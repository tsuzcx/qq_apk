package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

final class n
  implements TbsListener
{
  public final void onDownloadFinish(int paramInt)
  {
    AppMethodBeat.i(63991);
    if (TbsDownloader.needDownloadDecoupleCore())
    {
      TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
      TbsDownloader.a = true;
      AppMethodBeat.o(63991);
      return;
    }
    TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
    TbsDownloader.a = false;
    if (QbSdk.c() != null) {
      QbSdk.c().onDownloadFinish(paramInt);
    }
    if (QbSdk.d() != null) {
      QbSdk.d().onDownloadFinish(paramInt);
    }
    AppMethodBeat.o(63991);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(63993);
    if (QbSdk.d() != null) {
      QbSdk.d().onDownloadProgress(paramInt);
    }
    if (QbSdk.c() != null) {
      QbSdk.c().onDownloadProgress(paramInt);
    }
    AppMethodBeat.o(63993);
  }
  
  public final void onInstallFinish(int paramInt)
  {
    AppMethodBeat.i(63992);
    QbSdk.setTBSInstallingStatus(false);
    TbsDownloader.a = false;
    if (TbsDownloader.startDecoupleCoreIfNeeded()) {}
    for (TbsDownloader.a = true;; TbsDownloader.a = false)
    {
      if (QbSdk.c() != null) {
        QbSdk.c().onInstallFinish(paramInt);
      }
      if (QbSdk.d() != null) {
        QbSdk.d().onInstallFinish(paramInt);
      }
      AppMethodBeat.o(63992);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.n
 * JD-Core Version:    0.7.0.1
 */