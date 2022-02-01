package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class NFCIPCHelper
{
  public static void gdo()
  {
    AppMethodBeat.i(79142);
    Log.e("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult error");
    h.CyF.dN(968, 0);
    AppMethodBeat.o(79142);
  }
  
  public static class NFCEventTransfer
    implements Parcelable
  {
    public static final Parcelable.Creator<NFCEventTransfer> CREATOR;
    public int actionCode;
    public String dCe;
    public boolean dCf;
    public boolean dCg;
    public Bundle dCh;
    
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
      this.dCe = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.dCf = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.dCg = bool1;
        this.dCh = paramParcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(79138);
        return;
        bool1 = false;
        break;
      }
    }
    
    public NFCEventTransfer(com.tencent.mm.g.a.k paramk)
    {
      this.actionCode = paramk.dCc.actionCode;
      this.dCe = paramk.dCc.dCe;
      this.dCf = paramk.dCc.dCf;
      this.dCg = paramk.dCc.dCg;
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
      paramParcel.writeString(this.dCe);
      if (this.dCf)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.dCg) {
          break label72;
        }
      }
      label72:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        paramParcel.writeBundle(this.dCh);
        AppMethodBeat.o(79139);
        return;
        b1 = 0;
        break;
      }
    }
  }
  
  public static class a
    implements com.tencent.mm.ipcinvoker.k<NFCIPCHelper.NFCEventTransfer, NFCIPCHelper.NFCEventTransfer>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper
 * JD-Core Version:    0.7.0.1
 */