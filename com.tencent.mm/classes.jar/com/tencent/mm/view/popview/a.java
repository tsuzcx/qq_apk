package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public final class a
{
  private o lXp;
  private long tOh = 0L;
  private TextView vfg;
  
  public a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(a.f.emoji_capture_new_pop, null);
    this.vfg = ((TextView)localView.findViewById(a.e.emoji_capture_new_text));
    this.vfg.setText(j.b(paramContext, "[Yeah!] " + paramContext.getString(a.h.emoji_capture_new_tips)));
    this.lXp = new o(localView, -2, -2);
    this.lXp.setOutsideTouchable(false);
    this.lXp.setFocusable(false);
    localView.setOnClickListener(new a.1(this));
  }
  
  public final void dismiss()
  {
    y.i("MicroMsg.EmojiCaptureNewTipPopView", "dismiss %s", new Object[] { Boolean.valueOf(this.lXp.isShowing()) });
    if (this.lXp.isShowing())
    {
      this.lXp.dismiss();
      if ((this.tOh > 0L) && (bk.cp(this.tOh) > 2000L))
      {
        y.i("MicroMsg.EmojiCaptureNewTipPopView", "dismiss over time");
        g.DP().Dz().c(ac.a.wuP, Boolean.valueOf(true));
      }
      this.tOh = 0L;
    }
  }
  
  public final void ew(View paramView)
  {
    int i;
    if (paramView != null)
    {
      boolean bool = g.DP().Dz().getBoolean(ac.a.wuP, false);
      if ((!g.DP().Dz().getBoolean(ac.a.uzA, false)) && (!bool)) {
        break label45;
      }
      i = 1;
      if (i == 0) {
        break label50;
      }
    }
    for (;;)
    {
      return;
      label45:
      i = 0;
      break;
      label50:
      this.tOh = bk.UZ();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      y.i("MicroMsg.EmojiCaptureNewTipPopView", "show tips");
      this.lXp.showAtLocation(paramView, 0, 0, arrayOfInt[1] - com.tencent.mm.cb.a.fromDPToPix(paramView.getContext(), 70));
      while ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup)))
      {
        if ((paramView.getParent() instanceof DrawnCallBackLinearLayout))
        {
          ((DrawnCallBackLinearLayout)paramView.getParent()).setTouchedCallback(new a.2(this));
          return;
        }
        paramView = (ViewGroup)paramView.getParent();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.popview.a
 * JD-Core Version:    0.7.0.1
 */