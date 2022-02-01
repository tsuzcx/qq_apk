package com.tencent.mm.plugin.websearch.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.view.a.1;
import com.tencent.mm.plugin.websearch.widget.view.a.2;
import com.tencent.mm.plugin.websearch.widget.view.a.3;
import com.tencent.mm.plugin.websearch.widget.view.a.4;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;
import java.util.Map;

public final class b
  implements f
{
  public final int a(Activity paramActivity, String paramString1, String paramString2, List<af> paramList, ae paramae)
  {
    AppMethodBeat.i(116629);
    com.tencent.mm.plugin.websearch.widget.view.a locala = com.tencent.mm.plugin.websearch.widget.view.a.gRO();
    e locale = new e(paramActivity, 2, true);
    int i = locale.hashCode();
    locale.ODW = new a.1(locala, paramList);
    locale.ODT = new a.2(locala, paramList, locale);
    locale.ODU = new a.3(locala, paramae, i);
    locale.XbB = new a.4(locala, paramae, i);
    paramActivity = View.inflate(paramActivity, a.e.search_action_sheet_title, null);
    if (!TextUtils.isEmpty(paramString1))
    {
      ((TextView)paramActivity.findViewById(a.d.title)).setText(paramString1);
      if (TextUtils.isEmpty(paramString2)) {
        break label209;
      }
      ((TextView)paramActivity.findViewById(a.d.sub_title)).setText(paramString2);
    }
    for (;;)
    {
      locale.OEc = true;
      locale.Z(paramActivity, false);
      locale.eik();
      locala.PCO.put(Integer.valueOf(i), locale);
      AppMethodBeat.o(116629);
      return i;
      paramActivity.findViewById(a.d.title).setVisibility(8);
      break;
      label209:
      paramActivity.findViewById(a.d.sub_title).setVisibility(8);
    }
  }
  
  public final d a(Context paramContext, n paramn)
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