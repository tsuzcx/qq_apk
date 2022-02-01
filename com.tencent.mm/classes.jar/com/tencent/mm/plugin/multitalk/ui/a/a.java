package com.tencent.mm.plugin.multitalk.ui.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.ab.a.a;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.h;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.footer.c;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "addTextDoneCallback", "Lkotlin/Function0;", "", "getAddTextDoneCallback", "()Lkotlin/jvm/functions/Function0;", "setAddTextDoneCallback", "(Lkotlin/jvm/functions/Function0;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/MultiTalkDrawingView;", "getDrawingView", "()Lcom/tencent/mm/view/MultiTalkDrawingView;", "setDrawingView", "(Lcom/tencent/mm/view/MultiTalkDrawingView;)V", "editBitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getEditBitmapCallback", "()Lkotlin/jvm/functions/Function1;", "setEditBitmapCallback", "(Lkotlin/jvm/functions/Function1;)V", "editCache", "", "isFinishing", "", "isLoad", "()Z", "setLoad", "(Z)V", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cancelTextAdd", "clearCache", "clearScreen", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadEditLayout", "loadPhotoEditLogic", "isLandscape", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "onViewStatusChange", "zoom", "transX", "transY", "refreshEditLayout", "callback", "orientation", "release", "reset", "setDrawingEnable", "enable", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-multitalk_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.plugin.t
{
  public static final a.a zQx;
  final Context context;
  private boolean gMK;
  boolean isFinishing;
  int sTB;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  ab zCl;
  private final kotlin.f zQm;
  private final kotlin.f zQn;
  public com.tencent.mm.view.l zQo;
  com.tencent.mm.bt.b zQp;
  public String zQq;
  kotlin.g.a.a<x> zQr;
  public boolean zQs;
  h zQt;
  kotlin.g.a.b<? super Bitmap, x> zQu;
  private FrameLayout zQv;
  private e zQw;
  
  static
  {
    AppMethodBeat.i(239739);
    zQx = new a.a((byte)0);
    AppMethodBeat.o(239739);
  }
  
  public a(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, e parame)
  {
    AppMethodBeat.i(239738);
    this.zQv = paramFrameLayout;
    this.wgr = paramd;
    this.zQw = parame;
    this.zQm = g.ah((kotlin.g.a.a)g.zQA);
    this.zQn = g.ah((kotlin.g.a.a)f.zQz);
    this.context = this.zQv.getContext();
    this.zQq = String.valueOf(System.currentTimeMillis() + hashCode());
    this.zQt = h.diG;
    this.sTB = -1;
    AppMethodBeat.o(239738);
  }
  
  private final ab eow()
  {
    AppMethodBeat.i(239733);
    ab localab = (ab)this.zQm.getValue();
    AppMethodBeat.o(239733);
    return localab;
  }
  
  public final void aSs() {}
  
  public final void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    boolean bool = false;
    AppMethodBeat.i(239734);
    p.h(paramb, "config");
    this.zQs = true;
    this.zQv.setVisibility(0);
    this.zCl = eow();
    if (this.zQq == null) {
      this.zQq = String.valueOf(System.currentTimeMillis() + hashCode());
    }
    Object localObject = this.zCl;
    if (localObject != null) {
      ((ab)localObject).a(new ab.a.a().cJ(true).VH().a(ab.c.dja).cK(false).i(paramb.rect).VI().fN(this.zQq).VJ());
    }
    paramb = this.zCl;
    if (paramb != null) {}
    for (paramb = paramb.bB(this.context); paramb == null; paramb = null)
    {
      paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.MultiTalkDrawingView");
      AppMethodBeat.o(239734);
      throw paramb;
    }
    this.zQo = ((com.tencent.mm.view.l)paramb);
    paramb = this.zQo;
    if (paramb != null)
    {
      paramb = (com.tencent.mm.view.b.b)paramb.getBaseBoardView();
      if (paramb != null)
      {
        localObject = this.zQw;
        if (localObject != null) {
          bool = ((e)localObject).Ry(9);
        }
        paramb.DF(bool);
      }
    }
    paramb = this.zQo;
    if (paramb != null)
    {
      paramb = (c)paramb.getBaseFooterView();
      if (paramb != null) {
        paramb.setHideFooter(true);
      }
    }
    paramb = this.zQo;
    if (paramb == null)
    {
      paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.MultiTalkDrawingView");
      AppMethodBeat.o(239734);
      throw paramb;
    }
    this.zQp = paramb.getPresenter();
    paramb = this.zQp;
    if (paramb == null)
    {
      paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
      AppMethodBeat.o(239734);
      throw paramb;
    }
    ((com.tencent.mm.bt.a)paramb).Kyn = ((com.tencent.mm.bt.a.c)new c(this));
    paramb = new FrameLayout.LayoutParams(-1, -1);
    this.zQv.addView((View)this.zQo, (ViewGroup.LayoutParams)paramb);
    paramb = this.zQo;
    if (paramb != null) {
      paramb.setSelectedFeatureListener((z)new d(this));
    }
    paramb = this.zQp;
    if (paramb != null)
    {
      paramb = (com.tencent.mm.e.d)paramb.c(h.diH);
      if (paramb != null)
      {
        paramb.a((b.a)new e(this));
        AppMethodBeat.o(239734);
        return;
      }
    }
    AppMethodBeat.o(239734);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(239737);
    if (this.zQt == h.diL)
    {
      this.zQt = h.diG;
      com.tencent.mm.bt.b localb = this.zQp;
      if (localb != null) {
        localb.getSelectedFeatureListener().a(h.diL, 1, null);
      }
      AppMethodBeat.o(239737);
      return true;
    }
    AppMethodBeat.o(239737);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(239740);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(239740);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(239736);
    eow().onDestroy();
    ((ab)this.zQn.getValue()).onDestroy();
    this.zQv.removeAllViews();
    this.zQv.setVisibility(8);
    com.tencent.mm.bt.b localb = this.zQp;
    if (localb != null)
    {
      localb.onDestroy();
      AppMethodBeat.o(239736);
      return;
    }
    AppMethodBeat.o(239736);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(239735);
    this.zQt = h.diG;
    com.tencent.mm.bt.b localb = this.zQp;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(h.diG);
    }
    localb = this.zQp;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(h.diG, -1, null);
      AppMethodBeat.o(239735);
      return;
    }
    AppMethodBeat.o(239735);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "p0", "Ljava/lang/Exception;", "onSuccess", "Landroid/graphics/Bitmap;", "p1", "", "plugin-multitalk_release"})
  public static final class b
    implements u
  {
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(239722);
      if (paramBitmap != null)
      {
        kotlin.g.a.b localb = this.zQy.zQu;
        if (localb != null)
        {
          localb.invoke(paramBitmap);
          AppMethodBeat.o(239722);
          return;
        }
      }
      AppMethodBeat.o(239722);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(239723);
      Log.e("MicroMsg.MultiTalkEditPhotoContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      a.a(this.zQy);
      AppMethodBeat.o(239723);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$loadEditLayout$1", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-multitalk_release"})
  public static final class c
    implements com.tencent.mm.bt.a.c
  {
    public final boolean b(com.tencent.mm.z.f paramf)
    {
      AppMethodBeat.i(239724);
      p.h(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.hoI);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.zQy.wgr.a(d.c.BVd, localBundle);
      AppMethodBeat.o(239724);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$loadEditLayout$2", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-multitalk_release"})
  public static final class d
    implements z
  {
    public final void a(h paramh)
    {
      AppMethodBeat.i(239726);
      p.h(paramh, "features");
      Log.i("MicroMsg.MultiTalkEditPhotoContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { paramh.name() });
      if (paramh == h.diG) {
        d.b.a(this.zQy.wgr, d.c.BVS);
      }
      AppMethodBeat.o(239726);
    }
    
    public final void a(h paramh, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(239727);
      p.h(paramh, "features");
      Log.i("MicroMsg.MultiTalkEditPhotoContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramh.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(239727);
    }
    
    public final void cH(boolean paramBoolean) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class e
    implements b.a
  {
    e(a parama) {}
    
    public final boolean q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(239728);
      a locala = this.zQy;
      p.g(paramMotionEvent, "it");
      a.a(locala, paramMotionEvent);
      AppMethodBeat.o(239728);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ab>
  {
    public static final f zQz;
    
    static
    {
      AppMethodBeat.i(239730);
      zQz = new f();
      AppMethodBeat.o(239730);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ab>
  {
    public static final g zQA;
    
    static
    {
      AppMethodBeat.i(239732);
      zQA = new g();
      AppMethodBeat.o(239732);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.a
 * JD-Core Version:    0.7.0.1
 */