package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storagebase.h;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static List<ax> zyD;
  private static com.tencent.mm.plugin.sns.i.c zyF;
  private static boolean zyG;
  com.tencent.mm.ak.f callback;
  private String fHO;
  com.tencent.mm.ak.b rr;
  private a zyE;
  
  static
  {
    AppMethodBeat.i(95647);
    zyD = new LinkedList();
    zyG = true;
    AppMethodBeat.o(95647);
  }
  
  public u()
  {
    AppMethodBeat.i(95630);
    this.fHO = "";
    this.zyE = new a();
    ae.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", new Object[] { Integer.valueOf(256) });
    localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).hQF = new dhl();
    ((com.tencent.mm.ak.b.a)localObject).hQG = new dhm();
    ((com.tencent.mm.ak.b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((com.tencent.mm.ak.b.a)localObject).funcId = 214;
    ((com.tencent.mm.ak.b.a)localObject).hQH = 102;
    ((com.tencent.mm.ak.b.a)localObject).respCmdId = 1000000102;
    this.rr = ((com.tencent.mm.ak.b.a)localObject).aDS();
    ((dhl)this.rr.hQD.hQJ).GjP = 256;
    this.fHO = v.aAC();
    long l;
    byte[] arrayOfByte;
    if (zyG)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.ajS();
      localObject = com.tencent.mm.kernel.g.ajR().cachePath + "ad_1100007";
      ae.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(localObject)));
      arrayOfByte = com.tencent.mm.vfs.o.bb((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      zyF = (com.tencent.mm.plugin.sns.i.c)new com.tencent.mm.plugin.sns.i.c().parseFrom(arrayOfByte);
      ae.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (zyF != null) {
        break label293;
      }
      ae.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.o.deleteFile((String)localObject);
        continue;
        ae.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + zyF.zHJ.size());
      }
    }
    zyG = false;
    AppMethodBeat.o(95630);
  }
  
  public static void Af(long paramLong)
  {
    AppMethodBeat.i(95632);
    if (zyF == null) {
      zyF = new com.tencent.mm.plugin.sns.i.c();
    }
    zyF.zHJ.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95632);
  }
  
  public static void Ag(long paramLong)
  {
    AppMethodBeat.i(95633);
    if (zyF != null) {
      zyF.zHJ.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(95633);
  }
  
  public static boolean Ah(long paramLong)
  {
    AppMethodBeat.i(95634);
    if (zyF == null)
    {
      AppMethodBeat.o(95634);
      return false;
    }
    if (zyF.zHJ.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95634);
      return true;
    }
    AppMethodBeat.o(95634);
    return false;
  }
  
  public static boolean Ai(long paramLong)
  {
    AppMethodBeat.i(95639);
    try
    {
      boolean bool = a.a(paramLong, null, bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyLimit"), 0), bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyLikeTimeLimit"), 0), bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
      AppMethodBeat.o(95639);
      return bool;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "", new Object[0]);
      AppMethodBeat.o(95639);
    }
    return true;
  }
  
  public static void a(ax paramax)
  {
    AppMethodBeat.i(95645);
    if (!zyD.contains(paramax)) {
      zyD.add(paramax);
    }
    AppMethodBeat.o(95645);
  }
  
  private static boolean a(dgc paramdgc)
  {
    AppMethodBeat.i(95640);
    try
    {
      dgb localdgb1 = paramdgc.HNs;
      long l1 = paramdgc.Id;
      Object localObject = bu.nullAsNil(paramdgc.hFO);
      long l2 = paramdgc.HNr;
      int i = bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyLimit"), 0);
      int j = bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyLikeTimeLimit"), 0);
      int k = bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyCommentTimeLimit"), 0);
      if (((i > 0) || (j > 0) || (k > 0)) && ((localdgb1.nJA == 8) || (localdgb1.nJA == 7)) && (!a.a(l1, paramdgc, i, j, k, true)))
      {
        ae.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + (String)localObject + " snsId: " + l1 + " " + localdgb1.HNm + " " + localdgb1.HNk + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
        a.a(l1, paramdgc);
        AppMethodBeat.o(95640);
        return false;
      }
      ae.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + (String)localObject + " snsId: " + l1 + " " + localdgb1.HNm + " " + localdgb1.HNk + " actionLimit: " + i);
      if (!ah.dXJ().a(l1, localdgb1.HzT, localdgb1.CreateTime, (String)localObject))
      {
        dgb localdgb2 = paramdgc.HNt;
        com.tencent.mm.plugin.sns.storage.j localj = new com.tencent.mm.plugin.sns.storage.j();
        localj.field_snsID = l1;
        localj.field_parentID = l2;
        localj.field_createTime = localdgb1.CreateTime;
        localj.field_talker = localdgb1.HzT;
        localj.field_type = localdgb1.nJA;
        localj.field_curActionBuf = localdgb1.toByteArray();
        localj.field_refActionBuf = localdgb2.toByteArray();
        localj.field_clientId = ((String)localObject);
        if (com.tencent.mm.plugin.sns.ui.widget.e.id(localdgb1.HNo, 2)) {}
        for (i = 1;; i = 0)
        {
          localj.field_isSilence = i;
          if ((localdgb1.nJA != 8) && (localdgb1.nJA != 7)) {
            break;
          }
          localj.field_commentSvrID = localdgb1.HNm;
          if (a.a(l1, paramdgc)) {
            break label552;
          }
          ae.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
          AppMethodBeat.o(95640);
          return false;
        }
        localj.field_commentSvrID = localdgb1.HNk;
        boolean bool = al.a(l1, paramdgc);
        if (!bool)
        {
          AppMethodBeat.o(95640);
          return false;
        }
        label552:
        if ((!bu.ht(localdgb1.HNp)) && (localdgb1.HNp.get(0) != null))
        {
          paramdgc = al.a((dgn)localdgb1.HNp.get(0));
          if (be.fvc().JfU.aWl(paramdgc.field_md5) == null)
          {
            be.fvc().JfU.J(paramdgc);
            if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNE, 0) == 1))
            {
              localObject = com.tencent.mm.emoji.loader.e.gkR;
              com.tencent.mm.emoji.loader.e.a(paramdgc, null);
            }
          }
        }
        ah.dXJ().insert(localj);
        ah.dXJ().G(l1, com.tencent.mm.plugin.sns.ui.widget.e.id(localdgb1.HNo, 2));
        AppMethodBeat.o(95640);
        return true;
      }
      AppMethodBeat.o(95640);
      return false;
    }
    catch (Exception paramdgc)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdgc, "", new Object[0]);
      AppMethodBeat.o(95640);
    }
    return false;
  }
  
  private static boolean a(dgc paramdgc, dgb paramdgb, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95641);
    try
    {
      ae.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramdgb.HNm + " " + paramdgb.HNk);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.dWD())
      {
        ae.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        AppMethodBeat.o(95641);
        return false;
      }
      if (!ah.dXJ().a(paramLong1, paramdgb.HzT, paramdgb.CreateTime, paramString))
      {
        dgb localdgb = paramdgc.HNt;
        com.tencent.mm.plugin.sns.storage.j localj = new com.tencent.mm.plugin.sns.storage.j();
        localj.field_snsID = paramLong1;
        localj.field_parentID = paramLong2;
        localj.field_createTime = paramdgb.CreateTime;
        localj.field_talker = paramdgb.HzT;
        localj.field_type = paramdgb.nJA;
        localj.field_curActionBuf = paramdgb.toByteArray();
        localj.field_refActionBuf = localdgb.toByteArray();
        localj.field_clientId = paramString;
        localj.field_commentSvrID = paramdgb.HNk;
        ae.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramdgb.HNn);
        al.d(paramLong1, paramdgc);
        aBV();
        ah.dXJ().insert(localj);
        AppMethodBeat.o(95641);
        return true;
      }
      AppMethodBeat.o(95641);
      return false;
    }
    catch (Exception paramdgc)
    {
      ae.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramdgc.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdgc, "", new Object[0]);
      AppMethodBeat.o(95641);
    }
    return false;
  }
  
  private static void aBV()
  {
    AppMethodBeat.i(95644);
    Iterator localIterator = zyD.iterator();
    while (localIterator.hasNext())
    {
      ax localax = (ax)localIterator.next();
      if (localax != null) {
        localax.aBV();
      }
    }
    AppMethodBeat.o(95644);
  }
  
  public static void b(ax paramax)
  {
    AppMethodBeat.i(95646);
    zyD.remove(paramax);
    AppMethodBeat.o(95646);
  }
  
  private static boolean b(dgc paramdgc, dgb paramdgb, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95642);
    try
    {
      ae.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramdgb.HNm + " " + paramdgb.HNk);
      if (!ah.dXJ().a(paramLong1, paramdgb.HzT, paramdgb.CreateTime, paramString))
      {
        dgb localdgb = paramdgc.HNt;
        paramdgc = new com.tencent.mm.plugin.sns.storage.j();
        paramdgc.field_snsID = paramLong1;
        paramdgc.field_parentID = paramLong2;
        paramdgc.field_createTime = paramdgb.CreateTime;
        paramdgc.field_talker = paramdgb.HzT;
        paramdgc.field_type = paramdgb.nJA;
        paramdgc.field_curActionBuf = paramdgb.toByteArray();
        paramdgc.field_refActionBuf = localdgb.toByteArray();
        paramdgc.field_clientId = paramString;
        paramdgc.field_commentSvrID = paramdgb.HNk;
        paramString = new bol();
        ae.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramdgb.HNn);
        paramString.parseFrom(z.a(paramdgb.HNn));
        ae.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.dPq);
        ah.dXJ().insert(paramdgc);
        AppMethodBeat.o(95642);
        return true;
      }
      AppMethodBeat.o(95642);
      return false;
    }
    catch (Exception paramdgc)
    {
      ae.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramdgc.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdgc, "", new Object[0]);
      AppMethodBeat.o(95642);
    }
    return false;
  }
  
  public static void dWY()
  {
    AppMethodBeat.i(95635);
    if (zyF == null)
    {
      AppMethodBeat.o(95635);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().cachePath + "ad_1100007";
    ae.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(localObject)));
    try
    {
      byte[] arrayOfByte = zyF.toByteArray();
      com.tencent.mm.vfs.o.f((String)localObject, arrayOfByte, arrayOfByte.length);
      ae.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + zyF.zHJ.size());
      AppMethodBeat.o(95635);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: ".concat(String.valueOf(localObject)), new Object[0]);
      AppMethodBeat.o(95635);
    }
  }
  
  public static void dWZ()
  {
    AppMethodBeat.i(95643);
    Iterator localIterator = zyD.iterator();
    while (localIterator.hasNext())
    {
      ax localax = (ax)localIterator.next();
      if (localax != null) {
        localax.aBW();
      }
    }
    AppMethodBeat.o(95643);
  }
  
  public final boolean a(zx paramzx, final aq paramaq)
  {
    AppMethodBeat.i(95637);
    final SnsObject localSnsObject;
    boolean bool;
    try
    {
      localSnsObject = (SnsObject)new SnsObject().parseFrom(paramzx.Grv.getBuffer().toByteArray());
      paramzx = new String(localSnsObject.ObjectDesc.getBuffer().toByteArray());
      if (paramzx.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label452;
      }
      if (paramzx.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label467;
      }
    }
    catch (Exception paramzx)
    {
      com.tencent.mm.plugin.sns.storage.n localn;
      String[] arrayOfString;
      int i;
      ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramzx, "", new Object[0]);
      AppMethodBeat.o(95637);
      return false;
    }
    ae.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localSnsObject.Id + " " + r.zV(localSnsObject.Id) + " isPhoto " + bool);
    String str;
    int j;
    if (bool)
    {
      str = r.zV(localSnsObject.Id);
      localn = ah.dXI().aBw(localSnsObject.Username);
      if (bu.isNullOrNil(localn.field_newerIds)) {
        break label374;
      }
      arrayOfString = localn.field_newerIds.split(",");
      j = 0;
      i = 1;
      label184:
      if (j >= arrayOfString.length) {
        break label473;
      }
      if (!str.equals(arrayOfString[j])) {
        break label458;
      }
      i = 0;
      break label458;
    }
    for (;;)
    {
      if ((j < 2) && (j < arrayOfString.length) && (i != 0))
      {
        paramzx = paramzx + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        ae.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localSnsObject.Id + " S: " + str + " list " + localn.field_newerIds + " newer " + paramzx);
        if (i != 0) {
          ah.dXI().jW(localSnsObject.Username, paramzx);
        }
        while (ah.dXE().Ay(localSnsObject.Id))
        {
          ae.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          AppMethodBeat.o(95637);
          return false;
          label374:
          ah.dXI().jW(localSnsObject.Username, str);
        }
        com.tencent.mm.sdk.b.a.IvT.l(new ux());
        ah.cXK().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95624);
            if (!localSnsObject.Username.equals(u.a(u.this)))
            {
              com.tencent.mm.kernel.g.ajS();
              if (!com.tencent.mm.kernel.g.ajP().aiZ())
              {
                ae.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                AppMethodBeat.o(95624);
                return;
              }
              com.tencent.mm.kernel.g.ajS();
              Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(68377, null);
              com.tencent.mm.kernel.g.ajS();
              if ((bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(68400, null), 0) != localSnsObject.CreateTime) || ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).equals(localSnsObject.Username))))
              {
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajR().ajA().set(68377, localSnsObject.Username);
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajR().ajA().set(68400, Integer.valueOf(localSnsObject.CreateTime));
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajR().ajA().set(68418, r.zV(localSnsObject.Id));
                com.tencent.mm.kernel.g.ajS();
                com.tencent.mm.kernel.g.ajR().ajA().set(68419, Integer.valueOf(0));
                com.tencent.mm.plugin.sns.j.f.q(1, r.zV(localSnsObject.Id), 0);
              }
              localObject = u.bbx().iterator();
              while (((Iterator)localObject).hasNext()) {
                ((ax)((Iterator)localObject).next()).aBU();
              }
            }
            paramaq.sendEmptyMessage(0);
            AppMethodBeat.o(95624);
          }
        });
        AppMethodBeat.o(95637);
        return true;
        label452:
        bool = true;
        break;
        label458:
        j += 1;
        break label184;
        label467:
        bool = false;
        break;
        label473:
        j = 0;
        paramzx = str;
      }
    }
  }
  
  public final boolean b(zx paramzx, final aq paramaq)
  {
    AppMethodBeat.i(95638);
    Object localObject3;
    long l1;
    Object localObject1;
    label178:
    final boolean bool1;
    label193:
    Object localObject4;
    Object localObject5;
    int i;
    label972:
    label1110:
    Object localObject6;
    label1089:
    StringBuilder localStringBuilder;
    label1163:
    boolean bool2;
    for (;;)
    {
      long l2;
      final dgb localdgb;
      try
      {
        localObject3 = (dgc)new dgc().parseFrom(paramzx.Grv.getBuffer().toByteArray());
        l1 = ((dgc)localObject3).Id;
        l2 = ((dgc)localObject3).HNr;
        localdgb = ((dgc)localObject3).HNs;
        localObject1 = ((dgc)localObject3).hFO;
        paramzx = (zx)localObject1;
        if (localObject1 == null) {
          paramzx = "";
        }
        ae.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localdgb.nJA + " " + l1 + " " + paramzx);
        switch (localdgb.nJA)
        {
        case 9: 
          a((dgc)localObject3);
          if (com.tencent.mm.plugin.sns.ui.widget.e.id(localdgb.HNo, 2)) {
            break label1731;
          }
          bool1 = true;
          ah.cXK().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95625);
              if (bool1)
              {
                Iterator localIterator = u.bbx().iterator();
                while (localIterator.hasNext())
                {
                  ax localax = (ax)localIterator.next();
                  ae.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                  localax.aBT();
                }
              }
              paramaq.sendEmptyMessage(0);
              AppMethodBeat.o(95625);
            }
          });
          AppMethodBeat.o(95638);
          return true;
        }
      }
      catch (Exception paramzx)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramzx, "", new Object[0]);
        AppMethodBeat.o(95638);
        return false;
      }
      paramzx = ah.dXJ().h(l1, localdgb.HNk, localdgb.nJA);
      if (paramzx != null)
      {
        paramzx.ebX();
        ae.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(ah.dXJ().update(paramzx.systemRowid, paramzx))));
      }
      else
      {
        al.c(l1, (dgc)localObject3);
        continue;
        paramzx = ah.dXJ().h(l1, localdgb.HNm, localdgb.nJA);
        if (paramzx != null)
        {
          paramzx.ebX();
          bool1 = ah.dXJ().update(paramzx.systemRowid, paramzx);
          al.b(l1, (dgc)localObject3);
          ae.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(bool1)));
          continue;
          paramzx = ah.dXJ();
          localObject1 = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(l1));
          ae.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(localObject1)));
          bool1 = paramzx.hKK.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramzx.doNotify();
          }
          ae.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(bool1)));
          continue;
          paramzx = ah.dXJ();
          localObject1 = localdgb.HzT;
          localObject1 = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + bu.aSk((String)localObject1) + "'";
          ae.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(localObject1)));
          bool1 = paramzx.hKK.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramzx.doNotify();
          }
          ae.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(bool1)));
          al.b(l1, (dgc)localObject3);
          continue;
          a((dgc)localObject3, localdgb, l1, l2, paramzx);
          continue;
          b((dgc)localObject3, localdgb, l1, l2, paramzx);
          continue;
          com.tencent.mm.plugin.sns.storage.i.Az(l1);
          paramzx = ah.dXE().AG(l1);
          localObject1 = paramzx.ebP();
          ((TimeLineObject)localObject1).eQZ = 1;
          paramzx.f((TimeLineObject)localObject1);
          ah.dXE().b(l1, paramzx);
          continue;
          localObject1 = localdgb.FOe;
          if (m.Ab(l1))
          {
            paramzx = new m(l1, (cty)localObject1);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramzx, 0);
          }
          for (;;)
          {
            try
            {
              paramzx = ((dgc)localObject3).HNs;
              localObject4 = bu.nullAsNil(((dgc)localObject3).hFO);
              l2 = ((dgc)localObject3).HNr;
              int j = bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyLimit"), 0);
              int k = bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyLikeTimeLimit"), 0);
              int m = bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsAdNotifyCommentTimeLimit"), 0);
              if (localObject1 == null) {
                break label1089;
              }
              ae.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid64 %s, aid %s, commentId %s, actionLimit %s", new Object[] { localObject4, Long.valueOf(l1), Long.valueOf(((cty)localObject1).HEZ), Integer.valueOf(((cty)localObject1).HEU), Integer.valueOf(paramzx.HNk), Integer.valueOf(j) });
              if ((((cty)localObject1).HEZ == 0L) && (((cty)localObject1).HEU == 0)) {
                com.tencent.mm.plugin.report.service.g.yxI.dD(955, 4);
              }
              if (ah.dXJ().a(l1, paramzx.HzT, paramzx.CreateTime, (String)localObject4)) {
                break;
              }
              localObject5 = ((dgc)localObject3).HNt;
              localObject1 = new com.tencent.mm.plugin.sns.storage.j();
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_snsID = l1;
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_parentID = l2;
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_createTime = paramzx.CreateTime;
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_talker = paramzx.HzT;
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_type = paramzx.nJA;
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_curActionBuf = paramzx.toByteArray();
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_refActionBuf = ((dgb)localObject5).toByteArray();
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_clientId = ((String)localObject4);
              if (!com.tencent.mm.plugin.sns.ui.widget.e.id(paramzx.HNo, 2)) {
                break label1740;
              }
              i = 1;
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_isSilence = i;
              ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_commentSvrID = paramzx.HNm;
              if (!ah.dXH().Ay(l1)) {
                break label1163;
              }
              if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, (dgc)localObject3, j, k, m, true))) {
                break label1110;
              }
              ae.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_snsID + " " + ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_commentSvrID);
            }
            catch (Exception paramzx)
            {
              ae.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramzx, "", new Object[0]);
            }
            break;
            ae.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
            com.tencent.mm.plugin.report.service.g.yxI.dD(955, 3);
          }
          if (!a.a(l1, (dgc)localObject3))
          {
            ae.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_snsID + " " + ((com.tencent.mm.plugin.sns.storage.j)localObject1).field_commentSvrID);
          }
          else
          {
            if ((!bu.ht(paramzx.HNp)) && (paramzx.HNp.get(0) != null))
            {
              localObject3 = al.a((dgn)paramzx.HNp.get(0));
              if (be.fvc().JfU.aWl(((EmojiInfo)localObject3).field_md5) == null)
              {
                be.fvc().JfU.J((EmojiInfo)localObject3);
                if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNE, 0) == 1))
                {
                  localObject4 = com.tencent.mm.emoji.loader.e.gkR;
                  com.tencent.mm.emoji.loader.e.a((EmojiInfo)localObject3, null);
                }
              }
            }
            ah.dXJ().insert((com.tencent.mm.sdk.e.c)localObject1);
            ah.dXJ().G(l1, com.tencent.mm.plugin.sns.ui.widget.e.id(paramzx.HNo, 2));
            continue;
            localObject5 = "";
            localObject6 = null;
            localObject3 = null;
            localStringBuilder = null;
            localObject1 = null;
            bool2 = false;
            bool1 = bool2;
            localObject4 = localStringBuilder;
            paramzx = localObject6;
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          String str = r.zV(l1);
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramzx = localObject6;
          ae.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=".concat(String.valueOf(str)));
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramzx = localObject6;
          com.tencent.mm.plugin.sns.storage.e locale = ah.dXH().Ax(l1);
          if (locale != null)
          {
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramzx = localObject6;
            localObject3 = locale.dVi();
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramzx = (zx)localObject3;
            localObject1 = locale.dVj();
          }
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzx = (zx)localObject3;
          bool2 = ah.dXH().delete(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzx = (zx)localObject3;
          ah.dXJ().AB(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzx = (zx)localObject3;
          com.tencent.mm.plugin.sns.storage.i.AA(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzx = (zx)localObject3;
          localStringBuilder = new StringBuilder("processSnsAdFeedsForceDelAction snsId=").append(str).append(", delSucc=").append(bool2).append(", adSnsInfo==null?");
          if (locale != null) {
            break label1745;
          }
          bool3 = true;
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzx = (zx)localObject3;
          ae.i("MicroMsg.NetSceneNewSyncAlbum", bool3);
          paramzx = (zx)localObject3;
          localObject5 = str;
          bool1 = bool2;
        }
        catch (Throwable localThrowable)
        {
          ae.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction exp=" + localThrowable.toString() + ", snsId=" + (String)localObject5);
          Object localObject2 = localObject4;
          continue;
        }
        try
        {
          com.tencent.mm.plugin.sns.data.i.a(3, l1, paramzx, (com.tencent.mm.plugin.sns.storage.b)localObject1);
          if (!bool1) {
            break;
          }
          com.tencent.mm.plugin.sns.data.i.a(4, l1, paramzx, (com.tencent.mm.plugin.sns.storage.b)localObject1);
        }
        catch (Throwable paramzx)
        {
          ae.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction report exp=" + paramzx.toString() + ", snsId=" + (String)localObject5);
        }
      }
      break label178;
      label1731:
      bool1 = false;
      break label193;
      break;
      label1740:
      i = 0;
      break label972;
      label1745:
      boolean bool3 = false;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(95631);
    com.tencent.mm.kernel.g.ajS();
    byte[] arrayOfByte = bu.aSx(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((dhl)this.rr.hQD.hQJ).GjQ = localSKBuiltinBuffer_t;
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95631);
    return i;
  }
  
  public final int getType()
  {
    return 214;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95636);
    ae.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95636);
      return;
    }
    dhm localdhm = (dhm)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    paramArrayOfByte = localdhm.GjT.nIE;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      ae.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.zyE;
      paramString.rjr = paramArrayOfByte;
      paramString.rBT.sendEmptyMessage(0);
      AppMethodBeat.o(95636);
      return;
    }
    if ((localdhm.GjQ != null) && (localdhm.GjQ.getBuffer() != null))
    {
      paramArrayOfByte = localdhm.GjQ.getBuffer().toByteArray();
      paramq = ad.l(((dhl)((com.tencent.mm.ak.b)paramq).hQD.hQJ).GjQ.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0))
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(8195, bu.cH(paramq));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95636);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    aq rBT;
    LinkedList<zx> rjr;
    
    a()
    {
      AppMethodBeat.i(95629);
      this.rBT = new aq()
      {
        public final void handleMessage(final Message paramAnonymousMessage)
        {
          AppMethodBeat.i(95628);
          com.tencent.mm.kernel.g.ajS();
          if (!com.tencent.mm.kernel.g.ajP().aiZ())
          {
            AppMethodBeat.o(95628);
            return;
          }
          if ((u.a.this.rjr == null) || (u.a.this.rjr.isEmpty()))
          {
            paramAnonymousMessage = u.this;
            dhm localdhm = (dhm)paramAnonymousMessage.rr.hQE.hQJ;
            dhl localdhl = (dhl)paramAnonymousMessage.rr.hQD.hQJ;
            byte[] arrayOfByte = localdhm.GjQ.getBuffer().toByteArray();
            arrayOfByte = ad.l(localdhl.GjQ.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0))
            {
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(8195, bu.cH(arrayOfByte));
            }
            localdhl.GjQ.setBuffer(arrayOfByte);
            if ((localdhm.GeQ & localdhl.GjP) == 0)
            {
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(95628);
              return;
            }
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(95628);
            return;
          }
          paramAnonymousMessage = (zx)u.a.this.rjr.getFirst();
          ae.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramAnonymousMessage.Gru);
          u.a.this.rjr.removeFirst();
          switch (paramAnonymousMessage.Gru)
          {
          default: 
            u.a.this.rBT.sendEmptyMessage(0);
            AppMethodBeat.o(95628);
            return;
          case 45: 
            ah.dJc().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95626);
                if (!u.this.a(paramAnonymousMessage, u.a.this.rBT)) {
                  u.a.this.rBT.sendEmptyMessage(0);
                }
                AppMethodBeat.o(95626);
              }
            });
            AppMethodBeat.o(95628);
            return;
          }
          ah.dJc().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95627);
              if (!u.this.b(paramAnonymousMessage, u.a.this.rBT)) {
                u.a.this.rBT.sendEmptyMessage(0);
              }
              AppMethodBeat.o(95627);
            }
          });
          AppMethodBeat.o(95628);
        }
      };
      AppMethodBeat.o(95629);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u
 * JD-Core Version:    0.7.0.1
 */