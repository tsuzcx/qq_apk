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
import com.tencent.mm.bt.a.c;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "getEditPhotoWrapper", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "editShadowPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "initLogic", "", "loadCurrentPage", "info", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditPhotoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final EditPhotoPluginLayout.a xTN;
  private com.tencent.mm.plugin.recordvideo.activity.a sYS;
  private RecordConfigProvider sYT;
  private com.tencent.mm.media.widget.camerarecordview.b.b xQs;
  private final com.tencent.mm.plugin.recordvideo.plugin.g xTC;
  private final m xTG;
  private final com.tencent.mm.plugin.recordvideo.plugin.filter.a xTH;
  private final com.tencent.mm.plugin.recordvideo.plugin.l xTI;
  private final j xTJ;
  private final k xTK;
  private final com.tencent.mm.plugin.recordvideo.plugin.c xTL;
  private final n xTM;
  private final com.tencent.mm.plugin.recordvideo.plugin.a xTo;
  private final f xTw;
  private final com.tencent.mm.plugin.recordvideo.plugin.e xTx;
  
  static
  {
    AppMethodBeat.i(75770);
    xTN = new EditPhotoPluginLayout.a((byte)0);
    AppMethodBeat.o(75770);
  }
  
  public EditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75769);
    View.inflate(paramContext, 2131495086, (ViewGroup)this);
    paramContext = findViewById(2131297952);
    d.g.b.p.g(paramContext, "findViewById(R.id.change_text_root)");
    this.xTC = new com.tencent.mm.plugin.recordvideo.plugin.g((EditorInputView)paramContext);
    paramContext = findViewById(2131299285);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_close)");
    this.xTx = new com.tencent.mm.plugin.recordvideo.plugin.e((ImageView)paramContext, (d)this);
    this.xTG = new m((ViewGroup)this, (d)this);
    this.xTH = new com.tencent.mm.plugin.recordvideo.plugin.filter.a((ViewGroup)this, (d)this);
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131299273);
    d.g.b.p.g(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.xTo = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    this.xTL = new com.tencent.mm.plugin.recordvideo.plugin.c((ViewGroup)this, (d)this, this.xTC.xPV);
    paramContext = findViewById(2131299296);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_photo_crop)");
    this.xTI = new com.tencent.mm.plugin.recordvideo.plugin.l((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131299295);
    d.g.b.p.g(paramContext, "findViewById(R.id.editor_mix)");
    this.xTw = new f(paramContext, (d)this);
    paramContext = findViewById(2131303249);
    d.g.b.p.g(paramContext, "findViewById(R.id.photo_preview_plugin)");
    this.xTJ = new j((FrameLayout)paramContext, (d)this);
    paramContext = findViewById(2131298784);
    d.g.b.p.g(paramContext, "findViewById(R.id.control_container)");
    this.xTK = new k((ViewGroup)paramContext, (d)this);
    paramContext = findViewById(2131304672);
    d.g.b.p.g(paramContext, "findViewById(R.id.shadow_bg)");
    this.xTM = new n(paramContext, (d)this);
    this.xTo.setVisibility(0);
    this.xTL.setVisibility(0);
    this.xTG.setVisibility(0);
    getPluginList().add(this.xTK);
    getPluginList().add(this.xTG);
    getPluginList().add(this.xTH);
    getPluginList().add(this.xTI);
    getPluginList().add(this.xTJ);
    getPluginList().add(this.xTx);
    getPluginList().add(this.xTo);
    getPluginList().add(this.xTw);
    getPluginList().add(this.xTL);
    AppMethodBeat.o(75769);
  }
  
  public void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(75766);
    super.a(paramb);
    if (paramb != null)
    {
      this.xQs = paramb;
      Object localObject1 = this.xTJ;
      Object localObject2 = this.sYT;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      d.g.b.p.h(localObject2, "configProvider");
      d.g.b.p.h(paramb, "captureInfo");
      ((j)localObject1).sYT = ((RecordConfigProvider)localObject2);
      ((j)localObject1).xQs = paramb;
      localObject2 = this.xTJ;
      String str = paramb.hwJ;
      d.g.b.p.h(str, "path");
      ((j)localObject2).xQw.setVisibility(0);
      localObject1 = ((j)localObject2).xQs;
      Object localObject3;
      boolean bool;
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwM == true))
      {
        localObject1 = ((j)localObject2).dJL();
        ((j)localObject2).whL = ((y)localObject1);
        localObject1 = ((j)localObject2).whL;
        if (localObject1 != null)
        {
          localObject3 = new y.a.a();
          Object localObject4 = ((j)localObject2).sYT;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 291)) {
            break label360;
          }
          localObject4 = ((j)localObject2).sYT;
          if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 293)) {
            break label360;
          }
          bool = true;
          label201:
          localObject3 = ((y.a.a)localObject3).ca(bool).Lu().i(new Rect(((j)localObject2).xQw.getLeft(), ((j)localObject2).xQw.getTop(), ((j)localObject2).xQw.getRight(), ((j)localObject2).xQw.getBottom())).a(y.c.cSE);
          localObject4 = ((j)localObject2).xQs;
          if ((localObject4 == null) || (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).hwD != true)) {
            break label365;
          }
          bool = true;
          label283:
          ((y)localObject1).a(((y.a.a)localObject3).cb(bool).eZ(str).Lv());
        }
        localObject1 = ((j)localObject2).whL;
        if (localObject1 == null) {
          break label370;
        }
      }
      label360:
      label365:
      label370:
      for (localObject1 = ((y)localObject1).bh(((j)localObject2).context);; localObject1 = null)
      {
        if (localObject1 != null) {
          break label376;
        }
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
        localObject1 = ((j)localObject2).dJK();
        break;
        bool = false;
        break label201;
        bool = false;
        break label283;
      }
      label376:
      ((j)localObject2).xQt = ((com.tencent.mm.view.e)localObject1);
      localObject1 = ((j)localObject2).sYT;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).ioY;
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject3 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject3);
            localObject3 = ((j)localObject2).xQt;
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
      localObject1 = ((j)localObject2).xQt;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.footer.b)((com.tencent.mm.view.e)localObject1).getBaseFooterView();
        if (localObject1 != null) {
          ((com.tencent.mm.view.footer.b)localObject1).setHideFooter(true);
        }
      }
      localObject1 = ((j)localObject2).xQt;
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((j)localObject2).xQu = ((com.tencent.mm.view.e)localObject1).getPresenter();
      localObject1 = ((j)localObject2).xQu;
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
        AppMethodBeat.o(75766);
        throw paramb;
      }
      ((com.tencent.mm.bt.a)localObject1).FFh = ((a.c)new j.c((j)localObject2));
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((j)localObject2).xQw.addView((View)((j)localObject2).xQt, (ViewGroup.LayoutParams)localObject1);
      localObject1 = ((j)localObject2).xQt;
      if (localObject1 != null) {
        ((com.tencent.mm.view.e)localObject1).setSelectedFeatureListener((w)new j.d((j)localObject2));
      }
      localObject1 = ((j)localObject2).xQu;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.bt.b)localObject1).c(com.tencent.mm.api.g.cSn);
        if (localObject1 != null) {
          ((com.tencent.mm.e.d)localObject1).a((b.a)new j.e((j)localObject2));
        }
      }
      localObject1 = ((j)localObject2).xQu;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.e.g)((com.tencent.mm.bt.b)localObject1).c(com.tencent.mm.api.g.cSq);
        if (localObject1 != null) {
          ((com.tencent.mm.e.g)localObject1).a((b.a)new j.f((j)localObject2));
        }
      }
      localObject1 = h.aRz(str);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth));
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_MEDIA_TYPE_INT", Integer.valueOf(1));
      if (!paramb.hwD)
      {
        paramb = this.sYT;
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
        paramb = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0));
      }
      paramb = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auZ();
      AppMethodBeat.o(75766);
      return;
    }
  }
  
  public void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(75765);
    d.g.b.p.h(parama, "navigator");
    d.g.b.p.h(paramRecordConfigProvider, "configProvider");
    ae.i("MicroMsg.EditPhotoPluginLayout", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.sYS = parama;
    this.sYT = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.e.b.yhe;
    com.tencent.mm.plugin.recordvideo.e.b.d(paramRecordConfigProvider);
    parama = ((Iterable)getPluginList()).iterator();
    if (parama.hasNext())
    {
      Object localObject1 = (t)parama.next();
      Object localObject2 = paramRecordConfigProvider.xOh;
      boolean bool;
      if (localObject2 != null)
      {
        localObject2 = ((UICustomParam)localObject2).ggh;
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
        localObject1 = this.xTG.xQN;
        ((PhotoDoodlePlugin)localObject1).b(null, null);
        ((PhotoDoodlePlugin)localObject1).xSD.deferNotifyDataSetChanged();
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
    ae.i("MicroMsg.EditPhotoPluginLayout", "status :" + paramc + " , param :" + paramBundle);
    switch (b.cqt[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(75767);
      return;
    case 1: 
      aoQ();
      AppMethodBeat.o(75767);
      return;
    case 2: 
    case 3: 
    case 4: 
      this.xTK.setVisibility(4);
      AppMethodBeat.o(75767);
      return;
    case 5: 
      this.xTK.setVisibility(0);
      AppMethodBeat.o(75767);
      return;
    case 6: 
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.xTJ;
          paramBundle = (com.tencent.mm.api.p)paramBundle;
          d.g.b.p.h(paramBundle, "emojiInfo");
          localObject = paramc.xQu;
          if (localObject != null) {
            ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.g.cSo);
          }
          paramc = paramc.xQu;
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
      this.xTK.dJN();
      this.xTJ.reset();
      AppMethodBeat.o(75767);
      return;
    case 8: 
      AppMethodBeat.o(75767);
      return;
    case 9: 
      paramc = this.xTJ;
      paramc.xQv = com.tencent.mm.api.g.cSq;
      paramc.rss = 0;
      paramBundle = paramc.xQu;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSq);
      }
      paramc = paramc.xQu;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSq, 0, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.axc("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.Os(8);
      AppMethodBeat.o(75767);
      return;
    case 10: 
      paramc = this.xTJ;
      paramc.xQv = com.tencent.mm.api.g.cSq;
      paramc.rss = 1;
      paramBundle = paramc.xQu;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSq);
      }
      paramc = paramc.xQu;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSq, 1, null);
      }
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.axc("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.Os(9);
      AppMethodBeat.o(75767);
      return;
    case 11: 
      this.xTH.reset();
      if (paramBundle != null)
      {
        paramc = this.xTJ;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.xQv = com.tencent.mm.api.g.cSn;
        paramc.rss = i;
        paramBundle = paramc.xQu;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSn);
        }
        paramc = paramc.xQu;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSn, i, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 12: 
      this.xTG.reset();
      com.tencent.mm.plugin.recordvideo.plugin.filter.a locala = this.xTH;
      com.tencent.mm.bt.b localb = this.xTJ.xQu;
      paramc = (d.c)localObject;
      if (localb != null) {
        paramc = localb.fjK();
      }
      if (paramc != null) {
        locala.xSJ.setPreImage(paramc);
      }
      if (paramBundle != null)
      {
        paramc = this.xTJ;
        i = paramBundle.getInt("EDIT_FILTER_INDEX_INT");
        float f = paramBundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT");
        paramc.xQv = com.tencent.mm.api.g.cSt;
        paramc.rss = i;
        paramBundle = paramc.xQu;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(paramc.xQv);
        }
        paramBundle = paramc.xQu;
        if (paramBundle != null)
        {
          paramBundle.getSelectedFeatureListener().a(paramc.xQv, paramc.rss, Float.valueOf(f));
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 13: 
      paramc = this.xTJ;
      paramBundle = paramc.xQu;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.XS().XT(), -1, null);
      }
      paramBundle = paramc.xQu;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.xQv);
      }
      paramBundle = paramc.xQu;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.xQv, paramc.rss, null);
        AppMethodBeat.o(75767);
        return;
      }
      AppMethodBeat.o(75767);
      return;
    case 14: 
      this.xTx.setVisibility(0);
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
        this.xTK.setVisibility(0);
        break;
        this.xTx.setVisibility(4);
        this.xTK.setVisibility(4);
        paramc = this.xTJ.xQu;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSp);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.xTx.setVisibility(4);
        this.xTK.setVisibility(4);
        paramc = this.xTJ.xQu;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSo);
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
          paramc = this.xTJ;
          paramBundle = (Editable)localObject;
          if (paramBundle == null) {
            d.g.b.p.gkB();
          }
          d.g.b.p.h(paramBundle, "text");
          paramBundle.clearSpans();
          localObject = paramc.xQu;
          if (localObject != null) {
            ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.g.cSo);
          }
          paramc = paramc.xQu;
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
          com.tencent.mm.plugin.recordvideo.plugin.c.a(this.xTL, paramc, i, j);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.xTx.setVisibility(0);
        this.xTK.dJN();
        this.xTG.dJO();
        this.xTJ.dJM();
        AppMethodBeat.o(75767);
        return;
        paramBundle = this.xTJ;
        paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        paramc = paramBundle.whL;
        if (paramc != null)
        {
          paramc = paramc.Kd();
          if (paramc == null) {
            d.g.b.p.gkB();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramc.Ll()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          paramc = paramBundle.whL;
          if (paramc == null) {
            break label1639;
          }
          paramc = paramc.Kd();
          if (paramc == null) {
            d.g.b.p.gkB();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramc.Lk()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          paramc = paramBundle.whL;
          if (paramc == null) {
            break label1644;
          }
          paramc = paramc.Kd();
          if (paramc == null) {
            d.g.b.p.gkB();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramc.Ln()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          paramc = paramBundle.whL;
          if (paramc == null) {
            break label1649;
          }
          paramc = paramc.Kd();
          if (paramc == null) {
            d.g.b.p.gkB();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramc.Lq()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          paramc = paramBundle.whL;
          if (paramc == null) {
            break label1654;
          }
          paramc = paramc.Kd();
          if (paramc == null) {
            d.g.b.p.gkB();
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramc.Lm()));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          paramc = paramBundle.whL;
          if (paramc == null) {
            break label1659;
          }
          paramc = paramc.Kd();
          if (paramc == null) {
            d.g.b.p.gkB();
          }
          if (paramc.Lp()) {
            i = 1;
          }
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ROTATE_INT", Integer.valueOf(i));
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
          paramc = paramBundle.whL;
          if (paramc == null) {
            break label1664;
          }
        }
        boolean bool;
        for (paramc = paramc.Kd();; paramc = null)
        {
          if (paramc == null) {
            d.g.b.p.gkB();
          }
          bool = paramc.Lr();
          paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
          if (bool)
          {
            paramc = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.auY();
          }
          paramc = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avf();
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
        long l = bu.HQ();
        ae.i("MicroMsg.EditPhotoPluginLayout", "dofinish time: " + l + ' ' + bool);
        paramc = paramBundle.whL;
        if (paramc != null)
        {
          paramc.a((s)new j.b(paramBundle, l, bool));
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        this.xTG.xQN.setVisibility(4);
        this.xTx.setVisibility(4);
        paramc = this.xTK;
        paramc.xQH = k.a.xQI;
        paramBundle = paramc.xQD;
        d.g.b.p.g(paramBundle, "normalFuncLayout");
        paramBundle.setVisibility(4);
        paramc = paramc.xQE;
        d.g.b.p.g(paramc, "cropFuncLayout");
        paramc.setVisibility(0);
        paramc = this.xTJ;
        if (paramc.xQv != com.tencent.mm.api.g.cSr)
        {
          paramc.xQv = com.tencent.mm.api.g.cSr;
          paramc = paramc.xQu;
          if (paramc != null)
          {
            paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSr);
            AppMethodBeat.o(75767);
            return;
          }
        }
        AppMethodBeat.o(75767);
        return;
        this.xTx.setVisibility(0);
        paramc = this.xTJ;
        paramc.xQv = com.tencent.mm.api.g.cSm;
        paramc = paramc.xQu;
        if (paramc != null) {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSr, 2, null);
        }
        this.xTG.dJO();
        AppMethodBeat.o(75767);
        return;
        paramc = this.xTJ;
        paramc.xQv = com.tencent.mm.api.g.cSr;
        paramc = paramc.xQu;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSr, 0, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
        paramc = this.xTJ;
        paramc.xQv = com.tencent.mm.api.g.cSr;
        paramc = paramc.xQu;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSr, 3, null);
          AppMethodBeat.o(75767);
          return;
        }
        AppMethodBeat.o(75767);
        return;
      } while (this.xTK.tbO.getVisibility() == 4);
      label1412:
      label1452:
      label1492:
      if (this.xTK.tbO.getVisibility() == 0) {
        this.xTK.setVisibility(4);
      }
      label1664:
      label1669:
      label1679:
      AppMethodBeat.o(75767);
      return;
    }
    this.xTK.setVisibility(4);
    AppMethodBeat.o(75767);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(75768);
    if (!super.aoQ())
    {
      Object localObject = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avc();
      localObject = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject = this.sYS;
      if (localObject != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject);
      }
    }
    AppMethodBeat.o(75768);
    return true;
  }
  
  protected final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo()
  {
    return this.xQs;
  }
  
  protected final RecordConfigProvider getConfigProvider()
  {
    return this.sYT;
  }
  
  protected final j getEditPhotoWrapper()
  {
    return this.xTJ;
  }
  
  protected final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    this.xQs = paramb;
  }
  
  protected final void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    this.sYT = paramRecordConfigProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */