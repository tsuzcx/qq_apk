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
import com.tencent.mm.cf.b;
import com.tencent.mm.cf.e;
import com.tencent.mm.emoji.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;

public class SmileyPopView
  extends AbstractPopView
{
  private WindowManager.LayoutParams LuP;
  private View LuY;
  private ImageView LuZ;
  private int Lva;
  private TextView usH;
  
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
    AppMethodBeat.i(105305);
    inflate(paramContext, 2131493789, this);
    this.LuY = findViewById(2131304874);
    this.LuZ = ((ImageView)findViewById(2131299412));
    this.usH = ((TextView)findViewById(2131299411));
    this.LuP = new WindowManager.LayoutParams(2, 264, 1);
    this.Lva = getResources().getDimensionPixelOffset(2131166824);
    this.LuP.width = paramContext.getResources().getDimensionPixelSize(2131166823);
    this.LuP.height = paramContext.getResources().getDimensionPixelSize(2131166821);
    this.LuP.gravity = 49;
    AppMethodBeat.o(105305);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.LuP;
  }
  
  public final void hl(View paramView)
  {
    AppMethodBeat.i(105307);
    kL(paramView.getContext());
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.LuP.width - this.Lva) / 2;
    this.LuP.y = (arrayOfInt[1] - this.LuP.height + paramView.getMeasuredHeight() - this.LuD);
    if (j < this.LuP.width / 2)
    {
      this.LuY.setBackground(aq.aM(getContext(), 2130968967));
      this.LuP.x = (j + k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    if (this.LuP.width / 2 + j > i)
    {
      this.LuY.setBackground(aq.aM(getContext(), 2130968968));
      this.LuP.x = (j - k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    this.LuY.setBackground(aq.aM(getContext(), 2130968966));
    this.LuP.x = (j - i / 2);
    AppMethodBeat.o(105307);
  }
  
  public void setSmileyItem(o paramo)
  {
    AppMethodBeat.i(105306);
    Object localObject = e.fmZ().aRN(paramo.key);
    String str = b.fmR().aRK((String)localObject);
    ad.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { paramo.key, localObject, str });
    int k = str.indexOf("[");
    int j = str.indexOf("]");
    int i = j;
    if (j == -1) {
      i = str.length();
    }
    localObject = str.substring(k + 1, i);
    this.usH.setText((CharSequence)localObject);
    localObject = this.LuZ;
    e.fmZ();
    ((ImageView)localObject).setImageDrawable(e.aRM(paramo.key));
    AppMethodBeat.o(105306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */