package com.tencent.mm.view.e;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.view.SmileyPanelViewPager;

final class a$1
  extends ah
{
  a$1(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
    case 1102: 
      do
      {
        return;
        this.wzg.cLK();
        a.a(this.wzg);
      } while ((a.b(this.wzg) == null) || (a.c(this.wzg) == null));
      int j = a.d(this.wzg).wzE;
      if (j >= 0)
      {
        i = j;
        if (j <= a.d(this.wzg).afc(a.b(this.wzg)).cLI()) {}
      }
      else
      {
        i = a.d(this.wzg).afc(a.b(this.wzg)).cLI() - 1;
      }
      a.a(this.wzg, i + a.d(this.wzg).afc(a.b(this.wzg)).hxB);
      a.c(this.wzg).setCurrentItem(a.e(this.wzg));
      a.f(this.wzg);
      return;
    }
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
    a locala = this.wzg;
    int i = paramMessage.arg1;
    if (paramMessage.arg2 == 1) {}
    for (;;)
    {
      a.a(locala, i, bool, false);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.e.a.1
 * JD-Core Version:    0.7.0.1
 */