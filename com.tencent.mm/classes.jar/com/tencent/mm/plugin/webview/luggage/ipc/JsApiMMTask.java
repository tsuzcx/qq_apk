package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class JsApiMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiMMTask> CREATOR;
  public b.a PRM;
  public String PRN;
  public String PRO;
  public String errMsg;
  public String oAb;
  
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
    f(paramParcel);
    AppMethodBeat.o(78501);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(78497);
    try
    {
      ((br)Class.forName(this.PRN).newInstance()).a(MMApplicationContext.getContext(), this.oAb, new br.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78495);
          JsApiMMTask.this.errMsg = paramAnonymousString;
          if (paramAnonymousJSONObject != null) {
            JsApiMMTask.this.PRO = paramAnonymousJSONObject.toString();
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
      Log.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInMainProcess fail.", new Object[0]);
      AppMethodBeat.o(78497);
    }
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(78498);
    bPk();
    if (this.PRM != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.PRO);
        this.PRM.a(this.errMsg, localJSONObject);
        AppMethodBeat.o(78498);
        return;
      }
      catch (Exception localException)
      {
        this.PRM.a(this.errMsg, null);
        Log.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInClientProcess fail.", new Object[0]);
      }
    }
    AppMethodBeat.o(78498);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(78499);
    this.oAb = paramParcel.readString();
    this.PRN = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.PRO = paramParcel.readString();
    AppMethodBeat.o(78499);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(78500);
    paramParcel.writeString(this.oAb);
    paramParcel.writeString(this.PRN);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeString(this.PRO);
    AppMethodBeat.o(78500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */