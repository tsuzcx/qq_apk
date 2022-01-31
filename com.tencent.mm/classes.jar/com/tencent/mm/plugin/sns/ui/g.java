package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.protocal.c.anz;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
  extends d<awd>
{
  private String lCN = "";
  private List<awd> list = new ArrayList();
  private el oMM;
  private cq oMN;
  private g.a oMO;
  private int oMu = 0;
  private int oMv = 0;
  private String path = "";
  
  public g(g.a parama)
  {
    this.oMO = parama;
  }
  
  public final void cF(List<awd> paramList)
  {
    if (this.oMO != null)
    {
      if (paramList != null)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localHashMap1.clear();
        localHashMap2.clear();
        int n = paramList.size();
        y.d("MicroMsg.ArtistAdapterHelper", "initFixType " + n);
        int j = 0;
        int k = 0;
        int m = 0;
        if (j < n)
        {
          String str = ((awd)paramList.get(j)).kRN;
          int i;
          if (j + 1 < n)
          {
            if (str.equals(((awd)paramList.get(j + 1)).kRN)) {
              break label194;
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
            label194:
            if (j + 2 < n)
            {
              if (!str.equals(((awd)paramList.get(j + 2)).kRN)) {
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
        this.oMu = (k + 1);
        this.oMv = paramList.size();
        y.d("MicroMsg.ArtistAdapterHelper", "icount " + this.oMu);
        this.list = paramList;
        this.oMO.a(this.list, localHashMap1, localHashMap2, this.oMv, this.oMu, this.oMM);
      }
    }
    else {
      return;
    }
    this.oMO.bHg();
  }
  
  public final void eZ(String paramString1, String paramString2)
  {
    this.lCN = paramString1;
    this.path = paramString2;
    gw(true);
  }
  
  public final List<awd> xY()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.clear();
      this.oMN = null;
      Object localObject1 = this.path + this.lCN + "_ARTISTF.mm";
      Object localObject2;
      if (e.bK((String)localObject1))
      {
        localObject2 = e.c((String)localObject1, 0, -1);
        this.oMN = ((cq)new cq().aH((byte[])localObject2));
      }
      if (this.oMN == null)
      {
        localObject2 = this.path + this.lCN + "_ARTIST.mm";
        this.oMN = a.Oi(new String(e.c((String)localObject2, 0, (int)e.aeQ((String)localObject2))));
        if (this.oMN == null)
        {
          e.deleteFile((String)localObject2);
          return null;
        }
        e.deleteFile((String)localObject1);
        localObject2 = this.oMN.toByteArray();
        e.b((String)localObject1, (byte[])localObject2, localObject2.length);
      }
      if (this.oMN == null) {
        return null;
      }
      localObject1 = this.oMN.swl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (anz)((Iterator)localObject1).next();
        localObject2 = ((anz)localObject3).kRZ;
        localObject3 = ((anz)localObject3).sPJ.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          awd localawd = (awd)((Iterator)localObject3).next();
          localawd.kRN = ((String)localObject2);
          localArrayList.add(localawd);
        }
      }
      this.oMM = this.oMN.swk;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.ArtistAdapterHelper", localException, "loadData failed.", new Object[0]);
      return null;
    }
    return localException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.g
 * JD-Core Version:    0.7.0.1
 */