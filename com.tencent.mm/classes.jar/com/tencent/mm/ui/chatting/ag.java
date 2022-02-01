package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.chatting.e.a;
import java.util.LinkedList;

public final class ag
  implements com.tencent.mm.pluginsdk.ui.span.h
{
  private a cXJ;
  
  public ag(a parama)
  {
    this.cXJ = parama;
  }
  
  public final Object a(u paramu)
  {
    AppMethodBeat.i(34836);
    com.tencent.mm.pluginsdk.wallet.h.aad(6);
    switch (paramu.type)
    {
    case 3: 
    case 5: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 19: 
    case 24: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 32: 
    default: 
    case 4: 
    case 2: 
    case 6: 
    case 7: 
    case 9: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
      for (;;)
      {
        AppMethodBeat.o(34836);
        return null;
        LinkedList localLinkedList = new LinkedList();
        int i;
        if (x.zT(this.cXJ.getTalkerUserName()))
        {
          i = paramu.url.lastIndexOf("/");
          if (i >= 0) {
            localLinkedList.add(paramu.url.substring(i + 1));
          }
        }
        else
        {
          for (;;)
          {
            paramu = new LinkedList();
            i = 0;
            while (i < localLinkedList.size())
            {
              paramu.add(Integer.valueOf(6));
              i += 1;
            }
            localLinkedList.add(this.cXJ.getTalkerUserName());
          }
          new aa(this.cXJ.Kkd.getContext(), new aa.a()
          {
            public final void cF(boolean paramAnonymousBoolean) {}
          }).a(localLinkedList, paramu, null);
          continue;
          this.cXJ.Kkd.fEZ();
        }
      }
    case 25: 
    case 30: 
    case 31: 
    case 33: 
      paramu = this.cXJ.getTalkerUserName();
      AppMethodBeat.o(34836);
      return paramu;
    }
    paramu = this.cXJ.getTalkerUserName();
    AppMethodBeat.o(34836);
    return paramu;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(34837);
    switch (paramu.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34837);
      return null;
      if (bc.ajM())
      {
        if (com.tencent.mm.al.g.vz(this.cXJ.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
        if (com.tencent.mm.al.g.Es(this.cXJ.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
        if (com.tencent.mm.al.g.Er(this.cXJ.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
      }
      String str = new String(Base64.decode(paramu.url, 0));
      paramu = new String(Base64.decode(bu.bI((String)paramu.aY(String.class), ""), 0));
      ae.i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", new Object[] { str, paramu });
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1082;
      localAppBrandStatObject.dlj = (this.cXJ.getTalkerUserName() + "|1");
      ((p)com.tencent.mm.kernel.g.ab(p.class)).a(this.cXJ.Kkd.getContext(), null, str, 0, 0, paramu, localAppBrandStatObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ag
 * JD-Core Version:    0.7.0.1
 */