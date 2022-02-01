package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.qm;
import com.tencent.mm.autogen.a.zn;
import com.tencent.mm.autogen.a.zn.b;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  public static String XAd;
  public static String XAe;
  public static String XAf;
  public static String XAg;
  public static String XAh;
  public static String XAi;
  public static String XAj;
  public static String XAk;
  public static String XAl;
  public static String XAm;
  private static String[] XAn;
  private static String[] XAo;
  private static LinkedList<art> XAp;
  private static String XAq;
  private static Map<String, String> vlV;
  
  static
  {
    AppMethodBeat.i(30339);
    XAd = aq.dQY() + "/fav_fileicon_video.png";
    XAe = aq.dQY() + "/fav_fileicon_music.png";
    XAf = aq.dQY() + "/fav_list_img_default.png";
    XAg = aq.dQY() + "/fav_fileicon_zip.png";
    XAh = aq.dQY() + "/fav_fileicon_word.png";
    XAi = aq.dQY() + "/fav_fileicon_ppt.png";
    XAj = aq.dQY() + "/fav_fileicon_xls.png";
    XAk = aq.dQY() + "/fav_fileicon_txt.png";
    XAl = aq.dQY() + "/fav_fileicon_pdf.png";
    XAm = aq.dQY() + "/fav_fileicon_unknow.png";
    vlV = new HashMap();
    HashMap localHashMap = new HashMap();
    vlV = localHashMap;
    localHashMap.put("avi", XAd);
    vlV.put("m4v", XAd);
    vlV.put("vob", XAd);
    vlV.put("mpeg", XAd);
    vlV.put("mpe", XAd);
    vlV.put("asx", XAd);
    vlV.put("asf", XAd);
    vlV.put("f4v", XAd);
    vlV.put("flv", XAd);
    vlV.put("mkv", XAd);
    vlV.put("wmv", XAd);
    vlV.put("wm", XAd);
    vlV.put("3gp", XAd);
    vlV.put("mp4", XAd);
    vlV.put("rmvb", XAd);
    vlV.put("rm", XAd);
    vlV.put("ra", XAd);
    vlV.put("ram", XAd);
    vlV.put("mp3pro", XAe);
    vlV.put("vqf", XAe);
    vlV.put("cd", XAe);
    vlV.put("md", XAe);
    vlV.put("mod", XAe);
    vlV.put("vorbis", XAe);
    vlV.put("au", XAe);
    vlV.put("amr", XAe);
    vlV.put("silk", XAe);
    vlV.put("wma", XAe);
    vlV.put("mmf", XAe);
    vlV.put("mid", XAe);
    vlV.put("midi", XAe);
    vlV.put("mp3", XAe);
    vlV.put("aac", XAe);
    vlV.put("ape", XAe);
    vlV.put("aiff", XAe);
    vlV.put("aif", XAe);
    vlV.put("jfif", XAf);
    vlV.put("tiff", XAf);
    vlV.put("tif", XAf);
    vlV.put("jpe", XAf);
    vlV.put("dib", XAf);
    vlV.put("jpeg", XAf);
    vlV.put("jpg", XAf);
    vlV.put("png", XAf);
    vlV.put("bmp", XAf);
    vlV.put("gif", XAf);
    vlV.put("rar", XAg);
    vlV.put("zip", XAg);
    vlV.put("7z", XAg);
    vlV.put("iso", XAg);
    vlV.put("cab", XAg);
    vlV.put("doc", XAh);
    vlV.put("docx", XAh);
    vlV.put("ppt", XAi);
    vlV.put("pptx", XAi);
    vlV.put("xls", XAj);
    vlV.put("xlsx", XAj);
    vlV.put("txt", XAk);
    vlV.put("rtf", XAk);
    vlV.put("pdf", XAl);
    vlV.put("unknown", XAm);
    XAn = new String[] { "<div>", "<div/>", "<object", "<br", "</" };
    XAo = new String[] { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
    XAp = null;
    XAq = "";
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
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).xyb = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).xyh = false;
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
          ((i)localObject2).xyb = false;
          ((i)localObject2).xyh = false;
          ((i)localObject2).hIQ = f.anz(localObject2.toString());
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
        paramContext = new u(str);
        if (paramContext.jKS())
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
          paramContext = new art();
          paramContext.Md5 = y.bub(str);
          paramContext = new b(0, 2, XAq, XAp, paramContext);
          bh.aZW().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.h.OAn;
          if (!paramBoolean) {
            break label379;
          }
          k = 1;
          paramContext.b(14811, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(k) });
        }
        AppMethodBeat.o(30337);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WNNoteLogic", localException, "", new Object[0]);
        Log.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).b(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      Log.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (paramBoolean) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).b(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      label379:
      int k = 0;
    }
  }
  
  public static void ave(int paramInt)
  {
    AppMethodBeat.i(30336);
    XAp = null;
    XAq = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwu();
    XAq = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().anD((String)localObject2);
    if ((localObject2 == null) || (((arv)localObject2).vEn.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      XAp = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, XAq, XAp, null);
      bh.aZW().a((p)localObject1, 0);
      AppMethodBeat.o(30336);
      return;
      localObject2 = ((arv)localObject2).vEn.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        arf localarf = (arf)((Iterator)localObject2).next();
        Object localObject3 = f.b(localarf);
        if ((!Util.isNullOrNil((String)localObject3)) && (localarf.dataType == 2) && (y.ZC((String)localObject3)))
        {
          localObject3 = new art();
          ((art)localObject3).Md5 = localarf.ZyW;
          ((art)localObject3).AesKey = localarf.ZyH;
          ((art)localObject3).ZBp = localarf.Ysw;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
  }
  
  public static void bV(ArrayList<String> paramArrayList)
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
        String str1 = com.tencent.mm.plugin.wenote.c.c.gA(str2, "");
        str2 = com.tencent.mm.plugin.wenote.c.c.gB(str2, "");
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
        cL(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30332);
  }
  
  public static void bnF(String paramString)
  {
    AppMethodBeat.i(30330);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    if (!y.ZC(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    u localu = new u(paramString);
    if (!localu.jKS())
    {
      AppMethodBeat.o(30330);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 5);
      localJSONObject.put("downloaded", true);
      localJSONObject.put("title", localu.getName());
      localJSONObject.put("content", f.getLengthStr((float)localu.length()));
      localJSONObject.put("iconPath", bnH(y.alV(paramString)));
      localJSONObject.put("localPath", paramString);
      cL(localJSONObject);
      AppMethodBeat.o(30330);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(30330);
    }
  }
  
  public static void bnG(String paramString)
  {
    AppMethodBeat.i(30331);
    Log.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    Log.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.d(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = g.getMessageDigest(paramString.toString().getBytes());
    paramString = aq.dRa() + "/" + paramString + ".png";
    Log.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (y.ZC(paramString)) {
      Log.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (y.ZC(paramString)) {
      Log.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      cL(localJSONObject);
      AppMethodBeat.o(30331);
      return;
      Log.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.xxJ;
    }
  }
  
  public static String bnH(String paramString)
  {
    AppMethodBeat.i(30334);
    paramString = (String)vlV.get(paramString);
    if (paramString == null)
    {
      paramString = (String)vlV.get("unknown");
      AppMethodBeat.o(30334);
      return paramString;
    }
    AppMethodBeat.o(30334);
    return paramString;
  }
  
  private static void cL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(30328);
    qm localqm = new qm();
    localqm.hTJ.type = 6;
    localqm.hTJ.hTL = paramJSONObject.toString();
    localqm.hTJ.hTA = "";
    localqm.publish();
    AppMethodBeat.o(30328);
  }
  
  public static void cy(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30333);
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!Util.isNullOrNil(paramString))
    {
      i = (int)k.iDY().duration;
      j = (int)f.jh(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.aj(paramContext, j));
      localJSONObject.put("iconPath", aq.dQY() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.iDY().xxV;
          paramContext = new qm();
          paramContext.hTJ.type = 6;
          paramContext.hTJ.hTL = localJSONObject.toString();
          paramContext.hTJ.hTA = Integer.toString(i);
          paramContext.publish();
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
  
  public static void cz(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30338);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      AppMethodBeat.o(30338);
      return;
    }
    dn localdn = new dn();
    zn localzn = new zn();
    localzn.icF.icI = paramString;
    localzn.icF.icJ = localdn;
    localzn.icF.url = "";
    localzn.publish();
    if (!localzn.icG.hCQ)
    {
      if (localdn.hDr.hDx == 0) {
        localdn.hDr.hDx = R.l.favorite_fail_nonsupport;
      }
      com.tencent.mm.ui.base.k.s(paramContext, localdn.hDr.hDx, 0);
      AppMethodBeat.o(30338);
      return;
    }
    localdn.hDr.activity = ((Activity)paramContext);
    localdn.hDr.hDy = 28;
    localdn.publish();
    AppMethodBeat.o(30338);
  }
  
  public static void t(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(30329);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    if (!y.ZC(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.jh(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.aj(paramContext, paramInt));
      paramString.put("iconPath", aq.dQY() + "/fav_fileicon_recording.png");
      cL(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.h
 * JD-Core Version:    0.7.0.1
 */