package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class NFCIPCHelper
{
  public static void dcx()
  {
    AppMethodBeat.i(6951);
    ab.e("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult error");
    h.qsU.cT(968, 0);
    AppMethodBeat.o(6951);
  }
  
  public static class NFCEventTransfer
    implements Parcelable
  {
    public static final Parcelable.Creator<NFCEventTransfer> CREATOR;
    public int actionCode;
    public String cmq;
    public boolean cmr;
    public boolean cms;
    public Bundle cmt;
    
    static
    {
      AppMethodBeat.i(6949);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(6949);
    }
    
    protected NFCEventTransfer(Parcel paramParcel)
    {
      AppMethodBeat.i(6947);
      this.actionCode = paramParcel.readInt();
      this.cmq = paramParcel.readString();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.cmr = bool1;
        if (paramParcel.readByte() == 0) {
          break label83;
        }
      }
      label83:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.cms = bool1;
        this.cmt = paramParcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(6947);
        return;
        bool1 = false;
        break;
      }
    }
    
    public NFCEventTransfer(j paramj)
    {
      this.actionCode = paramj.cmo.actionCode;
      this.cmq = paramj.cmo.cmq;
      this.cmr = paramj.cmo.cmr;
      this.cms = paramj.cmo.cms;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(6948);
      paramParcel.writeInt(this.actionCode);
      paramParcel.writeString(this.cmq);
      if (this.cmr)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.cms) {
          break label74;
        }
      }
      label74:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        paramParcel.writeBundle(this.cmt);
        AppMethodBeat.o(6948);
        return;
        b1 = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper
 * JD-Core Version:    0.7.0.1
 */