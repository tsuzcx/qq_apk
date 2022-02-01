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
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.j.b;
import com.tencent.mm.plugin.recordvideo.plugin.j.c;
import com.tencent.mm.plugin.recordvideo.plugin.j.d;
import com.tencent.mm.plugin.recordvideo.plugin.j.e;
import com.tencent.mm.plugin.recordvideo.plugin.j.f;
import com.tencent.mm.plugin.recordvideo.plugin.k;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "getEditPhotoWrapper", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "editShadowPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "initLogic", "", "loadCurrentPage", "info", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditPhotoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final EditPhotoPluginLayout.a xDS;
  private com.tencent.mm.plugin.recordvideo.activity.a sNH;
  private RecordConfigProvider sNI;
  private com.tencent.mm.media.widget.camerarecordview.b.b xAw;
  private final f xDB;
  private final com.tencent.mm.plugin.recordvideo.plugin.e xDC;
  private final com.tencent.mm.plugin.recordvideo.plugin.g xDH;
  private final m xDL;
  private final com.tencent.mm.plugin.recordvideo.plugin.filter.a xDM;
  private final com.tencent.mm.plugin.recordvideo.plugin.l xDN;
  private final j xDO;
  private final k xDP;
  private final com.tencent.mm.plugin.recordvideo.plugin.c xDQ;
  private final n xDR;
  private final com.tencent.mm.plugin.recordvideo.plugin.a xDt;
  
  static
  {
    AppMethodBeat.i(75770);
    xDS = new EditPhotoPluginLayout.a((byte)0);
    AppMethodBeat.o(75770);
  }
  
  public EditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75769);
    View.inflate(paramContext, 2131495086, (ViewGroup)this);
    paramContext = findViewById(2131297952);
    d.g.b.p.g(paramContext, "findViewById(R.id.change_text_root)");
    this.xDH = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramContext);
    paramContext = findViewById(2131299285);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_close)");
    this.xDC = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramContext, (d)this);
    this.xDL = new m((ViewGroup)this, (d)this);
    this.xDM = new com.tencent.mm.plugin.recordvideo.plugin.filter.a((ViewGroup)this, (d)this);
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131299273);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.xDt = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    this.xDQ = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.xDH.xzZ);
    paramContext = findViewById(2131299296);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_photo_crop)");
    this.xDN = new com.tencent.mm.plugin.recordvideo.plugin.l((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299295);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_mix)");
    this.xDB = new f(paramContext, (d)this);
    paramContext = findViewById(2131303249);
    d.g.b.p.g(paramContext, "findViewById(R.id.photo_preview_plugin)");
    this.xDO = new j((FrameLayout)paramContext, (d)this);
    paramContext = findViewById(2131298784);
    d.g.b.p.g(paramContext, "findViewById(R.id.control_container)");
    this.xDP = new k((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131304672);
    d.g.b.p.g(paramContext, "findViewById(R.id.shadow_bg)");
    this.xDR = new n(paramContext, (d)this);
    this.xDt.setVisibility(0);
    this.xDQ.setVisibility(0);
    this.xDL.setVisibility(0);
    getPluginList().add(this.xDP);
    getPluginList().add(this.xDL);
    getPluginList().add(this.xDM);
    getPluginList().add(this.xDN);
    getPluginList().add(this.xDO);
    getPluginList().add(this.xDC);
    getPluginList().add(this.xDt);
    getPluginList().add(this.xDB);
    getPluginList().add(this.xDQ);
    AppMethodBeat.o(75769);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(75766);
    super.a(paramb);
    if (paramb != null)
    {
      this.xAw = paramb;
      Object localObject1 = this.xDO;
      Object localObject2 = this.sNI;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      d.g.b.p.h(localObject2, "configProvider");
      d.g.b.p.h(paramb, "captureInfo");
      ((j)localObject1).sNI = ((RecordConfigProvider)localObject2);
      ((j)localObject1).xAw = paramb;
      localObject2 = this.xDO;
      String str = paramb.htV;
      d.g.b.p.h(str, "path");
      ((j)localObject2).xAB.setVisibility(0);
      localObject1 = ((j)localObject2).xAw;
      Object localObject3;
      boolean bool;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).htY == true))
      {
        localObject1 = ((j)localObject2).dGu();
        ((j)localObject2).vVH = ((y)localObject1);
        localObject1 = ((j)localObject2).vVH;
        if (localObject1 != null)
        {
          localObject3 = new y.a.a();
          Object localObject4 = ((j)localObject2).sNI;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 291)) {
            break label360;
          }
          localObject4 = ((j)localObject2).sNI;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 293)) {
            break label360;
          }
          bool = true;
          label201:
          localObject3 = ((y.a.a)localObject3).ca(bool).Lm().i(new Rect(((j)localObject2).xAB.getLeft(), ((j)localObject2).xAB.getTop(), ((j)localObject2).xAB.getRight(), ((j)localObject2).xAB.getBottom())).a(y.c.cRU);
          localObject4 = ((j)localObject2).xAw;
          if ((localObject4 == null) || (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).htP != true)) {
            break label365;
          }
          bool = true;
          label283:
          ((y)localObject1).a(((y.a.a)localObject3).cb(bool).eU(str).Ln());
        }
        localObject1 = ((j)localObject2).vVH;
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
        localObject1 = ((j)localObject2).dGt();
        break;
        bool = false;
        break label201;
        bool = false;
        break label283;
      }
      label376:
      ((j)localObject2).xAx = ((com.tencent.mm.view.e)localObject1);
      localObject1 = ((j)localObject2).sNI;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).ime;
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject3 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject3);
            localObject3 = ((j)localObject2).xAx;
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
      localObject1 = ((j)localObject2).xAx;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.footer.b)((com.tencent.mm.view.e)localObject1).getBaseFooterView();
        if (localObject1 != null) {
          ((com.tencent.mm.view.footer.b)localObject1).setHideFooter(true);
        }
      }
      localObject1 = ((j)localObject2).xAx;
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((j)localObject2).xAy = ((com.tencent.mm.view.e)localObject1).getPresenter();
      localObject1 = ((j)localObject2).xAy;
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((com.tencent.mm.bu.a)localObject1).FmJ = ((a.c)new j.c((j)localObject2));
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((j)localObject2).xAB.addView((View)((j)localObject2).xAx, (ViewGroup.LayoutParams)localObject1);
      localObject1 = ((j)localObject2).xAx;
      if (localObject1 != null) {
        ((com.tencent.mm.view.e)localObject1).setSelectedFeatureListener((w)new j.d((j)localObject2));
      }
      localObject1 = ((j)localObject2).xAy;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.bu.b)localObject1).c(com.tencent.mm.api.g.cRD);
        if (localObject1 != null) {
          ((com.tencent.mm.e.d)localObject1).a((b.a)new j.e((j)localObject2));
        }
      }
      localObject1 = ((j)localObject2).xAy;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.g)((com.tencent.mm.bu.b)localObject1).c(com.tencent.mm.api.g.cRG);
        if (localObject1 != null) {
          ((com.tencent.mm.e.g)localObject1).a((b.a)new j.f((j)localObject2));
        }
      }
      localObject1 = com.tencent.mm.sdk.platformtools.g.aQc(str);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth));
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_MEDIA_TYPE_INT", Integer.valueOf(1));
      if (!paramb.htP)
      {
        paramb = this.sNI;
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
        paramb = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      paramb = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auK();
      AppMethodBeat.o(75766);
      return;
    }
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75765);
    d.g.b.p.h(parama, "navigator");
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    ad.i("MicroMsg.EditPhotoPluginLayout", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.sNH = parama;
    this.sNI = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.xRl;
    com.tencent.mm.plugin.recordvideo.e.b.d(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      Object localObject1 = (t)parama.next();
      Object localObject2 = paramRecordConfigProvider.xyk;
      boolean bool;
      if (localObject2 != null)
      {
        localObject2 = ((UICustomParam)localObject2).gdZ;
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
        localObject1 = this.xDL.xAS;
        ((PhotoDoodlePlugin)localObject1).b(null, null);
        ((PhotoDoodlePlugin)localObject1).xCI.deferNotifyDataSetChanged();
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
    d.g.b.p.h(paramc, "status");
    ad.i("MicroMsg.EditPhotoPluginLayout", "status :" + paramc + " , param :" + paramBundle);
    switch (b.cpQ[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(75767);
      return;
    case 1: 
      aoB();
      AppMethodBeat.o(75767);
      return;
    case 2: 
    case 3: 
    case 4: 
      this.xDP.setVisibility(4);
      AppMethodBeat.o(75767);
      return;
    case 5: 
      this.xDP.setVisibility(0);
      AppMethodBeat.o(75767);
      return;
    case 6: 
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.xDO;
          paramBundle = (com.tencent.mm.api.p)paramBundle;
          d.g.b.p.h(paramBundle, "emojiInfo");
          localObject = paramc.xAy;
          if (localObject != null) {
            ((com.tencent.mm.bu.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.g.cRE);
          }
          paramc = paramc.xAy;
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
      this.xDP.dGw();
      this.xDO.reset();
      AppMethodBeat.o(75767);
      return;
    case 8: 
      AppMethodBeat.o(75767);
      return;
    case 9: 
      paramc = this.xDO;
      paramc.xAA = com.tencent.mm.api.g.cRG;
      paramc.rko = 0;
      paramBundle = paramc.xAy;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRG);
      }
      paramc = paramc.xAy;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRG, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.avN("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.NM(8);
      AppMethodBeat.o(75767);
      return;
    case 10: 
      paramc = this.xDO;
      paramc.xAA = com.tencent.mm.api.g.cRG;
      paramc.rko = 1;
      paramBundle = paramc.xAy;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRG);
      }
      paramc = paramc.xAy;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRG, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.avN("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.NM(9);
      AppMethodBeat.o(75767);
      return;
    case 11: 
      this.xDM.reset();
      if (paramBundle != null)
      {
        paramc = this.xDO;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.xAA = com.tencent.mm.api.g.cRD;
        paramc.rko = i;
        paramBundle = paramc.xAy;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRD);
        }
        paramc = paramc.xAy;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRD, i, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 12: 
      this.xDL.reset();
      com.tencent.mm.plugin.recordvideo.plugin.filter.a locala = this.xDM;
      com.tencent.mm.bu.b localb = this.xDO.xAy;
      paramc = (d.c)localObject;
      if (localb != null) {
        paramc = localb.ffU();
      }
      if (paramc != null) {
        locala.xCO.setPreImage(paramc);
      }
      if (paramBundle != null)
      {
        paramc = this.xDO;
        i = paramBundle.getInt("EDIT_FILTER_INDEX_INT");
        float f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT");
        paramc.xAA = com.tencent.mm.api.g.cRJ;
        paramc.rko = i;
        paramBundle = paramc.xAy;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(paramc.xAA);
        }
        paramBundle = paramc.xAy;
        if (paramBundle != null)
        {
          paramBundle.getSelectedFeatureListener().a(paramc.xAA, paramc.rko, Float.valueOf(f));
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 13: 
      paramc = this.xDO;
      paramBundle = paramc.xAy;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.XI().XJ(), -1, null);
      }
      paramBundle = paramc.xAy;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.xAA);
      }
      paramBundle = paramc.xAy;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.xAA, paramc.rko, null);
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 14: 
      this.xDC.setVisibility(0);
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
      label1332:
      label1372:
      label1639:
      label1644:
      label1649:
      label1654:
      label1659:
      do
      {
        this.xDP.setVisibility(0);
        break;
        this.xDC.setVisibility(4);
        this.xDP.setVisibility(4);
        paramc = this.xDO.xAy;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRF);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.xDC.setVisibility(4);
        this.xDP.setVisibility(4);
        paramc = this.xDO.xAy;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRE);
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
          paramc = this.xDO;
          paramBundle = (Editable)localObject;
          if (paramBundle == null) {
            d.g.b.p.gfZ();
          }
          d.g.b.p.h(paramBundle, "text");
          paramBundle.clearSpans();
          localObject = paramc.xAy;
          if (localObject != null) {
            ((com.tencent.mm.bu.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.g.cRE);
          }
          paramc = paramc.xAy;
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
          com.tencent.mm.plugin.recordvideo.plugin.c.a(this.xDQ, paramc, i, j);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.xDC.setVisibility(0);
        this.xDP.dGw();
        this.xDL.dGx();
        this.xDO.dGv();
        AppMethodBeat.o(75767);
        return;
        paramBundle = this.xDO;
        paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        paramc = paramBundle.vVH;
        if (paramc != null)
        {
          paramc = paramc.JV();
          if (paramc == null) {
            d.g.b.p.gfZ();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramc.Ld()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          paramc = paramBundle.vVH;
          if (paramc == null) {
            break label1639;
          }
          paramc = paramc.JV();
          if (paramc == null) {
            d.g.b.p.gfZ();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramc.Lc()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          paramc = paramBundle.vVH;
          if (paramc == null) {
            break label1644;
          }
          paramc = paramc.JV();
          if (paramc == null) {
            d.g.b.p.gfZ();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramc.Lf()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          paramc = paramBundle.vVH;
          if (paramc == null) {
            break label1649;
          }
          paramc = paramc.JV();
          if (paramc == null) {
            d.g.b.p.gfZ();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramc.Li()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          paramc = paramBundle.vVH;
          if (paramc == null) {
            break label1654;
          }
          paramc = paramc.JV();
          if (paramc == null) {
            d.g.b.p.gfZ();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramc.Le()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          paramc = paramBundle.vVH;
          if (paramc == null) {
            break label1659;
          }
          paramc = paramc.JV();
          if (paramc == null) {
            d.g.b.p.gfZ();
          }
          if (paramc.Lh()) {
            i = 1;
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ROTATE_INT", Integer.valueOf(i));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
          paramc = paramBundle.vVH;
          if (paramc == null) {
            break label1664;
          }
        }
        boolean bool;
        for (paramc = paramc.JV();; paramc = null)
        {
          if (paramc == null) {
            d.g.b.p.gfZ();
          }
          bool = paramc.Lj();
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
          if (bool)
          {
            paramc = com.tencent.mm.media.k.d.hoU;
            com.tencent.mm.media.k.d.auJ();
          }
          paramc = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.auQ();
          if (paramBundle.isFinishing) {
            break label1679;
          }
          paramc = paramBundle.context;
          if (paramc != null) {
            break label1669;
          }
          paramc = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(75767);
          throw paramc;
          paramc = null;
          break;
          paramc = null;
          break label1332;
          paramc = null;
          break label1372;
          paramc = null;
          break label1412;
          paramc = null;
          break label1452;
          paramc = null;
          break label1492;
        }
        if (((Activity)paramc).isFinishing())
        {
          AppMethodBeat.o(75767);
          return;
        }
        paramBundle.isFinishing = true;
        long l = bt.HI();
        ad.i("MicroMsg.EditPhotoPluginLayout", "dofinish time: " + l + ' ' + bool);
        paramc = paramBundle.vVH;
        if (paramc != null)
        {
          paramc.a((s)new j.b(paramBundle, l, bool));
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.xDL.xAS.setVisibility(4);
        this.xDC.setVisibility(4);
        paramc = this.xDP;
        paramc.xAM = k.a.xAN;
        paramBundle = paramc.xAI;
        d.g.b.p.g(paramBundle, "normalFuncLayout");
        paramBundle.setVisibility(4);
        paramc = paramc.xAJ;
        d.g.b.p.g(paramc, "cropFuncLayout");
        paramc.setVisibility(0);
        paramc = this.xDO;
        if (paramc.xAA != com.tencent.mm.api.g.cRH)
        {
          paramc.xAA = com.tencent.mm.api.g.cRH;
          paramc = paramc.xAy;
          if (paramc != null)
          {
            paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRH);
            AppMethodBeat.o(75767);
            return;
          }
        }
        AppMethodBeat.o(75767);
        return;
        this.xDC.setVisibility(0);
        paramc = this.xDO;
        paramc.xAA = com.tencent.mm.api.g.cRC;
        paramc = paramc.xAy;
        if (paramc != null) {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRH, 2, null);
        }
        this.xDL.dGx();
        AppMethodBeat.o(75767);
        return;
        paramc = this.xDO;
        paramc.xAA = com.tencent.mm.api.g.cRH;
        paramc = paramc.xAy;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRH, 0, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        paramc = this.xDO;
        paramc.xAA = com.tencent.mm.api.g.cRH;
        paramc = paramc.xAy;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRH, 3, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      } while (this.xDP.sQD.getVisibility() == 4);
      label1412:
      label1452:
      label1492:
      if (this.xDP.sQD.getVisibility() == 0) {
        this.xDP.setVisibility(4);
      }
      label1664:
      label1669:
      label1679:
      AppMethodBeat.o(75767);
      return;
    }
    this.xDP.setVisibility(4);
    AppMethodBeat.o(75767);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(75768);
    if (!super.aoB())
    {
      Object localObject = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auN();
      localObject = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject = this.sNH;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    AppMethodBeat.o(75768);
    return true;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.xAw;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.sNI;
  }
  
  protected final j getEditPhotoWrapper()
  {
    return this.xDO;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.xAw = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.sNI = paramRecordConfigProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */