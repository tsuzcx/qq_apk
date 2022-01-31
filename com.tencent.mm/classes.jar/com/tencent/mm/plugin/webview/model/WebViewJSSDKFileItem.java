package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.ak.c;
import com.tencent.mm.j.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class WebViewJSSDKFileItem
  implements Parcelable
{
  public String appId;
  public int bLN;
  public String bMB;
  public String bUi;
  public String fMZ;
  public String fNa;
  public boolean fNc;
  public boolean fNd = true;
  public boolean fNe = true;
  public String fileName;
  public String goL;
  public a rfV;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.bMB = paramParcel.readString();
    this.goL = paramParcel.readString();
    this.fMZ = paramParcel.readString();
    this.bLN = paramParcel.readInt();
  }
  
  public static WebViewJSSDKFileItem Si(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.fMZ = paramString;
    localWebViewJSSDKImageItem.cbT();
    localWebViewJSSDKImageItem.bUi = c.a("jsupimg", bk.UY(), localWebViewJSSDKImageItem.bMB, localWebViewJSSDKImageItem.bMB);
    return localWebViewJSSDKImageItem;
  }
  
  public static WebViewJSSDKFileItem Sj(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.cbT();
    localWebViewJSSDKVoiceItem.bUi = c.a("jsupvoice", bk.UY(), localWebViewJSSDKVoiceItem.bMB, localWebViewJSSDKVoiceItem.bMB);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem Sk(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.fMZ = paramString;
    localWebViewJSSDKVideoItem.cbT();
    localWebViewJSSDKVideoItem.bUi = c.a("jsvideofile", bk.UY(), localWebViewJSSDKVideoItem.bMB, localWebViewJSSDKVideoItem.bMB);
    y.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.bMB, localWebViewJSSDKVideoItem.bUi });
    return localWebViewJSSDKVideoItem;
  }
  
  public static WebViewJSSDKFileItem y(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.rfY = paramString1;
    localWebViewJSSDKUpFileItem.fMZ = paramString2;
    localWebViewJSSDKUpFileItem.cbT();
    localWebViewJSSDKUpFileItem.bUi = c.a("jsupfile", bk.UY(), localWebViewJSSDKUpFileItem.bMB, localWebViewJSSDKUpFileItem.bMB);
    y.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.bMB });
    return localWebViewJSSDKUpFileItem;
  }
  
  public void c(d paramd)
  {
    if (this.rfV == null) {
      this.rfV = new a();
    }
    if (paramd == null)
    {
      y.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.rfV.field_aesKey = paramd.field_aesKey;
    this.rfV.field_fileId = paramd.field_fileId;
    this.rfV.field_fileUrl = paramd.field_fileUrl;
    this.rfV.field_fileLength = paramd.field_fileLength;
  }
  
  public abstract WebViewJSSDKFileItem cbT();
  
  public abstract String cbU();
  
  public abstract String cbV();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.bMB);
    paramParcel.writeString(this.goL);
    paramParcel.writeString(this.fMZ);
    paramParcel.writeInt(this.bLN);
  }
  
  public static final class a
  {
    public String field_aesKey;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
 * JD-Core Version:    0.7.0.1
 */