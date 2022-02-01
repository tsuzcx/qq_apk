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
import com.tencent.mm.bt.a.c;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "getEditPhotoWrapper", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "editShadowPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "initLogic", "", "loadCurrentPage", "info", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditPhotoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final EditPhotoPluginLayout.a wvK;
  private com.tencent.mm.plugin.recordvideo.activity.a rRh;
  private RecordConfigProvider rRi;
  private final com.tencent.mm.plugin.recordvideo.plugin.a sgB;
  private final com.tencent.mm.plugin.recordvideo.plugin.f sgF;
  private final com.tencent.mm.plugin.recordvideo.plugin.e sgG;
  private final com.tencent.mm.plugin.recordvideo.plugin.g sgK;
  private final m sgQ;
  private com.tencent.mm.media.widget.camerarecordview.b.b sgm;
  private final com.tencent.mm.plugin.recordvideo.plugin.filter.a wvE;
  private final com.tencent.mm.plugin.recordvideo.plugin.l wvF;
  private final j wvG;
  private final com.tencent.mm.plugin.recordvideo.plugin.k wvH;
  private final com.tencent.mm.plugin.recordvideo.plugin.c wvI;
  private final n wvJ;
  
  static
  {
    AppMethodBeat.i(75770);
    wvK = new EditPhotoPluginLayout.a((byte)0);
    AppMethodBeat.o(75770);
  }
  
  public EditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75769);
    View.inflate(paramContext, 2131495086, (ViewGroup)this);
    paramContext = findViewById(2131297952);
    d.g.b.k.g(paramContext, "findViewById(R.id.change_text_root)");
    this.sgK = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramContext);
    paramContext = findViewById(2131299285);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_close)");
    this.sgG = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramContext, (d)this);
    this.sgQ = new m((ViewGroup)this, (d)this);
    this.wvE = new com.tencent.mm.plugin.recordvideo.plugin.filter.a((ViewGroup)this, (d)this);
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131299273);
    d.g.b.k.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.sgB = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    this.wvI = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.sgK.wsh);
    paramContext = findViewById(2131299296);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_photo_crop)");
    this.wvF = new com.tencent.mm.plugin.recordvideo.plugin.l((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299295);
    d.g.b.k.g(paramContext, "findViewById(R.id.editor_mix)");
    this.sgF = new com.tencent.mm.plugin.recordvideo.plugin.f(paramContext, (d)this);
    paramContext = findViewById(2131303249);
    d.g.b.k.g(paramContext, "findViewById(R.id.photo_preview_plugin)");
    this.wvG = new j((FrameLayout)paramContext, (d)this);
    paramContext = findViewById(2131298784);
    d.g.b.k.g(paramContext, "findViewById(R.id.control_container)");
    this.wvH = new com.tencent.mm.plugin.recordvideo.plugin.k((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131304672);
    d.g.b.k.g(paramContext, "findViewById(R.id.shadow_bg)");
    this.wvJ = new n(paramContext, (d)this);
    this.sgB.setVisibility(0);
    this.wvI.setVisibility(0);
    this.sgQ.setVisibility(0);
    getPluginList().add(this.wvH);
    getPluginList().add(this.sgQ);
    getPluginList().add(this.wvE);
    getPluginList().add(this.wvF);
    getPluginList().add(this.wvG);
    getPluginList().add(this.sgG);
    getPluginList().add(this.sgB);
    getPluginList().add(this.sgF);
    getPluginList().add(this.wvI);
    AppMethodBeat.o(75769);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(75766);
    super.a(paramb);
    if (paramb != null)
    {
      this.sgm = paramb;
      Object localObject1 = this.wvG;
      Object localObject2 = this.rRi;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      d.g.b.k.h(localObject2, "configProvider");
      d.g.b.k.h(paramb, "captureInfo");
      ((j)localObject1).rRi = ((RecordConfigProvider)localObject2);
      ((j)localObject1).sgm = paramb;
      localObject2 = this.wvG;
      String str = paramb.hbN;
      d.g.b.k.h(str, "path");
      ((j)localObject2).sgs.setVisibility(0);
      localObject1 = ((j)localObject2).sgm;
      Object localObject3;
      boolean bool;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hbQ == true))
      {
        localObject1 = ((j)localObject2).dvW();
        ((j)localObject2).sgl = ((y)localObject1);
        localObject1 = ((j)localObject2).sgl;
        if (localObject1 != null)
        {
          localObject3 = new y.a.a();
          Object localObject4 = ((j)localObject2).rRi;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 291)) {
            break label360;
          }
          localObject4 = ((j)localObject2).rRi;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 293)) {
            break label360;
          }
          bool = true;
          label201:
          localObject3 = ((y.a.a)localObject3).bY(bool).JN().i(new Rect(((j)localObject2).sgs.getLeft(), ((j)localObject2).sgs.getTop(), ((j)localObject2).sgs.getRight(), ((j)localObject2).sgs.getBottom())).a(y.c.cGQ);
          localObject4 = ((j)localObject2).sgm;
          if ((localObject4 == null) || (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).hbH != true)) {
            break label365;
          }
          bool = true;
          label283:
          ((y)localObject1).a(((y.a.a)localObject3).bZ(bool).dZ(str).JO());
        }
        localObject1 = ((j)localObject2).sgl;
        if (localObject1 == null) {
          break label370;
        }
      }
      label360:
      label365:
      label370:
      for (localObject1 = ((y)localObject1).bg(((j)localObject2).context);; localObject1 = null)
      {
        if (localObject1 != null) {
          break label376;
        }
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
        localObject1 = ((j)localObject2).dvV();
        break;
        bool = false;
        break label201;
        bool = false;
        break label283;
      }
      label376:
      ((j)localObject2).sgn = ((com.tencent.mm.view.e)localObject1);
      localObject1 = ((j)localObject2).rRi;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).hSN;
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject3 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject3);
            localObject3 = ((j)localObject2).sgn;
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
      localObject1 = ((j)localObject2).sgn;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.footer.b)((com.tencent.mm.view.e)localObject1).getBaseFooterView();
        if (localObject1 != null) {
          ((com.tencent.mm.view.footer.b)localObject1).setHideFooter(true);
        }
      }
      localObject1 = ((j)localObject2).sgn;
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((j)localObject2).sgo = ((com.tencent.mm.view.e)localObject1).getPresenter();
      localObject1 = ((j)localObject2).sgo;
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((com.tencent.mm.bt.a)localObject1).DHC = ((a.c)new j.c((j)localObject2));
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((j)localObject2).sgs.addView((View)((j)localObject2).sgn, (ViewGroup.LayoutParams)localObject1);
      localObject1 = ((j)localObject2).sgn;
      if (localObject1 != null) {
        ((com.tencent.mm.view.e)localObject1).setSelectedFeatureListener((w)new j.d((j)localObject2));
      }
      localObject1 = ((j)localObject2).sgo;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.bt.b)localObject1).c(com.tencent.mm.api.g.cGz);
        if (localObject1 != null) {
          ((com.tencent.mm.e.d)localObject1).a((b.a)new j.e((j)localObject2));
        }
      }
      localObject1 = ((j)localObject2).sgo;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.g)((com.tencent.mm.bt.b)localObject1).c(com.tencent.mm.api.g.cGC);
        if (localObject1 != null) {
          ((com.tencent.mm.e.g)localObject1).a((b.a)new j.f((j)localObject2));
        }
      }
      localObject1 = com.tencent.mm.sdk.platformtools.f.aKw(str);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth));
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MEDIA_TYPE_INT", Integer.valueOf(1));
      if (!paramb.hbH)
      {
        paramb = this.rRi;
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
        paramb = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      paramb = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arX();
      AppMethodBeat.o(75766);
      return;
    }
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75765);
    d.g.b.k.h(parama, "navigator");
    d.g.b.k.h(paramRecordConfigProvider, "configProvider");
    ac.i("MicroMsg.EditPhotoPluginLayout", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.rRh = parama;
    this.rRi = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.wDE;
    com.tencent.mm.plugin.recordvideo.e.b.d(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      Object localObject1 = (t)parama.next();
      Object localObject2 = paramRecordConfigProvider.wqu;
      boolean bool;
      if (localObject2 != null)
      {
        localObject2 = ((UICustomParam)localObject2).fKy;
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
        localObject1 = this.sgQ.wsS;
        ((PhotoDoodlePlugin)localObject1).b(null, null);
        ((PhotoDoodlePlugin)localObject1).wuM.deferNotifyDataSetChanged();
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
    ac.i("MicroMsg.EditPhotoPluginLayout", "status :" + paramc + " , param :" + paramBundle);
    switch (b.cfA[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(75767);
      return;
    case 1: 
      alO();
      AppMethodBeat.o(75767);
      return;
    case 2: 
    case 3: 
    case 4: 
      this.wvH.setVisibility(4);
      AppMethodBeat.o(75767);
      return;
    case 5: 
      this.wvH.setVisibility(0);
      AppMethodBeat.o(75767);
      return;
    case 6: 
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.wvG;
          paramBundle = (p)paramBundle;
          d.g.b.k.h(paramBundle, "emojiInfo");
          localObject = paramc.sgo;
          if (localObject != null) {
            ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.g.cGA);
          }
          paramc = paramc.sgo;
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
      this.wvH.dvY();
      this.wvG.reset();
      AppMethodBeat.o(75767);
      return;
    case 8: 
      AppMethodBeat.o(75767);
      return;
    case 9: 
      paramc = this.wvG;
      paramc.sgr = com.tencent.mm.api.g.cGC;
      paramc.gPA = 0;
      paramBundle = paramc.sgo;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGC);
      }
      paramc = paramc.sgo;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGC, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.aqO("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.Mn(8);
      AppMethodBeat.o(75767);
      return;
    case 10: 
      paramc = this.wvG;
      paramc.sgr = com.tencent.mm.api.g.cGC;
      paramc.gPA = 1;
      paramBundle = paramc.sgo;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGC);
      }
      paramc = paramc.sgo;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGC, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.aqO("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.Mn(9);
      AppMethodBeat.o(75767);
      return;
    case 11: 
      this.wvE.reset();
      if (paramBundle != null)
      {
        paramc = this.wvG;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.sgr = com.tencent.mm.api.g.cGz;
        paramc.gPA = i;
        paramBundle = paramc.sgo;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGz);
        }
        paramc = paramc.sgo;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGz, i, null);
          AppMethodBeat.o(75767);
          return;
        }
      }
      AppMethodBeat.o(75767);
      return;
    case 12: 
      this.sgQ.reset();
      com.tencent.mm.plugin.recordvideo.plugin.filter.a locala = this.wvE;
      com.tencent.mm.bt.b localb = this.wvG.sgo;
      paramc = (d.c)localObject;
      if (localb != null) {
        paramc = localb.eQQ();
      }
      if (paramc != null) {
        locala.wuS.setPreImage(paramc);
      }
      if (paramBundle != null)
      {
        paramc = this.wvG;
        i = paramBundle.getInt("EDIT_FILTER_INDEX_INT");
        float f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT");
        paramc.sgr = com.tencent.mm.api.g.cGF;
        paramc.gPA = i;
        paramBundle = paramc.sgo;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(paramc.sgr);
        }
        paramBundle = paramc.sgo;
        if (paramBundle != null)
        {
          paramBundle.getSelectedFeatureListener().a(paramc.sgr, paramc.gPA, Float.valueOf(f));
          AppMethodBeat.o(75767);
          return;
        }
      }
      AppMethodBeat.o(75767);
      return;
    case 13: 
      paramc = this.wvG;
      paramBundle = paramc.sgo;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.Vr().Vs(), -1, null);
      }
      paramBundle = paramc.sgo;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.sgr);
      }
      paramBundle = paramc.sgo;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.sgr, paramc.gPA, null);
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 14: 
      this.sgG.setVisibility(0);
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
        this.wvH.setVisibility(0);
        break;
        this.sgG.setVisibility(4);
        this.wvH.setVisibility(4);
        paramc = this.wvG.sgo;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGB);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.sgG.setVisibility(4);
        this.wvH.setVisibility(4);
        paramc = this.wvG.sgo;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGA);
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
          paramc = this.wvG;
          paramBundle = (Editable)localObject;
          if (paramBundle == null) {
            d.g.b.k.fOy();
          }
          d.g.b.k.h(paramBundle, "text");
          paramBundle.clearSpans();
          localObject = paramc.sgo;
          if (localObject != null) {
            ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.g.cGA);
          }
          paramc = paramc.sgo;
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
          this.wvI.g(paramc, i, j);
        }
        AppMethodBeat.o(75767);
        return;
        this.sgG.setVisibility(0);
        this.wvH.dvY();
        this.sgQ.dvZ();
        this.wvG.dvX();
        AppMethodBeat.o(75767);
        return;
        paramBundle = this.wvG;
        paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
        paramc = paramBundle.sgl;
        if (paramc != null)
        {
          paramc = paramc.Iv();
          if (paramc == null) {
            d.g.b.k.fOy();
          }
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramc.JE()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          paramc = paramBundle.sgl;
          if (paramc == null) {
            break label1611;
          }
          paramc = paramc.Iv();
          if (paramc == null) {
            d.g.b.k.fOy();
          }
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramc.JD()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          paramc = paramBundle.sgl;
          if (paramc == null) {
            break label1616;
          }
          paramc = paramc.Iv();
          if (paramc == null) {
            d.g.b.k.fOy();
          }
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramc.JG()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          paramc = paramBundle.sgl;
          if (paramc == null) {
            break label1621;
          }
          paramc = paramc.Iv();
          if (paramc == null) {
            d.g.b.k.fOy();
          }
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramc.JJ()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          paramc = paramBundle.sgl;
          if (paramc == null) {
            break label1626;
          }
          paramc = paramc.Iv();
          if (paramc == null) {
            d.g.b.k.fOy();
          }
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramc.JF()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          paramc = paramBundle.sgl;
          if (paramc == null) {
            break label1631;
          }
          paramc = paramc.Iv();
          if (paramc == null) {
            d.g.b.k.fOy();
          }
          if (paramc.JI()) {
            i = 1;
          }
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ROTATE_INT", Integer.valueOf(i));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
          paramc = paramBundle.sgl;
          if (paramc == null) {
            break label1636;
          }
        }
        boolean bool;
        for (paramc = paramc.Iv();; paramc = null)
        {
          if (paramc == null) {
            d.g.b.k.fOy();
          }
          bool = paramc.JK();
          paramc = com.tencent.mm.plugin.recordvideo.d.c.wyg;
          com.tencent.mm.plugin.recordvideo.d.c.w("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
          if (bool)
          {
            paramc = com.tencent.mm.media.j.d.gWO;
            com.tencent.mm.media.j.d.arW();
          }
          paramc = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.asd();
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
        long l = bs.Gn();
        ac.i("MicroMsg.EditPhotoPluginLayout", "dofinish time: " + l + ' ' + bool);
        paramc = paramBundle.sgl;
        if (paramc != null)
        {
          paramc.a((s)new j.b(paramBundle, l, bool));
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.sgQ.wsS.setVisibility(4);
        this.sgG.setVisibility(4);
        paramc = this.wvH;
        paramc.wsM = k.a.wsN;
        paramBundle = paramc.wsI;
        d.g.b.k.g(paramBundle, "normalFuncLayout");
        paramBundle.setVisibility(4);
        paramc = paramc.wsJ;
        d.g.b.k.g(paramc, "cropFuncLayout");
        paramc.setVisibility(0);
        paramc = this.wvG;
        if (paramc.sgr != com.tencent.mm.api.g.cGD)
        {
          paramc.sgr = com.tencent.mm.api.g.cGD;
          paramc = paramc.sgo;
          if (paramc != null)
          {
            paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGD);
            AppMethodBeat.o(75767);
            return;
          }
        }
        AppMethodBeat.o(75767);
        return;
        this.sgG.setVisibility(0);
        paramc = this.wvG;
        paramc.sgr = com.tencent.mm.api.g.cGy;
        paramc = paramc.sgo;
        if (paramc != null) {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGD, 2, null);
        }
        this.sgQ.dvZ();
        AppMethodBeat.o(75767);
        return;
        paramc = this.wvG;
        paramc.sgr = com.tencent.mm.api.g.cGD;
        paramc = paramc.sgo;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGD, 0, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        paramc = this.wvG;
        paramc.sgr = com.tencent.mm.api.g.cGD;
        paramc = paramc.sgo;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGD, 3, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      } while (this.wvH.rTS.getVisibility() == 4);
      label1424:
      label1464:
      label1611:
      label1616:
      label1621:
      label1626:
      label1631:
      label1636:
      if (this.wvH.rTS.getVisibility() == 0) {
        this.wvH.setVisibility(4);
      }
      AppMethodBeat.o(75767);
      return;
    }
    this.wvH.setVisibility(4);
    AppMethodBeat.o(75767);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(75768);
    if (!super.alO())
    {
      Object localObject = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asa();
      localObject = com.tencent.mm.plugin.recordvideo.d.c.wyg;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject = this.rRh;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    AppMethodBeat.o(75768);
    return true;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.sgm;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.rRi;
  }
  
  protected final j getEditPhotoWrapper()
  {
    return this.wvG;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.sgm = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.rRi = paramRecordConfigProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */