package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class WepkgRunCgi
{
  static com.tencent.mm.al.b o(Parcel paramParcel)
  {
    AppMethodBeat.i(110806);
    b.a locala = new b.a();
    String str = paramParcel.readString();
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      locala.hNM = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
      label48:
      str = paramParcel.readString();
      arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      try
      {
        locala.hNN = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
        locala.uri = paramParcel.readString();
        locala.funcId = paramParcel.readInt();
        locala.hNO = paramParcel.readInt();
        locala.respCmdId = paramParcel.readInt();
        paramParcel = locala.aDC();
        AppMethodBeat.o(110806);
        return paramParcel;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if ((localException3 instanceof f.a.a.b)) {
            try
            {
              locala.hNN = ((a)Class.forName(str).newInstance());
            }
            catch (Exception localException1)
            {
              ad.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[] { bt.n(localException1) });
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi
 * JD-Core Version:    0.7.0.1
 */