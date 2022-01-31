package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.y;

public class SightPlayAutoSizeImageView
  extends ImageView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  private b ofD = new SightPlayAutoSizeImageView.a(this);
  
  public SightPlayAutoSizeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayAutoSizeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void aW(String paramString, boolean paramBoolean)
  {
    this.ofD.aW(paramString, paramBoolean);
  }
  
  public final void bAX()
  {
    setImageBitmap(null);
    setImageResource(R.g.nosdcard_chatting_bg);
  }
  
  public final boolean bAY()
  {
    return this.ofD.bBb();
  }
  
  public final void clear()
  {
    this.ofD.clear();
  }
  
  public final void dL(int paramInt1, int paramInt2) {}
  
  public Object getTagObject()
  {
    return getTag();
  }
  
  public Context getUIContext()
  {
    return getContext();
  }
  
  public String getVideoPath()
  {
    return this.ofD.oep;
  }
  
  protected void onAttachedToWindow()
  {
    y.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.udP.c(this.ofD.bBd());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    y.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.ofD.clear();
    com.tencent.mm.sdk.b.a.udP.d(this.ofD.bBd());
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.ofD.oeK = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt) {}
  
  public void setForceRecordState(boolean paramBoolean)
  {
    this.ofD.oeT = paramBoolean;
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.ofD.oeN = paramBoolean;
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.ofD.oeV = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.ofD.oeW = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg) {}
  
  public void setPosition(int paramInt)
  {
    this.ofD.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    this.ofD.setSightInfoView(paramTextView);
  }
  
  public void setTagObject(Object paramObject)
  {
    setTag(paramObject);
  }
  
  public void setThumbBgView(View paramView)
  {
    this.ofD.setThumbBgView(paramView);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayAutoSizeImageView
 * JD-Core Version:    0.7.0.1
 */