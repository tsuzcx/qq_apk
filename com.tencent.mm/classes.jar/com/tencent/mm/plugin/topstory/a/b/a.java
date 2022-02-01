package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ak.g
{
  public static a zZi;
  public List<String> zZj;
  public long zZk;
  public long zZl;
  public c zZm;
  public c zZn;
  private List<String> zZo;
  private List<String> zZp;
  public a zZq;
  public b zZr;
  public List<String> zpt;
  
  public a()
  {
    AppMethodBeat.i(88471);
    this.zZk = 1L;
    this.zZl = 1L;
    String str = Qc("blacklist");
    if (i.eA(str)) {}
    try
    {
      this.zpt = bs.lp(i.aSr(str), ",");
      this.zZk = com.tencent.mm.kernel.g.agR().agA().a(ah.a.GQI, 1L);
      ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "black version %d", new Object[] { Long.valueOf(this.zZk) });
      if (this.zpt == null) {
        this.zpt = new ArrayList();
      }
      str = Qc("unlikelist");
      if (!i.eA(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.zpt = bs.lp(i.aSr(str), ",");
        this.zZl = com.tencent.mm.kernel.g.agR().agA().a(ah.a.GQJ, 1L);
        ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "unlike version %d", new Object[] { Long.valueOf(this.zZl) });
        if (this.zZj == null) {
          this.zZj = new ArrayList();
        }
        com.tencent.mm.kernel.g.agi().a(2748, this);
        AppMethodBeat.o(88471);
        return;
        localException1 = localException1;
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", localException1, "read black cache file", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", localException2, "read unlike cache file", new Object[0]);
        }
      }
    }
  }
  
  private static final String Qc(String paramString)
  {
    AppMethodBeat.i(88470);
    paramString = new StringBuilder().append(com.tencent.mm.kernel.g.agR().ghC).append("topstory/").toString() + paramString;
    AppMethodBeat.o(88470);
    return paramString;
  }
  
  public static a ecz()
  {
    AppMethodBeat.i(88469);
    if (zZi == null) {
      zZi = new a();
    }
    a locala = zZi;
    AppMethodBeat.o(88469);
    return locala;
  }
  
  public final void W(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88472);
    if (this.zZm != null) {
      com.tencent.mm.kernel.g.agi().a(this.zZm);
    }
    ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request black version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.zZm = new c(1, paramLong, paramInt);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.zZm, 0);
    AppMethodBeat.o(88472);
  }
  
  public final void X(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88473);
    if (this.zZn != null) {
      com.tencent.mm.kernel.g.agi().a(this.zZn);
    }
    ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request unlike version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.zZn = new c(3, paramLong, paramInt);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.zZn, 0);
    AppMethodBeat.o(88473);
  }
  
  public final void ecA()
  {
    AppMethodBeat.i(88475);
    Object localObject = bs.n(this.zpt, ",");
    String str = Qc("blacklist");
    localObject = ((String)localObject).getBytes();
    i.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88475);
  }
  
  public final void ecB()
  {
    AppMethodBeat.i(88476);
    Object localObject = bs.n(this.zZj, ",");
    String str = Qc("unlikelist");
    localObject = ((String)localObject).getBytes();
    i.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88476);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(88474);
    oi localoi;
    if (paramn.equals(this.zZm))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.zZm.ecE();
        paramInt1 = paramString.DTN;
        if (paramInt1 == 1)
        {
          if (this.zZo == null) {
            this.zZo = new ArrayList();
          }
          paramn = paramString.DSZ.iterator();
          while (paramn.hasNext())
          {
            localoi = (oi)paramn.next();
            this.zZo.add(localoi.Username);
          }
          if (paramString.EfS == 1)
          {
            ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync black size %d version %d", new Object[] { Integer.valueOf(paramString.DSZ.size()), Long.valueOf(paramString.ELn) });
            W(paramString.ELn, paramString.EfV);
            AppMethodBeat.o(88474);
            return;
          }
          this.zpt = this.zZo;
          this.zZo = null;
          this.zZk = paramString.ELn;
          ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update black version %d total item %d", new Object[] { Long.valueOf(this.zZk), Integer.valueOf(this.zpt.size()) });
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQI, Long.valueOf(this.zZk));
          ecA();
          if (this.zZq != null)
          {
            this.zZq.adF();
            AppMethodBeat.o(88474);
          }
        }
        else
        {
          if (paramInt1 == 2)
          {
            ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update black list");
            AppMethodBeat.o(88474);
            return;
          }
          if (paramInt1 == 3)
          {
            ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync black list");
            this.zZo = null;
            W(this.zZk, 0);
            AppMethodBeat.o(88474);
            return;
          }
          ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid black update flag %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        AppMethodBeat.o(88474);
      }
    }
    else if ((paramn.equals(this.zZn)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.zZn.ecE();
      paramInt1 = paramString.DTN;
      if (paramInt1 == 1)
      {
        if (this.zZp == null) {
          this.zZp = new ArrayList();
        }
        paramn = paramString.DSZ.iterator();
        while (paramn.hasNext())
        {
          localoi = (oi)paramn.next();
          this.zZp.add(localoi.Username);
        }
        if (paramString.EfS == 1)
        {
          ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync unlike size %d version", new Object[] { Integer.valueOf(paramString.DSZ.size()), Long.valueOf(paramString.ELn) });
          X(paramString.ELn, paramString.EfV);
          AppMethodBeat.o(88474);
          return;
        }
        this.zZj = this.zZp;
        this.zZp = null;
        this.zZl = paramString.ELn;
        ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update unlike version %d total item %d", new Object[] { Long.valueOf(this.zZl), Integer.valueOf(this.zZj.size()) });
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQJ, Long.valueOf(this.zZl));
        ecB();
        if (this.zZr != null)
        {
          this.zZr.adF();
          AppMethodBeat.o(88474);
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update unlike list");
          AppMethodBeat.o(88474);
          return;
        }
        if (paramInt1 == 3)
        {
          ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync unlike list");
          this.zZp = null;
          X(this.zZl, 0);
          AppMethodBeat.o(88474);
          return;
        }
        ac.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid unlike update flag %d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
    AppMethodBeat.o(88474);
  }
  
  public static abstract interface a
  {
    public abstract void adF();
  }
  
  public static abstract interface b
  {
    public abstract void adF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.a
 * JD-Core Version:    0.7.0.1
 */