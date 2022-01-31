package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class ar
{
  public static String ab(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(6754);
    if (paramArrayList.size() == 0)
    {
      ab.e("MicroMsg.WebviewJSSDKUtil", "data is null");
      AppMethodBeat.o(6754);
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
    AppMethodBeat.o(6754);
    return paramArrayList;
  }
  
  public static String ac(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(6755);
    if (paramArrayList.size() == 0)
    {
      ab.e("MicroMsg.WebviewJSSDKUtil", "data is null");
      AppMethodBeat.o(6755);
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
      AppMethodBeat.o(6755);
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      ab.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(6755);
    }
    return "";
  }
  
  public static String ad(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(153140);
    if (bo.es(paramArrayList))
    {
      AppMethodBeat.o(153140);
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
        WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.dcE().ahh(str);
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
          localJSONStringer.value(((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).uXp);
          localJSONStringer.endObject();
        }
      }
      localJSONStringer.endArray();
    }
    catch (Exception paramArrayList)
    {
      ab.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramArrayList, "", new Object[0]);
      AppMethodBeat.o(153140);
      return "";
    }
    paramArrayList = localJSONStringer.toString();
    AppMethodBeat.o(153140);
    return paramArrayList;
  }
  
  public static String ahk(String paramString)
  {
    AppMethodBeat.i(6747);
    Object localObject = new File(com.tencent.mm.compatible.util.e.esr);
    if (!((File)localObject).mkdirs()) {
      ab.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + ((File)localObject).exists());
    }
    if (!((File)localObject).exists()) {
      ab.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { com.tencent.mm.compatible.util.e.esr });
    }
    localObject = ((File)localObject).getAbsolutePath() + File.separator + paramString + ".jpg";
    ab.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(6747);
    return localObject;
  }
  
  public static String ahl(String paramString)
  {
    AppMethodBeat.i(154609);
    Object localObject = new File(com.tencent.mm.compatible.util.e.esr);
    if (!((File)localObject).mkdirs()) {
      ab.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + ((File)localObject).exists());
    }
    if (!((File)localObject).exists()) {
      ab.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[] { com.tencent.mm.compatible.util.e.esr });
    }
    localObject = ((File)localObject).getAbsolutePath() + File.separator + paramString;
    ab.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[] { paramString, localObject });
    AppMethodBeat.o(154609);
    return localObject;
  }
  
  private static Intent ahm(String paramString)
  {
    AppMethodBeat.i(6748);
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    paramString = ahk(paramString);
    localIntent.putExtra("output", k.d(ah.getContext(), new File(paramString)));
    AppMethodBeat.o(6748);
    return localIntent;
  }
  
  public static String ahn(String paramString)
  {
    AppMethodBeat.i(6751);
    ab.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6751);
      return null;
    }
    String str = "weixin://resourceid/" + ag.cE(paramString);
    ab.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", new Object[] { paramString, str });
    AppMethodBeat.o(6751);
    return str;
  }
  
  public static String aho(String paramString)
  {
    AppMethodBeat.i(6752);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.dcE().ahh(paramString);
    if (localWebViewJSSDKFileItem != null)
    {
      ab.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", new Object[] { localWebViewJSSDKFileItem.hII });
      paramString = localWebViewJSSDKFileItem.hII;
      AppMethodBeat.o(6752);
      return paramString;
    }
    ab.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", new Object[] { paramString });
    AppMethodBeat.o(6752);
    return null;
  }
  
  public static String ahp(String paramString)
  {
    AppMethodBeat.i(6753);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = g.dcE().ahh(paramString);
    if (localWebViewJSSDKFileItem != null)
    {
      ab.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", new Object[] { localWebViewJSSDKFileItem.hII });
      paramString = localWebViewJSSDKFileItem.hgj;
      AppMethodBeat.o(6753);
      return paramString;
    }
    ab.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", new Object[] { paramString });
    AppMethodBeat.o(6753);
    return null;
  }
  
  static InputStream ahq(String paramString)
  {
    AppMethodBeat.i(6757);
    ab.i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6757);
      return null;
    }
    if ((!bo.isNullOrNil(paramString)) && (com.tencent.mm.a.e.cN(paramString))) {
      try
      {
        paramString = new FileInputStream(paramString);
        AppMethodBeat.o(6757);
        return paramString;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(6757);
    return null;
  }
  
  public static String ahr(String paramString)
  {
    AppMethodBeat.i(6758);
    paramString = "_USER_FOR_WEBVIEW_JSAPI" + p.t(paramString, bo.aoy());
    AppMethodBeat.o(6758);
    return paramString;
  }
  
  public static Intent ax(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(6746);
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    Object localObject;
    if (bo.isNullOrNil(paramString1))
    {
      localIntent.setType("*/*");
      localObject = null;
      if (bo.isNullOrNil(paramString2)) {
        break label345;
      }
      if (!"camera".equalsIgnoreCase(paramString2)) {
        break label159;
      }
      paramString1 = ahm(paramString3);
      i = 0;
      paramString1 = new Intent[] { paramString1 };
    }
    for (;;)
    {
      if ((i != 0) || (paramString1 == null) || (paramString1.length == 0))
      {
        paramString2 = new Intent("android.intent.action.CHOOSER");
        paramString2.putExtra("android.intent.extra.INITIAL_INTENTS", paramString1);
        paramString2.putExtra("android.intent.extra.TITLE", ah.getContext().getString(2131306035));
        paramString2.putExtra("android.intent.extra.INTENT", localIntent);
        AppMethodBeat.o(6746);
        return paramString2;
        localIntent.setType(paramString1);
        break;
        label159:
        if ("camcorder".equalsIgnoreCase(paramString2))
        {
          paramString1 = dcd();
          i = 0;
          paramString1 = new Intent[] { paramString1 };
          continue;
        }
        if ("microphone".equalsIgnoreCase(paramString2))
        {
          paramString1 = dce();
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
          paramString1[0] = ahm(paramString3);
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
            paramString3[0] = dce();
          }
          else
          {
            paramString3 = localObject;
            if (paramString1.equalsIgnoreCase("video/*"))
            {
              paramString3 = new Intent[1];
              paramString3[0] = dcd();
              continue;
              label345:
              if (d.fw(16))
              {
                ab.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                paramString1 = ahm(paramString3);
                i = 0;
                paramString1 = new Intent[] { paramString1 };
                break;
                paramString1 = paramString1[0];
                AppMethodBeat.o(6746);
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
    AppMethodBeat.i(6756);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
      AppMethodBeat.o(6756);
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
      AppMethodBeat.o(6756);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(6756);
    }
    return "";
  }
  
  private static Intent dcd()
  {
    AppMethodBeat.i(6749);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    AppMethodBeat.o(6749);
    return localIntent;
  }
  
  private static Intent dce()
  {
    AppMethodBeat.i(6750);
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    AppMethodBeat.o(6750);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ar
 * JD-Core Version:    0.7.0.1
 */