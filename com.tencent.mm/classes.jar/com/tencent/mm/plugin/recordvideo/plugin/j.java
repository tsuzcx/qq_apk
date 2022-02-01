package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.h;
import com.tencent.mm.api.u;
import com.tencent.mm.api.x;
import com.tencent.mm.api.z;
import com.tencent.mm.bt.a.c;
import com.tencent.mm.e.b.a;
import com.tencent.mm.media.k.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.m;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "isFinishing", "", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadPhotoEditLogic", "path", "", "onBackPress", "release", "reset", "setOutputSize", "width", "height", "setup", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-recordvideo_release"})
public final class j
  implements t
{
  public static final j.a BQv;
  public com.tencent.mm.media.widget.camerarecordview.b.b BQt;
  public m BQu;
  public final Context context;
  private boolean gMK;
  private boolean isFinishing;
  public int sTB;
  public RecordConfigProvider wdm;
  d wgr;
  public ab zCl;
  private final kotlin.f zQm;
  private final kotlin.f zQn;
  public com.tencent.mm.bt.b zQp;
  public h zQt;
  public FrameLayout zQv;
  
  static
  {
    AppMethodBeat.i(75540);
    BQv = new j.a((byte)0);
    AppMethodBeat.o(75540);
  }
  
  public j(FrameLayout paramFrameLayout, d paramd)
  {
    AppMethodBeat.i(75539);
    this.zQv = paramFrameLayout;
    this.wgr = paramd;
    this.zQm = kotlin.g.ah((a)h.BQA);
    this.zQn = kotlin.g.ah((a)g.BQz);
    this.context = this.zQv.getContext();
    this.zQt = h.diG;
    this.sTB = -1;
    AppMethodBeat.o(75539);
  }
  
  public final void aSs() {}
  
  public final void dJF()
  {
    AppMethodBeat.i(237289);
    Object localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    localObject = this.zCl;
    label75:
    label122:
    int i;
    if (localObject != null)
    {
      localObject = ((ab)localObject).Um();
      if (localObject == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(((x)localObject).Vy()));
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject = this.zCl;
      if (localObject == null) {
        break label522;
      }
      localObject = ((ab)localObject).Um();
      if (localObject == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(((x)localObject).Vx()));
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject = this.zCl;
      if (localObject == null) {
        break label528;
      }
      localObject = ((ab)localObject).Um();
      if (localObject == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(((x)localObject).VA()));
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject = this.zCl;
      if (localObject == null) {
        break label534;
      }
      localObject = ((ab)localObject).Um();
      label169:
      if (localObject == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(((x)localObject).VD()));
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject = this.zCl;
      if (localObject == null) {
        break label540;
      }
      localObject = ((ab)localObject).Um();
      label216:
      if (localObject == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(((x)localObject).Vz()));
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject = this.zCl;
      if (localObject == null) {
        break label546;
      }
      localObject = ((ab)localObject).Um();
      label263:
      if (localObject == null) {
        p.hyc();
      }
      if (!((x)localObject).VC()) {
        break label552;
      }
      i = 1;
      label283:
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ROTATE_INT", Integer.valueOf(i));
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject = com.tencent.mm.plugin.recordvideo.d.g.BXY;
      localObject = this.zCl;
      if (localObject == null) {
        break label557;
      }
      localObject = ((ab)localObject).Um();
      label331:
      if (localObject == null) {
        p.hyc();
      }
      i = ((x)localObject).Vy();
      localObject = this.zCl;
      if (localObject == null) {
        break label563;
      }
      localObject = ((ab)localObject).Um();
      label365:
      if (localObject == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.recordvideo.d.g.J(new int[] { i, ((x)localObject).Vx(), -1 });
      localObject = com.tencent.mm.plugin.recordvideo.d.g.BXY;
      com.tencent.mm.plugin.recordvideo.d.g.ax(1, 2L);
      localObject = this.zCl;
      if (localObject == null) {
        break label569;
      }
    }
    boolean bool;
    label522:
    label528:
    label534:
    label540:
    label546:
    label552:
    label557:
    label563:
    label569:
    for (localObject = ((ab)localObject).Um();; localObject = null)
    {
      if (localObject == null) {
        p.hyc();
      }
      bool = ((x)localObject).VE();
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        localObject = e.ilC;
        e.aNL();
      }
      localObject = e.ilC;
      e.aNS();
      if (this.isFinishing) {
        break label586;
      }
      localObject = this.context;
      if (localObject != null) {
        break label575;
      }
      localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(237289);
      throw ((Throwable)localObject);
      localObject = null;
      break;
      localObject = null;
      break label75;
      localObject = null;
      break label122;
      localObject = null;
      break label169;
      localObject = null;
      break label216;
      localObject = null;
      break label263;
      i = 0;
      break label283;
      localObject = null;
      break label331;
      localObject = null;
      break label365;
    }
    label575:
    if (((Activity)localObject).isFinishing())
    {
      label586:
      AppMethodBeat.o(237289);
      return;
    }
    this.isFinishing = true;
    final long l = Util.currentTicks();
    Log.i("MicroMsg.EditPhotoPluginLayout", "dofinish time: " + l + ' ' + bool);
    localObject = this.zCl;
    if (localObject != null)
    {
      ((ab)localObject).a((u)new b(this, l, bool));
      AppMethodBeat.o(237289);
      return;
    }
    AppMethodBeat.o(237289);
  }
  
  public final void eKA()
  {
    AppMethodBeat.i(237288);
    this.zQt = h.diG;
    com.tencent.mm.bt.b localb = this.zQp;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(h.diL, 2, null);
      AppMethodBeat.o(237288);
      return;
    }
    AppMethodBeat.o(237288);
  }
  
  public final void eKB()
  {
    AppMethodBeat.i(75535);
    this.zQt = h.diG;
    com.tencent.mm.bt.b localb = this.zQp;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(h.diL, 1, null);
      AppMethodBeat.o(75535);
      return;
    }
    AppMethodBeat.o(75535);
  }
  
  public final ab eKz()
  {
    AppMethodBeat.i(169938);
    ab localab = (ab)this.zQn.getValue();
    AppMethodBeat.o(169938);
    return localab;
  }
  
  public final ab eow()
  {
    AppMethodBeat.i(169937);
    ab localab = (ab)this.zQm.getValue();
    AppMethodBeat.o(169937);
    return localab;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75538);
    if (this.zQt == h.diL)
    {
      eKB();
      AppMethodBeat.o(75538);
      return true;
    }
    AppMethodBeat.o(75538);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237290);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237290);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75537);
    eow().onDestroy();
    eKz().onDestroy();
    this.zQv.removeAllViews();
    this.zQv.setVisibility(8);
    com.tencent.mm.bt.b localb = this.zQp;
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
    this.zQt = h.diG;
    com.tencent.mm.bt.b localb = this.zQp;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(h.diG);
    }
    localb = this.zQp;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(h.diG, -1, null);
      AppMethodBeat.o(75536);
      return;
    }
    AppMethodBeat.o(75536);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-recordvideo_release"})
  public static final class b
    implements u
  {
    b(long paramLong, boolean paramBoolean) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      Object localObject2 = null;
      AppMethodBeat.i(75528);
      Log.i("MicroMsg.EditPhotoPluginLayout", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + Util.ticksToNow(l));
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
        Log.i("MicroMsg.EditPhotoPluginLayout", "photo width: " + paramBitmap.getWidth() + "  height:" + paramBitmap.getHeight());
        Object localObject3 = Bitmap.CompressFormat.JPEG;
        localObject1 = j.b(this.BQw);
        if (localObject1 != null)
        {
          localObject1 = ((RecordConfigProvider)localObject1).BOC;
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, (Bitmap.CompressFormat)localObject3, (String)localObject1, true);
          localObject1 = new StringBuilder("saveBitmapToImage  cost:").append(Util.ticksToNow(l)).append("  path:");
          localObject3 = j.b(this.BQw);
          paramBitmap = localObject2;
          if (localObject3 != null) {
            paramBitmap = ((RecordConfigProvider)localObject3).BOC;
          }
          Log.i("MicroMsg.EditPhotoPluginLayout", paramBitmap);
          j.a(this.BQw);
          paramBitmap = com.tencent.mm.plugin.recordvideo.e.c.Cic;
          paramBitmap = j.b(this.BQw);
          localObject1 = j.c(this.BQw);
          if (localObject1 == null) {
            break label341;
          }
        }
        label341:
        for (paramBoolean = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqf;; paramBoolean = false)
        {
          com.tencent.mm.plugin.recordvideo.e.c.b(paramBitmap, paramBoolean, this.BQx);
          Log.d("MicroMsg.EditPhotoPluginLayout", "new ThreadPool  cost:" + Util.ticksToNow(l));
          MMHandlerThread.postToMainThread((Runnable)new a(this));
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
      Log.e("MicroMsg.EditPhotoPluginLayout", "photoEditor onError: %s", new Object[] { paramException });
      paramException = e.ilC;
      e.aNQ();
      paramException = e.ilC;
      e.zL(Util.ticksToNow(l));
      j.a(this.BQw);
      AppMethodBeat.o(75527);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1$onSuccess$1$1"})
    static final class a
      implements Runnable
    {
      a(j.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(75526);
        CaptureDataManager localCaptureDataManager = CaptureDataManager.BOb;
        Context localContext = j.d(this.BQy.BQw);
        Boolean localBoolean1 = Boolean.TRUE;
        Object localObject = j.b(this.BQy.BQw);
        if (localObject != null) {}
        for (localObject = ((RecordConfigProvider)localObject).BOC;; localObject = null)
        {
          Boolean localBoolean2 = Boolean.TRUE;
          com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          localCaptureDataManager.a(localContext, new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", (String)localObject, Long.valueOf(-1L), localBoolean2, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
          AppMethodBeat.o(75526);
          return;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-recordvideo_release"})
  public static final class c
    implements a.c
  {
    public final boolean b(com.tencent.mm.z.f paramf)
    {
      AppMethodBeat.i(163429);
      p.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.hoI);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.BQw.wgr.a(d.c.BVd, localBundle);
      AppMethodBeat.o(163429);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-recordvideo_release"})
  public static final class d
    implements z
  {
    public final void a(h paramh)
    {
      AppMethodBeat.i(163431);
      p.h(paramh, "features");
      Log.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedFeature] features:%s", new Object[] { paramh.name() });
      if (paramh == h.diG) {
        d.b.a(this.BQw.wgr, d.c.BVS);
      }
      AppMethodBeat.o(163431);
    }
    
    public final void a(h paramh, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(163432);
      p.h(paramh, "features");
      Log.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramh.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(163432);
    }
    
    public final void cH(boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class e
    implements b.a
  {
    public e(j paramj) {}
    
    public final boolean q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(75534);
      j localj = this.BQw;
      p.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(75534);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class f
    implements b.a
  {
    public f(j paramj) {}
    
    public final boolean q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(163433);
      j localj = this.BQw;
      p.g(paramMotionEvent, "it");
      j.a(localj, paramMotionEvent);
      AppMethodBeat.o(163433);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements a<ab>
  {
    public static final g BQz;
    
    static
    {
      AppMethodBeat.i(169934);
      BQz = new g();
      AppMethodBeat.o(169934);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements a<ab>
  {
    public static final h BQA;
    
    static
    {
      AppMethodBeat.i(169936);
      BQA = new h();
      AppMethodBeat.o(169936);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.j
 * JD-Core Version:    0.7.0.1
 */