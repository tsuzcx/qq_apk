package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cvs;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static List<au> wFA;
  private static com.tencent.mm.plugin.sns.j.c wFC;
  private static boolean wFD;
  com.tencent.mm.al.g callback;
  private String fki;
  com.tencent.mm.al.b rr;
  private a wFB;
  
  static
  {
    AppMethodBeat.i(95647);
    wFA = new LinkedList();
    wFD = true;
    AppMethodBeat.o(95647);
  }
  
  public t()
  {
    AppMethodBeat.i(95630);
    this.fki = "";
    this.wFB = new a();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", new Object[] { Integer.valueOf(256) });
    localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).gUU = new cvs();
    ((com.tencent.mm.al.b.a)localObject).gUV = new cvt();
    ((com.tencent.mm.al.b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((com.tencent.mm.al.b.a)localObject).funcId = 214;
    ((com.tencent.mm.al.b.a)localObject).reqCmdId = 102;
    ((com.tencent.mm.al.b.a)localObject).respCmdId = 1000000102;
    this.rr = ((com.tencent.mm.al.b.a)localObject).atI();
    ((cvs)this.rr.gUS.gUX).CRw = 256;
    this.fki = u.aqG();
    long l;
    byte[] arrayOfByte;
    if (wFD)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.afC();
      localObject = com.tencent.mm.kernel.g.afB().cachePath + "ad_1100007";
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(localObject)));
      arrayOfByte = com.tencent.mm.vfs.i.aR((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      wFC = (com.tencent.mm.plugin.sns.j.c)new com.tencent.mm.plugin.sns.j.c().parseFrom(arrayOfByte);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (wFC != null) {
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + wFC.wNR.size());
      }
    }
    wFD = false;
    AppMethodBeat.o(95630);
  }
  
  public static void a(au paramau)
  {
    AppMethodBeat.i(95645);
    if (!wFA.contains(paramau)) {
      wFA.add(paramau);
    }
    AppMethodBeat.o(95645);
  }
  
  private static boolean a(cuj paramcuj)
  {
    AppMethodBeat.i(95640);
    try
    {
      cui localcui1 = paramcuj.Emi;
      long l1 = paramcuj.Id;
      Object localObject = bt.nullAsNil(paramcuj.gKn);
      long l2 = paramcuj.Emh;
      int i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyLimit"), 0);
      int j = bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyLikeTimeLimit"), 0);
      int k = bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyCommentTimeLimit"), 0);
      if (((i > 0) || (j > 0) || (k > 0)) && ((localcui1.mBH == 8) || (localcui1.mBH == 7)) && (!a.a(l1, paramcuj, i, j, k, true)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + (String)localObject + " snsId: " + l1 + " " + localcui1.Emc + " " + localcui1.Ema + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
        a.a(l1, paramcuj);
        AppMethodBeat.o(95640);
        return false;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + (String)localObject + " snsId: " + l1 + " " + localcui1.Emc + " " + localcui1.Ema + " actionLimit: " + i);
      if (!af.dtz().a(l1, localcui1.DZr, localcui1.CreateTime, (String)localObject))
      {
        cui localcui2 = paramcuj.Emj;
        j localj = new j();
        localj.field_snsID = l1;
        localj.field_parentID = l2;
        localj.field_createTime = localcui1.CreateTime;
        localj.field_talker = localcui1.DZr;
        localj.field_type = localcui1.mBH;
        localj.field_curActionBuf = localcui1.toByteArray();
        localj.field_refActionBuf = localcui2.toByteArray();
        localj.field_clientId = ((String)localObject);
        if (com.tencent.mm.plugin.sns.ui.widget.e.hA(localcui1.Eme, 2)) {}
        for (i = 1;; i = 0)
        {
          localj.field_isSilence = i;
          if ((localcui1.mBH != 8) && (localcui1.mBH != 7)) {
            break;
          }
          localj.field_commentSvrID = localcui1.Emc;
          if (a.a(l1, paramcuj)) {
            break label548;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localj.field_snsID + " " + localj.field_commentSvrID);
          AppMethodBeat.o(95640);
          return false;
        }
        localj.field_commentSvrID = localcui1.Ema;
        boolean bool = aj.a(l1, paramcuj);
        if (!bool)
        {
          AppMethodBeat.o(95640);
          return false;
        }
        label548:
        if ((!bt.gL(localcui1.Emf)) && (localcui1.Emf.get(0) != null))
        {
          paramcuj = aj.a((cuu)localcui1.Emf.get(0));
          if (aw.eLx().FyY.aJx(paramcuj.field_md5) == null)
          {
            aw.eLx().FyY.K(paramcuj);
            if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwo, 0) == 1))
            {
              localObject = com.tencent.mm.emoji.loader.e.fLn;
              com.tencent.mm.emoji.loader.e.a(paramcuj, null);
            }
          }
        }
        af.dtz().insert(localj);
        af.dtz().E(l1, com.tencent.mm.plugin.sns.ui.widget.e.hA(localcui1.Eme, 2));
        AppMethodBeat.o(95640);
        return true;
      }
      AppMethodBeat.o(95640);
      return false;
    }
    catch (Exception paramcuj)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramcuj, "", new Object[0]);
      AppMethodBeat.o(95640);
    }
    return false;
  }
  
  private static boolean a(cuj paramcuj, cui paramcui, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95641);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramcui.Emc + " " + paramcui.Ema);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.dsr())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        AppMethodBeat.o(95641);
        return false;
      }
      if (!af.dtz().a(paramLong1, paramcui.DZr, paramcui.CreateTime, paramString))
      {
        cui localcui = paramcuj.Emj;
        j localj = new j();
        localj.field_snsID = paramLong1;
        localj.field_parentID = paramLong2;
        localj.field_createTime = paramcui.CreateTime;
        localj.field_talker = paramcui.DZr;
        localj.field_type = paramcui.mBH;
        localj.field_curActionBuf = paramcui.toByteArray();
        localj.field_refActionBuf = localcui.toByteArray();
        localj.field_clientId = paramString;
        localj.field_commentSvrID = paramcui.Ema;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramcui.Emd);
        aj.c(paramLong1, paramcuj);
        arK();
        af.dtz().insert(localj);
        AppMethodBeat.o(95641);
        return true;
      }
      AppMethodBeat.o(95641);
      return false;
    }
    catch (Exception paramcuj)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramcuj.getMessage());
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramcuj, "", new Object[0]);
      AppMethodBeat.o(95641);
    }
    return false;
  }
  
  private static void arK()
  {
    AppMethodBeat.i(95644);
    Iterator localIterator = wFA.iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      if (localau != null) {
        localau.arK();
      }
    }
    AppMethodBeat.o(95644);
  }
  
  public static void b(au paramau)
  {
    AppMethodBeat.i(95646);
    wFA.remove(paramau);
    AppMethodBeat.o(95646);
  }
  
  private static boolean b(cuj paramcuj, cui paramcui, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95642);
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramcui.Emc + " " + paramcui.Ema);
      if (!af.dtz().a(paramLong1, paramcui.DZr, paramcui.CreateTime, paramString))
      {
        cui localcui = paramcuj.Emj;
        paramcuj = new j();
        paramcuj.field_snsID = paramLong1;
        paramcuj.field_parentID = paramLong2;
        paramcuj.field_createTime = paramcui.CreateTime;
        paramcuj.field_talker = paramcui.DZr;
        paramcuj.field_type = paramcui.mBH;
        paramcuj.field_curActionBuf = paramcui.toByteArray();
        paramcuj.field_refActionBuf = localcui.toByteArray();
        paramcuj.field_clientId = paramString;
        paramcuj.field_commentSvrID = paramcui.Ema;
        paramString = new bft();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramcui.Emd);
        paramString.parseFrom(z.a(paramcui.Emd));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.dEb);
        af.dtz().insert(paramcuj);
        AppMethodBeat.o(95642);
        return true;
      }
      AppMethodBeat.o(95642);
      return false;
    }
    catch (Exception paramcuj)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramcuj.getMessage());
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramcuj, "", new Object[0]);
      AppMethodBeat.o(95642);
    }
    return false;
  }
  
  public static void dsO()
  {
    AppMethodBeat.i(95635);
    if (wFC == null)
    {
      AppMethodBeat.o(95635);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = com.tencent.mm.kernel.g.afB().cachePath + "ad_1100007";
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(localObject)));
    try
    {
      byte[] arrayOfByte = wFC.toByteArray();
      com.tencent.mm.vfs.i.f((String)localObject, arrayOfByte, arrayOfByte.length);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + wFC.wNR.size());
      AppMethodBeat.o(95635);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: ".concat(String.valueOf(localObject)), new Object[0]);
      AppMethodBeat.o(95635);
    }
  }
  
  public static void dsP()
  {
    AppMethodBeat.i(95643);
    Iterator localIterator = wFA.iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      if (localau != null) {
        localau.arL();
      }
    }
    AppMethodBeat.o(95643);
  }
  
  public static void sF(long paramLong)
  {
    AppMethodBeat.i(95632);
    if (wFC == null) {
      wFC = new com.tencent.mm.plugin.sns.j.c();
    }
    wFC.wNR.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95632);
  }
  
  public static void sG(long paramLong)
  {
    AppMethodBeat.i(95633);
    if (wFC != null) {
      wFC.wNR.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(95633);
  }
  
  public static boolean sH(long paramLong)
  {
    AppMethodBeat.i(95634);
    if (wFC == null)
    {
      AppMethodBeat.o(95634);
      return false;
    }
    if (wFC.wNR.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95634);
      return true;
    }
    AppMethodBeat.o(95634);
    return false;
  }
  
  public static boolean sI(long paramLong)
  {
    AppMethodBeat.i(95639);
    try
    {
      boolean bool = a.a(paramLong, null, bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyLimit"), 0), bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyLikeTimeLimit"), 0), bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
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
  
  public final boolean a(xd paramxd, final ap paramap)
  {
    AppMethodBeat.i(95637);
    final SnsObject localSnsObject;
    boolean bool;
    try
    {
      localSnsObject = (SnsObject)new SnsObject().parseFrom(paramxd.CYZ.getBuffer().toByteArray());
      paramxd = new String(localSnsObject.ObjectDesc.getBuffer().toByteArray());
      if (paramxd.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label452;
      }
      if (paramxd.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label467;
      }
    }
    catch (Exception paramxd)
    {
      com.tencent.mm.plugin.sns.storage.n localn;
      String[] arrayOfString;
      int i;
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramxd, "", new Object[0]);
      AppMethodBeat.o(95637);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localSnsObject.Id + " " + com.tencent.mm.plugin.sns.data.q.st(localSnsObject.Id) + " isPhoto " + bool);
    String str;
    int j;
    if (bool)
    {
      str = com.tencent.mm.plugin.sns.data.q.st(localSnsObject.Id);
      localn = af.dty().apP(localSnsObject.Username);
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
        paramxd = paramxd + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localSnsObject.Id + " S: " + str + " list " + localn.field_newerIds + " newer " + paramxd);
        if (i != 0) {
          af.dty().je(localSnsObject.Username, paramxd);
        }
        while (af.dtu().sZ(localSnsObject.Id))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          AppMethodBeat.o(95637);
          return false;
          label374:
          af.dty().je(localSnsObject.Username, str);
        }
        com.tencent.mm.sdk.b.a.ESL.l(new tr());
        af.czA().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95624);
            if (!localSnsObject.Username.equals(t.a(t.this)))
            {
              com.tencent.mm.kernel.g.afC();
              if (!com.tencent.mm.kernel.g.afz().aeI())
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                AppMethodBeat.o(95624);
                return;
              }
              com.tencent.mm.kernel.g.afC();
              Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(68377, null);
              com.tencent.mm.kernel.g.afC();
              if ((bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(68400, null), 0) != localSnsObject.CreateTime) || ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equals(localSnsObject.Username))))
              {
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.kernel.g.afB().afk().set(68377, localSnsObject.Username);
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.kernel.g.afB().afk().set(68400, Integer.valueOf(localSnsObject.CreateTime));
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.kernel.g.afB().afk().set(68418, com.tencent.mm.plugin.sns.data.q.st(localSnsObject.Id));
                com.tencent.mm.kernel.g.afC();
                com.tencent.mm.kernel.g.afB().afk().set(68419, Integer.valueOf(0));
                com.tencent.mm.plugin.sns.k.g.p(1, com.tencent.mm.plugin.sns.data.q.st(localSnsObject.Id), 0);
              }
              localObject = t.dsQ().iterator();
              while (((Iterator)localObject).hasNext()) {
                ((au)((Iterator)localObject).next()).arJ();
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
        paramxd = str;
      }
    }
  }
  
  public final boolean b(xd paramxd, final ap paramap)
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
    label973:
    label1111:
    Object localObject6;
    label1090:
    StringBuilder localStringBuilder;
    label1164:
    boolean bool2;
    for (;;)
    {
      long l2;
      final cui localcui;
      try
      {
        localObject3 = (cuj)new cuj().parseFrom(paramxd.CYZ.getBuffer().toByteArray());
        l1 = ((cuj)localObject3).Id;
        l2 = ((cuj)localObject3).Emh;
        localcui = ((cuj)localObject3).Emi;
        localObject1 = ((cuj)localObject3).gKn;
        paramxd = (xd)localObject1;
        if (localObject1 == null) {
          paramxd = "";
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localcui.mBH + " " + l1 + " " + paramxd);
        switch (localcui.mBH)
        {
        case 9: 
          a((cuj)localObject3);
          if (com.tencent.mm.plugin.sns.ui.widget.e.hA(localcui.Eme, 2)) {
            break label1732;
          }
          bool1 = true;
          af.czA().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95625);
              if (bool1)
              {
                Iterator localIterator = t.dsQ().iterator();
                while (localIterator.hasNext())
                {
                  au localau = (au)localIterator.next();
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                  localau.arI();
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
      catch (Exception paramxd)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramxd, "", new Object[0]);
        AppMethodBeat.o(95638);
        return false;
      }
      paramxd = af.dtz().h(l1, localcui.Ema, localcui.mBH);
      if (paramxd != null)
      {
        paramxd.dxG();
        bool1 = af.dtz().update(paramxd.systemRowid, paramxd);
        aj.b(l1, (cuj)localObject3);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(bool1)));
        continue;
        paramxd = af.dtz().h(l1, localcui.Emc, localcui.mBH);
        if (paramxd != null)
        {
          paramxd.dxG();
          bool1 = af.dtz().update(paramxd.systemRowid, paramxd);
          aj.b(l1, (cuj)localObject3);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(bool1)));
          continue;
          paramxd = af.dtz();
          localObject1 = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(l1));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(localObject1)));
          bool1 = paramxd.gPa.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramxd.doNotify();
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(bool1)));
          continue;
          paramxd = af.dtz();
          localObject1 = localcui.DZr;
          localObject1 = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + bt.aFQ((String)localObject1) + "'";
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(localObject1)));
          bool1 = paramxd.gPa.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramxd.doNotify();
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(bool1)));
          aj.b(l1, (cuj)localObject3);
          continue;
          a((cuj)localObject3, localcui, l1, l2, paramxd);
          continue;
          b((cuj)localObject3, localcui, l1, l2, paramxd);
          continue;
          com.tencent.mm.plugin.sns.storage.i.ta(l1);
          paramxd = af.dtu().th(l1);
          localObject1 = paramxd.dxy();
          ((TimeLineObject)localObject1).evt = 1;
          paramxd.g((TimeLineObject)localObject1);
          af.dtu().b(l1, paramxd);
          continue;
          localObject1 = localcui.CxV;
          if (l.sB(l1))
          {
            paramxd = new l(l1, (ciu)localObject1);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramxd, 0);
          }
          for (;;)
          {
            try
            {
              paramxd = ((cuj)localObject3).Emi;
              localObject4 = bt.nullAsNil(((cuj)localObject3).gKn);
              l2 = ((cuj)localObject3).Emh;
              int j = bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyLimit"), 0);
              int k = bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyLikeTimeLimit"), 0);
              int m = bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsAdNotifyCommentTimeLimit"), 0);
              if (localObject1 == null) {
                break label1090;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid64 %s, aid %s, commentId %s, actionLimit %s", new Object[] { localObject4, Long.valueOf(l1), Long.valueOf(((ciu)localObject1).Eem), Integer.valueOf(((ciu)localObject1).Eeh), Integer.valueOf(paramxd.Ema), Integer.valueOf(j) });
              if ((((ciu)localObject1).Eem == 0L) && (((ciu)localObject1).Eeh == 0)) {
                com.tencent.mm.plugin.report.service.h.vKh.dB(955, 4);
              }
              if (af.dtz().a(l1, paramxd.DZr, paramxd.CreateTime, (String)localObject4)) {
                break;
              }
              localObject5 = ((cuj)localObject3).Emj;
              localObject1 = new j();
              ((j)localObject1).field_snsID = l1;
              ((j)localObject1).field_parentID = l2;
              ((j)localObject1).field_createTime = paramxd.CreateTime;
              ((j)localObject1).field_talker = paramxd.DZr;
              ((j)localObject1).field_type = paramxd.mBH;
              ((j)localObject1).field_curActionBuf = paramxd.toByteArray();
              ((j)localObject1).field_refActionBuf = ((cui)localObject5).toByteArray();
              ((j)localObject1).field_clientId = ((String)localObject4);
              if (!com.tencent.mm.plugin.sns.ui.widget.e.hA(paramxd.Eme, 2)) {
                break label1741;
              }
              i = 1;
              ((j)localObject1).field_isSilence = i;
              ((j)localObject1).field_commentSvrID = paramxd.Emc;
              if (!af.dtx().sZ(l1)) {
                break label1164;
              }
              if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, (cuj)localObject3, j, k, m, true))) {
                break label1111;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + ((j)localObject1).field_snsID + " " + ((j)localObject1).field_commentSvrID);
            }
            catch (Exception paramxd)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramxd, "", new Object[0]);
            }
            break;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
            com.tencent.mm.plugin.report.service.h.vKh.dB(955, 3);
          }
          if (!a.a(l1, (cuj)localObject3))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + ((j)localObject1).field_snsID + " " + ((j)localObject1).field_commentSvrID);
          }
          else
          {
            if ((!bt.gL(paramxd.Emf)) && (paramxd.Emf.get(0) != null))
            {
              localObject3 = aj.a((cuu)paramxd.Emf.get(0));
              if (aw.eLx().FyY.aJx(((EmojiInfo)localObject3).field_md5) == null)
              {
                aw.eLx().FyY.K((EmojiInfo)localObject3);
                if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwo, 0) == 1))
                {
                  localObject4 = com.tencent.mm.emoji.loader.e.fLn;
                  com.tencent.mm.emoji.loader.e.a((EmojiInfo)localObject3, null);
                }
              }
            }
            af.dtz().insert((com.tencent.mm.sdk.e.c)localObject1);
            af.dtz().E(l1, com.tencent.mm.plugin.sns.ui.widget.e.hA(paramxd.Eme, 2));
            continue;
            localObject5 = "";
            localObject6 = null;
            localObject3 = null;
            localStringBuilder = null;
            localObject1 = null;
            bool2 = false;
            bool1 = bool2;
            localObject4 = localStringBuilder;
            paramxd = localObject6;
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
          String str = com.tencent.mm.plugin.sns.data.q.st(l1);
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramxd = localObject6;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=".concat(String.valueOf(str)));
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramxd = localObject6;
          com.tencent.mm.plugin.sns.storage.e locale = af.dtx().sY(l1);
          if (locale != null)
          {
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramxd = localObject6;
            localObject3 = locale.dxu();
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramxd = (xd)localObject3;
            localObject1 = locale.dxs();
          }
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxd = (xd)localObject3;
          bool2 = af.dtx().delete(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxd = (xd)localObject3;
          af.dtz().tc(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxd = (xd)localObject3;
          com.tencent.mm.plugin.sns.storage.i.tb(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxd = (xd)localObject3;
          localStringBuilder = new StringBuilder("processSnsAdFeedsForceDelAction snsId=").append(str).append(", delSucc=").append(bool2).append(", adSnsInfo==null?");
          if (locale != null) {
            break label1746;
          }
          bool3 = true;
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramxd = (xd)localObject3;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneNewSyncAlbum", bool3);
          paramxd = (xd)localObject3;
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
          com.tencent.mm.plugin.sns.data.h.a(3, l1, paramxd, (com.tencent.mm.plugin.sns.storage.b)localObject1);
          if (!bool1) {
            break;
          }
          com.tencent.mm.plugin.sns.data.h.a(4, l1, paramxd, (com.tencent.mm.plugin.sns.storage.b)localObject1);
        }
        catch (Throwable paramxd)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction report exp=" + paramxd.toString() + ", snsId=" + (String)localObject5);
        }
      }
      break label178;
      label1732:
      bool1 = false;
      break label193;
      break;
      label1741:
      i = 0;
      break label973;
      label1746:
      boolean bool3 = false;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(95631);
    com.tencent.mm.kernel.g.afC();
    byte[] arrayOfByte = bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((cvs)this.rr.gUS.gUX).CRx = localSKBuiltinBuffer_t;
    this.callback = paramg;
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
    cvt localcvt = (cvt)((com.tencent.mm.al.b)paramq).gUT.gUX;
    paramArrayOfByte = localcvt.CRA.mAL;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.wFB;
      paramString.pJl = paramArrayOfByte;
      paramString.qaZ.sendEmptyMessage(0);
      AppMethodBeat.o(95636);
      return;
    }
    if ((localcvt.CRx != null) && (localcvt.CRx.getBuffer() != null))
    {
      paramArrayOfByte = localcvt.CRx.getBuffer().toByteArray();
      paramq = com.tencent.mm.protocal.ad.k(((cvs)((com.tencent.mm.al.b)paramq).gUS.gUX).CRx.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0))
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(8195, bt.cy(paramq));
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
    return n.b.gVB;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    LinkedList<xd> pJl;
    ap qaZ;
    
    a()
    {
      AppMethodBeat.i(95629);
      this.qaZ = new ap()
      {
        public final void handleMessage(final Message paramAnonymousMessage)
        {
          AppMethodBeat.i(95628);
          com.tencent.mm.kernel.g.afC();
          if (!com.tencent.mm.kernel.g.afz().aeI())
          {
            AppMethodBeat.o(95628);
            return;
          }
          if ((t.a.this.pJl == null) || (t.a.this.pJl.isEmpty()))
          {
            paramAnonymousMessage = t.this;
            cvt localcvt = (cvt)paramAnonymousMessage.rr.gUT.gUX;
            cvs localcvs = (cvs)paramAnonymousMessage.rr.gUS.gUX;
            byte[] arrayOfByte = localcvt.CRx.getBuffer().toByteArray();
            arrayOfByte = com.tencent.mm.protocal.ad.k(localcvs.CRx.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0))
            {
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afB().afk().set(8195, bt.cy(arrayOfByte));
            }
            localcvs.CRx.setBuffer(arrayOfByte);
            if ((localcvt.CNq & localcvs.CRw) == 0)
            {
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(95628);
              return;
            }
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(95628);
            return;
          }
          paramAnonymousMessage = (xd)t.a.this.pJl.getFirst();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramAnonymousMessage.CYY);
          t.a.this.pJl.removeFirst();
          switch (paramAnonymousMessage.CYY)
          {
          default: 
            t.a.this.qaZ.sendEmptyMessage(0);
            AppMethodBeat.o(95628);
            return;
          case 45: 
            af.dhI().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95626);
                if (!t.this.a(paramAnonymousMessage, t.a.this.qaZ)) {
                  t.a.this.qaZ.sendEmptyMessage(0);
                }
                AppMethodBeat.o(95626);
              }
            });
            AppMethodBeat.o(95628);
            return;
          }
          af.dhI().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95627);
              if (!t.this.b(paramAnonymousMessage, t.a.this.qaZ)) {
                t.a.this.qaZ.sendEmptyMessage(0);
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