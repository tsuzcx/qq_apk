package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class am
{
  public static String Sm(String paramString)
  {
    Object localObject = new File(com.tencent.mm.compatible.util.e.dzD);
    if (!((File)localObject).mkdirs()) {
      y.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + ((File)localObject).exists());
    }
    if (!((File)localObject).exists()) {
      y.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { com.tencent.mm.compatible.util.e.dzD });
    }
    localObject = ((File)localObject).getAbsolutePath() + File.separator + paramString + ".jpg";
    y.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    return localObject;
  }
  
  public static Intent Sn(String paramString)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", Uri.fromFile(new File(Sm(paramString))));
    return localIntent;
  }
  
  public static String So(String paramString)
  {
    y.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", new Object[] { paramString });
    if (bk.bl(paramString)) {
      return null;
    }
    String str = "weixin://resourceid/" + ad.bB(paramString);
    y.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", new Object[] { paramString, str });
    return str;
  }
  
  public static String Sp(String paramString)
  {
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.ccL().Sl(paramString);
    if (localWebViewJSSDKFileItem != null)
    {
      y.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", new Object[] { localWebViewJSSDKFileItem.goL });
      return localWebViewJSSDKFileItem.goL;
    }
    y.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", new Object[] { paramString });
    return null;
  }
  
  public static String Sq(String paramString)
  {
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.ccL().Sl(paramString);
    if (localWebViewJSSDKFileItem != null)
    {
      y.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", new Object[] { localWebViewJSSDKFileItem.goL });
      return localWebViewJSSDKFileItem.fMZ;
    }
    y.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", new Object[] { paramString });
    return null;
  }
  
  static InputStream Sr(String paramString)
  {
    y.i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", new Object[] { paramString });
    if (bk.bl(paramString)) {}
    while ((bk.bl(paramString)) || (!com.tencent.mm.a.e.bK(paramString))) {
      return null;
    }
    try
    {
      paramString = new FileInputStream(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  public static String Ss(String paramString)
  {
    return "_USER_FOR_WEBVIEW_JSAPI" + o.l(paramString, bk.UY());
  }
  
  public static String W(ArrayList<String> paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      y.e("MicroMsg.WebviewJSSDKUtil", "data is null");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localJSONArray.put((String)paramArrayList.get(i));
      i += 1;
    }
    return localJSONArray.toString();
  }
  
  public static String X(ArrayList<String> paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      y.e("MicroMsg.WebviewJSSDKUtil", "data is null");
      return "";
    }
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.array();
      localJSONStringer.object();
      int i = 0;
      while (i < paramArrayList.size())
      {
        String str = (String)paramArrayList.get(i);
        localJSONStringer.key("localId");
        localJSONStringer.value(str);
        i += 1;
      }
      localJSONStringer.endObject();
      localJSONStringer.endArray();
      paramArrayList = localJSONStringer.toString();
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      y.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramArrayList, "", new Object[0]);
    }
    return "";
  }
  
  public static String c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
      return "";
    }
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.array();
      localJSONStringer.object();
      localJSONStringer.key("localId");
      localJSONStringer.value(paramString1);
      localJSONStringer.key("thumbLocalId");
      localJSONStringer.value(paramString2);
      localJSONStringer.key("duration");
      localJSONStringer.value(String.valueOf(paramInt1));
      localJSONStringer.key("height");
      localJSONStringer.value(String.valueOf(paramInt2));
      localJSONStringer.key("width");
      localJSONStringer.value(String.valueOf(paramInt3));
      localJSONStringer.key("size");
      localJSONStringer.value(String.valueOf(paramInt4));
      localJSONStringer.endObject();
      localJSONStringer.endArray();
      paramString1 = localJSONStringer.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramString1, "", new Object[0]);
    }
    return "";
  }
  
  public static Intent cbZ()
  {
    return new Intent("android.media.action.VIDEO_CAPTURE");
  }
  
  public static Intent cca()
  {
    return new Intent("android.provider.MediaStore.RECORD_SOUND");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.am
 * JD-Core Version:    0.7.0.1
 */