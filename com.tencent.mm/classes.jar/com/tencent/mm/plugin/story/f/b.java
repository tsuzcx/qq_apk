package com.tencent.mm.plugin.story.f;

import a.f.a.m;
import a.f.a.q;
import a.y;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Process;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.story.model.audio.i.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy.a;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI.b;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.story.ui.view.editor.item.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "uiNavigation", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "view", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;)V", "TAG", "", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "getContext", "()Landroid/content/Context;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "isFavorite", "", "isNotifyMoment", "loading", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$StoryProgressDialog;", "mixAudio", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "muteOrigin", "showLoading", "com/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1;", "startPerformance", "", "getUiNavigation", "()Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "getView", "()Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "checkAudioCache", "", "callback", "Lkotlin/Function0;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "isImageVideo", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "mediaDes", "needExport", "resId", "destroy", "getEditorItemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "getMixer", "Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer;", "editorItems", "mix", "mute", "notifyFavorite", "notifyMoment", "isNotify", "onBack", "onPlayerRepeat", "pause", "pauseAudio", "playAudio", "info", "prepareReport", "reportImageSize", "reset", "resume", "runMix", "runMixInBackground", "setup", "StoryProgressDialog", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.story.d.b.a
{
  final String TAG;
  final Context context;
  int eez;
  boolean qaU;
  private v qdF;
  a qdb;
  boolean sAA;
  boolean sAB;
  AudioCacheInfo sAC;
  j sAD;
  final StoryCaptureUI.b sAE;
  public final com.tencent.mm.plugin.story.d.b.b sAF;
  com.tencent.mm.plugin.story.e.a syP;
  
  public b(Context paramContext, StoryCaptureUI.b paramb, com.tencent.mm.plugin.story.d.b.b paramb1)
  {
    AppMethodBeat.i(109553);
    this.context = paramContext;
    this.sAE = paramb;
    this.sAF = paramb1;
    this.TAG = "MicroMsg.Story.EditorPresenter";
    this.syP = new com.tencent.mm.plugin.story.e.a();
    this.sAA = true;
    this.sAD = new j(this);
    AppMethodBeat.o(109553);
  }
  
  private final void cCj()
  {
    AppMethodBeat.i(109547);
    com.tencent.mm.media.i.a locala = new com.tencent.mm.media.i.a("runMix");
    pause();
    Object localObject1 = new a();
    Object localObject2 = this.context;
    a.f.b.j.q(localObject2, "context");
    a.a((a)localObject1, (Context)localObject2, false, 0, (a.f.a.a)b.a.b.sAI, 6);
    this.qdb = ((a)localObject1);
    Object localObject3;
    boolean bool;
    int j;
    int k;
    int m;
    if (this.qaU) {
      if (this.sAC == null)
      {
        i = 0;
        this.syP.ssq = i;
        this.syP.ssr = this.sAC;
        localObject1 = cgr();
        localObject2 = U((ArrayList)localObject1);
        localObject3 = k.sCp;
        localObject3 = k.a(this.sAF, this.sAC);
        bool = WXHardCoderJNI.hcEncodeVideoEnable;
        j = WXHardCoderJNI.hcEncodeVideoDelay;
        k = WXHardCoderJNI.hcEncodeVideoCPU;
        m = WXHardCoderJNI.hcEncodeVideoIO;
        if (!WXHardCoderJNI.hcEncodeVideoThr) {
          break label341;
        }
      }
    }
    label341:
    for (int i = Process.myTid();; i = 0)
    {
      this.eez = WXHardCoderJNI.startPerformance(bool, j, k, m, i, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.Media.StoryVideoMixer");
      ab.i("MicroMsg.Media.StoryVideoMixer", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(this.eez) });
      c.a locala1 = (c.a)com.tencent.mm.plugin.story.c.a.c.srQ.Uw();
      locala1.acE(this.syP.ssl);
      ab.i("MicroMsg.Media.StoryVideoMixer", "remux video config: ".concat(String.valueOf(locala1)));
      ((com.tencent.mm.plugin.story.model.e.b)localObject2).a(locala1.eRu, locala1.eRv, locala1.videoBitrate, locala1.fzT, locala1.audioSampleRate, 1, locala1.eRw, locala1.eWL);
      ((com.tencent.mm.plugin.story.model.e.b)localObject2).a((q)new b.g(this, locala, (ArrayList)localObject1, (chk)localObject3));
      AppMethodBeat.o(109547);
      return;
      i = 2;
      break;
      if (this.sAC == null)
      {
        i = 1;
        break;
      }
      i = 3;
      break;
    }
  }
  
  final com.tencent.mm.plugin.story.model.e.b U(ArrayList<com.tencent.mm.media.editor.a.b> paramArrayList)
  {
    AppMethodBeat.i(109548);
    float f1 = this.sAF.getItemContainer().getLeft();
    float f2 = this.sAF.getItemContainer().getTop();
    float f3 = this.sAF.getItemContainer().getRight();
    float f4 = this.sAF.getItemContainer().getBottom();
    long l = cb.abq();
    com.tencent.mm.plugin.story.e.a locala = this.syP;
    paramArrayList = (List)paramArrayList;
    String str1 = com.tencent.mm.plugin.story.model.l.acZ(String.valueOf(l));
    String str2 = com.tencent.mm.plugin.story.model.l.ada(String.valueOf(l));
    paramArrayList = new com.tencent.mm.plugin.story.model.e.b(locala, paramArrayList, new float[] { f1, f2, f3, f4 }, str1, str2, 0, false, 96);
    AppMethodBeat.o(109548);
    return paramArrayList;
  }
  
  public final void a(com.tencent.mm.plugin.story.e.a parama)
  {
    AppMethodBeat.i(109540);
    a.f.b.j.q(parama, "captureInfo");
    this.syP = parama;
    Object localObject = com.tencent.mm.plugin.story.model.audio.c.swQ;
    com.tencent.mm.plugin.story.model.audio.c.a(new com.tencent.mm.plugin.story.model.audio.c());
    com.tencent.mm.plugin.story.c.a locala = new com.tencent.mm.plugin.story.c.a();
    locala.sre = parama.ssp;
    if (parama.ssp) {}
    for (localObject = com.tencent.mm.plugin.story.c.d.srw;; localObject = com.tencent.mm.plugin.story.c.d.srr)
    {
      localObject = locala.a((com.tencent.mm.plugin.story.c.d)localObject);
      ((com.tencent.mm.plugin.story.c.a)localObject).srg = true;
      ((com.tencent.mm.plugin.story.c.a)localObject).srf = true;
      this.sAF.a(parama.ssl, parama.sss, parama.ssn, parama.sso, parama.ssp, (com.tencent.mm.plugin.story.c.a)localObject, (a.f.a.a)new b.i(this));
      AppMethodBeat.o(109540);
      return;
    }
  }
  
  public final void bnC()
  {
    int j = 2;
    AppMethodBeat.i(109550);
    Object localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDy().bC(System.currentTimeMillis());
    localObject1 = com.tencent.mm.plugin.story.model.audio.c.swQ;
    localObject1 = com.tencent.mm.plugin.story.model.audio.c.cBC();
    int i;
    label179:
    long l1;
    long l2;
    long l3;
    if ((localObject1 != null) && (((com.tencent.mm.plugin.story.model.audio.c)localObject1).pKF != 0L))
    {
      localObject2 = new bsp();
      ((bsp)localObject2).xGe = ((com.tencent.mm.plugin.story.model.audio.c)localObject1).swI;
      if (!((com.tencent.mm.plugin.story.model.audio.c)localObject1).swK) {
        break label349;
      }
      i = ((com.tencent.mm.plugin.story.model.audio.c)localObject1).cpt;
      localObject3 = AudioCacheInfo.swC;
      if (i != AudioCacheInfo.cBz()) {
        break label344;
      }
      i = 10;
      ((bsp)localObject2).xGf = i;
      ((bsp)localObject2).xGh = ((int)bo.aox());
      ((com.tencent.mm.plugin.story.model.audio.c)localObject1).cBA();
      ((com.tencent.mm.plugin.story.model.audio.c)localObject1).swL.add(localObject2);
      ab.i(com.tencent.mm.plugin.story.model.audio.c.TAG, "record send " + com.tencent.mm.plugin.story.model.audio.d.a((bsp)localObject2));
      if (((com.tencent.mm.plugin.story.model.audio.c)localObject1).pKF != 0L)
      {
        localObject2 = ah.getContext();
        if (!at.isWifi((Context)localObject2)) {
          break label385;
        }
        i = 1;
        localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
        l1 = com.tencent.mm.plugin.story.model.audio.c.swN;
        l2 = com.tencent.mm.plugin.story.model.audio.c.swO;
        l3 = ((com.tencent.mm.plugin.story.model.audio.c)localObject1).pKF;
        if (!((com.tencent.mm.plugin.story.model.audio.c)localObject1).swK) {
          break label443;
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).e(16208, new Object[] { Integer.valueOf(i), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(l2), "", Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(((com.tencent.mm.plugin.story.model.audio.c)localObject1).swI), "", "" });
      ((com.tencent.mm.plugin.story.model.audio.c)localObject1).cBB();
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      if (j.b.cAM() != com.tencent.mm.plugin.story.c.a.f.a.ssi) {
        break label448;
      }
      localObject1 = com.tencent.mm.plugin.story.g.h.sEz;
      com.tencent.mm.plugin.story.g.h.mh(true);
      cCj();
      AppMethodBeat.o(109550);
      return;
      label344:
      i = 2;
      break;
      label349:
      i = ((com.tencent.mm.plugin.story.model.audio.c)localObject1).cpt;
      localObject3 = AudioCacheInfo.swC;
      if (i == AudioCacheInfo.cBz()) {}
      for (i = 12;; i = 6)
      {
        ((bsp)localObject2).xGf = i;
        break;
      }
      label385:
      if (at.is4G((Context)localObject2))
      {
        i = 6;
        break label179;
      }
      if (at.is3G((Context)localObject2))
      {
        i = 5;
        break label179;
      }
      if (at.is2G((Context)localObject2))
      {
        i = 4;
        break label179;
      }
      if (at.isWap((Context)localObject2))
      {
        i = 3;
        break label179;
      }
      i = 2;
      break label179;
      label443:
      j = 1;
    }
    label448:
    localObject1 = com.tencent.mm.plugin.story.g.h.sEz;
    com.tencent.mm.plugin.story.g.h.mh(false);
    localObject1 = (a.f.a.a)new b.f(this);
    Object localObject2 = this.sAC;
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkAudioCache audio:");
    if (localObject2 != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append(", cache:");
      if (localObject2 == null) {
        break label648;
      }
    }
    label648:
    for (boolean bool = ((AudioCacheInfo)localObject2).arq;; bool = false)
    {
      ab.i((String)localObject3, bool);
      if ((localObject2 == null) || (((AudioCacheInfo)localObject2).arq)) {
        break label654;
      }
      ab.i(this.TAG, "checkAudioCache false");
      localObject3 = new a();
      a.a((a)localObject3, this.context, true, 0, (a.f.a.a)new b(this, (AudioCacheInfo)localObject2), 4);
      this.qdb = ((a)localObject3);
      localObject3 = com.tencent.mm.plugin.story.model.audio.i.swW;
      com.tencent.mm.plugin.story.model.audio.i.cBF().a((AudioCacheInfo)localObject2, (m)new b.c(this, (AudioCacheInfo)localObject2, (a.f.a.a)localObject1));
      AppMethodBeat.o(109550);
      return;
      bool = false;
      break;
    }
    label654:
    ab.i(this.TAG, "checkAudioCache done");
    ((a.f.a.a)localObject1).invoke();
    AppMethodBeat.o(109550);
  }
  
  public final void c(AudioCacheInfo paramAudioCacheInfo)
  {
    Object localObject2 = null;
    AppMethodBeat.i(109544);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("play audio ");
    Object localObject1;
    int i;
    if (paramAudioCacheInfo != null)
    {
      localObject1 = Integer.valueOf(paramAudioCacheInfo.swp);
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      localObject1 = localObject2;
      if (paramAudioCacheInfo != null) {
        localObject1 = paramAudioCacheInfo.musicUrl;
      }
      ab.i(str, (String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDi().fZ("");
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDi().bP(0L);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDi().bQ(0L);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDm().da(0L);
      pauseAudio();
      this.sAC = paramAudioCacheInfo;
      if (paramAudioCacheInfo != null)
      {
        localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDi().fZ(String.valueOf(paramAudioCacheInfo.swp));
        localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
        localObject1 = com.tencent.mm.plugin.story.g.i.cDi();
        i = paramAudioCacheInfo.cpt;
        localObject2 = AudioCacheInfo.swC;
        if (i != AudioCacheInfo.cBz()) {
          break label472;
        }
      }
    }
    label472:
    for (long l = 0L;; l = paramAudioCacheInfo.position + 1)
    {
      ((as)localObject1).bP(l);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDi().bQ(paramAudioCacheInfo.swu);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDm().da(1L);
      localObject1 = com.tencent.mm.plugin.story.model.audio.c.swQ;
      localObject1 = com.tencent.mm.plugin.story.model.audio.c.cBC();
      if (localObject1 != null)
      {
        i = paramAudioCacheInfo.swp;
        int j = paramAudioCacheInfo.type;
        ((com.tencent.mm.plugin.story.model.audio.c)localObject1).swI = i;
        ((com.tencent.mm.plugin.story.model.audio.c)localObject1).swJ = System.currentTimeMillis();
        ((com.tencent.mm.plugin.story.model.audio.c)localObject1).swK = true;
        ((com.tencent.mm.plugin.story.model.audio.c)localObject1).cCv = false;
        ((com.tencent.mm.plugin.story.model.audio.c)localObject1).cpt = j;
      }
      localObject2 = new com.google.android.exoplayer2.g.c((com.google.android.exoplayer2.g.f.a)new a.a((com.google.android.exoplayer2.h.d)new com.google.android.exoplayer2.h.l()));
      localObject1 = x.i(this.context, this.context.getString(2131297005));
      this.qdF = com.google.android.exoplayer2.g.a(this.context, (com.google.android.exoplayer2.g.h)localObject2);
      localObject2 = com.tencent.mm.plugin.story.model.audio.i.swW;
      a.f.b.j.p(localObject1, "userAgent");
      paramAudioCacheInfo = i.a.a(paramAudioCacheInfo, (String)localObject1);
      localObject1 = this.qdF;
      if (localObject1 != null) {
        ((v)localObject1).aC(true);
      }
      localObject1 = this.qdF;
      if (localObject1 != null) {
        ((v)localObject1).a(paramAudioCacheInfo);
      }
      paramAudioCacheInfo = this.qdF;
      if (paramAudioCacheInfo != null) {
        paramAudioCacheInfo.setRepeatMode(2);
      }
      if (this.qdF != null)
      {
        paramAudioCacheInfo = this.sAF;
        localObject1 = this.qdF;
        if (localObject1 == null) {
          a.f.b.j.ebi();
        }
        paramAudioCacheInfo.setMusicPlayer((v)localObject1);
      }
      AppMethodBeat.o(109544);
      return;
      localObject1 = null;
      break;
    }
  }
  
  final ArrayList<com.tencent.mm.media.editor.a.b> cgr()
  {
    AppMethodBeat.i(109549);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.sAF.getItemContainer().getAllItemViews()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.media.editor.a.b localb = ((com.tencent.mm.media.editor.a.h)localIterator.next()).UH();
      if (localb != null) {
        localArrayList.add(localb);
      }
    }
    AppMethodBeat.o(109549);
    return localArrayList;
  }
  
  public final void czM()
  {
    long l2 = 1L;
    AppMethodBeat.i(109546);
    Object localObject1 = ((Iterable)this.sAF.getItemContainer().getAllItemViews()).iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.media.editor.a.h)((Iterator)localObject1).next();
      if ((localObject2 instanceof com.tencent.mm.plugin.story.ui.view.editor.item.b))
      {
        i += 1;
      }
      else if ((localObject2 instanceof com.tencent.mm.plugin.story.ui.view.editor.item.g))
      {
        j += 1;
      }
      else if ((localObject2 instanceof f))
      {
        com.tencent.mm.plugin.story.g.i locali = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDi().ga(((f)localObject2).getReportPositionString().toString());
        locali = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDi().gb(String.valueOf(((f)localObject2).getLatitude()));
        locali = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDi().gc(String.valueOf(((f)localObject2).getLongitude()));
        localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDm().FW();
      }
      else if ((localObject2 instanceof com.tencent.mm.plugin.story.ui.view.editor.item.d))
      {
        localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDi().Ft();
      }
      else if ((localObject2 instanceof com.tencent.mm.plugin.story.ui.view.editor.item.h))
      {
        localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDi().Fu();
        localObject2 = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDm().FY();
      }
    }
    localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDi().bN(i);
    localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDi().bO(j);
    localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
    localObject1 = com.tencent.mm.plugin.story.g.i.cDi();
    if (this.sAA)
    {
      l1 = 1L;
      ((as)localObject1).bT(l1);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      localObject1 = com.tencent.mm.plugin.story.g.i.cDi();
      localObject2 = this.sAC;
      if (localObject2 == null) {
        break label413;
      }
      int k = ((AudioCacheInfo)localObject2).cpt;
      localObject2 = AudioCacheInfo.swC;
      if (k != AudioCacheInfo.cBz()) {
        break label413;
      }
      l1 = 1L;
      label335:
      ((as)localObject1).bS(l1);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      localObject1 = com.tencent.mm.plugin.story.g.i.cDm();
      if (!this.sAA) {
        break label419;
      }
    }
    label413:
    label419:
    for (long l1 = l2;; l1 = 0L)
    {
      ((bc)localObject1).dc(l1);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDm().cY(i);
      localObject1 = com.tencent.mm.plugin.story.g.i.sFa;
      com.tencent.mm.plugin.story.g.i.cDm().cZ(j);
      AppMethodBeat.o(109546);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label335;
    }
  }
  
  public final void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(109543);
    this.qaU = paramBoolean;
    this.sAF.getVideoPlayView().setMute(this.qaU);
    AppMethodBeat.o(109543);
  }
  
  public final void lR(boolean paramBoolean)
  {
    this.sAA = paramBoolean;
  }
  
  public final void lS(boolean paramBoolean)
  {
    this.sAB = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(109541);
    ab.b(this.TAG, "pause", new Object[0]);
    this.sAF.getItemContainer().pause();
    this.sAF.getVideoPlayView().pause();
    this.sAF.onPause();
    v localv = this.qdF;
    if (localv != null)
    {
      localv.aC(false);
      AppMethodBeat.o(109541);
      return;
    }
    AppMethodBeat.o(109541);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(109545);
    Object localObject = this.qdF;
    if ((localObject == null) || (((v)localObject).mJ() != 4))
    {
      localObject = com.tencent.mm.plugin.story.model.audio.c.swQ;
      localObject = com.tencent.mm.plugin.story.model.audio.c.cBC();
      if (localObject != null) {
        ((com.tencent.mm.plugin.story.model.audio.c)localObject).cBA();
      }
      localObject = this.qdF;
      if (localObject != null) {
        ((v)localObject).stop();
      }
      localObject = this.qdF;
      if (localObject != null) {
        ((v)localObject).release();
      }
      this.qdF = null;
      this.sAC = null;
    }
    AppMethodBeat.o(109545);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(109552);
    this.qaU = false;
    this.sAA = true;
    this.sAF.reset();
    this.sAF.getVideoPlayView().setMute(this.qaU);
    this.sAF.getVideoPlayView().stop();
    pauseAudio();
    this.sAC = null;
    this.syP.reset();
    StoryAudioManagerProxy.a locala = StoryAudioManagerProxy.sCO;
    StoryAudioManagerProxy.access$getInstance$cp().cancelAll();
    AppMethodBeat.o(109552);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(109542);
    ab.b(this.TAG, "resume", new Object[0]);
    this.sAF.getItemContainer().resume();
    this.sAF.getVideoPlayView().start();
    this.sAF.onResume();
    v localv = this.qdF;
    if (localv != null)
    {
      localv.aC(true);
      AppMethodBeat.o(109542);
      return;
    }
    AppMethodBeat.o(109542);
  }
  
  public final boolean zY()
  {
    AppMethodBeat.i(109551);
    if (this.sAF.Pk())
    {
      czM();
      if (this.sAF.czN())
      {
        AppMethodBeat.o(109551);
        return true;
      }
      Object localObject = com.tencent.mm.plugin.story.model.audio.c.swQ;
      localObject = com.tencent.mm.plugin.story.model.audio.c.cBC();
      bsp localbsp;
      if ((localObject != null) && (((com.tencent.mm.plugin.story.model.audio.c)localObject).pKF != 0L))
      {
        localbsp = new bsp();
        localbsp.xGe = ((com.tencent.mm.plugin.story.model.audio.c)localObject).swI;
        if (!((com.tencent.mm.plugin.story.model.audio.c)localObject).swK) {
          break label188;
        }
        i = ((com.tencent.mm.plugin.story.model.audio.c)localObject).cpt;
        locala = AudioCacheInfo.swC;
        if (i != AudioCacheInfo.cBz()) {
          break label183;
        }
      }
      label183:
      for (int i = 11;; i = 5)
      {
        localbsp.xGf = i;
        localbsp.xGh = ((int)bo.aox());
        ((com.tencent.mm.plugin.story.model.audio.c)localObject).cBA();
        ((com.tencent.mm.plugin.story.model.audio.c)localObject).swL.add(localbsp);
        ab.i(com.tencent.mm.plugin.story.model.audio.c.TAG, "record cancel " + com.tencent.mm.plugin.story.model.audio.d.a(localbsp));
        ((com.tencent.mm.plugin.story.model.audio.c)localObject).cBB();
        reset();
        this.sAE.boQ();
        AppMethodBeat.o(109551);
        return true;
      }
      label188:
      i = ((com.tencent.mm.plugin.story.model.audio.c)localObject).cpt;
      AudioCacheInfo.a locala = AudioCacheInfo.swC;
      if (i == AudioCacheInfo.cBz()) {}
      for (i = 13;; i = 7)
      {
        localbsp.xGf = i;
        break;
      }
    }
    AppMethodBeat.o(109551);
    return false;
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$StoryProgressDialog;", "", "()V", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mCancel", "Lkotlin/Function0;", "", "dismiss", "setCancelable", "enable", "", "setOnCancel", "onCancel", "show", "context", "Landroid/content/Context;", "cancelAble", "tip", "", "cancel", "plugin-story_release"})
  public static final class a
  {
    p lxi;
    a.f.a.a<y> sAG;
    
    public a()
    {
      AppMethodBeat.i(109523);
      this.sAG = ((a.f.a.a)b.a.a.sAH);
      AppMethodBeat.o(109523);
    }
    
    public final void a(Context paramContext, boolean paramBoolean, int paramInt, a.f.a.a<y> parama)
    {
      AppMethodBeat.i(151083);
      a.f.b.j.q(paramContext, "context");
      a.f.b.j.q(parama, "cancel");
      this.sAG = parama;
      if (this.lxi == null) {
        this.lxi = p.b(paramContext, (CharSequence)paramContext.getString(paramInt), paramBoolean, (DialogInterface.OnCancelListener)new b.a.c(this));
      }
      AppMethodBeat.o(151083);
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(109522);
      p localp = this.lxi;
      if (localp != null) {
        localp.dismiss();
      }
      this.lxi = null;
      AppMethodBeat.o(109522);
    }
    
    @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
    static final class b
      extends a.f.b.k
      implements a.f.a.a<y>
    {
      public static final b sAI;
      
      static
      {
        AppMethodBeat.i(109519);
        sAI = new b();
        AppMethodBeat.o(109519);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/presenter/EditorPresenter$checkAudioCache$1$1"})
  static final class b
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    b(b paramb, AudioCacheInfo paramAudioCacheInfo)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/presenter/EditorPresenter$showLoading$1", "Ljava/lang/Runnable;", "run", "", "plugin-story_release"})
  public static final class j
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(109539);
      b localb = this.sAK;
      b.a locala = new b.a();
      b.a.a(locala, this.sAK.context, false, 0, (a.f.a.a)b.j.a.sBe, 4);
      localb.qdb = locala;
      AppMethodBeat.o(109539);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b
 * JD-Core Version:    0.7.0.1
 */