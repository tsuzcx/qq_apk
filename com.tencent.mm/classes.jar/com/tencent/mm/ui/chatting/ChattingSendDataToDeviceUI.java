package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.e;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dw.b;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.eo.a;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.er.b;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.es.a;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.fe.a;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.a.jh.b;
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
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.HorizontalListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
  private boolean HJB;
  boolean HKl;
  private HorizontalListView HOC;
  private HorizontalListView HOD;
  private b HOE;
  private a HOF;
  private int HOG;
  private String HOH;
  private RelativeLayout HOI;
  private RelativeLayout HOJ;
  private TextView HOK;
  private Boolean HOL;
  private b HOM;
  private List<c> HON;
  private List<com.tencent.mm.pluginsdk.model.app.g> HOO;
  private long HOP;
  private boolean HOQ;
  boolean HOR;
  boolean HOS;
  int HOT;
  int HOU;
  private HashMap<String, View> HOV;
  private HashMap<String, c> HOW;
  private Map<Integer, View> HOX;
  private Map<String, Integer> HOY;
  private com.tencent.mm.sdk.b.c HOZ;
  private com.tencent.mm.sdk.b.c HPa;
  boolean deA;
  private k.b dsB;
  String fBR;
  String filePath;
  private long foF;
  WXMediaMessage nnt;
  private bo ooz;
  private String pym;
  
  public ChattingSendDataToDeviceUI()
  {
    AppMethodBeat.i(34660);
    this.HOH = "";
    this.HOL = Boolean.FALSE;
    this.HON = new ArrayList();
    this.HOO = new ArrayList();
    this.HOP = 0L;
    this.HOQ = true;
    this.deA = false;
    this.HOR = false;
    this.HOS = true;
    this.HOT = 2;
    this.HOU = -1;
    this.HOV = new HashMap();
    this.HOW = new HashMap();
    this.HOX = new HashMap();
    this.HOY = new HashMap();
    this.nnt = null;
    this.filePath = null;
    this.fBR = null;
    this.HKl = false;
    this.HOZ = new com.tencent.mm.sdk.b.c() {};
    this.HPa = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(34660);
  }
  
  private static String AY(long paramLong)
  {
    AppMethodBeat.i(34663);
    String str2 = "";
    az.ayM();
    Object localObject = com.tencent.mm.model.c.awD().vP(paramLong);
    if (((com.tencent.mm.g.c.dy)localObject).field_msgId == 0L)
    {
      AppMethodBeat.o(34663);
      return "";
    }
    String str3 = ((com.tencent.mm.g.c.dy)localObject).field_content;
    String str1 = str2;
    if (((bo)localObject).getType() == 49)
    {
      localObject = k.b.vA(str3);
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((k.b)localObject).type == 6) {
          str1 = ((k.b)localObject).hhG;
        }
      }
    }
    AppMethodBeat.o(34663);
    return str1;
  }
  
  private void BX(int paramInt)
  {
    AppMethodBeat.i(34662);
    if (this.deA)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HOU), "", Integer.valueOf(2), Integer.valueOf(this.HOT) });
      AppMethodBeat.o(34662);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HOU), AY(this.foF), Integer.valueOf(1), Integer.valueOf(this.HOT) });
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
    String str1 = paramc.dez;
    az.ayM();
    Object localObject = com.tencent.mm.model.c.awD().vP(paramLong);
    if ((((com.tencent.mm.g.c.dy)localObject).field_msgId == 0L) || (str1 == null))
    {
      AppMethodBeat.o(34671);
      return false;
    }
    int i = ((bo)localObject).getType();
    String str2 = ((com.tencent.mm.g.c.dy)localObject).field_content;
    if (((bo)localObject).cKN())
    {
      localObject = k.b.vA(str2);
      if (localObject == null)
      {
        ac.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
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
    Object localObject = new jh();
    ((jh)localObject).dkG.ddB = paramString;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    paramString = ((jh)localObject).dkH.dkI;
    int i = paramString.FQo.Ety;
    ac.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.dez;
    if (localObject == null)
    {
      ac.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
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
        bool = a(paramString.FQo.Url, paramc);
      }
    }
  }
  
  private static boolean a(String paramString, c paramc)
  {
    bool2 = false;
    AppMethodBeat.i(34667);
    Object localObject = paramc.dez;
    paramc = paramc.HPn;
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
        ac.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", paramString, paramc, new Object[0]);
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(34667);
      return bool1;
      i += 1;
    }
  }
  
  private void flx()
  {
    AppMethodBeat.i(34665);
    if ((this.HOE == null) || (this.HOP == 0L))
    {
      if (this.HOE == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.HOP) });
        if (this.HOJ != null) {
          this.HOJ.setVisibility(8);
        }
        AppMethodBeat.o(34665);
        return;
      }
    }
    this.HOO = com.tencent.mm.pluginsdk.model.app.h.b(this, this.HOP, false);
    if ((!com.tencent.mm.pluginsdk.model.app.h.r(this, this.HOP)) && (this.HOJ != null)) {
      this.HOJ.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.HOO != null) && (this.HOO.size() > 0))
    {
      localObject1 = ap.eLm().zO(this.HOP);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.HOO, new Comparator() {});
      }
      localObject1 = this.HOO.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.model.app.g)((Iterator)localObject1).next();
        localObject3 = new y();
        ((y)localObject3).appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
        ((y)localObject3).fBV = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appName;
        ((y)localObject3).iconUrl = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.nnt == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.ooz.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.nnt = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.nnt.sdkVer = 637927424;
      if ((this.fBR != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.HKl = true;
      }
      label403:
      this.HOE.HKl = this.HKl;
      this.HOE.U(localArrayList);
      this.HOE.notifyDataSetChanged();
      AppMethodBeat.o(34665);
      return;
      localObject1 = localObject3;
      if (this.dsB != null) {
        if (this.dsB.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.dsB.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.dsB.hib;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.dsB.hhE;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.dsB.hic;
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)this.dsB.ao(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            ((WXMusicObject)localObject1).songAlbumUrl = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songAlbumUrl;
            ((WXMusicObject)localObject1).songLyric = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songLyric;
          }
        }
        else if (this.dsB.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.dsB.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.dsB.hic;
        }
        else if (this.dsB.type == 5)
        {
          localObject1 = new WXWebpageObject(this.dsB.url);
        }
        else
        {
          if (this.dsB.type == 6)
          {
            localObject3 = ap.bEO().aGd(this.dsB.cZa);
            if (localObject3 != null)
            {
              ac.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              this.fBR = this.dsB.hhG;
            }
            while (r.aGr(this.filePath) != null)
            {
              com.tencent.mm.ui.base.h.cg(this, getString(2131757303));
              finish();
              break label403;
              ac.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.dsB.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = com.tencent.mm.av.o.aFx().I(this.ooz);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = com.tencent.mm.av.o.aFx().Cl(((e)localObject2).hGM);
              if (bs.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = com.tencent.mm.av.o.aFx().Cl(((e)localObject2).hGO);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.fBR = this.dsB.hhG;
            ac.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.ooz.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = com.tencent.mm.av.o.aFx().I(this.ooz);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = com.tencent.mm.av.o.aFx().Cl(((e)localObject2).hGM);
              if (bs.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = com.tencent.mm.av.o.aFx().Cl(((e)localObject2).hGO);
              }
              if (!bs.isNullOrNil(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.fBR = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            ac.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            az.ayM();
            localObject1 = com.tencent.mm.model.c.awD().alx(this.ooz.field_content);
            localObject1 = new WXLocationObject(((bo.b)localObject1).tWI, ((bo.b)localObject1).tWJ);
            continue;
            localObject2 = new WXVideoObject();
            com.tencent.mm.modelvideo.o.aJy();
            localObject3 = t.DV(this.ooz.field_imgPath);
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
                  this.fBR = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void fly()
  {
    AppMethodBeat.i(34666);
    Object localObject1 = new dw();
    Object localObject2;
    int i;
    if (this.deA)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      ((dw)localObject1).ddz.ddB = this.pym;
      ((dw)localObject1).ddz.ddC = ((String)localObject2);
      ((dw)localObject1).ddz.ddD = str;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      if (!((dw)localObject1).ddA.ddj) {
        break label436;
      }
      localObject1 = ((dw)localObject1).ddA.ddE;
      int j = ((List)localObject1).size();
      i = 0;
      label115:
      if (i >= j) {
        break label372;
      }
      localObject2 = new c();
      ((c)localObject2).dda = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((c)localObject2).fBV = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((c)localObject2).dez = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((c)localObject2).HPn = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.deA) || (!a((c)localObject2, this.pym))) {
        break label338;
      }
      this.HON.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label115;
      ((dw)localObject1).ddz.msgId = this.foF;
      break;
      label338:
      if ((!this.deA) && (a((c)localObject2, this.foF))) {
        this.HON.add(localObject2);
      }
    }
    label372:
    if (this.HON.size() > 0)
    {
      ac.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.HOF.U(this.HON);
      if (this.HOF.getCount() > 0)
      {
        this.HOK.setText(2131757132);
        this.HOQ = false;
      }
      this.HOF.notifyDataSetChanged();
    }
    label436:
    AppMethodBeat.o(34666);
  }
  
  public final void aQc(final String paramString)
  {
    AppMethodBeat.i(34670);
    try
    {
      final int i = ((Integer)this.HOY.get(paramString)).intValue();
      final aq localaq = (aq)((View)this.HOX.get(Integer.valueOf(i))).getTag();
      ac.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(localaq.HRd.getProgress()), paramString });
      final c localc = (c)this.HOW.get(paramString);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34643);
          localaq.HRd.setVisibility(0);
          localaq.HPi.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
          localaq.HPi.setText(ChattingSendDataToDeviceUI.this.getText(2131757314));
          localc.deE = "send_data_sending";
          AppMethodBeat.o(34643);
        }
      });
      final int j = Math.abs(localaq.HRd.getProgress());
      localc.progress = j;
      if (j >= 100) {}
      for (i = 0;; i = 500 / (100 - j))
      {
        ac.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
        com.tencent.e.h.JZN.aV(new com.tencent.e.i.h()
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
                    ChattingSendDataToDeviceUI.10.this.HPd.HRd.aaN(0);
                    ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(ChattingSendDataToDeviceUI.10.this.Cyl);
                    ChattingSendDataToDeviceUI.10.this.HPd.HRd.setVisibility(4);
                    ChattingSendDataToDeviceUI.10.this.HPd.HPi.setText(ChattingSendDataToDeviceUI.this.getText(2131757312));
                    ChattingSendDataToDeviceUI.10.this.HPd.HPi.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
                    ChattingSendDataToDeviceUI.10.this.HPe.deE = "send_data_sucess";
                    ChattingSendDataToDeviceUI.10.this.HPe.progress = 0;
                    ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 4);
                    AppMethodBeat.o(34644);
                  }
                });
                AppMethodBeat.o(34645);
                return;
              }
              catch (Exception localException)
              {
                ac.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              localaq.HRd.aaN(i);
              i += 1;
              j = i;
              Thread.sleep(i);
            }
          }
        });
        this.HOW.put(localc.deviceID, localc);
        AppMethodBeat.o(34670);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[] { paramString });
      AppMethodBeat.o(34670);
    }
  }
  
  public final b flz()
  {
    AppMethodBeat.i(34676);
    if (this.HOM == null) {
      this.HOM = new b();
    }
    b localb = this.HOM;
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
    if (this.HOV.size() > 0)
    {
      com.tencent.mm.ui.widget.a.d.a locala = new com.tencent.mm.ui.widget.a.d.a(this);
      locala.acJ(2131757306);
      locala.acM(2131757308).b(new ChattingSendDataToDeviceUI.7(this));
      locala.acN(2131757307).c(new ChattingSendDataToDeviceUI.8(this));
      locala.fvp().show();
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
    paramConfiguration = new dw();
    if (this.deA)
    {
      String str1 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      paramConfiguration.ddz.ddB = this.pym;
      paramConfiguration.ddz.ddC = str1;
      paramConfiguration.ddz.ddD = str2;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.GpY.l(paramConfiguration);
      if ((paramConfiguration.ddA.ddj) && (this.HON.size() > 0))
      {
        ac.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.HON.size()) });
        this.HOF.U(this.HON);
        if (this.HOF.getCount() > 0)
        {
          this.HOK.setText(2131757132);
          this.HOQ = false;
        }
        this.HOF.notifyDataSetChanged();
      }
      AppMethodBeat.o(34664);
      return;
      paramConfiguration.ddz.msgId = this.foF;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    AppMethodBeat.i(34661);
    super.onCreate(paramBundle);
    this.deA = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    ac.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.deA);
    if (!this.deA)
    {
      this.foF = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.foF != -1L)
      {
        az.ayM();
        this.ooz = com.tencent.mm.model.c.awD().vP(this.foF);
        if ((this.ooz != null) && (this.ooz.field_msgId != 0L)) {
          break label562;
        }
      }
    }
    this.HOT = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.HOR = false;
    setFinishOnTouchOutside(true);
    this.HON.clear();
    this.HOW.clear();
    this.HOI = ((RelativeLayout)findViewById(2131302850));
    paramBundle = new com.tencent.mm.g.a.dy();
    label260:
    Object localObject;
    if (this.deA)
    {
      this.pym = getIntent().getExtras().getString("sns_local_id");
      if (this.pym != null)
      {
        paramBundle.ddK.ddB = this.pym;
        ac.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.pym });
      }
      com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
      if (!paramBundle.ddL.ddj) {
        break label1267;
      }
      this.HOL = Boolean.TRUE;
      com.tencent.mm.sdk.b.a.GpY.c(this.HOZ);
      com.tencent.mm.sdk.b.a.GpY.c(this.HPa);
      this.HOI.setVisibility(0);
      this.HOC = ((HorizontalListView)findViewById(2131301457));
      this.HOK = ((TextView)findViewById(2131296995));
      this.HOK.setText(2131757294);
      this.HOF = new a(this);
      this.HOC.setAdapter(this.HOF);
      this.HOC.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34637);
          ChattingSendDataToDeviceUI.this.HOR = true;
          ChattingSendDataToDeviceUI.c localc = ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).aaJ(paramAnonymousInt);
          String str1 = localc.dda;
          paramAnonymousAdapterView = localc.deviceID;
          String str2 = localc.dez;
          try
          {
            if (ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).get(paramAnonymousAdapterView) != null)
            {
              ac.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
              paramAnonymousView = new dl();
              paramAnonymousView.dcW.cIZ = paramAnonymousAdapterView;
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", paramAnonymousAdapterView, 0);
              localc.deE = "send_data_cancel";
              ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(paramAnonymousAdapterView);
              paramAnonymousAdapterView = (aq)((View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramAnonymousInt))).getTag();
              paramAnonymousAdapterView.HPi.setText(ChattingSendDataToDeviceUI.this.getText(2131757305));
              paramAnonymousAdapterView.HPi.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100852));
              paramAnonymousAdapterView.HRd.setVisibility(8);
              paramAnonymousAdapterView.HRd.aaN(0);
              AppMethodBeat.o(34637);
              return;
            }
            localc.deE = "send_data_sending";
            ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(localc.deviceID, localc);
            ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).put(paramAnonymousAdapterView, paramAnonymousView);
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", paramAnonymousAdapterView, 1);
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
            paramAnonymousView = new er();
            paramAnonymousView.dex.cIZ = paramAnonymousAdapterView;
            paramAnonymousView.dex.dda = str1;
            paramAnonymousView.dex.data = ChattingSendDataToDeviceUI.e(ChattingSendDataToDeviceUI.this);
            paramAnonymousView.dex.dez = str2;
            if (ChattingSendDataToDeviceUI.this.deA)
            {
              paramAnonymousView.dex.ddB = ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.dex.deA = ChattingSendDataToDeviceUI.this.deA;
            }
            for (;;)
            {
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
              if (!paramAnonymousView.dey.deB)
              {
                ChattingSendDataToDeviceUI.aQd("send_data_failed");
                ac.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
              }
              AppMethodBeat.o(34637);
              return;
              paramAnonymousView.dex.msgId = ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this);
            }
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            ChattingSendDataToDeviceUI.aQd("send_data_failed");
            ac.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAnonymousAdapterView });
            AppMethodBeat.o(34637);
          }
        }
      });
      fly();
      if (!this.deA) {
        break label1076;
      }
      paramBundle = this.pym;
      if (paramBundle == null) {
        break label1071;
      }
      localObject = new jh();
      ((jh)localObject).dkG.ddB = paramBundle;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      i = ((jh)localObject).dkH.dkI.FQo.Ety;
      if (i != 1) {
        break label1039;
      }
      i = 3;
      label461:
      this.HOU = i;
      BX(1);
    }
    for (;;)
    {
      this.HOJ = ((RelativeLayout)findViewById(2131296910));
      this.HOD = ((HorizontalListView)findViewById(2131296858));
      this.HOE = new b(this);
      this.HOD.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34639);
          ac.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)
          {
            paramAnonymousView = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(ChattingSendDataToDeviceUI.this));
            paramAnonymousAdapterView = ChattingSendDataToDeviceUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(34639);
            return;
          }
          if ((ChattingSendDataToDeviceUI.this.HKl) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 2))
          {
            if ((ChattingSendDataToDeviceUI.this.filePath == null) || (ChattingSendDataToDeviceUI.this.fBR == null))
            {
              com.tencent.mm.ui.base.h.cg(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(2131758111));
              AppMethodBeat.o(34639);
              return;
            }
            com.tencent.mm.pluginsdk.ui.tools.a.b(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.fBR.toLowerCase(), 1);
            AppMethodBeat.o(34639);
            return;
          }
          if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.getAdapter().getCount() - 1))
          {
            paramAnonymousAdapterView = (com.tencent.mm.pluginsdk.model.app.g)ChattingSendDataToDeviceUI.i(ChattingSendDataToDeviceUI.this).get(paramAnonymousInt);
            if (!com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView))
            {
              com.tencent.mm.ui.base.h.cg(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(2131757304));
              paramAnonymousAdapterView.field_status = 4;
              ap.dny().a(paramAnonymousAdapterView, new String[0]);
              ChattingSendDataToDeviceUI.j(ChattingSendDataToDeviceUI.this);
              AppMethodBeat.o(34639);
              return;
            }
            com.tencent.mm.ci.a.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(34638);
                com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView.field_packageName, ChattingSendDataToDeviceUI.this.nnt, paramAnonymousAdapterView.field_appId, paramAnonymousAdapterView.field_openId, 0, null, null);
                AppMethodBeat.o(34638);
              }
            });
          }
          AppMethodBeat.o(34639);
        }
      });
      this.HOD.setAdapter(this.HOE);
      findViewById(2131303967).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34634);
          ChattingSendDataToDeviceUI.this.onBackPressed();
          AppMethodBeat.o(34634);
        }
      });
      AppMethodBeat.o(34661);
      return;
      label562:
      this.HOG = this.ooz.getType();
      this.HJB = w.sQ(this.ooz.field_talker);
      this.HOH = this.ooz.field_content;
      int j;
      if ((this.HJB) && (this.ooz.field_isSend == 0))
      {
        localObject = this.ooz.field_content;
        j = this.ooz.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.HJB)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = bi.ym((String)localObject);
            }
          }
        }
        this.HOH = paramBundle;
      }
      if (this.ooz.getType() == 49)
      {
        this.dsB = k.b.vA(this.HOH);
        if (this.dsB == null)
        {
          ac.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.dsB.type == 3) {
          this.HOP = 16L;
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.HOP) });
        break;
        if (this.dsB.type == 4)
        {
          this.HOP = 8L;
        }
        else if (this.dsB.type == 5)
        {
          this.HOP = 32L;
        }
        else
        {
          if (this.dsB.type == 6)
          {
            paramBundle = com.tencent.mm.pluginsdk.d.a.aFF(this.dsB.hhG);
            if (paramBundle == null)
            {
              ac.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.HOP = paramBundle.longValue();
            continue;
          }
          if (this.dsB.type == 2)
          {
            this.HOP = 2L;
            paramBundle = com.tencent.mm.av.o.aFx().I(this.ooz);
            if (paramBundle != null) {
              this.HOH = paramBundle.hGY;
            }
          }
          else
          {
            ac.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.ooz.getType() == 3)
            {
              paramBundle = com.tencent.mm.av.o.aFx().I(this.ooz);
              if (paramBundle != null) {
                this.HOH = paramBundle.hGY;
              }
            }
            for (;;)
            {
              paramBundle = com.tencent.mm.pluginsdk.d.a.aFF(this.HOG);
              if (paramBundle != null) {
                break label1014;
              }
              ac.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.ooz.getType() == 43)
              {
                paramBundle = com.tencent.mm.modelvideo.o.aJy().DT(this.ooz.field_imgPath);
                if (paramBundle != null) {
                  this.HOH = paramBundle.aJK();
                }
              }
            }
            label1014:
            this.HOP = paramBundle.longValue();
          }
        }
      }
      paramBundle.ddK.msgId = this.foF;
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
      long l = this.foF;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      for (;;)
      {
        this.HOU = i;
        break;
        az.ayM();
        paramBundle = com.tencent.mm.model.c.awD().vP(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (!paramBundle.cKN()) {
            break label1237;
          }
          paramBundle = k.b.vA((String)localObject);
          if (paramBundle != null) {
            break label1176;
          }
          ac.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
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
      this.HOI.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34675);
    super.onDestroy();
    ac.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.HOS = false;
    if (this.HOL.booleanValue())
    {
      if (!this.HOR) {
        BX(2);
      }
      com.tencent.mm.sdk.b.a.GpY.d(this.HOZ);
      com.tencent.mm.sdk.b.a.GpY.d(this.HPa);
      fe localfe = new fe();
      com.tencent.mm.sdk.b.a.GpY.l(localfe);
      if (localfe.deY.deB) {
        ac.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
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
    flx();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.HOL.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.HOC.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.cc.a.eb(this);
      if (f != com.tencent.mm.cc.a.hR(this)) {
        break label85;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165490));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(2131165516))) {
      label85:
      do
      {
        this.HOC.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(34672);
        return;
      } while ((f != com.tencent.mm.cc.a.hT(this)) && (f != com.tencent.mm.cc.a.hS(this)) && (f != com.tencent.mm.cc.a.hU(this)));
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
    private List<Map<String, ChattingSendDataToDeviceUI.c>> HKk;
    private Map<String, ChattingSendDataToDeviceUI.c> HPj;
    private Context context;
    private com.tencent.mm.av.a.a.c pEd;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(34650);
      this.context = paramContext;
      this.HKk = new ArrayList();
      this$1 = new c.a();
      ChattingSendDataToDeviceUI.this.hKI = 2131233401;
      this.pEd = ChattingSendDataToDeviceUI.this.aFT();
      AppMethodBeat.o(34650);
    }
    
    public final void U(List<ChattingSendDataToDeviceUI.c> paramList)
    {
      AppMethodBeat.i(34651);
      this.HKk.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.HPj = new HashMap();
        this.HPj.put("hard_device_info", paramList.get(i));
        this.HKk.add(this.HPj);
        i += 1;
      }
      AppMethodBeat.o(34651);
    }
    
    public final ChattingSendDataToDeviceUI.c aaJ(int paramInt)
    {
      AppMethodBeat.i(34653);
      ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((Map)this.HKk.get(paramInt)).get("hard_device_info");
      AppMethodBeat.o(34653);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34652);
      int i = this.HKk.size();
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
      ChattingSendDataToDeviceUI.c localc = aaJ(paramInt);
      ac.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
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
        paramView.pHd = paramViewGroup.findViewById(2131298736);
        paramView.iMz = ((TextView)paramViewGroup.findViewById(2131302656));
        paramView.lzC = ((ImageView)paramViewGroup.findViewById(2131300880));
        paramView.HPi = ((TextView)paramViewGroup.findViewById(2131304561));
        paramView.HRd = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(2131304560));
        paramView.HRd.setVisibility(4);
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localc.deviceID, Integer.valueOf(paramInt));
        String str1 = localc.fBV;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.cc.a.eb(this.context);
        if ((f != com.tencent.mm.cc.a.hR(this.context)) && (f != com.tencent.mm.cc.a.hS(this.context))) {
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
        if ((f != com.tencent.mm.cc.a.hT(this.context)) && (f != com.tencent.mm.cc.a.hU(this.context))) {
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
      paramView.iMz.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.HPi.setText(localStringBuffer);
      }
      Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(aaJ(paramInt).deviceID)) {
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(aaJ(paramInt).deviceID);
      }
      if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).deE != null))
      {
        ac.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).deE });
        if (!((ChattingSendDataToDeviceUI.c)localObject).deE.equals("send_data_sending")) {
          break label756;
        }
        paramView.HPi.setText(this.context.getString(2131757314));
        paramView.HPi.setTextColor(this.context.getResources().getColor(2131100854));
        paramView.HRd.aaN(localc.progress);
        paramView.HRd.setVisibility(0);
        localObject = localc.deviceID;
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
        if (j < 100) {
          break label742;
        }
        i = 0;
        com.tencent.e.h.JZN.aV(new com.tencent.e.i.h()
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
            while (ChattingSendDataToDeviceUI.this.HOS)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                if (this.HPe.deE.equals("send_data_sucess"))
                {
                  j = i;
                  ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(34647);
                      ChattingSendDataToDeviceUI.a.1.this.HPd.HRd.aaN(0);
                      ChattingSendDataToDeviceUI.a.1.this.HPd.HRd.setVisibility(4);
                      ChattingSendDataToDeviceUI.a.1.this.HPd.HPi.setText(ChattingSendDataToDeviceUI.this.getText(2131757312));
                      ChattingSendDataToDeviceUI.a.1.this.HPd.HPi.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100854));
                      ChattingSendDataToDeviceUI.a.1.this.HPe.deE = "send_data_sucess";
                      ChattingSendDataToDeviceUI.a.1.this.HPe.progress = 0;
                      ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.HPe.deviceID, ChattingSendDataToDeviceUI.a.1.this.HPe);
                      ac.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.HPe.deviceID });
                      AppMethodBeat.o(34647);
                    }
                  });
                  AppMethodBeat.o(34649);
                  return;
                }
                j = i;
                if (!this.HPe.deE.equals("send_data_failed")) {
                  continue;
                }
                j = i;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34648);
                    ChattingSendDataToDeviceUI.a.1.this.HPd.HRd.aaN(0);
                    ChattingSendDataToDeviceUI.a.1.this.HPd.HRd.setVisibility(4);
                    ChattingSendDataToDeviceUI.a.1.this.HPd.HPi.setText(ChattingSendDataToDeviceUI.this.getText(2131757309));
                    ChattingSendDataToDeviceUI.a.1.this.HPd.HPi.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(2131100857));
                    ChattingSendDataToDeviceUI.a.1.this.HPe.deE = "send_data_failed";
                    ChattingSendDataToDeviceUI.a.1.this.HPe.progress = 0;
                    ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.HPe.deviceID, ChattingSendDataToDeviceUI.a.1.this.HPe);
                    ac.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.HPe.deviceID });
                    AppMethodBeat.o(34648);
                  }
                });
                AppMethodBeat.o(34649);
                return;
              }
              catch (Exception localException)
              {
                ac.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              paramView.HRd.aaN(i);
              j = i;
              this.HPe.progress = i;
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
        ac.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.fBV });
        com.tencent.mm.av.o.aFB().a(localc.iconUrl, paramView.lzC, this.pEd);
        paramView.pHd.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(34654);
        return paramViewGroup;
        label742:
        i = 500 / (100 - j);
        break;
        label756:
        if (((ChattingSendDataToDeviceUI.c)localObject).deE.equals("send_data_sucess"))
        {
          paramView.HPi.setText(this.context.getString(2131757312));
          paramView.HPi.setTextColor(this.context.getResources().getColor(2131100854));
          paramView.HRd.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).deE.equals("send_data_cancel"))
        {
          paramView.HPi.setText(this.context.getString(2131757305));
          paramView.HPi.setTextColor(this.context.getResources().getColor(2131100852));
          paramView.HRd.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).deE.equals("send_data_failed"))
        {
          paramView.HPi.setText(this.context.getString(2131757309));
          paramView.HPi.setTextColor(this.context.getResources().getColor(2131100857));
          paramView.HRd.setVisibility(4);
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
      paramb = (es)paramb;
      String str1 = paramb.deC.deE;
      String str2 = paramb.deC.cIZ;
      if (str1.equals("send_data_sending")) {
        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, paramb.deC.progress);
      }
      for (;;)
      {
        AppMethodBeat.o(34658);
        return true;
        if (str1.equals("send_data_failed")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
        } else if (str1.equals("send_data_sucess")) {
          ChattingSendDataToDeviceUI.this.aQc(str2);
        }
      }
    }
    
    private boolean o(com.tencent.mm.sdk.b.b paramb)
    {
      AppMethodBeat.i(34659);
      paramb = ((eo)paramb).der.ddE;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramb.size())
      {
        ChattingSendDataToDeviceUI.c localc = new ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this);
        localc.dda = ((String)((Map)paramb.get(i)).get("deviceType"));
        localc.deviceID = ((String)((Map)paramb.get(i)).get("deviceID"));
        localc.fBV = ((String)((Map)paramb.get(i)).get("displayName"));
        localc.iconUrl = ((String)((Map)paramb.get(i)).get("iconUrl"));
        localc.dez = ((String)((Map)paramb.get(i)).get("ability"));
        localc.HPn = ((String)((Map)paramb.get(i)).get("abilityInf"));
        if (((ChattingSendDataToDeviceUI.this.deA) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this)))) || ((!ChattingSendDataToDeviceUI.this.deA) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this)))))
        {
          if ((ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(localc.deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).deE != null))
          {
            localc.deE = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localc.deviceID)).deE;
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
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).U(ChattingSendDataToDeviceUI.l(ChattingSendDataToDeviceUI.this));
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
      if ((paramb instanceof eo))
      {
        bool = o(paramb);
        AppMethodBeat.o(34657);
        return bool;
      }
      if ((paramb instanceof es))
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
    String HPn;
    String dda;
    String deE;
    String deviceID;
    String dez;
    String fBV;
    String iconUrl;
    int progress;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */