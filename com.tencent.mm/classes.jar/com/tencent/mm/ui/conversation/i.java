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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.t;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
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
  extends com.tencent.mm.ui.f<String, com.tencent.mm.storage.ap>
  implements n.b
{
  private float HGF;
  private float HGI;
  private float HGJ;
  private ColorStateList[] HGK;
  HashMap<String, d> HGM;
  public boolean HSw;
  k.a Hsb;
  private boolean IBk;
  com.tencent.mm.pluginsdk.ui.d IBm;
  private boolean IBn;
  com.tencent.mm.sdk.b.c IBq;
  public String IBs;
  private final int IBu;
  private final int IBv;
  private boolean IDE;
  private vt IDF;
  b IDG;
  private HashSet<String> IDH;
  private boolean IDI;
  HashMap<String, Integer> IDJ;
  private HashMap<String, Integer> IDK;
  private boolean IDL;
  private HashSet<String> IDM;
  private boolean IDN;
  private boolean IDO;
  private boolean IDP;
  private NoMeasuredTextView.c IDQ;
  public String IDR;
  private String IDS;
  private Drawable IDT;
  ValueAnimator IDU;
  final e IDV;
  private float IDW;
  private a IDX;
  private long IDY;
  private boolean IDZ;
  boolean IEa;
  protected List<String> fzw;
  private boolean iNn;
  private ListView mListView;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.d ntD;
  boolean uaQ;
  boolean yzE;
  
  public i(Context paramContext, ListView paramListView, f.a parama)
  {
    super(paramContext, (short)0);
    AppMethodBeat.i(38494);
    this.fzw = null;
    this.HGK = new ColorStateList[5];
    this.IBk = true;
    this.IDE = false;
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    this.IDF = null;
    this.iNn = false;
    this.HGF = -1.0F;
    this.HGI = -1.0F;
    this.HGJ = -1.0F;
    this.IBn = false;
    this.IBq = null;
    this.IDG = null;
    this.HSw = false;
    this.IDI = false;
    this.IDJ = new HashMap();
    this.IDK = new HashMap();
    this.IDL = false;
    this.IDN = false;
    this.IDO = false;
    this.IDP = false;
    this.IDQ = new NoMeasuredTextView.c()
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
          paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.span.k.c(i.b(i.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.cc.a.m(i.c(i.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(38482);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.IBs = "";
    this.IDR = "";
    this.Hsb = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(38488);
        i.this.notifyDataSetChanged();
        AppMethodBeat.o(38488);
      }
    };
    this.IDV = new e();
    this.yzE = false;
    this.IDW = -1.0F;
    this.IDY = 0L;
    this.IDZ = false;
    this.uaQ = false;
    this.IEa = false;
    this.mListView = paramListView;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.HGK[0] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
    this.HGK[1] = com.tencent.mm.cc.a.m(paramContext, 2131100643);
    this.HGK[3] = com.tencent.mm.cc.a.m(paramContext, 2131100711);
    this.HGK[2] = com.tencent.mm.cc.a.m(paramContext, 2131099769);
    this.HGK[2] = com.tencent.mm.cc.a.m(paramContext, 2131099769);
    this.HGK[4] = com.tencent.mm.cc.a.m(paramContext, 2131100490);
    if (com.tencent.mm.cc.a.ie(paramContext))
    {
      this.IBv = paramContext.getResources().getDimensionPixelSize(2131165246);
      this.IBu = paramContext.getResources().getDimensionPixelSize(2131165247);
    }
    for (;;)
    {
      this.HGM = new HashMap();
      this.IDH = new HashSet();
      this.IDM = new HashSet();
      this.HGF = paramContext.getResources().getDimension(2131165517);
      this.HGI = paramContext.getResources().getDimension(2131165466);
      this.HGJ = paramContext.getResources().getDimension(2131165576);
      this.fzw = new ArrayList();
      this.fzw.add("qmessage");
      this.IDP = fsp();
      if (!this.IDP) {
        this.fzw.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38494);
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
  
  private SparseArray<String> a(f.b<String, com.tencent.mm.storage.ap> paramb, SparseArray<String> paramSparseArray, HashMap<String, com.tencent.mm.storage.ap> paramHashMap)
  {
    AppMethodBeat.i(38516);
    String str = (String)paramb.object;
    int k = paramSparseArray.size();
    com.tencent.mm.storage.ap localap = (com.tencent.mm.storage.ap)paramb.HhZ;
    int j = paramSparseArray.size();
    int i = 0;
    label39:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i) });
      switch (paramb.HhY)
      {
      case 3: 
      case 4: 
      default: 
        if (i >= 0) {
          break label411;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
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
      if (localap == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
        if (i >= 0)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[] { str });
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
      while ((i < k) && (f((String)paramSparseArray.get(i), paramHashMap).field_flag > localap.field_flag)) {
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
    if (localap == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[] { str });
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
    long l2 = localap.field_flag;
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
      if (f((String)paramSparseArray.get(k), paramHashMap).field_flag > localap.field_flag) {
        break label666;
      }
    }
    label666:
    label765:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(-1), Boolean.valueOf(bool), Integer.valueOf(i), str });
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
  
  private void a(d paramd, com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(38505);
    if ((paramd.qKi) && (paramd.fBV == null))
    {
      paramd.nickName = this.context.getString(2131757293);
      AppMethodBeat.o(38505);
      return;
    }
    if (com.tencent.mm.storage.ai.aNc(paramai.field_username))
    {
      paramd.nickName = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).e(com.tencent.mm.sdk.platformtools.ai.getContext(), paramd.fBV, com.tencent.mm.cc.a.au(this.context, 2131165517));
      AppMethodBeat.o(38505);
      return;
    }
    paramd.nickName = com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramd.fBV, com.tencent.mm.cc.a.au(this.context, 2131165517));
    AppMethodBeat.o(38505);
  }
  
  private static String aPU(String paramString)
  {
    AppMethodBeat.i(38511);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(paramString);
      AppMethodBeat.o(38511);
      return paramString;
    }
    AppMethodBeat.o(38511);
    return null;
  }
  
  private static int abM(int paramInt)
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
  
  private CharSequence b(com.tencent.mm.storage.ap paramap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38509);
    Object localObject3 = new SpannableStringBuilder();
    if (paramap.lr(268435456))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131762246));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
    }
    if (((!bs.isNullOrNil(paramap.field_editingMsg)) || (paramap.field_editingQuoteMsgId != 0L)) && ((paramap.field_atCount <= 0) || ((paramap.field_unReadCount <= 0) && (paramap.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131761048));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      if (!bs.isNullOrNil(paramap.field_editingMsg)) {
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramap.field_editingMsg, paramInt));
      }
      paramap = ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
      AppMethodBeat.o(38509);
      return paramap;
    }
    if (Tf(paramap.field_msgType) == 10000)
    {
      boolean bool2 = w.xg(paramap.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramap.lr(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramap.lr(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramap.lr(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = w.xp(paramap.field_username);
      }
      if ((!bool2) && (paramap.field_hasTodo != 1))
      {
        paramap = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.f(this.context, paramap.field_content, paramInt));
        AppMethodBeat.o(38509);
        return paramap;
      }
    }
    Object localObject2;
    if (Tf(paramap.field_msgType) == 49)
    {
      localObject1 = com.tencent.mm.model.v.wk(paramap.field_digestUser);
      localObject2 = k.b.vA(paramap.field_content);
      if (localObject2 == null) {}
    }
    Object localObject4;
    switch (((k.b)localObject2).type)
    {
    default: 
    case 40: 
      do
      {
        localObject1 = paramap.field_digest;
        if ((localObject1 == null) || (!((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
          break;
        }
        paramap = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.e(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramap;
      } while (t.vF(paramap.field_content).hla != 19);
      if (bs.isNullOrNil((String)localObject1)) {}
      for (localObject1 = this.context.getString(2131755872);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755872))
      {
        paramap.qR((String)localObject1);
        paramap = ((SpannableStringBuilder)localObject3).append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramap;
      }
    case 5: 
      localObject1 = null;
      try
      {
        paramap = String.format(paramap.field_digest, new Object[] { l(paramap) });
        localObject4 = new StringBuilder();
        localObject1 = paramap;
        if (bs.isNullOrNil(paramap)) {
          localObject1 = this.context.getString(2131755920);
        }
        paramap = (String)localObject1 + " " + ((k.b)localObject2).title;
        paramap = ((SpannableStringBuilder)localObject3).append(com.tencent.mm.pluginsdk.ui.span.k.f(this.context, paramap, paramInt));
        AppMethodBeat.o(38509);
        return paramap;
      }
      catch (Exception paramap)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramap, "", new Object[0]);
          paramap = (com.tencent.mm.storage.ap)localObject1;
        }
      }
    }
    if (bs.isNullOrNil((String)localObject1)) {}
    for (Object localObject1 = this.context.getString(2131755872);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755872))
    {
      paramap.qR((String)localObject1);
      paramap = ((SpannableStringBuilder)localObject3).append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38509);
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
        AppMethodBeat.o(38509);
        return paramap;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      com.tencent.mm.model.az.ayM();
      localObject1 = com.tencent.mm.model.c.awJ().alJ("@t.qq.com");
      if ((localObject1 != null) && (((bu)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramap = this.context.getString(2131763356);
        AppMethodBeat.o(38509);
        return paramap;
      }
    }
    if ((paramap.field_msgType != null) && (paramap.field_msgType.equals("64")))
    {
      paramap = paramap.field_content;
      AppMethodBeat.o(38509);
      return paramap;
    }
    if ((paramap.field_msgType != null) && ((paramap.field_msgType.equals("47")) || (paramap.field_msgType.equals("1048625"))))
    {
      localObject1 = aPU(paramap.field_digest);
      localObject2 = "";
      if (!bs.isNullOrNil((String)localObject1))
      {
        paramap = ((SpannableStringBuilder)localObject3).append("[" + (String)localObject1 + "]");
        AppMethodBeat.o(38509);
        return paramap;
      }
      localObject1 = localObject2;
      if (paramap.field_digest != null)
      {
        localObject1 = localObject2;
        if (paramap.field_digest.contains(":"))
        {
          localObject2 = paramap.field_digest.substring(0, paramap.field_digest.indexOf(":"));
          localObject4 = aPU(paramap.field_digest.substring(paramap.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject2;
          if (!bs.isNullOrNil((String)localObject4))
          {
            paramap = "[" + (String)localObject4 + "]";
            if (bs.isNullOrNil((String)localObject2))
            {
              paramap = ((SpannableStringBuilder)localObject3).append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramInt));
              AppMethodBeat.o(38509);
              return paramap;
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramap);
            paramap = ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
            AppMethodBeat.o(38509);
            return paramap;
          }
        }
      }
      localObject2 = this.context.getString(2131755722);
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject1 = localObject2;
        paramap.qR((String)localObject1);
      }
    }
    else
    {
      if (bs.isNullOrNil(paramap.field_digest)) {
        break label1512;
      }
      if (bs.isNullOrNil(paramap.field_digestUser)) {
        break label1501;
      }
      localObject1 = l(paramap);
    }
    label1501:
    label1512:
    String str;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramap.field_digest, new Object[] { localObject1 });
        localObject1 = ((String)localObject1).replace('\n', ' ');
        if ((!paramap.lr(33554432)) || ((paramap.field_unReadCount <= 0) && (paramap.field_unReadMuteCount <= 0))) {
          break label1543;
        }
        paramap = new SpannableStringBuilder(this.context.getString(2131764320));
        paramap.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramap.length(), 33);
        paramap.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject1, paramInt));
        paramap = ((SpannableStringBuilder)localObject3).append(paramap);
        AppMethodBeat.o(38509);
        return paramap;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject2;
      break;
      localObject1 = paramap.field_digest;
      continue;
      str = com.tencent.mm.booter.notification.a.h.a(paramap.field_isSend, paramap.field_username, paramap.field_content, Tf(paramap.field_msgType), this.context);
    }
    label1543:
    if (paramap.field_UnReadInvite > 0)
    {
      if (paramap.field_UnReadInvite < 4096) {}
      for (paramap = this.context.getString(2131761045, new Object[] { Integer.valueOf(paramap.field_UnReadInvite) });; paramap = this.context.getString(2131761042))
      {
        paramap = new SpannableStringBuilder(paramap);
        paramap.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramap.length(), 33);
        paramap.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt));
        AppMethodBeat.o(38509);
        return paramap;
      }
    }
    if ((paramap.field_atCount > 0) && ((paramap.field_unReadCount > 0) || (paramap.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramap.field_atCount < 4096) {
        i = 2131761044;
      }
      for (;;)
      {
        paramap = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramap.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramap.length(), 33);
        paramap.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt));
        AppMethodBeat.o(38509);
        return paramap;
        if (com.tencent.mm.al.f.so(paramap.field_username)) {
          i = 2131761043;
        } else {
          i = 2131761046;
        }
      }
    }
    if (paramap.field_hasTodo == 1)
    {
      paramap = new SpannableStringBuilder(this.context.getString(2131764449));
      paramap.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramap.length(), 33);
      paramap.append(" ").append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt));
      AppMethodBeat.o(38509);
      return paramap;
    }
    if ((paramap.lr(16777216)) && ((paramap.field_unReadCount > 0) || (paramap.field_unReadMuteCount > 0)))
    {
      paramap = this.context.getString(2131755033);
      str = str.replace(paramap, "");
      paramap = new SpannableStringBuilder(paramap);
      paramap.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100800)), 0, paramap.length(), 33);
      paramap.append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt));
      paramap = ((SpannableStringBuilder)localObject3).append(paramap);
      AppMethodBeat.o(38509);
      return paramap;
    }
    if (paramap.lr(268435456))
    {
      ((SpannableStringBuilder)localObject3).append(str.replace(this.context.getString(2131762246), ""));
      AppMethodBeat.o(38509);
      return localObject3;
    }
    if ((paramBoolean) && ((paramap.field_unReadCount > 1) || (paramap.field_unReadMuteCount > 0))) {
      paramap = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramap.field_unReadCount), str });
    }
    for (;;)
    {
      paramap = ((SpannableStringBuilder)localObject3).append(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramap, paramInt));
      AppMethodBeat.o(38509);
      return paramap;
      if ((com.tencent.mm.storage.v.bIO()) && (w.xg(paramap.field_username)))
      {
        paramBoolean = paramap.lr(16);
        if ((paramap.field_unReadCount > 1) || ((!paramBoolean) && (paramap.field_unReadCount > 0)))
        {
          if (paramBoolean)
          {
            if (paramap.lr(32))
            {
              paramap = this.context.getString(2131761039, new Object[] { Integer.valueOf(paramap.field_unReadCount) });
              localObject2 = this.context.getResources().getDrawable(2131231289);
              ((Drawable)localObject2).setBounds(0, 0, paramInt, paramInt);
              localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
              localObject3 = new SpannableString("@");
              ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
              paramap = TextUtils.concat(new CharSequence[] { paramap, " ", localObject3, com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt) });
              AppMethodBeat.o(38509);
              return paramap;
            }
            paramap = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramap.field_unReadCount), str });
          }
          else
          {
            paramap = this.context.getString(2131761040, new Object[] { Integer.valueOf(paramap.field_unReadCount), str });
          }
        }
        else
        {
          if (paramap.lr(32))
          {
            paramap = this.context.getResources().getDrawable(2131231289);
            paramap.setBounds(0, 0, paramInt, paramInt);
            paramap = new com.tencent.mm.ui.widget.a(paramap);
            localObject2 = new SpannableString("@");
            ((SpannableString)localObject2).setSpan(paramap, 0, 1, 33);
            paramap = TextUtils.concat(new CharSequence[] { localObject2, com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramInt) });
            AppMethodBeat.o(38509);
            return paramap;
          }
          paramap = str;
        }
      }
      else if ((w.xq(paramap.field_username)) && ((paramap.field_unReadCount > 1) || (paramap.field_unReadMuteCount > 0)))
      {
        paramap = this.context.getString(2131761047, new Object[] { Integer.valueOf(paramap.field_unReadCount), str });
      }
      else
      {
        paramap = str;
      }
    }
  }
  
  private com.tencent.mm.storage.ap f(String paramString, HashMap<String, com.tencent.mm.storage.ap> paramHashMap)
  {
    AppMethodBeat.i(38515);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (com.tencent.mm.storage.ap)paramHashMap.get(paramString);
      AppMethodBeat.o(38515);
      return paramString;
    }
    if (this.HhM == null) {}
    for (paramString = null;; paramString = this.HhM.Hcp.dV(paramString))
    {
      paramString = (com.tencent.mm.storage.ap)paramString;
      AppMethodBeat.o(38515);
      return paramString;
    }
  }
  
  private void frO()
  {
    AppMethodBeat.i(38498);
    if (this.HGM == null)
    {
      AppMethodBeat.o(38498);
      return;
    }
    Iterator localIterator = this.HGM.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).IBC = null;
    }
    AppMethodBeat.o(38498);
  }
  
  private boolean fsm()
  {
    return this.IDS != null;
  }
  
  private void fso()
  {
    AppMethodBeat.i(38518);
    if ((this.HGM == null) || (this.IDH == null) || (this.IDH.isEmpty()))
    {
      AppMethodBeat.o(38518);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.IDH.size()) });
    Iterator localIterator = this.IDH.iterator();
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
        if (!this.HGM.containsKey(str1)) {
          break label360;
        }
        d locald = (d)this.HGM.get(str1);
        j = i;
        if (locald == null) {
          break label360;
        }
        this.IDV.re(str1);
        bool1 = w.sQ(str1);
        com.tencent.mm.storage.ai localai = this.IDV.dqK();
        if (localai != null)
        {
          String str2 = com.tencent.mm.model.v.a(localai, str1, bool1);
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.fBV });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.fBV))
            {
              locald.fBV = str2;
              a(locald, localai);
              j = 1;
            }
          }
          boolean bool2 = localai.Nw();
          if (localai.exT == 0)
          {
            bool1 = true;
            label269:
            if ((locald.IBI == bool2) && (bool1 == locald.IBM)) {
              break label360;
            }
            locald.IBI = bool2;
            locald.IBM = bool1;
            locald.IBN = localai.WE();
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[] { str1 });
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
      this.IDH.clear();
      AppMethodBeat.o(38518);
      return;
    }
  }
  
  private static boolean fsp()
  {
    AppMethodBeat.i(196820);
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSU, false);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "isShowAppBrandNotifyMsgEntry: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(196820);
    return bool;
  }
  
  private CharSequence i(com.tencent.mm.storage.ap paramap)
  {
    AppMethodBeat.i(38495);
    if (paramap.field_status == 1)
    {
      paramap = this.context.getString(2131761075);
      AppMethodBeat.o(38495);
      return paramap;
    }
    if (paramap.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38495);
      return "";
    }
    paramap = com.tencent.mm.pluginsdk.g.h.c(this.context, paramap.field_conversationTime, true);
    AppMethodBeat.o(38495);
    return paramap;
  }
  
  static int k(com.tencent.mm.storage.ap paramap)
  {
    AppMethodBeat.i(196819);
    if ((paramap == null) || (paramap.field_unReadCount <= 0))
    {
      if (((paramap.lr(8388608)) || (paramap.lr(2097152))) && (paramap.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(196819);
        return 1;
      }
      AppMethodBeat.o(196819);
      return 0;
    }
    if (w.xg(paramap.field_username))
    {
      if ((com.tencent.mm.storage.v.bIO()) && (!paramap.lr(16)) && (!paramap.lr(64)))
      {
        AppMethodBeat.o(196819);
        return 0;
      }
      AppMethodBeat.o(196819);
      return 1;
    }
    if (w.xl(paramap.field_username))
    {
      com.tencent.mm.model.az.ayM();
      if (!com.tencent.mm.model.c.agA().getBoolean(ah.a.GJO, true))
      {
        AppMethodBeat.o(196819);
        return 1;
      }
    }
    if (w.xp(paramap.field_username))
    {
      com.tencent.mm.model.az.ayM();
      if (!com.tencent.mm.model.c.agA().getBoolean(ah.a.GJP, true))
      {
        AppMethodBeat.o(196819);
        return 1;
      }
    }
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(paramap.field_username);
    if ((localai != null) && ((int)localai.fLJ != 0))
    {
      if ((localai.Nw()) && (localai.WE()))
      {
        AppMethodBeat.o(196819);
        return 1;
      }
      if ((w.sQ(paramap.field_username)) && (localai.exT == 0))
      {
        AppMethodBeat.o(196819);
        return 1;
      }
    }
    if (w.xq(paramap.field_username))
    {
      AppMethodBeat.o(196819);
      return 1;
    }
    AppMethodBeat.o(196819);
    return 2;
  }
  
  private static String l(com.tencent.mm.storage.ap paramap)
  {
    AppMethodBeat.i(38510);
    if ((paramap.field_isSend == 0) && (w.sQ(paramap.field_username)))
    {
      paramap = com.tencent.mm.model.v.getDisplayName(paramap.field_digestUser, paramap.field_username);
      AppMethodBeat.o(38510);
      return paramap;
    }
    paramap = com.tencent.mm.model.v.wk(paramap.field_digestUser);
    AppMethodBeat.o(38510);
    return paramap;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(38517);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(38517);
      return;
    }
    String str = (String)paramObject;
    if ((paramn instanceof bk))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
      if ((!str.contains("@")) || (str.endsWith("@chatroom")) || (str.endsWith("@im.chatroom")) || (str.endsWith("@micromsg.qq.com")) || (com.tencent.mm.storage.ai.aNc(str))) {}
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.HGM != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.IDN = true;
            super.m(null, 1);
            AppMethodBeat.o(38517);
          }
        }
        else {
          this.IDM.add(str);
        }
      }
      i = paramInt;
      if (paramInt == 3) {
        i = 2;
      }
      super.m(str, i);
      AppMethodBeat.o(38517);
      return;
    }
    if ((paramn instanceof bj))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (!bs.isNullOrNil(str))
      {
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
        if ((paramn != null) && ((int)paramn.fLJ > 0)) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(paramn.Nw()), Integer.valueOf(paramn.exT) });
        }
      }
      if (this.uaQ)
      {
        AppMethodBeat.o(38517);
        return;
      }
      this.IDL = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if ((this.HGM == null) || (!this.HGM.containsKey(str)))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.IDH != null) {
        this.IDH.add(str);
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
    if (this.IDS != null)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(38500);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.IDS = paramString;
    f localf = (f)paramView.getTag();
    int j = paramView.getContext().getResources().getColor(2131099736);
    Resources localResources = paramView.getContext().getResources();
    if ((localf != null) && (localf.HGQ)) {}
    for (int i = 2131099651;; i = 2131099650)
    {
      this.IDT = new ColorDrawable(am.o(j, localResources.getColor(i)));
      paramView.setBackground(this.IDT);
      if (w.xq(paramString))
      {
        paramView = (com.tencent.mm.storage.ap)Za(paramInt);
        paramString = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        com.tencent.mm.kernel.g.agP();
        paramString.HF(bs.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
        paramString.a(new g.a(paramView.field_unReadCount, paramInt + 1));
      }
      AppMethodBeat.o(38500);
      return;
    }
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.ap>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(38514);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.g.agM()))
    {
      AppMethodBeat.o(38514);
      return paramArrayOfSparseArray;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[] { Integer.valueOf(paramHashSet.size()), Integer.valueOf(paramArrayOfSparseArray[0].size()) });
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (f.b)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((f.b)localObject3).HhY != 5) && (!((ArrayList)localObject1).contains(((f.b)localObject3).object)))
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((f.b)localObject3).object);
        ((ArrayList)localObject1).add(((f.b)localObject3).object);
      }
    }
    localObject2 = new HashMap();
    com.tencent.mm.model.az.ayM();
    Object localObject3 = com.tencent.mm.model.c.awG().a((ArrayList)localObject1, w.hmN, this.fzw, com.tencent.mm.o.a.fLL);
    Object localObject4;
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = new com.tencent.mm.storage.ap();
      ((com.tencent.mm.storage.ap)localObject4).convertFrom((Cursor)localObject3);
      ((HashMap)localObject2).put(((com.tencent.mm.g.c.az)localObject4).field_username, localObject4);
    }
    ((Cursor)localObject3).close();
    localObject3 = paramHashSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (f.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((f.b)localObject4).HhY != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((f.b)localObject4).object).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((f.b)localObject4).object) == null) {}
          for (boolean bool = true;; bool = false)
          {
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((f.b)localObject4).HhZ = ((HashMap)localObject2).get(((f.b)localObject4).object);
            break;
          }
        }
        ((f.b)localObject4).HhZ = null;
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
        if (((f.b)localObject2).HhY != 5) {
          ((HashMap)localObject1).put(((f.b)localObject2).object, ((f.b)localObject2).HhZ);
        }
      }
    }
    AppMethodBeat.o(38514);
    return paramArrayOfSparseArray;
  }
  
  public final ArrayList<com.tencent.mm.storage.ap> aY(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(38513);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    com.tencent.mm.model.az.ayM();
    paramArrayList = com.tencent.mm.model.c.awG().a(paramArrayList, w.hmN, this.fzw, com.tencent.mm.o.a.fLL);
    while (paramArrayList.moveToNext())
    {
      com.tencent.mm.storage.ap localap = new com.tencent.mm.storage.ap();
      localap.convertFrom(paramArrayList);
      localArrayList.add(localap);
    }
    paramArrayList.close();
    AppMethodBeat.o(38513);
    return localArrayList;
  }
  
  public final void abZ(int paramInt)
  {
    AppMethodBeat.i(38501);
    if (!fsm())
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
      AppMethodBeat.o(38501);
      return;
    }
    com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
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
  
  public final void aca(int paramInt)
  {
    AppMethodBeat.i(38521);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(38521);
      return;
    }
    try
    {
      com.tencent.mm.storage.ap localap = (com.tencent.mm.storage.ap)Za(paramInt);
      if (localap == null)
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
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ConversationWithCacheAdapter", "preLoad position:%s is null!", new Object[] { Integer.valueOf(paramInt) });
        localObject = null;
      }
      a.b.eMA().el(localObject.field_username);
      AppMethodBeat.o(38521);
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(38508);
    if (this.HGM != null)
    {
      this.HGM.clear();
      this.IDN = true;
    }
    AppMethodBeat.o(38508);
  }
  
  public final boolean fdB()
  {
    AppMethodBeat.i(38519);
    boolean bool = super.fdB();
    AppMethodBeat.o(38519);
    return bool;
  }
  
  public final com.tencent.mm.storagebase.a.d ffb()
  {
    AppMethodBeat.i(38512);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)com.tencent.mm.model.c.awG().a(w.hmN, this.fzw, com.tencent.mm.o.a.fLL, true);
    AppMethodBeat.o(38512);
    return locald;
  }
  
  public final void fqR()
  {
    boolean bool1 = true;
    AppMethodBeat.i(38496);
    if (this.fzw == null) {
      this.fzw = new ArrayList();
    }
    this.fzw.clear();
    int i;
    if ((com.tencent.mm.model.u.axA() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = com.tencent.mm.model.u.axP();
      if ((i == 0) || (!bool2)) {
        break label198;
      }
      label59:
      if (bool1 != this.IDO)
      {
        if (!bool1) {
          break label203;
        }
        com.tencent.mm.model.az.ayM();
        a(5, (n)com.tencent.mm.model.c.awG(), "floatbottle");
        label89:
        this.IDO = bool1;
      }
      if (this.IDO) {
        this.fzw.add("floatbottle");
      }
      this.fzw.add("qmessage");
      bool1 = fsp();
      if (bool1 != this.IDP)
      {
        if (!bool1) {
          break label224;
        }
        com.tencent.mm.model.az.ayM();
        a(2, (n)com.tencent.mm.model.c.awG(), "appbrand_notify_message");
      }
    }
    for (;;)
    {
      this.IDP = bool1;
      if (!this.IDP) {
        this.fzw.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38496);
      return;
      i = 0;
      break;
      label198:
      bool1 = false;
      break label59;
      label203:
      com.tencent.mm.model.az.ayM();
      a(2, (n)com.tencent.mm.model.c.awG(), "floatbottle");
      break label89;
      label224:
      com.tencent.mm.model.az.ayM();
      a(5, (n)com.tencent.mm.model.c.awG(), "appbrand_notify_message");
    }
  }
  
  public final void fsn()
  {
    AppMethodBeat.i(38502);
    super.m(null, 1);
    AppMethodBeat.o(38502);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38503);
    this.IDX = new a((byte)0);
    com.tencent.mm.storage.ap localap = (com.tencent.mm.storage.ap)Za(paramInt);
    String str = localap.field_username;
    this.IDV.re(str);
    Object localObject1;
    int i;
    Object localObject3;
    label485:
    label1016:
    boolean bool1;
    if (this.IDJ.containsKey(str))
    {
      if (paramInt != ((Integer)this.IDJ.get(str)).intValue())
      {
        localObject2 = ffc();
        paramViewGroup = ffd();
        localObject1 = new StringBuffer();
        int k = localObject2.length;
        i = 0;
        while (i < k)
        {
          localObject3 = localObject2[i];
          int j = 0;
          while ((j < ((SparseArray)localObject3).size()) && (j < 50))
          {
            ((StringBuffer)localObject1).append("[");
            ((StringBuffer)localObject1).append(j);
            ((StringBuffer)localObject1).append(",");
            ((StringBuffer)localObject1).append(((SparseArray)localObject3).keyAt(j));
            ((StringBuffer)localObject1).append(",");
            ((StringBuffer)localObject1).append((String)((SparseArray)localObject3).valueAt(j));
            ((StringBuffer)localObject1).append("]");
            j += 1;
          }
          i += 1;
        }
        ((StringBuffer)localObject1).append("\n");
        if (paramViewGroup != null)
        {
          localObject2 = paramViewGroup.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            if (i >= 50) {
              break;
            }
            i += 1;
            ((StringBuffer)localObject1).append("[");
            ((StringBuffer)localObject1).append(((Map.Entry)localObject3).getKey());
            ((StringBuffer)localObject1).append(",");
            if (((Map.Entry)localObject3).getValue() != null) {
              ((StringBuffer)localObject1).append(((com.tencent.mm.storage.ap)((Map.Entry)localObject3).getValue()).field_username);
            }
            ((StringBuffer)localObject1).append("]");
          }
          ((StringBuffer)localObject1).append("\n");
        }
        localObject1 = ((StringBuffer)localObject1).toString();
        localObject2 = this.IDJ.toString();
        if (paramViewGroup == null) {
          break label2176;
        }
        i = paramViewGroup.size();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject1, str, Integer.valueOf(paramInt), localObject2, Integer.valueOf(i) });
        if (!this.IDI)
        {
          com.tencent.mm.plugin.fts.a.e.Fy(20);
          this.IDI = true;
        }
        if (System.currentTimeMillis() - this.IDY > 3600000L)
        {
          super.m(null, 1);
          this.IDY = System.currentTimeMillis();
        }
      }
      if (paramView != null) {
        break label2220;
      }
      localObject1 = new f();
      if (!com.tencent.mm.cc.a.jdMethod_if(this.context)) {
        break label2199;
      }
      com.tencent.mm.kiss.a.b.ahR();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493666);
      label526:
      paramView.setTag(2131306044, new int[2]);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38489);
          if ((i.f(i.this) == null) || (i.f(i.this).getOnItemClickListener() == null))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            AppMethodBeat.o(38489);
            return;
          }
          if (paramAnonymousView.getTag() == null)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            AppMethodBeat.o(38489);
            return;
          }
          if (!i.this.HSw)
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
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
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            AppMethodBeat.o(38490);
            return false;
          }
          if (paramAnonymousView.getTag() == null)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            AppMethodBeat.o(38490);
            return false;
          }
          if (!i.this.HSw)
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
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
      ((f)localObject1).fuY = ((ImageView)paramView.findViewById(2131297008));
      a.b.c(((f)localObject1).fuY, str);
      paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)((f)localObject1).fuY.getDrawable();
      if (this.IBm != null) {
        this.IBm.a(paramViewGroup);
      }
      ((f)localObject1).fuY.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(38491);
          this.IEe.fuY.getViewTreeObserver().removeOnPreDrawListener(this);
          int i = this.IEe.fuY.getWidth();
          int j = ao.av(i.g(i.this), 2131165508);
          if (i != j)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.IEe.fuY.getLayoutParams();
            localLayoutParams.width = j;
            localLayoutParams.height = j;
            this.IEe.fuY.setLayoutParams(localLayoutParams);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", new Object[] { Integer.valueOf(this.IEe.fuY.getWidth()) });
            if (!i.h(i.this))
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(1055L, 4L, 1L, false);
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
              i.i(i.this);
            }
          }
          AppMethodBeat.o(38491);
          return true;
        }
      });
      ((f)localObject1).HGT = ((NoMeasuredTextView)paramView.findViewById(2131302867));
      ((f)localObject1).HGT.setLayoutCallback(this.IDQ);
      ((f)localObject1).HGU = ((NoMeasuredTextView)paramView.findViewById(2131306207));
      ((f)localObject1).IEn = ((ImageView)paramView.findViewById(2131301312));
      ((f)localObject1).HGV = ((NoMeasuredTextView)paramView.findViewById(2131301311));
      ((f)localObject1).ntH = ((TextView)paramView.findViewById(2131305882));
      ((f)localObject1).IEo = ((WeImageView)paramView.findViewById(2131300954));
      ((f)localObject1).HGY = paramView.findViewById(2131297015);
      ((f)localObject1).IBR = ((ImageView)paramView.findViewById(2131301541));
      ((f)localObject1).IEp = ((ImageView)paramView.findViewById(2131302581));
      ((f)localObject1).ntH.setBackgroundResource(com.tencent.mm.ui.tools.u.ks(this.context));
      ((f)localObject1).ntH.setTextSize(0, com.tencent.mm.cc.a.av(this.context, 2131166949) * com.tencent.mm.cc.a.ib(this.context));
      ((f)localObject1).IEq = new c();
      paramView.setTag(localObject1);
      ((f)localObject1).HGV.setTextSize(0, com.tencent.mm.cc.a.au(this.context, 2131165574));
      ((f)localObject1).HGU.setTextSize(0, com.tencent.mm.cc.a.au(this.context, 2131165576));
      ((f)localObject1).HGT.setTextSize(0, com.tencent.mm.cc.a.au(this.context, 2131165517));
      this.IDW = ((f)localObject1).HGT.getTextSize();
      ((f)localObject1).HGV.setTextColor(this.HGK[0]);
      ((f)localObject1).HGU.setTextColor(this.HGK[4]);
      ((f)localObject1).HGT.setTextColor(this.HGK[3]);
      ((f)localObject1).HGV.setShouldEllipsize(true);
      ((f)localObject1).HGU.setShouldEllipsize(false);
      ((f)localObject1).HGT.setShouldEllipsize(true);
      if (((f)localObject1).HGT.getPaint() != null) {
        aj.a(((f)localObject1).HGT.getPaint(), 0.1F);
      }
      ((f)localObject1).HGU.setGravity(5);
      paramViewGroup = paramView;
      localObject3 = j(localap);
      ((f)localObject1).position = paramInt;
      ((f)localObject1).username = str;
      if ((!((d)localObject3).HGQ) || (localap.field_conversationTime == -1L)) {
        break label2234;
      }
      bool1 = true;
      label1060:
      ((f)localObject1).HGQ = bool1;
      if (((d)localObject3).IBD == null) {
        ((d)localObject3).IBD = b(localap, (int)((f)localObject1).HGV.getTextSize(), ((d)localObject3).IBK);
      }
      if ((w.xg(localap.field_username)) && (((d)localObject3).IBD != null))
      {
        paramView = d.IBj;
        if (d.frN())
        {
          paramView = r.GBV;
          r.aL(((d)localObject3).IBD.toString(), paramInt, localap.field_unReadCount);
          paramView = com.tencent.mm.plugin.brandservice.b.c.nva;
          com.tencent.mm.plugin.brandservice.b.c.s(1, "", "");
        }
      }
      if (((d)localObject3).IBC == null) {
        ((d)localObject3).IBC = i(localap);
      }
      if (!((d)localObject3).IBK) {
        break label2240;
      }
      ((f)localObject1).HGV.setTextColor(this.HGK[0]);
      label1205:
      com.tencent.mm.booter.notification.a.h.kB(((f)localObject1).HGV.getWidth());
      com.tencent.mm.booter.notification.a.h.kC((int)((f)localObject1).HGV.getTextSize());
      com.tencent.mm.booter.notification.a.h.b(((f)localObject1).HGV.getPaint());
      if ((!w.wq(str)) && (!w.ws(str))) {
        break label2261;
      }
      ((f)localObject1).HGT.setCompoundRightDrawablesWithIntrinsicBounds(2131691000);
      ((f)localObject1).HGT.setDrawRightDrawable(true);
      label1275:
      i = ((d)localObject3).IBE;
      if (i == -1) {
        break label2284;
      }
      ((f)localObject1).HGV.setCompoundLeftDrawablesWithIntrinsicBounds(i);
      ((f)localObject1).HGV.setDrawLeftDrawable(true);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((d)localObject3).IBE) });
      label1335:
      if (!com.tencent.mm.storage.ai.aNc(localap.field_username)) {
        break label2318;
      }
      this.IDV.re(localap.field_username);
      Object localObject4 = this.IDV.dqK();
      paramView = "";
      if (localObject4 != null) {
        paramView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bB(((av)localObject4).field_openImAppid, ((av)localObject4).field_descWordingId);
      }
      if (bs.isNullOrNil(paramView)) {
        break label2304;
      }
      Object localObject2 = paramView;
      if ("3552365301".equals(((av)localObject4).field_openImAppid)) {
        localObject2 = "@".concat(String.valueOf(paramView));
      }
      ((f)localObject1).HGT.aP((String)localObject2, 2131100528, 14);
      label1451:
      ((f)localObject1).HGT.setText(((d)localObject3).nickName);
      paramView = ((f)localObject1).HGU.getLayoutParams();
      if (((d)localObject3).IBC.length() < 9) {
        break label2341;
      }
      if (paramView.width != this.IBv)
      {
        paramView.width = this.IBv;
        ((f)localObject1).HGU.setLayoutParams(paramView);
      }
      label1516:
      ((f)localObject1).HGU.setText(((d)localObject3).IBC);
      ((f)localObject1).HGV.setText(((d)localObject3).IBD);
      if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localap, 7, 0L) <= 0L) {
        break label2372;
      }
      bool1 = true;
      label1558:
      localObject2 = localap.field_username;
      long l1 = localap.field_conversationTime;
      localObject4 = ((d)localObject3).IBC;
      boolean bool2 = ((f)localObject1).HGQ;
      long l2 = localap.field_flag;
      long l3 = localap.field_flag;
      if ((((d)localObject3).nickName != null) && (((d)localObject3).nickName.length() > 0)) {
        break label2378;
      }
      paramView = "?";
      label1625:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "[getView] position=%s username=%s conversationTime=%s updateTime=%s isPlacedTop=%s isTalkRoomTopPlace=%s flag=%s flagTime=%s nickname=%s", new Object[] { Integer.valueOf(paramInt), localObject2, Long.valueOf(l1), localObject4, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3 & 0xFFFFFFFF), paramView });
      ((f)localObject1).IEn.setVisibility(8);
      ((f)localObject1).IEo.setVisibility(8);
      if (!((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).afb(str)) {
        break label2396;
      }
      ((f)localObject1).IEo.setVisibility(0);
      ((f)localObject1).IEo.setImageDrawable(am.k(this.context, 2131690531, this.context.getResources().getColor(2131099982)));
      label1785:
      a.b.c(((f)localObject1).fuY, str);
      if (this.IBk)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "handleShowTipCnt.");
        if ((localap != null) && (localObject1 != null) && (localObject3 != null)) {
          break label2475;
        }
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
      }
      label1833:
      if ((!((d)localObject3).IBH) && (((d)localObject3).HGQ) && (com.tencent.mm.model.az.agM()))
      {
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().g(localap);
      }
      if ((this.IDS == null) || (!this.IDS.equals(str))) {
        break label2728;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), this.IDS });
      paramViewGroup.findViewById(2131298792).setBackground(this.IDT);
      label1932:
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
      if ((com.tencent.mm.bi.d.hXY == null) || (!com.tencent.mm.bi.d.hXY.DF(localap.field_username))) {
        break label2780;
      }
      ((f)localObject1).IBR.setVisibility(0);
      label1989:
      if ((!w.sQ(localap.field_username)) || (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class) == null) || (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amm(localap.field_username))) {
        break label2827;
      }
      if ((!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).dfn()) || (!((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).hL(localap.field_username, com.tencent.mm.model.u.axw()))) {
        break label2793;
      }
      ((f)localObject1).IEp.setImageResource(2131689895);
      label2084:
      ((f)localObject1).IEp.setVisibility(0);
    }
    for (;;)
    {
      this.IDX.content = String.valueOf(((d)localObject3).IBD);
      this.IDX.bLs = ((d)localObject3).fBV;
      this.IDX.time = String.valueOf(((d)localObject3).IBC);
      paramView = this.IDX;
      a.a.fhP().a(paramViewGroup, paramView.bLs, paramView.IBB, paramView.time, paramView.content);
      paramViewGroup.setAlpha(1.0F);
      AppMethodBeat.o(38503);
      return paramViewGroup;
      label2176:
      i = 0;
      break;
      this.IDJ.put(str, Integer.valueOf(paramInt));
      break label485;
      label2199:
      com.tencent.mm.kiss.a.b.ahR();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493664);
      break label526;
      label2220:
      localObject1 = (f)paramView.getTag();
      paramViewGroup = paramView;
      break label1016;
      label2234:
      bool1 = false;
      break label1060;
      label2240:
      ((f)localObject1).HGV.setTextColor(this.HGK[localObject3.oeH]);
      break label1205;
      label2261:
      if (!((f)localObject1).HGT.HCm) {
        break label1275;
      }
      ((f)localObject1).HGT.setDrawRightDrawable(false);
      break label1275;
      label2284:
      ((f)localObject1).HGV.setDrawLeftDrawable(false);
      ((f)localObject1).HGV.invalidate();
      break label1335;
      label2304:
      ((f)localObject1).HGT.aP(null, 0, 0);
      break label1451;
      label2318:
      w.wq(localap.field_username);
      ((f)localObject1).HGT.aP(null, 0, 0);
      break label1451;
      label2341:
      if (paramView.width == this.IBu) {
        break label1516;
      }
      paramView.width = this.IBu;
      ((f)localObject1).HGU.setLayoutParams(paramView);
      break label1516;
      label2372:
      bool1 = false;
      break label1558;
      label2378:
      paramView = Character.valueOf(((d)localObject3).nickName.charAt(0));
      break label1625;
      label2396:
      ((f)localObject1).IEo.setImageDrawable(am.k(this.context, 2131690523, this.context.getResources().getColor(2131099982)));
      if (((d)localObject3).qKi)
      {
        if (!((d)localObject3).IBM) {
          break label1785;
        }
        ((f)localObject1).IEo.setVisibility(0);
        break label1785;
      }
      if (!((d)localObject3).IBI) {
        break label1785;
      }
      ((f)localObject1).IEo.setVisibility(0);
      break label1785;
      label2475:
      ((f)localObject1).ntH.setVisibility(4);
      ((f)localObject1).HGY.setVisibility(4);
      if ((!w.wz(localap.field_username)) && (((d)localObject3).IBL) && ((((d)localObject3).IBG == 1) || (((d)localObject3).IBG == 2) || (((d)localObject3).IBG == 3))) {}
      for (paramView = this.HGK[2];; paramView = this.HGK[3])
      {
        ((f)localObject1).HGT.setTextColor(paramView);
        if ((!((d)localObject3).IBL) || (((d)localObject3).IBF == 0)) {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
        }
        paramInt = k(localap);
        if (paramInt != 1) {
          break label2612;
        }
        ((f)localObject1).HGY.setVisibility(0);
        break;
      }
      label2612:
      if (paramInt != 2) {
        break label1833;
      }
      paramInt = localap.field_unReadCount;
      if (paramInt > 99)
      {
        ((f)localObject1).ntH.setText("");
        ((f)localObject1).ntH.setBackgroundResource(2131689744);
        ((f)localObject1).ntH.setVisibility(0);
      }
      for (;;)
      {
        this.IDX.IBB = paramInt;
        break;
        if (paramInt > 0)
        {
          ((f)localObject1).ntH.setText(localap.field_unReadCount);
          ((f)localObject1).ntH.setVisibility(0);
          ((f)localObject1).ntH.setBackgroundResource(com.tencent.mm.ui.tools.u.aM(this.context, paramInt));
        }
      }
      label2728:
      if ((((d)localObject3).HGQ) && (localap.field_conversationTime != -1L))
      {
        paramViewGroup.findViewById(2131298792).setBackgroundResource(2131232872);
        break label1932;
      }
      paramViewGroup.findViewById(2131298792).setBackgroundResource(2131231854);
      break label1932;
      label2780:
      ((f)localObject1).IBR.setVisibility(8);
      break label1989;
      label2793:
      ((f)localObject1).IEp.setImageDrawable(am.k(this.context, 2131690409, this.context.getResources().getColor(2131099982)));
      break label2084;
      label2827:
      ((f)localObject1).IEp.setVisibility(8);
    }
  }
  
  public final void ghi()
  {
    AppMethodBeat.i(210143);
    if ((this.HGM == null) || (this.IDM == null) || (this.IDM.isEmpty()))
    {
      AppMethodBeat.o(210143);
      return;
    }
    if (this.IDN)
    {
      this.HGM.clear();
      this.IDN = false;
      this.IDM.clear();
      AppMethodBeat.o(210143);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(this.IDM.size()) });
    Iterator localIterator = this.IDM.iterator();
    while (localIterator.hasNext()) {
      this.HGM.remove(localIterator.next());
    }
    this.IDM.clear();
    AppMethodBeat.o(210143);
  }
  
  final d j(com.tencent.mm.storage.ap paramap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38504);
    String str2 = paramap.field_username;
    Object localObject;
    if (this.HGM != null)
    {
      localObject = (d)this.HGM.get(str2);
      if (localObject != null)
      {
        AppMethodBeat.o(38504);
        return localObject;
      }
    }
    d locald = new d((byte)0);
    this.IDV.re(str2);
    com.tencent.mm.storage.ai localai = this.IDV.dqK();
    if (localai != null)
    {
      locald.IBG = localai.eyd;
      locald.IBF = ((int)localai.fLJ);
      if (localai == null) {
        break label532;
      }
      bool1 = true;
      label111:
      locald.IBL = bool1;
      if ((localai == null) || (!localai.WE())) {
        break label537;
      }
      bool1 = true;
      label132:
      locald.IBN = bool1;
      if ((localai == null) || (localai.exT != 0)) {
        break label542;
      }
      bool1 = true;
      label153:
      locald.IBM = bool1;
      locald.qKi = w.wo(str2);
      if ((!locald.qKi) || (!locald.IBM) || (paramap.field_unReadCount <= 0)) {
        break label547;
      }
      bool1 = true;
      label194:
      locald.IBK = bool1;
      locald.oeH = 0;
      if ((Tf(paramap.field_msgType) == 34) && (paramap.field_isSend == 0) && (!bs.isNullOrNil(paramap.field_content)))
      {
        String str1 = paramap.field_content;
        if ((!str2.equals("qmessage")) && (!str2.equals("floatbottle")) && (!str2.equals("officialaccounts")) && (!paramap.lr(2097152)))
        {
          localObject = str1;
          if (!paramap.lr(8388608)) {}
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
        if (!new p((String)localObject).iaD) {
          locald.oeH = 1;
        }
      }
      locald.fBV = com.tencent.mm.model.v.a(localai, str2, locald.qKi);
      a(locald, localai);
      locald.IBC = i(paramap);
      locald.IBE = abM(paramap.field_status);
      locald.IBH = w.a(paramap);
      com.tencent.mm.model.az.ayM();
      locald.HGQ = com.tencent.mm.model.c.awG().h(paramap);
      if ((localai == null) || (!localai.Nw())) {
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
      locald.IBI = bool1;
      if (this.HGM != null) {
        this.HGM.put(str2, locald);
      }
      AppMethodBeat.o(38504);
      return locald;
      locald.IBG = -1;
      locald.IBF = -1;
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
    if (!this.IEa)
    {
      super.notifyDataSetChanged();
      this.IDJ.clear();
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    AppMethodBeat.o(38522);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38497);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.HSw);
    if (!this.HSw)
    {
      AppMethodBeat.o(38497);
      return;
    }
    this.HSw = false;
    super.pause();
    if (this.ntD != null) {
      this.ntD.cVr();
    }
    AppMethodBeat.o(38497);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(38499);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.HSw);
    if (this.HSw)
    {
      AppMethodBeat.o(38499);
      return;
    }
    this.HSw = true;
    fqR();
    fso();
    com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "newcursor resume syncNow ");
    this.HhL = true;
    lw(true);
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.g.g.a("MM/dd", (Time)localObject).toString();
    String str = ab.eUO();
    if ((!this.IBs.equals(localObject)) || (!this.IDR.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.IBs = ((String)localObject);
      this.IDR = str;
      if (i != 0) {
        frO();
      }
      if ((this.IBn) && (this.IDG != null))
      {
        this.IDG.fsq();
        this.IBn = false;
        super.m(null, 1);
      }
      AppMethodBeat.o(38499);
      return;
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
  
  public static abstract interface b
  {
    public abstract void fsq();
  }
  
  final class c
  {
    public View HyK = null;
    boolean IEf = false;
    boolean IEg = false;
    boolean IEh = false;
    boolean IEi = false;
    boolean IEj = false;
    public ImageView IEk = null;
    public TextView IEl = null;
    public View IEm = null;
    public View ntI = null;
    public TextView ntJ = null;
    String username = "";
    
    c() {}
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
    public boolean IBK;
    public boolean IBL;
    public boolean IBM;
    public boolean IBN;
    public String fBV;
    public CharSequence nickName;
    public int oeH;
    public boolean qKi;
    
    private d() {}
  }
  
  final class e
  {
    private Integer IBP = null;
    private com.tencent.mm.storage.ai contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final com.tencent.mm.storage.ai dqK()
    {
      AppMethodBeat.i(38493);
      if ((this.initialized) && (this.contact == null) && (com.tencent.mm.model.az.agM()))
      {
        com.tencent.mm.model.az.ayM();
        this.contact = com.tencent.mm.model.c.awB().aNt(this.talker);
      }
      com.tencent.mm.storage.ai localai = this.contact;
      AppMethodBeat.o(38493);
      return localai;
    }
    
    public final void re(String paramString)
    {
      AppMethodBeat.i(38492);
      this.talker = paramString;
      this.contact = null;
      this.IBP = null;
      this.initialized = false;
      if (!bs.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(38492);
    }
  }
  
  public static final class f
  {
    public boolean HGQ;
    public NoMeasuredTextView HGT;
    public NoMeasuredTextView HGU;
    public NoMeasuredTextView HGV;
    public View HGY;
    public ImageView IBR;
    public ImageView IEn;
    public WeImageView IEo;
    public ImageView IEp;
    public i.c IEq;
    public ImageView fuY;
    public TextView ntH;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */