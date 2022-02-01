package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import i.a.a.b;

public final class WepkgRunCgi
{
  static c u(Parcel paramParcel)
  {
    AppMethodBeat.i(110806);
    c.a locala = new c.a();
    String str = paramParcel.readString();
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      locala.otE = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
      label48:
      str = paramParcel.readString();
      arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      try
      {
        locala.otF = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
        locala.uri = paramParcel.readString();
        locala.funcId = paramParcel.readInt();
        locala.otG = paramParcel.readInt();
        locala.respCmdId = paramParcel.readInt();
        paramParcel = locala.bEF();
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
              locala.otF = ((a)Class.forName(str).newInstance());
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
  
  public static final class RemoteCgiTask
    extends MainProcessTask
    implements z.a
  {
    public static final Parcelable.Creator<RemoteCgiTask> CREATOR;
    public int XHd;
    private c XHe;
    public c XHf;
    public WepkgRunCgi.a XHg;
    private String rzc;
    private int yoO;
    private int ypa;
    
    static
    {
      AppMethodBeat.i(110805);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110805);
    }
    
    public RemoteCgiTask()
    {
      this.XHd = 0;
    }
    
    RemoteCgiTask(Parcel paramParcel)
    {
      AppMethodBeat.i(110804);
      this.XHd = 0;
      h(paramParcel);
      AppMethodBeat.o(110804);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(110799);
      z.a(this.XHf, this, true);
      AppMethodBeat.o(110799);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(110801);
      d.cM(this);
      if (this.XHg != null) {
        this.XHg.callback(this.ypa, this.yoO, this.rzc, this.XHe);
      }
      AppMethodBeat.o(110801);
    }
    
    public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
    {
      AppMethodBeat.i(110800);
      this.ypa = paramInt1;
      this.yoO = paramInt2;
      this.rzc = paramString;
      this.XHe = paramc;
      this.XHd = 2;
      cpA();
      AppMethodBeat.o(110800);
      return 0;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(110803);
      super.h(paramParcel);
      this.XHd = paramParcel.readInt();
      switch (this.XHd)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(110803);
        return;
        this.XHf = WepkgRunCgi.u(paramParcel);
        AppMethodBeat.o(110803);
        return;
        this.ypa = paramParcel.readInt();
        this.yoO = paramParcel.readInt();
        this.rzc = paramParcel.readString();
        this.XHe = WepkgRunCgi.u(paramParcel);
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(110802);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.XHd);
      switch (this.XHd)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(110802);
        return;
        WepkgRunCgi.a(this.XHf, paramParcel);
        AppMethodBeat.o(110802);
        return;
        paramParcel.writeInt(this.ypa);
        paramParcel.writeInt(this.yoO);
        paramParcel.writeString(this.rzc);
        WepkgRunCgi.a(this.XHe, paramParcel);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void callback(int paramInt1, int paramInt2, String paramString, c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi
 * JD-Core Version:    0.7.0.1
 */