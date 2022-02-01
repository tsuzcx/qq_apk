package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKImageItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR;
  public boolean rEo;
  
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
      this.rEo = bool;
      AppMethodBeat.o(79014);
      return;
      bool = false;
    }
  }
  
  public final void bt(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(182695);
    super.bt(paramJSONObject);
    if (paramJSONObject != null) {
      this.rEo = paramJSONObject.optBoolean("isGif");
    }
    AppMethodBeat.o(182695);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject fZv()
  {
    AppMethodBeat.i(182696);
    JSONObject localJSONObject = super.fZv();
    try
    {
      localJSONObject.put("isGif", this.rEo);
      label21:
      AppMethodBeat.o(182696);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final WebViewJSSDKFileItem fZw()
  {
    AppMethodBeat.i(79012);
    this.diQ = aw.awH(this.jau);
    fZz();
    AppMethodBeat.o(79012);
    return this;
  }
  
  public final String fZx()
  {
    return "jpeg";
  }
  
  public final String fZy()
  {
    return "image";
  }
  
  public final void fZz()
  {
    AppMethodBeat.i(79011);
    if (!new e(this.jau).exists())
    {
      ad.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
      AppMethodBeat.o(79011);
      return;
    }
    if (this.jMa == null) {
      this.jMa = aw.awF(System.currentTimeMillis());
    }
    for (;;)
    {
      Bitmap localBitmap = f.e(this.jau, 640, 640, false);
      if (localBitmap != null)
      {
        ad.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
        localBitmap = f.a(localBitmap, BackwardSupportUtil.ExifHelper.co(this.jau));
        if (localBitmap == null) {}
      }
      try
      {
        f.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, this.jMa, true);
        ad.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[] { this.jMa });
        AppMethodBeat.o(79011);
        return;
        if (!this.jMa.equals(this.jau)) {
          continue;
        }
        ad.i("MicroMsg.WebViewJSSDkImageItem", "Thumb file is original file");
        AppMethodBeat.o(79011);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79013);
    super.writeToParcel(paramParcel, paramInt);
    if (this.rEo) {}
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