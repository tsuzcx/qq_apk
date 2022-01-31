package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.a;
import com.tencent.mm.plugin.fav.a.an;
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
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.aca;>;
import org.json.JSONArray;

public abstract class d
{
  public static String vvZ = "";
  public static HashMap<String, JSONArray> vwa = new HashMap();
  public static boolean vwd = false;
  public static String vwe = an.bwZ() + "/fav_fileicon_recording.png";
  private static String vwf = an.bwZ() + "/ofm_file_icon.png";
  private static String vwg = an.bwZ() + "/app_attach_file_icon_pic.png";
  public static String vwh = an.bwZ() + "/location_msg.png";
  public static String vwi = an.bwZ() + "/note_fav_not_support.png";
  public m vvS = null;
  public com.tencent.mm.plugin.fav.a.g vvT;
  public HashMap<String, w> vvU = new HashMap();
  public HashMap<String, String> vvV = new HashMap();
  public HashMap<String, o> vvW = new HashMap();
  public String vvX = "WeNote_0";
  public String vvY = "";
  public boolean vwb = false;
  public acq vwc = new acq();
  
  public static acq a(String paramString, List<o> paramList, aca paramaca)
  {
    LinkedList localLinkedList = new LinkedList();
    acq localacq = new acq();
    if (paramaca != null) {
      localLinkedList.add(paramaca);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label914;
        }
        paramaca = (o)paramString.next();
        if (paramaca != null)
        {
          if (paramaca.vxq == null) {
            break;
          }
          localLinkedList.add(paramaca.vxq);
        }
      }
      if ((!bo.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = an.bxc();
        paramaca = new aca();
        paramaca.MI(8);
        paramaca.anN("WeNoteHtmlFile");
        paramaca.pz(true);
        paramaca.nC(e.avI(paramString));
        paramaca.anA(".htm");
        localLinkedList.add(paramaca);
        localObject1 = f.o(paramaca);
        if (!e.cN((String)localObject1)) {
          e.C(paramString, (String)localObject1);
        }
        paramaca.anE((String)localObject1);
      }
    }
    Object localObject1 = new aca();
    Object localObject2 = new acb();
    Object localObject3 = new acc();
    ((acc)localObject3).MM(6);
    ((acb)localObject2).c((acc)localObject3);
    ((aca)localObject1).a((acb)localObject2);
    switch (paramaca.type)
    {
    }
    for (;;)
    {
      ((aca)localObject1).anN(paramaca.vxr);
      localLinkedList.add(localObject1);
      break;
      ((aca)localObject1).MI(2);
      localObject2 = (p)paramaca;
      localObject3 = ((p)localObject2).vxt;
      ((aca)localObject1).anE((String)localObject3);
      if (!bo.isNullOrNil(((p)paramaca).mBq))
      {
        ((aca)localObject1).anD(paramaca.mBq);
        ((aca)localObject1).anF(((p)localObject2).cBD);
      }
      for (;;)
      {
        ((aca)localObject1).MI(2);
        break;
        ((aca)localObject1).anD(f.ajF(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.d.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.c((aca)localObject1));
        ((aca)localObject1).anF(f.c((aca)localObject1));
      }
      ((aca)localObject1).MI(6);
      localObject2 = (s)paramaca;
      ((aca)localObject1).anD(paramaca.mBq);
      localObject3 = new ach();
      ((ach)localObject3).aoe(((s)localObject2).fBq);
      ((ach)localObject3).D(((s)localObject2).lat);
      ((ach)localObject3).C(((s)localObject2).lng);
      ((ach)localObject3).MN((int)((s)localObject2).scale);
      ((ach)localObject3).aof(((s)localObject2).eSM);
      ((aca)localObject1).py(true);
      ((aca)localObject1).pz(true);
      ((aca)localObject1).wTw.a((ach)localObject3);
      continue;
      ((aca)localObject1).MI(8);
      localObject2 = (u)paramaca;
      ((aca)localObject1).anD(paramaca.mBq);
      ((aca)localObject1).anE(((u)localObject2).cBD);
      ((aca)localObject1).pz(true);
      ((aca)localObject1).anq(((u)localObject2).title);
      ((aca)localObject1).anr(((u)localObject2).content);
      ((aca)localObject1).anA(((u)localObject2).vxi);
      continue;
      ((aca)localObject1).MI(3);
      localObject2 = (v)paramaca;
      ((aca)localObject1).anD(paramaca.mBq);
      localObject3 = ((v)localObject2).cBD;
      if ((bo.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((aca)localObject1).anE((String)localObject3);
      ((aca)localObject1).MH(((v)localObject2).cvf);
      ((aca)localObject1).pz(true);
      ((aca)localObject1).anA(((v)localObject2).vxi);
      continue;
      ((aca)localObject1).MI(4);
      localObject2 = (k)paramaca;
      ((aca)localObject1).anD(paramaca.mBq);
      ((aca)localObject1).anE(((k)localObject2).cBD);
      ((aca)localObject1).anF(((k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.d.Zo(((k)localObject2).cBD);
      if (localObject3 != null) {
        ((aca)localObject1).MH(((com.tencent.mm.plugin.sight.base.a)localObject3).cmu());
      }
      for (;;)
      {
        ((aca)localObject1).anA(((k)localObject2).vxi);
        break;
        ((aca)localObject1).MH(1);
      }
      if (!vwd)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14547, new Object[] { Integer.valueOf(6) });
        vwd = true;
      }
      ((aca)localObject1).MI(1);
      ((aca)localObject1).py(true);
      ((aca)localObject1).pz(true);
      localObject2 = (i)paramaca;
      ((aca)localObject1).anD(paramaca.mBq);
      ((aca)localObject1).anr(com.tencent.mm.plugin.wenote.b.b.ajQ(((i)localObject2).content));
      if ((!bo.isNullOrNil(((aca)localObject1).desc)) && (((aca)localObject1).desc.length() > 1000)) {
        ((aca)localObject1).anr(((aca)localObject1).desc.substring(0, 1000));
      }
    }
    label914:
    a(localLinkedList, paramList);
    localacq.aJ(localLinkedList);
    return localacq;
  }
  
  private static void a(LinkedList<aca> paramLinkedList, List<o> paramList)
  {
    ab.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        aca localaca = (aca)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bo.isNullOrNil(localaca.wSC)))
        {
          localaca.anD(f.ajF(localaca.toString()));
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
          if ((localObject != null) && (((o)localObject).vxr != null) && (((o)localObject).vxr.equals(localaca.wTE))) {
            ((o)localObject).mBq = localaca.mBq;
          }
        }
        if ((i > 0) && (!bo.isNullOrNil(localaca.wSC)) && (!bo.isNullOrNil(localaca.wSE)))
        {
          localaca.py(true);
          localaca.pz(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ab.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localaca.dataType) });
          localObject = localaca.wTa;
          String str2;
          if (e.cN((String)localObject))
          {
            ab.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = e.avP((String)localObject);
            str2 = com.tencent.mm.a.g.w(e.i((String)localObject, 0, 256));
            localaca.anB(str1);
            localaca.anC(str2);
            localaca.nC(new com.tencent.mm.vfs.b((String)localObject).length());
            str1 = f.o(localaca);
            boolean bool = e.cN(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localaca.wTE))) {
              e.C((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localaca.wTc;
            if (!e.cN((String)localObject)) {
              break label516;
            }
            ab.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = e.avP((String)localObject);
            str2 = com.tencent.mm.a.g.cT((String)localObject);
            localaca.anG(str1);
            localaca.anH(str2);
            localaca.nD(new com.tencent.mm.vfs.b((String)localObject).length());
            str1 = f.c(localaca);
            if ((((String)localObject).equals(str1)) || (e.cN(str1))) {
              break;
            }
            e.C((String)localObject, str1);
            break;
            ab.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          ab.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  private void bn(Context paramContext, String paramString)
  {
    paramString = (k)this.vvW.get(paramString);
    if (bo.isNullOrNil(paramString.cBD)) {
      return;
    }
    if (!e.cN(paramString.cBD))
    {
      localObject = ajE(paramString.mBq);
      if (localObject == null)
      {
        ab.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      n((aca)localObject);
    }
    Object localObject = new Intent();
    if (this.vvT == null) {
      ((Intent)localObject).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_detail_fav_path", paramString.cBD);
      ((Intent)localObject).putExtra("key_detail_fav_thumb_path", paramString.thumbPath);
      ((Intent)localObject).putExtra("key_detail_fav_video_duration", paramString.duration);
      ((Intent)localObject).putExtra("key_detail_data_id", paramString.mBq);
      ((Intent)localObject).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject).putExtra("key_detail_fav_video_show_download_status", true);
      com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject, 1);
      return;
      ((Intent)localObject).putExtra("key_detail_info_id", this.vvT.field_localId);
    }
  }
  
  public abstract void a(aca paramaca, String paramString);
  
  public void ajD(String paramString) {}
  
  public final aca ajE(String paramString)
  {
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.vvV.get(paramString);
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (o)this.vvW.get(str);
    if (paramString == null)
    {
      ab.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.vxq;
  }
  
  public abstract String b(aca paramaca);
  
  public final void b(li paramli)
  {
    if (paramli.cBr == null)
    {
      ab.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
      return;
    }
    String str = paramli.cBr.cBt;
    o localo = (o)this.vvW.get(str);
    if (localo == null)
    {
      ab.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
      return;
    }
    ab.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", new Object[] { Integer.valueOf(localo.type) });
    switch (localo.type)
    {
    case 4: 
    default: 
      return;
    case 2: 
      bm(paramli.cBr.context, str);
      return;
    case 5: 
      bk(paramli.cBr.context, str);
      return;
    case 3: 
      bl(paramli.cBr.context, str);
      return;
    }
    bn(paramli.cBr.context, str);
  }
  
  public abstract void bk(Context paramContext, String paramString);
  
  public abstract void bl(Context paramContext, String paramString);
  
  public abstract void bm(Context paramContext, String paramString);
  
  public abstract String c(aca paramaca);
  
  public String dhI()
  {
    return "";
  }
  
  public final void el(List<aca> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<aca>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      aca localaca = (aca)localIterator.next();
      o localo = new o();
      localo.vxr = localaca.wTE;
      if (localaca.dataType == 1) {
        localo.vxr = "-1";
      }
      if (bo.isNullOrNil(localo.vxr))
      {
        ab.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = b(localaca);
        if ((!bo.isNullOrNil(paramList)) && (e.cN(paramList)))
        {
          f.z(this.vvS.cBE, paramList);
          return;
        }
        n(localaca);
        return;
      }
      if (localo.vxr.equals("WeNoteHtmlFile"))
      {
        localObject1 = b(localaca);
        if ((!bo.isNullOrNil((String)localObject1)) && (e.cN((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.vxH = e.cS((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.b.b.ajP(localw.vxH);
              paramList = (List<aca>)localObject1;
              try
              {
                ab.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localaca.mBq });
                vwa.containsKey(localw.vxH);
                ab.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(bo.isNullOrNil(localaca.wSC)), Boolean.valueOf(bo.isNullOrNil(localaca.wSE)) });
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
          ab.printErrStackTrace("MicroMsg.WNNoteBase", localException1, "", new Object[0]);
          continue;
          n(localaca);
          localw.vxJ = true;
          ab.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localaca.mBq });
          this.vvV.put(localaca.mBq, localo.vxr);
        }
      }
      if (!localo.vxr.equals("-1"))
      {
        i = bo.getInt(localo.vxr.substring(7), 0);
        j = bo.getInt(this.vvX.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.vvX = ((String)localObject2);
        localo.mBq = localaca.mBq;
        switch (localaca.dataType)
        {
        default: 
          if (localaca.dataType <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).vxr = localo.vxr;
          ((n)localObject2).type = 0;
          ((n)localObject2).mBq = localo.mBq;
          ((n)localObject2).vxq = localaca;
          localObject3 = b(localaca);
          ((n)localObject2).vxs = true;
          ((n)localObject2).cBD = ((String)localObject3);
          ((n)localObject2).hPe = vwi;
          ((n)localObject2).title = ah.getContext().getResources().getString(2131299798);
          ((n)localObject2).content = ah.getContext().getResources().getString(2131299765);
          localw.vxI.add(localObject2);
          this.vvW.put(localo.vxr, localObject2);
          break label23;
        }
      }
      if (!bo.isNullOrNil(localaca.desc)) {
        if ((localw.vxI.size() > 0) && (localw.vxI.get(localw.vxI.size() - 1) != null) && (((o)localw.vxI.get(localw.vxI.size() - 1)).vxr.equals("-1")))
        {
          localObject2 = (t)localw.vxI.get(localw.vxI.size() - 1);
          ((t)localObject2).content += localaca.desc;
        }
        else
        {
          localObject2 = new i();
          ((t)localObject2).vxr = localo.vxr;
          ((t)localObject2).content = localaca.desc;
          localw.vxI.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).vxr = localo.vxr;
          ((p)localObject2).type = 2;
          ((p)localObject2).mBq = localo.mBq;
          ((p)localObject2).vxq = localaca;
          localObject3 = b(localaca);
          if (!bo.isNullOrNil((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = c(localaca);
            if (!e.cN(str)) {
              a(localaca, str);
            }
            if (e.cN((String)localObject3))
            {
              ((p)localObject2).vxs = true;
              com.tencent.mm.plugin.wenote.b.c.hJ((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).cBD = ((String)localObject4);
              ((p)localObject2).vxt = ((String)localObject3);
              localw.vxI.add(localObject2);
              this.vvW.put(localo.vxr, localObject2);
              break;
              n(localaca);
              ((p)localObject2).vxs = false;
              this.vvV.put(localaca.mBq, localo.vxr);
            }
            if (localaca.dataType == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!bo.isNullOrNil(localaca.wSC))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).qSZ = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).vxr = localo.vxr;
              ((v)localObject2).type = 4;
              ((v)localObject2).mBq = localo.mBq;
              ((v)localObject2).vxq = localaca;
              localObject3 = b(localaca);
              if ((bo.isNullOrNil((String)localObject3)) || (!e.cN((String)localObject3))) {
                break label1315;
              }
              ((v)localObject2).vxs = true;
              ((v)localObject2).hPe = vwe;
              ((v)localObject2).length = ((int)f.hi(localaca.duration));
            }
            for (;;)
            {
              ((v)localObject2).cBD = ((String)localObject3);
              ((v)localObject2).vxF = f.L(ah.getContext(), (int)f.hi(localaca.duration));
              ((v)localObject2).cvf = localaca.duration;
              localObject3 = new gi();
              ((gi)localObject3).cuX.type = 17;
              ((gi)localObject3).cuX.cuZ = localaca;
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
              ((v)localObject2).cve = ((gi)localObject3).cuY.ret;
              ((v)localObject2).vxi = localaca.wSR;
              localw.vxI.add(localObject2);
              this.vvW.put(localo.vxr, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1315:
              n(localaca);
              ((v)localObject2).vxs = false;
              ((v)localObject2).vxG = ah.getContext().getString(2131299861);
              this.vvV.put(localaca.mBq, localo.vxr);
            }
            localObject2 = new r();
            ((r)localObject2).cyV = ((float)localaca.wTw.wUd.lat);
            ((r)localObject2).fFN = ((float)localaca.wTw.wUd.lng);
            ((r)localObject2).cyX = localaca.wTw.wUd.cyX;
            ((r)localObject2).vxB = localaca.wTw.wUd.label;
            ((r)localObject2).vxC = localaca.wTw.wUd.cDl;
            ((r)localObject2).vxD = localaca.wTE;
            localObject3 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((s)localObject3).vxr = localo.vxr;
            ((s)localObject3).type = 3;
            ((s)localObject3).mBq = localo.mBq;
            ((s)localObject3).vxq = localaca;
            ((s)localObject3).vxs = true;
            ((s)localObject3).eSM = ((r)localObject2).vxC;
            ((s)localObject3).fBq = ((r)localObject2).vxB;
            ((s)localObject3).lat = ((r)localObject2).cyV;
            ((s)localObject3).lng = ((r)localObject2).fFN;
            ((s)localObject3).scale = ((r)localObject2).cyX;
            ((s)localObject3).cBD = "";
            localw.vxI.add(localObject3);
            this.vvW.put(localo.vxr, localObject3);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((u)localObject2).vxr = localo.vxr;
            ((u)localObject2).type = 5;
            ((u)localObject2).mBq = localo.mBq;
            ((u)localObject2).vxq = localaca;
            localObject3 = b(localaca);
            if ((!bo.isNullOrNil((String)localObject3)) && (e.cN((String)localObject3)))
            {
              ((u)localObject2).vxs = true;
              ((u)localObject2).cBD = ((String)localObject3);
            }
            for (;;)
            {
              ((u)localObject2).hPe = h.ajJ(localaca.wSR);
              ((u)localObject2).title = localaca.title;
              ((u)localObject2).content = localaca.desc;
              ((u)localObject2).vxi = localaca.wSR;
              if (bo.isNullOrNil(((u)localObject2).content)) {
                ((u)localObject2).content = f.aJ((float)localaca.wSX);
              }
              localw.vxI.add(localObject2);
              this.vvW.put(localo.vxr, localObject2);
              break;
              ((u)localObject2).vxs = false;
              this.vvV.put(localaca.mBq, localo.vxr);
            }
            localObject2 = new k();
            ((k)localObject2).vxr = localo.vxr;
            ((k)localObject2).type = 6;
            ((k)localObject2).mBq = localo.mBq;
            ((k)localObject2).vxq = localaca;
            if (localaca != null) {
              ((k)localObject2).duration = localaca.duration;
            }
            ((k)localObject2).thumbPath = c(localaca);
            localObject3 = b(localaca);
            ((k)localObject2).cBD = ((String)localObject3);
            if ((!bo.isNullOrNil(((k)localObject2).thumbPath)) && (!e.cN(((k)localObject2).thumbPath)))
            {
              if (!e.cN((String)localObject3)) {
                break label2022;
              }
              localObject4 = com.tencent.mm.plugin.fav.ui.c.NW((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                ab.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.i.f.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((k)localObject2).thumbPath, true);
                if ((bo.isNullOrNil((String)localObject3)) || (!e.cN((String)localObject3))) {
                  break label2073;
                }
                ((k)localObject2).vxs = true;
                localw.vxI.add(localObject2);
                this.vvW.put(localo.vxr, localObject2);
              }
              catch (Exception localException3)
              {
                ab.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              label2022:
              a(localaca, ((k)localObject2).thumbPath);
              this.vvV.put(localaca.mBq + "_t", localo.vxr);
              continue;
              label2073:
              ((k)localObject2).vxs = false;
              this.vvV.put(localaca.mBq, localo.vxr);
            }
          }
        }
      }
    }
    label654:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.vxI, paramList, true);
    }
    if (this.vvS.cpO == -1L)
    {
      this.vvU.put(Long.toString(this.vvS.cBE), localw);
      return;
    }
    this.vvU.put(Long.toString(this.vvS.cpO), localw);
  }
  
  public abstract void n(aca paramaca);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */