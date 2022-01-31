package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a
  implements x.a
{
  public TextView tSA = null;
  public TextView tSB = null;
  public TextView tSC = null;
  public ImageView tSE = null;
  public ImageView tSF = null;
  public TextView tSG = null;
  public TextView tSH = null;
  public TextView tSI = null;
  public ViewGroup uwo = null;
  public g uwp;
  public ViewGroup uwq = null;
  public TextView uwr = null;
  public ImageView uws = null;
  public TextView uwt = null;
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(47875);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.BankcardListAdapter", bool);
      if (this.uwp != null) {
        break;
      }
      AppMethodBeat.o(47875);
      return;
    }
    if (paramString.equals(this.uwp.pek)) {
      this.tSF.post(new b.a.1(this, paramBitmap));
    }
    if ((paramString.equals(this.uwp.ugo)) && (this.tSE != null)) {
      this.tSE.post(new b.a.2(this, paramBitmap));
    }
    AppMethodBeat.o(47875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.b.a
 * JD-Core Version:    0.7.0.1
 */