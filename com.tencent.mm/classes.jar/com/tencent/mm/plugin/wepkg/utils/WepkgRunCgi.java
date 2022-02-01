package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import g.a.a.b;

public final class WepkgRunCgi
{
  static d q(Parcel paramParcel)
  {
    AppMethodBeat.i(110806);
    d.a locala = new d.a();
    String str = paramParcel.readString();
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      locala.iLN = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
      label48:
      str = paramParcel.readString();
      arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      try
      {
        locala.iLO = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
        locala.uri = paramParcel.readString();
        locala.funcId = paramParcel.readInt();
        locala.iLP = paramParcel.readInt();
        locala.respCmdId = paramParcel.readInt();
        paramParcel = locala.aXF();
        AppMethodBeat.o(110806);
        return paramParcel;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if ((localException3 instanceof b)) {
            try
            {
              locala.iLO = ((a)Class.forName(str).newInstance());
            }
            catch (Exception localException1)
            {
              Log.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[] { Util.stackTraceToString(localException1) });
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