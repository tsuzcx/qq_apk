package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class c$31
  implements View.OnClickListener
{
  c$31(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(139557);
    paramView = this.BIO;
    Object localObject1 = Environment.getExternalStorageDirectory();
    if (localObject1 == null)
    {
      paramView.cz("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(139557);
      return;
    }
    if (((File)localObject1).listFiles() == null)
    {
      paramView.cz("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(139557);
      return;
    }
    localObject1 = ((File)localObject1).getPath() + "/xweb_dump";
    Object localObject2;
    Object localObject3;
    try
    {
      localObject2 = new File((String)localObject1);
      localObject3 = ((File)localObject2).listFiles();
      if ((localObject3 == null) || (localObject3.length == 0))
      {
        paramView.cz("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        AppMethodBeat.o(139557);
        return;
      }
    }
    catch (Exception localException)
    {
      paramView.cz("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(139557);
      return;
    }
    int i = 0;
    while (i < localObject3.length)
    {
      if (localObject3[i].getName().endsWith(".zip"))
      {
        localObject2 = localObject3[i].getAbsolutePath();
        localObject3 = localObject3[i].getName();
        new AlertDialog.Builder(paramView.BDH).setTitle("提示").setMessage("确定加载:" + (String)localObject3 + "?").setPositiveButton("确定", new c.42(paramView, localException, (String)localObject2)).setNegativeButton("取消", new c.41(paramView)).show();
        AppMethodBeat.o(139557);
        return;
      }
      i += 1;
    }
    paramView.cz("web_dump目录下没有.zip文件", true);
    AppMethodBeat.o(139557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.31
 * JD-Core Version:    0.7.0.1
 */