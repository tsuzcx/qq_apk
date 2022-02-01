package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.api.z;
import com.tencent.mm.bt.a.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.b.a;
import com.tencent.mm.media.k.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.m;
import com.tencent.mm.z.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "editorViewDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "Lkotlin/collections/HashMap;", "isFinishing", "", "moved", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "sourcePath", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "ret", "path", "edited", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "onBackPress", "onDetach", "post", "r", "Lkotlin/Function0;", "release", "reset", "setDrawingPadding", "left", "top", "right", "bottom", "setVisibility", "visibility", "setup", "showEmojiPanel", "showTextPanel", "unDo", "updatePhotoEdit", "Companion", "PhotoEditorViewData", "plugin-vlog_release"})
public final class t
  implements com.tencent.mm.plugin.recordvideo.plugin.t
{
  public static final t.a GHX;
  private com.tencent.mm.media.widget.camerarecordview.b.b BQt;
  private m BQu;
  private final HashMap<String, b> GHW;
  private final Context context;
  private boolean gMK;
  private boolean isFinishing;
  private int sTB;
  private RecordConfigProvider wdm;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  private ab zCl;
  private com.tencent.mm.bt.b zQp;
  private com.tencent.mm.api.h zQt;
  private FrameLayout zQv;
  
  static
  {
    AppMethodBeat.i(191416);
    GHX = new t.a((byte)0);
    AppMethodBeat.o(191416);
  }
  
  public t(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191415);
    this.zQv = paramFrameLayout;
    this.wgr = paramd;
    this.context = this.zQv.getContext();
    this.GHW = new HashMap();
    this.zQt = com.tencent.mm.api.h.diG;
    this.sTB = -1;
    AppMethodBeat.o(191415);
  }
  
  private final boolean fDC()
  {
    RecordConfigProvider localRecordConfigProvider = this.wdm;
    if ((localRecordConfigProvider == null) || (localRecordConfigProvider.scene != 291))
    {
      localRecordConfigProvider = this.wdm;
      if ((localRecordConfigProvider == null) || (localRecordConfigProvider.scene != 293)) {
        return true;
      }
    }
    return false;
  }
  
  public final void U(kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(191403);
    p.h(parama, "r");
    this.zQv.post((Runnable)new u(parama));
    AppMethodBeat.o(191403);
  }
  
  public final void aSs() {}
  
  public final m aUl(String paramString)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    AppMethodBeat.i(191404);
    p.h(paramString, "path");
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "updatePhotoEdit path:" + paramString + ", photoLayout rect:[" + this.zQv.getLeft() + ", " + this.zQv.getTop() + ", " + this.zQv.getRight() + ", " + this.zQv.getBottom() + ']');
    this.zQv.setVisibility(0);
    Object localObject3;
    if (this.GHW.get(paramString) == null)
    {
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "put new photo editor:".concat(String.valueOf(paramString)));
      localObject1 = ab.diQ.Uo();
      localObject3 = new ab.a.a().cJ(fDC()).VH().j(new Rect(this.zQv.getLeft(), this.zQv.getTop(), this.zQv.getRight(), this.zQv.getBottom())).a(ab.c.diZ);
      Object localObject4 = this.BQt;
      boolean bool1 = bool2;
      if (localObject4 != null)
      {
        bool1 = bool2;
        if (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject4).iqf == true) {
          bool1 = true;
        }
      }
      ((ab)localObject1).a(((ab.a.a)localObject3).cK(bool1).fN(paramString).VJ());
      localObject3 = ((ab)localObject1).bB(this.context);
      if (localObject3 == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
        AppMethodBeat.o(191404);
        throw paramString;
      }
      localObject3 = (m)localObject3;
      localObject4 = (Map)this.GHW;
      p.g(localObject1, "editor");
      ((Map)localObject4).put(paramString, new b((ab)localObject1, (m)localObject3));
    }
    Object localObject1 = (b)this.GHW.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = ((b)localObject1).GHY;; localObject1 = null)
    {
      this.zCl = ((ab)localObject1);
      localObject3 = (b)this.GHW.get(paramString);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((b)localObject3).BQu;
      }
      this.BQu = ((m)localObject1);
      ArtistCacheManager.alA().Dn(paramString);
      com.tencent.mm.cache.c.alF().Dp(Util.nullAs(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
      localObject1 = this.wdm;
      if (localObject1 != null)
      {
        localObject1 = ((RecordConfigProvider)localObject1).jkf;
        if (localObject1 != null)
        {
          localObject2 = ((Bundle)localObject1).getFloatArray("matrix");
          if (localObject2 != null)
          {
            localObject1 = new Matrix();
            ((Matrix)localObject1).setValues((float[])localObject2);
            localObject2 = this.BQu;
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
      localObject1 = this.BQu;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.view.footer.c)((m)localObject1).getBaseFooterView();
        if (localObject1 != null) {
          ((com.tencent.mm.view.footer.c)localObject1).setHideFooter(true);
        }
      }
      localObject1 = this.BQu;
      if (localObject1 != null) {
        break;
      }
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
      AppMethodBeat.o(191404);
      throw paramString;
    }
    this.zQp = ((m)localObject1).getPresenter();
    localObject1 = this.zQp;
    if (localObject1 != null) {
      ((com.tencent.mm.bt.b)localObject1).gtf();
    }
    localObject1 = this.zQp;
    if (localObject1 == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
      AppMethodBeat.o(191404);
      throw paramString;
    }
    ((com.tencent.mm.bt.a)localObject1).Kyn = ((a.c)new d(this));
    localObject1 = this.BQu;
    if (localObject1 != null) {
      ((m)localObject1).setSelectedFeatureListener((z)new e(this));
    }
    localObject1 = this.zQp;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.bt.b)localObject1).c(com.tencent.mm.api.h.diH);
      if (localObject1 != null) {
        ((com.tencent.mm.e.d)localObject1).a((b.a)new f(this));
      }
    }
    localObject1 = this.zQp;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.e.h)((com.tencent.mm.bt.b)localObject1).c(com.tencent.mm.api.h.diK);
      if (localObject1 != null) {
        ((com.tencent.mm.e.h)localObject1).a((b.a)new g(this));
      }
    }
    paramString = BitmapUtil.getImageOptions(paramString);
    if (paramString != null)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(paramString.outWidth));
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(paramString.outHeight));
    }
    paramString = this.BQu;
    if (paramString == null) {
      p.hyc();
    }
    AppMethodBeat.o(191404);
    return paramString;
  }
  
  public final void acD(int paramInt)
  {
    AppMethodBeat.i(191405);
    this.zQt = com.tencent.mm.api.h.diH;
    this.sTB = paramInt;
    com.tencent.mm.bt.b localb = this.zQp;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.diH);
    }
    localb = this.zQp;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.diH, paramInt, null);
      AppMethodBeat.o(191405);
      return;
    }
    AppMethodBeat.o(191405);
  }
  
  public final void b(RecordConfigProvider paramRecordConfigProvider, com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(191402);
    p.h(paramRecordConfigProvider, "configProvider");
    p.h(paramb, "captureInfo");
    this.wdm = paramRecordConfigProvider;
    this.BQt = paramb;
    AppMethodBeat.o(191402);
  }
  
  public final void c(String paramString, q<? super Boolean, ? super String, ? super Boolean, kotlin.x> paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(191409);
    p.h(paramString, "sourcePath");
    p.h(paramq, "callback");
    Object localObject1 = (b)this.GHW.get(paramString);
    if (localObject1 != null) {}
    for (localObject1 = ((b)localObject1).GHY;; localObject1 = null)
    {
      this.zCl = ((ab)localObject1);
      if (this.zCl != null) {
        break;
      }
      paramq.d(Boolean.TRUE, paramString, Boolean.FALSE);
      AppMethodBeat.o(191409);
      return;
    }
    ArtistCacheManager.alA().Dn(paramString);
    com.tencent.mm.cache.c.alF().Dp(Util.nullAs(paramString, "MicroMsg.MultiPhotoEditContainerPlugin"));
    paramString = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    paramString = this.zCl;
    if (paramString != null)
    {
      paramString = paramString.Um();
      if (paramString == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramString.Vy()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      paramString = this.zCl;
      if (paramString == null) {
        break label517;
      }
      paramString = paramString.Um();
      label166:
      if (paramString == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramString.Vx()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      paramString = this.zCl;
      if (paramString == null) {
        break label522;
      }
      paramString = paramString.Um();
      label206:
      if (paramString == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramString.VA()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      paramString = this.zCl;
      if (paramString == null) {
        break label527;
      }
      paramString = paramString.Um();
      label246:
      if (paramString == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramString.VD()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      paramString = this.zCl;
      if (paramString == null) {
        break label532;
      }
      paramString = paramString.Um();
      label286:
      if (paramString == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramString.Vz()));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      paramString = this.zCl;
      if (paramString == null) {
        break label537;
      }
      paramString = paramString.Um();
      label326:
      if (paramString == null) {
        p.hyc();
      }
      if (!paramString.VC()) {
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
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ROTATE_INT", Integer.valueOf(i));
      paramString = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = this.zCl;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = ((ab)localObject1).Um();
      }
      if (paramString == null) {
        p.hyc();
      }
      final boolean bool = paramString.VE();
      paramString = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        paramString = e.ilC;
        e.aNL();
      }
      paramString = e.ilC;
      e.aNS();
      final long l = Util.currentTicks();
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "dofinish time: " + l + ' ' + bool);
      paramString = this.zCl;
      if (paramString == null) {
        break label547;
      }
      paramString.a((com.tencent.mm.api.u)new c(this, l, paramq, bool));
      AppMethodBeat.o(191409);
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
    AppMethodBeat.o(191409);
  }
  
  public final void fDA()
  {
    AppMethodBeat.i(191407);
    this.zQt = com.tencent.mm.api.h.diK;
    this.sTB = 0;
    Object localObject = this.zQp;
    if (localObject != null) {
      ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.diK);
    }
    localObject = this.zQp;
    if (localObject != null) {
      ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.diK, 0, null);
    }
    localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_MOSAIC_COUNT_INT");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.VH(8);
    AppMethodBeat.o(191407);
  }
  
  public final void fDB()
  {
    AppMethodBeat.i(191408);
    this.zQt = com.tencent.mm.api.h.diK;
    this.sTB = 1;
    Object localObject = this.zQp;
    if (localObject != null) {
      ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.diK);
    }
    localObject = this.zQp;
    if (localObject != null) {
      ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener().a(com.tencent.mm.api.h.diK, 1, null);
    }
    localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_BRUSH_COUNT_INT");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.VH(9);
    AppMethodBeat.o(191408);
  }
  
  public final void fDz()
  {
    AppMethodBeat.i(191406);
    com.tencent.mm.bt.b localb = this.zQp;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.cache.c.alF().alG(), -1, null);
    }
    localb = this.zQp;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(this.zQt);
    }
    localb = this.zQp;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(this.zQt, this.sTB, null);
      AppMethodBeat.o(191406);
      return;
    }
    AppMethodBeat.o(191406);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(191413);
    if (this.zQt == com.tencent.mm.api.h.diL)
    {
      this.zQt = com.tencent.mm.api.h.diG;
      com.tencent.mm.bt.b localb = this.zQp;
      if (localb != null) {
        localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.diL, 1, null);
      }
      AppMethodBeat.o(191413);
      return true;
    }
    AppMethodBeat.o(191413);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(191411);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.GHW.values();
    p.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      localb.GHY.onDestroy();
      localb.BQu.getPresenter().onDestroy();
    }
    this.GHW.clear();
    AppMethodBeat.o(191411);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191417);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    com.tencent.mm.plugin.recordvideo.plugin.t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191417);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(191412);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
    Object localObject = this.GHW.values();
    p.g(localObject, "editorViewDataMap.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      localb.GHY.onDestroy();
      localb.BQu.getPresenter().onDestroy();
    }
    this.GHW.clear();
    this.zQv.removeAllViews();
    this.zQv.setVisibility(8);
    this.zCl = null;
    AppMethodBeat.o(191412);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191410);
    Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "reset");
    this.zQt = com.tencent.mm.api.h.diG;
    com.tencent.mm.bt.b localb = this.zQp;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.diG);
    }
    localb = this.zQp;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.h.diG, -1, null);
      AppMethodBeat.o(191410);
      return;
    }
    AppMethodBeat.o(191410);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191414);
    this.zQv.setVisibility(paramInt);
    AppMethodBeat.o(191414);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "", "editor", "Lcom/tencent/mm/api/MMPhotoEditor;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "(Lcom/tencent/mm/api/MMPhotoEditor;Lcom/tencent/mm/view/PhotoDrawingView;)V", "getDrawingView", "()Lcom/tencent/mm/view/PhotoDrawingView;", "getEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"})
  static final class b
  {
    final m BQu;
    final ab GHY;
    
    public b(ab paramab, m paramm)
    {
      AppMethodBeat.i(191389);
      this.GHY = paramab;
      this.BQu = paramm;
      AppMethodBeat.o(191389);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(191392);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.GHY, paramObject.GHY)) || (!p.j(this.BQu, paramObject.BQu))) {}
        }
      }
      else
      {
        AppMethodBeat.o(191392);
        return true;
      }
      AppMethodBeat.o(191392);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(191391);
      Object localObject = this.GHY;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.BQu;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(191391);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(191390);
      String str = "PhotoEditorViewData(editor=" + this.GHY + ", drawingView=" + this.BQu + ")";
      AppMethodBeat.o(191390);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-vlog_release"})
  public static final class c
    implements com.tencent.mm.api.u
  {
    c(long paramLong, q paramq, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(191394);
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + Util.ticksToNow(l));
      Object localObject1 = e.ilC;
      e.zL(Util.ticksToNow(l));
      if (paramBitmap == null)
      {
        localObject1 = e.ilC;
        e.aNR();
      }
      if (paramBitmap != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        localObject1 = new StringBuilder();
        Object localObject2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        localObject1 = com.tencent.mm.plugin.recordvideo.e.c.eMK() + paramBitmap.hashCode();
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "saveBitmapToImage  cost:" + Util.ticksToNow(l) + "  path:" + (String)localObject1);
        t.a(this.GHZ);
        paramBitmap = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        paramBitmap = t.b(this.GHZ);
        localObject2 = t.c(this.GHZ);
        if (localObject2 != null) {}
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).iqf;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.c.b(paramBitmap, paramBoolean, this.BQx);
          Log.d("MicroMsg.MultiPhotoEditContainerPlugin", "new ThreadPool  cost:" + Util.ticksToNow(l));
          bool.d(Boolean.TRUE, localObject1, Boolean.valueOf(this.BQx));
          AppMethodBeat.o(191394);
          return;
        }
      }
      AppMethodBeat.o(191394);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(191393);
      p.h(paramException, "e");
      Log.e("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      paramException = e.ilC;
      e.aNQ();
      paramException = e.ilC;
      e.zL(Util.ticksToNow(l));
      t.a(this.GHZ);
      bool.d(Boolean.FALSE, null, Boolean.valueOf(this.BQx));
      AppMethodBeat.o(191393);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-vlog_release"})
  public static final class d
    implements a.c
  {
    public final boolean b(f paramf)
    {
      AppMethodBeat.i(191396);
      p.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.hoI);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.GHZ.wgr.a(d.c.BVd, localBundle);
      AppMethodBeat.o(191396);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-vlog_release"})
  public static final class e
    implements z
  {
    public final void a(com.tencent.mm.api.h paramh)
    {
      AppMethodBeat.i(191398);
      p.h(paramh, "features");
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { paramh.name() });
      if (paramh == com.tencent.mm.api.h.diG) {
        d.b.a(this.GHZ.wgr, d.c.BVS);
      }
      AppMethodBeat.o(191398);
    }
    
    public final void a(com.tencent.mm.api.h paramh, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(191399);
      p.h(paramh, "features");
      Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramh.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(191399);
    }
    
    public final void cH(boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class f
    implements b.a
  {
    f(t paramt) {}
    
    public final boolean q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(191400);
      t localt = this.GHZ;
      p.g(paramMotionEvent, "it");
      t.a(localt, paramMotionEvent);
      AppMethodBeat.o(191400);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class g
    implements b.a
  {
    g(t paramt) {}
    
    public final boolean q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(191401);
      t localt = this.GHZ;
      p.g(paramMotionEvent, "it");
      t.a(localt, paramMotionEvent);
      AppMethodBeat.o(191401);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.t
 * JD-Core Version:    0.7.0.1
 */