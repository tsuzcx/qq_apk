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
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.al.j;
import com.tencent.mm.al.v;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.ox.a;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oy.a;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.am;
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
  private ChatFooter.g Duj;
  private ImageView HKZ;
  public ImageView HLa;
  public LinearLayout HLb;
  public g HLc;
  private c.a HLd;
  private Boolean HLe;
  private Map<String, an> HLf;
  private List<an> HLg;
  private int HLh;
  private bu HLi;
  private a HLj;
  private b HLk;
  private List<String> HLl;
  private final String HLm;
  private final String HLn;
  private j HLo;
  private MMFragment HoI;
  private Object cXD;
  private ai dnB;
  private String lhM;
  private LinearLayout plH;
  private com.tencent.mm.api.c vIG;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34319);
    this.plH = null;
    this.HKZ = null;
    this.HLa = null;
    this.HLb = null;
    this.HLc = null;
    this.Duj = null;
    this.HLd = null;
    this.HLe = Boolean.FALSE;
    this.HLf = new ConcurrentHashMap();
    this.HLg = new ArrayList();
    this.HLh = 0;
    this.HLl = new LinkedList();
    this.HLm = "qrcode";
    this.HLn = "barcode";
    this.cXD = new Object();
    AppMethodBeat.o(34319);
  }
  
  private void a(j paramj, String paramString)
  {
    AppMethodBeat.i(34328);
    b(this.lhM, paramj.id, paramj.key, j.hxN, paramj.name, "", paramString);
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
    paramj = this.cXD;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.HLl.size())
        {
          if (((String)this.HLl.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.HLl.remove(i);
              ac.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.HLl.size()) });
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          ac.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.HLl.size()) });
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
  
  private static String aQb(String paramString)
  {
    AppMethodBeat.i(34334);
    if (d.d.aFH(paramString))
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
    b(this.lhM, paramj.id, paramj.key, j.hxP, paramj.name, "", paramj.value);
    AppMethodBeat.o(34329);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(34330);
    ac.d("ChatCustomFooter", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    com.tencent.mm.plugin.report.service.h.wUl.f(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(34330);
  }
  
  private void c(j paramj)
  {
    AppMethodBeat.i(34335);
    ac.i("ChatCustomFooter", paramj.getInfo());
    paramj = new v(this.lhM, paramj.getInfo());
    az.agi().a(paramj, 0);
    AppMethodBeat.o(34335);
  }
  
  private boolean dX(Object paramObject)
  {
    AppMethodBeat.i(34332);
    if (!(paramObject instanceof ox))
    {
      ac.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(34332);
      return true;
    }
    Object localObject = (ox)paramObject;
    double d1 = ((ox)localObject).drv.lat;
    double d2 = ((ox)localObject).drv.lng;
    int i = ((ox)localObject).drv.dmN;
    paramObject = ((ox)localObject).drv.label;
    localObject = ((ox)localObject).drv.dry;
    ac.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, localObject });
    if ((this.HLo == null) || (this.HLo.hxR != 105))
    {
      ac.e("ChatCustomFooter", "cache lost or location type is not correct");
      AppMethodBeat.o(34332);
      return true;
    }
    this.HLo.state = j.hxP;
    this.HLo.a(d1, d2, i, paramObject, (String)localObject);
    if (a(this.HLo))
    {
      c(this.HLo);
      b(this.HLo);
    }
    AppMethodBeat.o(34332);
    return true;
  }
  
  private boolean dY(Object paramObject)
  {
    AppMethodBeat.i(34333);
    if ((paramObject == null) || (!(paramObject instanceof oy)))
    {
      AppMethodBeat.o(34333);
      return false;
    }
    String str2 = ((oy)paramObject).drz.drB;
    String str1 = ((oy)paramObject).drz.scanResult;
    paramObject = str1;
    if (!d.d.aFH(str2)) {
      paramObject = str2 + "," + str1;
    }
    if ((this.HLo == null) || ((this.HLo.hxR != 100) && (this.HLo.hxR != 101)))
    {
      ac.e("ChatCustomFooter", "null pointer in cache or type error");
      AppMethodBeat.o(34333);
      return false;
    }
    ac.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { str2, paramObject });
    this.HLo.state = j.hxP;
    this.HLo.ba(aQb(str2), paramObject);
    if (a(this.HLo))
    {
      c(this.HLo);
      b(this.HLo);
    }
    AppMethodBeat.o(34333);
    return true;
  }
  
  private void fkM()
  {
    AppMethodBeat.i(34322);
    if ((this.HoI != null) && (this.dnB != null) && (!ae.isNullOrNil(this.lhM))) {
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.HoI, this.lhM, this.dnB.field_username);
    }
    AppMethodBeat.o(34322);
  }
  
  private void fkN()
  {
    AppMethodBeat.i(34323);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(b.aps());
    if ((!locale.exists()) && (!locale.mkdirs()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(2131757320), 1).show();
      AppMethodBeat.o(34323);
      return;
    }
    if ((this.HoI != null) && (!com.tencent.mm.pluginsdk.ui.tools.q.a(this.HoI, b.aps(), "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(2131763022), 1).show();
    }
    AppMethodBeat.o(34323);
  }
  
  private void fkP()
  {
    AppMethodBeat.i(34338);
    ac.i("ChatCustomFooter", "switch footer");
    if (this.Duj != null)
    {
      this.HLc.fkR();
      this.Duj.vu(true);
    }
    AppMethodBeat.o(34338);
  }
  
  private void fkQ()
  {
    AppMethodBeat.i(34339);
    if (this.dnB == null)
    {
      AppMethodBeat.o(34339);
      return;
    }
    if (this.dnB.eyd == 1)
    {
      az.ayM();
      com.tencent.mm.model.c.awG().aNN(this.dnB.field_username);
    }
    AppMethodBeat.o(34339);
  }
  
  private String getSender()
  {
    AppMethodBeat.i(34324);
    Object localObject = new StringBuilder("getSender ");
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.HLi == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.HLi != null) {
        break label86;
      }
    }
    label86:
    for (localObject = u.axw();; localObject = this.HLi.name)
    {
      ac.i("ChatCustomFooter", (String)localObject);
      if (this.HLi != null) {
        break label97;
      }
      localObject = u.axw();
      AppMethodBeat.o(34324);
      return localObject;
      bool = false;
      break;
    }
    label97:
    localObject = this.HLi.name;
    AppMethodBeat.o(34324);
    return localObject;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(34337);
    parama = z.a(parama.fXi.DPV);
    ac.i("ChatCustomFooter", "SysCmdMsgExtension:".concat(String.valueOf(parama)));
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
        ac.printErrStackTrace("ChatCustomFooter", parama, "", new Object[0]);
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
    c.b.c localc = paramc.bV(false).Jn();
    if ((localc == null) || (localc.cGb == null) || (paramString == null))
    {
      paramMMFragment = new IllegalArgumentException(" menuInfo or username is null ! ");
      AppMethodBeat.o(34320);
      throw paramMMFragment;
    }
    this.HLe = Boolean.valueOf(paramString.equals("gh_f0a92aa7146c"));
    this.HLh = Math.min(localc.cGb.size(), 6);
    ac.i("ChatCustomFooter", "setMenus, count:" + this.HLh);
    if (this.HLh <= 0)
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
    if (this.HLh > 3)
    {
      this.HKZ.setVisibility(0);
      this.plH.setWeightSum(Math.min(this.HLh, 3));
      i = 0;
      if (i >= 6) {
        break label664;
      }
      localObject = (FrameLayout)this.plH.getChildAt(i);
      localTextView = (TextView)((FrameLayout)localObject).findViewById(2131298095);
      localTextView.setTextSize(1, Math.min(1.125F, com.tencent.mm.cc.a.eb(getContext())) * 17.0F);
      localImageView = (ImageView)((FrameLayout)localObject).findViewById(2131298094);
      localImageView.setVisibility(8);
      if (i >= this.HLh) {
        break label605;
      }
      localj = (j)localc.cGb.get(i);
      ((FrameLayout)localObject).setTag(localj);
      localTextView.setText(k.c(getContext(), localj.name));
      if (localj.type == 0)
      {
        int j = (int)localTextView.getTextSize() * 2 / 3;
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = j;
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setImageDrawable(am.k(getContext(), 2131689769, getContext().getResources().getColor(2131099735)));
        localImageView.setVisibility(0);
      }
      ((FrameLayout)localObject).setOnClickListener(this);
      ((FrameLayout)localObject).setVisibility(0);
      if (this.HLe.booleanValue())
      {
        ac.i("ChatCustomFooter", "needShowRedDot：register RedDotComponent");
        ac.i("ChatCustomFooter", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localj.key, localj.name });
        if (!this.HLf.containsKey(localj.key)) {
          break label493;
        }
        ac.d("ChatCustomFooter", "this key has register");
        label463:
        this.HLc.d(localj);
      }
    }
    for (;;)
    {
      i += 1;
      break label171;
      this.HKZ.setVisibility(8);
      break;
      label493:
      localObject = new an(getContext(), localj.key, new an.a()
      {
        public final void G(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(196417);
          ac.d("ChatCustomFooter", "OnShowRedDot show：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          if (localTextView == null)
          {
            ac.d("ChatCustomFooter", "OnShowRedDot mTextView == null");
            AppMethodBeat.o(196417);
            return;
          }
          if (paramAnonymousBoolean)
          {
            new com.tencent.mm.sdk.platformtools.ao().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196416);
                Object localObject = ChatFooterCustom.this.getContext().getResources().getDrawable(2131234447);
                ((Drawable)localObject).setBounds(0, 0, com.tencent.mm.ui.ao.fromDPToPix(ChatFooterCustom.this.getContext(), 8), com.tencent.mm.ui.ao.fromDPToPix(ChatFooterCustom.this.getContext(), 8));
                localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
                SpannableString localSpannableString = new SpannableString("@");
                localSpannableString.setSpan(localObject, 0, 1, 33);
                ac.i("ChatCustomFooter", "setReddotText：%s", new Object[] { ChatFooterCustom.5.this.HLr.key });
                ChatFooterCustom.5.this.HLq.setText(TextUtils.concat(new CharSequence[] { k.c(ChatFooterCustom.this.getContext(), ChatFooterCustom.5.this.HLr.name) + " ", localSpannableString }));
                AppMethodBeat.o(196416);
              }
            }, 500L);
            AppMethodBeat.o(196417);
            return;
          }
          ac.i("ChatCustomFooter", "dont setReddotText:%s", new Object[] { localj.key });
          localTextView.setText(k.c(ChatFooterCustom.this.getContext(), localj.name));
          AppMethodBeat.o(196417);
        }
      });
      com.tencent.mm.plugin.newtips.a.dkb().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      this.HLf.put(localj.key, localObject);
      this.HLg.add(localObject);
      ac.d("ChatCustomFooter", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.HLf.size()), Integer.valueOf(this.HLg.size()) });
      break label463;
      label605:
      if ((i >= 3) && (this.HLh > 3))
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
    this.HoI = paramMMFragment;
    this.lhM = paramString;
    this.vIG = paramc;
    if (this.HLj != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.HLj);
    }
    if (this.HLk != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.HLk);
    }
    this.HLj = new a((byte)0);
    this.HLk = new b((byte)0);
    com.tencent.mm.sdk.b.a.GpY.c(this.HLj);
    com.tencent.mm.sdk.b.a.GpY.c(this.HLk);
    AppMethodBeat.o(34320);
  }
  
  public final void fkL()
  {
    AppMethodBeat.i(34321);
    if (this.HLj != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.HLj);
    }
    if (this.HLk != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.HLk);
    }
    ac.i("ChatCustomFooter", " releaseRedDotResource()");
    Object localObject1;
    Object localObject2;
    if (this.HLc != null)
    {
      localObject1 = this.HLc;
      ac.i("MicroMsg.ChatFooterCustomSubmenu", "releaseRedDotResource()");
      ((g)localObject1).HLu = "";
      ((g)localObject1).dvX = false;
      if ((((g)localObject1).HLf != null) && (((g)localObject1).HLf.size() > 0)) {
        ((g)localObject1).HLf.clear();
      }
      if ((((g)localObject1).HLg != null) && (((g)localObject1).HLg.size() > 0))
      {
        localObject2 = ((g)localObject1).HLg.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          an localan = (an)((Iterator)localObject2).next();
          com.tencent.mm.plugin.newtips.a.dkb();
          com.tencent.mm.plugin.newtips.a.i.i(localan);
        }
        ((g)localObject1).HLg.clear();
      }
    }
    if ((this.HLf != null) && (this.HLf.size() > 0)) {
      this.HLf.clear();
    }
    if ((this.HLg != null) && (this.HLg.size() > 0))
    {
      localObject1 = this.HLg.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (an)((Iterator)localObject1).next();
        com.tencent.mm.plugin.newtips.a.dkb();
        com.tencent.mm.plugin.newtips.a.i.i((com.tencent.mm.plugin.newtips.a.a)localObject2);
      }
      this.HLg.clear();
    }
    AppMethodBeat.o(34321);
  }
  
  public final void fkO()
  {
    AppMethodBeat.i(34325);
    if (this.HLc != null) {
      this.HLc.fkR();
    }
    AppMethodBeat.o(34325);
  }
  
  public ai getTalker()
  {
    return this.dnB;
  }
  
  public String getTalkerUserName()
  {
    if (this.dnB == null) {
      return null;
    }
    return this.dnB.field_username;
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
        com.tencent.mm.pluginsdk.wallet.h.XB(8);
        localObject3 = (j)localObject3;
        if (this.HLe.booleanValue())
        {
          com.tencent.mm.plugin.newtips.a.dkb().c(new com.tencent.mm.plugin.newtips.b.e(((j)localObject3).key));
          com.tencent.mm.plugin.report.service.h.wUl.f(19541, new Object[] { Integer.valueOf(2), ((j)localObject3).key });
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
      ac.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(???.getWidth()) });
      Object localObject4 = this.HLc;
      int i = localObject1[0] + ???.getWidth() / 2;
      int j = localObject1[1];
      if (!((g)localObject4).isShowing())
      {
        ((g)localObject4).a((j)localObject3, i, j);
        AppMethodBeat.o(34326);
      }
      else
      {
        ((g)localObject4).fkR();
        if ((localObject3 != null) && ((((g)localObject4).HLA.id != ((j)localObject3).id) || (!((g)localObject4).HLA.key.equals(((j)localObject3).key)))) {
          ((g)localObject4).a((j)localObject3, i, j);
        }
        AppMethodBeat.o(34326);
        continue;
        ac.i("ChatCustomFooter", "start webview url");
        fkQ();
        this.HLc.fkR();
        ((j)localObject3).state = j.hxN;
        a((j)localObject3, ((j)localObject3).dBy);
        c((j)localObject3);
        if ((!p.a.DfG.b(getContext(), ((j)localObject3).value, new Object[0])) && (!e.a(((j)localObject3).dBy, getContext(), this.HoI, this.lhM)))
        {
          ??? = new Intent();
          ???.putExtra("KPublisherId", "custom_menu");
          ???.putExtra("pre_username", this.lhM);
          ???.putExtra("prePublishId", "custom_menu");
          ???.putExtra("preUsername", this.lhM);
          ???.putExtra("preChatName", this.lhM);
          ???.putExtra("preChatTYPE", x.aE(this.lhM, this.lhM));
          ???.putExtra("rawUrl", ((j)localObject3).value);
          ???.putExtra("geta8key_username", this.lhM);
          ???.putExtra("from_scence", 1);
          d.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
          AppMethodBeat.o(34326);
          continue;
          ac.i("ChatCustomFooter", "switch to input");
          this.HLc.fkR();
          fkP();
          ((j)localObject3).state = j.hxN;
          a((j)localObject3, ((j)localObject3).value);
          c((j)localObject3);
          AppMethodBeat.o(34326);
          continue;
          ac.i("ChatCustomFooter", "get latest message");
          fkQ();
          this.HLc.fkR();
          ((j)localObject3).state = j.hxN;
          a((j)localObject3, ((j)localObject3).value);
          c((j)localObject3);
          this.HLd.fmE();
          AppMethodBeat.o(34326);
          continue;
          fkQ();
          this.HLc.fkR();
          ((j)localObject3).state = j.hxN;
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
              ((AppBrandStatObject)localObject3).cYP = this.lhM;
              localObject4 = (n)com.tencent.mm.kernel.g.ab(n.class);
              Context localContext = getContext();
              String str2 = ???.optString("userName");
              String str3 = ???.optString("pagePath");
              if (this.vIG == null) {}
              for (??? = (View)localObject1;; ??? = this.vIG.field_appId)
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
            ac.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
            fkQ();
            this.HLc.fkR();
            ((j)localObject3).state = j.hxO;
            localObject1 = ((j)localObject3).id + ((j)localObject3).key;
            synchronized (this.cXD)
            {
              this.HLl.add(localObject1);
              ac.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.HLl.size()) });
              b(this.lhM, ((j)localObject3).id, ((j)localObject3).key, j.hxO, ((j)localObject3).name, "", ((j)localObject3).value);
              this.HLo = ((j)localObject3);
              switch (((j)localObject3).hxR)
              {
              case 100: 
                ??? = new Intent();
                ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                ???.putExtra("key_set_result_after_scan", true);
                ???.putExtra("key_is_hide_right_btn", true);
                if (com.tencent.mm.r.a.cg(getContext())) {
                  continue;
                }
                getContext();
                if ((com.tencent.mm.bh.e.aIX()) || (com.tencent.mm.r.a.cj(getContext()))) {
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
            if (!com.tencent.mm.r.a.cg(getContext()))
            {
              getContext();
              if ((!com.tencent.mm.bh.e.aIX()) && (!com.tencent.mm.r.a.cj(getContext())))
              {
                d.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                AppMethodBeat.o(34326);
                continue;
                fkN();
                AppMethodBeat.o(34326);
                continue;
                az.ayM();
                if (!com.tencent.mm.model.c.isSDCardAvailable())
                {
                  t.jV(getContext());
                  AppMethodBeat.o(34326);
                }
                else
                {
                  ??? = getContext().getString(2131757149);
                  String str1 = getContext().getString(2131757148);
                  localObject3 = getContext();
                  localObject4 = new h.c()
                  {
                    public final void kG(int paramAnonymousInt)
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
                  fkM();
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
                  ??? = new el();
                  ???.dem.op = 1;
                  ???.dem.userName = this.dnB.field_username;
                  ???.dem.context = getContext();
                  com.tencent.mm.sdk.b.a.GpY.l(???);
                  AppMethodBeat.o(34326);
                  continue;
                  ??? = new el();
                  ???.dem.op = 2;
                  ???.dem.userName = this.dnB.field_username;
                  ???.dem.context = getContext();
                  com.tencent.mm.sdk.b.a.GpY.l(???);
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
      ac.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
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
    ac.i("ChatCustomFooter", "return from camera");
    if (!(paramObject instanceof Intent))
    {
      ac.e("ChatCustomFooter", "type error");
      AppMethodBeat.o(34331);
      return true;
    }
    paramObject = ((Intent)paramObject).getStringExtra("CropImage_OutputPath");
    if (paramObject == null)
    {
      ac.e("ChatCustomFooter", "return null path");
      AppMethodBeat.o(34331);
      return true;
    }
    Object localObject = new com.tencent.mm.vfs.e(paramObject);
    if ((((com.tencent.mm.vfs.e)localObject).exists()) && (((com.tencent.mm.vfs.e)localObject).isFile()))
    {
      ac.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
      paramObject = com.tencent.mm.vfs.i.aKe(com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject).mUri));
      ac.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.HLo == null) || ((this.HLo.hxR != 102) && (this.HLo.hxR != 103)))
      {
        ac.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.HLo.state = j.hxP;
      this.HLo.q((ArrayList)localObject);
      if (a(this.HLo))
      {
        c(this.HLo);
        b(this.HLo);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34331);
      return true;
      ac.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { paramObject });
    }
    ac.i("ChatCustomFooter", "return from albumn");
    if (!(paramObject instanceof Intent))
    {
      ac.e("ChatCustomFooter", "type error");
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
        ac.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[] { str });
        if (str != null)
        {
          com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str);
          if ((locale.exists()) && (locale.isFile()))
          {
            ac.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
            str = com.tencent.mm.vfs.i.aKe(com.tencent.mm.vfs.q.B(locale.mUri));
            paramObject.add(str);
            ac.i("ChatCustomFooter", "MD5 is %s", new Object[] { str });
          }
        }
        else
        {
          ac.e("ChatCustomFooter", "no file contained!");
          continue;
        }
        ac.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[] { str });
      }
      if ((this.HLo == null) || ((this.HLo.hxR != 104) && (this.HLo.hxR != 103) && (this.HLo.hxR != 102)))
      {
        ac.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      this.HLo.state = j.hxP;
      this.HLo.q(paramObject);
      if (a(this.HLo))
      {
        c(this.HLo);
        b(this.HLo);
      }
    }
    AppMethodBeat.o(34331);
    return true;
    ac.i("ChatCustomFooter", "send current");
    dX(paramObject);
    AppMethodBeat.o(34331);
    return true;
    ac.i("ChatCustomFooter", "send selected");
    dX(paramObject);
    AppMethodBeat.o(34331);
    return true;
    ac.i("ChatCustomFooter", "send qrcode wait msg");
    if (!dY(paramObject))
    {
      AppMethodBeat.o(34331);
      return true;
    }
    this.HLd.fmE();
    AppMethodBeat.o(34331);
    return true;
    ac.i("ChatCustomFooter", "send qrcode direct");
    dY(paramObject);
    AppMethodBeat.o(34331);
    return true;
  }
  
  public void setOnFooterSwitchListener(ChatFooter.g paramg)
  {
    this.Duj = paramg;
  }
  
  public void setOnProcessClickListener(c.a parama)
  {
    this.HLd = parama;
  }
  
  public void setTalker(ai paramai)
  {
    this.dnB = paramai;
  }
  
  public final void y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34336);
    this.plH = ((LinearLayout)findViewById(2131298093));
    this.HLb = ((LinearLayout)findViewById(2131298098));
    this.HLb.setVisibility(0);
    this.HLa = ((ImageView)findViewById(2131298097));
    this.HLa.setVisibility(0);
    this.HLa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34314);
        ChatFooterCustom.c(ChatFooterCustom.this);
        AppMethodBeat.o(34314);
      }
    });
    this.HKZ = ((ImageView)findViewById(2131298092));
    this.HKZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34315);
        ChatFooterCustom.d(ChatFooterCustom.this).fkR();
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
    this.HLc = new g(getContext(), paramViewGroup);
    this.HLc.HLt = new AdapterView.OnItemClickListener()
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
    extends com.tencent.mm.sdk.b.c<ox>
  {
    private a()
    {
      AppMethodBeat.i(161517);
      this.__eventId = ox.class.getName().hashCode();
      AppMethodBeat.o(161517);
    }
  }
  
  final class b
    extends com.tencent.mm.sdk.b.c<oy>
  {
    private b()
    {
      AppMethodBeat.i(161519);
      this.__eventId = oy.class.getName().hashCode();
      AppMethodBeat.o(161519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */