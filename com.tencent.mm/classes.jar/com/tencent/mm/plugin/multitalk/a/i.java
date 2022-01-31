package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import com.tencent.mm.bf.e;
import com.tencent.mm.plugin.multitalk.a.g;

public final class i
{
  private boolean mum;
  private boolean mun;
  
  public final void B(Activity paramActivity)
  {
    if (!this.mum)
    {
      this.mum = true;
      e.a(paramActivity, a.g.multitalk_not_support_video_tip, null);
    }
  }
  
  public final void C(Activity paramActivity)
  {
    if (!this.mun)
    {
      this.mun = true;
      e.a(paramActivity, a.g.voip_not_wifi_warnning_message, null);
    }
  }
  
  public final void reset()
  {
    this.mun = false;
    this.mum = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.i
 * JD-Core Version:    0.7.0.1
 */