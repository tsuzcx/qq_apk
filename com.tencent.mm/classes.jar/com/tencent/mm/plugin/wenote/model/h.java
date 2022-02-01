package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vk.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static String Eze;
  public static String Ezf;
  public static String Ezg;
  public static String Ezh;
  public static String Ezi;
  public static String Ezj;
  public static String Ezk;
  public static String Ezl;
  public static String Ezm;
  public static String Ezn;
  private static String[] Ezo;
  private static String[] Ezp;
  private static LinkedList<akb> Ezq;
  private static String Ezr;
  private static Map<String, String> nIf;
  
  static
  {
    AppMethodBeat.i(30339);
    Eze = ao.cvB() + "/fav_fileicon_video.png";
    Ezf = ao.cvB() + "/fav_fileicon_music.png";
    Ezg = ao.cvB() + "/fav_list_img_default.png";
    Ezh = ao.cvB() + "/fav_fileicon_zip.png";
    Ezi = ao.cvB() + "/fav_fileicon_word.png";
    Ezj = ao.cvB() + "/fav_fileicon_ppt.png";
    Ezk = ao.cvB() + "/fav_fileicon_xls.png";
    Ezl = ao.cvB() + "/fav_fileicon_txt.png";
    Ezm = ao.cvB() + "/fav_fileicon_pdf.png";
    Ezn = ao.cvB() + "/fav_fileicon_unknow.png";
    nIf = new HashMap();
    HashMap localHashMap = new HashMap();
    nIf = localHashMap;
    localHashMap.put("avi", Eze);
    nIf.put("m4v", Eze);
    nIf.put("vob", Eze);
    nIf.put("mpeg", Eze);
    nIf.put("mpe", Eze);
    nIf.put("asx", Eze);
    nIf.put("asf", Eze);
    nIf.put("f4v", Eze);
    nIf.put("flv", Eze);
    nIf.put("mkv", Eze);
    nIf.put("wmv", Eze);
    nIf.put("wm", Eze);
    nIf.put("3gp", Eze);
    nIf.put("mp4", Eze);
    nIf.put("rmvb", Eze);
    nIf.put("rm", Eze);
    nIf.put("ra", Eze);
    nIf.put("ram", Eze);
    nIf.put("mp3pro", Ezf);
    nIf.put("vqf", Ezf);
    nIf.put("cd", Ezf);
    nIf.put("md", Ezf);
    nIf.put("mod", Ezf);
    nIf.put("vorbis", Ezf);
    nIf.put("au", Ezf);
    nIf.put("amr", Ezf);
    nIf.put("silk", Ezf);
    nIf.put("wma", Ezf);
    nIf.put("mmf", Ezf);
    nIf.put("mid", Ezf);
    nIf.put("midi", Ezf);
    nIf.put("mp3", Ezf);
    nIf.put("aac", Ezf);
    nIf.put("ape", Ezf);
    nIf.put("aiff", Ezf);
    nIf.put("aif", Ezf);
    nIf.put("jfif", Ezg);
    nIf.put("tiff", Ezg);
    nIf.put("tif", Ezg);
    nIf.put("jpe", Ezg);
    nIf.put("dib", Ezg);
    nIf.put("jpeg", Ezg);
    nIf.put("jpg", Ezg);
    nIf.put("png", Ezg);
    nIf.put("bmp", Ezg);
    nIf.put("gif", Ezg);
    nIf.put("rar", Ezh);
    nIf.put("zip", Ezh);
    nIf.put("7z", Ezh);
    nIf.put("iso", Ezh);
    nIf.put("cab", Ezh);
    nIf.put("doc", Ezi);
    nIf.put("docx", Ezi);
    nIf.put("ppt", Ezj);
    nIf.put("pptx", Ezj);
    nIf.put("xls", Ezk);
    nIf.put("xlsx", Ezk);
    nIf.put("txt", Ezl);
    nIf.put("rtf", Ezl);
    nIf.put("pdf", Ezm);
    nIf.put("unknown", Ezn);
    Ezo = new String[] { "<div>", "<div/>", "<object", "<br", "</" };
    Ezp = new String[] { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
    Ezq = null;
    Ezr = "";
    AppMethodBeat.o(30339);
  }
  
  public static void XX(int paramInt)
  {
    AppMethodBeat.i(30336);
    Ezq = null;
    Ezr = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().cer();
    Ezr = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().aaX((String)localObject2);
    if ((localObject2 == null) || (((akd)localObject2).nZa.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      Ezq = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, Ezr, Ezq, null);
      ba.aiU().a((n)localObject1, 0);
      AppMethodBeat.o(30336);
      return;
      localObject2 = ((akd)localObject2).nZa.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ajn localajn = (ajn)((Iterator)localObject2).next();
        Object localObject3 = f.b(localajn);
        if ((!bt.isNullOrNil((String)localObject3)) && (localajn.dataType == 2) && (com.tencent.mm.vfs.i.fv((String)localObject3)))
        {
          localObject3 = new akb();
          ((akb)localObject3).Md5 = localajn.Ghi;
          ((akb)localObject3).AesKey = localajn.GgT;
          ((akb)localObject3).Gjr = localajn.GgR;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
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
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).ptF = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).ptL = false;
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
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content = ((String)localObject1);
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptF = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).ptL = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dsU = f.aaU(localObject2.toString());
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
    String str = com.tencent.mm.sdk.f.b.aqN("jpg");
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
        if (!bt.isNullOrNil(str)) {
          com.tencent.mm.sdk.f.b.k(str, paramContext);
        }
        paramContext = new e(str);
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
          paramContext = new akb();
          paramContext.Md5 = com.tencent.mm.vfs.i.aPK(str);
          paramContext = new b(0, 2, Ezr, Ezq, paramContext);
          ba.aiU().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.g.yhR;
          if (!paramBoolean) {
            break label379;
          }
          k = 1;
          paramContext.f(14811, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(k) });
        }
        AppMethodBeat.o(30337);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.WNNoteLogic", localException, "", new Object[0]);
        ad.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      ad.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.g.yhR;
      if (paramBoolean) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      label379:
      int k = 0;
    }
  }
  
  public static void aKf(String paramString)
  {
    AppMethodBeat.i(30330);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    if (!com.tencent.mm.vfs.i.fv(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    e locale = new e(paramString);
    if (!locale.exists())
    {
      AppMethodBeat.o(30330);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 5);
      localJSONObject.put("downloaded", true);
      localJSONObject.put("title", locale.getName());
      localJSONObject.put("content", f.ba((float)locale.length()));
      localJSONObject.put("iconPath", aKh(com.tencent.mm.vfs.i.ZF(paramString)));
      localJSONObject.put("localPath", paramString);
      bG(localJSONObject);
      AppMethodBeat.o(30330);
      return;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(30330);
    }
  }
  
  public static void aKg(String paramString)
  {
    AppMethodBeat.i(30331);
    ad.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    ad.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.c(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString.toString().getBytes());
    paramString = ao.cvD() + "/" + paramString + ".png";
    ad.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (com.tencent.mm.vfs.i.fv(paramString)) {
      ad.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (com.tencent.mm.vfs.i.fv(paramString)) {
      ad.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      bG(localJSONObject);
      AppMethodBeat.o(30331);
      return;
      ad.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.ptl;
    }
  }
  
  public static String aKh(String paramString)
  {
    AppMethodBeat.i(30334);
    paramString = (String)nIf.get(paramString);
    if (paramString == null)
    {
      paramString = (String)nIf.get("unknown");
      AppMethodBeat.o(30334);
      return paramString;
    }
    AppMethodBeat.o(30334);
    return paramString;
  }
  
  public static void aM(ArrayList<String> paramArrayList)
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
        String str1 = com.tencent.mm.plugin.wenote.c.c.fo(str2, "");
        str2 = com.tencent.mm.plugin.wenote.c.c.fp(str2, "");
        if (!bt.isNullOrNil(str1))
        {
          boolean bool = bt.isNullOrNil(str2);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(30332);
          return;
        }
        localJSONObject.put("bigImagePath", str1);
        localJSONObject.put("localPath", str2);
        bG(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        ad.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30332);
  }
  
  public static void bG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30333);
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!bt.isNullOrNil(paramString))
    {
      i = (int)k.eWM().duration;
      j = (int)f.sv(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.R(paramContext, j));
      localJSONObject.put("iconPath", ao.cvB() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.eWM().ptz;
          paramContext = new nk();
          paramContext.dBv.type = 6;
          paramContext.dBv.jsonString = localJSONObject.toString();
          paramContext.dBv.dBl = Integer.toString(i);
          a.IbL.l(paramContext);
          AppMethodBeat.o(30333);
          return;
          paramContext = paramContext;
          ad.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
    }
  }
  
  private static void bG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(30328);
    nk localnk = new nk();
    localnk.dBv.type = 6;
    localnk.dBv.jsonString = paramJSONObject.toString();
    localnk.dBv.dBl = "";
    a.IbL.l(localnk);
    AppMethodBeat.o(30328);
  }
  
  public static void bH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30338);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      AppMethodBeat.o(30338);
      return;
    }
    cv localcv = new cv();
    vk localvk = new vk();
    localvk.dJz.dJC = paramString;
    localvk.dJz.dJD = localcv;
    localvk.dJz.url = "";
    a.IbL.l(localvk);
    if (!localvk.dJA.dno)
    {
      if (localcv.dnG.dnL == 0) {
        localcv.dnG.dnL = 2131758893;
      }
      com.tencent.mm.ui.base.h.l(paramContext, localcv.dnG.dnL, 0);
      AppMethodBeat.o(30338);
      return;
    }
    localcv.dnG.activity = ((Activity)paramContext);
    localcv.dnG.dnM = 28;
    a.IbL.l(localcv);
    AppMethodBeat.o(30338);
  }
  
  public static void q(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(30329);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    if (!com.tencent.mm.vfs.i.fv(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.sv(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.R(paramContext, paramInt));
      paramString.put("iconPath", ao.cvB() + "/fav_fileicon_recording.png");
      bG(paramString);
      AppMethodBeat.o(30329);
      return;
    }
    catch (JSONException paramContext)
    {
      ad.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
      AppMethodBeat.o(30329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.h
 * JD-Core Version:    0.7.0.1
 */