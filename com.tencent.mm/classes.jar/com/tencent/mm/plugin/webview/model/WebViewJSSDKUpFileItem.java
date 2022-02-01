package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public class WebViewJSSDKUpFileItem
  extends WebViewJSSDKFileItem
{
  public static final Parcelable.Creator<WebViewJSSDKUpFileItem> CREATOR;
  public String ASo;
  public int fileType = -1;
  
  static
  {
    AppMethodBeat.i(79019);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(79019);
  }
  
  public WebViewJSSDKUpFileItem()
  {
    this.mediaType = 3;
  }
  
  private WebViewJSSDKUpFileItem(byte paramByte) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(79018);
    super.e(paramd);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.fileType);
    localArrayList.add(this.ASo);
    localArrayList.add(paramd.field_fileId);
    localArrayList.add(paramd.field_aesKey);
    localArrayList.add(paramd.field_fileLength);
    Context localContext = aj.getContext();
    if (ay.isWifi(localContext)) {
      localArrayList.add("1");
    }
    for (;;)
    {
      ad.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[] { Integer.valueOf(this.fileType), this.ASo, paramd.field_fileId });
      paramd = h.vKh;
      h.h(12018, localArrayList);
      paramd = this.jau;
      if (!bt.isNullOrNil(paramd))
      {
        paramd = new e(paramd);
        if (paramd.exists()) {
          paramd.delete();
        }
      }
      AppMethodBeat.o(79018);
      return;
      if (ay.is3G(localContext)) {
        localArrayList.add("4");
      } else if (ay.is4G(localContext)) {
        localArrayList.add("5");
      } else if (ay.is2G(localContext)) {
        localArrayList.add("3");
      } else if (ay.isWap(localContext)) {
        localArrayList.add("2");
      } else {
        localArrayList.add("0");
      }
    }
  }
  
  public final WebViewJSSDKFileItem fZw()
  {
    AppMethodBeat.i(79017);
    this.diQ = aw.awH(this.jau);
    AppMethodBeat.o(79017);
    return this;
  }
  
  public final String fZx()
  {
    return "file";
  }
  
  public final String fZy()
  {
    return "nomal";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKUpFileItem
 * JD-Core Version:    0.7.0.1
 */