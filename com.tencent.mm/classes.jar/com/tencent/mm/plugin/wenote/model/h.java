package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.g.a.ur.b;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public static String CVh;
  public static String CVi;
  public static String CVj;
  public static String CVk;
  public static String CVl;
  public static String CVm;
  public static String CVn;
  public static String CVo;
  public static String CVp;
  public static String CVq;
  private static String[] CVr;
  private static String[] CVs;
  private static LinkedList<ahl> CVt;
  private static String CVu;
  private static Map<String, String> nhJ;
  
  static
  {
    AppMethodBeat.i(30339);
    CVh = ao.cpW() + "/fav_fileicon_video.png";
    CVi = ao.cpW() + "/fav_fileicon_music.png";
    CVj = ao.cpW() + "/fav_list_img_default.png";
    CVk = ao.cpW() + "/fav_fileicon_zip.png";
    CVl = ao.cpW() + "/fav_fileicon_word.png";
    CVm = ao.cpW() + "/fav_fileicon_ppt.png";
    CVn = ao.cpW() + "/fav_fileicon_xls.png";
    CVo = ao.cpW() + "/fav_fileicon_txt.png";
    CVp = ao.cpW() + "/fav_fileicon_pdf.png";
    CVq = ao.cpW() + "/fav_fileicon_unknow.png";
    nhJ = new HashMap();
    HashMap localHashMap = new HashMap();
    nhJ = localHashMap;
    localHashMap.put("avi", CVh);
    nhJ.put("m4v", CVh);
    nhJ.put("vob", CVh);
    nhJ.put("mpeg", CVh);
    nhJ.put("mpe", CVh);
    nhJ.put("asx", CVh);
    nhJ.put("asf", CVh);
    nhJ.put("f4v", CVh);
    nhJ.put("flv", CVh);
    nhJ.put("mkv", CVh);
    nhJ.put("wmv", CVh);
    nhJ.put("wm", CVh);
    nhJ.put("3gp", CVh);
    nhJ.put("mp4", CVh);
    nhJ.put("rmvb", CVh);
    nhJ.put("rm", CVh);
    nhJ.put("ra", CVh);
    nhJ.put("ram", CVh);
    nhJ.put("mp3pro", CVi);
    nhJ.put("vqf", CVi);
    nhJ.put("cd", CVi);
    nhJ.put("md", CVi);
    nhJ.put("mod", CVi);
    nhJ.put("vorbis", CVi);
    nhJ.put("au", CVi);
    nhJ.put("amr", CVi);
    nhJ.put("silk", CVi);
    nhJ.put("wma", CVi);
    nhJ.put("mmf", CVi);
    nhJ.put("mid", CVi);
    nhJ.put("midi", CVi);
    nhJ.put("mp3", CVi);
    nhJ.put("aac", CVi);
    nhJ.put("ape", CVi);
    nhJ.put("aiff", CVi);
    nhJ.put("aif", CVi);
    nhJ.put("jfif", CVj);
    nhJ.put("tiff", CVj);
    nhJ.put("tif", CVj);
    nhJ.put("jpe", CVj);
    nhJ.put("dib", CVj);
    nhJ.put("jpeg", CVj);
    nhJ.put("jpg", CVj);
    nhJ.put("png", CVj);
    nhJ.put("bmp", CVj);
    nhJ.put("gif", CVj);
    nhJ.put("rar", CVk);
    nhJ.put("zip", CVk);
    nhJ.put("7z", CVk);
    nhJ.put("iso", CVk);
    nhJ.put("cab", CVk);
    nhJ.put("doc", CVl);
    nhJ.put("docx", CVl);
    nhJ.put("ppt", CVm);
    nhJ.put("pptx", CVm);
    nhJ.put("xls", CVn);
    nhJ.put("xlsx", CVn);
    nhJ.put("txt", CVo);
    nhJ.put("rtf", CVo);
    nhJ.put("pdf", CVp);
    nhJ.put("unknown", CVq);
    CVr = new String[] { "<div>", "<div/>", "<object", "<br", "</" };
    CVs = new String[] { "＜div>", "＜div/>", "＜object", "＜br", "＜/" };
    CVt = null;
    CVu = "";
    AppMethodBeat.o(30339);
  }
  
  public static void Wg(int paramInt)
  {
    AppMethodBeat.i(30336);
    CVt = null;
    CVu = "";
    Object localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZN();
    CVu = (String)localObject2;
    Object localObject1 = new LinkedList();
    localObject2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Xq((String)localObject2);
    if ((localObject2 == null) || (((ahn)localObject2).nxC.size() <= 1)) {
      localObject1 = null;
    }
    for (;;)
    {
      CVt = (LinkedList)localObject1;
      localObject1 = new b(paramInt, 1, CVu, CVt, null);
      az.agi().a((n)localObject1, 0);
      AppMethodBeat.o(30336);
      return;
      localObject2 = ((ahn)localObject2).nxC.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        agx localagx = (agx)((Iterator)localObject2).next();
        Object localObject3 = f.b(localagx);
        if ((!bs.isNullOrNil((String)localObject3)) && (localagx.dataType == 2) && (com.tencent.mm.vfs.i.eA((String)localObject3)))
        {
          localObject3 = new ahl();
          ((ahl)localObject3).Md5 = localagx.Ezw;
          ((ahl)localObject3).AesKey = localagx.Ezh;
          ((ahl)localObject3).EBF = localagx.Ezf;
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
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).oPV = false;
        ((com.tencent.mm.plugin.wenote.model.a.h)localObject1).oQb = false;
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
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oPV = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).oQb = false;
          ((com.tencent.mm.plugin.wenote.model.a.i)localObject2).dhw = f.Xn(localObject2.toString());
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
    String str = com.tencent.mm.sdk.f.b.alY("jpg");
    if (paramBitmap != null) {}
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
        if (!bs.isNullOrNil(str)) {
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
          paramContext = new ahl();
          paramContext.Md5 = com.tencent.mm.vfs.i.aKe(str);
          paramContext = new b(0, 2, CVu, CVt, paramContext);
          az.agi().a(paramContext, 0);
          paramContext = com.tencent.mm.plugin.report.service.h.wUl;
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
        ac.printErrStackTrace("MicroMsg.WNNoteLogic", localException, "", new Object[0]);
        ac.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        if (!paramBoolean) {}
      }
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(i) });
        localObject = "";
        break;
      }
      ac.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
      Object localObject = com.tencent.mm.plugin.report.service.h.wUl;
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
  
  public static void aEF(String paramString)
  {
    AppMethodBeat.i(30330);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30330);
      return;
    }
    if (!com.tencent.mm.vfs.i.eA(paramString))
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
      localJSONObject.put("content", f.aX((float)locale.length()));
      localJSONObject.put("iconPath", aEH(com.tencent.mm.vfs.i.VW(paramString)));
      localJSONObject.put("localPath", paramString);
      bx(localJSONObject);
      AppMethodBeat.o(30330);
      return;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.WNNoteLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(30330);
    }
  }
  
  public static void aEG(String paramString)
  {
    AppMethodBeat.i(30331);
    ac.i("MicroMsg.WNNoteLogic", "insert location run");
    JSONObject localJSONObject = new JSONObject(paramString);
    ac.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
    paramString = new com.tencent.mm.pluginsdk.location.c(-1L, (float)localJSONObject.getDouble("lat"), (float)localJSONObject.getDouble("lng"), localJSONObject.getInt("scale"), 1);
    paramString = g.getMessageDigest(paramString.toString().getBytes());
    paramString = ao.cpY() + "/" + paramString + ".png";
    ac.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[] { paramString });
    if (com.tencent.mm.vfs.i.eA(paramString)) {
      ac.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
    }
    if (com.tencent.mm.vfs.i.eA(paramString)) {
      ac.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
    }
    for (;;)
    {
      localJSONObject.put("localPath", paramString);
      bx(localJSONObject);
      AppMethodBeat.o(30331);
      return;
      ac.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[] { paramString });
      paramString = d.oPD;
    }
  }
  
  public static String aEH(String paramString)
  {
    AppMethodBeat.i(30334);
    paramString = (String)nhJ.get(paramString);
    if (paramString == null)
    {
      paramString = (String)nhJ.get("unknown");
      AppMethodBeat.o(30334);
      return paramString;
    }
    AppMethodBeat.o(30334);
    return paramString;
  }
  
  public static void aP(ArrayList<String> paramArrayList)
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
        String str1 = com.tencent.mm.plugin.wenote.c.c.fe(str2, "");
        str2 = com.tencent.mm.plugin.wenote.c.c.ff(str2, "");
        if (!bs.isNullOrNil(str1))
        {
          boolean bool = bs.isNullOrNil(str2);
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(30332);
          return;
        }
        localJSONObject.put("bigImagePath", str1);
        localJSONObject.put("localPath", str2);
        bx(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        ac.printErrStackTrace("MicroMsg.WNNoteLogic", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30332);
  }
  
  public static void bC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30333);
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    if (!bs.isNullOrNil(paramString))
    {
      i = (int)k.eHT().duration;
      j = (int)f.qw(i);
    }
    try
    {
      localJSONObject.put("downloaded", true);
      localJSONObject.put("length", i);
      localJSONObject.put("lengthStr", f.R(paramContext, j));
      localJSONObject.put("iconPath", ao.cpW() + "/fav_fileicon_recording.png");
      localJSONObject.put("localPath", paramString);
    }
    catch (JSONException paramContext)
    {
      try
      {
        for (;;)
        {
          localJSONObject.put("type", 4);
          i = k.eHT().oPP;
          paramContext = new nc();
          paramContext.dpI.type = 6;
          paramContext.dpI.jsonString = localJSONObject.toString();
          paramContext.dpI.dpy = Integer.toString(i);
          a.GpY.l(paramContext);
          AppMethodBeat.o(30333);
          return;
          paramContext = paramContext;
          ac.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
        }
      }
    }
  }
  
  public static void bD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30338);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
      AppMethodBeat.o(30338);
      return;
    }
    cs localcs = new cs();
    ur localur = new ur();
    localur.dxn.dxq = paramString;
    localur.dxn.dxr = localcs;
    localur.dxn.url = "";
    a.GpY.l(localur);
    if (!localur.dxo.dbS)
    {
      if (localcs.dck.dcp == 0) {
        localcs.dck.dcp = 2131758893;
      }
      com.tencent.mm.ui.base.h.l(paramContext, localcs.dck.dcp, 0);
      AppMethodBeat.o(30338);
      return;
    }
    localcs.dck.activity = ((Activity)paramContext);
    localcs.dck.dcq = 28;
    a.GpY.l(localcs);
    AppMethodBeat.o(30338);
  }
  
  private static void bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(30328);
    nc localnc = new nc();
    localnc.dpI.type = 6;
    localnc.dpI.jsonString = paramJSONObject.toString();
    localnc.dpI.dpy = "";
    a.GpY.l(localnc);
    AppMethodBeat.o(30328);
  }
  
  public static void q(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(30329);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    if (!com.tencent.mm.vfs.i.eA(paramString))
    {
      AppMethodBeat.o(30329);
      return;
    }
    paramString = new JSONObject();
    long l = paramInt;
    try
    {
      paramInt = (int)f.qw(l);
      paramString.put("type", 4);
      paramString.put("downloaded", true);
      paramString.put("length", paramInt);
      paramString.put("lengthStr", f.R(paramContext, paramInt));
      paramString.put("iconPath", ao.cpW() + "/fav_fileicon_recording.png");
      bx(paramString);
      AppMethodBeat.o(30329);
      return;
    }
    catch (JSONException paramContext)
    {
      ac.printErrStackTrace("MicroMsg.WNNoteLogic", paramContext, "", new Object[0]);
      AppMethodBeat.o(30329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.h
 * JD-Core Version:    0.7.0.1
 */