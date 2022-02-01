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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class RichTextImageView
  extends LinearLayout
{
  private ImageView KKl;
  private TextView Rje;
  private boolean Rjf;
  private String Rjg;
  private Activity hHU;
  private TextView titleTv;
  private TextView ycd;
  
  public RichTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98234);
    this.Rjf = false;
    this.hHU = ((Activity)paramContext);
    paramContext = inflate(this.hHU, b.g.sns_rich_text_image_view, this);
    this.ycd = ((TextView)paramContext.findViewById(b.f.righttext));
    this.titleTv = ((TextView)paramContext.findViewById(b.f.titletext));
    this.Rje = ((TextView)paramContext.findViewById(b.f.bottomtext));
    this.KKl = ((ImageView)paramContext.findViewById(b.f.image_left));
    AppMethodBeat.o(98234);
  }
  
  public ImageView getImageView()
  {
    return this.KKl;
  }
  
  public TextView getTitle()
  {
    return this.titleTv;
  }
  
  protected void onLayout(boolean paramBoolean, final int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98239);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.Rjf)
    {
      AppMethodBeat.o(98239);
      return;
    }
    if (this.Rjg == null)
    {
      AppMethodBeat.o(98239);
      return;
    }
    Log.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.ycd.getHeight() + " LineHeight:" + this.ycd.getLineHeight());
    paramInt3 = this.ycd.getHeight() / this.ycd.getLineHeight();
    int i = this.ycd.getLineCount();
    Rect localRect = new Rect();
    paramInt1 = 0;
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt3) {
        try
        {
          this.ycd.getLineBounds(paramInt1, localRect);
          paramInt2 += localRect.height();
          if (paramInt2 <= this.ycd.getHeight()) {
            paramInt1 += 1;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
      }
    }
    if ((i >= paramInt1) && (this.Rjf))
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 1;
      }
      paramInt1 = this.ycd.getLayout().getLineVisibleEnd(paramInt2 - 1);
      StringBuilder localStringBuilder = new StringBuilder("bottomH:").append(this.Rje.getHeight()).append("length");
      String str = this.Rjg;
      Log.e("test", str.substring(paramInt1, str.length()).length());
      Log.e("test", "bottomH:" + this.Rje.getHeight());
      if (this.Rje.getText().length() > 0)
      {
        this.Rje.setVisibility(0);
        this.Rjf = false;
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98233);
            RichTextImageView.b(RichTextImageView.this).setText(RichTextImageView.a(RichTextImageView.this).substring(0, paramInt1));
            RichTextImageView.c(RichTextImageView.this).setText(RichTextImageView.a(RichTextImageView.this).substring(paramInt1, RichTextImageView.a(RichTextImageView.this).length()));
            RichTextImageView.c(RichTextImageView.this).invalidate();
            RichTextImageView.d(RichTextImageView.this);
            Log.e("test", "bottomH:" + RichTextImageView.c(RichTextImageView.this).getHeight());
            AppMethodBeat.o(98233);
          }
        });
      }
      Log.e("test", "bottom:" + paramInt4 + "   mesH:" + this.Rje.getMeasuredHeight());
    }
    AppMethodBeat.o(98239);
  }
  
  public void setImage(int paramInt)
  {
    AppMethodBeat.i(98237);
    this.KKl.setImageResource(paramInt);
    AppMethodBeat.o(98237);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(98238);
    this.KKl.setImageBitmap(paramBitmap);
    AppMethodBeat.o(98238);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98236);
    this.Rjf = true;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.Rjg = str;
    this.ycd.setText(this.Rjg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RichTextImageView
 * JD-Core Version:    0.7.0.1
 */