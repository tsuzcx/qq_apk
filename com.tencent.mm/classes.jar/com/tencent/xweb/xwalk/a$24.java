package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.File;

final class a$24
  implements View.OnClickListener
{
  a$24(a parama) {}
  
  public final void onClick(View paramView)
  {
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
    ((File)localObject1).toString();
    localObject1 = ((File)localObject1).getPath() + "/xweb_dump";
    Object localObject2;
    Object localObject3;
    try
    {
      localObject2 = new File((String)localObject1);
      localObject3 = ((File)localObject2).listFiles();
      if ((localObject3 == null) || (localObject3.length == 0))
      {
        paramView.bU("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        return;
      }
    }
    catch (Exception localException)
    {
      paramView.bU("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
      return;
    }
    int i = 0;
    while (i < localObject3.length)
    {
      if (localObject3[i].getName().endsWith(".zip"))
      {
        localObject2 = localObject3[i].getAbsolutePath();
        localObject3 = localObject3[i].getName();
        new AlertDialog.Builder(paramView.xgK).setTitle("提示").setMessage("确定加载:" + (String)localObject3 + "?").setPositiveButton("确定", new a.31(paramView, localException, (String)localObject2)).setNegativeButton("取消", new a.30(paramView)).show();
        return;
      }
      i += 1;
    }
    paramView.bU("web_dump目录下没有.zip文件", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.24
 * JD-Core Version:    0.7.0.1
 */