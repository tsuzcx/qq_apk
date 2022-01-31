package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import com.tencent.xweb.WebView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

final class a$1$2
  implements DialogInterface.OnClickListener
{
  a$1$2(a.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.xlh.xlg;
    Object localObject1 = new Date();
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    String str = Environment.getExternalStorageDirectory().getPath();
    localObject1 = str + "/xweb_dump/" + ((SimpleDateFormat)localObject2).format((Date)localObject1);
    localObject2 = (String)localObject1 + "/main.html";
    str = (String)localObject1 + "/resource";
    paramDialogInterface.xkX.savePage((String)localObject2, str, 1);
    new Thread(new a.33(paramDialogInterface, (String)localObject1)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.1.2
 * JD-Core Version:    0.7.0.1
 */