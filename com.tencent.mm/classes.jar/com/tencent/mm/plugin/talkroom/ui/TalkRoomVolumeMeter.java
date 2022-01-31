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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

public class TalkRoomVolumeMeter
  extends FrameLayout
{
  private TalkRoomVolumeMeter.a tdZ;
  private ImageView tea;
  private ImageView teb;
  private ImageView tec;
  private FrameLayout ted;
  
  public TalkRoomVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25967);
    initView();
    AppMethodBeat.o(25967);
  }
  
  public TalkRoomVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25966);
    initView();
    AppMethodBeat.o(25966);
  }
  
  private void initView()
  {
    AppMethodBeat.i(25968);
    this.tdZ = new TalkRoomVolumeMeter.a(this, getContext());
    this.tea = new ImageView(getContext());
    this.tea.setScaleType(ImageView.ScaleType.FIT_XY);
    this.tea.setImageResource(2130840542);
    this.tea.setVisibility(0);
    this.teb = new ImageView(getContext());
    this.teb.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.teb.setImageResource(2130840541);
    this.teb.setVisibility(8);
    this.tec = new ImageView(getContext());
    this.tec.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.tec.setImageResource(2130840538);
    this.tec.setVisibility(8);
    this.ted = new FrameLayout(getContext());
    this.ted.addView(this.tdZ);
    this.ted.addView(this.teb);
    this.ted.setVisibility(8);
    addView(this.ted);
    addView(this.tec);
    addView(this.tea);
    setBackgroundColor(-16777216);
    bringChildToFront(this.tea);
    AppMethodBeat.o(25968);
  }
  
  private void setShowErr(boolean paramBoolean)
  {
    AppMethodBeat.i(25969);
    ImageView localImageView = this.tec;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(25969);
      return;
    }
  }
  
  private void setShowRed(boolean paramBoolean)
  {
    this.tdZ.ter = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    this.tdZ.max = paramInt;
  }
  
  public void setMaxPos(int paramInt)
  {
    this.tdZ.tef = paramInt;
  }
  
  public void setMinPos(int paramInt)
  {
    this.tdZ.tee = paramInt;
  }
  
  public void setShowFlame(boolean paramBoolean)
  {
    AppMethodBeat.i(25970);
    Object localObject = this.ted;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = this.tdZ;
      if (!((TalkRoomVolumeMeter.a)localObject).started)
      {
        ((TalkRoomVolumeMeter.a)localObject).started = true;
        ((TalkRoomVolumeMeter.a)localObject).ten.ag(100L, 100L);
      }
      AppMethodBeat.o(25970);
      return;
    }
    TalkRoomVolumeMeter.a locala = this.tdZ;
    if (locala.started)
    {
      locala.started = false;
      if ((locala.tep >= locala.tee) && (locala.tep <= locala.tef)) {
        break label132;
      }
    }
    label132:
    Canvas localCanvas;
    do
    {
      do
      {
        locala.ten.stopTimer();
        AppMethodBeat.o(25970);
        return;
      } while ((locala.tei == null) || (locala.teh == null));
      localCanvas = locala.teg.lockCanvas();
    } while ((localCanvas == null) || (locala.tek == null));
    localCanvas.setDrawFilter(locala.teq);
    locala.tek.set(0, 0, locala.tem, locala.tel + 0);
    if (locala.ter) {}
    for (localObject = locala.tei;; localObject = locala.teh)
    {
      localCanvas.drawBitmap((Bitmap)localObject, null, locala.tek, locala.paint);
      locala.teg.unlockCanvasAndPost(localCanvas);
      break;
    }
  }
  
  public void setValue(int paramInt)
  {
    TalkRoomVolumeMeter.a locala = this.tdZ;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      locala.value = i;
      locala.tep = (locala.tef - (locala.tef - locala.tee) * (locala.value * 1.0F / locala.max));
      return;
      i = paramInt;
      if (paramInt > locala.max) {
        i = locala.max;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter
 * JD-Core Version:    0.7.0.1
 */