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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public class RichTextImageView
  extends LinearLayout
{
  private TextView Ahm;
  private TextView AmZ;
  private boolean Ana;
  private String Anb;
  private Activity dtg;
  private TextView titleTv;
  private ImageView vQu;
  
  public RichTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98234);
    this.Ana = false;
    this.dtg = ((Activity)paramContext);
    paramContext = inflate(this.dtg, 2131495582, this);
    this.Ahm = ((TextView)paramContext.findViewById(2131304202));
    this.titleTv = ((TextView)paramContext.findViewById(2131305950));
    this.AmZ = ((TextView)paramContext.findViewById(2131297478));
    this.vQu = ((ImageView)paramContext.findViewById(2131300948));
    AppMethodBeat.o(98234);
  }
  
  public ImageView getImageView()
  {
    return this.vQu;
  }
  
  public TextView getTitle()
  {
    return this.titleTv;
  }
  
  protected void onLayout(boolean paramBoolean, final int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98239);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.Ana)
    {
      AppMethodBeat.o(98239);
      return;
    }
    if (this.Anb == null)
    {
      AppMethodBeat.o(98239);
      return;
    }
    ae.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.Ahm.getHeight() + " LineHeight:" + this.Ahm.getLineHeight());
    paramInt3 = this.Ahm.getHeight() / this.Ahm.getLineHeight();
    int i = this.Ahm.getLineCount();
    Rect localRect = new Rect();
    paramInt1 = 0;
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt3) {
        try
        {
          this.Ahm.getLineBounds(paramInt1, localRect);
          paramInt2 += localRect.height();
          if (paramInt2 <= this.Ahm.getHeight()) {
            paramInt1 += 1;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
      }
    }
    if ((i >= paramInt1) && (this.Ana))
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 1;
      }
      paramInt1 = this.Ahm.getLayout().getLineVisibleEnd(paramInt2 - 1);
      StringBuilder localStringBuilder = new StringBuilder("bottomH:").append(this.AmZ.getHeight()).append("length");
      String str = this.Anb;
      ae.e("test", str.substring(paramInt1, str.length()).length());
      ae.e("test", "bottomH:" + this.AmZ.getHeight());
      if (this.AmZ.getText().length() > 0)
      {
        this.AmZ.setVisibility(0);
        this.Ana = false;
        new aq().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98233);
            RichTextImageView.b(RichTextImageView.this).setText(RichTextImageView.a(RichTextImageView.this).substring(0, paramInt1));
            RichTextImageView.c(RichTextImageView.this).setText(RichTextImageView.a(RichTextImageView.this).substring(paramInt1, RichTextImageView.a(RichTextImageView.this).length()));
            RichTextImageView.c(RichTextImageView.this).invalidate();
            RichTextImageView.d(RichTextImageView.this);
            ae.e("test", "bottomH:" + RichTextImageView.c(RichTextImageView.this).getHeight());
            AppMethodBeat.o(98233);
          }
        });
      }
      ae.e("test", "bottom:" + paramInt4 + "   mesH:" + this.AmZ.getMeasuredHeight());
    }
    AppMethodBeat.o(98239);
  }
  
  public void setImage(int paramInt)
  {
    AppMethodBeat.i(98237);
    this.vQu.setImageResource(paramInt);
    AppMethodBeat.o(98237);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(98238);
    this.vQu.setImageBitmap(paramBitmap);
    AppMethodBeat.o(98238);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98236);
    this.Ana = true;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.Anb = str;
    this.Ahm.setText(this.Anb);
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