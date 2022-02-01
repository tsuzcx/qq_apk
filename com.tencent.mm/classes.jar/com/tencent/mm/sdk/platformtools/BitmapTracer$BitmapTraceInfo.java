package com.tencent.mm.sdk.platformtools;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class BitmapTracer$BitmapTraceInfo
{
  final long acquiredTime;
  final BitmapFactory.Options options;
  final String source;
  final StackTraceElement[] stack;
  
  BitmapTracer$BitmapTraceInfo(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(243773);
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    this.stack = ((StackTraceElement[])Arrays.copyOfRange(arrayOfStackTraceElement, 4, arrayOfStackTraceElement.length));
    this.source = paramString;
    this.options = paramOptions;
    this.acquiredTime = System.currentTimeMillis();
    AppMethodBeat.o(243773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BitmapTracer.BitmapTraceInfo
 * JD-Core Version:    0.7.0.1
 */