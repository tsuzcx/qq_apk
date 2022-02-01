package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.4;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fdk;
import com.tencent.mm.protocal.protobuf.fdl;
import com.tencent.mm.protocal.protobuf.fdm;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends com.tencent.mm.am.p
  implements com.tencent.mm.network.m
{
  public static List<Long> Qsd;
  public static List<Long> Qse;
  public com.tencent.mm.am.h callback;
  private long ibq;
  private String oYr;
  private c rr;
  
  static
  {
    AppMethodBeat.i(95578);
    Qsd = Collections.synchronizedList(new LinkedList());
    Qse = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(95578);
  }
  
  public m(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95574);
    this.ibq = paramLong;
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new fdl();
    ((c.a)localObject1).otF = new fdm();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((c.a)localObject1).funcId = 683;
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    this.oYr = (com.tencent.mm.kernel.h.baE().cachePath + "ad_detail_session");
    int i = t.aPK();
    localObject2 = y.bi(this.oYr, 0, -1);
    this.rr = ((c.a)localObject1).bEF();
    ((fdl)c.b.b(this.rr.otB)).Id = paramLong;
    ((fdl)c.b.b(this.rr.otB)).abCX = w.aN((byte[])localObject2);
    ((fdl)c.b.b(this.rr.otB)).IJG = paramInt;
    ((fdl)c.b.b(this.rr.otB)).abCZ = i;
    if ((paramString != null) && (paramString.length() > 0)) {
      ((fdl)c.b.b(this.rr.otB)).abCY = w.ak(paramString, true);
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 32);
    localObject1 = new StringBuilder("NetSceneSnsAdObjectDetial, snsId=").append(t.uA(paramLong)).append(", scene=").append(paramInt).append(", buf is null?");
    if (localObject2 == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", bool + ", syncBuf=" + paramString);
      AppMethodBeat.o(95574);
      return;
    }
  }
  
  public m(long paramLong, epj paramepj)
  {
    this(paramLong, 2, "");
    AppMethodBeat.i(95575);
    ((fdl)c.b.b(this.rr.otB)).YGq = paramepj;
    if (paramepj == null)
    {
      Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, remindFriendsInfo==null");
      AppMethodBeat.o(95575);
      return;
    }
    String str = null;
    if (paramepj.abtC != null) {
      str = w.b(paramepj.abtC);
    }
    Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, scene=2, ADGroupId64=" + paramepj.abtD + ", ADGroupId=" + paramepj.abty + ", extInfo=" + str);
    AppMethodBeat.o(95575);
  }
  
  public static boolean uF(long paramLong)
  {
    AppMethodBeat.i(95570);
    if (Qsd.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95570);
      return false;
    }
    Qsd.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95570);
    return true;
  }
  
  public static boolean uG(long paramLong)
  {
    AppMethodBeat.i(95571);
    if (Qse.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95571);
      return false;
    }
    Qse.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95571);
    return true;
  }
  
  private static boolean uH(long paramLong)
  {
    AppMethodBeat.i(95572);
    Qse.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95572);
    return true;
  }
  
  private static boolean uI(long paramLong)
  {
    AppMethodBeat.i(95573);
    Qsd.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95573);
    return true;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95576);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95576);
    return i;
  }
  
  public final int getType()
  {
    return 683;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95577);
    ??? = t.uA(this.ibq);
    Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "onGYNetEnd, errType " + paramInt2 + " errCode " + paramInt3 + ", snsId=" + (String)???);
    int i = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label234;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (((fdl)c.b.b(this.rr.otB)).IJG != 2) {
        break label221;
      }
      com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 1);
    }
    for (;;)
    {
      uI(this.ibq);
      uH(this.ibq);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 27);
      AppMethodBeat.o(95577);
      return;
      paramInt1 = i;
      if (paramInt2 != 4) {
        break;
      }
      paramInt1 = i;
      if (paramInt3 != 1) {
        break;
      }
      params = w.a(((fdm)c.c.b(this.rr.otC)).abCX);
      if (params != null)
      {
        y.deleteFile(this.oYr);
        y.f(this.oYr, params, params.length);
      }
      paramInt1 = 0;
      break;
      label221:
      com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 0);
    }
    label234:
    params = w.a(((fdm)c.c.b(this.rr.otC)).abCX);
    if (params != null)
    {
      y.deleteFile(this.oYr);
      y.f(this.oYr, params, params.length);
    }
    ??? = ((fdm)c.c.b(this.rr.otC)).abDa;
    Object localObject3 = ((fdm)c.c.b(this.rr.otC)).abDb;
    int j = ((fdl)c.b.b(this.rr.otB)).IJG;
    if (??? != null)
    {
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail scene=" + j + ", snsXml=" + w.b(((fdk)???).abCS.ObjectDesc));
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml=" + ((fdk)???).abCT);
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "dynamicData=" + w.b((gol)localObject3));
    }
    if ((??? != null) && (((fdk)???).abCS != null) && (((fdk)???).abCS.DeleteFlag > 0))
    {
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", t.uA(((fdk)???).abCS.Id) + " will remove by get detail ");
      uI(this.ibq);
      uH(this.ibq);
      al.hgE().delete(((fdk)???).abCS.Id);
      al.hgH().vh(((fdk)???).abCS.Id);
      n.vg(((fdk)???).abCS.Id);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95577);
      return;
    }
    if ((??? != null) && (((fdk)???).abCS != null))
    {
      if (((fdk)???).abCS.CommentUserList == null)
      {
        paramInt1 = 0;
        if (((fdk)???).abCS.LikeUserList != null) {
          break label1083;
        }
        i = 0;
        label612:
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment.size=" + paramInt1 + " liked.size=" + i + ", likeFlag=" + ((fdk)???).abCS.LikeFlag + ", snsId=" + t.uA(((fdk)???).abCS.Id));
      }
    }
    else
    {
      if (j != 2) {
        break label1174;
      }
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { ??? });
      paramArrayOfByte = ((fdm)c.c.b(this.rr.otC)).abDc;
      params = null;
      if (paramArrayOfByte != null) {
        params = paramArrayOfByte.YGn;
      }
    }
    boolean bool2;
    boolean bool3;
    boolean bool1;
    for (;;)
    {
      synchronized (a.Qqy)
      {
        if (a.hfz() == 1)
        {
          bool2 = true;
          Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "atDetail, graySwitch=".concat(String.valueOf(bool2)));
          bool3 = false;
          bool1 = bool3;
          if (!bool2) {
            break label1411;
          }
          bool1 = bool3;
          if (params == null) {
            break label1411;
          }
          bool1 = bool3;
          if (params.abCV == null) {
            break label1411;
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(w.a(params.abCV))) {
            break label1411;
          }
          bool1 = a.a(paramArrayOfByte);
          Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "atDetail, isValid=".concat(String.valueOf(bool1)));
          if (!bool1) {
            continue;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1802, 4);
          break label1411;
          params = w.a(paramArrayOfByte.YGo);
          Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "recv at adInfoXml=" + params + ", replaceMode=" + i);
          a.b(paramArrayOfByte, i);
        }
        try
        {
          localObject3 = al.hgE().vd(paramArrayOfByte.YGn.abCS.Id);
          if (localObject3 != null)
          {
            paramArrayOfByte = ((AdSnsInfo)localObject3).getAtAdInfo();
            params = paramArrayOfByte;
            if (paramArrayOfByte == null) {
              params = ((AdSnsInfo)localObject3).getAdInfo();
            }
            com.tencent.mm.plugin.sns.ad.timeline.helper.h.a(((AdSnsInfo)localObject3).getTimeLine(), ((AdSnsInfo)localObject3).getAdXml(), params, 3);
            Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "preDownloadAdLandingPagesForAtMsg, id=".concat(String.valueOf(???)));
            params = ((AdSnsInfo)localObject3).field_adxml;
            if (!Util.isNullOrNil(params)) {
              com.tencent.threadpool.h.ahAA.bm(new m.4(params));
            }
          }
        }
        finally
        {
          Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "TimeLineAdPreloadHelper->checkPreloadAdResource exp=" + params.toString());
          continue;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        uI(this.ibq);
        uH(this.ibq);
        AppMethodBeat.o(95577);
        return;
        paramInt1 = ((fdk)???).abCS.CommentUserList.size();
        break;
        label1083:
        i = ((fdk)???).abCS.LikeUserList.size();
        break label612;
        bool2 = false;
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1802, 5);
      }
      label1163:
      Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "remindObject == null");
    }
    for (;;)
    {
      synchronized (a.Qqy)
      {
        label1174:
        if (a.hfz() == 1)
        {
          bool2 = true;
          Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail, graySwitch=".concat(String.valueOf(bool2)));
          bool3 = false;
          paramArrayOfByte = "";
          params = paramArrayOfByte;
          bool1 = bool3;
          if (!bool2) {
            break label1408;
          }
          params = paramArrayOfByte;
          bool1 = bool3;
          if (??? == null) {
            break label1408;
          }
          params = paramArrayOfByte;
          bool1 = bool3;
          if (((fdk)???).abCV == null) {
            break label1408;
          }
          params = paramArrayOfByte;
          bool1 = bool3;
          if (TextUtils.isEmpty(w.a(((fdk)???).abCV))) {
            break label1408;
          }
          params = ((fdk)???).abCV.abwM;
          bool1 = a.a((fdk)???);
          if (!bool1) {
            break label1397;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1802, 6);
          break label1447;
          Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail, isValid=" + bool1 + ", replaceMode=" + i + ", dynamicAdinfo=" + params);
          a.a((fdk)???, (gol)localObject3, params, i);
        }
      }
      bool2 = false;
      continue;
      label1397:
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1802, 7);
      label1408:
      break label1447;
      label1411:
      if (paramArrayOfByte == null) {
        break label1163;
      }
      paramInt1 = 0;
      if (bool2) {
        paramInt1 = 2;
      }
      i = paramInt1;
      if (!bool2) {
        break;
      }
      i = paramInt1;
      if (bool1) {
        break;
      }
      i = 1;
      break;
      label1447:
      paramInt1 = 0;
      if (bool2) {
        paramInt1 = 2;
      }
      i = paramInt1;
      if (bool2)
      {
        i = paramInt1;
        if (!bool1) {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.m
 * JD-Core Version:    0.7.0.1
 */