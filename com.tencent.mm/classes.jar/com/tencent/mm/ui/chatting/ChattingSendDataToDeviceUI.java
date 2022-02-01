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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ej;
import com.tencent.mm.autogen.a.ej.b;
import com.tencent.mm.autogen.a.ev;
import com.tencent.mm.autogen.a.ev.b;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.fn;
import com.tencent.mm.autogen.a.fn.a;
import com.tencent.mm.autogen.a.fq;
import com.tencent.mm.autogen.a.fq.b;
import com.tencent.mm.autogen.a.fr;
import com.tencent.mm.autogen.a.fr.a;
import com.tencent.mm.autogen.a.gd;
import com.tencent.mm.autogen.a.gd.a;
import com.tencent.mm.autogen.a.lz;
import com.tencent.mm.autogen.a.lz.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLocationObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
  private boolean aedO;
  boolean aeeI;
  private Boolean aejA;
  private b aejB;
  private List<ae> aejC;
  private List<g> aejD;
  private long aejE;
  private boolean aejF;
  boolean aejG;
  boolean aejH;
  int aejI;
  int aejJ;
  private HashMap<String, View> aejK;
  private HashMap<String, ae> aejL;
  private Map<Integer, View> aejM;
  private Map<String, Integer> aejN;
  private IListener aejO;
  private IListener aejP;
  private HorizontalListView aejr;
  private HorizontalListView aejs;
  private b aejt;
  private a aeju;
  private int aejv;
  private String aejw;
  private RelativeLayout aejx;
  private RelativeLayout aejy;
  private TextView aejz;
  String filePath;
  boolean hFS;
  private k.b hWV;
  String lPJ;
  private long lul;
  WXMediaMessage vsv;
  private cc wPy;
  private String yqW;
  
  public ChattingSendDataToDeviceUI()
  {
    AppMethodBeat.i(34660);
    this.aejw = "";
    this.aejA = Boolean.FALSE;
    this.aejC = new ArrayList();
    this.aejD = new ArrayList();
    this.aejE = 0L;
    this.aejF = true;
    this.hFS = false;
    this.aejG = false;
    this.aejH = true;
    this.aejI = 2;
    this.aejJ = -1;
    this.aejK = new HashMap();
    this.aejL = new HashMap();
    this.aejM = new HashMap();
    this.aejN = new HashMap();
    this.vsv = null;
    this.filePath = null;
    this.lPJ = null;
    this.aeeI = false;
    this.aejO = new IListener(f.hfK) {};
    this.aejP = new IListener(f.hfK) {};
    AppMethodBeat.o(34660);
  }
  
  private void Lk(int paramInt)
  {
    AppMethodBeat.i(34662);
    if (this.hFS)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.aejJ), "", Integer.valueOf(2), Integer.valueOf(this.aejI) });
      AppMethodBeat.o(34662);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.aejJ), zH(this.lul), Integer.valueOf(1), Integer.valueOf(this.aejI) });
    AppMethodBeat.o(34662);
  }
  
  private static boolean a(ae paramae, long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(253740);
    if (paramLong == -1L)
    {
      AppMethodBeat.o(253740);
      return false;
    }
    String str1 = paramae.hFR;
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.bzD().sl(paramLong);
    if ((localObject == null) || (((fi)localObject).field_msgId == 0L) || ((!paramae.hEm) && (str1 == null)) || ((paramae.hEm) && ((paramae.hFU == null) || (paramae.hFU.isEmpty()))))
    {
      AppMethodBeat.o(253740);
      return false;
    }
    int i = ((cc)localObject).getType();
    String str2 = ((fi)localObject).field_content;
    boolean bool1;
    if (((cc)localObject).fxR())
    {
      localObject = k.b.Hf(str2);
      if (localObject == null)
      {
        Log.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        AppMethodBeat.o(253740);
        return false;
      }
      if ((((k.b)localObject).type == 3) || (((k.b)localObject).type == 76)) {
        if (!paramae.hEm)
        {
          bool1 = bool2;
          if (str1.contains("wxmsg_music")) {
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(253740);
      return bool1;
      bool1 = bool2;
      if (paramae.Ld(1))
      {
        bool1 = true;
        continue;
        if (((k.b)localObject).type == 4)
        {
          bool1 = bool2;
          if (!paramae.hEm) {
            bool1 = bool2;
          }
        }
        else if (((k.b)localObject).type == 6)
        {
          if (!paramae.hEm)
          {
            bool1 = bool2;
            if (str1.contains("wxmsg_file")) {
              bool1 = true;
            }
          }
          else
          {
            bool1 = bool2;
            if (paramae.Ld(4)) {
              bool1 = true;
            }
          }
        }
        else if (((k.b)localObject).type == 5)
        {
          if (!paramae.hEm)
          {
            bool1 = a(((k.b)localObject).url, paramae);
          }
          else
          {
            bool1 = bool2;
            if (paramae.Ld(5)) {
              bool1 = true;
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (((k.b)localObject).type == 2)
          {
            bool1 = bool2;
            if (!paramae.hEm)
            {
              bool1 = bool2;
              if (str1.contains("wxmsg_image"))
              {
                bool1 = true;
                continue;
                if (i == 3)
                {
                  if (!paramae.hEm)
                  {
                    bool1 = bool2;
                    if (str1.contains("wxmsg_image")) {
                      bool1 = true;
                    }
                  }
                  else
                  {
                    bool1 = bool2;
                    if (paramae.Ld(3)) {
                      bool1 = true;
                    }
                  }
                }
                else if (i == 48)
                {
                  if (!paramae.hEm)
                  {
                    bool1 = bool2;
                    if (str1.contains("wxmsg_poi")) {
                      bool1 = true;
                    }
                  }
                  else
                  {
                    bool1 = bool2;
                    if (paramae.Ld(2)) {
                      bool1 = true;
                    }
                  }
                }
                else if (i == 43)
                {
                  bool1 = bool2;
                  if (paramae.hEm)
                  {
                    bool1 = bool2;
                    if (paramae.Ld(6)) {
                      bool1 = true;
                    }
                  }
                }
                else
                {
                  bool1 = bool2;
                  if (i == 62)
                  {
                    bool1 = bool2;
                    if (!paramae.hEm)
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
    }
  }
  
  private static boolean a(ae paramae, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(253735);
    if (paramString == null)
    {
      AppMethodBeat.o(253735);
      return false;
    }
    Object localObject = new lz();
    ((lz)localObject).hNQ.hES = paramString;
    ((lz)localObject).publish();
    paramString = ((lz)localObject).hNR.hNS;
    int i = paramString.ContentObj.Zpq;
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramae.hFR;
    if (localObject == null)
    {
      Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
      AppMethodBeat.o(253735);
      return false;
    }
    if (i == 1) {
      if (!((String)localObject).contains("wxmsg_image")) {
        break label153;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(253735);
      return bool;
      if ((i == 4) || (i == 42))
      {
        if (((String)localObject).contains("wxmsg_music")) {}
      }
      else
      {
        label153:
        label178:
        do
        {
          do
          {
            bool = false;
            break;
            if (i != 15) {
              break label178;
            }
          } while (!((String)localObject).contains("wxmsg_video"));
          break;
          if (i == 3)
          {
            bool = a(paramString.ContentObj.Url, paramae);
            break;
          }
        } while (i != 5);
        bool = a(paramString.ContentObj.Url, paramae);
      }
    }
  }
  
  private static boolean a(String paramString, ae paramae)
  {
    bool2 = false;
    AppMethodBeat.i(253733);
    Object localObject = paramae.hFR;
    paramae = paramae.ysj;
    paramString = Uri.parse(paramString).getHost();
    bool1 = bool2;
    if (paramae != null)
    {
      bool1 = bool2;
      if (paramae.length() > 0)
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
        localObject = new JSONObject(paramae).getJSONArray("wxmsg_url");
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
        Log.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", paramString, paramae, new Object[0]);
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(253733);
      return bool1;
      i += 1;
    }
  }
  
  private void jpG()
  {
    AppMethodBeat.i(34665);
    if ((this.aejt == null) || (this.aejE == 0L))
    {
      if (this.aejt == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.aejE) });
        if (this.aejy != null) {
          this.aejy.setVisibility(8);
        }
        AppMethodBeat.o(34665);
        return;
      }
    }
    this.aejD = com.tencent.mm.pluginsdk.model.app.h.c(this, this.aejE, false);
    if ((!com.tencent.mm.pluginsdk.model.app.h.x(this, this.aejE)) && (this.aejy != null)) {
      this.aejy.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.aejD != null) && (this.aejD.size() > 0))
    {
      localObject1 = as.iIK().yj(this.aejE);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.aejD, new Comparator() {});
      }
      localObject1 = this.aejD.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (g)((Iterator)localObject1).next();
        localObject3 = new ab();
        ((ab)localObject3).appId = ((g)localObject2).field_appId;
        ((ab)localObject3).displayName = ((g)localObject2).field_appName;
        ((ab)localObject3).iconUrl = ((g)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.vsv == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.wPy.getType())
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.vsv = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.vsv.sdkVer = 638058496;
      if ((this.lPJ != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.aeeI = true;
      }
      label403:
      this.aejt.aeeI = this.aeeI;
      this.aejt.bz(localArrayList);
      this.aejt.notifyDataSetChanged();
      AppMethodBeat.o(34665);
      return;
      localObject1 = localObject3;
      if (this.hWV != null) {
        if (this.hWV.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.hWV.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.hWV.nRx;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.hWV.nRc;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.hWV.nRy;
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)this.hWV.aK(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            ((WXMusicObject)localObject1).songAlbumUrl = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songAlbumUrl;
            ((WXMusicObject)localObject1).songLyric = ((com.tencent.mm.pluginsdk.ui.tools.b)localObject2).songLyric;
          }
        }
        else if (this.hWV.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.hWV.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.hWV.nRy;
        }
        else if (this.hWV.type == 5)
        {
          localObject1 = new WXWebpageObject(this.hWV.url);
        }
        else
        {
          if (this.hWV.type == 6)
          {
            localObject3 = as.cWJ().bpI(this.hWV.hzM);
            if (localObject3 != null)
            {
              Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
              this.lPJ = this.hWV.nRe;
            }
            while (com.tencent.mm.pluginsdk.model.app.v.bpY(this.filePath) != null)
            {
              k.cZ(this, getString(R.l.gzy));
              finish();
              break label403;
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.hWV.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = r.bKa().af(this.wPy);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject2).oGr);
              if (Util.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject2).oGt);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.lPJ = this.hWV.nRe;
            Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.wPy.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = r.bKa().af(this.wPy);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject2).oGr);
              if (Util.isNullOrNil(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject2).oGt);
              }
              if (!Util.isNullOrNil(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.lPJ = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            bh.bCz();
            localObject1 = com.tencent.mm.model.c.bzD().aLV(this.wPy.field_content);
            localObject1 = new WXLocationObject(((cc.c)localObject1).KbW, ((cc.c)localObject1).KbX);
            continue;
            localObject2 = new WXVideoObject();
            com.tencent.mm.modelvideo.v.bOh();
            localObject3 = aa.PX(this.wPy.field_imgPath);
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
                  this.lPJ = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void jpH()
  {
    AppMethodBeat.i(34666);
    Object localObject1 = new ev();
    Object localObject2;
    Object localObject3;
    if (this.hFS)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      localObject3 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      ((ev)localObject1).hEQ.hES = this.yqW;
      ((ev)localObject1).hEQ.hET = ((String)localObject2);
      ((ev)localObject1).hEQ.hEU = ((String)localObject3);
    }
    for (;;)
    {
      ((ev)localObject1).publish();
      if (!((ev)localObject1).hER.hEn) {
        break label637;
      }
      if (this.hFS) {
        break;
      }
      localObject2 = ((ev)localObject1).hER.hEW;
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "MMIotDeviceInfo size =" + ((List)localObject2).size());
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject3 = new ae();
        ((ae)localObject3).deviceID = ((dlf)((List)localObject2).get(i)).ZQS;
        ((ae)localObject3).hFT = ((dlf)((List)localObject2).get(i)).aaRi;
        ((ae)localObject3).displayName = ((dlf)((List)localObject2).get(i)).nickname;
        ((ae)localObject3).iconUrl = ((dlf)((List)localObject2).get(i)).icon_url;
        ((ae)localObject3).hFU = ((dlf)((List)localObject2).get(i)).aaRj;
        ((ae)localObject3).hEm = true;
        if (a((ae)localObject3, this.lul))
        {
          Log.d("MicroMsg.ChattingSendDataToDeviceUI", "need show  ");
          this.aejC.add(localObject3);
        }
        i += 1;
      }
      ((ev)localObject1).hEQ.msgId = this.lul;
    }
    localObject1 = ((ev)localObject1).hER.hEV;
    int j = ((List)localObject1).size();
    int i = 0;
    if (i < j)
    {
      localObject2 = new ae();
      ((ae)localObject2).hEr = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((ae)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((ae)localObject2).displayName = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((ae)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((ae)localObject2).hFR = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((ae)localObject2).ysj = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((this.hFS) && (a((ae)localObject2, this.yqW))) {
        this.aejC.add(localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((!this.hFS) && (a((ae)localObject2, this.lul))) {
          this.aejC.add(localObject2);
        }
      }
    }
    if (this.aejC.size() > 0)
    {
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.aeju.bz(this.aejC);
      if (this.aeju.getCount() > 0)
      {
        this.aejz.setText(R.l.gwR);
        this.aejF = false;
      }
      this.aeju.notifyDataSetChanged();
    }
    label637:
    AppMethodBeat.o(34666);
  }
  
  private static String zH(long paramLong)
  {
    AppMethodBeat.i(34663);
    String str2 = "";
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.bzD().sl(paramLong);
    if ((localObject == null) || (((fi)localObject).field_msgId == 0L))
    {
      AppMethodBeat.o(34663);
      return "";
    }
    String str3 = ((fi)localObject).field_content;
    String str1 = str2;
    if (((cc)localObject).getType() == 49)
    {
      localObject = k.b.Hf(str3);
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (((k.b)localObject).type == 6) {
          str1 = ((k.b)localObject).nRe;
        }
      }
    }
    AppMethodBeat.o(34663);
    return str1;
  }
  
  public final void bAC(final String paramString)
  {
    AppMethodBeat.i(34670);
    try
    {
      final int i = ((Integer)this.aejN.get(paramString)).intValue();
      final au localau = (au)((View)this.aejM.get(Integer.valueOf(i))).getTag();
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(localau.aemr.getProgress()), paramString });
      final ae localae = (ae)this.aejL.get(paramString);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34643);
          localau.aemr.setVisibility(0);
          localau.aejX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_sending));
          localau.aejX.setText(ChattingSendDataToDeviceUI.this.getText(R.l.gzH));
          localae.hFX = "send_data_sending";
          AppMethodBeat.o(34643);
        }
      });
      final int j = Math.abs(localau.aemr.getProgress());
      localae.progress = j;
      if (j >= 100) {}
      for (i = 0;; i = 500 / (100 - j))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
        com.tencent.threadpool.h.ahAA.bp(new com.tencent.threadpool.i.h()
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
                    ChattingSendDataToDeviceUI.8.this.aejS.aemr.aBT(0);
                    ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(ChattingSendDataToDeviceUI.8.this.rKU);
                    ChattingSendDataToDeviceUI.8.this.aejS.aemr.setVisibility(4);
                    ChattingSendDataToDeviceUI.8.this.aejS.aejX.setText(ChattingSendDataToDeviceUI.this.getText(R.l.gzF));
                    ChattingSendDataToDeviceUI.8.this.aejS.aejX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_sending));
                    ChattingSendDataToDeviceUI.8.this.aejT.hFX = "send_data_sucess";
                    ChattingSendDataToDeviceUI.8.this.aejT.progress = 0;
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
              localau.aemr.aBT(i);
              i += 1;
              j = i;
              Thread.sleep(i);
            }
          }
        });
        this.aejL.put(localae.deviceID, localae);
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
    return R.i.ghx;
  }
  
  public final b jpI()
  {
    AppMethodBeat.i(34676);
    if (this.aejB == null) {
      this.aejB = new b();
    }
    b localb = this.aejB;
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
    if (this.aejK.size() > 0)
    {
      com.tencent.mm.ui.widget.a.e.a locala = new com.tencent.mm.ui.widget.a.e.a(this);
      locala.aEO(R.l.gzA);
      locala.aER(R.l.gzC).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34641);
          paramAnonymousDialogInterface = ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).keySet().iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            ej localej = new ej();
            localej.hEj.hEl = str;
            localej.publish();
          }
          ChattingSendDataToDeviceUI.this.finish();
          AppMethodBeat.o(34641);
        }
      });
      locala.aES(R.l.gzB).d(new ChattingSendDataToDeviceUI.6(this));
      locala.jHH().show();
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
    paramConfiguration = new ev();
    if (this.hFS)
    {
      String str1 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      String str2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
      paramConfiguration.hEQ.hES = this.yqW;
      paramConfiguration.hEQ.hET = str1;
      paramConfiguration.hEQ.hEU = str2;
    }
    for (;;)
    {
      paramConfiguration.publish();
      if ((paramConfiguration.hER.hEn) && (this.aejC.size() > 0))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.aejC.size()) });
        this.aeju.bz(this.aejC);
        if (this.aeju.getCount() > 0)
        {
          this.aejz.setText(R.l.gwR);
          this.aejF = false;
        }
        this.aeju.notifyDataSetChanged();
      }
      AppMethodBeat.o(34664);
      return;
      paramConfiguration.hEQ.msgId = this.lul;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 6;
    AppMethodBeat.i(34661);
    super.onCreate(paramBundle);
    this.hFS = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.hFS);
    if (!this.hFS)
    {
      this.lul = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.lul != -1L)
      {
        bh.bCz();
        this.wPy = com.tencent.mm.model.c.bzD().sl(this.lul);
        if ((this.wPy != null) && (this.wPy.field_msgId != 0L)) {
          break label546;
        }
      }
    }
    this.aejI = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.aejG = false;
    setFinishOnTouchOutside(true);
    this.aejC.clear();
    this.aejL.clear();
    this.aejx = ((RelativeLayout)findViewById(R.h.fRp));
    paramBundle = new ex();
    label258:
    Object localObject;
    int i;
    if (this.hFS)
    {
      this.yqW = getIntent().getExtras().getString("sns_local_id");
      if (this.yqW != null)
      {
        paramBundle.hFc.hES = this.yqW;
        Log.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.yqW });
      }
      paramBundle.publish();
      if (!paramBundle.hFd.hEn) {
        break label1277;
      }
      this.aejA = Boolean.TRUE;
      this.aejO.alive();
      this.aejP.alive();
      this.aejx.setVisibility(0);
      this.aejr = ((HorizontalListView)findViewById(R.h.listview));
      this.aejz = ((TextView)findViewById(R.h.fsv));
      this.aejz.setText(R.l.gzw);
      this.aeju = new a(this);
      this.aejr.setAdapter(this.aeju);
      this.aejr.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34637);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          ChattingSendDataToDeviceUI.this.aejG = true;
          paramAnonymousAdapterView = ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).aBO(paramAnonymousInt);
          localObject = new StringBuilder("NetworkDeviceInfo info ");
          boolean bool;
          String str1;
          String str2;
          int i;
          LinkedList localLinkedList;
          if (paramAnonymousAdapterView == null)
          {
            bool = true;
            Log.d("MicroMsg.ChattingSendDataToDeviceUI", bool);
            str1 = paramAnonymousAdapterView.hEr;
            localObject = paramAnonymousAdapterView.deviceID;
            str2 = paramAnonymousAdapterView.hFR;
            bool = paramAnonymousAdapterView.hEm;
            i = paramAnonymousAdapterView.hFT;
            localLinkedList = paramAnonymousAdapterView.hFU;
          }
          for (;;)
          {
            try
            {
              if (ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).get(localObject) != null)
              {
                Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                paramAnonymousView = new ej();
                paramAnonymousView.hEj.hEl = ((String)localObject);
                paramAnonymousView.hEj.hEm = bool;
                paramAnonymousView.publish();
                if (paramAnonymousView.hEk.hEn)
                {
                  ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", (String)localObject, 0);
                  paramAnonymousAdapterView.hFX = "send_data_cancel";
                  ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(localObject);
                  paramAnonymousAdapterView = (au)((View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramAnonymousInt))).getTag();
                  paramAnonymousAdapterView.aejX.setText(ChattingSendDataToDeviceUI.this.getText(R.l.gzz));
                  paramAnonymousAdapterView.aejX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_cancel));
                  paramAnonymousAdapterView.aemr.setVisibility(8);
                  paramAnonymousAdapterView.aemr.aBT(0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34637);
                return;
                bool = false;
                break;
              }
              paramAnonymousAdapterView.hFX = "send_data_sending";
              ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(paramAnonymousAdapterView.deviceID, paramAnonymousAdapterView);
              ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).put(localObject, paramAnonymousView);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", (String)localObject, 1);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
              paramAnonymousAdapterView = new fq();
              paramAnonymousAdapterView.hFP.hEl = ((String)localObject);
              paramAnonymousAdapterView.hFP.hEr = str1;
              paramAnonymousAdapterView.hFP.data = ChattingSendDataToDeviceUI.e(ChattingSendDataToDeviceUI.this);
              paramAnonymousAdapterView.hFP.hFR = str2;
              paramAnonymousAdapterView.hFP.hEm = bool;
              paramAnonymousAdapterView.hFP.hFT = i;
              paramAnonymousAdapterView.hFP.hFU = localLinkedList;
              if (!ChattingSendDataToDeviceUI.this.hFS) {
                continue;
              }
              paramAnonymousAdapterView.hFP.hES = ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this);
              paramAnonymousAdapterView.hFP.hFS = ChattingSendDataToDeviceUI.this.hFS;
              paramAnonymousAdapterView.publish();
              if (!paramAnonymousAdapterView.hFQ.isSuccess)
              {
                ChattingSendDataToDeviceUI.bAD("send_data_failed");
                Log.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
              }
            }
            catch (Exception paramAnonymousAdapterView)
            {
              ChattingSendDataToDeviceUI.bAD("send_data_failed");
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAnonymousAdapterView });
              continue;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34637);
            return;
            paramAnonymousAdapterView.hFP.msgId = ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this);
          }
        }
      });
      jpH();
      if (!this.hFS) {
        break label1061;
      }
      paramBundle = this.yqW;
      if (paramBundle == null) {
        break label1056;
      }
      localObject = new lz();
      ((lz)localObject).hNQ.hES = paramBundle;
      ((lz)localObject).publish();
      i = ((lz)localObject).hNR.hNS.ContentObj.Zpq;
      if (i != 1) {
        break label1018;
      }
      i = 3;
      label445:
      this.aejJ = i;
      Lk(1);
    }
    for (;;)
    {
      this.aejy = ((RelativeLayout)findViewById(R.h.frP));
      this.aejs = ((HorizontalListView)findViewById(R.h.frq));
      this.aejt = new b(this);
      this.aejs.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34639);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          Log.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)
          {
            paramAnonymousView = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
            paramAnonymousView.addFlags(67108864);
            paramAnonymousView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(ChattingSendDataToDeviceUI.this));
            paramAnonymousAdapterView = ChattingSendDataToDeviceUI.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aYi(), "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34639);
            return;
            if ((ChattingSendDataToDeviceUI.this.aeeI) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 2))
            {
              if ((ChattingSendDataToDeviceUI.this.filePath == null) || (ChattingSendDataToDeviceUI.this.lPJ == null))
              {
                k.cZ(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.l.download_no_match_msg));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34639);
                return;
              }
              com.tencent.mm.pluginsdk.ui.tools.a.b(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.lPJ.toLowerCase(), 1);
            }
            else if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.getAdapter().getCount() - 1))
            {
              paramAnonymousAdapterView = (g)ChattingSendDataToDeviceUI.i(ChattingSendDataToDeviceUI.this).get(paramAnonymousInt);
              if (!com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView))
              {
                k.cZ(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.l.chatting_send_app_not_installed));
                paramAnonymousAdapterView.field_status = 4;
                as.gxn().a(paramAnonymousAdapterView, new String[0]);
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
                  com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView.field_packageName, ChattingSendDataToDeviceUI.this.vsv, paramAnonymousAdapterView.field_appId, paramAnonymousAdapterView.field_openId, 0, null, null);
                  AppMethodBeat.o(34638);
                }
              });
            }
          }
        }
      });
      this.aejs.setAdapter(this.aejt);
      findViewById(R.h.fUH).setOnClickListener(new ChattingSendDataToDeviceUI.1(this));
      AppMethodBeat.o(34661);
      return;
      label546:
      this.aejv = this.wPy.getType();
      this.aedO = com.tencent.mm.storage.au.bwE(this.wPy.field_talker);
      this.aejw = this.wPy.field_content;
      if ((this.aedO) && (this.wPy.field_isSend == 0))
      {
        localObject = this.wPy.field_content;
        i = this.wPy.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.aedO)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (i == 0) {
              paramBundle = br.JK((String)localObject);
            }
          }
        }
        this.aejw = paramBundle;
      }
      if (this.wPy.getType() == 49)
      {
        this.hWV = k.b.Hf(this.aejw);
        if (this.hWV == null)
        {
          Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.hWV.type == 3) {
          this.aejE = 16L;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.aejE) });
        break;
        if (this.hWV.type == 4)
        {
          this.aejE = 8L;
        }
        else if (this.hWV.type == 5)
        {
          this.aejE = 32L;
        }
        else
        {
          if (this.hWV.type == 6)
          {
            paramBundle = com.tencent.mm.pluginsdk.e.a.boO(this.hWV.nRe);
            if (paramBundle == null)
            {
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.aejE = paramBundle.longValue();
            continue;
          }
          if (this.hWV.type == 2)
          {
            this.aejE = 2L;
            paramBundle = r.bKa().af(this.wPy);
            if (paramBundle != null) {
              this.aejw = paramBundle.oGC;
            }
          }
          else
          {
            Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.wPy.getType() == 3)
            {
              paramBundle = r.bKa().af(this.wPy);
              if (paramBundle != null) {
                this.aejw = paramBundle.oGC;
              }
            }
            for (;;)
            {
              paramBundle = com.tencent.mm.pluginsdk.e.a.boO(this.aejv);
              if (paramBundle != null) {
                break label993;
              }
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.wPy.getType() == 43)
              {
                paramBundle = com.tencent.mm.modelvideo.v.bOh().PR(this.wPy.field_imgPath);
                if (paramBundle != null) {
                  this.aejw = paramBundle.bOu();
                }
              }
            }
            label993:
            this.aejE = paramBundle.longValue();
          }
        }
      }
      paramBundle.hFc.msgId = this.lul;
      break label258;
      label1018:
      if ((i == 4) || (i == 42))
      {
        i = 1;
        break label445;
      }
      if (i == 15)
      {
        i = 6;
        break label445;
      }
      if (i == 3)
      {
        i = 5;
        break label445;
      }
      label1056:
      i = 0;
      break label445;
      label1061:
      long l = this.lul;
      if ((l == -1L) || (l == -9223372036854775808L)) {
        i = 0;
      }
      for (;;)
      {
        this.aejJ = i;
        break;
        bh.bCz();
        paramBundle = com.tencent.mm.model.c.bzD().sl(l);
        if ((paramBundle == null) || (paramBundle.field_msgId == 0L))
        {
          i = 0;
        }
        else
        {
          int k = paramBundle.getType();
          localObject = paramBundle.field_content;
          if (paramBundle.fxR())
          {
            paramBundle = k.b.Hf((String)localObject);
            if (paramBundle == null) {
              Log.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
            }
          }
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
              i = j;
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
            if (k == 3)
            {
              i = 3;
              break;
            }
            if (k == 48)
            {
              i = 2;
              break;
            }
            i = j;
            if (k == 62) {
              break;
            }
          } while (k != 43);
          i = j;
        }
      }
      label1277:
      this.aejx.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34675);
    super.onDestroy();
    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.aejH = false;
    if (this.aejA.booleanValue())
    {
      if (!this.aejG) {
        Lk(2);
      }
      this.aejO.dead();
      this.aejP.dead();
      gd localgd = new gd();
      localgd.publish();
      if (localgd.hGr.isSuccess) {
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
    jpG();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.aejA.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.aejr.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.cd.a.getScaleSize(this);
      if (f != com.tencent.mm.cd.a.me(this)) {
        break label85;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(R.f.LittlePadding));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(R.f.NormalPadding))) {
      label85:
      do
      {
        this.aejr.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(34672);
        return;
      } while ((f != com.tencent.mm.cd.a.mg(this)) && (f != com.tencent.mm.cd.a.mf(this)) && (f != com.tencent.mm.cd.a.mh(this)));
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
    private List<Map<String, ae>> aeeH;
    private Map<String, ae> aejY;
    private Context context;
    private com.tencent.mm.modelimage.loader.a.c yxG;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(34650);
      this.context = paramContext;
      this.aeeH = new ArrayList();
      this$1 = new c.a();
      ChattingSendDataToDeviceUI.this.oKB = R.g.foC;
      this.yxG = ChattingSendDataToDeviceUI.this.bKx();
      AppMethodBeat.o(34650);
    }
    
    public final ae aBO(int paramInt)
    {
      AppMethodBeat.i(253746);
      ae localae = (ae)((Map)this.aeeH.get(paramInt)).get("hard_device_info");
      AppMethodBeat.o(253746);
      return localae;
    }
    
    public final void bz(List<ae> paramList)
    {
      AppMethodBeat.i(34651);
      this.aeeH.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.aejY = new HashMap();
        this.aejY.put("hard_device_info", (ae)paramList.get(i));
        this.aeeH.add(this.aejY);
        i += 1;
      }
      AppMethodBeat.o(34651);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34652);
      int i = this.aeeH.size();
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
      ae localae = aBO(paramInt);
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      final int i;
      final int j;
      StringBuffer localStringBuffer;
      float f;
      label288:
      int k;
      label291:
      String str2;
      if (ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt)) == null)
      {
        paramView = new au();
        paramViewGroup = View.inflate(paramViewGroup.getContext(), R.i.gnR, null);
        paramView.rIY = paramViewGroup.findViewById(R.h.container);
        paramView.pUL = ((TextView)paramViewGroup.findViewById(R.h.fOX));
        paramView.ttT = ((ImageView)paramViewGroup.findViewById(R.h.iconIV));
        paramView.aejX = ((TextView)paramViewGroup.findViewById(R.h.fVR));
        paramView.aemr = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(R.h.fVQ));
        paramView.aemr.setVisibility(4);
        paramView.Aov = ((ImageView)paramViewGroup.findViewById(R.h.app_avatar_mask_iv));
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localae.deviceID, Integer.valueOf(paramInt));
        paramView.jqh();
        String str1 = localae.displayName;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.cd.a.getScaleSize(this.context);
        if ((f != com.tencent.mm.cd.a.me(this.context)) && (f != com.tencent.mm.cd.a.mf(this.context))) {
          break label398;
        }
        i = 6;
        k = 0;
        if (k >= str1.length()) {
          break label451;
        }
        int m = Character.codePointAt(str1, k);
        str2 = str1.substring(k, k + 1);
        if ((m < 0) || (m > 255)) {
          break label430;
        }
        j += 1;
        label342:
        if (j > i) {
          break label439;
        }
        localObject = ((StringBuffer)localObject).append(str2);
      }
      for (;;)
      {
        k += 1;
        break label291;
        paramViewGroup = (View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt));
        paramView = (au)paramViewGroup.getTag();
        break;
        label398:
        if ((f != com.tencent.mm.cd.a.mg(this.context)) && (f != com.tencent.mm.cd.a.mh(this.context))) {
          break label288;
        }
        i = 5;
        break label288;
        label430:
        j += 2;
        break label342;
        label439:
        localStringBuffer = localStringBuffer.append(str2);
      }
      label451:
      paramView.pUL.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.aejX.setText(localStringBuffer);
      }
      Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(aBO(paramInt).deviceID)) {
        localObject = (ae)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(aBO(paramInt).deviceID);
      }
      if ((localObject != null) && (((ae)localObject).hFX != null))
      {
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ae)localObject).hFX });
        if (!((ae)localObject).hFX.equals("send_data_sending")) {
          break label780;
        }
        paramView.aejX.setText(this.context.getString(R.l.gzH));
        paramView.aejX.setTextColor(this.context.getResources().getColor(R.e.send_data_sending));
        paramView.aemr.aBT(localae.progress);
        paramView.aemr.setVisibility(0);
        localObject = localae.deviceID;
        localObject = (ae)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ae)localObject).progress;
        if (j < 100) {
          break label766;
        }
        i = 0;
        com.tencent.threadpool.h.ahAA.bp(new com.tencent.threadpool.i.h()
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
            while (ChattingSendDataToDeviceUI.this.aejH)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                if (this.aejT.hFX.equals("send_data_sucess"))
                {
                  j = i;
                  ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(34647);
                      ChattingSendDataToDeviceUI.a.1.this.aejS.aemr.aBT(0);
                      ChattingSendDataToDeviceUI.a.1.this.aejS.aemr.setVisibility(4);
                      ChattingSendDataToDeviceUI.a.1.this.aejS.aejX.setText(ChattingSendDataToDeviceUI.this.getText(R.l.gzF));
                      ChattingSendDataToDeviceUI.a.1.this.aejS.aejX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_sending));
                      ChattingSendDataToDeviceUI.a.1.this.aejT.hFX = "send_data_sucess";
                      ChattingSendDataToDeviceUI.a.1.this.aejT.progress = 0;
                      ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.aejT.deviceID, ChattingSendDataToDeviceUI.a.1.this.aejT);
                      Log.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.aejT.deviceID });
                      AppMethodBeat.o(34647);
                    }
                  });
                  AppMethodBeat.o(34649);
                  return;
                }
                j = i;
                if (!this.aejT.hFX.equals("send_data_failed"))
                {
                  j = i;
                  if (!this.aejT.hFX.equals("send_data_outdate")) {
                    continue;
                  }
                }
                j = i;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(34648);
                    ChattingSendDataToDeviceUI.a.1.this.aejS.aemr.aBT(0);
                    ChattingSendDataToDeviceUI.a.1.this.aejS.aemr.setVisibility(4);
                    ChattingSendDataToDeviceUI.a.1.this.aejS.aejX.setText(ChattingSendDataToDeviceUI.this.getText(R.l.gzD));
                    ChattingSendDataToDeviceUI.a.1.this.aejS.aejX.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_state_text_failed));
                    ChattingSendDataToDeviceUI.a.1.this.aejT.hFX = "send_data_failed";
                    ChattingSendDataToDeviceUI.a.1.this.aejT.progress = 0;
                    ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.aejT.deviceID, ChattingSendDataToDeviceUI.a.1.this.aejT);
                    Log.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.aejT.deviceID });
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
              paramView.aemr.aBT(i);
              j = i;
              this.aejT.progress = i;
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
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localae.displayName });
        r.bKe().a(localae.iconUrl, paramView.ttT, this.yxG);
        paramView.rIY.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(34654);
        return paramViewGroup;
        label766:
        i = 500 / (100 - j);
        break;
        label780:
        if (((ae)localObject).hFX.equals("send_data_sucess"))
        {
          paramView.aejX.setText(this.context.getString(R.l.gzF));
          paramView.aejX.setTextColor(this.context.getResources().getColor(R.e.send_data_sending));
          paramView.aemr.setVisibility(4);
        }
        else if (((ae)localObject).hFX.equals("send_data_cancel"))
        {
          paramView.aejX.setText(this.context.getString(R.l.gzz));
          paramView.aejX.setTextColor(this.context.getResources().getColor(R.e.send_data_cancel));
          paramView.aemr.setVisibility(4);
        }
        else if ((((ae)localObject).hFX.equals("send_data_failed")) || (((ae)localObject).hFX.equals("send_data_outdate")))
        {
          paramView.aejX.setText(this.context.getString(R.l.gzD));
          paramView.aejX.setTextColor(this.context.getResources().getColor(R.e.send_state_text_failed));
          paramView.aemr.setVisibility(4);
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
      paramIEvent = (fr)paramIEvent;
      String str1 = paramIEvent.hFV.hFX;
      String str2 = paramIEvent.hFV.hEl;
      Log.d("MicroMsg.ChattingSendDataToDeviceUI", "sendDataState " + str1 + " deviceId " + str2);
      if (str1.equals("send_data_sending")) {
        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, paramIEvent.hFV.progress);
      }
      for (;;)
      {
        AppMethodBeat.o(34658);
        return true;
        if (str1.equals("send_data_failed")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
        } else if (str1.equals("send_data_outdate")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_outdate", str2, 0);
        } else if (str1.equals("send_data_sucess")) {
          ChattingSendDataToDeviceUI.this.bAC(str2);
        }
      }
    }
    
    private boolean n(IEvent paramIEvent)
    {
      AppMethodBeat.i(34659);
      paramIEvent = ((fn)paramIEvent).hFJ.hEV;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramIEvent.size())
      {
        ae localae = new ae();
        localae.hEr = ((String)((Map)paramIEvent.get(i)).get("deviceType"));
        localae.deviceID = ((String)((Map)paramIEvent.get(i)).get("deviceID"));
        localae.displayName = ((String)((Map)paramIEvent.get(i)).get("displayName"));
        localae.iconUrl = ((String)((Map)paramIEvent.get(i)).get("iconUrl"));
        localae.hFR = ((String)((Map)paramIEvent.get(i)).get("ability"));
        localae.ysj = ((String)((Map)paramIEvent.get(i)).get("abilityInf"));
        if (((ChattingSendDataToDeviceUI.this.hFS) && (ChattingSendDataToDeviceUI.b(localae, ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this)))) || ((!ChattingSendDataToDeviceUI.this.hFS) && (ChattingSendDataToDeviceUI.b(localae, ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this)))))
        {
          if ((ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(localae.deviceID)) && (((ae)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localae.deviceID)).hFX != null))
          {
            localae.hFX = ((ae)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localae.deviceID)).hFX;
            localae.progress = ((ae)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localae.deviceID)).progress;
          }
          localArrayList.add(localae);
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
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).bz(ChattingSendDataToDeviceUI.l(ChattingSendDataToDeviceUI.this));
            if (ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).getCount() > 0)
            {
              ChattingSendDataToDeviceUI.m(ChattingSendDataToDeviceUI.this).setText(R.l.gwR);
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
      if ((paramIEvent instanceof fn))
      {
        bool = n(paramIEvent);
        AppMethodBeat.o(34657);
        return bool;
      }
      if ((paramIEvent instanceof fr))
      {
        bool = m(paramIEvent);
        AppMethodBeat.o(34657);
        return bool;
      }
      AppMethodBeat.o(34657);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI
 * JD-Core Version:    0.7.0.1
 */