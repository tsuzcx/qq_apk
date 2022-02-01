package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.pa;
import com.tencent.mm.f.a.xu;
import com.tencent.mm.f.a.xu.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.u;
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
  public static String QGF;
  public static String QGG;
  public static String QGH;
  public static String QGI;
  public static String QGJ;
  public static String QGK;
  public static String QGL;
  public static String QGM;
  public static String QGN;
  public static String QGO;
  private static String[] QGP;
  private static String[] QGQ;
  private static LinkedList<aoa> QGR;
  private static String QGS;
  private static Map<String, String> saE;
  
  static
  {
    AppMethodBeat.i(30339);
    QGF = ap.dkm() + "/fav_fileicon_video.png";
    QGG = ap.dkm() + "/fav_fileicon_music.png";
    QGH = ap.dkm() + "/fav_list_img_default.png";
    QGI = ap.dkm() + "/fav_fileicon_zip.png";
    QGJ = ap.dkm() + "/fav_fileicon_word.png";
    QGK = ap.dkm() + "/fav_fileicon_ppt.png";
    QGL = ap.dkm() + "/fav_fileicon_xls.png";
    QGM = ap.dkm() + "/fav_fileicon_txt.png";
    QGN = ap.dkm() + "/fav_fileicon_pdf.png";
    QGO = ap.dkm() + "/fav_fileicon_unknow.png";
    saE = new HashMap();
    HashMap localHashMap = new HashMap();
    saE = localHashMap;
    localHashMap.put("avi", QGF);
    saE.put("m4v", QGF);
    saE.put("vob", QGF);
    saE.put("mpeg", QGF);
    saE.put("mpe", QGF);
    saE.put("asx", QGF);
    saE.put("asf", QGF);
    saE.put("f4v", QGF);
    saE.put("flv", QGF);
    saE.put("mkv", QGF);
    saE.put("wmv", QGF);
    saE.put("wm", QGF);
    saE.put("3gp", QGF);
    saE.put("mp4", QGF);
    saE.put("rmvb", QGF);
    saE.put("rm", QGF);
    saE.put("ra", QGF);
    saE.put("ram", QGF);
    saE.put("mp3pro", QGG);
    saE.put("vqf", QGG);
    saE.put("cd", QGG);
    saE.put("md", QGG);
    saE.put("mod", QGG);
    saE.put("vorbis", QGG);
    saE.put("au", QGG);
    saE.put("amr", QGG);
    saE.put("silk", QGG);
    saE.put("wma", QGG);
    saE.put("mmf", QGG);
    saE.put("mid", QGG);
    saE.put("midi", QGG);
    saE.put("mp3", QGG);
    saE.put("aac", QGG);
    saE.put("ape", QGG);
    saE.put("aiff", QGG);
    saE.put("aif", QGG);
    saE.put("jfif", QGH);
    saE.put("tiff", QGH);
    saE.put("tif", QGH);
    saE.put("jpe", QGH);
    saE.put("dib", QGH);
    saE.put("jpeg", QGH);
    saE.put("jpg", QGH);
    saE.put("png", QGH);
    saE.put("bmp", QGH);
    saE.put("gif", QGH);
    saE.put("rar", QGI);
    saE.put("zip", QGI);
    saE.put("7z", QGI);
    saE.put("iso", QGI);
    saE.put("cab", QGI);
    saE.put("doc", QGJ);
    saE.put("docx", QGJ);
    saE.put("ppt", QGK);
    saE.put("pptx", QGK);
    saE.put("xls", QGL);
    saE.put("xlsx", QGL);
    saE.put("txt", QGM);
    saE.put("rtf", QGM);
    saE.put("pdf", QGN);
    saE.put("unknown", QGO);
    QGP = new String[] { "<div>", "<div/>", "<object", "<br", "</" };
    QGQ = new String[] { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
    QGR = null;
    QGS = "";
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
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).urG = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).urM = false;
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
          ((i)localObject2).urG = false;
          ((i)localObject2).urM = false;
          ((i)localObject2).fEa = f.atK(localObject2.toString());
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
        paramContext = new com.tencent.mm.vfs.q(str);
        if (paramContext.ifE())
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
          paramContext = new aoa();
          paramContext.Md5 = u.buc(str);
          paramContext = new b(0, 2, QGS, QGR, paramContext);
          bh.aGY().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.h.IzE;
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
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).a(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      Log.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
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
  
  public static void apg(int paramInt)
  {
    AppMethodBeat.i(30336);
    QGR = null;
    QGS = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cSb();
    QGS = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().atO((String)localObject2);
    if ((localObject2 == null) || (((aoc)localObject2).syG.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      QGR = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, QGS, QGR, null);
      bh.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      AppMethodBeat.o(30336);
      return;
      localObject2 = ((aoc)localObject2).syG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        anm localanm = (anm)((Iterator)localObject2).next();
        Object localObject3 = f.b(localanm);
        if ((!Util.isNullOrNil((String)localObject3)) && (localanm.dataType == 2) && (u.agG((String)localObject3)))
        {
          localObject3 = new aoa();
          ((aoa)localObject3).Md5 = localanm.Sye;
          ((aoa)localObject3).AesKey = localanm.SxP;
          ((aoa)localObject3).SAx = localanm.Rwb;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
  }
  
  public static void bnR(String paramString)
  {
    AppMethodBeat.i(30330);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    if (!u.agG(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(paramString);
    if (!localq.ifE())
    {
      AppMethodBeat.o(30330);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 5);
      localJSONObject.put("downloaded", true);
      localJSONObject.put("title", localq.getName());
      localJSONObject.put("content", f.getLengthStr((float)localq.length()));
      localJSONObject.put("iconPath", bnT(u.asq(paramString)));
      localJSONObject.put("localPath", paramString);
      cq(localJSONObject);
      AppMethodBeat.o(30330);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(30330);
    }
  }
  
  public static void bnS(String paramString)
  {
    AppMethodBeat.i(30331);
    Log.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    Log.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.d(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = g.getMessageDigest(paramString.toString().getBytes());
    paramString = ap.dko() + "/" + paramString + ".png";
    Log.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (u.agG(paramString)) {
      Log.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (u.agG(paramString)) {
      Log.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      cq(localJSONObject);
      AppMethodBeat.o(30331);
      return;
      Log.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.uro;
    }
  }
  
  public static String bnT(String paramString)
  {
    AppMethodBeat.i(30334);
    paramString = (String)saE.get(paramString);
    if (paramString == null)
    {
      paramString = (String)saE.get("unknown");
      AppMethodBeat.o(30334);
      return paramString;
    }
    AppMethodBeat.o(30334);
    return paramString;
  }
  
  public static void bu(ArrayList<String> paramArrayList)
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
        String str1 = com.tencent.mm.plugin.wenote.d.c.fX(str2, "");
        str2 = com.tencent.mm.plugin.wenote.d.c.fY(str2, "");
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
        cq(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30332);
  }
  
  public static void cn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30333);
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!Util.isNullOrNil(paramString))
    {
      i = (int)k.hdr().duration;
      j = (int)f.GW(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.ab(paramContext, j));
      localJSONObject.put("iconPath", ap.dkm() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.hdr().urA;
          paramContext = new pa();
          paramContext.fNS.type = 6;
          paramContext.fNS.jsonString = localJSONObject.toString();
          paramContext.fNS.fNI = Integer.toString(i);
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
  
  public static void co(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30338);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      AppMethodBeat.o(30338);
      return;
    }
    dd localdd = new dd();
    xu localxu = new xu();
    localxu.fWG.fWJ = paramString;
    localxu.fWG.fWK = localdd;
    localxu.fWG.url = "";
    EventCenter.instance.publish(localxu);
    if (!localxu.fWH.fyl)
    {
      if (localdd.fyI.fyO == 0) {
        localdd.fyI.fyO = R.l.favorite_fail_nonsupport;
      }
      com.tencent.mm.ui.base.h.p(paramContext, localdd.fyI.fyO, 0);
      AppMethodBeat.o(30338);
      return;
    }
    localdd.fyI.activity = ((Activity)paramContext);
    localdd.fyI.fyP = 28;
    EventCenter.instance.publish(localdd);
    AppMethodBeat.o(30338);
  }
  
  private static void cq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(30328);
    pa localpa = new pa();
    localpa.fNS.type = 6;
    localpa.fNS.jsonString = paramJSONObject.toString();
    localpa.fNS.fNI = "";
    EventCenter.instance.publish(localpa);
    AppMethodBeat.o(30328);
  }
  
  public static void r(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(30329);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    if (!u.agG(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.GW(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.ab(paramContext, paramInt));
      paramString.put("iconPath", ap.dkm() + "/fav_fileicon_recording.png");
      cq(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.h
 * JD-Core Version:    0.7.0.1
 */