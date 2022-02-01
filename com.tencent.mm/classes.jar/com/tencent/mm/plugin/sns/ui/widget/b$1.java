package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class b$1
  implements f.a
{
  b$1(WeImageView paramWeImageView, String paramString, TextView paramTextView) {}
  
  public final void apm(String paramString)
  {
    AppMethodBeat.i(187793);
    try
    {
      String str = (String)this.xXW.getTag(2131304892);
      if (TextUtils.isEmpty(str)) {
        str = "";
      }
      while ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str)))
      {
        paramString = f.decodeFile(paramString, null);
        if (paramString != null)
        {
          this.xXW.setImageBitmap(paramString);
          this.xXW.setVisibility(0);
          if ((this.xXT != null) && ((this.xXT.getLayoutParams() instanceof LinearLayout.LayoutParams))) {
            ((LinearLayout.LayoutParams)this.xXT.getLayoutParams()).leftMargin = 0;
          }
          ad.d("SnsCardAdTagUtils", "onDownloaded succ, hash=" + this.xXW.hashCode());
          AppMethodBeat.o(187793);
          return;
          str = h.iU("adId", str);
        }
        else
        {
          ad.e("SnsCardAdTagUtils", "onDownloaded, bitmap==null");
          AppMethodBeat.o(187793);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      ad.e("SnsCardAdTagUtils", "onDownloaded, exp=" + paramString.toString());
      AppMethodBeat.o(187793);
      return;
    }
    ad.d("SnsCardAdTagUtils", "onDownloaded, url changed");
    AppMethodBeat.o(187793);
  }
  
  public final void dsA()
  {
    AppMethodBeat.i(187792);
    this.xXW.setTag(2131304892, "");
    this.xXW.setVisibility(8);
    ad.e("SnsCardAdTagUtils", "onDownloadError, hash=" + this.xXW.hashCode() + ", url=" + this.wOJ);
    AppMethodBeat.o(187792);
  }
  
  public final void duP() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */