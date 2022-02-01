package com.tencent.xweb.xwalk.a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.l;
import com.tencent.xweb.xwalk.updater.d;
import org.xwalk.core.XWebDownloader.DownloadInfo;
import org.xwalk.core.XWebDownloader.DownloadListener;

public final class h
  implements XWebDownloader.DownloadListener
{
  private final m aipL;
  private final g aipM;
  private final d aipN;
  private final boolean aipO;
  
  public h(m paramm, g paramg, d paramd)
  {
    AppMethodBeat.i(213069);
    this.aipL = paramm;
    this.aipM = paramg;
    this.aipN = paramd;
    if (paramd != null)
    {
      this.aipO = paramd.aiqx;
      AppMethodBeat.o(213069);
      return;
    }
    this.aipO = false;
    AppMethodBeat.o(213069);
  }
  
  public final void onDownloadCancelled()
  {
    AppMethodBeat.i(213087);
    this.aipL.jL(this.aipM.kjs(), -3);
    l.eM(this.aipM.kjs(), this.aipO);
    a.bIp(this.aipM.kjs()).e(null);
    AppMethodBeat.o(213087);
  }
  
  public final void onDownloadCompleted(XWebDownloader.DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(213088);
    l.eL(this.aipM.kjs(), this.aipO);
    a.bIp(this.aipM.kjs()).e(null);
    new AsyncTask() {}.execute(new Void[0]);
    AppMethodBeat.o(213088);
  }
  
  public final void onDownloadFailed(XWebDownloader.DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(213091);
    this.aipL.jL(this.aipM.kjs(), -1);
    l.eM(this.aipM.kjs(), this.aipO);
    a.bIp(this.aipM.kjs()).e(null);
    AppMethodBeat.o(213091);
  }
  
  public final void onDownloadStarted(int paramInt)
  {
    AppMethodBeat.i(213078);
    l.eK(this.aipM.kjs(), this.aipO);
    AppMethodBeat.o(213078);
  }
  
  public final void onDownloadUpdated(int paramInt)
  {
    AppMethodBeat.i(213083);
    m localm = this.aipL;
    String str = this.aipM.kjs();
    if ((localm.aipY.aiqi == 3) && (localm.kjK()) && (localm.aipU.equals(str))) {
      localm.aipV.aJu(paramInt);
    }
    AppMethodBeat.o(213083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.h
 * JD-Core Version:    0.7.0.1
 */