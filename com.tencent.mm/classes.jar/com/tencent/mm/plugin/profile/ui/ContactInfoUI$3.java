package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class ContactInfoUI$3
  implements View.OnLayoutChangeListener
{
  ContactInfoUI$3(ContactInfoUI paramContactInfoUI) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(305574);
    paramInt1 = paramInt4 - paramInt2;
    Log.d("MicroMsg.ContactInfoUI", "onLayoutChange: oldHeight:%s, newHeight:%s", new Object[] { Integer.valueOf(paramInt8 - paramInt6), Integer.valueOf(paramInt1) });
    ContactInfoUI.a(this.MVT, paramInt1);
    AppMethodBeat.o(305574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.3
 * JD-Core Version:    0.7.0.1
 */