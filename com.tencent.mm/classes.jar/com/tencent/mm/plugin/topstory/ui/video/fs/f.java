package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.sdk.platformtools.am;

public class f
  extends g
{
  public TextView eXr;
  public TextView kEq;
  public TextView kEr;
  public TextView nMe;
  public ImageView pEY;
  boolean pGW;
  View pGZ;
  View pHa;
  View pHb;
  private View pHc;
  View pHd;
  public View pHe;
  public View pHf;
  public TextView pHg;
  public View pHh;
  public View pHi;
  public ImageView pHj;
  public ImageView pHk;
  public View pHl;
  am pHm;
  private f.a pHn;
  
  public f(Context paramContext)
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
    if (this.pHn != null) {
      this.pHn.update(this.mPosition, getVideoTotalTime());
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
  
  protected int getBarPointWidth()
  {
    return this.ofq.getWidth();
  }
  
  protected int getLayoutId()
  {
    return b.e.top_story_fs_video_control_bar;
  }
  
  public final void hide()
  {
    setVisibility(8);
  }
  
  protected final void init()
  {
    super.init();
    this.pHa = this.contentView.findViewById(b.d.share_iv);
    this.pGZ = this.contentView.findViewById(b.d.full_screen_iv);
    this.pHb = this.contentView.findViewById(b.d.feedback_iv);
    this.pHc = this.contentView.findViewById(b.d.progress_root_bg);
    this.pHd = this.contentView.findViewById(b.d.progress_root);
    this.pHe = this.contentView.findViewById(b.d.tag_desc_layout);
    this.pHf = this.contentView.findViewById(b.d.bottom_tag_layout);
    this.pHg = ((TextView)this.contentView.findViewById(b.d.bottom_desc_tv));
    this.pHh = this.contentView.findViewById(b.d.tag_1_ll);
    this.pHi = this.contentView.findViewById(b.d.tag_2_ll);
    this.kEq = ((TextView)this.contentView.findViewById(b.d.tag_1_tv));
    this.kEr = ((TextView)this.contentView.findViewById(b.d.tag_2_tv));
    this.pHj = ((ImageView)this.contentView.findViewById(b.d.tag_1_icon));
    this.pHk = ((ImageView)this.contentView.findViewById(b.d.tag_2_icon));
    this.pEY = ((ImageView)this.contentView.findViewById(b.d.source_iv));
    this.nMe = ((TextView)this.contentView.findViewById(b.d.source_tv));
    this.pHl = this.contentView.findViewById(b.d.source_arrow);
    this.eXr = ((TextView)this.contentView.findViewById(b.d.title_tv));
  }
  
  public void setFeedbackBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pHb.setOnClickListener(paramOnClickListener);
  }
  
  public void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pGZ.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnUpdateProgressLenListener(f.a parama)
  {
    this.pHn = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.pGW = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pHa.setOnClickListener(paramOnClickListener);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.nMe != null) {
      this.nMe.setOnClickListener(paramOnClickListener);
    }
    if (this.pEY != null) {
      this.pEY.setOnClickListener(paramOnClickListener);
    }
    if (this.pHl != null) {
      this.pHl.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.pHh.setOnClickListener(paramOnClickListener);
    this.pHi.setOnClickListener(paramOnClickListener);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4)) {
      if (this.pHn != null) {
        this.pHn.bOx();
      }
    }
    while ((paramInt != 0) || (this.pHn == null)) {
      return;
    }
    this.pHn.bOw();
  }
  
  public final void show()
  {
    setVisibility(0);
    bOz();
    if (this.pHm == null) {
      this.pHm = new am(new f.1(this), false);
    }
    this.pHm.stopTimer();
    this.pHm.S(2000L, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */