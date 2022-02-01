package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class WebViewJSSDKFileItem
  implements Parcelable
{
  public a Jin;
  public String appId;
  public String dsN;
  public String fileName;
  public int height;
  public Bundle ioY = new Bundle();
  public String jXT;
  public String jXU;
  public boolean jXW;
  public boolean jXX = true;
  public boolean jXY = true;
  public String kKQ;
  public String mediaId;
  public int mediaType;
  public int size;
  public int width;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.dsN = paramParcel.readString();
    this.kKQ = paramParcel.readString();
    this.jXT = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.ioY = paramParcel.readBundle();
  }
  
  public static WebViewJSSDKFileItem R(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.EfF = paramString1;
    localWebViewJSSDKUpFileItem.jXT = paramString2;
    localWebViewJSSDKUpFileItem.eUd();
    localWebViewJSSDKUpFileItem.mediaId = c.a("jsupfile", bu.fpO(), localWebViewJSSDKUpFileItem.dsN, localWebViewJSSDKUpFileItem.dsN);
    ae.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.dsN });
    return localWebViewJSSDKUpFileItem;
  }
  
  public static WebViewJSSDKFileItem aWg(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.jXT = paramString;
    localWebViewJSSDKImageItem.eUd();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", bu.fpO(), localWebViewJSSDKImageItem.dsN, localWebViewJSSDKImageItem.dsN);
    return localWebViewJSSDKImageItem;
  }
  
  private static String ak(Bundle paramBundle)
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
  
  private static Bundle awT(String paramString)
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
  
  public static WebViewJSSDKFileItem bfG(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.eUd();
    localWebViewJSSDKVoiceItem.mediaId = c.a("jsupvoice", bu.fpO(), localWebViewJSSDKVoiceItem.dsN, localWebViewJSSDKVoiceItem.dsN);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem bfH(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.jXT = paramString;
    localWebViewJSSDKVideoItem.eUd();
    localWebViewJSSDKVideoItem.mediaId = c.a("jsvideofile", bu.fpO(), localWebViewJSSDKVideoItem.dsN, localWebViewJSSDKVideoItem.dsN);
    ae.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.dsN, localWebViewJSSDKVideoItem.mediaId });
    return localWebViewJSSDKVideoItem;
  }
  
  public static WebViewJSSDKFileItem lb(String paramString1, String paramString2)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.jXT = paramString1;
    localWebViewJSSDKImageItem.kKQ = paramString2;
    localWebViewJSSDKImageItem.eUd();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", bu.fpO(), localWebViewJSSDKImageItem.dsN, localWebViewJSSDKImageItem.dsN);
    return localWebViewJSSDKImageItem;
  }
  
  protected void bC(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.appId = paramJSONObject.optString("appId");
    this.dsN = paramJSONObject.optString("localId");
    this.kKQ = paramJSONObject.optString("thumbFilePath");
    this.jXT = paramJSONObject.optString("origFilePath");
    this.jXU = paramJSONObject.optString("serverId");
    this.mediaId = paramJSONObject.optString("mediaId");
    this.fileName = paramJSONObject.optString("fileName");
    this.mediaType = paramJSONObject.optInt("mediaType");
    this.size = paramJSONObject.optInt("size");
    this.width = paramJSONObject.optInt("width");
    this.height = paramJSONObject.optInt("height");
    this.Jin = a.aIL(paramJSONObject.optString("cdnInfo"));
    this.jXW = paramJSONObject.optBoolean("upload");
    this.jXX = paramJSONObject.optBoolean("needCompress", true);
    this.jXY = paramJSONObject.optBoolean("needUploadCDNInfo", true);
    this.ioY = awT(paramJSONObject.optString("extra"));
  }
  
  public void d(d paramd)
  {
    if (this.Jin == null) {
      this.Jin = new a();
    }
    if (paramd == null)
    {
      ae.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.Jin.field_aesKey = paramd.field_aesKey;
    this.Jin.field_fileId = paramd.field_fileId;
    this.Jin.field_fileUrl = paramd.field_fileUrl;
    this.Jin.field_fileLength = ((int)paramd.field_fileLength);
  }
  
  protected JSONObject eUc()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("localId", this.dsN);
      localJSONObject.put("thumbFilePath", this.kKQ);
      localJSONObject.put("origFilePath", this.jXT);
      localJSONObject.put("serverId", this.jXU);
      localJSONObject.put("mediaId", this.mediaId);
      localJSONObject.put("fileName", this.fileName);
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("size", this.size);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      if (this.Jin != null) {
        localJSONObject.put("cdnInfo", this.Jin.toJson());
      }
      localJSONObject.put("upload", this.jXW);
      localJSONObject.put("needCompress", this.jXX);
      localJSONObject.put("needUploadCDNInfo", this.jXY);
      localJSONObject.put("extra", ak(this.ioY));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public abstract WebViewJSSDKFileItem eUd();
  
  public abstract String eUf();
  
  public abstract String fwN();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dsN);
    paramParcel.writeString(this.kKQ);
    paramParcel.writeString(this.jXT);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeBundle(this.ioY);
  }
  
  public static final class a
  {
    public String field_aesKey;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    
    public static a aIL(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
 * JD-Core Version:    0.7.0.1
 */