package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.g.a.c.a.a;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.protocal.c.blr;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.bsg;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
{
  private final Set<b.b> rWf = Collections.newSetFromMap(new android.support.v4.f.a(i.rWF.length));
  private final k rWg = new k();
  private final d rhO = new b.3(this);
  
  private b()
  {
    q.a.clL().a("CheckResUpdate", this.rhO);
  }
  
  public static void DL(int paramInt)
  {
    y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.DN();
    boolean bool1 = com.tencent.mm.kernel.a.Db();
    boolean bool2 = at.dVC.L("login_user_name", "").equals("");
    if ((!bool1) && (bool2))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
      return;
    }
    m localm = new m(paramInt);
    com.tencent.mm.kernel.g.DO().dJT.a(localm, 0);
  }
  
  public static String eV(int paramInt1, int paramInt2)
  {
    s locals = q.a.clL().Wl(i.eW(paramInt1, paramInt2));
    if (locals == null)
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return null;
    }
    y.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[] { Boolean.valueOf(locals.field_deleted), locals.field_filePath, locals.field_md5, Boolean.valueOf(locals.field_fileCompress), Boolean.valueOf(locals.field_fileEncrypt), locals.field_originalMd5 });
    if ((!locals.field_fileCompress) && (!locals.field_fileEncrypt))
    {
      if ((!locals.field_deleted) && (!bk.bl(locals.field_filePath)) && (bk.pm(com.tencent.mm.a.g.bQ(locals.field_filePath)).equals(locals.field_md5)))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locals.field_filePath });
        return locals.field_filePath;
      }
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return null;
    }
    String str;
    if (locals.field_fileCompress) {
      str = locals.field_filePath + ".decompressed";
    }
    for (;;)
    {
      if (bk.bl(str))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return null;
        if (locals.field_fileEncrypt) {
          str = locals.field_filePath + ".decrypted";
        }
      }
      else
      {
        if ((!bk.bl(locals.field_originalMd5)) && (bk.pm(com.tencent.mm.a.g.bQ(str)).equals(locals.field_originalMd5)))
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
          return str;
        }
        y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return null;
      }
      str = null;
    }
  }
  
  final void a(int paramInt, blr paramblr, boolean paramBoolean)
  {
    String str = i.eW(paramInt, paramblr.tAu);
    if (paramblr.tFh == null)
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      return;
    }
    y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramblr.tAu), Integer.valueOf(paramblr.tFh.tFr) });
    j.s(paramblr.tFj, 3L);
    int i = paramblr.tFh.tFr;
    int j = paramblr.tAu;
    int k = paramblr.tFj;
    paramblr = paramblr.tFk;
    q.a.clL().H(new b.4(this, str, paramInt, j, i, k, paramblr, paramBoolean));
  }
  
  final void a(int paramInt, blr paramblr, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = i.eW(paramInt, paramblr.tAu);
    if (paramblr.tFi == null)
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
      return;
    }
    if (bk.bl(paramblr.tFi.tFq))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
      return;
    }
    y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(paramblr.tAu), Integer.valueOf(paramblr.tFi.tFp) });
    y.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramblr.tFi.tFq });
    j.s(paramblr.tFj, 4L);
    paramblr = new b.6(this, str, paramblr.tFh.tFu, paramblr.tFi.tFq, paramblr.tFi.tFp, paramblr.tFj, paramblr.tFk, false);
    q.a.clL().H(paramblr);
  }
  
  public final void af(int paramInt1, int paramInt2, int paramInt3)
  {
    d(paramInt1, paramInt2, paramInt3, true);
  }
  
  final void b(int paramInt, blr paramblr, boolean paramBoolean)
  {
    String str = i.eW(paramInt, paramblr.tAu);
    if (paramblr.tFh == null)
    {
      y.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      return;
    }
    int i = paramblr.tAu;
    int j = paramblr.tFh.tFr;
    if (paramblr.tFh.tFt == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramblr.tFh.tFt.size()))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramblr.tFj), paramblr.tFk, paramblr.tFh.kSC, paramblr.tFh.sRj });
      if (paramblr.tFh.tFt == null) {
        break;
      }
      localObject = paramblr.tFh.tFt.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bsg localbsg = (bsg)((Iterator)localObject).next();
        y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localbsg.hQQ), localbsg.tIT.coM() });
      }
    }
    j.he(paramblr.tFj);
    if (!paramBoolean) {
      j.s(paramblr.tFj, 1L);
    }
    if ((paramblr.sGq != 0) && (paramblr.sGq <= bk.UX()))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramblr.sGq), Integer.valueOf(paramblr.tFh.tFr) });
      j.s(paramblr.tFj, 14L);
      j.s(paramblr.tFj, 44L);
      j.a(paramInt, paramblr.tAu, paramblr.tFh.kSC, paramblr.tFh.tFr, j.a.rWV, false, paramBoolean, false, paramblr.tFk);
      return;
    }
    if ((bk.bl(paramblr.tFh.kSC)) && (paramblr.tFh.sRj == null))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      return;
    }
    localObject = new g.a(paramblr.tFh.kSC);
    ((a.a)localObject).rVT = str;
    ((g.a)localObject).bHv = paramInt;
    ((g.a)localObject).brC = paramblr.tAu;
    ((a.a)localObject).eCv = paramblr.sGq;
    ((g.a)localObject).bHw = paramblr.tFh.tFr;
    ((a.a)localObject).bIW = paramblr.tFh.sRE;
    ((g.a)localObject).rWz = i.a.DN(paramblr.tFh.tFs);
    ((g.a)localObject).rWA = i.a.DM(paramblr.tFh.tFs);
    ((g.a)localObject).rWb = paramblr.tFj;
    ((g.a)localObject).rWc = paramblr.tFk;
    if (paramblr.tFl > 0) {}
    for (paramInt = paramblr.tFl;; paramInt = 3)
    {
      ((a.a)localObject).rWd = paramInt;
      ((g.a)localObject).rWB = paramblr.rWB;
      ((a.a)localObject).networkType = paramblr.tFm;
      ((g.a)localObject).bHB = paramBoolean;
      if (!bk.dk(paramblr.tFh.tFt)) {
        ((g.a)localObject).rVY = ((bsg)paramblr.tFh.tFt.get(0)).tIT.oY;
      }
      if ((paramblr.tFi != null) && (!bk.bl(paramblr.tFi.tFq)))
      {
        ((g.a)localObject).rVW = paramblr.tFi.tFq;
        ((g.a)localObject).rVX = paramblr.tFi.tFp;
      }
      if ((paramblr.tFh.sRj != null) && (paramblr.tFh.sRj.oY.length > 0)) {
        ((g.a)localObject).rWy = paramblr.tFh.sRj.toByteArray();
      }
      ((g.a)localObject).rVZ = paramblr.tFh.tFu;
      ((g.a)localObject).fileSize = paramblr.tFh.ndo;
      ((a.a)localObject).priority = paramblr.tly;
      paramblr = new g(((g.a)localObject).url, ((g.a)localObject).rVT, ((g.a)localObject).bHw, ((g.a)localObject).networkType, ((g.a)localObject).rWd, ((g.a)localObject).eCv, ((g.a)localObject).bIW, ((g.a)localObject).bHv, ((g.a)localObject).brC, ((g.a)localObject).rWb, ((g.a)localObject).rWc, ((g.a)localObject).rVY, ((g.a)localObject).rVZ, ((g.a)localObject).rWz, ((g.a)localObject).rWA, ((g.a)localObject).rVW, ((g.a)localObject).rVX, ((g.a)localObject).rWB, ((g.a)localObject).rWy, ((g.a)localObject).fileSize, ((g.a)localObject).bHB, ((g.a)localObject).bHx, ((g.a)localObject).priority);
      y.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramblr.toString() });
      q.a.clL().H(new b.5(this, str, paramblr));
      return;
    }
  }
  
  final void b(s params)
  {
    y.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + params.field_urlKey);
    k localk = this.rWg;
    if (localk.Wj(params.field_urlKey))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      return;
    }
    localk.a(a.a(params));
  }
  
  final Set<b.b> clt()
  {
    synchronized (this.rWf)
    {
      Set localSet2 = Collections.newSetFromMap(new android.support.v4.f.a(this.rWf.size()));
      localSet2.addAll(this.rWf);
      return localSet2;
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    q.a.clL().H(new b.1(this, paramInt1, paramInt2, paramInt3, paramBoolean));
  }
  
  final void e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (q.a.clL().handler == null)
    {
      y.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      return;
    }
    q.a.clL().handler.post(new b.2(this, paramInt3, paramInt1, paramInt2, paramBoolean));
  }
  
  final void e(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    q.a.clL().H(new b.7(this, paramInt1, paramInt2, paramString, paramInt3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b
 * JD-Core Version:    0.7.0.1
 */