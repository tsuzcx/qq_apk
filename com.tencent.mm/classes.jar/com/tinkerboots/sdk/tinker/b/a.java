package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
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
    super.a(paramFile, paramInt, paramLong);
    Looper.getMainLooper();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        c.hS(a.this.context).cQJ();
        return false;
      }
    });
  }
  
  public final void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    super.a(paramFile, paramInt, paramBoolean);
    if (paramInt == 1)
    {
      paramFile = com.tencent.tinker.lib.e.a.hN(this.context).wWq;
      if ((paramFile.wWv != null) && ("00000000000000000000000000000000".equals(paramFile.wWv)))
      {
        com.tencent.tinker.lib.f.a.e("Tinker.ServerLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
        ShareTinkerInternals.ig(this.context);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, File paramFile, String paramString3)
  {
    super.a(paramString1, paramString2, paramFile, paramString3);
  }
  
  public final void a(Throwable paramThrowable, int paramInt)
  {
    super.a(paramThrowable, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.b.a
 * JD-Core Version:    0.7.0.1
 */