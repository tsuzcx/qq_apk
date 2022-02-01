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
  private int JxP;
  public boolean JxQ;
  public Context mContext;
  private int nEA;
  private WindowManager.LayoutParams nEB;
  private View nEb;
  private int nEd;
  private ViewGroup.LayoutParams nEe;
  private ViewGroup nEf;
  private final Set<c> nEg;
  private int nEz;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(212052);
    this.nEg = Collections.newSetFromMap(new ConcurrentHashMap());
    this.JxQ = false;
    this.mContext = paramContext;
    AppMethodBeat.o(212052);
  }
  
  private void bTL()
  {
    AppMethodBeat.i(212058);
    Iterator localIterator = this.nEg.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).bDq();
    }
    AppMethodBeat.o(212058);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(212054);
    Activity localActivity = (Activity)this.mContext;
    if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
    {
      Log.e("MicroMsg.WebViewFullscreenImpl", "enterFullscreen activity(%s) destroyed", new Object[] { localActivity });
      AppMethodBeat.o(212054);
      return;
    }
    View localView = this.nEb;
    this.nEb = paramView;
    ViewGroup localViewGroup = (ViewGroup)localActivity.getWindow().getDecorView();
    if (localView == null)
    {
      if ((paramView.getParent() instanceof ViewGroup))
      {
        this.nEf = ((ViewGroup)paramView.getParent());
        this.nEd = this.nEf.indexOfChild(paramView);
        this.nEe = paramView.getLayoutParams();
        this.nEf.removeView(paramView);
        this.JxP = this.nEb.getDrawingCacheBackgroundColor();
        this.nEb.setBackgroundColor(-16777216);
        localViewGroup.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
        localViewGroup.bringChildToFront(paramView);
        paramView.setX(0.0F);
        paramView.setY(0.0F);
      }
    }
    else
    {
      if (localView == null) {
        this.nEz = localViewGroup.getSystemUiVisibility();
      }
      localViewGroup.setSystemUiVisibility(5894);
      if (localView == null)
      {
        this.nEB = new WindowManager.LayoutParams();
        this.nEB.copyFrom(localActivity.getWindow().getAttributes());
      }
      localActivity.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28) {
        localActivity.getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
      }
      if (localView == null)
      {
        this.nEA = localActivity.getRequestedOrientation();
        Log.d("MicroMsg.WebViewFullscreenImpl", "enterFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.nEA) });
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
      bTL();
      AppMethodBeat.o(212054);
      return;
      this.nEd = 0;
      this.nEf = null;
      this.nEe = null;
      break;
      localActivity.setRequestedOrientation(0);
      continue;
      localActivity.setRequestedOrientation(8);
      continue;
      localActivity.setRequestedOrientation(1);
    }
  }
  
  public final boolean bJb()
  {
    return this.nEb != null;
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(212056);
    if (!this.nEg.contains(paramc)) {
      this.nEg.add(paramc);
    }
    AppMethodBeat.o(212056);
  }
  
  public final void d(c paramc)
  {
    AppMethodBeat.i(212057);
    this.nEg.remove(paramc);
    AppMethodBeat.o(212057);
  }
  
  public final void release()
  {
    AppMethodBeat.i(212053);
    this.nEg.clear();
    AppMethodBeat.o(212053);
  }
  
  public final boolean zr(boolean paramBoolean)
  {
    AppMethodBeat.i(212055);
    if (this.nEb == null)
    {
      AppMethodBeat.o(212055);
      return false;
    }
    Object localObject = (Activity)this.mContext;
    if ((!paramBoolean) && ((localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed())))
    {
      Log.e("MicroMsg.WebViewFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localObject });
      AppMethodBeat.o(212055);
      return false;
    }
    ((ViewGroup)((Activity)localObject).getWindow().getDecorView()).setSystemUiVisibility(this.nEz);
    ((Activity)localObject).getWindow().clearFlags(1024);
    if (this.nEB != null) {
      ((Activity)localObject).getWindow().setAttributes(this.nEB);
    }
    ((Activity)localObject).setRequestedOrientation(this.nEA);
    Log.d("MicroMsg.WebViewFullscreenImpl", "exitFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.nEA) });
    if (this.nEf != null)
    {
      if ((this.nEb.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.nEb.getParent()).removeView(this.nEb);
      }
      this.nEf.addView(this.nEb, this.nEd, this.nEe);
      this.nEb.setBackgroundColor(this.JxP);
    }
    this.nEb = null;
    f.e(false, true, true);
    localObject = this.nEg.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((c)((Iterator)localObject).next()).Na();
    }
    AppMethodBeat.o(212055);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.b
 * JD-Core Version:    0.7.0.1
 */