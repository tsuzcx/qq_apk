package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vo.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  public static String ERA;
  public static String ERB;
  public static String ERC;
  public static String ERD;
  public static String ERE;
  public static String ERF;
  public static String ERG;
  public static String ERH;
  public static String ERI;
  public static String ERJ;
  private static String[] ERK;
  private static String[] ERL;
  private static LinkedList<akl> ERM;
  private static String ERN;
  private static Map<String, String> nNI;
  
  static
  {
    AppMethodBeat.i(30339);
    ERA = ao.cxc() + "/fav_fileicon_video.png";
    ERB = ao.cxc() + "/fav_fileicon_music.png";
    ERC = ao.cxc() + "/fav_list_img_default.png";
    ERD = ao.cxc() + "/fav_fileicon_zip.png";
    ERE = ao.cxc() + "/fav_fileicon_word.png";
    ERF = ao.cxc() + "/fav_fileicon_ppt.png";
    ERG = ao.cxc() + "/fav_fileicon_xls.png";
    ERH = ao.cxc() + "/fav_fileicon_txt.png";
    ERI = ao.cxc() + "/fav_fileicon_pdf.png";
    ERJ = ao.cxc() + "/fav_fileicon_unknow.png";
    nNI = new HashMap();
    HashMap localHashMap = new HashMap();
    nNI = localHashMap;
    localHashMap.put("avi", ERA);
    nNI.put("m4v", ERA);
    nNI.put("vob", ERA);
    nNI.put("mpeg", ERA);
    nNI.put("mpe", ERA);
    nNI.put("asx", ERA);
    nNI.put("asf", ERA);
    nNI.put("f4v", ERA);
    nNI.put("flv", ERA);
    nNI.put("mkv", ERA);
    nNI.put("wmv", ERA);
    nNI.put("wm", ERA);
    nNI.put("3gp", ERA);
    nNI.put("mp4", ERA);
    nNI.put("rmvb", ERA);
    nNI.put("rm", ERA);
    nNI.put("ra", ERA);
    nNI.put("ram", ERA);
    nNI.put("mp3pro", ERB);
    nNI.put("vqf", ERB);
    nNI.put("cd", ERB);
    nNI.put("md", ERB);
    nNI.put("mod", ERB);
    nNI.put("vorbis", ERB);
    nNI.put("au", ERB);
    nNI.put("amr", ERB);
    nNI.put("silk", ERB);
    nNI.put("wma", ERB);
    nNI.put("mmf", ERB);
    nNI.put("mid", ERB);
    nNI.put("midi", ERB);
    nNI.put("mp3", ERB);
    nNI.put("aac", ERB);
    nNI.put("ape", ERB);
    nNI.put("aiff", ERB);
    nNI.put("aif", ERB);
    nNI.put("jfif", ERC);
    nNI.put("tiff", ERC);
    nNI.put("tif", ERC);
    nNI.put("jpe", ERC);
    nNI.put("dib", ERC);
    nNI.put("jpeg", ERC);
    nNI.put("jpg", ERC);
    nNI.put("png", ERC);
    nNI.put("bmp", ERC);
    nNI.put("gif", ERC);
    nNI.put("rar", ERD);
    nNI.put("zip", ERD);
    nNI.put("7z", ERD);
    nNI.put("iso", ERD);
    nNI.put("cab", ERD);
    nNI.put("doc", ERE);
    nNI.put("docx", ERE);
    nNI.put("ppt", ERF);
    nNI.put("pptx", ERF);
    nNI.put("xls", ERG);
    nNI.put("xlsx", ERG);
    nNI.put("txt", ERH);
    nNI.put("rtf", ERH);
    nNI.put("pdf", ERI);
    nNI.put("unknown", ERJ);
    ERK = new String[] { "<div>", "<div/>", "<object", "<br", "</" };
    ERL = new String[] { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
    ERM = null;
    ERN = "";
    AppMethodBeat.o(30339);
  }
  
  public static void YD(int paramInt)
  {
    AppMethodBeat.i(30336);
    ERM = null;
    ERN = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().cfG();
    ERN = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().abO((String)localObject2);
    if ((localObject2 == null) || (((akn)localObject2).oeJ.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      ERM = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, ERN, ERM, null);
      bc.ajj().a((n)localObject1, 0);
      AppMethodBeat.o(30336);
      return;
      localObject2 = ((akn)localObject2).oeJ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ajx localajx = (ajx)((Iterator)localObject2).next();
        Object localObject3 = f.b(localajx);
        if ((!bu.isNullOrNil((String)localObject3)) && (localajx.dataType == 2) && (o.fB((String)localObject3)))
        {
          localObject3 = new akl();
          ((akl)localObject3).Md5 = localajx.GzR;
          ((akl)localObject3).AesKey = localajx.GzC;
          ((akl)localObject3).GCa = localajx.GzA;
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
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).pAj = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).pAp = false;
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
          ((i)localObject2).pAj = false;
          ((i)localObject2).pAp = false;
          ((i)localObject2).dua = f.abL(localObject2.toString());
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
    String str = com.tencent.mm.sdk.f.b.arS("jpg");
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
        if (!bu.isNullOrNil(str)) {
          com.tencent.mm.sdk.f.b.k(str, paramContext);
        }
        paramContext = new com.tencent.mm.vfs.k(str);
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
          paramContext = new akl();
          paramContext.Md5 = o.aRh(str);
          paramContext = new b(0, 2, ERN, ERM, paramContext);
          bc.ajj().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.g.yxI;
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
        ae.printErrStackTrace("MicroMsg.WNNoteLogic", localException, "", new Object[0]);
        ae.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      ae.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.g.yxI;
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
  
  public static void aLB(String paramString)
  {
    AppMethodBeat.i(30330);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    if (!o.fB(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(paramString);
    if (!localk.exists())
    {
      AppMethodBeat.o(30330);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 5);
      localJSONObject.put("downloaded", true);
      localJSONObject.put("title", localk.getName());
      localJSONObject.put("content", f.ba((float)localk.length()));
      localJSONObject.put("iconPath", aLD(o.aaw(paramString)));
      localJSONObject.put("localPath", paramString);
      bG(localJSONObject);
      AppMethodBeat.o(30330);
      return;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(30330);
    }
  }
  
  public static void aLC(String paramString)
  {
    AppMethodBeat.i(30331);
    ae.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    ae.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.c(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString.toString().getBytes());
    paramString = ao.cxe() + "/" + paramString + ".png";
    ae.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (o.fB(paramString)) {
      ae.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (o.fB(paramString)) {
      ae.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      bG(localJSONObject);
      AppMethodBeat.o(30331);
      return;
      ae.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.pzR;
    }
  }
  
  public static String aLD(String paramString)
  {
    AppMethodBeat.i(30334);
    paramString = (String)nNI.get(paramString);
    if (paramString == null)
    {
      paramString = (String)nNI.get("unknown");
      AppMethodBeat.o(30334);
      return paramString;
    }
    AppMethodBeat.o(30334);
    return paramString;
  }
  
  public static void aN(ArrayList<String> paramArrayList)
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
        String str1 = com.tencent.mm.plugin.wenote.c.c.fs(str2, "");
        str2 = com.tencent.mm.plugin.wenote.c.c.ft(str2, "");
        if (!bu.isNullOrNil(str1))
        {
          boolean bool = bu.isNullOrNil(str2);
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
        ae.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30332);
  }
  
  private static void bG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(30328);
    nl localnl = new nl();
    localnl.dCA.type = 6;
    localnl.dCA.jsonString = paramJSONObject.toString();
    localnl.dCA.dCq = "";
    a.IvT.l(localnl);
    AppMethodBeat.o(30328);
  }
  
  public static void bH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30333);
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!bu.isNullOrNil(paramString))
    {
      i = (int)k.fay().duration;
      j = (int)f.sI(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.R(paramContext, j));
      localJSONObject.put("iconPath", ao.cxc() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.fay().pAd;
          paramContext = new nl();
          paramContext.dCA.type = 6;
          paramContext.dCA.jsonString = localJSONObject.toString();
          paramContext.dCA.dCq = Integer.toString(i);
          a.IvT.l(paramContext);
          AppMethodBeat.o(30333);
          return;
          paramContext = paramContext;
          ae.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
    }
  }
  
  public static void bI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30338);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      AppMethodBeat.o(30338);
      return;
    }
    cw localcw = new cw();
    vo localvo = new vo();
    localvo.dKN.dKQ = paramString;
    localvo.dKN.dKR = localcw;
    localvo.dKN.url = "";
    a.IvT.l(localvo);
    if (!localvo.dKO.doq)
    {
      if (localcw.doL.doQ == 0) {
        localcw.doL.doQ = 2131758893;
      }
      com.tencent.mm.ui.base.h.l(paramContext, localcw.doL.doQ, 0);
      AppMethodBeat.o(30338);
      return;
    }
    localcw.doL.activity = ((Activity)paramContext);
    localcw.doL.doR = 28;
    a.IvT.l(localcw);
    AppMethodBeat.o(30338);
  }
  
  public static void p(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(30329);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    if (!o.fB(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.sI(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.R(paramContext, paramInt));
      paramString.put("iconPath", ao.cxc() + "/fav_fileicon_recording.png");
      bG(paramString);
      AppMethodBeat.o(30329);
      return;
    }
    catch (JSONException paramContext)
    {
      ae.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
      AppMethodBeat.o(30329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.h
 * JD-Core Version:    0.7.0.1
 */