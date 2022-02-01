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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;

public class LanguageChoiceLayout
  extends RelativeLayout
{
  private RecyclerView BCj;
  public com.tencent.mm.plugin.transvoice.ui.a.a BCk;
  private a BCl;
  private Button gUt;
  private View gVS;
  private Button gWI;
  public ViewGroup gWR;
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(185271);
    this.gWI = null;
    this.gUt = null;
    this.gVS = null;
    this.gWR = null;
    this.BCj = null;
    this.BCk = null;
    this.BCl = null;
    init();
    AppMethodBeat.o(185271);
  }
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185272);
    this.gWI = null;
    this.gUt = null;
    this.gVS = null;
    this.gWR = null;
    this.BCj = null;
    this.BCk = null;
    this.BCl = null;
    init();
    AppMethodBeat.o(185272);
  }
  
  private void erx()
  {
    AppMethodBeat.i(185274);
    ArrayList localArrayList = new ArrayList();
    int i = com.tencent.mm.n.g.acA().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.iyi);
    if (ac.fko())
    {
      localArrayList.add(new a.a(getContext().getString(2131760625), com.tencent.mm.modelvoiceaddr.g.iyi));
      if ((com.tencent.mm.modelvoiceaddr.g.iyj & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760623), com.tencent.mm.modelvoiceaddr.g.iyj));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.iyk & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760624), com.tencent.mm.modelvoiceaddr.g.iyk));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.iyl) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131760626), com.tencent.mm.modelvoiceaddr.g.iyl));
      }
    }
    for (;;)
    {
      this.BCk.gs(localArrayList);
      this.BCk.asY.notifyChanged();
      AppMethodBeat.o(185274);
      return;
      if (ac.fks().equals("en"))
      {
        localArrayList.add(new a.a(getContext().getString(2131760624), com.tencent.mm.modelvoiceaddr.g.iyk));
        localArrayList.add(new a.a(getContext().getString(2131760625), com.tencent.mm.modelvoiceaddr.g.iyi));
        if ((i & com.tencent.mm.modelvoiceaddr.g.iyj) != 0) {
          localArrayList.add(new a.a(getContext().getString(2131760623), com.tencent.mm.modelvoiceaddr.g.iyj));
        }
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(185273);
    View.inflate(getContext(), 2131495022, this);
    this.gWR = ((ViewGroup)findViewById(2131302825));
    this.gWI = ((Button)findViewById(2131302824));
    this.gUt = ((Button)findViewById(2131302828));
    this.gVS = findViewById(2131302823);
    this.BCj = ((RecyclerView)findViewById(2131302827));
    this.BCk = new com.tencent.mm.plugin.transvoice.ui.a.a();
    RecyclerView localRecyclerView = this.BCj;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.BCj.setAdapter(this.BCk);
    erx();
    this.gWR.setTranslationY(ar.ci(getContext()).y);
    this.gVS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185265);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LanguageChoiceLayout.this.ery();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185265);
      }
    });
    this.gWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185266);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LanguageChoiceLayout.this.ery();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185266);
      }
    });
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185267);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (LanguageChoiceLayout.a(LanguageChoiceLayout.this) != null) {
          LanguageChoiceLayout.a(LanguageChoiceLayout.this).Tt(LanguageChoiceLayout.b(LanguageChoiceLayout.this).BEk);
        }
        LanguageChoiceLayout.this.ery();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185267);
      }
    });
    AppMethodBeat.o(185273);
  }
  
  public final void ery()
  {
    AppMethodBeat.i(185275);
    this.gWR.animate().translationY(ar.ci(getContext()).y).setDuration(200L).setListener(new AnimatorListenerAdapter()
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
    this.BCl = parama;
  }
  
  public void setSelectedLang(int paramInt)
  {
    AppMethodBeat.i(185276);
    if (this.BCk != null)
    {
      this.BCk.BEk = paramInt;
      this.BCk.asY.notifyChanged();
    }
    AppMethodBeat.o(185276);
  }
  
  public static abstract interface a
  {
    public abstract void Tt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout
 * JD-Core Version:    0.7.0.1
 */