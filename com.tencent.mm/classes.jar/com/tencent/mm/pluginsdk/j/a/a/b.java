package com.tencent.mm.pluginsdk.j.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.model.bb;
import com.tencent.mm.pluginsdk.j.a.b.c;
import com.tencent.mm.pluginsdk.j.a.c.d;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  private final Set<b> FhJ;
  private final k FhK;
  private final d FhL;
  
  private b()
  {
    AppMethodBeat.i(151932);
    this.FhJ = Collections.newSetFromMap(new android.support.v4.e.a(i.Fil.length));
    this.FhK = new k();
    this.FhL = new d()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.pluginsdk.j.a.c.m paramAnonymousm)
      {
        AppMethodBeat.i(151913);
        i.aNw(paramAnonymousString);
        paramAnonymousString = q.a.feQ().aNE(paramAnonymousString);
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
          if (paramAnonymousm.Fji != null)
          {
            if (!(paramAnonymousm.Fji instanceof com.tencent.mm.pluginsdk.j.a.b.a)) {
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
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, bu.getInt(paramAnonymousString.field_fileVersion, 0), j.a.Fiy, false, "NewXml".equalsIgnoreCase(paramAnonymousString.field_groupId2), false, paramAnonymousString.field_sampleId);
          AppMethodBeat.o(151913);
          return;
          label141:
          i = j;
          if ((paramAnonymousm.Fji instanceof c))
          {
            j.A(paramAnonymousString.field_reportId, 16L);
            i = 0;
          }
        }
      }
      
      public final void aNt(final String paramAnonymousString)
      {
        AppMethodBeat.i(151912);
        ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(paramAnonymousString)));
        s locals = q.a.feQ().aNE(paramAnonymousString);
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
        for (paramAnonymousString = j.a.Fiz;; paramAnonymousString = j.a.Fix)
        {
          j.a(locals.field_resType, locals.field_subType, locals.field_url, bu.getInt(locals.field_fileVersion, 0), paramAnonymousString, true, bu.nullAsNil(locals.field_groupId2).equals("NewXml"), false, locals.field_sampleId);
          if ((locals.field_fileCompress) || (locals.field_fileEncrypt)) {
            break;
          }
          paramAnonymousString = new bn();
          paramAnonymousString.dny.filePath = locals.field_filePath;
          paramAnonymousString.dny.dnC = locals.field_originalMd5;
          paramAnonymousString.dny.dnB = locals.field_fileUpdated;
          paramAnonymousString.dny.dnA = bu.getInt(locals.field_fileVersion, 0);
          paramAnonymousString.dny.dnz = locals.field_resType;
          paramAnonymousString.dny.subType = locals.field_subType;
          q.a.feQ().handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(218878);
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
              AppMethodBeat.o(218878);
            }
          });
          locals.field_fileUpdated = false;
          q.a.feQ().h(locals);
          AppMethodBeat.o(151912);
          return;
        }
        ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
        b.this.b(locals);
        AppMethodBeat.o(151912);
      }
      
      public final void aNu(String paramAnonymousString)
      {
        AppMethodBeat.i(151914);
        com.tencent.mm.pluginsdk.j.a.c.q localq = q.a.feQ();
        if (localq.kot) {}
        for (boolean bool = localq.Fjs.aNA(paramAnonymousString);; bool = false)
        {
          if (!bool) {
            i.aNw(paramAnonymousString);
          }
          AppMethodBeat.o(151914);
          return;
        }
      }
      
      public final String afK()
      {
        return "CheckResUpdate";
      }
    };
    Object localObject1 = q.a.feQ();
    d locald = this.FhL;
    ae.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { "CheckResUpdate", locald });
    if (((com.tencent.mm.pluginsdk.j.a.c.q)localObject1).kot)
    {
      com.tencent.mm.pluginsdk.j.a.c.i locali = ((com.tencent.mm.pluginsdk.j.a.c.q)localObject1).Fjt;
      ae.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(locald)));
      if (locald != null)
      {
        int i = "CheckResUpdate".hashCode();
        synchronized (locali.FiY)
        {
          List localList = (List)locali.FiX.get(i);
          localObject1 = localList;
          if (localList == null) {
            localObject1 = new LinkedList();
          }
          ((List)localObject1).add(locald);
          locali.FiX.put(i, localObject1);
          AppMethodBeat.o(151932);
          return;
        }
      }
    }
    AppMethodBeat.o(151932);
  }
  
  public static void Zd(int paramInt)
  {
    AppMethodBeat.i(151933);
    ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.ajP();
    boolean bool1 = com.tencent.mm.kernel.a.aiY();
    boolean bool2 = bb.hIK.ay("login_user_name", "").equals("");
    if ((!bool1) && (bool2))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
      AppMethodBeat.o(151933);
      return;
    }
    m localm = new m(paramInt);
    com.tencent.mm.kernel.g.ajQ().gDv.a(localm, 0);
    AppMethodBeat.o(151933);
  }
  
  static void c(s params)
  {
    AppMethodBeat.i(151937);
    ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { params.field_urlKey });
    k.g(params);
    AppMethodBeat.o(151937);
  }
  
  public static b fes()
  {
    AppMethodBeat.i(169213);
    if (!ak.coh()) {
      Assert.fail("Inaccessible in child process.");
    }
    b localb = c.fex();
    AppMethodBeat.o(169213);
    return localb;
  }
  
  public static String fet()
  {
    AppMethodBeat.i(151935);
    Object localObject = q.a.feQ().aNE(i.jr(60, 3));
    if (localObject == null)
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getOriginalMd5, %d.%d, get null info, return", new Object[] { Integer.valueOf(60), Integer.valueOf(3) });
      AppMethodBeat.o(151935);
      return null;
    }
    localObject = ((s)localObject).field_originalMd5;
    AppMethodBeat.o(151935);
    return localObject;
  }
  
  public static String jq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151934);
    s locals = q.a.feQ().aNE(i.jr(paramInt1, paramInt2));
    if (locals == null)
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    ae.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[] { Boolean.valueOf(locals.field_deleted), locals.field_filePath, locals.field_md5, Boolean.valueOf(locals.field_fileCompress), Boolean.valueOf(locals.field_fileEncrypt), locals.field_originalMd5 });
    String str;
    if ((!locals.field_fileCompress) && (!locals.field_fileEncrypt))
    {
      if ((!locals.field_deleted) && (!bu.isNullOrNil(locals.field_filePath)) && (bu.nullAsNil(o.aRh(locals.field_filePath)).equals(locals.field_md5)))
      {
        ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locals.field_filePath });
        str = locals.field_filePath;
        AppMethodBeat.o(151934);
        return str;
      }
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    if (locals.field_fileCompress) {
      str = locals.field_filePath + ".decompressed";
    }
    for (;;)
    {
      if (bu.isNullOrNil(str))
      {
        ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151934);
        return null;
        if (locals.field_fileEncrypt) {
          str = locals.field_filePath + ".decrypted";
        }
      }
      else
      {
        if ((!bu.isNullOrNil(locals.field_originalMd5)) && (bu.nullAsNil(o.aRh(str)).equals(locals.field_originalMd5)))
        {
          ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
          AppMethodBeat.o(151934);
          return str;
        }
        ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, needDecrypt(%b) needDecompress(%b), file invalid, return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(locals.field_fileEncrypt), Boolean.valueOf(locals.field_fileCompress) });
        AppMethodBeat.o(151934);
        return null;
      }
      str = null;
    }
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(151941);
    q.a.feQ().ad(new Runnable()
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
        Object localObject = i.jr(i, j);
        localObject = q.a.feQ().aNE((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(151918);
          return;
        }
        boolean bool = ((s)localObject).field_fileUpdated;
        ((s)localObject).field_fileUpdated = false;
        q.a.feQ().h((s)localObject);
        if (k == bu.getInt(((s)localObject).field_fileVersion, 0))
        {
          if (q.a.feQ().handler == null)
          {
            ae.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            AppMethodBeat.o(151918);
            return;
          }
          q.a.feQ().handler.post(new b.8(localb, i, j, str1, k, bool, str2));
        }
        AppMethodBeat.o(151918);
      }
    });
    AppMethodBeat.o(151941);
  }
  
  final void a(final int paramInt, final cwc paramcwc, final boolean paramBoolean)
  {
    AppMethodBeat.i(151938);
    final String str = i.jr(paramInt, paramcwc.Hzh);
    if (paramcwc.HHa == null)
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      AppMethodBeat.o(151938);
      return;
    }
    ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramcwc.Hzh), Integer.valueOf(paramcwc.HHa.HHk) });
    j.A(paramcwc.HHc, 3L);
    final int i = paramcwc.HHa.HHk;
    final int j = paramcwc.Hzh;
    final int k = paramcwc.HHc;
    paramcwc = paramcwc.HHd;
    q.a.feQ().ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151915);
        s locals = q.a.feQ().aNE(str);
        int i = paramInt;
        int j = j;
        int k = i;
        int m = k;
        String str1 = paramcwc;
        boolean bool2 = paramBoolean;
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(locals)));
        ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
        boolean bool1 = false;
        String str2;
        if (locals != null) {
          if (bu.getInt(locals.field_fileVersion, 0) <= k)
          {
            bool1 = true;
            str2 = i.jr(i, j);
            String str3 = i.Uq(str2);
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
            if (!bool1) {
              break label443;
            }
            q.a.feQ().PL(str2);
            b.fes().g(i, j, 2, bool2);
            if (!(com.tencent.mm.pluginsdk.j.a.d.a.aNH(str3) & true & com.tencent.mm.pluginsdk.j.a.d.a.aNH(str3 + ".decompressed") & com.tencent.mm.pluginsdk.j.a.d.a.aNH(str3 + ".decrypted"))) {
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
          q.a.feQ().h(locals);
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
        q.a.feQ().h(locals);
        label443:
        AppMethodBeat.o(151915);
      }
    });
    AppMethodBeat.o(151938);
  }
  
  final void a(int paramInt, cwc paramcwc, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151940);
    final String str = i.jr(paramInt, paramcwc.Hzh);
    if ((paramcwc.HHb == null) || (bu.isNullOrNil(paramcwc.HHb.HHj)))
    {
      ae.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key invalid, resource=%d.%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramcwc.Hzh) });
      AppMethodBeat.o(151940);
      return;
    }
    ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(paramcwc.Hzh), Integer.valueOf(paramcwc.HHb.HHi) });
    ae.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramcwc.HHb.HHj });
    j.A(paramcwc.HHc, 4L);
    paramcwc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151917);
        s locals = q.a.feQ().aNE(str);
        String str1 = this.FhT;
        String str2 = this.FhU;
        int i = this.FhV;
        int j = this.jNo;
        String str3 = this.FhR;
        boolean bool = paramBoolean2;
        if (locals == null)
        {
          locals = new s();
          locals.field_keyVersion = i;
          locals.field_encryptKey = str2;
          locals.field_reportId = j;
          locals.field_sampleId = str3;
          locals.field_originalMd5 = str1;
          q.a.feQ().h(locals);
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
          if (bu.isNullOrNil(locals.field_originalMd5)) {
            locals.field_originalMd5 = str1;
          }
          q.a.feQ().h(locals);
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
      paramcwc.run();
      AppMethodBeat.o(151940);
      return;
    }
    q.a.feQ().ad(paramcwc);
    AppMethodBeat.o(151940);
  }
  
  public final void aH(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151930);
    f(paramInt1, paramInt2, paramInt3, true);
    AppMethodBeat.o(151930);
  }
  
  final void b(int paramInt, final cwc paramcwc, boolean paramBoolean)
  {
    AppMethodBeat.i(151939);
    final String str = i.jr(paramInt, paramcwc.Hzh);
    if (paramcwc.HHa == null)
    {
      ae.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      AppMethodBeat.o(151939);
      return;
    }
    int i = paramcwc.Hzh;
    int j = paramcwc.HHa.HHk;
    if (paramcwc.HHa.HHm == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramcwc.HHa.HHm.size()))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramcwc.HHc), paramcwc.HHd, paramcwc.HHa.Url, paramcwc.HHa.Gwe });
      if (paramcwc.HHa.HHm == null) {
        break;
      }
      localObject = paramcwc.HHa.HHm.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dfe localdfe = (dfe)((Iterator)localObject).next();
        ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localdfe.Version), localdfe.HMq.fjO() });
      }
    }
    j.Db(paramcwc.HHc);
    if (!paramBoolean) {
      j.A(paramcwc.HHc, 1L);
    }
    if ((paramcwc.GgG != 0) && (paramcwc.GgG <= bu.aRi()))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramcwc.GgG), Integer.valueOf(paramcwc.HHa.HHk) });
      j.A(paramcwc.HHc, 14L);
      j.A(paramcwc.HHc, 44L);
      j.a(paramInt, paramcwc.Hzh, paramcwc.HHa.Url, paramcwc.HHa.HHk, j.a.FiB, false, paramBoolean, false, paramcwc.HHd);
      AppMethodBeat.o(151939);
      return;
    }
    if ((bu.isNullOrNil(paramcwc.HHa.Url)) && (paramcwc.HHa.Gwe == null))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      AppMethodBeat.o(151939);
      return;
    }
    localObject = new g.a(paramcwc.HHa.Url);
    ((g.a)localObject).aNy(str);
    ((g.a)localObject).dnz = paramInt;
    ((g.a)localObject).subType = paramcwc.Hzh;
    ((g.a)localObject).Dc(paramcwc.GgG);
    ((g.a)localObject).dnA = paramcwc.HHa.HHk;
    ((g.a)localObject).aNz(paramcwc.HHa.MD5);
    ((g.a)localObject).Fif = i.a.Zf(paramcwc.HHa.HHl);
    ((g.a)localObject).Fig = i.a.Ze(paramcwc.HHa.HHl);
    ((g.a)localObject).DRK = paramcwc.HHc;
    ((g.a)localObject).FhG = paramcwc.HHd;
    if (paramcwc.HHe > 0) {}
    for (paramInt = paramcwc.HHe;; paramInt = 3)
    {
      ((g.a)localObject).Zm(paramInt);
      ((g.a)localObject).Fih = paramcwc.Fih;
      ((g.a)localObject).Zl(paramcwc.HHf);
      ((g.a)localObject).dnF = paramBoolean;
      if (!bu.ht(paramcwc.HHa.HHm)) {
        ((g.a)localObject).FhE = ((dfe)paramcwc.HHa.HHm.get(0)).HMq.zr;
      }
      if ((paramcwc.HHb != null) && (!bu.isNullOrNil(paramcwc.HHb.HHj)))
      {
        ((g.a)localObject).FhC = paramcwc.HHb.HHj;
        ((g.a)localObject).FhD = paramcwc.HHb.HHi;
      }
      if ((paramcwc.HHa.Gwe != null) && (paramcwc.HHa.Gwe.zr.length > 0)) {
        ((g.a)localObject).Fie = paramcwc.HHa.Gwe.toByteArray();
      }
      ((g.a)localObject).dnC = paramcwc.HHa.HHn;
      ((g.a)localObject).fileSize = paramcwc.HHa.FileSize;
      ((g.a)localObject).Zn(paramcwc.HcW);
      paramcwc = ((g.a)localObject).feA();
      ae.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramcwc.toString() });
      q.a.feQ().ad(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151916);
          s locals1 = q.a.feQ().aNE(str);
          g localg = paramcwc;
          if (locals1 == null) {
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null, urlKey = %s", new Object[] { localg.Fhz });
          }
          while ((locals1 != null) && (locals1.field_deleted) && (localg.aNv(locals1.field_fileVersion) <= 0))
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { locals1.field_fileVersion, localg.FiQ });
            AppMethodBeat.o(151916);
            return;
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { locals1.field_urlKey, locals1.field_url, Long.valueOf(locals1.field_contentLength), Boolean.valueOf(locals1.field_deleted), locals1.field_eccSignature, Long.valueOf(locals1.field_expireTime), Boolean.valueOf(locals1.field_fileCompress), Boolean.valueOf(locals1.field_fileEncrypt), locals1.field_filePath, Boolean.valueOf(locals1.field_fileUpdated), locals1.field_fileVersion, locals1.field_groupId2, Integer.valueOf(locals1.field_keyVersion), Boolean.valueOf(bu.isNullOrNil(locals1.field_encryptKey)), Integer.valueOf(locals1.field_maxRetryTimes), Integer.valueOf(locals1.field_retryTimes), locals1.field_sampleId, Integer.valueOf(locals1.field_status) });
            ae.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { locals1.field_encryptKey });
          }
          if (locals1 == null)
          {
            locals1 = localg.fez();
            locals1.field_fileUpdated = true;
            locals1.field_needRetry = true;
            if (bu.isNullOrNil(locals1.field_encryptKey)) {
              locals1.field_keyVersion = -1;
            }
            ae.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(locals1)));
            q.a.feQ().h(locals1);
            b.fes().g(localg.dnz, localg.subType, 0, localg.dnF);
            f.a.a(true, true, locals1, localg);
            AppMethodBeat.o(151916);
            return;
          }
          ae.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
          locals1.field_networkType = localg.networkType;
          if (bu.isNullOrNil(locals1.field_originalMd5)) {
            locals1.field_originalMd5 = localg.dnC;
          }
          if (localg.aNv(locals1.field_fileVersion) > 0)
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
            s locals2 = localg.fez();
            if (locals1.field_keyVersion >= localg.FhD)
            {
              locals2.field_keyVersion = locals1.field_keyVersion;
              locals2.field_encryptKey = locals1.field_encryptKey;
            }
            locals2.field_fileUpdated = true;
            locals2.field_needRetry = true;
            locals2.field_deleted = false;
            q.a.feQ().h(locals2);
            b.fes().g(localg.dnz, localg.subType, 0, localg.dnF);
            q.a.feQ().PL(localg.Fhz);
            f.a.a(false, true, locals2, localg);
            AppMethodBeat.o(151916);
            return;
          }
          if ((localg.aNv(locals1.field_fileVersion) == 0) && (!locals1.field_needRetry))
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(locals1.field_resType), Integer.valueOf(locals1.field_subType), locals1.field_fileVersion });
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 2) || (locals1.field_status == 1) || (locals1.field_status == 0))
          {
            long l = com.tencent.mm.pluginsdk.j.a.d.a.gE(locals1.field_filePath);
            if (locals1.field_contentLength > l)
            {
              ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(locals1.field_contentLength), Long.valueOf(l) });
              if (0L == l)
              {
                b.fes().g(localg.dnz, localg.subType, 0, localg.dnF);
                f.a.a(false, true, locals1, localg);
                AppMethodBeat.o(151916);
                return;
              }
              f.a.a(true, false, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            if (!bu.nullAsNil(o.aRh(i.Uq(localg.Fhz))).equals(locals1.field_md5))
            {
              ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
              f.a.a(false, true, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { locals1.field_urlKey });
            locals1.field_status = 2;
            locals1.field_contentLength = com.tencent.mm.pluginsdk.j.a.d.a.gE(locals1.field_filePath);
            locals1.field_fileUpdated = false;
            locals1.field_reportId = localg.DRK;
            q.a.feQ().h(locals1);
            j.A(locals1.field_reportId, 13L);
            j.A(locals1.field_reportId, 44L);
            j.a(locals1.field_resType, locals1.field_subType, locals1.field_url, bu.getInt(locals1.field_fileVersion, 0), j.a.FiA, true, "NewXml".equalsIgnoreCase(locals1.field_groupId2), true, locals1.field_sampleId);
            if ((!localg.Fif) && (!localg.Fig))
            {
              b.fes().a(localg.dnz, localg.subType, i.Uq(localg.Fhz), bu.getInt(localg.FiQ, 0), localg.dnC);
              AppMethodBeat.o(151916);
              return;
            }
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { localg.Fhz });
            f.b.a(locals1, false, false);
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 4) || (locals1.field_status == 3))
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", new Object[] { locals1.field_urlKey });
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
    ae.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + params.field_urlKey);
    k localk = this.FhK;
    if (localk.aNB(params.field_urlKey))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      AppMethodBeat.o(151936);
      return;
    }
    localk.a(a.a(params));
    AppMethodBeat.o(151936);
  }
  
  public final void f(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151929);
    q.a.feQ().ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151910);
        s locals = q.a.feQ().aNE(i.jr(paramInt1, paramInt2));
        if ((locals != null) && ((-1 == paramInt3) || (String.valueOf(paramInt3).equals(locals.field_fileVersion)))) {
          if (paramBoolean) {
            break label79;
          }
        }
        label79:
        for (boolean bool = true;; bool = false)
        {
          locals.field_needRetry = bool;
          q.a.feQ().h(locals);
          AppMethodBeat.o(151910);
          return;
        }
      }
    });
    AppMethodBeat.o(151929);
  }
  
  final Set<b> fer()
  {
    AppMethodBeat.i(151928);
    synchronized (this.FhJ)
    {
      Set localSet2 = Collections.newSetFromMap(new android.support.v4.e.a(this.FhJ.size()));
      localSet2.addAll(this.FhJ);
      AppMethodBeat.o(151928);
      return localSet2;
    }
  }
  
  final void g(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(151942);
    if (q.a.feQ().handler == null)
    {
      ae.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      AppMethodBeat.o(151942);
      return;
    }
    q.a.feQ().handler.post(new b.2(this, paramInt3, paramInt1, paramInt2, paramBoolean));
    AppMethodBeat.o(151942);
  }
  
  public static abstract interface b
  {
    public abstract boolean few();
  }
  
  static final class c
  {
    private static final b Fid;
    
    static
    {
      AppMethodBeat.i(151927);
      Fid = new b((byte)0);
      AppMethodBeat.o(151927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.b
 * JD-Core Version:    0.7.0.1
 */