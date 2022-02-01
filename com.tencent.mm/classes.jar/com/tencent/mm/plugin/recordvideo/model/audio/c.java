package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.gt;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.recordvideo.model.a.a;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-recordvideo_release"})
public final class c
{
  public static final String TAG = "MicroMsg.AudioReporter";
  private static c xzA;
  private static long xzB;
  private static long xzC;
  private static gt xzD;
  public static final a xzE;
  private boolean dCv;
  private int dnh;
  public long xcO;
  public int xzw;
  private long xzx;
  public boolean xzy;
  public final ArrayList<bxc> xzz;
  
  static
  {
    AppMethodBeat.i(75420);
    xzE = new a((byte)0);
    TAG = "MicroMsg.AudioReporter";
    xzD = new gt();
    AppMethodBeat.o(75420);
  }
  
  public c()
  {
    AppMethodBeat.i(75419);
    AudioCacheInfo.a locala = AudioCacheInfo.xzp;
    this.dnh = AudioCacheInfo.dFX();
    this.dCv = true;
    this.xzz = new ArrayList();
    AppMethodBeat.o(75419);
  }
  
  private final void dGd()
  {
    int j = 2;
    AppMethodBeat.i(163425);
    if (this.xcO == 0L)
    {
      AppMethodBeat.o(163425);
      return;
    }
    Object localObject = aj.getContext();
    int i;
    long l1;
    long l2;
    long l3;
    if (ay.isWifi((Context)localObject))
    {
      i = 1;
      localObject = com.tencent.mm.plugin.report.service.g.yhR;
      l1 = xzB;
      l2 = xzC;
      l3 = this.xcO;
      if (!this.xzy) {
        break label220;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(16208, new Object[] { Integer.valueOf(i), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(l2), "", Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(this.xzw), "", "" });
      AppMethodBeat.o(163425);
      return;
      if (ay.is4G((Context)localObject))
      {
        i = 6;
        break;
      }
      if (ay.is3G((Context)localObject))
      {
        i = 5;
        break;
      }
      if (ay.is2G((Context)localObject))
      {
        i = 4;
        break;
      }
      if (ay.isWap((Context)localObject))
      {
        i = 3;
        break;
      }
      i = 2;
      break;
      label220:
      j = 1;
    }
  }
  
  private final void dGe()
  {
    AppMethodBeat.i(75418);
    b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "network()");
    localb.aiU().b((n)new a(this.xcO, (List)this.xzz));
    xzA = null;
    AppMethodBeat.o(75418);
  }
  
  public final void dGa()
  {
    AppMethodBeat.i(75417);
    bxc localbxc;
    long l;
    if (!this.dCv)
    {
      localbxc = new bxc();
      l = System.currentTimeMillis();
      localbxc.GQZ = this.xzw;
      i = this.dnh;
      AudioCacheInfo.a locala = AudioCacheInfo.xzp;
      if (i != AudioCacheInfo.dFX()) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 9)
    {
      localbxc.GRa = i;
      localbxc.GRb = ((int)(l - this.xzx));
      localbxc.GRc = ((int)(this.xzx / 1000L));
      this.xzz.add(localbxc);
      this.dCv = true;
      ad.i(TAG, "record pause " + d.a(localbxc));
      AppMethodBeat.o(75417);
      return;
    }
  }
  
  public final void dGb()
  {
    AppMethodBeat.i(163424);
    if (this.xcO == 0L)
    {
      AppMethodBeat.o(163424);
      return;
    }
    bxc localbxc = new bxc();
    localbxc.GQZ = this.xzw;
    if (this.xzy)
    {
      i = this.dnh;
      locala = AudioCacheInfo.xzp;
      if (i == AudioCacheInfo.dFY()) {}
      for (i = 10;; i = 2)
      {
        localbxc.GRa = i;
        localbxc.GRc = ((int)bt.aQJ());
        dGa();
        this.xzz.add(localbxc);
        ad.i(TAG, "record send " + d.a(localbxc));
        dGd();
        dGe();
        AppMethodBeat.o(163424);
        return;
      }
    }
    int i = this.dnh;
    AudioCacheInfo.a locala = AudioCacheInfo.xzp;
    if (i == AudioCacheInfo.dFY()) {}
    for (i = 12;; i = 6)
    {
      localbxc.GRa = i;
      break;
    }
  }
  
  public final void dGc()
  {
    AppMethodBeat.i(200294);
    if (this.xcO == 0L)
    {
      AppMethodBeat.o(200294);
      return;
    }
    bxc localbxc = new bxc();
    localbxc.GQZ = this.xzw;
    if (this.xzy)
    {
      i = this.dnh;
      locala = AudioCacheInfo.xzp;
      if (i == AudioCacheInfo.dFY()) {}
      for (i = 11;; i = 5)
      {
        localbxc.GRa = i;
        localbxc.GRc = ((int)bt.aQJ());
        dGa();
        this.xzz.add(localbxc);
        ad.i(TAG, "record cancel " + d.a(localbxc));
        dGe();
        AppMethodBeat.o(200294);
        return;
      }
    }
    int i = this.dnh;
    AudioCacheInfo.a locala = AudioCacheInfo.xzp;
    if (i == AudioCacheInfo.dFY()) {}
    for (i = 13;; i = 7)
    {
      localbxc.GRa = i;
      break;
    }
  }
  
  public final void hj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200293);
    this.xzw = paramInt1;
    this.xzx = System.currentTimeMillis();
    this.xzy = true;
    this.dCv = false;
    this.dnh = paramInt2;
    AppMethodBeat.o(200293);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void dGh()
    {
      AppMethodBeat.i(75416);
      ad.d(c.access$getTAG$cp(), "reportAudioSearchStruct:\n " + c.dGg().RE());
      c.dGg().aLk();
      gt localgt = new gt();
      p.h(localgt, "<set-?>");
      c.a(localgt);
      AppMethodBeat.o(75416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.c
 * JD-Core Version:    0.7.0.1
 */