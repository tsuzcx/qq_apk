package com.tencent.mm.plugin.voip.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class c
  extends BaseSmallView
{
  public final void GH(boolean paramBoolean)
  {
    AppMethodBeat.i(184101);
    if (paramBoolean)
    {
      AppMethodBeat.o(184101);
      throw null;
    }
    super.GH(false);
    AppMethodBeat.o(184101);
  }
  
  public final void aNF(String paramString)
  {
    AppMethodBeat.i(184095);
    AppMethodBeat.o(184095);
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(184099);
    AppMethodBeat.o(184099);
    throw null;
  }
  
  public final OpenGlRender getBeautyData()
  {
    throw null;
  }
  
  public final OpenGlRender getSpatioTemporalFilterData()
  {
    throw null;
  }
  
  public final boolean ghw()
  {
    AppMethodBeat.i(184097);
    super.ghw();
    AppMethodBeat.o(184097);
    throw null;
  }
  
  public final void ghx()
  {
    AppMethodBeat.i(184102);
    AppMethodBeat.o(184102);
    throw null;
  }
  
  public final void idK()
  {
    AppMethodBeat.i(184094);
    AppMethodBeat.o(184094);
    throw null;
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(115779);
    AppMethodBeat.o(115779);
    throw null;
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(293421);
    super.onViewAdded(paramView);
    if (this.UJb != null)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if ((this.UJb != null) && (this.UJb.get() != null))
      {
        this.UJb.get();
        AppMethodBeat.o(293421);
        throw null;
      }
    }
    else
    {
      AppMethodBeat.o(293421);
      throw null;
    }
    AppMethodBeat.o(293421);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(293449);
    super.a(paramCaptureView);
    AppMethodBeat.o(293449);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115773);
    AppMethodBeat.o(115773);
    throw null;
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    throw null;
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(115780);
    AppMethodBeat.o(115780);
    throw null;
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184098);
    if (this.Uxg != paramInt)
    {
      AppMethodBeat.o(184098);
      throw null;
    }
    AppMethodBeat.o(184098);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115770);
    AppMethodBeat.o(115770);
    throw null;
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(293471);
    super.setVoipUIListener(paramc);
    AppMethodBeat.o(293471);
    throw null;
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115775);
    super.uninit();
    AppMethodBeat.o(115775);
    throw null;
  }
  
  public final void updateText(String paramString)
  {
    AppMethodBeat.i(184096);
    AppMethodBeat.o(184096);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.c
 * JD-Core Version:    0.7.0.1
 */