package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.al.c;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class WebViewJSSDKFileItem
  implements Parcelable
{
  public String appId;
  public String cBO;
  public String ctV;
  public int cth;
  public String fileName;
  public String hII;
  public int height;
  public String hgj;
  public String hgk;
  public boolean hgm;
  public boolean hgn = true;
  public boolean hgo = true;
  public int size;
  public WebViewJSSDKFileItem.a uWl;
  public int width;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.ctV = paramParcel.readString();
    this.hII = paramParcel.readString();
    this.hgj = paramParcel.readString();
    this.cth = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
  }
  
  public static WebViewJSSDKFileItem H(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.keN = paramString1;
    localWebViewJSSDKUpFileItem.hgj = paramString2;
    localWebViewJSSDKUpFileItem.dca();
    localWebViewJSSDKUpFileItem.cBO = c.a("jsupfile", bo.aoy(), localWebViewJSSDKUpFileItem.ctV, localWebViewJSSDKUpFileItem.ctV);
    ab.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.ctV });
    return localWebViewJSSDKUpFileItem;
  }
  
  public static WebViewJSSDKFileItem ahf(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.hgj = paramString;
    localWebViewJSSDKImageItem.dca();
    localWebViewJSSDKImageItem.cBO = c.a("jsupimg", bo.aoy(), localWebViewJSSDKImageItem.ctV, localWebViewJSSDKImageItem.ctV);
    return localWebViewJSSDKImageItem;
  }
  
  public static WebViewJSSDKFileItem ahg(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.dca();
    localWebViewJSSDKVoiceItem.cBO = c.a("jsupvoice", bo.aoy(), localWebViewJSSDKVoiceItem.ctV, localWebViewJSSDKVoiceItem.ctV);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem ahu(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.hgj = paramString;
    localWebViewJSSDKVideoItem.dca();
    localWebViewJSSDKVideoItem.cBO = c.a("jsvideofile", bo.aoy(), localWebViewJSSDKVideoItem.ctV, localWebViewJSSDKVideoItem.ctV);
    ab.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.ctV, localWebViewJSSDKVideoItem.cBO });
    return localWebViewJSSDKVideoItem;
  }
  
  public static WebViewJSSDKFileItem hr(String paramString1, String paramString2)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.hgj = paramString1;
    localWebViewJSSDKImageItem.hII = paramString2;
    localWebViewJSSDKImageItem.dca();
    localWebViewJSSDKImageItem.cBO = c.a("jsupimg", bo.aoy(), localWebViewJSSDKImageItem.ctV, localWebViewJSSDKImageItem.ctV);
    return localWebViewJSSDKImageItem;
  }
  
  public void c(d paramd)
  {
    if (this.uWl == null) {
      this.uWl = new WebViewJSSDKFileItem.a();
    }
    if (paramd == null)
    {
      ab.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.uWl.field_aesKey = paramd.field_aesKey;
    this.uWl.field_fileId = paramd.field_fileId;
    this.uWl.field_fileUrl = paramd.field_fileUrl;
    this.uWl.field_fileLength = paramd.field_fileLength;
  }
  
  public abstract WebViewJSSDKFileItem dca();
  
  public abstract String dyR();
  
  public abstract String dzk();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.ctV);
    paramParcel.writeString(this.hII);
    paramParcel.writeString(this.hgj);
    paramParcel.writeInt(this.cth);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
 * JD-Core Version:    0.7.0.1
 */