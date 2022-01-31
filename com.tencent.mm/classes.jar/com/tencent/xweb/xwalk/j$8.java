package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.g;
import org.xwalk.core.XWalkGetImageBitmapToFileFinishedCallback;

final class j$8
  extends XWalkGetImageBitmapToFileFinishedCallback
{
  j$8(j paramj, g paramg) {}
  
  public final void onFinishImageBitmapToFile(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(139596);
    this.BKb.bD(paramInt1, paramString2);
    AppMethodBeat.o(139596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.8
 * JD-Core Version:    0.7.0.1
 */