package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.sdk.platformtools.am;

public final class g
  extends com.tencent.mm.plugin.topstory.ui.video.g
{
  private View pGZ = this.contentView.findViewById(b.d.full_screen_iv);
  private g.a pHK;
  am pHm;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void akG()
  {
    if (this.pHm != null)
    {
      this.pHm.stopTimer();
      this.pHm.S(2000L, 2000L);
    }
  }
  
  public final void akP()
  {
    super.akP();
    if (this.pHK != null) {
      this.pHK.update(this.mPosition, getVideoTotalTime());
    }
  }
  
  public final void bOy()
  {
    if (this.pHm != null) {
      this.pHm.stopTimer();
    }
  }
  
  public final void bOz()
  {
    this.ofr.setVisibility(0);
  }
  
  protected final int getBarPointWidth()
  {
    return this.ofq.getWidth();
  }
  
  protected final int getLayoutId()
  {
    return b.e.top_story_list_video_control_bar;
  }
  
  public final void hide()
  {
    setVisibility(8);
  }
  
  public final void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pGZ.setOnClickListener(paramOnClickListener);
  }
  
  public final void setOnUpdateProgressLenListener(g.a parama)
  {
    this.pHK = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4)) {
      if (this.pHK != null) {
        this.pHK.bOx();
      }
    }
    while ((paramInt != 0) || (this.pHK == null)) {
      return;
    }
    this.pHK.bOw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g
 * JD-Core Version:    0.7.0.1
 */