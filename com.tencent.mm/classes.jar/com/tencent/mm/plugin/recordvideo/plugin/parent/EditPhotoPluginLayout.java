package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mm.bt.a.c;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.j.c;
import com.tencent.mm.plugin.recordvideo.plugin.j.d;
import com.tencent.mm.plugin.recordvideo.plugin.j.e;
import com.tencent.mm.plugin.recordvideo.plugin.j.f;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.k.a;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getEditAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "getEditCropPhotoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "getEditPencilPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "getEditPhotoWrapper", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "editShadowPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "getLayoutId", "", "initLogic", "", "loadCurrentPage", "info", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditPhotoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final EditPhotoPluginLayout.a BUm;
  private com.tencent.mm.media.widget.camerarecordview.b.b BQt;
  private final com.tencent.mm.plugin.recordvideo.plugin.a BTN;
  private final f BTV;
  private final com.tencent.mm.plugin.recordvideo.plugin.e BTW;
  private final com.tencent.mm.plugin.recordvideo.plugin.g BUb;
  private final com.tencent.mm.plugin.recordvideo.plugin.m BUf;
  private final com.tencent.mm.plugin.recordvideo.plugin.filter.a BUg;
  private final com.tencent.mm.plugin.recordvideo.plugin.l BUh;
  private final j BUi;
  private final k BUj;
  private final com.tencent.mm.plugin.recordvideo.plugin.c BUk;
  private final n BUl;
  private com.tencent.mm.plugin.recordvideo.activity.a wdl;
  private RecordConfigProvider wdm;
  
  static
  {
    AppMethodBeat.i(75770);
    BUm = new EditPhotoPluginLayout.a((byte)0);
    AppMethodBeat.o(75770);
  }
  
  public EditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75769);
    View.inflate(paramContext, getLayoutId(), (ViewGroup)this);
    paramContext = findViewById(2131298286);
    p.g(paramContext, "findViewById(R.id.change_text_root)");
    this.BUb = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramContext);
    paramContext = findViewById(2131299875);
    p.g(paramContext, "findViewById(R.id.editor_close)");
    this.BTW = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramContext, (d)this);
    this.BUf = new com.tencent.mm.plugin.recordvideo.plugin.m((ViewGroup)this, (d)this);
    this.BUg = new com.tencent.mm.plugin.recordvideo.plugin.filter.a((ViewGroup)this, (d)this);
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131299859);
    p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.BTN = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    this.BUk = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.BUb.BPY);
    paramContext = findViewById(2131299895);
    p.g(paramContext, "findViewById(R.id.editor_photo_crop)");
    this.BUh = new com.tencent.mm.plugin.recordvideo.plugin.l((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299891);
    p.g(paramContext, "findViewById(R.id.editor_mix)");
    this.BTV = new f(paramContext, (d)this);
    paramContext = findViewById(2131305919);
    p.g(paramContext, "findViewById(R.id.photo_preview_plugin)");
    this.BUi = new j((FrameLayout)paramContext, (d)this);
    paramContext = findViewById(2131299234);
    p.g(paramContext, "findViewById(R.id.control_container)");
    this.BUj = new k((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131307727);
    p.g(paramContext, "findViewById(R.id.shadow_bg)");
    this.BUl = new n(paramContext, (d)this);
    this.BTN.setVisibility(0);
    this.BUk.setVisibility(0);
    this.BUf.setVisibility(0);
    getPluginList().add(this.BUj);
    getPluginList().add(this.BUf);
    getPluginList().add(this.BUg);
    getPluginList().add(this.BUh);
    getPluginList().add(this.BUi);
    getPluginList().add(this.BTW);
    getPluginList().add(this.BTN);
    getPluginList().add(this.BTV);
    getPluginList().add(this.BUk);
    AppMethodBeat.o(75769);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(75766);
    super.a(paramb);
    if (paramb != null)
    {
      this.BQt = paramb;
      Object localObject1 = this.BUi;
      Object localObject2 = this.wdm;
      if (localObject2 == null) {
        p.hyc();
      }
      p.h(localObject2, "configProvider");
      p.h(paramb, "captureInfo");
      ((j)localObject1).wdm = ((RecordConfigProvider)localObject2);
      ((j)localObject1).BQt = paramb;
      localObject2 = this.BUi;
      String str = paramb.iql;
      p.h(str, "path");
      ((j)localObject2).zQv.setVisibility(0);
      localObject1 = ((j)localObject2).BQt;
      Object localObject3;
      boolean bool;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqo == true))
      {
        localObject1 = ((j)localObject2).eKz();
        ((j)localObject2).zCl = ((ab)localObject1);
        localObject1 = ((j)localObject2).zCl;
        if (localObject1 != null)
        {
          localObject3 = new ab.a.a();
          Object localObject4 = ((j)localObject2).wdm;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 291)) {
            break label360;
          }
          localObject4 = ((j)localObject2).wdm;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 293)) {
            break label360;
          }
          bool = true;
          label201:
          localObject3 = ((ab.a.a)localObject3).cJ(bool).VH().j(new Rect(((j)localObject2).zQv.getLeft(), ((j)localObject2).zQv.getTop(), ((j)localObject2).zQv.getRight(), ((j)localObject2).zQv.getBottom())).a(ab.c.diZ);
          localObject4 = ((j)localObject2).BQt;
          if ((localObject4 == null) || (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).iqf != true)) {
            break label365;
          }
          bool = true;
          label283:
          ((ab)localObject1).a(((ab.a.a)localObject3).cK(bool).fN(str).VJ());
        }
        localObject1 = ((j)localObject2).zCl;
        if (localObject1 == null) {
          break label370;
        }
      }
      label360:
      label365:
      label370:
      for (localObject1 = ((ab)localObject1).bB(((j)localObject2).context);; localObject1 = null)
      {
        if (localObject1 != null) {
          break label376;
        }
        paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
        localObject1 = ((j)localObject2).eow();
        break;
        bool = false;
        break label201;
        bool = false;
        break label283;
      }
      label376:
      ((j)localObject2).BQu = ((com.tencent.mm.view.m)localObject1);
      localObject1 = ((j)localObject2).wdm;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).jkf;
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject3 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject3);
            localObject3 = ((j)localObject2).BQu;
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
      localObject1 = ((j)localObject2).BQu;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.footer.c)((com.tencent.mm.view.m)localObject1).getBaseFooterView();
        if (localObject1 != null) {
          ((com.tencent.mm.view.footer.c)localObject1).setHideFooter(true);
        }
      }
      localObject1 = ((j)localObject2).BQu;
      if (localObject1 == null)
      {
        paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((j)localObject2).zQp = ((com.tencent.mm.view.m)localObject1).getPresenter();
      localObject1 = ((j)localObject2).zQp;
      if (localObject1 == null)
      {
        paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((com.tencent.mm.bt.a)localObject1).Kyn = ((a.c)new j.c((j)localObject2));
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((j)localObject2).zQv.addView((View)((j)localObject2).BQu, (ViewGroup.LayoutParams)localObject1);
      localObject1 = ((j)localObject2).BQu;
      if (localObject1 != null) {
        ((com.tencent.mm.view.m)localObject1).setSelectedFeatureListener((z)new j.d((j)localObject2));
      }
      localObject1 = ((j)localObject2).zQp;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.bt.b)localObject1).c(com.tencent.mm.api.h.diH);
        if (localObject1 != null) {
          ((com.tencent.mm.e.d)localObject1).a((b.a)new j.e((j)localObject2));
        }
      }
      localObject1 = ((j)localObject2).zQp;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.h)((com.tencent.mm.bt.b)localObject1).c(com.tencent.mm.api.h.diK);
        if (localObject1 != null) {
          ((com.tencent.mm.e.h)localObject1).a((b.a)new j.f((j)localObject2));
        }
      }
      localObject1 = BitmapUtil.getImageOptions(str);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth));
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_TYPE_INT", Integer.valueOf(1));
      if (!paramb.iqf)
      {
        paramb = this.wdm;
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
        paramb = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      paramb = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNM();
      AppMethodBeat.o(75766);
      return;
    }
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75765);
    p.h(parama, "navigator");
    p.h(paramRecordConfigProvider, "configProvider");
    Log.i("MicroMsg.EditPhotoPluginLayout", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.wdl = parama;
    this.wdm = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    com.tencent.mm.plugin.recordvideo.e.c.d(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      Object localObject1 = (com.tencent.mm.plugin.recordvideo.plugin.t)parama.next();
      Object localObject2 = paramRecordConfigProvider.BOn;
      boolean bool;
      if (localObject2 != null)
      {
        localObject2 = ((UICustomParam)localObject2).gLL;
        if (localObject2 != null)
        {
          localObject2 = (Boolean)((Map)localObject2).get(((com.tencent.mm.plugin.recordvideo.plugin.t)localObject1).name());
          if (localObject2 != null)
          {
            bool = ((Boolean)localObject2).booleanValue();
            label141:
            if (bool) {
              break label216;
            }
            i = 1;
            label148:
            if (i == 0) {
              break label221;
            }
          }
        }
      }
      label216:
      label221:
      for (int i = 0;; i = 8)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.t)localObject1).setVisibility(i);
        if ((!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.plugin.filter.a)) || (i != 0)) {
          break;
        }
        localObject1 = this.BUf.BQL;
        ((PhotoDoodlePlugin)localObject1).b(null, null);
        localObject1 = ((PhotoDoodlePlugin)localObject1).BST;
        if (localObject1 == null) {
          break;
        }
        ((GridView)localObject1).deferNotifyDataSetChanged();
        break;
        bool = false;
        break label141;
        i = 0;
        break label148;
      }
    }
    AppMethodBeat.o(75765);
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(75767);
    p.h(paramc, "status");
    Log.i("MicroMsg.EditPhotoPluginLayout", "status :" + paramc + " , param :" + paramBundle);
    int i;
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(75767);
      return;
    case 1: 
      paramc = com.tencent.mm.plugin.recordvideo.d.g.BXY;
      com.tencent.mm.plugin.recordvideo.d.g.ax(2, 3L);
      onBackPress();
      AppMethodBeat.o(75767);
      return;
    case 2: 
    case 3: 
    case 4: 
      this.BUj.setVisibility(4);
      AppMethodBeat.o(75767);
      return;
    case 5: 
      this.BUj.setVisibility(0);
      AppMethodBeat.o(75767);
      return;
    case 6: 
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.BUi;
          p.g(paramBundle, "this");
          paramBundle = (r)paramBundle;
          p.h(paramBundle, "emojiInfo");
          localObject = paramc.zQp;
          if (localObject != null) {
            ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.diI);
          }
          paramc = paramc.zQp;
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
      this.BUj.eKC();
      this.BUi.reset();
      AppMethodBeat.o(75767);
      return;
    case 8: 
      AppMethodBeat.o(75767);
      return;
    case 9: 
      paramc = this.BUi;
      paramc.zQt = com.tencent.mm.api.h.diK;
      paramc.sTB = 0;
      paramBundle = paramc.zQp;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.h.diK);
      }
      paramc = paramc.zQp;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.diK, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.VH(8);
      AppMethodBeat.o(75767);
      return;
    case 10: 
      paramc = this.BUi;
      paramc.zQt = com.tencent.mm.api.h.diK;
      paramc.sTB = 1;
      paramBundle = paramc.zQp;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.h.diK);
      }
      paramc = paramc.zQp;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.diK, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.VH(9);
      AppMethodBeat.o(75767);
      return;
    case 11: 
      this.BUg.reset();
      if (paramBundle != null)
      {
        paramc = this.BUi;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.zQt = com.tencent.mm.api.h.diH;
        paramc.sTB = i;
        paramBundle = paramc.zQp;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.h.diH);
        }
        paramc = paramc.zQp;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.diH, i, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 12: 
      this.BUf.reset();
      com.tencent.mm.plugin.recordvideo.plugin.filter.a locala = this.BUg;
      com.tencent.mm.bt.b localb = this.BUi.zQp;
      paramc = (d.c)localObject;
      if (localb != null) {
        paramc = localb.gtm();
      }
      if (paramc != null) {
        locala.BTj.setPreImage(paramc);
      }
      if (paramBundle != null)
      {
        paramc = this.BUi;
        i = paramBundle.getInt("EDIT_FILTER_INDEX_INT");
        float f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT");
        paramc.zQt = com.tencent.mm.api.h.diN;
        paramc.sTB = i;
        paramBundle = paramc.zQp;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(paramc.zQt);
        }
        paramBundle = paramc.zQp;
        if (paramBundle != null)
        {
          paramBundle.getSelectedFeatureListener().a(paramc.zQt, paramc.sTB, Float.valueOf(f));
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 13: 
      paramc = this.BUi;
      paramBundle = paramc.zQp;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.alF().alG(), -1, null);
      }
      paramBundle = paramc.zQp;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.zQt);
      }
      paramBundle = paramc.zQp;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.zQt, paramc.sTB, null);
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 14: 
      this.BTW.setVisibility(0);
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
        this.BUj.setVisibility(0);
        break;
        this.BTW.setVisibility(4);
        this.BUj.setVisibility(4);
        paramc = this.BUi.zQp;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.diJ);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.BTW.setVisibility(4);
        this.BUj.setVisibility(4);
        paramc = this.BUi.zQp;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.diI);
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
          paramc = this.BUi;
          paramBundle = (Editable)localObject;
          if (paramBundle == null) {
            p.hyc();
          }
          p.h(paramBundle, "text");
          paramBundle.clearSpans();
          localObject = paramc.zQp;
          if (localObject != null) {
            ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.diI);
          }
          paramc = paramc.zQp;
          if (paramc != null)
          {
            paramc.a(paramBundle, i, j);
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
          com.tencent.mm.plugin.recordvideo.plugin.c.a(this.BUk, paramc, i, j);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.BTW.setVisibility(0);
        this.BUj.eKC();
        this.BUf.eox();
        this.BUi.eKB();
        AppMethodBeat.o(75767);
        return;
        this.BUi.dJF();
        AppMethodBeat.o(75767);
        return;
        this.BUf.BQL.setVisibility(4);
        this.BTW.setVisibility(4);
        paramc = this.BUj;
        paramc.BQF = k.a.BQG;
        paramBundle = paramc.BQB;
        p.g(paramBundle, "normalFuncLayout");
        paramBundle.setVisibility(4);
        paramc = paramc.BQC;
        p.g(paramc, "cropFuncLayout");
        paramc.setVisibility(0);
        paramc = this.BUi;
        if (paramc.zQt != com.tencent.mm.api.h.diL)
        {
          paramc.zQt = com.tencent.mm.api.h.diL;
          paramc = paramc.zQp;
          if (paramc != null)
          {
            paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.diL);
            AppMethodBeat.o(75767);
            return;
          }
        }
        AppMethodBeat.o(75767);
        return;
        this.BTW.setVisibility(0);
        this.BUi.eKA();
        this.BUf.eox();
        AppMethodBeat.o(75767);
        return;
        paramc = this.BUi;
        paramc.zQt = com.tencent.mm.api.h.diL;
        paramc = paramc.zQp;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.diL, 0, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        paramc = this.BUi;
        paramc.zQt = com.tencent.mm.api.h.diL;
        paramc = paramc.zQp;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.h.diL, 3, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      } while (this.BUj.wgR.getVisibility() == 4);
      if (this.BUj.wgR.getVisibility() == 0) {
        this.BUj.setVisibility(4);
      }
      AppMethodBeat.o(75767);
      return;
    }
    this.BUj.setVisibility(4);
    AppMethodBeat.o(75767);
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.a getAddEmojiPlugin()
  {
    return this.BTN;
  }
  
  public final com.tencent.mm.plugin.recordvideo.plugin.e getBackToRecordPlugin()
  {
    return this.BTW;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.BQt;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.wdm;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.c getEditAddTextPlugin()
  {
    return this.BUk;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.l getEditCropPhotoPlugin()
  {
    return this.BUh;
  }
  
  public final f getEditFinishPlugin()
  {
    return this.BTV;
  }
  
  protected final com.tencent.mm.plugin.recordvideo.plugin.m getEditPencilPlugin()
  {
    return this.BUf;
  }
  
  protected final j getEditPhotoWrapper()
  {
    return this.BUi;
  }
  
  public int getLayoutId()
  {
    return 2131495924;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75768);
    if (!super.onBackPress())
    {
      Object localObject = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNP();
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject = this.wdl;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    AppMethodBeat.o(75768);
    return true;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.BQt = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.wdm = paramRecordConfigProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */