package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.model.bb;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.protocal.protobuf.eav;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends q
  implements com.tencent.mm.network.m
{
  private static List<bb> DIN;
  private static com.tencent.mm.plugin.sns.j.c DIP;
  private static boolean DIQ;
  private a DIO;
  com.tencent.mm.ak.i callback;
  private String gna;
  d rr;
  
  static
  {
    AppMethodBeat.i(95647);
    DIN = new LinkedList();
    DIQ = true;
    AppMethodBeat.o(95647);
  }
  
  public v()
  {
    AppMethodBeat.i(95630);
    this.gna = "";
    this.DIO = new a();
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", new Object[] { Integer.valueOf(256) });
    localObject = new d.a();
    ((d.a)localObject).iLN = new eau();
    ((d.a)localObject).iLO = new eav();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnssync";
    ((d.a)localObject).funcId = 214;
    ((d.a)localObject).iLP = 102;
    ((d.a)localObject).respCmdId = 1000000102;
    this.rr = ((d.a)localObject).aXF();
    ((eau)this.rr.iLK.iLR).Leu = 256;
    this.gna = com.tencent.mm.model.z.aTY();
    long l;
    byte[] arrayOfByte;
    if (DIQ)
    {
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.aAi();
      localObject = com.tencent.mm.kernel.g.aAh().cachePath + "ad_1100007";
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(localObject)));
      arrayOfByte = com.tencent.mm.vfs.s.aW((String)localObject, 0, -1);
      if (arrayOfByte == null) {}
    }
    try
    {
      DIP = (com.tencent.mm.plugin.sns.j.c)new com.tencent.mm.plugin.sns.j.c().parseFrom(arrayOfByte);
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - l));
      if (DIP != null) {
        break label293;
      }
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localIOException, "", new Object[0]);
        com.tencent.mm.vfs.s.deleteFile((String)localObject);
        continue;
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + DIP.DRK.size());
      }
    }
    DIQ = false;
    AppMethodBeat.o(95630);
  }
  
  public static void Jl(long paramLong)
  {
    AppMethodBeat.i(95632);
    if (DIP == null) {
      DIP = new com.tencent.mm.plugin.sns.j.c();
    }
    DIP.DRK.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95632);
  }
  
  public static void Jm(long paramLong)
  {
    AppMethodBeat.i(95633);
    if (DIP != null) {
      DIP.DRK.remove(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(95633);
  }
  
  public static boolean Jn(long paramLong)
  {
    AppMethodBeat.i(95634);
    if (DIP == null)
    {
      AppMethodBeat.o(95634);
      return false;
    }
    if (DIP.DRK.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95634);
      return true;
    }
    AppMethodBeat.o(95634);
    return false;
  }
  
  public static boolean Jo(long paramLong)
  {
    AppMethodBeat.i(95639);
    try
    {
      boolean bool = a.a(paramLong, null, Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLimit"), 0), Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLikeTimeLimit"), 0), Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
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
  
  public static void a(bb parambb)
  {
    AppMethodBeat.i(95645);
    if (!DIN.contains(parambb)) {
      DIN.add(parambb);
    }
    AppMethodBeat.o(95645);
  }
  
  private static boolean a(dzj paramdzj)
  {
    AppMethodBeat.i(95640);
    try
    {
      dzi localdzi1 = paramdzj.MZb;
      long l1 = paramdzj.Id;
      Object localObject = Util.nullAsNil(paramdzj.izX);
      long l2 = paramdzj.MZa;
      int i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLimit"), 0);
      int j = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLikeTimeLimit"), 0);
      int k = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyCommentTimeLimit"), 0);
      if (((i > 0) || (j > 0) || (k > 0)) && ((localdzi1.oUv == 8) || (localdzi1.oUv == 7)) && (!a.a(l1, paramdzj, i, j, k, true)))
      {
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + (String)localObject + " snsId: " + l1 + " " + localdzi1.MYV + " " + localdzi1.MYT + " actionLimit:" + i + " actionLikeTimeLimit:" + j + " actionCommentTimeLimit:" + k);
        a.a(l1, paramdzj);
        AppMethodBeat.o(95640);
        return false;
      }
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + (String)localObject + " snsId: " + l1 + " " + localdzi1.MYV + " " + localdzi1.MYT + " actionLimit: " + i);
      if (!aj.faT().a(l1, localdzi1.MKC, localdzi1.CreateTime, (String)localObject))
      {
        dzi localdzi2 = paramdzj.MZc;
        com.tencent.mm.plugin.sns.storage.h localh = new com.tencent.mm.plugin.sns.storage.h();
        localh.field_snsID = l1;
        localh.field_parentID = l2;
        localh.field_createTime = localdzi1.CreateTime;
        localh.field_talker = localdzi1.MKC;
        localh.field_type = localdzi1.oUv;
        localh.field_curActionBuf = localdzi1.toByteArray();
        localh.field_refActionBuf = localdzi2.toByteArray();
        localh.field_clientId = ((String)localObject);
        if (com.tencent.mm.plugin.sns.ui.widget.e.iY(localdzi1.MYX, 2)) {}
        for (i = 1;; i = 0)
        {
          localh.field_isSilence = i;
          if ((localdzi1.oUv != 8) && (localdzi1.oUv != 7)) {
            break;
          }
          localh.field_commentSvrID = localdzi1.MYV;
          if (a.a(l1, paramdzj)) {
            break label552;
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + localh.field_snsID + " " + localh.field_commentSvrID);
          AppMethodBeat.o(95640);
          return false;
        }
        localh.field_commentSvrID = localdzi1.MYT;
        boolean bool = an.a(l1, paramdzj);
        if (!bool)
        {
          AppMethodBeat.o(95640);
          return false;
        }
        label552:
        if ((!Util.isNullOrNil(localdzi1.MYY)) && (localdzi1.MYY.get(0) != null))
        {
          paramdzj = an.a((dzu)localdzi1.MYY.get(0));
          if (bj.gCJ().OpN.blk(paramdzj.field_md5) == null)
          {
            bj.gCJ().OpN.K(paramdzj);
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skC, 0) == 1))
            {
              localObject = com.tencent.mm.emoji.loader.e.gVM;
              com.tencent.mm.emoji.loader.e.a(paramdzj, null);
            }
          }
        }
        aj.faT().insert(localh);
        aj.faT().L(l1, com.tencent.mm.plugin.sns.ui.widget.e.iY(localdzi1.MYX, 2));
        AppMethodBeat.o(95640);
        return true;
      }
      AppMethodBeat.o(95640);
      return false;
    }
    catch (Exception paramdzj)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdzj, "", new Object[0]);
      AppMethodBeat.o(95640);
    }
    return false;
  }
  
  private static boolean a(dzj paramdzj, dzi paramdzi, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95641);
    try
    {
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramdzi.MYV + " " + paramdzi.MYT);
      if (!com.tencent.mm.plugin.sns.lucky.a.g.eZL())
      {
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
        AppMethodBeat.o(95641);
        return false;
      }
      if (!aj.faT().a(paramLong1, paramdzi.MKC, paramdzi.CreateTime, paramString))
      {
        dzi localdzi = paramdzj.MZc;
        com.tencent.mm.plugin.sns.storage.h localh = new com.tencent.mm.plugin.sns.storage.h();
        localh.field_snsID = paramLong1;
        localh.field_parentID = paramLong2;
        localh.field_createTime = paramdzi.CreateTime;
        localh.field_talker = paramdzi.MKC;
        localh.field_type = paramdzi.oUv;
        localh.field_curActionBuf = paramdzi.toByteArray();
        localh.field_refActionBuf = localdzi.toByteArray();
        localh.field_clientId = paramString;
        localh.field_commentSvrID = paramdzi.MYT;
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramdzi.MYW);
        an.d(paramLong1, paramdzj);
        aVu();
        aj.faT().insert(localh);
        AppMethodBeat.o(95641);
        return true;
      }
      AppMethodBeat.o(95641);
      return false;
    }
    catch (Exception paramdzj)
    {
      Log.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramdzj.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdzj, "", new Object[0]);
      AppMethodBeat.o(95641);
    }
    return false;
  }
  
  private static void aVu()
  {
    AppMethodBeat.i(95644);
    Iterator localIterator = DIN.iterator();
    while (localIterator.hasNext())
    {
      bb localbb = (bb)localIterator.next();
      if (localbb != null) {
        localbb.aVu();
      }
    }
    AppMethodBeat.o(95644);
  }
  
  public static void b(bb parambb)
  {
    AppMethodBeat.i(95646);
    DIN.remove(parambb);
    AppMethodBeat.o(95646);
  }
  
  private static boolean b(dzj paramdzj, dzi paramdzi, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95642);
    try
    {
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + paramString + " snsId: " + paramLong1 + " " + paramdzi.MYV + " " + paramdzi.MYT);
      if (!aj.faT().a(paramLong1, paramdzi.MKC, paramdzi.CreateTime, paramString))
      {
        dzi localdzi = paramdzj.MZc;
        paramdzj = new com.tencent.mm.plugin.sns.storage.h();
        paramdzj.field_snsID = paramLong1;
        paramdzj.field_parentID = paramLong2;
        paramdzj.field_createTime = paramdzi.CreateTime;
        paramdzj.field_talker = paramdzi.MKC;
        paramdzj.field_type = paramdzi.oUv;
        paramdzj.field_curActionBuf = paramdzi.toByteArray();
        paramdzj.field_refActionBuf = localdzi.toByteArray();
        paramdzj.field_clientId = paramString;
        paramdzj.field_commentSvrID = paramdzi.MYT;
        paramString = new cbd();
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + paramdzi.MYW);
        paramString.parseFrom(com.tencent.mm.platformtools.z.a(paramdzi.MYW));
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + paramString.eht);
        aj.faT().insert(paramdzj);
        AppMethodBeat.o(95642);
        return true;
      }
      AppMethodBeat.o(95642);
      return false;
    }
    catch (Exception paramdzj)
    {
      Log.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + paramdzj.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramdzj, "", new Object[0]);
      AppMethodBeat.o(95642);
    }
    return false;
  }
  
  public static void fah()
  {
    AppMethodBeat.i(95635);
    if (DIP == null)
    {
      AppMethodBeat.o(95635);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    localObject = com.tencent.mm.kernel.g.aAh().cachePath + "ad_1100007";
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(localObject)));
    try
    {
      byte[] arrayOfByte = DIP.toByteArray();
      com.tencent.mm.vfs.s.f((String)localObject, arrayOfByte, arrayOfByte.length);
      Log.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - l) + " igNoreAbTestId " + DIP.DRK.size());
      AppMethodBeat.o(95635);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", localException, "listToFile failed: ".concat(String.valueOf(localObject)), new Object[0]);
      AppMethodBeat.o(95635);
    }
  }
  
  public static void fai()
  {
    AppMethodBeat.i(95643);
    Iterator localIterator = DIN.iterator();
    while (localIterator.hasNext())
    {
      bb localbb = (bb)localIterator.next();
      if (localbb != null) {
        localbb.aVv();
      }
    }
    AppMethodBeat.o(95643);
  }
  
  public final boolean a(abn paramabn, final MMHandler paramMMHandler)
  {
    AppMethodBeat.i(95637);
    final SnsObject localSnsObject;
    boolean bool;
    try
    {
      localSnsObject = (SnsObject)new SnsObject().parseFrom(paramabn.Lmt.getBuffer().toByteArray());
      paramabn = new String(localSnsObject.ObjectDesc.getBuffer().toByteArray());
      if (paramabn.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0) {
        break label452;
      }
      if (paramabn.indexOf("<contentStyle>1</contentStyle>") < 0) {
        break label467;
      }
    }
    catch (Exception paramabn)
    {
      l locall;
      String[] arrayOfString;
      int i;
      Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramabn, "", new Object[0]);
      AppMethodBeat.o(95637);
      return false;
    }
    Log.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + localSnsObject.Id + " " + r.Jb(localSnsObject.Id) + " isPhoto " + bool);
    String str;
    int j;
    if (bool)
    {
      str = r.Jb(localSnsObject.Id);
      locall = aj.faS().aQr(localSnsObject.Username);
      if (Util.isNullOrNil(locall.field_newerIds)) {
        break label374;
      }
      arrayOfString = locall.field_newerIds.split(",");
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
        paramabn = paramabn + "," + arrayOfString[j];
        j += 1;
      }
      else
      {
        Log.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + localSnsObject.Id + " S: " + str + " list " + locall.field_newerIds + " newer " + paramabn);
        if (i != 0) {
          aj.faS().kK(localSnsObject.Username, paramabn);
        }
        while (aj.faO().JF(localSnsObject.Id))
        {
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
          AppMethodBeat.o(95637);
          return false;
          label374:
          aj.faS().kK(localSnsObject.Username, str);
        }
        EventCenter.instance.publish(new vv());
        aj.dRd().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(95624);
            if (!localSnsObject.Username.equals(v.a(v.this)))
            {
              com.tencent.mm.kernel.g.aAi();
              if (!com.tencent.mm.kernel.g.aAf().azp())
              {
                Log.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                AppMethodBeat.o(95624);
                return;
              }
              com.tencent.mm.kernel.g.aAi();
              Object localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(68377, null);
              com.tencent.mm.kernel.g.aAi();
              if ((Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(68400, null), 0) != localSnsObject.CreateTime) || ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(localSnsObject.Username))))
              {
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(68377, localSnsObject.Username);
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(68400, Integer.valueOf(localSnsObject.CreateTime));
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(68418, r.Jb(localSnsObject.Id));
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(68419, Integer.valueOf(0));
                com.tencent.mm.plugin.sns.k.f.s(1, r.Jb(localSnsObject.Id), 0);
              }
              localObject = v.bwK().iterator();
              while (((Iterator)localObject).hasNext()) {
                ((bb)((Iterator)localObject).next()).aVt();
              }
            }
            paramMMHandler.sendEmptyMessage(0);
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
        paramabn = str;
      }
    }
  }
  
  public final boolean b(abn paramabn, final MMHandler paramMMHandler)
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
      final dzi localdzi;
      try
      {
        localObject3 = (dzj)new dzj().parseFrom(paramabn.Lmt.getBuffer().toByteArray());
        l1 = ((dzj)localObject3).Id;
        l2 = ((dzj)localObject3).MZa;
        localdzi = ((dzj)localObject3).MZb;
        localObject1 = ((dzj)localObject3).izX;
        paramabn = (abn)localObject1;
        if (localObject1 == null) {
          paramabn = "";
        }
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + localdzi.oUv + " " + l1 + " " + paramabn);
        switch (localdzi.oUv)
        {
        case 9: 
          a((dzj)localObject3);
          if (com.tencent.mm.plugin.sns.ui.widget.e.iY(localdzi.MYX, 2)) {
            break label1731;
          }
          bool1 = true;
          aj.dRd().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95625);
              if (bool1)
              {
                Iterator localIterator = v.bwK().iterator();
                while (localIterator.hasNext())
                {
                  bb localbb = (bb)localIterator.next();
                  Log.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                  localbb.aVs();
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
      catch (Exception paramabn)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramabn, "", new Object[0]);
        AppMethodBeat.o(95638);
        return false;
      }
      paramabn = aj.faT().i(l1, localdzi.MYT, localdzi.oUv);
      if (paramabn != null)
      {
        paramabn.feD();
        Log.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(aj.faT().update(paramabn.systemRowid, paramabn))));
      }
      else
      {
        an.c(l1, (dzj)localObject3);
        continue;
        paramabn = aj.faT().i(l1, localdzi.MYV, localdzi.oUv);
        if (paramabn != null)
        {
          paramabn.feD();
          bool1 = aj.faT().update(paramabn.systemRowid, paramabn);
          an.b(l1, (dzj)localObject3);
          Log.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(bool1)));
          continue;
          paramabn = aj.faT();
          localObject1 = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(l1));
          Log.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(localObject1)));
          bool1 = paramabn.iFy.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramabn.doNotify();
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(bool1)));
          continue;
          paramabn = aj.faT();
          localObject1 = localdzi.MKC;
          localObject1 = " update SnsComment set commentflag = 1 where snsID = " + l1 + " and talker = '" + Util.escapeSqlValue((String)localObject1) + "'";
          Log.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(localObject1)));
          bool1 = paramabn.iFy.execSQL("SnsComment", (String)localObject1);
          if (bool1) {
            paramabn.doNotify();
          }
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(bool1)));
          an.b(l1, (dzj)localObject3);
          continue;
          a((dzj)localObject3, localdzi, l1, l2, paramabn);
          continue;
          b((dzj)localObject3, localdzi, l1, l2, paramabn);
          continue;
          com.tencent.mm.plugin.sns.storage.g.JG(l1);
          paramabn = aj.faO().JJ(l1);
          localObject1 = paramabn.getTimeLine();
          ((TimeLineObject)localObject1).showFlag = 1;
          paramabn.setTimeLine((TimeLineObject)localObject1);
          aj.faO().b(l1, paramabn);
          continue;
          localObject1 = localdzi.KHJ;
          if (m.Jh(l1))
          {
            paramabn = new m(l1, (dmo)localObject1);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(paramabn, 0);
          }
          for (;;)
          {
            try
            {
              paramabn = ((dzj)localObject3).MZb;
              localObject4 = Util.nullAsNil(((dzj)localObject3).izX);
              l2 = ((dzj)localObject3).MZa;
              int j = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLimit"), 0);
              int k = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLikeTimeLimit"), 0);
              int m = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyCommentTimeLimit"), 0);
              if (localObject1 == null) {
                break label1089;
              }
              Log.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid64 %s, aid %s, commentId %s, actionLimit %s", new Object[] { localObject4, Long.valueOf(l1), Long.valueOf(((dmo)localObject1).MQh), Integer.valueOf(((dmo)localObject1).MQc), Integer.valueOf(paramabn.MYT), Integer.valueOf(j) });
              if ((((dmo)localObject1).MQh == 0L) && (((dmo)localObject1).MQc == 0)) {
                com.tencent.mm.plugin.report.service.h.CyF.dN(955, 4);
              }
              if (aj.faT().a(l1, paramabn.MKC, paramabn.CreateTime, (String)localObject4)) {
                break;
              }
              localObject5 = ((dzj)localObject3).MZc;
              localObject1 = new com.tencent.mm.plugin.sns.storage.h();
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_snsID = l1;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_parentID = l2;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_createTime = paramabn.CreateTime;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_talker = paramabn.MKC;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type = paramabn.oUv;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_curActionBuf = paramabn.toByteArray();
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_refActionBuf = ((dzi)localObject5).toByteArray();
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_clientId = ((String)localObject4);
              if (!com.tencent.mm.plugin.sns.ui.widget.e.iY(paramabn.MYX, 2)) {
                break label1740;
              }
              i = 1;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_isSilence = i;
              ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_commentSvrID = paramabn.MYV;
              if (!aj.faR().JF(l1)) {
                break label1163;
              }
              if (((j <= 0) && (k <= 0) && (m <= 0)) || (a.a(l1, (dzj)localObject3, j, k, m, true))) {
                break label1110;
              }
              Log.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_snsID + " " + ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_commentSvrID);
            }
            catch (Exception paramabn)
            {
              Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", paramabn, "", new Object[0]);
            }
            break;
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
            com.tencent.mm.plugin.report.service.h.CyF.dN(955, 3);
          }
          if (!a.a(l1, (dzj)localObject3))
          {
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_snsID + " " + ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_commentSvrID);
          }
          else
          {
            if ((!Util.isNullOrNil(paramabn.MYY)) && (paramabn.MYY.get(0) != null))
            {
              localObject3 = an.a((dzu)paramabn.MYY.get(0));
              if (bj.gCJ().OpN.blk(((EmojiInfo)localObject3).field_md5) == null)
              {
                bj.gCJ().OpN.K((EmojiInfo)localObject3);
                if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skC, 0) == 1))
                {
                  localObject4 = com.tencent.mm.emoji.loader.e.gVM;
                  com.tencent.mm.emoji.loader.e.a((EmojiInfo)localObject3, null);
                }
              }
            }
            aj.faT().insert((IAutoDBItem)localObject1);
            aj.faT().L(l1, com.tencent.mm.plugin.sns.ui.widget.e.iY(paramabn.MYX, 2));
            continue;
            localObject5 = "";
            localObject6 = null;
            localObject3 = null;
            localStringBuilder = null;
            localObject1 = null;
            bool2 = false;
            bool1 = bool2;
            localObject4 = localStringBuilder;
            paramabn = localObject6;
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
          String str = r.Jb(l1);
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramabn = localObject6;
          Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=".concat(String.valueOf(str)));
          bool1 = bool2;
          localObject4 = localStringBuilder;
          localObject5 = str;
          paramabn = localObject6;
          AdSnsInfo localAdSnsInfo = aj.faR().JE(l1);
          if (localAdSnsInfo != null)
          {
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramabn = localObject6;
            localObject3 = localAdSnsInfo.getAdInfo();
            bool1 = bool2;
            localObject4 = localStringBuilder;
            localObject5 = str;
            paramabn = (abn)localObject3;
            localObject1 = localAdSnsInfo.getAdXml();
          }
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabn = (abn)localObject3;
          bool2 = aj.faR().delete(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabn = (abn)localObject3;
          aj.faT().JI(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabn = (abn)localObject3;
          com.tencent.mm.plugin.sns.storage.g.JH(l1);
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabn = (abn)localObject3;
          localStringBuilder = new StringBuilder("processSnsAdFeedsForceDelAction snsId=").append(str).append(", delSucc=").append(bool2).append(", adSnsInfo==null?");
          if (localAdSnsInfo != null) {
            break label1745;
          }
          bool3 = true;
          bool1 = bool2;
          localObject4 = localObject1;
          localObject5 = str;
          paramabn = (abn)localObject3;
          Log.i("MicroMsg.NetSceneNewSyncAlbum", bool3);
          paramabn = (abn)localObject3;
          localObject5 = str;
          bool1 = bool2;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction exp=" + localThrowable.toString() + ", snsId=" + (String)localObject5);
          Object localObject2 = localObject4;
          continue;
        }
        try
        {
          com.tencent.mm.plugin.sns.data.i.a(3, l1, paramabn, (ADXml)localObject1);
          if (!bool1) {
            break;
          }
          com.tencent.mm.plugin.sns.data.i.a(4, l1, paramabn, (ADXml)localObject1);
        }
        catch (Throwable paramabn)
        {
          Log.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction report exp=" + paramabn.toString() + ", snsId=" + (String)localObject5);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(95631);
    com.tencent.mm.kernel.g.aAi();
    byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((eau)this.rr.iLK.iLR).Lev = localSKBuiltinBuffer_t;
    this.callback = parami;
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
    eav localeav = (eav)((d)params).iLL.iLR;
    paramArrayOfByte = localeav.Ley.oTA;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      Log.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + paramArrayOfByte.size());
      paramString = this.DIO;
      paramString.sKS = paramArrayOfByte;
      paramString.tby.sendEmptyMessage(0);
      AppMethodBeat.o(95636);
      return;
    }
    if ((localeav.Lev != null) && (localeav.Lev.getBuffer() != null))
    {
      paramArrayOfByte = localeav.Lev.getBuffer().toByteArray();
      params = ad.l(((eau)((d)params).iLK.iLR).Lev.getBuffer().toByteArray(), paramArrayOfByte);
      if ((params != null) && (params.length > 0))
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(8195, Util.encodeHexString(params));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(95636);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  final class a
  {
    LinkedList<abn> sKS;
    MMHandler tby;
    
    a()
    {
      AppMethodBeat.i(95629);
      this.tby = new MMHandler()
      {
        public final void handleMessage(final Message paramAnonymousMessage)
        {
          AppMethodBeat.i(95628);
          com.tencent.mm.kernel.g.aAi();
          if (!com.tencent.mm.kernel.g.aAf().azp())
          {
            AppMethodBeat.o(95628);
            return;
          }
          if ((v.a.this.sKS == null) || (v.a.this.sKS.isEmpty()))
          {
            paramAnonymousMessage = v.this;
            eav localeav = (eav)paramAnonymousMessage.rr.iLL.iLR;
            eau localeau = (eau)paramAnonymousMessage.rr.iLK.iLR;
            byte[] arrayOfByte = localeav.Lev.getBuffer().toByteArray();
            arrayOfByte = ad.l(localeau.Lev.getBuffer().toByteArray(), arrayOfByte);
            if ((arrayOfByte != null) && (arrayOfByte.length > 0))
            {
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().azQ().set(8195, Util.encodeHexString(arrayOfByte));
            }
            localeau.Lev.setBuffer(arrayOfByte);
            if ((localeav.KZh & localeau.Leu) == 0)
            {
              paramAnonymousMessage.callback.onSceneEnd(0, 0, "", paramAnonymousMessage);
              AppMethodBeat.o(95628);
              return;
            }
            paramAnonymousMessage.doScene(paramAnonymousMessage.dispatcher(), paramAnonymousMessage.callback);
            AppMethodBeat.o(95628);
            return;
          }
          paramAnonymousMessage = (abn)v.a.this.sKS.getFirst();
          Log.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramAnonymousMessage.Lms);
          v.a.this.sKS.removeFirst();
          switch (paramAnonymousMessage.Lms)
          {
          default: 
            v.a.this.tby.sendEmptyMessage(0);
            AppMethodBeat.o(95628);
            return;
          case 45: 
            aj.eJP().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95626);
                if (!v.this.a(paramAnonymousMessage, v.a.this.tby)) {
                  v.a.this.tby.sendEmptyMessage(0);
                }
                AppMethodBeat.o(95626);
              }
            });
            AppMethodBeat.o(95628);
            return;
          }
          aj.eJP().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(95627);
              if (!v.this.b(paramAnonymousMessage, v.a.this.tby)) {
                v.a.this.tby.sendEmptyMessage(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.v
 * JD-Core Version:    0.7.0.1
 */