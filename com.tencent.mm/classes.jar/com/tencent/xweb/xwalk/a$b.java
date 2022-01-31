package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.content.Context;

final class a$b
  extends l
{
  private ProgressDialog xln;
  boolean xly = false;
  
  public a$b(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  private void ahf(String paramString)
  {
    if (this.xln == null)
    {
      this.xln = new ProgressDialog(this.mContext);
      this.xln.setProgressStyle(1);
      this.xln.setMessage(paramString);
      this.xln.setOnCancelListener(new a.b.1(this));
      this.xln.setCancelable(false);
      this.xln.show();
    }
    this.xln.setMessage(paramString);
  }
  
  public final void onXWalkUpdateCancelled()
  {
    super.onXWalkUpdateCancelled();
    this.xln.setCancelable(true);
    this.xln.setCanceledOnTouchOutside(true);
    ahf("更新失败, 更新被取消");
  }
  
  public final void onXWalkUpdateCompleted()
  {
    super.onXWalkUpdateCompleted();
    ahf("更新完成，点任意位置重启进程生效");
    this.xln.setCancelable(true);
    this.xln.setCanceledOnTouchOutside(true);
    this.xln.setProgress(100);
    this.xly = true;
  }
  
  public final void onXWalkUpdateFailed(int paramInt)
  {
    super.onXWalkUpdateFailed(paramInt);
    this.xln.setCancelable(true);
    this.xln.setCanceledOnTouchOutside(true);
    ahf("更新失败, error code = :" + paramInt);
  }
  
  public final void onXWalkUpdateProgress(int paramInt)
  {
    super.onXWalkUpdateProgress(paramInt);
    if (this.xly) {
      return;
    }
    ahf("正在下载runtime");
    this.xln.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.b
 * JD-Core Version:    0.7.0.1
 */