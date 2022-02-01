package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.al;
import com.tencent.mm.plugin.vlog.ui.manager.a.b;
import com.tencent.mm.plugin.vlog.ui.manager.a.d;
import com.tencent.mm.plugin.vlog.ui.manager.a.e;
import com.tencent.mm.plugin.vlog.ui.plugin.ag;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "previewPlayerPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogGenerateManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "videoGenerateCallback", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "getPlayerView", "Landroid/view/View;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "release", "requestVLogScript", "sid", "fid", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class VLogPreviewPluginLayout
  extends BaseEditVideoPluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final VLogPreviewPluginLayout.a GFM;
  private kotlin.g.a.q<? super Boolean, ? super Integer, ? super a.b, x> GFI;
  private ag GFJ;
  private com.tencent.mm.plugin.vlog.ui.manager.a GFK;
  private final ae GFL;
  
  static
  {
    AppMethodBeat.i(111121);
    GFM = new VLogPreviewPluginLayout.a((byte)0);
    AppMethodBeat.o(111121);
  }
  
  public VLogPreviewPluginLayout(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111120);
    this.GFI = ((kotlin.g.a.q)new c(this, paramContext));
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.GGi;
    this.GFL = com.tencent.mm.plugin.vlog.ui.manager.c.fCM();
    Log.i("MicroMsg.VLogPreviewPluginLayout", "VLogPreviewPluginLayout invoke init");
    AppMethodBeat.o(111120);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(111115);
    Log.i("MicroMsg.VLogPreviewPluginLayout", "loadCurrentPage model:".concat(String.valueOf(paramb)));
    super.a(paramb);
    d.b.a(this, d.c.BVW);
    AppMethodBeat.o(111115);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    AppMethodBeat.i(111114);
    kotlin.g.b.p.h(parama, "navigator");
    kotlin.g.b.p.h(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    getCropVideoPlugin().setVisibility(8);
    f localf = getEditFinishPlugin();
    parama = paramRecordConfigProvider.BOn;
    Object localObject1;
    label79:
    Object localObject2;
    label97:
    Object localObject3;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.gLM);
      localObject1 = paramRecordConfigProvider.BOn;
      if (localObject1 == null) {
        break label326;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).gLN);
      localObject2 = paramRecordConfigProvider.BOn;
      if (localObject2 == null) {
        break label332;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.BOn;
      if (localObject3 == null) {
        break label338;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).gLO);
      label118:
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = getAddMusicPlugin();
      parama = paramRecordConfigProvider.BOn;
      if (parama == null) {
        break label344;
      }
      parama = Integer.valueOf(parama.gLM);
      label153:
      localObject1 = paramRecordConfigProvider.BOn;
      if (localObject1 == null) {
        break label349;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).gLN);
      label174:
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = getAddonTextPlugin();
      parama = paramRecordConfigProvider.BOn;
      if (parama == null) {
        break label355;
      }
      parama = parama.gLP;
      label202:
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = getAddTextPlugin();
      parama = paramRecordConfigProvider.BOn;
      if (parama == null) {
        break label360;
      }
      parama = Integer.valueOf(parama.gLM);
      label231:
      localObject3 = paramRecordConfigProvider.BOn;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).gLN);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      getMoreMenuPlugin().setScene(paramRecordConfigProvider.scene);
      parama = getAddTipPlugin();
      paramRecordConfigProvider = paramRecordConfigProvider.BOn.gLL;
      kotlin.g.b.p.g(paramRecordConfigProvider, "configProvider.uiParam.pluginHiddenMap");
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
      parama.BQc = i;
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
    kotlin.g.b.p.h(paramc, "status");
    Log.i("MicroMsg.VLogPreviewPluginLayout", "statusChange " + paramc + "  param:" + paramBundle);
    Object localObject;
    label199:
    label203:
    label207:
    label211:
    label356:
    long l;
    label293:
    label298:
    label327:
    int j;
    switch (e.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      Log.i("MicroMsg.VLogPreviewPluginLayout", "unknown key ".concat(String.valueOf(paramc)));
      super.a(paramc, paramBundle);
      AppMethodBeat.o(111116);
      return;
    case 1: 
      getItemContainerPlugin().setVisibility(0);
      getVideoControlContainerPlugin().setVisibility(0);
      localObject = getAddMusicPlugin();
      paramc = getConfigProvider();
      if (!this.GFL.GzH)
      {
        i = 1;
        paramBundle = new com.tencent.mm.plugin.recordvideo.b.d();
        Log.i("MicroMsg.EditAddMusicPlugin", "editorConfig : ".concat(String.valueOf(paramBundle)));
        if (paramc == null) {
          break label293;
        }
        paramc = Integer.valueOf(paramc.scene);
        if (paramc != null) {
          break label298;
        }
        if (paramc != null) {
          break label327;
        }
        if (paramc != null) {
          break label356;
        }
        ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject).setPlayMusicWhenSearchFinish(false);
        paramc = ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject).wgL;
        kotlin.g.b.p.h(paramBundle, "config");
        paramc.b(paramBundle);
        paramc.a(paramBundle);
        paramc.Cce.setSelection(Integer.valueOf(-1));
        if (i == 0) {
          break label386;
        }
        paramc.Cbk.setVisibility(0);
      }
      for (;;)
      {
        paramc.eLS();
        getAddMusicPlugin().gh(this.GFL.eua());
        AppMethodBeat.o(111116);
        return;
        i = 0;
        break;
        paramc = null;
        break label199;
        if (paramc.intValue() != 2) {
          break label203;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.BNz);
        paramBundle.BNc = true;
        paramBundle.BNb = true;
        break label211;
        if (paramc.intValue() != 3) {
          break label207;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.BNy);
        paramBundle.BNb = true;
        paramBundle.BNc = true;
        break label211;
        if (paramc.intValue() != 11) {
          break label211;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.BNI);
        paramBundle.BNb = true;
        paramBundle.BNc = true;
        break label211;
        paramc.Cbk.setVisibility(8);
      }
    case 2: 
      if (paramBundle != null)
      {
        paramBundle = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
        if (paramBundle != null)
        {
          i = paramBundle.source;
          paramc = AudioCacheInfo.BPo;
          if (i == AudioCacheInfo.eKb())
          {
            Log.i("MicroMsg.VLogPreviewPluginLayout", "current script index is :" + paramBundle.position);
            paramc = this.GFL;
            paramc.currentIndex = paramBundle.position;
            l = ((erh)paramc.GzG.get(paramc.currentIndex)).KPe;
            paramBundle = paramc.a((erh)paramc.GzG.get(paramc.currentIndex));
            localObject = ((erh)paramc.GzG.get(paramc.currentIndex)).NoU.MqU;
            kotlin.g.b.p.g(localObject, "scripts[currentIndex].music.music_url");
            paramc = new ah(l, paramBundle, (String)localObject, (erh)paramc.GzG.get(paramc.currentIndex));
            paramBundle = this.GFJ;
            if (paramBundle == null) {
              kotlin.g.b.p.btv("previewPlayerPlugin");
            }
            kotlin.g.b.p.h(paramc, "model");
            paramBundle = paramBundle.GIT;
            kotlin.g.b.p.h(paramc, "model");
            Log.i("MicroMsg.VLogPreloadPlayView", "renderScript:".concat(String.valueOf(paramc)));
            if (paramBundle.GCP == null) {
              paramBundle.GFW = paramc;
            }
            paramBundle = paramBundle.GCP;
            if (paramBundle != null) {
              paramBundle.a(paramc, paramc.getVideoDurationMs(), paramc.GzR);
            }
            paramBundle = al.GAc;
            al.a(paramc);
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
          j = paramc.BOX;
          Log.i("MicroMsg.VLogPreviewPluginLayout", "requestVLogScript prepare:true");
          paramc = getContext().getString(2131767138);
          kotlin.g.b.p.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
          aLt(paramc);
          paramc = this.GFL;
          paramc.GzF = ((kotlin.g.a.b)new b(this));
          paramc.DYl = j;
          if (j == 0) {
            paramc.GzG.clear();
          }
          paramBundle = paramc.cQe.decodeBytes("VLOG_CONF");
          if (paramBundle != null) {
            if (paramBundle.length != 0) {
              break label826;
            }
          }
          while (i != 0)
          {
            paramc = new com.tencent.mm.plugin.vlog.model.cgi.b();
            g.azz().b((com.tencent.mm.ak.q)paramc);
            AppMethodBeat.o(111116);
            return;
            i = 0;
          }
          paramBundle = new aar().parseFrom(paramBundle);
          if (paramBundle == null)
          {
            paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ClientConfFromServer");
            AppMethodBeat.o(111116);
            throw paramc;
          }
          paramc.GzD = ((aar)paramBundle);
          paramc.hN((List)paramc.Gyw);
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
    case 4: 
      getAddMusicPlugin().gi(this.GFL.eua());
      AppMethodBeat.o(111116);
      return;
    case 5: 
      label386:
      label826:
      paramc = al.GAc;
      paramc = al.GAb;
      if (paramc != null)
      {
        al.a(null);
        paramBundle = al.GAc;
        kotlin.g.b.p.h(paramc, "vLogScriptModel");
        paramBundle = new ln();
        paramBundle.KPe = paramc.GzP;
        paramBundle.KPf = 2L;
        paramBundle.KPh = System.currentTimeMillis();
        paramBundle.dNP = paramc.fBK();
        paramBundle.DYl = paramc.fBJ();
        paramBundle.KPi = paramc.fBL();
        al.GAa.add(paramBundle);
        Log.i(al.TAG, "record select: vlogScriptModel = ".concat(String.valueOf(paramc)));
        al.a(paramc);
      }
      Log.i(al.TAG, "record send");
      al.eKh();
      onPause();
      paramc = this.GFK;
      if (paramc != null)
      {
        Log.i("MicroMsg.VLogGenerateManager", "release");
        paramc.GFT.release();
      }
      if (!getMoreMenuPlugin().BQn) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      paramc = CaptureDataManager.BOb;
      kotlin.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bxP == 2)
      {
        paramc = CaptureDataManager.BOb;
        kotlin.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().eKy());
        paramc = this.GFL;
        if (!paramc.GzG.isEmpty()) {
          break label1270;
        }
        paramc = ah.GzT;
        paramc = new ah(0L, (List)new ArrayList(), "", new erh());
        label1195:
        if (paramc.GzQ.isEmpty()) {
          break label1376;
        }
      }
      label1376:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1381;
        }
        Log.e("MicroMsg.VLogPreviewPluginLayout", "model is not valid");
        AppMethodBeat.o(111116);
        return;
        if (getMoreMenuPlugin().bxP != 3) {
          break;
        }
        paramc = CaptureDataManager.BOb;
        kotlin.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().eKy());
        break;
        label1270:
        l = ((erh)paramc.GzG.get(paramc.currentIndex)).KPe;
        paramBundle = paramc.a((erh)paramc.GzG.get(paramc.currentIndex));
        localObject = ((erh)paramc.GzG.get(paramc.currentIndex)).NoU.MqU;
        kotlin.g.b.p.g(localObject, "scripts[currentIndex].music.music_url");
        paramc = new ah(l, paramBundle, (String)localObject, (erh)paramc.GzG.get(paramc.currentIndex));
        break label1195;
      }
      label1381:
      paramc.p(getItemContainerPlugin().eKr());
      getItemContainerPlugin();
      paramc.BKW = h.eKs();
      paramBundle = getItemContainerPlugin().getEditorDataList();
      kotlin.g.b.p.h(paramBundle, "<set-?>");
      paramc.BNo = paramBundle;
      paramc.aT(h.a(getItemContainerPlugin()));
      if (getContext() != null)
      {
        paramBundle = getContext();
        localObject = getConfigProvider();
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        this.GFK = new com.tencent.mm.plugin.vlog.ui.manager.a(paramBundle, paramc, (RecordConfigProvider)localObject, getAddMusicPlugin().wgL.getMuteOrigin(), getAddMusicPlugin().wgG);
        paramc = getContext().getString(2131767138);
        kotlin.g.b.p.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
        aLt(paramc);
        paramc = g.aAh();
        kotlin.g.b.p.g(paramc, "MMKernel.storage()");
        i = paramc.azQ().getInt(ar.a.OfX, 0);
        paramc = new StringBuilder("remux foreground? ");
        if (i == 0) {}
        for (;;)
        {
          Log.i("MicroMsg.VLogPreviewPluginLayout", bool);
          if (i != 0) {
            break label1763;
          }
          paramc = this.GFK;
          if (paramc == null) {
            break label1756;
          }
          paramBundle = this.GFJ;
          if (paramBundle == null) {
            kotlin.g.b.p.btv("previewPlayerPlugin");
          }
          i = paramBundle.GIT.getWidth();
          paramBundle = this.GFJ;
          if (paramBundle == null) {
            kotlin.g.b.p.btv("previewPlayerPlugin");
          }
          j = paramBundle.GIT.getHeight();
          paramBundle = this.GFI;
          kotlin.g.b.p.h(paramBundle, "callback");
          Log.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.wdm.BOA);
          paramc.xlr = paramBundle;
          paramc.GFT.jw(i, j);
          if (!TextUtils.isEmpty((CharSequence)paramc.GFW.GzR)) {
            break;
          }
          paramc.GFT.e(paramc.GFV);
          AppMethodBeat.o(111116);
          return;
          bool = false;
        }
        paramc.GFS.d(paramc.GFW.GzR, (m)new a.e(paramc));
        AppMethodBeat.o(111116);
        return;
        label1756:
        AppMethodBeat.o(111116);
        return;
        label1763:
        paramc = this.GFK;
        if (paramc != null)
        {
          paramBundle = this.GFJ;
          if (paramBundle == null) {
            kotlin.g.b.p.btv("previewPlayerPlugin");
          }
          i = paramBundle.GIT.getWidth();
          paramBundle = this.GFJ;
          if (paramBundle == null) {
            kotlin.g.b.p.btv("previewPlayerPlugin");
          }
          j = paramBundle.GIT.getHeight();
          paramBundle = this.GFI;
          kotlin.g.b.p.h(paramBundle, "callback");
          Log.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.wdm.BOA);
          paramc.xlr = paramBundle;
          paramc.GFT.jw(i, j);
          com.tencent.mm.plugin.vlog.remux.d.a(paramc.GFT, (kotlin.g.a.r)new a.d(paramc, i, j));
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.GFJ;
        if (paramc == null) {
          kotlin.g.b.p.btv("previewPlayerPlugin");
        }
        paramc.GIT.setMute(bool);
        AppMethodBeat.o(111116);
        return;
      }
      AppMethodBeat.o(111116);
      return;
    }
  }
  
  public final View getPlayerView()
  {
    AppMethodBeat.i(111117);
    Object localObject = new VLogPreloadPlayView(getContext());
    this.GFJ = new ag((VLogPreloadPlayView)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    ArrayList localArrayList = getPluginList();
    ag localag = this.GFJ;
    if (localag == null) {
      kotlin.g.b.p.btv("previewPlayerPlugin");
    }
    localArrayList.add(localag);
    localObject = (View)localObject;
    AppMethodBeat.o(111117);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(111118);
    Log.i("MicroMsg.VLogPreviewPluginLayout", "onBackPress");
    if (!super.onBackPress())
    {
      Object localObject = al.GAc;
      al.a(null);
      Log.i(al.TAG, "record cancel");
      al.eKh();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bha, x>
  {
    b(VLogPreviewPluginLayout paramVLogPreviewPluginLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errorCode", "", "model", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Boolean, Integer, a.b, x>
  {
    c(VLogPreviewPluginLayout paramVLogPreviewPluginLayout, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout
 * JD-Core Version:    0.7.0.1
 */