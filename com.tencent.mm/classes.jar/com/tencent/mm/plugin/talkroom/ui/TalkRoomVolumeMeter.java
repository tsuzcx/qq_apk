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
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class TalkRoomVolumeMeter
  extends FrameLayout
{
  private ImageView CDf;
  private a SOW;
  private ImageView SOX;
  private ImageView SOY;
  private FrameLayout SOZ;
  
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
    this.SOW = new a(getContext());
    this.SOX = new ImageView(getContext());
    this.SOX.setScaleType(ImageView.ScaleType.FIT_XY);
    this.SOX.setImageResource(R.g.fpD);
    this.SOX.setVisibility(0);
    this.CDf = new ImageView(getContext());
    this.CDf.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.CDf.setImageResource(R.g.fpC);
    this.CDf.setVisibility(8);
    this.SOY = new ImageView(getContext());
    this.SOY.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.SOY.setImageResource(R.g.fpz);
    this.SOY.setVisibility(8);
    this.SOZ = new FrameLayout(getContext());
    this.SOZ.addView(this.SOW);
    this.SOZ.addView(this.CDf);
    this.SOZ.setVisibility(8);
    addView(this.SOZ);
    addView(this.SOY);
    addView(this.SOX);
    setBackgroundColor(-16777216);
    bringChildToFront(this.SOX);
    AppMethodBeat.o(29651);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    AppMethodBeat.i(29652);
    ImageView localImageView = this.SOY;
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
    this.SOW.SPl = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.SOW.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.SOW.SPb = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.SOW.SPa = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    AppMethodBeat.i(29653);
    Object localObject = this.SOZ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = this.SOW;
      if (!((a)localObject).started)
      {
        ((a)localObject).started = true;
        ((a)localObject).SPh.startTimer(100L);
      }
      AppMethodBeat.o(29653);
      return;
    }
    a locala = this.SOW;
    if (locala.started)
    {
      locala.started = false;
      if ((locala.SPj >= locala.SPa) && (locala.SPj <= locala.SPb)) {
        break label129;
      }
    }
    label129:
    Canvas localCanvas;
    do
    {
      do
      {
        locala.SPh.stopTimer();
        AppMethodBeat.o(29653);
        return;
      } while ((locala.SPe == null) || (locala.SPd == null));
      localCanvas = locala.SPc.lockCanvas();
    } while ((localCanvas == null) || (locala.SPg == null));
    localCanvas.setDrawFilter(locala.SPk);
    locala.SPg.set(0, 0, locala.PkU, locala.PkV + 0);
    if (locala.SPl) {}
    for (localObject = locala.SPe;; localObject = locala.SPd)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.SPg, locala.paint);
      locala.SPc.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    a locala = this.SOW;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.SPj = (locala.SPb - (locala.SPb - locala.SPa) * (locala.value * 1.0F / locala.max));
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
    int PkU;
    int PkV;
    float SPa;
    float SPb;
    SurfaceHolder SPc;
    Bitmap SPd;
    Bitmap SPe;
    private Bitmap SPf;
    Rect SPg;
    MTimerHandler SPh;
    private float SPi;
    float SPj;
    PaintFlagsDrawFilter SPk;
    boolean SPl;
    private boolean isRefreshing;
    int max;
    Paint paint;
    private float[] qTB;
    boolean started;
    int value;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(29643);
      this.max = 100;
      this.value = 0;
      this.SPa = 0.0F;
      this.SPb = 0.0F;
      this.isRefreshing = false;
      this.SPi = this.SPb;
      this.SPj = this.SPb;
      this.SPl = false;
      this.started = false;
      this.SPc = getHolder();
      this.SPc.addCallback(this);
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.SPk = new PaintFlagsDrawFilter(0, 3);
      this.SPh = new MTimerHandler(new MTimerHandler.CallBack()
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
    
    private int hCS()
    {
      AppMethodBeat.i(29645);
      if (this.SPd == null)
      {
        AppMethodBeat.o(29645);
        return 190;
      }
      int i = this.SPd.getHeight();
      AppMethodBeat.o(29645);
      return i;
    }
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(29646);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
      this.SPb = 0.0F;
      this.SPa = (paramInt3 - hCS());
      this.SPi = this.SPb;
      this.SPj = this.SPb;
      this.PkU = paramInt2;
      this.PkV = hCS();
      this.SPg = new Rect(0, (int)this.SPi, this.PkU, (int)this.SPi + this.PkV);
      this.isRefreshing = true;
      AppMethodBeat.o(29646);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29644);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
      this.SPd = BitmapFactory.decodeResource(getResources(), R.g.fpA);
      this.SPf = BitmapFactory.decodeResource(getResources(), R.g.fpz);
      this.SPe = BitmapFactory.decodeResource(getResources(), R.g.fpB);
      AppMethodBeat.o(29644);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29647);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
      this.isRefreshing = false;
      this.SPh.stopTimer();
      if (this.SPd != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.SPd.toString() });
        this.SPd.recycle();
        this.SPd = null;
      }
      if (this.SPf != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.SPf.toString() });
        this.SPf.recycle();
        this.SPf = null;
      }
      if (this.SPe != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.SPe.toString() });
        this.SPe.recycle();
        this.SPe = null;
      }
      AppMethodBeat.o(29647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */