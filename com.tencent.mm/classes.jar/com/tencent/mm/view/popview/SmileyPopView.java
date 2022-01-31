package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.cd.b;
import com.tencent.mm.cd.e;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.plugin.l.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.u.a.a;

public class SmileyPopView
  extends AbstractPopView
{
  private TextView leV;
  private WindowManager.LayoutParams wzh;
  private View wzj;
  private ImageView wzk;
  private int wzl;
  
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
    inflate(paramContext, a.f.emoji_pop_smiley_view, this);
    this.wzj = findViewById(a.e.smiley_pop_frame);
    this.wzk = ((ImageView)findViewById(a.e.emoji_pop_image));
    this.leV = ((TextView)findViewById(a.e.emoji_pop_desc));
    this.wzh = new WindowManager.LayoutParams(2, 264, 1);
    this.wzl = getResources().getDimensionPixelOffset(a.c.smiley_pop_frame_width_bottom);
    this.wzh.width = paramContext.getResources().getDimensionPixelSize(a.c.smiley_pop_frame_width);
    this.wzh.height = paramContext.getResources().getDimensionPixelSize(a.c.smiley_pop_frame_height);
    this.wzh.gravity = 49;
  }
  
  public final void ep(View paramView)
  {
    paramView.setPressed(false);
    paramView.setSelected(false);
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = arrayOfInt[0] + paramView.getMeasuredWidth() / 2;
    int k = (this.wzh.width - this.wzl) / 2;
    this.wzh.y = (arrayOfInt[1] - this.wzh.height + paramView.getMeasuredHeight());
    if (j < this.wzh.width / 2)
    {
      this.wzj.setBackgroundResource(a.g.emoji_pop_bg_smiley_left);
      this.wzh.x = (j + k - i / 2);
      return;
    }
    if (this.wzh.width / 2 + j > i)
    {
      this.wzj.setBackgroundResource(a.g.emoji_pop_bg_smiley_right);
      this.wzh.x = (j - k - i / 2);
      return;
    }
    this.wzj.setBackgroundResource(a.g.emoji_pop_bg_smiley);
    this.wzh.x = (j - i / 2);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.wzh;
  }
  
  public void setSmileyItem(a parama)
  {
    String str1 = e.csH().getText(parama.position);
    String str2 = b.csC().aat(str1);
    y.i("MicroMsg.SmileyPopView", "pop smiley %s, %s, %s", new Object[] { Integer.valueOf(parama.position), str1, str2 });
    int k = str2.indexOf("[");
    int j = str2.indexOf("]");
    int i = j;
    if (j == -1) {
      i = str2.length();
    }
    str1 = str2.substring(k + 1, i);
    this.leV.setText(str1);
    this.wzk.setImageDrawable(e.csH().mW(parama.position));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.popview.SmileyPopView
 * JD-Core Version:    0.7.0.1
 */