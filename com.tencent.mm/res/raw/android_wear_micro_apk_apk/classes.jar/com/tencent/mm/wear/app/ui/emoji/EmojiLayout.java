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
  public MMGIFImageView afD;
  private String afE;
  
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
  
  public final void fK()
  {
    this.afD.setScaleX(1.3F);
    this.afD.setScaleY(1.3F);
    this.afD.start();
  }
  
  public final void fL()
  {
    this.afD.setScaleX(0.8F);
    this.afD.setScaleY(0.8F);
    MMGIFImageView localMMGIFImageView = this.afD;
    if ((localMMGIFImageView.getDrawable() != null) && ((localMMGIFImageView.getDrawable() instanceof com.tencent.mm.wear.app.emoji.gif.b))) {
      ((com.tencent.mm.wear.app.emoji.gif.b)localMMGIFImageView.getDrawable()).pause();
    }
  }
  
  public final String nm()
  {
    return this.afE;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.afD = ((MMGIFImageView)findViewById(2131558444));
  }
  
  public final void p(String paramString1, String paramString2)
  {
    d.c("MicroMsg.EmojiLayout", "md5: %s, productId: %s", new Object[] { paramString1, paramString2 });
    this.afE = paramString1;
    a locala = new a();
    locala.acL = this.afD;
    locala.acM = 2130837533;
    locala.type = 1;
    locala.acI = paramString2;
    locala.acJ = paramString1;
    locala.width = this.afD.getMeasuredWidth();
    locala.height = this.afD.getMeasuredHeight();
    h.me().a(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.EmojiLayout
 * JD-Core Version:    0.7.0.1
 */