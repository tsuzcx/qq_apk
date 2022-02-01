package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.s;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.bu.a.c;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.e;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "isFinishing", "", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadPhotoEditLogic", "path", "", "onBackPress", "release", "reset", "setup", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-recordvideo_release"})
public final class j
  implements t
{
  public static final j.a xAC;
  public final Context context;
  public boolean isFinishing;
  public int rko;
  public RecordConfigProvider sNI;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  public y vVH;
  public com.tencent.mm.api.g xAA;
  public FrameLayout xAB;
  private final d.f xAu;
  private final d.f xAv;
  public com.tencent.mm.media.widget.camerarecordview.b.b xAw;
  public e xAx;
  public com.tencent.mm.bu.b xAy;
  private boolean xAz;
  
  static
  {
    AppMethodBeat.i(75540);
    xAC = new j.a((byte)0);
    AppMethodBeat.o(75540);
  }
  
  public j(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75539);
    this.xAB = paramFrameLayout;
    this.sQE = paramd;
    this.xAu = d.g.O((a)h.xAH);
    this.xAv = d.g.O((a)g.xAG);
    this.context = this.xAB.getContext();
    this.xAA = com.tencent.mm.api.g.cRC;
    this.rko = -1;
    AppMethodBeat.o(75539);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(75538);
    if (this.xAA == com.tencent.mm.api.g.cRH)
    {
      dGv();
      AppMethodBeat.o(75538);
      return true;
    }
    AppMethodBeat.o(75538);
    return false;
  }
  
  public final void ayX() {}
  
  public final y dGt()
  {
    AppMethodBeat.i(169937);
    y localy = (y)this.xAu.getValue();
    AppMethodBeat.o(169937);
    return localy;
  }
  
  public final y dGu()
  {
    AppMethodBeat.i(169938);
    y localy = (y)this.xAv.getValue();
    AppMethodBeat.o(169938);
    return localy;
  }
  
  public final void dGv()
  {
    AppMethodBeat.i(75535);
    this.xAA = com.tencent.mm.api.g.cRC;
    com.tencent.mm.bu.b localb = this.xAy;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRH, 1, null);
      AppMethodBeat.o(75535);
      return;
    }
    AppMethodBeat.o(75535);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200313);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200313);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75537);
    dGt().onDestroy();
    dGu().onDestroy();
    this.xAB.removeAllViews();
    this.xAB.setVisibility(8);
    com.tencent.mm.bu.b localb = this.xAy;
    if (localb != null)
    {
      localb.onDestroy();
      AppMethodBeat.o(75537);
      return;
    }
    AppMethodBeat.o(75537);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75536);
    this.xAA = com.tencent.mm.api.g.cRC;
    com.tencent.mm.bu.b localb = this.xAy;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRC);
    }
    localb = this.xAy;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cRC, -1, null);
      AppMethodBeat.o(75536);
      return;
    }
    AppMethodBeat.o(75536);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-recordvideo_release"})
  public static final class b
    implements s
  {
    public b(long paramLong, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(75528);
      ad.i("MicroMsg.EditPhotoPluginLayout", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bt.aO(this.htB));
      Object localObject1 = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.rs(bt.aO(this.htB));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auP();
      }
      if (paramBitmap != null)
      {
        localObject1 = c.xHa;
        c.u("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = c.xHa;
        c.u("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        ad.i("MicroMsg.EditPhotoPluginLayout", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        Object localObject3 = Bitmap.CompressFormat.JPEG;
        localObject1 = j.b(this.xAD);
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).xyz;
          com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, (Bitmap.CompressFormat)localObject3, (String)localObject1, true);
          localObject1 = new StringBuilder("saveBitmapToImage  cost:").append(bt.aO(this.htB)).append("  path:");
          localObject3 = j.b(this.xAD);
          paramBitmap = localObject2;
          if (localObject3 != null) {
            paramBitmap = ((RecordConfigProvider)localObject3).xyz;
          }
          ad.i("MicroMsg.EditPhotoPluginLayout", paramBitmap);
          j.a(this.xAD);
          paramBitmap = com.tencent.mm.plugin.recordvideo.e.b.xRl;
          paramBitmap = j.b(this.xAD);
          localObject1 = j.c(this.xAD);
          if (localObject1 == null) {
            break label341;
          }
        }
        label341:
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).htP;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.b.b(paramBitmap, paramBoolean, this.xAE);
          ad.d("MicroMsg.EditPhotoPluginLayout", "new ThreadPool  cost:" + bt.aO(this.htB));
          aq.f((Runnable)new a(this));
          AppMethodBeat.o(75528);
          return;
          localObject1 = null;
          break;
        }
      }
      AppMethodBeat.o(75528);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(75527);
      p.h(paramException, "e");
      ad.e("MicroMsg.EditPhotoPluginLayout", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auO();
      paramException = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.rs(bt.aO(this.htB));
      j.a(this.xAD);
      AppMethodBeat.o(75527);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1$onSuccess$1$1"})
    static final class a
      implements Runnable
    {
      a(j.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75526);
        CaptureDataManager localCaptureDataManager = CaptureDataManager.xxY;
        Context localContext = j.d(this.xAF.xAD);
        Boolean localBoolean1 = Boolean.TRUE;
        Object localObject = j.b(this.xAF.xAD);
        if (localObject != null) {}
        for (localObject = ((RecordConfigProvider)localObject).xyz;; localObject = null)
        {
          Boolean localBoolean2 = Boolean.TRUE;
          c localc = c.xHa;
          localCaptureDataManager.a(localContext, new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", (String)localObject, Long.valueOf(-1L), localBoolean2, c.dGK()));
          AppMethodBeat.o(75526);
          return;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-recordvideo_release"})
  public static final class c
    implements a.c
  {
    public final boolean b(com.tencent.mm.aa.f paramf)
    {
      AppMethodBeat.i(163429);
      p.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.gzm);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.xAD.sQE.a(d.c.xEF, localBundle);
      AppMethodBeat.o(163429);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-recordvideo_release"})
  public static final class d
    implements w
  {
    public final void a(com.tencent.mm.api.g paramg)
    {
      AppMethodBeat.i(163431);
      p.h(paramg, "features");
      ad.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedFeature] features:%s", new Object[] { paramg.name() });
      if (paramg == com.tencent.mm.api.g.cRC) {
        d.b.a(this.xAD.sQE, d.c.xFp);
      }
      AppMethodBeat.o(163431);
    }
    
    public final void a(com.tencent.mm.api.g paramg, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(163432);
      p.h(paramg, "features");
      ad.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(163432);
    }
    
    public final void bY(boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class e
    implements b.a
  {
    public e(j paramj) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(75534);
      j localj = this.xAD;
      p.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(75534);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class f
    implements b.a
  {
    public f(j paramj) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(163433);
      j localj = this.xAD;
      p.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(163433);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements a<y>
  {
    public static final g xAG;
    
    static
    {
      AppMethodBeat.i(169934);
      xAG = new g();
      AppMethodBeat.o(169934);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements a<y>
  {
    public static final h xAH;
    
    static
    {
      AppMethodBeat.i(169936);
      xAH = new h();
      AppMethodBeat.o(169936);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.j
 * JD-Core Version:    0.7.0.1
 */