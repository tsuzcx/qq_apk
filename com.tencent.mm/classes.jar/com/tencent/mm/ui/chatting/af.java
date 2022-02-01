package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.chatting.d.a;
import java.util.LinkedList;

public final class af
  implements com.tencent.mm.pluginsdk.ui.span.h
{
  private a cOd;
  
  public af(a parama)
  {
    this.cOd = parama;
  }
  
  public final Object a(u paramu)
  {
    AppMethodBeat.i(34836);
    com.tencent.mm.pluginsdk.wallet.h.Vs(6);
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
        if (w.sl(this.cOd.getTalkerUserName()))
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
            localLinkedList.add(this.cOd.getTalkerUserName());
          }
          new aa(this.cOd.GzJ.getContext(), new aa.a()
          {
            public final void cE(boolean paramAnonymousBoolean) {}
          }).a(localLinkedList, paramu, null);
          continue;
          this.cOd.GzJ.eUW();
        }
      }
    case 25: 
    case 30: 
    case 31: 
    case 33: 
      paramu = this.cOd.getTalkerUserName();
      AppMethodBeat.o(34836);
      return paramu;
    }
    paramu = this.cOd.getTalkerUserName();
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
      if (az.afw())
      {
        if (f.pc(this.cOd.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
        if (f.wL(this.cOd.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
        if (f.wK(this.cOd.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
      }
      String str = new String(Base64.decode(paramu.url, 0));
      paramu = new String(Base64.decode(bt.by((String)paramu.aV(String.class), ""), 0));
      ad.i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", new Object[] { str, paramu });
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1082;
      localAppBrandStatObject.dbt = (this.cOd.getTalkerUserName() + "|1");
      ((n)g.ab(n.class)).a(this.cOd.GzJ.getContext(), null, str, 0, 0, paramu, localAppBrandStatObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.af
 * JD-Core Version:    0.7.0.1
 */