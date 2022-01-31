package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class g$49$1
  implements f
{
  g$49$1(g.49 param49, com.tencent.mm.plugin.webview.model.m paramm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(154971);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (agv)this.vqU.fBd.fsW.fta;
      if (paramString.lGK == 0)
      {
        paramString = paramString.wZu;
        paramm = new StringBuilder();
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (avw)localIterator.next();
          String str = ((avw)localObject).eAx + "," + ((avw)localObject).major;
          if (g.q(this.vqV.vqm).containsKey(str)) {
            paramString = (List)g.q(this.vqV.vqm).get(str);
          }
          for (;;)
          {
            paramString.add(localObject);
            paramm.append("{uuid:" + ((avw)localObject).eAx + ",major:" + ((avw)localObject).major + ",minors:[");
            paramString = ((avw)localObject).xlk.iterator();
            while (paramString.hasNext())
            {
              localObject = (avy)paramString.next();
              paramm.append(((avy)localObject).xll + "-" + ((avy)localObject).xlm + ",");
            }
            paramString = new ArrayList();
            g.q(this.vqV.vqm).put(str, paramString);
          }
          paramm.append("]},");
        }
        ab.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + paramm.toString());
      }
    }
    com.tencent.mm.kernel.g.Rc().b(1704, this);
    g.a(this.vqV.vqm, false);
    AppMethodBeat.o(154971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.49.1
 * JD-Core Version:    0.7.0.1
 */