package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class WepkgRunCgi
{
  static com.tencent.mm.ah.b k(Parcel paramParcel)
  {
    b.a locala = new b.a();
    String str = paramParcel.readString();
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      locala.ecH = ((a)Class.forName(str).newInstance()).aH(arrayOfByte);
      label43:
      str = paramParcel.readString();
      arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      try
      {
        locala.ecI = ((a)Class.forName(str).newInstance()).aH(arrayOfByte);
        locala.uri = paramParcel.readString();
        locala.ecG = paramParcel.readInt();
        locala.ecJ = paramParcel.readInt();
        locala.ecK = paramParcel.readInt();
        return locala.Kt();
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if ((localException3 instanceof d.a.a.b)) {
            try
            {
              locala.ecI = ((a)Class.forName(str).newInstance());
            }
            catch (Exception localException1)
            {
              y.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[] { bk.j(localException1) });
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi
 * JD-Core Version:    0.7.0.1
 */