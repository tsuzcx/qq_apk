package com.tencent.mm.pluginsdk.ui.preference;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.b.a;

final class NormalUserHeaderPreference$5
  implements View.OnLongClickListener
{
  NormalUserHeaderPreference$5(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final boolean onLongClick(View paramView)
  {
    if ((NormalUserHeaderPreference.d(this.siZ).getText() != null) && (NormalUserHeaderPreference.e(this.siZ) != null))
    {
      Object localObject = NormalUserHeaderPreference.d(this.siZ).getText().toString();
      int i = ((String)localObject).indexOf(':');
      paramView = (View)localObject;
      if (i >= 0)
      {
        paramView = (View)localObject;
        if (i < ((String)localObject).length()) {
          paramView = ((String)localObject).substring(i + 1).trim();
        }
      }
      localObject = new SpannableString(NormalUserHeaderPreference.d(this.siZ).getText());
      ((SpannableString)localObject).setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.a(this.siZ).getResources().getColor(R.e.light_blue_bg_color)), i + 1, NormalUserHeaderPreference.d(this.siZ).getText().length(), 33);
      NormalUserHeaderPreference.d(this.siZ).setText((CharSequence)localObject);
      localObject = new a(NormalUserHeaderPreference.a(this.siZ), NormalUserHeaderPreference.d(this.siZ));
      ((a)localObject).wog = new NormalUserHeaderPreference.5.1(this);
      ((a)localObject).phI = new NormalUserHeaderPreference.5.2(this, paramView);
      ((a)localObject).wfc = new NormalUserHeaderPreference.5.3(this);
      ((a)localObject).ch(0, 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.5
 * JD-Core Version:    0.7.0.1
 */