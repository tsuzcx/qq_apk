package com.tencent.mm.pluginsdk.ui.preference;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.c.a;

final class NormalUserHeaderPreference$5
  implements View.OnLongClickListener
{
  NormalUserHeaderPreference$5(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(28078);
    if ((NormalUserHeaderPreference.d(this.wbA).getText() != null) && (NormalUserHeaderPreference.e(this.wbA) != null))
    {
      Object localObject = NormalUserHeaderPreference.d(this.wbA).getText().toString();
      int i = ((String)localObject).indexOf(':');
      paramView = (View)localObject;
      if (i >= 0)
      {
        paramView = (View)localObject;
        if (i < ((String)localObject).length()) {
          paramView = ((String)localObject).substring(i + 1).trim();
        }
      }
      localObject = new SpannableString(NormalUserHeaderPreference.d(this.wbA).getText());
      ((SpannableString)localObject).setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.b(this.wbA).getResources().getColor(2131690206)), i + 1, NormalUserHeaderPreference.d(this.wbA).getText().length(), 33);
      NormalUserHeaderPreference.d(this.wbA).setText((CharSequence)localObject);
      localObject = new a(NormalUserHeaderPreference.b(this.wbA), NormalUserHeaderPreference.d(this.wbA));
      ((a)localObject).AIG = new NormalUserHeaderPreference.5.1(this);
      ((a)localObject).sap = new NormalUserHeaderPreference.5.2(this, paramView);
      ((a)localObject).AxS = new NormalUserHeaderPreference.5.3(this);
      ((a)localObject).dq(0, 0);
    }
    AppMethodBeat.o(28078);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.5
 * JD-Core Version:    0.7.0.1
 */