package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.lang.ref.WeakReference;

final class n$5
  implements View.OnClickListener
{
  n$5(n paramn, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38840);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    try
    {
      NetStatusUtil.startSettingItent((Context)n.w(this.aftV).get(), this.val$type);
      a.a(this, "com/tencent/mm/ui/conversation/banner/NetWarnBanner$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(38840);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetWarnView", paramView, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.n.5
 * JD-Core Version:    0.7.0.1
 */