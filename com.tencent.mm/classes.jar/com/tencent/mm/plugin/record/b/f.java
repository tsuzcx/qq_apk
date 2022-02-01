package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.al.n
  implements k
{
  private g callback;
  private int qaN;
  private int qaR;
  private final b rr;
  String vaj;
  j vak;
  private SparseArray<afy> val;
  private SparseBooleanArray vam;
  
  public f(j paramj)
  {
    AppMethodBeat.i(9484);
    this.callback = null;
    this.vaj = "";
    this.vak = null;
    this.val = new SparseArray();
    this.vam = new SparseBooleanArray();
    this.qaR = 0;
    this.qaN = 0;
    b.a locala = new b.a();
    locala.gUU = new kd();
    locala.gUV = new ke();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.funcId = 632;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.vak = paramj;
    AppMethodBeat.o(9484);
  }
  
  private void dgg()
  {
    AppMethodBeat.i(9485);
    this.vaj = k.b.a(n.a(this.vak.field_title, this.vak.field_desc, this.vak.field_dataProto), null, null);
    AppMethodBeat.o(9485);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(9487);
    this.callback = paramg;
    paramg = (kd)this.rr.gUS.gUX;
    this.val.clear();
    this.vam.clear();
    if (this.vak.field_dataProto.mVb.size() == 0)
    {
      ad.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.qaR = -100;
      AppMethodBeat.o(9487);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.qaN;
    afy localafy;
    if (i < this.vak.field_dataProto.mVb.size())
    {
      localafy = (afy)this.vak.field_dataProto.mVb.get(i);
      if ((!localafy.Dgr) || (!bt.isNullOrNil(localafy.DfZ))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.qaN = (i + 1);
      paramg.mAK = localLinkedList.size();
      paramg.mAL.clear();
      paramg.mAL.addAll(localLinkedList);
      ad.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.vak.field_dataProto.mVb.size()), Integer.valueOf(this.val.size()), Integer.valueOf(this.qaN) });
      if ((paramg.mAK <= 0) || (j == 0))
      {
        dgg();
        ad.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.qaR = -100;
        AppMethodBeat.o(9487);
        return -100;
        ddl localddl;
        if (!bt.isNullOrNil(localafy.DfZ))
        {
          localddl = new ddl();
          localddl.CCm = localafy.DfZ;
          localddl.AesKey = localafy.Dgb;
          localddl.Evn = localafy.dataType;
          localddl.rNY = ((int)localafy.Dgu);
          localddl.Evm = bt.by(localafy.dkb, "").hashCode();
          ad.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localddl.Evm), localafy.dkb, Integer.valueOf(localddl.Evn), localafy.DfZ, Long.valueOf(localafy.Dgu) });
          localLinkedList.add(localddl);
          this.val.put(localddl.Evm, localafy);
          this.vam.put(localddl.Evm, false);
        }
        if (!bt.isNullOrNil(localafy.gHu))
        {
          localddl = new ddl();
          localddl.CCm = localafy.gHu;
          localddl.AesKey = localafy.DfV;
          localddl.Evn = 2;
          localddl.rNY = ((int)localafy.DgF);
          localddl.Evm = (bt.by(localafy.dkb, "") + "@thumb").hashCode();
          ad.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localddl.Evm), localafy.dkb, Integer.valueOf(localddl.Evn), localafy.gHu, Long.valueOf(localafy.DgF) });
          localLinkedList.add(localddl);
          this.val.put(localddl.Evm, localafy);
          this.vam.put(localddl.Evm, true);
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
    ad.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.qaR), Integer.valueOf(this.qaN), paramString });
    if ((paramInt2 == 3) && (this.qaR == -100))
    {
      dgg();
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
    paramq = ((ke)((b)paramq).gUT.gUX).mAL.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (ddl)paramq.next();
      afy localafy = (afy)this.val.get(paramArrayOfByte.Evm);
      if (localafy != null) {
        if (this.vam.get(paramArrayOfByte.Evm))
        {
          ad.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.Evm), localafy.dkb, localafy.gHu, paramArrayOfByte.CCm, Long.valueOf(localafy.DgF), Long.valueOf(paramArrayOfByte.rNY) });
          localafy.aDn(paramArrayOfByte.CCm);
          localafy.aDo(paramArrayOfByte.AesKey);
          if ((!bt.isNullOrNil(paramArrayOfByte.CCm)) && (!bt.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.rNY > 0L))
          {
            localafy.vq(paramArrayOfByte.rNY);
          }
          else
          {
            ad.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          ad.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.Evm), localafy.dkb, localafy.DfZ, paramArrayOfByte.CCm, Long.valueOf(localafy.Dgu), Long.valueOf(paramArrayOfByte.rNY) });
          localafy.aDp(paramArrayOfByte.CCm);
          localafy.aDq(paramArrayOfByte.AesKey);
          if ((!bt.isNullOrNil(paramArrayOfByte.CCm)) && (!bt.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.rNY > 0L))
          {
            localafy.vp(paramArrayOfByte.rNY);
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
    if (this.qaN < this.vak.field_dataProto.mVb.size())
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
        dgg();
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.f
 * JD-Core Version:    0.7.0.1
 */