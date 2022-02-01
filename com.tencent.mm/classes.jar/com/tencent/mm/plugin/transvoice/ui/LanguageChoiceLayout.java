package com.tencent.mm.plugin.transvoice.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.transvoice.a.d;
import com.tencent.mm.plugin.transvoice.a.e;
import com.tencent.mm.plugin.transvoice.a.f;
import com.tencent.mm.plugin.transvoice.ui.a.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.List;

public class LanguageChoiceLayout
  extends RelativeLayout
{
  private RecyclerView TUE;
  public com.tencent.mm.plugin.transvoice.ui.a.a TUF;
  private a TUG;
  private Button nhC;
  private View niW;
  private Button njI;
  public ViewGroup njQ;
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(185271);
    this.njI = null;
    this.nhC = null;
    this.niW = null;
    this.njQ = null;
    this.TUE = null;
    this.TUF = null;
    this.TUG = null;
    init();
    AppMethodBeat.o(185271);
  }
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185272);
    this.njI = null;
    this.nhC = null;
    this.niW = null;
    this.njQ = null;
    this.TUE = null;
    this.TUF = null;
    this.TUG = null;
    init();
    AppMethodBeat.o(185272);
  }
  
  private void hPG()
  {
    AppMethodBeat.i(185274);
    ArrayList localArrayList = new ArrayList();
    int i = i.aRC().getInt("VoiceInputLanguageSupportType", g.pfF);
    if (LocaleUtil.isChineseAppLang())
    {
      localArrayList.add(new a.a(getContext().getString(a.f.TTM), g.pfF));
      if ((g.pfG & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(a.f.TTK), g.pfG));
      }
      if ((g.pfH & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(a.f.TTL), g.pfH));
      }
      if ((i & g.pfI) != 0) {
        localArrayList.add(new a.a(getContext().getString(a.f.TTN), g.pfI));
      }
    }
    for (;;)
    {
      this.TUF.lG(localArrayList);
      this.TUF.bZE.notifyChanged();
      AppMethodBeat.o(185274);
      return;
      if (LocaleUtil.getApplicationLanguage().equals("en"))
      {
        localArrayList.add(new a.a(getContext().getString(a.f.TTL), g.pfH));
        localArrayList.add(new a.a(getContext().getString(a.f.TTM), g.pfF));
        if ((i & g.pfG) != 0) {
          localArrayList.add(new a.a(getContext().getString(a.f.TTK), g.pfG));
        }
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(185273);
    View.inflate(getContext(), a.e.TTI, this);
    this.njQ = ((ViewGroup)findViewById(a.d.TTu));
    this.njI = ((Button)findViewById(a.d.TTt));
    this.nhC = ((Button)findViewById(a.d.TTx));
    this.niW = findViewById(a.d.TTs);
    this.TUE = ((RecyclerView)findViewById(a.d.TTw));
    this.TUF = new com.tencent.mm.plugin.transvoice.ui.a.a();
    RecyclerView localRecyclerView = this.TUE;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.TUE.setAdapter(this.TUF);
    hPG();
    this.njQ.setTranslationY(bf.bf(getContext()).y);
    this.niW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185265);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        LanguageChoiceLayout.this.hPH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185265);
      }
    });
    this.njI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185266);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        LanguageChoiceLayout.this.hPH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185266);
      }
    });
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185267);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (LanguageChoiceLayout.a(LanguageChoiceLayout.this) != null) {
          LanguageChoiceLayout.a(LanguageChoiceLayout.this).apq(LanguageChoiceLayout.b(LanguageChoiceLayout.this).TWC);
        }
        LanguageChoiceLayout.this.hPH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185267);
      }
    });
    AppMethodBeat.o(185273);
  }
  
  public final void hPH()
  {
    AppMethodBeat.i(185275);
    this.njQ.animate().translationY(bf.bf(getContext()).y).setDuration(200L).setListener(new AnimatorListenerAdapter()
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
    this.TUG = parama;
  }
  
  public void setSelectedLang(int paramInt)
  {
    AppMethodBeat.i(185276);
    if (this.TUF != null)
    {
      this.TUF.TWC = paramInt;
      this.TUF.bZE.notifyChanged();
    }
    AppMethodBeat.o(185276);
  }
  
  public static abstract interface a
  {
    public abstract void apq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout
 * JD-Core Version:    0.7.0.1
 */