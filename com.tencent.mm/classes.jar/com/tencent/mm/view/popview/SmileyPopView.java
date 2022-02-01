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
import com.tencent.mm.ce.b;
import com.tencent.mm.ce.e;
import com.tencent.mm.emoji.a.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;

public class SmileyPopView
  extends AbstractPopView
{
  private WindowManager.LayoutParams LRC;
  private View LRL;
  private ImageView LRM;
  private int LRN;
  private TextView uEa;
  
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
    this.LRL = findViewById(2131304874);
    this.LRM = ((ImageView)findViewById(2131299412));
    this.uEa = ((TextView)findViewById(2131299411));
    this.LRC = new WindowManager.LayoutParams(2, 264, 1);
    this.LRN = getResources().getDimensionPixelOffset(2131166824);
    this.LRC.width = paramContext.getResources().getDimensionPixelSize(2131166823);
    this.LRC.height = paramContext.getResources().getDimensionPixelSize(2131166821);
    this.LRC.gravity = 49;
    AppMethodBeat.o(105305);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.LRC;
  }
  
  public final void hq(View paramView)
  {
    AppMethodBeat.i(105307);
    kS(paramView.getContext());
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.LRC.width - this.LRN) / 2;
    this.LRC.y = (arrayOfInt[1] - this.LRC.height + paramView.getMeasuredHeight() - this.LRq);
    if (j < this.LRC.width / 2)
    {
      this.LRL.setBackground(aq.aM(getContext(), 2130968967));
      this.LRC.x = (j + k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    if (this.LRC.width / 2 + j > i)
    {
      this.LRL.setBackground(aq.aM(getContext(), 2130968968));
      this.LRC.x = (j - k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    this.LRL.setBackground(aq.aM(getContext(), 2130968966));
    this.LRC.x = (j - i / 2);
    AppMethodBeat.o(105307);
  }
  
  public void setSmileyItem(o paramo)
  {
    AppMethodBeat.i(105306);
    Object localObject = e.fqT().aTk(paramo.key);
    String str = b.fqL().aTh((String)localObject);
    ae.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { paramo.key, localObject, str });
    int k = str.indexOf("[");
    int j = str.indexOf("]");
    int i = j;
    if (j == -1) {
      i = str.length();
    }
    localObject = str.substring(k + 1, i);
    this.uEa.setText((CharSequence)localObject);
    localObject = this.LRM;
    e.fqT();
    ((ImageView)localObject).setImageDrawable(e.aTj(paramo.key));
    AppMethodBeat.o(105306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */