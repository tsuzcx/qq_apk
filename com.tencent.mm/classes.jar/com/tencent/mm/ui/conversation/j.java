package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.HandlerThread;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  extends r<com.tencent.mm.storage.ap>
  implements n.b
{
  private static long IBx = 2000L;
  private float HGF;
  private float HGI;
  private float HGJ;
  HashMap<String, a> HGM;
  private boolean HGN;
  private boolean HGO;
  public String IBs;
  private final int IBu;
  private final int IBv;
  private boolean IBy;
  au IBz;
  private String IEr;
  private ColorStateList[] IEs;
  private String dqK;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.f ntC;
  protected MMSlideDelView.d ntD;
  
  public j(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, new com.tencent.mm.storage.ap());
    AppMethodBeat.i(38528);
    this.IEs = new ColorStateList[5];
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    this.HGF = -1.0F;
    this.HGI = -1.0F;
    this.HGJ = -1.0F;
    this.HGN = false;
    this.HGO = false;
    this.IBs = "";
    this.IBy = false;
    this.IBz = new au(com.tencent.mm.model.az.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(38526);
        if (j.a(j.this)) {
          j.b(j.this);
        }
        AppMethodBeat.o(38526);
        return false;
      }
    }, false);
    super.a(parama);
    this.dqK = paramString;
    try
    {
      af.aCW();
      this.IEr = e.AI(paramString);
      label122:
      this.HGM = new HashMap();
      this.IEs[0] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
      this.IEs[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
      this.IEs[3] = com.tencent.mm.cc.a.m(paramContext, 2131100711);
      this.IEs[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
      this.IEs[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
      this.IEs[4] = com.tencent.mm.cc.a.m(paramContext, 2131100543);
      if (com.tencent.mm.cc.a.ie(paramContext))
      {
        this.IBv = paramContext.getResources().getDimensionPixelSize(2131165246);
        this.IBu = paramContext.getResources().getDimensionPixelSize(2131165247);
      }
      for (;;)
      {
        this.HGF = com.tencent.mm.cc.a.au(paramContext, 2131165517);
        this.HGI = com.tencent.mm.cc.a.au(paramContext, 2131165466);
        this.HGJ = com.tencent.mm.cc.a.au(paramContext, 2131165576);
        com.tencent.mm.model.az.ayM();
        c.awG().a(this);
        AppMethodBeat.o(38528);
        return;
        if (com.tencent.mm.cc.a.id(paramContext))
        {
          this.IBv = paramContext.getResources().getDimensionPixelSize(2131165245);
          this.IBu = paramContext.getResources().getDimensionPixelSize(2131165247);
        }
        else
        {
          this.IBv = paramContext.getResources().getDimensionPixelSize(2131165244);
          this.IBu = paramContext.getResources().getDimensionPixelSize(2131165248);
        }
      }
    }
    catch (Throwable paramString)
    {
      break label122;
    }
  }
  
  public static com.tencent.mm.storage.ap a(com.tencent.mm.storage.ap paramap, Cursor paramCursor)
  {
    AppMethodBeat.i(196822);
    com.tencent.mm.storage.ap localap = paramap;
    if (paramap == null) {
      localap = new com.tencent.mm.storage.ap();
    }
    localap.qR("");
    localap.qS("");
    localap.convertFrom(paramCursor);
    AppMethodBeat.o(196822);
    return localap;
  }
  
  private static String aPU(String paramString)
  {
    AppMethodBeat.i(38536);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(paramString);
      AppMethodBeat.o(38536);
      return paramString;
    }
    AppMethodBeat.o(38536);
    return null;
  }
  
  private CharSequence c(com.tencent.mm.storage.ap paramap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38535);
    if ((!bs.isNullOrNil(paramap.field_editingMsg)) && ((paramap.field_atCount <= 0) || (paramap.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(k.b(this.context, paramap.field_editingMsg, paramInt));
      AppMethodBeat.o(38535);
      return localObject1;
    }
    Object localObject1 = paramap.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramap = new SpannableString(k.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38535);
      return paramap;
    }
    String str1;
    if ((m(paramap) == 47) || (m(paramap) == 1048625))
    {
      localObject1 = aPU(paramap.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramap = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38535);
        return paramap;
      }
      localObject1 = str1;
      if (paramap.field_digest != null)
      {
        localObject1 = str1;
        if (paramap.field_digest.contains(":"))
        {
          str1 = paramap.field_digest.substring(0, paramap.field_digest.indexOf(":"));
          String str2 = aPU(paramap.field_digest.substring(paramap.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramap = "[" + str2 + "]";
            if (bs.isNullOrNil(str1))
            {
              AppMethodBeat.o(38535);
              return paramap;
            }
            paramap = str1 + ": " + paramap;
            AppMethodBeat.o(38535);
            return paramap;
          }
        }
      }
      str1 = this.context.getString(2131755722);
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramap.qR((String)localObject1);
      }
    }
    else
    {
      if (bs.isNullOrNil(paramap.field_digest)) {
        break label633;
      }
      if (bs.isNullOrNil(paramap.field_digestUser)) {
        break label622;
      }
      if ((paramap.field_isSend != 0) || (!w.sQ(paramap.field_username))) {
        break label610;
      }
      localObject1 = v.getDisplayName(paramap.field_digestUser, paramap.field_username);
    }
    for (;;)
    {
      label610:
      label622:
      try
      {
        localObject1 = String.format(paramap.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramap.field_atCount <= 0) || (paramap.field_unReadCount <= 0)) {
          break label661;
        }
        paramap = new SpannableStringBuilder(this.context.getString(2131761044));
        paramap.setSpan(new ForegroundColorSpan(-5569532), 0, paramap.length(), 33);
        paramap.append(" ").append(k.b(this.context, str1, paramInt));
        AppMethodBeat.o(38535);
        return paramap;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = v.wk(paramap.field_digestUser);
      continue;
      localObject1 = paramap.field_digest;
      continue;
      label633:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramap.field_isSend, paramap.field_username, paramap.field_content, m(paramap), this.context);
    }
    label661:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramap.field_unReadCount > 1) {
        localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramap.field_unReadCount), str1 });
      }
    }
    paramap = k.b(this.context, (CharSequence)localObject2, paramInt);
    AppMethodBeat.o(38535);
    return paramap;
  }
  
  private void frO()
  {
    AppMethodBeat.i(38538);
    if (this.HGM == null)
    {
      AppMethodBeat.o(38538);
      return;
    }
    Iterator localIterator = this.HGM.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).IBC = null;
    }
    AppMethodBeat.o(38538);
  }
  
  private void frP()
  {
    AppMethodBeat.i(38541);
    ac.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.IBy), Boolean.valueOf(this.IBz.eVs()) });
    this.IBy = true;
    if (this.IBz.eVs()) {
      frQ();
    }
    AppMethodBeat.o(38541);
  }
  
  private void frQ()
  {
    AppMethodBeat.i(38542);
    com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38527);
        if (!com.tencent.mm.model.az.agM())
        {
          j.c(j.this).stopTimer();
          ac.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38527);
          return;
        }
        long l = bs.eWj();
        j.d(j.this);
        l = bs.Ap(l) * 3L;
        ac.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(j.IBx), Boolean.valueOf(j.a(j.this)) });
        j.Bw((l + j.IBx) / 2L);
        j.e(j.this);
        au localau = j.c(j.this);
        l = j.IBx;
        localau.au(l, l);
        AppMethodBeat.o(38527);
      }
    });
    AppMethodBeat.o(38542);
  }
  
  private CharSequence i(com.tencent.mm.storage.ap paramap)
  {
    AppMethodBeat.i(38537);
    if (paramap.field_status == 1)
    {
      paramap = this.context.getString(2131761075);
      AppMethodBeat.o(38537);
      return paramap;
    }
    if (paramap.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38537);
      return "";
    }
    paramap = com.tencent.mm.pluginsdk.g.h.c(this.context, paramap.field_conversationTime, true);
    AppMethodBeat.o(38537);
    return paramap;
  }
  
  private static int m(com.tencent.mm.storage.ap paramap)
  {
    int j = 1;
    AppMethodBeat.i(38534);
    paramap = paramap.field_msgType;
    int i = j;
    if (paramap != null)
    {
      i = j;
      if (paramap.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramap).intValue();
      AppMethodBeat.o(38534);
      return i;
    }
    catch (NumberFormatException paramap)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(38532);
    cVi();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      localLinkedList.addAll(f.AW(this.dqK));
      label30:
      if (bs.isNullOrNil(this.IEr))
      {
        com.tencent.mm.model.az.ayM();
        setCursor(c.awG().c(w.hmN, localLinkedList, this.dqK));
      }
      for (;;)
      {
        if (this.HmY != null) {
          this.HmY.aPg();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38532);
        return;
        localLinkedList.add(this.IEr);
        com.tencent.mm.model.az.ayM();
        setCursor(c.awG().c(w.hmN, localLinkedList, this.dqK));
      }
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(38531);
    Xb();
    AppMethodBeat.o(38531);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38539);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38539);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(38539);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.ntC = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38540);
    ac.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.HGN), Boolean.valueOf(this.HGO), paramString });
    if ((!bs.isNullOrNil(paramString)) && (this.HGM != null)) {
      this.HGM.remove(paramString);
    }
    if (this.HGN)
    {
      frP();
      AppMethodBeat.o(38540);
      return;
    }
    this.HGO = true;
    AppMethodBeat.o(38540);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(196821);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(196821);
    return localCursor;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38533);
    com.tencent.mm.storage.ap localap = (com.tencent.mm.storage.ap)getItem(paramInt);
    String str = localap.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.cc.a.id(this.context))
      {
        paramView = View.inflate(this.context, 2131493663, null);
        paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131297008));
        paramViewGroup.IEu = ((NoMeasuredTextView)paramView.findViewById(2131302867));
        paramViewGroup.IEu.setTextSize(0, this.HGF);
        paramViewGroup.IEu.setTextColor(this.IEs[3]);
        paramViewGroup.IEu.setShouldEllipsize(true);
        paramViewGroup.IEv = ((NoMeasuredTextView)paramView.findViewById(2131306207));
        paramViewGroup.IEv.setTextSize(0, this.HGJ);
        paramViewGroup.IEv.setTextColor(this.IEs[4]);
        paramViewGroup.IEv.setShouldEllipsize(false);
        paramViewGroup.IEv.setGravity(5);
        paramViewGroup.IEw = ((NoMeasuredTextView)paramView.findViewById(2131301311));
        paramViewGroup.IEw.setTextSize(0, this.HGI);
        paramViewGroup.IEw.setTextColor(this.IEs[0]);
        paramViewGroup.IEw.setShouldEllipsize(true);
        paramViewGroup.IEx = ((TextView)paramView.findViewById(2131305882));
        paramViewGroup.IEx.setBackgroundResource(u.ks(this.context));
        paramViewGroup.HGW = ((ImageView)paramView.findViewById(2131300954));
        paramViewGroup.HGY = paramView.findViewById(2131297015);
        paramView.findViewById(2131305672).setVisibility(8);
        paramView.findViewById(2131301541).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a locala = (a)this.HGM.get(str);
      com.tencent.mm.model.az.ayM();
      Object localObject = c.awB().aNt(str);
      label382:
      boolean bool;
      if (locala == null)
      {
        locala = new a((byte)0);
        if (localObject != null)
        {
          locala.IBF = ((int)((b)localObject).fLJ);
          if (localObject == null) {
            break label1093;
          }
          bool = true;
          label390:
          locala.IBL = bool;
          if ((localObject == null) || (!((ai)localObject).WE())) {
            break label1099;
          }
          bool = true;
          label413:
          locala.IBN = bool;
          if ((localObject == null) || (!((ai)localObject).Nw())) {
            break label1105;
          }
          bool = true;
          label436:
          locala.IBI = bool;
          if (localap.field_unReadCount <= 0) {
            break label1111;
          }
          bool = true;
          label454:
          locala.zvF = bool;
          locala.oeH = 0;
          if ((m(localap) == 34) && (localap.field_isSend == 0) && (!bs.isNullOrNil(localap.field_content)) && (!new p(localap.field_content).iaD)) {
            locala.oeH = 1;
          }
          locala.nickName = k.b(this.context, v.a((ai)localObject, str, false), paramViewGroup.IEu.getTextSize());
          locala.IBC = i(localap);
          paramInt = (int)paramViewGroup.IEw.getTextSize();
          if ((!locala.IBI) || (!locala.zvF)) {
            break label1117;
          }
          bool = true;
          label586:
          locala.IBD = c(localap, paramInt, bool);
          locala.IBO = localap.field_attrflag;
          switch (localap.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label654:
            locala.IBE = paramInt;
            com.tencent.mm.model.az.ayM();
            locala.HGQ = c.awG().h(localap);
            locala.IBJ = ab.eUK();
            this.HGM.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.IBC == null) {
          locala.IBC = i(localap);
        }
        if ((locala.IBI) && (locala.zvF))
        {
          paramViewGroup.IEw.setTextColor(this.IEs[0]);
          label747:
          com.tencent.mm.booter.notification.a.h.kB(paramViewGroup.IEw.getWidth());
          com.tencent.mm.booter.notification.a.h.kC((int)paramViewGroup.IEw.getTextSize());
          com.tencent.mm.booter.notification.a.h.b(paramViewGroup.IEw.getPaint());
          if (locala.IBE == -1) {
            break label1167;
          }
          paramViewGroup.IEw.setCompoundLeftDrawablesWithIntrinsicBounds(locala.IBE);
          paramViewGroup.IEw.setDrawLeftDrawable(true);
          label807:
          paramViewGroup.IEw.setText(locala.IBD);
          paramViewGroup.IEu.setDrawRightDrawable(false);
          paramViewGroup.IEu.setText(locala.nickName);
          localObject = paramViewGroup.IEv.getLayoutParams();
          if (locala.IBC.length() < 9) {
            break label1178;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.IBv)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.IBv;
            paramViewGroup.IEv.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label893:
          paramViewGroup.IEv.setText(locala.IBC);
          if (!locala.IBI) {
            break label1211;
          }
          paramViewGroup.HGW.setVisibility(0);
          label921:
          a.b.c(paramViewGroup.fuY, str);
          paramViewGroup.IEx.setVisibility(4);
          paramViewGroup.HGY.setVisibility(4);
          if ((locala.IBL) && (locala.IBF != 0))
          {
            paramInt = localap.field_unReadCount;
            if (!locala.IBI) {
              break label1228;
            }
            paramViewGroup = paramViewGroup.HGY;
            if (paramInt <= 0) {
              break label1223;
            }
            paramInt = 0;
            label987:
            paramViewGroup.setVisibility(paramInt);
          }
          label992:
          if ((!locala.HGQ) || (localap.field_conversationTime == -1L)) {
            break label1305;
          }
          paramView.findViewById(2131298792).setBackgroundResource(2131231817);
        }
        for (;;)
        {
          a.a.fhP().a(paramView, String.valueOf(locala.nickName), localap.field_unReadCount, String.valueOf(locala.IBC), String.valueOf(locala.IBD));
          AppMethodBeat.o(38533);
          return paramView;
          paramView = View.inflate(this.context, 2131493662, null);
          break;
          locala.IBF = -1;
          break label382;
          label1093:
          bool = false;
          break label390;
          label1099:
          bool = false;
          break label413;
          label1105:
          bool = false;
          break label436;
          label1111:
          bool = false;
          break label454;
          label1117:
          bool = false;
          break label586;
          paramInt = -1;
          break label654;
          paramInt = 2131690878;
          break label654;
          paramInt = -1;
          break label654;
          paramInt = 2131690877;
          break label654;
          paramViewGroup.IEw.setTextColor(this.IEs[locala.oeH]);
          break label747;
          label1167:
          paramViewGroup.IEw.setDrawLeftDrawable(false);
          break label807;
          label1178:
          if (((ViewGroup.LayoutParams)localObject).width == this.IBu) {
            break label893;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.IBu;
          paramViewGroup.IEv.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label893;
          label1211:
          paramViewGroup.HGW.setVisibility(8);
          break label921;
          label1223:
          paramInt = 4;
          break label987;
          label1228:
          if (paramInt > 99)
          {
            paramViewGroup.IEx.setText("");
            paramViewGroup.IEx.setBackgroundResource(2131689744);
            paramViewGroup.IEx.setVisibility(0);
            break label992;
          }
          if (paramInt <= 0) {
            break label992;
          }
          paramViewGroup.IEx.setText(String.valueOf(paramInt));
          paramViewGroup.IEx.setBackgroundResource(u.aM(this.context, paramInt));
          paramViewGroup.IEx.setVisibility(0);
          break label992;
          label1305:
          paramView.findViewById(2131298792).setBackgroundResource(2131231818);
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38529);
    if (this.ntD != null) {
      this.ntD.cVr();
    }
    this.HGN = false;
    AppMethodBeat.o(38529);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38530);
    this.HGN = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.g.g.a("MM/dd", (Time)localObject).toString();
    if (!this.IBs.equals(localObject)) {}
    for (;;)
    {
      this.IBs = ((String)localObject);
      if (i != 0) {
        frO();
      }
      if (this.HGO)
      {
        super.a(null, null);
        this.HGO = false;
      }
      AppMethodBeat.o(38530);
      return;
      i = 0;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.ntB = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.ntA = paramg;
  }
  
  final class a
  {
    public boolean HGQ;
    public CharSequence IBC;
    public CharSequence IBD;
    public int IBE;
    public int IBF;
    public boolean IBI;
    public boolean IBJ;
    public boolean IBL;
    public boolean IBN;
    public int IBO;
    public CharSequence nickName;
    public int oeH;
    public boolean zvF;
    
    private a() {}
  }
  
  public static final class b
  {
    public ImageView HGW;
    public View HGY;
    public NoMeasuredTextView IEu;
    public NoMeasuredTextView IEv;
    public NoMeasuredTextView IEw;
    public TextView IEx;
    public ImageView fuY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */