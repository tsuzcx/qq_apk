package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.am;
import com.tencent.mm.plugin.vlog.ui.manager.a.d;
import com.tencent.mm.plugin.vlog.ui.manager.a.e;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.fyd;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "previewPlayerPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogGenerateManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "videoGenerateCallback", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "getPlayerView", "Landroid/view/View;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "release", "requestVLogScript", "sid", "fid", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VLogPreviewPluginLayout
  extends BaseEditVideoPluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.a
{
  public static final VLogPreviewPluginLayout.a UgT;
  private q<? super Boolean, ? super Integer, ? super com.tencent.mm.plugin.vlog.ui.manager.a.b, kotlin.ah> UgU;
  private com.tencent.mm.plugin.vlog.ui.plugin.ae UgV;
  private com.tencent.mm.plugin.vlog.ui.manager.a UgW;
  private final com.tencent.mm.plugin.vlog.model.ae UgX;
  
  static
  {
    AppMethodBeat.i(111121);
    UgT = new VLogPreviewPluginLayout.a((byte)0);
    AppMethodBeat.o(111121);
  }
  
  public VLogPreviewPluginLayout(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111120);
    this.UgU = ((q)new d(this, paramContext));
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.Uhq;
    this.UgX = com.tencent.mm.plugin.vlog.ui.manager.c.hSA();
    Log.i("MicroMsg.VLogPreviewPluginLayout", "VLogPreviewPluginLayout invoke init");
    AppMethodBeat.o(111120);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(111115);
    Log.i("MicroMsg.VLogPreviewPluginLayout", kotlin.g.b.s.X("loadCurrentPage model:", paramb));
    super.a(paramb);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, a.c.NPq);
    AppMethodBeat.o(111115);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    AppMethodBeat.i(111114);
    kotlin.g.b.s.u(parama, "navigator");
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    getCropVideoPlugin().setVisibility(8);
    com.tencent.mm.plugin.recordvideo.plugin.h localh = getEditFinishPlugin();
    parama = paramRecordConfigProvider.NHR;
    Object localObject1;
    label66:
    Object localObject2;
    label80:
    Object localObject3;
    if (parama == null)
    {
      parama = null;
      localObject1 = paramRecordConfigProvider.NHR;
      if (localObject1 != null) {
        break label274;
      }
      localObject1 = null;
      localObject2 = paramRecordConfigProvider.NHR;
      if (localObject2 != null) {
        break label287;
      }
      localObject2 = null;
      localObject3 = paramRecordConfigProvider.NHR;
      if (localObject3 != null) {
        break label297;
      }
      localObject3 = null;
      label94:
      localh.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = getAddMusicPlugin();
      parama = paramRecordConfigProvider.NHR;
      if (parama != null) {
        break label310;
      }
      parama = null;
      label123:
      localObject1 = paramRecordConfigProvider.NHR;
      if (localObject1 != null) {
        break label321;
      }
      localObject1 = null;
      label137:
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = getAddonTextPlugin();
      parama = paramRecordConfigProvider.NHR;
      if (parama != null) {
        break label334;
      }
      parama = null;
      label162:
      ((com.tencent.mm.plugin.recordvideo.plugin.r)localObject1).setText(parama);
      localObject2 = getAddTextPlugin();
      parama = paramRecordConfigProvider.NHR;
      if (parama != null) {
        break label342;
      }
      parama = null;
      label185:
      localObject1 = paramRecordConfigProvider.NHR;
      if (localObject1 != null) {
        break label353;
      }
      localObject1 = localObject4;
      label200:
      ((com.tencent.mm.plugin.recordvideo.plugin.e)localObject2).c(parama, (Integer)localObject1);
      getMoreMenuPlugin().setScene(paramRecordConfigProvider.scene);
      parama = getAddTipPlugin();
      paramRecordConfigProvider = paramRecordConfigProvider.NHR.lZs;
      kotlin.g.b.s.s(paramRecordConfigProvider, "configProvider.uiParam.pluginHiddenMap");
      if (!paramRecordConfigProvider.containsKey("plugin_tip")) {
        break label366;
      }
    }
    label274:
    label287:
    label297:
    label310:
    label321:
    label334:
    label342:
    label353:
    label366:
    for (int i = 8;; i = 0)
    {
      parama.NJO = i;
      AppMethodBeat.o(111114);
      return;
      parama = Integer.valueOf(parama.lZt);
      break;
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).lZu);
      break label66;
      localObject2 = ((UICustomParam)localObject2).text;
      break label80;
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).lZv);
      break label94;
      parama = Integer.valueOf(parama.lZt);
      break label123;
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).lZu);
      break label137;
      parama = parama.lZw;
      break label162;
      parama = Integer.valueOf(parama.lZt);
      break label185;
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).lZu);
      break label200;
    }
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    boolean bool = true;
    int i = 1;
    com.tencent.mm.plugin.vlog.ui.manager.a locala = null;
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(111116);
    kotlin.g.b.s.u(paramc, "status");
    Log.i("MicroMsg.VLogPreviewPluginLayout", "statusChange " + paramc + "  param:" + paramBundle);
    long l;
    int j;
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      Log.i("MicroMsg.VLogPreviewPluginLayout", kotlin.g.b.s.X("unknown key ", paramc));
      super.a(paramc, paramBundle);
      AppMethodBeat.o(111116);
      return;
    case 1: 
      getItemContainerPlugin().setVisibility(0);
      getVideoControlContainerPlugin().setVisibility(0);
      paramc = getAddMusicPlugin();
      paramBundle = getConfigProvider();
      if (!this.UgX.UaP) {}
      for (bool = true;; bool = false)
      {
        paramc.b(paramBundle, bool);
        getAddMusicPlugin().jL(this.UgX.gnn());
        AppMethodBeat.o(111116);
        return;
      }
    case 2: 
      if (paramBundle != null)
      {
        paramBundle = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
        if (paramBundle != null)
        {
          i = paramBundle.source;
          paramc = AudioCacheInfo.NIB;
          if (i == AudioCacheInfo.gHX())
          {
            Log.i("MicroMsg.VLogPreviewPluginLayout", kotlin.g.b.s.X("current script index is :", Integer.valueOf(paramBundle.position)));
            paramc = this.UgX;
            paramc.currentIndex = paramBundle.position;
            l = ((fyd)paramc.UaO.get(paramc.currentIndex)).YNt;
            paramBundle = paramc.a((fyd)paramc.UaO.get(paramc.currentIndex));
            localObject1 = ((fyd)paramc.UaO.get(paramc.currentIndex)).abVZ.aaRO;
            kotlin.g.b.s.s(localObject1, "scripts[currentIndex].music.music_url");
            localObject1 = new com.tencent.mm.plugin.vlog.model.ah(l, paramBundle, (String)localObject1, (fyd)paramc.UaO.get(paramc.currentIndex));
            paramBundle = this.UgV;
            paramc = paramBundle;
            if (paramBundle == null)
            {
              kotlin.g.b.s.bIx("previewPlayerPlugin");
              paramc = null;
            }
            kotlin.g.b.s.u(localObject1, "model");
            paramc = paramc.UjQ;
            kotlin.g.b.s.u(localObject1, "model");
            Log.i("MicroMsg.VLogPreloadPlayView", kotlin.g.b.s.X("renderScript:", localObject1));
            if (paramc.Uep == null) {
              paramc.Uhd = ((com.tencent.mm.plugin.vlog.model.ah)localObject1);
            }
            paramc = paramc.Uep;
            if (paramc != null) {
              paramc.a((com.tencent.mm.plugin.vlog.model.ah)localObject1, ((com.tencent.mm.plugin.vlog.model.ah)localObject1).getVideoDurationMs(), ((com.tencent.mm.plugin.vlog.model.ah)localObject1).UaZ);
            }
            paramc = am.Ubi;
            am.a((com.tencent.mm.plugin.vlog.model.ah)localObject1);
          }
        }
      }
      AppMethodBeat.o(111116);
      return;
    case 3: 
      if (paramBundle != null)
      {
        paramc = (AudioCacheInfo)paramBundle.getParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE");
        if (paramc != null)
        {
          j = paramc.NID;
          bool = com.tencent.mm.plugin.vlog.model.ae.hRi();
          Log.i("MicroMsg.VLogPreviewPluginLayout", kotlin.g.b.s.X("requestVLogScript prepare:", Boolean.valueOf(bool)));
          if (bool)
          {
            paramc = getContext().getString(a.i.vlog_dialog_tip);
            kotlin.g.b.s.s(paramc, "context.getString(R.string.vlog_dialog_tip)");
            aTf(paramc);
            paramc = this.UgX;
            paramc.UaN = ((kotlin.g.a.b)new c(this));
            paramc.oeO = j;
            if (j == 0) {
              paramc.UaO.clear();
            }
            paramBundle = paramc.eMf.decodeBytes("VLOG_CONF");
            if (paramBundle != null) {
              if (paramBundle.length != 0) {
                break label645;
              }
            }
            while (i != 0)
            {
              paramc = new com.tencent.mm.plugin.vlog.model.cgi.b();
              com.tencent.mm.kernel.h.aZW().a((p)paramc, 0);
              AppMethodBeat.o(111116);
              return;
              i = 0;
            }
            paramBundle = new acw().parseFrom(paramBundle);
            if (paramBundle == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ClientConfFromServer");
              AppMethodBeat.o(111116);
              throw paramc;
            }
            paramc.UaL = ((acw)paramBundle);
            paramc.lI((List)paramc.TZE);
          }
        }
      }
      AppMethodBeat.o(111116);
      return;
    case 4: 
      getAddMusicPlugin().jM(this.UgX.gnn());
      AppMethodBeat.o(111116);
      return;
    case 5: 
      label645:
      paramc = am.Ubi;
      paramc = am.Ubl;
      if (paramc != null)
      {
        am.a(null);
        paramBundle = am.Ubi;
        kotlin.g.b.s.u(paramc, "vLogScriptModel");
        paramBundle = new me();
        paramBundle.YNt = paramc.UaX;
        paramBundle.YNu = 2L;
        paramBundle.YNw = System.currentTimeMillis();
        paramBundle.hMx = paramc.hRk();
        paramBundle.oeO = paramc.hRj();
        paramBundle.YNx = paramc.hRl();
        am.Ubk.add(paramBundle);
        Log.i(am.TAG, kotlin.g.b.s.X("record select: vlogScriptModel = ", paramc));
        am.a(paramc);
      }
      Log.i(am.TAG, "record send");
      am.gIg();
      onPause();
      paramc = this.UgW;
      if (paramc != null)
      {
        Log.i("MicroMsg.VLogGenerateManager", "release");
        paramc.Uhf.release();
      }
      if (!getMoreMenuPlugin().NJY) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      CaptureDataManager.NHH.rnY.putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().dbk == 2)
      {
        CaptureDataManager.NHH.rnY.putString("key_group_list", getMoreMenuPlugin().gIy());
        paramc = this.UgX;
        if (!paramc.UaO.isEmpty()) {
          break label1052;
        }
        paramc = com.tencent.mm.plugin.vlog.model.ah.UaW;
        paramc = new com.tencent.mm.plugin.vlog.model.ah(0L, (List)new ArrayList(), "", new fyd());
        label986:
        if (paramc.UaY.isEmpty()) {
          break label1158;
        }
      }
      label1158:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1163;
        }
        Log.e("MicroMsg.VLogPreviewPluginLayout", "model is not valid");
        AppMethodBeat.o(111116);
        return;
        if (getMoreMenuPlugin().dbk != 3) {
          break;
        }
        CaptureDataManager.NHH.rnY.putString("key_black_list", getMoreMenuPlugin().gIy());
        break;
        label1052:
        l = ((fyd)paramc.UaO.get(paramc.currentIndex)).YNt;
        paramBundle = paramc.a((fyd)paramc.UaO.get(paramc.currentIndex));
        localObject2 = ((fyd)paramc.UaO.get(paramc.currentIndex)).abVZ.aaRO;
        kotlin.g.b.s.s(localObject2, "scripts[currentIndex].music.music_url");
        paramc = new com.tencent.mm.plugin.vlog.model.ah(l, paramBundle, (String)localObject2, (fyd)paramc.UaO.get(paramc.currentIndex));
        break label986;
      }
      label1163:
      paramc.A(getItemContainerPlugin().gIq());
      getItemContainerPlugin();
      paramc.NEB = j.gIr();
      paramBundle = getItemContainerPlugin().getEditorDataList();
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      paramc.NGV = paramBundle;
      paramc.bI(j.a(getItemContainerPlugin()));
      if (getContext() != null)
      {
        paramBundle = getContext();
        localObject2 = getConfigProvider();
        kotlin.g.b.s.checkNotNull(localObject2);
        this.UgW = new com.tencent.mm.plugin.vlog.ui.manager.a(paramBundle, paramc, (RecordConfigProvider)localObject2, getAddMusicPlugin().Gso.getMuteOrigin(), getAddMusicPlugin().Gss);
        paramc = getContext().getString(a.i.vlog_dialog_tip);
        kotlin.g.b.s.s(paramc, "context.getString(R.string.vlog_dialog_tip)");
        aTf(paramc);
        i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acVW, 0);
        if (i == 0)
        {
          Log.i("MicroMsg.VLogPreviewPluginLayout", kotlin.g.b.s.X("remux foreground? ", Boolean.valueOf(bool)));
          if (i != 0) {
            break label1528;
          }
          locala = this.UgW;
          if (locala == null) {
            break label1665;
          }
          paramBundle = this.UgV;
          paramc = paramBundle;
          if (paramBundle == null)
          {
            kotlin.g.b.s.bIx("previewPlayerPlugin");
            paramc = null;
          }
          i = paramc.UjQ.getWidth();
          paramc = this.UgV;
          if (paramc != null) {
            break label1490;
          }
          kotlin.g.b.s.bIx("previewPlayerPlugin");
          paramc = (a.c)localObject1;
        }
        label1490:
        for (;;)
        {
          j = paramc.UjQ.getHeight();
          paramc = this.UgU;
          kotlin.g.b.s.u(paramc, "callback");
          Log.i("MicroMsg.VLogGenerateManager", kotlin.g.b.s.X("generate path :", locala.oaV.NIe));
          locala.HJY = paramc;
          locala.Uhf.mz(i, j);
          if (!TextUtils.isEmpty((CharSequence)locala.Uhd.UaZ)) {
            break label1493;
          }
          locala.Uhf.f(locala.Uhh);
          AppMethodBeat.o(111116);
          return;
          bool = false;
          break;
        }
        label1493:
        locala.Uhe.g(locala.Uhd.UaZ, (m)new a.e(locala));
        AppMethodBeat.o(111116);
        return;
        label1528:
        localObject1 = this.UgW;
        if (localObject1 != null)
        {
          paramBundle = this.UgV;
          paramc = paramBundle;
          if (paramBundle == null)
          {
            kotlin.g.b.s.bIx("previewPlayerPlugin");
            paramc = null;
          }
          i = paramc.UjQ.getWidth();
          paramc = this.UgV;
          if (paramc != null) {
            break label1672;
          }
          kotlin.g.b.s.bIx("previewPlayerPlugin");
          paramc = locala;
        }
      }
      label1665:
      label1672:
      for (;;)
      {
        j = paramc.UjQ.getHeight();
        paramc = this.UgU;
        kotlin.g.b.s.u(paramc, "callback");
        Log.i("MicroMsg.VLogGenerateManager", kotlin.g.b.s.X("generate path :", ((com.tencent.mm.plugin.vlog.ui.manager.a)localObject1).oaV.NIe));
        ((com.tencent.mm.plugin.vlog.ui.manager.a)localObject1).HJY = paramc;
        ((com.tencent.mm.plugin.vlog.ui.manager.a)localObject1).Uhf.mz(i, j);
        com.tencent.mm.plugin.vlog.remux.e.a(((com.tencent.mm.plugin.vlog.ui.manager.a)localObject1).Uhf, (kotlin.g.a.r)new a.d((com.tencent.mm.plugin.vlog.ui.manager.a)localObject1, i, j));
        AppMethodBeat.o(111116);
        return;
      }
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.UgV;
        if (paramc != null) {
          break label1722;
        }
        kotlin.g.b.s.bIx("previewPlayerPlugin");
        paramc = (a.c)localObject2;
      }
      label1722:
      for (;;)
      {
        paramc.UjQ.setMute(bool);
        AppMethodBeat.o(111116);
        return;
      }
    }
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(111117);
    VLogPreloadPlayView localVLogPreloadPlayView = new VLogPreloadPlayView(getContext());
    this.UgV = new com.tencent.mm.plugin.vlog.ui.plugin.ae(localVLogPreloadPlayView, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    ArrayList localArrayList = getPluginList();
    com.tencent.mm.plugin.vlog.ui.plugin.ae localae = this.UgV;
    Object localObject = localae;
    if (localae == null)
    {
      kotlin.g.b.s.bIx("previewPlayerPlugin");
      localObject = null;
    }
    localArrayList.add(localObject);
    localObject = (View)localVLogPreloadPlayView;
    AppMethodBeat.o(111117);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(111118);
    Log.i("MicroMsg.VLogPreviewPluginLayout", "onBackPress");
    if (!super.onBackPress())
    {
      Object localObject = am.Ubi;
      am.a(null);
      Log.i(am.TAG, "record cancel");
      am.gIg();
      localObject = getNavigator();
      if (localObject != null) {
        ((com.tencent.mm.plugin.recordvideo.activity.a)localObject).a(0, null);
      }
    }
    AppMethodBeat.o(111118);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(111119);
    super.release();
    AppMethodBeat.o(111119);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<cct, kotlin.ah>
  {
    c(VLogPreviewPluginLayout paramVLogPreviewPluginLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errorCode", "", "model", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements q<Boolean, Integer, com.tencent.mm.plugin.vlog.ui.manager.a.b, kotlin.ah>
  {
    d(VLogPreviewPluginLayout paramVLogPreviewPluginLayout, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout
 * JD-Core Version:    0.7.0.1
 */