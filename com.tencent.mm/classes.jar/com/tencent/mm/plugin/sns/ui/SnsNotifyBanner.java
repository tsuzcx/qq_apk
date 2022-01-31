package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsNotifyBanner
  extends RelativeLayout
{
  private View Qz;
  private LayoutInflater mInflater;
  private TextView rTR;
  private ImageView rTS;
  int rTT;
  private SnsNotifyBanner.a rTU;
  
  public SnsNotifyBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39139);
    this.rTT = 0;
    init();
    AppMethodBeat.o(39139);
  }
  
  public SnsNotifyBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39138);
    this.rTT = 0;
    init();
    AppMethodBeat.o(39138);
  }
  
  private void init()
  {
    AppMethodBeat.i(39140);
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.Qz = this.mInflater.inflate(2130970849, this, true);
    this.rTR = ((TextView)this.Qz.findViewById(2131828044));
    this.rTS = ((ImageView)this.Qz.findViewById(2131828045));
    this.rTS.setOnClickListener(new SnsNotifyBanner.1(this));
    AppMethodBeat.o(39140);
  }
  
  public void setOnClickNotify(SnsNotifyBanner.a parama)
  {
    AppMethodBeat.i(39141);
    this.rTU = parama;
    this.rTR.setOnClickListener(new SnsNotifyBanner.2(this));
    AppMethodBeat.o(39141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotifyBanner
 * JD-Core Version:    0.7.0.1
 */