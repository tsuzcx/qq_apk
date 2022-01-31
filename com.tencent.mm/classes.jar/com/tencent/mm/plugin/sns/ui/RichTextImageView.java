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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class RichTextImageView
  extends LinearLayout
{
  private Activity bMV;
  private TextView eXr;
  private ImageView lZh;
  private TextView oOu;
  private TextView oTb;
  private boolean oTc = false;
  private String oTd;
  
  public RichTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bMV = ((Activity)paramContext);
    paramContext = inflate(this.bMV, i.g.sns_rich_text_image_view, this);
    this.oOu = ((TextView)paramContext.findViewById(i.f.righttext));
    this.eXr = ((TextView)paramContext.findViewById(i.f.titletext));
    this.oTb = ((TextView)paramContext.findViewById(i.f.bottomtext));
    this.lZh = ((ImageView)paramContext.findViewById(i.f.image_left));
  }
  
  public ImageView getImageView()
  {
    return this.lZh;
  }
  
  public TextView getTitle()
  {
    return this.eXr;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.oTc) {}
    int i;
    do
    {
      do
      {
        return;
      } while (this.oTd == null);
      y.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.oOu.getHeight() + " LineHeight:" + this.oOu.getLineHeight());
      paramInt3 = this.oOu.getHeight() / this.oOu.getLineHeight();
      i = this.oOu.getLineCount();
      Rect localRect = new Rect();
      paramInt1 = 0;
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt1 < paramInt3) {
          try
          {
            this.oOu.getLineBounds(paramInt1, localRect);
            paramInt2 += localRect.height();
            if (paramInt2 <= this.oOu.getHeight()) {
              paramInt1 += 1;
            }
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
        }
      }
    } while ((i < paramInt1) || (!this.oTc));
    paramInt2 = paramInt1;
    if (paramInt1 <= 0) {
      paramInt2 = 1;
    }
    paramInt1 = this.oOu.getLayout().getLineVisibleEnd(paramInt2 - 1);
    y.e("test", "bottomH:" + this.oTb.getHeight() + "length" + this.oTd.substring(paramInt1, this.oTd.length()).length());
    y.e("test", "bottomH:" + this.oTb.getHeight());
    if (this.oTb.getText().length() > 0)
    {
      this.oTb.setVisibility(0);
      this.oTc = false;
      new ah().post(new RichTextImageView.1(this, paramInt1));
    }
    y.e("test", "bottom:" + paramInt4 + "   mesH:" + this.oTb.getMeasuredHeight());
  }
  
  public void setImage(int paramInt)
  {
    this.lZh.setImageResource(paramInt);
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    this.lZh.setImageBitmap(paramBitmap);
  }
  
  public void setText(String paramString)
  {
    this.oTc = true;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.oTd = str;
    this.oOu.setText(this.oTd);
    requestLayout();
  }
  
  public void setTitle(String paramString)
  {
    this.eXr.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.RichTextImageView
 * JD-Core Version:    0.7.0.1
 */