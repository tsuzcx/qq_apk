package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;
import java.util.LinkedList;

public final class ai
  implements com.tencent.mm.pluginsdk.ui.d.g
{
  private a byx;
  
  public ai(a parama)
  {
    this.byx = parama;
  }
  
  public final Object a(m paramm)
  {
    i.Ez(6);
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
        return null;
        LinkedList localLinkedList = new LinkedList();
        int i;
        if (com.tencent.mm.model.s.gZ(this.byx.getTalkerUserName()))
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
            localLinkedList.add(this.byx.getTalkerUserName());
          }
          new com.tencent.mm.pluginsdk.ui.applet.s(this.byx.vtz.getContext(), new ai.1(this)).f(localLinkedList, paramm);
          continue;
          this.byx.vtz.cCo();
        }
      }
    case 25: 
    case 30: 
    case 31: 
      return this.byx.getTalkerUserName();
    }
    return this.byx.getTalkerUserName();
  }
  
  public final Object b(m paramm)
  {
    switch (paramm.type)
    {
    }
    do
    {
      return null;
    } while ((au.DK()) && ((f.eW(this.byx.getTalkerUserName())) || (f.lc(this.byx.getTalkerUserName())) || (f.lb(this.byx.getTalkerUserName()))));
    String str = new String(Base64.decode(paramm.url, 0));
    paramm = new String(Base64.decode(bk.aM((String)paramm.S(String.class), ""), 0));
    y.i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", new Object[] { str, paramm });
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1082;
    localAppBrandStatObject.bFv = this.byx.cDP();
    ((d)com.tencent.mm.kernel.g.r(d.class)).a(this.byx.vtz.getContext(), null, str, 0, 0, paramm, localAppBrandStatObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ai
 * JD-Core Version:    0.7.0.1
 */