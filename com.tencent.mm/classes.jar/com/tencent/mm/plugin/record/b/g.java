package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.etk;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  String HCK;
  k HCL;
  private SparseArray<anm> HCM;
  private SparseBooleanArray HCN;
  private i callback;
  private final d rr;
  private int wHr;
  private int wHv;
  
  public g(k paramk)
  {
    AppMethodBeat.i(9484);
    this.callback = null;
    this.HCK = "";
    this.HCL = null;
    this.HCM = new SparseArray();
    this.HCN = new SparseBooleanArray();
    this.wHv = 0;
    this.wHr = 0;
    d.a locala = new d.a();
    locala.lBU = new kz();
    locala.lBV = new la();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.funcId = 632;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.HCL = paramk;
    AppMethodBeat.o(9484);
  }
  
  private void fut()
  {
    AppMethodBeat.i(9485);
    this.HCK = k.b.a(p.a(this.HCL.field_title, this.HCL.field_desc, this.HCL.field_dataProto), null, null);
    AppMethodBeat.o(9485);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(9487);
    this.callback = parami;
    parami = (kz)d.b.b(this.rr.lBR);
    this.HCM.clear();
    this.HCN.clear();
    if (this.HCL.field_dataProto.syG.size() == 0)
    {
      Log.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.wHv = -100;
      AppMethodBeat.o(9487);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.wHr;
    anm localanm;
    if (i < this.HCL.field_dataProto.syG.size())
    {
      localanm = (anm)this.HCL.field_dataProto.syG.get(i);
      if ((!localanm.Syf) || (!Util.isNullOrNil(localanm.Rwb))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.wHr = (i + 1);
      parami.rVx = localLinkedList.size();
      parami.rVy.clear();
      parami.rVy.addAll(localLinkedList);
      Log.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.HCL.field_dataProto.syG.size()), Integer.valueOf(this.HCM.size()), Integer.valueOf(this.wHr) });
      if ((parami.rVx <= 0) || (j == 0))
      {
        fut();
        Log.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.wHv = -100;
        AppMethodBeat.o(9487);
        return -100;
        etk localetk;
        if (!Util.isNullOrNil(localanm.Rwb))
        {
          localetk = new etk();
          localetk.RNi = localanm.Rwb;
          localetk.AesKey = localanm.SxP;
          localetk.Uvx = localanm.dataType;
          localetk.Cqz = ((int)localanm.Syi);
          localetk.Uvw = Util.nullAs(localanm.fEa, "").hashCode();
          Log.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localetk.Uvw), localanm.fEa, Integer.valueOf(localetk.Uvx), localanm.Rwb, Long.valueOf(localanm.Syi) });
          localLinkedList.add(localetk);
          this.HCM.put(localetk.Uvw, localanm);
          this.HCN.put(localetk.Uvw, false);
        }
        if (!Util.isNullOrNil(localanm.lmm))
        {
          localetk = new etk();
          localetk.RNi = localanm.lmm;
          localetk.AesKey = localanm.SxK;
          localetk.Uvx = 2;
          localetk.Cqz = ((int)localanm.Sys);
          localetk.Uvw = (Util.nullAs(localanm.fEa, "") + "@thumb").hashCode();
          Log.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localetk.Uvw), localanm.fEa, Integer.valueOf(localetk.Uvx), localanm.lmm, Long.valueOf(localanm.Sys) });
          localLinkedList.add(localetk);
          this.HCM.put(localetk.Uvw, localanm);
          this.HCN.put(localetk.Uvw, true);
        }
        if (localLinkedList.size() >= 20) {
          continue;
        }
        i += 1;
        break;
      }
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(9487);
      return i;
    }
  }
  
  public final int getType()
  {
    return 632;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9486);
    Log.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.wHv), Integer.valueOf(this.wHr), paramString });
    if ((paramInt2 == 3) && (this.wHv == -100))
    {
      fut();
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
    params = ((la)d.c.b(((d)params).lBS)).rVy.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (etk)params.next();
      anm localanm = (anm)this.HCM.get(paramArrayOfByte.Uvw);
      if (localanm != null) {
        if (this.HCN.get(paramArrayOfByte.Uvw))
        {
          Log.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.Uvw), localanm.fEa, localanm.lmm, paramArrayOfByte.RNi, Long.valueOf(localanm.Sys), Long.valueOf(paramArrayOfByte.Cqz) });
          localanm.bsz(paramArrayOfByte.RNi);
          localanm.bsA(paramArrayOfByte.AesKey);
          if ((!Util.isNullOrNil(paramArrayOfByte.RNi)) && (!Util.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.Cqz > 0L))
          {
            localanm.TZ(paramArrayOfByte.Cqz);
          }
          else
          {
            Log.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          Log.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.Uvw), localanm.fEa, localanm.Rwb, paramArrayOfByte.RNi, Long.valueOf(localanm.Syi), Long.valueOf(paramArrayOfByte.Cqz) });
          localanm.bsB(paramArrayOfByte.RNi);
          localanm.bsC(paramArrayOfByte.AesKey);
          if ((!Util.isNullOrNil(paramArrayOfByte.RNi)) && (!Util.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.Cqz > 0L))
          {
            localanm.TY(paramArrayOfByte.Cqz);
          }
          else
          {
            Log.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
      }
    }
    boolean bool;
    if (this.wHr < this.HCL.field_dataProto.syG.size())
    {
      bool = true;
      Log.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
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
        Log.i("MicroMsg.NetSceneTransCDN", "do callback");
        fut();
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.g
 * JD-Core Version:    0.7.0.1
 */