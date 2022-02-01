package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<bpi>
{
  private List<bpi> list;
  private String path;
  private String sOz;
  private int xjP;
  private int xjQ;
  private gg xkh;
  private dj xki;
  private a xkj;
  
  public g(a parama)
  {
    AppMethodBeat.i(97712);
    this.list = new ArrayList();
    this.xjP = 0;
    this.xjQ = 0;
    this.sOz = "";
    this.path = "";
    this.xkj = parama;
    AppMethodBeat.o(97712);
  }
  
  public final List<bpi> VZ()
  {
    AppMethodBeat.i(97714);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.xki = null;
      Object localObject1 = this.path + this.sOz + "_ARTISTF.mm";
      Object localObject2;
      if (i.eK((String)localObject1))
      {
        localObject2 = i.aR((String)localObject1, 0, -1);
        this.xki = ((dj)new dj().parseFrom((byte[])localObject2));
      }
      if (this.xki == null)
      {
        localObject2 = this.path + this.sOz + "_ARTIST.mm";
        this.xki = a.apj(new String(i.aR((String)localObject2, 0, (int)i.aMN((String)localObject2))));
        if (this.xki == null)
        {
          i.deleteFile((String)localObject2);
          AppMethodBeat.o(97714);
          return null;
        }
        i.deleteFile((String)localObject1);
        localObject2 = this.xki.toByteArray();
        i.f((String)localObject1, (byte[])localObject2, localObject2.length);
      }
      localObject1 = this.xki;
      if (localObject1 == null)
      {
        AppMethodBeat.o(97714);
        return null;
      }
      localObject1 = this.xki.GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (beq)((Iterator)localObject1).next();
        localObject2 = ((beq)localObject3).Name;
        localObject3 = ((beq)localObject3).DaC.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bpi localbpi = (bpi)((Iterator)localObject3).next();
          localbpi.Desc = ((String)localObject2);
          localArrayList.add(localbpi);
        }
      }
      this.xkh = this.xki.Cyd;
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
  
  public final void fB(List<bpi> paramList)
  {
    AppMethodBeat.i(97713);
    if (this.xkj != null)
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
          String str = ((bpi)paramList.get(j)).Desc;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((bpi)paramList.get(j + 1)).Desc)) {
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
              if (!str.equals(((bpi)paramList.get(j + 2)).Desc)) {
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
        this.xjP = (k + 1);
        this.xjQ = paramList.size();
        ad.d("MicroMsg.ArtistAdapterHelper", "icount " + this.xjP);
        this.list = paramList;
        this.xkj.a(this.list, localHashMap1, localHashMap2, this.xjQ, this.xjP, this.xkh);
        AppMethodBeat.o(97713);
        return;
      }
      this.xkj.dyE();
    }
    AppMethodBeat.o(97713);
  }
  
  public final void ji(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97715);
    this.sOz = paramString1;
    this.path = paramString2;
    lQ(true);
    AppMethodBeat.o(97715);
  }
  
  public static abstract interface a
  {
    public abstract void a(List<bpi> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, int paramInt1, int paramInt2, gg paramgg);
    
    public abstract void dyE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */