package com.tencent.mm.storage;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "Landroid/text/SpannableString;", "prefix", "", "invoke"})
final class ag$c
  extends q
  implements b<String, SpannableString>
{
  ag$c(Map paramMap)
  {
    super(1);
  }
  
  private SpannableString bjd(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(212661);
    p.h(paramString, "prefix");
    Object localObject1 = (String)this.NRx.get(paramString + ".content");
    if (localObject1 != null)
    {
      if (localObject1 == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(212661);
        throw paramString;
      }
      localObject2 = n.trim((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = (String)this.NRx.get(paramString + ".android_color_light");
    if (ao.isDarkMode()) {
      localObject2 = (String)this.NRx.get(paramString + ".android_color_dark");
    }
    for (;;)
    {
      int i;
      int j;
      SpannableString localSpannableString;
      if (Util.getInt((String)this.NRx.get(paramString + ".bold"), 0) == 1)
      {
        i = 1;
        j = Util.getInt((String)this.NRx.get(paramString + ".size"), 15);
        localSpannableString = new SpannableString((CharSequence)localObject1);
      }
      for (;;)
      {
        try
        {
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject2 = new ForegroundColorSpan(Color.parseColor((String)localObject2));
            if (localObject1 == null) {
              continue;
            }
            paramString = Integer.valueOf(((String)localObject1).length());
            localSpannableString.setSpan(localObject2, 0, paramString.intValue(), 33);
          }
        }
        catch (Exception paramString)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "color error");
          continue;
          paramString = null;
          continue;
        }
        if (i != 0)
        {
          localObject2 = new StyleSpan(1);
          if (localObject1 == null) {
            continue;
          }
          paramString = Integer.valueOf(((String)localObject1).length());
          localSpannableString.setSpan(localObject2, 0, paramString.intValue(), 33);
        }
        if (j > 0)
        {
          localObject2 = new AbsoluteSizeSpan(j, true);
          paramString = localObject3;
          if (localObject1 != null) {
            paramString = Integer.valueOf(((String)localObject1).length());
          }
          localSpannableString.setSpan(localObject2, 0, paramString.intValue(), 33);
        }
        AppMethodBeat.o(212661);
        return localSpannableString;
        i = 0;
        break;
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.ag.c
 * JD-Core Version:    0.7.0.1
 */