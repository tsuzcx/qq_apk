package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

final class c$b
  extends n
{
  private ProgressDialog BIX;
  boolean BJl = false;
  
  public c$b(c paramc, Context paramContext)
  {
    super(paramContext);
  }
  
  private void ayp(String paramString)
  {
    AppMethodBeat.i(85181);
    if (this.BIX == null)
    {
      this.BIX = new ProgressDialog(this.mContext);
      this.BIX.setProgressStyle(1);
      this.BIX.setMessage(paramString);
      this.BIX.setOnCancelListener(new c.b.1(this));
      this.BIX.setCancelable(false);
      this.BIX.show();
    }
    this.BIX.setMessage(paramString);
    AppMethodBeat.o(85181);
  }
  
  public final void onXWalkUpdateCancelled()
  {
    AppMethodBeat.i(85179);
    super.onXWalkUpdateCancelled();
    try
    {
      this.BIX.setCancelable(true);
      this.BIX.setCanceledOnTouchOutside(true);
      ayp("更新失败, 更新被取消");
      AppMethodBeat.o(85179);
      return;
    }
    catch (Exception localException)
    {
      Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
      AppMethodBeat.o(85179);
    }
  }
  
  public final void onXWalkUpdateCompleted()
  {
    AppMethodBeat.i(85180);
    super.onXWalkUpdateCompleted();
    try
    {
      ayp("更新完成，点任意位置重启进程生效");
      this.BIX.setCancelable(true);
      this.BIX.setCanceledOnTouchOutside(true);
      this.BIX.setProgress(100);
      this.BJl = true;
      AppMethodBeat.o(85180);
      return;
    }
    catch (Exception localException)
    {
      Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
      AppMethodBeat.o(85180);
    }
  }
  
  public final void onXWalkUpdateFailed(int paramInt)
  {
    AppMethodBeat.i(85178);
    super.onXWalkUpdateFailed(paramInt);
    try
    {
      this.BIX.setCancelable(true);
      this.BIX.setCanceledOnTouchOutside(true);
      ayp("更新失败, error code = :".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(85178);
      return;
    }
    catch (Exception localException)
    {
      Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
      AppMethodBeat.o(85178);
    }
  }
  
  public final void onXWalkUpdateProgress(int paramInt)
  {
    AppMethodBeat.i(85177);
    super.onXWalkUpdateProgress(paramInt);
    if (this.BJl)
    {
      AppMethodBeat.o(85177);
      return;
    }
    try
    {
      ayp("正在下载runtime");
      if (this.BIX != null) {
        this.BIX.setProgress(paramInt);
      }
      AppMethodBeat.o(85177);
      return;
    }
    catch (Exception localException)
    {
      Log.i("WebDebugPage", "may run in background failed to load alert:" + localException.getMessage());
      AppMethodBeat.o(85177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.b
 * JD-Core Version:    0.7.0.1
 */