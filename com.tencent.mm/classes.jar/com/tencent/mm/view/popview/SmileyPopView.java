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
import com.tencent.mm.cg.b;
import com.tencent.mm.cg.e;
import com.tencent.mm.emoji.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;

public class SmileyPopView
  extends AbstractPopView
{
  private WindowManager.LayoutParams IaS;
  private View Ibb;
  private ImageView Ibc;
  private int Ibd;
  private TextView smp;
  
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
    this.Ibb = findViewById(2131304874);
    this.Ibc = ((ImageView)findViewById(2131299412));
    this.smp = ((TextView)findViewById(2131299411));
    this.IaS = new WindowManager.LayoutParams(2, 264, 1);
    this.Ibd = getResources().getDimensionPixelOffset(2131166824);
    this.IaS.width = paramContext.getResources().getDimensionPixelSize(2131166823);
    this.IaS.height = paramContext.getResources().getDimensionPixelSize(2131166821);
    this.IaS.gravity = 49;
    AppMethodBeat.o(105305);
  }
  
  public final void gD(View paramView)
  {
    AppMethodBeat.i(105307);
    kn(paramView.getContext());
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.IaS.width - this.Ibd) / 2;
    this.IaS.y = (arrayOfInt[1] - this.IaS.height + paramView.getMeasuredHeight() - this.IaG);
    if (j < this.IaS.width / 2)
    {
      this.Ibb.setBackground(ao.aC(getContext(), 2130968967));
      this.IaS.x = (j + k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    if (this.IaS.width / 2 + j > i)
    {
      this.Ibb.setBackground(ao.aC(getContext(), 2130968968));
      this.IaS.x = (j - k - i / 2);
      AppMethodBeat.o(105307);
      return;
    }
    this.Ibb.setBackground(ao.aC(getContext(), 2130968966));
    this.IaS.x = (j - i / 2);
    AppMethodBeat.o(105307);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.IaS;
  }
  
  public void setSmileyItem(n paramn)
  {
    AppMethodBeat.i(105306);
    Object localObject = e.eHT().aGO(paramn.key);
    String str = b.eHL().aGL((String)localObject);
    ad.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { paramn.key, localObject, str });
    int k = str.indexOf("[");
    int j = str.indexOf("]");
    int i = j;
    if (j == -1) {
      i = str.length();
    }
    localObject = str.substring(k + 1, i);
    this.smp.setText((CharSequence)localObject);
    localObject = this.Ibc;
    e.eHT();
    ((ImageView)localObject).setImageDrawable(e.aGN(paramn.key));
    AppMethodBeat.o(105306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */