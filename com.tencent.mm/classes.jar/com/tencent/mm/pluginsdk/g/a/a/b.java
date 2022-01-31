package com.tencent.mm.pluginsdk.g.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
{
  private final Set<b.b> vMV;
  private final k vMW;
  private final d vMX;
  
  private b()
  {
    AppMethodBeat.i(79490);
    this.vMV = Collections.newSetFromMap(new android.support.v4.e.a(i.vNx.length));
    this.vMW = new k();
    this.vMX = new b.3(this);
    Object localObject1 = q.a.dmz();
    d locald = this.vMX;
    ab.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { "CheckResUpdate", locald });
    if (((q)localObject1).hsO)
    {
      com.tencent.mm.pluginsdk.g.a.c.i locali = ((q)localObject1).vOG;
      ab.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(locald)));
      if (locald != null)
      {
        int i = "CheckResUpdate".hashCode();
        synchronized (locali.vOl)
        {
          List localList = (List)locali.vOk.get(i);
          localObject1 = localList;
          if (localList == null) {
            localObject1 = new LinkedList();
          }
          ((List)localObject1).add(locald);
          locali.vOk.put(i, localObject1);
          AppMethodBeat.o(79490);
          return;
        }
      }
    }
    AppMethodBeat.o(79490);
  }
  
  public static void LE(int paramInt)
  {
    AppMethodBeat.i(79491);
    ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.RJ();
    boolean bool1 = com.tencent.mm.kernel.a.QT();
    boolean bool2 = av.flM.Y("login_user_name", "").equals("");
    if ((!bool1) && (bool2))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
      AppMethodBeat.o(79491);
      return;
    }
    m localm = new m(paramInt);
    com.tencent.mm.kernel.g.RK().eHt.a(localm, 0);
    AppMethodBeat.o(79491);
  }
  
  static void c(s params)
  {
    AppMethodBeat.i(79494);
    ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { params.field_urlKey });
    k.g(params);
    AppMethodBeat.o(79494);
  }
  
  public static b dmb()
  {
    AppMethodBeat.i(156859);
    b localb = b.c.dmg();
    AppMethodBeat.o(156859);
    return localb;
  }
  
  public static String dmc()
  {
    AppMethodBeat.i(154794);
    Object localObject = q.a.dmz().alQ(i.hd(60, 2));
    if (localObject == null)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getOriginalMd5, %d.%d, get null info, return", new Object[] { Integer.valueOf(60), Integer.valueOf(2) });
      AppMethodBeat.o(154794);
      return null;
    }
    localObject = ((s)localObject).field_originalMd5;
    AppMethodBeat.o(154794);
    return localObject;
  }
  
  public static String hc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79492);
    s locals = q.a.dmz().alQ(i.hd(paramInt1, paramInt2));
    if (locals == null)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(79492);
      return null;
    }
    ab.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[] { Boolean.valueOf(locals.field_deleted), locals.field_filePath, locals.field_md5, Boolean.valueOf(locals.field_fileCompress), Boolean.valueOf(locals.field_fileEncrypt), locals.field_originalMd5 });
    String str;
    if ((!locals.field_fileCompress) && (!locals.field_fileEncrypt))
    {
      if ((!locals.field_deleted) && (!bo.isNullOrNil(locals.field_filePath)) && (bo.nullAsNil(com.tencent.mm.a.g.getMD5(locals.field_filePath)).equals(locals.field_md5)))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locals.field_filePath });
        str = locals.field_filePath;
        AppMethodBeat.o(79492);
        return str;
      }
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(79492);
      return null;
    }
    if (locals.field_fileCompress) {
      str = locals.field_filePath + ".decompressed";
    }
    for (;;)
    {
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(79492);
        return null;
        if (locals.field_fileEncrypt) {
          str = locals.field_filePath + ".decrypted";
        }
      }
      else
      {
        if ((!bo.isNullOrNil(locals.field_originalMd5)) && (bo.nullAsNil(com.tencent.mm.a.g.getMD5(str)).equals(locals.field_originalMd5)))
        {
          ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
          AppMethodBeat.o(79492);
          return str;
        }
        ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(79492);
        return null;
      }
      str = null;
    }
  }
  
  final void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(154795);
    q.a.dmz().O(new b.7(this, paramInt1, paramInt2, paramString1, paramInt3, paramString2));
    AppMethodBeat.o(154795);
  }
  
  final void a(int paramInt, bvd parambvd, boolean paramBoolean)
  {
    AppMethodBeat.i(79495);
    String str = i.hd(paramInt, parambvd.xCa);
    if (parambvd.xIN == null)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      AppMethodBeat.o(79495);
      return;
    }
    ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(parambvd.xCa), Integer.valueOf(parambvd.xIN.xIX) });
    j.B(parambvd.xIP, 3L);
    int i = parambvd.xIN.xIX;
    int j = parambvd.xCa;
    int k = parambvd.xIP;
    parambvd = parambvd.xIQ;
    q.a.dmz().O(new b.4(this, str, paramInt, j, i, k, parambvd, paramBoolean));
    AppMethodBeat.o(79495);
  }
  
  final void a(int paramInt, bvd parambvd, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(79497);
    String str = i.hd(paramInt, parambvd.xCa);
    if (parambvd.xIO == null)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
      AppMethodBeat.o(79497);
      return;
    }
    if (bo.isNullOrNil(parambvd.xIO.xIW))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
      AppMethodBeat.o(79497);
      return;
    }
    ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(parambvd.xCa), Integer.valueOf(parambvd.xIO.xIV) });
    ab.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { parambvd.xIO.xIW });
    j.B(parambvd.xIP, 4L);
    parambvd = new b.6(this, str, parambvd.xIN.xJa, parambvd.xIO.xIW, parambvd.xIO.xIV, parambvd.xIP, parambvd.xIQ, paramBoolean2);
    if (paramBoolean2)
    {
      parambvd.run();
      AppMethodBeat.o(79497);
      return;
    }
    q.a.dmz().O(parambvd);
    AppMethodBeat.o(79497);
  }
  
  public final void as(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(79488);
    e(paramInt1, paramInt2, paramInt3, true);
    AppMethodBeat.o(79488);
  }
  
  final void b(int paramInt, bvd parambvd, boolean paramBoolean)
  {
    AppMethodBeat.i(79496);
    String str = i.hd(paramInt, parambvd.xCa);
    if (parambvd.xIN == null)
    {
      ab.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      AppMethodBeat.o(79496);
      return;
    }
    int i = parambvd.xCa;
    int j = parambvd.xIN.xIX;
    if (parambvd.xIN.xIZ == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(parambvd.xIN.xIZ.size()))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(parambvd.xIP), parambvd.xIQ, parambvd.xIN.Url, parambvd.xIN.wPX });
      if (parambvd.xIN.xIZ == null) {
        break;
      }
      localObject = parambvd.xIN.xIZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ccr localccr = (ccr)((Iterator)localObject).next();
        ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localccr.Version), localccr.xNh.dqj() });
      }
    }
    j.nz(parambvd.xIP);
    if (!paramBoolean) {
      j.B(parambvd.xIP, 1L);
    }
    if ((parambvd.wCO != 0) && (parambvd.wCO <= bo.aox()))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(parambvd.wCO), Integer.valueOf(parambvd.xIN.xIX) });
      j.B(parambvd.xIP, 14L);
      j.B(parambvd.xIP, 44L);
      j.a(paramInt, parambvd.xCa, parambvd.xIN.Url, parambvd.xIN.xIX, j.a.vNN, false, paramBoolean, false, parambvd.xIQ);
      AppMethodBeat.o(79496);
      return;
    }
    if ((bo.isNullOrNil(parambvd.xIN.Url)) && (parambvd.xIN.wPX == null))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      AppMethodBeat.o(79496);
      return;
    }
    localObject = new g.a(parambvd.xIN.Url);
    ((g.a)localObject).alK(str);
    ((g.a)localObject).coJ = paramInt;
    ((g.a)localObject).subType = parambvd.xCa;
    ((g.a)localObject).nA(parambvd.wCO);
    ((g.a)localObject).coK = parambvd.xIN.xIX;
    ((g.a)localObject).alL(parambvd.xIN.wQr);
    ((g.a)localObject).vNr = i.a.LG(parambvd.xIN.xIY);
    ((g.a)localObject).vNs = i.a.LF(parambvd.xIN.xIY);
    ((g.a)localObject).vMR = parambvd.xIP;
    ((g.a)localObject).vMS = parambvd.xIQ;
    if (parambvd.xIR > 0) {}
    for (paramInt = parambvd.xIR;; paramInt = 3)
    {
      ((g.a)localObject).LN(paramInt);
      ((g.a)localObject).vNt = parambvd.vNt;
      ((g.a)localObject).LM(parambvd.xIS);
      ((g.a)localObject).coQ = paramBoolean;
      if (!bo.es(parambvd.xIN.xIZ)) {
        ((g.a)localObject).vMP = ((ccr)parambvd.xIN.xIZ.get(0)).xNh.pW;
      }
      if ((parambvd.xIO != null) && (!bo.isNullOrNil(parambvd.xIO.xIW)))
      {
        ((g.a)localObject).vMN = parambvd.xIO.xIW;
        ((g.a)localObject).vMO = parambvd.xIO.xIV;
      }
      if ((parambvd.xIN.wPX != null) && (parambvd.xIN.wPX.pW.length > 0)) {
        ((g.a)localObject).vNq = parambvd.xIN.wPX.toByteArray();
      }
      ((g.a)localObject).coM = parambvd.xIN.xJa;
      ((g.a)localObject).fileSize = parambvd.xIN.FileSize;
      ((g.a)localObject).LO(parambvd.xkR);
      parambvd = ((g.a)localObject).dmj();
      ab.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { parambvd.toString() });
      q.a.dmz().O(new b.5(this, str, parambvd));
      AppMethodBeat.o(79496);
      return;
    }
  }
  
  final void b(s params)
  {
    AppMethodBeat.i(79493);
    ab.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + params.field_urlKey);
    k localk = this.vMW;
    if (localk.alN(params.field_urlKey))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      AppMethodBeat.o(79493);
      return;
    }
    localk.a(a.a(params));
    AppMethodBeat.o(79493);
  }
  
  final Set<b.b> dma()
  {
    AppMethodBeat.i(79486);
    synchronized (this.vMV)
    {
      Set localSet2 = Collections.newSetFromMap(new android.support.v4.e.a(this.vMV.size()));
      localSet2.addAll(this.vMV);
      AppMethodBeat.o(79486);
      return localSet2;
    }
  }
  
  public final void e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(79487);
    q.a.dmz().O(new b.1(this, paramInt1, paramInt2, paramInt3, paramBoolean));
    AppMethodBeat.o(79487);
  }
  
  final void f(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(79499);
    if (q.a.dmz().handler == null)
    {
      ab.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      AppMethodBeat.o(79499);
      return;
    }
    q.a.dmz().handler.post(new b.2(this, paramInt3, paramInt1, paramInt2, paramBoolean));
    AppMethodBeat.o(79499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b
 * JD-Core Version:    0.7.0.1
 */