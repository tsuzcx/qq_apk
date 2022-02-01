package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.a.a;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.r;
import com.tencent.mm.api.z;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.k.c;
import com.tencent.mm.plugin.recordvideo.plugin.k.d;
import com.tencent.mm.plugin.recordvideo.plugin.k.e;
import com.tencent.mm.plugin.recordvideo.plugin.k.f;
import com.tencent.mm.plugin.recordvideo.plugin.l.a;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.plugin.recordvideo.plugin.o;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getEditAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "getEditCropPhotoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "getEditPencilPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "getEditPhotoWrapper", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "editShadowPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "getPhotoControlUI", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "changeUIColor", "", "getLayoutId", "", "initLogic", "loadCurrentPage", "info", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditPhotoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final a HQX;
  private com.tencent.mm.plugin.recordvideo.activity.a ALU;
  private RecordConfigProvider ALV;
  private com.tencent.mm.media.widget.camerarecordview.b.b HNh;
  private final com.tencent.mm.plugin.recordvideo.plugin.g HQG;
  private final com.tencent.mm.plugin.recordvideo.plugin.f HQH;
  private final com.tencent.mm.plugin.recordvideo.plugin.h HQM;
  private final n HQQ;
  private final com.tencent.mm.plugin.recordvideo.plugin.filter.a HQR;
  private final com.tencent.mm.plugin.recordvideo.plugin.m HQS;
  private final k HQT;
  private final com.tencent.mm.plugin.recordvideo.plugin.l HQU;
  private final com.tencent.mm.plugin.recordvideo.plugin.d HQV;
  private final o HQW;
  private final com.tencent.mm.plugin.recordvideo.plugin.b HQy;
  
  static
  {
    AppMethodBeat.i(75770);
    HQX = new a((byte)0);
    AppMethodBeat.o(75770);
  }
  
  public EditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75769);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(b.e.change_text_root);
    p.j(paramContext, "findViewById(R.id.change_text_root)");
    this.HQM = new com.tencent.mm.plugin.recordvideo.plugin.h((EditorInputView)paramContext, (d)this);
    paramContext = findViewById(b.e.editor_close);
    p.j(paramContext, "findViewById(R.id.editor_close)");
    this.HQH = new com.tencent.mm.plugin.recordvideo.plugin.f((ImageView)paramContext, (d)this);
    this.HQQ = new n((ViewGroup)this, (d)this);
    this.HQR = new com.tencent.mm.plugin.recordvideo.plugin.filter.a((ViewGroup)this, (d)this);
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(b.e.editor_add_emoji);
    p.j(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.HQy = new com.tencent.mm.plugin.recordvideo.plugin.b(paramContext, (ImageView)paramAttributeSet, (d)this);
    this.HQV = new com.tencent.mm.plugin.recordvideo.plugin.d((ViewGroup)this, (d)this, this.HQM.HMM);
    paramContext = findViewById(b.e.editor_photo_crop);
    p.j(paramContext, "findViewById(R.id.editor_photo_crop)");
    this.HQS = new com.tencent.mm.plugin.recordvideo.plugin.m((ImageView)paramContext, (d)this);
    paramContext = findViewById(b.e.editor_mix);
    p.j(paramContext, "findViewById(R.id.editor_mix)");
    this.HQG = new com.tencent.mm.plugin.recordvideo.plugin.g(paramContext, (d)this);
    paramContext = findViewById(b.e.photo_preview_plugin);
    p.j(paramContext, "findViewById(R.id.photo_preview_plugin)");
    this.HQT = new k((FrameLayout)paramContext, (d)this);
    paramContext = findViewById(b.e.control_container);
    p.j(paramContext, "findViewById(R.id.control_container)");
    this.HQU = new com.tencent.mm.plugin.recordvideo.plugin.l((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(b.e.shadow_bg);
    p.j(paramContext, "findViewById(R.id.shadow_bg)");
    this.HQW = new o(paramContext, (d)this);
    this.HQy.setVisibility(0);
    this.HQV.setVisibility(0);
    this.HQQ.setVisibility(0);
    getPluginList().add(this.HQU);
    getPluginList().add(this.HQQ);
    getPluginList().add(this.HQR);
    getPluginList().add(this.HQS);
    getPluginList().add(this.HQT);
    getPluginList().add(this.HQH);
    getPluginList().add(this.HQy);
    getPluginList().add(this.HQG);
    getPluginList().add(this.HQV);
    AppMethodBeat.o(75769);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(75766);
    super.a(paramb);
    if (paramb != null)
    {
      this.HNh = paramb;
      Object localObject1 = this.HQT;
      Object localObject2 = this.ALV;
      if (localObject2 == null) {
        p.iCn();
      }
      p.k(localObject2, "configProvider");
      p.k(paramb, "captureInfo");
      ((k)localObject1).ALV = ((RecordConfigProvider)localObject2);
      ((k)localObject1).HNh = paramb;
      localObject2 = this.HQT;
      String str = paramb.lfq;
      p.k(str, "path");
      ((k)localObject2).FvY.setVisibility(0);
      localObject1 = ((k)localObject2).HNh;
      Object localObject3;
      boolean bool;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lft == true))
      {
        localObject1 = ((k)localObject2).fwR();
        ((k)localObject2).Fhh = ((ab)localObject1);
        localObject1 = ((k)localObject2).Fhh;
        if (localObject1 != null)
        {
          localObject3 = new ab.a.a();
          Object localObject4 = ((k)localObject2).ALV;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 291)) {
            break label360;
          }
          localObject4 = ((k)localObject2).ALV;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 293)) {
            break label360;
          }
          bool = true;
          label201:
          localObject3 = ((ab.a.a)localObject3).df(bool).aac().o(new Rect(((k)localObject2).FvY.getLeft(), ((k)localObject2).FvY.getTop(), ((k)localObject2).FvY.getRight(), ((k)localObject2).FvY.getBottom())).a(ab.c.faG);
          localObject4 = ((k)localObject2).HNh;
          if ((localObject4 == null) || (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).lfl != true)) {
            break label365;
          }
          bool = true;
          label283:
          ((ab)localObject1).a(((ab.a.a)localObject3).dg(bool).gx(str).aae());
        }
        localObject1 = ((k)localObject2).Fhh;
        if (localObject1 == null) {
          break label370;
        }
      }
      label360:
      label365:
      label370:
      for (localObject1 = ((ab)localObject1).bA(((k)localObject2).context);; localObject1 = null)
      {
        if (localObject1 != null) {
          break label376;
        }
        paramb = new t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
        localObject1 = ((k)localObject2).eYo();
        break;
        bool = false;
        break label201;
        bool = false;
        break label283;
      }
      label376:
      ((k)localObject2).HNi = ((com.tencent.mm.view.m)localObject1);
      localObject1 = ((k)localObject2).ALV;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).mab;
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject3 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject3);
            localObject3 = ((k)localObject2).HNi;
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.view.m)localObject3).getBaseBoardView();
              if (localObject3 != null) {
                ((com.tencent.mm.view.b.a)localObject3).setForceMatrix((Matrix)localObject1);
              }
            }
          }
        }
      }
      localObject1 = ((k)localObject2).HNi;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.footer.c)((com.tencent.mm.view.m)localObject1).getBaseFooterView();
        if (localObject1 != null) {
          ((com.tencent.mm.view.footer.c)localObject1).setHideFooter(true);
        }
      }
      localObject1 = ((k)localObject2).HNi;
      if (localObject1 == null)
      {
        paramb = new t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((k)localObject2).FvS = ((com.tencent.mm.view.m)localObject1).getPresenter();
      localObject1 = ((k)localObject2).FvS;
      if (localObject1 == null)
      {
        paramb = new t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((com.tencent.mm.ca.a)localObject1).RAb = ((a.c)new k.c((k)localObject2));
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((k)localObject2).FvY.addView((View)((k)localObject2).HNi, (ViewGroup.LayoutParams)localObject1);
      localObject1 = ((k)localObject2).HNi;
      if (localObject1 != null) {
        ((com.tencent.mm.view.m)localObject1).setSelectedFeatureListener((z)new k.d((k)localObject2));
      }
      localObject1 = ((k)localObject2).FvS;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.ca.b)localObject1).c(com.tencent.mm.api.h.fan);
        if (localObject1 != null) {
          ((com.tencent.mm.e.d)localObject1).a((b.a)new k.e((k)localObject2));
        }
      }
      localObject1 = ((k)localObject2).FvS;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.h)((com.tencent.mm.ca.b)localObject1).c(com.tencent.mm.api.h.faq);
        if (localObject1 != null) {
          ((com.tencent.mm.e.h)localObject1).a((b.a)new k.f((k)localObject2));
        }
      }
      localObject1 = BitmapUtil.getImageOptions(str);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth));
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MEDIA_TYPE_INT", Integer.valueOf(1));
      if (!paramb.lfl)
      {
        paramb = this.ALV;
        if (paramb == null) {
          break label908;
        }
      }
    }
    label908:
    for (int i = paramb.scene;; i = 0)
    {
      if (i > 0)
      {
        paramb = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      paramb = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWq();
      AppMethodBeat.o(75766);
      return;
    }
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    int j = 0;
    AppMethodBeat.i(75765);
    p.k(parama, "navigator");
    p.k(paramRecordConfigProvider, "configProvider");
    Log.i("MicroMsg.EditPhotoPluginLayout", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.ALU = parama;
    this.ALV = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    com.tencent.mm.plugin.recordvideo.e.d.f(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      Object localObject1 = (u)parama.next();
      Object localObject2 = paramRecordConfigProvider.HKT;
      boolean bool;
      if (localObject2 != null)
      {
        localObject2 = ((UICustomParam)localObject2).jwa;
        if (localObject2 != null)
        {
          localObject2 = (Boolean)((Map)localObject2).get(((u)localObject1).name());
          if (localObject2 != null)
          {
            bool = ((Boolean)localObject2).booleanValue();
            label144:
            if (bool) {
              break label219;
            }
            i = 1;
            label151:
            if (i == 0) {
              break label224;
            }
          }
        }
      }
      label219:
      label224:
      for (i = 0;; i = 8)
      {
        ((u)localObject1).setVisibility(i);
        if ((!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.plugin.filter.a)) || (i != 0)) {
          break;
        }
        localObject1 = this.HQQ.HNB;
        ((PhotoDoodlePlugin)localObject1).b(null, null);
        localObject1 = ((PhotoDoodlePlugin)localObject1).HPH;
        if (localObject1 == null) {
          break;
        }
        ((GridView)localObject1).deferNotifyDataSetChanged();
        break;
        bool = false;
        break label144;
        i = 0;
        break label151;
      }
    }
    parama = this.ALV;
    int i = j;
    if (parama != null)
    {
      parama = parama.mab;
      i = j;
      if (parama != null) {
        i = parama.getInt("button_custom_color", 0);
      }
    }
    parama = getContext();
    p.j(parama, "context");
    if (i == parama.getResources().getColor(b.b.room_live_logo_color)) {
      this.HQU.kEt.setBackgroundResource(b.d.btn_solid_green_small_finder_live);
    }
    AppMethodBeat.o(75765);
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    com.tencent.mm.plugin.recordvideo.plugin.filter.a locala = null;
    Object localObject = null;
    AppMethodBeat.i(75767);
    p.k(paramc, "status");
    Log.i("MicroMsg.EditPhotoPluginLayout", "status :" + paramc + " , param :" + paramBundle);
    int i;
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(75767);
      return;
    case 1: 
      paramc = com.tencent.mm.plugin.recordvideo.d.g.HUM;
      com.tencent.mm.plugin.recordvideo.d.g.aJ(2, 3L);
      onBackPress();
      AppMethodBeat.o(75767);
      return;
    case 2: 
    case 3: 
    case 4: 
      this.HQU.setVisibility(4);
      AppMethodBeat.o(75767);
      return;
    case 5: 
      this.HQU.setVisibility(0);
      AppMethodBeat.o(75767);
      return;
    case 6: 
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.HQT;
          p.j(paramBundle, "this");
          paramBundle = (r)paramBundle;
          p.k(paramBundle, "emojiInfo");
          localObject = paramc.FvS;
          if (localObject != null) {
            ((com.tencent.mm.ca.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.fao);
          }
          paramc = paramc.FvS;
          if (paramc != null)
          {
            paramc.c(paramBundle);
            AppMethodBeat.o(75767);
            return;
          }
          AppMethodBeat.o(75767);
          return;
        }
      }
      AppMethodBeat.o(75767);
      return;
    case 7: 
      this.HQU.fwU();
      this.HQT.reset();
      AppMethodBeat.o(75767);
      return;
    case 8: 
      AppMethodBeat.o(75767);
      return;
    case 9: 
      paramc = this.HQT;
      paramc.FvW = com.tencent.mm.api.h.faq;
      paramc.wzx = 0;
      paramBundle = paramc.FvS;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.h.faq);
      }
      paramc = paramc.FvS;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.faq, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.aVY("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.acq(8);
      AppMethodBeat.o(75767);
      return;
    case 10: 
      paramc = this.HQT;
      paramc.FvW = com.tencent.mm.api.h.faq;
      paramc.wzx = 1;
      paramBundle = paramc.FvS;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.h.faq);
      }
      paramc = paramc.FvS;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.faq, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.aVY("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.acq(9);
      AppMethodBeat.o(75767);
      return;
    case 11: 
      this.HQR.reset();
      if (paramBundle != null)
      {
        paramc = this.HQT;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.FvW = com.tencent.mm.api.h.fan;
        paramc.wzx = i;
        paramBundle = paramc.FvS;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.h.fan);
        }
        paramc = paramc.FvS;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.fan, i, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 12: 
      this.HQQ.reset();
      locala = this.HQR;
      com.tencent.mm.ca.b localb = this.HQT.FvS;
      paramc = (d.c)localObject;
      if (localb != null) {
        paramc = localb.hoy();
      }
      if (paramc != null) {
        locala.HPX.setPreImage(paramc);
      }
      if (paramBundle != null)
      {
        paramc = this.HQT;
        i = paramBundle.getInt("EDIT_FILTER_INDEX_INT");
        float f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT");
        paramc.FvW = com.tencent.mm.api.h.fat;
        paramc.wzx = i;
        paramBundle = paramc.FvS;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(paramc.FvW);
        }
        paramBundle = paramc.FvS;
        if (paramBundle != null)
        {
          paramBundle.getSelectedFeatureListener().a(paramc.FvW, paramc.wzx, Float.valueOf(f));
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 13: 
      paramc = this.HQT;
      paramBundle = paramc.FvS;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.arE().arF(), -1, null);
      }
      paramBundle = paramc.FvS;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.FvW);
      }
      paramBundle = paramc.FvS;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.FvW, paramc.wzx, null);
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 14: 
      this.HQH.setVisibility(0);
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
        this.HQU.setVisibility(0);
        break;
        this.HQH.setVisibility(4);
        this.HQU.setVisibility(4);
        paramc = this.HQT.FvS;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.fap);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.HQH.setVisibility(4);
        this.HQU.setVisibility(4);
        paramc = this.HQT.FvS;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.fao);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        int j;
        if (paramBundle != null)
        {
          localObject = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          paramBundle = this.HQT;
          paramc = locala;
          if (localObject != null) {
            paramc = localObject.toString();
          }
          localObject = paramBundle.FvS;
          if (localObject != null) {
            ((com.tencent.mm.ca.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.fao);
          }
          paramBundle = paramBundle.FvS;
          if (paramBundle != null)
          {
            paramBundle.aQ(paramc, i, j);
            AppMethodBeat.o(75767);
            return;
          }
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        if (paramBundle != null)
        {
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          com.tencent.mm.plugin.recordvideo.plugin.d.a(this.HQV, paramc, i, j);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.HQH.setVisibility(0);
        this.HQU.fwU();
        this.HQQ.eYp();
        this.HQT.fwT();
        AppMethodBeat.o(75767);
        return;
        this.HQT.eof();
        AppMethodBeat.o(75767);
        return;
        this.HQQ.HNB.setVisibility(4);
        this.HQH.setVisibility(4);
        paramc = this.HQU;
        paramc.HNv = l.a.HNw;
        paramBundle = paramc.HNr;
        p.j(paramBundle, "normalFuncLayout");
        paramBundle.setVisibility(4);
        paramc = paramc.HNs;
        p.j(paramc, "cropFuncLayout");
        paramc.setVisibility(0);
        paramc = this.HQT;
        if (paramc.FvW != com.tencent.mm.api.h.far)
        {
          paramc.FvW = com.tencent.mm.api.h.far;
          paramc = paramc.FvS;
          if (paramc != null)
          {
            paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.far);
            AppMethodBeat.o(75767);
            return;
          }
        }
        AppMethodBeat.o(75767);
        return;
        this.HQH.setVisibility(0);
        this.HQT.fwS();
        this.HQQ.eYp();
        AppMethodBeat.o(75767);
        return;
        paramc = this.HQT;
        paramc.FvW = com.tencent.mm.api.h.far;
        paramc = paramc.FvS;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.far, 0, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        paramc = this.HQT;
        paramc.FvW = com.tencent.mm.api.h.far;
        paramc = paramc.FvS;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.far, 3, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      } while (this.HQU.AQv.getVisibility() == 4);
      if (this.HQU.AQv.getVisibility() == 0) {
        this.HQU.setVisibility(4);
      }
      AppMethodBeat.o(75767);
      return;
    }
    this.HQU.setVisibility(4);
    AppMethodBeat.o(75767);
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(227667);
    p.k(paramu, "plugin");
    p.k(paramu, "plugin");
    AppMethodBeat.o(227667);
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.b getAddEmojiPlugin()
  {
    return this.HQy;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.f getBackToRecordPlugin()
  {
    return this.HQH;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.HNh;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.ALV;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.d getEditAddTextPlugin()
  {
    return this.HQV;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.m getEditCropPhotoPlugin()
  {
    return this.HQS;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.g getEditFinishPlugin()
  {
    return this.HQG;
  }
  
  protected final n getEditPencilPlugin()
  {
    return this.HQQ;
  }
  
  protected final k getEditPhotoWrapper()
  {
    return this.HQT;
  }
  
  public int getLayoutId()
  {
    return b.f.photo_edit_plugin_layout;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.l getPhotoControlUI()
  {
    return this.HQU;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75768);
    if (!super.onBackPress())
    {
      Object localObject = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWt();
      localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject = this.ALU;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    AppMethodBeat.o(75768);
    return true;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.HNh = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.ALV = paramRecordConfigProvider;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */