package com.tencent.mm.plugin.webview.ui.tools.video;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private int EHZ;
  private Context mContext;
  private int mtR;
  private WindowManager.LayoutParams mtS;
  private View mtt;
  private int mtv;
  private ViewGroup.LayoutParams mtw;
  private ViewGroup mtx;
  private final Set<c> mty;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(199110);
    this.mty = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(199110);
  }
  
  private void bxA()
  {
    AppMethodBeat.i(199116);
    Iterator localIterator = this.mty.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).bib();
    }
    AppMethodBeat.o(199116);
  }
  
  public final void O(final View paramView, int paramInt)
  {
    AppMethodBeat.i(199112);
    Activity localActivity = (Activity)this.mContext;
    if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
    {
      ae.e("MicroMsg.WebViewFullscreenImpl", "enterFullscreen activity(%s) destroyed", new Object[] { localActivity });
      AppMethodBeat.o(199112);
      return;
    }
    View localView = this.mtt;
    this.mtt = paramView;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    if (localView == null)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        this.mtx = ((ViewGroup)paramView.getParent());
        this.mtv = this.mtx.indexOfChild(paramView);
        this.mtw = paramView.getLayoutParams();
        this.mtx.removeView(paramView);
        localViewGroup.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        localViewGroup.bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
      }
    }
    else
    {
      paramView = (ViewGroup)localActivity.getWindow().getDecorView();
      if (localView == null) {
        this.mtR = paramView.getSystemUiVisibility();
      }
      paramView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(199109);
          if (((paramAnonymousInt & 0x4) == 0) && (b.this.bnx())) {
            paramView.setSystemUiVisibility(5894);
          }
          AppMethodBeat.o(199109);
        }
      });
      paramView.setSystemUiVisibility(5894);
      if (localView == null)
      {
        this.mtS = new WindowManager.LayoutParams();
        this.mtS.copyFrom(localActivity.getWindow().getAttributes());
      }
      localActivity.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28) {
        localActivity.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
      }
      if (localView == null)
      {
        this.EHZ = localActivity.getRequestedOrientation();
        ae.d("MicroMsg.WebViewFullscreenImpl", "enterFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.EHZ) });
      }
      switch (paramInt)
      {
      default: 
        localActivity.setRequestedOrientation(9);
      }
    }
    for (;;)
    {
      f.e(true, true, true);
      bxA();
      AppMethodBeat.o(199112);
      return;
      this.mtv = 0;
      this.mtx = null;
      this.mtw = null;
      break;
      localActivity.setRequestedOrientation(0);
      continue;
      localActivity.setRequestedOrientation(8);
      continue;
      localActivity.setRequestedOrientation(1);
    }
  }
  
  public final boolean aYo()
  {
    AppMethodBeat.i(199113);
    if (this.mtt == null)
    {
      AppMethodBeat.o(199113);
      return false;
    }
    Object localObject = (Activity)this.mContext;
    if ((localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()))
    {
      ae.e("MicroMsg.WebViewFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localObject });
      AppMethodBeat.o(199113);
      return false;
    }
    ((ViewGroup)((Activity)localObject).getWindow().getDecorView()).setSystemUiVisibility(this.mtR);
    ((Activity)localObject).getWindow().clearFlags(1024);
    if (this.mtS != null) {
      ((Activity)localObject).getWindow().setAttributes(this.mtS);
    }
    ((Activity)localObject).setRequestedOrientation(this.EHZ);
    ae.d("MicroMsg.WebViewFullscreenImpl", "exitFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.EHZ) });
    if (this.mtx != null)
    {
      if ((this.mtt.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.mtt.getParent()).removeView(this.mtt);
      }
      this.mtx.addView(this.mtt, this.mtv, this.mtw);
    }
    this.mtt = null;
    f.e(false, true, true);
    localObject = this.mty.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((c)((Iterator)localObject).next()).DD();
    }
    AppMethodBeat.o(199113);
    return true;
  }
  
  public final boolean bnx()
  {
    return this.mtt != null;
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(199114);
    if (!this.mty.contains(paramc)) {
      this.mty.add(paramc);
    }
    AppMethodBeat.o(199114);
  }
  
  public final void d(c paramc)
  {
    AppMethodBeat.i(199115);
    this.mty.remove(paramc);
    AppMethodBeat.o(199115);
  }
  
  public final void release()
  {
    AppMethodBeat.i(199111);
    this.mty.clear();
    AppMethodBeat.o(199111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.b
 * JD-Core Version:    0.7.0.1
 */