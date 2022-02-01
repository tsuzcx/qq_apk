package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.p;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.vlog.model.ab;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.ui.manager.a.b;
import com.tencent.mm.plugin.vlog.ui.manager.a.d;
import com.tencent.mm.plugin.vlog.ui.manager.a.e;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "previewPlayerPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogGenerateManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "videoGenerateCallback", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "getPlayerView", "Landroid/view/View;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "release", "requestVLogScript", "sid", "fid", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class VLogPreviewPluginLayout
  extends BaseEditVideoPluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final VLogPreviewPluginLayout.a Ask;
  private q<? super Boolean, ? super Integer, ? super a.b, d.y> Asg;
  private com.tencent.mm.plugin.vlog.ui.plugin.g Ash;
  private com.tencent.mm.plugin.vlog.ui.manager.a Asi;
  private final v Asj;
  
  static
  {
    AppMethodBeat.i(111121);
    Ask = new VLogPreviewPluginLayout.a((byte)0);
    AppMethodBeat.o(111121);
  }
  
  public VLogPreviewPluginLayout(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111120);
    this.Asg = ((q)new c(this, paramContext));
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.AsH;
    this.Asj = com.tencent.mm.plugin.vlog.ui.manager.c.ega();
    ac.i("MicroMsg.VLogPreviewPluginLayout", "VLogPreviewPluginLayout invoke init");
    AppMethodBeat.o(111120);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(111115);
    ac.i("MicroMsg.VLogPreviewPluginLayout", "loadCurrentPage model:".concat(String.valueOf(paramb)));
    super.a(paramb);
    d.b.a(this, d.c.wxk);
    AppMethodBeat.o(111115);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    AppMethodBeat.i(111114);
    k.h(parama, "navigator");
    k.h(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    getCropVideoPlugin().setVisibility(8);
    f localf = getEditFinishPlugin();
    parama = paramRecordConfigProvider.wqu;
    Object localObject1;
    label79:
    Object localObject2;
    label97:
    Object localObject3;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.fKz);
      localObject1 = paramRecordConfigProvider.wqu;
      if (localObject1 == null) {
        break label326;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fKA);
      localObject2 = paramRecordConfigProvider.wqu;
      if (localObject2 == null) {
        break label332;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.wqu;
      if (localObject3 == null) {
        break label338;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).fKB);
      label118:
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = getAddMusicPlugin();
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label344;
      }
      parama = Integer.valueOf(parama.fKz);
      label153:
      localObject1 = paramRecordConfigProvider.wqu;
      if (localObject1 == null) {
        break label349;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fKA);
      label174:
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = getAddonTextPlugin();
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label355;
      }
      parama = parama.fKC;
      label202:
      ((p)localObject1).setText(parama);
      localObject2 = getAddTextPlugin();
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label360;
      }
      parama = Integer.valueOf(parama.fKz);
      label231:
      localObject3 = paramRecordConfigProvider.wqu;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).fKA);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      getMoreMenuPlugin().setScene(paramRecordConfigProvider.scene);
      parama = getAddTipPlugin();
      paramRecordConfigProvider = paramRecordConfigProvider.wqu.fKy;
      k.g(paramRecordConfigProvider, "configProvider.uiParam.pluginHiddenMap");
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
      parama.wsk = i;
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
    AppMethodBeat.i(111116);
    k.h(paramc, "status");
    ac.i("MicroMsg.VLogPreviewPluginLayout", "statusChange " + paramc + "  param:" + paramBundle);
    Object localObject;
    switch (a.cfA[paramc.ordinal()])
    {
    default: 
      ac.i("MicroMsg.VLogPreviewPluginLayout", "unknown key ".concat(String.valueOf(paramc)));
      super.a(paramc, paramBundle);
      AppMethodBeat.o(111116);
      return;
    case 1: 
      getItemContainerPlugin().setVisibility(0);
      getVideoControlContainerPlugin().setVisibility(0);
      localObject = getAddMusicPlugin();
      paramc = getConfigProvider();
      if (!this.Asj.AoM)
      {
        i = 1;
        paramBundle = new com.tencent.mm.plugin.recordvideo.b.d();
        ac.i("MicroMsg.EditAddMusicPlugin", "editorConfig : ".concat(String.valueOf(paramBundle)));
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
        paramc = ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject).wvm;
        k.h(paramBundle, "config");
        paramc.b(paramBundle);
        paramc.a(paramBundle);
        paramc.wAP.setSelection(Integer.valueOf(-1));
        if (i == 0) {
          break label382;
        }
        paramc.wAJ.setVisibility(0);
      }
      for (;;)
      {
        getAddMusicPlugin().eO(this.Asj.diF());
        AppMethodBeat.o(111116);
        return;
        i = 0;
        break;
        paramc = null;
        break label199;
        if (paramc.intValue() != 2) {
          break label203;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.wpG);
        paramBundle.wpj = true;
        paramBundle.wpi = true;
        break label211;
        if (paramc.intValue() != 3) {
          break label207;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.wpF);
        paramBundle.wpi = true;
        paramBundle.wpj = true;
        break label211;
        if (paramc.intValue() != 11) {
          break label211;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.wpP);
        paramBundle.wpi = true;
        paramBundle.wpj = true;
        break label211;
        paramc.wAJ.setVisibility(8);
      }
    case 2: 
      if (paramBundle != null)
      {
        paramc = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
        if (paramc != null)
        {
          i = paramc.dbL;
          paramBundle = AudioCacheInfo.wry;
          if (i == AudioCacheInfo.dvB())
          {
            ac.i("MicroMsg.VLogPreviewPluginLayout", "current script index is :" + paramc.position);
            paramc = this.Asj.RP(paramc.position);
            paramBundle = this.Ash;
            if (paramBundle == null) {
              k.aVY("previewPlayerPlugin");
            }
            k.h(paramc, "model");
            paramBundle = paramBundle.Ats;
            k.h(paramc, "model");
            ac.i("MicroMsg.VLogPreloadPlayView", "renderScript:".concat(String.valueOf(paramc)));
            if (paramBundle.ArL == null) {
              paramBundle.Asu = paramc;
            }
            paramBundle = paramBundle.ArL;
            if (paramBundle != null) {
              paramBundle.a(paramc, paramc.getVideoDurationMs(), paramc.AoW);
            }
            paramBundle = ab.Apg;
            ab.a(paramc);
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
          i = paramc.wri;
          ac.i("MicroMsg.VLogPreviewPluginLayout", "requestVLogScript prepare:true");
          paramc = getContext().getString(2131764707);
          k.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
          aqN(paramc);
          this.Asj.a(i, (d.g.a.b)new b(this));
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
    case 4: 
      getAddMusicPlugin().eP(this.Asj.diF());
      AppMethodBeat.o(111116);
      return;
    case 5: 
      label199:
      label203:
      label207:
      label211:
      label352:
      label382:
      paramc = ab.Apg;
      label289:
      label294:
      label323:
      paramc = ab.Apf;
      if (paramc != null)
      {
        ab.a(null);
        paramBundle = ab.Apg;
        k.h(paramc, "vLogScriptModel");
        paramBundle = new kn();
        paramBundle.DXC = paramc.AoU;
        paramBundle.DXD = 2L;
        paramBundle.DXF = System.currentTimeMillis();
        paramBundle.djq = paramc.efN();
        paramBundle.yiF = paramc.efM();
        paramBundle.DXG = paramc.efO();
        ab.Ape.add(paramBundle);
        ac.i(ab.TAG, "record select: vlogScriptModel = ".concat(String.valueOf(paramc)));
        ab.a(paramc);
      }
      ac.i(ab.TAG, "record send");
      ab.dvG();
      onPause();
      paramc = this.Asi;
      if (paramc != null)
      {
        ac.i("MicroMsg.VLogGenerateManager", "release");
        paramc.Asr.release();
      }
      if (!getMoreMenuPlugin().wsv) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      paramc = CaptureDataManager.wqi;
      k.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bns == 2)
      {
        paramc = CaptureDataManager.wqi;
        k.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().dvU());
        paramc = this.Asj.efL();
        if (paramc.AoV.isEmpty()) {
          break label989;
        }
      }
      label989:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label994;
        }
        ac.e("MicroMsg.VLogPreviewPluginLayout", "model is not valid");
        AppMethodBeat.o(111116);
        return;
        if (getMoreMenuPlugin().bns != 3) {
          break;
        }
        paramc = CaptureDataManager.wqi;
        k.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().dvU());
        break;
      }
      label994:
      paramc.p(getItemContainerPlugin().dvO());
      paramBundle = getItemContainerPlugin().dvN();
      k.h(paramBundle, "<set-?>");
      paramc.AoY = paramBundle;
      paramc.aF(h.a(getItemContainerPlugin()));
      if (getContext() != null)
      {
        paramBundle = getContext();
        localObject = getConfigProvider();
        if (localObject == null) {
          k.fOy();
        }
        this.Asi = new com.tencent.mm.plugin.vlog.ui.manager.a(paramBundle, paramc, (RecordConfigProvider)localObject, getAddMusicPlugin().wvm.getMuteOrigin(), getAddMusicPlugin().wpt);
        paramc = getContext().getString(2131764707);
        k.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
        aqN(paramc);
        paramc = com.tencent.mm.kernel.g.agR();
        k.g(paramc, "MMKernel.storage()");
        i = paramc.agA().getInt(ah.a.GQE, 0);
        paramc = new StringBuilder("remux foreground? ");
        if (i == 0) {}
        int j;
        for (;;)
        {
          ac.i("MicroMsg.VLogPreviewPluginLayout", bool);
          if (i != 0) {
            break label1364;
          }
          paramc = this.Asi;
          if (paramc == null) {
            break label1357;
          }
          paramBundle = this.Ash;
          if (paramBundle == null) {
            k.aVY("previewPlayerPlugin");
          }
          i = paramBundle.Ats.getWidth();
          paramBundle = this.Ash;
          if (paramBundle == null) {
            k.aVY("previewPlayerPlugin");
          }
          j = paramBundle.Ats.getHeight();
          paramBundle = this.Asg;
          k.h(paramBundle, "callback");
          ac.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.rRi.wqG);
          paramc.sMG = paramBundle;
          paramc.Asr.ib(i, j);
          if (!TextUtils.isEmpty((CharSequence)paramc.Asu.AoW)) {
            break;
          }
          paramc.Asr.c(paramc.Ast);
          AppMethodBeat.o(111116);
          return;
          bool = false;
        }
        paramc.Asq.b(paramc.Asu.AoW, (m)new a.e(paramc));
        AppMethodBeat.o(111116);
        return;
        label1357:
        AppMethodBeat.o(111116);
        return;
        label1364:
        paramc = this.Asi;
        if (paramc != null)
        {
          paramBundle = this.Ash;
          if (paramBundle == null) {
            k.aVY("previewPlayerPlugin");
          }
          i = paramBundle.Ats.getWidth();
          paramBundle = this.Ash;
          if (paramBundle == null) {
            k.aVY("previewPlayerPlugin");
          }
          j = paramBundle.Ats.getHeight();
          paramBundle = this.Asg;
          k.h(paramBundle, "callback");
          ac.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.rRi.wqG);
          paramc.sMG = paramBundle;
          paramc.Asr.ib(i, j);
          com.tencent.mm.plugin.vlog.remux.d.a(paramc.Asr, (d.g.a.r)new a.d(paramc, i, j));
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.Ash;
        if (paramc == null) {
          k.aVY("previewPlayerPlugin");
        }
        paramc.Ats.setMute(bool);
        AppMethodBeat.o(111116);
        return;
      }
      AppMethodBeat.o(111116);
      return;
    }
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(111118);
    ac.i("MicroMsg.VLogPreviewPluginLayout", "onBackPress");
    if (!super.alO())
    {
      Object localObject = ab.Apg;
      ab.a(null);
      ac.i(ab.TAG, "record cancel");
      ab.dvG();
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
    this.Ash = new com.tencent.mm.plugin.vlog.ui.plugin.g((VLogPreloadPlayView)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    ArrayList localArrayList = getPluginList();
    com.tencent.mm.plugin.vlog.ui.plugin.g localg = this.Ash;
    if (localg == null) {
      k.aVY("previewPlayerPlugin");
    }
    localArrayList.add(localg);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<are, d.y>
  {
    b(VLogPreviewPluginLayout paramVLogPreviewPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "errorCode", "", "model", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "invoke"})
  static final class c
    extends d.g.b.l
    implements q<Boolean, Integer, a.b, d.y>
  {
    c(VLogPreviewPluginLayout paramVLogPreviewPluginLayout, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout
 * JD-Core Version:    0.7.0.1
 */