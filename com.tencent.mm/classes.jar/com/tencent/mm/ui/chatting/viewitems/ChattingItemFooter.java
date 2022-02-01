package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.am.k;
import com.tencent.mm.am.w;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;

public class ChattingItemFooter
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int[] KeP = { 2131231608, 2131231608, 2131231614, 2131231611 };
  private static final int[] KeQ = { 2131233778, 2131233782, 2131233787, 2131233784 };
  private String lEN;
  private Context mContext;
  private LayoutInflater mInflater;
  
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
    paramk = new w(this.lEN, paramk.getInfo());
    ba.aiU().a(paramk, 0);
    AppMethodBeat.o(37300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(37301);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
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
      ad.d("ChattingItemFooter", "get latest message");
      paramView.state = k.hQi;
      c(paramView);
      continue;
      ad.d("ChattingItemFooter", "start webview url");
      paramView.state = k.hQi;
      c(paramView);
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramView.value);
      ((Intent)localObject).putExtra("showShare", false);
      ((Intent)localObject).putExtra("geta8key_username", this.lEN);
      d.b(this.mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemFooter
 * JD-Core Version:    0.7.0.1
 */