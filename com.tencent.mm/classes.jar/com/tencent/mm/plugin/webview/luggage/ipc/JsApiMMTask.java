package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public class JsApiMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiMMTask> CREATOR;
  public String errMsg;
  public String hCt;
  public a.a uTe;
  public String uTf;
  public String uTg;
  
  static
  {
    AppMethodBeat.i(6263);
    CREATOR = new JsApiMMTask.2();
    AppMethodBeat.o(6263);
  }
  
  public JsApiMMTask() {}
  
  private JsApiMMTask(Parcel paramParcel)
  {
    AppMethodBeat.i(6261);
    f(paramParcel);
    AppMethodBeat.o(6261);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(6257);
    try
    {
      ((bh)Class.forName(this.uTf).newInstance()).a(ah.getContext(), this.hCt, new JsApiMMTask.1(this));
      AppMethodBeat.o(6257);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(6257);
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(6258);
    aBk();
    if (this.uTe != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.uTg);
        this.uTe.a(this.errMsg, localJSONObject);
        AppMethodBeat.o(6258);
        return;
      }
      catch (Exception localException)
      {
        this.uTe.a(this.errMsg, null);
      }
    }
    AppMethodBeat.o(6258);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(6259);
    this.hCt = paramParcel.readString();
    this.uTf = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.uTg = paramParcel.readString();
    AppMethodBeat.o(6259);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(6260);
    paramParcel.writeString(this.hCt);
    paramParcel.writeString(this.uTf);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeString(this.uTg);
    AppMethodBeat.o(6260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */