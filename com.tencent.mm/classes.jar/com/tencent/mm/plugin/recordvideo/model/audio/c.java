package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.model.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-recordvideo_release"})
public final class c
{
  public static final String TAG = "MicroMsg.AudioReporter";
  private static c viX;
  private static long viY;
  private static long viZ;
  private static ec vja;
  public static final a vjb;
  public int dep;
  private boolean dsU;
  public long uMU;
  public int viT;
  private long viU;
  public boolean viV;
  public final ArrayList<bnz> viW;
  
  static
  {
    AppMethodBeat.i(75420);
    vjb = new a((byte)0);
    TAG = "MicroMsg.AudioReporter";
    vja = new ec();
    AppMethodBeat.o(75420);
  }
  
  public c()
  {
    AppMethodBeat.i(75419);
    AudioCacheInfo.a locala = AudioCacheInfo.viM;
    this.dep = AudioCacheInfo.dhQ();
    this.dsU = true;
    this.viW = new ArrayList();
    AppMethodBeat.o(75419);
  }
  
  private final void dhU()
  {
    int j = 2;
    AppMethodBeat.i(163425);
    if (this.uMU == 0L)
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
      localObject = h.vKh;
      l1 = viY;
      l2 = viZ;
      l3 = this.uMU;
      if (!this.viV) {
        break label220;
      }
    }
    for (;;)
    {
      ((h)localObject).f(16208, new Object[] { Integer.valueOf(i), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(l2), "", Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(this.viT), "", "" });
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
  
  public final void dhS()
  {
    AppMethodBeat.i(75417);
    bnz localbnz;
    long l;
    if (!this.dsU)
    {
      localbnz = new bnz();
      l = System.currentTimeMillis();
      localbnz.DLi = this.viT;
      i = this.dep;
      AudioCacheInfo.a locala = AudioCacheInfo.viM;
      if (i != AudioCacheInfo.dhQ()) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 9)
    {
      localbnz.DLj = i;
      localbnz.DLk = ((int)(l - this.viU));
      localbnz.DLl = ((int)(this.viU / 1000L));
      this.viW.add(localbnz);
      this.dsU = true;
      ad.i(TAG, "record pause " + d.a(localbnz));
      AppMethodBeat.o(75417);
      return;
    }
  }
  
  public final void dhT()
  {
    AppMethodBeat.i(163424);
    if (this.uMU == 0L)
    {
      AppMethodBeat.o(163424);
      return;
    }
    bnz localbnz = new bnz();
    localbnz.DLi = this.viT;
    if (this.viV)
    {
      i = this.dep;
      locala = AudioCacheInfo.viM;
      if (i == AudioCacheInfo.dhR()) {}
      for (i = 10;; i = 2)
      {
        localbnz.DLj = i;
        localbnz.DLl = ((int)bt.aGK());
        dhS();
        this.viW.add(localbnz);
        ad.i(TAG, "record send " + d.a(localbnz));
        dhU();
        dhV();
        AppMethodBeat.o(163424);
        return;
      }
    }
    int i = this.dep;
    AudioCacheInfo.a locala = AudioCacheInfo.viM;
    if (i == AudioCacheInfo.dhR()) {}
    for (i = 12;; i = 6)
    {
      localbnz.DLj = i;
      break;
    }
  }
  
  public final void dhV()
  {
    AppMethodBeat.i(75418);
    b localb = g.afA();
    k.g(localb, "network()");
    localb.aeS().b((n)new a(this.uMU, (List)this.viW));
    viX = null;
    AppMethodBeat.o(75418);
  }
  
  public final void ld(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204075);
    this.viT = paramInt1;
    this.viU = System.currentTimeMillis();
    this.viV = true;
    this.dsU = false;
    this.dep = paramInt2;
    AppMethodBeat.o(204075);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void dhY()
    {
      AppMethodBeat.i(75416);
      ad.d(c.access$getTAG$cp(), "reportAudioSearchStruct:\n " + c.dhX().PW());
      c.dhX().aBj();
      ec localec = new ec();
      k.h(localec, "<set-?>");
      c.a(localec);
      AppMethodBeat.o(75416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.c
 * JD-Core Version:    0.7.0.1
 */