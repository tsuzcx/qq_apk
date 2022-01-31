package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.y;

final class b$a
  implements x.a
{
  public ViewGroup qHD = null;
  public e qHE;
  public ViewGroup qHF = null;
  public TextView qHG = null;
  public ImageView qHH = null;
  public TextView qHI = null;
  public TextView qjA = null;
  public TextView qjB = null;
  public TextView qjC = null;
  public ImageView qjE = null;
  public ImageView qjF = null;
  public TextView qjG = null;
  public TextView qjH = null;
  public TextView qjI = null;
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
    boolean bool;
    if (paramBitmap == null)
    {
      bool = true;
      y.d("MicroMsg.BankcardListAdapter", bool);
      if (this.qHE != null) {
        break label51;
      }
    }
    label51:
    do
    {
      return;
      bool = false;
      break;
      if (paramString.equals(this.qHE.mEi)) {
        this.qjF.post(new b.a.1(this, paramBitmap));
      }
    } while ((!paramString.equals(this.qHE.qtT)) || (this.qjE == null));
    this.qjE.post(new b.a.2(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.b.a
 * JD-Core Version:    0.7.0.1
 */