package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/RecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-story_release"})
public final class c
{
  public static final String TAG = "MicroMsg.AudioReporter";
  private static c swM;
  public static long swN;
  public static long swO;
  private static bm swP;
  public static final c.a swQ;
  public boolean cCv;
  public int cpt;
  public long pKF;
  public int swI;
  public long swJ;
  public boolean swK;
  public final ArrayList<bsp> swL;
  
  static
  {
    AppMethodBeat.i(109190);
    swQ = new c.a((byte)0);
    TAG = "MicroMsg.AudioReporter";
    swP = new bm();
    AppMethodBeat.o(109190);
  }
  
  public c()
  {
    AppMethodBeat.i(109189);
    AudioCacheInfo.a locala = AudioCacheInfo.swC;
    this.cpt = AudioCacheInfo.cBy();
    this.cCv = true;
    this.swL = new ArrayList();
    AppMethodBeat.o(109189);
  }
  
  public final void cBA()
  {
    AppMethodBeat.i(109187);
    bsp localbsp;
    long l;
    if (!this.cCv)
    {
      localbsp = new bsp();
      l = System.currentTimeMillis();
      localbsp.xGe = this.swI;
      i = this.cpt;
      AudioCacheInfo.a locala = AudioCacheInfo.swC;
      if (i != AudioCacheInfo.cBy()) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 9)
    {
      localbsp.xGf = i;
      localbsp.xGg = ((int)(l - this.swJ));
      localbsp.xGh = ((int)(this.swJ / 1000L));
      this.swL.add(localbsp);
      this.cCv = true;
      ab.i(TAG, "record pause " + d.a(localbsp));
      AppMethodBeat.o(109187);
      return;
    }
  }
  
  public final void cBB()
  {
    AppMethodBeat.i(109188);
    com.tencent.mm.kernel.b localb = g.RK();
    j.p(localb, "network()");
    localb.Rc().b((m)new com.tencent.mm.plugin.story.model.a.b(this.pKF, (List)this.swL));
    swM = null;
    AppMethodBeat.o(109188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.c
 * JD-Core Version:    0.7.0.1
 */