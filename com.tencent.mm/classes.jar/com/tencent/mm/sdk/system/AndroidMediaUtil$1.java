package com.tencent.mm.sdk.system;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AndroidMediaUtil$1
  implements Runnable
{
  AndroidMediaUtil$1(String paramString, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(210085);
    AndroidMediaUtil.refreshMediaScanner(this.val$path, this.val$context);
    AppMethodBeat.o(210085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.system.AndroidMediaUtil.1
 * JD-Core Version:    0.7.0.1
 */