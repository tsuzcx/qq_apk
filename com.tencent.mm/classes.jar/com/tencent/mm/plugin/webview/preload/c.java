package com.tencent.mm.plugin.webview.preload;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c
{
  public TmplParams riT;
  public int riU;
  public long riV;
  public long riW;
  public boolean riX;
  public long riY;
  public long riZ;
  public long rja;
  public long rjb;
  public long rjc;
  public long rjd;
  public boolean rje;
  public long rjf;
  public long rjg;
  public boolean rjh = false;
  public boolean rji = false;
  private long rjj;
  private int rjk;
  private long rjl;
  private long rjm;
  private long rjn;
  private long rjo;
  private long rjp;
  public String rjq;
  public String rjr;
  public boolean rjs;
  public String url;
  
  public c()
  {
    if (ae.cqV())
    {
      this.rjr = "mm";
      return;
    }
    if (ae.cqX())
    {
      this.rjr = "tools";
      return;
    }
    if (ae.cqY())
    {
      this.rjr = "toolsmp";
      return;
    }
    this.rjr = "unknow";
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("tmplType: ").append(this.riT.rjv).append("\nmd5: ").append(this.riT.bIW).append("\ntime: ").append(new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new Date(this.riT.ouU))).append("\ntemplateVersion: ").append(this.riT.version).append("\n\ndata: ");
    if (this.riX)
    {
      str = "Sync";
      localStringBuilder = localStringBuilder.append(str).append("\ndataSize: ").append(this.riU).append("\ndataTime: ").append(this.rjm).append("\nwebview: ");
      if (!this.rje) {
        break label284;
      }
    }
    label284:
    for (String str = "preload";; str = "normal")
    {
      return str + "\n\nfinishType: " + this.rjk + "\nfinishTime: " + this.rjl + "\ncompileTime: " + this.rjb + "\nrenderTime: " + this.rjg + "\n\nwebReceivePageDataTime: " + this.rjn + "\na8KeyFinishTime: " + this.rjo + "\ngetA8KeyCostTime: " + this.rjp + "\n\nisOnlineWebView: " + this.rjs + "\nwebviewProcess: " + this.rjr + "\nwebviewKind: " + this.rjq + "\n";
      str = "Async";
      break;
    }
  }
  
  public final void wn()
  {
    if ((!this.rjh) || (!this.rji)) {
      return;
    }
    a.aa(this.riT.rjC, 132, 1);
    String str;
    if (aq.isWifi(ae.getContext()))
    {
      str = "wifi";
      this.rjj = Math.max(this.rjf, this.rjd);
      if (this.rjf <= this.rjc) {
        break label632;
      }
    }
    label632:
    for (int i = 1;; i = 2)
    {
      this.rjk = i;
      this.rjl = (this.rjj - this.riV);
      this.rjm = (this.riZ - this.riY);
      this.rjn = (this.rja - this.riV);
      this.rjo = (this.rjd - this.riV);
      this.rjp = (this.rjd - this.rjc);
      y.d("MicroMsg.Preload.Kv15862", "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, firstScreenRenderCostTime:%d, a8KeyFinishTime:%d, isUsePreloadWebView:%b, loadPageFrameCostTime:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, compileTime:%d, firstScreenRenderCostTime:%d, tmplType:%d tmplFullVersion:%s webviewKind:%s webviewProcess:%s", new Object[] { Integer.valueOf(this.riT.version), this.url, Integer.valueOf(this.riU), str, Long.valueOf(this.rjl), Integer.valueOf(this.rjk), Long.valueOf(this.rjg), Long.valueOf(this.rjo), Boolean.valueOf(this.rje), Long.valueOf(this.riW), Boolean.valueOf(this.riX), Long.valueOf(this.rjm), Long.valueOf(this.rjp), Long.valueOf(this.rjn), Long.valueOf(this.rjb), Long.valueOf(this.rjg), Integer.valueOf(this.riT.rjv), this.riT.rjB, this.rjq, this.rjr });
      h.nFQ.f(15862, new Object[] { Integer.valueOf(this.riT.version), this.url, Integer.valueOf(this.riU), str, Long.valueOf(this.rjl), Integer.valueOf(this.rjk), Long.valueOf(this.rjg), Long.valueOf(this.rjo), Boolean.valueOf(this.rje), Long.valueOf(this.riW), Boolean.valueOf(this.riX), Long.valueOf(this.rjm), Long.valueOf(this.rjp), Long.valueOf(this.rjn), Long.valueOf(this.rjb), Long.valueOf(this.rjg), Integer.valueOf(this.riT.rjv), this.riT.rjB, this.rjq, this.rjr });
      return;
      if (aq.is4G(ae.getContext()))
      {
        str = "4g";
        break;
      }
      if (aq.is3G(ae.getContext()))
      {
        str = "3g";
        break;
      }
      if (aq.is2G(ae.getContext()))
      {
        str = "2g";
        break;
      }
      str = "none";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.c
 * JD-Core Version:    0.7.0.1
 */