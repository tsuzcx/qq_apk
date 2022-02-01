package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    new AlertDialog.Builder(this.KFu.Kzw).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(154151);
        paramAnonymousDialogInterface = d.1.this.KFu;
        Object localObject1 = new Date();
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
        String str = Environment.getExternalStorageDirectory().getPath();
        localObject1 = str + "/xweb_dump/" + ((SimpleDateFormat)localObject2).format((Date)localObject1);
        localObject2 = (String)localObject1 + "/main.html";
        str = (String)localObject1 + "/resource";
        paramAnonymousDialogInterface.KFf.savePage((String)localObject2, str, 1);
        new Thread(new d.46(paramAnonymousDialogInterface, (String)localObject1)).start();
        AppMethodBeat.o(154151);
      }
    }).setNegativeButton("取消", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).show();
    AppMethodBeat.o(154152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.1
 * JD-Core Version:    0.7.0.1
 */