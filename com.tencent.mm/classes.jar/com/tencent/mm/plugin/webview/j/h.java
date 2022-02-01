package com.tencent.mm.plugin.webview.j;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import org.xwalk.core.Log;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/util/WebViewLongClickReportHelper;", "", "()V", "currentOpResult", "", "getCurrentOpResult", "()I", "setCurrentOpResult", "(I)V", "getA8KeyScene", "getGetA8KeyScene", "setGetA8KeyScene", "hasQrCode", "", "getHasQrCode", "()Z", "setHasQrCode", "(Z)V", "imageId", "", "getImageId", "()Ljava/lang/String;", "setImageId", "(Ljava/lang/String;)V", "opScene", "getOpScene", "setOpScene", "scanResult", "getScanResult", "setScanResult", "scanType", "getScanType", "setScanType", "startLongClickTime", "", "getStartLongClickTime", "()J", "setStartLongClickTime", "(J)V", "url", "getUrl", "setUrl", "initScanType", "", "codeType", "report", "opResult", "reset", "Companion", "webview-sdk_release"})
public final class h
{
  public static final a Etu;
  private static final String TAG = "MicroMsg.WebViewLongClickReportHelper";
  private long Etp;
  public boolean Etq;
  private int Etr;
  private String Ets = "";
  private int Ett = -1;
  public int dOE;
  public String scanResult = "";
  public String url = "";
  public String vyg = "";
  
  static
  {
    AppMethodBeat.i(177336);
    Etu = new a((byte)0);
    TAG = "MicroMsg.WebViewLongClickReportHelper";
    AppMethodBeat.o(177336);
  }
  
  public final void XW(int paramInt)
  {
    if (paramInt == 22) {}
    for (String str = "WX_CODE";; str = "QR_CODE")
    {
      this.Ets = str;
      return;
    }
  }
  
  public final void ma(int paramInt)
  {
    AppMethodBeat.i(177335);
    if (this.Ett > 0)
    {
      AppMethodBeat.o(177335);
      return;
    }
    this.Ett = paramInt;
    long l2 = System.currentTimeMillis() - this.Etp;
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
    g localg = g.yhR;
    String str1 = x.aNF(this.url);
    String str2 = a.Xt(this.url);
    if (this.Etq) {}
    for (int i = 1;; i = 0)
    {
      localg.f(19208, new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(this.dOE), Integer.valueOf(this.Etr), Long.valueOf(l1), x.aNF(this.scanResult), this.Ets, Integer.valueOf(paramInt), this.vyg });
      AppMethodBeat.o(177335);
      return;
    }
  }
  
  public final void reset(int paramInt)
  {
    AppMethodBeat.i(177334);
    this.Etr = paramInt;
    this.Etp = System.currentTimeMillis();
    AppMethodBeat.o(177334);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/util/WebViewLongClickReportHelper$Companion;", "", "()V", "TAG", "", "opResultCancel", "", "opResultFav", "opResultRecQrCode", "opResultSavePic", "opResultSendToFriend", "opResultTranslate", "getUrlId", "url", "webview-sdk_release"})
  public static final class a
  {
    public static String Xt(String paramString)
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
        l = bt.getLong(paramString.getQueryParameter("mid"), 0L);
        i = bt.getInt(paramString.getQueryParameter("idx"), 0);
        if ((bt.isNullOrNil(str)) || (l < 0L))
        {
          AppMethodBeat.o(177333);
          return "";
        }
      }
      catch (Exception paramString)
      {
        Log.e(h.access$getTAG$cp(), "getUrlId ex " + paramString.getMessage());
        AppMethodBeat.o(177333);
        return "";
      }
      paramString = "id://local/i.html?__biz=" + str + "&mid=" + l + "&idx=" + i;
      Log.d(h.access$getTAG$cp(), "urlId=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(177333);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.h
 * JD-Core Version:    0.7.0.1
 */