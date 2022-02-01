package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AssetImageGenerator$AssetImageGeneratorResult
{
  static
  {
    AppMethodBeat.i(215238);
    AssetImageGeneratorSucceeded = new AssetImageGeneratorResult("AssetImageGeneratorSucceeded", 0);
    AssetImageGeneratorFailed = new AssetImageGeneratorResult("AssetImageGeneratorFailed", 1);
    AssetImageGeneratorCancelled = new AssetImageGeneratorResult("AssetImageGeneratorCancelled", 2);
    $VALUES = new AssetImageGeneratorResult[] { AssetImageGeneratorSucceeded, AssetImageGeneratorFailed, AssetImageGeneratorCancelled };
    AppMethodBeat.o(215238);
  }
  
  private AssetImageGenerator$AssetImageGeneratorResult() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tav.core.AssetImageGenerator.AssetImageGeneratorResult
 * JD-Core Version:    0.7.0.1
 */