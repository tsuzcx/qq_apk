package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class ay
{
  public static String aYW(String paramString)
  {
    AppMethodBeat.i(79047);
    Object localObject = new o(b.aKV());
    if (!((o)localObject).mkdirs()) {
      Log.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + ((o)localObject).exists());
    }
    if (!((o)localObject).exists()) {
      Log.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.aKV() });
    }
    localObject = aa.z(((o)localObject).her()) + "/" + paramString + ".jpg";
    Log.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(79047);
    return localObject;
  }
  
  private static Intent aYX(String paramString)
  {
    AppMethodBeat.i(79048);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = aYW(paramString);
    localIntent.putExtra("output", FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), new o(paramString)));
    AppMethodBeat.o(79048);
    return localIntent;
  }
  
  public static String aYY(String paramString)
  {
    AppMethodBeat.i(79051);
    Log.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79051);
      return null;
    }
    String str = "weixin://resourceid/" + MD5Util.getMD5String(paramString);
    Log.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", new Object[] { paramString, str });
    AppMethodBeat.o(79051);
    return str;
  }
  
  public static String aYZ(String paramString)
  {
    AppMethodBeat.i(79052);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.gdv().aYO(paramString);
    if (localWebViewJSSDKFileItem != null)
    {
      Log.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", new Object[] { localWebViewJSSDKFileItem.lPx });
      paramString = localWebViewJSSDKFileItem.lPx;
      AppMethodBeat.o(79052);
      return paramString;
    }
    Log.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", new Object[] { paramString });
    AppMethodBeat.o(79052);
    return null;
  }
  
  public static String aZa(String paramString)
  {
    AppMethodBeat.i(79053);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.gdv().aYO(paramString);
    if (localWebViewJSSDKFileItem != null)
    {
      Log.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", new Object[] { localWebViewJSSDKFileItem.laR });
      paramString = localWebViewJSSDKFileItem.laR;
      AppMethodBeat.o(79053);
      return paramString;
    }
    Log.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", new Object[] { paramString });
    AppMethodBeat.o(79053);
    return null;
  }
  
  public static String aZb(String paramString)
  {
    AppMethodBeat.i(79059);
    paramString = "_USER_FOR_WEBVIEW_JSAPI" + x.x(paramString, Util.nowMilliSecond());
    AppMethodBeat.o(79059);
    return paramString;
  }
  
  public static String bb(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(79054);
    if (paramArrayList.size() == 0)
    {
      Log.e("MicroMsg.WebviewJSSDKUtil", "data is null");
      AppMethodBeat.o(79054);
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localJSONArray.put((String)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList = localJSONArray.toString();
    AppMethodBeat.o(79054);
    return paramArrayList;
  }
  
  public static String bc(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(79055);
    if (paramArrayList.size() == 0)
    {
      Log.e("MicroMsg.WebviewJSSDKUtil", "data is null");
      AppMethodBeat.o(79055);
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
      AppMethodBeat.o(79055);
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      Log.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(79055);
    }
    return "";
  }
  
  public static String bd(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(79056);
    if (Util.isNullOrNil(paramArrayList))
    {
      AppMethodBeat.o(79056);
      return "";
    }
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.array();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.gdv().aYO(str);
        if ((localWebViewJSSDKFileItem instanceof WebViewJSSDKImageItem))
        {
          localJSONStringer.object();
          localJSONStringer.key("localId");
          localJSONStringer.value(str);
          localJSONStringer.key("height");
          localJSONStringer.value(localWebViewJSSDKFileItem.height);
          localJSONStringer.key("width");
          localJSONStringer.value(localWebViewJSSDKFileItem.width);
          localJSONStringer.key("isGif");
          localJSONStringer.value(((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).xlR);
          localJSONStringer.endObject();
        }
      }
      localJSONStringer.endArray();
    }
    catch (Exception paramArrayList)
    {
      Log.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(79056);
      return "";
    }
    paramArrayList = localJSONStringer.toString();
    AppMethodBeat.o(79056);
    return paramArrayList;
  }
  
  public static Intent bf(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(79046);
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    Object localObject;
    if (Util.isNullOrNil(paramString1))
    {
      localIntent.setType("*/*");
      localObject = null;
      if (Util.isNullOrNil(paramString2)) {
        break label345;
      }
      if (!"camera".equalsIgnoreCase(paramString2)) {
        break label159;
      }
      paramString1 = aYX(paramString3);
      i = 0;
      paramString1 = new Intent[] { paramString1 };
    }
    for (;;)
    {
      if ((i != 0) || (paramString1 == null) || (paramString1.length == 0))
      {
        paramString2 = new Intent("android.intent.action.CHOOSER");
        paramString2.putExtra("android.intent.extra.INITIAL_INTENTS", paramString1);
        paramString2.putExtra("android.intent.extra.TITLE", MMApplicationContext.getContext().getString(2131768794));
        paramString2.putExtra("android.intent.extra.INTENT", localIntent);
        AppMethodBeat.o(79046);
        return paramString2;
        localIntent.setType(paramString1);
        break;
        label159:
        if ("camcorder".equalsIgnoreCase(paramString2))
        {
          paramString1 = gcV();
          i = 0;
          paramString1 = new Intent[] { paramString1 };
          continue;
        }
        if ("microphone".equalsIgnoreCase(paramString2))
        {
          paramString1 = gcW();
          i = 0;
          paramString1 = new Intent[] { paramString1 };
          continue;
        }
        if ((!"*".equalsIgnoreCase(paramString2)) && (!"true".equalsIgnoreCase(paramString2)) && (!"false".equalsIgnoreCase(paramString2))) {
          break label392;
        }
        if (paramString1.equalsIgnoreCase("image/*"))
        {
          paramString1 = new Intent[1];
          paramString1[0] = aYX(paramString3);
          paramString3 = paramString1;
        }
      }
      for (;;)
      {
        if (("false".equalsIgnoreCase(paramString2)) || ("*".equalsIgnoreCase(paramString2)))
        {
          paramString1 = paramString3;
          break;
          if (paramString1.equalsIgnoreCase("audio/*"))
          {
            paramString3 = new Intent[1];
            paramString3[0] = gcW();
          }
          else
          {
            paramString3 = localObject;
            if (paramString1.equalsIgnoreCase("video/*"))
            {
              paramString3 = new Intent[1];
              paramString3[0] = gcV();
              continue;
              label345:
              if (d.oE(16))
              {
                Log.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                paramString1 = aYX(paramString3);
                i = 0;
                paramString1 = new Intent[] { paramString1 };
                break;
                paramString1 = paramString1[0];
                AppMethodBeat.o(79046);
                return paramString1;
              }
              label392:
              i = 0;
              paramString1 = null;
              break;
            }
          }
        }
      }
      i = 0;
      paramString1 = paramString3;
    }
  }
  
  public static String c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(79057);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
      AppMethodBeat.o(79057);
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
      AppMethodBeat.o(79057);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(79057);
    }
    return "";
  }
  
  private static Intent gcV()
  {
    AppMethodBeat.i(79049);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(79049);
    return localIntent;
  }
  
  private static Intent gcW()
  {
    AppMethodBeat.i(79050);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(79050);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ay
 * JD-Core Version:    0.7.0.1
 */