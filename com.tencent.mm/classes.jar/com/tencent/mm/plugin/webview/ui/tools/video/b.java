package com.tencent.mm.plugin.webview.ui.tools.video;

import android.app.Activity;
import android.content.Context;
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
  public int Xoo;
  public boolean Xop;
  public Context mContext;
  public View tKX;
  public int tKZ;
  public ViewGroup.LayoutParams tLa;
  public ViewGroup tLb;
  public final Set<c> tLc;
  public int tLv;
  public int tLw;
  public WindowManager.LayoutParams tLx;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(297145);
    this.tLc = Collections.newSetFromMap(new ConcurrentHashMap());
    this.Xop = false;
    this.mContext = paramContext;
    AppMethodBeat.o(297145);
  }
  
  public final boolean IX(boolean paramBoolean)
  {
    AppMethodBeat.i(297159);
    if (this.tKX == null)
    {
      AppMethodBeat.o(297159);
      return false;
    }
    if (!(this.mContext instanceof Activity))
    {
      AppMethodBeat.o(297159);
      return false;
    }
    Object localObject = (Activity)this.mContext;
    if ((!paramBoolean) && ((localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed())))
    {
      Log.e("MicroMsg.WebViewFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localObject });
      AppMethodBeat.o(297159);
      return false;
    }
    ((ViewGroup)((Activity)localObject).getWindow().getDecorView()).setSystemUiVisibility(this.tLv);
    ((Activity)localObject).getWindow().clearFlags(1024);
    if (this.tLx != null) {
      ((Activity)localObject).getWindow().setAttributes(this.tLx);
    }
    ((Activity)localObject).setRequestedOrientation(this.tLw);
    Log.d("MicroMsg.WebViewFullscreenImpl", "exitFullscreen mStashedOrientation=%d", new Object[] { Integer.valueOf(this.tLw) });
    if (this.tLb != null)
    {
      if ((this.tKX.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.tKX.getParent()).removeView(this.tKX);
      }
      this.tLb.addView(this.tKX, this.tKZ, this.tLa);
      this.tKX.setBackgroundColor(this.Xoo);
    }
    this.tKX = null;
    f.d(false, true, true);
    localObject = this.tLc.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((c)((Iterator)localObject).next()).aqb();
    }
    AppMethodBeat.o(297159);
    return true;
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(297169);
    if (!this.tLc.contains(paramc)) {
      this.tLc.add(paramc);
    }
    AppMethodBeat.o(297169);
  }
  
  public final void cHO()
  {
    AppMethodBeat.i(297181);
    Iterator localIterator = this.tLc.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).cpc();
    }
    AppMethodBeat.o(297181);
  }
  
  public final boolean cuZ()
  {
    return this.tKX != null;
  }
  
  public final void d(c paramc)
  {
    AppMethodBeat.i(297173);
    this.tLc.remove(paramc);
    AppMethodBeat.o(297173);
  }
  
  public final void reset(Context paramContext)
  {
    this.mContext = paramContext;
    this.tLb = null;
    this.tKX = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.b
 * JD-Core Version:    0.7.0.1
 */