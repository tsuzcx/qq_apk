package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class b$1
  implements f.a
{
  b$1(WeImageView paramWeImageView, String paramString, TextView paramTextView) {}
  
  public final void axG(String paramString)
  {
    AppMethodBeat.i(198605);
    try
    {
      String str = (String)this.ACW.getTag(2131304892);
      if (TextUtils.isEmpty(str)) {
        str = "";
      }
      while ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str)))
      {
        paramString = g.decodeFile(paramString, null);
        if (paramString != null)
        {
          this.ACW.setImageBitmap(paramString);
          this.ACW.setVisibility(0);
          if ((this.ogz != null) && ((this.ogz.getLayoutParams() instanceof LinearLayout.LayoutParams))) {
            ((LinearLayout.LayoutParams)this.ogz.getLayoutParams()).leftMargin = 0;
          }
          ad.d("SnsCardAdTagUtils", "onDownloaded succ, hash=" + this.ACW.hashCode());
          AppMethodBeat.o(198605);
          return;
          str = h.jF("adId", str);
        }
        else
        {
          ad.e("SnsCardAdTagUtils", "onDownloaded, bitmap==null");
          AppMethodBeat.o(198605);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      ad.e("SnsCardAdTagUtils", "onDownloaded, exp=" + paramString.toString());
      AppMethodBeat.o(198605);
      return;
    }
    ad.d("SnsCardAdTagUtils", "onDownloaded, url changed");
    AppMethodBeat.o(198605);
  }
  
  public final void dRW() {}
  
  public final void dRX()
  {
    AppMethodBeat.i(198604);
    this.ACW.setTag(2131304892, "");
    this.ACW.setVisibility(8);
    ad.e("SnsCardAdTagUtils", "onDownloadError, hash=" + this.ACW.hashCode() + ", url=" + this.zbw);
    AppMethodBeat.o(198604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */