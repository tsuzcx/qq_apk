package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public class JsApiMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiMMTask> CREATOR;
  public b.a EiB;
  public String EiC;
  public String EiD;
  public String errMsg;
  public String kAh;
  
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
  
  public final void aOX()
  {
    AppMethodBeat.i(78497);
    try
    {
      ((bq)Class.forName(this.EiC).newInstance()).a(ak.getContext(), this.kAh, new bq.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78495);
          JsApiMMTask.this.errMsg = paramAnonymousString;
          if (paramAnonymousJSONObject != null) {
            JsApiMMTask.this.EiD = paramAnonymousJSONObject.toString();
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
      ae.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInMainProcess fail.", new Object[0]);
      AppMethodBeat.o(78497);
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(78498);
    bix();
    if (this.EiB != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.EiD);
        this.EiB.a(this.errMsg, localJSONObject);
        AppMethodBeat.o(78498);
        return;
      }
      catch (Exception localException)
      {
        this.EiB.a(this.errMsg, null);
        ae.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInClientProcess fail.", new Object[0]);
      }
    }
    AppMethodBeat.o(78498);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(78499);
    this.kAh = paramParcel.readString();
    this.EiC = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.EiD = paramParcel.readString();
    AppMethodBeat.o(78499);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(78500);
    paramParcel.writeString(this.kAh);
    paramParcel.writeString(this.EiC);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeString(this.EiD);
    AppMethodBeat.o(78500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */