package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ed.b;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ev.a;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.ey.b;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.ez.a;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.fl.a;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kf.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLocationObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.pluginsdk.e.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI
  extends MMActivity
{
  boolean PdX;
  private boolean Pdm;
  private String PiA;
  private RelativeLayout PiB;
  private RelativeLayout PiC;
  private TextView PiD;
  private Boolean PiE;
  private b PiF;
  private List<c> PiG;
  private List<com.tencent.mm.pluginsdk.model.app.g> PiH;
  private long PiI;
  private boolean PiJ;
  boolean PiK;
  boolean PiL;
  int PiM;
  int PiN;
  private HashMap<String, View> PiO;
  private HashMap<String, c> PiP;
  private Map<Integer, View> PiQ;
  private Map<String, Integer> PiR;
  private IListener PiS;
  private IListener PiT;
  private HorizontalListView Piv;
  private HorizontalListView Piw;
  private b Pix;
  private a Piy;
  private int Piz;
  boolean dIo;
  private k.b dXm;
  String filePath;
  String gCr;
  private long gof;
  WXMediaMessage pez;
  private ca qnv;
  private String rzs;
  
  public ChattingSendDataToDeviceUI()
  {
    AppMethodBeat.i(34660);
    this.PiA = "";
    this.PiE = Boolean.FALSE;
    this.PiG = new ArrayList();
    this.PiH = new ArrayList();
    this.PiI = 0L;
    this.PiJ = true;
    this.dIo = false;
    this.PiK = false;
    this.PiL = true;
    this.PiM = 2;
    this.PiN = -1;
    this.PiO = new HashMap();
    this.PiP = new HashMap();
    this.PiQ = new HashMap();
    this.PiR = new HashMap();
    this.pez = null;
    this.filePath = null;
    this.gCr = null;
    this.PdX = false;
    this.PiS = new IListener() {};
    this.PiT = new IListener() {};
    AppMethodBeat.o(34660);
  }
  
  private void GD(int paramInt)
  {
    AppMethodBeat.i(34662);
    if (this.dIo)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.PiN), "", Integer.valueOf(2), Integer.valueOf(this.PiM) });
      AppMethodBeat.o(34662);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.PiN), Nr(this.gof), Integer.valueOf(1), Integer.valueOf(this.PiM) });
    AppMethodBeat.o(34662);
  }
  
  private static String Nr(long paramLong)
  {
    AppMethodBeat.i(34663);
    String str2 = "";
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSQ().Hb(paramLong);
    if (((eo)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(34663);
      return "";
    }
    String str3 = ((eo)localObject).field_content;
    String str1 = str2;
    if (((ca)localObject).getType() == 49)
    {
      localObject = k.b.HD(str3);
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((k.b)localObject).type == 6) {
          str1 = ((k.b)localObject).iwJ;
        }
      }
    }
    AppMethodBeat.o(34663);
    return str1;
  }
  
  private static boolean a(c paramc, long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(34671);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(34671);
      return false;
    }
    String str1 = paramc.dIn;
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSQ().Hb(paramLong);
    if ((((eo)localObject).field_msgId == 0L) || (str1 == null))
    {
      AppMethodBeat.o(34671);
      return false;
    }
    int i = ((ca)localObject).getType();
    String str2 = ((eo)localObject).field_content;
    boolean bool1;
    if (((ca)localObject).dOQ())
    {
      localObject = k.b.HD(str2);
      if (localObject == null)
      {
        Log.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        AppMethodBeat.o(34671);
        return false;
      }
      if ((((k.b)localObject).type == 3) || (((k.b)localObject).type == 76))
      {
        bool1 = bool2;
        if (str1.contains("wxmsg_music")) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34671);
      return bool1;
      bool1 = bool2;
      if (((k.b)localObject).type != 4) {
        if (((k.b)localObject).type == 6)
        {
          bool1 = bool2;
          if (str1.contains("wxmsg_file")) {
            bool1 = true;
          }
        }
        else if (((k.b)localObject).type == 5)
        {
          bool1 = a(((k.b)localObject).url, paramc);
        }
        else
        {
          bool1 = bool2;
          if (((k.b)localObject).type == 2)
          {
            bool1 = bool2;
            if (str1.contains("wxmsg_image"))
            {
              bool1 = true;
              continue;
              if (i == 3)
              {
                bool1 = bool2;
                if (str1.contains("wxmsg_image")) {
                  bool1 = true;
                }
              }
              else if (i == 48)
              {
                bool1 = bool2;
                if (str1.contains("wxmsg_poi")) {
                  bool1 = true;
                }
              }
              else
              {
                bool1 = bool2;
                if (i == 62)
                {
                  bool1 = bool2;
                  if (str1.contains("wxmsg_video")) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean a(c paramc, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(34668);
    if (paramString == null)
    {
      AppMethodBeat.o(34668);
      return false;
    }
    Object localObject = new kf();
    ((kf)localObject).dPf.dHp = paramString;
    EventCenter.instance.publish((IEvent)localObject);
    paramString = ((kf)localObject).dPg.dPh;
    int i = paramString.ContentObj.LoU;
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.dIn;
    if (localObject == null)
    {
      Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
      AppMethodBeat.o(34668);
      return false;
    }
    if (i == 1) {
      if (!((String)localObject).contains("wxmsg_image")) {
        break label158;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34668);
      return bool;
      if ((i == 4) || (i == 42))
      {
        if (((String)localObject).contains("wxmsg_music")) {}
      }
      else
      {
        label158:
        label183:
        do
        {
          do
          {
            bool = false;
            break;
            if (i != 15) {
              break label183;
            }
          } while (!((String)localObject).contains("wxmsg_video"));
          break;
        } while (i != 3);
        bool = a(paramString.ContentObj.Url, paramc);
      }
    }
  }
  
  private static boolean a(String paramString, c paramc)
  {
    bool2 = false;
    AppMethodBeat.i(34667);
    Object localObject = paramc.dIn;
    paramc = paramc.Pjg;
    paramString = Uri.parse(paramString).getHost();
    bool1 = bool2;
    if (paramc != null)
    {
      bool1 = bool2;
      if (paramc.length() > 0)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (!((String)localObject).contains("wxmsg_url")) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramc).getJSONArray("wxmsg_url");
        int j = ((JSONArray)localObject).length();
        i = 0;
        bool1 = bool2;
        if (i < j)
        {
          bool1 = ((JSONArray)localObject).getString(i).equals(paramString);
          if (!bool1) {
            continue;
          }
          bool1 = true;
        }
      }
      catch (JSONException paramString)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", paramString, paramc, new Object[0]);
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(34667);
      return bool1;
      i += 1;
    }
  }
  
  private void gNU()
  {
    AppMethodBeat.i(34665);
    if ((this.Pix == null) || (this.PiI == 0L))
    {
      if (this.Pix == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.PiI) });
        if (this.PiC != null) {
          this.PiC.setVisibility(8);
        }
        AppMethodBeat.o(34665);
        return;
      }
    }
    this.PiH = com.tencent.mm.pluginsdk.model.app.h.b(this, this.PiI, false);
    if ((!com.tencent.mm.pluginsdk.model.app.h.s(this, this.PiI)) && (this.PiC != null)) {
      this.PiC.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.PiH != null) && (this.PiH.size() > 0))
    {
      localObject1 = ao.gng().Mq(this.PiI);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.PiH, new Comparator() {});
      }
      localObject1 = this.PiH.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next();
        localObject3 = new z();
        ((z)localObject3).appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
        ((z)localObject3).gCv = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
        ((z)localObject3).iconUrl = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.pez == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.qnv.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.pez = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.pez.sdkVer = 637928960;
      if ((this.gCr != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.PdX = true;
      }
      label403:
      this.Pix.PdX = this.PdX;
      this.Pix.ad(localArrayList);
      this.Pix.notifyDataSetChanged();
      AppMethodBeat.o(34665);
      return;
      localObject1 = localObject3;
      if (this.dXm != null) {
        if (this.dXm.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.dXm.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.dXm.ixd;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.dXm.iwH;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.dXm.ixe;
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)this.dXm.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            ((WXMusicObject)localObject1).songAlbumUrl = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songAlbumUrl;
            ((WXMusicObject)localObject1).songLyric = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songLyric;
          }
        }
        else if (this.dXm.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.dXm.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.dXm.ixe;
        }
        else if (this.dXm.type == 5)
        {
          localObject1 = new WXWebpageObject(this.dXm.url);
        }
        else
        {
          if (this.dXm.type == 6)
          {
            localObject3 = ao.cgO().bdx(this.dXm.dCK);
            if (localObject3 != null)
            {
              Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              this.gCr = this.dXm.iwJ;
            }
            while (r.bdN(this.filePath) != null)
            {
              com.tencent.mm.ui.base.h.cD(this, getString(2131757517));
              finish();
              break label403;
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.dXm.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = q.bcR().U(this.qnv);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = q.bcR().Oz(((com.tencent.mm.av.g)localObject2).iXm);
              if (Util.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = q.bcR().Oz(((com.tencent.mm.av.g)localObject2).iXo);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.gCr = this.dXm.iwJ;
            Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.qnv.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = q.bcR().U(this.qnv);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = q.bcR().Oz(((com.tencent.mm.av.g)localObject2).iXm);
              if (Util.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = q.bcR().Oz(((com.tencent.mm.av.g)localObject2).iXo);
              }
              if (!Util.isNullOrNil(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.gCr = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            bg.aVF();
            localObject1 = com.tencent.mm.model.c.aSQ().aEL(this.qnv.field_content);
            localObject1 = new WXLocationObject(((ca.b)localObject1).yFu, ((ca.b)localObject1).yFv);
            continue;
            localObject2 = new WXVideoObject();
            o.bhj();
            localObject3 = t.Qw(this.qnv.field_imgPath);
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              ((WXVideoObject)localObject2).videoUrl = ((String)localObject3);
              this.filePath = ((String)localObject3);
              i = ((String)localObject3).lastIndexOf(".");
              localObject1 = localObject2;
              if (i >= 0)
              {
                localObject1 = localObject2;
                if (i < ((String)localObject3).length() - 1)
                {
                  this.gCr = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void gNV()
  {
    AppMethodBeat.i(34666);
    Object localObject1 = new ed();
    Object localObject2;
    int i;
    if (this.dIo)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      ((ed)localObject1).dHn.dHp = this.rzs;
      ((ed)localObject1).dHn.dHq = ((String)localObject2);
      ((ed)localObject1).dHn.dHr = str;
      EventCenter.instance.publish((IEvent)localObject1);
      if (!((ed)localObject1).dHo.dGX) {
        break label436;
      }
      localObject1 = ((ed)localObject1).dHo.dHs;
      int j = ((List)localObject1).size();
      i = 0;
      label115:
      if (i >= j) {
        break label372;
      }
      localObject2 = new c();
      ((c)localObject2).dGP = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((c)localObject2).gCv = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((c)localObject2).dIn = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((c)localObject2).Pjg = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.dIo) || (!a((c)localObject2, this.rzs))) {
        break label338;
      }
      this.PiG.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label115;
      ((ed)localObject1).dHn.msgId = this.gof;
      break;
      label338:
      if ((!this.dIo) && (a((c)localObject2, this.gof))) {
        this.PiG.add(localObject2);
      }
    }
    label372:
    if (this.PiG.size() > 0)
    {
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.Piy.ad(this.PiG);
      if (this.Piy.getCount() > 0)
      {
        this.PiD.setText(2131757336);
        this.PiJ = false;
      }
      this.Piy.notifyDataSetChanged();
    }
    label436:
    AppMethodBeat.o(34666);
  }
  
  public final void bmx(final String paramString)
  {
    AppMethodBeat.i(34670);
    try
    {
      final int i = ((Integer)this.PiR.get(paramString)).intValue();
      final as localas = (as)((View)this.PiQ.get(Integer.valueOf(i))).getTag();
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(localas.Plh.getProgress()), paramString });
      final c localc = (c)this.PiP.get(paramString);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34643);
          localas.Plh.setVisibility(0);
          localas.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131101053));
          localas.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(2131757528));
          localc.dIr = "send_data_sending";
          AppMethodBeat.o(34643);
        }
      });
      final int j = Math.abs(localas.Plh.getProgress());
      localc.progress = j;
      if (j >= 100) {}
      for (i = 0;; i = 500 / (100 - j))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
        com.tencent.f.h.RTc.ba(new com.tencent.f.i.h()
        {
          public final String getKey()
          {
            return "ThreadPool";
          }
          
          public final void run()
          {
            AppMethodBeat.i(34645);
            int i = j + 1;
            int j;
            for (;;)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34644);
                    ChattingSendDataToDeviceUI.10.this.PiW.Plh.amr(0);
                    ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(ChattingSendDataToDeviceUI.10.this.Jhn);
                    ChattingSendDataToDeviceUI.10.this.PiW.Plh.setVisibility(4);
                    ChattingSendDataToDeviceUI.10.this.PiW.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(2131757526));
                    ChattingSendDataToDeviceUI.10.this.PiW.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131101053));
                    ChattingSendDataToDeviceUI.10.this.PiX.dIr = "send_data_sucess";
                    ChattingSendDataToDeviceUI.10.this.PiX.progress = 0;
                    ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 4);
                    AppMethodBeat.o(34644);
                  }
                });
                AppMethodBeat.o(34645);
                return;
              }
              catch (Exception localException)
              {
                Log.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              localas.Plh.amr(i);
              i += 1;
              j = i;
              Thread.sleep(i);
            }
          }
        });
        this.PiP.put(localc.deviceID, localc);
        AppMethodBeat.o(34670);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[] { paramString });
      AppMethodBeat.o(34670);
    }
  }
  
  public final b gNW()
  {
    AppMethodBeat.i(34676);
    if (this.PiF == null) {
      this.PiF = new b();
    }
    b localb = this.PiF;
    AppMethodBeat.o(34676);
    return localb;
  }
  
  public int getLayoutId()
  {
    return 2131493631;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34674);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131758379, 2131758380, 1);
    AppMethodBeat.o(34674);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(34669);
    if (this.PiO.size() > 0)
    {
      d.a locala = new d.a(this);
      locala.aoS(2131757520);
      locala.aoV(2131757522).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34641);
          paramAnonymousDialogInterface = ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).keySet().iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            ds localds = new ds();
            localds.dGK.dGL = str;
            EventCenter.instance.publish(localds);
          }
          ChattingSendDataToDeviceUI.this.finish();
          AppMethodBeat.o(34641);
        }
      });
      locala.aoW(2131757521).d(new ChattingSendDataToDeviceUI.8(this));
      locala.hbn().show();
      AppMethodBeat.o(34669);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(34669);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(34664);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = new ed();
    if (this.dIo)
    {
      String str1 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      paramConfiguration.dHn.dHp = this.rzs;
      paramConfiguration.dHn.dHq = str1;
      paramConfiguration.dHn.dHr = str2;
    }
    for (;;)
    {
      EventCenter.instance.publish(paramConfiguration);
      if ((paramConfiguration.dHo.dGX) && (this.PiG.size() > 0))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.PiG.size()) });
        this.Piy.ad(this.PiG);
        if (this.Piy.getCount() > 0)
        {
          this.PiD.setText(2131757336);
          this.PiJ = false;
        }
        this.Piy.notifyDataSetChanged();
      }
      AppMethodBeat.o(34664);
      return;
      paramConfiguration.dHn.msgId = this.gof;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    AppMethodBeat.i(34661);
    super.onCreate(paramBundle);
    this.dIo = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.dIo);
    if (!this.dIo)
    {
      this.gof = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.gof != -1L)
      {
        bg.aVF();
        this.qnv = com.tencent.mm.model.c.aSQ().Hb(this.gof);
        if ((this.qnv != null) && (this.qnv.field_msgId != 0L)) {
          break label562;
        }
      }
    }
    this.PiM = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.PiK = false;
    setFinishOnTouchOutside(true);
    this.PiG.clear();
    this.PiP.clear();
    this.PiB = ((RelativeLayout)findViewById(2131305420));
    paramBundle = new ef();
    label260:
    Object localObject;
    if (this.dIo)
    {
      this.rzs = getIntent().getExtras().getString("sns_local_id");
      if (this.rzs != null)
      {
        paramBundle.dHy.dHp = this.rzs;
        Log.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.rzs });
      }
      EventCenter.instance.publish(paramBundle);
      if (!paramBundle.dHz.dGX) {
        break label1273;
      }
      this.PiE = Boolean.TRUE;
      EventCenter.instance.addListener(this.PiS);
      EventCenter.instance.addListener(this.PiT);
      this.PiB.setVisibility(0);
      this.Piv = ((HorizontalListView)findViewById(2131303242));
      this.PiD = ((TextView)findViewById(2131297118));
      this.PiD.setText(2131757508);
      this.Piy = new a(this);
      this.Piv.setAdapter(this.Piy);
      this.Piv.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34637);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          ChattingSendDataToDeviceUI.this.PiK = true;
          localObject = ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).aml(paramAnonymousInt);
          String str1 = ((ChattingSendDataToDeviceUI.c)localObject).dGP;
          paramAnonymousAdapterView = ((ChattingSendDataToDeviceUI.c)localObject).deviceID;
          String str2 = ((ChattingSendDataToDeviceUI.c)localObject).dIn;
          for (;;)
          {
            try
            {
              if (ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).get(paramAnonymousAdapterView) != null)
              {
                Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                paramAnonymousView = new ds();
                paramAnonymousView.dGK.dGL = paramAnonymousAdapterView;
                EventCenter.instance.publish(paramAnonymousView);
                ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", paramAnonymousAdapterView, 0);
                ((ChattingSendDataToDeviceUI.c)localObject).dIr = "send_data_cancel";
                ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(paramAnonymousAdapterView);
                paramAnonymousAdapterView = (as)((View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramAnonymousInt))).getTag();
                paramAnonymousAdapterView.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(2131757519));
                paramAnonymousAdapterView.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131101051));
                paramAnonymousAdapterView.Plh.setVisibility(8);
                paramAnonymousAdapterView.Plh.amr(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34637);
                return;
              }
              ((ChattingSendDataToDeviceUI.c)localObject).dIr = "send_data_sending";
              ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(((ChattingSendDataToDeviceUI.c)localObject).deviceID, localObject);
              ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).put(paramAnonymousAdapterView, paramAnonymousView);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", paramAnonymousAdapterView, 1);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
              paramAnonymousView = new ey();
              paramAnonymousView.dIl.dGL = paramAnonymousAdapterView;
              paramAnonymousView.dIl.dGP = str1;
              paramAnonymousView.dIl.data = ChattingSendDataToDeviceUI.e(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.dIl.dIn = str2;
              if (!ChattingSendDataToDeviceUI.this.dIo) {
                continue;
              }
              paramAnonymousView.dIl.dHp = ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.dIl.dIo = ChattingSendDataToDeviceUI.this.dIo;
              EventCenter.instance.publish(paramAnonymousView);
              if (!paramAnonymousView.dIm.isSuccess)
              {
                ChattingSendDataToDeviceUI.bmy("send_data_failed");
                Log.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
              }
            }
            catch (Exception paramAnonymousAdapterView)
            {
              ChattingSendDataToDeviceUI.bmy("send_data_failed");
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAnonymousAdapterView });
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34637);
            return;
            paramAnonymousView.dIl.msgId = ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this);
          }
        }
      });
      gNV();
      if (!this.dIo) {
        break label1082;
      }
      paramBundle = this.rzs;
      if (paramBundle == null) {
        break label1077;
      }
      localObject = new kf();
      ((kf)localObject).dPf.dHp = paramBundle;
      EventCenter.instance.publish((IEvent)localObject);
      i = ((kf)localObject).dPg.dPh.ContentObj.LoU;
      if (i != 1) {
        break label1039;
      }
      i = 3;
      label461:
      this.PiN = i;
      GD(1);
    }
    for (;;)
    {
      this.PiC = ((RelativeLayout)findViewById(2131297012));
      this.Piw = ((HorizontalListView)findViewById(2131296951));
      this.Pix = new b(this);
      this.Piw.setOnItemClickListener(new ChattingSendDataToDeviceUI.5(this));
      this.Piw.setAdapter(this.Pix);
      findViewById(2131306821).setOnClickListener(new ChattingSendDataToDeviceUI.1(this));
      AppMethodBeat.o(34661);
      return;
      label562:
      this.Piz = this.qnv.getType();
      this.Pdm = ab.Eq(this.qnv.field_talker);
      this.PiA = this.qnv.field_content;
      int j;
      if ((this.Pdm) && (this.qnv.field_isSend == 0))
      {
        localObject = this.qnv.field_content;
        j = this.qnv.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.Pdm)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = bp.Kt((String)localObject);
            }
          }
        }
        this.PiA = paramBundle;
      }
      if (this.qnv.getType() == 49)
      {
        this.dXm = k.b.HD(this.PiA);
        if (this.dXm == null)
        {
          Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.dXm.type == 3) {
          this.PiI = 16L;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.PiI) });
        break;
        if (this.dXm.type == 4)
        {
          this.PiI = 8L;
        }
        else if (this.dXm.type == 5)
        {
          this.PiI = 32L;
        }
        else
        {
          if (this.dXm.type == 6)
          {
            paramBundle = e.a.bcU(this.dXm.iwJ);
            if (paramBundle == null)
            {
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.PiI = paramBundle.longValue();
            continue;
          }
          if (this.dXm.type == 2)
          {
            this.PiI = 2L;
            paramBundle = q.bcR().U(this.qnv);
            if (paramBundle != null) {
              this.PiA = paramBundle.iXy;
            }
          }
          else
          {
            Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.qnv.getType() == 3)
            {
              paramBundle = q.bcR().U(this.qnv);
              if (paramBundle != null) {
                this.PiA = paramBundle.iXy;
              }
            }
            for (;;)
            {
              paramBundle = e.a.bcU(this.Piz);
              if (paramBundle != null) {
                break label1014;
              }
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.qnv.getType() == 43)
              {
                paramBundle = o.bhj().Qq(this.qnv.field_imgPath);
                if (paramBundle != null) {
                  this.PiA = paramBundle.bhv();
                }
              }
            }
            label1014:
            this.PiI = paramBundle.longValue();
          }
        }
      }
      paramBundle.dHy.msgId = this.gof;
      break label260;
      label1039:
      if ((i == 4) || (i == 42))
      {
        i = 1;
        break label461;
      }
      if (i == 15)
      {
        i = 6;
        break label461;
      }
      if (i == 3)
      {
        i = 5;
        break label461;
      }
      label1077:
      i = 0;
      break label461;
      label1082:
      long l = this.gof;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      for (;;)
      {
        this.PiN = i;
        break;
        bg.aVF();
        paramBundle = com.tencent.mm.model.c.aSQ().Hb(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (!paramBundle.dOQ()) {
            break label1243;
          }
          paramBundle = k.b.HD((String)localObject);
          if (paramBundle != null) {
            break label1182;
          }
          Log.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        }
        label1182:
        label1243:
        do
        {
          do
          {
            i = 0;
            break;
            if (paramBundle.type == 3)
            {
              i = 1;
              break;
            }
            if (paramBundle.type == 4) {
              break;
            }
            if (paramBundle.type == 6)
            {
              i = 4;
              break;
            }
            if (paramBundle.type == 2)
            {
              i = 3;
              break;
            }
          } while (paramBundle.type != 5);
          i = 5;
          break;
          if (j == 3)
          {
            i = 3;
            break;
          }
          if (j == 48)
          {
            i = 2;
            break;
          }
        } while (j != 62);
      }
      label1273:
      this.PiB.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34675);
    super.onDestroy();
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.PiL = false;
    if (this.PiE.booleanValue())
    {
      if (!this.PiK) {
        GD(2);
      }
      EventCenter.instance.removeListener(this.PiS);
      EventCenter.instance.removeListener(this.PiT);
      fl localfl = new fl();
      EventCenter.instance.publish(localfl);
      if (localfl.dIL.isSuccess) {
        Log.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
      }
    }
    AppMethodBeat.o(34675);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34673);
    super.onPause();
    AppMethodBeat.o(34673);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34672);
    super.onResume();
    gNU();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.PiE.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.Piv.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.cb.a.ez(this);
      if (f != com.tencent.mm.cb.a.iY(this)) {
        break label85;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165508));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165534))) {
      label85:
      do
      {
        this.Piv.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(34672);
        return;
      } while ((f != com.tencent.mm.cb.a.ja(this)) && (f != com.tencent.mm.cb.a.iZ(this)) && (f != com.tencent.mm.cb.a.jb(this)));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private List<Map<String, ChattingSendDataToDeviceUI.c>> PdW;
    private Map<String, ChattingSendDataToDeviceUI.c> Pjc;
    private Context context;
    private com.tencent.mm.av.a.a.c rFu;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(34650);
      this.context = paramContext;
      this.PdW = new ArrayList();
      this$1 = new c.a();
      ChattingSendDataToDeviceUI.this.jbq = 2131234199;
      this.rFu = ChattingSendDataToDeviceUI.this.bdv();
      AppMethodBeat.o(34650);
    }
    
    public final void ad(List<ChattingSendDataToDeviceUI.c> paramList)
    {
      AppMethodBeat.i(34651);
      this.PdW.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.Pjc = new HashMap();
        this.Pjc.put("hard_device_info", paramList.get(i));
        this.PdW.add(this.Pjc);
        i += 1;
      }
      AppMethodBeat.o(34651);
    }
    
    public final ChattingSendDataToDeviceUI.c aml(int paramInt)
    {
      AppMethodBeat.i(34653);
      ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((Map)this.PdW.get(paramInt)).get("hard_device_info");
      AppMethodBeat.o(34653);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34652);
      int i = this.PdW.size();
      AppMethodBeat.o(34652);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(34654);
      ChattingSendDataToDeviceUI.c localc = aml(paramInt);
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      final int i;
      final int j;
      StringBuffer localStringBuffer;
      float f;
      label264:
      int k;
      label267:
      String str2;
      if (ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt)) == null)
      {
        paramView = new as();
        paramViewGroup = View.inflate(paramViewGroup.getContext(), 2131496229, null);
        paramView.rII = paramViewGroup.findViewById(2131299174);
        paramView.kgE = ((TextView)paramViewGroup.findViewById(2131305210));
        paramView.nnL = ((ImageView)paramViewGroup.findViewById(2131302475));
        paramView.Pjb = ((TextView)paramViewGroup.findViewById(2131307603));
        paramView.Plh = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(2131307602));
        paramView.Plh.setVisibility(4);
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localc.deviceID, Integer.valueOf(paramInt));
        String str1 = localc.gCv;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.cb.a.ez(this.context);
        if ((f != com.tencent.mm.cb.a.iY(this.context)) && (f != com.tencent.mm.cb.a.iZ(this.context))) {
          break label374;
        }
        i = 6;
        k = 0;
        if (k >= str1.length()) {
          break label427;
        }
        int m = Character.codePointAt(str1, k);
        str2 = str1.substring(k, k + 1);
        if ((m < 0) || (m > 255)) {
          break label406;
        }
        j += 1;
        label318:
        if (j > i) {
          break label415;
        }
        localObject = ((StringBuffer)localObject).append(str2);
      }
      for (;;)
      {
        k += 1;
        break label267;
        paramViewGroup = (View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt));
        paramView = (as)paramViewGroup.getTag();
        break;
        label374:
        if ((f != com.tencent.mm.cb.a.ja(this.context)) && (f != com.tencent.mm.cb.a.jb(this.context))) {
          break label264;
        }
        i = 5;
        break label264;
        label406:
        j += 2;
        break label318;
        label415:
        localStringBuffer = localStringBuffer.append(str2);
      }
      label427:
      paramView.kgE.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.Pjb.setText(localStringBuffer);
      }
      Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(aml(paramInt).deviceID)) {
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(aml(paramInt).deviceID);
      }
      if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).dIr != null))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).dIr });
        if (!((ChattingSendDataToDeviceUI.c)localObject).dIr.equals("send_data_sending")) {
          break label756;
        }
        paramView.Pjb.setText(this.context.getString(2131757528));
        paramView.Pjb.setTextColor(this.context.getResources().getColor(2131101053));
        paramView.Plh.amr(localc.progress);
        paramView.Plh.setVisibility(0);
        localObject = localc.deviceID;
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
        if (j < 100) {
          break label742;
        }
        i = 0;
        com.tencent.f.h.RTc.ba(new com.tencent.f.i.h()
        {
          public final String getKey()
          {
            return "SendDataState_handler";
          }
          
          public final void run()
          {
            AppMethodBeat.i(34649);
            int i = j + 1;
            int j;
            while (ChattingSendDataToDeviceUI.this.PiL)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                if (this.PiX.dIr.equals("send_data_sucess"))
                {
                  j = i;
                  ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(34647);
                      ChattingSendDataToDeviceUI.a.1.this.PiW.Plh.amr(0);
                      ChattingSendDataToDeviceUI.a.1.this.PiW.Plh.setVisibility(4);
                      ChattingSendDataToDeviceUI.a.1.this.PiW.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(2131757526));
                      ChattingSendDataToDeviceUI.a.1.this.PiW.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131101053));
                      ChattingSendDataToDeviceUI.a.1.this.PiX.dIr = "send_data_sucess";
                      ChattingSendDataToDeviceUI.a.1.this.PiX.progress = 0;
                      ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.PiX.deviceID, ChattingSendDataToDeviceUI.a.1.this.PiX);
                      Log.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.PiX.deviceID });
                      AppMethodBeat.o(34647);
                    }
                  });
                  AppMethodBeat.o(34649);
                  return;
                }
                j = i;
                if (!this.PiX.dIr.equals("send_data_failed")) {
                  continue;
                }
                j = i;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34648);
                    ChattingSendDataToDeviceUI.a.1.this.PiW.Plh.amr(0);
                    ChattingSendDataToDeviceUI.a.1.this.PiW.Plh.setVisibility(4);
                    ChattingSendDataToDeviceUI.a.1.this.PiW.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(2131757523));
                    ChattingSendDataToDeviceUI.a.1.this.PiW.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131101056));
                    ChattingSendDataToDeviceUI.a.1.this.PiX.dIr = "send_data_failed";
                    ChattingSendDataToDeviceUI.a.1.this.PiX.progress = 0;
                    ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.PiX.deviceID, ChattingSendDataToDeviceUI.a.1.this.PiX);
                    Log.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.PiX.deviceID });
                    AppMethodBeat.o(34648);
                  }
                });
                AppMethodBeat.o(34649);
                return;
              }
              catch (Exception localException)
              {
                Log.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              paramView.Plh.amr(i);
              j = i;
              this.PiX.progress = i;
              i += 1;
              j = i;
              Thread.sleep(i);
            }
            AppMethodBeat.o(34649);
          }
        });
      }
      for (;;)
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.gCv });
        q.bcV().a(localc.iconUrl, paramView.nnL, this.rFu);
        paramView.rII.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(34654);
        return paramViewGroup;
        label742:
        i = 500 / (100 - j);
        break;
        label756:
        if (((ChattingSendDataToDeviceUI.c)localObject).dIr.equals("send_data_sucess"))
        {
          paramView.Pjb.setText(this.context.getString(2131757526));
          paramView.Pjb.setTextColor(this.context.getResources().getColor(2131101053));
          paramView.Plh.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).dIr.equals("send_data_cancel"))
        {
          paramView.Pjb.setText(this.context.getString(2131757519));
          paramView.Pjb.setTextColor(this.context.getResources().getColor(2131101051));
          paramView.Plh.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).dIr.equals("send_data_failed"))
        {
          paramView.Pjb.setText(this.context.getString(2131757523));
          paramView.Pjb.setTextColor(this.context.getResources().getColor(2131101056));
          paramView.Plh.setVisibility(4);
        }
      }
    }
  }
  
  public final class b
  {
    public b() {}
    
    private boolean m(IEvent paramIEvent)
    {
      AppMethodBeat.i(34658);
      paramIEvent = (ez)paramIEvent;
      String str1 = paramIEvent.dIp.dIr;
      String str2 = paramIEvent.dIp.dGL;
      if (str1.equals("send_data_sending")) {
        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, paramIEvent.dIp.progress);
      }
      for (;;)
      {
        AppMethodBeat.o(34658);
        return true;
        if (str1.equals("send_data_failed")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
        } else if (str1.equals("send_data_sucess")) {
          ChattingSendDataToDeviceUI.this.bmx(str2);
        }
      }
    }
    
    private boolean n(IEvent paramIEvent)
    {
      AppMethodBeat.i(34659);
      paramIEvent = ((ev)paramIEvent).dIf.dHs;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramIEvent.size())
      {
        ChattingSendDataToDeviceUI.c localc = new ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this);
        localc.dGP = ((String)((Map)paramIEvent.get(i)).get("deviceType"));
        localc.deviceID = ((String)((Map)paramIEvent.get(i)).get("deviceID"));
        localc.gCv = ((String)((Map)paramIEvent.get(i)).get("displayName"));
        localc.iconUrl = ((String)((Map)paramIEvent.get(i)).get("iconUrl"));
        localc.dIn = ((String)((Map)paramIEvent.get(i)).get("ability"));
        localc.Pjg = ((String)((Map)paramIEvent.get(i)).get("abilityInf"));
        if (((ChattingSendDataToDeviceUI.this.dIo) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this)))) || ((!ChattingSendDataToDeviceUI.this.dIo) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this)))))
        {
          if ((ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(localc.deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).dIr != null))
          {
            localc.dIr = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).dIr;
            localc.progress = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).progress;
          }
          localArrayList.add(localc);
        }
        i += 1;
      }
      if (ChattingSendDataToDeviceUI.l(ChattingSendDataToDeviceUI.this).size() != localArrayList.size())
      {
        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, localArrayList);
        ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34656);
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).ad(ChattingSendDataToDeviceUI.l(ChattingSendDataToDeviceUI.this));
            if (ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).getCount() > 0)
            {
              ChattingSendDataToDeviceUI.m(ChattingSendDataToDeviceUI.this).setText(2131757336);
              ChattingSendDataToDeviceUI.n(ChattingSendDataToDeviceUI.this);
            }
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).notifyDataSetChanged();
            AppMethodBeat.o(34656);
          }
        });
      }
      AppMethodBeat.o(34659);
      return true;
    }
    
    public final boolean l(IEvent paramIEvent)
    {
      AppMethodBeat.i(34657);
      boolean bool;
      if ((paramIEvent instanceof ev))
      {
        bool = n(paramIEvent);
        AppMethodBeat.o(34657);
        return bool;
      }
      if ((paramIEvent instanceof ez))
      {
        bool = m(paramIEvent);
        AppMethodBeat.o(34657);
        return bool;
      }
      AppMethodBeat.o(34657);
      return true;
    }
  }
  
  public final class c
  {
    String Pjg;
    String dGP;
    String dIn;
    String dIr;
    String deviceID;
    String gCv;
    String iconUrl;
    int progress;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */