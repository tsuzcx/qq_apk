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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.f.b;
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
  extends com.tencent.mm.ui.f<String, at>
  implements n.b
{
  public boolean JGF;
  k.a JfK;
  private float JuA;
  private ColorStateList[] JuB;
  HashMap<String, d> JuD;
  private float Juw;
  private float Juz;
  private final int KsA;
  private final int KsB;
  private boolean Ksq;
  com.tencent.mm.pluginsdk.ui.e Kss;
  private boolean Kst;
  com.tencent.mm.sdk.b.c Ksw;
  public String Ksy;
  private boolean KuH;
  private wm KuI;
  b KuJ;
  private HashSet<String> KuK;
  private boolean KuL;
  HashMap<String, Integer> KuM;
  private HashMap<String, Integer> KuN;
  private boolean KuO;
  HashSet<String> KuP;
  boolean KuQ;
  private boolean KuR;
  private boolean KuS;
  private NoMeasuredTextView.c KuT;
  public String KuU;
  private String KuV;
  ValueAnimator KuX;
  final e KuY;
  private float KuZ;
  private a Kva;
  private long Kvb;
  private boolean Kvc;
  boolean Kvd;
  private ColorDrawable Ofs;
  protected List<String> fSL;
  private boolean jgw;
  private ListView mListView;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.d nUz;
  boolean vdz;
  boolean zQV;
  
  public i(Context paramContext, ListView paramListView, f.a parama)
  {
    super(paramContext, (short)0);
    AppMethodBeat.i(38494);
    this.fSL = null;
    this.JuB = new ColorStateList[5];
    this.Ksq = true;
    this.KuH = false;
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    this.KuI = null;
    this.jgw = false;
    this.Juw = -1.0F;
    this.Juz = -1.0F;
    this.JuA = -1.0F;
    this.Kst = false;
    this.Ksw = null;
    this.KuJ = null;
    this.JGF = false;
    this.KuL = false;
    this.KuM = new HashMap();
    this.KuN = new HashMap();
    this.KuO = false;
    this.KuQ = false;
    this.KuR = false;
    this.KuS = false;
    this.KuT = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38482);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.cc.a.fromDPToPix(i.a(i.this), paramAnonymousInt2);
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
          ColorStateList localColorStateList = com.tencent.mm.cc.a.m(i.c(i.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(38482);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.Ksy = "";
    this.KuU = "";
    this.JfK = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(38488);
        i.this.notifyDataSetChanged();
        AppMethodBeat.o(38488);
      }
    };
    this.KuY = new e();
    this.zQV = false;
    this.KuZ = -1.0F;
    this.Kvb = 0L;
    this.Kvc = false;
    this.vdz = false;
    this.Kvd = false;
    this.mListView = paramListView;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.JuB[0] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
    this.JuB[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
    this.JuB[3] = com.tencent.mm.cc.a.m(paramContext, 2131100711);
    this.JuB[2] = com.tencent.mm.cc.a.m(paramContext, 2131099769);
    this.JuB[2] = com.tencent.mm.cc.a.m(paramContext, 2131099769);
    this.JuB[4] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
    if (com.tencent.mm.cc.a.in(paramContext))
    {
      this.KsB = paramContext.getResources().getDimensionPixelSize(2131165246);
      this.KsA = paramContext.getResources().getDimensionPixelSize(2131165247);
    }
    for (;;)
    {
      this.JuD = new HashMap();
      this.KuK = new HashSet();
      this.KuP = new HashSet();
      this.Juw = paramContext.getResources().getDimension(2131165517);
      this.Juz = paramContext.getResources().getDimension(2131165466);
      this.JuA = paramContext.getResources().getDimension(2131165576);
      this.fSL = new ArrayList();
      this.fSL.add("qmessage");
      this.KuS = fJd();
      if (!this.KuS) {
        this.fSL.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38494);
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
  
  private SparseArray<String> a(f.b<String, at> paramb, SparseArray<String> paramSparseArray, HashMap<String, at> paramHashMap)
  {
    AppMethodBeat.i(38516);
    String str = (String)paramb.object;
    int k = paramSparseArray.size();
    at localat = (at)paramb.IVq;
    int j = paramSparseArray.size();
    int i = 0;
    label39:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      ad.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i) });
      switch (paramb.IVp)
      {
      case 3: 
      case 4: 
      default: 
        if (i >= 0) {
          break label411;
        }
        ad.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
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
      if (localat == null)
      {
        ad.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
        if (i >= 0)
        {
          ad.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[] { str });
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
      while ((i < k) && (f((String)paramSparseArray.get(i), paramHashMap).field_flag > localat.field_flag)) {
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
    if (localat == null)
    {
      ad.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[] { str });
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
    long l2 = localat.field_flag;
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
      if (f((String)paramSparseArray.get(k), paramHashMap).field_flag > localat.field_flag) {
        break label666;
      }
    }
    label666:
    label765:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(-1), Boolean.valueOf(bool), Integer.valueOf(i), str });
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
  
  private void a(d paramd, am paramam)
  {
    AppMethodBeat.i(38505);
    if ((paramd.ruk) && (paramd.fVj == null))
    {
      paramd.nickName = this.context.getString(2131757293);
      AppMethodBeat.o(38505);
      return;
    }
    if (am.aSQ(paramam.field_username))
    {
      paramd.nickName = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).e(aj.getContext(), paramd.fVj, com.tencent.mm.cc.a.ax(this.context, 2131165517));
      AppMethodBeat.o(38505);
      return;
    }
    paramd.nickName = k.b(this.context, paramd.fVj, com.tencent.mm.cc.a.ax(this.context, 2131165517));
    AppMethodBeat.o(38505);
  }
  
  private static String aVK(String paramString)
  {
    AppMethodBeat.i(38511);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(paramString);
      AppMethodBeat.o(38511);
      return paramString;
    }
    AppMethodBeat.o(38511);
    return null;
  }
  
  private static int aej(int paramInt)
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
  
  private CharSequence b(at paramat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38509);
    Object localObject3 = new SpannableStringBuilder();
    if ((paramat.lQ(268435456)) && (!w.vF(paramat.field_username)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131762246));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
      ad.i("MicroMsg.ConversationWithCacheAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { paramat.field_username, Integer.valueOf(paramat.field_attrflag) });
    }
    while (((!bt.isNullOrNil(paramat.field_editingMsg)) || (paramat.field_editingQuoteMsgId != 0L)) && ((paramat.field_atCount <= 0) || ((paramat.field_unReadCount <= 0) && (paramat.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      if (!bt.isNullOrNil(paramat.field_editingMsg)) {
        ((SpannableStringBuilder)localObject1).append(" ").append(k.b(this.context, paramat.field_editingMsg, paramInt));
      }
      paramat = ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
      AppMethodBeat.o(38509);
      return paramat;
      if ((paramat.lQ(268435456)) && (w.vF(paramat.field_username)))
      {
        ad.w("MicroMsg.ConversationWithCacheAdapter", "wrong flag");
        com.tencent.mm.plugin.report.service.g.yhR.f(20435, new Object[] { Integer.valueOf(1) });
        ad.i("MicroMsg.ConversationWithCacheAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { paramat.field_username, Integer.valueOf(paramat.field_attrflag) });
      }
    }
    if (WF(paramat.field_msgType) == 10000)
    {
      boolean bool2 = w.Ad(paramat.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramat.lQ(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramat.lQ(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramat.lQ(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = w.Am(paramat.field_username);
      }
      if ((!bool2) && (paramat.field_hasTodo != 1))
      {
        if (paramat.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
        {
          ad.i("MicroMsg.ConversationWithCacheAdapter", "is transfer remind msg ");
          paramat = ((SpannableStringBuilder)localObject3).append(" ").append(k.f(this.context, paramat.field_content, paramInt));
          AppMethodBeat.o(38509);
          return paramat;
        }
        paramat = new SpannableString(k.f(this.context, paramat.field_content, paramInt));
        AppMethodBeat.o(38509);
        return paramat;
      }
    }
    Object localObject2;
    if (WF(paramat.field_msgType) == 49)
    {
      localObject1 = v.zf(paramat.field_digestUser);
      localObject2 = k.b.yr(paramat.field_content);
      if (localObject2 == null) {}
    }
    Object localObject4;
    switch (((k.b)localObject2).type)
    {
    default: 
    case 40: 
      do
      {
        localObject1 = paramat.field_digest;
        if ((localObject1 == null) || (!((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
          break;
        }
        paramat = new SpannableString(k.e(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramat;
      } while (com.tencent.mm.ai.t.yw(paramat.field_content).hDj != 19);
      if (bt.isNullOrNil((String)localObject1)) {}
      for (localObject1 = this.context.getString(2131755872);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755872))
      {
        paramat.tB((String)localObject1);
        paramat = ((SpannableStringBuilder)localObject3).append(k.b(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramat;
      }
    case 5: 
      localObject1 = null;
      try
      {
        paramat = String.format(paramat.field_digest, new Object[] { l(paramat) });
        localObject4 = new StringBuilder();
        localObject1 = paramat;
        if (bt.isNullOrNil(paramat)) {
          localObject1 = this.context.getString(2131755920);
        }
        paramat = (String)localObject1 + " " + ((k.b)localObject2).title;
        paramat = ((SpannableStringBuilder)localObject3).append(k.f(this.context, paramat, paramInt));
        AppMethodBeat.o(38509);
        return paramat;
      }
      catch (Exception paramat)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramat, "", new Object[0]);
          paramat = (at)localObject1;
        }
      }
    }
    if (bt.isNullOrNil((String)localObject1)) {}
    for (Object localObject1 = this.context.getString(2131755872);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755872))
    {
      paramat.tB((String)localObject1);
      paramat = ((SpannableStringBuilder)localObject3).append(k.b(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38509);
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
        AppMethodBeat.o(38509);
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
        AppMethodBeat.o(38509);
        return paramat;
      }
    }
    if ((paramat.field_msgType != null) && (paramat.field_msgType.equals("64")))
    {
      paramat = paramat.field_content;
      AppMethodBeat.o(38509);
      return paramat;
    }
    if ((paramat.field_msgType != null) && ((paramat.field_msgType.equals("47")) || (paramat.field_msgType.equals("1048625"))))
    {
      localObject1 = aVK(paramat.field_digest);
      localObject2 = "";
      if (!bt.isNullOrNil((String)localObject1))
      {
        paramat = ((SpannableStringBuilder)localObject3).append("[" + (String)localObject1 + "]");
        AppMethodBeat.o(38509);
        return paramat;
      }
      localObject1 = localObject2;
      if (paramat.field_digest != null)
      {
        localObject1 = localObject2;
        if (paramat.field_digest.contains(":"))
        {
          localObject2 = paramat.field_digest.substring(0, paramat.field_digest.indexOf(":"));
          localObject4 = aVK(paramat.field_digest.substring(paramat.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject2;
          if (!bt.isNullOrNil((String)localObject4))
          {
            paramat = "[" + (String)localObject4 + "]";
            if (bt.isNullOrNil((String)localObject2))
            {
              paramat = ((SpannableStringBuilder)localObject3).append(k.b(this.context, (CharSequence)localObject2, paramInt));
              AppMethodBeat.o(38509);
              return paramat;
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(k.b(this.context, (CharSequence)localObject2, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramat);
            paramat = ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
            AppMethodBeat.o(38509);
            return paramat;
          }
        }
      }
      localObject2 = this.context.getString(2131755722);
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject1 = localObject2;
        paramat.tB((String)localObject1);
      }
    }
    else
    {
      if (bt.isNullOrNil(paramat.field_digest)) {
        break label1684;
      }
      if (bt.isNullOrNil(paramat.field_digestUser)) {
        break label1673;
      }
      localObject1 = l(paramat);
    }
    label1673:
    label1684:
    String str;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramat.field_digest, new Object[] { localObject1 });
        localObject1 = ((String)localObject1).replace('\n', ' ');
        if ((!paramat.lQ(33554432)) || ((paramat.field_unReadCount <= 0) && (paramat.field_unReadMuteCount <= 0))) {
          break label1715;
        }
        paramat = new SpannableStringBuilder(this.context.getString(2131764320));
        paramat.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramat.length(), 33);
        paramat.append(" ").append(k.b(this.context, (CharSequence)localObject1, paramInt));
        paramat = ((SpannableStringBuilder)localObject3).append(paramat);
        AppMethodBeat.o(38509);
        return paramat;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject2;
      break;
      localObject1 = paramat.field_digest;
      continue;
      str = com.tencent.mm.booter.notification.a.h.a(paramat.field_isSend, paramat.field_username, paramat.field_content, WF(paramat.field_msgType), this.context);
    }
    label1715:
    if (paramat.field_UnReadInvite > 0)
    {
      if (paramat.field_UnReadInvite < 4096) {}
      for (paramat = this.context.getString(2131761045, new Object[] { Integer.valueOf(paramat.field_UnReadInvite) });; paramat = this.context.getString(2131761042))
      {
        paramat = new SpannableStringBuilder(paramat);
        paramat.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramat.length(), 33);
        paramat.append(" ").append(k.b(this.context, str, paramInt));
        AppMethodBeat.o(38509);
        return paramat;
      }
    }
    if ((paramat.field_atCount > 0) && ((paramat.field_unReadCount > 0) || (paramat.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramat.field_atCount < 4096) {
        i = 2131761044;
      }
      for (;;)
      {
        paramat = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramat.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramat.length(), 33);
        paramat.append(" ").append(k.b(this.context, str, paramInt));
        AppMethodBeat.o(38509);
        return paramat;
        if (com.tencent.mm.am.g.vd(paramat.field_username)) {
          i = 2131761043;
        } else {
          i = 2131761046;
        }
      }
    }
    if (paramat.field_hasTodo == 1)
    {
      paramat = new SpannableStringBuilder(this.context.getString(2131764449));
      paramat.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramat.length(), 33);
      paramat.append(" ").append(k.b(this.context, str, paramInt));
      AppMethodBeat.o(38509);
      return paramat;
    }
    if ((paramat.lQ(16777216)) && ((paramat.field_unReadCount > 0) || (paramat.field_unReadMuteCount > 0)))
    {
      paramat = this.context.getString(2131755033);
      str = str.replace(paramat, "");
      paramat = new SpannableStringBuilder(paramat);
      paramat.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramat.length(), 33);
      paramat.append(k.b(this.context, str, paramInt));
      paramat = ((SpannableStringBuilder)localObject3).append(paramat);
      AppMethodBeat.o(38509);
      return paramat;
    }
    if (paramat.lQ(268435456))
    {
      ((SpannableStringBuilder)localObject3).append(str.replace(this.context.getString(2131762246), ""));
      AppMethodBeat.o(38509);
      return localObject3;
    }
    if ((paramBoolean) && ((paramat.field_unReadCount > 1) || (paramat.field_unReadMuteCount > 0))) {
      paramat = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramat.field_unReadCount), str });
    }
    for (;;)
    {
      paramat = ((SpannableStringBuilder)localObject3).append(k.b(this.context, paramat, paramInt));
      AppMethodBeat.o(38509);
      return paramat;
      if ((y.bNf()) && (w.Ad(paramat.field_username)))
      {
        paramBoolean = paramat.lQ(16);
        if ((paramat.field_unReadCount > 1) || ((!paramBoolean) && (paramat.field_unReadCount > 0)))
        {
          if (paramBoolean)
          {
            if (paramat.lQ(32))
            {
              paramat = this.context.getString(2131761039, new Object[] { Integer.valueOf(paramat.field_unReadCount) });
              localObject2 = this.context.getResources().getDrawable(2131231289);
              ((Drawable)localObject2).setBounds(0, 0, paramInt, paramInt);
              localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
              localObject3 = new SpannableString("@");
              ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
              paramat = TextUtils.concat(new CharSequence[] { paramat, " ", localObject3, k.b(this.context, str, paramInt) });
              AppMethodBeat.o(38509);
              return paramat;
            }
            paramat = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramat.field_unReadCount), str });
          }
          else
          {
            paramat = this.context.getString(2131761040, new Object[] { Integer.valueOf(paramat.field_unReadCount), str });
          }
        }
        else
        {
          if (paramat.lQ(32))
          {
            paramat = this.context.getResources().getDrawable(2131231289);
            paramat.setBounds(0, 0, paramInt, paramInt);
            paramat = new com.tencent.mm.ui.widget.a(paramat);
            localObject2 = new SpannableString("@");
            ((SpannableString)localObject2).setSpan(paramat, 0, 1, 33);
            paramat = TextUtils.concat(new CharSequence[] { localObject2, k.b(this.context, str, paramInt) });
            AppMethodBeat.o(38509);
            return paramat;
          }
          paramat = str;
        }
      }
      else if ((w.An(paramat.field_username)) && ((paramat.field_unReadCount > 1) || (paramat.field_unReadMuteCount > 0)))
      {
        paramat = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramat.field_unReadCount), str });
      }
      else
      {
        if ((WF(paramat.field_msgType) == 889192497) || (WF(paramat.field_msgType) == 922746929))
        {
          paramat = j(WF(paramat.field_msgType), paramat.field_content, paramat.field_username, paramInt);
          AppMethodBeat.o(38509);
          return paramat;
        }
        paramat = str;
      }
    }
  }
  
  private at f(String paramString, HashMap<String, at> paramHashMap)
  {
    AppMethodBeat.i(38515);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (at)paramHashMap.get(paramString);
      AppMethodBeat.o(38515);
      return paramString;
    }
    if (this.IVd == null) {}
    for (paramString = null;; paramString = this.IVd.IPF.dY(paramString))
    {
      paramString = (at)paramString;
      AppMethodBeat.o(38515);
      return paramString;
    }
  }
  
  private void fID()
  {
    AppMethodBeat.i(38498);
    if (this.JuD == null)
    {
      AppMethodBeat.o(38498);
      return;
    }
    Iterator localIterator = this.JuD.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).KsI = null;
    }
    AppMethodBeat.o(38498);
  }
  
  private boolean fJa()
  {
    return this.KuV != null;
  }
  
  private void fJc()
  {
    AppMethodBeat.i(38518);
    if ((this.JuD == null) || (this.KuK == null) || (this.KuK.isEmpty()))
    {
      AppMethodBeat.o(38518);
      return;
    }
    ad.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.KuK.size()) });
    Iterator localIterator = this.KuK.iterator();
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
        if (!this.JuD.containsKey(str1)) {
          break label360;
        }
        d locald = (d)this.JuD.get(str1);
        j = i;
        if (locald == null) {
          break label360;
        }
        this.KuY.tN(str1);
        bool1 = w.vF(str1);
        am localam = this.KuY.dBn();
        if (localam != null)
        {
          String str2 = v.a(localam, str1, bool1);
          ad.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.fVj });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.fVj))
            {
              locald.fVj = str2;
              a(locald, localam);
              j = 1;
            }
          }
          boolean bool2 = localam.Pf();
          if (localam.ePs == 0)
          {
            bool1 = true;
            label269:
            if ((locald.KsO == bool2) && (bool1 == locald.KsS)) {
              break label360;
            }
            locald.KsO = bool2;
            locald.KsS = bool1;
            locald.KsT = localam.YY();
            ad.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[] { str1 });
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
      this.KuK.clear();
      AppMethodBeat.o(38518);
      return;
    }
  }
  
  private static boolean fJd()
  {
    AppMethodBeat.i(194664);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxy, false);
    ad.i("MicroMsg.ConversationWithCacheAdapter", "isShowAppBrandNotifyMsgEntry: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(194664);
    return bool;
  }
  
  private CharSequence i(at paramat)
  {
    AppMethodBeat.i(38495);
    if (paramat.field_status == 1)
    {
      paramat = this.context.getString(2131761075);
      AppMethodBeat.o(38495);
      return paramat;
    }
    if (paramat.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38495);
      return "";
    }
    paramat = com.tencent.mm.pluginsdk.i.i.c(this.context, paramat.field_conversationTime, true);
    AppMethodBeat.o(38495);
    return paramat;
  }
  
  private CharSequence j(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(194663);
    Object localObject2 = new cif();
    Object localObject1;
    if (paramInt1 == 889192497) {
      localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).auh(paramString1);
    }
    for (;;)
    {
      try
      {
        if (((cif)localObject1).vox.size() <= 0) {
          continue;
        }
        localObject1 = (cig)((cif)localObject1).vox.getLast();
        paramString1 = ((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).parseDisplayTemplate(((cig)localObject1).hEb, paramString2);
        paramString2 = new SpannableString(paramString1.result);
        localObject2 = com.tencent.mm.model.u.aAm();
        if ((!((cig)localObject1).dyU.equals(localObject2)) && (((cig)localObject1).Hcd.equals(localObject2)) && (((cig)localObject1).Hce == 0) && (!paramString1.wFI.isEmpty()))
        {
          localObject1 = new BoldForegroundColorSpan(this.context.getResources().getColor(2131099732));
          localObject2 = this.context.getString(2131766947);
          int j = paramString1.result.indexOf((String)localObject2, ((Integer)((Pair)paramString1.wFI.get(0)).second).intValue());
          int i = ((String)localObject2).length() + j;
          paramInt1 = i;
          if (i > paramString2.length()) {
            paramInt1 = paramString2.length();
          }
          paramString2.setSpan(localObject1, j, paramInt1, 17);
        }
        paramString1 = k.d(this.context, paramString2, paramInt2);
        AppMethodBeat.o(194663);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramString1, "", new Object[0]);
        AppMethodBeat.o(194663);
      }
      localObject1 = localObject2;
      if (paramInt1 == 922746929)
      {
        paramString1 = k.b.yr(paramString1);
        localObject1 = localObject2;
        if (paramString1 != null) {
          localObject1 = ((com.tencent.mm.plugin.patmsg.a.a)paramString1.ao(com.tencent.mm.plugin.patmsg.a.a.class)).wFH;
        }
      }
    }
    return "";
  }
  
  static int k(at paramat)
  {
    AppMethodBeat.i(194662);
    if ((paramat == null) || (paramat.field_unReadCount <= 0))
    {
      if (((paramat.lQ(8388608)) || (paramat.lQ(2097152))) && (paramat.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(194662);
        return 1;
      }
      AppMethodBeat.o(194662);
      return 0;
    }
    if (w.Ad(paramat.field_username))
    {
      if ((y.bNf()) && (!paramat.lQ(16)) && (!paramat.lQ(64)))
      {
        AppMethodBeat.o(194662);
        return 0;
      }
      AppMethodBeat.o(194662);
      return 1;
    }
    if (w.Ai(paramat.field_username))
    {
      com.tencent.mm.model.ba.aBQ();
      if (!com.tencent.mm.model.c.ajl().getBoolean(al.a.Iwg, true))
      {
        AppMethodBeat.o(194662);
        return 1;
      }
    }
    if (w.Am(paramat.field_username))
    {
      com.tencent.mm.model.ba.aBQ();
      if (!com.tencent.mm.model.c.ajl().getBoolean(al.a.Iwh, true))
      {
        AppMethodBeat.o(194662);
        return 1;
      }
    }
    com.tencent.mm.model.ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(paramat.field_username);
    if ((localam != null) && ((int)localam.gfj != 0))
    {
      if ((localam.Pf()) && (localam.YY()))
      {
        AppMethodBeat.o(194662);
        return 1;
      }
      if ((w.vF(paramat.field_username)) && (localam.ePs == 0))
      {
        AppMethodBeat.o(194662);
        return 1;
      }
    }
    if (w.An(paramat.field_username))
    {
      AppMethodBeat.o(194662);
      return 1;
    }
    AppMethodBeat.o(194662);
    return 2;
  }
  
  private static String l(at paramat)
  {
    AppMethodBeat.i(38510);
    if ((paramat.field_isSend == 0) && (w.vF(paramat.field_username)))
    {
      paramat = v.getDisplayName(paramat.field_digestUser, paramat.field_username);
      AppMethodBeat.o(38510);
      return paramat;
    }
    paramat = v.zf(paramat.field_digestUser);
    AppMethodBeat.o(38510);
    return paramat;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38517);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38517);
      return;
    }
    String str = (String)paramObject;
    if ((paramn instanceof bq))
    {
      ad.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
      if ((!str.contains("@")) || (str.endsWith("@chatroom")) || (str.endsWith("@im.chatroom")) || (str.endsWith("@micromsg.qq.com")) || (am.aSQ(str))) {}
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.JuD != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.KuQ = true;
            super.n(null, 1);
            AppMethodBeat.o(38517);
          }
        }
        else {
          this.KuP.add(str);
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
    if ((paramn instanceof bp))
    {
      ad.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (!bt.isNullOrNil(str))
      {
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(str);
        if ((paramn != null) && ((int)paramn.gfj > 0)) {
          ad.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(paramn.Pf()), Integer.valueOf(paramn.ePs) });
        }
      }
      if (this.vdz)
      {
        AppMethodBeat.o(38517);
        return;
      }
      this.KuO = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if ((this.JuD == null) || (!this.JuD.containsKey(str)))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.KuK != null) {
        this.KuK.add(str);
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
    if (this.KuV != null)
    {
      ad.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(38500);
      return;
    }
    ad.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.KuV = paramString;
    f localf = (f)paramView.getTag();
    int j = paramView.getContext().getResources().getColor(2131099736);
    Resources localResources = paramView.getContext().getResources();
    if ((localf != null) && (localf.JuH)) {}
    for (int i = 2131099651;; i = 2131099650)
    {
      this.Ofs = new ColorDrawable(ao.v(j, localResources.getColor(i)));
      paramView.setBackground(this.Ofs);
      if (w.An(paramString))
      {
        paramView = (at)abj(paramInt);
        paramString = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        com.tencent.mm.kernel.g.ajA();
        paramString.KW(bt.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
        paramString.a(new g.a(paramView.field_unReadCount, paramInt + 1));
      }
      AppMethodBeat.o(38500);
      return;
    }
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, at>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(38514);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.g.ajx()))
    {
      AppMethodBeat.o(38514);
      return paramArrayOfSparseArray;
    }
    ad.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[] { Integer.valueOf(paramHashSet.size()), Integer.valueOf(paramArrayOfSparseArray[0].size()) });
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (f.b)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((f.b)localObject3).IVp != 5) && (!((ArrayList)localObject1).contains(((f.b)localObject3).object)))
      {
        ad.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((f.b)localObject3).object);
        ((ArrayList)localObject1).add(((f.b)localObject3).object);
      }
    }
    localObject2 = new HashMap();
    com.tencent.mm.model.ba.aBQ();
    Object localObject3 = com.tencent.mm.model.c.azv().a((ArrayList)localObject1, w.hFd, this.fSL, com.tencent.mm.p.a.gfl);
    Object localObject4;
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = new at();
      ((at)localObject4).convertFrom((Cursor)localObject3);
      ((HashMap)localObject2).put(((com.tencent.mm.g.c.ba)localObject4).field_username, localObject4);
    }
    ((Cursor)localObject3).close();
    localObject3 = paramHashSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (f.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((f.b)localObject4).IVp != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((f.b)localObject4).object).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((f.b)localObject4).object) == null) {}
          for (boolean bool = true;; bool = false)
          {
            ad.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((f.b)localObject4).IVq = ((HashMap)localObject2).get(((f.b)localObject4).object);
            break;
          }
        }
        ((f.b)localObject4).IVq = null;
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
        if (((f.b)localObject2).IVp != 5) {
          ((HashMap)localObject1).put(((f.b)localObject2).object, ((f.b)localObject2).IVq);
        }
      }
    }
    AppMethodBeat.o(38514);
    return paramArrayOfSparseArray;
  }
  
  public final ArrayList<at> aV(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(38513);
    ad.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    com.tencent.mm.model.ba.aBQ();
    paramArrayList = com.tencent.mm.model.c.azv().a(paramArrayList, w.hFd, this.fSL, com.tencent.mm.p.a.gfl);
    while (paramArrayList.moveToNext())
    {
      at localat = new at();
      localat.convertFrom(paramArrayList);
      localArrayList.add(localat);
    }
    paramArrayList.close();
    AppMethodBeat.o(38513);
    return localArrayList;
  }
  
  public final void aew(int paramInt)
  {
    AppMethodBeat.i(38501);
    if (!fJa())
    {
      ad.i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
      AppMethodBeat.o(38501);
      return;
    }
    com.tencent.mm.sdk.platformtools.aq.o(new Runnable()
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
  
  public final void aex(int paramInt)
  {
    AppMethodBeat.i(38521);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(38521);
      return;
    }
    try
    {
      at localat = (at)abj(paramInt);
      if (localat == null)
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
        ad.w("MicroMsg.ConversationWithCacheAdapter", "preLoad position:%s is null!", new Object[] { Integer.valueOf(paramInt) });
        localObject = null;
      }
      a.b.fbx().fg(localObject.field_username);
      AppMethodBeat.o(38521);
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(38508);
    if (this.JuD != null)
    {
      this.JuD.clear();
      this.KuQ = true;
    }
    AppMethodBeat.o(38508);
  }
  
  public final void fHE()
  {
    boolean bool1 = true;
    AppMethodBeat.i(38496);
    if (this.fSL == null) {
      this.fSL = new ArrayList();
    }
    this.fSL.clear();
    int i;
    if ((com.tencent.mm.model.u.aAq() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = com.tencent.mm.model.u.aAH();
      if ((i == 0) || (!bool2)) {
        break label198;
      }
      label59:
      if (bool1 != this.KuR)
      {
        if (!bool1) {
          break label203;
        }
        com.tencent.mm.model.ba.aBQ();
        a(5, (n)com.tencent.mm.model.c.azv(), "floatbottle");
        label89:
        this.KuR = bool1;
      }
      if (this.KuR) {
        this.fSL.add("floatbottle");
      }
      this.fSL.add("qmessage");
      bool1 = fJd();
      if (bool1 != this.KuS)
      {
        if (!bool1) {
          break label224;
        }
        com.tencent.mm.model.ba.aBQ();
        a(2, (n)com.tencent.mm.model.c.azv(), "appbrand_notify_message");
      }
    }
    for (;;)
    {
      this.KuS = bool1;
      if (!this.KuS) {
        this.fSL.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38496);
      return;
      i = 0;
      break;
      label198:
      bool1 = false;
      break label59;
      label203:
      com.tencent.mm.model.ba.aBQ();
      a(2, (n)com.tencent.mm.model.c.azv(), "floatbottle");
      break label89;
      label224:
      com.tencent.mm.model.ba.aBQ();
      a(5, (n)com.tencent.mm.model.c.azv(), "appbrand_notify_message");
    }
  }
  
  public final void fJb()
  {
    AppMethodBeat.i(38502);
    super.n(null, 1);
    AppMethodBeat.o(38502);
  }
  
  public final boolean ftJ()
  {
    AppMethodBeat.i(38519);
    boolean bool = super.ftJ();
    AppMethodBeat.o(38519);
    return bool;
  }
  
  public final com.tencent.mm.storagebase.a.d fvj()
  {
    AppMethodBeat.i(38512);
    ad.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)com.tencent.mm.model.c.azv().a(w.hFd, this.fSL, com.tencent.mm.p.a.gfl, true);
    AppMethodBeat.o(38512);
    return locald;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38503);
    this.Kva = new a((byte)0);
    at localat = (at)abj(paramInt);
    String str = localat.field_username;
    this.KuY.tN(str);
    Object localObject1;
    int i;
    Object localObject3;
    label249:
    label505:
    boolean bool1;
    if (this.KuM.containsKey(str))
    {
      if (paramInt != ((Integer)this.KuM.get(str)).intValue())
      {
        localObject1 = fvk();
        int k;
        if (this.IVd == null)
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
              paramViewGroup = this.IVd.IPF.ftI();
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
              ((StringBuffer)localObject2).append(((at)((Map.Entry)localObject3).getValue()).field_username);
            }
            ((StringBuffer)localObject2).append("]");
          }
          ((StringBuffer)localObject2).append("\n");
        }
        localObject1 = ((StringBuffer)localObject2).toString();
        localObject2 = this.KuM.toString();
        if (paramViewGroup == null) {
          break label2251;
        }
        i = paramViewGroup.size();
        ad.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject1, str, Integer.valueOf(paramInt), localObject2, Integer.valueOf(i) });
        if (!this.KuL)
        {
          com.tencent.mm.plugin.fts.a.e.GN(20);
          this.KuL = true;
        }
        if (System.currentTimeMillis() - this.Kvb > 3600000L)
        {
          super.n(null, 1);
          this.Kvb = System.currentTimeMillis();
        }
      }
      if (paramView != null) {
        break label2295;
      }
      localObject1 = new f();
      if (!com.tencent.mm.cc.a.io(this.context)) {
        break label2274;
      }
      com.tencent.mm.kiss.a.b.akC();
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if ((i.g(i.this) == null) || (i.g(i.this).getOnItemClickListener() == null))
          {
            ad.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          if (paramAnonymousView.getTag() == null)
          {
            ad.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          if (!i.this.JGF)
          {
            ad.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if ((i.g(i.this) == null) || (i.g(i.this).getOnItemLongClickListener() == null))
          {
            ad.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          if (paramAnonymousView.getTag() == null)
          {
            ad.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          if (!i.this.JGF)
          {
            ad.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
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
      ((f)localObject1).fOf = ((ImageView)paramView.findViewById(2131297008));
      a.b.c(((f)localObject1).fOf, str);
      paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)((f)localObject1).fOf.getDrawable();
      if (this.Kss != null) {
        this.Kss.a(paramViewGroup);
      }
      ((f)localObject1).fOf.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(38491);
          this.Kvh.fOf.getViewTreeObserver().removeOnPreDrawListener(this);
          int i = this.Kvh.fOf.getWidth();
          int j = com.tencent.mm.ui.aq.ay(i.h(i.this), 2131165508);
          if (i != j)
          {
            ad.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Kvh.fOf.getLayoutParams();
            localLayoutParams.width = j;
            localLayoutParams.height = j;
            this.Kvh.fOf.setLayoutParams(localLayoutParams);
            ad.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", new Object[] { Integer.valueOf(this.Kvh.fOf.getWidth()) });
            if (!i.i(i.this))
            {
              com.tencent.mm.plugin.report.e.ygI.idkeyStat(1055L, 4L, 1L, false);
              ad.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
              i.j(i.this);
            }
          }
          AppMethodBeat.o(38491);
          return true;
        }
      });
      ((f)localObject1).JuK = ((NoMeasuredTextView)paramView.findViewById(2131302867));
      ((f)localObject1).JuK.setLayoutCallback(this.KuT);
      ((f)localObject1).JuL = ((NoMeasuredTextView)paramView.findViewById(2131306207));
      ((f)localObject1).Kvq = ((ImageView)paramView.findViewById(2131301312));
      ((f)localObject1).JuM = ((NoMeasuredTextView)paramView.findViewById(2131301311));
      ((f)localObject1).nUD = ((TextView)paramView.findViewById(2131305882));
      ((f)localObject1).Kvr = ((WeImageView)paramView.findViewById(2131300954));
      ((f)localObject1).JuP = paramView.findViewById(2131297015);
      ((f)localObject1).KsX = ((ImageView)paramView.findViewById(2131301541));
      ((f)localObject1).Kvs = ((ImageView)paramView.findViewById(2131302581));
      ((f)localObject1).nUD.setBackgroundResource(com.tencent.mm.ui.tools.u.kE(this.context));
      ((f)localObject1).nUD.setTextSize(0, com.tencent.mm.cc.a.ay(this.context, 2131166949) * com.tencent.mm.cc.a.ik(this.context));
      ((f)localObject1).Kvt = new c();
      paramView.setTag(localObject1);
      ((f)localObject1).JuM.setTextSize(0, com.tencent.mm.cc.a.ax(this.context, 2131165574));
      ((f)localObject1).JuL.setTextSize(0, com.tencent.mm.cc.a.ax(this.context, 2131165576));
      ((f)localObject1).JuK.setTextSize(0, com.tencent.mm.cc.a.ax(this.context, 2131165517));
      this.KuZ = ((f)localObject1).JuK.getTextSize();
      ((f)localObject1).JuM.setTextColor(this.JuB[0]);
      ((f)localObject1).JuL.setTextColor(this.JuB[4]);
      ((f)localObject1).JuK.setTextColor(this.JuB[3]);
      ((f)localObject1).JuM.setShouldEllipsize(true);
      ((f)localObject1).JuL.setShouldEllipsize(false);
      ((f)localObject1).JuK.setShouldEllipsize(true);
      if (((f)localObject1).JuK.getPaint() != null) {
        al.a(((f)localObject1).JuK.getPaint(), 0.1F);
      }
      ((f)localObject1).JuL.setGravity(5);
      paramViewGroup = paramView;
      label1036:
      localObject3 = j(localat);
      ((f)localObject1).position = paramInt;
      ((f)localObject1).username = str;
      if ((!((d)localObject3).JuH) || (localat.field_conversationTime == -1L)) {
        break label2309;
      }
      bool1 = true;
      label1080:
      ((f)localObject1).JuH = bool1;
      if (((d)localObject3).KsJ == null) {
        ((d)localObject3).KsJ = b(localat, (int)((f)localObject1).JuM.getTextSize(), ((d)localObject3).KsQ);
      }
      if ((w.Ad(localat.field_username)) && (((d)localObject3).KsJ != null))
      {
        paramView = d.Ksp;
        if (d.fIC())
        {
          paramView = com.tencent.mm.storage.t.Ioj;
          com.tencent.mm.storage.t.aP(((d)localObject3).KsJ.toString(), paramInt, localat.field_unReadCount);
          paramView = com.tencent.mm.plugin.brandservice.b.c.nWy;
          com.tencent.mm.plugin.brandservice.b.c.s(1, "", "");
        }
      }
      if (((d)localObject3).KsI == null) {
        ((d)localObject3).KsI = i(localat);
      }
      if (!((d)localObject3).KsQ) {
        break label2315;
      }
      ((f)localObject1).JuM.setTextColor(this.JuB[0]);
      label1225:
      com.tencent.mm.booter.notification.a.h.kY(((f)localObject1).JuM.getWidth());
      com.tencent.mm.booter.notification.a.h.kZ((int)((f)localObject1).JuM.getTextSize());
      com.tencent.mm.booter.notification.a.h.b(((f)localObject1).JuM.getPaint());
      if ((!w.zl(str)) && (!w.zn(str))) {
        break label2336;
      }
      ((f)localObject1).JuK.setCompoundRightDrawablesWithIntrinsicBounds(2131691000);
      ((f)localObject1).JuK.setDrawRightDrawable(true);
      label1295:
      i = ((d)localObject3).KsK;
      if (i == -1) {
        break label2359;
      }
      ((f)localObject1).JuM.setCompoundLeftDrawablesWithIntrinsicBounds(i);
      ((f)localObject1).JuM.setDrawLeftDrawable(true);
      ad.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((d)localObject3).KsK) });
      label1355:
      if (!am.aSQ(localat.field_username)) {
        break label2393;
      }
      this.KuY.tN(localat.field_username);
      Object localObject4 = this.KuY.dBn();
      paramView = "";
      if (localObject4 != null) {
        paramView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bC(((aw)localObject4).field_openImAppid, ((aw)localObject4).field_descWordingId);
      }
      if (bt.isNullOrNil(paramView)) {
        break label2379;
      }
      Object localObject2 = paramView;
      if ("3552365301".equals(((aw)localObject4).field_openImAppid)) {
        localObject2 = "@".concat(String.valueOf(paramView));
      }
      ((f)localObject1).JuK.aT((String)localObject2, 2131100528, 14);
      label1471:
      ((f)localObject1).JuK.setText(((d)localObject3).nickName);
      paramView = ((f)localObject1).JuL.getLayoutParams();
      if (((d)localObject3).KsI.length() < 9) {
        break label2416;
      }
      if (paramView.width != this.KsB)
      {
        paramView.width = this.KsB;
        ((f)localObject1).JuL.setLayoutParams(paramView);
      }
      label1536:
      ((f)localObject1).JuL.setText(((d)localObject3).KsI);
      ((f)localObject1).JuM.setText(((d)localObject3).KsJ);
      if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localat, 7, 0L) <= 0L) {
        break label2447;
      }
      bool1 = true;
      label1578:
      localObject2 = localat.field_username;
      long l1 = localat.field_conversationTime;
      localObject4 = ((d)localObject3).KsI;
      boolean bool2 = ((f)localObject1).JuH;
      long l2 = localat.field_flag;
      long l3 = localat.field_flag;
      if ((((d)localObject3).nickName != null) && (((d)localObject3).nickName.length() > 0)) {
        break label2453;
      }
      paramView = "?";
      label1645:
      ad.i("MicroMsg.ConversationWithCacheAdapter", "[getView] position=%s username=%s conversationTime=%s updateTime=%s isPlacedTop=%s isTalkRoomTopPlace=%s flag=%s flagTime=%s nickname=%s", new Object[] { Integer.valueOf(paramInt), localObject2, Long.valueOf(l1), localObject4, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3 & 0xFFFFFFFF), paramView });
      if ((bool1) && (0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localat, 7, 0L)))
      {
        localat.qv(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localat, 6, localat.field_conversationTime));
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().a(localat, localat.field_username);
      }
      ((f)localObject1).Kvq.setVisibility(8);
      ((f)localObject1).Kvr.setVisibility(8);
      if (!((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).ajz(str)) {
        break label2471;
      }
      ((f)localObject1).Kvr.setVisibility(0);
      ((f)localObject1).Kvr.setImageDrawable(ao.k(this.context, 2131690531, this.context.getResources().getColor(2131099982)));
      label1860:
      a.b.c(((f)localObject1).fOf, str);
      if (this.Ksq)
      {
        ad.i("MicroMsg.ConversationWithCacheAdapter", "handleShowTipCnt.");
        if ((localat != null) && (localObject1 != null) && (localObject3 != null)) {
          break label2550;
        }
        ad.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
      }
      label1908:
      if ((!((d)localObject3).KsN) && (((d)localObject3).JuH) && (com.tencent.mm.model.ba.ajx()))
      {
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().g(localat);
      }
      if ((this.KuV == null) || (!this.KuV.equals(str))) {
        break label2803;
      }
      ad.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), this.KuV });
      paramViewGroup.findViewById(2131298792).setBackground(this.Ofs);
      label2007:
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            paramAnonymousView.findViewById(2131298792).getBackground().setHotspot(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(38483);
            return false;
          }
        });
      }
      if ((com.tencent.mm.bj.d.iru == null) || (!com.tencent.mm.bj.d.iru.GK(localat.field_username))) {
        break label2855;
      }
      ((f)localObject1).KsX.setVisibility(0);
      label2064:
      if ((!w.vF(localat.field_username)) || (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class) == null) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).ari(localat.field_username))) {
        break label2902;
      }
      if ((!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).doZ()) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).hW(localat.field_username, com.tencent.mm.model.u.aAm()))) {
        break label2868;
      }
      ((f)localObject1).Kvs.setImageResource(2131689895);
      label2159:
      ((f)localObject1).Kvs.setVisibility(0);
    }
    for (;;)
    {
      this.Kva.content = String.valueOf(((d)localObject3).KsJ);
      this.Kva.bVF = ((d)localObject3).fVj;
      this.Kva.time = String.valueOf(((d)localObject3).KsI);
      paramView = this.Kva;
      a.a.fyf().a(paramViewGroup, paramView.bVF, paramView.KsH, paramView.time, paramView.content);
      paramViewGroup.setAlpha(1.0F);
      AppMethodBeat.o(38503);
      return paramViewGroup;
      label2251:
      i = 0;
      break;
      this.KuM.put(str, Integer.valueOf(paramInt));
      break label505;
      label2274:
      com.tencent.mm.kiss.a.b.akC();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493664);
      break label546;
      label2295:
      localObject1 = (f)paramView.getTag();
      paramViewGroup = paramView;
      break label1036;
      label2309:
      bool1 = false;
      break label1080;
      label2315:
      ((f)localObject1).JuM.setTextColor(this.JuB[localObject3.oIb]);
      break label1225;
      label2336:
      if (!((f)localObject1).JuK.Jqb) {
        break label1295;
      }
      ((f)localObject1).JuK.setDrawRightDrawable(false);
      break label1295;
      label2359:
      ((f)localObject1).JuM.setDrawLeftDrawable(false);
      ((f)localObject1).JuM.invalidate();
      break label1355;
      label2379:
      ((f)localObject1).JuK.aT(null, 0, 0);
      break label1471;
      label2393:
      w.zl(localat.field_username);
      ((f)localObject1).JuK.aT(null, 0, 0);
      break label1471;
      label2416:
      if (paramView.width == this.KsA) {
        break label1536;
      }
      paramView.width = this.KsA;
      ((f)localObject1).JuL.setLayoutParams(paramView);
      break label1536;
      label2447:
      bool1 = false;
      break label1578;
      label2453:
      paramView = Character.valueOf(((d)localObject3).nickName.charAt(0));
      break label1645;
      label2471:
      ((f)localObject1).Kvr.setImageDrawable(ao.k(this.context, 2131690523, this.context.getResources().getColor(2131099982)));
      if (((d)localObject3).ruk)
      {
        if (!((d)localObject3).KsS) {
          break label1860;
        }
        ((f)localObject1).Kvr.setVisibility(0);
        break label1860;
      }
      if (!((d)localObject3).KsO) {
        break label1860;
      }
      ((f)localObject1).Kvr.setVisibility(0);
      break label1860;
      label2550:
      ((f)localObject1).nUD.setVisibility(4);
      ((f)localObject1).JuP.setVisibility(4);
      if ((!w.zv(localat.field_username)) && (((d)localObject3).KsR) && ((((d)localObject3).KsM == 1) || (((d)localObject3).KsM == 2) || (((d)localObject3).KsM == 3))) {}
      for (paramView = this.JuB[2];; paramView = this.JuB[3])
      {
        ((f)localObject1).JuK.setTextColor(paramView);
        if ((!((d)localObject3).KsR) || (((d)localObject3).KsL == 0)) {
          ad.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
        }
        paramInt = k(localat);
        if (paramInt != 1) {
          break label2687;
        }
        ((f)localObject1).JuP.setVisibility(0);
        break;
      }
      label2687:
      if (paramInt != 2) {
        break label1908;
      }
      paramInt = localat.field_unReadCount;
      if (paramInt > 99)
      {
        ((f)localObject1).nUD.setText("");
        ((f)localObject1).nUD.setBackgroundResource(2131689744);
        ((f)localObject1).nUD.setVisibility(0);
      }
      for (;;)
      {
        this.Kva.KsH = paramInt;
        break;
        if (paramInt > 0)
        {
          ((f)localObject1).nUD.setText(localat.field_unReadCount);
          ((f)localObject1).nUD.setVisibility(0);
          ((f)localObject1).nUD.setBackgroundResource(com.tencent.mm.ui.tools.u.aP(this.context, paramInt));
        }
      }
      label2803:
      if ((((d)localObject3).JuH) && (localat.field_conversationTime != -1L))
      {
        paramViewGroup.findViewById(2131298792).setBackgroundResource(2131232872);
        break label2007;
      }
      paramViewGroup.findViewById(2131298792).setBackgroundResource(2131231854);
      break label2007;
      label2855:
      ((f)localObject1).KsX.setVisibility(8);
      break label2064;
      label2868:
      ((f)localObject1).Kvs.setImageDrawable(ao.k(this.context, 2131690409, this.context.getResources().getColor(2131099982)));
      break label2159;
      label2902:
      ((f)localObject1).Kvs.setVisibility(8);
    }
  }
  
  final d j(at paramat)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38504);
    String str2 = paramat.field_username;
    Object localObject;
    if (this.JuD != null)
    {
      localObject = (d)this.JuD.get(str2);
      if (localObject != null)
      {
        AppMethodBeat.o(38504);
        return localObject;
      }
    }
    d locald = new d((byte)0);
    this.KuY.tN(str2);
    am localam = this.KuY.dBn();
    if (localam != null)
    {
      locald.KsM = localam.ePC;
      locald.KsL = ((int)localam.gfj);
      if (localam == null) {
        break label532;
      }
      bool1 = true;
      label111:
      locald.KsR = bool1;
      if ((localam == null) || (!localam.YY())) {
        break label537;
      }
      bool1 = true;
      label132:
      locald.KsT = bool1;
      if ((localam == null) || (localam.ePs != 0)) {
        break label542;
      }
      bool1 = true;
      label153:
      locald.KsS = bool1;
      locald.ruk = w.zj(str2);
      if ((!locald.ruk) || (!locald.KsS) || (paramat.field_unReadCount <= 0)) {
        break label547;
      }
      bool1 = true;
      label194:
      locald.KsQ = bool1;
      locald.oIb = 0;
      if ((WF(paramat.field_msgType) == 34) && (paramat.field_isSend == 0) && (!bt.isNullOrNil(paramat.field_content)))
      {
        String str1 = paramat.field_content;
        if ((!str2.equals("qmessage")) && (!str2.equals("floatbottle")) && (!str2.equals("officialaccounts")) && (!paramat.lQ(2097152)))
        {
          localObject = str1;
          if (!paramat.lQ(8388608)) {}
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
        if (!new p((String)localObject).itZ) {
          locald.oIb = 1;
        }
      }
      locald.fVj = v.a(localam, str2, locald.ruk);
      a(locald, localam);
      locald.KsI = i(paramat);
      locald.KsK = aej(paramat.field_status);
      locald.KsN = w.a(paramat);
      com.tencent.mm.model.ba.aBQ();
      locald.JuH = com.tencent.mm.model.c.azv().h(paramat);
      if ((localam == null) || (!localam.Pf())) {
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
      locald.KsO = bool1;
      if (this.JuD != null) {
        this.JuD.put(str2, locald);
      }
      AppMethodBeat.o(38504);
      return locald;
      locald.KsM = -1;
      locald.KsL = -1;
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
    if (!this.Kvd)
    {
      super.notifyDataSetChanged();
      this.KuM.clear();
    }
    ad.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    AppMethodBeat.o(38522);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38497);
    ad.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.JGF);
    if (!this.JGF)
    {
      AppMethodBeat.o(38497);
      return;
    }
    this.JGF = false;
    super.pause();
    if (this.nUz != null) {
      this.nUz.deC();
    }
    AppMethodBeat.o(38497);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(38499);
    ad.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.JGF);
    if (this.JGF)
    {
      AppMethodBeat.o(38499);
      return;
    }
    this.JGF = true;
    fHE();
    fJc();
    ad.i(this.TAG, "newcursor resume syncNow ");
    this.IVc = true;
    lR(true);
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.i.h.a("MM/dd", (Time)localObject).toString();
    String str = com.tencent.mm.sdk.platformtools.ac.fks();
    if ((!this.Ksy.equals(localObject)) || (!this.KuU.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.Ksy = ((String)localObject);
      this.KuU = str;
      if (i != 0) {
        fID();
      }
      if ((this.Kst) && (this.KuJ != null))
      {
        this.KuJ.fJe();
        this.Kst = false;
        super.n(null, 1);
      }
      AppMethodBeat.o(38499);
      return;
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
  
  public static abstract interface b
  {
    public abstract void fJe();
  }
  
  final class c
  {
    public View JmB = null;
    boolean Kvi = false;
    boolean Kvj = false;
    boolean Kvk = false;
    boolean Kvl = false;
    boolean Kvm = false;
    public ImageView Kvn = null;
    public TextView Kvo = null;
    public View Kvp = null;
    public View nUE = null;
    public TextView nUF = null;
    String username = "";
    
    c() {}
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
    public boolean KsQ;
    public boolean KsR;
    public boolean KsS;
    public boolean KsT;
    public String fVj;
    public CharSequence nickName;
    public int oIb;
    public boolean ruk;
    
    private d() {}
  }
  
  final class e
  {
    private Integer KsV = null;
    private am contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final am dBn()
    {
      AppMethodBeat.i(38493);
      if ((this.initialized) && (this.contact == null) && (com.tencent.mm.model.ba.ajx()))
      {
        com.tencent.mm.model.ba.aBQ();
        this.contact = com.tencent.mm.model.c.azp().Bf(this.talker);
      }
      am localam = this.contact;
      AppMethodBeat.o(38493);
      return localam;
    }
    
    public final void tN(String paramString)
    {
      AppMethodBeat.i(38492);
      this.talker = paramString;
      this.contact = null;
      this.KsV = null;
      this.initialized = false;
      if (!bt.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(38492);
    }
  }
  
  public static final class f
  {
    public boolean JuH;
    public NoMeasuredTextView JuK;
    public NoMeasuredTextView JuL;
    public NoMeasuredTextView JuM;
    public View JuP;
    public ImageView KsX;
    public ImageView Kvq;
    public WeImageView Kvr;
    public ImageView Kvs;
    public i.c Kvt;
    public ImageView fOf;
    public TextView nUD;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */