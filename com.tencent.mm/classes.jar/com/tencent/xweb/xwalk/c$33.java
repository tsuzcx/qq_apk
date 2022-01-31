package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$33
  implements View.OnLongClickListener
{
  c$33(c paramc) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(139559);
    new AlertDialog.Builder(this.BIO.BDH).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(85160);
        c.b(c.33.this.BIO, Environment.getExternalStorageDirectory() + "/xweb_dump");
        AppMethodBeat.o(85160);
      }
    }).setNegativeButton("取消", new c.33.1(this)).show();
    AppMethodBeat.o(139559);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.33
 * JD-Core Version:    0.7.0.1
 */