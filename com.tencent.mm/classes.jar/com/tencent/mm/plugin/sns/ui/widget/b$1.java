package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class b$1
  implements f.a
{
  b$1(WeImageView paramWeImageView, String paramString, TextView paramTextView) {}
  
  public final void asD(String paramString)
  {
    AppMethodBeat.i(200666);
    try
    {
      String str = (String)this.zkS.getTag(2131304892);
      if (TextUtils.isEmpty(str)) {
        str = "";
      }
      while ((!TextUtils.isEmpty(paramString)) && (paramString.equals(str)))
      {
        paramString = f.decodeFile(paramString, null);
        if (paramString != null)
        {
          this.zkS.setImageBitmap(paramString);
          this.zkS.setVisibility(0);
          if ((this.zkP != null) && ((this.zkP.getLayoutParams() instanceof LinearLayout.LayoutParams))) {
            ((LinearLayout.LayoutParams)this.zkP.getLayoutParams()).leftMargin = 0;
          }
          ac.d("SnsCardAdTagUtils", "onDownloaded succ, hash=" + this.zkS.hashCode());
          AppMethodBeat.o(200666);
          return;
          str = h.js("adId", str);
        }
        else
        {
          ac.e("SnsCardAdTagUtils", "onDownloaded, bitmap==null");
          AppMethodBeat.o(200666);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      ac.e("SnsCardAdTagUtils", "onDownloaded, exp=" + paramString.toString());
      AppMethodBeat.o(200666);
      return;
    }
    ac.d("SnsCardAdTagUtils", "onDownloaded, url changed");
    AppMethodBeat.o(200666);
  }
  
  public final void dFC() {}
  
  public final void dFD()
  {
    AppMethodBeat.i(200665);
    this.zkS.setTag(2131304892, "");
    this.zkS.setVisibility(8);
    ac.e("SnsCardAdTagUtils", "onDownloadError, hash=" + this.zkS.hashCode() + ", url=" + this.xLY);
    AppMethodBeat.o(200665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */