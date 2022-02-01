package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.yt;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.protocal.protobuf.ffd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends com.tencent.mm.am.p
  implements com.tencent.mm.network.m
{
  private static List<bc> QsO;
  private static com.tencent.mm.plugin.sns.k.b QsQ;
  private static boolean QsR;
  private a QsP;
  com.tencent.mm.am.h callback;
  private String ltf;
  com.tencent.mm.am.c rr;
  
  static
  {
    AppMethodBeat.i(95647);
    QsO = new LinkedList();
    QsR = true;
    AppMethodBeat.o(95647);
  }
  
  public v()
  {
    AppMethodBeat.i(95630);
    this.ltf = "";
    this.QsP = new a();
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", new Object[] { Integer.valueOf(256) });
    localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = new ffc();
    ((com.tencent.mm.am.c.a)localObject).otF = new ffd();
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((com.tencent.mm.am.c.a)localObject).funcId = 214;
    ((com.tencent.mm.am.c.a)localObject).otG = 102;
    ((com.tencent.mm.am.c.a)localObject).respCmdId = 1000000102;
    this.rr = ((com.tencent.mm.am.c.a)localObject).bEF();
    ((ffc)c.b.b(this.rr.otB)).ZdC = 256;
    this.ltf = z.bAM();
    long l;
    byte[] arrayOfByte;
    if (QsR)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.h.baF();
      localObject = com.tencent.mm.kernel.h.baE().cachePath + "ad_1100007";
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(localObject)));
      arrayOfByte = y.bi((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      QsQ = (com.tencent.mm.plugin.sns.k.b)new com.tencent.mm.plugin.sns.k.b().parseFrom(arrayOfByte);
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (QsQ != null) {
        break label293;
      }
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localIOException, "", new Object[0]);
        y.deleteFile((String)localObject);
        continue;
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + QsQ.QCv.size());
      }
    }
    QsR = false;
    AppMethodBeat.o(95630);
  }
  
  public static void a(bc parambc)
  {
    AppMethodBeat.i(95645);
    if (!QsO.contains(parambc)) {
      QsO.add(parambc);
    }
    AppMethodBeat.o(95645);
  }
  
  private static boolean a(fdq paramfdq)
  {
    AppMethodBeat.i(95640);
    try
    {
      fdp localfdp1 = paramfdq.abDp;
      long l1 = paramfdq.Id;
      Object localObject = Util.nullAsNil(paramfdq.nUv);
      long l2 = paramfdq.abDo;
      int i = Util.getInt(i.aRC().getValue("SnsAdNotifyLimit"), 0);
      int j = Util.getInt(i.aRC().getValue("SnsAdNotifyLikeTimeLimit"), 0);
      int k = Util.getInt(i.aRC().getValue("SnsAdNotifyCommentTimeLimit"), 0);
      if (((i > 0) || (j > 0) || (k > 0)) && ((localfdp1.vhJ == 8) || (localfdp1.vhJ == 7)) && (!a.a(l1, paramfdq, i, j, k, true)))
      {
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + (String)localObject + " snsId: " + l1 + " " + localfdp1.abDj + " " + localfdp1.abDh + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
        a.a(l1, paramfdq);
        AppMethodBeat.o(95640);
        return false;
      }
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + (String)localObject + " snsId: " + l1 + " " + localfdp1.abDj + " " + localfdp1.abDh + " actionLimit: " + i);
      if (!al.hgH().a(l1, localfdp1.abnl, localfdp1.CreateTime, (String)localObject))
      {
        fdp localfdp2 = paramfdq.abDq;
        o localo = new o();
        localo.field_snsID = l1;
        localo.field_parentID = l2;
        localo.field_createTime = localfdp1.CreateTime;
        localo.field_talker = localfdp1.abnl;
        localo.field_type = localfdp1.vhJ;
        localo.field_curActionBuf = localfdp1.toByteArray();
        localo.field_refActionBuf = localfdp2.toByteArray();
        localo.field_clientId = ((String)localObject);
        if (com.tencent.mm.plugin.sns.ui.widget.g.lU(localfdp1.abDl, 2)) {}
        for (i = 1;; i = 0)
        {
          localo.field_isSilence = i;
          if ((localfdp1.vhJ != 8) && (localfdp1.vhJ != 7)) {
            break;
          }
          localo.field_commentSvrID = localfdp1.abDj;
          if (a.a(l1, paramfdq)) {
            break label548;
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localo.field_snsID + " " + localo.field_commentSvrID);
          AppMethodBeat.o(95640);
          return false;
        }
        localo.field_commentSvrID = localfdp1.abDh;
        boolean bool = ap.a(l1, paramfdq);
        if (!bool)
        {
          AppMethodBeat.o(95640);
          return false;
        }
        label548:
        if ((!Util.isNullOrNil(localfdp1.abDm)) && (localfdp1.abDm.get(0) != null))
        {
          paramfdq = ap.a((feb)localfdp1.abDm.get(0));
          if (bl.jba().adju.bza(paramfdq.field_md5) == null)
          {
            bl.jba().adju.L(paramfdq);
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znH, 0) == 1))
            {
              localObject = e.mgl;
              e.a(paramfdq, null);
            }
          }
        }
        al.hgH().insert(localo);
        al.hgH().V(l1, com.tencent.mm.plugin.sns.ui.widget.g.lU(localfdp1.abDl, 2));
        AppMethodBeat.o(95640);
        return true;
      }
      AppMethodBeat.o(95640);
      return false;
    }
    catch (Exception paramfdq)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramfdq, "", new Object[0]);
      AppMethodBeat.o(95640);
    }
    return false;
  }
  
  private static boolean a(fdq paramfdq, fdp paramfdp, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95641);
    try
    {
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramfdp.abDj + " " + paramfdp.abDh);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.hfn())
      {
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        AppMethodBeat.o(95641);
        return false;
      }
      if (!al.hgH().a(paramLong1, paramfdp.abnl, paramfdp.CreateTime, paramString))
      {
        fdp localfdp = paramfdq.abDq;
        o localo = new o();
        localo.field_snsID = paramLong1;
        localo.field_parentID = paramLong2;
        localo.field_createTime = paramfdp.CreateTime;
        localo.field_talker = paramfdp.abnl;
        localo.field_type = paramfdp.vhJ;
        localo.field_curActionBuf = paramfdp.toByteArray();
        localo.field_refActionBuf = localfdp.toByteArray();
        localo.field_clientId = paramString;
        localo.field_commentSvrID = paramfdp.abDh;
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramfdp.abDk);
        ap.d(paramLong1, paramfdq);
        bCp();
        al.hgH().insert(localo);
        AppMethodBeat.o(95641);
        return true;
      }
      AppMethodBeat.o(95641);
      return false;
    }
    catch (Exception paramfdq)
    {
      Log.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramfdq.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramfdq, "", new Object[0]);
      AppMethodBeat.o(95641);
    }
    return false;
  }
  
  public static void b(bc parambc)
  {
    AppMethodBeat.i(95646);
    QsO.remove(parambc);
    AppMethodBeat.o(95646);
  }
  
  private static boolean b(fdq paramfdq, fdp paramfdp, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95642);
    try
    {
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramfdp.abDj + " " + paramfdp.abDh);
      if (!al.hgH().a(paramLong1, paramfdp.abnl, paramfdp.CreateTime, paramString))
      {
        fdp localfdp = paramfdq.abDq;
        paramfdq = new o();
        paramfdq.field_snsID = paramLong1;
        paramfdq.field_parentID = paramLong2;
        paramfdq.field_createTime = paramfdp.CreateTime;
        paramfdq.field_talker = paramfdp.abnl;
        paramfdq.field_type = paramfdp.vhJ;
        paramfdq.field_curActionBuf = paramfdp.toByteArray();
        paramfdq.field_refActionBuf = localfdp.toByteArray();
        paramfdq.field_clientId = paramString;
        paramfdq.field_commentSvrID = paramfdp.abDh;
        paramString = new czh();
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramfdp.abDk);
        paramString.parseFrom(com.tencent.mm.platformtools.w.a(paramfdp.abDk));
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.ihV);
        al.hgH().insert(paramfdq);
        AppMethodBeat.o(95642);
        return true;
      }
      AppMethodBeat.o(95642);
      return false;
    }
    catch (Exception paramfdq)
    {
      Log.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramfdq.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramfdq, "", new Object[0]);
      AppMethodBeat.o(95642);
    }
    return false;
  }
  
  private static void bCp()
  {
    AppMethodBeat.i(95644);
    Iterator localIterator = QsO.iterator();
    while (localIterator.hasNext())
    {
      bc localbc = (bc)localIterator.next();
      if (localbc != null) {
        localbc.bCp();
      }
    }
    AppMethodBeat.o(95644);
  }
  
  public static void hfO()
  {
    AppMethodBeat.i(95635);
    if (QsQ == null)
    {
      AppMethodBeat.o(95635);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().cachePath + "ad_1100007";
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(localObject)));
    try
    {
      byte[] arrayOfByte = QsQ.toByteArray();
      y.f((String)localObject, arrayOfByte, arrayOfByte.length);
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + QsQ.QCv.size());
      AppMethodBeat.o(95635);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: ".concat(String.valueOf(localObject)), new Object[0]);
      AppMethodBeat.o(95635);
    }
  }
  
  public static void jZ()
  {
    AppMethodBeat.i(95643);
    Iterator localIterator = QsO.iterator();
    while (localIterator.hasNext())
    {
      bc localbc = (bc)localIterator.next();
      if (localbc != null) {
        localbc.bCq();
      }
    }
    AppMethodBeat.o(95643);
  }
  
  public static void uK(long paramLong)
  {
    AppMethodBeat.i(95632);
    if (QsQ == null) {
      QsQ = new com.tencent.mm.plugin.sns.k.b();
    }
    QsQ.QCv.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95632);
  }
  
  public static void uL(long paramLong)
  {
    AppMethodBeat.i(95633);
    if (QsQ != null) {
      QsQ.QCv.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(95633);
  }
  
  public static boolean uM(long paramLong)
  {
    AppMethodBeat.i(95634);
    if (QsQ == null)
    {
      AppMethodBeat.o(95634);
      return false;
    }
    if (QsQ.QCv.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95634);
      return true;
    }
    AppMethodBeat.o(95634);
    return false;
  }
  
  public static boolean uN(long paramLong)
  {
    AppMethodBeat.i(95639);
    try
    {
      boolean bool = a.a(paramLong, null, Util.getInt(i.aRC().getValue("SnsAdNotifyLimit"), 0), Util.getInt(i.aRC().getValue("SnsAdNotifyLikeTimeLimit"), 0), Util.getInt(i.aRC().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
      AppMethodBeat.o(95639);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "", new Object[0]);
      AppMethodBeat.o(95639);
    }
    return true;
  }
  
  public final boolean a(adw paramadw, final MMHandler paramMMHandler)
  {
    AppMethodBeat.i(95637);
    final SnsObject localSnsObject;
    boolean bool;
    try
    {
      localSnsObject = (SnsObject)new SnsObject().parseFrom(paramadw.Zmd.aaxD.toByteArray());
      paramadw = new String(localSnsObject.ObjectDesc.aaxD.toByteArray());
      if (paramadw.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label449;
      }
      if (paramadw.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label464;
      }
    }
    catch (Exception paramadw)
    {
      u localu;
      String[] arrayOfString;
      int i;
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramadw, "", new Object[0]);
      AppMethodBeat.o(95637);
      return false;
    }
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localSnsObject.Id + " " + t.uA(localSnsObject.Id) + " isPhoto " + bool);
    String str;
    int j;
    if (bool)
    {
      str = t.uA(localSnsObject.Id);
      localu = al.hgF().aZW(localSnsObject.Username);
      if (Util.isNullOrNil(localu.field_newerIds)) {
        break label374;
      }
      arrayOfString = localu.field_newerIds.split(",");
      j = 0;
      i = 1;
      label184:
      if (j >= arrayOfString.length) {
        break label470;
      }
      if (!str.equals(arrayOfString[j])) {
        break label455;
      }
      i = 0;
      break label455;
    }
    for (;;)
    {
      if ((j < 2) && (j < arrayOfString.length) && (i != 0))
      {
        paramadw = paramadw + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        Log.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localSnsObject.Id + " S: " + str + " list " + localu.field_newerIds + " newer " + paramadw);
        if (i != 0) {
          al.hgF().mP(localSnsObject.Username, paramadw);
        }
        while (al.hgB().vi(localSnsObject.Id))
        {
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          AppMethodBeat.o(95637);
          return false;
          label374:
          al.hgF().mP(localSnsObject.Username, str);
        }
        new yt().publish();
        al.fAG().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95624);
            if (!localSnsObject.Username.equals(v.a(v.this)))
            {
              com.tencent.mm.kernel.h.baF();
              if (!com.tencent.mm.kernel.h.baC().aZN())
              {
                Log.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                AppMethodBeat.o(95624);
                return;
              }
              com.tencent.mm.kernel.h.baF();
              Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(68377, null);
              com.tencent.mm.kernel.h.baF();
              if ((Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(68400, null), 0) != localSnsObject.CreateTime) || ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(localSnsObject.Username))))
              {
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().B(68377, localSnsObject.Username);
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().B(68400, Integer.valueOf(localSnsObject.CreateTime));
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().B(68418, t.uA(localSnsObject.Id));
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().B(68419, Integer.valueOf(0));
                com.tencent.mm.plugin.sns.statistics.k.z(1, t.uA(localSnsObject.Id), 0);
              }
              localObject = v.QsO.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((bc)((Iterator)localObject).next()).bCo();
              }
            }
            paramMMHandler.sendEmptyMessage(0);
            AppMethodBeat.o(95624);
          }
        });
        AppMethodBeat.o(95637);
        return true;
        label449:
        bool = true;
        break;
        label455:
        j += 1;
        break label184;
        label464:
        bool = false;
        break;
        label470:
        j = 0;
        paramadw = str;
      }
    }
  }
  
  public final boolean b(adw paramadw, final MMHandler paramMMHandler)
  {
    AppMethodBeat.i(95638);
    Object localObject4;
    long l1;
    Object localObject1;
    label178:
    final boolean bool1;
    label193:
    Object localObject5;
    Object localObject6;
    int i;
    label972:
    label1110:
    Object localObject7;
    label1089:
    StringBuilder localStringBuilder;
    label1163:
    boolean bool2;
    for (;;)
    {
      long l2;
      final fdp localfdp;
      try
      {
        localObject4 = (fdq)new fdq().parseFrom(paramadw.Zmd.aaxD.toByteArray());
        l1 = ((fdq)localObject4).Id;
        l2 = ((fdq)localObject4).abDo;
        localfdp = ((fdq)localObject4).abDp;
        localObject1 = ((fdq)localObject4).nUv;
        paramadw = (adw)localObject1;
        if (localObject1 == null) {
          paramadw = "";
        }
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localfdp.vhJ + " " + l1 + " " + paramadw);
        switch (localfdp.vhJ)
        {
        case 9: 
          a((fdq)localObject4);
          if (com.tencent.mm.plugin.sns.ui.widget.g.lU(localfdp.abDl, 2)) {
            break label1731;
          }
          bool1 = true;
          al.fAG().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95625);
              if (bool1)
              {
                Iterator localIterator = v.QsO.iterator();
                while (localIterator.hasNext())
                {
                  bc localbc = (bc)localIterator.next();
                  Log.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                  localbc.bCn();
                }
              }
              paramMMHandler.sendEmptyMessage(0);
              AppMethodBeat.o(95625);
            }
          });
          AppMethodBeat.o(95638);
          return true;
        }
      }
      catch (Exception paramadw)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramadw, "", new Object[0]);
        AppMethodBeat.o(95638);
        return false;
      }
      paramadw = al.hgH().o(l1, localfdp.abDh, localfdp.vhJ);
      if (paramadw != null)
      {
        paramadw.hkI();
        Log.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(al.hgH().update(paramadw.systemRowid, paramadw))));
      }
      else
      {
        ap.c(l1, (fdq)localObject4);
        continue;
        paramadw = al.hgH().o(l1, localfdp.abDj, localfdp.vhJ);
        if (paramadw != null)
        {
          paramadw.hkI();
          bool1 = al.hgH().update(paramadw.systemRowid, paramadw);
          ap.b(l1, (fdq)localObject4);
          Log.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(bool1)));
          continue;
          paramadw = al.hgH();
          localObject1 = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(l1));
          Log.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(localObject1)));
          bool1 = paramadw.omV.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramadw.doNotify();
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(bool1)));
          continue;
          paramadw = al.hgH();
          localObject1 = localfdp.abnl;
          localObject1 = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + Util.escapeSqlValue((String)localObject1) + "'";
          Log.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(localObject1)));
          bool1 = paramadw.omV.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramadw.doNotify();
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(bool1)));
          ap.b(l1, (fdq)localObject4);
          continue;
          a((fdq)localObject4, localfdp, l1, l2, paramadw);
          continue;
          b((fdq)localObject4, localfdp, l1, l2, paramadw);
          continue;
          n.vf(l1);
          paramadw = al.hgB().vj(l1);
          localObject1 = paramadw.getTimeLine();
          ((TimeLineObject)localObject1).showFlag = 1;
          paramadw.setTimeLine((TimeLineObject)localObject1);
          al.hgB().b(l1, paramadw);
          continue;
          localObject1 = localfdp.YGq;
          if (m.uG(l1))
          {
            paramadw = new m(l1, (epj)localObject1);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(paramadw, 0);
          }
          for (;;)
          {
            try
            {
              paramadw = ((fdq)localObject4).abDp;
              localObject5 = Util.nullAsNil(((fdq)localObject4).nUv);
              l2 = ((fdq)localObject4).abDo;
              int j = Util.getInt(i.aRC().getValue("SnsAdNotifyLimit"), 0);
              int k = Util.getInt(i.aRC().getValue("SnsAdNotifyLikeTimeLimit"), 0);
              int m = Util.getInt(i.aRC().getValue("SnsAdNotifyCommentTimeLimit"), 0);
              if (localObject1 == null) {
                break label1089;
              }
              Log.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid64 %s, aid %s, commentId %s, actionLimit %s", new Object[] { localObject5, Long.valueOf(l1), Long.valueOf(((epj)localObject1).abtD), Integer.valueOf(((epj)localObject1).abty), Integer.valueOf(paramadw.abDh), Integer.valueOf(j) });
              if ((((epj)localObject1).abtD == 0L) && (((epj)localObject1).abty == 0)) {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 4);
              }
              if (al.hgH().a(l1, paramadw.abnl, paramadw.CreateTime, (String)localObject5)) {
                break;
              }
              localObject6 = ((fdq)localObject4).abDq;
              localObject1 = new o();
              ((o)localObject1).field_snsID = l1;
              ((o)localObject1).field_parentID = l2;
              ((o)localObject1).field_createTime = paramadw.CreateTime;
              ((o)localObject1).field_talker = paramadw.abnl;
              ((o)localObject1).field_type = paramadw.vhJ;
              ((o)localObject1).field_curActionBuf = paramadw.toByteArray();
              ((o)localObject1).field_refActionBuf = ((fdp)localObject6).toByteArray();
              ((o)localObject1).field_clientId = ((String)localObject5);
              if (!com.tencent.mm.plugin.sns.ui.widget.g.lU(paramadw.abDl, 2)) {
                break label1740;
              }
              i = 1;
              ((o)localObject1).field_isSilence = i;
              ((o)localObject1).field_commentSvrID = paramadw.abDj;
              if (!al.hgE().ve(l1)) {
                break label1163;
              }
              if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, (fdq)localObject4, j, k, m, true))) {
                break label1110;
              }
              Log.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + ((o)localObject1).field_snsID + " " + ((o)localObject1).field_commentSvrID);
            }
            catch (Exception paramadw)
            {
              Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramadw, "", new Object[0]);
            }
            break;
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
            com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 3);
          }
          if (!a.a(l1, (fdq)localObject4))
          {
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + ((o)localObject1).field_snsID + " " + ((o)localObject1).field_commentSvrID);
          }
          else
          {
            if ((!Util.isNullOrNil(paramadw.abDm)) && (paramadw.abDm.get(0) != null))
            {
              localObject4 = ap.a((feb)paramadw.abDm.get(0));
              if (bl.jba().adju.bza(((EmojiInfo)localObject4).field_md5) == null)
              {
                bl.jba().adju.L((EmojiInfo)localObject4);
                if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znH, 0) == 1))
                {
                  localObject5 = e.mgl;
                  e.a((EmojiInfo)localObject4, null);
                }
              }
            }
            al.hgH().insert((IAutoDBItem)localObject1);
            al.hgH().V(l1, com.tencent.mm.plugin.sns.ui.widget.g.lU(paramadw.abDl, 2));
            continue;
            localObject6 = "";
            localObject7 = null;
            localObject4 = null;
            localStringBuilder = null;
            localObject1 = null;
            bool2 = false;
            bool1 = bool2;
            localObject5 = localStringBuilder;
            paramadw = localObject7;
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
          String str = t.uA(l1);
          bool1 = bool2;
          localObject5 = localStringBuilder;
          localObject6 = str;
          paramadw = localObject7;
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=".concat(String.valueOf(str)));
          bool1 = bool2;
          localObject5 = localStringBuilder;
          localObject6 = str;
          paramadw = localObject7;
          AdSnsInfo localAdSnsInfo = al.hgE().vd(l1);
          if (localAdSnsInfo != null)
          {
            bool1 = bool2;
            localObject5 = localStringBuilder;
            localObject6 = str;
            paramadw = localObject7;
            localObject4 = localAdSnsInfo.getAdInfo();
            bool1 = bool2;
            localObject5 = localStringBuilder;
            localObject6 = str;
            paramadw = (adw)localObject4;
            localObject1 = localAdSnsInfo.getAdXml();
          }
          bool1 = bool2;
          localObject5 = localObject1;
          localObject6 = str;
          paramadw = (adw)localObject4;
          bool2 = al.hgE().delete(l1);
          bool1 = bool2;
          localObject5 = localObject1;
          localObject6 = str;
          paramadw = (adw)localObject4;
          al.hgH().vh(l1);
          bool1 = bool2;
          localObject5 = localObject1;
          localObject6 = str;
          paramadw = (adw)localObject4;
          n.vg(l1);
          bool1 = bool2;
          localObject5 = localObject1;
          localObject6 = str;
          paramadw = (adw)localObject4;
          localStringBuilder = new StringBuilder("processSnsAdFeedsForceDelAction snsId=").append(str).append(", delSucc=").append(bool2).append(", adSnsInfo==null?");
          if (localAdSnsInfo != null) {
            break label1745;
          }
          bool3 = true;
          bool1 = bool2;
          localObject5 = localObject1;
          localObject6 = str;
          paramadw = (adw)localObject4;
          Log.i("MicroMsg.NetSceneNewSyncAlbum", bool3);
          paramadw = (adw)localObject4;
          localObject6 = str;
          bool1 = bool2;
        }
        finally
        {
          Log.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction exp=" + localObject2.toString() + ", snsId=" + (String)localObject6);
          Object localObject3 = localObject5;
          continue;
        }
        try
        {
          com.tencent.mm.plugin.sns.data.k.a(3, l1, paramadw, (ADXml)localObject1);
          if (!bool1) {
            break;
          }
          com.tencent.mm.plugin.sns.data.k.a(4, l1, paramadw, (ADXml)localObject1);
          break;
        }
        finally
        {
          Log.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction report exp=" + paramadw.toString() + ", snsId=" + (String)localObject6);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95631);
    com.tencent.mm.kernel.h.baF();
    byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(8195, null)));
    gol localgol = new gol();
    localgol.df(arrayOfByte);
    ((ffc)c.b.b(this.rr.otB)).ZdD = localgol;
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95631);
    return i;
  }
  
  public final int getType()
  {
    return 214;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95636);
    Log.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95636);
      return;
    }
    ffd localffd = (ffd)c.c.b(((com.tencent.mm.am.c)params).otC);
    paramArrayOfByte = localffd.ZdG.vgO;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      Log.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.QsP;
      paramString.zMR = paramArrayOfByte;
      paramString.AdR.sendEmptyMessage(0);
      AppMethodBeat.o(95636);
      return;
    }
    if ((localffd.ZdD != null) && (localffd.ZdD.aaxD != null))
    {
      paramArrayOfByte = localffd.ZdD.aaxD.toByteArray();
      if (paramArrayOfByte != null)
      {
        params = ad.o(((ffc)c.b.b(((com.tencent.mm.am.c)params).otB)).ZdD.aaxD.toByteArray(), paramArrayOfByte);
        if ((params != null) && (params.length > 0))
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().B(8195, Util.encodeHexString(params));
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95636);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    MMHandler AdR;
    LinkedList<adw> zMR;
    
    a()
    {
      AppMethodBeat.i(95629);
      this.AdR = new MMHandler()
      {
        public final void handleMessage(final Message paramAnonymousMessage)
        {
          AppMethodBeat.i(95628);
          com.tencent.mm.kernel.h.baF();
          if (!com.tencent.mm.kernel.h.baC().aZN())
          {
            AppMethodBeat.o(95628);
            return;
          }
          if ((v.a.this.zMR == null) || (v.a.this.zMR.isEmpty()))
          {
            paramAnonymousMessage = v.this;
            ffd localffd = (ffd)c.c.b(paramAnonymousMessage.rr.otC);
            ffc localffc = (ffc)c.b.b(paramAnonymousMessage.rr.otB);
            byte[] arrayOfByte = localffd.ZdD.aaxD.toByteArray();
            if (arrayOfByte != null)
            {
              arrayOfByte = ad.o(localffc.ZdD.aaxD.toByteArray(), arrayOfByte);
              if ((arrayOfByte != null) && (arrayOfByte.length > 0))
              {
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baE().ban().B(8195, Util.encodeHexString(arrayOfByte));
              }
              localffc.ZdD.df(arrayOfByte);
            }
            if ((localffd.YYp & localffc.ZdC) == 0)
            {
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(95628);
              return;
            }
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(95628);
            return;
          }
          paramAnonymousMessage = (adw)v.a.this.zMR.getFirst();
          Log.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramAnonymousMessage.Zmc);
          v.a.this.zMR.removeFirst();
          switch (paramAnonymousMessage.Zmc)
          {
          default: 
            v.a.this.AdR.sendEmptyMessage(0);
            AppMethodBeat.o(95628);
            return;
          case 45: 
            al.gHI().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95626);
                if (!v.this.a(paramAnonymousMessage, v.a.this.AdR)) {
                  v.a.this.AdR.sendEmptyMessage(0);
                }
                AppMethodBeat.o(95626);
              }
            });
            AppMethodBeat.o(95628);
            return;
          }
          al.gHI().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95627);
              if (!v.this.b(paramAnonymousMessage, v.a.this.AdR)) {
                v.a.this.AdR.sendEmptyMessage(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.v
 * JD-Core Version:    0.7.0.1
 */