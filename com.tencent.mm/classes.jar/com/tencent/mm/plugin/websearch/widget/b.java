package com.tencent.mm.plugin.websearch.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.widget.view.a.1;
import com.tencent.mm.plugin.websearch.widget.view.a.2;
import com.tencent.mm.plugin.websearch.widget.view.a.3;
import com.tencent.mm.plugin.websearch.widget.view.a.4;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.websearch.api.e
{
  public final int a(Activity paramActivity, String paramString1, String paramString2, List<y> paramList, x paramx)
  {
    AppMethodBeat.i(116629);
    com.tencent.mm.plugin.websearch.widget.view.a locala = com.tencent.mm.plugin.websearch.widget.view.a.eiE();
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramActivity, 2, true);
    int i = locale.hashCode();
    locale.Hsb = new a.1(locala, paramList);
    locale.HrX = new a.2(locala, paramList, locale);
    locale.HrY = new a.3(locala, paramx, i);
    locale.GHn = new a.4(locala, paramx, i);
    paramActivity = View.inflate(paramActivity, 2131495319, null);
    if (!TextUtils.isEmpty(paramString1))
    {
      ((TextView)paramActivity.findViewById(2131305902)).setText(paramString1);
      if (TextUtils.isEmpty(paramString2)) {
        break label205;
      }
      ((TextView)paramActivity.findViewById(2131305508)).setText(paramString2);
    }
    for (;;)
    {
      locale.HFm = true;
      locale.J(paramActivity, false);
      locale.csG();
      locala.AJp.put(Integer.valueOf(i), locale);
      AppMethodBeat.o(116629);
      return i;
      paramActivity.findViewById(2131305902).setVisibility(8);
      break;
      label205:
      paramActivity.findViewById(2131305508).setVisibility(8);
    }
  }
  
  public final c a(Context paramContext, n paramn)
  {
    AppMethodBeat.i(116628);
    paramContext = new a(paramContext, paramn);
    AppMethodBeat.o(116628);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.b
 * JD-Core Version:    0.7.0.1
 */