package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;

final class a$25$2
  implements DialogInterface.OnClickListener
{
  a$25$2(a.25 param25) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.a(this.xlm.xlg, Environment.getExternalStorageDirectory() + "/xweb_dump");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.25.2
 * JD-Core Version:    0.7.0.1
 */