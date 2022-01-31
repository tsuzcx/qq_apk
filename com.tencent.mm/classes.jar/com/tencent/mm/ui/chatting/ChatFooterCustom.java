package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.c;
import com.tencent.mm.aj.q;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.nb.a;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.nc.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.c.a;
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
  implements View.OnClickListener, bz.a
{
  private Object clk;
  private ad czH;
  private String ikj;
  private LinearLayout lrN;
  private com.tencent.mm.aj.d pyd;
  private ChatFooter.e vWj;
  private MMFragment zbQ;
  private ImageView zxa;
  public ImageView zxb;
  public LinearLayout zxc;
  public g zxd;
  private c.a zxe;
  private int zxf;
  private bq zxg;
  private ChatFooterCustom.a zxh;
  private ChatFooterCustom.b zxi;
  private List<String> zxj;
  private final String zxk;
  private final String zxl;
  private com.tencent.mm.aj.j zxm;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30473);
    this.lrN = null;
    this.zxa = null;
    this.zxb = null;
    this.zxc = null;
    this.zxd = null;
    this.vWj = null;
    this.zxe = null;
    this.zxf = 0;
    this.zxj = new LinkedList();
    this.zxk = "qrcode";
    this.zxl = "barcode";
    this.clk = new Object();
    AppMethodBeat.o(30473);
  }
  
  private static String Pl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "qrcode";
    }
    return "barcode";
  }
  
  private boolean a(com.tencent.mm.aj.j paramj)
  {
    AppMethodBeat.i(30481);
    if (paramj == null)
    {
      AppMethodBeat.o(30481);
      return false;
    }
    String str = paramj.id + paramj.key;
    paramj = this.clk;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.zxj.size())
        {
          if (((String)this.zxj.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.zxj.remove(i);
              ab.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.zxj.size()) });
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          ab.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.zxj.size()) });
          AppMethodBeat.o(30481);
          return false;
        }
      }
      finally
      {
        AppMethodBeat.o(30481);
      }
    }
  }
  
  private void b(com.tencent.mm.aj.j paramj)
  {
    AppMethodBeat.i(30482);
    com.tencent.mm.plugin.report.service.h.qsU.e(10809, new Object[] { this.ikj, Integer.valueOf(paramj.id), paramj.key, com.tencent.mm.aj.j.fwo, "" });
    AppMethodBeat.o(30482);
  }
  
  private void c(com.tencent.mm.aj.j paramj)
  {
    AppMethodBeat.i(30483);
    com.tencent.mm.plugin.report.service.h.qsU.e(10809, new Object[] { this.ikj, Integer.valueOf(paramj.id), paramj.key, com.tencent.mm.aj.j.fwq, paramj.content });
    AppMethodBeat.o(30483);
  }
  
  private boolean cG(Object paramObject)
  {
    AppMethodBeat.i(30485);
    if (!(paramObject instanceof nb))
    {
      ab.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(30485);
      return true;
    }
    Object localObject = (nb)paramObject;
    double d1 = ((nb)localObject).cDj.lat;
    double d2 = ((nb)localObject).cDj.lng;
    int i = ((nb)localObject).cDj.cyX;
    paramObject = ((nb)localObject).cDj.label;
    localObject = ((nb)localObject).cDj.cDl;
    ab.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, localObject });
    if ((this.zxm == null) || (this.zxm.fws != 105))
    {
      ab.e("ChatCustomFooter", "cache lost or location type is not correct");
      AppMethodBeat.o(30485);
      return true;
    }
    this.zxm.state = com.tencent.mm.aj.j.fwq;
    this.zxm.a(d1, d2, i, paramObject, (String)localObject);
    if (a(this.zxm))
    {
      d(this.zxm);
      c(this.zxm);
    }
    AppMethodBeat.o(30485);
    return true;
  }
  
  private boolean cH(Object paramObject)
  {
    AppMethodBeat.i(30486);
    if (!(paramObject instanceof nc))
    {
      ab.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(30486);
      return false;
    }
    Object localObject = (nc)paramObject;
    if ((this.zxm == null) || ((this.zxm.fws != 100) && (this.zxm.fws != 101)))
    {
      ab.e("ChatCustomFooter", "null pointer in cache or type error");
      AppMethodBeat.o(30486);
      return false;
    }
    paramObject = Pl(((nc)localObject).cDm.cDo);
    localObject = ((nc)localObject).cDm.scanResult;
    ab.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { paramObject, localObject });
    this.zxm.state = com.tencent.mm.aj.j.fwq;
    this.zxm.aD(paramObject, (String)localObject);
    if (a(this.zxm))
    {
      d(this.zxm);
      c(this.zxm);
    }
    AppMethodBeat.o(30486);
    return true;
  }
  
  private void d(com.tencent.mm.aj.j paramj)
  {
    AppMethodBeat.i(30487);
    ab.i("ChatCustomFooter", paramj.getInfo());
    paramj = new q(this.ikj, paramj.getInfo());
    aw.Rc().a(paramj, 0);
    AppMethodBeat.o(30487);
  }
  
  private void dGe()
  {
    AppMethodBeat.i(30476);
    if ((this.zbQ != null) && (this.czH != null) && (!ah.isNullOrNil(this.ikj))) {
      n.b(this.zbQ, 9, this.ikj, this.czH.field_username);
    }
    AppMethodBeat.o(30476);
  }
  
  private void dGf()
  {
    AppMethodBeat.i(30477);
    File localFile = new File(com.tencent.mm.compatible.util.e.esr);
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(2131298329), 1).show();
      AppMethodBeat.o(30477);
      return;
    }
    if ((this.zbQ != null) && (!n.a(this.zbQ, com.tencent.mm.compatible.util.e.esr, "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(2131303074), 1).show();
    }
    AppMethodBeat.o(30477);
  }
  
  private void dGh()
  {
    AppMethodBeat.i(30490);
    ab.i("ChatCustomFooter", "switch footer");
    if (this.vWj != null)
    {
      this.zxd.dGj();
      this.vWj.pu(true);
    }
    AppMethodBeat.o(30490);
  }
  
  private void dGi()
  {
    AppMethodBeat.i(30491);
    if (this.czH == null)
    {
      AppMethodBeat.o(30491);
      return;
    }
    if (this.czH.dqS == 1)
    {
      aw.aaz();
      c.YF().arM(this.czH.field_username);
    }
    AppMethodBeat.o(30491);
  }
  
  private String getSender()
  {
    AppMethodBeat.i(30478);
    Object localObject = new StringBuilder("getSender ");
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.zxg == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.zxg != null) {
        break label86;
      }
    }
    label86:
    for (localObject = com.tencent.mm.model.r.Zn();; localObject = this.zxg.name)
    {
      ab.i("ChatCustomFooter", (String)localObject);
      if (this.zxg != null) {
        break label97;
      }
      localObject = com.tencent.mm.model.r.Zn();
      AppMethodBeat.o(30478);
      return localObject;
      bool = false;
      break;
    }
    label97:
    localObject = this.zxg.name;
    AppMethodBeat.o(30478);
    return localObject;
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(30489);
    parama = aa.a(parama.eyJ.woR);
    ab.i("ChatCustomFooter", "SysCmdMsgExtension:".concat(String.valueOf(parama)));
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
        ab.printErrStackTrace("ChatCustomFooter", parama, "", new Object[0]);
        AppMethodBeat.o(30489);
        return;
      }
      int i = ((XmlPullParser)localObject).next();
      break label191;
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
        label191:
        while (i == 1)
        {
          AppMethodBeat.o(30489);
          return;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public final void a(MMFragment paramMMFragment, com.tencent.mm.aj.d paramd, String paramString)
  {
    AppMethodBeat.i(30474);
    d.b.c localc = paramd.cU(false).aeF();
    if ((localc == null) || (localc.fvL == null) || (paramString == null))
    {
      paramMMFragment = new IllegalArgumentException(" menuInfo or username is null ! ");
      AppMethodBeat.o(30474);
      throw paramMMFragment;
    }
    this.zxf = Math.min(localc.fvL.size(), 6);
    ab.i("ChatCustomFooter", "setMenus, count:" + this.zxf);
    if (this.zxf <= 0)
    {
      paramMMFragment = new IllegalArgumentException(" mTabCount is invalid ! ");
      AppMethodBeat.o(30474);
      throw paramMMFragment;
    }
    int i;
    label157:
    FrameLayout localFrameLayout;
    TextView localTextView;
    ImageView localImageView;
    if (this.zxf > 3)
    {
      this.zxa.setVisibility(0);
      this.lrN.setWeightSum(Math.min(this.zxf, 3));
      i = 0;
      if (i >= 6) {
        break label378;
      }
      localFrameLayout = (FrameLayout)this.lrN.getChildAt(i);
      localTextView = (TextView)localFrameLayout.findViewById(2131822496);
      localFrameLayout.findViewById(2131822495).setVisibility(8);
      localImageView = (ImageView)localFrameLayout.getChildAt(2);
      localImageView.setVisibility(8);
      if (i >= this.zxf) {
        break label319;
      }
      com.tencent.mm.aj.j localj = (com.tencent.mm.aj.j)localc.fvL.get(i);
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
      break label157;
      this.zxa.setVisibility(8);
      break;
      label319:
      if ((i >= 3) && (this.zxf > 3))
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
    label378:
    this.zbQ = paramMMFragment;
    this.ikj = paramString;
    this.pyd = paramd;
    if (this.zxh != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.zxh);
    }
    if (this.zxi != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.zxi);
    }
    this.zxh = new ChatFooterCustom.a(this, (byte)0);
    this.zxi = new ChatFooterCustom.b(this, (byte)0);
    com.tencent.mm.sdk.b.a.ymk.c(this.zxh);
    com.tencent.mm.sdk.b.a.ymk.c(this.zxi);
    AppMethodBeat.o(30474);
  }
  
  public final void cvl()
  {
    AppMethodBeat.i(30475);
    if (this.zxh != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.zxh);
    }
    if (this.zxi != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.zxi);
    }
    AppMethodBeat.o(30475);
  }
  
  public final void dGg()
  {
    AppMethodBeat.i(30479);
    if (this.zxd != null) {
      this.zxd.dGj();
    }
    AppMethodBeat.o(30479);
  }
  
  public ad getTalker()
  {
    return this.czH;
  }
  
  public String getTalkerUserName()
  {
    if (this.czH == null) {
      return null;
    }
    return this.czH.field_username;
  }
  
  public void onClick(View arg1)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject3;
      try
      {
        AppMethodBeat.i(30480);
        localObject3 = ???.getTag();
        if (!(localObject3 instanceof com.tencent.mm.aj.j))
        {
          AppMethodBeat.o(30480);
          return;
        }
        com.tencent.mm.pluginsdk.wallet.j.Mx(8);
        localObject3 = (com.tencent.mm.aj.j)localObject3;
        ((com.tencent.mm.aj.j)localObject3).content = "";
        switch (((com.tencent.mm.aj.j)localObject3).type)
        {
        case 0: 
          AppMethodBeat.o(30480);
          continue;
          localObject1 = new int[2];
        }
      }
      finally {}
      ???.getLocationOnScreen((int[])localObject1);
      ab.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(???.getWidth()) });
      Object localObject4 = this.zxd;
      int i = localObject1[0] + ???.getWidth() / 2;
      int j = localObject1[1];
      if (!((g)localObject4).isShowing())
      {
        ((g)localObject4).a((com.tencent.mm.aj.j)localObject3, i, j);
        AppMethodBeat.o(30480);
      }
      else
      {
        ((g)localObject4).dGj();
        if ((localObject3 != null) && ((((g)localObject4).zxu.id != ((com.tencent.mm.aj.j)localObject3).id) || (!((g)localObject4).zxu.key.equals(((com.tencent.mm.aj.j)localObject3).key)))) {
          ((g)localObject4).a((com.tencent.mm.aj.j)localObject3, i, j);
        }
        AppMethodBeat.o(30480);
        continue;
        ab.i("ChatCustomFooter", "start webview url");
        dGi();
        this.zxd.dGj();
        ((com.tencent.mm.aj.j)localObject3).state = com.tencent.mm.aj.j.fwo;
        b((com.tencent.mm.aj.j)localObject3);
        d((com.tencent.mm.aj.j)localObject3);
        if ((!r.a.vJD.b(getContext(), ((com.tencent.mm.aj.j)localObject3).value, new Object[0])) && (!e.a(((com.tencent.mm.aj.j)localObject3).cMO, getContext(), this.zbQ, this.ikj)))
        {
          ??? = new Intent();
          ???.putExtra("KPublisherId", "custom_menu");
          ???.putExtra("pre_username", this.ikj);
          ???.putExtra("prePublishId", "custom_menu");
          ???.putExtra("preUsername", this.ikj);
          ???.putExtra("preChatName", this.ikj);
          ???.putExtra("preChatTYPE", u.ah(this.ikj, this.ikj));
          ???.putExtra("rawUrl", ((com.tencent.mm.aj.j)localObject3).value);
          ???.putExtra("geta8key_username", this.ikj);
          ???.putExtra("from_scence", 1);
          com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
          AppMethodBeat.o(30480);
          continue;
          ab.i("ChatCustomFooter", "switch to input");
          this.zxd.dGj();
          dGh();
          ((com.tencent.mm.aj.j)localObject3).state = com.tencent.mm.aj.j.fwo;
          b((com.tencent.mm.aj.j)localObject3);
          d((com.tencent.mm.aj.j)localObject3);
          AppMethodBeat.o(30480);
          continue;
          ab.i("ChatCustomFooter", "get latest message");
          dGi();
          this.zxd.dGj();
          ((com.tencent.mm.aj.j)localObject3).state = com.tencent.mm.aj.j.fwo;
          b((com.tencent.mm.aj.j)localObject3);
          d((com.tencent.mm.aj.j)localObject3);
          this.zxe.dHL();
          AppMethodBeat.o(30480);
          continue;
          dGi();
          this.zxd.dGj();
          ((com.tencent.mm.aj.j)localObject3).state = com.tencent.mm.aj.j.fwo;
          b((com.tencent.mm.aj.j)localObject3);
          d((com.tencent.mm.aj.j)localObject3);
          boolean bool = TextUtils.isEmpty(((com.tencent.mm.aj.j)localObject3).value);
          if (!bool)
          {
            try
            {
              ??? = new JSONObject(((com.tencent.mm.aj.j)localObject3).value);
              localObject3 = new AppBrandStatObject();
              ((AppBrandStatObject)localObject3).scene = 1035;
              ((AppBrandStatObject)localObject3).cmF = this.ikj;
              localObject4 = (com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class);
              Context localContext = getContext();
              String str2 = ???.optString("userName");
              String str3 = ???.optString("pagePath");
              if (this.pyd == null) {}
              for (??? = (View)localObject1;; ??? = this.pyd.field_appId)
              {
                ((com.tencent.mm.plugin.appbrand.service.j)localObject4).a(localContext, str2, null, 0, 0, str3, (AppBrandStatObject)localObject3, ???);
                AppMethodBeat.o(30480);
                break;
              }
            }
            catch (JSONException ???)
            {
              AppMethodBeat.o(30480);
            }
            ab.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
            dGi();
            this.zxd.dGj();
            ((com.tencent.mm.aj.j)localObject3).state = com.tencent.mm.aj.j.fwp;
            localObject1 = ((com.tencent.mm.aj.j)localObject3).id + ((com.tencent.mm.aj.j)localObject3).key;
            synchronized (this.clk)
            {
              this.zxj.add(localObject1);
              ab.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.zxj.size()) });
              com.tencent.mm.plugin.report.service.h.qsU.e(10809, new Object[] { this.ikj, Integer.valueOf(((com.tencent.mm.aj.j)localObject3).id), ((com.tencent.mm.aj.j)localObject3).key, com.tencent.mm.aj.j.fwp, "" });
              this.zxm = ((com.tencent.mm.aj.j)localObject3);
              switch (((com.tencent.mm.aj.j)localObject3).fws)
              {
              case 100: 
                ??? = new Intent();
                ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                ???.putExtra("key_is_finish_on_scanned", true);
                ???.putExtra("key_is_hide_right_btn", true);
                if (com.tencent.mm.r.a.bN(getContext())) {
                  continue;
                }
                getContext();
                if (com.tencent.mm.bg.e.alb()) {
                  continue;
                }
                com.tencent.mm.bq.d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                AppMethodBeat.o(30480);
              }
            }
            ??? = new Intent();
            ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            ???.putExtra("key_is_finish_on_scanned", false);
            ???.putExtra("key_is_hide_right_btn", true);
            if (!com.tencent.mm.r.a.bN(getContext()))
            {
              getContext();
              if (!com.tencent.mm.bg.e.alb())
              {
                com.tencent.mm.bq.d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                AppMethodBeat.o(30480);
                continue;
                dGf();
                AppMethodBeat.o(30480);
                continue;
                aw.aaz();
                if (!c.isSDCardAvailable())
                {
                  t.ii(getContext());
                  AppMethodBeat.o(30480);
                }
                else
                {
                  ??? = getContext().getString(2131298160);
                  String str1 = getContext().getString(2131298159);
                  localObject3 = getContext();
                  localObject4 = new ChatFooterCustom.1(this);
                  com.tencent.mm.ui.base.h.a((Context)localObject3, null, new String[] { ???, str1 }, null, (h.c)localObject4);
                  AppMethodBeat.o(30480);
                  continue;
                  dGe();
                  AppMethodBeat.o(30480);
                  continue;
                  ??? = new Intent();
                  ???.putExtra("map_view_type", 0);
                  ???.putExtra("map_sender_name", getSender());
                  ???.putExtra("map_talker_name", getTalkerUserName());
                  ???.putExtra("view_type_key", 1);
                  ???.putExtra("key_get_location_type", 1);
                  com.tencent.mm.bq.d.b(getContext(), "location", ".ui.RedirectUI", ???);
                  AppMethodBeat.o(30480);
                  continue;
                  ??? = new ee();
                  ???.crV.op = 1;
                  ???.crV.userName = this.czH.field_username;
                  ???.crV.context = getContext();
                  com.tencent.mm.sdk.b.a.ymk.l(???);
                  AppMethodBeat.o(30480);
                  continue;
                  ??? = new ee();
                  ???.crV.op = 2;
                  ???.crV.userName = this.czH.field_username;
                  ???.crV.context = getContext();
                  com.tencent.mm.sdk.b.a.ymk.l(???);
                  continue;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean s(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(30484);
    if (paramObject == null)
    {
      ab.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
      AppMethodBeat.o(30484);
      return true;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(30484);
        return true;
        paramInt = 1001;
        continue;
        paramInt = 1002;
      }
    }
    ab.i("ChatCustomFooter", "return from camera");
    if (!(paramObject instanceof Intent))
    {
      ab.e("ChatCustomFooter", "type error");
      AppMethodBeat.o(30484);
      return true;
    }
    paramObject = ((Intent)paramObject).getStringExtra("CropImage_OutputPath");
    if (paramObject == null)
    {
      ab.e("ChatCustomFooter", "return null path");
      AppMethodBeat.o(30484);
      return true;
    }
    Object localObject = new File(paramObject);
    if ((((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      ab.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
      paramObject = com.tencent.mm.a.g.r((File)localObject);
      ab.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.zxm == null) || ((this.zxm.fws != 102) && (this.zxm.fws != 103)))
      {
        ab.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(30484);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.zxm.state = com.tencent.mm.aj.j.fwq;
      this.zxm.f((ArrayList)localObject);
      if (a(this.zxm))
      {
        d(this.zxm);
        c(this.zxm);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30484);
      return true;
      ab.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { paramObject });
    }
    ab.i("ChatCustomFooter", "return from albumn");
    if (!(paramObject instanceof Intent))
    {
      ab.e("ChatCustomFooter", "type error");
      AppMethodBeat.o(30484);
      return true;
    }
    localObject = ((Intent)paramObject).getStringArrayListExtra("CropImage_OutputPath_List");
    paramObject = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ab.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[] { str });
        if (str != null)
        {
          File localFile = new File(str);
          if ((localFile.exists()) && (localFile.isFile()))
          {
            ab.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
            str = com.tencent.mm.a.g.r(localFile);
            paramObject.add(str);
            ab.i("ChatCustomFooter", "MD5 is %s", new Object[] { str });
          }
        }
        else
        {
          ab.e("ChatCustomFooter", "no file contained!");
          continue;
        }
        ab.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { str });
      }
      if ((this.zxm == null) || ((this.zxm.fws != 104) && (this.zxm.fws != 103) && (this.zxm.fws != 102)))
      {
        ab.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(30484);
        return true;
      }
      this.zxm.state = com.tencent.mm.aj.j.fwq;
      this.zxm.f(paramObject);
      if (a(this.zxm))
      {
        d(this.zxm);
        c(this.zxm);
      }
    }
    AppMethodBeat.o(30484);
    return true;
    ab.i("ChatCustomFooter", "send current");
    cG(paramObject);
    AppMethodBeat.o(30484);
    return true;
    ab.i("ChatCustomFooter", "send selected");
    cG(paramObject);
    AppMethodBeat.o(30484);
    return true;
    ab.i("ChatCustomFooter", "send qrcode wait msg");
    if (!cH(paramObject))
    {
      AppMethodBeat.o(30484);
      return true;
    }
    this.zxe.dHL();
    AppMethodBeat.o(30484);
    return true;
    ab.i("ChatCustomFooter", "send qrcode direct");
    cH(paramObject);
    AppMethodBeat.o(30484);
    return true;
  }
  
  public void setOnFooterSwitchListener(ChatFooter.e parame)
  {
    this.vWj = parame;
  }
  
  public void setOnProcessClickListener(c.a parama)
  {
    this.zxe = parama;
  }
  
  public void setTalker(ad paramad)
  {
    this.czH = paramad;
  }
  
  public final void u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30488);
    this.lrN = ((LinearLayout)findViewById(2131822500));
    this.zxc = ((LinearLayout)findViewById(2131822498));
    this.zxc.setVisibility(0);
    this.zxb = ((ImageView)findViewById(2131822499));
    this.zxb.setVisibility(0);
    this.zxb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30464);
        ChatFooterCustom.c(ChatFooterCustom.this);
        AppMethodBeat.o(30464);
      }
    });
    this.zxa = ((ImageView)findViewById(2131822501));
    this.zxa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30465);
        ChatFooterCustom.d(ChatFooterCustom.this).dGj();
        paramAnonymousView = (ImageView)paramAnonymousView;
        int j;
        if (paramAnonymousView.getTag() == null)
        {
          paramAnonymousView.setTag(new Object());
          paramAnonymousView.setImageResource(2130839685);
          i = 0;
          if (i < ChatFooterCustom.e(ChatFooterCustom.this))
          {
            paramAnonymousView = ChatFooterCustom.f(ChatFooterCustom.this).getChildAt(i);
            if (i >= 3) {}
            for (j = 0;; j = 8)
            {
              paramAnonymousView.setVisibility(j);
              i += 1;
              break;
            }
          }
          AppMethodBeat.o(30465);
          return;
        }
        paramAnonymousView.setTag(null);
        paramAnonymousView.setImageResource(2130839684);
        int i = 0;
        if (i < ChatFooterCustom.e(ChatFooterCustom.this))
        {
          paramAnonymousView = ChatFooterCustom.f(ChatFooterCustom.this).getChildAt(i);
          if (i < 3) {}
          for (j = 0;; j = 8)
          {
            paramAnonymousView.setVisibility(j);
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(30465);
      }
    });
    this.zxd = new g(getContext(), paramViewGroup);
    this.zxd.zxo = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(30466);
        ChatFooterCustom.this.onClick(paramAnonymousView);
        AppMethodBeat.o(30466);
      }
    };
    AppMethodBeat.o(30488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */