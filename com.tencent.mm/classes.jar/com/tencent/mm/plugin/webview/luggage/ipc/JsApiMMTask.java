package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class JsApiMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiMMTask> CREATOR;
  public a.a AUT;
  public String AUU;
  public String AUV;
  public String errMsg;
  public String jBX;
  
  static
  {
    AppMethodBeat.i(78503);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(78503);
  }
  
  public JsApiMMTask() {}
  
  private JsApiMMTask(Parcel paramParcel)
  {
    AppMethodBeat.i(78501);
    e(paramParcel);
    AppMethodBeat.o(78501);
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(78498);
    aXn();
    if (this.AUT != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.AUV);
        this.AUT.a(this.errMsg, localJSONObject);
        AppMethodBeat.o(78498);
        return;
      }
      catch (Exception localException)
      {
        this.AUT.a(this.errMsg, null);
      }
    }
    AppMethodBeat.o(78498);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(78497);
    try
    {
      ((bn)Class.forName(this.AUU).newInstance()).a(aj.getContext(), this.jBX, new bn.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78495);
          JsApiMMTask.this.errMsg = paramAnonymousString;
          if (paramAnonymousJSONObject != null) {
            JsApiMMTask.this.AUV = paramAnonymousJSONObject.toString();
          }
          JsApiMMTask.a(JsApiMMTask.this);
          AppMethodBeat.o(78495);
        }
      });
      AppMethodBeat.o(78497);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(78497);
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(78499);
    this.jBX = paramParcel.readString();
    this.AUU = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.AUV = paramParcel.readString();
    AppMethodBeat.o(78499);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(78500);
    paramParcel.writeString(this.jBX);
    paramParcel.writeString(this.AUU);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeString(this.AUV);
    AppMethodBeat.o(78500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */