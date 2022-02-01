package com.tencent.mm.plugin.record.model;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.fov;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.protocal.protobuf.lw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends p
  implements m
{
  private int AdA;
  private int AdE;
  String NAm;
  k NAn;
  private SparseArray<arf> NAo;
  private SparseBooleanArray NAp;
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public h(k paramk)
  {
    AppMethodBeat.i(9484);
    this.callback = null;
    this.NAm = "";
    this.NAn = null;
    this.NAo = new SparseArray();
    this.NAp = new SparseBooleanArray();
    this.AdE = 0;
    this.AdA = 0;
    c.a locala = new c.a();
    locala.otE = new lv();
    locala.otF = new lw();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.funcId = 632;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.NAn = paramk;
    AppMethodBeat.o(9484);
  }
  
  private void gGi()
  {
    AppMethodBeat.i(9485);
    this.NAm = k.b.a(q.a(this.NAn.field_title, this.NAn.field_desc, this.NAn.field_dataProto), null, null);
    AppMethodBeat.o(9485);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(9487);
    this.callback = paramh;
    paramh = (lv)c.b.b(this.rr.otB);
    this.NAo.clear();
    this.NAp.clear();
    if (this.NAn.field_dataProto.vEn.size() == 0)
    {
      Log.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.AdE = -100;
      AppMethodBeat.o(9487);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.AdA;
    arf localarf;
    if (i < this.NAn.field_dataProto.vEn.size())
    {
      localarf = (arf)this.NAn.field_dataProto.vEn.get(i);
      if ((!localarf.ZyX) || (!Util.isNullOrNil(localarf.Ysw))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.AdA = (i + 1);
      paramh.vgN = localLinkedList.size();
      paramh.vgO.clear();
      paramh.vgO.addAll(localLinkedList);
      Log.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.NAn.field_dataProto.vEn.size()), Integer.valueOf(this.NAo.size()), Integer.valueOf(this.AdA) });
      if ((paramh.vgN <= 0) || (j == 0))
      {
        gGi();
        Log.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.AdE = -100;
        AppMethodBeat.o(9487);
        return -100;
        fov localfov;
        if (!Util.isNullOrNil(localarf.Ysw))
        {
          localfov = new fov();
          localfov.YKw = localarf.Ysw;
          localfov.AesKey = localarf.ZyH;
          localfov.abPc = localarf.dataType;
          localfov.IcI = ((int)localarf.Zza);
          localfov.abPb = Util.nullAs(localarf.hIQ, "").hashCode();
          Log.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localfov.abPb), localarf.hIQ, Integer.valueOf(localfov.abPc), localarf.Ysw, Long.valueOf(localarf.Zza) });
          localLinkedList.add(localfov);
          this.NAo.put(localfov.abPb, localarf);
          this.NAp.put(localfov.abPb, false);
        }
        if (!Util.isNullOrNil(localarf.nRr))
        {
          localfov = new fov();
          localfov.YKw = localarf.nRr;
          localfov.AesKey = localarf.ZyC;
          localfov.abPc = 2;
          localfov.IcI = ((int)localarf.Zzk);
          localfov.abPb = (Util.nullAs(localarf.hIQ, "") + "@thumb").hashCode();
          Log.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localfov.abPb), localarf.hIQ, Integer.valueOf(localfov.abPc), localarf.nRr, Long.valueOf(localarf.Zzk) });
          localLinkedList.add(localfov);
          this.NAo.put(localfov.abPb, localarf);
          this.NAp.put(localfov.abPb, true);
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
    Log.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.AdE), Integer.valueOf(this.AdA), paramString });
    if ((paramInt2 == 3) && (this.AdE == -100))
    {
      gGi();
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
    params = ((lw)c.c.b(((c)params).otC)).vgO.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (fov)params.next();
      arf localarf = (arf)this.NAo.get(paramArrayOfByte.abPb);
      if (localarf != null) {
        if (this.NAp.get(paramArrayOfByte.abPb))
        {
          Log.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.abPb), localarf.hIQ, localarf.nRr, paramArrayOfByte.YKw, Long.valueOf(localarf.Zzk), Long.valueOf(paramArrayOfByte.IcI) });
          localarf.bsq(paramArrayOfByte.YKw);
          localarf.bsr(paramArrayOfByte.AesKey);
          if ((!Util.isNullOrNil(paramArrayOfByte.YKw)) && (!Util.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.IcI > 0L))
          {
            localarf.yp(paramArrayOfByte.IcI);
          }
          else
          {
            Log.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          Log.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.abPb), localarf.hIQ, localarf.Ysw, paramArrayOfByte.YKw, Long.valueOf(localarf.Zza), Long.valueOf(paramArrayOfByte.IcI) });
          localarf.bss(paramArrayOfByte.YKw);
          localarf.bst(paramArrayOfByte.AesKey);
          if ((!Util.isNullOrNil(paramArrayOfByte.YKw)) && (!Util.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.IcI > 0L))
          {
            localarf.yo(paramArrayOfByte.IcI);
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
    if (this.AdA < this.NAn.field_dataProto.vEn.size())
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
        gGi();
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.h
 * JD-Core Version:    0.7.0.1
 */