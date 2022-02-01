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
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "closePanel", "Landroid/widget/ImageView;", "containerView", "Landroid/widget/LinearLayout;", "langStringArr", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLangStringArr", "()Ljava/util/ArrayList;", "setLangStringArr", "(Ljava/util/ArrayList;)V", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "langTypeArr", "getLangTypeArr", "setLangTypeArr", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"})
public final class a
  extends android.support.v7.app.e
{
  public static final a yWG;
  private LinearLayout containerView;
  int hDN;
  private View targetView;
  private ImageView yWA;
  ArrayList<Integer> yWB;
  private ArrayList<String> yWC;
  private MMBottomSheetBehavior<View> yWD;
  private boolean yWE;
  b yWF;
  
  static
  {
    AppMethodBeat.i(102557);
    yWG = new a((byte)0);
    AppMethodBeat.o(102557);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821488);
    AppMethodBeat.i(102556);
    this.hDN = com.tencent.mm.modelvoiceaddr.g.hEm;
    this.yWB = new ArrayList();
    this.yWC = new ArrayList();
    gl();
    int i = com.tencent.mm.m.g.Zd().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.hEm);
    if (ac.eFq())
    {
      this.yWC.add(getContext().getString(2131760625));
      this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEm));
      if ((com.tencent.mm.modelvoiceaddr.g.hEn & i) != 0)
      {
        this.yWC.add(getContext().getString(2131760623));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEn));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.hEo & i) != 0)
      {
        this.yWC.add(getContext().getString(2131760624));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEo));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.hEp) != 0)
      {
        this.yWC.add(getContext().getString(2131760626));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEp));
        AppMethodBeat.o(102556);
      }
    }
    else if (ac.eFu().equals("en"))
    {
      this.yWC.add(getContext().getString(2131760624));
      this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEo));
      this.yWC.add(getContext().getString(2131760625));
      this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEm));
      if ((i & com.tencent.mm.modelvoiceaddr.g.hEn) != 0)
      {
        this.yWC.add(getContext().getString(2131760623));
        this.yWB.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.hEn));
      }
    }
    AppMethodBeat.o(102556);
  }
  
  public final void dQG()
  {
    AppMethodBeat.i(102554);
    Object localObject1 = this.containerView;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.yWB).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.fvx();
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
      ((TextView)((FrameLayout)localObject2).findViewById(2131301306)).setText((CharSequence)this.yWC.get(i));
      Object localObject3 = ((FrameLayout)localObject2).findViewById(2131301305);
      k.g(localObject3, "item.findViewById<View>(…language_choice_selected)");
      if (k == this.hDN) {}
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
      this.yWA = ((ImageView)paramBundle.findViewById(2131298375));
      this.containerView = ((LinearLayout)paramBundle.findViewById(2131301303));
    }
    paramBundle = this.yWA;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    paramBundle = this.targetView;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.findViewById(2131303747);; paramBundle = null)
    {
      this.yWD = MMBottomSheetBehavior.w(paramBundle);
      paramBundle = this.yWD;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new d(this));
      }
      dQG();
      AppMethodBeat.o(102553);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102555);
    super.show();
    MMBottomSheetBehavior localMMBottomSheetBehavior = this.yWD;
    if (localMMBottomSheetBehavior != null)
    {
      localMMBottomSheetBehavior.cv();
      AppMethodBeat.o(102555);
      return;
    }
    AppMethodBeat.o(102555);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$Companion;", "", "()V", "MODE_ONLY_PANEL_CLOSE_PANEL_OFFSET", "", "TAG", "", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static abstract interface b
  {
    public abstract void PC(int paramInt);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102549);
      this.yWH.dismiss();
      AppMethodBeat.o(102549);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class d
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102550);
      k.h(paramView, "bottomSheet");
      paramView = this.yWH;
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
      k.h(paramView, "bottomSheet");
      if (2 == paramInt)
      {
        if (a.a(this.yWH))
        {
          this.yWH.dismiss();
          AppMethodBeat.o(102551);
          return;
        }
        paramView = a.b(this.yWH);
        if (paramView != null)
        {
          paramView.cv();
          AppMethodBeat.o(102551);
          return;
        }
      }
      AppMethodBeat.o(102551);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(int paramInt, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102552);
      jdField_this.hDN = this.crJ;
      jdField_this.dQG();
      paramView = a.c(jdField_this);
      if (paramView != null)
      {
        paramView.PC(jdField_this.hDN);
        AppMethodBeat.o(102552);
        return;
      }
      AppMethodBeat.o(102552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a
 * JD-Core Version:    0.7.0.1
 */