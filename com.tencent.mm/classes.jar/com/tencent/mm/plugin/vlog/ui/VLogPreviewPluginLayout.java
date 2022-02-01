package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.ui.manager.a.b;
import com.tencent.mm.plugin.vlog.ui.manager.a.d;
import com.tencent.mm.plugin.vlog.ui.manager.a.e;
import com.tencent.mm.plugin.vlog.ui.plugin.ac;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.a.m;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "previewPlayerPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogGenerateManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "videoGenerateCallback", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "getPlayerView", "Landroid/view/View;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "release", "requestVLogScript", "sid", "fid", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class VLogPreviewPluginLayout
  extends BaseEditVideoPluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final VLogPreviewPluginLayout.a BLX;
  private d.g.a.q<? super Boolean, ? super Integer, ? super a.b, z> BLT;
  private ac BLU;
  private com.tencent.mm.plugin.vlog.ui.manager.a BLV;
  private final x BLW;
  
  static
  {
    AppMethodBeat.i(111121);
    BLX = new VLogPreviewPluginLayout.a((byte)0);
    AppMethodBeat.o(111121);
  }
  
  public VLogPreviewPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111120);
    this.BLT = ((d.g.a.q)new VLogPreviewPluginLayout.c(this, paramContext));
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.BMt;
    this.BLW = com.tencent.mm.plugin.vlog.ui.manager.c.esZ();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreviewPluginLayout", "VLogPreviewPluginLayout invoke init");
    AppMethodBeat.o(111120);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(111115);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreviewPluginLayout", "loadCurrentPage model:".concat(String.valueOf(paramb)));
    super.a(paramb);
    d.b.a(this, d.c.xFt);
    AppMethodBeat.o(111115);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    AppMethodBeat.i(111114);
    d.g.b.p.h(parama, "navigator");
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    getCropVideoPlugin().setVisibility(8);
    f localf = getEditFinishPlugin();
    parama = paramRecordConfigProvider.xyk;
    Object localObject1;
    label79:
    Object localObject2;
    label97:
    Object localObject3;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.gea);
      localObject1 = paramRecordConfigProvider.xyk;
      if (localObject1 == null) {
        break label326;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).geb);
      localObject2 = paramRecordConfigProvider.xyk;
      if (localObject2 == null) {
        break label332;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.xyk;
      if (localObject3 == null) {
        break label338;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).gec);
      label118:
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = getAddMusicPlugin();
      parama = paramRecordConfigProvider.xyk;
      if (parama == null) {
        break label344;
      }
      parama = Integer.valueOf(parama.gea);
      label153:
      localObject1 = paramRecordConfigProvider.xyk;
      if (localObject1 == null) {
        break label349;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).geb);
      label174:
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = getAddonTextPlugin();
      parama = paramRecordConfigProvider.xyk;
      if (parama == null) {
        break label355;
      }
      parama = parama.ged;
      label202:
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = getAddTextPlugin();
      parama = paramRecordConfigProvider.xyk;
      if (parama == null) {
        break label360;
      }
      parama = Integer.valueOf(parama.gea);
      label231:
      localObject3 = paramRecordConfigProvider.xyk;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).geb);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      getMoreMenuPlugin().setScene(paramRecordConfigProvider.scene);
      parama = getAddTipPlugin();
      paramRecordConfigProvider = paramRecordConfigProvider.xyk.gdZ;
      d.g.b.p.g(paramRecordConfigProvider, "configProvider.uiParam.pluginHiddenMap");
      if (!paramRecordConfigProvider.containsKey("plugin_tip")) {
        break label365;
      }
    }
    label326:
    label332:
    label338:
    label344:
    label349:
    label355:
    label360:
    label365:
    for (int i = 8;; i = 0)
    {
      parama.xAd = i;
      AppMethodBeat.o(111114);
      return;
      parama = null;
      break;
      localObject1 = null;
      break label79;
      localObject2 = null;
      break label97;
      localObject3 = null;
      break label118;
      parama = null;
      break label153;
      localObject1 = null;
      break label174;
      parama = null;
      break label202;
      parama = null;
      break label231;
    }
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    boolean bool = true;
    int i = 1;
    AppMethodBeat.i(111116);
    d.g.b.p.h(paramc, "status");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreviewPluginLayout", "statusChange " + paramc + "  param:" + paramBundle);
    Object localObject;
    label199:
    label203:
    label207:
    label211:
    label352:
    label382:
    long l;
    label289:
    label294:
    label323:
    int j;
    switch (d.cpQ[paramc.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreviewPluginLayout", "unknown key ".concat(String.valueOf(paramc)));
      super.a(paramc, paramBundle);
      AppMethodBeat.o(111116);
      return;
    case 1: 
      getItemContainerPlugin().setVisibility(0);
      getVideoControlContainerPlugin().setVisibility(0);
      localObject = getAddMusicPlugin();
      paramc = getConfigProvider();
      if (!this.BLW.BGD)
      {
        i = 1;
        paramBundle = new com.tencent.mm.plugin.recordvideo.b.d();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EditAddMusicPlugin", "editorConfig : ".concat(String.valueOf(paramBundle)));
        if (paramc == null) {
          break label289;
        }
        paramc = Integer.valueOf(paramc.scene);
        if (paramc != null) {
          break label294;
        }
        if (paramc != null) {
          break label323;
        }
        if (paramc != null) {
          break label352;
        }
        ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject).setPlayMusicWhenSearchFinish(false);
        paramc = ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject).xDi;
        d.g.b.p.h(paramBundle, "config");
        paramc.b(paramBundle);
        paramc.a(paramBundle);
        paramc.xLh.setSelection(Integer.valueOf(-1));
        if (i == 0) {
          break label382;
        }
        paramc.xKt.setVisibility(0);
      }
      for (;;)
      {
        getAddMusicPlugin().fd(this.BLW.dsR());
        AppMethodBeat.o(111116);
        return;
        i = 0;
        break;
        paramc = null;
        break label199;
        if (paramc.intValue() != 2) {
          break label203;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.xxw);
        paramBundle.xwZ = true;
        paramBundle.xwY = true;
        break label211;
        if (paramc.intValue() != 3) {
          break label207;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.xxv);
        paramBundle.xwY = true;
        paramBundle.xwZ = true;
        break label211;
        if (paramc.intValue() != 11) {
          break label211;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.xxF);
        paramBundle.xwY = true;
        paramBundle.xwZ = true;
        break label211;
        paramc.xKt.setVisibility(8);
      }
    case 2: 
      if (paramBundle != null)
      {
        paramBundle = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
        if (paramBundle != null)
        {
          i = paramBundle.dnh;
          paramc = AudioCacheInfo.xzp;
          if (i == AudioCacheInfo.dFX())
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreviewPluginLayout", "current script index is :" + paramBundle.position);
            paramc = this.BLW;
            paramc.currentIndex = paramBundle.position;
            l = ((dwg)paramc.BGC.get(paramc.currentIndex)).FCY;
            paramBundle = paramc.a((dwg)paramc.BGC.get(paramc.currentIndex));
            localObject = ((dwg)paramc.BGC.get(paramc.currentIndex)).HIK.GRf;
            d.g.b.p.g(localObject, "scripts[currentIndex].music.music_url");
            paramc = new aa(l, paramBundle, (String)localObject, (dwg)paramc.BGC.get(paramc.currentIndex));
            paramBundle = this.BLU;
            if (paramBundle == null) {
              d.g.b.p.bcb("previewPlayerPlugin");
            }
            d.g.b.p.h(paramc, "model");
            paramBundle = paramBundle.BOC;
            d.g.b.p.h(paramc, "model");
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreloadPlayView", "renderScript:".concat(String.valueOf(paramc)));
            if (paramBundle.BJC == null) {
              paramBundle.BMh = paramc;
            }
            paramBundle = paramBundle.BJC;
            if (paramBundle != null) {
              paramBundle.a(paramc, paramc.getVideoDurationMs(), paramc.BGN);
            }
            paramBundle = com.tencent.mm.plugin.vlog.model.ad.BGW;
            com.tencent.mm.plugin.vlog.model.ad.a(paramc);
          }
          AppMethodBeat.o(111116);
          return;
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
          j = paramc.xyZ;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreviewPluginLayout", "requestVLogScript prepare:true");
          paramc = getContext().getString(2131764707);
          d.g.b.p.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
          avM(paramc);
          paramc = this.BLW;
          paramc.BGB = ((d.g.a.b)new VLogPreviewPluginLayout.b(this));
          paramc.zyN = j;
          if (j == 0) {
            paramc.BGC.clear();
          }
          paramBundle = paramc.cBy.decodeBytes("VLOG_CONF");
          if (paramBundle != null) {
            if (paramBundle.length != 0) {
              break label822;
            }
          }
          while (i != 0)
          {
            paramc = new com.tencent.mm.plugin.vlog.model.cgi.b();
            g.aiU().b((n)paramc);
            AppMethodBeat.o(111116);
            return;
            i = 0;
          }
          paramBundle = new yz().parseFrom(paramBundle);
          if (paramBundle == null)
          {
            paramc = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ClientConfFromServer");
            AppMethodBeat.o(111116);
            throw paramc;
          }
          paramc.BGz = ((yz)paramBundle);
          paramc.gC((List)paramc.BFr);
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
    case 4: 
      getAddMusicPlugin().fe(this.BLW.dsR());
      AppMethodBeat.o(111116);
      return;
    case 5: 
      label822:
      paramc = com.tencent.mm.plugin.vlog.model.ad.BGW;
      paramc = com.tencent.mm.plugin.vlog.model.ad.BGV;
      if (paramc != null)
      {
        com.tencent.mm.plugin.vlog.model.ad.a(null);
        paramBundle = com.tencent.mm.plugin.vlog.model.ad.BGW;
        d.g.b.p.h(paramc, "vLogScriptModel");
        paramBundle = new kw();
        paramBundle.FCY = paramc.BGL;
        paramBundle.FCZ = 2L;
        paramBundle.FDb = System.currentTimeMillis();
        paramBundle.dvd = paramc.esq();
        paramBundle.zyN = paramc.esp();
        paramBundle.FDc = paramc.esr();
        com.tencent.mm.plugin.vlog.model.ad.BGU.add(paramBundle);
        com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.vlog.model.ad.TAG, "record select: vlogScriptModel = ".concat(String.valueOf(paramc)));
        com.tencent.mm.plugin.vlog.model.ad.a(paramc);
      }
      com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.vlog.model.ad.TAG, "record send");
      com.tencent.mm.plugin.vlog.model.ad.dGe();
      onPause();
      paramc = this.BLV;
      if (paramc != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogGenerateManager", "release");
        paramc.BMe.release();
      }
      if (!getMoreMenuPlugin().xAo) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      paramc = CaptureDataManager.xxY;
      d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bxN == 2)
      {
        paramc = CaptureDataManager.xxY;
        d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().dGs());
        paramc = this.BLW;
        if (!paramc.BGC.isEmpty()) {
          break label1266;
        }
        paramc = aa.BGP;
        paramc = new aa(0L, (List)new ArrayList(), "", new dwg());
        label1191:
        if (paramc.BGM.isEmpty()) {
          break label1372;
        }
      }
      label1372:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1377;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.VLogPreviewPluginLayout", "model is not valid");
        AppMethodBeat.o(111116);
        return;
        if (getMoreMenuPlugin().bxN != 3) {
          break;
        }
        paramc = CaptureDataManager.xxY;
        d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().dGs());
        break;
        label1266:
        l = ((dwg)paramc.BGC.get(paramc.currentIndex)).FCY;
        paramBundle = paramc.a((dwg)paramc.BGC.get(paramc.currentIndex));
        localObject = ((dwg)paramc.BGC.get(paramc.currentIndex)).HIK.GRf;
        d.g.b.p.g(localObject, "scripts[currentIndex].music.music_url");
        paramc = new aa(l, paramBundle, (String)localObject, (dwg)paramc.BGC.get(paramc.currentIndex));
        break label1191;
      }
      label1377:
      paramc.p(getItemContainerPlugin().dGl());
      getItemContainerPlugin();
      paramc.xuV = h.dGm();
      paramBundle = getItemContainerPlugin().getEditorDataList();
      d.g.b.p.h(paramBundle, "<set-?>");
      paramc.xxl = paramBundle;
      paramc.aB(h.a(getItemContainerPlugin()));
      if (getContext() != null)
      {
        paramBundle = getContext();
        localObject = getConfigProvider();
        if (localObject == null) {
          d.g.b.p.gfZ();
        }
        this.BLV = new com.tencent.mm.plugin.vlog.ui.manager.a(paramBundle, paramc, (RecordConfigProvider)localObject, getAddMusicPlugin().xDi.getMuteOrigin(), getAddMusicPlugin().xxj);
        paramc = getContext().getString(2131764707);
        d.g.b.p.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
        avM(paramc);
        paramc = g.ajC();
        d.g.b.p.g(paramc, "MMKernel.storage()");
        i = paramc.ajl().getInt(al.a.IDb, 0);
        paramc = new StringBuilder("remux foreground? ");
        if (i == 0) {}
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreviewPluginLayout", bool);
          if (i != 0) {
            break label1759;
          }
          paramc = this.BLV;
          if (paramc == null) {
            break label1752;
          }
          paramBundle = this.BLU;
          if (paramBundle == null) {
            d.g.b.p.bcb("previewPlayerPlugin");
          }
          i = paramBundle.BOC.getWidth();
          paramBundle = this.BLU;
          if (paramBundle == null) {
            d.g.b.p.bcb("previewPlayerPlugin");
          }
          j = paramBundle.BOC.getHeight();
          paramBundle = this.BLT;
          d.g.b.p.h(paramBundle, "callback");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.sNI.xyx);
          paramc.tJo = paramBundle;
          paramc.BMe.iq(i, j);
          if (!TextUtils.isEmpty((CharSequence)paramc.BMh.BGN)) {
            break;
          }
          paramc.BMe.c(paramc.BMg);
          AppMethodBeat.o(111116);
          return;
          bool = false;
        }
        paramc.BMd.b(paramc.BMh.BGN, (m)new a.e(paramc));
        AppMethodBeat.o(111116);
        return;
        label1752:
        AppMethodBeat.o(111116);
        return;
        label1759:
        paramc = this.BLV;
        if (paramc != null)
        {
          paramBundle = this.BLU;
          if (paramBundle == null) {
            d.g.b.p.bcb("previewPlayerPlugin");
          }
          i = paramBundle.BOC.getWidth();
          paramBundle = this.BLU;
          if (paramBundle == null) {
            d.g.b.p.bcb("previewPlayerPlugin");
          }
          j = paramBundle.BOC.getHeight();
          paramBundle = this.BLT;
          d.g.b.p.h(paramBundle, "callback");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.sNI.xyx);
          paramc.tJo = paramBundle;
          paramc.BMe.iq(i, j);
          com.tencent.mm.plugin.vlog.remux.d.a(paramc.BMe, (d.g.a.r)new a.d(paramc, i, j));
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.BLU;
        if (paramc == null) {
          d.g.b.p.bcb("previewPlayerPlugin");
        }
        paramc.BOC.setMute(bool);
        AppMethodBeat.o(111116);
        return;
      }
      AppMethodBeat.o(111116);
      return;
    }
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(111118);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogPreviewPluginLayout", "onBackPress");
    if (!super.aoB())
    {
      Object localObject = com.tencent.mm.plugin.vlog.model.ad.BGW;
      com.tencent.mm.plugin.vlog.model.ad.a(null);
      com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.vlog.model.ad.TAG, "record cancel");
      com.tencent.mm.plugin.vlog.model.ad.dGe();
      localObject = getNavigator();
      if (localObject != null) {
        ((com.tencent.mm.plugin.recordvideo.activity.a)localObject).a(0, null);
      }
    }
    AppMethodBeat.o(111118);
    return true;
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(111117);
    Object localObject = new VLogPreloadPlayView(getContext());
    this.BLU = new ac((VLogPreloadPlayView)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    ArrayList localArrayList = getPluginList();
    ac localac = this.BLU;
    if (localac == null) {
      d.g.b.p.bcb("previewPlayerPlugin");
    }
    localArrayList.add(localac);
    localObject = (View)localObject;
    AppMethodBeat.o(111117);
    return localObject;
  }
  
  public final void release()
  {
    AppMethodBeat.i(111119);
    super.release();
    AppMethodBeat.o(111119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout
 * JD-Core Version:    0.7.0.1
 */