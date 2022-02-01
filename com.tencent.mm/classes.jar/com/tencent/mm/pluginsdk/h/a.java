package com.tencent.mm.pluginsdk.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.aq.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.protocal.protobuf.jj;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  extends q
  implements m
{
  private final a QXZ;
  private i callback;
  private d rr;
  
  public a(List<b> paramList, a parama)
  {
    AppMethodBeat.i(219008);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ji();
    ((d.a)localObject).lBV = new jj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/batchcheckbigfileupload";
    ((d.a)localObject).funcId = 3939;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ji)d.b.b(this.rr.lBR);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      yb localyb = new yb();
      String str1 = localb.filePath;
      String str2 = localb.toUser;
      if ((!Util.isNullOrNil(localb.aesKey)) && (!Util.isNullOrNil(localb.smU)))
      {
        localyb.ScV = localb.aesKey;
        localyb.CqS = localb.smU;
        localyb.CqQ = localb.fileName;
        localyb.RNe = localb.jmx;
      }
      for (localyb.RNd = localb.fileSize;; localyb.RNd = ((int)u.bBQ(str1)))
      {
        localyb.RLs = com.tencent.mm.i.a.iTW;
        localyb.CRQ = str2;
        localyb.CRR = z.bcZ();
        Log.i("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig NetSceneBatchCheckBigFileUpload, aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { localyb.ScV, localyb.CqS, localyb.CqQ, Long.valueOf(localyb.RNd), localyb.RNe, localyb.CRQ, localyb.CRR, Util.getStack() });
        ((ji)localObject).rVy.add(localyb);
        break;
        f.bkh();
        localyb.ScV = com.tencent.mm.aq.a.bjV();
        f.bkh();
        localyb.CqS = com.tencent.mm.aq.a.Vs(str1);
        localyb.CqQ = u.bBW(str1);
        localyb.RNe = u.asq(str1);
      }
    }
    ((ji)localObject).rVx = ((ji)localObject).rVy.size();
    this.QXZ = parama;
    AppMethodBeat.o(219008);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(219010);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(219010);
    return i;
  }
  
  public final int getType()
  {
    return 3939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219031);
    Log.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.QXZ != null)
      {
        params = paramString;
        if (Util.isNullOrNil(paramString)) {
          params = MMApplicationContext.getContext().getString(c.h.check_big_file_error_svr);
        }
        paramString = this.QXZ;
        if (paramInt3 == 0) {
          break label145;
        }
      }
      for (;;)
      {
        paramString.bQ(paramInt3, params);
        AppMethodBeat.o(219031);
        return;
        label145:
        paramInt3 = -1001;
      }
    }
    paramArrayOfByte = (ji)d.b.b(((d)params).lBR);
    params = (jj)d.c.b(((d)params).lBS);
    paramInt1 = params.getBaseResponse().CqV;
    if (paramInt1 != 0)
    {
      paramString = params.getBaseResponse().Tef.toString();
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig outer resp.getBaseResponse().Ret: " + paramInt1 + ", errMsg:" + paramString);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      if (this.QXZ != null) {
        this.QXZ.bQ(paramInt1, paramString);
      }
      AppMethodBeat.o(219031);
      return;
    }
    if ((paramArrayOfByte.rVx != params.rVx) || (paramArrayOfByte.rVy.size() != params.rVy.size()) || (params.rVx != params.rVy.size()))
    {
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig  req.count: " + paramArrayOfByte.rVx + " not equals resp.Count:" + params.rVx + ", resp.List.size() = " + params.rVy.size());
      this.callback.onSceneEnd(paramInt2, -1000, "req-count mismatch resp-count", this);
      if (this.QXZ != null) {
        this.QXZ.bQ(-1000, MMApplicationContext.getContext().getString(c.h.check_big_file_error_invalid_resp));
      }
      AppMethodBeat.o(219031);
      return;
    }
    Object localObject = params.rVy.iterator();
    while (((Iterator)localObject).hasNext())
    {
      yc localyc = (yc)((Iterator)localObject).next();
      paramInt1 = localyc.getBaseResponse().CqV;
      String str = localyc.getBaseResponse().Tef.toString();
      if (paramInt1 != 0)
      {
        Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig inner resp.getBaseResponse().Ret: " + localyc + ", errMsg:" + str);
        paramString = XmlParser.parseXml(str, "e", null);
        if (paramString == null) {}
        for (paramString = MMApplicationContext.getContext().getString(c.h.check_big_file_error_parse_resp);; paramString = (String)paramString.get(".e.Content"))
        {
          this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
          if (this.QXZ != null) {
            this.QXZ.bQ(paramInt1, paramString);
          }
          AppMethodBeat.o(219031);
          return;
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.QXZ != null)
    {
      paramString = Collections.synchronizedList(new ArrayList());
      paramInt1 = 0;
      while (paramInt1 < params.rVx)
      {
        localObject = new c();
        ((c)localObject).smU = ((yb)paramArrayOfByte.rVy.get(paramInt1)).CqS;
        ((c)localObject).totalLen = ((yb)paramArrayOfByte.rVy.get(paramInt1)).RNd;
        ((c)localObject).aesKey = ((yb)paramArrayOfByte.rVy.get(paramInt1)).ScV;
        ((c)localObject).signature = ((yc)params.rVy.get(paramInt1)).mVB;
        ((c)localObject).QYa = ((yc)params.rVy.get(paramInt1)).Skj;
        ((c)localObject).QYb = ((yc)params.rVy.get(paramInt1)).Skk;
        Log.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { ((c)localObject).signature, Integer.valueOf(((yc)params.rVy.get(paramInt1)).Ski), ((c)localObject).QYa, ((c)localObject).QYb });
        paramString.add(localObject);
        paramInt1 += 1;
      }
      this.QXZ.bQ(0, "");
    }
    AppMethodBeat.o(219031);
  }
  
  public static abstract interface a
  {
    public abstract void bQ(int paramInt, String paramString);
  }
  
  public static final class b
  {
    public String aesKey;
    public String fileName;
    public String filePath;
    public long fileSize;
    public String jmx;
    public String smU;
    public String toUser;
  }
  
  public final class c
  {
    public String QYa;
    public String QYb;
    public String aesKey;
    public String signature;
    public String smU;
    public long totalLen;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a
 * JD-Core Version:    0.7.0.1
 */