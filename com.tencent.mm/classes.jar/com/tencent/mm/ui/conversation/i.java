package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Pair;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.tools.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class i
  extends com.tencent.mm.ui.f<String, au>
  implements n.b
{
  boolean Aic;
  k.a JAv;
  private float JPl;
  private float JPo;
  private float JPp;
  private ColorStateList[] JPq;
  HashMap<String, d> JPs;
  private boolean KOK;
  com.tencent.mm.pluginsdk.ui.e KOM;
  private boolean KON;
  com.tencent.mm.sdk.b.c KOQ;
  public String KOS;
  private final int KOU;
  private final int KOV;
  private boolean KRb;
  private wq KRc;
  b KRd;
  private HashSet<String> KRe;
  private boolean KRf;
  HashMap<String, Integer> KRg;
  private HashMap<String, Integer> KRh;
  private boolean KRi;
  HashSet<String> KRj;
  boolean KRk;
  private boolean KRl;
  private boolean KRm;
  private NoMeasuredTextView.c KRn;
  public String KRo;
  private String KRp;
  private ColorDrawable KRq;
  ValueAnimator KRr;
  final e KRs;
  private float KRt;
  private a KRu;
  private long KRv;
  private boolean KRw;
  boolean KRx;
  public boolean Kbw;
  protected List<String> fUR;
  private boolean jjp;
  private ListView mListView;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.d oaf;
  boolean vpK;
  
  public i(Context paramContext, ListView paramListView, f.a parama)
  {
    super(paramContext, (short)0);
    AppMethodBeat.i(38494);
    this.fUR = null;
    this.JPq = new ColorStateList[5];
    this.KOK = true;
    this.KRb = false;
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    this.KRc = null;
    this.jjp = false;
    this.JPl = -1.0F;
    this.JPo = -1.0F;
    this.JPp = -1.0F;
    this.KON = false;
    this.KOQ = null;
    this.KRd = null;
    this.Kbw = false;
    this.KRf = false;
    this.KRg = new HashMap();
    this.KRh = new HashMap();
    this.KRi = false;
    this.KRk = false;
    this.KRl = false;
    this.KRm = false;
    this.KRn = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38482);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.cb.a.fromDPToPix(i.a(i.this), paramAnonymousInt2);
        paramAnonymousNoMeasuredTextView.getPaint().setTextSize(paramAnonymousInt2);
        float f2 = paramAnonymousNoMeasuredTextView.getPaint().measureText(" ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousNoMeasuredTextView.getPaint().setTextSize(f1);
        int i = paramAnonymousNoMeasuredTextView.getMeasuredWidth() - paramAnonymousNoMeasuredTextView.getCompoundPaddingRight() - paramAnonymousNoMeasuredTextView.getCompoundPaddingLeft();
        if (f2 >= i * 0.6D)
        {
          paramAnonymousCharSequence = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousNoMeasuredTextView.getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
          f2 = paramAnonymousNoMeasuredTextView.getPaint().measureText(paramAnonymousCharSequence.toString());
          paramAnonymousNoMeasuredTextView.getPaint().setTextSize(paramAnonymousInt2);
          paramAnonymousString = TextUtils.ellipsize(paramAnonymousString, paramAnonymousNoMeasuredTextView.getPaint(), i - f2 - 20.0F, TextUtils.TruncateAt.END);
          paramAnonymousNoMeasuredTextView.getPaint().setTextSize(f1);
        }
        for (paramAnonymousNoMeasuredTextView = paramAnonymousCharSequence;; paramAnonymousNoMeasuredTextView = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousNoMeasuredTextView.getPaint(), i - f2, TextUtils.TruncateAt.END))
        {
          paramAnonymousCharSequence = k.c(i.b(i.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.cb.a.m(i.c(i.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(38482);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.KOS = "";
    this.KRo = "";
    this.JAv = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(38488);
        i.this.notifyDataSetChanged();
        AppMethodBeat.o(38488);
      }
    };
    this.KRs = new e();
    this.Aic = false;
    this.KRt = -1.0F;
    this.KRv = 0L;
    this.KRw = false;
    this.vpK = false;
    this.KRx = false;
    this.mListView = paramListView;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.JPq[0] = com.tencent.mm.cb.a.m(paramContext, 2131100490);
    this.JPq[1] = com.tencent.mm.cb.a.m(paramContext, 2131100643);
    this.JPq[3] = com.tencent.mm.cb.a.m(paramContext, 2131100711);
    this.JPq[2] = com.tencent.mm.cb.a.m(paramContext, 2131099769);
    this.JPq[2] = com.tencent.mm.cb.a.m(paramContext, 2131099769);
    this.JPq[4] = com.tencent.mm.cb.a.m(paramContext, 2131100490);
    if (com.tencent.mm.cb.a.is(paramContext))
    {
      this.KOV = paramContext.getResources().getDimensionPixelSize(2131165246);
      this.KOU = paramContext.getResources().getDimensionPixelSize(2131165247);
    }
    for (;;)
    {
      this.JPs = new HashMap();
      this.KRe = new HashSet();
      this.KRj = new HashSet();
      this.JPl = paramContext.getResources().getDimension(2131165517);
      this.JPo = paramContext.getResources().getDimension(2131165466);
      this.JPp = paramContext.getResources().getDimension(2131165576);
      this.fUR = new ArrayList();
      this.fUR.add("qmessage");
      this.KRm = fNu();
      if (!this.KRm) {
        this.fUR.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38494);
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
    AppMethodBeat.i(38507);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(38507);
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
  
  private SparseArray<String> a(f.b<String, au> paramb, SparseArray<String> paramSparseArray, HashMap<String, au> paramHashMap)
  {
    AppMethodBeat.i(38516);
    String str = (String)paramb.object;
    int k = paramSparseArray.size();
    au localau = (au)paramb.JpY;
    int j = paramSparseArray.size();
    int i = 0;
    label39:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      ae.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i) });
      switch (paramb.JpX)
      {
      case 3: 
      case 4: 
      default: 
        if (i >= 0) {
          break label411;
        }
        ae.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
        AppMethodBeat.o(38516);
        return paramSparseArray;
        i += 1;
        break label39;
        i = -1;
      }
    }
    j = i;
    if (i < 0)
    {
      AppMethodBeat.o(38516);
      return paramSparseArray;
    }
    while (j < k - 1)
    {
      paramSparseArray.put(j, paramSparseArray.get(j + 1));
      j += 1;
    }
    paramSparseArray.remove(k - 1);
    for (;;)
    {
      AppMethodBeat.o(38516);
      return paramSparseArray;
      if (localau == null)
      {
        ae.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
        if (i >= 0)
        {
          ae.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[] { str });
          while (i < k - 1)
          {
            paramSparseArray.put(i, paramSparseArray.get(i + 1));
            i += 1;
          }
          paramSparseArray.remove(k - 1);
        }
        AppMethodBeat.o(38516);
        return paramSparseArray;
      }
      if (i >= 0) {
        break;
      }
      i = 0;
      while ((i < k) && (f((String)paramSparseArray.get(i), paramHashMap).field_flag > localau.field_flag)) {
        i += 1;
      }
      j = k;
      while (j > i)
      {
        paramSparseArray.put(j, paramSparseArray.get(j - 1));
        j -= 1;
      }
      paramSparseArray.put(i, str);
    }
    label411:
    paramb = f(str, paramHashMap);
    if (localau == null)
    {
      ae.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[] { str });
      while (i < k - 1)
      {
        paramSparseArray.put(i, paramSparseArray.get(i + 1));
        i += 1;
      }
      paramSparseArray.remove(k - 1);
      AppMethodBeat.o(38516);
      return paramSparseArray;
    }
    long l1 = paramb.field_flag;
    long l2 = localau.field_flag;
    if (l1 == l2)
    {
      AppMethodBeat.o(38516);
      return paramSparseArray;
    }
    int n;
    int m;
    if (l1 < l2)
    {
      j = 0;
      n = i - 1;
      m = 1;
      label538:
      k = j;
      label542:
      if (k > n) {
        break label765;
      }
      if (f((String)paramSparseArray.get(k), paramHashMap).field_flag > localau.field_flag) {
        break label666;
      }
    }
    label666:
    label765:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(-1), Boolean.valueOf(bool), Integer.valueOf(i), str });
      if (!bool)
      {
        AppMethodBeat.o(38516);
        return paramSparseArray;
        j = i + 1;
        n = k - 1;
        m = 0;
        break label538;
        k += 1;
        break label542;
      }
      if (m != 0) {
        while (i > k)
        {
          paramSparseArray.put(i, paramSparseArray.get(i - 1));
          i -= 1;
        }
      }
      k -= 1;
      for (;;)
      {
        j = k;
        if (i >= k) {
          break;
        }
        paramSparseArray.put(i, paramSparseArray.get(i + 1));
        i += 1;
      }
      j = k;
      paramSparseArray.put(j, str);
      break;
    }
  }
  
  private void a(d paramd, an paraman)
  {
    AppMethodBeat.i(38505);
    if ((paramd.rCw) && (paramd.fXp == null))
    {
      paramd.nickName = this.context.getString(2131757293);
      AppMethodBeat.o(38505);
      return;
    }
    if (an.aUq(paraman.field_username))
    {
      paramd.nickName = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).e(ak.getContext(), paramd.fXp, com.tencent.mm.cb.a.ax(this.context, 2131165517));
      AppMethodBeat.o(38505);
      return;
    }
    paramd.nickName = k.b(this.context, paramd.fXp, com.tencent.mm.cb.a.ax(this.context, 2131165517));
    AppMethodBeat.o(38505);
  }
  
  private static String aXl(String paramString)
  {
    AppMethodBeat.i(38511);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(paramString);
      AppMethodBeat.o(38511);
      return paramString;
    }
    AppMethodBeat.o(38511);
    return null;
  }
  
  private static int aeS(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    default: 
      return -1;
    case 1: 
    case 8: 
      return 2131690878;
    }
    return 2131690877;
  }
  
  private CharSequence b(au paramau, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38509);
    Object localObject3 = new SpannableStringBuilder();
    if ((paramau.lS(268435456)) && (!x.wb(paramau.field_username)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131762246));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
      ae.i("MicroMsg.ConversationWithCacheAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { paramau.field_username, Integer.valueOf(paramau.field_attrflag) });
    }
    while (((!bu.isNullOrNil(paramau.field_editingMsg)) || (paramau.field_editingQuoteMsgId != 0L)) && ((paramau.field_atCount <= 0) || ((paramau.field_unReadCount <= 0) && (paramau.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      if (!bu.isNullOrNil(paramau.field_editingMsg)) {
        ((SpannableStringBuilder)localObject1).append(" ").append(k.b(this.context, paramau.field_editingMsg, paramInt));
      }
      paramau = ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
      AppMethodBeat.o(38509);
      return paramau;
      if ((paramau.lS(268435456)) && (x.wb(paramau.field_username)))
      {
        ae.w("MicroMsg.ConversationWithCacheAdapter", "wrong flag");
        com.tencent.mm.plugin.report.service.g.yxI.f(20435, new Object[] { Integer.valueOf(1) });
        ae.i("MicroMsg.ConversationWithCacheAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { paramau.field_username, Integer.valueOf(paramau.field_attrflag) });
      }
    }
    if (Xr(paramau.field_msgType) == 10000)
    {
      boolean bool2 = x.AN(paramau.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramau.lS(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramau.lS(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramau.lS(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = x.AW(paramau.field_username);
      }
      if ((!bool2) && (paramau.field_hasTodo != 1))
      {
        if (paramau.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
        {
          ae.i("MicroMsg.ConversationWithCacheAdapter", "is transfer remind msg ");
          paramau = ((SpannableStringBuilder)localObject3).append(" ").append(k.f(this.context, paramau.field_content, paramInt));
          AppMethodBeat.o(38509);
          return paramau;
        }
        paramau = new SpannableString(k.f(this.context, paramau.field_content, paramInt));
        AppMethodBeat.o(38509);
        return paramau;
      }
    }
    Object localObject2;
    if (Xr(paramau.field_msgType) == 49)
    {
      localObject1 = w.zP(paramau.field_digestUser);
      localObject2 = k.b.zb(paramau.field_content);
      if (localObject2 == null) {}
    }
    Object localObject4;
    switch (((k.b)localObject2).type)
    {
    default: 
    case 40: 
      do
      {
        localObject1 = paramau.field_digest;
        if ((localObject1 == null) || (!((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
          break;
        }
        paramau = new SpannableString(k.e(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramau;
      } while (com.tencent.mm.ah.t.zg(paramau.field_content).hGb != 19);
      if (bu.isNullOrNil((String)localObject1)) {}
      for (localObject1 = this.context.getString(2131755872);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755872))
      {
        paramau.tW((String)localObject1);
        paramau = ((SpannableStringBuilder)localObject3).append(k.b(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramau;
      }
    case 5: 
      localObject1 = null;
      try
      {
        paramau = String.format(paramau.field_digest, new Object[] { l(paramau) });
        localObject4 = new StringBuilder();
        localObject1 = paramau;
        if (bu.isNullOrNil(paramau)) {
          localObject1 = this.context.getString(2131755920);
        }
        paramau = (String)localObject1 + " " + ((k.b)localObject2).title;
        paramau = ((SpannableStringBuilder)localObject3).append(k.f(this.context, paramau, paramInt));
        AppMethodBeat.o(38509);
        return paramau;
      }
      catch (Exception paramau)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramau, "", new Object[0]);
          paramau = (au)localObject1;
        }
      }
    }
    if (bu.isNullOrNil((String)localObject1)) {}
    for (Object localObject1 = this.context.getString(2131755872);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755872))
    {
      paramau.tW((String)localObject1);
      paramau = ((SpannableStringBuilder)localObject3).append(k.b(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38509);
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
        AppMethodBeat.o(38509);
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
        AppMethodBeat.o(38509);
        return paramau;
      }
    }
    if ((paramau.field_msgType != null) && (paramau.field_msgType.equals("64")))
    {
      paramau = paramau.field_content;
      AppMethodBeat.o(38509);
      return paramau;
    }
    if ((paramau.field_msgType != null) && ((paramau.field_msgType.equals("47")) || (paramau.field_msgType.equals("1048625"))))
    {
      localObject1 = aXl(paramau.field_digest);
      localObject2 = "";
      if (!bu.isNullOrNil((String)localObject1))
      {
        paramau = ((SpannableStringBuilder)localObject3).append("[" + (String)localObject1 + "]");
        AppMethodBeat.o(38509);
        return paramau;
      }
      localObject1 = localObject2;
      if (paramau.field_digest != null)
      {
        localObject1 = localObject2;
        if (paramau.field_digest.contains(":"))
        {
          localObject2 = paramau.field_digest.substring(0, paramau.field_digest.indexOf(":"));
          localObject4 = aXl(paramau.field_digest.substring(paramau.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject2;
          if (!bu.isNullOrNil((String)localObject4))
          {
            paramau = "[" + (String)localObject4 + "]";
            if (bu.isNullOrNil((String)localObject2))
            {
              paramau = ((SpannableStringBuilder)localObject3).append(k.b(this.context, (CharSequence)localObject2, paramInt));
              AppMethodBeat.o(38509);
              return paramau;
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(k.b(this.context, (CharSequence)localObject2, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramau);
            paramau = ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
            AppMethodBeat.o(38509);
            return paramau;
          }
        }
      }
      localObject2 = this.context.getString(2131755722);
      if (bu.isNullOrNil((String)localObject1))
      {
        localObject1 = localObject2;
        paramau.tW((String)localObject1);
      }
    }
    else
    {
      if (bu.isNullOrNil(paramau.field_digest)) {
        break label1684;
      }
      if (bu.isNullOrNil(paramau.field_digestUser)) {
        break label1673;
      }
      localObject1 = l(paramau);
    }
    label1673:
    label1684:
    String str;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramau.field_digest, new Object[] { localObject1 });
        localObject1 = ((String)localObject1).replace('\n', ' ');
        if ((!paramau.lS(33554432)) || ((paramau.field_unReadCount <= 0) && (paramau.field_unReadMuteCount <= 0))) {
          break label1715;
        }
        paramau = new SpannableStringBuilder(this.context.getString(2131764320));
        paramau.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramau.length(), 33);
        paramau.append(" ").append(k.b(this.context, (CharSequence)localObject1, paramInt));
        paramau = ((SpannableStringBuilder)localObject3).append(paramau);
        AppMethodBeat.o(38509);
        return paramau;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject2;
      break;
      localObject1 = paramau.field_digest;
      continue;
      str = com.tencent.mm.booter.notification.a.h.a(paramau.field_isSend, paramau.field_username, paramau.field_content, Xr(paramau.field_msgType), this.context);
    }
    label1715:
    if (paramau.field_UnReadInvite > 0)
    {
      if (paramau.field_UnReadInvite < 4096) {}
      for (paramau = this.context.getString(2131761045, new Object[] { Integer.valueOf(paramau.field_UnReadInvite) });; paramau = this.context.getString(2131761042))
      {
        paramau = new SpannableStringBuilder(paramau);
        paramau.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramau.length(), 33);
        paramau.append(" ").append(k.b(this.context, str, paramInt));
        AppMethodBeat.o(38509);
        return paramau;
      }
    }
    if ((paramau.field_atCount > 0) && ((paramau.field_unReadCount > 0) || (paramau.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramau.field_atCount < 4096) {
        i = 2131761044;
      }
      for (;;)
      {
        paramau = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramau.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramau.length(), 33);
        paramau.append(" ").append(k.b(this.context, str, paramInt));
        AppMethodBeat.o(38509);
        return paramau;
        if (com.tencent.mm.al.g.vz(paramau.field_username)) {
          i = 2131761043;
        } else {
          i = 2131761046;
        }
      }
    }
    if (paramau.field_hasTodo == 1)
    {
      paramau = new SpannableStringBuilder(this.context.getString(2131764449));
      paramau.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramau.length(), 33);
      paramau.append(" ").append(k.b(this.context, str, paramInt));
      AppMethodBeat.o(38509);
      return paramau;
    }
    if ((paramau.lS(16777216)) && ((paramau.field_unReadCount > 0) || (paramau.field_unReadMuteCount > 0)))
    {
      paramau = this.context.getString(2131755033);
      str = str.replace(paramau, "");
      paramau = new SpannableStringBuilder(paramau);
      paramau.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramau.length(), 33);
      paramau.append(k.b(this.context, str, paramInt));
      paramau = ((SpannableStringBuilder)localObject3).append(paramau);
      AppMethodBeat.o(38509);
      return paramau;
    }
    if (paramau.lS(268435456))
    {
      ((SpannableStringBuilder)localObject3).append(str.replace(this.context.getString(2131762246), ""));
      AppMethodBeat.o(38509);
      return localObject3;
    }
    if ((paramBoolean) && ((paramau.field_unReadCount > 1) || (paramau.field_unReadMuteCount > 0))) {
      paramau = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramau.field_unReadCount), str });
    }
    for (;;)
    {
      paramau = ((SpannableStringBuilder)localObject3).append(k.b(this.context, paramau, paramInt));
      AppMethodBeat.o(38509);
      return paramau;
      if ((y.bOd()) && (x.AN(paramau.field_username)))
      {
        paramBoolean = paramau.lS(16);
        if ((paramau.field_unReadCount > 1) || ((!paramBoolean) && (paramau.field_unReadCount > 0)))
        {
          if (paramBoolean)
          {
            if (paramau.lS(32))
            {
              paramau = this.context.getString(2131761039, new Object[] { Integer.valueOf(paramau.field_unReadCount) });
              localObject2 = this.context.getResources().getDrawable(2131231289);
              ((Drawable)localObject2).setBounds(0, 0, paramInt, paramInt);
              localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
              localObject3 = new SpannableString("@");
              ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
              paramau = TextUtils.concat(new CharSequence[] { paramau, " ", localObject3, k.b(this.context, str, paramInt) });
              AppMethodBeat.o(38509);
              return paramau;
            }
            paramau = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramau.field_unReadCount), str });
          }
          else
          {
            paramau = this.context.getString(2131761040, new Object[] { Integer.valueOf(paramau.field_unReadCount), str });
          }
        }
        else
        {
          if (paramau.lS(32))
          {
            paramau = this.context.getResources().getDrawable(2131231289);
            paramau.setBounds(0, 0, paramInt, paramInt);
            paramau = new com.tencent.mm.ui.widget.a(paramau);
            localObject2 = new SpannableString("@");
            ((SpannableString)localObject2).setSpan(paramau, 0, 1, 33);
            paramau = TextUtils.concat(new CharSequence[] { localObject2, k.b(this.context, str, paramInt) });
            AppMethodBeat.o(38509);
            return paramau;
          }
          paramau = str;
        }
      }
      else if ((x.AX(paramau.field_username)) && ((paramau.field_unReadCount > 1) || (paramau.field_unReadMuteCount > 0)))
      {
        paramau = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramau.field_unReadCount), str });
      }
      else
      {
        if ((Xr(paramau.field_msgType) == 889192497) || (Xr(paramau.field_msgType) == 922746929))
        {
          paramau = j(Xr(paramau.field_msgType), paramau.field_content, paramau.field_username, paramInt);
          AppMethodBeat.o(38509);
          return paramau;
        }
        paramau = str;
      }
    }
  }
  
  private au f(String paramString, HashMap<String, au> paramHashMap)
  {
    AppMethodBeat.i(38515);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (au)paramHashMap.get(paramString);
      AppMethodBeat.o(38515);
      return paramString;
    }
    if (this.JpL == null) {}
    for (paramString = null;; paramString = this.JpL.Jkn.dZ(paramString))
    {
      paramString = (au)paramString;
      AppMethodBeat.o(38515);
      return paramString;
    }
  }
  
  private void fMV()
  {
    AppMethodBeat.i(38498);
    if (this.JPs == null)
    {
      AppMethodBeat.o(38498);
      return;
    }
    Iterator localIterator = this.JPs.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).KPc = null;
    }
    AppMethodBeat.o(38498);
  }
  
  private boolean fNr()
  {
    return this.KRp != null;
  }
  
  private void fNt()
  {
    AppMethodBeat.i(38518);
    if ((this.JPs == null) || (this.KRe == null) || (this.KRe.isEmpty()))
    {
      AppMethodBeat.o(38518);
      return;
    }
    ae.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.KRe.size()) });
    Iterator localIterator = this.KRe.iterator();
    int i = 0;
    int j;
    boolean bool1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        j = i;
        if (str1 == null) {
          break label360;
        }
        j = i;
        if (str1.equals("")) {
          break label360;
        }
        j = i;
        if (!this.JPs.containsKey(str1)) {
          break label360;
        }
        d locald = (d)this.JPs.get(str1);
        j = i;
        if (locald == null) {
          break label360;
        }
        this.KRs.ui(str1);
        bool1 = x.wb(str1);
        an localan = this.KRs.dEE();
        if (localan != null)
        {
          String str2 = w.a(localan, str1, bool1);
          ae.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.fXp });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.fXp))
            {
              locald.fXp = str2;
              a(locald, localan);
              j = 1;
            }
          }
          boolean bool2 = localan.Pd();
          if (localan.eRd == 0)
          {
            bool1 = true;
            label269:
            if ((locald.KPi == bool2) && (bool1 == locald.KPm)) {
              break label360;
            }
            locald.KPi = bool2;
            locald.KPm = bool1;
            locald.KPn = localan.Zh();
            ae.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[] { str1 });
          }
        }
      }
    }
    label360:
    for (i = 1;; i = j)
    {
      break;
      bool1 = false;
      break label269;
      if (i != 0) {
        notifyDataSetChanged();
      }
      this.KRe.clear();
      AppMethodBeat.o(38518);
      return;
    }
  }
  
  private static boolean fNu()
  {
    AppMethodBeat.i(188065);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEE, false);
    ae.i("MicroMsg.ConversationWithCacheAdapter", "isShowAppBrandNotifyMsgEntry: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(188065);
    return bool;
  }
  
  private CharSequence i(au paramau)
  {
    AppMethodBeat.i(38495);
    if (paramau.field_status == 1)
    {
      paramau = this.context.getString(2131761075);
      AppMethodBeat.o(38495);
      return paramau;
    }
    if (paramau.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38495);
      return "";
    }
    paramau = com.tencent.mm.pluginsdk.i.i.c(this.context, paramau.field_conversationTime, true);
    AppMethodBeat.o(38495);
    return paramau;
  }
  
  private CharSequence j(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(188064);
    Object localObject2 = new ciz();
    Object localObject1;
    if (paramInt1 == 889192497) {
      localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).avw(paramString1);
    }
    for (;;)
    {
      try
      {
        if (((ciz)localObject1).vAC.size() <= 0) {
          continue;
        }
        localObject1 = (cja)((ciz)localObject1).vAC.getLast();
        paramString1 = ((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).parseDisplayTemplate(((cja)localObject1).hGT, paramString2);
        paramString2 = new SpannableString(paramString1.result);
        localObject2 = v.aAC();
        if ((!((cja)localObject1).dzZ.equals(localObject2)) && (((cja)localObject1).HvD.equals(localObject2)) && (((cja)localObject1).HvE == 0) && (!paramString1.wVt.isEmpty()))
        {
          localObject1 = new BoldForegroundColorSpan(this.context.getResources().getColor(2131099732));
          localObject2 = this.context.getString(2131766947);
          int j = paramString1.result.indexOf((String)localObject2, ((Integer)((Pair)paramString1.wVt.get(0)).second).intValue());
          int i = ((String)localObject2).length() + j;
          paramInt1 = i;
          if (i > paramString2.length()) {
            paramInt1 = paramString2.length();
          }
          paramString2.setSpan(localObject1, j, paramInt1, 17);
        }
        paramString1 = k.d(this.context, paramString2, paramInt2);
        AppMethodBeat.o(188064);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramString1, "", new Object[0]);
        AppMethodBeat.o(188064);
      }
      localObject1 = localObject2;
      if (paramInt1 == 922746929)
      {
        paramString1 = k.b.zb(paramString1);
        localObject1 = localObject2;
        if (paramString1 != null) {
          localObject1 = ((com.tencent.mm.plugin.patmsg.a.a)paramString1.ao(com.tencent.mm.plugin.patmsg.a.a.class)).wVs;
        }
      }
    }
    return "";
  }
  
  static int k(au paramau)
  {
    AppMethodBeat.i(188063);
    if ((paramau == null) || (paramau.field_unReadCount <= 0))
    {
      if (((paramau.lS(8388608)) || (paramau.lS(2097152))) && (paramau.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(188063);
        return 1;
      }
      AppMethodBeat.o(188063);
      return 0;
    }
    if (x.AN(paramau.field_username))
    {
      if ((y.bOd()) && (!paramau.lS(16)) && (!paramau.lS(64)))
      {
        AppMethodBeat.o(188063);
        return 0;
      }
      AppMethodBeat.o(188063);
      return 1;
    }
    if (x.AS(paramau.field_username))
    {
      bc.aCg();
      if (!com.tencent.mm.model.c.ajA().getBoolean(am.a.IQE, true))
      {
        AppMethodBeat.o(188063);
        return 1;
      }
    }
    if (x.AW(paramau.field_username))
    {
      bc.aCg();
      if (!com.tencent.mm.model.c.ajA().getBoolean(am.a.IQF, true))
      {
        AppMethodBeat.o(188063);
        return 1;
      }
    }
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(paramau.field_username);
    if ((localan != null) && ((int)localan.ght != 0))
    {
      if ((localan.Pd()) && (localan.Zh()))
      {
        AppMethodBeat.o(188063);
        return 1;
      }
      if ((x.wb(paramau.field_username)) && (localan.eRd == 0))
      {
        AppMethodBeat.o(188063);
        return 1;
      }
    }
    if (x.AX(paramau.field_username))
    {
      AppMethodBeat.o(188063);
      return 1;
    }
    AppMethodBeat.o(188063);
    return 2;
  }
  
  private static String l(au paramau)
  {
    AppMethodBeat.i(38510);
    if ((paramau.field_isSend == 0) && (x.wb(paramau.field_username)))
    {
      paramau = w.getDisplayName(paramau.field_digestUser, paramau.field_username);
      AppMethodBeat.o(38510);
      return paramau;
    }
    paramau = w.zP(paramau.field_digestUser);
    AppMethodBeat.o(38510);
    return paramau;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38517);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38517);
      return;
    }
    String str = (String)paramObject;
    if ((paramn instanceof br))
    {
      ae.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
      if ((!str.contains("@")) || (str.endsWith("@chatroom")) || (str.endsWith("@im.chatroom")) || (str.endsWith("@micromsg.qq.com")) || (an.aUq(str))) {}
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.JPs != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.KRk = true;
            super.n(null, 1);
            AppMethodBeat.o(38517);
          }
        }
        else {
          this.KRj.add(str);
        }
      }
      i = paramInt;
      if (paramInt == 3) {
        i = 2;
      }
      super.n(str, i);
      AppMethodBeat.o(38517);
      return;
    }
    if ((paramn instanceof bq))
    {
      ae.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (!bu.isNullOrNil(str))
      {
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str);
        if ((paramn != null) && ((int)paramn.ght > 0)) {
          ae.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(paramn.Pd()), Integer.valueOf(paramn.eRd) });
        }
      }
      if (this.vpK)
      {
        AppMethodBeat.o(38517);
        return;
      }
      this.KRi = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if ((this.JPs == null) || (!this.JPs.containsKey(str)))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.KRe != null) {
        this.KRe.add(str);
      }
    }
    AppMethodBeat.o(38517);
  }
  
  public final void a(View paramView, int paramInt, String paramString)
  {
    AppMethodBeat.i(38500);
    if (paramView == null)
    {
      AppMethodBeat.o(38500);
      return;
    }
    if (this.KRp != null)
    {
      ae.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(38500);
      return;
    }
    ae.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.KRp = paramString;
    f localf = (f)paramView.getTag();
    int j = paramView.getContext().getResources().getColor(2131099736);
    Resources localResources = paramView.getContext().getResources();
    if ((localf != null) && (localf.JPw)) {}
    for (int i = 2131099651;; i = 2131099650)
    {
      this.KRq = new ColorDrawable(ao.v(j, localResources.getColor(i)));
      paramView.setBackground(this.KRq);
      if (x.AX(paramString))
      {
        paramView = (au)abR(paramInt);
        paramString = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        com.tencent.mm.kernel.g.ajP();
        paramString.Lw(bu.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
        paramString.a(new g.a(paramView.field_unReadCount, paramInt + 1));
      }
      AppMethodBeat.o(38500);
      return;
    }
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, au>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(38514);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.g.ajM()))
    {
      AppMethodBeat.o(38514);
      return paramArrayOfSparseArray;
    }
    ae.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[] { Integer.valueOf(paramHashSet.size()), Integer.valueOf(paramArrayOfSparseArray[0].size()) });
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (f.b)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((f.b)localObject3).JpX != 5) && (!((ArrayList)localObject1).contains(((f.b)localObject3).object)))
      {
        ae.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((f.b)localObject3).object);
        ((ArrayList)localObject1).add(((f.b)localObject3).object);
      }
    }
    localObject2 = new HashMap();
    bc.aCg();
    Object localObject3 = com.tencent.mm.model.c.azL().a((ArrayList)localObject1, x.hHV, this.fUR, com.tencent.mm.o.a.ghD);
    Object localObject4;
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = new au();
      ((au)localObject4).convertFrom((Cursor)localObject3);
      ((HashMap)localObject2).put(((ba)localObject4).field_username, localObject4);
    }
    ((Cursor)localObject3).close();
    localObject3 = paramHashSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (f.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((f.b)localObject4).JpX != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((f.b)localObject4).object).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((f.b)localObject4).object) == null) {}
          for (boolean bool = true;; bool = false)
          {
            ae.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((f.b)localObject4).JpY = ((HashMap)localObject2).get(((f.b)localObject4).object);
            break;
          }
        }
        ((f.b)localObject4).JpY = null;
      }
    }
    ((ArrayList)localObject1).clear();
    ((HashMap)localObject2).clear();
    localObject1 = new HashMap();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      localObject2 = (f.b)paramHashSet.next();
      if (localObject2 != null)
      {
        a((f.b)localObject2, paramArrayOfSparseArray[0], (HashMap)localObject1);
        if (((f.b)localObject2).JpX != 5) {
          ((HashMap)localObject1).put(((f.b)localObject2).object, ((f.b)localObject2).JpY);
        }
      }
    }
    AppMethodBeat.o(38514);
    return paramArrayOfSparseArray;
  }
  
  public final ArrayList<au> aW(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(38513);
    ae.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    bc.aCg();
    paramArrayList = com.tencent.mm.model.c.azL().a(paramArrayList, x.hHV, this.fUR, com.tencent.mm.o.a.ghD);
    while (paramArrayList.moveToNext())
    {
      au localau = new au();
      localau.convertFrom(paramArrayList);
      localArrayList.add(localau);
    }
    paramArrayList.close();
    AppMethodBeat.o(38513);
    return localArrayList;
  }
  
  public final void aff(int paramInt)
  {
    AppMethodBeat.i(38501);
    if (!fNr())
    {
      ae.i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
      AppMethodBeat.o(38501);
      return;
    }
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38485);
        i.e(i.this);
        AppMethodBeat.o(38485);
      }
    }, paramInt);
    AppMethodBeat.o(38501);
  }
  
  public final void afg(int paramInt)
  {
    AppMethodBeat.i(38521);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(38521);
      return;
    }
    try
    {
      au localau = (au)abR(paramInt);
      if (localau == null)
      {
        AppMethodBeat.o(38521);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject;
      for (;;)
      {
        ae.w("MicroMsg.ConversationWithCacheAdapter", "preLoad position:%s is null!", new Object[] { Integer.valueOf(paramInt) });
        localObject = null;
      }
      a.b.ffl().fl(localObject.field_username);
      AppMethodBeat.o(38521);
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(38508);
    if (this.JPs != null)
    {
      this.JPs.clear();
      this.KRk = true;
    }
    AppMethodBeat.o(38508);
  }
  
  public final void fLW()
  {
    boolean bool1 = true;
    AppMethodBeat.i(38496);
    if (this.fUR == null) {
      this.fUR = new ArrayList();
    }
    this.fUR.clear();
    int i;
    if ((v.aAG() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = v.aAX();
      if ((i == 0) || (!bool2)) {
        break label198;
      }
      label59:
      if (bool1 != this.KRl)
      {
        if (!bool1) {
          break label203;
        }
        bc.aCg();
        a(5, (n)com.tencent.mm.model.c.azL(), "floatbottle");
        label89:
        this.KRl = bool1;
      }
      if (this.KRl) {
        this.fUR.add("floatbottle");
      }
      this.fUR.add("qmessage");
      bool1 = fNu();
      if (bool1 != this.KRm)
      {
        if (!bool1) {
          break label224;
        }
        bc.aCg();
        a(2, (n)com.tencent.mm.model.c.azL(), "appbrand_notify_message");
      }
    }
    for (;;)
    {
      this.KRm = bool1;
      if (!this.KRm) {
        this.fUR.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38496);
      return;
      i = 0;
      break;
      label198:
      bool1 = false;
      break label59;
      label203:
      bc.aCg();
      a(2, (n)com.tencent.mm.model.c.azL(), "floatbottle");
      break label89;
      label224:
      bc.aCg();
      a(5, (n)com.tencent.mm.model.c.azL(), "appbrand_notify_message");
    }
  }
  
  public final void fNs()
  {
    AppMethodBeat.i(38502);
    super.n(null, 1);
    AppMethodBeat.o(38502);
  }
  
  public final boolean fxK()
  {
    AppMethodBeat.i(38519);
    boolean bool = super.fxK();
    AppMethodBeat.o(38519);
    return bool;
  }
  
  public final com.tencent.mm.storagebase.a.d fzk()
  {
    AppMethodBeat.i(38512);
    ae.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    bc.aCg();
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)com.tencent.mm.model.c.azL().a(x.hHV, this.fUR, com.tencent.mm.o.a.ghD, true);
    AppMethodBeat.o(38512);
    return locald;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38503);
    this.KRu = new a((byte)0);
    au localau = (au)abR(paramInt);
    String str = localau.field_username;
    this.KRs.ui(str);
    Object localObject1;
    int i;
    Object localObject3;
    label249:
    label505:
    boolean bool1;
    if (this.KRg.containsKey(str))
    {
      if (paramInt != ((Integer)this.KRg.get(str)).intValue())
      {
        localObject1 = fzl();
        int k;
        if (this.JpL == null)
        {
          paramViewGroup = null;
          localObject2 = new StringBuffer();
          k = localObject1.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= k) {
            break label249;
          }
          localObject3 = localObject1[i];
          int j = 0;
          for (;;)
          {
            if ((j < ((SparseArray)localObject3).size()) && (j < 50))
            {
              ((StringBuffer)localObject2).append("[");
              ((StringBuffer)localObject2).append(j);
              ((StringBuffer)localObject2).append(",");
              ((StringBuffer)localObject2).append(((SparseArray)localObject3).keyAt(j));
              ((StringBuffer)localObject2).append(",");
              ((StringBuffer)localObject2).append((String)((SparseArray)localObject3).valueAt(j));
              ((StringBuffer)localObject2).append("]");
              j += 1;
              continue;
              paramViewGroup = this.JpL.Jkn.fxJ();
              break;
            }
          }
          i += 1;
        }
        ((StringBuffer)localObject2).append("\n");
        if (paramViewGroup != null)
        {
          localObject1 = paramViewGroup.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            if (i >= 50) {
              break;
            }
            i += 1;
            ((StringBuffer)localObject2).append("[");
            ((StringBuffer)localObject2).append(((Map.Entry)localObject3).getKey());
            ((StringBuffer)localObject2).append(",");
            if (((Map.Entry)localObject3).getValue() != null) {
              ((StringBuffer)localObject2).append(((au)((Map.Entry)localObject3).getValue()).field_username);
            }
            ((StringBuffer)localObject2).append("]");
          }
          ((StringBuffer)localObject2).append("\n");
        }
        localObject1 = ((StringBuffer)localObject2).toString();
        localObject2 = this.KRg.toString();
        if (paramViewGroup == null) {
          break label2263;
        }
        i = paramViewGroup.size();
        ae.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject1, str, Integer.valueOf(paramInt), localObject2, Integer.valueOf(i) });
        if (!this.KRf)
        {
          com.tencent.mm.plugin.fts.a.e.Hk(20);
          this.KRf = true;
        }
        if (System.currentTimeMillis() - this.KRv > 3600000L)
        {
          super.n(null, 1);
          this.KRv = System.currentTimeMillis();
        }
      }
      if (paramView != null) {
        break label2307;
      }
      localObject1 = new f();
      if (!com.tencent.mm.cb.a.it(this.context)) {
        break label2286;
      }
      com.tencent.mm.kiss.a.b.akR();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493666);
      label546:
      paramView.setTag(2131306044, new int[2]);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38489);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if ((i.g(i.this) == null) || (i.g(i.this).getOnItemClickListener() == null))
          {
            ae.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          if (paramAnonymousView.getTag() == null)
          {
            ae.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          if (!i.this.Kbw)
          {
            ae.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          localObject = (i.f)paramAnonymousView.getTag();
          int i = ((i.f)localObject).position;
          int j = i.g(i.this).getHeaderViewsCount();
          i.g(i.this).getOnItemClickListener().onItemClick(i.g(i.this), paramAnonymousView, i + j, i.this.getItemId(((i.f)localObject).position));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38489);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38490);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if ((i.g(i.this) == null) || (i.g(i.this).getOnItemLongClickListener() == null))
          {
            ae.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          if (paramAnonymousView.getTag() == null)
          {
            ae.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          if (!i.this.Kbw)
          {
            ae.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          localObject = (i.f)paramAnonymousView.getTag();
          int i = ((i.f)localObject).position;
          int j = i.g(i.this).getHeaderViewsCount();
          boolean bool = i.g(i.this).getOnItemLongClickListener().onItemLongClick(i.g(i.this), paramAnonymousView, i + j, i.this.getItemId(((i.f)localObject).position));
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38490);
          return bool;
        }
      });
      ((f)localObject1).fQl = ((ImageView)paramView.findViewById(2131297008));
      a.b.c(((f)localObject1).fQl, str);
      paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)((f)localObject1).fQl.getDrawable();
      if (this.KOM != null) {
        this.KOM.a(paramViewGroup);
      }
      ((f)localObject1).fQl.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(38491);
          this.KRB.fQl.getViewTreeObserver().removeOnPreDrawListener(this);
          int i = this.KRB.fQl.getWidth();
          int j = aq.ay(i.h(i.this), 2131165508);
          if (i != j)
          {
            ae.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.KRB.fQl.getLayoutParams();
            localLayoutParams.width = j;
            localLayoutParams.height = j;
            this.KRB.fQl.setLayoutParams(localLayoutParams);
            ae.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", new Object[] { Integer.valueOf(this.KRB.fQl.getWidth()) });
            if (!i.i(i.this))
            {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(1055L, 4L, 1L, false);
              ae.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
              i.j(i.this);
            }
          }
          AppMethodBeat.o(38491);
          return true;
        }
      });
      ((f)localObject1).JPz = ((NoMeasuredTextView)paramView.findViewById(2131302867));
      ((f)localObject1).JPz.setLayoutCallback(this.KRn);
      ((f)localObject1).JPA = ((NoMeasuredTextView)paramView.findViewById(2131306207));
      ((f)localObject1).KRK = ((ImageView)paramView.findViewById(2131301312));
      ((f)localObject1).JPB = ((NoMeasuredTextView)paramView.findViewById(2131301311));
      ((f)localObject1).oaj = ((TextView)paramView.findViewById(2131305882));
      ((f)localObject1).KRL = ((WeImageView)paramView.findViewById(2131300954));
      ((f)localObject1).JPE = paramView.findViewById(2131297015);
      ((f)localObject1).KPr = ((ImageView)paramView.findViewById(2131301541));
      ((f)localObject1).KRM = ((ImageView)paramView.findViewById(2131302581));
      ((f)localObject1).oaj.setBackgroundResource(u.kL(this.context));
      ((f)localObject1).oaj.setTextSize(0, com.tencent.mm.cb.a.ay(this.context, 2131166949) * com.tencent.mm.cb.a.ip(this.context));
      ((f)localObject1).KRN = new c();
      paramView.setTag(localObject1);
      ((f)localObject1).JPB.setTextSize(0, com.tencent.mm.cb.a.ax(this.context, 2131165574));
      ((f)localObject1).JPA.setTextSize(0, com.tencent.mm.cb.a.ax(this.context, 2131165576));
      ((f)localObject1).JPz.setTextSize(0, com.tencent.mm.cb.a.ax(this.context, 2131165517));
      this.KRt = ((f)localObject1).JPz.getTextSize();
      ((f)localObject1).JPB.setTextColor(this.JPq[0]);
      ((f)localObject1).JPA.setTextColor(this.JPq[4]);
      ((f)localObject1).JPz.setTextColor(this.JPq[3]);
      ((f)localObject1).JPB.setShouldEllipsize(true);
      ((f)localObject1).JPA.setShouldEllipsize(false);
      ((f)localObject1).JPz.setShouldEllipsize(true);
      if (((f)localObject1).JPz.getPaint() != null) {
        al.a(((f)localObject1).JPz.getPaint(), 0.1F);
      }
      ((f)localObject1).JPA.setGravity(5);
      paramViewGroup = paramView;
      label1036:
      localObject3 = j(localau);
      ((f)localObject1).position = paramInt;
      ((f)localObject1).username = str;
      if ((!((d)localObject3).JPw) || (localau.field_conversationTime == -1L)) {
        break label2321;
      }
      bool1 = true;
      label1080:
      ((f)localObject1).JPw = bool1;
      if (((d)localObject3).KPd == null) {
        ((d)localObject3).KPd = b(localau, (int)((f)localObject1).JPB.getTextSize(), ((d)localObject3).KPk);
      }
      if ((x.AN(localau.field_username)) && (((d)localObject3).KPd != null))
      {
        paramView = d.KOJ;
        if (d.fMU())
        {
          paramView = com.tencent.mm.storage.t.IIz;
          com.tencent.mm.storage.t.aS(((d)localObject3).KPd.toString(), paramInt, localau.field_unReadCount);
          paramView = com.tencent.mm.plugin.brandservice.b.c.och;
          com.tencent.mm.plugin.brandservice.b.c.s(1, "", "");
        }
      }
      if (((d)localObject3).KPc == null) {
        ((d)localObject3).KPc = i(localau);
      }
      if (!((d)localObject3).KPk) {
        break label2327;
      }
      ((f)localObject1).JPB.setTextColor(this.JPq[0]);
      label1225:
      com.tencent.mm.booter.notification.a.h.la(((f)localObject1).JPB.getWidth());
      com.tencent.mm.booter.notification.a.h.lb((int)((f)localObject1).JPB.getTextSize());
      com.tencent.mm.booter.notification.a.h.b(((f)localObject1).JPB.getPaint());
      if ((!x.zV(str)) && (!x.zX(str))) {
        break label2348;
      }
      ((f)localObject1).JPz.setCompoundRightDrawablesWithIntrinsicBounds(2131691000);
      ((f)localObject1).JPz.setDrawRightDrawable(true);
      label1295:
      i = ((d)localObject3).KPe;
      if (i == -1) {
        break label2371;
      }
      ((f)localObject1).JPB.setCompoundLeftDrawablesWithIntrinsicBounds(i);
      ((f)localObject1).JPB.setDrawLeftDrawable(true);
      ae.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((d)localObject3).KPe) });
      label1355:
      if (!an.aUq(localau.field_username)) {
        break label2405;
      }
      this.KRs.ui(localau.field_username);
      Object localObject4 = this.KRs.dEE();
      paramView = "";
      if (localObject4 != null) {
        paramView = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).bC(((aw)localObject4).field_openImAppid, ((aw)localObject4).field_descWordingId);
      }
      if (bu.isNullOrNil(paramView)) {
        break label2391;
      }
      Object localObject2 = paramView;
      if ("3552365301".equals(((aw)localObject4).field_openImAppid)) {
        localObject2 = "@".concat(String.valueOf(paramView));
      }
      ((f)localObject1).JPz.aW((String)localObject2, 2131100528, 14);
      label1471:
      ((f)localObject1).JPz.setText(((d)localObject3).nickName);
      paramView = ((f)localObject1).JPA.getLayoutParams();
      if (((d)localObject3).KPc.length() < 9) {
        break label2428;
      }
      if (paramView.width != this.KOV)
      {
        paramView.width = this.KOV;
        ((f)localObject1).JPA.setLayoutParams(paramView);
      }
      label1536:
      ((f)localObject1).JPA.setText(((d)localObject3).KPc);
      ((f)localObject1).JPB.setText(((d)localObject3).KPd);
      if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localau, 7, 0L) <= 0L) {
        break label2459;
      }
      bool1 = true;
      label1578:
      localObject2 = localau.field_username;
      long l1 = localau.field_conversationTime;
      localObject4 = ((d)localObject3).KPc;
      boolean bool2 = ((f)localObject1).JPw;
      long l2 = localau.field_flag;
      long l3 = localau.field_flag;
      if ((((d)localObject3).nickName != null) && (((d)localObject3).nickName.length() > 0)) {
        break label2465;
      }
      paramView = "?";
      label1645:
      ae.i("MicroMsg.ConversationWithCacheAdapter", "[getView] position=%s username=%s conversationTime=%s updateTime=%s isPlacedTop=%s isTalkRoomTopPlace=%s flag=%s flagTime=%s nickname=%s unread=%s", new Object[] { Integer.valueOf(paramInt), localObject2, Long.valueOf(l1), localObject4, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3 & 0xFFFFFFFF), paramView, Integer.valueOf(localau.field_unReadCount) });
      if ((bool1) && (0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localau, 7, 0L)))
      {
        localau.qI(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localau, 6, localau.field_conversationTime));
        bc.aCg();
        com.tencent.mm.model.c.azL().a(localau, localau.field_username);
      }
      ((f)localObject1).KRK.setVisibility(8);
      ((f)localObject1).KRL.setVisibility(8);
      if (!((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).akx(str)) {
        break label2483;
      }
      ((f)localObject1).KRL.setVisibility(0);
      ((f)localObject1).KRL.setImageDrawable(ao.k(this.context, 2131690531, this.context.getResources().getColor(2131099982)));
      label1872:
      a.b.c(((f)localObject1).fQl, str);
      if (this.KOK)
      {
        ae.i("MicroMsg.ConversationWithCacheAdapter", "handleShowTipCnt.");
        if ((localau != null) && (localObject1 != null) && (localObject3 != null)) {
          break label2562;
        }
        ae.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
      }
      label1920:
      if ((!((d)localObject3).KPh) && (((d)localObject3).JPw) && (bc.ajM()))
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().g(localau);
      }
      if ((this.KRp == null) || (!this.KRp.equals(str))) {
        break label2815;
      }
      ae.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), this.KRp });
      paramViewGroup.findViewById(2131298792).setBackground(this.KRq);
      label2019:
      if (Build.VERSION.SDK_INT >= 21) {
        paramViewGroup.findViewById(2131298792).setOnTouchListener(new View.OnTouchListener()
        {
          @TargetApi(21)
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(38483);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            paramAnonymousView.findViewById(2131298792).getBackground().setHotspot(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(38483);
            return false;
          }
        });
      }
      if ((com.tencent.mm.bi.d.iuo == null) || (!com.tencent.mm.bi.d.iuo.Hm(localau.field_username))) {
        break label2867;
      }
      ((f)localObject1).KPr.setVisibility(0);
      label2076:
      if ((!x.wb(localau.field_username)) || (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class) == null) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asq(localau.field_username))) {
        break label2914;
      }
      if ((!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).dsj()) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).ic(localau.field_username, v.aAC()))) {
        break label2880;
      }
      ((f)localObject1).KRM.setImageResource(2131689895);
      label2171:
      ((f)localObject1).KRM.setVisibility(0);
    }
    for (;;)
    {
      this.KRu.content = String.valueOf(((d)localObject3).KPd);
      this.KRu.bVF = ((d)localObject3).fXp;
      this.KRu.time = String.valueOf(((d)localObject3).KPc);
      paramView = this.KRu;
      a.a.fCh().a(paramViewGroup, paramView.bVF, paramView.KPb, paramView.time, paramView.content);
      paramViewGroup.setAlpha(1.0F);
      AppMethodBeat.o(38503);
      return paramViewGroup;
      label2263:
      i = 0;
      break;
      this.KRg.put(str, Integer.valueOf(paramInt));
      break label505;
      label2286:
      com.tencent.mm.kiss.a.b.akR();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493664);
      break label546;
      label2307:
      localObject1 = (f)paramView.getTag();
      paramViewGroup = paramView;
      break label1036;
      label2321:
      bool1 = false;
      break label1080;
      label2327:
      ((f)localObject1).JPB.setTextColor(this.JPq[localObject3.oOD]);
      break label1225;
      label2348:
      if (!((f)localObject1).JPz.JKQ) {
        break label1295;
      }
      ((f)localObject1).JPz.setDrawRightDrawable(false);
      break label1295;
      label2371:
      ((f)localObject1).JPB.setDrawLeftDrawable(false);
      ((f)localObject1).JPB.invalidate();
      break label1355;
      label2391:
      ((f)localObject1).JPz.aW(null, 0, 0);
      break label1471;
      label2405:
      x.zV(localau.field_username);
      ((f)localObject1).JPz.aW(null, 0, 0);
      break label1471;
      label2428:
      if (paramView.width == this.KOU) {
        break label1536;
      }
      paramView.width = this.KOU;
      ((f)localObject1).JPA.setLayoutParams(paramView);
      break label1536;
      label2459:
      bool1 = false;
      break label1578;
      label2465:
      paramView = Character.valueOf(((d)localObject3).nickName.charAt(0));
      break label1645;
      label2483:
      ((f)localObject1).KRL.setImageDrawable(ao.k(this.context, 2131690523, this.context.getResources().getColor(2131099982)));
      if (((d)localObject3).rCw)
      {
        if (!((d)localObject3).KPm) {
          break label1872;
        }
        ((f)localObject1).KRL.setVisibility(0);
        break label1872;
      }
      if (!((d)localObject3).KPi) {
        break label1872;
      }
      ((f)localObject1).KRL.setVisibility(0);
      break label1872;
      label2562:
      ((f)localObject1).oaj.setVisibility(4);
      ((f)localObject1).JPE.setVisibility(4);
      if ((!x.Af(localau.field_username)) && (((d)localObject3).KPl) && ((((d)localObject3).KPg == 1) || (((d)localObject3).KPg == 2) || (((d)localObject3).KPg == 3))) {}
      for (paramView = this.JPq[2];; paramView = this.JPq[3])
      {
        ((f)localObject1).JPz.setTextColor(paramView);
        if ((!((d)localObject3).KPl) || (((d)localObject3).KPf == 0)) {
          ae.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
        }
        paramInt = k(localau);
        if (paramInt != 1) {
          break label2699;
        }
        ((f)localObject1).JPE.setVisibility(0);
        break;
      }
      label2699:
      if (paramInt != 2) {
        break label1920;
      }
      paramInt = localau.field_unReadCount;
      if (paramInt > 99)
      {
        ((f)localObject1).oaj.setText("");
        ((f)localObject1).oaj.setBackgroundResource(2131689744);
        ((f)localObject1).oaj.setVisibility(0);
      }
      for (;;)
      {
        this.KRu.KPb = paramInt;
        break;
        if (paramInt > 0)
        {
          ((f)localObject1).oaj.setText(localau.field_unReadCount);
          ((f)localObject1).oaj.setVisibility(0);
          ((f)localObject1).oaj.setBackgroundResource(u.aP(this.context, paramInt));
        }
      }
      label2815:
      if ((((d)localObject3).JPw) && (localau.field_conversationTime != -1L))
      {
        paramViewGroup.findViewById(2131298792).setBackgroundResource(2131232872);
        break label2019;
      }
      paramViewGroup.findViewById(2131298792).setBackgroundResource(2131231854);
      break label2019;
      label2867:
      ((f)localObject1).KPr.setVisibility(8);
      break label2076;
      label2880:
      ((f)localObject1).KRM.setImageDrawable(ao.k(this.context, 2131690409, this.context.getResources().getColor(2131099982)));
      break label2171;
      label2914:
      ((f)localObject1).KRM.setVisibility(8);
    }
  }
  
  final d j(au paramau)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38504);
    String str2 = paramau.field_username;
    Object localObject;
    if (this.JPs != null)
    {
      localObject = (d)this.JPs.get(str2);
      if (localObject != null)
      {
        AppMethodBeat.o(38504);
        return localObject;
      }
    }
    d locald = new d((byte)0);
    this.KRs.ui(str2);
    an localan = this.KRs.dEE();
    if (localan != null)
    {
      locald.KPg = localan.eRn;
      locald.KPf = ((int)localan.ght);
      if (localan == null) {
        break label532;
      }
      bool1 = true;
      label111:
      locald.KPl = bool1;
      if ((localan == null) || (!localan.Zh())) {
        break label537;
      }
      bool1 = true;
      label132:
      locald.KPn = bool1;
      if ((localan == null) || (localan.eRd != 0)) {
        break label542;
      }
      bool1 = true;
      label153:
      locald.KPm = bool1;
      locald.rCw = x.zT(str2);
      if ((!locald.rCw) || (!locald.KPm) || (paramau.field_unReadCount <= 0)) {
        break label547;
      }
      bool1 = true;
      label194:
      locald.KPk = bool1;
      locald.oOD = 0;
      if ((Xr(paramau.field_msgType) == 34) && (paramau.field_isSend == 0) && (!bu.isNullOrNil(paramau.field_content)))
      {
        String str1 = paramau.field_content;
        if ((!str2.equals("qmessage")) && (!str2.equals("floatbottle")) && (!str2.equals("officialaccounts")) && (!paramau.lS(2097152)))
        {
          localObject = str1;
          if (!paramau.lS(8388608)) {}
        }
        else
        {
          String[] arrayOfString = str1.split(":");
          localObject = str1;
          if (arrayOfString != null)
          {
            localObject = str1;
            if (arrayOfString.length > 3) {
              localObject = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
            }
          }
        }
        if (!new p((String)localObject).iwT) {
          locald.oOD = 1;
        }
      }
      locald.fXp = w.a(localan, str2, locald.rCw);
      a(locald, localan);
      locald.KPc = i(paramau);
      locald.KPe = aeS(paramau.field_status);
      locald.KPh = x.a(paramau);
      bc.aCg();
      locald.JPw = com.tencent.mm.model.c.azL().h(paramau);
      if ((localan == null) || (!localan.Pd())) {
        break label552;
      }
    }
    label532:
    label537:
    label542:
    label547:
    label552:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locald.KPi = bool1;
      if (this.JPs != null) {
        this.JPs.put(str2, locald);
      }
      AppMethodBeat.o(38504);
      return locald;
      locald.KPg = -1;
      locald.KPf = -1;
      break;
      bool1 = false;
      break label111;
      bool1 = false;
      break label132;
      bool1 = false;
      break label153;
      bool1 = false;
      break label194;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(38522);
    if (!this.KRx)
    {
      super.notifyDataSetChanged();
      this.KRg.clear();
    }
    ae.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    AppMethodBeat.o(38522);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38497);
    ae.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.Kbw);
    if (!this.Kbw)
    {
      AppMethodBeat.o(38497);
      return;
    }
    this.Kbw = false;
    super.pause();
    if (this.oaf != null) {
      this.oaf.dhu();
    }
    AppMethodBeat.o(38497);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(38499);
    ae.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.Kbw);
    if (this.Kbw)
    {
      AppMethodBeat.o(38499);
      return;
    }
    this.Kbw = true;
    fLW();
    fNt();
    ae.i(this.TAG, "newcursor resume syncNow ");
    this.JpK = true;
    lR(true);
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.i.h.a("MM/dd", (Time)localObject).toString();
    String str = ad.fom();
    if ((!this.KOS.equals(localObject)) || (!this.KRo.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.KOS = ((String)localObject);
      this.KRo = str;
      if (i != 0) {
        fMV();
      }
      if ((this.KON) && (this.KRd != null))
      {
        this.KRd.fNv();
        this.KON = false;
        super.n(null, 1);
      }
      AppMethodBeat.o(38499);
      return;
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
  
  public static abstract interface b
  {
    public abstract void fNv();
  }
  
  final class c
  {
    public View JHq = null;
    boolean KRC = false;
    boolean KRD = false;
    boolean KRE = false;
    boolean KRF = false;
    boolean KRG = false;
    public ImageView KRH = null;
    public TextView KRI = null;
    public View KRJ = null;
    public View oak = null;
    public TextView oal = null;
    String username = "";
    
    c() {}
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
    public boolean KPk;
    public boolean KPl;
    public boolean KPm;
    public boolean KPn;
    public String fXp;
    public CharSequence nickName;
    public int oOD;
    public boolean rCw;
    
    private d() {}
  }
  
  final class e
  {
    private Integer KPp = null;
    private an contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final an dEE()
    {
      AppMethodBeat.i(38493);
      if ((this.initialized) && (this.contact == null) && (bc.ajM()))
      {
        bc.aCg();
        this.contact = com.tencent.mm.model.c.azF().BH(this.talker);
      }
      an localan = this.contact;
      AppMethodBeat.o(38493);
      return localan;
    }
    
    public final void ui(String paramString)
    {
      AppMethodBeat.i(38492);
      this.talker = paramString;
      this.contact = null;
      this.KPp = null;
      this.initialized = false;
      if (!bu.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(38492);
    }
  }
  
  public static final class f
  {
    public NoMeasuredTextView JPA;
    public NoMeasuredTextView JPB;
    public View JPE;
    public boolean JPw;
    public NoMeasuredTextView JPz;
    public ImageView KPr;
    public ImageView KRK;
    public WeImageView KRL;
    public ImageView KRM;
    public i.c KRN;
    public ImageView fQl;
    public TextView oaj;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */