package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private int muf;
  private int muj;
  String pYq;
  j pYr;
  private SparseArray<aca> pYs;
  private SparseBooleanArray pYt;
  private final b rr;
  
  public f(j paramj)
  {
    AppMethodBeat.i(135662);
    this.callback = null;
    this.pYq = "";
    this.pYr = null;
    this.pYs = new SparseArray();
    this.pYt = new SparseBooleanArray();
    this.muj = 0;
    this.muf = 0;
    b.a locala = new b.a();
    locala.fsX = new ja();
    locala.fsY = new jb();
    locala.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
    locala.funcId = 632;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.pYr = paramj;
    AppMethodBeat.o(135662);
  }
  
  private void cfQ()
  {
    AppMethodBeat.i(135663);
    this.pYq = j.b.a(n.a(this.pYr.field_title, this.pYr.field_desc, this.pYr.field_dataProto), null, null);
    AppMethodBeat.o(135663);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(135665);
    this.callback = paramf;
    paramf = (ja)this.rr.fsV.fta;
    this.pYs.clear();
    this.pYt.clear();
    if (this.pYr.field_dataProto.wVc.size() == 0)
    {
      ab.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
      this.muj = -100;
      AppMethodBeat.o(135665);
      return -100;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = this.muf;
    aca localaca;
    if (i < this.pYr.field_dataProto.wVc.size())
    {
      localaca = (aca)this.pYr.field_dataProto.wVc.get(i);
      if ((!localaca.wSU) || (!bo.isNullOrNil(localaca.wSC))) {}
    }
    for (int j = 0;; j = 1)
    {
      this.muf = (i + 1);
      paramf.jJu = localLinkedList.size();
      paramf.jJv.clear();
      paramf.jJv.addAll(localLinkedList);
      ab.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", new Object[] { Integer.valueOf(this.pYr.field_dataProto.wVc.size()), Integer.valueOf(this.pYs.size()), Integer.valueOf(this.muf) });
      if ((paramf.jJu <= 0) || (j == 0))
      {
        cfQ();
        ab.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
        this.muj = -100;
        AppMethodBeat.o(135665);
        return -100;
        clh localclh;
        if (!bo.isNullOrNil(localaca.wSC))
        {
          localclh = new clh();
          localclh.wDs = localaca.wSC;
          localclh.AesKey = localaca.wSE;
          localclh.xVy = localaca.dataType;
          localclh.niJ = ((int)localaca.wSX);
          localclh.xVx = bo.bf(localaca.mBq, "").hashCode();
          ab.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", new Object[] { Integer.valueOf(localclh.xVx), localaca.mBq, Integer.valueOf(localclh.xVy), localaca.wSC, Long.valueOf(localaca.wSX) });
          localLinkedList.add(localclh);
          this.pYs.put(localclh.xVx, localaca);
          this.pYt.put(localclh.xVx, false);
        }
        if (!bo.isNullOrNil(localaca.fgM))
        {
          localclh = new clh();
          localclh.wDs = localaca.fgM;
          localclh.AesKey = localaca.wSy;
          localclh.xVy = 2;
          localclh.niJ = ((int)localaca.wTi);
          localclh.xVx = (bo.bf(localaca.mBq, "") + "@thumb").hashCode();
          ab.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", new Object[] { Integer.valueOf(localclh.xVx), localaca.mBq, Integer.valueOf(localclh.xVy), localaca.fgM, Long.valueOf(localaca.wTi) });
          localLinkedList.add(localclh);
          this.pYs.put(localclh.xVx, localaca);
          this.pYt.put(localclh.xVx, true);
        }
        if (localLinkedList.size() >= 20) {
          continue;
        }
        i += 1;
        break;
      }
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(135665);
      return i;
    }
  }
  
  public final int getType()
  {
    return 632;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135664);
    ab.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.muj), Integer.valueOf(this.muf), paramString });
    if ((paramInt2 == 3) && (this.muj == -100))
    {
      cfQ();
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(135664);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(135664);
      return;
    }
    paramq = ((jb)((b)paramq).fsW.fta).jJv.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (clh)paramq.next();
      aca localaca = (aca)this.pYs.get(paramArrayOfByte.xVx);
      if (localaca != null) {
        if (this.pYt.get(paramArrayOfByte.xVx))
        {
          ab.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.xVx), localaca.mBq, localaca.fgM, paramArrayOfByte.wDs, Long.valueOf(localaca.wTi), Long.valueOf(paramArrayOfByte.niJ) });
          localaca.ans(paramArrayOfByte.wDs);
          localaca.ant(paramArrayOfByte.AesKey);
          if ((!bo.isNullOrNil(paramArrayOfByte.wDs)) && (!bo.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.niJ > 0L))
          {
            localaca.nD(paramArrayOfByte.niJ);
          }
          else
          {
            ab.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
        else
        {
          ab.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[] { Integer.valueOf(paramArrayOfByte.xVx), localaca.mBq, localaca.wSC, paramArrayOfByte.wDs, Long.valueOf(localaca.wSX), Long.valueOf(paramArrayOfByte.niJ) });
          localaca.anu(paramArrayOfByte.wDs);
          localaca.anv(paramArrayOfByte.AesKey);
          if ((!bo.isNullOrNil(paramArrayOfByte.wDs)) && (!bo.isNullOrNil(paramArrayOfByte.AesKey)) && (paramArrayOfByte.niJ > 0L))
          {
            localaca.nC(paramArrayOfByte.niJ);
          }
          else
          {
            ab.w("MicroMsg.NetSceneTransCDN", "match error server return");
            paramInt2 = 3;
          }
        }
      }
    }
    boolean bool;
    if (this.muf < this.pYr.field_dataProto.wVc.size())
    {
      bool = true;
      ab.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
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
        ab.i("MicroMsg.NetSceneTransCDN", "do callback");
        cfQ();
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(135664);
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
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.f
 * JD-Core Version:    0.7.0.1
 */