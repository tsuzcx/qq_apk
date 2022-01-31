package com.tencent.mm.plugin.recordvideo.plugin.parent;

import a.f.b.j;
import a.f.b.u.c;
import a.v;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Process;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.recordvideo.b.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.m;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.plugin.recordvideo.plugin.p;
import com.tencent.mm.plugin.recordvideo.plugin.p.b;
import com.tencent.mm.plugin.recordvideo.plugin.w.b;
import com.tencent.mm.plugin.recordvideo.plugin.w.c;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.f.b.a;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy.a;
import com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorInputView;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "initLogic", "", "onBackPress", "", "release", "startEditView", "info", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class EditorVideoPluginLayoutNew
  extends BasePluginLayout
  implements d
{
  public static final EditorVideoPluginLayoutNew.a qeh;
  private final com.tencent.mm.remoteservice.d evl;
  public RecordConfigProvider qaF;
  public com.tencent.mm.media.widget.camerarecordview.a.b qbS;
  private com.tencent.mm.plugin.recordvideo.activity.a qdK;
  private final com.tencent.mm.plugin.recordvideo.plugin.c qdO;
  private final com.tencent.mm.plugin.recordvideo.plugin.a qdQ;
  private final com.tencent.mm.plugin.recordvideo.plugin.d qdR;
  public final p qdU;
  private final e qdZ;
  private final n qea;
  private final com.tencent.mm.plugin.recordvideo.plugin.b qeb;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a qec;
  public final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a qed;
  public final com.tencent.mm.plugin.recordvideo.plugin.w qee;
  private final com.tencent.mm.plugin.recordvideo.plugin.l qef;
  private final m qeg;
  
  static
  {
    AppMethodBeat.i(150813);
    qeh = new EditorVideoPluginLayoutNew.a((byte)0);
    AppMethodBeat.o(150813);
  }
  
  public EditorVideoPluginLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(150812);
    this.evl = new com.tencent.mm.remoteservice.d(paramContext);
    this.qee = new com.tencent.mm.plugin.recordvideo.plugin.w(paramContext);
    paramAttributeSet = StoryAudioManagerProxy.sCO;
    StoryAudioManagerProxy.a.createInstance(this.evl);
    LayoutInflater.from(paramContext).inflate(2130971065, (ViewGroup)this, true);
    paramContext = findViewById(2131828715);
    j.p(paramContext, "findViewById(R.id.video_play_plugin)");
    this.qdU = new p((VideoPlayerTextureView)paramContext, (d)this, (TextView)findViewById(2131821751));
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131823579);
    j.p(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.qdQ = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    paramContext = findViewById(2131823571);
    j.p(paramContext, "findViewById(R.id.editor_item_container)");
    this.qdZ = new e((EditorItemContainer)paramContext, (d)this);
    paramContext = findViewById(2131826737);
    j.p(paramContext, "findViewById(R.id.control_container)");
    this.qea = new n((ViewGroup)paramContext, (d)this);
    this.qeb = new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)this, (d)this);
    this.qec = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (d)this);
    this.qed = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a((ViewGroup)this, (d)this);
    paramContext = findViewById(2131828380);
    j.p(paramContext, "findViewById(R.id.editor_mix)");
    this.qdR = new com.tencent.mm.plugin.recordvideo.plugin.d(paramContext, (d)this);
    paramContext = findViewById(2131828697);
    j.p(paramContext, "findViewById(R.id.editor_close)");
    this.qdO = new com.tencent.mm.plugin.recordvideo.plugin.c((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131828714);
    j.p(paramContext, "findViewById(R.id.ext_text_area)");
    this.qef = new com.tencent.mm.plugin.recordvideo.plugin.l((TextView)paramContext, (d)this);
    paramContext = findViewById(2131821747);
    j.p(paramContext, "findViewById(R.id.recorder_black_mask)");
    this.qeg = new m(paramContext, (d)this);
    getPluginList().add(this.qdU);
    getPluginList().add(this.qdQ);
    getPluginList().add(this.qdZ);
    getPluginList().add(this.qea);
    getPluginList().add(this.qeb);
    getPluginList().add(this.qec);
    getPluginList().add(this.qed);
    getPluginList().add(this.qdR);
    getPluginList().add(this.qee);
    getPluginList().add(this.qdO);
    getPluginList().add(this.qef);
    getPluginList().add(this.qeg);
    paramContext = ((Iterable)getPluginList()).iterator();
    while (paramContext.hasNext())
    {
      paramAttributeSet = (com.tencent.mm.plugin.recordvideo.plugin.q)paramContext.next();
      if (j.e((Boolean)com.tencent.mm.component.api.jumper.a.etq.get(paramAttributeSet.name()), Boolean.TRUE)) {
        paramAttributeSet.setVisibility(0);
      }
    }
    AppMethodBeat.o(150812);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject3 = null;
    AppMethodBeat.i(150808);
    j.q(parama, "navigator");
    j.q(paramRecordConfigProvider, "configProvider");
    ab.i("MicroMsg.EditorVideoPluginLayoutNew", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.qdK = parama;
    this.qaF = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.d.a.qfv;
    com.tencent.mm.plugin.recordvideo.d.a.c(paramRecordConfigProvider);
    parama = this.qdZ;
    j.q(paramRecordConfigProvider, "configProvider");
    parama = parama.qbQ;
    j.q(paramRecordConfigProvider, "configProvider");
    parama.qaF = paramRecordConfigProvider;
    this.qec.setVisibility(0);
    this.qed.setVisibility(0);
    parama = ((Iterable)getPluginList()).iterator();
    Object localObject1;
    Object localObject2;
    while (parama.hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.recordvideo.plugin.q)parama.next();
      localObject2 = paramRecordConfigProvider.qbr;
      if (localObject2 != null)
      {
        localObject2 = ((UICustomParam)localObject2).etv;
        if (localObject2 != null)
        {
          localObject2 = (Boolean)((Map)localObject2).get(((com.tencent.mm.plugin.recordvideo.plugin.q)localObject1).name());
          if (localObject2 != null)
          {
            if (!((Boolean)localObject2).booleanValue())
            {
              i = 1;
              label192:
              if (i == 0) {
                break label214;
              }
            }
            label214:
            for (int i = 0;; i = 8)
            {
              ((com.tencent.mm.plugin.recordvideo.plugin.q)localObject1).setVisibility(i);
              break;
              i = 0;
              break label192;
            }
          }
        }
      }
    }
    Object localObject4 = this.qdR;
    parama = paramRecordConfigProvider.qbr;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.etw);
      localObject1 = paramRecordConfigProvider.qbr;
      if (localObject1 == null) {
        break label791;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).etx);
      label264:
      localObject2 = paramRecordConfigProvider.qbr;
      if (localObject2 == null) {
        break label797;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      label282:
      localObject4 = ((com.tencent.mm.plugin.recordvideo.plugin.d)localObject4).view;
      if ((parama != null) && (parama.intValue() != 0)) {
        ((View)localObject4).setBackgroundResource(parama.intValue());
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject4 instanceof TextView))) {
        ((TextView)localObject4).setTextColor(android.support.v4.content.b.m(((TextView)localObject4).getContext(), ((Integer)localObject1).intValue()));
      }
      if ((localObject2 != null) && ((localObject4 instanceof TextView))) {
        ((TextView)localObject4).setText((CharSequence)localObject2);
      }
      localObject2 = this.qec;
      parama = paramRecordConfigProvider.qbr;
      if (parama == null) {
        break label803;
      }
      parama = Integer.valueOf(parama.etw);
      label403:
      localObject1 = paramRecordConfigProvider.qbr;
      if (localObject1 == null) {
        break label808;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).etx);
      label424:
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2).qdz.sOo.nJm;
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((Button)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((Button)localObject2).setTextColor(android.support.v4.content.b.m(((Button)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      localObject1 = this.qef;
      parama = paramRecordConfigProvider.qbr;
      if (parama == null) {
        break label814;
      }
      parama = parama.ety;
      label521:
      if (!bo.isNullOrNil(parama)) {
        break label819;
      }
      ((com.tencent.mm.plugin.recordvideo.plugin.l)localObject1).qct.setVisibility(8);
      label538:
      localObject2 = this.qeb;
      parama = paramRecordConfigProvider.qbr;
      if (parama == null) {
        break label843;
      }
      parama = Integer.valueOf(parama.etw);
      label561:
      localObject1 = paramRecordConfigProvider.qbr;
      if (localObject1 == null) {
        break label848;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).etx);
      label582:
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.b)localObject2).qbL.getConfirm();
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((View)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((TextView)localObject2).setTextColor(android.support.v4.content.b.m(((TextView)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      localObject1 = this.qed;
      parama = paramRecordConfigProvider.qbr;
      if (parama == null) {
        break label854;
      }
    }
    label791:
    label797:
    label803:
    label808:
    label814:
    label819:
    label843:
    label848:
    label854:
    for (parama = Integer.valueOf(parama.etw);; parama = null)
    {
      localObject2 = paramRecordConfigProvider.qbr;
      paramRecordConfigProvider = localObject3;
      if (localObject2 != null) {
        paramRecordConfigProvider = Integer.valueOf(((UICustomParam)localObject2).etx);
      }
      localObject1 = ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject1).qdl.getFinishButton();
      if (localObject1 == null) {
        break label859;
      }
      if ((parama != null) && (parama.intValue() != 0)) {
        ((Button)localObject1).setBackgroundResource(parama.intValue());
      }
      if ((paramRecordConfigProvider != null) && (paramRecordConfigProvider.intValue() != 0) && ((localObject1 instanceof TextView))) {
        ((Button)localObject1).setTextColor(android.support.v4.content.b.m(((Button)localObject1).getContext(), paramRecordConfigProvider.intValue()));
      }
      AppMethodBeat.o(150808);
      return;
      parama = null;
      break;
      localObject1 = null;
      break label264;
      localObject2 = null;
      break label282;
      parama = null;
      break label403;
      localObject1 = null;
      break label424;
      parama = null;
      break label521;
      ((com.tencent.mm.plugin.recordvideo.plugin.l)localObject1).qct.setVisibility(0);
      ((com.tencent.mm.plugin.recordvideo.plugin.l)localObject1).qct.setText((CharSequence)parama);
      break label538;
      parama = null;
      break label561;
      localObject1 = null;
      break label582;
    }
    label859:
    AppMethodBeat.o(150808);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(150809);
    j.q(paramc, "status");
    if (paramc != d.c.qeI) {
      ab.i("MicroMsg.EditorVideoPluginLayoutNew", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    label332:
    label336:
    label340:
    label382:
    int k;
    label402:
    label422:
    label442:
    int m;
    switch (c.bLo[paramc.ordinal()])
    {
    default: 
      ab.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      AppMethodBeat.o(150809);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      this.qea.setVisibility(4);
      AppMethodBeat.o(150809);
      return;
    case 5: 
      paramBundle = this.qeg;
      paramc = paramBundle.mwU;
      paramBundle = paramBundle.mwU.getContext();
      j.p(paramBundle, "bgView.context");
      paramc.setBackgroundColor(paramBundle.getResources().getColor(2131689763));
      AppMethodBeat.o(150809);
      return;
    case 6: 
      this.qdZ.setVisibility(0);
      this.qea.setVisibility(0);
      paramBundle = this.qec;
      localObject1 = this.qbS;
      if (localObject1 == null) {
        j.ebi();
      }
      paramc = this.qaF;
      j.q(localObject1, "info");
      localObject2 = new com.tencent.mm.plugin.story.c.a();
      "editorConfig : ".concat(String.valueOf(localObject2));
      h.dUV();
      if (paramc != null)
      {
        paramc = Integer.valueOf(paramc.scene);
        if (paramc != null) {
          break label382;
        }
        if (paramc != null) {
          break label402;
        }
        if (paramc != null) {
          break label422;
        }
        if (paramc != null) {
          break label442;
        }
      }
      for (;;)
      {
        EditorAudioView.a(paramBundle.qdz, ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).fbn, ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).startTime, ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).endTime, (com.tencent.mm.plugin.story.c.a)localObject2);
        AppMethodBeat.o(150809);
        return;
        paramc = null;
        break;
        if (paramc.intValue() != 2) {
          break label332;
        }
        ((com.tencent.mm.plugin.story.c.a)localObject2).a(com.tencent.mm.plugin.story.c.d.srs);
        continue;
        if (paramc.intValue() != 1) {
          break label336;
        }
        ((com.tencent.mm.plugin.story.c.a)localObject2).a(com.tencent.mm.plugin.story.c.d.srx);
        continue;
        if (paramc.intValue() != 3) {
          break label340;
        }
        ((com.tencent.mm.plugin.story.c.a)localObject2).a(com.tencent.mm.plugin.story.c.d.srr);
        continue;
        if (paramc.intValue() == 5) {
          ((com.tencent.mm.plugin.story.c.a)localObject2).a(com.tencent.mm.plugin.story.c.d.srt);
        }
      }
    case 7: 
      this.qea.setVisibility(0);
      paramc = this.qdZ.qbP;
      if (paramc != null)
      {
        paramc.setVisibility(0);
        AppMethodBeat.o(150809);
        return;
      }
      AppMethodBeat.o(150809);
      return;
    case 8: 
      localObject1 = this.qdZ;
      if (paramBundle != null) {}
      for (paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");; paramc = null)
      {
        if (paramc != null) {
          ((e)localObject1).qbQ.D(paramc);
        }
        AppMethodBeat.o(150809);
        return;
      }
    case 9: 
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramc = this.qdZ;
        paramBundle = localObject1.toString();
        j.q(paramBundle, "text");
        if (paramc.qbP != null)
        {
          localObject1 = paramc.qbP;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.story.ui.view.editor.item.g)localObject1).setVisibility(0);
          }
          localObject1 = paramc.qbP;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.story.ui.view.editor.item.g)localObject1).setText((CharSequence)paramBundle, i, j);
          }
          paramc.qbP = null;
          AppMethodBeat.o(150809);
          return;
        }
        paramc.qbQ.h((CharSequence)paramBundle, i, j);
      }
      AppMethodBeat.o(150809);
      return;
    case 10: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        this.qeb.e(paramc, i, j);
      }
      AppMethodBeat.o(150809);
      return;
    case 11: 
      if (paramBundle != null)
      {
        bool1 = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        this.qdU.oKC.setMute(bool1);
      }
      AppMethodBeat.o(150809);
      return;
    case 12: 
      this.qed.cgz();
      AppMethodBeat.o(150809);
      return;
    case 13: 
      this.qea.setVisibility(4);
      paramc = this.qdU;
      paramc.qcD = true;
      k = paramc.qcC.getWidth();
      m = paramc.qcC.getHeight();
      j = com.tencent.mm.cb.a.fromDPToPix(paramc.context, 20) + com.tencent.mm.cb.a.fromDPToPix(paramc.context, 95) + com.tencent.mm.cb.a.fromDPToPix(paramc.context, 12);
      i = j;
      if (am.hO(paramc.context)) {
        i = j + am.fx(paramc.context);
      }
      j = m - i;
      if (paramc.qcC.getBottom() + i < com.tencent.mm.plugin.mmsight.d.ex(paramc.context).y) {
        j = (int)((k - com.tencent.mm.cb.a.fromDPToPix(paramc.context, 32) * 2) / (k / m));
      }
      f1 = (int)(k / m * j) / k;
      f2 = j / m;
      paramc.qcC.animate().scaleX(f1).scaleY(f2).translationY(-(i / 2.0F)).setDuration(300L).setListener((Animator.AnimatorListener)new p.b(paramc));
      this.qdZ.qbQ.setEnableTouch(false);
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(150809);
      return;
    case 14: 
      if (paramBundle != null)
      {
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramc = this.qdU;
        paramc.startTime = i;
        paramc.endTime = j;
        paramc.oKC.e(paramc.startTime, true);
      }
      AppMethodBeat.o(150809);
      return;
    case 15: 
      this.qdU.onPause();
      AppMethodBeat.o(150809);
      return;
    case 16: 
      this.qdU.onResume();
      AppMethodBeat.o(150809);
      return;
    case 17: 
      if (paramBundle != null)
      {
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.qed;
        if (paramc.qdl.getVisibility() == 0)
        {
          paramc = paramc.qdl;
          paramc.oQL.setCurrentCursorPosition(i / paramc.oQL.getDurationMs());
        }
      }
      AppMethodBeat.o(150809);
      return;
    case 18: 
      paramc = this.qbS;
      if (paramc != null)
      {
        j = paramc.endTime;
        k = paramc.startTime;
        paramc = this.qaF;
        if (paramc != null) {
          i = paramc.qbx;
        }
        while (j - k > i)
        {
          paramc = getContext();
          if (paramc == null)
          {
            paramc = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(150809);
            throw paramc;
            i = 10000;
          }
          else
          {
            ((Activity)paramc).setResult(3000);
            paramc = getContext();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(150809);
              throw paramc;
            }
            ((Activity)paramc).finish();
            AppMethodBeat.o(150809);
            return;
          }
        }
        this.qea.setVisibility(0);
        this.qdU.ks(false);
        this.qdZ.cgt();
        paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(150809);
        return;
      }
      AppMethodBeat.o(150809);
      return;
    case 19: 
      this.qea.setVisibility(0);
      this.qdU.ks(true);
      this.qdZ.cgt();
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(150809);
      return;
    case 20: 
      cgq();
      AppMethodBeat.o(150809);
      return;
    }
    this.qdU.release();
    this.qdZ.onPause();
    this.qec.onPause();
    boolean bool1 = this.qec.qdB;
    paramc = this.qec.qaV;
    paramBundle = this.qdZ.cgr();
    Object localObject1 = this.qdZ.cgs();
    Object localObject2 = this.qdZ;
    float f1 = ((e)localObject2).qbQ.getLeft();
    float f2 = ((e)localObject2).qbQ.getTop();
    float f3 = ((e)localObject2).qbQ.getRight();
    float f4 = ((e)localObject2).qbQ.getBottom();
    int i = this.qdU.startTime;
    int j = this.qdU.endTime;
    com.tencent.mm.plugin.recordvideo.b.b localb = new com.tencent.mm.plugin.recordvideo.b.b(bool1, paramc, paramBundle, (ArrayList)localObject1, new float[] { f1, f2, f3, f4 }, i, j);
    ab.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(localb)));
    com.tencent.mm.plugin.recordvideo.plugin.w localw = this.qee;
    j.q(localb, "editConfig");
    if ((localw.qaF == null) || (!localw.enable)) {
      ab.e("MicroMsg.RemuxPlugin", "notice: configProvider is null  " + localw.enable + "  " + localw.qaF + ' ');
    }
    label1733:
    label1761:
    label1914:
    long l1;
    Object localObject3;
    for (;;)
    {
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(this.qdZ.cgu()));
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(this.qdZ.cgv()));
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      if (this.qec.qaV != null) {
        break label4160;
      }
      i = 0;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      if (!this.qec.qdB) {
        break label4166;
      }
      i = 0;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      AppMethodBeat.o(150809);
      return;
      localw.enable = false;
      ab.i("MicroMsg.RemuxPlugin", "configProvider : " + localw.qaF);
      ab.i("MicroMsg.RemuxPlugin", "RemuxMediaEditConfig : ".concat(String.valueOf(localb)));
      ab.i("MicroMsg.RemuxPlugin", "mediaCaptureInfo : " + localw.oQp);
      paramBundle = localw.qaF;
      if (paramBundle != null)
      {
        localObject1 = localw.oQp;
        if ((paramBundle == null) || (localObject1 == null))
        {
          ab.e("MicroMsg.RemuxMediaEditConfig", "configProvider  is null");
          paramc = new b.b((byte)0);
          ab.i("MicroMsg.RemuxPlugin", "generateTargetConfig info: " + paramc + ' ');
          localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
          com.tencent.mm.plugin.recordvideo.c.b.p("KEY_VIDEO_IS_EDITED_BOOLEAN", Boolean.valueOf(paramc.qbd));
          localObject1 = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.Wc();
          if (paramc.qbd)
          {
            localObject1 = com.tencent.mm.media.i.c.eZC;
            com.tencent.mm.media.i.c.Wb();
          }
          if (paramc.qbc) {
            break;
          }
          if (localb.qaV != null) {
            continue;
          }
          paramc = localw.oQp;
          if ((paramc == null) || (paramc.fbp != true)) {
            break label2561;
          }
          if (paramBundle.scene != 2) {
            break label2543;
          }
          paramc = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.VZ();
        }
        for (;;)
        {
          paramc = com.tencent.mm.plugin.recordvideo.d.a.qfv;
          com.tencent.mm.plugin.recordvideo.d.a.d(localw.qaF);
          paramc = paramBundle.qbB;
          j.p(paramc, "this.outputVideoPath");
          localObject1 = paramBundle.thumbPath;
          j.p(localObject1, "this.thumbPath");
          com.tencent.mm.plugin.recordvideo.plugin.w.fT(paramc, (String)localObject1);
          paramc = paramBundle.qbB;
          j.p(paramc, "this.outputVideoPath");
          com.tencent.mm.plugin.recordvideo.plugin.w.XY(paramc);
          paramc = Boolean.TRUE;
          localObject1 = paramBundle.qbB;
          paramBundle = paramBundle.thumbPath;
          l1 = localb.qba - localb.qaZ;
          localObject2 = Boolean.FALSE;
          localObject3 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
          localw.b(new CaptureDataManager.CaptureVideoNormalModel(paramc, (String)localObject1, paramBundle, Long.valueOf(l1), (Boolean)localObject2, com.tencent.mm.plugin.recordvideo.c.b.cgB()));
          break;
          if (paramBundle.qbq == null)
          {
            paramc = com.tencent.mm.modelcontrol.d.afW();
            j.p(paramc, "SubCoreVideoControl.getCore()");
            paramBundle.qbq = paramc.afZ();
          }
          paramc = paramBundle.qbq;
          if ((paramc == null) || (paramc.fAh != 1))
          {
            paramc = paramBundle.qbq;
            if ((paramc == null) || (paramc.fAh != 2)) {}
          }
          else
          {
            localObject2 = paramBundle.qbq;
            if (localObject2 != null)
            {
              paramc = paramBundle.qbq;
              if (paramc == null) {
                break label2380;
              }
              paramc = Integer.valueOf(paramc.fAp);
              label2248:
              ((VideoTransPara)localObject2).videoBitrate = paramc.intValue();
            }
            localObject2 = new StringBuilder("match aba switch, target videoBitrate:");
            paramc = paramBundle.qbq;
            if (paramc == null) {
              break label2385;
            }
          }
          label2380:
          label2385:
          for (paramc = Integer.valueOf(paramc.videoBitrate);; paramc = null)
          {
            ab.i("MicroMsg.RemuxMediaEditConfig", paramc);
            if ((localb.qaW.isEmpty()) && (localb.qaV == null)) {
              break label2390;
            }
            paramc = new b.b((byte)0);
            paramc.qbc = true;
            paramc.qbd = true;
            ab.i("MicroMsg.RemuxMediaEditConfig", "remux by add editItems " + localb.qaW);
            paramc = com.tencent.mm.plugin.recordvideo.b.b.a(((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).fbn, paramBundle, paramc);
            break;
            paramc = null;
            break label2248;
          }
          label2390:
          if ((localb.qaZ - 80 >= 0) || (localb.qba + 80 <= ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).endTime))
          {
            ab.i("MicroMsg.RemuxMediaEditConfig", "remux by time reMuxEndTimeMs:" + localb.qba + "  reMuxStartTimeMs:" + localb.qaZ);
            paramc = new b.b((byte)0);
            paramc.qbc = true;
            paramc.qbd = true;
            paramc = com.tencent.mm.plugin.recordvideo.b.b.a(((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).fbn, paramBundle, paramc);
            break label1914;
          }
          if ((paramBundle.qbm == 2) && (localb.qaW.isEmpty()))
          {
            paramc = new b.b((byte)0);
            break label1914;
          }
          paramc = com.tencent.mm.plugin.recordvideo.b.b.a(((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).fbn, paramBundle, new b.b((byte)0));
          break label1914;
          label2543:
          if (paramBundle.scene == 1)
          {
            paramc = com.tencent.mm.media.i.c.eZC;
            com.tencent.mm.media.i.c.Wa();
          }
        }
        label2561:
        paramc = paramBundle.qbA;
        j.p(paramc, "this.inputVideoPath");
        localObject1 = paramBundle.thumbPath;
        j.p(localObject1, "this.thumbPath");
        com.tencent.mm.plugin.recordvideo.plugin.w.fT(paramc, (String)localObject1);
        paramc = paramBundle.qbA;
        j.p(paramc, "this.inputVideoPath");
        com.tencent.mm.plugin.recordvideo.plugin.w.XY(paramc);
        paramc = Boolean.TRUE;
        localObject1 = paramBundle.qbA;
        paramBundle = paramBundle.thumbPath;
        l1 = localb.qba - localb.qaZ;
        localObject2 = Boolean.FALSE;
        localObject3 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        localw.b(new CaptureDataManager.CaptureVideoNormalModel(paramc, (String)localObject1, paramBundle, Long.valueOf(l1), (Boolean)localObject2, com.tencent.mm.plugin.recordvideo.c.b.cgB()));
      }
    }
    u.c localc;
    label2768:
    Object localObject4;
    label2837:
    label2868:
    label2881:
    label2894:
    label2907:
    Integer localInteger;
    label2920:
    label3052:
    boolean bool2;
    if (j.e(paramBundle.qbv, Boolean.TRUE))
    {
      paramBundle = new b.a();
      paramBundle.a(localw.context, false, 2131302637, (a.f.a.a)w.b.qde);
      localw.qdb = paramBundle;
      l1 = System.currentTimeMillis();
      localc = new u.c();
      bool1 = WXHardCoderJNI.hcEncodeVideoEnable;
      j = WXHardCoderJNI.hcEncodeVideoDelay;
      k = WXHardCoderJNI.hcEncodeVideoCPU;
      m = WXHardCoderJNI.hcEncodeVideoIO;
      if (WXHardCoderJNI.hcEncodeVideoThr)
      {
        i = Process.myTid();
        localc.BNp = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "RemuxPlugin");
        ab.i("MicroMsg.RemuxPlugin", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(localc.BNp) });
        paramBundle = localw.qaF;
        if (paramBundle == null) {
          break label3812;
        }
        paramBundle = paramBundle.qbq;
        i = paramc.videoBitrate;
        j = paramc.eRu;
        k = paramc.eRv;
        if (paramBundle == null) {
          break label3817;
        }
        localObject1 = Integer.valueOf(paramBundle.fAh);
        if (paramBundle == null) {
          break label3823;
        }
        localObject2 = Integer.valueOf(paramBundle.fAj);
        if (paramBundle == null) {
          break label3829;
        }
        localObject3 = Integer.valueOf(paramBundle.fAk);
        if (paramBundle == null) {
          break label3835;
        }
        localObject4 = Integer.valueOf(paramBundle.fAl);
        if (paramBundle == null) {
          break label3841;
        }
        localInteger = Integer.valueOf(paramBundle.fAm);
        ab.i("MicroMsg.RemuxPlugin", "ABA: Input encoding prams :Br: [%d]  height: [%d]  width: [%d]  [%d] [%d]  [%d]  [%d] [%d] [%d] [%d] ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject1, localObject2, localObject3, localObject4, localInteger, Integer.valueOf(localb.qba), Integer.valueOf(localb.qaZ) });
        if (((paramBundle == null) || (paramBundle.fAh != 1)) && ((paramBundle == null) || (paramBundle.fAh != 2))) {
          break label3853;
        }
        localObject1 = localw.oQp;
        if (localObject1 == null) {
          break label3847;
        }
        localObject1 = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject1).fbn;
        paramBundle = AdaptiveAdjustBitrate.GetBitrate((String)localObject1, paramc.eRv, paramc.eRu, paramBundle.fps, paramc.videoBitrate, (localb.qba - localb.qaZ) / 1000, localb.qaZ / 1000, 2, paramBundle.fAj, paramBundle.fAk, paramBundle.fAl, paramBundle.fAm);
        j.p(paramBundle, "AdaptiveAdjustBitrate.Ge…ansPara?.abaDecreasesize)");
        localw.qdc = paramBundle;
        if ((localw.qdc[3] > 0) || (localw.qdc[4] > 0)) {
          paramc.videoBitrate = (localw.qdc[0] * 1000);
        }
        if (localw.qdc[5] > 0)
        {
          paramc.eRu = localw.qdc[1];
          paramc.eRv = localw.qdc[2];
        }
        ab.i("MicroMsg.RemuxPlugin", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(paramc.videoBitrate), Integer.valueOf(paramc.eRu), Integer.valueOf(paramc.eRv) });
        long l2 = System.currentTimeMillis();
        paramBundle = localw.qaF;
        if (paramBundle != null)
        {
          localObject1 = paramBundle.qbB;
          paramBundle = (Bundle)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramBundle = com.tencent.mm.plugin.story.model.l.acZ(String.valueOf(l2));
        }
        localObject1 = localw.qaF;
        if (localObject1 != null)
        {
          localObject2 = ((RecordConfigProvider)localObject1).thumbPath;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.story.model.l.ada(String.valueOf(l2));
        }
        localObject2 = localw.qaF;
        if (localObject2 == null) {
          break label3932;
        }
        i = ((RecordConfigProvider)localObject2).scene;
        label3335:
        bool1 = false;
        if (i != 2) {
          break label3957;
        }
        if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVT, 0) != 1) {
          break label3938;
        }
        bool2 = true;
        label3369:
        i = ac.erB.erc;
        if (i == -1) {
          break label3950;
        }
        if (i != 1) {
          break label3944;
        }
        bool1 = true;
        label3392:
        ab.i("MicroMsg.RemuxPlugin", "sns config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
        localObject4 = new com.tencent.mm.plugin.story.e.a();
        localObject2 = localw.oQp;
        if (localObject2 != null)
        {
          localObject3 = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject2).fbn;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        ((com.tencent.mm.plugin.story.e.a)localObject4).acH((String)localObject2);
        localObject2 = localw.oQp;
        if (localObject2 != null)
        {
          localObject3 = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject2).fbo;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        ((com.tencent.mm.plugin.story.e.a)localObject4).acI((String)localObject2);
        ((com.tencent.mm.plugin.story.e.a)localObject4).ssr = localb.qaV;
        if (!localb.qaU) {
          break label4074;
        }
        if (((com.tencent.mm.plugin.story.e.a)localObject4).ssr != null) {
          break label4068;
        }
        i = 0;
        label3545:
        ((com.tencent.mm.plugin.story.e.a)localObject4).ssq = i;
        localObject2 = localw.oQp;
        if (localObject2 == null) {
          break label4094;
        }
        bool2 = ((com.tencent.mm.media.widget.camerarecordview.a.b)localObject2).fbp;
        label3571:
        ((com.tencent.mm.plugin.story.e.a)localObject4).fbp = bool2;
        ((com.tencent.mm.plugin.story.e.a)localObject4).eWL = SightVideoJNI.getMp4Rotate(((com.tencent.mm.plugin.story.e.a)localObject4).ssl);
        ((com.tencent.mm.plugin.story.e.a)localObject4).ssn = localb.qaZ;
        ((com.tencent.mm.plugin.story.e.a)localObject4).sso = localb.qba;
        ab.i("MicroMsg.RemuxPlugin", "getTransformInfo :".concat(String.valueOf(localObject4)));
        paramBundle = new com.tencent.mm.plugin.story.model.e.b((com.tencent.mm.plugin.story.e.a)localObject4, (List)localb.qaW, localb.qaY, paramBundle, (String)localObject1, 0, bool1, 32);
        localObject1 = localw.qaF;
        if ((localObject1 == null) || (((RecordConfigProvider)localObject1).scene != 2)) {
          break label4100;
        }
        f1 = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVY, 1.0F);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.RemuxPlugin", "final kbps: " + f1 + "  " + paramc.videoBitrate * f1);
      paramBundle.a(paramc.eRu, paramc.eRv, (int)(f1 * paramc.videoBitrate), paramc.fzT, paramc.audioSampleRate, paramc.eRF, paramc.eRw, paramc.eWL);
      paramBundle.a((a.f.a.q)new w.c(localw, localc, paramc, l1, localb));
      break;
      i = 0;
      break label2768;
      label3812:
      paramBundle = null;
      break label2837;
      label3817:
      localObject1 = null;
      break label2868;
      label3823:
      localObject2 = null;
      break label2881;
      label3829:
      localObject3 = null;
      break label2894;
      label3835:
      localObject4 = null;
      break label2907;
      label3841:
      localInteger = null;
      break label2920;
      label3847:
      localObject1 = null;
      break label3052;
      label3853:
      i = paramc.videoBitrate;
      paramBundle = localw.qaF;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.qbq;
        if (paramBundle == null) {}
      }
      for (paramBundle = Integer.valueOf(paramBundle.fAp);; paramBundle = null)
      {
        if (paramBundle == null) {
          j.ebi();
        }
        ab.i("MicroMsg.RemuxPlugin", "ABA: No use ABA algorithm: final bitrate: [%d], takePhotosVideoBR: [%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBundle.intValue()) });
        break;
      }
      label3932:
      i = 0;
      break label3335;
      label3938:
      bool2 = false;
      break label3369;
      label3944:
      bool1 = false;
      break label3392;
      label3950:
      bool1 = bool2;
      break label3392;
      label3957:
      if (i == 1)
      {
        if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVU, 0) != 1) {
          break label4049;
        }
        bool2 = true;
        i = ac.erB.erb;
        if (i == -1) {
          break label4061;
        }
        if (i != 1) {
          break label4055;
        }
        bool1 = true;
      }
      for (;;)
      {
        label3988:
        ab.i("MicroMsg.RemuxPlugin", "c2c config use x264 encode: " + bool2 + ", deviceUseX264Encode:" + i);
        break;
        label4049:
        bool2 = false;
        break label3988;
        label4055:
        bool1 = false;
        continue;
        label4061:
        bool1 = bool2;
      }
      label4068:
      i = 2;
      break label3545;
      label4074:
      if (((com.tencent.mm.plugin.story.e.a)localObject4).ssr == null)
      {
        i = 1;
        break label3545;
      }
      i = 3;
      break label3545;
      label4094:
      bool2 = true;
      break label3571;
      label4100:
      localObject1 = localw.qaF;
      if (localObject1 != null)
      {
        if (((RecordConfigProvider)localObject1).scene == 1) {
          f1 = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVX, 1.0F);
        }
      }
      else
      {
        f1 = 1.0F;
        continue;
        ab.e("MicroMsg.RemuxPlugin", "something error ! notice !");
        break;
        label4160:
        i = 1;
        break label1733;
        label4166:
        i = 1;
        break label1761;
      }
      f1 = 1.0F;
    }
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150811);
    if (!super.cgq())
    {
      ab.i("MicroMsg.EditorVideoPluginLayoutNew", "onBackPress");
      Object localObject = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      this.qdU.release();
      localObject = this.qdK;
      if (localObject != null) {
        ((com.tencent.mm.plugin.recordvideo.activity.a)localObject).cgh();
      }
    }
    AppMethodBeat.o(150811);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(150810);
    super.release();
    StoryAudioManagerProxy.a locala = StoryAudioManagerProxy.sCO;
    StoryAudioManagerProxy.access$getInstance$cp().cancelAll();
    this.evl.release();
    AppMethodBeat.o(150810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew
 * JD-Core Version:    0.7.0.1
 */