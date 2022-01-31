package com.tencent.mm.view.e;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.view.SmileyPanelViewPager;

final class a$1
  extends ak
{
  a$1(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(63023);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63023);
      return;
      this.AUz.dRg();
      a.a(this.AUz);
      if ((a.b(this.AUz) != null) && (a.c(this.AUz) != null))
      {
        int j = a.d(this.AUz).AVa;
        int i;
        if (j >= 0)
        {
          i = j;
          if (j <= a.d(this.AUz).avU(a.b(this.AUz)).dRf()) {}
        }
        else
        {
          i = a.d(this.AUz).avU(a.b(this.AUz)).dRf() - 1;
        }
        a.a(this.AUz, i + a.d(this.AUz).avU(a.b(this.AUz)).jpL);
        a.c(this.AUz).setCurrentItem(a.e(this.AUz));
        a.f(this.AUz);
        AppMethodBeat.o(63023);
        return;
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
        a.b(this.AUz, paramMessage.arg1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.view.e.a.1
 * JD-Core Version:    0.7.0.1
 */