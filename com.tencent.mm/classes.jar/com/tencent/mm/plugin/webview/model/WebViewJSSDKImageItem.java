package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;

public class WebViewJSSDKImageItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR;
  public boolean uXp;
  
  static
  {
    AppMethodBeat.i(6722);
    CREATOR = new WebViewJSSDKImageItem.1();
    AppMethodBeat.o(6722);
  }
  
  public WebViewJSSDKImageItem()
  {
    this.cth = 1;
  }
  
  protected WebViewJSSDKImageItem(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(153139);
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.uXp = bool;
      AppMethodBeat.o(153139);
      return;
      bool = false;
    }
  }
  
  public final WebViewJSSDKFileItem dca()
  {
    AppMethodBeat.i(6720);
    this.ctV = ar.ahn(this.hgj);
    dzl();
    AppMethodBeat.o(6720);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String dyR()
  {
    return "jpeg";
  }
  
  public final String dzk()
  {
    return "image";
  }
  
  public final void dzl()
  {
    AppMethodBeat.i(6719);
    if (!new File(this.hgj).exists())
    {
      ab.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
      AppMethodBeat.o(6719);
      return;
    }
    if (this.hII == null) {
      this.hII = ar.ahk(System.currentTimeMillis());
    }
    for (;;)
    {
      Bitmap localBitmap = d.d(this.hgj, 640, 640, false);
      if (localBitmap != null)
      {
        ab.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
        localBitmap = d.b(localBitmap, BackwardSupportUtil.ExifHelper.bY(this.hgj));
        if (localBitmap == null) {}
      }
      try
      {
        d.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, this.hII, true);
        ab.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[] { this.hII });
        AppMethodBeat.o(6719);
        return;
        if (!this.hII.equals(this.hgj)) {
          continue;
        }
        ab.i("MicroMsg.WebViewJSSDkImageItem", "Thumb file is original file");
        AppMethodBeat.o(6719);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(6721);
    super.writeToParcel(paramParcel, paramInt);
    if (this.uXp) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(6721);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem
 * JD-Core Version:    0.7.0.1
 */