package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.MMBottomSheetBehavior;
import android.support.design.widget.MMBottomSheetBehavior.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.transvoice.a.f;
import com.tencent.mm.plugin.transvoice.a.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "closePanel", "Landroid/widget/ImageView;", "containerView", "Landroid/widget/LinearLayout;", "langStringArr", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLangStringArr", "()Ljava/util/ArrayList;", "setLangStringArr", "(Ljava/util/ArrayList;)V", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "langTypeArr", "getLangTypeArr", "setLangTypeArr", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"})
public final class a
  extends e
{
  public static final a NhE;
  private ArrayList<String> NhA;
  private MMBottomSheetBehavior<View> NhB;
  private boolean NhC;
  b NhD;
  private ImageView Nhy;
  ArrayList<Integer> Nhz;
  private LinearLayout containerView;
  private View kJL;
  int mlv;
  
  static
  {
    AppMethodBeat.i(102557);
    NhE = new a((byte)0);
    AppMethodBeat.o(102557);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, a.g.TransDialog);
    AppMethodBeat.i(102556);
    this.mlv = g.mlT;
    this.Nhz = new ArrayList();
    this.NhA = new ArrayList();
    bb();
    int i = h.axc().getInt("VoiceInputLanguageSupportType", g.mlT);
    if (LocaleUtil.isChineseAppLang())
    {
      this.NhA.add(getContext().getString(a.f.NgO));
      this.Nhz.add(Integer.valueOf(g.mlT));
      if ((g.mlU & i) != 0)
      {
        this.NhA.add(getContext().getString(a.f.NgM));
        this.Nhz.add(Integer.valueOf(g.mlU));
      }
      if ((g.mlV & i) != 0)
      {
        this.NhA.add(getContext().getString(a.f.NgN));
        this.Nhz.add(Integer.valueOf(g.mlV));
      }
      if ((i & g.mlW) != 0)
      {
        this.NhA.add(getContext().getString(a.f.NgP));
        this.Nhz.add(Integer.valueOf(g.mlW));
        AppMethodBeat.o(102556);
      }
    }
    else if (LocaleUtil.getApplicationLanguage().equals("en"))
    {
      this.NhA.add(getContext().getString(a.f.NgN));
      this.Nhz.add(Integer.valueOf(g.mlV));
      this.NhA.add(getContext().getString(a.f.NgO));
      this.Nhz.add(Integer.valueOf(g.mlT));
      if ((i & g.mlU) != 0)
      {
        this.NhA.add(getContext().getString(a.f.NgM));
        this.Nhz.add(Integer.valueOf(g.mlU));
      }
    }
    AppMethodBeat.o(102556);
  }
  
  public final void gsx()
  {
    AppMethodBeat.i(102554);
    Object localObject1 = this.containerView;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.Nhz).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      int k = ((Number)localObject2).intValue();
      localObject2 = getLayoutInflater().inflate(com.tencent.mm.plugin.transvoice.a.e.NgI, null);
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(102554);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout)localObject2;
      ((TextView)((FrameLayout)localObject2).findViewById(com.tencent.mm.plugin.transvoice.a.d.Ngt)).setText((CharSequence)this.NhA.get(i));
      Object localObject3 = ((FrameLayout)localObject2).findViewById(com.tencent.mm.plugin.transvoice.a.d.Ngs);
      p.j(localObject3, "item.findViewById<View>(…language_choice_selected)");
      if (k == this.mlv) {}
      for (i = 0;; i = 4)
      {
        ((View)localObject3).setVisibility(i);
        ((FrameLayout)localObject2).setOnClickListener((View.OnClickListener)new e(k, this));
        localObject3 = new FrameLayout.LayoutParams(-1, -2);
        LinearLayout localLinearLayout = this.containerView;
        if (localLinearLayout == null) {
          break label245;
        }
        localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i = j;
        break;
      }
      label245:
      i = j;
    }
    AppMethodBeat.o(102554);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102553);
    this.kJL = LayoutInflater.from(getContext()).inflate(com.tencent.mm.plugin.transvoice.a.e.NgH, null, false);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    View localView = this.kJL;
    if (localView == null) {
      p.iCn();
    }
    setContentView(localView, localLayoutParams);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(67108864);
      paramBundle.setLayout(-1, -1);
      paramBundle.setSoftInputMode(34);
      paramBundle.setDimAmount(0.5F);
      paramBundle.setWindowAnimations(a.g.BottomToTopSlowAnimation);
    }
    paramBundle = this.kJL;
    if (paramBundle != null)
    {
      this.Nhy = ((ImageView)paramBundle.findViewById(com.tencent.mm.plugin.transvoice.a.d.Ngo));
      this.containerView = ((LinearLayout)paramBundle.findViewById(com.tencent.mm.plugin.transvoice.a.d.Ngr));
    }
    paramBundle = this.Nhy;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    paramBundle = this.kJL;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.findViewById(com.tencent.mm.plugin.transvoice.a.d.NgC);; paramBundle = null)
    {
      this.NhB = MMBottomSheetBehavior.c(paramBundle);
      paramBundle = this.NhB;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new d(this));
      }
      gsx();
      AppMethodBeat.o(102553);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102555);
    super.show();
    MMBottomSheetBehavior localMMBottomSheetBehavior = this.NhB;
    if (localMMBottomSheetBehavior != null)
    {
      localMMBottomSheetBehavior.T();
      AppMethodBeat.o(102555);
      return;
    }
    AppMethodBeat.o(102555);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$Companion;", "", "()V", "MODE_ONLY_PANEL_CLOSE_PANEL_OFFSET", "", "TAG", "", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static abstract interface b
  {
    public abstract void ajW(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102549);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.NhF.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102549);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class d
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102550);
      p.k(paramView, "bottomSheet");
      paramView = this.NhF;
      if (0.7F >= paramFloat) {}
      for (boolean bool = true;; bool = false)
      {
        a.a(paramView, bool);
        AppMethodBeat.o(102550);
        return;
      }
    }
    
    public final void e(View paramView, int paramInt)
    {
      AppMethodBeat.i(102551);
      p.k(paramView, "bottomSheet");
      if (2 == paramInt)
      {
        if (a.a(this.NhF))
        {
          this.NhF.dismiss();
          AppMethodBeat.o(102551);
          return;
        }
        paramView = a.b(this.NhF);
        if (paramView != null)
        {
          paramView.T();
          AppMethodBeat.o(102551);
          return;
        }
      }
      AppMethodBeat.o(102551);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(int paramInt, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102552);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      jdField_this.mlv = this.cPi;
      jdField_this.gsx();
      paramView = a.c(jdField_this);
      if (paramView != null) {
        paramView.ajW(jdField_this.mlv);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a
 * JD-Core Version:    0.7.0.1
 */