package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.cd.e;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.sdk.platformtools.ab;

public class SmileyPopView
  extends AbstractPopView
{
  private WindowManager.LayoutParams AUB;
  private View AUE;
  private ImageView AUF;
  private int AUG;
  private TextView nCQ;
  
  public SmileyPopView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SmileyPopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmileyPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63070);
    inflate(paramContext, 2130969378, this);
    this.AUE = findViewById(2131823616);
    this.AUF = ((ImageView)findViewById(2131823617));
    this.nCQ = ((TextView)findViewById(2131823618));
    this.AUB = new WindowManager.LayoutParams(2, 264, 1);
    this.AUG = getResources().getDimensionPixelOffset(2131428697);
    this.AUB.width = paramContext.getResources().getDimensionPixelSize(2131428696);
    this.AUB.height = paramContext.getResources().getDimensionPixelSize(2131428694);
    this.AUB.gravity = 49;
    AppMethodBeat.o(63070);
  }
  
  public final void fD(View paramView)
  {
    AppMethodBeat.i(63072);
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.AUB.width - this.AUG) / 2;
    this.AUB.y = (arrayOfInt[1] - this.AUB.height + paramView.getMeasuredHeight());
    if (j < this.AUB.width / 2)
    {
      this.AUE.setBackgroundResource(2131231266);
      this.AUB.x = (j + k - i / 2);
      AppMethodBeat.o(63072);
      return;
    }
    if (this.AUB.width / 2 + j > i)
    {
      this.AUE.setBackgroundResource(2131231267);
      this.AUB.x = (j - k - i / 2);
      AppMethodBeat.o(63072);
      return;
    }
    this.AUE.setBackgroundResource(2131231265);
    this.AUB.x = (j - i / 2);
    AppMethodBeat.o(63072);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.AUB;
  }
  
  public void setSmileyItem(i parami)
  {
    AppMethodBeat.i(63071);
    String str1 = e.dve().getText(parami.position);
    String str2 = b.duW().aqC(str1);
    ab.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { Integer.valueOf(parami.position), str1, str2 });
    int k = str2.indexOf("[");
    int j = str2.indexOf("]");
    int i = j;
    if (j == -1) {
      i = str2.length();
    }
    str1 = str2.substring(k + 1, i);
    this.nCQ.setText(str1);
    this.AUF.setImageDrawable(e.dve().qA(parami.position));
    AppMethodBeat.o(63071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */