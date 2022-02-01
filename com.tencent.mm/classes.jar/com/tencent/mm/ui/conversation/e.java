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
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends r<com.tencent.mm.storage.ap>
  implements n.b
{
  private static long IBx = 2000L;
  private float HGF;
  protected float HGI;
  private float HGJ;
  private ColorStateList[] HGK;
  HashMap<String, d> HGM;
  private boolean HGN;
  private boolean HGO;
  private boolean IBk;
  private f IBl;
  private com.tencent.mm.pluginsdk.ui.d IBm;
  private boolean IBn;
  private boolean IBo;
  private c IBp;
  private com.tencent.mm.sdk.b.c IBq;
  private b IBr;
  public String IBs;
  final e IBt;
  private final int IBu;
  private final int IBv;
  private a IBw;
  private boolean IBy;
  private au IBz;
  protected List<String> fzw;
  private String iJd;
  private boolean iNn;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.f ntC;
  protected MMSlideDelView.d ntD;
  boolean yzE;
  
  public e(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.storage.ap());
    AppMethodBeat.i(38304);
    this.fzw = null;
    this.HGK = new ColorStateList[5];
    this.IBk = true;
    this.iNn = false;
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    this.HGF = -1.0F;
    this.HGI = -1.0F;
    this.HGJ = -1.0F;
    this.HGN = false;
    this.HGO = false;
    this.IBn = false;
    this.IBo = false;
    this.IBq = null;
    this.IBr = null;
    this.IBs = "";
    this.IBt = new e();
    this.yzE = false;
    this.IBy = false;
    this.IBz = new au(com.tencent.mm.model.az.agU().GrZ.getLooper(), new au.a()
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
    this.HGK[0] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
    this.HGK[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
    this.HGK[3] = com.tencent.mm.cc.a.m(paramContext, 2131100711);
    this.HGK[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
    this.HGK[2] = com.tencent.mm.cc.a.m(paramContext, 2131100640);
    this.HGK[4] = com.tencent.mm.cc.a.m(paramContext, 2131100543);
    this.HGM = new HashMap();
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
      AppMethodBeat.o(38304);
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
  
  private static int Tf(String paramString)
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
  
  private CharSequence a(com.tencent.mm.storage.ap paramap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38315);
    if ((!bs.isNullOrNil(paramap.field_editingMsg)) && ((paramap.field_atCount <= 0) || (paramap.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramap.field_editingMsg, paramInt));
      AppMethodBeat.o(38315);
      return localObject1;
    }
    Object localObject1 = paramap.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramap = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38315);
      return paramap;
    }
    localObject1 = paramap.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      com.tencent.mm.model.az.ayM();
      if (bs.m((Integer)com.tencent.mm.model.c.agA().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramap = this.context.getString(2131763356);
        AppMethodBeat.o(38315);
        return paramap;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      com.tencent.mm.model.az.ayM();
      localObject1 = com.tencent.mm.model.c.awJ().alJ("@t.qq.com");
      if ((localObject1 != null) && (((com.tencent.mm.storage.bu)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramap = this.context.getString(2131763356);
        AppMethodBeat.o(38315);
        return paramap;
      }
    }
    String str1;
    if ((paramap.field_msgType != null) && ((paramap.field_msgType.equals("47")) || (paramap.field_msgType.equals("1048625"))))
    {
      localObject1 = aPU(paramap.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramap = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38315);
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
              AppMethodBeat.o(38315);
              return paramap;
            }
            paramap = str1 + ": " + paramap;
            AppMethodBeat.o(38315);
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
        break label794;
      }
      if (bs.isNullOrNil(paramap.field_digestUser)) {
        break label783;
      }
      if ((paramap.field_isSend != 0) || (!w.sQ(paramap.field_username))) {
        break label771;
      }
      localObject1 = com.tencent.mm.model.v.getDisplayName(paramap.field_digestUser, paramap.field_username);
    }
    label771:
    label783:
    label794:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramap.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramap.field_atCount <= 0) || (paramap.field_unReadCount <= 0)) {
          break label825;
        }
        paramap = new SpannableStringBuilder(this.context.getString(2131761044));
        paramap.setSpan(new ForegroundColorSpan(-5569532), 0, paramap.length(), 33);
        paramap.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str1, paramInt));
        AppMethodBeat.o(38315);
        return paramap;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = com.tencent.mm.model.v.wk(paramap.field_digestUser);
      continue;
      localObject1 = paramap.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramap.field_isSend, paramap.field_username, paramap.field_content, Tf(paramap.field_msgType), this.context);
    }
    label825:
    if ((paramBoolean) && (paramap.field_unReadCount > 1)) {
      localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramap.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramap = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramInt);
      AppMethodBeat.o(38315);
      return paramap;
      localObject2 = str1;
      if (paramap.field_unReadCount > 0)
      {
        localObject2 = str1;
        if (w.xg(paramap.field_parentRef))
        {
          localObject2 = str1;
          if (!(this.context instanceof NewBizConversationUI)) {
            localObject2 = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramap.field_unReadCount), str1 });
          }
        }
      }
    }
  }
  
  private static String aPU(String paramString)
  {
    AppMethodBeat.i(38316);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(paramString);
      AppMethodBeat.o(38316);
      return paramString;
    }
    AppMethodBeat.o(38316);
    return null;
  }
  
  private void baq()
  {
    AppMethodBeat.i(38314);
    if (this.HGM != null)
    {
      this.HGM.clear();
      this.HGM = null;
    }
    AppMethodBeat.o(38314);
  }
  
  private void frO()
  {
    AppMethodBeat.i(38308);
    if (this.HGM == null)
    {
      AppMethodBeat.o(38308);
      return;
    }
    Iterator localIterator = this.HGM.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).IBC = null;
    }
    AppMethodBeat.o(38308);
  }
  
  private void frP()
  {
    AppMethodBeat.i(38319);
    ac.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.IBy), Boolean.valueOf(this.IBz.eVs()) });
    this.IBy = true;
    if (this.IBz.eVs()) {
      frQ();
    }
    AppMethodBeat.o(38319);
  }
  
  private void frQ()
  {
    AppMethodBeat.i(38320);
    com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38301);
        if (!com.tencent.mm.model.az.agM())
        {
          e.f(e.this).stopTimer();
          ac.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38301);
          return;
        }
        long l = bs.eWj();
        e.g(e.this);
        l = bs.Ap(l) * 3L;
        ac.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(e.frR()), Boolean.valueOf(e.d(e.this)) });
        e.Bv((l + e.frR()) / 2L);
        e.h(e.this);
        au localau = e.f(e.this);
        l = e.frR();
        localau.au(l, l);
        AppMethodBeat.o(38301);
      }
    });
    AppMethodBeat.o(38320);
  }
  
  private CharSequence i(com.tencent.mm.storage.ap paramap)
  {
    AppMethodBeat.i(38305);
    if (paramap.field_status == 1)
    {
      paramap = this.context.getString(2131761075);
      AppMethodBeat.o(38305);
      return paramap;
    }
    if (paramap.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38305);
      return "";
    }
    paramap = com.tencent.mm.pluginsdk.g.h.c(this.context, paramap.field_conversationTime, true);
    AppMethodBeat.o(38305);
    return paramap;
  }
  
  public void Xb()
  {
    AppMethodBeat.i(38311);
    ac.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.iNn) });
    if (this.iNn)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = com.tencent.mm.model.az.ayM().hlY.b(w.hmN, this.fzw, this.iJd);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.fzw != null) && (this.fzw.size() > 0)) {
        localArrayList1.addAll(this.fzw);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!w.sQ(str)) {
            localArrayList2.add(str);
          }
          ac.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(str)));
        }
        if (this.IBl == null) {}
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = com.tencent.mm.model.az.ayM().hlZ.b(this.iJd, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.iJd != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38311);
      return;
      com.tencent.mm.model.az.ayM();
      setCursor(com.tencent.mm.model.c.awG().a(w.hmN, this.fzw, com.tencent.mm.o.a.fLL, false));
    }
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(38306);
    Xb();
    AppMethodBeat.o(38306);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38317);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38317);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(38317);
  }
  
  protected void a(com.tencent.mm.storage.ap paramap, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.ntC = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(38318);
    ac.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.HGN), Boolean.valueOf(this.HGO), paramString });
    if ((!bs.isNullOrNil(paramString)) && (this.HGM != null)) {
      this.HGM.remove(paramString);
    }
    if (this.HGN)
    {
      frP();
      AppMethodBeat.o(38318);
      return;
    }
    this.HGO = true;
    AppMethodBeat.o(38318);
  }
  
  protected void a(String paramString, g paramg) {}
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38312);
    com.tencent.mm.storage.ap localap = (com.tencent.mm.storage.ap)getItem(paramInt);
    String str = localap.field_username;
    paramViewGroup = this.IBt;
    paramViewGroup.talker = str;
    paramViewGroup.contact = null;
    paramViewGroup.IBP = null;
    paramViewGroup.initialized = false;
    if (!bs.isNullOrNil(str)) {
      paramViewGroup.initialized = true;
    }
    this.IBw = new a((byte)0);
    label152:
    Object localObject1;
    label462:
    Object localObject2;
    ai localai;
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
      if (com.tencent.mm.cc.a.id(this.context))
      {
        paramView = View.inflate(this.context, 2131493663, null);
        paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131297008));
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label1909;
        }
        a.b.d(paramViewGroup.fuY, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.fuY.getDrawable();
        if (this.IBm != null) {
          this.IBm.a((d.a)localObject1);
        }
        paramViewGroup.HGT = ((NoMeasuredTextView)paramView.findViewById(2131302867));
        paramViewGroup.IBQ = ((NoMeasuredTextView)paramView.findViewById(2131305134));
        paramViewGroup.HGU = ((NoMeasuredTextView)paramView.findViewById(2131306207));
        paramViewGroup.HGV = ((NoMeasuredTextView)paramView.findViewById(2131301311));
        paramViewGroup.ntH = ((TextView)paramView.findViewById(2131305882));
        paramViewGroup.ntH.setBackgroundResource(com.tencent.mm.ui.tools.u.ks(this.context));
        paramViewGroup.HGW = ((ImageView)paramView.findViewById(2131300954));
        paramViewGroup.HGY = paramView.findViewById(2131297015);
        paramViewGroup.HGX = ((ImageView)paramView.findViewById(2131305672));
        paramViewGroup.IBR = ((ImageView)paramView.findViewById(2131301541));
        paramView.setTag(paramViewGroup);
        paramViewGroup.HGV.setTextSize(0, this.HGI);
        paramViewGroup.HGU.setTextSize(0, this.HGJ);
        paramViewGroup.HGT.setTextSize(0, this.HGF);
        paramViewGroup.IBQ.setTextSize(0, this.HGI);
        paramViewGroup.HGV.setTextColor(this.HGK[0]);
        paramViewGroup.HGU.setTextColor(this.HGK[4]);
        paramViewGroup.HGT.setTextColor(this.HGK[3]);
        paramViewGroup.IBQ.setTextColor(this.HGK[0]);
        paramViewGroup.HGV.setShouldEllipsize(true);
        paramViewGroup.HGU.setShouldEllipsize(false);
        paramViewGroup.HGT.setShouldEllipsize(true);
        paramViewGroup.IBQ.setShouldEllipsize(true);
        paramViewGroup.HGU.setGravity(5);
        localObject1 = (d)this.HGM.get(str);
        if (localObject1 != null) {
          break label2682;
        }
        localObject2 = new d((byte)0);
        localObject1 = this.IBt;
        if ((((e)localObject1).initialized) && (((e)localObject1).contact == null))
        {
          com.tencent.mm.model.az.ayM();
          ((e)localObject1).contact = com.tencent.mm.model.c.awB().aNt(((e)localObject1).talker);
        }
        localai = ((e)localObject1).contact;
        if (localai == null) {
          break label1932;
        }
        ((d)localObject2).IBG = localai.eyd;
        ((d)localObject2).IBF = ((int)localai.fLJ);
        if (localai == null) {
          break label1947;
        }
        bool = true;
        ((d)localObject2).IBL = bool;
        if ((localai == null) || (!localai.WE())) {
          break label1953;
        }
        bool = true;
        ((d)localObject2).IBN = bool;
        if ((localai == null) || (localai.exT != 0)) {
          break label1959;
        }
        bool = true;
        ((d)localObject2).IBM = bool;
        ((d)localObject2).qKi = w.sQ(str);
        if ((!((d)localObject2).qKi) || (!((d)localObject2).IBM) || (localap.field_unReadCount <= 0)) {
          break label1965;
        }
        bool = true;
        ((d)localObject2).IBK = bool;
        ((d)localObject2).oeH = 0;
        i = Tf(localap.field_msgType);
        if ((i == 34) && (localap.field_isSend == 0) && (!bs.isNullOrNil(localap.field_content)))
        {
          localObject3 = localap.field_content;
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
          if (!new p((String)localObject1).iaD) {
            ((d)localObject2).oeH = 1;
          }
        }
        if (i == 285212721)
        {
          localObject1 = localap.field_content;
          long l = localap.field_lastSeq;
          com.tencent.e.h.JZN.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38302);
              Object localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(0L, this.hSd);
              if ((localObject == null) || (((com.tencent.mm.ah.u)localObject).hkS.size() == 0))
              {
                AppMethodBeat.o(38302);
                return;
              }
              localObject = (com.tencent.mm.ah.v)((com.tencent.mm.ah.u)localObject).hkS.getFirst();
              if (!TextUtils.isEmpty(((com.tencent.mm.ah.v)localObject).url))
              {
                ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((com.tencent.mm.ah.v)localObject).url, ((com.tencent.mm.ah.v)localObject).type, 92, new Object[0]);
                ac.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", new Object[] { ((com.tencent.mm.ah.v)localObject).title });
              }
              AppMethodBeat.o(38302);
            }
          }, "tmplPreload");
        }
        localObject1 = com.tencent.mm.model.v.a(localai, str, ((d)localObject2).qKi);
        if ((!((d)localObject2).qKi) || (localObject1 != null)) {
          break label1971;
        }
        ((d)localObject2).nickName = this.context.getString(2131757293);
        label931:
        ((d)localObject2).IBC = i(localap);
        ((d)localObject2).IBD = a(localap, (int)paramViewGroup.HGV.getTextSize(), ((d)localObject2).IBK);
        ((d)localObject2).IBO = localap.field_attrflag;
        switch (localap.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label1023:
          ((d)localObject2).IBE = i;
          ((d)localObject2).IBH = w.a(localap);
          com.tencent.mm.model.az.ayM();
          ((d)localObject2).HGQ = com.tencent.mm.model.c.awG().h(localap);
          if ((localai != null) && (localai.Nw()))
          {
            bool = true;
            label1075:
            ((d)localObject2).IBI = bool;
            ((d)localObject2).IBJ = ab.eUK();
            this.HGM.put(str, localObject2);
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
      if (((d)localObject1).IBC == null) {
        ((d)localObject1).IBC = i(localap);
      }
      if ((((d)localObject1).IBK) || (w.xg(localap.field_parentRef)))
      {
        paramViewGroup.HGV.setTextColor(this.HGK[0]);
        com.tencent.mm.booter.notification.a.h.kB(paramViewGroup.HGV.getWidth());
        com.tencent.mm.booter.notification.a.h.kC((int)paramViewGroup.HGV.getTextSize());
        com.tencent.mm.booter.notification.a.h.b(paramViewGroup.HGV.getPaint());
        if (!str.toLowerCase().endsWith("@t.qq.com")) {
          break label2059;
        }
        paramViewGroup.HGT.setCompoundRightDrawablesWithIntrinsicBounds(2131232700);
        paramViewGroup.HGT.setDrawRightDrawable(true);
        i = ((d)localObject1).IBE;
        if (i == -1) {
          break label2070;
        }
        paramViewGroup.HGV.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        paramViewGroup.HGV.setDrawLeftDrawable(true);
        paramViewGroup.IBQ.setVisibility(8);
        localObject2 = paramViewGroup.HGU.getLayoutParams();
        if (((d)localObject1).IBC.length() < 9) {
          break label2081;
        }
        if (((ViewGroup.LayoutParams)localObject2).width != this.IBv)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.IBv;
          paramViewGroup.HGU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        ac.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
        paramViewGroup.HGU.setText(((d)localObject1).IBC);
        paramViewGroup.HGV.setText(((d)localObject1).IBD);
        if ((!((d)localObject1).qKi) || (!((d)localObject1).IBM)) {
          break label2114;
        }
        paramViewGroup.HGW.setVisibility(0);
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label2145;
        }
        a.b.d(paramViewGroup.fuY, str);
        if (this.IBk)
        {
          if ((localap != null) && (paramViewGroup != null) && (localObject1 != null)) {
            break label2157;
          }
          ac.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        if ((!((d)localObject1).IBH) && (((d)localObject1).HGQ) && (com.tencent.mm.model.az.agM()))
        {
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().g(localap);
        }
        if ((!(this.context instanceof NewBizConversationUI)) || (!((d)localObject1).HGQ) || (localap.field_conversationTime == -1L)) {
          break label2569;
        }
        localObject2 = this.context.getResources().getDrawable(2131231289);
        i = (int)paramViewGroup.HGT.getTextSize();
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
        localObject3 = new SpannableString("@");
        ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
        paramViewGroup.HGT.setText(TextUtils.concat(new CharSequence[] { ((d)localObject1).nickName, " ", localObject3 }));
        paramView.findViewById(2131298792).setBackgroundResource(2131231818);
        com.tencent.mm.br.d.eQD();
        localObject2 = new vt();
        ((vt)localObject2).dyB.dyD = true;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localap, 7, 0L)) && (!localap.field_username.equals(((vt)localObject2).dyC.dyF)))
        {
          localap.ov(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localap, 6, localap.field_conversationTime));
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().a(localap, localap.field_username);
        }
        if ((com.tencent.mm.bh.g.hXW != null) && (com.tencent.mm.bh.g.hXW.DC(localap.field_username))) {
          break label2617;
        }
        paramViewGroup.HGX.setVisibility(8);
        if ((com.tencent.mm.bi.d.hXY == null) || (!com.tencent.mm.bi.d.hXY.DF(localap.field_username))) {
          break label2670;
        }
        paramViewGroup.IBR.setVisibility(0);
      }
      for (;;)
      {
        this.IBw.content = String.valueOf(((d)localObject1).IBD);
        this.IBw.bLs = String.valueOf(((d)localObject1).nickName);
        this.IBw.time = String.valueOf(((d)localObject1).IBC);
        localObject2 = this.IBw;
        a.a.fhP().a(paramView, ((a)localObject2).bLs, ((a)localObject2).IBB, ((a)localObject2).time, ((a)localObject2).content);
        a(str, paramViewGroup);
        a(localap, ((d)localObject1).HGQ, paramInt, false);
        AppMethodBeat.o(38312);
        return paramView;
        paramView = View.inflate(this.context, 2131493662, null);
        break;
        a.b.c(paramViewGroup.fuY, str);
        break label152;
        paramViewGroup = (g)paramView.getTag();
        break label462;
        ((d)localObject2).IBG = -1;
        ((d)localObject2).IBF = -1;
        break label569;
        bool = false;
        break label577;
        bool = false;
        break label600;
        bool = false;
        break label623;
        bool = false;
        break label667;
        ((d)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, com.tencent.mm.model.v.a(localai, str, ((d)localObject2).qKi), paramViewGroup.HGT.getTextSize());
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
        paramViewGroup.HGV.setTextColor(this.HGK[localObject1.oeH]);
        break label1157;
        paramViewGroup.HGT.setDrawRightDrawable(false);
        break label1220;
        paramViewGroup.HGV.setDrawLeftDrawable(false);
        break label1250;
        if (((ViewGroup.LayoutParams)localObject2).width == this.IBu) {
          break label1313;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.IBu;
        paramViewGroup.HGU.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1313;
        if (((d)localObject1).IBI)
        {
          paramViewGroup.HGW.setVisibility(0);
          break label1385;
        }
        paramViewGroup.HGW.setVisibility(8);
        break label1385;
        a.b.c(paramViewGroup.fuY, str);
        break label1414;
        paramViewGroup.ntH.setVisibility(4);
        paramViewGroup.HGY.setVisibility(4);
        if (w.xg(localap.field_username))
        {
          localObject2 = paramViewGroup.HGY;
          if (localap.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            paramViewGroup.HGT.setTextColor(this.HGK[3]);
            break;
          }
        }
        localObject3 = paramViewGroup.HGT;
        if ((((d)localObject1).IBL) && (((d)localObject1).IBG == 1)) {}
        for (localObject2 = this.HGK[2];; localObject2 = this.HGK[3])
        {
          ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
          if ((((d)localObject1).IBL) && (((d)localObject1).IBF != 0)) {
            break label2307;
          }
          ac.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (w.xg(localap.field_parentRef))
        {
          if ((this.context instanceof NewBizConversationUI)) {
            break label1444;
          }
          localObject2 = paramViewGroup.HGY;
          if (localap.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).IBI) && (((d)localObject1).IBN))
        {
          localObject2 = paramViewGroup.HGY;
          if (localap.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).qKi) && (((d)localObject1).IBM))
        {
          localObject2 = paramViewGroup.HGY;
          if (localap.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        i = localap.field_unReadCount;
        if (i > 99)
        {
          paramViewGroup.ntH.setText("");
          paramViewGroup.ntH.setBackgroundResource(2131689744);
          paramViewGroup.ntH.setVisibility(0);
        }
        for (;;)
        {
          this.IBw.IBB = i;
          break;
          if (i > 0)
          {
            paramViewGroup.ntH.setText(localap.field_unReadCount);
            paramViewGroup.ntH.setBackgroundResource(com.tencent.mm.ui.tools.u.aM(this.context, i));
            paramViewGroup.ntH.setVisibility(0);
          }
        }
        paramViewGroup.HGT.setText(((d)localObject1).nickName);
        if ((!((d)localObject1).HGQ) || (localap.field_conversationTime == -1L)) {
          break label1614;
        }
        paramView.findViewById(2131298792).setBackgroundResource(2131231817);
        break label1627;
        paramViewGroup.HGX.setVisibility(0);
        if (localap.field_username.equals(((vt)localObject2).dyC.dyF))
        {
          paramViewGroup.HGX.setImageResource(2131691273);
          break label1758;
        }
        paramViewGroup.HGX.setImageResource(2131691272);
        break label1758;
        paramViewGroup.IBR.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(38310);
    this.IBz.stopTimer();
    this.IBr = null;
    this.IBp = null;
    baq();
    cVi();
    feY();
    detach();
    AppMethodBeat.o(38310);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38307);
    if (this.ntD != null) {
      this.ntD.cVr();
    }
    this.HGN = false;
    AppMethodBeat.o(38307);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38309);
    ac.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.HGN), Boolean.valueOf(this.IBn), Boolean.valueOf(this.HGO), Boolean.valueOf(this.IBo) });
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
      if ((this.IBn) && (this.IBr != null)) {
        this.IBn = false;
      }
      if ((this.HGO) || (this.IBo))
      {
        super.a(null, null);
        this.HGO = false;
        this.IBo = false;
      }
      AppMethodBeat.o(38309);
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
    public int IBB;
    public String bLs;
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
        ac.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
        AppMethodBeat.o(38303);
        return;
      }
      paramn = (String)paramObject;
      if (e.a(this.IBA))
      {
        AppMethodBeat.o(38303);
        return;
      }
      if ((paramn != null) && (!paramn.equals("")) && (e.b(this.IBA) != null) && (e.b(this.IBA).containsKey(Integer.valueOf(paramInt))))
      {
        e.b(this.IBA).remove(Integer.valueOf(paramInt));
        e.c(this.IBA);
      }
      AppMethodBeat.o(38303);
    }
  }
  
  final class d
  {
    public boolean HGQ;
    public CharSequence IBC;
    public CharSequence IBD;
    public int IBE;
    public int IBF;
    public int IBG;
    public boolean IBH;
    public boolean IBI;
    public boolean IBJ;
    public boolean IBK;
    public boolean IBL;
    public boolean IBM;
    public boolean IBN;
    public int IBO;
    public CharSequence nickName;
    public int oeH;
    public boolean qKi;
    
    private d() {}
  }
  
  final class e
  {
    Integer IBP = null;
    ai contact = null;
    boolean initialized = false;
    String talker = null;
    
    public e() {}
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public NoMeasuredTextView HGT;
    public NoMeasuredTextView HGU;
    public NoMeasuredTextView HGV;
    public ImageView HGW;
    public ImageView HGX;
    public View HGY;
    public NoMeasuredTextView IBQ;
    public ImageView IBR;
    public ImageView fuY;
    public TextView ntH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */