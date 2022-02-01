package com.tencent.mm.plugin.websearch.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.a.f;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.view.a.1;
import com.tencent.mm.plugin.websearch.widget.view.a.2;
import com.tencent.mm.plugin.websearch.widget.view.a.3;
import com.tencent.mm.plugin.websearch.widget.view.a.4;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.websearch.api.f
{
  public final int a(Activity paramActivity, String paramString1, String paramString2, List<ag> paramList, af paramaf)
  {
    AppMethodBeat.i(116629);
    com.tencent.mm.plugin.websearch.widget.view.a locala = com.tencent.mm.plugin.websearch.widget.view.a.irf();
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramActivity, 2, true);
    int i = localf.hashCode();
    localf.Vti = new a.1(locala, paramList);
    localf.Vtg = new a.2(locala, paramList, localf);
    localf.GAC = new a.3(locala, paramaf, i);
    localf.aeLi = new a.4(locala, paramaf, i);
    paramActivity = View.inflate(paramActivity, a.f.search_action_sheet_title, null);
    if (!TextUtils.isEmpty(paramString1))
    {
      ((TextView)paramActivity.findViewById(a.e.title)).setText(paramString1);
      if (TextUtils.isEmpty(paramString2)) {
        break label209;
      }
      ((TextView)paramActivity.findViewById(a.e.sub_title)).setText(paramString2);
    }
    for (;;)
    {
      localf.Vto = true;
      localf.af(paramActivity, false);
      localf.dDn();
      locala.Wtt.put(Integer.valueOf(i), localf);
      AppMethodBeat.o(116629);
      return i;
      paramActivity.findViewById(a.e.title).setVisibility(8);
      break;
      label209:
      paramActivity.findViewById(a.e.sub_title).setVisibility(8);
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