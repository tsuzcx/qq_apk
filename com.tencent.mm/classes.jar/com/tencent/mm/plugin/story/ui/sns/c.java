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
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.plugin.story.ui.view.gallery.f;
import com.tencent.mm.ui.j.b;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class c
  extends e
{
  public static final c.a Bpi;
  private static final String TAG = "MicroMsg.StoryEntranceDialog";
  private final c.b Bph;
  private b goY;
  private boolean hct;
  private boolean hcu;
  private boolean hcv;
  private Context mContext;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(119960);
    Bpi = new c.a((byte)0);
    TAG = "MicroMsg.StoryEntranceDialog";
    AppMethodBeat.o(119960);
  }
  
  public c(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(119959);
    this.mContext = paramContext;
    this.Bph = new c.b(this);
    gK();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.goY = new b(paramContext);
    AppMethodBeat.o(119959);
  }
  
  private final boolean aoA()
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
      this.goY.ae(paramMotionEvent);
      int i = this.goY.KYK;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.hcu) || (this.hct)) {
            break label172;
          }
          bool1 = this.goY.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.hcu) && (!bool1)) {
        break label227;
      }
      if (!this.hcv)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.hcv = true;
      }
      AppMethodBeat.o(119957);
      return true;
      this.hcv = false;
      this.hcu = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.hcv)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.goY.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.hcv = true;
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
    if (aoA())
    {
      if (localWindow == null) {
        p.gkB();
      }
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(2131821249);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!aoA()) {
        break label271;
      }
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
      label75:
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(2131306045).setOnClickListener((View.OnClickListener)new c.c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new f(paramView, (StoryGalleryView.b)this.Bph);
      this.goY.a((com.tencent.mm.ui.j.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        p.gkB();
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
        p.gkB();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c
 * JD-Core Version:    0.7.0.1
 */