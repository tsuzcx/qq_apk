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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.dz;
import com.tencent.mm.f.a.ek;
import com.tencent.mm.f.a.ek.b;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.fc;
import com.tencent.mm.f.a.fc.a;
import com.tencent.mm.f.a.ff;
import com.tencent.mm.f.a.ff.b;
import com.tencent.mm.f.a.fg;
import com.tencent.mm.f.a.fg.a;
import com.tencent.mm.f.a.fs;
import com.tencent.mm.f.a.fs.a;
import com.tencent.mm.f.a.kv;
import com.tencent.mm.f.a.kv.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
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
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
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
  private HorizontalListView WBX;
  private HorizontalListView WBY;
  private b WBZ;
  private a WCa;
  private int WCb;
  private String WCc;
  private RelativeLayout WCd;
  private RelativeLayout WCe;
  private TextView WCf;
  private Boolean WCg;
  private b WCh;
  private List<c> WCi;
  private List<com.tencent.mm.pluginsdk.model.app.g> WCj;
  private long WCk;
  private boolean WCl;
  boolean WCm;
  boolean WCn;
  int WCo;
  int WCp;
  private HashMap<String, View> WCq;
  private HashMap<String, c> WCr;
  private Map<Integer, View> WCs;
  private Map<String, Integer> WCt;
  private IListener WCu;
  private IListener WCv;
  private boolean Wwx;
  boolean Wxq;
  boolean fBf;
  private k.b fQY;
  String filePath;
  private long iSo;
  String jmx;
  WXMediaMessage sgD;
  private ca tMi;
  private String veZ;
  
  public ChattingSendDataToDeviceUI()
  {
    AppMethodBeat.i(34660);
    this.WCc = "";
    this.WCg = Boolean.FALSE;
    this.WCi = new ArrayList();
    this.WCj = new ArrayList();
    this.WCk = 0L;
    this.WCl = true;
    this.fBf = false;
    this.WCm = false;
    this.WCn = true;
    this.WCo = 2;
    this.WCp = -1;
    this.WCq = new HashMap();
    this.WCr = new HashMap();
    this.WCs = new HashMap();
    this.WCt = new HashMap();
    this.sgD = null;
    this.filePath = null;
    this.jmx = null;
    this.Wxq = false;
    this.WCu = new IListener() {};
    this.WCv = new IListener() {};
    AppMethodBeat.o(34660);
  }
  
  private void Kl(int paramInt)
  {
    AppMethodBeat.i(34662);
    if (this.fBf)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.WCp), "", Integer.valueOf(2), Integer.valueOf(this.WCo) });
      AppMethodBeat.o(34662);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.WCp), Vz(this.iSo), Integer.valueOf(1), Integer.valueOf(this.WCo) });
    AppMethodBeat.o(34662);
  }
  
  private static String Vz(long paramLong)
  {
    AppMethodBeat.i(34663);
    String str2 = "";
    bh.beI();
    Object localObject = com.tencent.mm.model.c.bbO().Oq(paramLong);
    if (((et)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(34663);
      return "";
    }
    String str3 = ((et)localObject).field_content;
    String str1 = str2;
    if (((ca)localObject).getType() == 49)
    {
      localObject = k.b.OQ(str3);
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((k.b)localObject).type == 6) {
          str1 = ((k.b)localObject).llY;
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
    String str1 = paramc.fBe;
    bh.beI();
    Object localObject = com.tencent.mm.model.c.bbO().Oq(paramLong);
    if ((((et)localObject).field_msgId == 0L) || (str1 == null))
    {
      AppMethodBeat.o(34671);
      return false;
    }
    int i = ((ca)localObject).getType();
    String str2 = ((et)localObject).field_content;
    boolean bool1;
    if (((ca)localObject).erk())
    {
      localObject = k.b.OQ(str2);
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
    Object localObject = new kv();
    ((kv)localObject).fIq.fAg = paramString;
    EventCenter.instance.publish((IEvent)localObject);
    paramString = ((kv)localObject).fIr.fIs;
    int i = paramString.ContentObj.Sqq;
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.fBe;
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
    Object localObject = paramc.fBe;
    paramc = paramc.WCI;
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
  
  private void hNd()
  {
    AppMethodBeat.i(34665);
    if ((this.WBZ == null) || (this.WCk == 0L))
    {
      if (this.WBZ == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.WCk) });
        if (this.WCe != null) {
          this.WCe.setVisibility(8);
        }
        AppMethodBeat.o(34665);
        return;
      }
    }
    this.WCj = com.tencent.mm.pluginsdk.model.app.h.c(this, this.WCk, false);
    if ((!com.tencent.mm.pluginsdk.model.app.h.u(this, this.WCk)) && (this.WCe != null)) {
      this.WCe.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.WCj != null) && (this.WCj.size() > 0))
    {
      localObject1 = ao.hhI().TT(this.WCk);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.WCj, new Comparator() {});
      }
      localObject1 = this.WCj.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next();
        localObject3 = new z();
        ((z)localObject3).appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
        ((z)localObject3).jmB = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
        ((z)localObject3).iconUrl = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.sgD == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.tMi.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.sgD = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.sgD.sdkVer = 637992960;
      if ((this.jmx != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.Wxq = true;
      }
      label403:
      this.WBZ.Wxq = this.Wxq;
      this.WBZ.aa(localArrayList);
      this.WBZ.notifyDataSetChanged();
      AppMethodBeat.o(34665);
      return;
      localObject1 = localObject3;
      if (this.fQY != null) {
        if (this.fQY.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.fQY.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.fQY.lms;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.fQY.llW;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.fQY.lmt;
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)this.fQY.ar(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            ((WXMusicObject)localObject1).songAlbumUrl = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songAlbumUrl;
            ((WXMusicObject)localObject1).songLyric = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songLyric;
          }
        }
        else if (this.fQY.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.fQY.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.fQY.lmt;
        }
        else if (this.fQY.type == 5)
        {
          localObject1 = new WXWebpageObject(this.fQY.url);
        }
        else
        {
          if (this.fQY.type == 6)
          {
            localObject3 = ao.ctZ().bpR(this.fQY.fvr);
            if (localObject3 != null)
            {
              Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              this.jmx = this.fQY.llY;
            }
            while (r.bqj(this.filePath) != null)
            {
              com.tencent.mm.ui.base.h.cO(this, getString(R.l.ewU));
              finish();
              break label403;
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.fQY.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = q.bmh().aa(this.tMi);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = q.bmh().VW(((com.tencent.mm.ay.g)localObject2).lNH);
              if (Util.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = q.bmh().VW(((com.tencent.mm.ay.g)localObject2).lNJ);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.jmx = this.fQY.llY;
            Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.tMi.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = q.bmh().aa(this.tMi);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = q.bmh().VW(((com.tencent.mm.ay.g)localObject2).lNH);
              if (Util.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = q.bmh().VW(((com.tencent.mm.ay.g)localObject2).lNJ);
              }
              if (!Util.isNullOrNil(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.jmx = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            bh.beI();
            localObject1 = com.tencent.mm.model.c.bbO().aOV(this.tMi.field_content);
            localObject1 = new WXLocationObject(((ca.b)localObject1).Ejn, ((ca.b)localObject1).Ejo);
            continue;
            localObject2 = new WXVideoObject();
            s.bqB();
            localObject3 = x.XT(this.tMi.field_imgPath);
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
                  this.jmx = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void hNe()
  {
    AppMethodBeat.i(34666);
    Object localObject1 = new ek();
    Object localObject2;
    int i;
    if (this.fBf)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      ((ek)localObject1).fAe.fAg = this.veZ;
      ((ek)localObject1).fAe.fAh = ((String)localObject2);
      ((ek)localObject1).fAe.fAi = str;
      EventCenter.instance.publish((IEvent)localObject1);
      if (!((ek)localObject1).fAf.fzO) {
        break label436;
      }
      localObject1 = ((ek)localObject1).fAf.fAj;
      int j = ((List)localObject1).size();
      i = 0;
      label115:
      if (i >= j) {
        break label372;
      }
      localObject2 = new c();
      ((c)localObject2).fzF = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((c)localObject2).jmB = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((c)localObject2).fBe = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((c)localObject2).WCI = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.fBf) || (!a((c)localObject2, this.veZ))) {
        break label338;
      }
      this.WCi.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label115;
      ((ek)localObject1).fAe.msgId = this.iSo;
      break;
      label338:
      if ((!this.fBf) && (a((c)localObject2, this.iSo))) {
        this.WCi.add(localObject2);
      }
    }
    label372:
    if (this.WCi.size() > 0)
    {
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.WCa.aa(this.WCi);
      if (this.WCa.getCount() > 0)
      {
        this.WCf.setText(R.l.eut);
        this.WCl = false;
      }
      this.WCa.notifyDataSetChanged();
    }
    label436:
    AppMethodBeat.o(34666);
  }
  
  public final void byY(final String paramString)
  {
    AppMethodBeat.i(34670);
    try
    {
      final int i = ((Integer)this.WCt.get(paramString)).intValue();
      final as localas = (as)((View)this.WCs.get(Integer.valueOf(i))).getTag();
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(localas.WER.getProgress()), paramString });
      final c localc = (c)this.WCr.get(paramString);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34643);
          localas.WER.setVisibility(0);
          localas.WCD.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_sending));
          localas.WCD.setText(ChattingSendDataToDeviceUI.this.getText(R.l.exd));
          localc.fBi = "send_data_sending";
          AppMethodBeat.o(34643);
        }
      });
      final int j = Math.abs(localas.WER.getProgress());
      localc.progress = j;
      if (j >= 100) {}
      for (i = 0;; i = 500 / (100 - j))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
        com.tencent.e.h.ZvG.bh(new com.tencent.e.i.h()
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
                    ChattingSendDataToDeviceUI.10.this.WCy.WER.avr(0);
                    ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(ChattingSendDataToDeviceUI.10.this.oHg);
                    ChattingSendDataToDeviceUI.10.this.WCy.WER.setVisibility(4);
                    ChattingSendDataToDeviceUI.10.this.WCy.WCD.setText(ChattingSendDataToDeviceUI.this.getText(R.l.exb));
                    ChattingSendDataToDeviceUI.10.this.WCy.WCD.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_sending));
                    ChattingSendDataToDeviceUI.10.this.WCz.fBi = "send_data_sucess";
                    ChattingSendDataToDeviceUI.10.this.WCz.progress = 0;
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
              localas.WER.avr(i);
              i += 1;
              j = i;
              Thread.sleep(i);
            }
          }
        });
        this.WCr.put(localc.deviceID, localc);
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
  
  public int getLayoutId()
  {
    return R.i.eeH;
  }
  
  public final b hNf()
  {
    AppMethodBeat.i(34676);
    if (this.WCh == null) {
      this.WCh = new b();
    }
    b localb = this.WCh;
    AppMethodBeat.o(34676);
    return localb;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34674);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
    AppMethodBeat.o(34674);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(34669);
    if (this.WCq.size() > 0)
    {
      d.a locala = new d.a(this);
      locala.ayg(R.l.ewW);
      locala.ayj(R.l.ewY).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34641);
          paramAnonymousDialogInterface = ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).keySet().iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            dz localdz = new dz();
            localdz.fzA.fzB = str;
            EventCenter.instance.publish(localdz);
          }
          ChattingSendDataToDeviceUI.this.finish();
          AppMethodBeat.o(34641);
        }
      });
      locala.ayk(R.l.ewX).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34642);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(34642);
        }
      });
      locala.icu().show();
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
    paramConfiguration = new ek();
    if (this.fBf)
    {
      String str1 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      paramConfiguration.fAe.fAg = this.veZ;
      paramConfiguration.fAe.fAh = str1;
      paramConfiguration.fAe.fAi = str2;
    }
    for (;;)
    {
      EventCenter.instance.publish(paramConfiguration);
      if ((paramConfiguration.fAf.fzO) && (this.WCi.size() > 0))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.WCi.size()) });
        this.WCa.aa(this.WCi);
        if (this.WCa.getCount() > 0)
        {
          this.WCf.setText(R.l.eut);
          this.WCl = false;
        }
        this.WCa.notifyDataSetChanged();
      }
      AppMethodBeat.o(34664);
      return;
      paramConfiguration.fAe.msgId = this.iSo;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    AppMethodBeat.i(34661);
    super.onCreate(paramBundle);
    this.fBf = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.fBf);
    if (!this.fBf)
    {
      this.iSo = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.iSo != -1L)
      {
        bh.beI();
        this.tMi = com.tencent.mm.model.c.bbO().Oq(this.iSo);
        if ((this.tMi != null) && (this.tMi.field_msgId != 0L)) {
          break label562;
        }
      }
    }
    this.WCo = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.WCm = false;
    setFinishOnTouchOutside(true);
    this.WCi.clear();
    this.WCr.clear();
    this.WCd = ((RelativeLayout)findViewById(R.h.dPo));
    paramBundle = new em();
    label260:
    Object localObject;
    if (this.fBf)
    {
      this.veZ = getIntent().getExtras().getString("sns_local_id");
      if (this.veZ != null)
      {
        paramBundle.fAp.fAg = this.veZ;
        Log.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.veZ });
      }
      EventCenter.instance.publish(paramBundle);
      if (!paramBundle.fAq.fzO) {
        break label1273;
      }
      this.WCg = Boolean.TRUE;
      EventCenter.instance.addListener(this.WCu);
      EventCenter.instance.addListener(this.WCv);
      this.WCd.setVisibility(0);
      this.WBX = ((HorizontalListView)findViewById(R.h.listview));
      this.WCf = ((TextView)findViewById(R.h.dsc));
      this.WCf.setText(R.l.ewT);
      this.WCa = new a(this);
      this.WBX.setAdapter(this.WCa);
      this.WBX.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34637);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          ChattingSendDataToDeviceUI.this.WCm = true;
          localObject = ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).avm(paramAnonymousInt);
          String str1 = ((ChattingSendDataToDeviceUI.c)localObject).fzF;
          paramAnonymousAdapterView = ((ChattingSendDataToDeviceUI.c)localObject).deviceID;
          String str2 = ((ChattingSendDataToDeviceUI.c)localObject).fBe;
          for (;;)
          {
            try
            {
              if (ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).get(paramAnonymousAdapterView) != null)
              {
                Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                paramAnonymousView = new dz();
                paramAnonymousView.fzA.fzB = paramAnonymousAdapterView;
                EventCenter.instance.publish(paramAnonymousView);
                ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", paramAnonymousAdapterView, 0);
                ((ChattingSendDataToDeviceUI.c)localObject).fBi = "send_data_cancel";
                ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(paramAnonymousAdapterView);
                paramAnonymousAdapterView = (as)((View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramAnonymousInt))).getTag();
                paramAnonymousAdapterView.WCD.setText(ChattingSendDataToDeviceUI.this.getText(R.l.ewV));
                paramAnonymousAdapterView.WCD.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_cancel));
                paramAnonymousAdapterView.WER.setVisibility(8);
                paramAnonymousAdapterView.WER.avr(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34637);
                return;
              }
              ((ChattingSendDataToDeviceUI.c)localObject).fBi = "send_data_sending";
              ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(((ChattingSendDataToDeviceUI.c)localObject).deviceID, localObject);
              ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).put(paramAnonymousAdapterView, paramAnonymousView);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", paramAnonymousAdapterView, 1);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
              paramAnonymousView = new ff();
              paramAnonymousView.fBc.fzB = paramAnonymousAdapterView;
              paramAnonymousView.fBc.fzF = str1;
              paramAnonymousView.fBc.data = ChattingSendDataToDeviceUI.e(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.fBc.fBe = str2;
              if (!ChattingSendDataToDeviceUI.this.fBf) {
                continue;
              }
              paramAnonymousView.fBc.fAg = ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.fBc.fBf = ChattingSendDataToDeviceUI.this.fBf;
              EventCenter.instance.publish(paramAnonymousView);
              if (!paramAnonymousView.fBd.isSuccess)
              {
                ChattingSendDataToDeviceUI.byZ("send_data_failed");
                Log.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
              }
            }
            catch (Exception paramAnonymousAdapterView)
            {
              ChattingSendDataToDeviceUI.byZ("send_data_failed");
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAnonymousAdapterView });
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34637);
            return;
            paramAnonymousView.fBc.msgId = ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this);
          }
        }
      });
      hNe();
      if (!this.fBf) {
        break label1082;
      }
      paramBundle = this.veZ;
      if (paramBundle == null) {
        break label1077;
      }
      localObject = new kv();
      ((kv)localObject).fIq.fAg = paramBundle;
      EventCenter.instance.publish((IEvent)localObject);
      i = ((kv)localObject).fIr.fIs.ContentObj.Sqq;
      if (i != 1) {
        break label1039;
      }
      i = 3;
      label461:
      this.WCp = i;
      Kl(1);
    }
    for (;;)
    {
      this.WCe = ((RelativeLayout)findViewById(R.h.drx));
      this.WBY = ((HorizontalListView)findViewById(R.h.drd));
      this.WBZ = new b(this);
      this.WBY.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34639);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          Log.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)
          {
            paramAnonymousView = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(ChattingSendDataToDeviceUI.this));
            paramAnonymousAdapterView = ChattingSendDataToDeviceUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34639);
            return;
            if ((ChattingSendDataToDeviceUI.this.Wxq) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 2))
            {
              if ((ChattingSendDataToDeviceUI.this.filePath == null) || (ChattingSendDataToDeviceUI.this.jmx == null))
              {
                com.tencent.mm.ui.base.h.cO(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.l.download_no_match_msg));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34639);
                return;
              }
              com.tencent.mm.pluginsdk.ui.tools.a.b(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.jmx.toLowerCase(), 1);
            }
            else if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.getAdapter().getCount() - 1))
            {
              paramAnonymousAdapterView = (com.tencent.mm.pluginsdk.model.app.g)ChattingSendDataToDeviceUI.i(ChattingSendDataToDeviceUI.this).get(paramAnonymousInt);
              if (!com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView))
              {
                com.tencent.mm.ui.base.h.cO(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.l.chatting_send_app_not_installed));
                paramAnonymousAdapterView.field_status = 4;
                ao.fmz().a(paramAnonymousAdapterView, new String[0]);
                ChattingSendDataToDeviceUI.j(ChattingSendDataToDeviceUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34639);
                return;
              }
              com.tencent.mm.co.a.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(34638);
                  com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView.field_packageName, ChattingSendDataToDeviceUI.this.sgD, paramAnonymousAdapterView.field_appId, paramAnonymousAdapterView.field_openId, 0, null, null);
                  AppMethodBeat.o(34638);
                }
              });
            }
          }
        }
      });
      this.WBY.setAdapter(this.WBZ);
      findViewById(R.h.dSE).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34634);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ChattingSendDataToDeviceUI.this.onBackPressed();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34634);
        }
      });
      AppMethodBeat.o(34661);
      return;
      label562:
      this.WCb = this.tMi.getType();
      this.Wwx = ab.Lj(this.tMi.field_talker);
      this.WCc = this.tMi.field_content;
      int j;
      if ((this.Wwx) && (this.tMi.field_isSend == 0))
      {
        localObject = this.tMi.field_content;
        j = this.tMi.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.Wwx)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = bq.RM((String)localObject);
            }
          }
        }
        this.WCc = paramBundle;
      }
      if (this.tMi.getType() == 49)
      {
        this.fQY = k.b.OQ(this.WCc);
        if (this.fQY == null)
        {
          Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.fQY.type == 3) {
          this.WCk = 16L;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.WCk) });
        break;
        if (this.fQY.type == 4)
        {
          this.WCk = 8L;
        }
        else if (this.fQY.type == 5)
        {
          this.WCk = 32L;
        }
        else
        {
          if (this.fQY.type == 6)
          {
            paramBundle = e.a.boU(this.fQY.llY);
            if (paramBundle == null)
            {
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.WCk = paramBundle.longValue();
            continue;
          }
          if (this.fQY.type == 2)
          {
            this.WCk = 2L;
            paramBundle = q.bmh().aa(this.tMi);
            if (paramBundle != null) {
              this.WCc = paramBundle.lNS;
            }
          }
          else
          {
            Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.tMi.getType() == 3)
            {
              paramBundle = q.bmh().aa(this.tMi);
              if (paramBundle != null) {
                this.WCc = paramBundle.lNS;
              }
            }
            for (;;)
            {
              paramBundle = e.a.boU(this.WCb);
              if (paramBundle != null) {
                break label1014;
              }
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.tMi.getType() == 43)
              {
                paramBundle = s.bqB().XN(this.tMi.field_imgPath);
                if (paramBundle != null) {
                  this.WCc = paramBundle.bqO();
                }
              }
            }
            label1014:
            this.WCk = paramBundle.longValue();
          }
        }
      }
      paramBundle.fAp.msgId = this.iSo;
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
      long l = this.iSo;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      for (;;)
      {
        this.WCp = i;
        break;
        bh.beI();
        paramBundle = com.tencent.mm.model.c.bbO().Oq(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (!paramBundle.erk()) {
            break label1243;
          }
          paramBundle = k.b.OQ((String)localObject);
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
      this.WCd.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34675);
    super.onDestroy();
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.WCn = false;
    if (this.WCg.booleanValue())
    {
      if (!this.WCm) {
        Kl(2);
      }
      EventCenter.instance.removeListener(this.WCu);
      EventCenter.instance.removeListener(this.WCv);
      fs localfs = new fs();
      EventCenter.instance.publish(localfs);
      if (localfs.fBC.isSuccess) {
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
    hNd();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.WCg.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.WBX.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.ci.a.ez(this);
      if (f != com.tencent.mm.ci.a.kc(this)) {
        break label85;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(R.f.LittlePadding));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(R.f.NormalPadding))) {
      label85:
      do
      {
        this.WBX.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(34672);
        return;
      } while ((f != com.tencent.mm.ci.a.ke(this)) && (f != com.tencent.mm.ci.a.kd(this)) && (f != com.tencent.mm.ci.a.kf(this)));
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
    private Map<String, ChattingSendDataToDeviceUI.c> WCE;
    private List<Map<String, ChattingSendDataToDeviceUI.c>> Wxp;
    private Context context;
    private com.tencent.mm.ay.a.a.c vle;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(34650);
      this.context = paramContext;
      this.Wxp = new ArrayList();
      this$1 = new c.a();
      ChattingSendDataToDeviceUI.this.lRP = R.g.doe;
      this.vle = ChattingSendDataToDeviceUI.this.bmL();
      AppMethodBeat.o(34650);
    }
    
    public final void aa(List<ChattingSendDataToDeviceUI.c> paramList)
    {
      AppMethodBeat.i(34651);
      this.Wxp.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.WCE = new HashMap();
        this.WCE.put("hard_device_info", paramList.get(i));
        this.Wxp.add(this.WCE);
        i += 1;
      }
      AppMethodBeat.o(34651);
    }
    
    public final ChattingSendDataToDeviceUI.c avm(int paramInt)
    {
      AppMethodBeat.i(34653);
      ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((Map)this.Wxp.get(paramInt)).get("hard_device_info");
      AppMethodBeat.o(34653);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34652);
      int i = this.Wxp.size();
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
      ChattingSendDataToDeviceUI.c localc = avm(paramInt);
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      final int i;
      final int j;
      StringBuffer localStringBuffer;
      float f;
      label270:
      int k;
      label273:
      String str2;
      if (ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt)) == null)
      {
        paramView = new as();
        paramViewGroup = View.inflate(paramViewGroup.getContext(), R.i.ekM, null);
        paramView.voq = paramViewGroup.findViewById(R.h.container);
        paramView.mYd = ((TextView)paramViewGroup.findViewById(R.h.dNd));
        paramView.qps = ((ImageView)paramViewGroup.findViewById(R.h.dIy));
        paramView.WCD = ((TextView)paramViewGroup.findViewById(R.h.dTJ));
        paramView.WER = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(R.h.dTI));
        paramView.WER.setVisibility(4);
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localc.deviceID, Integer.valueOf(paramInt));
        String str1 = localc.jmB;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.ci.a.ez(this.context);
        if ((f != com.tencent.mm.ci.a.kc(this.context)) && (f != com.tencent.mm.ci.a.kd(this.context))) {
          break label380;
        }
        i = 6;
        k = 0;
        if (k >= str1.length()) {
          break label433;
        }
        int m = Character.codePointAt(str1, k);
        str2 = str1.substring(k, k + 1);
        if ((m < 0) || (m > 255)) {
          break label412;
        }
        j += 1;
        label324:
        if (j > i) {
          break label421;
        }
        localObject = ((StringBuffer)localObject).append(str2);
      }
      for (;;)
      {
        k += 1;
        break label273;
        paramViewGroup = (View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt));
        paramView = (as)paramViewGroup.getTag();
        break;
        label380:
        if ((f != com.tencent.mm.ci.a.ke(this.context)) && (f != com.tencent.mm.ci.a.kf(this.context))) {
          break label270;
        }
        i = 5;
        break label270;
        label412:
        j += 2;
        break label324;
        label421:
        localStringBuffer = localStringBuffer.append(str2);
      }
      label433:
      paramView.mYd.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.WCD.setText(localStringBuffer);
      }
      Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(avm(paramInt).deviceID)) {
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(avm(paramInt).deviceID);
      }
      if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).fBi != null))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).fBi });
        if (!((ChattingSendDataToDeviceUI.c)localObject).fBi.equals("send_data_sending")) {
          break label762;
        }
        paramView.WCD.setText(this.context.getString(R.l.exd));
        paramView.WCD.setTextColor(this.context.getResources().getColor(R.e.send_data_sending));
        paramView.WER.avr(localc.progress);
        paramView.WER.setVisibility(0);
        localObject = localc.deviceID;
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
        if (j < 100) {
          break label748;
        }
        i = 0;
        com.tencent.e.h.ZvG.bh(new com.tencent.e.i.h()
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
            while (ChattingSendDataToDeviceUI.this.WCn)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                if (this.WCz.fBi.equals("send_data_sucess"))
                {
                  j = i;
                  ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(34647);
                      ChattingSendDataToDeviceUI.a.1.this.WCy.WER.avr(0);
                      ChattingSendDataToDeviceUI.a.1.this.WCy.WER.setVisibility(4);
                      ChattingSendDataToDeviceUI.a.1.this.WCy.WCD.setText(ChattingSendDataToDeviceUI.this.getText(R.l.exb));
                      ChattingSendDataToDeviceUI.a.1.this.WCy.WCD.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_sending));
                      ChattingSendDataToDeviceUI.a.1.this.WCz.fBi = "send_data_sucess";
                      ChattingSendDataToDeviceUI.a.1.this.WCz.progress = 0;
                      ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.WCz.deviceID, ChattingSendDataToDeviceUI.a.1.this.WCz);
                      Log.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.WCz.deviceID });
                      AppMethodBeat.o(34647);
                    }
                  });
                  AppMethodBeat.o(34649);
                  return;
                }
                j = i;
                if (!this.WCz.fBi.equals("send_data_failed")) {
                  continue;
                }
                j = i;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34648);
                    ChattingSendDataToDeviceUI.a.1.this.WCy.WER.avr(0);
                    ChattingSendDataToDeviceUI.a.1.this.WCy.WER.setVisibility(4);
                    ChattingSendDataToDeviceUI.a.1.this.WCy.WCD.setText(ChattingSendDataToDeviceUI.this.getText(R.l.ewZ));
                    ChattingSendDataToDeviceUI.a.1.this.WCy.WCD.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_state_text_failed));
                    ChattingSendDataToDeviceUI.a.1.this.WCz.fBi = "send_data_failed";
                    ChattingSendDataToDeviceUI.a.1.this.WCz.progress = 0;
                    ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.WCz.deviceID, ChattingSendDataToDeviceUI.a.1.this.WCz);
                    Log.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.WCz.deviceID });
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
              paramView.WER.avr(i);
              j = i;
              this.WCz.progress = i;
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
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.jmB });
        q.bml().a(localc.iconUrl, paramView.qps, this.vle);
        paramView.voq.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(34654);
        return paramViewGroup;
        label748:
        i = 500 / (100 - j);
        break;
        label762:
        if (((ChattingSendDataToDeviceUI.c)localObject).fBi.equals("send_data_sucess"))
        {
          paramView.WCD.setText(this.context.getString(R.l.exb));
          paramView.WCD.setTextColor(this.context.getResources().getColor(R.e.send_data_sending));
          paramView.WER.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).fBi.equals("send_data_cancel"))
        {
          paramView.WCD.setText(this.context.getString(R.l.ewV));
          paramView.WCD.setTextColor(this.context.getResources().getColor(R.e.send_data_cancel));
          paramView.WER.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).fBi.equals("send_data_failed"))
        {
          paramView.WCD.setText(this.context.getString(R.l.ewZ));
          paramView.WCD.setTextColor(this.context.getResources().getColor(R.e.send_state_text_failed));
          paramView.WER.setVisibility(4);
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
      paramIEvent = (fg)paramIEvent;
      String str1 = paramIEvent.fBg.fBi;
      String str2 = paramIEvent.fBg.fzB;
      if (str1.equals("send_data_sending")) {
        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, paramIEvent.fBg.progress);
      }
      for (;;)
      {
        AppMethodBeat.o(34658);
        return true;
        if (str1.equals("send_data_failed")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
        } else if (str1.equals("send_data_sucess")) {
          ChattingSendDataToDeviceUI.this.byY(str2);
        }
      }
    }
    
    private boolean n(IEvent paramIEvent)
    {
      AppMethodBeat.i(34659);
      paramIEvent = ((fc)paramIEvent).fAW.fAj;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramIEvent.size())
      {
        ChattingSendDataToDeviceUI.c localc = new ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this);
        localc.fzF = ((String)((Map)paramIEvent.get(i)).get("deviceType"));
        localc.deviceID = ((String)((Map)paramIEvent.get(i)).get("deviceID"));
        localc.jmB = ((String)((Map)paramIEvent.get(i)).get("displayName"));
        localc.iconUrl = ((String)((Map)paramIEvent.get(i)).get("iconUrl"));
        localc.fBe = ((String)((Map)paramIEvent.get(i)).get("ability"));
        localc.WCI = ((String)((Map)paramIEvent.get(i)).get("abilityInf"));
        if (((ChattingSendDataToDeviceUI.this.fBf) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this)))) || ((!ChattingSendDataToDeviceUI.this.fBf) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this)))))
        {
          if ((ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(localc.deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).fBi != null))
          {
            localc.fBi = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).fBi;
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
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).aa(ChattingSendDataToDeviceUI.l(ChattingSendDataToDeviceUI.this));
            if (ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).getCount() > 0)
            {
              ChattingSendDataToDeviceUI.m(ChattingSendDataToDeviceUI.this).setText(R.l.eut);
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
      if ((paramIEvent instanceof fc))
      {
        bool = n(paramIEvent);
        AppMethodBeat.o(34657);
        return bool;
      }
      if ((paramIEvent instanceof fg))
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
    String WCI;
    String deviceID;
    String fBe;
    String fBi;
    String fzF;
    String iconUrl;
    String jmB;
    int progress;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */