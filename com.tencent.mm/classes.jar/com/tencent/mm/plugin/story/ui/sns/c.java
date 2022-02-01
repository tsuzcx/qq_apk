package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class c
  extends e
{
  public static final a LTZ;
  private static final String TAG = "MicroMsg.StoryEntranceDialog";
  private final b LTY;
  private com.tencent.mm.ui.o.b jKS;
  private View kJL;
  private boolean kJN;
  private boolean kJO;
  private boolean kJP;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(119960);
    LTZ = new a((byte)0);
    TAG = "MicroMsg.StoryEntranceDialog";
    AppMethodBeat.o(119960);
  }
  
  public c(Context paramContext)
  {
    super(paramContext, a.h.CustomSheetStyle);
    AppMethodBeat.i(119959);
    this.mContext = paramContext;
    this.LTY = new b(this);
    bb();
    paramContext = getContext();
    p.j(paramContext, "context");
    this.jKS = new com.tencent.mm.ui.o.b(paramContext);
    AppMethodBeat.o(119959);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(119954);
    Resources localResources = this.mContext.getResources();
    p.j(localResources, "mContext.resources");
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
    if ((this.kJL instanceof a))
    {
      Object localObject = this.kJL;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
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
    p.k(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.jKS.at(paramMotionEvent);
      int i = this.jKS.XLC;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.kJO) || (this.kJN)) {
            break label172;
          }
          bool1 = this.jKS.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.kJO) && (!bool1)) {
        break label227;
      }
      if (!this.kJP)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.j(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.kJP = true;
      }
      AppMethodBeat.o(119957);
      return true;
      this.kJP = false;
      this.kJO = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.kJP)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.j(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.jKS.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.kJP = true;
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
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.setDimAmount(0.0F);
      AppMethodBeat.o(119955);
      return;
    }
    AppMethodBeat.o(119955);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(119956);
    p.k(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      if (localWindow == null) {
        p.iCn();
      }
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(a.h.RightToLeftAnimation);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!isLandscape()) {
        break label304;
      }
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
      label76:
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(a.d.touch_outside).setOnClickListener((View.OnClickListener)new c(this));
      super.setContentView(paramView);
      this.kJL = paramView;
      paramView = new f(paramView, (StoryGalleryView.b)this.LTY);
      this.jKS.a((com.tencent.mm.ui.o.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.setLayout(-1, -1);
      if (getWindow() != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label318;
        }
        paramView = getWindow();
        if (paramView == null) {
          p.iCn();
        }
        p.j(paramView, "window!!");
        paramView = paramView.getDecorView();
        p.j(paramView, "window!!.decorView");
        paramView.setSystemUiVisibility(1280);
        paramView = getWindow();
        if (paramView == null) {
          p.iCn();
        }
        paramView.addFlags(-2147483648);
        paramView = getWindow();
        if (paramView == null) {
          p.iCn();
        }
        p.j(paramView, "window!!");
        paramView.setStatusBarColor(0);
      }
    }
    for (;;)
    {
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.setFlags(134217728, 134217728);
      AppMethodBeat.o(119956);
      return;
      if (localWindow == null) {
        p.iCn();
      }
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(a.h.BottomToTopSlowAnimation);
      break;
      label304:
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      break label76;
      label318:
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.addFlags(67108864);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void aRj()
    {
      long l1 = 0L;
      AppMethodBeat.i(119952);
      View localView = c.a(this.LUa);
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
    
    public final void cj(float paramFloat) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(c.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(119951);
        new MMHandler().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(119950);
            if (this.LUc.LUb.LUa.isShowing()) {
              this.LUc.LUb.LUa.cancel();
            }
            AppMethodBeat.o(119950);
          }
        });
        AppMethodBeat.o(119951);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119953);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.LUa.isShowing()) {
        this.LUa.cancel();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119953);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c
 * JD-Core Version:    0.7.0.1
 */