package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.e.b;
import com.tencent.mm.ag.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;

final class FriendPreference$2
  implements e.b
{
  FriendPreference$2(FriendPreference paramFriendPreference, e parame, String paramString1, String paramString2) {}
  
  public final int bl(int paramInt1, int paramInt2)
  {
    this.eba.JU();
    y.i("MicroMsg.FriendPreference", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      o.JQ();
      Bitmap localBitmap = d.kh(this.dol);
      if (FriendPreference.a(this.mXY, this.mWK, localBitmap))
      {
        Toast.makeText(this.mXY.mContext, this.mXY.mContext.getString(R.l.contact_info_save_avater_ok), 0).show();
        return 0;
      }
    }
    Toast.makeText(this.mXY.mContext, this.mXY.mContext.getString(R.l.contact_info_save_avater_fail), 0).show();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference.2
 * JD-Core Version:    0.7.0.1
 */