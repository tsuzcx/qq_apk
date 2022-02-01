package com.tencent.mm.pluginsdk.h.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.h.a.c.l;
import com.tencent.mm.pluginsdk.h.a.c.n;
import com.tencent.mm.pluginsdk.h.a.c.n.a;
import com.tencent.mm.pluginsdk.h.a.c.q.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  private final Set<b> Dkm;
  private final k Dkn;
  private final com.tencent.mm.pluginsdk.h.a.c.d Dko;
  
  private b()
  {
    AppMethodBeat.i(151932);
    this.Dkm = Collections.newSetFromMap(new android.support.v4.e.a(i.DkO.length));
    this.Dkn = new k();
    this.Dko = new com.tencent.mm.pluginsdk.h.a.c.d()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.pluginsdk.h.a.c.m paramAnonymousm)
      {
        AppMethodBeat.i(151913);
        i.aGA(paramAnonymousString);
        paramAnonymousString = q.a.eMf().aGI(paramAnonymousString);
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
          if (paramAnonymousm.DlL != null)
          {
            if (!(paramAnonymousm.DlL instanceof com.tencent.mm.pluginsdk.h.a.b.a)) {
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
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, bs.getInt(paramAnonymousString.field_fileVersion, 0), j.a.Dlb, false, "NewXml".equalsIgnoreCase(paramAnonymousString.field_groupId2), false, paramAnonymousString.field_sampleId);
          AppMethodBeat.o(151913);
          return;
          label141:
          i = j;
          if ((paramAnonymousm.DlL instanceof com.tencent.mm.pluginsdk.h.a.b.c))
          {
            j.A(paramAnonymousString.field_reportId, 16L);
            i = 0;
          }
        }
      }
      
      public final void aGx(final String paramAnonymousString)
      {
        AppMethodBeat.i(151912);
        ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(paramAnonymousString)));
        s locals = q.a.eMf().aGI(paramAnonymousString);
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
        for (paramAnonymousString = j.a.Dlc;; paramAnonymousString = j.a.Dla)
        {
          j.a(locals.field_resType, locals.field_subType, locals.field_url, bs.getInt(locals.field_fileVersion, 0), paramAnonymousString, true, bs.nullAsNil(locals.field_groupId2).equals("NewXml"), false, locals.field_sampleId);
          if ((locals.field_fileCompress) || (locals.field_fileEncrypt)) {
            break;
          }
          paramAnonymousString = new bk();
          paramAnonymousString.dbc.filePath = locals.field_filePath;
          paramAnonymousString.dbc.dbg = locals.field_originalMd5;
          paramAnonymousString.dbc.dbf = locals.field_fileUpdated;
          paramAnonymousString.dbc.dbe = bs.getInt(locals.field_fileVersion, 0);
          paramAnonymousString.dbc.dbd = locals.field_resType;
          paramAnonymousString.dbc.subType = locals.field_subType;
          q.a.eMf().handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192683);
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
              AppMethodBeat.o(192683);
            }
          });
          locals.field_fileUpdated = false;
          q.a.eMf().h(locals);
          AppMethodBeat.o(151912);
          return;
        }
        ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
        b.this.b(locals);
        AppMethodBeat.o(151912);
      }
      
      public final void aGy(String paramAnonymousString)
      {
        AppMethodBeat.i(151914);
        com.tencent.mm.pluginsdk.h.a.c.q localq = q.a.eMf();
        if (localq.jQO) {}
        for (boolean bool = localq.DlV.aGE(paramAnonymousString);; bool = false)
        {
          if (!bool) {
            i.aGA(paramAnonymousString);
          }
          AppMethodBeat.o(151914);
          return;
        }
      }
      
      public final String azp()
      {
        return "CheckResUpdate";
      }
    };
    Object localObject1 = q.a.eMf();
    com.tencent.mm.pluginsdk.h.a.c.d locald = this.Dko;
    ac.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { "CheckResUpdate", locald });
    if (((com.tencent.mm.pluginsdk.h.a.c.q)localObject1).jQO)
    {
      com.tencent.mm.pluginsdk.h.a.c.i locali = ((com.tencent.mm.pluginsdk.h.a.c.q)localObject1).DlW;
      ac.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(locald)));
      if (locald != null)
      {
        int i = "CheckResUpdate".hashCode();
        synchronized (locali.DlB)
        {
          List localList = (List)locali.DlA.get(i);
          localObject1 = localList;
          if (localList == null) {
            localObject1 = new LinkedList();
          }
          ((List)localObject1).add(locald);
          locali.DlA.put(i, localObject1);
          AppMethodBeat.o(151932);
          return;
        }
      }
    }
    AppMethodBeat.o(151932);
  }
  
  public static void WB(int paramInt)
  {
    AppMethodBeat.i(151933);
    ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.agP();
    boolean bool1 = com.tencent.mm.kernel.a.afX();
    boolean bool2 = ay.hnA.aw("login_user_name", "").equals("");
    if ((!bool1) && (bool2))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
      AppMethodBeat.o(151933);
      return;
    }
    m localm = new m(paramInt);
    com.tencent.mm.kernel.g.agQ().ghe.a(localm, 0);
    AppMethodBeat.o(151933);
  }
  
  static void c(s params)
  {
    AppMethodBeat.i(151937);
    ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { params.field_urlKey });
    k.g(params);
    AppMethodBeat.o(151937);
  }
  
  public static b eLH()
  {
    AppMethodBeat.i(169213);
    if (!ai.cin()) {
      Assert.fail("Inaccessible in child process.");
    }
    b localb = c.eLM();
    AppMethodBeat.o(169213);
    return localb;
  }
  
  public static String eLI()
  {
    AppMethodBeat.i(151935);
    Object localObject = q.a.eMf().aGI(i.jb(60, 3));
    if (localObject == null)
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getOriginalMd5, %d.%d, get null info, return", new Object[] { Integer.valueOf(60), Integer.valueOf(3) });
      AppMethodBeat.o(151935);
      return null;
    }
    localObject = ((s)localObject).field_originalMd5;
    AppMethodBeat.o(151935);
    return localObject;
  }
  
  public static String ja(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151934);
    s locals = q.a.eMf().aGI(i.jb(paramInt1, paramInt2));
    if (locals == null)
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    ac.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[] { Boolean.valueOf(locals.field_deleted), locals.field_filePath, locals.field_md5, Boolean.valueOf(locals.field_fileCompress), Boolean.valueOf(locals.field_fileEncrypt), locals.field_originalMd5 });
    String str;
    if ((!locals.field_fileCompress) && (!locals.field_fileEncrypt))
    {
      if ((!locals.field_deleted) && (!bs.isNullOrNil(locals.field_filePath)) && (bs.nullAsNil(com.tencent.mm.vfs.i.aKe(locals.field_filePath)).equals(locals.field_md5)))
      {
        ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locals.field_filePath });
        str = locals.field_filePath;
        AppMethodBeat.o(151934);
        return str;
      }
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    if (locals.field_fileCompress) {
      str = locals.field_filePath + ".decompressed";
    }
    for (;;)
    {
      if (bs.isNullOrNil(str))
      {
        ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151934);
        return null;
        if (locals.field_fileEncrypt) {
          str = locals.field_filePath + ".decrypted";
        }
      }
      else
      {
        if ((!bs.isNullOrNil(locals.field_originalMd5)) && (bs.nullAsNil(com.tencent.mm.vfs.i.aKe(str)).equals(locals.field_originalMd5)))
        {
          ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
          AppMethodBeat.o(151934);
          return str;
        }
        ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, needDecrypt(%b) needDecompress(%b), file invalid, return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(locals.field_fileEncrypt), Boolean.valueOf(locals.field_fileCompress) });
        AppMethodBeat.o(151934);
        return null;
      }
      str = null;
    }
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(151941);
    q.a.eMf().ag(new Runnable()
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
        Object localObject = i.jb(i, j);
        localObject = q.a.eMf().aGI((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(151918);
          return;
        }
        boolean bool = ((s)localObject).field_fileUpdated;
        ((s)localObject).field_fileUpdated = false;
        q.a.eMf().h((s)localObject);
        if (k == bs.getInt(((s)localObject).field_fileVersion, 0))
        {
          if (q.a.eMf().handler == null)
          {
            ac.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            AppMethodBeat.o(151918);
            return;
          }
          q.a.eMf().handler.post(new b.8(localb, i, j, str1, k, bool, str2));
        }
        AppMethodBeat.o(151918);
      }
    });
    AppMethodBeat.o(151941);
  }
  
  final void a(final int paramInt, final cqd paramcqd, final boolean paramBoolean)
  {
    AppMethodBeat.i(151938);
    final String str = i.jb(paramInt, paramcqd.FvC);
    if (paramcqd.FDn == null)
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      AppMethodBeat.o(151938);
      return;
    }
    ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramcqd.FvC), Integer.valueOf(paramcqd.FDn.FDx) });
    j.A(paramcqd.FDp, 3L);
    final int i = paramcqd.FDn.FDx;
    final int j = paramcqd.FvC;
    final int k = paramcqd.FDp;
    paramcqd = paramcqd.FDq;
    q.a.eMf().ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151915);
        s locals = q.a.eMf().aGI(str);
        int i = paramInt;
        int j = j;
        int k = i;
        int m = k;
        String str1 = paramcqd;
        boolean bool2 = paramBoolean;
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(locals)));
        ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
        boolean bool1 = false;
        String str2;
        if (locals != null) {
          if (bs.getInt(locals.field_fileVersion, 0) <= k)
          {
            bool1 = true;
            str2 = i.jb(i, j);
            String str3 = i.Qc(str2);
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
            if (!bool1) {
              break label443;
            }
            q.a.eMf().LJ(str2);
            b.eLH().g(i, j, 2, bool2);
            if (!(com.tencent.mm.pluginsdk.h.a.d.a.aGL(str3) & true & com.tencent.mm.pluginsdk.h.a.d.a.aGL(str3 + ".decompressed") & com.tencent.mm.pluginsdk.h.a.d.a.aGL(str3 + ".decrypted"))) {
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
          q.a.eMf().h(locals);
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
        q.a.eMf().h(locals);
        label443:
        AppMethodBeat.o(151915);
      }
    });
    AppMethodBeat.o(151938);
  }
  
  final void a(int paramInt, cqd paramcqd, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151940);
    final String str = i.jb(paramInt, paramcqd.FvC);
    if ((paramcqd.FDo == null) || (bs.isNullOrNil(paramcqd.FDo.FDw)))
    {
      ac.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key invalid, resource=%d.%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramcqd.FvC) });
      AppMethodBeat.o(151940);
      return;
    }
    ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(paramcqd.FvC), Integer.valueOf(paramcqd.FDo.FDv) });
    ac.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramcqd.FDo.FDw });
    j.A(paramcqd.FDp, 4L);
    paramcqd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151917);
        s locals = q.a.eMf().aGI(str);
        String str1 = this.Dkw;
        String str2 = this.Dkx;
        int i = this.Dky;
        int j = this.jqi;
        String str3 = this.Dku;
        boolean bool = paramBoolean2;
        if (locals == null)
        {
          locals = new s();
          locals.field_keyVersion = i;
          locals.field_encryptKey = str2;
          locals.field_reportId = j;
          locals.field_sampleId = str3;
          locals.field_originalMd5 = str1;
          q.a.eMf().h(locals);
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
          if (bs.isNullOrNil(locals.field_originalMd5)) {
            locals.field_originalMd5 = str1;
          }
          q.a.eMf().h(locals);
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
      paramcqd.run();
      AppMethodBeat.o(151940);
      return;
    }
    q.a.eMf().ag(paramcqd);
    AppMethodBeat.o(151940);
  }
  
  public final void aE(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151930);
    f(paramInt1, paramInt2, paramInt3, true);
    AppMethodBeat.o(151930);
  }
  
  final void b(int paramInt, final cqd paramcqd, boolean paramBoolean)
  {
    AppMethodBeat.i(151939);
    final String str = i.jb(paramInt, paramcqd.FvC);
    if (paramcqd.FDn == null)
    {
      ac.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      AppMethodBeat.o(151939);
      return;
    }
    int i = paramcqd.FvC;
    int j = paramcqd.FDn.FDx;
    if (paramcqd.FDn.FDz == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramcqd.FDn.FDz.size()))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramcqd.FDp), paramcqd.FDq, paramcqd.FDn.Url, paramcqd.FDn.Ewb });
      if (paramcqd.FDn.FDz == null) {
        break;
      }
      localObject = paramcqd.FDn.FDz.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cyx localcyx = (cyx)((Iterator)localObject).next();
        ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localcyx.Version), localcyx.FIf.eQU() });
      }
    }
    j.zP(paramcqd.FDp);
    if (!paramBoolean) {
      j.A(paramcqd.FDp, 1L);
    }
    if ((paramcqd.Eha != 0) && (paramcqd.Eha <= bs.aNx()))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramcqd.Eha), Integer.valueOf(paramcqd.FDn.FDx) });
      j.A(paramcqd.FDp, 14L);
      j.A(paramcqd.FDp, 44L);
      j.a(paramInt, paramcqd.FvC, paramcqd.FDn.Url, paramcqd.FDn.FDx, j.a.Dle, false, paramBoolean, false, paramcqd.FDq);
      AppMethodBeat.o(151939);
      return;
    }
    if ((bs.isNullOrNil(paramcqd.FDn.Url)) && (paramcqd.FDn.Ewb == null))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      AppMethodBeat.o(151939);
      return;
    }
    localObject = new g.a(paramcqd.FDn.Url);
    ((g.a)localObject).aGC(str);
    ((g.a)localObject).dbd = paramInt;
    ((g.a)localObject).subType = paramcqd.FvC;
    ((g.a)localObject).zQ(paramcqd.Eha);
    ((g.a)localObject).dbe = paramcqd.FDn.FDx;
    ((g.a)localObject).aGD(paramcqd.FDn.MD5);
    ((g.a)localObject).DkI = i.a.WD(paramcqd.FDn.FDy);
    ((g.a)localObject).DkJ = i.a.WC(paramcqd.FDn.FDy);
    ((g.a)localObject).Dki = paramcqd.FDp;
    ((g.a)localObject).Dkj = paramcqd.FDq;
    if (paramcqd.FDr > 0) {}
    for (paramInt = paramcqd.FDr;; paramInt = 3)
    {
      ((g.a)localObject).WK(paramInt);
      ((g.a)localObject).DkK = paramcqd.DkK;
      ((g.a)localObject).WJ(paramcqd.FDs);
      ((g.a)localObject).dbj = paramBoolean;
      if (!bs.gY(paramcqd.FDn.FDz)) {
        ((g.a)localObject).Dkg = ((cyx)paramcqd.FDn.FDz.get(0)).FIf.xy;
      }
      if ((paramcqd.FDo != null) && (!bs.isNullOrNil(paramcqd.FDo.FDw)))
      {
        ((g.a)localObject).Dke = paramcqd.FDo.FDw;
        ((g.a)localObject).Dkf = paramcqd.FDo.FDv;
      }
      if ((paramcqd.FDn.Ewb != null) && (paramcqd.FDn.Ewb.xy.length > 0)) {
        ((g.a)localObject).DkH = paramcqd.FDn.Ewb.toByteArray();
      }
      ((g.a)localObject).dbg = paramcqd.FDn.FDA;
      ((g.a)localObject).fileSize = paramcqd.FDn.FileSize;
      ((g.a)localObject).WL(paramcqd.EZW);
      paramcqd = ((g.a)localObject).eLP();
      ac.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramcqd.toString() });
      q.a.eMf().ag(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151916);
          s locals1 = q.a.eMf().aGI(str);
          g localg = paramcqd;
          if (locals1 == null) {
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null, urlKey = %s", new Object[] { localg.Dkb });
          }
          while ((locals1 != null) && (locals1.field_deleted) && (localg.aGz(locals1.field_fileVersion) <= 0))
          {
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { locals1.field_fileVersion, localg.Dlt });
            AppMethodBeat.o(151916);
            return;
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { locals1.field_urlKey, locals1.field_url, Long.valueOf(locals1.field_contentLength), Boolean.valueOf(locals1.field_deleted), locals1.field_eccSignature, Long.valueOf(locals1.field_expireTime), Boolean.valueOf(locals1.field_fileCompress), Boolean.valueOf(locals1.field_fileEncrypt), locals1.field_filePath, Boolean.valueOf(locals1.field_fileUpdated), locals1.field_fileVersion, locals1.field_groupId2, Integer.valueOf(locals1.field_keyVersion), Boolean.valueOf(bs.isNullOrNil(locals1.field_encryptKey)), Integer.valueOf(locals1.field_maxRetryTimes), Integer.valueOf(locals1.field_retryTimes), locals1.field_sampleId, Integer.valueOf(locals1.field_status) });
            ac.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { locals1.field_encryptKey });
          }
          if (locals1 == null)
          {
            locals1 = localg.eLO();
            locals1.field_fileUpdated = true;
            locals1.field_needRetry = true;
            if (bs.isNullOrNil(locals1.field_encryptKey)) {
              locals1.field_keyVersion = -1;
            }
            ac.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(locals1)));
            q.a.eMf().h(locals1);
            b.eLH().g(localg.dbd, localg.subType, 0, localg.dbj);
            f.a.a(true, true, locals1, localg);
            AppMethodBeat.o(151916);
            return;
          }
          ac.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
          locals1.field_networkType = localg.networkType;
          if (bs.isNullOrNil(locals1.field_originalMd5)) {
            locals1.field_originalMd5 = localg.dbg;
          }
          if (localg.aGz(locals1.field_fileVersion) > 0)
          {
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
            s locals2 = localg.eLO();
            if (locals1.field_keyVersion >= localg.Dkf)
            {
              locals2.field_keyVersion = locals1.field_keyVersion;
              locals2.field_encryptKey = locals1.field_encryptKey;
            }
            locals2.field_fileUpdated = true;
            locals2.field_needRetry = true;
            locals2.field_deleted = false;
            q.a.eMf().h(locals2);
            b.eLH().g(localg.dbd, localg.subType, 0, localg.dbj);
            q.a.eMf().LJ(localg.Dkb);
            f.a.a(false, true, locals2, localg);
            AppMethodBeat.o(151916);
            return;
          }
          if ((localg.aGz(locals1.field_fileVersion) == 0) && (!locals1.field_needRetry))
          {
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(locals1.field_resType), Integer.valueOf(locals1.field_subType), locals1.field_fileVersion });
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 2) || (locals1.field_status == 1) || (locals1.field_status == 0))
          {
            long l = com.tencent.mm.pluginsdk.h.a.d.a.fD(locals1.field_filePath);
            if (locals1.field_contentLength > l)
            {
              ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(locals1.field_contentLength), Long.valueOf(l) });
              if (0L == l)
              {
                b.eLH().g(localg.dbd, localg.subType, 0, localg.dbj);
                f.a.a(false, true, locals1, localg);
                AppMethodBeat.o(151916);
                return;
              }
              f.a.a(true, false, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            if (!bs.nullAsNil(com.tencent.mm.vfs.i.aKe(i.Qc(localg.Dkb))).equals(locals1.field_md5))
            {
              ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
              f.a.a(false, true, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { locals1.field_urlKey });
            locals1.field_status = 2;
            locals1.field_contentLength = com.tencent.mm.pluginsdk.h.a.d.a.fD(locals1.field_filePath);
            locals1.field_fileUpdated = false;
            locals1.field_reportId = localg.Dki;
            q.a.eMf().h(locals1);
            j.A(locals1.field_reportId, 13L);
            j.A(locals1.field_reportId, 44L);
            j.a(locals1.field_resType, locals1.field_subType, locals1.field_url, bs.getInt(locals1.field_fileVersion, 0), j.a.Dld, true, "NewXml".equalsIgnoreCase(locals1.field_groupId2), true, locals1.field_sampleId);
            if ((!localg.DkI) && (!localg.DkJ))
            {
              b.eLH().a(localg.dbd, localg.subType, i.Qc(localg.Dkb), bs.getInt(localg.Dlt, 0), localg.dbg);
              AppMethodBeat.o(151916);
              return;
            }
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { localg.Dkb });
            f.b.a(locals1, false, false);
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 4) || (locals1.field_status == 3))
          {
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", new Object[] { locals1.field_urlKey });
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
    ac.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + params.field_urlKey);
    k localk = this.Dkn;
    if (localk.aGF(params.field_urlKey))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      AppMethodBeat.o(151936);
      return;
    }
    localk.a(a.a(params));
    AppMethodBeat.o(151936);
  }
  
  final Set<b> eLG()
  {
    AppMethodBeat.i(151928);
    synchronized (this.Dkm)
    {
      Set localSet2 = Collections.newSetFromMap(new android.support.v4.e.a(this.Dkm.size()));
      localSet2.addAll(this.Dkm);
      AppMethodBeat.o(151928);
      return localSet2;
    }
  }
  
  public final void f(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151929);
    q.a.eMf().ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151910);
        s locals = q.a.eMf().aGI(i.jb(paramInt1, paramInt2));
        if ((locals != null) && ((-1 == paramInt3) || (String.valueOf(paramInt3).equals(locals.field_fileVersion)))) {
          if (paramBoolean) {
            break label79;
          }
        }
        label79:
        for (boolean bool = true;; bool = false)
        {
          locals.field_needRetry = bool;
          q.a.eMf().h(locals);
          AppMethodBeat.o(151910);
          return;
        }
      }
    });
    AppMethodBeat.o(151929);
  }
  
  final void g(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151942);
    if (q.a.eMf().handler == null)
    {
      ac.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      AppMethodBeat.o(151942);
      return;
    }
    q.a.eMf().handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151911);
        bm localbm = new bm();
        localbm.dbk.cZu = paramInt3;
        localbm.dbk.dbd = paramInt1;
        localbm.dbk.subType = paramInt2;
        localbm.dbk.dbj = paramBoolean;
        com.tencent.mm.sdk.b.a.GpY.l(localbm);
        AppMethodBeat.o(151911);
      }
    });
    AppMethodBeat.o(151942);
  }
  
  public static final class a
    implements com.tencent.mm.pluginsdk.h.a.c.g
  {
    private final com.tencent.mm.sdk.b.c DkC;
    private final cc.a DkD;
    private final h DkE;
    
    public a()
    {
      AppMethodBeat.i(151923);
      this.DkC = new com.tencent.mm.sdk.b.c() {};
      this.DkD = new cc.a()
      {
        public final void a(com.tencent.mm.ak.f.a paramAnonymousa)
        {
          AppMethodBeat.i(151921);
          paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
          if (bs.isNullOrNil(paramAnonymousa))
          {
            ac.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
            AppMethodBeat.o(151921);
            return;
          }
          ac.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(paramAnonymousa)));
          Map localMap;
          if (!bs.isNullOrNil(paramAnonymousa))
          {
            localMap = bv.L(paramAnonymousa, "sysmsg");
            j.A(0L, 0L);
            if (localMap != null) {
              break label167;
            }
            paramAnonymousa = "null";
            ac.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { paramAnonymousa });
            if (localMap != null) {
              break label180;
            }
            j.A(0L, 30L);
          }
          for (;;)
          {
            if ((localMap != null) && (localMap.size() > 0) && (bs.nullAsNil((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")))
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
        
        public final void a(f.c paramAnonymousc) {}
      };
      this.DkE = new h();
      AppMethodBeat.o(151923);
    }
    
    public final String azp()
    {
      return "CheckResUpdate";
    }
    
    public final n.a c(l paraml)
    {
      AppMethodBeat.i(151926);
      if (!(paraml instanceof c))
      {
        ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
        AppMethodBeat.o(151926);
        return null;
      }
      ac.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
      paraml = new d((c)paraml);
      AppMethodBeat.o(151926);
      return paraml;
    }
    
    public final void eLJ()
    {
      AppMethodBeat.i(151924);
      com.tencent.mm.sdk.b.a.GpY.c(this.DkC);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("resourcemgr", this.DkD, true);
      com.tencent.mm.kernel.g.agU().m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151922);
          p.bHP();
          AppMethodBeat.o(151922);
        }
      }, 10000L);
      AppMethodBeat.o(151924);
    }
    
    public final com.tencent.mm.pluginsdk.h.a.c.h eLK()
    {
      return this.DkE;
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(151925);
      com.tencent.mm.sdk.b.a.GpY.d(this.DkC);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("resourcemgr", this.DkD, true);
      AppMethodBeat.o(151925);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean eLL();
  }
  
  static final class c
  {
    private static final b DkG;
    
    static
    {
      AppMethodBeat.i(151927);
      DkG = new b((byte)0);
      AppMethodBeat.o(151927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.b
 * JD-Core Version:    0.7.0.1
 */