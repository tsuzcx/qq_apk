package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.uh.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.ago;
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
  public static String BDb;
  public static String BDc;
  public static String BDd;
  public static String BDe;
  public static String BDf;
  public static String BDg;
  public static String BDh;
  public static String BDi;
  public static String BDj;
  public static String BDk;
  private static String[] BDl;
  private static String[] BDm;
  private static LinkedList<agm> BDn;
  private static String BDo;
  private static Map<String, String> mFE;
  
  static
  {
    AppMethodBeat.i(30339);
    BDb = ao.cip() + "/fav_fileicon_video.png";
    BDc = ao.cip() + "/fav_fileicon_music.png";
    BDd = ao.cip() + "/fav_list_img_default.png";
    BDe = ao.cip() + "/fav_fileicon_zip.png";
    BDf = ao.cip() + "/fav_fileicon_word.png";
    BDg = ao.cip() + "/fav_fileicon_ppt.png";
    BDh = ao.cip() + "/fav_fileicon_xls.png";
    BDi = ao.cip() + "/fav_fileicon_txt.png";
    BDj = ao.cip() + "/fav_fileicon_pdf.png";
    BDk = ao.cip() + "/fav_fileicon_unknow.png";
    mFE = new HashMap();
    HashMap localHashMap = new HashMap();
    mFE = localHashMap;
    localHashMap.put("avi", BDb);
    mFE.put("m4v", BDb);
    mFE.put("vob", BDb);
    mFE.put("mpeg", BDb);
    mFE.put("mpe", BDb);
    mFE.put("asx", BDb);
    mFE.put("asf", BDb);
    mFE.put("f4v", BDb);
    mFE.put("flv", BDb);
    mFE.put("mkv", BDb);
    mFE.put("wmv", BDb);
    mFE.put("wm", BDb);
    mFE.put("3gp", BDb);
    mFE.put("mp4", BDb);
    mFE.put("rmvb", BDb);
    mFE.put("rm", BDb);
    mFE.put("ra", BDb);
    mFE.put("ram", BDb);
    mFE.put("mp3pro", BDc);
    mFE.put("vqf", BDc);
    mFE.put("cd", BDc);
    mFE.put("md", BDc);
    mFE.put("mod", BDc);
    mFE.put("vorbis", BDc);
    mFE.put("au", BDc);
    mFE.put("amr", BDc);
    mFE.put("silk", BDc);
    mFE.put("wma", BDc);
    mFE.put("mmf", BDc);
    mFE.put("mid", BDc);
    mFE.put("midi", BDc);
    mFE.put("mp3", BDc);
    mFE.put("aac", BDc);
    mFE.put("ape", BDc);
    mFE.put("aiff", BDc);
    mFE.put("aif", BDc);
    mFE.put("jfif", BDd);
    mFE.put("tiff", BDd);
    mFE.put("tif", BDd);
    mFE.put("jpe", BDd);
    mFE.put("dib", BDd);
    mFE.put("jpeg", BDd);
    mFE.put("jpg", BDd);
    mFE.put("png", BDd);
    mFE.put("bmp", BDd);
    mFE.put("gif", BDd);
    mFE.put("rar", BDe);
    mFE.put("zip", BDe);
    mFE.put("7z", BDe);
    mFE.put("iso", BDe);
    mFE.put("cab", BDe);
    mFE.put("doc", BDf);
    mFE.put("docx", BDf);
    mFE.put("ppt", BDg);
    mFE.put("pptx", BDg);
    mFE.put("xls", BDh);
    mFE.put("xlsx", BDh);
    mFE.put("txt", BDi);
    mFE.put("rtf", BDi);
    mFE.put("pdf", BDj);
    mFE.put("unknown", BDk);
    BDl = new String[] { "<div>", "<div/>", "<object", "<br", "</" };
    BDm = new String[] { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
    BDn = null;
    BDo = "";
    AppMethodBeat.o(30339);
  }
  
  public static void TY(int paramInt)
  {
    AppMethodBeat.i(30336);
    BDn = null;
    BDo = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSy();
    BDo = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().Te((String)localObject2);
    if ((localObject2 == null) || (((ago)localObject2).mVb.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      BDn = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, BDo, BDn, null);
      az.aeS().a((n)localObject1, 0);
      AppMethodBeat.o(30336);
      return;
      localObject2 = ((ago)localObject2).mVb.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        afy localafy = (afy)((Iterator)localObject2).next();
        Object localObject3 = f.b(localafy);
        if ((!bt.isNullOrNil((String)localObject3)) && (localafy.dataType == 2) && (com.tencent.mm.vfs.i.eK((String)localObject3)))
        {
          localObject3 = new agm();
          ((agm)localObject3).Md5 = localafy.Dgq;
          ((agm)localObject3).AesKey = localafy.Dgb;
          ((agm)localObject3).Diz = localafy.DfZ;
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
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).omv = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).omB = false;
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
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).omv = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).omB = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dkb = f.Tb(localObject2.toString());
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
    String str = com.tencent.mm.sdk.f.b.ahd("jpg");
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
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
          paramContext = new agm();
          paramContext.Md5 = com.tencent.mm.vfs.i.aEN(str);
          paramContext = new b(0, 2, BDo, BDn, paramContext);
          az.aeS().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.h.vKh;
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
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      ad.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.h.vKh;
      if (paramBoolean) {}
      for (i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      label379:
      int k = 0;
    }
  }
  
  public static void aD(ArrayList<String> paramArrayList)
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
        String str1 = com.tencent.mm.plugin.wenote.c.c.eR(str2, "");
        str2 = com.tencent.mm.plugin.wenote.c.c.eS(str2, "");
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
        bw(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        ad.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30332);
  }
  
  public static void azo(String paramString)
  {
    AppMethodBeat.i(30330);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    if (!com.tencent.mm.vfs.i.eK(paramString))
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
      localJSONObject.put("content", f.aS((float)locale.length()));
      localJSONObject.put("iconPath", azq(com.tencent.mm.vfs.i.RK(paramString)));
      localJSONObject.put("localPath", paramString);
      bw(localJSONObject);
      AppMethodBeat.o(30330);
      return;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(30330);
    }
  }
  
  public static void azp(String paramString)
  {
    AppMethodBeat.i(30331);
    ad.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    ad.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.c(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = g.getMessageDigest(paramString.toString().getBytes());
    paramString = ao.cir() + "/" + paramString + ".png";
    ad.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (com.tencent.mm.vfs.i.eK(paramString)) {
      ad.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (com.tencent.mm.vfs.i.eK(paramString)) {
      ad.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      bw(localJSONObject);
      AppMethodBeat.o(30331);
      return;
      ad.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.omd;
    }
  }
  
  public static String azq(String paramString)
  {
    AppMethodBeat.i(30334);
    paramString = (String)mFE.get(paramString);
    if (paramString == null)
    {
      paramString = (String)mFE.get("unknown");
      AppMethodBeat.o(30334);
      return paramString;
    }
    AppMethodBeat.o(30334);
    return paramString;
  }
  
  public static void bB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30333);
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!bt.isNullOrNil(paramString))
    {
      i = (int)k.esA().duration;
      j = (int)f.mI(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.N(paramContext, j));
      localJSONObject.put("iconPath", ao.cip() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.esA().omp;
          paramContext = new mt();
          paramContext.drX.type = 6;
          paramContext.drX.jsonString = localJSONObject.toString();
          paramContext.drX.drN = Integer.toString(i);
          a.ESL.l(paramContext);
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
  
  public static void bC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30338);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      AppMethodBeat.o(30338);
      return;
    }
    cs localcs = new cs();
    uh localuh = new uh();
    localuh.dzB.dzE = paramString;
    localuh.dzB.dzF = localcs;
    localuh.dzB.url = "";
    a.ESL.l(localuh);
    if (!localuh.dzC.dew)
    {
      if (localcs.deQ.deV == 0) {
        localcs.deQ.deV = 2131758893;
      }
      com.tencent.mm.ui.base.h.j(paramContext, localcs.deQ.deV, 0);
      AppMethodBeat.o(30338);
      return;
    }
    localcs.deQ.activity = ((Activity)paramContext);
    localcs.deQ.deW = 28;
    a.ESL.l(localcs);
    AppMethodBeat.o(30338);
  }
  
  private static void bw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(30328);
    mt localmt = new mt();
    localmt.drX.type = 6;
    localmt.drX.jsonString = paramJSONObject.toString();
    localmt.drX.drN = "";
    a.ESL.l(localmt);
    AppMethodBeat.o(30328);
  }
  
  public static void q(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(30329);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    if (!com.tencent.mm.vfs.i.eK(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.mI(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.N(paramContext, paramInt));
      paramString.put("iconPath", ao.cip() + "/fav_fileicon_recording.png");
      bw(paramString);
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