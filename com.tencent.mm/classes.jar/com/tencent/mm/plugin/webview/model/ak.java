package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/TopStoryWebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "enterTime", "", "getEnterTime", "()J", "lastResumeTime", "maxScrollY", "", "publishId", "", "scene", "stayTime", "totalScrollY", "onPause", "", "onResume", "report", "setMaxScrollY", "setPublishId", "setScene", "setTotalScrollY", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
{
  public int WMd;
  public final long enterTime;
  public long hTS;
  public String mso;
  public long qvl;
  public int scene;
  public int uiX;
  
  public ak()
  {
    AppMethodBeat.i(298181);
    this.qvl = -1L;
    this.enterTime = System.currentTimeMillis();
    this.WMd = a.mt(MMApplicationContext.getContext());
    this.uiX = a.mt(MMApplicationContext.getContext());
    AppMethodBeat.o(298181);
  }
  
  private static final void g(Bundle paramBundle, f paramf)
  {
    AppMethodBeat.i(298188);
    h.ber(paramBundle.getString("reportString"));
    AppMethodBeat.o(298188);
  }
  
  public final void report()
  {
    AppMethodBeat.i(298206);
    if (!Util.isNullOrNil(this.mso))
    {
      localObject = this.mso;
      s.checkNotNull(localObject);
      if (n.U((String)localObject, "wrd", false)) {}
    }
    else
    {
      AppMethodBeat.o(298206);
      return;
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("iswebviewreadtime=1");
    ((StringBuffer)localObject).append("&publishid=");
    ((StringBuffer)localObject).append(this.mso);
    ((StringBuffer)localObject).append("&staytime=");
    ((StringBuffer)localObject).append(this.hTS);
    ((StringBuffer)localObject).append("&allstaytime=");
    ((StringBuffer)localObject).append(System.currentTimeMillis() - this.enterTime);
    ((StringBuffer)localObject).append("&maxscrolly=");
    ((StringBuffer)localObject).append(this.WMd);
    ((StringBuffer)localObject).append("&totalscrolly=");
    ((StringBuffer)localObject).append(this.uiX);
    ((StringBuffer)localObject).append("&scene=");
    ((StringBuffer)localObject).append(this.scene);
    ((StringBuffer)localObject).append("&entertime=");
    ((StringBuffer)localObject).append(this.enterTime);
    ((StringBuffer)localObject).append("&screenheight=");
    ((StringBuffer)localObject).append(a.mt(MMApplicationContext.getContext()));
    Bundle localBundle = new Bundle();
    localBundle.putString("reportString", ((StringBuffer)localObject).toString());
    try
    {
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, ak..ExternalSyntheticLambda0.INSTANCE.getClass(), null);
      AppMethodBeat.o(298206);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException, "TopStory report", new Object[0]);
      AppMethodBeat.o(298206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ak
 * JD-Core Version:    0.7.0.1
 */