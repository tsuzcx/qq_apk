package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;

public final class h
  extends BaseSmallView
{
  private TextView igx;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    LayoutInflater.from(paramContext).inflate(a.c.voip_voice_mini_widget_view, this);
    this.igx = ((TextView)findViewById(a.b.voip_voice_mini_time_tv));
  }
  
  public final void Qb(String paramString)
  {
    this.igx.setTextSize(1, 12.0F);
    this.igx.setText(paramString);
  }
  
  public final void Qc(String paramString)
  {
    this.igx.setTextSize(1, 14.0F);
    this.igx.setText(paramString);
  }
  
  protected final void bSg() {}
  
  protected final void bSh() {}
  
  public final OpenGlRender getFilterData()
  {
    return null;
  }
  
  protected final void onAnimationEnd() {}
  
  public final void setCaptureView(CaptureView paramCaptureView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.h
 * JD-Core Version:    0.7.0.1
 */