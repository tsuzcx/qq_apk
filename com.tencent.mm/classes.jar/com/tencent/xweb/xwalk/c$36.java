package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.d.a;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.g.a;

final class c$36
  implements g.a
{
  private ProgressDialog BIX = null;
  boolean mFinished = false;
  
  c$36(c paramc, g paramg, String paramString) {}
  
  public final void TB(int paramInt)
  {
    AppMethodBeat.i(139567);
    if ((this.mFinished) || (this.BIX == null))
    {
      AppMethodBeat.o(139567);
      return;
    }
    this.BIX.setProgress(paramInt);
    AppMethodBeat.o(139567);
  }
  
  public final void TC(int paramInt)
  {
    AppMethodBeat.i(139568);
    this.mFinished = true;
    if (this.BIX == null)
    {
      AppMethodBeat.o(139568);
      return;
    }
    switch (paramInt)
    {
    default: 
      this.BIX.setMessage("更新失败，未知错误，ErrCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139568);
      return;
    case 0: 
      if ("XFilesPPTReader".equalsIgnoreCase(this.BIZ)) {
        c.a(this.BIO, "", d.a.BDb);
      }
      this.BIX.setMessage("更新完成，请重启进程");
      this.BIX.setProgress(100);
      this.BIX.getButton(-2).setVisibility(8);
      this.BIX.getButton(-1).setVisibility(0);
      AppMethodBeat.o(139568);
      return;
    case -1: 
      this.BIX.setMessage("更新被取消，ErrCode = ".concat(String.valueOf(paramInt)));
      Toast.makeText(this.BIO.BDH, "更新被取消，ErrCode = ".concat(String.valueOf(paramInt)), 0).show();
      AppMethodBeat.o(139568);
      return;
    case -2: 
      this.BIX.setMessage("更新失败，无网络，ErrCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139568);
      return;
    case -3: 
      this.BIX.setMessage("更新失败，未到检查时间，ErrCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139568);
      return;
    case -4: 
      this.BIX.setMessage("更新失败，其它任务正在更新插件，ErrCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139568);
      return;
    case -5: 
      this.BIX.setMessage("更新失败，配置下载失败，ErrCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139568);
      return;
    case -6: 
      this.BIX.setMessage("更新失败，配置解析失败，ErrCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139568);
      return;
    case -7: 
      this.BIX.setMessage("更新失败，配置中未包含插件信息，ErrCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139568);
      return;
    case -8: 
      this.BIX.setMessage("更新失败，未找到可用更新，ErrCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139568);
      return;
    }
    this.BIX.setMessage("更新失败，下载安装出错，ErrCode = ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(139568);
  }
  
  public final void eaf()
  {
    AppMethodBeat.i(139566);
    this.BIX = new ProgressDialog(this.BIO.BDH);
    this.BIX.setProgressStyle(1);
    this.BIX.setMessage("下载更新中");
    this.BIX.setCancelable(false);
    this.BIX.setCanceledOnTouchOutside(false);
    this.BIX.setButton(-2, "取消", new c.36.1(this));
    this.BIX.setButton(-1, "重启", new c.36.2(this));
    this.BIX.show();
    this.BIX.getButton(-1).setVisibility(8);
    AppMethodBeat.o(139566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.36
 * JD-Core Version:    0.7.0.1
 */