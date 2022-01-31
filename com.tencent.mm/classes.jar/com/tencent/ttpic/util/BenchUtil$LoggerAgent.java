package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;

public class BenchUtil$LoggerAgent
{
  public void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(83809);
    if (BenchUtil.ENABLE_LOG) {
      LogUtils.d(paramString1, paramString2);
    }
    AppMethodBeat.o(83809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.util.BenchUtil.LoggerAgent
 * JD-Core Version:    0.7.0.1
 */