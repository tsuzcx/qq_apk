package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.a;
import com.tencent.mm.plugin.wear.model.f.l;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

final class e$6
  extends c<ux>
{
  e$6(e parame)
  {
    AppMethodBeat.i(26306);
    this.__eventId = ux.class.getName().hashCode();
    AppMethodBeat.o(26306);
  }
  
  private static boolean a(ux paramux)
  {
    AppMethodBeat.i(26307);
    switch (paramux.cLs.cut)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26307);
      return false;
      paramux = paramux.cLs.cLl;
      if ((paramux == null) || (paramux.length < 10) || (paramux[0] != 1)) {
        continue;
      }
      Object localObject = new byte[paramux.length - 1];
      System.arraycopy(paramux, 1, localObject, 0, localObject.length);
      try
      {
        paramux = (csp)new csp().parseFrom((byte[])localObject);
        if (paramux == null) {
          continue;
        }
        localObject = paramux.ybf;
        ab.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", new Object[] { localObject, Integer.valueOf(paramux.yaX) });
        a.cYy().uGI.a(new l(20010, (String)localObject));
      }
      catch (IOException paramux)
      {
        for (;;)
        {
          paramux = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.6
 * JD-Core Version:    0.7.0.1
 */