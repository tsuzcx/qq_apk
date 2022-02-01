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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.transvoice.ui.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;

public class LanguageChoiceLayout
  extends RelativeLayout
{
  private RecyclerView BTH;
  public com.tencent.mm.plugin.transvoice.ui.a.a BTI;
  private a BTJ;
  private Button gXc;
  private View gYC;
  public ViewGroup gZE;
  private Button gZv;
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(185271);
    this.gZv = null;
    this.gXc = null;
    this.gYC = null;
    this.gZE = null;
    this.BTH = null;
    this.BTI = null;
    this.BTJ = null;
    init();
    AppMethodBeat.o(185271);
  }
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185272);
    this.gZv = null;
    this.gXc = null;
    this.gYC = null;
    this.gZE = null;
    this.BTH = null;
    this.BTI = null;
    this.BTJ = null;
    init();
    AppMethodBeat.o(185272);
  }
  
  private void eve()
  {
    AppMethodBeat.i(185274);
    ArrayList localArrayList = new ArrayList();
    int i = com.tencent.mm.n.g.acL().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.iBb);
    if (ad.foi())
    {
      localArrayList.add(new a.a(getContext().getString(2131760625), com.tencent.mm.modelvoiceaddr.g.iBb));
      if ((com.tencent.mm.modelvoiceaddr.g.iBc & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760623), com.tencent.mm.modelvoiceaddr.g.iBc));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.iBd & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760624), com.tencent.mm.modelvoiceaddr.g.iBd));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.iBe) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760626), com.tencent.mm.modelvoiceaddr.g.iBe));
      }
    }
    for (;;)
    {
      this.BTI.gB(localArrayList);
      this.BTI.asY.notifyChanged();
      AppMethodBeat.o(185274);
      return;
      if (ad.fom().equals("en"))
      {
        localArrayList.add(new a.a(getContext().getString(2131760624), com.tencent.mm.modelvoiceaddr.g.iBd));
        localArrayList.add(new a.a(getContext().getString(2131760625), com.tencent.mm.modelvoiceaddr.g.iBb));
        if ((i & com.tencent.mm.modelvoiceaddr.g.iBc) != 0) {
          localArrayList.add(new a.a(getContext().getString(2131760623), com.tencent.mm.modelvoiceaddr.g.iBc));
        }
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(185273);
    View.inflate(getContext(), 2131495022, this);
    this.gZE = ((ViewGroup)findViewById(2131302825));
    this.gZv = ((Button)findViewById(2131302824));
    this.gXc = ((Button)findViewById(2131302828));
    this.gYC = findViewById(2131302823);
    this.BTH = ((RecyclerView)findViewById(2131302827));
    this.BTI = new com.tencent.mm.plugin.transvoice.ui.a.a();
    RecyclerView localRecyclerView = this.BTH;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.BTH.setAdapter(this.BTI);
    eve();
    this.gZE.setTranslationY(ar.ck(getContext()).y);
    this.gYC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185265);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LanguageChoiceLayout.this.evf();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185265);
      }
    });
    this.gZv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185266);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LanguageChoiceLayout.this.evf();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185266);
      }
    });
    this.gXc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185267);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (LanguageChoiceLayout.a(LanguageChoiceLayout.this) != null) {
          LanguageChoiceLayout.a(LanguageChoiceLayout.this).Ua(LanguageChoiceLayout.b(LanguageChoiceLayout.this).BVI);
        }
        LanguageChoiceLayout.this.evf();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185267);
      }
    });
    AppMethodBeat.o(185273);
  }
  
  public final void evf()
  {
    AppMethodBeat.i(185275);
    this.gZE.animate().translationY(ar.ck(getContext()).y).setDuration(200L).setListener(new AnimatorListenerAdapter()
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
    this.BTJ = parama;
  }
  
  public void setSelectedLang(int paramInt)
  {
    AppMethodBeat.i(185276);
    if (this.BTI != null)
    {
      this.BTI.BVI = paramInt;
      this.BTI.asY.notifyChanged();
    }
    AppMethodBeat.o(185276);
  }
  
  public static abstract interface a
  {
    public abstract void Ua(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout
 * JD-Core Version:    0.7.0.1
 */