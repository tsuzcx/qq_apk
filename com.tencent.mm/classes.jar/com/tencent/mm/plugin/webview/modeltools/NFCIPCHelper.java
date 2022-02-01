package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.k;
import com.tencent.mm.f.a.k.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class NFCIPCHelper
{
  public static void b(k paramk)
  {
    AppMethodBeat.i(234002);
    Log.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", new Object[] { Integer.valueOf(paramk.fuF.actionCode) });
    try
    {
      NFCEventTransfer localNFCEventTransfer = new NFCEventTransfer(paramk);
      localNFCEventTransfer = (NFCEventTransfer)XIPCInvoker.a(ToolsProcessIPCService.PROCESS_NAME, localNFCEventTransfer, a.class);
      if ((localNFCEventTransfer != null) && (localNFCEventTransfer.fuK != null))
      {
        paramk.fuG.fuK = localNFCEventTransfer.fuK;
        AppMethodBeat.o(234002);
        return;
      }
      gWm();
      AppMethodBeat.o(234002);
      return;
    }
    catch (Exception paramk)
    {
      Log.printErrStackTrace("MicroMsg.NFCIPCHelper", paramk, "alvinluo nfcInvokeAsResult exception", new Object[0]);
      gWm();
      AppMethodBeat.o(234002);
    }
  }
  
  private static void gWm()
  {
    AppMethodBeat.i(79142);
    Log.e("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult error");
    h.IzE.el(968, 0);
    AppMethodBeat.o(79142);
  }
  
  static class NFCEventTransfer
    implements Parcelable
  {
    public static final Parcelable.Creator<NFCEventTransfer> CREATOR;
    public int actionCode;
    public String fuH;
    public boolean fuI;
    public boolean fuJ;
    public Bundle fuK;
    
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
      this.fuH = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.fuI = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.fuJ = bool1;
        this.fuK = paramParcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(79138);
        return;
        bool1 = false;
        break;
      }
    }
    
    public NFCEventTransfer(k paramk)
    {
      this.actionCode = paramk.fuF.actionCode;
      this.fuH = paramk.fuF.fuH;
      this.fuI = paramk.fuF.fuI;
      this.fuJ = paramk.fuF.fuJ;
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
      paramParcel.writeString(this.fuH);
      if (this.fuI)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.fuJ) {
          break label72;
        }
      }
      label72:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        paramParcel.writeBundle(this.fuK);
        AppMethodBeat.o(79139);
        return;
        b1 = 0;
        break;
      }
    }
  }
  
  static class a
    implements m<NFCIPCHelper.NFCEventTransfer, NFCIPCHelper.NFCEventTransfer>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper
 * JD-Core Version:    0.7.0.1
 */