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
import com.tencent.mm.bt.a.c;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.view.e;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "isFinishing", "", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadPhotoEditLogic", "path", "", "onBackPress", "release", "reset", "setup", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-recordvideo_release"})
public final class j
  implements t
{
  public static final j.a xQx;
  public final Context context;
  private boolean ghe;
  public boolean isFinishing;
  public int rss;
  public RecordConfigProvider sYT;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  public y whL;
  private final d.f xQq;
  private final d.f xQr;
  public com.tencent.mm.media.widget.camerarecordview.b.b xQs;
  public e xQt;
  public com.tencent.mm.bt.b xQu;
  public com.tencent.mm.api.g xQv;
  public FrameLayout xQw;
  
  static
  {
    AppMethodBeat.i(75540);
    xQx = new j.a((byte)0);
    AppMethodBeat.o(75540);
  }
  
  public j(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75539);
    this.xQw = paramFrameLayout;
    this.tbP = paramd;
    this.xQq = d.g.O((a)h.xQC);
    this.xQr = d.g.O((a)g.xQB);
    this.context = this.xQw.getContext();
    this.xQv = com.tencent.mm.api.g.cSm;
    this.rss = -1;
    AppMethodBeat.o(75539);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(75538);
    if (this.xQv == com.tencent.mm.api.g.cSr)
    {
      dJM();
      AppMethodBeat.o(75538);
      return true;
    }
    AppMethodBeat.o(75538);
    return false;
  }
  
  public final void azm() {}
  
  public final y dJK()
  {
    AppMethodBeat.i(169937);
    y localy = (y)this.xQq.getValue();
    AppMethodBeat.o(169937);
    return localy;
  }
  
  public final y dJL()
  {
    AppMethodBeat.i(169938);
    y localy = (y)this.xQr.getValue();
    AppMethodBeat.o(169938);
    return localy;
  }
  
  public final void dJM()
  {
    AppMethodBeat.i(75535);
    this.xQv = com.tencent.mm.api.g.cSm;
    com.tencent.mm.bt.b localb = this.xQu;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSr, 1, null);
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
    AppMethodBeat.i(206574);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206574);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75537);
    dJK().onDestroy();
    dJL().onDestroy();
    this.xQw.removeAllViews();
    this.xQw.setVisibility(8);
    com.tencent.mm.bt.b localb = this.xQu;
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
    this.xQv = com.tencent.mm.api.g.cSm;
    com.tencent.mm.bt.b localb = this.xQu;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSm);
    }
    localb = this.xQu;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cSm, -1, null);
      AppMethodBeat.o(75536);
      return;
    }
    AppMethodBeat.o(75536);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-recordvideo_release"})
  public static final class b
    implements s
  {
    public b(long paramLong, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(75528);
      ae.i("MicroMsg.EditPhotoPluginLayout", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bu.aO(this.hwp));
      Object localObject1 = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.rF(bu.aO(this.hwp));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.ave();
      }
      if (paramBitmap != null)
      {
        localObject1 = c.xWV;
        c.u("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = c.xWV;
        c.u("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        ae.i("MicroMsg.EditPhotoPluginLayout", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        Object localObject3 = Bitmap.CompressFormat.JPEG;
        localObject1 = j.b(this.xQy);
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).xOv;
          h.a(paramBitmap, 100, (Bitmap.CompressFormat)localObject3, (String)localObject1, true);
          localObject1 = new StringBuilder("saveBitmapToImage  cost:").append(bu.aO(this.hwp)).append("  path:");
          localObject3 = j.b(this.xQy);
          paramBitmap = localObject2;
          if (localObject3 != null) {
            paramBitmap = ((RecordConfigProvider)localObject3).xOv;
          }
          ae.i("MicroMsg.EditPhotoPluginLayout", paramBitmap);
          j.a(this.xQy);
          paramBitmap = com.tencent.mm.plugin.recordvideo.e.b.yhe;
          paramBitmap = j.b(this.xQy);
          localObject1 = j.c(this.xQy);
          if (localObject1 == null) {
            break label341;
          }
        }
        label341:
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwD;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.b.b(paramBitmap, paramBoolean, this.xQz);
          ae.d("MicroMsg.EditPhotoPluginLayout", "new ThreadPool  cost:" + bu.aO(this.hwp));
          ar.f((Runnable)new a(this));
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
      ae.e("MicroMsg.EditPhotoPluginLayout", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avd();
      paramException = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.rF(bu.aO(this.hwp));
      j.a(this.xQy);
      AppMethodBeat.o(75527);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1$onSuccess$1$1"})
    static final class a
      implements Runnable
    {
      a(j.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75526);
        CaptureDataManager localCaptureDataManager = CaptureDataManager.xNV;
        Context localContext = j.d(this.xQA.xQy);
        Boolean localBoolean1 = Boolean.TRUE;
        Object localObject = j.b(this.xQA.xQy);
        if (localObject != null) {}
        for (localObject = ((RecordConfigProvider)localObject).xOv;; localObject = null)
        {
          Boolean localBoolean2 = Boolean.TRUE;
          c localc = c.xWV;
          localCaptureDataManager.a(localContext, new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", (String)localObject, Long.valueOf(-1L), localBoolean2, c.dKb()));
          AppMethodBeat.o(75526);
          return;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-recordvideo_release"})
  public static final class c
    implements a.c
  {
    public final boolean b(com.tencent.mm.z.f paramf)
    {
      AppMethodBeat.i(163429);
      p.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.gBT);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.xQy.tbP.a(d.c.xUA, localBundle);
      AppMethodBeat.o(163429);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-recordvideo_release"})
  public static final class d
    implements w
  {
    public final void a(com.tencent.mm.api.g paramg)
    {
      AppMethodBeat.i(163431);
      p.h(paramg, "features");
      ae.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedFeature] features:%s", new Object[] { paramg.name() });
      if (paramg == com.tencent.mm.api.g.cSm) {
        d.b.a(this.xQy.tbP, d.c.xVk);
      }
      AppMethodBeat.o(163431);
    }
    
    public final void a(com.tencent.mm.api.g paramg, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(163432);
      p.h(paramg, "features");
      ae.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(163432);
    }
    
    public final void bY(boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class e
    implements b.a
  {
    public e(j paramj) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(75534);
      j localj = this.xQy;
      p.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(75534);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class f
    implements b.a
  {
    public f(j paramj) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(163433);
      j localj = this.xQy;
      p.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(163433);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements a<y>
  {
    public static final g xQB;
    
    static
    {
      AppMethodBeat.i(169934);
      xQB = new g();
      AppMethodBeat.o(169934);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements a<y>
  {
    public static final h xQC;
    
    static
    {
      AppMethodBeat.i(169936);
      xQC = new h();
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