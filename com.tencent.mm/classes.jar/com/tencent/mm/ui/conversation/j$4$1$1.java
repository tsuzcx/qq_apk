package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bxs;
import java.io.File;

final class j$4$1$1
  implements DialogInterface.OnClickListener
{
  j$4$1$1(j.4.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(this.vTq.vTp.vTo.tNK)), "application/vnd.android.package-archive");
    j.a(this.vTq.vTp.vTn).startActivity(localIntent);
    h.nFQ.a(614L, 50L, 1L, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.4.1.1
 * JD-Core Version:    0.7.0.1
 */