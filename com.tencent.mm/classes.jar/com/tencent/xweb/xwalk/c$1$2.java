package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

final class c$1$2
  implements DialogInterface.OnClickListener
{
  c$1$2(c.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(85121);
    paramDialogInterface = this.BIP.BIO;
    Object localObject1 = new Date();
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
    String str = Environment.getExternalStorageDirectory().getPath();
    localObject1 = str + "/xweb_dump/" + ((SimpleDateFormat)localObject2).format((Date)localObject1);
    localObject2 = (String)localObject1 + "/main.html";
    str = (String)localObject1 + "/resource";
    paramDialogInterface.BID.savePage((String)localObject2, str, 1);
    new Thread(new c.44(paramDialogInterface, (String)localObject1)).start();
    AppMethodBeat.o(85121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.1.2
 * JD-Core Version:    0.7.0.1
 */