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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "closePanel", "Landroid/widget/ImageView;", "containerView", "Landroid/widget/LinearLayout;", "langStringArr", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLangStringArr", "()Ljava/util/ArrayList;", "setLangStringArr", "(Ljava/util/ArrayList;)V", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "langTypeArr", "getLangTypeArr", "setLangTypeArr", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"})
public final class a
  extends android.support.v7.app.e
{
  public static final a.a BTF;
  ArrayList<Integer> BTA;
  private ArrayList<String> BTB;
  private MMBottomSheetBehavior<View> BTC;
  private boolean BTD;
  b BTE;
  private ImageView BTz;
  private LinearLayout containerView;
  int iAD;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(102557);
    BTF = new a.a((byte)0);
    AppMethodBeat.o(102557);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821488);
    AppMethodBeat.i(102556);
    this.iAD = com.tencent.mm.modelvoiceaddr.g.iBb;
    this.BTA = new ArrayList();
    this.BTB = new ArrayList();
    gK();
    int i = com.tencent.mm.n.g.acL().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.iBb);
    if (ad.foi())
    {
      this.BTB.add(getContext().getString(2131760625));
      this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBb));
      if ((com.tencent.mm.modelvoiceaddr.g.iBc & i) != 0)
      {
        this.BTB.add(getContext().getString(2131760623));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBc));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.iBd & i) != 0)
      {
        this.BTB.add(getContext().getString(2131760624));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBd));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.iBe) != 0)
      {
        this.BTB.add(getContext().getString(2131760626));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBe));
        AppMethodBeat.o(102556);
      }
    }
    else if (ad.fom().equals("en"))
    {
      this.BTB.add(getContext().getString(2131760624));
      this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBd));
      this.BTB.add(getContext().getString(2131760625));
      this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBb));
      if ((i & com.tencent.mm.modelvoiceaddr.g.iBc) != 0)
      {
        this.BTB.add(getContext().getString(2131760623));
        this.BTA.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iBc));
      }
    }
    AppMethodBeat.o(102556);
  }
  
  public final void evd()
  {
    AppMethodBeat.i(102554);
    Object localObject1 = this.containerView;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.BTA).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      int k = ((Number)localObject2).intValue();
      localObject2 = getLayoutInflater().inflate(2131494543, null);
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(102554);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout)localObject2;
      ((TextView)((FrameLayout)localObject2).findViewById(2131301306)).setText((CharSequence)this.BTB.get(i));
      Object localObject3 = ((FrameLayout)localObject2).findViewById(2131301305);
      p.g(localObject3, "item.findViewById<View>(…language_choice_selected)");
      if (k == this.iAD) {}
      for (i = 0;; i = 4)
      {
        ((View)localObject3).setVisibility(i);
        ((FrameLayout)localObject2).setOnClickListener((View.OnClickListener)new e(k, this));
        localObject3 = new FrameLayout.LayoutParams(-1, -2);
        LinearLayout localLinearLayout = this.containerView;
        if (localLinearLayout == null) {
          break label243;
        }
        localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        i = j;
        break;
      }
      label243:
      i = j;
    }
    AppMethodBeat.o(102554);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102553);
    this.targetView = LayoutInflater.from(getContext()).inflate(2131494542, null, false);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    setContentView(this.targetView, localLayoutParams);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.addFlags(67108864);
      paramBundle.setLayout(-1, -1);
      paramBundle.setSoftInputMode(34);
      paramBundle.setDimAmount(0.5F);
      paramBundle.setWindowAnimations(2131820790);
    }
    paramBundle = this.targetView;
    if (paramBundle != null)
    {
      this.BTz = ((ImageView)paramBundle.findViewById(2131298375));
      this.containerView = ((LinearLayout)paramBundle.findViewById(2131301303));
    }
    paramBundle = this.BTz;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    paramBundle = this.targetView;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.findViewById(2131303747);; paramBundle = null)
    {
      this.BTC = MMBottomSheetBehavior.w(paramBundle);
      paramBundle = this.BTC;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new d(this));
      }
      evd();
      AppMethodBeat.o(102553);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102555);
    super.show();
    MMBottomSheetBehavior localMMBottomSheetBehavior = this.BTC;
    if (localMMBottomSheetBehavior != null)
    {
      localMMBottomSheetBehavior.cS();
      AppMethodBeat.o(102555);
      return;
    }
    AppMethodBeat.o(102555);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static abstract interface b
  {
    public abstract void TZ(int paramInt);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102549);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.BTG.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102549);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class d
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102550);
      p.h(paramView, "bottomSheet");
      paramView = this.BTG;
      if (0.7F >= paramFloat) {}
      for (boolean bool = true;; bool = false)
      {
        a.a(paramView, bool);
        AppMethodBeat.o(102550);
        return;
      }
    }
    
    public final void k(View paramView, int paramInt)
    {
      AppMethodBeat.i(102551);
      p.h(paramView, "bottomSheet");
      if (2 == paramInt)
      {
        if (a.a(this.BTG))
        {
          this.BTG.dismiss();
          AppMethodBeat.o(102551);
          return;
        }
        paramView = a.b(this.BTG);
        if (paramView != null)
        {
          paramView.cS();
          AppMethodBeat.o(102551);
          return;
        }
      }
      AppMethodBeat.o(102551);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(int paramInt, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102552);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      jdField_this.iAD = this.cAn;
      jdField_this.evd();
      paramView = a.c(jdField_this);
      if (paramView != null) {
        paramView.TZ(jdField_this.iAD);
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