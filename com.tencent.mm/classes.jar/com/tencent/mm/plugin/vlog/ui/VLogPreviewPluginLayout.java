package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.b.k;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.s;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.al;
import com.tencent.mm.plugin.vlog.remux.e;
import com.tencent.mm.plugin.vlog.ui.manager.a.b;
import com.tencent.mm.plugin.vlog.ui.manager.a.d;
import com.tencent.mm.plugin.vlog.ui.manager.a.e;
import com.tencent.mm.plugin.vlog.ui.plugin.af;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "previewPlayerPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogGenerateManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "videoGenerateCallback", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "getPlayerView", "Landroid/view/View;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "release", "requestVLogScript", "sid", "fid", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class VLogPreviewPluginLayout
  extends BaseEditVideoPluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final a NtD;
  private af NtA;
  private com.tencent.mm.plugin.vlog.ui.manager.a NtB;
  private final ae NtC;
  private kotlin.g.a.q<? super Boolean, ? super Integer, ? super a.b, x> Ntz;
  
  static
  {
    AppMethodBeat.i(111121);
    NtD = new a((byte)0);
    AppMethodBeat.o(111121);
  }
  
  public VLogPreviewPluginLayout(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111120);
    this.Ntz = ((kotlin.g.a.q)new c(this, paramContext));
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.NtZ;
    this.NtC = com.tencent.mm.plugin.vlog.ui.manager.c.guL();
    Log.i("MicroMsg.VLogPreviewPluginLayout", "VLogPreviewPluginLayout invoke init");
    AppMethodBeat.o(111120);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(111115);
    Log.i("MicroMsg.VLogPreviewPluginLayout", "loadCurrentPage model:".concat(String.valueOf(paramb)));
    super.a(paramb);
    d.b.a(this, d.c.HSK);
    AppMethodBeat.o(111115);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    AppMethodBeat.i(111114);
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    getCropVideoPlugin().setVisibility(8);
    g localg = getEditFinishPlugin();
    parama = paramRecordConfigProvider.HKT;
    Object localObject1;
    label79:
    Object localObject2;
    label97:
    Object localObject3;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.jwb);
      localObject1 = paramRecordConfigProvider.HKT;
      if (localObject1 == null) {
        break label326;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).jwc);
      localObject2 = paramRecordConfigProvider.HKT;
      if (localObject2 == null) {
        break label332;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.HKT;
      if (localObject3 == null) {
        break label338;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).jwd);
      label118:
      localg.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = getAddMusicPlugin();
      parama = paramRecordConfigProvider.HKT;
      if (parama == null) {
        break label344;
      }
      parama = Integer.valueOf(parama.jwb);
      label153:
      localObject1 = paramRecordConfigProvider.HKT;
      if (localObject1 == null) {
        break label349;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).jwc);
      label174:
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = getAddonTextPlugin();
      parama = paramRecordConfigProvider.HKT;
      if (parama == null) {
        break label355;
      }
      parama = parama.jwe;
      label202:
      ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject1).setText(parama);
      localObject2 = getAddTextPlugin();
      parama = paramRecordConfigProvider.HKT;
      if (parama == null) {
        break label360;
      }
      parama = Integer.valueOf(parama.jwb);
      label231:
      localObject3 = paramRecordConfigProvider.HKT;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).jwc);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.d)localObject2).a(parama, (Integer)localObject1);
      getMoreMenuPlugin().setScene(paramRecordConfigProvider.scene);
      parama = getAddTipPlugin();
      paramRecordConfigProvider = paramRecordConfigProvider.HKT.jwa;
      p.j(paramRecordConfigProvider, "configProvider.uiParam.pluginHiddenMap");
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
      parama.HMQ = i;
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
    p.k(paramc, "status");
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
      if (!this.NtC.Nnn)
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
        paramc = ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject).AQb;
        p.k(paramBundle, "config");
        paramc.b(paramBundle);
        paramc.a(paramBundle);
        paramc.HYt.setSelection(Integer.valueOf(-1));
        if (i == 0) {
          break label386;
        }
        paramc.HYb.setVisibility(0);
      }
      for (;;)
      {
        paramc.fyn();
        getAddMusicPlugin().gL(this.NtC.fek());
        AppMethodBeat.o(111116);
        return;
        i = 0;
        break;
        paramc = null;
        break label199;
        if (paramc.intValue() != 2) {
          break label203;
        }
        paramBundle.a(k.HKi);
        paramBundle.HJH = true;
        paramBundle.HJG = true;
        break label211;
        if (paramc.intValue() != 3) {
          break label207;
        }
        paramBundle.a(k.HKh);
        paramBundle.HJG = true;
        paramBundle.HJH = true;
        break label211;
        if (paramc.intValue() != 11) {
          break label211;
        }
        paramBundle.a(k.HKr);
        paramBundle.HJG = true;
        paramBundle.HJH = true;
        break label211;
        paramc.HYb.setVisibility(8);
      }
    case 2: 
      if (paramBundle != null)
      {
        paramBundle = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
        if (paramBundle != null)
        {
          i = paramBundle.source;
          paramc = AudioCacheInfo.HMa;
          if (i == AudioCacheInfo.fwo())
          {
            Log.i("MicroMsg.VLogPreviewPluginLayout", "current script index is :" + paramBundle.position);
            paramc = this.NtC;
            paramc.currentIndex = paramBundle.position;
            l = ((fbs)paramc.Nnm.get(paramc.currentIndex)).RQc;
            paramBundle = paramc.a((fbs)paramc.Nnm.get(paramc.currentIndex));
            localObject = ((fbs)paramc.Nnm.get(paramc.currentIndex)).UBQ.TCi;
            p.j(localObject, "scripts[currentIndex].music.music_url");
            paramc = new ah(l, paramBundle, (String)localObject, (fbs)paramc.Nnm.get(paramc.currentIndex));
            paramBundle = this.NtA;
            if (paramBundle == null) {
              p.bGy("previewPlayerPlugin");
            }
            p.k(paramc, "model");
            paramBundle = paramBundle.NwI;
            p.k(paramc, "model");
            Log.i("MicroMsg.VLogPreloadPlayView", "renderScript:".concat(String.valueOf(paramc)));
            if (paramBundle.Nqz == null) {
              paramBundle.NtN = paramc;
            }
            paramBundle = paramBundle.Nqz;
            if (paramBundle != null) {
              paramBundle.a(paramc, paramc.getVideoDurationMs(), paramc.Nnx);
            }
            paramBundle = al.NnI;
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
          j = paramc.HLC;
          Log.i("MicroMsg.VLogPreviewPluginLayout", "requestVLogScript prepare:true");
          paramc = getContext().getString(a.i.vlog_dialog_tip);
          p.j(paramc, "context.getString(R.string.vlog_dialog_tip)");
          aVX(paramc);
          paramc = this.NtC;
          paramc.Nnl = ((kotlin.g.a.b)new b(this));
          paramc.KlE = j;
          if (j == 0) {
            paramc.Nnm.clear();
          }
          paramBundle = paramc.cQO.decodeBytes("VLOG_CONF");
          if (paramBundle != null) {
            if (paramBundle.length != 0) {
              break label826;
            }
          }
          while (i != 0)
          {
            paramc = new com.tencent.mm.plugin.vlog.model.cgi.b();
            h.aGY().b((com.tencent.mm.an.q)paramc);
            AppMethodBeat.o(111116);
            return;
            i = 0;
          }
          paramBundle = new aaw().parseFrom(paramBundle);
          if (paramBundle == null)
          {
            paramc = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ClientConfFromServer");
            AppMethodBeat.o(111116);
            throw paramc;
          }
          paramc.Nnj = ((aaw)paramBundle);
          paramc.iC((List)paramc.NlY);
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
    case 4: 
      getAddMusicPlugin().gM(this.NtC.fek());
      AppMethodBeat.o(111116);
      return;
    case 5: 
      label386:
      label826:
      paramc = al.NnI;
      paramc = al.NnH;
      if (paramc != null)
      {
        al.a(null);
        paramBundle = al.NnI;
        p.k(paramc, "vLogScriptModel");
        paramBundle = new ld();
        paramBundle.RQc = paramc.Nnv;
        paramBundle.RQd = 2L;
        paramBundle.RQf = System.currentTimeMillis();
        paramBundle.fHa = paramc.gtH();
        paramBundle.KlE = paramc.gtG();
        paramBundle.RQg = paramc.gtI();
        al.NnG.add(paramBundle);
        Log.i(al.TAG, "record select: vlogScriptModel = ".concat(String.valueOf(paramc)));
        al.a(paramc);
      }
      Log.i(al.TAG, "record send");
      al.fwx();
      onPause();
      paramc = this.NtB;
      if (paramc != null)
      {
        Log.i("MicroMsg.VLogGenerateManager", "release");
        paramc.NtK.release();
      }
      if (!getMoreMenuPlugin().HNb) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      paramc = CaptureDataManager.HKJ;
      p.j(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bhr == 2)
      {
        paramc = CaptureDataManager.HKJ;
        p.j(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().fwQ());
        paramc = this.NtC;
        if (!paramc.Nnm.isEmpty()) {
          break label1270;
        }
        paramc = ah.Nnz;
        paramc = new ah(0L, (List)new ArrayList(), "", new fbs());
        label1195:
        if (paramc.Nnw.isEmpty()) {
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
        if (getMoreMenuPlugin().bhr != 3) {
          break;
        }
        paramc = CaptureDataManager.HKJ;
        p.j(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().fwQ());
        break;
        label1270:
        l = ((fbs)paramc.Nnm.get(paramc.currentIndex)).RQc;
        paramBundle = paramc.a((fbs)paramc.Nnm.get(paramc.currentIndex));
        localObject = ((fbs)paramc.Nnm.get(paramc.currentIndex)).UBQ.TCi;
        p.j(localObject, "scripts[currentIndex].music.music_url");
        paramc = new ah(l, paramBundle, (String)localObject, (fbs)paramc.Nnm.get(paramc.currentIndex));
        break label1195;
      }
      label1381:
      paramc.q(getItemContainerPlugin().fwI());
      getItemContainerPlugin();
      paramc.HHh = i.fwJ();
      paramBundle = getItemContainerPlugin().getEditorDataList();
      p.k(paramBundle, "<set-?>");
      paramc.HJW = paramBundle;
      paramc.bh(i.a(getItemContainerPlugin()));
      if (getContext() != null)
      {
        paramBundle = getContext();
        localObject = getConfigProvider();
        if (localObject == null) {
          p.iCn();
        }
        this.NtB = new com.tencent.mm.plugin.vlog.ui.manager.a(paramBundle, paramc, (RecordConfigProvider)localObject, getAddMusicPlugin().AQb.getMuteOrigin(), getAddMusicPlugin().AQf);
        paramc = getContext().getString(a.i.vlog_dialog_tip);
        p.j(paramc, "context.getString(R.string.vlog_dialog_tip)");
        aVX(paramc);
        paramc = h.aHG();
        p.j(paramc, "MMKernel.storage()");
        i = paramc.aHp().getInt(ar.a.Vun, 0);
        paramc = new StringBuilder("remux foreground? ");
        if (i == 0) {}
        for (;;)
        {
          Log.i("MicroMsg.VLogPreviewPluginLayout", bool);
          if (i != 0) {
            break label1763;
          }
          paramc = this.NtB;
          if (paramc == null) {
            break label1756;
          }
          paramBundle = this.NtA;
          if (paramBundle == null) {
            p.bGy("previewPlayerPlugin");
          }
          i = paramBundle.NwI.getWidth();
          paramBundle = this.NtA;
          if (paramBundle == null) {
            p.bGy("previewPlayerPlugin");
          }
          j = paramBundle.NwI.getHeight();
          paramBundle = this.Ntz;
          p.k(paramBundle, "callback");
          Log.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.ALV.HLg);
          paramc.nmO = paramBundle;
          paramc.NtK.kJ(i, j);
          if (!TextUtils.isEmpty((CharSequence)paramc.NtN.Nnx)) {
            break;
          }
          paramc.NtK.e(paramc.NtM);
          AppMethodBeat.o(111116);
          return;
          bool = false;
        }
        paramc.NtJ.c(paramc.NtN.Nnx, (m)new a.e(paramc));
        AppMethodBeat.o(111116);
        return;
        label1756:
        AppMethodBeat.o(111116);
        return;
        label1763:
        paramc = this.NtB;
        if (paramc != null)
        {
          paramBundle = this.NtA;
          if (paramBundle == null) {
            p.bGy("previewPlayerPlugin");
          }
          i = paramBundle.NwI.getWidth();
          paramBundle = this.NtA;
          if (paramBundle == null) {
            p.bGy("previewPlayerPlugin");
          }
          j = paramBundle.NwI.getHeight();
          paramBundle = this.Ntz;
          p.k(paramBundle, "callback");
          Log.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.ALV.HLg);
          paramc.nmO = paramBundle;
          paramc.NtK.kJ(i, j);
          e.a(paramc.NtK, (r)new a.d(paramc, i, j));
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.NtA;
        if (paramc == null) {
          p.bGy("previewPlayerPlugin");
        }
        paramc.NwI.setMute(bool);
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
    this.NtA = new af((VLogPreloadPlayView)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    ArrayList localArrayList = getPluginList();
    af localaf = this.NtA;
    if (localaf == null) {
      p.bGy("previewPlayerPlugin");
    }
    localArrayList.add(localaf);
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
      Object localObject = al.NnI;
      al.a(null);
      Log.i(al.TAG, "record cancel");
      al.fwx();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<boi, x>
  {
    b(VLogPreviewPluginLayout paramVLogPreviewPluginLayout)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errorCode", "", "model", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout
 * JD-Core Version:    0.7.0.1
 */