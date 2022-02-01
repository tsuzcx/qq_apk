package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.am.h
{
  private static a TIr;
  public List<String> Dig;
  public b TIA;
  public List<String> TIs;
  public long TIt;
  public long TIu;
  private com.tencent.mm.plugin.topstory.a.c.c TIv;
  private com.tencent.mm.plugin.topstory.a.c.c TIw;
  private List<String> TIx;
  private List<String> TIy;
  public a TIz;
  
  public a()
  {
    AppMethodBeat.i(88471);
    this.TIt = 1L;
    this.TIu = 1L;
    String str = afg("blacklist");
    if (y.ZC(str)) {}
    try
    {
      this.Dig = Util.stringToList(y.bEn(str), ",");
      this.TIt = com.tencent.mm.kernel.h.baE().ban().a(at.a.acWa, 1L);
      Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "black version %d", new Object[] { Long.valueOf(this.TIt) });
      if (this.Dig == null) {
        this.Dig = new ArrayList();
      }
      str = afg("unlikelist");
      if (!y.ZC(str)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.Dig = Util.stringToList(y.bEn(str), ",");
        this.TIu = com.tencent.mm.kernel.h.baE().ban().a(at.a.acWb, 1L);
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "unlike version %d", new Object[] { Long.valueOf(this.TIu) });
        if (this.TIs == null) {
          this.TIs = new ArrayList();
        }
        com.tencent.mm.kernel.h.aZW().a(2748, this);
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
  
  private static final String afg(String paramString)
  {
    AppMethodBeat.i(88470);
    paramString = new StringBuilder().append(com.tencent.mm.kernel.h.baE().mCJ).append("topstory/").toString() + paramString;
    AppMethodBeat.o(88470);
    return paramString;
  }
  
  public static a hMM()
  {
    AppMethodBeat.i(88469);
    if (TIr == null) {
      TIr = new a();
    }
    a locala = TIr;
    AppMethodBeat.o(88469);
    return locala;
  }
  
  public static void onFinish()
  {
    AppMethodBeat.i(271672);
    if (TIr != null)
    {
      if (TIr.TIv != null)
      {
        com.tencent.mm.kernel.h.aZW().a(TIr.TIv);
        TIr.TIv = null;
      }
      if (TIr.TIw != null)
      {
        com.tencent.mm.kernel.h.aZW().a(TIr.TIw);
        TIr.TIw = null;
      }
      com.tencent.mm.kernel.h.aZW().b(2748, TIr);
      TIr = null;
    }
    AppMethodBeat.o(271672);
  }
  
  public final void aF(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88472);
    if (this.TIv != null) {
      com.tencent.mm.kernel.h.aZW().a(this.TIv);
    }
    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request black version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.TIv = new com.tencent.mm.plugin.topstory.a.c.c(1, paramLong, paramInt);
    com.tencent.mm.kernel.h.baD().mCm.a(this.TIv, 0);
    AppMethodBeat.o(88472);
  }
  
  public final void aG(long paramLong, int paramInt)
  {
    AppMethodBeat.i(88473);
    if (this.TIw != null) {
      com.tencent.mm.kernel.h.aZW().a(this.TIw);
    }
    Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "request unlike version %d offset %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    this.TIw = new com.tencent.mm.plugin.topstory.a.c.c(3, paramLong, paramInt);
    com.tencent.mm.kernel.h.baD().mCm.a(this.TIw, 0);
    AppMethodBeat.o(88473);
  }
  
  public final void hMN()
  {
    AppMethodBeat.i(88475);
    Object localObject = Util.listToString(this.Dig, ",");
    String str = afg("blacklist");
    localObject = ((String)localObject).getBytes();
    y.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88475);
  }
  
  public final void hMO()
  {
    AppMethodBeat.i(88476);
    Object localObject = Util.listToString(this.TIs, ",");
    String str = afg("unlikelist");
    localObject = ((String)localObject).getBytes();
    y.f(str, (byte[])localObject, localObject.length);
    AppMethodBeat.o(88476);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(88474);
    rt localrt;
    if (paramp.equals(this.TIv))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.TIv.hMR();
        paramInt1 = paramString.YJw;
        if (paramInt1 == 1)
        {
          if (this.TIx == null) {
            this.TIx = new ArrayList();
          }
          paramp = paramString.YIB.iterator();
          while (paramp.hasNext())
          {
            localrt = (rt)paramp.next();
            this.TIx.add(localrt.Username);
          }
          if (paramString.YYp == 1)
          {
            Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync black size %d version %d", new Object[] { Integer.valueOf(paramString.YIB.size()), Long.valueOf(paramString.aanC) });
            aF(paramString.aanC, paramString.YYs);
            AppMethodBeat.o(88474);
            return;
          }
          this.Dig = this.TIx;
          this.TIx = null;
          this.TIt = paramString.aanC;
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update black version %d total item %d", new Object[] { Long.valueOf(this.TIt), Integer.valueOf(this.Dig.size()) });
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acWa, Long.valueOf(this.TIt));
          hMN();
          if (this.TIz != null)
          {
            this.TIz.cwC();
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
            this.TIx = null;
            aF(this.TIt, 0);
            AppMethodBeat.o(88474);
            return;
          }
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "invalid black update flag %d", new Object[] { Integer.valueOf(paramInt1) });
        }
        AppMethodBeat.o(88474);
      }
    }
    else if ((paramp.equals(this.TIw)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.TIw.hMR();
      paramInt1 = paramString.YJw;
      if (paramInt1 == 1)
      {
        if (this.TIy == null) {
          this.TIy = new ArrayList();
        }
        paramp = paramString.YIB.iterator();
        while (paramp.hasNext())
        {
          localrt = (rt)paramp.next();
          this.TIy.add(localrt.Username);
        }
        if (paramString.YYp == 1)
        {
          Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "sync unlike size %d version", new Object[] { Integer.valueOf(paramString.YIB.size()), Long.valueOf(paramString.aanC) });
          aG(paramString.aanC, paramString.YYs);
          AppMethodBeat.o(88474);
          return;
        }
        this.TIs = this.TIy;
        this.TIy = null;
        this.TIu = paramString.aanC;
        Log.i("MicroMsg.TopStory.TopStoryBlackListMgr", "update unlike version %d total item %d", new Object[] { Long.valueOf(this.TIu), Integer.valueOf(this.TIs.size()) });
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWb, Long.valueOf(this.TIu));
        hMO();
        if (this.TIA != null)
        {
          this.TIA.cwC();
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
          this.TIy = null;
          aG(this.TIu, 0);
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
    public abstract void cwC();
  }
  
  public static abstract interface b
  {
    public abstract void cwC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.a
 * JD-Core Version:    0.7.0.1
 */