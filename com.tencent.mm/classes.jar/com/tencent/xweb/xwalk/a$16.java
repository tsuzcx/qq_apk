package com.tencent.xweb.xwalk;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import com.tencent.xweb.xwalk.plugin.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

final class a$16
  implements View.OnClickListener
{
  a$16(a parama) {}
  
  public final void onClick(View paramView)
  {
    int i = 99999;
    paramView = this.xlg;
    Object localObject1 = Environment.getExternalStorageDirectory();
    if (localObject1 == null)
    {
      paramView.bU("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    if (((File)localObject1).listFiles() == null)
    {
      paramView.bU("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    b localb = XWalkPluginManager.ahg("FullScreenVideo");
    if (localb == null)
    {
      paramView.bU("插件未准备好", true);
      return;
    }
    if (localb.xmr >= 99999) {
      i = localb.xmr + 1;
    }
    Object localObject2;
    try
    {
      localObject1 = new FileInputStream(((File)localObject1).getPath() + "/apkxwebtest/xweb_fullscreen_video.js");
      localObject2 = new File(localb.az(i, false));
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new FileOutputStream((File)localObject2);
      byte[] arrayOfByte = new byte[1048576];
      for (;;)
      {
        int j = ((FileInputStream)localObject1).read(arrayOfByte);
        if (j == -1) {
          break;
        }
        ((FileOutputStream)localObject2).write(arrayOfByte, 0, j);
      }
      ((FileOutputStream)localObject2).flush();
    }
    catch (Exception localException)
    {
      paramView.bU("加载失败，请检查文件是否存在", true);
      return;
    }
    ((FileInputStream)localObject1).close();
    ((FileOutputStream)localObject2).close();
    localException.KJ(i);
    new AlertDialog.Builder(paramView.xgK).setMessage("加载成功，请重启进程").setCancelable(false).setPositiveButton("确定", new a.27(paramView)).create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.16
 * JD-Core Version:    0.7.0.1
 */