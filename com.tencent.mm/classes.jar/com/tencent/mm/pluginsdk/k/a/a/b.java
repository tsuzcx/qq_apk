package com.tencent.mm.pluginsdk.k.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.bw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.k.a.c.d;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.pluginsdk.k.a.c.p.a;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.protocal.protobuf.dyr;
import com.tencent.mm.protocal.protobuf.dyt;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.protocal.protobuf.eik;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  private final Set<b> QZe;
  private final k QZf;
  private final d QZg;
  
  private b()
  {
    AppMethodBeat.i(151932);
    this.QZe = Collections.newSetFromMap(new androidx.b.a(i.QZI.length));
    this.QZf = new k();
    this.QZg = new d()
    {
      public final void a(String paramAnonymousString, l paramAnonymousl)
      {
        int j = 1;
        AppMethodBeat.i(151913);
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onFailed: %s", new Object[] { paramAnonymousString });
        i.bqu(paramAnonymousString);
        paramAnonymousString = p.a.hiK().bqC(paramAnonymousString);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(151913);
          return;
        }
        int i = j;
        if (paramAnonymousl != null)
        {
          i = j;
          if (paramAnonymousl.RaE != null)
          {
            if (!(paramAnonymousl.RaE instanceof com.tencent.mm.pluginsdk.k.a.b.a)) {
              break label182;
            }
            j.F(paramAnonymousString.field_reportId, 7L);
            i = 0;
          }
        }
        for (;;)
        {
          if (i != 0) {
            j.F(paramAnonymousString.field_reportId, 11L);
          }
          j.F(paramAnonymousString.field_reportId, 44L);
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, Util.getInt(paramAnonymousString.field_fileVersion, 0), j.a.QZV, false, "NewXml".equalsIgnoreCase(paramAnonymousString.field_groupId2), false, paramAnonymousString.field_sampleId);
          j.p(paramAnonymousString.field_resType, paramAnonymousString.field_subType, Util.getInt(paramAnonymousString.field_fileVersion, 0), (int)paramAnonymousString.field_reportId, 78);
          AppMethodBeat.o(151913);
          return;
          label182:
          i = j;
          if ((paramAnonymousl.RaE instanceof com.tencent.mm.pluginsdk.k.a.b.c))
          {
            j.F(paramAnonymousString.field_reportId, 16L);
            i = 0;
          }
        }
      }
      
      public final String aCt()
      {
        return "CheckResUpdate";
      }
      
      public final void bqr(final String paramAnonymousString)
      {
        AppMethodBeat.i(151912);
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(paramAnonymousString)));
        r localr = p.a.hiK().bqC(paramAnonymousString);
        if (localr == null)
        {
          AppMethodBeat.o(151912);
          return;
        }
        j.F(localr.field_reportId, 10L);
        j.F(localr.field_reportId, 15L);
        j.p(localr.field_resType, localr.field_subType, Util.getInt(localr.field_fileVersion, 0), (int)localr.field_reportId, 77);
        if (((!localr.field_fileCompress) || (localr.field_fileEncrypt)) && (localr.field_fileUpdated)) {
          if (localr.field_maxRetryTimes <= localr.field_retryTimes) {
            break label290;
          }
        }
        label290:
        for (paramAnonymousString = j.a.QZW;; paramAnonymousString = j.a.QZU)
        {
          j.a(localr.field_resType, localr.field_subType, localr.field_url, Util.getInt(localr.field_fileVersion, 0), paramAnonymousString, true, Util.nullAsNil(localr.field_groupId2).equals("NewXml"), false, localr.field_sampleId);
          if ((localr.field_fileCompress) || (localr.field_fileEncrypt)) {
            break;
          }
          paramAnonymousString = new bu();
          paramAnonymousString.fxB.filePath = localr.field_filePath;
          paramAnonymousString.fxB.fxF = localr.field_originalMd5;
          paramAnonymousString.fxB.fxE = localr.field_fileUpdated;
          paramAnonymousString.fxB.fxD = Util.getInt(localr.field_fileVersion, 0);
          paramAnonymousString.fxB.fxC = localr.field_resType;
          paramAnonymousString.fxB.subType = localr.field_subType;
          p.a.hiK().handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(226642);
              EventCenter.instance.publish(paramAnonymousString);
              AppMethodBeat.o(226642);
            }
          });
          localr.field_fileUpdated = false;
          p.a.hiK().h(localr);
          AppMethodBeat.o(151912);
          return;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
        b.this.b(localr);
        AppMethodBeat.o(151912);
      }
      
      public final void bqs(String paramAnonymousString)
      {
        AppMethodBeat.i(151914);
        p localp = p.a.hiK();
        if (localp.omY) {}
        for (boolean bool = localp.RaO.bqy(paramAnonymousString);; bool = false)
        {
          if (!bool) {
            i.bqu(paramAnonymousString);
          }
          AppMethodBeat.o(151914);
          return;
        }
      }
    };
    Object localObject1 = p.a.hiK();
    d locald = this.QZg;
    Log.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { "CheckResUpdate", locald });
    if (((p)localObject1).omY)
    {
      com.tencent.mm.pluginsdk.k.a.c.i locali = ((p)localObject1).RaP;
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(locald)));
      if (locald != null)
      {
        int i = "CheckResUpdate".hashCode();
        synchronized (locali.Rav)
        {
          List localList = (List)locali.Rau.get(i);
          localObject1 = localList;
          if (localList == null) {
            localObject1 = new LinkedList();
          }
          ((List)localObject1).add(locald);
          locali.Rau.put(i, localObject1);
          AppMethodBeat.o(151932);
          return;
        }
      }
    }
    AppMethodBeat.o(151932);
  }
  
  public static void apP(int paramInt)
  {
    AppMethodBeat.i(151933);
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    h.aHE();
    boolean bool1 = com.tencent.mm.kernel.b.aGL();
    boolean bool2 = bg.ltv.aD("login_user_name", "").equals("");
    if ((!bool1) && (bool2))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
      AppMethodBeat.o(151933);
      return;
    }
    m localm = new m(paramInt);
    h.aHF().kcd.a(localm, 0);
    AppMethodBeat.o(151933);
  }
  
  static void c(r paramr)
  {
    AppMethodBeat.i(151937);
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { paramr.field_urlKey });
    k.g(paramr);
    AppMethodBeat.o(151937);
  }
  
  public static b hii()
  {
    AppMethodBeat.i(169213);
    if (!MMApplicationContext.isMainProcess()) {
      Assert.fail("Inaccessible in child process.");
    }
    b localb = c.hin();
    AppMethodBeat.o(169213);
    return localb;
  }
  
  public static String hij()
  {
    AppMethodBeat.i(151935);
    Object localObject = p.a.hiK().bqC(i.lW(60, 3));
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
  
  public static String lV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151934);
    r localr = p.a.hiK().bqC(i.lW(paramInt1, paramInt2));
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
      if ((!localr.field_deleted) && (!Util.isNullOrNil(localr.field_filePath)) && (Util.nullAsNil(u.buc(localr.field_filePath)).equals(localr.field_md5)))
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
        if ((!Util.isNullOrNil(localr.field_originalMd5)) && (Util.nullAsNil(u.buc(str)).equals(localr.field_originalMd5)))
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
  
  final void a(final int paramInt, final dyr paramdyr, final boolean paramBoolean)
  {
    AppMethodBeat.i(151938);
    final String str = i.lW(paramInt, paramdyr.TVM);
    if (paramdyr.Uer == null)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      AppMethodBeat.o(151938);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramdyr.TVM), Integer.valueOf(paramdyr.Uer.UeB) });
    j.F(paramdyr.Uet, 3L);
    final int i = paramdyr.Uer.UeB;
    final int j = paramdyr.TVM;
    final int k = paramdyr.Uet;
    paramdyr = paramdyr.Ueu;
    p.a.hiK().am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151915);
        r localr = p.a.hiK().bqC(str);
        int i = paramInt;
        int j = j;
        int k = i;
        int m = k;
        String str1 = paramdyr;
        boolean bool2 = paramBoolean;
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(localr)));
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
        boolean bool1 = false;
        String str2;
        if (localr != null) {
          if (Util.getInt(localr.field_fileVersion, 0) <= k)
          {
            bool1 = true;
            str2 = i.lW(i, j);
            String str3 = i.alY(str2);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
            if (!bool1) {
              break label443;
            }
            p.a.hiK().agN(str2);
            b.hii().h(i, j, 2, bool2);
            if (!(com.tencent.mm.pluginsdk.k.a.d.a.bqF(str3) & true & com.tencent.mm.pluginsdk.k.a.d.a.bqF(str3 + ".decompressed") & com.tencent.mm.pluginsdk.k.a.d.a.bqF(str3 + ".decrypted"))) {
              break label390;
            }
            if (localr != null)
            {
              j.F(localr.field_reportId, 21L);
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
          p.a.hiK().h(localr);
          AppMethodBeat.o(151915);
          return;
          j.F(localr.field_reportId, 47L);
          j.F(localr.field_reportId, 22L);
          break;
          j.F(m, 47L);
          j.F(m, 22L);
          bool1 = true;
          break;
          label390:
          if (localr != null)
          {
            j.F(localr.field_reportId, 22L);
            j.F(localr.field_reportId, 47L);
          }
        }
        label420:
        localr.field_deleted = true;
        localr.field_fileVersion = String.valueOf(k);
        p.a.hiK().h(localr);
        label443:
        AppMethodBeat.o(151915);
      }
    });
    AppMethodBeat.o(151938);
  }
  
  final void a(int paramInt, dyr paramdyr, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151940);
    final String str = i.lW(paramInt, paramdyr.TVM);
    if ((paramdyr.Ues == null) || (Util.isNullOrNil(paramdyr.Ues.UeA)))
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key invalid, resource=%d.%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramdyr.TVM) });
      AppMethodBeat.o(151940);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(paramdyr.TVM), Integer.valueOf(paramdyr.Ues.Uez) });
    Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramdyr.Ues.UeA });
    j.F(paramdyr.Uet, 4L);
    paramdyr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151917);
        r localr = p.a.hiK().bqC(str);
        String str1 = this.QZp;
        String str2 = this.QZq;
        int i = this.QZr;
        int j = this.nJD;
        String str3 = this.QZn;
        boolean bool = paramBoolean2;
        if (localr == null)
        {
          localr = new r();
          localr.field_keyVersion = i;
          localr.field_encryptKey = str2;
          localr.field_reportId = j;
          localr.field_sampleId = str3;
          localr.field_originalMd5 = str1;
          p.a.hiK().h(localr);
          j.F(j, 51L);
          j.F(j, 45L);
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
          p.a.hiK().h(localr);
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
      paramdyr.run();
      AppMethodBeat.o(151940);
      return;
    }
    p.a.hiK().am(paramdyr);
    AppMethodBeat.o(151940);
  }
  
  public final void aT(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151930);
    g(paramInt1, paramInt2, paramInt3, true);
    AppMethodBeat.o(151930);
  }
  
  final void b(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(151941);
    p.a.hiK().am(new Runnable()
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
        Object localObject = i.lW(i, j);
        localObject = p.a.hiK().bqC((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(151918);
          return;
        }
        boolean bool = ((r)localObject).field_fileUpdated;
        ((r)localObject).field_fileUpdated = false;
        p.a.hiK().h((r)localObject);
        if (k == Util.getInt(((r)localObject).field_fileVersion, 0))
        {
          if (p.a.hiK().handler == null)
          {
            Log.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            AppMethodBeat.o(151918);
            return;
          }
          p.a.hiK().handler.post(new b.8(localb, i, j, str1, k, bool, str2));
        }
        AppMethodBeat.o(151918);
      }
    });
    AppMethodBeat.o(151941);
  }
  
  final void b(int paramInt, final dyr paramdyr, boolean paramBoolean)
  {
    AppMethodBeat.i(151939);
    final String str = i.lW(paramInt, paramdyr.TVM);
    if (paramdyr.Uer == null)
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      AppMethodBeat.o(151939);
      return;
    }
    int i = paramdyr.TVM;
    int j = paramdyr.Uer.UeB;
    if (paramdyr.Uer.UeD == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramdyr.Uer.UeD.size()))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramdyr.Uet), paramdyr.Ueu, paramdyr.Uer.Url, paramdyr.Uer.UeE });
      if (paramdyr.Uer.UeD == null) {
        break;
      }
      localObject = paramdyr.Uer.UeD.iterator();
      while (((Iterator)localObject).hasNext())
      {
        eik localeik = (eik)((Iterator)localObject).next();
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localeik.rWt), localeik.Uks.Ap() });
      }
    }
    j.TU(paramdyr.Uet);
    if (!paramBoolean) {
      j.F(paramdyr.Uet, 1L);
    }
    if ((paramdyr.Scv != 0) && (paramdyr.Scv <= Util.nowSecond()))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramdyr.Scv), Integer.valueOf(paramdyr.Uer.UeB) });
      j.F(paramdyr.Uet, 14L);
      j.F(paramdyr.Uet, 44L);
      j.a(paramInt, paramdyr.TVM, paramdyr.Uer.Url, paramdyr.Uer.UeB, j.a.QZY, false, paramBoolean, false, paramdyr.Ueu);
      AppMethodBeat.o(151939);
      return;
    }
    if ((Util.isNullOrNil(paramdyr.Uer.Url)) && (paramdyr.Uer.UeE == null))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      AppMethodBeat.o(151939);
      return;
    }
    localObject = new g.a(paramdyr.Uer.Url);
    ((g.a)localObject).bqw(str);
    ((g.a)localObject).fxC = paramInt;
    ((g.a)localObject).subType = paramdyr.TVM;
    ((g.a)localObject).TV(paramdyr.Scv);
    ((g.a)localObject).fxD = paramdyr.Uer.UeB;
    ((g.a)localObject).bqx(paramdyr.Uer.MD5);
    ((g.a)localObject).QZB = i.a.apR(paramdyr.Uer.UeC);
    ((g.a)localObject).QZC = i.a.apQ(paramdyr.Uer.UeC);
    ((g.a)localObject).PvW = paramdyr.Uet;
    ((g.a)localObject).QZb = paramdyr.Ueu;
    if (paramdyr.Uev > 0) {}
    for (paramInt = paramdyr.Uev;; paramInt = 3)
    {
      ((g.a)localObject).apY(paramInt);
      ((g.a)localObject).QZD = paramdyr.QZD;
      ((g.a)localObject).apX(paramdyr.Uew);
      ((g.a)localObject).fxI = paramBoolean;
      if (!Util.isNullOrNil(paramdyr.Uer.UeD)) {
        ((g.a)localObject).QYZ = ((eik)paramdyr.Uer.UeD.get(0)).Uks.UH;
      }
      if ((paramdyr.Ues != null) && (!Util.isNullOrNil(paramdyr.Ues.UeA)))
      {
        ((g.a)localObject).QYX = paramdyr.Ues.UeA;
        ((g.a)localObject).QYY = paramdyr.Ues.Uez;
      }
      if ((paramdyr.Uer.UeE != null) && (paramdyr.Uer.UeE.UH.length > 0)) {
        ((g.a)localObject).QZA = paramdyr.Uer.UeE.toByteArray();
      }
      ((g.a)localObject).fxF = paramdyr.Uer.UeF;
      ((g.a)localObject).fileSize = paramdyr.Uer.HlG;
      ((g.a)localObject).apZ(paramdyr.TrM);
      paramdyr = ((g.a)localObject).hiq();
      Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramdyr.toString() });
      p.a.hiK().am(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151916);
          r localr1 = p.a.hiK().bqC(str);
          g localg = paramdyr;
          if (localr1 == null) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null, urlKey = %s", new Object[] { localg.QYU });
          }
          while ((localr1 != null) && (localr1.field_deleted) && (localg.bqt(localr1.field_fileVersion) <= 0))
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { localr1.field_fileVersion, localg.Ran });
            AppMethodBeat.o(151916);
            return;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { localr1.field_urlKey, localr1.field_url, Long.valueOf(localr1.field_contentLength), Boolean.valueOf(localr1.field_deleted), localr1.field_eccSignature, Long.valueOf(localr1.field_expireTime), Boolean.valueOf(localr1.field_fileCompress), Boolean.valueOf(localr1.field_fileEncrypt), localr1.field_filePath, Boolean.valueOf(localr1.field_fileUpdated), localr1.field_fileVersion, localr1.field_groupId2, Integer.valueOf(localr1.field_keyVersion), Boolean.valueOf(Util.isNullOrNil(localr1.field_encryptKey)), Integer.valueOf(localr1.field_maxRetryTimes), Integer.valueOf(localr1.field_retryTimes), localr1.field_sampleId, Integer.valueOf(localr1.field_status) });
            Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { localr1.field_encryptKey });
          }
          if (localr1 == null)
          {
            localr1 = localg.hip();
            localr1.field_fileUpdated = true;
            localr1.field_needRetry = true;
            if (Util.isNullOrNil(localr1.field_encryptKey)) {
              localr1.field_keyVersion = -1;
            }
            Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(localr1)));
            p.a.hiK().h(localr1);
            b.hii().h(localg.fxC, localg.subType, 0, localg.fxI);
            f.a.a(true, true, localr1, localg);
            AppMethodBeat.o(151916);
            return;
          }
          Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
          localr1.field_networkType = localg.networkType;
          if (Util.isNullOrNil(localr1.field_originalMd5)) {
            localr1.field_originalMd5 = localg.fxF;
          }
          if (localg.bqt(localr1.field_fileVersion) > 0)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
            r localr2 = localg.hip();
            if (localr1.field_keyVersion >= localg.QYY)
            {
              localr2.field_keyVersion = localr1.field_keyVersion;
              localr2.field_encryptKey = localr1.field_encryptKey;
            }
            localr2.field_fileUpdated = true;
            localr2.field_needRetry = true;
            localr2.field_deleted = false;
            p.a.hiK().h(localr2);
            b.hii().h(localg.fxC, localg.subType, 0, localg.fxI);
            p.a.hiK().agN(localg.QYU);
            f.a.a(false, true, localr2, localg);
            AppMethodBeat.o(151916);
            return;
          }
          if ((localg.bqt(localr1.field_fileVersion) == 0) && (!localr1.field_needRetry))
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(localr1.field_resType), Integer.valueOf(localr1.field_subType), localr1.field_fileVersion });
            AppMethodBeat.o(151916);
            return;
          }
          if ((localr1.field_status == 2) || (localr1.field_status == 1) || (localr1.field_status == 0))
          {
            long l = com.tencent.mm.pluginsdk.k.a.d.a.ij(localr1.field_filePath);
            if (localr1.field_contentLength > l)
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(localr1.field_contentLength), Long.valueOf(l) });
              if (0L == l)
              {
                b.hii().h(localg.fxC, localg.subType, 0, localg.fxI);
                f.a.a(false, true, localr1, localg);
                AppMethodBeat.o(151916);
                return;
              }
              f.a.a(true, false, localr1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            if (!Util.nullAsNil(u.buc(i.alY(localg.QYU))).equals(localr1.field_md5))
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
              f.a.a(false, true, localr1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { localr1.field_urlKey });
            localr1.field_status = 2;
            localr1.field_contentLength = com.tencent.mm.pluginsdk.k.a.d.a.ij(localr1.field_filePath);
            localr1.field_fileUpdated = false;
            localr1.field_reportId = localg.PvW;
            p.a.hiK().h(localr1);
            j.F(localr1.field_reportId, 13L);
            j.F(localr1.field_reportId, 44L);
            j.a(localr1.field_resType, localr1.field_subType, localr1.field_url, Util.getInt(localr1.field_fileVersion, 0), j.a.QZX, true, "NewXml".equalsIgnoreCase(localr1.field_groupId2), true, localr1.field_sampleId);
            if ((!localg.QZB) && (!localg.QZC))
            {
              b.hii().b(localg.fxC, localg.subType, i.alY(localg.QYU), Util.getInt(localg.Ran, 0), localg.fxF);
              AppMethodBeat.o(151916);
              return;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { localg.QYU });
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
    k localk = this.QZf;
    if (localk.bqz(paramr.field_urlKey))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      AppMethodBeat.o(151936);
      return;
    }
    localk.a(a.a(paramr));
    AppMethodBeat.o(151936);
  }
  
  public final void g(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151929);
    p.a.hiK().am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151910);
        r localr = p.a.hiK().bqC(i.lW(paramInt1, paramInt2));
        if ((localr != null) && ((-1 == paramInt3) || (String.valueOf(paramInt3).equals(localr.field_fileVersion)))) {
          if (paramBoolean) {
            break label79;
          }
        }
        label79:
        for (boolean bool = true;; bool = false)
        {
          localr.field_needRetry = bool;
          p.a.hiK().h(localr);
          AppMethodBeat.o(151910);
          return;
        }
      }
    });
    AppMethodBeat.o(151929);
  }
  
  final void h(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151942);
    if (p.a.hiK().handler == null)
    {
      Log.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      AppMethodBeat.o(151942);
      return;
    }
    p.a.hiK().handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151911);
        bw localbw = new bw();
        localbw.fxJ.fvK = paramInt3;
        localbw.fxJ.fxC = paramInt1;
        localbw.fxJ.subType = paramInt2;
        localbw.fxJ.fxI = paramBoolean;
        EventCenter.instance.publish(localbw);
        AppMethodBeat.o(151911);
      }
    });
    AppMethodBeat.o(151942);
  }
  
  final Set<b> hih()
  {
    AppMethodBeat.i(151928);
    synchronized (this.QZe)
    {
      Set localSet2 = Collections.newSetFromMap(new androidx.b.a(this.QZe.size()));
      localSet2.addAll(this.QZe);
      AppMethodBeat.o(151928);
      return localSet2;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean him();
  }
  
  static final class c
  {
    private static final b QZz;
    
    static
    {
      AppMethodBeat.i(151927);
      QZz = new b((byte)0);
      AppMethodBeat.o(151927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */