package com.tencent.mm.plugin.websearch.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.a.b;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.widget.view.a.1;
import com.tencent.mm.plugin.websearch.widget.view.a.2;
import com.tencent.mm.plugin.websearch.widget.view.a.3;
import com.tencent.mm.plugin.websearch.widget.view.a.4;
import com.tencent.mm.plugin.websearch.widget.view.b.2;
import com.tencent.mm.plugin.websearch.widget.view.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;
import java.util.Map;

public final class b
  implements h
{
  public final int a(Activity paramActivity, String paramString1, String paramString2, List<y> paramList, x paramx)
  {
    com.tencent.mm.plugin.websearch.widget.view.a locala = com.tencent.mm.plugin.websearch.widget.view.a.cak();
    d locald = new d(paramActivity, 2, true);
    int i = locald.hashCode();
    locald.wdr = new a.1(locala, paramList);
    locald.phH = new a.2(locala, paramList, locald);
    locald.phI = new a.3(locala, paramx, i);
    locald.wmU = new a.4(locala, paramx, i);
    paramActivity = View.inflate(paramActivity, a.b.search_action_sheet_title, null);
    if (!TextUtils.isEmpty(paramString1))
    {
      ((TextView)paramActivity.findViewById(a.a.title)).setText(paramString1);
      if (TextUtils.isEmpty(paramString2)) {
        break label198;
      }
      ((TextView)paramActivity.findViewById(a.a.sub_title)).setText(paramString2);
    }
    for (;;)
    {
      locald.wnm = true;
      locald.ej(paramActivity);
      locald.cfU();
      locala.qXt.put(Integer.valueOf(i), locald);
      return i;
      paramActivity.findViewById(a.a.title).setVisibility(8);
      break;
      label198:
      paramActivity.findViewById(a.a.sub_title).setVisibility(8);
    }
  }
  
  public final f a(Context paramContext, r paramr)
  {
    return new a(paramContext, paramr);
  }
  
  public final i a(LinearLayout paramLinearLayout, int paramInt, Activity paramActivity, g paramg)
  {
    paramLinearLayout = new com.tencent.mm.plugin.websearch.widget.view.b(paramLinearLayout, paramInt, paramActivity, paramg);
    paramActivity = LinearLayout.inflate(paramLinearLayout.fXV.getContext(), a.b.service_widget_view_wrapper, paramLinearLayout.fXV);
    paramLinearLayout.qXz = paramActivity.findViewById(a.a.search_widget_container_divider);
    paramLinearLayout.oGu = ((ViewPager)paramActivity.findViewById(a.a.pager));
    paramLinearLayout.qXy = new b.b(paramLinearLayout, paramLinearLayout.gfb.getSupportFragmentManager());
    paramLinearLayout.oGu.setAdapter(paramLinearLayout.qXy);
    paramLinearLayout.oGu.setOffscreenPageLimit(0);
    paramLinearLayout.oGu.a(new b.2(paramLinearLayout));
    return paramLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.b
 * JD-Core Version:    0.7.0.1
 */