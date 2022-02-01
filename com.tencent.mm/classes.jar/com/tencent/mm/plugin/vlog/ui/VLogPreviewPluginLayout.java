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
import com.tencent.mm.plugin.recordvideo.plugin.p;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.vlog.model.j;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.plugin.vlog.ui.manager.b.b;
import com.tencent.mm.plugin.vlog.ui.manager.b.d;
import com.tencent.mm.plugin.vlog.ui.manager.b.e;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "previewPlayerPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogGenerateManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "videoGenerateCallback", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "getPlayerView", "Landroid/view/View;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "release", "requestVLogScript", "sid", "fid", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class VLogPreviewPluginLayout
  extends BaseEditVideoPluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final a zbV;
  private final z Ltl;
  private q<? super Boolean, ? super Integer, ? super b.b, y> zbR;
  private com.tencent.mm.plugin.vlog.ui.plugin.a zbS;
  private com.tencent.mm.plugin.vlog.ui.manager.b zbT;
  
  static
  {
    AppMethodBeat.i(111121);
    zbV = new a((byte)0);
    AppMethodBeat.o(111121);
  }
  
  public VLogPreviewPluginLayout(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111120);
    this.zbR = ((q)new c(this, paramContext));
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.d.zcE;
    this.Ltl = com.tencent.mm.plugin.vlog.ui.manager.d.fZa();
    ad.i("MicroMsg.VLogPreviewPluginLayout", "VLogPreviewPluginLayout invoke init");
    AppMethodBeat.o(111120);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(111115);
    ad.i("MicroMsg.VLogPreviewPluginLayout", "loadCurrentPage model:".concat(String.valueOf(paramb)));
    super.a(paramb);
    d.b.a(this, d.c.voD);
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
    parama = paramRecordConfigProvider.vhI;
    Object localObject1;
    label79:
    Object localObject2;
    label97:
    Object localObject3;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.fGS);
      localObject1 = paramRecordConfigProvider.vhI;
      if (localObject1 == null) {
        break label326;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fGT);
      localObject2 = paramRecordConfigProvider.vhI;
      if (localObject2 == null) {
        break label332;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.vhI;
      if (localObject3 == null) {
        break label338;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).fGU);
      label118:
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = getAddMusicPlugin();
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label344;
      }
      parama = Integer.valueOf(parama.fGS);
      label153:
      localObject1 = paramRecordConfigProvider.vhI;
      if (localObject1 == null) {
        break label349;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fGT);
      label174:
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = getAddonTextPlugin();
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label355;
      }
      parama = parama.fGV;
      label202:
      ((p)localObject1).setText(parama);
      localObject2 = getAddTextPlugin();
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label360;
      }
      parama = Integer.valueOf(parama.fGS);
      label231:
      localObject3 = paramRecordConfigProvider.vhI;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).fGT);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      getMoreMenuPlugin().setScene(paramRecordConfigProvider.scene);
      parama = getAddTipPlugin();
      paramRecordConfigProvider = paramRecordConfigProvider.vhI.fGR;
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
      parama.vjz = i;
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
    ad.i("MicroMsg.VLogPreviewPluginLayout", "statusChange " + paramc + "  param:" + paramBundle);
    Object localObject;
    switch (a.ciE[paramc.ordinal()])
    {
    default: 
      ad.i("MicroMsg.VLogPreviewPluginLayout", "unknown key ".concat(String.valueOf(paramc)));
      super.a(paramc, paramBundle);
      AppMethodBeat.o(111116);
      return;
    case 1: 
      getItemContainerPlugin().setVisibility(0);
      getVideoControlContainerPlugin().setVisibility(0);
      localObject = getAddMusicPlugin();
      paramc = getConfigProvider();
      if (!this.Ltl.LrC)
      {
        i = 1;
        paramBundle = new com.tencent.mm.plugin.recordvideo.b.d();
        ad.i("MicroMsg.EditAddMusicPlugin", "editorConfig : ".concat(String.valueOf(paramBundle)));
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
        paramc = ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject).vmE;
        k.h(paramBundle, "config");
        paramc.b(paramBundle);
        paramc.a(paramBundle);
        paramc.vqR.setSelection(Integer.valueOf(-1));
        if (i == 0) {
          break label382;
        }
        paramc.vqL.setVisibility(0);
      }
      for (;;)
      {
        getAddMusicPlugin().eJ(this.Ltl.cUZ());
        AppMethodBeat.o(111116);
        return;
        i = 0;
        break;
        paramc = null;
        break label199;
        if (paramc.intValue() != 2) {
          break label203;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.vgU);
        paramBundle.vgx = true;
        paramBundle.vgw = true;
        break label211;
        if (paramc.intValue() != 3) {
          break label207;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.vgT);
        paramBundle.vgw = true;
        paramBundle.vgx = true;
        break label211;
        if (paramc.intValue() != 11) {
          break label211;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.vhd);
        paramBundle.vgw = true;
        paramBundle.vgx = true;
        break label211;
        paramc.vqL.setVisibility(8);
      }
    case 2: 
      if (paramBundle != null)
      {
        paramc = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
        if (paramc != null)
        {
          i = paramc.dep;
          paramBundle = AudioCacheInfo.viM;
          if (i == AudioCacheInfo.dhQ())
          {
            ad.i("MicroMsg.VLogPreviewPluginLayout", "current script index is :" + paramc.position);
            paramc = this.Ltl.aif(paramc.position);
            paramBundle = this.zbS;
            if (paramBundle == null) {
              k.aPZ("previewPlayerPlugin");
            }
            k.h(paramc, "model");
            paramBundle = paramBundle.zcF;
            k.h(paramc, "model");
            ad.i("MicroMsg.VLogPreloadPlayView", "renderScript:".concat(String.valueOf(paramc)));
            if (paramBundle.Lti == null) {
              paramBundle.zcs = paramc;
            }
            paramBundle = paramBundle.Lti;
            if (paramBundle != null) {
              paramBundle.a(paramc, paramc.getVideoDurationMs(), paramc.yZt);
            }
            paramBundle = j.yZD;
            j.a(paramc);
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
          i = paramc.viz;
          ad.i("MicroMsg.VLogPreviewPluginLayout", "requestVLogScript prepare:true");
          paramc = getContext().getString(2131764707);
          k.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
          alN(paramc);
          this.Ltl.a(i, (d.g.a.b)new b(this));
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
    case 4: 
      getAddMusicPlugin().eK(this.Ltl.cUZ());
      AppMethodBeat.o(111116);
      return;
    case 5: 
      label199:
      label203:
      label207:
      label211:
      label352:
      label382:
      paramc = j.yZD;
      label289:
      label294:
      label323:
      paramc = j.yZC;
      if (paramc != null)
      {
        j.a(null);
        paramBundle = j.yZD;
        k.h(paramc, "vLogScriptModel");
        paramBundle = new kh();
        paramBundle.CFc = paramc.yZr;
        paramBundle.CFd = 2L;
        paramBundle.CFf = System.currentTimeMillis();
        paramBundle.dlI = paramc.dQV();
        paramBundle.wVR = paramc.dQU();
        paramBundle.CFg = paramc.dQW();
        j.yZB.add(paramBundle);
        ad.i(j.TAG, "record select: vlogScriptModel = ".concat(String.valueOf(paramc)));
        j.a(paramc);
      }
      ad.i(j.TAG, "record send");
      j.dhV();
      onPause();
      paramc = this.zbT;
      if (paramc != null)
      {
        ad.i("MicroMsg.VLogGenerateManager", "release");
        paramc.zcp.release();
      }
      if (!getMoreMenuPlugin().vjK) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      paramc = CaptureDataManager.vhw;
      k.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().boX == 2)
      {
        paramc = CaptureDataManager.vhw;
        k.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().dik());
        paramc = this.Ltl.fYR();
        if (paramc.yZs.isEmpty()) {
          break label989;
        }
      }
      label989:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label994;
        }
        ad.e("MicroMsg.VLogPreviewPluginLayout", "model is not valid");
        AppMethodBeat.o(111116);
        return;
        if (getMoreMenuPlugin().boX != 3) {
          break;
        }
        paramc = CaptureDataManager.vhw;
        k.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().dik());
        break;
      }
      label994:
      paramc.p(getItemContainerPlugin().die());
      paramBundle = getItemContainerPlugin().did();
      k.h(paramBundle, "<set-?>");
      paramc.yZv = paramBundle;
      paramc.at(com.tencent.mm.plugin.recordvideo.plugin.h.a(getItemContainerPlugin()));
      if (getContext() != null)
      {
        paramBundle = getContext();
        localObject = getConfigProvider();
        if (localObject == null) {
          k.fvU();
        }
        this.zbT = new com.tencent.mm.plugin.vlog.ui.manager.b(paramBundle, paramc, (RecordConfigProvider)localObject, getAddMusicPlugin().vmE.getMuteOrigin(), getAddMusicPlugin().vgH);
        paramc = getContext().getString(2131764707);
        k.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
        alN(paramc);
        paramc = com.tencent.mm.kernel.g.afB();
        k.g(paramc, "MMKernel.storage()");
        i = paramc.afk().getInt(ae.a.FsM, 0);
        paramc = new StringBuilder("remux foreground? ");
        if (i == 0) {}
        int j;
        for (;;)
        {
          ad.i("MicroMsg.VLogPreviewPluginLayout", bool);
          if (i != 0) {
            break label1364;
          }
          paramc = this.zbT;
          if (paramc == null) {
            break label1357;
          }
          paramBundle = this.zbS;
          if (paramBundle == null) {
            k.aPZ("previewPlayerPlugin");
          }
          i = paramBundle.zcF.getWidth();
          paramBundle = this.zbS;
          if (paramBundle == null) {
            k.aPZ("previewPlayerPlugin");
          }
          j = paramBundle.zcF.getHeight();
          paramBundle = this.zbR;
          k.h(paramBundle, "callback");
          ad.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.vcC.vhU);
          paramc.rDO = paramBundle;
          paramc.zcp.hN(i, j);
          if (!TextUtils.isEmpty((CharSequence)paramc.zcs.yZt)) {
            break;
          }
          paramc.zcp.b(paramc.zcr);
          AppMethodBeat.o(111116);
          return;
          bool = false;
        }
        paramc.zco.b(paramc.zcs.yZt, (m)new b.e(paramc));
        AppMethodBeat.o(111116);
        return;
        label1357:
        AppMethodBeat.o(111116);
        return;
        label1364:
        paramc = this.zbT;
        if (paramc != null)
        {
          paramBundle = this.zbS;
          if (paramBundle == null) {
            k.aPZ("previewPlayerPlugin");
          }
          i = paramBundle.zcF.getWidth();
          paramBundle = this.zbS;
          if (paramBundle == null) {
            k.aPZ("previewPlayerPlugin");
          }
          j = paramBundle.zcF.getHeight();
          paramBundle = this.zbR;
          k.h(paramBundle, "callback");
          ad.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.vcC.vhU);
          paramc.rDO = paramBundle;
          paramc.zcp.hN(i, j);
          com.tencent.mm.plugin.vlog.remux.g.a(paramc.zcp, (d.g.a.r)new b.d(paramc, i, j));
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.zbS;
        if (paramc == null) {
          k.aPZ("previewPlayerPlugin");
        }
        paramc.zcF.setMute(bool);
        AppMethodBeat.o(111116);
        return;
      }
      AppMethodBeat.o(111116);
      return;
    }
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(111118);
    ad.i("MicroMsg.VLogPreviewPluginLayout", "onBackPress");
    if (!super.dia())
    {
      Object localObject = j.yZD;
      j.a(null);
      ad.i(j.TAG, "record cancel");
      j.dhV();
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
    this.zbS = new com.tencent.mm.plugin.vlog.ui.plugin.a((VLogPreloadPlayView)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    ArrayList localArrayList = getPluginList();
    com.tencent.mm.plugin.vlog.ui.plugin.a locala = this.zbS;
    if (locala == null) {
      k.aPZ("previewPlayerPlugin");
    }
    localArrayList.add(locala);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<aoa, y>
  {
    b(VLogPreviewPluginLayout paramVLogPreviewPluginLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "errorCode", "", "model", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "invoke"})
  static final class c
    extends d.g.b.l
    implements q<Boolean, Integer, b.b, y>
  {
    c(VLogPreviewPluginLayout paramVLogPreviewPluginLayout, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout
 * JD-Core Version:    0.7.0.1
 */