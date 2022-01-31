package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.ui.widget.c.a;

final class SDKOAuthUI$14
  implements AdapterView.OnItemLongClickListener
{
  SDKOAuthUI$14(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(7537);
    SDKOAuthUI.d(this.vbR, paramInt);
    int i = SDKOAuthUI.h(this.vbR).Kt(paramInt).id;
    if ((i != 0) && (i != 1)) {
      SDKOAuthUI.l(this.vbR).a(paramView, paramInt, paramLong, this.vbR, SDKOAuthUI.i(this.vbR), SDKOAuthUI.j(this.vbR), SDKOAuthUI.k(this.vbR));
    }
    AppMethodBeat.o(7537);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.14
 * JD-Core Version:    0.7.0.1
 */