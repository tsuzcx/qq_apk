package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class RichTextImageView
  extends LinearLayout
{
  private Activity cup;
  private ImageView oyP;
  private TextView rGf;
  private TextView rKY;
  private boolean rKZ;
  private String rLa;
  private TextView titleTv;
  
  public RichTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38547);
    this.rKZ = false;
    this.cup = ((Activity)paramContext);
    paramContext = inflate(this.cup, 2130970858, this);
    this.rGf = ((TextView)paramContext.findViewById(2131825858));
    this.titleTv = ((TextView)paramContext.findViewById(2131825857));
    this.rKY = ((TextView)paramContext.findViewById(2131828067));
    this.oyP = ((ImageView)paramContext.findViewById(2131825855));
    AppMethodBeat.o(38547);
  }
  
  public ImageView getImageView()
  {
    return this.oyP;
  }
  
  public TextView getTitle()
  {
    return this.titleTv;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38552);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.rKZ)
    {
      AppMethodBeat.o(38552);
      return;
    }
    if (this.rLa == null)
    {
      AppMethodBeat.o(38552);
      return;
    }
    ab.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.rGf.getHeight() + " LineHeight:" + this.rGf.getLineHeight());
    paramInt3 = this.rGf.getHeight() / this.rGf.getLineHeight();
    int i = this.rGf.getLineCount();
    Rect localRect = new Rect();
    paramInt1 = 0;
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt3) {
        try
        {
          this.rGf.getLineBounds(paramInt1, localRect);
          paramInt2 += localRect.height();
          if (paramInt2 <= this.rGf.getHeight()) {
            paramInt1 += 1;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
      }
    }
    if ((i >= paramInt1) && (this.rKZ))
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 1;
      }
      paramInt1 = this.rGf.getLayout().getLineVisibleEnd(paramInt2 - 1);
      StringBuilder localStringBuilder = new StringBuilder("bottomH:").append(this.rKY.getHeight()).append("length");
      String str = this.rLa;
      ab.e("test", str.substring(paramInt1, str.length()).length());
      ab.e("test", "bottomH:" + this.rKY.getHeight());
      if (this.rKY.getText().length() > 0)
      {
        this.rKY.setVisibility(0);
        this.rKZ = false;
        new ak().post(new RichTextImageView.1(this, paramInt1));
      }
      ab.e("test", "bottom:" + paramInt4 + "   mesH:" + this.rKY.getMeasuredHeight());
    }
    AppMethodBeat.o(38552);
  }
  
  public void setImage(int paramInt)
  {
    AppMethodBeat.i(38550);
    this.oyP.setImageResource(paramInt);
    AppMethodBeat.o(38550);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(38551);
    this.oyP.setImageBitmap(paramBitmap);
    AppMethodBeat.o(38551);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(38549);
    this.rKZ = true;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.rLa = str;
    this.rGf.setText(this.rLa);
    requestLayout();
    AppMethodBeat.o(38549);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(38548);
    this.titleTv.setText(paramString);
    AppMethodBeat.o(38548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RichTextImageView
 * JD-Core Version:    0.7.0.1
 */