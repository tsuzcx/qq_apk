package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class ReadMailUI$13$1
  implements h.c
{
  ReadMailUI$13$1(ReadMailUI.13 param13) {}
  
  public final void iA(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(68436);
    if (paramInt == 3)
    {
      ReadMailUI.J(this.pPd.pOX);
      AppMethodBeat.o(68436);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.pPd.pOX, ComposeUI.class);
    localIntent.putExtra("mailid", ReadMailUI.a(this.pPd.pOX));
    localIntent.putExtra("subject", ReadMailUI.K(this.pPd.pOX));
    String[] arrayOfString1 = ReadMailUI.L(this.pPd.pOX).a(false, ReadMailUI.l(this.pPd.pOX));
    String[] arrayOfString2 = ReadMailUI.c(this.pPd.pOX).a(true, ReadMailUI.l(this.pPd.pOX));
    String[] arrayOfString3 = ReadMailUI.d(this.pPd.pOX).a(true, ReadMailUI.l(this.pPd.pOX));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(68436);
      return;
    case 0: 
      localIntent.putExtra("composeType", 2);
      localIntent.putExtra("toList", arrayOfString1);
    }
    for (;;)
    {
      this.pPd.pOX.startActivity(localIntent);
      AppMethodBeat.o(68436);
      return;
      localIntent.putExtra("composeType", 2);
      String[] arrayOfString4 = new String[arrayOfString1.length + arrayOfString2.length];
      int k = arrayOfString1.length;
      int i = 0;
      paramInt = 0;
      while (i < k)
      {
        arrayOfString4[paramInt] = arrayOfString1[i];
        i += 1;
        paramInt += 1;
      }
      k = arrayOfString2.length;
      i = j;
      while (i < k)
      {
        arrayOfString4[paramInt] = arrayOfString2[i];
        i += 1;
        paramInt += 1;
      }
      localIntent.putExtra("toList", arrayOfString4);
      localIntent.putExtra("ccList", arrayOfString3);
      continue;
      localIntent.putExtra("composeType", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.13.1
 * JD-Core Version:    0.7.0.1
 */