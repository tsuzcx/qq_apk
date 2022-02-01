package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements f
{
  public static a BqU;
  public List<String> AHn;
  public List<String> BqV;
  public long BqW;
  public long BqX;
  public c BqY;
  public c BqZ;
  private List<String> Bra;
  private List<String> Brb;
  public a Brc;
  public b Brd;
  
  public a()
  {
    AppMethodBeat.i(88471);
    this.BqW = 1L;
    this.BqX = 1L;
    String str = TH("blacklist");
    if (i.fv(str)) {}
    try
    {
      this.AHn = bt.lO(i.aYq(str), ",");
      this.BqW = g.ajC().ajl().a(al.a.IDf, 1L);
      ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "black version %d", new Object[] { Long.valueOf(this.BqW) });
      if (this.AHn == null) {
        this.AHn = new ArrayList();
      }
      str = TH("unlikelist");
      if (!i.fv(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.AHn = bt.lO(i.aYq(str), ",");
        this.BqX = g.ajC().ajl().a(al.a.IDg, 1L);
        ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "unlike version %d", new Object[] { Long.valueOf(this.BqX) });
        if (this.BqV == null) {
          this.BqV = new ArrayList();
        }
        g.aiU().a(2748, this);
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
  
  private static final String TH(String paramString)
  {
    AppMethodBeat.i(88470);
    paramString = new StringBuilder().append(g.ajC().gBm).append("topstory/").toString() + paramString;
    AppMethodBeat.o(88470);
    return paramString;
  }
  
  public static a eoQ()
  {
    AppMethodBeat.i(88469);
    if (BqU == null) {
      BqU = new a();
    }
    a locala = BqU;
    AppMethodBeat.o(88469);
    return locala;
  }
  
  public final void ab(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88472);
    if (this.BqY != null) {
      g.aiU().a(this.BqY);
    }
    ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request black version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.BqY = new c(1, paramLong, paramInt);
    g.ajB().gAO.a(this.BqY, 0);
    AppMethodBeat.o(88472);
  }
  
  public final void ac(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88473);
    if (this.BqZ != null) {
      g.aiU().a(this.BqZ);
    }
    ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request unlike version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.BqZ = new c(3, paramLong, paramInt);
    g.ajB().gAO.a(this.BqZ, 0);
    AppMethodBeat.o(88473);
  }
  
  public final void eoR()
  {
    AppMethodBeat.i(88475);
    Object localObject = bt.m(this.AHn, ",");
    String str = TH("blacklist");
    localObject = ((String)localObject).getBytes();
    i.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88475);
  }
  
  public final void eoS()
  {
    AppMethodBeat.i(88476);
    Object localObject = bt.m(this.BqV, ",");
    String str = TH("unlikelist");
    localObject = ((String)localObject).getBytes();
    i.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88476);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(88474);
    pn localpn;
    if (paramn.equals(this.BqY))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.BqY.eoV();
        paramInt1 = paramString.Fzh;
        if (paramInt1 == 1)
        {
          if (this.Bra == null) {
            this.Bra = new ArrayList();
          }
          paramn = paramString.Fys.iterator();
          while (paramn.hasNext())
          {
            localpn = (pn)paramn.next();
            this.Bra.add(localpn.Username);
          }
          if (paramString.FMr == 1)
          {
            ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync black size %d version %d", new Object[] { Integer.valueOf(paramString.Fys.size()), Long.valueOf(paramString.Guq) });
            ab(paramString.Guq, paramString.FMu);
            AppMethodBeat.o(88474);
            return;
          }
          this.AHn = this.Bra;
          this.Bra = null;
          this.BqW = paramString.Guq;
          ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update black version %d total item %d", new Object[] { Long.valueOf(this.BqW), Integer.valueOf(this.AHn.size()) });
          g.ajC().ajl().set(al.a.IDf, Long.valueOf(this.BqW));
          eoR();
          if (this.Brc != null)
          {
            this.Brc.agl();
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
            this.Bra = null;
            ab(this.BqW, 0);
            AppMethodBeat.o(88474);
            return;
          }
          ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid black update flag %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        AppMethodBeat.o(88474);
      }
    }
    else if ((paramn.equals(this.BqZ)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.BqZ.eoV();
      paramInt1 = paramString.Fzh;
      if (paramInt1 == 1)
      {
        if (this.Brb == null) {
          this.Brb = new ArrayList();
        }
        paramn = paramString.Fys.iterator();
        while (paramn.hasNext())
        {
          localpn = (pn)paramn.next();
          this.Brb.add(localpn.Username);
        }
        if (paramString.FMr == 1)
        {
          ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync unlike size %d version", new Object[] { Integer.valueOf(paramString.Fys.size()), Long.valueOf(paramString.Guq) });
          ac(paramString.Guq, paramString.FMu);
          AppMethodBeat.o(88474);
          return;
        }
        this.BqV = this.Brb;
        this.Brb = null;
        this.BqX = paramString.Guq;
        ad.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update unlike version %d total item %d", new Object[] { Long.valueOf(this.BqX), Integer.valueOf(this.BqV.size()) });
        g.ajC().ajl().set(al.a.IDg, Long.valueOf(this.BqX));
        eoS();
        if (this.Brd != null)
        {
          this.Brd.agl();
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
          this.Brb = null;
          ac(this.BqX, 0);
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
    public abstract void agl();
  }
  
  public static abstract interface b
  {
    public abstract void agl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.a
 * JD-Core Version:    0.7.0.1
 */