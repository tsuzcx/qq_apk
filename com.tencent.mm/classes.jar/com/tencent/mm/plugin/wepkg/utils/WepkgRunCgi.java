package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class WepkgRunCgi
{
  static com.tencent.mm.ak.b o(Parcel paramParcel)
  {
    AppMethodBeat.i(110806);
    b.a locala = new b.a();
    String str = paramParcel.readString();
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      locala.hvt = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
      label48:
      str = paramParcel.readString();
      arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      try
      {
        locala.hvu = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
        locala.uri = paramParcel.readString();
        locala.funcId = paramParcel.readInt();
        locala.reqCmdId = paramParcel.readInt();
        locala.respCmdId = paramParcel.readInt();
        paramParcel = locala.aAz();
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
              locala.hvu = ((a)Class.forName(str).newInstance());
            }
            catch (Exception localException1)
            {
              ac.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[] { bs.m(localException1) });
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
    implements x.a
  {
    public static final Parcelable.Creator<RemoteCgiTask> CREATOR;
    public int Dca;
    private com.tencent.mm.ak.b Dcb;
    public com.tencent.mm.ak.b Dcc;
    public WepkgRunCgi.a Dcd;
    private String jYB;
    private int pwB;
    private int pwp;
    
    static
    {
      AppMethodBeat.i(110805);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110805);
    }
    
    public RemoteCgiTask()
    {
      this.Dca = 0;
    }
    
    RemoteCgiTask(Parcel paramParcel)
    {
      AppMethodBeat.i(110804);
      this.Dca = 0;
      e(paramParcel);
      AppMethodBeat.o(110804);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
    {
      AppMethodBeat.i(110800);
      this.pwB = paramInt1;
      this.pwp = paramInt2;
      this.jYB = paramString;
      this.Dcb = paramb;
      this.Dca = 2;
      bet();
      AppMethodBeat.o(110800);
      return 0;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(110799);
      x.a(this.Dcc, this, true);
      AppMethodBeat.o(110799);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(110801);
      d.bh(this);
      if (this.Dcd != null) {
        this.Dcd.a(this.pwB, this.pwp, this.jYB, this.Dcb);
      }
      AppMethodBeat.o(110801);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(110803);
      super.e(paramParcel);
      this.Dca = paramParcel.readInt();
      switch (this.Dca)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(110803);
        return;
        this.Dcc = WepkgRunCgi.o(paramParcel);
        AppMethodBeat.o(110803);
        return;
        this.pwB = paramParcel.readInt();
        this.pwp = paramParcel.readInt();
        this.jYB = paramParcel.readString();
        this.Dcb = WepkgRunCgi.o(paramParcel);
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(110802);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Dca);
      switch (this.Dca)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(110802);
        return;
        WepkgRunCgi.a(this.Dcc, paramParcel);
        AppMethodBeat.o(110802);
        return;
        paramParcel.writeInt(this.pwB);
        paramParcel.writeInt(this.pwp);
        paramParcel.writeString(this.jYB);
        WepkgRunCgi.a(this.Dcb, paramParcel);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi
 * JD-Core Version:    0.7.0.1
 */