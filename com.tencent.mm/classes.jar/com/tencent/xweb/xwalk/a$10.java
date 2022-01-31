package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

final class a$10
  implements View.OnClickListener
{
  a$10(a parama, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    if (this.xlk.getVisibility() == 8)
    {
      this.xlk.setVisibility(0);
      ((Button)paramView).setText("隐藏插件设置");
      return;
    }
    this.xlk.setVisibility(8);
    ((Button)paramView).setText("插件设置");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.10
 * JD-Core Version:    0.7.0.1
 */