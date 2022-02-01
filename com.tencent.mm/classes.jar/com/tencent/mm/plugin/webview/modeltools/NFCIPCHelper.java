package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.m.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class NFCIPCHelper
{
  public static void b(com.tencent.mm.autogen.a.m paramm)
  {
    AppMethodBeat.i(295820);
    Log.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", new Object[] { Integer.valueOf(paramm.hyZ.actionCode) });
    try
    {
      NFCEventTransfer localNFCEventTransfer = new NFCEventTransfer(paramm);
      localNFCEventTransfer = (NFCEventTransfer)XIPCInvoker.a(ToolsProcessIPCService.PROCESS_NAME, localNFCEventTransfer, a.class);
      if ((localNFCEventTransfer != null) && (localNFCEventTransfer.hze != null))
      {
        paramm.hza.hze = localNFCEventTransfer.hze;
        AppMethodBeat.o(295820);
        return;
      }
      ivS();
      AppMethodBeat.o(295820);
      return;
    }
    catch (Exception paramm)
    {
      Log.printErrStackTrace("MicroMsg.NFCIPCHelper", paramm, "alvinluo nfcInvokeAsResult exception", new Object[0]);
      ivS();
      AppMethodBeat.o(295820);
    }
  }
  
  private static void ivS()
  {
    AppMethodBeat.i(79142);
    Log.e("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult error");
    h.OAn.kJ(968, 0);
    AppMethodBeat.o(79142);
  }
  
  static class NFCEventTransfer
    implements Parcelable
  {
    public static final Parcelable.Creator<NFCEventTransfer> CREATOR;
    public int actionCode;
    public String hzb;
    public boolean hzc;
    public boolean hzd;
    public Bundle hze;
    
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
      this.hzb = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.hzc = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.hzd = bool1;
        this.hze = paramParcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(79138);
        return;
        bool1 = false;
        break;
      }
    }
    
    public NFCEventTransfer(com.tencent.mm.autogen.a.m paramm)
    {
      this.actionCode = paramm.hyZ.actionCode;
      this.hzb = paramm.hyZ.hzb;
      this.hzc = paramm.hyZ.hzc;
      this.hzd = paramm.hyZ.hzd;
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
      paramParcel.writeString(this.hzb);
      if (this.hzc)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.hzd) {
          break label72;
        }
      }
      label72:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        paramParcel.writeBundle(this.hze);
        AppMethodBeat.o(79139);
        return;
        b1 = 0;
        break;
      }
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.m<NFCIPCHelper.NFCEventTransfer, NFCIPCHelper.NFCEventTransfer>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper
 * JD-Core Version:    0.7.0.1
 */