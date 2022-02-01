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
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.o.b;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
  extends r<at>
  implements n.b
{
  private static long KsD = 2000L;
  private float JuA;
  HashMap<String, a> JuD;
  private boolean JuE;
  private boolean JuF;
  private float Juw;
  private float Juz;
  private final int KsA;
  private final int KsB;
  private boolean KsE;
  av KsF;
  public String Ksy;
  private String Kvu;
  private ColorStateList[] Kvv;
  private String dCB;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.f nUy;
  protected MMSlideDelView.d nUz;
  
  public j(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, new at());
    AppMethodBeat.i(38528);
    this.Kvv = new ColorStateList[5];
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    this.Juw = -1.0F;
    this.Juz = -1.0F;
    this.JuA = -1.0F;
    this.JuE = false;
    this.JuF = false;
    this.Ksy = "";
    this.KsE = false;
    this.KsF = new av(com.tencent.mm.model.ba.ajF().IdO.getLooper(), new av.a()
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
    this.dCB = paramString;
    try
    {
      ag.aFZ();
      this.Kvu = f.DH(paramString);
      label122:
      this.JuD = new HashMap();
      this.Kvv[0] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
      this.Kvv[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
      this.Kvv[3] = com.tencent.mm.cc.a.m(paramContext, 2131100711);
      this.Kvv[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
      this.Kvv[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
      this.Kvv[4] = com.tencent.mm.cc.a.m(paramContext, 2131100543);
      if (com.tencent.mm.cc.a.in(paramContext))
      {
        this.KsB = paramContext.getResources().getDimensionPixelSize(2131165246);
        this.KsA = paramContext.getResources().getDimensionPixelSize(2131165247);
      }
      for (;;)
      {
        this.Juw = com.tencent.mm.cc.a.ax(paramContext, 2131165517);
        this.Juz = com.tencent.mm.cc.a.ax(paramContext, 2131165466);
        this.JuA = com.tencent.mm.cc.a.ax(paramContext, 2131165576);
        com.tencent.mm.model.ba.aBQ();
        c.azv().a(this);
        AppMethodBeat.o(38528);
        return;
        if (com.tencent.mm.cc.a.im(paramContext))
        {
          this.KsB = paramContext.getResources().getDimensionPixelSize(2131165245);
          this.KsA = paramContext.getResources().getDimensionPixelSize(2131165247);
        }
        else
        {
          this.KsB = paramContext.getResources().getDimensionPixelSize(2131165244);
          this.KsA = paramContext.getResources().getDimensionPixelSize(2131165248);
        }
      }
    }
    catch (Throwable paramString)
    {
      break label122;
    }
  }
  
  public static at a(at paramat, Cursor paramCursor)
  {
    AppMethodBeat.i(194666);
    at localat = paramat;
    if (paramat == null) {
      localat = new at();
    }
    localat.tB("");
    localat.tC("");
    localat.convertFrom(paramCursor);
    AppMethodBeat.o(194666);
    return localat;
  }
  
  private static String aVK(String paramString)
  {
    AppMethodBeat.i(38536);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(paramString);
      AppMethodBeat.o(38536);
      return paramString;
    }
    AppMethodBeat.o(38536);
    return null;
  }
  
  private CharSequence c(at paramat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38535);
    if ((!bt.isNullOrNil(paramat.field_editingMsg)) && ((paramat.field_atCount <= 0) || (paramat.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(k.b(this.context, paramat.field_editingMsg, paramInt));
      AppMethodBeat.o(38535);
      return localObject1;
    }
    Object localObject1 = paramat.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramat = new SpannableString(k.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38535);
      return paramat;
    }
    String str1;
    if ((m(paramat) == 47) || (m(paramat) == 1048625))
    {
      localObject1 = aVK(paramat.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramat = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38535);
        return paramat;
      }
      localObject1 = str1;
      if (paramat.field_digest != null)
      {
        localObject1 = str1;
        if (paramat.field_digest.contains(":"))
        {
          str1 = paramat.field_digest.substring(0, paramat.field_digest.indexOf(":"));
          String str2 = aVK(paramat.field_digest.substring(paramat.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramat = "[" + str2 + "]";
            if (bt.isNullOrNil(str1))
            {
              AppMethodBeat.o(38535);
              return paramat;
            }
            paramat = str1 + ": " + paramat;
            AppMethodBeat.o(38535);
            return paramat;
          }
        }
      }
      str1 = this.context.getString(2131755722);
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramat.tB((String)localObject1);
      }
    }
    else
    {
      if (bt.isNullOrNil(paramat.field_digest)) {
        break label633;
      }
      if (bt.isNullOrNil(paramat.field_digestUser)) {
        break label622;
      }
      if ((paramat.field_isSend != 0) || (!w.vF(paramat.field_username))) {
        break label610;
      }
      localObject1 = v.getDisplayName(paramat.field_digestUser, paramat.field_username);
    }
    for (;;)
    {
      label610:
      label622:
      try
      {
        localObject1 = String.format(paramat.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramat.field_atCount <= 0) || (paramat.field_unReadCount <= 0)) {
          break label661;
        }
        paramat = new SpannableStringBuilder(this.context.getString(2131761044));
        paramat.setSpan(new ForegroundColorSpan(-5569532), 0, paramat.length(), 33);
        paramat.append(" ").append(k.b(this.context, str1, paramInt));
        AppMethodBeat.o(38535);
        return paramat;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = v.zf(paramat.field_digestUser);
      continue;
      localObject1 = paramat.field_digest;
      continue;
      label633:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramat.field_isSend, paramat.field_username, paramat.field_content, m(paramat), this.context);
    }
    label661:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramat.field_unReadCount > 1) {
        localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramat.field_unReadCount), str1 });
      }
    }
    paramat = k.b(this.context, (CharSequence)localObject2, paramInt);
    AppMethodBeat.o(38535);
    return paramat;
  }
  
  private void fID()
  {
    AppMethodBeat.i(38538);
    if (this.JuD == null)
    {
      AppMethodBeat.o(38538);
      return;
    }
    Iterator localIterator = this.JuD.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).KsI = null;
    }
    AppMethodBeat.o(38538);
  }
  
  private void fIE()
  {
    AppMethodBeat.i(38541);
    ad.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.KsE), Boolean.valueOf(this.KsF.fkZ()) });
    this.KsE = true;
    if (this.KsF.fkZ()) {
      fIF();
    }
    AppMethodBeat.o(38541);
  }
  
  private void fIF()
  {
    AppMethodBeat.i(38542);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38527);
        if (!com.tencent.mm.model.ba.ajx())
        {
          j.c(j.this).stopTimer();
          ad.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38527);
          return;
        }
        long l = bt.flT();
        j.d(j.this);
        l = bt.Df(l) * 3L;
        ad.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(j.KsD), Boolean.valueOf(j.a(j.this)) });
        j.Eo((l + j.KsD) / 2L);
        j.e(j.this);
        av localav = j.c(j.this);
        l = j.KsD;
        localav.az(l, l);
        AppMethodBeat.o(38527);
      }
    });
    AppMethodBeat.o(38542);
  }
  
  private CharSequence i(at paramat)
  {
    AppMethodBeat.i(38537);
    if (paramat.field_status == 1)
    {
      paramat = this.context.getString(2131761075);
      AppMethodBeat.o(38537);
      return paramat;
    }
    if (paramat.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38537);
      return "";
    }
    paramat = i.c(this.context, paramat.field_conversationTime, true);
    AppMethodBeat.o(38537);
    return paramat;
  }
  
  private static int m(at paramat)
  {
    int j = 1;
    AppMethodBeat.i(38534);
    paramat = paramat.field_msgType;
    int i = j;
    if (paramat != null)
    {
      i = j;
      if (paramat.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramat).intValue();
      AppMethodBeat.o(38534);
      return i;
    }
    catch (NumberFormatException paramat)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(38532);
    det();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      localLinkedList.addAll(com.tencent.mm.am.g.DV(this.dCB));
      label30:
      if (bt.isNullOrNil(this.Kvu))
      {
        com.tencent.mm.model.ba.aBQ();
        setCursor(c.azv().c(w.hFd, localLinkedList, this.dCB));
      }
      for (;;)
      {
        if (this.JaF != null) {
          this.JaF.aSs();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38532);
        return;
        localLinkedList.add(this.Kvu);
        com.tencent.mm.model.ba.aBQ();
        setCursor(c.azv().c(w.hFd, localLinkedList, this.dCB));
      }
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(38531);
    Zu();
    AppMethodBeat.o(38531);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38539);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38539);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(38539);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.nUy = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38540);
    ad.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.JuE), Boolean.valueOf(this.JuF), paramString });
    if ((!bt.isNullOrNil(paramString)) && (this.JuD != null)) {
      this.JuD.remove(paramString);
    }
    if (this.JuE)
    {
      fIE();
      AppMethodBeat.o(38540);
      return;
    }
    this.JuF = true;
    AppMethodBeat.o(38540);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(194665);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(194665);
    return localCursor;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38533);
    at localat = (at)getItem(paramInt);
    String str = localat.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.cc.a.im(this.context))
      {
        paramView = View.inflate(this.context, 2131493663, null);
        paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131297008));
        paramViewGroup.Kvx = ((NoMeasuredTextView)paramView.findViewById(2131302867));
        paramViewGroup.Kvx.setTextSize(0, this.Juw);
        paramViewGroup.Kvx.setTextColor(this.Kvv[3]);
        paramViewGroup.Kvx.setShouldEllipsize(true);
        paramViewGroup.Kvy = ((NoMeasuredTextView)paramView.findViewById(2131306207));
        paramViewGroup.Kvy.setTextSize(0, this.JuA);
        paramViewGroup.Kvy.setTextColor(this.Kvv[4]);
        paramViewGroup.Kvy.setShouldEllipsize(false);
        paramViewGroup.Kvy.setGravity(5);
        paramViewGroup.Kvz = ((NoMeasuredTextView)paramView.findViewById(2131301311));
        paramViewGroup.Kvz.setTextSize(0, this.Juz);
        paramViewGroup.Kvz.setTextColor(this.Kvv[0]);
        paramViewGroup.Kvz.setShouldEllipsize(true);
        paramViewGroup.KvA = ((TextView)paramView.findViewById(2131305882));
        paramViewGroup.KvA.setBackgroundResource(u.kE(this.context));
        paramViewGroup.JuN = ((ImageView)paramView.findViewById(2131300954));
        paramViewGroup.JuP = paramView.findViewById(2131297015);
        paramView.findViewById(2131305672).setVisibility(8);
        paramView.findViewById(2131301541).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a locala = (a)this.JuD.get(str);
      com.tencent.mm.model.ba.aBQ();
      Object localObject = c.azp().Bf(str);
      label382:
      boolean bool;
      if (locala == null)
      {
        locala = new a((byte)0);
        if (localObject != null)
        {
          locala.KsL = ((int)((b)localObject).gfj);
          if (localObject == null) {
            break label1093;
          }
          bool = true;
          label390:
          locala.KsR = bool;
          if ((localObject == null) || (!((am)localObject).YY())) {
            break label1099;
          }
          bool = true;
          label413:
          locala.KsT = bool;
          if ((localObject == null) || (!((am)localObject).Pf())) {
            break label1105;
          }
          bool = true;
          label436:
          locala.KsO = bool;
          if (localat.field_unReadCount <= 0) {
            break label1111;
          }
          bool = true;
          label454:
          locala.ANB = bool;
          locala.oIb = 0;
          if ((m(localat) == 34) && (localat.field_isSend == 0) && (!bt.isNullOrNil(localat.field_content)) && (!new p(localat.field_content).itZ)) {
            locala.oIb = 1;
          }
          locala.nickName = k.b(this.context, v.a((am)localObject, str, false), paramViewGroup.Kvx.getTextSize());
          locala.KsI = i(localat);
          paramInt = (int)paramViewGroup.Kvz.getTextSize();
          if ((!locala.KsO) || (!locala.ANB)) {
            break label1117;
          }
          bool = true;
          label586:
          locala.KsJ = c(localat, paramInt, bool);
          locala.KsU = localat.field_attrflag;
          switch (localat.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label654:
            locala.KsK = paramInt;
            com.tencent.mm.model.ba.aBQ();
            locala.JuH = c.azv().h(localat);
            locala.KsP = ac.fko();
            this.JuD.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.KsI == null) {
          locala.KsI = i(localat);
        }
        if ((locala.KsO) && (locala.ANB))
        {
          paramViewGroup.Kvz.setTextColor(this.Kvv[0]);
          label747:
          com.tencent.mm.booter.notification.a.h.kY(paramViewGroup.Kvz.getWidth());
          com.tencent.mm.booter.notification.a.h.kZ((int)paramViewGroup.Kvz.getTextSize());
          com.tencent.mm.booter.notification.a.h.b(paramViewGroup.Kvz.getPaint());
          if (locala.KsK == -1) {
            break label1167;
          }
          paramViewGroup.Kvz.setCompoundLeftDrawablesWithIntrinsicBounds(locala.KsK);
          paramViewGroup.Kvz.setDrawLeftDrawable(true);
          label807:
          paramViewGroup.Kvz.setText(locala.KsJ);
          paramViewGroup.Kvx.setDrawRightDrawable(false);
          paramViewGroup.Kvx.setText(locala.nickName);
          localObject = paramViewGroup.Kvy.getLayoutParams();
          if (locala.KsI.length() < 9) {
            break label1178;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.KsB)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.KsB;
            paramViewGroup.Kvy.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label893:
          paramViewGroup.Kvy.setText(locala.KsI);
          if (!locala.KsO) {
            break label1211;
          }
          paramViewGroup.JuN.setVisibility(0);
          label921:
          a.b.c(paramViewGroup.fOf, str);
          paramViewGroup.KvA.setVisibility(4);
          paramViewGroup.JuP.setVisibility(4);
          if ((locala.KsR) && (locala.KsL != 0))
          {
            paramInt = localat.field_unReadCount;
            if (!locala.KsO) {
              break label1228;
            }
            paramViewGroup = paramViewGroup.JuP;
            if (paramInt <= 0) {
              break label1223;
            }
            paramInt = 0;
            label987:
            paramViewGroup.setVisibility(paramInt);
          }
          label992:
          if ((!locala.JuH) || (localat.field_conversationTime == -1L)) {
            break label1305;
          }
          paramView.findViewById(2131298792).setBackgroundResource(2131231817);
        }
        for (;;)
        {
          a.a.fyf().a(paramView, String.valueOf(locala.nickName), localat.field_unReadCount, String.valueOf(locala.KsI), String.valueOf(locala.KsJ));
          AppMethodBeat.o(38533);
          return paramView;
          paramView = View.inflate(this.context, 2131493662, null);
          break;
          locala.KsL = -1;
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
          paramViewGroup.Kvz.setTextColor(this.Kvv[locala.oIb]);
          break label747;
          label1167:
          paramViewGroup.Kvz.setDrawLeftDrawable(false);
          break label807;
          label1178:
          if (((ViewGroup.LayoutParams)localObject).width == this.KsA) {
            break label893;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.KsA;
          paramViewGroup.Kvy.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label893;
          label1211:
          paramViewGroup.JuN.setVisibility(8);
          break label921;
          label1223:
          paramInt = 4;
          break label987;
          label1228:
          if (paramInt > 99)
          {
            paramViewGroup.KvA.setText("");
            paramViewGroup.KvA.setBackgroundResource(2131689744);
            paramViewGroup.KvA.setVisibility(0);
            break label992;
          }
          if (paramInt <= 0) {
            break label992;
          }
          paramViewGroup.KvA.setText(String.valueOf(paramInt));
          paramViewGroup.KvA.setBackgroundResource(u.aP(this.context, paramInt));
          paramViewGroup.KvA.setVisibility(0);
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
    if (this.nUz != null) {
      this.nUz.deC();
    }
    this.JuE = false;
    AppMethodBeat.o(38529);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38530);
    this.JuE = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.i.h.a("MM/dd", (Time)localObject).toString();
    if (!this.Ksy.equals(localObject)) {}
    for (;;)
    {
      this.Ksy = ((String)localObject);
      if (i != 0) {
        fID();
      }
      if (this.JuF)
      {
        super.a(null, null);
        this.JuF = false;
      }
      AppMethodBeat.o(38530);
      return;
      i = 0;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.nUx = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.nUw = paramg;
  }
  
  final class a
  {
    public boolean ANB;
    public boolean JuH;
    public CharSequence KsI;
    public CharSequence KsJ;
    public int KsK;
    public int KsL;
    public boolean KsO;
    public boolean KsP;
    public boolean KsR;
    public boolean KsT;
    public int KsU;
    public CharSequence nickName;
    public int oIb;
    
    private a() {}
  }
  
  public static final class b
  {
    public ImageView JuN;
    public View JuP;
    public TextView KvA;
    public NoMeasuredTextView Kvx;
    public NoMeasuredTextView Kvy;
    public NoMeasuredTextView Kvz;
    public ImageView fOf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */