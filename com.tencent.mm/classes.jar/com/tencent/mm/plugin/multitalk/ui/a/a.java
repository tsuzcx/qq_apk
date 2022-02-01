package com.tencent.mm.plugin.multitalk.ui.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a.a;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.api.i;
import com.tencent.mm.api.w;
import com.tencent.mm.e.d;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.footer.c;
import com.tencent.mm.view.l;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "addTextDoneCallback", "Lkotlin/Function0;", "", "getAddTextDoneCallback", "()Lkotlin/jvm/functions/Function0;", "setAddTextDoneCallback", "(Lkotlin/jvm/functions/Function0;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/MultiTalkDrawingView;", "getDrawingView", "()Lcom/tencent/mm/view/MultiTalkDrawingView;", "setDrawingView", "(Lcom/tencent/mm/view/MultiTalkDrawingView;)V", "editBitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getEditBitmapCallback", "()Lkotlin/jvm/functions/Function1;", "setEditBitmapCallback", "(Lkotlin/jvm/functions/Function1;)V", "editCache", "", "isFinishing", "", "isLoad", "()Z", "setLoad", "(Z)V", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "color", "bgcolor", "cancelTextAdd", "clearCache", "clearScreen", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadEditLayout", "loadPhotoEditLogic", "isLandscape", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "onViewStatusChange", "zoom", "transX", "transY", "refreshEditLayout", "callback", "orientation", "release", "reset", "setDrawingEnable", "enable", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements v
{
  public static final a.a Lsa;
  com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  ac LcI;
  private FrameLayout Lsb;
  private e Lsc;
  private final j Lsd;
  private final j Lse;
  public l Lsf;
  com.tencent.mm.bt.b Lsg;
  public String Lsh;
  kotlin.g.a.a<ah> Lsi;
  private boolean Lsj;
  i Lsk;
  kotlin.g.a.b<? super Bitmap, ah> Lsl;
  final Context context;
  boolean isFinishing;
  private boolean mat;
  int zVI;
  
  static
  {
    AppMethodBeat.i(285336);
    Lsa = new a.a((byte)0);
    AppMethodBeat.o(285336);
  }
  
  public a(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, e parame)
  {
    AppMethodBeat.i(285304);
    this.Lsb = paramFrameLayout;
    this.GrC = parama;
    this.Lsc = parame;
    this.Lsd = k.cm((kotlin.g.a.a)a.f.Lso);
    this.Lse = k.cm((kotlin.g.a.a)a.e.Lsn);
    this.context = this.Lsb.getContext();
    this.Lsh = String.valueOf(System.currentTimeMillis() + hashCode());
    this.Lsk = i.hdN;
    this.zVI = -1;
    AppMethodBeat.o(285304);
  }
  
  private static final boolean a(a parama, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(285323);
    s.u(parama, "this$0");
    s.s(paramMotionEvent, "it");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(285323);
      return false;
      parama.mat = false;
      continue;
      if (parama.mat)
      {
        com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(parama.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPb);
      }
      else
      {
        com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(parama.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOZ);
        continue;
        parama.mat = true;
        com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(parama.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPa);
      }
    }
  }
  
  private final ac ghj()
  {
    AppMethodBeat.i(285311);
    Object localObject = this.Lsd.getValue();
    s.s(localObject, "<get-mPortraitPhotoEditor>(...)");
    localObject = (ac)localObject;
    AppMethodBeat.o(285311);
    return localObject;
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(285378);
    s.u(paramb, "config");
    if (!this.Lsj)
    {
      b(paramb);
      paramb = this.Lsf;
      if (paramb != null)
      {
        paramb = (com.tencent.mm.view.b.b)paramb.getBaseBoardView();
        if (paramb != null)
        {
          paramb.jMQ();
          paramb.invalidate();
          paramb.callback = parama;
          paramb.agKV = true;
        }
      }
      AppMethodBeat.o(285378);
      return;
    }
    paramb = paramb.rect;
    if (paramb == null) {}
    for (paramb = null;; paramb = paramb.toShortString())
    {
      Log.printInfoStack("MicroMsg.MultiTalkEditPhotoContainerPlugin", "config is %s", new Object[] { paramb });
      break;
    }
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(285384);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(285384);
  }
  
  public final void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    boolean bool = false;
    AppMethodBeat.i(285353);
    s.u(paramb, "config");
    this.Lsj = true;
    this.Lsb.setVisibility(0);
    this.LcI = ghj();
    if (this.Lsh == null) {
      this.Lsh = String.valueOf(System.currentTimeMillis() + hashCode());
    }
    Object localObject = this.LcI;
    if (localObject != null)
    {
      ac.a.a locala = new ac.a.a().dR(true).dQ(false).a(ac.c.heh).dS(false);
      paramb = paramb.rect;
      locala.hee.hed = paramb;
      locala.hee.backgroundColor = 0;
      ((ac)localObject).a(locala.hX(this.Lsh).hee);
    }
    paramb = this.LcI;
    if (paramb == null) {}
    for (paramb = null; paramb == null; paramb = paramb.cn(this.context))
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.MultiTalkDrawingView");
      AppMethodBeat.o(285353);
      throw paramb;
    }
    this.Lsf = ((l)paramb);
    paramb = this.Lsf;
    if (paramb != null)
    {
      paramb = (com.tencent.mm.view.b.b)paramb.getBaseBoardView();
      if (paramb != null)
      {
        localObject = this.Lsc;
        if (localObject != null) {
          break label271;
        }
        paramb.Oa(bool);
      }
    }
    paramb = this.Lsf;
    if (paramb == null) {}
    for (paramb = null;; paramb = (c)paramb.getBaseFooterView())
    {
      if (paramb != null) {
        paramb.setHideFooter(true);
      }
      paramb = this.Lsf;
      if (paramb != null) {
        break label292;
      }
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.MultiTalkDrawingView");
      AppMethodBeat.o(285353);
      throw paramb;
      label271:
      bool = ((e)localObject).abZ(9);
      break;
    }
    label292:
    this.Lsg = paramb.getPresenter();
    paramb = this.Lsg;
    if (paramb == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
      AppMethodBeat.o(285353);
      throw paramb;
    }
    ((com.tencent.mm.bt.a)paramb).YwB = ((com.tencent.mm.bt.a.c)new c(this));
    paramb = new FrameLayout.LayoutParams(-1, -1);
    this.Lsb.addView((View)this.Lsf, (ViewGroup.LayoutParams)paramb);
    paramb = this.Lsf;
    if (paramb != null) {
      paramb.setSelectedFeatureListener((aa)new d(this));
    }
    paramb = this.Lsg;
    if (paramb != null)
    {
      paramb = (d)paramb.c(i.hdO);
      if (paramb != null) {
        paramb.a(new a..ExternalSyntheticLambda0(this));
      }
    }
    AppMethodBeat.o(285353);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(285401);
    s.u(this, "this");
    AppMethodBeat.o(285401);
  }
  
  public final String name()
  {
    AppMethodBeat.i(285390);
    String str = v.a.b(this);
    AppMethodBeat.o(285390);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(285396);
    s.u(this, "this");
    AppMethodBeat.o(285396);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(285370);
    if (this.Lsk == i.hdS)
    {
      this.Lsk = i.hdN;
      Object localObject = this.Lsg;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
        if (localObject != null) {
          ((aa)localObject).a(i.hdS, 1, null);
        }
      }
      AppMethodBeat.o(285370);
      return true;
    }
    AppMethodBeat.o(285370);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(285406);
    s.u(this, "this");
    AppMethodBeat.o(285406);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(285409);
    s.u(this, "this");
    AppMethodBeat.o(285409);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(285415);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(285415);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(285419);
    s.u(this, "this");
    AppMethodBeat.o(285419);
  }
  
  public final void release()
  {
    AppMethodBeat.i(285365);
    ghj().onDestroy();
    Object localObject = this.Lse.getValue();
    s.s(localObject, "<get-mLandscapePhotoEditor>(...)");
    ((ac)localObject).onDestroy();
    this.Lsb.removeAllViews();
    this.Lsb.setVisibility(8);
    localObject = this.Lsg;
    if (localObject != null) {
      ((com.tencent.mm.bt.b)localObject).onDestroy();
    }
    AppMethodBeat.o(285365);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(285357);
    this.Lsk = i.hdN;
    Object localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdN);
      }
    }
    localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdN, -1, null);
      }
    }
    AppMethodBeat.o(285357);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(285422);
    s.u(this, "this");
    AppMethodBeat.o(285422);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "p0", "Ljava/lang/Exception;", "onSuccess", "Landroid/graphics/Bitmap;", "p1", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements w
  {
    b(a parama) {}
    
    public final void b(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(285320);
      if (paramBitmap != null)
      {
        kotlin.g.a.b localb = this.Lsm.Lsl;
        if (localb != null) {
          localb.invoke(paramBitmap);
        }
      }
      AppMethodBeat.o(285320);
    }
    
    public final void f(Exception paramException)
    {
      AppMethodBeat.i(285327);
      Log.e("MicroMsg.MultiTalkEditPhotoContainerPlugin", "photoEditor onError: %s", new Object[] { paramException });
      a.a(this.Lsm);
      AppMethodBeat.o(285327);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$loadEditLayout$1", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.bt.a.c
  {
    c(a parama) {}
    
    public final boolean b(f paramf)
    {
      AppMethodBeat.i(285316);
      s.u(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.mAC);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.Lsm.GrC.a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOw, localBundle);
      AppMethodBeat.o(285316);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$loadEditLayout$2", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements aa
  {
    d(a parama) {}
    
    public final void a(i parami)
    {
      AppMethodBeat.i(285321);
      s.u(parami, "features");
      Log.i("MicroMsg.MultiTalkEditPhotoContainerPlugin", "[onSelectedFeature] features:%s", new Object[] { parami.name() });
      if (parami == i.hdN) {
        com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.Lsm.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPm);
      }
      AppMethodBeat.o(285321);
    }
    
    public final void a(i parami, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(285335);
      s.u(parami, "features");
      Log.i("MicroMsg.MultiTalkEditPhotoContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { parami.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(285335);
    }
    
    public final void dP(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a.a
 * JD-Core Version:    0.7.0.1
 */