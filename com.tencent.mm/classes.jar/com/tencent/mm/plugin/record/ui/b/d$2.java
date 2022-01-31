package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.i;
import com.tencent.mm.ui.widget.c.a;

final class d$2
  implements View.OnLongClickListener
{
  d$2(d paramd, i parami, boolean paramBoolean, u paramu, int paramInt, b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(153642);
    TextView localTextView = (TextView)paramView;
    Object localObject = new SpannableString(localTextView.getText());
    ((SpannableString)localObject).setSpan(new BackgroundColorSpan(this.qau.context.getResources().getColor(2131690206)), 0, localTextView.getText().length(), 33);
    localTextView.setText((CharSequence)localObject);
    localObject = new a(this.qau.context, localTextView);
    ((a)localObject).AIG = new d.2.1(this);
    ((a)localObject).sap = new d.2.2(this, localTextView);
    ((a)localObject).AxS = new d.2.3(this, localTextView);
    if ((paramView.getTag(2131820681) instanceof int[]))
    {
      paramView = (int[])paramView.getTag(2131820681);
      ((a)localObject).dq(paramView[0], paramView[1]);
    }
    for (;;)
    {
      AppMethodBeat.o(153642);
      return true;
      ((a)localObject).dq(this.qau.jUm, this.qau.jUn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.2
 * JD-Core Version:    0.7.0.1
 */