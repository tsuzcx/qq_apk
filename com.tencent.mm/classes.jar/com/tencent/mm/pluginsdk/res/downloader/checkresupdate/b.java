package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import android.util.SparseArray;
import com.tencent.matrix.report.e.a;
import com.tencent.matrix.report.e.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.res.downloader.model.d;
import com.tencent.mm.pluginsdk.res.downloader.model.l;
import com.tencent.mm.pluginsdk.res.downloader.model.p.a;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.protocal.protobuf.ery;
import com.tencent.mm.protocal.protobuf.fcm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  private final Set<b> XVh;
  private final k XVi;
  private final d XVj;
  
  private b()
  {
    AppMethodBeat.i(151932);
    this.XVh = Collections.newSetFromMap(new androidx.b.a(i.XVM.length));
    this.XVi = new k();
    this.XVj = new d()
    {
      public final void a(String paramAnonymousString, l paramAnonymousl)
      {
        int j = 1;
        AppMethodBeat.i(151913);
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onFailed: %s", new Object[] { paramAnonymousString });
        i.bqi(paramAnonymousString);
        paramAnonymousString = p.a.iJK().bqq(paramAnonymousString);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(151913);
          return;
        }
        int i = j;
        if (paramAnonymousl != null)
        {
          i = j;
          if (paramAnonymousl.XWJ != null)
          {
            if (!(paramAnonymousl.XWJ instanceof com.tencent.mm.pluginsdk.res.downloader.a.a)) {
              break label182;
            }
            j.ac(paramAnonymousString.field_reportId, 7L);
            i = 0;
          }
        }
        for (;;)
        {
          if (i != 0) {
            j.ac(paramAnonymousString.field_reportId, 11L);
          }
          j.ac(paramAnonymousString.field_reportId, 44L);
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, Util.getInt(paramAnonymousString.field_fileVersion, 0), j.a.XVZ, false, "NewXml".equalsIgnoreCase(paramAnonymousString.field_groupId2), false, paramAnonymousString.field_sampleId);
          j.r(paramAnonymousString.field_resType, paramAnonymousString.field_subType, Util.getInt(paramAnonymousString.field_fileVersion, 0), (int)paramAnonymousString.field_reportId, 78);
          AppMethodBeat.o(151913);
          return;
          label182:
          i = j;
          if ((paramAnonymousl.XWJ instanceof com.tencent.mm.pluginsdk.res.downloader.a.c))
          {
            j.ac(paramAnonymousString.field_reportId, 16L);
            i = 0;
          }
        }
      }
      
      public final String aVp()
      {
        return "CheckResUpdate";
      }
      
      public final void bqf(final String paramAnonymousString)
      {
        AppMethodBeat.i(151912);
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(paramAnonymousString)));
        r localr = p.a.iJK().bqq(paramAnonymousString);
        if (localr == null)
        {
          AppMethodBeat.o(151912);
          return;
        }
        j.ac(localr.field_reportId, 10L);
        j.ac(localr.field_reportId, 15L);
        j.r(localr.field_resType, localr.field_subType, Util.getInt(localr.field_fileVersion, 0), (int)localr.field_reportId, 77);
        if (((!localr.field_fileCompress) || (localr.field_fileEncrypt)) && (localr.field_fileUpdated)) {
          if (localr.field_maxRetryTimes <= localr.field_retryTimes) {
            break label290;
          }
        }
        label290:
        for (paramAnonymousString = j.a.XWa;; paramAnonymousString = j.a.XVY)
        {
          j.a(localr.field_resType, localr.field_subType, localr.field_url, Util.getInt(localr.field_fileVersion, 0), paramAnonymousString, true, Util.nullAsNil(localr.field_groupId2).equals("NewXml"), false, localr.field_sampleId);
          if ((localr.field_fileCompress) || (localr.field_fileEncrypt)) {
            break;
          }
          paramAnonymousString = new cd();
          paramAnonymousString.hCg.filePath = localr.field_filePath;
          paramAnonymousString.hCg.hCk = localr.field_originalMd5;
          paramAnonymousString.hCg.hCj = localr.field_fileUpdated;
          paramAnonymousString.hCg.hCi = Util.getInt(localr.field_fileVersion, 0);
          paramAnonymousString.hCg.hCh = localr.field_resType;
          paramAnonymousString.hCg.subType = localr.field_subType;
          p.a.iJK().handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(245018);
              paramAnonymousString.publish();
              AppMethodBeat.o(245018);
            }
          });
          localr.field_fileUpdated = false;
          p.a.iJK().h(localr);
          AppMethodBeat.o(151912);
          return;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
        b.this.b(localr);
        AppMethodBeat.o(151912);
      }
      
      public final void bqg(String paramAnonymousString)
      {
        AppMethodBeat.i(151914);
        com.tencent.mm.pluginsdk.res.downloader.model.p localp = p.a.iJK();
        if (localp.rqI) {}
        for (boolean bool = localp.XWU.bqm(paramAnonymousString);; bool = false)
        {
          if (!bool) {
            i.bqi(paramAnonymousString);
          }
          AppMethodBeat.o(151914);
          return;
        }
      }
    };
    Object localObject1 = p.a.iJK();
    d locald = this.XVj;
    Log.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { "CheckResUpdate", locald });
    if (((com.tencent.mm.pluginsdk.res.downloader.model.p)localObject1).rqI)
    {
      com.tencent.mm.pluginsdk.res.downloader.model.i locali = ((com.tencent.mm.pluginsdk.res.downloader.model.p)localObject1).XWV;
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(locald)));
      if (locald != null)
      {
        int i = "CheckResUpdate".hashCode();
        synchronized (locali.XWA)
        {
          List localList = (List)locali.XWz.get(i);
          localObject1 = localList;
          if (localList == null) {
            localObject1 = new LinkedList();
          }
          ((List)localObject1).add(locald);
          locali.XWz.put(i, localObject1);
          AppMethodBeat.o(151932);
          return;
        }
      }
    }
    AppMethodBeat.o(151932);
  }
  
  public static void avS(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(151933);
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject;
    if (com.tencent.matrix.c.a.ni(84))
    {
      localObject = com.tencent.matrix.a.b.awt().awu();
      e.b.b.a(paramInt, (com.tencent.matrix.a.b.b)localObject);
      if (!com.tencent.matrix.c.b.ayx()) {
        break label114;
      }
      Log.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "skip doCheck for low energy: doze mode on!");
    }
    for (;;)
    {
      if (i != 0) {
        e.a.ns(84);
      }
      h.baC();
      boolean bool1 = com.tencent.mm.kernel.b.aZM();
      boolean bool2 = bg.okT.aM("login_user_name", "").equals("");
      if ((!bool1) && (bool2))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
        AppMethodBeat.o(151933);
        return;
        label114:
        if ((com.tencent.matrix.a.b.isInit()) && (!((com.tencent.matrix.a.b.b)localObject).isForeground()) && (!com.tencent.matrix.a.b.b.bZ(((com.tencent.matrix.a.b.b)localObject).mContext))) {
          Log.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "skip doCheck for low energy: bg & non-charging!");
        }
      }
      else
      {
        localObject = new m(paramInt);
        h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0);
        AppMethodBeat.o(151933);
        return;
      }
      i = 0;
    }
  }
  
  public static List<r> avT(int paramInt)
  {
    AppMethodBeat.i(245014);
    List localList = p.a.iJK().bqr(String.format(Locale.ENGLISH, "%s.%%.data", new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(245014);
    return localList;
  }
  
  static void c(r paramr)
  {
    AppMethodBeat.i(151937);
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { paramr.field_urlKey });
    k.g(paramr);
    AppMethodBeat.o(151937);
  }
  
  public static b iJf()
  {
    AppMethodBeat.i(169213);
    if (!MMApplicationContext.isMainProcess()) {
      Assert.fail("Inaccessible in child process.");
    }
    b localb = c.iJl();
    AppMethodBeat.o(169213);
    return localb;
  }
  
  public static String iJg()
  {
    AppMethodBeat.i(151935);
    Object localObject = p.a.iJK().bqq(i.nL(60, 3));
    if (localObject == null)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getOriginalMd5, %d.%d, get null info, return", new Object[] { Integer.valueOf(60), Integer.valueOf(3) });
      AppMethodBeat.o(151935);
      return null;
    }
    localObject = ((r)localObject).field_originalMd5;
    AppMethodBeat.o(151935);
    return localObject;
  }
  
  public static int nJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245011);
    r localr = p.a.iJK().bqq(i.nL(paramInt1, paramInt2));
    if (localr == null)
    {
      AppMethodBeat.o(245011);
      return 0;
    }
    paramInt1 = Util.getInt(localr.field_fileVersion, 0);
    AppMethodBeat.o(245011);
    return paramInt1;
  }
  
  public static String nK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151934);
    r localr = p.a.iJK().bqq(i.nL(paramInt1, paramInt2));
    if (localr == null)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    Log.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[] { Boolean.valueOf(localr.field_deleted), localr.field_filePath, localr.field_md5, Boolean.valueOf(localr.field_fileCompress), Boolean.valueOf(localr.field_fileEncrypt), localr.field_originalMd5 });
    String str;
    if ((!localr.field_fileCompress) && (!localr.field_fileEncrypt))
    {
      if ((!localr.field_deleted) && (!Util.isNullOrNil(localr.field_filePath)) && (Util.nullAsNil(y.bub(localr.field_filePath)).equals(localr.field_md5)))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localr.field_filePath });
        str = localr.field_filePath;
        AppMethodBeat.o(151934);
        return str;
      }
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    if (localr.field_fileCompress) {
      str = localr.field_filePath + ".decompressed";
    }
    for (;;)
    {
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151934);
        return null;
        if (localr.field_fileEncrypt) {
          str = localr.field_filePath + ".decrypted";
        }
      }
      else
      {
        if ((!Util.isNullOrNil(localr.field_originalMd5)) && (Util.nullAsNil(y.bub(str)).equals(localr.field_originalMd5)))
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
          AppMethodBeat.o(151934);
          return str;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, needDecrypt(%b) needDecompress(%b), file invalid, return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(localr.field_fileEncrypt), Boolean.valueOf(localr.field_fileCompress) });
        AppMethodBeat.o(151934);
        return null;
      }
      str = null;
    }
  }
  
  final void a(final int paramInt, final erv paramerv, final boolean paramBoolean)
  {
    AppMethodBeat.i(151938);
    final String str = i.nL(paramInt, paramerv.abmA);
    if (paramerv.abvF == null)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      AppMethodBeat.o(151938);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramerv.abmA), Integer.valueOf(paramerv.abvF.abvO) });
    j.ac(paramerv.xKa, 3L);
    final int i = paramerv.abvF.abvO;
    final int j = paramerv.abmA;
    final int k = paramerv.xKa;
    paramerv = paramerv.abvH;
    p.a.iJK().au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151915);
        r localr = p.a.iJK().bqq(str);
        int i = paramInt;
        int j = j;
        int k = i;
        int m = k;
        String str1 = paramerv;
        boolean bool2 = paramBoolean;
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(localr)));
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
        boolean bool1 = false;
        String str2;
        if (localr != null) {
          if (Util.getInt(localr.field_fileVersion, 0) <= k)
          {
            bool1 = true;
            str2 = i.nL(i, j);
            String str3 = i.afg(str2);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
            if (!bool1) {
              break label443;
            }
            p.a.iJK().ZJ(str2);
            b.iJf().g(i, j, 2, bool2);
            if (!(com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(str3) & true & com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(str3 + ".decompressed") & com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(str3 + ".decrypted"))) {
              break label390;
            }
            if (localr != null)
            {
              j.ac(localr.field_reportId, 21L);
              j.a(localr.field_resType, localr.field_subType, k, bool2, localr.field_sampleId);
            }
          }
        }
        for (;;)
        {
          if (localr != null) {
            break label420;
          }
          localr = new r();
          localr.field_urlKey = str2;
          localr.field_resType = i;
          localr.field_subType = j;
          localr.field_deleted = true;
          localr.field_fileVersion = String.valueOf(k);
          localr.field_reportId = m;
          localr.field_sampleId = str1;
          p.a.iJK().h(localr);
          AppMethodBeat.o(151915);
          return;
          j.ac(localr.field_reportId, 47L);
          j.ac(localr.field_reportId, 22L);
          break;
          j.ac(m, 47L);
          j.ac(m, 22L);
          bool1 = true;
          break;
          label390:
          if (localr != null)
          {
            j.ac(localr.field_reportId, 22L);
            j.ac(localr.field_reportId, 47L);
          }
        }
        label420:
        localr.field_deleted = true;
        localr.field_fileVersion = String.valueOf(k);
        p.a.iJK().h(localr);
        label443:
        AppMethodBeat.o(151915);
      }
    });
    AppMethodBeat.o(151938);
  }
  
  final void a(int paramInt, erv paramerv, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151940);
    final String str = i.nL(paramInt, paramerv.abmA);
    if ((paramerv.abvG == null) || (Util.isNullOrNil(paramerv.abvG.abvN)))
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key invalid, resource=%d.%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramerv.abmA) });
      AppMethodBeat.o(151940);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(paramerv.abmA), Integer.valueOf(paramerv.abvG.abvM) });
    Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramerv.abvG.abvN });
    j.ac(paramerv.xKa, 4L);
    paramerv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151917);
        r localr = p.a.iJK().bqq(str);
        String str1 = this.XVs;
        String str2 = this.XVt;
        int i = this.XVu;
        int j = this.qJk;
        String str3 = this.XVq;
        boolean bool = paramBoolean2;
        if (localr == null)
        {
          localr = new r();
          localr.field_keyVersion = i;
          localr.field_encryptKey = str2;
          localr.field_reportId = j;
          localr.field_sampleId = str3;
          localr.field_originalMd5 = str1;
          p.a.iJK().h(localr);
          j.ac(j, 51L);
          j.ac(j, 45L);
          AppMethodBeat.o(151917);
          return;
        }
        if (localr.field_keyVersion < i)
        {
          localr.field_keyVersion = i;
          localr.field_encryptKey = str2;
          localr.field_reportId = j;
          localr.field_sampleId = str3;
          if (Util.isNullOrNil(localr.field_originalMd5)) {
            localr.field_originalMd5 = str1;
          }
          p.a.iJK().h(localr);
          f.b.a(localr, true, bool);
          AppMethodBeat.o(151917);
          return;
        }
        if ((bool) && (localr.field_keyVersion == i)) {
          f.b.a(localr, true, true);
        }
        AppMethodBeat.o(151917);
      }
    };
    if (paramBoolean2)
    {
      paramerv.run();
      AppMethodBeat.o(151940);
      return;
    }
    p.a.iJK().au(paramerv);
    AppMethodBeat.o(151940);
  }
  
  final void b(int paramInt, final erv paramerv, boolean paramBoolean)
  {
    AppMethodBeat.i(151939);
    final String str = i.nL(paramInt, paramerv.abmA);
    if (paramerv.abvF == null)
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      AppMethodBeat.o(151939);
      return;
    }
    int i = paramerv.abmA;
    int j = paramerv.abvF.abvO;
    if (paramerv.abvF.abvQ == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramerv.abvF.abvQ.size()))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramerv.xKa), paramerv.abvH, paramerv.abvF.Url, paramerv.abvF.abvR });
      if (paramerv.abvF.abvQ == null) {
        break;
      }
      localObject = paramerv.abvF.abvQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        fcm localfcm = (fcm)((Iterator)localObject).next();
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localfcm.crz), localfcm.abCb.ZV() });
      }
    }
    j.yk(paramerv.xKa);
    if (!paramBoolean) {
      j.ac(paramerv.xKa, 1L);
    }
    if ((paramerv.Zan != 0) && (paramerv.Zan <= Util.nowSecond()))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramerv.Zan), Integer.valueOf(paramerv.abvF.abvO) });
      j.ac(paramerv.xKa, 14L);
      j.ac(paramerv.xKa, 44L);
      j.a(paramInt, paramerv.abmA, paramerv.abvF.Url, paramerv.abvF.abvO, j.a.XWc, false, paramBoolean, false, paramerv.abvH);
      AppMethodBeat.o(151939);
      return;
    }
    if ((Util.isNullOrNil(paramerv.abvF.Url)) && (paramerv.abvF.abvR == null))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      AppMethodBeat.o(151939);
      return;
    }
    localObject = new g.a(paramerv.abvF.Url);
    ((g.a)localObject).bqk(str);
    ((g.a)localObject).hCh = paramInt;
    ((g.a)localObject).subType = paramerv.abmA;
    ((g.a)localObject).yl(paramerv.Zan);
    ((g.a)localObject).hCi = paramerv.abvF.abvO;
    ((g.a)localObject).bql(paramerv.abvF.MD5);
    ((g.a)localObject).XVF = i.a.avV(paramerv.abvF.abvP);
    ((g.a)localObject).XVG = i.a.avU(paramerv.abvF.abvP);
    ((g.a)localObject).Wmc = paramerv.xKa;
    ((g.a)localObject).XVe = paramerv.abvH;
    if (paramerv.abvI > 0) {}
    for (paramInt = paramerv.abvI;; paramInt = 3)
    {
      ((g.a)localObject).awc(paramInt);
      ((g.a)localObject).XVH = paramerv.XVH;
      ((g.a)localObject).awb(paramerv.abvJ);
      ((g.a)localObject).hCn = paramBoolean;
      if (!Util.isNullOrNil(paramerv.abvF.abvQ)) {
        ((g.a)localObject).XVc = ((fcm)paramerv.abvF.abvQ.get(0)).abCb.Op;
      }
      if ((paramerv.abvG != null) && (!Util.isNullOrNil(paramerv.abvG.abvN)))
      {
        ((g.a)localObject).XVa = paramerv.abvG.abvN;
        ((g.a)localObject).XVb = paramerv.abvG.abvM;
      }
      if ((paramerv.abvF.abvR != null) && (paramerv.abvF.abvR.Op.length > 0)) {
        ((g.a)localObject).XVE = paramerv.abvF.abvR.toByteArray();
      }
      ((g.a)localObject).hCk = paramerv.abvF.abvS;
      ((g.a)localObject).fileSize = paramerv.abvF.Nju;
      ((g.a)localObject).awd(paramerv.aaFY);
      paramerv = ((g.a)localObject).iJp();
      Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramerv.toString() });
      p.a.iJK().au(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151916);
          r localr1 = p.a.iJK().bqq(str);
          g localg = paramerv;
          if (localr1 == null) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null, urlKey = %s", new Object[] { localg.XUX });
          }
          while ((localr1 != null) && (localr1.field_deleted) && (localg.bqh(localr1.field_fileVersion) <= 0))
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { localr1.field_fileVersion, localg.XWr });
            AppMethodBeat.o(151916);
            return;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { localr1.field_urlKey, localr1.field_url, Long.valueOf(localr1.field_contentLength), Boolean.valueOf(localr1.field_deleted), localr1.field_eccSignature, Long.valueOf(localr1.field_expireTime), Boolean.valueOf(localr1.field_fileCompress), Boolean.valueOf(localr1.field_fileEncrypt), localr1.field_filePath, Boolean.valueOf(localr1.field_fileUpdated), localr1.field_fileVersion, localr1.field_groupId2, Integer.valueOf(localr1.field_keyVersion), Boolean.valueOf(Util.isNullOrNil(localr1.field_encryptKey)), Integer.valueOf(localr1.field_maxRetryTimes), Integer.valueOf(localr1.field_retryTimes), localr1.field_sampleId, Integer.valueOf(localr1.field_status) });
            Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { localr1.field_encryptKey });
          }
          if (localr1 == null)
          {
            localr1 = localg.iJo();
            localr1.field_fileUpdated = true;
            localr1.field_needRetry = true;
            if (Util.isNullOrNil(localr1.field_encryptKey)) {
              localr1.field_keyVersion = -1;
            }
            Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(localr1)));
            p.a.iJK().h(localr1);
            b.iJf().g(localg.hCh, localg.subType, 0, localg.hCn);
            f.a.a(true, true, localr1, localg);
            AppMethodBeat.o(151916);
            return;
          }
          Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
          localr1.field_networkType = localg.networkType;
          if (Util.isNullOrNil(localr1.field_originalMd5)) {
            localr1.field_originalMd5 = localg.hCk;
          }
          if (localg.bqh(localr1.field_fileVersion) > 0)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
            r localr2 = localg.iJo();
            if (localr1.field_keyVersion >= localg.XVb)
            {
              localr2.field_keyVersion = localr1.field_keyVersion;
              localr2.field_encryptKey = localr1.field_encryptKey;
            }
            localr2.field_fileUpdated = true;
            localr2.field_needRetry = true;
            localr2.field_deleted = false;
            p.a.iJK().h(localr2);
            b.iJf().g(localg.hCh, localg.subType, 0, localg.hCn);
            p.a.iJK().ZJ(localg.XUX);
            f.a.a(false, true, localr2, localg);
            AppMethodBeat.o(151916);
            return;
          }
          if ((localg.bqh(localr1.field_fileVersion) == 0) && (!localr1.field_needRetry))
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(localr1.field_resType), Integer.valueOf(localr1.field_subType), localr1.field_fileVersion });
            AppMethodBeat.o(151916);
            return;
          }
          if ((localr1.field_status == 2) || (localr1.field_status == 1) || (localr1.field_status == 0))
          {
            long l = com.tencent.mm.pluginsdk.res.downloader.b.a.jK(localr1.field_filePath);
            if (localr1.field_contentLength > l)
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(localr1.field_contentLength), Long.valueOf(l) });
              if (0L == l)
              {
                b.iJf().g(localg.hCh, localg.subType, 0, localg.hCn);
                f.a.a(false, true, localr1, localg);
                AppMethodBeat.o(151916);
                return;
              }
              f.a.a(true, false, localr1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            if (!Util.nullAsNil(y.bub(i.afg(localg.XUX))).equals(localr1.field_md5))
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
              f.a.a(false, true, localr1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { localr1.field_urlKey });
            localr1.field_status = 2;
            localr1.field_contentLength = com.tencent.mm.pluginsdk.res.downloader.b.a.jK(localr1.field_filePath);
            localr1.field_fileUpdated = false;
            localr1.field_reportId = localg.Wmc;
            p.a.iJK().h(localr1);
            j.ac(localr1.field_reportId, 13L);
            j.ac(localr1.field_reportId, 44L);
            j.a(localr1.field_resType, localr1.field_subType, localr1.field_url, Util.getInt(localr1.field_fileVersion, 0), j.a.XWb, true, "NewXml".equalsIgnoreCase(localr1.field_groupId2), true, localr1.field_sampleId);
            if ((!localg.XVF) && (!localg.XVG))
            {
              b.iJf().c(localg.hCh, localg.subType, i.afg(localg.XUX), Util.getInt(localg.XWr, 0), localg.hCk);
              AppMethodBeat.o(151916);
              return;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { localg.XUX });
            f.b.a(localr1, false, false);
            AppMethodBeat.o(151916);
            return;
          }
          if ((localr1.field_status == 4) || (localr1.field_status == 3))
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", new Object[] { localr1.field_urlKey });
            f.a.a(false, true, localr1, localg);
          }
          AppMethodBeat.o(151916);
        }
      });
      AppMethodBeat.o(151939);
      return;
    }
  }
  
  final void b(r paramr)
  {
    AppMethodBeat.i(151936);
    Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + paramr.field_urlKey);
    k localk = this.XVi;
    if (localk.bqn(paramr.field_urlKey))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      AppMethodBeat.o(151936);
      return;
    }
    localk.a(a.a(paramr));
    AppMethodBeat.o(151936);
  }
  
  public final void bu(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151930);
    f(paramInt1, paramInt2, paramInt3, true);
    AppMethodBeat.o(151930);
  }
  
  final void c(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(151941);
    p.a.iJK().au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151918);
        b localb = b.this;
        int i = paramInt1;
        int j = paramInt2;
        String str1 = paramString1;
        int k = paramInt3;
        String str2 = paramString2;
        Object localObject = i.nL(i, j);
        localObject = p.a.iJK().bqq((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(151918);
          return;
        }
        boolean bool = ((r)localObject).field_fileUpdated;
        ((r)localObject).field_fileUpdated = false;
        p.a.iJK().h((r)localObject);
        if (k == Util.getInt(((r)localObject).field_fileVersion, 0))
        {
          if (p.a.iJK().handler == null)
          {
            Log.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            AppMethodBeat.o(151918);
            return;
          }
          p.a.iJK().handler.post(new b.8(localb, i, j, str1, k, bool, str2));
        }
        AppMethodBeat.o(151918);
      }
    });
    AppMethodBeat.o(151941);
  }
  
  public final void f(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151929);
    p.a.iJK().au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151910);
        r localr = p.a.iJK().bqq(i.nL(paramInt1, paramInt2));
        if ((localr != null) && ((-1 == paramInt3) || (String.valueOf(paramInt3).equals(localr.field_fileVersion)))) {
          if (paramBoolean) {
            break label79;
          }
        }
        label79:
        for (boolean bool = true;; bool = false)
        {
          localr.field_needRetry = bool;
          p.a.iJK().h(localr);
          AppMethodBeat.o(151910);
          return;
        }
      }
    });
    AppMethodBeat.o(151929);
  }
  
  final void g(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(151942);
    if (p.a.iJK().handler == null)
    {
      Log.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      AppMethodBeat.o(151942);
      return;
    }
    p.a.iJK().handler.post(new b.2(this, paramInt3, paramInt1, paramInt2, paramBoolean));
    AppMethodBeat.o(151942);
  }
  
  final Set<b> iJe()
  {
    AppMethodBeat.i(151928);
    synchronized (this.XVh)
    {
      Set localSet2 = Collections.newSetFromMap(new androidx.b.a(this.XVh.size()));
      localSet2.addAll(this.XVh);
      AppMethodBeat.o(151928);
      return localSet2;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean iJk();
  }
  
  static final class c
  {
    private static final b XVC;
    
    static
    {
      AppMethodBeat.i(151927);
      XVC = new b((byte)0);
      AppMethodBeat.o(151927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b
 * JD-Core Version:    0.7.0.1
 */