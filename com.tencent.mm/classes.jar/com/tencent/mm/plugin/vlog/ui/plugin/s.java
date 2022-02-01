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
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.a.a;
import com.tencent.mm.api.ab.b;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "editorViewDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "Lkotlin/collections/HashMap;", "isFinishing", "", "moved", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "sourcePath", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "ret", "path", "edited", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "onBackPress", "onDetach", "post", "r", "Lkotlin/Function0;", "release", "reset", "setDrawingPadding", "left", "top", "right", "bottom", "setVisibility", "visibility", "setup", "showEmojiPanel", "showTextPanel", "unDo", "updatePhotoEdit", "Companion", "PhotoEditorViewData", "plugin-vlog_release"})
public final class s
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final a NvL;
  private RecordConfigProvider ALV;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  private ab Fhh;
  private com.tencent.mm.ca.b FvS;
  private com.tencent.mm.api.h FvW;
  private FrameLayout FvY;
  private com.tencent.mm.media.widget.camerarecordview.b.b HNh;
  private m HNi;
  private final HashMap<String, b> NvK;
  private final Context context;
  private boolean isFinishing;
  private boolean jwZ;
  private int wzx;
  
  static
  {
    AppMethodBeat.i(231196);
    NvL = new a((byte)0);
    AppMethodBeat.o(231196);
  }
  
  public s(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(231195);
    this.FvY = paramFrameLayout;
    this.APl = paramd;
    this.context = this.FvY.getContext();
    this.NvK = new HashMap();
    this.FvW = com.tencent.mm.api.h.fam;
    this.wzx = -1;
    AppMethodBeat.o(231195);
  }
  
  private final boolean gvA()
  {
    RecordConfigProvider localRecordConfigProvider = this.ALV;
    if ((localRecordConfigProvider == null) || (localRecordConfigProvider.scene != 291))
    {
      localRecordConfigProvider = this.ALV;
      if ((localRecordConfigProvider == null) || (localRecordConfigProvider.scene != 293)) {
        return true;
      }
    }
    return false;
  }
  
  public final void X(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(231177);
    p.k(parama, "r");
    this.FvY.post((Runnable)new t(parama));
    AppMethodBeat.o(231177);
  }
  
  public final void akk(int paramInt)
  {
    AppMethodBeat.i(231181);
    this.FvW = com.tencent.mm.api.h.fan;
    this.wzx = paramInt;
    com.tencent.mm.ca.b localb = this.FvS;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.fan);
    }
    localb = this.FvS;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.fan, paramInt, null);
      AppMethodBeat.o(231181);
      return;
    }
    AppMethodBeat.o(231181);
  }
  
  public final void b(RecordConfigProvider paramRecordConfigProvider, com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(231176);
    p.k(paramRecordConfigProvider, "configProvider");
    p.k(paramb, "captureInfo");
    this.ALV = paramRecordConfigProvider;
    this.HNh = paramb;
    AppMethodBeat.o(231176);
  }
  
  public final m bfK(String paramString)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    AppMethodBeat.i(231179);
    p.k(paramString, "path");
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "updatePhotoEdit path:" + paramString + ", photoLayout rect:[" + this.FvY.getLeft() + ", " + this.FvY.getTop() + ", " + this.FvY.getRight() + ", " + this.FvY.getBottom() + ']');
    this.FvY.setVisibility(0);
    Object localObject3;
    if (this.NvK.get(paramString) == null)
    {
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "put new photo editor:".concat(String.valueOf(paramString)));
      localObject1 = ab.fax.YG();
      localObject3 = new ab.a.a().df(gvA()).aac().o(new Rect(this.FvY.getLeft(), this.FvY.getTop(), this.FvY.getRight(), this.FvY.getBottom())).a(ab.c.faG);
      Object localObject4 = this.HNh;
      boolean bool1 = bool2;
      if (localObject4 != null)
      {
        bool1 = bool2;
        if (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).lfl == true) {
          bool1 = true;
        }
      }
      ((ab)localObject1).a(((ab.a.a)localObject3).dg(bool1).gx(paramString).aae());
      localObject3 = ((ab)localObject1).bA(this.context);
      if (localObject3 == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(231179);
        throw paramString;
      }
      localObject3 = (m)localObject3;
      localObject4 = (Map)this.NvK;
      p.j(localObject1, "editor");
      ((Map)localObject4).put(paramString, new b((ab)localObject1, (m)localObject3));
    }
    Object localObject1 = (b)this.NvK.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = ((b)localObject1).NvM;; localObject1 = null)
    {
      this.Fhh = ((ab)localObject1);
      localObject3 = (b)this.NvK.get(paramString);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((b)localObject3).HNi;
      }
      this.HNi = ((m)localObject1);
      ArtistCacheManager.arz().Ke(paramString);
      com.tencent.mm.cache.c.arE().Kg(Util.nullAs(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
      localObject1 = this.ALV;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).mab;
        if (localObject1 != null)
        {
          localObject2 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject2 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject2);
            localObject2 = this.HNi;
            if (localObject2 != null)
            {
              localObject2 = ((m)localObject2).getBaseBoardView();
              if (localObject2 != null) {
                ((com.tencent.mm.view.b.a)localObject2).setForceMatrix((Matrix)localObject1);
              }
            }
          }
        }
      }
      localObject1 = this.HNi;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.footer.c)((m)localObject1).getBaseFooterView();
        if (localObject1 != null) {
          ((com.tencent.mm.view.footer.c)localObject1).setHideFooter(true);
        }
      }
      localObject1 = this.HNi;
      if (localObject1 != null) {
        break;
      }
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
      AppMethodBeat.o(231179);
      throw paramString;
    }
    this.FvS = ((m)localObject1).getPresenter();
    localObject1 = this.FvS;
    if (localObject1 != null) {
      ((com.tencent.mm.ca.b)localObject1).hos();
    }
    localObject1 = this.FvS;
    if (localObject1 == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
      AppMethodBeat.o(231179);
      throw paramString;
    }
    ((com.tencent.mm.ca.a)localObject1).RAb = ((a.c)new d(this));
    localObject1 = this.HNi;
    if (localObject1 != null) {
      ((m)localObject1).setSelectedFeatureListener((z)new e(this));
    }
    localObject1 = this.FvS;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.ca.b)localObject1).c(com.tencent.mm.api.h.fan);
      if (localObject1 != null) {
        ((com.tencent.mm.e.d)localObject1).a((b.a)new f(this));
      }
    }
    localObject1 = this.FvS;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.e.h)((com.tencent.mm.ca.b)localObject1).c(com.tencent.mm.api.h.faq);
      if (localObject1 != null) {
        ((com.tencent.mm.e.h)localObject1).a((b.a)new g(this));
      }
    }
    paramString = BitmapUtil.getImageOptions(paramString);
    if (paramString != null)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(paramString.outWidth));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(paramString.outHeight));
    }
    paramString = this.HNi;
    if (paramString == null) {
      p.iCn();
    }
    AppMethodBeat.o(231179);
    return paramString;
  }
  
  public final void c(String paramString, q<? super Boolean, ? super String, ? super Boolean, kotlin.x> paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(231187);
    p.k(paramString, "sourcePath");
    p.k(paramq, "callback");
    Object localObject1 = (b)this.NvK.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = ((b)localObject1).NvM;; localObject1 = null)
    {
      this.Fhh = ((ab)localObject1);
      if (this.Fhh != null) {
        break;
      }
      paramq.c(Boolean.TRUE, paramString, Boolean.FALSE);
      AppMethodBeat.o(231187);
      return;
    }
    ArtistCacheManager.arz().Ke(paramString);
    com.tencent.mm.cache.c.arE().Kg(Util.nullAs(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
    paramString = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    paramString = this.Fhh;
    if (paramString != null)
    {
      paramString = paramString.YE();
      if (paramString == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramString.ZT()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      paramString = this.Fhh;
      if (paramString == null) {
        break label517;
      }
      paramString = paramString.YE();
      label166:
      if (paramString == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramString.ZS()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      paramString = this.Fhh;
      if (paramString == null) {
        break label522;
      }
      paramString = paramString.YE();
      label206:
      if (paramString == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramString.ZV()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      paramString = this.Fhh;
      if (paramString == null) {
        break label527;
      }
      paramString = paramString.YE();
      label246:
      if (paramString == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramString.ZY()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      paramString = this.Fhh;
      if (paramString == null) {
        break label532;
      }
      paramString = paramString.YE();
      label286:
      if (paramString == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramString.ZU()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      paramString = this.Fhh;
      if (paramString == null) {
        break label537;
      }
      paramString = paramString.YE();
      label326:
      if (paramString == null) {
        p.iCn();
      }
      if (!paramString.ZX()) {
        break label542;
      }
    }
    label517:
    label522:
    label527:
    label532:
    label537:
    label542:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_ROTATE_INT", Integer.valueOf(i));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = this.Fhh;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = ((ab)localObject1).YE();
      }
      if (paramString == null) {
        p.iCn();
      }
      final boolean bool = paramString.ZZ();
      paramString = com.tencent.mm.plugin.recordvideo.d.c.HUw;
      com.tencent.mm.plugin.recordvideo.d.c.w("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        paramString = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWp();
      }
      paramString = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWw();
      final long l = Util.currentTicks();
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "dofinish time: " + l + ' ' + bool);
      paramString = this.Fhh;
      if (paramString == null) {
        break label547;
      }
      paramString.a((u)new c(this, l, paramq, bool));
      AppMethodBeat.o(231187);
      return;
      paramString = null;
      break;
      paramString = null;
      break label166;
      paramString = null;
      break label206;
      paramString = null;
      break label246;
      paramString = null;
      break label286;
      paramString = null;
      break label326;
    }
    label547:
    AppMethodBeat.o(231187);
  }
  
  public final void gvx()
  {
    AppMethodBeat.i(231183);
    com.tencent.mm.ca.b localb = this.FvS;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.cache.c.arE().arF(), -1, null);
    }
    localb = this.FvS;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(this.FvW);
    }
    localb = this.FvS;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(this.FvW, this.wzx, null);
      AppMethodBeat.o(231183);
      return;
    }
    AppMethodBeat.o(231183);
  }
  
  public final void gvy()
  {
    AppMethodBeat.i(231185);
    this.FvW = com.tencent.mm.api.h.faq;
    this.wzx = 0;
    Object localObject = this.FvS;
    if (localObject != null) {
      ((com.tencent.mm.ca.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.faq);
    }
    localObject = this.FvS;
    if (localObject != null) {
      ((com.tencent.mm.ca.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.faq, 0, null);
    }
    localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.aVY("KEY_CLICK_MOSAIC_COUNT_INT");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.acq(8);
    AppMethodBeat.o(231185);
  }
  
  public final void gvz()
  {
    AppMethodBeat.i(231186);
    this.FvW = com.tencent.mm.api.h.faq;
    this.wzx = 1;
    Object localObject = this.FvS;
    if (localObject != null) {
      ((com.tencent.mm.ca.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.faq);
    }
    localObject = this.FvS;
    if (localObject != null) {
      ((com.tencent.mm.ca.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.faq, 1, null);
    }
    localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.aVY("KEY_CLICK_BRUSH_COUNT_INT");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.acq(9);
    AppMethodBeat.o(231186);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(231192);
    if (this.FvW == com.tencent.mm.api.h.far)
    {
      this.FvW = com.tencent.mm.api.h.fam;
      com.tencent.mm.ca.b localb = this.FvS;
      if (localb != null) {
        localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.far, 1, null);
      }
      AppMethodBeat.o(231192);
      return true;
    }
    AppMethodBeat.o(231192);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(231189);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    super.onDetach();
    Object localObject = this.NvK.values();
    p.j(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      localb.NvM.onDestroy();
      localb.HNi.getPresenter().onDestroy();
    }
    this.NvK.clear();
    AppMethodBeat.o(231189);
  }
  
  public final void release()
  {
    AppMethodBeat.i(231190);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.NvK.values();
    p.j(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      localb.NvM.onDestroy();
      localb.HNi.getPresenter().onDestroy();
    }
    this.NvK.clear();
    this.FvY.removeAllViews();
    this.FvY.setVisibility(8);
    this.Fhh = null;
    AppMethodBeat.o(231190);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(231188);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "reset");
    this.FvW = com.tencent.mm.api.h.fam;
    com.tencent.mm.ca.b localb = this.FvS;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.fam);
    }
    localb = this.FvS;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.fam, -1, null);
      AppMethodBeat.o(231188);
      return;
    }
    AppMethodBeat.o(231188);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(231194);
    this.FvY.setVisibility(paramInt);
    AppMethodBeat.o(231194);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "", "editor", "Lcom/tencent/mm/api/MMPhotoEditor;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "(Lcom/tencent/mm/api/MMPhotoEditor;Lcom/tencent/mm/view/PhotoDrawingView;)V", "getDrawingView", "()Lcom/tencent/mm/view/PhotoDrawingView;", "getEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"})
  static final class b
  {
    final m HNi;
    final ab NvM;
    
    public b(ab paramab, m paramm)
    {
      AppMethodBeat.i(224676);
      this.NvM = paramab;
      this.HNi = paramm;
      AppMethodBeat.o(224676);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(224679);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.NvM, paramObject.NvM)) || (!p.h(this.HNi, paramObject.HNi))) {}
        }
      }
      else
      {
        AppMethodBeat.o(224679);
        return true;
      }
      AppMethodBeat.o(224679);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(224678);
      Object localObject = this.NvM;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.HNi;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(224678);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(224677);
      String str = "PhotoEditorViewData(editor=" + this.NvM + ", drawingView=" + this.HNi + ")";
      AppMethodBeat.o(224677);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-vlog_release"})
  public static final class c
    implements u
  {
    c(long paramLong, q paramq, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(228665);
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + Util.ticksToNow(l));
      Object localObject1 = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.FS(Util.ticksToNow(l));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWv();
      }
      if (paramBitmap != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.HUw;
        com.tencent.mm.plugin.recordvideo.d.c.w("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        localObject1 = new StringBuilder();
        Object localObject2 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        localObject1 = com.tencent.mm.plugin.recordvideo.e.d.fzw() + paramBitmap.hashCode();
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "saveBitmapToImage  cost:" + Util.ticksToNow(l) + "  path:" + (String)localObject1);
        s.a(this.NvN);
        paramBitmap = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        paramBitmap = s.b(this.NvN);
        localObject2 = s.c(this.NvN);
        if (localObject2 != null) {}
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfl;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.d.b(paramBitmap, paramBoolean, this.HNl);
          Log.d("MicroMsg.MultiPhotoEditContainerPlugin", "new ThreadPool  cost:" + Util.ticksToNow(l));
          bool.c(Boolean.TRUE, localObject1, Boolean.valueOf(this.HNl));
          AppMethodBeat.o(228665);
          return;
        }
      }
      AppMethodBeat.o(228665);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(228650);
      p.k(paramException, "e");
      Log.e("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWu();
      paramException = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.FS(Util.ticksToNow(l));
      s.a(this.NvN);
      bool.c(Boolean.FALSE, null, Boolean.valueOf(this.HNl));
      AppMethodBeat.o(228650);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-vlog_release"})
  public static final class d
    implements a.c
  {
    public final boolean b(com.tencent.mm.ab.f paramf)
    {
      AppMethodBeat.i(231829);
      p.k(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.kaz);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.NvN.APl.a(d.c.HRQ, localBundle);
      AppMethodBeat.o(231829);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-vlog_release"})
  public static final class e
    implements z
  {
    public final void a(com.tencent.mm.api.h paramh)
    {
      AppMethodBeat.i(233453);
      p.k(paramh, "features");
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { paramh.name() });
      if (paramh == com.tencent.mm.api.h.fam) {
        d.b.a(this.NvN.APl, d.c.HSG);
      }
      AppMethodBeat.o(233453);
    }
    
    public final void a(com.tencent.mm.api.h paramh, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(233455);
      p.k(paramh, "features");
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramh.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(233455);
    }
    
    public final void dd(boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class f
    implements b.a
  {
    f(s params) {}
    
    public final boolean q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(227860);
      s locals = this.NvN;
      p.j(paramMotionEvent, "it");
      s.a(locals, paramMotionEvent);
      AppMethodBeat.o(227860);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class g
    implements b.a
  {
    g(s params) {}
    
    public final boolean q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(231461);
      s locals = this.NvN;
      p.j(paramMotionEvent, "it");
      s.a(locals, paramMotionEvent);
      AppMethodBeat.o(231461);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.s
 * JD-Core Version:    0.7.0.1
 */