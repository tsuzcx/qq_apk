package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.ms.a;
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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.afy;>;
import org.json.JSONArray;

public abstract class d
{
  public static boolean BCM = false;
  public static String olY = "";
  public static HashMap<String, JSONArray> olZ = new HashMap();
  public static String oma = ao.cip() + "/fav_fileicon_recording.png";
  private static String omb = ao.cip() + "/ofm_file_icon.png";
  private static String omc = ao.cip() + "/app_attach_file_icon_pic.png";
  public static String omd = ao.cip() + "/location_msg.png";
  public static String ome = ao.cip() + "/note_fav_not_support.png";
  public m BCD = null;
  public com.tencent.mm.plugin.fav.a.g BCE;
  public HashMap<String, w> BCF = new HashMap();
  public HashMap<String, String> BCG = new HashMap();
  public HashMap<String, o> BCH = new HashMap();
  public String BCI = "WeNote_0";
  public String BCJ = "";
  public boolean BCK = false;
  public ago BCL = new ago();
  public String BCN = "";
  public int BCO = 0;
  
  public static ago a(String paramString, List<o> paramList, afy paramafy)
  {
    LinkedList localLinkedList = new LinkedList();
    ago localago = new ago();
    if (paramafy != null) {
      localLinkedList.add(paramafy);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label914;
        }
        paramafy = (o)paramString.next();
        if (paramafy != null)
        {
          if (paramafy.omH == null) {
            break;
          }
          localLinkedList.add(paramafy.omH);
        }
      }
      if ((!bt.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cis();
        paramafy = new afy();
        paramafy.VD(8);
        paramafy.aDI("WeNoteHtmlFile");
        paramafy.ux(true);
        paramafy.vp(com.tencent.mm.vfs.i.aMN(paramString));
        paramafy.aDv(".htm");
        localLinkedList.add(paramafy);
        localObject1 = f.b(paramafy);
        if (!com.tencent.mm.vfs.i.eK((String)localObject1)) {
          com.tencent.mm.vfs.i.lC(paramString, (String)localObject1);
        }
        paramafy.aDz((String)localObject1);
      }
    }
    Object localObject1 = new afy();
    Object localObject2 = new afz();
    Object localObject3 = new aga();
    ((aga)localObject3).VH(6);
    ((afz)localObject2).c((aga)localObject3);
    ((afy)localObject1).a((afz)localObject2);
    switch (paramafy.type)
    {
    }
    for (;;)
    {
      ((afy)localObject1).aDI(paramafy.omI);
      localLinkedList.add(localObject1);
      break;
      ((afy)localObject1).VD(2);
      localObject2 = (p)paramafy;
      localObject3 = ((p)localObject2).omG;
      ((afy)localObject1).aDz((String)localObject3);
      if (!bt.isNullOrNil(((p)paramafy).dkb))
      {
        ((afy)localObject1).aDy(paramafy.dkb);
        ((afy)localObject1).aDA(((p)localObject2).drZ);
      }
      for (;;)
      {
        ((afy)localObject1).VD(2);
        break;
        ((afy)localObject1).aDy(f.Tb(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.f.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.a((afy)localObject1));
        ((afy)localObject1).aDA(f.a((afy)localObject1));
      }
      ((afy)localObject1).VD(6);
      localObject2 = (s)paramafy;
      ((afy)localObject1).aDy(paramafy.dkb);
      localObject3 = new agf();
      ((agf)localObject3).aEc(((s)localObject2).hdQ);
      ((agf)localObject3).C(((s)localObject2).lat);
      ((agf)localObject3).B(((s)localObject2).lng);
      ((agf)localObject3).VI((int)((s)localObject2).BDP);
      ((agf)localObject3).aEd(((s)localObject2).goQ);
      ((afy)localObject1).uw(true);
      ((afy)localObject1).ux(true);
      ((afy)localObject1).DgT.c((agf)localObject3);
      continue;
      ((afy)localObject1).VD(8);
      localObject2 = (u)paramafy;
      ((afy)localObject1).aDy(paramafy.dkb);
      ((afy)localObject1).aDz(((u)localObject2).drZ);
      ((afy)localObject1).ux(true);
      ((afy)localObject1).aDl(((u)localObject2).title);
      ((afy)localObject1).aDm(((u)localObject2).content);
      ((afy)localObject1).aDv(((u)localObject2).omK);
      continue;
      ((afy)localObject1).VD(3);
      localObject2 = (v)paramafy;
      ((afy)localObject1).aDy(paramafy.dkb);
      localObject3 = ((v)localObject2).drZ;
      if ((bt.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((afy)localObject1).aDz((String)localObject3);
      ((afy)localObject1).VC(((v)localObject2).dkk);
      ((afy)localObject1).ux(true);
      ((afy)localObject1).aDv(((v)localObject2).omK);
      continue;
      ((afy)localObject1).VD(4);
      localObject2 = (k)paramafy;
      ((afy)localObject1).aDy(paramafy.dkb);
      ((afy)localObject1).aDz(((k)localObject2).drZ);
      ((afy)localObject1).aDA(((k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.e.ano(((k)localObject2).drZ);
      if (localObject3 != null) {
        ((afy)localObject1).VC(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((afy)localObject1).aDv(((k)localObject2).omK);
        break;
        ((afy)localObject1).VC(1);
      }
      if (!BCM)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(14547, new Object[] { Integer.valueOf(6) });
        BCM = true;
      }
      ((afy)localObject1).VD(1);
      ((afy)localObject1).uw(true);
      ((afy)localObject1).ux(true);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)paramafy;
      ((afy)localObject1).aDy(paramafy.dkb);
      ((afy)localObject1).aDm(com.tencent.mm.plugin.wenote.c.b.SY(((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content));
      if ((!bt.isNullOrNil(((afy)localObject1).desc)) && (((afy)localObject1).desc.length() > 1000)) {
        ((afy)localObject1).aDm(((afy)localObject1).desc.substring(0, 1000));
      }
    }
    label914:
    a(localLinkedList, paramList);
    localago.bd(localLinkedList);
    return localago;
  }
  
  private static void a(LinkedList<afy> paramLinkedList, List<o> paramList)
  {
    ad.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        afy localafy = (afy)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bt.isNullOrNil(localafy.DfZ)))
        {
          localafy.aDy(f.Tb(localafy.toString()));
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
          if ((localObject != null) && (((o)localObject).omI != null) && (((o)localObject).omI.equals(localafy.Dhb))) {
            ((o)localObject).dkb = localafy.dkb;
          }
        }
        if ((i > 0) && (!bt.isNullOrNil(localafy.DfZ)) && (!bt.isNullOrNil(localafy.Dgb)))
        {
          localafy.uw(true);
          localafy.ux(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ad.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localafy.dataType) });
          localObject = localafy.Dgx;
          String str2;
          if (com.tencent.mm.vfs.i.eK((String)localObject))
          {
            ad.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.i.aEN((String)localObject);
            str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.vfs.i.aR((String)localObject, 0, 256));
            localafy.aDw(str1);
            localafy.aDx(str2);
            localafy.vp(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = f.b(localafy);
            boolean bool = com.tencent.mm.vfs.i.eK(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localafy.Dhb))) {
              com.tencent.mm.vfs.i.lC((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localafy.Dgz;
            if (!com.tencent.mm.vfs.i.eK((String)localObject)) {
              break label516;
            }
            ad.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.i.aEN((String)localObject);
            str2 = com.tencent.mm.b.g.dE((String)localObject);
            localafy.aDB(str1);
            localafy.aDC(str2);
            localafy.vq(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = f.a(localafy);
            if ((((String)localObject).equals(str1)) || (com.tencent.mm.vfs.i.eK(str1))) {
              break;
            }
            com.tencent.mm.vfs.i.lC((String)localObject, str1);
            break;
            ad.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          ad.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  private void bA(Context paramContext, String paramString)
  {
    paramString = (k)this.BCH.get(paramString);
    if (bt.isNullOrNil(paramString.drZ)) {
      return;
    }
    if (!com.tencent.mm.vfs.i.eK(paramString.drZ))
    {
      localObject = azm(paramString.dkb);
      if (localObject == null)
      {
        ad.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      p((afy)localObject);
    }
    Object localObject = new Intent();
    if (this.BCE == null) {
      ((Intent)localObject).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_detail_fav_path", paramString.drZ);
      ((Intent)localObject).putExtra("key_detail_fav_thumb_path", paramString.thumbPath);
      ((Intent)localObject).putExtra("key_detail_fav_video_duration", paramString.duration);
      ((Intent)localObject).putExtra("key_detail_data_id", paramString.dkb);
      ((Intent)localObject).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject).putExtra("key_detail_fav_video_show_download_status", true);
      if (paramString.omH != null) {
        ((Intent)localObject).putExtra("key_detail_msg_uuid", paramString.omH.hAt);
      }
      com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject, 1);
      return;
      ((Intent)localObject).putExtra("key_detail_info_id", this.BCE.field_localId);
    }
  }
  
  public abstract String a(afy paramafy);
  
  public abstract void a(afy paramafy, String paramString);
  
  public void azl(String paramString) {}
  
  public final afy azm(String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.BCG.get(paramString);
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (o)this.BCH.get(str);
    if (paramString == null)
    {
      ad.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.omH;
  }
  
  public final void b(ms paramms)
  {
    if (paramms.drL == null)
    {
      ad.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
      return;
    }
    String str = paramms.drL.drN;
    o localo = (o)this.BCH.get(str);
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
      bz(paramms.drL.context, str);
      return;
    case 5: 
      bx(paramms.drL.context, str);
      return;
    case 3: 
      by(paramms.drL.context, str);
      return;
    }
    bA(paramms.drL.context, str);
  }
  
  public abstract void bx(Context paramContext, String paramString);
  
  public abstract void by(Context paramContext, String paramString);
  
  public abstract void bz(Context paramContext, String paramString);
  
  public abstract String d(afy paramafy);
  
  public String esx()
  {
    return "";
  }
  
  public final void gD(List<afy> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<afy>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      afy localafy = (afy)localIterator.next();
      o localo = new o();
      localo.omI = localafy.Dhb;
      if (localafy.dataType == 1) {
        localo.omI = "-1";
      }
      if (bt.isNullOrNil(localo.omI))
      {
        ad.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = d(localafy);
        if ((!bt.isNullOrNil(paramList)) && (com.tencent.mm.vfs.i.eK(paramList)))
        {
          f.F(this.BCD.dsa, paramList);
          return;
        }
        p(localafy);
        return;
      }
      if (localo.omI.equals("WeNoteHtmlFile"))
      {
        localObject1 = d(localafy);
        if ((!bt.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.i.eK((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.omO = com.tencent.mm.vfs.i.aMP((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.c.b.SX(localw.omO);
              paramList = (List<afy>)localObject1;
              try
              {
                ad.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localafy.dkb });
                olZ.containsKey(localw.omO);
                ad.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(bt.isNullOrNil(localafy.DfZ)), Boolean.valueOf(bt.isNullOrNil(localafy.Dgb)) });
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
          p(localafy);
          localw.omQ = true;
          ad.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localafy.dkb });
          this.BCG.put(localafy.dkb, localo.omI);
        }
      }
      if (!localo.omI.equals("-1"))
      {
        i = bt.getInt(localo.omI.substring(7), 0);
        j = bt.getInt(this.BCI.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.BCI = ((String)localObject2);
        localo.dkb = localafy.dkb;
        switch (localafy.dataType)
        {
        default: 
          if (localafy.dataType <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).omI = localo.omI;
          ((n)localObject2).type = 0;
          ((n)localObject2).dkb = localo.dkb;
          ((n)localObject2).omH = localafy;
          localObject3 = d(localafy);
          ((n)localObject2).omJ = true;
          ((n)localObject2).drZ = ((String)localObject3);
          ((n)localObject2).jUR = ome;
          ((n)localObject2).title = aj.getContext().getResources().getString(2131758972);
          ((n)localObject2).content = aj.getContext().getResources().getString(2131758937);
          localw.omP.add(localObject2);
          this.BCH.put(localo.omI, localObject2);
          break label23;
        }
      }
      if (!bt.isNullOrNil(localafy.desc)) {
        if ((localw.omP.size() > 0) && (localw.omP.get(localw.omP.size() - 1) != null) && (((o)localw.omP.get(localw.omP.size() - 1)).omI.equals("-1")))
        {
          localObject2 = (t)localw.omP.get(localw.omP.size() - 1);
          ((t)localObject2).content += localafy.desc;
        }
        else
        {
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
          ((t)localObject2).omI = localo.omI;
          ((t)localObject2).content = localafy.desc;
          localw.omP.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).omI = localo.omI;
          ((p)localObject2).type = 2;
          ((p)localObject2).dkb = localo.dkb;
          ((p)localObject2).omH = localafy;
          localObject3 = d(localafy);
          if (!bt.isNullOrNil((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = a(localafy);
            if (!com.tencent.mm.vfs.i.eK(str)) {
              a(localafy, str);
            }
            if (com.tencent.mm.vfs.i.eK((String)localObject3))
            {
              ((p)localObject2).omJ = true;
              c.eS((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).drZ = ((String)localObject4);
              ((p)localObject2).omG = ((String)localObject3);
              localw.omP.add(localObject2);
              this.BCH.put(localo.omI, localObject2);
              break;
              p(localafy);
              ((p)localObject2).omJ = false;
              this.BCG.put(localafy.dkb, localo.omI);
            }
            if (localafy.dataType == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!bt.isNullOrNil(localafy.DfZ))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).wrL = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).omI = localo.omI;
              ((v)localObject2).type = 4;
              ((v)localObject2).dkb = localo.dkb;
              ((v)localObject2).omH = localafy;
              localObject3 = d(localafy);
              if ((bt.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.i.eK((String)localObject3))) {
                break label1315;
              }
              ((v)localObject2).omJ = true;
              ((v)localObject2).jUR = oma;
              ((v)localObject2).length = ((int)f.mI(localafy.duration));
            }
            for (;;)
            {
              ((v)localObject2).drZ = ((String)localObject3);
              ((v)localObject2).omM = f.N(aj.getContext(), (int)f.mI(localafy.duration));
              ((v)localObject2).dkk = localafy.duration;
              localObject3 = new gs();
              ((gs)localObject3).dkc.type = 17;
              ((gs)localObject3).dkc.dke = localafy;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
              ((v)localObject2).dkj = ((gs)localObject3).dkd.ret;
              ((v)localObject2).omK = localafy.Dgo;
              localw.omP.add(localObject2);
              this.BCH.put(localo.omI, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1315:
              p(localafy);
              ((v)localObject2).omJ = false;
              ((v)localObject2).omN = aj.getContext().getString(2131759038);
              this.BCG.put(localafy.dkb, localo.omI);
            }
            localObject4 = new r();
            localObject3 = localafy.DgT.DhC;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new agf();
              ((agf)localObject2).aEc("");
              ((agf)localObject2).aEd("");
              ad.e("MicroMsg.WNNoteBase", "locItem is null, dataItemId:" + localafy.dkb);
            }
            ((r)localObject4).dpb = ((float)((agf)localObject2).lat);
            ((r)localObject4).hil = ((float)((agf)localObject2).lng);
            ((r)localObject4).dpd = ((agf)localObject2).dpd;
            ((r)localObject4).BDM = ((agf)localObject2).label;
            ((r)localObject4).BDN = ((agf)localObject2).dtN;
            ((r)localObject4).BDO = localafy.Dhb;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((s)localObject2).omI = localo.omI;
            ((s)localObject2).type = 3;
            ((s)localObject2).dkb = localo.dkb;
            ((s)localObject2).omH = localafy;
            ((s)localObject2).omJ = true;
            ((s)localObject2).goQ = ((r)localObject4).BDN;
            ((s)localObject2).hdQ = ((r)localObject4).BDM;
            ((s)localObject2).lat = ((r)localObject4).dpb;
            ((s)localObject2).lng = ((r)localObject4).hil;
            ((s)localObject2).BDP = ((r)localObject4).dpd;
            ((s)localObject2).drZ = "";
            localw.omP.add(localObject2);
            this.BCH.put(localo.omI, localObject2);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((u)localObject2).omI = localo.omI;
            ((u)localObject2).type = 5;
            ((u)localObject2).dkb = localo.dkb;
            ((u)localObject2).omH = localafy;
            localObject3 = d(localafy);
            if ((!bt.isNullOrNil((String)localObject3)) && (com.tencent.mm.vfs.i.eK((String)localObject3)))
            {
              ((u)localObject2).omJ = true;
              ((u)localObject2).drZ = ((String)localObject3);
            }
            for (;;)
            {
              ((u)localObject2).jUR = h.azq(localafy.Dgo);
              ((u)localObject2).title = localafy.title;
              ((u)localObject2).content = localafy.desc;
              ((u)localObject2).omK = localafy.Dgo;
              if (bt.isNullOrNil(((u)localObject2).content)) {
                ((u)localObject2).content = f.aS((float)localafy.Dgu);
              }
              localw.omP.add(localObject2);
              this.BCH.put(localo.omI, localObject2);
              break;
              ((u)localObject2).omJ = false;
              this.BCG.put(localafy.dkb, localo.omI);
            }
            localObject2 = new k();
            ((k)localObject2).omI = localo.omI;
            ((k)localObject2).type = 6;
            ((k)localObject2).dkb = localo.dkb;
            ((k)localObject2).omH = localafy;
            if (localafy != null) {
              ((k)localObject2).duration = localafy.duration;
            }
            ((k)localObject2).thumbPath = a(localafy);
            localObject3 = d(localafy);
            ((k)localObject2).drZ = ((String)localObject3);
            if ((!bt.isNullOrNil(((k)localObject2).thumbPath)) && (!com.tencent.mm.vfs.i.eK(((k)localObject2).thumbPath)))
            {
              if (!com.tencent.mm.vfs.i.eK((String)localObject3)) {
                break label2063;
              }
              localObject4 = com.tencent.mm.plugin.fav.ui.e.Yw((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                ad.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.j.f.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((k)localObject2).thumbPath, true);
                if ((bt.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.i.eK((String)localObject3))) {
                  break label2114;
                }
                ((k)localObject2).omJ = true;
                localw.omP.add(localObject2);
                this.BCH.put(localo.omI, localObject2);
              }
              catch (Exception localException3)
              {
                ad.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              a(localafy, ((k)localObject2).thumbPath);
              this.BCG.put(localafy.dkb + "_t", localo.omI);
              continue;
              label2114:
              ((k)localObject2).omJ = false;
              this.BCG.put(localafy.dkb, localo.omI);
            }
          }
        }
      }
    }
    label654:
    label2063:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.omP, paramList, true);
    }
    if (this.BCD.msgId == -1L)
    {
      this.BCF.put(Long.toString(this.BCD.dsa), localw);
      return;
    }
    this.BCF.put(Long.toString(this.BCD.msgId), localw);
  }
  
  public abstract void p(afy paramafy);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */