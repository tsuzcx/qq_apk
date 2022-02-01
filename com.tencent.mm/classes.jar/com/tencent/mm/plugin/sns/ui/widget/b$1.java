package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class b$1
  implements f.a
{
  b$1(WeImageView paramWeImageView, String paramString, TextView paramTextView) {}
  
  public final void aNH(String paramString)
  {
    AppMethodBeat.i(203997);
    try
    {
      String str = (String)this.Ffd.getTag(2131307979);
      if (TextUtils.isEmpty(str)) {
        str = "";
      }
      while ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str)))
      {
        paramString = BitmapUtil.decodeFile(paramString, null);
        if (paramString != null)
        {
          this.Ffd.setImageBitmap(paramString);
          this.Ffd.setVisibility(0);
          if ((this.EJe != null) && ((this.EJe.getLayoutParams() instanceof LinearLayout.LayoutParams))) {
            ((LinearLayout.LayoutParams)this.EJe.getLayoutParams()).leftMargin = 0;
          }
          Log.d("SnsCardAdTagUtils", "onDownloaded succ, hash=" + this.Ffd.hashCode());
          AppMethodBeat.o(203997);
          return;
          str = h.kz("adId", str);
        }
        else
        {
          Log.e("SnsCardAdTagUtils", "onDownloaded, bitmap==null");
          AppMethodBeat.o(203997);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      Log.e("SnsCardAdTagUtils", "onDownloaded, exp=" + paramString.toString());
      AppMethodBeat.o(203997);
      return;
    }
    Log.d("SnsCardAdTagUtils", "onDownloaded, url changed");
    AppMethodBeat.o(203997);
  }
  
  public final void eWN() {}
  
  public final void eWO()
  {
    AppMethodBeat.i(203996);
    this.Ffd.setTag(2131307979, "");
    this.Ffd.setVisibility(8);
    Log.e("SnsCardAdTagUtils", "onDownloadError, hash=" + this.Ffd.hashCode() + ", url=" + this.DzZ);
    AppMethodBeat.o(203996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */