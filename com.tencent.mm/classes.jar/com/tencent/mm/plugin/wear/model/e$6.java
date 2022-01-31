package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.a;
import com.tencent.mm.plugin.wear.model.f.l;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class e$6
  extends c<td>
{
  e$6(e parame)
  {
    this.udX = td.class.getName().hashCode();
  }
  
  private static boolean a(td paramtd)
  {
    switch (paramtd.ccJ.bNb)
    {
    }
    for (;;)
    {
      return false;
      paramtd = paramtd.ccJ.ccD;
      if ((paramtd == null) || (paramtd.length < 10) || (paramtd[0] != 1)) {
        continue;
      }
      Object localObject = new byte[paramtd.length - 1];
      System.arraycopy(paramtd, 1, localObject, 0, localObject.length);
      try
      {
        paramtd = (cfe)new cfe().aH((byte[])localObject);
        if (paramtd == null) {
          continue;
        }
        localObject = paramtd.tTO;
        y.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", new Object[] { localObject, Integer.valueOf(paramtd.tTG) });
        a.bYL().qRA.a(new l(20010, (String)localObject));
        return false;
      }
      catch (IOException paramtd)
      {
        for (;;)
        {
          paramtd = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.6
 * JD-Core Version:    0.7.0.1
 */