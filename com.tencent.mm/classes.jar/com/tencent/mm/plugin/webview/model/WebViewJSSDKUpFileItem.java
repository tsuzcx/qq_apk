package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.util.ArrayList;
import java.util.List;

public class WebViewJSSDKUpFileItem
  extends WebViewJSSDKFileItem
{
  public static final Parcelable.Creator<WebViewJSSDKUpFileItem> CREATOR;
  public String EfF;
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
    localArrayList.add(this.EfF);
    localArrayList.add(paramd.field_fileId);
    localArrayList.add(paramd.field_aesKey);
    localArrayList.add(paramd.field_fileLength);
    Context localContext = ak.getContext();
    if (az.isWifi(localContext)) {
      localArrayList.add("1");
    }
    for (;;)
    {
      ae.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[] { Integer.valueOf(this.fileType), this.EfF, paramd.field_fileId });
      paramd = g.yxI;
      g.m(12018, localArrayList);
      paramd = this.jXT;
      if (!bu.isNullOrNil(paramd))
      {
        paramd = new k(paramd);
        if (paramd.exists()) {
          paramd.delete();
        }
      }
      AppMethodBeat.o(79018);
      return;
      if (az.is3G(localContext)) {
        localArrayList.add("4");
      } else if (az.is4G(localContext)) {
        localArrayList.add("5");
      } else if (az.is5G(localContext)) {
        localArrayList.add("6");
      } else if (az.is2G(localContext)) {
        localArrayList.add("3");
      } else if (az.isWap(localContext)) {
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
  
  public final WebViewJSSDKFileItem eUd()
  {
    AppMethodBeat.i(79017);
    this.dsN = ax.aIT(this.jXT);
    AppMethodBeat.o(79017);
    return this;
  }
  
  public final String eUf()
  {
    return "file";
  }
  
  public final String fwN()
  {
    return "nomal";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKUpFileItem
 * JD-Core Version:    0.7.0.1
 */