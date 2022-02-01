package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.ob;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.al.g
{
  public static a yLp;
  public List<String> yLq;
  public long yLr;
  public long yLs;
  public c yLt;
  public c yLu;
  private List<String> yLv;
  private List<String> yLw;
  public a yLx;
  public b yLy;
  public List<String> yct;
  
  public a()
  {
    AppMethodBeat.i(88471);
    this.yLr = 1L;
    this.yLs = 1L;
    String str = LW("blacklist");
    if (i.eK(str)) {}
    try
    {
      this.yct = bt.kS(i.aMP(str), ",");
      this.yLr = com.tencent.mm.kernel.g.afB().afk().a(ae.a.FsQ, 1L);
      ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "black version %d", new Object[] { Long.valueOf(this.yLr) });
      if (this.yct == null) {
        this.yct = new ArrayList();
      }
      str = LW("unlikelist");
      if (!i.eK(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.yct = bt.kS(i.aMP(str), ",");
        this.yLs = com.tencent.mm.kernel.g.afB().afk().a(ae.a.FsR, 1L);
        ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "unlike version %d", new Object[] { Long.valueOf(this.yLs) });
        if (this.yLq == null) {
          this.yLq = new ArrayList();
        }
        com.tencent.mm.kernel.g.aeS().a(2748, this);
        AppMethodBeat.o(88471);
        return;
        localException1 = localException1;
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", localException1, "read black cache file", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", localException2, "read unlike cache file", new Object[0]);
        }
      }
    }
  }
  
  private static final String LW(String paramString)
  {
    AppMethodBeat.i(88470);
    paramString = new StringBuilder().append(com.tencent.mm.kernel.g.afB().gcW).append("topstory/").toString() + paramString;
    AppMethodBeat.o(88470);
    return paramString;
  }
  
  public static a dNZ()
  {
    AppMethodBeat.i(88469);
    if (yLp == null) {
      yLp = new a();
    }
    a locala = yLp;
    AppMethodBeat.o(88469);
    return locala;
  }
  
  public final void T(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88472);
    if (this.yLt != null) {
      com.tencent.mm.kernel.g.aeS().a(this.yLt);
    }
    ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request black version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.yLt = new c(1, paramLong, paramInt);
    com.tencent.mm.kernel.g.afA().gcy.a(this.yLt, 0);
    AppMethodBeat.o(88472);
  }
  
  public final void U(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88473);
    if (this.yLu != null) {
      com.tencent.mm.kernel.g.aeS().a(this.yLu);
    }
    ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request unlike version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.yLu = new c(3, paramLong, paramInt);
    com.tencent.mm.kernel.g.afA().gcy.a(this.yLu, 0);
    AppMethodBeat.o(88473);
  }
  
  public final void dOa()
  {
    AppMethodBeat.i(88475);
    Object localObject = bt.n(this.yct, ",");
    String str = LW("blacklist");
    localObject = ((String)localObject).getBytes();
    i.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88475);
  }
  
  public final void dOb()
  {
    AppMethodBeat.i(88476);
    Object localObject = bt.n(this.yLq, ",");
    String str = LW("unlikelist");
    localObject = ((String)localObject).getBytes();
    i.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88476);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(88474);
    ob localob;
    if (paramn.equals(this.yLt))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.yLt.dOe();
        paramInt1 = paramString.CBp;
        if (paramInt1 == 1)
        {
          if (this.yLv == null) {
            this.yLv = new ArrayList();
          }
          paramn = paramString.CAD.iterator();
          while (paramn.hasNext())
          {
            localob = (ob)paramn.next();
            this.yLv.add(localob.Username);
          }
          if (paramString.CNq == 1)
          {
            ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync black size %d version %d", new Object[] { Integer.valueOf(paramString.CAD.size()), Long.valueOf(paramString.Dql) });
            T(paramString.Dql, paramString.CNt);
            AppMethodBeat.o(88474);
            return;
          }
          this.yct = this.yLv;
          this.yLv = null;
          this.yLr = paramString.Dql;
          ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update black version %d total item %d", new Object[] { Long.valueOf(this.yLr), Integer.valueOf(this.yct.size()) });
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsQ, Long.valueOf(this.yLr));
          dOa();
          if (this.yLx != null)
          {
            this.yLx.acz();
            AppMethodBeat.o(88474);
          }
        }
        else
        {
          if (paramInt1 == 2)
          {
            ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update black list");
            AppMethodBeat.o(88474);
            return;
          }
          if (paramInt1 == 3)
          {
            ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync black list");
            this.yLv = null;
            T(this.yLr, 0);
            AppMethodBeat.o(88474);
            return;
          }
          ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid black update flag %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        AppMethodBeat.o(88474);
      }
    }
    else if ((paramn.equals(this.yLu)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.yLu.dOe();
      paramInt1 = paramString.CBp;
      if (paramInt1 == 1)
      {
        if (this.yLw == null) {
          this.yLw = new ArrayList();
        }
        paramn = paramString.CAD.iterator();
        while (paramn.hasNext())
        {
          localob = (ob)paramn.next();
          this.yLw.add(localob.Username);
        }
        if (paramString.CNq == 1)
        {
          ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync unlike size %d version", new Object[] { Integer.valueOf(paramString.CAD.size()), Long.valueOf(paramString.Dql) });
          U(paramString.Dql, paramString.CNt);
          AppMethodBeat.o(88474);
          return;
        }
        this.yLq = this.yLw;
        this.yLw = null;
        this.yLs = paramString.Dql;
        ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update unlike version %d total item %d", new Object[] { Long.valueOf(this.yLs), Integer.valueOf(this.yLq.size()) });
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsR, Long.valueOf(this.yLs));
        dOb();
        if (this.yLy != null)
        {
          this.yLy.acz();
          AppMethodBeat.o(88474);
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update unlike list");
          AppMethodBeat.o(88474);
          return;
        }
        if (paramInt1 == 3)
        {
          ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync unlike list");
          this.yLw = null;
          U(this.yLs, 0);
          AppMethodBeat.o(88474);
          return;
        }
        ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid unlike update flag %d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
    AppMethodBeat.o(88474);
  }
  
  public static abstract interface a
  {
    public abstract void acz();
  }
  
  public static abstract interface b
  {
    public abstract void acz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.a
 * JD-Core Version:    0.7.0.1
 */