package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class JsApiMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiMMTask> CREATOR;
  public b.a DQB;
  public String DQC;
  public String DQD;
  public String errMsg;
  public String kwS;
  
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
  
  public final void aOA()
  {
    AppMethodBeat.i(78497);
    try
    {
      ((bq)Class.forName(this.DQC).newInstance()).a(aj.getContext(), this.kwS, new bq.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78495);
          JsApiMMTask.this.errMsg = paramAnonymousString;
          if (paramAnonymousJSONObject != null) {
            JsApiMMTask.this.DQD = paramAnonymousJSONObject.toString();
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
      ad.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInMainProcess fail.", new Object[0]);
      AppMethodBeat.o(78497);
    }
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(78498);
    bhO();
    if (this.DQB != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.DQD);
        this.DQB.a(this.errMsg, localJSONObject);
        AppMethodBeat.o(78498);
        return;
      }
      catch (Exception localException)
      {
        this.DQB.a(this.errMsg, null);
        ad.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInClientProcess fail.", new Object[0]);
      }
    }
    AppMethodBeat.o(78498);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(78499);
    this.kwS = paramParcel.readString();
    this.DQC = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.DQD = paramParcel.readString();
    AppMethodBeat.o(78499);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(78500);
    paramParcel.writeString(this.kwS);
    paramParcel.writeString(this.DQC);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeString(this.DQD);
    AppMethodBeat.o(78500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */