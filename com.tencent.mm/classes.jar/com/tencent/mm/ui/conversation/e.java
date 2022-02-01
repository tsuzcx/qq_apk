package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cb;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends r<au>
  implements n.b
{
  private static long KOX = 2000L;
  boolean Aic;
  private float JPl;
  protected float JPo;
  private float JPp;
  private ColorStateList[] JPq;
  HashMap<String, d> JPs;
  private boolean JPt;
  private boolean JPu;
  private boolean KOK;
  private f KOL;
  private com.tencent.mm.pluginsdk.ui.e KOM;
  private boolean KON;
  private boolean KOO;
  private c KOP;
  private com.tencent.mm.sdk.b.c KOQ;
  private b KOR;
  public String KOS;
  final e KOT;
  private final int KOU;
  private final int KOV;
  private a KOW;
  private boolean KOY;
  private com.tencent.mm.sdk.platformtools.aw KOZ;
  protected List<String> fUR;
  private String jff;
  private boolean jjp;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.f oae;
  protected MMSlideDelView.d oaf;
  
  public e(Context paramContext, r.a parama)
  {
    super(paramContext, new au());
    AppMethodBeat.i(38304);
    this.fUR = null;
    this.JPq = new ColorStateList[5];
    this.KOK = true;
    this.jjp = false;
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    this.JPl = -1.0F;
    this.JPo = -1.0F;
    this.JPp = -1.0F;
    this.JPt = false;
    this.JPu = false;
    this.KON = false;
    this.KOO = false;
    this.KOQ = null;
    this.KOR = null;
    this.KOS = "";
    this.KOT = new e();
    this.Aic = false;
    this.KOY = false;
    this.KOZ = new com.tencent.mm.sdk.platformtools.aw(bc.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(38300);
        if (e.d(e.this)) {
          e.e(e.this);
        }
        AppMethodBeat.o(38300);
        return false;
      }
    }, false);
    super.a(parama);
    this.JPq[0] = com.tencent.mm.cb.a.m(paramContext, 2131100490);
    this.JPq[1] = com.tencent.mm.cb.a.m(paramContext, 2131100643);
    this.JPq[3] = com.tencent.mm.cb.a.m(paramContext, 2131100711);
    this.JPq[2] = com.tencent.mm.cb.a.m(paramContext, 2131100640);
    this.JPq[2] = com.tencent.mm.cb.a.m(paramContext, 2131100640);
    this.JPq[4] = com.tencent.mm.cb.a.m(paramContext, 2131100543);
    this.JPs = new HashMap();
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
      AppMethodBeat.o(38304);
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
  
  private static int Xr(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(38313);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(38313);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private CharSequence a(au paramau, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38315);
    if ((!bu.isNullOrNil(paramau.field_editingMsg)) && ((paramau.field_atCount <= 0) || (paramau.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(k.b(this.context, paramau.field_editingMsg, paramInt));
      AppMethodBeat.o(38315);
      return localObject1;
    }
    Object localObject1 = paramau.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramau = new SpannableString(k.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38315);
      return paramau;
    }
    localObject1 = paramau.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      bc.aCg();
      if (bu.o((Integer)com.tencent.mm.model.c.ajA().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramau = this.context.getString(2131763356);
        AppMethodBeat.o(38315);
        return paramau;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azO().arD("@t.qq.com");
      if ((localObject1 != null) && (((cb)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramau = this.context.getString(2131763356);
        AppMethodBeat.o(38315);
        return paramau;
      }
    }
    String str1;
    if ((paramau.field_msgType != null) && ((paramau.field_msgType.equals("47")) || (paramau.field_msgType.equals("1048625"))))
    {
      localObject1 = aXl(paramau.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramau = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38315);
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
              AppMethodBeat.o(38315);
              return paramau;
            }
            paramau = str1 + ": " + paramau;
            AppMethodBeat.o(38315);
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
        break label794;
      }
      if (bu.isNullOrNil(paramau.field_digestUser)) {
        break label783;
      }
      if ((paramau.field_isSend != 0) || (!x.wb(paramau.field_username))) {
        break label771;
      }
      localObject1 = w.getDisplayName(paramau.field_digestUser, paramau.field_username);
    }
    label771:
    label783:
    label794:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramau.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramau.field_atCount <= 0) || (paramau.field_unReadCount <= 0)) {
          break label825;
        }
        paramau = new SpannableStringBuilder(this.context.getString(2131761044));
        paramau.setSpan(new ForegroundColorSpan(-5569532), 0, paramau.length(), 33);
        paramau.append(" ").append(k.b(this.context, str1, paramInt));
        AppMethodBeat.o(38315);
        return paramau;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = w.zP(paramau.field_digestUser);
      continue;
      localObject1 = paramau.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramau.field_isSend, paramau.field_username, paramau.field_content, Xr(paramau.field_msgType), this.context);
    }
    label825:
    if ((paramBoolean) && (paramau.field_unReadCount > 1)) {
      localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramau.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramau = k.b(this.context, (CharSequence)localObject2, paramInt);
      AppMethodBeat.o(38315);
      return paramau;
      localObject2 = str1;
      if (paramau.field_unReadCount > 0)
      {
        localObject2 = str1;
        if (x.AN(paramau.field_parentRef))
        {
          localObject2 = str1;
          if (!(this.context instanceof NewBizConversationUI)) {
            localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramau.field_unReadCount), str1 });
          }
        }
      }
    }
  }
  
  private static String aXl(String paramString)
  {
    AppMethodBeat.i(38316);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(paramString);
      AppMethodBeat.o(38316);
      return paramString;
    }
    AppMethodBeat.o(38316);
    return null;
  }
  
  private void bew()
  {
    AppMethodBeat.i(38314);
    if (this.JPs != null)
    {
      this.JPs.clear();
      this.JPs = null;
    }
    AppMethodBeat.o(38314);
  }
  
  private void fMV()
  {
    AppMethodBeat.i(38308);
    if (this.JPs == null)
    {
      AppMethodBeat.o(38308);
      return;
    }
    Iterator localIterator = this.JPs.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).KPc = null;
    }
    AppMethodBeat.o(38308);
  }
  
  private void fMW()
  {
    AppMethodBeat.i(38319);
    ae.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.KOY), Boolean.valueOf(this.KOZ.foU()) });
    this.KOY = true;
    if (this.KOZ.foU()) {
      fMX();
    }
    AppMethodBeat.o(38319);
  }
  
  private void fMX()
  {
    AppMethodBeat.i(38320);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38301);
        if (!bc.ajM())
        {
          e.f(e.this).stopTimer();
          ae.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38301);
          return;
        }
        long l = bu.fpO();
        e.g(e.this);
        l = bu.DD(l) * 3L;
        ae.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(e.fMY()), Boolean.valueOf(e.d(e.this)) });
        e.EP((l + e.fMY()) / 2L);
        e.h(e.this);
        com.tencent.mm.sdk.platformtools.aw localaw = e.f(e.this);
        l = e.fMY();
        localaw.ay(l, l);
        AppMethodBeat.o(38301);
      }
    });
    AppMethodBeat.o(38320);
  }
  
  private CharSequence i(au paramau)
  {
    AppMethodBeat.i(38305);
    if (paramau.field_status == 1)
    {
      paramau = this.context.getString(2131761075);
      AppMethodBeat.o(38305);
      return paramau;
    }
    if (paramau.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38305);
      return "";
    }
    paramau = com.tencent.mm.pluginsdk.i.i.c(this.context, paramau.field_conversationTime, true);
    AppMethodBeat.o(38305);
    return paramau;
  }
  
  public void ZD()
  {
    AppMethodBeat.i(38311);
    ae.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.jjp) });
    if (this.jjp)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = bc.aCg().hHd.a(x.hHV, this.fUR, this.jff);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.fUR != null) && (this.fUR.size() > 0)) {
        localArrayList1.addAll(this.fUR);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!x.wb(str)) {
            localArrayList2.add(str);
          }
          ae.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(str)));
        }
        if (this.KOL == null) {}
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = bc.aCg().hHe.b(this.jff, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.jff != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38311);
      return;
      bc.aCg();
      setCursor(com.tencent.mm.model.c.azL().a(x.hHV, this.fUR, com.tencent.mm.o.a.ghD, false));
    }
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(38306);
    ZD();
    AppMethodBeat.o(38306);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38317);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38317);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(38317);
  }
  
  protected void a(au paramau, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.oae = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38318);
    ae.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.JPt), Boolean.valueOf(this.JPu), paramString });
    if ((!bu.isNullOrNil(paramString)) && (this.JPs != null)) {
      this.JPs.remove(paramString);
    }
    if (this.JPt)
    {
      fMW();
      AppMethodBeat.o(38318);
      return;
    }
    this.JPu = true;
    AppMethodBeat.o(38318);
  }
  
  protected void a(String paramString, g paramg) {}
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38312);
    au localau = (au)getItem(paramInt);
    String str = localau.field_username;
    paramViewGroup = this.KOT;
    paramViewGroup.talker = str;
    paramViewGroup.contact = null;
    paramViewGroup.KPp = null;
    paramViewGroup.initialized = false;
    if (!bu.isNullOrNil(str)) {
      paramViewGroup.initialized = true;
    }
    this.KOW = new a((byte)0);
    label152:
    Object localObject1;
    label462:
    Object localObject2;
    an localan;
    label569:
    boolean bool;
    label577:
    label600:
    label623:
    int i;
    label667:
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new g();
      if (com.tencent.mm.cb.a.ir(this.context))
      {
        paramView = View.inflate(this.context, 2131493663, null);
        paramViewGroup.fQl = ((ImageView)paramView.findViewById(2131297008));
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label1909;
        }
        a.b.d(paramViewGroup.fQl, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.fQl.getDrawable();
        if (this.KOM != null) {
          this.KOM.a((com.tencent.mm.pluginsdk.ui.e.a)localObject1);
        }
        paramViewGroup.JPz = ((NoMeasuredTextView)paramView.findViewById(2131302867));
        paramViewGroup.KPq = ((NoMeasuredTextView)paramView.findViewById(2131305134));
        paramViewGroup.JPA = ((NoMeasuredTextView)paramView.findViewById(2131306207));
        paramViewGroup.JPB = ((NoMeasuredTextView)paramView.findViewById(2131301311));
        paramViewGroup.oaj = ((TextView)paramView.findViewById(2131305882));
        paramViewGroup.oaj.setBackgroundResource(u.kL(this.context));
        paramViewGroup.JPC = ((ImageView)paramView.findViewById(2131300954));
        paramViewGroup.JPE = paramView.findViewById(2131297015);
        paramViewGroup.JPD = ((ImageView)paramView.findViewById(2131305672));
        paramViewGroup.KPr = ((ImageView)paramView.findViewById(2131301541));
        paramView.setTag(paramViewGroup);
        paramViewGroup.JPB.setTextSize(0, this.JPo);
        paramViewGroup.JPA.setTextSize(0, this.JPp);
        paramViewGroup.JPz.setTextSize(0, this.JPl);
        paramViewGroup.KPq.setTextSize(0, this.JPo);
        paramViewGroup.JPB.setTextColor(this.JPq[0]);
        paramViewGroup.JPA.setTextColor(this.JPq[4]);
        paramViewGroup.JPz.setTextColor(this.JPq[3]);
        paramViewGroup.KPq.setTextColor(this.JPq[0]);
        paramViewGroup.JPB.setShouldEllipsize(true);
        paramViewGroup.JPA.setShouldEllipsize(false);
        paramViewGroup.JPz.setShouldEllipsize(true);
        paramViewGroup.KPq.setShouldEllipsize(true);
        paramViewGroup.JPA.setGravity(5);
        localObject1 = (d)this.JPs.get(str);
        if (localObject1 != null) {
          break label2682;
        }
        localObject2 = new d((byte)0);
        localObject1 = this.KOT;
        if ((((e)localObject1).initialized) && (((e)localObject1).contact == null))
        {
          bc.aCg();
          ((e)localObject1).contact = com.tencent.mm.model.c.azF().BH(((e)localObject1).talker);
        }
        localan = ((e)localObject1).contact;
        if (localan == null) {
          break label1932;
        }
        ((d)localObject2).KPg = localan.eRn;
        ((d)localObject2).KPf = ((int)localan.ght);
        if (localan == null) {
          break label1947;
        }
        bool = true;
        ((d)localObject2).KPl = bool;
        if ((localan == null) || (!localan.Zh())) {
          break label1953;
        }
        bool = true;
        ((d)localObject2).KPn = bool;
        if ((localan == null) || (localan.eRd != 0)) {
          break label1959;
        }
        bool = true;
        ((d)localObject2).KPm = bool;
        ((d)localObject2).rCw = x.wb(str);
        if ((!((d)localObject2).rCw) || (!((d)localObject2).KPm) || (localau.field_unReadCount <= 0)) {
          break label1965;
        }
        bool = true;
        ((d)localObject2).KPk = bool;
        ((d)localObject2).oOD = 0;
        i = Xr(localau.field_msgType);
        if ((i == 34) && (localau.field_isSend == 0) && (!bu.isNullOrNil(localau.field_content)))
        {
          localObject3 = localau.field_content;
          if (!str.equals("qmessage"))
          {
            localObject1 = localObject3;
            if (!str.equals("floatbottle")) {}
          }
          else
          {
            String[] arrayOfString = ((String)localObject3).split(":");
            localObject1 = localObject3;
            if (arrayOfString != null)
            {
              localObject1 = localObject3;
              if (arrayOfString.length > 3) {
                localObject1 = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
              }
            }
          }
          if (!new p((String)localObject1).iwT) {
            ((d)localObject2).oOD = 1;
          }
        }
        if (i == 285212721)
        {
          localObject1 = localau.field_content;
          long l = localau.field_lastSeq;
          com.tencent.e.h.MqF.f(new e.3(this, (String)localObject1), "tmplPreload");
        }
        localObject1 = w.a(localan, str, ((d)localObject2).rCw);
        if ((!((d)localObject2).rCw) || (localObject1 != null)) {
          break label1971;
        }
        ((d)localObject2).nickName = this.context.getString(2131757293);
        label931:
        ((d)localObject2).KPc = i(localau);
        ((d)localObject2).KPd = a(localau, (int)paramViewGroup.JPB.getTextSize(), ((d)localObject2).KPk);
        ((d)localObject2).KPo = localau.field_attrflag;
        switch (localau.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label1023:
          ((d)localObject2).KPe = i;
          ((d)localObject2).KPh = x.a(localau);
          bc.aCg();
          ((d)localObject2).JPw = com.tencent.mm.model.c.azL().h(localau);
          if ((localan != null) && (localan.Pd()))
          {
            bool = true;
            label1075:
            ((d)localObject2).KPi = bool;
            ((d)localObject2).KPj = ad.foi();
            this.JPs.put(str, localObject2);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    label1157:
    label1220:
    label1250:
    label1385:
    label1909:
    label2682:
    for (;;)
    {
      if (((d)localObject1).KPc == null) {
        ((d)localObject1).KPc = i(localau);
      }
      if ((((d)localObject1).KPk) || (x.AN(localau.field_parentRef)))
      {
        paramViewGroup.JPB.setTextColor(this.JPq[0]);
        com.tencent.mm.booter.notification.a.h.la(paramViewGroup.JPB.getWidth());
        com.tencent.mm.booter.notification.a.h.lb((int)paramViewGroup.JPB.getTextSize());
        com.tencent.mm.booter.notification.a.h.b(paramViewGroup.JPB.getPaint());
        if (!str.toLowerCase().endsWith("@t.qq.com")) {
          break label2059;
        }
        paramViewGroup.JPz.setCompoundRightDrawablesWithIntrinsicBounds(2131232700);
        paramViewGroup.JPz.setDrawRightDrawable(true);
        i = ((d)localObject1).KPe;
        if (i == -1) {
          break label2070;
        }
        paramViewGroup.JPB.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        paramViewGroup.JPB.setDrawLeftDrawable(true);
        paramViewGroup.KPq.setVisibility(8);
        localObject2 = paramViewGroup.JPA.getLayoutParams();
        if (((d)localObject1).KPc.length() < 9) {
          break label2081;
        }
        if (((ViewGroup.LayoutParams)localObject2).width != this.KOV)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.KOV;
          paramViewGroup.JPA.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        ae.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
        paramViewGroup.JPA.setText(((d)localObject1).KPc);
        paramViewGroup.JPB.setText(((d)localObject1).KPd);
        if ((!((d)localObject1).rCw) || (!((d)localObject1).KPm)) {
          break label2114;
        }
        paramViewGroup.JPC.setVisibility(0);
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label2145;
        }
        a.b.d(paramViewGroup.fQl, str);
        if (this.KOK)
        {
          if ((localau != null) && (paramViewGroup != null) && (localObject1 != null)) {
            break label2157;
          }
          ae.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        if ((!((d)localObject1).KPh) && (((d)localObject1).JPw) && (bc.ajM()))
        {
          bc.aCg();
          com.tencent.mm.model.c.azL().g(localau);
        }
        if ((!(this.context instanceof NewBizConversationUI)) || (!((d)localObject1).JPw) || (localau.field_conversationTime == -1L)) {
          break label2569;
        }
        localObject2 = this.context.getResources().getDrawable(2131231289);
        i = (int)paramViewGroup.JPz.getTextSize();
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
        localObject3 = new SpannableString("@");
        ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
        paramViewGroup.JPz.setText(TextUtils.concat(new CharSequence[] { ((d)localObject1).nickName, " ", localObject3 }));
        paramView.findViewById(2131298792).setBackgroundResource(2131231818);
        com.tencent.mm.br.d.fjx();
        localObject2 = new wq();
        ((wq)localObject2).dMc.dMe = true;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localau, 7, 0L)) && (!localau.field_username.equals(((wq)localObject2).dMd.dMg)))
        {
          localau.qI(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localau, 6, localau.field_conversationTime));
          bc.aCg();
          com.tencent.mm.model.c.azL().a(localau, localau.field_username);
        }
        if ((com.tencent.mm.bh.g.ium != null) && (com.tencent.mm.bh.g.ium.Hj(localau.field_username))) {
          break label2617;
        }
        paramViewGroup.JPD.setVisibility(8);
        if ((com.tencent.mm.bi.d.iuo == null) || (!com.tencent.mm.bi.d.iuo.Hm(localau.field_username))) {
          break label2670;
        }
        paramViewGroup.KPr.setVisibility(0);
      }
      for (;;)
      {
        this.KOW.content = String.valueOf(((d)localObject1).KPd);
        this.KOW.bVF = String.valueOf(((d)localObject1).nickName);
        this.KOW.time = String.valueOf(((d)localObject1).KPc);
        localObject2 = this.KOW;
        a.a.fCh().a(paramView, ((a)localObject2).bVF, ((a)localObject2).KPb, ((a)localObject2).time, ((a)localObject2).content);
        a(str, paramViewGroup);
        a(localau, ((d)localObject1).JPw, paramInt, false);
        AppMethodBeat.o(38312);
        return paramView;
        paramView = View.inflate(this.context, 2131493662, null);
        break;
        a.b.c(paramViewGroup.fQl, str);
        break label152;
        paramViewGroup = (g)paramView.getTag();
        break label462;
        ((d)localObject2).KPg = -1;
        ((d)localObject2).KPf = -1;
        break label569;
        bool = false;
        break label577;
        bool = false;
        break label600;
        bool = false;
        break label623;
        bool = false;
        break label667;
        ((d)localObject2).nickName = k.b(this.context, w.a(localan, str, ((d)localObject2).rCw), paramViewGroup.JPz.getTextSize());
        break label931;
        i = -1;
        break label1023;
        i = 2131690878;
        break label1023;
        i = -1;
        break label1023;
        i = 2131690877;
        break label1023;
        bool = false;
        break label1075;
        paramViewGroup.JPB.setTextColor(this.JPq[localObject1.oOD]);
        break label1157;
        paramViewGroup.JPz.setDrawRightDrawable(false);
        break label1220;
        paramViewGroup.JPB.setDrawLeftDrawable(false);
        break label1250;
        if (((ViewGroup.LayoutParams)localObject2).width == this.KOU) {
          break label1313;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.KOU;
        paramViewGroup.JPA.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1313;
        if (((d)localObject1).KPi)
        {
          paramViewGroup.JPC.setVisibility(0);
          break label1385;
        }
        paramViewGroup.JPC.setVisibility(8);
        break label1385;
        a.b.c(paramViewGroup.fQl, str);
        break label1414;
        paramViewGroup.oaj.setVisibility(4);
        paramViewGroup.JPE.setVisibility(4);
        if (x.AN(localau.field_username))
        {
          localObject2 = paramViewGroup.JPE;
          if (localau.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            paramViewGroup.JPz.setTextColor(this.JPq[3]);
            break;
          }
        }
        localObject3 = paramViewGroup.JPz;
        if ((((d)localObject1).KPl) && (((d)localObject1).KPg == 1)) {}
        for (localObject2 = this.JPq[2];; localObject2 = this.JPq[3])
        {
          ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
          if ((((d)localObject1).KPl) && (((d)localObject1).KPf != 0)) {
            break label2307;
          }
          ae.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (x.AN(localau.field_parentRef))
        {
          if ((this.context instanceof NewBizConversationUI)) {
            break label1444;
          }
          localObject2 = paramViewGroup.JPE;
          if (localau.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).KPi) && (((d)localObject1).KPn))
        {
          localObject2 = paramViewGroup.JPE;
          if (localau.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).rCw) && (((d)localObject1).KPm))
        {
          localObject2 = paramViewGroup.JPE;
          if (localau.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        i = localau.field_unReadCount;
        if (i > 99)
        {
          paramViewGroup.oaj.setText("");
          paramViewGroup.oaj.setBackgroundResource(2131689744);
          paramViewGroup.oaj.setVisibility(0);
        }
        for (;;)
        {
          this.KOW.KPb = i;
          break;
          if (i > 0)
          {
            paramViewGroup.oaj.setText(localau.field_unReadCount);
            paramViewGroup.oaj.setBackgroundResource(u.aP(this.context, i));
            paramViewGroup.oaj.setVisibility(0);
          }
        }
        paramViewGroup.JPz.setText(((d)localObject1).nickName);
        if ((!((d)localObject1).JPw) || (localau.field_conversationTime == -1L)) {
          break label1614;
        }
        paramView.findViewById(2131298792).setBackgroundResource(2131231817);
        break label1627;
        paramViewGroup.JPD.setVisibility(0);
        if (localau.field_username.equals(((wq)localObject2).dMd.dMg))
        {
          paramViewGroup.JPD.setImageResource(2131691273);
          break label1758;
        }
        paramViewGroup.JPD.setImageResource(2131691272);
        break label1758;
        paramViewGroup.KPr.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(38310);
    this.KOZ.stopTimer();
    this.KOR = null;
    this.KOP = null;
    bew();
    dhl();
    fzh();
    detach();
    AppMethodBeat.o(38310);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38307);
    if (this.oaf != null) {
      this.oaf.dhu();
    }
    this.JPt = false;
    AppMethodBeat.o(38307);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38309);
    ae.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.JPt), Boolean.valueOf(this.KON), Boolean.valueOf(this.JPu), Boolean.valueOf(this.KOO) });
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
      if ((this.KON) && (this.KOR != null)) {
        this.KON = false;
      }
      if ((this.JPu) || (this.KOO))
      {
        super.a(null, null);
        this.JPu = false;
        this.KOO = false;
      }
      AppMethodBeat.o(38309);
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
    public int KPb;
    public String bVF;
    public String content;
    public String time;
    
    private a() {}
  }
  
  public static abstract interface b {}
  
  final class c
    implements n.b
  {
    public final void a(int paramInt, n paramn, Object paramObject)
    {
      AppMethodBeat.i(38303);
      if ((paramObject == null) || (!(paramObject instanceof String)))
      {
        ae.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
        AppMethodBeat.o(38303);
        return;
      }
      paramn = (String)paramObject;
      if (e.a(this.KPa))
      {
        AppMethodBeat.o(38303);
        return;
      }
      if ((paramn != null) && (!paramn.equals("")) && (e.b(this.KPa) != null) && (e.b(this.KPa).containsKey(Integer.valueOf(paramInt))))
      {
        e.b(this.KPa).remove(Integer.valueOf(paramInt));
        e.c(this.KPa);
      }
      AppMethodBeat.o(38303);
    }
  }
  
  final class d
  {
    public boolean JPw;
    public CharSequence KPc;
    public CharSequence KPd;
    public int KPe;
    public int KPf;
    public int KPg;
    public boolean KPh;
    public boolean KPi;
    public boolean KPj;
    public boolean KPk;
    public boolean KPl;
    public boolean KPm;
    public boolean KPn;
    public int KPo;
    public CharSequence nickName;
    public int oOD;
    public boolean rCw;
    
    private d() {}
  }
  
  final class e
  {
    Integer KPp = null;
    an contact = null;
    boolean initialized = false;
    String talker = null;
    
    public e() {}
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public NoMeasuredTextView JPA;
    public NoMeasuredTextView JPB;
    public ImageView JPC;
    public ImageView JPD;
    public View JPE;
    public NoMeasuredTextView JPz;
    public NoMeasuredTextView KPq;
    public ImageView KPr;
    public ImageView fQl;
    public TextView oaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */