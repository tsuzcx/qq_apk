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
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.k;
import com.tencent.mm.al.w;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.pz.a;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.qa.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d.c.a;
import com.tencent.mm.vfs.aa;
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
  implements View.OnClickListener, cj.a
{
  private com.tencent.mm.api.c Bdk;
  private ChatFooter.g KiE;
  private MMFragment OHs;
  private ImageView PeL;
  public ImageView PeM;
  public LinearLayout PeN;
  public g PeO;
  private c.a PeP;
  private Boolean PeQ;
  private Map<String, ap> PeR;
  private List<ap> PeS;
  private int PeT;
  private ci PeU;
  private a PeV;
  private b PeW;
  private List<String> PeX;
  private final String PeY;
  private final String PeZ;
  private k Pfa;
  private Object dBh;
  private as dSh;
  private String mRa;
  private LinearLayout rmL;
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChatFooterCustom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34319);
    this.rmL = null;
    this.PeL = null;
    this.PeM = null;
    this.PeN = null;
    this.PeO = null;
    this.KiE = null;
    this.PeP = null;
    this.PeQ = Boolean.FALSE;
    this.PeR = new ConcurrentHashMap();
    this.PeS = new ArrayList();
    this.PeT = 0;
    this.PeX = new LinkedList();
    this.PeY = "qrcode";
    this.PeZ = "barcode";
    this.dBh = new Object();
    AppMethodBeat.o(34319);
  }
  
  private void a(k paramk, String paramString)
  {
    AppMethodBeat.i(34328);
    b(this.mRa, paramk.id, paramk.key, k.iOp, paramk.name, "", paramString);
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
    paramk = this.dBh;
    for (int i = 0;; i = -1) {
      try
      {
        while (i < this.PeX.size())
        {
          if (((String)this.PeX.get(i)).equals(str))
          {
            if (i >= 0)
            {
              this.PeX.remove(i);
              Log.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[] { str, Integer.valueOf(this.PeX.size()) });
              return true;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          Log.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[] { str, Integer.valueOf(this.PeX.size()) });
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
    b(this.mRa, paramk.id, paramk.key, k.iOr, paramk.name, "", paramk.value);
    AppMethodBeat.o(34329);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(34330);
    Log.d("ChatCustomFooter", "brandUsername:%s, menuId:%s, menuKey:%s, status:%s, content:%s, actionType:%d, nativescene:%d, titleInfo:%s, indexInfo:%s, actionInfo:%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    com.tencent.mm.plugin.report.service.h.CyF.a(10809, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString5, paramString6, paramString7 });
    AppMethodBeat.o(34330);
  }
  
  private static String bmv(String paramString)
  {
    AppMethodBeat.i(34334);
    if (e.d.bcW(paramString))
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
    paramk = new w(this.mRa, paramk.getInfo());
    bg.azz().a(paramk, 0);
    AppMethodBeat.o(34335);
  }
  
  private boolean ef(Object paramObject)
  {
    AppMethodBeat.i(34332);
    if (!(paramObject instanceof pz))
    {
      Log.e("ChatCustomFooter", "send current location data type error!");
      AppMethodBeat.o(34332);
      return true;
    }
    Object localObject = (pz)paramObject;
    double d1 = ((pz)localObject).dWg.lat;
    double d2 = ((pz)localObject).dWg.lng;
    int i = ((pz)localObject).dWg.dRt;
    paramObject = ((pz)localObject).dWg.label;
    localObject = ((pz)localObject).dWg.dWi;
    Log.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Integer.valueOf(i), paramObject, localObject });
    if ((this.Pfa == null) || (this.Pfa.iOt != 105))
    {
      Log.e("ChatCustomFooter", "cache lost or location type is not correct");
      AppMethodBeat.o(34332);
      return true;
    }
    this.Pfa.state = k.iOr;
    this.Pfa.a(d1, d2, i, paramObject, (String)localObject);
    if (a(this.Pfa))
    {
      c(this.Pfa);
      b(this.Pfa);
    }
    AppMethodBeat.o(34332);
    return true;
  }
  
  private boolean eg(Object paramObject)
  {
    AppMethodBeat.i(34333);
    if ((paramObject == null) || (!(paramObject instanceof qa)))
    {
      AppMethodBeat.o(34333);
      return false;
    }
    String str2 = ((qa)paramObject).dWj.dWl;
    String str1 = ((qa)paramObject).dWj.scanResult;
    paramObject = str1;
    if (!e.d.bcW(str2)) {
      paramObject = str2 + "," + str1;
    }
    if ((this.Pfa == null) || ((this.Pfa.iOt != 100) && (this.Pfa.iOt != 101)))
    {
      Log.e("ChatCustomFooter", "null pointer in cache or type error");
      AppMethodBeat.o(34333);
      return false;
    }
    Log.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[] { str2, paramObject });
    this.Pfa.state = k.iOr;
    this.Pfa.bf(bmv(str2), paramObject);
    if (a(this.Pfa))
    {
      c(this.Pfa);
      b(this.Pfa);
    }
    AppMethodBeat.o(34333);
    return true;
  }
  
  private void gNl()
  {
    AppMethodBeat.i(34322);
    if ((this.OHs != null) && (this.dSh != null) && (!af.isNullOrNil(this.mRa))) {
      com.tencent.mm.pluginsdk.ui.tools.s.a(this.OHs, this.mRa, this.dSh.field_username);
    }
    AppMethodBeat.o(34322);
  }
  
  private void gNm()
  {
    AppMethodBeat.i(34323);
    o localo = new o(com.tencent.mm.loader.j.b.aKV());
    if ((!localo.exists()) && (!localo.mkdirs()))
    {
      Toast.makeText((Activity)getContext(), getContext().getString(2131757534), 1).show();
      AppMethodBeat.o(34323);
      return;
    }
    if ((this.OHs != null) && (!com.tencent.mm.pluginsdk.ui.tools.s.a(this.OHs, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg"))) {
      Toast.makeText((Activity)getContext(), getContext().getString(2131765171), 1).show();
    }
    AppMethodBeat.o(34323);
  }
  
  private void gNo()
  {
    AppMethodBeat.i(34338);
    Log.i("ChatCustomFooter", "switch footer");
    if (this.KiE != null)
    {
      this.PeO.gNq();
      this.KiE.An(true);
    }
    AppMethodBeat.o(34338);
  }
  
  private void gNp()
  {
    AppMethodBeat.i(34339);
    if (this.dSh == null)
    {
      AppMethodBeat.o(34339);
      return;
    }
    if (this.dSh.fuQ == 1)
    {
      bg.aVF();
      com.tencent.mm.model.c.aST().bkd(this.dSh.field_username);
    }
    AppMethodBeat.o(34339);
  }
  
  private String getSender()
  {
    AppMethodBeat.i(34324);
    Object localObject = new StringBuilder("getSender ");
    boolean bool;
    StringBuilder localStringBuilder;
    if (this.PeU == null)
    {
      bool = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool).append(" ");
      if (this.PeU != null) {
        break label86;
      }
    }
    label86:
    for (localObject = com.tencent.mm.model.z.aTY();; localObject = this.PeU.name)
    {
      Log.i("ChatCustomFooter", (String)localObject);
      if (this.PeU != null) {
        break label97;
      }
      localObject = com.tencent.mm.model.z.aTY();
      AppMethodBeat.o(34324);
      return localObject;
      bool = false;
      break;
    }
    label97:
    localObject = this.PeU.name;
    AppMethodBeat.o(34324);
    return localObject;
  }
  
  public final void M(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34336);
    this.rmL = ((LinearLayout)findViewById(2131298438));
    this.PeN = ((LinearLayout)findViewById(2131298443));
    this.PeN.setVisibility(0);
    this.PeM = ((ImageView)findViewById(2131298442));
    this.PeM.setVisibility(0);
    this.PeM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34314);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ChatFooterCustom.c(ChatFooterCustom.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34314);
      }
    });
    this.PeL = ((ImageView)findViewById(2131298437));
    this.PeL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34315);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ChatFooterCustom.d(ChatFooterCustom.this).gNq();
        paramAnonymousView = (ImageView)paramAnonymousView;
        int i;
        int j;
        if (paramAnonymousView.getTag() == null)
        {
          paramAnonymousView.setTag(new Object());
          paramAnonymousView.setImageResource(2131233985);
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
          paramAnonymousView.setImageResource(2131233984);
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
    this.PeO = new g(getContext(), paramViewGroup);
    this.PeO.Pff = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34316);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
    parama = com.tencent.mm.platformtools.z.a(parama.heO.KHn);
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
    c.b.c localc = paramc.cG(false).Ve();
    if ((localc == null) || (localc.dij == null) || (paramString == null))
    {
      paramMMFragment = new IllegalArgumentException(" menuInfo or username is null ! ");
      AppMethodBeat.o(34320);
      throw paramMMFragment;
    }
    this.PeQ = Boolean.valueOf(paramString.equals("gh_f0a92aa7146c"));
    this.PeT = Math.min(localc.dij.size(), 6);
    Log.i("ChatCustomFooter", "setMenus, count:" + this.PeT);
    if (this.PeT <= 0)
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
    if (this.PeT > 3)
    {
      this.PeL.setVisibility(0);
      this.rmL.setWeightSum(Math.min(this.PeT, 3));
      i = 0;
      if (i >= 6) {
        break label664;
      }
      localObject = (FrameLayout)this.rmL.getChildAt(i);
      localTextView = (TextView)((FrameLayout)localObject).findViewById(2131298440);
      localTextView.setTextSize(1, Math.min(1.125F, com.tencent.mm.cb.a.ez(getContext())) * 17.0F);
      localImageView = (ImageView)((FrameLayout)localObject).findViewById(2131298439);
      localImageView.setVisibility(8);
      if (i >= this.PeT) {
        break label605;
      }
      localk = (k)localc.dij.get(i);
      ((FrameLayout)localObject).setTag(localk);
      localTextView.setText(l.c(getContext(), localk.name));
      if (localk.type == 0)
      {
        int j = (int)localTextView.getTextSize() * 2 / 3;
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        localLayoutParams.height = j;
        localLayoutParams.width = j;
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setImageDrawable(ar.m(getContext(), 2131689780, getContext().getResources().getColor(2131099749)));
        localImageView.setVisibility(0);
      }
      ((FrameLayout)localObject).setOnClickListener(this);
      ((FrameLayout)localObject).setVisibility(0);
      if (this.PeQ.booleanValue())
      {
        Log.i("ChatCustomFooter", "needShowRedDot：register RedDotComponent");
        Log.i("ChatCustomFooter", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (!this.PeR.containsKey(localk.key)) {
          break label493;
        }
        Log.d("ChatCustomFooter", "this key has register");
        label463:
        this.PeO.d(localk);
      }
    }
    for (;;)
    {
      i += 1;
      break label171;
      this.PeL.setVisibility(8);
      break;
      label493:
      localObject = new ap(getContext(), localk.key, new ap.a()
      {
        public final void O(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(232843);
          Log.d("ChatCustomFooter", "OnShowRedDot show：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          if (localTextView == null)
          {
            Log.d("ChatCustomFooter", "OnShowRedDot mTextView == null");
            AppMethodBeat.o(232843);
            return;
          }
          if (paramAnonymousBoolean)
          {
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(232842);
                Object localObject = ChatFooterCustom.this.getContext().getResources().getDrawable(2131235385);
                ((Drawable)localObject).setBounds(0, 0, at.fromDPToPix(ChatFooterCustom.this.getContext(), 8), at.fromDPToPix(ChatFooterCustom.this.getContext(), 8));
                localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
                SpannableString localSpannableString = new SpannableString("@");
                localSpannableString.setSpan(localObject, 0, 1, 33);
                Log.i("ChatCustomFooter", "setReddotText：%s", new Object[] { ChatFooterCustom.5.this.Pfd.key });
                ChatFooterCustom.5.this.Pfc.setText(TextUtils.concat(new CharSequence[] { l.c(ChatFooterCustom.this.getContext(), ChatFooterCustom.5.this.Pfd.name) + " ", localSpannableString }));
                AppMethodBeat.o(232842);
              }
            }, 500L);
            AppMethodBeat.o(232843);
            return;
          }
          Log.i("ChatCustomFooter", "dont setReddotText:%s", new Object[] { localk.key });
          localTextView.setText(l.c(ChatFooterCustom.this.getContext(), localk.name));
          AppMethodBeat.o(232843);
        }
      });
      com.tencent.mm.plugin.newtips.a.exl().h((com.tencent.mm.plugin.newtips.a.a)localObject);
      this.PeR.put(localk.key, localObject);
      this.PeS.add(localObject);
      Log.d("ChatCustomFooter", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.PeR.size()), Integer.valueOf(this.PeS.size()) });
      break label463;
      label605:
      if ((i >= 3) && (this.PeT > 3))
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
    this.OHs = paramMMFragment;
    this.mRa = paramString;
    this.Bdk = paramc;
    if (this.PeV != null) {
      EventCenter.instance.removeListener(this.PeV);
    }
    if (this.PeW != null) {
      EventCenter.instance.removeListener(this.PeW);
    }
    this.PeV = new a((byte)0);
    this.PeW = new b((byte)0);
    EventCenter.instance.addListener(this.PeV);
    EventCenter.instance.addListener(this.PeW);
    AppMethodBeat.o(34320);
  }
  
  public final void gNk()
  {
    AppMethodBeat.i(34321);
    if (this.PeV != null) {
      EventCenter.instance.removeListener(this.PeV);
    }
    if (this.PeW != null) {
      EventCenter.instance.removeListener(this.PeW);
    }
    Log.i("ChatCustomFooter", " releaseRedDotResource()");
    Object localObject1;
    Object localObject2;
    if (this.PeO != null)
    {
      localObject1 = this.PeO;
      Log.i("MicroMsg.ChatFooterCustomSubmenu", "releaseRedDotResource()");
      ((g)localObject1).Pfg = "";
      ((g)localObject1).eaY = false;
      if ((((g)localObject1).PeR != null) && (((g)localObject1).PeR.size() > 0)) {
        ((g)localObject1).PeR.clear();
      }
      if ((((g)localObject1).PeS != null) && (((g)localObject1).PeS.size() > 0))
      {
        localObject2 = ((g)localObject1).PeS.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ap localap = (ap)((Iterator)localObject2).next();
          com.tencent.mm.plugin.newtips.a.exl();
          i.i(localap);
        }
        ((g)localObject1).PeS.clear();
      }
    }
    if ((this.PeR != null) && (this.PeR.size() > 0)) {
      this.PeR.clear();
    }
    if ((this.PeS != null) && (this.PeS.size() > 0))
    {
      localObject1 = this.PeS.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ap)((Iterator)localObject1).next();
        com.tencent.mm.plugin.newtips.a.exl();
        i.i((com.tencent.mm.plugin.newtips.a.a)localObject2);
      }
      this.PeS.clear();
    }
    AppMethodBeat.o(34321);
  }
  
  public final void gNn()
  {
    AppMethodBeat.i(34325);
    if (this.PeO != null) {
      this.PeO.gNq();
    }
    AppMethodBeat.o(34325);
  }
  
  public as getTalker()
  {
    return this.dSh;
  }
  
  public String getTalkerUserName()
  {
    if (this.dSh == null) {
      return null;
    }
    return this.dSh.field_username;
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject3).bm(???);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject3).axR());
        localObject3 = ???.getTag();
        if (!(localObject3 instanceof k))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34326);
          return;
        }
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(8);
        localObject3 = (k)localObject3;
        if (this.PeQ.booleanValue())
        {
          com.tencent.mm.plugin.newtips.a.exl().a(new com.tencent.mm.plugin.newtips.b.e(((k)localObject3).key));
          com.tencent.mm.plugin.report.service.h.CyF.a(19541, new Object[] { Integer.valueOf(2), ((k)localObject3).key });
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
      Object localObject4 = this.PeO;
      int i = localObject1[0] + ???.getWidth() / 2;
      int j = localObject1[1];
      if (!((g)localObject4).isShowing())
      {
        ((g)localObject4).a((k)localObject3, i, j);
      }
      else
      {
        ((g)localObject4).gNq();
        if ((localObject3 != null) && ((((g)localObject4).Pfm.id != ((k)localObject3).id) || (!((g)localObject4).Pfm.key.equals(((k)localObject3).key))))
        {
          ((g)localObject4).a((k)localObject3, i, j);
          continue;
          Log.i("ChatCustomFooter", "start webview url");
          gNp();
          this.PeO.gNq();
          ((k)localObject3).state = k.iOp;
          a((k)localObject3, ((k)localObject3).egX);
          c((k)localObject3);
          if ((!q.a.JSZ.b(getContext(), ((k)localObject3).value, new Object[0])) && (!e.a(((k)localObject3).egX, getContext(), this.OHs, this.mRa)))
          {
            ??? = new Intent();
            ???.putExtra("KPublisherId", "custom_menu");
            ???.putExtra("pre_username", this.mRa);
            ???.putExtra("prePublishId", "custom_menu");
            ???.putExtra("preUsername", this.mRa);
            ???.putExtra("preChatName", this.mRa);
            ???.putExtra("preChatTYPE", ac.aJ(this.mRa, this.mRa));
            ???.putExtra("rawUrl", ((k)localObject3).value);
            ???.putExtra("geta8key_username", this.mRa);
            ???.putExtra("from_scence", 1);
            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", ???);
            continue;
            Log.i("ChatCustomFooter", "switch to input");
            this.PeO.gNq();
            gNo();
            ((k)localObject3).state = k.iOp;
            a((k)localObject3, ((k)localObject3).value);
            c((k)localObject3);
            continue;
            Log.i("ChatCustomFooter", "get latest message");
            gNp();
            this.PeO.gNq();
            ((k)localObject3).state = k.iOp;
            a((k)localObject3, ((k)localObject3).value);
            c((k)localObject3);
            this.PeP.gPf();
            if ((ab.Iv(getTalkerUserName())) && (WeChatSomeFeatureSwitch.hardcodeWeChatUSTeam()) && (((k)localObject3).key.equalsIgnoreCase("rselfmenu_2")) && (((k)localObject3).value.contains("weixin://dl/")))
            {
              com.tencent.mm.pluginsdk.g.ce(getContext(), ((k)localObject3).value);
              continue;
              gNp();
              this.PeO.gNq();
              ((k)localObject3).state = k.iOp;
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
                  ((AppBrandStatObject)localObject3).dCw = this.mRa;
                  localObject4 = (r)com.tencent.mm.kernel.g.af(r.class);
                  Context localContext = getContext();
                  String str2 = ???.optString("userName");
                  String str3 = ???.optString("pagePath");
                  if (this.Bdk == null) {}
                  for (??? = (View)localObject1;; ??? = this.Bdk.field_appId)
                  {
                    ((r)localObject4).a(localContext, str2, null, 0, 0, str3, (AppBrandStatObject)localObject3, ???);
                    break;
                  }
                  Log.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                  gNp();
                  this.PeO.gNq();
                  ((k)localObject3).state = k.iOq;
                  localObject1 = ((k)localObject3).id + ((k)localObject3).key;
                  synchronized (this.dBh)
                  {
                    this.PeX.add(localObject1);
                    Log.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[] { localObject1, Integer.valueOf(this.PeX.size()) });
                    b(this.mRa, ((k)localObject3).id, ((k)localObject3).key, k.iOq, ((k)localObject3).name, "", ((k)localObject3).value);
                    this.Pfa = ((k)localObject3);
                    switch (((k)localObject3).iOt)
                    {
                    case 100: 
                      ??? = new Intent();
                      ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                      ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                      ???.putExtra("key_set_result_after_scan", true);
                      ???.putExtra("key_is_hide_right_btn", true);
                      if (com.tencent.mm.q.a.o(getContext(), true)) {
                        continue;
                      }
                      getContext();
                      if ((com.tencent.mm.bh.e.bgF()) || (com.tencent.mm.q.a.r(getContext(), true))) {
                        continue;
                      }
                      com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                    }
                  }
                  ??? = new Intent();
                  ???.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                  ???.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                  ???.putExtra("key_set_result_after_scan", false);
                  ???.putExtra("key_is_hide_right_btn", true);
                  if (com.tencent.mm.q.a.o(getContext(), true)) {
                    continue;
                  }
                  getContext();
                  if ((com.tencent.mm.bh.e.bgF()) || (com.tencent.mm.q.a.r(getContext(), true))) {
                    continue;
                  }
                  com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", ???);
                }
                catch (JSONException ???) {}
                gNm();
                continue;
                bg.aVF();
                if (!com.tencent.mm.model.c.isSDCardAvailable())
                {
                  u.kf(getContext());
                }
                else
                {
                  ??? = getContext().getString(2131757353);
                  String str1 = getContext().getString(2131757352);
                  localObject3 = getContext();
                  localObject4 = new h.d()
                  {
                    public final void oj(int paramAnonymousInt)
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
                  gNl();
                  continue;
                  ??? = new Intent();
                  ???.putExtra("map_view_type", 0);
                  ???.putExtra("map_sender_name", getSender());
                  ???.putExtra("map_talker_name", getTalkerUserName());
                  ???.putExtra("view_type_key", 1);
                  ???.putExtra("key_get_location_type", 1);
                  com.tencent.mm.br.c.b(getContext(), "location", ".ui.RedirectUI", ???);
                  continue;
                  ??? = new es();
                  ???.dIa.op = 1;
                  ???.dIa.userName = this.dSh.field_username;
                  ???.dIa.context = getContext();
                  EventCenter.instance.publish(???);
                  continue;
                  ??? = new es();
                  ???.dIa.op = 2;
                  ???.dIa.userName = this.dSh.field_username;
                  ???.dIa.context = getContext();
                  EventCenter.instance.publish(???);
                  continue;
                  Log.i("ChatCustomFooter", "jump to search");
                  gNp();
                  this.PeO.gNq();
                  ((k)localObject3).state = k.iOp;
                  a((k)localObject3, ((k)localObject3).value);
                  c((k)localObject3);
                  str1 = ((k)localObject3).value;
                  ??? = "";
                  if (this.dSh != null) {
                    ??? = this.dSh.field_username;
                  }
                  Log.i("ChatCustomFooter", "bizMenu jumpToSearch username: %s, suggestData: %s", new Object[] { ???, str1 });
                  localObject3 = ai.fXX();
                  ((Intent)localObject3).putExtra("ftsneedkeyboard", true);
                  ((Intent)localObject3).putExtra("ftsbizscene", 75);
                  ((Intent)localObject3).putExtra("ftsType", 2);
                  localObject4 = ai.h(75, false, 2);
                  ((Map)localObject4).put("userName", ???);
                  if (!af.isNullOrNil(str1)) {
                    ((Map)localObject4).put("thirdExtParam", str1);
                  }
                  ((Intent)localObject3).putExtra("rawUrl", ai.bd((Map)localObject4));
                  ((Intent)localObject3).putExtra("key_load_js_without_delay", true);
                  ((Intent)localObject3).putExtra("ftsbizusername", ???);
                  ((Intent)localObject3).addFlags(67108864);
                  com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", (Intent)localObject3);
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
  
  public final boolean s(int paramInt, Object paramObject)
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
    Object localObject = new o(paramObject);
    if ((((o)localObject).exists()) && (((o)localObject).isFile()))
    {
      Log.i("ChatCustomFooter", "%s retrieved!", new Object[] { paramObject });
      paramObject = com.tencent.mm.vfs.s.bhK(aa.z(((o)localObject).mUri));
      Log.i("ChatCustomFooter", "MD5 is %s", new Object[] { paramObject });
      if ((this.Pfa == null) || ((this.Pfa.iOt != 102) && (this.Pfa.iOt != 103)))
      {
        Log.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramObject);
      this.Pfa.state = k.iOr;
      this.Pfa.u((ArrayList)localObject);
      if (a(this.Pfa))
      {
        c(this.Pfa);
        b(this.Pfa);
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
          o localo = new o(str);
          if ((localo.exists()) && (localo.isFile()))
          {
            Log.i("ChatCustomFooter", "%s retrieved!", new Object[] { str });
            str = com.tencent.mm.vfs.s.bhK(aa.z(localo.mUri));
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
      if ((this.Pfa == null) || ((this.Pfa.iOt != 104) && (this.Pfa.iOt != 103) && (this.Pfa.iOt != 102)))
      {
        Log.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
        AppMethodBeat.o(34331);
        return true;
      }
      this.Pfa.state = k.iOr;
      this.Pfa.u(paramObject);
      if (a(this.Pfa))
      {
        c(this.Pfa);
        b(this.Pfa);
      }
    }
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send current");
    ef(paramObject);
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send selected");
    ef(paramObject);
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send qrcode wait msg");
    if (!eg(paramObject))
    {
      AppMethodBeat.o(34331);
      return true;
    }
    this.PeP.gPf();
    AppMethodBeat.o(34331);
    return true;
    Log.i("ChatCustomFooter", "send qrcode direct");
    eg(paramObject);
    AppMethodBeat.o(34331);
    return true;
  }
  
  public void setOnFooterSwitchListener(ChatFooter.g paramg)
  {
    this.KiE = paramg;
  }
  
  public void setOnProcessClickListener(c.a parama)
  {
    this.PeP = parama;
  }
  
  public void setTalker(as paramas)
  {
    this.dSh = paramas;
  }
  
  final class a
    extends IListener<pz>
  {
    private a()
    {
      AppMethodBeat.i(161517);
      this.__eventId = pz.class.getName().hashCode();
      AppMethodBeat.o(161517);
    }
  }
  
  final class b
    extends IListener<qa>
  {
    private b()
    {
      AppMethodBeat.i(161519);
      this.__eventId = qa.class.getName().hashCode();
      AppMethodBeat.o(161519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom
 * JD-Core Version:    0.7.0.1
 */