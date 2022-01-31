package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.ui.widget.b.a;

final class SDKOAuthUI$2
  implements AdapterView.OnItemLongClickListener
{
  SDKOAuthUI$2(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    SDKOAuthUI.d(this.rmk, paramInt);
    int i = SDKOAuthUI.d(this.rmk).CA(paramInt).id;
    if ((i != 0) && (i != 1)) {
      SDKOAuthUI.h(this.rmk).a(paramView, paramInt, paramLong, this.rmk, SDKOAuthUI.e(this.rmk), SDKOAuthUI.f(this.rmk), SDKOAuthUI.g(this.rmk));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.2
 * JD-Core Version:    0.7.0.1
 */