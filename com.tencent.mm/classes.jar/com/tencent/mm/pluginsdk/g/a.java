package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
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
  private final a JXx;
  private i callback;
  private d rr;
  
  public a(List<b> paramList, a parama)
  {
    AppMethodBeat.i(223767);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new js();
    ((d.a)localObject).iLO = new jt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/batchcheckbigfileupload";
    ((d.a)localObject).funcId = 3939;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (js)this.rr.iLK.iLR;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      xv localxv = new xv();
      String str1 = localb.filePath;
      String str2 = localb.toUser;
      if ((!Util.isNullOrNil(localb.aesKey)) && (!Util.isNullOrNil(localb.pkL)))
      {
        localxv.LbJ = localb.aesKey;
        localxv.xuB = localb.pkL;
        localxv.xuz = localb.fileName;
        localxv.KMh = localb.gCr;
      }
      for (localxv.KMg = localb.fileSize;; localxv.KMg = ((int)com.tencent.mm.vfs.s.boW(str1)))
      {
        localxv.KKA = com.tencent.mm.i.a.gpO;
        localxv.xNG = str2;
        localxv.xNH = z.aTY();
        Log.i("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig NetSceneBatchCheckBigFileUpload, aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { localxv.LbJ, localxv.xuB, localxv.xuz, Long.valueOf(localxv.KMg), localxv.KMh, localxv.xNG, localxv.xNH, Util.getStack() });
        ((js)localObject).oTA.add(localxv);
        break;
        f.baR();
        localxv.LbJ = com.tencent.mm.an.a.baG();
        f.baR();
        localxv.xuB = com.tencent.mm.an.a.NV(str1);
        localxv.xuz = com.tencent.mm.vfs.s.bpb(str1);
        localxv.KMh = com.tencent.mm.vfs.s.akC(str1);
      }
    }
    ((js)localObject).oTz = ((js)localObject).oTA.size();
    this.JXx = parama;
    AppMethodBeat.o(223767);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(223768);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(223768);
    return i;
  }
  
  public final int getType()
  {
    return 3939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223769);
    Log.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.JXx != null)
      {
        params = paramString;
        if (Util.isNullOrNil(paramString)) {
          params = MMApplicationContext.getContext().getString(2131757553);
        }
        paramString = this.JXx;
        if (paramInt3 == 0) {
          break label145;
        }
      }
      for (;;)
      {
        paramString.bS(paramInt3, params);
        AppMethodBeat.o(223769);
        return;
        label145:
        paramInt3 = -1001;
      }
    }
    paramArrayOfByte = (js)((d)params).iLK.iLR;
    params = (jt)((d)params).iLL.iLR;
    paramInt1 = params.getBaseResponse().Ret;
    if (paramInt1 != 0)
    {
      paramString = params.getBaseResponse().ErrMsg.toString();
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig outer resp.getBaseResponse().Ret: " + paramInt1 + ", errMsg:" + paramString);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      if (this.JXx != null) {
        this.JXx.bS(paramInt1, paramString);
      }
      AppMethodBeat.o(223769);
      return;
    }
    if ((paramArrayOfByte.oTz != params.oTz) || (paramArrayOfByte.oTA.size() != params.oTA.size()) || (params.oTz != params.oTA.size()))
    {
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig  req.count: " + paramArrayOfByte.oTz + " not equals resp.Count:" + params.oTz + ", resp.List.size() = " + params.oTA.size());
      this.callback.onSceneEnd(paramInt2, -1000, "req-count mismatch resp-count", this);
      if (this.JXx != null) {
        this.JXx.bS(-1000, MMApplicationContext.getContext().getString(2131757551));
      }
      AppMethodBeat.o(223769);
      return;
    }
    Object localObject = params.oTA.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xw localxw = (xw)((Iterator)localObject).next();
      paramInt1 = localxw.getBaseResponse().Ret;
      String str = localxw.getBaseResponse().ErrMsg.toString();
      if (paramInt1 != 0)
      {
        Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig inner resp.getBaseResponse().Ret: " + localxw + ", errMsg:" + str);
        paramString = XmlParser.parseXml(str, "e", null);
        if (paramString == null) {}
        for (paramString = MMApplicationContext.getContext().getString(2131757552);; paramString = (String)paramString.get(".e.Content"))
        {
          this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
          if (this.JXx != null) {
            this.JXx.bS(paramInt1, paramString);
          }
          AppMethodBeat.o(223769);
          return;
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.JXx != null)
    {
      paramString = Collections.synchronizedList(new ArrayList());
      paramInt1 = 0;
      while (paramInt1 < params.oTz)
      {
        localObject = new c();
        ((c)localObject).pkL = ((xv)paramArrayOfByte.oTA.get(paramInt1)).xuB;
        ((c)localObject).totalLen = ((xv)paramArrayOfByte.oTA.get(paramInt1)).KMg;
        ((c)localObject).aesKey = ((xv)paramArrayOfByte.oTA.get(paramInt1)).LbJ;
        ((c)localObject).signature = ((xw)params.oTA.get(paramInt1)).keb;
        ((c)localObject).JXy = ((xw)params.oTA.get(paramInt1)).LiS;
        ((c)localObject).JXz = ((xw)params.oTA.get(paramInt1)).LiT;
        Log.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { ((c)localObject).signature, Integer.valueOf(((xw)params.oTA.get(paramInt1)).LiR), ((c)localObject).JXy, ((c)localObject).JXz });
        paramString.add(localObject);
        paramInt1 += 1;
      }
      this.JXx.bS(0, "");
    }
    AppMethodBeat.o(223769);
  }
  
  public static abstract interface a
  {
    public abstract void bS(int paramInt, String paramString);
  }
  
  public static final class b
  {
    public String aesKey;
    public String fileName;
    public String filePath;
    public long fileSize;
    public String gCr;
    public String pkL;
    public String toUser;
  }
  
  public final class c
  {
    public String JXy;
    public String JXz;
    public String aesKey;
    public String pkL;
    public String signature;
    public long totalLen;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a
 * JD-Core Version:    0.7.0.1
 */