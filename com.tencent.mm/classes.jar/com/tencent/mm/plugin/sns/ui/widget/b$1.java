package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class b$1
  implements f.a
{
  b$1(WeImageView paramWeImageView, String paramString, TextView paramTextView) {}
  
  public final void ayY(String paramString)
  {
    AppMethodBeat.i(220152);
    try
    {
      String str = (String)this.AUx.getTag(2131304892);
      if (TextUtils.isEmpty(str)) {
        str = "";
      }
      while ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str)))
      {
        paramString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramString, null);
        if (paramString != null)
        {
          this.AUx.setImageBitmap(paramString);
          this.AUx.setVisibility(0);
          if ((this.omy != null) && ((this.omy.getLayoutParams() instanceof LinearLayout.LayoutParams))) {
            ((LinearLayout.LayoutParams)this.omy.getLayoutParams()).leftMargin = 0;
          }
          ae.d("SnsCardAdTagUtils", "onDownloaded succ, hash=" + this.AUx.hashCode());
          AppMethodBeat.o(220152);
          return;
          str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", str);
        }
        else
        {
          ae.e("SnsCardAdTagUtils", "onDownloaded, bitmap==null");
          AppMethodBeat.o(220152);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      ae.e("SnsCardAdTagUtils", "onDownloaded, exp=" + paramString.toString());
      AppMethodBeat.o(220152);
      return;
    }
    ae.d("SnsCardAdTagUtils", "onDownloaded, url changed");
    AppMethodBeat.o(220152);
  }
  
  public final void dVu() {}
  
  public final void dVv()
  {
    AppMethodBeat.i(220151);
    this.AUx.setTag(2131304892, "");
    this.AUx.setVisibility(8);
    ae.e("SnsCardAdTagUtils", "onDownloadError, hash=" + this.AUx.hashCode() + ", url=" + this.zsa);
    AppMethodBeat.o(220151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */