package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.StaticLayout;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.vending.d.b.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class av
  extends com.tencent.mm.vending.a.b<ax, n>
{
  private boolean DEBUG = false;
  bd dXx;
  volatile String jKL = "";
  Context mContext;
  volatile String oSZ = "";
  String peN;
  au pgm;
  private int pgn = (int)(System.currentTimeMillis() / 1000L);
  private com.tencent.mm.n.a pgo;
  private boolean pgp = false;
  volatile boolean pgq = false;
  byte[] pgr = new byte[0];
  protected HashMap<String, String> pgs = new HashMap();
  public HashMap<String, Boolean> pgt = new HashMap();
  private String pgu = "";
  private String pgv = "";
  
  public av()
  {
    super(new n());
    cKN();
  }
  
  private void a(int paramInt, ax paramax)
  {
    Object localObject1 = paramax.ojd.tKb;
    com.tencent.mm.kiss.widget.textview.a.a locala = com.tencent.mm.plugin.sns.ui.widget.b.bKA().getTextViewConfig();
    paramax.pgL = new com.tencent.mm.plugin.sns.data.d();
    if (this.DEBUG) {
      y.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + paramInt + " commentInfoList: " + ((List)localObject1).size() + " commentData:" + paramax.pgL.omT.size());
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (btd)((Iterator)localObject1).next();
      CharSequence localCharSequence = com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, (btd)localObject2, this.pgm.oWm, paramax.oje.field_type, paramax.oje.field_userName, 1);
      Object localObject3 = com.tencent.mm.kiss.widget.textview.c.dNE;
      if (locala != null)
      {
        localObject3 = (com.tencent.mm.kiss.widget.textview.b)((com.tencent.mm.kiss.widget.textview.c)localObject3).dNF.get(Integer.valueOf(com.tencent.mm.kiss.widget.textview.c.a(locala)));
        if (localObject3 != null)
        {
          localObject3 = (LinkedList)((com.tencent.mm.kiss.widget.textview.b)localObject3).dND.get(localCharSequence.toString());
          if ((localObject3 == null) || (((LinkedList)localObject3).size() == 0)) {
            paramInt = 0;
          }
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label249;
        }
        paramax.pgL.a((btd)localObject2, localCharSequence);
        break;
        paramInt = 1;
        continue;
        paramInt = 0;
      }
      label249:
      paramax.pgL.a((btd)localObject2, localCharSequence);
      paramInt = com.tencent.mm.plugin.sns.ui.widget.b.bKA().getViewWidth();
      if (paramInt > 0)
      {
        localObject2 = com.tencent.mm.kiss.widget.textview.d.a(localCharSequence, paramInt, locala).EF();
        com.tencent.mm.kiss.widget.textview.c.dNE.a(locala, (com.tencent.mm.kiss.widget.textview.f)localObject2);
      }
    }
  }
  
  private String d(bxk parambxk)
  {
    Object localObject;
    if (parambxk.tNr.sPI == 26) {
      localObject = this.mContext.getString(i.j.favorite);
    }
    String str;
    do
    {
      return localObject;
      if (parambxk.tNq == null) {
        return "";
      }
      if (bk.bl(parambxk.tNq.lsK)) {
        return "";
      }
      if (this.pgs.containsKey(parambxk.tNq.lsK)) {
        return (String)this.pgs.get(parambxk.tNq.lsK);
      }
      int i = bk.getInt(parambxk.tNq.hQE, 0);
      str = com.tencent.mm.pluginsdk.model.app.g.b(this.mContext, com.tencent.mm.pluginsdk.model.app.g.dh(parambxk.tNq.lsK, i), null);
      localObject = str;
    } while (bk.bl(str));
    this.pgs.put(parambxk.tNq.lsK, str);
    return str;
  }
  
  private static boolean e(bxk parambxk)
  {
    if (bk.bl(parambxk.tNs)) {}
    while ((am.a.bEf() & 0x2) <= 0) {
      return true;
    }
    return false;
  }
  
  private ax yT(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    y.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", new Object[] { Integer.valueOf(paramInt) });
    long l2 = System.currentTimeMillis();
    ax localax = new ax();
    n localn = (n)super.getItem(paramInt);
    if (localn == null)
    {
      y.printErrStackTrace("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mCount) });
      return localax;
    }
    bxk localbxk = localn.bGe();
    bto localbto = aj.q(localn);
    int j = au.E(localn);
    localax.amH = j;
    localax.pgP = localn.field_snsId;
    localax.pgT = localn.field_likeFlag;
    localax.pgU = localn.bGA();
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (localn.bGb() == null)
    {
      localObject1 = "";
      localax.pgV = ((String)localObject1);
      localax.oje = localn;
      localax.oji = localbxk;
      localax.ojd = localbto;
      localObject1 = localax.oji.tNo;
      localObject2 = this.mContext;
      com.tencent.mm.plugin.sns.ui.widget.d.bKB();
      localObject2 = com.tencent.mm.plugin.sns.ui.widget.e.a((Context)localObject2, (String)localObject1, com.tencent.mm.plugin.sns.ui.widget.d.getTextSize());
      localax.pgM = ((CharSequence)localObject2);
      i = com.tencent.mm.plugin.sns.ui.widget.d.bKB().getViewWidth();
      if (paramInt >= this.pgm.getCount()) {
        break label2896;
      }
      localObject3 = (n)super.getItem(paramInt);
      if ((localObject3 == null) || (!((n)localObject3).yr(32))) {
        break label2896;
      }
      localObject3 = ((n)localObject3).bFZ();
      if ((localObject3 == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject3).oBg != 1)) {
        break label2896;
      }
      i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    }
    label572:
    label581:
    label1225:
    label1354:
    label1484:
    label2381:
    label2896:
    for (;;)
    {
      if (this.DEBUG) {
        y.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + paramInt + " viewWidth: " + i + " desc:" + (String)localObject1);
      }
      localObject1 = com.tencent.mm.kiss.widget.textview.d.a((CharSequence)localObject2, i, com.tencent.mm.plugin.sns.ui.widget.d.bKB().getTextViewConfig()).EF();
      com.tencent.mm.kiss.widget.textview.c.dNE.a(com.tencent.mm.plugin.sns.ui.widget.d.bKB().getTextViewConfig(), (com.tencent.mm.kiss.widget.textview.f)localObject1);
      if (((com.tencent.mm.kiss.widget.textview.f)localObject1).dOj.getLineCount() > 7)
      {
        localObject1 = com.tencent.mm.kiss.widget.textview.d.a((CharSequence)localObject2, i, com.tencent.mm.plugin.sns.ui.widget.d.bKB().bKC()).EF();
        com.tencent.mm.kiss.widget.textview.c.dNE.a(com.tencent.mm.plugin.sns.ui.widget.d.bKB().bKC(), (com.tencent.mm.kiss.widget.textview.f)localObject1);
      }
      a(paramInt, localax);
      label509:
      Object localObject4;
      if (localax.oje.yr(32))
      {
        com.tencent.mm.plugin.sns.model.af.bDC().b(localn, null);
        d(localax.oji);
        localObject4 = localn.field_userName;
        localObject1 = this.dXx.abk((String)localObject4);
        if (!bk.bl((String)localObject4))
        {
          if (!((String)localObject4).equals(this.peN)) {
            break label2893;
          }
          if (this.pgo != null) {
            break label1277;
          }
          this.pgo = ((com.tencent.mm.n.a)localObject1);
        }
      }
      for (;;)
      {
        Object localObject5;
        label626:
        boolean bool1;
        if (localObject1 == null)
        {
          localObject2 = localObject4;
          localObject3 = localObject2;
          if (localn.yr(32))
          {
            localObject5 = localn.bFZ();
            localObject3 = localObject2;
            if (localObject5 != null)
            {
              if (!((com.tencent.mm.plugin.sns.storage.b)localObject5).oBA) {
                break label1296;
              }
              localObject3 = ((com.tencent.mm.plugin.sns.storage.b)localObject5).oBB;
            }
          }
          localax.hcm = ((String)localObject4);
          localax.phd = ((String)localObject3);
          localax.oNn = localn.yr(32);
          localax.oOM = localn.bGE();
          if (localObject1 != null) {
            break label1333;
          }
          bool1 = true;
          localax.phe = bool1;
          localax.pgN = ((com.tencent.mm.n.a)localObject1);
          localax.pgO = localn.bGk();
          localax.pgQ = localbxk.tNo;
          localax.pgR = localbxk.tNt;
          localax.pgS = localn.field_createTime;
          localax.pgW = ay.g(this.mContext, localax.pgS * 1000L);
          localax.phg = false;
          if ((j == 10) && (!q.Gj().equals(localbxk.hPY)) && (localbto.tKm != null) && (localbto.tKm.tKO != 0))
          {
            localax.phh = localbto.tKm.tKO;
            localax.phg = true;
          }
          if (!localax.oNn) {
            break label1360;
          }
          localObject1 = localn.bGb();
          if (localObject1 != null)
          {
            localax.phj = ((com.tencent.mm.plugin.sns.storage.a)localObject1).oAd;
            if (bk.bl(((com.tencent.mm.plugin.sns.storage.a)localObject1).oAe)) {
              break label1354;
            }
            bool1 = true;
            label854:
            localax.phk = bool1;
          }
          label861:
          localObject1 = d(localbxk);
          if ((!com.tencent.mm.plugin.sns.c.a.eUS.ct((String)localObject1)) || (!e(localbxk))) {
            break label1636;
          }
          localax.phl = true;
          if (localbxk.tNq != null) {
            break label1500;
          }
          bool1 = false;
        }
        for (;;)
        {
          localax.mAppName = ((String)localObject1);
          localax.phn = bool1;
          if ((localbxk.ouE != null) && (!bk.bl(localbxk.ouE.qTY)))
          {
            localax.mAppName = this.mContext.getString(i.j.top_story_share_app_brand_name);
            localax.phl = true;
          }
          label990:
          label1277:
          boolean bool2;
          if ((localax.hcm != null) && (localax.hcm.equals(this.peN)))
          {
            bool1 = true;
            localax.phf = bool1;
            localax.phr = localn.bGG();
            localax.phs = localn.bGw().tsu;
            localax.pht = false;
            if ((localbto != null) && (localax.phf))
            {
              i = localbto.ttI;
              if ((i == 3) || (i == 5)) {
                localax.pht = true;
              }
            }
            if (localbto == null) {
              break label2447;
            }
            if (localbto.tKe.size() > 0) {
              break label1712;
            }
            localax.phu = false;
            break label1897;
            if ((localbto.tKm == null) || (!q.Gj().equals(localbxk.hPY)) || (localbto.tKm.tKO <= 0)) {
              break label1972;
            }
            localax.phz = (com.tencent.mm.plugin.sns.lucky.a.m.b(localn, localbto) * 1.0D);
            localax.phy = localbto.tKm.tKO;
            localax.phx = true;
            localObject2 = new b.a();
            localObject3 = localbto.tKm.tKP.iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (btk)((Iterator)localObject3).next();
                localObject1 = this.dXx.abk(((btk)localObject4).sxM);
                if (localObject1 != null)
                {
                  localObject1 = bk.pm(((com.tencent.mm.n.a)localObject1).Bq());
                  ((b.a)localObject2).w(new com.tencent.mm.vending.j.a[] { com.tencent.mm.vending.j.a.r(((btk)localObject4).sxM, localObject1) });
                  continue;
                  localObject1 = localn.bGb().fVM;
                  break;
                  com.tencent.mm.plugin.sns.model.af.bDC().a(localn, null);
                  break label509;
                  localObject1 = this.pgo;
                  break label572;
                  localObject2 = ((com.tencent.mm.n.a)localObject1).Bq();
                  break label581;
                  localObject3 = localObject2;
                  if (!bk.bl((String)localObject2)) {
                    break label626;
                  }
                  localObject3 = localObject2;
                  if (bk.bl(((com.tencent.mm.plugin.sns.storage.b)localObject5).nickname)) {
                    break label626;
                  }
                  localObject3 = ((com.tencent.mm.plugin.sns.storage.b)localObject5).nickname;
                  break label626;
                  if ((int)((com.tencent.mm.n.a)localObject1).dBe == 0)
                  {
                    bool1 = true;
                    break label670;
                  }
                  bool1 = false;
                  break label670;
                  bool1 = false;
                  break label854;
                  label1360:
                  if (localbxk.tNp == null)
                  {
                    localObject1 = null;
                    label1371:
                    if (localbxk.tNp != null) {
                      break label1461;
                    }
                    localObject2 = null;
                    label1382:
                    if (bk.bl((String)localObject2)) {
                      break label1484;
                    }
                    if ((localn.field_snsId != 0L) || (bk.bl((String)localObject1))) {
                      break label1474;
                    }
                  }
                  for (localax.phj = ((String)localObject1 + "·" + (String)localObject2);; localax.phj = ((String)localObject2))
                  {
                    localax.phk = true;
                    break;
                    localObject1 = localbxk.tNp.ffj;
                    break label1371;
                    localObject2 = localbxk.tNp.lFn;
                    break label1382;
                  }
                  localax.phj = ((String)localObject1);
                  localax.phk = false;
                  break label861;
                  label1500:
                  if (this.pgt.containsKey(localbxk.tNq.lsK))
                  {
                    if (((Boolean)this.pgt.get(localbxk.tNq.lsK)).booleanValue()) {
                      break label2887;
                    }
                    bool1 = false;
                    break label907;
                  }
                  if (com.tencent.mm.pluginsdk.model.app.g.cu(localbxk.tNq.lsK)) {
                    if (localbxk.tNq.swJ == 0)
                    {
                      bool2 = false;
                      bool1 = false;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            this.pgt.put(localbxk.tNq.lsK, Boolean.valueOf(bool2));
            break;
            bool2 = true;
            bool1 = true;
            continue;
            bool2 = com.tencent.mm.pluginsdk.model.app.g.VR(localbxk.tNq.lsK);
            if (!bool2)
            {
              bool1 = false;
              continue;
              label1636:
              if ((!bk.bl(localbxk.tNs)) && (e(localbxk)))
              {
                localax.mAppName = ((String)localObject1);
                localax.phm = true;
                localax.php = localbxk.sbL;
                localax.pho = localbxk.tNs;
                break label921;
              }
              localax.phl = false;
              localax.phm = false;
              break label921;
              bool1 = false;
              break label990;
              if (this.peN.equals(localbto.sxM))
              {
                localax.phu = true;
                localObject2 = new StringBuffer();
                localObject3 = localbto.tKe.iterator();
                i = 0;
                if (((Iterator)localObject3).hasNext())
                {
                  localObject1 = (btd)((Iterator)localObject3).next();
                  if (i == 0)
                  {
                    i = 1;
                    ((StringBuffer)localObject2).append("  ");
                  }
                  for (;;)
                  {
                    if (((btd)localObject1).tqh == null) {
                      break label1825;
                    }
                    ((StringBuffer)localObject2).append(((btd)localObject1).tqh);
                    break;
                    ((StringBuffer)localObject2).append(",  ");
                  }
                  localObject4 = this.dXx.abk(((btd)localObject1).sxM);
                  if (localObject4 == null) {}
                  for (localObject1 = ((btd)localObject1).sxM;; localObject1 = ((com.tencent.mm.n.a)localObject4).Bq())
                  {
                    ((StringBuffer)localObject2).append((String)localObject1);
                    break;
                  }
                }
                localax.phv = ((StringBuffer)localObject2).toString();
                break label1083;
              }
              localObject1 = localbto.tKe.iterator();
              label1897:
              if (!((Iterator)localObject1).hasNext()) {
                break label1083;
              }
              localObject2 = (btd)((Iterator)localObject1).next();
              if (!this.peN.equals(((btd)localObject2).sxM)) {
                break label1082;
              }
              localax.phu = true;
              localax.phw = true;
              break label1083;
              localObject1 = bk.pm(((btk)localObject4).sxM);
              break label1225;
              localax.phA = ((b.a)localObject2).cKV();
              if (localbto.tJY.size() > 0)
              {
                localObject2 = new b.a();
                localObject3 = localbto.tJY.iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (btd)((Iterator)localObject3).next();
                  localObject1 = this.dXx.abk(((btd)localObject4).sxM);
                  if (localObject1 != null) {}
                  for (localObject1 = bk.pm(((com.tencent.mm.n.a)localObject1).Bq());; localObject1 = bk.pm(((btd)localObject4).sxM))
                  {
                    ((b.a)localObject2).w(new com.tencent.mm.vending.j.a[] { com.tencent.mm.vending.j.a.r(((btd)localObject4).sxM, localObject1) });
                    break;
                  }
                }
                localax.phB = ((b.a)localObject2).cKV();
              }
              if (localbto.tKb.size() > 0)
              {
                localObject2 = new b.a();
                localObject3 = localbto.tKb.iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  localObject5 = (btd)((Iterator)localObject3).next();
                  long l1;
                  if (((btd)localObject5).tJu != 0)
                  {
                    l1 = ((btd)localObject5).tJu;
                    label2172:
                    localObject4 = ((btd)localObject5).sxM;
                    if (!((btd)localObject5).sxM.equals(this.peN)) {
                      break label2390;
                    }
                    if (this.pgo != null) {
                      break label2381;
                    }
                    localObject1 = this.dXx.abk(((btd)localObject5).sxM);
                    this.pgo = ((com.tencent.mm.n.a)localObject1);
                    if (localObject1 == null) {
                      break label2409;
                    }
                    localObject1 = ((com.tencent.mm.n.a)localObject1).Bq();
                  }
                  for (;;)
                  {
                    String str = ((btd)localObject5).kVs;
                    localObject5 = (CharSequence)localax.pgL.omT.get(((btd)localObject5).tJu + "-" + ((btd)localObject5).tJx + "-" + ((btd)localObject5).kVs);
                    com.tencent.mm.vending.j.f localf = new com.tencent.mm.vending.j.f();
                    localf.a = new Object[] { Long.valueOf(l1), localObject4, localObject1, str, localObject5 };
                    ((b.a)localObject2).w(new com.tencent.mm.vending.j.a[] { (com.tencent.mm.vending.j.f)localf });
                    break;
                    l1 = ((btd)localObject5).tJx;
                    break label2172;
                    localObject1 = this.pgo;
                    break label2223;
                    label2390:
                    localObject1 = this.dXx.abk(((btd)localObject5).sxM);
                    break label2223;
                    label2409:
                    if (((btd)localObject5).tqh != null) {
                      localObject1 = ((btd)localObject5).tqh;
                    } else {
                      localObject1 = ((btd)localObject5).sxM;
                    }
                  }
                }
                localax.phC = ((b.a)localObject2).cKV();
              }
              af.a(this.mContext, localax, localbxk.ouC);
              if (localax.oNn)
              {
                localax.pgX = localn.bGb();
                localax.pgY = localn.bFZ();
                localObject1 = localn.bFZ();
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).oAF;
                  localax.pgZ = ((String)localObject1);
                }
              }
              else if (localax.oNn)
              {
                localObject3 = localax.pgX;
                if (localax.pgX.oAf != com.tencent.mm.plugin.sns.storage.a.ozR) {
                  break label2644;
                }
                localax.pha = ((com.tencent.mm.plugin.sns.storage.a)localObject3).oAg;
              }
              for (;;)
              {
                localObject1 = localn.bGw();
                localax.phF = ((awe)localObject1);
                if ((localObject1 != null) && (!q.Gj().equals(localbxk.hPY)) && (com.tencent.mm.plugin.sns.lucky.a.m.a(localn, localbto))) {
                  localax.phi = true;
                }
                y.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[] { Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l2) });
                return localax;
                localObject1 = "";
                break;
                label2644:
                if ((((com.tencent.mm.plugin.sns.storage.a)localObject3).oAf == com.tencent.mm.plugin.sns.storage.a.ozS) && (!bk.bl(((com.tencent.mm.plugin.sns.storage.a)localObject3).oAg)))
                {
                  localObject2 = "";
                  localObject4 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).oAi.iterator();
                  if (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (String)((Iterator)localObject4).next();
                    localObject1 = com.tencent.mm.plugin.sns.model.af.bDt().abk((String)localObject5);
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.n.a)localObject1).Bq();
                      if (!bk.bl((String)localObject1)) {
                        localObject1 = (String)localObject2 + (String)localObject1;
                      }
                    }
                    for (;;)
                    {
                      localObject2 = localObject1;
                      if (((com.tencent.mm.plugin.sns.storage.a)localObject3).oAi.getLast() == localObject5) {
                        break;
                      }
                      localObject2 = (String)localObject1 + ",";
                      break;
                      localObject1 = (String)localObject2 + (String)localObject5;
                      continue;
                      localObject1 = (String)localObject2 + (String)localObject5;
                    }
                  }
                  localax.phc = ((String)localObject2);
                  localax.phb = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject3).oAg, new Object[] { localObject2 });
                }
              }
            }
            bool1 = true;
          }
          bool1 = true;
        }
      }
    }
  }
  
  protected final Cursor bJN()
  {
    if (!this.pgp) {}
    label781:
    label786:
    label928:
    label1093:
    for (;;)
    {
      int k;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      synchronized (this.pgr)
      {
        this.jKL = v(0L, this.jKL);
        this.pgp = true;
        k = com.tencent.mm.plugin.sns.model.af.bDF().OO(this.jKL);
        y.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", new Object[] { Integer.valueOf(this.pgn), Integer.valueOf(k), this.jKL });
        if (this.pgn == k) {
          break label928;
        }
        ??? = com.tencent.mm.plugin.sns.model.af.bDI().dR(this.pgn, k);
        if ((??? == null) || (!((Cursor)???).moveToFirst())) {
          break label888;
        }
        Object localObject2 = new LinkedList();
        localObject4 = new com.tencent.mm.plugin.sns.storage.e();
        ((com.tencent.mm.plugin.sns.storage.e)localObject4).d((Cursor)???);
        localObject5 = ((com.tencent.mm.plugin.sns.storage.e)localObject4).bGl();
        localObject6 = new StringBuilder("ad xml ");
        Object localObject7 = ((n)localObject5).bGN();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(((n)localObject5).field_stringSeq);
        localStringBuffer.append(((com.tencent.mm.plugin.sns.storage.e)localObject7).field_adxml);
        localStringBuffer.append(" <createtime " + ((n)localObject5).field_createTime + ">");
        localStringBuffer.append(" <exposuretime " + ((com.tencent.mm.plugin.sns.storage.e)localObject7).field_exposureTime + ">");
        localStringBuffer.append(" <adcreatetime " + ((com.tencent.mm.plugin.sns.storage.e)localObject7).field_createAdTime + "> ");
        localStringBuffer.append(((com.tencent.mm.plugin.sns.storage.e)localObject7).bGe().tNo);
        y.d("MicroMsg.SnsTimeLineVendingSide", localStringBuffer.toString());
        l1 = 21600L;
        localObject6 = ((n)localObject5).bGb();
        i = ((n)localObject5).field_createTime;
        if ((((com.tencent.mm.plugin.sns.storage.e)localObject4).field_localFlag & 0x80) > 0)
        {
          bool = true;
          if (localObject6 == null) {
            break label1093;
          }
          if (!bool) {
            break label761;
          }
          l1 = 60L * ((com.tencent.mm.plugin.sns.storage.a)localObject6).ozV;
          i = ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_exposureTime;
          long l2 = bk.cn(i);
          if (l2 < l1) {
            break label786;
          }
          localObject6 = aj.q((n)localObject5);
          if (((n)localObject5).field_likeFlag == 0)
          {
            localObject6 = ((bto)localObject6).tKb.iterator();
            if (!((Iterator)localObject6).hasNext()) {
              break label781;
            }
            localObject7 = (btd)((Iterator)localObject6).next();
            if ((localObject7 == null) || (bk.bl(((btd)localObject7).sxM)) || (!((btd)localObject7).sxM.equals(this.peN))) {
              continue;
            }
          }
          j = 1;
          if (j != 0) {
            break label786;
          }
          com.tencent.mm.plugin.sns.model.af.bDI().delete(((n)localObject5).field_snsId);
          y.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + ((n)localObject5).field_snsId + " exposureTime: " + l1 + " field_createTime: " + ((n)localObject5).field_createTime + " checktime: " + l2 + " gettime: " + i + " isexposure " + bool + " exposureTime " + ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_exposureTime + " adCreateTIme:" + ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_createAdTime);
          if (!bool) {
            ((LinkedList)localObject2).add(localObject4);
          }
          if (((Cursor)???).moveToNext()) {
            continue;
          }
          if (((LinkedList)localObject2).size() <= 0) {
            break label888;
          }
          localObject4 = new LinkedList();
          localObject2 = ((LinkedList)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label864;
          }
          localObject5 = (com.tencent.mm.plugin.sns.storage.e)((Iterator)localObject2).next();
          localObject6 = new bj();
          ((bj)localObject6).sva = 13298;
          ((bj)localObject6).svb = new com.tencent.mm.bv.b(((com.tencent.mm.plugin.sns.storage.e)localObject5).bGb().ovV.getBytes());
          ((bj)localObject6).svc = (System.currentTimeMillis() / 1000L);
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      boolean bool = false;
      continue;
      label761:
      long l1 = 60L * ((com.tencent.mm.plugin.sns.storage.a)localObject6).ozU;
      int i = ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_createAdTime;
      continue;
      int j = 0;
      continue;
      l1 = ((n)localObject5).field_snsId;
      y.i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid " + l1);
      if (com.tencent.mm.plugin.sns.model.m.fS(l1))
      {
        localObject4 = new com.tencent.mm.plugin.sns.model.m(l1, 1, ((n)localObject5).bGb().oAu);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject4, 0);
        continue;
        label864:
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.sns.model.l((LinkedList)localObject4), 0);
        label888:
        if (??? != null)
        {
          y.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + ((Cursor)???).getCount());
          ((Cursor)???).close();
        }
        this.pgn = k;
        ??? = com.tencent.mm.plugin.sns.model.af.bDF().cv(this.jKL, k);
        y.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        com.tencent.mm.modelsns.b localb = com.tencent.mm.modelsns.b.jd(500);
        if (localb.QT())
        {
          i = this.c;
          if (i != 0) {
            break label1003;
          }
          localb.jg(0).jg(0).jg(0);
          localb.QX();
        }
        label1003:
        do
        {
          return ???;
          localObject4 = i.j((n)getItem(1));
          localObject5 = i.j((n)getItem(i - 1));
        } while ((((String)localObject4).equals(this.pgu)) && (((String)localObject5).equals(this.pgv)));
        this.pgu = ((String)localObject4);
        this.pgv = ((String)localObject5);
        localb.jg(i).ni((String)localObject4).ni((String)localObject5);
        localb.QX();
        return ???;
      }
    }
  }
  
  public final void bJj()
  {
    looperCheckForVending();
    long l;
    if (this.c == 0)
    {
      l = 0L;
      this.pgq = true;
    }
    for (;;)
    {
      synchronized (this.pgr)
      {
        this.jKL = v(l, this.jKL);
        return;
        int i = this.c - 1;
        int j = 0;
        ??? = (n)getItem(i);
        if ((??? != null) && (!((n)???).yr(32)) && (((n)???).field_snsId != 0L))
        {
          l = ((n)???).field_snsId;
          y.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[] { Long.valueOf(l), ((n)???).field_stringSeq });
          break;
        }
        j += 1;
        i -= 1;
        if ((i < 0) || (j > 500)) {
          l = 0L;
        }
      }
    }
  }
  
  public final void destroyAsynchronous()
  {
    super.destroyAsynchronous();
    com.tencent.mm.kiss.widget.textview.c.dNE.EE();
    this.pgt.clear();
    this.mContext = null;
    this.pgm = null;
    this.dXx = null;
    this.wsM = null;
  }
  
  final String v(long paramLong, String paramString)
  {
    y.d("MicroMsg.SnsTimeLineVendingSide", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.sns.model.af.bDv().bEe()), paramString });
    Object localObject = com.tencent.mm.plugin.sns.model.af.bDF();
    int i;
    String str;
    if (paramString.equals(""))
    {
      i = com.tencent.mm.plugin.sns.model.af.bDv().bEe() / 2;
      localObject = i.fO(((o)localObject).e(paramLong, i, false));
      str = this.oSZ;
      if (!str.equals("")) {
        break label122;
      }
      paramString = (String)localObject;
      label85:
      localObject = com.tencent.mm.plugin.sns.model.af.bDJ().OF("@__weixintimtline").bGv();
      if (((xs)localObject).sUt != 0L) {
        break label141;
      }
    }
    label122:
    do
    {
      return paramString;
      i = com.tencent.mm.plugin.sns.model.af.bDv().bEe();
      break;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(str) < 0) {
        break label85;
      }
      paramString = str;
      break label85;
      localObject = i.fO(((xs)localObject).sUt);
      if (paramString.equals("")) {
        return localObject;
      }
    } while (((String)localObject).compareTo(paramString) <= 0);
    label141:
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av
 * JD-Core Version:    0.7.0.1
 */