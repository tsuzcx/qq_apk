package com.tencent.mm.pluginsdk.j.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.br;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  private final Set<b> JYC;
  private final k JYD;
  private final com.tencent.mm.pluginsdk.j.a.c.d JYE;
  
  private b()
  {
    AppMethodBeat.i(151932);
    this.JYC = Collections.newSetFromMap(new android.support.v4.e.a(i.JZf.length));
    this.JYD = new k();
    this.JYE = new com.tencent.mm.pluginsdk.j.a.c.d()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.pluginsdk.j.a.c.m paramAnonymousm)
      {
        int j = 1;
        AppMethodBeat.i(151913);
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onFailed: %s", new Object[] { paramAnonymousString });
        i.bdY(paramAnonymousString);
        paramAnonymousString = q.a.goa().beg(paramAnonymousString);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(151913);
          return;
        }
        int i = j;
        if (paramAnonymousm != null)
        {
          i = j;
          if (paramAnonymousm.Kab != null)
          {
            if (!(paramAnonymousm.Kab instanceof com.tencent.mm.pluginsdk.j.a.b.a)) {
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
          j.a(paramAnonymousString.field_resType, paramAnonymousString.field_subType, paramAnonymousString.field_url, Util.getInt(paramAnonymousString.field_fileVersion, 0), j.a.JZs, false, "NewXml".equalsIgnoreCase(paramAnonymousString.field_groupId2), false, paramAnonymousString.field_sampleId);
          j.m(paramAnonymousString.field_resType, paramAnonymousString.field_subType, Util.getInt(paramAnonymousString.field_fileVersion, 0), (int)paramAnonymousString.field_reportId, 78);
          AppMethodBeat.o(151913);
          return;
          label182:
          i = j;
          if ((paramAnonymousm.Kab instanceof com.tencent.mm.pluginsdk.j.a.b.c))
          {
            j.F(paramAnonymousString.field_reportId, 16L);
            i = 0;
          }
        }
      }
      
      public final String avy()
      {
        return "CheckResUpdate";
      }
      
      public final void bdV(final String paramAnonymousString)
      {
        AppMethodBeat.i(151912);
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(paramAnonymousString)));
        com.tencent.mm.pluginsdk.j.a.c.s locals = q.a.goa().beg(paramAnonymousString);
        if (locals == null)
        {
          AppMethodBeat.o(151912);
          return;
        }
        j.F(locals.field_reportId, 10L);
        j.F(locals.field_reportId, 15L);
        j.m(locals.field_resType, locals.field_subType, Util.getInt(locals.field_fileVersion, 0), (int)locals.field_reportId, 77);
        if (((!locals.field_fileCompress) || (locals.field_fileEncrypt)) && (locals.field_fileUpdated)) {
          if (locals.field_maxRetryTimes <= locals.field_retryTimes) {
            break label290;
          }
        }
        label290:
        for (paramAnonymousString = j.a.JZt;; paramAnonymousString = j.a.JZr)
        {
          j.a(locals.field_resType, locals.field_subType, locals.field_url, Util.getInt(locals.field_fileVersion, 0), paramAnonymousString, true, Util.nullAsNil(locals.field_groupId2).equals("NewXml"), false, locals.field_sampleId);
          if ((locals.field_fileCompress) || (locals.field_fileEncrypt)) {
            break;
          }
          paramAnonymousString = new bp();
          paramAnonymousString.dEN.filePath = locals.field_filePath;
          paramAnonymousString.dEN.dER = locals.field_originalMd5;
          paramAnonymousString.dEN.dEQ = locals.field_fileUpdated;
          paramAnonymousString.dEN.dEP = Util.getInt(locals.field_fileVersion, 0);
          paramAnonymousString.dEN.dEO = locals.field_resType;
          paramAnonymousString.dEN.subType = locals.field_subType;
          q.a.goa().handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(223822);
              EventCenter.instance.publish(paramAnonymousString);
              AppMethodBeat.o(223822);
            }
          });
          locals.field_fileUpdated = false;
          q.a.goa().h(locals);
          AppMethodBeat.o(151912);
          return;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
        b.this.b(locals);
        AppMethodBeat.o(151912);
      }
      
      public final void bdW(String paramAnonymousString)
      {
        AppMethodBeat.i(151914);
        q localq = q.a.goa();
        if (localq.lsb) {}
        for (boolean bool = localq.Kal.bec(paramAnonymousString);; bool = false)
        {
          if (!bool) {
            i.bdY(paramAnonymousString);
          }
          AppMethodBeat.o(151914);
          return;
        }
      }
    };
    Object localObject1 = q.a.goa();
    com.tencent.mm.pluginsdk.j.a.c.d locald = this.JYE;
    Log.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { "CheckResUpdate", locald });
    if (((q)localObject1).lsb)
    {
      com.tencent.mm.pluginsdk.j.a.c.i locali = ((q)localObject1).Kam;
      Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(locald)));
      if (locald != null)
      {
        int i = "CheckResUpdate".hashCode();
        synchronized (locali.JZS)
        {
          List localList = (List)locali.JZR.get(i);
          localObject1 = localList;
          if (localList == null) {
            localObject1 = new LinkedList();
          }
          ((List)localObject1).add(locald);
          locali.JZR.put(i, localObject1);
          AppMethodBeat.o(151932);
          return;
        }
      }
    }
    AppMethodBeat.o(151932);
  }
  
  public static void ahP(int paramInt)
  {
    AppMethodBeat.i(151933);
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.kernel.g.aAf();
    boolean bool1 = com.tencent.mm.kernel.a.azo();
    boolean bool2 = bf.iDu.aA("login_user_name", "").equals("");
    if ((!bool1) && (bool2))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
      AppMethodBeat.o(151933);
      return;
    }
    m localm = new m(paramInt);
    com.tencent.mm.kernel.g.aAg().hqi.a(localm, 0);
    AppMethodBeat.o(151933);
  }
  
  static void c(com.tencent.mm.pluginsdk.j.a.c.s params)
  {
    AppMethodBeat.i(151937);
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { params.field_urlKey });
    k.g(params);
    AppMethodBeat.o(151937);
  }
  
  public static b gnC()
  {
    AppMethodBeat.i(169213);
    if (!MMApplicationContext.isMainProcess()) {
      Assert.fail("Inaccessible in child process.");
    }
    b localb = c.gnH();
    AppMethodBeat.o(169213);
    return localb;
  }
  
  public static String gnD()
  {
    AppMethodBeat.i(151935);
    Object localObject = q.a.goa().beg(i.kD(60, 3));
    if (localObject == null)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getOriginalMd5, %d.%d, get null info, return", new Object[] { Integer.valueOf(60), Integer.valueOf(3) });
      AppMethodBeat.o(151935);
      return null;
    }
    localObject = ((com.tencent.mm.pluginsdk.j.a.c.s)localObject).field_originalMd5;
    AppMethodBeat.o(151935);
    return localObject;
  }
  
  public static String kC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151934);
    com.tencent.mm.pluginsdk.j.a.c.s locals = q.a.goa().beg(i.kD(paramInt1, paramInt2));
    if (locals == null)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    Log.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[] { Boolean.valueOf(locals.field_deleted), locals.field_filePath, locals.field_md5, Boolean.valueOf(locals.field_fileCompress), Boolean.valueOf(locals.field_fileEncrypt), locals.field_originalMd5 });
    String str;
    if ((!locals.field_fileCompress) && (!locals.field_fileEncrypt))
    {
      if ((!locals.field_deleted) && (!Util.isNullOrNil(locals.field_filePath)) && (Util.nullAsNil(com.tencent.mm.vfs.s.bhK(locals.field_filePath)).equals(locals.field_md5)))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), locals.field_filePath });
        str = locals.field_filePath;
        AppMethodBeat.o(151934);
        return str;
      }
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(151934);
      return null;
    }
    if (locals.field_fileCompress) {
      str = locals.field_filePath + ".decompressed";
    }
    for (;;)
    {
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(151934);
        return null;
        if (locals.field_fileEncrypt) {
          str = locals.field_filePath + ".decrypted";
        }
      }
      else
      {
        if ((!Util.isNullOrNil(locals.field_originalMd5)) && (Util.nullAsNil(com.tencent.mm.vfs.s.bhK(str)).equals(locals.field_originalMd5)))
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str });
          AppMethodBeat.o(151934);
          return str;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, needDecrypt(%b) needDecompress(%b), file invalid, return null ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(locals.field_fileEncrypt), Boolean.valueOf(locals.field_fileCompress) });
        AppMethodBeat.o(151934);
        return null;
      }
      str = null;
    }
  }
  
  final void a(final int paramInt1, final int paramInt2, final String paramString1, final int paramInt3, final String paramString2)
  {
    AppMethodBeat.i(151941);
    q.a.goa().aj(new Runnable()
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
        Object localObject = i.kD(i, j);
        localObject = q.a.goa().beg((String)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(151918);
          return;
        }
        boolean bool = ((com.tencent.mm.pluginsdk.j.a.c.s)localObject).field_fileUpdated;
        ((com.tencent.mm.pluginsdk.j.a.c.s)localObject).field_fileUpdated = false;
        q.a.goa().h((com.tencent.mm.pluginsdk.j.a.c.s)localObject);
        if (k == Util.getInt(((com.tencent.mm.pluginsdk.j.a.c.s)localObject).field_fileVersion, 0))
        {
          if (q.a.goa().handler == null)
          {
            Log.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
            AppMethodBeat.o(151918);
            return;
          }
          q.a.goa().handler.post(new b.8(localb, i, j, str1, k, bool, str2));
        }
        AppMethodBeat.o(151918);
      }
    });
    AppMethodBeat.o(151941);
  }
  
  final void a(final int paramInt, final dov paramdov, final boolean paramBoolean)
  {
    AppMethodBeat.i(151938);
    final String str = i.kD(paramInt, paramdov.MJT);
    if (paramdov.MSk == null)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
      AppMethodBeat.o(151938);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(paramdov.MJT), Integer.valueOf(paramdov.MSk.MSu) });
    j.F(paramdov.MSm, 3L);
    final int i = paramdov.MSk.MSu;
    final int j = paramdov.MJT;
    final int k = paramdov.MSm;
    paramdov = paramdov.MSn;
    q.a.goa().aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151915);
        com.tencent.mm.pluginsdk.j.a.c.s locals = q.a.goa().beg(str);
        int i = paramInt;
        int j = j;
        int k = i;
        int m = k;
        String str1 = paramdov;
        boolean bool2 = paramBoolean;
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(locals)));
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
        boolean bool1 = false;
        String str2;
        if (locals != null) {
          if (Util.getInt(locals.field_fileVersion, 0) <= k)
          {
            bool1 = true;
            str2 = i.kD(i, j);
            String str3 = i.aee(str2);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
            if (!bool1) {
              break label443;
            }
            q.a.goa().Zb(str2);
            b.gnC().h(i, j, 2, bool2);
            if (!(com.tencent.mm.pluginsdk.j.a.d.a.bej(str3) & true & com.tencent.mm.pluginsdk.j.a.d.a.bej(str3 + ".decompressed") & com.tencent.mm.pluginsdk.j.a.d.a.bej(str3 + ".decrypted"))) {
              break label390;
            }
            if (locals != null)
            {
              j.F(locals.field_reportId, 21L);
              j.a(locals.field_resType, locals.field_subType, k, bool2, locals.field_sampleId);
            }
          }
        }
        for (;;)
        {
          if (locals != null) {
            break label420;
          }
          locals = new com.tencent.mm.pluginsdk.j.a.c.s();
          locals.field_urlKey = str2;
          locals.field_resType = i;
          locals.field_subType = j;
          locals.field_deleted = true;
          locals.field_fileVersion = String.valueOf(k);
          locals.field_reportId = m;
          locals.field_sampleId = str1;
          q.a.goa().h(locals);
          AppMethodBeat.o(151915);
          return;
          j.F(locals.field_reportId, 47L);
          j.F(locals.field_reportId, 22L);
          break;
          j.F(m, 47L);
          j.F(m, 22L);
          bool1 = true;
          break;
          label390:
          if (locals != null)
          {
            j.F(locals.field_reportId, 22L);
            j.F(locals.field_reportId, 47L);
          }
        }
        label420:
        locals.field_deleted = true;
        locals.field_fileVersion = String.valueOf(k);
        q.a.goa().h(locals);
        label443:
        AppMethodBeat.o(151915);
      }
    });
    AppMethodBeat.o(151938);
  }
  
  final void a(int paramInt, dov paramdov, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(151940);
    final String str = i.kD(paramInt, paramdov.MJT);
    if ((paramdov.MSl == null) || (Util.isNullOrNil(paramdov.MSl.MSt)))
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key invalid, resource=%d.%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramdov.MJT) });
      AppMethodBeat.o(151940);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Integer.valueOf(paramdov.MJT), Integer.valueOf(paramdov.MSl.MSs) });
    Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[] { paramdov.MSl.MSt });
    j.F(paramdov.MSm, 4L);
    paramdov = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151917);
        com.tencent.mm.pluginsdk.j.a.c.s locals = q.a.goa().beg(str);
        String str1 = this.JYN;
        String str2 = this.JYO;
        int i = this.JYP;
        int j = this.kPx;
        String str3 = this.JYL;
        boolean bool = paramBoolean2;
        if (locals == null)
        {
          locals = new com.tencent.mm.pluginsdk.j.a.c.s();
          locals.field_keyVersion = i;
          locals.field_encryptKey = str2;
          locals.field_reportId = j;
          locals.field_sampleId = str3;
          locals.field_originalMd5 = str1;
          q.a.goa().h(locals);
          j.F(j, 51L);
          j.F(j, 45L);
          AppMethodBeat.o(151917);
          return;
        }
        if (locals.field_keyVersion < i)
        {
          locals.field_keyVersion = i;
          locals.field_encryptKey = str2;
          locals.field_reportId = j;
          locals.field_sampleId = str3;
          if (Util.isNullOrNil(locals.field_originalMd5)) {
            locals.field_originalMd5 = str1;
          }
          q.a.goa().h(locals);
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
      paramdov.run();
      AppMethodBeat.o(151940);
      return;
    }
    q.a.goa().aj(paramdov);
    AppMethodBeat.o(151940);
  }
  
  public final void aP(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151930);
    g(paramInt1, paramInt2, paramInt3, true);
    AppMethodBeat.o(151930);
  }
  
  final void b(int paramInt, final dov paramdov, boolean paramBoolean)
  {
    AppMethodBeat.i(151939);
    final String str = i.kD(paramInt, paramdov.MJT);
    if (paramdov.MSk == null)
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", new Object[] { str });
      AppMethodBeat.o(151939);
      return;
    }
    int i = paramdov.MJT;
    int j = paramdov.MSk.MSu;
    if (paramdov.MSk.MSw == null) {}
    for (Object localObject = "null";; localObject = String.valueOf(paramdov.MSk.MSw.size()))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), localObject, Integer.valueOf(paramdov.MSm), paramdov.MSn, paramdov.MSk.Url, paramdov.MSk.MSx });
      if (paramdov.MSk.MSw == null) {
        break;
      }
      localObject = paramdov.MSk.MSw.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dyk localdyk = (dyk)((Iterator)localObject).next();
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[] { Integer.valueOf(localdyk.Version), localdyk.MYa.yO() });
      }
    }
    j.Mr(paramdov.MSm);
    if (!paramBoolean) {
      j.F(paramdov.MSm, 1L);
    }
    if ((paramdov.Lbj != 0) && (paramdov.Lbj <= Util.nowSecond()))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[] { str, Integer.valueOf(paramdov.Lbj), Integer.valueOf(paramdov.MSk.MSu) });
      j.F(paramdov.MSm, 14L);
      j.F(paramdov.MSm, 44L);
      j.a(paramInt, paramdov.MJT, paramdov.MSk.Url, paramdov.MSk.MSu, j.a.JZv, false, paramBoolean, false, paramdov.MSn);
      AppMethodBeat.o(151939);
      return;
    }
    if ((Util.isNullOrNil(paramdov.MSk.Url)) && (paramdov.MSk.MSx == null))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
      AppMethodBeat.o(151939);
      return;
    }
    localObject = new g.a(paramdov.MSk.Url);
    ((g.a)localObject).bea(str);
    ((g.a)localObject).dEO = paramInt;
    ((g.a)localObject).subType = paramdov.MJT;
    ((g.a)localObject).Ms(paramdov.Lbj);
    ((g.a)localObject).dEP = paramdov.MSk.MSu;
    ((g.a)localObject).beb(paramdov.MSk.MD5);
    ((g.a)localObject).JYZ = i.a.ahR(paramdov.MSk.MSv);
    ((g.a)localObject).JZa = i.a.ahQ(paramdov.MSk.MSv);
    ((g.a)localObject).IBJ = paramdov.MSm;
    ((g.a)localObject).JYz = paramdov.MSn;
    if (paramdov.MSo > 0) {}
    for (paramInt = paramdov.MSo;; paramInt = 3)
    {
      ((g.a)localObject).ahY(paramInt);
      ((g.a)localObject).JZb = paramdov.JZb;
      ((g.a)localObject).ahX(paramdov.MSp);
      ((g.a)localObject).dEU = paramBoolean;
      if (!Util.isNullOrNil(paramdov.MSk.MSw)) {
        ((g.a)localObject).JYx = ((dyk)paramdov.MSk.MSw.get(0)).MYa.zy;
      }
      if ((paramdov.MSl != null) && (!Util.isNullOrNil(paramdov.MSl.MSt)))
      {
        ((g.a)localObject).JYv = paramdov.MSl.MSt;
        ((g.a)localObject).JYw = paramdov.MSl.MSs;
      }
      if ((paramdov.MSk.MSx != null) && (paramdov.MSk.MSx.zy.length > 0)) {
        ((g.a)localObject).JYY = paramdov.MSk.MSx.toByteArray();
      }
      ((g.a)localObject).dER = paramdov.MSk.MSy;
      ((g.a)localObject).fileSize = paramdov.MSk.FileSize;
      ((g.a)localObject).ahZ(paramdov.MhZ);
      paramdov = ((g.a)localObject).gnK();
      Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[] { paramdov.toString() });
      q.a.goa().aj(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151916);
          com.tencent.mm.pluginsdk.j.a.c.s locals1 = q.a.goa().beg(str);
          g localg = paramdov;
          if (locals1 == null) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null, urlKey = %s", new Object[] { localg.JYs });
          }
          while ((locals1 != null) && (locals1.field_deleted) && (localg.bdX(locals1.field_fileVersion) <= 0))
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", new Object[] { locals1.field_fileVersion, localg.JZK });
            AppMethodBeat.o(151916);
            return;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", new Object[] { locals1.field_urlKey, locals1.field_url, Long.valueOf(locals1.field_contentLength), Boolean.valueOf(locals1.field_deleted), locals1.field_eccSignature, Long.valueOf(locals1.field_expireTime), Boolean.valueOf(locals1.field_fileCompress), Boolean.valueOf(locals1.field_fileEncrypt), locals1.field_filePath, Boolean.valueOf(locals1.field_fileUpdated), locals1.field_fileVersion, locals1.field_groupId2, Integer.valueOf(locals1.field_keyVersion), Boolean.valueOf(Util.isNullOrNil(locals1.field_encryptKey)), Integer.valueOf(locals1.field_maxRetryTimes), Integer.valueOf(locals1.field_retryTimes), locals1.field_sampleId, Integer.valueOf(locals1.field_status) });
            Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", new Object[] { locals1.field_encryptKey });
          }
          if (locals1 == null)
          {
            locals1 = localg.gnJ();
            locals1.field_fileUpdated = true;
            locals1.field_needRetry = true;
            if (Util.isNullOrNil(locals1.field_encryptKey)) {
              locals1.field_keyVersion = -1;
            }
            Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(locals1)));
            q.a.goa().h(locals1);
            b.gnC().h(localg.dEO, localg.subType, 0, localg.dEU);
            f.a.a(true, true, locals1, localg);
            AppMethodBeat.o(151916);
            return;
          }
          Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
          locals1.field_networkType = localg.networkType;
          if (Util.isNullOrNil(locals1.field_originalMd5)) {
            locals1.field_originalMd5 = localg.dER;
          }
          if (localg.bdX(locals1.field_fileVersion) > 0)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
            com.tencent.mm.pluginsdk.j.a.c.s locals2 = localg.gnJ();
            if (locals1.field_keyVersion >= localg.JYw)
            {
              locals2.field_keyVersion = locals1.field_keyVersion;
              locals2.field_encryptKey = locals1.field_encryptKey;
            }
            locals2.field_fileUpdated = true;
            locals2.field_needRetry = true;
            locals2.field_deleted = false;
            q.a.goa().h(locals2);
            b.gnC().h(localg.dEO, localg.subType, 0, localg.dEU);
            q.a.goa().Zb(localg.JYs);
            f.a.a(false, true, locals2, localg);
            AppMethodBeat.o(151916);
            return;
          }
          if ((localg.bdX(locals1.field_fileVersion) == 0) && (!locals1.field_needRetry))
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", new Object[] { Integer.valueOf(locals1.field_resType), Integer.valueOf(locals1.field_subType), locals1.field_fileVersion });
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 2) || (locals1.field_status == 1) || (locals1.field_status == 0))
          {
            long l = com.tencent.mm.pluginsdk.j.a.d.a.hv(locals1.field_filePath);
            if (locals1.field_contentLength > l)
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", new Object[] { Long.valueOf(locals1.field_contentLength), Long.valueOf(l) });
              if (0L == l)
              {
                b.gnC().h(localg.dEO, localg.subType, 0, localg.dEU);
                f.a.a(false, true, locals1, localg);
                AppMethodBeat.o(151916);
                return;
              }
              f.a.a(true, false, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            if (!Util.nullAsNil(com.tencent.mm.vfs.s.bhK(i.aee(localg.JYs))).equals(locals1.field_md5))
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
              f.a.a(false, true, locals1, localg);
              AppMethodBeat.o(151916);
              return;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", new Object[] { locals1.field_urlKey });
            locals1.field_status = 2;
            locals1.field_contentLength = com.tencent.mm.pluginsdk.j.a.d.a.hv(locals1.field_filePath);
            locals1.field_fileUpdated = false;
            locals1.field_reportId = localg.IBJ;
            q.a.goa().h(locals1);
            j.F(locals1.field_reportId, 13L);
            j.F(locals1.field_reportId, 44L);
            j.a(locals1.field_resType, locals1.field_subType, locals1.field_url, Util.getInt(locals1.field_fileVersion, 0), j.a.JZu, true, "NewXml".equalsIgnoreCase(locals1.field_groupId2), true, locals1.field_sampleId);
            if ((!localg.JYZ) && (!localg.JZa))
            {
              b.gnC().a(localg.dEO, localg.subType, i.aee(localg.JYs), Util.getInt(localg.JZK, 0), localg.dER);
              AppMethodBeat.o(151916);
              return;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", new Object[] { localg.JYs });
            f.b.a(locals1, false, false);
            AppMethodBeat.o(151916);
            return;
          }
          if ((locals1.field_status == 4) || (locals1.field_status == 3))
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", new Object[] { locals1.field_urlKey });
            f.a.a(false, true, locals1, localg);
          }
          AppMethodBeat.o(151916);
        }
      });
      AppMethodBeat.o(151939);
      return;
    }
  }
  
  final void b(com.tencent.mm.pluginsdk.j.a.c.s params)
  {
    AppMethodBeat.i(151936);
    Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + params.field_urlKey);
    k localk = this.JYD;
    if (localk.bed(params.field_urlKey))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
      AppMethodBeat.o(151936);
      return;
    }
    localk.a(a.a(params));
    AppMethodBeat.o(151936);
  }
  
  public final void g(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151929);
    q.a.goa().aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151910);
        com.tencent.mm.pluginsdk.j.a.c.s locals = q.a.goa().beg(i.kD(paramInt1, paramInt2));
        if ((locals != null) && ((-1 == paramInt3) || (String.valueOf(paramInt3).equals(locals.field_fileVersion)))) {
          if (paramBoolean) {
            break label79;
          }
        }
        label79:
        for (boolean bool = true;; bool = false)
        {
          locals.field_needRetry = bool;
          q.a.goa().h(locals);
          AppMethodBeat.o(151910);
          return;
        }
      }
    });
    AppMethodBeat.o(151929);
  }
  
  final Set<b> gnB()
  {
    AppMethodBeat.i(151928);
    synchronized (this.JYC)
    {
      Set localSet2 = Collections.newSetFromMap(new android.support.v4.e.a(this.JYC.size()));
      localSet2.addAll(this.JYC);
      AppMethodBeat.o(151928);
      return localSet2;
    }
  }
  
  final void h(final int paramInt1, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(151942);
    if (q.a.goa().handler == null)
    {
      Log.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
      AppMethodBeat.o(151942);
      return;
    }
    q.a.goa().handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151911);
        br localbr = new br();
        localbr.dEV.dDe = paramInt3;
        localbr.dEV.dEO = paramInt1;
        localbr.dEV.subType = paramInt2;
        localbr.dEV.dEU = paramBoolean;
        EventCenter.instance.publish(localbr);
        AppMethodBeat.o(151911);
      }
    });
    AppMethodBeat.o(151942);
  }
  
  public static final class a
    implements com.tencent.mm.pluginsdk.j.a.c.g
  {
    private final IListener JYT;
    private final cj.a JYU;
    private final h JYV;
    
    public a()
    {
      AppMethodBeat.i(151923);
      this.JYT = new IListener() {};
      this.JYU = new cj.a()
      {
        public final void a(h.a paramAnonymousa)
        {
          AppMethodBeat.i(151921);
          paramAnonymousa = z.a(paramAnonymousa.heO.KHn);
          if (Util.isNullOrNil(paramAnonymousa))
          {
            Log.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
            AppMethodBeat.o(151921);
            return;
          }
          Log.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(paramAnonymousa)));
          Map localMap;
          if (!Util.isNullOrNil(paramAnonymousa))
          {
            localMap = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
            j.F(0L, 0L);
            if (localMap != null) {
              break label168;
            }
            paramAnonymousa = "null";
            Log.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { paramAnonymousa });
            if (localMap != null) {
              break label181;
            }
            j.F(0L, 30L);
          }
          for (;;)
          {
            if ((localMap != null) && (localMap.size() > 0) && (Util.nullAsNil((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")))
            {
              e.j(".sysmsg", "delete", localMap);
              e.j(".sysmsg", "cache", localMap);
              e.j(".sysmsg", "decrypt", localMap);
            }
            AppMethodBeat.o(151921);
            return;
            label168:
            paramAnonymousa = String.valueOf(localMap.size());
            break;
            label181:
            j.F(0L, 31L);
          }
        }
        
        public final void a(h.c paramAnonymousc) {}
      };
      this.JYV = new h();
      AppMethodBeat.o(151923);
    }
    
    public final String avy()
    {
      return "CheckResUpdate";
    }
    
    public final n.a c(l paraml)
    {
      AppMethodBeat.i(151926);
      if (!(paraml instanceof c))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
        AppMethodBeat.o(151926);
        return null;
      }
      Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
      paraml = new d((c)paraml);
      AppMethodBeat.o(151926);
      return paraml;
    }
    
    public final void gnE()
    {
      AppMethodBeat.i(151924);
      EventCenter.instance.addListener(this.JYT);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("resourcemgr", this.JYU, true);
      com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(151922);
          p.cjR();
          AppMethodBeat.o(151922);
        }
      }, 10000L);
      AppMethodBeat.o(151924);
    }
    
    public final com.tencent.mm.pluginsdk.j.a.c.h gnF()
    {
      return this.JYV;
    }
    
    public final void onAccountRelease()
    {
      AppMethodBeat.i(151925);
      EventCenter.instance.removeListener(this.JYT);
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("resourcemgr", this.JYU, true);
      AppMethodBeat.o(151925);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean gnG();
  }
  
  static final class c
  {
    private static final b JYX;
    
    static
    {
      AppMethodBeat.i(151927);
      JYX = new b((byte)0);
      AppMethodBeat.o(151927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.b
 * JD-Core Version:    0.7.0.1
 */