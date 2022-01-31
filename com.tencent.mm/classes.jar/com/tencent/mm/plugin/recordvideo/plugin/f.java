package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.b;
import com.tencent.mm.e.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "isFinishing", "", "moved", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", "index", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadPhotoEditLogic", "path", "", "onBackPress", "release", "reset", "setup", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-recordvideo_release"})
public final class f
  implements q
{
  public static final f.a qbY;
  public final Context context;
  public int eSO;
  public boolean mwZ;
  public s oOG;
  public RecordConfigProvider qaF;
  d qbI;
  public com.tencent.mm.media.widget.camerarecordview.a.b qbS;
  public com.tencent.mm.view.b qbT;
  public com.tencent.mm.bs.b qbU;
  private boolean qbV;
  public e qbW;
  public FrameLayout qbX;
  
  static
  {
    AppMethodBeat.i(150629);
    qbY = new f.a((byte)0);
    AppMethodBeat.o(150629);
  }
  
  public f(FrameLayout paramFrameLayout, d paramd)
  {
    AppMethodBeat.i(150628);
    this.qbX = paramFrameLayout;
    this.qbI = paramd;
    paramFrameLayout = s.bWe.Ab();
    j.p(paramFrameLayout, "MMPhotoEditor.mFactory.get()");
    this.oOG = paramFrameLayout;
    this.context = this.qbX.getContext();
    this.qbW = e.bVV;
    this.eSO = -1;
    AppMethodBeat.o(150628);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150627);
    if (this.qbW == e.bWa)
    {
      cgw();
      AppMethodBeat.o(150627);
      return true;
    }
    AppMethodBeat.o(150627);
    return false;
  }
  
  public final void cgw()
  {
    AppMethodBeat.i(150624);
    this.qbW = e.bVV;
    com.tencent.mm.bs.b localb = this.qbU;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(e.bWa, 1);
      AppMethodBeat.o(150624);
      return;
    }
    AppMethodBeat.o(150624);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(150626);
    this.oOG.onDestroy();
    this.qbX.removeAllViews();
    this.qbX.setVisibility(8);
    com.tencent.mm.bs.b localb = this.qbU;
    if (localb != null)
    {
      localb.onDestroy();
      AppMethodBeat.o(150626);
      return;
    }
    AppMethodBeat.o(150626);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(150625);
    this.qbW = e.bVV;
    com.tencent.mm.bs.b localb = this.qbU;
    if (localb != null) {
      localb.getSelectedFeatureListener().a(e.bVV);
    }
    localb = this.qbU;
    if (localb != null)
    {
      localb.getSelectedFeatureListener().a(e.bVV, -1);
      AppMethodBeat.o(150625);
      return;
    }
    AppMethodBeat.o(150625);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
  public static final class f
    implements b.a
  {
    public f(f paramf) {}
    
    public final boolean o(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(150623);
      f localf = this.qbZ;
      j.p(paramMotionEvent, "it");
      f.a(localf, paramMotionEvent);
      AppMethodBeat.o(150623);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f
 * JD-Core Version:    0.7.0.1
 */