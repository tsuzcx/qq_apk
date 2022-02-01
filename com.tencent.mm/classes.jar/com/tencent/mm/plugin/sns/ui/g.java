package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<btz>
{
  private List<btz> list;
  private String path;
  private String tWM;
  private int ywI;
  private int ywJ;
  private gk yxa;
  private dl yxb;
  private a yxc;
  
  public g(a parama)
  {
    AppMethodBeat.i(97712);
    this.list = new ArrayList();
    this.ywI = 0;
    this.ywJ = 0;
    this.tWM = "";
    this.path = "";
    this.yxc = parama;
    AppMethodBeat.o(97712);
  }
  
  public final List<btz> WX()
  {
    AppMethodBeat.i(97714);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.yxb = null;
      Object localObject1 = this.path + this.tWM + "_ARTISTF.mm";
      Object localObject2;
      if (i.eA((String)localObject1))
      {
        localObject2 = i.aU((String)localObject1, 0, -1);
        this.yxb = ((dl)new dl().parseFrom((byte[])localObject2));
      }
      if (this.yxb == null)
      {
        localObject2 = this.path + this.tWM + "_ARTIST.mm";
        this.yxb = a.auv(new String(i.aU((String)localObject2, 0, (int)i.aSp((String)localObject2))));
        if (this.yxb == null)
        {
          i.deleteFile((String)localObject2);
          AppMethodBeat.o(97714);
          return null;
        }
        i.deleteFile((String)localObject1);
        localObject2 = this.yxb.toByteArray();
        i.f((String)localObject1, (byte[])localObject2, localObject2.length);
      }
      localObject1 = this.yxb;
      if (localObject1 == null)
      {
        AppMethodBeat.o(97714);
        return null;
      }
      localObject1 = this.yxb.GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (bii)((Iterator)localObject1).next();
        localObject2 = ((bii)localObject3).Name;
        localObject3 = ((bii)localObject3).Etz.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          btz localbtz = (btz)((Iterator)localObject3).next();
          localbtz.Desc = ((String)localObject2);
          localArrayList.add(localbtz);
        }
      }
      this.yxa = this.yxb.DQz;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.ArtistAdapterHelper", localException, "loadData failed.", new Object[0]);
      AppMethodBeat.o(97714);
      return null;
    }
    AppMethodBeat.o(97714);
    return localException;
  }
  
  public final void fJ(List<btz> paramList)
  {
    AppMethodBeat.i(97713);
    if (this.yxc != null)
    {
      if (paramList != null)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localHashMap1.clear();
        localHashMap2.clear();
        int n = paramList.size();
        ac.d("MicroMsg.ArtistAdapterHelper", "initFixType ".concat(String.valueOf(n)));
        int j = 0;
        int k = 0;
        int m = 0;
        if (j < n)
        {
          String str = ((btz)paramList.get(j)).Desc;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((btz)paramList.get(j + 1)).Desc)) {
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
              if (!str.equals(((btz)paramList.get(j + 2)).Desc)) {
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
        this.ywI = (k + 1);
        this.ywJ = paramList.size();
        ac.d("MicroMsg.ArtistAdapterHelper", "icount " + this.ywI);
        this.list = paramList;
        this.yxc.a(this.list, localHashMap1, localHashMap2, this.ywJ, this.ywI, this.yxa);
        AppMethodBeat.o(97713);
        return;
      }
      this.yxc.dNb();
    }
    AppMethodBeat.o(97713);
  }
  
  public final void jG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97715);
    this.tWM = paramString1;
    this.path = paramString2;
    mJ(true);
    AppMethodBeat.o(97715);
  }
  
  public static abstract interface a
  {
    public abstract void a(List<btz> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, gk paramgk);
    
    public abstract void dNb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */