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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class RichTextImageView
  extends LinearLayout
{
  private Activity dsa;
  private TextView titleTv;
  private ImageView vEq;
  private TextView zQf;
  private TextView zVR;
  private boolean zVS;
  private String zVT;
  
  public RichTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98234);
    this.zVS = false;
    this.dsa = ((Activity)paramContext);
    paramContext = inflate(this.dsa, 2131495582, this);
    this.zQf = ((TextView)paramContext.findViewById(2131304202));
    this.titleTv = ((TextView)paramContext.findViewById(2131305950));
    this.zVR = ((TextView)paramContext.findViewById(2131297478));
    this.vEq = ((ImageView)paramContext.findViewById(2131300948));
    AppMethodBeat.o(98234);
  }
  
  public ImageView getImageView()
  {
    return this.vEq;
  }
  
  public TextView getTitle()
  {
    return this.titleTv;
  }
  
  protected void onLayout(boolean paramBoolean, final int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98239);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.zVS)
    {
      AppMethodBeat.o(98239);
      return;
    }
    if (this.zVT == null)
    {
      AppMethodBeat.o(98239);
      return;
    }
    ad.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.zQf.getHeight() + " LineHeight:" + this.zQf.getLineHeight());
    paramInt3 = this.zQf.getHeight() / this.zQf.getLineHeight();
    int i = this.zQf.getLineCount();
    Rect localRect = new Rect();
    paramInt1 = 0;
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt3) {
        try
        {
          this.zQf.getLineBounds(paramInt1, localRect);
          paramInt2 += localRect.height();
          if (paramInt2 <= this.zQf.getHeight()) {
            paramInt1 += 1;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
      }
    }
    if ((i >= paramInt1) && (this.zVS))
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 1;
      }
      paramInt1 = this.zQf.getLayout().getLineVisibleEnd(paramInt2 - 1);
      StringBuilder localStringBuilder = new StringBuilder("bottomH:").append(this.zVR.getHeight()).append("length");
      String str = this.zVT;
      ad.e("test", str.substring(paramInt1, str.length()).length());
      ad.e("test", "bottomH:" + this.zVR.getHeight());
      if (this.zVR.getText().length() > 0)
      {
        this.zVR.setVisibility(0);
        this.zVS = false;
        new ap().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98233);
            RichTextImageView.b(RichTextImageView.this).setText(RichTextImageView.a(RichTextImageView.this).substring(0, paramInt1));
            RichTextImageView.c(RichTextImageView.this).setText(RichTextImageView.a(RichTextImageView.this).substring(paramInt1, RichTextImageView.a(RichTextImageView.this).length()));
            RichTextImageView.c(RichTextImageView.this).invalidate();
            RichTextImageView.d(RichTextImageView.this);
            ad.e("test", "bottomH:" + RichTextImageView.c(RichTextImageView.this).getHeight());
            AppMethodBeat.o(98233);
          }
        });
      }
      ad.e("test", "bottom:" + paramInt4 + "   mesH:" + this.zVR.getMeasuredHeight());
    }
    AppMethodBeat.o(98239);
  }
  
  public void setImage(int paramInt)
  {
    AppMethodBeat.i(98237);
    this.vEq.setImageResource(paramInt);
    AppMethodBeat.o(98237);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(98238);
    this.vEq.setImageBitmap(paramBitmap);
    AppMethodBeat.o(98238);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98236);
    this.zVS = true;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.zVT = str;
    this.zQf.setText(this.zVT);
    requestLayout();
    AppMethodBeat.o(98236);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(98235);
    this.titleTv.setText(paramString);
    AppMethodBeat.o(98235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RichTextImageView
 * JD-Core Version:    0.7.0.1
 */