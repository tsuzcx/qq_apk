package com.tencent.xweb.extension.video;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  float Ajw;
  a BER;
  boolean BES;
  float BET;
  float Tb;
  ImageView idc;
  ImageView qTC;
  ImageView qTD;
  private ImageView qTE;
  
  public c(FrameLayout paramFrameLayout, a parama)
  {
    AppMethodBeat.i(84565);
    this.idc = null;
    this.qTE = null;
    this.BES = false;
    this.Ajw = 0.0F;
    this.BER = parama;
    this.qTC = ((ImageView)paramFrameLayout.findViewById(2131821463));
    this.idc = ((ImageView)paramFrameLayout.findViewById(2131821462));
    this.qTD = ((ImageView)paramFrameLayout.findViewById(2131821461));
    this.qTE = ((ImageView)paramFrameLayout.findViewById(2131821464));
    this.qTE.setOnTouchListener(new c.1(this));
    AppMethodBeat.o(84565);
  }
  
  public final void c(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(84566);
    if ((this.BES) && (!paramBoolean))
    {
      AppMethodBeat.o(84566);
      return;
    }
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      this.Tb = f;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qTE.getLayoutParams();
      localLayoutParams.leftMargin = ((int)(f / 100.0F * this.qTD.getWidth() - this.qTE.getWidth() / 2));
      this.qTE.setLayoutParams(localLayoutParams);
      this.qTE.requestLayout();
      localLayoutParams = (FrameLayout.LayoutParams)this.qTC.getLayoutParams();
      localLayoutParams.width = ((int)(f / 100.0F * this.qTD.getWidth()));
      this.qTC.setLayoutParams(localLayoutParams);
      this.qTC.requestLayout();
      AppMethodBeat.o(84566);
      return;
      f = paramFloat;
      if (paramFloat > 100.0F) {
        f = 100.0F;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aFf();
    
    public abstract void bE(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */