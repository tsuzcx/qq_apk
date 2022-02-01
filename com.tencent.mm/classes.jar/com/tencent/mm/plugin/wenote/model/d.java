package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.wenote.c.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.aml;>;
import org.json.JSONArray;

public abstract class d
{
  public static boolean JGX = false;
  public static String qPd = "";
  public static HashMap<String, JSONArray> qPe = new HashMap();
  public static String qPf = ao.cVg() + "/fav_fileicon_recording.png";
  private static String qPg = ao.cVg() + "/ofm_file_icon.png";
  private static String qPh = ao.cVg() + "/app_attach_file_icon_pic.png";
  public static String qPi = ao.cVg() + "/location_msg.png";
  public static String qPj = ao.cVg() + "/note_fav_not_support.png";
  public m JGO = null;
  public com.tencent.mm.plugin.fav.a.g JGP;
  public HashMap<String, w> JGQ = new HashMap();
  public HashMap<String, String> JGR = new HashMap();
  public HashMap<String, com.tencent.mm.plugin.wenote.model.a.o> JGS = new HashMap();
  public String JGT = "WeNote_0";
  public String JGU = "";
  public boolean JGV = false;
  public anb JGW = new anb();
  public String JGY = "";
  public int JGZ = 0;
  
  public static anb a(String paramString, List<com.tencent.mm.plugin.wenote.model.a.o> paramList, aml paramaml)
  {
    LinkedList localLinkedList = new LinkedList();
    anb localanb = new anb();
    if (paramaml != null) {
      localLinkedList.add(paramaml);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label935;
        }
        paramaml = (com.tencent.mm.plugin.wenote.model.a.o)paramString.next();
        if (paramaml != null)
        {
          if (paramaml.qPM == null) {
            break;
          }
          if (paramaml.qPM.dataType == 20) {
            paramaml.qPM.ajd(3);
          }
          localLinkedList.add(paramaml.qPM);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cVj();
        paramaml = new aml();
        paramaml.ajd(8);
        paramaml.bgC("WeNoteHtmlFile");
        paramaml.At(true);
        paramaml.Mu(com.tencent.mm.vfs.s.boW(paramString));
        paramaml.bgp(".htm");
        localLinkedList.add(paramaml);
        localObject1 = f.b(paramaml);
        if (!com.tencent.mm.vfs.s.YS((String)localObject1)) {
          com.tencent.mm.vfs.s.nw(paramString, (String)localObject1);
        }
        paramaml.bgt((String)localObject1);
      }
    }
    Object localObject1 = new aml();
    Object localObject2 = new amm();
    Object localObject3 = new amn();
    ((amn)localObject3).ajh(6);
    ((amm)localObject2).c((amn)localObject3);
    ((aml)localObject1).a((amm)localObject2);
    switch (paramaml.type)
    {
    }
    for (;;)
    {
      ((aml)localObject1).bgC(paramaml.qPN);
      localLinkedList.add(localObject1);
      break;
      ((aml)localObject1).ajd(2);
      localObject2 = (p)paramaml;
      localObject3 = ((p)localObject2).qPL;
      ((aml)localObject1).bgt((String)localObject3);
      if (!Util.isNullOrNil(((p)paramaml).dLl))
      {
        ((aml)localObject1).bgs(paramaml.dLl);
        ((aml)localObject1).bgu(((p)localObject2).dUs);
      }
      for (;;)
      {
        ((aml)localObject1).ajd(2);
        break;
        ((aml)localObject1).bgs(f.alR(localObject2.toString()));
        BitmapUtil.createThumbNail((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.a((aml)localObject1), true);
        ((aml)localObject1).bgu(f.a((aml)localObject1));
      }
      ((aml)localObject1).ajd(6);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.s)paramaml;
      ((aml)localObject1).bgs(paramaml.dLl);
      localObject3 = new ams();
      ((ams)localObject3).bgW(((com.tencent.mm.plugin.wenote.model.a.s)localObject2).iUO);
      ((ams)localObject3).C(((com.tencent.mm.plugin.wenote.model.a.s)localObject2).lat);
      ((ams)localObject3).B(((com.tencent.mm.plugin.wenote.model.a.s)localObject2).lng);
      ((ams)localObject3).aji((int)((com.tencent.mm.plugin.wenote.model.a.s)localObject2).JIb);
      ((ams)localObject3).bgX(((com.tencent.mm.plugin.wenote.model.a.s)localObject2).kHV);
      ((aml)localObject1).As(true);
      ((aml)localObject1).At(true);
      ((aml)localObject1).Lwh.c((ams)localObject3);
      continue;
      ((aml)localObject1).ajd(8);
      localObject2 = (u)paramaml;
      ((aml)localObject1).bgs(paramaml.dLl);
      ((aml)localObject1).bgt(((u)localObject2).dUs);
      ((aml)localObject1).At(true);
      ((aml)localObject1).bgf(((u)localObject2).title);
      ((aml)localObject1).bgg(((u)localObject2).content);
      ((aml)localObject1).bgp(((u)localObject2).qPP);
      continue;
      ((aml)localObject1).ajd(3);
      localObject2 = (v)paramaml;
      ((aml)localObject1).bgs(paramaml.dLl);
      localObject3 = ((v)localObject2).dUs;
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((aml)localObject1).bgt((String)localObject3);
      ((aml)localObject1).ajc(((v)localObject2).dLu);
      ((aml)localObject1).At(true);
      ((aml)localObject1).bgp(((v)localObject2).qPP);
      continue;
      ((aml)localObject1).ajd(4);
      localObject2 = (k)paramaml;
      ((aml)localObject1).bgs(paramaml.dLl);
      ((aml)localObject1).bgt(((k)localObject2).dUs);
      ((aml)localObject1).bgu(((k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.e.aNx(((k)localObject2).dUs);
      if (localObject3 != null) {
        ((aml)localObject1).ajc(((a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((aml)localObject1).bgp(((k)localObject2).qPP);
        break;
        ((aml)localObject1).ajc(1);
      }
      if (!JGX)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(14547, new Object[] { Integer.valueOf(6) });
        JGX = true;
      }
      ((aml)localObject1).ajd(1);
      ((aml)localObject1).As(true);
      ((aml)localObject1).At(true);
      localObject2 = (i)paramaml;
      ((aml)localObject1).bgs(paramaml.dLl);
      ((aml)localObject1).bgg(com.tencent.mm.plugin.wenote.c.b.alO(((i)localObject2).content));
      if ((!Util.isNullOrNil(((aml)localObject1).desc)) && (((aml)localObject1).desc.length() > 1000)) {
        ((aml)localObject1).bgg(((aml)localObject1).desc.substring(0, 1000));
      }
    }
    label935:
    a(localLinkedList, paramList);
    localanb.bH(localLinkedList);
    return localanb;
  }
  
  private static void a(LinkedList<aml> paramLinkedList, List<com.tencent.mm.plugin.wenote.model.a.o> paramList)
  {
    Log.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        aml localaml = (aml)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (Util.isNullOrNil(localaml.KuR)))
        {
          localaml.bgs(f.alR(localaml.toString()));
          str1 = null;
          localObject = str1;
          if (i - 1 >= 0)
          {
            localObject = str1;
            if (i - 1 < paramList.size())
            {
              localObject = str1;
              if (paramList.size() > 0) {
                localObject = (com.tencent.mm.plugin.wenote.model.a.o)paramList.get(i - 1);
              }
            }
          }
          if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.o)localObject).qPN != null) && (((com.tencent.mm.plugin.wenote.model.a.o)localObject).qPN.equals(localaml.Lwp))) {
            ((com.tencent.mm.plugin.wenote.model.a.o)localObject).dLl = localaml.dLl;
          }
        }
        if ((i > 0) && (!Util.isNullOrNil(localaml.KuR)) && (!Util.isNullOrNil(localaml.Lvp)))
        {
          localaml.As(true);
          localaml.At(true);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localaml.dataType) });
          localObject = localaml.LvL;
          String str2;
          if (com.tencent.mm.vfs.s.YS((String)localObject))
          {
            Log.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.s.bhK((String)localObject);
            str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.vfs.s.aW((String)localObject, 0, 256));
            localaml.bgq(str1);
            localaml.bgr(str2);
            localaml.Mu(new com.tencent.mm.vfs.o((String)localObject).length());
            str1 = f.b(localaml);
            boolean bool = com.tencent.mm.vfs.s.YS(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localaml.Lwp))) {
              com.tencent.mm.vfs.s.nw((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localaml.LvN;
            if (!com.tencent.mm.vfs.s.YS((String)localObject)) {
              break label516;
            }
            Log.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.s.bhK((String)localObject);
            str2 = com.tencent.mm.b.g.fb((String)localObject);
            localaml.bgv(str1);
            localaml.bgw(str2);
            localaml.Mv(new com.tencent.mm.vfs.o((String)localObject).length());
            str1 = f.a(localaml);
            if ((((String)localObject).equals(str1)) || (com.tencent.mm.vfs.s.YS(str1))) {
              break;
            }
            com.tencent.mm.vfs.s.nw((String)localObject, str1);
            break;
            Log.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          Log.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  private void ca(Context paramContext, String paramString)
  {
    paramString = (k)this.JGS.get(paramString);
    if (Util.isNullOrNil(paramString.dUs)) {
      return;
    }
    if (!com.tencent.mm.vfs.s.YS(paramString.dUs))
    {
      localObject = bbP(paramString.dLl);
      if (localObject == null)
      {
        Log.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      p((aml)localObject);
    }
    Object localObject = new Intent();
    if (this.JGP == null) {
      ((Intent)localObject).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_detail_fav_path", paramString.dUs);
      ((Intent)localObject).putExtra("key_detail_fav_thumb_path", paramString.thumbPath);
      ((Intent)localObject).putExtra("key_detail_fav_video_duration", paramString.duration);
      ((Intent)localObject).putExtra("key_detail_data_id", paramString.dLl);
      ((Intent)localObject).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject).putExtra("key_detail_fav_video_show_download_status", true);
      if (paramString.qPM != null) {
        ((Intent)localObject).putExtra("key_detail_msg_uuid", paramString.qPM.jsz);
      }
      com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject, 1);
      return;
      ((Intent)localObject).putExtra("key_detail_info_id", this.JGP.field_localId);
    }
  }
  
  public abstract String a(aml paramaml);
  
  public abstract void a(aml paramaml, String paramString);
  
  public final void b(oc paramoc)
  {
    if (paramoc.dUe == null)
    {
      Log.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
      return;
    }
    String str = paramoc.dUe.dUg;
    com.tencent.mm.plugin.wenote.model.a.o localo = (com.tencent.mm.plugin.wenote.model.a.o)this.JGS.get(str);
    if (localo == null)
    {
      Log.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
      return;
    }
    Log.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", new Object[] { Integer.valueOf(localo.type) });
    switch (localo.type)
    {
    case 4: 
    default: 
      return;
    case 2: 
      bZ(paramoc.dUe.context, str);
      return;
    case 5: 
      bX(paramoc.dUe.context, str);
      return;
    case 3: 
      bY(paramoc.dUe.context, str);
      return;
    }
    ca(paramoc.dUe.context, str);
  }
  
  public abstract void bX(Context paramContext, String paramString);
  
  public abstract void bY(Context paramContext, String paramString);
  
  public abstract void bZ(Context paramContext, String paramString);
  
  public void bbO(String paramString) {}
  
  public final aml bbP(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.JGR.get(paramString);
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (com.tencent.mm.plugin.wenote.model.a.o)this.JGS.get(str);
    if (paramString == null)
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.qPM;
  }
  
  public abstract String d(aml paramaml);
  
  public String gjA()
  {
    return "";
  }
  
  public final void iq(List<aml> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<aml>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      aml localaml = (aml)localIterator.next();
      com.tencent.mm.plugin.wenote.model.a.o localo = new com.tencent.mm.plugin.wenote.model.a.o();
      localo.qPN = localaml.Lwp;
      if (localaml.dataType == 1) {
        localo.qPN = "-1";
      }
      if (Util.isNullOrNil(localo.qPN))
      {
        Log.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = d(localaml);
        if ((!Util.isNullOrNil(paramList)) && (com.tencent.mm.vfs.s.YS(paramList)))
        {
          f.O(this.JGO.dUt, paramList);
          return;
        }
        p(localaml);
        return;
      }
      if (localo.qPN.equals("WeNoteHtmlFile"))
      {
        localObject1 = d(localaml);
        if ((!Util.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.s.YS((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.qPT = com.tencent.mm.vfs.s.boY((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.c.b.alN(localw.qPT);
              paramList = (List<aml>)localObject1;
              try
              {
                Log.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localaml.dLl });
                qPe.containsKey(localw.qPT);
                Log.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(Util.isNullOrNil(localaml.KuR)), Boolean.valueOf(Util.isNullOrNil(localaml.Lvp)) });
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
          Log.printErrStackTrace("MicroMsg.WNNoteBase", localException1, "", new Object[0]);
          continue;
          p(localaml);
          localw.qPV = true;
          Log.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localaml.dLl });
          this.JGR.put(localaml.dLl, localo.qPN);
        }
      }
      if (!localo.qPN.equals("-1"))
      {
        i = Util.getInt(localo.qPN.substring(7), 0);
        j = Util.getInt(this.JGT.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.JGT = ((String)localObject2);
        localo.dLl = localaml.dLl;
        switch (localaml.dataType)
        {
        default: 
          if (localaml.dataType <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).qPN = localo.qPN;
          ((n)localObject2).type = 0;
          ((n)localObject2).dLl = localo.dLl;
          ((n)localObject2).qPM = localaml;
          localObject3 = d(localaml);
          ((n)localObject2).qPO = true;
          ((n)localObject2).dUs = ((String)localObject3);
          ((n)localObject2).mav = qPj;
          ((n)localObject2).title = MMApplicationContext.getContext().getResources().getString(2131759296);
          ((n)localObject2).content = MMApplicationContext.getContext().getResources().getString(2131759261);
          localw.qPU.add(localObject2);
          this.JGS.put(localo.qPN, localObject2);
          break label23;
        }
      }
      if (!Util.isNullOrNil(localaml.desc)) {
        if ((localw.qPU.size() > 0) && (localw.qPU.get(localw.qPU.size() - 1) != null) && (((com.tencent.mm.plugin.wenote.model.a.o)localw.qPU.get(localw.qPU.size() - 1)).qPN.equals("-1")))
        {
          localObject2 = (t)localw.qPU.get(localw.qPU.size() - 1);
          ((t)localObject2).content += localaml.desc;
        }
        else
        {
          localObject2 = new i();
          ((t)localObject2).qPN = localo.qPN;
          ((t)localObject2).content = localaml.desc;
          localw.qPU.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).qPN = localo.qPN;
          ((p)localObject2).type = 2;
          ((p)localObject2).dLl = localo.dLl;
          ((p)localObject2).qPM = localaml;
          localObject3 = d(localaml);
          if (!Util.isNullOrNil((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = a(localaml);
            if (!com.tencent.mm.vfs.s.YS(str)) {
              a(localaml, str);
            }
            if (com.tencent.mm.vfs.s.YS((String)localObject3))
            {
              ((p)localObject2).qPO = true;
              c.fK((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).dUs = ((String)localObject4);
              ((p)localObject2).qPL = ((String)localObject3);
              localw.qPU.add(localObject2);
              this.JGS.put(localo.qPN, localObject2);
              break;
              p(localaml);
              ((p)localObject2).qPO = false;
              this.JGR.put(localaml.dLl, localo.qPN);
            }
            if (localaml.dataType == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!Util.isNullOrNil(localaml.KuR))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).DmM = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).qPN = localo.qPN;
              ((v)localObject2).type = 4;
              ((v)localObject2).dLl = localo.dLl;
              ((v)localObject2).qPM = localaml;
              localObject3 = d(localaml);
              if ((Util.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.s.YS((String)localObject3))) {
                break label1315;
              }
              ((v)localObject2).qPO = true;
              ((v)localObject2).mav = qPf;
              ((v)localObject2).length = ((int)f.AO(localaml.duration));
            }
            for (;;)
            {
              ((v)localObject2).dUs = ((String)localObject3);
              ((v)localObject2).qPR = f.W(MMApplicationContext.getContext(), (int)f.AO(localaml.duration));
              ((v)localObject2).dLu = localaml.duration;
              localObject3 = new hb();
              ((hb)localObject3).dLm.type = 17;
              ((hb)localObject3).dLm.dLo = localaml;
              EventCenter.instance.publish((IEvent)localObject3);
              ((v)localObject2).dLt = ((hb)localObject3).dLn.ret;
              ((v)localObject2).qPP = localaml.LvC;
              localw.qPU.add(localObject2);
              this.JGS.put(localo.qPN, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1315:
              p(localaml);
              ((v)localObject2).qPO = false;
              ((v)localObject2).qPS = MMApplicationContext.getContext().getString(2131759364);
              this.JGR.put(localaml.dLl, localo.qPN);
            }
            localObject4 = new r();
            localObject3 = localaml.Lwh.LwQ;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new ams();
              ((ams)localObject2).bgW("");
              ((ams)localObject2).bgX("");
              Log.e("MicroMsg.WNNoteBase", "locItem is null, dataItemId:" + localaml.dLl);
            }
            ((r)localObject4).latitude = ((float)((ams)localObject2).lat);
            ((r)localObject4).longtitude = ((float)((ams)localObject2).lng);
            ((r)localObject4).dRt = ((ams)localObject2).dRt;
            ((r)localObject4).JHY = ((ams)localObject2).label;
            ((r)localObject4).JHZ = ((ams)localObject2).dWi;
            ((r)localObject4).JIa = localaml.Lwp;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).qPN = localo.qPN;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).type = 3;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).dLl = localo.dLl;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).qPM = localaml;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).qPO = true;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).kHV = ((r)localObject4).JHZ;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).iUO = ((r)localObject4).JHY;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).lat = ((r)localObject4).latitude;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).lng = ((r)localObject4).longtitude;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).JIb = ((r)localObject4).dRt;
            ((com.tencent.mm.plugin.wenote.model.a.s)localObject2).dUs = "";
            localw.qPU.add(localObject2);
            this.JGS.put(localo.qPN, localObject2);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((u)localObject2).qPN = localo.qPN;
            ((u)localObject2).type = 5;
            ((u)localObject2).dLl = localo.dLl;
            ((u)localObject2).qPM = localaml;
            localObject3 = d(localaml);
            if ((!Util.isNullOrNil((String)localObject3)) && (com.tencent.mm.vfs.s.YS((String)localObject3)))
            {
              ((u)localObject2).qPO = true;
              ((u)localObject2).dUs = ((String)localObject3);
            }
            for (;;)
            {
              ((u)localObject2).mav = h.bbT(localaml.LvC);
              ((u)localObject2).title = localaml.title;
              ((u)localObject2).content = localaml.desc;
              ((u)localObject2).qPP = localaml.LvC;
              if (Util.isNullOrNil(((u)localObject2).content)) {
                ((u)localObject2).content = f.getLengthStr((float)localaml.LvI);
              }
              localw.qPU.add(localObject2);
              this.JGS.put(localo.qPN, localObject2);
              break;
              ((u)localObject2).qPO = false;
              this.JGR.put(localaml.dLl, localo.qPN);
            }
            localObject2 = new k();
            ((k)localObject2).qPN = localo.qPN;
            ((k)localObject2).type = 6;
            ((k)localObject2).dLl = localo.dLl;
            ((k)localObject2).qPM = localaml;
            if (localaml != null) {
              ((k)localObject2).duration = localaml.duration;
            }
            ((k)localObject2).thumbPath = a(localaml);
            localObject3 = d(localaml);
            ((k)localObject2).dUs = ((String)localObject3);
            if ((!Util.isNullOrNil(((k)localObject2).thumbPath)) && (!com.tencent.mm.vfs.s.YS(((k)localObject2).thumbPath)))
            {
              if (!com.tencent.mm.vfs.s.YS((String)localObject3)) {
                break label2063;
              }
              localObject4 = com.tencent.mm.plugin.fav.ui.e.asm((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                Log.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.l.f.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((k)localObject2).thumbPath, true);
                if ((Util.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.s.YS((String)localObject3))) {
                  break label2114;
                }
                ((k)localObject2).qPO = true;
                localw.qPU.add(localObject2);
                this.JGS.put(localo.qPN, localObject2);
              }
              catch (Exception localException3)
              {
                Log.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              a(localaml, ((k)localObject2).thumbPath);
              this.JGR.put(localaml.dLl + "_t", localo.qPN);
              continue;
              label2114:
              ((k)localObject2).qPO = false;
              this.JGR.put(localaml.dLl, localo.qPN);
            }
          }
        }
      }
    }
    label654:
    label2063:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.qPU, paramList, true);
    }
    if (this.JGO.msgId == -1L)
    {
      this.JGQ.put(Long.toString(this.JGO.dUt), localw);
      return;
    }
    this.JGQ.put(Long.toString(this.JGO.msgId), localw);
  }
  
  public abstract void p(aml paramaml);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */