package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
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
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.ui.manager.a.b;
import com.tencent.mm.plugin.vlog.ui.manager.a.d;
import com.tencent.mm.plugin.vlog.ui.manager.a.e;
import com.tencent.mm.plugin.vlog.ui.plugin.ac;
import com.tencent.mm.plugin.vlog.ui.preview.VLogPreloadPlayView;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.a.m;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/VLogPreviewPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "previewPlayerPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewPlayerPlugin;", "vLogDataManager", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "vLogGenerateManager", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager;", "videoGenerateCallback", "Lkotlin/Function3;", "", "", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "", "getPlayerView", "Landroid/view/View;", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "release", "requestVLogScript", "sid", "fid", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class VLogPreviewPluginLayout
  extends BaseEditVideoPluginLayout
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.d
{
  public static final VLogPreviewPluginLayout.a Cdw;
  private d.g.a.q<? super Boolean, ? super Integer, ? super a.b, z> Cds;
  private ac Cdt;
  private com.tencent.mm.plugin.vlog.ui.manager.a Cdu;
  private final x Cdv;
  
  static
  {
    AppMethodBeat.i(111121);
    Cdw = new VLogPreviewPluginLayout.a((byte)0);
    AppMethodBeat.o(111121);
  }
  
  public VLogPreviewPluginLayout(final Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111120);
    this.Cds = ((d.g.a.q)new c(this, paramContext));
    paramContext = com.tencent.mm.plugin.vlog.ui.manager.c.CdS;
    this.Cdv = com.tencent.mm.plugin.vlog.ui.manager.c.ewG();
    ae.i("MicroMsg.VLogPreviewPluginLayout", "VLogPreviewPluginLayout invoke init");
    AppMethodBeat.o(111120);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(111115);
    ae.i("MicroMsg.VLogPreviewPluginLayout", "loadCurrentPage model:".concat(String.valueOf(paramb)));
    super.a(paramb);
    d.b.a(this, d.c.xVo);
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
    parama = paramRecordConfigProvider.xOh;
    Object localObject1;
    label79:
    Object localObject2;
    label97:
    Object localObject3;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.ggi);
      localObject1 = paramRecordConfigProvider.xOh;
      if (localObject1 == null) {
        break label326;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).ggj);
      localObject2 = paramRecordConfigProvider.xOh;
      if (localObject2 == null) {
        break label332;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.xOh;
      if (localObject3 == null) {
        break label338;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).ggk);
      label118:
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = getAddMusicPlugin();
      parama = paramRecordConfigProvider.xOh;
      if (parama == null) {
        break label344;
      }
      parama = Integer.valueOf(parama.ggi);
      label153:
      localObject1 = paramRecordConfigProvider.xOh;
      if (localObject1 == null) {
        break label349;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).ggj);
      label174:
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = getAddonTextPlugin();
      parama = paramRecordConfigProvider.xOh;
      if (parama == null) {
        break label355;
      }
      parama = parama.ggl;
      label202:
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = getAddTextPlugin();
      parama = paramRecordConfigProvider.xOh;
      if (parama == null) {
        break label360;
      }
      parama = Integer.valueOf(parama.ggi);
      label231:
      localObject3 = paramRecordConfigProvider.xOh;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).ggj);
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      getMoreMenuPlugin().setScene(paramRecordConfigProvider.scene);
      parama = getAddTipPlugin();
      paramRecordConfigProvider = paramRecordConfigProvider.xOh.ggh;
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
      parama.xPZ = i;
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
    ae.i("MicroMsg.VLogPreviewPluginLayout", "statusChange " + paramc + "  param:" + paramBundle);
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
    switch (d.cqt[paramc.ordinal()])
    {
    default: 
      ae.i("MicroMsg.VLogPreviewPluginLayout", "unknown key ".concat(String.valueOf(paramc)));
      super.a(paramc, paramBundle);
      AppMethodBeat.o(111116);
      return;
    case 1: 
      getItemContainerPlugin().setVisibility(0);
      getVideoControlContainerPlugin().setVisibility(0);
      localObject = getAddMusicPlugin();
      paramc = getConfigProvider();
      if (!this.Cdv.BYc)
      {
        i = 1;
        paramBundle = new com.tencent.mm.plugin.recordvideo.b.d();
        ae.i("MicroMsg.EditAddMusicPlugin", "editorConfig : ".concat(String.valueOf(paramBundle)));
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
        paramc = ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject).xTd;
        d.g.b.p.h(paramBundle, "config");
        paramc.b(paramBundle);
        paramc.a(paramBundle);
        paramc.ybc.setSelection(Integer.valueOf(-1));
        if (i == 0) {
          break label382;
        }
        paramc.yao.setVisibility(0);
      }
      for (;;)
      {
        getAddMusicPlugin().fl(this.Cdv.dwg());
        AppMethodBeat.o(111116);
        return;
        i = 0;
        break;
        paramc = null;
        break label199;
        if (paramc.intValue() != 2) {
          break label203;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.xNt);
        paramBundle.xMW = true;
        paramBundle.xMV = true;
        break label211;
        if (paramc.intValue() != 3) {
          break label207;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.xNs);
        paramBundle.xMV = true;
        paramBundle.xMW = true;
        break label211;
        if (paramc.intValue() != 11) {
          break label211;
        }
        paramBundle.a(com.tencent.mm.plugin.recordvideo.b.i.xNC);
        paramBundle.xMV = true;
        paramBundle.xMW = true;
        break label211;
        paramc.yao.setVisibility(8);
      }
    case 2: 
      if (paramBundle != null)
      {
        paramBundle = (AudioCacheInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_PARCELABLE");
        if (paramBundle != null)
        {
          i = paramBundle.doj;
          paramc = AudioCacheInfo.xPl;
          if (i == AudioCacheInfo.dJo())
          {
            ae.i("MicroMsg.VLogPreviewPluginLayout", "current script index is :" + paramBundle.position);
            paramc = this.Cdv;
            paramc.currentIndex = paramBundle.position;
            l = ((dxb)paramc.BYb.get(paramc.currentIndex)).FVt;
            paramBundle = paramc.a((dxb)paramc.BYb.get(paramc.currentIndex));
            localObject = ((dxb)paramc.BYb.get(paramc.currentIndex)).Icw.HkG;
            d.g.b.p.g(localObject, "scripts[currentIndex].music.music_url");
            paramc = new aa(l, paramBundle, (String)localObject, (dxb)paramc.BYb.get(paramc.currentIndex));
            paramBundle = this.Cdt;
            if (paramBundle == null) {
              d.g.b.p.bdF("previewPlayerPlugin");
            }
            d.g.b.p.h(paramc, "model");
            paramBundle = paramBundle.Cgb;
            d.g.b.p.h(paramc, "model");
            ae.i("MicroMsg.VLogPreloadPlayView", "renderScript:".concat(String.valueOf(paramc)));
            if (paramBundle.Cbb == null) {
              paramBundle.CdG = paramc;
            }
            paramBundle = paramBundle.Cbb;
            if (paramBundle != null) {
              paramBundle.a(paramc, paramc.getVideoDurationMs(), paramc.BYm);
            }
            paramBundle = ad.BYv;
            ad.a(paramc);
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
          j = paramc.xOV;
          ae.i("MicroMsg.VLogPreviewPluginLayout", "requestVLogScript prepare:true");
          paramc = getContext().getString(2131764707);
          d.g.b.p.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
          axb(paramc);
          paramc = this.Cdv;
          paramc.BYa = ((d.g.a.b)new b(this));
          paramc.zQm = j;
          if (j == 0) {
            paramc.BYb.clear();
          }
          paramBundle = paramc.cCf.decodeBytes("VLOG_CONF");
          if (paramBundle != null) {
            if (paramBundle.length != 0) {
              break label822;
            }
          }
          while (i != 0)
          {
            paramc = new com.tencent.mm.plugin.vlog.model.cgi.b();
            g.ajj().b((n)paramc);
            AppMethodBeat.o(111116);
            return;
            i = 0;
          }
          paramBundle = new zc().parseFrom(paramBundle);
          if (paramBundle == null)
          {
            paramc = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ClientConfFromServer");
            AppMethodBeat.o(111116);
            throw paramc;
          }
          paramc.BXY = ((zc)paramBundle);
          paramc.gL((List)paramc.BWP);
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
    case 4: 
      getAddMusicPlugin().fm(this.Cdv.dwg());
      AppMethodBeat.o(111116);
      return;
    case 5: 
      label822:
      paramc = ad.BYv;
      paramc = ad.BYu;
      if (paramc != null)
      {
        ad.a(null);
        paramBundle = ad.BYv;
        d.g.b.p.h(paramc, "vLogScriptModel");
        paramBundle = new kw();
        paramBundle.FVt = paramc.BYk;
        paramBundle.FVu = 2L;
        paramBundle.FVw = System.currentTimeMillis();
        paramBundle.dwi = paramc.evX();
        paramBundle.zQm = paramc.evW();
        paramBundle.FVx = paramc.evY();
        ad.BYt.add(paramBundle);
        ae.i(ad.TAG, "record select: vlogScriptModel = ".concat(String.valueOf(paramc)));
        ad.a(paramc);
      }
      ae.i(ad.TAG, "record send");
      ad.dJv();
      onPause();
      paramc = this.Cdu;
      if (paramc != null)
      {
        ae.i("MicroMsg.VLogGenerateManager", "release");
        paramc.CdD.release();
      }
      if (!getMoreMenuPlugin().xQk) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      paramc = CaptureDataManager.xNV;
      d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
      paramc.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().bxN == 2)
      {
        paramc = CaptureDataManager.xNV;
        d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_group_list", getMoreMenuPlugin().dJJ());
        paramc = this.Cdv;
        if (!paramc.BYb.isEmpty()) {
          break label1266;
        }
        paramc = aa.BYo;
        paramc = new aa(0L, (List)new ArrayList(), "", new dxb());
        label1191:
        if (paramc.BYl.isEmpty()) {
          break label1372;
        }
      }
      label1372:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1377;
        }
        ae.e("MicroMsg.VLogPreviewPluginLayout", "model is not valid");
        AppMethodBeat.o(111116);
        return;
        if (getMoreMenuPlugin().bxN != 3) {
          break;
        }
        paramc = CaptureDataManager.xNV;
        d.g.b.p.g(paramc, "CaptureDataManager.INSTANCE");
        paramc.getExtData().putString("key_black_list", getMoreMenuPlugin().dJJ());
        break;
        label1266:
        l = ((dxb)paramc.BYb.get(paramc.currentIndex)).FVt;
        paramBundle = paramc.a((dxb)paramc.BYb.get(paramc.currentIndex));
        localObject = ((dxb)paramc.BYb.get(paramc.currentIndex)).Icw.HkG;
        d.g.b.p.g(localObject, "scripts[currentIndex].music.music_url");
        paramc = new aa(l, paramBundle, (String)localObject, (dxb)paramc.BYb.get(paramc.currentIndex));
        break label1191;
      }
      label1377:
      paramc.p(getItemContainerPlugin().dJC());
      getItemContainerPlugin();
      paramc.xKS = h.dJD();
      paramBundle = getItemContainerPlugin().getEditorDataList();
      d.g.b.p.h(paramBundle, "<set-?>");
      paramc.xNi = paramBundle;
      paramc.aC(h.a(getItemContainerPlugin()));
      if (getContext() != null)
      {
        paramBundle = getContext();
        localObject = getConfigProvider();
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        this.Cdu = new com.tencent.mm.plugin.vlog.ui.manager.a(paramBundle, paramc, (RecordConfigProvider)localObject, getAddMusicPlugin().xTd.getMuteOrigin(), getAddMusicPlugin().xNg);
        paramc = getContext().getString(2131764707);
        d.g.b.p.g(paramc, "context.getString(R.string.vlog_dialog_tip)");
        axb(paramc);
        paramc = g.ajR();
        d.g.b.p.g(paramc, "MMKernel.storage()");
        i = paramc.ajA().getInt(am.a.IXB, 0);
        paramc = new StringBuilder("remux foreground? ");
        if (i == 0) {}
        for (;;)
        {
          ae.i("MicroMsg.VLogPreviewPluginLayout", bool);
          if (i != 0) {
            break label1759;
          }
          paramc = this.Cdu;
          if (paramc == null) {
            break label1752;
          }
          paramBundle = this.Cdt;
          if (paramBundle == null) {
            d.g.b.p.bdF("previewPlayerPlugin");
          }
          i = paramBundle.Cgb.getWidth();
          paramBundle = this.Cdt;
          if (paramBundle == null) {
            d.g.b.p.bdF("previewPlayerPlugin");
          }
          j = paramBundle.Cgb.getHeight();
          paramBundle = this.Cds;
          d.g.b.p.h(paramBundle, "callback");
          ae.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.sYT.xOt);
          paramc.tUf = paramBundle;
          paramc.CdD.iu(i, j);
          if (!TextUtils.isEmpty((CharSequence)paramc.CdG.BYm)) {
            break;
          }
          paramc.CdD.c(paramc.CdF);
          AppMethodBeat.o(111116);
          return;
          bool = false;
        }
        paramc.CdC.b(paramc.CdG.BYm, (m)new a.e(paramc));
        AppMethodBeat.o(111116);
        return;
        label1752:
        AppMethodBeat.o(111116);
        return;
        label1759:
        paramc = this.Cdu;
        if (paramc != null)
        {
          paramBundle = this.Cdt;
          if (paramBundle == null) {
            d.g.b.p.bdF("previewPlayerPlugin");
          }
          i = paramBundle.Cgb.getWidth();
          paramBundle = this.Cdt;
          if (paramBundle == null) {
            d.g.b.p.bdF("previewPlayerPlugin");
          }
          j = paramBundle.Cgb.getHeight();
          paramBundle = this.Cds;
          d.g.b.p.h(paramBundle, "callback");
          ae.i("MicroMsg.VLogGenerateManager", "generate path :" + paramc.sYT.xOt);
          paramc.tUf = paramBundle;
          paramc.CdD.iu(i, j);
          com.tencent.mm.plugin.vlog.remux.d.a(paramc.CdD, (d.g.a.r)new a.d(paramc, i, j));
          AppMethodBeat.o(111116);
          return;
        }
      }
      AppMethodBeat.o(111116);
      return;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = this.Cdt;
        if (paramc == null) {
          d.g.b.p.bdF("previewPlayerPlugin");
        }
        paramc.Cgb.setMute(bool);
        AppMethodBeat.o(111116);
        return;
      }
      AppMethodBeat.o(111116);
      return;
    }
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(111118);
    ae.i("MicroMsg.VLogPreviewPluginLayout", "onBackPress");
    if (!super.aoQ())
    {
      Object localObject = ad.BYv;
      ad.a(null);
      ae.i(ad.TAG, "record cancel");
      ad.dJv();
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
    this.Cdt = new ac((VLogPreloadPlayView)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.d)this);
    ArrayList localArrayList = getPluginList();
    ac localac = this.Cdt;
    if (localac == null) {
      d.g.b.p.bdF("previewPlayerPlugin");
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.b<avq, z>
  {
    b(VLogPreviewPluginLayout paramVLogPreviewPluginLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "errorCode", "", "model", "Lcom/tencent/mm/plugin/vlog/ui/manager/VLogGenerateManager$VLogOutputInfo;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.q<Boolean, Integer, a.b, z>
  {
    c(VLogPreviewPluginLayout paramVLogPreviewPluginLayout, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout
 * JD-Core Version:    0.7.0.1
 */