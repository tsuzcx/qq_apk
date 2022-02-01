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
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "getAddMusicPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "getAddPoiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "getAddTipPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "getAddonTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "getBgPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "getCropVideoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "getInputPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "getItemContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "moreMenuPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "getMoreMenuPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getNavigator", "()Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "setNavigator", "(Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;)V", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;)V", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "getReMuxPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getVideoControlContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getLayoutId", "", "getPlayerView", "Landroid/view/View;", "hideDialog", "", "initLogic", "initSafeArea", "loadCurrentPage", "info", "loadPlayerView", "showDialog", "tip", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public abstract class BaseEditVideoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final BaseEditVideoPluginLayout.a xDI = new BaseEditVideoPluginLayout.a((byte)0);
  public com.tencent.mm.ui.base.p mCn;
  private com.tencent.mm.plugin.recordvideo.activity.a sNH;
  private RecordConfigProvider sNI;
  private com.tencent.mm.media.widget.camerarecordview.b.b xAw;
  private final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a xDA;
  private final com.tencent.mm.plugin.recordvideo.plugin.f xDB;
  private final com.tencent.mm.plugin.recordvideo.plugin.e xDC;
  private final ab xDD;
  private final com.tencent.mm.plugin.recordvideo.plugin.p xDE;
  private final com.tencent.mm.plugin.recordvideo.plugin.q xDF;
  private final i xDG;
  private final g xDH;
  protected com.tencent.mm.plugin.recordvideo.plugin.s xDs;
  private final com.tencent.mm.plugin.recordvideo.plugin.a xDt;
  private final com.tencent.mm.plugin.recordvideo.plugin.h xDu;
  private final com.tencent.mm.plugin.recordvideo.plugin.r xDv;
  private final com.tencent.mm.plugin.recordvideo.plugin.c xDw;
  private final com.tencent.mm.plugin.recordvideo.plugin.d xDx;
  private final com.tencent.mm.plugin.recordvideo.plugin.b xDy;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a xDz;
  
  public BaseEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.xDD = new ab(paramContext);
    ad.i("MicroMsg.EditorVideoPluginLayout", "EditorVideoPluginLayoutNew invoke init");
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
    this.xDt = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    paramContext = findViewById(2131299293);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_item_container)");
    this.xDu = new com.tencent.mm.plugin.recordvideo.plugin.h((EditorItemContainer)paramContext, (d)this);
    paramContext = findViewById(2131298784);
    d.g.b.p.g(paramContext, "findViewById(R.id.control_container)");
    this.xDv = new com.tencent.mm.plugin.recordvideo.plugin.r((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131297952);
    d.g.b.p.g(paramContext, "findViewById(R.id.change_text_root)");
    this.xDH = new g((EditorInputView)paramContext);
    this.xDw = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.xDH.xzZ);
    this.xDz = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (d)this);
    this.xDA = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a((ViewGroup)this, (d)this);
    paramContext = findViewById(2131299295);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_mix)");
    this.xDB = new com.tencent.mm.plugin.recordvideo.plugin.f(paramContext, (d)this);
    paramContext = findViewById(2131299285);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_close)");
    this.xDC = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299621);
    d.g.b.p.g(paramContext, "findViewById(R.id.ext_text_area)");
    this.xDE = new com.tencent.mm.plugin.recordvideo.plugin.p((TextView)paramContext, (d)this);
    paramContext = findViewById(2131303907);
    d.g.b.p.g(paramContext, "findViewById(R.id.recorder_black_mask)");
    this.xDF = new com.tencent.mm.plugin.recordvideo.plugin.q((ImageView)paramContext, (d)this);
    this.xDx = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (d)this, this.xDH.xzZ);
    this.xDy = new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)this, (d)this);
    this.xDG = new i((ViewGroup)this, (d)this);
    getPluginList().add(this.xDt);
    getPluginList().add(this.xDu);
    getPluginList().add(this.xDv);
    getPluginList().add(this.xDw);
    getPluginList().add(this.xDz);
    getPluginList().add(this.xDA);
    getPluginList().add(this.xDB);
    getPluginList().add(this.xDD);
    getPluginList().add(this.xDC);
    getPluginList().add(this.xDE);
    getPluginList().add(this.xDF);
    getPluginList().add(this.xDx);
    getPluginList().add(this.xDy);
    getPluginList().add(this.xDG);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.xyR;
    i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.xyR;
    int j = com.tencent.mm.plugin.recordvideo.model.a.dFK();
    float f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = j * 1.78F;
    float f5 = (i - f4) / 2.0F;
    if (f1 <= 1.78F)
    {
      this.xDH.bs(f3);
      this.xDu.X(f2, f3);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.xDH.bt(f3);
      this.xDu.Y(f4, f5);
      return;
    }
    this.xDH.bs(f3);
    this.xDH.bt(f3);
    this.xDu.X(f2, f3);
    this.xDu.Y(f4, f5);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    super.a(paramb);
    this.xAw = paramb;
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    d.g.b.p.h(parama, "navigator");
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    this.sNH = parama;
    this.sNI = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.xRl;
    com.tencent.mm.plugin.recordvideo.e.b.e(paramRecordConfigProvider);
    parama = this.xDu;
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    parama = parama.xAi;
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    parama.sNI = paramRecordConfigProvider;
    this.xDz.setVisibility(0);
    this.xDA.setVisibility(0);
    com.tencent.mm.plugin.recordvideo.plugin.f localf = this.xDB;
    parama = paramRecordConfigProvider.xyk;
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
      parama = Integer.valueOf(parama.gea);
      localObject1 = paramRecordConfigProvider.xyk;
      if (localObject1 == null) {
        break label597;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).geb);
      localObject2 = paramRecordConfigProvider.xyk;
      if (localObject2 == null) {
        break label603;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.xyk;
      if (localObject3 == null) {
        break label609;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).gec);
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.xDz;
      parama = paramRecordConfigProvider.xyk;
      if (parama == null) {
        break label615;
      }
      parama = Integer.valueOf(parama.gea);
      localObject1 = paramRecordConfigProvider.xyk;
      if (localObject1 == null) {
        break label620;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).geb);
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = this.xDE;
      parama = paramRecordConfigProvider.xyk;
      if (parama == null) {
        break label626;
      }
      parama = parama.ged;
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = this.xDw;
      parama = paramRecordConfigProvider.xyk;
      if (parama == null) {
        break label631;
      }
      parama = Integer.valueOf(parama.gea);
      label276:
      localObject1 = paramRecordConfigProvider.xyk;
      if (localObject1 == null) {
        break label636;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).geb);
      label297:
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      localObject2 = this.xDA;
      parama = paramRecordConfigProvider.xyk;
      if (parama == null) {
        break label642;
      }
      parama = Integer.valueOf(parama.gea);
      label328:
      localObject3 = paramRecordConfigProvider.xyk;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).geb);
      }
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject2).xCs.getFinishButton();
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((Button)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((Button)localObject2).setTextColor(android.support.v4.content.b.n(((Button)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      this.xDG.setScene(paramRecordConfigProvider.scene);
      parama = this.xDx;
      localObject1 = paramRecordConfigProvider.xyk.gdZ;
      d.g.b.p.g(localObject1, "configProvider.uiParam.pluginHiddenMap");
      if (!((Map)localObject1).containsKey("plugin_tip")) {
        break label647;
      }
      i = 8;
      label476:
      parama.xAd = i;
      parama = ((Iterable)getPluginList()).iterator();
      label494:
      if (!parama.hasNext()) {
        return;
      }
      localObject1 = (t)parama.next();
      localObject2 = paramRecordConfigProvider.xyk;
      if (localObject2 == null) {
        break label652;
      }
      localObject2 = ((UICustomParam)localObject2).gdZ;
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
    if (paramc != d.c.xER) {
      ad.i("MicroMsg.EditorVideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
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
    switch (a.cpQ[paramc.ordinal()])
    {
    default: 
      ad.e("MicroMsg.EditorVideoPluginLayout", "unknown status ".concat(String.valueOf(paramc)));
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
                  this.xDv.setVisibility(4);
                  return;
                  paramBundle = this.xDF;
                  paramc = paramBundle.xBc;
                  paramBundle = paramBundle.xBc.getContext();
                  d.g.b.p.g(paramBundle, "bgView.context");
                  paramc.setBackgroundColor(paramBundle.getResources().getColor(2131100017));
                  return;
                  paramc = this.xDz;
                  localObject1 = this.xAw;
                  if (localObject1 == null) {
                    d.g.b.p.gfZ();
                  }
                  com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject1, this.sNI);
                  this.xDu.setVisibility(0);
                  this.xDv.setVisibility(0);
                  if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP")))
                  {
                    this.xDz.dGE();
                    return;
                    this.xDv.setVisibility(0);
                    paramc = this.xDu;
                    paramBundle = paramc.xAg;
                    if (paramBundle != null) {
                      paramBundle.setVisibility(0);
                    }
                    paramc = paramc.xAh;
                    if (paramc != null)
                    {
                      paramc.setVisibility(0);
                      return;
                      localObject1 = this.xDu;
                      if (paramBundle != null) {}
                      for (paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO"); paramc != null; paramc = null)
                      {
                        paramBundle = ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject1).xAi;
                        d.g.b.p.h(paramc, "emojiInfo");
                        localObject1 = paramBundle.getContext();
                        d.g.b.p.g(localObject1, "context");
                        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f((Context)localObject1);
                        localObject2 = paramBundle.sNI;
                        if (localObject2 != null)
                        {
                          localObject2 = ((RecordConfigProvider)localObject2).xyk;
                          if (localObject2 != null) {
                            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).aa(((UICustomParam)localObject2).gdV, ((UICustomParam)localObject2).gdW);
                          }
                        }
                        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                        paramBundle.pXk.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.dEN();
                        localObject3 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.dEP());
                        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.dEO());
                        c.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.c)localObject1, paramBundle.xNY);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.xOt);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setEmojiInfo(paramc);
                        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).resume();
                        if (paramBundle.xOf) {
                          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).pause();
                        }
                        paramBundle.s((View)localObject1, true);
                        paramBundle.removeCallbacks(paramBundle.pXq);
                        paramBundle.postDelayed(paramBundle.pXq, 1500L);
                        paramBundle.dHU();
                        return;
                      }
                    }
                  }
                }
              } while (paramBundle == null);
              paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
              i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
              j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
              paramBundle = this.xDu;
              paramc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.q(paramc, i, j, 0, null, 24);
              d.g.b.p.h(paramc, "item");
              if (paramBundle.xAg != null)
              {
                localObject1 = paramBundle.xAg;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setVisibility(0);
                }
                localObject1 = paramBundle.xAg;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setText(paramc);
                }
                paramBundle.xAg = null;
              }
              for (;;)
              {
                paramc = z.MKo;
                return;
                paramBundle = paramBundle.xAi;
                d.g.b.p.h(paramc, "item");
                localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.r(paramBundle.getContext());
                localObject2 = paramBundle.sNI;
                if (localObject2 != null)
                {
                  localObject2 = ((RecordConfigProvider)localObject2).xyk;
                  if (localObject2 != null) {
                    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).aa(((UICustomParam)localObject2).gdX, ((UICustomParam)localObject2).gdY);
                  }
                }
                localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                paramBundle.pXk.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.dEN();
                localObject3 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.dEP());
                localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.dEO());
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).a(paramBundle.xNY, paramBundle.heightPercent);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.xOt);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setText(paramc);
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.r)localObject1).setOnClickListener(paramBundle.xOo);
                paramBundle.s((View)localObject1, true);
                paramBundle.removeCallbacks(paramBundle.pXq);
                paramBundle.postDelayed(paramBundle.pXq, 1500L);
                paramBundle.dHU();
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
              this.xDu.xAi.dHV();
              j = this.xDu.xAi.getLocationItemHeight();
              if (j != 0) {
                break label1040;
              }
              i = 0;
              k = aq.fromDPToPix(getContext(), 44);
              this.xDx.NH(i + j + k);
            }
            for (;;)
            {
              paramc = z.MKo;
              return;
              i = 0;
              break;
              i = aq.fromDPToPix(getContext(), 24);
              break label1003;
              this.xDu.au(paramc.toString(), j, k);
            }
          } while (paramBundle == null);
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          com.tencent.mm.plugin.recordvideo.plugin.c.a(this.xDw, paramc, i, j);
          paramc = z.MKo;
          return;
        } while (paramBundle == null);
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramBundle = this.xDx;
        paramBundle.xzZ.mode = 1;
        paramBundle.xzZ.setShow(true);
        paramBundle.xzZ.g(paramc, i, j);
        paramc = z.MKo;
        return;
      } while (paramBundle == null);
      bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
      paramc = this.xDs;
      if (paramc == null) {
        d.g.b.p.bcb("previewPlugin");
      }
      paramc.vRr.setMute(bool);
      paramc = z.MKo;
      return;
    case 15: 
      this.xDA.pN(true);
      return;
    case 16: 
      this.xDv.setVisibility(4);
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", false);
        paramc = this.xDs;
        if (paramc == null) {
          d.g.b.p.bcb("previewPlugin");
        }
        paramc.xBk = true;
        paramBundle = paramc.vRr.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        m = ((ViewGroup)paramBundle).getWidth();
        paramBundle = paramc.vRr.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        n = ((ViewGroup)paramBundle).getHeight();
        j = com.tencent.mm.cc.a.fromDPToPix(paramc.context, 20) + com.tencent.mm.cc.a.fromDPToPix(paramc.context, 95) + com.tencent.mm.cc.a.fromDPToPix(paramc.context, 12);
        if (!ar.jR(paramc.context)) {
          break label2807;
        }
        j += ar.ej(paramc.context);
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
        i = com.tencent.mm.cc.a.fromDPToPix(paramc.context, 56) + 0;
        if (al.aG(paramc.context))
        {
          ad.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is true，videoViewTopMargin: " + i + ", cutout height is " + al.aF(paramc.context));
          i += al.aF(paramc.context);
        }
      }
      for (;;)
      {
        paramBundle = paramc.vRr.getParent();
        if (paramBundle != null) {
          break;
        }
        throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        ad.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is false");
      }
      if (((ViewGroup)paramBundle).getBottom() + j < com.tencent.mm.plugin.mmsight.d.fM(paramc.context).y) {}
      for (k = (int)((m - com.tencent.mm.cc.a.fromDPToPix(paramc.context, 32) * 2) / (m / n));; k = n - j - i)
      {
        int i1 = (int)(m / n * k);
        float f1 = i1 / m;
        float f2 = k / n;
        float f3 = -(Math.abs(j - i) / 2.0F);
        ad.i("MicroMsg.EditVideoPlayPlugin", "scaleX: " + f1 + ", scaleY: " + f2 + ", translationY: " + f3);
        ad.i("MicroMsg.EditVideoPlayPlugin", "isShowWeseeBtn: " + bool + ", videoViewWidth: " + m + ", videoViewHeight: " + n + ", videoViewBottomMargin:" + j + ", videoViewTopMargin:" + i + ", videoViewScaleHeight: " + k + ", videoViewScaleWidth: " + i1);
        paramBundle = paramc.vRr.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)paramBundle).animate().scaleX(f1).scaleY(f2).translationY(f3).setDuration(300L).setListener((Animator.AnimatorListener)new s.b(paramc));
        paramc = z.MKo;
        this.xDu.xAi.setEnableTouch(false);
        paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramc = this.xDs;
        if (paramc == null) {
          d.g.b.p.bcb("previewPlugin");
        }
        paramc.ddx = i;
        paramc.htQ = j;
        paramc.vRr.d(paramc.ddx, true);
        paramc = z.MKo;
        return;
        paramc = this.xDs;
        if (paramc == null) {
          d.g.b.p.bcb("previewPlugin");
        }
        paramc.onPause();
        return;
        paramc = this.xDs;
        if (paramc == null) {
          d.g.b.p.bcb("previewPlugin");
        }
        paramc.onResume();
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.xDs;
        if (paramc == null) {
          d.g.b.p.bcb("previewPlugin");
        }
        paramc.vRr.d(i, true);
        paramc = z.MKo;
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.xDA;
        if (paramc.xCs.getVisibility() == 0)
        {
          paramc = paramc.xCs;
          paramc.vXu.setCurrentCursorPosition(i / paramc.vXu.getDurationMs());
        }
        paramc = z.MKo;
        return;
        paramc = this.xAw;
        if (paramc == null) {
          break;
        }
        paramBundle = this.sNI;
        if (paramBundle != null) {
          i = paramBundle.xyt;
        }
        while (paramc.htQ - paramc.ddx > i + 250)
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
        this.xDv.setVisibility(0);
        paramc = this.xDs;
        if (paramc == null) {
          d.g.b.p.bcb("previewPlugin");
        }
        paramc.pJ(false);
        this.xDu.dGn();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        paramc = z.MKo;
        return;
        this.xDv.setVisibility(0);
        this.xDz.dGE();
        paramc = this.xDs;
        if (paramc == null) {
          d.g.b.p.bcb("previewPlugin");
        }
        paramc.pJ(true);
        this.xDu.dGn();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        aoB();
        return;
        if (paramBundle == null) {
          break;
        }
        paramBundle = paramBundle.getByteArray("PARAM_EDIT_POI_INFO");
        paramc = this.xDu;
        paramBundle = new csd().parseFrom(paramBundle);
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecordLocationInfo");
        }
        paramBundle = (csd)paramBundle;
        d.g.b.p.h(paramBundle, "storyLocation");
        if ((!bt.isNullOrNil(paramBundle.jDf)) || (!bt.isNullOrNil(paramBundle.jde)))
        {
          i = 1;
          if (i == 0) {
            break label2480;
          }
          if (!paramc.xAi.dHX()) {
            break label2469;
          }
          paramc = paramc.xAi;
          d.g.b.p.h(paramBundle, "sl");
          if (paramc.xOk != null)
          {
            paramc.I((d.g.a.a)EditorItemContainer.e.xOx);
            paramc.a(paramBundle);
          }
          j = this.xDu.xAi.getLocationItemHeight();
          if (j != 0) {
            break label2506;
          }
        }
        for (i = 0;; i = aq.fromDPToPix(getContext(), 24))
        {
          k = aq.fromDPToPix(getContext(), 44);
          if (!this.xDu.dGk()) {
            this.xDx.NH(i + j + k);
          }
          paramc = z.MKo;
          return;
          i = 0;
          break;
          paramc.xAi.a(paramBundle);
          break label2402;
          if (!paramc.xAi.dHX()) {
            break label2402;
          }
          paramc.xAi.I((d.g.a.a)h.a.xAk);
          break label2402;
        }
        this.xDy.dGj();
        return;
        if (paramBundle == null) {
          break;
        }
        bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
        paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
        paramc = new ArrayList();
        if (paramBundle != null)
        {
          paramBundle = ((Iterable)paramBundle.xzJ).iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject2 = (byte[])paramBundle.next();
              localObject1 = new bwa();
              localObject3 = (com.tencent.mm.bx.a)localObject1;
              try
              {
                ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject2);
                paramc.add(localObject1);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.l("safeParser", "", new Object[] { localException });
                }
              }
            }
          }
          paramBundle = z.MKo;
        }
        paramBundle = this.xDu;
        paramc = (List)paramc;
        d.g.b.p.h(paramc, "lyricsInfo");
        if (bool) {
          if (paramBundle.xAi.xOl != null)
          {
            i = 1;
            if (i == 0) {
              break label2737;
            }
            paramBundle = paramBundle.xAi;
            d.g.b.p.h(paramc, "lyricsItemInfos");
            if (paramBundle.xOl != null)
            {
              paramBundle.dHW();
              paramBundle.fi(paramc);
            }
          }
        }
        for (;;)
        {
          paramc = z.MKo;
          return;
          i = 0;
          break;
          paramBundle.xAi.fi(paramc);
          continue;
          paramBundle.xAi.dHW();
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.xQL.ordinal()) {
          this.xDz.xDi.pX(false);
        }
        paramc = z.MKo;
        return;
      }
    }
  }
  
  protected final void avM(final String paramString)
  {
    d.g.b.p.h(paramString, "tip");
    ad.i("MicroMsg.EditorVideoPluginLayout", "showDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new v("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, paramString));
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a getAddEmojiPlugin()
  {
    return this.xDt;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a.a getAddMusicPlugin()
  {
    return this.xDz;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.b getAddPoiPlugin()
  {
    return this.xDy;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.c getAddTextPlugin()
  {
    return this.xDw;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.d getAddTipPlugin()
  {
    return this.xDx;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.p getAddonTextPlugin()
  {
    return this.xDE;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.e getBackToRecordPlugin()
  {
    return this.xDC;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.q getBgPlugin()
  {
    return this.xDF;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.xAw;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.sNI;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a getCropVideoPlugin()
  {
    return this.xDA;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.f getEditFinishPlugin()
  {
    return this.xDB;
  }
  
  protected final g getInputPlugin()
  {
    return this.xDH;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.h getItemContainerPlugin()
  {
    return this.xDu;
  }
  
  public int getLayoutId()
  {
    return 2131495831;
  }
  
  protected final i getMoreMenuPlugin()
  {
    return this.xDG;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.activity.a getNavigator()
  {
    return this.sNH;
  }
  
  public abstract View getPlayerView();
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.s getPreviewPlugin()
  {
    com.tencent.mm.plugin.recordvideo.plugin.s locals = this.xDs;
    if (locals == null) {
      d.g.b.p.bcb("previewPlugin");
    }
    return locals;
  }
  
  protected final ab getReMuxPlugin()
  {
    return this.xDD;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.r getVideoControlContainerPlugin()
  {
    return this.xDv;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.xAw = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.sNI = paramRecordConfigProvider;
  }
  
  protected final void setNavigator(com.tencent.mm.plugin.recordvideo.activity.a parama)
  {
    this.sNH = parama;
  }
  
  protected final void setPreviewPlugin(com.tencent.mm.plugin.recordvideo.plugin.s params)
  {
    d.g.b.p.h(params, "<set-?>");
    this.xDs = params;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(75762);
      com.tencent.mm.ui.base.p localp = BaseEditVideoPluginLayout.a(this.xDJ);
      if (localp != null) {
        localp.dismiss();
      }
      BaseEditVideoPluginLayout.a(this.xDJ, null);
      AppMethodBeat.o(75762);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(75763);
      BaseEditVideoPluginLayout.a(this.xDJ, com.tencent.mm.ui.base.h.b(this.xDJ.getContext(), paramString, false, null));
      AppMethodBeat.o(75763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */