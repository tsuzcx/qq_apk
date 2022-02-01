package com.tencent.mm.storage;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "Landroid/text/SpannableString;", "prefix", "", "invoke"})
public final class ab$a
  extends q
  implements b<String, SpannableString>
{
  public ab$a(Map paramMap)
  {
    super(1);
  }
  
  private SpannableString aUe(String paramString)
  {
    AppMethodBeat.i(188852);
    p.h(paramString, "prefix");
    String str = (String)this.IJC.get(paramString + ".content");
    Object localObject = (String)this.IJC.get(paramString + ".android_color_light");
    if (al.isDarkMode()) {
      localObject = (String)this.IJC.get(paramString + ".android_color_dark");
    }
    int i;
    for (;;)
    {
      int k;
      if (bu.getInt((String)this.IJC.get(paramString + ".bold"), 0) == 1)
      {
        i = 1;
        k = bu.getInt((String)this.IJC.get(paramString + ".size"), 15);
        paramString = new SpannableString((CharSequence)str);
      }
      for (;;)
      {
        try
        {
          if (!bu.isNullOrNil((String)localObject))
          {
            localObject = new ForegroundColorSpan(Color.parseColor((String)localObject));
            if (str == null) {
              continue;
            }
            j = str.length();
            paramString.setSpan(localObject, 0, j, 33);
          }
        }
        catch (Exception localException)
        {
          int j;
          ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "color error");
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
        }
        if (i != 0)
        {
          localObject = new StyleSpan(1);
          if (str == null) {
            continue;
          }
          i = str.length();
          paramString.setSpan(localObject, 0, i, 33);
        }
        if (k > 0)
        {
          localObject = new AbsoluteSizeSpan(k, true);
          if (str == null) {
            continue;
          }
          i = str.length();
          paramString.setSpan(localObject, 0, i, 33);
        }
        AppMethodBeat.o(188852);
        return paramString;
        i = 0;
        break;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ab.a
 * JD-Core Version:    0.7.0.1
 */