package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class ReadMailUI$13$1
  implements h.c
{
  ReadMailUI$13$1(ReadMailUI.13 param13) {}
  
  public final void kM(int paramInt)
  {
    AppMethodBeat.i(123164);
    if (paramInt == 3)
    {
      ReadMailUI.J(this.uRn.uRh);
      AppMethodBeat.o(123164);
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).setClass(this.uRn.uRh, ComposeUI.class);
    ((Intent)localObject1).putExtra("mailid", ReadMailUI.a(this.uRn.uRh));
    ((Intent)localObject1).putExtra("subject", ReadMailUI.K(this.uRn.uRh));
    Object localObject2 = ReadMailUI.L(this.uRn.uRh).a(false, ReadMailUI.l(this.uRn.uRh));
    String[] arrayOfString1 = ReadMailUI.c(this.uRn.uRh).a(true, ReadMailUI.l(this.uRn.uRh));
    String[] arrayOfString2 = ReadMailUI.d(this.uRn.uRh).a(true, ReadMailUI.l(this.uRn.uRh));
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(123164);
      return;
    case 0: 
      ((Intent)localObject1).putExtra("composeType", 2);
      ((Intent)localObject1).putExtra("toList", (String[])localObject2);
    }
    for (;;)
    {
      localObject2 = this.uRn.uRh;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$8$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((ReadMailUI)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$8$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(123164);
      return;
      ((Intent)localObject1).putExtra("composeType", 2);
      String[] arrayOfString3 = new String[localObject2.length + arrayOfString1.length];
      int j = localObject2.length;
      int i = 0;
      paramInt = 0;
      while (i < j)
      {
        arrayOfString3[paramInt] = localObject2[i];
        i += 1;
        paramInt += 1;
      }
      j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        arrayOfString3[paramInt] = arrayOfString1[i];
        i += 1;
        paramInt += 1;
      }
      ((Intent)localObject1).putExtra("toList", arrayOfString3);
      ((Intent)localObject1).putExtra("ccList", arrayOfString2);
      continue;
      ((Intent)localObject1).putExtra("composeType", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.13.1
 * JD-Core Version:    0.7.0.1
 */