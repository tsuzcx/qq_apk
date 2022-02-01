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
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class c
  extends e
{
  public static final c.a AXK;
  private static final String TAG = "MicroMsg.StoryEntranceDialog";
  private final b AXJ;
  private boolean gZG;
  private boolean gZH;
  private boolean gZI;
  private com.tencent.mm.ui.j.b gmC;
  private Context mContext;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(119960);
    AXK = new c.a((byte)0);
    TAG = "MicroMsg.StoryEntranceDialog";
    AppMethodBeat.o(119960);
  }
  
  public c(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(119959);
    this.mContext = paramContext;
    this.AXJ = new b(this);
    gK();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.gmC = new com.tencent.mm.ui.j.b(paramContext);
    AppMethodBeat.o(119959);
  }
  
  private final boolean aol()
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
    p.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.gmC.ag(paramMotionEvent);
      int i = this.gmC.KCq;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.gZH) || (this.gZG)) {
            break label172;
          }
          bool1 = this.gmC.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.gZH) && (!bool1)) {
        break label227;
      }
      if (!this.gZI)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.gZI = true;
      }
      AppMethodBeat.o(119957);
      return true;
      this.gZI = false;
      this.gZH = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.gZI)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.gmC.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.gZI = true;
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
    p.h(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (aol())
    {
      if (localWindow == null) {
        p.gfZ();
      }
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(2131821249);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!aol()) {
        break label271;
      }
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
      label75:
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(2131306045).setOnClickListener((View.OnClickListener)new c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new f(paramView, (StoryGalleryView.b)this.AXJ);
      this.gmC.a((com.tencent.mm.ui.j.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        p.gfZ();
      }
      paramView.setLayout(-1, -1);
      if (getWindow() != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label285;
        }
        paramView = getWindow();
        p.g(paramView, "window");
        paramView = paramView.getDecorView();
        p.g(paramView, "window.decorView");
        paramView.setSystemUiVisibility(1280);
        getWindow().addFlags(-2147483648);
        paramView = getWindow();
        p.g(paramView, "window");
        paramView.setStatusBarColor(0);
      }
    }
    for (;;)
    {
      getWindow().setFlags(134217728, 134217728);
      AppMethodBeat.o(119956);
      return;
      if (localWindow == null) {
        p.gfZ();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
  public static final class b
    implements StoryGalleryView.b
  {
    public final void aqy()
    {
      long l1 = 0L;
      AppMethodBeat.i(119952);
      View localView = c.a(this.AXL);
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
    
    public final void bI(float paramFloat) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
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
            if (this.AXN.AXM.AXL.isShowing()) {
              this.AXN.AXM.AXL.cancel();
            }
            AppMethodBeat.o(119950);
          }
        });
        AppMethodBeat.o(119951);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119953);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (this.AXL.isShowing()) {
        this.AXL.cancel();
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