package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
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
  private static Map<String, String> mwh;
  public static String vwA;
  public static String vwB;
  public static String vwC;
  public static String vwD;
  public static String vwE;
  public static String vwF;
  private static String[] vwG;
  private static String[] vwH;
  private static LinkedList<aco> vwI;
  private static String vwJ;
  public static String vww;
  public static String vwx;
  public static String vwy;
  public static String vwz;
  
  static
  {
    AppMethodBeat.i(26646);
    vww = an.bwZ() + "/fav_fileicon_video.png";
    vwx = an.bwZ() + "/fav_fileicon_music.png";
    vwy = an.bwZ() + "/fav_list_img_default.png";
    vwz = an.bwZ() + "/fav_fileicon_zip.png";
    vwA = an.bwZ() + "/fav_fileicon_word.png";
    vwB = an.bwZ() + "/fav_fileicon_ppt.png";
    vwC = an.bwZ() + "/fav_fileicon_xls.png";
    vwD = an.bwZ() + "/fav_fileicon_txt.png";
    vwE = an.bwZ() + "/fav_fileicon_pdf.png";
    vwF = an.bwZ() + "/fav_fileicon_unknow.png";
    mwh = new HashMap();
    HashMap localHashMap = new HashMap();
    mwh = localHashMap;
    localHashMap.put("avi", vww);
    mwh.put("m4v", vww);
    mwh.put("vob", vww);
    mwh.put("mpeg", vww);
    mwh.put("mpe", vww);
    mwh.put("asx", vww);
    mwh.put("asf", vww);
    mwh.put("f4v", vww);
    mwh.put("flv", vww);
    mwh.put("mkv", vww);
    mwh.put("wmv", vww);
    mwh.put("wm", vww);
    mwh.put("3gp", vww);
    mwh.put("mp4", vww);
    mwh.put("rmvb", vww);
    mwh.put("rm", vww);
    mwh.put("ra", vww);
    mwh.put("ram", vww);
    mwh.put("mp3pro", vwx);
    mwh.put("vqf", vwx);
    mwh.put("cd", vwx);
    mwh.put("md", vwx);
    mwh.put("mod", vwx);
    mwh.put("vorbis", vwx);
    mwh.put("au", vwx);
    mwh.put("amr", vwx);
    mwh.put("silk", vwx);
    mwh.put("wma", vwx);
    mwh.put("mmf", vwx);
    mwh.put("mid", vwx);
    mwh.put("midi", vwx);
    mwh.put("mp3", vwx);
    mwh.put("aac", vwx);
    mwh.put("ape", vwx);
    mwh.put("aiff", vwx);
    mwh.put("aif", vwx);
    mwh.put("jfif", vwy);
    mwh.put("tiff", vwy);
    mwh.put("tif", vwy);
    mwh.put("jpe", vwy);
    mwh.put("dib", vwy);
    mwh.put("jpeg", vwy);
    mwh.put("jpg", vwy);
    mwh.put("png", vwy);
    mwh.put("bmp", vwy);
    mwh.put("gif", vwy);
    mwh.put("rar", vwz);
    mwh.put("zip", vwz);
    mwh.put("7z", vwz);
    mwh.put("iso", vwz);
    mwh.put("cab", vwz);
    mwh.put("doc", vwA);
    mwh.put("docx", vwA);
    mwh.put("ppt", vwB);
    mwh.put("pptx", vwB);
    mwh.put("xls", vwC);
    mwh.put("xlsx", vwC);
    mwh.put("txt", vwD);
    mwh.put("rtf", vwD);
    mwh.put("pdf", vwE);
    mwh.put("unknown", vwF);
    vwG = new String[] { "<div>", "<div/>", "<object", "<br", "</" };
    vwH = new String[] { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
    vwI = null;
    vwJ = "";
    AppMethodBeat.o(26646);
  }
  
  public static void Lb(int paramInt)
  {
    AppMethodBeat.i(26643);
    vwI = null;
    vwJ = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().div();
    vwJ = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ajN((String)localObject2);
    if ((localObject2 == null) || (((acq)localObject2).wVc.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      vwI = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, vwJ, vwI, null);
      aw.Rc().a((m)localObject1, 0);
      AppMethodBeat.o(26643);
      return;
      localObject2 = ((acq)localObject2).wVc.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aca localaca = (aca)((Iterator)localObject2).next();
        Object localObject3 = f.o(localaca);
        if ((!bo.isNullOrNil((String)localObject3)) && (localaca.dataType == 2) && (e.cN((String)localObject3)))
        {
          localObject3 = new aco();
          ((aco)localObject3).Md5 = localaca.wST;
          ((aco)localObject3).AesKey = localaca.wSE;
          ((aco)localObject3).wUW = localaca.wSC;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
  }
  
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> a(Object paramObject, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(26642);
    if (paramObject == null)
    {
      AppMethodBeat.o(26642);
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
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).vwW = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).vxc = false;
        localArrayList.add(i, localObject1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!((String)localObject1).trim().equals("<ThisisNoteNodeObj>"))
        {
          localObject2 = new i();
          ((i)localObject2).content = ((String)localObject1);
          ((i)localObject2).vwW = false;
          ((i)localObject2).vxc = false;
          ((i)localObject2).mBq = f.ajF(localObject2.toString());
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
    AppMethodBeat.o(26642);
    return localArrayList;
  }
  
  public static void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(26644);
    String str = com.tencent.mm.sdk.f.b.TY("jpg");
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.d.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
        if (!bo.isNullOrNil(str)) {
          com.tencent.mm.sdk.f.b.a(str, paramContext);
        }
        paramContext = new com.tencent.mm.vfs.b(str);
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
          paramContext = new aco();
          paramContext.Md5 = e.avP(str);
          paramContext = new b(0, 2, vwJ, vwI, paramContext);
          aw.Rc().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.h.qsU;
          if (!paramBoolean) {
            break label378;
          }
          k = 1;
          paramContext.e(14811, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(k) });
        }
        AppMethodBeat.o(26644);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.WNNoteLogic", localException, "", new Object[0]);
        ab.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
        localObject = com.tencent.mm.plugin.report.service.h.qsU;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      ab.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.h.qsU;
      if (paramBoolean) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      label378:
      int k = 0;
    }
  }
  
  private static void aW(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(26635);
    lj locallj = new lj();
    locallj.cBB.type = 6;
    locallj.cBB.jsonString = paramJSONObject.toString();
    locallj.cBB.cBt = "";
    a.ymk.l(locallj);
    AppMethodBeat.o(26635);
  }
  
  public static void af(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(26639);
    JSONObject localJSONObject = new JSONObject();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str2 = (String)paramArrayList.next();
      try
      {
        localJSONObject.put("type", 2);
        localJSONObject.put("downloaded", true);
        String str1 = com.tencent.mm.plugin.wenote.b.c.hI(str2, "");
        str2 = com.tencent.mm.plugin.wenote.b.c.hJ(str2, "");
        if (!bo.isNullOrNil(str1))
        {
          boolean bool = bo.isNullOrNil(str2);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(26639);
          return;
        }
        localJSONObject.put("bigImagePath", str1);
        localJSONObject.put("localPath", str2);
        aW(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        ab.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(26639);
  }
  
  public static void ajH(String paramString)
  {
    AppMethodBeat.i(26637);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26637);
      return;
    }
    if (!e.cN(paramString))
    {
      AppMethodBeat.o(26637);
      return;
    }
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramString);
    if (!localb.exists())
    {
      AppMethodBeat.o(26637);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 5);
      localJSONObject.put("downloaded", true);
      localJSONObject.put("title", localb.getName());
      localJSONObject.put("content", f.aJ((float)localb.length()));
      localJSONObject.put("iconPath", ajJ(e.cP(paramString)));
      localJSONObject.put("localPath", paramString);
      aW(localJSONObject);
      AppMethodBeat.o(26637);
      return;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(26637);
    }
  }
  
  public static void ajI(String paramString)
  {
    AppMethodBeat.i(26638);
    ab.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    ab.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.b(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = g.w(paramString.toString().getBytes());
    paramString = an.bxb() + "/" + paramString + ".png";
    ab.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (e.cN(paramString)) {
      ab.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (e.cN(paramString)) {
      ab.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      aW(localJSONObject);
      AppMethodBeat.o(26638);
      return;
      ab.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.vwh;
    }
  }
  
  public static String ajJ(String paramString)
  {
    AppMethodBeat.i(26641);
    paramString = (String)mwh.get(paramString);
    if (paramString == null)
    {
      paramString = (String)mwh.get("unknown");
      AppMethodBeat.o(26641);
      return paramString;
    }
    AppMethodBeat.o(26641);
    return paramString;
  }
  
  public static void bo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26640);
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!bo.isNullOrNil(paramString))
    {
      i = (int)k.dhL().duration;
      j = (int)f.hi(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.L(paramContext, j));
      localJSONObject.put("iconPath", an.bwZ() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.dhL().vwR;
          paramContext = new lj();
          paramContext.cBB.type = 6;
          paramContext.cBB.jsonString = localJSONObject.toString();
          paramContext.cBB.cBt = Integer.toString(i);
          a.ymk.l(paramContext);
          AppMethodBeat.o(26640);
          return;
          paramContext = paramContext;
          ab.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
    }
  }
  
  public static void bp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26645);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      AppMethodBeat.o(26645);
      return;
    }
    cm localcm = new cm();
    sm localsm = new sm();
    localsm.cIK.cIN = paramString;
    localsm.cIK.cIO = localcm;
    localsm.cIK.url = "";
    a.ymk.l(localsm);
    if (!localsm.cIL.cpz)
    {
      if (localcm.cpR.cpX == 0) {
        localcm.cpR.cpX = 2131299721;
      }
      com.tencent.mm.ui.base.h.h(paramContext, localcm.cpR.cpX, 0);
      AppMethodBeat.o(26645);
      return;
    }
    localcm.cpR.activity = ((Activity)paramContext);
    localcm.cpR.cpY = 28;
    a.ymk.l(localcm);
    AppMethodBeat.o(26645);
  }
  
  public static void p(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(26636);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26636);
      return;
    }
    if (!e.cN(paramString))
    {
      AppMethodBeat.o(26636);
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.hi(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.L(paramContext, paramInt));
      paramString.put("iconPath", an.bwZ() + "/fav_fileicon_recording.png");
      aW(paramString);
      AppMethodBeat.o(26636);
      return;
    }
    catch (JSONException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
      AppMethodBeat.o(26636);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.h
 * JD-Core Version:    0.7.0.1
 */