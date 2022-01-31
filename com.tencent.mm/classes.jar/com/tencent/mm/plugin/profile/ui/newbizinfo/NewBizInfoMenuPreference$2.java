package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.R.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a;
import java.util.Iterator;
import java.util.List;

final class NewBizInfoMenuPreference$2
  implements n.c
{
  NewBizInfoMenuPreference$2(NewBizInfoMenuPreference paramNewBizInfoMenuPreference, e parame) {}
  
  public final void a(l paraml)
  {
    Iterator localIterator = this.mZO.nap.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.type == 5)
      {
        Object localObject = NewBizInfoMenuPreference.b(this.mZP).getResources().getDrawable(R.g.biz_menu_show_miniprogram_icon);
        int i = NewBizInfoMenuPreference.d(this.mZP) * 16 / 17;
        ((Drawable)localObject).setBounds(0, 0, i, i);
        localObject = new a((Drawable)localObject);
        SpannableString localSpannableString = new SpannableString("@");
        localSpannableString.setSpan(localObject, 0, 1, 33);
        paraml.e(locale.name.hashCode(), TextUtils.concat(new CharSequence[] { locale.name, "  ", localSpannableString }));
      }
      else
      {
        paraml.e(locale.name.hashCode(), locale.name);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference.2
 * JD-Core Version:    0.7.0.1
 */