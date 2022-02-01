package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  public static List<Long> DIc;
  public static List<Long> DId;
  public com.tencent.mm.ak.i callback;
  private long ece;
  private String jpU;
  private d rr;
  
  static
  {
    AppMethodBeat.i(95578);
    DIc = Collections.synchronizedList(new LinkedList());
    DId = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(95578);
  }
  
  public m(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95574);
    this.ece = paramLong;
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new dze();
    ((d.a)localObject1).iLO = new dzf();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((d.a)localObject1).funcId = 683;
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    this.jpU = (com.tencent.mm.kernel.g.aAh().cachePath + "ad_detail_session");
    int i;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.vfs.s.aW(this.jpU, 0, -1);
      this.rr = ((d.a)localObject1).aXF();
      ((dze)this.rr.iLK.iLR).Id = paramLong;
      ((dze)this.rr.iLK.iLR).MYJ = z.aC((byte[])localObject2);
      ((dze)this.rr.iLK.iLR).Scene = paramInt;
      ((dze)this.rr.iLK.iLR).MYL = i;
      if ((paramString != null) && (paramString.length() > 0)) {
        ((dze)this.rr.iLK.iLR).MYK = z.Sv(paramString);
      }
      localObject1 = new StringBuilder("NetSceneSnsAdObjectDetial, snsId=").append(r.Jb(paramLong)).append(", scene=").append(paramInt).append(", buf is null?");
      if (localObject2 == null) {}
      for (;;)
      {
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", bool + ", syncBuf=" + paramString);
        AppMethodBeat.o(95574);
        return;
        if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
        {
          i = 3;
          break;
        }
        if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
        {
          i = 4;
          break;
        }
        if (!NetStatusUtil.is2G(MMApplicationContext.getContext())) {
          break label359;
        }
        i = 2;
        break;
        bool = false;
      }
      label359:
      i = 0;
    }
  }
  
  public m(long paramLong, dmo paramdmo)
  {
    this(paramLong, 2, "");
    AppMethodBeat.i(95575);
    ((dze)this.rr.iLK.iLR).KHJ = paramdmo;
    if (paramdmo == null)
    {
      Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, remindFriendsInfo==null");
      AppMethodBeat.o(95575);
      return;
    }
    String str = null;
    if (paramdmo.MQg != null) {
      str = z.b(paramdmo.MQg);
    }
    Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, scene=2, ADGroupId64=" + paramdmo.MQh + ", ADGroupId=" + paramdmo.MQc + ", extInfo=" + str);
    AppMethodBeat.o(95575);
  }
  
  public static boolean Jg(long paramLong)
  {
    AppMethodBeat.i(95570);
    if (DIc.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95570);
      return false;
    }
    DIc.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95570);
    return true;
  }
  
  public static boolean Jh(long paramLong)
  {
    AppMethodBeat.i(95571);
    if (DId.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95571);
      return false;
    }
    DId.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95571);
    return true;
  }
  
  private static boolean Ji(long paramLong)
  {
    AppMethodBeat.i(95572);
    DId.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95572);
    return true;
  }
  
  private static boolean Jj(long paramLong)
  {
    AppMethodBeat.i(95573);
    DIc.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95573);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(95576);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95576);
    return i;
  }
  
  public final int getType()
  {
    return 683;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95577);
    params = r.Jb(this.ece);
    Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + paramInt2 + " errCode " + paramInt3 + ", snsId=" + params);
    int i = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label223;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (((dze)this.rr.iLK.iLR).Scene != 2) {
        break label210;
      }
      h.CyF.dN(955, 1);
    }
    for (;;)
    {
      Jj(this.ece);
      Ji(this.ece);
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
      paramArrayOfByte = z.a(((dzf)this.rr.iLL.iLR).MYJ);
      if (paramArrayOfByte != null)
      {
        com.tencent.mm.vfs.s.deleteFile(this.jpU);
        com.tencent.mm.vfs.s.f(this.jpU, paramArrayOfByte, paramArrayOfByte.length);
      }
      paramInt1 = 0;
      break;
      label210:
      h.CyF.dN(955, 0);
    }
    label223:
    paramArrayOfByte = z.a(((dzf)this.rr.iLL.iLR).MYJ);
    if (paramArrayOfByte != null)
    {
      com.tencent.mm.vfs.s.deleteFile(this.jpU);
      com.tencent.mm.vfs.s.f(this.jpU, paramArrayOfByte, paramArrayOfByte.length);
    }
    paramArrayOfByte = ((dzf)this.rr.iLL.iLR).MYM;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = ((dzf)this.rr.iLL.iLR).MYN;
    int j = ((dze)this.rr.iLK.iLR).Scene;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail scene=" + j + ", snsXml=" + z.b(paramArrayOfByte.MYH.ObjectDesc));
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml=" + paramArrayOfByte.MYI);
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "dynamicData=" + z.b(localSKBuiltinBuffer_t));
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.MYH != null) && (paramArrayOfByte.MYH.DeleteFlag > 0))
    {
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", r.Jb(paramArrayOfByte.MYH.Id) + " will remove by get detail ");
      Jj(this.ece);
      Ji(this.ece);
      aj.faR().delete(paramArrayOfByte.MYH.Id);
      aj.faT().JI(paramArrayOfByte.MYH.Id);
      com.tencent.mm.plugin.sns.storage.g.JH(paramArrayOfByte.MYH.Id);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95577);
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.MYH != null))
    {
      if (paramArrayOfByte.MYH.CommentUserList == null)
      {
        paramInt1 = 0;
        if (paramArrayOfByte.MYH.LikeUserList != null) {
          break label854;
        }
        i = 0;
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment.size=" + paramInt1 + " liked.size=" + i + ", likeFlag=" + paramArrayOfByte.MYH.LikeFlag + ", snsId=" + r.Jb(paramArrayOfByte.MYH.Id));
      }
    }
    else
    {
      if (j != 2) {
        break label912;
      }
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { params });
      paramArrayOfByte = ((dzf)this.rr.iLL.iLR).MYO;
      if (paramArrayOfByte == null) {
        break label901;
      }
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "recv at adInfoXml=".concat(String.valueOf(z.a(paramArrayOfByte.KHH))));
      a.b(paramArrayOfByte);
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = aj.faR().JE(paramArrayOfByte.KHG.MYH.Id);
        com.tencent.mm.plugin.sns.ad.timeline.b.e.a(paramArrayOfByte.getTimeLine(), paramArrayOfByte.getAdXml(), 3);
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "preDownloadAdLandingPagesForAtMsg, id=".concat(String.valueOf(params)));
        j.aQk(paramArrayOfByte.field_adxml);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        Jj(this.ece);
        Ji(this.ece);
        AppMethodBeat.o(95577);
        return;
        paramInt1 = paramArrayOfByte.MYH.CommentUserList.size();
        break;
        label854:
        i = paramArrayOfByte.MYH.LikeUserList.size();
      }
      catch (Throwable params)
      {
        Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "TimeLineAdPreloadHelper->checkPreloadAdResource exp=" + params.toString());
        continue;
      }
      label901:
      Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "remindObject == null");
      continue;
      label912:
      a.a(paramArrayOfByte, localSKBuiltinBuffer_t);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.m
 * JD-Core Version:    0.7.0.1
 */