package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKImageItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR;
  public boolean xlR;
  
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
      this.xlR = bool;
      AppMethodBeat.o(79014);
      return;
      bool = false;
    }
  }
  
  public final void cb(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(182695);
    super.cb(paramJSONObject);
    if (paramJSONObject != null) {
      this.xlR = paramJSONObject.optBoolean("isGif");
    }
    AppMethodBeat.o(182695);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject gWR()
  {
    AppMethodBeat.i(182696);
    JSONObject localJSONObject = super.gWR();
    try
    {
      localJSONObject.put("isGif", this.xlR);
      label21:
      AppMethodBeat.o(182696);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final WebViewJSSDKFileItem gWS()
  {
    AppMethodBeat.i(79012);
    this.dJX = ay.aYY(this.laR);
    hdZ();
    AppMethodBeat.o(79012);
    return this;
  }
  
  public final String getFileType()
  {
    return "image";
  }
  
  public final String hdY()
  {
    return "jpeg";
  }
  
  public final void hdZ()
  {
    AppMethodBeat.i(79011);
    if (!new o(this.laR).exists())
    {
      Log.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
      AppMethodBeat.o(79011);
      return;
    }
    if (this.lPx == null) {
      this.lPx = ay.aYW(System.currentTimeMillis());
    }
    for (;;)
    {
      Bitmap localBitmap = BitmapUtil.extractThumbNail(this.laR, 640, 640, false);
      if (localBitmap != null)
      {
        Log.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
        localBitmap = BitmapUtil.rotate(localBitmap, BackwardSupportUtil.ExifHelper.getExifOrientation(this.laR));
        if (localBitmap == null) {}
      }
      try
      {
        BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, this.lPx, true);
        Log.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[] { this.lPx });
        AppMethodBeat.o(79011);
        return;
        if (!this.lPx.equals(this.laR)) {
          continue;
        }
        Log.i("MicroMsg.WebViewJSSDkImageItem", "Thumb file is original file");
        AppMethodBeat.o(79011);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79013);
    super.writeToParcel(paramParcel, paramInt);
    if (this.xlR) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(79013);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem
 * JD-Core Version:    0.7.0.1
 */