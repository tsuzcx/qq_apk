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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class f
  extends q<am>
  implements n.b
{
  private static long Hbq = 2000L;
  private float GgQ;
  protected float GgT;
  private float GgU;
  private ColorStateList[] GgV;
  HashMap<String, d> GgX;
  private boolean GgY;
  private boolean GgZ;
  private boolean Hbd;
  private f Hbe;
  private com.tencent.mm.pluginsdk.ui.d Hbf;
  private boolean Hbg;
  private boolean Hbh;
  private c Hbi;
  private com.tencent.mm.sdk.b.c Hbj;
  private b Hbk;
  public String Hbl;
  final e Hbm;
  private final int Hbn;
  private final int Hbo;
  private a Hbp;
  private boolean Hbr;
  private av Hbs;
  protected List<String> fvP;
  private String iiW;
  private boolean inh;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.f mRm;
  protected MMSlideDelView.d mRn;
  boolean xmM;
  
  public f(Context paramContext, q.a parama)
  {
    super(paramContext, new am());
    AppMethodBeat.i(38304);
    this.fvP = null;
    this.GgV = new ColorStateList[5];
    this.Hbd = true;
    this.inh = false;
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    this.GgQ = -1.0F;
    this.GgT = -1.0F;
    this.GgU = -1.0F;
    this.GgY = false;
    this.GgZ = false;
    this.Hbg = false;
    this.Hbh = false;
    this.Hbj = null;
    this.Hbk = null;
    this.Hbl = "";
    this.Hbm = new e();
    this.xmM = false;
    this.Hbr = false;
    this.Hbs = new av(az.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(38300);
        if (f.d(f.this)) {
          f.e(f.this);
        }
        AppMethodBeat.o(38300);
        return false;
      }
    }, false);
    super.a(parama);
    this.GgV[0] = com.tencent.mm.cd.a.m(paramContext, 2131100490);
    this.GgV[1] = com.tencent.mm.cd.a.m(paramContext, 2131100643);
    this.GgV[3] = com.tencent.mm.cd.a.m(paramContext, 2131100711);
    this.GgV[2] = com.tencent.mm.cd.a.m(paramContext, 2131100640);
    this.GgV[2] = com.tencent.mm.cd.a.m(paramContext, 2131100640);
    this.GgV[4] = com.tencent.mm.cd.a.m(paramContext, 2131100543);
    this.GgX = new HashMap();
    if (com.tencent.mm.cd.a.hS(paramContext)) {
      this.Hbo = paramContext.getResources().getDimensionPixelSize(2131165245);
    }
    for (this.Hbn = paramContext.getResources().getDimensionPixelSize(2131165247);; this.Hbn = paramContext.getResources().getDimensionPixelSize(2131165248))
    {
      this.GgQ = com.tencent.mm.cd.a.ao(paramContext, 2131165517);
      this.GgT = com.tencent.mm.cd.a.ao(paramContext, 2131165466);
      this.GgU = com.tencent.mm.cd.a.ao(paramContext, 2131165576);
      AppMethodBeat.o(38304);
      return;
      this.Hbo = paramContext.getResources().getDimensionPixelSize(2131165244);
    }
  }
  
  private static int OV(String paramString)
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
  
  private CharSequence a(am paramam, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38315);
    if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramam.field_editingMsg)) && ((paramam.field_atCount <= 0) || (paramam.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramam.field_editingMsg, paramInt));
      AppMethodBeat.o(38315);
      return localObject1;
    }
    Object localObject1 = paramam.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramam = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38315);
      return paramam;
    }
    localObject1 = paramam.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      az.arV();
      if (com.tencent.mm.sdk.platformtools.bt.l((Integer)com.tencent.mm.model.c.afk().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramam = this.context.getString(2131763356);
        AppMethodBeat.o(38315);
        return paramam;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      az.arV();
      localObject1 = com.tencent.mm.model.c.apU().agP("@t.qq.com");
      if ((localObject1 != null) && (((br)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramam = this.context.getString(2131763356);
        AppMethodBeat.o(38315);
        return paramam;
      }
    }
    String str1;
    if ((paramam.field_msgType != null) && ((paramam.field_msgType.equals("47")) || (paramam.field_msgType.equals("1048625"))))
    {
      localObject1 = aKr(paramam.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramam = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38315);
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
            if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str1))
            {
              AppMethodBeat.o(38315);
              return paramam;
            }
            paramam = str1 + ": " + paramam;
            AppMethodBeat.o(38315);
            return paramam;
          }
        }
      }
      str1 = this.context.getString(2131755722);
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramam.nL((String)localObject1);
      }
    }
    else
    {
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramam.field_digest)) {
        break label794;
      }
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramam.field_digestUser)) {
        break label783;
      }
      if ((paramam.field_isSend != 0) || (!w.pF(paramam.field_username))) {
        break label771;
      }
      localObject1 = com.tencent.mm.model.v.getDisplayName(paramam.field_digestUser, paramam.field_username);
    }
    label771:
    label783:
    label794:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramam.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramam.field_atCount <= 0) || (paramam.field_unReadCount <= 0)) {
          break label825;
        }
        paramam = new SpannableStringBuilder(this.context.getString(2131761044));
        paramam.setSpan(new ForegroundColorSpan(-5569532), 0, paramam.length(), 33);
        paramam.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str1, paramInt));
        AppMethodBeat.o(38315);
        return paramam;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = com.tencent.mm.model.v.sh(paramam.field_digestUser);
      continue;
      localObject1 = paramam.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramam.field_isSend, paramam.field_username, paramam.field_content, OV(paramam.field_msgType), this.context);
    }
    label825:
    if ((paramBoolean) && (paramam.field_unReadCount > 1)) {
      localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramam.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramam = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramInt);
      AppMethodBeat.o(38315);
      return paramam;
      localObject2 = str1;
      if (paramam.field_unReadCount > 0)
      {
        localObject2 = str1;
        if (w.td(paramam.field_parentRef))
        {
          localObject2 = str1;
          if (!(this.context instanceof NewBizConversationUI)) {
            localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramam.field_unReadCount), str1 });
          }
        }
      }
    }
  }
  
  private static String aKr(String paramString)
  {
    AppMethodBeat.i(38316);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(paramString);
      AppMethodBeat.o(38316);
      return paramString;
    }
    AppMethodBeat.o(38316);
    return null;
  }
  
  private void aTs()
  {
    AppMethodBeat.i(38314);
    if (this.GgX != null)
    {
      this.GgX.clear();
      this.GgX = null;
    }
    AppMethodBeat.o(38314);
  }
  
  private void fbX()
  {
    AppMethodBeat.i(38308);
    if (this.GgX == null)
    {
      AppMethodBeat.o(38308);
      return;
    }
    Iterator localIterator = this.GgX.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).Hbw = null;
    }
    AppMethodBeat.o(38308);
  }
  
  private void fbY()
  {
    AppMethodBeat.i(38319);
    ad.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.Hbr), Boolean.valueOf(this.Hbs.eFX()) });
    this.Hbr = true;
    if (this.Hbs.eFX()) {
      fbZ();
    }
    AppMethodBeat.o(38319);
  }
  
  private void fbZ()
  {
    AppMethodBeat.i(38320);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38301);
        if (!az.afw())
        {
          f.f(f.this).stopTimer();
          ad.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38301);
          return;
        }
        long l = com.tencent.mm.sdk.platformtools.bt.eGO();
        f.g(f.this);
        l = com.tencent.mm.sdk.platformtools.bt.vM(l) * 3L;
        ad.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(f.fca()), Boolean.valueOf(f.d(f.this)) });
        f.wS((l + f.fca()) / 2L);
        f.h(f.this);
        av localav = f.f(f.this);
        l = f.fca();
        localav.av(l, l);
        AppMethodBeat.o(38301);
      }
    });
    AppMethodBeat.o(38320);
  }
  
  private CharSequence i(am paramam)
  {
    AppMethodBeat.i(38305);
    if (paramam.field_status == 1)
    {
      paramam = this.context.getString(2131761075);
      AppMethodBeat.o(38305);
      return paramam;
    }
    if (paramam.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38305);
      return "";
    }
    paramam = com.tencent.mm.pluginsdk.g.h.c(this.context, paramam.field_conversationTime, true);
    AppMethodBeat.o(38305);
    return paramam;
  }
  
  public void Wd()
  {
    AppMethodBeat.i(38311);
    ad.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.inh) });
    if (this.inh)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = az.arV().gLy.b(w.gMn, this.fvP, this.iiW);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.fvP != null) && (this.fvP.size() > 0)) {
        localArrayList1.addAll(this.fvP);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!w.pF(str)) {
            localArrayList2.add(str);
          }
          ad.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(str)));
        }
        if (this.Hbe == null) {}
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = az.arV().gLz.b(this.iiW, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.iiW != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38311);
      return;
      az.arV();
      setCursor(com.tencent.mm.model.c.apR().a(w.gMn, this.fvP, com.tencent.mm.o.a.fIf, false));
    }
  }
  
  public final void We()
  {
    AppMethodBeat.i(38306);
    Wd();
    AppMethodBeat.o(38306);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38317);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38317);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(38317);
  }
  
  protected void a(am paramam, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.mRm = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38318);
    ad.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.GgY), Boolean.valueOf(this.GgZ), paramString });
    if ((!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString)) && (this.GgX != null)) {
      this.GgX.remove(paramString);
    }
    if (this.GgY)
    {
      fbY();
      AppMethodBeat.o(38318);
      return;
    }
    this.GgZ = true;
    AppMethodBeat.o(38318);
  }
  
  protected void a(String paramString, g paramg) {}
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38312);
    am localam = (am)getItem(paramInt);
    String str = localam.field_username;
    paramViewGroup = this.Hbm;
    paramViewGroup.talker = str;
    paramViewGroup.contact = null;
    paramViewGroup.HbJ = null;
    paramViewGroup.initialized = false;
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(str)) {
      paramViewGroup.initialized = true;
    }
    this.Hbp = new a((byte)0);
    label152:
    Object localObject1;
    label462:
    Object localObject2;
    af localaf;
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
      if (com.tencent.mm.cd.a.hS(this.context))
      {
        paramView = View.inflate(this.context, 2131493663, null);
        paramViewGroup.frr = ((ImageView)paramView.findViewById(2131297008));
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label1909;
        }
        a.b.d(paramViewGroup.frr, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.frr.getDrawable();
        if (this.Hbf != null) {
          this.Hbf.a((d.a)localObject1);
        }
        paramViewGroup.Ghe = ((NoMeasuredTextView)paramView.findViewById(2131302867));
        paramViewGroup.HbK = ((NoMeasuredTextView)paramView.findViewById(2131305134));
        paramViewGroup.Ghf = ((NoMeasuredTextView)paramView.findViewById(2131306207));
        paramViewGroup.Ghg = ((NoMeasuredTextView)paramView.findViewById(2131301311));
        paramViewGroup.mRr = ((TextView)paramView.findViewById(2131305882));
        paramViewGroup.mRr.setBackgroundResource(com.tencent.mm.ui.tools.u.kh(this.context));
        paramViewGroup.Ghh = ((ImageView)paramView.findViewById(2131300954));
        paramViewGroup.Ghj = paramView.findViewById(2131297015);
        paramViewGroup.Ghi = ((ImageView)paramView.findViewById(2131305672));
        paramViewGroup.HbL = ((ImageView)paramView.findViewById(2131301541));
        paramView.setTag(paramViewGroup);
        paramViewGroup.Ghg.setTextSize(0, this.GgT);
        paramViewGroup.Ghf.setTextSize(0, this.GgU);
        paramViewGroup.Ghe.setTextSize(0, this.GgQ);
        paramViewGroup.HbK.setTextSize(0, this.GgT);
        paramViewGroup.Ghg.setTextColor(this.GgV[0]);
        paramViewGroup.Ghf.setTextColor(this.GgV[4]);
        paramViewGroup.Ghe.setTextColor(this.GgV[3]);
        paramViewGroup.HbK.setTextColor(this.GgV[0]);
        paramViewGroup.Ghg.setShouldEllipsize(true);
        paramViewGroup.Ghf.setShouldEllipsize(false);
        paramViewGroup.Ghe.setShouldEllipsize(true);
        paramViewGroup.HbK.setShouldEllipsize(true);
        paramViewGroup.Ghf.setGravity(5);
        localObject1 = (d)this.GgX.get(str);
        if (localObject1 != null) {
          break label2682;
        }
        localObject2 = new d((byte)0);
        localObject1 = this.Hbm;
        if ((((e)localObject1).initialized) && (((e)localObject1).contact == null))
        {
          az.arV();
          ((e)localObject1).contact = com.tencent.mm.model.c.apM().aHY(((e)localObject1).talker);
        }
        localaf = ((e)localObject1).contact;
        if (localaf == null) {
          break label1932;
        }
        ((d)localObject2).HbA = localaf.evH;
        ((d)localObject2).Hbz = ((int)localaf.fId);
        if (localaf == null) {
          break label1947;
        }
        bool = true;
        ((d)localObject2).HbF = bool;
        if ((localaf == null) || (!localaf.VG())) {
          break label1953;
        }
        bool = true;
        ((d)localObject2).HbH = bool;
        if ((localaf == null) || (localaf.evx != 0)) {
          break label1959;
        }
        bool = true;
        ((d)localObject2).HbG = bool;
        ((d)localObject2).qbC = w.pF(str);
        if ((!((d)localObject2).qbC) || (!((d)localObject2).HbG) || (localam.field_unReadCount <= 0)) {
          break label1965;
        }
        bool = true;
        ((d)localObject2).HbE = bool;
        ((d)localObject2).nBH = 0;
        i = OV(localam.field_msgType);
        if ((i == 34) && (localam.field_isSend == 0) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(localam.field_content)))
        {
          localObject3 = localam.field_content;
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
          if (!new p((String)localObject1).hAc) {
            ((d)localObject2).nBH = 1;
          }
        }
        if (i == 285212721)
        {
          localObject1 = localam.field_content;
          long l = localam.field_lastSeq;
          com.tencent.e.h.Iye.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38302);
              Object localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(0L, this.hrB);
              if ((localObject == null) || (((com.tencent.mm.ai.u)localObject).gKs.size() == 0))
              {
                AppMethodBeat.o(38302);
                return;
              }
              localObject = (com.tencent.mm.ai.v)((com.tencent.mm.ai.u)localObject).gKs.getFirst();
              if (!TextUtils.isEmpty(((com.tencent.mm.ai.v)localObject).url))
              {
                ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((com.tencent.mm.ai.v)localObject).url, ((com.tencent.mm.ai.v)localObject).type, 92, new Object[0]);
                ad.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", new Object[] { ((com.tencent.mm.ai.v)localObject).title });
              }
              AppMethodBeat.o(38302);
            }
          }, "tmplPreload");
        }
        localObject1 = com.tencent.mm.model.v.a(localaf, str, ((d)localObject2).qbC);
        if ((!((d)localObject2).qbC) || (localObject1 != null)) {
          break label1971;
        }
        ((d)localObject2).nickName = this.context.getString(2131757293);
        label931:
        ((d)localObject2).Hbw = i(localam);
        ((d)localObject2).Hbx = a(localam, (int)paramViewGroup.Ghg.getTextSize(), ((d)localObject2).HbE);
        ((d)localObject2).HbI = localam.field_attrflag;
        switch (localam.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label1023:
          ((d)localObject2).Hby = i;
          ((d)localObject2).HbB = w.a(localam);
          az.arV();
          ((d)localObject2).Ghb = com.tencent.mm.model.c.apR().h(localam);
          if ((localaf != null) && (localaf.Ny()))
          {
            bool = true;
            label1075:
            ((d)localObject2).HbC = bool;
            ((d)localObject2).HbD = ac.eFq();
            this.GgX.put(str, localObject2);
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
      if (((d)localObject1).Hbw == null) {
        ((d)localObject1).Hbw = i(localam);
      }
      if ((((d)localObject1).HbE) || (w.td(localam.field_parentRef)))
      {
        paramViewGroup.Ghg.setTextColor(this.GgV[0]);
        com.tencent.mm.booter.notification.a.h.kE(paramViewGroup.Ghg.getWidth());
        com.tencent.mm.booter.notification.a.h.kF((int)paramViewGroup.Ghg.getTextSize());
        com.tencent.mm.booter.notification.a.h.b(paramViewGroup.Ghg.getPaint());
        if (!str.toLowerCase().endsWith("@t.qq.com")) {
          break label2059;
        }
        paramViewGroup.Ghe.setCompoundRightDrawablesWithIntrinsicBounds(2131232700);
        paramViewGroup.Ghe.setDrawRightDrawable(true);
        i = ((d)localObject1).Hby;
        if (i == -1) {
          break label2070;
        }
        paramViewGroup.Ghg.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        paramViewGroup.Ghg.setDrawLeftDrawable(true);
        paramViewGroup.HbK.setVisibility(8);
        localObject2 = paramViewGroup.Ghf.getLayoutParams();
        if (((d)localObject1).Hbw.length() <= 9) {
          break label2081;
        }
        if (((ViewGroup.LayoutParams)localObject2).width != this.Hbo)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.Hbo;
          paramViewGroup.Ghf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        ad.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
        paramViewGroup.Ghf.setText(((d)localObject1).Hbw);
        paramViewGroup.Ghg.setText(((d)localObject1).Hbx);
        if ((!((d)localObject1).qbC) || (!((d)localObject1).HbG)) {
          break label2114;
        }
        paramViewGroup.Ghh.setVisibility(0);
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label2145;
        }
        a.b.d(paramViewGroup.frr, str);
        if (this.Hbd)
        {
          if ((localam != null) && (paramViewGroup != null) && (localObject1 != null)) {
            break label2157;
          }
          ad.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        if ((!((d)localObject1).HbB) && (((d)localObject1).Ghb) && (az.afw()))
        {
          az.arV();
          com.tencent.mm.model.c.apR().g(localam);
        }
        if ((!(this.context instanceof NewBizConversationUI)) || (!((d)localObject1).Ghb) || (localam.field_conversationTime == -1L)) {
          break label2569;
        }
        localObject2 = this.context.getResources().getDrawable(2131231289);
        i = (int)paramViewGroup.Ghe.getTextSize();
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
        localObject3 = new SpannableString("@");
        ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
        paramViewGroup.Ghe.setText(TextUtils.concat(new CharSequence[] { ((d)localObject1).nickName, " ", localObject3 }));
        paramView.findViewById(2131298792).setBackgroundResource(2131231818);
        com.tencent.mm.bs.d.eBj();
        localObject2 = new vj();
        ((vj)localObject2).dAP.dAR = true;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localam, 7, 0L)) && (!localam.field_username.equals(((vj)localObject2).dAQ.dAT)))
        {
          localam.kT(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localam, 6, localam.field_conversationTime));
          az.arV();
          com.tencent.mm.model.c.apR().a(localam, localam.field_username);
        }
        if ((com.tencent.mm.bi.g.hxv != null) && (com.tencent.mm.bi.g.hxv.zx(localam.field_username))) {
          break label2617;
        }
        paramViewGroup.Ghi.setVisibility(8);
        if ((com.tencent.mm.bj.d.hxx == null) || (!com.tencent.mm.bj.d.hxx.zA(localam.field_username))) {
          break label2670;
        }
        paramViewGroup.HbL.setVisibility(0);
      }
      for (;;)
      {
        this.Hbp.content = String.valueOf(((d)localObject1).Hbx);
        this.Hbp.bNK = String.valueOf(((d)localObject1).nickName);
        this.Hbp.time = String.valueOf(((d)localObject1).Hbw);
        localObject2 = this.Hbp;
        a.a.eSf().a(paramView, ((a)localObject2).bNK, ((a)localObject2).Hbu, ((a)localObject2).time, ((a)localObject2).content);
        a(str, paramViewGroup);
        a(localam, ((d)localObject1).Ghb, paramInt, false);
        AppMethodBeat.o(38312);
        return paramView;
        paramView = View.inflate(this.context, 2131493662, null);
        break;
        a.b.c(paramViewGroup.frr, str);
        break label152;
        paramViewGroup = (g)paramView.getTag();
        break label462;
        ((d)localObject2).HbA = -1;
        ((d)localObject2).Hbz = -1;
        break label569;
        bool = false;
        break label577;
        bool = false;
        break label600;
        bool = false;
        break label623;
        bool = false;
        break label667;
        ((d)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, com.tencent.mm.model.v.a(localaf, str, ((d)localObject2).qbC), paramViewGroup.Ghe.getTextSize());
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
        paramViewGroup.Ghg.setTextColor(this.GgV[localObject1.nBH]);
        break label1157;
        paramViewGroup.Ghe.setDrawRightDrawable(false);
        break label1220;
        paramViewGroup.Ghg.setDrawLeftDrawable(false);
        break label1250;
        if (((ViewGroup.LayoutParams)localObject2).width == this.Hbn) {
          break label1313;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.Hbn;
        paramViewGroup.Ghf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1313;
        if (((d)localObject1).HbC)
        {
          paramViewGroup.Ghh.setVisibility(0);
          break label1385;
        }
        paramViewGroup.Ghh.setVisibility(8);
        break label1385;
        a.b.c(paramViewGroup.frr, str);
        break label1414;
        paramViewGroup.mRr.setVisibility(4);
        paramViewGroup.Ghj.setVisibility(4);
        if (w.td(localam.field_username))
        {
          localObject2 = paramViewGroup.Ghj;
          if (localam.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            paramViewGroup.Ghe.setTextColor(this.GgV[3]);
            break;
          }
        }
        localObject3 = paramViewGroup.Ghe;
        if ((((d)localObject1).HbF) && (((d)localObject1).HbA == 1)) {}
        for (localObject2 = this.GgV[2];; localObject2 = this.GgV[3])
        {
          ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
          if ((((d)localObject1).HbF) && (((d)localObject1).Hbz != 0)) {
            break label2307;
          }
          ad.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (w.td(localam.field_parentRef))
        {
          if ((this.context instanceof NewBizConversationUI)) {
            break label1444;
          }
          localObject2 = paramViewGroup.Ghj;
          if (localam.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).HbC) && (((d)localObject1).HbH))
        {
          localObject2 = paramViewGroup.Ghj;
          if (localam.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).qbC) && (((d)localObject1).HbG))
        {
          localObject2 = paramViewGroup.Ghj;
          if (localam.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        i = localam.field_unReadCount;
        if (i > 99)
        {
          paramViewGroup.mRr.setText("");
          paramViewGroup.mRr.setBackgroundResource(2131689744);
          paramViewGroup.mRr.setVisibility(0);
        }
        for (;;)
        {
          this.Hbp.Hbu = i;
          break;
          if (i > 0)
          {
            paramViewGroup.mRr.setText(localam.field_unReadCount);
            paramViewGroup.mRr.setBackgroundResource(com.tencent.mm.ui.tools.u.aG(this.context, i));
            paramViewGroup.mRr.setVisibility(0);
          }
        }
        paramViewGroup.Ghe.setText(((d)localObject1).nickName);
        if ((!((d)localObject1).Ghb) || (localam.field_conversationTime == -1L)) {
          break label1614;
        }
        paramView.findViewById(2131298792).setBackgroundResource(2131231817);
        break label1627;
        paramViewGroup.Ghi.setVisibility(0);
        if (localam.field_username.equals(((vj)localObject2).dAQ.dAT))
        {
          paramViewGroup.Ghi.setImageResource(2131691273);
          break label1758;
        }
        paramViewGroup.Ghi.setImageResource(2131691272);
        break label1758;
        paramViewGroup.HbL.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(38310);
    this.Hbs.stopTimer();
    this.Hbk = null;
    this.Hbi = null;
    aTs();
    cHX();
    ePu();
    detach();
    AppMethodBeat.o(38310);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38307);
    if (this.mRn != null) {
      this.mRn.cIg();
    }
    this.GgY = false;
    AppMethodBeat.o(38307);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38309);
    ad.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.GgY), Boolean.valueOf(this.Hbg), Boolean.valueOf(this.GgZ), Boolean.valueOf(this.Hbh) });
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
      if ((this.Hbg) && (this.Hbk != null)) {
        this.Hbg = false;
      }
      if ((this.GgZ) || (this.Hbh))
      {
        super.a(null, null);
        this.GgZ = false;
        this.Hbh = false;
      }
      AppMethodBeat.o(38309);
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
    public int Hbu;
    public String bNK;
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
        ad.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
        AppMethodBeat.o(38303);
        return;
      }
      paramn = (String)paramObject;
      if (f.a(this.Hbt))
      {
        AppMethodBeat.o(38303);
        return;
      }
      if ((paramn != null) && (!paramn.equals("")) && (f.b(this.Hbt) != null) && (f.b(this.Hbt).containsKey(Integer.valueOf(paramInt))))
      {
        f.b(this.Hbt).remove(Integer.valueOf(paramInt));
        f.c(this.Hbt);
      }
      AppMethodBeat.o(38303);
    }
  }
  
  final class d
  {
    public boolean Ghb;
    public int HbA;
    public boolean HbB;
    public boolean HbC;
    public boolean HbD;
    public boolean HbE;
    public boolean HbF;
    public boolean HbG;
    public boolean HbH;
    public int HbI;
    public CharSequence Hbw;
    public CharSequence Hbx;
    public int Hby;
    public int Hbz;
    public int nBH;
    public CharSequence nickName;
    public boolean qbC;
    
    private d() {}
  }
  
  final class e
  {
    Integer HbJ = null;
    af contact = null;
    boolean initialized = false;
    String talker = null;
    
    public e() {}
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public NoMeasuredTextView Ghe;
    public NoMeasuredTextView Ghf;
    public NoMeasuredTextView Ghg;
    public ImageView Ghh;
    public ImageView Ghi;
    public View Ghj;
    public NoMeasuredTextView HbK;
    public ImageView HbL;
    public ImageView frr;
    public TextView mRr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */