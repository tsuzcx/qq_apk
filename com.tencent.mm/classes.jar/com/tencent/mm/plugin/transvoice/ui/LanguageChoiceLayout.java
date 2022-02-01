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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ap;
import java.util.ArrayList;
import java.util.List;

public class LanguageChoiceLayout
  extends RelativeLayout
{
  private RecyclerView Akx;
  public a Aky;
  private a Akz;
  private Button gAJ;
  private Button gCY;
  private View gCi;
  public ViewGroup gDh;
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(185271);
    this.gCY = null;
    this.gAJ = null;
    this.gCi = null;
    this.gDh = null;
    this.Akx = null;
    this.Aky = null;
    this.Akz = null;
    init();
    AppMethodBeat.o(185271);
  }
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185272);
    this.gCY = null;
    this.gAJ = null;
    this.gCi = null;
    this.gDh = null;
    this.Akx = null;
    this.Aky = null;
    this.Akz = null;
    init();
    AppMethodBeat.o(185272);
  }
  
  private void efg()
  {
    AppMethodBeat.i(185274);
    ArrayList localArrayList = new ArrayList();
    int i = com.tencent.mm.m.g.ZY().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.ieO);
    if (ab.eUK())
    {
      localArrayList.add(new a.a(getContext().getString(2131760625), com.tencent.mm.modelvoiceaddr.g.ieO));
      if ((com.tencent.mm.modelvoiceaddr.g.ieP & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760623), com.tencent.mm.modelvoiceaddr.g.ieP));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.ieQ & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760624), com.tencent.mm.modelvoiceaddr.g.ieQ));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.ieR) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760626), com.tencent.mm.modelvoiceaddr.g.ieR));
      }
    }
    for (;;)
    {
      this.Aky.gh(localArrayList);
      this.Aky.arg.notifyChanged();
      AppMethodBeat.o(185274);
      return;
      if (ab.eUO().equals("en"))
      {
        localArrayList.add(new a.a(getContext().getString(2131760624), com.tencent.mm.modelvoiceaddr.g.ieQ));
        localArrayList.add(new a.a(getContext().getString(2131760625), com.tencent.mm.modelvoiceaddr.g.ieO));
        if ((i & com.tencent.mm.modelvoiceaddr.g.ieP) != 0) {
          localArrayList.add(new a.a(getContext().getString(2131760623), com.tencent.mm.modelvoiceaddr.g.ieP));
        }
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(185273);
    View.inflate(getContext(), 2131495022, this);
    this.gDh = ((ViewGroup)findViewById(2131302825));
    this.gCY = ((Button)findViewById(2131302824));
    this.gAJ = ((Button)findViewById(2131302828));
    this.gCi = findViewById(2131302823);
    this.Akx = ((RecyclerView)findViewById(2131302827));
    this.Aky = new a();
    RecyclerView localRecyclerView = this.Akx;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.Akx.setAdapter(this.Aky);
    efg();
    this.gDh.setTranslationY(ap.cl(getContext()).y);
    this.gCi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185265);
        LanguageChoiceLayout.this.efh();
        AppMethodBeat.o(185265);
      }
    });
    this.gCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185266);
        LanguageChoiceLayout.this.efh();
        AppMethodBeat.o(185266);
      }
    });
    this.gAJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185267);
        if (LanguageChoiceLayout.a(LanguageChoiceLayout.this) != null) {
          LanguageChoiceLayout.a(LanguageChoiceLayout.this).RJ(LanguageChoiceLayout.b(LanguageChoiceLayout.this).Amy);
        }
        LanguageChoiceLayout.this.efh();
        AppMethodBeat.o(185267);
      }
    });
    AppMethodBeat.o(185273);
  }
  
  public final void efh()
  {
    AppMethodBeat.i(185275);
    this.gDh.animate().translationY(ap.cl(getContext()).y).setDuration(200L).setListener(new AnimatorListenerAdapter()
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
    this.Akz = parama;
  }
  
  public void setSelectedLang(int paramInt)
  {
    AppMethodBeat.i(185276);
    if (this.Aky != null)
    {
      this.Aky.Amy = paramInt;
      this.Aky.arg.notifyChanged();
    }
    AppMethodBeat.o(185276);
  }
  
  public static abstract interface a
  {
    public abstract void RJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout
 * JD-Core Version:    0.7.0.1
 */