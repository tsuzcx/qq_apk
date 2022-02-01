package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.message.y;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpShareVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "data", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "mpShareVideoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "IPCInvoke_Fav", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG;
  public static final e Xml;
  
  static
  {
    AppMethodBeat.i(82666);
    Xml = new e();
    TAG = "MicroMsg.MpShareVideoMsgFav";
    AppMethodBeat.o(82666);
  }
  
  private static final void bQ(Bundle paramBundle) {}
  
  public static void c(y paramy)
  {
    AppMethodBeat.i(82664);
    s.u(paramy, "msgInfo");
    MpVideoDataParcelable localMpVideoDataParcelable = new MpVideoDataParcelable();
    localMpVideoDataParcelable.Xmn = paramy;
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localMpVideoDataParcelable, e.a.class, e..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(82664);
  }
  
  public static void d(jz paramjz)
  {
    AppMethodBeat.i(296709);
    if (paramjz == null)
    {
      Log.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(296709);
      return;
    }
    dn localdn = new dn();
    Object localObject1 = ad.Jo(Util.nullAsNil(paramjz.mso));
    localObject1 = ad.bCb().M((String)localObject1, true);
    s.checkNotNull(localObject1);
    ((ad.b)localObject1).q("sendAppMsgScene", Integer.valueOf(2));
    ((ad.b)localObject1).q("preChatName", paramjz.iiu);
    ((ad.b)localObject1).q("prePublishId", paramjz.mso);
    ((ad.b)localObject1).q("preUsername", paramjz.iit);
    ((ad.b)localObject1).q("referUrl", paramjz.url);
    localdn.hDr.hDy = 36;
    if (paramjz == null) {
      Log.w("MicroMsg.GetFavDataSource", "fillMpVideoEventInfo mpMsgItem is null");
    }
    for (;;)
    {
      localdn.publish();
      AppMethodBeat.o(296709);
      return;
      localObject1 = new arv();
      Object localObject2 = new asb();
      ((asb)localObject2).bto(z.bAM());
      ((asb)localObject2).btp(z.bAM());
      ((asb)localObject2).axH(4);
      ((asb)localObject2).yu(Util.nowMilliSecond());
      ((asb)localObject2).btv(paramjz.url);
      ((arv)localObject1).a((asb)localObject2);
      localObject2 = new arf();
      ((arf)localObject2).bsC("");
      ((arf)localObject2).bsx(paramjz.nUM);
      ((arf)localObject2).bsG(MD5Util.getMD5String(paramjz.YMn + paramjz.YMm));
      ((arf)localObject2).axx(paramjz.videoDuration);
      ((arf)localObject2).bso(paramjz.title);
      ((arf)localObject2).bsu(paramjz.url);
      ((arf)localObject2).Kj(true);
      ((arf)localObject2).Kk(true);
      arn localarn = new arn();
      localarn.vid = paramjz.YMn;
      localarn.videoUrl = paramjz.videoUrl;
      localarn.YMm = paramjz.YMm;
      localarn.hEE = paramjz.hEE;
      localarn.nUF = paramjz.nUF;
      localarn.nUM = paramjz.nUM;
      localarn.videoWidth = paramjz.width;
      localarn.videoHeight = paramjz.height;
      localarn.duration = paramjz.videoDuration;
      paramjz = new arg();
      paramjz.e(localarn);
      ((arf)localObject2).a(paramjz);
      paramjz = new LinkedList();
      paramjz.add(localObject2);
      ((arv)localObject1).cs(paramjz);
      localdn.hDr.hDt = ((arv)localObject1);
      localdn.hDr.type = 4;
      ((arf)localObject2).axy(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.e
 * JD-Core Version:    0.7.0.1
 */