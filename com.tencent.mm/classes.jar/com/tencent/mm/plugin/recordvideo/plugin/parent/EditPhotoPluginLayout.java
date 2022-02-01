package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.app.Activity;
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
import com.tencent.mm.api.p;
import com.tencent.mm.api.s;
import com.tencent.mm.api.u;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.a.a;
import com.tencent.mm.api.y.c;
import com.tencent.mm.bu.a.c;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.j.b;
import com.tencent.mm.plugin.recordvideo.plugin.j.c;
import com.tencent.mm.plugin.recordvideo.plugin.j.d;
import com.tencent.mm.plugin.recordvideo.plugin.j.e;
import com.tencent.mm.plugin.recordvideo.plugin.j.f;
import com.tencent.mm.plugin.recordvideo.plugin.k.a;
import com.tencent.mm.plugin.recordvideo.plugin.m;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "getEditPhotoWrapper", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "editShadowPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "initLogic", "", "loadCurrentPage", "info", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditPhotoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final a vno;
  private RecordConfigProvider vcC;
  private com.tencent.mm.media.widget.camerarecordview.b.b vjS;
  private com.tencent.mm.plugin.recordvideo.activity.a vmM;
  private final com.tencent.mm.plugin.recordvideo.plugin.a vmO;
  private final com.tencent.mm.plugin.recordvideo.plugin.f vmW;
  private final com.tencent.mm.plugin.recordvideo.plugin.e vmX;
  private final com.tencent.mm.plugin.recordvideo.plugin.g vnc;
  private final m vnh;
  private final com.tencent.mm.plugin.recordvideo.plugin.filter.a vni;
  private final com.tencent.mm.plugin.recordvideo.plugin.l vnj;
  private final j vnk;
  private final com.tencent.mm.plugin.recordvideo.plugin.k vnl;
  private final com.tencent.mm.plugin.recordvideo.plugin.c vnm;
  private final n vnn;
  
  static
  {
    AppMethodBeat.i(75770);
    vno = new a((byte)0);
    AppMethodBeat.o(75770);
  }
  
  public EditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75769);
    View.inflate(paramContext, 2131495086, (ViewGroup)this);
    paramContext = findViewById(2131297952);
    d.g.b.k.g(paramContext, "findViewById(R.id.change_text_root)");
    this.vnc = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramContext);
    paramContext = findViewById(2131299285);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_close)");
    this.vmX = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramContext, (d)this);
    this.vnh = new m((ViewGroup)this, (d)this);
    this.vni = new com.tencent.mm.plugin.recordvideo.plugin.filter.a((ViewGroup)this, (d)this);
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131299273);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.vmO = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    this.vnm = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.vnc.vjw);
    paramContext = findViewById(2131299296);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_photo_crop)");
    this.vnj = new com.tencent.mm.plugin.recordvideo.plugin.l((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299295);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_mix)");
    this.vmW = new com.tencent.mm.plugin.recordvideo.plugin.f(paramContext, (d)this);
    paramContext = findViewById(2131303249);
    d.g.b.k.g(paramContext, "findViewById(R.id.photo_preview_plugin)");
    this.vnk = new j((FrameLayout)paramContext, (d)this);
    paramContext = findViewById(2131298784);
    d.g.b.k.g(paramContext, "findViewById(R.id.control_container)");
    this.vnl = new com.tencent.mm.plugin.recordvideo.plugin.k((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131304672);
    d.g.b.k.g(paramContext, "findViewById(R.id.shadow_bg)");
    this.vnn = new n(paramContext, (d)this);
    this.vmO.setVisibility(0);
    this.vnm.setVisibility(0);
    this.vnh.setVisibility(0);
    getPluginList().add(this.vnl);
    getPluginList().add(this.vnh);
    getPluginList().add(this.vni);
    getPluginList().add(this.vnj);
    getPluginList().add(this.vnk);
    getPluginList().add(this.vmX);
    getPluginList().add(this.vmO);
    getPluginList().add(this.vmW);
    getPluginList().add(this.vnm);
    AppMethodBeat.o(75769);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(75766);
    super.a(paramb);
    if (paramb != null)
    {
      this.vjS = paramb;
      Object localObject1 = this.vnk;
      Object localObject2 = this.vcC;
      if (localObject2 == null) {
        d.g.b.k.fvU();
      }
      d.g.b.k.h(localObject2, "configProvider");
      d.g.b.k.h(paramb, "captureInfo");
      ((j)localObject1).vcC = ((RecordConfigProvider)localObject2);
      ((j)localObject1).vjS = paramb;
      localObject2 = this.vnk;
      String str = paramb.gBr;
      d.g.b.k.h(str, "path");
      ((j)localObject2).vjX.setVisibility(0);
      localObject1 = ((j)localObject2).vjS;
      Object localObject3;
      boolean bool;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBu == true))
      {
        localObject1 = ((j)localObject2).dim();
        ((j)localObject2).tJO = ((y)localObject1);
        localObject1 = ((j)localObject2).tJO;
        if (localObject1 != null)
        {
          localObject3 = new y.a.a();
          Object localObject4 = ((j)localObject2).vcC;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 291)) {
            break label360;
          }
          localObject4 = ((j)localObject2).vcC;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 293)) {
            break label360;
          }
          bool = true;
          label201:
          localObject3 = ((y.a.a)localObject3).bX(bool).Kd().i(new Rect(((j)localObject2).vjX.getLeft(), ((j)localObject2).vjX.getTop(), ((j)localObject2).vjX.getRight(), ((j)localObject2).vjX.getBottom())).a(y.c.cJJ);
          localObject4 = ((j)localObject2).vjS;
          if ((localObject4 == null) || (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).gBl != true)) {
            break label365;
          }
          bool = true;
          label283:
          ((y)localObject1).a(((y.a.a)localObject3).bY(bool).ek(str).Ke());
        }
        localObject1 = ((j)localObject2).tJO;
        if (localObject1 == null) {
          break label370;
        }
      }
      label360:
      label365:
      label370:
      for (localObject1 = ((y)localObject1).bf(((j)localObject2).context);; localObject1 = null)
      {
        if (localObject1 != null) {
          break label376;
        }
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
        localObject1 = ((j)localObject2).dil();
        break;
        bool = false;
        break label201;
        bool = false;
        break label283;
      }
      label376:
      ((j)localObject2).vjT = ((com.tencent.mm.view.e)localObject1);
      localObject1 = ((j)localObject2).vcC;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).hsl;
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject3 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject3);
            localObject3 = ((j)localObject2).vjT;
            if (localObject3 != null)
            {
              localObject3 = ((com.tencent.mm.view.e)localObject3).getBaseBoardView();
              if (localObject3 != null) {
                ((com.tencent.mm.view.b.a)localObject3).setForceMatrix((Matrix)localObject1);
              }
            }
          }
        }
      }
      localObject1 = ((j)localObject2).vjT;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.footer.b)((com.tencent.mm.view.e)localObject1).getBaseFooterView();
        if (localObject1 != null) {
          ((com.tencent.mm.view.footer.b)localObject1).setHideFooter(true);
        }
      }
      localObject1 = ((j)localObject2).vjT;
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((j)localObject2).vjU = ((com.tencent.mm.view.e)localObject1).getPresenter();
      localObject1 = ((j)localObject2).vjU;
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((com.tencent.mm.bu.a)localObject1).Cpk = ((a.c)new j.c((j)localObject2));
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((j)localObject2).vjX.addView((View)((j)localObject2).vjT, (ViewGroup.LayoutParams)localObject1);
      localObject1 = ((j)localObject2).vjT;
      if (localObject1 != null) {
        ((com.tencent.mm.view.e)localObject1).setSelectedFeatureListener((w)new j.d((j)localObject2));
      }
      localObject1 = ((j)localObject2).vjU;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.bu.b)localObject1).c(com.tencent.mm.api.g.cJs);
        if (localObject1 != null) {
          ((com.tencent.mm.e.d)localObject1).a((b.a)new j.e((j)localObject2));
        }
      }
      localObject1 = ((j)localObject2).vjU;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.g)((com.tencent.mm.bu.b)localObject1).c(com.tencent.mm.api.g.cJv);
        if (localObject1 != null) {
          ((com.tencent.mm.e.g)localObject1).a((b.a)new j.f((j)localObject2));
        }
      }
      localObject1 = com.tencent.mm.sdk.platformtools.f.aFf(str);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth));
        localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_MEDIA_TYPE_INT", Integer.valueOf(1));
      if (!paramb.gBl)
      {
        paramb = this.vcC;
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
        paramb = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      paramb = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.ald();
      AppMethodBeat.o(75766);
      return;
    }
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75765);
    d.g.b.k.h(parama, "navigator");
    d.g.b.k.h(paramRecordConfigProvider, "configProvider");
    ad.i("MicroMsg.EditPhotoPluginLayout", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.vmM = parama;
    this.vcC = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.vtE;
    com.tencent.mm.plugin.recordvideo.e.b.c(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      Object localObject1 = (t)parama.next();
      Object localObject2 = paramRecordConfigProvider.vhI;
      boolean bool;
      if (localObject2 != null)
      {
        localObject2 = ((UICustomParam)localObject2).fGR;
        if (localObject2 != null)
        {
          localObject2 = (Boolean)((Map)localObject2).get(((t)localObject1).name());
          if (localObject2 != null)
          {
            bool = ((Boolean)localObject2).booleanValue();
            label141:
            if (bool) {
              break label207;
            }
            i = 1;
            label148:
            if (i == 0) {
              break label212;
            }
          }
        }
      }
      label207:
      label212:
      for (int i = 0;; i = 8)
      {
        ((t)localObject1).setVisibility(i);
        if ((!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.plugin.filter.a)) || (i != 0)) {
          break;
        }
        localObject1 = this.vnh.vkq;
        ((PhotoDoodlePlugin)localObject1).b(null, null);
        ((PhotoDoodlePlugin)localObject1).vmg.deferNotifyDataSetChanged();
        break;
        bool = false;
        break label141;
        i = 0;
        break label148;
      }
    }
    AppMethodBeat.o(75765);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    int i = 0;
    Object localObject = null;
    AppMethodBeat.i(75767);
    d.g.b.k.h(paramc, "status");
    ad.i("MicroMsg.EditPhotoPluginLayout", "status :" + paramc + " , param :" + paramBundle);
    switch (b.ciE[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(75767);
      return;
    case 1: 
      dia();
      AppMethodBeat.o(75767);
      return;
    case 2: 
    case 3: 
    case 4: 
      this.vnl.setVisibility(4);
      AppMethodBeat.o(75767);
      return;
    case 5: 
      this.vnl.setVisibility(0);
      AppMethodBeat.o(75767);
      return;
    case 6: 
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.vnk;
          paramBundle = (p)paramBundle;
          d.g.b.k.h(paramBundle, "emojiInfo");
          localObject = paramc.vjU;
          if (localObject != null) {
            ((com.tencent.mm.bu.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.g.cJt);
          }
          paramc = paramc.vjU;
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
      this.vnl.dio();
      this.vnk.reset();
      AppMethodBeat.o(75767);
      return;
    case 8: 
      AppMethodBeat.o(75767);
      return;
    case 9: 
      paramc = this.vnk;
      paramc.vjW = com.tencent.mm.api.g.cJv;
      paramc.goS = 0;
      paramBundle = paramc.vjU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJv);
      }
      paramc = paramc.vjU;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJv, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.alO("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.Ko(8);
      AppMethodBeat.o(75767);
      return;
    case 10: 
      paramc = this.vnk;
      paramc.vjW = com.tencent.mm.api.g.cJv;
      paramc.goS = 1;
      paramBundle = paramc.vjU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJv);
      }
      paramc = paramc.vjU;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJv, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.alO("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.Ko(9);
      AppMethodBeat.o(75767);
      return;
    case 11: 
      this.vni.reset();
      if (paramBundle != null)
      {
        paramc = this.vnk;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.vjW = com.tencent.mm.api.g.cJs;
        paramc.goS = i;
        paramBundle = paramc.vjU;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJs);
        }
        paramc = paramc.vjU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJs, i, null);
          AppMethodBeat.o(75767);
          return;
        }
      }
      AppMethodBeat.o(75767);
      return;
    case 12: 
      this.vnh.reset();
      com.tencent.mm.plugin.recordvideo.plugin.filter.a locala = this.vni;
      com.tencent.mm.bu.b localb = this.vnk.vjU;
      paramc = (d.c)localObject;
      if (localb != null) {
        paramc = localb.eBw();
      }
      if (paramc != null) {
        locala.vmk.setPreImage(paramc);
      }
      if (paramBundle != null)
      {
        paramc = this.vnk;
        i = paramBundle.getInt("EDIT_FILTER_INDEX_INT");
        float f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT");
        paramc.vjW = com.tencent.mm.api.g.cJy;
        paramc.goS = i;
        paramBundle = paramc.vjU;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(paramc.vjW);
        }
        paramBundle = paramc.vjU;
        if (paramBundle != null)
        {
          paramBundle.getSelectedFeatureListener().a(paramc.vjW, paramc.goS, Float.valueOf(f));
          AppMethodBeat.o(75767);
          return;
        }
      }
      AppMethodBeat.o(75767);
      return;
    case 13: 
      paramc = this.vnk;
      paramBundle = paramc.vjU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.Uw().Ux(), -1, null);
      }
      paramBundle = paramc.vjU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.vjW);
      }
      paramBundle = paramc.vjU;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.vjW, paramc.goS, null);
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 14: 
      this.vmX.setVisibility(0);
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
      label1304:
      label1344:
      label1384:
      label1641:
      label1651:
      do
      {
        this.vnl.setVisibility(0);
        break;
        this.vmX.setVisibility(4);
        this.vnl.setVisibility(4);
        paramc = this.vnk.vjU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJu);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.vmX.setVisibility(4);
        this.vnl.setVisibility(4);
        paramc = this.vnk.vjU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJt);
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
          paramc = this.vnk;
          paramBundle = (Editable)localObject;
          if (paramBundle == null) {
            d.g.b.k.fvU();
          }
          d.g.b.k.h(paramBundle, "text");
          paramBundle.clearSpans();
          localObject = paramc.vjU;
          if (localObject != null) {
            ((com.tencent.mm.bu.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.g.cJt);
          }
          paramc = paramc.vjU;
          if (paramc != null)
          {
            paramc.a(paramBundle, i, j);
            AppMethodBeat.o(75767);
            return;
          }
        }
        AppMethodBeat.o(75767);
        return;
        if (paramBundle != null)
        {
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          this.vnm.g(paramc, i, j);
        }
        AppMethodBeat.o(75767);
        return;
        this.vmX.setVisibility(0);
        this.vnl.dio();
        this.vnh.dip();
        this.vnk.din();
        AppMethodBeat.o(75767);
        return;
        paramBundle = this.vnk;
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        paramc = paramBundle.tJO;
        if (paramc != null)
        {
          paramc = paramc.IM();
          if (paramc == null) {
            d.g.b.k.fvU();
          }
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramc.JU()));
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          paramc = paramBundle.tJO;
          if (paramc == null) {
            break label1611;
          }
          paramc = paramc.IM();
          if (paramc == null) {
            d.g.b.k.fvU();
          }
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramc.JT()));
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          paramc = paramBundle.tJO;
          if (paramc == null) {
            break label1616;
          }
          paramc = paramc.IM();
          if (paramc == null) {
            d.g.b.k.fvU();
          }
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramc.JW()));
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          paramc = paramBundle.tJO;
          if (paramc == null) {
            break label1621;
          }
          paramc = paramc.IM();
          if (paramc == null) {
            d.g.b.k.fvU();
          }
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramc.JZ()));
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          paramc = paramBundle.tJO;
          if (paramc == null) {
            break label1626;
          }
          paramc = paramc.IM();
          if (paramc == null) {
            d.g.b.k.fvU();
          }
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramc.JV()));
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          paramc = paramBundle.tJO;
          if (paramc == null) {
            break label1631;
          }
          paramc = paramc.IM();
          if (paramc == null) {
            d.g.b.k.fvU();
          }
          if (paramc.JY()) {
            i = 1;
          }
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ROTATE_INT", Integer.valueOf(i));
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
          paramc = paramBundle.tJO;
          if (paramc == null) {
            break label1636;
          }
        }
        boolean bool;
        for (paramc = paramc.IM();; paramc = null)
        {
          if (paramc == null) {
            d.g.b.k.fvU();
          }
          bool = paramc.Ka();
          paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
          if (bool)
          {
            paramc = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.alc();
          }
          paramc = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.alj();
          if (paramBundle.isFinishing) {
            break label1651;
          }
          paramc = paramBundle.context;
          if (paramc != null) {
            break label1641;
          }
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(75767);
          throw paramc;
          paramc = null;
          break;
          paramc = null;
          break label1304;
          paramc = null;
          break label1344;
          paramc = null;
          break label1384;
          paramc = null;
          break label1424;
          paramc = null;
          break label1464;
        }
        if (((Activity)paramc).isFinishing())
        {
          AppMethodBeat.o(75767);
          return;
        }
        paramBundle.isFinishing = true;
        long l = bt.GC();
        ad.i("MicroMsg.EditPhotoPluginLayout", "dofinish time: " + l + ' ' + bool);
        paramc = paramBundle.tJO;
        if (paramc != null)
        {
          paramc.a((s)new j.b(paramBundle, l, bool));
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.vnh.vkq.setVisibility(4);
        this.vmX.setVisibility(4);
        paramc = this.vnl;
        paramc.vki = k.a.vkk;
        paramBundle = paramc.vke;
        d.g.b.k.g(paramBundle, "normalFuncLayout");
        paramBundle.setVisibility(4);
        paramc = paramc.vkf;
        d.g.b.k.g(paramc, "cropFuncLayout");
        paramc.setVisibility(0);
        paramc = this.vnk;
        if (paramc.vjW != com.tencent.mm.api.g.cJw)
        {
          paramc.vjW = com.tencent.mm.api.g.cJw;
          paramc = paramc.vjU;
          if (paramc != null)
          {
            paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJw);
            AppMethodBeat.o(75767);
            return;
          }
        }
        AppMethodBeat.o(75767);
        return;
        this.vmX.setVisibility(0);
        paramc = this.vnk;
        paramc.vjW = com.tencent.mm.api.g.cJr;
        paramc = paramc.vjU;
        if (paramc != null) {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJw, 2, null);
        }
        this.vnh.dip();
        AppMethodBeat.o(75767);
        return;
        paramc = this.vnk;
        paramc.vjW = com.tencent.mm.api.g.cJw;
        paramc = paramc.vjU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJw, 0, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        paramc = this.vnk;
        paramc.vjW = com.tencent.mm.api.g.cJw;
        paramc = paramc.vjU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJw, 3, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      } while (this.vnl.vkj.getVisibility() == 4);
      label1424:
      label1464:
      label1611:
      label1616:
      label1621:
      label1626:
      label1631:
      label1636:
      if (this.vnl.vkj.getVisibility() == 0) {
        this.vnl.setVisibility(4);
      }
      AppMethodBeat.o(75767);
      return;
    }
    this.vnl.setVisibility(4);
    AppMethodBeat.o(75767);
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(75768);
    if (!super.dia())
    {
      Object localObject = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alg();
      localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject = this.vmM;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    AppMethodBeat.o(75768);
    return true;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.vjS;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.vcC;
  }
  
  protected final j getEditPhotoWrapper()
  {
    return this.vnk;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.vjS = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.vcC = paramRecordConfigProvider;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */