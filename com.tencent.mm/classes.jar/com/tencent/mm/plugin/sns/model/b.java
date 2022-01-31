package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.i.h.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b
  implements com.tencent.mm.ai.f, c.a
{
  static int rcV = 0;
  private static final int rcW;
  Set<b.b> bLQ;
  public final byte[] eFQ;
  LinkedList<com.tencent.mm.plugin.sns.data.f> elu;
  private ak handler;
  private long rcX;
  private int rcY;
  private int rcZ;
  private LinkedList<com.tencent.mm.plugin.sns.data.g> rda;
  public HashMap<String, Long> rdb;
  private HashMap<String, String> rdc;
  public boolean rdd;
  public Set<b.a> rde;
  private Map<String, Long> rdf;
  Map<String, com.tencent.mm.plugin.sns.data.c> rdg;
  public ConcurrentHashMap<String, c> rdh;
  public CopyOnWriteArrayList<String> rdi;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      rcW = i;
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(36107);
    this.handler = null;
    this.rcX = 0L;
    this.rcY = 0;
    this.rcZ = 2;
    this.rda = new LinkedList();
    this.rdb = new HashMap();
    this.eFQ = new byte[0];
    this.rdc = new HashMap();
    this.rdd = true;
    this.bLQ = new HashSet();
    this.rde = new HashSet();
    this.elu = new LinkedList();
    this.rdf = new ConcurrentHashMap();
    this.rdg = new HashMap();
    this.rdh = new ConcurrentHashMap();
    this.rdi = new CopyOnWriteArrayList();
    this.handler = ag.bEf();
    coi();
    AppMethodBeat.o(36107);
  }
  
  private boolean Iu()
  {
    AppMethodBeat.i(36118);
    if (bo.gz(this.rcX) * 1000L > 300000L)
    {
      AppMethodBeat.o(36118);
      return true;
    }
    AppMethodBeat.o(36118);
    return false;
  }
  
  private boolean a(bcs parambcs, int paramInt, com.tencent.mm.plugin.sns.data.e parame, az paramaz, String paramString1, String paramString2)
  {
    AppMethodBeat.i(36112);
    if (!com.tencent.mm.plugin.sns.data.i.ZK(ag.getAccPath()))
    {
      ab.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { ag.getAccPath(), com.tencent.mm.compatible.util.e.eQx });
      AppMethodBeat.o(36112);
      return false;
    }
    if ((parambcs.Id.startsWith("Locall_path")) || (parambcs.Id.startsWith("pre_temp_sns_pic")))
    {
      ab.d("MicroMsg.DownloadManager", "is a local img not need download");
      AppMethodBeat.o(36112);
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.i.bd(paramInt, parambcs.Id);
    for (;;)
    {
      synchronized (this.eFQ)
      {
        if (!this.rdg.containsKey(str))
        {
          ab.i("MicroMsg.DownloadManager", "add list %s", new Object[] { parambcs.Id });
          this.rdg.put(str, new com.tencent.mm.plugin.sns.data.c(parame, paramInt));
          this.elu.add(new com.tencent.mm.plugin.sns.data.f(parambcs, paramInt, str, paramaz, paramString1, paramString2));
          continue;
          ab.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[] { Integer.valueOf(ag.cpe().coI()), Integer.valueOf(this.rdf.size()) });
          ab.v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", new Object[] { Integer.valueOf(this.rdg.size()), Integer.valueOf(this.rdg.size()), Integer.valueOf(this.rda.size()) });
          if (Looper.myLooper() == null) {
            break label430;
          }
          Looper.myQueue().addIdleHandler(new b.d(this));
          cok();
          col();
          if (this.elu.size() > 0) {
            ahb();
          }
          AppMethodBeat.o(36112);
          return true;
        }
        else
        {
          parame = this.elu.iterator();
        }
        if (!parame.hasNext()) {
          continue;
        }
        paramaz = (com.tencent.mm.plugin.sns.data.f)parame.next();
        if ((paramaz.cIc == null) || (!paramaz.cIc.Id.equals(parambcs.Id)) || (paramaz.requestType != paramInt)) {
          continue;
        }
        if (this.elu.remove(paramaz)) {
          this.elu.addLast(paramaz);
        }
        ab.v("MicroMsg.DownloadManager", "update the donwload list ");
      }
      label430:
      ab.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
    }
  }
  
  private static boolean aae(String paramString)
  {
    AppMethodBeat.i(36122);
    if ((paramString == null) || (paramString.equals("")))
    {
      ab.d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(36122);
      return false;
    }
    AppMethodBeat.o(36122);
    return true;
  }
  
  private void coi()
  {
    AppMethodBeat.i(36108);
    synchronized (this.eFQ)
    {
      this.elu.clear();
      this.rdg.clear();
      this.rdf.clear();
      this.rda.clear();
      this.rdb.clear();
      AppMethodBeat.o(36108);
      return;
    }
  }
  
  private boolean coj()
  {
    AppMethodBeat.i(36109);
    synchronized (this.eFQ)
    {
      if ((this.rda != null) && (this.rda.size() > 0))
      {
        com.tencent.mm.plugin.sns.data.g localg = (com.tencent.mm.plugin.sns.data.g)this.rda.remove();
        new at().v(new com.tencent.mm.plugin.sns.data.g[] { localg });
        AppMethodBeat.o(36109);
        return true;
      }
      AppMethodBeat.o(36109);
      return false;
    }
  }
  
  public final void a(int paramInt1, bcs parambcs, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(36124);
    if (parambcs == null) {}
    for (??? = Integer.valueOf(-1);; ??? = parambcs.Id)
    {
      ab.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt3) });
      if (!ag.coN())
      {
        com.tencent.mm.kernel.g.RM();
        if (com.tencent.mm.kernel.g.RJ().QU()) {
          break;
        }
      }
      coi();
      AppMethodBeat.o(36124);
      return;
    }
    if (paramInt1 != 2) {
      this.rcY += paramInt3;
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.eFQ)
      {
        if ((this.rcY <= 512000) || (this.elu.size() != 0)) {
          break label801;
        }
        ab.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.rcY) });
        ao.a.flJ.cq(this.rcY, 0);
        this.rcY = 0;
        break label801;
        if (paramBoolean2) {
          this.rdb.put(paramString, Long.valueOf(System.currentTimeMillis()));
        }
        if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3) && (parambcs != null))
        {
          ??? = ag.cpc();
          ab.d("MicroMsg.LazyerImageLoader2", "updateCache " + parambcs.Id);
          localObject2 = com.tencent.mm.plugin.sns.data.i.bc(1, parambcs.Id);
          localObject2 = (n)((g)???).rdp.get((String)localObject2);
          if (com.tencent.mm.plugin.sns.data.i.b((n)localObject2))
          {
            ((n)localObject2).XU();
            ab.d("MicroMsg.LazyerImageLoader2", "force update");
            ag.coS().execute(new g.2((g)???, parambcs));
          }
        }
        ??? = this.bLQ.iterator();
        if (!((Iterator)???).hasNext()) {
          break label587;
        }
        localObject2 = (b.b)((Iterator)???).next();
        if (localObject2 == null) {
          continue;
        }
        if ((paramInt1 == 2) || (parambcs == null)) {
          break label527;
        }
        if (paramInt2 == 3)
        {
          ((b.b)localObject2).cnV();
          continue;
          if ((paramInt1 != 1) && (paramInt1 != 3)) {
            continue;
          }
          this.rdb.put(paramString, Long.valueOf(System.currentTimeMillis()));
        }
      }
      if ((paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 5) || (paramInt2 == 7))
      {
        ((b.b)localObject2).ZU(parambcs.Id);
      }
      else if ((paramInt2 == 2) || (paramInt2 == 8))
      {
        ((b.b)localObject2).bp(parambcs.Id, true);
      }
      else if ((paramInt2 == 4) || (paramInt2 == 6))
      {
        ((b.b)localObject2).bq(parambcs.Id, true);
        continue;
        label527:
        if (((paramInt2 == 2) || (paramInt2 == 8)) && (parambcs != null))
        {
          ((b.b)localObject2).bp(parambcs.Id, false);
        }
        else if (((paramInt2 == 4) || (paramInt2 == 6)) && (parambcs != null))
        {
          ((b.b)localObject2).bq(parambcs.Id, false);
          continue;
          label587:
          long l;
          synchronized (this.eFQ)
          {
            ab.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, batchDownloaded %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
            if (paramBoolean2) {
              this.rdf.remove(paramString);
            }
            ahb();
            p(paramString, paramInt4, paramBoolean2);
            paramString = this.eFQ;
            if (parambcs == null) {}
          }
          label801:
          if (9 == paramInt2) {
            if (paramInt1 != 1) {
              if (paramInt1 != 3) {}
            }
          }
        }
      }
    }
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(36110);
    this.handler.post(new b.1(this, paramb));
    AppMethodBeat.o(36110);
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(36127);
    if ((!bo.isNullOrNil(paramString)) && (paramc != null))
    {
      c localc = (c)this.rdh.get(paramString);
      if ((localc == null) || (!localc.czw.equals(paramc.czw))) {
        this.rdh.put(paramString, paramc);
      }
    }
    AppMethodBeat.o(36127);
  }
  
  public final void a(String paramString1, String arg2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(145243);
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.field_mediaId = paramString1;
    localh.url = ???;
    localh.edJ = 1;
    localh.field_fileType = 100;
    localh.edE = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString3;
    localh.edQ = parama;
    o.alF().a(localh, false);
    synchronized (this.rdc)
    {
      this.rdc.put(paramString1, paramString3);
      AppMethodBeat.o(145243);
      return;
    }
  }
  
  public final boolean a(bcs parambcs, int paramInt, com.tencent.mm.plugin.sns.data.e parame, az paramaz)
  {
    AppMethodBeat.i(36113);
    if (parambcs == null)
    {
      ab.e("MicroMsg.DownloadManager", "unknow case media is null " + bo.dtY().toString());
      AppMethodBeat.o(36113);
      return false;
    }
    synchronized (this.eFQ)
    {
      aw.aaH(parambcs.Id);
      a(parambcs, paramInt, parame, paramaz, null, null);
      AppMethodBeat.o(36113);
      return true;
    }
  }
  
  public final boolean a(bcs parambcs, com.tencent.mm.plugin.sns.data.e parame, az paramaz, String paramString1, String paramString2)
  {
    AppMethodBeat.i(36114);
    if (parambcs == null)
    {
      ab.e("MicroMsg.DownloadManager", "unknow case media is null " + bo.dtY().toString());
      AppMethodBeat.o(36114);
      return false;
    }
    synchronized (this.eFQ)
    {
      aw.aaH(parambcs.Id);
      a(parambcs, 8, parame, paramaz, paramString1, paramString2);
      AppMethodBeat.o(36114);
      return true;
    }
  }
  
  public final void aaa(String paramString)
  {
    AppMethodBeat.i(36115);
    o.alF().j(paramString, null);
    synchronized (this.rdc)
    {
      this.rdc.remove(paramString);
      AppMethodBeat.o(36115);
      return;
    }
  }
  
  public final boolean aab(String paramString)
  {
    AppMethodBeat.i(36119);
    synchronized (this.eFQ)
    {
      if (this.rdf.containsKey(com.tencent.mm.plugin.sns.data.i.bd(1, paramString)))
      {
        AppMethodBeat.o(36119);
        return true;
      }
      if (this.rdf.containsKey(com.tencent.mm.plugin.sns.data.i.bd(5, paramString)))
      {
        AppMethodBeat.o(36119);
        return true;
      }
      AppMethodBeat.o(36119);
      return false;
    }
  }
  
  public final boolean aac(String paramString)
  {
    AppMethodBeat.i(36120);
    synchronized (this.eFQ)
    {
      if ((this.rdf.containsKey(com.tencent.mm.plugin.sns.data.i.bd(2, paramString))) || (this.rdf.containsKey(com.tencent.mm.plugin.sns.data.i.bd(8, paramString))))
      {
        AppMethodBeat.o(36120);
        return true;
      }
      AppMethodBeat.o(36120);
      return false;
    }
  }
  
  public final boolean aad(String paramString)
  {
    AppMethodBeat.i(145244);
    synchronized (this.rdc)
    {
      if (this.rdc.containsKey(paramString))
      {
        AppMethodBeat.o(145244);
        return true;
      }
      AppMethodBeat.o(145244);
      return false;
    }
  }
  
  public final void aaf(String paramString)
  {
    AppMethodBeat.i(36125);
    ag.bEf().post(new b.5(this, paramString));
    AppMethodBeat.o(36125);
  }
  
  public final c aag(String paramString)
  {
    AppMethodBeat.i(36128);
    if (!bo.isNullOrNil(paramString))
    {
      paramString = (c)this.rdh.remove(paramString);
      if (paramString != null) {
        paramString.com();
      }
      AppMethodBeat.o(36128);
      return paramString;
    }
    AppMethodBeat.o(36128);
    return null;
  }
  
  public final void aah(String paramString)
  {
    AppMethodBeat.i(36129);
    this.rdi.add(paramString);
    AppMethodBeat.o(36129);
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36106);
    this.rcZ = paramInt;
    for (;;)
    {
      label128:
      int i;
      try
      {
        String str;
        if (com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext()))
        {
          str = com.tencent.mm.m.g.Nq().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!bo.isNullOrNil(str)) || (!com.tencent.mm.sdk.a.b.dsf())) {
            break label457;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (bo.isNullOrNil(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = bo.apV(localObject[0]);
          paramInt = bo.apV(localObject[1]) + paramInt * 60 - ((int)com.tencent.mm.plugin.sns.data.i.afS() - 8) * 60;
          if (paramInt >= 0) {
            break label467;
          }
          paramInt += 1440;
          String[] arrayOfString1 = str.split(";");
          i = 0;
          label140:
          if (i >= arrayOfString1.length) {
            continue;
          }
          if (bo.isNullOrNil(arrayOfString1[i])) {
            break label460;
          }
          localObject = arrayOfString1[i].split("-");
          if ((localObject == null) || (localObject.length < 4))
          {
            ab.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[] { Integer.valueOf(i), str });
            break label460;
          }
        }
        else
        {
          str = com.tencent.mm.m.g.Nq().getValue("SnsImgDownloadConcurrentCountForNotWifi");
          continue;
        }
        String[] arrayOfString2 = localObject[0].split(":");
        int j = bo.apV(arrayOfString2[0]);
        j = bo.apV(arrayOfString2[1]) + j * 60;
        arrayOfString2 = localObject[1].split(":");
        int k = bo.apV(arrayOfString2[0]);
        k = bo.apV(arrayOfString2[1]) + k * 60;
        ab.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), localObject[2], localObject[3] });
        if ((paramInt > k) || (paramInt <= j)) {
          break label460;
        }
        if (paramBoolean)
        {
          localObject = localObject[2];
          j = bo.apV((String)localObject);
          if (j <= 0) {
            break label460;
          }
          this.rcZ = j;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { bo.l(localException) });
        ab.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.rcZ) });
        AppMethodBeat.o(36106);
        return;
      }
      Object localObject = localObject[3];
      continue;
      label457:
      label460:
      label467:
      do
      {
        break label128;
        break;
        i += 1;
        break label140;
      } while (paramInt < 1440);
      paramInt -= 1440;
    }
  }
  
  public final void ahb()
  {
    AppMethodBeat.i(36123);
    if (!this.rdd)
    {
      AppMethodBeat.o(36123);
      return;
    }
    if (ag.coN())
    {
      coi();
      AppMethodBeat.o(36123);
      return;
    }
    if (!com.tencent.mm.plugin.sns.data.i.ZK(ag.getAccPath()))
    {
      AppMethodBeat.o(36123);
      return;
    }
    int i = this.rcZ;
    if (com.tencent.mm.platformtools.ae.gkp > 0) {
      i = com.tencent.mm.platformtools.ae.gkp;
    }
    com.tencent.mm.plugin.sns.data.f localf;
    bcs localbcs;
    String str2;
    String str3;
    String str4;
    String str1;
    SparseArray localSparseArray1;
    com.tencent.mm.plugin.sns.data.e locale;
    SparseArray localSparseArray2;
    int j;
    Object localObject4;
    boolean bool1;
    label457:
    label487:
    Object localObject3;
    for (;;)
    {
      synchronized (this.eFQ)
      {
        Object localObject1;
        if ((this.elu.size() > 0) && (ag.cpe().coI() + this.rdf.size() <= i))
        {
          ab.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[] { Integer.valueOf(ag.cpe().coI()), Integer.valueOf(this.rdf.size()), Integer.valueOf(this.elu.size()), Integer.valueOf(this.rcZ) });
          localf = (com.tencent.mm.plugin.sns.data.f)this.elu.removeLast();
          if (localf == null)
          {
            AppMethodBeat.o(36123);
            return;
          }
          localbcs = localf.cIc;
          i = localf.requestType;
          str2 = localf.key;
          str3 = localf.rbk;
          str4 = localf.rbl;
          str1 = localf.czw;
          localSparseArray1 = localf.rbn;
          if ((!this.rdg.containsKey(str2)) || (this.rdg.get(str2) == null))
          {
            this.rdg.remove(str2);
            AppMethodBeat.o(36123);
            return;
          }
          locale = ((com.tencent.mm.plugin.sns.data.c)this.rdg.get(str2)).rbc;
          localSparseArray2 = ((com.tencent.mm.plugin.sns.data.c)this.rdg.get(str2)).rbd;
          j = i;
          if (i != 1) {
            break label1493;
          }
          j = i;
          if (!localbcs.raZ) {
            break label1493;
          }
          j = 8;
          break label1493;
          boolean bool2 = true;
          localObject1 = localbcs.xrS;
          localObject4 = localObject1;
          if (j == 7)
          {
            localObject4 = localObject1;
            if (!bo.isNullOrNil(localbcs.xsc)) {
              localObject4 = localbcs.xsc;
            }
          }
          int k = localbcs.xrT;
          i = k;
          localObject1 = localObject4;
          bool1 = bool2;
          if (bo.isNullOrNil((String)localObject4))
          {
            i = k;
            localObject1 = localObject4;
            bool1 = bool2;
            if (localbcs.jKs == 2)
            {
              localObject1 = localbcs.Url;
              i = localbcs.xrR;
              bool1 = bool2;
            }
          }
          if (!aae((String)localObject1))
          {
            this.rdg.remove(str2);
            AppMethodBeat.o(36123);
            return;
            if (j == 6)
            {
              bool1 = false;
              localObject1 = localbcs.xrZ;
              i = localbcs.xrR;
              continue;
            }
            if (j == 9)
            {
              localObject4 = (bcs)localSparseArray1.valueAt(0);
              bool1 = true;
              localObject1 = ((bcs)localObject4).xrS;
              i = ((bcs)localObject4).xrT;
              if ((!bo.isNullOrNil((String)localObject1)) || (((bcs)localObject4).jKs != 2)) {
                break label1490;
              }
              localObject1 = ((bcs)localObject4).Url;
              i = ((bcs)localObject4).xrR;
              break label1512;
            }
            bool1 = false;
            localObject1 = localbcs.Url;
            i = localbcs.xrR;
            continue;
          }
          if (i != 2) {
            continue;
          }
          if (!ag.cpe().isDownloading(str2))
          {
            ab.d("MicroMsg.DownloadManager", "to downLoad scene " + localbcs.Id + "  " + (String)localObject1);
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RK().eHt.a(new p(localbcs, localbcs.Id, (String)localObject1, localbcs.jKs, bool1, j, str2), 0);
            ag.cpe().aau(str2);
          }
        }
        label700:
        AppMethodBeat.o(36123);
        return;
        if ((i != 1) && (i != 0)) {
          break label1475;
        }
        if (i == 0) {
          ab.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject1 + " isThumb :" + bool1);
        }
        if (this.rdf.containsKey(str2)) {
          continue;
        }
        if (j == 9)
        {
          ab.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", new Object[] { str1 });
          if (((localbcs == null) && ((localSparseArray1 == null) || (localSparseArray1.size() <= 0))) || (j == 6) || (j == 8) || (!this.rdb.containsKey(str2))) {
            break;
          }
          long l = ((Long)this.rdb.get(str2)).longValue();
          if (System.currentTimeMillis() - l >= 300000L) {
            break;
          }
          this.rdg.remove(str2);
          localObject4 = new StringBuilder("no need download. lastTime: ").append(l).append(" url: ").append((String)localObject1).append(" id: ");
          if (localbcs == null)
          {
            localObject1 = str1;
            ab.i("MicroMsg.DownloadManager", (String)localObject1);
            AppMethodBeat.o(36123);
          }
        }
        else
        {
          ab.i("MicroMsg.DownloadManager", "to downLoad cdn " + localbcs.Id + "  " + (String)localObject1);
        }
      }
      localObject3 = localbcs.Id;
    }
    this.rdf.put(str2, Long.valueOf(bo.aox()));
    if ((j == 2) || (j == 8))
    {
      com.tencent.mm.kernel.g.RM();
      i = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(68391, null), 0);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(68391, Integer.valueOf(i + 1));
    }
    if (j == 9)
    {
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(str1, localSparseArray1, localSparseArray2, localf.size);
      label1122:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).rjD = localf.rbm;
      if (j != 4) {
        break label1275;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).rjB = true;
      label1143:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).rjA = bool1;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).rjC = j;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).reG = str2;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = ((String)localObject3);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).gr(str3, str4);
      localObject3 = null;
      if ((j != 1) && (j != 5) && (j != 7) && (j != 9)) {
        break label1284;
      }
      ab.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
      localObject3 = new com.tencent.mm.plugin.sns.model.a.i(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      label1224:
      break label1434;
    }
    for (;;)
    {
      label1225:
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).v(new String[] { "" });
      break;
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(localbcs.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).reH = localbcs;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).rbc = locale;
      break label1122;
      label1275:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).rjB = false;
      break label1143;
      label1284:
      if (j != 4) {
        break label1521;
      }
      ab.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
      localObject3 = com.tencent.mm.model.c.c.abU().me("100438");
      bool1 = false;
      if (((com.tencent.mm.storage.c)localObject3).isValid())
      {
        if (bo.getInt((String)((com.tencent.mm.storage.c)localObject3).dvN().get("CDNDownload"), 0) == 0) {
          break label1515;
        }
        bool1 = true;
      }
      label1345:
      ab.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", new Object[] { Boolean.valueOf(localbcs.raZ), Boolean.valueOf(bool1) });
      if ((!localbcs.raZ) || (bool1)) {
        localObject3 = new com.tencent.mm.plugin.sns.model.a.g(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      } else {
        localObject3 = new com.tencent.mm.plugin.sns.model.a.h(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      }
    }
    for (;;)
    {
      localObject3 = new com.tencent.mm.plugin.sns.model.a.e(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      break label1225;
      label1434:
      if (j != 6) {
        break label1225;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = localbcs.xrZ;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).cqq = localbcs.xsb;
      localObject3 = new com.tencent.mm.plugin.sns.model.a.d(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      break label1225;
      label1475:
      this.rdg.remove(str2);
      break label700;
      label1490:
      break label1512;
      label1493:
      if ((j == 1) || (j == 5)) {
        break;
      }
      if (j != 7) {
        break label487;
      }
      break;
      label1512:
      break label457;
      label1515:
      bool1 = false;
      break label1345;
      label1521:
      if ((j != 2) && (j != 8)) {
        if (j != 3) {
          break label1224;
        }
      }
    }
  }
  
  public final void b(b.b paramb)
  {
    AppMethodBeat.i(36111);
    this.handler.post(new b.2(this, paramb));
    AppMethodBeat.o(36111);
  }
  
  final void cok()
  {
    AppMethodBeat.i(36116);
    if (Iu()) {
      this.handler.postDelayed(new b.4(this), 500L);
    }
    AppMethodBeat.o(36116);
  }
  
  final void col()
  {
    AppMethodBeat.i(36117);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    synchronized (this.eFQ)
    {
      localObject2 = this.rdf.entrySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ((this.rdf.containsKey(localObject2)) && (bo.gz(((Long)this.rdf.get(localObject2)).longValue()) * 1000L > 300000L))
      {
        ab.d("MicroMsg.DownloadManager", "too long to download");
        this.rdf.remove(localObject2);
        this.rdg.remove(localObject2);
      }
    }
    AppMethodBeat.o(36117);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(36126);
    ab.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    if (paramm.getType() != 208)
    {
      AppMethodBeat.o(36126);
      return;
    }
    paramString = (p)paramm;
    b.b localb;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramString.reE == 2) || (paramString.reE == 8))
      {
        paramm = this.bLQ.iterator();
        while (paramm.hasNext())
        {
          localb = (b.b)paramm.next();
          if (localb != null) {
            localb.bp(paramString.cBO, false);
          }
        }
      }
      AppMethodBeat.o(36126);
      return;
    }
    if (paramm.getType() == 208)
    {
      paramm = this.bLQ.iterator();
      while (paramm.hasNext())
      {
        localb = (b.b)paramm.next();
        if (localb != null) {
          if (paramString.reE == 3) {
            localb.cnV();
          } else if ((paramString.reE == 1) || (paramString.reE == 5) || (paramString.reE == 7)) {
            localb.ZU(paramString.cBO);
          } else if ((paramString.reE == 2) || (paramString.reE == 8)) {
            localb.bp(paramString.cBO, true);
          }
        }
      }
    }
    AppMethodBeat.o(36126);
  }
  
  public final void p(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36121);
    synchronized (this.eFQ)
    {
      ab.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, Boolean.valueOf(paramBoolean) });
      Object localObject = (com.tencent.mm.plugin.sns.data.c)this.rdg.get(paramString);
      if (localObject != null)
      {
        if (9 != ((com.tencent.mm.plugin.sns.data.c)localObject).requestType) {
          break label134;
        }
        localObject = (com.tencent.mm.plugin.sns.data.e)((com.tencent.mm.plugin.sns.data.c)localObject).rbd.get(paramInt);
        if (localObject != null) {
          ag.cpc().a((com.tencent.mm.plugin.sns.data.e)localObject, paramString);
        }
      }
      label134:
      do
      {
        if (paramBoolean) {
          this.rdg.remove(paramString);
        }
        AppMethodBeat.o(36121);
        return;
        localObject = ((com.tencent.mm.plugin.sns.data.c)localObject).rbc;
      } while (localObject == null);
      ag.cpc().a((com.tencent.mm.plugin.sns.data.e)localObject, paramString);
    }
  }
  
  public static final class c
  {
    final String czw;
    private final byte[] eKs;
    boolean eRZ;
    private int fjZ;
    public boolean rdm;
    long startTime;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(36104);
      this.eKs = new byte[0];
      this.czw = paramString;
      this.fjZ = paramInt;
      this.startTime = -1L;
      this.rdm = false;
      this.eRZ = false;
      ab.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", new Object[] { paramString, Integer.valueOf(paramInt), this });
      AppMethodBeat.o(36104);
    }
    
    public final void com()
    {
      synchronized (this.eKs)
      {
        if (this.fjZ > 0) {
          this.fjZ -= 1;
        }
        if (this.fjZ == 0) {
          this.eRZ = true;
        }
        return;
      }
    }
    
    public final void setStartTime(long paramLong)
    {
      AppMethodBeat.i(138245);
      if (!this.rdm) {
        synchronized (this.eKs)
        {
          if (!this.rdm)
          {
            this.rdm = true;
            this.startTime = paramLong;
            ab.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", new Object[] { this.czw, Long.valueOf(this.startTime), this });
          }
          AppMethodBeat.o(138245);
          return;
        }
      }
      AppMethodBeat.o(138245);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b
 * JD-Core Version:    0.7.0.1
 */