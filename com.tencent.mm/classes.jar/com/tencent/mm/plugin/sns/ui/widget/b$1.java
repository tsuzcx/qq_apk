package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class b$1
  implements f.a
{
  b$1(WeImageView paramWeImageView, String paramString, TextView paramTextView) {}
  
  public final void aYs(String paramString)
  {
    AppMethodBeat.i(195335);
    try
    {
      String str = (String)this.LtI.getTag(i.f.sns_ad_card_img_url);
      if (TextUtils.isEmpty(str)) {
        str = "";
      }
      while ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str)))
      {
        paramString = BitmapUtil.decodeFile(paramString, null);
        if (paramString != null)
        {
          this.LtI.setImageBitmap(paramString);
          this.LtI.setVisibility(0);
          if ((this.EIX != null) && ((this.EIX.getLayoutParams() instanceof LinearLayout.LayoutParams))) {
            ((LinearLayout.LayoutParams)this.EIX.getLayoutParams()).leftMargin = 0;
          }
          Log.d("SnsCardAdTagUtils", "onDownloaded succ, hash=" + this.LtI.hashCode());
          AppMethodBeat.o(195335);
          return;
          str = h.kU("adId", str);
        }
        else
        {
          Log.e("SnsCardAdTagUtils", "onDownloaded, bitmap==null");
          AppMethodBeat.o(195335);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      Log.e("SnsCardAdTagUtils", "onDownloaded, exp=" + paramString.toString());
      AppMethodBeat.o(195335);
      return;
    }
    Log.d("SnsCardAdTagUtils", "onDownloaded, url changed");
    AppMethodBeat.o(195335);
  }
  
  public final void fJU() {}
  
  public final void fJV()
  {
    AppMethodBeat.i(195333);
    this.LtI.setTag(i.f.sns_ad_card_img_url, "");
    this.LtI.setVisibility(8);
    Log.e("SnsCardAdTagUtils", "onDownloadError, hash=" + this.LtI.hashCode() + ", url=" + this.JLq);
    AppMethodBeat.o(195333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */