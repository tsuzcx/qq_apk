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
import com.tencent.mm.vfs.q;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKImageItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR;
  public boolean BYl;
  
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
      this.BYl = bool;
      AppMethodBeat.o(79014);
      return;
      bool = false;
    }
  }
  
  public final void cm(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(182695);
    super.cm(paramJSONObject);
    if (paramJSONObject != null) {
      this.BYl = paramJSONObject.optBoolean("isGif");
    }
    AppMethodBeat.o(182695);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject gVK()
  {
    AppMethodBeat.i(182696);
    JSONObject localJSONObject = super.gVK();
    try
    {
      localJSONObject.put("isGif", this.BYl);
      label21:
      AppMethodBeat.o(182696);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final WebViewJSSDKFileItem gVL()
  {
    AppMethodBeat.i(79012);
    this.fCM = az.bkS(this.nVa);
    gVO();
    AppMethodBeat.o(79012);
    return this;
  }
  
  public final String gVM()
  {
    return "jpeg";
  }
  
  public final void gVO()
  {
    AppMethodBeat.i(79011);
    if (!new q(this.nVa).ifE())
    {
      Log.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
      AppMethodBeat.o(79011);
      return;
    }
    if (this.oLR == null) {
      this.oLR = az.getFilePath(System.currentTimeMillis());
    }
    for (;;)
    {
      Bitmap localBitmap = BitmapUtil.extractThumbNail(this.nVa, 640, 640, false);
      if (localBitmap != null)
      {
        Log.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
        localBitmap = BitmapUtil.rotate(localBitmap, BackwardSupportUtil.ExifHelper.getExifOrientation(this.nVa));
        if (localBitmap == null) {}
      }
      try
      {
        BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, this.oLR, true);
        Log.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[] { this.oLR });
        AppMethodBeat.o(79011);
        return;
        if (!this.oLR.equals(this.nVa)) {
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
  
  public final String getFileType()
  {
    return "image";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79013);
    super.writeToParcel(paramParcel, paramInt);
    if (this.BYl) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(79013);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem
 * JD-Core Version:    0.7.0.1
 */