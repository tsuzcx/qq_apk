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
import com.tencent.mm.sdk.platformtools.ab;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "closePanel", "Landroid/widget/ImageView;", "containerView", "Landroid/widget/LinearLayout;", "langStringArr", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLangStringArr", "()Ljava/util/ArrayList;", "setLangStringArr", "(Ljava/util/ArrayList;)V", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "langTypeArr", "getLangTypeArr", "setLangTypeArr", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"})
public final class a
  extends android.support.v7.app.e
{
  public static final a.a Akv;
  private ImageView Akp;
  ArrayList<Integer> Akq;
  private ArrayList<String> Akr;
  private MMBottomSheetBehavior<View> Aks;
  private boolean Akt;
  b Aku;
  private LinearLayout containerView;
  int iep;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(102557);
    Akv = new a.a((byte)0);
    AppMethodBeat.o(102557);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821488);
    AppMethodBeat.i(102556);
    this.iep = com.tencent.mm.modelvoiceaddr.g.ieO;
    this.Akq = new ArrayList();
    this.Akr = new ArrayList();
    gt();
    int i = com.tencent.mm.m.g.ZY().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.ieO);
    if (ab.eUK())
    {
      this.Akr.add(getContext().getString(2131760625));
      this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieO));
      if ((com.tencent.mm.modelvoiceaddr.g.ieP & i) != 0)
      {
        this.Akr.add(getContext().getString(2131760623));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieP));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.ieQ & i) != 0)
      {
        this.Akr.add(getContext().getString(2131760624));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieQ));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.ieR) != 0)
      {
        this.Akr.add(getContext().getString(2131760626));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieR));
        AppMethodBeat.o(102556);
      }
    }
    else if (ab.eUO().equals("en"))
    {
      this.Akr.add(getContext().getString(2131760624));
      this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieQ));
      this.Akr.add(getContext().getString(2131760625));
      this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieO));
      if ((i & com.tencent.mm.modelvoiceaddr.g.ieP) != 0)
      {
        this.Akr.add(getContext().getString(2131760623));
        this.Akq.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.ieP));
      }
    }
    AppMethodBeat.o(102556);
  }
  
  public final void eff()
  {
    AppMethodBeat.i(102554);
    Object localObject1 = this.containerView;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.Akq).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.fOc();
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
      ((TextView)((FrameLayout)localObject2).findViewById(2131301306)).setText((CharSequence)this.Akr.get(i));
      Object localObject3 = ((FrameLayout)localObject2).findViewById(2131301305);
      k.g(localObject3, "item.findViewById<View>(…language_choice_selected)");
      if (k == this.iep) {}
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
      this.Akp = ((ImageView)paramBundle.findViewById(2131298375));
      this.containerView = ((LinearLayout)paramBundle.findViewById(2131301303));
    }
    paramBundle = this.Akp;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    paramBundle = this.targetView;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.findViewById(2131303747);; paramBundle = null)
    {
      this.Aks = MMBottomSheetBehavior.w(paramBundle);
      paramBundle = this.Aks;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new d(this));
      }
      eff();
      AppMethodBeat.o(102553);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102555);
    super.show();
    MMBottomSheetBehavior localMMBottomSheetBehavior = this.Aks;
    if (localMMBottomSheetBehavior != null)
    {
      localMMBottomSheetBehavior.cC();
      AppMethodBeat.o(102555);
      return;
    }
    AppMethodBeat.o(102555);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static abstract interface b
  {
    public abstract void RI(int paramInt);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102549);
      this.Akw.dismiss();
      AppMethodBeat.o(102549);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class d
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102550);
      k.h(paramView, "bottomSheet");
      paramView = this.Akw;
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
        if (a.a(this.Akw))
        {
          this.Akw.dismiss();
          AppMethodBeat.o(102551);
          return;
        }
        paramView = a.b(this.Akw);
        if (paramView != null)
        {
          paramView.cC();
          AppMethodBeat.o(102551);
          return;
        }
      }
      AppMethodBeat.o(102551);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(int paramInt, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102552);
      jdField_this.iep = this.coP;
      jdField_this.eff();
      paramView = a.c(jdField_this);
      if (paramView != null)
      {
        paramView.RI(jdField_this.iep);
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