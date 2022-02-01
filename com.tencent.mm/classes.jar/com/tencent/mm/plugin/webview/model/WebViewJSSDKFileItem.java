package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.c;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class WebViewJSSDKFileItem
  implements Parcelable
{
  public a OdX;
  public String appId;
  public String drH;
  public String fileName;
  public int height;
  public Bundle ime = new Bundle();
  public String jUC;
  public String jUD;
  public boolean jUF;
  public boolean jUG = true;
  public boolean jUH = true;
  public String kHB;
  public String mediaId;
  public int mediaType;
  public int size;
  public int width;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.drH = paramParcel.readString();
    this.kHB = paramParcel.readString();
    this.jUC = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.ime = paramParcel.readBundle();
  }
  
  public static WebViewJSSDKFileItem I(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.DNG = paramString1;
    localWebViewJSSDKUpFileItem.jUC = paramString2;
    localWebViewJSSDKUpFileItem.fts();
    localWebViewJSSDKUpFileItem.mediaId = c.a("jsupfile", bt.flT(), localWebViewJSSDKUpFileItem.drH, localWebViewJSSDKUpFileItem.drH);
    ad.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.drH });
    return localWebViewJSSDKUpFileItem;
  }
  
  public static WebViewJSSDKFileItem aHM(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.fts();
    localWebViewJSSDKVoiceItem.mediaId = c.a("jsupvoice", bt.flT(), localWebViewJSSDKVoiceItem.drH, localWebViewJSSDKVoiceItem.drH);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem aHN(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.jUC = paramString;
    localWebViewJSSDKVideoItem.fts();
    localWebViewJSSDKVideoItem.mediaId = c.a("jsvideofile", bt.flT(), localWebViewJSSDKVideoItem.drH, localWebViewJSSDKVideoItem.drH);
    ad.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.drH, localWebViewJSSDKVideoItem.mediaId });
    return localWebViewJSSDKVideoItem;
  }
  
  public static WebViewJSSDKFileItem aHr(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.jUC = paramString;
    localWebViewJSSDKImageItem.fts();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", bt.flT(), localWebViewJSSDKImageItem.drH, localWebViewJSSDKImageItem.drH);
    return localWebViewJSSDKImageItem;
  }
  
  private static String aj(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject.put(str, paramBundle.get(str));
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramBundle) {}
  }
  
  private static Bundle avE(String paramString)
  {
    localBundle = new Bundle();
    if ((paramString == null) || (paramString.isEmpty())) {
      return localBundle;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramString.get(str);
        if ((localObject instanceof String)) {
          localBundle.putString(str, (String)localObject);
        } else if ((localObject instanceof Integer)) {
          localBundle.putInt(str, ((Integer)localObject).intValue());
        } else if ((localObject instanceof Long)) {
          localBundle.putLong(str, ((Long)localObject).longValue());
        } else if ((localObject instanceof Boolean)) {
          localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
        } else if ((localObject instanceof Byte)) {
          localBundle.putByte(str, ((Byte)localObject).byteValue());
        } else if ((localObject instanceof Character)) {
          localBundle.putChar(str, ((Character)localObject).charValue());
        } else if ((localObject instanceof Float)) {
          localBundle.putFloat(str, ((Float)localObject).floatValue());
        } else if ((localObject instanceof Short)) {
          localBundle.putShort(str, ((Short)localObject).shortValue());
        } else if ((localObject instanceof Double)) {
          localBundle.putDouble(str, ((Double)localObject).doubleValue());
        } else {
          localBundle.putString(str, localObject.toString());
        }
      }
      return localBundle;
    }
    catch (JSONException paramString) {}
  }
  
  public static WebViewJSSDKFileItem hU(String paramString1, String paramString2)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.jUC = paramString1;
    localWebViewJSSDKImageItem.kHB = paramString2;
    localWebViewJSSDKImageItem.fts();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", bt.flT(), localWebViewJSSDKImageItem.drH, localWebViewJSSDKImageItem.drH);
    return localWebViewJSSDKImageItem;
  }
  
  protected void bC(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.appId = paramJSONObject.optString("appId");
    this.drH = paramJSONObject.optString("localId");
    this.kHB = paramJSONObject.optString("thumbFilePath");
    this.jUC = paramJSONObject.optString("origFilePath");
    this.jUD = paramJSONObject.optString("serverId");
    this.mediaId = paramJSONObject.optString("mediaId");
    this.fileName = paramJSONObject.optString("fileName");
    this.mediaType = paramJSONObject.optInt("mediaType");
    this.size = paramJSONObject.optInt("size");
    this.width = paramJSONObject.optInt("width");
    this.height = paramJSONObject.optInt("height");
    this.OdX = a.aHs(paramJSONObject.optString("cdnInfo"));
    this.jUF = paramJSONObject.optBoolean("upload");
    this.jUG = paramJSONObject.optBoolean("needCompress", true);
    this.jUH = paramJSONObject.optBoolean("needUploadCDNInfo", true);
    this.ime = avE(paramJSONObject.optString("extra"));
  }
  
  public void d(d paramd)
  {
    if (this.OdX == null) {
      this.OdX = new a();
    }
    if (paramd == null)
    {
      ad.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.OdX.field_aesKey = paramd.field_aesKey;
    this.OdX.field_fileId = paramd.field_fileId;
    this.OdX.field_fileUrl = paramd.field_fileUrl;
    this.OdX.field_fileLength = ((int)paramd.field_fileLength);
  }
  
  protected JSONObject ftr()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("localId", this.drH);
      localJSONObject.put("thumbFilePath", this.kHB);
      localJSONObject.put("origFilePath", this.jUC);
      localJSONObject.put("serverId", this.jUD);
      localJSONObject.put("mediaId", this.mediaId);
      localJSONObject.put("fileName", this.fileName);
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("size", this.size);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      if (this.OdX != null) {
        localJSONObject.put("cdnInfo", this.OdX.toJson());
      }
      localJSONObject.put("upload", this.jUF);
      localJSONObject.put("needCompress", this.jUG);
      localJSONObject.put("needUploadCDNInfo", this.jUH);
      localJSONObject.put("extra", aj(this.ime));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public abstract WebViewJSSDKFileItem fts();
  
  public abstract String ftt();
  
  public abstract String ftu();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.drH);
    paramParcel.writeString(this.kHB);
    paramParcel.writeString(this.jUC);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeBundle(this.ime);
  }
  
  public static final class a
  {
    public String field_aesKey;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    
    public static a aHs(String paramString)
    {
      AppMethodBeat.i(182694);
      a locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.field_aesKey = paramString.optString("aesKey");
        locala.field_fileId = paramString.optString("fileId");
        locala.field_fileUrl = paramString.optString("fileUrl");
        locala.field_fileLength = paramString.optInt("fileLength");
        label62:
        AppMethodBeat.o(182694);
        return locala;
      }
      catch (JSONException paramString)
      {
        break label62;
      }
    }
    
    public final String toJson()
    {
      AppMethodBeat.i(182693);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("aesKey", this.field_aesKey);
        ((JSONObject)localObject).put("fileId", this.field_fileId);
        ((JSONObject)localObject).put("fileUrl", this.field_fileUrl);
        ((JSONObject)localObject).put("fileLength", this.field_fileLength);
        label57:
        localObject = ((JSONObject)localObject).toString();
        AppMethodBeat.o(182693);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        break label57;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
 * JD-Core Version:    0.7.0.1
 */