package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.t;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.l;
import com.tencent.mm.plugin.recordvideo.plugin.m;
import com.tencent.mm.plugin.recordvideo.plugin.m.a;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.plugin.recordvideo.plugin.o;
import com.tencent.mm.plugin.recordvideo.plugin.p;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getEditAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "getEditCropPhotoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "getEditPencilPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "getEditPhotoWrapper", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "editShadowPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "getPhotoControlUI", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "changeUIColor", "", "getLayoutId", "", "initLogic", "loadCurrentPage", "info", "onBackPress", "", "onDetach", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class EditPhotoPluginLayout
  extends BasePluginLayout
  implements a
{
  public static final EditPhotoPluginLayout.a NNx;
  private com.tencent.mm.plugin.recordvideo.activity.a Fiu;
  private com.tencent.mm.media.widget.camerarecordview.b.b NKf;
  private final n NNA;
  private final l NNB;
  private final m NNC;
  private final com.tencent.mm.plugin.recordvideo.plugin.e NND;
  private final p NNE;
  private final com.tencent.mm.plugin.recordvideo.plugin.c NNb;
  private final h NNj;
  private final com.tencent.mm.plugin.recordvideo.plugin.g NNk;
  private final com.tencent.mm.plugin.recordvideo.plugin.i NNp;
  private final o NNy;
  private final com.tencent.mm.plugin.recordvideo.plugin.filter.a NNz;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(75770);
    NNx = new EditPhotoPluginLayout.a((byte)0);
    AppMethodBeat.o(75770);
  }
  
  public EditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75769);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(b.e.change_text_root);
    s.s(paramContext, "findViewById(R.id.change_text_root)");
    this.NNp = new com.tencent.mm.plugin.recordvideo.plugin.i((EditorInputView)paramContext, (a)this);
    paramContext = findViewById(b.e.editor_close);
    s.s(paramContext, "findViewById(R.id.editor_close)");
    this.NNk = new com.tencent.mm.plugin.recordvideo.plugin.g((ImageView)paramContext, (a)this);
    this.NNy = new o((ViewGroup)this, (a)this);
    this.NNz = new com.tencent.mm.plugin.recordvideo.plugin.filter.a((ViewGroup)this, (a)this);
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(b.e.editor_add_emoji);
    s.s(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.NNb = new com.tencent.mm.plugin.recordvideo.plugin.c(paramContext, (ImageView)paramAttributeSet, (a)this);
    this.NND = new com.tencent.mm.plugin.recordvideo.plugin.e((ViewGroup)this, (a)this, this.NNp.NJH);
    paramContext = findViewById(b.e.editor_photo_crop);
    s.s(paramContext, "findViewById(R.id.editor_photo_crop)");
    this.NNA = new n((ImageView)paramContext, (a)this);
    paramContext = findViewById(b.e.editor_mix);
    s.s(paramContext, "findViewById(R.id.editor_mix)");
    this.NNj = new h(paramContext, (a)this);
    paramContext = findViewById(b.e.photo_preview_plugin);
    s.s(paramContext, "findViewById(R.id.photo_preview_plugin)");
    this.NNB = new l((FrameLayout)paramContext, (a)this);
    paramContext = findViewById(b.e.control_container);
    s.s(paramContext, "findViewById(R.id.control_container)");
    this.NNC = new m((ViewGroup)paramContext, (a)this);
    paramContext = findViewById(b.e.shadow_bg);
    s.s(paramContext, "findViewById(R.id.shadow_bg)");
    this.NNE = new p(paramContext, (a)this);
    this.NNb.setVisibility(0);
    this.NND.setVisibility(0);
    this.NNy.setVisibility(0);
    getPluginList().add(this.NNC);
    getPluginList().add(this.NNy);
    getPluginList().add(this.NNz);
    getPluginList().add(this.NNA);
    getPluginList().add(this.NNB);
    getPluginList().add(this.NNk);
    getPluginList().add(this.NNb);
    getPluginList().add(this.NNj);
    getPluginList().add(this.NND);
    AppMethodBeat.o(75769);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(75766);
    super.a(paramb);
    if (paramb != null)
    {
      setCaptureInfo(paramb);
      Object localObject = getEditPhotoWrapper();
      RecordConfigProvider localRecordConfigProvider = getConfigProvider();
      s.checkNotNull(localRecordConfigProvider);
      s.u(localRecordConfigProvider, "configProvider");
      s.u(paramb, "captureInfo");
      ((l)localObject).oaV = localRecordConfigProvider;
      ((l)localObject).NKf = paramb;
      getEditPhotoWrapper().aTc(paramb.nKb);
      localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MEDIA_TYPE_INT", Integer.valueOf(1));
      if (!paramb.nJW)
      {
        paramb = getConfigProvider();
        if (paramb != null) {
          break label169;
        }
      }
    }
    label169:
    for (int i = 0;; i = paramb.scene)
    {
      if (i > 0)
      {
        paramb = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      paramb = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bqY();
      AppMethodBeat.o(75766);
      return;
    }
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    int j = 0;
    AppMethodBeat.i(75765);
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    Log.i("MicroMsg.EditPhotoPluginLayout", s.X("configProvider ", paramRecordConfigProvider));
    this.Fiu = parama;
    this.oaV = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.util.f.Obq;
    com.tencent.mm.plugin.recordvideo.util.f.k(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    label107:
    int i;
    if (parama.hasNext())
    {
      Object localObject1 = (v)parama.next();
      Object localObject2 = paramRecordConfigProvider.NHR;
      boolean bool;
      if (localObject2 == null)
      {
        bool = false;
        if (bool) {
          break label234;
        }
        i = 1;
        label114:
        if (i == 0) {
          break label239;
        }
      }
      label234:
      label239:
      for (i = 0;; i = 8)
      {
        ((v)localObject1).setVisibility(i);
        if ((!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.plugin.filter.a)) || (i != 0)) {
          break;
        }
        localObject1 = getEditPencilPlugin().NKx;
        ((PhotoDoodlePlugin)localObject1).c(null, null);
        localObject1 = ((PhotoDoodlePlugin)localObject1).NMo;
        if (localObject1 == null) {
          break;
        }
        ((GridView)localObject1).deferNotifyDataSetChanged();
        break;
        localObject2 = ((UICustomParam)localObject2).lZs;
        if (localObject2 == null)
        {
          bool = false;
          break label107;
        }
        localObject2 = (Boolean)((Map)localObject2).get(((v)localObject1).name());
        if (localObject2 == null)
        {
          bool = false;
          break label107;
        }
        bool = ((Boolean)localObject2).booleanValue();
        break label107;
        i = 0;
        break label114;
      }
    }
    parama = this.oaV;
    if (parama == null) {
      i = j;
    }
    for (;;)
    {
      if (i == getContext().getResources().getColor(b.b.room_live_logo_color)) {
        this.NNC.nhC.setBackgroundResource(b.d.btn_solid_green_small_finder_live);
      }
      AppMethodBeat.o(75765);
      return;
      parama = parama.oSS;
      i = j;
      if (parama != null) {
        i = parama.getInt("button_custom_color", 0);
      }
    }
  }
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    l locall = null;
    AppMethodBeat.i(75767);
    s.u(paramc, "status");
    Log.i("MicroMsg.EditPhotoPluginLayout", "status :" + paramc + " , param :" + paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
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
    case 27: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(75767);
              return;
              paramc = com.tencent.mm.plugin.recordvideo.f.g.NRB;
              com.tencent.mm.plugin.recordvideo.f.g.aQ(2, 3L);
              onBackPress();
              AppMethodBeat.o(75767);
              return;
              this.NNC.setVisibility(4);
              AppMethodBeat.o(75767);
              return;
              this.NNC.setVisibility(0);
              AppMethodBeat.o(75767);
              return;
            } while (paramBundle == null);
            paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
          } while (paramBundle == null);
          paramc = getEditPhotoWrapper();
          paramBundle = (t)paramBundle;
          s.u(paramBundle, "emojiInfo");
          localObject = paramc.Lsg;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
            if (localObject != null) {
              ((aa)localObject).a(com.tencent.mm.api.i.hdP);
            }
          }
          paramc = paramc.Lsg;
          if (paramc != null) {
            paramc.d(paramBundle);
          }
          AppMethodBeat.o(75767);
          return;
          this.NNC.gIC();
          this.NNB.reset();
          AppMethodBeat.o(75767);
          return;
          AppMethodBeat.o(75767);
          return;
          paramc = this.NNB;
          paramc.Lsk = com.tencent.mm.api.i.hdR;
          paramc.zVI = 0;
          paramBundle = paramc.Lsg;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.getSelectedFeatureListener();
            if (paramBundle != null) {
              paramBundle.a(com.tencent.mm.api.i.hdR);
            }
          }
          paramc = paramc.Lsg;
          if (paramc != null)
          {
            paramc = paramc.getSelectedFeatureListener();
            if (paramc != null) {
              paramc.a(com.tencent.mm.api.i.hdR, 0, null);
            }
          }
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_MOSAIC_COUNT_INT");
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.agG(8);
          AppMethodBeat.o(75767);
          return;
          paramc = this.NNB;
          paramc.Lsk = com.tencent.mm.api.i.hdR;
          paramc.zVI = 1;
          paramBundle = paramc.Lsg;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.getSelectedFeatureListener();
            if (paramBundle != null) {
              paramBundle.a(com.tencent.mm.api.i.hdR);
            }
          }
          paramc = paramc.Lsg;
          if (paramc != null)
          {
            paramc = paramc.getSelectedFeatureListener();
            if (paramc != null) {
              paramc.a(com.tencent.mm.api.i.hdR, 1, null);
            }
          }
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_BRUSH_COUNT_INT");
          paramc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.agG(9);
          AppMethodBeat.o(75767);
          return;
          this.NNz.reset();
        } while (paramBundle == null);
        paramc = getEditPhotoWrapper();
        int i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.Lsk = com.tencent.mm.api.i.hdO;
        paramc.zVI = i;
        paramBundle = paramc.Lsg;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getSelectedFeatureListener();
          if (paramBundle != null) {
            paramBundle.a(com.tencent.mm.api.i.hdO);
          }
        }
        paramc = paramc.Lsg;
        if (paramc != null)
        {
          paramc = paramc.getSelectedFeatureListener();
          if (paramc != null) {
            paramc.a(com.tencent.mm.api.i.hdO, i, null);
          }
        }
        AppMethodBeat.o(75767);
        return;
        this.NNy.reset();
        localObject = this.NNz;
        paramc = this.NNB.Lsg;
        if (paramc == null) {}
        for (paramc = locall;; paramc = paramc.iPu())
        {
          if (paramc != null) {
            ((com.tencent.mm.plugin.recordvideo.plugin.filter.a)localObject).NMD.setPreImage(paramc);
          }
          if (paramBundle == null) {
            break;
          }
          paramc = getEditPhotoWrapper();
          i = paramBundle.getInt("EDIT_FILTER_INDEX_INT");
          float f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT");
          paramc.Lsk = com.tencent.mm.api.i.hdU;
          paramc.zVI = i;
          paramBundle = paramc.Lsg;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.getSelectedFeatureListener();
            if (paramBundle != null) {
              paramBundle.a(paramc.Lsk);
            }
          }
          paramBundle = paramc.Lsg;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.getSelectedFeatureListener();
            if (paramBundle != null) {
              paramBundle.a(paramc.Lsk, paramc.zVI, Float.valueOf(f));
            }
          }
          AppMethodBeat.o(75767);
          return;
        }
        paramc = this.NNB;
        paramBundle = paramc.Lsg;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getSelectedFeatureListener();
          if (paramBundle != null) {
            paramBundle.a(com.tencent.mm.cache.c.aLA().aLB(), -1, null);
          }
        }
        paramBundle = paramc.Lsg;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getSelectedFeatureListener();
          if (paramBundle != null) {
            paramBundle.a(paramc.Lsk);
          }
        }
        paramBundle = paramc.Lsg;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getSelectedFeatureListener();
          if (paramBundle != null) {
            paramBundle.a(paramc.Lsk, paramc.zVI, null);
          }
        }
        AppMethodBeat.o(75767);
        return;
        this.NNk.setVisibility(0);
        do
        {
          this.NNC.setVisibility(0);
          break;
          this.NNk.setVisibility(4);
          this.NNC.setVisibility(4);
          paramc = this.NNB.Lsg;
          if (paramc != null)
          {
            paramc = paramc.getSelectedFeatureListener();
            if (paramc != null) {
              paramc.a(com.tencent.mm.api.i.hdQ);
            }
          }
          AppMethodBeat.o(75767);
          return;
          this.NNk.setVisibility(4);
          this.NNC.setVisibility(4);
          paramc = this.NNB.Lsg;
          if (paramc != null)
          {
            paramc = paramc.getSelectedFeatureListener();
            if (paramc != null) {
              paramc.a(com.tencent.mm.api.i.hdP);
            }
          }
          AppMethodBeat.o(75767);
          return;
          if (paramBundle == null) {
            break;
          }
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          int j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          paramBundle = paramBundle.getString("PARAM_EDIT_TEXT_FONT");
          locall = getEditPhotoWrapper();
          if (paramc == null) {}
          for (paramc = (a.c)localObject;; paramc = paramc.toString())
          {
            s.checkNotNull(paramBundle);
            s.u(paramBundle, "font");
            localObject = locall.Lsg;
            if (localObject != null)
            {
              localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
              if (localObject != null) {
                ((aa)localObject).a(com.tencent.mm.api.i.hdP);
              }
            }
            localObject = locall.Lsg;
            if (localObject != null) {
              ((com.tencent.mm.bt.b)localObject).r(paramc, i, j, paramBundle);
            }
            AppMethodBeat.o(75767);
            return;
          }
          if (paramBundle == null) {
            break;
          }
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          com.tencent.mm.plugin.recordvideo.plugin.e.a(getEditAddTextPlugin(), paramc, i, j);
          AppMethodBeat.o(75767);
          return;
          this.NNk.setVisibility(0);
          this.NNC.gIC();
          this.NNy.ghk();
          this.NNB.gIB();
          AppMethodBeat.o(75767);
          return;
          this.NNB.fti();
          AppMethodBeat.o(75767);
          return;
          this.NNy.NKx.setVisibility(4);
          this.NNk.setVisibility(4);
          paramc = this.NNC;
          paramc.NKr = m.a.NKs;
          paramc.NKn.setVisibility(4);
          paramc.NKo.setVisibility(0);
          paramc = this.NNB;
          if (paramc.Lsk != com.tencent.mm.api.i.hdS)
          {
            paramc.Lsk = com.tencent.mm.api.i.hdS;
            paramc = paramc.Lsg;
            if (paramc != null)
            {
              paramc = paramc.getSelectedFeatureListener();
              if (paramc != null) {
                paramc.a(com.tencent.mm.api.i.hdS);
              }
            }
          }
          AppMethodBeat.o(75767);
          return;
          this.NNk.setVisibility(0);
          this.NNB.gIA();
          this.NNy.ghk();
          AppMethodBeat.o(75767);
          return;
          paramc = this.NNB;
          paramc.Lsk = com.tencent.mm.api.i.hdS;
          paramc = paramc.Lsg;
          if (paramc != null)
          {
            paramc = paramc.getSelectedFeatureListener();
            if (paramc != null) {
              paramc.a(com.tencent.mm.api.i.hdS, 0, null);
            }
          }
          AppMethodBeat.o(75767);
          return;
          paramc = this.NNB;
          paramc.Lsk = com.tencent.mm.api.i.hdS;
          paramc = paramc.Lsg;
          if (paramc != null)
          {
            paramc = paramc.getSelectedFeatureListener();
            if (paramc != null) {
              paramc.a(com.tencent.mm.api.i.hdS, 3, null);
            }
          }
          AppMethodBeat.o(75767);
          return;
        } while (this.NNC.NKm.getVisibility() == 4);
      } while (this.NNC.NKm.getVisibility() != 0);
      this.NNC.setVisibility(4);
      AppMethodBeat.o(75767);
      return;
    }
    this.NNC.setVisibility(4);
    AppMethodBeat.o(75767);
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(281182);
    a.b.a(this, paramv);
    AppMethodBeat.o(281182);
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.c getAddEmojiPlugin()
  {
    return this.NNb;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.g getBackToRecordPlugin()
  {
    return this.NNk;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.NKf;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.oaV;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.e getEditAddTextPlugin()
  {
    return this.NND;
  }
  
  protected final n getEditCropPhotoPlugin()
  {
    return this.NNA;
  }
  
  public final h getEditFinishPlugin()
  {
    return this.NNj;
  }
  
  protected final o getEditPencilPlugin()
  {
    return this.NNy;
  }
  
  protected final l getEditPhotoWrapper()
  {
    return this.NNB;
  }
  
  public int getLayoutId()
  {
    return b.f.photo_edit_plugin_layout;
  }
  
  protected final m getPhotoControlUI()
  {
    return this.NNC;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75768);
    if (!super.onBackPress())
    {
      Object localObject = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brb();
      localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject = this.Fiu;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    AppMethodBeat.o(75768);
    return true;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(281178);
    super.onDetach();
    com.tencent.mm.plugin.comm.b.e.xfd.a("SnsPublishProcess", "mediaEditPageStaytime_", Long.valueOf(getBrowserTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(281178);
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.NKf = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.oaV = paramRecordConfigProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */