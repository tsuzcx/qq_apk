package com.tencent.mm.plugin.webview.ui.tools.video;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private int QvU;
  public boolean QvV;
  private Context mContext;
  private int qGJ;
  private int qGK;
  private WindowManager.LayoutParams qGL;
  private View qGl;
  private int qGn;
  private ViewGroup.LayoutParams qGo;
  private ViewGroup qGp;
  private final Set<c> qGq;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(248779);
    this.qGq = Collections.newSetFromMap(new ConcurrentHashMap());
    this.QvV = false;
    this.mContext = paramContext;
    AppMethodBeat.o(248779);
  }
  
  private void cgQ()
  {
    AppMethodBeat.i(248789);
    Iterator localIterator = this.qGq.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).bOO();
    }
    AppMethodBeat.o(248789);
  }
  
  public final boolean Dp(boolean paramBoolean)
  {
    AppMethodBeat.i(248785);
    if (this.qGl == null)
    {
      AppMethodBeat.o(248785);
      return false;
    }
    if (!(this.mContext instanceof Activity))
    {
      AppMethodBeat.o(248785);
      return false;
    }
    Object localObject = (Activity)this.mContext;
    if ((!paramBoolean) && ((localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed())))
    {
      Log.e("MicroMsg.WebViewFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localObject });
      AppMethodBeat.o(248785);
      return false;
    }
    ((ViewGroup)((Activity)localObject).getWindow().getDecorView()).setSystemUiVisibility(this.qGJ);
    ((Activity)localObject).getWindow().clearFlags(1024);
    if (this.qGL != null) {
      ((Activity)localObject).getWindow().setAttributes(this.qGL);
    }
    ((Activity)localObject).setRequestedOrientation(this.qGK);
    Log.d("MicroMsg.WebViewFullscreenImpl", "exitFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.qGK) });
    if (this.qGp != null)
    {
      if ((this.qGl.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.qGl.getParent()).removeView(this.qGl);
      }
      this.qGp.addView(this.qGl, this.qGn, this.qGo);
      this.qGl.setBackgroundColor(this.QvU);
    }
    this.qGl = null;
    f.d(false, true, true);
    localObject = this.qGq.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((c)((Iterator)localObject).next()).PS();
    }
    AppMethodBeat.o(248785);
    return true;
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(248784);
    if (!(this.mContext instanceof Activity))
    {
      AppMethodBeat.o(248784);
      return;
    }
    Activity localActivity = (Activity)this.mContext;
    if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
    {
      Log.e("MicroMsg.WebViewFullscreenImpl", "enterFullscreen activity(%s) destroyed", new Object[] { localActivity });
      AppMethodBeat.o(248784);
      return;
    }
    View localView = this.qGl;
    this.qGl = paramView;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    if (localView == null)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        this.qGp = ((ViewGroup)paramView.getParent());
        this.qGn = this.qGp.indexOfChild(paramView);
        this.qGo = paramView.getLayoutParams();
        this.qGp.removeView(paramView);
        this.QvU = this.qGl.getDrawingCacheBackgroundColor();
        this.qGl.setBackgroundColor(-16777216);
        localViewGroup.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        localViewGroup.bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
      }
    }
    else
    {
      if (localView == null) {
        this.qGJ = localViewGroup.getSystemUiVisibility();
      }
      localViewGroup.setSystemUiVisibility(5894);
      if (localView == null)
      {
        this.qGL = new WindowManager.LayoutParams();
        this.qGL.copyFrom(localActivity.getWindow().getAttributes());
      }
      localActivity.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28) {
        localActivity.getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
      }
      if (localView == null)
      {
        this.qGK = localActivity.getRequestedOrientation();
        Log.d("MicroMsg.WebViewFullscreenImpl", "enterFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.qGK) });
      }
      switch (paramInt)
      {
      default: 
        localActivity.setRequestedOrientation(9);
      }
    }
    for (;;)
    {
      f.d(true, true, true);
      cgQ();
      AppMethodBeat.o(248784);
      return;
      this.qGn = 0;
      this.qGp = null;
      this.qGo = null;
      break;
      localActivity.setRequestedOrientation(0);
      continue;
      localActivity.setRequestedOrientation(8);
      continue;
      localActivity.setRequestedOrientation(1);
    }
  }
  
  public final boolean bUK()
  {
    return this.qGl != null;
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(248787);
    if (!this.qGq.contains(paramc)) {
      this.qGq.add(paramc);
    }
    AppMethodBeat.o(248787);
  }
  
  public final void d(c paramc)
  {
    AppMethodBeat.i(248788);
    this.qGq.remove(paramc);
    AppMethodBeat.o(248788);
  }
  
  public final void release()
  {
    AppMethodBeat.i(248783);
    this.qGq.clear();
    AppMethodBeat.o(248783);
  }
  
  public final void reset(Context paramContext)
  {
    this.mContext = paramContext;
    this.qGp = null;
    this.qGl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.b
 * JD-Core Version:    0.7.0.1
 */