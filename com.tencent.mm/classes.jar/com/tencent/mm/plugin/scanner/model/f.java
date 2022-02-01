package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineEngineLogReporter;", "", "()V", "report", "", "performance", "Lcom/tencent/mm/plugin/scanner/decoder/ReIdAiScanImageDecodeQueue$Performance;", "Lcom/tencent/mm/plugin/scanner/decoder/ReIdAiScanImageDecodeQueue;", "modelVersion", "", "combineFlowCount", "combineFlowSkipWorkingCount", "combineFlowSkipCount", "combineFlowHandleCount", "engineHandleCount", "engineHandleFailedCount", "engineHandleSucCount", "engineHandleSucFirstFrame", "svrHandleCount", "svrHandleFailCount", "svrHandleSucCount", "svrHandleSucFirstFrame", "tentativeCount", "maxScore2ConfirmedCount", "tentative2ConfirmedCount", "tentative2DeletedCount", "confirmed2MissCount", "miss2DeletedCount", "Miss2ConfirmedCount", "doudiCount", "detectAvg", "detectMax", "combineFlowSkipSensorCount", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f ORq;
  
  static
  {
    AppMethodBeat.i(314407);
    ORq = new f();
    AppMethodBeat.o(314407);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14)
  {
    AppMethodBeat.i(314400);
    h.OAn.b(24190, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), Integer.valueOf(paramInt10), Integer.valueOf(paramInt11), Integer.valueOf(paramInt12), Integer.valueOf(paramInt13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt14) });
    AppMethodBeat.o(314400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.f
 * JD-Core Version:    0.7.0.1
 */