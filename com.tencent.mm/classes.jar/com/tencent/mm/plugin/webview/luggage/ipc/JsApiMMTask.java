package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class JsApiMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiMMTask> CREATOR = new JsApiMMTask.2();
  public String aox;
  public String giZ;
  public a.a rdg;
  public String rdh;
  public String rdi;
  
  public JsApiMMTask() {}
  
  private JsApiMMTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    try
    {
      ((aw)Class.forName(this.rdh).newInstance()).a(ae.getContext(), this.giZ, new JsApiMMTask.1(this));
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void Zv()
  {
    ahD();
    if (this.rdg != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.rdi);
      this.rdg.a(this.aox, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      this.rdg.a(this.aox, null);
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.giZ = paramParcel.readString();
    this.rdh = paramParcel.readString();
    this.aox = paramParcel.readString();
    this.rdi = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.giZ);
    paramParcel.writeString(this.rdh);
    paramParcel.writeString(this.aox);
    paramParcel.writeString(this.rdi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask
 * JD-Core Version:    0.7.0.1
 */