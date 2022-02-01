package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public class WebViewJSSDKUpFileItem
  extends WebViewJSSDKFileItem
{
  public static final Parcelable.Creator<WebViewJSSDKUpFileItem> CREATOR;
  public String WET;
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
  
  public final void d(d paramd)
  {
    AppMethodBeat.i(79018);
    super.d(paramd);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.fileType);
    localArrayList.add(this.WET);
    localArrayList.add(paramd.field_fileId);
    localArrayList.add(paramd.field_aesKey);
    localArrayList.add(paramd.field_fileLength);
    Context localContext = MMApplicationContext.getContext();
    if (NetStatusUtil.isWifi(localContext)) {
      localArrayList.add("1");
    }
    for (;;)
    {
      Log.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[] { Integer.valueOf(this.fileType), this.WET, paramd.field_fileId });
      paramd = h.OAn;
      h.P(12018, localArrayList);
      paramd = this.qUK;
      if (!Util.isNullOrNil(paramd))
      {
        paramd = new u(paramd);
        if (paramd.jKS()) {
          paramd.diJ();
        }
      }
      AppMethodBeat.o(79018);
      return;
      if (NetStatusUtil.is3G(localContext)) {
        localArrayList.add("4");
      } else if (NetStatusUtil.is4G(localContext)) {
        localArrayList.add("5");
      } else if (NetStatusUtil.is5G(localContext)) {
        localArrayList.add("6");
      } else if (NetStatusUtil.is2G(localContext)) {
        localArrayList.add("3");
      } else if (NetStatusUtil.isWap(localContext)) {
        localArrayList.add("2");
      } else {
        localArrayList.add("0");
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getFileType()
  {
    return "nomal";
  }
  
  public final WebViewJSSDKFileItem kLS()
  {
    AppMethodBeat.i(79017);
    this.hHB = az.bkB(this.qUK);
    AppMethodBeat.o(79017);
    return this;
  }
  
  public final String kLT()
  {
    return "file";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKUpFileItem
 * JD-Core Version:    0.7.0.1
 */