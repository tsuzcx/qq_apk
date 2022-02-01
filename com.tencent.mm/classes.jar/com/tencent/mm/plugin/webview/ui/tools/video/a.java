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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private int EpL;
  private Context mContext;
  private final Set<b> moA;
  private int moQ;
  private WindowManager.LayoutParams moR;
  private View mov;
  private int mox;
  private ViewGroup.LayoutParams moy;
  private ViewGroup moz;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(208927);
    this.moA = Collections.newSetFromMap(new ConcurrentHashMap());
    this.mContext = paramContext;
    AppMethodBeat.o(208927);
  }
  
  private void bwJ()
  {
    AppMethodBeat.i(208933);
    Iterator localIterator = this.moA.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).bht();
    }
    AppMethodBeat.o(208933);
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(208929);
    Activity localActivity = (Activity)this.mContext;
    if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
    {
      ad.e("MicroMsg.WebViewFullscreenImpl", "enterFullscreen activity(%s) destroyed", new Object[] { localActivity });
      AppMethodBeat.o(208929);
      return;
    }
    View localView = this.mov;
    this.mov = paramView;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    if (localView == null)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        this.moz = ((ViewGroup)paramView.getParent());
        this.mox = this.moz.indexOfChild(paramView);
        this.moy = paramView.getLayoutParams();
        this.moz.removeView(paramView);
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
        this.moQ = paramView.getSystemUiVisibility();
      }
      if (!d.lz(19)) {
        break label368;
      }
      paramView.setSystemUiVisibility(2);
      label197:
      if (localView == null)
      {
        this.moR = new WindowManager.LayoutParams();
        this.moR.copyFrom(localActivity.getWindow().getAttributes());
      }
      localActivity.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28) {
        localActivity.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
      }
      if (localView == null)
      {
        this.EpL = localActivity.getRequestedOrientation();
        ad.d("MicroMsg.WebViewFullscreenImpl", "enterFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.EpL) });
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
      bwJ();
      AppMethodBeat.o(208929);
      return;
      this.mox = 0;
      this.moz = null;
      this.moy = null;
      break;
      label368:
      paramView.setSystemUiVisibility(4102);
      break label197;
      localActivity.setRequestedOrientation(0);
      continue;
      localActivity.setRequestedOrientation(8);
      continue;
      localActivity.setRequestedOrientation(1);
    }
  }
  
  public final boolean aXV()
  {
    AppMethodBeat.i(208930);
    if (this.mov == null)
    {
      AppMethodBeat.o(208930);
      return false;
    }
    Object localObject = (Activity)this.mContext;
    if ((localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()))
    {
      ad.e("MicroMsg.WebViewFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localObject });
      AppMethodBeat.o(208930);
      return false;
    }
    ((ViewGroup)((Activity)localObject).getWindow().getDecorView()).setSystemUiVisibility(this.moQ);
    ((Activity)localObject).getWindow().clearFlags(1024);
    if (this.moR != null) {
      ((Activity)localObject).getWindow().setAttributes(this.moR);
    }
    ((Activity)localObject).setRequestedOrientation(this.EpL);
    ad.d("MicroMsg.WebViewFullscreenImpl", "exitFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.EpL) });
    if (this.moz != null)
    {
      if ((this.mov.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.mov.getParent()).removeView(this.mov);
      }
      this.moz.addView(this.mov, this.mox, this.moy);
    }
    this.mov = null;
    f.e(false, true, true);
    localObject = this.moA.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).DA();
    }
    AppMethodBeat.o(208930);
    return true;
  }
  
  public final boolean bmN()
  {
    return this.mov != null;
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(208931);
    if (!this.moA.contains(paramb)) {
      this.moA.add(paramb);
    }
    AppMethodBeat.o(208931);
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(208932);
    this.moA.remove(paramb);
    AppMethodBeat.o(208932);
  }
  
  public final void release()
  {
    AppMethodBeat.i(208928);
    this.moA.clear();
    AppMethodBeat.o(208928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.a
 * JD-Core Version:    0.7.0.1
 */