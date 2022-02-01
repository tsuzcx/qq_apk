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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.dz.b;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.er.a;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.eu.b;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ev.a;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.fh.a;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.g.a.jp.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
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
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.b;
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
  private b JCA;
  private List<c> JCB;
  private List<com.tencent.mm.pluginsdk.model.app.g> JCC;
  private long JCD;
  private boolean JCE;
  boolean JCF;
  boolean JCG;
  int JCH;
  int JCI;
  private HashMap<String, View> JCJ;
  private HashMap<String, c> JCK;
  private Map<Integer, View> JCL;
  private Map<String, Integer> JCM;
  private com.tencent.mm.sdk.b.c JCN;
  private com.tencent.mm.sdk.b.c JCO;
  private HorizontalListView JCq;
  private HorizontalListView JCr;
  private b JCs;
  private a JCt;
  private int JCu;
  private String JCv;
  private RelativeLayout JCw;
  private RelativeLayout JCx;
  private TextView JCy;
  private Boolean JCz;
  private boolean Jxs;
  boolean Jyc;
  private k.b dEu;
  boolean dpW;
  private long fGN;
  String fVf;
  String filePath;
  WXMediaMessage nOg;
  private bu oRU;
  private String qbR;
  
  public ChattingSendDataToDeviceUI()
  {
    AppMethodBeat.i(34660);
    this.JCv = "";
    this.JCz = Boolean.FALSE;
    this.JCB = new ArrayList();
    this.JCC = new ArrayList();
    this.JCD = 0L;
    this.JCE = true;
    this.dpW = false;
    this.JCF = false;
    this.JCG = true;
    this.JCH = 2;
    this.JCI = -1;
    this.JCJ = new HashMap();
    this.JCK = new HashMap();
    this.JCL = new HashMap();
    this.JCM = new HashMap();
    this.nOg = null;
    this.filePath = null;
    this.fVf = null;
    this.Jyc = false;
    this.JCN = new com.tencent.mm.sdk.b.c() {};
    this.JCO = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(34660);
  }
  
  private void CG(int paramInt)
  {
    AppMethodBeat.i(34662);
    if (this.dpW)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.JCI), "", Integer.valueOf(2), Integer.valueOf(this.JCH) });
      AppMethodBeat.o(34662);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.JCI), DO(this.fGN), Integer.valueOf(1), Integer.valueOf(this.JCH) });
    AppMethodBeat.o(34662);
  }
  
  private static String DO(long paramLong)
  {
    AppMethodBeat.i(34663);
    String str2 = "";
    ba.aBQ();
    Object localObject = com.tencent.mm.model.c.azs().xY(paramLong);
    if (((ei)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(34663);
      return "";
    }
    String str3 = ((ei)localObject).field_content;
    String str1 = str2;
    if (((bu)localObject).getType() == 49)
    {
      localObject = k.b.yr(str3);
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((k.b)localObject).type == 6) {
          str1 = ((k.b)localObject).hzP;
        }
      }
    }
    AppMethodBeat.o(34663);
    return str1;
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
    String str1 = paramc.dpV;
    ba.aBQ();
    Object localObject = com.tencent.mm.model.c.azs().xY(paramLong);
    if ((((ei)localObject).field_msgId == 0L) || (str1 == null))
    {
      AppMethodBeat.o(34671);
      return false;
    }
    int i = ((bu)localObject).getType();
    String str2 = ((ei)localObject).field_content;
    if (((bu)localObject).cTc())
    {
      localObject = k.b.yr(str2);
      if (localObject == null)
      {
        ad.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        AppMethodBeat.o(34671);
        return false;
      }
      if (((k.b)localObject).type == 3) {
        if (!str1.contains("wxmsg_music")) {
          break label184;
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
        label275:
        if (((k.b)localObject).type == 6)
        {
          if (str1.contains("wxmsg_file")) {}
        }
        else {
          label184:
          label255:
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
                  break label255;
                }
              } while (!str1.contains("wxmsg_image"));
              break;
              if (i != 48) {
                break label275;
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
    Object localObject = new jp();
    ((jp)localObject).dwt.doX = paramString;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    paramString = ((jp)localObject).dwu.dwv;
    int i = paramString.HAT.GaP;
    ad.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.dpV;
    if (localObject == null)
    {
      ad.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
      AppMethodBeat.o(34668);
      return false;
    }
    if (i == 1) {
      if (!((String)localObject).contains("wxmsg_image")) {
        break label152;
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
        label152:
        label177:
        do
        {
          do
          {
            bool = false;
            break;
            if (i != 15) {
              break label177;
            }
          } while (!((String)localObject).contains("wxmsg_video"));
          break;
        } while (i != 3);
        bool = a(paramString.HAT.Url, paramc);
      }
    }
  }
  
  private static boolean a(String paramString, c paramc)
  {
    bool2 = false;
    AppMethodBeat.i(34667);
    Object localObject = paramc.dpV;
    paramc = paramc.JDb;
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
  
  private void fBN()
  {
    AppMethodBeat.i(34665);
    if ((this.JCs == null) || (this.JCD == 0L))
    {
      if (this.JCs == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.JCD) });
        if (this.JCx != null) {
          this.JCx.setVisibility(8);
        }
        AppMethodBeat.o(34665);
        return;
      }
    }
    this.JCC = com.tencent.mm.pluginsdk.model.app.h.b(this, this.JCD, false);
    if ((!com.tencent.mm.pluginsdk.model.app.h.r(this, this.JCD)) && (this.JCx != null)) {
      this.JCx.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.JCC != null) && (this.JCC.size() > 0))
    {
      localObject1 = ao.fah().CC(this.JCD);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.JCC, new Comparator() {});
      }
      localObject1 = this.JCC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next();
        localObject3 = new y();
        ((y)localObject3).appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
        ((y)localObject3).fVj = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
        ((y)localObject3).iconUrl = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.nOg == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.oRU.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.nOg = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.nOg.sdkVer = 637928960;
      if ((this.fVf != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.Jyc = true;
      }
      label403:
      this.JCs.Jyc = this.Jyc;
      this.JCs.V(localArrayList);
      this.JCs.notifyDataSetChanged();
      AppMethodBeat.o(34665);
      return;
      localObject1 = localObject3;
      if (this.dEu != null) {
        if (this.dEu.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.dEu.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.dEu.hAk;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.dEu.hzN;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.dEu.hAl;
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)this.dEu.ao(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            ((WXMusicObject)localObject1).songAlbumUrl = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songAlbumUrl;
            ((WXMusicObject)localObject1).songLyric = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songLyric;
          }
        }
        else if (this.dEu.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.dEu.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.dEu.hAl;
        }
        else if (this.dEu.type == 5)
        {
          localObject1 = new WXWebpageObject(this.dEu.url);
        }
        else
        {
          if (this.dEu.type == 6)
          {
            localObject3 = ao.bIX().aLD(this.dEu.dks);
            if (localObject3 != null)
            {
              ad.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              this.fVf = this.dEu.hzP;
            }
            while (r.aLR(this.filePath) != null)
            {
              com.tencent.mm.ui.base.h.cl(this, getString(2131757303));
              finish();
              break label403;
              ad.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.dEu.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = q.aIF().L(this.oRU);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = q.aIF().Fm(((com.tencent.mm.aw.g)localObject2).hZw);
              if (bt.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = q.aIF().Fm(((com.tencent.mm.aw.g)localObject2).hZy);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.fVf = this.dEu.hzP;
            ad.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.oRU.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = q.aIF().L(this.oRU);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = q.aIF().Fm(((com.tencent.mm.aw.g)localObject2).hZw);
              if (bt.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = q.aIF().Fm(((com.tencent.mm.aw.g)localObject2).hZy);
              }
              if (!bt.isNullOrNil(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.fVf = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            ad.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            ba.aBQ();
            localObject1 = com.tencent.mm.model.c.azs().aql(this.oRU.field_content);
            localObject1 = new WXLocationObject(((bu.b)localObject1).uZr, ((bu.b)localObject1).uZs);
            continue;
            localObject2 = new WXVideoObject();
            o.aMJ();
            localObject3 = t.Hh(this.oRU.field_imgPath);
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
                  this.fVf = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void fBO()
  {
    AppMethodBeat.i(34666);
    Object localObject1 = new dz();
    Object localObject2;
    int i;
    if (this.dpW)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      ((dz)localObject1).doV.doX = this.qbR;
      ((dz)localObject1).doV.doY = ((String)localObject2);
      ((dz)localObject1).doV.doZ = str;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!((dz)localObject1).doW.doF) {
        break label436;
      }
      localObject1 = ((dz)localObject1).doW.dpa;
      int j = ((List)localObject1).size();
      i = 0;
      label115:
      if (i >= j) {
        break label372;
      }
      localObject2 = new c();
      ((c)localObject2).dow = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((c)localObject2).fVj = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((c)localObject2).dpV = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((c)localObject2).JDb = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.dpW) || (!a((c)localObject2, this.qbR))) {
        break label338;
      }
      this.JCB.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label115;
      ((dz)localObject1).doV.msgId = this.fGN;
      break;
      label338:
      if ((!this.dpW) && (a((c)localObject2, this.fGN))) {
        this.JCB.add(localObject2);
      }
    }
    label372:
    if (this.JCB.size() > 0)
    {
      ad.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.JCt.V(this.JCB);
      if (this.JCt.getCount() > 0)
      {
        this.JCy.setText(2131757132);
        this.JCE = false;
      }
      this.JCt.notifyDataSetChanged();
    }
    label436:
    AppMethodBeat.o(34666);
  }
  
  public final void aVS(final String paramString)
  {
    AppMethodBeat.i(34670);
    try
    {
      final int i = ((Integer)this.JCM.get(paramString)).intValue();
      final aq localaq = (aq)((View)this.JCL.get(Integer.valueOf(i))).getTag();
      ad.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(localaq.JET.getProgress()), paramString });
      final c localc = (c)this.JCK.get(paramString);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34643);
          localaq.JET.setVisibility(0);
          localaq.JCW.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
          localaq.JCW.setText(ChattingSendDataToDeviceUI.this.getText(2131757314));
          localc.dqa = "send_data_sending";
          AppMethodBeat.o(34643);
        }
      });
      final int j = Math.abs(localaq.JET.getProgress());
      localc.progress = j;
      if (j >= 100) {}
      for (i = 0;; i = 500 / (100 - j))
      {
        ad.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
        com.tencent.e.h.LTJ.aU(new com.tencent.e.i.h()
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
                    ChattingSendDataToDeviceUI.10.this.JCR.JET.acY(0);
                    ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(ChattingSendDataToDeviceUI.10.this.EbU);
                    ChattingSendDataToDeviceUI.10.this.JCR.JET.setVisibility(4);
                    ChattingSendDataToDeviceUI.10.this.JCR.JCW.setText(ChattingSendDataToDeviceUI.this.getText(2131757312));
                    ChattingSendDataToDeviceUI.10.this.JCR.JCW.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
                    ChattingSendDataToDeviceUI.10.this.JCS.dqa = "send_data_sucess";
                    ChattingSendDataToDeviceUI.10.this.JCS.progress = 0;
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
              localaq.JET.acY(i);
              i += 1;
              j = i;
              Thread.sleep(i);
            }
          }
        });
        this.JCK.put(localc.deviceID, localc);
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
  
  public final b fBP()
  {
    AppMethodBeat.i(34676);
    if (this.JCA == null) {
      this.JCA = new b();
    }
    b localb = this.JCA;
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
    if (this.JCJ.size() > 0)
    {
      d.a locala = new d.a(this);
      locala.afi(2131757306);
      locala.afl(2131757308).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34641);
          paramAnonymousDialogInterface = ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).keySet().iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            do localdo = new do();
            localdo.dos.cUi = str;
            com.tencent.mm.sdk.b.a.IbL.l(localdo);
          }
          ChattingSendDataToDeviceUI.this.finish();
          AppMethodBeat.o(34641);
        }
      });
      locala.afm(2131757307).d(new ChattingSendDataToDeviceUI.8(this));
      locala.fMb().show();
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
    paramConfiguration = new dz();
    if (this.dpW)
    {
      String str1 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      paramConfiguration.doV.doX = this.qbR;
      paramConfiguration.doV.doY = str1;
      paramConfiguration.doV.doZ = str2;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IbL.l(paramConfiguration);
      if ((paramConfiguration.doW.doF) && (this.JCB.size() > 0))
      {
        ad.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.JCB.size()) });
        this.JCt.V(this.JCB);
        if (this.JCt.getCount() > 0)
        {
          this.JCy.setText(2131757132);
          this.JCE = false;
        }
        this.JCt.notifyDataSetChanged();
      }
      AppMethodBeat.o(34664);
      return;
      paramConfiguration.doV.msgId = this.fGN;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    AppMethodBeat.i(34661);
    super.onCreate(paramBundle);
    this.dpW = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    ad.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.dpW);
    if (!this.dpW)
    {
      this.fGN = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.fGN != -1L)
      {
        ba.aBQ();
        this.oRU = com.tencent.mm.model.c.azs().xY(this.fGN);
        if ((this.oRU != null) && (this.oRU.field_msgId != 0L)) {
          break label562;
        }
      }
    }
    this.JCH = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.JCF = false;
    setFinishOnTouchOutside(true);
    this.JCB.clear();
    this.JCK.clear();
    this.JCw = ((RelativeLayout)findViewById(2131302850));
    paramBundle = new eb();
    label260:
    Object localObject;
    if (this.dpW)
    {
      this.qbR = getIntent().getExtras().getString("sns_local_id");
      if (this.qbR != null)
      {
        paramBundle.dpg.doX = this.qbR;
        ad.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.qbR });
      }
      com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
      if (!paramBundle.dph.doF) {
        break label1267;
      }
      this.JCz = Boolean.TRUE;
      com.tencent.mm.sdk.b.a.IbL.c(this.JCN);
      com.tencent.mm.sdk.b.a.IbL.c(this.JCO);
      this.JCw.setVisibility(0);
      this.JCq = ((HorizontalListView)findViewById(2131301457));
      this.JCy = ((TextView)findViewById(2131296995));
      this.JCy.setText(2131757294);
      this.JCt = new a(this);
      this.JCq.setAdapter(this.JCt);
      this.JCq.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34637);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          ChattingSendDataToDeviceUI.this.JCF = true;
          localObject = ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).acT(paramAnonymousInt);
          String str1 = ((ChattingSendDataToDeviceUI.c)localObject).dow;
          paramAnonymousAdapterView = ((ChattingSendDataToDeviceUI.c)localObject).deviceID;
          String str2 = ((ChattingSendDataToDeviceUI.c)localObject).dpV;
          for (;;)
          {
            try
            {
              if (ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).get(paramAnonymousAdapterView) != null)
              {
                ad.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                paramAnonymousView = new do();
                paramAnonymousView.dos.cUi = paramAnonymousAdapterView;
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
                ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", paramAnonymousAdapterView, 0);
                ((ChattingSendDataToDeviceUI.c)localObject).dqa = "send_data_cancel";
                ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(paramAnonymousAdapterView);
                paramAnonymousAdapterView = (aq)((View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramAnonymousInt))).getTag();
                paramAnonymousAdapterView.JCW.setText(ChattingSendDataToDeviceUI.this.getText(2131757305));
                paramAnonymousAdapterView.JCW.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100852));
                paramAnonymousAdapterView.JET.setVisibility(8);
                paramAnonymousAdapterView.JET.acY(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34637);
                return;
              }
              ((ChattingSendDataToDeviceUI.c)localObject).dqa = "send_data_sending";
              ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(((ChattingSendDataToDeviceUI.c)localObject).deviceID, localObject);
              ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).put(paramAnonymousAdapterView, paramAnonymousView);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", paramAnonymousAdapterView, 1);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
              paramAnonymousView = new eu();
              paramAnonymousView.dpT.cUi = paramAnonymousAdapterView;
              paramAnonymousView.dpT.dow = str1;
              paramAnonymousView.dpT.data = ChattingSendDataToDeviceUI.e(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.dpT.dpV = str2;
              if (!ChattingSendDataToDeviceUI.this.dpW) {
                continue;
              }
              paramAnonymousView.dpT.doX = ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.dpT.dpW = ChattingSendDataToDeviceUI.this.dpW;
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
              if (!paramAnonymousView.dpU.dpX)
              {
                ChattingSendDataToDeviceUI.aVT("send_data_failed");
                ad.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
              }
            }
            catch (Exception paramAnonymousAdapterView)
            {
              ChattingSendDataToDeviceUI.aVT("send_data_failed");
              ad.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAnonymousAdapterView });
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34637);
            return;
            paramAnonymousView.dpT.msgId = ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this);
          }
        }
      });
      fBO();
      if (!this.dpW) {
        break label1076;
      }
      paramBundle = this.qbR;
      if (paramBundle == null) {
        break label1071;
      }
      localObject = new jp();
      ((jp)localObject).dwt.doX = paramBundle;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      i = ((jp)localObject).dwu.dwv.HAT.GaP;
      if (i != 1) {
        break label1039;
      }
      i = 3;
      label461:
      this.JCI = i;
      CG(1);
    }
    for (;;)
    {
      this.JCx = ((RelativeLayout)findViewById(2131296910));
      this.JCr = ((HorizontalListView)findViewById(2131296858));
      this.JCs = new b(this);
      this.JCr.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34639);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          ad.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)
          {
            paramAnonymousView = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(ChattingSendDataToDeviceUI.this));
            paramAnonymousAdapterView = ChattingSendDataToDeviceUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34639);
            return;
            if ((ChattingSendDataToDeviceUI.this.Jyc) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 2))
            {
              if ((ChattingSendDataToDeviceUI.this.filePath == null) || (ChattingSendDataToDeviceUI.this.fVf == null))
              {
                com.tencent.mm.ui.base.h.cl(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(2131758111));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34639);
                return;
              }
              com.tencent.mm.pluginsdk.ui.tools.a.b(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.fVf.toLowerCase(), 1);
            }
            else if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.getAdapter().getCount() - 1))
            {
              paramAnonymousAdapterView = (com.tencent.mm.pluginsdk.model.app.g)ChattingSendDataToDeviceUI.i(ChattingSendDataToDeviceUI.this).get(paramAnonymousInt);
              if (!com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView))
              {
                com.tencent.mm.ui.base.h.cl(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(2131757304));
                paramAnonymousAdapterView.field_status = 4;
                ao.dxQ().a(paramAnonymousAdapterView, new String[0]);
                ChattingSendDataToDeviceUI.j(ChattingSendDataToDeviceUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34639);
                return;
              }
              com.tencent.mm.ci.a.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(34638);
                  com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView.field_packageName, ChattingSendDataToDeviceUI.this.nOg, paramAnonymousAdapterView.field_appId, paramAnonymousAdapterView.field_openId, 0, null, null);
                  AppMethodBeat.o(34638);
                }
              });
            }
          }
        }
      });
      this.JCr.setAdapter(this.JCs);
      findViewById(2131303967).setOnClickListener(new ChattingSendDataToDeviceUI.1(this));
      AppMethodBeat.o(34661);
      return;
      label562:
      this.JCu = this.oRU.getType();
      this.Jxs = w.vF(this.oRU.field_talker);
      this.JCv = this.oRU.field_content;
      int j;
      if ((this.Jxs) && (this.oRU.field_isSend == 0))
      {
        localObject = this.oRU.field_content;
        j = this.oRU.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.Jxs)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = bj.Bl((String)localObject);
            }
          }
        }
        this.JCv = paramBundle;
      }
      if (this.oRU.getType() == 49)
      {
        this.dEu = k.b.yr(this.JCv);
        if (this.dEu == null)
        {
          ad.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.dEu.type == 3) {
          this.JCD = 16L;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.JCD) });
        break;
        if (this.dEu.type == 4)
        {
          this.JCD = 8L;
        }
        else if (this.dEu.type == 5)
        {
          this.JCD = 32L;
        }
        else
        {
          if (this.dEu.type == 6)
          {
            paramBundle = e.a.aLf(this.dEu.hzP);
            if (paramBundle == null)
            {
              ad.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.JCD = paramBundle.longValue();
            continue;
          }
          if (this.dEu.type == 2)
          {
            this.JCD = 2L;
            paramBundle = q.aIF().L(this.oRU);
            if (paramBundle != null) {
              this.JCv = paramBundle.hZI;
            }
          }
          else
          {
            ad.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.oRU.getType() == 3)
            {
              paramBundle = q.aIF().L(this.oRU);
              if (paramBundle != null) {
                this.JCv = paramBundle.hZI;
              }
            }
            for (;;)
            {
              paramBundle = e.a.aLf(this.JCu);
              if (paramBundle != null) {
                break label1014;
              }
              ad.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.oRU.getType() == 43)
              {
                paramBundle = o.aMJ().Hb(this.oRU.field_imgPath);
                if (paramBundle != null) {
                  this.JCv = paramBundle.aMV();
                }
              }
            }
            label1014:
            this.JCD = paramBundle.longValue();
          }
        }
      }
      paramBundle.dpg.msgId = this.fGN;
      break label260;
      label1039:
      if (i == 4)
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
      label1071:
      i = 0;
      break label461;
      label1076:
      long l = this.fGN;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      for (;;)
      {
        this.JCI = i;
        break;
        ba.aBQ();
        paramBundle = com.tencent.mm.model.c.azs().xY(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (!paramBundle.cTc()) {
            break label1237;
          }
          paramBundle = k.b.yr((String)localObject);
          if (paramBundle != null) {
            break label1176;
          }
          ad.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        }
        label1176:
        label1237:
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
      label1267:
      this.JCw.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34675);
    super.onDestroy();
    ad.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.JCG = false;
    if (this.JCz.booleanValue())
    {
      if (!this.JCF) {
        CG(2);
      }
      com.tencent.mm.sdk.b.a.IbL.d(this.JCN);
      com.tencent.mm.sdk.b.a.IbL.d(this.JCO);
      fh localfh = new fh();
      com.tencent.mm.sdk.b.a.IbL.l(localfh);
      if (localfh.dqu.dpX) {
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
    fBN();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.JCz.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.JCq.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.cc.a.eb(this);
      if (f != com.tencent.mm.cc.a.ia(this)) {
        break label85;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165490));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165516))) {
      label85:
      do
      {
        this.JCq.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(34672);
        return;
      } while ((f != com.tencent.mm.cc.a.ic(this)) && (f != com.tencent.mm.cc.a.ib(this)) && (f != com.tencent.mm.cc.a.id(this)));
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
    private Map<String, ChattingSendDataToDeviceUI.c> JCX;
    private List<Map<String, ChattingSendDataToDeviceUI.c>> Jyb;
    private Context context;
    private com.tencent.mm.aw.a.a.c qhI;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(34650);
      this.context = paramContext;
      this.Jyb = new ArrayList();
      this$1 = new c.a();
      ChattingSendDataToDeviceUI.this.idD = 2131233401;
      this.qhI = ChattingSendDataToDeviceUI.this.aJc();
      AppMethodBeat.o(34650);
    }
    
    public final void V(List<ChattingSendDataToDeviceUI.c> paramList)
    {
      AppMethodBeat.i(34651);
      this.Jyb.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.JCX = new HashMap();
        this.JCX.put("hard_device_info", paramList.get(i));
        this.Jyb.add(this.JCX);
        i += 1;
      }
      AppMethodBeat.o(34651);
    }
    
    public final ChattingSendDataToDeviceUI.c acT(int paramInt)
    {
      AppMethodBeat.i(34653);
      ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((Map)this.Jyb.get(paramInt)).get("hard_device_info");
      AppMethodBeat.o(34653);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34652);
      int i = this.Jyb.size();
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
      ChattingSendDataToDeviceUI.c localc = acT(paramInt);
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
        paramView.qkI = paramViewGroup.findViewById(2131298736);
        paramView.jfJ = ((TextView)paramViewGroup.findViewById(2131302656));
        paramView.lZa = ((ImageView)paramViewGroup.findViewById(2131300880));
        paramView.JCW = ((TextView)paramViewGroup.findViewById(2131304561));
        paramView.JET = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(2131304560));
        paramView.JET.setVisibility(4);
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localc.deviceID, Integer.valueOf(paramInt));
        String str1 = localc.fVj;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.cc.a.eb(this.context);
        if ((f != com.tencent.mm.cc.a.ia(this.context)) && (f != com.tencent.mm.cc.a.ib(this.context))) {
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
        if ((f != com.tencent.mm.cc.a.ic(this.context)) && (f != com.tencent.mm.cc.a.id(this.context))) {
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
      paramView.jfJ.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.JCW.setText(localStringBuffer);
      }
      Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(acT(paramInt).deviceID)) {
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(acT(paramInt).deviceID);
      }
      if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).dqa != null))
      {
        ad.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).dqa });
        if (!((ChattingSendDataToDeviceUI.c)localObject).dqa.equals("send_data_sending")) {
          break label756;
        }
        paramView.JCW.setText(this.context.getString(2131757314));
        paramView.JCW.setTextColor(this.context.getResources().getColor(2131100854));
        paramView.JET.acY(localc.progress);
        paramView.JET.setVisibility(0);
        localObject = localc.deviceID;
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
        if (j < 100) {
          break label742;
        }
        i = 0;
        com.tencent.e.h.LTJ.aU(new com.tencent.e.i.h()
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
            while (ChattingSendDataToDeviceUI.this.JCG)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                if (this.JCS.dqa.equals("send_data_sucess"))
                {
                  j = i;
                  ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(34647);
                      ChattingSendDataToDeviceUI.a.1.this.JCR.JET.acY(0);
                      ChattingSendDataToDeviceUI.a.1.this.JCR.JET.setVisibility(4);
                      ChattingSendDataToDeviceUI.a.1.this.JCR.JCW.setText(ChattingSendDataToDeviceUI.this.getText(2131757312));
                      ChattingSendDataToDeviceUI.a.1.this.JCR.JCW.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
                      ChattingSendDataToDeviceUI.a.1.this.JCS.dqa = "send_data_sucess";
                      ChattingSendDataToDeviceUI.a.1.this.JCS.progress = 0;
                      ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.JCS.deviceID, ChattingSendDataToDeviceUI.a.1.this.JCS);
                      ad.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.JCS.deviceID });
                      AppMethodBeat.o(34647);
                    }
                  });
                  AppMethodBeat.o(34649);
                  return;
                }
                j = i;
                if (!this.JCS.dqa.equals("send_data_failed")) {
                  continue;
                }
                j = i;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34648);
                    ChattingSendDataToDeviceUI.a.1.this.JCR.JET.acY(0);
                    ChattingSendDataToDeviceUI.a.1.this.JCR.JET.setVisibility(4);
                    ChattingSendDataToDeviceUI.a.1.this.JCR.JCW.setText(ChattingSendDataToDeviceUI.this.getText(2131757309));
                    ChattingSendDataToDeviceUI.a.1.this.JCR.JCW.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100857));
                    ChattingSendDataToDeviceUI.a.1.this.JCS.dqa = "send_data_failed";
                    ChattingSendDataToDeviceUI.a.1.this.JCS.progress = 0;
                    ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.JCS.deviceID, ChattingSendDataToDeviceUI.a.1.this.JCS);
                    ad.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.JCS.deviceID });
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
              paramView.JET.acY(i);
              j = i;
              this.JCS.progress = i;
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
        ad.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.fVj });
        q.aIJ().a(localc.iconUrl, paramView.lZa, this.qhI);
        paramView.qkI.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(34654);
        return paramViewGroup;
        label742:
        i = 500 / (100 - j);
        break;
        label756:
        if (((ChattingSendDataToDeviceUI.c)localObject).dqa.equals("send_data_sucess"))
        {
          paramView.JCW.setText(this.context.getString(2131757312));
          paramView.JCW.setTextColor(this.context.getResources().getColor(2131100854));
          paramView.JET.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).dqa.equals("send_data_cancel"))
        {
          paramView.JCW.setText(this.context.getString(2131757305));
          paramView.JCW.setTextColor(this.context.getResources().getColor(2131100852));
          paramView.JET.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).dqa.equals("send_data_failed"))
        {
          paramView.JCW.setText(this.context.getString(2131757309));
          paramView.JCW.setTextColor(this.context.getResources().getColor(2131100857));
          paramView.JET.setVisibility(4);
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
      paramb = (ev)paramb;
      String str1 = paramb.dpY.dqa;
      String str2 = paramb.dpY.cUi;
      if (str1.equals("send_data_sending")) {
        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, paramb.dpY.progress);
      }
      for (;;)
      {
        AppMethodBeat.o(34658);
        return true;
        if (str1.equals("send_data_failed")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
        } else if (str1.equals("send_data_sucess")) {
          ChattingSendDataToDeviceUI.this.aVS(str2);
        }
      }
    }
    
    private boolean o(com.tencent.mm.sdk.b.b paramb)
    {
      AppMethodBeat.i(34659);
      paramb = ((er)paramb).dpN.dpa;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramb.size())
      {
        ChattingSendDataToDeviceUI.c localc = new ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this);
        localc.dow = ((String)((Map)paramb.get(i)).get("deviceType"));
        localc.deviceID = ((String)((Map)paramb.get(i)).get("deviceID"));
        localc.fVj = ((String)((Map)paramb.get(i)).get("displayName"));
        localc.iconUrl = ((String)((Map)paramb.get(i)).get("iconUrl"));
        localc.dpV = ((String)((Map)paramb.get(i)).get("ability"));
        localc.JDb = ((String)((Map)paramb.get(i)).get("abilityInf"));
        if (((ChattingSendDataToDeviceUI.this.dpW) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this)))) || ((!ChattingSendDataToDeviceUI.this.dpW) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this)))))
        {
          if ((ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(localc.deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).dqa != null))
          {
            localc.dqa = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).dqa;
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
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).V(ChattingSendDataToDeviceUI.l(ChattingSendDataToDeviceUI.this));
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
      if ((paramb instanceof er))
      {
        bool = o(paramb);
        AppMethodBeat.o(34657);
        return bool;
      }
      if ((paramb instanceof ev))
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
    String JDb;
    String deviceID;
    String dow;
    String dpV;
    String dqa;
    String fVj;
    String iconUrl;
    int progress;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */