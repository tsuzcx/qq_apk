package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.base.h.c;

final class l$1
  implements h.c
{
  l$1(DialogInterface.OnDismissListener paramOnDismissListener, String paramString, Context paramContext) {}
  
  public final void gl(int paramInt)
  {
    if (this.sjL != null) {
      this.sjL.onDismiss(null);
    }
    String str1 = this.sjM.replace(" ", "").replace("#", "@");
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      Context localContext = this.val$context;
      Intent localIntent = new Intent();
      localIntent.putExtra("composeType", 4);
      String str2 = str1.substring(0, str1.indexOf('@'));
      localIntent.putExtra("toList", new String[] { str2 + " " + str1 });
      d.b(localContext, "qqmail", ".ui.ComposeUI", localIntent);
      return;
    }
    l.bo(this.val$context, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.1
 * JD-Core Version:    0.7.0.1
 */