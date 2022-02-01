package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private final b rr;
  private int rtv;
  private int rtz;
  String xqI;
  com.tencent.mm.plugin.record.a.k xqJ;
  private SparseArray<ajn> xqK;
  private SparseBooleanArray xqL;
  
  public g(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(9484);
    this.callback = null;
    this.xqI = "";
    this.xqJ = null;
    this.xqK = new SparseArray();
    this.xqL = new SparseBooleanArray();
    this.rtz = 0;
    this.rtv = 0;
    b.a locala = new b.a();
    locala.hNM = new ks();
    locala.hNN = new kt();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.funcId = 632;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.xqJ = paramk;
    AppMethodBeat.o(9484);
  }
  
  private void dEk()
  {
    AppMethodBeat.i(9485);
    this.xqI = k.b.a(p.a(this.xqJ.field_title, this.xqJ.field_desc, this.xqJ.field_dataProto), null, null);
    AppMethodBeat.o(9485);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(9487);
    this.callback = paramf;
    paramf = (ks)this.rr.hNK.hNQ;
    this.xqK.clear();
    this.xqL.clear();
    if (this.xqJ.field_dataProto.nZa.size() == 0)
    {
      ad.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.rtz = -100;
      AppMethodBeat.o(9487);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.rtv;
    ajn localajn;
    if (i < this.xqJ.field_dataProto.nZa.size())
    {
      localajn = (ajn)this.xqJ.field_dataProto.nZa.get(i);
      if ((!localajn.Ghj) || (!bt.isNullOrNil(localajn.GgR))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.rtv = (i + 1);
      paramf.nDi = localLinkedList.size();
      paramf.nDj.clear();
      paramf.nDj.addAll(localLinkedList);
      ad.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.xqJ.field_dataProto.nZa.size()), Integer.valueOf(this.xqK.size()), Integer.valueOf(this.rtv) });
      if ((paramf.nDi <= 0) || (j == 0))
      {
        dEk();
        ad.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.rtz = -100;
        AppMethodBeat.o(9487);
        return -100;
        dop localdop;
        if (!bt.isNullOrNil(localajn.GgR))
        {
          localdop = new dop();
          localdop.FAe = localajn.GgR;
          localdop.AesKey = localajn.GgT;
          localdop.HCZ = localajn.dataType;
          localdop.tSu = ((int)localajn.Ghm);
          localdop.HCY = bt.bI(localajn.dsU, "").hashCode();
          ad.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localdop.HCY), localajn.dsU, Integer.valueOf(localdop.HCZ), localajn.GgR, Long.valueOf(localajn.Ghm) });
          localLinkedList.add(localdop);
          this.xqK.put(localdop.HCY, localajn);
          this.xqL.put(localdop.HCY, false);
        }
        if (!bt.isNullOrNil(localajn.hAe))
        {
          localdop = new dop();
          localdop.FAe = localajn.hAe;
          localdop.AesKey = localajn.GgN;
          localdop.HCZ = 2;
          localdop.tSu = ((int)localajn.Ghx);
          localdop.HCY = (bt.bI(localajn.dsU, "") + "@thumb").hashCode();
          ad.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localdop.HCY), localajn.dsU, Integer.valueOf(localdop.HCZ), localajn.hAe, Long.valueOf(localajn.Ghx) });
          localLinkedList.add(localdop);
          this.xqK.put(localdop.HCY, localajn);
          this.xqL.put(localdop.HCY, true);
        }
        if (localLinkedList.size() >= 20) {
          continue;
        }
        i += 1;
        break;
      }
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(9487);
      return i;
    }
  }
  
  public final int getType()
  {
    return 632;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9486);
    ad.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.rtz), Integer.valueOf(this.rtv), paramString });
    if ((paramInt2 == 3) && (this.rtz == -100))
    {
      dEk();
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(9486);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9486);
      return;
    }
    paramq = ((kt)((b)paramq).hNL.hNQ).nDj.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (dop)paramq.next();
      ajn localajn = (ajn)this.xqK.get(paramArrayOfByte.HCY);
      if (localajn != null) {
        if (this.xqL.get(paramArrayOfByte.HCY))
        {
          ad.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.HCY), localajn.dsU, localajn.hAe, paramArrayOfByte.FAe, Long.valueOf(localajn.Ghx), Long.valueOf(paramArrayOfByte.tSu) });
          localajn.aOh(paramArrayOfByte.FAe);
          localajn.aOi(paramArrayOfByte.AesKey);
          if ((!bt.isNullOrNil(paramArrayOfByte.FAe)) && (!bt.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.tSu > 0L))
          {
            localajn.CH(paramArrayOfByte.tSu);
          }
          else
          {
            ad.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          ad.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.HCY), localajn.dsU, localajn.GgR, paramArrayOfByte.FAe, Long.valueOf(localajn.Ghm), Long.valueOf(paramArrayOfByte.tSu) });
          localajn.aOj(paramArrayOfByte.FAe);
          localajn.aOk(paramArrayOfByte.AesKey);
          if ((!bt.isNullOrNil(paramArrayOfByte.FAe)) && (!bt.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.tSu > 0L))
          {
            localajn.CG(paramArrayOfByte.tSu);
          }
          else
          {
            ad.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
      }
    }
    boolean bool;
    if (this.rtv < this.xqJ.field_dataProto.nZa.size())
    {
      bool = true;
      ad.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break label631;
      }
      if (doScene(dispatcher(), this.callback) != -100) {
        break label626;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        ad.i("MicroMsg.NetSceneTransCDN", "do callback");
        dEk();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(9486);
      return;
      bool = false;
      break;
      label626:
      paramInt1 = 0;
      continue;
      label631:
      paramInt1 = 1;
    }
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.g
 * JD-Core Version:    0.7.0.1
 */