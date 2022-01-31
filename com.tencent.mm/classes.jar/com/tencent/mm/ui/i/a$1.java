package com.tencent.mm.ui.i;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.f.a.e;

final class a$1
  extends ah
{
  a$1(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject;
    Context localContext;
    a locala;
    if (paramMessage.what == 1000)
    {
      localObject = (String)paramMessage.obj;
      if (localObject == null) {
        break label132;
      }
      localContext = this.win.context;
      locala = this.win;
      if (localContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break label115;
      }
      e.B(localContext, "Error", "Application requires permission to access the Internet");
    }
    for (;;)
    {
      if (paramMessage.what == 1010)
      {
        paramMessage = (a.c)paramMessage.obj;
        localObject = this.win;
        ((a)localObject).wik = false;
        if (paramMessage == a.c.wir)
        {
          ((a)localObject).wii = null;
          a.a(null);
        }
        if (((a)localObject).wim != null) {
          ((a)localObject).wim.b(paramMessage);
        }
      }
      return;
      label115:
      new b(localContext, (String)localObject, locala).show();
      continue;
      label132:
      this.win.c(a.c.wir);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.1
 * JD-Core Version:    0.7.0.1
 */