package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.nb.a;
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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.agx;>;
import org.json.JSONArray;

public abstract class d
{
  public static boolean CUS = false;
  public static String oPA = ao.cpW() + "/fav_fileicon_recording.png";
  private static String oPB = ao.cpW() + "/ofm_file_icon.png";
  private static String oPC = ao.cpW() + "/app_attach_file_icon_pic.png";
  public static String oPD = ao.cpW() + "/location_msg.png";
  public static String oPE = ao.cpW() + "/note_fav_not_support.png";
  public static String oPy = "";
  public static HashMap<String, JSONArray> oPz = new HashMap();
  public m CUJ = null;
  public com.tencent.mm.plugin.fav.a.g CUK;
  public HashMap<String, w> CUL = new HashMap();
  public HashMap<String, String> CUM = new HashMap();
  public HashMap<String, o> CUN = new HashMap();
  public String CUO = "WeNote_0";
  public String CUP = "";
  public boolean CUQ = false;
  public ahn CUR = new ahn();
  public String CUT = "";
  public int CUU = 0;
  
  public static ahn a(String paramString, List<o> paramList, agx paramagx)
  {
    LinkedList localLinkedList = new LinkedList();
    ahn localahn = new ahn();
    if (paramagx != null) {
      localLinkedList.add(paramagx);
    }
    for (;;)
    {
      paramString = paramList.iterator();
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label914;
        }
        paramagx = (o)paramString.next();
        if (paramagx != null)
        {
          if (paramagx.oQh == null) {
            break;
          }
          localLinkedList.add(paramagx.oQh);
        }
      }
      if ((!bs.isNullOrNil(paramString)) && (paramString.length() > 0))
      {
        paramString = ao.cpZ();
        paramagx = new agx();
        paramagx.XM(8);
        paramagx.aIZ("WeNoteHtmlFile");
        paramagx.vz(true);
        paramagx.zS(com.tencent.mm.vfs.i.aSp(paramString));
        paramagx.aIM(".htm");
        localLinkedList.add(paramagx);
        localObject1 = f.b(paramagx);
        if (!com.tencent.mm.vfs.i.eA((String)localObject1)) {
          com.tencent.mm.vfs.i.lZ(paramString, (String)localObject1);
        }
        paramagx.aIQ((String)localObject1);
      }
    }
    Object localObject1 = new agx();
    Object localObject2 = new agy();
    Object localObject3 = new agz();
    ((agz)localObject3).XQ(6);
    ((agy)localObject2).c((agz)localObject3);
    ((agx)localObject1).a((agy)localObject2);
    switch (paramagx.type)
    {
    }
    for (;;)
    {
      ((agx)localObject1).aIZ(paramagx.oQi);
      localLinkedList.add(localObject1);
      break;
      ((agx)localObject1).XM(2);
      localObject2 = (p)paramagx;
      localObject3 = ((p)localObject2).oQg;
      ((agx)localObject1).aIQ((String)localObject3);
      if (!bs.isNullOrNil(((p)paramagx).dhw))
      {
        ((agx)localObject1).aIP(paramagx.dhw);
        ((agx)localObject1).aIR(((p)localObject2).dpK);
      }
      for (;;)
      {
        ((agx)localObject1).XM(2);
        break;
        ((agx)localObject1).aIP(f.Xn(localObject2.toString()));
        com.tencent.mm.sdk.platformtools.f.c((String)localObject3, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.a((agx)localObject1));
        ((agx)localObject1).aIR(f.a((agx)localObject1));
      }
      ((agx)localObject1).XM(6);
      localObject2 = (s)paramagx;
      ((agx)localObject1).aIP(paramagx.dhw);
      localObject3 = new ahe();
      ((ahe)localObject3).aJt(((s)localObject2).hEt);
      ((ahe)localObject3).B(((s)localObject2).lat);
      ((ahe)localObject3).A(((s)localObject2).lng);
      ((ahe)localObject3).XR((int)((s)localObject2).CVW);
      ((ahe)localObject3).aJu(((s)localObject2).gPy);
      ((agx)localObject1).vy(true);
      ((agx)localObject1).vz(true);
      ((agx)localObject1).EzZ.c((ahe)localObject3);
      continue;
      ((agx)localObject1).XM(8);
      localObject2 = (u)paramagx;
      ((agx)localObject1).aIP(paramagx.dhw);
      ((agx)localObject1).aIQ(((u)localObject2).dpK);
      ((agx)localObject1).vz(true);
      ((agx)localObject1).aIC(((u)localObject2).title);
      ((agx)localObject1).aID(((u)localObject2).content);
      ((agx)localObject1).aIM(((u)localObject2).oQk);
      continue;
      ((agx)localObject1).XM(3);
      localObject2 = (v)paramagx;
      ((agx)localObject1).aIP(paramagx.dhw);
      localObject3 = ((v)localObject2).dpK;
      if ((bs.isNullOrNil((String)localObject3)) || (((String)localObject3).length() == 0)) {
        break;
      }
      ((agx)localObject1).aIQ((String)localObject3);
      ((agx)localObject1).XL(((v)localObject2).dhF);
      ((agx)localObject1).vz(true);
      ((agx)localObject1).aIM(((v)localObject2).oQk);
      continue;
      ((agx)localObject1).XM(4);
      localObject2 = (k)paramagx;
      ((agx)localObject1).aIP(paramagx.dhw);
      ((agx)localObject1).aIQ(((k)localObject2).dpK);
      ((agx)localObject1).aIR(((k)localObject2).thumbPath);
      localObject3 = com.tencent.mm.plugin.sight.base.e.asx(((k)localObject2).dpK);
      if (localObject3 != null) {
        ((agx)localObject1).XL(((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration());
      }
      for (;;)
      {
        ((agx)localObject1).aIM(((k)localObject2).oQk);
        break;
        ((agx)localObject1).XL(1);
      }
      if (!CUS)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(14547, new Object[] { Integer.valueOf(6) });
        CUS = true;
      }
      ((agx)localObject1).XM(1);
      ((agx)localObject1).vy(true);
      ((agx)localObject1).vz(true);
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.i)paramagx;
      ((agx)localObject1).aIP(paramagx.dhw);
      ((agx)localObject1).aID(com.tencent.mm.plugin.wenote.c.b.Xk(((com.tencent.mm.plugin.wenote.model.a.i)localObject2).content));
      if ((!bs.isNullOrNil(((agx)localObject1).desc)) && (((agx)localObject1).desc.length() > 1000)) {
        ((agx)localObject1).aID(((agx)localObject1).desc.substring(0, 1000));
      }
    }
    label914:
    a(localLinkedList, paramList);
    localahn.bk(localLinkedList);
    return localahn;
  }
  
  private static void a(LinkedList<agx> paramLinkedList, List<o> paramList)
  {
    ac.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
    if (paramLinkedList.size() > 0)
    {
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        agx localagx = (agx)paramLinkedList.get(i);
        String str1;
        Object localObject;
        if ((i > 0) && (bs.isNullOrNil(localagx.Ezf)))
        {
          localagx.aIP(f.Xn(localagx.toString()));
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
          if ((localObject != null) && (((o)localObject).oQi != null) && (((o)localObject).oQi.equals(localagx.EAh))) {
            ((o)localObject).dhw = localagx.dhw;
          }
        }
        if ((i > 0) && (!bs.isNullOrNil(localagx.Ezf)) && (!bs.isNullOrNil(localagx.Ezh)))
        {
          localagx.vy(true);
          localagx.vz(true);
        }
        for (;;)
        {
          i += 1;
          break;
          ac.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localagx.dataType) });
          localObject = localagx.EzD;
          String str2;
          if (com.tencent.mm.vfs.i.eA((String)localObject))
          {
            ac.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.i.aKe((String)localObject);
            str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.vfs.i.aU((String)localObject, 0, 256));
            localagx.aIN(str1);
            localagx.aIO(str2);
            localagx.zS(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = f.b(localagx);
            boolean bool = com.tencent.mm.vfs.i.eA(str1);
            if ((!((String)localObject).equals(str1)) && (!bool) && (!"WeNoteHtmlFile".equals(localagx.EAh))) {
              com.tencent.mm.vfs.i.lZ((String)localObject, str1);
            }
          }
          for (;;)
          {
            localObject = localagx.EzF;
            if (!com.tencent.mm.vfs.i.eA((String)localObject)) {
              break label516;
            }
            ac.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[] { localObject });
            str1 = com.tencent.mm.vfs.i.aKe((String)localObject);
            str2 = com.tencent.mm.b.g.dt((String)localObject);
            localagx.aIS(str1);
            localagx.aIT(str2);
            localagx.zT(new com.tencent.mm.vfs.e((String)localObject).length());
            str1 = f.a(localagx);
            if ((((String)localObject).equals(str1)) || (com.tencent.mm.vfs.i.eA(str1))) {
              break;
            }
            com.tencent.mm.vfs.i.lZ((String)localObject, str1);
            break;
            ac.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[] { localObject });
          }
          label516:
          ac.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[] { localObject });
        }
      }
    }
  }
  
  private void bB(Context paramContext, String paramString)
  {
    paramString = (k)this.CUN.get(paramString);
    if (bs.isNullOrNil(paramString.dpK)) {
      return;
    }
    if (!com.tencent.mm.vfs.i.eA(paramString.dpK))
    {
      localObject = aED(paramString.dhw);
      if (localObject == null)
      {
        ac.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
        return;
      }
      p((agx)localObject);
    }
    Object localObject = new Intent();
    if (this.CUK == null) {
      ((Intent)localObject).putExtra("key_detail_info_id", 0);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("key_detail_fav_path", paramString.dpK);
      ((Intent)localObject).putExtra("key_detail_fav_thumb_path", paramString.thumbPath);
      ((Intent)localObject).putExtra("key_detail_fav_video_duration", paramString.duration);
      ((Intent)localObject).putExtra("key_detail_data_id", paramString.dhw);
      ((Intent)localObject).putExtra("key_detail_statExtStr", "");
      ((Intent)localObject).putExtra("key_detail_fav_video_show_download_status", true);
      if (paramString.oQh != null) {
        ((Intent)localObject).putExtra("key_detail_msg_uuid", paramString.oQh.iaU);
      }
      com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", (Intent)localObject, 1);
      return;
      ((Intent)localObject).putExtra("key_detail_info_id", this.CUK.field_localId);
    }
  }
  
  public abstract String a(agx paramagx);
  
  public abstract void a(agx paramagx, String paramString);
  
  public void aEC(String paramString) {}
  
  public final agx aED(String paramString)
  {
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
      return null;
    }
    String str = (String)this.CUM.get(paramString);
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[] { paramString });
      return null;
    }
    paramString = (o)this.CUN.get(str);
    if (paramString == null)
    {
      ac.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[] { str });
      return null;
    }
    return paramString.oQh;
  }
  
  public final void b(nb paramnb)
  {
    if (paramnb.dpw == null)
    {
      ac.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
      return;
    }
    String str = paramnb.dpw.dpy;
    o localo = (o)this.CUN.get(str);
    if (localo == null)
    {
      ac.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
      return;
    }
    ac.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", new Object[] { Integer.valueOf(localo.type) });
    switch (localo.type)
    {
    case 4: 
    default: 
      return;
    case 2: 
      bA(paramnb.dpw.context, str);
      return;
    case 5: 
      by(paramnb.dpw.context, str);
      return;
    case 3: 
      bz(paramnb.dpw.context, str);
      return;
    }
    bB(paramnb.dpw.context, str);
  }
  
  public abstract void bA(Context paramContext, String paramString);
  
  public abstract void by(Context paramContext, String paramString);
  
  public abstract void bz(Context paramContext, String paramString);
  
  public abstract String d(agx paramagx);
  
  public String eHQ()
  {
    return "";
  }
  
  public final void gO(List<agx> paramList)
  {
    w localw = new w();
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<agx>)localObject1;
    label23:
    while (localIterator.hasNext())
    {
      agx localagx = (agx)localIterator.next();
      o localo = new o();
      localo.oQi = localagx.EAh;
      if (localagx.dataType == 1) {
        localo.oQi = "-1";
      }
      if (bs.isNullOrNil(localo.oQi))
      {
        ac.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
        paramList = d(localagx);
        if ((!bs.isNullOrNil(paramList)) && (com.tencent.mm.vfs.i.eA(paramList)))
        {
          f.D(this.CUJ.dpL, paramList);
          return;
        }
        p(localagx);
        return;
      }
      if (localo.oQi.equals("WeNoteHtmlFile"))
      {
        localObject1 = d(localagx);
        if ((!bs.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.i.eA((String)localObject1))) {}
        for (;;)
        {
          try
          {
            for (;;)
            {
              localw.oQo = com.tencent.mm.vfs.i.aSr((String)localObject1);
              localObject1 = com.tencent.mm.plugin.wenote.c.b.Xj(localw.oQo);
              paramList = (List<agx>)localObject1;
              try
              {
                ac.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[] { localagx.dhw });
                oPz.containsKey(localw.oQo);
                ac.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[] { Boolean.valueOf(bs.isNullOrNil(localagx.Ezf)), Boolean.valueOf(bs.isNullOrNil(localagx.Ezh)) });
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
          ac.printErrStackTrace("MicroMsg.WNNoteBase", localException1, "", new Object[0]);
          continue;
          p(localagx);
          localw.oQq = true;
          ac.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[] { localagx.dhw });
          this.CUM.put(localagx.dhw, localo.oQi);
        }
      }
      if (!localo.oQi.equals("-1"))
      {
        i = bs.getInt(localo.oQi.substring(7), 0);
        j = bs.getInt(this.CUO.substring(7), 0);
        localObject3 = new StringBuilder("WeNote_");
        if (j <= i) {
          break label654;
        }
      }
      for (localObject2 = String.valueOf(j);; localObject2 = String.valueOf(i))
      {
        this.CUO = ((String)localObject2);
        localo.dhw = localagx.dhw;
        switch (localagx.dataType)
        {
        default: 
          if (localagx.dataType <= 0) {
            break label23;
          }
          localObject2 = new j();
          ((n)localObject2).oQi = localo.oQi;
          ((n)localObject2).type = 0;
          ((n)localObject2).dhw = localo.dhw;
          ((n)localObject2).oQh = localagx;
          localObject3 = d(localagx);
          ((n)localObject2).oQj = true;
          ((n)localObject2).dpK = ((String)localObject3);
          ((n)localObject2).kvC = oPE;
          ((n)localObject2).title = ai.getContext().getResources().getString(2131758972);
          ((n)localObject2).content = ai.getContext().getResources().getString(2131758937);
          localw.oQp.add(localObject2);
          this.CUN.put(localo.oQi, localObject2);
          break label23;
        }
      }
      if (!bs.isNullOrNil(localagx.desc)) {
        if ((localw.oQp.size() > 0) && (localw.oQp.get(localw.oQp.size() - 1) != null) && (((o)localw.oQp.get(localw.oQp.size() - 1)).oQi.equals("-1")))
        {
          localObject2 = (t)localw.oQp.get(localw.oQp.size() - 1);
          ((t)localObject2).content += localagx.desc;
        }
        else
        {
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.i();
          ((t)localObject2).oQi = localo.oQi;
          ((t)localObject2).content = localagx.desc;
          localw.oQp.add(localObject2);
          continue;
          localObject2 = new com.tencent.mm.plugin.wenote.model.a.f();
          ((p)localObject2).oQi = localo.oQi;
          ((p)localObject2).type = 2;
          ((p)localObject2).dhw = localo.dhw;
          ((p)localObject2).oQh = localagx;
          localObject3 = d(localagx);
          if (!bs.isNullOrNil((String)localObject3))
          {
            localObject4 = (String)localObject3 + "_bigthumb";
            str = a(localagx);
            if (!com.tencent.mm.vfs.i.eA(str)) {
              a(localagx, str);
            }
            if (com.tencent.mm.vfs.i.eA((String)localObject3))
            {
              ((p)localObject2).oQj = true;
              c.ff((String)localObject3, (String)localObject4);
            }
            for (;;)
            {
              ((p)localObject2).dpK = ((String)localObject4);
              ((p)localObject2).oQg = ((String)localObject3);
              localw.oQp.add(localObject2);
              this.CUN.put(localo.oQi, localObject2);
              break;
              p(localagx);
              ((p)localObject2).oQj = false;
              this.CUM.put(localagx.dhw, localo.oQi);
            }
            if (localagx.dataType == 20)
            {
              localObject3 = new com.tencent.mm.plugin.wenote.model.a.b();
              localObject2 = localObject3;
              if (!bs.isNullOrNil(localagx.Ezf))
              {
                ((com.tencent.mm.plugin.wenote.model.a.b)localObject3).xDb = true;
                localObject2 = localObject3;
              }
              label1089:
              ((v)localObject2).oQi = localo.oQi;
              ((v)localObject2).type = 4;
              ((v)localObject2).dhw = localo.dhw;
              ((v)localObject2).oQh = localagx;
              localObject3 = d(localagx);
              if ((bs.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.i.eA((String)localObject3))) {
                break label1315;
              }
              ((v)localObject2).oQj = true;
              ((v)localObject2).kvC = oPA;
              ((v)localObject2).length = ((int)f.qw(localagx.duration));
            }
            for (;;)
            {
              ((v)localObject2).dpK = ((String)localObject3);
              ((v)localObject2).oQm = f.R(ai.getContext(), (int)f.qw(localagx.duration));
              ((v)localObject2).dhF = localagx.duration;
              localObject3 = new gt();
              ((gt)localObject3).dhx.type = 17;
              ((gt)localObject3).dhx.dhz = localagx;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
              ((v)localObject2).dhE = ((gt)localObject3).dhy.ret;
              ((v)localObject2).oQk = localagx.Ezu;
              localw.oQp.add(localObject2);
              this.CUN.put(localo.oQi, localObject2);
              break;
              localObject2 = new l();
              break label1089;
              label1315:
              p(localagx);
              ((v)localObject2).oQj = false;
              ((v)localObject2).oQn = ai.getContext().getString(2131759038);
              this.CUM.put(localagx.dhw, localo.oQi);
            }
            localObject4 = new r();
            localObject3 = localagx.EzZ.EAI;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new ahe();
              ((ahe)localObject2).aJt("");
              ((ahe)localObject2).aJu("");
              ac.e("MicroMsg.WNNoteBase", "locItem is null, dataItemId:" + localagx.dhw);
            }
            ((r)localObject4).dmL = ((float)((ahe)localObject2).lat);
            ((r)localObject4).hIO = ((float)((ahe)localObject2).lng);
            ((r)localObject4).dmN = ((ahe)localObject2).dmN;
            ((r)localObject4).CVS = ((ahe)localObject2).label;
            ((r)localObject4).CVT = ((ahe)localObject2).dry;
            ((r)localObject4).CVU = localagx.EAh;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.g();
            ((s)localObject2).oQi = localo.oQi;
            ((s)localObject2).type = 3;
            ((s)localObject2).dhw = localo.dhw;
            ((s)localObject2).oQh = localagx;
            ((s)localObject2).oQj = true;
            ((s)localObject2).gPy = ((r)localObject4).CVT;
            ((s)localObject2).hEt = ((r)localObject4).CVS;
            ((s)localObject2).lat = ((r)localObject4).dmL;
            ((s)localObject2).lng = ((r)localObject4).hIO;
            ((s)localObject2).CVW = ((r)localObject4).dmN;
            ((s)localObject2).dpK = "";
            localw.oQp.add(localObject2);
            this.CUN.put(localo.oQi, localObject2);
            continue;
            localObject2 = new com.tencent.mm.plugin.wenote.model.a.d();
            ((u)localObject2).oQi = localo.oQi;
            ((u)localObject2).type = 5;
            ((u)localObject2).dhw = localo.dhw;
            ((u)localObject2).oQh = localagx;
            localObject3 = d(localagx);
            if ((!bs.isNullOrNil((String)localObject3)) && (com.tencent.mm.vfs.i.eA((String)localObject3)))
            {
              ((u)localObject2).oQj = true;
              ((u)localObject2).dpK = ((String)localObject3);
            }
            for (;;)
            {
              ((u)localObject2).kvC = h.aEH(localagx.Ezu);
              ((u)localObject2).title = localagx.title;
              ((u)localObject2).content = localagx.desc;
              ((u)localObject2).oQk = localagx.Ezu;
              if (bs.isNullOrNil(((u)localObject2).content)) {
                ((u)localObject2).content = f.aX((float)localagx.EzA);
              }
              localw.oQp.add(localObject2);
              this.CUN.put(localo.oQi, localObject2);
              break;
              ((u)localObject2).oQj = false;
              this.CUM.put(localagx.dhw, localo.oQi);
            }
            localObject2 = new k();
            ((k)localObject2).oQi = localo.oQi;
            ((k)localObject2).type = 6;
            ((k)localObject2).dhw = localo.dhw;
            ((k)localObject2).oQh = localagx;
            if (localagx != null) {
              ((k)localObject2).duration = localagx.duration;
            }
            ((k)localObject2).thumbPath = a(localagx);
            localObject3 = d(localagx);
            ((k)localObject2).dpK = ((String)localObject3);
            if ((!bs.isNullOrNil(((k)localObject2).thumbPath)) && (!com.tencent.mm.vfs.i.eA(((k)localObject2).thumbPath)))
            {
              if (!com.tencent.mm.vfs.i.eA((String)localObject3)) {
                break label2063;
              }
              localObject4 = com.tencent.mm.plugin.fav.ui.e.acS((String)localObject3);
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                ac.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                com.tencent.mm.pluginsdk.j.f.a((Bitmap)localObject4, Bitmap.CompressFormat.JPEG, ((k)localObject2).thumbPath, true);
                if ((bs.isNullOrNil((String)localObject3)) || (!com.tencent.mm.vfs.i.eA((String)localObject3))) {
                  break label2114;
                }
                ((k)localObject2).oQj = true;
                localw.oQp.add(localObject2);
                this.CUN.put(localo.oQi, localObject2);
              }
              catch (Exception localException3)
              {
                ac.printErrStackTrace("MicroMsg.WNNoteBase", localException3, "", new Object[0]);
                continue;
              }
              a(localagx, ((k)localObject2).thumbPath);
              this.CUM.put(localagx.dhw + "_t", localo.oQi);
              continue;
              label2114:
              ((k)localObject2).oQj = false;
              this.CUM.put(localagx.dhw, localo.oQi);
            }
          }
        }
      }
    }
    label654:
    label2063:
    if ((paramList != null) && (paramList.size() > 0)) {
      h.a(localw.oQp, paramList, true);
    }
    if (this.CUJ.msgId == -1L)
    {
      this.CUL.put(Long.toString(this.CUJ.dpL), localw);
      return;
    }
    this.CUL.put(Long.toString(this.CUJ.msgId), localw);
  }
  
  public abstract void p(agx paramagx);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.d
 * JD-Core Version:    0.7.0.1
 */