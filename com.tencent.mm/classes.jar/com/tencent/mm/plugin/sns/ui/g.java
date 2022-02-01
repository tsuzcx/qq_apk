package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<byn>
{
  private List<byn> list;
  private String path;
  private String uZv;
  private int zNU;
  private int zNV;
  private gr zOm;
  private dm zOn;
  private a zOo;
  
  public g(a parama)
  {
    AppMethodBeat.i(97712);
    this.list = new ArrayList();
    this.zNU = 0;
    this.zNV = 0;
    this.uZv = "";
    this.path = "";
    this.zOo = parama;
    AppMethodBeat.o(97712);
  }
  
  public final List<byn> Zq()
  {
    AppMethodBeat.i(97714);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.zOn = null;
      Object localObject1 = this.path + this.uZv + "_ARTISTF.mm";
      Object localObject2;
      if (i.fv((String)localObject1))
      {
        localObject2 = i.aY((String)localObject1, 0, -1);
        this.zOn = ((dm)new dm().parseFrom((byte[])localObject2));
      }
      if (this.zOn == null)
      {
        localObject2 = this.path + this.uZv + "_ARTIST.mm";
        this.zOn = a.azB(new String(i.aY((String)localObject2, 0, (int)i.aYo((String)localObject2))));
        if (this.zOn == null)
        {
          i.deleteFile((String)localObject2);
          AppMethodBeat.o(97714);
          return null;
        }
        i.deleteFile((String)localObject1);
        localObject2 = this.zOn.toByteArray();
        i.f((String)localObject1, (byte[])localObject2, localObject2.length);
      }
      localObject1 = this.zOn;
      if (localObject1 == null)
      {
        AppMethodBeat.o(97714);
        return null;
      }
      localObject1 = this.zOn.GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (bmq)((Iterator)localObject1).next();
        localObject2 = ((bmq)localObject3).Name;
        localObject3 = ((bmq)localObject3).GaQ.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          byn localbyn = (byn)((Iterator)localObject3).next();
          localbyn.Desc = ((String)localObject2);
          localArrayList.add(localbyn);
        }
      }
      this.zOm = this.zOn.FvO;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ArtistAdapterHelper", localException, "loadData failed.", new Object[0]);
      AppMethodBeat.o(97714);
      return null;
    }
    AppMethodBeat.o(97714);
    return localException;
  }
  
  public final void fU(List<byn> paramList)
  {
    AppMethodBeat.i(97713);
    if (this.zOo != null)
    {
      if (paramList != null)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localHashMap1.clear();
        localHashMap2.clear();
        int n = paramList.size();
        ad.d("MicroMsg.ArtistAdapterHelper", "initFixType ".concat(String.valueOf(n)));
        int j = 0;
        int k = 0;
        int m = 0;
        if (j < n)
        {
          String str = ((byn)paramList.get(j)).Desc;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((byn)paramList.get(j + 1)).Desc)) {
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
              if (!str.equals(((byn)paramList.get(j + 2)).Desc)) {
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
        this.zNU = (k + 1);
        this.zNV = paramList.size();
        ad.d("MicroMsg.ArtistAdapterHelper", "icount " + this.zNU);
        this.list = paramList;
        this.zOo.a(this.list, localHashMap1, localHashMap2, this.zNV, this.zNU, this.zOm);
        AppMethodBeat.o(97713);
        return;
      }
      this.zOo.dZq();
    }
    AppMethodBeat.o(97713);
  }
  
  public final void jT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97715);
    this.uZv = paramString1;
    this.path = paramString2;
    nd(true);
    AppMethodBeat.o(97715);
  }
  
  public static abstract interface a
  {
    public abstract void a(List<byn> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, gr paramgr);
    
    public abstract void dZq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */