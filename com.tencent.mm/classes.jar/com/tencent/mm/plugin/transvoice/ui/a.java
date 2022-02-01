package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.MMBottomSheetBehavior;
import android.support.design.widget.MMBottomSheetBehavior.a;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.transvoice.a.d;
import com.tencent.mm.plugin.transvoice.a.e;
import com.tencent.mm.plugin.transvoice.a.f;
import com.tencent.mm.plugin.transvoice.a.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "closePanel", "Landroid/widget/ImageView;", "containerView", "Landroid/widget/LinearLayout;", "langStringArr", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLangStringArr", "()Ljava/util/ArrayList;", "setLangStringArr", "(Ljava/util/ArrayList;)V", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "langTypeArr", "getLangTypeArr", "setLangTypeArr", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e
{
  public static final a.a TUw;
  private LinearLayout BlF;
  private MMBottomSheetBehavior<View> TUA;
  private boolean TUB;
  b TUC;
  private ImageView TUx;
  ArrayList<Integer> TUy;
  private ArrayList<String> TUz;
  private View nmf;
  int pfh;
  
  static
  {
    AppMethodBeat.i(102557);
    TUw = new a.a((byte)0);
    AppMethodBeat.o(102557);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, a.g.TransDialog);
    AppMethodBeat.i(102556);
    this.pfh = g.pfF;
    this.TUy = new ArrayList();
    this.TUz = new ArrayList();
    bU();
    int i = i.aRC().getInt("VoiceInputLanguageSupportType", g.pfF);
    if (LocaleUtil.isChineseAppLang())
    {
      this.TUz.add(getContext().getString(a.f.TTM));
      this.TUy.add(Integer.valueOf(g.pfF));
      if ((g.pfG & i) != 0)
      {
        this.TUz.add(getContext().getString(a.f.TTK));
        this.TUy.add(Integer.valueOf(g.pfG));
      }
      if ((g.pfH & i) != 0)
      {
        this.TUz.add(getContext().getString(a.f.TTL));
        this.TUy.add(Integer.valueOf(g.pfH));
      }
      if ((i & g.pfI) != 0)
      {
        this.TUz.add(getContext().getString(a.f.TTN));
        this.TUy.add(Integer.valueOf(g.pfI));
        AppMethodBeat.o(102556);
      }
    }
    else if (LocaleUtil.getApplicationLanguage().equals("en"))
    {
      this.TUz.add(getContext().getString(a.f.TTL));
      this.TUy.add(Integer.valueOf(g.pfH));
      this.TUz.add(getContext().getString(a.f.TTM));
      this.TUy.add(Integer.valueOf(g.pfF));
      if ((i & g.pfG) != 0)
      {
        this.TUz.add(getContext().getString(a.f.TTK));
        this.TUy.add(Integer.valueOf(g.pfG));
      }
    }
    AppMethodBeat.o(102556);
  }
  
  private static final void a(a parama, int paramInt, View paramView)
  {
    AppMethodBeat.i(262541);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.pfh = paramInt;
    parama.hPF();
    paramView = parama.TUC;
    if (paramView != null) {
      paramView.app(parama.pfh);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262541);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(262540);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262540);
  }
  
  public final void hPF()
  {
    AppMethodBeat.i(102554);
    Object localObject1 = this.BlF;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = ((Iterable)this.TUy).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      int k = ((Number)localObject2).intValue();
      localObject2 = getLayoutInflater().inflate(a.e.TTG, null);
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(102554);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout)localObject2;
      ((TextView)((FrameLayout)localObject2).findViewById(a.d.TTr)).setText((CharSequence)this.TUz.get(i));
      Object localObject3 = ((FrameLayout)localObject2).findViewById(a.d.TTq);
      if (k == this.pfh) {}
      for (int j = 0;; j = 4)
      {
        ((View)localObject3).setVisibility(j);
        ((FrameLayout)localObject2).setOnClickListener(new a..ExternalSyntheticLambda1(this, k));
        localObject3 = new FrameLayout.LayoutParams(-1, -2);
        LinearLayout localLinearLayout = this.BlF;
        if (localLinearLayout != null) {
          localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(102554);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102553);
    this.nmf = LayoutInflater.from(getContext()).inflate(a.e.TTF, null, false);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    View localView = this.nmf;
    s.checkNotNull(localView);
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
    paramBundle = this.nmf;
    if (paramBundle != null)
    {
      this.TUx = ((ImageView)paramBundle.findViewById(a.d.TTm));
      this.BlF = ((LinearLayout)paramBundle.findViewById(a.d.TTp));
    }
    paramBundle = this.TUx;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    }
    paramBundle = this.nmf;
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.findViewById(a.d.TTA))
    {
      this.TUA = MMBottomSheetBehavior.c(paramBundle);
      paramBundle = this.TUA;
      if (paramBundle != null) {
        paramBundle.cb = ((MMBottomSheetBehavior.a)new c(this));
      }
      hPF();
      AppMethodBeat.o(102553);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(102555);
    super.show();
    MMBottomSheetBehavior localMMBottomSheetBehavior = this.TUA;
    if (localMMBottomSheetBehavior != null) {
      localMMBottomSheetBehavior.aL();
    }
    AppMethodBeat.o(102555);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void app(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends MMBottomSheetBehavior.a
  {
    c(a parama) {}
    
    public final void c(View paramView, float paramFloat)
    {
      AppMethodBeat.i(102550);
      s.u(paramView, "bottomSheet");
      paramView = this.TUD;
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
      s.u(paramView, "bottomSheet");
      if (2 == paramInt)
      {
        if (a.a(this.TUD))
        {
          this.TUD.dismiss();
          AppMethodBeat.o(102551);
          return;
        }
        paramView = a.b(this.TUD);
        if (paramView != null) {
          paramView.aL();
        }
      }
      AppMethodBeat.o(102551);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a
 * JD-Core Version:    0.7.0.1
 */