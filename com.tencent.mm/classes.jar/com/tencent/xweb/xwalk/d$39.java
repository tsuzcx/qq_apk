package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$39
  implements View.OnLongClickListener
{
  d$39(d paramd) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(207253);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$44", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    new AlertDialog.Builder(this.SGe.SzQ).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(207252);
        d.b(d.39.this.SGe, Environment.getExternalStorageDirectory() + "/xweb_dump");
        AppMethodBeat.o(207252);
      }
    }).setNegativeButton("取消", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(154200);
        AppMethodBeat.o(154200);
      }
    }).show();
    a.a(false, this, "com/tencent/xweb/xwalk/WebDebugPage$44", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(207253);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.39
 * JD-Core Version:    0.7.0.1
 */