package com.tencent.mm.pluginsdk.h.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.model.ay;
import com.tencent.mm.pluginsdk.h.a.b.c;
import com.tencent.mm.pluginsdk.h.a.c.d;
import com.tencent.mm.pluginsdk.h.a.c.n;
import com.tencent.mm.pluginsdk.h.a.c.q.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  private final Set<b> BRW;
  private final k BRX;
  private final d BRY;
  
  private b()
  {
    AppMethodBeat.i(151932);
    this.BRW = Collections.newSetFromMap(new android.support.v4.e.a(i.BSy.length));
    this.BRX = new k();
    this.BRY = new d()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.pluginsdk.h.a.c.m paramAnonymousm)
      {
        AppMethodBeat.i(151913);
        i.aBi(paramAnonymousString);
        paramAnonymousString = q.a.ewL().aBq(paramAnonymousString);
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
          if (paramAnonymousm.BTv != null)
          {
            if (!(paramAnonymousm.BTv instanceof com.tencent.mm.pluginsdk.h.a.b.a)) {
              break label141;
            }
            j.D(paramAnonymousString.field_reportId, 7L);
            i = 0;
          }
        }
        for (;;)
        {
          if (i != 0) {
            j.D(paramAnonymousString.field_reportId, 11L);
          }
          j.D(paramAnonymousString.field_reportId, 44L);
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, bt.getInt(paramAnonymousString.field_fileVersion, 0), j.a.BSL, false, "NewXml".equalsIgnoreCase(paramAnonymousString.field_groupId2), false, paramAnonymousString.field_sampleId);
          AppMethodBeat.o(151913);
          return;
          label141:
          i = j;
          if ((paramAnonymousm.BTv instanceof c))
          {
            j.D(paramAnonymousString.field_reportId, 16L);
            i = 0;
          }
        }
      }
      
      public final void aBf(final String paramAnonymousString)
      {
        AppMethodBeat.i(151912);
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(paramAnonymousString)));
        s locals = q.a.ewL().aBq(paramAnonymousString);
        if (locals == null)
        {
          AppMethodBeat.o(151912);
          return;
        }
        j.D(locals.field_reportId, 10L);
        j.D(locals.field_reportId, 15L);
        if (((!locals.field_fileCompress) || (locals.field_fileEncrypt)) && (locals.field_fileUpdated)) {
          if (locals.field_maxRetryTimes <= locals.field_retryTimes) {
            break label264;
          }
        }
        label264:
        for (paramAnonymousString = j.a.BSM;; paramAnonymousString = j.a.BSK)
        {
          j.a(locals.field_resType, locals.field_subType, locals.field_url, bt.getInt(locals.field_fileVersion, 0), paramAnonymousString, true, bt.nullAsNil(locals.field_groupId2).equals("NewXml"), false, locals.field_sampleId);
          if ((locals.field_fileCompress) || (locals.field_fileEncrypt)) {
            break;
          }
          paramAnonymousString = new bk();
          paramAnonymousString.ddG.filePath = locals.field_filePath;
          paramAnonymousString.ddG.ddK = locals.field_originalMd5;
          paramAnonymousString.ddG.ddJ = locals.field_fileUpdated;
          paramAnonymousString.ddG.ddI = bt.getInt(locals.field_fileVersion, 0);
          paramAnonymousString.ddG.ddH = locals.field_resType;
          paramAnonymousString.ddG.subType = locals.field_subType;
          q.a.ewL().handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190779);
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
              AppMethodBeat.o(190779);
            }
          });
          locals.field_fileUpdated = false;
          q.a.ewL().h(locals);
          AppMethodBeat.o(151912);
          return;
        }
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
        b.this.b(locals);
        AppMethodBeat.o(151912);
      }
      
      public final void aBg(String paramAnonymousString)
      {
        AppMethodBeat.i(151914);
        com.tencent.mm.pluginsdk.h.a.c.q localq = q.a.ewL();
        if (localq.jqw) {}
        for (boolean bool = localq.BTF.aBm(paramAnonymousString);; bool = false)
        {
          if (!bool) {
            i.aBi(paramAnonymousString);
          }
          AppMethodBeat.o(151914);
          return;
        }
      }
      
      public final String asy()
      {
        return "CheckResUpdate";
      }
    };
    Object localObject1 = q.a.ewL();
    d locald = this.BRY;
    ad.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { "CheckResUpdate", locald });
    if (((com.tencent.mm.pluginsdk.h.a.c.q)localObject1).jqw)
    {
      com.tencent.mm.pluginsdk.h.a.c.i locali = ((com.tencent.mm.pluginsdk.h.a.c.q)localObject1).BTG;
      ad.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(locald)));
      if (locald != null)
      {
        int i = "CheckResUpdate".hashCode();
        synchronized (locali.BTl)
        {
          List localList = (List)locali.BTk.get(i);
          localObject1 = localList;
          if (localList == null) {
            localObject1 = new LinkedList();
          }
          ((List)localObject1).add(locald);
          locali.BTk.put(i, localObject1);
          AppMethodBeat.o(151932);
          return;
        }
      }
    }
    AppMethodBeat.o(151932);
  }
  
  public static void Ur(int paramInt)
  {
    AppMethodBeat.i(151933);
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.afz();
    boolean bool1 = com.tencent.mm.kernel.a.aeH();
    boolean bool2 = ay.gNa.ao("login_user_name", "").equals("");
    if ((!bool1) && (bool2))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
      AppMethodBeat.o(151933);
      return;
    }
    m localm = new m(paramInt);
    com.tencent.mm.kernel.g.afA().gcy.a(localm, 0);
    AppMethodBeat.o(151933);
  }
  
  static void c(s params)
  {
    AppMethodBeat.i(151937);
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { params.field_urlKey });
    k.g(params);
    AppMethodBeat.o(151937);
  }
  
  public static b ewn()
  {
    AppMethodBeat.i(169213);
    if (!aj.cbe()) {
      Assert.fail("Inaccessible in child process.");
    }
    b localb = c.ews();
    AppMethodBeat.o(169213);
    return localb;
  }
  
  public static String ewo()
  {
    AppMethodBeat.i(151935);
    Object localObject = q.a.ewL().aBq(i.iO(60, 3));
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
  
  public static String iN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151934);
    s locals = q.a.ewL().aBq(i.iO(paramInt1, paramInt2));
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
      if ((!locals.field_deleted) && (!bt.isNullOrNil(locals.field_filePath)) && (bt.nullAsNil(com.tencent.mm.vfs.i.aEN(locals.field_filePath)).equals(locals.field_md5)))
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
        if ((!bt.isNullOrNil(locals.field_originalMd5)) && (bt.nullAsNil(com.tencent.mm.vfs.i.aEN(str)).equals(locals.field_originalMd5)))
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
    q.a.ewL().ae(new Runnable()
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
        Object localObject = i.iO(i, j);
        localObject = q.a.ewL().aBq((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(151918);
          return;
        }
        boolean bool = ((s)localObject).field_fileUpdated;
        ((s)localObject).field_fileUpdated = false;
        q.a.ewL().h((s)localObject);
        if (k == bt.getInt(((s)localObject).field_fileVersion, 0))
        {
          if (q.a.ewL().handler == null)
          {
            ad.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            AppMethodBeat.o(151918);
            return;
          }
          q.a.ewL().handler.post(new b.8(localb, i, j, str1, k, bool, str2));
        }
        AppMethodBeat.o(151918);
      }
    });
    AppMethodBeat.o(151941);
  }
  
  final void a(final int paramInt, final ckw paramckw, final boolean paramBoolean)
  {
    AppMethodBeat.i(151938);
    final String str = i.iO(paramInt, paramckw.DYI);
    if (paramckw.Egn == null)
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      AppMethodBeat.o(151938);
      return;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramckw.DYI), Integer.valueOf(paramckw.Egn.Egx) });
    j.D(paramckw.Egp, 3L);
    final int i = paramckw.Egn.Egx;
    final int j = paramckw.DYI;
    final int k = paramckw.Egp;
    paramckw = paramckw.Egq;
    q.a.ewL().ae(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151915);
        s locals = q.a.ewL().aBq(str);
        int i = paramInt;
        int j = j;
        int k = i;
        int m = k;
        String str1 = paramckw;
        boolean bool2 = paramBoolean;
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(locals)));
        ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
        boolean bool1 = false;
        String str2;
        if (locals != null) {
          if (bt.getInt(locals.field_fileVersion, 0) <= k)
          {
            bool1 = true;
            str2 = i.iO(i, j);
            String str3 = i.LW(str2);
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
            if (!bool1) {
              break label443;
            }
            q.a.ewL().HF(str2);
            b.ewn().f(i, j, 2, bool2);
            if (!(com.tencent.mm.pluginsdk.h.a.d.a.aBt(str3) & true & com.tencent.mm.pluginsdk.h.a.d.a.aBt(str3 + ".decompressed") & com.tencent.mm.pluginsdk.h.a.d.a.aBt(str3 + ".decrypted"))) {
              break label390;
            }
            if (locals != null)
            {
              j.D(locals.field_reportId, 21L);
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
          q.a.ewL().h(locals);
          AppMethodBeat.o(151915);
          return;
          j.D(locals.field_reportId, 47L);
          j.D(locals.field_reportId, 22L);
          break;
          j.D(m, 47L);
          j.D(m, 22L);
          bool1 = true;
          break;
          label390:
          if (locals != null)
          {
            j.D(locals.field_reportId, 22L);
            j.D(locals.field_reportId, 47L);
          }
        }
        label420:
        locals.field_deleted = true;
        locals.field_fileVersion = String.valueOf(k);
        q.a.ewL().h(locals);
        label443:
        AppMethodBeat.o(151915);
      }
    });
    AppMethodBeat.o(151938);
  }
  
  final void a(int paramInt, ckw paramckw, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151940);
    final String str = i.iO(paramInt, paramckw.DYI);
    if ((paramckw.Ego == null) || (bt.isNullOrNil(paramckw.Ego.Egw)))
    {
      ad.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key invalid, resource=%d.%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramckw.DYI) });
      AppMethodBeat.o(151940);
      return;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(paramckw.DYI), Integer.valueOf(paramckw.Ego.Egv) });
    ad.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramckw.Ego.Egw });
    j.D(paramckw.Egp, 4L);
    paramckw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151917);
        s locals = q.a.ewL().aBq(str);
        String str1 = this.BSg;
        String str2 = this.BSh;
        int i = this.BSi;
        int j = this.iPY;
        String str3 = this.BSe;
        boolean bool = paramBoolean2;
        if (locals == null)
        {
          locals = new s();
          locals.field_keyVersion = i;
          locals.field_encryptKey = str2;
          locals.field_reportId = j;
          locals.field_sampleId = str3;
          locals.field_originalMd5 = str1;
          q.a.ewL().h(locals);
          j.D(j, 51L);
          j.D(j, 45L);
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
          q.a.ewL().h(locals);
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
      paramckw.run();
      AppMethodBeat.o(151940);
      return;
    }
    q.a.ewL().ae(paramckw);
    AppMethodBeat.o(151940);
  }
  
  public final void aD(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151930);
    e(paramInt1, paramInt2, paramInt3, true);
    AppMethodBeat.o(151930);
  }
  
  final void b(int paramInt, final ckw paramckw, boolean paramBoolean)
  {
    AppMethodBeat.i(151939);
    final String str = i.iO(paramInt, paramckw.DYI);
    if (paramckw.Egn == null)
    {
      ad.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      AppMethodBeat.o(151939);
      return;
    }
    int i = paramckw.DYI;
    int j = paramckw.Egn.Egx;
    if (paramckw.Egn.Egz == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramckw.Egn.Egz.size()))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramckw.Egp), paramckw.Egq, paramckw.Egn.Url, paramckw.Egn.DcU });
      if (paramckw.Egn.Egz == null) {
        break;
      }
      localObject = paramckw.Egn.Egz.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ctm localctm = (ctm)((Iterator)localObject).next();
        ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localctm.Version), localctm.Elh.eBA() });
      }
    }
    j.vm(paramckw.Egp);
    if (!paramBoolean) {
      j.D(paramckw.Egp, 1L);
    }
    if ((paramckw.COp != 0) && (paramckw.COp <= bt.aGK()))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramckw.COp), Integer.valueOf(paramckw.Egn.Egx) });
      j.D(paramckw.Egp, 14L);
      j.D(paramckw.Egp, 44L);
      j.a(paramInt, paramckw.DYI, paramckw.Egn.Url, paramckw.Egn.Egx, j.a.BSO, false, paramBoolean, false, paramckw.Egq);
      AppMethodBeat.o(151939);
      return;
    }
    if ((bt.isNullOrNil(paramckw.Egn.Url)) && (paramckw.Egn.DcU == null))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      AppMethodBeat.o(151939);
      return;
    }
    localObject = new g.a(paramckw.Egn.Url);
    ((g.a)localObject).aBk(str);
    ((g.a)localObject).ddH = paramInt;
    ((g.a)localObject).subType = paramckw.DYI;
    ((g.a)localObject).vn(paramckw.COp);
    ((g.a)localObject).ddI = paramckw.Egn.Egx;
    ((g.a)localObject).aBl(paramckw.Egn.MD5);
    ((g.a)localObject).BSs = i.a.Ut(paramckw.Egn.Egy);
    ((g.a)localObject).BSt = i.a.Us(paramckw.Egn.Egy);
    ((g.a)localObject).BRS = paramckw.Egp;
    ((g.a)localObject).BRT = paramckw.Egq;
    if (paramckw.Egr > 0) {}
    for (paramInt = paramckw.Egr;; paramInt = 3)
    {
      ((g.a)localObject).UA(paramInt);
      ((g.a)localObject).BSu = paramckw.BSu;
      ((g.a)localObject).Uz(paramckw.Egs);
      ((g.a)localObject).ddN = paramBoolean;
      if (!bt.gL(paramckw.Egn.Egz)) {
        ((g.a)localObject).BRQ = ((ctm)paramckw.Egn.Egz.get(0)).Elh.wA;
      }
      if ((paramckw.Ego != null) && (!bt.isNullOrNil(paramckw.Ego.Egw)))
      {
        ((g.a)localObject).BRO = paramckw.Ego.Egw;
        ((g.a)localObject).BRP = paramckw.Ego.Egv;
      }
      if ((paramckw.Egn.DcU != null) && (paramckw.Egn.DcU.wA.length > 0)) {
        ((g.a)localObject).BSr = paramckw.Egn.DcU.toByteArray();
      }
      ((g.a)localObject).ddK = paramckw.Egn.EgA;
      ((g.a)localObject).fileSize = paramckw.Egn.FileSize;
      ((g.a)localObject).UB(paramckw.DEB);
      paramckw = ((g.a)localObject).ewv();
      ad.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramckw.toString() });
      q.a.ewL().ae(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151916);
          s locals1 = q.a.ewL().aBq(str);
          g localg = paramckw;
          if (locals1 == null) {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null, urlKey = %s", new Object[] { localg.BRL });
          }
          while ((locals1 != null) && (locals1.field_deleted) && (localg.aBh(locals1.field_fileVersion) <= 0))
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { locals1.field_fileVersion, localg.BTd });
            AppMethodBeat.o(151916);
            return;
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { locals1.field_urlKey, locals1.field_url, Long.valueOf(locals1.field_contentLength), Boolean.valueOf(locals1.field_deleted), locals1.field_eccSignature, Long.valueOf(locals1.field_expireTime), Boolean.valueOf(locals1.field_fileCompress), Boolean.valueOf(locals1.field_fileEncrypt), locals1.field_filePath, Boolean.valueOf(locals1.field_fileUpdated), locals1.field_fileVersion, locals1.field_groupId2, Integer.valueOf(locals1.field_keyVersion), Boolean.valueOf(bt.isNullOrNil(locals1.field_encryptKey)), Integer.valueOf(locals1.field_maxRetryTimes), Integer.valueOf(locals1.field_retryTimes), locals1.field_sampleId, Integer.valueOf(locals1.field_status) });
            ad.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { locals1.field_encryptKey });
          }
          if (locals1 == null)
          {
            locals1 = localg.ewu();
            locals1.field_fileUpdated = true;
            locals1.field_needRetry = true;
            if (bt.isNullOrNil(locals1.field_encryptKey)) {
              locals1.field_keyVersion = -1;
            }
            ad.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(locals1)));
            q.a.ewL().h(locals1);
            b.ewn().f(localg.ddH, localg.subType, 0, localg.ddN);
            f.a.a(true, true, locals1, localg);
            AppMethodBeat.o(151916);
            return;
          }
          ad.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
          locals1.field_networkType = localg.networkType;
          if (bt.isNullOrNil(locals1.field_originalMd5)) {
            locals1.field_originalMd5 = localg.ddK;
          }
          if (localg.aBh(locals1.field_fileVersion) > 0)
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
            s locals2 = localg.ewu();
            if (locals1.field_keyVersion >= localg.BRP)
            {
              locals2.field_keyVersion = locals1.field_keyVersion;
              locals2.field_encryptKey = locals1.field_encryptKey;
            }
            locals2.field_fileUpdated = true;
            locals2.field_needRetry = true;
            locals2.field_deleted = false;
            q.a.ewL().h(locals2);
            b.ewn().f(localg.ddH, localg.subType, 0, localg.ddN);
            q.a.ewL().HF(localg.BRL);
            f.a.a(false, true, locals2, localg);
            AppMethodBeat.o(151916);
            return;
          }
          if ((localg.aBh(locals1.field_fileVersion) == 0) && (!locals1.field_needRetry))
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(locals1.field_resType), Integer.valueOf(locals1.field_subType), locals1.field_fileVersion });
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 2) || (locals1.field_status == 1) || (locals1.field_status == 0))
          {
            long l = com.tencent.mm.pluginsdk.h.a.d.a.fN(locals1.field_filePath);
            if (locals1.field_contentLength > l)
            {
              ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(locals1.field_contentLength), Long.valueOf(l) });
              if (0L == l)
              {
                b.ewn().f(localg.ddH, localg.subType, 0, localg.ddN);
                f.a.a(false, true, locals1, localg);
                AppMethodBeat.o(151916);
                return;
              }
              f.a.a(true, false, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            if (!bt.nullAsNil(com.tencent.mm.vfs.i.aEN(i.LW(localg.BRL))).equals(locals1.field_md5))
            {
              ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
              f.a.a(false, true, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { locals1.field_urlKey });
            locals1.field_status = 2;
            locals1.field_contentLength = com.tencent.mm.pluginsdk.h.a.d.a.fN(locals1.field_filePath);
            locals1.field_fileUpdated = false;
            locals1.field_reportId = localg.BRS;
            q.a.ewL().h(locals1);
            j.D(locals1.field_reportId, 13L);
            j.D(locals1.field_reportId, 44L);
            j.a(locals1.field_resType, locals1.field_subType, locals1.field_url, bt.getInt(locals1.field_fileVersion, 0), j.a.BSN, true, "NewXml".equalsIgnoreCase(locals1.field_groupId2), true, locals1.field_sampleId);
            if ((!localg.BSs) && (!localg.BSt))
            {
              b.ewn().a(localg.ddH, localg.subType, i.LW(localg.BRL), bt.getInt(localg.BTd, 0), localg.ddK);
              AppMethodBeat.o(151916);
              return;
            }
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { localg.BRL });
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
    k localk = this.BRX;
    if (localk.aBn(params.field_urlKey))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      AppMethodBeat.o(151936);
      return;
    }
    localk.a(a.a(params));
    AppMethodBeat.o(151936);
  }
  
  public final void e(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151929);
    q.a.ewL().ae(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151910);
        s locals = q.a.ewL().aBq(i.iO(paramInt1, paramInt2));
        if ((locals != null) && ((-1 == paramInt3) || (String.valueOf(paramInt3).equals(locals.field_fileVersion)))) {
          if (paramBoolean) {
            break label79;
          }
        }
        label79:
        for (boolean bool = true;; bool = false)
        {
          locals.field_needRetry = bool;
          q.a.ewL().h(locals);
          AppMethodBeat.o(151910);
          return;
        }
      }
    });
    AppMethodBeat.o(151929);
  }
  
  final Set<b> ewm()
  {
    AppMethodBeat.i(151928);
    synchronized (this.BRW)
    {
      Set localSet2 = Collections.newSetFromMap(new android.support.v4.e.a(this.BRW.size()));
      localSet2.addAll(this.BRW);
      AppMethodBeat.o(151928);
      return localSet2;
    }
  }
  
  final void f(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(151942);
    if (q.a.ewL().handler == null)
    {
      ad.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      AppMethodBeat.o(151942);
      return;
    }
    q.a.ewL().handler.post(new b.2(this, paramInt3, paramInt1, paramInt2, paramBoolean));
    AppMethodBeat.o(151942);
  }
  
  public static abstract interface b
  {
    public abstract boolean ewr();
  }
  
  static final class c
  {
    private static final b BSq;
    
    static
    {
      AppMethodBeat.i(151927);
      BSq = new b((byte)0);
      AppMethodBeat.o(151927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.b
 * JD-Core Version:    0.7.0.1
 */