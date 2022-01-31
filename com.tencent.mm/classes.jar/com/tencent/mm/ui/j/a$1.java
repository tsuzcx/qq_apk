package com.tencent.mm.ui.j;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.g.a.f;

final class a$1
  extends ak
{
  a$1(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(80340);
    Object localObject;
    Context localContext;
    a locala;
    if (paramMessage.what == 1000)
    {
      localObject = (String)paramMessage.obj;
      if (localObject == null) {
        break label142;
      }
      localContext = this.ABh.context;
      locala = this.ABh;
      if (localContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break label125;
      }
      f.L(localContext, "Error", "Application requires permission to access the Internet");
    }
    for (;;)
    {
      if (paramMessage.what == 1010)
      {
        paramMessage = (a.c)paramMessage.obj;
        localObject = this.ABh;
        ((a)localObject).ABe = false;
        if (paramMessage == a.c.ABl)
        {
          ((a)localObject).ABc = null;
          a.a(null);
        }
        if (((a)localObject).ABg != null) {
          ((a)localObject).ABg.b(paramMessage);
        }
      }
      AppMethodBeat.o(80340);
      return;
      label125:
      new b(localContext, (String)localObject, locala).show();
      continue;
      label142:
      this.ABh.c(a.c.ABl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.j.a.1
 * JD-Core Version:    0.7.0.1
 */