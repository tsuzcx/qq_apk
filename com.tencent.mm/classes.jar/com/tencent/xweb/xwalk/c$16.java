package com.tencent.xweb.xwalk;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.b;
import com.tencent.xweb.xwalk.a.e;
import java.io.File;

final class c$16
  implements View.OnClickListener
{
  c$16(c paramc) {}
  
  public final void onClick(View paramView)
  {
    int i = 100000;
    AppMethodBeat.i(85137);
    paramView = this.BIO;
    File localFile1 = Environment.getExternalStorageDirectory();
    if (localFile1 == null)
    {
      paramView.cz("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(85137);
      return;
    }
    if (localFile1.listFiles() == null)
    {
      paramView.cz("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(85137);
      return;
    }
    com.tencent.xweb.xwalk.a.c localc = e.ayq("FullScreenVideo");
    if (localc == null)
    {
      paramView.cz("插件未准备好", true);
      AppMethodBeat.o(85137);
      return;
    }
    if (localc.BKm >= 100000) {
      i = localc.BKm + 1;
    }
    localFile1 = new File(localFile1.getPath() + "/apkxwebtest/xweb_fullscreen_video.js");
    File localFile2 = new File(localc.aP(i, false));
    if (localFile2.exists()) {
      localFile2.delete();
    }
    if (b.m(localFile1, localFile2))
    {
      localc.TI(i);
      new AlertDialog.Builder(paramView.BDH).setMessage("加载成功，请重启进程").setCancelable(false).setPositiveButton("确定", new c.37(paramView)).create().show();
      AppMethodBeat.o(85137);
      return;
    }
    paramView.cz("加载失败，请检查文件是否存在", true);
    AppMethodBeat.o(85137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.16
 * JD-Core Version:    0.7.0.1
 */