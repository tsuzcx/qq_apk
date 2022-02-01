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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public class TalkRoomVolumeMeter
  extends FrameLayout
{
  private a yKu;
  private ImageView yKv;
  private ImageView yKw;
  private ImageView yKx;
  private FrameLayout yKy;
  
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
    this.yKu = new a(getContext());
    this.yKv = new ImageView(getContext());
    this.yKv.setScaleType(ImageView.ScaleType.FIT_XY);
    this.yKv.setImageResource(2131234331);
    this.yKv.setVisibility(0);
    this.yKw = new ImageView(getContext());
    this.yKw.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.yKw.setImageResource(2131234330);
    this.yKw.setVisibility(8);
    this.yKx = new ImageView(getContext());
    this.yKx.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.yKx.setImageResource(2131234327);
    this.yKx.setVisibility(8);
    this.yKy = new FrameLayout(getContext());
    this.yKy.addView(this.yKu);
    this.yKy.addView(this.yKw);
    this.yKy.setVisibility(8);
    addView(this.yKy);
    addView(this.yKx);
    addView(this.yKv);
    setBackgroundColor(-16777216);
    bringChildToFront(this.yKv);
    AppMethodBeat.o(29651);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    AppMethodBeat.i(29652);
    ImageView localImageView = this.yKx;
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
    this.yKu.yKK = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.yKu.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.yKu.yKA = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.yKu.yKz = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    AppMethodBeat.i(29653);
    Object localObject = this.yKy;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = this.yKu;
      if (!((a)localObject).started)
      {
        ((a)localObject).started = true;
        ((a)localObject).yKG.av(100L, 100L);
      }
      AppMethodBeat.o(29653);
      return;
    }
    a locala = this.yKu;
    if (locala.started)
    {
      locala.started = false;
      if ((locala.yKI >= locala.yKz) && (locala.yKI <= locala.yKA)) {
        break label132;
      }
    }
    label132:
    Canvas localCanvas;
    do
    {
      do
      {
        locala.yKG.stopTimer();
        AppMethodBeat.o(29653);
        return;
      } while ((locala.yKD == null) || (locala.yKC == null));
      localCanvas = locala.yKB.lockCanvas();
    } while ((localCanvas == null) || (locala.yKF == null));
    localCanvas.setDrawFilter(locala.yKJ);
    locala.yKF.set(0, 0, locala.wbW, locala.wbX + 0);
    if (locala.yKK) {}
    for (localObject = locala.yKD;; localObject = locala.yKC)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.yKF, locala.paint);
      locala.yKB.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    a locala = this.yKu;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.yKI = (locala.yKA - (locala.yKA - locala.yKz) * (locala.value * 1.0F / locala.max));
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
    private float[] iZf;
    private boolean isRefreshing;
    int max;
    Paint paint;
    boolean started;
    int value;
    int wbW;
    int wbX;
    float yKA;
    SurfaceHolder yKB;
    Bitmap yKC;
    Bitmap yKD;
    private Bitmap yKE;
    Rect yKF;
    av yKG;
    private float yKH;
    float yKI;
    PaintFlagsDrawFilter yKJ;
    boolean yKK;
    float yKz;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(29643);
      this.max = 100;
      this.value = 0;
      this.yKz = 0.0F;
      this.yKA = 0.0F;
      this.isRefreshing = false;
      this.yKH = this.yKA;
      this.yKI = this.yKA;
      this.yKK = false;
      this.started = false;
      this.yKB = getHolder();
      this.yKB.addCallback(this);
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.yKJ = new PaintFlagsDrawFilter(0, 3);
      this.yKG = new av(new av.a()
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
    
    private int dNp()
    {
      AppMethodBeat.i(29645);
      if (this.yKC == null)
      {
        AppMethodBeat.o(29645);
        return 190;
      }
      int i = this.yKC.getHeight();
      AppMethodBeat.o(29645);
      return i;
    }
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(29646);
      ad.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
      this.yKA = 0.0F;
      this.yKz = (paramInt3 - dNp());
      this.yKH = this.yKA;
      this.yKI = this.yKA;
      this.wbW = paramInt2;
      this.wbX = dNp();
      this.yKF = new Rect(0, (int)this.yKH, this.wbW, (int)this.yKH + this.wbX);
      this.isRefreshing = true;
      AppMethodBeat.o(29646);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29644);
      ad.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
      this.yKC = BitmapFactory.decodeResource(getResources(), 2131234328);
      this.yKE = BitmapFactory.decodeResource(getResources(), 2131234327);
      this.yKD = BitmapFactory.decodeResource(getResources(), 2131234329);
      AppMethodBeat.o(29644);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29647);
      ad.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
      this.isRefreshing = false;
      this.yKG.stopTimer();
      if (this.yKC != null)
      {
        ad.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.yKC.toString() });
        this.yKC.recycle();
        this.yKC = null;
      }
      if (this.yKE != null)
      {
        ad.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.yKE.toString() });
        this.yKE.recycle();
        this.yKE = null;
      }
      if (this.yKD != null)
      {
        ad.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.yKD.toString() });
        this.yKD.recycle();
        this.yKD = null;
      }
      AppMethodBeat.o(29647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */