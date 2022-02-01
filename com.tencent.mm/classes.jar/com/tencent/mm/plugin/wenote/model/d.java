package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.nj.a;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.c.c;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.ajn;>;
import org.json.JSONArray;

public abstract class d
{
  public static boolean EyP = false;
  public static String ptg = "";
  public static HashMap<String, JSONArray> pth = new HashMap();
  public static String pti = ao.cvB() + "/fav_fileicon_recording.png";
  private static String ptj = ao.cvB() + "/ofm_file_icon.png";
  private static String ptk = ao.cvB() + "/app_attach_file_icon_pic.png";
  public static String ptl = ao.cvB() + "/location_msg.png";
  public static String ptm = ao.cvB() + "/note_fav_not_support.png";
  public m EyG = null;
  public com.tencent.mm.plugin.fav.a.g EyH;
  public HashMap<String, w> EyI = new HashMap();
  public HashMap<String, String> EyJ = new HashMap();
  public HashMap<String, o> EyK = new HashMap();
  public String EyL = "WeNote_0";
  public String EyM = "";
  public boolean EyN = false;
  public akd EyO = new akd();
  public String EyQ = "";
  public int EyR = 0;
  
  public static akd a(String paramString, List<o> paramList, ajn paramajn)
  {
    LinkedList localLinkedList = new LinkedList();
    akd localakd = new akd();
    if (paramajn != null) {
      localLinkedList.add(paramajn);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label914;
        }
        paramajn = (o)paramString.next();
        if (paramajn != null)
        {
          if (paramajn.ptR == null) {
            break;
          }
          localLinkedList.add(paramajn.ptR);
        }
      }
      if ((!bt.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cvE();
        paramajn = new ajn();
        paramajn.ZI(8);
        paramajn.aOC("WeNoteHtmlFile");
        paramajn.wl(true);
        paramajn.CG(com.tencent.mm.vfs.i.aYo(paramString));
        paramajn.aOp(".htm");
        localLinkedList.add(paramajn);
        localObject1 = f.b(paramajn);
        if (!com.tencent.mm.vfs.i.fv((String)localObject1)) {
          com.tencent.mm.vfs.i.mz(paramString, (String)localObject1);
        }
        paramajn.aOt((String)localObject1);
      }
    }
    Object localObject1 = new ajn();
    Object localObject2 = new ajo();
    Object localObject3 = new ajp();
    ((ajp)localObject3).ZM(6);
    ((ajo)localObject2).c((ajp)localObject3);
    ((ajn)localObject1).a((ajo)localObject2);
    switch (paramajn.type)
    {
    }
    for (;;)
    {
      ((ajn)localObject1).aOC(paramajn.ptS);
      localLinkedList.add(localObject1);
      break;
      ((ajn)localObject1).ZI(2);
      localObject2 = (p)paramajn;
      localObject3 = ((p)localObject2).ptQ;
      ((ajn)localObject1).aOt((String)localObject3);
      if (!bt.isNullOrNil(((p)paramajn).dsU))
      {
        ((ajn)localObject1).aOs(paramajn.dsU);
        ((ajn)localObject1).aOu(((p)localObject2).dBx);
      }
      for (;;)
      {
        ((ajn)localObject1).ZI(2);
        break;
        ((ajn)localObject1).aOs(f.aaU(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.g.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.a((ajn)localObject1));
        ((ajn)localObject1).aOu(f.a((ajn)localObject1));
      }
      ((ajn)localObject1).ZI(6);
      localObject2 = (s)paramajn;
      ((ajn)localObject1).aOs(paramajn.dsU);
      localObject3 = new aju();
      ((aju)localObject3).aOW(((s)localObject2).hWY);
      ((aju)localObject3).B(((s)localObject2).lat);
      ((aju)localObject3).A(((s)localObject2).lng);
      ((aju)localObject3).ZN((int)((s)localObject2).EzS);
      ((aju)localObject3).aOX(((s)localObject2).jDf);
      ((ajn)localObject1).wk(true);
      ((ajn)localObject1).wl(true);
      ((ajn)localObject1).GhL.c((aju)localObject3);
      continue;
      ((ajn)localObject1).ZI(8);
      localObject2 = (u)paramajn;
      ((ajn)localObject1).aOs(paramajn.dsU);
      ((ajn)localObject1).aOt(((u)localObject2).dBx);
      ((ajn)localObject1).wl(true);
      ((ajn)localObject1).aOf(((u)localObject2).title);
      ((ajn)localObject1).aOg(((u)localObject2).content);
      ((ajn)localObject1).aOp(((u)localObject2).ptU);
      continue;
      ((ajn)localObject1).ZI(3);
      localObject2 = (v)paramajn;
      ((ajn)localObject1).aOs(paramajn.dsU);
      localObject3 = ((v)localObject2).dBx;
      if ((bt.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((ajn)localObject1).aOt((String)localObject3);
      ((ajn)localObject1).ZH(((v)localObject2).dtd);
      ((ajn)localObject1).wl(true);
      ((ajn)localObject1).aOp(((v)localObject2).ptU);
      continue;
      ((ajn)localObject1).ZI(4);
      localObject2 = (k)paramajn;
      ((ajn)localObject1).aOs(paramajn.dsU);
      ((ajn)localObject1).aOt(((k)localObject2).dBx);
      ((ajn)localObject1).aOu(((k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.e.axx(((k)localObject2).dBx);
      if (localObject3 != null) {
        ((ajn)localObject1).ZH(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((ajn)localObject1).aOp(((k)localObject2).ptU);
        break;
        ((ajn)localObject1).ZH(1);
      }
      if (!EyP)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(14547, new Object[] { Integer.valueOf(6) });
        EyP = true;
      }
      ((ajn)localObject1).ZI(1);
      ((ajn)localObject1).wk(true);
      ((ajn)localObject1).wl(true);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)paramajn;
      ((ajn)localObject1).aOs(paramajn.dsU);
      ((ajn)localObject1).aOg(com.tencent.mm.plugin.wenote.c.b.aaR(((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content));
      if ((!bt.isNullOrNil(((ajn)localObject1).desc)) && (((ajn)localObject1).desc.length() > 1000)) {
        ((ajn)localObject1).aOg(((ajn)localObject1).desc.substring(0, 1000));
      }
    }
    label914:
    a(localLinkedList, paramList);
    localakd.bl(localLinkedList);
    return localakd;
  }
  
  private static void a(LinkedList<ajn> paramLinkedList, List<o> paramList)
  {
    ad.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        ajn localajn = (ajn)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bt.isNullOrNil(localajn.GgR)))
        {
          localajn.aOs(f.aaU(localajn.toString()));
          str1 = null;
          localObject = str1;
          if (i - 1 >= 0)
          {
            localObject = str1;
            if (i - 1 < paramList.size())
            {
              localObject = str1;
              if (paramList.size() > 0) {
                localObject = (o)paramList.get(i - 1);
              }
            }
          }
          if ((localObject != null) && (((o)localObject).ptS != null) && (((o)localObject).ptS.equals(localajn.GhT))) {
            ((o)localObject).dsU = localajn.dsU;
          }
        }
        if ((i > 0) && (!bt.isNullOrNil(localajn.GgR)) && (!bt.isNullOrNil(localajn.GgT)))
        {
          localajn.wk(true);
          localajn.wl(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ad.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localajn.dataType) });
          localObject = localajn.Ghp;
          String str2;
          if (com.tencent.mm.vfs.i.fv((String)localObject))
          {
            ad.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.i.aPK((String)localObject);
            str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.vfs.i.aY((String)localObject, 0, 256));
            localajn.aOq(str1);
            localajn.aOr(str2);
            localajn.CG(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = f.b(localajn);
            boolean bool = com.tencent.mm.vfs.i.fv(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localajn.GhT))) {
              com.tencent.mm.vfs.i.mz((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localajn.Ghr;
            if (!com.tencent.mm.vfs.i.fv((String)localObject)) {
              break label516;
            }
            ad.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.i.aPK((String)localObject);
            str2 = com.tencent.mm.b.g.ep((String)localObject);
            localajn.aOv(str1);
            localajn.aOw(str2);
            localajn.CH(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = f.a(localajn);
            if ((((String)localObject).equals(str1)) || (com.tencent.mm.vfs.i.fv(str1))) {
              break;
            }
            com.tencent.mm.vfs.i.mz((String)localObject, str1);
            break;
            ad.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          ad.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  private void bF(Context paramContext, String paramString)
  {
    paramString = (k)this.EyK.get(paramString);
    if (bt.isNullOrNil(paramString.dBx)) {
      return;
    }
    if (!com.tencent.mm.vfs.i.fv(paramString.dBx))
    {
      localObject = aKd(paramString.dsU);
      if (localObject == null)
      {
        ad.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      p((ajn)localObject);
    }
    Object localObject = new Intent();
    if (this.EyH == null) {
      ((Intent)localObject).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_detail_fav_path", paramString.dBx);
      ((Intent)localObject).putExtra("key_detail_fav_thumb_path", paramString.thumbPath);
      ((Intent)localObject).putExtra("key_detail_fav_video_duration", paramString.duration);
      ((Intent)localObject).putExtra("key_detail_data_id", paramString.dsU);
      ((Intent)localObject).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject).putExtra("key_detail_fav_video_show_download_status", true);
      if (paramString.ptR != null) {
        ((Intent)localObject).putExtra("key_detail_msg_uuid", paramString.ptR.iuq);
      }
      com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject, 1);
      return;
      ((Intent)localObject).putExtra("key_detail_info_id", this.EyH.field_localId);
    }
  }
  
  public abstract String a(ajn paramajn);
  
  public abstract void a(ajn paramajn, String paramString);
  
  public void aKc(String paramString) {}
  
  public final ajn aKd(String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.EyJ.get(paramString);
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (o)this.EyK.get(str);
    if (paramString == null)
    {
      ad.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.ptR;
  }
  
  public final void b(nj paramnj)
  {
    if (paramnj.dBj == null)
    {
      ad.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
      return;
    }
    String str = paramnj.dBj.dBl;
    o localo = (o)this.EyK.get(str);
    if (localo == null)
    {
      ad.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
      return;
    }
    ad.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", new Object[] { Integer.valueOf(localo.type) });
    switch (localo.type)
    {
    case 4: 
    default: 
      return;
    case 2: 
      bE(paramnj.dBj.context, str);
      return;
    case 5: 
      bC(paramnj.dBj.context, str);
      return;
    case 3: 
      bD(paramnj.dBj.context, str);
      return;
    }
    bF(paramnj.dBj.context, str);
  }
  
  public abstract void bC(Context paramContext, String paramString);
  
  public abstract void bD(Context paramContext, String paramString);
  
  public abstract void bE(Context paramContext, String paramString);
  
  public abstract String d(ajn paramajn);
  
  public String eWJ()
  {
    return "";
  }
  
  public final void ha(List<ajn> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<ajn>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      ajn localajn = (ajn)localIterator.next();
      o localo = new o();
      localo.ptS = localajn.GhT;
      if (localajn.dataType == 1) {
        localo.ptS = "-1";
      }
      if (bt.isNullOrNil(localo.ptS))
      {
        ad.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = d(localajn);
        if ((!bt.isNullOrNil(paramList)) && (com.tencent.mm.vfs.i.fv(paramList)))
        {
          f.I(this.EyG.dBy, paramList);
          return;
        }
        p(localajn);
        return;
      }
      if (localo.ptS.equals("WeNoteHtmlFile"))
      {
        localObject1 = d(localajn);
        if ((!bt.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.i.fv((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.ptY = com.tencent.mm.vfs.i.aYq((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.c.b.aaQ(localw.ptY);
              paramList = (List<ajn>)localObject1;
              try
              {
                ad.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localajn.dsU });
                pth.containsKey(localw.ptY);
                ad.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(bt.isNullOrNil(localajn.GgR)), Boolean.valueOf(bt.isNullOrNil(localajn.GgT)) });
              }
              catch (Exception localException1) {}
            }
          }
          catch (Exception localException2)
          {
            int i;
            int j;
            Object localObject3;
            Object localObject2;
            Object localObject4;
            String str;
            continue;
          }
          ad.printErrStackTrace("MicroMsg.WNNoteBase", localException1, "", new Object[0]);
          continue;
          p(localajn);
          localw.pua = true;
          ad.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localajn.dsU });
          this.EyJ.put(localajn.dsU, localo.ptS);
        }
      }
      if (!localo.ptS.equals("-1"))
      {
        i = bt.getInt(localo.ptS.substring(7), 0);
        j = bt.getInt(this.EyL.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.EyL = ((String)localObject2);
        localo.dsU = localajn.dsU;
        switch (localajn.dataType)
        {
        default: 
          if (localajn.dataType <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).ptS = localo.ptS;
          ((n)localObject2).type = 0;
          ((n)localObject2).dsU = localo.dsU;
          ((n)localObject2).ptR = localajn;
          localObject3 = d(localajn);
          ((n)localObject2).ptT = true;
          ((n)localObject2).dBx = ((String)localObject3);
          ((n)localObject2).kRE = ptm;
          ((n)localObject2).title = aj.getContext().getResources().getString(2131758972);
          ((n)localObject2).content = aj.getContext().getResources().getString(2131758937);
          localw.ptZ.add(localObject2);
          this.EyK.put(localo.ptS, localObject2);
          break label23;
        }
      }
      if (!bt.isNullOrNil(localajn.desc)) {
        if ((localw.ptZ.size() > 0) && (localw.ptZ.get(localw.ptZ.size() - 1) != null) && (((o)localw.ptZ.get(localw.ptZ.size() - 1)).ptS.equals("-1")))
        {
          localObject2 = (t)localw.ptZ.get(localw.ptZ.size() - 1);
          ((t)localObject2).content += localajn.desc;
        }
        else
        {
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
          ((t)localObject2).ptS = localo.ptS;
          ((t)localObject2).content = localajn.desc;
          localw.ptZ.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).ptS = localo.ptS;
          ((p)localObject2).type = 2;
          ((p)localObject2).dsU = localo.dsU;
          ((p)localObject2).ptR = localajn;
          localObject3 = d(localajn);
          if (!bt.isNullOrNil((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = a(localajn);
            if (!com.tencent.mm.vfs.i.fv(str)) {
              a(localajn, str);
            }
            if (com.tencent.mm.vfs.i.fv((String)localObject3))
            {
              ((p)localObject2).ptT = true;
              c.fp((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).dBx = ((String)localObject4);
              ((p)localObject2).ptQ = ((String)localObject3);
              localw.ptZ.add(localObject2);
              this.EyK.put(localo.ptS, localObject2);
              break;
              p(localajn);
              ((p)localObject2).ptT = false;
              this.EyJ.put(localajn.dsU, localo.ptS);
            }
            if (localajn.dataType == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!bt.isNullOrNil(localajn.GgR))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).yRL = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).ptS = localo.ptS;
              ((v)localObject2).type = 4;
              ((v)localObject2).dsU = localo.dsU;
              ((v)localObject2).ptR = localajn;
              localObject3 = d(localajn);
              if ((bt.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.i.fv((String)localObject3))) {
                break label1315;
              }
              ((v)localObject2).ptT = true;
              ((v)localObject2).kRE = pti;
              ((v)localObject2).length = ((int)f.sv(localajn.duration));
            }
            for (;;)
            {
              ((v)localObject2).dBx = ((String)localObject3);
              ((v)localObject2).ptW = f.R(aj.getContext(), (int)f.sv(localajn.duration));
              ((v)localObject2).dtd = localajn.duration;
              localObject3 = new gw();
              ((gw)localObject3).dsV.type = 17;
              ((gw)localObject3).dsV.dsX = localajn;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
              ((v)localObject2).dtc = ((gw)localObject3).dsW.ret;
              ((v)localObject2).ptU = localajn.Ghg;
              localw.ptZ.add(localObject2);
              this.EyK.put(localo.ptS, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1315:
              p(localajn);
              ((v)localObject2).ptT = false;
              ((v)localObject2).ptX = aj.getContext().getString(2131759038);
              this.EyJ.put(localajn.dsU, localo.ptS);
            }
            localObject4 = new r();
            localObject3 = localajn.GhL.Giu;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new aju();
              ((aju)localObject2).aOW("");
              ((aju)localObject2).aOX("");
              ad.e("MicroMsg.WNNoteBase", "locItem is null, dataItemId:" + localajn.dsU);
            }
            ((r)localObject4).dyz = ((float)((aju)localObject2).lat);
            ((r)localObject4).ibC = ((float)((aju)localObject2).lng);
            ((r)localObject4).dyB = ((aju)localObject2).dyB;
            ((r)localObject4).EzP = ((aju)localObject2).label;
            ((r)localObject4).EzQ = ((aju)localObject2).dDq;
            ((r)localObject4).EzR = localajn.GhT;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((s)localObject2).ptS = localo.ptS;
            ((s)localObject2).type = 3;
            ((s)localObject2).dsU = localo.dsU;
            ((s)localObject2).ptR = localajn;
            ((s)localObject2).ptT = true;
            ((s)localObject2).jDf = ((r)localObject4).EzQ;
            ((s)localObject2).hWY = ((r)localObject4).EzP;
            ((s)localObject2).lat = ((r)localObject4).dyz;
            ((s)localObject2).lng = ((r)localObject4).ibC;
            ((s)localObject2).EzS = ((r)localObject4).dyB;
            ((s)localObject2).dBx = "";
            localw.ptZ.add(localObject2);
            this.EyK.put(localo.ptS, localObject2);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((u)localObject2).ptS = localo.ptS;
            ((u)localObject2).type = 5;
            ((u)localObject2).dsU = localo.dsU;
            ((u)localObject2).ptR = localajn;
            localObject3 = d(localajn);
            if ((!bt.isNullOrNil((String)localObject3)) && (com.tencent.mm.vfs.i.fv((String)localObject3)))
            {
              ((u)localObject2).ptT = true;
              ((u)localObject2).dBx = ((String)localObject3);
            }
            for (;;)
            {
              ((u)localObject2).kRE = h.aKh(localajn.Ghg);
              ((u)localObject2).title = localajn.title;
              ((u)localObject2).content = localajn.desc;
              ((u)localObject2).ptU = localajn.Ghg;
              if (bt.isNullOrNil(((u)localObject2).content)) {
                ((u)localObject2).content = f.ba((float)localajn.Ghm);
              }
              localw.ptZ.add(localObject2);
              this.EyK.put(localo.ptS, localObject2);
              break;
              ((u)localObject2).ptT = false;
              this.EyJ.put(localajn.dsU, localo.ptS);
            }
            localObject2 = new k();
            ((k)localObject2).ptS = localo.ptS;
            ((k)localObject2).type = 6;
            ((k)localObject2).dsU = localo.dsU;
            ((k)localObject2).ptR = localajn;
            if (localajn != null) {
              ((k)localObject2).duration = localajn.duration;
            }
            ((k)localObject2).thumbPath = a(localajn);
            localObject3 = d(localajn);
            ((k)localObject2).dBx = ((String)localObject3);
            if ((!bt.isNullOrNil(((k)localObject2).thumbPath)) && (!com.tencent.mm.vfs.i.fv(((k)localObject2).thumbPath)))
            {
              if (!com.tencent.mm.vfs.i.fv((String)localObject3)) {
                break label2063;
              }
              localObject4 = com.tencent.mm.plugin.fav.ui.e.agH((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                ad.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.l.f.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((k)localObject2).thumbPath, true);
                if ((bt.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.i.fv((String)localObject3))) {
                  break label2114;
                }
                ((k)localObject2).ptT = true;
                localw.ptZ.add(localObject2);
                this.EyK.put(localo.ptS, localObject2);
              }
              catch (Exception localException3)
              {
                ad.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              a(localajn, ((k)localObject2).thumbPath);
              this.EyJ.put(localajn.dsU + "_t", localo.ptS);
              continue;
              label2114:
              ((k)localObject2).ptT = false;
              this.EyJ.put(localajn.dsU, localo.ptS);
            }
          }
        }
      }
    }
    label654:
    label2063:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.ptZ, paramList, true);
    }
    if (this.EyG.msgId == -1L)
    {
      this.EyI.put(Long.toString(this.EyG.dBy), localw);
      return;
    }
    this.EyI.put(Long.toString(this.EyG.msgId), localw);
  }
  
  public abstract void p(ajn paramajn);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */