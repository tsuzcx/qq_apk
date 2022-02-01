package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AVAssetReaderStatus
{
  static
  {
    AppMethodBeat.i(215184);
    AssetReaderStatusUnknown = new AVAssetReaderStatus("AssetReaderStatusUnknown", 0);
    AssetReaderStatusReading = new AVAssetReaderStatus("AssetReaderStatusReading", 1);
    AssetReaderStatusCompleted = new AVAssetReaderStatus("AssetReaderStatusCompleted", 2);
    AssetReaderStatusFailed = new AVAssetReaderStatus("AssetReaderStatusFailed", 3);
    AssetReaderStatusCancelled = new AVAssetReaderStatus("AssetReaderStatusCancelled", 4);
    $VALUES = new AVAssetReaderStatus[] { AssetReaderStatusUnknown, AssetReaderStatusReading, AssetReaderStatusCompleted, AssetReaderStatusFailed, AssetReaderStatusCancelled };
    AppMethodBeat.o(215184);
  }
  
  private AVAssetReaderStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AVAssetReaderStatus
 * JD-Core Version:    0.7.0.1
 */