package com.tencent.mm.plugin.transvoice.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.transvoice.ui.a.a;
import com.tencent.mm.plugin.transvoice.ui.a.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ap;
import java.util.ArrayList;
import java.util.List;

public class LanguageChoiceLayout
  extends RelativeLayout
{
  private Button hJg;
  private Button hJh;
  public ViewGroup yWI;
  private RecyclerView yWJ;
  public a yWK;
  private a yWL;
  private View yqI;
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(185271);
    this.hJg = null;
    this.hJh = null;
    this.yqI = null;
    this.yWI = null;
    this.yWJ = null;
    this.yWK = null;
    this.yWL = null;
    init();
    AppMethodBeat.o(185271);
  }
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185272);
    this.hJg = null;
    this.hJh = null;
    this.yqI = null;
    this.yWI = null;
    this.yWJ = null;
    this.yWK = null;
    this.yWL = null;
    init();
    AppMethodBeat.o(185272);
  }
  
  private void dQH()
  {
    AppMethodBeat.i(185274);
    ArrayList localArrayList = new ArrayList();
    int i = com.tencent.mm.m.g.Zd().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.hEm);
    if (ac.eFq())
    {
      localArrayList.add(new a.a(getContext().getString(2131760625), com.tencent.mm.modelvoiceaddr.g.hEm));
      if ((com.tencent.mm.modelvoiceaddr.g.hEn & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760623), com.tencent.mm.modelvoiceaddr.g.hEn));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.hEo & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760624), com.tencent.mm.modelvoiceaddr.g.hEo));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.hEp) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760626), com.tencent.mm.modelvoiceaddr.g.hEp));
      }
    }
    for (;;)
    {
      this.yWK.ga(localArrayList);
      this.yWK.aql.notifyChanged();
      AppMethodBeat.o(185274);
      return;
      if (ac.eFu().equals("en"))
      {
        localArrayList.add(new a.a(getContext().getString(2131760624), com.tencent.mm.modelvoiceaddr.g.hEo));
        localArrayList.add(new a.a(getContext().getString(2131760625), com.tencent.mm.modelvoiceaddr.g.hEm));
        if ((i & com.tencent.mm.modelvoiceaddr.g.hEn) != 0) {
          localArrayList.add(new a.a(getContext().getString(2131760623), com.tencent.mm.modelvoiceaddr.g.hEn));
        }
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(185273);
    View.inflate(getContext(), 2131495022, this);
    this.yWI = ((ViewGroup)findViewById(2131302825));
    this.hJg = ((Button)findViewById(2131302824));
    this.hJh = ((Button)findViewById(2131302828));
    this.yqI = findViewById(2131302823);
    this.yWJ = ((RecyclerView)findViewById(2131302827));
    this.yWK = new a();
    RecyclerView localRecyclerView = this.yWJ;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.yWJ.setAdapter(this.yWK);
    dQH();
    this.yWI.setTranslationY(ap.cf(getContext()).y);
    this.yqI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185265);
        LanguageChoiceLayout.this.dQI();
        AppMethodBeat.o(185265);
      }
    });
    this.hJg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185266);
        LanguageChoiceLayout.this.dQI();
        AppMethodBeat.o(185266);
      }
    });
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185267);
        if (LanguageChoiceLayout.a(LanguageChoiceLayout.this) != null) {
          LanguageChoiceLayout.a(LanguageChoiceLayout.this).PD(LanguageChoiceLayout.b(LanguageChoiceLayout.this).yYJ);
        }
        LanguageChoiceLayout.this.dQI();
        AppMethodBeat.o(185267);
      }
    });
    AppMethodBeat.o(185273);
  }
  
  public final void dQI()
  {
    AppMethodBeat.i(185275);
    this.yWI.animate().translationY(ap.cf(getContext()).y).setDuration(200L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(185270);
        LanguageChoiceLayout.this.setVisibility(8);
        AppMethodBeat.o(185270);
      }
    }).start();
    AppMethodBeat.o(185275);
  }
  
  public void setSelectLanguageListener(a parama)
  {
    this.yWL = parama;
  }
  
  public void setSelectedLang(int paramInt)
  {
    AppMethodBeat.i(185276);
    if (this.yWK != null)
    {
      this.yWK.yYJ = paramInt;
      this.yWK.aql.notifyChanged();
    }
    AppMethodBeat.o(185276);
  }
  
  public static abstract interface a
  {
    public abstract void PD(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout
 * JD-Core Version:    0.7.0.1
 */