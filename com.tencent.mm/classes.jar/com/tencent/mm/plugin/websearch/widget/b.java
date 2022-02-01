package com.tencent.mm.plugin.websearch.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.widget.view.a.1;
import com.tencent.mm.plugin.websearch.widget.view.a.2;
import com.tencent.mm.plugin.websearch.widget.view.a.3;
import com.tencent.mm.plugin.websearch.widget.view.a.4;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.websearch.api.e
{
  public final int a(Activity paramActivity, String paramString1, String paramString2, List<x> paramList, w paramw)
  {
    AppMethodBeat.i(116629);
    com.tencent.mm.plugin.websearch.widget.view.a locala = com.tencent.mm.plugin.websearch.widget.view.a.exY();
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramActivity, 2, true);
    int i = locale.hashCode();
    locale.ISy = new a.1(locala, paramList);
    locale.ISu = new a.2(locala, paramList, locale);
    locale.ISv = new a.3(locala, paramw, i);
    locale.Ihj = new a.4(locala, paramw, i);
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
      locale.JfJ = true;
      locale.J(paramActivity, false);
      locale.cED();
      locala.CbG.put(Integer.valueOf(i), locale);
      AppMethodBeat.o(116629);
      return i;
      paramActivity.findViewById(2131305902).setVisibility(8);
      break;
      label205:
      paramActivity.findViewById(2131305508).setVisibility(8);
    }
  }
  
  public final c a(Context paramContext, m paramm)
  {
    AppMethodBeat.i(116628);
    paramContext = new a(paramContext, paramm);
    AppMethodBeat.o(116628);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.b
 * JD-Core Version:    0.7.0.1
 */