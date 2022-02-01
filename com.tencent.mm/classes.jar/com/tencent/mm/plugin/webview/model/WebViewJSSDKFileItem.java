package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class WebViewJSSDKFileItem
  implements Parcelable
{
  public a UtF;
  public String appId;
  public String dJX;
  public String fileName;
  public int height;
  public Bundle jkf = new Bundle();
  public String lPx;
  public String laR;
  public String laS;
  public boolean laU;
  public boolean laV = true;
  public boolean laW = true;
  public String mediaId;
  public int mediaType;
  public int size;
  public int width;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.dJX = paramParcel.readString();
    this.lPx = paramParcel.readString();
    this.laR = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.jkf = paramParcel.readBundle();
  }
  
  public static WebViewJSSDKFileItem T(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.ISo = paramString1;
    localWebViewJSSDKUpFileItem.laR = paramString2;
    localWebViewJSSDKUpFileItem.gWS();
    localWebViewJSSDKUpFileItem.mediaId = c.a("jsupfile", Util.nowMilliSecond(), localWebViewJSSDKUpFileItem.dJX, localWebViewJSSDKUpFileItem.dJX);
    Log.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.dJX });
    return localWebViewJSSDKUpFileItem;
  }
  
  private static Bundle aLl(String paramString)
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
  
  private static String au(Bundle paramBundle)
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
  
  public static WebViewJSSDKFileItem bxe(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.laR = paramString;
    localWebViewJSSDKImageItem.gWS();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", Util.nowMilliSecond(), localWebViewJSSDKImageItem.dJX, localWebViewJSSDKImageItem.dJX);
    return localWebViewJSSDKImageItem;
  }
  
  public static WebViewJSSDKFileItem bxf(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.gWS();
    localWebViewJSSDKVoiceItem.mediaId = c.a("jsupvoice", Util.nowMilliSecond(), localWebViewJSSDKVoiceItem.dJX, localWebViewJSSDKVoiceItem.dJX);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem bxg(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.laR = paramString;
    localWebViewJSSDKVideoItem.gWS();
    localWebViewJSSDKVideoItem.mediaId = c.a("jsvideofile", Util.nowMilliSecond(), localWebViewJSSDKVideoItem.dJX, localWebViewJSSDKVideoItem.dJX);
    Log.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.dJX, localWebViewJSSDKVideoItem.mediaId });
    return localWebViewJSSDKVideoItem;
  }
  
  public static WebViewJSSDKFileItem ma(String paramString1, String paramString2)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.laR = paramString1;
    localWebViewJSSDKImageItem.lPx = paramString2;
    localWebViewJSSDKImageItem.gWS();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", Util.nowMilliSecond(), localWebViewJSSDKImageItem.dJX, localWebViewJSSDKImageItem.dJX);
    return localWebViewJSSDKImageItem;
  }
  
  protected void cb(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.appId = paramJSONObject.optString("appId");
    this.dJX = paramJSONObject.optString("localId");
    this.lPx = paramJSONObject.optString("thumbFilePath");
    this.laR = paramJSONObject.optString("origFilePath");
    this.laS = paramJSONObject.optString("serverId");
    this.mediaId = paramJSONObject.optString("mediaId");
    this.fileName = paramJSONObject.optString("fileName");
    this.mediaType = paramJSONObject.optInt("mediaType");
    this.size = paramJSONObject.optInt("size");
    this.width = paramJSONObject.optInt("width");
    this.height = paramJSONObject.optInt("height");
    this.UtF = a.aYM(paramJSONObject.optString("cdnInfo"));
    this.laU = paramJSONObject.optBoolean("upload");
    this.laV = paramJSONObject.optBoolean("needCompress", true);
    this.laW = paramJSONObject.optBoolean("needUploadCDNInfo", true);
    this.jkf = aLl(paramJSONObject.optString("extra"));
  }
  
  public void d(d paramd)
  {
    if (this.UtF == null) {
      this.UtF = new a();
    }
    if (paramd == null)
    {
      Log.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.UtF.field_aesKey = paramd.field_aesKey;
    this.UtF.field_fileId = paramd.field_fileId;
    this.UtF.field_fileUrl = paramd.field_fileUrl;
    this.UtF.field_fileLength = ((int)paramd.field_fileLength);
  }
  
  protected JSONObject gWR()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("localId", this.dJX);
      localJSONObject.put("thumbFilePath", this.lPx);
      localJSONObject.put("origFilePath", this.laR);
      localJSONObject.put("serverId", this.laS);
      localJSONObject.put("mediaId", this.mediaId);
      localJSONObject.put("fileName", this.fileName);
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("size", this.size);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      if (this.UtF != null) {
        localJSONObject.put("cdnInfo", this.UtF.toJson());
      }
      localJSONObject.put("upload", this.laU);
      localJSONObject.put("needCompress", this.laV);
      localJSONObject.put("needUploadCDNInfo", this.laW);
      localJSONObject.put("extra", au(this.jkf));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public abstract WebViewJSSDKFileItem gWS();
  
  public abstract String getFileType();
  
  public abstract String hdY();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dJX);
    paramParcel.writeString(this.lPx);
    paramParcel.writeString(this.laR);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeBundle(this.jkf);
  }
  
  public static final class a
  {
    public String field_aesKey;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    
    public static a aYM(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem
 * JD-Core Version:    0.7.0.1
 */