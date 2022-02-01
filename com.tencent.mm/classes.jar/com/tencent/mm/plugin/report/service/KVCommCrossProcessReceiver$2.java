package com.tencent.mm.plugin.report.service;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class KVCommCrossProcessReceiver$2
  implements Runnable
{
  KVCommCrossProcessReceiver$2(KVCommCrossProcessReceiver paramKVCommCrossProcessReceiver, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(143820);
    Log.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    KVCommCrossProcessReceiver.a(this.OzP, this.val$intent);
    AppMethodBeat.o(143820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver.2
 * JD-Core Version:    0.7.0.1
 */