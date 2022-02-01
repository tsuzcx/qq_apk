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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.ea.b;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.es.a;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ev.b;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.g.a.ew.a;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fi.a;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.jq.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
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
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.b;
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
  boolean JSS;
  private boolean JSi;
  private HashMap<String, View> JXA;
  private HashMap<String, c> JXB;
  private Map<Integer, View> JXC;
  private Map<String, Integer> JXD;
  private com.tencent.mm.sdk.b.c JXE;
  private com.tencent.mm.sdk.b.c JXF;
  private HorizontalListView JXh;
  private HorizontalListView JXi;
  private b JXj;
  private a JXk;
  private int JXl;
  private String JXm;
  private RelativeLayout JXn;
  private RelativeLayout JXo;
  private TextView JXp;
  private Boolean JXq;
  private b JXr;
  private List<c> JXs;
  private List<com.tencent.mm.pluginsdk.model.app.g> JXt;
  private long JXu;
  private boolean JXv;
  boolean JXw;
  boolean JXx;
  int JXy;
  int JXz;
  private k.b dFz;
  boolean drb;
  private long fIR;
  String fXl;
  String filePath;
  WXMediaMessage nTL;
  private bv oYw;
  private String qiw;
  
  public ChattingSendDataToDeviceUI()
  {
    AppMethodBeat.i(34660);
    this.JXm = "";
    this.JXq = Boolean.FALSE;
    this.JXs = new ArrayList();
    this.JXt = new ArrayList();
    this.JXu = 0L;
    this.JXv = true;
    this.drb = false;
    this.JXw = false;
    this.JXx = true;
    this.JXy = 2;
    this.JXz = -1;
    this.JXA = new HashMap();
    this.JXB = new HashMap();
    this.JXC = new HashMap();
    this.JXD = new HashMap();
    this.nTL = null;
    this.filePath = null;
    this.fXl = null;
    this.JSS = false;
    this.JXE = new com.tencent.mm.sdk.b.c() {};
    this.JXF = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(34660);
  }
  
  private void CS(int paramInt)
  {
    AppMethodBeat.i(34662);
    if (this.drb)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.JXz), "", Integer.valueOf(2), Integer.valueOf(this.JXy) });
      AppMethodBeat.o(34662);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.JXz), En(this.fIR), Integer.valueOf(1), Integer.valueOf(this.JXy) });
    AppMethodBeat.o(34662);
  }
  
  private static String En(long paramLong)
  {
    AppMethodBeat.i(34663);
    String str2 = "";
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().ys(paramLong);
    if (((ei)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(34663);
      return "";
    }
    String str3 = ((ei)localObject).field_content;
    String str1 = str2;
    if (((bv)localObject).getType() == 49)
    {
      localObject = k.b.zb(str3);
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((k.b)localObject).type == 6) {
          str1 = ((k.b)localObject).hCD;
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
    String str1 = paramc.dra;
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().ys(paramLong);
    if ((((ei)localObject).field_msgId == 0L) || (str1 == null))
    {
      AppMethodBeat.o(34671);
      return false;
    }
    int i = ((bv)localObject).getType();
    String str2 = ((ei)localObject).field_content;
    if (((bv)localObject).cVH())
    {
      localObject = k.b.zb(str2);
      if (localObject == null)
      {
        ae.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
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
    Object localObject = new jq();
    ((jq)localObject).dxy.dqc = paramString;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    paramString = ((jq)localObject).dxz.dxA;
    int i = paramString.HUG.Gtw;
    ae.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.dra;
    if (localObject == null)
    {
      ae.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
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
        bool = a(paramString.HUG.Url, paramc);
      }
    }
  }
  
  private static boolean a(String paramString, c paramc)
  {
    bool2 = false;
    AppMethodBeat.i(34667);
    Object localObject = paramc.dra;
    paramc = paramc.JXS;
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
        ae.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", paramString, paramc, new Object[0]);
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(34667);
      return bool1;
      i += 1;
    }
  }
  
  private void fFP()
  {
    AppMethodBeat.i(34665);
    if ((this.JXj == null) || (this.JXu == 0L))
    {
      if (this.JXj == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.JXu) });
        if (this.JXo != null) {
          this.JXo.setVisibility(8);
        }
        AppMethodBeat.o(34665);
        return;
      }
    }
    this.JXt = com.tencent.mm.pluginsdk.model.app.h.b(this, this.JXu, false);
    if ((!com.tencent.mm.pluginsdk.model.app.h.s(this, this.JXu)) && (this.JXo != null)) {
      this.JXo.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.JXt != null) && (this.JXt.size() > 0))
    {
      localObject1 = ao.fdV().Da(this.JXu);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.JXt, new Comparator() {});
      }
      localObject1 = this.JXt.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next();
        localObject3 = new z();
        ((z)localObject3).appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
        ((z)localObject3).fXp = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
        ((z)localObject3).iconUrl = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.nTL == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.oYw.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.nTL = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.nTL.sdkVer = 637928960;
      if ((this.fXl != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.JSS = true;
      }
      label403:
      this.JXj.JSS = this.JSS;
      this.JXj.V(localArrayList);
      this.JXj.notifyDataSetChanged();
      AppMethodBeat.o(34665);
      return;
      localObject1 = localObject3;
      if (this.dFz != null) {
        if (this.dFz.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.dFz.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.dFz.hCY;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.dFz.hCB;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.dFz.hCZ;
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)this.dFz.ao(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            ((WXMusicObject)localObject1).songAlbumUrl = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songAlbumUrl;
            ((WXMusicObject)localObject1).songLyric = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songLyric;
          }
        }
        else if (this.dFz.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.dFz.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.dFz.hCZ;
        }
        else if (this.dFz.type == 5)
        {
          localObject1 = new WXWebpageObject(this.dFz.url);
        }
        else
        {
          if (this.dFz.type == 6)
          {
            localObject3 = ao.bJV().aMZ(this.dFz.dlu);
            if (localObject3 != null)
            {
              ae.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              this.fXl = this.dFz.hCD;
            }
            while (r.aNn(this.filePath) != null)
            {
              com.tencent.mm.ui.base.h.cm(this, getString(2131757303));
              finish();
              break label403;
              ae.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.dFz.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = q.aIX().L(this.oYw);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = q.aIX().FO(((com.tencent.mm.av.g)localObject2).ico);
              if (bu.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = q.aIX().FO(((com.tencent.mm.av.g)localObject2).icq);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.fXl = this.dFz.hCD;
            ae.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.oYw.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = q.aIX().L(this.oYw);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = q.aIX().FO(((com.tencent.mm.av.g)localObject2).ico);
              if (bu.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = q.aIX().FO(((com.tencent.mm.av.g)localObject2).icq);
              }
              if (!bu.isNullOrNil(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.fXl = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            ae.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            bc.aCg();
            localObject1 = com.tencent.mm.model.c.azI().arq(this.oYw.field_content);
            localObject1 = new WXLocationObject(((bv.b)localObject1).vlC, ((bv.b)localObject1).vlD);
            continue;
            localObject2 = new WXVideoObject();
            o.aNh();
            localObject3 = t.HJ(this.oYw.field_imgPath);
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
                  this.fXl = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void fFQ()
  {
    AppMethodBeat.i(34666);
    Object localObject1 = new ea();
    Object localObject2;
    int i;
    if (this.drb)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      ((ea)localObject1).dqa.dqc = this.qiw;
      ((ea)localObject1).dqa.dqd = ((String)localObject2);
      ((ea)localObject1).dqa.dqe = str;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!((ea)localObject1).dqb.dpK) {
        break label436;
      }
      localObject1 = ((ea)localObject1).dqb.dqf;
      int j = ((List)localObject1).size();
      i = 0;
      label115:
      if (i >= j) {
        break label372;
      }
      localObject2 = new c();
      ((c)localObject2).dpB = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((c)localObject2).fXp = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((c)localObject2).dra = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((c)localObject2).JXS = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.drb) || (!a((c)localObject2, this.qiw))) {
        break label338;
      }
      this.JXs.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label115;
      ((ea)localObject1).dqa.msgId = this.fIR;
      break;
      label338:
      if ((!this.drb) && (a((c)localObject2, this.fIR))) {
        this.JXs.add(localObject2);
      }
    }
    label372:
    if (this.JXs.size() > 0)
    {
      ae.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.JXk.V(this.JXs);
      if (this.JXk.getCount() > 0)
      {
        this.JXp.setText(2131757132);
        this.JXv = false;
      }
      this.JXk.notifyDataSetChanged();
    }
    label436:
    AppMethodBeat.o(34666);
  }
  
  public final void aXt(final String paramString)
  {
    AppMethodBeat.i(34670);
    try
    {
      final int i = ((Integer)this.JXD.get(paramString)).intValue();
      final ar localar = (ar)((View)this.JXC.get(Integer.valueOf(i))).getTag();
      ae.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(localar.JZK.getProgress()), paramString });
      final c localc = (c)this.JXB.get(paramString);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34643);
          localar.JZK.setVisibility(0);
          localar.JXN.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
          localar.JXN.setText(ChattingSendDataToDeviceUI.this.getText(2131757314));
          localc.drf = "send_data_sending";
          AppMethodBeat.o(34643);
        }
      });
      final int j = Math.abs(localar.JZK.getProgress());
      localc.progress = j;
      if (j >= 100) {}
      for (i = 0;; i = 500 / (100 - j))
      {
        ae.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
        com.tencent.e.h.MqF.aR(new com.tencent.e.i.h()
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
                    ChattingSendDataToDeviceUI.10.this.JXI.JZK.adG(0);
                    ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(ChattingSendDataToDeviceUI.10.this.EtV);
                    ChattingSendDataToDeviceUI.10.this.JXI.JZK.setVisibility(4);
                    ChattingSendDataToDeviceUI.10.this.JXI.JXN.setText(ChattingSendDataToDeviceUI.this.getText(2131757312));
                    ChattingSendDataToDeviceUI.10.this.JXI.JXN.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
                    ChattingSendDataToDeviceUI.10.this.JXJ.drf = "send_data_sucess";
                    ChattingSendDataToDeviceUI.10.this.JXJ.progress = 0;
                    ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 4);
                    AppMethodBeat.o(34644);
                  }
                });
                AppMethodBeat.o(34645);
                return;
              }
              catch (Exception localException)
              {
                ae.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              localar.JZK.adG(i);
              i += 1;
              j = i;
              Thread.sleep(i);
            }
          }
        });
        this.JXB.put(localc.deviceID, localc);
        AppMethodBeat.o(34670);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[] { paramString });
      AppMethodBeat.o(34670);
    }
  }
  
  public final b fFR()
  {
    AppMethodBeat.i(34676);
    if (this.JXr == null) {
      this.JXr = new b();
    }
    b localb = this.JXr;
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
    if (this.JXA.size() > 0)
    {
      d.a locala = new d.a(this);
      locala.afR(2131757306);
      locala.afU(2131757308).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34641);
          paramAnonymousDialogInterface = ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).keySet().iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            dp localdp = new dp();
            localdp.dpx.cVh = str;
            com.tencent.mm.sdk.b.a.IvT.l(localdp);
          }
          ChattingSendDataToDeviceUI.this.finish();
          AppMethodBeat.o(34641);
        }
      });
      locala.afV(2131757307).d(new ChattingSendDataToDeviceUI.8(this));
      locala.fQv().show();
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
    paramConfiguration = new ea();
    if (this.drb)
    {
      String str1 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      paramConfiguration.dqa.dqc = this.qiw;
      paramConfiguration.dqa.dqd = str1;
      paramConfiguration.dqa.dqe = str2;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IvT.l(paramConfiguration);
      if ((paramConfiguration.dqb.dpK) && (this.JXs.size() > 0))
      {
        ae.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.JXs.size()) });
        this.JXk.V(this.JXs);
        if (this.JXk.getCount() > 0)
        {
          this.JXp.setText(2131757132);
          this.JXv = false;
        }
        this.JXk.notifyDataSetChanged();
      }
      AppMethodBeat.o(34664);
      return;
      paramConfiguration.dqa.msgId = this.fIR;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    AppMethodBeat.i(34661);
    super.onCreate(paramBundle);
    this.drb = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    ae.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.drb);
    if (!this.drb)
    {
      this.fIR = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.fIR != -1L)
      {
        bc.aCg();
        this.oYw = com.tencent.mm.model.c.azI().ys(this.fIR);
        if ((this.oYw != null) && (this.oYw.field_msgId != 0L)) {
          break label562;
        }
      }
    }
    this.JXy = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.JXw = false;
    setFinishOnTouchOutside(true);
    this.JXs.clear();
    this.JXB.clear();
    this.JXn = ((RelativeLayout)findViewById(2131302850));
    paramBundle = new ec();
    label260:
    Object localObject;
    if (this.drb)
    {
      this.qiw = getIntent().getExtras().getString("sns_local_id");
      if (this.qiw != null)
      {
        paramBundle.dql.dqc = this.qiw;
        ae.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.qiw });
      }
      com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
      if (!paramBundle.dqm.dpK) {
        break label1267;
      }
      this.JXq = Boolean.TRUE;
      com.tencent.mm.sdk.b.a.IvT.c(this.JXE);
      com.tencent.mm.sdk.b.a.IvT.c(this.JXF);
      this.JXn.setVisibility(0);
      this.JXh = ((HorizontalListView)findViewById(2131301457));
      this.JXp = ((TextView)findViewById(2131296995));
      this.JXp.setText(2131757294);
      this.JXk = new a(this);
      this.JXh.setAdapter(this.JXk);
      this.JXh.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34637);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          ChattingSendDataToDeviceUI.this.JXw = true;
          localObject = ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).adB(paramAnonymousInt);
          String str1 = ((ChattingSendDataToDeviceUI.c)localObject).dpB;
          paramAnonymousAdapterView = ((ChattingSendDataToDeviceUI.c)localObject).deviceID;
          String str2 = ((ChattingSendDataToDeviceUI.c)localObject).dra;
          for (;;)
          {
            try
            {
              if (ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).get(paramAnonymousAdapterView) != null)
              {
                ae.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                paramAnonymousView = new dp();
                paramAnonymousView.dpx.cVh = paramAnonymousAdapterView;
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
                ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", paramAnonymousAdapterView, 0);
                ((ChattingSendDataToDeviceUI.c)localObject).drf = "send_data_cancel";
                ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(paramAnonymousAdapterView);
                paramAnonymousAdapterView = (ar)((View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramAnonymousInt))).getTag();
                paramAnonymousAdapterView.JXN.setText(ChattingSendDataToDeviceUI.this.getText(2131757305));
                paramAnonymousAdapterView.JXN.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100852));
                paramAnonymousAdapterView.JZK.setVisibility(8);
                paramAnonymousAdapterView.JZK.adG(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34637);
                return;
              }
              ((ChattingSendDataToDeviceUI.c)localObject).drf = "send_data_sending";
              ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(((ChattingSendDataToDeviceUI.c)localObject).deviceID, localObject);
              ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).put(paramAnonymousAdapterView, paramAnonymousView);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", paramAnonymousAdapterView, 1);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
              paramAnonymousView = new ev();
              paramAnonymousView.dqY.cVh = paramAnonymousAdapterView;
              paramAnonymousView.dqY.dpB = str1;
              paramAnonymousView.dqY.data = ChattingSendDataToDeviceUI.e(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.dqY.dra = str2;
              if (!ChattingSendDataToDeviceUI.this.drb) {
                continue;
              }
              paramAnonymousView.dqY.dqc = ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.dqY.drb = ChattingSendDataToDeviceUI.this.drb;
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
              if (!paramAnonymousView.dqZ.drc)
              {
                ChattingSendDataToDeviceUI.aXu("send_data_failed");
                ae.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
              }
            }
            catch (Exception paramAnonymousAdapterView)
            {
              ChattingSendDataToDeviceUI.aXu("send_data_failed");
              ae.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAnonymousAdapterView });
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34637);
            return;
            paramAnonymousView.dqY.msgId = ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this);
          }
        }
      });
      fFQ();
      if (!this.drb) {
        break label1076;
      }
      paramBundle = this.qiw;
      if (paramBundle == null) {
        break label1071;
      }
      localObject = new jq();
      ((jq)localObject).dxy.dqc = paramBundle;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      i = ((jq)localObject).dxz.dxA.HUG.Gtw;
      if (i != 1) {
        break label1039;
      }
      i = 3;
      label461:
      this.JXz = i;
      CS(1);
    }
    for (;;)
    {
      this.JXo = ((RelativeLayout)findViewById(2131296910));
      this.JXi = ((HorizontalListView)findViewById(2131296858));
      this.JXj = new b(this);
      this.JXi.setOnItemClickListener(new ChattingSendDataToDeviceUI.5(this));
      this.JXi.setAdapter(this.JXj);
      findViewById(2131303967).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34634);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ChattingSendDataToDeviceUI.this.onBackPressed();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34634);
        }
      });
      AppMethodBeat.o(34661);
      return;
      label562:
      this.JXl = this.oYw.getType();
      this.JSi = x.wb(this.oYw.field_talker);
      this.JXm = this.oYw.field_content;
      int j;
      if ((this.JSi) && (this.oYw.field_isSend == 0))
      {
        localObject = this.oYw.field_content;
        j = this.oYw.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.JSi)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = bl.BN((String)localObject);
            }
          }
        }
        this.JXm = paramBundle;
      }
      if (this.oYw.getType() == 49)
      {
        this.dFz = k.b.zb(this.JXm);
        if (this.dFz == null)
        {
          ae.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.dFz.type == 3) {
          this.JXu = 16L;
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.JXu) });
        break;
        if (this.dFz.type == 4)
        {
          this.JXu = 8L;
        }
        else if (this.dFz.type == 5)
        {
          this.JXu = 32L;
        }
        else
        {
          if (this.dFz.type == 6)
          {
            paramBundle = e.a.aMB(this.dFz.hCD);
            if (paramBundle == null)
            {
              ae.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.JXu = paramBundle.longValue();
            continue;
          }
          if (this.dFz.type == 2)
          {
            this.JXu = 2L;
            paramBundle = q.aIX().L(this.oYw);
            if (paramBundle != null) {
              this.JXm = paramBundle.icA;
            }
          }
          else
          {
            ae.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.oYw.getType() == 3)
            {
              paramBundle = q.aIX().L(this.oYw);
              if (paramBundle != null) {
                this.JXm = paramBundle.icA;
              }
            }
            for (;;)
            {
              paramBundle = e.a.aMB(this.JXl);
              if (paramBundle != null) {
                break label1014;
              }
              ae.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.oYw.getType() == 43)
              {
                paramBundle = o.aNh().HD(this.oYw.field_imgPath);
                if (paramBundle != null) {
                  this.JXm = paramBundle.aNt();
                }
              }
            }
            label1014:
            this.JXu = paramBundle.longValue();
          }
        }
      }
      paramBundle.dql.msgId = this.fIR;
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
      long l = this.fIR;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      for (;;)
      {
        this.JXz = i;
        break;
        bc.aCg();
        paramBundle = com.tencent.mm.model.c.azI().ys(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (!paramBundle.cVH()) {
            break label1237;
          }
          paramBundle = k.b.zb((String)localObject);
          if (paramBundle != null) {
            break label1176;
          }
          ae.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
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
      this.JXn.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34675);
    super.onDestroy();
    ae.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.JXx = false;
    if (this.JXq.booleanValue())
    {
      if (!this.JXw) {
        CS(2);
      }
      com.tencent.mm.sdk.b.a.IvT.d(this.JXE);
      com.tencent.mm.sdk.b.a.IvT.d(this.JXF);
      fi localfi = new fi();
      com.tencent.mm.sdk.b.a.IvT.l(localfi);
      if (localfi.drz.drc) {
        ae.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
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
    fFP();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.JXq.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.JXh.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.cb.a.ef(this);
      if (f != com.tencent.mm.cb.a.jdMethod_if(this)) {
        break label85;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165490));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165516))) {
      label85:
      do
      {
        this.JXh.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(34672);
        return;
      } while ((f != com.tencent.mm.cb.a.ih(this)) && (f != com.tencent.mm.cb.a.ig(this)) && (f != com.tencent.mm.cb.a.ii(this)));
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
    private List<Map<String, ChattingSendDataToDeviceUI.c>> JSR;
    private Map<String, ChattingSendDataToDeviceUI.c> JXO;
    private Context context;
    private com.tencent.mm.av.a.a.c qon;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(34650);
      this.context = paramContext;
      this.JSR = new ArrayList();
      this$1 = new c.a();
      ChattingSendDataToDeviceUI.this.igv = 2131233401;
      this.qon = ChattingSendDataToDeviceUI.this.aJu();
      AppMethodBeat.o(34650);
    }
    
    public final void V(List<ChattingSendDataToDeviceUI.c> paramList)
    {
      AppMethodBeat.i(34651);
      this.JSR.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.JXO = new HashMap();
        this.JXO.put("hard_device_info", paramList.get(i));
        this.JSR.add(this.JXO);
        i += 1;
      }
      AppMethodBeat.o(34651);
    }
    
    public final ChattingSendDataToDeviceUI.c adB(int paramInt)
    {
      AppMethodBeat.i(34653);
      ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((Map)this.JSR.get(paramInt)).get("hard_device_info");
      AppMethodBeat.o(34653);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34652);
      int i = this.JSR.size();
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
      ChattingSendDataToDeviceUI.c localc = adB(paramInt);
      ae.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
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
        paramView = new ar();
        paramViewGroup = View.inflate(paramViewGroup.getContext(), 2131495368, null);
        paramView.qrn = paramViewGroup.findViewById(2131298736);
        paramView.jiC = ((TextView)paramViewGroup.findViewById(2131302656));
        paramView.mdt = ((ImageView)paramViewGroup.findViewById(2131300880));
        paramView.JXN = ((TextView)paramViewGroup.findViewById(2131304561));
        paramView.JZK = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(2131304560));
        paramView.JZK.setVisibility(4);
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localc.deviceID, Integer.valueOf(paramInt));
        String str1 = localc.fXp;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.cb.a.ef(this.context);
        if ((f != com.tencent.mm.cb.a.jdMethod_if(this.context)) && (f != com.tencent.mm.cb.a.ig(this.context))) {
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
        paramView = (ar)paramViewGroup.getTag();
        break;
        label374:
        if ((f != com.tencent.mm.cb.a.ih(this.context)) && (f != com.tencent.mm.cb.a.ii(this.context))) {
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
      paramView.jiC.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.JXN.setText(localStringBuffer);
      }
      Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(adB(paramInt).deviceID)) {
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(adB(paramInt).deviceID);
      }
      if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).drf != null))
      {
        ae.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).drf });
        if (!((ChattingSendDataToDeviceUI.c)localObject).drf.equals("send_data_sending")) {
          break label756;
        }
        paramView.JXN.setText(this.context.getString(2131757314));
        paramView.JXN.setTextColor(this.context.getResources().getColor(2131100854));
        paramView.JZK.adG(localc.progress);
        paramView.JZK.setVisibility(0);
        localObject = localc.deviceID;
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
        if (j < 100) {
          break label742;
        }
        i = 0;
        com.tencent.e.h.MqF.aR(new com.tencent.e.i.h()
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
            while (ChattingSendDataToDeviceUI.this.JXx)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                if (this.JXJ.drf.equals("send_data_sucess"))
                {
                  j = i;
                  ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(34647);
                      ChattingSendDataToDeviceUI.a.1.this.JXI.JZK.adG(0);
                      ChattingSendDataToDeviceUI.a.1.this.JXI.JZK.setVisibility(4);
                      ChattingSendDataToDeviceUI.a.1.this.JXI.JXN.setText(ChattingSendDataToDeviceUI.this.getText(2131757312));
                      ChattingSendDataToDeviceUI.a.1.this.JXI.JXN.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
                      ChattingSendDataToDeviceUI.a.1.this.JXJ.drf = "send_data_sucess";
                      ChattingSendDataToDeviceUI.a.1.this.JXJ.progress = 0;
                      ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.JXJ.deviceID, ChattingSendDataToDeviceUI.a.1.this.JXJ);
                      ae.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.JXJ.deviceID });
                      AppMethodBeat.o(34647);
                    }
                  });
                  AppMethodBeat.o(34649);
                  return;
                }
                j = i;
                if (!this.JXJ.drf.equals("send_data_failed")) {
                  continue;
                }
                j = i;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34648);
                    ChattingSendDataToDeviceUI.a.1.this.JXI.JZK.adG(0);
                    ChattingSendDataToDeviceUI.a.1.this.JXI.JZK.setVisibility(4);
                    ChattingSendDataToDeviceUI.a.1.this.JXI.JXN.setText(ChattingSendDataToDeviceUI.this.getText(2131757309));
                    ChattingSendDataToDeviceUI.a.1.this.JXI.JXN.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100857));
                    ChattingSendDataToDeviceUI.a.1.this.JXJ.drf = "send_data_failed";
                    ChattingSendDataToDeviceUI.a.1.this.JXJ.progress = 0;
                    ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.JXJ.deviceID, ChattingSendDataToDeviceUI.a.1.this.JXJ);
                    ae.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.JXJ.deviceID });
                    AppMethodBeat.o(34648);
                  }
                });
                AppMethodBeat.o(34649);
                return;
              }
              catch (Exception localException)
              {
                ae.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              paramView.JZK.adG(i);
              j = i;
              this.JXJ.progress = i;
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
        ae.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.fXp });
        q.aJb().a(localc.iconUrl, paramView.mdt, this.qon);
        paramView.qrn.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(34654);
        return paramViewGroup;
        label742:
        i = 500 / (100 - j);
        break;
        label756:
        if (((ChattingSendDataToDeviceUI.c)localObject).drf.equals("send_data_sucess"))
        {
          paramView.JXN.setText(this.context.getString(2131757312));
          paramView.JXN.setTextColor(this.context.getResources().getColor(2131100854));
          paramView.JZK.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).drf.equals("send_data_cancel"))
        {
          paramView.JXN.setText(this.context.getString(2131757305));
          paramView.JXN.setTextColor(this.context.getResources().getColor(2131100852));
          paramView.JZK.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).drf.equals("send_data_failed"))
        {
          paramView.JXN.setText(this.context.getString(2131757309));
          paramView.JXN.setTextColor(this.context.getResources().getColor(2131100857));
          paramView.JZK.setVisibility(4);
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
      paramb = (ew)paramb;
      String str1 = paramb.drd.drf;
      String str2 = paramb.drd.cVh;
      if (str1.equals("send_data_sending")) {
        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, paramb.drd.progress);
      }
      for (;;)
      {
        AppMethodBeat.o(34658);
        return true;
        if (str1.equals("send_data_failed")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
        } else if (str1.equals("send_data_sucess")) {
          ChattingSendDataToDeviceUI.this.aXt(str2);
        }
      }
    }
    
    private boolean o(com.tencent.mm.sdk.b.b paramb)
    {
      AppMethodBeat.i(34659);
      paramb = ((es)paramb).dqS.dqf;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramb.size())
      {
        ChattingSendDataToDeviceUI.c localc = new ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this);
        localc.dpB = ((String)((Map)paramb.get(i)).get("deviceType"));
        localc.deviceID = ((String)((Map)paramb.get(i)).get("deviceID"));
        localc.fXp = ((String)((Map)paramb.get(i)).get("displayName"));
        localc.iconUrl = ((String)((Map)paramb.get(i)).get("iconUrl"));
        localc.dra = ((String)((Map)paramb.get(i)).get("ability"));
        localc.JXS = ((String)((Map)paramb.get(i)).get("abilityInf"));
        if (((ChattingSendDataToDeviceUI.this.drb) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this)))) || ((!ChattingSendDataToDeviceUI.this.drb) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this)))))
        {
          if ((ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(localc.deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).drf != null))
          {
            localc.drf = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).drf;
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
      if ((paramb instanceof es))
      {
        bool = o(paramb);
        AppMethodBeat.o(34657);
        return bool;
      }
      if ((paramb instanceof ew))
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
    String JXS;
    String deviceID;
    String dpB;
    String dra;
    String drf;
    String fXp;
    String iconUrl;
    int progress;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */