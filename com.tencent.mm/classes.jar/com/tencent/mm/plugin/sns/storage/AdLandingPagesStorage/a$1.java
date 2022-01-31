package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements m
{
  a$1(a parama) {}
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36922);
    if (this.rrw.rcJ != null) {
      this.rrw.rcJ.failed(paramLong);
    }
    this.rrw.ad(8, paramLong);
    AppMethodBeat.o(36922);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36921);
    if (this.rrw.rcJ != null) {
      this.rrw.rcJ.succeed(paramLong);
    }
    this.rrw.ad(3, paramLong);
    AppMethodBeat.o(36921);
  }
  
  public final void hx(long paramLong)
  {
    AppMethodBeat.i(36925);
    ab.i("MicroMsg.AdDownloadApkMgr", "%d progress changed", new Object[] { Long.valueOf(paramLong) });
    if (this.rrw.rcJ != null)
    {
      FileDownloadTaskInfo localFileDownloadTaskInfo = f.bjl().iA(paramLong);
      if ((localFileDownloadTaskInfo.kYX >= 0L) && (localFileDownloadTaskInfo.jyU > 0L)) {
        this.rrw.rcJ.progress(paramLong, (int)(localFileDownloadTaskInfo.kYX * 100L / localFileDownloadTaskInfo.jyU));
      }
    }
    AppMethodBeat.o(36925);
  }
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(36926);
    if (this.rrw.rcJ != null) {
      this.rrw.rcJ.resumed(paramLong);
    }
    this.rrw.ad(7, paramLong);
    AppMethodBeat.o(36926);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(36924);
    if (this.rrw.rcJ != null) {
      this.rrw.rcJ.paused(paramLong);
    }
    this.rrw.ad(6, paramLong);
    AppMethodBeat.o(36924);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(36923);
    if (this.rrw.rcJ != null) {
      this.rrw.rcJ.stopped(paramLong);
    }
    this.rrw.ad(2, paramLong);
    AppMethodBeat.o(36923);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(36920);
    this.rrw.ad(1, paramLong);
    AppMethodBeat.o(36920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.1
 * JD-Core Version:    0.7.0.1
 */