package com.tencent.mm.plugin.sns.ui.a.b;

import android.content.Context;
import android.database.Cursor;
import android.text.StaticLayout;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.af;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.vending.d.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  extends b
{
  private boolean DEBUG = false;
  private bd fnD;
  private Context mContext;
  protected volatile String meP = "";
  protected volatile String rKW = "";
  private String rXD;
  private av sdP;
  private int sdQ = (int)(System.currentTimeMillis() / 1000L);
  private com.tencent.mm.n.a sdR;
  private boolean sdS = false;
  private volatile boolean sdT = false;
  private byte[] sdU = new byte[0];
  protected HashMap<String, String> sdV = new HashMap();
  public HashMap<String, Boolean> sdW = new HashMap();
  private String sdX = "";
  private String sdY = "";
  
  public a(n paramn)
  {
    super(paramn);
    dQd();
  }
  
  private aw Fg(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    ab.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", new Object[] { Integer.valueOf(paramInt) });
    long l2 = System.currentTimeMillis();
    aw localaw = new aw();
    n localn = (n)super.getItem(paramInt);
    if (localn == null)
    {
      ab.printErrStackTrace("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mCount) });
      return localaw;
    }
    TimeLineObject localTimeLineObject = localn.csh();
    SnsObject localSnsObject = ak.q(localn);
    int j = av.D(localn);
    localaw.aoW = j;
    localaw.rZw = localn.field_snsId;
    localaw.rZA = localn.field_likeFlag;
    localaw.rZB = localn.csD();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label249:
    boolean bool1;
    label260:
    int i;
    if (localn.csd() == null)
    {
      localObject1 = "";
      localaw.rZC = ((String)localObject1);
      localaw.qXp = localn;
      localaw.qXt = localTimeLineObject;
      localaw.qXo = localSnsObject;
      localObject2 = localaw.qXt.xTP;
      localObject3 = this.mContext;
      com.tencent.mm.plugin.sns.ui.widget.e.cxN();
      float f = com.tencent.mm.plugin.sns.ui.widget.e.getTextSize();
      if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(f.a.sqL)) {
        break label1328;
      }
      if (localaw.qXt != null) {
        break label1315;
      }
      localObject1 = "";
      if (!com.tencent.mm.plugin.sns.e.a.ZS((String)localObject1)) {
        break label1328;
      }
      bool1 = true;
      localObject1 = com.tencent.mm.plugin.sns.ui.widget.f.a((Context)localObject3, (String)localObject2, f, bool1);
      localaw.rZt = ((CharSequence)localObject1);
      i = com.tencent.mm.plugin.sns.ui.widget.e.cxN().getViewWidth();
      if (paramInt >= this.sdP.getCount()) {
        break label2923;
      }
      localObject3 = (n)super.getItem(paramInt);
      if ((localObject3 == null) || (!((n)localObject3).Ex(32))) {
        break label2923;
      }
      localObject3 = ((n)localObject3).csb();
      if ((localObject3 == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject3).rqq != 1)) {
        break label2923;
      }
      i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12);
    }
    label559:
    label720:
    label1366:
    label1895:
    label2408:
    label2923:
    for (;;)
    {
      if (this.DEBUG) {
        ab.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + paramInt + " viewWidth: " + i + " desc:" + (String)localObject2);
      }
      localObject2 = com.tencent.mm.kiss.widget.textview.d.a((CharSequence)localObject1, i, com.tencent.mm.plugin.sns.ui.widget.e.cxN().getTextViewConfig()).SK();
      com.tencent.mm.kiss.widget.textview.c.eLm.a(com.tencent.mm.plugin.sns.ui.widget.e.cxN().getTextViewConfig(), (com.tencent.mm.kiss.widget.textview.f)localObject2);
      if (((com.tencent.mm.kiss.widget.textview.f)localObject2).eLR.getLineCount() > 7)
      {
        localObject1 = com.tencent.mm.kiss.widget.textview.d.a((CharSequence)localObject1, i, com.tencent.mm.plugin.sns.ui.widget.e.cxN().cxO()).SK();
        com.tencent.mm.kiss.widget.textview.c.eLm.a(com.tencent.mm.plugin.sns.ui.widget.e.cxN().cxO(), (com.tencent.mm.kiss.widget.textview.f)localObject1);
      }
      a(paramInt, localaw);
      Object localObject4;
      if (localaw.qXp.Ex(32))
      {
        ag.cpc().b(localn, null);
        e(localaw.qXt);
        localObject4 = localn.field_userName;
        localObject1 = this.fnD.arv((String)localObject4);
        if (!bo.isNullOrNil((String)localObject4))
        {
          if (!((String)localObject4).equals(this.rXD)) {
            break label2920;
          }
          if (this.sdR != null) {
            break label1347;
          }
          this.sdR = ((com.tencent.mm.n.a)localObject1);
        }
      }
      for (;;)
      {
        label622:
        label631:
        Object localObject5;
        if (localObject1 == null)
        {
          localObject2 = localObject4;
          localObject3 = localObject2;
          if (localn.Ex(32))
          {
            localObject5 = localn.csb();
            localObject3 = localObject2;
            if (localObject5 != null)
            {
              if (!((com.tencent.mm.plugin.sns.storage.b)localObject5).rqL) {
                break label1366;
              }
              localObject3 = ((com.tencent.mm.plugin.sns.storage.b)localObject5).rqM;
            }
          }
          localaw.ikj = ((String)localObject4);
          localaw.rZK = ((String)localObject3);
          localaw.rEX = localn.Ex(32);
          localaw.rGx = localn.csH();
          if (localObject1 != null) {
            break label1403;
          }
          bool1 = true;
          localaw.rZL = bool1;
          localaw.rZu = ((com.tencent.mm.n.a)localObject1);
          localaw.rZv = localn.getSnsId();
          localaw.rZx = localTimeLineObject.xTP;
          localaw.rZy = localTimeLineObject.xTU;
          localaw.rZz = localn.field_createTime;
          localaw.rZD = ax.h(this.mContext, localaw.rZz * 1000L);
          localaw.rZN = false;
          if ((j == 10) && (!r.Zn().equals(localTimeLineObject.jJA)) && (localSnsObject.SnsRedEnvelops != null) && (localSnsObject.SnsRedEnvelops.xPd != 0))
          {
            localaw.rZO = localSnsObject.SnsRedEnvelops.xPd;
            localaw.rZN = true;
          }
          if (!localaw.rEX) {
            break label1430;
          }
          localObject1 = localn.csd();
          if (localObject1 != null)
          {
            localaw.rZQ = ((com.tencent.mm.plugin.sns.storage.a)localObject1).rpn;
            if (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject1).rpo)) {
              break label1424;
            }
            bool1 = true;
            localaw.rZR = bool1;
          }
          localObject1 = e(localTimeLineObject);
          if ((!com.tencent.mm.plugin.sns.c.a.gmP.dF((String)localObject1)) || (!f(localTimeLineObject))) {
            break label1706;
          }
          localaw.rZS = true;
          if (localTimeLineObject.xTR != null) {
            break label1570;
          }
          bool1 = false;
        }
        for (;;)
        {
          localaw.mAppName = ((String)localObject1);
          localaw.rZU = bool1;
          if ((localTimeLineObject.rjx != null) && (!bo.isNullOrNil(localTimeLineObject.rjx.uJi)))
          {
            localaw.mAppName = this.mContext.getString(2131304364);
            localaw.rZS = true;
          }
          label1133:
          label1134:
          label1276:
          boolean bool2;
          if ((localaw.ikj != null) && (localaw.ikj.equals(this.rXD)))
          {
            bool1 = true;
            localaw.rZM = bool1;
            localaw.rZY = localn.csJ();
            localaw.rZZ = localn.csz().xsx;
            localaw.saa = false;
            if ((localSnsObject != null) && (localaw.rZM))
            {
              i = localSnsObject.ExtFlag;
              if ((i == 3) || (i == 5)) {
                localaw.saa = true;
              }
            }
            if (localSnsObject == null) {
              break label2474;
            }
            if (localSnsObject.WithUserList.size() > 0) {
              break label1782;
            }
            localaw.sab = false;
            break label1967;
            if ((localSnsObject.SnsRedEnvelops == null) || (!r.Zn().equals(localTimeLineObject.jJA)) || (localSnsObject.SnsRedEnvelops.xPd <= 0)) {
              break label2042;
            }
            localaw.sag = (com.tencent.mm.plugin.sns.lucky.a.m.b(localn, localSnsObject) * 1.0D);
            localaw.saf = localSnsObject.SnsRedEnvelops.xPd;
            localaw.sae = true;
            localObject2 = new b.a();
            localObject3 = localSnsObject.SnsRedEnvelops.xPe.iterator();
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (cea)((Iterator)localObject3).next();
                localObject1 = this.fnD.arv(((cea)localObject4).Username);
                if (localObject1 != null)
                {
                  localObject1 = bo.nullAsNil(((com.tencent.mm.n.a)localObject1).Of());
                  ((b.a)localObject2).B(new com.tencent.mm.vending.j.a[] { com.tencent.mm.vending.j.a.C(((cea)localObject4).Username, localObject1) });
                  continue;
                  localObject1 = localn.csd().hpq;
                  break;
                  localObject1 = localaw.qXt.jJA;
                  break label249;
                  bool1 = false;
                  break label260;
                  ag.cpc().a(localn, null);
                  break label559;
                  localObject1 = this.sdR;
                  break label622;
                  localObject2 = ((com.tencent.mm.n.a)localObject1).Of();
                  break label631;
                  localObject3 = localObject2;
                  if (!bo.isNullOrNil((String)localObject2)) {
                    break label676;
                  }
                  localObject3 = localObject2;
                  if (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject5).nickname)) {
                    break label676;
                  }
                  localObject3 = ((com.tencent.mm.plugin.sns.storage.b)localObject5).nickname;
                  break label676;
                  label1403:
                  if ((int)((com.tencent.mm.n.a)localObject1).euF == 0)
                  {
                    bool1 = true;
                    break label720;
                  }
                  bool1 = false;
                  break label720;
                  bool1 = false;
                  break label905;
                  if (localTimeLineObject.xTQ == null)
                  {
                    localObject1 = null;
                    if (localTimeLineObject.xTQ != null) {
                      break label1531;
                    }
                    localObject2 = null;
                    if (bo.isNullOrNil((String)localObject2)) {
                      break label1554;
                    }
                    if ((localn.field_snsId != 0L) || (bo.isNullOrNil((String)localObject1))) {
                      break label1544;
                    }
                  }
                  for (localaw.rZQ = ((String)localObject1 + "·" + (String)localObject2);; localaw.rZQ = ((String)localObject2))
                  {
                    localaw.rZR = true;
                    break;
                    localObject1 = localTimeLineObject.xTQ.gwR;
                    break label1441;
                    label1531:
                    localObject2 = localTimeLineObject.xTQ.eSM;
                    break label1452;
                  }
                  localaw.rZQ = ((String)localObject1);
                  localaw.rZR = false;
                  break label912;
                  if (this.sdW.containsKey(localTimeLineObject.xTR.Id))
                  {
                    if (((Boolean)this.sdW.get(localTimeLineObject.xTR.Id)).booleanValue()) {
                      break label2914;
                    }
                    bool1 = false;
                    break label958;
                  }
                  if (com.tencent.mm.pluginsdk.model.app.g.dG(localTimeLineObject.xTR.Id)) {
                    if (localTimeLineObject.xTR.wpL == 0)
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
            this.sdW.put(localTimeLineObject.xTR.Id, Boolean.valueOf(bool2));
            break;
            bool2 = true;
            bool1 = true;
            continue;
            bool2 = com.tencent.mm.pluginsdk.model.app.g.alp(localTimeLineObject.xTR.Id);
            if (!bool2)
            {
              bool1 = false;
              continue;
              if ((!bo.isNullOrNil(localTimeLineObject.xTT)) && (f(localTimeLineObject)))
              {
                localaw.mAppName = ((String)localObject1);
                localaw.rZT = true;
                localaw.rZW = localTimeLineObject.vSR;
                localaw.rZV = localTimeLineObject.xTT;
                break label972;
              }
              localaw.rZS = false;
              localaw.rZT = false;
              break label972;
              bool1 = false;
              break label1041;
              label1782:
              if (this.rXD.equals(localSnsObject.Username))
              {
                localaw.sab = true;
                localObject2 = new StringBuffer();
                localObject3 = localSnsObject.WithUserList.iterator();
                i = 0;
                if (((Iterator)localObject3).hasNext())
                {
                  localObject1 = (cds)((Iterator)localObject3).next();
                  if (i == 0)
                  {
                    i = 1;
                    ((StringBuffer)localObject2).append("  ");
                  }
                  for (;;)
                  {
                    if (((cds)localObject1).Nickname == null) {
                      break label1895;
                    }
                    ((StringBuffer)localObject2).append(((cds)localObject1).Nickname);
                    break;
                    ((StringBuffer)localObject2).append(",  ");
                  }
                  localObject4 = this.fnD.arv(((cds)localObject1).Username);
                  if (localObject4 == null) {}
                  for (localObject1 = ((cds)localObject1).Username;; localObject1 = ((com.tencent.mm.n.a)localObject4).Of())
                  {
                    ((StringBuffer)localObject2).append((String)localObject1);
                    break;
                  }
                }
                localaw.sac = ((StringBuffer)localObject2).toString();
                break label1134;
              }
              localObject1 = localSnsObject.WithUserList.iterator();
              if (!((Iterator)localObject1).hasNext()) {
                break label1134;
              }
              localObject2 = (cds)((Iterator)localObject1).next();
              if (!this.rXD.equals(((cds)localObject2).Username)) {
                break label1133;
              }
              localaw.sab = true;
              localaw.sad = true;
              break label1134;
              localObject1 = bo.nullAsNil(((cea)localObject4).Username);
              break label1276;
              localaw.sah = ((b.a)localObject2).dQl();
              label2042:
              if (localSnsObject.LikeUserList.size() > 0)
              {
                localObject2 = new b.a();
                localObject3 = localSnsObject.LikeUserList.iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (cds)((Iterator)localObject3).next();
                  localObject1 = this.fnD.arv(((cds)localObject4).Username);
                  if (localObject1 != null) {}
                  for (localObject1 = bo.nullAsNil(((com.tencent.mm.n.a)localObject1).Of());; localObject1 = bo.nullAsNil(((cds)localObject4).Username))
                  {
                    ((b.a)localObject2).B(new com.tencent.mm.vending.j.a[] { com.tencent.mm.vending.j.a.C(((cds)localObject4).Username, localObject1) });
                    break;
                  }
                }
                localaw.sai = ((b.a)localObject2).dQl();
              }
              if (localSnsObject.CommentUserList.size() > 0)
              {
                localObject2 = new b.a();
                localObject3 = localSnsObject.CommentUserList.iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (cds)((Iterator)localObject3).next();
                  long l1;
                  if (((cds)localObject4).xNY != 0)
                  {
                    l1 = ((cds)localObject4).xNY;
                    localObject5 = ((cds)localObject4).Username;
                    if (!((cds)localObject4).Username.equals(this.rXD)) {
                      break label2417;
                    }
                    if (this.sdR != null) {
                      break label2408;
                    }
                    localObject1 = this.fnD.arv(((cds)localObject4).Username);
                    this.sdR = ((com.tencent.mm.n.a)localObject1);
                    label2293:
                    if (localObject1 == null) {
                      break label2436;
                    }
                    localObject1 = ((com.tencent.mm.n.a)localObject1).Of();
                  }
                  for (;;)
                  {
                    ((b.a)localObject2).B(new com.tencent.mm.vending.j.a[] { com.tencent.mm.vending.j.a.b(Long.valueOf(l1), localObject5, localObject1, ((cds)localObject4).ntu, (CharSequence)localaw.rZs.rbi.get(((cds)localObject4).xNY + "-" + ((cds)localObject4).xOa + "-" + ((cds)localObject4).ntu)) });
                    break;
                    l1 = ((cds)localObject4).xOa;
                    break label2242;
                    localObject1 = this.sdR;
                    break label2293;
                    label2417:
                    localObject1 = this.fnD.arv(((cds)localObject4).Username);
                    break label2293;
                    if (((cds)localObject4).Nickname != null) {
                      localObject1 = ((cds)localObject4).Nickname;
                    } else {
                      localObject1 = ((cds)localObject4).Username;
                    }
                  }
                }
                localaw.saj = ((b.a)localObject2).dQl();
              }
              af.a(this.mContext, localaw, localTimeLineObject.rjv);
              if (localaw.rEX)
              {
                localaw.rZE = localn.csd();
                localaw.rZF = localn.csb();
                localObject1 = localn.csb();
                if (localObject1 != null)
                {
                  localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).rpP;
                  localaw.rZG = ((String)localObject1);
                }
              }
              else if (localaw.rEX)
              {
                localObject3 = localaw.rZE;
                if (localaw.rZE.rpp != com.tencent.mm.plugin.sns.storage.a.rpb) {
                  break label2671;
                }
                localaw.rZH = ((com.tencent.mm.plugin.sns.storage.a)localObject3).rpq;
              }
              for (;;)
              {
                localObject1 = localn.csz();
                localaw.sam = ((bct)localObject1);
                if ((localObject1 != null) && (!r.Zn().equals(localTimeLineObject.jJA)) && (com.tencent.mm.plugin.sns.lucky.a.m.a(localn, localSnsObject))) {
                  localaw.rZP = true;
                }
                ab.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[] { Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l2) });
                return localaw;
                localObject1 = "";
                break;
                label2671:
                if ((((com.tencent.mm.plugin.sns.storage.a)localObject3).rpp == com.tencent.mm.plugin.sns.storage.a.rpc) && (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject3).rpq)))
                {
                  localObject2 = "";
                  localObject4 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).rps.iterator();
                  if (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (String)((Iterator)localObject4).next();
                    localObject1 = ag.coT().arv((String)localObject5);
                    if (localObject1 != null)
                    {
                      localObject1 = ((com.tencent.mm.n.a)localObject1).Of();
                      if (!bo.isNullOrNil((String)localObject1)) {
                        localObject1 = (String)localObject2 + (String)localObject1;
                      }
                    }
                    for (;;)
                    {
                      localObject2 = localObject1;
                      if (((com.tencent.mm.plugin.sns.storage.a)localObject3).rps.getLast() == localObject5) {
                        break;
                      }
                      localObject2 = (String)localObject1 + ",";
                      break;
                      localObject1 = (String)localObject2 + (String)localObject5;
                      continue;
                      localObject1 = (String)localObject2 + (String)localObject5;
                    }
                  }
                  localaw.rZJ = ((String)localObject2);
                  localaw.rZI = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject3).rpq, new Object[] { localObject2 });
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
  
  private void Kc()
  {
    synchronized (this.sdU)
    {
      this.meP = w(0L, this.meP);
      return;
    }
  }
  
  private void a(int paramInt, aw paramaw)
  {
    Object localObject1 = paramaw.qXo.CommentUserList;
    paramaw.rZs = new com.tencent.mm.plugin.sns.data.d();
    if (this.DEBUG) {
      ab.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + paramInt + " commentInfoList: " + ((List)localObject1).size() + " commentData:" + paramaw.rZs.rbi.size());
    }
    Iterator localIterator = ((List)localObject1).iterator();
    label132:
    label263:
    label268:
    label273:
    label340:
    while (localIterator.hasNext())
    {
      Object localObject2 = (cds)localIterator.next();
      CharSequence localCharSequence;
      if (com.tencent.mm.plugin.sns.ui.widget.d.fS(((cds)localObject2).xOc, 16))
      {
        localObject1 = com.tencent.mm.plugin.sns.ui.widget.b.cxJ().getTextViewConfig();
        localCharSequence = com.tencent.mm.plugin.sns.ui.widget.d.a(this.mContext, (cds)localObject2, new a.1(this), paramaw.qXp.field_type, paramaw.qXp.field_userName, 1);
        Object localObject3 = com.tencent.mm.kiss.widget.textview.c.eLm;
        if (localObject1 == null) {
          break label268;
        }
        localObject3 = (com.tencent.mm.kiss.widget.textview.b)((com.tencent.mm.kiss.widget.textview.c)localObject3).eLn.get(Integer.valueOf(com.tencent.mm.kiss.widget.textview.c.a((com.tencent.mm.kiss.widget.textview.a.a)localObject1)));
        if (localObject3 == null) {
          break label268;
        }
        localObject3 = (LinkedList)((com.tencent.mm.kiss.widget.textview.b)localObject3).eLl.get(localCharSequence.toString());
        if ((localObject3 != null) && (((LinkedList)localObject3).size() != 0)) {
          break label263;
        }
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label273;
        }
        paramaw.rZs.a((cds)localObject2, localCharSequence);
        break;
        localObject1 = com.tencent.mm.plugin.sns.ui.widget.c.cxK().getTextViewConfig();
        break label132;
        paramInt = 1;
        continue;
        paramInt = 0;
      }
      paramaw.rZs.a((cds)localObject2, localCharSequence);
      if (com.tencent.mm.plugin.sns.ui.widget.d.fS(((cds)localObject2).xOc, 16)) {}
      for (paramInt = com.tencent.mm.plugin.sns.ui.widget.b.cxJ().getViewWidth();; paramInt = com.tencent.mm.plugin.sns.ui.widget.c.cxK().getViewWidth())
      {
        if (paramInt <= 0) {
          break label340;
        }
        localObject2 = com.tencent.mm.kiss.widget.textview.d.a(localCharSequence, paramInt, (com.tencent.mm.kiss.widget.textview.a.a)localObject1).SK();
        com.tencent.mm.kiss.widget.textview.c.eLm.a((com.tencent.mm.kiss.widget.textview.a.a)localObject1, (com.tencent.mm.kiss.widget.textview.f)localObject2);
        break;
      }
    }
  }
  
  private String e(TimeLineObject paramTimeLineObject)
  {
    Object localObject;
    if (paramTimeLineObject.xTS.wNZ == 26) {
      localObject = this.mContext.getString(2131299680);
    }
    String str;
    do
    {
      return localObject;
      if (paramTimeLineObject.xTR == null) {
        return "";
      }
      if (bo.isNullOrNil(paramTimeLineObject.xTR.Id)) {
        return "";
      }
      if (this.sdV.containsKey(paramTimeLineObject.xTR.Id)) {
        return (String)this.sdV.get(paramTimeLineObject.xTR.Id);
      }
      int i = bo.getInt(paramTimeLineObject.xTR.jKg, 0);
      str = com.tencent.mm.pluginsdk.model.app.g.q(this.mContext, paramTimeLineObject.xTR.Id, i);
      localObject = str;
    } while (bo.isNullOrNil(str));
    this.sdV.put(paramTimeLineObject.xTR.Id, str);
    return str;
  }
  
  private static boolean f(TimeLineObject paramTimeLineObject)
  {
    if (bo.isNullOrNil(paramTimeLineObject.xTT)) {}
    while ((an.a.cpE() & 0x2) <= 0) {
      return true;
    }
    return false;
  }
  
  public final void Pz()
  {
    looperCheckForVending();
    ab.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", new Object[] { Boolean.valueOf(this.sdT) });
    if (this.sdT) {
      return;
    }
    synchronized (this.sdU)
    {
      this.meP = w(0L, this.meP);
      return;
    }
  }
  
  public final void a(Context paramContext, av paramav, String paramString)
  {
    this.mContext = paramContext;
    this.sdP = paramav;
    this.rXD = paramString;
    com.tencent.mm.kernel.g.RM();
    this.fnD = ((j)com.tencent.mm.kernel.g.E(j.class)).YA();
  }
  
  public final void acl(String paramString)
  {
    this.rKW = paramString;
  }
  
  public final void acm(String paramString)
  {
    synchronized (this.sdU)
    {
      this.meP = paramString;
      return;
    }
  }
  
  public final void cvL()
  {
    looperCheckForVending();
    long l;
    if (this.c == 0)
    {
      l = 0L;
      this.sdT = true;
    }
    for (;;)
    {
      synchronized (this.sdU)
      {
        this.meP = w(l, this.meP);
        return;
        int i = this.c - 1;
        int j = 0;
        ??? = (n)getItem(i);
        if ((??? != null) && (!((n)???).Ex(32)) && (((n)???).field_snsId != 0L))
        {
          l = ((n)???).field_snsId;
          ab.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[] { Long.valueOf(l), ((n)???).field_stringSeq });
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
  
  public final String cwN()
  {
    return this.meP;
  }
  
  public final String cwO()
  {
    return this.rKW;
  }
  
  public final void cwP()
  {
    this.sdT = true;
  }
  
  public Cursor cwQ()
  {
    init();
    int k = ag.cpf().abI(this.meP);
    ab.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", new Object[] { Integer.valueOf(this.sdQ), Integer.valueOf(k), this.meP });
    Object localObject1 = new ArrayList();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    long l1;
    int i;
    boolean bool;
    if (this.sdQ != k)
    {
      localObject2 = ag.cpi().fD(this.sdQ, k);
      if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject3 = new LinkedList();
        localObject4 = new com.tencent.mm.plugin.sns.storage.e();
        ((com.tencent.mm.plugin.sns.storage.e)localObject4).convertFrom((Cursor)localObject2);
        localObject5 = ((com.tencent.mm.plugin.sns.storage.e)localObject4).csn();
        localObject6 = new StringBuilder("ad xml ");
        localObject7 = ((n)localObject5).csQ();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(((n)localObject5).field_stringSeq);
        localStringBuffer.append(((com.tencent.mm.plugin.sns.storage.e)localObject7).field_adxml);
        localStringBuffer.append(" <createtime " + ((n)localObject5).field_createTime + ">");
        localStringBuffer.append(" <exposuretime " + ((com.tencent.mm.plugin.sns.storage.e)localObject7).field_exposureTime + ">");
        localStringBuffer.append(" <adcreatetime " + ((com.tencent.mm.plugin.sns.storage.e)localObject7).field_createAdTime + "> ");
        localStringBuffer.append(((com.tencent.mm.plugin.sns.storage.e)localObject7).csh().xTP);
        ab.d("MicroMsg.SnsTimeLineVendingSide", localStringBuffer.toString());
        l1 = 21600L;
        localObject6 = ((n)localObject5).csd();
        i = ((n)localObject5).field_createTime;
        if ((((com.tencent.mm.plugin.sns.storage.e)localObject4).field_localFlag & 0x80) > 0)
        {
          bool = true;
          if (localObject6 == null) {
            break label1113;
          }
          if (!bool) {
            break label733;
          }
          l1 = 60L * ((com.tencent.mm.plugin.sns.storage.a)localObject6).rpf;
          i = ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_exposureTime;
        }
      }
    }
    label464:
    label853:
    label1113:
    for (;;)
    {
      label369:
      long l2 = bo.gz(i);
      int j;
      if (l2 >= l1)
      {
        localObject6 = ak.q((n)localObject5);
        if (((n)localObject5).field_likeFlag == 0)
        {
          localObject6 = ((SnsObject)localObject6).CommentUserList.iterator();
          do
          {
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localObject7 = (cds)((Iterator)localObject6).next();
          } while ((localObject7 == null) || (bo.isNullOrNil(((cds)localObject7).Username)) || (!((cds)localObject7).Username.equals(this.rXD)));
        }
        j = 1;
        if (j == 0)
        {
          ((List)localObject1).add(Long.valueOf(((n)localObject5).field_snsId));
          ab.i("MicroMsg.SnsTimeLineVendingSide", "prepare to delete the ad " + ((n)localObject5).field_snsId + " exposureTime: " + l1 + " field_createTime: " + ((n)localObject5).field_createTime + " checktime: " + l2 + " gettime: " + i + " isexposure " + bool + " exposureTime " + ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_exposureTime + " adCreateTIme:" + ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_createAdTime);
          if (!bool) {
            ((LinkedList)localObject3).add(localObject4);
          }
        }
      }
      for (;;)
      {
        if (((Cursor)localObject2).moveToNext()) {
          break label827;
        }
        if (((LinkedList)localObject3).size() <= 0) {
          break label853;
        }
        localObject4 = new LinkedList();
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.sns.storage.e)((Iterator)localObject3).next();
          localObject6 = new bp();
          ((bp)localObject6).wog = 13298;
          ((bp)localObject6).woh = new com.tencent.mm.bv.b(((com.tencent.mm.plugin.sns.storage.e)localObject5).csd().cFe.getBytes());
          ((bp)localObject6).woi = (System.currentTimeMillis() / 1000L);
          ((LinkedList)localObject4).add(localObject6);
        }
        bool = false;
        break;
        label733:
        l1 = 60L * ((com.tencent.mm.plugin.sns.storage.a)localObject6).rpe;
        i = ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_createAdTime;
        break label369;
        j = 0;
        break label464;
        l1 = ((n)localObject5).field_snsId;
        ab.i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid ".concat(String.valueOf(l1)));
        if (com.tencent.mm.plugin.sns.model.m.lx(l1))
        {
          localObject4 = new com.tencent.mm.plugin.sns.model.m(l1, 1, ((n)localObject5).csd().rpE);
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a((com.tencent.mm.ai.m)localObject4, 0);
        }
      }
      break;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(new l((LinkedList)localObject4), 0);
      if (localObject2 != null)
      {
        ab.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + ((Cursor)localObject2).getCount());
        ((Cursor)localObject2).close();
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.plugin.sns.model.a.lt(((Long)((Iterator)localObject2).next()).longValue());
        }
        ((List)localObject1).clear();
      }
      this.sdQ = k;
      localObject1 = ag.cpf().dr(this.meP, k);
      ab.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
      localObject2 = com.tencent.mm.modelsns.b.lV(500);
      if (((com.tencent.mm.modelsns.b)localObject2).aka())
      {
        i = this.c;
        if (i != 0) {
          break label1023;
        }
        ((com.tencent.mm.modelsns.b)localObject2).lY(0).lY(0).lY(0);
        ((com.tencent.mm.modelsns.b)localObject2).ake();
      }
      label1023:
      do
      {
        return localObject1;
        localObject3 = i.j((n)getItem(1));
        localObject4 = i.j((n)getItem(i - 1));
      } while ((((String)localObject3).equals(this.sdX)) && (((String)localObject4).equals(this.sdY)));
      this.sdX = ((String)localObject3);
      this.sdY = ((String)localObject4);
      ((com.tencent.mm.modelsns.b)localObject2).lY(i).uv((String)localObject3).uv((String)localObject4);
      ((com.tencent.mm.modelsns.b)localObject2).ake();
      return localObject1;
    }
  }
  
  public void destroyAsynchronous()
  {
    super.destroyAsynchronous();
    com.tencent.mm.kiss.widget.textview.c.eLm.SJ();
    this.sdW.clear();
    this.mContext = null;
    this.sdP = null;
    this.fnD = null;
    this.ANH = null;
  }
  
  protected final void init()
  {
    if (!this.sdS)
    {
      Kc();
      this.sdS = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.a
 * JD-Core Version:    0.7.0.1
 */