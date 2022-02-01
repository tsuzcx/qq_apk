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
import com.tencent.mm.am.e;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.tools.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  extends q<am>
  implements n.b
{
  private static long Hbq = 2000L;
  private float GgQ;
  private float GgT;
  private float GgU;
  HashMap<String, a> GgX;
  private boolean GgY;
  private boolean GgZ;
  public String Hbl;
  private final int Hbn;
  private final int Hbo;
  private boolean Hbr;
  av Hbs;
  private String Hee;
  private ColorStateList[] Hef;
  private String dta;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.f mRm;
  protected MMSlideDelView.d mRn;
  
  public j(Context paramContext, String paramString, q.a parama)
  {
    super(paramContext, new am());
    AppMethodBeat.i(38528);
    this.Hef = new ColorStateList[5];
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    this.GgQ = -1.0F;
    this.GgT = -1.0F;
    this.GgU = -1.0F;
    this.GgY = false;
    this.GgZ = false;
    this.Hbl = "";
    this.Hbr = false;
    this.Hbs = new av(az.afE().EUN.getLooper(), new av.a()
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
    this.dta = paramString;
    try
    {
      com.tencent.mm.am.af.awe();
      this.Hee = e.wC(paramString);
      label122:
      this.GgX = new HashMap();
      this.Hef[0] = com.tencent.mm.cd.a.m(paramContext, 2131100490);
      this.Hef[1] = com.tencent.mm.cd.a.m(paramContext, 2131100643);
      this.Hef[3] = com.tencent.mm.cd.a.m(paramContext, 2131100711);
      this.Hef[2] = com.tencent.mm.cd.a.m(paramContext, 2131100640);
      this.Hef[2] = com.tencent.mm.cd.a.m(paramContext, 2131100640);
      this.Hef[4] = com.tencent.mm.cd.a.m(paramContext, 2131100543);
      if (com.tencent.mm.cd.a.hS(paramContext)) {
        this.Hbo = paramContext.getResources().getDimensionPixelSize(2131165245);
      }
      for (this.Hbn = paramContext.getResources().getDimensionPixelSize(2131165247);; this.Hbn = paramContext.getResources().getDimensionPixelSize(2131165248))
      {
        this.GgQ = com.tencent.mm.cd.a.ao(paramContext, 2131165517);
        this.GgT = com.tencent.mm.cd.a.ao(paramContext, 2131165466);
        this.GgU = com.tencent.mm.cd.a.ao(paramContext, 2131165576);
        az.arV();
        c.apR().a(this);
        AppMethodBeat.o(38528);
        return;
        this.Hbo = paramContext.getResources().getDimensionPixelSize(2131165244);
      }
    }
    catch (Throwable paramString)
    {
      break label122;
    }
  }
  
  public static am a(am paramam, Cursor paramCursor)
  {
    AppMethodBeat.i(191724);
    am localam = paramam;
    if (paramam == null) {
      localam = new am();
    }
    localam.nL("");
    localam.nM("");
    localam.convertFrom(paramCursor);
    AppMethodBeat.o(191724);
    return localam;
  }
  
  private static String aKr(String paramString)
  {
    AppMethodBeat.i(38536);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(paramString);
      AppMethodBeat.o(38536);
      return paramString;
    }
    AppMethodBeat.o(38536);
    return null;
  }
  
  private CharSequence c(am paramam, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38535);
    if ((!bt.isNullOrNil(paramam.field_editingMsg)) && ((paramam.field_atCount <= 0) || (paramam.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(k.b(this.context, paramam.field_editingMsg, paramInt));
      AppMethodBeat.o(38535);
      return localObject1;
    }
    Object localObject1 = paramam.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramam = new SpannableString(k.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38535);
      return paramam;
    }
    String str1;
    if ((l(paramam) == 47) || (l(paramam) == 1048625))
    {
      localObject1 = aKr(paramam.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramam = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38535);
        return paramam;
      }
      localObject1 = str1;
      if (paramam.field_digest != null)
      {
        localObject1 = str1;
        if (paramam.field_digest.contains(":"))
        {
          str1 = paramam.field_digest.substring(0, paramam.field_digest.indexOf(":"));
          String str2 = aKr(paramam.field_digest.substring(paramam.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramam = "[" + str2 + "]";
            if (bt.isNullOrNil(str1))
            {
              AppMethodBeat.o(38535);
              return paramam;
            }
            paramam = str1 + ": " + paramam;
            AppMethodBeat.o(38535);
            return paramam;
          }
        }
      }
      str1 = this.context.getString(2131755722);
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramam.nL((String)localObject1);
      }
    }
    else
    {
      if (bt.isNullOrNil(paramam.field_digest)) {
        break label633;
      }
      if (bt.isNullOrNil(paramam.field_digestUser)) {
        break label622;
      }
      if ((paramam.field_isSend != 0) || (!w.pF(paramam.field_username))) {
        break label610;
      }
      localObject1 = v.getDisplayName(paramam.field_digestUser, paramam.field_username);
    }
    for (;;)
    {
      label610:
      label622:
      try
      {
        localObject1 = String.format(paramam.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramam.field_atCount <= 0) || (paramam.field_unReadCount <= 0)) {
          break label661;
        }
        paramam = new SpannableStringBuilder(this.context.getString(2131761044));
        paramam.setSpan(new ForegroundColorSpan(-5569532), 0, paramam.length(), 33);
        paramam.append(" ").append(k.b(this.context, str1, paramInt));
        AppMethodBeat.o(38535);
        return paramam;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = v.sh(paramam.field_digestUser);
      continue;
      localObject1 = paramam.field_digest;
      continue;
      label633:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramam.field_isSend, paramam.field_username, paramam.field_content, l(paramam), this.context);
    }
    label661:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramam.field_unReadCount > 1) {
        localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramam.field_unReadCount), str1 });
      }
    }
    paramam = k.b(this.context, (CharSequence)localObject2, paramInt);
    AppMethodBeat.o(38535);
    return paramam;
  }
  
  private void fbX()
  {
    AppMethodBeat.i(38538);
    if (this.GgX == null)
    {
      AppMethodBeat.o(38538);
      return;
    }
    Iterator localIterator = this.GgX.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).Hbw = null;
    }
    AppMethodBeat.o(38538);
  }
  
  private void fbY()
  {
    AppMethodBeat.i(38541);
    ad.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.Hbr), Boolean.valueOf(this.Hbs.eFX()) });
    this.Hbr = true;
    if (this.Hbs.eFX()) {
      fbZ();
    }
    AppMethodBeat.o(38541);
  }
  
  private void fbZ()
  {
    AppMethodBeat.i(38542);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38527);
        if (!az.afw())
        {
          j.c(j.this).stopTimer();
          ad.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38527);
          return;
        }
        long l = bt.eGO();
        j.d(j.this);
        l = bt.vM(l) * 3L;
        ad.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(j.Hbq), Boolean.valueOf(j.a(j.this)) });
        j.wT((l + j.Hbq) / 2L);
        j.e(j.this);
        av localav = j.c(j.this);
        l = j.Hbq;
        localav.av(l, l);
        AppMethodBeat.o(38527);
      }
    });
    AppMethodBeat.o(38542);
  }
  
  private CharSequence i(am paramam)
  {
    AppMethodBeat.i(38537);
    if (paramam.field_status == 1)
    {
      paramam = this.context.getString(2131761075);
      AppMethodBeat.o(38537);
      return paramam;
    }
    if (paramam.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38537);
      return "";
    }
    paramam = com.tencent.mm.pluginsdk.g.h.c(this.context, paramam.field_conversationTime, true);
    AppMethodBeat.o(38537);
    return paramam;
  }
  
  private static int l(am paramam)
  {
    int j = 1;
    AppMethodBeat.i(38534);
    paramam = paramam.field_msgType;
    int i = j;
    if (paramam != null)
    {
      i = j;
      if (paramam.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramam).intValue();
      AppMethodBeat.o(38534);
      return i;
    }
    catch (NumberFormatException paramam)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(38532);
    cHX();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      localLinkedList.addAll(f.wQ(this.dta));
      label30:
      if (bt.isNullOrNil(this.Hee))
      {
        az.arV();
        setCursor(c.apR().d(w.gMn, localLinkedList, this.dta));
      }
      for (;;)
      {
        if (this.FNn != null) {
          this.FNn.aIp();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38532);
        return;
        localLinkedList.add(this.Hee);
        az.arV();
        setCursor(c.apR().d(w.gMn, localLinkedList, this.dta));
      }
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }
  
  public final void We()
  {
    AppMethodBeat.i(38531);
    Wd();
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
    this.mRm = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38540);
    ad.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.GgY), Boolean.valueOf(this.GgZ), paramString });
    if ((!bt.isNullOrNil(paramString)) && (this.GgX != null)) {
      this.GgX.remove(paramString);
    }
    if (this.GgY)
    {
      fbY();
      AppMethodBeat.o(38540);
      return;
    }
    this.GgZ = true;
    AppMethodBeat.o(38540);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(191723);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(191723);
    return localCursor;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38533);
    am localam = (am)getItem(paramInt);
    String str = localam.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.cd.a.hS(this.context))
      {
        paramView = View.inflate(this.context, 2131493663, null);
        paramViewGroup.frr = ((ImageView)paramView.findViewById(2131297008));
        paramViewGroup.Heh = ((NoMeasuredTextView)paramView.findViewById(2131302867));
        paramViewGroup.Heh.setTextSize(0, this.GgQ);
        paramViewGroup.Heh.setTextColor(this.Hef[3]);
        paramViewGroup.Heh.setShouldEllipsize(true);
        paramViewGroup.Hei = ((NoMeasuredTextView)paramView.findViewById(2131306207));
        paramViewGroup.Hei.setTextSize(0, this.GgU);
        paramViewGroup.Hei.setTextColor(this.Hef[4]);
        paramViewGroup.Hei.setShouldEllipsize(false);
        paramViewGroup.Hei.setGravity(5);
        paramViewGroup.Hej = ((NoMeasuredTextView)paramView.findViewById(2131301311));
        paramViewGroup.Hej.setTextSize(0, this.GgT);
        paramViewGroup.Hej.setTextColor(this.Hef[0]);
        paramViewGroup.Hej.setShouldEllipsize(true);
        paramViewGroup.Hek = ((TextView)paramView.findViewById(2131305882));
        paramViewGroup.Hek.setBackgroundResource(u.kh(this.context));
        paramViewGroup.Ghh = ((ImageView)paramView.findViewById(2131300954));
        paramViewGroup.Ghj = paramView.findViewById(2131297015);
        paramView.findViewById(2131305672).setVisibility(8);
        paramView.findViewById(2131301541).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a locala = (a)this.GgX.get(str);
      az.arV();
      Object localObject = c.apM().aHY(str);
      label382:
      boolean bool;
      if (locala == null)
      {
        locala = new a((byte)0);
        if (localObject != null)
        {
          locala.Hbz = ((int)((b)localObject).fId);
          if (localObject == null) {
            break label1093;
          }
          bool = true;
          label390:
          locala.HbF = bool;
          if ((localObject == null) || (!((com.tencent.mm.storage.af)localObject).VG())) {
            break label1099;
          }
          bool = true;
          label413:
          locala.HbH = bool;
          if ((localObject == null) || (!((com.tencent.mm.storage.af)localObject).Ny())) {
            break label1105;
          }
          bool = true;
          label436:
          locala.HbC = bool;
          if (localam.field_unReadCount <= 0) {
            break label1111;
          }
          bool = true;
          label454:
          locala.yiG = bool;
          locala.nBH = 0;
          if ((l(localam) == 34) && (localam.field_isSend == 0) && (!bt.isNullOrNil(localam.field_content)) && (!new p(localam.field_content).hAc)) {
            locala.nBH = 1;
          }
          locala.nickName = k.b(this.context, v.a((com.tencent.mm.storage.af)localObject, str, false), paramViewGroup.Heh.getTextSize());
          locala.Hbw = i(localam);
          paramInt = (int)paramViewGroup.Hej.getTextSize();
          if ((!locala.HbC) || (!locala.yiG)) {
            break label1117;
          }
          bool = true;
          label586:
          locala.Hbx = c(localam, paramInt, bool);
          locala.HbI = localam.field_attrflag;
          switch (localam.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label654:
            locala.Hby = paramInt;
            az.arV();
            locala.Ghb = c.apR().h(localam);
            locala.HbD = ac.eFq();
            this.GgX.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.Hbw == null) {
          locala.Hbw = i(localam);
        }
        if ((locala.HbC) && (locala.yiG))
        {
          paramViewGroup.Hej.setTextColor(this.Hef[0]);
          label747:
          com.tencent.mm.booter.notification.a.h.kE(paramViewGroup.Hej.getWidth());
          com.tencent.mm.booter.notification.a.h.kF((int)paramViewGroup.Hej.getTextSize());
          com.tencent.mm.booter.notification.a.h.b(paramViewGroup.Hej.getPaint());
          if (locala.Hby == -1) {
            break label1167;
          }
          paramViewGroup.Hej.setCompoundLeftDrawablesWithIntrinsicBounds(locala.Hby);
          paramViewGroup.Hej.setDrawLeftDrawable(true);
          label807:
          paramViewGroup.Hej.setText(locala.Hbx);
          paramViewGroup.Heh.setDrawRightDrawable(false);
          paramViewGroup.Heh.setText(locala.nickName);
          localObject = paramViewGroup.Hei.getLayoutParams();
          if (locala.Hbw.length() <= 9) {
            break label1178;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.Hbo)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.Hbo;
            paramViewGroup.Hei.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label893:
          paramViewGroup.Hei.setText(locala.Hbw);
          if (!locala.HbC) {
            break label1211;
          }
          paramViewGroup.Ghh.setVisibility(0);
          label921:
          a.b.c(paramViewGroup.frr, str);
          paramViewGroup.Hek.setVisibility(4);
          paramViewGroup.Ghj.setVisibility(4);
          if ((locala.HbF) && (locala.Hbz != 0))
          {
            paramInt = localam.field_unReadCount;
            if (!locala.HbC) {
              break label1228;
            }
            paramViewGroup = paramViewGroup.Ghj;
            if (paramInt <= 0) {
              break label1223;
            }
            paramInt = 0;
            label987:
            paramViewGroup.setVisibility(paramInt);
          }
          label992:
          if ((!locala.Ghb) || (localam.field_conversationTime == -1L)) {
            break label1305;
          }
          paramView.findViewById(2131298792).setBackgroundResource(2131231817);
        }
        for (;;)
        {
          a.a.eSf().a(paramView, String.valueOf(locala.nickName), localam.field_unReadCount, String.valueOf(locala.Hbw), String.valueOf(locala.Hbx));
          AppMethodBeat.o(38533);
          return paramView;
          paramView = View.inflate(this.context, 2131493662, null);
          break;
          locala.Hbz = -1;
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
          paramViewGroup.Hej.setTextColor(this.Hef[locala.nBH]);
          break label747;
          label1167:
          paramViewGroup.Hej.setDrawLeftDrawable(false);
          break label807;
          label1178:
          if (((ViewGroup.LayoutParams)localObject).width == this.Hbn) {
            break label893;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.Hbn;
          paramViewGroup.Hei.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label893;
          label1211:
          paramViewGroup.Ghh.setVisibility(8);
          break label921;
          label1223:
          paramInt = 4;
          break label987;
          label1228:
          if (paramInt > 99)
          {
            paramViewGroup.Hek.setText("");
            paramViewGroup.Hek.setBackgroundResource(2131689744);
            paramViewGroup.Hek.setVisibility(0);
            break label992;
          }
          if (paramInt <= 0) {
            break label992;
          }
          paramViewGroup.Hek.setText(String.valueOf(paramInt));
          paramViewGroup.Hek.setBackgroundResource(u.aG(this.context, paramInt));
          paramViewGroup.Hek.setVisibility(0);
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
    if (this.mRn != null) {
      this.mRn.cIg();
    }
    this.GgY = false;
    AppMethodBeat.o(38529);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38530);
    this.GgY = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.g.g.a("MM/dd", (Time)localObject).toString();
    if (!this.Hbl.equals(localObject)) {}
    for (;;)
    {
      this.Hbl = ((String)localObject);
      if (i != 0) {
        fbX();
      }
      if (this.GgZ)
      {
        super.a(null, null);
        this.GgZ = false;
      }
      AppMethodBeat.o(38530);
      return;
      i = 0;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.mRl = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.mRk = paramg;
  }
  
  final class a
  {
    public boolean Ghb;
    public boolean HbC;
    public boolean HbD;
    public boolean HbF;
    public boolean HbH;
    public int HbI;
    public CharSequence Hbw;
    public CharSequence Hbx;
    public int Hby;
    public int Hbz;
    public int nBH;
    public CharSequence nickName;
    public boolean yiG;
    
    private a() {}
  }
  
  public static final class b
  {
    public ImageView Ghh;
    public View Ghj;
    public NoMeasuredTextView Heh;
    public NoMeasuredTextView Hei;
    public NoMeasuredTextView Hej;
    public TextView Hek;
    public ImageView frr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */