package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout
  extends LinearLayout
{
  private boolean bIU = false;
  private List<MaskImageView> list = new LinkedList();
  private ah oNg = new ah();
  private Runnable oNh = new MaskLinearLayout.1(this);
  
  public MaskLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnTouchListener(new MaskLinearLayout.2(this));
  }
  
  public final void b(MaskImageView paramMaskImageView)
  {
    this.list.add(paramMaskImageView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    Assert.assertTrue(false);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.bIU = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskLinearLayout
 * JD-Core Version:    0.7.0.1
 */