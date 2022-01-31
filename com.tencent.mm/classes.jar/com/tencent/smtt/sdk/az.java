package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

class az
  implements n.a
{
  az(TbsLogReport paramTbsLogReport) {}
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(64480);
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(64480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.az
 * JD-Core Version:    0.7.0.1
 */