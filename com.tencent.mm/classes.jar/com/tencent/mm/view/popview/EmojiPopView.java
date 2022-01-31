package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class EmojiPopView
  extends AbstractPopView
{
  private EmojiStatusView AUA;
  private WindowManager.LayoutParams AUB;
  private String AUC;
  private ProgressBar nbP;
  private int offsetY;
  
  public EmojiPopView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmojiPopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63064);
    inflate(paramContext, 2130969377, this);
    this.AUA = ((EmojiStatusView)findViewById(2131820629));
    this.nbP = ((ProgressBar)findViewById(2131821404));
    setBackground(null);
    this.AUB = new WindowManager.LayoutParams(2, 264, 1);
    paramInt = paramContext.getResources().getDimensionPixelSize(2131428392);
    this.AUB.width = paramInt;
    this.AUB.height = paramInt;
    this.AUB.gravity = 8388659;
    this.offsetY = paramContext.getResources().getDimensionPixelSize(2131428390);
    AppMethodBeat.o(63064);
  }
  
  public final void fD(View paramView)
  {
    AppMethodBeat.i(63066);
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    this.AUB.x = (arrayOfInt[0] - (this.AUB.width - paramView.getMeasuredWidth()) / 2);
    this.AUB.y = (arrayOfInt[1] - this.AUB.height + this.offsetY);
    AppMethodBeat.o(63066);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.AUB;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(63067);
    super.onDetachedFromWindow();
    AppMethodBeat.o(63067);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63065);
    if (paramEmojiInfo == null)
    {
      this.AUA.setVisibility(4);
      this.nbP.setVisibility(0);
      ab.i("MicroMsg.EmojiPopView", "emoji is null. set null");
      AppMethodBeat.o(63065);
      return;
    }
    if (!paramEmojiInfo.Al().equals(this.AUC))
    {
      this.AUC = paramEmojiInfo.Al();
      this.AUA.setStatusListener(new EmojiPopView.1(this));
      this.AUA.setEmojiInfo(paramEmojiInfo);
    }
    AppMethodBeat.o(63065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */