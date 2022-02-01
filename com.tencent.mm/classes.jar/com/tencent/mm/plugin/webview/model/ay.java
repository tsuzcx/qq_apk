package com.tencent.mm.plugin.webview.model;

import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.plugin.webview.h.g;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/model/WebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "appId", "", "browseHistoryWebControllerReportInfo", "Lcom/tencent/mm/plugin/webview/reporter/WebViewBrowseHistoryReportInfo;", "chattype", "", "desc", "enterTime", "", "expidstr", "hasShowKeyboard", "lastResumeTime", "mPreUsername", "mPreviousUrl", "messageId", "messageIndex", "newMsgId", "publishId", "publisher", "rawUrl", "scene", "statExtStr", "stayTime", "title", "username", "viewID", "onPause", "", "onResume", "report", "setAppId", "setBrowseHistoryWebControllerReportInfo", "browseInfo", "setChattype", "setDesc", "setExpidstr", "setHasShowKeyboard", "showKeyboard", "", "setMessageId", "setMessageIndex", "setPreUsername", "setPreviousUrl", "url", "setPublishId", "setPublisher", "setRawUrl", "setScene", "setStatExtStr", "setTitle", "setUserName", "setViewID", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
{
  public String WEU;
  public long WMB;
  public int WMC;
  public String WMD;
  public String WME;
  public String WMF;
  public int WMG;
  public int WMH;
  public String WMz;
  public g Wwk;
  public String appId;
  public String desc;
  private final long enterTime;
  public long hTS;
  public String idu;
  public String kLp;
  public String mso;
  public long qvl;
  public int scene;
  public String statExtStr;
  public String title;
  public String username;
  
  public ay()
  {
    AppMethodBeat.i(298234);
    this.title = "";
    this.desc = "";
    this.qvl = -1L;
    this.enterTime = (System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(298234);
  }
  
  private static final void a(ay paramay, IPCString paramIPCString)
  {
    AppMethodBeat.i(298257);
    s.u(paramay, "this$0");
    PString localPString = new PString();
    for (;;)
    {
      try
      {
        str1 = ((l)com.tencent.mm.kernel.h.ax(l.class)).a(paramay.statExtStr, localPString);
        localObject1 = paramay.Wwk;
        if (localObject1 == null)
        {
          str2 = null;
          Log.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s, allStayTime %d, desc: %s, urlList: %s", new Object[] { Integer.valueOf(10643), paramay.username, Long.valueOf(paramay.WMB), Integer.valueOf(paramay.WMC), Integer.valueOf(paramay.scene), Long.valueOf(paramay.enterTime), Long.valueOf(paramay.hTS), paramay.idu, paramay.WEU, paramay.WMz, paramay.mso, paramay.appId, paramay.WMD, paramay.WME, paramIPCString, paramay.WMF, paramay.statExtStr, str1, Integer.valueOf(paramay.WMG), paramay.title, paramay.kLp, localPString.value, Long.valueOf(System.currentTimeMillis() - paramay.enterTime), paramay.desc, str2 });
          str6 = paramay.title;
          str5 = paramay.desc;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = aa.aUC(paramay.title);
          s.s(localObject1, "doUrlEncode(title)");
        }
        catch (Exception localException2)
        {
          String str1;
          Object localObject1;
          String str2;
          String str3;
          com.tencent.mm.plugin.report.service.h localh;
          String str7;
          long l1;
          int i;
          int j;
          long l2;
          long l3;
          String str8;
          String str9;
          String str10;
          String str11;
          String str12;
          String str13;
          Object localObject2 = str6;
        }
        try
        {
          str3 = aa.aUC(paramay.desc);
          s.s(str3, "doUrlEncode(desc)");
          localh = com.tencent.mm.plugin.report.service.h.OAn;
          str7 = paramay.username;
          l1 = paramay.WMB;
          i = paramay.WMC;
          j = paramay.scene;
          l2 = paramay.enterTime;
          l3 = paramay.hTS;
          if (paramay.idu != null) {
            break label696;
          }
          str5 = paramay.idu;
          str8 = paramay.WEU;
          str9 = paramay.WMz;
          str10 = paramay.mso;
          str11 = paramay.appId;
          str12 = paramay.WMD;
          str13 = paramay.WME;
          if (paramay.WMF != null) {
            break label724;
          }
          str6 = paramay.WMF;
          localh.b(10643, new Object[] { str7, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Long.valueOf(l3), str5, str8, str9, str10, str11, str12, str13, paramIPCString, str6, str1, Integer.valueOf(paramay.WMG), localObject1, paramay.kLp, localPString.value, "", "", "", Long.valueOf(System.currentTimeMillis() - paramay.enterTime), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramay.WMH), str3, str2 });
          AppMethodBeat.o(298257);
          return;
        }
        catch (Exception localException3)
        {
          String str4;
          break label673;
        }
        localException1 = localException1;
        str1 = "";
        continue;
        str2 = localException1.iwE();
        continue;
      }
      label673:
      Log.printErrStackTrace("MicroMsg.WebviewReporter", (Throwable)localException2, "", new Object[0]);
      str4 = str5;
      continue;
      label696:
      String str5 = paramay.idu;
      s.checkNotNull(str5);
      str5 = n.m(str5, ",", "!", false);
      continue;
      label724:
      String str6 = paramay.WMF;
      s.checkNotNull(str6);
      str6 = n.m(str6, ",", "!", false);
    }
  }
  
  private static final void g(IPCVoid paramIPCVoid, f paramf)
  {
    AppMethodBeat.i(298243);
    if (!com.tencent.mm.kernel.h.baz()) {}
    for (paramIPCVoid = "";; paramIPCVoid = z.bAM())
    {
      paramf.onCallback(new IPCString(paramIPCVoid));
      AppMethodBeat.o(298243);
      return;
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(298281);
    if (!Util.isNullOrNil(this.WMz)) {
      Log.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", new Object[] { this.WMz });
    }
    try
    {
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)IPCVoid.mzv, ay..ExternalSyntheticLambda0.INSTANCE.getClass(), new ay..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(298281);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", new Object[] { localRemoteException });
      AppMethodBeat.o(298281);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ay
 * JD-Core Version:    0.7.0.1
 */