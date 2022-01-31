package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public class WebViewJSSDKImageItem
  extends WebViewJSSDKFileItem
  implements Parcelable
{
  public static final Parcelable.Creator<WebViewJSSDKImageItem> CREATOR = new WebViewJSSDKImageItem.1();
  
  public WebViewJSSDKImageItem()
  {
    this.bLN = 1;
  }
  
  protected WebViewJSSDKImageItem(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final WebViewJSSDKFileItem cbT()
  {
    this.bMB = am.So(this.fMZ);
    cbX();
    return this;
  }
  
  public final String cbU()
  {
    return "jpeg";
  }
  
  public final String cbV()
  {
    return "image";
  }
  
  public final void cbX()
  {
    if (!new File(this.fMZ).exists())
    {
      y.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
      return;
    }
    this.goL = am.Sm(System.currentTimeMillis());
    Bitmap localBitmap = c.a(this.fMZ, 640, 640, false, null, 0);
    if (localBitmap != null)
    {
      y.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
      localBitmap = c.b(localBitmap, BackwardSupportUtil.ExifHelper.YS(this.fMZ));
      if (localBitmap == null) {}
    }
    try
    {
      c.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, this.goL, true);
      y.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[] { this.goL });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem
 * JD-Core Version:    0.7.0.1
 */