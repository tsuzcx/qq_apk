package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a.a;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.api.i;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y;
import com.tencent.mm.e.h;
import com.tencent.mm.plugin.recordvideo.f.g;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "isFinishing", "", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "", "color", "bgcolor", "font", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadPhotoEditLogic", "path", "onBackPress", "release", "reset", "setOutputSize", "width", "height", "setup", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements v
{
  public static final l.a NKe;
  com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private ac LcI;
  private FrameLayout Lsb;
  private final kotlin.j Lsd;
  private final kotlin.j Lse;
  public com.tencent.mm.bt.b Lsg;
  public i Lsk;
  public com.tencent.mm.media.widget.camerarecordview.b.b NKf;
  private com.tencent.mm.view.m NKg;
  private final Context context;
  private boolean isFinishing;
  private boolean mat;
  public RecordConfigProvider oaV;
  public int zVI;
  
  static
  {
    AppMethodBeat.i(75540);
    NKe = new l.a((byte)0);
    AppMethodBeat.o(75540);
  }
  
  public l(FrameLayout paramFrameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75539);
    this.Lsb = paramFrameLayout;
    this.GrC = parama;
    this.Lsd = kotlin.k.cm((kotlin.g.a.a)l.f.NKl);
    this.Lse = kotlin.k.cm((kotlin.g.a.a)l.e.NKk);
    this.context = this.Lsb.getContext();
    this.Lsk = i.hdN;
    this.zVI = -1;
    AppMethodBeat.o(75539);
  }
  
  private static final boolean a(l paraml, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280877);
    s.u(paraml, "this$0");
    s.s(paramMotionEvent, "it");
    paraml.aj(paramMotionEvent);
    AppMethodBeat.o(280877);
    return false;
  }
  
  private final void aj(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280874);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(280874);
      return;
      this.mat = false;
      AppMethodBeat.o(280874);
      return;
      if (this.mat)
      {
        a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPb);
        AppMethodBeat.o(280874);
        return;
      }
      a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOZ);
      AppMethodBeat.o(280874);
      return;
      this.mat = true;
      a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPa);
    }
  }
  
  private static final boolean b(l paraml, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280881);
    s.u(paraml, "this$0");
    s.s(paramMotionEvent, "it");
    paraml.aj(paramMotionEvent);
    AppMethodBeat.o(280881);
    return false;
  }
  
  private final ac gIz()
  {
    AppMethodBeat.i(169938);
    Object localObject = this.Lse.getValue();
    s.s(localObject, "<get-mLandscapePhotoEditor>(...)");
    localObject = (ac)localObject;
    AppMethodBeat.o(169938);
    return localObject;
  }
  
  private final ac ghj()
  {
    AppMethodBeat.i(169937);
    Object localObject = this.Lsd.getValue();
    s.s(localObject, "<get-mPortraitPhotoEditor>(...)");
    localObject = (ac)localObject;
    AppMethodBeat.o(169937);
    return localObject;
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280977);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280977);
  }
  
  public final void aTc(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(280939);
    s.u(paramString, "path");
    this.Lsb.setVisibility(0);
    Object localObject1 = this.NKf;
    int i;
    label56:
    Object localObject2;
    label106:
    boolean bool1;
    if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nKe == true))
    {
      i = 1;
      if (i == 0) {
        break label285;
      }
      localObject1 = gIz();
      this.LcI = ((ac)localObject1);
      localObject1 = this.LcI;
      if (localObject1 != null)
      {
        localObject2 = new ac.a.a();
        Object localObject3 = this.oaV;
        if ((localObject3 == null) || (((RecordConfigProvider)localObject3).scene != 291)) {
          break label294;
        }
        i = 1;
        if (i != 0) {
          break label304;
        }
        localObject3 = this.oaV;
        if ((localObject3 == null) || (((RecordConfigProvider)localObject3).scene != 293)) {
          break label299;
        }
        i = 1;
        label134:
        if (i != 0) {
          break label304;
        }
        bool1 = true;
        label140:
        localObject2 = ((ac.a.a)localObject2).dR(bool1).dQ(false).t(new Rect(this.Lsb.getLeft(), this.Lsb.getTop(), this.Lsb.getRight(), this.Lsb.getBottom())).a(ac.c.heg);
        localObject3 = this.NKf;
        bool1 = bool2;
        if (localObject3 != null)
        {
          bool1 = bool2;
          if (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject3).nJW == true) {
            bool1 = true;
          }
        }
        ((ac)localObject1).a(((ac.a.a)localObject2).dS(bool1).hX(paramString).hee);
      }
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label309;
      }
    }
    label285:
    label294:
    label299:
    label304:
    label309:
    for (localObject1 = null;; localObject1 = ((ac)localObject1).cn(this.context))
    {
      if (localObject1 != null) {
        break label323;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
      AppMethodBeat.o(280939);
      throw paramString;
      i = 0;
      break;
      localObject1 = ghj();
      break label56;
      i = 0;
      break label106;
      i = 0;
      break label134;
      bool1 = false;
      break label140;
    }
    label323:
    this.NKg = ((com.tencent.mm.view.m)localObject1);
    localObject1 = this.oaV;
    if (localObject1 != null)
    {
      localObject1 = ((RecordConfigProvider)localObject1).oSS;
      if (localObject1 != null)
      {
        localObject2 = ((Bundle)localObject1).getFloatArray("matrix");
        if (localObject2 != null)
        {
          localObject1 = new Matrix();
          ((Matrix)localObject1).setValues((float[])localObject2);
          localObject2 = this.NKg;
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.view.m)localObject2).getBaseBoardView();
            if (localObject2 != null) {
              ((com.tencent.mm.view.b.a)localObject2).setForceMatrix((Matrix)localObject1);
            }
          }
        }
      }
    }
    localObject1 = this.NKg;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (com.tencent.mm.view.footer.c)((com.tencent.mm.view.m)localObject1).getBaseFooterView())
    {
      if (localObject1 != null) {
        ((com.tencent.mm.view.footer.c)localObject1).setHideFooter(true);
      }
      localObject1 = this.NKg;
      if (localObject1 != null) {
        break;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
      AppMethodBeat.o(280939);
      throw paramString;
    }
    this.Lsg = ((com.tencent.mm.view.m)localObject1).getPresenter();
    localObject1 = this.Lsg;
    if (localObject1 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
      AppMethodBeat.o(280939);
      throw paramString;
    }
    ((com.tencent.mm.bt.a)localObject1).YwB = ((com.tencent.mm.bt.a.c)new c(this));
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    this.Lsb.addView((View)this.NKg, (ViewGroup.LayoutParams)localObject1);
    localObject1 = this.NKg;
    if (localObject1 != null) {
      ((com.tencent.mm.view.m)localObject1).setSelectedFeatureListener((aa)new d(this));
    }
    localObject1 = this.Lsg;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.e.d)((com.tencent.mm.bt.b)localObject1).c(i.hdO);
      if (localObject1 != null) {
        ((com.tencent.mm.e.d)localObject1).a(new l..ExternalSyntheticLambda1(this));
      }
    }
    localObject1 = this.Lsg;
    if (localObject1 != null)
    {
      localObject1 = (h)((com.tencent.mm.bt.b)localObject1).c(i.hdR);
      if (localObject1 != null) {
        ((h)localObject1).a(new l..ExternalSyntheticLambda0(this));
      }
    }
    paramString = BitmapUtil.getImageOptions(paramString);
    if (paramString != null)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(paramString.outWidth));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(paramString.outHeight));
    }
    AppMethodBeat.o(280939);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280990);
    s.u(this, "this");
    AppMethodBeat.o(280990);
  }
  
  public final void fti()
  {
    Object localObject2 = null;
    AppMethodBeat.i(280954);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    localObject1 = this.LcI;
    label68:
    label108:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      s.checkNotNull(localObject1);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(((y)localObject1).aBy()));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label469;
      }
      localObject1 = null;
      s.checkNotNull(localObject1);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(((y)localObject1).aBx()));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label479;
      }
      localObject1 = null;
      s.checkNotNull(localObject1);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(((y)localObject1).aBA()));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label489;
      }
      localObject1 = null;
      label148:
      s.checkNotNull(localObject1);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(((y)localObject1).aBE()));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label499;
      }
      localObject1 = null;
      label188:
      s.checkNotNull(localObject1);
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(((y)localObject1).aBz()));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label509;
      }
      localObject1 = null;
      label228:
      s.checkNotNull(localObject1);
      if (!((y)localObject1).aBD()) {
        break label519;
      }
      i = 1;
      label245:
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ROTATE_INT", Integer.valueOf(i));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      localObject1 = g.NRB;
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label524;
      }
      localObject1 = null;
      label289:
      s.checkNotNull(localObject1);
      i = ((y)localObject1).aBy();
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label534;
      }
      localObject1 = null;
      label316:
      s.checkNotNull(localObject1);
      g.M(new int[] { i, ((y)localObject1).aBx(), -1 });
      localObject1 = g.NRB;
      g.aQ(1, 2L);
      localObject1 = this.LcI;
      if (localObject1 != null) {
        break label544;
      }
    }
    final boolean bool;
    label519:
    label524:
    label534:
    label544:
    for (localObject1 = localObject2;; localObject1 = ((ac)localObject1).aAy())
    {
      s.checkNotNull(localObject1);
      bool = ((y)localObject1).aBF();
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(bool));
      if (bool)
      {
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqX();
      }
      localObject1 = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bre();
      if (this.isFinishing) {
        break label565;
      }
      localObject1 = this.context;
      if (localObject1 != null) {
        break label554;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(280954);
      throw ((Throwable)localObject1);
      localObject1 = ((ac)localObject1).aAy();
      break;
      label469:
      localObject1 = ((ac)localObject1).aAy();
      break label68;
      label479:
      localObject1 = ((ac)localObject1).aAy();
      break label108;
      label489:
      localObject1 = ((ac)localObject1).aAy();
      break label148;
      label499:
      localObject1 = ((ac)localObject1).aAy();
      break label188;
      label509:
      localObject1 = ((ac)localObject1).aAy();
      break label228;
      i = 0;
      break label245;
      localObject1 = ((ac)localObject1).aAy();
      break label289;
      localObject1 = ((ac)localObject1).aAy();
      break label316;
    }
    label554:
    if (((Activity)localObject1).isFinishing())
    {
      label565:
      AppMethodBeat.o(280954);
      return;
    }
    this.isFinishing = true;
    long l = Util.currentTicks();
    Log.i("MicroMsg.EditPhotoPluginLayout", "dofinish time: " + l + ' ' + bool);
    localObject1 = this.LcI;
    if (localObject1 != null) {
      ((ac)localObject1).a((w)new b(l, this, bool));
    }
    AppMethodBeat.o(280954);
  }
  
  public final void gIA()
  {
    AppMethodBeat.i(280943);
    this.Lsk = i.hdN;
    Object localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdS, 2, null);
      }
    }
    AppMethodBeat.o(280943);
  }
  
  public final void gIB()
  {
    AppMethodBeat.i(75535);
    this.Lsk = i.hdN;
    Object localObject = this.Lsg;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.bt.b)localObject).getSelectedFeatureListener();
      if (localObject != null) {
        ((aa)localObject).a(i.hdS, 1, null);
      }
    }
    AppMethodBeat.o(75535);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280982);
    String str = v.a.b(this);
    AppMethodBeat.o(280982);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280987);
    s.u(this, "this");
    AppMethodBeat.o(280987);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75538);
    if (this.Lsk == i.hdS)
    {
      gIB();
      AppMethodBeat.o(75538);
      return true;
    }
    AppMethodBeat.o(75538);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280993);
    s.u(this, "this");
    AppMethodBeat.o(280993);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280997);
    s.u(this, "this");
    AppMethodBeat.o(280997);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(281001);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(281001);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281004);
    s.u(this, "this");
    AppMethodBeat.o(281004);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75537);
    ghj().onDestroy();
    gIz().onDestroy();
    this.Lsb.removeAllViews();
    this.Lsb.setVisibility(8);
    com.tencent.mm.bt.b localb = this.Lsg;
    if (localb != null) {
      localb.onDestroy();
    }
    AppMethodBeat.o(75537);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75536);
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
    AppMethodBeat.o(75536);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(280948);
    com.tencent.mm.bt.b localb = this.Lsg;
    if (localb != null) {
      localb.setOutputSize(paramInt1, paramInt2);
    }
    AppMethodBeat.o(280948);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(281006);
    s.u(this, "this");
    AppMethodBeat.o(281006);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements w
  {
    b(long paramLong, l paraml, boolean paramBoolean) {}
    
    public final void b(Bitmap paramBitmap, boolean paramBoolean)
    {
      AppMethodBeat.i(75528);
      Log.i("MicroMsg.EditPhotoPluginLayout", "photoEditor onSuccess: " + paramBitmap + " isNever：" + paramBoolean + "  cost:" + Util.ticksToNow(this.nvq));
      Object localObject = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.ia(Util.ticksToNow(this.nvq));
      if (paramBitmap == null)
      {
        localObject = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brd();
      }
      if (paramBitmap != null)
      {
        localObject = bool;
        final long l = this.nvq;
        paramBoolean = this.NKi;
        kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (kotlin.g.a.m)new a(paramBitmap, (l)localObject, l, paramBoolean, null), 2);
      }
      AppMethodBeat.o(75528);
    }
    
    public final void f(Exception paramException)
    {
      AppMethodBeat.i(75527);
      s.u(paramException, "e");
      Log.e("MicroMsg.EditPhotoPluginLayout", "photoEditor onError: %s", new Object[] { paramException });
      paramException = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brc();
      paramException = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.ia(Util.ticksToNow(this.nvq));
      l.a(bool);
      AppMethodBeat.o(75527);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(Bitmap paramBitmap, l paraml, long paramLong, boolean paramBoolean, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(280558);
        paramObject = (kotlin.d.d)new a(this.NKj, this.NKh, l, this.NKi, paramd);
        AppMethodBeat.o(280558);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(280549);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(280549);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(this.NKj.getWidth()));
          paramObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(this.NKj.getHeight()));
          Log.i("MicroMsg.EditPhotoPluginLayout", "photo width: " + this.NKj.getWidth() + "  height:" + this.NKj.getHeight());
          Object localObject1 = this.NKj;
          Object localObject2 = Bitmap.CompressFormat.JPEG;
          paramObject = l.b(this.NKh);
          if (paramObject == null)
          {
            paramObject = null;
            BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, (Bitmap.CompressFormat)localObject2, paramObject, true);
            localObject1 = new StringBuilder("saveBitmapToImage  cost:").append(Util.ticksToNow(l)).append("  path:");
            paramObject = l.b(this.NKh);
            if (paramObject != null) {
              break label354;
            }
            paramObject = null;
            label214:
            Log.i("MicroMsg.EditPhotoPluginLayout", paramObject);
            l.a(this.NKh);
            paramObject = com.tencent.mm.plugin.recordvideo.util.f.Obq;
            paramObject = l.b(this.NKh);
            localObject1 = l.c(this.NKh);
            if (localObject1 != null) {
              break label362;
            }
          }
          label354:
          label362:
          for (boolean bool = false;; bool = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJW)
          {
            com.tencent.mm.plugin.recordvideo.util.f.b(paramObject, bool, this.NKi);
            Log.d("MicroMsg.EditPhotoPluginLayout", s.X("new ThreadPool  cost:", kotlin.d.b.a.b.BF(Util.ticksToNow(l))));
            paramObject = (kotlin.d.f)bg.kCh();
            localObject1 = (kotlin.g.a.m)new kotlin.d.b.a.k(this.NKh, null)
            {
              int label;
              
              public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
              {
                AppMethodBeat.i(280589);
                paramAnonymousObject = (kotlin.d.d)new 1(this.NKh, paramAnonymousd);
                AppMethodBeat.o(280589);
                return paramAnonymousObject;
              }
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(280584);
                Object localObject = kotlin.d.a.a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(280584);
                  throw paramAnonymousObject;
                }
                ResultKt.throwOnFailure(paramAnonymousObject);
                localObject = CaptureDataManager.NHH;
                Context localContext = l.d(this.NKh);
                Boolean localBoolean1 = Boolean.TRUE;
                paramAnonymousObject = l.b(this.NKh);
                if (paramAnonymousObject == null) {}
                for (paramAnonymousObject = null;; paramAnonymousObject = paramAnonymousObject.NIg)
                {
                  Long localLong = kotlin.d.b.a.b.BF(-1L);
                  Boolean localBoolean2 = Boolean.TRUE;
                  com.tencent.mm.plugin.recordvideo.f.c localc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
                  ((CaptureDataManager)localObject).a(localContext, new CaptureDataManager.CaptureVideoNormalModel(localBoolean1, "", paramAnonymousObject, localLong, localBoolean2, com.tencent.mm.plugin.recordvideo.f.c.gJe()));
                  paramAnonymousObject = ah.aiuX;
                  AppMethodBeat.o(280584);
                  return paramAnonymousObject;
                }
              }
            };
            localObject2 = (kotlin.d.d)this;
            this.label = 1;
            if (kotlinx.coroutines.l.a(paramObject, (kotlin.g.a.m)localObject1, (kotlin.d.d)localObject2) != locala) {
              break label375;
            }
            AppMethodBeat.o(280549);
            return locala;
            paramObject = paramObject.NIg;
            break;
            paramObject = paramObject.NIg;
            break label214;
          }
        }
        ResultKt.throwOnFailure(paramObject);
        label375:
        paramObject = ah.aiuX;
        AppMethodBeat.o(280549);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.bt.a.c
  {
    c(l paraml) {}
    
    public final boolean b(com.tencent.mm.ab.f paramf)
    {
      AppMethodBeat.i(163429);
      s.u(paramf, "item");
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramf.mAC);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramf.mColor);
      localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramf.mBgColor);
      this.NKh.GrC.a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOw, localBundle);
      AppMethodBeat.o(163429);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "params", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements aa
  {
    d(l paraml) {}
    
    public final void a(i parami)
    {
      AppMethodBeat.i(163431);
      s.u(parami, "features");
      Log.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedFeature] features:%s", new Object[] { parami.name() });
      if (parami == i.hdN) {
        a.b.a(this.NKh.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPm);
      }
      AppMethodBeat.o(163431);
    }
    
    public final void a(i parami, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(163432);
      s.u(parami, "features");
      Log.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { parami.name(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(163432);
    }
    
    public final void dP(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.l
 * JD-Core Version:    0.7.0.1
 */