package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.c;
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
  public a SuJ;
  public String appId;
  public String fCM;
  public String fileName;
  public int height;
  public Bundle mab = new Bundle();
  public String mediaId;
  public int mediaType;
  public String nVa;
  public String nVb;
  public boolean nVd;
  public boolean nVe = true;
  public boolean nVf = true;
  public String oLR;
  public int size;
  public int width;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.fCM = paramParcel.readString();
    this.oLR = paramParcel.readString();
    this.nVa = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.mab = paramParcel.readBundle();
  }
  
  public static WebViewJSSDKFileItem X(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.POG = paramString1;
    localWebViewJSSDKUpFileItem.nVa = paramString2;
    localWebViewJSSDKUpFileItem.gVL();
    localWebViewJSSDKUpFileItem.mediaId = c.a("jsupfile", Util.nowMilliSecond(), localWebViewJSSDKUpFileItem.fCM, localWebViewJSSDKUpFileItem.fCM);
    Log.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.fCM });
    return localWebViewJSSDKUpFileItem;
  }
  
  private static Bundle aVN(String paramString)
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
  
  private static String aq(Bundle paramBundle)
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
  
  public static WebViewJSSDKFileItem bIH(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.nVa = paramString;
    localWebViewJSSDKImageItem.gVL();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", Util.nowMilliSecond(), localWebViewJSSDKImageItem.fCM, localWebViewJSSDKImageItem.fCM);
    return localWebViewJSSDKImageItem;
  }
  
  public static WebViewJSSDKFileItem bII(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.gVL();
    localWebViewJSSDKVoiceItem.mediaId = c.a("jsupvoice", Util.nowMilliSecond(), localWebViewJSSDKVoiceItem.fCM, localWebViewJSSDKVoiceItem.fCM);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem bIJ(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.nVa = paramString;
    localWebViewJSSDKVideoItem.gVL();
    localWebViewJSSDKVideoItem.mediaId = c.a("jsvideofile", Util.nowMilliSecond(), localWebViewJSSDKVideoItem.fCM, localWebViewJSSDKVideoItem.fCM);
    Log.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.fCM, localWebViewJSSDKVideoItem.mediaId });
    return localWebViewJSSDKVideoItem;
  }
  
  public static WebViewJSSDKFileItem oF(String paramString1, String paramString2)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.nVa = paramString1;
    localWebViewJSSDKImageItem.oLR = paramString2;
    localWebViewJSSDKImageItem.gVL();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", Util.nowMilliSecond(), localWebViewJSSDKImageItem.fCM, localWebViewJSSDKImageItem.fCM);
    return localWebViewJSSDKImageItem;
  }
  
  protected void cm(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.appId = paramJSONObject.optString("appId");
    this.fCM = paramJSONObject.optString("localId");
    this.oLR = paramJSONObject.optString("thumbFilePath");
    this.nVa = paramJSONObject.optString("origFilePath");
    this.nVb = paramJSONObject.optString("serverId");
    this.mediaId = paramJSONObject.optString("mediaId");
    this.fileName = paramJSONObject.optString("fileName");
    this.mediaType = paramJSONObject.optInt("mediaType");
    this.size = paramJSONObject.optInt("size");
    this.width = paramJSONObject.optInt("width");
    this.height = paramJSONObject.optInt("height");
    this.SuJ = a.bkG(paramJSONObject.optString("cdnInfo"));
    this.nVd = paramJSONObject.optBoolean("upload");
    this.nVe = paramJSONObject.optBoolean("needCompress", true);
    this.nVf = paramJSONObject.optBoolean("needUploadCDNInfo", true);
    this.mab = aVN(paramJSONObject.optString("extra"));
  }
  
  public void d(d paramd)
  {
    if (this.SuJ == null) {
      this.SuJ = new a();
    }
    if (paramd == null)
    {
      Log.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.SuJ.field_aesKey = paramd.field_aesKey;
    this.SuJ.field_fileId = paramd.field_fileId;
    this.SuJ.field_fileUrl = paramd.field_fileUrl;
    this.SuJ.field_fileLength = ((int)paramd.field_fileLength);
  }
  
  protected JSONObject gVK()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("localId", this.fCM);
      localJSONObject.put("thumbFilePath", this.oLR);
      localJSONObject.put("origFilePath", this.nVa);
      localJSONObject.put("serverId", this.nVb);
      localJSONObject.put("mediaId", this.mediaId);
      localJSONObject.put("fileName", this.fileName);
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("size", this.size);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      if (this.SuJ != null) {
        localJSONObject.put("cdnInfo", this.SuJ.toJson());
      }
      localJSONObject.put("upload", this.nVd);
      localJSONObject.put("needCompress", this.nVe);
      localJSONObject.put("needUploadCDNInfo", this.nVf);
      localJSONObject.put("extra", aq(this.mab));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public abstract WebViewJSSDKFileItem gVL();
  
  public abstract String gVM();
  
  public abstract String getFileType();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.fCM);
    paramParcel.writeString(this.oLR);
    paramParcel.writeString(this.nVa);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeBundle(this.mab);
  }
  
  public static final class a
  {
    public String field_aesKey;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    
    public static a bkG(String paramString)
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