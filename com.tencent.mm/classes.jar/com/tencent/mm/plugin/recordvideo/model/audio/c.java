package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.recordvideo.model.a.a;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-recordvideo_release"})
public final class c
{
  public static final String TAG = "MicroMsg.AudioReporter";
  public static final a xPA;
  private static c xPw;
  private static long xPx;
  private static long xPy;
  private static gv xPz;
  private boolean dDA;
  private int doj;
  public int xPs;
  private long xPt;
  public boolean xPu;
  public final ArrayList<bxw> xPv;
  public long xsF;
  
  static
  {
    AppMethodBeat.i(75420);
    xPA = new a((byte)0);
    TAG = "MicroMsg.AudioReporter";
    xPz = new gv();
    AppMethodBeat.o(75420);
  }
  
  public c()
  {
    AppMethodBeat.i(75419);
    AudioCacheInfo.a locala = AudioCacheInfo.xPl;
    this.doj = AudioCacheInfo.dJo();
    this.dDA = true;
    this.xPv = new ArrayList();
    AppMethodBeat.o(75419);
  }
  
  private final void dJu()
  {
    int j = 2;
    AppMethodBeat.i(163425);
    if (this.xsF == 0L)
    {
      AppMethodBeat.o(163425);
      return;
    }
    Object localObject = ak.getContext();
    int i;
    long l1;
    long l2;
    long l3;
    if (az.isWifi((Context)localObject))
    {
      i = 1;
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      l1 = xPx;
      l2 = xPy;
      l3 = this.xsF;
      if (!this.xPu) {
        break label220;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(16208, new Object[] { Integer.valueOf(i), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(l2), "", Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(this.xPs), "", "" });
      AppMethodBeat.o(163425);
      return;
      if (az.is4G((Context)localObject))
      {
        i = 6;
        break;
      }
      if (az.is3G((Context)localObject))
      {
        i = 5;
        break;
      }
      if (az.is2G((Context)localObject))
      {
        i = 4;
        break;
      }
      if (az.isWap((Context)localObject))
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
  
  private final void dJv()
  {
    AppMethodBeat.i(75418);
    b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "network()");
    localb.ajj().b((n)new a(this.xsF, (List)this.xPv));
    xPw = null;
    AppMethodBeat.o(75418);
  }
  
  public final void dJr()
  {
    AppMethodBeat.i(75417);
    bxw localbxw;
    long l;
    if (!this.dDA)
    {
      localbxw = new bxw();
      l = System.currentTimeMillis();
      localbxw.HkA = this.xPs;
      i = this.doj;
      AudioCacheInfo.a locala = AudioCacheInfo.xPl;
      if (i != AudioCacheInfo.dJo()) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 9)
    {
      localbxw.HkB = i;
      localbxw.HkC = ((int)(l - this.xPt));
      localbxw.HkD = ((int)(this.xPt / 1000L));
      this.xPv.add(localbxw);
      this.dDA = true;
      ae.i(TAG, "record pause " + d.a(localbxw));
      AppMethodBeat.o(75417);
      return;
    }
  }
  
  public final void dJs()
  {
    AppMethodBeat.i(163424);
    if (this.xsF == 0L)
    {
      AppMethodBeat.o(163424);
      return;
    }
    bxw localbxw = new bxw();
    localbxw.HkA = this.xPs;
    if (this.xPu)
    {
      i = this.doj;
      locala = AudioCacheInfo.xPl;
      if (i == AudioCacheInfo.dJp()) {}
      for (i = 10;; i = 2)
      {
        localbxw.HkB = i;
        localbxw.HkD = ((int)bu.aRi());
        dJr();
        this.xPv.add(localbxw);
        ae.i(TAG, "record send " + d.a(localbxw));
        dJu();
        dJv();
        AppMethodBeat.o(163424);
        return;
      }
    }
    int i = this.doj;
    AudioCacheInfo.a locala = AudioCacheInfo.xPl;
    if (i == AudioCacheInfo.dJp()) {}
    for (i = 12;; i = 6)
    {
      localbxw.HkB = i;
      break;
    }
  }
  
  public final void dJt()
  {
    AppMethodBeat.i(206555);
    if (this.xsF == 0L)
    {
      AppMethodBeat.o(206555);
      return;
    }
    bxw localbxw = new bxw();
    localbxw.HkA = this.xPs;
    if (this.xPu)
    {
      i = this.doj;
      locala = AudioCacheInfo.xPl;
      if (i == AudioCacheInfo.dJp()) {}
      for (i = 11;; i = 5)
      {
        localbxw.HkB = i;
        localbxw.HkD = ((int)bu.aRi());
        dJr();
        this.xPv.add(localbxw);
        ae.i(TAG, "record cancel " + d.a(localbxw));
        dJv();
        AppMethodBeat.o(206555);
        return;
      }
    }
    int i = this.doj;
    AudioCacheInfo.a locala = AudioCacheInfo.xPl;
    if (i == AudioCacheInfo.dJp()) {}
    for (i = 13;; i = 7)
    {
      localbxw.HkB = i;
      break;
    }
  }
  
  public final void hl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206554);
    this.xPs = paramInt1;
    this.xPt = System.currentTimeMillis();
    this.xPu = true;
    this.dDA = false;
    this.doj = paramInt2;
    AppMethodBeat.o(206554);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void dJy()
    {
      AppMethodBeat.i(75416);
      ae.d(c.access$getTAG$cp(), "reportAudioSearchStruct:\n " + c.dJx().RD());
      c.dJx().aLH();
      gv localgv = new gv();
      p.h(localgv, "<set-?>");
      c.a(localgv);
      AppMethodBeat.o(75416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.c
 * JD-Core Version:    0.7.0.1
 */