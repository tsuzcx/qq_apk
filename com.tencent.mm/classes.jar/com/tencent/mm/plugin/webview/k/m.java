package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebViewLongClickReportHelper;", "", "()V", "currentOpResult", "", "getCurrentOpResult", "()I", "setCurrentOpResult", "(I)V", "getA8KeyScene", "getGetA8KeyScene", "setGetA8KeyScene", "hasQrCode", "", "getHasQrCode", "()Z", "setHasQrCode", "(Z)V", "imageId", "", "getImageId", "()Ljava/lang/String;", "setImageId", "(Ljava/lang/String;)V", "opScene", "getOpScene", "setOpScene", "scanResult", "getScanResult", "setScanResult", "scanType", "getScanType", "setScanType", "startLongClickTime", "", "getStartLongClickTime", "()J", "setStartLongClickTime", "(J)V", "url", "getUrl", "setUrl", "initScanType", "", "codeType", "report", "opResult", "reset", "Companion", "webview-sdk_release"})
public final class m
{
  public static final a QAp;
  private static final String TAG = "MicroMsg.WebViewLongClickReportHelper";
  public String EKt = "";
  private long QAk;
  public boolean QAl;
  private int QAm;
  private String QAn = "";
  private int QAo = -1;
  public int gco;
  public String scanResult = "";
  public String url = "";
  
  static
  {
    AppMethodBeat.i(177336);
    QAp = new a((byte)0);
    TAG = "MicroMsg.WebViewLongClickReportHelper";
    AppMethodBeat.o(177336);
  }
  
  public final void apf(int paramInt)
  {
    if (paramInt == 22) {}
    for (String str = "WX_CODE";; str = "QR_CODE")
    {
      this.QAn = str;
      return;
    }
  }
  
  public final void fs(int paramInt)
  {
    AppMethodBeat.i(177334);
    this.QAm = paramInt;
    this.QAk = System.currentTimeMillis();
    AppMethodBeat.o(177334);
  }
  
  public final void rE(int paramInt)
  {
    AppMethodBeat.i(177335);
    if (this.QAo > 0)
    {
      AppMethodBeat.o(177335);
      return;
    }
    this.QAo = paramInt;
    long l2 = System.currentTimeMillis() - this.QAk;
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
    h localh = h.IzE;
    String str1 = ab.aXb(this.url);
    String str2 = a.apQ(this.url);
    if (this.QAl) {}
    for (int i = 1;; i = 0)
    {
      localh.a(19208, new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(this.gco), Integer.valueOf(this.QAm), Long.valueOf(l1), ab.aXb(this.scanResult), this.QAn, Integer.valueOf(paramInt), this.EKt });
      AppMethodBeat.o(177335);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebViewLongClickReportHelper$Companion;", "", "()V", "TAG", "", "opResultCancel", "", "opResultFav", "opResultRecQrCode", "opResultSavePic", "opResultSendToFriend", "opResultSoso", "opResultTranslate", "getUrlId", "url", "webview-sdk_release"})
  public static final class a
  {
    public static String apQ(String paramString)
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
        Log.e(m.access$getTAG$cp(), "getUrlId ex " + paramString.getMessage());
        AppMethodBeat.o(177333);
        return "";
      }
      paramString = "id://local/i.html?__biz=" + str + "&mid=" + l + "&idx=" + i;
      Log.d(m.access$getTAG$cp(), "urlId=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(177333);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.m
 * JD-Core Version:    0.7.0.1
 */