package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pn;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.c.k;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a;
import com.tencent.mm.plugin.vlog.a.e;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.plugin.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addAudioBtn", "Landroid/widget/ImageView;", "addAudioGroup", "Landroid/view/View;", "addAudioTip", "addMusicTooltip", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;", "audioStateListeners", "", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin$AudioStateListener;", "getAudioStateListeners", "()Ljava/util/List;", "setAudioStateListeners", "(Ljava/util/List;)V", "clickAudioWhenShowTips", "", "editorConfig", "Lcom/tencent/mm/plugin/recordvideo/config/EditorConfig;", "forceEnable", "isNeedHackResume", "()Z", "setNeedHackResume", "(Z)V", "isSetMusicMute", "isSetOriginMute", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "seekable", "selectAudioDuration", "", "shouldShowSelectFinderVideoTooltip", "getShouldShowSelectFinderVideoTooltip", "addMusicList", "", "audioList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "addMusicListFromAudioCache", "index", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "appendFinderMusicInfo", "", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "filePath", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkShowAudioPanel", "getAllAudioCache", "getItemIndex", "isClickAudioWhenShowTips", "isClickFinderAudioWhenShowRedDot", "isShowAudioSearchPanel", "isShowFinderRedDot", "isShowFinderSelectPanel", "isShowFinderTips", "onBackPress", "onClick", "v", "onDetach", "onFinish", "onLyricsItemDeleted", "onPause", "onProgress", "timeMs", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOrigin", "pause", "pauseMusic", "release", "replayAudio", "reset", "resetIconColor", "iconColor", "resetStyle", "bgResId", "textColor", "text", "selectResId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;I)V", "restartAudio", "resume", "resumeMusic", "seek", "host", "", "setAudioCheckRes", "setBackground", "resId", "setLocalAudioList", "setMusicList", "setPlayMusicWhenSearchFinish", "enable", "setUpVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "isCaptureFromPic2Video", "isMediaMute", "isAllImage", "setVisibility", "visibility", "showAudioPanel", "unSelectAudio", "AudioStateListener", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener, d.c, d.d, d.e
{
  public static final a.a UeS;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.b Gsn;
  public final EditorAudioView Gso;
  private com.tencent.mm.plugin.recordvideo.c.d Gsq;
  public AudioCacheInfo Gss;
  List<Object> Gsv;
  private final ImageView NMS;
  public final ImageView NMT;
  private final View NMU;
  private boolean NMV;
  public boolean NMW;
  private final View UeT;
  private d.e UeU;
  private long UeV;
  public boolean UeW;
  public ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(281689);
    UeS = new a.a((byte)0);
    AppMethodBeat.o(281689);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(281600);
    this.parent = paramViewGroup;
    paramViewGroup = this.parent.findViewById(a.f.editor_add_audio);
    s.s(paramViewGroup, "parent.findViewById(R.id.editor_add_audio)");
    this.NMS = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(a.f.editor_add_audio_check);
    s.s(paramViewGroup, "parent.findViewById(R.id.editor_add_audio_check)");
    this.NMT = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(a.f.editor_add_audio_group);
    s.s(paramViewGroup, "parent.findViewById(R.id.editor_add_audio_group)");
    this.NMU = paramViewGroup;
    paramViewGroup = this.parent.findViewById(a.f.editor_audio_panel);
    s.s(paramViewGroup, "parent.findViewById(R.id.editor_audio_panel)");
    this.Gso = ((EditorAudioView)paramViewGroup);
    paramViewGroup = this.parent.getContext();
    s.s(paramViewGroup, "parent.context");
    this.Gsn = new com.tencent.mm.plugin.recordvideo.plugin.a.b(paramViewGroup);
    paramViewGroup = this.parent.findViewById(a.f.timeline_editor_add_music_tooltip);
    s.s(paramViewGroup, "parent.findViewById(R.id…editor_add_music_tooltip)");
    this.UeT = paramViewGroup;
    this.Gsq = new com.tencent.mm.plugin.recordvideo.c.d();
    this.NMV = true;
    this.UeV = -1L;
    this.Gsv = ((List)new ArrayList());
    this.NMV = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVh, true);
    a(Integer.valueOf(a.e.bg_story_audio_finish_btn), null, -1);
    Log.i("MicroMsg.EditAddMusicPlugin", s.X("forceEnable ", Boolean.valueOf(this.NMV)));
    this.NMT.setImageDrawable(this.parent.getContext().getResources().getDrawable(a.h.popvideo_post_selected));
    this.NMS.setImageDrawable(bb.m(this.parent.getContext(), a.h.icons_filled_sound, -1));
    this.NMS.setOnClickListener((View.OnClickListener)this);
    if (this.NMV)
    {
      this.Gso.setOnVisibleChangeCallback((kotlin.g.a.b)new u(parama) {});
      this.Gso.setCallback((EditorAudioView.a)new EditorAudioView.a()
      {
        public final void a(AudioCacheInfo paramAnonymousAudioCacheInfo)
        {
          int j = 0;
          AppMethodBeat.i(281519);
          Log.i("MicroMsg.EditAddMusicPlugin", s.X("onAudioSelected:", paramAnonymousAudioCacheInfo));
          if (s.p(jdField_this.Gss, paramAnonymousAudioCacheInfo))
          {
            if (jdField_this.Gss != null) {
              jdField_this.bLh();
            }
            AppMethodBeat.o(281519);
            return;
          }
          if (paramAnonymousAudioCacheInfo == null)
          {
            a.a(jdField_this, 0L);
            jdField_this.Gss = paramAnonymousAudioCacheInfo;
            paramAnonymousAudioCacheInfo = jdField_this;
            paramAnonymousAudioCacheInfo.NMT.setVisibility(8);
            paramAnonymousAudioCacheInfo.Gss = null;
            paramAnonymousAudioCacheInfo.bLg();
            com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.NJL, a.c.NOF);
            paramAnonymousAudioCacheInfo = new Bundle();
            paramAnonymousAudioCacheInfo.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", false);
            this.NJL.a(a.c.NOG, paramAnonymousAudioCacheInfo);
            this.NJL.a(a.c.NOb, null);
            AppMethodBeat.o(281519);
            return;
          }
          int i = paramAnonymousAudioCacheInfo.type;
          Object localObject = AudioCacheInfo.NIB;
          if (i == AudioCacheInfo.gHQ())
          {
            com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.NJL, a.c.NOB);
            AppMethodBeat.o(281519);
            return;
          }
          Log.i("MicroMsg.EditAddMusicPlugin", "play music:" + paramAnonymousAudioCacheInfo.musicUrl + " cached:" + paramAnonymousAudioCacheInfo.cached + " cachePath:" + paramAnonymousAudioCacheInfo.cachePath + "  cacheFile:" + y.ZC(paramAnonymousAudioCacheInfo.cachePath));
          if (((paramAnonymousAudioCacheInfo.cached) && (TextUtils.isEmpty((CharSequence)paramAnonymousAudioCacheInfo.cachePath))) || ((!paramAnonymousAudioCacheInfo.cached) && (TextUtils.isEmpty((CharSequence)paramAnonymousAudioCacheInfo.musicUrl))))
          {
            paramAnonymousAudioCacheInfo = new pn();
            paramAnonymousAudioCacheInfo.jmN = 2020;
            paramAnonymousAudioCacheInfo.wU("null music url");
            paramAnonymousAudioCacheInfo.bMH();
            AppMethodBeat.o(281519);
            return;
          }
          a.c(jdField_this).setVisibility(0);
          jdField_this.Gss = paramAnonymousAudioCacheInfo;
          com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.NJL, a.c.NOF);
          a.d(jdField_this).e(paramAnonymousAudioCacheInfo);
          a.a(jdField_this, paramAnonymousAudioCacheInfo.duration);
          localObject = ((Iterable)jdField_this.Gsv).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((Iterator)localObject).next();
          }
          localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MUSIC_ID_INT", Integer.valueOf(paramAnonymousAudioCacheInfo.NID));
          localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          i = paramAnonymousAudioCacheInfo.source;
          localObject = AudioCacheInfo.NIB;
          if (i == AudioCacheInfo.gHY()) {}
          for (i = 0;; i = paramAnonymousAudioCacheInfo.position + 1)
          {
            com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MUSIC_INDEX_INT", Integer.valueOf(i));
            localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
            com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MUSIC_REQ_ID_INT", Long.valueOf(paramAnonymousAudioCacheInfo.NII));
            localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
            int k = paramAnonymousAudioCacheInfo.source;
            localObject = AudioCacheInfo.NIB;
            i = j;
            if (k == AudioCacheInfo.gHY()) {
              i = 1;
            }
            com.tencent.mm.plugin.recordvideo.f.c.I("KEY_SEARCH_MUSIC_INT", Integer.valueOf(i));
            localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
            localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.gIh();
            if (localObject != null) {
              ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).kG(paramAnonymousAudioCacheInfo.NID, paramAnonymousAudioCacheInfo.source);
            }
            AppMethodBeat.o(281519);
            return;
          }
        }
        
        public final void b(AudioCacheInfo paramAnonymousAudioCacheInfo)
        {
          AppMethodBeat.i(281522);
          s.u(paramAnonymousAudioCacheInfo, "info");
          Bundle localBundle = new Bundle();
          localBundle.putParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE", (Parcelable)paramAnonymousAudioCacheInfo);
          this.NJL.a(a.c.NPr, localBundle);
          AppMethodBeat.o(281522);
        }
        
        public final void fjI()
        {
          AppMethodBeat.i(281528);
          com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.NJL, a.c.NPs);
          AppMethodBeat.o(281528);
        }
        
        public final void g(boolean paramAnonymousBoolean, List<? extends dki> paramAnonymousList)
        {
          AppMethodBeat.i(281493);
          s.u(paramAnonymousList, "lyricsInfos");
          Bundle localBundle = new Bundle();
          int i;
          if (((Collection)paramAnonymousList).isEmpty())
          {
            i = 1;
            if (i != 0) {
              break label93;
            }
            localBundle.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", paramAnonymousBoolean);
            localBundle.putParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST", (Parcelable)new LyricsInfo(paramAnonymousList));
          }
          for (;;)
          {
            this.NJL.a(a.c.NOG, localBundle);
            AppMethodBeat.o(281493);
            return;
            i = 0;
            break;
            label93:
            localBundle.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", false);
          }
        }
        
        public final void pauseAudio()
        {
          AppMethodBeat.i(281496);
          jdField_this.bLg();
          AppMethodBeat.o(281496);
        }
        
        public final void uJ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(281531);
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN", paramAnonymousBoolean);
          this.NJL.a(a.c.NOE, localBundle);
          AppMethodBeat.o(281531);
        }
      });
    }
    for (;;)
    {
      this.Gso.Bt(w.hQS());
      if (!this.Gso.getShouldShowSelectFinderVideoRedDot()) {
        break;
      }
      this.UeT.setVisibility(0);
      this.UeT.postDelayed(new a..ExternalSyntheticLambda0(this), 5000L);
      AppMethodBeat.o(281600);
      return;
      this.NMU.setVisibility(8);
    }
    this.UeT.setVisibility(8);
    AppMethodBeat.o(281600);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(281635);
    s.u(parama, "this$0");
    parama.UeT.setVisibility(8);
    AppMethodBeat.o(281635);
  }
  
  public final Object a(FinderObject paramFinderObject, String paramString, kotlin.d.d<? super String> paramd)
  {
    AppMethodBeat.i(281962);
    paramFinderObject = l.a((f)bg.kCi(), (m)new a.b(paramString, paramFinderObject, this, null), paramd);
    AppMethodBeat.o(281962);
    return paramFinderObject;
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean) {}
  
  public final void a(d.e parame)
  {
    this.UeU = parame;
  }
  
  public final void a(Integer paramInteger1, Integer paramInteger2, int paramInt)
  {
    AppMethodBeat.i(281733);
    EditorAudioView.a(this.Gso, paramInteger1, paramInteger2, null, Integer.valueOf(a.e.story_cursor_orange), null, Integer.valueOf(a.h.popvideo_post_selected_origin), null, null, null, null, null, null, null, true, 8144);
    if (paramInt != -1) {
      this.NMT.setImageDrawable(this.parent.getContext().getResources().getDrawable(paramInt));
    }
    AppMethodBeat.o(281733);
  }
  
  public final void agy(int paramInt)
  {
    AppMethodBeat.i(281933);
    this.NMS.setImageDrawable(bb.m(this.parent.getContext(), a.h.icons_filled_sound, paramInt));
    AppMethodBeat.o(281933);
  }
  
  public final void bLg()
  {
    AppMethodBeat.i(281856);
    Log.i("MicroMsg.EditAddMusicPlugin", "pauseMusic");
    this.Gsn.pauseAudio();
    Iterator localIterator = ((Iterable)this.Gsv).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(281856);
  }
  
  public final void bLh()
  {
    AppMethodBeat.i(281864);
    Log.i("MicroMsg.EditAddMusicPlugin", "resumeMusic");
    if (this.Gss == null)
    {
      AppMethodBeat.o(281864);
      return;
    }
    this.Gsn.gIX();
    Iterator localIterator = ((Iterable)this.Gsv).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(281864);
  }
  
  public final void gIV()
  {
    AppMethodBeat.i(281766);
    if ((this.Gsq.NGJ == k.NHf) && (this.Gsq.NGI)) {
      this.Gso.setShow(true);
    }
    AppMethodBeat.o(281766);
  }
  
  public final boolean hSj()
  {
    AppMethodBeat.i(281703);
    if (!this.Gso.getWithMusic())
    {
      AppMethodBeat.o(281703);
      return true;
    }
    AppMethodBeat.o(281703);
    return false;
  }
  
  public final void hSk()
  {
    AppMethodBeat.i(281714);
    this.Gsn.seekTo(0L);
    Iterator localIterator = ((Iterable)this.Gsv).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(281714);
  }
  
  public final void hSl()
  {
    AppMethodBeat.i(281755);
    this.Gso.Bu(false);
    AppMethodBeat.o(281755);
  }
  
  public final void hSm()
  {
    AppMethodBeat.i(281791);
    this.Gso.setShow(true);
    AppMethodBeat.o(281791);
  }
  
  public final boolean hSn()
  {
    AppMethodBeat.i(281975);
    if (this.UeT.getVisibility() == 0)
    {
      AppMethodBeat.o(281975);
      return true;
    }
    AppMethodBeat.o(281975);
    return false;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(281884);
    if (this.Gso.onBackPress())
    {
      AppMethodBeat.o(281884);
      return true;
    }
    this.Gso.reset();
    Object localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.gIh();
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).gIe();
    }
    AppMethodBeat.o(281884);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(281781);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.UeW = hSn();
    this.UeT.setVisibility(8);
    this.Gso.setShow(true);
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_MUSIC_COUNT_INT");
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agG(6);
    paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agH(5);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(281781);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(281833);
    super.onDetach();
    onPause();
    AppMethodBeat.o(281833);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281805);
    Log.i("MicroMsg.EditAddMusicPlugin", "pauseAudio");
    bLg();
    AppMethodBeat.o(281805);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(281893);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(281893);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281845);
    if ((!this.NMW) && (this.Gso.getWithMusic())) {
      bLh();
    }
    AppMethodBeat.o(281845);
  }
  
  public final void pause() {}
  
  public final void qU(long paramLong) {}
  
  public final void release()
  {
    AppMethodBeat.i(281821);
    reset();
    this.Gss = null;
    this.Gsn.release();
    this.Gso.destroy();
    AppMethodBeat.o(281821);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(281889);
    this.NMT.setVisibility(8);
    this.Gss = null;
    this.Gsn.gIW();
    AppMethodBeat.o(281889);
  }
  
  public final void resume() {}
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(281876);
    this.Gsn.seekTo(paramLong);
    Iterator localIterator = ((Iterable)this.Gsv).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(281876);
  }
  
  public final void setBackground(int paramInt)
  {
    AppMethodBeat.i(281725);
    this.Gso.setBackground(paramInt);
    AppMethodBeat.o(281725);
  }
  
  public final void setLocalAudioList(List<AudioCacheInfo> paramList)
  {
    AppMethodBeat.i(281741);
    s.u(paramList, "audioList");
    this.Gso.setLocalAudioList(paramList);
    AppMethodBeat.o(281741);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(281799);
    if (this.NMV) {
      this.NMU.setVisibility(paramInt);
    }
    AppMethodBeat.o(281799);
  }
  
  public final void wK(long paramLong)
  {
    AppMethodBeat.i(281942);
    seekTo(paramLong);
    AppMethodBeat.o(281942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.a
 * JD-Core Version:    0.7.0.1
 */