package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.k;
import com.tencent.mm.ao.w;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;

public class ChattingItemFooter
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int[] XjS = { R.g.dmO, R.g.dmO, R.g.dmQ, R.g.dmP };
  private static final int[] XjT = { R.g.dox, R.g.doy, R.g.doA, R.g.doz };
  private Context mContext;
  private LayoutInflater mInflater;
  private String pRV;
  
  public ChattingItemFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37299);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    AppMethodBeat.o(37299);
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(37300);
    paramk = new w(this.pRV, paramk.getInfo());
    bh.aGY().a(paramk, 0);
    AppMethodBeat.o(37300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(37301);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = paramView.getTag();
    if (!(paramView instanceof k))
    {
      a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37301);
      return;
    }
    paramView = (k)paramView;
    switch (paramView.type)
    {
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37301);
      return;
      Log.d("ChattingItemFooter", "get latest message");
      paramView.state = k.lEF;
      c(paramView);
      continue;
      Log.d("ChattingItemFooter", "start webview url");
      paramView.state = k.lEF;
      c(paramView);
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramView.value);
      ((Intent)localObject).putExtra("showShare", false);
      ((Intent)localObject).putExtra("geta8key_username", this.pRV);
      ((Intent)localObject).putExtra("key_enable_teen_mode_check", true);
      c.b(this.mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemFooter
 * JD-Core Version:    0.7.0.1
 */