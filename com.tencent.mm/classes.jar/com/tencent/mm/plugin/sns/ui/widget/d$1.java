package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class d$1
  implements g.a
{
  d$1(WeImageView paramWeImageView, String paramString, TextView paramTextView) {}
  
  public final void aWn(String paramString)
  {
    AppMethodBeat.i(309226);
    try
    {
      String str = (String)this.RXb.getTag(b.f.sns_ad_card_img_url);
      if (TextUtils.isEmpty(str)) {
        str = "";
      }
      while ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str)))
      {
        paramString = BitmapUtil.decodeFile(paramString, null);
        if (paramString != null)
        {
          this.RXb.setImageBitmap(paramString);
          this.RXb.setVisibility(0);
          if ((this.KCw != null) && ((this.KCw.getLayoutParams() instanceof LinearLayout.LayoutParams))) {
            ((LinearLayout.LayoutParams)this.KCw.getLayoutParams()).leftMargin = 0;
          }
          Log.d("SnsCardAdTagUtils", "onDownloaded succ, hash=" + this.RXb.hashCode());
          AppMethodBeat.o(309226);
          return;
          str = k.mC("adId", str);
        }
        else
        {
          Log.e("SnsCardAdTagUtils", "onDownloaded, bitmap==null");
          AppMethodBeat.o(309226);
          return;
        }
      }
    }
    finally
    {
      Log.e("SnsCardAdTagUtils", "onDownloaded, exp=" + paramString.toString());
      AppMethodBeat.o(309226);
      return;
    }
    Log.d("SnsCardAdTagUtils", "onDownloaded, url changed");
    AppMethodBeat.o(309226);
  }
  
  public final void gZM() {}
  
  public final void gZN()
  {
    AppMethodBeat.i(309220);
    this.RXb.setTag(b.f.sns_ad_card_img_url, "");
    this.RXb.setVisibility(8);
    Log.e("SnsCardAdTagUtils", "onDownloadError, hash=" + this.RXb.hashCode() + ", url=" + this.PUd);
    AppMethodBeat.o(309220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.d.1
 * JD-Core Version:    0.7.0.1
 */