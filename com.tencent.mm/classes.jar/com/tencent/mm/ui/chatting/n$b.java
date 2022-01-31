package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.List;

final class n$b
  implements av.a
{
  private com.tencent.mm.ui.chatting.c.a byx;
  private Context context;
  private String eeM;
  private long idK;
  private boolean kax;
  private n.a vjE;
  
  public n$b(com.tencent.mm.ui.chatting.c.a parama, Context paramContext, String paramString, long paramLong, n.a parama1)
  {
    this.byx = parama;
    this.context = paramContext;
    this.eeM = paramString;
    this.idK = paramLong;
    this.vjE = parama1;
    this.kax = f.eW(paramString);
  }
  
  private void cCD()
  {
    Iterator localIterator = this.vjE.vju.iterator();
    while (localIterator.hasNext())
    {
      bi localbi = (bi)localIterator.next();
      Context localContext = this.context;
      boolean bool = this.vjE.vgB;
      String str = this.eeM;
      if (localbi.isText()) {
        k.a(localContext, str, localbi, bool);
      } else if (localbi.ctB()) {
        k.b(localContext, str, localbi);
      } else if ((localbi.aRQ()) && (!this.kax)) {
        k.c(localContext, str, localbi);
      } else if (localbi.aVM()) {
        k.c(localContext, str, localbi, bool);
      } else if (((localbi.cvo()) || (localbi.cvp())) && (!this.kax))
      {
        if (!k.ao(localbi)) {
          k.a(localContext, str, localbi);
        }
      }
      else if ((localbi.aVK()) && ((!this.kax) || (k.aw(localbi))) && (!k.ax(localbi)) && (localbi.getType() != 318767153) && (!k.aB(localbi)) && (!k.aq(localbi))) {
        k.b(localContext, str, localbi, bool);
      }
    }
  }
  
  private void cCE()
  {
    n.bD(this.context, this.eeM);
    nd localnd = new nd();
    localnd.bWJ.type = 5;
    localnd.bWJ.bWP = this.vjE.vju;
    localnd.bWJ.toUser = this.eeM;
    localnd.bWJ.bWQ = this.vjE.bWQ;
    localnd.bWJ.context = this.context;
    localnd.bWJ.bWm = this.vjE.bWm;
    localnd.bWJ.bWS = this.vjE.vjv;
    com.tencent.mm.sdk.b.a.udP.m(localnd);
  }
  
  public final boolean JS()
  {
    if (this.kax)
    {
      c localc = z.MA().aj(this.idK);
      synchronized (e.ehy)
      {
        String str = e.HR();
        e.d(localc);
        if (this.vjE.vjD)
        {
          cCD();
          e.lw(str);
          return true;
        }
        cCE();
      }
    }
    if (this.vjE.vjD)
    {
      cCD();
      return true;
    }
    cCE();
    return true;
  }
  
  public final boolean JT()
  {
    if (n.cCC() != null) {
      n.cCC().dismiss();
    }
    b.a(this.context, this.byx.findViewById(R.h.mm_content_fl), this.context.getString(R.l.finish_sent), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.b
 * JD-Core Version:    0.7.0.1
 */