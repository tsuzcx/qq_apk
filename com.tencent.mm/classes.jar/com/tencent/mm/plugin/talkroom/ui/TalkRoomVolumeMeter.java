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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public class TalkRoomVolumeMeter
  extends FrameLayout
{
  private a BGK;
  private ImageView BGL;
  private ImageView BGM;
  private ImageView BGN;
  private FrameLayout BGO;
  
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
    this.BGK = new a(getContext());
    this.BGL = new ImageView(getContext());
    this.BGL.setScaleType(ImageView.ScaleType.FIT_XY);
    this.BGL.setImageResource(2131234331);
    this.BGL.setVisibility(0);
    this.BGM = new ImageView(getContext());
    this.BGM.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.BGM.setImageResource(2131234330);
    this.BGM.setVisibility(8);
    this.BGN = new ImageView(getContext());
    this.BGN.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.BGN.setImageResource(2131234327);
    this.BGN.setVisibility(8);
    this.BGO = new FrameLayout(getContext());
    this.BGO.addView(this.BGK);
    this.BGO.addView(this.BGM);
    this.BGO.setVisibility(8);
    addView(this.BGO);
    addView(this.BGN);
    addView(this.BGL);
    setBackgroundColor(-16777216);
    bringChildToFront(this.BGL);
    AppMethodBeat.o(29651);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    AppMethodBeat.i(29652);
    ImageView localImageView = this.BGN;
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
    this.BGK.BHa = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.BGK.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.BGK.BGQ = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.BGK.BGP = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    AppMethodBeat.i(29653);
    Object localObject = this.BGO;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = this.BGK;
      if (!((a)localObject).started)
      {
        ((a)localObject).started = true;
        ((a)localObject).BGW.ay(100L, 100L);
      }
      AppMethodBeat.o(29653);
      return;
    }
    a locala = this.BGK;
    if (locala.started)
    {
      locala.started = false;
      if ((locala.BGY >= locala.BGP) && (locala.BGY <= locala.BGQ)) {
        break label132;
      }
    }
    label132:
    Canvas localCanvas;
    do
    {
      do
      {
        locala.BGW.stopTimer();
        AppMethodBeat.o(29653);
        return;
      } while ((locala.BGT == null) || (locala.BGS == null));
      localCanvas = locala.BGR.lockCanvas();
    } while ((localCanvas == null) || (locala.BGV == null));
    localCanvas.setDrawFilter(locala.BGZ);
    locala.BGV.set(0, 0, locala.yRe, locala.yRf + 0);
    if (locala.BHa) {}
    for (localObject = locala.BGT;; localObject = locala.BGS)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.BGV, locala.paint);
      locala.BGR.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    a locala = this.BGK;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.BGY = (locala.BGQ - (locala.BGQ - locala.BGP) * (locala.value * 1.0F / locala.max));
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
    float BGP;
    float BGQ;
    SurfaceHolder BGR;
    Bitmap BGS;
    Bitmap BGT;
    private Bitmap BGU;
    Rect BGV;
    aw BGW;
    private float BGX;
    float BGY;
    PaintFlagsDrawFilter BGZ;
    boolean BHa;
    private boolean isRefreshing;
    private float[] jWJ;
    int max;
    Paint paint;
    boolean started;
    int value;
    int yRe;
    int yRf;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(29643);
      this.max = 100;
      this.value = 0;
      this.BGP = 0.0F;
      this.BGQ = 0.0F;
      this.isRefreshing = false;
      this.BGX = this.BGQ;
      this.BGY = this.BGQ;
      this.BHa = false;
      this.started = false;
      this.BGR = getHolder();
      this.BGR.addCallback(this);
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.BGZ = new PaintFlagsDrawFilter(0, 3);
      this.BGW = new aw(new aw.a()
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
    
    private int erN()
    {
      AppMethodBeat.i(29645);
      if (this.BGS == null)
      {
        AppMethodBeat.o(29645);
        return 190;
      }
      int i = this.BGS.getHeight();
      AppMethodBeat.o(29645);
      return i;
    }
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(29646);
      ae.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
      this.BGQ = 0.0F;
      this.BGP = (paramInt3 - erN());
      this.BGX = this.BGQ;
      this.BGY = this.BGQ;
      this.yRe = paramInt2;
      this.yRf = erN();
      this.BGV = new Rect(0, (int)this.BGX, this.yRe, (int)this.BGX + this.yRf);
      this.isRefreshing = true;
      AppMethodBeat.o(29646);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29644);
      ae.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
      this.BGS = BitmapFactory.decodeResource(getResources(), 2131234328);
      this.BGU = BitmapFactory.decodeResource(getResources(), 2131234327);
      this.BGT = BitmapFactory.decodeResource(getResources(), 2131234329);
      AppMethodBeat.o(29644);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29647);
      ae.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
      this.isRefreshing = false;
      this.BGW.stopTimer();
      if (this.BGS != null)
      {
        ae.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.BGS.toString() });
        this.BGS.recycle();
        this.BGS = null;
      }
      if (this.BGU != null)
      {
        ae.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.BGU.toString() });
        this.BGU.recycle();
        this.BGU = null;
      }
      if (this.BGT != null)
      {
        ae.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.BGT.toString() });
        this.BGT.recycle();
        this.BGT = null;
      }
      AppMethodBeat.o(29647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */