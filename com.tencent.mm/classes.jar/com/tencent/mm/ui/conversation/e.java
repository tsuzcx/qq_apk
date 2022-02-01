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
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends r<at>
  implements n.b
{
  private static long KsD = 2000L;
  private float JuA;
  private ColorStateList[] JuB;
  HashMap<String, d> JuD;
  private boolean JuE;
  private boolean JuF;
  private float Juw;
  protected float Juz;
  private final int KsA;
  private final int KsB;
  private a KsC;
  private boolean KsE;
  private av KsF;
  private boolean Ksq;
  private f Ksr;
  private com.tencent.mm.pluginsdk.ui.e Kss;
  private boolean Kst;
  private boolean Ksu;
  private c Ksv;
  private com.tencent.mm.sdk.b.c Ksw;
  private b Ksx;
  public String Ksy;
  final e Ksz;
  protected List<String> fSL;
  private String jcm;
  private boolean jgw;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.f nUy;
  protected MMSlideDelView.d nUz;
  boolean zQV;
  
  public e(Context paramContext, r.a parama)
  {
    super(paramContext, new at());
    AppMethodBeat.i(38304);
    this.fSL = null;
    this.JuB = new ColorStateList[5];
    this.Ksq = true;
    this.jgw = false;
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    this.Juw = -1.0F;
    this.Juz = -1.0F;
    this.JuA = -1.0F;
    this.JuE = false;
    this.JuF = false;
    this.Kst = false;
    this.Ksu = false;
    this.Ksw = null;
    this.Ksx = null;
    this.Ksy = "";
    this.Ksz = new e();
    this.zQV = false;
    this.KsE = false;
    this.KsF = new av(com.tencent.mm.model.ba.ajF().IdO.getLooper(), new av.a()
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
    this.JuB[0] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
    this.JuB[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
    this.JuB[3] = com.tencent.mm.cc.a.m(paramContext, 2131100711);
    this.JuB[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
    this.JuB[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
    this.JuB[4] = com.tencent.mm.cc.a.m(paramContext, 2131100543);
    this.JuD = new HashMap();
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
      AppMethodBeat.o(38304);
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
  
  private static int WF(String paramString)
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
  
  private CharSequence a(at paramat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38315);
    if ((!bt.isNullOrNil(paramat.field_editingMsg)) && ((paramat.field_atCount <= 0) || (paramat.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(k.b(this.context, paramat.field_editingMsg, paramInt));
      AppMethodBeat.o(38315);
      return localObject1;
    }
    Object localObject1 = paramat.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramat = new SpannableString(k.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38315);
      return paramat;
    }
    localObject1 = paramat.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      com.tencent.mm.model.ba.aBQ();
      if (bt.n((Integer)com.tencent.mm.model.c.ajl().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramat = this.context.getString(2131763356);
        AppMethodBeat.o(38315);
        return paramat;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      com.tencent.mm.model.ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azy().aqy("@t.qq.com");
      if ((localObject1 != null) && (((ca)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramat = this.context.getString(2131763356);
        AppMethodBeat.o(38315);
        return paramat;
      }
    }
    String str1;
    if ((paramat.field_msgType != null) && ((paramat.field_msgType.equals("47")) || (paramat.field_msgType.equals("1048625"))))
    {
      localObject1 = aVK(paramat.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramat = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38315);
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
              AppMethodBeat.o(38315);
              return paramat;
            }
            paramat = str1 + ": " + paramat;
            AppMethodBeat.o(38315);
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
        break label794;
      }
      if (bt.isNullOrNil(paramat.field_digestUser)) {
        break label783;
      }
      if ((paramat.field_isSend != 0) || (!w.vF(paramat.field_username))) {
        break label771;
      }
      localObject1 = com.tencent.mm.model.v.getDisplayName(paramat.field_digestUser, paramat.field_username);
    }
    label771:
    label783:
    label794:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramat.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramat.field_atCount <= 0) || (paramat.field_unReadCount <= 0)) {
          break label825;
        }
        paramat = new SpannableStringBuilder(this.context.getString(2131761044));
        paramat.setSpan(new ForegroundColorSpan(-5569532), 0, paramat.length(), 33);
        paramat.append(" ").append(k.b(this.context, str1, paramInt));
        AppMethodBeat.o(38315);
        return paramat;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = com.tencent.mm.model.v.zf(paramat.field_digestUser);
      continue;
      localObject1 = paramat.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramat.field_isSend, paramat.field_username, paramat.field_content, WF(paramat.field_msgType), this.context);
    }
    label825:
    if ((paramBoolean) && (paramat.field_unReadCount > 1)) {
      localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramat.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramat = k.b(this.context, (CharSequence)localObject2, paramInt);
      AppMethodBeat.o(38315);
      return paramat;
      localObject2 = str1;
      if (paramat.field_unReadCount > 0)
      {
        localObject2 = str1;
        if (w.Ad(paramat.field_parentRef))
        {
          localObject2 = str1;
          if (!(this.context instanceof NewBizConversationUI)) {
            localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramat.field_unReadCount), str1 });
          }
        }
      }
    }
  }
  
  private static String aVK(String paramString)
  {
    AppMethodBeat.i(38316);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(paramString);
      AppMethodBeat.o(38316);
      return paramString;
    }
    AppMethodBeat.o(38316);
    return null;
  }
  
  private void bdQ()
  {
    AppMethodBeat.i(38314);
    if (this.JuD != null)
    {
      this.JuD.clear();
      this.JuD = null;
    }
    AppMethodBeat.o(38314);
  }
  
  private void fID()
  {
    AppMethodBeat.i(38308);
    if (this.JuD == null)
    {
      AppMethodBeat.o(38308);
      return;
    }
    Iterator localIterator = this.JuD.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).KsI = null;
    }
    AppMethodBeat.o(38308);
  }
  
  private void fIE()
  {
    AppMethodBeat.i(38319);
    ad.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.KsE), Boolean.valueOf(this.KsF.fkZ()) });
    this.KsE = true;
    if (this.KsF.fkZ()) {
      fIF();
    }
    AppMethodBeat.o(38319);
  }
  
  private void fIF()
  {
    AppMethodBeat.i(38320);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38301);
        if (!com.tencent.mm.model.ba.ajx())
        {
          e.f(e.this).stopTimer();
          ad.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38301);
          return;
        }
        long l = bt.flT();
        e.g(e.this);
        l = bt.Df(l) * 3L;
        ad.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(e.fIG()), Boolean.valueOf(e.d(e.this)) });
        e.En((l + e.fIG()) / 2L);
        e.h(e.this);
        av localav = e.f(e.this);
        l = e.fIG();
        localav.az(l, l);
        AppMethodBeat.o(38301);
      }
    });
    AppMethodBeat.o(38320);
  }
  
  private CharSequence i(at paramat)
  {
    AppMethodBeat.i(38305);
    if (paramat.field_status == 1)
    {
      paramat = this.context.getString(2131761075);
      AppMethodBeat.o(38305);
      return paramat;
    }
    if (paramat.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38305);
      return "";
    }
    paramat = com.tencent.mm.pluginsdk.i.i.c(this.context, paramat.field_conversationTime, true);
    AppMethodBeat.o(38305);
    return paramat;
  }
  
  public void Zu()
  {
    AppMethodBeat.i(38311);
    ad.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.jgw) });
    if (this.jgw)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = com.tencent.mm.model.ba.aBQ().hEl.a(w.hFd, this.fSL, this.jcm);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.fSL != null) && (this.fSL.size() > 0)) {
        localArrayList1.addAll(this.fSL);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!w.vF(str)) {
            localArrayList2.add(str);
          }
          ad.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(str)));
        }
        if (this.Ksr == null) {}
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = com.tencent.mm.model.ba.aBQ().hEm.b(this.jcm, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.jcm != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38311);
      return;
      com.tencent.mm.model.ba.aBQ();
      setCursor(com.tencent.mm.model.c.azv().a(w.hFd, this.fSL, com.tencent.mm.p.a.gfl, false));
    }
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(38306);
    Zu();
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
  
  protected void a(at paramat, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.nUy = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38318);
    ad.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.JuE), Boolean.valueOf(this.JuF), paramString });
    if ((!bt.isNullOrNil(paramString)) && (this.JuD != null)) {
      this.JuD.remove(paramString);
    }
    if (this.JuE)
    {
      fIE();
      AppMethodBeat.o(38318);
      return;
    }
    this.JuF = true;
    AppMethodBeat.o(38318);
  }
  
  protected void a(String paramString, g paramg) {}
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38312);
    at localat = (at)getItem(paramInt);
    String str = localat.field_username;
    paramViewGroup = this.Ksz;
    paramViewGroup.talker = str;
    paramViewGroup.contact = null;
    paramViewGroup.KsV = null;
    paramViewGroup.initialized = false;
    if (!bt.isNullOrNil(str)) {
      paramViewGroup.initialized = true;
    }
    this.KsC = new a((byte)0);
    label152:
    Object localObject1;
    label462:
    Object localObject2;
    am localam;
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
      if (com.tencent.mm.cc.a.im(this.context))
      {
        paramView = View.inflate(this.context, 2131493663, null);
        paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131297008));
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label1909;
        }
        a.b.d(paramViewGroup.fOf, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.fOf.getDrawable();
        if (this.Kss != null) {
          this.Kss.a((com.tencent.mm.pluginsdk.ui.e.a)localObject1);
        }
        paramViewGroup.JuK = ((NoMeasuredTextView)paramView.findViewById(2131302867));
        paramViewGroup.KsW = ((NoMeasuredTextView)paramView.findViewById(2131305134));
        paramViewGroup.JuL = ((NoMeasuredTextView)paramView.findViewById(2131306207));
        paramViewGroup.JuM = ((NoMeasuredTextView)paramView.findViewById(2131301311));
        paramViewGroup.nUD = ((TextView)paramView.findViewById(2131305882));
        paramViewGroup.nUD.setBackgroundResource(com.tencent.mm.ui.tools.u.kE(this.context));
        paramViewGroup.JuN = ((ImageView)paramView.findViewById(2131300954));
        paramViewGroup.JuP = paramView.findViewById(2131297015);
        paramViewGroup.JuO = ((ImageView)paramView.findViewById(2131305672));
        paramViewGroup.KsX = ((ImageView)paramView.findViewById(2131301541));
        paramView.setTag(paramViewGroup);
        paramViewGroup.JuM.setTextSize(0, this.Juz);
        paramViewGroup.JuL.setTextSize(0, this.JuA);
        paramViewGroup.JuK.setTextSize(0, this.Juw);
        paramViewGroup.KsW.setTextSize(0, this.Juz);
        paramViewGroup.JuM.setTextColor(this.JuB[0]);
        paramViewGroup.JuL.setTextColor(this.JuB[4]);
        paramViewGroup.JuK.setTextColor(this.JuB[3]);
        paramViewGroup.KsW.setTextColor(this.JuB[0]);
        paramViewGroup.JuM.setShouldEllipsize(true);
        paramViewGroup.JuL.setShouldEllipsize(false);
        paramViewGroup.JuK.setShouldEllipsize(true);
        paramViewGroup.KsW.setShouldEllipsize(true);
        paramViewGroup.JuL.setGravity(5);
        localObject1 = (d)this.JuD.get(str);
        if (localObject1 != null) {
          break label2682;
        }
        localObject2 = new d((byte)0);
        localObject1 = this.Ksz;
        if ((((e)localObject1).initialized) && (((e)localObject1).contact == null))
        {
          com.tencent.mm.model.ba.aBQ();
          ((e)localObject1).contact = com.tencent.mm.model.c.azp().Bf(((e)localObject1).talker);
        }
        localam = ((e)localObject1).contact;
        if (localam == null) {
          break label1932;
        }
        ((d)localObject2).KsM = localam.ePC;
        ((d)localObject2).KsL = ((int)localam.gfj);
        if (localam == null) {
          break label1947;
        }
        bool = true;
        ((d)localObject2).KsR = bool;
        if ((localam == null) || (!localam.YY())) {
          break label1953;
        }
        bool = true;
        ((d)localObject2).KsT = bool;
        if ((localam == null) || (localam.ePs != 0)) {
          break label1959;
        }
        bool = true;
        ((d)localObject2).KsS = bool;
        ((d)localObject2).ruk = w.vF(str);
        if ((!((d)localObject2).ruk) || (!((d)localObject2).KsS) || (localat.field_unReadCount <= 0)) {
          break label1965;
        }
        bool = true;
        ((d)localObject2).KsQ = bool;
        ((d)localObject2).oIb = 0;
        i = WF(localat.field_msgType);
        if ((i == 34) && (localat.field_isSend == 0) && (!bt.isNullOrNil(localat.field_content)))
        {
          localObject3 = localat.field_content;
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
          if (!new p((String)localObject1).itZ) {
            ((d)localObject2).oIb = 1;
          }
        }
        if (i == 285212721)
        {
          localObject1 = localat.field_content;
          long l = localat.field_lastSeq;
          com.tencent.e.h.LTJ.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38302);
              Object localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(0L, this.ilu);
              if ((localObject == null) || (((com.tencent.mm.ai.u)localObject).hDb.size() == 0))
              {
                AppMethodBeat.o(38302);
                return;
              }
              localObject = (com.tencent.mm.ai.v)((com.tencent.mm.ai.u)localObject).hDb.getFirst();
              if (!TextUtils.isEmpty(((com.tencent.mm.ai.v)localObject).url))
              {
                ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((com.tencent.mm.ai.v)localObject).url, ((com.tencent.mm.ai.v)localObject).type, 92, new Object[0]);
                ad.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", new Object[] { ((com.tencent.mm.ai.v)localObject).title });
              }
              AppMethodBeat.o(38302);
            }
          }, "tmplPreload");
        }
        localObject1 = com.tencent.mm.model.v.a(localam, str, ((d)localObject2).ruk);
        if ((!((d)localObject2).ruk) || (localObject1 != null)) {
          break label1971;
        }
        ((d)localObject2).nickName = this.context.getString(2131757293);
        label931:
        ((d)localObject2).KsI = i(localat);
        ((d)localObject2).KsJ = a(localat, (int)paramViewGroup.JuM.getTextSize(), ((d)localObject2).KsQ);
        ((d)localObject2).KsU = localat.field_attrflag;
        switch (localat.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label1023:
          ((d)localObject2).KsK = i;
          ((d)localObject2).KsN = w.a(localat);
          com.tencent.mm.model.ba.aBQ();
          ((d)localObject2).JuH = com.tencent.mm.model.c.azv().h(localat);
          if ((localam != null) && (localam.Pf()))
          {
            bool = true;
            label1075:
            ((d)localObject2).KsO = bool;
            ((d)localObject2).KsP = ac.fko();
            this.JuD.put(str, localObject2);
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
      if (((d)localObject1).KsI == null) {
        ((d)localObject1).KsI = i(localat);
      }
      if ((((d)localObject1).KsQ) || (w.Ad(localat.field_parentRef)))
      {
        paramViewGroup.JuM.setTextColor(this.JuB[0]);
        com.tencent.mm.booter.notification.a.h.kY(paramViewGroup.JuM.getWidth());
        com.tencent.mm.booter.notification.a.h.kZ((int)paramViewGroup.JuM.getTextSize());
        com.tencent.mm.booter.notification.a.h.b(paramViewGroup.JuM.getPaint());
        if (!str.toLowerCase().endsWith("@t.qq.com")) {
          break label2059;
        }
        paramViewGroup.JuK.setCompoundRightDrawablesWithIntrinsicBounds(2131232700);
        paramViewGroup.JuK.setDrawRightDrawable(true);
        i = ((d)localObject1).KsK;
        if (i == -1) {
          break label2070;
        }
        paramViewGroup.JuM.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        paramViewGroup.JuM.setDrawLeftDrawable(true);
        paramViewGroup.KsW.setVisibility(8);
        localObject2 = paramViewGroup.JuL.getLayoutParams();
        if (((d)localObject1).KsI.length() < 9) {
          break label2081;
        }
        if (((ViewGroup.LayoutParams)localObject2).width != this.KsB)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.KsB;
          paramViewGroup.JuL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        ad.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
        paramViewGroup.JuL.setText(((d)localObject1).KsI);
        paramViewGroup.JuM.setText(((d)localObject1).KsJ);
        if ((!((d)localObject1).ruk) || (!((d)localObject1).KsS)) {
          break label2114;
        }
        paramViewGroup.JuN.setVisibility(0);
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label2145;
        }
        a.b.d(paramViewGroup.fOf, str);
        if (this.Ksq)
        {
          if ((localat != null) && (paramViewGroup != null) && (localObject1 != null)) {
            break label2157;
          }
          ad.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        if ((!((d)localObject1).KsN) && (((d)localObject1).JuH) && (com.tencent.mm.model.ba.ajx()))
        {
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().g(localat);
        }
        if ((!(this.context instanceof NewBizConversationUI)) || (!((d)localObject1).JuH) || (localat.field_conversationTime == -1L)) {
          break label2569;
        }
        localObject2 = this.context.getResources().getDrawable(2131231289);
        i = (int)paramViewGroup.JuK.getTextSize();
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
        localObject3 = new SpannableString("@");
        ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
        paramViewGroup.JuK.setText(TextUtils.concat(new CharSequence[] { ((d)localObject1).nickName, " ", localObject3 }));
        paramView.findViewById(2131298792).setBackgroundResource(2131231818);
        com.tencent.mm.bs.d.ffH();
        localObject2 = new wm();
        ((wm)localObject2).dKN.dKP = true;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localat, 7, 0L)) && (!localat.field_username.equals(((wm)localObject2).dKO.dKR)))
        {
          localat.qv(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localat, 6, localat.field_conversationTime));
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().a(localat, localat.field_username);
        }
        if ((com.tencent.mm.bi.g.irs != null) && (com.tencent.mm.bi.g.irs.GH(localat.field_username))) {
          break label2617;
        }
        paramViewGroup.JuO.setVisibility(8);
        if ((com.tencent.mm.bj.d.iru == null) || (!com.tencent.mm.bj.d.iru.GK(localat.field_username))) {
          break label2670;
        }
        paramViewGroup.KsX.setVisibility(0);
      }
      for (;;)
      {
        this.KsC.content = String.valueOf(((d)localObject1).KsJ);
        this.KsC.bVF = String.valueOf(((d)localObject1).nickName);
        this.KsC.time = String.valueOf(((d)localObject1).KsI);
        localObject2 = this.KsC;
        a.a.fyf().a(paramView, ((a)localObject2).bVF, ((a)localObject2).KsH, ((a)localObject2).time, ((a)localObject2).content);
        a(str, paramViewGroup);
        a(localat, ((d)localObject1).JuH, paramInt, false);
        AppMethodBeat.o(38312);
        return paramView;
        paramView = View.inflate(this.context, 2131493662, null);
        break;
        a.b.c(paramViewGroup.fOf, str);
        break label152;
        paramViewGroup = (g)paramView.getTag();
        break label462;
        ((d)localObject2).KsM = -1;
        ((d)localObject2).KsL = -1;
        break label569;
        bool = false;
        break label577;
        bool = false;
        break label600;
        bool = false;
        break label623;
        bool = false;
        break label667;
        ((d)localObject2).nickName = k.b(this.context, com.tencent.mm.model.v.a(localam, str, ((d)localObject2).ruk), paramViewGroup.JuK.getTextSize());
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
        paramViewGroup.JuM.setTextColor(this.JuB[localObject1.oIb]);
        break label1157;
        paramViewGroup.JuK.setDrawRightDrawable(false);
        break label1220;
        paramViewGroup.JuM.setDrawLeftDrawable(false);
        break label1250;
        if (((ViewGroup.LayoutParams)localObject2).width == this.KsA) {
          break label1313;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.KsA;
        paramViewGroup.JuL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1313;
        if (((d)localObject1).KsO)
        {
          paramViewGroup.JuN.setVisibility(0);
          break label1385;
        }
        paramViewGroup.JuN.setVisibility(8);
        break label1385;
        a.b.c(paramViewGroup.fOf, str);
        break label1414;
        paramViewGroup.nUD.setVisibility(4);
        paramViewGroup.JuP.setVisibility(4);
        if (w.Ad(localat.field_username))
        {
          localObject2 = paramViewGroup.JuP;
          if (localat.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            paramViewGroup.JuK.setTextColor(this.JuB[3]);
            break;
          }
        }
        localObject3 = paramViewGroup.JuK;
        if ((((d)localObject1).KsR) && (((d)localObject1).KsM == 1)) {}
        for (localObject2 = this.JuB[2];; localObject2 = this.JuB[3])
        {
          ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
          if ((((d)localObject1).KsR) && (((d)localObject1).KsL != 0)) {
            break label2307;
          }
          ad.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (w.Ad(localat.field_parentRef))
        {
          if ((this.context instanceof NewBizConversationUI)) {
            break label1444;
          }
          localObject2 = paramViewGroup.JuP;
          if (localat.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).KsO) && (((d)localObject1).KsT))
        {
          localObject2 = paramViewGroup.JuP;
          if (localat.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).ruk) && (((d)localObject1).KsS))
        {
          localObject2 = paramViewGroup.JuP;
          if (localat.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        i = localat.field_unReadCount;
        if (i > 99)
        {
          paramViewGroup.nUD.setText("");
          paramViewGroup.nUD.setBackgroundResource(2131689744);
          paramViewGroup.nUD.setVisibility(0);
        }
        for (;;)
        {
          this.KsC.KsH = i;
          break;
          if (i > 0)
          {
            paramViewGroup.nUD.setText(localat.field_unReadCount);
            paramViewGroup.nUD.setBackgroundResource(com.tencent.mm.ui.tools.u.aP(this.context, i));
            paramViewGroup.nUD.setVisibility(0);
          }
        }
        paramViewGroup.JuK.setText(((d)localObject1).nickName);
        if ((!((d)localObject1).JuH) || (localat.field_conversationTime == -1L)) {
          break label1614;
        }
        paramView.findViewById(2131298792).setBackgroundResource(2131231817);
        break label1627;
        paramViewGroup.JuO.setVisibility(0);
        if (localat.field_username.equals(((wm)localObject2).dKO.dKR))
        {
          paramViewGroup.JuO.setImageResource(2131691273);
          break label1758;
        }
        paramViewGroup.JuO.setImageResource(2131691272);
        break label1758;
        paramViewGroup.KsX.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(38310);
    this.KsF.stopTimer();
    this.Ksx = null;
    this.Ksv = null;
    bdQ();
    det();
    fvg();
    detach();
    AppMethodBeat.o(38310);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38307);
    if (this.nUz != null) {
      this.nUz.deC();
    }
    this.JuE = false;
    AppMethodBeat.o(38307);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38309);
    ad.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.JuE), Boolean.valueOf(this.Kst), Boolean.valueOf(this.JuF), Boolean.valueOf(this.Ksu) });
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
      if ((this.Kst) && (this.Ksx != null)) {
        this.Kst = false;
      }
      if ((this.JuF) || (this.Ksu))
      {
        super.a(null, null);
        this.JuF = false;
        this.Ksu = false;
      }
      AppMethodBeat.o(38309);
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
    public int KsH;
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
        ad.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
        AppMethodBeat.o(38303);
        return;
      }
      paramn = (String)paramObject;
      if (e.a(this.KsG))
      {
        AppMethodBeat.o(38303);
        return;
      }
      if ((paramn != null) && (!paramn.equals("")) && (e.b(this.KsG) != null) && (e.b(this.KsG).containsKey(Integer.valueOf(paramInt))))
      {
        e.b(this.KsG).remove(Integer.valueOf(paramInt));
        e.c(this.KsG);
      }
      AppMethodBeat.o(38303);
    }
  }
  
  final class d
  {
    public boolean JuH;
    public CharSequence KsI;
    public CharSequence KsJ;
    public int KsK;
    public int KsL;
    public int KsM;
    public boolean KsN;
    public boolean KsO;
    public boolean KsP;
    public boolean KsQ;
    public boolean KsR;
    public boolean KsS;
    public boolean KsT;
    public int KsU;
    public CharSequence nickName;
    public int oIb;
    public boolean ruk;
    
    private d() {}
  }
  
  final class e
  {
    Integer KsV = null;
    am contact = null;
    boolean initialized = false;
    String talker = null;
    
    public e() {}
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public NoMeasuredTextView JuK;
    public NoMeasuredTextView JuL;
    public NoMeasuredTextView JuM;
    public ImageView JuN;
    public ImageView JuO;
    public View JuP;
    public NoMeasuredTextView KsW;
    public ImageView KsX;
    public ImageView fOf;
    public TextView nUD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */