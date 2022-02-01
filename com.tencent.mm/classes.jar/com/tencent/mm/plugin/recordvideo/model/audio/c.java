package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.kj;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.model.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-recordvideo_release"})
public final class c
{
  private static long BPA = 0L;
  private static long BPB = 0L;
  private static kj BPC;
  public static final a BPD;
  private static c BPz;
  public static final String TAG = "MicroMsg.AudioReporter";
  public int BPv;
  private long BPw;
  public boolean BPx;
  public final ArrayList<clo> BPy;
  private boolean pause;
  private int source;
  public long ulj;
  
  static
  {
    AppMethodBeat.i(75420);
    BPD = new a((byte)0);
    TAG = "MicroMsg.AudioReporter";
    BPC = new kj();
    AppMethodBeat.o(75420);
  }
  
  public c()
  {
    AppMethodBeat.i(75419);
    AudioCacheInfo.a locala = AudioCacheInfo.BPo;
    this.source = AudioCacheInfo.eKb();
    this.pause = true;
    this.BPy = new ArrayList();
    AppMethodBeat.o(75419);
  }
  
  private final void eKg()
  {
    int j = 2;
    AppMethodBeat.i(163425);
    if (this.ulj == 0L)
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
      localObject = h.CyF;
      l1 = BPA;
      l2 = BPB;
      l3 = this.ulj;
      if (!this.BPx) {
        break label220;
      }
    }
    for (;;)
    {
      ((h)localObject).a(16208, new Object[] { Integer.valueOf(i), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(l2), "", Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(this.BPv), "", "" });
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
  
  private final void eKh()
  {
    AppMethodBeat.i(75418);
    b localb = g.aAg();
    p.g(localb, "network()");
    localb.azz().b((q)new a(this.ulj, (List)this.BPy));
    BPz = null;
    AppMethodBeat.o(75418);
  }
  
  public final void eKd()
  {
    AppMethodBeat.i(75417);
    clo localclo;
    long l;
    if (!this.pause)
    {
      localclo = new clo();
      l = System.currentTimeMillis();
      localclo.MqO = this.BPv;
      i = this.source;
      AudioCacheInfo.a locala = AudioCacheInfo.BPo;
      if (i != AudioCacheInfo.eKb()) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 9)
    {
      localclo.MqP = i;
      localclo.MqQ = ((int)(l - this.BPw));
      localclo.MqR = ((int)(this.BPw / 1000L));
      this.BPy.add(localclo);
      this.pause = true;
      Log.i(TAG, "record pause " + d.a(localclo));
      AppMethodBeat.o(75417);
      return;
    }
  }
  
  public final void eKe()
  {
    AppMethodBeat.i(163424);
    if (this.ulj == 0L)
    {
      AppMethodBeat.o(163424);
      return;
    }
    clo localclo = new clo();
    localclo.MqO = this.BPv;
    if (this.BPx)
    {
      i = this.source;
      locala = AudioCacheInfo.BPo;
      if (i == AudioCacheInfo.eKc()) {}
      for (i = 10;; i = 2)
      {
        localclo.MqP = i;
        localclo.MqR = ((int)Util.nowSecond());
        eKd();
        this.BPy.add(localclo);
        Log.i(TAG, "record send " + d.a(localclo));
        eKg();
        eKh();
        AppMethodBeat.o(163424);
        return;
      }
    }
    int i = this.source;
    AudioCacheInfo.a locala = AudioCacheInfo.BPo;
    if (i == AudioCacheInfo.eKc()) {}
    for (i = 12;; i = 6)
    {
      localclo.MqP = i;
      break;
    }
  }
  
  public final void eKf()
  {
    AppMethodBeat.i(237261);
    if (this.ulj == 0L)
    {
      AppMethodBeat.o(237261);
      return;
    }
    clo localclo = new clo();
    localclo.MqO = this.BPv;
    if (this.BPx)
    {
      i = this.source;
      locala = AudioCacheInfo.BPo;
      if (i == AudioCacheInfo.eKc()) {}
      for (i = 11;; i = 5)
      {
        localclo.MqP = i;
        localclo.MqR = ((int)Util.nowSecond());
        eKd();
        this.BPy.add(localclo);
        Log.i(TAG, "record cancel " + d.a(localclo));
        eKh();
        AppMethodBeat.o(237261);
        return;
      }
    }
    int i = this.source;
    AudioCacheInfo.a locala = AudioCacheInfo.BPo;
    if (i == AudioCacheInfo.eKc()) {}
    for (i = 13;; i = 7)
    {
      localclo.MqP = i;
      break;
    }
  }
  
  public final void hV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237260);
    this.BPv = paramInt1;
    this.BPw = System.currentTimeMillis();
    this.BPx = true;
    this.pause = false;
    this.source = paramInt2;
    AppMethodBeat.o(237260);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void eKk()
    {
      AppMethodBeat.i(75416);
      Log.d(c.access$getTAG$cp(), "reportAudioSearchStruct:\n " + c.eKj().abW());
      c.eKj().bfK();
      kj localkj = new kj();
      p.h(localkj, "<set-?>");
      c.a(localkj);
      AppMethodBeat.o(75416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.c
 * JD-Core Version:    0.7.0.1
 */