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
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ae;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.j.a;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.b;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d.a;
import com.tencent.mm.plugin.recordvideo.util.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "getAddMusicPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "getAddPoiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "getAddTipPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "getAddonTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "getBgPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "getCropVideoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "getInputPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "getItemContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "moreMenuPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "getMoreMenuPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getNavigator", "()Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "setNavigator", "(Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;)V", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;)V", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "getReMuxPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getVideoControlContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getLayoutId", "", "getPlayerView", "Landroid/view/View;", "hideDialog", "", "initLogic", "initSafeArea", "loadCurrentPage", "info", "loadPlayerView", "showDialog", "tip", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseEditVideoPluginLayout
  extends BasePluginLayout
  implements a
{
  public static final BaseEditVideoPluginLayout.a NMZ = new BaseEditVideoPluginLayout.a((byte)0);
  private com.tencent.mm.plugin.recordvideo.activity.a Fiu;
  private com.tencent.mm.media.widget.camerarecordview.b.b NKf;
  protected u NNa;
  private final com.tencent.mm.plugin.recordvideo.plugin.c NNb;
  private final j NNc;
  private final com.tencent.mm.plugin.recordvideo.plugin.t NNd;
  private final com.tencent.mm.plugin.recordvideo.plugin.e NNe;
  private final com.tencent.mm.plugin.recordvideo.plugin.f NNf;
  private final com.tencent.mm.plugin.recordvideo.plugin.d NNg;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a NNh;
  private final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a NNi;
  private final h NNj;
  private final com.tencent.mm.plugin.recordvideo.plugin.g NNk;
  private final ae NNl;
  private final com.tencent.mm.plugin.recordvideo.plugin.r NNm;
  private final com.tencent.mm.plugin.recordvideo.plugin.s NNn;
  private final com.tencent.mm.plugin.recordvideo.plugin.k NNo;
  private final i NNp;
  private RecordConfigProvider oaV;
  private w rYw;
  
  public BaseEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.NNl = new ae(paramContext);
    Log.i("MicroMsg.EditorVideoPluginLayout", "EditorVideoPluginLayoutNew invoke init");
    LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    paramContext = getPlayerView();
    paramAttributeSet = (ViewStub)findViewById(b.e.place_holder);
    Object localObject = paramAttributeSet.getParent();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    localObject = (ViewGroup)localObject;
    int i = ((ViewGroup)localObject).indexOfChild((View)paramAttributeSet);
    ((ViewGroup)localObject).removeViewAt(i);
    ((ViewGroup)localObject).addView(paramContext, i, new ViewGroup.LayoutParams(-1, -1));
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(b.e.editor_add_emoji);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.NNb = new com.tencent.mm.plugin.recordvideo.plugin.c(paramContext, (ImageView)paramAttributeSet, (a)this);
    paramContext = findViewById(b.e.editor_item_container);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.editor_item_container)");
    this.NNc = new j((EditorItemContainer)paramContext, (a)this);
    paramContext = findViewById(b.e.control_container);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.control_container)");
    this.NNd = new com.tencent.mm.plugin.recordvideo.plugin.t((ViewGroup)paramContext, (a)this);
    paramContext = findViewById(b.e.change_text_root);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.change_text_root)");
    this.NNp = new i((EditorInputView)paramContext, (a)this);
    this.NNe = new com.tencent.mm.plugin.recordvideo.plugin.e((ViewGroup)this, (a)this, this.NNp.NJH);
    this.NNh = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (a)this);
    this.NNi = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a((ViewGroup)this, (a)this);
    paramContext = findViewById(b.e.editor_mix);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.editor_mix)");
    this.NNj = new h(paramContext, (a)this);
    paramContext = findViewById(b.e.editor_close);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.editor_close)");
    this.NNk = new com.tencent.mm.plugin.recordvideo.plugin.g((ImageView)paramContext, (a)this);
    paramContext = findViewById(b.e.ext_text_area);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.ext_text_area)");
    this.NNm = new com.tencent.mm.plugin.recordvideo.plugin.r((TextView)paramContext, (a)this);
    paramContext = findViewById(b.e.recorder_black_mask);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.recorder_black_mask)");
    this.NNn = new com.tencent.mm.plugin.recordvideo.plugin.s((ImageView)paramContext, (a)this);
    this.NNf = new com.tencent.mm.plugin.recordvideo.plugin.f((ViewGroup)this, (a)this, this.NNp.NJH);
    this.NNg = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (a)this);
    this.NNo = new com.tencent.mm.plugin.recordvideo.plugin.k((ViewGroup)this, (a)this);
    getPluginList().add(this.NNb);
    getPluginList().add(this.NNc);
    getPluginList().add(this.NNd);
    getPluginList().add(this.NNe);
    getPluginList().add(this.NNh);
    getPluginList().add(this.NNi);
    getPluginList().add(this.NNj);
    getPluginList().add(this.NNl);
    getPluginList().add(this.NNk);
    getPluginList().add(this.NNm);
    getPluginList().add(this.NNn);
    getPluginList().add(this.NNf);
    getPluginList().add(this.NNg);
    getPluginList().add(this.NNo);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.NIt;
    i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.NIt;
    int j = com.tencent.mm.plugin.recordvideo.model.a.gHH();
    float f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = j * 1.78F;
    float f5 = (i - f4) / 2.0F;
    if (f1 <= 1.78F)
    {
      this.NNp.cV(f3);
      this.NNc.aJ(f2, f3);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.NNp.cW(f3);
      this.NNc.aK(f4, f5);
      return;
    }
    this.NNp.cV(f3);
    this.NNp.cW(f3);
    this.NNc.aJ(f2, f3);
    this.NNc.aK(f4, f5);
  }
  
  private static final void a(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout)
  {
    kotlin.g.b.s.u(paramBaseEditVideoPluginLayout, "this$0");
    w localw = paramBaseEditVideoPluginLayout.rYw;
    if (localw != null) {
      localw.dismiss();
    }
    paramBaseEditVideoPluginLayout.rYw = null;
  }
  
  private static final void a(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout, String paramString)
  {
    kotlin.g.b.s.u(paramBaseEditVideoPluginLayout, "this$0");
    kotlin.g.b.s.u(paramString, "$tip");
    paramBaseEditVideoPluginLayout.rYw = com.tencent.mm.ui.base.k.a(paramBaseEditVideoPluginLayout.getContext(), paramString, false, null);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    super.a(paramb);
    this.NKf = paramb;
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    kotlin.g.b.s.u(parama, "navigator");
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    this.Fiu = parama;
    this.oaV = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    com.tencent.mm.plugin.recordvideo.util.f.l(paramRecordConfigProvider);
    parama = this.NNc;
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    parama = parama.NJQ;
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    parama.oaV = paramRecordConfigProvider;
    this.NNh.setVisibility(0);
    this.NNi.setVisibility(0);
    h localh = this.NNj;
    parama = paramRecordConfigProvider.NHR;
    Object localObject1;
    label117:
    Object localObject2;
    label131:
    Object localObject3;
    label145:
    label174:
    label188:
    label213:
    label236:
    label250:
    boolean bool;
    if (parama == null)
    {
      parama = null;
      localObject1 = paramRecordConfigProvider.NHR;
      if (localObject1 != null) {
        break label457;
      }
      localObject1 = null;
      localObject2 = paramRecordConfigProvider.NHR;
      if (localObject2 != null) {
        break label470;
      }
      localObject2 = null;
      localObject3 = paramRecordConfigProvider.NHR;
      if (localObject3 != null) {
        break label480;
      }
      localObject3 = null;
      localh.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.NNh;
      parama = paramRecordConfigProvider.NHR;
      if (parama != null) {
        break label493;
      }
      parama = null;
      localObject1 = paramRecordConfigProvider.NHR;
      if (localObject1 != null) {
        break label504;
      }
      localObject1 = null;
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = this.NNm;
      parama = paramRecordConfigProvider.NHR;
      if (parama != null) {
        break label517;
      }
      parama = null;
      ((com.tencent.mm.plugin.recordvideo.plugin.r)localObject1).setText(parama);
      localObject2 = this.NNe;
      parama = paramRecordConfigProvider.NHR;
      if (parama != null) {
        break label525;
      }
      parama = null;
      localObject1 = paramRecordConfigProvider.NHR;
      if (localObject1 != null) {
        break label536;
      }
      localObject1 = null;
      ((com.tencent.mm.plugin.recordvideo.plugin.e)localObject2).c(parama, (Integer)localObject1);
      localObject2 = this.NNi;
      parama = paramRecordConfigProvider.NHR;
      if (parama != null) {
        break label549;
      }
      parama = null;
      label275:
      localObject1 = paramRecordConfigProvider.NHR;
      if (localObject1 != null) {
        break label560;
      }
      localObject1 = localObject4;
      label290:
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject2).NLQ.getFinishButton();
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((Button)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((Button)localObject2).setTextColor(androidx.core.content.a.w(((Button)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      this.NNo.setScene(paramRecordConfigProvider.scene);
      parama = ((Iterable)getPluginList()).iterator();
      label388:
      if (!parama.hasNext()) {
        return;
      }
      localObject1 = (v)parama.next();
      localObject2 = paramRecordConfigProvider.NHR;
      if (localObject2 != null) {
        break label573;
      }
      bool = false;
      label422:
      if (bool) {
        break label639;
      }
      i = 1;
      label429:
      if (i == 0) {
        break label644;
      }
    }
    label644:
    for (int i = 0;; i = 8)
    {
      ((v)localObject1).setVisibility(i);
      break label388;
      parama = Integer.valueOf(parama.lZt);
      break;
      label457:
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).lZu);
      break label117;
      label470:
      localObject2 = ((UICustomParam)localObject2).text;
      break label131;
      label480:
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).lZv);
      break label145;
      label493:
      parama = Integer.valueOf(parama.lZt);
      break label174;
      label504:
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).lZu);
      break label188;
      label517:
      parama = parama.lZw;
      break label213;
      label525:
      parama = Integer.valueOf(parama.lZt);
      break label236;
      label536:
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).lZu);
      break label250;
      label549:
      parama = Integer.valueOf(parama.lZt);
      break label275;
      label560:
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).lZu);
      break label290;
      label573:
      localObject2 = ((UICustomParam)localObject2).lZs;
      if (localObject2 == null)
      {
        bool = false;
        break label422;
      }
      localObject3 = m.ObJ;
      localObject2 = (Boolean)((Map)localObject2).get(m.aTK(((v)localObject1).name()));
      if (localObject2 == null)
      {
        bool = false;
        break label422;
      }
      bool = ((Boolean)localObject2).booleanValue();
      break label422;
      label639:
      i = 0;
      break label429;
    }
  }
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    kotlin.g.b.s.u(paramc, "status");
    if (paramc != a.c.NOK) {
      Log.i("MicroMsg.EditorVideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    int j;
    label755:
    int k;
    label1043:
    label1078:
    label1084:
    label1098:
    boolean bool;
    label1336:
    label1348:
    int m;
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      Log.e("MicroMsg.EditorVideoPluginLayout", kotlin.g.b.s.X("unknown status ", paramc));
      paramc = ah.aiuX;
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      this.NNd.setVisibility(4);
      paramc = ah.aiuX;
      return;
    case 6: 
      paramc = this.NNn;
      paramc.Esh.setBackgroundColor(paramc.Esh.getContext().getResources().getColor(b.b.black));
      paramc = ah.aiuX;
      return;
    case 7: 
      paramc = this.NNh;
      localObject1 = this.NKf;
      kotlin.g.b.s.checkNotNull(localObject1);
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject1, this.oaV);
      this.NNc.setVisibility(0);
      this.NNd.setVisibility(0);
      if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP"))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          this.NNh.gIV();
        }
        paramc = ah.aiuX;
        return;
      }
    case 8: 
      this.NNd.setVisibility(0);
      paramc = this.NNc;
      paramBundle = paramc.NJR;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramc = paramc.NJS;
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      paramc = ah.aiuX;
      return;
    case 9: 
      localObject1 = this.NNc;
      if (paramBundle == null) {}
      for (paramc = null;; paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO"))
      {
        if (paramc != null)
        {
          paramBundle = ((j)localObject1).NJQ;
          kotlin.g.b.s.u(paramc, "emojiInfo");
          localObject1 = paramBundle.getContext();
          kotlin.g.b.s.s(localObject1, "context");
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.f((Context)localObject1);
          localObject2 = paramBundle.oaV;
          if (localObject2 != null)
          {
            localObject2 = ((RecordConfigProvider)localObject2).NHR;
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).aM(((UICustomParam)localObject2).lZo, ((UICustomParam)localObject2).lZp);
            }
          }
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          paramBundle.yms.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          localObject2 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
          localObject2 = com.tencent.mm.plugin.recordvideo.background.e.gGL();
          localObject3 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.gGN());
          localObject2 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.gGM());
          d.a.a((com.tencent.mm.plugin.recordvideo.ui.editor.view.d)localObject1, paramBundle.NYn);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.NYI);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).setEmojiInfo(paramc);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).resume();
          if (paramBundle.NYu) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f)localObject1).pause();
          }
          paramBundle.B((View)localObject1, true);
          paramBundle.removeCallbacks(paramBundle.ymy);
          paramBundle.postDelayed(paramBundle.ymy, 1500L);
          paramBundle.gKt();
        }
        paramc = ah.aiuX;
        return;
      }
    case 10: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        localObject1 = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
        paramBundle = getItemContainerPlugin();
        kotlin.g.b.s.checkNotNull(localObject1);
        paramc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.r(paramc, i, j, (String)localObject1);
        kotlin.g.b.s.u(paramc, "item");
        if (paramBundle.NJR == null) {
          break label755;
        }
        localObject1 = paramBundle.NJR;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setVisibility(0);
        }
        localObject1 = paramBundle.NJR;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setText(paramc);
        }
        paramBundle.NJR = null;
      }
      for (;;)
      {
        paramc = ah.aiuX;
        paramc = ah.aiuX;
        return;
        paramBundle = paramBundle.NJQ;
        kotlin.g.b.s.u(paramc, "item");
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.s(paramBundle.getContext());
        localObject2 = paramBundle.oaV;
        if (localObject2 != null)
        {
          localObject2 = ((RecordConfigProvider)localObject2).NHR;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).aM(((UICustomParam)localObject2).lZq, ((UICustomParam)localObject2).lZr);
          }
        }
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        paramBundle.yms.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.gGL();
        localObject3 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).b((Rect)localObject2, com.tencent.mm.plugin.recordvideo.background.e.gGN());
        localObject2 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setValidArea(com.tencent.mm.plugin.recordvideo.background.e.gGM());
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).a(paramBundle.NYn, paramBundle.heightPercent);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setStateResolve((EditorItemContainer.b)paramBundle.NYI);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setText(paramc);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.s)localObject1).setOnClickListener(paramBundle.NYD);
        paramBundle.B((View)localObject1, true);
        paramBundle.removeCallbacks(paramBundle.ymy);
        paramBundle.postDelayed(paramBundle.ymy, 1500L);
        paramBundle.gKt();
      }
    case 11: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        k = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        if ((paramc != null) && (paramc.length() != 0)) {
          break label1078;
        }
        i = 1;
        if (i == 0) {
          break label1098;
        }
        getItemContainerPlugin().NJQ.gKu();
        j = getItemContainerPlugin().NJQ.getLocationItemHeight();
        if (j != 0) {
          break label1084;
        }
        i = 0;
        k = bd.fromDPToPix(getContext(), 44);
        getAddTipPlugin().agz(i + j + k);
      }
      for (;;)
      {
        paramc = ah.aiuX;
        paramc = ah.aiuX;
        return;
        i = 0;
        break;
        i = bd.fromDPToPix(getContext(), 24);
        break label1043;
        getItemContainerPlugin().aI(paramc.toString(), j, k);
      }
    case 12: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        com.tencent.mm.plugin.recordvideo.plugin.e.a(getAddTextPlugin(), paramc, i, j);
        paramc = ah.aiuX;
      }
      paramc = ah.aiuX;
      return;
    case 13: 
      if (paramBundle != null)
      {
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramBundle = getAddTipPlugin();
        paramBundle.NJH.mode = 1;
        paramBundle.NJH.setShow(true);
        paramBundle.NJH.e(paramc, i, j);
        paramc = ah.aiuX;
      }
      paramc = ah.aiuX;
      return;
    case 14: 
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
        paramc = getPreviewPlugin().KZh;
        if (paramc != null) {
          paramc.setMute(bool);
        }
        paramc = ah.aiuX;
      }
      paramc = ah.aiuX;
      return;
    case 15: 
      this.NNi.Bb(true);
      paramc = ah.aiuX;
      return;
    case 16: 
      this.NNd.setVisibility(4);
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", false);
        paramBundle = getPreviewPlugin();
        paramBundle.NKN = true;
        paramc = paramBundle.gIE();
        if (paramc != null) {
          break label1836;
        }
        j = 0;
        paramc = paramBundle.gIE();
        if (paramc != null) {
          break label1845;
        }
        k = 0;
        m = com.tencent.mm.cd.a.fromDPToPix(paramBundle.context, 20) + com.tencent.mm.cd.a.fromDPToPix(paramBundle.context, 95) + com.tencent.mm.cd.a.fromDPToPix(paramBundle.context, 12);
        if (!bf.bg(paramBundle.context)) {
          break label2872;
        }
        m += bf.bk(paramBundle.context);
      }
      break;
    }
    label1836:
    label1845:
    label2872:
    for (;;)
    {
      i = 0;
      if (bool)
      {
        i = com.tencent.mm.cd.a.fromDPToPix(paramBundle.context, 56) + 0;
        if (aw.bx(paramBundle.context))
        {
          Log.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is true，videoViewTopMargin: " + i + ", cutout height is " + aw.bw(paramBundle.context));
          i += aw.bw(paramBundle.context);
        }
      }
      else
      {
        label1484:
        paramc = paramBundle.gIE();
        if (paramc != null) {
          break label1866;
        }
        paramc = null;
        label1495:
        if (paramc != null) {
          break label1877;
        }
        n = m + 0;
        label1505:
        if (n >= com.tencent.mm.plugin.mmsight.d.iQ(paramBundle.context).y) {
          break label2859;
        }
      }
      for (int n = (int)((j - com.tencent.mm.cd.a.fromDPToPix(paramBundle.context, 32) * 2) / (j / k));; n = k - m - i)
      {
        int i1 = (int)(j / k * n);
        float f1 = i1 / j;
        float f2 = n / k;
        float f3 = -(Math.abs(m - i) / 2.0F);
        Log.i("MicroMsg.EditVideoPlayPlugin", "scaleX: " + f1 + ", scaleY: " + f2 + ", translationY: " + f3);
        Log.i("MicroMsg.EditVideoPlayPlugin", "isShowWeseeBtn: " + bool + ", videoViewWidth: " + j + ", videoViewHeight: " + k + ", videoViewBottomMargin:" + m + ", videoViewTopMargin:" + i + ", videoViewScaleHeight: " + n + ", videoViewScaleWidth: " + i1);
        paramc = paramBundle.gIE();
        if (paramc != null)
        {
          paramc = paramc.animate();
          if (paramc != null)
          {
            paramc = paramc.scaleX(f1);
            if (paramc != null)
            {
              paramc = paramc.scaleY(f2);
              if (paramc != null)
              {
                paramc = paramc.translationY(f3);
                if (paramc != null)
                {
                  paramc = paramc.setDuration(300L);
                  if (paramc != null) {
                    paramc.setListener((Animator.AnimatorListener)new u.b(paramBundle));
                  }
                }
              }
            }
          }
        }
        paramc = ah.aiuX;
        this.NNc.gIs();
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        paramc = ah.aiuX;
        return;
        j = paramc.getWidth();
        break label1336;
        k = paramc.getHeight();
        break label1348;
        Log.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is false");
        break label1484;
        label1866:
        paramc = Integer.valueOf(paramc.getBottom());
        break label1495;
        label1877:
        n = paramc.intValue();
        break label1505;
        if (paramBundle != null)
        {
          i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
          j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
          paramc = getPreviewPlugin();
          paramc.startTime = i;
          paramc.endTime = j;
          paramBundle = paramc.KZh;
          if (paramBundle != null) {
            paramBundle.c(paramc.startTime, true);
          }
          paramc = ah.aiuX;
        }
        paramc = ah.aiuX;
        return;
        getPreviewPlugin().onPause();
        paramc = ah.aiuX;
        return;
        getPreviewPlugin().onResume();
        paramc = ah.aiuX;
        return;
        if (paramBundle != null)
        {
          i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
          paramc = getPreviewPlugin().KZh;
          if (paramc != null) {
            paramc.c(i, true);
          }
          paramc = ah.aiuX;
        }
        paramc = ah.aiuX;
        return;
        if (paramBundle != null)
        {
          i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
          paramc = getCropVideoPlugin();
          if (paramc.NLQ.getVisibility() == 0)
          {
            paramc = paramc.NLQ;
            paramc.Leu.setCurrentCursorPosition(i / paramc.Leu.getDurationMs());
          }
          paramc = ah.aiuX;
        }
        paramc = ah.aiuX;
        return;
        paramc = this.NKf;
        if (paramc != null)
        {
          paramBundle = getConfigProvider();
          if (paramBundle == null) {
            i = 10000;
          }
          while (paramc.endTime - paramc.startTime > i + 250)
          {
            paramc = com.tencent.mm.plugin.recordvideo.f.g.NRB;
            com.tencent.mm.plugin.recordvideo.f.g.aQ(2, 3L);
            paramc = getContext();
            if (paramc == null)
            {
              throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              i = paramBundle.NHZ;
            }
            else
            {
              ((Activity)paramc).setResult(3000);
              paramc = getContext();
              if (paramc == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
              }
              ((Activity)paramc).finish();
              return;
            }
          }
          getVideoControlContainerPlugin().setVisibility(0);
          getPreviewPlugin().AX(false);
          getItemContainerPlugin().gIt();
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
          paramc = ah.aiuX;
        }
        paramc = ah.aiuX;
        return;
        this.NNd.setVisibility(0);
        this.NNh.gIV();
        getPreviewPlugin().AX(true);
        this.NNc.gIt();
        paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        paramc = ah.aiuX;
        return;
        paramc = com.tencent.mm.plugin.recordvideo.f.g.NRB;
        com.tencent.mm.plugin.recordvideo.f.g.aQ(2, 3L);
        onBackPress();
        paramc = ah.aiuX;
        return;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getByteArray("PARAM_EDIT_POI_INFO");
          paramc = getItemContainerPlugin();
          paramBundle = new enw().parseFrom(paramBundle);
          if (paramBundle == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecordLocationInfo");
          }
          paramBundle = (enw)paramBundle;
          kotlin.g.b.s.u(paramBundle, "storyLocation");
          if ((Util.isNullOrNil(paramBundle.poiName)) && (Util.isNullOrNil(paramBundle.pSh))) {
            break label2512;
          }
          i = 1;
          if (i == 0) {
            break label2529;
          }
          if (!paramc.NJQ.gKw()) {
            break label2518;
          }
          paramc = paramc.NJQ;
          kotlin.g.b.s.u(paramBundle, "sl");
          if (paramc.NYz != null)
          {
            paramc.bL((kotlin.g.a.a)EditorItemContainer.d.NYK);
            paramc.a(paramBundle);
          }
          j = getItemContainerPlugin().NJQ.getLocationItemHeight();
          if (j != 0) {
            break label2555;
          }
        }
        label2512:
        label2518:
        label2529:
        label2555:
        for (i = 0;; i = bd.fromDPToPix(getContext(), 24))
        {
          k = bd.fromDPToPix(getContext(), 44);
          if (!getItemContainerPlugin().gIp()) {
            getAddTipPlugin().agz(i + j + k);
          }
          paramc = ah.aiuX;
          paramc = ah.aiuX;
          return;
          i = 0;
          break;
          paramc.NJQ.a(paramBundle);
          break label2447;
          if (!paramc.NJQ.gKw()) {
            break label2447;
          }
          paramc.NJQ.bL((kotlin.g.a.a)j.a.NJU);
          break label2447;
        }
        this.NNg.enT();
        paramc = ah.aiuX;
        return;
        if (paramBundle != null)
        {
          bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
          paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
          paramc = new ArrayList();
          if (paramBundle != null)
          {
            paramBundle = ((Iterable)paramBundle.NJq).iterator();
            for (;;)
            {
              if (paramBundle.hasNext())
              {
                localObject2 = (byte[])paramBundle.next();
                localObject1 = new dki();
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
                    Log.printDebugStack("safeParser", "", new Object[] { localException });
                  }
                }
              }
            }
            paramBundle = ah.aiuX;
            paramBundle = ah.aiuX;
          }
          paramBundle = getItemContainerPlugin();
          paramc = (List)paramc;
          kotlin.g.b.s.u(paramc, "lyricsInfo");
          if (!bool) {
            break label2809;
          }
          if (paramBundle.NJQ.NYA == null) {
            break label2792;
          }
          i = 1;
          if (i == 0) {
            break label2798;
          }
          paramBundle = paramBundle.NJQ;
          kotlin.g.b.s.u(paramc, "lyricsItemInfos");
          if (paramBundle.NYA != null)
          {
            paramBundle.gKv();
            paramBundle.jR(paramc);
          }
        }
        for (;;)
        {
          paramc = ah.aiuX;
          paramc = ah.aiuX;
          return;
          label2792:
          i = 0;
          break;
          label2798:
          paramBundle.NJQ.jR(paramc);
          continue;
          label2809:
          paramBundle.NJQ.gKv();
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaH.ordinal()) {
          getAddMusicPlugin().Gso.Bu(false);
        }
        paramc = ah.aiuX;
        paramc = ah.aiuX;
        return;
      }
    }
  }
  
  public final void a(v paramv)
  {
    a.b.a(this, paramv);
  }
  
  protected final void aTf(String paramString)
  {
    kotlin.g.b.s.u(paramString, "tip");
    Log.i("MicroMsg.EditorVideoPluginLayout", "showDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread(new BaseEditVideoPluginLayout..ExternalSyntheticLambda1(this, paramString));
  }
  
  public final void ful()
  {
    if (this.rYw == null) {
      return;
    }
    Log.i("MicroMsg.EditorVideoPluginLayout", "hideDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread(new BaseEditVideoPluginLayout..ExternalSyntheticLambda0(this));
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.c getAddEmojiPlugin()
  {
    return this.NNb;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a.a getAddMusicPlugin()
  {
    return this.NNh;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.d getAddPoiPlugin()
  {
    return this.NNg;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.e getAddTextPlugin()
  {
    return this.NNe;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.f getAddTipPlugin()
  {
    return this.NNf;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.r getAddonTextPlugin()
  {
    return this.NNm;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.g getBackToRecordPlugin()
  {
    return this.NNk;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.s getBgPlugin()
  {
    return this.NNn;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.NKf;
  }
  
  public final RecordConfigProvider getConfigProvider()
  {
    return this.oaV;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a getCropVideoPlugin()
  {
    return this.NNi;
  }
  
  public final h getEditFinishPlugin()
  {
    return this.NNj;
  }
  
  protected final i getInputPlugin()
  {
    return this.NNp;
  }
  
  protected final j getItemContainerPlugin()
  {
    return this.NNc;
  }
  
  public int getLayoutId()
  {
    return b.f.video_edit_plugin_layout_new;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.k getMoreMenuPlugin()
  {
    return this.NNo;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.activity.a getNavigator()
  {
    return this.Fiu;
  }
  
  public abstract View getPlayerView();
  
  public final u getPreviewPlugin()
  {
    u localu = this.NNa;
    if (localu != null) {
      return localu;
    }
    kotlin.g.b.s.bIx("previewPlugin");
    return null;
  }
  
  protected final ae getReMuxPlugin()
  {
    return this.NNl;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.t getVideoControlContainerPlugin()
  {
    return this.NNd;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.NKf = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.oaV = paramRecordConfigProvider;
  }
  
  protected final void setNavigator(com.tencent.mm.plugin.recordvideo.activity.a parama)
  {
    this.Fiu = parama;
  }
  
  protected final void setPreviewPlugin(u paramu)
  {
    kotlin.g.b.s.u(paramu, "<set-?>");
    this.NNa = paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */