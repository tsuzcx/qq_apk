package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class WebViewJSSDKFileItem
  implements Parcelable
{
  public a akjx;
  public String appId;
  public String fileName;
  public String hHB;
  public int height;
  public String mediaId;
  public int mediaType;
  public Bundle oSS = new Bundle();
  public String qUK;
  public String qUL;
  public boolean qUN;
  public boolean qUO = true;
  public boolean qUP = true;
  public String rPM;
  public int size;
  public int width;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.hHB = paramParcel.readString();
    this.rPM = paramParcel.readString();
    this.qUK = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.oSS = paramParcel.readBundle();
  }
  
  private static String aO(Bundle paramBundle)
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
  
  private static Bundle aSV(String paramString)
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
  
  public static WebViewJSSDKFileItem an(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.WET = paramString1;
    localWebViewJSSDKUpFileItem.qUK = paramString2;
    localWebViewJSSDKUpFileItem.kLS();
    localWebViewJSSDKUpFileItem.mediaId = h.a("jsupfile", Util.nowMilliSecond(), localWebViewJSSDKUpFileItem.hHB, localWebViewJSSDKUpFileItem.hHB);
    Log.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.hHB });
    return localWebViewJSSDKUpFileItem;
  }
  
  public static WebViewJSSDKFileItem bLB(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.qUK = paramString;
    localWebViewJSSDKImageItem.kLS();
    localWebViewJSSDKImageItem.mediaId = h.a("jsupimg", Util.nowMilliSecond(), localWebViewJSSDKImageItem.hHB, localWebViewJSSDKImageItem.hHB);
    return localWebViewJSSDKImageItem;
  }
  
  public static WebViewJSSDKFileItem bLC(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.kLS();
    localWebViewJSSDKVoiceItem.mediaId = h.a("jsupvoice", Util.nowMilliSecond(), localWebViewJSSDKVoiceItem.hHB, localWebViewJSSDKVoiceItem.hHB);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem bLD(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.qUK = paramString;
    localWebViewJSSDKVideoItem.kLS();
    localWebViewJSSDKVideoItem.mediaId = h.a("jsvideofile", Util.nowMilliSecond(), localWebViewJSSDKVideoItem.hHB, localWebViewJSSDKVideoItem.hHB);
    Log.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.hHB, localWebViewJSSDKVideoItem.mediaId });
    return localWebViewJSSDKVideoItem;
  }
  
  public static WebViewJSSDKFileItem rW(String paramString1, String paramString2)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.qUK = paramString1;
    localWebViewJSSDKImageItem.rPM = paramString2;
    localWebViewJSSDKImageItem.kLS();
    localWebViewJSSDKImageItem.mediaId = h.a("jsupimg", Util.nowMilliSecond(), localWebViewJSSDKImageItem.hHB, localWebViewJSSDKImageItem.hHB);
    return localWebViewJSSDKImageItem;
  }
  
  protected void cT(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.appId = paramJSONObject.optString("appId");
    this.hHB = paramJSONObject.optString("localId");
    this.rPM = paramJSONObject.optString("thumbFilePath");
    this.qUK = paramJSONObject.optString("origFilePath");
    this.qUL = paramJSONObject.optString("serverId");
    this.mediaId = paramJSONObject.optString("mediaId");
    this.fileName = paramJSONObject.optString("fileName");
    this.mediaType = paramJSONObject.optInt("mediaType");
    this.size = paramJSONObject.optInt("size");
    this.width = paramJSONObject.optInt("width");
    this.height = paramJSONObject.optInt("height");
    this.akjx = a.bkr(paramJSONObject.optString("cdnInfo"));
    this.qUN = paramJSONObject.optBoolean("upload");
    this.qUO = paramJSONObject.optBoolean("needCompress", true);
    this.qUP = paramJSONObject.optBoolean("needUploadCDNInfo", true);
    this.oSS = aSV(paramJSONObject.optString("extra"));
  }
  
  public void d(d paramd)
  {
    if (this.akjx == null) {
      this.akjx = new a();
    }
    if (paramd == null)
    {
      Log.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.akjx.field_aesKey = paramd.field_aesKey;
    this.akjx.field_fileId = paramd.field_fileId;
    this.akjx.field_fileUrl = paramd.field_fileUrl;
    this.akjx.field_fileLength = ((int)paramd.field_fileLength);
  }
  
  public abstract String getFileType();
  
  protected JSONObject kLR()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("localId", this.hHB);
      localJSONObject.put("thumbFilePath", this.rPM);
      localJSONObject.put("origFilePath", this.qUK);
      localJSONObject.put("serverId", this.qUL);
      localJSONObject.put("mediaId", this.mediaId);
      localJSONObject.put("fileName", this.fileName);
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("size", this.size);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      if (this.akjx != null) {
        localJSONObject.put("cdnInfo", this.akjx.toJson());
      }
      localJSONObject.put("upload", this.qUN);
      localJSONObject.put("needCompress", this.qUO);
      localJSONObject.put("needUploadCDNInfo", this.qUP);
      localJSONObject.put("extra", aO(this.oSS));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public abstract WebViewJSSDKFileItem kLS();
  
  public abstract String kLT();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hHB);
    paramParcel.writeString(this.rPM);
    paramParcel.writeString(this.qUK);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeBundle(this.oSS);
  }
  
  public static final class a
  {
    public String field_aesKey;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    
    public static a bkr(String paramString)
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