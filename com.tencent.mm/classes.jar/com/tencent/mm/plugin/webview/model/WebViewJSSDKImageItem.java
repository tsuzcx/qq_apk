package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKImageItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR;
  public boolean tUF;
  
  static
  {
    AppMethodBeat.i(79015);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(79015);
  }
  
  public WebViewJSSDKImageItem()
  {
    this.mediaType = 1;
  }
  
  protected WebViewJSSDKImageItem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(79014);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.tUF = bool;
      AppMethodBeat.o(79014);
      return;
      bool = false;
    }
  }
  
  public final void bC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(182695);
    super.bC(paramJSONObject);
    if (paramJSONObject != null) {
      this.tUF = paramJSONObject.optBoolean("isGif");
    }
    AppMethodBeat.o(182695);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject eUc()
  {
    AppMethodBeat.i(182696);
    JSONObject localJSONObject = super.eUc();
    try
    {
      localJSONObject.put("isGif", this.tUF);
      label21:
      AppMethodBeat.o(182696);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final WebViewJSSDKFileItem eUd()
  {
    AppMethodBeat.i(79012);
    this.dsN = ax.aIT(this.jXT);
    fwO();
    AppMethodBeat.o(79012);
    return this;
  }
  
  public final String eUf()
  {
    return "jpeg";
  }
  
  public final String fwN()
  {
    return "image";
  }
  
  public final void fwO()
  {
    AppMethodBeat.i(79011);
    if (!new k(this.jXT).exists())
    {
      ae.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
      AppMethodBeat.o(79011);
      return;
    }
    if (this.kKQ == null) {
      this.kKQ = ax.aIR(System.currentTimeMillis());
    }
    for (;;)
    {
      Bitmap localBitmap = h.d(this.jXT, 640, 640, false);
      if (localBitmap != null)
      {
        ae.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
        localBitmap = h.a(localBitmap, BackwardSupportUtil.ExifHelper.df(this.jXT));
        if (localBitmap == null) {}
      }
      try
      {
        h.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, this.kKQ, true);
        ae.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[] { this.kKQ });
        AppMethodBeat.o(79011);
        return;
        if (!this.kKQ.equals(this.jXT)) {
          continue;
        }
        ae.i("MicroMsg.WebViewJSSDkImageItem", "Thumb file is original file");
        AppMethodBeat.o(79011);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79013);
    super.writeToParcel(paramParcel, paramInt);
    if (this.tUF) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(79013);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem
 * JD-Core Version:    0.7.0.1
 */