package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import java.io.File;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(70277);
    Object localObject = (ImageView)this.qUm.qUl.findViewById(2131824109);
    ((ImageView)localObject).setImageBitmap(this.pZR);
    ((ImageView)localObject).setVisibility(0);
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    k.a(this.qUm.qUl.getContext(), (Intent)localObject, new File(this.hZn), "video/*");
    try
    {
      this.qUm.qUl.getContext().startActivity(Intent.createChooser((Intent)localObject, this.qUm.qUl.getContext().getString(2131297103)));
      AppMethodBeat.o(70277);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
      h.h(this.qUm.qUl.getContext(), 2131301863, 2131301864);
      AppMethodBeat.o(70277);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c.1.1
 * JD-Core Version:    0.7.0.1
 */