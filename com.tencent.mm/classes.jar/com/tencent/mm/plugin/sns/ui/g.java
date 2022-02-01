package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<bzh>
{
  private int Afb;
  private int Afc;
  private gr Aft;
  private dm Afu;
  private a Afv;
  private List<bzh> list;
  private String path;
  private String vlG;
  
  public g(a parama)
  {
    AppMethodBeat.i(97712);
    this.list = new ArrayList();
    this.Afb = 0;
    this.Afc = 0;
    this.vlG = "";
    this.path = "";
    this.Afv = parama;
    AppMethodBeat.o(97712);
  }
  
  public final List<bzh> Zz()
  {
    AppMethodBeat.i(97714);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.Afu = null;
      Object localObject1 = this.path + this.vlG + "_ARTISTF.mm";
      Object localObject2;
      if (o.fB((String)localObject1))
      {
        localObject2 = o.bb((String)localObject1, 0, -1);
        this.Afu = ((dm)new dm().parseFrom((byte[])localObject2));
      }
      if (this.Afu == null)
      {
        localObject2 = this.path + this.vlG + "_ARTIST.mm";
        this.Afu = a.aAS(new String(o.bb((String)localObject2, 0, (int)o.aZR((String)localObject2))));
        if (this.Afu == null)
        {
          o.deleteFile((String)localObject2);
          AppMethodBeat.o(97714);
          return null;
        }
        o.deleteFile((String)localObject1);
        localObject2 = this.Afu.toByteArray();
        o.f((String)localObject1, (byte[])localObject2, localObject2.length);
      }
      localObject1 = this.Afu;
      if (localObject1 == null)
      {
        AppMethodBeat.o(97714);
        return null;
      }
      localObject1 = this.Afu.GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (bni)((Iterator)localObject1).next();
        localObject2 = ((bni)localObject3).Name;
        localObject3 = ((bni)localObject3).Gtx.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bzh localbzh = (bzh)((Iterator)localObject3).next();
          localbzh.Desc = ((String)localObject2);
          localArrayList.add(localbzh);
        }
      }
      this.Aft = this.Afu.FOm;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.ArtistAdapterHelper", localException, "loadData failed.", new Object[0]);
      AppMethodBeat.o(97714);
      return null;
    }
    AppMethodBeat.o(97714);
    return localException;
  }
  
  public final void gd(List<bzh> paramList)
  {
    AppMethodBeat.i(97713);
    if (this.Afv != null)
    {
      if (paramList != null)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localHashMap1.clear();
        localHashMap2.clear();
        int n = paramList.size();
        ae.d("MicroMsg.ArtistAdapterHelper", "initFixType ".concat(String.valueOf(n)));
        int j = 0;
        int k = 0;
        int m = 0;
        if (j < n)
        {
          String str = ((bzh)paramList.get(j)).Desc;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((bzh)paramList.get(j + 1)).Desc)) {
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
              if (!str.equals(((bzh)paramList.get(j + 2)).Desc)) {
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
        this.Afb = (k + 1);
        this.Afc = paramList.size();
        ae.d("MicroMsg.ArtistAdapterHelper", "icount " + this.Afb);
        this.list = paramList;
        this.Afv.a(this.list, localHashMap1, localHashMap2, this.Afc, this.Afb, this.Aft);
        AppMethodBeat.o(97713);
        return;
      }
      this.Afv.ecV();
    }
    AppMethodBeat.o(97713);
  }
  
  public final void ka(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97715);
    this.vlG = paramString1;
    this.path = paramString2;
    nh(true);
    AppMethodBeat.o(97715);
  }
  
  public static abstract interface a
  {
    public abstract void a(List<bzh> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, gr paramgr);
    
    public abstract void ecV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */