package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  private View contentView;
  private boolean cvm;
  private boolean hPP;
  private int mPosition;
  private b qTB;
  private ImageView qTC;
  private ImageView qTD;
  private ImageView qTE;
  private ImageView qTF;
  private TextView qTG;
  private TextView qTH;
  private int qTI;
  private int qTJ;
  private float qTL;
  private int qTM;
  private int qTN;
  private int qTO;
  private int qTP;
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(70293);
    this.qTB = null;
    this.contentView = null;
    this.qTD = null;
    this.qTE = null;
    this.qTF = null;
    this.qTI = 0;
    this.mPosition = 0;
    this.qTJ = 0;
    this.hPP = false;
    this.qTL = 0.0F;
    this.cvm = false;
    this.qTM = -1;
    this.qTN = -1;
    this.qTO = -1;
    this.qTP = -1;
    init();
    AppMethodBeat.o(70293);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(70294);
    this.qTB = null;
    this.contentView = null;
    this.qTD = null;
    this.qTE = null;
    this.qTF = null;
    this.qTI = 0;
    this.mPosition = 0;
    this.qTJ = 0;
    this.hPP = false;
    this.qTL = 0.0F;
    this.cvm = false;
    this.qTM = -1;
    this.qTN = -1;
    this.qTO = -1;
    this.qTP = -1;
    init();
    AppMethodBeat.o(70294);
  }
  
  public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(70295);
    this.qTB = null;
    this.contentView = null;
    this.qTD = null;
    this.qTE = null;
    this.qTF = null;
    this.qTI = 0;
    this.mPosition = 0;
    this.qTJ = 0;
    this.hPP = false;
    this.qTL = 0.0F;
    this.cvm = false;
    this.qTM = -1;
    this.qTN = -1;
    this.qTO = -1;
    this.qTP = -1;
    init();
    AppMethodBeat.o(70295);
  }
  
  private void aFy()
  {
    AppMethodBeat.i(70304);
    if (this.qTI == 0)
    {
      AppMethodBeat.o(70304);
      return;
    }
    if (this.hPP)
    {
      AppMethodBeat.o(70304);
      return;
    }
    if (this.qTE == null)
    {
      AppMethodBeat.o(70304);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(70304);
      return;
    }
    int i = (this.qTE.getWidth() - this.qTE.getPaddingLeft() - this.qTE.getPaddingRight()) / 2;
    this.qTG.setText(ol(this.mPosition / 60) + ":" + ol(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.qTD.getLayoutParams()).leftMargin;
    int k = this.qTE.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qTE.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.qTI * getBarLen()) - i);
    this.qTE.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.qTC.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.qTI * getBarLen()));
    this.qTC.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(70304);
  }
  
  private int getBarLen()
  {
    AppMethodBeat.i(70303);
    this.qTJ = this.qTD.getWidth();
    int i = this.qTJ;
    AppMethodBeat.o(70303);
    return i;
  }
  
  private int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(70300);
    int i = ((FrameLayout.LayoutParams)this.qTD.getLayoutParams()).leftMargin;
    int j = this.qTE.getPaddingLeft();
    j = (int)((((FrameLayout.LayoutParams)this.qTE.getLayoutParams()).leftMargin - (i - j)) * 1.0D / getBarLen() * this.qTI);
    i = j;
    if (j < 0) {
      i = 0;
    }
    AppMethodBeat.o(70300);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(70296);
    this.contentView = View.inflate(getContext(), 2130970797, this);
    this.qTC = ((ImageView)this.contentView.findViewById(2131821463));
    this.qTD = ((ImageView)this.contentView.findViewById(2131821461));
    this.qTE = ((ImageView)this.contentView.findViewById(2131821464));
    this.qTF = ((ImageView)this.contentView.findViewById(2131821295));
    this.qTG = ((TextView)this.contentView.findViewById(2131821459));
    this.qTH = ((TextView)this.contentView.findViewById(2131821465));
    this.qTE.setOnTouchListener(new SnsAdNativeLandingPagesVideoPlayerLoadingBar.1(this));
    AppMethodBeat.o(70296);
  }
  
  public static String ol(int paramInt)
  {
    AppMethodBeat.i(70305);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(70305);
      return str;
    }
    AppMethodBeat.o(70305);
    return String.valueOf(paramInt);
  }
  
  public final void cmM()
  {
    this.qTJ = 0;
  }
  
  public boolean getIsPlay()
  {
    return this.cvm;
  }
  
  public int getVideoTotalTime()
  {
    return this.qTI;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(70297);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.qTM) || (paramInt2 != this.qTN) || (paramInt3 != this.qTO) || (paramInt4 != this.qTP)) {
      aFy();
    }
    this.qTM = paramInt1;
    this.qTN = paramInt2;
    this.qTO = paramInt3;
    this.qTP = paramInt4;
    AppMethodBeat.o(70297);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(70301);
    this.mPosition = paramInt;
    aFy();
    AppMethodBeat.o(70301);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.qTB = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(70299);
    this.cvm = paramBoolean;
    if (paramBoolean)
    {
      this.qTF.setImageResource(2131231637);
      AppMethodBeat.o(70299);
      return;
    }
    this.qTF.setImageResource(2131231638);
    AppMethodBeat.o(70299);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70298);
    this.qTF.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(70298);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(70302);
    if ((this.qTE.isShown()) && (this.qTE.getWidth() == 0))
    {
      post(new SnsAdNativeLandingPagesVideoPlayerLoadingBar.2(this, paramInt));
      AppMethodBeat.o(70302);
      return;
    }
    this.qTI = paramInt;
    this.mPosition = 0;
    this.qTH.setText(ol(this.qTI / 60) + ":" + ol(this.qTI % 60));
    aFy();
    AppMethodBeat.o(70302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */