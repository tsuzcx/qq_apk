package com.tencent.mm.ui.mvvm.b;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mvvm.a.m;
import com.tencent.mm.ui.tools.h;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/uic/BaseSelectContactMenuUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "animator", "Landroid/animation/ObjectAnimator;", "keyboardHeightChangeObserver", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "getKeyboardHeightChangeObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightChangeObserver$delegate", "Lkotlin/Lazy;", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "selectRecordMsgBt", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getSelectRecordMsgBt", "()Landroid/widget/LinearLayout;", "selectRecordMsgBt$delegate", "selectRecordMsgFinishBt", "Landroid/widget/Button;", "getSelectRecordMsgFinishBt", "()Landroid/widget/Button;", "selectRecordMsgFinishBt$delegate", "selectRecordMsgLayout", "Landroid/view/View;", "getSelectRecordMsgLayout", "()Landroid/view/View;", "selectRecordMsgLayout$delegate", "selectRecordMsgRightArrowIv", "Landroid/widget/ImageView;", "getSelectRecordMsgRightArrowIv", "()Landroid/widget/ImageView;", "selectRecordMsgRightArrowIv$delegate", "selectRecordMsgSuccessIv", "getSelectRecordMsgSuccessIv", "selectRecordMsgSuccessIv$delegate", "selectRecordMsgTipsTv", "Landroid/widget/TextView;", "getSelectRecordMsgTipsTv", "()Landroid/widget/TextView;", "selectRecordMsgTipsTv$delegate", "selectRecordMsgWarnIv", "getSelectRecordMsgWarnIv", "selectRecordMsgWarnIv$delegate", "selectRecordUploadProgressView", "Landroid/widget/ProgressBar;", "getSelectRecordUploadProgressView", "()Landroid/widget/ProgressBar;", "selectRecordUploadProgressView$delegate", "clickConfirmMenu", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onWindowFocusChanged", "hasFocus", "", "updateBottomMenuVisible", "show", "updateMenu", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;", "Companion", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends com.tencent.mm.plugin.mvvmbase.a
{
  public static final b.a afBq;
  private ObjectAnimator JWJ;
  private final j afBr;
  private final j afBs;
  private final j afBt;
  private final j afBu;
  private final j afBv;
  private final j afBw;
  private final j afBx;
  private final j afBy;
  private final j afBz;
  private com.tencent.mm.ui.tools.i lKz;
  
  static
  {
    AppMethodBeat.i(250684);
    afBq = new b.a((byte)0);
    AppMethodBeat.o(250684);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250623);
    this.afBr = k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.afBs = k.cm((kotlin.g.a.a)new d(this));
    this.afBt = k.cm((kotlin.g.a.a)new e(this));
    this.afBu = k.cm((kotlin.g.a.a)new h(this));
    this.afBv = k.cm((kotlin.g.a.a)new j(this));
    this.afBw = k.cm((kotlin.g.a.a)new g(this));
    this.afBx = k.cm((kotlin.g.a.a)new k(this));
    this.afBy = k.cm((kotlin.g.a.a)new i(this));
    this.afBz = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(250623);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(250641);
    s.u(paramb, "this$0");
    Object localObject = paramb.gst();
    if (localObject != null)
    {
      localObject = ((BaseMvvmActivity)localObject).getStateCenter();
      if (localObject != null) {
        ((UIStateCenter)localObject).dispatch((IStateAction)new m(paramb.jCh().getHeight()));
      }
    }
    AppMethodBeat.o(250641);
  }
  
  private final View jCh()
  {
    AppMethodBeat.i(250630);
    View localView = (View)this.afBr.getValue();
    AppMethodBeat.o(250630);
    return localView;
  }
  
  private final Button jCi()
  {
    AppMethodBeat.i(250634);
    Button localButton = (Button)this.afBt.getValue();
    AppMethodBeat.o(250634);
    return localButton;
  }
  
  public final void a(com.tencent.mm.ui.mvvm.a.i parami)
  {
    AppMethodBeat.i(250703);
    s.u(parami, "state");
    MMActivity localMMActivity = (MMActivity)getActivity();
    Log.i("MicroMsg.SelectContact.BaseSelectContactMenuUIC", s.X("updateMenu: ", Integer.valueOf(parami.pJQ.size())));
    String str;
    if (parami.pJQ.size() > 0)
    {
      str = getString(a.h.app_finish) + '(' + parami.pJQ.size() + ')';
      if (parami.jBY()) {
        localMMActivity.updateOptionMenuText(1, str);
      }
    }
    while (parami.pJQ.size() > parami.afAW) {
      if (parami.jBY())
      {
        localMMActivity.enableOptionMenu(1, true);
        AppMethodBeat.o(250703);
        return;
        jCi().setText((CharSequence)str);
        continue;
        str = getString(a.h.app_finish);
        if (parami.jBY()) {
          localMMActivity.updateOptionMenuText(1, str);
        } else {
          jCi().setText((CharSequence)str);
        }
      }
      else
      {
        jCi().setEnabled(true);
        AppMethodBeat.o(250703);
        return;
      }
    }
    if (parami.jBY())
    {
      localMMActivity.enableOptionMenu(1, false);
      AppMethodBeat.o(250703);
      return;
    }
    jCi().setEnabled(false);
    AppMethodBeat.o(250703);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250689);
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.observe((q)getActivity(), (kotlin.g.a.b)new c(this));
      }
    }
    AppMethodBeat.o(250689);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(250704);
    ObjectAnimator localObjectAnimator = this.JWJ;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    super.onDestroy();
    AppMethodBeat.o(250704);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(250700);
    com.tencent.mm.ui.tools.i locali = this.lKz;
    if (locali != null) {
      locali.close();
    }
    super.onPause();
    AppMethodBeat.o(250700);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(250697);
    super.onResume();
    com.tencent.mm.ui.tools.i locali = this.lKz;
    if (locali != null) {
      locali.start();
    }
    AppMethodBeat.o(250697);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(250694);
    super.onWindowFocusChanged(paramBoolean);
    com.tencent.mm.ui.tools.i locali = this.lKz;
    if (locali != null) {
      locali.start();
    }
    AppMethodBeat.o(250694);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<h>
  {
    b(b paramb)
    {
      super();
    }
    
    private static final void a(b paramb, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(250625);
      s.u(paramb, "this$0");
      Log.i("MicroMsg.SelectContact.BaseSelectContactMenuUIC", "height:%s", new Object[] { Integer.valueOf(paramInt) });
      ObjectAnimator localObjectAnimator = b.f(paramb);
      int i;
      if ((localObjectAnimator != null) && (localObjectAnimator.isRunning() == true))
      {
        i = 1;
        if (i != 0)
        {
          localObjectAnimator = b.f(paramb);
          if (localObjectAnimator != null) {
            localObjectAnimator.cancel();
          }
        }
        if (paramInt <= 0) {
          break label225;
        }
        if (b.g(paramb).getTranslationY() != 0.0F) {
          break label220;
        }
        i = 1;
        label89:
        if (i == 0) {
          b.g(paramb).setTranslationY(0.0F);
        }
      }
      label220:
      label225:
      for (localObjectAnimator = ObjectAnimator.ofFloat(b.g(paramb), "translationY", new float[] { 0.0F, -paramInt });; localObjectAnimator = ObjectAnimator.ofFloat(b.g(paramb), "translationY", new float[] { b.g(paramb).getTranslationY(), 0.0F }))
      {
        b.a(paramb, localObjectAnimator);
        localObjectAnimator = b.f(paramb);
        if (localObjectAnimator != null) {
          localObjectAnimator.setDuration(200L);
        }
        localObjectAnimator = b.f(paramb);
        if (localObjectAnimator != null) {
          localObjectAnimator.setInterpolator((TimeInterpolator)new androidx.g.a.a.b());
        }
        localObjectAnimator = b.f(paramb);
        if (localObjectAnimator != null) {
          localObjectAnimator.addUpdateListener(b.b..ExternalSyntheticLambda0.INSTANCE);
        }
        paramb = b.f(paramb);
        if (paramb != null) {
          paramb.start();
        }
        AppMethodBeat.o(250625);
        return;
        i = 0;
        break;
        i = 0;
        break label89;
      }
    }
    
    private static final void h(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(250617);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("translationY");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(250617);
        throw paramValueAnimator;
      }
      Log.i("MicroMsg.SelectContact.BaseSelectContactMenuUIC", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramValueAnimator).floatValue()) });
      AppMethodBeat.o(250617);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.ui.mvvm.a.i, ah>
  {
    c(b paramb)
    {
      super();
    }
    
    private static final void a(b paramb, View paramView)
    {
      AppMethodBeat.i(250607);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/mvvm/uic/BaseSelectContactMenuUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramb, "this$0");
      b.b(paramb);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/mvvm/uic/BaseSelectContactMenuUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250607);
    }
    
    private static final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(250605);
      s.u(paramb, "this$0");
      b.b(paramb);
      AppMethodBeat.o(250605);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Button>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<TextView>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ProgressBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ProgressBar>
  {
    k(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.b.b
 * JD-Core Version:    0.7.0.1
 */