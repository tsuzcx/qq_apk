package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public class JsApiMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiMMTask> CREATOR;
  public a.a Cng;
  public String Cnh;
  public String Cni;
  public String errMsg;
  public String kct;
  
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
  
  public final void aLq()
  {
    AppMethodBeat.i(78497);
    try
    {
      ((bn)Class.forName(this.Cnh).newInstance()).a(ai.getContext(), this.kct, new bn.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78495);
          JsApiMMTask.this.errMsg = paramAnonymousString;
          if (paramAnonymousJSONObject != null) {
            JsApiMMTask.this.Cni = paramAnonymousJSONObject.toString();
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
      ac.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInMainProcess fail.", new Object[0]);
      AppMethodBeat.o(78497);
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(78498);
    bek();
    if (this.Cng != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.Cni);
        this.Cng.a(this.errMsg, localJSONObject);
        AppMethodBeat.o(78498);
        return;
      }
      catch (Exception localException)
      {
        this.Cng.a(this.errMsg, null);
        ac.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInClientProcess fail.", new Object[0]);
      }
    }
    AppMethodBeat.o(78498);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(78499);
    this.kct = paramParcel.readString();
    this.Cnh = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.Cni = paramParcel.readString();
    AppMethodBeat.o(78499);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(78500);
    paramParcel.writeString(this.kct);
    paramParcel.writeString(this.Cnh);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeString(this.Cni);
    AppMethodBeat.o(78500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */