package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AssetWriterStatus
{
  static
  {
    AppMethodBeat.i(215393);
    AssetWriterStatusUnknown = new AssetWriterStatus("AssetWriterStatusUnknown", 0);
    AssetWriterStatusWriting = new AssetWriterStatus("AssetWriterStatusWriting", 1);
    AssetWriterStatusCompleted = new AssetWriterStatus("AssetWriterStatusCompleted", 2);
    AssetWriterStatusFailed = new AssetWriterStatus("AssetWriterStatusFailed", 3);
    AssetWriterStatusCancelled = new AssetWriterStatus("AssetWriterStatusCancelled", 4);
    $VALUES = new AssetWriterStatus[] { AssetWriterStatusUnknown, AssetWriterStatusWriting, AssetWriterStatusCompleted, AssetWriterStatusFailed, AssetWriterStatusCancelled };
    AppMethodBeat.o(215393);
  }
  
  private AssetWriterStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterStatus
 * JD-Core Version:    0.7.0.1
 */