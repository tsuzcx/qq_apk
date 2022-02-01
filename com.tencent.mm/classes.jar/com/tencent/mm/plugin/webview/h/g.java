package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/reporter/WebViewBrowseHistoryReportInfo;", "", "()V", "TAG", "", "pageInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/reporter/WebViewBrowseHistoryReportInfo$BrowsePageInfo;", "Lkotlin/collections/ArrayList;", "appendReportInfoWithLimit", "", "info", "generateReportString", "setLastBrowsePageStayTime", "exitTime", "", "BrowsePageInfo", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private final String TAG;
  public final ArrayList<a> WQT;
  
  public g()
  {
    AppMethodBeat.i(294676);
    this.TAG = "WebViewBrowseHistoryReportInfo";
    this.WQT = new ArrayList();
    AppMethodBeat.o(294676);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(294681);
    s.u(parama, "info");
    if (this.WQT.size() > 0) {
      parama.hTS = (parama.zVt - ((a)this.WQT.get(this.WQT.size() - 1)).zVt);
    }
    this.WQT.add(parama);
    AppMethodBeat.o(294681);
  }
  
  public final String iwE()
  {
    AppMethodBeat.i(294688);
    Iterator localIterator = this.WQT.iterator();
    int i = 0;
    String str2 = "";
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (i <= 20)
      {
        String str6 = locala.tgw;
        String str5 = locala.url;
        for (;;)
        {
          try
          {
            str1 = r.as(locala.tgw, "UTF-8");
            s.s(str1, "encode(browsePageInfo.pageTitle, \"UTF-8\")");
          }
          catch (Exception localException1)
          {
            try
            {
              String str3 = r.as(locala.url, "UTF-8");
              s.s(str3, "encode(browsePageInfo.url, \"UTF-8\")");
              str2 = str2 + str3 + ';' + locala.zVt + ';' + locala.hTS + ';' + str1 + "$$$";
              i += 1;
            }
            catch (Exception localException2)
            {
              String str1;
              String str4;
              break label169;
            }
            localException1 = localException1;
            str1 = str6;
          }
          label169:
          Log.printErrStackTrace(this.TAG, (Throwable)localException1, "", new Object[0]);
          str4 = str5;
        }
      }
    }
    AppMethodBeat.o(294688);
    return str2;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/reporter/WebViewBrowseHistoryReportInfo$BrowsePageInfo;", "", "url", "", "enterTimeStamp", "", "pageTitle", "(Ljava/lang/String;JLjava/lang/String;)V", "getEnterTimeStamp", "()J", "getPageTitle", "()Ljava/lang/String;", "stayTime", "getStayTime", "setStayTime", "(J)V", "getUrl", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public long hTS;
    final String tgw;
    final String url;
    public final long zVt;
    
    public a(String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(294692);
      this.url = paramString1;
      this.zVt = paramLong;
      this.tgw = paramString2;
      AppMethodBeat.o(294692);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.g
 * JD-Core Version:    0.7.0.1
 */