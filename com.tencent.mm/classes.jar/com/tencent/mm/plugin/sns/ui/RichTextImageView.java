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
  private Activity djj;
  private TextView titleTv;
  private ImageView ttq;
  private TextView xmb;
  private TextView xrG;
  private boolean xrH;
  private String xrI;
  
  public RichTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98234);
    this.xrH = false;
    this.djj = ((Activity)paramContext);
    paramContext = inflate(this.djj, 2131495582, this);
    this.xmb = ((TextView)paramContext.findViewById(2131304202));
    this.titleTv = ((TextView)paramContext.findViewById(2131305950));
    this.xrG = ((TextView)paramContext.findViewById(2131297478));
    this.ttq = ((ImageView)paramContext.findViewById(2131300948));
    AppMethodBeat.o(98234);
  }
  
  public ImageView getImageView()
  {
    return this.ttq;
  }
  
  public TextView getTitle()
  {
    return this.titleTv;
  }
  
  protected void onLayout(boolean paramBoolean, final int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98239);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.xrH)
    {
      AppMethodBeat.o(98239);
      return;
    }
    if (this.xrI == null)
    {
      AppMethodBeat.o(98239);
      return;
    }
    ad.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.xmb.getHeight() + " LineHeight:" + this.xmb.getLineHeight());
    paramInt3 = this.xmb.getHeight() / this.xmb.getLineHeight();
    int i = this.xmb.getLineCount();
    Rect localRect = new Rect();
    paramInt1 = 0;
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt3) {
        try
        {
          this.xmb.getLineBounds(paramInt1, localRect);
          paramInt2 += localRect.height();
          if (paramInt2 <= this.xmb.getHeight()) {
            paramInt1 += 1;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
      }
    }
    if ((i >= paramInt1) && (this.xrH))
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 1;
      }
      paramInt1 = this.xmb.getLayout().getLineVisibleEnd(paramInt2 - 1);
      StringBuilder localStringBuilder = new StringBuilder("bottomH:").append(this.xrG.getHeight()).append("length");
      String str = this.xrI;
      ad.e("test", str.substring(paramInt1, str.length()).length());
      ad.e("test", "bottomH:" + this.xrG.getHeight());
      if (this.xrG.getText().length() > 0)
      {
        this.xrG.setVisibility(0);
        this.xrH = false;
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
      ad.e("test", "bottom:" + paramInt4 + "   mesH:" + this.xrG.getMeasuredHeight());
    }
    AppMethodBeat.o(98239);
  }
  
  public void setImage(int paramInt)
  {
    AppMethodBeat.i(98237);
    this.ttq.setImageResource(paramInt);
    AppMethodBeat.o(98237);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(98238);
    this.ttq.setImageBitmap(paramBitmap);
    AppMethodBeat.o(98238);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98236);
    this.xrH = true;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.xrI = str;
    this.xmb.setText(this.xrI);
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