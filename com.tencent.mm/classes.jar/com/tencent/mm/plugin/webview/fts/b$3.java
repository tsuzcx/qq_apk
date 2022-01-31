package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.av.a;
import com.tencent.mm.av.e;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.h.a.jy.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import java.util.Iterator;
import java.util.Set;

final class b$3
  extends c<jy>
{
  b$3(b paramb)
  {
    this.udX = jy.class.getName().hashCode();
  }
  
  private boolean a(jy paramjy)
  {
    e locale = paramjy.bSA.bSu;
    if ((locale != null) && (a.d(locale))) {
      switch (paramjy.bSA.action)
      {
      }
    }
    for (;;)
    {
      return false;
      paramjy = this.qZb.qYR.iterator();
      while (paramjy.hasNext()) {
        h.Db(((Integer)paramjy.next()).intValue()).db(locale.eux, 0);
      }
      paramjy = this.qZb.qYR.iterator();
      while (paramjy.hasNext()) {
        h.Db(((Integer)paramjy.next()).intValue()).db(locale.eux, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.3
 * JD-Core Version:    0.7.0.1
 */