package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements g
{
  protected boolean cvm;
  private int uLs;
  private int uLt;
  private int uLu;
  private PInt wfz;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(117963);
    this.wfz = new PInt();
    this.cvm = false;
    this.uLs = -1;
    this.uLt = -1;
    this.uLu = -1;
    AppMethodBeat.o(117963);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(117964);
    this.wfz = new PInt();
    this.cvm = false;
    this.uLs = -1;
    this.uLt = -1;
    this.uLu = -1;
    AppMethodBeat.o(117964);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(117965);
    this.wfz = new PInt();
    this.cvm = false;
    this.uLs = -1;
    this.uLt = -1;
    this.uLu = -1;
    AppMethodBeat.o(117965);
  }
  
  private int getBarPointPaddingLeft()
  {
    AppMethodBeat.i(117968);
    if (this.uLt == -1) {
      this.uLt = this.qTE.getPaddingLeft();
    }
    int i = this.uLt;
    AppMethodBeat.o(117968);
    return i;
  }
  
  private int getBarPointPaddingRight()
  {
    AppMethodBeat.i(117969);
    if (this.uLu == -1) {
      this.uLu = this.qTE.getPaddingRight();
    }
    int i = this.uLu;
    AppMethodBeat.o(117969);
    return i;
  }
  
  public final void Ef(int paramInt)
  {
    AppMethodBeat.i(117976);
    seek(paramInt);
    AppMethodBeat.o(117976);
  }
  
  public void aFy()
  {
    AppMethodBeat.i(117973);
    if (this.qTI == 0)
    {
      AppMethodBeat.o(117973);
      return;
    }
    if (this.hPP)
    {
      AppMethodBeat.o(117973);
      return;
    }
    if (this.qTE == null)
    {
      AppMethodBeat.o(117973);
      return;
    }
    if (getBarLen() == 0)
    {
      AppMethodBeat.o(117973);
      return;
    }
    this.qTG.setText(ol(this.mPosition / 60) + ":" + ol(this.mPosition % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qTE.getLayoutParams();
    int i = getBarLen();
    localLayoutParams.leftMargin = hg(this.mPosition, i);
    this.qTE.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.qTC.getLayoutParams();
    localLayoutParams.width = ((int)(this.mPosition * 1.0D / this.qTI * i));
    this.qTC.setLayoutParams(localLayoutParams);
    requestLayout();
    AppMethodBeat.o(117973);
  }
  
  public final boolean bwz()
  {
    return this.cvm;
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(117967);
    if (this.uLs == -1) {
      this.uLs = this.qTE.getWidth();
    }
    int i = this.uLs;
    AppMethodBeat.o(117967);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2130971068;
  }
  
  public ImageView getPlayBtn()
  {
    return this.qTF;
  }
  
  public TextView getPlaytimeTv()
  {
    return this.qTG;
  }
  
  protected final int hg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117970);
    if (paramInt1 <= 0)
    {
      this.qTD.getLayoutParams();
      paramInt1 = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(117970);
      return paramInt1;
      if (paramInt1 >= this.qTI) {
        paramInt1 = paramInt2 - (getBarPointWidth() - getBarPointPaddingLeft() - getBarPointPaddingRight()) / 2;
      } else {
        paramInt1 = (int)(paramInt1 * 1.0D / this.qTI * paramInt2);
      }
    }
  }
  
  public void init()
  {
    AppMethodBeat.i(117966);
    this.contentView = View.inflate(getContext(), getLayoutId(), this);
    this.qTC = ((ImageView)this.contentView.findViewById(2131821463));
    this.qTD = ((ImageView)this.contentView.findViewById(2131821461));
    this.qTE = ((ImageView)this.contentView.findViewById(2131821464));
    this.qTF = ((ImageView)this.contentView.findViewById(2131821295));
    this.qTG = ((TextView)this.contentView.findViewById(2131821459));
    this.qTH = ((TextView)this.contentView.findViewById(2131821465));
    this.qTE.setOnTouchListener(new VideoPlayerSeekBar.1(this));
    AppMethodBeat.o(117966);
  }
  
  public final void oi(boolean paramBoolean)
  {
    AppMethodBeat.i(117977);
    setIsPlay(paramBoolean);
    AppMethodBeat.o(117977);
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(117971);
    ab.d("MicroMsg.VideoPlayerSeekBar", "seek position : ".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.qTI) {
      paramInt = this.qTI;
    }
    if (this.mPosition != paramInt)
    {
      this.mPosition = paramInt;
      aFy();
    }
    AppMethodBeat.o(117971);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(117975);
    this.cvm = paramBoolean;
    super.setIsPlay(paramBoolean);
    AppMethodBeat.o(117975);
  }
  
  public void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(117974);
    if (this.qTF != null) {
      this.qTF.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(117974);
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(117972);
    this.qTI = paramInt;
    this.mPosition = 0;
    this.qTH.setText(ol(this.qTI / 60) + ":" + ol(this.qTI % 60));
    aFy();
    AppMethodBeat.o(117972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
 * JD-Core Version:    0.7.0.1
 */