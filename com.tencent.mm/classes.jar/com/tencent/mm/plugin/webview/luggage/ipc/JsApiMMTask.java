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
  public b.a IVw;
  public String IVx;
  public String IVy;
  public String errMsg;
  public String lEA;
  
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
  
  public final void bjj()
  {
    AppMethodBeat.i(78497);
    try
    {
      ((br)Class.forName(this.IVx).newInstance()).a(MMApplicationContext.getContext(), this.lEA, new br.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78495);
          JsApiMMTask.this.errMsg = paramAnonymousString;
          if (paramAnonymousJSONObject != null) {
            JsApiMMTask.this.IVy = paramAnonymousJSONObject.toString();
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
  
  public final void bjk()
  {
    AppMethodBeat.i(78498);
    bDK();
    if (this.IVw != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.IVy);
        this.IVw.c(this.errMsg, localJSONObject);
        AppMethodBeat.o(78498);
        return;
      }
      catch (Exception localException)
      {
        this.IVw.c(this.errMsg, null);
        Log.printErrStackTrace("MicroMsg.JsApiMMTask", localException, "runInClientProcess fail.", new Object[0]);
      }
    }
    AppMethodBeat.o(78498);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(78499);
    this.lEA = paramParcel.readString();
    this.IVx = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.IVy = paramParcel.readString();
    AppMethodBeat.o(78499);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(78500);
    paramParcel.writeString(this.lEA);
    paramParcel.writeString(this.IVx);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeString(this.IVy);
    AppMethodBeat.o(78500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */