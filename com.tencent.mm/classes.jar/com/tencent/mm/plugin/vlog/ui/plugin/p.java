package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.api.s;
import com.tencent.mm.api.u;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.bt.a.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.view.e;
import com.tencent.mm.z.f;
import d.g.a.q;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "editorViewDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "Lkotlin/collections/HashMap;", "isFinishing", "", "moved", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "sourcePath", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "ret", "path", "edited", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "onBackPress", "onDetach", "post", "r", "Lkotlin/Function0;", "release", "reset", "setDrawingPadding", "left", "top", "right", "bottom", "setVisibility", "visibility", "setup", "showEmojiPanel", "showTextPanel", "unDo", "updatePhotoEdit", "Companion", "PhotoEditorViewData", "plugin-vlog_release"})
public final class p
  implements t
{
  public static final p.a Cfg;
  public final HashMap<String, p.b> Cff;
  public final Context context;
  private boolean ghe;
  private boolean isFinishing;
  public int rss;
  public RecordConfigProvider sYT;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  public y whL;
  public com.tencent.mm.media.widget.camerarecordview.b.b xQs;
  public e xQt;
  public com.tencent.mm.bt.b xQu;
  public g xQv;
  public FrameLayout xQw;
  
  static
  {
    AppMethodBeat.i(191752);
    Cfg = new p.a((byte)0);
    AppMethodBeat.o(191752);
  }
  
  public p(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191751);
    this.xQw = paramFrameLayout;
    this.tbP = paramd;
    this.context = this.xQw.getContext();
    this.Cff = new HashMap();
    this.xQv = g.cSm;
    this.rss = -1;
    AppMethodBeat.o(191751);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(191749);
    if (this.xQv == g.cSr)
    {
      this.xQv = g.cSm;
      com.tencent.mm.bt.b localb = this.xQu;
      if (localb != null) {
        localb.getSelectedFeatureListener().a(g.cSr, 1, null);
      }
      AppMethodBeat.o(191749);
      return true;
    }
    AppMethodBeat.o(191749);
    return false;
  }
  
  public final void azm() {}
  
  public final void b(String paramString, q<? super Boolean, ? super String, ? super Boolean, z> paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(191745);
    d.g.b.p.h(paramString, "sourcePath");
    d.g.b.p.h(paramq, "callback");
    Object localObject1 = (p.b)this.Cff.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = ((p.b)localObject1).Cfh;; localObject1 = null)
    {
      this.whL = ((y)localObject1);
      if (this.whL != null) {
        break;
      }
      paramq.d(Boolean.TRUE, paramString, Boolean.FALSE);
      AppMethodBeat.o(191745);
      return;
    }
    ArtistCacheManager.XN().uX(paramString);
    com.tencent.mm.cache.c.XS().uZ(bu.bI(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
    paramString = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    paramString = this.whL;
    if (paramString != null)
    {
      paramString = paramString.Kd();
      if (paramString == null) {
        d.g.b.p.gkB();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramString.Ll()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      paramString = this.whL;
      if (paramString == null) {
        break label517;
      }
      paramString = paramString.Kd();
      label166:
      if (paramString == null) {
        d.g.b.p.gkB();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramString.Lk()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      paramString = this.whL;
      if (paramString == null) {
        break label522;
      }
      paramString = paramString.Kd();
      label206:
      if (paramString == null) {
        d.g.b.p.gkB();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramString.Ln()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      paramString = this.whL;
      if (paramString == null) {
        break label527;
      }
      paramString = paramString.Kd();
      label246:
      if (paramString == null) {
        d.g.b.p.gkB();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramString.Lq()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      paramString = this.whL;
      if (paramString == null) {
        break label532;
      }
      paramString = paramString.Kd();
      label286:
      if (paramString == null) {
        d.g.b.p.gkB();
      }
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramString.Lm()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      paramString = this.whL;
      if (paramString == null) {
        break label537;
      }
      paramString = paramString.Kd();
      label326:
      if (paramString == null) {
        d.g.b.p.gkB();
      }
      if (!paramString.Lp()) {
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
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = this.whL;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = ((y)localObject1).Kd();
      }
      if (paramString == null) {
        d.g.b.p.gkB();
      }
      final boolean bool = paramString.Lr();
      paramString = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        paramString = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auY();
      }
      paramString = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avf();
      final long l = bu.HQ();
      ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "dofinish time: " + l + ' ' + bool);
      paramString = this.whL;
      if (paramString == null) {
        break label547;
      }
      paramString.a((s)new c(this, l, paramq, bool));
      AppMethodBeat.o(191745);
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
    AppMethodBeat.o(191745);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(191747);
    ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.Cff.values();
    d.g.b.p.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      p.b localb = (p.b)((Iterator)localObject).next();
      localb.Cfh.onDestroy();
      localb.xQt.getPresenter().onDestroy();
    }
    this.Cff.clear();
    AppMethodBeat.o(191747);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191753);
    d.g.b.p.h(paramArrayOfString, "permissions");
    d.g.b.p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191753);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(191748);
    ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.Cff.values();
    d.g.b.p.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      p.b localb = (p.b)((Iterator)localObject).next();
      localb.Cfh.onDestroy();
      localb.xQt.getPresenter().onDestroy();
    }
    this.Cff.clear();
    this.xQw.removeAllViews();
    this.xQw.setVisibility(8);
    this.whL = null;
    AppMethodBeat.o(191748);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191746);
    ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "reset");
    this.xQv = g.cSm;
    com.tencent.mm.bt.b localb = this.xQu;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(g.cSm);
    }
    localb = this.xQu;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(g.cSm, -1, null);
      AppMethodBeat.o(191746);
      return;
    }
    AppMethodBeat.o(191746);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191750);
    this.xQw.setVisibility(paramInt);
    AppMethodBeat.o(191750);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-vlog_release"})
  public static final class c
    implements s
  {
    c(long paramLong, q paramq, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(191737);
      ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bu.aO(l));
      Object localObject1 = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.rF(bu.aO(l));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.ave();
      }
      if (paramBitmap != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        localObject1 = new StringBuilder();
        Object localObject2 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
        localObject1 = com.tencent.mm.plugin.recordvideo.e.b.dLM() + paramBitmap.hashCode();
        h.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
        ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "saveBitmapToImage  cost:" + bu.aO(l) + "  path:" + (String)localObject1);
        p.a(this.Cfi);
        paramBitmap = com.tencent.mm.plugin.recordvideo.e.b.yhe;
        paramBitmap = p.b(this.Cfi);
        localObject2 = p.c(this.Cfi);
        if (localObject2 != null) {}
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).hwD;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.b.b(paramBitmap, paramBoolean, this.xQz);
          ae.d("MicroMsg.MultiPhotoEditContainerPlugin", "new ThreadPool  cost:" + bu.aO(l));
          bool.d(Boolean.TRUE, localObject1, Boolean.valueOf(this.xQz));
          AppMethodBeat.o(191737);
          return;
        }
      }
      AppMethodBeat.o(191737);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(191736);
      d.g.b.p.h(paramException, "e");
      ae.e("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avd();
      paramException = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.rF(bu.aO(l));
      p.a(this.Cfi);
      bool.d(Boolean.FALSE, null, Boolean.valueOf(this.xQz));
      AppMethodBeat.o(191736);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-vlog_release"})
  public static final class d
    implements a.c
  {
    public final boolean b(f paramf)
    {
      AppMethodBeat.i(191739);
      d.g.b.p.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.gBT);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.Cfi.tbP.a(d.c.xUA, localBundle);
      AppMethodBeat.o(191739);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-vlog_release"})
  public static final class e
    implements w
  {
    public final void a(g paramg)
    {
      AppMethodBeat.i(191741);
      d.g.b.p.h(paramg, "features");
      ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { paramg.name() });
      if (paramg == g.cSm) {
        d.b.a(this.Cfi.tbP, d.c.xVk);
      }
      AppMethodBeat.o(191741);
    }
    
    public final void a(g paramg, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(191742);
      d.g.b.p.h(paramg, "features");
      ae.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(191742);
    }
    
    public final void bY(boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class f
    implements b.a
  {
    public f(p paramp) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(191743);
      p localp = this.Cfi;
      d.g.b.p.g(paramMotionEvent, "it");
      p.a(localp, paramMotionEvent);
      AppMethodBeat.o(191743);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class g
    implements b.a
  {
    public g(p paramp) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(191744);
      p localp = this.Cfi;
      d.g.b.p.g(paramMotionEvent, "it");
      p.a(localp, paramMotionEvent);
      AppMethodBeat.o(191744);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.p
 * JD-Core Version:    0.7.0.1
 */