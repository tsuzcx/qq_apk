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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
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
  extends r<au>
  implements n.b
{
  private static long KOX = 2000L;
  private float JPl;
  private float JPo;
  private float JPp;
  HashMap<String, a> JPs;
  private boolean JPt;
  private boolean JPu;
  public String KOS;
  private final int KOU;
  private final int KOV;
  private boolean KOY;
  aw KOZ;
  private String KRO;
  private ColorStateList[] KRP;
  private String dDG;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.f oae;
  protected MMSlideDelView.d oaf;
  
  public j(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, new au());
    AppMethodBeat.i(38528);
    this.KRP = new ColorStateList[5];
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    this.JPl = -1.0F;
    this.JPo = -1.0F;
    this.JPp = -1.0F;
    this.JPt = false;
    this.JPu = false;
    this.KOS = "";
    this.KOY = false;
    this.KOZ = new aw(bc.ajU().IxZ.getLooper(), new aw.a()
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
    this.dDG = paramString;
    try
    {
      ag.aGp();
      this.KRO = f.Ej(paramString);
      label122:
      this.JPs = new HashMap();
      this.KRP[0] = com.tencent.mm.cb.a.m(paramContext, 2131100490);
      this.KRP[1] = com.tencent.mm.cb.a.m(paramContext, 2131100643);
      this.KRP[3] = com.tencent.mm.cb.a.m(paramContext, 2131100711);
      this.KRP[2] = com.tencent.mm.cb.a.m(paramContext, 2131100640);
      this.KRP[2] = com.tencent.mm.cb.a.m(paramContext, 2131100640);
      this.KRP[4] = com.tencent.mm.cb.a.m(paramContext, 2131100543);
      if (com.tencent.mm.cb.a.is(paramContext))
      {
        this.KOV = paramContext.getResources().getDimensionPixelSize(2131165246);
        this.KOU = paramContext.getResources().getDimensionPixelSize(2131165247);
      }
      for (;;)
      {
        this.JPl = com.tencent.mm.cb.a.ax(paramContext, 2131165517);
        this.JPo = com.tencent.mm.cb.a.ax(paramContext, 2131165466);
        this.JPp = com.tencent.mm.cb.a.ax(paramContext, 2131165576);
        bc.aCg();
        com.tencent.mm.model.c.azL().a(this);
        AppMethodBeat.o(38528);
        return;
        if (com.tencent.mm.cb.a.ir(paramContext))
        {
          this.KOV = paramContext.getResources().getDimensionPixelSize(2131165245);
          this.KOU = paramContext.getResources().getDimensionPixelSize(2131165247);
        }
        else
        {
          this.KOV = paramContext.getResources().getDimensionPixelSize(2131165244);
          this.KOU = paramContext.getResources().getDimensionPixelSize(2131165248);
        }
      }
    }
    catch (Throwable paramString)
    {
      break label122;
    }
  }
  
  public static au a(au paramau, Cursor paramCursor)
  {
    AppMethodBeat.i(188068);
    au localau = paramau;
    if (paramau == null) {
      localau = new au();
    }
    localau.tW("");
    localau.tX("");
    localau.convertFrom(paramCursor);
    AppMethodBeat.o(188068);
    return localau;
  }
  
  private static String aXl(String paramString)
  {
    AppMethodBeat.i(38536);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(paramString);
      AppMethodBeat.o(38536);
      return paramString;
    }
    AppMethodBeat.o(38536);
    return null;
  }
  
  private CharSequence c(au paramau, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38535);
    if ((!bu.isNullOrNil(paramau.field_editingMsg)) && ((paramau.field_atCount <= 0) || (paramau.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(k.b(this.context, paramau.field_editingMsg, paramInt));
      AppMethodBeat.o(38535);
      return localObject1;
    }
    Object localObject1 = paramau.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramau = new SpannableString(k.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38535);
      return paramau;
    }
    String str1;
    if ((m(paramau) == 47) || (m(paramau) == 1048625))
    {
      localObject1 = aXl(paramau.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramau = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38535);
        return paramau;
      }
      localObject1 = str1;
      if (paramau.field_digest != null)
      {
        localObject1 = str1;
        if (paramau.field_digest.contains(":"))
        {
          str1 = paramau.field_digest.substring(0, paramau.field_digest.indexOf(":"));
          String str2 = aXl(paramau.field_digest.substring(paramau.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramau = "[" + str2 + "]";
            if (bu.isNullOrNil(str1))
            {
              AppMethodBeat.o(38535);
              return paramau;
            }
            paramau = str1 + ": " + paramau;
            AppMethodBeat.o(38535);
            return paramau;
          }
        }
      }
      str1 = this.context.getString(2131755722);
      if (bu.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramau.tW((String)localObject1);
      }
    }
    else
    {
      if (bu.isNullOrNil(paramau.field_digest)) {
        break label633;
      }
      if (bu.isNullOrNil(paramau.field_digestUser)) {
        break label622;
      }
      if ((paramau.field_isSend != 0) || (!x.wb(paramau.field_username))) {
        break label610;
      }
      localObject1 = w.getDisplayName(paramau.field_digestUser, paramau.field_username);
    }
    for (;;)
    {
      label610:
      label622:
      try
      {
        localObject1 = String.format(paramau.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramau.field_atCount <= 0) || (paramau.field_unReadCount <= 0)) {
          break label661;
        }
        paramau = new SpannableStringBuilder(this.context.getString(2131761044));
        paramau.setSpan(new ForegroundColorSpan(-5569532), 0, paramau.length(), 33);
        paramau.append(" ").append(k.b(this.context, str1, paramInt));
        AppMethodBeat.o(38535);
        return paramau;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = w.zP(paramau.field_digestUser);
      continue;
      localObject1 = paramau.field_digest;
      continue;
      label633:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramau.field_isSend, paramau.field_username, paramau.field_content, m(paramau), this.context);
    }
    label661:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramau.field_unReadCount > 1) {
        localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramau.field_unReadCount), str1 });
      }
    }
    paramau = k.b(this.context, (CharSequence)localObject2, paramInt);
    AppMethodBeat.o(38535);
    return paramau;
  }
  
  private void fMV()
  {
    AppMethodBeat.i(38538);
    if (this.JPs == null)
    {
      AppMethodBeat.o(38538);
      return;
    }
    Iterator localIterator = this.JPs.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).KPc = null;
    }
    AppMethodBeat.o(38538);
  }
  
  private void fMW()
  {
    AppMethodBeat.i(38541);
    ae.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.KOY), Boolean.valueOf(this.KOZ.foU()) });
    this.KOY = true;
    if (this.KOZ.foU()) {
      fMX();
    }
    AppMethodBeat.o(38541);
  }
  
  private void fMX()
  {
    AppMethodBeat.i(38542);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38527);
        if (!bc.ajM())
        {
          j.c(j.this).stopTimer();
          ae.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38527);
          return;
        }
        long l = bu.fpO();
        j.d(j.this);
        l = bu.DD(l) * 3L;
        ae.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(j.KOX), Boolean.valueOf(j.a(j.this)) });
        j.EQ((l + j.KOX) / 2L);
        j.e(j.this);
        aw localaw = j.c(j.this);
        l = j.KOX;
        localaw.ay(l, l);
        AppMethodBeat.o(38527);
      }
    });
    AppMethodBeat.o(38542);
  }
  
  private CharSequence i(au paramau)
  {
    AppMethodBeat.i(38537);
    if (paramau.field_status == 1)
    {
      paramau = this.context.getString(2131761075);
      AppMethodBeat.o(38537);
      return paramau;
    }
    if (paramau.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38537);
      return "";
    }
    paramau = i.c(this.context, paramau.field_conversationTime, true);
    AppMethodBeat.o(38537);
    return paramau;
  }
  
  private static int m(au paramau)
  {
    int j = 1;
    AppMethodBeat.i(38534);
    paramau = paramau.field_msgType;
    int i = j;
    if (paramau != null)
    {
      i = j;
      if (paramau.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramau).intValue();
      AppMethodBeat.o(38534);
      return i;
    }
    catch (NumberFormatException paramau)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(38532);
    dhl();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      localLinkedList.addAll(com.tencent.mm.al.g.Ex(this.dDG));
      label30:
      if (bu.isNullOrNil(this.KRO))
      {
        bc.aCg();
        setCursor(com.tencent.mm.model.c.azL().c(x.hHV, localLinkedList, this.dDG));
      }
      for (;;)
      {
        if (this.Jvn != null) {
          this.Jvn.aSR();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38532);
        return;
        localLinkedList.add(this.KRO);
        bc.aCg();
        setCursor(com.tencent.mm.model.c.azL().c(x.hHV, localLinkedList, this.dDG));
      }
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(38531);
    ZD();
    AppMethodBeat.o(38531);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38539);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38539);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(38539);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.oae = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38540);
    ae.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.JPt), Boolean.valueOf(this.JPu), paramString });
    if ((!bu.isNullOrNil(paramString)) && (this.JPs != null)) {
      this.JPs.remove(paramString);
    }
    if (this.JPt)
    {
      fMW();
      AppMethodBeat.o(38540);
      return;
    }
    this.JPu = true;
    AppMethodBeat.o(38540);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(188067);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(188067);
    return localCursor;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38533);
    au localau = (au)getItem(paramInt);
    String str = localau.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.cb.a.ir(this.context))
      {
        paramView = View.inflate(this.context, 2131493663, null);
        paramViewGroup.fQl = ((ImageView)paramView.findViewById(2131297008));
        paramViewGroup.KRR = ((NoMeasuredTextView)paramView.findViewById(2131302867));
        paramViewGroup.KRR.setTextSize(0, this.JPl);
        paramViewGroup.KRR.setTextColor(this.KRP[3]);
        paramViewGroup.KRR.setShouldEllipsize(true);
        paramViewGroup.KRS = ((NoMeasuredTextView)paramView.findViewById(2131306207));
        paramViewGroup.KRS.setTextSize(0, this.JPp);
        paramViewGroup.KRS.setTextColor(this.KRP[4]);
        paramViewGroup.KRS.setShouldEllipsize(false);
        paramViewGroup.KRS.setGravity(5);
        paramViewGroup.KRT = ((NoMeasuredTextView)paramView.findViewById(2131301311));
        paramViewGroup.KRT.setTextSize(0, this.JPo);
        paramViewGroup.KRT.setTextColor(this.KRP[0]);
        paramViewGroup.KRT.setShouldEllipsize(true);
        paramViewGroup.KRU = ((TextView)paramView.findViewById(2131305882));
        paramViewGroup.KRU.setBackgroundResource(u.kL(this.context));
        paramViewGroup.JPC = ((ImageView)paramView.findViewById(2131300954));
        paramViewGroup.JPE = paramView.findViewById(2131297015);
        paramView.findViewById(2131305672).setVisibility(8);
        paramView.findViewById(2131301541).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a locala = (a)this.JPs.get(str);
      bc.aCg();
      Object localObject = com.tencent.mm.model.c.azF().BH(str);
      label382:
      boolean bool;
      if (locala == null)
      {
        locala = new a((byte)0);
        if (localObject != null)
        {
          locala.KPf = ((int)((com.tencent.mm.contact.c)localObject).ght);
          if (localObject == null) {
            break label1093;
          }
          bool = true;
          label390:
          locala.KPl = bool;
          if ((localObject == null) || (!((an)localObject).Zh())) {
            break label1099;
          }
          bool = true;
          label413:
          locala.KPn = bool;
          if ((localObject == null) || (!((an)localObject).Pd())) {
            break label1105;
          }
          bool = true;
          label436:
          locala.KPi = bool;
          if (localau.field_unReadCount <= 0) {
            break label1111;
          }
          bool = true;
          label454:
          locala.Bfc = bool;
          locala.oOD = 0;
          if ((m(localau) == 34) && (localau.field_isSend == 0) && (!bu.isNullOrNil(localau.field_content)) && (!new p(localau.field_content).iwT)) {
            locala.oOD = 1;
          }
          locala.nickName = k.b(this.context, w.a((an)localObject, str, false), paramViewGroup.KRR.getTextSize());
          locala.KPc = i(localau);
          paramInt = (int)paramViewGroup.KRT.getTextSize();
          if ((!locala.KPi) || (!locala.Bfc)) {
            break label1117;
          }
          bool = true;
          label586:
          locala.KPd = c(localau, paramInt, bool);
          locala.KPo = localau.field_attrflag;
          switch (localau.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label654:
            locala.KPe = paramInt;
            bc.aCg();
            locala.JPw = com.tencent.mm.model.c.azL().h(localau);
            locala.KPj = ad.foi();
            this.JPs.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.KPc == null) {
          locala.KPc = i(localau);
        }
        if ((locala.KPi) && (locala.Bfc))
        {
          paramViewGroup.KRT.setTextColor(this.KRP[0]);
          label747:
          com.tencent.mm.booter.notification.a.h.la(paramViewGroup.KRT.getWidth());
          com.tencent.mm.booter.notification.a.h.lb((int)paramViewGroup.KRT.getTextSize());
          com.tencent.mm.booter.notification.a.h.b(paramViewGroup.KRT.getPaint());
          if (locala.KPe == -1) {
            break label1167;
          }
          paramViewGroup.KRT.setCompoundLeftDrawablesWithIntrinsicBounds(locala.KPe);
          paramViewGroup.KRT.setDrawLeftDrawable(true);
          label807:
          paramViewGroup.KRT.setText(locala.KPd);
          paramViewGroup.KRR.setDrawRightDrawable(false);
          paramViewGroup.KRR.setText(locala.nickName);
          localObject = paramViewGroup.KRS.getLayoutParams();
          if (locala.KPc.length() < 9) {
            break label1178;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.KOV)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.KOV;
            paramViewGroup.KRS.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label893:
          paramViewGroup.KRS.setText(locala.KPc);
          if (!locala.KPi) {
            break label1211;
          }
          paramViewGroup.JPC.setVisibility(0);
          label921:
          a.b.c(paramViewGroup.fQl, str);
          paramViewGroup.KRU.setVisibility(4);
          paramViewGroup.JPE.setVisibility(4);
          if ((locala.KPl) && (locala.KPf != 0))
          {
            paramInt = localau.field_unReadCount;
            if (!locala.KPi) {
              break label1228;
            }
            paramViewGroup = paramViewGroup.JPE;
            if (paramInt <= 0) {
              break label1223;
            }
            paramInt = 0;
            label987:
            paramViewGroup.setVisibility(paramInt);
          }
          label992:
          if ((!locala.JPw) || (localau.field_conversationTime == -1L)) {
            break label1305;
          }
          paramView.findViewById(2131298792).setBackgroundResource(2131231817);
        }
        for (;;)
        {
          a.a.fCh().a(paramView, String.valueOf(locala.nickName), localau.field_unReadCount, String.valueOf(locala.KPc), String.valueOf(locala.KPd));
          AppMethodBeat.o(38533);
          return paramView;
          paramView = View.inflate(this.context, 2131493662, null);
          break;
          locala.KPf = -1;
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
          paramViewGroup.KRT.setTextColor(this.KRP[locala.oOD]);
          break label747;
          label1167:
          paramViewGroup.KRT.setDrawLeftDrawable(false);
          break label807;
          label1178:
          if (((ViewGroup.LayoutParams)localObject).width == this.KOU) {
            break label893;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.KOU;
          paramViewGroup.KRS.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label893;
          label1211:
          paramViewGroup.JPC.setVisibility(8);
          break label921;
          label1223:
          paramInt = 4;
          break label987;
          label1228:
          if (paramInt > 99)
          {
            paramViewGroup.KRU.setText("");
            paramViewGroup.KRU.setBackgroundResource(2131689744);
            paramViewGroup.KRU.setVisibility(0);
            break label992;
          }
          if (paramInt <= 0) {
            break label992;
          }
          paramViewGroup.KRU.setText(String.valueOf(paramInt));
          paramViewGroup.KRU.setBackgroundResource(u.aP(this.context, paramInt));
          paramViewGroup.KRU.setVisibility(0);
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
    if (this.oaf != null) {
      this.oaf.dhu();
    }
    this.JPt = false;
    AppMethodBeat.o(38529);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38530);
    this.JPt = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.i.h.a("MM/dd", (Time)localObject).toString();
    if (!this.KOS.equals(localObject)) {}
    for (;;)
    {
      this.KOS = ((String)localObject);
      if (i != 0) {
        fMV();
      }
      if (this.JPu)
      {
        super.a(null, null);
        this.JPu = false;
      }
      AppMethodBeat.o(38530);
      return;
      i = 0;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.oad = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.oac = paramg;
  }
  
  final class a
  {
    public boolean Bfc;
    public boolean JPw;
    public CharSequence KPc;
    public CharSequence KPd;
    public int KPe;
    public int KPf;
    public boolean KPi;
    public boolean KPj;
    public boolean KPl;
    public boolean KPn;
    public int KPo;
    public CharSequence nickName;
    public int oOD;
    
    private a() {}
  }
  
  public static final class b
  {
    public ImageView JPC;
    public View JPE;
    public NoMeasuredTextView KRR;
    public NoMeasuredTextView KRS;
    public NoMeasuredTextView KRT;
    public TextView KRU;
    public ImageView fQl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */