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
import com.tencent.mm.api.y;
import com.tencent.mm.bt.a.c;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.e;
import d.g.a.a;
import d.g.b.u;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "isFinishing", "", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadPhotoEditLogic", "path", "", "onBackPress", "release", "reset", "setup", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-recordvideo_release"})
public final class j
  implements t
{
  public static final j.a wsD;
  public final Context context;
  public int gPA;
  public boolean isFinishing;
  public RecordConfigProvider rRi;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d rTT;
  public y sgl;
  public com.tencent.mm.media.widget.camerarecordview.b.b sgm;
  public e sgn;
  public com.tencent.mm.bt.b sgo;
  private boolean sgq;
  public com.tencent.mm.api.g sgr;
  public FrameLayout sgs;
  private final d.f wsB;
  private final d.f wsC;
  
  static
  {
    AppMethodBeat.i(75540);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(j.class), "mPortraitPhotoEditor", "getMPortraitPhotoEditor()Lcom/tencent/mm/api/MMPhotoEditor;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(j.class), "mLandscapePhotoEditor", "getMLandscapePhotoEditor()Lcom/tencent/mm/api/MMPhotoEditor;")) };
    wsD = new j.a((byte)0);
    AppMethodBeat.o(75540);
  }
  
  public j(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75539);
    this.sgs = paramFrameLayout;
    this.rTT = paramd;
    this.wsB = d.g.K((a)h.wsH);
    this.wsC = d.g.K((a)g.wsG);
    this.context = this.sgs.getContext();
    this.sgr = com.tencent.mm.api.g.cGy;
    this.gPA = -1;
    AppMethodBeat.o(75539);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(75538);
    if (this.sgr == com.tencent.mm.api.g.cGD)
    {
      dvX();
      AppMethodBeat.o(75538);
      return true;
    }
    AppMethodBeat.o(75538);
    return false;
  }
  
  public final void awk() {}
  
  public final y dvV()
  {
    AppMethodBeat.i(169937);
    y localy = (y)this.wsB.getValue();
    AppMethodBeat.o(169937);
    return localy;
  }
  
  public final y dvW()
  {
    AppMethodBeat.i(169938);
    y localy = (y)this.wsC.getValue();
    AppMethodBeat.o(169938);
    return localy;
  }
  
  public final void dvX()
  {
    AppMethodBeat.i(75535);
    this.sgr = com.tencent.mm.api.g.cGy;
    com.tencent.mm.bt.b localb = this.sgo;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGD, 1, null);
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
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75537);
    dvV().onDestroy();
    dvW().onDestroy();
    this.sgs.removeAllViews();
    this.sgs.setVisibility(8);
    com.tencent.mm.bt.b localb = this.sgo;
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
    this.sgr = com.tencent.mm.api.g.cGy;
    com.tencent.mm.bt.b localb = this.sgo;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGy);
    }
    localb = this.sgo;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cGy, -1, null);
      AppMethodBeat.o(75536);
      return;
    }
    AppMethodBeat.o(75536);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-recordvideo_release"})
  public static final class b
    implements s
  {
    public b(long paramLong, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(75528);
      ac.i("MicroMsg.EditPhotoPluginLayout", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bs.aO(this.hbt));
      Object localObject1 = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.pt(bs.aO(this.hbt));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asc();
      }
      if (paramBitmap != null)
      {
        localObject1 = c.wyg;
        c.w("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = c.wyg;
        c.w("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        ac.i("MicroMsg.EditPhotoPluginLayout", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        Object localObject3 = Bitmap.CompressFormat.JPEG;
        localObject1 = j.b(this.wsE);
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).wqI;
          com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, (Bitmap.CompressFormat)localObject3, (String)localObject1, true);
          localObject1 = new StringBuilder("saveBitmapToImage  cost:").append(bs.aO(this.hbt)).append("  path:");
          localObject3 = j.b(this.wsE);
          paramBitmap = localObject2;
          if (localObject3 != null) {
            paramBitmap = ((RecordConfigProvider)localObject3).wqI;
          }
          ac.i("MicroMsg.EditPhotoPluginLayout", paramBitmap);
          j.a(this.wsE);
          paramBitmap = com.tencent.mm.plugin.recordvideo.e.b.wDE;
          paramBitmap = j.b(this.wsE);
          localObject1 = j.c(this.wsE);
          if (localObject1 == null) {
            break label341;
          }
        }
        label341:
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hbH;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.b.b(paramBitmap, paramBoolean, this.sgw);
          ac.d("MicroMsg.EditPhotoPluginLayout", "new ThreadPool  cost:" + bs.aO(this.hbt));
          ap.f((Runnable)new a(this));
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
      d.g.b.k.h(paramException, "e");
      ac.e("MicroMsg.EditPhotoPluginLayout", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asb();
      paramException = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.pt(bs.aO(this.hbt));
      j.a(this.wsE);
      AppMethodBeat.o(75527);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1$onSuccess$1$1"})
    static final class a
      implements Runnable
    {
      a(j.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75526);
        CaptureDataManager localCaptureDataManager = CaptureDataManager.wqi;
        Context localContext = j.d(this.wsF.wsE);
        Boolean localBoolean1 = Boolean.TRUE;
        Object localObject = j.b(this.wsF.wsE);
        if (localObject != null) {}
        for (localObject = ((RecordConfigProvider)localObject).wqI;; localObject = null)
        {
          Boolean localBoolean2 = Boolean.TRUE;
          c localc = c.wyg;
          localCaptureDataManager.a(localContext, new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", (String)localObject, Long.valueOf(-1L), localBoolean2, c.dwq()));
          AppMethodBeat.o(75526);
          return;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-recordvideo_release"})
  public static final class c
    implements a.c
  {
    public final boolean b(com.tencent.mm.z.f paramf)
    {
      AppMethodBeat.i(163429);
      d.g.b.k.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.gfC);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.wsE.rTT.a(d.c.www, localBundle);
      AppMethodBeat.o(163429);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-recordvideo_release"})
  public static final class d
    implements com.tencent.mm.api.w
  {
    public final void a(com.tencent.mm.api.g paramg)
    {
      AppMethodBeat.i(163431);
      d.g.b.k.h(paramg, "features");
      ac.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedFeature] features:%s", new Object[] { paramg.name() });
      if (paramg == com.tencent.mm.api.g.cGy) {
        d.b.a(this.wsE.rTT, d.c.wxg);
      }
      AppMethodBeat.o(163431);
    }
    
    public final void a(com.tencent.mm.api.g paramg, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(163432);
      d.g.b.k.h(paramg, "features");
      ac.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(163432);
    }
    
    public final void bW(boolean paramBoolean) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class e
    implements b.a
  {
    public e(j paramj) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(75534);
      j localj = this.wsE;
      d.g.b.k.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(75534);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class f
    implements b.a
  {
    public f(j paramj) {}
    
    public final boolean n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(163433);
      j localj = this.wsE;
      d.g.b.k.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(163433);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<y>
  {
    public static final g wsG;
    
    static
    {
      AppMethodBeat.i(169934);
      wsG = new g();
      AppMethodBeat.o(169934);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<y>
  {
    public static final h wsH;
    
    static
    {
      AppMethodBeat.i(169936);
      wsH = new h();
      AppMethodBeat.o(169936);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.j
 * JD-Core Version:    0.7.0.1
 */