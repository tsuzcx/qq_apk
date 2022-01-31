package com.tencent.mm.plugin.webview.luggage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.ar;

class LuggageMMLocalResourceProvider$GetLocalResourceInfoTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetLocalResourceInfoTask> CREATOR;
  String ctV;
  Runnable hzK;
  int infoType;
  String path;
  
  static
  {
    AppMethodBeat.i(5986);
    CREATOR = new LuggageMMLocalResourceProvider.GetLocalResourceInfoTask.1();
    AppMethodBeat.o(5986);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(5982);
    switch (this.infoType)
    {
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(5982);
      return;
      this.path = ar.aho(this.ctV);
      continue;
      this.path = ar.ahp(this.ctV);
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(5983);
    if (this.hzK != null) {
      this.hzK.run();
    }
    AppMethodBeat.o(5983);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(5985);
    this.ctV = paramParcel.readString();
    this.infoType = paramParcel.readInt();
    this.path = paramParcel.readString();
    AppMethodBeat.o(5985);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(5984);
    paramParcel.writeString(this.ctV);
    paramParcel.writeInt(this.infoType);
    paramParcel.writeString(this.path);
    AppMethodBeat.o(5984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider.GetLocalResourceInfoTask
 * JD-Core Version:    0.7.0.1
 */