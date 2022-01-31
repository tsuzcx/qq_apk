package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class SnsNotifyBanner
  extends RelativeLayout
{
  private LayoutInflater Lu;
  private View QR;
  private TextView pbe;
  private ImageView pbf;
  int pbg = 0;
  private SnsNotifyBanner.a pbh;
  
  public SnsNotifyBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SnsNotifyBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.Lu = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.QR = this.Lu.inflate(i.g.sns_notify_banner, this, true);
    this.pbe = ((TextView)this.QR.findViewById(i.f.sns_banner_notify_tv));
    this.pbf = ((ImageView)this.QR.findViewById(i.f.sns_banner_notify_close_iv));
    this.pbf.setOnClickListener(new SnsNotifyBanner.1(this));
  }
  
  public void setOnClickNotify(SnsNotifyBanner.a parama)
  {
    this.pbh = parama;
    this.pbe.setOnClickListener(new SnsNotifyBanner.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotifyBanner
 * JD-Core Version:    0.7.0.1
 */