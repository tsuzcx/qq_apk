package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.model.av;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static List<av> zhO;
  private static com.tencent.mm.plugin.sns.i.c zhQ;
  private static boolean zhR;
  com.tencent.mm.al.f callback;
  private String fFK;
  com.tencent.mm.al.b rr;
  private a zhP;
  
  static
  {
    AppMethodBeat.i(95647);
    zhO = new LinkedList();
    zhR = true;
    AppMethodBeat.o(95647);
  }
  
  public t()
  {
    AppMethodBeat.i(95630);
    this.fFK = "";
    this.zhP = new a();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", new Object[] { Integer.valueOf(256) });
    localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).hNM = new dgr();
    ((com.tencent.mm.al.b.a)localObject).hNN = new dgs();
    ((com.tencent.mm.al.b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((com.tencent.mm.al.b.a)localObject).funcId = 214;
    ((com.tencent.mm.al.b.a)localObject).hNO = 102;
    ((com.tencent.mm.al.b.a)localObject).respCmdId = 1000000102;
    this.rr = ((com.tencent.mm.al.b.a)localObject).aDC();
    ((dgr)this.rr.hNK.hNQ).FRq = 256;
    this.fFK = u.aAm();
    long l;
    byte[] arrayOfByte;
    if (zhR)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.ajD();
      localObject = com.tencent.mm.kernel.g.ajC().cachePath + "ad_1100007";
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(localObject)));
      arrayOfByte = com.tencent.mm.vfs.i.aY((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      zhQ = (com.tencent.mm.plugin.sns.i.c)new com.tencent.mm.plugin.sns.i.c().parseFrom(arrayOfByte);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (zhQ != null) {
        break label293;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.i.deleteFile((String)localObject);
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + zhQ.zqu.size());
      }
    }
    zhR = false;
    AppMethodBeat.o(95630);
  }
  
  public static void a(av paramav)
  {
    AppMethodBeat.i(95645);
    if (!zhO.contains(paramav)) {
      zhO.add(paramav);
    }
    AppMethodBeat.o(95645);
  }
  
  private static boolean a(dfi paramdfi)
  {
    AppMethodBeat.i(95640);
    try
    {
      dfh localdfh1 = paramdfi.HtP;
      long l1 = paramdfi.Id;
      Object localObject = bt.nullAsNil(paramdfi.hCW);
      long l2 = paramdfi.HtO;
      int i = bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyLimit"), 0);
      int j = bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyLikeTimeLimit"), 0);
      int k = bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyCommentTimeLimit"), 0);
      if (((i > 0) || (j > 0) || (k > 0)) && ((localdfh1.nEf == 8) || (localdfh1.nEf == 7)) && (!a.a(l1, paramdfi, i, j, k, true)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + (String)localObject + " snsId: " + l1 + " " + localdfh1.HtJ + " " + localdfh1.HtH + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
        a.a(l1, paramdfi);
        AppMethodBeat.o(95640);
        return false;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + (String)localObject + " snsId: " + l1 + " " + localdfh1.HtJ + " " + localdfh1.HtH + " actionLimit: " + i);
      if (!ag.dUj().a(l1, localdfh1.Hgt, localdfh1.CreateTime, (String)localObject))
      {
        dfh localdfh2 = paramdfi.HtQ;
        j localj = new j();
        localj.field_snsID = l1;
        localj.field_parentID = l2;
        localj.field_createTime = localdfh1.CreateTime;
        localj.field_talker = localdfh1.Hgt;
        localj.field_type = localdfh1.nEf;
        localj.field_curActionBuf = localdfh1.toByteArray();
        localj.field_refActionBuf = localdfh2.toByteArray();
        localj.field_clientId = ((String)localObject);
        if (com.tencent.mm.plugin.sns.ui.widget.e.ia(localdfh1.HtL, 2)) {}
        for (i = 1;; i = 0)
        {
          localj.field_isSilence = i;
          if ((localdfh1.nEf != 8) && (localdfh1.nEf != 7)) {
            break;
          }
          localj.field_commentSvrID = localdfh1.HtJ;
          if (a.a(l1, paramdfi)) {
            break label548;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
          AppMethodBeat.o(95640);
          return false;
        }
        localj.field_commentSvrID = localdfh1.HtH;
        boolean bool = ak.a(l1, paramdfi);
        if (!bool)
        {
          AppMethodBeat.o(95640);
          return false;
        }
        label548:
        if ((!bt.hj(localdfh1.HtM)) && (localdfh1.HtM.get(0) != null))
        {
          paramdfi = ak.a((dft)localdfh1.HtM.get(0));
          if (bd.frc().ILn.aUK(paramdfi.field_md5) == null)
          {
            bd.frc().ILn.J(paramdfi);
            if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFY, 0) == 1))
            {
              localObject = com.tencent.mm.emoji.loader.e.giz;
              com.tencent.mm.emoji.loader.e.a(paramdfi, null);
            }
          }
        }
        ag.dUj().insert(localj);
        ag.dUj().E(l1, com.tencent.mm.plugin.sns.ui.widget.e.ia(localdfh1.HtL, 2));
        AppMethodBeat.o(95640);
        return true;
      }
      AppMethodBeat.o(95640);
      return false;
    }
    catch (Exception paramdfi)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdfi, "", new Object[0]);
      AppMethodBeat.o(95640);
    }
    return false;
  }
  
  private static boolean a(dfi paramdfi, dfh paramdfh, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95641);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramdfh.HtJ + " " + paramdfh.HtH);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.dTd())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        AppMethodBeat.o(95641);
        return false;
      }
      if (!ag.dUj().a(paramLong1, paramdfh.Hgt, paramdfh.CreateTime, paramString))
      {
        dfh localdfh = paramdfi.HtQ;
        j localj = new j();
        localj.field_snsID = paramLong1;
        localj.field_parentID = paramLong2;
        localj.field_createTime = paramdfh.CreateTime;
        localj.field_talker = paramdfh.Hgt;
        localj.field_type = paramdfh.nEf;
        localj.field_curActionBuf = paramdfh.toByteArray();
        localj.field_refActionBuf = localdfh.toByteArray();
        localj.field_clientId = paramString;
        localj.field_commentSvrID = paramdfh.HtH;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramdfh.HtK);
        ak.d(paramLong1, paramdfi);
        aBF();
        ag.dUj().insert(localj);
        AppMethodBeat.o(95641);
        return true;
      }
      AppMethodBeat.o(95641);
      return false;
    }
    catch (Exception paramdfi)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramdfi.getMessage());
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdfi, "", new Object[0]);
      AppMethodBeat.o(95641);
    }
    return false;
  }
  
  private static void aBF()
  {
    AppMethodBeat.i(95644);
    Iterator localIterator = zhO.iterator();
    while (localIterator.hasNext())
    {
      av localav = (av)localIterator.next();
      if (localav != null) {
        localav.aBF();
      }
    }
    AppMethodBeat.o(95644);
  }
  
  public static void b(av paramav)
  {
    AppMethodBeat.i(95646);
    zhO.remove(paramav);
    AppMethodBeat.o(95646);
  }
  
  private static boolean b(dfi paramdfi, dfh paramdfh, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95642);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramdfh.HtJ + " " + paramdfh.HtH);
      if (!ag.dUj().a(paramLong1, paramdfh.Hgt, paramdfh.CreateTime, paramString))
      {
        dfh localdfh = paramdfi.HtQ;
        paramdfi = new j();
        paramdfi.field_snsID = paramLong1;
        paramdfi.field_parentID = paramLong2;
        paramdfi.field_createTime = paramdfh.CreateTime;
        paramdfi.field_talker = paramdfh.Hgt;
        paramdfi.field_type = paramdfh.nEf;
        paramdfi.field_curActionBuf = paramdfh.toByteArray();
        paramdfi.field_refActionBuf = localdfh.toByteArray();
        paramdfi.field_clientId = paramString;
        paramdfi.field_commentSvrID = paramdfh.HtH;
        paramString = new bnt();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramdfh.HtK);
        paramString.parseFrom(z.a(paramdfh.HtK));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.dOa);
        ag.dUj().insert(paramdfi);
        AppMethodBeat.o(95642);
        return true;
      }
      AppMethodBeat.o(95642);
      return false;
    }
    catch (Exception paramdfi)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramdfi.getMessage());
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdfi, "", new Object[0]);
      AppMethodBeat.o(95642);
    }
    return false;
  }
  
  public static void dTy()
  {
    AppMethodBeat.i(95635);
    if (zhQ == null)
    {
      AppMethodBeat.o(95635);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().cachePath + "ad_1100007";
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(localObject)));
    try
    {
      byte[] arrayOfByte = zhQ.toByteArray();
      com.tencent.mm.vfs.i.f((String)localObject, arrayOfByte, arrayOfByte.length);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + zhQ.zqu.size());
      AppMethodBeat.o(95635);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: ".concat(String.valueOf(localObject)), new Object[0]);
      AppMethodBeat.o(95635);
    }
  }
  
  public static void dTz()
  {
    AppMethodBeat.i(95643);
    Iterator localIterator = zhO.iterator();
    while (localIterator.hasNext())
    {
      av localav = (av)localIterator.next();
      if (localav != null) {
        localav.aBG();
      }
    }
    AppMethodBeat.o(95643);
  }
  
  public static void zH(long paramLong)
  {
    AppMethodBeat.i(95632);
    if (zhQ == null) {
      zhQ = new com.tencent.mm.plugin.sns.i.c();
    }
    zhQ.zqu.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95632);
  }
  
  public static void zI(long paramLong)
  {
    AppMethodBeat.i(95633);
    if (zhQ != null) {
      zhQ.zqu.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(95633);
  }
  
  public static boolean zJ(long paramLong)
  {
    AppMethodBeat.i(95634);
    if (zhQ == null)
    {
      AppMethodBeat.o(95634);
      return false;
    }
    if (zhQ.zqu.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95634);
      return true;
    }
    AppMethodBeat.o(95634);
    return false;
  }
  
  public static boolean zK(long paramLong)
  {
    AppMethodBeat.i(95639);
    try
    {
      boolean bool = a.a(paramLong, null, bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyLimit"), 0), bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyLikeTimeLimit"), 0), bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
      AppMethodBeat.o(95639);
      return bool;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "", new Object[0]);
      AppMethodBeat.o(95639);
    }
    return true;
  }
  
  public final boolean a(zu paramzu, final ap paramap)
  {
    AppMethodBeat.i(95637);
    final SnsObject localSnsObject;
    boolean bool;
    try
    {
      localSnsObject = (SnsObject)new SnsObject().parseFrom(paramzu.FYV.getBuffer().toByteArray());
      paramzu = new String(localSnsObject.ObjectDesc.getBuffer().toByteArray());
      if (paramzu.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label452;
      }
      if (paramzu.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label467;
      }
    }
    catch (Exception paramzu)
    {
      com.tencent.mm.plugin.sns.storage.n localn;
      String[] arrayOfString;
      int i;
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramzu, "", new Object[0]);
      AppMethodBeat.o(95637);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localSnsObject.Id + " " + com.tencent.mm.plugin.sns.data.q.zw(localSnsObject.Id) + " isPhoto " + bool);
    String str;
    int j;
    if (bool)
    {
      str = com.tencent.mm.plugin.sns.data.q.zw(localSnsObject.Id);
      localn = ag.dUi().aAf(localSnsObject.Username);
      if (bt.isNullOrNil(localn.field_newerIds)) {
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
        paramzu = paramzu + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localSnsObject.Id + " S: " + str + " list " + localn.field_newerIds + " newer " + paramzu);
        if (i != 0) {
          ag.dUi().jP(localSnsObject.Username, paramzu);
        }
        while (ag.dUe().Aa(localSnsObject.Id))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          AppMethodBeat.o(95637);
          return false;
          label374:
          ag.dUi().jP(localSnsObject.Username, str);
        }
        com.tencent.mm.sdk.b.a.IbL.l(new ut());
        ag.cVf().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95624);
            if (!localSnsObject.Username.equals(t.a(t.this)))
            {
              com.tencent.mm.kernel.g.ajD();
              if (!com.tencent.mm.kernel.g.ajA().aiK())
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                AppMethodBeat.o(95624);
                return;
              }
              com.tencent.mm.kernel.g.ajD();
              Object localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(68377, null);
              com.tencent.mm.kernel.g.ajD();
              if ((bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(68400, null), 0) != localSnsObject.CreateTime) || ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equals(localSnsObject.Username))))
              {
                com.tencent.mm.kernel.g.ajD();
                com.tencent.mm.kernel.g.ajC().ajl().set(68377, localSnsObject.Username);
                com.tencent.mm.kernel.g.ajD();
                com.tencent.mm.kernel.g.ajC().ajl().set(68400, Integer.valueOf(localSnsObject.CreateTime));
                com.tencent.mm.kernel.g.ajD();
                com.tencent.mm.kernel.g.ajC().ajl().set(68418, com.tencent.mm.plugin.sns.data.q.zw(localSnsObject.Id));
                com.tencent.mm.kernel.g.ajD();
                com.tencent.mm.kernel.g.ajC().ajl().set(68419, Integer.valueOf(0));
                com.tencent.mm.plugin.sns.j.f.q(1, com.tencent.mm.plugin.sns.data.q.zw(localSnsObject.Id), 0);
              }
              localObject = t.baY().iterator();
              while (((Iterator)localObject).hasNext()) {
                ((av)((Iterator)localObject).next()).aBE();
              }
            }
            paramap.sendEmptyMessage(0);
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
        paramzu = str;
      }
    }
  }
  
  public final boolean b(zu paramzu, final ap paramap)
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
      final dfh localdfh;
      try
      {
        localObject3 = (dfi)new dfi().parseFrom(paramzu.FYV.getBuffer().toByteArray());
        l1 = ((dfi)localObject3).Id;
        l2 = ((dfi)localObject3).HtO;
        localdfh = ((dfi)localObject3).HtP;
        localObject1 = ((dfi)localObject3).hCW;
        paramzu = (zu)localObject1;
        if (localObject1 == null) {
          paramzu = "";
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localdfh.nEf + " " + l1 + " " + paramzu);
        switch (localdfh.nEf)
        {
        case 9: 
          a((dfi)localObject3);
          if (com.tencent.mm.plugin.sns.ui.widget.e.ia(localdfh.HtL, 2)) {
            break label1731;
          }
          bool1 = true;
          ag.cVf().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95625);
              if (bool1)
              {
                Iterator localIterator = t.baY().iterator();
                while (localIterator.hasNext())
                {
                  av localav = (av)localIterator.next();
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                  localav.aBD();
                }
              }
              paramap.sendEmptyMessage(0);
              AppMethodBeat.o(95625);
            }
          });
          AppMethodBeat.o(95638);
          return true;
        }
      }
      catch (Exception paramzu)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramzu, "", new Object[0]);
        AppMethodBeat.o(95638);
        return false;
      }
      paramzu = ag.dUj().h(l1, localdfh.HtH, localdfh.nEf);
      if (paramzu != null)
      {
        paramzu.dYt();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(ag.dUj().update(paramzu.systemRowid, paramzu))));
      }
      else
      {
        ak.c(l1, (dfi)localObject3);
        continue;
        paramzu = ag.dUj().h(l1, localdfh.HtJ, localdfh.nEf);
        if (paramzu != null)
        {
          paramzu.dYt();
          bool1 = ag.dUj().update(paramzu.systemRowid, paramzu);
          ak.b(l1, (dfi)localObject3);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(bool1)));
          continue;
          paramzu = ag.dUj();
          localObject1 = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(l1));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(localObject1)));
          bool1 = paramzu.hHS.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramzu.doNotify();
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(bool1)));
          continue;
          paramzu = ag.dUj();
          localObject1 = localdfh.Hgt;
          localObject1 = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + bt.aQN((String)localObject1) + "'";
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(localObject1)));
          bool1 = paramzu.hHS.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramzu.doNotify();
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(bool1)));
          ak.b(l1, (dfi)localObject3);
          continue;
          a((dfi)localObject3, localdfh, l1, l2, paramzu);
          continue;
          b((dfi)localObject3, localdfh, l1, l2, paramzu);
          continue;
          com.tencent.mm.plugin.sns.storage.i.Ab(l1);
          paramzu = ag.dUe().Ai(l1);
          localObject1 = paramzu.dYl();
          ((TimeLineObject)localObject1).ePo = 1;
          paramzu.f((TimeLineObject)localObject1);
          ag.dUe().b(l1, paramzu);
          continue;
          localObject1 = localdfh.FvG;
          if (l.zD(l1))
          {
            paramzu = new l(l1, (cte)localObject1);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(paramzu, 0);
          }
          for (;;)
          {
            try
            {
              paramzu = ((dfi)localObject3).HtP;
              localObject4 = bt.nullAsNil(((dfi)localObject3).hCW);
              l2 = ((dfi)localObject3).HtO;
              int j = bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyLimit"), 0);
              int k = bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyLikeTimeLimit"), 0);
              int m = bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsAdNotifyCommentTimeLimit"), 0);
              if (localObject1 == null) {
                break label1089;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid64 %s, aid %s, commentId %s, actionLimit %s", new Object[] { localObject4, Long.valueOf(l1), Long.valueOf(((cte)localObject1).Hlz), Integer.valueOf(((cte)localObject1).Hlu), Integer.valueOf(paramzu.HtH), Integer.valueOf(j) });
              if ((((cte)localObject1).Hlz == 0L) && (((cte)localObject1).Hlu == 0)) {
                com.tencent.mm.plugin.report.service.g.yhR.dD(955, 4);
              }
              if (ag.dUj().a(l1, paramzu.Hgt, paramzu.CreateTime, (String)localObject4)) {
                break;
              }
              localObject5 = ((dfi)localObject3).HtQ;
              localObject1 = new j();
              ((j)localObject1).field_snsID = l1;
              ((j)localObject1).field_parentID = l2;
              ((j)localObject1).field_createTime = paramzu.CreateTime;
              ((j)localObject1).field_talker = paramzu.Hgt;
              ((j)localObject1).field_type = paramzu.nEf;
              ((j)localObject1).field_curActionBuf = paramzu.toByteArray();
              ((j)localObject1).field_refActionBuf = ((dfh)localObject5).toByteArray();
              ((j)localObject1).field_clientId = ((String)localObject4);
              if (!com.tencent.mm.plugin.sns.ui.widget.e.ia(paramzu.HtL, 2)) {
                break label1740;
              }
              i = 1;
              ((j)localObject1).field_isSilence = i;
              ((j)localObject1).field_commentSvrID = paramzu.HtJ;
              if (!ag.dUh().Aa(l1)) {
                break label1163;
              }
              if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, (dfi)localObject3, j, k, m, true))) {
                break label1110;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + ((j)localObject1).field_snsID + " " + ((j)localObject1).field_commentSvrID);
            }
            catch (Exception paramzu)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramzu, "", new Object[0]);
            }
            break;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
            com.tencent.mm.plugin.report.service.g.yhR.dD(955, 3);
          }
          if (!a.a(l1, (dfi)localObject3))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + ((j)localObject1).field_snsID + " " + ((j)localObject1).field_commentSvrID);
          }
          else
          {
            if ((!bt.hj(paramzu.HtM)) && (paramzu.HtM.get(0) != null))
            {
              localObject3 = ak.a((dft)paramzu.HtM.get(0));
              if (bd.frc().ILn.aUK(((EmojiInfo)localObject3).field_md5) == null)
              {
                bd.frc().ILn.J((EmojiInfo)localObject3);
                if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFY, 0) == 1))
                {
                  localObject4 = com.tencent.mm.emoji.loader.e.giz;
                  com.tencent.mm.emoji.loader.e.a((EmojiInfo)localObject3, null);
                }
              }
            }
            ag.dUj().insert((com.tencent.mm.sdk.e.c)localObject1);
            ag.dUj().E(l1, com.tencent.mm.plugin.sns.ui.widget.e.ia(paramzu.HtL, 2));
            continue;
            localObject5 = "";
            localObject6 = null;
            localObject3 = null;
            localStringBuilder = null;
            localObject1 = null;
            bool2 = false;
            bool1 = bool2;
            localObject4 = localStringBuilder;
            paramzu = localObject6;
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
          String str = com.tencent.mm.plugin.sns.data.q.zw(l1);
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramzu = localObject6;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=".concat(String.valueOf(str)));
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramzu = localObject6;
          com.tencent.mm.plugin.sns.storage.e locale = ag.dUh().zZ(l1);
          if (locale != null)
          {
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramzu = localObject6;
            localObject3 = locale.dRK();
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramzu = (zu)localObject3;
            localObject1 = locale.dRL();
          }
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzu = (zu)localObject3;
          bool2 = ag.dUh().delete(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzu = (zu)localObject3;
          ag.dUj().Ad(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzu = (zu)localObject3;
          com.tencent.mm.plugin.sns.storage.i.Ac(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzu = (zu)localObject3;
          localStringBuilder = new StringBuilder("processSnsAdFeedsForceDelAction snsId=").append(str).append(", delSucc=").append(bool2).append(", adSnsInfo==null?");
          if (locale != null) {
            break label1745;
          }
          bool3 = true;
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramzu = (zu)localObject3;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", bool3);
          paramzu = (zu)localObject3;
          localObject5 = str;
          bool1 = bool2;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction exp=" + localThrowable.toString() + ", snsId=" + (String)localObject5);
          Object localObject2 = localObject4;
          continue;
        }
        try
        {
          com.tencent.mm.plugin.sns.data.h.a(3, l1, paramzu, (com.tencent.mm.plugin.sns.storage.b)localObject1);
          if (!bool1) {
            break;
          }
          com.tencent.mm.plugin.sns.data.h.a(4, l1, paramzu, (com.tencent.mm.plugin.sns.storage.b)localObject1);
        }
        catch (Throwable paramzu)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction report exp=" + paramzu.toString() + ", snsId=" + (String)localObject5);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(95631);
    com.tencent.mm.kernel.g.ajD();
    byte[] arrayOfByte = bt.aRa(bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((dgr)this.rr.hNK.hNQ).FRr = localSKBuiltinBuffer_t;
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95636);
      return;
    }
    dgs localdgs = (dgs)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    paramArrayOfByte = localdgs.FRu.nDj;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.zhP;
      paramString.rbl = paramArrayOfByte;
      paramString.rtH.sendEmptyMessage(0);
      AppMethodBeat.o(95636);
      return;
    }
    if ((localdgs.FRr != null) && (localdgs.FRr.getBuffer() != null))
    {
      paramArrayOfByte = localdgs.FRr.getBuffer().toByteArray();
      paramq = com.tencent.mm.protocal.ad.k(((dgr)((com.tencent.mm.al.b)paramq).hNK.hNQ).FRr.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0))
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(8195, bt.cE(paramq));
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
    return n.b.hOp;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    LinkedList<zu> rbl;
    ap rtH;
    
    a()
    {
      AppMethodBeat.i(95629);
      this.rtH = new ap()
      {
        public final void handleMessage(final Message paramAnonymousMessage)
        {
          AppMethodBeat.i(95628);
          com.tencent.mm.kernel.g.ajD();
          if (!com.tencent.mm.kernel.g.ajA().aiK())
          {
            AppMethodBeat.o(95628);
            return;
          }
          if ((t.a.this.rbl == null) || (t.a.this.rbl.isEmpty()))
          {
            paramAnonymousMessage = t.this;
            dgs localdgs = (dgs)paramAnonymousMessage.rr.hNL.hNQ;
            dgr localdgr = (dgr)paramAnonymousMessage.rr.hNK.hNQ;
            byte[] arrayOfByte = localdgs.FRr.getBuffer().toByteArray();
            arrayOfByte = com.tencent.mm.protocal.ad.k(localdgr.FRr.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0))
            {
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajC().ajl().set(8195, bt.cE(arrayOfByte));
            }
            localdgr.FRr.setBuffer(arrayOfByte);
            if ((localdgs.FMr & localdgr.FRq) == 0)
            {
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(95628);
              return;
            }
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(95628);
            return;
          }
          paramAnonymousMessage = (zu)t.a.this.rbl.getFirst();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramAnonymousMessage.FYU);
          t.a.this.rbl.removeFirst();
          switch (paramAnonymousMessage.FYU)
          {
          default: 
            t.a.this.rtH.sendEmptyMessage(0);
            AppMethodBeat.o(95628);
            return;
          case 45: 
            ag.dFL().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95626);
                if (!t.this.a(paramAnonymousMessage, t.a.this.rtH)) {
                  t.a.this.rtH.sendEmptyMessage(0);
                }
                AppMethodBeat.o(95626);
              }
            });
            AppMethodBeat.o(95628);
            return;
          }
          ag.dFL().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95627);
              if (!t.this.b(paramAnonymousMessage, t.a.this.rtH)) {
                t.a.this.rtH.sendEmptyMessage(0);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t
 * JD-Core Version:    0.7.0.1
 */