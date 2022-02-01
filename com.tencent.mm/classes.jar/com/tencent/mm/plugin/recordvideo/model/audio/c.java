package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.nc;
import com.tencent.mm.plugin.recordvideo.model.a.a;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-recordvideo_release"})
public final class c
{
  private static c HMl;
  private static long HMm = 0L;
  private static long HMn = 0L;
  private static nc HMo;
  public static final a HMp;
  public static final String TAG = "MicroMsg.AudioReporter";
  public int HMh;
  private long HMi;
  public boolean HMj;
  public final ArrayList<cul> HMk;
  private boolean pause;
  private int source;
  public long yjR;
  
  static
  {
    AppMethodBeat.i(75420);
    HMp = new a((byte)0);
    TAG = "MicroMsg.AudioReporter";
    HMo = new nc();
    AppMethodBeat.o(75420);
  }
  
  public c()
  {
    AppMethodBeat.i(75419);
    AudioCacheInfo.a locala = AudioCacheInfo.HMa;
    this.source = AudioCacheInfo.fwo();
    this.pause = true;
    this.HMk = new ArrayList();
    AppMethodBeat.o(75419);
  }
  
  private final void fww()
  {
    int j = 2;
    AppMethodBeat.i(163425);
    if (this.yjR == 0L)
    {
      AppMethodBeat.o(163425);
      return;
    }
    Object localObject = MMApplicationContext.getContext();
    int i;
    long l1;
    long l2;
    long l3;
    if (NetStatusUtil.isWifi((Context)localObject))
    {
      i = 1;
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      l1 = HMm;
      l2 = HMn;
      l3 = this.yjR;
      if (!this.HMj) {
        break label220;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(16208, new Object[] { Integer.valueOf(i), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(l2), "", Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(this.HMh), "", "" });
      AppMethodBeat.o(163425);
      return;
      if (NetStatusUtil.is4G((Context)localObject))
      {
        i = 6;
        break;
      }
      if (NetStatusUtil.is3G((Context)localObject))
      {
        i = 5;
        break;
      }
      if (NetStatusUtil.is2G((Context)localObject))
      {
        i = 4;
        break;
      }
      if (NetStatusUtil.isWap((Context)localObject))
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
  
  private final void fwx()
  {
    AppMethodBeat.i(75418);
    com.tencent.mm.kernel.c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "network()");
    localc.aGY().b((q)new a(this.yjR, (List)this.HMk));
    HMl = null;
    AppMethodBeat.o(75418);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(75417);
    cul localcul;
    long l;
    if (!this.pause)
    {
      localcul = new cul();
      l = System.currentTimeMillis();
      localcul.TCc = this.HMh;
      i = this.source;
      AudioCacheInfo.a locala = AudioCacheInfo.HMa;
      if (i != AudioCacheInfo.fwo()) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 9)
    {
      localcul.TCd = i;
      localcul.TCe = ((int)(l - this.HMi));
      localcul.TCf = ((int)(this.HMi / 1000L));
      this.HMk.add(localcul);
      this.pause = true;
      Log.i(TAG, "record pause " + d.a(localcul));
      AppMethodBeat.o(75417);
      return;
    }
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(163424);
    if (this.yjR == 0L)
    {
      AppMethodBeat.o(163424);
      return;
    }
    cul localcul = new cul();
    localcul.TCc = this.HMh;
    if (this.HMj)
    {
      i = this.source;
      locala = AudioCacheInfo.HMa;
      if (i == AudioCacheInfo.fwp()) {}
      for (i = 10;; i = 2)
      {
        localcul.TCd = i;
        localcul.TCf = ((int)Util.nowSecond());
        fwt();
        this.HMk.add(localcul);
        Log.i(TAG, "record send " + d.a(localcul));
        fww();
        fwx();
        AppMethodBeat.o(163424);
        return;
      }
    }
    int i = this.source;
    AudioCacheInfo.a locala = AudioCacheInfo.HMa;
    if (i == AudioCacheInfo.fwp()) {}
    for (i = 12;; i = 6)
    {
      localcul.TCd = i;
      break;
    }
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(228998);
    if (this.yjR == 0L)
    {
      AppMethodBeat.o(228998);
      return;
    }
    cul localcul = new cul();
    localcul.TCc = this.HMh;
    if (this.HMj)
    {
      i = this.source;
      locala = AudioCacheInfo.HMa;
      if (i == AudioCacheInfo.fwp()) {}
      for (i = 11;; i = 5)
      {
        localcul.TCd = i;
        localcul.TCf = ((int)Util.nowSecond());
        fwt();
        this.HMk.add(localcul);
        Log.i(TAG, "record cancel " + d.a(localcul));
        fwx();
        AppMethodBeat.o(228998);
        return;
      }
    }
    int i = this.source;
    AudioCacheInfo.a locala = AudioCacheInfo.HMa;
    if (i == AudioCacheInfo.fwp()) {}
    for (i = 13;; i = 7)
    {
      localcul.TCd = i;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void fwA()
    {
      AppMethodBeat.i(75416);
      Log.d(c.access$getTAG$cp(), "reportAudioSearchStruct:\n " + c.fwz().agI());
      c.fwz().bpa();
      nc localnc = new nc();
      p.k(localnc, "<set-?>");
      c.a(localnc);
      AppMethodBeat.o(75416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.c
 * JD-Core Version:    0.7.0.1
 */