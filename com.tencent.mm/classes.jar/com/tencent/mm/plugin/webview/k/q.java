package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xwalk.core.Log;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewLongClickReportHelper;", "", "()V", "currentOpResult", "", "getCurrentOpResult", "()I", "setCurrentOpResult", "(I)V", "getA8KeyScene", "getGetA8KeyScene", "setGetA8KeyScene", "hasQrCode", "", "getHasQrCode", "()Z", "setHasQrCode", "(Z)V", "imageId", "", "getImageId", "()Ljava/lang/String;", "setImageId", "(Ljava/lang/String;)V", "opScene", "getOpScene", "setOpScene", "scanResult", "getScanResult", "setScanResult", "scanType", "getScanType", "setScanType", "startLongClickTime", "", "getStartLongClickTime", "()J", "setStartLongClickTime", "(J)V", "url", "getUrl", "setUrl", "initScanType", "", "codeType", "report", "opResult", "reset", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  private static final String TAG;
  public static final a Xtr;
  public String KEa = "";
  private long Xts;
  public boolean Xtt;
  private int Xtu;
  private String Xtv = "";
  private int Xtw = -1;
  public int iiA;
  public String scanResult = "";
  public String url = "";
  
  static
  {
    AppMethodBeat.i(177336);
    Xtr = new a((byte)0);
    TAG = "MicroMsg.WebViewLongClickReportHelper";
    AppMethodBeat.o(177336);
  }
  
  public final void avd(int paramInt)
  {
    if (paramInt == 22) {}
    for (String str = "WX_CODE";; str = "QR_CODE")
    {
      this.Xtv = str;
      return;
    }
  }
  
  public final void iF(int paramInt)
  {
    AppMethodBeat.i(177334);
    this.Xtu = paramInt;
    this.Xts = System.currentTimeMillis();
    AppMethodBeat.o(177334);
  }
  
  public final void rG(int paramInt)
  {
    AppMethodBeat.i(177335);
    if (this.Xtw > 0)
    {
      AppMethodBeat.o(177335);
      return;
    }
    this.Xtw = paramInt;
    long l2 = System.currentTimeMillis() - this.Xts;
    long l1;
    if (l2 >= 0L)
    {
      l1 = l2;
      if (l2 <= 86400000L) {}
    }
    else
    {
      l1 = 0L;
    }
    h localh = h.OAn;
    String str1 = aa.aUC(this.url);
    String str2 = a.ajr(this.url);
    if (this.Xtt) {}
    for (int i = 1;; i = 0)
    {
      localh.b(19208, new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(this.iiA), Integer.valueOf(this.Xtu), Long.valueOf(l1), aa.aUC(this.scanResult), this.Xtv, Integer.valueOf(paramInt), this.KEa });
      AppMethodBeat.o(177335);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewLongClickReportHelper$Companion;", "", "()V", "TAG", "", "opResultCancel", "", "opResultFav", "opResultRecQrCode", "opResultSavePic", "opResultSendToFriend", "opResultSoso", "opResultTranslate", "getUrlId", "url", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String ajr(String paramString)
    {
      AppMethodBeat.i(177333);
      if (paramString == null)
      {
        AppMethodBeat.o(177333);
        return "";
      }
      String str;
      long l;
      int i;
      try
      {
        paramString = Uri.parse(paramString);
        str = paramString.getQueryParameter("__biz");
        l = Util.getLong(paramString.getQueryParameter("mid"), 0L);
        i = Util.getInt(paramString.getQueryParameter("idx"), 0);
        if ((Util.isNullOrNil(str)) || (l < 0L))
        {
          AppMethodBeat.o(177333);
          return "";
        }
      }
      catch (Exception paramString)
      {
        Log.e(q.access$getTAG$cp(), s.X("getUrlId ex ", paramString.getMessage()));
        AppMethodBeat.o(177333);
        return "";
      }
      paramString = "id://local/i.html?__biz=" + str + "&mid=" + l + "&idx=" + i;
      Log.d(q.access$getTAG$cp(), s.X("urlId=", paramString));
      AppMethodBeat.o(177333);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.q
 * JD-Core Version:    0.7.0.1
 */