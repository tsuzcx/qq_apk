package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKImageItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR;
  public boolean tJO;
  
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
      this.tJO = bool;
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
      this.tJO = paramJSONObject.optBoolean("isGif");
    }
    AppMethodBeat.o(182695);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject ftr()
  {
    AppMethodBeat.i(182696);
    JSONObject localJSONObject = super.ftr();
    try
    {
      localJSONObject.put("isGif", this.tJO);
      label21:
      AppMethodBeat.o(182696);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final WebViewJSSDKFileItem fts()
  {
    AppMethodBeat.i(79012);
    this.drH = ax.aHA(this.jUC);
    ftv();
    AppMethodBeat.o(79012);
    return this;
  }
  
  public final String ftt()
  {
    return "jpeg";
  }
  
  public final String ftu()
  {
    return "image";
  }
  
  public final void ftv()
  {
    AppMethodBeat.i(79011);
    if (!new e(this.jUC).exists())
    {
      ad.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
      AppMethodBeat.o(79011);
      return;
    }
    if (this.kHB == null) {
      this.kHB = ax.aHy(System.currentTimeMillis());
    }
    for (;;)
    {
      Bitmap localBitmap = g.d(this.jUC, 640, 640, false);
      if (localBitmap != null)
      {
        ad.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
        localBitmap = g.a(localBitmap, BackwardSupportUtil.ExifHelper.cY(this.jUC));
        if (localBitmap == null) {}
      }
      try
      {
        g.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, this.kHB, true);
        ad.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[] { this.kHB });
        AppMethodBeat.o(79011);
        return;
        if (!this.kHB.equals(this.jUC)) {
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
    if (this.tJO) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(79013);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem
 * JD-Core Version:    0.7.0.1
 */