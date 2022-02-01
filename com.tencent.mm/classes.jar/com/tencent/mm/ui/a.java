package com.tencent.mm.ui;

import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static void a(ActionBar paramActionBar, boolean paramBoolean, y paramy, Menu paramMenu)
  {
    AppMethodBeat.i(249363);
    View localView1 = paramActionBar.getCustomView();
    if (localView1 == null)
    {
      AppMethodBeat.o(249363);
      return;
    }
    View localView2 = localView1.findViewById(a.g.actionbar_center_layout);
    if (localView2 == null)
    {
      Log.d("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, centerLayout is null");
      AppMethodBeat.o(249363);
      return;
    }
    Log.i("MicroMsg.ActionBarCenterHelper", "setActionTitleCenter, customView measuredWidth outside is %s, isActionbarCenterLayoutMode is %s, customView: %s， context: %s.", new Object[] { Integer.valueOf(localView1.getMeasuredWidth()), Boolean.valueOf(paramBoolean), localView1, localView1.getContext() });
    localView1.post(new a.1(localView1, paramActionBar, paramy, paramMenu, localView2, paramBoolean));
    AppMethodBeat.o(249363);
  }
  
  public static boolean jhB()
  {
    AppMethodBeat.i(249365);
    int i = ((c)h.ax(c.class)).a(c.a.zkV, 1);
    Log.d("MicroMsg.ActionBarCenterHelper", "isSupportHotWordPrioritySwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(249365);
      return true;
    }
    AppMethodBeat.o(249365);
    return false;
  }
  
  public static void v(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(249369);
    if (!jhB())
    {
      AppMethodBeat.o(249369);
      return;
    }
    if (paramTextView == null)
    {
      AppMethodBeat.o(249369);
      return;
    }
    paramTextView.setTextSize(0, com.tencent.mm.cd.a.bs(paramTextView.getContext(), paramInt));
    AppMethodBeat.o(249369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a
 * JD-Core Version:    0.7.0.1
 */