package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKVideoItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKVideoItem> CREATOR;
  public int duration;
  
  static
  {
    AppMethodBeat.i(79024);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(79024);
  }
  
  public WebViewJSSDKVideoItem()
  {
    this.mediaType = 4;
  }
  
  protected WebViewJSSDKVideoItem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(79022);
    this.duration = paramParcel.readInt();
    AppMethodBeat.o(79022);
  }
  
  public final void bC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(182697);
    super.bC(paramJSONObject);
    if (paramJSONObject != null) {
      this.duration = paramJSONObject.optInt("duration");
    }
    AppMethodBeat.o(182697);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject ftr()
  {
    AppMethodBeat.i(182698);
    JSONObject localJSONObject = super.ftr();
    try
    {
      localJSONObject.put("duration", this.duration);
      label21:
      AppMethodBeat.o(182698);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final WebViewJSSDKFileItem fts()
  {
    AppMethodBeat.i(79021);
    this.drH = ax.aHA(this.jUC);
    AppMethodBeat.o(79021);
    return this;
  }
  
  public final String ftt()
  {
    return "mp4";
  }
  
  public final String ftu()
  {
    return "video";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79023);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.duration);
    AppMethodBeat.o(79023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem
 * JD-Core Version:    0.7.0.1
 */