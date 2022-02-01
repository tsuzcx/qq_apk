package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.autogen.a.fk;
import com.tencent.mm.autogen.a.sm;
import com.tencent.mm.autogen.a.sm.a;
import com.tencent.mm.autogen.a.sn;
import com.tencent.mm.autogen.a.sn.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.chatting.component.BizComponent.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom
  extends LinearLayout
  implements View.OnClickListener, cl.a
{
  private com.tencent.mm.api.c MVg;
  private ChatFooter.g YfB;
  private MMFragment adFi;
  private ImageView aefA;
  public ImageView aefB;
  public LinearLayout aefC;
  public h aefD;
  private BizComponent.a aefE;
  private Boolean aefF;
  private Map<String, ar> aefG;
  private List<ar> aefH;
  private int aefI;
  private cm aefJ;
  private GetLocationListener aefK;
  private GetScanCodeListener aefL;
  private List<String> aefM;
  private final String aefN;
  private final String aefO;
  private com.tencent.mm.an.k aefP;
  private au hRm;
  private String sWX;
  private Object wrI;
  public LinearLayout xYI;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34319);
    this.xYI = null;
    this.aefA = null;
    this.aefB = null;
    this.aefC = null;
    this.aefD = null;
    this.YfB = null;
    this.aefE = null;
    this.aefF = Boolean.FALSE;
    this.aefG = new ConcurrentHashMap();
    this.aefH = new ArrayList();
    this.aefI = 0;
    this.aefM = new LinkedList();
    this.aefN = "qrcode";
    this.aefO = "barcode";
    this.wrI = new Object();
    AppMethodBeat.o(34319);
  }
  
  private void a(com.tencent.mm.an.k paramk, String paramString)
  {
    AppMethodBeat.i(34328);
    b(this.sWX, paramk.id, paramk.key, com.tencent.mm.an.k.owm, paramk.name, "", paramString);
    AppMethodBeat.o(34328);
  }
  
  private boolean a(com.tencent.mm.an.k paramk)
  {
    AppMethodBeat.i(34327);
    if (paramk == null)
    {
      AppMethodBeat.o(34327);
      return false;
    }
    String str = paramk.id + paramk.key;
    paramk = this.wrI;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.aefM.size())
        {
          if (((String)this.aefM.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.aefM.remove(i);
              Log.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.aefM.size()) });
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          Log.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.aefM.size()) });
          AppMethodBeat.o(34327);
          return false;
        }
      }
      finally
      {
        AppMethodBeat.o(34327);
      }
    }
  }
  
  private void b(com.tencent.mm.an.k paramk)
  {
    AppMethodBeat.i(34329);
    b(this.sWX, paramk.id, paramk.key, com.tencent.mm.an.k.own, paramk.name, "", paramk.value);
    AppMethodBeat.o(34329);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(34330);
    Log.d("ChatCustomFooter", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    com.tencent.mm.plugin.report.service.h.OAn.b(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(34330);
  }
  
  private static String bAA(String paramString)
  {
    AppMethodBeat.i(34334);
    if (e.e.boQ(paramString))
    {
      AppMethodBeat.o(34334);
      return "qrcode";
    }
    AppMethodBeat.o(34334);
    return "barcode";
  }
  
  private void c(com.tencent.mm.an.k paramk)
  {
    AppMethodBeat.i(34335);
    Log.i("ChatCustomFooter", paramk.getInfo());
    paramk = new com.tencent.mm.an.w(this.sWX, paramk.getInfo());
    bh.aZW().a(paramk, 0);
    AppMethodBeat.o(34335);
  }
  
  private boolean gI(Object paramObject)
  {
    AppMethodBeat.i(34332);
    if (!(paramObject instanceof sm))
    {
      Log.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(34332);
      return true;
    }
    Object localObject = (sm)paramObject;
    double d1 = ((sm)localObject).hVG.lat;
    double d2 = ((sm)localObject).hVG.lng;
    int i = ((sm)localObject).hVG.hQp;
    paramObject = ((sm)localObject).hVG.label;
    localObject = ((sm)localObject).hVG.hVI;
    Log.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, localObject });
    if ((this.aefP == null) || (this.aefP.owp != 105))
    {
      Log.e("ChatCustomFooter", "cache lost or location type is not correct");
      AppMethodBeat.o(34332);
      return true;
    }
    this.aefP.state = com.tencent.mm.an.k.own;
    this.aefP.a(d1, d2, i, paramObject, (String)localObject);
    if (a(this.aefP))
    {
      c(this.aefP);
      b(this.aefP);
    }
    AppMethodBeat.o(34332);
    return true;
  }
  
  private boolean gJ(Object paramObject)
  {
    AppMethodBeat.i(34333);
    if ((paramObject == null) || (!(paramObject instanceof sn)))
    {
      AppMethodBeat.o(34333);
      return false;
    }
    String str2 = ((sn)paramObject).hVJ.hVL;
    String str1 = ((sn)paramObject).hVJ.scanResult;
    paramObject = str1;
    if (!e.e.boQ(str2)) {
      paramObject = str2 + "," + str1;
    }
    if ((this.aefP == null) || ((this.aefP.owp != 100) && (this.aefP.owp != 101)))
    {
      Log.e("ChatCustomFooter", "null pointer in cache or type error");
      AppMethodBeat.o(34333);
      return false;
    }
    Log.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { str2, paramObject });
    this.aefP.state = com.tencent.mm.an.k.own;
    this.aefP.bv(bAA(str2), paramObject);
    if (a(this.aefP))
    {
      c(this.aefP);
      b(this.aefP);
    }
    AppMethodBeat.o(34333);
    return true;
  }
  
  private String getSender()
  {
    AppMethodBeat.i(34324);
    Object localObject = new StringBuilder("getSender ");
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.aefJ == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.aefJ != null) {
        break label86;
      }
    }
    label86:
    for (localObject = z.bAM();; localObject = this.aefJ.name)
    {
      Log.i("ChatCustomFooter", (String)localObject);
      if (this.aefJ != null) {
        break label97;
      }
      localObject = z.bAM();
      AppMethodBeat.o(34324);
      return localObject;
      bool = false;
      break;
    }
    label97:
    localObject = this.aefJ.name;
    AppMethodBeat.o(34324);
    return localObject;
  }
  
  private void joY()
  {
    AppMethodBeat.i(34322);
    if ((this.adFi != null) && (this.hRm != null) && (!ab.isNullOrNil(this.sWX))) {
      com.tencent.mm.pluginsdk.ui.tools.t.a(this.adFi, this.sWX, this.hRm.field_username);
    }
    AppMethodBeat.o(34322);
  }
  
  private void joZ()
  {
    AppMethodBeat.i(34323);
    u localu = new u(com.tencent.mm.loader.i.b.bmL());
    if ((!localu.jKS()) && (!localu.jKY()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(R.l.gzM), 1).show();
      AppMethodBeat.o(34323);
      return;
    }
    if ((this.adFi != null) && (!com.tencent.mm.pluginsdk.ui.tools.t.a(this.adFi, com.tencent.mm.loader.i.b.bmL(), "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(R.l.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(34323);
  }
  
  private void jpb()
  {
    AppMethodBeat.i(34338);
    Log.i("ChatCustomFooter", "switch footer");
    if (this.YfB != null)
    {
      this.aefD.diW();
      this.YfB.Ke(true);
    }
    AppMethodBeat.o(34338);
  }
  
  private void jpc()
  {
    AppMethodBeat.i(34339);
    if (this.hRm == null)
    {
      AppMethodBeat.o(34339);
      return;
    }
    if (this.hRm.hyY == 1)
    {
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxS(this.hRm.field_username);
    }
    AppMethodBeat.o(34339);
  }
  
  public final boolean Q(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(34331);
    if (paramObject == null)
    {
      Log.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
      AppMethodBeat.o(34331);
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
        AppMethodBeat.o(34331);
        return true;
        paramInt = 1001;
        continue;
        paramInt = 1002;
      }
    }
    Log.i("ChatCustomFooter", "return from camera");
    if (!(paramObject instanceof Intent))
    {
      Log.e("ChatCustomFooter", "type error");
      AppMethodBeat.o(34331);
      return true;
    }
    paramObject = ((Intent)paramObject).getStringExtra("CropImage_OutputPath");
    if (paramObject == null)
    {
      Log.e("ChatCustomFooter", "return null path");
      AppMethodBeat.o(34331);
      return true;
    }
    Object localObject = new u(paramObject);
    if ((((u)localObject).jKS()) && (((u)localObject).jKV()))
    {
      Log.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
      paramObject = y.bub(ah.v(((u)localObject).mUri));
      Log.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.aefP == null) || ((this.aefP.owp != 102) && (this.aefP.owp != 103)))
      {
        Log.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.aefP.state = com.tencent.mm.an.k.own;
      this.aefP.x((ArrayList)localObject);
      if (a(this.aefP))
      {
        c(this.aefP);
        b(this.aefP);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34331);
      return true;
      Log.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { paramObject });
    }
    Log.i("ChatCustomFooter", "return from albumn");
    if (!(paramObject instanceof Intent))
    {
      Log.e("ChatCustomFooter", "type error");
      AppMethodBeat.o(34331);
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
        Log.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[] { str });
        if (str != null)
        {
          u localu = new u(str);
          if ((localu.jKS()) && (localu.jKV()))
          {
            Log.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
            str = y.bub(ah.v(localu.mUri));
            paramObject.add(str);
            Log.i("ChatCustomFooter", "MD5 is %s", new Object[] { str });
          }
        }
        else
        {
          Log.e("ChatCustomFooter", "no file contained!");
          continue;
        }
        Log.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { str });
      }
      if ((this.aefP == null) || ((this.aefP.owp != 104) && (this.aefP.owp != 103) && (this.aefP.owp != 102)))
      {
        Log.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      this.aefP.state = com.tencent.mm.an.k.own;
      this.aefP.x(paramObject);
      if (a(this.aefP))
      {
        c(this.aefP);
        b(this.aefP);
      }
    }
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send current");
    gI(paramObject);
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send selected");
    gI(paramObject);
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send qrcode wait msg");
    if (!gJ(paramObject))
    {
      AppMethodBeat.o(34331);
      return true;
    }
    this.aefE.jrn();
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send qrcode direct");
    gJ(paramObject);
    AppMethodBeat.o(34331);
    return true;
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(34337);
    parama = com.tencent.mm.platformtools.w.a(parama.mpN.YFG);
    Log.i("ChatCustomFooter", "SysCmdMsgExtension:".concat(String.valueOf(parama)));
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
        Log.printErrStackTrace("ChatCustomFooter", parama, "", new Object[0]);
        AppMethodBeat.o(34337);
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
          AppMethodBeat.o(34337);
          return;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public final void a(g.c paramc) {}
  
  public final void a(MMFragment paramMMFragment, com.tencent.mm.api.c paramc, String paramString)
  {
    AppMethodBeat.i(34320);
    c.b.c localc = paramc.dO(false).aBo();
    if ((localc == null) || (localc.hdq == null) || (paramString == null))
    {
      paramMMFragment = new IllegalArgumentException(" menuInfo or username is null ! ");
      AppMethodBeat.o(34320);
      throw paramMMFragment;
    }
    this.aefF = Boolean.valueOf(paramString.equals("gh_f0a92aa7146c"));
    this.aefI = Math.min(localc.hdq.size(), 6);
    Log.i("ChatCustomFooter", "setMenus, count:" + this.aefI);
    if (this.aefI <= 0)
    {
      paramMMFragment = new IllegalArgumentException(" mTabCount is invalid ! ");
      AppMethodBeat.o(34320);
      throw paramMMFragment;
    }
    int i;
    label171:
    Object localObject;
    final TextView localTextView;
    ImageView localImageView;
    final com.tencent.mm.an.k localk;
    if (this.aefI > 3)
    {
      this.aefA.setVisibility(0);
      this.xYI.setWeightSum(Math.min(this.aefI, 3));
      i = 0;
      if (i >= 6) {
        break label664;
      }
      localObject = (FrameLayout)this.xYI.getChildAt(i);
      localTextView = (TextView)((FrameLayout)localObject).findViewById(R.h.fyd);
      localTextView.setTextSize(1, Math.min(1.125F, com.tencent.mm.cd.a.getScaleSize(getContext())) * 17.0F);
      localImageView = (ImageView)((FrameLayout)localObject).findViewById(R.h.fyc);
      localImageView.setVisibility(8);
      if (i >= this.aefI) {
        break label605;
      }
      localk = (com.tencent.mm.an.k)localc.hdq.get(i);
      ((FrameLayout)localObject).setTag(localk);
      localTextView.setText(p.b(getContext(), localk.name));
      if (localk.type == 0)
      {
        int j = (int)localTextView.getTextSize() * 2 / 3;
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = j;
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setImageDrawable(bb.m(getContext(), R.k.biz_menu_show_sub_menu_icon, getContext().getResources().getColor(R.e.FG_2)));
        localImageView.setVisibility(0);
      }
      ((FrameLayout)localObject).setOnClickListener(this);
      ((FrameLayout)localObject).setVisibility(0);
      if (this.aefF.booleanValue())
      {
        Log.i("ChatCustomFooter", "needShowRedDot：register RedDotComponent");
        Log.i("ChatCustomFooter", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (!this.aefG.containsKey(localk.key)) {
          break label493;
        }
        Log.d("ChatCustomFooter", "this key has register");
        label463:
        this.aefD.d(localk);
      }
    }
    for (;;)
    {
      i += 1;
      break label171;
      this.aefA.setVisibility(8);
      break;
      label493:
      localObject = new ar(getContext(), localk.key, new ar.a()
      {
        public final void aR(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(253720);
          Log.d("ChatCustomFooter", "OnShowRedDot show：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          if (localTextView == null)
          {
            Log.d("ChatCustomFooter", "OnShowRedDot mTextView == null");
            AppMethodBeat.o(253720);
            return;
          }
          if (paramAnonymousBoolean)
          {
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(253996);
                Object localObject = ChatFooterCustom.this.getContext().getResources().getDrawable(R.g.unread_dot_shape);
                ((Drawable)localObject).setBounds(0, 0, bd.fromDPToPix(ChatFooterCustom.this.getContext(), 8), bd.fromDPToPix(ChatFooterCustom.this.getContext(), 8));
                localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
                SpannableString localSpannableString = new SpannableString("@");
                localSpannableString.setSpan(localObject, 0, 1, 33);
                Log.i("ChatCustomFooter", "setReddotText：%s", new Object[] { ChatFooterCustom.5.this.aefS.key });
                ChatFooterCustom.5.this.aefR.setText(TextUtils.concat(new CharSequence[] { p.b(ChatFooterCustom.this.getContext(), ChatFooterCustom.5.this.aefS.name) + " ", localSpannableString }));
                AppMethodBeat.o(253996);
              }
            }, 500L);
            AppMethodBeat.o(253720);
            return;
          }
          Log.i("ChatCustomFooter", "dont setReddotText:%s", new Object[] { localk.key });
          localTextView.setText(p.b(ChatFooterCustom.this.getContext(), localk.name));
          AppMethodBeat.o(253720);
        }
      });
      com.tencent.mm.plugin.newtips.a.gtf().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      this.aefG.put(localk.key, localObject);
      this.aefH.add(localObject);
      Log.d("ChatCustomFooter", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.aefG.size()), Integer.valueOf(this.aefH.size()) });
      break label463;
      label605:
      if ((i >= 3) && (this.aefI > 3))
      {
        ((FrameLayout)localObject).setTag(null);
        localTextView.setText("");
        localImageView.setVisibility(8);
        ((FrameLayout)localObject).setOnClickListener(null);
        ((FrameLayout)localObject).setVisibility(0);
      }
      else
      {
        ((FrameLayout)localObject).setVisibility(8);
      }
    }
    label664:
    this.adFi = paramMMFragment;
    this.sWX = paramString;
    this.MVg = paramc;
    if (this.aefK != null) {
      this.aefK.dead();
    }
    if (this.aefL != null) {
      this.aefL.dead();
    }
    this.aefK = new GetLocationListener();
    this.aefL = new GetScanCodeListener();
    this.aefK.alive();
    this.aefL.alive();
    AppMethodBeat.o(34320);
  }
  
  public final void ae(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34336);
    this.xYI = ((LinearLayout)findViewById(R.h.fyb));
    this.aefC = ((LinearLayout)findViewById(R.h.fyg));
    this.aefC.setVisibility(0);
    this.aefB = ((ImageView)findViewById(R.h.fyf));
    this.aefB.setVisibility(0);
    this.aefB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34314);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ChatFooterCustom.c(ChatFooterCustom.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34314);
      }
    });
    this.aefA = ((ImageView)findViewById(R.h.fya));
    this.aefA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34315);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ChatFooterCustom.d(ChatFooterCustom.this).diW();
        paramAnonymousView = (ImageView)paramAnonymousView;
        int i;
        int j;
        if (paramAnonymousView.getTag() == null)
        {
          paramAnonymousView.setTag(new Object());
          paramAnonymousView.setImageResource(R.g.fov);
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
        }
        else
        {
          paramAnonymousView.setTag(null);
          paramAnonymousView.setImageResource(R.g.fou);
          i = 0;
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
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34315);
      }
    });
    this.aefD = new h(getContext(), paramViewGroup);
    this.aefD.aefU = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34316);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        ChatFooterCustom.this.onClick(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(34316);
      }
    };
    AppMethodBeat.o(34336);
  }
  
  public au getTalker()
  {
    return this.hRm;
  }
  
  public String getTalkerUserName()
  {
    if (this.hRm == null) {
      return null;
    }
    return this.hRm.field_username;
  }
  
  public final void joX()
  {
    AppMethodBeat.i(34321);
    if (this.aefK != null) {
      this.aefK.dead();
    }
    if (this.aefL != null) {
      this.aefL.dead();
    }
    Log.i("ChatCustomFooter", " releaseRedDotResource()");
    Object localObject1;
    Object localObject2;
    if (this.aefD != null)
    {
      localObject1 = this.aefD;
      Log.i("MicroMsg.ChatFooterCustomSubmenu", "releaseRedDotResource()");
      ((h)localObject1).aefV = "";
      ((h)localObject1).iaS = false;
      if ((((h)localObject1).aefG != null) && (((h)localObject1).aefG.size() > 0)) {
        ((h)localObject1).aefG.clear();
      }
      if ((((h)localObject1).aefH != null) && (((h)localObject1).aefH.size() > 0))
      {
        localObject2 = ((h)localObject1).aefH.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ar localar = (ar)((Iterator)localObject2).next();
          com.tencent.mm.plugin.newtips.a.gtf();
          i.i(localar);
        }
        ((h)localObject1).aefH.clear();
      }
    }
    if ((this.aefG != null) && (this.aefG.size() > 0)) {
      this.aefG.clear();
    }
    if ((this.aefH != null) && (this.aefH.size() > 0))
    {
      localObject1 = this.aefH.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ar)((Iterator)localObject1).next();
        com.tencent.mm.plugin.newtips.a.gtf();
        i.i((com.tencent.mm.plugin.newtips.a.a)localObject2);
      }
      this.aefH.clear();
    }
    AppMethodBeat.o(34321);
  }
  
  public final void jpa()
  {
    AppMethodBeat.i(34325);
    if (this.aefD != null) {
      this.aefD.diW();
    }
    AppMethodBeat.o(34325);
  }
  
  public void onClick(View arg1)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        AppMethodBeat.i(34326);
        localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(???);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        localObject1 = ???.getTag();
        if (!(localObject1 instanceof com.tencent.mm.an.k))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34326);
          return;
        }
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(8);
        localObject3 = (com.tencent.mm.an.k)localObject1;
        if (this.aefF.booleanValue())
        {
          com.tencent.mm.plugin.newtips.a.gtf().a(new com.tencent.mm.plugin.newtips.b.e(((com.tencent.mm.an.k)localObject3).key));
          com.tencent.mm.plugin.report.service.h.OAn.b(19541, new Object[] { Integer.valueOf(2), ((com.tencent.mm.an.k)localObject3).key });
        }
        ((com.tencent.mm.an.k)localObject3).content = "";
        switch (((com.tencent.mm.an.k)localObject3).type)
        {
        case 0: 
          label204:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34326);
          continue;
          localObject1 = new int[2];
        }
      }
      finally {}
      ???.getLocationInWindow((int[])localObject1);
      Log.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(???.getWidth()) });
      Object localObject4 = this.aefD;
      int i = localObject1[0] + ???.getWidth() / 2;
      int j = localObject1[1];
      if (!((h)localObject4).isShowing())
      {
        ((h)localObject4).a((com.tencent.mm.an.k)localObject3, i, j);
      }
      else
      {
        ((h)localObject4).diW();
        if ((localObject3 != null) && ((((h)localObject4).aega.id != ((com.tencent.mm.an.k)localObject3).id) || (!((h)localObject4).aega.key.equals(((com.tencent.mm.an.k)localObject3).key))))
        {
          ((h)localObject4).a((com.tencent.mm.an.k)localObject3, i, j);
          continue;
          Log.i("ChatCustomFooter", "start webview url");
          jpc();
          this.aefD.diW();
          ((com.tencent.mm.an.k)localObject3).state = com.tencent.mm.an.k.owm;
          a((com.tencent.mm.an.k)localObject3, ((com.tencent.mm.an.k)localObject3).ihx);
          c((com.tencent.mm.an.k)localObject3);
          if ((!r.a.XNV.b(getContext(), ((com.tencent.mm.an.k)localObject3).value, new Object[0])) && (!f.a(((com.tencent.mm.an.k)localObject3).ihx, getContext(), this.adFi, this.sWX)))
          {
            ??? = new Intent();
            ???.putExtra("KPublisherId", "custom_menu");
            ???.putExtra("pre_username", this.sWX);
            ???.putExtra("prePublishId", "custom_menu");
            ???.putExtra("preUsername", this.sWX);
            ???.putExtra("preChatName", this.sWX);
            ???.putExtra("preChatTYPE", ac.aX(this.sWX, this.sWX));
            ???.putExtra("rawUrl", ((com.tencent.mm.an.k)localObject3).value);
            ???.putExtra("geta8key_username", this.sWX);
            ???.putExtra("from_scence", 1);
            ???.putExtra("key_enable_teen_mode_check", true);
            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
            continue;
            Log.i("ChatCustomFooter", "switch to input");
            this.aefD.diW();
            jpb();
            ((com.tencent.mm.an.k)localObject3).state = com.tencent.mm.an.k.owm;
            a((com.tencent.mm.an.k)localObject3, ((com.tencent.mm.an.k)localObject3).value);
            c((com.tencent.mm.an.k)localObject3);
            continue;
            Log.i("ChatCustomFooter", "get latest message");
            jpc();
            this.aefD.diW();
            ((com.tencent.mm.an.k)localObject3).state = com.tencent.mm.an.k.owm;
            a((com.tencent.mm.an.k)localObject3, ((com.tencent.mm.an.k)localObject3).value);
            c((com.tencent.mm.an.k)localObject3);
            this.aefE.jrn();
            if ((au.bwJ(getTalkerUserName())) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()) && (((com.tencent.mm.an.k)localObject3).key.equalsIgnoreCase("rselfmenu_2")) && (((com.tencent.mm.an.k)localObject3).value.contains("weixin://dl/")))
            {
              g.cB(getContext(), ((com.tencent.mm.an.k)localObject3).value);
              continue;
              jpc();
              this.aefD.diW();
              ((com.tencent.mm.an.k)localObject3).state = com.tencent.mm.an.k.owm;
              a((com.tencent.mm.an.k)localObject3, ((com.tencent.mm.an.k)localObject3).value);
              c((com.tencent.mm.an.k)localObject3);
              boolean bool = TextUtils.isEmpty(((com.tencent.mm.an.k)localObject3).value);
              if (!bool) {
                for (;;)
                {
                  for (;;)
                  {
                    try
                    {
                      ??? = new JSONObject(((com.tencent.mm.an.k)localObject3).value);
                      localObject1 = new AppBrandStatObject();
                      ((AppBrandStatObject)localObject1).scene = 1035;
                      if (ab.isNullOrNil(((com.tencent.mm.an.k)localObject3).key)) {
                        break label2002;
                      }
                      localObject4 = ((com.tencent.mm.an.k)localObject3).key.replace("_", "");
                      i = ((com.tencent.mm.an.k)localObject3).key.length() - ((String)localObject4).length();
                      ((AppBrandStatObject)localObject1).hzx = String.format("%s:%s:%s:%s", new Object[] { this.sWX, Integer.valueOf(i), ((com.tencent.mm.an.k)localObject3).name, ???.optString("pagePath") });
                      Log.d("ChatCustomFooter", "sceneNote = %s", new Object[] { ((AppBrandStatObject)localObject1).hzx });
                      localObject3 = (com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class);
                      localObject4 = getContext();
                      String str2 = ???.optString("userName");
                      String str3 = ???.optString("pagePath");
                      if (this.MVg != null) {
                        break label1059;
                      }
                      ??? = null;
                      ((com.tencent.mm.plugin.appbrand.service.t)localObject3).a((Context)localObject4, str2, null, 0, 0, str3, (AppBrandStatObject)localObject1, ???);
                    }
                    catch (JSONException ???)
                    {
                      Log.e("ChatCustomFooter", ???.getMessage());
                    }
                    break;
                    label1059:
                    ??? = this.MVg.field_appId;
                    continue;
                    Log.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                    jpc();
                    this.aefD.diW();
                    ((com.tencent.mm.an.k)localObject3).state = com.tencent.mm.an.k.STATE_START;
                    localObject1 = ((com.tencent.mm.an.k)localObject3).id + ((com.tencent.mm.an.k)localObject3).key;
                    synchronized (this.wrI)
                    {
                      this.aefM.add(localObject1);
                      Log.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.aefM.size()) });
                      b(this.sWX, ((com.tencent.mm.an.k)localObject3).id, ((com.tencent.mm.an.k)localObject3).key, com.tencent.mm.an.k.STATE_START, ((com.tencent.mm.an.k)localObject3).name, "", ((com.tencent.mm.an.k)localObject3).value);
                      this.aefP = ((com.tencent.mm.an.k)localObject3);
                      switch (((com.tencent.mm.an.k)localObject3).owp)
                      {
                      case 100: 
                        ??? = new Intent();
                        ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                        ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                        ???.putExtra("key_set_result_after_scan", true);
                        ???.putExtra("key_is_hide_right_btn", true);
                        ???.putExtra("key_scan_report_enter_scene", 2);
                        if (com.tencent.mm.n.a.p(getContext(), true)) {
                          break label204;
                        }
                        getContext();
                        if ((com.tencent.mm.bc.e.bNA()) || (com.tencent.mm.n.a.u(getContext(), true))) {
                          break label204;
                        }
                        com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                      }
                    }
                  }
                  ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                  ???.putExtra("key_set_result_after_scan", false);
                  ???.putExtra("key_is_hide_right_btn", true);
                  ???.putExtra("key_scan_report_enter_scene", 2);
                  if (com.tencent.mm.n.a.p(getContext(), true)) {
                    break;
                  }
                  getContext();
                  if ((com.tencent.mm.bc.e.bNA()) || (com.tencent.mm.n.a.u(getContext(), true))) {
                    break;
                  }
                  com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                  break;
                  joZ();
                  break;
                  bh.bCz();
                  if (!com.tencent.mm.model.c.isSDCardAvailable())
                  {
                    aa.nh(getContext());
                    break;
                  }
                  ??? = getContext().getString(R.l.gxf);
                  String str1 = getContext().getString(R.l.gxe);
                  localObject3 = getContext();
                  localObject4 = new k.d()
                  {
                    public final void qz(int paramAnonymousInt)
                    {
                      AppMethodBeat.i(34313);
                      switch (paramAnonymousInt)
                      {
                      }
                      for (;;)
                      {
                        AppMethodBeat.o(34313);
                        return;
                        ChatFooterCustom.a(ChatFooterCustom.this);
                        AppMethodBeat.o(34313);
                        return;
                        ChatFooterCustom.b(ChatFooterCustom.this);
                      }
                    }
                  };
                  com.tencent.mm.ui.base.k.a((Context)localObject3, null, new String[] { ???, str1 }, null, (k.d)localObject4);
                  break;
                  joY();
                  break;
                  ??? = new Intent();
                  ???.putExtra("map_view_type", 0);
                  ???.putExtra("map_sender_name", getSender());
                  ???.putExtra("map_talker_name", getTalkerUserName());
                  ???.putExtra("view_type_key", 1);
                  ???.putExtra("key_get_location_type", 1);
                  com.tencent.mm.br.c.b(getContext(), "location", ".ui.RedirectUI", ???);
                  break;
                  ??? = new fk();
                  ???.hFE.op = 1;
                  ???.hFE.userName = this.hRm.field_username;
                  ???.hFE.context = getContext();
                  ???.publish();
                  break;
                  ??? = new fk();
                  ???.hFE.op = 2;
                  ???.hFE.userName = this.hRm.field_username;
                  ???.hFE.context = getContext();
                  ???.publish();
                  break;
                  Log.i("ChatCustomFooter", "jump to search");
                  jpc();
                  this.aefD.diW();
                  ((com.tencent.mm.an.k)localObject3).state = com.tencent.mm.an.k.owm;
                  a((com.tencent.mm.an.k)localObject3, ((com.tencent.mm.an.k)localObject3).value);
                  c((com.tencent.mm.an.k)localObject3);
                  str1 = ((com.tencent.mm.an.k)localObject3).value;
                  ??? = "";
                  if (this.hRm != null) {
                    ??? = this.hRm.field_username;
                  }
                  Log.i("ChatCustomFooter", "bizMenu jumpToSearch username: %s, suggestData: %s", new Object[] { ???, str1 });
                  localObject3 = aj.ipS();
                  ((Intent)localObject3).putExtra("ftsneedkeyboard", true);
                  ((Intent)localObject3).putExtra("ftsbizscene", 75);
                  ((Intent)localObject3).putExtra("ftsType", 2);
                  localObject4 = aj.r(75, false, 2);
                  ((Map)localObject4).put("userName", ???);
                  if (!ab.isNullOrNil(str1)) {
                    ((Map)localObject4).put("thirdExtParam", str1);
                  }
                  ((Intent)localObject3).putExtra("rawUrl", aj.bo((Map)localObject4));
                  ((Intent)localObject3).putExtra("key_load_js_without_delay", true);
                  ((Intent)localObject3).putExtra("ftsbizusername", ???);
                  ((Intent)localObject3).addFlags(67108864);
                  com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", (Intent)localObject3);
                  break;
                  label2002:
                  i = 0;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setOnFooterSwitchListener(ChatFooter.g paramg)
  {
    this.YfB = paramg;
  }
  
  public void setOnProcessClickListener(BizComponent.a parama)
  {
    this.aefE = parama;
  }
  
  public void setTalker(au paramau)
  {
    this.hRm = paramau;
  }
  
  class GetLocationListener
    extends IListener<sm>
  {
    public GetLocationListener()
    {
      super();
      AppMethodBeat.i(161517);
      this.__eventId = sm.class.getName().hashCode();
      AppMethodBeat.o(161517);
    }
  }
  
  class GetScanCodeListener
    extends IListener<sn>
  {
    public GetScanCodeListener()
    {
      super();
      AppMethodBeat.i(161519);
      this.__eventId = sn.class.getName().hashCode();
      AppMethodBeat.o(161519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */