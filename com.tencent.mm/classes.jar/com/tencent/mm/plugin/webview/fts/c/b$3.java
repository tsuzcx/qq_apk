package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;

final class b$3
  implements b.a
{
  b$3(b paramb, FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void aDk()
  {
    AppMethodBeat.i(5936);
    com.tencent.mm.plugin.webview.fts.ui.b localb = this.uQW.uQT;
    Object localObject1 = localb.JN(localb.iyC);
    float[] arrayOfFloat = localb.iyz;
    if ((localObject1 == null) || (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).iyQ == null) || (arrayOfFloat == null))
    {
      AppMethodBeat.o(5936);
      return;
    }
    localObject1 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).iyQ.get();
    if (localObject1 != null)
    {
      if (localb.iyC != localb.iyy)
      {
        Object localObject2 = localb.JN(localb.iyy);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).iyQ != null))
        {
          localObject2 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).iyQ.get();
          if (localObject2 != null) {
            localb.a(localb.iyy, arrayOfFloat, ((View)localObject2).getVisibility());
          }
        }
      }
      int i = localb.iyC;
      localb.iyy = -1;
      localb.iyC = -1;
      if (localb.uQN != null)
      {
        localb.uQN.aDk();
        localb.uQN = null;
      }
      localb.a(i, arrayOfFloat, ((View)localObject1).getVisibility());
    }
    AppMethodBeat.o(5936);
  }
  
  public final void daM()
  {
    AppMethodBeat.i(5938);
    FtsWebVideoView localFtsWebVideoView = this.uQV;
    if ((!localFtsWebVideoView.efg) && (localFtsWebVideoView.getSystemVolume() == 0)) {
      localFtsWebVideoView.setMute(true);
    }
    AppMethodBeat.o(5938);
  }
  
  public final void daN()
  {
    AppMethodBeat.i(5939);
    FtsWebVideoView localFtsWebVideoView = this.uQV;
    if ((localFtsWebVideoView.efg) && (localFtsWebVideoView.getSystemVolume() > 0)) {
      localFtsWebVideoView.setMute(false);
    }
    AppMethodBeat.o(5939);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(5937);
    if (this.uQV.aEQ())
    {
      this.uQV.ok(false);
      AppMethodBeat.o(5937);
      return true;
    }
    AppMethodBeat.o(5937);
    return false;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(5934);
    FtsWebVideoView localFtsWebVideoView = this.uQV;
    ab.i("MicroMsg.FtsWebVideoView", "onUIPause");
    localFtsWebVideoView.uQi.alo();
    AppMethodBeat.o(5934);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(5935);
    FtsWebVideoView localFtsWebVideoView = this.uQV;
    ab.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
    ab.i("MicroMsg.FtsWebVideoView", "clean");
    localFtsWebVideoView.stop();
    localFtsWebVideoView.uQi.aEM();
    WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = localFtsWebVideoView.uQj;
    if (localWebSearchWebVideoViewControlBar.idl != null) {
      localWebSearchWebVideoViewControlBar.idl.stopTimer();
    }
    if (localWebSearchWebVideoViewControlBar.idk != null) {
      localWebSearchWebVideoViewControlBar.idk.stopTimer();
    }
    try
    {
      localFtsWebVideoView.getContext().unregisterReceiver(localFtsWebVideoView.uQD);
      AppMethodBeat.o(5935);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(5935);
    }
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(5933);
    FtsWebVideoView localFtsWebVideoView = this.uQV;
    ab.i("MicroMsg.FtsWebVideoView", "onUIResume");
    localFtsWebVideoView.uQi.alp();
    AppMethodBeat.o(5933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b.3
 * JD-Core Version:    0.7.0.1
 */