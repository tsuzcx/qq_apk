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
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aj;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "getAddMusicPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "getAddPoiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "getAddTipPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "getAddonTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "getBgPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "getCropVideoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "getInputPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "getItemContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "moreMenuPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "getMoreMenuPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getNavigator", "()Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "setNavigator", "(Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;)V", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;)V", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "getReMuxPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getVideoControlContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getLayoutId", "", "getPlayerView", "Landroid/view/View;", "hideDialog", "", "initLogic", "initSafeArea", "loadCurrentPage", "info", "loadPlayerView", "showDialog", "tip", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public abstract class BaseEditVideoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final BaseEditVideoPluginLayout.a wvB = new BaseEditVideoPluginLayout.a((byte)0);
  public com.tencent.mm.ui.base.p mcf;
  private com.tencent.mm.plugin.recordvideo.activity.a rRh;
  private RecordConfigProvider rRi;
  private final com.tencent.mm.plugin.recordvideo.plugin.a sgB;
  private final com.tencent.mm.plugin.recordvideo.plugin.c sgC;
  private final com.tencent.mm.plugin.recordvideo.plugin.a.a sgD;
  private final f sgF;
  private final e sgG;
  private final com.tencent.mm.plugin.recordvideo.plugin.ac sgH;
  private final com.tencent.mm.plugin.recordvideo.plugin.p sgI;
  private final q sgJ;
  private final com.tencent.mm.plugin.recordvideo.plugin.g sgK;
  private com.tencent.mm.media.widget.camerarecordview.b.b sgm;
  private final r sgz;
  private final i wvA;
  protected s wvv;
  private final com.tencent.mm.plugin.recordvideo.plugin.h wvw;
  private final com.tencent.mm.plugin.recordvideo.plugin.d wvx;
  private final com.tencent.mm.plugin.recordvideo.plugin.b wvy;
  private final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a wvz;
  
  public BaseEditVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.sgH = new com.tencent.mm.plugin.recordvideo.plugin.ac(paramContext);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditorVideoPluginLayout", "EditorVideoPluginLayoutNew invoke init");
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
    this.sgB = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    paramContext = findViewById(2131299293);
    k.g(paramContext, "findViewById(R.id.editor_item_container)");
    this.wvw = new com.tencent.mm.plugin.recordvideo.plugin.h((EditorItemContainer)paramContext, (d)this);
    paramContext = findViewById(2131298784);
    k.g(paramContext, "findViewById(R.id.control_container)");
    this.sgz = new r((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131297952);
    k.g(paramContext, "findViewById(R.id.change_text_root)");
    this.sgK = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramContext);
    this.sgC = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.sgK.wsh);
    this.sgD = new com.tencent.mm.plugin.recordvideo.plugin.a.a((ViewGroup)this, (d)this);
    this.wvz = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a((ViewGroup)this, (d)this);
    paramContext = findViewById(2131299295);
    k.g(paramContext, "findViewById(R.id.editor_mix)");
    this.sgF = new f(paramContext, (d)this);
    paramContext = findViewById(2131299285);
    k.g(paramContext, "findViewById(R.id.editor_close)");
    this.sgG = new e((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299621);
    k.g(paramContext, "findViewById(R.id.ext_text_area)");
    this.sgI = new com.tencent.mm.plugin.recordvideo.plugin.p((TextView)paramContext, (d)this);
    paramContext = findViewById(2131303907);
    k.g(paramContext, "findViewById(R.id.recorder_black_mask)");
    this.sgJ = new q((ImageView)paramContext, (d)this);
    this.wvx = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (d)this, this.sgK.wsh);
    this.wvy = new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)this, (d)this);
    this.wvA = new i((ViewGroup)this, (d)this);
    getPluginList().add(this.sgB);
    getPluginList().add(this.wvw);
    getPluginList().add(this.sgz);
    getPluginList().add(this.sgC);
    getPluginList().add(this.sgD);
    getPluginList().add(this.wvz);
    getPluginList().add(this.sgF);
    getPluginList().add(this.sgH);
    getPluginList().add(this.sgG);
    getPluginList().add(this.sgI);
    getPluginList().add(this.sgJ);
    getPluginList().add(this.wvx);
    getPluginList().add(this.wvy);
    getPluginList().add(this.wvA);
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.wra;
    i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    paramContext = com.tencent.mm.plugin.recordvideo.model.a.wra;
    int j = com.tencent.mm.plugin.recordvideo.model.a.dvp();
    float f1 = i / j;
    float f2 = i / 2.18F;
    float f3 = (j - f2) / 2.0F;
    float f4 = j * 1.78F;
    float f5 = (i - f4) / 2.0F;
    if (f1 <= 1.78F)
    {
      this.sgK.bp(f3);
      this.wvw.V(f2, f3);
      return;
    }
    if (f1 >= 2.18F)
    {
      this.sgK.bq(f3);
      this.wvw.W(f4, f5);
      return;
    }
    this.sgK.bp(f3);
    this.sgK.bq(f3);
    this.wvw.V(f2, f3);
    this.wvw.W(f4, f5);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    super.a(paramb);
    this.sgm = paramb;
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject4 = null;
    k.h(parama, "navigator");
    k.h(paramRecordConfigProvider, "configProvider");
    this.rRh = parama;
    this.rRi = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.wDE;
    com.tencent.mm.plugin.recordvideo.e.b.e(paramRecordConfigProvider);
    parama = this.wvw;
    k.h(paramRecordConfigProvider, "configProvider");
    parama.wsp.a(paramRecordConfigProvider);
    this.sgD.setVisibility(0);
    this.wvz.setVisibility(0);
    f localf = this.sgF;
    parama = paramRecordConfigProvider.wqu;
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
      parama = Integer.valueOf(parama.fKz);
      localObject1 = paramRecordConfigProvider.wqu;
      if (localObject1 == null) {
        break label588;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fKA);
      localObject2 = paramRecordConfigProvider.wqu;
      if (localObject2 == null) {
        break label594;
      }
      localObject2 = ((UICustomParam)localObject2).text;
      localObject3 = paramRecordConfigProvider.wqu;
      if (localObject3 == null) {
        break label600;
      }
      localObject3 = Integer.valueOf(((UICustomParam)localObject3).fKB);
      localf.a(parama, (Integer)localObject1, (String)localObject2, (Integer)localObject3);
      localObject2 = this.sgD;
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label606;
      }
      parama = Integer.valueOf(parama.fKz);
      localObject1 = paramRecordConfigProvider.wqu;
      if (localObject1 == null) {
        break label611;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fKA);
      com.tencent.mm.plugin.recordvideo.plugin.a.a.a((com.tencent.mm.plugin.recordvideo.plugin.a.a)localObject2, parama, (Integer)localObject1);
      localObject1 = this.sgI;
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label617;
      }
      parama = parama.fKC;
      ((com.tencent.mm.plugin.recordvideo.plugin.p)localObject1).setText(parama);
      localObject2 = this.sgC;
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label622;
      }
      parama = Integer.valueOf(parama.fKz);
      label267:
      localObject1 = paramRecordConfigProvider.wqu;
      if (localObject1 == null) {
        break label627;
      }
      localObject1 = Integer.valueOf(((UICustomParam)localObject1).fKA);
      label288:
      ((com.tencent.mm.plugin.recordvideo.plugin.c)localObject2).a(parama, (Integer)localObject1);
      localObject2 = this.wvz;
      parama = paramRecordConfigProvider.wqu;
      if (parama == null) {
        break label633;
      }
      parama = Integer.valueOf(parama.fKz);
      label319:
      localObject3 = paramRecordConfigProvider.wqu;
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((UICustomParam)localObject3).fKA);
      }
      localObject2 = ((com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a)localObject2).wuw.getFinishButton();
      if (localObject2 != null)
      {
        if ((parama != null) && (parama.intValue() != 0)) {
          ((Button)localObject2).setBackgroundResource(parama.intValue());
        }
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0) && ((localObject2 instanceof TextView))) {
          ((Button)localObject2).setTextColor(android.support.v4.content.b.n(((Button)localObject2).getContext(), ((Integer)localObject1).intValue()));
        }
      }
      this.wvA.setScene(paramRecordConfigProvider.scene);
      parama = this.wvx;
      localObject1 = paramRecordConfigProvider.wqu.fKy;
      k.g(localObject1, "configProvider.uiParam.pluginHiddenMap");
      if (!((Map)localObject1).containsKey("plugin_tip")) {
        break label638;
      }
      i = 8;
      label467:
      parama.wsk = i;
      parama = ((Iterable)getPluginList()).iterator();
      label485:
      if (!parama.hasNext()) {
        return;
      }
      localObject1 = (t)parama.next();
      localObject2 = paramRecordConfigProvider.wqu;
      if (localObject2 == null) {
        break label643;
      }
      localObject2 = ((UICustomParam)localObject2).fKy;
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
    if (paramc != d.c.wwI) {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditorVideoPluginLayout", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    Object localObject1;
    int i;
    int j;
    int k;
    label568:
    label605:
    label619:
    Object localObject2;
    boolean bool;
    int m;
    int n;
    switch (a.cfA[paramc.ordinal()])
    {
    default: 
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.EditorVideoPluginLayout", "unknown status ".concat(String.valueOf(paramc)));
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
                  this.sgz.setVisibility(4);
                  return;
                  this.sgJ.dwa();
                  return;
                  paramc = this.sgD;
                  localObject1 = this.sgm;
                  if (localObject1 == null) {
                    k.fOy();
                  }
                  com.tencent.mm.plugin.recordvideo.plugin.a.a.a(paramc, (com.tencent.mm.media.widget.camerarecordview.b.b)localObject1, this.rRi);
                  this.wvw.setVisibility(0);
                  this.sgz.setVisibility(0);
                  if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_VIDEO_NEED_CROP")))
                  {
                    this.sgD.dwk();
                    return;
                    this.sgz.setVisibility(0);
                    paramc = this.wvw;
                    paramBundle = paramc.wsn;
                    if (paramBundle != null) {
                      paramBundle.setVisibility(0);
                    }
                    paramc = paramc.wso;
                    if (paramc != null)
                    {
                      paramc.setVisibility(0);
                      return;
                      localObject1 = this.wvw;
                      if (paramBundle != null) {}
                      for (paramc = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO"); paramc != null; paramc = null)
                      {
                        ((com.tencent.mm.plugin.recordvideo.plugin.h)localObject1).wsp.C(paramc);
                        return;
                      }
                    }
                  }
                }
              } while (paramBundle == null);
              localObject1 = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
              i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
              j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
              paramc = this.wvw;
              paramBundle = localObject1.toString();
              k.h(paramBundle, "text");
              if (paramc.wsn != null)
              {
                localObject1 = paramc.wsn;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject1).setVisibility(0);
                }
                localObject1 = paramc.wsn;
                if (localObject1 != null) {
                  ((com.tencent.mm.plugin.recordvideo.ui.editor.item.g)localObject1).setText((CharSequence)paramBundle, i, j);
                }
                paramc.wsn = null;
              }
              for (;;)
              {
                paramc = y.KTp;
                return;
                paramc.wsp.k((CharSequence)paramBundle, i, j);
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
              this.wvw.wsp.dwS();
              j = this.wvw.wsp.getLocationItemHeight();
              if (j != 0) {
                break label605;
              }
              i = 0;
              k = ao.fromDPToPix(getContext(), 44);
              this.wvx.Mi(i + j + k);
            }
            for (;;)
            {
              paramc = y.KTp;
              return;
              i = 0;
              break;
              i = ao.fromDPToPix(getContext(), 24);
              break label568;
              this.wvw.ar(paramc.toString(), j, k);
            }
          } while (paramBundle == null);
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          this.sgC.g(paramc, i, j);
          paramc = y.KTp;
          return;
        } while (paramBundle == null);
        paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
        i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
        j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
        paramBundle = this.wvx;
        localObject1 = paramBundle.wsh;
        localObject2 = EditorInputView.wBM;
        ((EditorInputView)localObject1).mode = EditorInputView.dwO();
        paramBundle.wsh.setShow(true);
        paramBundle.wsh.i(paramc, i, j);
        paramc = y.KTp;
        return;
      } while (paramBundle == null);
      bool = paramBundle.getBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN");
      paramc = this.wvv;
      if (paramc == null) {
        k.aVY("previewPlugin");
      }
      paramc.uOi.setMute(bool);
      paramc = y.KTp;
      return;
    case 15: 
      this.wvz.pr(true);
      return;
    case 16: 
      this.sgz.setVisibility(4);
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", false);
        paramc = this.wvv;
        if (paramc == null) {
          k.aVY("previewPlugin");
        }
        paramc.wtk = true;
        paramBundle = paramc.uOi.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        m = ((ViewGroup)paramBundle).getWidth();
        paramBundle = paramc.uOi.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        n = ((ViewGroup)paramBundle).getHeight();
        j = com.tencent.mm.cc.a.fromDPToPix(paramc.context, 20) + com.tencent.mm.cc.a.fromDPToPix(paramc.context, 95) + com.tencent.mm.cc.a.fromDPToPix(paramc.context, 12);
        if (!ap.jF(paramc.context)) {
          break label2345;
        }
        j += ap.ej(paramc.context);
      }
      break;
    }
    label2056:
    label2082:
    label2345:
    for (;;)
    {
      i = 0;
      if (bool)
      {
        i = com.tencent.mm.cc.a.fromDPToPix(paramc.context, 56) + 0;
        if (aj.aG(paramc.context))
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is true，videoViewTopMargin: " + i + ", cutout height is " + aj.aF(paramc.context));
          i += aj.aF(paramc.context);
        }
      }
      for (;;)
      {
        paramBundle = paramc.uOi.getParent();
        if (paramBundle != null) {
          break;
        }
        throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.EditVideoPlayPlugin", "hasCutOut is false");
      }
      if (((ViewGroup)paramBundle).getBottom() + j < com.tencent.mm.plugin.mmsight.d.fH(paramc.context).y) {}
      for (k = (int)((m - com.tencent.mm.cc.a.fromDPToPix(paramc.context, 32) * 2) / (m / n));; k = n - j - i)
      {
        int i1 = (int)(m / n * k);
        float f1 = i1 / m;
        float f2 = k / n;
        float f3 = -(Math.abs(j - i) / 2.0F);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditVideoPlayPlugin", "scaleX: " + f1 + ", scaleY: " + f2 + ", translationY: " + f3);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditVideoPlayPlugin", "isShowWeseeBtn: " + bool + ", videoViewWidth: " + m + ", videoViewHeight: " + n + ", videoViewBottomMargin:" + j + ", videoViewTopMargin:" + i + ", videoViewScaleHeight: " + k + ", videoViewScaleWidth: " + i1);
        paramBundle = paramc.uOi.getParent();
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)paramBundle).animate().scaleX(f1).scaleY(f2).translationY(f3).setDuration(300L).setListener((Animator.AnimatorListener)new s.b(paramc));
        paramc = y.KTp;
        this.wvw.wsp.setEnableTouch(false);
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramc = this.wvv;
        if (paramc == null) {
          k.aVY("previewPlugin");
        }
        paramc.cSh = i;
        paramc.hbI = j;
        paramc.uOi.d(paramc.cSh, true);
        paramc = y.KTp;
        return;
        paramc = this.wvv;
        if (paramc == null) {
          k.aVY("previewPlugin");
        }
        paramc.onPause();
        return;
        paramc = this.wvv;
        if (paramc == null) {
          k.aVY("previewPlugin");
        }
        paramc.onResume();
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.wvv;
        if (paramc == null) {
          k.aVY("previewPlugin");
        }
        paramc.uOi.d(i, true);
        paramc = y.KTp;
        return;
        if (paramBundle == null) {
          break;
        }
        i = paramBundle.getInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT");
        paramc = this.wvz;
        if (paramc.wuw.getVisibility() == 0)
        {
          paramc = paramc.wuw;
          paramc.uUk.setCurrentCursorPosition(i / paramc.uUk.getDurationMs());
        }
        paramc = y.KTp;
        return;
        paramc = this.sgm;
        if (paramc == null) {
          break;
        }
        paramBundle = this.rRi;
        if (paramBundle != null) {
          i = paramBundle.wqC;
        }
        while (paramc.hbI - paramc.cSh > i + 250)
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
        this.sgz.setVisibility(0);
        paramc = this.wvv;
        if (paramc == null) {
          k.aVY("previewPlugin");
        }
        paramc.pm(false);
        this.wvw.dvP();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        paramc = y.KTp;
        return;
        this.sgz.setVisibility(0);
        this.sgD.dwk();
        paramc = this.wvv;
        if (paramc == null) {
          k.aVY("previewPlugin");
        }
        paramc.pm(true);
        this.wvw.dvP();
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
        return;
        alO();
        return;
        if (paramBundle == null) {
          break;
        }
        paramBundle = paramBundle.getByteArray("PARAM_EDIT_POI_INFO");
        paramc = this.wvw;
        paramBundle = new cna().parseFrom(paramBundle);
        if (paramBundle == null) {
          throw new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecordLocationInfo");
        }
        paramBundle = (cna)paramBundle;
        k.h(paramBundle, "storyLocation");
        if ((!bs.isNullOrNil(paramBundle.gPy)) || (!bs.isNullOrNil(paramBundle.iJV)))
        {
          i = 1;
          if (i == 0) {
            break label2056;
          }
          if (!paramc.wsp.dwV()) {
            break label2045;
          }
          paramc = paramc.wsp;
          k.h(paramBundle, "sl");
          if (paramc.wDc != null)
          {
            paramc.E((d.g.a.a)EditorItemContainer.e.wDp);
            paramc.a(paramBundle);
          }
          label1978:
          j = this.wvw.wsp.getLocationItemHeight();
          if (j != 0) {
            break label2082;
          }
        }
        for (i = 0;; i = ao.fromDPToPix(getContext(), 24))
        {
          k = ao.fromDPToPix(getContext(), 44);
          if (!this.wvw.dvM()) {
            this.wvx.Mi(i + j + k);
          }
          paramc = y.KTp;
          return;
          i = 0;
          break;
          label2045:
          paramc.wsp.a(paramBundle);
          break label1978;
          if (!paramc.wsp.dwV()) {
            break label1978;
          }
          paramc.wsp.E((d.g.a.a)h.a.wsr);
          break label1978;
        }
        this.wvy.dvL();
        return;
        if (paramBundle == null) {
          break;
        }
        bool = paramBundle.getBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN");
        paramBundle = (LyricsInfo)paramBundle.getParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST");
        paramc = new ArrayList();
        if (paramBundle != null)
        {
          paramBundle = ((Iterable)paramBundle.wrS).iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject2 = (byte[])paramBundle.next();
              localObject1 = new brn();
              com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)localObject1;
              try
              {
                locala.parseFrom((byte[])localObject2);
                paramc.add(localObject1);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ac.l("safeParser", "", new Object[] { localException });
                }
              }
            }
          }
          paramBundle = y.KTp;
        }
        paramBundle = this.wvw;
        paramc = (List)paramc;
        k.h(paramc, "lyricsInfo");
        if (bool) {
          if (paramBundle.wsp.dwT()) {
            paramBundle.wsp.eT(paramc);
          }
        }
        for (;;)
        {
          paramc = y.KTp;
          return;
          paramBundle.wsp.eU(paramc);
          continue;
          paramBundle.wsp.dwU();
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBundle.getInt("PARAM_DELETE_VIEW_TYPE_INT") == com.tencent.mm.plugin.recordvideo.ui.editor.item.b.wCN.ordinal()) {
          this.sgD.dwj();
        }
        paramc = y.KTp;
        return;
      }
    }
  }
  
  protected final void aqN(final String paramString)
  {
    k.h(paramString, "tip");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.EditorVideoPluginLayout", "showDialog");
    Context localContext = getContext();
    if (localContext == null) {
      throw new v("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)localContext).runOnUiThread((Runnable)new c(this, paramString));
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a getAddEmojiPlugin()
  {
    return this.sgB;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a.a getAddMusicPlugin()
  {
    return this.sgD;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.b getAddPoiPlugin()
  {
    return this.wvy;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.c getAddTextPlugin()
  {
    return this.sgC;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.d getAddTipPlugin()
  {
    return this.wvx;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.p getAddonTextPlugin()
  {
    return this.sgI;
  }
  
  protected final e getBackToRecordPlugin()
  {
    return this.sgG;
  }
  
  protected final q getBgPlugin()
  {
    return this.sgJ;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.sgm;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.rRi;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a getCropVideoPlugin()
  {
    return this.wvz;
  }
  
  protected final f getEditFinishPlugin()
  {
    return this.sgF;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.g getInputPlugin()
  {
    return this.sgK;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.h getItemContainerPlugin()
  {
    return this.wvw;
  }
  
  public int getLayoutId()
  {
    return 2131495831;
  }
  
  protected final i getMoreMenuPlugin()
  {
    return this.wvA;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.activity.a getNavigator()
  {
    return this.rRh;
  }
  
  public abstract View getPlayerView();
  
  protected final s getPreviewPlugin()
  {
    s locals = this.wvv;
    if (locals == null) {
      k.aVY("previewPlugin");
    }
    return locals;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.ac getReMuxPlugin()
  {
    return this.sgH;
  }
  
  protected final r getVideoControlContainerPlugin()
  {
    return this.sgz;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.sgm = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.rRi = paramRecordConfigProvider;
  }
  
  protected final void setNavigator(com.tencent.mm.plugin.recordvideo.activity.a parama)
  {
    this.rRh = parama;
  }
  
  protected final void setPreviewPlugin(s params)
  {
    k.h(params, "<set-?>");
    this.wvv = params;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(75762);
      com.tencent.mm.ui.base.p localp = BaseEditVideoPluginLayout.a(this.wvC);
      if (localp != null) {
        localp.dismiss();
      }
      BaseEditVideoPluginLayout.a(this.wvC, null);
      AppMethodBeat.o(75762);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(BaseEditVideoPluginLayout paramBaseEditVideoPluginLayout, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(75763);
      BaseEditVideoPluginLayout.a(this.wvC, com.tencent.mm.ui.base.h.b(this.wvC.getContext(), paramString, false, null));
      AppMethodBeat.o(75763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */