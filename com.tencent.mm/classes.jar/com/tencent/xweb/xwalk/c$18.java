package com.tencent.xweb.xwalk;

import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class c$18
  implements View.OnClickListener
{
  c$18(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85139);
    paramView = this.BIO;
    Object localObject = Environment.getExternalStorageDirectory();
    if (localObject == null)
    {
      paramView.cz("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(85139);
      return;
    }
    if (((File)localObject).listFiles() == null)
    {
      paramView.cz("请确认应用权限，在权限管理打开应用的读写存储权限", true);
      AppMethodBeat.o(85139);
      return;
    }
    localObject = ((File)localObject).getPath() + "/apkxwebtest/xfiles_ppt_reader.zip";
    if (!new File((String)localObject).exists())
    {
      paramView.cz("文件不存在 /apkxwebtest/xfiles_ppt_reader.zip", true);
      AppMethodBeat.o(85139);
      return;
    }
    new c.38(paramView, (String)localObject).execute(new Void[0]);
    AppMethodBeat.o(85139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.18
 * JD-Core Version:    0.7.0.1
 */