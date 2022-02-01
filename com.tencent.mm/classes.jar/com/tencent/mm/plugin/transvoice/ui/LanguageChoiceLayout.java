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
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.transvoice.ui.a.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.List;

public class LanguageChoiceLayout
  extends RelativeLayout
{
  private RecyclerView Gun;
  public com.tencent.mm.plugin.transvoice.ui.a.a Guo;
  private a Gup;
  private Button hPX;
  private View hRx;
  private Button hSq;
  public ViewGroup hSz;
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(185271);
    this.hSq = null;
    this.hPX = null;
    this.hRx = null;
    this.hSz = null;
    this.Gun = null;
    this.Guo = null;
    this.Gup = null;
    init();
    AppMethodBeat.o(185271);
  }
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185272);
    this.hSq = null;
    this.hPX = null;
    this.hRx = null;
    this.hSz = null;
    this.Gun = null;
    this.Guo = null;
    this.Gup = null;
    init();
    AppMethodBeat.o(185272);
  }
  
  private void fAx()
  {
    AppMethodBeat.i(185274);
    ArrayList localArrayList = new ArrayList();
    int i = h.aqJ().getInt("VoiceInputLanguageSupportType", g.jwq);
    if (LocaleUtil.isChineseAppLang())
    {
      localArrayList.add(new a.a(getContext().getString(2131762137), g.jwq));
      if ((g.jwr & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131762135), g.jwr));
      }
      if ((g.jws & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131762136), g.jws));
      }
      if ((i & g.jwt) != 0) {
        localArrayList.add(new a.a(getContext().getString(2131762138), g.jwt));
      }
    }
    for (;;)
    {
      this.Guo.hy(localArrayList);
      this.Guo.atj.notifyChanged();
      AppMethodBeat.o(185274);
      return;
      if (LocaleUtil.getApplicationLanguage().equals("en"))
      {
        localArrayList.add(new a.a(getContext().getString(2131762136), g.jws));
        localArrayList.add(new a.a(getContext().getString(2131762137), g.jwq));
        if ((i & g.jwr) != 0) {
          localArrayList.add(new a.a(getContext().getString(2131762135), g.jwr));
        }
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(185273);
    View.inflate(getContext(), 2131495854, this);
    this.hSz = ((ViewGroup)findViewById(2131305395));
    this.hSq = ((Button)findViewById(2131305394));
    this.hPX = ((Button)findViewById(2131305398));
    this.hRx = findViewById(2131305393);
    this.Gun = ((RecyclerView)findViewById(2131305397));
    this.Guo = new com.tencent.mm.plugin.transvoice.ui.a.a();
    RecyclerView localRecyclerView = this.Gun;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.Gun.setAdapter(this.Guo);
    fAx();
    this.hSz.setTranslationY(au.az(getContext()).y);
    this.hRx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185265);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LanguageChoiceLayout.this.fAy();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185265);
      }
    });
    this.hSq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185266);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LanguageChoiceLayout.this.fAy();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185266);
      }
    });
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185267);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (LanguageChoiceLayout.a(LanguageChoiceLayout.this) != null) {
          LanguageChoiceLayout.a(LanguageChoiceLayout.this).acq(LanguageChoiceLayout.b(LanguageChoiceLayout.this).Gwo);
        }
        LanguageChoiceLayout.this.fAy();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185267);
      }
    });
    AppMethodBeat.o(185273);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(185275);
    this.hSz.animate().translationY(au.az(getContext()).y).setDuration(200L).setListener(new AnimatorListenerAdapter()
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
    this.Gup = parama;
  }
  
  public void setSelectedLang(int paramInt)
  {
    AppMethodBeat.i(185276);
    if (this.Guo != null)
    {
      this.Guo.Gwo = paramInt;
      this.Guo.atj.notifyChanged();
    }
    AppMethodBeat.o(185276);
  }
  
  public static abstract interface a
  {
    public abstract void acq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout
 * JD-Core Version:    0.7.0.1
 */