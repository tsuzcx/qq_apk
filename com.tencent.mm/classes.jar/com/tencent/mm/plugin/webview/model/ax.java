package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class ax
{
  public static String aIR(String paramString)
  {
    AppMethodBeat.i(79047);
    Object localObject = new k(b.asv());
    if (!((k)localObject).mkdirs()) {
      ae.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + ((k)localObject).exists());
    }
    if (!((k)localObject).exists()) {
      ae.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { b.asv() });
    }
    localObject = w.B(((k)localObject).fTh()) + "/" + paramString + ".jpg";
    ae.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(79047);
    return localObject;
  }
  
  private static Intent aIS(String paramString)
  {
    AppMethodBeat.i(79048);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = aIR(paramString);
    localIntent.putExtra("output", o.a(ak.getContext(), new k(paramString)));
    AppMethodBeat.o(79048);
    return localIntent;
  }
  
  public static String aIT(String paramString)
  {
    AppMethodBeat.i(79051);
    ae.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79051);
      return null;
    }
    String str = "weixin://resourceid/" + aj.ej(paramString);
    ae.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", new Object[] { paramString, str });
    AppMethodBeat.o(79051);
    return str;
  }
  
  public static String aIU(String paramString)
  {
    AppMethodBeat.i(79052);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.eUG().aIN(paramString);
    if (localWebViewJSSDKFileItem != null)
    {
      ae.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", new Object[] { localWebViewJSSDKFileItem.kKQ });
      paramString = localWebViewJSSDKFileItem.kKQ;
      AppMethodBeat.o(79052);
      return paramString;
    }
    ae.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", new Object[] { paramString });
    AppMethodBeat.o(79052);
    return null;
  }
  
  public static String aIV(String paramString)
  {
    AppMethodBeat.i(79053);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.eUG().aIN(paramString);
    if (localWebViewJSSDKFileItem != null)
    {
      ae.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", new Object[] { localWebViewJSSDKFileItem.jXT });
      paramString = localWebViewJSSDKFileItem.jXT;
      AppMethodBeat.o(79053);
      return paramString;
    }
    ae.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", new Object[] { paramString });
    AppMethodBeat.o(79053);
    return null;
  }
  
  public static String aIW(String paramString)
  {
    AppMethodBeat.i(79059);
    paramString = "_USER_FOR_WEBVIEW_JSAPI" + t.w(paramString, bu.fpO());
    AppMethodBeat.o(79059);
    return paramString;
  }
  
  public static String aJ(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(79054);
    if (paramArrayList.size() == 0)
    {
      ae.e("MicroMsg.WebviewJSSDKUtil", "data is null");
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
  
  public static String aK(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(79055);
    if (paramArrayList.size() == 0)
    {
      ae.e("MicroMsg.WebviewJSSDKUtil", "data is null");
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
      ae.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(79055);
    }
    return "";
  }
  
  public static String aL(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(79056);
    if (bu.ht(paramArrayList))
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
        WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.eUG().aIN(str);
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
          localJSONStringer.value(((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).tUF);
          localJSONStringer.endObject();
        }
      }
      localJSONStringer.endArray();
    }
    catch (Exception paramArrayList)
    {
      ae.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(79056);
      return "";
    }
    paramArrayList = localJSONStringer.toString();
    AppMethodBeat.o(79056);
    return paramArrayList;
  }
  
  public static Intent aV(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(79046);
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    Object localObject;
    if (bu.isNullOrNil(paramString1))
    {
      localIntent.setType("*/*");
      localObject = null;
      if (bu.isNullOrNil(paramString2)) {
        break label345;
      }
      if (!"camera".equalsIgnoreCase(paramString2)) {
        break label159;
      }
      paramString1 = aIS(paramString3);
      i = 0;
      paramString1 = new Intent[] { paramString1 };
    }
    for (;;)
    {
      if ((i != 0) || (paramString1 == null) || (paramString1.length == 0))
      {
        paramString2 = new Intent("android.intent.action.CHOOSER");
        paramString2.putExtra("android.intent.extra.INITIAL_INTENTS", paramString1);
        paramString2.putExtra("android.intent.extra.TITLE", ak.getContext().getString(2131766283));
        paramString2.putExtra("android.intent.extra.INTENT", localIntent);
        AppMethodBeat.o(79046);
        return paramString2;
        localIntent.setType(paramString1);
        break;
        label159:
        if ("camcorder".equalsIgnoreCase(paramString2))
        {
          paramString1 = eUh();
          i = 0;
          paramString1 = new Intent[] { paramString1 };
          continue;
        }
        if ("microphone".equalsIgnoreCase(paramString2))
        {
          paramString1 = eUi();
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
          paramString1[0] = aIS(paramString3);
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
            paramString3[0] = eUi();
          }
          else
          {
            paramString3 = localObject;
            if (paramString1.equalsIgnoreCase("video/*"))
            {
              paramString3 = new Intent[1];
              paramString3[0] = eUh();
              continue;
              label345:
              if (d.lB(16))
              {
                ae.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                paramString1 = aIS(paramString3);
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
  
  public static String b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(79057);
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
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
      ae.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(79057);
    }
    return "";
  }
  
  private static Intent eUh()
  {
    AppMethodBeat.i(79049);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(79049);
    return localIntent;
  }
  
  private static Intent eUi()
  {
    AppMethodBeat.i(79050);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(79050);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ax
 * JD-Core Version:    0.7.0.1
 */