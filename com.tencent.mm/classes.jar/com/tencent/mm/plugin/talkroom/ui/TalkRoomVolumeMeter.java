package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.am;

public class TalkRoomVolumeMeter
  extends FrameLayout
{
  private TalkRoomVolumeMeter.a pCp;
  private ImageView pCq;
  private ImageView pCr;
  private ImageView pCs;
  private FrameLayout pCt;
  
  public TalkRoomVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public TalkRoomVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    this.pCp = new TalkRoomVolumeMeter.a(this, getContext());
    this.pCq = new ImageView(getContext());
    this.pCq.setScaleType(ImageView.ScaleType.FIT_XY);
    this.pCq.setImageResource(R.g.talk_room_volume_net);
    this.pCq.setVisibility(0);
    this.pCr = new ImageView(getContext());
    this.pCr.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.pCr.setImageResource(R.g.talk_room_volume_mask);
    this.pCr.setVisibility(8);
    this.pCs = new ImageView(getContext());
    this.pCs.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.pCs.setImageResource(R.g.talk_room_volume_err);
    this.pCs.setVisibility(8);
    this.pCt = new FrameLayout(getContext());
    this.pCt.addView(this.pCp);
    this.pCt.addView(this.pCr);
    this.pCt.setVisibility(8);
    addView(this.pCt);
    addView(this.pCs);
    addView(this.pCq);
    setBackgroundColor(-16777216);
    bringChildToFront(this.pCq);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    ImageView localImageView = this.pCs;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  private void setShowRed(boolean paramBoolean)
  {
    this.pCp.pCI = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.pCp.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.pCp.pCv = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.pCp.pCu = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    Object localObject = this.pCt;
    int i;
    if (paramBoolean)
    {
      i = 0;
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break label57;
      }
      localObject = this.pCp;
      if (!((TalkRoomVolumeMeter.a)localObject).started)
      {
        ((TalkRoomVolumeMeter.a)localObject).started = true;
        ((TalkRoomVolumeMeter.a)localObject).pCD.S(100L, 100L);
      }
    }
    label57:
    TalkRoomVolumeMeter.a locala;
    do
    {
      return;
      i = 8;
      break;
      locala = this.pCp;
    } while (!locala.started);
    locala.started = false;
    if ((locala.pCG < locala.pCu) || (locala.pCG > locala.pCv)) {}
    Canvas localCanvas;
    do
    {
      do
      {
        locala.pCD.stopTimer();
        return;
      } while ((locala.pCy == null) || (locala.pCx == null));
      localCanvas = locala.pCw.lockCanvas();
    } while ((localCanvas == null) || (locala.pCA == null));
    localCanvas.setDrawFilter(locala.pCH);
    locala.pCA.set(0, 0, locala.pCC, locala.pCB + 0);
    if (locala.pCI) {}
    for (localObject = locala.pCy;; localObject = locala.pCx)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.pCA, locala.gaZ);
      locala.pCw.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    TalkRoomVolumeMeter.a locala = this.pCp;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.pCG = (locala.pCv - (locala.pCv - locala.pCu) * (locala.value * 1.0F / locala.max));
      return;
      i = paramInt;
      if (paramInt > locala.max) {
        i = locala.max;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */