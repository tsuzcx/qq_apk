package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AssetReader$AVAssetReaderStatus
{
  static
  {
    AppMethodBeat.i(188749);
    AssetReaderStatusUnknown = new AVAssetReaderStatus("AssetReaderStatusUnknown", 0);
    AssetReaderStatusReading = new AVAssetReaderStatus("AssetReaderStatusReading", 1);
    AssetReaderStatusCompleted = new AVAssetReaderStatus("AssetReaderStatusCompleted", 2);
    AssetReaderStatusFailed = new AVAssetReaderStatus("AssetReaderStatusFailed", 3);
    AssetReaderStatusCancelled = new AVAssetReaderStatus("AssetReaderStatusCancelled", 4);
    $VALUES = new AVAssetReaderStatus[] { AssetReaderStatusUnknown, AssetReaderStatusReading, AssetReaderStatusCompleted, AssetReaderStatusFailed, AssetReaderStatusCancelled };
    AppMethodBeat.o(188749);
  }
  
  private AssetReader$AVAssetReaderStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AssetReader.AVAssetReaderStatus
 * JD-Core Version:    0.7.0.1
 */