package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.c;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.h.a;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.plugin.recordvideo.plugin.r;
import com.tencent.mm.plugin.recordvideo.plugin.s;
import com.tencent.mm.plugin.recordvideo.plugin.s.b;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "getAddMusicPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "getAddPoiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "getAddTipPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "getAddonTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "getBgPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "getCropVideoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "getInputPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "getItemContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "moreMenuPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "getMoreMenuPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getNavigator", "()Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "setNavigator", "(Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;)V", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;)V", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "getReMuxPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getVideoControlContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getLayoutId", "", "getPlayerView", "Landroid/view/View;", "hideDialog", "", "initLogic", "initSafeArea", "loadCurrentPage", "info", "loadPlayerView", "showDialog", "tip", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public abstract class BaseEditVideoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final a vnd = new a((byte)0);
  public com.tencent.mm.ui.base.p lAj;
  private RecordConfigProvider vcC;
  private com.tencent.mm.media.widget.camerarecordview.b.b vjS;
  private com.tencent.mm.plugin.recordvideo.activity.a vmM;
  protected s vmN;
  private final com.tencent.mm.plugin.recordvideo.plugin.a vmO;
  private final com.tencent.mm.plugin.recordvideo.plugin.h vmP;
  private final r vmQ;
  private final c vmR;
  private final com.tencent.mm.plugin.recordvideo.plugin.d vmS;
  private final com.tencent.mm.plugin.recordvideo.plugin.b vmT;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a vmU;
  private final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a vmV;
  private final f vmW;
  private final e vmX;
  private final ab vmY;
  private final com.tencent.mm.plugin.recordvideo.plugin.p vmZ;
  private final q vna;
  private final i vnb;
  private final com.tencent.mm.plugin.recordvideo.plugin.g vnc;
  
  public BaseEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.vmY = new ab(paramContext);
    ad.i("MicroMsg.EditorVideoPluginLayout", "EditorVideoPluginLayoutNew invoke init");
    LayoutInflater.from(paramContext).inflate(getLayoutId(), (ViewGroup)this, true);
    paramContext = getPlayerView();
    paramAttributeSet = (ViewStub)findViewById(2131303271);
    k.g(paramAttributeSet, "placeholder");
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
    k.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.vmO = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    paramContext = findViewById(2131299293);
    k.g(paramContext, "findViewById(R.id.editor_item_container)");
    this.vmP = new com.tencent.mm.plugin.recordvideo.plugin.h((EditorItemContainer)paramContext, (d)this);
    paramContext = findViewById(2131298784);
    k.g(paramContext, "findViewById(R.id.control_container)");
    this.vmQ = new r((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131297952);
    k.g(paramContext, "findViewById(R.id.change_text_root)");
    this.vnc = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramContext);
    this.vmR = new c((ViewGroup)this, (d)this, this.vnc.vjw);
    this.vmU = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (d)this);
    this.vmV = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a((ViewGroup)this, (d)this);
    paramContext = findViewById(2131299295);
    k.g(paramContext, "findViewById(R.id.editor_mix)");
    this.vmW = new f(paramContext, (d)this);
    paramContext = findViewById(2131299285);
    k.g(paramContext, "findViewById(R.id.editor_close)");
    this.vmX = new e((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299621);
    k.g(paramContext, "findViewById(R.id.ext_text_area)");
    this.vmZ = new com.tencent.mm.plugin.recordvideo.plugin.p((TextView)paramContext, (d)this);
    paramContext = findViewById(2131303907);
    k.g(paramContext, "findViewById(R.id.recorder_black_mask)");
    this.vna = new q((ImageView)paramContext, (d)this);
    this.vmS = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (d)this, this.vnc.vjw);
    this.vmT = new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)this, (d)this);
    this.vnb = new i((ViewGroup)this, (d)this);
    getPluginList().add(this.vmO);
    getPluginList().add(this.vmP);
    getPluginList().add(this.vmQ);
    getPluginList().add(this.vmR);
    getPluginList().add(this.vmU);
    getPluginList().add(this.vmV);
    getPluginList().add(this.vmW);
    getPluginList().add(this.vmY);
    getPluginList().add(this.vmX);
    getPluginList().add(this.vmZ);
    getPluginList().add(this.vna);
    getPluginList().add(this.vmS);
    getPluginList().add(this.vmT);
    getPluginList().add(this.vnb);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.viq;
    i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.viq;
    int j = com.tencent.mm.plugin.recordvideo.model.a.dhH();
    float f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = j * 1.78F;
    float f5 = (i - f4) / 2.0F;
    if (f1 <= 1.78F)
    {
      this.vnc.bi(f3);
      this.vmP.R(f2, f3);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.vnc.bj(f3);
      this.vmP.S(f4, f5);
      return;
    }
    this.vnc.bi(f3);
    this.vnc.bj(f3);
    this.vmP.R(f2, f3);
    this.vmP.S(f4, f5);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    super.a(paramb);
    this.vjS = paramb;
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    k.h(parama, "navigator");
    k.h(paramRecordConfigProvider, "configProvider");
    this.vmM = parama;
    this.vcC = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.vtE;
    com.tencent.mm.plugin.recordvideo.e.b.d(paramRecordConfigProvider);
    parama = this.vmP;
    k.h(paramRecordConfigProvider, "configProvider");
    parama.vjE.a(paramRecordConfigProvider);
    this.vmU.setVisibility(0);
    this.vmV.setVisibility(0);
    f localf = this.vmW;
    parama = paramRecordConfigProvider.vhI;
    Object localObject1;
    label115:
    Object localObject2;
    label133:
    Object localObject3;
    label154:
    label189:
    label210:
    label238:
    boolean bool;
    if (parama != null)
    {
      parama = Integer.valueOf(parama.fGS);
      localObject1 = paramRecordConfigProvider.vhI;
      if (localObject1 == null) {
        break label588;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fGT);
      localObject2 = paramRecordConfigProvider.vhI;
      if (localObject2 == null) {
        break label594;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.vhI;
      if (localObject3 == null) {
        break label600;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).fGU);
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.vmU;
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label606;
      }
      parama = Integer.valueOf(parama.fGS);
      localObject1 = paramRecordConfigProvider.vhI;
      if (localObject1 == null) {
        break label611;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fGT);
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = this.vmZ;
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label617;
      }
      parama = parama.fGV;
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = this.vmR;
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label622;
      }
      parama = Integer.valueOf(parama.fGS);
      label267:
      localObject1 = paramRecordConfigProvider.vhI;
      if (localObject1 == null) {
        break label627;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fGT);
      label288:
      ((c)localObject2).a(parama, (Integer)localObject1);
      localObject2 = this.vmV;
      parama = paramRecordConfigProvider.vhI;
      if (parama == null) {
        break label633;
      }
      parama = Integer.valueOf(parama.fGS);
      label319:
      localObject3 = paramRecordConfigProvider.vhI;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).fGT);
      }
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject2).vlQ.getFinishButton();
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((Button)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((Button)localObject2).setTextColor(android.support.v4.content.b.n(((Button)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      this.vnb.setScene(paramRecordConfigProvider.scene);
      parama = this.vmS;
      localObject1 = paramRecordConfigProvider.vhI.fGR;
      k.g(localObject1, "configProvider.uiParam.pluginHiddenMap");
      if (!((Map)localObject1).containsKey("plugin_tip")) {
        break label638;
      }
      i = 8;
      label467:
      parama.vjz = i;
      parama = ((Iterable)getPluginList()).iterator();
      label485:
      if (!parama.hasNext()) {
        return;
      }
      localObject1 = (t)parama.next();
      localObject2 = paramRecordConfigProvider.vhI;
      if (localObject2 == null) {
        break label643;
      }
      localObject2 = ((UICustomParam)localObject2).fGR;
      if (localObject2 == null) {
        break label643;
      }
      localObject2 = (Boolean)((Map)localObject2).get(((t)localObject1).name());
      if (localObject2 == null) {
        break label643;
      }
      bool = ((Boolean)localObject2).booleanValue();
      label559:
      if (bool) {
        break label649;
      }
      i = 1;
      label566:
      if (i == 0) {
        break label654;
      }
    }
    label643:
    label649:
    label654:
    for (int i = 0;; i = 8)
    {
      ((t)localObject1).setVisibility(i);
      break label485;
      parama = null;
      break;
      label588:
      localObject1 = null;
      break label115;
      label594:
      localObject2 = null;
      break label133;
      label600:
      localObject3 = null;
      break label154;
      label606:
      parama = null;
      break label189;
      label611:
      localObject1 = null;
      break label210;
      label617:
      parama = null;
      break label238;
      label622:
      parama = null;
      break label267;
      label627:
      localObject1 = null;
      break label288;
      label633:
      parama = null;
      break label319;
      label638:
      i = 0;
      break label467;
      bool = false;
      break label559;
      i = 0;
      break label566;
    }
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    k.h(paramc, "status");
    if (paramc != d.c.vob) {
      ad.i("MicroMsg.EditorVideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    Object localObject;
    int i;
    int j;
    int k;
    label568:
    label605:
    label619:
    boolean bool;
    int m;
    int n;
    switch (a.ciE[paramc.ordinal()])
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
                  this.vmQ.setVisibility(4);
                  return;
                  this.vna.fYe();
                  return;
                  paramc = this.vmU;
                  localObject = this.vjS;
                  if (localObject == null) {
                    k.fvU();
                  }
                  com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject, this.vcC);
                  this.vmP.setVisibility(0);
                  this.vmQ.setVisibility(0);
                  if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP")))
                  {
                    this.vmU.dit();
                    return;
                    this.vmQ.setVisibility(0);
                    paramc = this.vmP;
                    paramBundle = paramc.vjC;
                    if (paramBundle != null) {
                      paramBundle.setVisibility(0);
                    }
                    paramc = paramc.vjD;
                    if (paramc != null)
                    {
                      paramc.setVisibility(0);
                      return;
                      localObject = this.vmP;
                      if (paramBundle != null) {}
                      for (paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO"); paramc != null; paramc = null)
                      {
                        ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject).vjE.O(paramc);
                        return;
                      }
                    }
                  }
                }
              } while (paramBundle == null);
              localObject = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
              i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
              j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
              paramc = this.vmP;
              paramBundle = localObject.toString();
              k.h(paramBundle, "text");
              if (paramc.vjC != null)
              {
                localObject = paramc.vjC;
                if (localObject != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject).setVisibility(0);
                }
                localObject = paramc.vjC;
                if (localObject != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject).setText((CharSequence)paramBundle, i, j);
                }
                paramc.vjC = null;
              }
              for (;;)
              {
                paramc = y.JfV;
                return;
                paramc.vjE.n((CharSequence)paramBundle, i, j);
              }
            } while (paramBundle == null);
            paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
            j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
            k = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
            if ((paramc == null) || (paramc.length() == 0))
            {
              i = 1;
              if (i == 0) {
                break label619;
              }
              this.vmP.vjE.diW();
              j = this.vmP.vjE.getLocationItemHeight();
              if (j != 0) {
                break label605;
              }
              i = 0;
              k = ao.fromDPToPix(getContext(), 44);
              this.vmS.Kk(i + j + k);
            }
            for (;;)
            {
              paramc = y.JfV;
              return;
              i = 0;
              break;
              i = ao.fromDPToPix(getContext(), 24);
              break label568;
              this.vmP.as(paramc.toString(), j, k);
            }
          } while (paramBundle == null);
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          this.vmR.g(paramc, i, j);
          paramc = y.JfV;
          return;
        } while (paramBundle == null);
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        this.vmS.g(paramc, i, j);
        paramc = y.JfV;
        return;
      } while (paramBundle == null);
      bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
      paramc = this.vmN;
      if (paramc == null) {
        k.aPZ("previewPlugin");
      }
      paramc.tFN.setMute(bool);
      paramc = y.JfV;
      return;
    case 15: 
      this.vmV.ou(true);
      return;
    case 16: 
      this.vmQ.setVisibility(4);
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", false);
        paramc = this.vmN;
        if (paramc == null) {
          k.aPZ("previewPlugin");
        }
        paramc.vkI = true;
        paramBundle = paramc.tFN.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        m = ((ViewGroup)paramBundle).getWidth();
        paramBundle = paramc.tFN.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        n = ((ViewGroup)paramBundle).getHeight();
        j = com.tencent.mm.cd.a.fromDPToPix(paramc.context, 20) + com.tencent.mm.cd.a.fromDPToPix(paramc.context, 95) + com.tencent.mm.cd.a.fromDPToPix(paramc.context, 12);
        if (!ap.ju(paramc.context)) {
          break label2405;
        }
        j += ap.eb(paramc.context);
      }
      break;
    }
    label1920:
    label1940:
    label2005:
    label2138:
    label2144:
    label2405:
    for (;;)
    {
      i = 0;
      if (bool)
      {
        i = com.tencent.mm.cd.a.fromDPToPix(paramc.context, 56) + 0;
        if (ai.aF(paramc.context))
        {
          ad.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is true，videoViewTopMargin: " + i + ", cutout height is " + ai.aE(paramc.context));
          i += ai.aE(paramc.context);
        }
      }
      for (;;)
      {
        paramBundle = paramc.tFN.getParent();
        if (paramBundle != null) {
          break;
        }
        throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        ad.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is false");
      }
      if (((ViewGroup)paramBundle).getBottom() + j < com.tencent.mm.plugin.mmsight.d.fv(paramc.context).y) {}
      for (k = (int)((m - com.tencent.mm.cd.a.fromDPToPix(paramc.context, 32) * 2) / (m / n));; k = n - j - i)
      {
        int i1 = (int)(m / n * k);
        float f1 = i1 / m;
        float f2 = k / n;
        float f3 = -(Math.abs(j - i) / 2.0F);
        ad.i("MicroMsg.EditVideoPlayPlugin", "scaleX: " + f1 + ", scaleY: " + f2 + ", translationY: " + f3);
        ad.i("MicroMsg.EditVideoPlayPlugin", "isShowWeseeBtn: " + bool + ", videoViewWidth: " + m + ", videoViewHeight: " + n + ", videoViewBottomMargin:" + j + ", videoViewTopMargin:" + i + ", videoViewScaleHeight: " + k + ", videoViewScaleWidth: " + i1);
        paramBundle = paramc.tFN.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)paramBundle).animate().scaleX(f1).scaleY(f2).translationY(f3).setDuration(300L).setListener((Animator.AnimatorListener)new s.b(paramc));
        paramc = y.JfV;
        this.vmP.vjE.setEnableTouch(false);
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramc = this.vmN;
        if (paramc == null) {
          k.aPZ("previewPlugin");
        }
        paramc.cUL = i;
        paramc.gBm = j;
        paramc.tFN.d(paramc.cUL, true);
        paramc = y.JfV;
        return;
        paramc = this.vmN;
        if (paramc == null) {
          k.aPZ("previewPlugin");
        }
        paramc.onPause();
        return;
        paramc = this.vmN;
        if (paramc == null) {
          k.aPZ("previewPlugin");
        }
        paramc.onResume();
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.vmN;
        if (paramc == null) {
          k.aPZ("previewPlugin");
        }
        paramc.tFN.d(i, true);
        paramc = y.JfV;
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.vmV;
        if (paramc.vlQ.getVisibility() == 0)
        {
          paramc = paramc.vlQ;
          paramc.tLG.setCurrentCursorPosition(i / paramc.tLG.getDurationMs());
        }
        paramc = y.JfV;
        return;
        paramc = this.vjS;
        if (paramc == null) {
          break;
        }
        paramBundle = this.vcC;
        if (paramBundle != null) {
          i = paramBundle.vhQ;
        }
        while (paramc.gBm - paramc.cUL > i + 250)
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
        this.vmQ.setVisibility(0);
        paramc = this.vmN;
        if (paramc == null) {
          k.aPZ("previewPlugin");
        }
        paramc.os(false);
        this.vmP.dif();
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        paramc = y.JfV;
        return;
        this.vmQ.setVisibility(0);
        this.vmU.dit();
        paramc = this.vmN;
        if (paramc == null) {
          k.aPZ("previewPlugin");
        }
        paramc.os(true);
        this.vmP.dif();
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        dia();
        return;
        if (paramBundle == null) {
          break;
        }
        paramBundle = paramBundle.getByteArray("PARAM_EDIT_POI_INFO");
        paramc = this.vmP;
        paramBundle = new chx().parseFrom(paramBundle);
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecordLocationInfo");
        }
        paramBundle = (chx)paramBundle;
        k.h(paramBundle, "storyLocation");
        if ((!bt.isNullOrNil(paramBundle.goQ)) || (!bt.isNullOrNil(paramBundle.ijO)))
        {
          i = 1;
          if (i == 0) {
            break label2098;
          }
          if (!paramc.vjE.diY()) {
            break label2087;
          }
          paramc.vjE.c(paramBundle);
          m = this.vmP.vjE.getLocationItemHeight();
          if (m != 0) {
            break label2124;
          }
          i = 0;
          n = ao.fromDPToPix(getContext(), 44);
          localObject = this.vmP;
          if (!((com.tencent.mm.plugin.recordvideo.plugin.h)localObject).vjE.fYu()) {
            break label2150;
          }
          paramc = ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject).vjE.getTipItemView();
          if (paramc != null)
          {
            paramc = paramc.getText();
            if (paramc != null)
            {
              paramBundle = paramc.toString();
              paramc = paramBundle;
              if (paramBundle != null) {
                break label2005;
              }
            }
          }
          paramc = "";
          paramBundle = ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject).vjE.getTipItemView();
          if (paramBundle == null) {
            break label2138;
          }
          j = paramBundle.getColor();
          label2024:
          paramBundle = ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject).vjE.getTipItemView();
          if (paramBundle == null) {
            break label2144;
          }
          k = paramBundle.getTextBg();
          label2043:
          ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject).as(paramc, j, k);
        }
        label2150:
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            this.vmS.Kk(i + m + n);
          }
          paramc = y.JfV;
          return;
          i = 0;
          break;
          paramc.vjE.a(paramBundle);
          break label1920;
          if (!paramc.vjE.diY()) {
            break label1920;
          }
          paramc.vjE.y((d.g.a.a)h.a.vjG);
          break label1920;
          i = ao.fromDPToPix(getContext(), 24);
          break label1940;
          j = 0;
          break label2024;
          k = 0;
          break label2043;
        }
        this.vmT.dib();
        return;
        if (paramBundle == null) {
          break;
        }
        bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
        paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
        paramc = new ArrayList();
        if (paramBundle != null)
        {
          paramBundle = ((Iterable)paramBundle.vjg).iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              byte[] arrayOfByte = (byte[])paramBundle.next();
              localObject = new bmx();
              com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)localObject;
              try
              {
                locala.parseFrom(arrayOfByte);
                paramc.add(localObject);
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
          paramBundle = y.JfV;
        }
        paramBundle = this.vmP;
        paramc = (List)paramc;
        k.h(paramc, "lyricsInfo");
        if (bool) {
          if (paramBundle.vjE.fYt()) {
            paramBundle.vjE.iY(paramc);
          }
        }
        for (;;)
        {
          paramc = y.JfV;
          return;
          paramBundle.vjE.eO(paramc);
          continue;
          paramBundle.vjE.diX();
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.item.b.vsN.ordinal()) {
          this.vmU.fYn();
        }
        paramc = y.JfV;
        return;
      }
    }
  }
  
  protected final void alN(final String paramString)
  {
    k.h(paramString, "tip");
    ad.i("MicroMsg.EditorVideoPluginLayout", "showDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new v("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, paramString));
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a getAddEmojiPlugin()
  {
    return this.vmO;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a.a getAddMusicPlugin()
  {
    return this.vmU;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.b getAddPoiPlugin()
  {
    return this.vmT;
  }
  
  protected final c getAddTextPlugin()
  {
    return this.vmR;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.d getAddTipPlugin()
  {
    return this.vmS;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.p getAddonTextPlugin()
  {
    return this.vmZ;
  }
  
  protected final e getBackToRecordPlugin()
  {
    return this.vmX;
  }
  
  protected final q getBgPlugin()
  {
    return this.vna;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.vjS;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.vcC;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a getCropVideoPlugin()
  {
    return this.vmV;
  }
  
  protected final f getEditFinishPlugin()
  {
    return this.vmW;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.g getInputPlugin()
  {
    return this.vnc;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.h getItemContainerPlugin()
  {
    return this.vmP;
  }
  
  public int getLayoutId()
  {
    return 2131495831;
  }
  
  protected final i getMoreMenuPlugin()
  {
    return this.vnb;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.activity.a getNavigator()
  {
    return this.vmM;
  }
  
  public abstract View getPlayerView();
  
  protected final s getPreviewPlugin()
  {
    s locals = this.vmN;
    if (locals == null) {
      k.aPZ("previewPlugin");
    }
    return locals;
  }
  
  protected final ab getReMuxPlugin()
  {
    return this.vmY;
  }
  
  protected final r getVideoControlContainerPlugin()
  {
    return this.vmQ;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.vjS = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.vcC = paramRecordConfigProvider;
  }
  
  protected final void setNavigator(com.tencent.mm.plugin.recordvideo.activity.a parama)
  {
    this.vmM = parama;
  }
  
  protected final void setPreviewPlugin(s params)
  {
    k.h(params, "<set-?>");
    this.vmN = params;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(75762);
      com.tencent.mm.ui.base.p localp = BaseEditVideoPluginLayout.a(this.vne);
      if (localp != null) {
        localp.dismiss();
      }
      BaseEditVideoPluginLayout.a(this.vne, null);
      AppMethodBeat.o(75762);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(75763);
      BaseEditVideoPluginLayout.a(this.vne, com.tencent.mm.ui.base.h.b(this.vne.getContext(), paramString, false, null));
      AppMethodBeat.o(75763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */