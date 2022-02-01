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
  private a Bpl;
  private ImageView Bpm;
  private ImageView Bpn;
  private ImageView Bpo;
  private FrameLayout Bpp;
  
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
    this.Bpl = new a(getContext());
    this.Bpm = new ImageView(getContext());
    this.Bpm.setScaleType(ImageView.ScaleType.FIT_XY);
    this.Bpm.setImageResource(2131234331);
    this.Bpm.setVisibility(0);
    this.Bpn = new ImageView(getContext());
    this.Bpn.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Bpn.setImageResource(2131234330);
    this.Bpn.setVisibility(8);
    this.Bpo = new ImageView(getContext());
    this.Bpo.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.Bpo.setImageResource(2131234327);
    this.Bpo.setVisibility(8);
    this.Bpp = new FrameLayout(getContext());
    this.Bpp.addView(this.Bpl);
    this.Bpp.addView(this.Bpn);
    this.Bpp.setVisibility(8);
    addView(this.Bpp);
    addView(this.Bpo);
    addView(this.Bpm);
    setBackgroundColor(-16777216);
    bringChildToFront(this.Bpm);
    AppMethodBeat.o(29651);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    AppMethodBeat.i(29652);
    ImageView localImageView = this.Bpo;
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
    this.Bpl.BpB = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.Bpl.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.Bpl.Bpr = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.Bpl.Bpq = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    AppMethodBeat.i(29653);
    Object localObject = this.Bpp;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = this.Bpl;
      if (!((a)localObject).started)
      {
        ((a)localObject).started = true;
        ((a)localObject).Bpx.az(100L, 100L);
      }
      AppMethodBeat.o(29653);
      return;
    }
    a locala = this.Bpl;
    if (locala.started)
    {
      locala.started = false;
      if ((locala.Bpz >= locala.Bpq) && (locala.Bpz <= locala.Bpr)) {
        break label132;
      }
    }
    label132:
    Canvas localCanvas;
    do
    {
      do
      {
        locala.Bpx.stopTimer();
        AppMethodBeat.o(29653);
        return;
      } while ((locala.Bpu == null) || (locala.Bpt == null));
      localCanvas = locala.Bps.lockCanvas();
    } while ((localCanvas == null) || (locala.Bpw == null));
    localCanvas.setDrawFilter(locala.BpA);
    locala.Bpw.set(0, 0, locala.yBe, locala.yBf + 0);
    if (locala.BpB) {}
    for (localObject = locala.Bpu;; localObject = locala.Bpt)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.Bpw, locala.paint);
      locala.Bps.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    a locala = this.Bpl;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.Bpz = (locala.Bpr - (locala.Bpr - locala.Bpq) * (locala.value * 1.0F / locala.max));
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
    PaintFlagsDrawFilter BpA;
    boolean BpB;
    float Bpq;
    float Bpr;
    SurfaceHolder Bps;
    Bitmap Bpt;
    Bitmap Bpu;
    private Bitmap Bpv;
    Rect Bpw;
    av Bpx;
    private float Bpy;
    float Bpz;
    private boolean isRefreshing;
    private float[] jTs;
    int max;
    Paint paint;
    boolean started;
    int value;
    int yBe;
    int yBf;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(29643);
      this.max = 100;
      this.value = 0;
      this.Bpq = 0.0F;
      this.Bpr = 0.0F;
      this.isRefreshing = false;
      this.Bpy = this.Bpr;
      this.Bpz = this.Bpr;
      this.BpB = false;
      this.started = false;
      this.Bps = getHolder();
      this.Bps.addCallback(this);
      this.paint = new Paint();
      this.paint.setAntiAlias(true);
      this.BpA = new PaintFlagsDrawFilter(0, 3);
      this.Bpx = new av(new av.a()
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
    
    private int eog()
    {
      AppMethodBeat.i(29645);
      if (this.Bpt == null)
      {
        AppMethodBeat.o(29645);
        return 190;
      }
      int i = this.Bpt.getHeight();
      AppMethodBeat.o(29645);
      return i;
    }
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(29646);
      ad.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + paramInt2 + " height = " + paramInt3);
      this.Bpr = 0.0F;
      this.Bpq = (paramInt3 - eog());
      this.Bpy = this.Bpr;
      this.Bpz = this.Bpr;
      this.yBe = paramInt2;
      this.yBf = eog();
      this.Bpw = new Rect(0, (int)this.Bpy, this.yBe, (int)this.Bpy + this.yBf);
      this.isRefreshing = true;
      AppMethodBeat.o(29646);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29644);
      ad.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
      this.Bpt = BitmapFactory.decodeResource(getResources(), 2131234328);
      this.Bpv = BitmapFactory.decodeResource(getResources(), 2131234327);
      this.Bpu = BitmapFactory.decodeResource(getResources(), 2131234329);
      AppMethodBeat.o(29644);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(29647);
      ad.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
      this.isRefreshing = false;
      this.Bpx.stopTimer();
      if (this.Bpt != null)
      {
        ad.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.Bpt.toString() });
        this.Bpt.recycle();
        this.Bpt = null;
      }
      if (this.Bpv != null)
      {
        ad.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.Bpv.toString() });
        this.Bpv.recycle();
        this.Bpv = null;
      }
      if (this.Bpu != null)
      {
        ad.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", new Object[] { this.Bpu.toString() });
        this.Bpu.recycle();
        this.Bpu = null;
      }
      AppMethodBeat.o(29647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */