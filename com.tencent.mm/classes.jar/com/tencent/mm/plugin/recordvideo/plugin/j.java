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
import com.tencent.mm.bu.a.c;
import com.tencent.mm.e.b.a;
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
import d.g.b.u;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "isFinishing", "", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadPhotoEditLogic", "path", "", "onBackPress", "release", "reset", "setup", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-recordvideo_release"})
public final class j
  implements t
{
  public static final a vjY;
  public final Context context;
  public int goS;
  public boolean isFinishing;
  public y tJO;
  public RecordConfigProvider vcC;
  private final d.f vjQ;
  private final d.f vjR;
  public com.tencent.mm.media.widget.camerarecordview.b.b vjS;
  public e vjT;
  public com.tencent.mm.bu.b vjU;
  private boolean vjV;
  public com.tencent.mm.api.g vjW;
  public FrameLayout vjX;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  
  static
  {
    AppMethodBeat.i(75540);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new u(d.g.b.w.bk(j.class), "mPortraitPhotoEditor", "getMPortraitPhotoEditor()Lcom/tencent/mm/api/MMPhotoEditor;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bk(j.class), "mLandscapePhotoEditor", "getMLandscapePhotoEditor()Lcom/tencent/mm/api/MMPhotoEditor;")) };
    vjY = new a((byte)0);
    AppMethodBeat.o(75540);
  }
  
  public j(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75539);
    this.vjX = paramFrameLayout;
    this.vjo = paramd;
    this.vjQ = d.g.E((a)h.vkd);
    this.vjR = d.g.E((a)g.vkc);
    this.context = this.vjX.getContext();
    this.vjW = com.tencent.mm.api.g.cJr;
    this.goS = -1;
    AppMethodBeat.o(75539);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    AppMethodBeat.i(75538);
    if (this.vjW == com.tencent.mm.api.g.cJw)
    {
      din();
      AppMethodBeat.o(75538);
      return true;
    }
    AppMethodBeat.o(75538);
    return false;
  }
  
  public final y dil()
  {
    AppMethodBeat.i(169937);
    y localy = (y)this.vjQ.getValue();
    AppMethodBeat.o(169937);
    return localy;
  }
  
  public final y dim()
  {
    AppMethodBeat.i(169938);
    y localy = (y)this.vjR.getValue();
    AppMethodBeat.o(169938);
    return localy;
  }
  
  public final void din()
  {
    AppMethodBeat.i(75535);
    this.vjW = com.tencent.mm.api.g.cJr;
    com.tencent.mm.bu.b localb = this.vjU;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJw, 1, null);
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
    dil().onDestroy();
    dim().onDestroy();
    this.vjX.removeAllViews();
    this.vjX.setVisibility(8);
    com.tencent.mm.bu.b localb = this.vjU;
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
    this.vjW = com.tencent.mm.api.g.cJr;
    com.tencent.mm.bu.b localb = this.vjU;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJr);
    }
    localb = this.vjU;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(com.tencent.mm.api.g.cJr, -1, null);
      AppMethodBeat.o(75536);
      return;
    }
    AppMethodBeat.o(75536);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-recordvideo_release"})
  public static final class b
    implements s
  {
    public b(long paramLong, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(75528);
      ad.i("MicroMsg.EditPhotoPluginLayout", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + bt.aS(this.gAX));
      Object localObject1 = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.lF(bt.aS(this.gAX));
      if (paramBitmap == null)
      {
        localObject1 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.ali();
      }
      if (paramBitmap != null)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(paramBitmap.getWidth()));
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(paramBitmap.getHeight()));
        ad.i("MicroMsg.EditPhotoPluginLayout", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        Object localObject3 = Bitmap.CompressFormat.JPEG;
        localObject1 = j.b(this.vjZ);
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).vhW;
          com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, (Bitmap.CompressFormat)localObject3, (String)localObject1, true);
          localObject1 = new StringBuilder("saveBitmapToImage  cost:").append(bt.aS(this.gAX)).append("  path:");
          localObject3 = j.b(this.vjZ);
          paramBitmap = localObject2;
          if (localObject3 != null) {
            paramBitmap = ((RecordConfigProvider)localObject3).vhW;
          }
          ad.i("MicroMsg.EditPhotoPluginLayout", paramBitmap);
          j.a(this.vjZ);
          paramBitmap = com.tencent.mm.plugin.recordvideo.e.b.vtE;
          paramBitmap = j.b(this.vjZ);
          localObject1 = j.c(this.vjZ);
          if (localObject1 == null) {
            break label341;
          }
        }
        label341:
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBl;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.b.b(paramBitmap, paramBoolean, this.vka);
          ad.d("MicroMsg.EditPhotoPluginLayout", "new ThreadPool  cost:" + bt.aS(this.gAX));
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
      d.g.b.k.h(paramException, "e");
      ad.e("MicroMsg.EditPhotoPluginLayout", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alh();
      paramException = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.lF(bt.aS(this.gAX));
      j.a(this.vjZ);
      AppMethodBeat.o(75527);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1$onSuccess$1$1"})
    static final class a
      implements Runnable
    {
      a(j.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75526);
        CaptureDataManager localCaptureDataManager = CaptureDataManager.vhw;
        Context localContext = j.d(this.vkb.vjZ);
        Boolean localBoolean1 = Boolean.TRUE;
        Object localObject = j.b(this.vkb.vjZ);
        if (localObject != null) {}
        for (localObject = ((RecordConfigProvider)localObject).vhW;; localObject = null)
        {
          Boolean localBoolean2 = Boolean.TRUE;
          com.tencent.mm.plugin.recordvideo.d.b localb = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          localCaptureDataManager.a(localContext, new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", (String)localObject, Long.valueOf(-1L), localBoolean2, com.tencent.mm.plugin.recordvideo.d.b.dix()));
          AppMethodBeat.o(75526);
          return;
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-recordvideo_release"})
  public static final class c
    implements a.c
  {
    public final boolean b(com.tencent.mm.aa.f paramf)
    {
      AppMethodBeat.i(163429);
      d.g.b.k.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.gaW);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.vjZ.vjo.a(d.c.vnP, localBundle);
      AppMethodBeat.o(163429);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-recordvideo_release"})
  public static final class d
    implements com.tencent.mm.api.w
  {
    public final void a(com.tencent.mm.api.g paramg)
    {
      AppMethodBeat.i(163431);
      d.g.b.k.h(paramg, "features");
      ad.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedFeature] features:%s", new Object[] { paramg.name() });
      if (paramg == com.tencent.mm.api.g.cJr) {
        d.b.a(this.vjZ.vjo, d.c.voz);
      }
      AppMethodBeat.o(163431);
    }
    
    public final void a(com.tencent.mm.api.g paramg, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(163432);
      d.g.b.k.h(paramg, "features");
      ad.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramg.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(163432);
    }
    
    public final void bV(boolean paramBoolean) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class e
    implements b.a
  {
    public e(j paramj) {}
    
    public final boolean p(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(75534);
      j localj = this.vjZ;
      d.g.b.k.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(75534);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class f
    implements b.a
  {
    public f(j paramj) {}
    
    public final boolean p(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(163433);
      j localj = this.vjZ;
      d.g.b.k.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(163433);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<y>
  {
    public static final g vkc;
    
    static
    {
      AppMethodBeat.i(169934);
      vkc = new g();
      AppMethodBeat.o(169934);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<y>
  {
    public static final h vkd;
    
    static
    {
      AppMethodBeat.i(169936);
      vkd = new h();
      AppMethodBeat.o(169936);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.j
 * JD-Core Version:    0.7.0.1
 */