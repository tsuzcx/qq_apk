package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dv.b;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.en.a;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.eq.b;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.er.a;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fd.a;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.ja.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
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
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.HorizontalListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI
  extends MMActivity
{
  private boolean GjM;
  boolean Gkw;
  private HorizontalListView GoL;
  private HorizontalListView GoM;
  private b GoN;
  private a GoO;
  private int GoP;
  private String GoQ;
  private RelativeLayout GoR;
  private RelativeLayout GoS;
  private TextView GoT;
  private Boolean GoU;
  private b GoV;
  private List<c> GoW;
  private List<com.tencent.mm.pluginsdk.model.app.g> GoX;
  private long GoY;
  private boolean GoZ;
  boolean Gpa;
  boolean Gpb;
  int Gpc;
  int Gpd;
  private HashMap<String, View> Gpe;
  private HashMap<String, c> Gpf;
  private Map<Integer, View> Gpg;
  private Map<String, Integer> Gph;
  private com.tencent.mm.sdk.b.c Gpi;
  private com.tencent.mm.sdk.b.c Gpj;
  boolean dhf;
  private k.b duP;
  String filePath;
  private long fll;
  String fyk;
  WXMediaMessage mLk;
  private bl nLz;
  private String oVb;
  
  public ChattingSendDataToDeviceUI()
  {
    AppMethodBeat.i(34660);
    this.GoQ = "";
    this.GoU = Boolean.FALSE;
    this.GoW = new ArrayList();
    this.GoX = new ArrayList();
    this.GoY = 0L;
    this.GoZ = true;
    this.dhf = false;
    this.Gpa = false;
    this.Gpb = true;
    this.Gpc = 2;
    this.Gpd = -1;
    this.Gpe = new HashMap();
    this.Gpf = new HashMap();
    this.Gpg = new HashMap();
    this.Gph = new HashMap();
    this.mLk = null;
    this.filePath = null;
    this.fyk = null;
    this.Gkw = false;
    this.Gpi = new com.tencent.mm.sdk.b.c() {};
    this.Gpj = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(34660);
  }
  
  private void Bf(int paramInt)
  {
    AppMethodBeat.i(34662);
    if (this.dhf)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Gpd), "", Integer.valueOf(2), Integer.valueOf(this.Gpc) });
      AppMethodBeat.o(34662);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Gpd), wv(this.fll), Integer.valueOf(1), Integer.valueOf(this.Gpc) });
    AppMethodBeat.o(34662);
  }
  
  private static boolean a(c paramc, long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(34671);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(34671);
      return false;
    }
    String str1 = paramc.dhe;
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().rm(paramLong);
    if ((((du)localObject).field_msgId == 0L) || (str1 == null))
    {
      AppMethodBeat.o(34671);
      return false;
    }
    int i = ((bl)localObject).getType();
    String str2 = ((du)localObject).field_content;
    if (((bl)localObject).cxB())
    {
      localObject = k.b.rx(str2);
      if (localObject == null)
      {
        ad.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        AppMethodBeat.o(34671);
        return false;
      }
      if (((k.b)localObject).type == 3) {
        if (!str1.contains("wxmsg_music")) {
          break label183;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34671);
      return bool;
      if (((k.b)localObject).type == 4) {
        bool = false;
      } else {
        label274:
        if (((k.b)localObject).type == 6)
        {
          if (str1.contains("wxmsg_file")) {}
        }
        else {
          label183:
          label254:
          do
          {
            do
            {
              do
              {
                do
                {
                  bool = false;
                  break;
                  if (((k.b)localObject).type == 5)
                  {
                    bool = a(((k.b)localObject).url, paramc);
                    break;
                  }
                } while ((((k.b)localObject).type != 2) || (!str1.contains("wxmsg_image")));
                break;
                if (i != 3) {
                  break label254;
                }
              } while (!str1.contains("wxmsg_image"));
              break;
              if (i != 48) {
                break label274;
              }
            } while (!str1.contains("wxmsg_poi"));
            break;
          } while ((i != 62) || (!str1.contains("wxmsg_video")));
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
    Object localObject = new ja();
    ((ja)localObject).dmY.dgg = paramString;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    paramString = ((ja)localObject).dmZ.dna;
    int i = paramString.Etm.DaB;
    ad.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.dhe;
    if (localObject == null)
    {
      ad.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
      AppMethodBeat.o(34668);
      return false;
    }
    if (i == 1) {
      if (!((String)localObject).contains("wxmsg_image")) {
        break label150;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34668);
      return bool;
      if (i == 4)
      {
        if (((String)localObject).contains("wxmsg_music")) {}
      }
      else
      {
        label150:
        label175:
        do
        {
          do
          {
            bool = false;
            break;
            if (i != 15) {
              break label175;
            }
          } while (!((String)localObject).contains("wxmsg_video"));
          break;
        } while (i != 3);
        bool = a(paramString.Etm.Url, paramc);
      }
    }
  }
  
  private static boolean a(String paramString, c paramc)
  {
    bool2 = false;
    AppMethodBeat.i(34667);
    Object localObject = paramc.dhe;
    paramc = paramc.Gpw;
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
        ad.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", paramString, paramc, new Object[0]);
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(34667);
      return bool1;
      i += 1;
    }
  }
  
  private void eVL()
  {
    AppMethodBeat.i(34665);
    if ((this.GoN == null) || (this.GoY == 0L))
    {
      if (this.GoN == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.GoY) });
        if (this.GoS != null) {
          this.GoS.setVisibility(8);
        }
        AppMethodBeat.o(34665);
        return;
      }
    }
    this.GoX = com.tencent.mm.pluginsdk.model.app.h.b(this, this.GoY, false);
    if ((!com.tencent.mm.pluginsdk.model.app.h.q(this, this.GoY)) && (this.GoS != null)) {
      this.GoS.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.GoX != null) && (this.GoX.size() > 0))
    {
      localObject1 = ap.evS().vl(this.GoY);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.GoX, new ChattingSendDataToDeviceUI.6(this, (List)localObject1));
      }
      localObject1 = this.GoX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next();
        localObject3 = new y();
        ((y)localObject3).appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
        ((y)localObject3).fyo = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
        ((y)localObject3).iconUrl = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.mLk == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.nLz.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.mLk = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.mLk.sdkVer = 637927424;
      if ((this.fyk != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.Gkw = true;
      }
      label403:
      this.GoN.Gkw = this.Gkw;
      this.GoN.ad(localArrayList);
      this.GoN.notifyDataSetChanged();
      AppMethodBeat.o(34665);
      return;
      localObject1 = localObject3;
      if (this.duP != null) {
        if (this.duP.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.duP.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.duP.gHA;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.duP.gHd;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.duP.gHB;
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)this.duP.ao(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            ((WXMusicObject)localObject1).songAlbumUrl = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songAlbumUrl;
            ((WXMusicObject)localObject1).songLyric = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songLyric;
          }
        }
        else if (this.duP.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.duP.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.duP.gHB;
        }
        else if (this.duP.type == 5)
        {
          localObject1 = new WXWebpageObject(this.duP.url);
        }
        else
        {
          if (this.duP.type == 6)
          {
            localObject3 = ap.bxS().aAL(this.duP.dbA);
            if (localObject3 != null)
            {
              ad.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              this.fyk = this.duP.gHf;
            }
            while (r.aAZ(this.filePath) != null)
            {
              com.tencent.mm.ui.base.h.cf(this, getString(2131757303));
              finish();
              break label403;
              ad.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.duP.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = com.tencent.mm.aw.o.ayF().I(this.nLz);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = com.tencent.mm.aw.o.ayF().yg(((e)localObject2).hgj);
              if (bt.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = com.tencent.mm.aw.o.ayF().yg(((e)localObject2).hgl);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.fyk = this.duP.gHf;
            ad.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.nLz.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = com.tencent.mm.aw.o.ayF().I(this.nLz);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = com.tencent.mm.aw.o.ayF().yg(((e)localObject2).hgj);
              if (bt.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = com.tencent.mm.aw.o.ayF().yg(((e)localObject2).hgl);
              }
              if (!bt.isNullOrNil(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.fyk = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            ad.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            az.arV();
            localObject1 = com.tencent.mm.model.c.apO().agD(this.nLz.field_content);
            localObject1 = new WXLocationObject(((bl.b)localObject1).sOv, ((bl.b)localObject1).sOw);
            continue;
            localObject2 = new WXVideoObject();
            com.tencent.mm.modelvideo.o.aCI();
            localObject3 = t.zQ(this.nLz.field_imgPath);
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
                  this.fyk = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void eVM()
  {
    AppMethodBeat.i(34666);
    Object localObject1 = new dv();
    Object localObject2;
    int i;
    if (this.dhf)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      ((dv)localObject1).dge.dgg = this.oVb;
      ((dv)localObject1).dge.dgh = ((String)localObject2);
      ((dv)localObject1).dge.dgi = str;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!((dv)localObject1).dgf.dfO) {
        break label435;
      }
      localObject1 = ((dv)localObject1).dgf.dgj;
      int j = ((List)localObject1).size();
      i = 0;
      label115:
      if (i >= j) {
        break label372;
      }
      localObject2 = new c();
      ((c)localObject2).dfF = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((c)localObject2).fyo = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((c)localObject2).dhe = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((c)localObject2).Gpw = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.dhf) || (!a((c)localObject2, this.oVb))) {
        break label338;
      }
      this.GoW.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label115;
      ((dv)localObject1).dge.msgId = this.fll;
      break;
      label338:
      if ((!this.dhf) && (a((c)localObject2, this.fll))) {
        this.GoW.add(localObject2);
      }
    }
    label372:
    if (this.GoW.size() > 0)
    {
      ad.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.GoO.ad(this.GoW);
      if (this.GoO.getCount() > 0)
      {
        this.GoT.setText(2131757132);
        this.GoZ = false;
      }
      this.GoO.notifyDataSetChanged();
    }
    label435:
    AppMethodBeat.o(34666);
  }
  
  private static String wv(long paramLong)
  {
    AppMethodBeat.i(34663);
    String str2 = "";
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().rm(paramLong);
    if (((du)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(34663);
      return "";
    }
    String str3 = ((du)localObject).field_content;
    String str1 = str2;
    if (((bl)localObject).getType() == 49)
    {
      localObject = k.b.rx(str3);
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((k.b)localObject).type == 6) {
          str1 = ((k.b)localObject).gHf;
        }
      }
    }
    AppMethodBeat.o(34663);
    return str1;
  }
  
  public final void aKz(final String paramString)
  {
    AppMethodBeat.i(34670);
    try
    {
      final int i = ((Integer)this.Gph.get(paramString)).intValue();
      final aq localaq = (aq)((View)this.Gpg.get(Integer.valueOf(i))).getTag();
      ad.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(localaq.Grl.getProgress()), paramString });
      final c localc = (c)this.Gpf.get(paramString);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34643);
          localaq.Grl.setVisibility(0);
          localaq.Gpr.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
          localaq.Gpr.setText(ChattingSendDataToDeviceUI.this.getText(2131757314));
          localc.dhj = "send_data_sending";
          AppMethodBeat.o(34643);
        }
      });
      final int j = Math.abs(localaq.Grl.getProgress());
      localc.progress = j;
      if (j >= 100) {}
      for (i = 0;; i = 500 / (100 - j))
      {
        ad.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
        com.tencent.e.h.Iye.aS(new com.tencent.e.i.h()
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
                    ChattingSendDataToDeviceUI.10.this.Gpm.Grl.YC(0);
                    ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(ChattingSendDataToDeviceUI.10.this.BfZ);
                    ChattingSendDataToDeviceUI.10.this.Gpm.Grl.setVisibility(4);
                    ChattingSendDataToDeviceUI.10.this.Gpm.Gpr.setText(ChattingSendDataToDeviceUI.this.getText(2131757312));
                    ChattingSendDataToDeviceUI.10.this.Gpm.Gpr.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
                    ChattingSendDataToDeviceUI.10.this.Gpn.dhj = "send_data_sucess";
                    ChattingSendDataToDeviceUI.10.this.Gpn.progress = 0;
                    ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 4);
                    AppMethodBeat.o(34644);
                  }
                });
                AppMethodBeat.o(34645);
                return;
              }
              catch (Exception localException)
              {
                ad.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              localaq.Grl.YC(i);
              i += 1;
              j = i;
              Thread.sleep(i);
            }
          }
        });
        this.Gpf.put(localc.deviceID, localc);
        AppMethodBeat.o(34670);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[] { paramString });
      AppMethodBeat.o(34670);
    }
  }
  
  public final b eVN()
  {
    AppMethodBeat.i(34676);
    if (this.GoV == null) {
      this.GoV = new b();
    }
    b localb = this.GoV;
    AppMethodBeat.o(34676);
    return localb;
  }
  
  public int getLayoutId()
  {
    return 2131493519;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34674);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131758111, 2131758112, 1);
    AppMethodBeat.o(34674);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(34669);
    if (this.Gpe.size() > 0)
    {
      com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
      locala.aay(2131757306);
      locala.aaB(2131757308).b(new ChattingSendDataToDeviceUI.7(this));
      locala.aaC(2131757307).c(new ChattingSendDataToDeviceUI.8(this));
      locala.fft().show();
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
    paramConfiguration = new dv();
    if (this.dhf)
    {
      String str1 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      paramConfiguration.dge.dgg = this.oVb;
      paramConfiguration.dge.dgh = str1;
      paramConfiguration.dge.dgi = str2;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ESL.l(paramConfiguration);
      if ((paramConfiguration.dgf.dfO) && (this.GoW.size() > 0))
      {
        ad.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.GoW.size()) });
        this.GoO.ad(this.GoW);
        if (this.GoO.getCount() > 0)
        {
          this.GoT.setText(2131757132);
          this.GoZ = false;
        }
        this.GoO.notifyDataSetChanged();
      }
      AppMethodBeat.o(34664);
      return;
      paramConfiguration.dge.msgId = this.fll;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    AppMethodBeat.i(34661);
    super.onCreate(paramBundle);
    this.dhf = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    ad.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.dhf);
    if (!this.dhf)
    {
      this.fll = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.fll != -1L)
      {
        az.arV();
        this.nLz = com.tencent.mm.model.c.apO().rm(this.fll);
        if ((this.nLz != null) && (this.nLz.field_msgId != 0L)) {
          break label560;
        }
      }
    }
    this.Gpc = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.Gpa = false;
    setFinishOnTouchOutside(true);
    this.GoW.clear();
    this.Gpf.clear();
    this.GoR = ((RelativeLayout)findViewById(2131302850));
    paramBundle = new dx();
    label258:
    Object localObject;
    if (this.dhf)
    {
      this.oVb = getIntent().getExtras().getString("sns_local_id");
      if (this.oVb != null)
      {
        paramBundle.dgp.dgg = this.oVb;
        ad.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.oVb });
      }
      com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
      if (!paramBundle.dgq.dfO) {
        break label1259;
      }
      this.GoU = Boolean.TRUE;
      com.tencent.mm.sdk.b.a.ESL.c(this.Gpi);
      com.tencent.mm.sdk.b.a.ESL.c(this.Gpj);
      this.GoR.setVisibility(0);
      this.GoL = ((HorizontalListView)findViewById(2131301457));
      this.GoT = ((TextView)findViewById(2131296995));
      this.GoT.setText(2131757294);
      this.GoO = new a(this);
      this.GoL.setAdapter(this.GoO);
      this.GoL.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34637);
          ChattingSendDataToDeviceUI.this.Gpa = true;
          ChattingSendDataToDeviceUI.c localc = ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).Yy(paramAnonymousInt);
          String str1 = localc.dfF;
          paramAnonymousAdapterView = localc.deviceID;
          String str2 = localc.dhe;
          try
          {
            if (ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).get(paramAnonymousAdapterView) != null)
            {
              ad.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
              paramAnonymousView = new dk();
              paramAnonymousView.dfB.cLR = paramAnonymousAdapterView;
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", paramAnonymousAdapterView, 0);
              localc.dhj = "send_data_cancel";
              ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(paramAnonymousAdapterView);
              paramAnonymousAdapterView = (aq)((View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramAnonymousInt))).getTag();
              paramAnonymousAdapterView.Gpr.setText(ChattingSendDataToDeviceUI.this.getText(2131757305));
              paramAnonymousAdapterView.Gpr.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100852));
              paramAnonymousAdapterView.Grl.setVisibility(8);
              paramAnonymousAdapterView.Grl.YC(0);
              AppMethodBeat.o(34637);
              return;
            }
            localc.dhj = "send_data_sending";
            ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(localc.deviceID, localc);
            ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).put(paramAnonymousAdapterView, paramAnonymousView);
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", paramAnonymousAdapterView, 1);
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
            paramAnonymousView = new eq();
            paramAnonymousView.dhc.cLR = paramAnonymousAdapterView;
            paramAnonymousView.dhc.dfF = str1;
            paramAnonymousView.dhc.data = ChattingSendDataToDeviceUI.e(ChattingSendDataToDeviceUI.this);
            paramAnonymousView.dhc.dhe = str2;
            if (ChattingSendDataToDeviceUI.this.dhf)
            {
              paramAnonymousView.dhc.dgg = ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.dhc.dhf = ChattingSendDataToDeviceUI.this.dhf;
            }
            for (;;)
            {
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
              if (!paramAnonymousView.dhd.dhg)
              {
                ChattingSendDataToDeviceUI.aKA("send_data_failed");
                ad.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
              }
              AppMethodBeat.o(34637);
              return;
              paramAnonymousView.dhc.msgId = ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this);
            }
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            ChattingSendDataToDeviceUI.aKA("send_data_failed");
            ad.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAnonymousAdapterView });
            AppMethodBeat.o(34637);
          }
        }
      });
      eVM();
      if (!this.dhf) {
        break label1069;
      }
      paramBundle = this.oVb;
      if (paramBundle == null) {
        break label1064;
      }
      localObject = new ja();
      ((ja)localObject).dmY.dgg = paramBundle;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      i = ((ja)localObject).dmZ.dna.Etm.DaB;
      if (i != 1) {
        break label1032;
      }
      i = 3;
      label459:
      this.Gpd = i;
      Bf(1);
    }
    for (;;)
    {
      this.GoS = ((RelativeLayout)findViewById(2131296910));
      this.GoM = ((HorizontalListView)findViewById(2131296858));
      this.GoN = new b(this);
      this.GoM.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34639);
          ad.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)
          {
            paramAnonymousView = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(ChattingSendDataToDeviceUI.this));
            paramAnonymousAdapterView = ChattingSendDataToDeviceUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(34639);
            return;
          }
          if ((ChattingSendDataToDeviceUI.this.Gkw) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 2))
          {
            if ((ChattingSendDataToDeviceUI.this.filePath == null) || (ChattingSendDataToDeviceUI.this.fyk == null))
            {
              com.tencent.mm.ui.base.h.cf(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(2131758111));
              AppMethodBeat.o(34639);
              return;
            }
            com.tencent.mm.pluginsdk.ui.tools.a.b(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.fyk.toLowerCase(), 1);
            AppMethodBeat.o(34639);
            return;
          }
          if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.getAdapter().getCount() - 1))
          {
            paramAnonymousAdapterView = (com.tencent.mm.pluginsdk.model.app.g)ChattingSendDataToDeviceUI.i(ChattingSendDataToDeviceUI.this).get(paramAnonymousInt);
            if (!com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView))
            {
              com.tencent.mm.ui.base.h.cf(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(2131757304));
              paramAnonymousAdapterView.field_status = 4;
              ap.cZQ().a(paramAnonymousAdapterView, new String[0]);
              ChattingSendDataToDeviceUI.j(ChattingSendDataToDeviceUI.this);
              AppMethodBeat.o(34639);
              return;
            }
            com.tencent.mm.cj.a.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(34638);
                com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView.field_packageName, ChattingSendDataToDeviceUI.this.mLk, paramAnonymousAdapterView.field_appId, paramAnonymousAdapterView.field_openId, 0, null, null);
                AppMethodBeat.o(34638);
              }
            });
          }
          AppMethodBeat.o(34639);
        }
      });
      this.GoM.setAdapter(this.GoN);
      findViewById(2131303967).setOnClickListener(new ChattingSendDataToDeviceUI.1(this));
      AppMethodBeat.o(34661);
      return;
      label560:
      this.GoP = this.nLz.getType();
      this.GjM = w.pF(this.nLz.field_talker);
      this.GoQ = this.nLz.field_content;
      int j;
      if ((this.GjM) && (this.nLz.field_isSend == 0))
      {
        localObject = this.nLz.field_content;
        j = this.nLz.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.GjM)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = bi.ug((String)localObject);
            }
          }
        }
        this.GoQ = paramBundle;
      }
      if (this.nLz.getType() == 49)
      {
        this.duP = k.b.rx(this.GoQ);
        if (this.duP == null)
        {
          ad.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.duP.type == 3) {
          this.GoY = 16L;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.GoY) });
        break;
        if (this.duP.type == 4)
        {
          this.GoY = 8L;
        }
        else if (this.duP.type == 5)
        {
          this.GoY = 32L;
        }
        else
        {
          if (this.duP.type == 6)
          {
            paramBundle = com.tencent.mm.pluginsdk.d.a.aAn(this.duP.gHf);
            if (paramBundle == null)
            {
              ad.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.GoY = paramBundle.longValue();
            continue;
          }
          if (this.duP.type == 2)
          {
            this.GoY = 2L;
            paramBundle = com.tencent.mm.aw.o.ayF().I(this.nLz);
            if (paramBundle != null) {
              this.GoQ = paramBundle.hgv;
            }
          }
          else
          {
            ad.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.nLz.getType() == 3)
            {
              paramBundle = com.tencent.mm.aw.o.ayF().I(this.nLz);
              if (paramBundle != null) {
                this.GoQ = paramBundle.hgv;
              }
            }
            for (;;)
            {
              paramBundle = com.tencent.mm.pluginsdk.d.a.aAn(this.GoP);
              if (paramBundle != null) {
                break label1007;
              }
              ad.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.nLz.getType() == 43)
              {
                paramBundle = com.tencent.mm.modelvideo.o.aCI().zO(this.nLz.field_imgPath);
                if (paramBundle != null) {
                  this.GoQ = paramBundle.aCT();
                }
              }
            }
            label1007:
            this.GoY = paramBundle.longValue();
          }
        }
      }
      paramBundle.dgp.msgId = this.fll;
      break label258;
      label1032:
      if (i == 4)
      {
        i = 1;
        break label459;
      }
      if (i == 15)
      {
        i = 6;
        break label459;
      }
      if (i == 3)
      {
        i = 5;
        break label459;
      }
      label1064:
      i = 0;
      break label459;
      label1069:
      long l = this.fll;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      for (;;)
      {
        this.Gpd = i;
        break;
        az.arV();
        paramBundle = com.tencent.mm.model.c.apO().rm(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (!paramBundle.cxB()) {
            break label1229;
          }
          paramBundle = k.b.rx((String)localObject);
          if (paramBundle != null) {
            break label1168;
          }
          ad.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        }
        label1168:
        label1229:
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
      label1259:
      this.GoR.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34675);
    super.onDestroy();
    ad.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.Gpb = false;
    if (this.GoU.booleanValue())
    {
      if (!this.Gpa) {
        Bf(2);
      }
      com.tencent.mm.sdk.b.a.ESL.d(this.Gpi);
      com.tencent.mm.sdk.b.a.ESL.d(this.Gpj);
      fd localfd = new fd();
      com.tencent.mm.sdk.b.a.ESL.l(localfd);
      if (localfd.dhD.dhg) {
        ad.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
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
    eVL();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.GoU.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.GoL.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.cd.a.dT(this);
      if (f != com.tencent.mm.cd.a.hG(this)) {
        break label85;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165490));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165516))) {
      label85:
      do
      {
        this.GoL.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(34672);
        return;
      } while ((f != com.tencent.mm.cd.a.hI(this)) && (f != com.tencent.mm.cd.a.hH(this)) && (f != com.tencent.mm.cd.a.hJ(this)));
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
    private List<Map<String, ChattingSendDataToDeviceUI.c>> Gkv;
    private Map<String, ChattingSendDataToDeviceUI.c> Gps;
    private Context context;
    private com.tencent.mm.aw.a.a.c paS;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(34650);
      this.context = paramContext;
      this.Gkv = new ArrayList();
      this$1 = new c.a();
      ChattingSendDataToDeviceUI.this.hkf = 2131233401;
      this.paS = ChattingSendDataToDeviceUI.this.azc();
      AppMethodBeat.o(34650);
    }
    
    public final ChattingSendDataToDeviceUI.c Yy(int paramInt)
    {
      AppMethodBeat.i(34653);
      ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((Map)this.Gkv.get(paramInt)).get("hard_device_info");
      AppMethodBeat.o(34653);
      return localc;
    }
    
    public final void ad(List<ChattingSendDataToDeviceUI.c> paramList)
    {
      AppMethodBeat.i(34651);
      this.Gkv.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.Gps = new HashMap();
        this.Gps.put("hard_device_info", paramList.get(i));
        this.Gkv.add(this.Gps);
        i += 1;
      }
      AppMethodBeat.o(34651);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34652);
      int i = this.Gkv.size();
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
      ChattingSendDataToDeviceUI.c localc = Yy(paramInt);
      ad.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
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
        paramView = new aq();
        paramViewGroup = View.inflate(paramViewGroup.getContext(), 2131495368, null);
        paramView.pdS = paramViewGroup.findViewById(2131298736);
        paramView.imt = ((TextView)paramViewGroup.findViewById(2131302656));
        paramView.kXS = ((ImageView)paramViewGroup.findViewById(2131300880));
        paramView.Gpr = ((TextView)paramViewGroup.findViewById(2131304561));
        paramView.Grl = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(2131304560));
        paramView.Grl.setVisibility(4);
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localc.deviceID, Integer.valueOf(paramInt));
        String str1 = localc.fyo;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.cd.a.dT(this.context);
        if ((f != com.tencent.mm.cd.a.hG(this.context)) && (f != com.tencent.mm.cd.a.hH(this.context))) {
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
        paramView = (aq)paramViewGroup.getTag();
        break;
        label374:
        if ((f != com.tencent.mm.cd.a.hI(this.context)) && (f != com.tencent.mm.cd.a.hJ(this.context))) {
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
      paramView.imt.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.Gpr.setText(localStringBuffer);
      }
      Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(Yy(paramInt).deviceID)) {
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(Yy(paramInt).deviceID);
      }
      if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).dhj != null))
      {
        ad.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).dhj });
        if (!((ChattingSendDataToDeviceUI.c)localObject).dhj.equals("send_data_sending")) {
          break label756;
        }
        paramView.Gpr.setText(this.context.getString(2131757314));
        paramView.Gpr.setTextColor(this.context.getResources().getColor(2131100854));
        paramView.Grl.YC(localc.progress);
        paramView.Grl.setVisibility(0);
        localObject = localc.deviceID;
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
        if (j < 100) {
          break label742;
        }
        i = 0;
        com.tencent.e.h.Iye.aS(new com.tencent.e.i.h()
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
            while (ChattingSendDataToDeviceUI.this.Gpb)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                if (this.Gpn.dhj.equals("send_data_sucess"))
                {
                  j = i;
                  ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(34647);
                      ChattingSendDataToDeviceUI.a.1.this.Gpm.Grl.YC(0);
                      ChattingSendDataToDeviceUI.a.1.this.Gpm.Grl.setVisibility(4);
                      ChattingSendDataToDeviceUI.a.1.this.Gpm.Gpr.setText(ChattingSendDataToDeviceUI.this.getText(2131757312));
                      ChattingSendDataToDeviceUI.a.1.this.Gpm.Gpr.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
                      ChattingSendDataToDeviceUI.a.1.this.Gpn.dhj = "send_data_sucess";
                      ChattingSendDataToDeviceUI.a.1.this.Gpn.progress = 0;
                      ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.Gpn.deviceID, ChattingSendDataToDeviceUI.a.1.this.Gpn);
                      ad.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.Gpn.deviceID });
                      AppMethodBeat.o(34647);
                    }
                  });
                  AppMethodBeat.o(34649);
                  return;
                }
                j = i;
                if (!this.Gpn.dhj.equals("send_data_failed")) {
                  continue;
                }
                j = i;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34648);
                    ChattingSendDataToDeviceUI.a.1.this.Gpm.Grl.YC(0);
                    ChattingSendDataToDeviceUI.a.1.this.Gpm.Grl.setVisibility(4);
                    ChattingSendDataToDeviceUI.a.1.this.Gpm.Gpr.setText(ChattingSendDataToDeviceUI.this.getText(2131757309));
                    ChattingSendDataToDeviceUI.a.1.this.Gpm.Gpr.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100857));
                    ChattingSendDataToDeviceUI.a.1.this.Gpn.dhj = "send_data_failed";
                    ChattingSendDataToDeviceUI.a.1.this.Gpn.progress = 0;
                    ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.Gpn.deviceID, ChattingSendDataToDeviceUI.a.1.this.Gpn);
                    ad.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.Gpn.deviceID });
                    AppMethodBeat.o(34648);
                  }
                });
                AppMethodBeat.o(34649);
                return;
              }
              catch (Exception localException)
              {
                ad.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              paramView.Grl.YC(i);
              j = i;
              this.Gpn.progress = i;
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
        ad.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.fyo });
        com.tencent.mm.aw.o.ayJ().a(localc.iconUrl, paramView.kXS, this.paS);
        paramView.pdS.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(34654);
        return paramViewGroup;
        label742:
        i = 500 / (100 - j);
        break;
        label756:
        if (((ChattingSendDataToDeviceUI.c)localObject).dhj.equals("send_data_sucess"))
        {
          paramView.Gpr.setText(this.context.getString(2131757312));
          paramView.Gpr.setTextColor(this.context.getResources().getColor(2131100854));
          paramView.Grl.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).dhj.equals("send_data_cancel"))
        {
          paramView.Gpr.setText(this.context.getString(2131757305));
          paramView.Gpr.setTextColor(this.context.getResources().getColor(2131100852));
          paramView.Grl.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).dhj.equals("send_data_failed"))
        {
          paramView.Gpr.setText(this.context.getString(2131757309));
          paramView.Gpr.setTextColor(this.context.getResources().getColor(2131100857));
          paramView.Grl.setVisibility(4);
        }
      }
    }
  }
  
  public final class b
  {
    public b() {}
    
    private boolean n(com.tencent.mm.sdk.b.b paramb)
    {
      AppMethodBeat.i(34658);
      paramb = (er)paramb;
      String str1 = paramb.dhh.dhj;
      String str2 = paramb.dhh.cLR;
      if (str1.equals("send_data_sending")) {
        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, paramb.dhh.progress);
      }
      for (;;)
      {
        AppMethodBeat.o(34658);
        return true;
        if (str1.equals("send_data_failed")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
        } else if (str1.equals("send_data_sucess")) {
          ChattingSendDataToDeviceUI.this.aKz(str2);
        }
      }
    }
    
    private boolean o(com.tencent.mm.sdk.b.b paramb)
    {
      AppMethodBeat.i(34659);
      paramb = ((en)paramb).dgW.dgj;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramb.size())
      {
        ChattingSendDataToDeviceUI.c localc = new ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this);
        localc.dfF = ((String)((Map)paramb.get(i)).get("deviceType"));
        localc.deviceID = ((String)((Map)paramb.get(i)).get("deviceID"));
        localc.fyo = ((String)((Map)paramb.get(i)).get("displayName"));
        localc.iconUrl = ((String)((Map)paramb.get(i)).get("iconUrl"));
        localc.dhe = ((String)((Map)paramb.get(i)).get("ability"));
        localc.Gpw = ((String)((Map)paramb.get(i)).get("abilityInf"));
        if (((ChattingSendDataToDeviceUI.this.dhf) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this)))) || ((!ChattingSendDataToDeviceUI.this.dhf) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this)))))
        {
          if ((ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(localc.deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).dhj != null))
          {
            localc.dhj = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).dhj;
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
              ChattingSendDataToDeviceUI.m(ChattingSendDataToDeviceUI.this).setText(2131757132);
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
    
    public final boolean m(com.tencent.mm.sdk.b.b paramb)
    {
      AppMethodBeat.i(34657);
      boolean bool;
      if ((paramb instanceof en))
      {
        bool = o(paramb);
        AppMethodBeat.o(34657);
        return bool;
      }
      if ((paramb instanceof er))
      {
        bool = n(paramb);
        AppMethodBeat.o(34657);
        return bool;
      }
      AppMethodBeat.o(34657);
      return true;
    }
  }
  
  public final class c
  {
    String Gpw;
    String deviceID;
    String dfF;
    String dhe;
    String dhj;
    String fyo;
    String iconUrl;
    int progress;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */