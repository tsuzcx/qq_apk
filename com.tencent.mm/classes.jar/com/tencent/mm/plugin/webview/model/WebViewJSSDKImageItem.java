package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJSSDKImageItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR;
  public boolean sNg;
  
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
      this.sNg = bool;
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
      this.sNg = paramJSONObject.optBoolean("isGif");
    }
    AppMethodBeat.o(182695);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject fcF()
  {
    AppMethodBeat.i(182696);
    JSONObject localJSONObject = super.fcF();
    try
    {
      localJSONObject.put("isGif", this.sNg);
      label21:
      AppMethodBeat.o(182696);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final WebViewJSSDKFileItem fcG()
  {
    AppMethodBeat.i(79012);
    this.dgl = aw.aBZ(this.jAH);
    fdb();
    AppMethodBeat.o(79012);
    return this;
  }
  
  public final String fcH()
  {
    return "jpeg";
  }
  
  public final String fda()
  {
    return "image";
  }
  
  public final void fdb()
  {
    AppMethodBeat.i(79011);
    if (!new e(this.jAH).exists())
    {
      ac.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
      AppMethodBeat.o(79011);
      return;
    }
    if (this.kmB == null) {
      this.kmB = aw.aBX(System.currentTimeMillis());
    }
    for (;;)
    {
      Bitmap localBitmap = f.e(this.jAH, 640, 640, false);
      if (localBitmap != null)
      {
        ac.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
        localBitmap = f.a(localBitmap, BackwardSupportUtil.ExifHelper.ce(this.jAH));
        if (localBitmap == null) {}
      }
      try
      {
        f.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, this.kmB, true);
        ac.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[] { this.kmB });
        AppMethodBeat.o(79011);
        return;
        if (!this.kmB.equals(this.jAH)) {
          continue;
        }
        ac.i("MicroMsg.WebViewJSSDkImageItem", "Thumb file is original file");
        AppMethodBeat.o(79011);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79013);
    super.writeToParcel(paramParcel, paramInt);
    if (this.sNg) {}
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