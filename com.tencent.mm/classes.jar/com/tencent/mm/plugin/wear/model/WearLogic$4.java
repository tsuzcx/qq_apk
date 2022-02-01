package com.tencent.mm.plugin.wear.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.a;
import com.tencent.mm.plugin.wear.model.f.l;
import com.tencent.mm.protocal.protobuf.gaq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

class WearLogic$4
  extends IListener<acn>
{
  WearLogic$4(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(261875);
    this.__eventId = acn.class.getName().hashCode();
    AppMethodBeat.o(261875);
  }
  
  private static boolean a(acn paramacn)
  {
    AppMethodBeat.i(29993);
    switch (paramacn.ifU.hId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29993);
      return false;
      paramacn = paramacn.ifU.ifP;
      if ((paramacn == null) || (paramacn.length < 10) || (paramacn[0] != 1)) {
        continue;
      }
      Object localObject = new byte[paramacn.length - 1];
      System.arraycopy(paramacn, 1, localObject, 0, localObject.length);
      try
      {
        paramacn = (gaq)new gaq().parseFrom((byte[])localObject);
        if (paramacn == null) {
          continue;
        }
        localObject = paramacn.abXZ;
        Log.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", new Object[] { localObject, Integer.valueOf(paramacn.abXQ) });
        a.inJ().a(new l(20010, (String)localObject));
      }
      catch (IOException paramacn)
      {
        for (;;)
        {
          paramacn = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearLogic.4
 * JD-Core Version:    0.7.0.1
 */