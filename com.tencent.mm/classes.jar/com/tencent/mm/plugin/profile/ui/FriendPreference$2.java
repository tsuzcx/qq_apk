package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

final class FriendPreference$2
  implements e.c
{
  FriendPreference$2(FriendPreference paramFriendPreference, e parame, String paramString1, String paramString2) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23621);
    this.fro.acU();
    ab.i("MicroMsg.FriendPreference", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      o.acQ();
      Bitmap localBitmap = d.rb(this.efI);
      if (FriendPreference.a(this.pAL, this.pzF, localBitmap))
      {
        Toast.makeText(this.pAL.mContext, this.pAL.mContext.getString(2131298739), 0).show();
        AppMethodBeat.o(23621);
        return 0;
      }
    }
    Toast.makeText(this.pAL.mContext, this.pAL.mContext.getString(2131298737), 0).show();
    AppMethodBeat.o(23621);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference.2
 * JD-Core Version:    0.7.0.1
 */