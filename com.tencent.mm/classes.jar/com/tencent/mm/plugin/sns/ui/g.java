package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.h.a;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<bcs>
{
  private List<bcs> list;
  private String nZZ;
  private String path;
  private int rEf;
  private int rEg;
  private fo rEx;
  private db rEy;
  private g.a rEz;
  
  public g(g.a parama)
  {
    AppMethodBeat.i(38091);
    this.list = new ArrayList();
    this.rEf = 0;
    this.rEg = 0;
    this.nZZ = "";
    this.path = "";
    this.rEz = parama;
    AppMethodBeat.o(38091);
  }
  
  public final List<bcs> Kq()
  {
    AppMethodBeat.i(38093);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.rEy = null;
      Object localObject1 = this.path + this.nZZ + "_ARTISTF.mm";
      Object localObject2;
      if (e.cN((String)localObject1))
      {
        localObject2 = e.i((String)localObject1, 0, -1);
        this.rEy = ((db)new db().parseFrom((byte[])localObject2));
      }
      if (this.rEy == null)
      {
        localObject2 = this.path + this.nZZ + "_ARTIST.mm";
        this.rEy = a.abc(new String(e.i((String)localObject2, 0, (int)e.avI((String)localObject2))));
        if (this.rEy == null)
        {
          e.deleteFile((String)localObject2);
          AppMethodBeat.o(38093);
          return null;
        }
        e.deleteFile((String)localObject1);
        localObject2 = this.rEy.toByteArray();
        e.b((String)localObject1, (byte[])localObject2, localObject2.length);
      }
      localObject1 = this.rEy;
      if (localObject1 == null)
      {
        AppMethodBeat.o(38093);
        return null;
      }
      localObject1 = this.rEy.GroupList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (atp)((Iterator)localObject1).next();
        localObject2 = ((atp)localObject3).Name;
        localObject3 = ((atp)localObject3).wOa.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bcs localbcs = (bcs)((Iterator)localObject3).next();
          localbcs.Desc = ((String)localObject2);
          localArrayList.add(localbcs);
        }
      }
      this.rEx = this.rEy.wpx;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.ArtistAdapterHelper", localException, "loadData failed.", new Object[0]);
      AppMethodBeat.o(38093);
      return null;
    }
    AppMethodBeat.o(38093);
    return localException;
  }
  
  public final void dl(List<bcs> paramList)
  {
    AppMethodBeat.i(38092);
    if (this.rEz != null)
    {
      if (paramList != null)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localHashMap1.clear();
        localHashMap2.clear();
        int n = paramList.size();
        ab.d("MicroMsg.ArtistAdapterHelper", "initFixType ".concat(String.valueOf(n)));
        int j = 0;
        int k = 0;
        int m = 0;
        if (j < n)
        {
          String str = ((bcs)paramList.get(j)).Desc;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((bcs)paramList.get(j + 1)).Desc)) {
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
              if (!str.equals(((bcs)paramList.get(j + 2)).Desc)) {
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
        this.rEf = (k + 1);
        this.rEg = paramList.size();
        ab.d("MicroMsg.ArtistAdapterHelper", "icount " + this.rEf);
        this.list = paramList;
        this.rEz.a(this.list, localHashMap1, localHashMap2, this.rEg, this.rEf, this.rEx);
        AppMethodBeat.o(38092);
        return;
      }
      this.rEz.ctk();
    }
    AppMethodBeat.o(38092);
  }
  
  public final void gH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(38094);
    this.nZZ = paramString1;
    this.path = paramString2;
    ie(true);
    AppMethodBeat.o(38094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */