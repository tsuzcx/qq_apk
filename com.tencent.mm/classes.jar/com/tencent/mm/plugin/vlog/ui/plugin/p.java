package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.f;
import com.tencent.mm.api.s;
import com.tencent.mm.api.u;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.bu.a.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.e;
import d.g.a.q;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "editorViewDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "Lkotlin/collections/HashMap;", "isFinishing", "", "moved", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "sourcePath", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "ret", "path", "edited", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "onBackPress", "onDetach", "post", "r", "Lkotlin/Function0;", "release", "reset", "setDrawingPadding", "left", "top", "right", "bottom", "setVisibility", "visibility", "setup", "showEmojiPanel", "showTextPanel", "unDo", "updatePhotoEdit", "Companion", "PhotoEditorViewData", "plugin-vlog_release"})
public final class p
  implements t
{
  public static final p.a BNH;
  public final HashMap<String, p.b> BNG;
  public final Context context;
  private boolean isFinishing;
  public int rko;
  public RecordConfigProvider sNI;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  public y vVH;
  public com.tencent.mm.api.g xAA;
  public FrameLayout xAB;
  public com.tencent.mm.media.widget.camerarecordview.b.b xAw;
  public e xAx;
  public com.tencent.mm.bu.b xAy;
  private boolean xAz;
  
  static
  {
    AppMethodBeat.i(196293);
    BNH = new p.a((byte)0);
    AppMethodBeat.o(196293);
  }
  
  public p(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(196292);
    this.xAB = paramFrameLayout;
    this.sQE = paramd;
    this.context = this.xAB.getContext();
    this.BNG = new HashMap();
    this.xAA = com.tencent.mm.api.g.cRC;
    this.rko = -1;
    AppMethodBeat.o(196292);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(196290);
    if (this.xAA == com.tencent.mm.api.g.cRH)
    {
      this.xAA = com.tencent.mm.api.g.cRC;
      com.tencent.mm.bu.b localb = this.xAy;
      if (localb != null) {
        localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRH, 1, null);
      }
      AppMethodBeat.o(196290);
      return true;
    }
    AppMethodBeat.o(196290);
    return false;
  }
  
  public final void ayX() {}
  
  public final void c(String paramString, q<? super Boolean, ? super String, ? super Boolean, z> paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(196286);
    d.g.b.p.h(paramString, "sourcePath");
    d.g.b.p.h(paramq, "callback");
    Object localObject1 = (p.b)this.BNG.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = ((p.b)localObject1).BNI;; localObject1 = null)
    {
      this.vVH = ((y)localObject1);
      if (this.vVH != null) {
        break;
      }
      paramq.d(Boolean.TRUE, paramString, Boolean.FALSE);
      AppMethodBeat.o(196286);
      return;
    }
    ArtistCacheManager.XD().uC(paramString);
    com.tencent.mm.cache.c.XI().uE(bt.bI(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
    paramString = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    paramString = this.vVH;
    if (paramString != null)
    {
      paramString = paramString.JV();
      if (paramString == null) {
        d.g.b.p.gfZ();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramString.Ld()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      paramString = this.vVH;
      if (paramString == null) {
        break label517;
      }
      paramString = paramString.JV();
      label166:
      if (paramString == null) {
        d.g.b.p.gfZ();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramString.Lc()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      paramString = this.vVH;
      if (paramString == null) {
        break label522;
      }
      paramString = paramString.JV();
      label206:
      if (paramString == null) {
        d.g.b.p.gfZ();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramString.Lf()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      paramString = this.vVH;
      if (paramString == null) {
        break label527;
      }
      paramString = paramString.JV();
      label246:
      if (paramString == null) {
        d.g.b.p.gfZ();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramString.Li()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      paramString = this.vVH;
      if (paramString == null) {
        break label532;
      }
      paramString = paramString.JV();
      label286:
      if (paramString == null) {
        d.g.b.p.gfZ();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramString.Le()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      paramString = this.vVH;
      if (paramString == null) {
        break label537;
      }
      paramString = paramString.JV();
      label326:
      if (paramString == null) {
        d.g.b.p.gfZ();
      }
      if (!paramString.Lh()) {
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
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ROTATE_INT", Integer.valueOf(i));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = this.vVH;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = ((y)localObject1).JV();
      }
      if (paramString == null) {
        d.g.b.p.gfZ();
      }
      final boolean bool = paramString.Lj();
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        paramString = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auJ();
      }
      paramString = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auQ();
      final long l = bt.HI();
      ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "dofinish time: " + l + ' ' + bool);
      paramString = this.vVH;
      if (paramString == null) {
        break label547;
      }
      paramString.a((s)new c(this, l, paramq, bool));
      AppMethodBeat.o(196286);
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
    AppMethodBeat.o(196286);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(196288);
    ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.BNG.values();
    d.g.b.p.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      p.b localb = (p.b)((Iterator)localObject).next();
      localb.BNI.onDestroy();
      localb.xAx.getPresenter().onDestroy();
    }
    this.BNG.clear();
    AppMethodBeat.o(196288);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196294);
    d.g.b.p.h(paramArrayOfString, "permissions");
    d.g.b.p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196294);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(196289);
    ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.BNG.values();
    d.g.b.p.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      p.b localb = (p.b)((Iterator)localObject).next();
      localb.BNI.onDestroy();
      localb.xAx.getPresenter().onDestroy();
    }
    this.BNG.clear();
    this.xAB.removeAllViews();
    this.xAB.setVisibility(8);
    this.vVH = null;
    AppMethodBeat.o(196289);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(196287);
    ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "reset");
    this.xAA = com.tencent.mm.api.g.cRC;
    com.tencent.mm.bu.b localb = this.xAy;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRC);
    }
    localb = this.xAy;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRC, -1, null);
      AppMethodBeat.o(196287);
      return;
    }
    AppMethodBeat.o(196287);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196291);
    this.xAB.setVisibility(paramInt);
    AppMethodBeat.o(196291);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-vlog_release"})
  public static final class c
    implements s
  {
    c(long paramLong, q paramq, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(196278);
      ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bt.aO(l));
      Object localObject1 = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.rs(bt.aO(l));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auP();
      }
      if (paramBitmap != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        localObject1 = new StringBuilder();
        Object localObject2 = com.tencent.mm.plugin.recordvideo.e.b.xRl;
        localObject1 = com.tencent.mm.plugin.recordvideo.e.b.dIv() + paramBitmap.hashCode();
        com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
        ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "saveBitmapToImage  cost:" + bt.aO(l) + "  path:" + (String)localObject1);
        p.a(this.BNJ);
        paramBitmap = com.tencent.mm.plugin.recordvideo.e.b.xRl;
        paramBitmap = p.b(this.BNJ);
        localObject2 = p.c(this.BNJ);
        if (localObject2 != null) {}
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).htP;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.b.b(paramBitmap, paramBoolean, this.xAE);
          ad.d("MicroMsg.MultiPhotoEditContainerPlugin", "new ThreadPool  cost:" + bt.aO(l));
          bool.d(Boolean.TRUE, localObject1, Boolean.valueOf(this.xAE));
          AppMethodBeat.o(196278);
          return;
        }
      }
      AppMethodBeat.o(196278);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(196277);
      d.g.b.p.h(paramException, "e");
      ad.e("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auO();
      paramException = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.rs(bt.aO(l));
      p.a(this.BNJ);
      bool.d(Boolean.FALSE, null, Boolean.valueOf(this.xAE));
      AppMethodBeat.o(196277);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-vlog_release"})
  public static final class d
    implements a.c
  {
    public final boolean b(f paramf)
    {
      AppMethodBeat.i(196280);
      d.g.b.p.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.gzm);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.BNJ.sQE.a(d.c.xEF, localBundle);
      AppMethodBeat.o(196280);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-vlog_release"})
  public static final class e
    implements w
  {
    public final void a(com.tencent.mm.api.g paramg)
    {
      AppMethodBeat.i(196282);
      d.g.b.p.h(paramg, "features");
      ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { paramg.name() });
      if (paramg == com.tencent.mm.api.g.cRC) {
        d.b.a(this.BNJ.sQE, d.c.xFp);
      }
      AppMethodBeat.o(196282);
    }
    
    public final void a(com.tencent.mm.api.g paramg, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(196283);
      d.g.b.p.h(paramg, "features");
      ad.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(196283);
    }
    
    public final void bY(boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class f
    implements b.a
  {
    public f(p paramp) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(196284);
      p localp = this.BNJ;
      d.g.b.p.g(paramMotionEvent, "it");
      p.a(localp, paramMotionEvent);
      AppMethodBeat.o(196284);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class g
    implements b.a
  {
    public g(p paramp) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(196285);
      p localp = this.BNJ;
      d.g.b.p.g(paramMotionEvent, "it");
      p.a(localp, paramMotionEvent);
      AppMethodBeat.o(196285);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.p
 * JD-Core Version:    0.7.0.1
 */