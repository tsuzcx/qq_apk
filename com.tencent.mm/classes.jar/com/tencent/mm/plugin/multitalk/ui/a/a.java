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
import com.tencent.mm.api.z;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.footer.c;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "addTextDoneCallback", "Lkotlin/Function0;", "", "getAddTextDoneCallback", "()Lkotlin/jvm/functions/Function0;", "setAddTextDoneCallback", "(Lkotlin/jvm/functions/Function0;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/MultiTalkDrawingView;", "getDrawingView", "()Lcom/tencent/mm/view/MultiTalkDrawingView;", "setDrawingView", "(Lcom/tencent/mm/view/MultiTalkDrawingView;)V", "editBitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getEditBitmapCallback", "()Lkotlin/jvm/functions/Function1;", "setEditBitmapCallback", "(Lkotlin/jvm/functions/Function1;)V", "editCache", "", "isFinishing", "", "isLoad", "()Z", "setLoad", "(Z)V", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "color", "bgcolor", "cancelTextAdd", "clearCache", "clearScreen", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadEditLayout", "loadPhotoEditLogic", "isLandscape", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "onViewStatusChange", "zoom", "transX", "transY", "refreshEditLayout", "callback", "orientation", "release", "reset", "setDrawingEnable", "enable", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-multitalk_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.plugin.u
{
  public static final a Fwa;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  ab Fhh;
  private final kotlin.f FvP;
  private final kotlin.f FvQ;
  public com.tencent.mm.view.l FvR;
  com.tencent.mm.ca.b FvS;
  public String FvT;
  kotlin.g.a.a<x> FvU;
  public boolean FvV;
  h FvW;
  kotlin.g.a.b<? super Bitmap, x> FvX;
  private FrameLayout FvY;
  private e FvZ;
  final Context context;
  boolean isFinishing;
  private boolean jwZ;
  int wzx;
  
  static
  {
    AppMethodBeat.i(196524);
    Fwa = new a((byte)0);
    AppMethodBeat.o(196524);
  }
  
  public a(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd, e parame)
  {
    AppMethodBeat.i(196523);
    this.FvY = paramFrameLayout;
    this.APl = paramd;
    this.FvZ = parame;
    this.FvP = g.ar((kotlin.g.a.a)g.Fwd);
    this.FvQ = g.ar((kotlin.g.a.a)f.Fwc);
    this.context = this.FvY.getContext();
    this.FvT = String.valueOf(System.currentTimeMillis() + hashCode());
    this.FvW = h.fam;
    this.wzx = -1;
    AppMethodBeat.o(196523);
  }
  
  private final ab eYo()
  {
    AppMethodBeat.i(196507);
    ab localab = (ab)this.FvP.getValue();
    AppMethodBeat.o(196507);
    return localab;
  }
  
  public final void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    boolean bool = false;
    AppMethodBeat.i(196514);
    p.k(paramb, "config");
    this.FvV = true;
    this.FvY.setVisibility(0);
    this.Fhh = eYo();
    if (this.FvT == null) {
      this.FvT = String.valueOf(System.currentTimeMillis() + hashCode());
    }
    Object localObject = this.Fhh;
    if (localObject != null) {
      ((ab)localObject).a(new ab.a.a().df(true).aac().a(ab.c.faH).dg(false).n(paramb.byG).aad().gx(this.FvT).aae());
    }
    paramb = this.Fhh;
    if (paramb != null) {}
    for (paramb = paramb.bA(this.context); paramb == null; paramb = null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.view.MultiTalkDrawingView");
      AppMethodBeat.o(196514);
      throw paramb;
    }
    this.FvR = ((com.tencent.mm.view.l)paramb);
    paramb = this.FvR;
    if (paramb != null)
    {
      paramb = (com.tencent.mm.view.b.b)paramb.getBaseBoardView();
      if (paramb != null)
      {
        localObject = this.FvZ;
        if (localObject != null) {
          bool = ((e)localObject).XP(9);
        }
        paramb.If(bool);
      }
    }
    paramb = this.FvR;
    if (paramb != null)
    {
      paramb = (c)paramb.getBaseFooterView();
      if (paramb != null) {
        paramb.setHideFooter(true);
      }
    }
    paramb = this.FvR;
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.view.MultiTalkDrawingView");
      AppMethodBeat.o(196514);
      throw paramb;
    }
    this.FvS = paramb.getPresenter();
    paramb = this.FvS;
    if (paramb == null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
      AppMethodBeat.o(196514);
      throw paramb;
    }
    ((com.tencent.mm.ca.a)paramb).RAb = ((com.tencent.mm.ca.a.c)new c(this));
    paramb = new FrameLayout.LayoutParams(-1, -1);
    this.FvY.addView((View)this.FvR, (ViewGroup.LayoutParams)paramb);
    paramb = this.FvR;
    if (paramb != null) {
      paramb.setSelectedFeatureListener((z)new d(this));
    }
    paramb = this.FvS;
    if (paramb != null)
    {
      paramb = (com.tencent.mm.e.d)paramb.c(h.fan);
      if (paramb != null)
      {
        paramb.a((b.a)new e(this));
        AppMethodBeat.o(196514);
        return;
      }
    }
    AppMethodBeat.o(196514);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(196525);
    String str = getClass().getName();
    AppMethodBeat.o(196525);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(196520);
    if (this.FvW == h.far)
    {
      this.FvW = h.fam;
      com.tencent.mm.ca.b localb = this.FvS;
      if (localb != null) {
        localb.getSelectedFeatureListener().a(h.far, 1, null);
      }
      AppMethodBeat.o(196520);
      return true;
    }
    AppMethodBeat.o(196520);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196528);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196528);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(196517);
    eYo().onDestroy();
    ((ab)this.FvQ.getValue()).onDestroy();
    this.FvY.removeAllViews();
    this.FvY.setVisibility(8);
    com.tencent.mm.ca.b localb = this.FvS;
    if (localb != null)
    {
      localb.onDestroy();
      AppMethodBeat.o(196517);
      return;
    }
    AppMethodBeat.o(196517);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(196516);
    this.FvW = h.fam;
    com.tencent.mm.ca.b localb = this.FvS;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(h.fam);
    }
    localb = this.FvS;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(h.fam, -1, null);
      AppMethodBeat.o(196516);
      return;
    }
    AppMethodBeat.o(196516);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "p0", "Ljava/lang/Exception;", "onSuccess", "Landroid/graphics/Bitmap;", "p1", "", "plugin-multitalk_release"})
  public static final class b
    implements com.tencent.mm.api.u
  {
    public final void a(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(204061);
      if (paramBitmap != null)
      {
        kotlin.g.a.b localb = this.Fwb.FvX;
        if (localb != null)
        {
          localb.invoke(paramBitmap);
          AppMethodBeat.o(204061);
          return;
        }
      }
      AppMethodBeat.o(204061);
    }
    
    public final void onError(Exception paramException)
    {
      AppMethodBeat.i(204063);
      Log.e("MicroMsg.MultiTalkEditPhotoContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      a.a(this.Fwb);
      AppMethodBeat.o(204063);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$loadEditLayout$1", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-multitalk_release"})
  public static final class c
    implements com.tencent.mm.ca.a.c
  {
    public final boolean b(com.tencent.mm.ab.f paramf)
    {
      AppMethodBeat.i(197121);
      p.k(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.kaz);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.Fwb.APl.a(d.c.HRQ, localBundle);
      AppMethodBeat.o(197121);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$loadEditLayout$2", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-multitalk_release"})
  public static final class d
    implements z
  {
    public final void a(h paramh)
    {
      AppMethodBeat.i(202562);
      p.k(paramh, "features");
      Log.i("MicroMsg.MultiTalkEditPhotoContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { paramh.name() });
      if (paramh == h.fam) {
        d.b.a(this.Fwb.APl, d.c.HSG);
      }
      AppMethodBeat.o(202562);
    }
    
    public final void a(h paramh, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(202565);
      p.k(paramh, "features");
      Log.i("MicroMsg.MultiTalkEditPhotoContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramh.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(202565);
    }
    
    public final void dd(boolean paramBoolean) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  static final class e
    implements b.a
  {
    e(a parama) {}
    
    public final boolean q(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(202755);
      a locala = this.Fwb;
      p.j(paramMotionEvent, "it");
      a.a(locala, paramMotionEvent);
      AppMethodBeat.o(202755);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ab>
  {
    public static final f Fwc;
    
    static
    {
      AppMethodBeat.i(206676);
      Fwc = new f();
      AppMethodBeat.o(206676);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ab>
  {
    public static final g Fwd;
    
    static
    {
      AppMethodBeat.i(199649);
      Fwd = new g();
      AppMethodBeat.o(199649);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.a
 * JD-Core Version:    0.7.0.1
 */