package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.autogen.a.ql.a;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.c.c;
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
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.arf;>;
import org.json.JSONArray;

public abstract class d
{
  public static boolean XzN = false;
  public static String xxE = "";
  public static HashMap<String, JSONArray> xxF = new HashMap();
  public static String xxG = aq.dQY() + "/fav_fileicon_recording.png";
  private static String xxH = aq.dQY() + "/ofm_file_icon.png";
  private static String xxI = aq.dQY() + "/app_attach_file_icon_pic.png";
  public static String xxJ = aq.dQY() + "/location_msg.png";
  public static String xxK = aq.dQY() + "/note_fav_not_support.png";
  public m XzE = null;
  public com.tencent.mm.plugin.fav.a.g XzF;
  public HashMap<String, w> XzG = new HashMap();
  public HashMap<String, String> XzH = new HashMap();
  public HashMap<String, o> XzI = new HashMap();
  public String XzJ = "WeNote_0";
  public String XzK = "";
  public boolean XzL = false;
  public arv XzM = new arv();
  public String XzO = "";
  public int XzP = 0;
  
  public static arv a(String paramString, List<o> paramList, arf paramarf)
  {
    LinkedList localLinkedList = new LinkedList();
    arv localarv = new arv();
    if (paramarf != null) {
      localLinkedList.add(paramarf);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label939;
        }
        paramarf = (o)paramString.next();
        if (paramarf != null)
        {
          if (paramarf.xyn == null) {
            break;
          }
          if (paramarf.xyn.dataType == 20) {
            paramarf.xyn.axy(3);
          }
          localLinkedList.add(paramarf.xyn);
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = aq.dRb();
        paramarf = new arf();
        paramarf.axy(8);
        paramarf.bsL("WeNoteHtmlFile");
        paramarf.Kk(true);
        paramarf.yo(y.bEl(paramString));
        paramarf.bsy(".htm");
        localLinkedList.add(paramarf);
        localObject1 = f.b(paramarf);
        if (!y.ZC((String)localObject1)) {
          y.O(paramString, (String)localObject1, false);
        }
        paramarf.bsC((String)localObject1);
      }
    }
    Object localObject1 = new arf();
    Object localObject2 = new arg();
    Object localObject3 = new arh();
    ((arh)localObject3).axC(6);
    ((arg)localObject2).c((arh)localObject3);
    ((arf)localObject1).a((arg)localObject2);
    switch (paramarf.type)
    {
    }
    for (;;)
    {
      ((arf)localObject1).bsL(paramarf.xyo);
      localLinkedList.add(localObject1);
      break;
      ((arf)localObject1).axy(2);
      localObject2 = (p)paramarf;
      localObject3 = ((p)localObject2).xym;
      ((arf)localObject1).bsC((String)localObject3);
      if (!Util.isNullOrNil(((p)paramarf).hIQ))
      {
        ((arf)localObject1).bsB(paramarf.hIQ);
        ((arf)localObject1).bsD(((p)localObject2).hTM);
      }
      for (;;)
      {
        ((arf)localObject1).axy(2);
        break;
        ((arf)localObject1).bsB(f.anz(localObject2.toString()));
        BitmapUtil.createThumbNail((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.a((arf)localObject1), true);
        ((arf)localObject1).bsD(f.a((arf)localObject1));
      }
      ((arf)localObject1).axy(6);
      localObject2 = (s)paramarf;
      ((arf)localObject1).bsB(paramarf.hIQ);
      localObject3 = new arm();
      ((arm)localObject3).btf(((s)localObject2).oDI);
      ((arm)localObject3).W(((s)localObject2).lat);
      ((arm)localObject3).V(((s)localObject2).lng);
      ((arm)localObject3).axD((int)((s)localObject2).XAR);
      ((arm)localObject3).btg(((s)localObject2).poiName);
      ((arf)localObject1).Kj(true);
      ((arf)localObject1).Kk(true);
      ((arf)localObject1).Zzy.c((arm)localObject3);
      continue;
      ((arf)localObject1).axy(8);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.u)paramarf;
      ((arf)localObject1).bsB(paramarf.hIQ);
      ((arf)localObject1).bsC(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).hTM);
      ((arf)localObject1).Kk(true);
      ((arf)localObject1).bso(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).title);
      ((arf)localObject1).bsp(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).content);
      ((arf)localObject1).bsy(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).xyq);
      continue;
      ((arf)localObject1).axy(3);
      localObject2 = (v)paramarf;
      ((arf)localObject1).bsB(paramarf.hIQ);
      localObject3 = ((v)localObject2).hTM;
      if ((Util.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((arf)localObject1).bsC((String)localObject3);
      ((arf)localObject1).axx(((v)localObject2).hIZ);
      ((arf)localObject1).Kk(true);
      ((arf)localObject1).bsy(((v)localObject2).xyq);
      continue;
      ((arf)localObject1).axy(4);
      localObject2 = (k)paramarf;
      ((arf)localObject1).bsB(paramarf.hIQ);
      ((arf)localObject1).bsC(((k)localObject2).hTM);
      ((arf)localObject1).bsD(((k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.f.aVX(((k)localObject2).hTM);
      if (localObject3 != null) {
        ((arf)localObject1).axx(((com.tencent.mm.plugin.sight.base.b)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((arf)localObject1).bsy(((k)localObject2).xyq);
        break;
        ((arf)localObject1).axx(1);
      }
      if (!XzN)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(14547, new Object[] { Integer.valueOf(6) });
        XzN = true;
      }
      ((arf)localObject1).axy(1);
      ((arf)localObject1).Kj(true);
      ((arf)localObject1).Kk(true);
      localObject2 = (i)paramarf;
      ((arf)localObject1).bsB(paramarf.hIQ);
      ((arf)localObject1).bsp(com.tencent.mm.plugin.wenote.c.b.anw(((i)localObject2).content));
      if ((!Util.isNullOrNil(((arf)localObject1).desc)) && (((arf)localObject1).desc.length() > 1000)) {
        ((arf)localObject1).bsp(((arf)localObject1).desc.substring(0, 1000));
      }
    }
    label939:
    a(localLinkedList, paramList);
    localarv.cs(localLinkedList);
    return localarv;
  }
  
  private static void a(LinkedList<arf> paramLinkedList, List<o> paramList)
  {
    Log.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        arf localarf = (arf)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (Util.isNullOrNil(localarf.Ysw)))
        {
          localarf.bsB(f.anz(localarf.toString()));
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
          if ((localObject != null) && (((o)localObject).xyo != null) && (((o)localObject).xyo.equals(localarf.ZzG))) {
            ((o)localObject).hIQ = localarf.hIQ;
          }
        }
        if ((i > 0) && (!Util.isNullOrNil(localarf.Ysw)) && (!Util.isNullOrNil(localarf.ZyH)))
        {
          localarf.Kj(true);
          localarf.Kk(true);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localarf.dataType) });
          localObject = localarf.Zzd;
          String str2;
          if (y.ZC((String)localObject))
          {
            Log.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = y.bub((String)localObject);
            str2 = com.tencent.mm.b.g.getMessageDigest(y.bi((String)localObject, 0, 256));
            localarf.bsz(str1);
            localarf.bsA(str2);
            localarf.yo(new com.tencent.mm.vfs.u((String)localObject).length());
            str1 = f.b(localarf);
            boolean bool = y.ZC(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localarf.ZzG))) {
              y.O((String)localObject, str1, false);
            }
          }
          for (;;)
          {
            localObject = localarf.Zzf;
            if (!y.ZC((String)localObject)) {
              break label518;
            }
            Log.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = y.bub((String)localObject);
            str2 = com.tencent.mm.b.g.hu((String)localObject);
            localarf.bsE(str1);
            localarf.bsF(str2);
            localarf.yp(new com.tencent.mm.vfs.u((String)localObject).length());
            str1 = f.a(localarf);
            if ((((String)localObject).equals(str1)) || (y.ZC(str1))) {
              break;
            }
            y.O((String)localObject, str1, false);
            break;
            Log.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label518:
          Log.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  private void cx(Context paramContext, String paramString)
  {
    paramString = (k)this.XzI.get(paramString);
    if (Util.isNullOrNil(paramString.hTM)) {
      return;
    }
    if (!y.ZC(paramString.hTM))
    {
      localObject = bnD(paramString.hIQ);
      if (localObject == null)
      {
        Log.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      p((arf)localObject);
    }
    Object localObject = new Intent();
    if (this.XzF == null) {
      ((Intent)localObject).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_detail_fav_path", paramString.hTM);
      ((Intent)localObject).putExtra("key_detail_fav_thumb_path", paramString.thumbPath);
      ((Intent)localObject).putExtra("key_detail_fav_video_duration", paramString.duration);
      ((Intent)localObject).putExtra("key_detail_data_id", paramString.hIQ);
      ((Intent)localObject).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject).putExtra("key_detail_fav_video_show_download_status", true);
      if (paramString.xyn != null) {
        ((Intent)localObject).putExtra("key_detail_msg_uuid", paramString.xyn.pbn);
      }
      com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject, 1);
      return;
      ((Intent)localObject).putExtra("key_detail_info_id", this.XzF.field_localId);
    }
  }
  
  public abstract String a(arf paramarf);
  
  public abstract void a(arf paramarf, String paramString);
  
  public final void b(ql paramql)
  {
    if (paramql.hTy == null)
    {
      Log.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
      return;
    }
    String str = paramql.hTy.hTA;
    o localo = (o)this.XzI.get(str);
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
      cw(paramql.hTy.context, str);
      return;
    case 5: 
      cu(paramql.hTy.context, str);
      return;
    case 3: 
      cv(paramql.hTy.context, str);
      return;
    }
    cx(paramql.hTy.context, str);
  }
  
  public void bnC(String paramString) {}
  
  public final arf bnD(String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.XzH.get(paramString);
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (o)this.XzI.get(str);
    if (paramString == null)
    {
      Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.xyn;
  }
  
  public abstract void cu(Context paramContext, String paramString);
  
  public abstract void cv(Context paramContext, String paramString);
  
  public abstract void cw(Context paramContext, String paramString);
  
  public abstract String d(arf paramarf);
  
  public String iDU()
  {
    return "";
  }
  
  public final void mq(List<arf> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<arf>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      arf localarf = (arf)localIterator.next();
      o localo = new o();
      localo.xyo = localarf.ZzG;
      if (localarf.dataType == 1) {
        localo.xyo = "-1";
      }
      if (Util.isNullOrNil(localo.xyo))
      {
        Log.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = d(localarf);
        if ((!Util.isNullOrNil(paramList)) && (y.ZC(paramList)))
        {
          f.al(this.XzE.hTN, paramList);
          return;
        }
        p(localarf);
        return;
      }
      if (localo.xyo.equals("WeNoteHtmlFile"))
      {
        localObject1 = d(localarf);
        if ((!Util.isNullOrNil((String)localObject1)) && (y.ZC((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.xyv = y.bEn((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.c.b.anv(localw.xyv);
              paramList = (List<arf>)localObject1;
              try
              {
                Log.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localarf.hIQ });
                xxF.containsKey(localw.xyv);
                Log.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(Util.isNullOrNil(localarf.Ysw)), Boolean.valueOf(Util.isNullOrNil(localarf.ZyH)) });
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
          p(localarf);
          localw.xyx = true;
          Log.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localarf.hIQ });
          this.XzH.put(localarf.hIQ, localo.xyo);
        }
      }
      if (!localo.xyo.equals("-1"))
      {
        i = Util.getInt(localo.xyo.substring(7), 0);
        j = Util.getInt(this.XzJ.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.XzJ = ((String)localObject2);
        localo.hIQ = localarf.hIQ;
        switch (localarf.dataType)
        {
        default: 
          if (localarf.dataType <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).xyo = localo.xyo;
          ((n)localObject2).type = 0;
          ((n)localObject2).hIQ = localo.hIQ;
          ((n)localObject2).xyn = localarf;
          localObject3 = d(localarf);
          ((n)localObject2).xyp = true;
          ((n)localObject2).hTM = ((String)localObject3);
          ((n)localObject2).sdM = xxK;
          ((n)localObject2).title = MMApplicationContext.getContext().getResources().getString(R.l.favorite_record_no_support_type);
          ((n)localObject2).content = MMApplicationContext.getContext().getResources().getString(R.l.favorite_oldversion_content);
          localw.xyw.add(localObject2);
          this.XzI.put(localo.xyo, localObject2);
          break label23;
        }
      }
      if (!Util.isNullOrNil(localarf.desc)) {
        if ((localw.xyw.size() > 0) && (localw.xyw.get(localw.xyw.size() - 1) != null) && (((o)localw.xyw.get(localw.xyw.size() - 1)).xyo.equals("-1")))
        {
          localObject2 = (t)localw.xyw.get(localw.xyw.size() - 1);
          ((t)localObject2).content += localarf.desc;
        }
        else
        {
          localObject2 = new i();
          ((t)localObject2).xyo = localo.xyo;
          ((t)localObject2).content = localarf.desc;
          localw.xyw.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).xyo = localo.xyo;
          ((p)localObject2).type = 2;
          ((p)localObject2).hIQ = localo.hIQ;
          ((p)localObject2).xyn = localarf;
          localObject3 = d(localarf);
          if (!Util.isNullOrNil((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = a(localarf);
            if (!y.ZC(str)) {
              a(localarf, str);
            }
            if (y.ZC((String)localObject3))
            {
              ((p)localObject2).xyp = true;
              c.gB((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).hTM = ((String)localObject4);
              ((p)localObject2).xym = ((String)localObject3);
              localw.xyw.add(localObject2);
              this.XzI.put(localo.xyo, localObject2);
              break;
              p(localarf);
              ((p)localObject2).xyp = false;
              this.XzH.put(localarf.hIQ, localo.xyo);
            }
            if (localarf.dataType == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!Util.isNullOrNil(localarf.Ysw))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).PFT = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).xyo = localo.xyo;
              ((v)localObject2).type = 4;
              ((v)localObject2).hIQ = localo.hIQ;
              ((v)localObject2).xyn = localarf;
              localObject3 = d(localarf);
              if ((Util.isNullOrNil((String)localObject3)) || (!y.ZC((String)localObject3))) {
                break label1312;
              }
              ((v)localObject2).xyp = true;
              ((v)localObject2).sdM = xxG;
              ((v)localObject2).length = ((int)f.jh(localarf.duration));
            }
            for (;;)
            {
              ((v)localObject2).hTM = ((String)localObject3);
              ((v)localObject2).xyt = f.aj(MMApplicationContext.getContext(), (int)f.jh(localarf.duration));
              ((v)localObject2).hIZ = localarf.duration;
              localObject3 = new ht();
              ((ht)localObject3).hIR.type = 17;
              ((ht)localObject3).hIR.hIT = localarf;
              ((ht)localObject3).publish();
              ((v)localObject2).hIY = ((ht)localObject3).hIS.ret;
              ((v)localObject2).xyq = localarf.ZyU;
              localw.xyw.add(localObject2);
              this.XzI.put(localo.xyo, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1312:
              p(localarf);
              ((v)localObject2).xyp = false;
              ((v)localObject2).xyu = MMApplicationContext.getContext().getString(R.l.favorite_wenote_voice_downloading);
              this.XzH.put(localarf.hIQ, localo.xyo);
            }
            localObject4 = new r();
            localObject3 = localarf.Zzy.ZAh;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new arm();
              ((arm)localObject2).btf("");
              ((arm)localObject2).btg("");
              Log.e("MicroMsg.WNNoteBase", "locItem is null, dataItemId:" + localarf.hIQ);
            }
            ((r)localObject4).latitude = ((float)((arm)localObject2).lat);
            ((r)localObject4).longtitude = ((float)((arm)localObject2).lng);
            ((r)localObject4).hQp = ((arm)localObject2).hQp;
            ((r)localObject4).XAO = ((arm)localObject2).label;
            ((r)localObject4).XAP = ((arm)localObject2).hVI;
            ((r)localObject4).XAQ = localarf.ZzG;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((s)localObject2).xyo = localo.xyo;
            ((s)localObject2).type = 3;
            ((s)localObject2).hIQ = localo.hIQ;
            ((s)localObject2).xyn = localarf;
            ((s)localObject2).xyp = true;
            ((s)localObject2).poiName = ((r)localObject4).XAP;
            ((s)localObject2).oDI = ((r)localObject4).XAO;
            ((s)localObject2).lat = ((r)localObject4).latitude;
            ((s)localObject2).lng = ((r)localObject4).longtitude;
            ((s)localObject2).XAR = ((r)localObject4).hQp;
            ((s)localObject2).hTM = "";
            localw.xyw.add(localObject2);
            this.XzI.put(localo.xyo, localObject2);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).xyo = localo.xyo;
            ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).type = 5;
            ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).hIQ = localo.hIQ;
            ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).xyn = localarf;
            localObject3 = d(localarf);
            if ((!Util.isNullOrNil((String)localObject3)) && (y.ZC((String)localObject3)))
            {
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).xyp = true;
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).hTM = ((String)localObject3);
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).sdM = h.bnH(localarf.ZyU);
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).title = localarf.title;
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).content = localarf.desc;
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).xyq = localarf.ZyU;
              if (Util.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.u)localObject2).content)) {
                ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).content = f.getLengthStr((float)localarf.Zza);
              }
              localw.xyw.add(localObject2);
              this.XzI.put(localo.xyo, localObject2);
              break;
              ((com.tencent.mm.plugin.wenote.model.a.u)localObject2).xyp = false;
              this.XzH.put(localarf.hIQ, localo.xyo);
            }
            localObject2 = new k();
            ((k)localObject2).xyo = localo.xyo;
            ((k)localObject2).type = 6;
            ((k)localObject2).hIQ = localo.hIQ;
            ((k)localObject2).xyn = localarf;
            if (localarf != null) {
              ((k)localObject2).duration = localarf.duration;
            }
            ((k)localObject2).thumbPath = a(localarf);
            localObject3 = d(localarf);
            ((k)localObject2).hTM = ((String)localObject3);
            if ((!Util.isNullOrNil(((k)localObject2).thumbPath)) && (!y.ZC(((k)localObject2).thumbPath)))
            {
              if (!y.ZC((String)localObject3)) {
                break label2060;
              }
              localObject4 = e.auu((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                Log.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.l.f.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((k)localObject2).thumbPath, true);
                if ((Util.isNullOrNil((String)localObject3)) || (!y.ZC((String)localObject3))) {
                  break label2111;
                }
                ((k)localObject2).xyp = true;
                localw.xyw.add(localObject2);
                this.XzI.put(localo.xyo, localObject2);
              }
              catch (Exception localException3)
              {
                Log.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              a(localarf, ((k)localObject2).thumbPath);
              this.XzH.put(localarf.hIQ + "_t", localo.xyo);
              continue;
              label2111:
              ((k)localObject2).xyp = false;
              this.XzH.put(localarf.hIQ, localo.xyo);
            }
          }
        }
      }
    }
    label654:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.xyw, paramList, true);
    }
    label2060:
    if (this.XzE.msgId == -1L)
    {
      this.XzG.put(Long.toString(this.XzE.hTN), localw);
      return;
    }
    this.XzG.put(Long.toString(this.XzE.msgId), localw);
  }
  
  public abstract void p(arf paramarf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */