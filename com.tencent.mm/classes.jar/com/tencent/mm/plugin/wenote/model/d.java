package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.h.a.ku.a;
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
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.c.xv;>;
import org.json.JSONArray;

public abstract class d
{
  public static String rFq = "";
  public static HashMap<String, JSONArray> rFr = new HashMap();
  public static boolean rFu = false;
  public static String rFv = an.aQK() + "/fav_fileicon_recording.png";
  private static String rFw = an.aQK() + "/ofm_file_icon.png";
  private static String rFx = an.aQK() + "/app_attach_file_icon_pic.png";
  public static String rFy = an.aQK() + "/location_msg.png";
  public static String rFz = an.aQK() + "/note_fav_not_support.png";
  public m rFj = null;
  public com.tencent.mm.plugin.fav.a.g rFk;
  public HashMap<String, w> rFl = new HashMap();
  public HashMap<String, String> rFm = new HashMap();
  public HashMap<String, o> rFn = new HashMap();
  public String rFo = "WeNote_0";
  public String rFp = "";
  public boolean rFs = false;
  public yj rFt = new yj();
  
  public static yj a(String paramString, List<o> paramList, xv paramxv)
  {
    LinkedList localLinkedList = new LinkedList();
    yj localyj = new yj();
    if (paramxv != null) {
      localLinkedList.add(paramxv);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label914;
        }
        paramxv = (o)paramString.next();
        if (paramxv != null)
        {
          if (paramxv.rGH == null) {
            break;
          }
          localLinkedList.add(paramxv.rGH);
        }
      }
      if ((!bk.bl(paramString)) && (paramString.length() > 0))
      {
        paramString = an.aQN();
        paramxv = new xv();
        paramxv.EH(8);
        paramxv.XR("WeNoteHtmlFile");
        paramxv.mk(true);
        paramxv.hf(com.tencent.mm.vfs.e.aeQ(paramString));
        paramxv.XE(".htm");
        localLinkedList.add(paramxv);
        localObject1 = f.o(paramxv);
        if (!com.tencent.mm.vfs.e.bK((String)localObject1)) {
          com.tencent.mm.vfs.e.r(paramString, (String)localObject1);
        }
        paramxv.XI((String)localObject1);
      }
    }
    Object localObject1 = new xv();
    Object localObject2 = new xw();
    Object localObject3 = new xx();
    ((xx)localObject3).EL(6);
    ((xw)localObject2).c((xx)localObject3);
    ((xv)localObject1).a((xw)localObject2);
    switch (paramxv.type)
    {
    }
    for (;;)
    {
      ((xv)localObject1).XR(paramxv.rGI);
      localLinkedList.add(localObject1);
      break;
      ((xv)localObject1).EH(2);
      localObject2 = (p)paramxv;
      localObject3 = ((p)localObject2).rGK;
      ((xv)localObject1).XI((String)localObject3);
      if (!bk.bl(((p)paramxv).kgC))
      {
        ((xv)localObject1).XH(paramxv.kgC);
        ((xv)localObject1).XJ(((p)localObject2).bTY);
      }
      for (;;)
      {
        ((xv)localObject1).EH(2);
        break;
        ((xv)localObject1).XH(f.Ur(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.c.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.c((xv)localObject1));
        ((xv)localObject1).XJ(f.c((xv)localObject1));
      }
      ((xv)localObject1).EH(6);
      localObject2 = (s)paramxv;
      ((xv)localObject1).XH(paramxv.kgC);
      localObject3 = new yc();
      ((yc)localObject3).Yh(((s)localObject2).ekZ);
      ((yc)localObject3).z(((s)localObject2).lat);
      ((yc)localObject3).y(((s)localObject2).lng);
      ((yc)localObject3).EM((int)((s)localObject2).rGV);
      ((yc)localObject3).Yi(((s)localObject2).lFn);
      ((xv)localObject1).mj(true);
      ((xv)localObject1).mk(true);
      ((xv)localObject1).sVA.a((yc)localObject3);
      continue;
      ((xv)localObject1).EH(8);
      localObject2 = (u)paramxv;
      ((xv)localObject1).XH(paramxv.kgC);
      ((xv)localObject1).XI(((u)localObject2).bTY);
      ((xv)localObject1).mk(true);
      ((xv)localObject1).Xu(((u)localObject2).title);
      ((xv)localObject1).Xv(((u)localObject2).content);
      ((xv)localObject1).XE(((u)localObject2).rGz);
      continue;
      ((xv)localObject1).EH(3);
      localObject2 = (v)paramxv;
      ((xv)localObject1).XH(paramxv.kgC);
      localObject3 = ((v)localObject2).bTY;
      if ((bk.bl((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((xv)localObject1).XI((String)localObject3);
      ((xv)localObject1).EG(((v)localObject2).bNN);
      ((xv)localObject1).mk(true);
      ((xv)localObject1).XE(((v)localObject2).rGz);
      continue;
      ((xv)localObject1).EH(4);
      localObject2 = (k)paramxv;
      ((xv)localObject1).XH(paramxv.kgC);
      ((xv)localObject1).XI(((k)localObject2).bTY);
      ((xv)localObject1).XJ(((k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.d.MH(((k)localObject2).bTY);
      if (localObject3 != null) {
        ((xv)localObject1).EG(((com.tencent.mm.plugin.sight.base.a)localObject3).bAT());
      }
      for (;;)
      {
        ((xv)localObject1).XE(((k)localObject2).rGz);
        break;
        ((xv)localObject1).EG(1);
      }
      if (!rFu)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14547, new Object[] { Integer.valueOf(6) });
        rFu = true;
      }
      ((xv)localObject1).EH(1);
      ((xv)localObject1).mj(true);
      ((xv)localObject1).mk(true);
      localObject2 = (i)paramxv;
      ((xv)localObject1).XH(paramxv.kgC);
      ((xv)localObject1).Xv(com.tencent.mm.plugin.wenote.b.b.UB(((i)localObject2).content));
      if ((!bk.bl(((xv)localObject1).desc)) && (((xv)localObject1).desc.length() > 1000)) {
        ((xv)localObject1).Xv(((xv)localObject1).desc.substring(0, 1000));
      }
    }
    label914:
    a(localLinkedList, paramList);
    localyj.az(localLinkedList);
    return localyj;
  }
  
  private static void a(LinkedList<xv> paramLinkedList, List<o> paramList)
  {
    y.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        xv localxv = (xv)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bk.bl(localxv.sUG)))
        {
          localxv.XH(f.Ur(localxv.toString()));
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
          if ((localObject != null) && (((o)localObject).rGI != null) && (((o)localObject).rGI.equals(localxv.sVI))) {
            ((o)localObject).kgC = localxv.kgC;
          }
        }
        if ((i > 0) && (!bk.bl(localxv.sUG)) && (!bk.bl(localxv.sUI)))
        {
          localxv.mj(true);
          localxv.mk(true);
        }
        for (;;)
        {
          i += 1;
          break;
          y.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localxv.aYU) });
          localObject = localxv.sVe;
          String str2;
          if (com.tencent.mm.vfs.e.bK((String)localObject))
          {
            y.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.e.aeY((String)localObject);
            str2 = com.tencent.mm.a.g.o(com.tencent.mm.vfs.e.c((String)localObject, 0, 256));
            localxv.XF(str1);
            localxv.XG(str2);
            localxv.hf(new com.tencent.mm.vfs.b((String)localObject).length());
            str1 = f.o(localxv);
            boolean bool = com.tencent.mm.vfs.e.bK(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localxv.sVI))) {
              com.tencent.mm.vfs.e.r((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localxv.sVg;
            if (!com.tencent.mm.vfs.e.bK((String)localObject)) {
              break label516;
            }
            y.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.e.aeY((String)localObject);
            str2 = com.tencent.mm.a.g.bR((String)localObject);
            localxv.XK(str1);
            localxv.XL(str2);
            localxv.hg(new com.tencent.mm.vfs.b((String)localObject).length());
            str1 = f.c(localxv);
            if ((((String)localObject).equals(str1)) || (com.tencent.mm.vfs.e.bK(str1))) {
              break;
            }
            com.tencent.mm.vfs.e.r((String)localObject, str1);
            break;
            y.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          y.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  public void Up(String paramString) {}
  
  public final xv Uq(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.rFm.get(paramString);
    if (bk.bl(str))
    {
      y.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (o)this.rFn.get(str);
    if (paramString == null)
    {
      y.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.rGH;
  }
  
  public abstract void a(xv paramxv, String paramString);
  
  public abstract void aZ(Context paramContext, String paramString);
  
  public abstract String b(xv paramxv);
  
  public final void b(ku paramku)
  {
    if (paramku.bTL == null) {
      y.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = paramku.bTL.bTN;
      localObject2 = (o)this.rFn.get(localObject1);
      if (localObject2 == null)
      {
        y.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
        return;
      }
      y.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", new Object[] { Integer.valueOf(((o)localObject2).type) });
      switch (((o)localObject2).type)
      {
      case 4: 
      default: 
        return;
      case 2: 
        bb(paramku.bTL.context, (String)localObject1);
        return;
      case 5: 
        aZ(paramku.bTL.context, (String)localObject1);
        return;
      case 3: 
        ba(paramku.bTL.context, (String)localObject1);
        return;
      }
      paramku = paramku.bTL.context;
      localObject1 = (k)this.rFn.get(localObject1);
    } while (bk.bl(((k)localObject1).bTY));
    if (!com.tencent.mm.vfs.e.bK(((k)localObject1).bTY))
    {
      localObject2 = Uq(((k)localObject1).kgC);
      if (localObject2 == null)
      {
        y.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      n((xv)localObject2);
    }
    Object localObject2 = new Intent();
    if (this.rFk == null) {
      ((Intent)localObject2).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("key_detail_fav_path", ((k)localObject1).bTY);
      ((Intent)localObject2).putExtra("key_detail_fav_thumb_path", ((k)localObject1).thumbPath);
      ((Intent)localObject2).putExtra("key_detail_fav_video_duration", ((k)localObject1).duration);
      ((Intent)localObject2).putExtra("key_detail_data_id", ((k)localObject1).kgC);
      ((Intent)localObject2).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject2).putExtra("key_detail_fav_video_show_download_status", true);
      com.tencent.mm.plugin.fav.a.b.b(paramku, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject2, 1);
      return;
      ((Intent)localObject2).putExtra("key_detail_info_id", this.rFk.field_localId);
    }
  }
  
  public abstract void ba(Context paramContext, String paramString);
  
  public abstract void bb(Context paramContext, String paramString);
  
  public abstract String c(xv paramxv);
  
  public String chv()
  {
    return "";
  }
  
  public final void df(List<xv> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<xv>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      xv localxv = (xv)localIterator.next();
      o localo = new o();
      localo.rGI = localxv.sVI;
      if (localxv.aYU == 1) {
        localo.rGI = "-1";
      }
      if (bk.bl(localo.rGI))
      {
        y.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = b(localxv);
        if ((!bk.bl(paramList)) && (com.tencent.mm.vfs.e.bK(paramList)))
        {
          f.y(this.rFj.bTZ, paramList);
          return;
        }
        n(localxv);
        return;
      }
      if (localo.rGI.equals("WeNoteHtmlFile"))
      {
        localObject1 = b(localxv);
        if ((!bk.bl((String)localObject1)) && (com.tencent.mm.vfs.e.bK((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.rGZ = com.tencent.mm.vfs.e.bP((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.b.b.UA(localw.rGZ);
              paramList = (List<xv>)localObject1;
              try
              {
                y.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localxv.kgC });
                rFr.containsKey(localw.rGZ);
                y.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(bk.bl(localxv.sUG)), Boolean.valueOf(bk.bl(localxv.sUI)) });
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
          y.printErrStackTrace("MicroMsg.WNNoteBase", localException1, "", new Object[0]);
          continue;
          n(localxv);
          localw.rHb = true;
          y.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localxv.kgC });
          this.rFm.put(localxv.kgC, localo.rGI);
        }
      }
      if (!localo.rGI.equals("-1"))
      {
        i = bk.getInt(localo.rGI.substring(7), 0);
        j = bk.getInt(this.rFo.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.rFo = ((String)localObject2);
        localo.kgC = localxv.kgC;
        switch (localxv.aYU)
        {
        default: 
          if (localxv.aYU <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).rGI = localo.rGI;
          ((n)localObject2).type = 0;
          ((n)localObject2).kgC = localo.kgC;
          ((n)localObject2).rGH = localxv;
          localObject3 = b(localxv);
          ((n)localObject2).rGJ = true;
          ((n)localObject2).bTY = ((String)localObject3);
          ((n)localObject2).gum = rFz;
          ((n)localObject2).title = ae.getContext().getResources().getString(R.l.favorite_record_no_support_type);
          ((n)localObject2).content = ae.getContext().getResources().getString(R.l.favorite_oldversion_content);
          localw.rHa.add(localObject2);
          this.rFn.put(localo.rGI, localObject2);
          break label23;
        }
      }
      if (!bk.bl(localxv.desc)) {
        if ((localw.rHa.size() > 0) && (localw.rHa.get(localw.rHa.size() - 1) != null) && (((o)localw.rHa.get(localw.rHa.size() - 1)).rGI.equals("-1")))
        {
          localObject2 = (t)localw.rHa.get(localw.rHa.size() - 1);
          ((t)localObject2).content += localxv.desc;
        }
        else
        {
          localObject2 = new i();
          ((t)localObject2).rGI = localo.rGI;
          ((t)localObject2).content = localxv.desc;
          localw.rHa.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).rGI = localo.rGI;
          ((p)localObject2).type = 2;
          ((p)localObject2).kgC = localo.kgC;
          ((p)localObject2).rGH = localxv;
          localObject3 = b(localxv);
          if (!bk.bl((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = c(localxv);
            if (!com.tencent.mm.vfs.e.bK(str)) {
              a(localxv, str);
            }
            if (com.tencent.mm.vfs.e.bK((String)localObject3))
            {
              ((p)localObject2).rGJ = true;
              com.tencent.mm.plugin.wenote.b.c.fI((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).bTY = ((String)localObject4);
              ((p)localObject2).rGK = ((String)localObject3);
              localw.rHa.add(localObject2);
              this.rFn.put(localo.rGI, localObject2);
              break;
              n(localxv);
              ((p)localObject2).rGJ = false;
              this.rFm.put(localxv.kgC, localo.rGI);
            }
            if (localxv.aYU == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!bk.bl(localxv.sUG))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).oeK = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).rGI = localo.rGI;
              ((v)localObject2).type = 4;
              ((v)localObject2).kgC = localo.kgC;
              ((v)localObject2).rGH = localxv;
              localObject3 = b(localxv);
              if ((bk.bl((String)localObject3)) || (!com.tencent.mm.vfs.e.bK((String)localObject3))) {
                break label1315;
              }
              ((v)localObject2).rGJ = true;
              ((v)localObject2).gum = rFv;
              ((v)localObject2).length = ((int)f.ck(localxv.duration));
            }
            for (;;)
            {
              ((v)localObject2).bTY = ((String)localObject3);
              ((v)localObject2).rGX = f.B(ae.getContext(), (int)f.ck(localxv.duration));
              ((v)localObject2).bNN = localxv.duration;
              localObject3 = new gf();
              ((gf)localObject3).bNF.type = 17;
              ((gf)localObject3).bNF.bNH = localxv;
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
              ((v)localObject2).bNM = ((gf)localObject3).bNG.ret;
              ((v)localObject2).rGz = localxv.sUV;
              localw.rHa.add(localObject2);
              this.rFn.put(localo.rGI, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1315:
              n(localxv);
              ((v)localObject2).rGJ = false;
              ((v)localObject2).rGY = ae.getContext().getString(R.l.favorite_wenote_voice_downloading);
              this.rFm.put(localxv.kgC, localo.rGI);
            }
            localObject2 = new r();
            ((r)localObject2).bRt = ((float)localxv.sVA.sWf.lat);
            ((r)localObject2).epo = ((float)localxv.sVA.sWf.lng);
            ((r)localObject2).bRv = localxv.sVA.sWf.bRv;
            ((r)localObject2).rGS = localxv.sVA.sWf.label;
            ((r)localObject2).rGT = localxv.sVA.sWf.bVA;
            ((r)localObject2).rGU = localxv.sVI;
            localObject3 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((s)localObject3).rGI = localo.rGI;
            ((s)localObject3).type = 3;
            ((s)localObject3).kgC = localo.kgC;
            ((s)localObject3).rGH = localxv;
            ((s)localObject3).rGJ = true;
            ((s)localObject3).lFn = ((r)localObject2).rGT;
            ((s)localObject3).ekZ = ((r)localObject2).rGS;
            ((s)localObject3).lat = ((r)localObject2).bRt;
            ((s)localObject3).lng = ((r)localObject2).epo;
            ((s)localObject3).rGV = ((r)localObject2).bRv;
            ((s)localObject3).bTY = "";
            localw.rHa.add(localObject3);
            this.rFn.put(localo.rGI, localObject3);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((u)localObject2).rGI = localo.rGI;
            ((u)localObject2).type = 5;
            ((u)localObject2).kgC = localo.kgC;
            ((u)localObject2).rGH = localxv;
            localObject3 = b(localxv);
            if ((!bk.bl((String)localObject3)) && (com.tencent.mm.vfs.e.bK((String)localObject3)))
            {
              ((u)localObject2).rGJ = true;
              ((u)localObject2).bTY = ((String)localObject3);
            }
            for (;;)
            {
              ((u)localObject2).gum = h.Uv(localxv.sUV);
              ((u)localObject2).title = localxv.title;
              ((u)localObject2).content = localxv.desc;
              ((u)localObject2).rGz = localxv.sUV;
              if (bk.bl(((u)localObject2).content)) {
                ((u)localObject2).content = f.ar((float)localxv.sVb);
              }
              localw.rHa.add(localObject2);
              this.rFn.put(localo.rGI, localObject2);
              break;
              ((u)localObject2).rGJ = false;
              this.rFm.put(localxv.kgC, localo.rGI);
            }
            localObject2 = new k();
            ((k)localObject2).rGI = localo.rGI;
            ((k)localObject2).type = 6;
            ((k)localObject2).kgC = localo.kgC;
            ((k)localObject2).rGH = localxv;
            if (localxv != null) {
              ((k)localObject2).duration = localxv.duration;
            }
            ((k)localObject2).thumbPath = c(localxv);
            localObject3 = b(localxv);
            ((k)localObject2).bTY = ((String)localObject3);
            if ((!bk.bl(((k)localObject2).thumbPath)) && (!com.tencent.mm.vfs.e.bK(((k)localObject2).thumbPath)))
            {
              if (!com.tencent.mm.vfs.e.bK((String)localObject3)) {
                break label2022;
              }
              localObject4 = com.tencent.mm.plugin.fav.ui.c.CU((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                y.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.i.e.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((k)localObject2).thumbPath, true);
                if ((bk.bl((String)localObject3)) || (!com.tencent.mm.vfs.e.bK((String)localObject3))) {
                  break label2073;
                }
                ((k)localObject2).rGJ = true;
                localw.rHa.add(localObject2);
                this.rFn.put(localo.rGI, localObject2);
              }
              catch (Exception localException3)
              {
                y.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              label2022:
              a(localxv, ((k)localObject2).thumbPath);
              this.rFm.put(localxv.kgC + "_t", localo.rGI);
              continue;
              label2073:
              ((k)localObject2).rGJ = false;
              this.rFm.put(localxv.kgC, localo.rGI);
            }
          }
        }
      }
    }
    label654:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.rHa, paramList, true);
    }
    if (this.rFj.bIt == -1L)
    {
      this.rFl.put(Long.toString(this.rFj.bTZ), localw);
      return;
    }
    this.rFl.put(Long.toString(this.rFj.bIt), localw);
  }
  
  public abstract void n(xv paramxv);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */