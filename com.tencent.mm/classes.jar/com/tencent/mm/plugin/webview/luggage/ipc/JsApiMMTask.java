package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiMMTask> CREATOR;
  public b.a WIj;
  public String WIk;
  public String WIl;
  public String errMsg;
  public String eventName;
  public String rDU;
  
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
    h(paramParcel);
    AppMethodBeat.o(78501);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(78497);
    try
    {
      ((bv)Class.forName(this.WIk).newInstance()).a(MMApplicationContext.getContext(), this.rDU, new bv.a()
      {
        public final void b(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(295980);
          JsApiMMTask.this.eventName = paramAnonymousString;
          JsApiMMTask.this.WIl = paramAnonymousJSONObject.toString();
          JsApiMMTask.b(JsApiMMTask.this);
          AppMethodBeat.o(295980);
        }
        
        public final void j(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78495);
          JsApiMMTask.this.errMsg = paramAnonymousString;
          if (paramAnonymousJSONObject != null) {
            JsApiMMTask.this.WIl = paramAnonymousJSONObject.toString();
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
  
  public final void bQr()
  {
    AppMethodBeat.i(78498);
    cpx();
    Object localObject;
    if (this.WIj != null) {
      for (localObject = null;; localObject = localJSONObject)
      {
        try
        {
          if (!TextUtils.isEmpty(this.WIl)) {
            break label66;
          }
          localJSONObject = new JSONObject();
          localObject = localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            JSONObject localJSONObject;
            label66:
            Log.printErrStackTrace("MicroMsg.JsApiMMTask", localJSONException, "runInClientProcess fail.", new Object[0]);
          }
          if (!(this.WIj.eiY instanceof a)) {
            break label135;
          }
          ((a)this.WIj.eiY).aod().b(this.eventName, localObject);
        }
        if (!TextUtils.isEmpty(this.eventName)) {
          break;
        }
        this.WIj.a(this.errMsg, localObject);
        AppMethodBeat.o(78498);
        return;
        localJSONObject = new JSONObject(this.WIl);
      }
    }
    label135:
    AppMethodBeat.o(78498);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(78499);
    this.rDU = paramParcel.readString();
    this.WIk = paramParcel.readString();
    this.errMsg = paramParcel.readString();
    this.WIl = paramParcel.readString();
    this.eventName = paramParcel.readString();
    AppMethodBeat.o(78499);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(78500);
    paramParcel.writeString(this.rDU);
    paramParcel.writeString(this.WIk);
    paramParcel.writeString(this.errMsg);
    paramParcel.writeString(this.WIl);
    paramParcel.writeString(this.eventName);
    AppMethodBeat.o(78500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */