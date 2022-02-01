package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.nk.a;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.c.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.ajx;>;
import org.json.JSONArray;

public abstract class d
{
  public static boolean ERl = false;
  public static String pzM = "";
  public static HashMap<String, JSONArray> pzN = new HashMap();
  public static String pzO = ao.cxc() + "/fav_fileicon_recording.png";
  private static String pzP = ao.cxc() + "/ofm_file_icon.png";
  private static String pzQ = ao.cxc() + "/app_attach_file_icon_pic.png";
  public static String pzR = ao.cxc() + "/location_msg.png";
  public static String pzS = ao.cxc() + "/note_fav_not_support.png";
  public m ERc = null;
  public com.tencent.mm.plugin.fav.a.g ERd;
  public HashMap<String, w> ERe = new HashMap();
  public HashMap<String, String> ERf = new HashMap();
  public HashMap<String, com.tencent.mm.plugin.wenote.model.a.o> ERg = new HashMap();
  public String ERh = "WeNote_0";
  public String ERi = "";
  public boolean ERj = false;
  public akn ERk = new akn();
  public String ERm = "";
  public int ERn = 0;
  
  public static akn a(String paramString, List<com.tencent.mm.plugin.wenote.model.a.o> paramList, ajx paramajx)
  {
    LinkedList localLinkedList = new LinkedList();
    akn localakn = new akn();
    if (paramajx != null) {
      localLinkedList.add(paramajx);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label914;
        }
        paramajx = (com.tencent.mm.plugin.wenote.model.a.o)paramString.next();
        if (paramajx != null)
        {
          if (paramajx.pAv == null) {
            break;
          }
          localLinkedList.add(paramajx.pAv);
        }
      }
      if ((!bu.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cxf();
        paramajx = new ajx();
        paramajx.aao(8);
        paramajx.aPZ("WeNoteHtmlFile");
        paramajx.wt(true);
        paramajx.De(com.tencent.mm.vfs.o.aZR(paramString));
        paramajx.aPM(".htm");
        localLinkedList.add(paramajx);
        localObject1 = f.b(paramajx);
        if (!com.tencent.mm.vfs.o.fB((String)localObject1)) {
          com.tencent.mm.vfs.o.mF(paramString, (String)localObject1);
        }
        paramajx.aPQ((String)localObject1);
      }
    }
    Object localObject1 = new ajx();
    Object localObject2 = new ajy();
    Object localObject3 = new ajz();
    ((ajz)localObject3).aas(6);
    ((ajy)localObject2).c((ajz)localObject3);
    ((ajx)localObject1).a((ajy)localObject2);
    switch (paramajx.type)
    {
    }
    for (;;)
    {
      ((ajx)localObject1).aPZ(paramajx.pAw);
      localLinkedList.add(localObject1);
      break;
      ((ajx)localObject1).aao(2);
      localObject2 = (p)paramajx;
      localObject3 = ((p)localObject2).pAu;
      ((ajx)localObject1).aPQ((String)localObject3);
      if (!bu.isNullOrNil(((p)paramajx).dua))
      {
        ((ajx)localObject1).aPP(paramajx.dua);
        ((ajx)localObject1).aPR(((p)localObject2).dCC);
      }
      for (;;)
      {
        ((ajx)localObject1).aao(2);
        break;
        ((ajx)localObject1).aPP(f.abL(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.h.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.a((ajx)localObject1));
        ((ajx)localObject1).aPR(f.a((ajx)localObject1));
      }
      ((ajx)localObject1).aao(6);
      localObject2 = (s)paramajx;
      ((ajx)localObject1).aPP(paramajx.dua);
      localObject3 = new ake();
      ((ake)localObject3).aQt(((s)localObject2).hZQ);
      ((ake)localObject3).B(((s)localObject2).lat);
      ((ake)localObject3).A(((s)localObject2).lng);
      ((ake)localObject3).aat((int)((s)localObject2).ESo);
      ((ake)localObject3).aQu(((s)localObject2).jGd);
      ((ajx)localObject1).ws(true);
      ((ajx)localObject1).wt(true);
      ((ajx)localObject1).GAu.c((ake)localObject3);
      continue;
      ((ajx)localObject1).aao(8);
      localObject2 = (u)paramajx;
      ((ajx)localObject1).aPP(paramajx.dua);
      ((ajx)localObject1).aPQ(((u)localObject2).dCC);
      ((ajx)localObject1).wt(true);
      ((ajx)localObject1).aPC(((u)localObject2).title);
      ((ajx)localObject1).aPD(((u)localObject2).content);
      ((ajx)localObject1).aPM(((u)localObject2).pAy);
      continue;
      ((ajx)localObject1).aao(3);
      localObject2 = (v)paramajx;
      ((ajx)localObject1).aPP(paramajx.dua);
      localObject3 = ((v)localObject2).dCC;
      if ((bu.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((ajx)localObject1).aPQ((String)localObject3);
      ((ajx)localObject1).aan(((v)localObject2).duj);
      ((ajx)localObject1).wt(true);
      ((ajx)localObject1).aPM(((v)localObject2).pAy);
      continue;
      ((ajx)localObject1).aao(4);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.k)paramajx;
      ((ajx)localObject1).aPP(paramajx.dua);
      ((ajx)localObject1).aPQ(((com.tencent.mm.plugin.wenote.model.a.k)localObject2).dCC);
      ((ajx)localObject1).aPR(((com.tencent.mm.plugin.wenote.model.a.k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.e.ayN(((com.tencent.mm.plugin.wenote.model.a.k)localObject2).dCC);
      if (localObject3 != null) {
        ((ajx)localObject1).aan(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((ajx)localObject1).aPM(((com.tencent.mm.plugin.wenote.model.a.k)localObject2).pAy);
        break;
        ((ajx)localObject1).aan(1);
      }
      if (!ERl)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(14547, new Object[] { Integer.valueOf(6) });
        ERl = true;
      }
      ((ajx)localObject1).aao(1);
      ((ajx)localObject1).ws(true);
      ((ajx)localObject1).wt(true);
      localObject2 = (i)paramajx;
      ((ajx)localObject1).aPP(paramajx.dua);
      ((ajx)localObject1).aPD(com.tencent.mm.plugin.wenote.c.b.abI(((i)localObject2).content));
      if ((!bu.isNullOrNil(((ajx)localObject1).desc)) && (((ajx)localObject1).desc.length() > 1000)) {
        ((ajx)localObject1).aPD(((ajx)localObject1).desc.substring(0, 1000));
      }
    }
    label914:
    a(localLinkedList, paramList);
    localakn.bm(localLinkedList);
    return localakn;
  }
  
  private static void a(LinkedList<ajx> paramLinkedList, List<com.tencent.mm.plugin.wenote.model.a.o> paramList)
  {
    ae.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        ajx localajx = (ajx)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bu.isNullOrNil(localajx.GzA)))
        {
          localajx.aPP(f.abL(localajx.toString()));
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
          if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.o)localObject).pAw != null) && (((com.tencent.mm.plugin.wenote.model.a.o)localObject).pAw.equals(localajx.GAC))) {
            ((com.tencent.mm.plugin.wenote.model.a.o)localObject).dua = localajx.dua;
          }
        }
        if ((i > 0) && (!bu.isNullOrNil(localajx.GzA)) && (!bu.isNullOrNil(localajx.GzC)))
        {
          localajx.ws(true);
          localajx.wt(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ae.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localajx.dataType) });
          localObject = localajx.GzY;
          String str2;
          if (com.tencent.mm.vfs.o.fB((String)localObject))
          {
            ae.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.o.aRh((String)localObject);
            str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.vfs.o.bb((String)localObject, 0, 256));
            localajx.aPN(str1);
            localajx.aPO(str2);
            localajx.De(new com.tencent.mm.vfs.k((String)localObject).length());
            str1 = f.b(localajx);
            boolean bool = com.tencent.mm.vfs.o.fB(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localajx.GAC))) {
              com.tencent.mm.vfs.o.mF((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localajx.GAa;
            if (!com.tencent.mm.vfs.o.fB((String)localObject)) {
              break label516;
            }
            ae.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.o.aRh((String)localObject);
            str2 = com.tencent.mm.b.g.eu((String)localObject);
            localajx.aPS(str1);
            localajx.aPT(str2);
            localajx.Df(new com.tencent.mm.vfs.k((String)localObject).length());
            str1 = f.a(localajx);
            if ((((String)localObject).equals(str1)) || (com.tencent.mm.vfs.o.fB(str1))) {
              break;
            }
            com.tencent.mm.vfs.o.mF((String)localObject, str1);
            break;
            ae.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          ae.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  private void bG(Context paramContext, String paramString)
  {
    paramString = (com.tencent.mm.plugin.wenote.model.a.k)this.ERg.get(paramString);
    if (bu.isNullOrNil(paramString.dCC)) {
      return;
    }
    if (!com.tencent.mm.vfs.o.fB(paramString.dCC))
    {
      localObject = aLz(paramString.dua);
      if (localObject == null)
      {
        ae.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      p((ajx)localObject);
    }
    Object localObject = new Intent();
    if (this.ERd == null) {
      ((Intent)localObject).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_detail_fav_path", paramString.dCC);
      ((Intent)localObject).putExtra("key_detail_fav_thumb_path", paramString.thumbPath);
      ((Intent)localObject).putExtra("key_detail_fav_video_duration", paramString.duration);
      ((Intent)localObject).putExtra("key_detail_data_id", paramString.dua);
      ((Intent)localObject).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject).putExtra("key_detail_fav_video_show_download_status", true);
      if (paramString.pAv != null) {
        ((Intent)localObject).putExtra("key_detail_msg_uuid", paramString.pAv.ixk);
      }
      com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject, 1);
      return;
      ((Intent)localObject).putExtra("key_detail_info_id", this.ERd.field_localId);
    }
  }
  
  public abstract String a(ajx paramajx);
  
  public abstract void a(ajx paramajx, String paramString);
  
  public void aLy(String paramString) {}
  
  public final ajx aLz(String paramString)
  {
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.ERf.get(paramString);
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (com.tencent.mm.plugin.wenote.model.a.o)this.ERg.get(str);
    if (paramString == null)
    {
      ae.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.pAv;
  }
  
  public final void b(nk paramnk)
  {
    if (paramnk.dCo == null)
    {
      ae.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
      return;
    }
    String str = paramnk.dCo.dCq;
    com.tencent.mm.plugin.wenote.model.a.o localo = (com.tencent.mm.plugin.wenote.model.a.o)this.ERg.get(str);
    if (localo == null)
    {
      ae.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
      return;
    }
    ae.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", new Object[] { Integer.valueOf(localo.type) });
    switch (localo.type)
    {
    case 4: 
    default: 
      return;
    case 2: 
      bF(paramnk.dCo.context, str);
      return;
    case 5: 
      bD(paramnk.dCo.context, str);
      return;
    case 3: 
      bE(paramnk.dCo.context, str);
      return;
    }
    bG(paramnk.dCo.context, str);
  }
  
  public abstract void bD(Context paramContext, String paramString);
  
  public abstract void bE(Context paramContext, String paramString);
  
  public abstract void bF(Context paramContext, String paramString);
  
  public abstract String d(ajx paramajx);
  
  public String fav()
  {
    return "";
  }
  
  public final void hk(List<ajx> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<ajx>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      ajx localajx = (ajx)localIterator.next();
      com.tencent.mm.plugin.wenote.model.a.o localo = new com.tencent.mm.plugin.wenote.model.a.o();
      localo.pAw = localajx.GAC;
      if (localajx.dataType == 1) {
        localo.pAw = "-1";
      }
      if (bu.isNullOrNil(localo.pAw))
      {
        ae.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = d(localajx);
        if ((!bu.isNullOrNil(paramList)) && (com.tencent.mm.vfs.o.fB(paramList)))
        {
          f.J(this.ERc.dCD, paramList);
          return;
        }
        p(localajx);
        return;
      }
      if (localo.pAw.equals("WeNoteHtmlFile"))
      {
        localObject1 = d(localajx);
        if ((!bu.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.o.fB((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.pAC = com.tencent.mm.vfs.o.aZT((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.c.b.abH(localw.pAC);
              paramList = (List<ajx>)localObject1;
              try
              {
                ae.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localajx.dua });
                pzN.containsKey(localw.pAC);
                ae.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(bu.isNullOrNil(localajx.GzA)), Boolean.valueOf(bu.isNullOrNil(localajx.GzC)) });
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
          ae.printErrStackTrace("MicroMsg.WNNoteBase", localException1, "", new Object[0]);
          continue;
          p(localajx);
          localw.pAE = true;
          ae.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localajx.dua });
          this.ERf.put(localajx.dua, localo.pAw);
        }
      }
      if (!localo.pAw.equals("-1"))
      {
        i = bu.getInt(localo.pAw.substring(7), 0);
        j = bu.getInt(this.ERh.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.ERh = ((String)localObject2);
        localo.dua = localajx.dua;
        switch (localajx.dataType)
        {
        default: 
          if (localajx.dataType <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).pAw = localo.pAw;
          ((n)localObject2).type = 0;
          ((n)localObject2).dua = localo.dua;
          ((n)localObject2).pAv = localajx;
          localObject3 = d(localajx);
          ((n)localObject2).pAx = true;
          ((n)localObject2).dCC = ((String)localObject3);
          ((n)localObject2).kVn = pzS;
          ((n)localObject2).title = ak.getContext().getResources().getString(2131758972);
          ((n)localObject2).content = ak.getContext().getResources().getString(2131758937);
          localw.pAD.add(localObject2);
          this.ERg.put(localo.pAw, localObject2);
          break label23;
        }
      }
      if (!bu.isNullOrNil(localajx.desc)) {
        if ((localw.pAD.size() > 0) && (localw.pAD.get(localw.pAD.size() - 1) != null) && (((com.tencent.mm.plugin.wenote.model.a.o)localw.pAD.get(localw.pAD.size() - 1)).pAw.equals("-1")))
        {
          localObject2 = (t)localw.pAD.get(localw.pAD.size() - 1);
          ((t)localObject2).content += localajx.desc;
        }
        else
        {
          localObject2 = new i();
          ((t)localObject2).pAw = localo.pAw;
          ((t)localObject2).content = localajx.desc;
          localw.pAD.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).pAw = localo.pAw;
          ((p)localObject2).type = 2;
          ((p)localObject2).dua = localo.dua;
          ((p)localObject2).pAv = localajx;
          localObject3 = d(localajx);
          if (!bu.isNullOrNil((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = a(localajx);
            if (!com.tencent.mm.vfs.o.fB(str)) {
              a(localajx, str);
            }
            if (com.tencent.mm.vfs.o.fB((String)localObject3))
            {
              ((p)localObject2).pAx = true;
              c.ft((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).dCC = ((String)localObject4);
              ((p)localObject2).pAu = ((String)localObject3);
              localw.pAD.add(localObject2);
              this.ERg.put(localo.pAw, localObject2);
              break;
              p(localajx);
              ((p)localObject2).pAx = false;
              this.ERf.put(localajx.dua, localo.pAw);
            }
            if (localajx.dataType == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!bu.isNullOrNil(localajx.GzA))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).zhV = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).pAw = localo.pAw;
              ((v)localObject2).type = 4;
              ((v)localObject2).dua = localo.dua;
              ((v)localObject2).pAv = localajx;
              localObject3 = d(localajx);
              if ((bu.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.o.fB((String)localObject3))) {
                break label1315;
              }
              ((v)localObject2).pAx = true;
              ((v)localObject2).kVn = pzO;
              ((v)localObject2).length = ((int)f.sI(localajx.duration));
            }
            for (;;)
            {
              ((v)localObject2).dCC = ((String)localObject3);
              ((v)localObject2).pAA = f.R(ak.getContext(), (int)f.sI(localajx.duration));
              ((v)localObject2).duj = localajx.duration;
              localObject3 = new gx();
              ((gx)localObject3).dub.type = 17;
              ((gx)localObject3).dub.dud = localajx;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
              ((v)localObject2).dui = ((gx)localObject3).duc.ret;
              ((v)localObject2).pAy = localajx.GzP;
              localw.pAD.add(localObject2);
              this.ERg.put(localo.pAw, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1315:
              p(localajx);
              ((v)localObject2).pAx = false;
              ((v)localObject2).pAB = ak.getContext().getString(2131759038);
              this.ERf.put(localajx.dua, localo.pAw);
            }
            localObject4 = new r();
            localObject3 = localajx.GAu.GBd;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new ake();
              ((ake)localObject2).aQt("");
              ((ake)localObject2).aQu("");
              ae.e("MicroMsg.WNNoteBase", "locItem is null, dataItemId:" + localajx.dua);
            }
            ((r)localObject4).dzE = ((float)((ake)localObject2).lat);
            ((r)localObject4).iev = ((float)((ake)localObject2).lng);
            ((r)localObject4).dzG = ((ake)localObject2).dzG;
            ((r)localObject4).ESl = ((ake)localObject2).label;
            ((r)localObject4).ESm = ((ake)localObject2).dEv;
            ((r)localObject4).ESn = localajx.GAC;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((s)localObject2).pAw = localo.pAw;
            ((s)localObject2).type = 3;
            ((s)localObject2).dua = localo.dua;
            ((s)localObject2).pAv = localajx;
            ((s)localObject2).pAx = true;
            ((s)localObject2).jGd = ((r)localObject4).ESm;
            ((s)localObject2).hZQ = ((r)localObject4).ESl;
            ((s)localObject2).lat = ((r)localObject4).dzE;
            ((s)localObject2).lng = ((r)localObject4).iev;
            ((s)localObject2).ESo = ((r)localObject4).dzG;
            ((s)localObject2).dCC = "";
            localw.pAD.add(localObject2);
            this.ERg.put(localo.pAw, localObject2);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((u)localObject2).pAw = localo.pAw;
            ((u)localObject2).type = 5;
            ((u)localObject2).dua = localo.dua;
            ((u)localObject2).pAv = localajx;
            localObject3 = d(localajx);
            if ((!bu.isNullOrNil((String)localObject3)) && (com.tencent.mm.vfs.o.fB((String)localObject3)))
            {
              ((u)localObject2).pAx = true;
              ((u)localObject2).dCC = ((String)localObject3);
            }
            for (;;)
            {
              ((u)localObject2).kVn = h.aLD(localajx.GzP);
              ((u)localObject2).title = localajx.title;
              ((u)localObject2).content = localajx.desc;
              ((u)localObject2).pAy = localajx.GzP;
              if (bu.isNullOrNil(((u)localObject2).content)) {
                ((u)localObject2).content = f.ba((float)localajx.GzV);
              }
              localw.pAD.add(localObject2);
              this.ERg.put(localo.pAw, localObject2);
              break;
              ((u)localObject2).pAx = false;
              this.ERf.put(localajx.dua, localo.pAw);
            }
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.k();
            ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).pAw = localo.pAw;
            ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).type = 6;
            ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).dua = localo.dua;
            ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).pAv = localajx;
            if (localajx != null) {
              ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).duration = localajx.duration;
            }
            ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).thumbPath = a(localajx);
            localObject3 = d(localajx);
            ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).dCC = ((String)localObject3);
            if ((!bu.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.k)localObject2).thumbPath)) && (!com.tencent.mm.vfs.o.fB(((com.tencent.mm.plugin.wenote.model.a.k)localObject2).thumbPath)))
            {
              if (!com.tencent.mm.vfs.o.fB((String)localObject3)) {
                break label2063;
              }
              localObject4 = com.tencent.mm.plugin.fav.ui.e.ahE((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                ae.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.l.f.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).thumbPath, true);
                if ((bu.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.o.fB((String)localObject3))) {
                  break label2114;
                }
                ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).pAx = true;
                localw.pAD.add(localObject2);
                this.ERg.put(localo.pAw, localObject2);
              }
              catch (Exception localException3)
              {
                ae.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              a(localajx, ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).thumbPath);
              this.ERf.put(localajx.dua + "_t", localo.pAw);
              continue;
              label2114:
              ((com.tencent.mm.plugin.wenote.model.a.k)localObject2).pAx = false;
              this.ERf.put(localajx.dua, localo.pAw);
            }
          }
        }
      }
    }
    label654:
    label2063:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.pAD, paramList, true);
    }
    if (this.ERc.msgId == -1L)
    {
      this.ERe.put(Long.toString(this.ERc.dCD), localw);
      return;
    }
    this.ERe.put(Long.toString(this.ERc.msgId), localw);
  }
  
  public abstract void p(ajx paramajx);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */