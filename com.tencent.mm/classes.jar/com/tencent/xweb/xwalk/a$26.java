package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.xweb.xwalk.plugin.c;
import com.tencent.xweb.xwalk.plugin.c.b;

final class a$26
  implements c.b
{
  boolean mFinished = false;
  private ProgressDialog xln = null;
  
  a$26(a parama, c paramc) {}
  
  public final void KG(int paramInt)
  {
    if ((this.mFinished) || (this.xln == null)) {
      return;
    }
    this.xln.setProgress(paramInt);
  }
  
  public final void KH(int paramInt)
  {
    this.mFinished = true;
    if (this.xln == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      this.xln.setMessage("更新失败，未知错误，ErrCode = " + paramInt);
      return;
    case 0: 
      this.xln.setMessage("更新完成，请重启进程");
      this.xln.setProgress(100);
      this.xln.getButton(-2).setVisibility(8);
      this.xln.getButton(-1).setVisibility(0);
      return;
    case -1: 
      this.xln.setMessage("更新被取消，ErrCode = " + paramInt);
      Toast.makeText(this.xlg.xgK, "更新被取消，ErrCode = " + paramInt, 0).show();
      return;
    case -2: 
      this.xln.setMessage("更新失败，无网络，ErrCode = " + paramInt);
      return;
    case -3: 
      this.xln.setMessage("更新失败，未到检查时间，ErrCode = " + paramInt);
      return;
    case -4: 
      this.xln.setMessage("更新失败，其它任务正在更新插件，ErrCode = " + paramInt);
      return;
    case -5: 
      this.xln.setMessage("更新失败，配置下载失败，ErrCode = " + paramInt);
      return;
    case -6: 
      this.xln.setMessage("更新失败，配置解析失败，ErrCode = " + paramInt);
      return;
    case -7: 
      this.xln.setMessage("更新失败，配置中未包含插件信息，ErrCode = " + paramInt);
      return;
    case -8: 
      this.xln.setMessage("更新失败，未找到可用更新，ErrCode = " + paramInt);
      return;
    }
    this.xln.setMessage("更新失败，下载安装出错，ErrCode = " + paramInt);
  }
  
  public final void cTC()
  {
    this.xln = new ProgressDialog(this.xlg.xgK);
    this.xln.setProgressStyle(1);
    this.xln.setMessage("下载更新中");
    this.xln.setCancelable(false);
    this.xln.setCanceledOnTouchOutside(false);
    this.xln.setButton(-2, "取消", new a.26.1(this));
    this.xln.setButton(-1, "重启", new a.26.2(this));
    this.xln.show();
    this.xln.getButton(-1).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.26
 * JD-Core Version:    0.7.0.1
 */