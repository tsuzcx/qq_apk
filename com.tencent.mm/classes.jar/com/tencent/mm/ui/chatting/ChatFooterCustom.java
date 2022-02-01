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
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.am.j;
import com.tencent.mm.am.v;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.oo.a;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.op.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.c.a;
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
  implements View.OnClickListener, cc.a
{
  private ChatFooter.g CbR;
  private MMFragment FOX;
  private ImageView Glk;
  public ImageView Gll;
  public LinearLayout Glm;
  public g Gln;
  private c.a Glo;
  private Boolean Glp;
  private Map<String, an> Glq;
  private List<an> Glr;
  private int Gls;
  private br Glt;
  private a Glu;
  private b Glv;
  private List<String> Glw;
  private final String Glx;
  private final String Gly;
  private j Glz;
  private Object dah;
  private af dpQ;
  private String kGt;
  private LinearLayout oIh;
  private com.tencent.mm.api.c uzN;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34319);
    this.oIh = null;
    this.Glk = null;
    this.Gll = null;
    this.Glm = null;
    this.Gln = null;
    this.CbR = null;
    this.Glo = null;
    this.Glp = Boolean.FALSE;
    this.Glq = new ConcurrentHashMap();
    this.Glr = new ArrayList();
    this.Gls = 0;
    this.Glw = new LinkedList();
    this.Glx = "qrcode";
    this.Gly = "barcode";
    this.dah = new Object();
    AppMethodBeat.o(34319);
  }
  
  private void a(j paramj, String paramString)
  {
    AppMethodBeat.i(34328);
    b(this.kGt, paramj.id, paramj.key, j.gXo, paramj.name, "", paramString);
    AppMethodBeat.o(34328);
  }
  
  private boolean a(j paramj)
  {
    AppMethodBeat.i(34327);
    if (paramj == null)
    {
      AppMethodBeat.o(34327);
      return false;
    }
    String str = paramj.id + paramj.key;
    paramj = this.dah;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.Glw.size())
        {
          if (((String)this.Glw.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.Glw.remove(i);
              ad.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.Glw.size()) });
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          ad.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.Glw.size()) });
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
  
  private static String aKy(String paramString)
  {
    AppMethodBeat.i(34334);
    if (d.d.aAp(paramString))
    {
      AppMethodBeat.o(34334);
      return "qrcode";
    }
    AppMethodBeat.o(34334);
    return "barcode";
  }
  
  private void b(j paramj)
  {
    AppMethodBeat.i(34329);
    b(this.kGt, paramj.id, paramj.key, j.gXq, paramj.name, "", paramj.value);
    AppMethodBeat.o(34329);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(34330);
    ad.d("ChatCustomFooter", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    com.tencent.mm.plugin.report.service.h.vKh.f(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(34330);
  }
  
  private void c(j paramj)
  {
    AppMethodBeat.i(34335);
    ad.i("ChatCustomFooter", paramj.getInfo());
    paramj = new v(this.kGt, paramj.getInfo());
    az.aeS().a(paramj, 0);
    AppMethodBeat.o(34335);
  }
  
  private boolean dW(Object paramObject)
  {
    AppMethodBeat.i(34332);
    if (!(paramObject instanceof oo))
    {
      ad.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(34332);
      return true;
    }
    Object localObject = (oo)paramObject;
    double d1 = ((oo)localObject).dtK.lat;
    double d2 = ((oo)localObject).dtK.lng;
    int i = ((oo)localObject).dtK.dpd;
    paramObject = ((oo)localObject).dtK.label;
    localObject = ((oo)localObject).dtK.dtN;
    ad.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, localObject });
    if ((this.Glz == null) || (this.Glz.gXs != 105))
    {
      ad.e("ChatCustomFooter", "cache lost or location type is not correct");
      AppMethodBeat.o(34332);
      return true;
    }
    this.Glz.state = j.gXq;
    this.Glz.a(d1, d2, i, paramObject, (String)localObject);
    if (a(this.Glz))
    {
      c(this.Glz);
      b(this.Glz);
    }
    AppMethodBeat.o(34332);
    return true;
  }
  
  private boolean dX(Object paramObject)
  {
    AppMethodBeat.i(34333);
    if ((paramObject == null) || (!(paramObject instanceof op)))
    {
      AppMethodBeat.o(34333);
      return false;
    }
    String str2 = ((op)paramObject).dtO.dtQ;
    String str1 = ((op)paramObject).dtO.scanResult;
    paramObject = str1;
    if (!d.d.aAp(str2)) {
      paramObject = str2 + "," + str1;
    }
    if ((this.Glz == null) || ((this.Glz.gXs != 100) && (this.Glz.gXs != 101)))
    {
      ad.e("ChatCustomFooter", "null pointer in cache or type error");
      AppMethodBeat.o(34333);
      return false;
    }
    ad.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { str2, paramObject });
    this.Glz.state = j.gXq;
    this.Glz.aS(aKy(str2), paramObject);
    if (a(this.Glz))
    {
      c(this.Glz);
      b(this.Glz);
    }
    AppMethodBeat.o(34333);
    return true;
  }
  
  private void eVa()
  {
    AppMethodBeat.i(34322);
    if ((this.FOX != null) && (this.dpQ != null) && (!ae.isNullOrNil(this.kGt))) {
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.FOX, this.kGt, this.dpQ.field_username);
    }
    AppMethodBeat.o(34322);
  }
  
  private void eVb()
  {
    AppMethodBeat.i(34323);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(b.ais());
    if ((!locale.exists()) && (!locale.mkdirs()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(2131757320), 1).show();
      AppMethodBeat.o(34323);
      return;
    }
    if ((this.FOX != null) && (!com.tencent.mm.pluginsdk.ui.tools.q.a(this.FOX, b.ais(), "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(2131763022), 1).show();
    }
    AppMethodBeat.o(34323);
  }
  
  private void eVd()
  {
    AppMethodBeat.i(34338);
    ad.i("ChatCustomFooter", "switch footer");
    if (this.CbR != null)
    {
      this.Gln.eVf();
      this.CbR.us(true);
    }
    AppMethodBeat.o(34338);
  }
  
  private void eVe()
  {
    AppMethodBeat.i(34339);
    if (this.dpQ == null)
    {
      AppMethodBeat.o(34339);
      return;
    }
    if (this.dpQ.evH == 1)
    {
      az.arV();
      com.tencent.mm.model.c.apR().aIs(this.dpQ.field_username);
    }
    AppMethodBeat.o(34339);
  }
  
  private String getSender()
  {
    AppMethodBeat.i(34324);
    Object localObject = new StringBuilder("getSender ");
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.Glt == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.Glt != null) {
        break label86;
      }
    }
    label86:
    for (localObject = u.aqG();; localObject = this.Glt.name)
    {
      ad.i("ChatCustomFooter", (String)localObject);
      if (this.Glt != null) {
        break label97;
      }
      localObject = u.aqG();
      AppMethodBeat.o(34324);
      return localObject;
      bool = false;
      break;
    }
    label97:
    localObject = this.Glt.name;
    AppMethodBeat.o(34324);
    return localObject;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(34337);
    parama = z.a(parama.fTo.Cxz);
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
  
  public final void a(f.c paramc) {}
  
  public final void a(MMFragment paramMMFragment, com.tencent.mm.api.c paramc, String paramString)
  {
    AppMethodBeat.i(34320);
    c.b.c localc = paramc.bU(false).JE();
    if ((localc == null) || (localc.cIU == null) || (paramString == null))
    {
      paramMMFragment = new IllegalArgumentException(" menuInfo or username is null ! ");
      AppMethodBeat.o(34320);
      throw paramMMFragment;
    }
    this.Glp = Boolean.valueOf(paramString.equals("gh_f0a92aa7146c"));
    this.Gls = Math.min(localc.cIU.size(), 6);
    ad.i("ChatCustomFooter", "setMenus, count:" + this.Gls);
    if (this.Gls <= 0)
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
    final j localj;
    if (this.Gls > 3)
    {
      this.Glk.setVisibility(0);
      this.oIh.setWeightSum(Math.min(this.Gls, 3));
      i = 0;
      if (i >= 6) {
        break label664;
      }
      localObject = (FrameLayout)this.oIh.getChildAt(i);
      localTextView = (TextView)((FrameLayout)localObject).findViewById(2131298095);
      localTextView.setTextSize(1, Math.min(1.125F, com.tencent.mm.cd.a.dT(getContext())) * 17.0F);
      localImageView = (ImageView)((FrameLayout)localObject).findViewById(2131298094);
      localImageView.setVisibility(8);
      if (i >= this.Gls) {
        break label605;
      }
      localj = (j)localc.cIU.get(i);
      ((FrameLayout)localObject).setTag(localj);
      localTextView.setText(k.c(getContext(), localj.name));
      if (localj.type == 0)
      {
        int j = (int)localTextView.getTextSize() * 2 / 3;
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = j;
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setImageDrawable(am.i(getContext(), 2131689769, getContext().getResources().getColor(2131099735)));
        localImageView.setVisibility(0);
      }
      ((FrameLayout)localObject).setOnClickListener(this);
      ((FrameLayout)localObject).setVisibility(0);
      if (this.Glp.booleanValue())
      {
        ad.i("ChatCustomFooter", "needShowRedDot：register RedDotComponent");
        ad.i("ChatCustomFooter", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localj.key, localj.name });
        if (!this.Glq.containsKey(localj.key)) {
          break label493;
        }
        ad.d("ChatCustomFooter", "this key has register");
        label463:
        this.Gln.d(localj);
      }
    }
    for (;;)
    {
      i += 1;
      break label171;
      this.Glk.setVisibility(8);
      break;
      label493:
      localObject = new an(getContext(), localj.key, new an.a()
      {
        public final void F(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(191475);
          ad.d("ChatCustomFooter", "OnShowRedDot show：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          if (localTextView == null)
          {
            ad.d("ChatCustomFooter", "OnShowRedDot mTextView == null");
            AppMethodBeat.o(191475);
            return;
          }
          if (paramAnonymousBoolean)
          {
            new ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(191474);
                Object localObject = ChatFooterCustom.this.getContext().getResources().getDrawable(2131234447);
                ((Drawable)localObject).setBounds(0, 0, ao.fromDPToPix(ChatFooterCustom.this.getContext(), 8), ao.fromDPToPix(ChatFooterCustom.this.getContext(), 8));
                localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
                SpannableString localSpannableString = new SpannableString("@");
                localSpannableString.setSpan(localObject, 0, 1, 33);
                ad.i("ChatCustomFooter", "setReddotText：%s", new Object[] { ChatFooterCustom.5.this.GlC.key });
                ChatFooterCustom.5.this.GlB.setText(TextUtils.concat(new CharSequence[] { k.c(ChatFooterCustom.this.getContext(), ChatFooterCustom.5.this.GlC.name) + " ", localSpannableString }));
                AppMethodBeat.o(191474);
              }
            }, 500L);
            AppMethodBeat.o(191475);
            return;
          }
          ad.i("ChatCustomFooter", "dont setReddotText:%s", new Object[] { localj.key });
          localTextView.setText(k.c(ChatFooterCustom.this.getContext(), localj.name));
          AppMethodBeat.o(191475);
        }
      });
      com.tencent.mm.plugin.newtips.a.cWs().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      this.Glq.put(localj.key, localObject);
      this.Glr.add(localObject);
      ad.d("ChatCustomFooter", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.Glq.size()), Integer.valueOf(this.Glr.size()) });
      break label463;
      label605:
      if ((i >= 3) && (this.Gls > 3))
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
    this.FOX = paramMMFragment;
    this.kGt = paramString;
    this.uzN = paramc;
    if (this.Glu != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.Glu);
    }
    if (this.Glv != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.Glv);
    }
    this.Glu = new a((byte)0);
    this.Glv = new b((byte)0);
    com.tencent.mm.sdk.b.a.ESL.c(this.Glu);
    com.tencent.mm.sdk.b.a.ESL.c(this.Glv);
    AppMethodBeat.o(34320);
  }
  
  public final void eUZ()
  {
    AppMethodBeat.i(34321);
    if (this.Glu != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.Glu);
    }
    if (this.Glv != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.Glv);
    }
    ad.i("ChatCustomFooter", " releaseRedDotResource()");
    Object localObject1;
    Object localObject2;
    if (this.Gln != null)
    {
      localObject1 = this.Gln;
      ad.i("MicroMsg.ChatFooterCustomSubmenu", "releaseRedDotResource()");
      ((g)localObject1).GlF = "";
      ((g)localObject1).dyl = false;
      if ((((g)localObject1).Glq != null) && (((g)localObject1).Glq.size() > 0)) {
        ((g)localObject1).Glq.clear();
      }
      if ((((g)localObject1).Glr != null) && (((g)localObject1).Glr.size() > 0))
      {
        localObject2 = ((g)localObject1).Glr.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          an localan = (an)((Iterator)localObject2).next();
          com.tencent.mm.plugin.newtips.a.cWs();
          com.tencent.mm.plugin.newtips.a.i.i(localan);
        }
        ((g)localObject1).Glr.clear();
      }
    }
    if ((this.Glq != null) && (this.Glq.size() > 0)) {
      this.Glq.clear();
    }
    if ((this.Glr != null) && (this.Glr.size() > 0))
    {
      localObject1 = this.Glr.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (an)((Iterator)localObject1).next();
        com.tencent.mm.plugin.newtips.a.cWs();
        com.tencent.mm.plugin.newtips.a.i.i((com.tencent.mm.plugin.newtips.a.a)localObject2);
      }
      this.Glr.clear();
    }
    AppMethodBeat.o(34321);
  }
  
  public final void eVc()
  {
    AppMethodBeat.i(34325);
    if (this.Gln != null) {
      this.Gln.eVf();
    }
    AppMethodBeat.o(34325);
  }
  
  public af getTalker()
  {
    return this.dpQ;
  }
  
  public String getTalkerUserName()
  {
    if (this.dpQ == null) {
      return null;
    }
    return this.dpQ.field_username;
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
        localObject3 = ???.getTag();
        if (!(localObject3 instanceof j))
        {
          AppMethodBeat.o(34326);
          return;
        }
        com.tencent.mm.pluginsdk.wallet.h.Vs(8);
        localObject3 = (j)localObject3;
        if (this.Glp.booleanValue())
        {
          com.tencent.mm.plugin.newtips.a.cWs().c(new com.tencent.mm.plugin.newtips.b.e(((j)localObject3).key));
          com.tencent.mm.plugin.report.service.h.vKh.f(19541, new Object[] { Integer.valueOf(2), ((j)localObject3).key });
        }
        ((j)localObject3).content = "";
        switch (((j)localObject3).type)
        {
        case 0: 
          AppMethodBeat.o(34326);
          continue;
          localObject1 = new int[2];
        }
      }
      finally {}
      ???.getLocationOnScreen((int[])localObject1);
      ad.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(???.getWidth()) });
      Object localObject4 = this.Gln;
      int i = localObject1[0] + ???.getWidth() / 2;
      int j = localObject1[1];
      if (!((g)localObject4).isShowing())
      {
        ((g)localObject4).a((j)localObject3, i, j);
        AppMethodBeat.o(34326);
      }
      else
      {
        ((g)localObject4).eVf();
        if ((localObject3 != null) && ((((g)localObject4).GlL.id != ((j)localObject3).id) || (!((g)localObject4).GlL.key.equals(((j)localObject3).key)))) {
          ((g)localObject4).a((j)localObject3, i, j);
        }
        AppMethodBeat.o(34326);
        continue;
        ad.i("ChatCustomFooter", "start webview url");
        eVe();
        this.Gln.eVf();
        ((j)localObject3).state = j.gXo;
        a((j)localObject3, ((j)localObject3).dDM);
        c((j)localObject3);
        if ((!p.a.BNw.b(getContext(), ((j)localObject3).value, new Object[0])) && (!e.a(((j)localObject3).dDM, getContext(), this.FOX, this.kGt)))
        {
          ??? = new Intent();
          ???.putExtra("KPublisherId", "custom_menu");
          ???.putExtra("pre_username", this.kGt);
          ???.putExtra("prePublishId", "custom_menu");
          ???.putExtra("preUsername", this.kGt);
          ???.putExtra("preChatName", this.kGt);
          ???.putExtra("preChatTYPE", x.aw(this.kGt, this.kGt));
          ???.putExtra("rawUrl", ((j)localObject3).value);
          ???.putExtra("geta8key_username", this.kGt);
          ???.putExtra("from_scence", 1);
          d.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
          AppMethodBeat.o(34326);
          continue;
          ad.i("ChatCustomFooter", "switch to input");
          this.Gln.eVf();
          eVd();
          ((j)localObject3).state = j.gXo;
          a((j)localObject3, ((j)localObject3).value);
          c((j)localObject3);
          AppMethodBeat.o(34326);
          continue;
          ad.i("ChatCustomFooter", "get latest message");
          eVe();
          this.Gln.eVf();
          ((j)localObject3).state = j.gXo;
          a((j)localObject3, ((j)localObject3).value);
          c((j)localObject3);
          this.Glo.eWS();
          AppMethodBeat.o(34326);
          continue;
          eVe();
          this.Gln.eVf();
          ((j)localObject3).state = j.gXo;
          a((j)localObject3, ((j)localObject3).value);
          c((j)localObject3);
          boolean bool = TextUtils.isEmpty(((j)localObject3).value);
          if (!bool)
          {
            try
            {
              ??? = new JSONObject(((j)localObject3).value);
              localObject3 = new AppBrandStatObject();
              ((AppBrandStatObject)localObject3).scene = 1035;
              ((AppBrandStatObject)localObject3).dbt = this.kGt;
              localObject4 = (n)com.tencent.mm.kernel.g.ab(n.class);
              Context localContext = getContext();
              String str2 = ???.optString("userName");
              String str3 = ???.optString("pagePath");
              if (this.uzN == null) {}
              for (??? = (View)localObject1;; ??? = this.uzN.field_appId)
              {
                ((n)localObject4).a(localContext, str2, null, 0, 0, str3, (AppBrandStatObject)localObject3, ???);
                AppMethodBeat.o(34326);
                break;
              }
            }
            catch (JSONException ???)
            {
              AppMethodBeat.o(34326);
            }
            ad.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
            eVe();
            this.Gln.eVf();
            ((j)localObject3).state = j.gXp;
            localObject1 = ((j)localObject3).id + ((j)localObject3).key;
            synchronized (this.dah)
            {
              this.Glw.add(localObject1);
              ad.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.Glw.size()) });
              b(this.kGt, ((j)localObject3).id, ((j)localObject3).key, j.gXp, ((j)localObject3).name, "", ((j)localObject3).value);
              this.Glz = ((j)localObject3);
              switch (((j)localObject3).gXs)
              {
              case 100: 
                ??? = new Intent();
                ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                ???.putExtra("key_set_result_after_scan", true);
                ???.putExtra("key_is_hide_right_btn", true);
                if (com.tencent.mm.r.a.cd(getContext())) {
                  continue;
                }
                getContext();
                if (com.tencent.mm.bi.e.aCh()) {
                  continue;
                }
                d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                AppMethodBeat.o(34326);
              }
            }
            ??? = new Intent();
            ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            ???.putExtra("key_set_result_after_scan", false);
            ???.putExtra("key_is_hide_right_btn", true);
            if (!com.tencent.mm.r.a.cd(getContext()))
            {
              getContext();
              if (!com.tencent.mm.bi.e.aCh())
              {
                d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                AppMethodBeat.o(34326);
                continue;
                eVb();
                AppMethodBeat.o(34326);
                continue;
                az.arV();
                if (!com.tencent.mm.model.c.isSDCardAvailable())
                {
                  t.jK(getContext());
                  AppMethodBeat.o(34326);
                }
                else
                {
                  ??? = getContext().getString(2131757149);
                  String str1 = getContext().getString(2131757148);
                  localObject3 = getContext();
                  localObject4 = new h.c()
                  {
                    public final void kM(int paramAnonymousInt)
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
                  AppMethodBeat.o(34326);
                  continue;
                  eVa();
                  AppMethodBeat.o(34326);
                  continue;
                  ??? = new Intent();
                  ???.putExtra("map_view_type", 0);
                  ???.putExtra("map_sender_name", getSender());
                  ???.putExtra("map_talker_name", getTalkerUserName());
                  ???.putExtra("view_type_key", 1);
                  ???.putExtra("key_get_location_type", 1);
                  d.b(getContext(), "location", ".ui.RedirectUI", ???);
                  AppMethodBeat.o(34326);
                  continue;
                  ??? = new ek();
                  ???.dgR.op = 1;
                  ???.dgR.userName = this.dpQ.field_username;
                  ???.dgR.context = getContext();
                  com.tencent.mm.sdk.b.a.ESL.l(???);
                  AppMethodBeat.o(34326);
                  continue;
                  ??? = new ek();
                  ???.dgR.op = 2;
                  ???.dgR.userName = this.dpQ.field_username;
                  ???.dgR.context = getContext();
                  com.tencent.mm.sdk.b.a.ESL.l(???);
                  continue;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean q(int paramInt, Object paramObject)
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
      paramObject = com.tencent.mm.vfs.i.aEN(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject).mUri));
      ad.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.Glz == null) || ((this.Glz.gXs != 102) && (this.Glz.gXs != 103)))
      {
        ad.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.Glz.state = j.gXq;
      this.Glz.l((ArrayList)localObject);
      if (a(this.Glz))
      {
        c(this.Glz);
        b(this.Glz);
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
            str = com.tencent.mm.vfs.i.aEN(com.tencent.mm.vfs.q.B(locale.mUri));
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
      if ((this.Glz == null) || ((this.Glz.gXs != 104) && (this.Glz.gXs != 103) && (this.Glz.gXs != 102)))
      {
        ad.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      this.Glz.state = j.gXq;
      this.Glz.l(paramObject);
      if (a(this.Glz))
      {
        c(this.Glz);
        b(this.Glz);
      }
    }
    AppMethodBeat.o(34331);
    return true;
    ad.i("ChatCustomFooter", "send current");
    dW(paramObject);
    AppMethodBeat.o(34331);
    return true;
    ad.i("ChatCustomFooter", "send selected");
    dW(paramObject);
    AppMethodBeat.o(34331);
    return true;
    ad.i("ChatCustomFooter", "send qrcode wait msg");
    if (!dX(paramObject))
    {
      AppMethodBeat.o(34331);
      return true;
    }
    this.Glo.eWS();
    AppMethodBeat.o(34331);
    return true;
    ad.i("ChatCustomFooter", "send qrcode direct");
    dX(paramObject);
    AppMethodBeat.o(34331);
    return true;
  }
  
  public void setOnFooterSwitchListener(ChatFooter.g paramg)
  {
    this.CbR = paramg;
  }
  
  public void setOnProcessClickListener(c.a parama)
  {
    this.Glo = parama;
  }
  
  public void setTalker(af paramaf)
  {
    this.dpQ = paramaf;
  }
  
  public final void x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34336);
    this.oIh = ((LinearLayout)findViewById(2131298093));
    this.Glm = ((LinearLayout)findViewById(2131298098));
    this.Glm.setVisibility(0);
    this.Gll = ((ImageView)findViewById(2131298097));
    this.Gll.setVisibility(0);
    this.Gll.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34314);
        ChatFooterCustom.c(ChatFooterCustom.this);
        AppMethodBeat.o(34314);
      }
    });
    this.Glk = ((ImageView)findViewById(2131298092));
    this.Glk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34315);
        ChatFooterCustom.d(ChatFooterCustom.this).eVf();
        paramAnonymousView = (ImageView)paramAnonymousView;
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
          AppMethodBeat.o(34315);
          return;
        }
        paramAnonymousView.setTag(null);
        paramAnonymousView.setImageResource(2131233307);
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
        AppMethodBeat.o(34315);
      }
    });
    this.Gln = new g(getContext(), paramViewGroup);
    this.Gln.GlE = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34316);
        ChatFooterCustom.this.onClick(paramAnonymousView);
        AppMethodBeat.o(34316);
      }
    };
    AppMethodBeat.o(34336);
  }
  
  final class a
    extends com.tencent.mm.sdk.b.c<oo>
  {
    private a()
    {
      AppMethodBeat.i(161517);
      this.__eventId = oo.class.getName().hashCode();
      AppMethodBeat.o(161517);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<op>
  {
    private b()
    {
      AppMethodBeat.i(161519);
      this.__eventId = op.class.getName().hashCode();
      AppMethodBeat.o(161519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */