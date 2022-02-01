package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.dpm;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private int rBH;
  private int rBL;
  private final b rr;
  String xGF;
  com.tencent.mm.plugin.record.a.k xGG;
  private SparseArray<ajx> xGH;
  private SparseBooleanArray xGI;
  
  public g(com.tencent.mm.plugin.record.a.k paramk)
  {
    AppMethodBeat.i(9484);
    this.callback = null;
    this.xGF = "";
    this.xGG = null;
    this.xGH = new SparseArray();
    this.xGI = new SparseBooleanArray();
    this.rBL = 0;
    this.rBH = 0;
    b.a locala = new b.a();
    locala.hQF = new ks();
    locala.hQG = new kt();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.funcId = 632;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.xGG = paramk;
    AppMethodBeat.o(9484);
  }
  
  private void dHB()
  {
    AppMethodBeat.i(9485);
    this.xGF = k.b.a(p.a(this.xGG.field_title, this.xGG.field_desc, this.xGG.field_dataProto), null, null);
    AppMethodBeat.o(9485);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(9487);
    this.callback = paramf;
    paramf = (ks)this.rr.hQD.hQJ;
    this.xGH.clear();
    this.xGI.clear();
    if (this.xGG.field_dataProto.oeJ.size() == 0)
    {
      ae.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.rBL = -100;
      AppMethodBeat.o(9487);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.rBH;
    ajx localajx;
    if (i < this.xGG.field_dataProto.oeJ.size())
    {
      localajx = (ajx)this.xGG.field_dataProto.oeJ.get(i);
      if ((!localajx.GzS) || (!bu.isNullOrNil(localajx.GzA))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.rBH = (i + 1);
      paramf.nID = localLinkedList.size();
      paramf.nIE.clear();
      paramf.nIE.addAll(localLinkedList);
      ae.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.xGG.field_dataProto.oeJ.size()), Integer.valueOf(this.xGH.size()), Integer.valueOf(this.rBH) });
      if ((paramf.nID <= 0) || (j == 0))
      {
        dHB();
        ae.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.rBL = -100;
        AppMethodBeat.o(9487);
        return -100;
        dpm localdpm;
        if (!bu.isNullOrNil(localajx.GzA))
        {
          localdpm = new dpm();
          localdpm.FSC = localajx.GzA;
          localdpm.AesKey = localajx.GzC;
          localdpm.HWM = localajx.dataType;
          localdpm.udl = ((int)localajx.GzV);
          localdpm.HWL = bu.bI(localajx.dua, "").hashCode();
          ae.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localdpm.HWL), localajx.dua, Integer.valueOf(localdpm.HWM), localajx.GzA, Long.valueOf(localajx.GzV) });
          localLinkedList.add(localdpm);
          this.xGH.put(localdpm.HWL, localajx);
          this.xGI.put(localdpm.HWL, false);
        }
        if (!bu.isNullOrNil(localajx.hCS))
        {
          localdpm = new dpm();
          localdpm.FSC = localajx.hCS;
          localdpm.AesKey = localajx.Gzw;
          localdpm.HWM = 2;
          localdpm.udl = ((int)localajx.GAg);
          localdpm.HWL = (bu.bI(localajx.dua, "") + "@thumb").hashCode();
          ae.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localdpm.HWL), localajx.dua, Integer.valueOf(localdpm.HWM), localajx.hCS, Long.valueOf(localajx.GAg) });
          localLinkedList.add(localdpm);
          this.xGH.put(localdpm.HWL, localajx);
          this.xGI.put(localdpm.HWL, true);
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
    ae.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.rBL), Integer.valueOf(this.rBH), paramString });
    if ((paramInt2 == 3) && (this.rBL == -100))
    {
      dHB();
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
    paramq = ((kt)((b)paramq).hQE.hQJ).nIE.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (dpm)paramq.next();
      ajx localajx = (ajx)this.xGH.get(paramArrayOfByte.HWL);
      if (localajx != null) {
        if (this.xGI.get(paramArrayOfByte.HWL))
        {
          ae.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.HWL), localajx.dua, localajx.hCS, paramArrayOfByte.FSC, Long.valueOf(localajx.GAg), Long.valueOf(paramArrayOfByte.udl) });
          localajx.aPE(paramArrayOfByte.FSC);
          localajx.aPF(paramArrayOfByte.AesKey);
          if ((!bu.isNullOrNil(paramArrayOfByte.FSC)) && (!bu.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.udl > 0L))
          {
            localajx.Df(paramArrayOfByte.udl);
          }
          else
          {
            ae.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          ae.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.HWL), localajx.dua, localajx.GzA, paramArrayOfByte.FSC, Long.valueOf(localajx.GzV), Long.valueOf(paramArrayOfByte.udl) });
          localajx.aPG(paramArrayOfByte.FSC);
          localajx.aPH(paramArrayOfByte.AesKey);
          if ((!bu.isNullOrNil(paramArrayOfByte.FSC)) && (!bu.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.udl > 0L))
          {
            localajx.De(paramArrayOfByte.udl);
          }
          else
          {
            ae.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
      }
    }
    boolean bool;
    if (this.rBH < this.xGG.field_dataProto.oeJ.size())
    {
      bool = true;
      ae.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
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
        ae.i("MicroMsg.NetSceneTransCDN", "do callback");
        dHB();
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
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.g
 * JD-Core Version:    0.7.0.1
 */