package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AssetParallelSegmentStatus
{
  static
  {
    AppMethodBeat.i(215653);
    AssetParallelStatusUnknown = new AssetParallelSegmentStatus("AssetParallelStatusUnknown", 0);
    AssetParallelStatusPrepared = new AssetParallelSegmentStatus("AssetParallelStatusPrepared", 1);
    AssetParallelStatusStarted = new AssetParallelSegmentStatus("AssetParallelStatusStarted", 2);
    AssetParallelStatusWaiting = new AssetParallelSegmentStatus("AssetParallelStatusWaiting", 3);
    AssetReaderStatusReadFinish = new AssetParallelSegmentStatus("AssetReaderStatusReadFinish", 4);
    AssetReaderStatusWriteFinish = new AssetParallelSegmentStatus("AssetReaderStatusWriteFinish", 5);
    AssetExportStatusCompleted = new AssetParallelSegmentStatus("AssetExportStatusCompleted", 6);
    AssetParallelStatusFailed = new AssetParallelSegmentStatus("AssetParallelStatusFailed", 7);
    AssetParallelStatusCancelled = new AssetParallelSegmentStatus("AssetParallelStatusCancelled", 8);
    AssetParallelStatusTimeout = new AssetParallelSegmentStatus("AssetParallelStatusTimeout", 9);
    $VALUES = new AssetParallelSegmentStatus[] { AssetParallelStatusUnknown, AssetParallelStatusPrepared, AssetParallelStatusStarted, AssetParallelStatusWaiting, AssetReaderStatusReadFinish, AssetReaderStatusWriteFinish, AssetExportStatusCompleted, AssetParallelStatusFailed, AssetParallelStatusCancelled, AssetParallelStatusTimeout };
    AppMethodBeat.o(215653);
  }
  
  private AssetParallelSegmentStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetParallelSegmentStatus
 * JD-Core Version:    0.7.0.1
 */