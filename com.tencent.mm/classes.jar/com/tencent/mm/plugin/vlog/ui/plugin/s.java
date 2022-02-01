package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a.a;
import com.tencent.mm.api.ac.b;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.api.i;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.d;
import com.tencent.mm.e.h;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "editorViewDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "Lkotlin/collections/HashMap;", "isFinishing", "", "moved", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "sourcePath", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "ret", "path", "edited", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "onBackPress", "onDetach", "post", "r", "Lkotlin/Function0;", "release", "reset", "setDrawingPadding", "left", "top", "right", "bottom", "setVisibility", "visibility", "setup", "showEmojiPanel", "showTextPanel", "unDo", "updatePhotoEdit", "Companion", "PhotoEditorViewData", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final s.a UiX;
  private ac LcI;
  private FrameLayout Lsb;
  private com.tencent.mm.bt.b Lsg;
  private i Lsk;
  private com.tencent.mm.media.widget.camerarecordview.b.b NKf;
  private m NKg;
  private final HashMap<String, s.b> UiY;
  private final Context context;
  private boolean isFinishing;
  private boolean mat;
  private RecordConfigProvider oaV;
  private int zVI;
  
  static
  {
    AppMethodBeat.i(282526);
    UiX = new s.a((byte)0);
    AppMethodBeat.o(282526);
  }
  
  public s(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282456);
    this.Lsb = paramFrameLayout;
    this.context = this.Lsb.getContext();
    this.UiY = new HashMap();
    this.Lsk = i.hdN;
    this.zVI = -1;
    AppMethodBeat.o(282456);
  }
  
  private static final boolean a(s params, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282479);
    kotlin.g.b.s.u(params, "this$0");
    kotlin.g.b.s.s(paramMotionEvent, "it");
    params.aj(paramMotionEvent);
    AppMethodBeat.o(282479);
    return false;
  }
  
  private final void aj(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282465);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(282465);
      return;
      this.mat = false;
      AppMethodBeat.o(282465);
      return;
      if (this.mat)
      {
        a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPb);
        AppMethodBeat.o(282465);
        return;
      }
      a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOZ);
      AppMethodBeat.o(282465);
      return;
      this.mat = true;
      a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPa);
    }
  }
  
  private static final boolean b(s params, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282487);
    kotlin.g.b.s.u(params, "this$0");
    kotlin.g.b.s.s(paramMotionEvent, "it");
    params.aj(paramMotionEvent);
    AppMethodBeat.o(282487);
    return false;
  }
  
  private static final void bX(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(282469);
    kotlin.g.b.s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(282469);
  }
  
  public final void apD(int paramInt)
  {
    AppMethodBeat.i(282592);
    this.Lsk = i.hdO;
    this.zVI = paramInt;
    Object localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdO);
      }
    }
    localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdO, paramInt, null);
      }
    }
    AppMethodBeat.o(282592);
  }
  
  public final void b(RecordConfigProvider paramRecordConfigProvider, com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(282560);
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    kotlin.g.b.s.u(paramb, "captureInfo");
    this.oaV = paramRecordConfigProvider;
    this.NKf = paramb;
    AppMethodBeat.o(282560);
  }
  
  public final void bI(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(282570);
    kotlin.g.b.s.u(parama, "r");
    this.Lsb.post(new s..ExternalSyntheticLambda2(parama));
    AppMethodBeat.o(282570);
  }
  
  public final m bfq(String paramString)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    AppMethodBeat.i(282590);
    kotlin.g.b.s.u(paramString, "path");
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "updatePhotoEdit path:" + paramString + ", photoLayout rect:[" + this.Lsb.getLeft() + ", " + this.Lsb.getTop() + ", " + this.Lsb.getRight() + ", " + this.Lsb.getBottom() + ']');
    this.Lsb.setVisibility(0);
    Object localObject3;
    if (this.UiY.get(paramString) == null)
    {
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", kotlin.g.b.s.X("put new photo editor:", paramString));
      localObject1 = ac.hdY.aAA();
      localObject3 = new ac.a.a();
      Object localObject4 = this.oaV;
      int i;
      if ((localObject4 != null) && (((RecordConfigProvider)localObject4).scene == 291))
      {
        i = 1;
        if (i != 0) {
          break label367;
        }
        localObject4 = this.oaV;
        if ((localObject4 == null) || (((RecordConfigProvider)localObject4).scene != 293)) {
          break label362;
        }
        i = 1;
        label214:
        if (i != 0) {
          break label367;
        }
      }
      label362:
      label367:
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject3 = ((ac.a.a)localObject3).dR(bool1).dQ(false).t(new Rect(this.Lsb.getLeft(), this.Lsb.getTop(), this.Lsb.getRight(), this.Lsb.getBottom())).a(ac.c.heg);
        localObject4 = this.NKf;
        bool1 = bool2;
        if (localObject4 != null)
        {
          bool1 = bool2;
          if (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).nJW == true) {
            bool1 = true;
          }
        }
        ((ac)localObject1).a(((ac.a.a)localObject3).dS(bool1).hX(paramString).hee);
        localObject3 = ((ac)localObject1).cn(this.context);
        if (localObject3 != null) {
          break label372;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(282590);
        throw paramString;
        i = 0;
        break;
        i = 0;
        break label214;
      }
      label372:
      localObject3 = (m)localObject3;
      localObject4 = (Map)this.UiY;
      kotlin.g.b.s.s(localObject1, "editor");
      ((Map)localObject4).put(paramString, new s.b((ac)localObject1, (m)localObject3));
    }
    Object localObject1 = (s.b)this.UiY.get(paramString);
    if (localObject1 == null)
    {
      localObject1 = null;
      this.LcI = ((ac)localObject1);
      localObject1 = (s.b)this.UiY.get(paramString);
      if (localObject1 != null) {
        break label640;
      }
      localObject1 = null;
      label464:
      this.NKg = ((m)localObject1);
      ArtistCacheManager.aLv().CK(paramString);
      com.tencent.mm.cache.c.aLA().CM(Util.nullAs(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
      localObject1 = this.oaV;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).oSS;
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject3 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject3);
            localObject3 = this.NKg;
            if (localObject3 != null)
            {
              localObject3 = ((m)localObject3).getBaseBoardView();
              if (localObject3 != null) {
                ((com.tencent.mm.view.b.a)localObject3).setForceMatrix((Matrix)localObject1);
              }
            }
          }
        }
      }
      localObject1 = this.NKg;
      if (localObject1 != null) {
        break label650;
      }
    }
    label640:
    label650:
    for (localObject1 = localObject2;; localObject1 = (com.tencent.mm.view.footer.c)((m)localObject1).getBaseFooterView())
    {
      if (localObject1 != null) {
        ((com.tencent.mm.view.footer.c)localObject1).setHideFooter(true);
      }
      localObject1 = this.NKg;
      if (localObject1 != null) {
        break label663;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
      AppMethodBeat.o(282590);
      throw paramString;
      localObject1 = ((s.b)localObject1).UiZ;
      break;
      localObject1 = ((s.b)localObject1).NKg;
      break label464;
    }
    label663:
    this.Lsg = ((m)localObject1).getPresenter();
    localObject1 = this.Lsg;
    if (localObject1 != null) {
      ((com.tencent.mm.bt.b)localObject1).iPm();
    }
    localObject1 = this.Lsg;
    if (localObject1 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
      AppMethodBeat.o(282590);
      throw paramString;
    }
    ((com.tencent.mm.bt.a)localObject1).YwB = ((com.tencent.mm.bt.a.c)new d(this));
    localObject1 = this.NKg;
    if (localObject1 != null) {
      ((m)localObject1).setSelectedFeatureListener((aa)new e(this));
    }
    localObject1 = this.Lsg;
    if (localObject1 != null)
    {
      localObject1 = (d)((com.tencent.mm.bt.b)localObject1).c(i.hdO);
      if (localObject1 != null) {
        ((d)localObject1).a(new s..ExternalSyntheticLambda0(this));
      }
    }
    localObject1 = this.Lsg;
    if (localObject1 != null)
    {
      localObject1 = (h)((com.tencent.mm.bt.b)localObject1).c(i.hdR);
      if (localObject1 != null) {
        ((h)localObject1).a(new s..ExternalSyntheticLambda1(this));
      }
    }
    paramString = BitmapUtil.getImageOptions(paramString);
    if (paramString != null)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(paramString.outWidth));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(paramString.outHeight));
    }
    paramString = this.NKg;
    kotlin.g.b.s.checkNotNull(paramString);
    AppMethodBeat.o(282590);
    return paramString;
  }
  
  public final void c(String paramString, final q<? super Boolean, ? super String, ? super Boolean, ah> paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(282629);
    kotlin.g.b.s.u(paramString, "sourcePath");
    kotlin.g.b.s.u(paramq, "callback");
    Object localObject1 = (s.b)this.UiY.get(paramString);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((s.b)localObject1).UiZ)
    {
      this.LcI = ((ac)localObject1);
      if (this.LcI != null) {
        break;
      }
      paramq.invoke(Boolean.TRUE, paramString, Boolean.FALSE);
      AppMethodBeat.o(282629);
      return;
    }
    ArtistCacheManager.aLv().CK(paramString);
    com.tencent.mm.cache.c.aLA().CM(Util.nullAs(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
    paramString = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    paramString = this.LcI;
    label157:
    label191:
    label225:
    int i;
    if (paramString == null)
    {
      paramString = null;
      kotlin.g.b.s.checkNotNull(paramString);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramString.aBy()));
      paramString = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      paramString = this.LcI;
      if (paramString != null) {
        break label473;
      }
      paramString = null;
      kotlin.g.b.s.checkNotNull(paramString);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramString.aBx()));
      paramString = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      paramString = this.LcI;
      if (paramString != null) {
        break label481;
      }
      paramString = null;
      kotlin.g.b.s.checkNotNull(paramString);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramString.aBA()));
      paramString = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      paramString = this.LcI;
      if (paramString != null) {
        break label489;
      }
      paramString = null;
      kotlin.g.b.s.checkNotNull(paramString);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramString.aBE()));
      paramString = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      paramString = this.LcI;
      if (paramString != null) {
        break label497;
      }
      paramString = null;
      label259:
      kotlin.g.b.s.checkNotNull(paramString);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramString.aBz()));
      paramString = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      paramString = this.LcI;
      if (paramString != null) {
        break label505;
      }
      paramString = null;
      label293:
      kotlin.g.b.s.checkNotNull(paramString);
      if (!paramString.aBD()) {
        break label513;
      }
      i = 1;
      label308:
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ROTATE_INT", Integer.valueOf(i));
      paramString = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      paramString = this.LcI;
      if (paramString != null) {
        break label518;
      }
    }
    label513:
    label518:
    for (paramString = localObject2;; paramString = paramString.aAy())
    {
      kotlin.g.b.s.checkNotNull(paramString);
      final boolean bool = paramString.aBF();
      paramString = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        paramString = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqX();
      }
      paramString = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bre();
      long l = Util.currentTicks();
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "dofinish time: " + l + ' ' + bool);
      paramString = this.LcI;
      if (paramString != null) {
        paramString.a((w)new c(l, this, paramq, bool));
      }
      AppMethodBeat.o(282629);
      return;
      paramString = paramString.aAy();
      break;
      label473:
      paramString = paramString.aAy();
      break label157;
      label481:
      paramString = paramString.aAy();
      break label191;
      label489:
      paramString = paramString.aAy();
      break label225;
      label497:
      paramString = paramString.aAy();
      break label259;
      label505:
      paramString = paramString.aAy();
      break label293;
      i = 0;
      break label308;
    }
  }
  
  public final void hTn()
  {
    AppMethodBeat.i(282599);
    Object localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(com.tencent.mm.cache.c.aLA().aLB(), -1, null);
      }
    }
    localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(this.Lsk);
      }
    }
    localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(this.Lsk, this.zVI, null);
      }
    }
    AppMethodBeat.o(282599);
  }
  
  public final void hTo()
  {
    AppMethodBeat.i(282610);
    this.Lsk = i.hdR;
    this.zVI = 0;
    Object localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdR);
      }
    }
    localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdR, 0, null);
      }
    }
    localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_MOSAIC_COUNT_INT");
    localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agG(8);
    AppMethodBeat.o(282610);
  }
  
  public final void hTp()
  {
    AppMethodBeat.i(282620);
    this.Lsk = i.hdR;
    this.zVI = 1;
    Object localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdR);
      }
    }
    localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdR, 1, null);
      }
    }
    localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_BRUSH_COUNT_INT");
    localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agG(9);
    AppMethodBeat.o(282620);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282661);
    if (this.Lsk == i.hdS)
    {
      this.Lsk = i.hdN;
      Object localObject = this.Lsg;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
        if (localObject != null) {
          ((aa)localObject).a(i.hdS, 1, null);
        }
      }
      AppMethodBeat.o(282661);
      return true;
    }
    AppMethodBeat.o(282661);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(282647);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    super.onDetach();
    Object localObject = this.UiY.values();
    kotlin.g.b.s.s(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s.b localb = (s.b)((Iterator)localObject).next();
      localb.UiZ.onDestroy();
      localb.NKg.getPresenter().onDestroy();
    }
    this.UiY.clear();
    AppMethodBeat.o(282647);
  }
  
  public final void release()
  {
    AppMethodBeat.i(282656);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.UiY.values();
    kotlin.g.b.s.s(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      s.b localb = (s.b)((Iterator)localObject).next();
      localb.UiZ.onDestroy();
      localb.NKg.getPresenter().onDestroy();
    }
    this.UiY.clear();
    this.Lsb.removeAllViews();
    this.Lsb.setVisibility(8);
    this.LcI = null;
    AppMethodBeat.o(282656);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282637);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "reset");
    this.Lsk = i.hdN;
    Object localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdN);
      }
    }
    localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdN, -1, null);
      }
    }
    AppMethodBeat.o(282637);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282666);
    this.Lsb.setVisibility(paramInt);
    AppMethodBeat.o(282666);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements w
  {
    c(long paramLong, s params, q<? super Boolean, ? super String, ? super Boolean, ah> paramq, boolean paramBoolean) {}
    
    public final void b(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(282650);
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + Util.ticksToNow(this.nvq));
      Object localObject1 = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.ia(Util.ticksToNow(this.nvq));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brd();
      }
      long l;
      Object localObject2;
      boolean bool;
      Object localObject3;
      if (paramBitmap != null)
      {
        l = this.nvq;
        localObject2 = paramq;
        bool = this.NKi;
        localObject1 = bool;
        localObject3 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject3 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        localObject3 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        localObject3 = kotlin.g.b.s.X(com.tencent.mm.plugin.recordvideo.util.f.gLi(), Integer.valueOf(paramBitmap.hashCode()));
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "saveBitmapToImage  cost:" + Util.ticksToNow(l) + "  path:" + (String)localObject3);
        s.a((s)localObject2);
        paramBitmap = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        paramBitmap = s.b((s)localObject2);
        localObject2 = s.c((s)localObject2);
        if (localObject2 != null) {
          break label318;
        }
      }
      label318:
      for (paramBoolean = false;; paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).nJW)
      {
        com.tencent.mm.plugin.recordvideo.util.f.b(paramBitmap, paramBoolean, bool);
        Log.d("MicroMsg.MultiPhotoEditContainerPlugin", kotlin.g.b.s.X("new ThreadPool  cost:", Long.valueOf(Util.ticksToNow(l))));
        ((q)localObject1).invoke(Boolean.TRUE, localObject3, Boolean.valueOf(bool));
        AppMethodBeat.o(282650);
        return;
      }
    }
    
    public final void f(Exception paramException)
    {
      AppMethodBeat.i(282634);
      kotlin.g.b.s.u(paramException, "e");
      Log.e("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brc();
      paramException = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.ia(Util.ticksToNow(this.nvq));
      s.a(paramq);
      bool.invoke(Boolean.FALSE, null, Boolean.valueOf(this.NKi));
      AppMethodBeat.o(282634);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.bt.a.c
  {
    d(s params) {}
    
    public final boolean b(com.tencent.mm.ab.f paramf)
    {
      AppMethodBeat.i(282633);
      kotlin.g.b.s.u(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.mAC);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.Uja.GrC.a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOw, localBundle);
      AppMethodBeat.o(282633);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements aa
  {
    e(s params) {}
    
    public final void a(i parami)
    {
      AppMethodBeat.i(282640);
      kotlin.g.b.s.u(parami, "features");
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { parami.name() });
      if (parami == i.hdN) {
        a.b.a(this.Uja.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPm);
      }
      AppMethodBeat.o(282640);
    }
    
    public final void a(i parami, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(282646);
      kotlin.g.b.s.u(parami, "features");
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { parami.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(282646);
    }
    
    public final void dP(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.s
 * JD-Core Version:    0.7.0.1
 */