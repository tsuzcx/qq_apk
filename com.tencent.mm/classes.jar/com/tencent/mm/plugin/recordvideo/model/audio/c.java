package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.qm;
import com.tencent.mm.plugin.recordvideo.model.a.a;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a NJe;
  private static c NJj;
  private static long NJk;
  private static long NJl;
  private static qm NJm;
  public static final String TAG;
  public long Bjl;
  public int NJf;
  private long NJg;
  public boolean NJh;
  public final ArrayList<dlr> NJi;
  private boolean pause;
  private int source;
  
  static
  {
    AppMethodBeat.i(75420);
    NJe = new a((byte)0);
    TAG = "MicroMsg.AudioReporter";
    NJm = new qm();
    AppMethodBeat.o(75420);
  }
  
  public c()
  {
    AppMethodBeat.i(75419);
    AudioCacheInfo.a locala = AudioCacheInfo.NIB;
    this.source = AudioCacheInfo.gHX();
    this.pause = true;
    this.NJi = new ArrayList();
    AppMethodBeat.o(75419);
  }
  
  private final void gIf()
  {
    int j = 2;
    AppMethodBeat.i(163425);
    if (this.Bjl == 0L)
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
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      l1 = NJk;
      l2 = NJl;
      l3 = this.Bjl;
      if (!this.NJh) {
        break label220;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).b(16208, new Object[] { Integer.valueOf(i), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(l2), "", Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(this.NJf), "", "" });
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
  
  private final void gIg()
  {
    AppMethodBeat.i(75418);
    com.tencent.mm.kernel.h.baD().mCm.a((p)new a(this.Bjl, (List)this.NJi), 0);
    NJj = null;
    AppMethodBeat.o(75418);
  }
  
  public final void gIc()
  {
    AppMethodBeat.i(75417);
    dlr localdlr;
    long l;
    if (!this.pause)
    {
      localdlr = new dlr();
      l = System.currentTimeMillis();
      localdlr.aaRI = this.NJf;
      i = this.source;
      AudioCacheInfo.a locala = AudioCacheInfo.NIB;
      if (i != AudioCacheInfo.gHX()) {
        break label122;
      }
    }
    label122:
    for (int i = 1;; i = 9)
    {
      localdlr.aaRJ = i;
      localdlr.aaRK = ((int)(l - this.NJg));
      localdlr.aaRL = ((int)(this.NJg / 1000L));
      this.NJi.add(localdlr);
      this.pause = true;
      Log.i(TAG, kotlin.g.b.s.X("record pause ", d.a(localdlr)));
      AppMethodBeat.o(75417);
      return;
    }
  }
  
  public final void gId()
  {
    AppMethodBeat.i(163424);
    if (this.Bjl == 0L)
    {
      AppMethodBeat.o(163424);
      return;
    }
    dlr localdlr = new dlr();
    localdlr.aaRI = this.NJf;
    if (this.NJh)
    {
      i = this.source;
      locala = AudioCacheInfo.NIB;
      if (i == AudioCacheInfo.gHY()) {}
      for (i = 10;; i = 2)
      {
        localdlr.aaRJ = i;
        localdlr.aaRL = ((int)Util.nowSecond());
        gIc();
        this.NJi.add(localdlr);
        Log.i(TAG, kotlin.g.b.s.X("record send ", d.a(localdlr)));
        gIf();
        gIg();
        AppMethodBeat.o(163424);
        return;
      }
    }
    int i = this.source;
    AudioCacheInfo.a locala = AudioCacheInfo.NIB;
    if (i == AudioCacheInfo.gHY()) {}
    for (i = 12;; i = 6)
    {
      localdlr.aaRJ = i;
      break;
    }
  }
  
  public final void gIe()
  {
    AppMethodBeat.i(279674);
    if (this.Bjl == 0L)
    {
      AppMethodBeat.o(279674);
      return;
    }
    dlr localdlr = new dlr();
    localdlr.aaRI = this.NJf;
    if (this.NJh)
    {
      i = this.source;
      locala = AudioCacheInfo.NIB;
      if (i == AudioCacheInfo.gHY()) {}
      for (i = 11;; i = 5)
      {
        localdlr.aaRJ = i;
        localdlr.aaRL = ((int)Util.nowSecond());
        gIc();
        this.NJi.add(localdlr);
        Log.i(TAG, kotlin.g.b.s.X("record cancel ", d.a(localdlr)));
        gIg();
        AppMethodBeat.o(279674);
        return;
      }
    }
    int i = this.source;
    AudioCacheInfo.a locala = AudioCacheInfo.NIB;
    if (i == AudioCacheInfo.gHY()) {}
    for (i = 13;; i = 7)
    {
      localdlr.aaRJ = i;
      break;
    }
  }
  
  public final void kG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(279654);
    this.NJf = paramInt1;
    this.NJg = System.currentTimeMillis();
    this.NJh = true;
    this.pause = false;
    this.source = paramInt2;
    AppMethodBeat.o(279654);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void gIj()
    {
      AppMethodBeat.i(75416);
      Log.d(c.access$getTAG$cp(), kotlin.g.b.s.X("reportAudioSearchStruct:\n ", c.gIi().aIF()));
      c.gIi().bMH();
      qm localqm = new qm();
      kotlin.g.b.s.u(localqm, "<set-?>");
      c.a(localqm);
      AppMethodBeat.o(75416);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.c
 * JD-Core Version:    0.7.0.1
 */