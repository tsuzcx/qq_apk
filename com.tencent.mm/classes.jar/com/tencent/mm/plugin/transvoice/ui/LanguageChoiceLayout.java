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
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.transvoice.a.d;
import com.tencent.mm.plugin.transvoice.a.e;
import com.tencent.mm.plugin.transvoice.a.f;
import com.tencent.mm.plugin.transvoice.ui.a.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.List;

public class LanguageChoiceLayout
  extends RelativeLayout
{
  private RecyclerView NhG;
  public com.tencent.mm.plugin.transvoice.ui.a.a NhH;
  private a NhI;
  private Button kEt;
  private View kFU;
  private Button kGN;
  public ViewGroup kGW;
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(185271);
    this.kGN = null;
    this.kEt = null;
    this.kFU = null;
    this.kGW = null;
    this.NhG = null;
    this.NhH = null;
    this.NhI = null;
    init();
    AppMethodBeat.o(185271);
  }
  
  public LanguageChoiceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185272);
    this.kGN = null;
    this.kEt = null;
    this.kFU = null;
    this.kGW = null;
    this.NhG = null;
    this.NhH = null;
    this.NhI = null;
    init();
    AppMethodBeat.o(185272);
  }
  
  private void gsy()
  {
    AppMethodBeat.i(185274);
    ArrayList localArrayList = new ArrayList();
    int i = h.axc().getInt("VoiceInputLanguageSupportType", g.mlT);
    if (LocaleUtil.isChineseAppLang())
    {
      localArrayList.add(new a.a(getContext().getString(a.f.NgO), g.mlT));
      if ((g.mlU & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(a.f.NgM), g.mlU));
      }
      if ((g.mlV & i) != 0) {
        localArrayList.add(new a.a(getContext().getString(a.f.NgN), g.mlV));
      }
      if ((i & g.mlW) != 0) {
        localArrayList.add(new a.a(getContext().getString(a.f.NgP), g.mlW));
      }
    }
    for (;;)
    {
      this.NhH.ig(localArrayList);
      this.NhH.alc.notifyChanged();
      AppMethodBeat.o(185274);
      return;
      if (LocaleUtil.getApplicationLanguage().equals("en"))
      {
        localArrayList.add(new a.a(getContext().getString(a.f.NgN), g.mlV));
        localArrayList.add(new a.a(getContext().getString(a.f.NgO), g.mlT));
        if ((i & g.mlU) != 0) {
          localArrayList.add(new a.a(getContext().getString(a.f.NgM), g.mlU));
        }
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(185273);
    View.inflate(getContext(), a.e.NgK, this);
    this.kGW = ((ViewGroup)findViewById(a.d.Ngw));
    this.kGN = ((Button)findViewById(a.d.Ngv));
    this.kEt = ((Button)findViewById(a.d.Ngz));
    this.kFU = findViewById(a.d.Ngu);
    this.NhG = ((RecyclerView)findViewById(a.d.Ngy));
    this.NhH = new com.tencent.mm.plugin.transvoice.ui.a.a();
    RecyclerView localRecyclerView = this.NhG;
    getContext();
    localRecyclerView.setLayoutManager(new LinearLayoutManager());
    this.NhG.setAdapter(this.NhH);
    gsy();
    this.kGW.setTranslationY(ax.au(getContext()).y);
    this.kFU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185265);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LanguageChoiceLayout.this.gsz();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185265);
      }
    });
    this.kGN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185266);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LanguageChoiceLayout.this.gsz();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185266);
      }
    });
    this.kEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(185267);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (LanguageChoiceLayout.a(LanguageChoiceLayout.this) != null) {
          LanguageChoiceLayout.a(LanguageChoiceLayout.this).ajX(LanguageChoiceLayout.b(LanguageChoiceLayout.this).NjH);
        }
        LanguageChoiceLayout.this.gsz();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(185267);
      }
    });
    AppMethodBeat.o(185273);
  }
  
  public final void gsz()
  {
    AppMethodBeat.i(185275);
    this.kGW.animate().translationY(ax.au(getContext()).y).setDuration(200L).setListener(new AnimatorListenerAdapter()
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
    this.NhI = parama;
  }
  
  public void setSelectedLang(int paramInt)
  {
    AppMethodBeat.i(185276);
    if (this.NhH != null)
    {
      this.NhH.NjH = paramInt;
      this.NhH.alc.notifyChanged();
    }
    AppMethodBeat.o(185276);
  }
  
  public static abstract interface a
  {
    public abstract void ajX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.LanguageChoiceLayout
 * JD-Core Version:    0.7.0.1
 */