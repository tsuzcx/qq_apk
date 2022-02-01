package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class WepkgRunCgi
{
  static com.tencent.mm.al.b n(Parcel paramParcel)
  {
    AppMethodBeat.i(110806);
    b.a locala = new b.a();
    String str = paramParcel.readString();
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      locala.gUU = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
      label48:
      str = paramParcel.readString();
      arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      try
      {
        locala.gUV = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
        locala.uri = paramParcel.readString();
        locala.funcId = paramParcel.readInt();
        locala.reqCmdId = paramParcel.readInt();
        locala.respCmdId = paramParcel.readInt();
        paramParcel = locala.atI();
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
              locala.gUV = ((a)Class.forName(str).newInstance());
            }
            catch (Exception localException1)
            {
              ad.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[] { bt.m(localException1) });
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
    public int BJR;
    private com.tencent.mm.al.b BJS;
    public com.tencent.mm.al.b BJT;
    public WepkgRunCgi.a BJU;
    private String jyg;
    private int oTe;
    private int oTq;
    
    static
    {
      AppMethodBeat.i(110805);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110805);
    }
    
    public RemoteCgiTask()
    {
      this.BJR = 0;
    }
    
    RemoteCgiTask(Parcel paramParcel)
    {
      AppMethodBeat.i(110804);
      this.BJR = 0;
      e(paramParcel);
      AppMethodBeat.o(110804);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, n paramn)
    {
      AppMethodBeat.i(110800);
      this.oTq = paramInt1;
      this.oTe = paramInt2;
      this.jyg = paramString;
      this.BJS = paramb;
      this.BJR = 2;
      aXw();
      AppMethodBeat.o(110800);
      return 0;
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(110801);
      d.bk(this);
      if (this.BJU != null) {
        this.BJU.a(this.oTq, this.oTe, this.jyg, this.BJS);
      }
      AppMethodBeat.o(110801);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(110799);
      x.a(this.BJT, this, true);
      AppMethodBeat.o(110799);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(110803);
      super.e(paramParcel);
      this.BJR = paramParcel.readInt();
      switch (this.BJR)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(110803);
        return;
        this.BJT = WepkgRunCgi.n(paramParcel);
        AppMethodBeat.o(110803);
        return;
        this.oTq = paramParcel.readInt();
        this.oTe = paramParcel.readInt();
        this.jyg = paramParcel.readString();
        this.BJS = WepkgRunCgi.n(paramParcel);
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(110802);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.BJR);
      switch (this.BJR)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(110802);
        return;
        WepkgRunCgi.a(this.BJT, paramParcel);
        AppMethodBeat.o(110802);
        return;
        paramParcel.writeInt(this.oTq);
        paramParcel.writeInt(this.oTe);
        paramParcel.writeString(this.jyg);
        WepkgRunCgi.a(this.BJS, paramParcel);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi
 * JD-Core Version:    0.7.0.1
 */