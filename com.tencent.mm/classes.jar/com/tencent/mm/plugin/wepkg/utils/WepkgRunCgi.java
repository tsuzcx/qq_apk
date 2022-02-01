package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import g.a.a.b;

public final class WepkgRunCgi
{
  static com.tencent.mm.an.d q(Parcel paramParcel)
  {
    AppMethodBeat.i(110806);
    d.a locala = new d.a();
    String str = paramParcel.readString();
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      locala.lBU = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
      label48:
      str = paramParcel.readString();
      arrayOfByte = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(arrayOfByte);
      try
      {
        locala.lBV = ((a)Class.forName(str).newInstance()).parseFrom(arrayOfByte);
        locala.uri = paramParcel.readString();
        locala.funcId = paramParcel.readInt();
        locala.lBW = paramParcel.readInt();
        locala.respCmdId = paramParcel.readInt();
        paramParcel = locala.bgN();
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
              locala.lBV = ((a)Class.forName(str).newInstance());
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
    implements aa.a
  {
    public static final Parcelable.Creator<RemoteCgiTask> CREATOR;
    public int QNF;
    private com.tencent.mm.an.d QNG;
    public com.tencent.mm.an.d QNH;
    public WepkgRunCgi.a QNI;
    private String ovI;
    private int vdb;
    private int vdn;
    
    static
    {
      AppMethodBeat.i(110805);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(110805);
    }
    
    public RemoteCgiTask()
    {
      this.QNF = 0;
    }
    
    RemoteCgiTask(Parcel paramParcel)
    {
      AppMethodBeat.i(110804);
      this.QNF = 0;
      f(paramParcel);
      AppMethodBeat.o(110804);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(110799);
      aa.a(this.QNH, this, true);
      AppMethodBeat.o(110799);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, q paramq)
    {
      AppMethodBeat.i(110800);
      this.vdn = paramInt1;
      this.vdb = paramInt2;
      this.ovI = paramString;
      this.QNG = paramd;
      this.QNF = 2;
      bPt();
      AppMethodBeat.o(110800);
      return 0;
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(110801);
      d.bs(this);
      if (this.QNI != null) {
        this.QNI.a(this.vdn, this.vdb, this.ovI, this.QNG);
      }
      AppMethodBeat.o(110801);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(110803);
      super.f(paramParcel);
      this.QNF = paramParcel.readInt();
      switch (this.QNF)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(110803);
        return;
        this.QNH = WepkgRunCgi.q(paramParcel);
        AppMethodBeat.o(110803);
        return;
        this.vdn = paramParcel.readInt();
        this.vdb = paramParcel.readInt();
        this.ovI = paramParcel.readString();
        this.QNG = WepkgRunCgi.q(paramParcel);
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(110802);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.QNF);
      switch (this.QNF)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(110802);
        return;
        WepkgRunCgi.a(this.QNH, paramParcel);
        AppMethodBeat.o(110802);
        return;
        paramParcel.writeInt(this.vdn);
        paramParcel.writeInt(this.vdb);
        paramParcel.writeString(this.ovI);
        WepkgRunCgi.a(this.QNG, paramParcel);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi
 * JD-Core Version:    0.7.0.1
 */