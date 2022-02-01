package com.tencent.mm.pluginsdk.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  extends p
  implements m
{
  private final a XTX;
  private h callback;
  private c rr;
  
  public a(List<b> paramList, a parama)
  {
    AppMethodBeat.i(244547);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ke();
    ((c.a)localObject).otF = new kf();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/batchcheckbigfileupload";
    ((c.a)localObject).funcId = 3939;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ke)c.b.b(this.rr.otB);
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      zy localzy = new zy();
      String str1 = localb.filePath;
      String str2 = localb.toUser;
      if ((!Util.isNullOrNil(localb.aesKey)) && (!Util.isNullOrNil(localb.vyS)))
      {
        localzy.ZaN = localb.aesKey;
        localzy.Ida = localb.vyS;
        localzy.IcZ = localb.fileName;
        localzy.YKs = localb.lPJ;
      }
      for (localzy.YKr = localb.fileSize;; localzy.YKr = ((int)y.bEl(str1)))
      {
        localzy.YIE = com.tencent.mm.g.a.lwb;
        localzy.IMg = str2;
        localzy.IMh = z.bAM();
        Log.i("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig NetSceneBatchCheckBigFileUpload, aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { localzy.ZaN, localzy.Ida, localzy.IcZ, Long.valueOf(localzy.YKr), localzy.YKs, localzy.IMg, localzy.IMh, Util.getStack() });
        ((ke)localObject).vgO.add(localzy);
        break;
        k.bHX();
        localzy.ZaN = d.bHI();
        k.bHX();
        localzy.Ida = d.Ns(str1);
        localzy.IcZ = y.bEq(str1);
        localzy.YKs = y.alV(str1);
      }
    }
    ((ke)localObject).vgN = ((ke)localObject).vgO.size();
    this.XTX = parama;
    AppMethodBeat.o(244547);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(244557);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(244557);
    return i;
  }
  
  public final int getType()
  {
    return 3939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(244573);
    Log.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.XTX != null)
      {
        params = paramString;
        if (Util.isNullOrNil(paramString)) {
          params = MMApplicationContext.getContext().getString(c.h.check_big_file_error_svr);
        }
        paramString = this.XTX;
        if (paramInt3 == 0) {
          break label145;
        }
      }
      for (;;)
      {
        paramString.cy(paramInt3, params);
        AppMethodBeat.o(244573);
        return;
        label145:
        paramInt3 = -1001;
      }
    }
    paramArrayOfByte = (ke)c.b.b(((c)params).otB);
    params = (kf)c.c.b(((c)params).otC);
    paramInt1 = params.getBaseResponse().Idd;
    if (paramInt1 != 0)
    {
      paramString = params.getBaseResponse().akjO.toString();
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig outer resp.getBaseResponse().Ret: " + paramInt1 + ", errMsg:" + paramString);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      if (this.XTX != null) {
        this.XTX.cy(paramInt1, paramString);
      }
      AppMethodBeat.o(244573);
      return;
    }
    if ((paramArrayOfByte.vgN != params.vgN) || (paramArrayOfByte.vgO.size() != params.vgO.size()) || (params.vgN != params.vgO.size()))
    {
      Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig  req.count: " + paramArrayOfByte.vgN + " not equals resp.Count:" + params.vgN + ", resp.List.size() = " + params.vgO.size());
      this.callback.onSceneEnd(paramInt2, -1000, "req-count mismatch resp-count", this);
      if (this.XTX != null) {
        this.XTX.cy(-1000, MMApplicationContext.getContext().getString(c.h.check_big_file_error_invalid_resp));
      }
      AppMethodBeat.o(244573);
      return;
    }
    Object localObject = params.vgO.iterator();
    while (((Iterator)localObject).hasNext())
    {
      zz localzz = (zz)((Iterator)localObject).next();
      paramInt1 = localzz.getBaseResponse().Idd;
      String str = localzz.getBaseResponse().akjO.toString();
      if (paramInt1 != 0)
      {
        Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig inner resp.getBaseResponse().Ret: " + localzz + ", errMsg:" + str);
        paramString = XmlParser.parseXml(str, "e", null);
        if (paramString == null) {}
        for (paramString = MMApplicationContext.getContext().getString(c.h.check_big_file_error_parse_resp);; paramString = (String)paramString.get(".e.Content"))
        {
          this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
          if (this.XTX != null) {
            this.XTX.cy(paramInt1, paramString);
          }
          AppMethodBeat.o(244573);
          return;
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.XTX != null)
    {
      paramString = Collections.synchronizedList(new ArrayList());
      paramInt1 = 0;
      while (paramInt1 < params.vgN)
      {
        localObject = new c();
        ((c)localObject).vyS = ((zy)paramArrayOfByte.vgO.get(paramInt1)).Ida;
        ((c)localObject).totalLen = ((zy)paramArrayOfByte.vgO.get(paramInt1)).YKr;
        ((c)localObject).aesKey = ((zy)paramArrayOfByte.vgO.get(paramInt1)).ZaN;
        ((c)localObject).signature = ((zz)params.vgO.get(paramInt1)).pSi;
        ((c)localObject).XTY = ((zz)params.vgO.get(paramInt1)).Zit;
        ((c)localObject).XTZ = ((zz)params.vgO.get(paramInt1)).Ziu;
        Log.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { ((c)localObject).signature, Integer.valueOf(((zz)params.vgO.get(paramInt1)).Zis), ((c)localObject).XTY, ((c)localObject).XTZ });
        paramString.add(localObject);
        paramInt1 += 1;
      }
      this.XTX.cy(0, "");
    }
    AppMethodBeat.o(244573);
  }
  
  public static abstract interface a
  {
    public abstract void cy(int paramInt, String paramString);
  }
  
  public static final class b
  {
    public String aesKey;
    public String fileName;
    public String filePath;
    public long fileSize;
    public String lPJ;
    public String toUser;
    public String vyS;
  }
  
  public final class c
  {
    public String XTY;
    public String XTZ;
    public String aesKey;
    public String signature;
    public long totalLen;
    public String vyS;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a
 * JD-Core Version:    0.7.0.1
 */