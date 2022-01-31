package com.tencent.mm.plugin.wallet_core.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class a$b
  implements x.a
{
  Bankcard tOQ;
  String uta;
  WeakReference<ImageView> uyd;
  WeakReference<View> uye = null;
  WeakReference<ImageView> uyf = null;
  WeakReference<TextView> uyg = null;
  boolean uyh = false;
  
  public final void m(String paramString, final Bitmap paramBitmap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47997);
    Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
    if (paramBitmap == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.d("MicroMsg.BankcardLogoHelper", bool1);
      if (!TextUtils.isEmpty(this.uta)) {
        break;
      }
      ab.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
      AppMethodBeat.o(47997);
      return;
    }
    if (this.uyd != null)
    {
      final ImageView localImageView = (ImageView)this.uyd.get();
      if (paramBitmap == null)
      {
        bool1 = true;
        if (localImageView != null) {
          break label290;
        }
        label106:
        if (localImageView != null) {
          break label296;
        }
      }
      label290:
      label296:
      for (localObject = "";; localObject = localImageView.getTag())
      {
        ab.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.uta, Boolean.valueOf(this.uyh) });
        if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.uta))) {
          break label331;
        }
        if (!this.uyh) {
          break label306;
        }
        if ((localImageView.getTag(2131820690) == null) || (this.tOQ == null) || (this.tOQ.field_bankcardType == null)) {
          break label331;
        }
        paramString = (String)localImageView.getTag(2131820690);
        if ((!bo.isNullOrNil(paramString)) && (paramString.equals(this.tOQ.field_bankcardType)))
        {
          localImageView.post(new a.b.1(this, localImageView, paramBitmap));
          localImageView.setTag(2131820690, null);
        }
        AppMethodBeat.o(47997);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label106;
      }
      label306:
      localImageView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47996);
          localImageView.setImageBitmap(paramBitmap);
          AppMethodBeat.o(47996);
        }
      });
      localImageView.setTag(2131820690, null);
    }
    label331:
    AppMethodBeat.o(47997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a.b
 * JD-Core Version:    0.7.0.1
 */