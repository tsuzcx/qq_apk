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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class RichTextImageView
  extends LinearLayout
{
  private TextView EpI;
  private TextView EvL;
  private boolean EvM;
  private String EvN;
  private Activity dKq;
  private TextView titleTv;
  private ImageView zky;
  
  public RichTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98234);
    this.EvM = false;
    this.dKq = ((Activity)paramContext);
    paramContext = inflate(this.dKq, 2131496480, this);
    this.EpI = ((TextView)paramContext.findViewById(2131307116));
    this.titleTv = ((TextView)paramContext.findViewById(2131309253));
    this.EvL = ((TextView)paramContext.findViewById(2131297716));
    this.zky = ((ImageView)paramContext.findViewById(2131302578));
    AppMethodBeat.o(98234);
  }
  
  public ImageView getImageView()
  {
    return this.zky;
  }
  
  public TextView getTitle()
  {
    return this.titleTv;
  }
  
  protected void onLayout(boolean paramBoolean, final int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98239);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.EvM)
    {
      AppMethodBeat.o(98239);
      return;
    }
    if (this.EvN == null)
    {
      AppMethodBeat.o(98239);
      return;
    }
    Log.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.EpI.getHeight() + " LineHeight:" + this.EpI.getLineHeight());
    paramInt3 = this.EpI.getHeight() / this.EpI.getLineHeight();
    int i = this.EpI.getLineCount();
    Rect localRect = new Rect();
    paramInt1 = 0;
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt3) {
        try
        {
          this.EpI.getLineBounds(paramInt1, localRect);
          paramInt2 += localRect.height();
          if (paramInt2 <= this.EpI.getHeight()) {
            paramInt1 += 1;
          }
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
      }
    }
    if ((i >= paramInt1) && (this.EvM))
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = 1;
      }
      paramInt1 = this.EpI.getLayout().getLineVisibleEnd(paramInt2 - 1);
      StringBuilder localStringBuilder = new StringBuilder("bottomH:").append(this.EvL.getHeight()).append("length");
      String str = this.EvN;
      Log.e("test", str.substring(paramInt1, str.length()).length());
      Log.e("test", "bottomH:" + this.EvL.getHeight());
      if (this.EvL.getText().length() > 0)
      {
        this.EvL.setVisibility(0);
        this.EvM = false;
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
      Log.e("test", "bottom:" + paramInt4 + "   mesH:" + this.EvL.getMeasuredHeight());
    }
    AppMethodBeat.o(98239);
  }
  
  public void setImage(int paramInt)
  {
    AppMethodBeat.i(98237);
    this.zky.setImageResource(paramInt);
    AppMethodBeat.o(98237);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(98238);
    this.zky.setImageBitmap(paramBitmap);
    AppMethodBeat.o(98238);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98236);
    this.EvM = true;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.EvN = str;
    this.EpI.setText(this.EvN);
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