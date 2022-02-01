package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.fs;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.model.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-recordvideo_release"})
public final class c
{
  public static final String TAG = "MicroMsg.AudioReporter";
  private static c wrJ;
  private static long wrK;
  private static long wrL;
  private static fs wrM;
  public static final a wrN;
  public int dbL;
  private boolean dqE;
  public long vVK;
  public int wrF;
  private long wrG;
  public boolean wrH;
  public final ArrayList<bsp> wrI;
  
  static
  {
    AppMethodBeat.i(75420);
    wrN = new a((byte)0);
    TAG = "MicroMsg.AudioReporter";
    wrM = new fs();
    AppMethodBeat.o(75420);
  }
  
  public c()
  {
    AppMethodBeat.i(75419);
    AudioCacheInfo.a locala = AudioCacheInfo.wry;
    this.dbL = AudioCacheInfo.dvB();
    this.dqE = true;
    this.wrI = new ArrayList();
    AppMethodBeat.o(75419);
  }
  
  private final void dvF()
  {
    int j = 2;
    AppMethodBeat.i(163425);
    if (this.vVK == 0L)
    {
      AppMethodBeat.o(163425);
      return;
    }
    Object localObject = ai.getContext();
    int i;
    long l1;
    long l2;
    long l3;
    if (ax.isWifi((Context)localObject))
    {
      i = 1;
      localObject = h.wUl;
      l1 = wrK;
      l2 = wrL;
      l3 = this.vVK;
      if (!this.wrH) {
        break label220;
      }
    }
    for (;;)
    {
      ((h)localObject).f(16208, new Object[] { Integer.valueOf(i), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(l2), "", Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(this.wrF), "", "" });
      AppMethodBeat.o(163425);
      return;
      if (ax.is4G((Context)localObject))
      {
        i = 6;
        break;
      }
      if (ax.is3G((Context)localObject))
      {
        i = 5;
        break;
      }
      if (ax.is2G((Context)localObject))
      {
        i = 4;
        break;
      }
      if (ax.isWap((Context)localObject))
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
  
  public final void dvD()
  {
    AppMethodBeat.i(75417);
    bsp localbsp;
    long l;
    if (!this.dqE)
    {
      localbsp = new bsp();
      l = System.currentTimeMillis();
      localbsp.Fhx = this.wrF;
      i = this.dbL;
      AudioCacheInfo.a locala = AudioCacheInfo.wry;
      if (i != AudioCacheInfo.dvB()) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 9)
    {
      localbsp.Fhy = i;
      localbsp.Fhz = ((int)(l - this.wrG));
      localbsp.FhA = ((int)(this.wrG / 1000L));
      this.wrI.add(localbsp);
      this.dqE = true;
      ac.i(TAG, "record pause " + d.a(localbsp));
      AppMethodBeat.o(75417);
      return;
    }
  }
  
  public final void dvE()
  {
    AppMethodBeat.i(163424);
    if (this.vVK == 0L)
    {
      AppMethodBeat.o(163424);
      return;
    }
    bsp localbsp = new bsp();
    localbsp.Fhx = this.wrF;
    if (this.wrH)
    {
      i = this.dbL;
      locala = AudioCacheInfo.wry;
      if (i == AudioCacheInfo.dvC()) {}
      for (i = 10;; i = 2)
      {
        localbsp.Fhy = i;
        localbsp.FhA = ((int)bs.aNx());
        dvD();
        this.wrI.add(localbsp);
        ac.i(TAG, "record send " + d.a(localbsp));
        dvF();
        dvG();
        AppMethodBeat.o(163424);
        return;
      }
    }
    int i = this.dbL;
    AudioCacheInfo.a locala = AudioCacheInfo.wry;
    if (i == AudioCacheInfo.dvC()) {}
    for (i = 12;; i = 6)
    {
      localbsp.Fhy = i;
      break;
    }
  }
  
  public final void dvG()
  {
    AppMethodBeat.i(75418);
    b localb = g.agQ();
    k.g(localb, "network()");
    localb.agi().b((n)new a(this.vVK, (List)this.wrI));
    wrJ = null;
    AppMethodBeat.o(75418);
  }
  
  public final void gS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199264);
    this.wrF = paramInt1;
    this.wrG = System.currentTimeMillis();
    this.wrH = true;
    this.dqE = false;
    this.dbL = paramInt2;
    AppMethodBeat.o(199264);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void dvJ()
    {
      AppMethodBeat.i(75416);
      ac.d(c.access$getTAG$cp(), "reportAudioSearchStruct:\n " + c.dvI().PS());
      c.dvI().aHZ();
      fs localfs = new fs();
      k.h(localfs, "<set-?>");
      c.a(localfs);
      AppMethodBeat.o(75416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.c
 * JD-Core Version:    0.7.0.1
 */