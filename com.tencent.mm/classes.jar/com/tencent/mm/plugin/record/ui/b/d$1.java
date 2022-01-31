package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.ui.widget.b.a;

final class d$1
  implements View.OnLongClickListener
{
  d$1(d paramd, b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    TextView localTextView = (TextView)paramView;
    Object localObject = new SpannableString(localTextView.getText());
    ((SpannableString)localObject).setSpan(new BackgroundColorSpan(this.nuF.context.getResources().getColor(R.e.light_blue_bg_color)), 0, localTextView.getText().length(), 33);
    localTextView.setText((CharSequence)localObject);
    localObject = new a(this.nuF.context, localTextView);
    ((a)localObject).wog = new d.1.1(this);
    ((a)localObject).phI = new d.1.2(this, localTextView);
    ((a)localObject).wfc = new d.1.3(this, localTextView);
    if ((paramView.getTag(R.h.touch_loc) instanceof int[]))
    {
      paramView = (int[])paramView.getTag(R.h.touch_loc);
      ((a)localObject).ch(paramView[0], paramView[1]);
      return true;
    }
    ((a)localObject).ch(this.nuF.idy, this.nuF.idz);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.1
 * JD-Core Version:    0.7.0.1
 */