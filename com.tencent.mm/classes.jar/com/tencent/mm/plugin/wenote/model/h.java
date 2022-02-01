package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.g.a.wo.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static String JHA;
  public static String JHn;
  public static String JHo;
  public static String JHp;
  public static String JHq;
  public static String JHr;
  public static String JHs;
  public static String JHt;
  public static String JHu;
  public static String JHv;
  public static String JHw;
  private static String[] JHx;
  private static String[] JHy;
  private static LinkedList<amz> JHz;
  private static Map<String, String> oYD;
  
  static
  {
    AppMethodBeat.i(30339);
    JHn = ao.cVg() + "/fav_fileicon_video.png";
    JHo = ao.cVg() + "/fav_fileicon_music.png";
    JHp = ao.cVg() + "/fav_list_img_default.png";
    JHq = ao.cVg() + "/fav_fileicon_zip.png";
    JHr = ao.cVg() + "/fav_fileicon_word.png";
    JHs = ao.cVg() + "/fav_fileicon_ppt.png";
    JHt = ao.cVg() + "/fav_fileicon_xls.png";
    JHu = ao.cVg() + "/fav_fileicon_txt.png";
    JHv = ao.cVg() + "/fav_fileicon_pdf.png";
    JHw = ao.cVg() + "/fav_fileicon_unknow.png";
    oYD = new HashMap();
    HashMap localHashMap = new HashMap();
    oYD = localHashMap;
    localHashMap.put("avi", JHn);
    oYD.put("m4v", JHn);
    oYD.put("vob", JHn);
    oYD.put("mpeg", JHn);
    oYD.put("mpe", JHn);
    oYD.put("asx", JHn);
    oYD.put("asf", JHn);
    oYD.put("f4v", JHn);
    oYD.put("flv", JHn);
    oYD.put("mkv", JHn);
    oYD.put("wmv", JHn);
    oYD.put("wm", JHn);
    oYD.put("3gp", JHn);
    oYD.put("mp4", JHn);
    oYD.put("rmvb", JHn);
    oYD.put("rm", JHn);
    oYD.put("ra", JHn);
    oYD.put("ram", JHn);
    oYD.put("mp3pro", JHo);
    oYD.put("vqf", JHo);
    oYD.put("cd", JHo);
    oYD.put("md", JHo);
    oYD.put("mod", JHo);
    oYD.put("vorbis", JHo);
    oYD.put("au", JHo);
    oYD.put("amr", JHo);
    oYD.put("silk", JHo);
    oYD.put("wma", JHo);
    oYD.put("mmf", JHo);
    oYD.put("mid", JHo);
    oYD.put("midi", JHo);
    oYD.put("mp3", JHo);
    oYD.put("aac", JHo);
    oYD.put("ape", JHo);
    oYD.put("aiff", JHo);
    oYD.put("aif", JHo);
    oYD.put("jfif", JHp);
    oYD.put("tiff", JHp);
    oYD.put("tif", JHp);
    oYD.put("jpe", JHp);
    oYD.put("dib", JHp);
    oYD.put("jpeg", JHp);
    oYD.put("jpg", JHp);
    oYD.put("png", JHp);
    oYD.put("bmp", JHp);
    oYD.put("gif", JHp);
    oYD.put("rar", JHq);
    oYD.put("zip", JHq);
    oYD.put("7z", JHq);
    oYD.put("iso", JHq);
    oYD.put("cab", JHq);
    oYD.put("doc", JHr);
    oYD.put("docx", JHr);
    oYD.put("ppt", JHs);
    oYD.put("pptx", JHs);
    oYD.put("xls", JHt);
    oYD.put("xlsx", JHt);
    oYD.put("txt", JHu);
    oYD.put("rtf", JHu);
    oYD.put("pdf", JHv);
    oYD.put("unknown", JHw);
    JHx = new String[] { "<div>", "<div/>", "<object", "<br", "</" };
    JHy = new String[] { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
    JHz = null;
    JHA = "";
    AppMethodBeat.o(30339);
  }
  
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> a(Object paramObject, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(30335);
    if (paramObject == null)
    {
      AppMethodBeat.o(30335);
      return null;
    }
    paramObject = (ArrayList)paramObject;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramObject.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.c)((Iterator)localObject1).next();
      if (((com.tencent.mm.plugin.wenote.model.a.c)localObject2).getType() != 1) {
        localArrayList.add(localObject2);
      }
    }
    int i = 0;
    if (i < paramList.size())
    {
      localObject1 = (String)paramList.get(i);
      if (((String)localObject1).trim().equals("<ThisisNoteNodeHrObj>"))
      {
        localObject1 = new com.tencent.mm.plugin.wenote.model.a.h();
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).qPA = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).qPG = false;
        if (i < localArrayList.size()) {
          localArrayList.add(i, localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localObject1);
        continue;
        if (!((String)localObject1).trim().equals("<ThisisNoteNodeObj>"))
        {
          localObject2 = new i();
          ((i)localObject2).content = ((String)localObject1);
          ((i)localObject2).qPA = false;
          ((i)localObject2).qPG = false;
          ((i)localObject2).dLl = f.alR(localObject2.toString());
          if (i < localArrayList.size()) {
            localArrayList.add(i, localObject2);
          } else {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    if (paramBoolean)
    {
      paramObject.clear();
      paramObject.addAll(localArrayList);
    }
    AppMethodBeat.o(30335);
    return localArrayList;
  }
  
  public static void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(30337);
    String str = AndroidMediaUtil.getExportImagePath("jpg");
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
        if (!Util.isNullOrNil(str)) {
          AndroidMediaUtil.refreshMediaScanner(str, paramContext);
        }
        paramContext = new o(str);
        if (paramContext.exists())
        {
          long l = paramContext.length() / 1024L;
          int j = 0;
          i = 0;
          if (paramBitmap != null)
          {
            j = paramBitmap.getWidth();
            i = paramBitmap.getHeight();
            paramBitmap.recycle();
          }
          paramContext = new amz();
          paramContext.Md5 = s.bhK(str);
          paramContext = new b(0, 2, JHA, JHz, paramContext);
          bg.azz().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.h.CyF;
          if (!paramBoolean) {
            break label379;
          }
          k = 1;
          paramContext.a(14811, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(k) });
        }
        AppMethodBeat.o(30337);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WNNoteLogic", localException, "", new Object[0]);
        Log.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      Log.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
      if (paramBoolean) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      label379:
      int k = 0;
    }
  }
  
  public static void aho(int paramInt)
  {
    AppMethodBeat.i(30336);
    JHz = null;
    JHA = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDw();
    JHA = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().alU((String)localObject2);
    if ((localObject2 == null) || (((anb)localObject2).ppH.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      JHz = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, JHA, JHz, null);
      bg.azz().a((q)localObject1, 0);
      AppMethodBeat.o(30336);
      return;
      localObject2 = ((anb)localObject2).ppH.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aml localaml = (aml)((Iterator)localObject2).next();
        Object localObject3 = f.b(localaml);
        if ((!Util.isNullOrNil((String)localObject3)) && (localaml.dataType == 2) && (s.YS((String)localObject3)))
        {
          localObject3 = new amz();
          ((amz)localObject3).Md5 = localaml.LvE;
          ((amz)localObject3).AesKey = localaml.Lvp;
          ((amz)localObject3).LxW = localaml.KuR;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
  }
  
  public static void bbR(String paramString)
  {
    AppMethodBeat.i(30330);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    if (!s.YS(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    o localo = new o(paramString);
    if (!localo.exists())
    {
      AppMethodBeat.o(30330);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 5);
      localJSONObject.put("downloaded", true);
      localJSONObject.put("title", localo.getName());
      localJSONObject.put("content", f.getLengthStr((float)localo.length()));
      localJSONObject.put("iconPath", bbT(s.akC(paramString)));
      localJSONObject.put("localPath", paramString);
      cf(localJSONObject);
      AppMethodBeat.o(30330);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(30330);
    }
  }
  
  public static void bbS(String paramString)
  {
    AppMethodBeat.i(30331);
    Log.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    Log.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.d(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = g.getMessageDigest(paramString.toString().getBytes());
    paramString = ao.cVi() + "/" + paramString + ".png";
    Log.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (s.YS(paramString)) {
      Log.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (s.YS(paramString)) {
      Log.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      cf(localJSONObject);
      AppMethodBeat.o(30331);
      return;
      Log.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.qPi;
    }
  }
  
  public static String bbT(String paramString)
  {
    AppMethodBeat.i(30334);
    paramString = (String)oYD.get(paramString);
    if (paramString == null)
    {
      paramString = (String)oYD.get("unknown");
      AppMethodBeat.o(30334);
      return paramString;
    }
    AppMethodBeat.o(30334);
    return paramString;
  }
  
  public static void bf(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(30332);
    JSONObject localJSONObject = new JSONObject();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str2 = (String)paramArrayList.next();
      try
      {
        localJSONObject.put("type", 2);
        localJSONObject.put("downloaded", true);
        String str1 = com.tencent.mm.plugin.wenote.c.c.fJ(str2, "");
        str2 = com.tencent.mm.plugin.wenote.c.c.fK(str2, "");
        if (!Util.isNullOrNil(str1))
        {
          boolean bool = Util.isNullOrNil(str2);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(30332);
          return;
        }
        localJSONObject.put("bigImagePath", str1);
        localJSONObject.put("localPath", str2);
        cf(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30332);
  }
  
  public static void cb(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30333);
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!Util.isNullOrNil(paramString))
    {
      i = (int)k.gjD().duration;
      j = (int)f.AO(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.W(paramContext, j));
      localJSONObject.put("iconPath", ao.cVg() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.gjD().qPu;
          paramContext = new od();
          paramContext.dUq.type = 6;
          paramContext.dUq.jsonString = localJSONObject.toString();
          paramContext.dUq.dUg = Integer.toString(i);
          EventCenter.instance.publish(paramContext);
          AppMethodBeat.o(30333);
          return;
          paramContext = paramContext;
          Log.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
    }
  }
  
  public static void cc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30338);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      AppMethodBeat.o(30338);
      return;
    }
    cz localcz = new cz();
    wo localwo = new wo();
    localwo.ecC.ecF = paramString;
    localwo.ecC.ecG = localcz;
    localwo.ecC.url = "";
    EventCenter.instance.publish(localwo);
    if (!localwo.ecD.dFE)
    {
      if (localcz.dFZ.dGe == 0) {
        localcz.dFZ.dGe = 2131759217;
      }
      com.tencent.mm.ui.base.h.n(paramContext, localcz.dFZ.dGe, 0);
      AppMethodBeat.o(30338);
      return;
    }
    localcz.dFZ.activity = ((Activity)paramContext);
    localcz.dFZ.dGf = 28;
    EventCenter.instance.publish(localcz);
    AppMethodBeat.o(30338);
  }
  
  private static void cf(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(30328);
    od localod = new od();
    localod.dUq.type = 6;
    localod.dUq.jsonString = paramJSONObject.toString();
    localod.dUq.dUg = "";
    EventCenter.instance.publish(localod);
    AppMethodBeat.o(30328);
  }
  
  public static void p(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(30329);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    if (!s.YS(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.AO(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.W(paramContext, paramInt));
      paramString.put("iconPath", ao.cVg() + "/fav_fileicon_recording.png");
      cf(paramString);
      AppMethodBeat.o(30329);
      return;
    }
    catch (JSONException paramContext)
    {
      Log.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
      AppMethodBeat.o(30329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.h
 * JD-Core Version:    0.7.0.1
 */