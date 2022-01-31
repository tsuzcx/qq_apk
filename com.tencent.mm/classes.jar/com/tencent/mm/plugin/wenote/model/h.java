package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.kv;
import com.tencent.mm.h.a.ra;
import com.tencent.mm.h.a.ra.b;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static Map<String, String> kbL;
  public static String rFN = an.aQK() + "/fav_fileicon_video.png";
  public static String rFO = an.aQK() + "/fav_fileicon_music.png";
  public static String rFP = an.aQK() + "/fav_list_img_default.png";
  public static String rFQ = an.aQK() + "/fav_fileicon_zip.png";
  public static String rFR = an.aQK() + "/fav_fileicon_word.png";
  public static String rFS = an.aQK() + "/fav_fileicon_ppt.png";
  public static String rFT = an.aQK() + "/fav_fileicon_xls.png";
  public static String rFU = an.aQK() + "/fav_fileicon_txt.png";
  public static String rFV = an.aQK() + "/fav_fileicon_pdf.png";
  public static String rFW = an.aQK() + "/fav_fileicon_unknow.png";
  private static String[] rFX = { "<div>", "<div/>", "<object", "<br", "</" };
  private static String[] rFY = { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
  private static LinkedList<yh> rFZ = null;
  private static String rGa = "";
  
  static
  {
    kbL = new HashMap();
    HashMap localHashMap = new HashMap();
    kbL = localHashMap;
    localHashMap.put("avi", rFN);
    kbL.put("m4v", rFN);
    kbL.put("vob", rFN);
    kbL.put("mpeg", rFN);
    kbL.put("mpe", rFN);
    kbL.put("asx", rFN);
    kbL.put("asf", rFN);
    kbL.put("f4v", rFN);
    kbL.put("flv", rFN);
    kbL.put("mkv", rFN);
    kbL.put("wmv", rFN);
    kbL.put("wm", rFN);
    kbL.put("3gp", rFN);
    kbL.put("mp4", rFN);
    kbL.put("rmvb", rFN);
    kbL.put("rm", rFN);
    kbL.put("ra", rFN);
    kbL.put("ram", rFN);
    kbL.put("mp3pro", rFO);
    kbL.put("vqf", rFO);
    kbL.put("cd", rFO);
    kbL.put("md", rFO);
    kbL.put("mod", rFO);
    kbL.put("vorbis", rFO);
    kbL.put("au", rFO);
    kbL.put("amr", rFO);
    kbL.put("silk", rFO);
    kbL.put("wma", rFO);
    kbL.put("mmf", rFO);
    kbL.put("mid", rFO);
    kbL.put("midi", rFO);
    kbL.put("mp3", rFO);
    kbL.put("aac", rFO);
    kbL.put("ape", rFO);
    kbL.put("aiff", rFO);
    kbL.put("aif", rFO);
    kbL.put("jfif", rFP);
    kbL.put("tiff", rFP);
    kbL.put("tif", rFP);
    kbL.put("jpe", rFP);
    kbL.put("dib", rFP);
    kbL.put("jpeg", rFP);
    kbL.put("jpg", rFP);
    kbL.put("png", rFP);
    kbL.put("bmp", rFP);
    kbL.put("gif", rFP);
    kbL.put("rar", rFQ);
    kbL.put("zip", rFQ);
    kbL.put("7z", rFQ);
    kbL.put("iso", rFQ);
    kbL.put("cab", rFQ);
    kbL.put("doc", rFR);
    kbL.put("docx", rFR);
    kbL.put("ppt", rFS);
    kbL.put("pptx", rFS);
    kbL.put("xls", rFT);
    kbL.put("xlsx", rFT);
    kbL.put("txt", rFU);
    kbL.put("rtf", rFU);
    kbL.put("pdf", rFV);
    kbL.put("unknown", rFW);
  }
  
  public static void Di(int paramInt)
  {
    rFZ = null;
    rGa = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cie();
    rGa = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Uy((String)localObject2);
    if ((localObject2 == null) || (((yj)localObject2).sXc.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      rFZ = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, rGa, rFZ, null);
      au.Dk().a((m)localObject1, 0);
      return;
      localObject2 = ((yj)localObject2).sXc.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        xv localxv = (xv)((Iterator)localObject2).next();
        Object localObject3 = f.o(localxv);
        if ((!bk.bl((String)localObject3)) && (localxv.aYU == 2) && (e.bK((String)localObject3)))
        {
          localObject3 = new yh();
          ((yh)localObject3).jnU = localxv.sUX;
          ((yh)localObject3).sRu = localxv.sUI;
          ((yh)localObject3).sWW = localxv.sUG;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
  }
  
  public static void Ut(String paramString)
  {
    if (bk.bl(paramString)) {}
    com.tencent.mm.vfs.b localb;
    do
    {
      do
      {
        return;
      } while (!e.bK(paramString));
      localb = new com.tencent.mm.vfs.b(paramString);
    } while (!localb.exists());
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 5);
      localJSONObject.put("downloaded", true);
      localJSONObject.put("title", localb.getName());
      localJSONObject.put("content", f.ar((float)localb.length()));
      localJSONObject.put("iconPath", Uv(e.bM(paramString)));
      localJSONObject.put("localPath", paramString);
      aA(localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
    }
  }
  
  public static void Uu(String paramString)
  {
    y.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    y.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.b(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = g.o(paramString.toString().getBytes());
    paramString = an.aQM() + "/" + paramString + ".png";
    y.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (e.bK(paramString)) {
      y.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (e.bK(paramString)) {
      y.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      aA(localJSONObject);
      return;
      y.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.rFy;
    }
  }
  
  public static String Uv(String paramString)
  {
    String str = (String)kbL.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = (String)kbL.get("unknown");
    }
    return paramString;
  }
  
  public static void Z(ArrayList<String> paramArrayList)
  {
    JSONObject localJSONObject = new JSONObject();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str2 = (String)paramArrayList.next();
      try
      {
        localJSONObject.put("type", 2);
        localJSONObject.put("downloaded", true);
        String str1 = com.tencent.mm.plugin.wenote.b.c.fH(str2, "");
        str2 = com.tencent.mm.plugin.wenote.b.c.fI(str2, "");
        if (bk.bl(str1)) {
          break;
        }
        if (bk.bl(str2)) {
          return;
        }
        localJSONObject.put("bigImagePath", str1);
        localJSONObject.put("localPath", str2);
        aA(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        y.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
  }
  
  public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> a(Object paramObject, List<String> paramList, boolean paramBoolean)
  {
    if (paramObject == null) {
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
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).rGn = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).rGt = false;
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
          ((i)localObject2).rGn = false;
          ((i)localObject2).rGt = false;
          ((i)localObject2).kgC = f.Ur(localObject2.toString());
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
    return localArrayList;
  }
  
  public static void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    String str = q.pd("jpg");
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.c.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
        if (!bk.bl(str)) {
          q.a(str, paramContext);
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
          paramContext = new yh();
          paramContext.jnU = e.aeY(str);
          paramContext = new b(0, 2, rGa, rFZ, paramContext);
          au.Dk().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.h.nFQ;
          if (!paramBoolean) {
            break label366;
          }
          k = 1;
          paramContext.f(14811, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(k) });
        }
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.WNNoteLogic", localException, "", new Object[0]);
        y.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
        localObject = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      y.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.h.nFQ;
      if (paramBoolean) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      label366:
      int k = 0;
    }
  }
  
  private static void aA(JSONObject paramJSONObject)
  {
    kv localkv = new kv();
    localkv.bTV.type = 6;
    localkv.bTV.bTX = paramJSONObject.toString();
    localkv.bTV.bTN = "";
    a.udP.m(localkv);
  }
  
  public static void bc(Context paramContext, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!bk.bl(paramString))
    {
      i = (int)k.chy().duration;
      j = (int)f.ck(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.B(paramContext, j));
      localJSONObject.put("iconPath", an.aQK() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.chy().rGi;
          paramContext = new kv();
          paramContext.bTV.type = 6;
          paramContext.bTV.bTX = localJSONObject.toString();
          paramContext.bTV.bTN = Integer.toString(i);
          a.udP.m(paramContext);
          return;
          paramContext = paramContext;
          y.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
    }
  }
  
  public static void bd(Context paramContext, String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      return;
    }
    cj localcj = new cj();
    ra localra = new ra();
    localra.cak.can = paramString;
    localra.cak.cao = localcj;
    localra.cak.url = "";
    a.udP.m(localra);
    if (!localra.cal.bIe)
    {
      if (localcj.bIw.bIC == 0) {
        localcj.bIw.bIC = R.l.favorite_fail_nonsupport;
      }
      com.tencent.mm.ui.base.h.h(paramContext, localcj.bIw.bIC, 0);
      return;
    }
    localcj.bIw.activity = ((Activity)paramContext);
    localcj.bIw.bID = 28;
    a.udP.m(localcj);
  }
  
  public static void k(Context paramContext, String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    while (!e.bK(paramString)) {
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.ck(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.B(paramContext, paramInt));
      paramString.put("iconPath", an.aQK() + "/fav_fileicon_recording.png");
      aA(paramString);
      return;
    }
    catch (JSONException paramContext)
    {
      y.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.h
 * JD-Core Version:    0.7.0.1
 */