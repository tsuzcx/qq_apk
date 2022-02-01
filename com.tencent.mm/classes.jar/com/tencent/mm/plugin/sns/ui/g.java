package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.k.a;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<dmz>
{
  private String Kca;
  private hl RaG;
  private en RaH;
  private a RaI;
  private int Rao;
  private int Rap;
  private List<dmz> list;
  private String path;
  
  public g(a parama)
  {
    AppMethodBeat.i(97712);
    this.list = new ArrayList();
    this.Rao = 0;
    this.Rap = 0;
    this.Kca = "";
    this.path = "";
    this.RaI = parama;
    AppMethodBeat.o(97712);
  }
  
  public final List<dmz> aNv()
  {
    AppMethodBeat.i(97714);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.RaH = null;
      Object localObject1 = this.path + this.Kca + "_ARTISTF.mm";
      Object localObject2;
      if (y.ZC((String)localObject1))
      {
        localObject2 = y.bi((String)localObject1, 0, -1);
        this.RaH = ((en)new en().parseFrom((byte[])localObject2));
      }
      if (this.RaH == null)
      {
        localObject2 = this.path + this.Kca + "_ARTIST.mm";
        this.RaH = a.aZi(new String(y.bi((String)localObject2, 0, (int)y.bEl((String)localObject2))));
        if (this.RaH == null)
        {
          y.deleteFile((String)localObject2);
          AppMethodBeat.o(97714);
          return null;
        }
        y.deleteFile((String)localObject1);
        localObject2 = this.RaH.toByteArray();
        y.f((String)localObject1, (byte[])localObject2, localObject2.length);
      }
      localObject1 = this.RaH;
      if (localObject1 == null)
      {
        AppMethodBeat.o(97714);
        return null;
      }
      localObject1 = this.RaH.GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (cxu)((Iterator)localObject1).next();
        localObject2 = ((cxu)localObject3).IGU;
        localObject3 = ((cxu)localObject3).Zpr.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          dmz localdmz = (dmz)((Iterator)localObject3).next();
          localdmz.IGG = ((String)localObject2);
          localArrayList.add(localdmz);
        }
      }
      this.RaG = this.RaH.YGD;
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
  
  public final void kI(List<dmz> paramList)
  {
    AppMethodBeat.i(97713);
    if (this.RaI != null)
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
          String str = ((dmz)paramList.get(j)).IGG;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((dmz)paramList.get(j + 1)).IGG)) {
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
              if (!str.equals(((dmz)paramList.get(j + 2)).IGG)) {
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
        this.Rao = (k + 1);
        this.Rap = paramList.size();
        Log.d("MicroMsg.ArtistAdapterHelper", "icount " + this.Rao);
        this.list = paramList;
        this.RaI.a(this.list, localHashMap1, localHashMap2, this.Rap, this.Rao, this.RaG);
        AppMethodBeat.o(97713);
        return;
      }
      this.RaI.hlt();
    }
    AppMethodBeat.o(97713);
  }
  
  public final void mT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97715);
    this.Kca = paramString1;
    this.path = paramString2;
    wq(true);
    AppMethodBeat.o(97715);
  }
  
  public static abstract interface a
  {
    public abstract void a(List<dmz> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, hl paramhl);
    
    public abstract void hlt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */