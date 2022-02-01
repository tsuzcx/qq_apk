package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<cvt>
{
  private String Ejr;
  private int KAH;
  private int KAI;
  private gs KAZ;
  private dw KBa;
  private a KBb;
  private List<cvt> list;
  private String path;
  
  public g(a parama)
  {
    AppMethodBeat.i(97712);
    this.list = new ArrayList();
    this.KAH = 0;
    this.KAI = 0;
    this.Ejr = "";
    this.path = "";
    this.KBb = parama;
    AppMethodBeat.o(97712);
  }
  
  public final List<cvt> ato()
  {
    AppMethodBeat.i(97714);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.KBa = null;
      Object localObject1 = this.path + this.Ejr + "_ARTISTF.mm";
      Object localObject2;
      if (u.agG((String)localObject1))
      {
        localObject2 = u.aY((String)localObject1, 0, -1);
        this.KBa = ((dw)new dw().parseFrom((byte[])localObject2));
      }
      if (this.KBa == null)
      {
        localObject2 = this.path + this.Ejr + "_ARTIST.mm";
        this.KBa = a.baL(new String(u.aY((String)localObject2, 0, (int)u.bBQ((String)localObject2))));
        if (this.KBa == null)
        {
          u.deleteFile((String)localObject2);
          AppMethodBeat.o(97714);
          return null;
        }
        u.deleteFile((String)localObject1);
        u.H((String)localObject1, this.KBa.toByteArray());
      }
      localObject1 = this.KBa;
      if (localObject1 == null)
      {
        AppMethodBeat.o(97714);
        return null;
      }
      localObject1 = this.KBa.GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (chu)((Iterator)localObject1).next();
        localObject2 = ((chu)localObject3).CMP;
        localObject3 = ((chu)localObject3).Sqr.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          cvt localcvt = (cvt)((Iterator)localObject3).next();
          localcvt.CMB = ((String)localObject2);
          localArrayList.add(localcvt);
        }
      }
      this.KAZ = this.KBa.RJn;
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
  
  public final void hH(List<cvt> paramList)
  {
    AppMethodBeat.i(97713);
    if (this.KBb != null)
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
          String str = ((cvt)paramList.get(j)).CMB;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((cvt)paramList.get(j + 1)).CMB)) {
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
              if (!str.equals(((cvt)paramList.get(j + 2)).CMB)) {
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
        this.KAH = (k + 1);
        this.KAI = paramList.size();
        Log.d("MicroMsg.ArtistAdapterHelper", "icount " + this.KAH);
        this.list = paramList;
        this.KBb.a(this.list, localHashMap1, localHashMap2, this.KAI, this.KAH, this.KAZ);
        AppMethodBeat.o(97713);
        return;
      }
      this.KBb.fTd();
    }
    AppMethodBeat.o(97713);
  }
  
  public final void lk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97715);
    this.Ejr = paramString1;
    this.path = paramString2;
    sk(true);
    AppMethodBeat.o(97715);
  }
  
  public static abstract interface a
  {
    public abstract void a(List<cvt> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, gs paramgs);
    
    public abstract void fTd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */