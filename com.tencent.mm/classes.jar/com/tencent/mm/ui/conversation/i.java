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
import com.tencent.mm.ai.t;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class i
  extends com.tencent.mm.ui.f<String, com.tencent.mm.storage.am>
  implements n.b
{
  k.a FSm;
  private float GgQ;
  private float GgT;
  private float GgU;
  private ColorStateList[] GgV;
  HashMap<String, d> GgX;
  public boolean GsE;
  private boolean Hbd;
  com.tencent.mm.pluginsdk.ui.d Hbf;
  private boolean Hbg;
  com.tencent.mm.sdk.b.c Hbj;
  public String Hbl;
  private final int Hbn;
  private final int Hbo;
  boolean HdA;
  private boolean HdB;
  private boolean HdC;
  private NoMeasuredTextView.c HdD;
  public String HdE;
  private String HdF;
  private Drawable HdG;
  ValueAnimator HdH;
  final e HdI;
  private float HdJ;
  private a HdK;
  private long HdL;
  private boolean HdM;
  boolean HdN;
  private boolean Hdr;
  private vj Hds;
  b Hdt;
  private HashSet<String> Hdu;
  private boolean Hdv;
  HashMap<String, Integer> Hdw;
  private HashMap<String, Integer> Hdx;
  boolean Hdy;
  HashSet<String> Hdz;
  protected List<String> fvP;
  private boolean inh;
  private ListView mListView;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.d mRn;
  boolean sSE;
  boolean xmM;
  
  public i(Context paramContext, ListView paramListView, f.a parama)
  {
    super(paramContext, (short)0);
    AppMethodBeat.i(38494);
    this.fvP = null;
    this.GgV = new ColorStateList[5];
    this.Hbd = true;
    this.Hdr = false;
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    this.Hds = null;
    this.inh = false;
    this.GgQ = -1.0F;
    this.GgT = -1.0F;
    this.GgU = -1.0F;
    this.Hbg = false;
    this.Hbj = null;
    this.Hdt = null;
    this.GsE = false;
    this.Hdv = false;
    this.Hdw = new HashMap();
    this.Hdx = new HashMap();
    this.Hdy = false;
    this.HdA = false;
    this.HdB = false;
    this.HdC = false;
    this.HdD = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38482);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.cd.a.fromDPToPix(i.a(i.this), paramAnonymousInt2);
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
          paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.span.k.c(i.b(i.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.cd.a.m(i.c(i.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(38482);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.Hbl = "";
    this.HdE = "";
    this.FSm = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(38488);
        i.this.notifyDataSetChanged();
        AppMethodBeat.o(38488);
      }
    };
    this.HdI = new e();
    this.xmM = false;
    this.HdJ = -1.0F;
    this.HdL = 0L;
    this.HdM = false;
    this.sSE = false;
    this.HdN = false;
    this.mListView = paramListView;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.GgV[0] = com.tencent.mm.cd.a.m(paramContext, 2131100490);
    this.GgV[1] = com.tencent.mm.cd.a.m(paramContext, 2131100643);
    this.GgV[3] = com.tencent.mm.cd.a.m(paramContext, 2131100711);
    this.GgV[2] = com.tencent.mm.cd.a.m(paramContext, 2131099769);
    this.GgV[2] = com.tencent.mm.cd.a.m(paramContext, 2131099769);
    this.GgV[4] = com.tencent.mm.cd.a.m(paramContext, 2131100490);
    if (com.tencent.mm.cd.a.hT(paramContext))
    {
      this.Hbo = paramContext.getResources().getDimensionPixelSize(2131165246);
      this.Hbn = paramContext.getResources().getDimensionPixelSize(2131165247);
    }
    for (;;)
    {
      this.GgX = new HashMap();
      this.Hdu = new HashSet();
      this.Hdz = new HashSet();
      this.GgQ = paramContext.getResources().getDimension(2131165517);
      this.GgT = paramContext.getResources().getDimension(2131165466);
      this.GgU = paramContext.getResources().getDimension(2131165576);
      this.fvP = new ArrayList();
      this.fvP.add("qmessage");
      this.HdC = fcu();
      if (!this.HdC) {
        this.fvP.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38494);
      return;
      if (com.tencent.mm.cd.a.hS(paramContext))
      {
        this.Hbo = paramContext.getResources().getDimensionPixelSize(2131165245);
        this.Hbn = paramContext.getResources().getDimensionPixelSize(2131165247);
      }
      else
      {
        this.Hbo = paramContext.getResources().getDimensionPixelSize(2131165244);
        this.Hbn = paramContext.getResources().getDimensionPixelSize(2131165248);
      }
    }
  }
  
  private static int OV(String paramString)
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
  
  private static int ZL(int paramInt)
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
  
  static int a(com.tencent.mm.storage.am paramam, d paramd)
  {
    AppMethodBeat.i(38506);
    if ((paramam == null) || (paramam.field_unReadCount <= 0))
    {
      if ((paramam != null) && ((paramam.lw(8388608)) || (paramam.lw(2097152))) && (paramam != null) && (paramam.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(38506);
        return 1;
      }
      AppMethodBeat.o(38506);
      return 0;
    }
    if (w.td(paramam.field_username))
    {
      if ((com.tencent.mm.storage.u.bBQ()) && (!paramam.lw(16)) && (!paramam.lw(64)))
      {
        AppMethodBeat.o(38506);
        return 0;
      }
      AppMethodBeat.o(38506);
      return 1;
    }
    if (w.ti(paramam.field_username))
    {
      az.arV();
      if (!com.tencent.mm.model.c.afk().getBoolean(ae.a.FlZ, true))
      {
        AppMethodBeat.o(38506);
        return 1;
      }
    }
    if (w.tm(paramam.field_username))
    {
      az.arV();
      if (!com.tencent.mm.model.c.afk().getBoolean(ae.a.Fma, true))
      {
        AppMethodBeat.o(38506);
        return 1;
      }
    }
    if ((paramd.HbC) && (paramd.HbH))
    {
      AppMethodBeat.o(38506);
      return 1;
    }
    if ((paramd.qbC) && (paramd.HbG))
    {
      AppMethodBeat.o(38506);
      return 1;
    }
    if (w.tn(paramam.field_username))
    {
      AppMethodBeat.o(38506);
      return 1;
    }
    AppMethodBeat.o(38506);
    return 2;
  }
  
  private SparseArray<String> a(f.b<String, com.tencent.mm.storage.am> paramb, SparseArray<String> paramSparseArray, HashMap<String, com.tencent.mm.storage.am> paramHashMap)
  {
    AppMethodBeat.i(38516);
    String str = (String)paramb.object;
    int k = paramSparseArray.size();
    com.tencent.mm.storage.am localam = (com.tencent.mm.storage.am)paramb.FIR;
    int j = paramSparseArray.size();
    int i = 0;
    label39:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      ad.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i) });
      switch (paramb.FIQ)
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
      if (localam == null)
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
      while ((i < k) && (e((String)paramSparseArray.get(i), paramHashMap).field_flag > localam.field_flag)) {
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
    paramb = e(str, paramHashMap);
    if (localam == null)
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
    long l2 = localam.field_flag;
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
      if (e((String)paramSparseArray.get(k), paramHashMap).field_flag > localam.field_flag) {
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
  
  private void a(d paramd, af paramaf)
  {
    AppMethodBeat.i(38505);
    if ((paramd.qbC) && (paramd.fyo == null))
    {
      paramd.nickName = this.context.getString(2131757293);
      AppMethodBeat.o(38505);
      return;
    }
    if (af.aHH(paramaf.field_username))
    {
      paramd.nickName = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).e(aj.getContext(), paramd.fyo, com.tencent.mm.cd.a.ao(this.context, 2131165517));
      AppMethodBeat.o(38505);
      return;
    }
    paramd.nickName = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramd.fyo, com.tencent.mm.cd.a.ao(this.context, 2131165517));
    AppMethodBeat.o(38505);
  }
  
  private static String aKr(String paramString)
  {
    AppMethodBeat.i(38511);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(paramString);
      AppMethodBeat.o(38511);
      return paramString;
    }
    AppMethodBeat.o(38511);
    return null;
  }
  
  private CharSequence b(com.tencent.mm.storage.am paramam, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38509);
    if (((!bt.isNullOrNil(paramam.field_editingMsg)) || (paramam.field_editingQuoteMsgId != 0L)) && ((paramam.field_atCount <= 0) || ((paramam.field_unReadCount <= 0) && (paramam.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      if (!bt.isNullOrNil(paramam.field_editingMsg)) {
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramam.field_editingMsg, paramInt));
      }
      AppMethodBeat.o(38509);
      return localObject1;
    }
    if (OV(paramam.field_msgType) == 10000)
    {
      boolean bool2 = w.td(paramam.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramam.lw(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramam.lw(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramam.lw(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = w.tm(paramam.field_username);
      }
      if ((!bool2) && (paramam.field_hasTodo != 1))
      {
        paramam = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.e(this.context, paramam.field_content, paramInt));
        AppMethodBeat.o(38509);
        return paramam;
      }
    }
    Object localObject2;
    if (OV(paramam.field_msgType) == 49)
    {
      localObject1 = v.sh(paramam.field_digestUser);
      localObject2 = k.b.rx(paramam.field_content);
      if (localObject2 == null) {}
    }
    Object localObject3;
    switch (((k.b)localObject2).type)
    {
    default: 
    case 40: 
      do
      {
        localObject1 = paramam.field_digest;
        if ((localObject1 == null) || (!((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
          break;
        }
        paramam = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.e(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramam;
      } while (t.rC(paramam.field_content).gKA != 19);
      if (bt.isNullOrNil((String)localObject1)) {}
      for (localObject1 = this.context.getString(2131755872);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755872))
      {
        paramam.nL((String)localObject1);
        paramam = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject1, paramInt);
        AppMethodBeat.o(38509);
        return paramam;
      }
    case 5: 
      localObject1 = null;
      try
      {
        paramam = String.format(paramam.field_digest, new Object[] { k(paramam) });
        localObject3 = new StringBuilder();
        localObject1 = paramam;
        if (bt.isNullOrNil(paramam)) {
          localObject1 = this.context.getString(2131755920);
        }
        paramam = (String)localObject1 + " " + ((k.b)localObject2).title;
        paramam = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.e(this.context, paramam, paramInt));
        AppMethodBeat.o(38509);
        return paramam;
      }
      catch (Exception paramam)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramam, "", new Object[0]);
          paramam = (com.tencent.mm.storage.am)localObject1;
        }
      }
    }
    if (bt.isNullOrNil((String)localObject1)) {}
    for (Object localObject1 = this.context.getString(2131755872);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755872))
    {
      paramam.nL((String)localObject1);
      paramam = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject1, paramInt);
      AppMethodBeat.o(38509);
      return paramam;
    }
    localObject1 = paramam.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      az.arV();
      if (bt.l((Integer)com.tencent.mm.model.c.afk().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramam = this.context.getString(2131763356);
        AppMethodBeat.o(38509);
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
        AppMethodBeat.o(38509);
        return paramam;
      }
    }
    if ((paramam.field_msgType != null) && (paramam.field_msgType.equals("64")))
    {
      paramam = paramam.field_content;
      AppMethodBeat.o(38509);
      return paramam;
    }
    if ((paramam.field_msgType != null) && ((paramam.field_msgType.equals("47")) || (paramam.field_msgType.equals("1048625"))))
    {
      localObject1 = aKr(paramam.field_digest);
      localObject2 = "";
      if (!bt.isNullOrNil((String)localObject1))
      {
        paramam = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38509);
        return paramam;
      }
      localObject1 = localObject2;
      if (paramam.field_digest != null)
      {
        localObject1 = localObject2;
        if (paramam.field_digest.contains(":"))
        {
          localObject2 = paramam.field_digest.substring(0, paramam.field_digest.indexOf(":"));
          localObject3 = aKr(paramam.field_digest.substring(paramam.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject2;
          if (!bt.isNullOrNil((String)localObject3))
          {
            paramam = "[" + (String)localObject3 + "]";
            if (bt.isNullOrNil((String)localObject2))
            {
              paramam = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramInt);
              AppMethodBeat.o(38509);
              return paramam;
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramam);
            AppMethodBeat.o(38509);
            return localObject1;
          }
        }
      }
      localObject2 = this.context.getString(2131755722);
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject1 = localObject2;
        paramam.nL((String)localObject1);
      }
    }
    else
    {
      if (bt.isNullOrNil(paramam.field_digest)) {
        break label1396;
      }
      if (bt.isNullOrNil(paramam.field_digestUser)) {
        break label1385;
      }
      localObject1 = k(paramam);
    }
    label1385:
    label1396:
    String str;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramam.field_digest, new Object[] { localObject1 });
        localObject1 = ((String)localObject1).replace('\n', ' ');
        if ((!paramam.lw(33554432)) || ((paramam.field_unReadCount <= 0) && (paramam.field_unReadMuteCount <= 0))) {
          break label1427;
        }
        paramam = new SpannableStringBuilder(this.context.getString(2131764320));
        paramam.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramam.length(), 33);
        paramam.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramam;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject2;
      break;
      localObject1 = paramam.field_digest;
      continue;
      str = com.tencent.mm.booter.notification.a.h.a(paramam.field_isSend, paramam.field_username, paramam.field_content, OV(paramam.field_msgType), this.context);
    }
    label1427:
    if (paramam.field_UnReadInvite > 0)
    {
      if (paramam.field_UnReadInvite < 4096) {}
      for (paramam = this.context.getString(2131761045, new Object[] { Integer.valueOf(paramam.field_UnReadInvite) });; paramam = this.context.getString(2131761042))
      {
        paramam = new SpannableStringBuilder(paramam);
        paramam.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramam.length(), 33);
        paramam.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt));
        AppMethodBeat.o(38509);
        return paramam;
      }
    }
    if ((paramam.field_atCount > 0) && ((paramam.field_unReadCount > 0) || (paramam.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramam.field_atCount < 4096) {
        i = 2131761044;
      }
      for (;;)
      {
        paramam = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramam.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramam.length(), 33);
        paramam.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt));
        AppMethodBeat.o(38509);
        return paramam;
        if (com.tencent.mm.am.f.pc(paramam.field_username)) {
          i = 2131761043;
        } else {
          i = 2131761046;
        }
      }
    }
    if (paramam.field_hasTodo == 1)
    {
      paramam = new SpannableStringBuilder(this.context.getString(2131764449));
      paramam.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramam.length(), 33);
      paramam.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt));
      AppMethodBeat.o(38509);
      return paramam;
    }
    if ((paramam.lw(16777216)) && ((paramam.field_unReadCount > 0) || (paramam.field_unReadMuteCount > 0)))
    {
      paramam = this.context.getString(2131755033);
      str = str.replace(paramam, "");
      paramam = new SpannableStringBuilder(paramam);
      paramam.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramam.length(), 33);
      paramam.append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt));
      AppMethodBeat.o(38509);
      return paramam;
    }
    if ((paramBoolean) && ((paramam.field_unReadCount > 1) || (paramam.field_unReadMuteCount > 0))) {
      paramam = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramam.field_unReadCount), str });
    }
    for (;;)
    {
      paramam = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramam, paramInt);
      AppMethodBeat.o(38509);
      return paramam;
      if ((com.tencent.mm.storage.u.bBQ()) && (w.td(paramam.field_username)))
      {
        paramBoolean = paramam.lw(16);
        if ((paramam.field_unReadCount > 1) || ((!paramBoolean) && (paramam.field_unReadCount > 0)))
        {
          if (paramBoolean)
          {
            if (paramam.lw(32))
            {
              paramam = this.context.getString(2131761039, new Object[] { Integer.valueOf(paramam.field_unReadCount) });
              localObject2 = this.context.getResources().getDrawable(2131231289);
              ((Drawable)localObject2).setBounds(0, 0, paramInt, paramInt);
              localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
              localObject3 = new SpannableString("@");
              ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
              paramam = TextUtils.concat(new CharSequence[] { paramam, " ", localObject3, com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt) });
              AppMethodBeat.o(38509);
              return paramam;
            }
            paramam = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramam.field_unReadCount), str });
          }
          else
          {
            paramam = this.context.getString(2131761040, new Object[] { Integer.valueOf(paramam.field_unReadCount), str });
          }
        }
        else
        {
          if (paramam.lw(32))
          {
            paramam = this.context.getResources().getDrawable(2131231289);
            paramam.setBounds(0, 0, paramInt, paramInt);
            paramam = new com.tencent.mm.ui.widget.a(paramam);
            localObject2 = new SpannableString("@");
            ((SpannableString)localObject2).setSpan(paramam, 0, 1, 33);
            paramam = TextUtils.concat(new CharSequence[] { localObject2, com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt) });
            AppMethodBeat.o(38509);
            return paramam;
          }
          paramam = str;
        }
      }
      else if ((w.tn(paramam.field_username)) && ((paramam.field_unReadCount > 1) || (paramam.field_unReadMuteCount > 0)))
      {
        paramam = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramam.field_unReadCount), str });
      }
      else
      {
        paramam = str;
      }
    }
  }
  
  private com.tencent.mm.storage.am e(String paramString, HashMap<String, com.tencent.mm.storage.am> paramHashMap)
  {
    AppMethodBeat.i(38515);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (com.tencent.mm.storage.am)paramHashMap.get(paramString);
      AppMethodBeat.o(38515);
      return paramString;
    }
    paramString = (com.tencent.mm.storage.am)dU(paramString);
    AppMethodBeat.o(38515);
    return paramString;
  }
  
  private void fbX()
  {
    AppMethodBeat.i(38498);
    if (this.GgX == null)
    {
      AppMethodBeat.o(38498);
      return;
    }
    Iterator localIterator = this.GgX.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).Hbw = null;
    }
    AppMethodBeat.o(38498);
  }
  
  private boolean fcr()
  {
    return this.HdF != null;
  }
  
  private void fct()
  {
    AppMethodBeat.i(38518);
    if ((this.GgX == null) || (this.Hdu == null) || (this.Hdu.isEmpty()))
    {
      AppMethodBeat.o(38518);
      return;
    }
    ad.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.Hdu.size()) });
    Iterator localIterator = this.Hdu.iterator();
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
        if (!this.GgX.containsKey(str1)) {
          break label360;
        }
        d locald = (d)this.GgX.get(str1);
        j = i;
        if (locald == null) {
          break label360;
        }
        this.HdI.nY(str1);
        bool1 = w.pF(str1);
        af localaf = this.HdI.ddc();
        if (localaf != null)
        {
          String str2 = v.a(localaf, str1, bool1);
          ad.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.fyo });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.fyo))
            {
              locald.fyo = str2;
              a(locald, localaf);
              j = 1;
            }
          }
          boolean bool2 = localaf.Ny();
          if (localaf.evx == 0)
          {
            bool1 = true;
            label269:
            if ((locald.HbC == bool2) && (bool1 == locald.HbG)) {
              break label360;
            }
            locald.HbC = bool2;
            locald.HbG = bool1;
            locald.HbH = localaf.VG();
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
      this.Hdu.clear();
      AppMethodBeat.o(38518);
      return;
    }
  }
  
  private static boolean fcu()
  {
    AppMethodBeat.i(191722);
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppj, false);
    ad.i("MicroMsg.ConversationWithCacheAdapter", "isShowAppBrandNotifyMsgEntry: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(191722);
    return bool;
  }
  
  private CharSequence i(com.tencent.mm.storage.am paramam)
  {
    AppMethodBeat.i(38495);
    if (paramam.field_status == 1)
    {
      paramam = this.context.getString(2131761075);
      AppMethodBeat.o(38495);
      return paramam;
    }
    if (paramam.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38495);
      return "";
    }
    paramam = com.tencent.mm.pluginsdk.g.h.c(this.context, paramam.field_conversationTime, true);
    AppMethodBeat.o(38495);
    return paramam;
  }
  
  private static String k(com.tencent.mm.storage.am paramam)
  {
    AppMethodBeat.i(38510);
    if ((paramam.field_isSend == 0) && (w.pF(paramam.field_username)))
    {
      paramam = v.getDisplayName(paramam.field_digestUser, paramam.field_username);
      AppMethodBeat.o(38510);
      return paramam;
    }
    paramam = v.sh(paramam.field_digestUser);
    AppMethodBeat.o(38510);
    return paramam;
  }
  
  public final void ZM(int paramInt)
  {
    AppMethodBeat.i(38501);
    if (!fcr())
    {
      ad.i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
      AppMethodBeat.o(38501);
      return;
    }
    aq.n(new Runnable()
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
  
  public final void ZN(int paramInt)
  {
    AppMethodBeat.i(38521);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(38521);
      return;
    }
    try
    {
      com.tencent.mm.storage.am localam = (com.tencent.mm.storage.am)WQ(paramInt);
      if (localam == null)
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
      a.b.exg().ew(localObject.field_username);
      AppMethodBeat.o(38521);
    }
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
    if ((paramn instanceof bh))
    {
      ad.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
      if ((!str.contains("@")) || (str.endsWith("@chatroom")) || (str.endsWith("@im.chatroom")) || (str.endsWith("@micromsg.qq.com")) || (af.aHH(str))) {}
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.GgX != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.HdA = true;
            super.j(null, 1);
            AppMethodBeat.o(38517);
          }
        }
        else {
          this.Hdz.add(str);
        }
      }
      i = paramInt;
      if (paramInt == 3) {
        i = 2;
      }
      super.j(str, i);
      AppMethodBeat.o(38517);
      return;
    }
    if ((paramn instanceof bg))
    {
      ad.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (!bt.isNullOrNil(str))
      {
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
        if ((paramn != null) && ((int)paramn.fId > 0)) {
          ad.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(paramn.Ny()), Integer.valueOf(paramn.evx) });
        }
      }
      if (this.sSE)
      {
        AppMethodBeat.o(38517);
        return;
      }
      this.Hdy = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if ((this.GgX == null) || (!this.GgX.containsKey(str)))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.Hdu != null) {
        this.Hdu.add(str);
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
    if (this.HdF != null)
    {
      ad.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(38500);
      return;
    }
    ad.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.HdF = paramString;
    f localf = (f)paramView.getTag();
    int j = paramView.getContext().getResources().getColor(2131099736);
    Resources localResources = paramView.getContext().getResources();
    if ((localf != null) && (localf.Ghb))
    {
      i = 2131099651;
      this.HdG = new ColorDrawable(com.tencent.mm.ui.am.o(j, localResources.getColor(i)));
      paramView.setBackground(this.HdG);
      if (w.tn(paramString))
      {
        paramView = (com.tencent.mm.storage.am)WQ(paramInt);
        paramString = com.tencent.mm.plugin.report.service.h.vKh;
        if (paramView != null) {
          break label340;
        }
      }
    }
    label340:
    for (int i = 0;; i = paramView.field_unReadCount)
    {
      paramString.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt + 1), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null });
      AppMethodBeat.o(38500);
      return;
      i = 2131099650;
      break;
    }
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.am>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(38514);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.g.afw()))
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
      if ((localObject3 != null) && (((f.b)localObject3).FIQ != 5) && (!((ArrayList)localObject1).contains(((f.b)localObject3).object)))
      {
        ad.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((f.b)localObject3).object);
        ((ArrayList)localObject1).add(((f.b)localObject3).object);
      }
    }
    localObject2 = new HashMap();
    az.arV();
    Object localObject3 = com.tencent.mm.model.c.apR().a((ArrayList)localObject1, w.gMn, this.fvP, com.tencent.mm.o.a.fIf);
    Object localObject4;
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = new com.tencent.mm.storage.am();
      ((com.tencent.mm.storage.am)localObject4).convertFrom((Cursor)localObject3);
      ((HashMap)localObject2).put(((ay)localObject4).field_username, localObject4);
    }
    ((Cursor)localObject3).close();
    localObject3 = paramHashSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (f.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((f.b)localObject4).FIQ != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((f.b)localObject4).object).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((f.b)localObject4).object) == null) {}
          for (boolean bool = true;; bool = false)
          {
            ad.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((f.b)localObject4).FIR = ((HashMap)localObject2).get(((f.b)localObject4).object);
            break;
          }
        }
        ((f.b)localObject4).FIR = null;
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
        if (((f.b)localObject2).FIQ != 5) {
          ((HashMap)localObject1).put(((f.b)localObject2).object, ((f.b)localObject2).FIR);
        }
      }
    }
    AppMethodBeat.o(38514);
    return paramArrayOfSparseArray;
  }
  
  public final boolean aLz(String paramString)
  {
    AppMethodBeat.i(38520);
    if ((this.GgX == null) || (!this.GgX.containsKey(paramString)))
    {
      AppMethodBeat.o(38520);
      return true;
    }
    AppMethodBeat.o(38520);
    return false;
  }
  
  public final ArrayList<com.tencent.mm.storage.am> aM(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(38513);
    ad.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    az.arV();
    paramArrayList = com.tencent.mm.model.c.apR().a(paramArrayList, w.gMn, this.fvP, com.tencent.mm.o.a.fIf);
    while (paramArrayList.moveToNext())
    {
      com.tencent.mm.storage.am localam = new com.tencent.mm.storage.am();
      localam.convertFrom(paramArrayList);
      localArrayList.add(localam);
    }
    paramArrayList.close();
    AppMethodBeat.o(38513);
    return localArrayList;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(38508);
    if (this.GgX != null)
    {
      this.GgX.clear();
      this.HdA = true;
    }
    AppMethodBeat.o(38508);
  }
  
  public final boolean eNX()
  {
    AppMethodBeat.i(38519);
    boolean bool = super.eNX();
    AppMethodBeat.o(38519);
    return bool;
  }
  
  public final com.tencent.mm.storagebase.a.d ePx()
  {
    AppMethodBeat.i(38512);
    ad.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    az.arV();
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)com.tencent.mm.model.c.apR().a(w.gMn, this.fvP, com.tencent.mm.o.a.fIf, true);
    AppMethodBeat.o(38512);
    return locald;
  }
  
  public final void fba()
  {
    boolean bool1 = true;
    AppMethodBeat.i(38496);
    if (this.fvP == null) {
      this.fvP = new ArrayList();
    }
    this.fvP.clear();
    int i;
    if ((com.tencent.mm.model.u.aqK() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = com.tencent.mm.model.u.aqZ();
      if ((i == 0) || (!bool2)) {
        break label198;
      }
      label59:
      if (bool1 != this.HdB)
      {
        if (!bool1) {
          break label203;
        }
        az.arV();
        a(5, (n)com.tencent.mm.model.c.apR(), "floatbottle");
        label89:
        this.HdB = bool1;
      }
      if (this.HdB) {
        this.fvP.add("floatbottle");
      }
      this.fvP.add("qmessage");
      bool1 = fcu();
      if (bool1 != this.HdC)
      {
        if (!bool1) {
          break label224;
        }
        az.arV();
        a(2, (n)com.tencent.mm.model.c.apR(), "appbrand_notify_message");
      }
    }
    for (;;)
    {
      this.HdC = bool1;
      if (!this.HdC) {
        this.fvP.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38496);
      return;
      i = 0;
      break;
      label198:
      bool1 = false;
      break label59;
      label203:
      az.arV();
      a(2, (n)com.tencent.mm.model.c.apR(), "floatbottle");
      break label89;
      label224:
      az.arV();
      a(5, (n)com.tencent.mm.model.c.apR(), "appbrand_notify_message");
    }
  }
  
  public final void fcs()
  {
    AppMethodBeat.i(38502);
    super.j(null, 1);
    AppMethodBeat.o(38502);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38503);
    this.HdK = new a((byte)0);
    com.tencent.mm.storage.am localam = (com.tencent.mm.storage.am)WQ(paramInt);
    String str = localam.field_username;
    this.HdI.nY(str);
    Object localObject1;
    int i;
    Object localObject3;
    label249:
    label505:
    boolean bool1;
    if (this.Hdw.containsKey(str))
    {
      if (paramInt != ((Integer)this.Hdw.get(str)).intValue())
      {
        localObject1 = ePy();
        int k;
        if (this.FIE == null)
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
              paramViewGroup = this.FIE.FDm.eNW();
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
              ((StringBuffer)localObject2).append(((com.tencent.mm.storage.am)((Map.Entry)localObject3).getValue()).field_username);
            }
            ((StringBuffer)localObject2).append("]");
          }
          ((StringBuffer)localObject2).append("\n");
        }
        localObject1 = ((StringBuffer)localObject2).toString();
        localObject2 = this.Hdw.toString();
        if (paramViewGroup == null) {
          break label2174;
        }
        i = paramViewGroup.size();
        ad.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject1, str, Integer.valueOf(paramInt), localObject2, Integer.valueOf(i) });
        if (!this.Hdv)
        {
          com.tencent.mm.plugin.fts.a.e.DC(20);
          this.Hdv = true;
        }
        if (System.currentTimeMillis() - this.HdL > 3600000L)
        {
          super.j(null, 1);
          this.HdL = System.currentTimeMillis();
        }
      }
      if (paramView != null) {
        break label2218;
      }
      localObject1 = new f();
      if (!com.tencent.mm.cd.a.hU(this.context)) {
        break label2197;
      }
      com.tencent.mm.kiss.a.b.agA();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493666);
      label546:
      paramView.setTag(2131306044, new int[2]);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38489);
          if ((i.f(i.this) == null) || (i.f(i.this).getOnItemClickListener() == null))
          {
            ad.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            AppMethodBeat.o(38489);
            return;
          }
          if (paramAnonymousView.getTag() == null)
          {
            ad.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            AppMethodBeat.o(38489);
            return;
          }
          if (!i.this.GsE)
          {
            ad.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            AppMethodBeat.o(38489);
            return;
          }
          i.f localf = (i.f)paramAnonymousView.getTag();
          int i = localf.position;
          int j = i.f(i.this).getHeaderViewsCount();
          i.f(i.this).getOnItemClickListener().onItemClick(i.f(i.this), paramAnonymousView, i + j, i.this.getItemId(localf.position));
          AppMethodBeat.o(38489);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38490);
          if ((i.f(i.this) == null) || (i.f(i.this).getOnItemLongClickListener() == null))
          {
            ad.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            AppMethodBeat.o(38490);
            return false;
          }
          if (paramAnonymousView.getTag() == null)
          {
            ad.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            AppMethodBeat.o(38490);
            return false;
          }
          if (!i.this.GsE)
          {
            ad.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            AppMethodBeat.o(38490);
            return false;
          }
          i.f localf = (i.f)paramAnonymousView.getTag();
          int i = localf.position;
          int j = i.f(i.this).getHeaderViewsCount();
          boolean bool = i.f(i.this).getOnItemLongClickListener().onItemLongClick(i.f(i.this), paramAnonymousView, i + j, i.this.getItemId(localf.position));
          AppMethodBeat.o(38490);
          return bool;
        }
      });
      ((f)localObject1).frr = ((ImageView)paramView.findViewById(2131297008));
      a.b.c(((f)localObject1).frr, str);
      paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)((f)localObject1).frr.getDrawable();
      if (this.Hbf != null) {
        this.Hbf.a(paramViewGroup);
      }
      ((f)localObject1).frr.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(38491);
          this.HdR.frr.getViewTreeObserver().removeOnPreDrawListener(this);
          int i = this.HdR.frr.getWidth();
          int j = ao.ap(i.g(i.this), 2131165508);
          if (i != j)
          {
            ad.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.HdR.frr.getLayoutParams();
            localLayoutParams.width = j;
            localLayoutParams.height = j;
            this.HdR.frr.setLayoutParams(localLayoutParams);
            ad.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", new Object[] { Integer.valueOf(this.HdR.frr.getWidth()) });
            if (!i.h(i.this))
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(1055L, 4L, 1L, false);
              ad.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
              i.i(i.this);
            }
          }
          AppMethodBeat.o(38491);
          return true;
        }
      });
      ((f)localObject1).Ghe = ((NoMeasuredTextView)paramView.findViewById(2131302867));
      ((f)localObject1).Ghe.setLayoutCallback(this.HdD);
      ((f)localObject1).Ghf = ((NoMeasuredTextView)paramView.findViewById(2131306207));
      ((f)localObject1).Hea = ((ImageView)paramView.findViewById(2131301312));
      ((f)localObject1).Ghg = ((NoMeasuredTextView)paramView.findViewById(2131301311));
      ((f)localObject1).mRr = ((TextView)paramView.findViewById(2131305882));
      ((f)localObject1).Heb = ((WeImageView)paramView.findViewById(2131300954));
      ((f)localObject1).Ghj = paramView.findViewById(2131297015);
      ((f)localObject1).HbL = ((ImageView)paramView.findViewById(2131301541));
      ((f)localObject1).Hec = ((ImageView)paramView.findViewById(2131302581));
      ((f)localObject1).mRr.setBackgroundResource(com.tencent.mm.ui.tools.u.kh(this.context));
      ((f)localObject1).mRr.setTextSize(0, com.tencent.mm.cd.a.ap(this.context, 2131166949) * com.tencent.mm.cd.a.hQ(this.context));
      ((f)localObject1).Hed = new c();
      paramView.setTag(localObject1);
      ((f)localObject1).Ghg.setTextSize(0, com.tencent.mm.cd.a.ao(this.context, 2131165574));
      ((f)localObject1).Ghf.setTextSize(0, com.tencent.mm.cd.a.ao(this.context, 2131165576));
      ((f)localObject1).Ghe.setTextSize(0, com.tencent.mm.cd.a.ao(this.context, 2131165517));
      this.HdJ = ((f)localObject1).Ghe.getTextSize();
      ((f)localObject1).Ghg.setTextColor(this.GgV[0]);
      ((f)localObject1).Ghf.setTextColor(this.GgV[4]);
      ((f)localObject1).Ghe.setTextColor(this.GgV[3]);
      ((f)localObject1).Ghg.setShouldEllipsize(true);
      ((f)localObject1).Ghf.setShouldEllipsize(false);
      ((f)localObject1).Ghe.setShouldEllipsize(true);
      if (((f)localObject1).Ghe.getPaint() != null) {
        ai.a(((f)localObject1).Ghe.getPaint(), 0.1F);
      }
      ((f)localObject1).Ghf.setGravity(5);
      paramViewGroup = paramView;
      label1036:
      localObject3 = j(localam);
      ((f)localObject1).position = paramInt;
      ((f)localObject1).username = str;
      if ((!((d)localObject3).Ghb) || (localam.field_conversationTime == -1L)) {
        break label2232;
      }
      bool1 = true;
      label1080:
      ((f)localObject1).Ghb = bool1;
      if (((d)localObject3).Hbx == null) {
        ((d)localObject3).Hbx = b(localam, (int)((f)localObject1).Ghg.getTextSize(), ((d)localObject3).HbE);
      }
      if ((w.td(localam.field_username)) && (((d)localObject3).Hbx != null))
      {
        paramView = r.Fem;
        r.aI(((d)localObject3).Hbx.toString(), paramInt, localam.field_unReadCount);
      }
      if (((d)localObject3).Hbw == null) {
        ((d)localObject3).Hbw = i(localam);
      }
      if (!((d)localObject3).HbE) {
        break label2238;
      }
      ((f)localObject1).Ghg.setTextColor(this.GgV[0]);
      label1203:
      com.tencent.mm.booter.notification.a.h.kE(((f)localObject1).Ghg.getWidth());
      com.tencent.mm.booter.notification.a.h.kF((int)((f)localObject1).Ghg.getTextSize());
      com.tencent.mm.booter.notification.a.h.b(((f)localObject1).Ghg.getPaint());
      if ((!w.sn(str)) && (!w.sp(str))) {
        break label2259;
      }
      ((f)localObject1).Ghe.setCompoundRightDrawablesWithIntrinsicBounds(2131691000);
      ((f)localObject1).Ghe.setDrawRightDrawable(true);
      label1273:
      i = ((d)localObject3).Hby;
      if (i == -1) {
        break label2282;
      }
      ((f)localObject1).Ghg.setCompoundLeftDrawablesWithIntrinsicBounds(i);
      ((f)localObject1).Ghg.setDrawLeftDrawable(true);
      ad.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((d)localObject3).Hby) });
      label1333:
      if (!af.aHH(localam.field_username)) {
        break label2316;
      }
      this.HdI.nY(localam.field_username);
      Object localObject4 = this.HdI.ddc();
      paramView = "";
      if (localObject4 != null) {
        paramView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bt(((au)localObject4).field_openImAppid, ((au)localObject4).field_descWordingId);
      }
      if (bt.isNullOrNil(paramView)) {
        break label2302;
      }
      Object localObject2 = paramView;
      if ("3552365301".equals(((au)localObject4).field_openImAppid)) {
        localObject2 = "@".concat(String.valueOf(paramView));
      }
      ((f)localObject1).Ghe.aM((String)localObject2, 2131100528, 14);
      label1449:
      ((f)localObject1).Ghe.setText(((d)localObject3).nickName);
      paramView = ((f)localObject1).Ghf.getLayoutParams();
      if (((d)localObject3).Hbw.length() < 9) {
        break label2339;
      }
      if (paramView.width != this.Hbo)
      {
        paramView.width = this.Hbo;
        ((f)localObject1).Ghf.setLayoutParams(paramView);
      }
      label1514:
      ((f)localObject1).Ghf.setText(((d)localObject3).Hbw);
      ((f)localObject1).Ghg.setText(((d)localObject3).Hbx);
      if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localam, 7, 0L) <= 0L) {
        break label2370;
      }
      bool1 = true;
      label1556:
      localObject2 = localam.field_username;
      long l1 = localam.field_conversationTime;
      localObject4 = ((d)localObject3).Hbw;
      boolean bool2 = ((f)localObject1).Ghb;
      long l2 = localam.field_flag;
      long l3 = localam.field_flag;
      if ((((d)localObject3).nickName != null) && (((d)localObject3).nickName.length() > 0)) {
        break label2376;
      }
      paramView = "?";
      label1623:
      ad.i("MicroMsg.ConversationWithCacheAdapter", "[getView] position=%s username=%s conversationTime=%s updateTime=%s isPlacedTop=%s isTalkRoomTopPlace=%s flag=%s flagTime=%s nickname=%s", new Object[] { Integer.valueOf(paramInt), localObject2, Long.valueOf(l1), localObject4, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3 & 0xFFFFFFFF), paramView });
      ((f)localObject1).Hea.setVisibility(8);
      ((f)localObject1).Heb.setVisibility(8);
      if (!((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aaj(str)) {
        break label2394;
      }
      ((f)localObject1).Heb.setVisibility(0);
      ((f)localObject1).Heb.setImageDrawable(com.tencent.mm.ui.am.i(this.context, 2131690531, this.context.getResources().getColor(2131099982)));
      label1783:
      a.b.c(((f)localObject1).frr, str);
      if (this.Hbd)
      {
        ad.i("MicroMsg.ConversationWithCacheAdapter", "handleShowTipCnt.");
        if ((localam != null) && (localObject1 != null) && (localObject3 != null)) {
          break label2473;
        }
        ad.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
      }
      label1831:
      if ((!((d)localObject3).HbB) && (((d)localObject3).Ghb) && (az.afw()))
      {
        az.arV();
        com.tencent.mm.model.c.apR().g(localam);
      }
      if ((this.HdF == null) || (!this.HdF.equals(str))) {
        break label2731;
      }
      ad.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), this.HdF });
      paramViewGroup.findViewById(2131298792).setBackground(this.HdG);
      label1930:
      if (Build.VERSION.SDK_INT >= 21) {
        paramViewGroup.findViewById(2131298792).setOnTouchListener(new View.OnTouchListener()
        {
          @TargetApi(21)
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(38483);
            paramAnonymousView.findViewById(2131298792).getBackground().setHotspot(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
            AppMethodBeat.o(38483);
            return false;
          }
        });
      }
      if ((com.tencent.mm.bj.d.hxx == null) || (!com.tencent.mm.bj.d.hxx.zA(localam.field_username))) {
        break label2783;
      }
      ((f)localObject1).HbL.setVisibility(0);
      label1987:
      if ((!w.pF(localam.field_username)) || (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class) == null) || (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).ahr(localam.field_username))) {
        break label2830;
      }
      if ((!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).cRD()) || (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).hs(localam.field_username, com.tencent.mm.model.u.aqG()))) {
        break label2796;
      }
      ((f)localObject1).Hec.setImageResource(2131689895);
      label2082:
      ((f)localObject1).Hec.setVisibility(0);
    }
    for (;;)
    {
      this.HdK.content = String.valueOf(((d)localObject3).Hbx);
      this.HdK.bNK = ((d)localObject3).fyo;
      this.HdK.time = String.valueOf(((d)localObject3).Hbw);
      paramView = this.HdK;
      a.a.eSf().a(paramViewGroup, paramView.bNK, paramView.Hbu, paramView.time, paramView.content);
      paramViewGroup.setAlpha(1.0F);
      AppMethodBeat.o(38503);
      return paramViewGroup;
      label2174:
      i = 0;
      break;
      this.Hdw.put(str, Integer.valueOf(paramInt));
      break label505;
      label2197:
      com.tencent.mm.kiss.a.b.agA();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493664);
      break label546;
      label2218:
      localObject1 = (f)paramView.getTag();
      paramViewGroup = paramView;
      break label1036;
      label2232:
      bool1 = false;
      break label1080;
      label2238:
      ((f)localObject1).Ghg.setTextColor(this.GgV[localObject3.nBH]);
      break label1203;
      label2259:
      if (!((f)localObject1).Ghe.Gcx) {
        break label1273;
      }
      ((f)localObject1).Ghe.setDrawRightDrawable(false);
      break label1273;
      label2282:
      ((f)localObject1).Ghg.setDrawLeftDrawable(false);
      ((f)localObject1).Ghg.invalidate();
      break label1333;
      label2302:
      ((f)localObject1).Ghe.aM(null, 0, 0);
      break label1449;
      label2316:
      w.sn(localam.field_username);
      ((f)localObject1).Ghe.aM(null, 0, 0);
      break label1449;
      label2339:
      if (paramView.width == this.Hbn) {
        break label1514;
      }
      paramView.width = this.Hbn;
      ((f)localObject1).Ghf.setLayoutParams(paramView);
      break label1514;
      label2370:
      bool1 = false;
      break label1556;
      label2376:
      paramView = Character.valueOf(((d)localObject3).nickName.charAt(0));
      break label1623;
      label2394:
      ((f)localObject1).Heb.setImageDrawable(com.tencent.mm.ui.am.i(this.context, 2131690523, this.context.getResources().getColor(2131099982)));
      if (((d)localObject3).qbC)
      {
        if (!((d)localObject3).HbG) {
          break label1783;
        }
        ((f)localObject1).Heb.setVisibility(0);
        break label1783;
      }
      if (!((d)localObject3).HbC) {
        break label1783;
      }
      ((f)localObject1).Heb.setVisibility(0);
      break label1783;
      label2473:
      ((f)localObject1).mRr.setVisibility(4);
      ((f)localObject1).Ghj.setVisibility(4);
      if ((!w.sw(localam.field_username)) && (((d)localObject3).HbF) && ((((d)localObject3).HbA == 1) || (((d)localObject3).HbA == 2) || (((d)localObject3).HbA == 3))) {}
      for (paramView = this.GgV[2];; paramView = this.GgV[3])
      {
        ((f)localObject1).Ghe.setTextColor(paramView);
        if ((((d)localObject3).HbF) && (((d)localObject3).Hbz != 0)) {
          break label2590;
        }
        ad.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
        break;
      }
      label2590:
      paramInt = a(localam, (d)localObject3);
      if (paramInt == 1)
      {
        ((f)localObject1).Ghj.setVisibility(0);
        break label1831;
      }
      if (paramInt != 2) {
        break label1831;
      }
      paramInt = localam.field_unReadCount;
      if (paramInt > 99)
      {
        ((f)localObject1).mRr.setText("");
        ((f)localObject1).mRr.setBackgroundResource(2131689744);
        ((f)localObject1).mRr.setVisibility(0);
      }
      for (;;)
      {
        this.HdK.Hbu = paramInt;
        break;
        if (paramInt > 0)
        {
          ((f)localObject1).mRr.setText(localam.field_unReadCount);
          ((f)localObject1).mRr.setVisibility(0);
          ((f)localObject1).mRr.setBackgroundResource(com.tencent.mm.ui.tools.u.aG(this.context, paramInt));
        }
      }
      label2731:
      if ((((d)localObject3).Ghb) && (localam.field_conversationTime != -1L))
      {
        paramViewGroup.findViewById(2131298792).setBackgroundResource(2131232872);
        break label1930;
      }
      paramViewGroup.findViewById(2131298792).setBackgroundResource(2131231854);
      break label1930;
      label2783:
      ((f)localObject1).HbL.setVisibility(8);
      break label1987;
      label2796:
      ((f)localObject1).Hec.setImageDrawable(com.tencent.mm.ui.am.i(this.context, 2131690409, this.context.getResources().getColor(2131099982)));
      break label2082;
      label2830:
      ((f)localObject1).Hec.setVisibility(8);
    }
  }
  
  final d j(com.tencent.mm.storage.am paramam)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38504);
    String str2 = paramam.field_username;
    Object localObject;
    if (this.GgX != null)
    {
      localObject = (d)this.GgX.get(str2);
      if (localObject != null)
      {
        AppMethodBeat.o(38504);
        return localObject;
      }
    }
    d locald = new d((byte)0);
    this.HdI.nY(str2);
    af localaf = this.HdI.ddc();
    if (localaf != null)
    {
      locald.HbA = localaf.evH;
      locald.Hbz = ((int)localaf.fId);
      if (localaf == null) {
        break label532;
      }
      bool1 = true;
      label111:
      locald.HbF = bool1;
      if ((localaf == null) || (!localaf.VG())) {
        break label537;
      }
      bool1 = true;
      label132:
      locald.HbH = bool1;
      if ((localaf == null) || (localaf.evx != 0)) {
        break label542;
      }
      bool1 = true;
      label153:
      locald.HbG = bool1;
      locald.qbC = w.sl(str2);
      if ((!locald.qbC) || (!locald.HbG) || (paramam.field_unReadCount <= 0)) {
        break label547;
      }
      bool1 = true;
      label194:
      locald.HbE = bool1;
      locald.nBH = 0;
      if ((OV(paramam.field_msgType) == 34) && (paramam.field_isSend == 0) && (!bt.isNullOrNil(paramam.field_content)))
      {
        String str1 = paramam.field_content;
        if ((!str2.equals("qmessage")) && (!str2.equals("floatbottle")) && (!str2.equals("officialaccounts")) && (!paramam.lw(2097152)))
        {
          localObject = str1;
          if (!paramam.lw(8388608)) {}
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
        if (!new p((String)localObject).hAc) {
          locald.nBH = 1;
        }
      }
      locald.fyo = v.a(localaf, str2, locald.qbC);
      a(locald, localaf);
      locald.Hbw = i(paramam);
      locald.Hby = ZL(paramam.field_status);
      locald.HbB = w.a(paramam);
      az.arV();
      locald.Ghb = com.tencent.mm.model.c.apR().h(paramam);
      if ((localaf == null) || (!localaf.Ny())) {
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
      locald.HbC = bool1;
      if (this.GgX != null) {
        this.GgX.put(str2, locald);
      }
      AppMethodBeat.o(38504);
      return locald;
      locald.HbA = -1;
      locald.Hbz = -1;
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
    if (!this.HdN)
    {
      super.notifyDataSetChanged();
      this.Hdw.clear();
    }
    ad.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    AppMethodBeat.o(38522);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38497);
    ad.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.GsE);
    if (!this.GsE)
    {
      AppMethodBeat.o(38497);
      return;
    }
    this.GsE = false;
    super.pause();
    if (this.mRn != null) {
      this.mRn.cIg();
    }
    AppMethodBeat.o(38497);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(38499);
    ad.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.GsE);
    if (this.GsE)
    {
      AppMethodBeat.o(38499);
      return;
    }
    this.GsE = true;
    fba();
    fct();
    ad.i(this.TAG, "newcursor resume syncNow ");
    this.FID = true;
    kT(true);
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.g.g.a("MM/dd", (Time)localObject).toString();
    String str = ac.eFu();
    if ((!this.Hbl.equals(localObject)) || (!this.HdE.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.Hbl = ((String)localObject);
      this.HdE = str;
      if (i != 0) {
        fbX();
      }
      if ((this.Hbg) && (this.Hdt != null))
      {
        this.Hdt.fcv();
        this.Hbg = false;
        super.j(null, 1);
      }
      AppMethodBeat.o(38499);
      return;
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
  
  public static abstract interface b
  {
    public abstract void fcv();
  }
  
  final class c
  {
    public View FYV = null;
    boolean HdS = false;
    boolean HdT = false;
    boolean HdU = false;
    boolean HdV = false;
    boolean HdW = false;
    public ImageView HdX = null;
    public TextView HdY = null;
    public View HdZ = null;
    public View mRs = null;
    public TextView mRt = null;
    String username = "";
    
    c() {}
  }
  
  final class d
  {
    public boolean Ghb;
    public int HbA;
    public boolean HbB;
    public boolean HbC;
    public boolean HbE;
    public boolean HbF;
    public boolean HbG;
    public boolean HbH;
    public CharSequence Hbw;
    public CharSequence Hbx;
    public int Hby;
    public int Hbz;
    public String fyo;
    public int nBH;
    public CharSequence nickName;
    public boolean qbC;
    
    private d() {}
  }
  
  final class e
  {
    private Integer HbJ = null;
    private af contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final af ddc()
    {
      AppMethodBeat.i(38493);
      if ((this.initialized) && (this.contact == null) && (az.afw()))
      {
        az.arV();
        this.contact = com.tencent.mm.model.c.apM().aHY(this.talker);
      }
      af localaf = this.contact;
      AppMethodBeat.o(38493);
      return localaf;
    }
    
    public final void nY(String paramString)
    {
      AppMethodBeat.i(38492);
      this.talker = paramString;
      this.contact = null;
      this.HbJ = null;
      this.initialized = false;
      if (!bt.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(38492);
    }
  }
  
  public static final class f
  {
    public boolean Ghb;
    public NoMeasuredTextView Ghe;
    public NoMeasuredTextView Ghf;
    public NoMeasuredTextView Ghg;
    public View Ghj;
    public ImageView HbL;
    public ImageView Hea;
    public WeImageView Heb;
    public ImageView Hec;
    public i.c Hed;
    public ImageView frr;
    public TextView mRr;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */