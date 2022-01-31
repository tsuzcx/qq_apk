package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class TalkRoomVolumeMeter$a
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  Paint gaZ;
  int max = 100;
  Rect pCA;
  int pCB;
  int pCC;
  am pCD;
  private boolean pCE = false;
  private float pCF = this.pCv;
  float pCG = this.pCv;
  PaintFlagsDrawFilter pCH;
  boolean pCI = false;
  float pCu = 0.0F;
  float pCv = 0.0F;
  SurfaceHolder pCw = getHolder();
  Bitmap pCx;
  Bitmap pCy;
  private Bitmap pCz;
  private float[] positions;
  boolean started = false;
  int value = 0;
  
  public TalkRoomVolumeMeter$a(TalkRoomVolumeMeter paramTalkRoomVolumeMeter, Context paramContext)
  {
    super(paramContext);
    this.pCw.addCallback(this);
    this.gaZ = new Paint();
    this.gaZ.setAntiAlias(true);
    this.pCH = new PaintFlagsDrawFilter(0, 3);
    this.pCD = new am(new TalkRoomVolumeMeter.a.1(this), true);
  }
  
  private int bMT()
  {
    if (this.pCx == null) {
      return 190;
    }
    return this.pCx.getHeight();
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    y.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
    this.pCv = 0.0F;
    this.pCu = (paramInt3 - bMT());
    this.pCF = this.pCv;
    this.pCG = this.pCv;
    this.pCC = paramInt2;
    this.pCB = bMT();
    this.pCA = new Rect(0, (int)this.pCF, this.pCC, (int)this.pCF + this.pCB);
    this.pCE = true;
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    y.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
    this.pCx = BitmapFactory.decodeResource(getResources(), R.g.talk_room_volume_flame);
    this.pCz = BitmapFactory.decodeResource(getResources(), R.g.talk_room_volume_err);
    this.pCy = BitmapFactory.decodeResource(getResources(), R.g.talk_room_volume_flame_red);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    y.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
    this.pCE = false;
    this.pCD.stopTimer();
    if (this.pCx != null)
    {
      this.pCx.recycle();
      this.pCx = null;
    }
    if (this.pCz != null)
    {
      this.pCz.recycle();
      this.pCz = null;
    }
    if (this.pCy != null)
    {
      this.pCy.recycle();
      this.pCy = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter.a
 * JD-Core Version:    0.7.0.1
 */