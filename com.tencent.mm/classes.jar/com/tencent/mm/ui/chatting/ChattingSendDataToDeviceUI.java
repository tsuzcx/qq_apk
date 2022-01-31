package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.db;
import com.tencent.mm.h.a.dm;
import com.tencent.mm.h.a.dm.b;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.eu;
import com.tencent.mm.h.a.eu.a;
import com.tencent.mm.h.a.ia;
import com.tencent.mm.h.a.ia.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
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
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI
  extends MMActivity
{
  boolean bKP = false;
  private g.a bWy;
  private long djE;
  String fGv = null;
  String filePath = null;
  private String juQ;
  private bi pyF;
  private HorizontalListView sgN;
  private boolean vgB;
  boolean vhp = false;
  private HorizontalListView vkY;
  private b vkZ;
  private a vla;
  private int vlb;
  private String vlc = "";
  private RelativeLayout vld;
  private RelativeLayout vle;
  private TextView vlf;
  private Boolean vlg = Boolean.valueOf(false);
  private ChattingSendDataToDeviceUI.b vlh;
  private List<ChattingSendDataToDeviceUI.c> vli = new ArrayList();
  private List<f> vlj = new ArrayList();
  private long vlk = 0L;
  private boolean vll = true;
  boolean vlm = false;
  boolean vln = true;
  int vlo = 2;
  int vlp = -1;
  private HashMap<String, View> vlq = new HashMap();
  HashMap<String, ChattingSendDataToDeviceUI.c> vlr = new HashMap();
  Map<Integer, View> vls = new HashMap();
  Map<String, Integer> vlt = new HashMap();
  WXMediaMessage vlu = null;
  private com.tencent.mm.sdk.b.c vlv = new ChattingSendDataToDeviceUI.10(this);
  private com.tencent.mm.sdk.b.c vlw = new ChattingSendDataToDeviceUI.2(this);
  
  private static boolean a(ChattingSendDataToDeviceUI.c paramc, long paramLong)
  {
    boolean bool = true;
    if (paramLong == -1L) {}
    String str1;
    Object localObject;
    do
    {
      return false;
      str1 = paramc.bKO;
      au.Hx();
      localObject = com.tencent.mm.model.c.Fy().fd(paramLong);
    } while ((((cs)localObject).field_msgId == 0L) || (str1 == null));
    int i = ((bi)localObject).getType();
    String str2 = ((cs)localObject).field_content;
    if (((bi)localObject).aVK())
    {
      localObject = g.a.gp(str2);
      if (localObject == null)
      {
        y.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        return false;
      }
      if (((g.a)localObject).type == 3) {
        if (!str1.contains("wxmsg_music")) {
          break label151;
        }
      }
    }
    for (;;)
    {
      return bool;
      if (((g.a)localObject).type == 4) {
        bool = false;
      } else if (((g.a)localObject).type == 6)
      {
        if (str1.contains("wxmsg_file")) {}
      }
      else {
        label151:
        label222:
        label242:
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
                if (((g.a)localObject).type == 5)
                {
                  bool = a(((g.a)localObject).url, paramc);
                  break;
                }
              } while ((((g.a)localObject).type != 2) || (!str1.contains("wxmsg_image")));
              break;
              if (i != 3) {
                break label222;
              }
            } while (!str1.contains("wxmsg_image"));
            break;
            if (i != 48) {
              break label242;
            }
          } while (!str1.contains("wxmsg_poi"));
          break;
        } while ((i != 62) || (!str1.contains("wxmsg_video")));
      }
    }
  }
  
  private static boolean a(ChattingSendDataToDeviceUI.c paramc, String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return false;
    }
    Object localObject = new ia();
    ((ia)localObject).bQa.bJQ = paramString;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    paramString = ((ia)localObject).bQb.bQc;
    int i = paramString.tNr.sPI;
    y.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.bKO;
    if (localObject == null)
    {
      y.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
      return false;
    }
    if (i == 1) {
      if (!((String)localObject).contains("wxmsg_image")) {
        break label126;
      }
    }
    for (;;)
    {
      return bool;
      if (i == 4)
      {
        if (((String)localObject).contains("wxmsg_music")) {}
      }
      else
      {
        label126:
        do
        {
          do
          {
            bool = false;
            break;
            if (i != 15) {
              break label151;
            }
          } while (!((String)localObject).contains("wxmsg_video"));
          break;
        } while (i != 3);
        label151:
        bool = a(paramString.tNr.kSC, paramc);
      }
    }
  }
  
  private static boolean a(String paramString, ChattingSendDataToDeviceUI.c paramc)
  {
    boolean bool2 = false;
    Object localObject = paramc.bKO;
    paramc = paramc.vlJ;
    paramString = Uri.parse(paramString).getHost();
    boolean bool1 = bool2;
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
    try
    {
      localObject = new JSONObject(paramc).getJSONArray("wxmsg_url");
      int j = ((JSONArray)localObject).length();
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i < j)
        {
          bool1 = ((JSONArray)localObject).getString(i).equals(paramString);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", paramString, paramc, new Object[0]);
    }
  }
  
  private void cCT()
  {
    if ((this.vkZ == null) || (this.vlk == 0L))
    {
      if (this.vkZ == null) {}
      for (boolean bool = true;; bool = false)
      {
        y.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.vlk) });
        if (this.vle != null) {
          this.vle.setVisibility(8);
        }
        return;
      }
    }
    this.vlj = com.tencent.mm.pluginsdk.model.app.g.b(this, this.vlk, false);
    if ((!com.tencent.mm.pluginsdk.model.app.g.m(this, this.vlk)) && (this.vle != null)) {
      this.vle.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.vlj != null) && (this.vlj.size() > 0))
    {
      localObject1 = ap.cld().hc(this.vlk);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.vlj, new ChattingSendDataToDeviceUI.4(this, (List)localObject1));
      }
      localObject1 = this.vlj.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        localObject3 = new ab();
        ((ab)localObject3).appId = ((f)localObject2).field_appId;
        ((ab)localObject3).dtK = ((f)localObject2).field_appName;
        ((ab)localObject3).iconUrl = ((f)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.vlu == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.pyF.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.vlu = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.vlu.sdkVer = 620824064;
      if ((this.fGv != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.vhp = true;
      }
      label391:
      this.vkZ.vhp = this.vhp;
      this.vkZ.bc(localArrayList);
      this.vkZ.notifyDataSetChanged();
      return;
      localObject1 = localObject3;
      if (this.bWy != null) {
        if (this.bWy.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.bWy.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.bWy.dQU;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.bWy.dQu;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.bWy.dQV;
        }
        else if (this.bWy.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.bWy.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.bWy.dQV;
        }
        else if (this.bWy.type == 5)
        {
          localObject1 = new WXWebpageObject(this.bWy.url);
        }
        else
        {
          if (this.bWy.type == 6)
          {
            localObject3 = ap.avh().VQ(this.bWy.bFE);
            if (localObject3 != null)
            {
              y.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath;
              this.fGv = this.bWy.dQw;
            }
            while (q.Wb(this.filePath) != null)
            {
              com.tencent.mm.ui.base.h.bC(this, getString(R.l.chatting_send_apk_file));
              finish();
              break label391;
              y.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.bWy.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = com.tencent.mm.as.o.OJ().q(this.pyF);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = com.tencent.mm.as.o.OJ().me(((com.tencent.mm.as.e)localObject2).enq);
              if (bk.bl(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = com.tencent.mm.as.o.OJ().me(((com.tencent.mm.as.e)localObject2).ens);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.fGv = this.bWy.dQw;
            y.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.pyF.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = com.tencent.mm.as.o.OJ().q(this.pyF);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = com.tencent.mm.as.o.OJ().me(((com.tencent.mm.as.e)localObject2).enq);
              if (bk.bl(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = com.tencent.mm.as.o.OJ().me(((com.tencent.mm.as.e)localObject2).ens);
              }
              if (!bk.bl(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.fGv = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            y.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            au.Hx();
            localObject1 = com.tencent.mm.model.c.Fy().HO(this.pyF.field_content);
            localObject1 = new WXLocationObject(((bi.b)localObject1).lCJ, ((bi.b)localObject1).lCK);
            continue;
            localObject2 = new WXVideoObject();
            com.tencent.mm.modelvideo.o.Sr();
            localObject3 = t.nS(this.pyF.field_imgPath);
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
                  this.fGv = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void cCU()
  {
    Object localObject1 = new dm();
    Object localObject2;
    int i;
    if (this.bKP)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
      ((dm)localObject1).bJO.bJQ = this.juQ;
      ((dm)localObject1).bJO.bJR = ((String)localObject2);
      ((dm)localObject1).bJO.bJS = i;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      if (!((dm)localObject1).bJP.bJy) {
        return;
      }
      localObject1 = ((dm)localObject1).bJP.bJT;
      int j = ((List)localObject1).size();
      i = 0;
      label107:
      if (i >= j) {
        break label364;
      }
      localObject2 = new ChattingSendDataToDeviceUI.c(this);
      ((ChattingSendDataToDeviceUI.c)localObject2).bJp = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((ChattingSendDataToDeviceUI.c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((ChattingSendDataToDeviceUI.c)localObject2).dtK = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((ChattingSendDataToDeviceUI.c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((ChattingSendDataToDeviceUI.c)localObject2).bKO = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((ChattingSendDataToDeviceUI.c)localObject2).vlJ = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.bKP) || (!a((ChattingSendDataToDeviceUI.c)localObject2, this.juQ))) {
        break label330;
      }
      this.vli.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label107;
      ((dm)localObject1).bJO.bIt = this.djE;
      break;
      label330:
      if ((!this.bKP) && (a((ChattingSendDataToDeviceUI.c)localObject2, this.djE))) {
        this.vli.add(localObject2);
      }
    }
    label364:
    if (this.vli.size() > 0)
    {
      y.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.vla.bc(this.vli);
      if (this.vla.getCount() > 0)
      {
        this.vlf.setText(R.l.chatting_available_device);
        this.vll = false;
      }
      this.vla.notifyDataSetChanged();
    }
  }
  
  private void qu(int paramInt)
  {
    if (this.bKP)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vlp), "", Integer.valueOf(2), Integer.valueOf(this.vlo) });
      return;
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    int i = this.vlp;
    long l = this.djE;
    String str2 = "";
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fy().fd(l);
    String str1;
    if (((cs)localObject).field_msgId == 0L) {
      str1 = "";
    }
    for (;;)
    {
      localh.f(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), str1, Integer.valueOf(1), Integer.valueOf(this.vlo) });
      return;
      String str3 = ((cs)localObject).field_content;
      str1 = str2;
      if (((bi)localObject).getType() == 49)
      {
        localObject = g.a.gp(str3);
        str1 = str2;
        if (localObject != null)
        {
          str1 = str2;
          if (((g.a)localObject).type == 6) {
            str1 = ((g.a)localObject).dQw;
          }
        }
      }
    }
  }
  
  public final ChattingSendDataToDeviceUI.b cCV()
  {
    if (this.vlh == null) {
      this.vlh = new ChattingSendDataToDeviceUI.b(this);
    }
    return this.vlh;
  }
  
  protected final int getLayoutId()
  {
    return R.i.chatting_send_data_to_device_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
  }
  
  public void onBackPressed()
  {
    if (this.vlq.size() > 0)
    {
      com.tencent.mm.ui.widget.a.c.a locala = new com.tencent.mm.ui.widget.a.c.a(this);
      locala.Iq(R.l.chatting_send_cancel_tips);
      locala.Is(R.l.chatting_send_dialog_cancel).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).keySet().iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            db localdb = new db();
            localdb.bJl.bwK = str;
            com.tencent.mm.sdk.b.a.udP.m(localdb);
          }
          ChattingSendDataToDeviceUI.this.finish();
        }
      });
      locala.It(R.l.chatting_send_continue).b(new ChattingSendDataToDeviceUI.6(this));
      locala.aoP().show();
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = new dm();
    if (this.bKP)
    {
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
      paramConfiguration.bJO.bJQ = this.juQ;
      paramConfiguration.bJO.bJR = str;
      paramConfiguration.bJO.bJS = i;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.udP.m(paramConfiguration);
      if ((paramConfiguration.bJP.bJy) && (this.vli.size() > 0))
      {
        y.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.vli.size()) });
        this.vla.bc(this.vli);
        if (this.vla.getCount() > 0)
        {
          this.vlf.setText(R.l.chatting_available_device);
          this.vll = false;
        }
        this.vla.notifyDataSetChanged();
      }
      return;
      paramConfiguration.bJO.bIt = this.djE;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    super.onCreate(paramBundle);
    this.bKP = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    y.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.bKP);
    if (!this.bKP)
    {
      this.djE = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.djE != -1L)
      {
        au.Hx();
        this.pyF = com.tencent.mm.model.c.Fy().fd(this.djE);
        if ((this.pyF != null) && (this.pyF.field_msgId != 0L)) {
          break label531;
        }
      }
    }
    this.vlo = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.vlm = false;
    setFinishOnTouchOutside(true);
    this.vli.clear();
    this.vlr.clear();
    this.vld = ((RelativeLayout)findViewById(R.h.newtork_device));
    paramBundle = new do();
    label252:
    Object localObject;
    if (this.bKP)
    {
      this.juQ = getIntent().getExtras().getString("sns_local_id");
      if (this.juQ != null)
      {
        paramBundle.bJZ.bJQ = this.juQ;
        y.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.juQ });
      }
      com.tencent.mm.sdk.b.a.udP.m(paramBundle);
      if (!paramBundle.bKa.bJy) {
        break label1230;
      }
      this.vlg = Boolean.valueOf(true);
      com.tencent.mm.sdk.b.a.udP.c(this.vlv);
      com.tencent.mm.sdk.b.a.udP.c(this.vlw);
      this.vld.setVisibility(0);
      this.sgN = ((HorizontalListView)findViewById(R.h.listview));
      this.vlf = ((TextView)findViewById(R.h.available_device));
      this.vlf.setText(R.l.chatting_searching_available_device);
      this.vla = new a(this);
      this.sgN.setAdapter(this.vla);
      this.sgN.setOnItemClickListener(new ChattingSendDataToDeviceUI.1(this));
      cCU();
      if (!this.bKP) {
        break label1040;
      }
      paramBundle = this.juQ;
      if (paramBundle == null) {
        break label1035;
      }
      localObject = new ia();
      ((ia)localObject).bQa.bJQ = paramBundle;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      i = ((ia)localObject).bQb.bQc.tNr.sPI;
      if (i != 1) {
        break label1003;
      }
      i = 3;
      label454:
      this.vlp = i;
      qu(1);
    }
    for (;;)
    {
      this.vle = ((RelativeLayout)findViewById(R.h.application));
      this.vkY = ((HorizontalListView)findViewById(R.h.app_listview));
      this.vkZ = new b(this);
      this.vkY.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          y.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)
          {
            paramAnonymousAdapterView = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
            paramAnonymousAdapterView.addFlags(67108864);
            paramAnonymousAdapterView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(ChattingSendDataToDeviceUI.this));
            ChattingSendDataToDeviceUI.this.startActivity(paramAnonymousAdapterView);
          }
          do
          {
            return;
            if ((ChattingSendDataToDeviceUI.this.vhp) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 2))
            {
              if ((ChattingSendDataToDeviceUI.this.filePath == null) || (ChattingSendDataToDeviceUI.this.fGv == null))
              {
                com.tencent.mm.ui.base.h.bC(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.l.download_no_match_msg));
                return;
              }
              com.tencent.mm.pluginsdk.ui.tools.a.b(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.fGv.toLowerCase(), 1);
              return;
            }
          } while ((paramAnonymousInt < 0) || (paramAnonymousInt >= paramAnonymousAdapterView.getAdapter().getCount() - 1));
          paramAnonymousAdapterView = (f)ChattingSendDataToDeviceUI.i(ChattingSendDataToDeviceUI.this).get(paramAnonymousInt);
          if (!com.tencent.mm.pluginsdk.model.app.g.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView))
          {
            com.tencent.mm.ui.base.h.bC(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.l.chatting_send_app_not_installed));
            paramAnonymousAdapterView.field_status = 4;
            ap.brn().a(paramAnonymousAdapterView, new String[0]);
            ChattingSendDataToDeviceUI.j(ChattingSendDataToDeviceUI.this);
            return;
          }
          com.tencent.mm.cg.a.post(new ChattingSendDataToDeviceUI.3.1(this, paramAnonymousAdapterView));
        }
      });
      this.vkY.setAdapter(this.vkZ);
      return;
      label531:
      this.vlb = this.pyF.getType();
      this.vgB = com.tencent.mm.model.s.fn(this.pyF.field_talker);
      this.vlc = this.pyF.field_content;
      int j;
      if ((this.vgB) && (this.pyF.field_isSend == 0))
      {
        localObject = this.pyF.field_content;
        j = this.pyF.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.vgB)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = bd.iJ((String)localObject);
            }
          }
        }
        this.vlc = paramBundle;
      }
      if (this.pyF.getType() == 49)
      {
        this.bWy = g.a.gp(this.vlc);
        if (this.bWy == null)
        {
          y.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.bWy.type == 3) {
          this.vlk = 16L;
        }
      }
      for (;;)
      {
        y.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.vlk) });
        break;
        if (this.bWy.type == 4)
        {
          this.vlk = 8L;
        }
        else if (this.bWy.type == 5)
        {
          this.vlk = 32L;
        }
        else
        {
          if (this.bWy.type == 6)
          {
            paramBundle = b.a.Vx(this.bWy.dQw);
            if (paramBundle == null)
            {
              y.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.vlk = paramBundle.longValue();
            continue;
          }
          if (this.bWy.type == 2)
          {
            this.vlk = 2L;
            paramBundle = com.tencent.mm.as.o.OJ().q(this.pyF);
            if (paramBundle != null) {
              this.vlc = paramBundle.enA;
            }
          }
          else
          {
            y.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.pyF.getType() == 3)
            {
              paramBundle = com.tencent.mm.as.o.OJ().q(this.pyF);
              if (paramBundle != null) {
                this.vlc = paramBundle.enA;
              }
            }
            for (;;)
            {
              paramBundle = b.a.Vx(this.vlb);
              if (paramBundle != null) {
                break label978;
              }
              y.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.pyF.getType() == 43)
              {
                paramBundle = com.tencent.mm.modelvideo.o.Sr().nQ(this.pyF.field_imgPath);
                if (paramBundle != null) {
                  this.vlc = paramBundle.SD();
                }
              }
            }
            label978:
            this.vlk = paramBundle.longValue();
          }
        }
      }
      paramBundle.bJZ.bIt = this.djE;
      break label252;
      label1003:
      if (i == 4)
      {
        i = 1;
        break label454;
      }
      if (i == 15)
      {
        i = 6;
        break label454;
      }
      if (i == 3)
      {
        i = 5;
        break label454;
      }
      label1035:
      i = 0;
      break label454;
      label1040:
      long l = this.djE;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      label1200:
      for (;;)
      {
        this.vlp = i;
        break;
        au.Hx();
        paramBundle = com.tencent.mm.model.c.Fy().fd(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (!paramBundle.aVK()) {
            break label1200;
          }
          paramBundle = g.a.gp((String)localObject);
          if (paramBundle != null) {
            break label1139;
          }
          y.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        }
        label1139:
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
      label1230:
      this.vld.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.vln = false;
    if (this.vlg.booleanValue())
    {
      if (!this.vlm) {
        qu(2);
      }
      com.tencent.mm.sdk.b.a.udP.d(this.vlv);
      com.tencent.mm.sdk.b.a.udP.d(this.vlw);
      eu localeu = new eu();
      com.tencent.mm.sdk.b.a.udP.m(localeu);
      if (localeu.bLn.bKQ) {
        y.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    cCT();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.vlg.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.sgN.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.cb.a.cJ(this);
      if (f != 1.125F) {
        break label72;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(R.f.LittlePadding));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(R.f.NormalPadding))) {
      label72:
      do
      {
        this.sgN.setLayoutParams(localLayoutParams);
        return;
      } while ((f != 1.375F) && (f != 1.25F) && (f != 1.625F));
    }
  }
  
  private final class a
    extends BaseAdapter
  {
    private Context context;
    private com.tencent.mm.as.a.a.c jAJ;
    private List<Map<String, ChattingSendDataToDeviceUI.c>> vho;
    private Map<String, ChattingSendDataToDeviceUI.c> vlF;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
      this.vho = new ArrayList();
      this$1 = new com.tencent.mm.as.a.a.c.a();
      ChattingSendDataToDeviceUI.this.eru = R.g.my_device_default_icon;
      this.jAJ = ChattingSendDataToDeviceUI.this.OV();
    }
    
    public final ChattingSendDataToDeviceUI.c GS(int paramInt)
    {
      return (ChattingSendDataToDeviceUI.c)((Map)this.vho.get(paramInt)).get("hard_device_info");
    }
    
    public final void bc(List<ChattingSendDataToDeviceUI.c> paramList)
    {
      this.vho.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.vlF = new HashMap();
        this.vlF.put("hard_device_info", paramList.get(i));
        this.vho.add(this.vlF);
        i += 1;
      }
    }
    
    public final int getCount()
    {
      return this.vho.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ChattingSendDataToDeviceUI.c localc = GS(paramInt);
      y.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      int i;
      int j;
      StringBuffer localStringBuffer;
      float f;
      label255:
      int k;
      label258:
      String str2;
      if (ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt)) == null)
      {
        paramView = new as();
        paramViewGroup = View.inflate(paramViewGroup.getContext(), R.i.send_data_to_device_item, null);
        paramView.jDJ = paramViewGroup.findViewById(R.h.container);
        paramView.fhD = ((TextView)paramViewGroup.findViewById(R.h.nameTV));
        paramView.gSx = ((ImageView)paramViewGroup.findViewById(R.h.iconIV));
        paramView.vlE = ((TextView)paramViewGroup.findViewById(R.h.sendStateTV));
        paramView.vnu = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(R.h.sendProgress));
        paramView.vnu.setVisibility(4);
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localc.deviceID, Integer.valueOf(paramInt));
        String str1 = localc.dtK;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.cb.a.cJ(this.context);
        if ((f != 1.125F) && (f != 1.25F)) {
          break label365;
        }
        i = 6;
        k = 0;
        if (k >= str1.length()) {
          break label408;
        }
        int m = Character.codePointAt(str1, k);
        str2 = str1.substring(k, k + 1);
        if ((m < 0) || (m > 255)) {
          break label387;
        }
        j += 1;
        label309:
        if (j > i) {
          break label396;
        }
        localObject = ((StringBuffer)localObject).append(str2);
      }
      for (;;)
      {
        k += 1;
        break label258;
        paramViewGroup = (View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt));
        paramView = (as)paramViewGroup.getTag();
        break;
        label365:
        if ((f != 1.375F) && (f != 1.625F)) {
          break label255;
        }
        i = 5;
        break label255;
        label387:
        j += 2;
        break label309;
        label396:
        localStringBuffer = localStringBuffer.append(str2);
      }
      label408:
      paramView.fhD.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.vlE.setText(localStringBuffer);
      }
      Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(GS(paramInt).deviceID)) {
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(GS(paramInt).deviceID);
      }
      if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).bKT != null))
      {
        y.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).bKT });
        if (!((ChattingSendDataToDeviceUI.c)localObject).bKT.equals("send_data_sending")) {
          break label732;
        }
        paramView.vlE.setText(this.context.getString(R.l.chatting_sending));
        paramView.vlE.setTextColor(this.context.getResources().getColor(R.e.send_data_sending));
        paramView.vnu.setProgress(localc.progress);
        paramView.vnu.setVisibility(0);
        localObject = localc.deviceID;
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
        if (j < 100) {
          break label718;
        }
        i = 0;
        com.tencent.mm.sdk.f.e.b(new ChattingSendDataToDeviceUI.a.1(this, j, (ChattingSendDataToDeviceUI.c)localObject, paramView, i), "SendDataState_handler").start();
      }
      for (;;)
      {
        y.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.dtK });
        com.tencent.mm.as.o.ON().a(localc.iconUrl, paramView.gSx, this.jAJ);
        paramView.jDJ.setTag(Integer.valueOf(paramInt));
        return paramViewGroup;
        label718:
        i = 500 / (100 - j);
        break;
        label732:
        if (((ChattingSendDataToDeviceUI.c)localObject).bKT.equals("send_data_sucess"))
        {
          paramView.vlE.setText(this.context.getString(R.l.chatting_send_success));
          paramView.vlE.setTextColor(this.context.getResources().getColor(R.e.send_data_sending));
          paramView.vnu.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).bKT.equals("send_data_cancel"))
        {
          paramView.vlE.setText(this.context.getString(R.l.chatting_send_cancel));
          paramView.vlE.setTextColor(this.context.getResources().getColor(R.e.send_data_cancel));
          paramView.vnu.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).bKT.equals("send_data_failed"))
        {
          paramView.vlE.setText(this.context.getString(R.l.chatting_send_failed));
          paramView.vlE.setTextColor(this.context.getResources().getColor(R.e.send_state_text_failed));
          paramView.vnu.setVisibility(4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */