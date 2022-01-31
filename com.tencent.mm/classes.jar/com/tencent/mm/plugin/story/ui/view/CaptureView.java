package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.c.a.b.a;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/CaptureView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "albumView", "Landroid/widget/ImageView;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "captureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "closeView", "guideView", "Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "hideHintRunnable", "Ljava/lang/Runnable;", "recordStartTime", "", "startTimeStamp", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "uiNavigation", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "getUiNavigation", "()Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "setUiNavigation", "(Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;)V", "useBackGroundCamera", "", "destroy", "", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "gotoEditor", "capture", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "hideGuideView", "hideHint", "initCaptureButton", "onBack", "onClick", "v", "Landroid/view/View;", "pause", "resume", "setVisibility", "visibility", "showHint", "strRes", "useCpuCrop", "Companion", "plugin-story_release"})
public final class CaptureView
  extends RelativeLayout
  implements View.OnClickListener, com.tencent.mm.media.widget.camerarecordview.c.a
{
  public static final CaptureView.b sLl;
  private final ak faV;
  private boolean faW;
  private long lvI;
  private final CameraFrontSightView lyh;
  private final MMSightCaptureTouchView lyi;
  private final TextView lyj;
  private final Runnable lym;
  public com.tencent.mm.media.widget.camerarecordview.a lyn;
  private StoryCaptureUI.b sAE;
  private final CameraPreviewGLSurfaceView sLg;
  private final MMSightRecordButton sLh;
  private final ImageView sLi;
  private final ImageView sLj;
  public g sLk;
  private long startTimeStamp;
  
  static
  {
    AppMethodBeat.i(110326);
    sLl = new CaptureView.b((byte)0);
    AppMethodBeat.o(110326);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110325);
    AppMethodBeat.o(110325);
  }
  
  public CaptureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110324);
    this.startTimeStamp = bo.yB();
    this.faW = true;
    this.faV = new ak(Looper.getMainLooper());
    View.inflate(paramContext, 2130970931, (ViewGroup)this);
    paramAttributeSet = findViewById(2131821744);
    j.p(paramAttributeSet, "findViewById(R.id.draw_preview_surface)");
    this.sLg = ((CameraPreviewGLSurfaceView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828294);
    j.p(paramAttributeSet, "findViewById(R.id.story_capture_button)");
    this.sLh = ((MMSightRecordButton)paramAttributeSet);
    paramAttributeSet = findViewById(2131823535);
    j.p(paramAttributeSet, "findViewById(R.id.capture_focus_frame)");
    this.lyh = ((CameraFrontSightView)paramAttributeSet);
    paramAttributeSet = findViewById(2131823536);
    j.p(paramAttributeSet, "findViewById(R.id.capture_touch_view)");
    this.lyi = ((MMSightCaptureTouchView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828295);
    j.p(paramAttributeSet, "findViewById(R.id.story_capture_hint)");
    this.lyj = ((TextView)paramAttributeSet);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 120);
    this.lyh.eI(paramInt, paramInt);
    paramAttributeSet = findViewById(2131828293);
    j.p(paramAttributeSet, "findViewById<ImageView>(R.id.story_capture_close)");
    this.sLi = ((ImageView)paramAttributeSet);
    this.sLi.setImageDrawable(aj.g(paramContext, 2131231147, -1));
    this.sLi.setOnClickListener((View.OnClickListener)this);
    paramAttributeSet = findViewById(2131827126);
    j.p(paramAttributeSet, "findViewById<ImageView>(….story_choose_from_album)");
    this.sLj = ((ImageView)paramAttributeSet);
    this.sLj.setImageDrawable(aj.g(paramContext, 2131231436, -1));
    this.sLj.setOnClickListener((View.OnClickListener)this);
    paramAttributeSet = (ImageView)findViewById(2131828292);
    paramAttributeSet.setImageDrawable(aj.g(paramContext, 2131231443, -1));
    paramAttributeSet.setOnClickListener((View.OnClickListener)this);
    this.lyn = new com.tencent.mm.media.widget.camerarecordview.a((com.tencent.mm.media.widget.camerarecordview.c.a)this);
    this.lyi.setTouchCallback((MMSightCaptureTouchView.a)new CaptureView.1(this));
    paramAttributeSet = com.tencent.mm.kernel.g.RL();
    j.p(paramAttributeSet, "storage()");
    if (!paramAttributeSet.Ru().getBoolean(ac.a.yLw, false))
    {
      this.sLk = new g(paramContext);
      paramContext = this.sLk;
      if (paramContext != null)
      {
        paramAttributeSet = new ViewGroup.LayoutParams(-1, -1);
        addView((View)paramContext, paramAttributeSet);
        paramContext.setClickListener((a.f.a.a)new a(this));
      }
    }
    this.startTimeStamp = bo.yB();
    this.sLh.setSimpleTapCallback((MMSightRecordButton.d)new h(this));
    this.sLh.setLongPressCallback((MMSightRecordButton.b)new CaptureView.i(this));
    this.sLh.setLongPressScrollCallback((MMSightRecordButton.c)new j(this));
    this.lym = ((Runnable)new CaptureView.g(this));
    AppMethodBeat.o(110324);
  }
  
  public final boolean DP()
  {
    return false;
  }
  
  public final boolean Xn()
  {
    AppMethodBeat.i(110319);
    boolean bool = ((b.a)com.tencent.mm.plugin.story.c.a.b.srP.Uw()).eZM;
    AppMethodBeat.o(110319);
    return bool;
  }
  
  public final boolean Xo()
  {
    return ac.eru.eoC;
  }
  
  public final void cFt()
  {
    AppMethodBeat.i(110318);
    Object localObject = this.sLk;
    if (localObject != null) {
      ((g)localObject).animate().alpha(0.0F).withEndAction((Runnable)new CaptureView.e((g)localObject, this)).start();
    }
    localObject = com.tencent.mm.kernel.g.RL();
    j.p(localObject, "storage()");
    ((e)localObject).Ru().set(ac.a.yLw, Boolean.TRUE);
    AppMethodBeat.o(110318);
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.preview.c getCameraPreviewView()
  {
    return (com.tencent.mm.media.widget.camerarecordview.preview.c)this.sLg;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.a.a getEncodeConfig()
  {
    AppMethodBeat.i(110321);
    com.tencent.mm.media.widget.camerarecordview.a.a locala = (com.tencent.mm.media.widget.camerarecordview.a.a)new CaptureView.c();
    AppMethodBeat.o(110321);
    return locala;
  }
  
  public final com.tencent.mm.media.h.a getPreviewRenderer()
  {
    return null;
  }
  
  public final com.tencent.mm.media.h.a getRecordRenderer()
  {
    return null;
  }
  
  public final com.tencent.mm.media.widget.b.b getRecorder()
  {
    return null;
  }
  
  public final int getResolutionLimit()
  {
    AppMethodBeat.i(110320);
    int i = ((b.a)com.tencent.mm.plugin.story.c.a.b.srP.Uw()).ltb;
    AppMethodBeat.o(110320);
    return i;
  }
  
  public final StoryCaptureUI.b getUiNavigation()
  {
    return this.sAE;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(110322);
    VideoTransPara localVideoTransPara = ((c.a)com.tencent.mm.plugin.story.c.a.c.srQ.Uw()).qbq;
    AppMethodBeat.o(110322);
    return localVideoTransPara;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110323);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label42;
      }
      label22:
      if (paramView != null) {
        break label98;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        AppMethodBeat.o(110323);
        return;
        paramView = null;
        break;
        label42:
        if (paramView.intValue() != 2131828293) {
          break label22;
        }
        if (this.lyn.isRecording) {
          break label335;
        }
        paramView = this.sAE;
        if (paramView != null) {
          paramView.exit();
        }
        paramView = i.sFa;
        i.FR(3);
        paramView = i.sFa;
        i.cDn();
        AppMethodBeat.o(110323);
        return;
        label98:
        if (paramView.intValue() == 2131827126)
        {
          if (this.lyn.isRecording)
          {
            AppMethodBeat.o(110323);
            return;
          }
          paramView = new Intent();
          paramView.putExtra("key_edit_video_max_time_length", ((a.a)com.tencent.mm.plugin.story.c.a.a.srz.Uw()).srK);
          paramView.putExtra("key_edit_text_color", "#0E9CE6");
          Context localContext;
          if (((a.a)com.tencent.mm.plugin.story.c.a.a.srz.Uw()).srG)
          {
            localContext = getContext();
            if (localContext == null)
            {
              paramView = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(110323);
              throw paramView;
            }
            n.a((Activity)localContext, 1002, 9, 14, 3, paramView);
          }
          for (;;)
          {
            paramView = i.sFa;
            i.cDi().bM(0L);
            paramView = i.sFa;
            i.FR(4);
            paramView = i.sFa;
            i.cDm().FV();
            AppMethodBeat.o(110323);
            return;
            localContext = getContext();
            if (localContext == null)
            {
              paramView = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(110323);
              throw paramView;
            }
            n.a((Activity)localContext, 1002, 1, 14, 2, paramView);
          }
        }
      }
    }
    if (paramView.intValue() == 2131828292)
    {
      paramView = i.sFa;
      i.FR(1);
      this.faW = this.lyn.WN();
    }
    label335:
    AppMethodBeat.o(110323);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(151160);
    com.tencent.mm.media.widget.camerarecordview.a.a(this.lyn, false, null, 3);
    AppMethodBeat.o(151160);
  }
  
  public final void setUiNavigation(StoryCaptureUI.b paramb)
  {
    this.sAE = paramb;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(110317);
    super.setVisibility(paramInt);
    this.sLg.setVisibility(paramInt);
    if (paramInt == 0) {
      this.sLh.bRO();
    }
    AppMethodBeat.o(110317);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/ui/view/CaptureView$2$1"})
  static final class a
    extends k
    implements a.f.a.a<y>
  {
    a(CaptureView paramCaptureView)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onSimpleTap"})
  static final class h
    implements MMSightRecordButton.d
  {
    h(CaptureView paramCaptureView) {}
    
    public final void bpa()
    {
      AppMethodBeat.i(110308);
      CaptureView.a(this.sLm, 2131304173);
      AppMethodBeat.o(110308);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/CaptureView$initCaptureButton$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-story_release"})
  public static final class j
    implements MMSightRecordButton.c
  {
    public final void uR(int paramInt)
    {
      AppMethodBeat.i(110315);
      CaptureView.b(this.sLm).a(true, true, paramInt);
      AppMethodBeat.o(110315);
    }
    
    public final void uS(int paramInt)
    {
      AppMethodBeat.i(110316);
      CaptureView.b(this.sLm).a(false, true, paramInt);
      AppMethodBeat.o(110316);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CaptureView
 * JD-Core Version:    0.7.0.1
 */