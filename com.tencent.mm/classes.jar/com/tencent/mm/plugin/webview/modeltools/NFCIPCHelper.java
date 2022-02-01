package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.j.a;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class NFCIPCHelper
{
  public static void eUz()
  {
    AppMethodBeat.i(79142);
    ae.e("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult error");
    g.yxI.dD(968, 0);
    AppMethodBeat.o(79142);
  }
  
  public static class NFCEventTransfer
    implements Parcelable
  {
    public static final Parcelable.Creator<NFCEventTransfer> CREATOR;
    public int actionCode;
    public String dkS;
    public boolean dkT;
    public boolean dkU;
    public Bundle dkV;
    
    static
    {
      AppMethodBeat.i(79140);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(79140);
    }
    
    protected NFCEventTransfer(Parcel paramParcel)
    {
      AppMethodBeat.i(79138);
      this.actionCode = paramParcel.readInt();
      this.dkS = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.dkT = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.dkU = bool1;
        this.dkV = paramParcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(79138);
        return;
        bool1 = false;
        break;
      }
    }
    
    public NFCEventTransfer(j paramj)
    {
      this.actionCode = paramj.dkQ.actionCode;
      this.dkS = paramj.dkQ.dkS;
      this.dkT = paramj.dkQ.dkT;
      this.dkU = paramj.dkQ.dkU;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(79139);
      paramParcel.writeInt(this.actionCode);
      paramParcel.writeString(this.dkS);
      if (this.dkT)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.dkU) {
          break label72;
        }
      }
      label72:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        paramParcel.writeBundle(this.dkV);
        AppMethodBeat.o(79139);
        return;
        b1 = 0;
        break;
      }
    }
  }
  
  public static class a
    implements k<NFCIPCHelper.NFCEventTransfer, NFCIPCHelper.NFCEventTransfer>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper
 * JD-Core Version:    0.7.0.1
 */