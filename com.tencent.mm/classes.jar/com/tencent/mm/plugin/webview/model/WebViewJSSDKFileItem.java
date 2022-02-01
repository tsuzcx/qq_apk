package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class WebViewJSSDKFileItem
  implements Parcelable
{
  public a GZW;
  public String appId;
  public String dgl;
  public String fileName;
  public Bundle hSN = new Bundle();
  public int height;
  public String jAH;
  public String jAI;
  public boolean jAK;
  public boolean jAL = true;
  public boolean jAM = true;
  public String kmB;
  public String mediaId;
  public int mediaType;
  public int size;
  public int width;
  
  public WebViewJSSDKFileItem() {}
  
  protected WebViewJSSDKFileItem(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.dgl = paramParcel.readString();
    this.kmB = paramParcel.readString();
    this.jAH = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.hSN = paramParcel.readBundle();
  }
  
  public static WebViewJSSDKFileItem O(int paramInt, String paramString1, String paramString2)
  {
    WebViewJSSDKUpFileItem localWebViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
    localWebViewJSSDKUpFileItem.fileType = paramInt;
    localWebViewJSSDKUpFileItem.CkB = paramString1;
    localWebViewJSSDKUpFileItem.jAH = paramString2;
    localWebViewJSSDKUpFileItem.fcG();
    localWebViewJSSDKUpFileItem.mediaId = c.a("jsupfile", bs.eWj(), localWebViewJSSDKUpFileItem.dgl, localWebViewJSSDKUpFileItem.dgl);
    ac.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[] { Integer.valueOf(paramInt), paramString2, localWebViewJSSDKUpFileItem.dgl });
    return localWebViewJSSDKUpFileItem;
  }
  
  public static WebViewJSSDKFileItem aCp(String paramString)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.jAH = paramString;
    localWebViewJSSDKImageItem.fcG();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", bs.eWj(), localWebViewJSSDKImageItem.dgl, localWebViewJSSDKImageItem.dgl);
    return localWebViewJSSDKImageItem;
  }
  
  public static WebViewJSSDKFileItem aHG(String paramString)
  {
    WebViewJSSDKVoiceItem localWebViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
    localWebViewJSSDKVoiceItem.fileName = paramString;
    localWebViewJSSDKVoiceItem.fcG();
    localWebViewJSSDKVoiceItem.mediaId = c.a("jsupvoice", bs.eWj(), localWebViewJSSDKVoiceItem.dgl, localWebViewJSSDKVoiceItem.dgl);
    return localWebViewJSSDKVoiceItem;
  }
  
  public static WebViewJSSDKVideoItem aOK(String paramString)
  {
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
    localWebViewJSSDKVideoItem.jAH = paramString;
    localWebViewJSSDKVideoItem.fcG();
    localWebViewJSSDKVideoItem.mediaId = c.a("jsvideofile", bs.eWj(), localWebViewJSSDKVideoItem.dgl, localWebViewJSSDKVideoItem.dgl);
    ac.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[] { paramString, localWebViewJSSDKVideoItem.dgl, localWebViewJSSDKVideoItem.mediaId });
    return localWebViewJSSDKVideoItem;
  }
  
  private static String ag(Bundle paramBundle)
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
  
  private static Bundle aqE(String paramString)
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
  
  public static WebViewJSSDKFileItem nr(String paramString1, String paramString2)
  {
    WebViewJSSDKImageItem localWebViewJSSDKImageItem = new WebViewJSSDKImageItem();
    localWebViewJSSDKImageItem.jAH = paramString1;
    localWebViewJSSDKImageItem.kmB = paramString2;
    localWebViewJSSDKImageItem.fcG();
    localWebViewJSSDKImageItem.mediaId = c.a("jsupimg", bs.eWj(), localWebViewJSSDKImageItem.dgl, localWebViewJSSDKImageItem.dgl);
    return localWebViewJSSDKImageItem;
  }
  
  protected void bt(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.appId = paramJSONObject.optString("appId");
    this.dgl = paramJSONObject.optString("localId");
    this.kmB = paramJSONObject.optString("thumbFilePath");
    this.jAH = paramJSONObject.optString("origFilePath");
    this.jAI = paramJSONObject.optString("serverId");
    this.mediaId = paramJSONObject.optString("mediaId");
    this.fileName = paramJSONObject.optString("fileName");
    this.mediaType = paramJSONObject.optInt("mediaType");
    this.size = paramJSONObject.optInt("size");
    this.width = paramJSONObject.optInt("width");
    this.height = paramJSONObject.optInt("height");
    this.GZW = a.aBS(paramJSONObject.optString("cdnInfo"));
    this.jAK = paramJSONObject.optBoolean("upload");
    this.jAL = paramJSONObject.optBoolean("needCompress", true);
    this.jAM = paramJSONObject.optBoolean("needUploadCDNInfo", true);
    this.hSN = aqE(paramJSONObject.optString("extra"));
  }
  
  public void d(d paramd)
  {
    if (this.GZW == null) {
      this.GZW = new a();
    }
    if (paramd == null)
    {
      ac.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
      return;
    }
    this.GZW.field_aesKey = paramd.field_aesKey;
    this.GZW.field_fileId = paramd.field_fileId;
    this.GZW.field_fileUrl = paramd.field_fileUrl;
    this.GZW.field_fileLength = ((int)paramd.field_fileLength);
  }
  
  protected JSONObject fcF()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("localId", this.dgl);
      localJSONObject.put("thumbFilePath", this.kmB);
      localJSONObject.put("origFilePath", this.jAH);
      localJSONObject.put("serverId", this.jAI);
      localJSONObject.put("mediaId", this.mediaId);
      localJSONObject.put("fileName", this.fileName);
      localJSONObject.put("mediaType", this.mediaType);
      localJSONObject.put("size", this.size);
      localJSONObject.put("width", this.width);
      localJSONObject.put("height", this.height);
      if (this.GZW != null) {
        localJSONObject.put("cdnInfo", this.GZW.toJson());
      }
      localJSONObject.put("upload", this.jAK);
      localJSONObject.put("needCompress", this.jAL);
      localJSONObject.put("needUploadCDNInfo", this.jAM);
      localJSONObject.put("extra", ag(this.hSN));
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public abstract WebViewJSSDKFileItem fcG();
  
  public abstract String fcH();
  
  public abstract String fda();
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dgl);
    paramParcel.writeString(this.kmB);
    paramParcel.writeString(this.jAH);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeBundle(this.hSN);
  }
  
  public static final class a
  {
    public String field_aesKey;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    
    public static a aBS(String paramString)
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