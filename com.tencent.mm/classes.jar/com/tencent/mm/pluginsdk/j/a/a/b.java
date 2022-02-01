package com.tencent.mm.pluginsdk.j.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  private final Set<b> EPo;
  private final k EPp;
  private final com.tencent.mm.pluginsdk.j.a.c.d EPq;
  
  private b()
  {
    AppMethodBeat.i(151932);
    this.EPo = Collections.newSetFromMap(new android.support.v4.e.a(i.EPQ.length));
    this.EPp = new k();
    this.EPq = new com.tencent.mm.pluginsdk.j.a.c.d()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.pluginsdk.j.a.c.m paramAnonymousm)
      {
        AppMethodBeat.i(151913);
        i.aMa(paramAnonymousString);
        paramAnonymousString = q.a.fbc().aMi(paramAnonymousString);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(151913);
          return;
        }
        int j = 1;
        int i = j;
        if (paramAnonymousm != null)
        {
          i = j;
          if (paramAnonymousm.EQN != null)
          {
            if (!(paramAnonymousm.EQN instanceof com.tencent.mm.pluginsdk.j.a.b.a)) {
              break label141;
            }
            j.A(paramAnonymousString.field_reportId, 7L);
            i = 0;
          }
        }
        for (;;)
        {
          if (i != 0) {
            j.A(paramAnonymousString.field_reportId, 11L);
          }
          j.A(paramAnonymousString.field_reportId, 44L);
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, bt.getInt(paramAnonymousString.field_fileVersion, 0), j.a.EQd, false, "NewXml".equalsIgnoreCase(paramAnonymousString.field_groupId2), false, paramAnonymousString.field_sampleId);
          AppMethodBeat.o(151913);
          return;
          label141:
          i = j;
          if ((paramAnonymousm.EQN instanceof com.tencent.mm.pluginsdk.j.a.b.c))
          {
            j.A(paramAnonymousString.field_reportId, 16L);
            i = 0;
          }
        }
      }
      
      public final void aLX(final String paramAnonymousString)
      {
        AppMethodBeat.i(151912);
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(paramAnonymousString)));
        s locals = q.a.fbc().aMi(paramAnonymousString);
        if (locals == null)
        {
          AppMethodBeat.o(151912);
          return;
        }
        j.A(locals.field_reportId, 10L);
        j.A(locals.field_reportId, 15L);
        if (((!locals.field_fileCompress) || (locals.field_fileEncrypt)) && (locals.field_fileUpdated)) {
          if (locals.field_maxRetryTimes <= locals.field_retryTimes) {
            break label264;
          }
        }
        label264:
        for (paramAnonymousString = j.a.EQe;; paramAnonymousString = j.a.EQc)
        {
          j.a(locals.field_resType, locals.field_subType, locals.field_url, bt.getInt(locals.field_fileVersion, 0), paramAnonymousString, true, bt.nullAsNil(locals.field_groupId2).equals("NewXml"), false, locals.field_sampleId);
          if ((locals.field_fileCompress) || (locals.field_fileEncrypt)) {
            break;
          }
          paramAnonymousString = new bn();
          paramAnonymousString.dmw.filePath = locals.field_filePath;
          paramAnonymousString.dmw.dmA = locals.field_originalMd5;
          paramAnonymousString.dmw.dmz = locals.field_fileUpdated;
          paramAnonymousString.dmw.dmy = bt.getInt(locals.field_fileVersion, 0);
          paramAnonymousString.dmw.dmx = locals.field_resType;
          paramAnonymousString.dmw.subType = locals.field_subType;
          q.a.fbc().handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195425);
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
              AppMethodBeat.o(195425);
            }
          });
          locals.field_fileUpdated = false;
          q.a.fbc().h(locals);
          AppMethodBeat.o(151912);
          return;
        }
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
        b.this.b(locals);
        AppMethodBeat.o(151912);
      }
      
      public final void aLY(String paramAnonymousString)
      {
        AppMethodBeat.i(151914);
        com.tencent.mm.pluginsdk.j.a.c.q localq = q.a.fbc();
        if (localq.kld) {}
        for (boolean bool = localq.EQX.aMe(paramAnonymousString);; bool = false)
        {
          if (!bool) {
            i.aMa(paramAnonymousString);
          }
          AppMethodBeat.o(151914);
          return;
        }
      }
      
      public final String afw()
      {
        return "CheckResUpdate";
      }
    };
    Object localObject1 = q.a.fbc();
    com.tencent.mm.pluginsdk.j.a.c.d locald = this.EPq;
    ad.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { "CheckResUpdate", locald });
    if (((com.tencent.mm.pluginsdk.j.a.c.q)localObject1).kld)
    {
      com.tencent.mm.pluginsdk.j.a.c.i locali = ((com.tencent.mm.pluginsdk.j.a.c.q)localObject1).EQY;
      ad.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(locald)));
      if (locald != null)
      {
        int i = "CheckResUpdate".hashCode();
        synchronized (locali.EQD)
        {
          List localList = (List)locali.EQC.get(i);
          localObject1 = localList;
          if (localList == null) {
            localObject1 = new LinkedList();
          }
          ((List)localObject1).add(locald);
          locali.EQC.put(i, localObject1);
          AppMethodBeat.o(151932);
          return;
        }
      }
    }
    AppMethodBeat.o(151932);
  }
  
  public static void Yx(int paramInt)
  {
    AppMethodBeat.i(151933);
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.ajA();
    boolean bool1 = com.tencent.mm.kernel.a.aiJ();
    boolean bool2 = az.hFS.ax("login_user_name", "").equals("");
    if ((!bool1) && (bool2))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
      AppMethodBeat.o(151933);
      return;
    }
    m localm = new m(paramInt);
    com.tencent.mm.kernel.g.ajB().gAO.a(localm, 0);
    AppMethodBeat.o(151933);
  }
  
  static void c(s params)
  {
    AppMethodBeat.i(151937);
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { params.field_urlKey });
    k.g(params);
    AppMethodBeat.o(151937);
  }
  
  public static b faE()
  {
    AppMethodBeat.i(169213);
    if (!aj.cmR()) {
      Assert.fail("Inaccessible in child process.");
    }
    b localb = c.faJ();
    AppMethodBeat.o(169213);
    return localb;
  }
  
  public static String faF()
  {
    AppMethodBeat.i(151935);
    Object localObject = q.a.fbc().aMi(i.jn(60, 3));
    if (localObject == null)
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getOriginalMd5, %d.%d, get null info, return", new Object[] { Integer.valueOf(60), Integer.valueOf(3) });
      AppMethodBeat.o(151935);
      return null;
    }
    localObject = ((s)localObject).field_originalMd5;
    AppMethodBeat.o(151935);
    return localObject;
  }
  
  public static String jm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151934);
    s locals = q.a.fbc().aMi(i.jn(paramInt1, paramInt2));
    if (locals == null)
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    ad.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[] { Boolean.valueOf(locals.field_deleted), locals.field_filePath, locals.field_md5, Boolean.valueOf(locals.field_fileCompress), Boolean.valueOf(locals.field_fileEncrypt), locals.field_originalMd5 });
    String str;
    if ((!locals.field_fileCompress) && (!locals.field_fileEncrypt))
    {
      if ((!locals.field_deleted) && (!bt.isNullOrNil(locals.field_filePath)) && (bt.nullAsNil(com.tencent.mm.vfs.i.aPK(locals.field_filePath)).equals(locals.field_md5)))
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locals.field_filePath });
        str = locals.field_filePath;
        AppMethodBeat.o(151934);
        return str;
      }
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    if (locals.field_fileCompress) {
      str = locals.field_filePath + ".decompressed";
    }
    for (;;)
    {
      if (bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151934);
        return null;
        if (locals.field_fileEncrypt) {
          str = locals.field_filePath + ".decrypted";
        }
      }
      else
      {
        if ((!bt.isNullOrNil(locals.field_originalMd5)) && (bt.nullAsNil(com.tencent.mm.vfs.i.aPK(str)).equals(locals.field_originalMd5)))
        {
          ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
          AppMethodBeat.o(151934);
          return str;
        }
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, needDecrypt(%b) needDecompress(%b), file invalid, return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(locals.field_fileEncrypt), Boolean.valueOf(locals.field_fileCompress) });
        AppMethodBeat.o(151934);
        return null;
      }
      str = null;
    }
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(151941);
    q.a.fbc().af(new Runnable()
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
        Object localObject = i.jn(i, j);
        localObject = q.a.fbc().aMi((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(151918);
          return;
        }
        boolean bool = ((s)localObject).field_fileUpdated;
        ((s)localObject).field_fileUpdated = false;
        q.a.fbc().h((s)localObject);
        if (k == bt.getInt(((s)localObject).field_fileVersion, 0))
        {
          if (q.a.fbc().handler == null)
          {
            ad.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            AppMethodBeat.o(151918);
            return;
          }
          q.a.fbc().handler.post(new b.8(localb, i, j, str1, k, bool, str2));
        }
        AppMethodBeat.o(151918);
      }
    });
    AppMethodBeat.o(151941);
  }
  
  final void a(final int paramInt, final cvi paramcvi, final boolean paramBoolean)
  {
    AppMethodBeat.i(151938);
    final String str = i.jn(paramInt, paramcvi.HfH);
    if (paramcvi.HnA == null)
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      AppMethodBeat.o(151938);
      return;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramcvi.HfH), Integer.valueOf(paramcvi.HnA.HnK) });
    j.A(paramcvi.HnC, 3L);
    final int i = paramcvi.HnA.HnK;
    final int j = paramcvi.HfH;
    final int k = paramcvi.HnC;
    paramcvi = paramcvi.HnD;
    q.a.fbc().af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151915);
        s locals = q.a.fbc().aMi(str);
        int i = paramInt;
        int j = j;
        int k = i;
        int m = k;
        String str1 = paramcvi;
        boolean bool2 = paramBoolean;
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(locals)));
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
        boolean bool1 = false;
        String str2;
        if (locals != null) {
          if (bt.getInt(locals.field_fileVersion, 0) <= k)
          {
            bool1 = true;
            str2 = i.jn(i, j);
            String str3 = i.TH(str2);
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
            if (!bool1) {
              break label443;
            }
            q.a.fbc().Pd(str2);
            b.faE().g(i, j, 2, bool2);
            if (!(com.tencent.mm.pluginsdk.j.a.d.a.aMl(str3) & true & com.tencent.mm.pluginsdk.j.a.d.a.aMl(str3 + ".decompressed") & com.tencent.mm.pluginsdk.j.a.d.a.aMl(str3 + ".decrypted"))) {
              break label390;
            }
            if (locals != null)
            {
              j.A(locals.field_reportId, 21L);
              j.a(locals.field_resType, locals.field_subType, k, bool2, locals.field_sampleId);
            }
          }
        }
        for (;;)
        {
          if (locals != null) {
            break label420;
          }
          locals = new s();
          locals.field_urlKey = str2;
          locals.field_resType = i;
          locals.field_subType = j;
          locals.field_deleted = true;
          locals.field_fileVersion = String.valueOf(k);
          locals.field_reportId = m;
          locals.field_sampleId = str1;
          q.a.fbc().h(locals);
          AppMethodBeat.o(151915);
          return;
          j.A(locals.field_reportId, 47L);
          j.A(locals.field_reportId, 22L);
          break;
          j.A(m, 47L);
          j.A(m, 22L);
          bool1 = true;
          break;
          label390:
          if (locals != null)
          {
            j.A(locals.field_reportId, 22L);
            j.A(locals.field_reportId, 47L);
          }
        }
        label420:
        locals.field_deleted = true;
        locals.field_fileVersion = String.valueOf(k);
        q.a.fbc().h(locals);
        label443:
        AppMethodBeat.o(151915);
      }
    });
    AppMethodBeat.o(151938);
  }
  
  final void a(int paramInt, cvi paramcvi, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151940);
    final String str = i.jn(paramInt, paramcvi.HfH);
    if ((paramcvi.HnB == null) || (bt.isNullOrNil(paramcvi.HnB.HnJ)))
    {
      ad.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key invalid, resource=%d.%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramcvi.HfH) });
      AppMethodBeat.o(151940);
      return;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(paramcvi.HfH), Integer.valueOf(paramcvi.HnB.HnI) });
    ad.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramcvi.HnB.HnJ });
    j.A(paramcvi.HnC, 4L);
    paramcvi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151917);
        s locals = q.a.fbc().aMi(str);
        String str1 = this.EPy;
        String str2 = this.EPz;
        int i = this.EPA;
        int j = this.jKc;
        String str3 = this.EPw;
        boolean bool = paramBoolean2;
        if (locals == null)
        {
          locals = new s();
          locals.field_keyVersion = i;
          locals.field_encryptKey = str2;
          locals.field_reportId = j;
          locals.field_sampleId = str3;
          locals.field_originalMd5 = str1;
          q.a.fbc().h(locals);
          j.A(j, 51L);
          j.A(j, 45L);
          AppMethodBeat.o(151917);
          return;
        }
        if (locals.field_keyVersion < i)
        {
          locals.field_keyVersion = i;
          locals.field_encryptKey = str2;
          locals.field_reportId = j;
          locals.field_sampleId = str3;
          if (bt.isNullOrNil(locals.field_originalMd5)) {
            locals.field_originalMd5 = str1;
          }
          q.a.fbc().h(locals);
          f.b.a(locals, true, bool);
          AppMethodBeat.o(151917);
          return;
        }
        if ((bool) && (locals.field_keyVersion == i)) {
          f.b.a(locals, true, true);
        }
        AppMethodBeat.o(151917);
      }
    };
    if (paramBoolean2)
    {
      paramcvi.run();
      AppMethodBeat.o(151940);
      return;
    }
    q.a.fbc().af(paramcvi);
    AppMethodBeat.o(151940);
  }
  
  public final void aG(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151930);
    f(paramInt1, paramInt2, paramInt3, true);
    AppMethodBeat.o(151930);
  }
  
  final void b(int paramInt, final cvi paramcvi, boolean paramBoolean)
  {
    AppMethodBeat.i(151939);
    final String str = i.jn(paramInt, paramcvi.HfH);
    if (paramcvi.HnA == null)
    {
      ad.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      AppMethodBeat.o(151939);
      return;
    }
    int i = paramcvi.HfH;
    int j = paramcvi.HnA.HnK;
    if (paramcvi.HnA.HnM == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramcvi.HnA.HnM.size()))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramcvi.HnC), paramcvi.HnD, paramcvi.HnA.Url, paramcvi.HnA.Gdx });
      if (paramcvi.HnA.HnM == null) {
        break;
      }
      localObject = paramcvi.HnA.HnM.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dek localdek = (dek)((Iterator)localObject).next();
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localdek.Version), localdek.HsN.ffY() });
      }
    }
    j.CD(paramcvi.HnC);
    if (!paramBoolean) {
      j.A(paramcvi.HnC, 1L);
    }
    if ((paramcvi.FOh != 0) && (paramcvi.FOh <= bt.aQJ()))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramcvi.FOh), Integer.valueOf(paramcvi.HnA.HnK) });
      j.A(paramcvi.HnC, 14L);
      j.A(paramcvi.HnC, 44L);
      j.a(paramInt, paramcvi.HfH, paramcvi.HnA.Url, paramcvi.HnA.HnK, j.a.EQg, false, paramBoolean, false, paramcvi.HnD);
      AppMethodBeat.o(151939);
      return;
    }
    if ((bt.isNullOrNil(paramcvi.HnA.Url)) && (paramcvi.HnA.Gdx == null))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      AppMethodBeat.o(151939);
      return;
    }
    localObject = new g.a(paramcvi.HnA.Url);
    ((g.a)localObject).aMc(str);
    ((g.a)localObject).dmx = paramInt;
    ((g.a)localObject).subType = paramcvi.HfH;
    ((g.a)localObject).CE(paramcvi.FOh);
    ((g.a)localObject).dmy = paramcvi.HnA.HnK;
    ((g.a)localObject).aMd(paramcvi.HnA.MD5);
    ((g.a)localObject).EPK = i.a.Yz(paramcvi.HnA.HnL);
    ((g.a)localObject).EPL = i.a.Yy(paramcvi.HnA.HnL);
    ((g.a)localObject).DAq = paramcvi.HnC;
    ((g.a)localObject).EPl = paramcvi.HnD;
    if (paramcvi.HnE > 0) {}
    for (paramInt = paramcvi.HnE;; paramInt = 3)
    {
      ((g.a)localObject).YG(paramInt);
      ((g.a)localObject).EPM = paramcvi.EPM;
      ((g.a)localObject).YF(paramcvi.HnF);
      ((g.a)localObject).dmD = paramBoolean;
      if (!bt.hj(paramcvi.HnA.HnM)) {
        ((g.a)localObject).EPj = ((dek)paramcvi.HnA.HnM.get(0)).HsN.zr;
      }
      if ((paramcvi.HnB != null) && (!bt.isNullOrNil(paramcvi.HnB.HnJ)))
      {
        ((g.a)localObject).EPh = paramcvi.HnB.HnJ;
        ((g.a)localObject).EPi = paramcvi.HnB.HnI;
      }
      if ((paramcvi.HnA.Gdx != null) && (paramcvi.HnA.Gdx.zr.length > 0)) {
        ((g.a)localObject).EPJ = paramcvi.HnA.Gdx.toByteArray();
      }
      ((g.a)localObject).dmA = paramcvi.HnA.HnN;
      ((g.a)localObject).fileSize = paramcvi.HnA.FileSize;
      ((g.a)localObject).YH(paramcvi.GJv);
      paramcvi = ((g.a)localObject).faM();
      ad.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramcvi.toString() });
      q.a.fbc().af(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151916);
          s locals1 = q.a.fbc().aMi(str);
          g localg = paramcvi;
          if (locals1 == null) {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null, urlKey = %s", new Object[] { localg.EPe });
          }
          while ((locals1 != null) && (locals1.field_deleted) && (localg.aLZ(locals1.field_fileVersion) <= 0))
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { locals1.field_fileVersion, localg.EQv });
            AppMethodBeat.o(151916);
            return;
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { locals1.field_urlKey, locals1.field_url, Long.valueOf(locals1.field_contentLength), Boolean.valueOf(locals1.field_deleted), locals1.field_eccSignature, Long.valueOf(locals1.field_expireTime), Boolean.valueOf(locals1.field_fileCompress), Boolean.valueOf(locals1.field_fileEncrypt), locals1.field_filePath, Boolean.valueOf(locals1.field_fileUpdated), locals1.field_fileVersion, locals1.field_groupId2, Integer.valueOf(locals1.field_keyVersion), Boolean.valueOf(bt.isNullOrNil(locals1.field_encryptKey)), Integer.valueOf(locals1.field_maxRetryTimes), Integer.valueOf(locals1.field_retryTimes), locals1.field_sampleId, Integer.valueOf(locals1.field_status) });
            ad.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { locals1.field_encryptKey });
          }
          if (locals1 == null)
          {
            locals1 = localg.faL();
            locals1.field_fileUpdated = true;
            locals1.field_needRetry = true;
            if (bt.isNullOrNil(locals1.field_encryptKey)) {
              locals1.field_keyVersion = -1;
            }
            ad.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(locals1)));
            q.a.fbc().h(locals1);
            b.faE().g(localg.dmx, localg.subType, 0, localg.dmD);
            f.a.a(true, true, locals1, localg);
            AppMethodBeat.o(151916);
            return;
          }
          ad.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
          locals1.field_networkType = localg.networkType;
          if (bt.isNullOrNil(locals1.field_originalMd5)) {
            locals1.field_originalMd5 = localg.dmA;
          }
          if (localg.aLZ(locals1.field_fileVersion) > 0)
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
            s locals2 = localg.faL();
            if (locals1.field_keyVersion >= localg.EPi)
            {
              locals2.field_keyVersion = locals1.field_keyVersion;
              locals2.field_encryptKey = locals1.field_encryptKey;
            }
            locals2.field_fileUpdated = true;
            locals2.field_needRetry = true;
            locals2.field_deleted = false;
            q.a.fbc().h(locals2);
            b.faE().g(localg.dmx, localg.subType, 0, localg.dmD);
            q.a.fbc().Pd(localg.EPe);
            f.a.a(false, true, locals2, localg);
            AppMethodBeat.o(151916);
            return;
          }
          if ((localg.aLZ(locals1.field_fileVersion) == 0) && (!locals1.field_needRetry))
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(locals1.field_resType), Integer.valueOf(locals1.field_subType), locals1.field_fileVersion });
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 2) || (locals1.field_status == 1) || (locals1.field_status == 0))
          {
            long l = com.tencent.mm.pluginsdk.j.a.d.a.gy(locals1.field_filePath);
            if (locals1.field_contentLength > l)
            {
              ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(locals1.field_contentLength), Long.valueOf(l) });
              if (0L == l)
              {
                b.faE().g(localg.dmx, localg.subType, 0, localg.dmD);
                f.a.a(false, true, locals1, localg);
                AppMethodBeat.o(151916);
                return;
              }
              f.a.a(true, false, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            if (!bt.nullAsNil(com.tencent.mm.vfs.i.aPK(i.TH(localg.EPe))).equals(locals1.field_md5))
            {
              ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
              f.a.a(false, true, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { locals1.field_urlKey });
            locals1.field_status = 2;
            locals1.field_contentLength = com.tencent.mm.pluginsdk.j.a.d.a.gy(locals1.field_filePath);
            locals1.field_fileUpdated = false;
            locals1.field_reportId = localg.DAq;
            q.a.fbc().h(locals1);
            j.A(locals1.field_reportId, 13L);
            j.A(locals1.field_reportId, 44L);
            j.a(locals1.field_resType, locals1.field_subType, locals1.field_url, bt.getInt(locals1.field_fileVersion, 0), j.a.EQf, true, "NewXml".equalsIgnoreCase(locals1.field_groupId2), true, locals1.field_sampleId);
            if ((!localg.EPK) && (!localg.EPL))
            {
              b.faE().a(localg.dmx, localg.subType, i.TH(localg.EPe), bt.getInt(localg.EQv, 0), localg.dmA);
              AppMethodBeat.o(151916);
              return;
            }
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { localg.EPe });
            f.b.a(locals1, false, false);
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 4) || (locals1.field_status == 3))
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", new Object[] { locals1.field_urlKey });
            f.a.a(false, true, locals1, localg);
          }
          AppMethodBeat.o(151916);
        }
      });
      AppMethodBeat.o(151939);
      return;
    }
  }
  
  final void b(s params)
  {
    AppMethodBeat.i(151936);
    ad.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + params.field_urlKey);
    k localk = this.EPp;
    if (localk.aMf(params.field_urlKey))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      AppMethodBeat.o(151936);
      return;
    }
    localk.a(a.a(params));
    AppMethodBeat.o(151936);
  }
  
  public final void f(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151929);
    q.a.fbc().af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151910);
        s locals = q.a.fbc().aMi(i.jn(paramInt1, paramInt2));
        if ((locals != null) && ((-1 == paramInt3) || (String.valueOf(paramInt3).equals(locals.field_fileVersion)))) {
          if (paramBoolean) {
            break label79;
          }
        }
        label79:
        for (boolean bool = true;; bool = false)
        {
          locals.field_needRetry = bool;
          q.a.fbc().h(locals);
          AppMethodBeat.o(151910);
          return;
        }
      }
    });
    AppMethodBeat.o(151929);
  }
  
  final Set<b> faD()
  {
    AppMethodBeat.i(151928);
    synchronized (this.EPo)
    {
      Set localSet2 = Collections.newSetFromMap(new android.support.v4.e.a(this.EPo.size()));
      localSet2.addAll(this.EPo);
      AppMethodBeat.o(151928);
      return localSet2;
    }
  }
  
  final void g(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151942);
    if (q.a.fbc().handler == null)
    {
      ad.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      AppMethodBeat.o(151942);
      return;
    }
    q.a.fbc().handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151911);
        bp localbp = new bp();
        localbp.dmE.dkM = paramInt3;
        localbp.dmE.dmx = paramInt1;
        localbp.dmE.subType = paramInt2;
        localbp.dmE.dmD = paramBoolean;
        com.tencent.mm.sdk.b.a.IbL.l(localbp);
        AppMethodBeat.o(151911);
      }
    });
    AppMethodBeat.o(151942);
  }
  
  public static final class a
    implements com.tencent.mm.pluginsdk.j.a.c.g
  {
    private final com.tencent.mm.sdk.b.c EPE;
    private final cd.a EPF;
    private final h EPG;
    
    public a()
    {
      AppMethodBeat.i(151923);
      this.EPE = new com.tencent.mm.sdk.b.c() {};
      this.EPF = new cd.a()
      {
        public final void a(e.a paramAnonymousa)
        {
          AppMethodBeat.i(151921);
          paramAnonymousa = z.a(paramAnonymousa.gqE.Fvk);
          if (bt.isNullOrNil(paramAnonymousa))
          {
            ad.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
            AppMethodBeat.o(151921);
            return;
          }
          ad.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(paramAnonymousa)));
          Map localMap;
          if (!bt.isNullOrNil(paramAnonymousa))
          {
            localMap = bw.M(paramAnonymousa, "sysmsg");
            j.A(0L, 0L);
            if (localMap != null) {
              break label167;
            }
            paramAnonymousa = "null";
            ad.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { paramAnonymousa });
            if (localMap != null) {
              break label180;
            }
            j.A(0L, 30L);
          }
          for (;;)
          {
            if ((localMap != null) && (localMap.size() > 0) && (bt.nullAsNil((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")))
            {
              e.k(".sysmsg", "delete", localMap);
              e.k(".sysmsg", "cache", localMap);
              e.k(".sysmsg", "decrypt", localMap);
            }
            AppMethodBeat.o(151921);
            return;
            label167:
            paramAnonymousa = String.valueOf(localMap.size());
            break;
            label180:
            j.A(0L, 31L);
          }
        }
        
        public final void a(e.c paramAnonymousc) {}
      };
      this.EPG = new h();
      AppMethodBeat.o(151923);
    }
    
    public final String afw()
    {
      return "CheckResUpdate";
    }
    
    public final n.a c(l paraml)
    {
      AppMethodBeat.i(151926);
      if (!(paraml instanceof c))
      {
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
        AppMethodBeat.o(151926);
        return null;
      }
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
      paraml = new d((c)paraml);
      AppMethodBeat.o(151926);
      return paraml;
    }
    
    public final void faG()
    {
      AppMethodBeat.i(151924);
      com.tencent.mm.sdk.b.a.IbL.c(this.EPE);
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("resourcemgr", this.EPF, true);
      com.tencent.mm.kernel.g.ajF().n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151922);
          p.bMa();
          AppMethodBeat.o(151922);
        }
      }, 10000L);
      AppMethodBeat.o(151924);
    }
    
    public final com.tencent.mm.pluginsdk.j.a.c.h faH()
    {
      return this.EPG;
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(151925);
      com.tencent.mm.sdk.b.a.IbL.d(this.EPE);
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("resourcemgr", this.EPF, true);
      AppMethodBeat.o(151925);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean faI();
  }
  
  static final class c
  {
    private static final b EPI;
    
    static
    {
      AppMethodBeat.i(151927);
      EPI = new b((byte)0);
      AppMethodBeat.o(151927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.b
 * JD-Core Version:    0.7.0.1
 */