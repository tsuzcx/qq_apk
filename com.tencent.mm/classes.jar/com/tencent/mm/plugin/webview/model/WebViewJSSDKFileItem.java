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
  public a Lwc;
  public String appId;
  public String diQ;
  public String fileName;
  public int height;
  public Bundle hsl = new Bundle();
  public String jMa;
  public String jau;
  public String jav;
  public boolean jax;
  public boolean jay = true;
  public boolean jaz = true;
  public String mediaId;
  public int mediaType;
  public int size;
  public int width;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.diQ = paramParcel.readString();
    this.jMa = paramParcel.readString();
    this.jau = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.hsl = paramParcel.readBundle();
  }
  
  public static WebViewJSSDKFileItem O(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.ASo = paramString1;
    localWebViewJSSDKUpFileItem.jau = paramString2;
    localWebViewJSSDKUpFileItem.fZw();
    localWebViewJSSDKUpFileItem.mediaId = c.a("jsupfile", bt.eGO(), localWebViewJSSDKUpFileItem.diQ, localWebViewJSSDKUpFileItem.diQ);
    ad.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.diQ });
    return localWebViewJSSDKUpFileItem;
  }
  
  public static WebViewJSSDKFileItem aVX(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.jau = paramString;
    localWebViewJSSDKImageItem.fZw();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", bt.eGO(), localWebViewJSSDKImageItem.diQ, localWebViewJSSDKImageItem.diQ);
    return localWebViewJSSDKImageItem;
  }
  
  public static WebViewJSSDKFileItem aVY(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.fZw();
    localWebViewJSSDKVoiceItem.mediaId = c.a("jsupvoice", bt.eGO(), localWebViewJSSDKVoiceItem.diQ, localWebViewJSSDKVoiceItem.diQ);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem aVZ(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.jau = paramString;
    localWebViewJSSDKVideoItem.fZw();
    localWebViewJSSDKVideoItem.mediaId = c.a("jsvideofile", bt.eGO(), localWebViewJSSDKVideoItem.diQ, localWebViewJSSDKVideoItem.diQ);
    ad.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.diQ, localWebViewJSSDKVideoItem.mediaId });
    return localWebViewJSSDKVideoItem;
  }
  
  private static String ac(Bundle paramBundle)
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
  
  private static Bundle alF(String paramString)
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
  
  public static WebViewJSSDKFileItem mV(String paramString1, String paramString2)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.jau = paramString1;
    localWebViewJSSDKImageItem.jMa = paramString2;
    localWebViewJSSDKImageItem.fZw();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", bt.eGO(), localWebViewJSSDKImageItem.diQ, localWebViewJSSDKImageItem.diQ);
    return localWebViewJSSDKImageItem;
  }
  
  protected void bt(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.appId = paramJSONObject.optString("appId");
    this.diQ = paramJSONObject.optString("localId");
    this.jMa = paramJSONObject.optString("thumbFilePath");
    this.jau = paramJSONObject.optString("origFilePath");
    this.jav = paramJSONObject.optString("serverId");
    this.mediaId = paramJSONObject.optString("mediaId");
    this.fileName = paramJSONObject.optString("fileName");
    this.mediaType = paramJSONObject.optInt("mediaType");
    this.size = paramJSONObject.optInt("size");
    this.width = paramJSONObject.optInt("width");
    this.height = paramJSONObject.optInt("height");
    this.Lwc = a.awA(paramJSONObject.optString("cdnInfo"));
    this.jax = paramJSONObject.optBoolean("upload");
    this.jay = paramJSONObject.optBoolean("needCompress", true);
    this.jaz = paramJSONObject.optBoolean("needUploadCDNInfo", true);
    this.hsl = alF(paramJSONObject.optString("extra"));
  }
  
  public void e(d paramd)
  {
    if (this.Lwc == null) {
      this.Lwc = new a();
    }
    if (paramd == null)
    {
      ad.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.Lwc.field_aesKey = paramd.field_aesKey;
    this.Lwc.field_fileId = paramd.field_fileId;
    this.Lwc.field_fileUrl = paramd.field_fileUrl;
    this.Lwc.field_fileLength = ((int)paramd.field_fileLength);
  }
  
  protected JSONObject fZv()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("localId", this.diQ);
      localJSONObject.put("thumbFilePath", this.jMa);
      localJSONObject.put("origFilePath", this.jau);
      localJSONObject.put("serverId", this.jav);
      localJSONObject.put("mediaId", this.mediaId);
      localJSONObject.put("fileName", this.fileName);
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("size", this.size);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      if (this.Lwc != null) {
        localJSONObject.put("cdnInfo", this.Lwc.toJson());
      }
      localJSONObject.put("upload", this.jax);
      localJSONObject.put("needCompress", this.jay);
      localJSONObject.put("needUploadCDNInfo", this.jaz);
      localJSONObject.put("extra", ac(this.hsl));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public abstract WebViewJSSDKFileItem fZw();
  
  public abstract String fZx();
  
  public abstract String fZy();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.diQ);
    paramParcel.writeString(this.jMa);
    paramParcel.writeString(this.jau);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeBundle(this.hsl);
  }
  
  public static final class a
  {
    public String field_aesKey;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    
    public static a awA(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
 * JD-Core Version:    0.7.0.1
 */