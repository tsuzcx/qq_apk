package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.d.a;
import java.util.LinkedList;

public final class af
  implements com.tencent.mm.pluginsdk.ui.d.g
{
  private a caz;
  
  public af(a parama)
  {
    this.caz = parama;
  }
  
  public final Object a(m paramm)
  {
    AppMethodBeat.i(30955);
    com.tencent.mm.pluginsdk.wallet.j.Mx(6);
    switch (paramm.type)
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
        AppMethodBeat.o(30955);
        return null;
        LinkedList localLinkedList = new LinkedList();
        int i;
        if (t.nI(this.caz.getTalkerUserName()))
        {
          i = paramm.url.lastIndexOf("/");
          if (i >= 0) {
            localLinkedList.add(paramm.url.substring(i + 1));
          }
        }
        else
        {
          for (;;)
          {
            paramm = new LinkedList();
            i = 0;
            while (i < localLinkedList.size())
            {
              paramm.add(Integer.valueOf(6));
              i += 1;
            }
            localLinkedList.add(this.caz.getTalkerUserName());
          }
          new s(this.caz.zJz.getContext(), new af.1(this)).a(localLinkedList, paramm, null);
          continue;
          this.caz.zJz.dGb();
        }
      }
    case 25: 
    case 30: 
    case 31: 
    case 33: 
      paramm = this.caz.getTalkerUserName();
      AppMethodBeat.o(30955);
      return paramm;
    }
    paramm = this.caz.getTalkerUserName();
    AppMethodBeat.o(30955);
    return paramm;
  }
  
  public final Object b(m paramm)
  {
    AppMethodBeat.i(30956);
    switch (paramm.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30956);
      return null;
      if (aw.RG())
      {
        if (f.lg(this.caz.getTalkerUserName()))
        {
          AppMethodBeat.o(30956);
          return null;
        }
        if (f.rX(this.caz.getTalkerUserName()))
        {
          AppMethodBeat.o(30956);
          return null;
        }
        if (f.rW(this.caz.getTalkerUserName()))
        {
          AppMethodBeat.o(30956);
          return null;
        }
      }
      String str = new String(Base64.decode(paramm.url, 0));
      paramm = new String(Base64.decode(bo.bf((String)paramm.ap(String.class), ""), 0));
      ab.i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", new Object[] { str, paramm });
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1082;
      localAppBrandStatObject.cmF = this.caz.getTalkerUserName();
      ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(this.caz.zJz.getContext(), null, str, 0, 0, paramm, localAppBrandStatObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.af
 * JD-Core Version:    0.7.0.1
 */