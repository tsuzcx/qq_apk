package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView;
import com.tencent.mm.plugin.recordvideo.plugin.h.a;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.s.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "getAddMusicPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "getAddPoiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "getAddTipPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "getAddonTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "getBgPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "getCropVideoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "getInputPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "getItemContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "moreMenuPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "getMoreMenuPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getNavigator", "()Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "setNavigator", "(Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;)V", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;)V", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "getReMuxPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getVideoControlContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getLayoutId", "", "getPlayerView", "Landroid/view/View;", "hideDialog", "", "initLogic", "initSafeArea", "loadCurrentPage", "info", "loadPlayerView", "showDialog", "tip", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public abstract class BaseEditVideoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final BaseEditVideoPluginLayout.a BUc = new BaseEditVideoPluginLayout.a((byte)0);
  private com.tencent.mm.media.widget.camerarecordview.b.b BQt;
  protected com.tencent.mm.plugin.recordvideo.plugin.s BTM;
  private final com.tencent.mm.plugin.recordvideo.plugin.a BTN;
  private final com.tencent.mm.plugin.recordvideo.plugin.h BTO;
  private final com.tencent.mm.plugin.recordvideo.plugin.r BTP;
  private final com.tencent.mm.plugin.recordvideo.plugin.c BTQ;
  private final com.tencent.mm.plugin.recordvideo.plugin.d BTR;
  private final com.tencent.mm.plugin.recordvideo.plugin.b BTS;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a BTT;
  private final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a BTU;
  private final com.tencent.mm.plugin.recordvideo.plugin.f BTV;
  private final com.tencent.mm.plugin.recordvideo.plugin.e BTW;
  private final ab BTX;
  private final com.tencent.mm.plugin.recordvideo.plugin.p BTY;
  private final com.tencent.mm.plugin.recordvideo.plugin.q BTZ;
  private final i BUa;
  private final com.tencent.mm.plugin.recordvideo.plugin.g BUb;
  public com.tencent.mm.ui.base.q nUq;
  private com.tencent.mm.plugin.recordvideo.activity.a wdl;
  private RecordConfigProvider wdm;
  
  public BaseEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.BTX = new ab(paramContext);
    Log.i("MicroMsg.EditorVideoPluginLayout", "EditorVideoPluginLayoutNew invoke init");
    LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    paramContext = getPlayerView();
    paramAttributeSet = (ViewStub)findViewById(2131305944);
    kotlin.g.b.p.g(paramAttributeSet, "placeholder");
    Object localObject = paramAttributeSet.getParent();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    int i = ((ViewGroup)localObject).indexOfChild((View)paramAttributeSet);
    ((ViewGroup)localObject).removeViewAt(i);
    ((ViewGroup)localObject).addView(paramContext, i, new ViewGroup.LayoutParams(-1, -1));
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131299859);
    kotlin.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.BTN = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    paramContext = findViewById(2131299887);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.editor_item_container)");
    this.BTO = new com.tencent.mm.plugin.recordvideo.plugin.h((EditorItemContainer)paramContext, (d)this);
    paramContext = findViewById(2131299234);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.control_container)");
    this.BTP = new com.tencent.mm.plugin.recordvideo.plugin.r((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131298286);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.change_text_root)");
    this.BUb = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramContext);
    this.BTQ = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.BUb.BPY);
    this.BTT = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (d)this);
    this.BTU = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a((ViewGroup)this, (d)this);
    paramContext = findViewById(2131299891);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.editor_mix)");
    this.BTV = new com.tencent.mm.plugin.recordvideo.plugin.f(paramContext, (d)this);
    paramContext = findViewById(2131299875);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.editor_close)");
    this.BTW = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131300255);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.ext_text_area)");
    this.BTY = new com.tencent.mm.plugin.recordvideo.plugin.p((TextView)paramContext, (d)this);
    paramContext = findViewById(2131306748);
    kotlin.g.b.p.g(paramContext, "findViewById(R.id.recorder_black_mask)");
    this.BTZ = new com.tencent.mm.plugin.recordvideo.plugin.q((ImageView)paramContext, (d)this);
    this.BTR = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (d)this, this.BUb.BPY);
    this.BTS = new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)this, (d)this);
    this.BUa = new i((ViewGroup)this, (d)this);
    getPluginList().add(this.BTN);
    getPluginList().add(this.BTO);
    getPluginList().add(this.BTP);
    getPluginList().add(this.BTQ);
    getPluginList().add(this.BTT);
    getPluginList().add(this.BTU);
    getPluginList().add(this.BTV);
    getPluginList().add(this.BTX);
    getPluginList().add(this.BTW);
    getPluginList().add(this.BTY);
    getPluginList().add(this.BTZ);
    getPluginList().add(this.BTR);
    getPluginList().add(this.BTS);
    getPluginList().add(this.BUa);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.BOO;
    i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.BOO;
    int j = com.tencent.mm.plugin.recordvideo.model.a.eJO();
    float f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = j * 1.78F;
    float f5 = (i - f4) / 2.0F;
    if (f1 <= 1.78F)
    {
      this.BUb.bL(f3);
      this.BTO.ac(f2, f3);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.BUb.bM(f3);
      this.BTO.ad(f4, f5);
      return;
    }
    this.BUb.bL(f3);
    this.BUb.bM(f3);
    this.BTO.ac(f2, f3);
    this.BTO.ad(f4, f5);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    super.a(paramb);
    this.BQt = paramb;
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    kotlin.g.b.p.h(parama, "navigator");
    kotlin.g.b.p.h(paramRecordConfigProvider, "configProvider");
    this.wdl = parama;
    this.wdm = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    com.tencent.mm.plugin.recordvideo.e.c.e(paramRecordConfigProvider);
    parama = this.BTO;
    kotlin.g.b.p.h(paramRecordConfigProvider, "configProvider");
    parama = parama.BQh;
    kotlin.g.b.p.h(paramRecordConfigProvider, "configProvider");
    parama.wdm = paramRecordConfigProvider;
    this.BTT.setVisibility(0);
    this.BTU.setVisibility(0);
    com.tencent.mm.plugin.recordvideo.plugin.f localf = this.BTV;
    parama = paramRecordConfigProvider.BOn;
    Object localObject1;
    label124:
    Object localObject2;
    label142:
    Object localObject3;
    label163:
    label198:
    label219:
    label247:
    boolean bool;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.gLM);
      localObject1 = paramRecordConfigProvider.BOn;
      if (localObject1 == null) {
        break label597;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).gLN);
      localObject2 = paramRecordConfigProvider.BOn;
      if (localObject2 == null) {
        break label603;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.BOn;
      if (localObject3 == null) {
        break label609;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).gLO);
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.BTT;
      parama = paramRecordConfigProvider.BOn;
      if (parama == null) {
        break label615;
      }
      parama = Integer.valueOf(parama.gLM);
      localObject1 = paramRecordConfigProvider.BOn;
      if (localObject1 == null) {
        break label620;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).gLN);
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = this.BTY;
      parama = paramRecordConfigProvider.BOn;
      if (parama == null) {
        break label626;
      }
      parama = parama.gLP;
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = this.BTQ;
      parama = paramRecordConfigProvider.BOn;
      if (parama == null) {
        break label631;
      }
      parama = Integer.valueOf(parama.gLM);
      label276:
      localObject1 = paramRecordConfigProvider.BOn;
      if (localObject1 == null) {
        break label636;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).gLN);
      label297:
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      localObject2 = this.BTU;
      parama = paramRecordConfigProvider.BOn;
      if (parama == null) {
        break label642;
      }
      parama = Integer.valueOf(parama.gLM);
      label328:
      localObject3 = paramRecordConfigProvider.BOn;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).gLN);
      }
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject2).BSs.getFinishButton();
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((Button)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((Button)localObject2).setTextColor(android.support.v4.content.b.n(((Button)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      this.BUa.setScene(paramRecordConfigProvider.scene);
      parama = this.BTR;
      localObject1 = paramRecordConfigProvider.BOn.gLL;
      kotlin.g.b.p.g(localObject1, "configProvider.uiParam.pluginHiddenMap");
      if (!((Map)localObject1).containsKey("plugin_tip")) {
        break label647;
      }
      i = 8;
      label476:
      parama.BQc = i;
      parama = ((Iterable)getPluginList()).iterator();
      label494:
      if (!parama.hasNext()) {
        return;
      }
      localObject1 = (com.tencent.mm.plugin.recordvideo.plugin.t)parama.next();
      localObject2 = paramRecordConfigProvider.BOn;
      if (localObject2 == null) {
        break label652;
      }
      localObject2 = ((UICustomParam)localObject2).gLL;
      if (localObject2 == null) {
        break label652;
      }
      localObject2 = (Boolean)((Map)localObject2).get(((com.tencent.mm.plugin.recordvideo.plugin.t)localObject1).name());
      if (localObject2 == null) {
        break label652;
      }
      bool = ((Boolean)localObject2).booleanValue();
      label568:
      if (bool) {
        break label658;
      }
      i = 1;
      label575:
      if (i == 0) {
        break label663;
      }
    }
    label642:
    label647:
    label652:
    label658:
    label663:
    for (int i = 0;; i = 8)
    {
      ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject1).setVisibility(i);
      break label494;
      parama = null;
      break;
      label597:
      localObject1 = null;
      break label124;
      label603:
      localObject2 = null;
      break label142;
      label609:
      localObject3 = null;
      break label163;
      label615:
      parama = null;
      break label198;
      label620:
      localObject1 = null;
      break label219;
      label626:
      parama = null;
      break label247;
      label631:
      parama = null;
      break label276;
      label636:
      localObject1 = null;
      break label297;
      parama = null;
      break label328;
      i = 0;
      break label476;
      bool = false;
      break label568;
      i = 0;
      break label575;
    }
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    kotlin.g.b.p.h(paramc, "status");
    if (paramc != d.c.BVq) {
      Log.i("MicroMsg.EditorVideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    int k;
    label1003:
    boolean bool;
    label1040:
    label1054:
    int m;
    int n;
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      Log.e("MicroMsg.EditorVideoPluginLayout", "unknown status ".concat(String.valueOf(paramc)));
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  return;
                  this.BTP.setVisibility(4);
                  return;
                  paramBundle = this.BTZ;
                  paramc = paramBundle.BQU;
                  paramBundle = paramBundle.BQU.getContext();
                  kotlin.g.b.p.g(paramBundle, "bgView.context");
                  paramc.setBackgroundColor(paramBundle.getResources().getColor(2131100042));
                  return;
                  paramc = this.BTT;
                  localObject1 = this.BQt;
                  if (localObject1 == null) {
                    kotlin.g.b.p.hyc();
                  }
                  com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject1, this.wdm);
                  this.BTO.setVisibility(0);
                  this.BTP.setVisibility(0);
                  if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP")))
                  {
                    this.BTT.eKP();
                    return;
                    this.BTP.setVisibility(0);
                    paramc = this.BTO;
                    paramBundle = paramc.BQf;
                    if (paramBundle != null) {
                      paramBundle.setVisibility(0);
                    }
                    paramc = paramc.BQg;
                    if (paramc != null)
                    {
                      paramc.setVisibility(0);
                      return;
                      localObject1 = this.BTO;
                      if (paramBundle != null) {}
                      for (paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO"); paramc != null; paramc = null)
                      {
                        paramBundle = ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject1).BQh;
                        kotlin.g.b.p.h(paramc, "emojiInfo");
                        localObject1 = paramBundle.getContext();
                        kotlin.g.b.p.g(localObject1, "context");
                        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f((Context)localObject1);
                        localObject2 = paramBundle.wdm;
                        if (localObject2 != null)
                        {
                          localObject2 = ((RecordConfigProvider)localObject2).BOn;
                          if (localObject2 != null) {
                            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).af(((UICustomParam)localObject2).gLH, ((UICustomParam)localObject2).gLI);
                          }
                        }
                        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                        paramBundle.ruN.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.eIR();
                        localObject3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.eIT());
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.eIS());
                        c.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.c)localObject1, paramBundle.CeT);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.Cfo);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setEmojiInfo(paramc);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).resume();
                        if (paramBundle.Cfa) {
                          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).pause();
                        }
                        paramBundle.t((View)localObject1, true);
                        paramBundle.removeCallbacks(paramBundle.ruT);
                        paramBundle.postDelayed(paramBundle.ruT, 1500L);
                        paramBundle.eMl();
                        return;
                      }
                    }
                  }
                }
              } while (paramBundle == null);
              paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
              i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
              j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
              paramBundle = this.BTO;
              paramc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.q(paramc, i, j, 0, null, 24);
              kotlin.g.b.p.h(paramc, "item");
              if (paramBundle.BQf != null)
              {
                localObject1 = paramBundle.BQf;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setVisibility(0);
                }
                localObject1 = paramBundle.BQf;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setText(paramc);
                }
                paramBundle.BQf = null;
              }
              for (;;)
              {
                paramc = x.SXb;
                return;
                paramBundle = paramBundle.BQh;
                kotlin.g.b.p.h(paramc, "item");
                localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.r(paramBundle.getContext());
                localObject2 = paramBundle.wdm;
                if (localObject2 != null)
                {
                  localObject2 = ((RecordConfigProvider)localObject2).BOn;
                  if (localObject2 != null) {
                    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).af(((UICustomParam)localObject2).gLJ, ((UICustomParam)localObject2).gLK);
                  }
                }
                localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                paramBundle.ruN.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.eIR();
                localObject3 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.eIT());
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.eIS());
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).a(paramBundle.CeT, paramBundle.heightPercent);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.Cfo);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setText(paramc);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setOnClickListener(paramBundle.Cfj);
                paramBundle.t((View)localObject1, true);
                paramBundle.removeCallbacks(paramBundle.ruT);
                paramBundle.postDelayed(paramBundle.ruT, 1500L);
                paramBundle.eMl();
              }
            } while (paramBundle == null);
            paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
            j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
            k = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
            if ((paramc == null) || (paramc.length() == 0))
            {
              i = 1;
              if (i == 0) {
                break label1054;
              }
              this.BTO.BQh.eMm();
              j = this.BTO.BQh.getLocationItemHeight();
              if (j != 0) {
                break label1040;
              }
              i = 0;
              k = at.fromDPToPix(getContext(), 44);
              this.BTR.VD(i + j + k);
            }
            for (;;)
            {
              paramc = x.SXb;
              return;
              i = 0;
              break;
              i = at.fromDPToPix(getContext(), 24);
              break label1003;
              this.BTO.ay(paramc.toString(), j, k);
            }
          } while (paramBundle == null);
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          com.tencent.mm.plugin.recordvideo.plugin.c.a(this.BTQ, paramc, i, j);
          paramc = x.SXb;
          return;
        } while (paramBundle == null);
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramBundle = this.BTR;
        paramBundle.BPY.mode = 1;
        paramBundle.BPY.setShow(true);
        paramBundle.BPY.g(paramc, i, j);
        paramc = x.SXb;
        return;
      } while (paramBundle == null);
      bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
      paramc = this.BTM;
      if (paramc == null) {
        kotlin.g.b.p.btv("previewPlugin");
      }
      paramc.zyd.setMute(bool);
      paramc = x.SXb;
      return;
    case 15: 
      this.BTU.tg(true);
      return;
    case 16: 
      this.BTP.setVisibility(4);
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", false);
        paramc = this.BTM;
        if (paramc == null) {
          kotlin.g.b.p.btv("previewPlugin");
        }
        paramc.BRc = true;
        paramBundle = paramc.zyd.getParent();
        if (paramBundle == null) {
          throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        m = ((ViewGroup)paramBundle).getWidth();
        paramBundle = paramc.zyd.getParent();
        if (paramBundle == null) {
          throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        n = ((ViewGroup)paramBundle).getHeight();
        j = com.tencent.mm.cb.a.fromDPToPix(paramc.context, 20) + com.tencent.mm.cb.a.fromDPToPix(paramc.context, 95) + com.tencent.mm.cb.a.fromDPToPix(paramc.context, 12);
        if (!au.aA(paramc.context)) {
          break label2829;
        }
        j += au.aD(paramc.context);
      }
      break;
    }
    label2829:
    for (;;)
    {
      i = 0;
      if (bool)
      {
        i = com.tencent.mm.cb.a.fromDPToPix(paramc.context, 56) + 0;
        if (ao.aQ(paramc.context))
        {
          Log.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is true，videoViewTopMargin: " + i + ", cutout height is " + ao.aP(paramc.context));
          i += ao.aP(paramc.context);
        }
      }
      for (;;)
      {
        paramBundle = paramc.zyd.getParent();
        if (paramBundle != null) {
          break;
        }
        throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        Log.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is false");
      }
      if (((ViewGroup)paramBundle).getBottom() + j < com.tencent.mm.plugin.mmsight.d.gx(paramc.context).y) {}
      for (k = (int)((m - com.tencent.mm.cb.a.fromDPToPix(paramc.context, 32) * 2) / (m / n));; k = n - j - i)
      {
        int i1 = (int)(m / n * k);
        float f1 = i1 / m;
        float f2 = k / n;
        float f3 = -(Math.abs(j - i) / 2.0F);
        Log.i("MicroMsg.EditVideoPlayPlugin", "scaleX: " + f1 + ", scaleY: " + f2 + ", translationY: " + f3);
        Log.i("MicroMsg.EditVideoPlayPlugin", "isShowWeseeBtn: " + bool + ", videoViewWidth: " + m + ", videoViewHeight: " + n + ", videoViewBottomMargin:" + j + ", videoViewTopMargin:" + i + ", videoViewScaleHeight: " + k + ", videoViewScaleWidth: " + i1);
        paramBundle = paramc.zyd.getParent();
        if (paramBundle == null) {
          throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)paramBundle).animate().scaleX(f1).scaleY(f2).translationY(f3).setDuration(300L).setListener((Animator.AnimatorListener)new s.b(paramc));
        paramc = x.SXb;
        this.BTO.BQh.setEnableTouch(false);
        paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramc = this.BTM;
        if (paramc == null) {
          kotlin.g.b.p.btv("previewPlugin");
        }
        paramc.dvv = i;
        paramc.iqg = j;
        paramc.zyd.d(paramc.dvv, true);
        paramc = x.SXb;
        return;
        paramc = this.BTM;
        if (paramc == null) {
          kotlin.g.b.p.btv("previewPlugin");
        }
        paramc.onPause();
        return;
        paramc = this.BTM;
        if (paramc == null) {
          kotlin.g.b.p.btv("previewPlugin");
        }
        paramc.onResume();
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.BTM;
        if (paramc == null) {
          kotlin.g.b.p.btv("previewPlugin");
        }
        paramc.zyd.d(i, true);
        paramc = x.SXb;
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.BTU;
        if (paramc.BSs.getVisibility() == 0)
        {
          paramc = paramc.BSs;
          paramc.zDX.setCurrentCursorPosition(i / paramc.zDX.getDurationMs());
        }
        paramc = x.SXb;
        return;
        paramc = this.BQt;
        if (paramc == null) {
          break;
        }
        paramBundle = this.wdm;
        if (paramBundle != null) {
          i = paramBundle.BOv;
        }
        while (paramc.iqg - paramc.dvv > i + 250)
        {
          paramc = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.ax(2, 3L);
          paramc = getContext();
          if (paramc == null)
          {
            throw new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            i = 10000;
          }
          else
          {
            ((Activity)paramc).setResult(3000);
            paramc = getContext();
            if (paramc == null) {
              throw new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            }
            ((Activity)paramc).finish();
            return;
          }
        }
        this.BTP.setVisibility(0);
        paramc = this.BTM;
        if (paramc == null) {
          kotlin.g.b.p.btv("previewPlugin");
        }
        paramc.tc(false);
        this.BTO.eKt();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        paramc = x.SXb;
        return;
        this.BTP.setVisibility(0);
        this.BTT.eKP();
        paramc = this.BTM;
        if (paramc == null) {
          kotlin.g.b.p.btv("previewPlugin");
        }
        paramc.tc(true);
        this.BTO.eKt();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        paramc = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.ax(2, 3L);
        onBackPress();
        return;
        if (paramBundle == null) {
          break;
        }
        paramBundle = paramBundle.getByteArray("PARAM_EDIT_POI_INFO");
        paramc = this.BTO;
        paramBundle = new dlg().parseFrom(paramBundle);
        if (paramBundle == null) {
          throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecordLocationInfo");
        }
        paramBundle = (dlg)paramBundle;
        kotlin.g.b.p.h(paramBundle, "storyLocation");
        if ((!Util.isNullOrNil(paramBundle.kHV)) || (!Util.isNullOrNil(paramBundle.kea)))
        {
          i = 1;
          if (i == 0) {
            break label2502;
          }
          if (!paramc.BQh.eMo()) {
            break label2491;
          }
          paramc = paramc.BQh;
          kotlin.g.b.p.h(paramBundle, "sl");
          if (paramc.Cff != null)
          {
            paramc.ab((kotlin.g.a.a)EditorItemContainer.e.Cfs);
            paramc.a(paramBundle);
          }
          label2424:
          j = this.BTO.BQh.getLocationItemHeight();
          if (j != 0) {
            break label2528;
          }
        }
        label2491:
        label2502:
        label2528:
        for (i = 0;; i = at.fromDPToPix(getContext(), 24))
        {
          k = at.fromDPToPix(getContext(), 44);
          if (!this.BTO.eKq()) {
            this.BTR.VD(i + j + k);
          }
          paramc = x.SXb;
          return;
          i = 0;
          break;
          paramc.BQh.a(paramBundle);
          break label2424;
          if (!paramc.BQh.eMo()) {
            break label2424;
          }
          paramc.BQh.ab((kotlin.g.a.a)h.a.BQj);
          break label2424;
        }
        this.BTS.eKn();
        return;
        if (paramBundle == null) {
          break;
        }
        bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
        paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
        paramc = new ArrayList();
        if (paramBundle != null)
        {
          paramBundle = ((Iterable)paramBundle.BPI).iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject2 = (byte[])paramBundle.next();
              localObject1 = new ckm();
              localObject3 = (com.tencent.mm.bw.a)localObject1;
              try
              {
                ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject2);
                paramc.add(localObject1);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printDebugStack("safeParser", "", new Object[] { localException });
                }
              }
            }
          }
          paramBundle = x.SXb;
        }
        paramBundle = this.BTO;
        paramc = (List)paramc;
        kotlin.g.b.p.h(paramc, "lyricsInfo");
        if (bool) {
          if (paramBundle.BQh.Cfg != null)
          {
            i = 1;
            if (i == 0) {
              break label2759;
            }
            paramBundle = paramBundle.BQh;
            kotlin.g.b.p.h(paramc, "lyricsItemInfos");
            if (paramBundle.Cfg != null)
            {
              paramBundle.eMn();
              paramBundle.gl(paramc);
            }
          }
        }
        for (;;)
        {
          paramc = x.SXb;
          return;
          i = 0;
          break;
          label2759:
          paramBundle.BQh.gl(paramc);
          continue;
          paramBundle.BQh.eMn();
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ChB.ordinal()) {
          this.BTT.wgL.tw(false);
        }
        paramc = x.SXb;
        return;
      }
    }
  }
  
  protected final void aLt(final String paramString)
  {
    kotlin.g.b.p.h(paramString, "tip");
    Log.i("MicroMsg.EditorVideoPluginLayout", "showDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, paramString));
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a getAddEmojiPlugin()
  {
    return this.BTN;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a.a getAddMusicPlugin()
  {
    return this.BTT;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.b getAddPoiPlugin()
  {
    return this.BTS;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.c getAddTextPlugin()
  {
    return this.BTQ;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.d getAddTipPlugin()
  {
    return this.BTR;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.p getAddonTextPlugin()
  {
    return this.BTY;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.e getBackToRecordPlugin()
  {
    return this.BTW;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.q getBgPlugin()
  {
    return this.BTZ;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.BQt;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.wdm;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a getCropVideoPlugin()
  {
    return this.BTU;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.f getEditFinishPlugin()
  {
    return this.BTV;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.g getInputPlugin()
  {
    return this.BUb;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.h getItemContainerPlugin()
  {
    return this.BTO;
  }
  
  public int getLayoutId()
  {
    return 2131496795;
  }
  
  protected final i getMoreMenuPlugin()
  {
    return this.BUa;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.activity.a getNavigator()
  {
    return this.wdl;
  }
  
  public abstract View getPlayerView();
  
  public final com.tencent.mm.plugin.recordvideo.plugin.s getPreviewPlugin()
  {
    com.tencent.mm.plugin.recordvideo.plugin.s locals = this.BTM;
    if (locals == null) {
      kotlin.g.b.p.btv("previewPlugin");
    }
    return locals;
  }
  
  protected final ab getReMuxPlugin()
  {
    return this.BTX;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.r getVideoControlContainerPlugin()
  {
    return this.BTP;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.BQt = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.wdm = paramRecordConfigProvider;
  }
  
  protected final void setNavigator(com.tencent.mm.plugin.recordvideo.activity.a parama)
  {
    this.wdl = parama;
  }
  
  protected final void setPreviewPlugin(com.tencent.mm.plugin.recordvideo.plugin.s params)
  {
    kotlin.g.b.p.h(params, "<set-?>");
    this.BTM = params;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(75762);
      com.tencent.mm.ui.base.q localq = BaseEditVideoPluginLayout.a(this.BUd);
      if (localq != null) {
        localq.dismiss();
      }
      BaseEditVideoPluginLayout.a(this.BUd, null);
      AppMethodBeat.o(75762);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(75763);
      BaseEditVideoPluginLayout.a(this.BUd, com.tencent.mm.ui.base.h.a(this.BUd.getContext(), paramString, false, null));
      AppMethodBeat.o(75763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */