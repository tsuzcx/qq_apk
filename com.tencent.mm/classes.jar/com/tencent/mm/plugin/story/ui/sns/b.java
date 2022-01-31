package com.tencent.mm.plugin.story.ui.sns;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.plugin.story.ui.view.gallery.f;
import com.tencent.mm.plugin.story.ui.view.gallery.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class b
  extends android.support.v7.app.e
{
  private static final String TAG = "MicroMsg.StoryEntranceDialog";
  public static final b.a sKm;
  private Context mContext;
  private f sKh;
  private final b.b sKi;
  private boolean sKj;
  private boolean sKk;
  private boolean sKl;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(110245);
    sKm = new b.a((byte)0);
    TAG = "MicroMsg.StoryEntranceDialog";
    AppMethodBeat.o(110245);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, 2131493185);
    AppMethodBeat.i(110244);
    this.mContext = paramContext;
    this.sKi = new b.b(this);
    eS();
    paramContext = getContext();
    j.p(paramContext, "context");
    this.sKh = new f(paramContext);
    AppMethodBeat.o(110244);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(110239);
    Resources localResources = this.mContext.getResources();
    j.p(localResources, "mContext.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(110239);
      return true;
    }
    AppMethodBeat.o(110239);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(110243);
    if ((this.targetView instanceof a))
    {
      Object localObject = this.targetView;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
        AppMethodBeat.o(110243);
        throw ((Throwable)localObject);
      }
      ((a)localObject).finish();
    }
    super.cancel();
    AppMethodBeat.o(110243);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(110242);
    j.q(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.sKh.N(paramMotionEvent);
      int i = this.sKh.sSl;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.sKk) || (this.sKj)) {
            break label172;
          }
          bool1 = this.sKh.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.sKk) && (!bool1)) {
        break label227;
      }
      if (!this.sKl)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        j.p(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.sKl = true;
      }
      AppMethodBeat.o(110242);
      return true;
      this.sKl = false;
      this.sKk = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.sKl)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        j.p(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.sKh.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.sKl = true;
        bool1 = bool2;
      }
    }
    label227:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(110242);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110240);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(110240);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(110241);
    j.q(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      if (localWindow == null) {
        j.ebi();
      }
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(2131493543);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!isLandscape()) {
        break label271;
      }
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
      label75:
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(2131823374).setOnClickListener((View.OnClickListener)new b.c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new h(paramView, (StoryGalleryView.b)this.sKi);
      this.sKh.a((com.tencent.mm.plugin.story.ui.view.gallery.e)paramView);
      paramView = getWindow();
      if (paramView == null) {
        j.ebi();
      }
      paramView.setLayout(-1, -1);
      if (getWindow() != null)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label285;
        }
        paramView = getWindow();
        j.p(paramView, "window");
        paramView = paramView.getDecorView();
        j.p(paramView, "window.decorView");
        paramView.setSystemUiVisibility(1280);
        getWindow().addFlags(-2147483648);
        paramView = getWindow();
        j.p(paramView, "window");
        paramView.setStatusBarColor(0);
      }
    }
    for (;;)
    {
      getWindow().setFlags(134217728, 134217728);
      AppMethodBeat.o(110241);
      return;
      if (localWindow == null) {
        j.ebi();
      }
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(2131493120);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b
 * JD-Core Version:    0.7.0.1
 */