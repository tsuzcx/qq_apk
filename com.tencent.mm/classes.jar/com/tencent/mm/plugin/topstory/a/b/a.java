package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements i
{
  public static a Gjc;
  public List<String> FjN;
  public List<String> Gjd;
  public long Gje;
  public long Gjf;
  public c Gjg;
  public c Gjh;
  private List<String> Gji;
  private List<String> Gjj;
  public a Gjk;
  public b Gjl;
  
  public a()
  {
    AppMethodBeat.i(88471);
    this.Gje = 1L;
    this.Gjf = 1L;
    String str = aee("blacklist");
    if (s.YS(str)) {}
    try
    {
      this.FjN = Util.stringToList(s.boY(str), ",");
      this.Gje = g.aAh().azQ().a(ar.a.Ogb, 1L);
      Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "black version %d", new Object[] { Long.valueOf(this.Gje) });
      if (this.FjN == null) {
        this.FjN = new ArrayList();
      }
      str = aee("unlikelist");
      if (!s.YS(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.FjN = Util.stringToList(s.boY(str), ",");
        this.Gjf = g.aAh().azQ().a(ar.a.Ogc, 1L);
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "unlike version %d", new Object[] { Long.valueOf(this.Gjf) });
        if (this.Gjd == null) {
          this.Gjd = new ArrayList();
        }
        g.azz().a(2748, this);
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
  
  private static final String aee(String paramString)
  {
    AppMethodBeat.i(88470);
    paramString = new StringBuilder().append(g.aAh().hqG).append("topstory/").toString() + paramString;
    AppMethodBeat.o(88470);
    return paramString;
  }
  
  public static a fxV()
  {
    AppMethodBeat.i(88469);
    if (Gjc == null) {
      Gjc = new a();
    }
    a locala = Gjc;
    AppMethodBeat.o(88469);
    return locala;
  }
  
  public final void ae(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88472);
    if (this.Gjg != null) {
      g.azz().a(this.Gjg);
    }
    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request black version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.Gjg = new c(1, paramLong, paramInt);
    g.aAg().hqi.a(this.Gjg, 0);
    AppMethodBeat.o(88472);
  }
  
  public final void af(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88473);
    if (this.Gjh != null) {
      g.azz().a(this.Gjh);
    }
    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request unlike version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.Gjh = new c(3, paramLong, paramInt);
    g.aAg().hqi.a(this.Gjh, 0);
    AppMethodBeat.o(88473);
  }
  
  public final void fxW()
  {
    AppMethodBeat.i(88475);
    Object localObject = Util.listToString(this.FjN, ",");
    String str = aee("blacklist");
    localObject = ((String)localObject).getBytes();
    s.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88475);
  }
  
  public final void fxX()
  {
    AppMethodBeat.i(88476);
    Object localObject = Util.listToString(this.Gjd, ",");
    String str = aee("unlikelist");
    localObject = ((String)localObject).getBytes();
    s.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88476);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(88474);
    qq localqq;
    if (paramq.equals(this.Gjg))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.Gjg.fya();
        paramInt1 = paramString.KLm;
        if (paramInt1 == 1)
        {
          if (this.Gji == null) {
            this.Gji = new ArrayList();
          }
          paramq = paramString.KKx.iterator();
          while (paramq.hasNext())
          {
            localqq = (qq)paramq.next();
            this.Gji.add(localqq.Username);
          }
          if (paramString.KZh == 1)
          {
            Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync black size %d version %d", new Object[] { Integer.valueOf(paramString.KKx.size()), Long.valueOf(paramString.LRV) });
            ae(paramString.LRV, paramString.KZk);
            AppMethodBeat.o(88474);
            return;
          }
          this.FjN = this.Gji;
          this.Gji = null;
          this.Gje = paramString.LRV;
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update black version %d total item %d", new Object[] { Long.valueOf(this.Gje), Integer.valueOf(this.FjN.size()) });
          g.aAh().azQ().set(ar.a.Ogb, Long.valueOf(this.Gje));
          fxW();
          if (this.Gjk != null)
          {
            this.Gjk.awp();
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
            this.Gji = null;
            ae(this.Gje, 0);
            AppMethodBeat.o(88474);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid black update flag %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        AppMethodBeat.o(88474);
      }
    }
    else if ((paramq.equals(this.Gjh)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.Gjh.fya();
      paramInt1 = paramString.KLm;
      if (paramInt1 == 1)
      {
        if (this.Gjj == null) {
          this.Gjj = new ArrayList();
        }
        paramq = paramString.KKx.iterator();
        while (paramq.hasNext())
        {
          localqq = (qq)paramq.next();
          this.Gjj.add(localqq.Username);
        }
        if (paramString.KZh == 1)
        {
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync unlike size %d version", new Object[] { Integer.valueOf(paramString.KKx.size()), Long.valueOf(paramString.LRV) });
          af(paramString.LRV, paramString.KZk);
          AppMethodBeat.o(88474);
          return;
        }
        this.Gjd = this.Gjj;
        this.Gjj = null;
        this.Gjf = paramString.LRV;
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update unlike version %d total item %d", new Object[] { Long.valueOf(this.Gjf), Integer.valueOf(this.Gjd.size()) });
        g.aAh().azQ().set(ar.a.Ogc, Long.valueOf(this.Gjf));
        fxX();
        if (this.Gjl != null)
        {
          this.Gjl.awp();
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
          this.Gjj = null;
          af(this.Gjf, 0);
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
    public abstract void awp();
  }
  
  public static abstract interface b
  {
    public abstract void awp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.a
 * JD-Core Version:    0.7.0.1
 */