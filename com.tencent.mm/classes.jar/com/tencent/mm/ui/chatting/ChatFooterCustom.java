package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.c;
import com.tencent.mm.h.a.eb;
import com.tencent.mm.h.a.mh;
import com.tencent.mm.h.a.mh.a;
import com.tencent.mm.h.a.mi;
import com.tencent.mm.h.a.mi.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.c.a;
import com.tencent.mm.ui.x;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom
  extends LinearLayout
  implements View.OnClickListener, bx.a
{
  private ad bSg;
  private String hcm;
  private Object ikx = new Object();
  private LinearLayout jiW = null;
  private com.tencent.mm.ai.d mVy;
  private ChatFooter.e sfe = null;
  private x uNW;
  private ImageView vih = null;
  public ImageView vii = null;
  public h vij = null;
  private c.a vik = null;
  private int vil = 0;
  private bq vim;
  private ChatFooterCustom.a vin;
  private ChatFooterCustom.b vio;
  private List<String> vip = new LinkedList();
  private final String viq = "qrcode";
  private final String vir = "barcode";
  private com.tencent.mm.ai.j vis;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(com.tencent.mm.ai.j paramj)
  {
    if (paramj == null) {
      return false;
    }
    String str = paramj.id + paramj.key;
    paramj = this.ikx;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.vip.size())
        {
          if (!((String)this.vip.get(i)).equals(str)) {
            break label166;
          }
          if (i >= 0)
          {
            this.vip.remove(i);
            y.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.vip.size()) });
            return true;
          }
          y.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.vip.size()) });
          return false;
        }
      }
      finally {}
      i = -1;
      continue;
      label166:
      i += 1;
    }
  }
  
  private void b(com.tencent.mm.ai.j paramj)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(10809, new Object[] { this.hcm, Integer.valueOf(paramj.id), paramj.key, com.tencent.mm.ai.j.egm, "" });
  }
  
  private void c(com.tencent.mm.ai.j paramj)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(10809, new Object[] { this.hcm, Integer.valueOf(paramj.id), paramj.key, com.tencent.mm.ai.j.ego, paramj.content });
  }
  
  private void cCr()
  {
    if ((this.uNW != null) && (this.bSg != null) && (!ah.bl(this.hcm))) {
      l.b(this.uNW, 9, this.hcm, this.bSg.field_username);
    }
  }
  
  private void cCs()
  {
    File localFile = new File(com.tencent.mm.compatible.util.e.dzD);
    if ((!localFile.exists()) && (!localFile.mkdir())) {
      Toast.makeText((Activity)getContext(), getContext().getString(R.l.chatting_toast_sdk_fail), 1).show();
    }
    while ((this.uNW == null) || (l.a(this.uNW, com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      return;
    }
    Toast.makeText((Activity)getContext(), getContext().getString(R.l.selectcameraapp_none), 1).show();
  }
  
  private void cCu()
  {
    y.i("ChatCustomFooter", "switch footer");
    if (this.sfe != null)
    {
      this.vij.cCw();
      this.sfe.me(true);
    }
  }
  
  private void cCv()
  {
    if (this.bSg == null) {}
    while (this.bSg.cCI != 1) {
      return;
    }
    au.Hx();
    c.FB().abA(this.bSg.field_username);
  }
  
  private boolean cc(Object paramObject)
  {
    if (!(paramObject instanceof mh)) {
      y.e("ChatCustomFooter", "send current location data type error!");
    }
    for (;;)
    {
      return true;
      Object localObject = (mh)paramObject;
      double d1 = ((mh)localObject).bVy.lat;
      double d2 = ((mh)localObject).bVy.lng;
      int i = ((mh)localObject).bVy.bRv;
      paramObject = ((mh)localObject).bVy.label;
      String str = ((mh)localObject).bVy.bVA;
      y.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, str });
      if ((this.vis == null) || (this.vis.egq != 105))
      {
        y.e("ChatCustomFooter", "cache lost or location type is not correct");
        return true;
      }
      this.vis.state = com.tencent.mm.ai.j.ego;
      localObject = this.vis;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("x", String.valueOf(d1));
        localJSONObject.put("y", String.valueOf(d2));
        localJSONObject.put("scale", i);
        localJSONObject.put("label", paramObject);
        localJSONObject.put("poiname", str);
        paramObject = new JSONObject();
        paramObject.put("location", localJSONObject);
        ((com.tencent.mm.ai.j)localObject).content = paramObject.toString();
        y.v("MicroMsg.BizMenuItem", ((com.tencent.mm.ai.j)localObject).content);
        if (!a(this.vis)) {
          continue;
        }
        d(this.vis);
        c(this.vis);
        return true;
      }
      catch (JSONException paramObject)
      {
        for (;;)
        {
          y.e("MicroMsg.BizMenuItem", paramObject.toString());
        }
      }
    }
  }
  
  private boolean cd(Object paramObject)
  {
    if (!(paramObject instanceof mi))
    {
      y.e("ChatCustomFooter", "send current location data type error!");
      return false;
    }
    Object localObject = (mi)paramObject;
    if ((this.vis == null) || ((this.vis.egq != 100) && (this.vis.egq != 101)))
    {
      y.e("ChatCustomFooter", "null pointer in cache or type error");
      return false;
    }
    switch (((mi)localObject).bVB.bVD)
    {
    default: 
      paramObject = "";
    }
    for (;;)
    {
      String str = ((mi)localObject).bVB.scanResult;
      y.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { paramObject, str });
      this.vis.state = com.tencent.mm.ai.j.ego;
      localObject = this.vis;
      y.v("MicroMsg.BizMenuItem", "type is %s , result is %s", new Object[] { paramObject, str });
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scan_type", paramObject);
        localJSONObject.put("scan_result", str);
        paramObject = new JSONObject();
        paramObject.put("scan_code", localJSONObject);
        ((com.tencent.mm.ai.j)localObject).content = paramObject.toString();
        y.v("MicroMsg.BizMenuItem", "content: %s", new Object[] { ((com.tencent.mm.ai.j)localObject).content });
        if (a(this.vis))
        {
          d(this.vis);
          c(this.vis);
        }
        return true;
        paramObject = "qrcode";
        continue;
        paramObject = "barcode";
      }
      catch (JSONException paramObject)
      {
        for (;;)
        {
          y.e("MicroMsg.BizMenuItem", paramObject.toString());
        }
      }
    }
  }
  
  private void d(com.tencent.mm.ai.j paramj)
  {
    y.i("ChatCustomFooter", paramj.getInfo());
    paramj = new com.tencent.mm.ai.q(this.hcm, paramj.getInfo());
    au.Dk().a(paramj, 0);
  }
  
  private String getSender()
  {
    Object localObject = new StringBuilder("getSender ");
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.vim == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.vim != null) {
        break label72;
      }
    }
    label72:
    for (localObject = com.tencent.mm.model.q.Gj();; localObject = this.vim.name)
    {
      y.i("ChatCustomFooter", (String)localObject);
      if (this.vim != null) {
        break label83;
      }
      return com.tencent.mm.model.q.Gj();
      bool = false;
      break;
    }
    label83:
    return this.vim.name;
  }
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    y.i("ChatCustomFooter", "SysCmdMsgExtension:" + parama);
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = XmlPullParserFactory.newInstance();
        ((XmlPullParserFactory)localObject).setNamespaceAware(true);
        localObject = ((XmlPullParserFactory)localObject).newPullParser();
        ((XmlPullParser)localObject).setInput(new StringReader(parama));
        i = ((XmlPullParser)localObject).getEventType();
      }
      catch (Exception parama)
      {
        y.printErrStackTrace("ChatCustomFooter", parama, "", new Object[0]);
        return;
      }
      int i = ((XmlPullParser)localObject).next();
      break label179;
      parama = ((XmlPullParser)localObject).getName();
      if ("sysmsg".equals(parama))
      {
        if ("type".equals(((XmlPullParser)localObject).getAttributeName(0))) {
          ((XmlPullParser)localObject).getAttributeValue(0);
        }
      }
      else if ("username".equals(parama))
      {
        ((XmlPullParser)localObject).nextText();
      }
      else if ("data".equals(parama))
      {
        ((XmlPullParser)localObject).nextText();
        continue;
        label179:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public final void a(x paramx, com.tencent.mm.ai.d paramd, String paramString)
  {
    d.b.c localc = paramd.bS(false).LY();
    if ((localc == null) || (localc.efJ == null) || (paramString == null)) {
      throw new IllegalArgumentException(" menuInfo or username is null ! ");
    }
    this.vil = Math.min(localc.efJ.size(), 6);
    y.i("ChatCustomFooter", "setMenus, count:" + this.vil);
    if (this.vil <= 0) {
      throw new IllegalArgumentException(" mTabCount is invalid ! ");
    }
    int i;
    label135:
    FrameLayout localFrameLayout;
    TextView localTextView;
    ImageView localImageView;
    if (this.vil > 3)
    {
      this.vih.setVisibility(0);
      this.jiW.setWeightSum(Math.min(this.vil, 3));
      i = 0;
      if (i >= 6) {
        break label364;
      }
      localFrameLayout = (FrameLayout)this.jiW.getChildAt(i);
      localTextView = (TextView)localFrameLayout.getChildAt(0).findViewById(R.h.chatting_footer_menu_text);
      localFrameLayout.getChildAt(0).findViewById(R.h.chatting_footer_menu_icon).setVisibility(8);
      localImageView = (ImageView)localFrameLayout.getChildAt(1);
      localImageView.setVisibility(8);
      if (i >= this.vil) {
        break label305;
      }
      com.tencent.mm.ai.j localj = (com.tencent.mm.ai.j)localc.efJ.get(i);
      localFrameLayout.setTag(localj);
      localTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), localj.name));
      if (localj.type == 0) {
        localImageView.setVisibility(0);
      }
      localFrameLayout.setOnClickListener(this);
      localFrameLayout.setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break label135;
      this.vih.setVisibility(8);
      break;
      label305:
      if ((i >= 3) && (this.vil > 3))
      {
        localFrameLayout.setTag(null);
        localTextView.setText("");
        localImageView.setVisibility(8);
        localFrameLayout.setOnClickListener(null);
        localFrameLayout.setVisibility(0);
      }
      else
      {
        localFrameLayout.setVisibility(8);
      }
    }
    label364:
    this.uNW = paramx;
    this.hcm = paramString;
    this.mVy = paramd;
    if (this.vin != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.vin);
    }
    if (this.vio != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.vio);
    }
    this.vin = new ChatFooterCustom.a(this, (byte)0);
    this.vio = new ChatFooterCustom.b(this, (byte)0);
    com.tencent.mm.sdk.b.a.udP.c(this.vin);
    com.tencent.mm.sdk.b.a.udP.c(this.vio);
  }
  
  public final void bIQ()
  {
    if (this.vin != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.vin);
    }
    if (this.vio != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.vio);
    }
  }
  
  public final void cCt()
  {
    if (this.vij != null) {
      this.vij.cCw();
    }
  }
  
  public ad getTalker()
  {
    return this.bSg;
  }
  
  public String getTalkerUserName()
  {
    if (this.bSg == null) {
      return null;
    }
    return this.bSg.field_username;
  }
  
  public final boolean l(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      y.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
    }
    label129:
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            switch (paramInt)
            {
            }
            for (;;)
            {
              switch (paramInt)
              {
              default: 
                return true;
              case 1001: 
                y.i("ChatCustomFooter", "return from camera");
                if ((paramObject instanceof Intent)) {
                  break label129;
                }
                y.e("ChatCustomFooter", "type error");
                return true;
                paramInt = 1001;
                continue;
                paramInt = 1002;
              }
            }
            paramObject = ((Intent)paramObject).getStringExtra("CropImage_OutputPath");
            if (paramObject == null)
            {
              y.e("ChatCustomFooter", "return null path");
              return true;
            }
            localObject = new File(paramObject);
            if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
              break;
            }
            y.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
            paramObject = com.tencent.mm.a.g.m((File)localObject);
            y.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
            if ((this.vis == null) || ((this.vis.egq != 102) && (this.vis.egq != 103)))
            {
              y.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
              return true;
            }
            localObject = new ArrayList();
            ((ArrayList)localObject).add(paramObject);
            this.vis.state = com.tencent.mm.ai.j.ego;
            this.vis.f((ArrayList)localObject);
          } while (!a(this.vis));
          d(this.vis);
          c(this.vis);
          return true;
          y.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { paramObject });
          return true;
          y.i("ChatCustomFooter", "return from albumn");
          if (!(paramObject instanceof Intent))
          {
            y.e("ChatCustomFooter", "type error");
            return true;
          }
          localObject = ((Intent)paramObject).getStringArrayListExtra("CropImage_OutputPath_List");
          paramObject = new ArrayList();
        } while ((localObject == null) || (((ArrayList)localObject).size() == 0));
        Object localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          y.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[] { str });
          if (str != null)
          {
            File localFile = new File(str);
            if ((localFile.exists()) && (localFile.isFile()))
            {
              y.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
              str = com.tencent.mm.a.g.m(localFile);
              paramObject.add(str);
              y.i("ChatCustomFooter", "MD5 is %s", new Object[] { str });
            }
          }
          else
          {
            y.e("ChatCustomFooter", "no file contained!");
            continue;
          }
          y.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { str });
        }
        if ((this.vis == null) || ((this.vis.egq != 104) && (this.vis.egq != 103) && (this.vis.egq != 102)))
        {
          y.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
          return true;
        }
        this.vis.state = com.tencent.mm.ai.j.ego;
        this.vis.f(paramObject);
      } while (!a(this.vis));
      d(this.vis);
      c(this.vis);
      return true;
      y.i("ChatCustomFooter", "send current");
      cc(paramObject);
      return true;
      y.i("ChatCustomFooter", "send selected");
      cc(paramObject);
      return true;
      y.i("ChatCustomFooter", "send qrcode wait msg");
    } while (!cd(paramObject));
    this.vik.cDV();
    return true;
    y.i("ChatCustomFooter", "send qrcode direct");
    cd(paramObject);
    return true;
  }
  
  public void onClick(View arg1)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject3;
      boolean bool;
      Object localObject4;
      int i;
      int j;
      try
      {
        localObject3 = ???.getTag();
        bool = localObject3 instanceof com.tencent.mm.ai.j;
        if (!bool) {
          return;
        }
        i.Ez(8);
        localObject3 = (com.tencent.mm.ai.j)localObject3;
        ((com.tencent.mm.ai.j)localObject3).content = "";
        switch (((com.tencent.mm.ai.j)localObject3).type)
        {
        case 0: 
          localObject1 = new int[2];
          ???.getLocationOnScreen((int[])localObject1);
          y.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(???.getWidth()) });
          localObject4 = this.vij;
          i = localObject1[0] + ???.getWidth() / 2;
          j = localObject1[1];
          if (!((h)localObject4).isShowing())
          {
            ((h)localObject4).a((com.tencent.mm.ai.j)localObject3, i, j);
            continue;
          }
          ((h)localObject4).cCw();
        }
      }
      finally {}
      if ((localObject3 != null) && ((((h)localObject4).viA.id != ((com.tencent.mm.ai.j)localObject3).id) || (!((h)localObject4).viA.key.equals(((com.tencent.mm.ai.j)localObject3).key))))
      {
        ((h)localObject4).a((com.tencent.mm.ai.j)localObject3, i, j);
        continue;
        y.i("ChatCustomFooter", "start webview url");
        cCv();
        this.vij.cCw();
        ((com.tencent.mm.ai.j)localObject3).state = com.tencent.mm.ai.j.egm;
        b((com.tencent.mm.ai.j)localObject3);
        d((com.tencent.mm.ai.j)localObject3);
        if ((!p.a.rSH.c(getContext(), ((com.tencent.mm.ai.j)localObject3).value, new Object[0])) && (!f.a(((com.tencent.mm.ai.j)localObject3).ceb, getContext(), this.uNW, this.hcm)))
        {
          ??? = new Intent();
          ???.putExtra("KPublisherId", "custom_menu");
          ???.putExtra("pre_username", this.hcm);
          ???.putExtra("prePublishId", "custom_menu");
          ???.putExtra("preUsername", this.hcm);
          ???.putExtra("preChatName", this.hcm);
          ???.putExtra("preChatTYPE", t.R(this.hcm, this.hcm));
          ???.putExtra("rawUrl", ((com.tencent.mm.ai.j)localObject3).value);
          ???.putExtra("geta8key_username", this.hcm);
          ???.putExtra("from_scence", 1);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
          continue;
          y.i("ChatCustomFooter", "switch to input");
          this.vij.cCw();
          cCu();
          ((com.tencent.mm.ai.j)localObject3).state = com.tencent.mm.ai.j.egm;
          b((com.tencent.mm.ai.j)localObject3);
          d((com.tencent.mm.ai.j)localObject3);
          continue;
          y.i("ChatCustomFooter", "get latest message");
          cCv();
          this.vij.cCw();
          ((com.tencent.mm.ai.j)localObject3).state = com.tencent.mm.ai.j.egm;
          b((com.tencent.mm.ai.j)localObject3);
          d((com.tencent.mm.ai.j)localObject3);
          this.vik.cDV();
          continue;
          cCv();
          this.vij.cCw();
          ((com.tencent.mm.ai.j)localObject3).state = com.tencent.mm.ai.j.egm;
          b((com.tencent.mm.ai.j)localObject3);
          d((com.tencent.mm.ai.j)localObject3);
          bool = TextUtils.isEmpty(((com.tencent.mm.ai.j)localObject3).value);
          if (!bool)
          {
            try
            {
              ??? = new JSONObject(((com.tencent.mm.ai.j)localObject3).value);
              localObject3 = new AppBrandStatObject();
              ((AppBrandStatObject)localObject3).scene = 1035;
              ((AppBrandStatObject)localObject3).bFv = this.hcm;
              localObject4 = (com.tencent.mm.plugin.appbrand.r.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.d.class);
              Context localContext = getContext();
              String str2 = ???.optString("userName");
              String str3 = ???.optString("pagePath");
              if (this.mVy == null) {}
              for (??? = (View)localObject1;; ??? = this.mVy.field_appId)
              {
                ((com.tencent.mm.plugin.appbrand.r.d)localObject4).a(localContext, str2, null, 0, 0, str3, (AppBrandStatObject)localObject3, ???);
                break;
              }
              y.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
              cCv();
              this.vij.cCw();
              ((com.tencent.mm.ai.j)localObject3).state = com.tencent.mm.ai.j.egn;
              localObject1 = ((com.tencent.mm.ai.j)localObject3).id + ((com.tencent.mm.ai.j)localObject3).key;
              synchronized (this.ikx)
              {
                this.vip.add(localObject1);
                y.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.vip.size()) });
                com.tencent.mm.plugin.report.service.h.nFQ.f(10809, new Object[] { this.hcm, Integer.valueOf(((com.tencent.mm.ai.j)localObject3).id), ((com.tencent.mm.ai.j)localObject3).key, com.tencent.mm.ai.j.egn, "" });
                this.vis = ((com.tencent.mm.ai.j)localObject3);
                switch (((com.tencent.mm.ai.j)localObject3).egq)
                {
                case 100: 
                  ??? = new Intent();
                  ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                  ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                  ???.putExtra("key_is_finish_on_scanned", true);
                  ???.putExtra("key_is_hide_right_btn", true);
                  if (com.tencent.mm.r.a.bj(getContext())) {
                    continue;
                  }
                  getContext();
                  if (com.tencent.mm.bf.e.RS()) {
                    continue;
                  }
                  com.tencent.mm.br.d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                }
              }
              ??? = new Intent();
              ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
              ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
              ???.putExtra("key_is_finish_on_scanned", false);
              ???.putExtra("key_is_hide_right_btn", true);
              if (com.tencent.mm.r.a.bj(getContext())) {
                continue;
              }
              getContext();
              if (com.tencent.mm.bf.e.RS()) {
                continue;
              }
              com.tencent.mm.br.d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
            }
            catch (JSONException ???) {}
            cCs();
            continue;
            au.Hx();
            if (!c.isSDCardAvailable())
            {
              s.gM(getContext());
            }
            else
            {
              ??? = getContext().getString(R.l.chatting_context_menu_take_picture);
              String str1 = getContext().getString(R.l.chatting_context_menu_image);
              localObject3 = getContext();
              localObject4 = new ChatFooterCustom.1(this);
              com.tencent.mm.ui.base.h.a((Context)localObject3, null, new String[] { ???, str1 }, null, (h.c)localObject4);
              continue;
              cCr();
              continue;
              ??? = new Intent();
              ???.putExtra("map_view_type", 0);
              ???.putExtra("map_sender_name", getSender());
              ???.putExtra("map_talker_name", getTalkerUserName());
              ???.putExtra("view_type_key", 1);
              ???.putExtra("key_get_location_type", 1);
              com.tencent.mm.br.d.b(getContext(), "location", ".ui.RedirectUI", ???);
              continue;
              ??? = new eb();
              ???.bKB.op = 1;
              ???.bKB.userName = this.bSg.field_username;
              ???.bKB.context = getContext();
              com.tencent.mm.sdk.b.a.udP.m(???);
              continue;
              ??? = new eb();
              ???.bKB.op = 2;
              ???.bKB.userName = this.bSg.field_username;
              ???.bKB.context = getContext();
              com.tencent.mm.sdk.b.a.udP.m(???);
              continue;
              continue;
            }
          }
        }
      }
    }
  }
  
  public final void p(ViewGroup paramViewGroup)
  {
    this.jiW = ((LinearLayout)findViewById(R.h.chatting_footer_menu_container));
    this.vii = ((ImageView)findViewById(R.h.chatting_footer_switch2input));
    this.vii.setVisibility(0);
    this.vii.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        ChatFooterCustom.c(ChatFooterCustom.this);
      }
    });
    this.vih = ((ImageView)findViewById(R.h.chatting_footer_menu_arrow));
    this.vih.setOnClickListener(new ChatFooterCustom.3(this));
    this.vij = new h(getContext(), paramViewGroup);
    this.vij.viu = new ChatFooterCustom.4(this);
  }
  
  public void setOnFooterSwitchListener(ChatFooter.e parame)
  {
    this.sfe = parame;
  }
  
  public void setOnProcessClickListener(c.a parama)
  {
    this.vik = parama;
  }
  
  public void setTalker(ad paramad)
  {
    this.bSg = paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */