package com.tencent.mm.storage;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"<no name provided>", "Landroid/text/SpannableString;", "prefix", ""}, k=3, mv={1, 5, 1}, xi=48)
final class ai$b
  extends u
  implements b<String, SpannableString>
{
  ai$b(Map<String, String> paramMap)
  {
    super(1);
  }
  
  private SpannableString bvI(String paramString)
  {
    AppMethodBeat.i(248500);
    s.u(paramString, "prefix");
    Object localObject1 = (String)this.acGH.get(s.X(paramString, ".content"));
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = this.acGH.get(s.X(paramString, ".android_color_light"));
      if (aw.isDarkMode()) {
        localObject2 = this.acGH.get(s.X(paramString, ".android_color_dark"));
      }
      int i;
      int j;
      if (Util.getInt((String)this.acGH.get(s.X(paramString, ".bold")), 0) == 1)
      {
        i = 1;
        j = Util.getInt((String)this.acGH.get(s.X(paramString, ".size")), 15);
        paramString = new SpannableString((CharSequence)localObject1);
      }
      try
      {
        if (!Util.isNullOrNil((String)localObject2)) {
          paramString.setSpan(new ForegroundColorSpan(Color.parseColor((String)localObject2)), 0, ((String)localObject1).length(), 33);
        }
        if (i != 0) {
          paramString.setSpan(new StyleSpan(1), 0, ((String)localObject1).length(), 33);
        }
        if (j > 0) {
          paramString.setSpan(new AbsoluteSizeSpan(j, true), 0, ((String)localObject1).length(), 33);
        }
        AppMethodBeat.o(248500);
        return paramString;
        localObject2 = n.bq((CharSequence)localObject1).toString();
        localObject1 = localObject2;
        if (localObject2 != null) {
          continue;
        }
        localObject1 = "";
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "color error");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ai.b
 * JD-Core Version:    0.7.0.1
 */