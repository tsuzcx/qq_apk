package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.a;

public final class k
{
  int De;
  float iaW;
  View idW;
  private GestureDetector idY;
  private float iea;
  int ieb;
  int iec;
  Runnable ied;
  Context mContext;
  k.a tja;
  c tjb;
  boolean tjc;
  boolean tjd;
  
  public k(Context paramContext, View paramView, c paramc)
  {
    AppMethodBeat.i(1739);
    this.tja = k.a.tjf;
    this.iaW = 0.0F;
    this.De = 0;
    this.iea = 0.0F;
    this.ieb = -1;
    this.iec = 0;
    this.ied = new k.1(this);
    this.mContext = paramContext;
    this.tjb = paramc;
    this.idW = paramView;
    this.idY = new GestureDetector(this.mContext, new k.2(this));
    this.iaW = a.cP(paramContext);
    AppMethodBeat.o(1739);
  }
  
  public final void aFG()
  {
    this.ieb = -1;
    this.iec = 0;
    this.iea = 0.0F;
  }
  
  public final void z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(1740);
    if (!this.tjb.cJx())
    {
      this.tja = k.a.tjf;
      AppMethodBeat.o(1740);
      return;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.iea = paramMotionEvent.getRawX();
      this.De = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
      this.iaW = a.cP(this.mContext);
    }
    this.idY.onTouchEvent(paramMotionEvent);
    if ((i == 1) || (i == 3))
    {
      if (this.tja != k.a.tji) {
        break label160;
      }
      c localc = this.tjb;
      i = this.iec;
      paramMotionEvent.getRawX();
      localc.GC(i);
      this.ieb = -1;
      this.iec = 0;
      this.iea = 0.0F;
    }
    for (;;)
    {
      this.tja = k.a.tjf;
      AppMethodBeat.o(1740);
      return;
      label160:
      if (this.tja == k.a.tjg) {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
      } else {
        paramMotionEvent = k.a.tjh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k
 * JD-Core Version:    0.7.0.1
 */