package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mm.ah.m;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.e;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.a.h;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public final class b
  implements com.tencent.mm.ah.f, c.a
{
  static int ooB = 0;
  private static final int ooC;
  public byte[] dIn = new byte[0];
  LinkedList<com.tencent.mm.plugin.sns.data.f> dtH = new LinkedList();
  Set<b.b> dup = new HashSet();
  private ah handler = null;
  private long ooD = 0L;
  private int ooE = 0;
  private int ooF = 2;
  private LinkedList<com.tencent.mm.plugin.sns.data.g> ooG = new LinkedList();
  public HashMap<String, Long> ooH = new HashMap();
  public boolean ooI = true;
  public Set<b.a> ooJ = new HashSet();
  private Map<String, Long> ooK = new ConcurrentHashMap();
  Map<String, com.tencent.mm.plugin.sns.data.c> ooL = new HashMap();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      ooC = i;
      return;
    }
  }
  
  public b()
  {
    bCK();
  }
  
  private boolean a(awd arg1, int paramInt, com.tencent.mm.plugin.sns.data.e parame, az paramaz, String paramString1, String paramString2)
  {
    if (!com.tencent.mm.plugin.sns.data.i.Nd(af.FU()))
    {
      y.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { af.FU(), com.tencent.mm.compatible.util.e.bkF });
      return false;
    }
    if ((???.lsK.startsWith("Locall_path")) || (???.lsK.startsWith("pre_temp_sns_pic")))
    {
      y.d("MicroMsg.DownloadManager", "is a local img not need download");
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.i.aH(paramInt, ???.lsK);
    for (;;)
    {
      synchronized (this.dIn)
      {
        if (!this.ooL.containsKey(str))
        {
          y.i("MicroMsg.DownloadManager", "add list %s", new Object[] { ???.lsK });
          this.ooL.put(str, new com.tencent.mm.plugin.sns.data.c(parame, paramInt));
          this.dtH.add(new com.tencent.mm.plugin.sns.data.f(???, paramInt, str, paramaz, paramString1, paramString2));
          continue;
          y.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[] { Integer.valueOf(af.bDE().bDj()), Integer.valueOf(this.ooK.size()) });
          y.v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", new Object[] { Integer.valueOf(this.ooL.size()), Integer.valueOf(this.ooL.size()), Integer.valueOf(this.ooG.size()) });
          if (Looper.myLooper() == null) {
            break label486;
          }
          Looper.myQueue().addIdleHandler(new b.c(this));
          if (bk.cn(this.ooD) * 1000L <= 300000L) {
            break label497;
          }
          paramInt = 1;
          if (paramInt != 0) {
            this.handler.postDelayed(new b.4(this), 500L);
          }
          parame = new LinkedList();
          synchronized (this.dIn)
          {
            paramaz = this.ooK.entrySet().iterator();
            if (!paramaz.hasNext()) {
              break;
            }
            parame.add(((Map.Entry)paramaz.next()).getKey());
          }
        }
        else
        {
          parame = this.dtH.iterator();
        }
        if (!parame.hasNext()) {
          continue;
        }
        paramaz = (com.tencent.mm.plugin.sns.data.f)parame.next();
        if ((!paramaz.bZK.lsK.equals(???.lsK)) || (paramaz.requestType != paramInt)) {
          continue;
        }
        if (this.dtH.remove(paramaz)) {
          this.dtH.addLast(paramaz);
        }
        y.v("MicroMsg.DownloadManager", "update the donwload list ");
      }
      label486:
      y.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
      continue;
      label497:
      paramInt = 0;
    }
    parame = parame.iterator();
    while (parame.hasNext())
    {
      paramaz = (String)parame.next();
      if ((this.ooK.containsKey(paramaz)) && (bk.cn(((Long)this.ooK.get(paramaz)).longValue()) * 1000L > 300000L))
      {
        y.d("MicroMsg.DownloadManager", "too long to download");
        this.ooK.remove(paramaz);
        this.ooL.remove(paramaz);
      }
    }
    if (this.dtH.size() > 0) {
      Om();
    }
    return true;
  }
  
  public static void bCI() {}
  
  public static boolean bCJ()
  {
    return false;
  }
  
  private void bCK()
  {
    synchronized (this.dIn)
    {
      this.dtH.clear();
      this.ooL.clear();
      this.ooK.clear();
      this.ooG.clear();
      this.ooH.clear();
      return;
    }
  }
  
  private boolean bCL()
  {
    synchronized (this.dIn)
    {
      if ((this.ooG != null) && (this.ooG.size() > 0))
      {
        com.tencent.mm.plugin.sns.data.g localg = (com.tencent.mm.plugin.sns.data.g)this.ooG.remove();
        new as().p(new com.tencent.mm.plugin.sns.data.g[] { localg });
        return true;
      }
      return false;
    }
  }
  
  public final boolean Nm(String paramString)
  {
    synchronized (this.dIn)
    {
      if (this.ooK.containsKey(com.tencent.mm.plugin.sns.data.i.aH(1, paramString))) {
        return true;
      }
      if (this.ooK.containsKey(com.tencent.mm.plugin.sns.data.i.aH(5, paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean Nn(String paramString)
  {
    synchronized (this.dIn)
    {
      return (this.ooK.containsKey(com.tencent.mm.plugin.sns.data.i.aH(2, paramString))) || (this.ooK.containsKey(com.tencent.mm.plugin.sns.data.i.aH(8, paramString)));
    }
  }
  
  public final void No(String paramString)
  {
    for (;;)
    {
      int i;
      synchronized (this.dIn)
      {
        y.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString });
        Object localObject1 = (com.tencent.mm.plugin.sns.data.c)this.ooL.get(paramString);
        com.tencent.mm.plugin.sns.data.e locale;
        Object localObject2;
        if (localObject1 != null)
        {
          locale = ((com.tencent.mm.plugin.sns.data.c)localObject1).omO;
          if (locale != null)
          {
            g localg = af.bDC();
            localObject2 = (awd)locale.list.get(0);
            i = 1;
            if (i >= locale.list.size()) {
              break label339;
            }
            localObject1 = (awd)locale.list.get(i);
            if ((paramString == null) || (paramString.indexOf(((awd)localObject1).lsK) < 0)) {
              break label342;
            }
            localObject2 = localObject1;
            String str1 = an.eJ(af.getAccSnsPath(), ((awd)localObject2).lsK);
            if (locale.omU != 0) {
              continue;
            }
            localObject1 = com.tencent.mm.plugin.sns.data.i.f((awd)localObject2);
            String str2 = com.tencent.mm.plugin.sns.data.i.aG(locale.omU, ((awd)localObject2).lsK);
            if (!localg.ooR.aC(str2)) {
              new g.b(localg, com.tencent.mm.plugin.sns.data.i.aG(locale.omU, ((awd)localObject2).lsK), str1 + (String)localObject1, str1, (awd)localObject2, locale.omU).p(new String[] { "" });
            }
          }
        }
        this.ooL.remove(paramString);
        return;
        if (locale.omU == 4)
        {
          localObject1 = com.tencent.mm.plugin.sns.data.i.g((awd)localObject2);
          continue;
        }
        if (locale.omU == 5)
        {
          localObject1 = com.tencent.mm.plugin.sns.data.i.g((awd)localObject2);
          continue;
        }
        if (locale.omU == 3)
        {
          localObject1 = com.tencent.mm.plugin.sns.data.i.l((awd)localObject2);
          continue;
        }
        localObject1 = com.tencent.mm.plugin.sns.data.i.e((awd)localObject2);
      }
      label339:
      continue;
      label342:
      i += 1;
    }
  }
  
  public final void Np(String paramString)
  {
    af.aXq().post(new b.5(this, paramString));
  }
  
  public final void Om()
  {
    if (!this.ooI) {}
    do
    {
      return;
      if (af.bDo())
      {
        bCK();
        return;
      }
    } while (!com.tencent.mm.plugin.sns.data.i.Nd(af.FU()));
    int i = this.ooF;
    if (com.tencent.mm.platformtools.ae.eSu > 0) {
      i = com.tencent.mm.platformtools.ae.eSu;
    }
    com.tencent.mm.plugin.sns.data.f localf;
    synchronized (this.dIn)
    {
      if ((this.dtH.size() <= 0) || (af.bDE().bDj() + this.ooK.size() > i)) {
        break label579;
      }
      y.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[] { Integer.valueOf(af.bDE().bDj()), Integer.valueOf(this.ooK.size()), Integer.valueOf(this.dtH.size()), Integer.valueOf(this.ooF) });
      localf = (com.tencent.mm.plugin.sns.data.f)this.dtH.removeLast();
      if (localf == null) {
        return;
      }
    }
    awd localawd = localf.bZK;
    i = localf.requestType;
    String str1 = localf.key;
    String str2 = localf.omV;
    String str3 = localf.omW;
    if ((!this.ooL.containsKey(str1)) || (this.ooL.get(str1) == null))
    {
      this.ooL.remove(str1);
      return;
    }
    com.tencent.mm.plugin.sns.data.e locale = ((com.tencent.mm.plugin.sns.data.c)this.ooL.get(str1)).omO;
    int j = i;
    boolean bool;
    Object localObject3;
    Object localObject2;
    label371:
    int k;
    if (i == 1)
    {
      j = i;
      if (localawd.omL)
      {
        j = 8;
        break label1245;
        bool = true;
        localObject3 = localawd.trP;
        localObject2 = localObject3;
        if (j == 7)
        {
          localObject2 = localObject3;
          if (!bk.bl(localawd.trZ)) {
            localObject2 = localawd.trZ;
          }
        }
        i = localawd.trQ;
        if ((bk.bl((String)localObject2)) && (localawd.hQR == 2))
        {
          localObject2 = localawd.kSC;
          i = localawd.trO;
          label1036:
          for (;;)
          {
            label923:
            if ((localObject2 == null) || (((String)localObject2).equals("")))
            {
              y.d("MicroMsg.DownloadManager", "url  " + (String)localObject2);
              k = 0;
              label412:
              if (k == 0)
              {
                this.ooL.remove(str1);
                return;
                label432:
                if (j == 6)
                {
                  bool = false;
                  localObject2 = localawd.trW;
                  i = localawd.trO;
                }
                else
                {
                  bool = false;
                  localObject2 = localawd.kSC;
                  i = localawd.trO;
                }
              }
              else
              {
                if (i != 2) {
                  break label1269;
                }
                if (!af.bDE().isDownloading(str1))
                {
                  y.d("MicroMsg.DownloadManager", "to downLoad scene " + localawd.lsK + "  " + (String)localObject2);
                  com.tencent.mm.kernel.g.DQ();
                  com.tencent.mm.kernel.g.DO().dJT.a(new p(localawd, localawd.lsK, (String)localObject2, localawd.hQR, bool, j, str1), 0);
                  af.bDE().NA(str1);
                }
                label579:
                label583:
                do
                {
                  return;
                  if (i == 0) {
                    y.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject2 + " isThumb :" + bool);
                  }
                } while (this.ooK.containsKey(str1));
                y.i("MicroMsg.DownloadManager", "to downLoad cdn " + localawd.lsK + "  " + (String)localObject2);
                if ((localawd != null) && (j != 6) && (j != 8) && (this.ooH.containsKey(str1)))
                {
                  long l = ((Long)this.ooH.get(str1)).longValue();
                  if (System.currentTimeMillis() - l < 300000L)
                  {
                    this.ooL.remove(str1);
                    y.w("MicroMsg.DownloadManager", "download error pass " + l + " url " + (String)localObject2 + " id: " + localawd.lsK);
                    return;
                  }
                }
                this.ooK.put(str1, Long.valueOf(bk.UX()));
                if ((j == 2) || (j == 8))
                {
                  com.tencent.mm.kernel.g.DQ();
                  i = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(68391, null), 0);
                  com.tencent.mm.kernel.g.DQ();
                  com.tencent.mm.kernel.g.DP().Dz().o(68391, Integer.valueOf(i + 1));
                }
                localObject3 = new com.tencent.mm.plugin.sns.model.a.a(localawd.lsK);
                ((com.tencent.mm.plugin.sns.model.a.a)localObject3).oqa = localawd;
                ((com.tencent.mm.plugin.sns.model.a.a)localObject3).ouK = localf.omX;
                if (j == 4)
                {
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).ouI = true;
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).url = ((String)localObject2);
                  i = localawd.hQR;
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).ouH = bool;
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).ouJ = j;
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).opZ = str1;
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).omO = locale;
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).omV = str2;
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).omW = str3;
                  localObject2 = null;
                  if ((j != 1) && (j != 5) && (j != 7)) {
                    break label1036;
                  }
                  localObject2 = new com.tencent.mm.plugin.sns.model.a.i(this, (com.tencent.mm.plugin.sns.model.a.a)localObject3);
                  label1007:
                  break;
                }
                for (;;)
                {
                  label1008:
                  ((com.tencent.mm.plugin.sns.model.a.c)localObject2).p(new String[] { "" });
                  break;
                  ((com.tencent.mm.plugin.sns.model.a.a)localObject3).ouI = false;
                  break label923;
                  if (j != 4) {
                    break label1287;
                  }
                  y.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                  localObject2 = com.tencent.mm.model.c.c.IX().fJ("100438");
                  bool = false;
                  if (((com.tencent.mm.storage.c)localObject2).isValid())
                  {
                    if (bk.getInt((String)((com.tencent.mm.storage.c)localObject2).ctr().get("CDNDownload"), 0) == 0) {
                      break label1281;
                    }
                    bool = true;
                  }
                  label1097:
                  y.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", new Object[] { Boolean.valueOf(localawd.omL), Boolean.valueOf(bool) });
                  if ((!localawd.omL) || (bool)) {
                    localObject2 = new com.tencent.mm.plugin.sns.model.a.g(this, (com.tencent.mm.plugin.sns.model.a.a)localObject3);
                  } else {
                    localObject2 = new h(this, (com.tencent.mm.plugin.sns.model.a.a)localObject3);
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.model.a.e(this, (com.tencent.mm.plugin.sns.model.a.a)localObject3);
      break label1008;
      if (j != 6) {
        break label1008;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject3).url = localawd.trW;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject3).bIW = localawd.trY;
      localObject2 = new com.tencent.mm.plugin.sns.model.a.d(this, (com.tencent.mm.plugin.sns.model.a.a)localObject3);
      break label1008;
      label1245:
      label1269:
      do
      {
        this.ooL.remove(str1);
        break label579;
        break label371;
        if ((j == 1) || (j == 5)) {
          break;
        }
        if (j != 7) {
          break label432;
        }
        break;
        k = 1;
        break label412;
        if (i == 1) {
          break label583;
        }
      } while (i != 0);
      break label583;
      label1281:
      bool = false;
      break label1097;
      label1287:
      if ((j != 2) && (j != 8)) {
        if (j != 3) {
          break label1007;
        }
      }
    }
  }
  
  public final void T(int paramInt, boolean paramBoolean)
  {
    this.ooF = paramInt;
    for (;;)
    {
      label122:
      int i;
      try
      {
        String str;
        if (aq.isWifi(com.tencent.mm.sdk.platformtools.ae.getContext()))
        {
          str = com.tencent.mm.m.g.AA().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!bk.bl(str)) || (!com.tencent.mm.sdk.a.b.cqk())) {
            break label445;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (bk.bl(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = bk.ZR(localObject[0]);
          paramInt = bk.ZR(localObject[1]) + paramInt * 60 - ((int)com.tencent.mm.plugin.sns.data.i.Nh() - 8) * 60;
          if (paramInt >= 0) {
            break label455;
          }
          paramInt += 1440;
          String[] arrayOfString1 = str.split(";");
          i = 0;
          label134:
          if (i >= arrayOfString1.length) {
            continue;
          }
          if (bk.bl(arrayOfString1[i])) {
            break label448;
          }
          localObject = arrayOfString1[i].split("-");
          if ((localObject == null) || (localObject.length < 4))
          {
            y.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[] { Integer.valueOf(i), str });
            break label448;
          }
        }
        else
        {
          str = com.tencent.mm.m.g.AA().getValue("SnsImgDownloadConcurrentCountForNotWifi");
          continue;
        }
        String[] arrayOfString2 = localObject[0].split(":");
        int j = bk.ZR(arrayOfString2[0]);
        j = bk.ZR(arrayOfString2[1]) + j * 60;
        arrayOfString2 = localObject[1].split(":");
        int k = bk.ZR(arrayOfString2[0]);
        k = bk.ZR(arrayOfString2[1]) + k * 60;
        y.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), localObject[2], localObject[3] });
        if ((paramInt > k) || (paramInt <= j)) {
          break label448;
        }
        if (paramBoolean)
        {
          localObject = localObject[2];
          j = bk.ZR((String)localObject);
          if (j <= 0) {
            break label448;
          }
          this.ooF = j;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { bk.j(localException) });
        y.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.ooF) });
        return;
      }
      Object localObject = localObject[3];
      continue;
      label445:
      label448:
      label455:
      do
      {
        break label122;
        break;
        i += 1;
        break label134;
      } while (paramInt < 1440);
      paramInt -= 1440;
    }
  }
  
  public final void a(int paramInt1, awd arg2, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    y.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b, requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???.lsK, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt3) });
    if (!af.bDo())
    {
      com.tencent.mm.kernel.g.DQ();
      if (com.tencent.mm.kernel.g.DN().Dc()) {}
    }
    else
    {
      bCK();
      return;
    }
    this.ooE += paramInt3;
    for (;;)
    {
      Object localObject2;
      synchronized (this.dIn)
      {
        if ((this.ooE <= 512000) || (this.dtH.size() != 0)) {
          break label546;
        }
        y.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.ooE) });
        am.a.dVz.bg(this.ooE, 0);
        this.ooE = 0;
        break label546;
        this.ooH.put(paramString, Long.valueOf(System.currentTimeMillis()));
        if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3))
        {
          ??? = af.bDC();
          y.d("MicroMsg.LazyerImageLoader2", "updateCache " + ???.lsK);
          localObject2 = com.tencent.mm.plugin.sns.data.i.aG(1, ???.lsK);
          localObject2 = (n)((g)???).ooR.get(localObject2);
          if (com.tencent.mm.plugin.sns.data.i.b((n)localObject2))
          {
            ((n)localObject2).Ff();
            y.d("MicroMsg.LazyerImageLoader2", "force update");
            af.bDs().post(new g.9((g)???, ???));
          }
        }
        ??? = this.dup.iterator();
        if (!((Iterator)???).hasNext()) {
          break label490;
        }
        localObject2 = (b.b)((Iterator)???).next();
        if (localObject2 == null) {
          continue;
        }
        if (paramInt1 == 2) {
          break label438;
        }
        if (paramInt2 == 3) {
          ((b.b)localObject2).bCt();
        }
      }
      if ((paramInt2 == 1) || (paramInt2 == 5) || (paramInt2 == 7)) {
        ((b.b)localObject2).Ni(???.lsK);
      } else if ((paramInt2 == 2) || (paramInt2 == 8)) {
        ((b.b)localObject2).ba(???.lsK, true);
      } else {
        label546:
        if ((paramInt2 == 4) || (paramInt2 == 6))
        {
          ((b.b)localObject2).bb(???.lsK, true);
          continue;
          label438:
          if ((paramInt2 == 2) || (paramInt2 == 8))
          {
            ((b.b)localObject2).ba(???.lsK, false);
          }
          else if ((paramInt2 == 4) || (paramInt2 == 6))
          {
            ((b.b)localObject2).bb(???.lsK, false);
            continue;
            label490:
            synchronized (this.dIn)
            {
              y.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s", new Object[] { paramString });
              this.ooK.remove(paramString);
              Om();
              No(paramString);
              return;
            }
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
    this.handler.post(new b.1(this, paramb));
  }
  
  public final boolean a(awd paramawd, int paramInt, com.tencent.mm.plugin.sns.data.e parame, az paramaz)
  {
    if (paramawd == null)
    {
      y.e("MicroMsg.DownloadManager", "unknow case media is null " + bk.csb().toString());
      return false;
    }
    synchronized (this.dIn)
    {
      av.NN(paramawd.lsK);
      a(paramawd, paramInt, parame, paramaz, null, null);
      return true;
    }
  }
  
  public final boolean a(awd paramawd, com.tencent.mm.plugin.sns.data.e parame, az paramaz, String paramString1, String paramString2)
  {
    if (paramawd == null)
    {
      y.e("MicroMsg.DownloadManager", "unknow case media is null " + bk.csb().toString());
      return false;
    }
    synchronized (this.dIn)
    {
      av.NN(paramawd.lsK);
      a(paramawd, 8, parame, paramaz, paramString1, paramString2);
      return true;
    }
  }
  
  public final void b(b.b paramb)
  {
    this.handler.post(new b.2(this, paramb));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    if (paramm.getType() != 208) {}
    for (;;)
    {
      return;
      paramString = (p)paramm;
      b.b localb;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if ((paramString.opX == 2) || (paramString.opX == 8))
        {
          paramm = this.dup.iterator();
          while (paramm.hasNext())
          {
            localb = (b.b)paramm.next();
            if (localb != null) {
              localb.ba(paramString.bUi, false);
            }
          }
        }
      }
      else if (paramm.getType() == 208)
      {
        paramm = this.dup.iterator();
        while (paramm.hasNext())
        {
          localb = (b.b)paramm.next();
          if (localb != null) {
            if (paramString.opX == 3) {
              localb.bCt();
            } else if ((paramString.opX == 1) || (paramString.opX == 5) || (paramString.opX == 7)) {
              localb.Ni(paramString.bUi);
            } else if ((paramString.opX == 2) || (paramString.opX == 8)) {
              localb.ba(paramString.bUi, true);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b
 * JD-Core Version:    0.7.0.1
 */