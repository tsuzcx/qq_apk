package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.WebView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

final class d$1
  implements View.OnClickListener
{
  d$1(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154152);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    new AlertDialog.Builder(this.SGe.SzQ).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(154151);
        paramAnonymousDialogInterface = d.1.this.SGe;
        Object localObject1 = new Date();
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
        String str = Environment.getExternalStorageDirectory().getPath();
        localObject1 = str + "/xweb_dump/" + ((SimpleDateFormat)localObject2).format((Date)localObject1);
        localObject2 = (String)localObject1 + "/main.html";
        str = (String)localObject1 + "/resource";
        paramAnonymousDialogInterface.SFP.savePage((String)localObject2, str, 1);
        new Thread(new d.49(paramAnonymousDialogInterface, (String)localObject1)).start();
        AppMethodBeat.o(154151);
      }
    }).setNegativeButton("取消", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.1
 * JD-Core Version:    0.7.0.1
 */