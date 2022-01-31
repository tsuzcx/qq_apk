package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

final class bb$1
  implements DialogInterface.OnDismissListener
{
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    g.DQ();
    int i = bk.a((Integer)g.DP().Dz().get(68385, null), 0);
    g.DQ();
    g.DP().Dz().o(68385, Integer.valueOf(i + 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb.1
 * JD-Core Version:    0.7.0.1
 */