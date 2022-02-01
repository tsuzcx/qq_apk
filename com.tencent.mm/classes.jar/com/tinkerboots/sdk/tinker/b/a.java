package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.util.c;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public final class a
  extends com.tencent.tinker.lib.d.a
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(File paramFile, int paramInt, long paramLong)
  {
    AppMethodBeat.i(3443);
    super.a(paramFile, paramInt, paramLong);
    Looper.getMainLooper();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(3442);
        c.lp(a.this.context).fYC();
        AppMethodBeat.o(3442);
        return false;
      }
    });
    AppMethodBeat.o(3443);
  }
  
  public final void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(3446);
    super.a(paramFile, paramInt, paramBoolean);
    if (paramInt == 1)
    {
      paramFile = com.tencent.tinker.lib.e.a.lk(this.context).Mha;
      if ((paramFile.Mhf != null) && ("00000000000000000000000000000000".equals(paramFile.Mhf)))
      {
        ShareTinkerLog.v("Tinker.ServerLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
        ShareTinkerInternals.killAllOtherProcess(this.context);
      }
    }
    AppMethodBeat.o(3446);
  }
  
  public final void a(String paramString1, String paramString2, File paramFile, String paramString3)
  {
    AppMethodBeat.i(3445);
    super.a(paramString1, paramString2, paramFile, paramString3);
    AppMethodBeat.o(3445);
  }
  
  public final void a(Throwable paramThrowable, int paramInt)
  {
    AppMethodBeat.i(3444);
    super.a(paramThrowable, paramInt);
    AppMethodBeat.o(3444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.b.a
 * JD-Core Version:    0.7.0.1
 */