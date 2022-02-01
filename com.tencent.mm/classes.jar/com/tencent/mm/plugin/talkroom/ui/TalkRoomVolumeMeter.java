package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class TalkRoomVolumeMeter
  extends FrameLayout
{
  private a FRB;
  private ImageView FRC;
  private ImageView FRD;
  private ImageView FRE;
  private FrameLayout FRF;
  
  public TalkRoomVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29650);
    initView();
    AppMethodBeat.o(29650);
  }
  
  public TalkRoomVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29649);
    initView();
    AppMethodBeat.o(29649);
  }
  
  private void initView()
  {
    AppMethodBeat.i(29651);
    this.FRB = new a(getContext());
    this.FRC = new ImageView(getContext());
    this.FRC.setScaleType(ImageView.ScaleType.FIT_XY);
    this.FRC.setImageResource(2131235214);
    this.FRC.setVisibility(0);
    this.FRD = new ImageView(getContext());
    this.FRD.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.FRD.setImageResource(2131235213);
    this.FRD.setVisibility(8);
    this.FRE = new ImageView(getContext());
    this.FRE.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.FRE.setImageResource(2131235210);
    this.FRE.setVisibility(8);
    this.FRF = new FrameLayout(getContext());
    this.FRF.addView(this.FRB);
    this.FRF.addView(this.FRD);
    this.FRF.setVisibility(8);
    addView(this.FRF);
    addView(this.FRE);
    addView(this.FRC);
    setBackgroundColor(-16777216);
    bringChildToFront(this.FRC);
    AppMethodBeat.o(29651);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    AppMethodBeat.i(29652);
    ImageView localImageView = this.FRE;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(29652);
      return;
    }
  }
  
  private void setShowRed(boolean paramBoolean)
  {
    this.FRB.FRR = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.FRB.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.FRB.FRH = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.FRB.FRG = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    AppMethodBeat.i(29653);
    Object localObject = this.FRF;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = this.FRB;
      if (!((a)localObject).started)
      {
        ((a)localObject).started = true;
        ((a)localObject).FRN.startTimer(100L);
      }
      AppMethodBeat.o(29653);
      return;
    }
    a locala = this.FRB;
    if (locala.started)
    {
      locala.started = false;
      if ((locala.FRP >= locala.FRG) && (locala.FRP <= locala.FRH)) {
        break label129;
      }
    }
    label129:
    Canvas localCanvas;
    do
    {
      do
      {
        locala.FRN.stopTimer();
        AppMethodBeat.o(29653);
        return;
      } while ((locala.FRK == null) || (locala.FRJ == null));
      localCanvas = locala.FRI.lockCanvas();
    } while ((localCanvas == null) || (locala.FRM == null));
    localCanvas.setDrawFilter(locala.FRQ);
    locala.FRM.set(0, 0, locala.CVr, locala.CVs + 0);
    if (locala.FRR) {}
    for (localObject = locala.FRK;; localObject = locala.FRJ)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.FRM, locala.paint);
      locala.FRI.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    a locala = this.FRB;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.FRP = (locala.FRH - (locala.FRH - locala.FRG) * (locala.value * 1.0F / locala.max));
      return;
      i = paramInt;
      if (paramInt > locala.max) {
        i = locala.max;
      }
    }
  }
  
  final class a
    extends SurfaceView
    implements SurfaceHolder.Callback
  {
    int CVr;
    int CVs;
    float FRG;
    float FRH;
    SurfaceHolder FRI;
    Bitmap FRJ;
    Bitmap FRK;
    private Bitmap FRL;
    Rect FRM;
    MTimerHandler FRN;
    private float FRO;
    float FRP;
    PaintFlagsDrawFilter FRQ;
    boolean FRR;
    private boolean isRefreshing;
    private float[] kZF;
    int max;
    Paint paint;
    boolean started;
    int value;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(29643);
      this.max = 100;
      this.value = 0;
      this.FRG = 0.0F;
      this.FRH = 0.0F;
      this.isRefreshing = false;
      this.FRO = this.FRH;
      this.FRP = this.FRH;
      this.FRR = false;
      this.started = false;
      this.FRI = getHolder();
      this.FRI.addCallback(this);
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.FRQ = new PaintFlagsDrawFilter(0, 3);
      this.FRN = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(29642);
          TalkRoomVolumeMeter.a.a(TalkRoomVolumeMeter.a.this);
          boolean bool = TalkRoomVolumeMeter.a.b(TalkRoomVolumeMeter.a.this);
          AppMethodBeat.o(29642);
          return bool;
        }
      }, true);
      AppMethodBeat.o(29643);
    }
    
    private int fuq()
    {
      AppMethodBeat.i(29645);
      if (this.FRJ == null)
      {
        AppMethodBeat.o(29645);
        return 190;
      }
      int i = this.FRJ.getHeight();
      AppMethodBeat.o(29645);
      return i;
    }
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(29646);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
      this.FRH = 0.0F;
      this.FRG = (paramInt3 - fuq());
      this.FRO = this.FRH;
      this.FRP = this.FRH;
      this.CVr = paramInt2;
      this.CVs = fuq();
      this.FRM = new Rect(0, (int)this.FRO, this.CVr, (int)this.FRO + this.CVs);
      this.isRefreshing = true;
      AppMethodBeat.o(29646);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29644);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
      this.FRJ = BitmapFactory.decodeResource(getResources(), 2131235211);
      this.FRL = BitmapFactory.decodeResource(getResources(), 2131235210);
      this.FRK = BitmapFactory.decodeResource(getResources(), 2131235212);
      AppMethodBeat.o(29644);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29647);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
      this.isRefreshing = false;
      this.FRN.stopTimer();
      if (this.FRJ != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.FRJ.toString() });
        this.FRJ.recycle();
        this.FRJ = null;
      }
      if (this.FRL != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.FRL.toString() });
        this.FRL.recycle();
        this.FRL = null;
      }
      if (this.FRK != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.FRK.toString() });
        this.FRK.recycle();
        this.FRK = null;
      }
      AppMethodBeat.o(29647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */