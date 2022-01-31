package com.tencent.mm.plugin.websearch.widget;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.p;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class a$6
  implements Runnable
{
  a$6(a parama, String paramString, WidgetData paramWidgetData) {}
  
  public final void run()
  {
    AppMethodBeat.i(91397);
    View localView1 = (View)a.i(this.uLR).get(this.uLT);
    View localView2 = (View)a.j(this.uLR).get(this.uLT);
    if (localView1 != null)
    {
      Object localObject = (AbsoluteLayout.LayoutParams)localView1.getLayoutParams();
      int i = ((AbsoluteLayout.LayoutParams)localObject).height;
      int j = p.pQ(this.uLS.uKB.height);
      int k = ((AbsoluteLayout.LayoutParams)localObject).width;
      int m = p.pQ(this.uLS.uKB.width);
      a.a(this.uLR, localView1, (View)a.k(this.uLR).get(this.uLT), i, j, k, m, this.uLT);
      localObject = localView2.getLayoutParams();
      if ((localObject instanceof AbsoluteLayout.LayoutParams))
      {
        localObject = (AbsoluteLayout.LayoutParams)localObject;
        ((AbsoluteLayout.LayoutParams)localObject).x = p.pQ(this.uLS.uKB.offsetX);
        ((AbsoluteLayout.LayoutParams)localObject).y = p.pQ(this.uLS.uKB.offsetY);
        localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      try
      {
        for (;;)
        {
          if (!TextUtils.isEmpty(this.uLS.uKB.hhh)) {
            localView1.setBackgroundColor(Color.parseColor(this.uLS.uKB.hhh));
          }
          if (!this.uLS.uKB.cIy) {
            break;
          }
          localView1.setVisibility(0);
          localView2.setVisibility(0);
          AppMethodBeat.o(91397);
          return;
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            localObject = (ViewGroup.MarginLayoutParams)localObject;
            ((ViewGroup.MarginLayoutParams)localObject).leftMargin = p.pQ(this.uLS.uKB.offsetX);
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = p.pQ(this.uLS.uKB.offsetY);
            localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("FTSSearchWidgetMgr", bo.l(localException));
        }
        localView1.setVisibility(8);
        localView2.setVisibility(8);
      }
    }
    AppMethodBeat.o(91397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.6
 * JD-Core Version:    0.7.0.1
 */