package com.tencent.mm.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.api.p;
import com.tencent.mm.api.s;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

final class MMNewPhotoEditUI$5
  implements n
{
  MMNewPhotoEditUI$5(MMNewPhotoEditUI paramMMNewPhotoEditUI, int paramInt) {}
  
  public final void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(11926);
    ab.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    String str;
    try
    {
      str = b.TY("jpg");
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
      ab.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", new Object[] { str });
      MMNewPhotoEditUI.f(this.zcs).recordImage(MMNewPhotoEditUI.c(this.zcs), str, MMNewPhotoEditUI.d(this.zcs), MMNewPhotoEditUI.e(this.zcs).zZ().Au(), MMNewPhotoEditUI.e(this.zcs).zZ().Av());
      if ((MMNewPhotoEditUI.g(this.zcs)) || (this.val$index == 2)) {
        b.a(str, this.zcs);
      }
      if ((this.val$index != 0) && (!paramBitmap.isRecycled()))
      {
        ab.i("MicroMsg.MMNewPhotoEditUI", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
      }
      MMNewPhotoEditUI.a(this.zcs, str);
      if ((MMNewPhotoEditUI.h(this.zcs) != 291) && (MMNewPhotoEditUI.h(this.zcs) != 293)) {
        break label401;
      }
      if (this.val$index == 0)
      {
        MMNewPhotoEditUI.b(this.zcs, str);
        MMNewPhotoEditUI.b(this.zcs);
        MMNewPhotoEditUI.b(this.zcs, 1);
        AppMethodBeat.o(11926);
        return;
      }
      if (this.val$index == 1)
      {
        MMNewPhotoEditUI.c(this.zcs, str);
        MMNewPhotoEditUI.b(this.zcs, 2);
        Toast.makeText(ah.getContext(), this.zcs.getString(2131306165), 1).show();
        MMNewPhotoEditUI.b(this.zcs);
        this.zcs.finish();
        AppMethodBeat.o(11926);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      onError(paramBitmap);
      AppMethodBeat.o(11926);
      return;
    }
    if (this.val$index == 2)
    {
      Toast.makeText(ah.getContext(), this.zcs.getString(2131306161, new Object[] { e.esr }), 1).show();
      MMNewPhotoEditUI.b(this.zcs, 3);
      MMNewPhotoEditUI.b(this.zcs);
      this.zcs.finish();
      AppMethodBeat.o(11926);
      return;
      label401:
      MMNewPhotoEditUI.d(this.zcs, str);
    }
    AppMethodBeat.o(11926);
  }
  
  public final void onError(Exception paramException)
  {
    AppMethodBeat.i(11925);
    MMNewPhotoEditUI.b(this.zcs);
    ab.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", new Object[] { paramException });
    Toast.makeText(ah.getContext(), this.zcs.getResources().getString(2131306158), 1).show();
    this.zcs.setResult(0);
    this.zcs.finish();
    AppMethodBeat.o(11925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI.5
 * JD-Core Version:    0.7.0.1
 */