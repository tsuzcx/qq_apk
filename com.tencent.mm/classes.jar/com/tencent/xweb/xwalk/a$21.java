package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import org.xwalk.core.R.id;

final class a$21
  implements View.OnClickListener
{
  a$21(a parama) {}
  
  public final void onClick(View paramView)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.xlg.xld.findViewById(R.id.config_memu);
    if (localLinearLayout.getVisibility() == 8)
    {
      localLinearLayout.setVisibility(0);
      ((Button)paramView).setText("隐藏高级设置");
      return;
    }
    localLinearLayout.setVisibility(8);
    ((Button)paramView).setText("高级设置");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.21
 * JD-Core Version:    0.7.0.1
 */