package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.byp;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.protocal.c.hk;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  private final b dmK;
  private f dmL = null;
  private int jZI = 0;
  private int jZM = 0;
  String nsK = "";
  g nsL = null;
  private SparseArray<xv> nsM = new SparseArray();
  private SparseBooleanArray nsN = new SparseBooleanArray();
  
  public a(g paramg)
  {
    b.a locala = new b.a();
    locala.ecH = new hj();
    locala.ecI = new hk();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.ecG = 632;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.nsL = paramg;
  }
  
  private void bvv()
  {
    this.nsK = g.a.a(h.a(this.nsL.field_title, this.nsL.field_desc, this.nsL.field_dataProto), null, null);
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (hj)this.dmK.ecE.ecN;
    this.nsM.clear();
    this.nsN.clear();
    if (this.nsL.field_dataProto.sXc.size() == 0)
    {
      y.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.jZM = -100;
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.jZI;
    xv localxv;
    if (i < this.nsL.field_dataProto.sXc.size())
    {
      localxv = (xv)this.nsL.field_dataProto.sXc.get(i);
      if ((!localxv.sUY) || (!bk.bl(localxv.sUG))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.jZI = (i + 1);
      paramf.hPS = localLinkedList.size();
      paramf.hPT.clear();
      paramf.hPT.addAll(localLinkedList);
      y.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.nsL.field_dataProto.sXc.size()), Integer.valueOf(this.nsM.size()), Integer.valueOf(this.jZI) });
      if ((paramf.hPS <= 0) || (j == 0))
      {
        bvv();
        y.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.jZM = -100;
        return -100;
        byp localbyp;
        if (!bk.bl(localxv.sUG))
        {
          localbyp = new byp();
          localbyp.sGU = localxv.sUG;
          localbyp.sRu = localxv.sUI;
          localbyp.tOP = localxv.aYU;
          localbyp.tOQ = ((int)localxv.sVb);
          localbyp.tOO = bk.aM(localxv.kgC, "").hashCode();
          y.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localbyp.tOO), localxv.kgC, Integer.valueOf(localbyp.tOP), localxv.sUG, Long.valueOf(localxv.sVb) });
          localLinkedList.add(localbyp);
          this.nsM.put(localbyp.tOO, localxv);
          this.nsN.put(localbyp.tOO, false);
        }
        if (!bk.bl(localxv.dQL))
        {
          localbyp = new byp();
          localbyp.sGU = localxv.dQL;
          localbyp.sRu = localxv.sUC;
          localbyp.tOP = 2;
          localbyp.tOQ = ((int)localxv.sVm);
          localbyp.tOO = (bk.aM(localxv.kgC, "") + "@thumb").hashCode();
          y.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localbyp.tOO), localxv.kgC, Integer.valueOf(localbyp.tOP), localxv.dQL, Long.valueOf(localxv.sVm) });
          localLinkedList.add(localbyp);
          this.nsM.put(localbyp.tOO, localxv);
          this.nsN.put(localbyp.tOO, true);
        }
        if (localLinkedList.size() >= 20) {
          continue;
        }
        i += 1;
        break;
      }
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.jZM), Integer.valueOf(this.jZI), paramString });
    if ((paramInt2 == 3) && (this.jZM == -100))
    {
      bvv();
      this.dmL.onSceneEnd(0, 0, paramString, this);
    }
    label602:
    label607:
    label610:
    for (;;)
    {
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      paramq = ((hk)((b)paramq).ecF.ecN).hPT.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (byp)paramq.next();
        xv localxv = (xv)this.nsM.get(paramArrayOfByte.tOO);
        if (localxv != null) {
          if (this.nsN.get(paramArrayOfByte.tOO))
          {
            y.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.tOO), localxv.kgC, localxv.dQL, paramArrayOfByte.sGU, Long.valueOf(localxv.sVm), Long.valueOf(paramArrayOfByte.tOQ) });
            localxv.Xw(paramArrayOfByte.sGU);
            localxv.Xx(paramArrayOfByte.sRu);
            if ((!bk.bl(paramArrayOfByte.sGU)) && (!bk.bl(paramArrayOfByte.sRu)) && (paramArrayOfByte.tOQ > 0L))
            {
              localxv.hg(paramArrayOfByte.tOQ);
            }
            else
            {
              y.w("MicroMsg.NetSceneTransCDN", "match error server return");
              paramInt2 = 3;
            }
          }
          else
          {
            y.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.tOO), localxv.kgC, localxv.sUG, paramArrayOfByte.sGU, Long.valueOf(localxv.sVb), Long.valueOf(paramArrayOfByte.tOQ) });
            localxv.Xy(paramArrayOfByte.sGU);
            localxv.Xz(paramArrayOfByte.sRu);
            if ((!bk.bl(paramArrayOfByte.sGU)) && (!bk.bl(paramArrayOfByte.sRu)) && (paramArrayOfByte.tOQ > 0L))
            {
              localxv.hf(paramArrayOfByte.tOQ);
            }
            else
            {
              y.w("MicroMsg.NetSceneTransCDN", "match error server return");
              paramInt2 = 3;
            }
          }
        }
      }
      boolean bool;
      if (this.jZI < this.nsL.field_dataProto.sXc.size())
      {
        bool = true;
        y.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label607;
        }
        if (a(this.edc, this.dmL) != -100) {
          break label602;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 == 0) {
          break label610;
        }
        y.i("MicroMsg.NetSceneTransCDN", "do callback");
        bvv();
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        bool = false;
        break;
        paramInt1 = 0;
        continue;
        paramInt1 = 1;
      }
    }
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 632;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.a
 * JD-Core Version:    0.7.0.1
 */