package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  protected View contentView;
  public boolean hPP;
  public int mPosition;
  public b qTB;
  public ImageView qTC;
  public ImageView qTD;
  public ImageView qTE;
  protected ImageView qTF;
  public TextView qTG;
  protected TextView qTH;
  public int qTI;
  private int qTJ;
  private int qTK;
  public float qTL;
  private int qTM;
  private int qTN;
  private int qTO;
  private int qTP;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(117918);
    this.qTB = null;
    this.contentView = null;
    this.qTD = null;
    this.qTE = null;
    this.qTF = null;
    this.qTI = 0;
    this.mPosition = 0;
    this.qTJ = 0;
    this.qTK = 0;
    this.hPP = false;
    this.qTL = 0.0F;
    this.qTM = -1;
    this.qTN = -1;
    this.qTO = -1;
    this.qTP = -1;
    init();
    AppMethodBeat.o(117918);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(117919);
    this.qTB = null;
    this.contentView = null;
    this.qTD = null;
    this.qTE = null;
    this.qTF = null;
    this.qTI = 0;
    this.mPosition = 0;
    this.qTJ = 0;
    this.qTK = 0;
    this.hPP = false;
    this.qTL = 0.0F;
    this.qTM = -1;
    this.qTN = -1;
    this.qTO = -1;
    this.qTP = -1;
    init();
    AppMethodBeat.o(117919);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(117920);
    this.qTB = null;
    this.contentView = null;
    this.qTD = null;
    this.qTE = null;
    this.qTF = null;
    this.qTI = 0;
    this.mPosition = 0;
    this.qTJ = 0;
    this.qTK = 0;
    this.hPP = false;
    this.qTL = 0.0F;
    this.qTM = -1;
    this.qTN = -1;
    this.qTO = -1;
    this.qTP = -1;
    init();
    AppMethodBeat.o(117920);
  }
  
  public static String ol(int paramInt)
  {
    AppMethodBeat.i(117932);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(117932);
      return str;
    }
    AppMethodBeat.o(117932);
    return String.valueOf(paramInt);
  }
  
  public void aFy()
  {
    AppMethodBeat.i(117931);
    if (this.qTI == 0)
    {
      AppMethodBeat.o(117931);
      return;
    }
    if (this.hPP)
    {
      AppMethodBeat.o(117931);
      return;
    }
    if (this.qTE == null)
    {
      AppMethodBeat.o(117931);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(117931);
      return;
    }
    int i = (getBarPointWidth() - this.qTE.getPaddingLeft() - this.qTE.getPaddingRight()) / 2;
    this.qTG.setText(ol(this.mPosition / 60) + ":" + ol(this.mPosition % 60));
    int j = ((FrameLayout.LayoutParams)this.qTD.getLayoutParams()).leftMargin;
    int k = this.qTE.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qTE.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.mPosition * 1.0D / this.qTI * getBarLen()) - i);
    this.qTE.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.qTC.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.qTI * getBarLen()));
    this.qTC.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(117931);
  }
  
  public final void cmL()
  {
    AppMethodBeat.i(117928);
    this.qTH.setText(ol(this.qTI / 60) + ":" + ol(this.qTI % 60));
    aFy();
    AppMethodBeat.o(117928);
  }
  
  public final void cmM()
  {
    this.qTJ = 0;
  }
  
  public int getBarLen()
  {
    AppMethodBeat.i(117929);
    if (this.qTJ <= 0) {
      this.qTJ = this.qTD.getWidth();
    }
    int i = this.qTJ;
    AppMethodBeat.o(117929);
    return i;
  }
  
  protected int getBarPointWidth()
  {
    AppMethodBeat.i(117930);
    if (this.qTK <= 0) {
      this.qTK = this.qTE.getWidth();
    }
    int i = this.qTK;
    AppMethodBeat.o(117930);
    return i;
  }
  
  protected int getCurrentTimeByBarPoint()
  {
    AppMethodBeat.i(117925);
    int i = ((FrameLayout.LayoutParams)this.qTD.getLayoutParams()).leftMargin;
    int j = this.qTE.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.qTE.getLayoutParams()).leftMargin - (i - j) + (getBarPointWidth() - this.qTE.getPaddingLeft() - this.qTE.getPaddingRight()) / 2) * 1.0D / getBarLen() * this.qTI));
    AppMethodBeat.o(117925);
    return i;
  }
  
  protected int getLayoutId()
  {
    return 2130971067;
  }
  
  public int getVideoTotalTime()
  {
    return this.qTI;
  }
  
  public int getmPosition()
  {
    return this.mPosition;
  }
  
  protected void init()
  {
    AppMethodBeat.i(117921);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.qTC = ((ImageView)this.contentView.findViewById(2131821463));
    this.qTD = ((ImageView)this.contentView.findViewById(2131821461));
    this.qTE = ((ImageView)this.contentView.findViewById(2131821464));
    this.qTF = ((ImageView)this.contentView.findViewById(2131821295));
    this.qTG = ((TextView)this.contentView.findViewById(2131821459));
    this.qTH = ((TextView)this.contentView.findViewById(2131821465));
    this.qTE.setOnTouchListener(new AdVideoPlayerLoadingBar.1(this));
    this.qTE.post(new AdVideoPlayerLoadingBar.2(this));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qTC.getLayoutParams();
    localLayoutParams.width = 0;
    this.qTC.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(117921);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(117922);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.qTJ = 0;
    if ((paramInt1 != this.qTM) || (paramInt2 != this.qTN) || (paramInt3 != this.qTO) || (paramInt4 != this.qTP)) {
      aFy();
    }
    this.qTM = paramInt1;
    this.qTN = paramInt2;
    this.qTO = paramInt3;
    this.qTP = paramInt4;
    AppMethodBeat.o(117922);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(117926);
    this.mPosition = paramInt;
    aFy();
    AppMethodBeat.o(117926);
  }
  
  public void setIplaySeekCallback(b paramb)
  {
    this.qTB = paramb;
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(117924);
    if (paramBoolean)
    {
      this.qTF.setImageResource(2131231637);
      AppMethodBeat.o(117924);
      return;
    }
    this.qTF.setImageResource(2131231638);
    AppMethodBeat.o(117924);
  }
  
  public void setOnPlayButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(117923);
    this.qTF.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(117923);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(117927);
    this.qTI = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new AdVideoPlayerLoadingBar.3(this));
      AppMethodBeat.o(117927);
      return;
    }
    cmL();
    AppMethodBeat.o(117927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
 * JD-Core Version:    0.7.0.1
 */