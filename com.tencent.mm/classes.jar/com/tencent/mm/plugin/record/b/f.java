package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.ak.n
  implements k
{
  private g callback;
  private int qJt;
  private int qJx;
  private final b rr;
  String wiX;
  j wiY;
  private SparseArray<agx> wiZ;
  private SparseBooleanArray wja;
  
  public f(j paramj)
  {
    AppMethodBeat.i(9484);
    this.callback = null;
    this.wiX = "";
    this.wiY = null;
    this.wiZ = new SparseArray();
    this.wja = new SparseBooleanArray();
    this.qJx = 0;
    this.qJt = 0;
    b.a locala = new b.a();
    locala.hvt = new kj();
    locala.hvu = new kk();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.funcId = 632;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.wiY = paramj;
    AppMethodBeat.o(9484);
  }
  
  private void dtN()
  {
    AppMethodBeat.i(9485);
    this.wiX = k.b.a(n.a(this.wiY.field_title, this.wiY.field_desc, this.wiY.field_dataProto), null, null);
    AppMethodBeat.o(9485);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(9487);
    this.callback = paramg;
    paramg = (kj)this.rr.hvr.hvw;
    this.wiZ.clear();
    this.wja.clear();
    if (this.wiY.field_dataProto.nxC.size() == 0)
    {
      ac.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.qJx = -100;
      AppMethodBeat.o(9487);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.qJt;
    agx localagx;
    if (i < this.wiY.field_dataProto.nxC.size())
    {
      localagx = (agx)this.wiY.field_dataProto.nxC.get(i);
      if ((!localagx.Ezx) || (!bs.isNullOrNil(localagx.Ezf))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.qJt = (i + 1);
      paramg.ncL = localLinkedList.size();
      paramg.ncM.clear();
      paramg.ncM.addAll(localLinkedList);
      ac.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.wiY.field_dataProto.nxC.size()), Integer.valueOf(this.wiZ.size()), Integer.valueOf(this.qJt) });
      if ((paramg.ncL <= 0) || (j == 0))
      {
        dtN();
        ac.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.qJx = -100;
        AppMethodBeat.o(9487);
        return -100;
        dja localdja;
        if (!bs.isNullOrNil(localagx.Ezf))
        {
          localdja = new dja();
          localdja.DUJ = localagx.Ezf;
          localdja.AesKey = localagx.Ezh;
          localdja.FSq = localagx.dataType;
          localdja.sVP = ((int)localagx.EzA);
          localdja.FSp = bs.bG(localagx.dhw, "").hashCode();
          ac.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localdja.FSp), localagx.dhw, Integer.valueOf(localdja.FSq), localagx.Ezf, Long.valueOf(localagx.EzA) });
          localLinkedList.add(localdja);
          this.wiZ.put(localdja.FSp, localagx);
          this.wja.put(localdja.FSp, false);
        }
        if (!bs.isNullOrNil(localagx.hhV))
        {
          localdja = new dja();
          localdja.DUJ = localagx.hhV;
          localdja.AesKey = localagx.Ezb;
          localdja.FSq = 2;
          localdja.sVP = ((int)localagx.EzL);
          localdja.FSp = (bs.bG(localagx.dhw, "") + "@thumb").hashCode();
          ac.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localdja.FSp), localagx.dhw, Integer.valueOf(localdja.FSq), localagx.hhV, Long.valueOf(localagx.EzL) });
          localLinkedList.add(localdja);
          this.wiZ.put(localdja.FSp, localagx);
          this.wja.put(localdja.FSp, true);
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
    ac.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.qJx), Integer.valueOf(this.qJt), paramString });
    if ((paramInt2 == 3) && (this.qJx == -100))
    {
      dtN();
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
    paramq = ((kk)((b)paramq).hvs.hvw).ncM.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (dja)paramq.next();
      agx localagx = (agx)this.wiZ.get(paramArrayOfByte.FSp);
      if (localagx != null) {
        if (this.wja.get(paramArrayOfByte.FSp))
        {
          ac.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.FSp), localagx.dhw, localagx.hhV, paramArrayOfByte.DUJ, Long.valueOf(localagx.EzL), Long.valueOf(paramArrayOfByte.sVP) });
          localagx.aIE(paramArrayOfByte.DUJ);
          localagx.aIF(paramArrayOfByte.AesKey);
          if ((!bs.isNullOrNil(paramArrayOfByte.DUJ)) && (!bs.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.sVP > 0L))
          {
            localagx.zT(paramArrayOfByte.sVP);
          }
          else
          {
            ac.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          ac.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.FSp), localagx.dhw, localagx.Ezf, paramArrayOfByte.DUJ, Long.valueOf(localagx.EzA), Long.valueOf(paramArrayOfByte.sVP) });
          localagx.aIG(paramArrayOfByte.DUJ);
          localagx.aIH(paramArrayOfByte.AesKey);
          if ((!bs.isNullOrNil(paramArrayOfByte.DUJ)) && (!bs.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.sVP > 0L))
          {
            localagx.zS(paramArrayOfByte.sVP);
          }
          else
          {
            ac.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
      }
    }
    boolean bool;
    if (this.qJt < this.wiY.field_dataProto.nxC.size())
    {
      bool = true;
      ac.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
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
        ac.i("MicroMsg.NetSceneTransCDN", "do callback");
        dtN();
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
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.f
 * JD-Core Version:    0.7.0.1
 */