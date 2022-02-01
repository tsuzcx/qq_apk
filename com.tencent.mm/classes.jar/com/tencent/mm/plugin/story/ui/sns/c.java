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
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.m.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class c
  extends e
{
  public static final c.a FzU;
  private static final String TAG = "MicroMsg.StoryEntranceDialog";
  private final b FzT;
  private b gZR;
  private boolean hVn;
  private boolean hVo;
  private boolean hVp;
  private Context mContext;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(119960);
    FzU = new c.a((byte)0);
    TAG = "MicroMsg.StoryEntranceDialog";
    AppMethodBeat.o(119960);
  }
  
  public c(Context paramContext)
  {
    super(paramContext, 2131820868);
    AppMethodBeat.i(119959);
    this.mContext = paramContext;
    this.FzT = new b(this);
    gR();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.gZR = new b(paramContext);
    AppMethodBeat.o(119959);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(119954);
    Resources localResources = this.mContext.getResources();
    p.g(localResources, "mContext.resources");
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
    p.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.gZR.al(paramMotionEvent);
      int i = this.gZR.QnD;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.hVo) || (this.hVn)) {
            break label172;
          }
          bool1 = this.gZR.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.hVo) && (!bool1)) {
        break label227;
      }
      if (!this.hVp)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.hVp = true;
      }
      AppMethodBeat.o(119957);
      return true;
      this.hVp = false;
      this.hVo = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.hVp)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.gZR.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.hVp = true;
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
    p.h(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      if (localWindow == null) {
        p.hyc();
      }
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(2131821287);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!isLandscape()) {
        break label303;
      }
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
      label75:
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(2131309368).setOnClickListener((View.OnClickListener)new c.c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new f(paramView, (StoryGalleryView.b)this.FzT);
      this.gZR.a((com.tencent.mm.ui.m.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.setLayout(-1, -1);
      if (getWindow() != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label317;
        }
        paramView = getWindow();
        if (paramView == null) {
          p.hyc();
        }
        p.g(paramView, "window!!");
        paramView = paramView.getDecorView();
        p.g(paramView, "window!!.decorView");
        paramView.setSystemUiVisibility(1280);
        paramView = getWindow();
        if (paramView == null) {
          p.hyc();
        }
        paramView.addFlags(-2147483648);
        paramView = getWindow();
        if (paramView == null) {
          p.hyc();
        }
        p.g(paramView, "window!!");
        paramView.setStatusBarColor(0);
      }
    }
    for (;;)
    {
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.setFlags(134217728, 134217728);
      AppMethodBeat.o(119956);
      return;
      if (localWindow == null) {
        p.hyc();
      }
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(2131820793);
      break;
      label303:
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      break label75;
      label317:
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.addFlags(67108864);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void aJl()
    {
      long l1 = 0L;
      AppMethodBeat.i(119952);
      View localView = c.a(this.FzV);
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
    
    public final void ca(float paramFloat) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
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
            if (this.FzX.FzW.FzV.isShowing()) {
              this.FzX.FzW.FzV.cancel();
            }
            AppMethodBeat.o(119950);
          }
        });
        AppMethodBeat.o(119951);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c
 * JD-Core Version:    0.7.0.1
 */