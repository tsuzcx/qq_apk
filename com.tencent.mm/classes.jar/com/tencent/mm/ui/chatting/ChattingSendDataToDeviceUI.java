package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.e;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.dp.b;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.g.a.ex.a;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.ie.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLocationObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
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
  private j.b cEn;
  boolean csj;
  private long eaY;
  String elt;
  String filePath;
  WXMediaMessage jMk;
  private bi kEz;
  private String lEp;
  private HorizontalListView vZg;
  private ChattingSendDataToDeviceUI.a zAA;
  private int zAB;
  private String zAC;
  private RelativeLayout zAD;
  private RelativeLayout zAE;
  private TextView zAF;
  private Boolean zAG;
  private ChattingSendDataToDeviceUI.b zAH;
  private List<ChattingSendDataToDeviceUI.c> zAI;
  private List<f> zAJ;
  private long zAK;
  private boolean zAL;
  boolean zAM;
  boolean zAN;
  int zAO;
  int zAP;
  private HashMap<String, View> zAQ;
  private HashMap<String, ChattingSendDataToDeviceUI.c> zAR;
  private Map<Integer, View> zAS;
  private Map<String, Integer> zAT;
  private com.tencent.mm.sdk.b.c zAU;
  private com.tencent.mm.sdk.b.c zAV;
  private HorizontalListView zAy;
  private b zAz;
  private boolean zvB;
  boolean zwj;
  
  public ChattingSendDataToDeviceUI()
  {
    AppMethodBeat.i(30787);
    this.zAC = "";
    this.zAG = Boolean.FALSE;
    this.zAI = new ArrayList();
    this.zAJ = new ArrayList();
    this.zAK = 0L;
    this.zAL = true;
    this.csj = false;
    this.zAM = false;
    this.zAN = true;
    this.zAO = 2;
    this.zAP = -1;
    this.zAQ = new HashMap();
    this.zAR = new HashMap();
    this.zAS = new HashMap();
    this.zAT = new HashMap();
    this.jMk = null;
    this.filePath = null;
    this.elt = null;
    this.zwj = false;
    this.zAU = new ChattingSendDataToDeviceUI.10(this);
    this.zAV = new ChattingSendDataToDeviceUI.2(this);
    AppMethodBeat.o(30787);
  }
  
  private static boolean a(ChattingSendDataToDeviceUI.c paramc, long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(30798);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(30798);
      return false;
    }
    String str1 = paramc.csi;
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().kB(paramLong);
    if ((((dd)localObject).field_msgId == 0L) || (str1 == null))
    {
      AppMethodBeat.o(30798);
      return false;
    }
    int i = ((bi)localObject).getType();
    String str2 = ((dd)localObject).field_content;
    if (((bi)localObject).bCn())
    {
      localObject = j.b.mY(str2);
      if (localObject == null)
      {
        ab.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        AppMethodBeat.o(30798);
        return false;
      }
      if (((j.b)localObject).type == 3) {
        if (!str1.contains("wxmsg_music")) {
          break label183;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30798);
      return bool;
      if (((j.b)localObject).type == 4) {
        bool = false;
      } else {
        label274:
        if (((j.b)localObject).type == 6)
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
                  if (((j.b)localObject).type == 5)
                  {
                    bool = a(((j.b)localObject).url, paramc);
                    break;
                  }
                } while ((((j.b)localObject).type != 2) || (!str1.contains("wxmsg_image")));
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
  
  private static boolean a(ChattingSendDataToDeviceUI.c paramc, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(30795);
    if (paramString == null)
    {
      AppMethodBeat.o(30795);
      return false;
    }
    Object localObject = new ie();
    ((ie)localObject).cxt.crk = paramString;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    paramString = ((ie)localObject).cxu.cxv;
    int i = paramString.xTS.wNZ;
    ab.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.csi;
    if (localObject == null)
    {
      ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
      AppMethodBeat.o(30795);
      return false;
    }
    if (i == 1) {
      if (!((String)localObject).contains("wxmsg_image")) {
        break label150;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30795);
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
        bool = a(paramString.xTS.Url, paramc);
      }
    }
  }
  
  private static boolean a(String paramString, ChattingSendDataToDeviceUI.c paramc)
  {
    bool2 = false;
    AppMethodBeat.i(30794);
    Object localObject = paramc.csi;
    paramc = paramc.zBi;
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
        ab.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", paramString, paramc, new Object[0]);
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(30794);
      return bool1;
      i += 1;
    }
  }
  
  private void dGF()
  {
    AppMethodBeat.i(30792);
    if ((this.zAz == null) || (this.zAK == 0L))
    {
      if (this.zAz == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.zAK) });
        if (this.zAE != null) {
          this.zAE.setVisibility(8);
        }
        AppMethodBeat.o(30792);
        return;
      }
    }
    this.zAJ = com.tencent.mm.pluginsdk.model.app.g.b(this, this.zAK, false);
    if ((!com.tencent.mm.pluginsdk.model.app.g.o(this, this.zAK)) && (this.zAE != null)) {
      this.zAE.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.zAJ != null) && (this.zAJ.size() > 0))
    {
      localObject1 = al.dlM().ny(this.zAK);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.zAJ, new ChattingSendDataToDeviceUI.4(this, (List)localObject1));
      }
      localObject1 = this.zAJ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        localObject3 = new y();
        ((y)localObject3).appId = ((f)localObject2).field_appId;
        ((y)localObject3).elx = ((f)localObject2).field_appName;
        ((y)localObject3).iconUrl = ((f)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.jMk == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.kEz.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.jMk = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.jMk.sdkVer = 620954624;
      if ((this.elt != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.zwj = true;
      }
      label403:
      this.zAz.zwj = this.zwj;
      this.zAz.bt(localArrayList);
      this.zAz.notifyDataSetChanged();
      AppMethodBeat.o(30792);
      return;
      localObject1 = localObject3;
      if (this.cEn != null) {
        if (this.cEn.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.cEn.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.cEn.fgU;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.cEn.fgv;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.cEn.fgV;
        }
        else if (this.cEn.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.cEn.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.cEn.fgV;
        }
        else if (this.cEn.type == 5)
        {
          localObject1 = new WXWebpageObject(this.cEn.url);
        }
        else
        {
          if (this.cEn.type == 6)
          {
            localObject3 = al.aUJ().alo(this.cEn.cmN);
            if (localObject3 != null)
            {
              ab.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath;
              this.elt = this.cEn.fgx;
            }
            while (q.alz(this.filePath) != null)
            {
              com.tencent.mm.ui.base.h.bO(this, getString(2131298312));
              finish();
              break label403;
              ab.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.cEn.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = com.tencent.mm.at.o.ahC().w(this.kEz);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = com.tencent.mm.at.o.ahC().te(((e)localObject2).fDM);
              if (bo.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = com.tencent.mm.at.o.ahC().te(((e)localObject2).fDO);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.elt = this.cEn.fgx;
            ab.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.kEz.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = com.tencent.mm.at.o.ahC().w(this.kEz);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = com.tencent.mm.at.o.ahC().te(((e)localObject2).fDM);
              if (bo.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = com.tencent.mm.at.o.ahC().te(((e)localObject2).fDO);
              }
              if (!bo.isNullOrNil(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.elt = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            ab.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            aw.aaz();
            localObject1 = com.tencent.mm.model.c.YC().Tz(this.kEz.field_content);
            localObject1 = new WXLocationObject(((bi.b)localObject1).nZV, ((bi.b)localObject1).nZW);
            continue;
            localObject2 = new WXVideoObject();
            com.tencent.mm.modelvideo.o.alE();
            localObject3 = com.tencent.mm.modelvideo.t.vf(this.kEz.field_imgPath);
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
                  this.elt = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void dGG()
  {
    AppMethodBeat.i(30793);
    Object localObject1 = new dp();
    Object localObject2;
    int i;
    if (this.csj)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
      ((dp)localObject1).cri.crk = this.lEp;
      ((dp)localObject1).cri.crl = ((String)localObject2);
      ((dp)localObject1).cri.crm = i;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!((dp)localObject1).crj.cqS) {
        break label433;
      }
      localObject1 = ((dp)localObject1).crj.crn;
      int j = ((List)localObject1).size();
      i = 0;
      label113:
      if (i >= j) {
        break label370;
      }
      localObject2 = new ChattingSendDataToDeviceUI.c(this);
      ((ChattingSendDataToDeviceUI.c)localObject2).cqJ = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((ChattingSendDataToDeviceUI.c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((ChattingSendDataToDeviceUI.c)localObject2).elx = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((ChattingSendDataToDeviceUI.c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((ChattingSendDataToDeviceUI.c)localObject2).csi = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((ChattingSendDataToDeviceUI.c)localObject2).zBi = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.csj) || (!a((ChattingSendDataToDeviceUI.c)localObject2, this.lEp))) {
        break label336;
      }
      this.zAI.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label113;
      ((dp)localObject1).cri.cpO = this.eaY;
      break;
      label336:
      if ((!this.csj) && (a((ChattingSendDataToDeviceUI.c)localObject2, this.eaY))) {
        this.zAI.add(localObject2);
      }
    }
    label370:
    if (this.zAI.size() > 0)
    {
      ab.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.zAA.bt(this.zAI);
      if (this.zAA.getCount() > 0)
      {
        this.zAF.setText(2131298143);
        this.zAL = false;
      }
      this.zAA.notifyDataSetChanged();
    }
    label433:
    AppMethodBeat.o(30793);
  }
  
  private static String ox(long paramLong)
  {
    AppMethodBeat.i(30790);
    String str2 = "";
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().kB(paramLong);
    if (((dd)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(30790);
      return "";
    }
    String str3 = ((dd)localObject).field_content;
    String str1 = str2;
    if (((bi)localObject).getType() == 49)
    {
      localObject = j.b.mY(str3);
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((j.b)localObject).type == 6) {
          str1 = ((j.b)localObject).fgx;
        }
      }
    }
    AppMethodBeat.o(30790);
    return str1;
  }
  
  private void vb(int paramInt)
  {
    AppMethodBeat.i(30789);
    if (this.csj)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zAP), "", Integer.valueOf(2), Integer.valueOf(this.zAO) });
      AppMethodBeat.o(30789);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zAP), ox(this.eaY), Integer.valueOf(1), Integer.valueOf(this.zAO) });
    AppMethodBeat.o(30789);
  }
  
  public final void atK(String paramString)
  {
    AppMethodBeat.i(30797);
    try
    {
      int i = ((Integer)this.zAT.get(paramString)).intValue();
      ap localap = (ap)((View)this.zAS.get(Integer.valueOf(i))).getTag();
      ab.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(localap.zCQ.getProgress()), paramString });
      ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)this.zAR.get(paramString);
      runOnUiThread(new ChattingSendDataToDeviceUI.7(this, localap, localc));
      int j = Math.abs(localap.zCQ.getProgress());
      localc.progress = j;
      if (j >= 100) {}
      for (i = 0;; i = 500 / (100 - j))
      {
        ab.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
        d.h(new ChattingSendDataToDeviceUI.8(this, j, localap, paramString, localc, i), "progressSuccess_handler").start();
        this.zAR.put(localc.deviceID, localc);
        AppMethodBeat.o(30797);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[] { paramString });
      AppMethodBeat.o(30797);
    }
  }
  
  public final ChattingSendDataToDeviceUI.b dGH()
  {
    AppMethodBeat.i(30803);
    if (this.zAH == null) {
      this.zAH = new ChattingSendDataToDeviceUI.b(this);
    }
    ChattingSendDataToDeviceUI.b localb = this.zAH;
    AppMethodBeat.o(30803);
    return localb;
  }
  
  public int getLayoutId()
  {
    return 2130969139;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(30801);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131299009, 2131299010, 1);
    AppMethodBeat.o(30801);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(30796);
    if (this.zAQ.size() > 0)
    {
      com.tencent.mm.ui.widget.b.c.a locala = new com.tencent.mm.ui.widget.b.c.a(this);
      locala.Rf(2131298315);
      locala.Ri(2131298317).a(new ChattingSendDataToDeviceUI.5(this));
      locala.Rj(2131298316).b(new ChattingSendDataToDeviceUI.6(this));
      locala.aLZ().show();
      AppMethodBeat.o(30796);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(30796);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(30791);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = new dp();
    if (this.csj)
    {
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
      paramConfiguration.cri.crk = this.lEp;
      paramConfiguration.cri.crl = str;
      paramConfiguration.cri.crm = i;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.l(paramConfiguration);
      if ((paramConfiguration.crj.cqS) && (this.zAI.size() > 0))
      {
        ab.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.zAI.size()) });
        this.zAA.bt(this.zAI);
        if (this.zAA.getCount() > 0)
        {
          this.zAF.setText(2131298143);
          this.zAL = false;
        }
        this.zAA.notifyDataSetChanged();
      }
      AppMethodBeat.o(30791);
      return;
      paramConfiguration.cri.cpO = this.eaY;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    AppMethodBeat.i(30788);
    super.onCreate(paramBundle);
    this.csj = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    ab.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.csj);
    if (!this.csj)
    {
      this.eaY = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.eaY != -1L)
      {
        aw.aaz();
        this.kEz = com.tencent.mm.model.c.YC().kB(this.eaY);
        if ((this.kEz != null) && (this.kEz.field_msgId != 0L)) {
          break label542;
        }
      }
    }
    this.zAO = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.zAM = false;
    setFinishOnTouchOutside(true);
    this.zAI.clear();
    this.zAR.clear();
    this.zAD = ((RelativeLayout)findViewById(2131822769));
    paramBundle = new dr();
    label258:
    Object localObject;
    if (this.csj)
    {
      this.lEp = getIntent().getExtras().getString("sns_local_id");
      if (this.lEp != null)
      {
        paramBundle.crt.crk = this.lEp;
        ab.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.lEp });
      }
      com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
      if (!paramBundle.cru.cqS) {
        break label1241;
      }
      this.zAG = Boolean.TRUE;
      com.tencent.mm.sdk.b.a.ymk.c(this.zAU);
      com.tencent.mm.sdk.b.a.ymk.c(this.zAV);
      this.zAD.setVisibility(0);
      this.vZg = ((HorizontalListView)findViewById(2131821736));
      this.zAF = ((TextView)findViewById(2131822770));
      this.zAF.setText(2131298303);
      this.zAA = new ChattingSendDataToDeviceUI.a(this, this);
      this.vZg.setAdapter(this.zAA);
      this.vZg.setOnItemClickListener(new ChattingSendDataToDeviceUI.1(this));
      dGG();
      if (!this.csj) {
        break label1051;
      }
      paramBundle = this.lEp;
      if (paramBundle == null) {
        break label1046;
      }
      localObject = new ie();
      ((ie)localObject).cxt.crk = paramBundle;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      i = ((ie)localObject).cxu.cxv.xTS.wNZ;
      if (i != 1) {
        break label1014;
      }
      i = 3;
      label459:
      this.zAP = i;
      vb(1);
    }
    for (;;)
    {
      this.zAE = ((RelativeLayout)findViewById(2131822774));
      this.zAy = ((HorizontalListView)findViewById(2131822776));
      this.zAz = new b(this);
      this.zAy.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(30764);
          ab.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)
          {
            paramAnonymousAdapterView = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
            paramAnonymousAdapterView.addFlags(67108864);
            paramAnonymousAdapterView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(ChattingSendDataToDeviceUI.this));
            ChattingSendDataToDeviceUI.this.startActivity(paramAnonymousAdapterView);
            AppMethodBeat.o(30764);
            return;
          }
          if ((ChattingSendDataToDeviceUI.this.zwj) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 2))
          {
            if ((ChattingSendDataToDeviceUI.this.filePath == null) || (ChattingSendDataToDeviceUI.this.elt == null))
            {
              com.tencent.mm.ui.base.h.bO(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(2131299009));
              AppMethodBeat.o(30764);
              return;
            }
            com.tencent.mm.pluginsdk.ui.tools.a.a(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.elt.toLowerCase(), 1);
            AppMethodBeat.o(30764);
            return;
          }
          if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.getAdapter().getCount() - 1))
          {
            paramAnonymousAdapterView = (f)ChattingSendDataToDeviceUI.i(ChattingSendDataToDeviceUI.this).get(paramAnonymousInt);
            if (!com.tencent.mm.pluginsdk.model.app.g.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView))
            {
              com.tencent.mm.ui.base.h.bO(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(2131298313));
              paramAnonymousAdapterView.field_status = 4;
              al.cac().a(paramAnonymousAdapterView, new String[0]);
              ChattingSendDataToDeviceUI.j(ChattingSendDataToDeviceUI.this);
              AppMethodBeat.o(30764);
              return;
            }
            com.tencent.mm.ch.a.post(new ChattingSendDataToDeviceUI.3.1(this, paramAnonymousAdapterView));
          }
          AppMethodBeat.o(30764);
        }
      });
      this.zAy.setAdapter(this.zAz);
      AppMethodBeat.o(30788);
      return;
      label542:
      this.zAB = this.kEz.getType();
      this.zvB = com.tencent.mm.model.t.lA(this.kEz.field_talker);
      this.zAC = this.kEz.field_content;
      int j;
      if ((this.zvB) && (this.kEz.field_isSend == 0))
      {
        localObject = this.kEz.field_content;
        j = this.kEz.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.zvB)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = bf.pv((String)localObject);
            }
          }
        }
        this.zAC = paramBundle;
      }
      if (this.kEz.getType() == 49)
      {
        this.cEn = j.b.mY(this.zAC);
        if (this.cEn == null)
        {
          ab.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.cEn.type == 3) {
          this.zAK = 16L;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.zAK) });
        break;
        if (this.cEn.type == 4)
        {
          this.zAK = 8L;
        }
        else if (this.cEn.type == 5)
        {
          this.zAK = 32L;
        }
        else
        {
          if (this.cEn.type == 6)
          {
            paramBundle = com.tencent.mm.pluginsdk.c.a.akT(this.cEn.fgx);
            if (paramBundle == null)
            {
              ab.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.zAK = paramBundle.longValue();
            continue;
          }
          if (this.cEn.type == 2)
          {
            this.zAK = 2L;
            paramBundle = com.tencent.mm.at.o.ahC().w(this.kEz);
            if (paramBundle != null) {
              this.zAC = paramBundle.fDX;
            }
          }
          else
          {
            ab.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.kEz.getType() == 3)
            {
              paramBundle = com.tencent.mm.at.o.ahC().w(this.kEz);
              if (paramBundle != null) {
                this.zAC = paramBundle.fDX;
              }
            }
            for (;;)
            {
              paramBundle = com.tencent.mm.pluginsdk.c.a.akT(this.zAB);
              if (paramBundle != null) {
                break label989;
              }
              ab.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.kEz.getType() == 43)
              {
                paramBundle = com.tencent.mm.modelvideo.o.alE().vd(this.kEz.field_imgPath);
                if (paramBundle != null) {
                  this.zAC = paramBundle.alP();
                }
              }
            }
            label989:
            this.zAK = paramBundle.longValue();
          }
        }
      }
      paramBundle.crt.cpO = this.eaY;
      break label258;
      label1014:
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
      label1046:
      i = 0;
      break label459;
      label1051:
      long l = this.eaY;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      label1211:
      for (;;)
      {
        this.zAP = i;
        break;
        aw.aaz();
        paramBundle = com.tencent.mm.model.c.YC().kB(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (!paramBundle.bCn()) {
            break label1211;
          }
          paramBundle = j.b.mY((String)localObject);
          if (paramBundle != null) {
            break label1150;
          }
          ab.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        }
        label1150:
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
      label1241:
      this.zAD.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30802);
    super.onDestroy();
    ab.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.zAN = false;
    if (this.zAG.booleanValue())
    {
      if (!this.zAM) {
        vb(2);
      }
      com.tencent.mm.sdk.b.a.ymk.d(this.zAU);
      com.tencent.mm.sdk.b.a.ymk.d(this.zAV);
      ex localex = new ex();
      com.tencent.mm.sdk.b.a.ymk.l(localex);
      if (localex.csH.csk) {
        ab.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
      }
    }
    AppMethodBeat.o(30802);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30800);
    super.onPause();
    AppMethodBeat.o(30800);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30799);
    super.onResume();
    dGF();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.zAG.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.vZg.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.cb.a.dr(this);
      if (f != com.tencent.mm.cb.a.gh(this)) {
        break label85;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131427782));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131427808))) {
      label85:
      do
      {
        this.vZg.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(30799);
        return;
      } while ((f != com.tencent.mm.cb.a.gj(this)) && (f != com.tencent.mm.cb.a.gi(this)) && (f != com.tencent.mm.cb.a.gk(this)));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */