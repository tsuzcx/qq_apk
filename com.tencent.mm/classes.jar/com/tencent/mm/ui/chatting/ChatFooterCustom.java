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
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.am.w;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.pg.a;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.ph.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.d.c.a;
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
  implements View.OnClickListener, cd.a
{
  private ChatFooter.g EZo;
  private MMFragment Jco;
  private ImageView JyQ;
  public ImageView JyR;
  public LinearLayout JyS;
  public g JyT;
  private c.a JyU;
  private Boolean JyV;
  private Map<String, an> JyW;
  private List<an> JyX;
  private int JyY;
  private ca JyZ;
  private a Jza;
  private b Jzb;
  private List<String> Jzc;
  private final String Jzd;
  private final String Jze;
  private com.tencent.mm.am.k Jzf;
  private Object diV;
  private am dzp;
  private String lEN;
  private LinearLayout pPh;
  private com.tencent.mm.api.c wPN;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34319);
    this.pPh = null;
    this.JyQ = null;
    this.JyR = null;
    this.JyS = null;
    this.JyT = null;
    this.EZo = null;
    this.JyU = null;
    this.JyV = Boolean.FALSE;
    this.JyW = new ConcurrentHashMap();
    this.JyX = new ArrayList();
    this.JyY = 0;
    this.Jzc = new LinkedList();
    this.Jzd = "qrcode";
    this.Jze = "barcode";
    this.diV = new Object();
    AppMethodBeat.o(34319);
  }
  
  private void a(com.tencent.mm.am.k paramk, String paramString)
  {
    AppMethodBeat.i(34328);
    b(this.lEN, paramk.id, paramk.key, com.tencent.mm.am.k.hQi, paramk.name, "", paramString);
    AppMethodBeat.o(34328);
  }
  
  private boolean a(com.tencent.mm.am.k paramk)
  {
    AppMethodBeat.i(34327);
    if (paramk == null)
    {
      AppMethodBeat.o(34327);
      return false;
    }
    String str = paramk.id + paramk.key;
    paramk = this.diV;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.Jzc.size())
        {
          if (((String)this.Jzc.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.Jzc.remove(i);
              ad.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.Jzc.size()) });
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          ad.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.Jzc.size()) });
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
  
  private static String aVR(String paramString)
  {
    AppMethodBeat.i(34334);
    if (e.d.aLh(paramString))
    {
      AppMethodBeat.o(34334);
      return "qrcode";
    }
    AppMethodBeat.o(34334);
    return "barcode";
  }
  
  private void b(com.tencent.mm.am.k paramk)
  {
    AppMethodBeat.i(34329);
    b(this.lEN, paramk.id, paramk.key, com.tencent.mm.am.k.hQk, paramk.name, "", paramk.value);
    AppMethodBeat.o(34329);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(34330);
    ad.d("ChatCustomFooter", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    com.tencent.mm.plugin.report.service.g.yhR.f(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(34330);
  }
  
  private void c(com.tencent.mm.am.k paramk)
  {
    AppMethodBeat.i(34335);
    ad.i("ChatCustomFooter", paramk.getInfo());
    paramk = new w(this.lEN, paramk.getInfo());
    ba.aiU().a(paramk, 0);
    AppMethodBeat.o(34335);
  }
  
  private boolean ea(Object paramObject)
  {
    AppMethodBeat.i(34332);
    if (!(paramObject instanceof pg))
    {
      ad.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(34332);
      return true;
    }
    Object localObject = (pg)paramObject;
    double d1 = ((pg)localObject).dDn.lat;
    double d2 = ((pg)localObject).dDn.lng;
    int i = ((pg)localObject).dDn.dyB;
    paramObject = ((pg)localObject).dDn.label;
    localObject = ((pg)localObject).dDn.dDq;
    ad.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, localObject });
    if ((this.Jzf == null) || (this.Jzf.hQm != 105))
    {
      ad.e("ChatCustomFooter", "cache lost or location type is not correct");
      AppMethodBeat.o(34332);
      return true;
    }
    this.Jzf.state = com.tencent.mm.am.k.hQk;
    this.Jzf.a(d1, d2, i, paramObject, (String)localObject);
    if (a(this.Jzf))
    {
      c(this.Jzf);
      b(this.Jzf);
    }
    AppMethodBeat.o(34332);
    return true;
  }
  
  private boolean eb(Object paramObject)
  {
    AppMethodBeat.i(34333);
    if ((paramObject == null) || (!(paramObject instanceof ph)))
    {
      AppMethodBeat.o(34333);
      return false;
    }
    String str2 = ((ph)paramObject).dDr.dDt;
    String str1 = ((ph)paramObject).dDr.scanResult;
    paramObject = str1;
    if (!e.d.aLh(str2)) {
      paramObject = str2 + "," + str1;
    }
    if ((this.Jzf == null) || ((this.Jzf.hQm != 100) && (this.Jzf.hQm != 101)))
    {
      ad.e("ChatCustomFooter", "null pointer in cache or type error");
      AppMethodBeat.o(34333);
      return false;
    }
    ad.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { str2, paramObject });
    this.Jzf.state = com.tencent.mm.am.k.hQk;
    this.Jzf.bb(aVR(str2), paramObject);
    if (a(this.Jzf))
    {
      c(this.Jzf);
      b(this.Jzf);
    }
    AppMethodBeat.o(34333);
    return true;
  }
  
  private void fBb()
  {
    AppMethodBeat.i(34322);
    if ((this.Jco != null) && (this.dzp != null) && (!af.isNullOrNil(this.lEN))) {
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.Jco, this.lEN, this.dzp.field_username);
    }
    AppMethodBeat.o(34322);
  }
  
  private void fBc()
  {
    AppMethodBeat.i(34323);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.asg());
    if ((!locale.exists()) && (!locale.mkdirs()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(2131757320), 1).show();
      AppMethodBeat.o(34323);
      return;
    }
    if ((this.Jco != null) && (!com.tencent.mm.pluginsdk.ui.tools.q.a(this.Jco, com.tencent.mm.loader.j.b.asg(), "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(2131763022), 1).show();
    }
    AppMethodBeat.o(34323);
  }
  
  private void fBe()
  {
    AppMethodBeat.i(34338);
    ad.i("ChatCustomFooter", "switch footer");
    if (this.EZo != null)
    {
      this.JyT.fBg();
      this.EZo.wg(true);
    }
    AppMethodBeat.o(34338);
  }
  
  private void fBf()
  {
    AppMethodBeat.i(34339);
    if (this.dzp == null)
    {
      AppMethodBeat.o(34339);
      return;
    }
    if (this.dzp.ePC == 1)
    {
      ba.aBQ();
      com.tencent.mm.model.c.azv().aTE(this.dzp.field_username);
    }
    AppMethodBeat.o(34339);
  }
  
  private String getSender()
  {
    AppMethodBeat.i(34324);
    Object localObject = new StringBuilder("getSender ");
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.JyZ == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.JyZ != null) {
        break label86;
      }
    }
    label86:
    for (localObject = u.aAm();; localObject = this.JyZ.name)
    {
      ad.i("ChatCustomFooter", (String)localObject);
      if (this.JyZ != null) {
        break label97;
      }
      localObject = u.aAm();
      AppMethodBeat.o(34324);
      return localObject;
      bool = false;
      break;
    }
    label97:
    localObject = this.JyZ.name;
    AppMethodBeat.o(34324);
    return localObject;
  }
  
  public final void C(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34336);
    this.pPh = ((LinearLayout)findViewById(2131298093));
    this.JyS = ((LinearLayout)findViewById(2131298098));
    this.JyS.setVisibility(0);
    this.JyR = ((ImageView)findViewById(2131298097));
    this.JyR.setVisibility(0);
    this.JyR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34314);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ChatFooterCustom.c(ChatFooterCustom.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34314);
      }
    });
    this.JyQ = ((ImageView)findViewById(2131298092));
    this.JyQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34315);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ChatFooterCustom.d(ChatFooterCustom.this).fBg();
        paramAnonymousView = (ImageView)paramAnonymousView;
        int i;
        int j;
        if (paramAnonymousView.getTag() == null)
        {
          paramAnonymousView.setTag(new Object());
          paramAnonymousView.setImageResource(2131233308);
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
          paramAnonymousView.setImageResource(2131233307);
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
    this.JyT = new g(getContext(), paramViewGroup);
    this.JyT.Jzk = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34316);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        ChatFooterCustom.this.onClick(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(34316);
      }
    };
    AppMethodBeat.o(34336);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(34337);
    parama = z.a(parama.gqE.Fvk);
    ad.i("ChatCustomFooter", "SysCmdMsgExtension:".concat(String.valueOf(parama)));
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
        ad.printErrStackTrace("ChatCustomFooter", parama, "", new Object[0]);
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
  
  public final void a(e.c paramc) {}
  
  public final void a(MMFragment paramMMFragment, com.tencent.mm.api.c paramc, String paramString)
  {
    AppMethodBeat.i(34320);
    c.b.c localc = paramc.bX(false).KM();
    if ((localc == null) || (localc.cRg == null) || (paramString == null))
    {
      paramMMFragment = new IllegalArgumentException(" menuInfo or username is null ! ");
      AppMethodBeat.o(34320);
      throw paramMMFragment;
    }
    this.JyV = Boolean.valueOf(paramString.equals("gh_f0a92aa7146c"));
    this.JyY = Math.min(localc.cRg.size(), 6);
    ad.i("ChatCustomFooter", "setMenus, count:" + this.JyY);
    if (this.JyY <= 0)
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
    final com.tencent.mm.am.k localk;
    if (this.JyY > 3)
    {
      this.JyQ.setVisibility(0);
      this.pPh.setWeightSum(Math.min(this.JyY, 3));
      i = 0;
      if (i >= 6) {
        break label664;
      }
      localObject = (FrameLayout)this.pPh.getChildAt(i);
      localTextView = (TextView)((FrameLayout)localObject).findViewById(2131298095);
      localTextView.setTextSize(1, Math.min(1.125F, com.tencent.mm.cc.a.eb(getContext())) * 17.0F);
      localImageView = (ImageView)((FrameLayout)localObject).findViewById(2131298094);
      localImageView.setVisibility(8);
      if (i >= this.JyY) {
        break label605;
      }
      localk = (com.tencent.mm.am.k)localc.cRg.get(i);
      ((FrameLayout)localObject).setTag(localk);
      localTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), localk.name));
      if (localk.type == 0)
      {
        int j = (int)localTextView.getTextSize() * 2 / 3;
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = j;
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setImageDrawable(ao.k(getContext(), 2131689769, getContext().getResources().getColor(2131099735)));
        localImageView.setVisibility(0);
      }
      ((FrameLayout)localObject).setOnClickListener(this);
      ((FrameLayout)localObject).setVisibility(0);
      if (this.JyV.booleanValue())
      {
        ad.i("ChatCustomFooter", "needShowRedDot：register RedDotComponent");
        ad.i("ChatCustomFooter", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (!this.JyW.containsKey(localk.key)) {
          break label493;
        }
        ad.d("ChatCustomFooter", "this key has register");
        label463:
        this.JyT.d(localk);
      }
    }
    for (;;)
    {
      i += 1;
      break label171;
      this.JyQ.setVisibility(8);
      break;
      label493:
      localObject = new an(getContext(), localk.key, new an.a()
      {
        public final void L(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(193836);
          ad.d("ChatCustomFooter", "OnShowRedDot show：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          if (localTextView == null)
          {
            ad.d("ChatCustomFooter", "OnShowRedDot mTextView == null");
            AppMethodBeat.o(193836);
            return;
          }
          if (paramAnonymousBoolean)
          {
            new ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(193835);
                Object localObject = ChatFooterCustom.this.getContext().getResources().getDrawable(2131234447);
                ((Drawable)localObject).setBounds(0, 0, aq.fromDPToPix(ChatFooterCustom.this.getContext(), 8), aq.fromDPToPix(ChatFooterCustom.this.getContext(), 8));
                localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
                SpannableString localSpannableString = new SpannableString("@");
                localSpannableString.setSpan(localObject, 0, 1, 33);
                ad.i("ChatCustomFooter", "setReddotText：%s", new Object[] { ChatFooterCustom.5.this.Jzi.key });
                ChatFooterCustom.5.this.Jzh.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.span.k.c(ChatFooterCustom.this.getContext(), ChatFooterCustom.5.this.Jzi.name) + " ", localSpannableString }));
                AppMethodBeat.o(193835);
              }
            }, 500L);
            AppMethodBeat.o(193836);
            return;
          }
          ad.i("ChatCustomFooter", "dont setReddotText:%s", new Object[] { localk.key });
          localTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(ChatFooterCustom.this.getContext(), localk.name));
          AppMethodBeat.o(193836);
        }
      });
      com.tencent.mm.plugin.newtips.a.dun().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      this.JyW.put(localk.key, localObject);
      this.JyX.add(localObject);
      ad.d("ChatCustomFooter", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.JyW.size()), Integer.valueOf(this.JyX.size()) });
      break label463;
      label605:
      if ((i >= 3) && (this.JyY > 3))
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
    this.Jco = paramMMFragment;
    this.lEN = paramString;
    this.wPN = paramc;
    if (this.Jza != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.Jza);
    }
    if (this.Jzb != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.Jzb);
    }
    this.Jza = new a((byte)0);
    this.Jzb = new b((byte)0);
    com.tencent.mm.sdk.b.a.IbL.c(this.Jza);
    com.tencent.mm.sdk.b.a.IbL.c(this.Jzb);
    AppMethodBeat.o(34320);
  }
  
  public final void fBa()
  {
    AppMethodBeat.i(34321);
    if (this.Jza != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.Jza);
    }
    if (this.Jzb != null) {
      com.tencent.mm.sdk.b.a.IbL.d(this.Jzb);
    }
    ad.i("ChatCustomFooter", " releaseRedDotResource()");
    Object localObject1;
    Object localObject2;
    if (this.JyT != null)
    {
      localObject1 = this.JyT;
      ad.i("MicroMsg.ChatFooterCustomSubmenu", "releaseRedDotResource()");
      ((g)localObject1).Jzl = "";
      ((g)localObject1).dIh = false;
      if ((((g)localObject1).JyW != null) && (((g)localObject1).JyW.size() > 0)) {
        ((g)localObject1).JyW.clear();
      }
      if ((((g)localObject1).JyX != null) && (((g)localObject1).JyX.size() > 0))
      {
        localObject2 = ((g)localObject1).JyX.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          an localan = (an)((Iterator)localObject2).next();
          com.tencent.mm.plugin.newtips.a.dun();
          com.tencent.mm.plugin.newtips.a.i.i(localan);
        }
        ((g)localObject1).JyX.clear();
      }
    }
    if ((this.JyW != null) && (this.JyW.size() > 0)) {
      this.JyW.clear();
    }
    if ((this.JyX != null) && (this.JyX.size() > 0))
    {
      localObject1 = this.JyX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (an)((Iterator)localObject1).next();
        com.tencent.mm.plugin.newtips.a.dun();
        com.tencent.mm.plugin.newtips.a.i.i((com.tencent.mm.plugin.newtips.a.a)localObject2);
      }
      this.JyX.clear();
    }
    AppMethodBeat.o(34321);
  }
  
  public final void fBd()
  {
    AppMethodBeat.i(34325);
    if (this.JyT != null) {
      this.JyT.fBg();
    }
    AppMethodBeat.o(34325);
  }
  
  public am getTalker()
  {
    return this.dzp;
  }
  
  public String getTalkerUserName()
  {
    if (this.dzp == null) {
      return null;
    }
    return this.dzp.field_username;
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject3).bd(???);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject3).ahq());
        localObject3 = ???.getTag();
        if (!(localObject3 instanceof com.tencent.mm.am.k))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34326);
          return;
        }
        com.tencent.mm.pluginsdk.wallet.h.Zx(8);
        localObject3 = (com.tencent.mm.am.k)localObject3;
        if (this.JyV.booleanValue())
        {
          com.tencent.mm.plugin.newtips.a.dun().c(new com.tencent.mm.plugin.newtips.b.e(((com.tencent.mm.am.k)localObject3).key));
          com.tencent.mm.plugin.report.service.g.yhR.f(19541, new Object[] { Integer.valueOf(2), ((com.tencent.mm.am.k)localObject3).key });
        }
        ((com.tencent.mm.am.k)localObject3).content = "";
        switch (((com.tencent.mm.am.k)localObject3).type)
        {
        case 0: 
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34326);
          continue;
          localObject1 = new int[2];
        }
      }
      finally {}
      ???.getLocationOnScreen((int[])localObject1);
      ad.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(???.getWidth()) });
      Object localObject4 = this.JyT;
      int i = localObject1[0] + ???.getWidth() / 2;
      int j = localObject1[1];
      if (!((g)localObject4).isShowing())
      {
        ((g)localObject4).a((com.tencent.mm.am.k)localObject3, i, j);
      }
      else
      {
        ((g)localObject4).fBg();
        if ((localObject3 != null) && ((((g)localObject4).Jzr.id != ((com.tencent.mm.am.k)localObject3).id) || (!((g)localObject4).Jzr.key.equals(((com.tencent.mm.am.k)localObject3).key))))
        {
          ((g)localObject4).a((com.tencent.mm.am.k)localObject3, i, j);
          continue;
          ad.i("ChatCustomFooter", "start webview url");
          fBf();
          this.JyT.fBg();
          ((com.tencent.mm.am.k)localObject3).state = com.tencent.mm.am.k.hQi;
          a((com.tencent.mm.am.k)localObject3, ((com.tencent.mm.am.k)localObject3).dNL);
          c((com.tencent.mm.am.k)localObject3);
          if ((!q.a.EJC.b(getContext(), ((com.tencent.mm.am.k)localObject3).value, new Object[0])) && (!e.a(((com.tencent.mm.am.k)localObject3).dNL, getContext(), this.Jco, this.lEN)))
          {
            ??? = new Intent();
            ???.putExtra("KPublisherId", "custom_menu");
            ???.putExtra("pre_username", this.lEN);
            ???.putExtra("prePublishId", "custom_menu");
            ???.putExtra("preUsername", this.lEN);
            ???.putExtra("preChatName", this.lEN);
            ???.putExtra("preChatTYPE", x.aG(this.lEN, this.lEN));
            ???.putExtra("rawUrl", ((com.tencent.mm.am.k)localObject3).value);
            ???.putExtra("geta8key_username", this.lEN);
            ???.putExtra("from_scence", 1);
            d.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
            continue;
            ad.i("ChatCustomFooter", "switch to input");
            this.JyT.fBg();
            fBe();
            ((com.tencent.mm.am.k)localObject3).state = com.tencent.mm.am.k.hQi;
            a((com.tencent.mm.am.k)localObject3, ((com.tencent.mm.am.k)localObject3).value);
            c((com.tencent.mm.am.k)localObject3);
            continue;
            ad.i("ChatCustomFooter", "get latest message");
            fBf();
            this.JyT.fBg();
            ((com.tencent.mm.am.k)localObject3).state = com.tencent.mm.am.k.hQi;
            a((com.tencent.mm.am.k)localObject3, ((com.tencent.mm.am.k)localObject3).value);
            c((com.tencent.mm.am.k)localObject3);
            this.JyU.fCX();
            continue;
            fBf();
            this.JyT.fBg();
            ((com.tencent.mm.am.k)localObject3).state = com.tencent.mm.am.k.hQi;
            a((com.tencent.mm.am.k)localObject3, ((com.tencent.mm.am.k)localObject3).value);
            c((com.tencent.mm.am.k)localObject3);
            boolean bool = TextUtils.isEmpty(((com.tencent.mm.am.k)localObject3).value);
            if (!bool)
            {
              try
              {
                ??? = new JSONObject(((com.tencent.mm.am.k)localObject3).value);
                localObject3 = new AppBrandStatObject();
                ((AppBrandStatObject)localObject3).scene = 1035;
                ((AppBrandStatObject)localObject3).dkh = this.lEN;
                localObject4 = (o)com.tencent.mm.kernel.g.ab(o.class);
                Context localContext = getContext();
                String str2 = ???.optString("userName");
                String str3 = ???.optString("pagePath");
                if (this.wPN == null) {}
                for (??? = (View)localObject1;; ??? = this.wPN.field_appId)
                {
                  ((o)localObject4).a(localContext, str2, null, 0, 0, str3, (AppBrandStatObject)localObject3, ???);
                  break;
                }
                ad.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                fBf();
                this.JyT.fBg();
                ((com.tencent.mm.am.k)localObject3).state = com.tencent.mm.am.k.hQj;
                localObject1 = ((com.tencent.mm.am.k)localObject3).id + ((com.tencent.mm.am.k)localObject3).key;
                synchronized (this.diV)
                {
                  this.Jzc.add(localObject1);
                  ad.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.Jzc.size()) });
                  b(this.lEN, ((com.tencent.mm.am.k)localObject3).id, ((com.tencent.mm.am.k)localObject3).key, com.tencent.mm.am.k.hQj, ((com.tencent.mm.am.k)localObject3).name, "", ((com.tencent.mm.am.k)localObject3).value);
                  this.Jzf = ((com.tencent.mm.am.k)localObject3);
                  switch (((com.tencent.mm.am.k)localObject3).hQm)
                  {
                  case 100: 
                    ??? = new Intent();
                    ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                    ???.putExtra("key_set_result_after_scan", true);
                    ???.putExtra("key_is_hide_right_btn", true);
                    if (com.tencent.mm.s.a.n(getContext(), true)) {
                      continue;
                    }
                    getContext();
                    if ((com.tencent.mm.bi.e.aMh()) || (com.tencent.mm.s.a.p(getContext(), true))) {
                      continue;
                    }
                    d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                  }
                }
                ??? = new Intent();
                ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                ???.putExtra("key_set_result_after_scan", false);
                ???.putExtra("key_is_hide_right_btn", true);
                if (com.tencent.mm.s.a.n(getContext(), true)) {
                  continue;
                }
                getContext();
                if ((com.tencent.mm.bi.e.aMh()) || (com.tencent.mm.s.a.p(getContext(), true))) {
                  continue;
                }
                d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
              }
              catch (JSONException ???) {}
              fBc();
              continue;
              ba.aBQ();
              if (!com.tencent.mm.model.c.isSDCardAvailable())
              {
                t.kg(getContext());
              }
              else
              {
                ??? = getContext().getString(2131757149);
                String str1 = getContext().getString(2131757148);
                localObject3 = getContext();
                localObject4 = new h.c()
                {
                  public final void lf(int paramAnonymousInt)
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
                com.tencent.mm.ui.base.h.a((Context)localObject3, null, new String[] { ???, str1 }, null, (h.c)localObject4);
                continue;
                fBb();
                continue;
                ??? = new Intent();
                ???.putExtra("map_view_type", 0);
                ???.putExtra("map_sender_name", getSender());
                ???.putExtra("map_talker_name", getTalkerUserName());
                ???.putExtra("view_type_key", 1);
                ???.putExtra("key_get_location_type", 1);
                d.b(getContext(), "location", ".ui.RedirectUI", ???);
                continue;
                ??? = new eo();
                ???.dpI.op = 1;
                ???.dpI.userName = this.dzp.field_username;
                ???.dpI.context = getContext();
                com.tencent.mm.sdk.b.a.IbL.l(???);
                continue;
                ??? = new eo();
                ???.dpI.op = 2;
                ???.dpI.userName = this.dzp.field_username;
                ???.dpI.context = getContext();
                com.tencent.mm.sdk.b.a.IbL.l(???);
                continue;
                continue;
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean p(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(34331);
    if (paramObject == null)
    {
      ad.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
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
    ad.i("ChatCustomFooter", "return from camera");
    if (!(paramObject instanceof Intent))
    {
      ad.e("ChatCustomFooter", "type error");
      AppMethodBeat.o(34331);
      return true;
    }
    paramObject = ((Intent)paramObject).getStringExtra("CropImage_OutputPath");
    if (paramObject == null)
    {
      ad.e("ChatCustomFooter", "return null path");
      AppMethodBeat.o(34331);
      return true;
    }
    Object localObject = new com.tencent.mm.vfs.e(paramObject);
    if ((((com.tencent.mm.vfs.e)localObject).exists()) && (((com.tencent.mm.vfs.e)localObject).isFile()))
    {
      ad.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
      paramObject = com.tencent.mm.vfs.i.aPK(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject).mUri));
      ad.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.Jzf == null) || ((this.Jzf.hQm != 102) && (this.Jzf.hQm != 103)))
      {
        ad.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.Jzf.state = com.tencent.mm.am.k.hQk;
      this.Jzf.q((ArrayList)localObject);
      if (a(this.Jzf))
      {
        c(this.Jzf);
        b(this.Jzf);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34331);
      return true;
      ad.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { paramObject });
    }
    ad.i("ChatCustomFooter", "return from albumn");
    if (!(paramObject instanceof Intent))
    {
      ad.e("ChatCustomFooter", "type error");
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
        ad.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[] { str });
        if (str != null)
        {
          com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str);
          if ((locale.exists()) && (locale.isFile()))
          {
            ad.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
            str = com.tencent.mm.vfs.i.aPK(com.tencent.mm.vfs.q.B(locale.mUri));
            paramObject.add(str);
            ad.i("ChatCustomFooter", "MD5 is %s", new Object[] { str });
          }
        }
        else
        {
          ad.e("ChatCustomFooter", "no file contained!");
          continue;
        }
        ad.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { str });
      }
      if ((this.Jzf == null) || ((this.Jzf.hQm != 104) && (this.Jzf.hQm != 103) && (this.Jzf.hQm != 102)))
      {
        ad.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      this.Jzf.state = com.tencent.mm.am.k.hQk;
      this.Jzf.q(paramObject);
      if (a(this.Jzf))
      {
        c(this.Jzf);
        b(this.Jzf);
      }
    }
    AppMethodBeat.o(34331);
    return true;
    ad.i("ChatCustomFooter", "send current");
    ea(paramObject);
    AppMethodBeat.o(34331);
    return true;
    ad.i("ChatCustomFooter", "send selected");
    ea(paramObject);
    AppMethodBeat.o(34331);
    return true;
    ad.i("ChatCustomFooter", "send qrcode wait msg");
    if (!eb(paramObject))
    {
      AppMethodBeat.o(34331);
      return true;
    }
    this.JyU.fCX();
    AppMethodBeat.o(34331);
    return true;
    ad.i("ChatCustomFooter", "send qrcode direct");
    eb(paramObject);
    AppMethodBeat.o(34331);
    return true;
  }
  
  public void setOnFooterSwitchListener(ChatFooter.g paramg)
  {
    this.EZo = paramg;
  }
  
  public void setOnProcessClickListener(c.a parama)
  {
    this.JyU = parama;
  }
  
  public void setTalker(am paramam)
  {
    this.dzp = paramam;
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<pg>
  {
    private a()
    {
      AppMethodBeat.i(161517);
      this.__eventId = pg.class.getName().hashCode();
      AppMethodBeat.o(161517);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<ph>
  {
    private b()
    {
      AppMethodBeat.i(161519);
      this.__eventId = ph.class.getName().hashCode();
      AppMethodBeat.o(161519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */