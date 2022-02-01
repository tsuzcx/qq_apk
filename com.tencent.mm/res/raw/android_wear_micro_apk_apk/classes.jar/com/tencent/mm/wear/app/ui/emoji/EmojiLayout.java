package com.tencent.mm.wear.app.ui.emoji;

import android.content.Context;
import android.support.wearable.view.aa;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.c.a;
import com.tencent.mm.wear.app.emoji.gif.MMGIFImageView;

public class EmojiLayout
  extends RelativeLayout
  implements aa
{
  public MMGIFImageView ajf;
  private String ajg;
  
  public EmojiLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmojiLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmojiLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void fU()
  {
    this.ajf.setScaleX(1.3F);
    this.ajf.setScaleY(1.3F);
    this.ajf.start();
  }
  
  public final void fV()
  {
    this.ajf.setScaleX(0.8F);
    this.ajf.setScaleY(0.8F);
    MMGIFImageView localMMGIFImageView = this.ajf;
    if ((localMMGIFImageView.getDrawable() != null) && ((localMMGIFImageView.getDrawable() instanceof com.tencent.mm.wear.app.emoji.gif.b))) {
      ((com.tencent.mm.wear.app.emoji.gif.b)localMMGIFImageView.getDrawable()).pause();
    }
  }
  
  public final String nZ()
  {
    return this.ajg;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.ajf = ((MMGIFImageView)findViewById(2131558445));
  }
  
  public final void q(String paramString1, String paramString2)
  {
    d.c("MicroMsg.EmojiLayout", "md5: %s, productId: %s", new Object[] { paramString1, paramString2 });
    this.ajg = paramString1;
    a locala = new a();
    locala.agm = this.ajf;
    locala.agn = 2130837533;
    locala.type = 1;
    locala.agj = paramString2;
    locala.agk = paramString1;
    locala.width = this.ajf.getMeasuredWidth();
    locala.height = this.ajf.getMeasuredHeight();
    h.mR().a(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.EmojiLayout
 * JD-Core Version:    0.7.0.1
 */