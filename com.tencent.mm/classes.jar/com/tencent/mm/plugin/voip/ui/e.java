package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;

public final class e
  extends BaseSmallView
{
  private TextView timeTv;
  
  public e(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(4980);
    LayoutInflater.from(paramContext).inflate(2130971115, this);
    this.timeTv = ((TextView)findViewById(2131828902));
    AppMethodBeat.o(4980);
  }
  
  public final void aeI(String paramString)
  {
    AppMethodBeat.i(4982);
    this.timeTv.setTextSize(1, 12.0F);
    this.timeTv.setText(paramString);
    AppMethodBeat.o(4982);
  }
  
  public final void aeJ(String paramString)
  {
    AppMethodBeat.i(4981);
    this.timeTv.setTextSize(1, 14.0F);
    this.timeTv.setText(paramString);
    AppMethodBeat.o(4981);
  }
  
  public final void cPo() {}
  
  public final void cPp() {}
  
  public final OpenGlRender getBeautyData()
  {
    return null;
  }
  
  public final OpenGlRender getFilterData()
  {
    return null;
  }
  
  public final void onAnimationEnd() {}
  
  public final void setCaptureView(CaptureView paramCaptureView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e
 * JD-Core Version:    0.7.0.1
 */