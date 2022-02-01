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
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ac;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.i.a;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.plugin.recordvideo.plugin.t.b;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "getAddMusicPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "getAddPoiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "getAddTipPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "getAddonTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "getBgPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "getCropVideoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "getInputPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "getItemContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "moreMenuPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "getMoreMenuPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getNavigator", "()Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "setNavigator", "(Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;)V", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;)V", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "getReMuxPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getVideoControlContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getLayoutId", "", "getPlayerView", "Landroid/view/View;", "hideDialog", "", "initLogic", "initSafeArea", "loadCurrentPage", "info", "loadPlayerView", "showDialog", "tip", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public abstract class BaseEditVideoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final a HQN = new a((byte)0);
  private com.tencent.mm.plugin.recordvideo.activity.a ALU;
  private RecordConfigProvider ALV;
  private com.tencent.mm.media.widget.camerarecordview.b.b HNh;
  private final com.tencent.mm.plugin.recordvideo.plugin.s HQA;
  private final com.tencent.mm.plugin.recordvideo.plugin.d HQB;
  private final com.tencent.mm.plugin.recordvideo.plugin.e HQC;
  private final com.tencent.mm.plugin.recordvideo.plugin.c HQD;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a HQE;
  private final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a HQF;
  private final com.tencent.mm.plugin.recordvideo.plugin.g HQG;
  private final com.tencent.mm.plugin.recordvideo.plugin.f HQH;
  private final ac HQI;
  private final q HQJ;
  private final com.tencent.mm.plugin.recordvideo.plugin.r HQK;
  private final com.tencent.mm.plugin.recordvideo.plugin.j HQL;
  private final com.tencent.mm.plugin.recordvideo.plugin.h HQM;
  protected com.tencent.mm.plugin.recordvideo.plugin.t HQx;
  private final com.tencent.mm.plugin.recordvideo.plugin.b HQy;
  private final i HQz;
  private com.tencent.mm.ui.base.s oTk;
  
  public BaseEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.HQI = new ac(paramContext);
    Log.i("MicroMsg.EditorVideoPluginLayout", "EditorVideoPluginLayoutNew invoke init");
    LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    paramContext = getPlayerView();
    paramAttributeSet = (ViewStub)findViewById(b.e.place_holder);
    p.j(paramAttributeSet, "placeholder");
    Object localObject = paramAttributeSet.getParent();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    int i = ((ViewGroup)localObject).indexOfChild((View)paramAttributeSet);
    ((ViewGroup)localObject).removeViewAt(i);
    ((ViewGroup)localObject).addView(paramContext, i, new ViewGroup.LayoutParams(-1, -1));
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(b.e.editor_add_emoji);
    p.j(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.HQy = new com.tencent.mm.plugin.recordvideo.plugin.b(paramContext, (ImageView)paramAttributeSet, (d)this);
    paramContext = findViewById(b.e.editor_item_container);
    p.j(paramContext, "findViewById(R.id.editor_item_container)");
    this.HQz = new i((EditorItemContainer)paramContext, (d)this);
    paramContext = findViewById(b.e.control_container);
    p.j(paramContext, "findViewById(R.id.control_container)");
    this.HQA = new com.tencent.mm.plugin.recordvideo.plugin.s((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(b.e.change_text_root);
    p.j(paramContext, "findViewById(R.id.change_text_root)");
    this.HQM = new com.tencent.mm.plugin.recordvideo.plugin.h((EditorInputView)paramContext, (d)this);
    this.HQB = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (d)this, this.HQM.HMM);
    this.HQE = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (d)this);
    this.HQF = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a((ViewGroup)this, (d)this);
    paramContext = findViewById(b.e.editor_mix);
    p.j(paramContext, "findViewById(R.id.editor_mix)");
    this.HQG = new com.tencent.mm.plugin.recordvideo.plugin.g(paramContext, (d)this);
    paramContext = findViewById(b.e.editor_close);
    p.j(paramContext, "findViewById(R.id.editor_close)");
    this.HQH = new com.tencent.mm.plugin.recordvideo.plugin.f((ImageView)paramContext, (d)this);
    paramContext = findViewById(b.e.ext_text_area);
    p.j(paramContext, "findViewById(R.id.ext_text_area)");
    this.HQJ = new q((TextView)paramContext, (d)this);
    paramContext = findViewById(b.e.recorder_black_mask);
    p.j(paramContext, "findViewById(R.id.recorder_black_mask)");
    this.HQK = new com.tencent.mm.plugin.recordvideo.plugin.r((ImageView)paramContext, (d)this);
    this.HQC = new com.tencent.mm.plugin.recordvideo.plugin.e((ViewGroup)this, (d)this, this.HQM.HMM);
    this.HQD = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this);
    this.HQL = new com.tencent.mm.plugin.recordvideo.plugin.j((ViewGroup)this, (d)this);
    getPluginList().add(this.HQy);
    getPluginList().add(this.HQz);
    getPluginList().add(this.HQA);
    getPluginList().add(this.HQB);
    getPluginList().add(this.HQE);
    getPluginList().add(this.HQF);
    getPluginList().add(this.HQG);
    getPluginList().add(this.HQI);
    getPluginList().add(this.HQH);
    getPluginList().add(this.HQJ);
    getPluginList().add(this.HQK);
    getPluginList().add(this.HQC);
    getPluginList().add(this.HQD);
    getPluginList().add(this.HQL);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.HLt;
    i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.HLt;
    int j = com.tencent.mm.plugin.recordvideo.model.a.fvZ();
    float f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = j * 1.78F;
    float f5 = (i - f4) / 2.0F;
    if (f1 <= 1.78F)
    {
      this.HQM.bR(f3);
      this.HQz.ae(f2, f3);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.HQM.bS(f3);
      this.HQz.af(f4, f5);
      return;
    }
    this.HQM.bR(f3);
    this.HQM.bS(f3);
    this.HQz.ae(f2, f3);
    this.HQz.af(f4, f5);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    super.a(paramb);
    this.HNh = paramb;
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    this.ALU = parama;
    this.ALV = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    com.tencent.mm.plugin.recordvideo.e.d.g(paramRecordConfigProvider);
    parama = this.HQz;
    p.k(paramRecordConfigProvider, "configProvider");
    parama = parama.HMV;
    p.k(paramRecordConfigProvider, "configProvider");
    parama.ALV = paramRecordConfigProvider;
    this.HQE.setVisibility(0);
    this.HQF.setVisibility(0);
    com.tencent.mm.plugin.recordvideo.plugin.g localg = this.HQG;
    parama = paramRecordConfigProvider.HKT;
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
      parama = Integer.valueOf(parama.jwb);
      localObject1 = paramRecordConfigProvider.HKT;
      if (localObject1 == null) {
        break label562;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).jwc);
      localObject2 = paramRecordConfigProvider.HKT;
      if (localObject2 == null) {
        break label568;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.HKT;
      if (localObject3 == null) {
        break label574;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).jwd);
      localg.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.HQE;
      parama = paramRecordConfigProvider.HKT;
      if (parama == null) {
        break label580;
      }
      parama = Integer.valueOf(parama.jwb);
      localObject1 = paramRecordConfigProvider.HKT;
      if (localObject1 == null) {
        break label585;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).jwc);
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = this.HQJ;
      parama = paramRecordConfigProvider.HKT;
      if (parama == null) {
        break label591;
      }
      parama = parama.jwe;
      ((q)localObject1).setText(parama);
      localObject2 = this.HQB;
      parama = paramRecordConfigProvider.HKT;
      if (parama == null) {
        break label596;
      }
      parama = Integer.valueOf(parama.jwb);
      label276:
      localObject1 = paramRecordConfigProvider.HKT;
      if (localObject1 == null) {
        break label601;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).jwc);
      label297:
      ((com.tencent.mm.plugin.recordvideo.plugin.d)localObject2).a(parama, (Integer)localObject1);
      localObject2 = this.HQF;
      parama = paramRecordConfigProvider.HKT;
      if (parama == null) {
        break label607;
      }
      parama = Integer.valueOf(parama.jwb);
      label328:
      localObject3 = paramRecordConfigProvider.HKT;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).jwc);
      }
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject2).HPh.getFinishButton();
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((Button)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((Button)localObject2).setTextColor(androidx.core.content.a.w(((Button)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      this.HQL.setScene(paramRecordConfigProvider.scene);
      parama = ((Iterable)getPluginList()).iterator();
      label451:
      if (!parama.hasNext()) {
        return;
      }
      localObject1 = (u)parama.next();
      localObject2 = paramRecordConfigProvider.HKT;
      if (localObject2 == null) {
        break label612;
      }
      localObject2 = ((UICustomParam)localObject2).jwa;
      if (localObject2 == null) {
        break label612;
      }
      localObject3 = com.tencent.mm.plugin.recordvideo.e.j.Ifp;
      localObject2 = (Boolean)((Map)localObject2).get(com.tencent.mm.plugin.recordvideo.e.j.aWw(((u)localObject1).name()));
      if (localObject2 == null) {
        break label612;
      }
      bool = ((Boolean)localObject2).booleanValue();
      label533:
      if (bool) {
        break label618;
      }
      i = 1;
      label540:
      if (i == 0) {
        break label623;
      }
    }
    label562:
    label568:
    label574:
    label580:
    label585:
    label591:
    label596:
    label601:
    label607:
    label612:
    label618:
    label623:
    for (int i = 0;; i = 8)
    {
      ((u)localObject1).setVisibility(i);
      break label451;
      parama = null;
      break;
      localObject1 = null;
      break label124;
      localObject2 = null;
      break label142;
      localObject3 = null;
      break label163;
      parama = null;
      break label198;
      localObject1 = null;
      break label219;
      parama = null;
      break label247;
      parama = null;
      break label276;
      localObject1 = null;
      break label297;
      parama = null;
      break label328;
      bool = false;
      break label533;
      i = 0;
      break label540;
    }
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    p.k(paramc, "status");
    if (paramc != d.c.HSe) {
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
    label1316:
    int m;
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
                  this.HQA.setVisibility(4);
                  return;
                  paramBundle = this.HQK;
                  paramc = paramBundle.zpB;
                  paramBundle = paramBundle.zpB.getContext();
                  p.j(paramBundle, "bgView.context");
                  paramc.setBackgroundColor(paramBundle.getResources().getColor(b.b.black));
                  return;
                  paramc = this.HQE;
                  localObject1 = this.HNh;
                  if (localObject1 == null) {
                    p.iCn();
                  }
                  com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject1, this.ALV);
                  this.HQz.setVisibility(0);
                  this.HQA.setVisibility(0);
                  if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP")))
                  {
                    this.HQE.fxj();
                    return;
                    this.HQA.setVisibility(0);
                    paramc = this.HQz;
                    paramBundle = paramc.HMT;
                    if (paramBundle != null) {
                      paramBundle.setVisibility(0);
                    }
                    paramc = paramc.HMU;
                    if (paramc != null)
                    {
                      paramc.setVisibility(0);
                      return;
                      localObject1 = this.HQz;
                      if (paramBundle != null) {}
                      for (paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO"); paramc != null; paramc = null)
                      {
                        paramBundle = ((i)localObject1).HMV;
                        p.k(paramc, "emojiInfo");
                        localObject1 = paramBundle.getContext();
                        p.j(localObject1, "context");
                        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f((Context)localObject1);
                        localObject2 = paramBundle.ALV;
                        if (localObject2 != null)
                        {
                          localObject2 = ((RecordConfigProvider)localObject2).HKT;
                          if (localObject2 != null) {
                            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).ah(((UICustomParam)localObject2).jvW, ((UICustomParam)localObject2).jvX);
                          }
                        }
                        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                        paramBundle.var.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.fuV();
                        localObject3 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.fuX());
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.fuW());
                        c.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.c)localObject1, paramBundle.IbP);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.Ick);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setEmojiInfo(paramc);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).resume();
                        if (paramBundle.IbW) {
                          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).pause();
                        }
                        paramBundle.v((View)localObject1, true);
                        paramBundle.removeCallbacks(paramBundle.vax);
                        paramBundle.postDelayed(paramBundle.vax, 1500L);
                        paramBundle.fyH();
                        return;
                      }
                    }
                  }
                }
              } while (paramBundle == null);
              paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
              i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
              j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
              paramBundle = this.HQz;
              paramc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.r(paramc, i, j, 0, null, 24);
              p.k(paramc, "item");
              if (paramBundle.HMT != null)
              {
                localObject1 = paramBundle.HMT;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setVisibility(0);
                }
                localObject1 = paramBundle.HMT;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setText(paramc);
                }
                paramBundle.HMT = null;
              }
              for (;;)
              {
                paramc = x.aazN;
                return;
                paramBundle = paramBundle.HMV;
                p.k(paramc, "item");
                localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramBundle.getContext());
                localObject2 = paramBundle.ALV;
                if (localObject2 != null)
                {
                  localObject2 = ((RecordConfigProvider)localObject2).HKT;
                  if (localObject2 != null) {
                    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).ah(((UICustomParam)localObject2).jvY, ((UICustomParam)localObject2).jvZ);
                  }
                }
                localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                paramBundle.var.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.fuV();
                localObject3 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.fuX());
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.fuW());
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).a(paramBundle.IbP, paramBundle.heightPercent);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.Ick);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setText(paramc);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setOnClickListener(paramBundle.Icf);
                paramBundle.v((View)localObject1, true);
                paramBundle.removeCallbacks(paramBundle.vax);
                paramBundle.postDelayed(paramBundle.vax, 1500L);
                paramBundle.fyH();
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
              this.HQz.HMV.fyI();
              j = this.HQz.HMV.getLocationItemHeight();
              if (j != 0) {
                break label1040;
              }
              i = 0;
              k = aw.fromDPToPix(getContext(), 44);
              this.HQC.acm(i + j + k);
            }
            for (;;)
            {
              paramc = x.aazN;
              return;
              i = 0;
              break;
              i = aw.fromDPToPix(getContext(), 24);
              break label1003;
              this.HQz.aB(paramc.toString(), j, k);
            }
          } while (paramBundle == null);
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          com.tencent.mm.plugin.recordvideo.plugin.d.a(this.HQB, paramc, i, j);
          paramc = x.aazN;
          return;
        } while (paramBundle == null);
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramBundle = this.HQC;
        paramBundle.HMM.mode = 1;
        paramBundle.HMM.setShow(true);
        paramBundle.HMM.g(paramc, i, j);
        paramc = x.aazN;
        return;
      } while (paramBundle == null);
      bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
      paramc = this.HQx;
      if (paramc == null) {
        p.bGy("previewPlugin");
      }
      paramc = paramc.Fdy;
      if (paramc != null) {
        paramc.setMute(bool);
      }
      paramc = x.aazN;
      return;
    case 15: 
      this.HQF.wC(true);
      return;
    case 16: 
      this.HQA.setVisibility(4);
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", false);
        paramc = this.HQx;
        if (paramc == null) {
          p.bGy("previewPlugin");
        }
        paramc.HNR = true;
        paramBundle = paramc.fwW();
        if (paramBundle == null) {
          break label1794;
        }
        j = paramBundle.getWidth();
        label1301:
        paramBundle = paramc.fwW();
        if (paramBundle == null) {
          break label1800;
        }
        k = paramBundle.getHeight();
        m = com.tencent.mm.ci.a.fromDPToPix(paramc.context, 20) + com.tencent.mm.ci.a.fromDPToPix(paramc.context, 95) + com.tencent.mm.ci.a.fromDPToPix(paramc.context, 12);
        if (!ax.av(paramc.context)) {
          break label2831;
        }
        m += ax.aB(paramc.context);
      }
      break;
    }
    label1794:
    label1800:
    label2831:
    for (;;)
    {
      i = 0;
      if (bool)
      {
        i = com.tencent.mm.ci.a.fromDPToPix(paramc.context, 56) + 0;
        if (ar.aN(paramc.context))
        {
          Log.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is true，videoViewTopMargin: " + i + ", cutout height is " + ar.aM(paramc.context));
          i += ar.aM(paramc.context);
        }
      }
      else
      {
        label1452:
        paramBundle = paramc.fwW();
        if (paramBundle == null) {
          break label1818;
        }
        n = paramBundle.getBottom();
        label1467:
        if (n >= com.tencent.mm.plugin.mmsight.d.hv(paramc.context).y) {
          break label2818;
        }
      }
      for (int n = (int)((j - com.tencent.mm.ci.a.fromDPToPix(paramc.context, 32) * 2) / (j / k));; n = k - m - i)
      {
        int i1 = (int)(j / k * n);
        float f1 = i1 / j;
        float f2 = n / k;
        float f3 = -(Math.abs(m - i) / 2.0F);
        Log.i("MicroMsg.EditVideoPlayPlugin", "scaleX: " + f1 + ", scaleY: " + f2 + ", translationY: " + f3);
        Log.i("MicroMsg.EditVideoPlayPlugin", "isShowWeseeBtn: " + bool + ", videoViewWidth: " + j + ", videoViewHeight: " + k + ", videoViewBottomMargin:" + m + ", videoViewTopMargin:" + i + ", videoViewScaleHeight: " + n + ", videoViewScaleWidth: " + i1);
        paramBundle = paramc.fwW();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.animate();
          if (paramBundle != null)
          {
            paramBundle = paramBundle.scaleX(f1);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.scaleY(f2);
              if (paramBundle != null)
              {
                paramBundle = paramBundle.translationY(f3);
                if (paramBundle != null)
                {
                  paramBundle = paramBundle.setDuration(300L);
                  if (paramBundle != null) {
                    paramBundle.setListener((Animator.AnimatorListener)new t.b(paramc));
                  }
                }
              }
            }
          }
        }
        paramc = x.aazN;
        this.HQz.fwK();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        j = 0;
        break label1301;
        k = 0;
        break label1316;
        Log.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is false");
        break label1452;
        label1818:
        n = m + 0;
        break label1467;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramc = this.HQx;
        if (paramc == null) {
          p.bGy("previewPlugin");
        }
        paramc.fod = i;
        paramc.endTime = j;
        paramBundle = paramc.Fdy;
        if (paramBundle != null) {
          paramBundle.b(paramc.fod, true);
        }
        paramc = x.aazN;
        return;
        paramc = this.HQx;
        if (paramc == null) {
          p.bGy("previewPlugin");
        }
        paramc.onPause();
        return;
        paramc = this.HQx;
        if (paramc == null) {
          p.bGy("previewPlugin");
        }
        paramc.onResume();
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.HQx;
        if (paramc == null) {
          p.bGy("previewPlugin");
        }
        paramc = paramc.Fdy;
        if (paramc != null) {
          paramc.b(i, true);
        }
        paramc = x.aazN;
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.HQF;
        if (paramc.HPh.getVisibility() == 0)
        {
          paramc = paramc.HPh;
          paramc.FiW.setCurrentCursorPosition(i / paramc.FiW.getDurationMs());
        }
        paramc = x.aazN;
        return;
        paramc = this.HNh;
        if (paramc == null) {
          break;
        }
        paramBundle = this.ALV;
        if (paramBundle != null) {
          i = paramBundle.HLb;
        }
        while (paramc.endTime - paramc.fod > i + 250)
        {
          paramc = com.tencent.mm.plugin.recordvideo.d.g.HUM;
          com.tencent.mm.plugin.recordvideo.d.g.aJ(2, 3L);
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
        this.HQA.setVisibility(0);
        paramc = this.HQx;
        if (paramc == null) {
          p.bGy("previewPlugin");
        }
        paramc.wy(false);
        this.HQz.fwL();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        paramc = x.aazN;
        return;
        this.HQA.setVisibility(0);
        this.HQE.fxj();
        paramc = this.HQx;
        if (paramc == null) {
          p.bGy("previewPlugin");
        }
        paramc.wy(true);
        this.HQz.fwL();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        paramc = com.tencent.mm.plugin.recordvideo.d.g.HUM;
        com.tencent.mm.plugin.recordvideo.d.g.aJ(2, 3L);
        onBackPress();
        return;
        if (paramBundle == null) {
          break;
        }
        paramBundle = paramBundle.getByteArray("PARAM_EDIT_POI_INFO");
        paramc = this.HQz;
        paramBundle = new duy().parseFrom(paramBundle);
        if (paramBundle == null) {
          throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecordLocationInfo");
        }
        paramBundle = (duy)paramBundle;
        p.k(paramBundle, "storyLocation");
        if ((!Util.isNullOrNil(paramBundle.poiName)) || (!Util.isNullOrNil(paramBundle.mVA)))
        {
          i = 1;
          if (i == 0) {
            break label2504;
          }
          if (!paramc.HMV.fyK()) {
            break label2493;
          }
          paramc = paramc.HMV;
          p.k(paramBundle, "sl");
          if (paramc.Icb != null)
          {
            paramc.ae((kotlin.g.a.a)EditorItemContainer.e.Ico);
            paramc.a(paramBundle);
          }
          label2426:
          j = this.HQz.HMV.getLocationItemHeight();
          if (j != 0) {
            break label2530;
          }
        }
        label2493:
        label2504:
        label2530:
        for (i = 0;; i = aw.fromDPToPix(getContext(), 24))
        {
          k = aw.fromDPToPix(getContext(), 44);
          if (!this.HQz.fwH()) {
            this.HQC.acm(i + j + k);
          }
          paramc = x.aazN;
          return;
          i = 0;
          break;
          paramc.HMV.a(paramBundle);
          break label2426;
          if (!paramc.HMV.fyK()) {
            break label2426;
          }
          paramc.HMV.ae((kotlin.g.a.a)i.a.HMX);
          break label2426;
        }
        this.HQD.fwF();
        return;
        if (paramBundle == null) {
          break;
        }
        bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
        paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
        paramc = new ArrayList();
        if (paramBundle != null)
        {
          paramBundle = ((Iterable)paramBundle.HMu).iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject2 = (byte[])paramBundle.next();
              localObject1 = new ctg();
              localObject3 = (com.tencent.mm.cd.a)localObject1;
              try
              {
                ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject2);
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
          paramBundle = x.aazN;
        }
        paramBundle = this.HQz;
        paramc = (List)paramc;
        p.k(paramc, "lyricsInfo");
        if (bool) {
          if (paramBundle.HMV.Icc != null)
          {
            i = 1;
            if (i == 0) {
              break label2761;
            }
            paramBundle = paramBundle.HMV;
            p.k(paramc, "lyricsItemInfos");
            if (paramBundle.Icc != null)
            {
              paramBundle.fyJ();
              paramBundle.gR(paramc);
            }
          }
        }
        for (;;)
        {
          paramc = x.aazN;
          return;
          i = 0;
          break;
          label2761:
          paramBundle.HMV.gR(paramc);
          continue;
          paramBundle.HMV.fyJ();
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Ier.ordinal()) {
          this.HQE.AQb.wT(false);
        }
        paramc = x.aazN;
        return;
      }
    }
  }
  
  public final void a(u paramu)
  {
    p.k(paramu, "plugin");
    p.k(paramu, "plugin");
  }
  
  protected final void aVX(final String paramString)
  {
    p.k(paramString, "tip");
    Log.i("MicroMsg.EditorVideoPluginLayout", "showDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, paramString));
  }
  
  public final void epj()
  {
    if (this.oTk == null) {
      return;
    }
    Log.i("MicroMsg.EditorVideoPluginLayout", "hideDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new kotlin.t("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread((Runnable)new b(this));
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.b getAddEmojiPlugin()
  {
    return this.HQy;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a.a getAddMusicPlugin()
  {
    return this.HQE;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.c getAddPoiPlugin()
  {
    return this.HQD;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.d getAddTextPlugin()
  {
    return this.HQB;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.e getAddTipPlugin()
  {
    return this.HQC;
  }
  
  protected final q getAddonTextPlugin()
  {
    return this.HQJ;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.f getBackToRecordPlugin()
  {
    return this.HQH;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.r getBgPlugin()
  {
    return this.HQK;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.HNh;
  }
  
  public final RecordConfigProvider getConfigProvider()
  {
    return this.ALV;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a getCropVideoPlugin()
  {
    return this.HQF;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.g getEditFinishPlugin()
  {
    return this.HQG;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.h getInputPlugin()
  {
    return this.HQM;
  }
  
  protected final i getItemContainerPlugin()
  {
    return this.HQz;
  }
  
  public int getLayoutId()
  {
    return b.f.video_edit_plugin_layout_new;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.j getMoreMenuPlugin()
  {
    return this.HQL;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.activity.a getNavigator()
  {
    return this.ALU;
  }
  
  public abstract View getPlayerView();
  
  public final com.tencent.mm.plugin.recordvideo.plugin.t getPreviewPlugin()
  {
    com.tencent.mm.plugin.recordvideo.plugin.t localt = this.HQx;
    if (localt == null) {
      p.bGy("previewPlugin");
    }
    return localt;
  }
  
  protected final ac getReMuxPlugin()
  {
    return this.HQI;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.s getVideoControlContainerPlugin()
  {
    return this.HQA;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.HNh = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.ALV = paramRecordConfigProvider;
  }
  
  protected final void setNavigator(com.tencent.mm.plugin.recordvideo.activity.a parama)
  {
    this.ALU = parama;
  }
  
  protected final void setPreviewPlugin(com.tencent.mm.plugin.recordvideo.plugin.t paramt)
  {
    p.k(paramt, "<set-?>");
    this.HQx = paramt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(75762);
      com.tencent.mm.ui.base.s locals = BaseEditVideoPluginLayout.a(this.HQO);
      if (locals != null) {
        locals.dismiss();
      }
      BaseEditVideoPluginLayout.a(this.HQO, null);
      AppMethodBeat.o(75762);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(75763);
      BaseEditVideoPluginLayout.a(this.HQO, com.tencent.mm.ui.base.h.a(this.HQO.getContext(), paramString, false, null));
      AppMethodBeat.o(75763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */