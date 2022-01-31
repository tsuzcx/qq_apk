package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class WepkgRunCgi
{
  static com.tencent.mm.ai.b n(Parcel paramParcel)
  {
    AppMethodBeat.i(63647);
    b.a locala = new b.a();
    String str = paramParcel.readString();
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      locala.fsX = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
      label48:
      str = paramParcel.readString();
      arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      try
      {
        locala.fsY = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
        locala.uri = paramParcel.readString();
        locala.funcId = paramParcel.readInt();
        locala.reqCmdId = paramParcel.readInt();
        locala.respCmdId = paramParcel.readInt();
        paramParcel = locala.ado();
        AppMethodBeat.o(63647);
        return paramParcel;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if ((localException3 instanceof e.a.a.b)) {
            try
            {
              locala.fsY = ((a)Class.forName(str).newInstance());
            }
            catch (Exception localException1)
            {
              ab.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[] { bo.l(localException1) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi
 * JD-Core Version:    0.7.0.1
 */