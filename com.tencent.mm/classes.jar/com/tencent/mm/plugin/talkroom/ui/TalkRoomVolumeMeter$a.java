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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class TalkRoomVolumeMeter$a
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private boolean isRefreshing;
  int max;
  Paint paint;
  private float[] positions;
  boolean started;
  float tee;
  float tef;
  SurfaceHolder teg;
  Bitmap teh;
  Bitmap tei;
  private Bitmap tej;
  Rect tek;
  int tel;
  int tem;
  ap ten;
  private float teo;
  float tep;
  PaintFlagsDrawFilter teq;
  boolean ter;
  int value;
  
  public TalkRoomVolumeMeter$a(TalkRoomVolumeMeter paramTalkRoomVolumeMeter, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(25960);
    this.max = 100;
    this.value = 0;
    this.tee = 0.0F;
    this.tef = 0.0F;
    this.isRefreshing = false;
    this.teo = this.tef;
    this.tep = this.tef;
    this.ter = false;
    this.started = false;
    this.teg = getHolder();
    this.teg.addCallback(this);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.teq = new PaintFlagsDrawFilter(0, 3);
    this.ten = new ap(new TalkRoomVolumeMeter.a.1(this), true);
    AppMethodBeat.o(25960);
  }
  
  private int cHW()
  {
    AppMethodBeat.i(25962);
    if (this.teh == null)
    {
      AppMethodBeat.o(25962);
      return 190;
    }
    int i = this.teh.getHeight();
    AppMethodBeat.o(25962);
    return i;
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25963);
    ab.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
    this.tef = 0.0F;
    this.tee = (paramInt3 - cHW());
    this.teo = this.tef;
    this.tep = this.tef;
    this.tem = paramInt2;
    this.tel = cHW();
    this.tek = new Rect(0, (int)this.teo, this.tem, (int)this.teo + this.tel);
    this.isRefreshing = true;
    AppMethodBeat.o(25963);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(25961);
    ab.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
    this.teh = BitmapFactory.decodeResource(getResources(), 2130840539);
    this.tej = BitmapFactory.decodeResource(getResources(), 2130840538);
    this.tei = BitmapFactory.decodeResource(getResources(), 2130840540);
    AppMethodBeat.o(25961);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(25964);
    ab.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
    this.isRefreshing = false;
    this.ten.stopTimer();
    if (this.teh != null)
    {
      ab.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.teh.toString() });
      this.teh.recycle();
      this.teh = null;
    }
    if (this.tej != null)
    {
      ab.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.tej.toString() });
      this.tej.recycle();
      this.tej = null;
    }
    if (this.tei != null)
    {
      ab.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.tei.toString() });
      this.tei.recycle();
      this.tei = null;
    }
    AppMethodBeat.o(25964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter.a
 * JD-Core Version:    0.7.0.1
 */