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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public class TalkRoomVolumeMeter
  extends FrameLayout
{
  private a zXH;
  private ImageView zXI;
  private ImageView zXJ;
  private ImageView zXK;
  private FrameLayout zXL;
  
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
    this.zXH = new a(getContext());
    this.zXI = new ImageView(getContext());
    this.zXI.setScaleType(ImageView.ScaleType.FIT_XY);
    this.zXI.setImageResource(2131234331);
    this.zXI.setVisibility(0);
    this.zXJ = new ImageView(getContext());
    this.zXJ.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.zXJ.setImageResource(2131234330);
    this.zXJ.setVisibility(8);
    this.zXK = new ImageView(getContext());
    this.zXK.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.zXK.setImageResource(2131234327);
    this.zXK.setVisibility(8);
    this.zXL = new FrameLayout(getContext());
    this.zXL.addView(this.zXH);
    this.zXL.addView(this.zXJ);
    this.zXL.setVisibility(8);
    addView(this.zXL);
    addView(this.zXK);
    addView(this.zXI);
    setBackgroundColor(-16777216);
    bringChildToFront(this.zXI);
    AppMethodBeat.o(29651);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    AppMethodBeat.i(29652);
    ImageView localImageView = this.zXK;
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
    this.zXH.zXX = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.zXH.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.zXH.zXN = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.zXH.zXM = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    AppMethodBeat.i(29653);
    Object localObject = this.zXL;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = this.zXH;
      if (!((a)localObject).started)
      {
        ((a)localObject).started = true;
        ((a)localObject).zXT.au(100L, 100L);
      }
      AppMethodBeat.o(29653);
      return;
    }
    a locala = this.zXH;
    if (locala.started)
    {
      locala.started = false;
      if ((locala.zXV >= locala.zXM) && (locala.zXV <= locala.zXN)) {
        break label132;
      }
    }
    label132:
    Canvas localCanvas;
    do
    {
      do
      {
        locala.zXT.stopTimer();
        AppMethodBeat.o(29653);
        return;
      } while ((locala.zXQ == null) || (locala.zXP == null));
      localCanvas = locala.zXO.lockCanvas();
    } while ((localCanvas == null) || (locala.zXS == null));
    localCanvas.setDrawFilter(locala.zXW);
    locala.zXS.set(0, 0, locala.xnd, locala.xne + 0);
    if (locala.zXX) {}
    for (localObject = locala.zXQ;; localObject = locala.zXP)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.zXS, locala.paint);
      locala.zXO.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    a locala = this.zXH;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.zXV = (locala.zXN - (locala.zXN - locala.zXM) * (locala.value * 1.0F / locala.max));
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
    private boolean isRefreshing;
    private float[] jzv;
    int max;
    Paint paint;
    boolean started;
    int value;
    int xnd;
    int xne;
    float zXM;
    float zXN;
    SurfaceHolder zXO;
    Bitmap zXP;
    Bitmap zXQ;
    private Bitmap zXR;
    Rect zXS;
    au zXT;
    private float zXU;
    float zXV;
    PaintFlagsDrawFilter zXW;
    boolean zXX;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(29643);
      this.max = 100;
      this.value = 0;
      this.zXM = 0.0F;
      this.zXN = 0.0F;
      this.isRefreshing = false;
      this.zXU = this.zXN;
      this.zXV = this.zXN;
      this.zXX = false;
      this.started = false;
      this.zXO = getHolder();
      this.zXO.addCallback(this);
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.zXW = new PaintFlagsDrawFilter(0, 3);
      this.zXT = new au(new au.a()
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
    
    private int ebP()
    {
      AppMethodBeat.i(29645);
      if (this.zXP == null)
      {
        AppMethodBeat.o(29645);
        return 190;
      }
      int i = this.zXP.getHeight();
      AppMethodBeat.o(29645);
      return i;
    }
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(29646);
      ac.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
      this.zXN = 0.0F;
      this.zXM = (paramInt3 - ebP());
      this.zXU = this.zXN;
      this.zXV = this.zXN;
      this.xnd = paramInt2;
      this.xne = ebP();
      this.zXS = new Rect(0, (int)this.zXU, this.xnd, (int)this.zXU + this.xne);
      this.isRefreshing = true;
      AppMethodBeat.o(29646);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29644);
      ac.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
      this.zXP = BitmapFactory.decodeResource(getResources(), 2131234328);
      this.zXR = BitmapFactory.decodeResource(getResources(), 2131234327);
      this.zXQ = BitmapFactory.decodeResource(getResources(), 2131234329);
      AppMethodBeat.o(29644);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29647);
      ac.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
      this.isRefreshing = false;
      this.zXT.stopTimer();
      if (this.zXP != null)
      {
        ac.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.zXP.toString() });
        this.zXP.recycle();
        this.zXP = null;
      }
      if (this.zXR != null)
      {
        ac.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.zXR.toString() });
        this.zXR.recycle();
        this.zXR = null;
      }
      if (this.zXQ != null)
      {
        ac.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.zXQ.toString() });
        this.zXQ.recycle();
        this.zXQ = null;
      }
      AppMethodBeat.o(29647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */