package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AssetExportSession$AssetExportSessionStatus
{
  static
  {
    AppMethodBeat.i(188473);
    AssetExportSessionStatusUnknown = new AssetExportSessionStatus("AssetExportSessionStatusUnknown", 0);
    AssetExportSessionStatusExporting = new AssetExportSessionStatus("AssetExportSessionStatusExporting", 1);
    AssetExportSessionStatusCompleted = new AssetExportSessionStatus("AssetExportSessionStatusCompleted", 2);
    AssetExportSessionStatusFailed = new AssetExportSessionStatus("AssetExportSessionStatusFailed", 3);
    AssetExportSessionStatusCancelled = new AssetExportSessionStatus("AssetExportSessionStatusCancelled", 4);
    AssetExportSessionStatusTimeout = new AssetExportSessionStatus("AssetExportSessionStatusTimeout", 5);
    $VALUES = new AssetExportSessionStatus[] { AssetExportSessionStatusUnknown, AssetExportSessionStatusExporting, AssetExportSessionStatusCompleted, AssetExportSessionStatusFailed, AssetExportSessionStatusCancelled, AssetExportSessionStatusTimeout };
    AppMethodBeat.o(188473);
  }
  
  private AssetExportSession$AssetExportSessionStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportSession.AssetExportSessionStatus
 * JD-Core Version:    0.7.0.1
 */