package com.tencent.youtu.ytposedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class YTPoseDetectInterface$1
  implements YTPoseDetectInterface.PoseDetectResult
{
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(117768);
    YTPoseDetectInterface.access$100(paramInt, paramString1, paramString2);
    AppMethodBeat.o(117768);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(117767);
    YTPoseDetectInterface.access$000();
    AppMethodBeat.o(117767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.YTPoseDetectInterface.1
 * JD-Core Version:    0.7.0.1
 */