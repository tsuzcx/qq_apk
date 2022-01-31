package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.websearch.ui.b;

public final class k
{
  int Cv = 0;
  float gCn = 0.0F;
  View gES;
  private GestureDetector gEU;
  private float gEW = 0.0F;
  int gEX = -1;
  int gEY = 0;
  Runnable gEZ = new k.1(this);
  Context mContext;
  k.a pFB = k.a.pFG;
  c pFC;
  boolean pFD;
  boolean pFE;
  
  public k(Context paramContext, View paramView, c paramc)
  {
    this.mContext = paramContext;
    this.pFC = paramc;
    this.gES = paramView;
    this.gEU = new GestureDetector(this.mContext, new k.2(this));
    this.gCn = b.cn(paramContext);
  }
  
  public final void E(MotionEvent paramMotionEvent)
  {
    if (!this.pFC.bNK()) {
      this.pFB = k.a.pFG;
    }
    int i;
    do
    {
      return;
      i = paramMotionEvent.getActionMasked();
      if (i == 0)
      {
        this.gEW = paramMotionEvent.getRawX();
        this.Cv = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
        this.gCn = b.cn(this.mContext);
      }
      this.gEU.onTouchEvent(paramMotionEvent);
    } while ((i != 1) && (i != 3));
    if (this.pFB == k.a.pFJ)
    {
      c localc = this.pFC;
      i = this.gEY;
      paramMotionEvent.getRawX();
      localc.zz(i);
      this.gEX = -1;
      this.gEY = 0;
      this.gEW = 0.0F;
    }
    for (;;)
    {
      this.pFB = k.a.pFG;
      return;
      if (this.pFB == k.a.pFH) {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
      } else {
        paramMotionEvent = k.a.pFI;
      }
    }
  }
  
  public final void bOl()
  {
    this.gEX = -1;
    this.gEY = 0;
    this.gEW = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k
 * JD-Core Version:    0.7.0.1
 */