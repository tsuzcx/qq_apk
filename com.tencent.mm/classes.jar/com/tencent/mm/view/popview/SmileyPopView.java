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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;

public class SmileyPopView
  extends AbstractPopView
{
  private WindowManager.LayoutParams JBI;
  private View JBR;
  private ImageView JBS;
  private int JBT;
  private TextView tui;
  
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
    this.JBR = findViewById(2131304874);
    this.JBS = ((ImageView)findViewById(2131299412));
    this.tui = ((TextView)findViewById(2131299411));
    this.JBI = new WindowManager.LayoutParams(2, 264, 1);
    this.JBT = getResources().getDimensionPixelOffset(2131166824);
    this.JBI.width = paramContext.getResources().getDimensionPixelSize(2131166823);
    this.JBI.height = paramContext.getResources().getDimensionPixelSize(2131166821);
    this.JBI.gravity = 49;
    AppMethodBeat.o(105305);
  }
  
  public final void gU(View paramView)
  {
    AppMethodBeat.i(105307);
    kz(paramView.getContext());
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.JBI.width - this.JBT) / 2;
    this.JBI.y = (arrayOfInt[1] - this.JBI.height + paramView.getMeasuredHeight() - this.JBw);
    if (j < this.JBI.width / 2)
    {
      this.JBR.setBackground(ao.aI(getContext(), 2130968967));
      this.JBI.x = (j + k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    if (this.JBI.width / 2 + j > i)
    {
      this.JBR.setBackground(ao.aI(getContext(), 2130968968));
      this.JBI.x = (j - k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    this.JBR.setBackground(ao.aI(getContext(), 2130968966));
    this.JBI.x = (j - i / 2);
    AppMethodBeat.o(105307);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.JBI;
  }
  
  public void setSmileyItem(o paramo)
  {
    AppMethodBeat.i(105306);
    Object localObject = e.eXp().aMg(paramo.key);
    String str = b.eXh().aMd((String)localObject);
    ac.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { paramo.key, localObject, str });
    int k = str.indexOf("[");
    int j = str.indexOf("]");
    int i = j;
    if (j == -1) {
      i = str.length();
    }
    localObject = str.substring(k + 1, i);
    this.tui.setText((CharSequence)localObject);
    localObject = this.JBS;
    e.eXp();
    ((ImageView)localObject).setImageDrawable(e.aMf(paramo.key));
    AppMethodBeat.o(105306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */