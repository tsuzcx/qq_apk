package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public class WebViewJSSDKUpFileItem
  extends WebViewJSSDKFileItem
{
  public static final Parcelable.Creator<WebViewJSSDKUpFileItem> CREATOR;
  public String CkB;
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
    localArrayList.add(this.CkB);
    localArrayList.add(paramd.field_fileId);
    localArrayList.add(paramd.field_aesKey);
    localArrayList.add(paramd.field_fileLength);
    Context localContext = ai.getContext();
    if (ax.isWifi(localContext)) {
      localArrayList.add("1");
    }
    for (;;)
    {
      ac.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[] { Integer.valueOf(this.fileType), this.CkB, paramd.field_fileId });
      paramd = h.wUl;
      h.k(12018, localArrayList);
      paramd = this.jAH;
      if (!bs.isNullOrNil(paramd))
      {
        paramd = new e(paramd);
        if (paramd.exists()) {
          paramd.delete();
        }
      }
      AppMethodBeat.o(79018);
      return;
      if (ax.is3G(localContext)) {
        localArrayList.add("4");
      } else if (ax.is4G(localContext)) {
        localArrayList.add("5");
      } else if (ax.is2G(localContext)) {
        localArrayList.add("3");
      } else if (ax.isWap(localContext)) {
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
  
  public final WebViewJSSDKFileItem fcG()
  {
    AppMethodBeat.i(79017);
    this.dgl = aw.aBZ(this.jAH);
    AppMethodBeat.o(79017);
    return this;
  }
  
  public final String fcH()
  {
    return "file";
  }
  
  public final String fda()
  {
    return "nomal";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKUpFileItem
 * JD-Core Version:    0.7.0.1
 */