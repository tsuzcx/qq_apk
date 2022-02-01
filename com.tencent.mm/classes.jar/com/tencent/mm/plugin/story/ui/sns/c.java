package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.h;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.plugin.story.ui.view.gallery.f;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
{
  public static final c.a Swe;
  private static final String TAG;
  private final b Swf;
  private Context mContext;
  private com.tencent.mm.ui.o.b mke;
  private View nmf;
  private boolean nmh;
  private boolean nmi;
  private boolean nmj;
  
  static
  {
    AppMethodBeat.i(119960);
    Swe = new c.a((byte)0);
    TAG = "MicroMsg.StoryEntranceDialog";
    AppMethodBeat.o(119960);
  }
  
  public c(Context paramContext)
  {
    super(paramContext, a.h.CustomSheetStyle);
    AppMethodBeat.i(119959);
    this.mContext = paramContext;
    this.Swf = new b(this);
    bU();
    paramContext = getContext();
    s.s(paramContext, "context");
    this.mke = new com.tencent.mm.ui.o.b(paramContext);
    AppMethodBeat.o(119959);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(367397);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    if (paramc.isShowing()) {
      paramc.cancel();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367397);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(119954);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(119954);
      return true;
    }
    AppMethodBeat.o(119954);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(119958);
    if ((this.nmf instanceof a))
    {
      Object localObject = this.nmf;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
        AppMethodBeat.o(119958);
        throw ((Throwable)localObject);
      }
      ((a)localObject).finish();
    }
    super.cancel();
    AppMethodBeat.o(119958);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(119957);
    s.u(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.mke.aw(paramMotionEvent);
      int i = this.mke.Irw;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.nmi) || (this.nmh)) {
            break label166;
          }
          bool1 = this.mke.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.nmi) && (!bool1)) {
        break label225;
      }
      if (!this.nmj)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.nmj = true;
      }
      AppMethodBeat.o(119957);
      return true;
      this.nmj = false;
      this.nmi = false;
      break;
      label166:
      bool1 = bool2;
      if (!this.nmj)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(3);
        com.tencent.mm.ui.o.b localb = this.mke;
        s.s(localMotionEvent, "cancelEvent");
        localb.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.nmj = true;
        bool1 = bool2;
      }
    }
    label225:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(119957);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119955);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.0F);
    }
    AppMethodBeat.o(119955);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(119956);
    s.u(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      s.checkNotNull(localWindow);
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(a.h.RightToLeftAnimation);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!isLandscape()) {
        break label260;
      }
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
      label75:
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(a.d.touch_outside).setOnClickListener(new c..ExternalSyntheticLambda0(this));
      super.setContentView(paramView);
      this.nmf = paramView;
      paramView = new f(paramView, (StoryGalleryView.b)this.Swf);
      this.mke.a((com.tencent.mm.ui.o.a)paramView);
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.setLayout(-1, -1);
      if (getWindow() != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label274;
        }
        paramView = getWindow();
        s.checkNotNull(paramView);
        paramView.getDecorView().setSystemUiVisibility(1280);
        paramView = getWindow();
        s.checkNotNull(paramView);
        paramView.addFlags(-2147483648);
        paramView = getWindow();
        s.checkNotNull(paramView);
        paramView.setStatusBarColor(0);
      }
    }
    for (;;)
    {
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.setFlags(134217728, 134217728);
      AppMethodBeat.o(119956);
      return;
      s.checkNotNull(localWindow);
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(a.h.BottomToTopSlowAnimation);
      break;
      label260:
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      break label75;
      label274:
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.addFlags(67108864);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements StoryGalleryView.b
  {
    b(c paramc) {}
    
    private static final void b(c paramc)
    {
      AppMethodBeat.i(367391);
      s.u(paramc, "this$0");
      if (paramc.isShowing()) {
        paramc.cancel();
      }
      AppMethodBeat.o(367391);
    }
    
    private static final void c(c paramc)
    {
      AppMethodBeat.i(367395);
      s.u(paramc, "this$0");
      new MMHandler().post(new c.b..ExternalSyntheticLambda1(paramc));
      AppMethodBeat.o(367395);
    }
    
    public final void bkW()
    {
      long l1 = 0L;
      AppMethodBeat.i(119952);
      View localView = c.a(this.Swg);
      c localc;
      long l2;
      if (localView != null)
      {
        localc = this.Swg;
        localView.setEnabled(false);
        l2 = ((localView.getHeight() - localView.getTranslationY()) / localView.getHeight() * 300.0F);
        if (l2 >= 0L) {
          break label102;
        }
      }
      for (;;)
      {
        localView.animate().translationY(localView.getHeight()).setDuration(l1).withEndAction(new c.b..ExternalSyntheticLambda0(localc)).start();
        AppMethodBeat.o(119952);
        return;
        label102:
        l1 = l2;
      }
    }
    
    public final void dv(float paramFloat) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c
 * JD-Core Version:    0.7.0.1
 */