package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.MMBottomSheetBehavior;
import android.support.design.widget.MMBottomSheetBehavior.a;
import android.support.v7.app.e;
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
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "closePanel", "Landroid/widget/ImageView;", "containerView", "Landroid/widget/LinearLayout;", "langStringArr", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLangStringArr", "()Ljava/util/ArrayList;", "setLangStringArr", "(Ljava/util/ArrayList;)V", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "langTypeArr", "getLangTypeArr", "setLangTypeArr", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"})
public final class a
  extends e
{
  public static final a Gul;
  private ImageView Guf;
  ArrayList<Integer> Gug;
  private ArrayList<String> Guh;
  private MMBottomSheetBehavior<View> Gui;
  private boolean Guj;
  b Guk;
  private LinearLayout containerView;
  int jvS;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(102557);
    Gul = new a((byte)0);
    AppMethodBeat.o(102557);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131821534);
    AppMethodBeat.i(102556);
    this.jvS = g.jwq;
    this.Gug = new ArrayList();
    this.Guh = new ArrayList();
    gR();
    int i = h.aqJ().getInt("VoiceInputLanguageSupportType", g.jwq);
    if (LocaleUtil.isChineseAppLang())
    {
      this.Guh.add(getContext().getString(2131762137));
      this.Gug.add(Integer.valueOf(g.jwq));
      if ((g.jwr & i) != 0)
      {
        this.Guh.add(getContext().getString(2131762135));
        this.Gug.add(Integer.valueOf(g.jwr));
      }
      if ((g.jws & i) != 0)
      {
        this.Guh.add(getContext().getString(2131762136));
        this.Gug.add(Integer.valueOf(g.jws));
      }
      if ((i & g.jwt) != 0)
      {
        this.Guh.add(getContext().getString(2131762138));
        this.Gug.add(Integer.valueOf(g.jwt));
        AppMethodBeat.o(102556);
      }
    }
    else if (LocaleUtil.getApplicationLanguage().equals("en"))
    {
      this.Guh.add(getContext().getString(2131762136));
      this.Gug.add(Integer.valueOf(g.jws));
      this.Guh.add(getContext().getString(2131762137));
      this.Gug.add(Integer.valueOf(g.jwq));
      if ((i & g.jwr) != 0)
      {
        this.Guh.add(getContext().getString(2131762135));
        this.Gug.add(Integer.valueOf(g.jwr));
      }
    }
    AppMethodBeat.o(102556);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(102554);
    Object localObject1 = this.containerView;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.Gug).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      int k = ((Number)localObject2).intValue();
      localObject2 = getLayoutInflater().inflate(2131495152, null);
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(102554);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout)localObject2;
      ((TextView)((FrameLayout)localObject2).findViewById(2131303004)).setText((CharSequence)this.Guh.get(i));
      Object localObject3 = ((FrameLayout)localObject2).findViewById(2131303003);
      p.g(localObject3, "item.findViewById<View>(…language_choice_selected)");
      if (k == this.jvS) {}
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
    this.targetView = LayoutInflater.from(getContext()).inflate(2131495151, null, false);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    View localView = this.targetView;
    if (localView == null) {
      p.hyc();
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
      paramBundle.setWindowAnimations(2131820793);
    }
    paramBundle = this.targetView;
    if (paramBundle != null)
    {
      this.Guf = ((ImageView)paramBundle.findViewById(2131298784));
      this.containerView = ((LinearLayout)paramBundle.findViewById(2131303001));
    }
    paramBundle = this.Guf;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    paramBundle = this.targetView;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.findViewById(2131306536);; paramBundle = null)
    {
      this.Gui = MMBottomSheetBehavior.x(paramBundle);
      paramBundle = this.Gui;
      if (paramBundle != null) {
        paramBundle.a((MMBottomSheetBehavior.a)new d(this));
      }
      fAw();
      AppMethodBeat.o(102553);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102555);
    super.show();
    MMBottomSheetBehavior localMMBottomSheetBehavior = this.Gui;
    if (localMMBottomSheetBehavior != null)
    {
      localMMBottomSheetBehavior.cU();
      AppMethodBeat.o(102555);
      return;
    }
    AppMethodBeat.o(102555);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$Companion;", "", "()V", "MODE_ONLY_PANEL_CLOSE_PANEL_OFFSET", "", "TAG", "", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
  public static abstract interface b
  {
    public abstract void acp(int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102549);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.Gum.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102549);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
  public static final class d
    extends MMBottomSheetBehavior.a
  {
    public final void b(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102550);
      p.h(paramView, "bottomSheet");
      paramView = this.Gum;
      if (0.7F >= paramFloat) {}
      for (boolean bool = true;; bool = false)
      {
        a.a(paramView, bool);
        AppMethodBeat.o(102550);
        return;
      }
    }
    
    public final void f(View paramView, int paramInt)
    {
      AppMethodBeat.i(102551);
      p.h(paramView, "bottomSheet");
      if (2 == paramInt)
      {
        if (a.a(this.Gum))
        {
          this.Gum.dismiss();
          AppMethodBeat.o(102551);
          return;
        }
        paramView = a.b(this.Gum);
        if (paramView != null)
        {
          paramView.cU();
          AppMethodBeat.o(102551);
          return;
        }
      }
      AppMethodBeat.o(102551);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(int paramInt, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102552);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      jdField_this.jvS = this.$type;
      jdField_this.fAw();
      paramView = a.c(jdField_this);
      if (paramView != null) {
        paramView.acp(jdField_this.jvS);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(102552);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a
 * JD-Core Version:    0.7.0.1
 */