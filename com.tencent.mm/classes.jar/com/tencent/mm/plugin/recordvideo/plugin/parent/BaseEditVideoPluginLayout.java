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
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.h.a;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.s.b;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "getAddMusicPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "getAddPoiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "getAddTipPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "getAddonTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "getBgPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "getCropVideoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "getInputPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "getItemContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "moreMenuPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "getMoreMenuPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getNavigator", "()Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "setNavigator", "(Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;)V", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;)V", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "getReMuxPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getVideoControlContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getLayoutId", "", "getPlayerView", "Landroid/view/View;", "hideDialog", "", "initLogic", "initSafeArea", "loadCurrentPage", "info", "loadPlayerView", "showDialog", "tip", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public abstract class BaseEditVideoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final BaseEditVideoPluginLayout.a xTD = new BaseEditVideoPluginLayout.a((byte)0);
  public com.tencent.mm.ui.base.p mHs;
  private com.tencent.mm.plugin.recordvideo.activity.a sYS;
  private RecordConfigProvider sYT;
  private com.tencent.mm.media.widget.camerarecordview.b.b xQs;
  private final com.tencent.mm.plugin.recordvideo.plugin.q xTA;
  private final i xTB;
  private final g xTC;
  protected com.tencent.mm.plugin.recordvideo.plugin.s xTn;
  private final com.tencent.mm.plugin.recordvideo.plugin.a xTo;
  private final com.tencent.mm.plugin.recordvideo.plugin.h xTp;
  private final com.tencent.mm.plugin.recordvideo.plugin.r xTq;
  private final com.tencent.mm.plugin.recordvideo.plugin.c xTr;
  private final com.tencent.mm.plugin.recordvideo.plugin.d xTs;
  private final com.tencent.mm.plugin.recordvideo.plugin.b xTt;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a xTu;
  private final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a xTv;
  private final com.tencent.mm.plugin.recordvideo.plugin.f xTw;
  private final com.tencent.mm.plugin.recordvideo.plugin.e xTx;
  private final ab xTy;
  private final com.tencent.mm.plugin.recordvideo.plugin.p xTz;
  
  public BaseEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.xTy = new ab(paramContext);
    ae.i("MicroMsg.EditorVideoPluginLayout", "EditorVideoPluginLayoutNew invoke init");
    LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    paramContext = getPlayerView();
    paramAttributeSet = (ViewStub)findViewById(2131303271);
    d.g.b.p.g(paramAttributeSet, "placeholder");
    Object localObject = paramAttributeSet.getParent();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    int i = ((ViewGroup)localObject).indexOfChild((View)paramAttributeSet);
    ((ViewGroup)localObject).removeViewAt(i);
    ((ViewGroup)localObject).addView(paramContext, i, new ViewGroup.LayoutParams(-1, -1));
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131299273);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.xTo = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    paramContext = findViewById(2131299293);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_item_container)");
    this.xTp = new com.tencent.mm.plugin.recordvideo.plugin.h((EditorItemContainer)paramContext, (d)this);
    paramContext = findViewById(2131298784);
    d.g.b.p.g(paramContext, "findViewById(R.id.control_container)");
    this.xTq = new com.tencent.mm.plugin.recordvideo.plugin.r((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131297952);
    d.g.b.p.g(paramContext, "findViewById(R.id.change_text_root)");
    this.xTC = new g((EditorInputView)paramContext);
    this.xTr = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.xTC.xPV);
    this.xTu = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (d)this);
    this.xTv = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a((ViewGroup)this, (d)this);
    paramContext = findViewById(2131299295);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_mix)");
    this.xTw = new com.tencent.mm.plugin.recordvideo.plugin.f(paramContext, (d)this);
    paramContext = findViewById(2131299285);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_close)");
    this.xTx = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299621);
    d.g.b.p.g(paramContext, "findViewById(R.id.ext_text_area)");
    this.xTz = new com.tencent.mm.plugin.recordvideo.plugin.p((TextView)paramContext, (d)this);
    paramContext = findViewById(2131303907);
    d.g.b.p.g(paramContext, "findViewById(R.id.recorder_black_mask)");
    this.xTA = new com.tencent.mm.plugin.recordvideo.plugin.q((ImageView)paramContext, (d)this);
    this.xTs = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (d)this, this.xTC.xPV);
    this.xTt = new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)this, (d)this);
    this.xTB = new i((ViewGroup)this, (d)this);
    getPluginList().add(this.xTo);
    getPluginList().add(this.xTp);
    getPluginList().add(this.xTq);
    getPluginList().add(this.xTr);
    getPluginList().add(this.xTu);
    getPluginList().add(this.xTv);
    getPluginList().add(this.xTw);
    getPluginList().add(this.xTy);
    getPluginList().add(this.xTx);
    getPluginList().add(this.xTz);
    getPluginList().add(this.xTA);
    getPluginList().add(this.xTs);
    getPluginList().add(this.xTt);
    getPluginList().add(this.xTB);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.xON;
    i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.xON;
    int j = com.tencent.mm.plugin.recordvideo.model.a.dJb();
    float f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = j * 1.78F;
    float f5 = (i - f4) / 2.0F;
    if (f1 <= 1.78F)
    {
      this.xTC.bs(f3);
      this.xTp.X(f2, f3);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.xTC.bt(f3);
      this.xTp.Y(f4, f5);
      return;
    }
    this.xTC.bs(f3);
    this.xTC.bt(f3);
    this.xTp.X(f2, f3);
    this.xTp.Y(f4, f5);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    super.a(paramb);
    this.xQs = paramb;
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    d.g.b.p.h(parama, "navigator");
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    this.sYS = parama;
    this.sYT = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.yhe;
    com.tencent.mm.plugin.recordvideo.e.b.e(paramRecordConfigProvider);
    parama = this.xTp;
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    parama = parama.xQe;
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    parama.sYT = paramRecordConfigProvider;
    this.xTu.setVisibility(0);
    this.xTv.setVisibility(0);
    com.tencent.mm.plugin.recordvideo.plugin.f localf = this.xTw;
    parama = paramRecordConfigProvider.xOh;
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
      parama = Integer.valueOf(parama.ggi);
      localObject1 = paramRecordConfigProvider.xOh;
      if (localObject1 == null) {
        break label597;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).ggj);
      localObject2 = paramRecordConfigProvider.xOh;
      if (localObject2 == null) {
        break label603;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.xOh;
      if (localObject3 == null) {
        break label609;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).ggk);
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.xTu;
      parama = paramRecordConfigProvider.xOh;
      if (parama == null) {
        break label615;
      }
      parama = Integer.valueOf(parama.ggi);
      localObject1 = paramRecordConfigProvider.xOh;
      if (localObject1 == null) {
        break label620;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).ggj);
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = this.xTz;
      parama = paramRecordConfigProvider.xOh;
      if (parama == null) {
        break label626;
      }
      parama = parama.ggl;
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = this.xTr;
      parama = paramRecordConfigProvider.xOh;
      if (parama == null) {
        break label631;
      }
      parama = Integer.valueOf(parama.ggi);
      label276:
      localObject1 = paramRecordConfigProvider.xOh;
      if (localObject1 == null) {
        break label636;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).ggj);
      label297:
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      localObject2 = this.xTv;
      parama = paramRecordConfigProvider.xOh;
      if (parama == null) {
        break label642;
      }
      parama = Integer.valueOf(parama.ggi);
      label328:
      localObject3 = paramRecordConfigProvider.xOh;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).ggj);
      }
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject2).xSn.getFinishButton();
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((Button)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((Button)localObject2).setTextColor(android.support.v4.content.b.n(((Button)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      this.xTB.setScene(paramRecordConfigProvider.scene);
      parama = this.xTs;
      localObject1 = paramRecordConfigProvider.xOh.ggh;
      d.g.b.p.g(localObject1, "configProvider.uiParam.pluginHiddenMap");
      if (!((Map)localObject1).containsKey("plugin_tip")) {
        break label647;
      }
      i = 8;
      label476:
      parama.xPZ = i;
      parama = ((Iterable)getPluginList()).iterator();
      label494:
      if (!parama.hasNext()) {
        return;
      }
      localObject1 = (t)parama.next();
      localObject2 = paramRecordConfigProvider.xOh;
      if (localObject2 == null) {
        break label652;
      }
      localObject2 = ((UICustomParam)localObject2).ggh;
      if (localObject2 == null) {
        break label652;
      }
      localObject2 = (Boolean)((Map)localObject2).get(((t)localObject1).name());
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
      ((t)localObject1).setVisibility(i);
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
    d.g.b.p.h(paramc, "status");
    if (paramc != d.c.xUM) {
      ae.i("MicroMsg.EditorVideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
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
    switch (a.cqt[paramc.ordinal()])
    {
    default: 
      ae.e("MicroMsg.EditorVideoPluginLayout", "unknown status ".concat(String.valueOf(paramc)));
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
                  this.xTq.setVisibility(4);
                  return;
                  paramBundle = this.xTA;
                  paramc = paramBundle.xQX;
                  paramBundle = paramBundle.xQX.getContext();
                  d.g.b.p.g(paramBundle, "bgView.context");
                  paramc.setBackgroundColor(paramBundle.getResources().getColor(2131100017));
                  return;
                  paramc = this.xTu;
                  localObject1 = this.xQs;
                  if (localObject1 == null) {
                    d.g.b.p.gkB();
                  }
                  com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject1, this.sYT);
                  this.xTp.setVisibility(0);
                  this.xTq.setVisibility(0);
                  if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP")))
                  {
                    this.xTu.dJV();
                    return;
                    this.xTq.setVisibility(0);
                    paramc = this.xTp;
                    paramBundle = paramc.xQc;
                    if (paramBundle != null) {
                      paramBundle.setVisibility(0);
                    }
                    paramc = paramc.xQd;
                    if (paramc != null)
                    {
                      paramc.setVisibility(0);
                      return;
                      localObject1 = this.xTp;
                      if (paramBundle != null) {}
                      for (paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO"); paramc != null; paramc = null)
                      {
                        paramBundle = ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject1).xQe;
                        d.g.b.p.h(paramc, "emojiInfo");
                        localObject1 = paramBundle.getContext();
                        d.g.b.p.g(localObject1, "context");
                        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f((Context)localObject1);
                        localObject2 = paramBundle.sYT;
                        if (localObject2 != null)
                        {
                          localObject2 = ((RecordConfigProvider)localObject2).xOh;
                          if (localObject2 != null) {
                            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).aa(((UICustomParam)localObject2).ggd, ((UICustomParam)localObject2).gge);
                          }
                        }
                        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                        paramBundle.qdP.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.dIe();
                        localObject3 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.dIg());
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.dIf());
                        c.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.c)localObject1, paramBundle.ydR);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.yem);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setEmojiInfo(paramc);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).resume();
                        if (paramBundle.ydY) {
                          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).pause();
                        }
                        paramBundle.s((View)localObject1, true);
                        paramBundle.removeCallbacks(paramBundle.qdV);
                        paramBundle.postDelayed(paramBundle.qdV, 1500L);
                        paramBundle.dLl();
                        return;
                      }
                    }
                  }
                }
              } while (paramBundle == null);
              paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
              i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
              j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
              paramBundle = this.xTp;
              paramc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.q(paramc, i, j, 0, null, 24);
              d.g.b.p.h(paramc, "item");
              if (paramBundle.xQc != null)
              {
                localObject1 = paramBundle.xQc;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setVisibility(0);
                }
                localObject1 = paramBundle.xQc;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setText(paramc);
                }
                paramBundle.xQc = null;
              }
              for (;;)
              {
                paramc = z.Nhr;
                return;
                paramBundle = paramBundle.xQe;
                d.g.b.p.h(paramc, "item");
                localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.r(paramBundle.getContext());
                localObject2 = paramBundle.sYT;
                if (localObject2 != null)
                {
                  localObject2 = ((RecordConfigProvider)localObject2).xOh;
                  if (localObject2 != null) {
                    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).aa(((UICustomParam)localObject2).ggf, ((UICustomParam)localObject2).ggg);
                  }
                }
                localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                paramBundle.qdP.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.dIe();
                localObject3 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.dIg());
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xKl;
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.dIf());
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).a(paramBundle.ydR, paramBundle.heightPercent);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.yem);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setText(paramc);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setOnClickListener(paramBundle.yeh);
                paramBundle.s((View)localObject1, true);
                paramBundle.removeCallbacks(paramBundle.qdV);
                paramBundle.postDelayed(paramBundle.qdV, 1500L);
                paramBundle.dLl();
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
              this.xTp.xQe.dLm();
              j = this.xTp.xQe.getLocationItemHeight();
              if (j != 0) {
                break label1040;
              }
              i = 0;
              k = aq.fromDPToPix(getContext(), 44);
              this.xTs.On(i + j + k);
            }
            for (;;)
            {
              paramc = z.Nhr;
              return;
              i = 0;
              break;
              i = aq.fromDPToPix(getContext(), 24);
              break label1003;
              this.xTp.av(paramc.toString(), j, k);
            }
          } while (paramBundle == null);
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          com.tencent.mm.plugin.recordvideo.plugin.c.a(this.xTr, paramc, i, j);
          paramc = z.Nhr;
          return;
        } while (paramBundle == null);
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramBundle = this.xTs;
        paramBundle.xPV.mode = 1;
        paramBundle.xPV.setShow(true);
        paramBundle.xPV.g(paramc, i, j);
        paramc = z.Nhr;
        return;
      } while (paramBundle == null);
      bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
      paramc = this.xTn;
      if (paramc == null) {
        d.g.b.p.bdF("previewPlugin");
      }
      paramc.wdv.setMute(bool);
      paramc = z.Nhr;
      return;
    case 15: 
      this.xTv.pV(true);
      return;
    case 16: 
      this.xTq.setVisibility(4);
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", false);
        paramc = this.xTn;
        if (paramc == null) {
          d.g.b.p.bdF("previewPlugin");
        }
        paramc.xRf = true;
        paramBundle = paramc.wdv.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        m = ((ViewGroup)paramBundle).getWidth();
        paramBundle = paramc.wdv.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        n = ((ViewGroup)paramBundle).getHeight();
        j = com.tencent.mm.cb.a.fromDPToPix(paramc.context, 20) + com.tencent.mm.cb.a.fromDPToPix(paramc.context, 95) + com.tencent.mm.cb.a.fromDPToPix(paramc.context, 12);
        if (!ar.jY(paramc.context)) {
          break label2807;
        }
        j += ar.en(paramc.context);
      }
      break;
    }
    label2402:
    label2807:
    for (;;)
    {
      i = 0;
      if (bool)
      {
        i = com.tencent.mm.cb.a.fromDPToPix(paramc.context, 56) + 0;
        if (al.aH(paramc.context))
        {
          ae.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is true，videoViewTopMargin: " + i + ", cutout height is " + al.aG(paramc.context));
          i += al.aG(paramc.context);
        }
      }
      for (;;)
      {
        paramBundle = paramc.wdv.getParent();
        if (paramBundle != null) {
          break;
        }
        throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        ae.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is false");
      }
      if (((ViewGroup)paramBundle).getBottom() + j < com.tencent.mm.plugin.mmsight.d.fS(paramc.context).y) {}
      for (k = (int)((m - com.tencent.mm.cb.a.fromDPToPix(paramc.context, 32) * 2) / (m / n));; k = n - j - i)
      {
        int i1 = (int)(m / n * k);
        float f1 = i1 / m;
        float f2 = k / n;
        float f3 = -(Math.abs(j - i) / 2.0F);
        ae.i("MicroMsg.EditVideoPlayPlugin", "scaleX: " + f1 + ", scaleY: " + f2 + ", translationY: " + f3);
        ae.i("MicroMsg.EditVideoPlayPlugin", "isShowWeseeBtn: " + bool + ", videoViewWidth: " + m + ", videoViewHeight: " + n + ", videoViewBottomMargin:" + j + ", videoViewTopMargin:" + i + ", videoViewScaleHeight: " + k + ", videoViewScaleWidth: " + i1);
        paramBundle = paramc.wdv.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)paramBundle).animate().scaleX(f1).scaleY(f2).translationY(f3).setDuration(300L).setListener((Animator.AnimatorListener)new s.b(paramc));
        paramc = z.Nhr;
        this.xTp.xQe.setEnableTouch(false);
        paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramc = this.xTn;
        if (paramc == null) {
          d.g.b.p.bdF("previewPlugin");
        }
        paramc.dez = i;
        paramc.hwE = j;
        paramc.wdv.d(paramc.dez, true);
        paramc = z.Nhr;
        return;
        paramc = this.xTn;
        if (paramc == null) {
          d.g.b.p.bdF("previewPlugin");
        }
        paramc.onPause();
        return;
        paramc = this.xTn;
        if (paramc == null) {
          d.g.b.p.bdF("previewPlugin");
        }
        paramc.onResume();
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.xTn;
        if (paramc == null) {
          d.g.b.p.bdF("previewPlugin");
        }
        paramc.wdv.d(i, true);
        paramc = z.Nhr;
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.xTv;
        if (paramc.xSn.getVisibility() == 0)
        {
          paramc = paramc.xSn;
          paramc.wjy.setCurrentCursorPosition(i / paramc.wjy.getDurationMs());
        }
        paramc = z.Nhr;
        return;
        paramc = this.xQs;
        if (paramc == null) {
          break;
        }
        paramBundle = this.sYT;
        if (paramBundle != null) {
          i = paramBundle.xOp;
        }
        while (paramc.hwE - paramc.dez > i + 250)
        {
          paramc = getContext();
          if (paramc == null)
          {
            throw new v("null cannot be cast to non-null type android.app.Activity");
            i = 10000;
          }
          else
          {
            ((Activity)paramc).setResult(3000);
            paramc = getContext();
            if (paramc == null) {
              throw new v("null cannot be cast to non-null type android.app.Activity");
            }
            ((Activity)paramc).finish();
            return;
          }
        }
        this.xTq.setVisibility(0);
        paramc = this.xTn;
        if (paramc == null) {
          d.g.b.p.bdF("previewPlugin");
        }
        paramc.pR(false);
        this.xTp.dJE();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        paramc = z.Nhr;
        return;
        this.xTq.setVisibility(0);
        this.xTu.dJV();
        paramc = this.xTn;
        if (paramc == null) {
          d.g.b.p.bdF("previewPlugin");
        }
        paramc.pR(true);
        this.xTp.dJE();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        aoQ();
        return;
        if (paramBundle == null) {
          break;
        }
        paramBundle = paramBundle.getByteArray("PARAM_EDIT_POI_INFO");
        paramc = this.xTp;
        paramBundle = new csx().parseFrom(paramBundle);
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecordLocationInfo");
        }
        paramBundle = (csx)paramBundle;
        d.g.b.p.h(paramBundle, "storyLocation");
        if ((!bu.isNullOrNil(paramBundle.jGd)) || (!bu.isNullOrNil(paramBundle.jfX)))
        {
          i = 1;
          if (i == 0) {
            break label2480;
          }
          if (!paramc.xQe.dLo()) {
            break label2469;
          }
          paramc = paramc.xQe;
          d.g.b.p.h(paramBundle, "sl");
          if (paramc.yed != null)
          {
            paramc.I((d.g.a.a)EditorItemContainer.e.yeq);
            paramc.a(paramBundle);
          }
          j = this.xTp.xQe.getLocationItemHeight();
          if (j != 0) {
            break label2506;
          }
        }
        for (i = 0;; i = aq.fromDPToPix(getContext(), 24))
        {
          k = aq.fromDPToPix(getContext(), 44);
          if (!this.xTp.dJB()) {
            this.xTs.On(i + j + k);
          }
          paramc = z.Nhr;
          return;
          i = 0;
          break;
          paramc.xQe.a(paramBundle);
          break label2402;
          if (!paramc.xQe.dLo()) {
            break label2402;
          }
          paramc.xQe.I((d.g.a.a)h.a.xQg);
          break label2402;
        }
        this.xTt.dJA();
        return;
        if (paramBundle == null) {
          break;
        }
        bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
        paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
        paramc = new ArrayList();
        if (paramBundle != null)
        {
          paramBundle = ((Iterable)paramBundle.xPF).iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject2 = (byte[])paramBundle.next();
              localObject1 = new bwu();
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
                  ae.l("safeParser", "", new Object[] { localException });
                }
              }
            }
          }
          paramBundle = z.Nhr;
        }
        paramBundle = this.xTp;
        paramc = (List)paramc;
        d.g.b.p.h(paramc, "lyricsInfo");
        if (bool) {
          if (paramBundle.xQe.yee != null)
          {
            i = 1;
            if (i == 0) {
              break label2737;
            }
            paramBundle = paramBundle.xQe;
            d.g.b.p.h(paramc, "lyricsItemInfos");
            if (paramBundle.yee != null)
            {
              paramBundle.dLn();
              paramBundle.fq(paramc);
            }
          }
        }
        for (;;)
        {
          paramc = z.Nhr;
          return;
          i = 0;
          break;
          paramBundle.xQe.fq(paramc);
          continue;
          paramBundle.xQe.dLn();
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ygE.ordinal()) {
          this.xTu.xTd.qf(false);
        }
        paramc = z.Nhr;
        return;
      }
    }
  }
  
  protected final void axb(final String paramString)
  {
    d.g.b.p.h(paramString, "tip");
    ae.i("MicroMsg.EditorVideoPluginLayout", "showDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new v("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, paramString));
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a getAddEmojiPlugin()
  {
    return this.xTo;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a.a getAddMusicPlugin()
  {
    return this.xTu;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.b getAddPoiPlugin()
  {
    return this.xTt;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.c getAddTextPlugin()
  {
    return this.xTr;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.d getAddTipPlugin()
  {
    return this.xTs;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.p getAddonTextPlugin()
  {
    return this.xTz;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.e getBackToRecordPlugin()
  {
    return this.xTx;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.q getBgPlugin()
  {
    return this.xTA;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.xQs;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.sYT;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a getCropVideoPlugin()
  {
    return this.xTv;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.f getEditFinishPlugin()
  {
    return this.xTw;
  }
  
  protected final g getInputPlugin()
  {
    return this.xTC;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.h getItemContainerPlugin()
  {
    return this.xTp;
  }
  
  public int getLayoutId()
  {
    return 2131495831;
  }
  
  protected final i getMoreMenuPlugin()
  {
    return this.xTB;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.activity.a getNavigator()
  {
    return this.sYS;
  }
  
  public abstract View getPlayerView();
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.s getPreviewPlugin()
  {
    com.tencent.mm.plugin.recordvideo.plugin.s locals = this.xTn;
    if (locals == null) {
      d.g.b.p.bdF("previewPlugin");
    }
    return locals;
  }
  
  protected final ab getReMuxPlugin()
  {
    return this.xTy;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.r getVideoControlContainerPlugin()
  {
    return this.xTq;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.xQs = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.sYT = paramRecordConfigProvider;
  }
  
  protected final void setNavigator(com.tencent.mm.plugin.recordvideo.activity.a parama)
  {
    this.sYS = parama;
  }
  
  protected final void setPreviewPlugin(com.tencent.mm.plugin.recordvideo.plugin.s params)
  {
    d.g.b.p.h(params, "<set-?>");
    this.xTn = params;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(75762);
      com.tencent.mm.ui.base.p localp = BaseEditVideoPluginLayout.a(this.xTE);
      if (localp != null) {
        localp.dismiss();
      }
      BaseEditVideoPluginLayout.a(this.xTE, null);
      AppMethodBeat.o(75762);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(75763);
      BaseEditVideoPluginLayout.a(this.xTE, com.tencent.mm.ui.base.h.b(this.xTE.getContext(), paramString, false, null));
      AppMethodBeat.o(75763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */