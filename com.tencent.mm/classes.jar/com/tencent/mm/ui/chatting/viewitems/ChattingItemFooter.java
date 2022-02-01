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
import com.tencent.mm.am.j;
import com.tencent.mm.am.v;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;

public class ChattingItemFooter
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int[] GOn = { 2131231608, 2131231608, 2131231614, 2131231611 };
  private static final int[] GOo = { 2131233778, 2131233782, 2131233787, 2131233784 };
  private String kGt;
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
  
  private void c(j paramj)
  {
    AppMethodBeat.i(37300);
    paramj = new v(this.kGt, paramj.getInfo());
    az.aeS().a(paramj, 0);
    AppMethodBeat.o(37300);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(37301);
    paramView = paramView.getTag();
    if (!(paramView instanceof j))
    {
      AppMethodBeat.o(37301);
      return;
    }
    paramView = (j)paramView;
    switch (paramView.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37301);
      return;
      ad.d("ChattingItemFooter", "get latest message");
      paramView.state = j.gXo;
      c(paramView);
      AppMethodBeat.o(37301);
      return;
      ad.d("ChattingItemFooter", "start webview url");
      paramView.state = j.gXo;
      c(paramView);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView.value);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("geta8key_username", this.kGt);
      d.b(this.mContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemFooter
 * JD-Core Version:    0.7.0.1
 */