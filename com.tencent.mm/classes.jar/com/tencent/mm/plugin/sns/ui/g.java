package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<cnb>
{
  private he EnQ;
  private dw EnR;
  private a EnS;
  private int Eny;
  private int Enz;
  private List<cnb> list;
  private String path;
  private String yFy;
  
  public g(a parama)
  {
    AppMethodBeat.i(97712);
    this.list = new ArrayList();
    this.Eny = 0;
    this.Enz = 0;
    this.yFy = "";
    this.path = "";
    this.EnS = parama;
    AppMethodBeat.o(97712);
  }
  
  public final List<cnb> anm()
  {
    AppMethodBeat.i(97714);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.EnR = null;
      Object localObject1 = this.path + this.yFy + "_ARTISTF.mm";
      Object localObject2;
      if (s.YS((String)localObject1))
      {
        localObject2 = s.aW((String)localObject1, 0, -1);
        this.EnR = ((dw)new dw().parseFrom((byte[])localObject2));
      }
      if (this.EnR == null)
      {
        localObject2 = this.path + this.yFy + "_ARTIST.mm";
        this.EnR = a.aPO(new String(s.aW((String)localObject2, 0, (int)s.boW((String)localObject2))));
        if (this.EnR == null)
        {
          s.deleteFile((String)localObject2);
          AppMethodBeat.o(97714);
          return null;
        }
        s.deleteFile((String)localObject1);
        localObject2 = this.EnR.toByteArray();
        s.f((String)localObject1, (byte[])localObject2, localObject2.length);
      }
      localObject1 = this.EnR;
      if (localObject1 == null)
      {
        AppMethodBeat.o(97714);
        return null;
      }
      localObject1 = this.EnR.GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (bzz)((Iterator)localObject1).next();
        localObject2 = ((bzz)localObject3).Name;
        localObject3 = ((bzz)localObject3).LoV.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          cnb localcnb = (cnb)((Iterator)localObject3).next();
          localcnb.Desc = ((String)localObject2);
          localArrayList.add(localcnb);
        }
      }
      this.EnQ = this.EnR.KHT;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ArtistAdapterHelper", localException, "loadData failed.", new Object[0]);
      AppMethodBeat.o(97714);
      return null;
    }
    AppMethodBeat.o(97714);
    return localException;
  }
  
  public final void gZ(List<cnb> paramList)
  {
    AppMethodBeat.i(97713);
    if (this.EnS != null)
    {
      if (paramList != null)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localHashMap1.clear();
        localHashMap2.clear();
        int n = paramList.size();
        Log.d("MicroMsg.ArtistAdapterHelper", "initFixType ".concat(String.valueOf(n)));
        int j = 0;
        int k = 0;
        int m = 0;
        if (j < n)
        {
          String str = ((cnb)paramList.get(j)).Desc;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((cnb)paramList.get(j + 1)).Desc)) {
              break label192;
            }
            i = 1;
          }
          for (;;)
          {
            localHashMap1.put(Integer.valueOf(k), Integer.valueOf(m));
            localHashMap2.put(Integer.valueOf(k), Integer.valueOf(i));
            m += i;
            k += 1;
            j = i + j;
            break;
            i = 1;
            continue;
            label192:
            if (j + 2 < n)
            {
              if (!str.equals(((cnb)paramList.get(j + 2)).Desc)) {
                i = 2;
              }
            }
            else
            {
              i = 2;
              continue;
            }
            i = 3;
          }
        }
        this.Eny = (k + 1);
        this.Enz = paramList.size();
        Log.d("MicroMsg.ArtistAdapterHelper", "icount " + this.Eny);
        this.list = paramList;
        this.EnS.a(this.list, localHashMap1, localHashMap2, this.Enz, this.Eny, this.EnQ);
        AppMethodBeat.o(97713);
        return;
      }
      this.EnS.ffi();
    }
    AppMethodBeat.o(97713);
  }
  
  public final void kO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97715);
    this.yFy = paramString1;
    this.path = paramString2;
    pN(true);
    AppMethodBeat.o(97715);
  }
  
  public static abstract interface a
  {
    public abstract void a(List<cnb> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, he paramhe);
    
    public abstract void ffi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */