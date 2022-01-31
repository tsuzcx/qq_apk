package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
  implements TbsListener
{
  l(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public final void onDownloadFinish(int paramInt) {}
  
  public final void onDownloadProgress(int paramInt) {}
  
  public final void onInstallFinish(int paramInt)
  {
    AppMethodBeat.i(63989);
    QbSdk.preInit(this.a, this.b);
    AppMethodBeat.o(63989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */