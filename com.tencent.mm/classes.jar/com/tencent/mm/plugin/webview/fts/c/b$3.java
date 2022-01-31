package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class b$3
  implements b.a
{
  b$3(b paramb, FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void ajc()
  {
    com.tencent.mm.plugin.webview.fts.ui.b localb = this.rbo.rbl;
    Object localObject1 = localb.BT(localb.gVp);
    float[] arrayOfFloat = localb.gVm;
    if ((localObject1 == null) || (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).gVz == null) || (arrayOfFloat == null)) {}
    do
    {
      return;
      localObject1 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).gVz.get();
    } while (localObject1 == null);
    if (localb.gVp != localb.gVl)
    {
      Object localObject2 = localb.BT(localb.gVl);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).gVz != null))
      {
        localObject2 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).gVz.get();
        if (localObject2 != null) {
          localb.a(localb.gVl, arrayOfFloat, ((View)localObject2).getVisibility());
        }
      }
    }
    int i = localb.gVp;
    localb.gVl = -1;
    localb.gVp = -1;
    if (localb.rbf != null)
    {
      localb.rbf.ajc();
      localb.rbf = null;
    }
    localb.a(i, arrayOfFloat, ((View)localObject1).getVisibility());
  }
  
  public final void caM()
  {
    FtsWebVideoView localFtsWebVideoView = this.rbn;
    if ((!localFtsWebVideoView.dnJ) && (localFtsWebVideoView.getSystemVolume() == 0)) {
      localFtsWebVideoView.setMute(true);
    }
  }
  
  public final void caN()
  {
    FtsWebVideoView localFtsWebVideoView = this.rbn;
    if ((localFtsWebVideoView.dnJ) && (localFtsWebVideoView.getSystemVolume() > 0)) {
      localFtsWebVideoView.setMute(false);
    }
  }
  
  public final void onDestroy()
  {
    FtsWebVideoView localFtsWebVideoView = this.rbn;
    y.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
    y.i("MicroMsg.FtsWebVideoView", "clean");
    localFtsWebVideoView.stop();
    localFtsWebVideoView.raB.akT();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = localFtsWebVideoView.raC;
    if (localWebSearchWebVideoViewControlBar.gEg != null) {
      localWebSearchWebVideoViewControlBar.gEg.stopTimer();
    }
    if (localWebSearchWebVideoViewControlBar.gEf != null) {
      localWebSearchWebVideoViewControlBar.gEf.stopTimer();
    }
    try
    {
      localFtsWebVideoView.getContext().unregisterReceiver(localFtsWebVideoView.raV);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void pY()
  {
    FtsWebVideoView localFtsWebVideoView = this.rbn;
    y.i("MicroMsg.FtsWebVideoView", "onUIResume");
    localFtsWebVideoView.raB.Sf();
  }
  
  public final void qa()
  {
    FtsWebVideoView localFtsWebVideoView = this.rbn;
    y.i("MicroMsg.FtsWebVideoView", "onUIPause");
    localFtsWebVideoView.raB.Se();
  }
  
  public final boolean qc()
  {
    boolean bool = false;
    if (this.rbn.ake())
    {
      this.rbn.lb(false);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b.3
 * JD-Core Version:    0.7.0.1
 */