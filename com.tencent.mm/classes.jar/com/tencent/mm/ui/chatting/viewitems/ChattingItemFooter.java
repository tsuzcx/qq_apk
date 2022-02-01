package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.k;
import com.tencent.mm.al.w;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;

public class ChattingItemFooter
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int[] PNQ = { 2131231673, 2131231673, 2131231679, 2131231676 };
  private static final int[] PNR = { 2131234599, 2131234603, 2131234608, 2131234605 };
  private Context mContext;
  private LayoutInflater mInflater;
  private String mRa;
  
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
    paramk = new w(this.mRa, paramk.getInfo());
    bg.azz().a(paramk, 0);
    AppMethodBeat.o(37300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(37301);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
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
      paramView.state = k.iOp;
      c(paramView);
      continue;
      Log.d("ChattingItemFooter", "start webview url");
      paramView.state = k.iOp;
      c(paramView);
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramView.value);
      ((Intent)localObject).putExtra("showShare", false);
      ((Intent)localObject).putExtra("geta8key_username", this.mRa);
      ((Intent)localObject).putExtra("key_enable_teen_mode_check", true);
      c.b(this.mContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemFooter
 * JD-Core Version:    0.7.0.1
 */