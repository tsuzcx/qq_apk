package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements f
{
  public static a BIt;
  public List<String> AYQ;
  private List<String> BIA;
  public a BIB;
  public b BIC;
  public List<String> BIu;
  public long BIv;
  public long BIw;
  public c BIx;
  public c BIy;
  private List<String> BIz;
  
  public a()
  {
    AppMethodBeat.i(88471);
    this.BIv = 1L;
    this.BIw = 1L;
    String str = Uq("blacklist");
    if (o.fB(str)) {}
    try
    {
      this.AYQ = bu.lV(o.aZT(str), ",");
      this.BIv = g.ajR().ajA().a(am.a.IXF, 1L);
      ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "black version %d", new Object[] { Long.valueOf(this.BIv) });
      if (this.AYQ == null) {
        this.AYQ = new ArrayList();
      }
      str = Uq("unlikelist");
      if (!o.fB(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.AYQ = bu.lV(o.aZT(str), ",");
        this.BIw = g.ajR().ajA().a(am.a.IXG, 1L);
        ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "unlike version %d", new Object[] { Long.valueOf(this.BIw) });
        if (this.BIu == null) {
          this.BIu = new ArrayList();
        }
        g.ajj().a(2748, this);
        AppMethodBeat.o(88471);
        return;
        localException1 = localException1;
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", localException1, "read black cache file", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", localException2, "read unlike cache file", new Object[0]);
        }
      }
    }
  }
  
  private static final String Uq(String paramString)
  {
    AppMethodBeat.i(88470);
    paramString = new StringBuilder().append(g.ajR().gDT).append("topstory/").toString() + paramString;
    AppMethodBeat.o(88470);
    return paramString;
  }
  
  public static a esx()
  {
    AppMethodBeat.i(88469);
    if (BIt == null) {
      BIt = new a();
    }
    a locala = BIt;
    AppMethodBeat.o(88469);
    return locala;
  }
  
  public final void ab(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88472);
    if (this.BIx != null) {
      g.ajj().a(this.BIx);
    }
    ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request black version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.BIx = new c(1, paramLong, paramInt);
    g.ajQ().gDv.a(this.BIx, 0);
    AppMethodBeat.o(88472);
  }
  
  public final void ac(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88473);
    if (this.BIy != null) {
      g.ajj().a(this.BIy);
    }
    ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request unlike version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.BIy = new c(3, paramLong, paramInt);
    g.ajQ().gDv.a(this.BIy, 0);
    AppMethodBeat.o(88473);
  }
  
  public final void esy()
  {
    AppMethodBeat.i(88475);
    Object localObject = bu.m(this.AYQ, ",");
    String str = Uq("blacklist");
    localObject = ((String)localObject).getBytes();
    o.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88475);
  }
  
  public final void esz()
  {
    AppMethodBeat.i(88476);
    Object localObject = bu.m(this.BIu, ",");
    String str = Uq("unlikelist");
    localObject = ((String)localObject).getBytes();
    o.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88476);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(88474);
    pp localpp;
    if (paramn.equals(this.BIx))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.BIx.esC();
        paramInt1 = paramString.FRF;
        if (paramInt1 == 1)
        {
          if (this.BIz == null) {
            this.BIz = new ArrayList();
          }
          paramn = paramString.FQQ.iterator();
          while (paramn.hasNext())
          {
            localpp = (pp)paramn.next();
            this.BIz.add(localpp.Username);
          }
          if (paramString.GeQ == 1)
          {
            ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync black size %d version %d", new Object[] { Integer.valueOf(paramString.FQQ.size()), Long.valueOf(paramString.GNP) });
            ab(paramString.GNP, paramString.GeT);
            AppMethodBeat.o(88474);
            return;
          }
          this.AYQ = this.BIz;
          this.BIz = null;
          this.BIv = paramString.GNP;
          ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update black version %d total item %d", new Object[] { Long.valueOf(this.BIv), Integer.valueOf(this.AYQ.size()) });
          g.ajR().ajA().set(am.a.IXF, Long.valueOf(this.BIv));
          esy();
          if (this.BIB != null)
          {
            this.BIB.agz();
            AppMethodBeat.o(88474);
          }
        }
        else
        {
          if (paramInt1 == 2)
          {
            ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update black list");
            AppMethodBeat.o(88474);
            return;
          }
          if (paramInt1 == 3)
          {
            ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync black list");
            this.BIz = null;
            ab(this.BIv, 0);
            AppMethodBeat.o(88474);
            return;
          }
          ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid black update flag %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        AppMethodBeat.o(88474);
      }
    }
    else if ((paramn.equals(this.BIy)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.BIy.esC();
      paramInt1 = paramString.FRF;
      if (paramInt1 == 1)
      {
        if (this.BIA == null) {
          this.BIA = new ArrayList();
        }
        paramn = paramString.FQQ.iterator();
        while (paramn.hasNext())
        {
          localpp = (pp)paramn.next();
          this.BIA.add(localpp.Username);
        }
        if (paramString.GeQ == 1)
        {
          ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync unlike size %d version", new Object[] { Integer.valueOf(paramString.FQQ.size()), Long.valueOf(paramString.GNP) });
          ac(paramString.GNP, paramString.GeT);
          AppMethodBeat.o(88474);
          return;
        }
        this.BIu = this.BIA;
        this.BIA = null;
        this.BIw = paramString.GNP;
        ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update unlike version %d total item %d", new Object[] { Long.valueOf(this.BIw), Integer.valueOf(this.BIu.size()) });
        g.ajR().ajA().set(am.a.IXG, Long.valueOf(this.BIw));
        esz();
        if (this.BIC != null)
        {
          this.BIC.agz();
          AppMethodBeat.o(88474);
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update unlike list");
          AppMethodBeat.o(88474);
          return;
        }
        if (paramInt1 == 3)
        {
          ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync unlike list");
          this.BIA = null;
          ac(this.BIw, 0);
          AppMethodBeat.o(88474);
          return;
        }
        ae.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid unlike update flag %d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
    AppMethodBeat.o(88474);
  }
  
  public static abstract interface a
  {
    public abstract void agz();
  }
  
  public static abstract interface b
  {
    public abstract void agz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.a
 * JD-Core Version:    0.7.0.1
 */