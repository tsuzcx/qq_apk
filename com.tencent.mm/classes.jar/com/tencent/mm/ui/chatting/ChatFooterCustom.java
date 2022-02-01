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
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.k;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.f.a.ez;
import com.tencent.mm.f.a.qx;
import com.tencent.mm.f.a.qx.a;
import com.tencent.mm.f.a.qy;
import com.tencent.mm.f.a.qy.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cj;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.h.d;
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
  implements View.OnClickListener, ck.a
{
  private com.tencent.mm.api.c GXj;
  private ChatFooter.g Rjr;
  private MMFragment WaN;
  private ImageView Wyd;
  public ImageView Wye;
  public LinearLayout Wyf;
  public g Wyg;
  private com.tencent.mm.ui.chatting.d.c.b Wyh;
  private Boolean Wyi;
  private Map<String, ap> Wyj;
  private List<ap> Wyk;
  private int Wyl;
  private cj Wym;
  private a Wyn;
  private b Wyo;
  private List<String> Wyp;
  private final String Wyq;
  private final String Wyr;
  private k Wys;
  private as fLE;
  private String pRV;
  private Object tnh;
  private LinearLayout uPX;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34319);
    this.uPX = null;
    this.Wyd = null;
    this.Wye = null;
    this.Wyf = null;
    this.Wyg = null;
    this.Rjr = null;
    this.Wyh = null;
    this.Wyi = Boolean.FALSE;
    this.Wyj = new ConcurrentHashMap();
    this.Wyk = new ArrayList();
    this.Wyl = 0;
    this.Wyp = new LinkedList();
    this.Wyq = "qrcode";
    this.Wyr = "barcode";
    this.tnh = new Object();
    AppMethodBeat.o(34319);
  }
  
  private void a(k paramk, String paramString)
  {
    AppMethodBeat.i(34328);
    b(this.pRV, paramk.id, paramk.key, k.lEF, paramk.name, "", paramString);
    AppMethodBeat.o(34328);
  }
  
  private boolean a(k paramk)
  {
    AppMethodBeat.i(34327);
    if (paramk == null)
    {
      AppMethodBeat.o(34327);
      return false;
    }
    String str = paramk.id + paramk.key;
    paramk = this.tnh;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.Wyp.size())
        {
          if (((String)this.Wyp.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.Wyp.remove(i);
              Log.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.Wyp.size()) });
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          Log.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.Wyp.size()) });
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
  
  private void b(k paramk)
  {
    AppMethodBeat.i(34329);
    b(this.pRV, paramk.id, paramk.key, k.lEH, paramk.name, "", paramk.value);
    AppMethodBeat.o(34329);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(34330);
    Log.d("ChatCustomFooter", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    com.tencent.mm.plugin.report.service.h.IzE.a(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(34330);
  }
  
  private static String byW(String paramString)
  {
    AppMethodBeat.i(34334);
    if (e.d.boW(paramString))
    {
      AppMethodBeat.o(34334);
      return "qrcode";
    }
    AppMethodBeat.o(34334);
    return "barcode";
  }
  
  private void c(k paramk)
  {
    AppMethodBeat.i(34335);
    Log.i("ChatCustomFooter", paramk.getInfo());
    paramk = new com.tencent.mm.ao.w(this.pRV, paramk.getInfo());
    bh.aGY().a(paramk, 0);
    AppMethodBeat.o(34335);
  }
  
  private boolean ek(Object paramObject)
  {
    AppMethodBeat.i(34332);
    if (!(paramObject instanceof qx))
    {
      Log.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(34332);
      return true;
    }
    Object localObject = (qx)paramObject;
    double d1 = ((qx)localObject).fPL.lat;
    double d2 = ((qx)localObject).fPL.lng;
    int i = ((qx)localObject).fPL.fKJ;
    paramObject = ((qx)localObject).fPL.label;
    localObject = ((qx)localObject).fPL.fPN;
    Log.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, localObject });
    if ((this.Wys == null) || (this.Wys.lEJ != 105))
    {
      Log.e("ChatCustomFooter", "cache lost or location type is not correct");
      AppMethodBeat.o(34332);
      return true;
    }
    this.Wys.state = k.lEH;
    this.Wys.a(d1, d2, i, paramObject, (String)localObject);
    if (a(this.Wys))
    {
      c(this.Wys);
      b(this.Wys);
    }
    AppMethodBeat.o(34332);
    return true;
  }
  
  private boolean el(Object paramObject)
  {
    AppMethodBeat.i(34333);
    if ((paramObject == null) || (!(paramObject instanceof qy)))
    {
      AppMethodBeat.o(34333);
      return false;
    }
    String str2 = ((qy)paramObject).fPO.fPQ;
    String str1 = ((qy)paramObject).fPO.scanResult;
    paramObject = str1;
    if (!e.d.boW(str2)) {
      paramObject = str2 + "," + str1;
    }
    if ((this.Wys == null) || ((this.Wys.lEJ != 100) && (this.Wys.lEJ != 101)))
    {
      Log.e("ChatCustomFooter", "null pointer in cache or type error");
      AppMethodBeat.o(34333);
      return false;
    }
    Log.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { str2, paramObject });
    this.Wys.state = k.lEH;
    this.Wys.bk(byW(str2), paramObject);
    if (a(this.Wys))
    {
      c(this.Wys);
      b(this.Wys);
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
    if (this.Wym == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.Wym != null) {
        break label86;
      }
    }
    label86:
    for (localObject = com.tencent.mm.model.z.bcZ();; localObject = this.Wym.name)
    {
      Log.i("ChatCustomFooter", (String)localObject);
      if (this.Wym != null) {
        break label97;
      }
      localObject = com.tencent.mm.model.z.bcZ();
      AppMethodBeat.o(34324);
      return localObject;
      bool = false;
      break;
    }
    label97:
    localObject = this.Wym.name;
    AppMethodBeat.o(34324);
    return localObject;
  }
  
  private void hMv()
  {
    AppMethodBeat.i(34322);
    if ((this.WaN != null) && (this.fLE != null) && (!ae.isNullOrNil(this.pRV))) {
      com.tencent.mm.pluginsdk.ui.tools.u.a(this.WaN, this.pRV, this.fLE.field_username);
    }
    AppMethodBeat.o(34322);
  }
  
  private void hMw()
  {
    AppMethodBeat.i(34323);
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSX());
    if ((!localq.ifE()) && (!localq.ifK()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(R.l.exi), 1).show();
      AppMethodBeat.o(34323);
      return;
    }
    if ((this.WaN != null) && (!com.tencent.mm.pluginsdk.ui.tools.u.a(this.WaN, com.tencent.mm.loader.j.b.aSX(), "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(R.l.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(34323);
  }
  
  private void hMy()
  {
    AppMethodBeat.i(34338);
    Log.i("ChatCustomFooter", "switch footer");
    if (this.Rjr != null)
    {
      this.Wyg.cFD();
      this.Rjr.Et(true);
    }
    AppMethodBeat.o(34338);
  }
  
  private void hMz()
  {
    AppMethodBeat.i(34339);
    if (this.fLE == null)
    {
      AppMethodBeat.o(34339);
      return;
    }
    if (this.fLE.hDp == 1)
    {
      bh.beI();
      com.tencent.mm.model.c.bbR().bwC(this.fLE.field_username);
    }
    AppMethodBeat.o(34339);
  }
  
  public final void U(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34336);
    this.uPX = ((LinearLayout)findViewById(R.h.dxx));
    this.Wyf = ((LinearLayout)findViewById(R.h.dxC));
    this.Wyf.setVisibility(0);
    this.Wye = ((ImageView)findViewById(R.h.dxB));
    this.Wye.setVisibility(0);
    this.Wye.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34314);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ChatFooterCustom.c(ChatFooterCustom.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34314);
      }
    });
    this.Wyd = ((ImageView)findViewById(R.h.dxw));
    this.Wyd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34315);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ChatFooterCustom.d(ChatFooterCustom.this).cFD();
        paramAnonymousView = (ImageView)paramAnonymousView;
        int i;
        int j;
        if (paramAnonymousView.getTag() == null)
        {
          paramAnonymousView.setTag(new Object());
          paramAnonymousView.setImageResource(R.g.dnX);
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
          paramAnonymousView.setImageResource(R.g.dnW);
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
    this.Wyg = new g(getContext(), paramViewGroup);
    this.Wyg.Wyx = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34316);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        ChatFooterCustom.this.onClick(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(34316);
      }
    };
    AppMethodBeat.o(34336);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(34337);
    parama = com.tencent.mm.platformtools.z.a(parama.jQG.RIF);
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
  
  public final void a(h.c paramc) {}
  
  public final void a(MMFragment paramMMFragment, com.tencent.mm.api.c paramc, String paramString)
  {
    AppMethodBeat.i(34320);
    c.b.c localc = paramc.dc(false).Zw();
    if ((localc == null) || (localc.eZQ == null) || (paramString == null))
    {
      paramMMFragment = new IllegalArgumentException(" menuInfo or username is null ! ");
      AppMethodBeat.o(34320);
      throw paramMMFragment;
    }
    this.Wyi = Boolean.valueOf(paramString.equals("gh_f0a92aa7146c"));
    this.Wyl = Math.min(localc.eZQ.size(), 6);
    Log.i("ChatCustomFooter", "setMenus, count:" + this.Wyl);
    if (this.Wyl <= 0)
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
    final k localk;
    if (this.Wyl > 3)
    {
      this.Wyd.setVisibility(0);
      this.uPX.setWeightSum(Math.min(this.Wyl, 3));
      i = 0;
      if (i >= 6) {
        break label664;
      }
      localObject = (FrameLayout)this.uPX.getChildAt(i);
      localTextView = (TextView)((FrameLayout)localObject).findViewById(R.h.dxz);
      localTextView.setTextSize(1, Math.min(1.125F, com.tencent.mm.ci.a.ez(getContext())) * 17.0F);
      localImageView = (ImageView)((FrameLayout)localObject).findViewById(R.h.dxy);
      localImageView.setVisibility(8);
      if (i >= this.Wyl) {
        break label605;
      }
      localk = (k)localc.eZQ.get(i);
      ((FrameLayout)localObject).setTag(localk);
      localTextView.setText(l.c(getContext(), localk.name));
      if (localk.type == 0)
      {
        int j = (int)localTextView.getTextSize() * 2 / 3;
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = j;
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setImageDrawable(au.o(getContext(), R.k.biz_menu_show_sub_menu_icon, getContext().getResources().getColor(R.e.FG_2)));
        localImageView.setVisibility(0);
      }
      ((FrameLayout)localObject).setOnClickListener(this);
      ((FrameLayout)localObject).setVisibility(0);
      if (this.Wyi.booleanValue())
      {
        Log.i("ChatCustomFooter", "needShowRedDot：register RedDotComponent");
        Log.i("ChatCustomFooter", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (!this.Wyj.containsKey(localk.key)) {
          break label493;
        }
        Log.d("ChatCustomFooter", "this key has register");
        label463:
        this.Wyg.d(localk);
      }
    }
    for (;;)
    {
      i += 1;
      break label171;
      this.Wyd.setVisibility(8);
      break;
      label493:
      localObject = new ap(getContext(), localk.key, new ap.a()
      {
        public final void U(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(291257);
          Log.d("ChatCustomFooter", "OnShowRedDot show：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          if (localTextView == null)
          {
            Log.d("ChatCustomFooter", "OnShowRedDot mTextView == null");
            AppMethodBeat.o(291257);
            return;
          }
          if (paramAnonymousBoolean)
          {
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(286530);
                Object localObject = ChatFooterCustom.this.getContext().getResources().getDrawable(R.g.unread_dot_shape);
                ((Drawable)localObject).setBounds(0, 0, aw.fromDPToPix(ChatFooterCustom.this.getContext(), 8), aw.fromDPToPix(ChatFooterCustom.this.getContext(), 8));
                localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
                SpannableString localSpannableString = new SpannableString("@");
                localSpannableString.setSpan(localObject, 0, 1, 33);
                Log.i("ChatCustomFooter", "setReddotText：%s", new Object[] { ChatFooterCustom.5.this.Wyv.key });
                ChatFooterCustom.5.this.Wyu.setText(TextUtils.concat(new CharSequence[] { l.c(ChatFooterCustom.this.getContext(), ChatFooterCustom.5.this.Wyv.name) + " ", localSpannableString }));
                AppMethodBeat.o(286530);
              }
            }, 500L);
            AppMethodBeat.o(291257);
            return;
          }
          Log.i("ChatCustomFooter", "dont setReddotText:%s", new Object[] { localk.key });
          localTextView.setText(l.c(ChatFooterCustom.this.getContext(), localk.name));
          AppMethodBeat.o(291257);
        }
      });
      com.tencent.mm.plugin.newtips.a.fiO().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      this.Wyj.put(localk.key, localObject);
      this.Wyk.add(localObject);
      Log.d("ChatCustomFooter", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.Wyj.size()), Integer.valueOf(this.Wyk.size()) });
      break label463;
      label605:
      if ((i >= 3) && (this.Wyl > 3))
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
    this.WaN = paramMMFragment;
    this.pRV = paramString;
    this.GXj = paramc;
    if (this.Wyn != null) {
      EventCenter.instance.removeListener(this.Wyn);
    }
    if (this.Wyo != null) {
      EventCenter.instance.removeListener(this.Wyo);
    }
    this.Wyn = new a((byte)0);
    this.Wyo = new b((byte)0);
    EventCenter.instance.addListener(this.Wyn);
    EventCenter.instance.addListener(this.Wyo);
    AppMethodBeat.o(34320);
  }
  
  public as getTalker()
  {
    return this.fLE;
  }
  
  public String getTalkerUserName()
  {
    if (this.fLE == null) {
      return null;
    }
    return this.fLE.field_username;
  }
  
  public final void hMu()
  {
    AppMethodBeat.i(34321);
    if (this.Wyn != null) {
      EventCenter.instance.removeListener(this.Wyn);
    }
    if (this.Wyo != null) {
      EventCenter.instance.removeListener(this.Wyo);
    }
    Log.i("ChatCustomFooter", " releaseRedDotResource()");
    Object localObject1;
    Object localObject2;
    if (this.Wyg != null)
    {
      localObject1 = this.Wyg;
      Log.i("MicroMsg.ChatFooterCustomSubmenu", "releaseRedDotResource()");
      ((g)localObject1).Wyy = "";
      ((g)localObject1).fUV = false;
      if ((((g)localObject1).Wyj != null) && (((g)localObject1).Wyj.size() > 0)) {
        ((g)localObject1).Wyj.clear();
      }
      if ((((g)localObject1).Wyk != null) && (((g)localObject1).Wyk.size() > 0))
      {
        localObject2 = ((g)localObject1).Wyk.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ap localap = (ap)((Iterator)localObject2).next();
          com.tencent.mm.plugin.newtips.a.fiO();
          i.i(localap);
        }
        ((g)localObject1).Wyk.clear();
      }
    }
    if ((this.Wyj != null) && (this.Wyj.size() > 0)) {
      this.Wyj.clear();
    }
    if ((this.Wyk != null) && (this.Wyk.size() > 0))
    {
      localObject1 = this.Wyk.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ap)((Iterator)localObject1).next();
        com.tencent.mm.plugin.newtips.a.fiO();
        i.i((com.tencent.mm.plugin.newtips.a.a)localObject2);
      }
      this.Wyk.clear();
    }
    AppMethodBeat.o(34321);
  }
  
  public final void hMx()
  {
    AppMethodBeat.i(34325);
    if (this.Wyg != null) {
      this.Wyg.cFD();
    }
    AppMethodBeat.o(34325);
  }
  
  public void onClick(View arg1)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject3;
      try
      {
        AppMethodBeat.i(34326);
        localObject3 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject3).bn(???);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aFi());
        localObject3 = ???.getTag();
        if (!(localObject3 instanceof k))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34326);
          return;
        }
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(8);
        localObject3 = (k)localObject3;
        if (this.Wyi.booleanValue())
        {
          com.tencent.mm.plugin.newtips.a.fiO().a(new com.tencent.mm.plugin.newtips.b.e(((k)localObject3).key));
          com.tencent.mm.plugin.report.service.h.IzE.a(19541, new Object[] { Integer.valueOf(2), ((k)localObject3).key });
        }
        ((k)localObject3).content = "";
        switch (((k)localObject3).type)
        {
        case 0: 
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34326);
          continue;
          localObject1 = new int[2];
        }
      }
      finally {}
      ???.getLocationInWindow((int[])localObject1);
      Log.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(???.getWidth()) });
      Object localObject4 = this.Wyg;
      int i = localObject1[0] + ???.getWidth() / 2;
      int j = localObject1[1];
      if (!((g)localObject4).isShowing())
      {
        ((g)localObject4).a((k)localObject3, i, j);
      }
      else
      {
        ((g)localObject4).cFD();
        if ((localObject3 != null) && ((((g)localObject4).WyE.id != ((k)localObject3).id) || (!((g)localObject4).WyE.key.equals(((k)localObject3).key))))
        {
          ((g)localObject4).a((k)localObject3, i, j);
          continue;
          Log.i("ChatCustomFooter", "start webview url");
          hMz();
          this.Wyg.cFD();
          ((k)localObject3).state = k.lEF;
          a((k)localObject3, ((k)localObject3).gbn);
          c((k)localObject3);
          if ((!q.a.QSe.b(getContext(), ((k)localObject3).value, new Object[0])) && (!e.a(((k)localObject3).gbn, getContext(), this.WaN, this.pRV)))
          {
            ??? = new Intent();
            ???.putExtra("KPublisherId", "custom_menu");
            ???.putExtra("pre_username", this.pRV);
            ???.putExtra("prePublishId", "custom_menu");
            ???.putExtra("preUsername", this.pRV);
            ???.putExtra("preChatName", this.pRV);
            ???.putExtra("preChatTYPE", ac.aN(this.pRV, this.pRV));
            ???.putExtra("rawUrl", ((k)localObject3).value);
            ???.putExtra("geta8key_username", this.pRV);
            ???.putExtra("from_scence", 1);
            com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
            continue;
            Log.i("ChatCustomFooter", "switch to input");
            this.Wyg.cFD();
            hMy();
            ((k)localObject3).state = k.lEF;
            a((k)localObject3, ((k)localObject3).value);
            c((k)localObject3);
            continue;
            Log.i("ChatCustomFooter", "get latest message");
            hMz();
            this.Wyg.cFD();
            ((k)localObject3).state = k.lEF;
            a((k)localObject3, ((k)localObject3).value);
            c((k)localObject3);
            this.Wyh.hOv();
            if ((ab.PN(getTalkerUserName())) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()) && (((k)localObject3).key.equalsIgnoreCase("rselfmenu_2")) && (((k)localObject3).value.contains("weixin://dl/")))
            {
              com.tencent.mm.pluginsdk.g.cq(getContext(), ((k)localObject3).value);
              continue;
              hMz();
              this.Wyg.cFD();
              ((k)localObject3).state = k.lEF;
              a((k)localObject3, ((k)localObject3).value);
              c((k)localObject3);
              boolean bool = TextUtils.isEmpty(((k)localObject3).value);
              if (!bool)
              {
                try
                {
                  ??? = new JSONObject(((k)localObject3).value);
                  localObject3 = new AppBrandStatObject();
                  ((AppBrandStatObject)localObject3).scene = 1035;
                  ((AppBrandStatObject)localObject3).fvd = this.pRV;
                  localObject4 = (r)com.tencent.mm.kernel.h.ae(r.class);
                  Context localContext = getContext();
                  String str2 = ???.optString("userName");
                  String str3 = ???.optString("pagePath");
                  if (this.GXj == null) {}
                  for (??? = (View)localObject1;; ??? = this.GXj.field_appId)
                  {
                    ((r)localObject4).a(localContext, str2, null, 0, 0, str3, (AppBrandStatObject)localObject3, ???);
                    break;
                  }
                  Log.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                  hMz();
                  this.Wyg.cFD();
                  ((k)localObject3).state = k.lEG;
                  localObject1 = ((k)localObject3).id + ((k)localObject3).key;
                  synchronized (this.tnh)
                  {
                    this.Wyp.add(localObject1);
                    Log.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.Wyp.size()) });
                    b(this.pRV, ((k)localObject3).id, ((k)localObject3).key, k.lEG, ((k)localObject3).name, "", ((k)localObject3).value);
                    this.Wys = ((k)localObject3);
                    switch (((k)localObject3).lEJ)
                    {
                    case 100: 
                      ??? = new Intent();
                      ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                      ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                      ???.putExtra("key_set_result_after_scan", true);
                      ???.putExtra("key_is_hide_right_btn", true);
                      if (com.tencent.mm.q.a.p(getContext(), true)) {
                        continue;
                      }
                      getContext();
                      if ((com.tencent.mm.bj.e.bpU()) || (com.tencent.mm.q.a.t(getContext(), true))) {
                        continue;
                      }
                      com.tencent.mm.by.c.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                    }
                  }
                  ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                  ???.putExtra("key_set_result_after_scan", false);
                  ???.putExtra("key_is_hide_right_btn", true);
                  if (com.tencent.mm.q.a.p(getContext(), true)) {
                    continue;
                  }
                  getContext();
                  if ((com.tencent.mm.bj.e.bpU()) || (com.tencent.mm.q.a.t(getContext(), true))) {
                    continue;
                  }
                  com.tencent.mm.by.c.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                }
                catch (JSONException ???) {}
                hMw();
                continue;
                bh.beI();
                if (!com.tencent.mm.model.c.isSDCardAvailable())
                {
                  com.tencent.mm.ui.base.w.ld(getContext());
                }
                else
                {
                  ??? = getContext().getString(R.l.euG);
                  String str1 = getContext().getString(R.l.euF);
                  localObject3 = getContext();
                  localObject4 = new h.d()
                  {
                    public final void qy(int paramAnonymousInt)
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
                  com.tencent.mm.ui.base.h.a((Context)localObject3, null, new String[] { ???, str1 }, null, (h.d)localObject4);
                  continue;
                  hMv();
                  continue;
                  ??? = new Intent();
                  ???.putExtra("map_view_type", 0);
                  ???.putExtra("map_sender_name", getSender());
                  ???.putExtra("map_talker_name", getTalkerUserName());
                  ???.putExtra("view_type_key", 1);
                  ???.putExtra("key_get_location_type", 1);
                  com.tencent.mm.by.c.b(getContext(), "location", ".ui.RedirectUI", ???);
                  continue;
                  ??? = new ez();
                  ???.fAR.op = 1;
                  ???.fAR.userName = this.fLE.field_username;
                  ???.fAR.context = getContext();
                  EventCenter.instance.publish(???);
                  continue;
                  ??? = new ez();
                  ???.fAR.op = 2;
                  ???.fAR.userName = this.fLE.field_username;
                  ???.fAR.context = getContext();
                  EventCenter.instance.publish(???);
                  continue;
                  Log.i("ChatCustomFooter", "jump to search");
                  hMz();
                  this.Wyg.cFD();
                  ((k)localObject3).state = k.lEF;
                  a((k)localObject3, ((k)localObject3).value);
                  c((k)localObject3);
                  str1 = ((k)localObject3).value;
                  ??? = "";
                  if (this.fLE != null) {
                    ??? = this.fLE.field_username;
                  }
                  Log.i("ChatCustomFooter", "bizMenu jumpToSearch username: %s, suggestData: %s", new Object[] { ???, str1 });
                  localObject3 = ai.gQI();
                  ((Intent)localObject3).putExtra("ftsneedkeyboard", true);
                  ((Intent)localObject3).putExtra("ftsbizscene", 75);
                  ((Intent)localObject3).putExtra("ftsType", 2);
                  localObject4 = ai.j(75, false, 2);
                  ((Map)localObject4).put("userName", ???);
                  if (!ae.isNullOrNil(str1)) {
                    ((Map)localObject4).put("thirdExtParam", str1);
                  }
                  ((Intent)localObject3).putExtra("rawUrl", ai.aX((Map)localObject4));
                  ((Intent)localObject3).putExtra("key_load_js_without_delay", true);
                  ((Intent)localObject3).putExtra("ftsbizusername", ???);
                  ((Intent)localObject3).addFlags(67108864);
                  com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", (Intent)localObject3);
                  continue;
                  continue;
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
    this.Rjr = paramg;
  }
  
  public void setOnProcessClickListener(com.tencent.mm.ui.chatting.d.c.b paramb)
  {
    this.Wyh = paramb;
  }
  
  public void setTalker(as paramas)
  {
    this.fLE = paramas;
  }
  
  public final boolean w(int paramInt, Object paramObject)
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
    Object localObject = new com.tencent.mm.vfs.q(paramObject);
    if ((((com.tencent.mm.vfs.q)localObject).ifE()) && (((com.tencent.mm.vfs.q)localObject).ifH()))
    {
      Log.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
      paramObject = com.tencent.mm.vfs.u.buc(((com.tencent.mm.vfs.q)localObject).getPath());
      Log.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.Wys == null) || ((this.Wys.lEJ != 102) && (this.Wys.lEJ != 103)))
      {
        Log.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.Wys.state = k.lEH;
      this.Wys.u((ArrayList)localObject);
      if (a(this.Wys))
      {
        c(this.Wys);
        b(this.Wys);
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
          com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(str);
          if ((localq.ifE()) && (localq.ifH()))
          {
            Log.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
            str = com.tencent.mm.vfs.u.buc(localq.getPath());
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
      if ((this.Wys == null) || ((this.Wys.lEJ != 104) && (this.Wys.lEJ != 103) && (this.Wys.lEJ != 102)))
      {
        Log.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      this.Wys.state = k.lEH;
      this.Wys.u(paramObject);
      if (a(this.Wys))
      {
        c(this.Wys);
        b(this.Wys);
      }
    }
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send current");
    ek(paramObject);
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send selected");
    ek(paramObject);
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send qrcode wait msg");
    if (!el(paramObject))
    {
      AppMethodBeat.o(34331);
      return true;
    }
    this.Wyh.hOv();
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send qrcode direct");
    el(paramObject);
    AppMethodBeat.o(34331);
    return true;
  }
  
  final class a
    extends IListener<qx>
  {
    private a()
    {
      AppMethodBeat.i(161517);
      this.__eventId = qx.class.getName().hashCode();
      AppMethodBeat.o(161517);
    }
  }
  
  final class b
    extends IListener<qy>
  {
    private b()
    {
      AppMethodBeat.i(161519);
      this.__eventId = qy.class.getName().hashCode();
      AppMethodBeat.o(161519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */