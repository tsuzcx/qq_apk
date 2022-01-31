package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgs;

final class SDKOAuthUI$12
  implements AdapterView.OnItemClickListener
{
  SDKOAuthUI$12(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(7535);
    SDKOAuthUI.b.a(SDKOAuthUI.h(this.vbR), SDKOAuthUI.h(this.vbR).Kt(paramInt).id);
    SDKOAuthUI.h(this.vbR).notifyDataSetChanged();
    AppMethodBeat.o(7535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.12
 * JD-Core Version:    0.7.0.1
 */