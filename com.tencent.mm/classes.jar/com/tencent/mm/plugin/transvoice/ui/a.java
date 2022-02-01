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
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "closePanel", "Landroid/widget/ImageView;", "containerView", "Landroid/widget/LinearLayout;", "langStringArr", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLangStringArr", "()Ljava/util/ArrayList;", "setLangStringArr", "(Ljava/util/ArrayList;)V", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "langTypeArr", "getLangTypeArr", "setLangTypeArr", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"})
public final class a
  extends android.support.v7.app.e
{
  public static final a.a BCh;
  private ImageView BCb;
  ArrayList<Integer> BCc;
  private ArrayList<String> BCd;
  private MMBottomSheetBehavior<View> BCe;
  private boolean BCf;
  b BCg;
  private LinearLayout containerView;
  int ixK;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(102557);
    BCh = new a.a((byte)0);
    AppMethodBeat.o(102557);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821488);
    AppMethodBeat.i(102556);
    this.ixK = com.tencent.mm.modelvoiceaddr.g.iyi;
    this.BCc = new ArrayList();
    this.BCd = new ArrayList();
    gK();
    int i = com.tencent.mm.n.g.acA().getInt("VoiceInputLanguageSupportType", com.tencent.mm.modelvoiceaddr.g.iyi);
    if (ac.fko())
    {
      this.BCd.add(getContext().getString(2131760625));
      this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyi));
      if ((com.tencent.mm.modelvoiceaddr.g.iyj & i) != 0)
      {
        this.BCd.add(getContext().getString(2131760623));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyj));
      }
      if ((com.tencent.mm.modelvoiceaddr.g.iyk & i) != 0)
      {
        this.BCd.add(getContext().getString(2131760624));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyk));
      }
      if ((i & com.tencent.mm.modelvoiceaddr.g.iyl) != 0)
      {
        this.BCd.add(getContext().getString(2131760626));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyl));
        AppMethodBeat.o(102556);
      }
    }
    else if (ac.fks().equals("en"))
    {
      this.BCd.add(getContext().getString(2131760624));
      this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyk));
      this.BCd.add(getContext().getString(2131760625));
      this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyi));
      if ((i & com.tencent.mm.modelvoiceaddr.g.iyj) != 0)
      {
        this.BCd.add(getContext().getString(2131760623));
        this.BCc.add(Integer.valueOf(com.tencent.mm.modelvoiceaddr.g.iyj));
      }
    }
    AppMethodBeat.o(102556);
  }
  
  public final void erw()
  {
    AppMethodBeat.i(102554);
    Object localObject1 = this.containerView;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.BCc).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.gfB();
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
      ((TextView)((FrameLayout)localObject2).findViewById(2131301306)).setText((CharSequence)this.BCd.get(i));
      Object localObject3 = ((FrameLayout)localObject2).findViewById(2131301305);
      p.g(localObject3, "item.findViewById<View>(…language_choice_selected)");
      if (k == this.ixK) {}
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
      this.BCb = ((ImageView)paramBundle.findViewById(2131298375));
      this.containerView = ((LinearLayout)paramBundle.findViewById(2131301303));
    }
    paramBundle = this.BCb;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    paramBundle = this.targetView;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.findViewById(2131303747);; paramBundle = null)
    {
      this.BCe = MMBottomSheetBehavior.w(paramBundle);
      paramBundle = this.BCe;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new d(this));
      }
      erw();
      AppMethodBeat.o(102553);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102555);
    super.show();
    MMBottomSheetBehavior localMMBottomSheetBehavior = this.BCe;
    if (localMMBottomSheetBehavior != null)
    {
      localMMBottomSheetBehavior.cS();
      AppMethodBeat.o(102555);
      return;
    }
    AppMethodBeat.o(102555);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static abstract interface b
  {
    public abstract void Ts(int paramInt);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102549);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.BCi.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102549);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class d
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102550);
      p.h(paramView, "bottomSheet");
      paramView = this.BCi;
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
        if (a.a(this.BCi))
        {
          this.BCi.dismiss();
          AppMethodBeat.o(102551);
          return;
        }
        paramView = a.b(this.BCi);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(int paramInt, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102552);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      jdField_this.ixK = this.czG;
      jdField_this.erw();
      paramView = a.c(jdField_this);
      if (paramView != null) {
        paramView.Ts(jdField_this.ixK);
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