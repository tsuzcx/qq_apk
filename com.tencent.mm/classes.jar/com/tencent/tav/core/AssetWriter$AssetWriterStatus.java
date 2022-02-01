package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum AssetWriter$AssetWriterStatus
{
  static
  {
    AppMethodBeat.i(188822);
    AssetWriterStatusUnknown = new AssetWriterStatus("AssetWriterStatusUnknown", 0);
    AssetWriterStatusWriting = new AssetWriterStatus("AssetWriterStatusWriting", 1);
    AssetWriterStatusCompleted = new AssetWriterStatus("AssetWriterStatusCompleted", 2);
    AssetWriterStatusFailed = new AssetWriterStatus("AssetWriterStatusFailed", 3);
    AssetWriterStatusCancelled = new AssetWriterStatus("AssetWriterStatusCancelled", 4);
    $VALUES = new AssetWriterStatus[] { AssetWriterStatusUnknown, AssetWriterStatusWriting, AssetWriterStatusCompleted, AssetWriterStatusFailed, AssetWriterStatusCancelled };
    AppMethodBeat.o(188822);
  }
  
  private AssetWriter$AssetWriterStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriter.AssetWriterStatus
 * JD-Core Version:    0.7.0.1
 */