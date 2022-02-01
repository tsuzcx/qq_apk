package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.oz.a;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.d.c;
import com.tencent.mm.plugin.wenote.model.a.i;
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
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.anm;>;
import org.json.JSONArray;

public abstract class d
{
  public static boolean QGp = false;
  public static String urh = "";
  public static HashMap<String, JSONArray> urj = new HashMap();
  public static String urk = ap.dkm() + "/fav_fileicon_recording.png";
  private static String urm = ap.dkm() + "/ofm_file_icon.png";
  private static String urn = ap.dkm() + "/app_attach_file_icon_pic.png";
  public static String uro = ap.dkm() + "/location_msg.png";
  public static String urp = ap.dkm() + "/note_fav_not_support.png";
  public m QGg = null;
  public com.tencent.mm.plugin.fav.a.g QGh;
  public HashMap<String, w> QGi = new HashMap();
  public HashMap<String, String> QGj = new HashMap();
  public HashMap<String, o> QGk = new HashMap();
  public String QGl = "WeNote_0";
  public String QGm = "";
  public boolean QGn = false;
  public aoc QGo = new aoc();
  public String QGq = "";
  public int QGr = 0;
  
  public static aoc a(String paramString, List<o> paramList, anm paramanm)
  {
    LinkedList localLinkedList = new LinkedList();
    aoc localaoc = new aoc();
    if (paramanm != null) {
      localLinkedList.add(paramanm);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label935;
        }
        paramanm = (o)paramString.next();
        if (paramanm != null)
        {
          if (paramanm.urS == null) {
            break;
          }
          if (paramanm.urS.dataType == 20) {
            paramanm.urS.arq(3);
          }
          localLinkedList.add(paramanm.urS);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ap.dkp();
        paramanm = new anm();
        paramanm.arq(8);
        paramanm.bsU("WeNoteHtmlFile");
        paramanm.Ey(true);
        paramanm.TY(com.tencent.mm.vfs.u.bBQ(paramString));
        paramanm.bsH(".htm");
        localLinkedList.add(paramanm);
        localObject1 = f.b(paramanm);
        if (!com.tencent.mm.vfs.u.agG((String)localObject1)) {
          com.tencent.mm.vfs.u.on(paramString, (String)localObject1);
        }
        paramanm.bsL((String)localObject1);
      }
    }
    Object localObject1 = new anm();
    Object localObject2 = new ann();
    Object localObject3 = new ano();
    ((ano)localObject3).aru(6);
    ((ann)localObject2).c((ano)localObject3);
    ((anm)localObject1).a((ann)localObject2);
    switch (paramanm.type)
    {
    }
    for (;;)
    {
      ((anm)localObject1).bsU(paramanm.urT);
      localLinkedList.add(localObject1);
      break;
      ((anm)localObject1).arq(2);
      localObject2 = (p)paramanm;
      localObject3 = ((p)localObject2).urR;
      ((anm)localObject1).bsL((String)localObject3);
      if (!Util.isNullOrNil(((p)paramanm).fEa))
      {
        ((anm)localObject1).bsK(paramanm.fEa);
        ((anm)localObject1).bsM(((p)localObject2).fNU);
      }
      for (;;)
      {
        ((anm)localObject1).arq(2);
        break;
        ((anm)localObject1).bsK(f.atK(localObject2.toString()));
        BitmapUtil.createThumbNail((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.a((anm)localObject1), true);
        ((anm)localObject1).bsM(f.a((anm)localObject1));
      }
      ((anm)localObject1).arq(6);
      localObject2 = (s)paramanm;
      ((anm)localObject1).bsK(paramanm.fEa);
      localObject3 = new ant();
      ((ant)localObject3).bto(((s)localObject2).lLg);
      ((ant)localObject3).E(((s)localObject2).lat);
      ((ant)localObject3).D(((s)localObject2).lng);
      ((ant)localObject3).arv((int)((s)localObject2).QHt);
      ((ant)localObject3).btp(((s)localObject2).poiName);
      ((anm)localObject1).Ex(true);
      ((anm)localObject1).Ey(true);
      ((anm)localObject1).SyG.c((ant)localObject3);
      continue;
      ((anm)localObject1).arq(8);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.u)paramanm;
      ((anm)localObject1).bsK(paramanm.fEa);
      ((anm)localObject1).bsL(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).fNU);
      ((anm)localObject1).Ey(true);
      ((anm)localObject1).bsx(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).title);
      ((anm)localObject1).bsy(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).content);
      ((anm)localObject1).bsH(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).urV);
      continue;
      ((anm)localObject1).arq(3);
      localObject2 = (v)paramanm;
      ((anm)localObject1).bsK(paramanm.fEa);
      localObject3 = ((v)localObject2).fNU;
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((anm)localObject1).bsL((String)localObject3);
      ((anm)localObject1).arp(((v)localObject2).fEj);
      ((anm)localObject1).Ey(true);
      ((anm)localObject1).bsH(((v)localObject2).urV);
      continue;
      ((anm)localObject1).arq(4);
      localObject2 = (k)paramanm;
      ((anm)localObject1).bsK(paramanm.fEa);
      ((anm)localObject1).bsL(((k)localObject2).fNU);
      ((anm)localObject1).bsM(((k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.f.aYg(((k)localObject2).fNU);
      if (localObject3 != null) {
        ((anm)localObject1).arp(((com.tencent.mm.plugin.sight.base.b)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((anm)localObject1).bsH(((k)localObject2).urV);
        break;
        ((anm)localObject1).arp(1);
      }
      if (!QGp)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(14547, new Object[] { Integer.valueOf(6) });
        QGp = true;
      }
      ((anm)localObject1).arq(1);
      ((anm)localObject1).Ex(true);
      ((anm)localObject1).Ey(true);
      localObject2 = (i)paramanm;
      ((anm)localObject1).bsK(paramanm.fEa);
      ((anm)localObject1).bsy(com.tencent.mm.plugin.wenote.d.b.atH(((i)localObject2).content));
      if ((!Util.isNullOrNil(((anm)localObject1).desc)) && (((anm)localObject1).desc.length() > 1000)) {
        ((anm)localObject1).bsy(((anm)localObject1).desc.substring(0, 1000));
      }
    }
    label935:
    a(localLinkedList, paramList);
    localaoc.cg(localLinkedList);
    return localaoc;
  }
  
  private static void a(LinkedList<anm> paramLinkedList, List<o> paramList)
  {
    Log.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        anm localanm = (anm)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (Util.isNullOrNil(localanm.Rwb)))
        {
          localanm.bsK(f.atK(localanm.toString()));
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
          if ((localObject != null) && (((o)localObject).urT != null) && (((o)localObject).urT.equals(localanm.SyO))) {
            ((o)localObject).fEa = localanm.fEa;
          }
        }
        if ((i > 0) && (!Util.isNullOrNil(localanm.Rwb)) && (!Util.isNullOrNil(localanm.SxP)))
        {
          localanm.Ex(true);
          localanm.Ey(true);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localanm.dataType) });
          localObject = localanm.Syl;
          String str2;
          if (com.tencent.mm.vfs.u.agG((String)localObject))
          {
            Log.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.u.buc((String)localObject);
            str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.vfs.u.aY((String)localObject, 0, 256));
            localanm.bsI(str1);
            localanm.bsJ(str2);
            localanm.TY(new q((String)localObject).length());
            str1 = f.b(localanm);
            boolean bool = com.tencent.mm.vfs.u.agG(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localanm.SyO))) {
              com.tencent.mm.vfs.u.on((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localanm.Syn;
            if (!com.tencent.mm.vfs.u.agG((String)localObject)) {
              break label516;
            }
            Log.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.u.buc((String)localObject);
            str2 = com.tencent.mm.b.g.fR((String)localObject);
            localanm.bsN(str1);
            localanm.bsO(str2);
            localanm.TZ(new q((String)localObject).length());
            str1 = f.a(localanm);
            if ((((String)localObject).equals(str1)) || (com.tencent.mm.vfs.u.agG(str1))) {
              break;
            }
            com.tencent.mm.vfs.u.on((String)localObject, str1);
            break;
            Log.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          Log.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  private void cm(Context paramContext, String paramString)
  {
    paramString = (k)this.QGk.get(paramString);
    if (Util.isNullOrNil(paramString.fNU)) {
      return;
    }
    if (!com.tencent.mm.vfs.u.agG(paramString.fNU))
    {
      localObject = bnP(paramString.fEa);
      if (localObject == null)
      {
        Log.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      p((anm)localObject);
    }
    Object localObject = new Intent();
    if (this.QGh == null) {
      ((Intent)localObject).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_detail_fav_path", paramString.fNU);
      ((Intent)localObject).putExtra("key_detail_fav_thumb_path", paramString.thumbPath);
      ((Intent)localObject).putExtra("key_detail_fav_video_duration", paramString.duration);
      ((Intent)localObject).putExtra("key_detail_data_id", paramString.fEa);
      ((Intent)localObject).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject).putExtra("key_detail_fav_video_show_download_status", true);
      if (paramString.urS != null) {
        ((Intent)localObject).putExtra("key_detail_msg_uuid", paramString.urS.mic);
      }
      com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject, 1);
      return;
      ((Intent)localObject).putExtra("key_detail_info_id", this.QGh.field_localId);
    }
  }
  
  public abstract String a(anm paramanm);
  
  public abstract void a(anm paramanm, String paramString);
  
  public final void b(oz paramoz)
  {
    if (paramoz.fNG == null)
    {
      Log.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
      return;
    }
    String str = paramoz.fNG.fNI;
    o localo = (o)this.QGk.get(str);
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
      cl(paramoz.fNG.context, str);
      return;
    case 5: 
      cj(paramoz.fNG.context, str);
      return;
    case 3: 
      ck(paramoz.fNG.context, str);
      return;
    }
    cm(paramoz.fNG.context, str);
  }
  
  public void bnO(String paramString) {}
  
  public final anm bnP(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.QGj.get(paramString);
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (o)this.QGk.get(str);
    if (paramString == null)
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.urS;
  }
  
  public abstract void cj(Context paramContext, String paramString);
  
  public abstract void ck(Context paramContext, String paramString);
  
  public abstract void cl(Context paramContext, String paramString);
  
  public abstract String d(anm paramanm);
  
  public String hdn()
  {
    return "";
  }
  
  public final void jh(List<anm> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<anm>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      anm localanm = (anm)localIterator.next();
      o localo = new o();
      localo.urT = localanm.SyO;
      if (localanm.dataType == 1) {
        localo.urT = "-1";
      }
      if (Util.isNullOrNil(localo.urT))
      {
        Log.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = d(localanm);
        if ((!Util.isNullOrNil(paramList)) && (com.tencent.mm.vfs.u.agG(paramList)))
        {
          f.W(this.QGg.fNV, paramList);
          return;
        }
        p(localanm);
        return;
      }
      if (localo.urT.equals("WeNoteHtmlFile"))
      {
        localObject1 = d(localanm);
        if ((!Util.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.u.agG((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.urZ = com.tencent.mm.vfs.u.bBS((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.d.b.atG(localw.urZ);
              paramList = (List<anm>)localObject1;
              try
              {
                Log.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localanm.fEa });
                urj.containsKey(localw.urZ);
                Log.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(Util.isNullOrNil(localanm.Rwb)), Boolean.valueOf(Util.isNullOrNil(localanm.SxP)) });
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
          p(localanm);
          localw.usb = true;
          Log.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localanm.fEa });
          this.QGj.put(localanm.fEa, localo.urT);
        }
      }
      if (!localo.urT.equals("-1"))
      {
        i = Util.getInt(localo.urT.substring(7), 0);
        j = Util.getInt(this.QGl.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.QGl = ((String)localObject2);
        localo.fEa = localanm.fEa;
        switch (localanm.dataType)
        {
        default: 
          if (localanm.dataType <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).urT = localo.urT;
          ((n)localObject2).type = 0;
          ((n)localObject2).fEa = localo.fEa;
          ((n)localObject2).urS = localanm;
          localObject3 = d(localanm);
          ((n)localObject2).urU = true;
          ((n)localObject2).fNU = ((String)localObject3);
          ((n)localObject2).oYm = urp;
          ((n)localObject2).title = MMApplicationContext.getContext().getResources().getString(R.l.favorite_record_no_support_type);
          ((n)localObject2).content = MMApplicationContext.getContext().getResources().getString(R.l.favorite_oldversion_content);
          localw.usa.add(localObject2);
          this.QGk.put(localo.urT, localObject2);
          break label23;
        }
      }
      if (!Util.isNullOrNil(localanm.desc)) {
        if ((localw.usa.size() > 0) && (localw.usa.get(localw.usa.size() - 1) != null) && (((o)localw.usa.get(localw.usa.size() - 1)).urT.equals("-1")))
        {
          localObject2 = (t)localw.usa.get(localw.usa.size() - 1);
          ((t)localObject2).content += localanm.desc;
        }
        else
        {
          localObject2 = new i();
          ((t)localObject2).urT = localo.urT;
          ((t)localObject2).content = localanm.desc;
          localw.usa.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).urT = localo.urT;
          ((p)localObject2).type = 2;
          ((p)localObject2).fEa = localo.fEa;
          ((p)localObject2).urS = localanm;
          localObject3 = d(localanm);
          if (!Util.isNullOrNil((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = a(localanm);
            if (!com.tencent.mm.vfs.u.agG(str)) {
              a(localanm, str);
            }
            if (com.tencent.mm.vfs.u.agG((String)localObject3))
            {
              ((p)localObject2).urU = true;
              c.fY((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).fNU = ((String)localObject4);
              ((p)localObject2).urR = ((String)localObject3);
              localw.usa.add(localObject2);
              this.QGk.put(localo.urT, localObject2);
              break;
              p(localanm);
              ((p)localObject2).urU = false;
              this.QGj.put(localanm.fEa, localo.urT);
            }
            if (localanm.dataType == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!Util.isNullOrNil(localanm.Rwb))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).Jsr = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).urT = localo.urT;
              ((v)localObject2).type = 4;
              ((v)localObject2).fEa = localo.fEa;
              ((v)localObject2).urS = localanm;
              localObject3 = d(localanm);
              if ((Util.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.u.agG((String)localObject3))) {
                break label1315;
              }
              ((v)localObject2).urU = true;
              ((v)localObject2).oYm = urk;
              ((v)localObject2).length = ((int)f.GW(localanm.duration));
            }
            for (;;)
            {
              ((v)localObject2).fNU = ((String)localObject3);
              ((v)localObject2).urX = f.ab(MMApplicationContext.getContext(), (int)f.GW(localanm.duration));
              ((v)localObject2).fEj = localanm.duration;
              localObject3 = new hi();
              ((hi)localObject3).fEb.type = 17;
              ((hi)localObject3).fEb.fEd = localanm;
              EventCenter.instance.publish((IEvent)localObject3);
              ((v)localObject2).fEi = ((hi)localObject3).fEc.ret;
              ((v)localObject2).urV = localanm.Syc;
              localw.usa.add(localObject2);
              this.QGk.put(localo.urT, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1315:
              p(localanm);
              ((v)localObject2).urU = false;
              ((v)localObject2).urY = MMApplicationContext.getContext().getString(R.l.favorite_wenote_voice_downloading);
              this.QGj.put(localanm.fEa, localo.urT);
            }
            localObject4 = new r();
            localObject3 = localanm.SyG.Szp;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new ant();
              ((ant)localObject2).bto("");
              ((ant)localObject2).btp("");
              Log.e("MicroMsg.WNNoteBase", "locItem is null, dataItemId:" + localanm.fEa);
            }
            ((r)localObject4).latitude = ((float)((ant)localObject2).lat);
            ((r)localObject4).longtitude = ((float)((ant)localObject2).lng);
            ((r)localObject4).fKJ = ((ant)localObject2).fKJ;
            ((r)localObject4).QHq = ((ant)localObject2).label;
            ((r)localObject4).QHr = ((ant)localObject2).fPN;
            ((r)localObject4).QHs = localanm.SyO;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((s)localObject2).urT = localo.urT;
            ((s)localObject2).type = 3;
            ((s)localObject2).fEa = localo.fEa;
            ((s)localObject2).urS = localanm;
            ((s)localObject2).urU = true;
            ((s)localObject2).poiName = ((r)localObject4).QHr;
            ((s)localObject2).lLg = ((r)localObject4).QHq;
            ((s)localObject2).lat = ((r)localObject4).latitude;
            ((s)localObject2).lng = ((r)localObject4).longtitude;
            ((s)localObject2).QHt = ((r)localObject4).fKJ;
            ((s)localObject2).fNU = "";
            localw.usa.add(localObject2);
            this.QGk.put(localo.urT, localObject2);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).urT = localo.urT;
            ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).type = 5;
            ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).fEa = localo.fEa;
            ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).urS = localanm;
            localObject3 = d(localanm);
            if ((!Util.isNullOrNil((String)localObject3)) && (com.tencent.mm.vfs.u.agG((String)localObject3)))
            {
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).urU = true;
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).fNU = ((String)localObject3);
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).oYm = h.bnT(localanm.Syc);
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).title = localanm.title;
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).content = localanm.desc;
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).urV = localanm.Syc;
              if (Util.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).content)) {
                ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).content = f.getLengthStr((float)localanm.Syi);
              }
              localw.usa.add(localObject2);
              this.QGk.put(localo.urT, localObject2);
              break;
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).urU = false;
              this.QGj.put(localanm.fEa, localo.urT);
            }
            localObject2 = new k();
            ((k)localObject2).urT = localo.urT;
            ((k)localObject2).type = 6;
            ((k)localObject2).fEa = localo.fEa;
            ((k)localObject2).urS = localanm;
            if (localanm != null) {
              ((k)localObject2).duration = localanm.duration;
            }
            ((k)localObject2).thumbPath = a(localanm);
            localObject3 = d(localanm);
            ((k)localObject2).fNU = ((String)localObject3);
            if ((!Util.isNullOrNil(((k)localObject2).thumbPath)) && (!com.tencent.mm.vfs.u.agG(((k)localObject2).thumbPath)))
            {
              if (!com.tencent.mm.vfs.u.agG((String)localObject3)) {
                break label2063;
              }
              localObject4 = e.aAn((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                Log.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.m.g.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((k)localObject2).thumbPath, true);
                if ((Util.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.u.agG((String)localObject3))) {
                  break label2114;
                }
                ((k)localObject2).urU = true;
                localw.usa.add(localObject2);
                this.QGk.put(localo.urT, localObject2);
              }
              catch (Exception localException3)
              {
                Log.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              a(localanm, ((k)localObject2).thumbPath);
              this.QGj.put(localanm.fEa + "_t", localo.urT);
              continue;
              label2114:
              ((k)localObject2).urU = false;
              this.QGj.put(localanm.fEa, localo.urT);
            }
          }
        }
      }
    }
    label654:
    label2063:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.usa, paramList, true);
    }
    if (this.QGg.msgId == -1L)
    {
      this.QGi.put(Long.toString(this.QGg.fNV), localw);
      return;
    }
    this.QGi.put(Long.toString(this.QGg.msgId), localw);
  }
  
  public abstract void p(anm paramanm);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */