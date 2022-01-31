package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.protocal.c.azp;

final class SDKOAuthUI$19
  implements AdapterView.OnItemClickListener
{
  SDKOAuthUI$19(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    SDKOAuthUI.b.a(SDKOAuthUI.d(this.rmk), SDKOAuthUI.d(this.rmk).CA(paramInt).id);
    SDKOAuthUI.d(this.rmk).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.19
 * JD-Core Version:    0.7.0.1
 */