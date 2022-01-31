package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class aj
{
  public String crk;
  public int position;
  public a qVe;
  public TimeLineObject rLC;
  public View rLD;
  public View rLE;
  public MMPinProgressBtn rLF;
  public TextView rLG;
  public int rLH = 2;
  public boolean rLI = false;
  public int rLJ = 0;
  public boolean raZ = false;
  public ImageView rwJ;
  public TextView rwK;
  
  public final void a(TimeLineObject paramTimeLineObject, int paramInt, String paramString, boolean paramBoolean)
  {
    this.rLC = paramTimeLineObject;
    this.position = paramInt;
    this.crk = paramString;
    this.raZ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aj
 * JD-Core Version:    0.7.0.1
 */