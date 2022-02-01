package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  String BGE;
  k BGF;
  private SparseArray<aml> BGG;
  private SparseBooleanArray BGH;
  private i callback;
  private final d rr;
  private int tbm;
  private int tbq;
  
  public g(k paramk)
  {
    AppMethodBeat.i(9484);
    this.callback = null;
    this.BGE = "";
    this.BGF = null;
    this.BGG = new SparseArray();
    this.BGH = new SparseBooleanArray();
    this.tbq = 0;
    this.tbm = 0;
    d.a locala = new d.a();
    locala.iLN = new lj();
    locala.iLO = new lk();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.funcId = 632;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.BGF = paramk;
    AppMethodBeat.o(9484);
  }
  
  private void eIo()
  {
    AppMethodBeat.i(9485);
    this.BGE = k.b.a(p.a(this.BGF.field_title, this.BGF.field_desc, this.BGF.field_dataProto), null, null);
    AppMethodBeat.o(9485);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(9487);
    this.callback = parami;
    parami = (lj)this.rr.iLK.iLR;
    this.BGG.clear();
    this.BGH.clear();
    if (this.BGF.field_dataProto.ppH.size() == 0)
    {
      Log.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.tbq = -100;
      AppMethodBeat.o(9487);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.tbm;
    aml localaml;
    if (i < this.BGF.field_dataProto.ppH.size())
    {
      localaml = (aml)this.BGF.field_dataProto.ppH.get(i);
      if ((!localaml.LvF) || (!Util.isNullOrNil(localaml.KuR))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.tbm = (i + 1);
      parami.oTz = localLinkedList.size();
      parami.oTA.clear();
      parami.oTA.addAll(localLinkedList);
      Log.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.BGF.field_dataProto.ppH.size()), Integer.valueOf(this.BGG.size()), Integer.valueOf(this.tbm) });
      if ((parami.oTz <= 0) || (j == 0))
      {
        eIo();
        Log.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.tbq = -100;
        AppMethodBeat.o(9487);
        return -100;
        eji localeji;
        if (!Util.isNullOrNil(localaml.KuR))
        {
          localeji = new eji();
          localeji.KMl = localaml.KuR;
          localeji.AesKey = localaml.Lvp;
          localeji.NiS = localaml.dataType;
          localeji.xui = ((int)localaml.LvI);
          localeji.NiR = Util.nullAs(localaml.dLl, "").hashCode();
          Log.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localeji.NiR), localaml.dLl, Integer.valueOf(localeji.NiS), localaml.KuR, Long.valueOf(localaml.LvI) });
          localLinkedList.add(localeji);
          this.BGG.put(localeji.NiR, localaml);
          this.BGH.put(localeji.NiR, false);
        }
        if (!Util.isNullOrNil(localaml.iwX))
        {
          localeji = new eji();
          localeji.KMl = localaml.iwX;
          localeji.AesKey = localaml.Lvk;
          localeji.NiS = 2;
          localeji.xui = ((int)localaml.LvT);
          localeji.NiR = (Util.nullAs(localaml.dLl, "") + "@thumb").hashCode();
          Log.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localeji.NiR), localaml.dLl, Integer.valueOf(localeji.NiS), localaml.iwX, Long.valueOf(localaml.LvT) });
          localLinkedList.add(localeji);
          this.BGG.put(localeji.NiR, localaml);
          this.BGH.put(localeji.NiR, true);
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
    Log.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.tbq), Integer.valueOf(this.tbm), paramString });
    if ((paramInt2 == 3) && (this.tbq == -100))
    {
      eIo();
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
    params = ((lk)((d)params).iLL.iLR).oTA.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (eji)params.next();
      aml localaml = (aml)this.BGG.get(paramArrayOfByte.NiR);
      if (localaml != null) {
        if (this.BGH.get(paramArrayOfByte.NiR))
        {
          Log.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.NiR), localaml.dLl, localaml.iwX, paramArrayOfByte.KMl, Long.valueOf(localaml.LvT), Long.valueOf(paramArrayOfByte.xui) });
          localaml.bgh(paramArrayOfByte.KMl);
          localaml.bgi(paramArrayOfByte.AesKey);
          if ((!Util.isNullOrNil(paramArrayOfByte.KMl)) && (!Util.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.xui > 0L))
          {
            localaml.Mv(paramArrayOfByte.xui);
          }
          else
          {
            Log.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          Log.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.NiR), localaml.dLl, localaml.KuR, paramArrayOfByte.KMl, Long.valueOf(localaml.LvI), Long.valueOf(paramArrayOfByte.xui) });
          localaml.bgj(paramArrayOfByte.KMl);
          localaml.bgk(paramArrayOfByte.AesKey);
          if ((!Util.isNullOrNil(paramArrayOfByte.KMl)) && (!Util.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.xui > 0L))
          {
            localaml.Mu(paramArrayOfByte.xui);
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
    if (this.tbm < this.BGF.field_dataProto.ppH.size())
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
        eIo();
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
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.g
 * JD-Core Version:    0.7.0.1
 */