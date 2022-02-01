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
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.ph.a;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.g.a.pi.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cb;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.d.c.a;
import com.tencent.mm.vfs.o;
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
  implements View.OnClickListener, cf.a
{
  private ChatFooter.g FrM;
  private ImageView JTG;
  public ImageView JTH;
  public LinearLayout JTI;
  public g JTJ;
  private c.a JTK;
  private Boolean JTL;
  private Map<String, ao> JTM;
  private List<ao> JTN;
  private int JTO;
  private cb JTP;
  private a JTQ;
  private b JTR;
  private List<String> JTS;
  private final String JTT;
  private final String JTU;
  private com.tencent.mm.al.k JTV;
  private MMFragment JwY;
  private an dAu;
  private Object djX;
  private String lJm;
  private LinearLayout pVM;
  private com.tencent.mm.api.c xfE;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34319);
    this.pVM = null;
    this.JTG = null;
    this.JTH = null;
    this.JTI = null;
    this.JTJ = null;
    this.FrM = null;
    this.JTK = null;
    this.JTL = Boolean.FALSE;
    this.JTM = new ConcurrentHashMap();
    this.JTN = new ArrayList();
    this.JTO = 0;
    this.JTS = new LinkedList();
    this.JTT = "qrcode";
    this.JTU = "barcode";
    this.djX = new Object();
    AppMethodBeat.o(34319);
  }
  
  private void a(com.tencent.mm.al.k paramk, String paramString)
  {
    AppMethodBeat.i(34328);
    b(this.lJm, paramk.id, paramk.key, com.tencent.mm.al.k.hTa, paramk.name, "", paramString);
    AppMethodBeat.o(34328);
  }
  
  private boolean a(com.tencent.mm.al.k paramk)
  {
    AppMethodBeat.i(34327);
    if (paramk == null)
    {
      AppMethodBeat.o(34327);
      return false;
    }
    String str = paramk.id + paramk.key;
    paramk = this.djX;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.JTS.size())
        {
          if (((String)this.JTS.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.JTS.remove(i);
              ae.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.JTS.size()) });
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          ae.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.JTS.size()) });
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
  
  private static String aXs(String paramString)
  {
    AppMethodBeat.i(34334);
    if (e.d.aMD(paramString))
    {
      AppMethodBeat.o(34334);
      return "qrcode";
    }
    AppMethodBeat.o(34334);
    return "barcode";
  }
  
  private void b(com.tencent.mm.al.k paramk)
  {
    AppMethodBeat.i(34329);
    b(this.lJm, paramk.id, paramk.key, com.tencent.mm.al.k.hTc, paramk.name, "", paramk.value);
    AppMethodBeat.o(34329);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(34330);
    ae.d("ChatCustomFooter", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    com.tencent.mm.plugin.report.service.g.yxI.f(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(34330);
  }
  
  private void c(com.tencent.mm.al.k paramk)
  {
    AppMethodBeat.i(34335);
    ae.i("ChatCustomFooter", paramk.getInfo());
    paramk = new com.tencent.mm.al.w(this.lJm, paramk.getInfo());
    bc.ajj().a(paramk, 0);
    AppMethodBeat.o(34335);
  }
  
  private boolean eb(Object paramObject)
  {
    AppMethodBeat.i(34332);
    if (!(paramObject instanceof ph))
    {
      ae.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(34332);
      return true;
    }
    Object localObject = (ph)paramObject;
    double d1 = ((ph)localObject).dEs.lat;
    double d2 = ((ph)localObject).dEs.lng;
    int i = ((ph)localObject).dEs.dzG;
    paramObject = ((ph)localObject).dEs.label;
    localObject = ((ph)localObject).dEs.dEv;
    ae.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, localObject });
    if ((this.JTV == null) || (this.JTV.hTe != 105))
    {
      ae.e("ChatCustomFooter", "cache lost or location type is not correct");
      AppMethodBeat.o(34332);
      return true;
    }
    this.JTV.state = com.tencent.mm.al.k.hTc;
    this.JTV.a(d1, d2, i, paramObject, (String)localObject);
    if (a(this.JTV))
    {
      c(this.JTV);
      b(this.JTV);
    }
    AppMethodBeat.o(34332);
    return true;
  }
  
  private boolean ec(Object paramObject)
  {
    AppMethodBeat.i(34333);
    if ((paramObject == null) || (!(paramObject instanceof pi)))
    {
      AppMethodBeat.o(34333);
      return false;
    }
    String str2 = ((pi)paramObject).dEw.dEy;
    String str1 = ((pi)paramObject).dEw.scanResult;
    paramObject = str1;
    if (!e.d.aMD(str2)) {
      paramObject = str2 + "," + str1;
    }
    if ((this.JTV == null) || ((this.JTV.hTe != 100) && (this.JTV.hTe != 101)))
    {
      ae.e("ChatCustomFooter", "null pointer in cache or type error");
      AppMethodBeat.o(34333);
      return false;
    }
    ae.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { str2, paramObject });
    this.JTV.state = com.tencent.mm.al.k.hTc;
    this.JTV.bb(aXs(str2), paramObject);
    if (a(this.JTV))
    {
      c(this.JTV);
      b(this.JTV);
    }
    AppMethodBeat.o(34333);
    return true;
  }
  
  private void fFd()
  {
    AppMethodBeat.i(34322);
    if ((this.JwY != null) && (this.dAu != null) && (!af.isNullOrNil(this.lJm))) {
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.JwY, this.lJm, this.dAu.field_username);
    }
    AppMethodBeat.o(34322);
  }
  
  private void fFe()
  {
    AppMethodBeat.i(34323);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(com.tencent.mm.loader.j.b.asv());
    if ((!localk.exists()) && (!localk.mkdirs()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(2131757320), 1).show();
      AppMethodBeat.o(34323);
      return;
    }
    if ((this.JwY != null) && (!com.tencent.mm.pluginsdk.ui.tools.q.a(this.JwY, com.tencent.mm.loader.j.b.asv(), "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(2131763022), 1).show();
    }
    AppMethodBeat.o(34323);
  }
  
  private void fFg()
  {
    AppMethodBeat.i(34338);
    ae.i("ChatCustomFooter", "switch footer");
    if (this.FrM != null)
    {
      this.JTJ.fFi();
      this.FrM.wo(true);
    }
    AppMethodBeat.o(34338);
  }
  
  private void fFh()
  {
    AppMethodBeat.i(34339);
    if (this.dAu == null)
    {
      AppMethodBeat.o(34339);
      return;
    }
    if (this.dAu.eRn == 1)
    {
      bc.aCg();
      com.tencent.mm.model.c.azL().aVf(this.dAu.field_username);
    }
    AppMethodBeat.o(34339);
  }
  
  private String getSender()
  {
    AppMethodBeat.i(34324);
    Object localObject = new StringBuilder("getSender ");
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.JTP == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.JTP != null) {
        break label86;
      }
    }
    label86:
    for (localObject = v.aAC();; localObject = this.JTP.name)
    {
      ae.i("ChatCustomFooter", (String)localObject);
      if (this.JTP != null) {
        break label97;
      }
      localObject = v.aAC();
      AppMethodBeat.o(34324);
      return localObject;
      bool = false;
      break;
    }
    label97:
    localObject = this.JTP.name;
    AppMethodBeat.o(34324);
    return localObject;
  }
  
  public final void C(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34336);
    this.pVM = ((LinearLayout)findViewById(2131298093));
    this.JTI = ((LinearLayout)findViewById(2131298098));
    this.JTI.setVisibility(0);
    this.JTH = ((ImageView)findViewById(2131298097));
    this.JTH.setVisibility(0);
    this.JTH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34314);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ChatFooterCustom.c(ChatFooterCustom.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34314);
      }
    });
    this.JTG = ((ImageView)findViewById(2131298092));
    this.JTG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34315);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ChatFooterCustom.d(ChatFooterCustom.this).fFi();
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
    this.JTJ = new g(getContext(), paramViewGroup);
    this.JTJ.JUa = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34316);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
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
    parama = z.a(parama.gte.FNI);
    ae.i("ChatCustomFooter", "SysCmdMsgExtension:".concat(String.valueOf(parama)));
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
        ae.printErrStackTrace("ChatCustomFooter", parama, "", new Object[0]);
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
    c.b.c localc = paramc.bX(false).KU();
    if ((localc == null) || (localc.cRQ == null) || (paramString == null))
    {
      paramMMFragment = new IllegalArgumentException(" menuInfo or username is null ! ");
      AppMethodBeat.o(34320);
      throw paramMMFragment;
    }
    this.JTL = Boolean.valueOf(paramString.equals("gh_f0a92aa7146c"));
    this.JTO = Math.min(localc.cRQ.size(), 6);
    ae.i("ChatCustomFooter", "setMenus, count:" + this.JTO);
    if (this.JTO <= 0)
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
    final com.tencent.mm.al.k localk;
    if (this.JTO > 3)
    {
      this.JTG.setVisibility(0);
      this.pVM.setWeightSum(Math.min(this.JTO, 3));
      i = 0;
      if (i >= 6) {
        break label664;
      }
      localObject = (FrameLayout)this.pVM.getChildAt(i);
      localTextView = (TextView)((FrameLayout)localObject).findViewById(2131298095);
      localTextView.setTextSize(1, Math.min(1.125F, com.tencent.mm.cb.a.ef(getContext())) * 17.0F);
      localImageView = (ImageView)((FrameLayout)localObject).findViewById(2131298094);
      localImageView.setVisibility(8);
      if (i >= this.JTO) {
        break label605;
      }
      localk = (com.tencent.mm.al.k)localc.cRQ.get(i);
      ((FrameLayout)localObject).setTag(localk);
      localTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), localk.name));
      if (localk.type == 0)
      {
        int j = (int)localTextView.getTextSize() * 2 / 3;
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = j;
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setImageDrawable(com.tencent.mm.ui.ao.k(getContext(), 2131689769, getContext().getResources().getColor(2131099735)));
        localImageView.setVisibility(0);
      }
      ((FrameLayout)localObject).setOnClickListener(this);
      ((FrameLayout)localObject).setVisibility(0);
      if (this.JTL.booleanValue())
      {
        ae.i("ChatCustomFooter", "needShowRedDot：register RedDotComponent");
        ae.i("ChatCustomFooter", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (!this.JTM.containsKey(localk.key)) {
          break label493;
        }
        ae.d("ChatCustomFooter", "this key has register");
        label463:
        this.JTJ.d(localk);
      }
    }
    for (;;)
    {
      i += 1;
      break label171;
      this.JTG.setVisibility(8);
      break;
      label493:
      localObject = new ao(getContext(), localk.key, new ao.a()
      {
        public final void N(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(187132);
          ae.d("ChatCustomFooter", "OnShowRedDot show：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          if (localTextView == null)
          {
            ae.d("ChatCustomFooter", "OnShowRedDot mTextView == null");
            AppMethodBeat.o(187132);
            return;
          }
          if (paramAnonymousBoolean)
          {
            new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187131);
                Object localObject = ChatFooterCustom.this.getContext().getResources().getDrawable(2131234447);
                ((Drawable)localObject).setBounds(0, 0, com.tencent.mm.ui.aq.fromDPToPix(ChatFooterCustom.this.getContext(), 8), com.tencent.mm.ui.aq.fromDPToPix(ChatFooterCustom.this.getContext(), 8));
                localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
                SpannableString localSpannableString = new SpannableString("@");
                localSpannableString.setSpan(localObject, 0, 1, 33);
                ae.i("ChatCustomFooter", "setReddotText：%s", new Object[] { ChatFooterCustom.5.this.JTY.key });
                ChatFooterCustom.5.this.JTX.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.span.k.c(ChatFooterCustom.this.getContext(), ChatFooterCustom.5.this.JTY.name) + " ", localSpannableString }));
                AppMethodBeat.o(187131);
              }
            }, 500L);
            AppMethodBeat.o(187132);
            return;
          }
          ae.i("ChatCustomFooter", "dont setReddotText:%s", new Object[] { localk.key });
          localTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(ChatFooterCustom.this.getContext(), localk.name));
          AppMethodBeat.o(187132);
        }
      });
      com.tencent.mm.plugin.newtips.a.dxD().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      this.JTM.put(localk.key, localObject);
      this.JTN.add(localObject);
      ae.d("ChatCustomFooter", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.JTM.size()), Integer.valueOf(this.JTN.size()) });
      break label463;
      label605:
      if ((i >= 3) && (this.JTO > 3))
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
    this.JwY = paramMMFragment;
    this.lJm = paramString;
    this.xfE = paramc;
    if (this.JTQ != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.JTQ);
    }
    if (this.JTR != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.JTR);
    }
    this.JTQ = new a((byte)0);
    this.JTR = new b((byte)0);
    com.tencent.mm.sdk.b.a.IvT.c(this.JTQ);
    com.tencent.mm.sdk.b.a.IvT.c(this.JTR);
    AppMethodBeat.o(34320);
  }
  
  public final void fFc()
  {
    AppMethodBeat.i(34321);
    if (this.JTQ != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.JTQ);
    }
    if (this.JTR != null) {
      com.tencent.mm.sdk.b.a.IvT.d(this.JTR);
    }
    ae.i("ChatCustomFooter", " releaseRedDotResource()");
    Object localObject1;
    Object localObject2;
    if (this.JTJ != null)
    {
      localObject1 = this.JTJ;
      ae.i("MicroMsg.ChatFooterCustomSubmenu", "releaseRedDotResource()");
      ((g)localObject1).JUb = "";
      ((g)localObject1).dJl = false;
      if ((((g)localObject1).JTM != null) && (((g)localObject1).JTM.size() > 0)) {
        ((g)localObject1).JTM.clear();
      }
      if ((((g)localObject1).JTN != null) && (((g)localObject1).JTN.size() > 0))
      {
        localObject2 = ((g)localObject1).JTN.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ao localao = (ao)((Iterator)localObject2).next();
          com.tencent.mm.plugin.newtips.a.dxD();
          i.i(localao);
        }
        ((g)localObject1).JTN.clear();
      }
    }
    if ((this.JTM != null) && (this.JTM.size() > 0)) {
      this.JTM.clear();
    }
    if ((this.JTN != null) && (this.JTN.size() > 0))
    {
      localObject1 = this.JTN.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ao)((Iterator)localObject1).next();
        com.tencent.mm.plugin.newtips.a.dxD();
        i.i((com.tencent.mm.plugin.newtips.a.a)localObject2);
      }
      this.JTN.clear();
    }
    AppMethodBeat.o(34321);
  }
  
  public final void fFf()
  {
    AppMethodBeat.i(34325);
    if (this.JTJ != null) {
      this.JTJ.fFi();
    }
    AppMethodBeat.o(34325);
  }
  
  public an getTalker()
  {
    return this.dAu;
  }
  
  public String getTalkerUserName()
  {
    if (this.dAu == null) {
      return null;
    }
    return this.dAu.field_username;
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject3).ahF());
        localObject3 = ???.getTag();
        if (!(localObject3 instanceof com.tencent.mm.al.k))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34326);
          return;
        }
        com.tencent.mm.pluginsdk.wallet.h.aad(8);
        localObject3 = (com.tencent.mm.al.k)localObject3;
        if (this.JTL.booleanValue())
        {
          com.tencent.mm.plugin.newtips.a.dxD().a(new com.tencent.mm.plugin.newtips.b.e(((com.tencent.mm.al.k)localObject3).key));
          com.tencent.mm.plugin.report.service.g.yxI.f(19541, new Object[] { Integer.valueOf(2), ((com.tencent.mm.al.k)localObject3).key });
        }
        ((com.tencent.mm.al.k)localObject3).content = "";
        switch (((com.tencent.mm.al.k)localObject3).type)
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
      ae.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(???.getWidth()) });
      Object localObject4 = this.JTJ;
      int i = localObject1[0] + ???.getWidth() / 2;
      int j = localObject1[1];
      if (!((g)localObject4).isShowing())
      {
        ((g)localObject4).a((com.tencent.mm.al.k)localObject3, i, j);
      }
      else
      {
        ((g)localObject4).fFi();
        if ((localObject3 != null) && ((((g)localObject4).JUh.id != ((com.tencent.mm.al.k)localObject3).id) || (!((g)localObject4).JUh.key.equals(((com.tencent.mm.al.k)localObject3).key))))
        {
          ((g)localObject4).a((com.tencent.mm.al.k)localObject3, i, j);
          continue;
          ae.i("ChatCustomFooter", "start webview url");
          fFh();
          this.JTJ.fFi();
          ((com.tencent.mm.al.k)localObject3).state = com.tencent.mm.al.k.hTa;
          a((com.tencent.mm.al.k)localObject3, ((com.tencent.mm.al.k)localObject3).dPb);
          c((com.tencent.mm.al.k)localObject3);
          if ((!q.a.Fca.b(getContext(), ((com.tencent.mm.al.k)localObject3).value, new Object[0])) && (!e.a(((com.tencent.mm.al.k)localObject3).dPb, getContext(), this.JwY, this.lJm)))
          {
            ??? = new Intent();
            ???.putExtra("KPublisherId", "custom_menu");
            ???.putExtra("pre_username", this.lJm);
            ???.putExtra("prePublishId", "custom_menu");
            ???.putExtra("preUsername", this.lJm);
            ???.putExtra("preChatName", this.lJm);
            ???.putExtra("preChatTYPE", y.aH(this.lJm, this.lJm));
            ???.putExtra("rawUrl", ((com.tencent.mm.al.k)localObject3).value);
            ???.putExtra("geta8key_username", this.lJm);
            ???.putExtra("from_scence", 1);
            d.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
            continue;
            ae.i("ChatCustomFooter", "switch to input");
            this.JTJ.fFi();
            fFg();
            ((com.tencent.mm.al.k)localObject3).state = com.tencent.mm.al.k.hTa;
            a((com.tencent.mm.al.k)localObject3, ((com.tencent.mm.al.k)localObject3).value);
            c((com.tencent.mm.al.k)localObject3);
            continue;
            ae.i("ChatCustomFooter", "get latest message");
            fFh();
            this.JTJ.fFi();
            ((com.tencent.mm.al.k)localObject3).state = com.tencent.mm.al.k.hTa;
            a((com.tencent.mm.al.k)localObject3, ((com.tencent.mm.al.k)localObject3).value);
            c((com.tencent.mm.al.k)localObject3);
            this.JTK.fGZ();
            continue;
            fFh();
            this.JTJ.fFi();
            ((com.tencent.mm.al.k)localObject3).state = com.tencent.mm.al.k.hTa;
            a((com.tencent.mm.al.k)localObject3, ((com.tencent.mm.al.k)localObject3).value);
            c((com.tencent.mm.al.k)localObject3);
            boolean bool = TextUtils.isEmpty(((com.tencent.mm.al.k)localObject3).value);
            if (!bool)
            {
              try
              {
                ??? = new JSONObject(((com.tencent.mm.al.k)localObject3).value);
                localObject3 = new AppBrandStatObject();
                ((AppBrandStatObject)localObject3).scene = 1035;
                ((AppBrandStatObject)localObject3).dlj = this.lJm;
                localObject4 = (p)com.tencent.mm.kernel.g.ab(p.class);
                Context localContext = getContext();
                String str2 = ???.optString("userName");
                String str3 = ???.optString("pagePath");
                if (this.xfE == null) {}
                for (??? = (View)localObject1;; ??? = this.xfE.field_appId)
                {
                  ((p)localObject4).a(localContext, str2, null, 0, 0, str3, (AppBrandStatObject)localObject3, ???);
                  break;
                }
                ae.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                fFh();
                this.JTJ.fFi();
                ((com.tencent.mm.al.k)localObject3).state = com.tencent.mm.al.k.hTb;
                localObject1 = ((com.tencent.mm.al.k)localObject3).id + ((com.tencent.mm.al.k)localObject3).key;
                synchronized (this.djX)
                {
                  this.JTS.add(localObject1);
                  ae.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.JTS.size()) });
                  b(this.lJm, ((com.tencent.mm.al.k)localObject3).id, ((com.tencent.mm.al.k)localObject3).key, com.tencent.mm.al.k.hTb, ((com.tencent.mm.al.k)localObject3).name, "", ((com.tencent.mm.al.k)localObject3).value);
                  this.JTV = ((com.tencent.mm.al.k)localObject3);
                  switch (((com.tencent.mm.al.k)localObject3).hTe)
                  {
                  case 100: 
                    ??? = new Intent();
                    ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                    ???.putExtra("key_set_result_after_scan", true);
                    ???.putExtra("key_is_hide_right_btn", true);
                    if (com.tencent.mm.r.a.n(getContext(), true)) {
                      continue;
                    }
                    getContext();
                    if ((com.tencent.mm.bh.e.aME()) || (com.tencent.mm.r.a.p(getContext(), true))) {
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
                if (com.tencent.mm.r.a.n(getContext(), true)) {
                  continue;
                }
                getContext();
                if ((com.tencent.mm.bh.e.aME()) || (com.tencent.mm.r.a.p(getContext(), true))) {
                  continue;
                }
                d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
              }
              catch (JSONException ???) {}
              fFe();
              continue;
              bc.aCg();
              if (!com.tencent.mm.model.c.isSDCardAvailable())
              {
                t.kn(getContext());
              }
              else
              {
                ??? = getContext().getString(2131757149);
                String str1 = getContext().getString(2131757148);
                localObject3 = getContext();
                localObject4 = new h.c()
                {
                  public final void lh(int paramAnonymousInt)
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
                fFd();
                continue;
                ??? = new Intent();
                ???.putExtra("map_view_type", 0);
                ???.putExtra("map_sender_name", getSender());
                ???.putExtra("map_talker_name", getTalkerUserName());
                ???.putExtra("view_type_key", 1);
                ???.putExtra("key_get_location_type", 1);
                d.b(getContext(), "location", ".ui.RedirectUI", ???);
                continue;
                ??? = new ep();
                ???.dqN.op = 1;
                ???.dqN.userName = this.dAu.field_username;
                ???.dqN.context = getContext();
                com.tencent.mm.sdk.b.a.IvT.l(???);
                continue;
                ??? = new ep();
                ???.dqN.op = 2;
                ???.dqN.userName = this.dAu.field_username;
                ???.dqN.context = getContext();
                com.tencent.mm.sdk.b.a.IvT.l(???);
                continue;
                ae.i("ChatCustomFooter", "jump to search");
                fFh();
                this.JTJ.fFi();
                ((com.tencent.mm.al.k)localObject3).state = com.tencent.mm.al.k.hTa;
                a((com.tencent.mm.al.k)localObject3, ((com.tencent.mm.al.k)localObject3).value);
                c((com.tencent.mm.al.k)localObject3);
                str1 = ((com.tencent.mm.al.k)localObject3).value;
                ??? = "";
                if (this.dAu != null) {
                  ??? = this.dAu.field_username;
                }
                ae.i("ChatCustomFooter", "bizMenu jumpToSearch username: %s, suggestData: %s", new Object[] { ???, str1 });
                localObject3 = ad.ePM();
                ((Intent)localObject3).putExtra("ftsneedkeyboard", true);
                ((Intent)localObject3).putExtra("ftsbizscene", 75);
                ((Intent)localObject3).putExtra("ftsType", 2);
                localObject4 = ad.f(75, false, 2);
                ((Map)localObject4).put("userName", ???);
                if (!af.isNullOrNil(str1)) {
                  ((Map)localObject4).put("thirdExtParam", str1);
                }
                ((Intent)localObject3).putExtra("rawUrl", ad.be((Map)localObject4));
                ((Intent)localObject3).putExtra("key_load_js_without_delay", true);
                ((Intent)localObject3).putExtra("ftsbizusername", ???);
                ((Intent)localObject3).addFlags(67108864);
                d.b(getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", (Intent)localObject3);
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
      ae.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
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
    ae.i("ChatCustomFooter", "return from camera");
    if (!(paramObject instanceof Intent))
    {
      ae.e("ChatCustomFooter", "type error");
      AppMethodBeat.o(34331);
      return true;
    }
    paramObject = ((Intent)paramObject).getStringExtra("CropImage_OutputPath");
    if (paramObject == null)
    {
      ae.e("ChatCustomFooter", "return null path");
      AppMethodBeat.o(34331);
      return true;
    }
    Object localObject = new com.tencent.mm.vfs.k(paramObject);
    if ((((com.tencent.mm.vfs.k)localObject).exists()) && (((com.tencent.mm.vfs.k)localObject).isFile()))
    {
      ae.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
      paramObject = o.aRh(com.tencent.mm.vfs.w.B(((com.tencent.mm.vfs.k)localObject).mUri));
      ae.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.JTV == null) || ((this.JTV.hTe != 102) && (this.JTV.hTe != 103)))
      {
        ae.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.JTV.state = com.tencent.mm.al.k.hTc;
      this.JTV.q((ArrayList)localObject);
      if (a(this.JTV))
      {
        c(this.JTV);
        b(this.JTV);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34331);
      return true;
      ae.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { paramObject });
    }
    ae.i("ChatCustomFooter", "return from albumn");
    if (!(paramObject instanceof Intent))
    {
      ae.e("ChatCustomFooter", "type error");
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
        ae.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[] { str });
        if (str != null)
        {
          com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(str);
          if ((localk.exists()) && (localk.isFile()))
          {
            ae.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
            str = o.aRh(com.tencent.mm.vfs.w.B(localk.mUri));
            paramObject.add(str);
            ae.i("ChatCustomFooter", "MD5 is %s", new Object[] { str });
          }
        }
        else
        {
          ae.e("ChatCustomFooter", "no file contained!");
          continue;
        }
        ae.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { str });
      }
      if ((this.JTV == null) || ((this.JTV.hTe != 104) && (this.JTV.hTe != 103) && (this.JTV.hTe != 102)))
      {
        ae.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      this.JTV.state = com.tencent.mm.al.k.hTc;
      this.JTV.q(paramObject);
      if (a(this.JTV))
      {
        c(this.JTV);
        b(this.JTV);
      }
    }
    AppMethodBeat.o(34331);
    return true;
    ae.i("ChatCustomFooter", "send current");
    eb(paramObject);
    AppMethodBeat.o(34331);
    return true;
    ae.i("ChatCustomFooter", "send selected");
    eb(paramObject);
    AppMethodBeat.o(34331);
    return true;
    ae.i("ChatCustomFooter", "send qrcode wait msg");
    if (!ec(paramObject))
    {
      AppMethodBeat.o(34331);
      return true;
    }
    this.JTK.fGZ();
    AppMethodBeat.o(34331);
    return true;
    ae.i("ChatCustomFooter", "send qrcode direct");
    ec(paramObject);
    AppMethodBeat.o(34331);
    return true;
  }
  
  public void setOnFooterSwitchListener(ChatFooter.g paramg)
  {
    this.FrM = paramg;
  }
  
  public void setOnProcessClickListener(c.a parama)
  {
    this.JTK = parama;
  }
  
  public void setTalker(an paraman)
  {
    this.dAu = paraman;
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<ph>
  {
    private a()
    {
      AppMethodBeat.i(161517);
      this.__eventId = ph.class.getName().hashCode();
      AppMethodBeat.o(161517);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<pi>
  {
    private b()
    {
      AppMethodBeat.i(161519);
      this.__eventId = pi.class.getName().hashCode();
      AppMethodBeat.o(161519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */