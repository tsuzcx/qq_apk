package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

final class SnsSightPlayerUI$9$1
  implements Runnable
{
  SnsSightPlayerUI$9$1(SnsSightPlayerUI.9 param9, Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(39258);
    Object localObject = (ImageView)this.rVX.rVT.findViewById(2131824109);
    if (localObject != null)
    {
      ((ImageView)localObject).setImageBitmap(this.pZR);
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    k.a(this.rVX.rVT.getContext(), (Intent)localObject, e.avH(this.hZn), "video/*");
    try
    {
      this.rVX.rVT.getContext().startActivity(Intent.createChooser((Intent)localObject, this.rVX.rVT.getContext().getString(2131299853)));
      AppMethodBeat.o(39258);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
      h.h(this.rVX.rVT.getContext(), 2131299759, 2131299760);
      AppMethodBeat.o(39258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9.1
 * JD-Core Version:    0.7.0.1
 */