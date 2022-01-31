package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.j.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WebViewJSSDKUpFileItem
  extends WebViewJSSDKFileItem
{
  public static final Parcelable.Creator<WebViewJSSDKUpFileItem> CREATOR = new WebViewJSSDKUpFileItem.1();
  public int fileType = -1;
  public String rfY;
  
  public WebViewJSSDKUpFileItem()
  {
    this.bLN = 3;
  }
  
  private WebViewJSSDKUpFileItem(byte paramByte) {}
  
  public final void c(d paramd)
  {
    super.c(paramd);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.fileType);
    localArrayList.add(this.rfY);
    localArrayList.add(paramd.field_fileId);
    localArrayList.add(paramd.field_aesKey);
    localArrayList.add(paramd.field_fileLength);
    Context localContext = ae.getContext();
    if (aq.isWifi(localContext)) {
      localArrayList.add("1");
    }
    for (;;)
    {
      y.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[] { Integer.valueOf(this.fileType), this.rfY, paramd.field_fileId });
      paramd = h.nFQ;
      h.f(12018, localArrayList);
      paramd = this.fMZ;
      if (!bk.bl(paramd))
      {
        paramd = new File(paramd);
        if (paramd.exists()) {
          paramd.delete();
        }
      }
      return;
      if (aq.is3G(localContext)) {
        localArrayList.add("4");
      } else if (aq.is4G(localContext)) {
        localArrayList.add("5");
      } else if (aq.is2G(localContext)) {
        localArrayList.add("3");
      } else if (aq.isWap(localContext)) {
        localArrayList.add("2");
      } else {
        localArrayList.add("0");
      }
    }
  }
  
  public final WebViewJSSDKFileItem cbT()
  {
    this.bMB = am.So(this.fMZ);
    return this;
  }
  
  public final String cbU()
  {
    return "file";
  }
  
  public final String cbV()
  {
    return "nomal";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKUpFileItem
 * JD-Core Version:    0.7.0.1
 */