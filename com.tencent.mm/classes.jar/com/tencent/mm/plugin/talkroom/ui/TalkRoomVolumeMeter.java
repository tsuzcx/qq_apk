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
  private a MlC;
  private ImageView MlD;
  private ImageView MlE;
  private ImageView MlF;
  private FrameLayout MlG;
  
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
    this.MlC = new a(getContext());
    this.MlD = new ImageView(getContext());
    this.MlD.setScaleType(ImageView.ScaleType.FIT_XY);
    this.MlD.setImageResource(R.g.dpo);
    this.MlD.setVisibility(0);
    this.MlE = new ImageView(getContext());
    this.MlE.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.MlE.setImageResource(R.g.dpn);
    this.MlE.setVisibility(8);
    this.MlF = new ImageView(getContext());
    this.MlF.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.MlF.setImageResource(R.g.dpk);
    this.MlF.setVisibility(8);
    this.MlG = new FrameLayout(getContext());
    this.MlG.addView(this.MlC);
    this.MlG.addView(this.MlE);
    this.MlG.setVisibility(8);
    addView(this.MlG);
    addView(this.MlF);
    addView(this.MlD);
    setBackgroundColor(-16777216);
    bringChildToFront(this.MlD);
    AppMethodBeat.o(29651);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    AppMethodBeat.i(29652);
    ImageView localImageView = this.MlF;
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
    this.MlC.MlS = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.MlC.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.MlC.MlI = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.MlC.MlH = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    AppMethodBeat.i(29653);
    Object localObject = this.MlG;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = this.MlC;
      if (!((a)localObject).started)
      {
        ((a)localObject).started = true;
        ((a)localObject).MlO.startTimer(100L);
      }
      AppMethodBeat.o(29653);
      return;
    }
    a locala = this.MlC;
    if (locala.started)
    {
      locala.started = false;
      if ((locala.MlQ >= locala.MlH) && (locala.MlQ <= locala.MlI)) {
        break label129;
      }
    }
    label129:
    Canvas localCanvas;
    do
    {
      do
      {
        locala.MlO.stopTimer();
        AppMethodBeat.o(29653);
        return;
      } while ((locala.MlL == null) || (locala.MlK == null));
      localCanvas = locala.MlJ.lockCanvas();
    } while ((localCanvas == null) || (locala.MlN == null));
    localCanvas.setDrawFilter(locala.MlR);
    locala.MlN.set(0, 0, locala.Jbb, locala.Jbc + 0);
    if (locala.MlS) {}
    for (localObject = locala.MlL;; localObject = locala.MlK)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.MlN, locala.paint);
      locala.MlJ.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    a locala = this.MlC;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.MlQ = (locala.MlI - (locala.MlI - locala.MlH) * (locala.value * 1.0F / locala.max));
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
    int Jbb;
    int Jbc;
    float MlH;
    float MlI;
    SurfaceHolder MlJ;
    Bitmap MlK;
    Bitmap MlL;
    private Bitmap MlM;
    Rect MlN;
    MTimerHandler MlO;
    private float MlP;
    float MlQ;
    PaintFlagsDrawFilter MlR;
    boolean MlS;
    private boolean isRefreshing;
    int max;
    private float[] nTQ;
    Paint paint;
    boolean started;
    int value;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(29643);
      this.max = 100;
      this.value = 0;
      this.MlH = 0.0F;
      this.MlI = 0.0F;
      this.isRefreshing = false;
      this.MlP = this.MlI;
      this.MlQ = this.MlI;
      this.MlS = false;
      this.started = false;
      this.MlJ = getHolder();
      this.MlJ.addCallback(this);
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.MlR = new PaintFlagsDrawFilter(0, 3);
      this.MlO = new MTimerHandler(new MTimerHandler.CallBack()
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
    
    private int giS()
    {
      AppMethodBeat.i(29645);
      if (this.MlK == null)
      {
        AppMethodBeat.o(29645);
        return 190;
      }
      int i = this.MlK.getHeight();
      AppMethodBeat.o(29645);
      return i;
    }
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(29646);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
      this.MlI = 0.0F;
      this.MlH = (paramInt3 - giS());
      this.MlP = this.MlI;
      this.MlQ = this.MlI;
      this.Jbb = paramInt2;
      this.Jbc = giS();
      this.MlN = new Rect(0, (int)this.MlP, this.Jbb, (int)this.MlP + this.Jbc);
      this.isRefreshing = true;
      AppMethodBeat.o(29646);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29644);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
      this.MlK = BitmapFactory.decodeResource(getResources(), R.g.dpl);
      this.MlM = BitmapFactory.decodeResource(getResources(), R.g.dpk);
      this.MlL = BitmapFactory.decodeResource(getResources(), R.g.dpm);
      AppMethodBeat.o(29644);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29647);
      Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
      this.isRefreshing = false;
      this.MlO.stopTimer();
      if (this.MlK != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.MlK.toString() });
        this.MlK.recycle();
        this.MlK = null;
      }
      if (this.MlM != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.MlM.toString() });
        this.MlM.recycle();
        this.MlM = null;
      }
      if (this.MlL != null)
      {
        Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.MlL.toString() });
        this.MlL.recycle();
        this.MlL = null;
      }
      AppMethodBeat.o(29647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */