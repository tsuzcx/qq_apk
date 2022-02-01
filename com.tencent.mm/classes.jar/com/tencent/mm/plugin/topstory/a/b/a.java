package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements i
{
  private static a MVN;
  public List<String> Lyy;
  public List<String> MVO;
  public long MVP;
  public long MVQ;
  private com.tencent.mm.plugin.topstory.a.c.c MVR;
  private com.tencent.mm.plugin.topstory.a.c.c MVS;
  private List<String> MVT;
  private List<String> MVU;
  public a MVV;
  public b MVW;
  
  public a()
  {
    AppMethodBeat.i(88471);
    this.MVP = 1L;
    this.MVQ = 1L;
    String str = alY("blacklist");
    if (u.agG(str)) {}
    try
    {
      this.Lyy = Util.stringToList(u.bBS(str), ",");
      this.MVP = h.aHG().aHp().a(ar.a.Vur, 1L);
      Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "black version %d", new Object[] { Long.valueOf(this.MVP) });
      if (this.Lyy == null) {
        this.Lyy = new ArrayList();
      }
      str = alY("unlikelist");
      if (!u.agG(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.Lyy = Util.stringToList(u.bBS(str), ",");
        this.MVQ = h.aHG().aHp().a(ar.a.Vus, 1L);
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "unlike version %d", new Object[] { Long.valueOf(this.MVQ) });
        if (this.MVO == null) {
          this.MVO = new ArrayList();
        }
        h.aGY().a(2748, this);
        AppMethodBeat.o(88471);
        return;
        localException1 = localException1;
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", localException1, "read black cache file", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryBlackListMgr", localException2, "read unlike cache file", new Object[0]);
        }
      }
    }
  }
  
  private static final String alY(String paramString)
  {
    AppMethodBeat.i(88470);
    paramString = new StringBuilder().append(h.aHG().kcB).append("topstory/").toString() + paramString;
    AppMethodBeat.o(88470);
    return paramString;
  }
  
  public static a gpQ()
  {
    AppMethodBeat.i(88469);
    if (MVN == null) {
      MVN = new a();
    }
    a locala = MVN;
    AppMethodBeat.o(88469);
    return locala;
  }
  
  public static void onFinish()
  {
    AppMethodBeat.i(262084);
    if (MVN != null)
    {
      if (MVN.MVR != null)
      {
        h.aGY().a(MVN.MVR);
        MVN.MVR = null;
      }
      if (MVN.MVS != null)
      {
        h.aGY().a(MVN.MVS);
        MVN.MVS = null;
      }
      h.aGY().b(2748, MVN);
      MVN = null;
    }
    AppMethodBeat.o(262084);
  }
  
  public final void an(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88472);
    if (this.MVR != null) {
      h.aGY().a(this.MVR);
    }
    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request black version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.MVR = new com.tencent.mm.plugin.topstory.a.c.c(1, paramLong, paramInt);
    h.aHF().kcd.a(this.MVR, 0);
    AppMethodBeat.o(88472);
  }
  
  public final void ao(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88473);
    if (this.MVS != null) {
      h.aGY().a(this.MVS);
    }
    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request unlike version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.MVS = new com.tencent.mm.plugin.topstory.a.c.c(3, paramLong, paramInt);
    h.aHF().kcd.a(this.MVS, 0);
    AppMethodBeat.o(88473);
  }
  
  public final void gpR()
  {
    AppMethodBeat.i(88475);
    String str = Util.listToString(this.Lyy, ",");
    u.H(alY("blacklist"), str.getBytes());
    AppMethodBeat.o(88475);
  }
  
  public final void gpS()
  {
    AppMethodBeat.i(88476);
    String str = Util.listToString(this.MVO, ",");
    u.H(alY("unlikelist"), str.getBytes());
    AppMethodBeat.o(88476);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(88474);
    qj localqj;
    if (paramq.equals(this.MVR))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.MVR.gpV();
        paramInt1 = paramString.RMi;
        if (paramInt1 == 1)
        {
          if (this.MVT == null) {
            this.MVT = new ArrayList();
          }
          paramq = paramString.RLp.iterator();
          while (paramq.hasNext())
          {
            localqj = (qj)paramq.next();
            this.MVT.add(localqj.Username);
          }
          if (paramString.Saq == 1)
          {
            Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync black size %d version %d", new Object[] { Integer.valueOf(paramString.RLp.size()), Long.valueOf(paramString.TaE) });
            an(paramString.TaE, paramString.Sat);
            AppMethodBeat.o(88474);
            return;
          }
          this.Lyy = this.MVT;
          this.MVT = null;
          this.MVP = paramString.TaE;
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update black version %d total item %d", new Object[] { Long.valueOf(this.MVP), Integer.valueOf(this.Lyy.size()) });
          h.aHG().aHp().set(ar.a.Vur, Long.valueOf(this.MVP));
          gpR();
          if (this.MVV != null)
          {
            this.MVV.bWp();
            AppMethodBeat.o(88474);
          }
        }
        else
        {
          if (paramInt1 == 2)
          {
            Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update black list");
            AppMethodBeat.o(88474);
            return;
          }
          if (paramInt1 == 3)
          {
            Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync black list");
            this.MVT = null;
            an(this.MVP, 0);
            AppMethodBeat.o(88474);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid black update flag %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        AppMethodBeat.o(88474);
      }
    }
    else if ((paramq.equals(this.MVS)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.MVS.gpV();
      paramInt1 = paramString.RMi;
      if (paramInt1 == 1)
      {
        if (this.MVU == null) {
          this.MVU = new ArrayList();
        }
        paramq = paramString.RLp.iterator();
        while (paramq.hasNext())
        {
          localqj = (qj)paramq.next();
          this.MVU.add(localqj.Username);
        }
        if (paramString.Saq == 1)
        {
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync unlike size %d version", new Object[] { Integer.valueOf(paramString.RLp.size()), Long.valueOf(paramString.TaE) });
          ao(paramString.TaE, paramString.Sat);
          AppMethodBeat.o(88474);
          return;
        }
        this.MVO = this.MVU;
        this.MVU = null;
        this.MVQ = paramString.TaE;
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update unlike version %d total item %d", new Object[] { Long.valueOf(this.MVQ), Integer.valueOf(this.MVO.size()) });
        h.aHG().aHp().set(ar.a.Vus, Long.valueOf(this.MVQ));
        gpS();
        if (this.MVW != null)
        {
          this.MVW.bWp();
          AppMethodBeat.o(88474);
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "no need to update unlike list");
          AppMethodBeat.o(88474);
          return;
        }
        if (paramInt1 == 3)
        {
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "resync unlike list");
          this.MVU = null;
          ao(this.MVQ, 0);
          AppMethodBeat.o(88474);
          return;
        }
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid unlike update flag %d", new Object[] { Integer.valueOf(paramInt1) });
      }
    }
    AppMethodBeat.o(88474);
  }
  
  public static abstract interface a
  {
    public abstract void bWp();
  }
  
  public static abstract interface b
  {
    public abstract void bWp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.a
 * JD-Core Version:    0.7.0.1
 */