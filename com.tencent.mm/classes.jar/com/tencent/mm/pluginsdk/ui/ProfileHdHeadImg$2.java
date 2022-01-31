package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.ab;

final class ProfileHdHeadImg$2
  implements e.c
{
  ProfileHdHeadImg$2(ProfileHdHeadImg paramProfileHdHeadImg, Bitmap paramBitmap) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27525);
    ProfileHdHeadImg.a(this.vRA).acU();
    ab.i("MicroMsg.ProfileHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      o.acQ();
      Bitmap localBitmap = d.rb(ProfileHdHeadImg.b(this.vRA));
      if (localBitmap != null)
      {
        ProfileHdHeadImg localProfileHdHeadImg = this.vRA;
        o.acQ();
        ProfileHdHeadImg.a(localProfileHdHeadImg, localBitmap, d.D(ProfileHdHeadImg.b(this.vRA), true));
      }
      for (;;)
      {
        AppMethodBeat.o(27525);
        return 0;
        ProfileHdHeadImg.a(this.vRA, this.qGq, null);
      }
    }
    ProfileHdHeadImg.a(this.vRA, this.qGq, null);
    AppMethodBeat.o(27525);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg.2
 * JD-Core Version:    0.7.0.1
 */