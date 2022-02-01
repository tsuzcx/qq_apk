package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.plugin.story.ui.view.gallery.f;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.j.b;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class c
  extends e
{
  private static final String TAG = "MicroMsg.StoryEntranceDialog";
  public static final a ysP;
  private b fPd;
  private Context mContext;
  private View targetView;
  private final b ysL;
  private boolean ysM;
  private boolean ysN;
  private boolean ysO;
  
  static
  {
    AppMethodBeat.i(119960);
    ysP = new a((byte)0);
    TAG = "MicroMsg.StoryEntranceDialog";
    AppMethodBeat.o(119960);
  }
  
  public c(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(119959);
    this.mContext = paramContext;
    this.ysL = new b(this);
    gl();
    paramContext = getContext();
    k.g(paramContext, "context");
    this.fPd = new b(paramContext);
    AppMethodBeat.o(119959);
  }
  
  private final boolean aov()
  {
    AppMethodBeat.i(119954);
    Resources localResources = this.mContext.getResources();
    k.g(localResources, "mContext.resources");
    if (localResources.getConfiguration().orientation == 2)
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
    if ((this.targetView instanceof a))
    {
      Object localObject = this.targetView;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
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
    k.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.fPd.ae(paramMotionEvent);
      int i = this.fPd.HkQ;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.ysN) || (this.ysM)) {
            break label172;
          }
          bool1 = this.fPd.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.ysN) && (!bool1)) {
        break label227;
      }
      if (!this.ysO)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.ysO = true;
      }
      AppMethodBeat.o(119957);
      return true;
      this.ysO = false;
      this.ysN = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.ysO)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.fPd.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.ysO = true;
        bool1 = bool2;
      }
    }
    label227:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(119957);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119955);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(119955);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(119956);
    k.h(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (aov())
    {
      if (localWindow == null) {
        k.fvU();
      }
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(2131821249);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!aov()) {
        break label271;
      }
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
      label75:
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(2131306045).setOnClickListener((View.OnClickListener)new c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new f(paramView, (StoryGalleryView.b)this.ysL);
      this.fPd.a((com.tencent.mm.ui.j.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        k.fvU();
      }
      paramView.setLayout(-1, -1);
      if (getWindow() != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label285;
        }
        paramView = getWindow();
        k.g(paramView, "window");
        paramView = paramView.getDecorView();
        k.g(paramView, "window.decorView");
        paramView.setSystemUiVisibility(1280);
        getWindow().addFlags(-2147483648);
        paramView = getWindow();
        k.g(paramView, "window");
        paramView.setStatusBarColor(0);
      }
    }
    for (;;)
    {
      getWindow().setFlags(134217728, 134217728);
      AppMethodBeat.o(119956);
      return;
      if (localWindow == null) {
        k.fvU();
      }
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(2131820790);
      break;
      label271:
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      break label75;
      label285:
      getWindow().addFlags(67108864);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void bx(float paramFloat) {}
    
    public final void dKU()
    {
      long l1 = 0L;
      AppMethodBeat.i(119952);
      View localView = c.a(this.ysQ);
      long l2;
      if (localView != null)
      {
        localView.setEnabled(false);
        l2 = ((localView.getHeight() - localView.getTranslationY()) / localView.getHeight() * 300.0F);
        if (l2 >= 0L) {
          break label104;
        }
      }
      for (;;)
      {
        localView.animate().translationY(localView.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
        AppMethodBeat.o(119952);
        return;
        AppMethodBeat.o(119952);
        return;
        label104:
        l1 = l2;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(119951);
        new ap().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(119950);
            if (this.ysS.ysR.ysQ.isShowing()) {
              this.ysS.ysR.ysQ.cancel();
            }
            AppMethodBeat.o(119950);
          }
        });
        AppMethodBeat.o(119951);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119953);
      if (this.ysQ.isShowing()) {
        this.ysQ.cancel();
      }
      AppMethodBeat.o(119953);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c
 * JD-Core Version:    0.7.0.1
 */