package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.ah.d.a;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.be;
import com.tencent.mm.vfs.b;
import java.util.HashMap;
import java.util.List;

public class g
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private com.tencent.mm.model.bk nou;
  private c nov = new c();
  private a now = new a();
  private d nox = new d();
  private f noy = new f();
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new g.1());
  }
  
  private static void a(final int paramInt, g.a parama)
  {
    if (!com.tencent.mm.kernel.g.DK())
    {
      c(parama);
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        Object localObject = new b(com.tencent.mm.plugin.n.c.FG());
        if ((!((b)localObject).exists()) || (!((b)localObject).isDirectory()))
        {
          g.d(this.noz);
          return;
        }
        localObject = ((b)localObject).cLt();
        if ((localObject == null) || (localObject.length <= 0))
        {
          g.d(this.noz);
          return;
        }
        String str1 = String.format("reader_%d_", new Object[] { Integer.valueOf(paramInt) });
        String str2 = String.format("ReaderApp_%d", new Object[] { Integer.valueOf(paramInt) });
        while (i < localObject.length)
        {
          if (localObject[i].getName().startsWith(str1)) {
            localObject[i].delete();
          }
          if (localObject[i].getName().startsWith(str2)) {
            localObject[i].delete();
          }
          i += 1;
        }
        g.d(this.noz);
      }
      
      public final String toString()
      {
        return super.toString() + "|deleteAllPic";
      }
    });
  }
  
  public static void a(g.a parama)
  {
    buZ().hV(20);
    ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abu("newsapp");
    a(20, parama);
  }
  
  public static void b(g.a parama)
  {
    buZ().hV(11);
    ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abu("blogapp");
    a(11, parama);
  }
  
  private static g buY()
  {
    return (g)p.B(g.class);
  }
  
  public static com.tencent.mm.model.bk buZ()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (buY().nou == null) {
      buY().nou = new com.tencent.mm.model.bk(com.tencent.mm.kernel.g.DP().dKu);
    }
    return buY().nou;
  }
  
  private static void c(g.a parama)
  {
    ai.d(new g.2(parama));
  }
  
  public static void cl(String paramString, int paramInt)
  {
    i(buZ().I(paramString, paramInt), paramInt);
  }
  
  public static void ft(long paramLong)
  {
    i(buZ().bD(paramLong), 20);
  }
  
  private static void i(List<bj> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int i = 0;
    label16:
    if (i < paramList.size())
    {
      if (i != 0) {
        break label60;
      }
      com.tencent.mm.sdk.platformtools.bk.deleteFile(q.y(((bj)paramList.get(i)).Ia(), paramInt, "@T"));
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label60:
      com.tencent.mm.sdk.platformtools.bk.deleteFile(q.y(((bj)paramList.get(i)).Ia(), paramInt, "@S"));
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    d.a.a(this.nov);
    com.tencent.mm.kernel.g.DS().O(new g.4(this));
    com.tencent.mm.sdk.b.a.udP.c(this.now);
    com.tencent.mm.sdk.b.a.udP.c(this.nox);
    com.tencent.mm.sdk.b.a.udP.c(this.noy);
    e locale = e.not;
    e.init();
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt)
  {
    if ((0x80000 & paramInt) != 0) {
      a(null);
    }
    if ((0x40000 & paramInt) != 0) {
      b(null);
    }
  }
  
  public final void onAccountRelease()
  {
    d.a.b(this.nov);
    com.tencent.mm.sdk.b.a.udP.d(this.now);
    com.tencent.mm.sdk.b.a.udP.d(this.nox);
    com.tencent.mm.sdk.b.a.udP.d(this.noy);
    e locale = e.not;
    e.release();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.g
 * JD-Core Version:    0.7.0.1
 */