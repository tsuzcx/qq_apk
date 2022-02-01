package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
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
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.h.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.e.a;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.gnx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.g.a;
import com.tencent.mm.ui.g.b;
import com.tencent.mm.ui.g.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.ah;
import kotlin.g.b.s;

public final class k
  extends com.tencent.mm.ui.g<String, com.tencent.mm.storage.bb>
  implements MStorageEx.IOnStorageChange
{
  public static HashMap<String, Integer> afoc;
  boolean Kgb;
  boolean Rdz;
  MStorage.IOnStorageChange adKf;
  private float aeaW;
  private float aeaZ;
  private float aeba;
  private ColorStateList[] aebb;
  HashMap<String, d> aebd;
  public boolean aepk;
  private NoMeasuredTextView.c afaM;
  private boolean afmI;
  com.tencent.mm.pluginsdk.ui.e afmK;
  private boolean afmL;
  IListener afmO;
  public String afmQ;
  private final int afmS;
  private final int afmT;
  private boolean afnX;
  private aaq afnY;
  b afnZ;
  private m afnw;
  private HashSet<String> afoa;
  private boolean afob;
  private HashMap<String, Integer> afod;
  HashMap<String, List<Long>> afoe;
  HashMap<String, Integer> afof;
  private boolean afog;
  HashSet<String> afoh;
  boolean afoi;
  private boolean afoj;
  private boolean afok;
  public String afol;
  boolean afom;
  private String afon;
  private ColorDrawable afoo;
  ValueAnimator afop;
  final e afoq;
  private float afor;
  private final int afos;
  private final int afot;
  private a afou;
  private long afov;
  private boolean afow;
  boolean afox;
  protected List<String> lMF;
  private ListView mListView;
  private boolean pVy;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.d vzi;
  
  static
  {
    AppMethodBeat.i(257280);
    afoc = new HashMap();
    AppMethodBeat.o(257280);
  }
  
  public k(Context paramContext, ListView paramListView, m paramm, g.a parama)
  {
    super(paramContext, (short)0);
    AppMethodBeat.i(257090);
    this.lMF = null;
    this.aebb = new ColorStateList[5];
    this.afmI = true;
    this.afnX = false;
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    this.afnY = null;
    this.pVy = false;
    this.aeaW = -1.0F;
    this.aeaZ = -1.0F;
    this.aeba = -1.0F;
    this.afmL = false;
    this.afmO = null;
    this.afnZ = null;
    this.aepk = false;
    this.afob = false;
    this.afod = new HashMap();
    this.afoe = new HashMap();
    this.afof = new HashMap();
    this.afog = false;
    this.afoi = false;
    this.afoj = false;
    this.afok = false;
    this.afaM = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38482);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.cd.a.fromDPToPix(k.a(k.this), paramAnonymousInt2);
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
          paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.span.p.b(k.b(k.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.cd.a.l(k.c(k.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(38482);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.afmQ = "";
    this.afol = "";
    this.afom = true;
    this.adKf = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(38488);
        k.this.notifyDataSetChanged();
        AppMethodBeat.o(38488);
      }
    };
    this.afoq = new e();
    this.Rdz = false;
    this.afor = -1.0F;
    this.afov = 0L;
    this.afow = false;
    this.Kgb = false;
    this.afox = false;
    this.mListView = paramListView;
    this.afnw = paramm;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.aebb[0] = com.tencent.mm.cd.a.l(paramContext, R.e.hint_text_color);
    this.aebb[1] = com.tencent.mm.cd.a.l(paramContext, R.e.red_text_color);
    this.aebb[3] = com.tencent.mm.cd.a.l(paramContext, R.e.normal_text_color);
    this.aebb[2] = com.tencent.mm.cd.a.l(paramContext, R.e.Link);
    this.aebb[2] = com.tencent.mm.cd.a.l(paramContext, R.e.Link);
    this.aebb[4] = com.tencent.mm.cd.a.l(paramContext, R.e.hint_text_color);
    if (com.tencent.mm.cd.a.mq(paramContext))
    {
      this.afmT = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeLargerWidth);
      this.afmS = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
    }
    for (;;)
    {
      this.afos = ((int)(paramContext.getResources().getDimension(R.f.NormalListHeight) + 0.5F));
      this.afot = ((int)(paramContext.getResources().getDimension(R.f.ListFoldHeight) + 0.5F));
      this.aebd = new HashMap();
      this.afoa = new HashSet();
      this.afoh = new HashSet();
      this.aeaW = paramContext.getResources().getDimension(R.f.NormalTextSize);
      this.aeaZ = paramContext.getResources().getDimension(R.f.HintTextSize);
      this.aeba = paramContext.getResources().getDimension(R.f.SmallestTextSize);
      this.lMF = new ArrayList();
      this.lMF.add("qmessage");
      this.afok = jAk();
      if (!this.afok) {
        this.lMF.add("appbrand_notify_message");
      }
      AppMethodBeat.o(257090);
      return;
      if (com.tencent.mm.cd.a.mp(paramContext))
      {
        this.afmT = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
        this.afmS = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
      }
      else
      {
        this.afmT = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
        this.afmS = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth);
      }
    }
  }
  
  private SparseArray<String> a(g.b<String, com.tencent.mm.storage.bb> paramb, SparseArray<String> paramSparseArray, HashMap<String, com.tencent.mm.storage.bb> paramHashMap)
  {
    AppMethodBeat.i(38516);
    String str = (String)paramb.object;
    int k = paramSparseArray.size();
    com.tencent.mm.storage.bb localbb = (com.tencent.mm.storage.bb)paramb.adxy;
    int j = paramSparseArray.size();
    int i = 0;
    label39:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d, changeType:%s", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramb.adxx) });
      switch (paramb.adxx)
      {
      case 3: 
      case 4: 
      default: 
        if (i >= 0) {
          break label436;
        }
        Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
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
      Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_DELETE  position < 0");
      AppMethodBeat.o(38516);
      return paramSparseArray;
    }
    while (j < k - 1)
    {
      paramSparseArray.put(j, (String)paramSparseArray.get(j + 1));
      j += 1;
    }
    paramSparseArray.remove(k - 1);
    for (;;)
    {
      AppMethodBeat.o(38516);
      return paramSparseArray;
      if (localbb == null)
      {
        Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
        if (i >= 0)
        {
          Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[] { str });
          while (i < k - 1)
          {
            paramSparseArray.put(i, (String)paramSparseArray.get(i + 1));
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
      while ((i < k) && (g((String)paramSparseArray.get(i), paramHashMap).field_flag > localbb.field_flag)) {
        i += 1;
      }
      j = k;
      while (j > i)
      {
        paramSparseArray.put(j, (String)paramSparseArray.get(j - 1));
        j -= 1;
      }
      paramSparseArray.put(i, str);
    }
    label436:
    paramb = g(str, paramHashMap);
    if (localbb == null)
    {
      Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[] { str });
      while (i < k - 1)
      {
        paramSparseArray.put(i, (String)paramSparseArray.get(i + 1));
        i += 1;
      }
      paramSparseArray.remove(k - 1);
      AppMethodBeat.o(38516);
      return paramSparseArray;
    }
    long l1 = paramb.field_flag;
    long l2 = localbb.field_flag;
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
      label566:
      k = j;
      label570:
      if (k > n) {
        break label836;
      }
      if (g((String)paramSparseArray.get(k), paramHashMap).field_flag > localbb.field_flag) {
        break label728;
      }
    }
    label836:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(-1), Boolean.valueOf(bool1), Integer.valueOf(i), str });
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (m == 0)
        {
          bool2 = bool1;
          if (k == n + 1) {
            bool2 = true;
          }
        }
      }
      if (!bool2)
      {
        AppMethodBeat.o(38516);
        return paramSparseArray;
        j = i + 1;
        n = k - 1;
        m = 0;
        break label566;
        label728:
        k += 1;
        break label570;
      }
      if (m != 0) {
        while (i > k)
        {
          paramSparseArray.put(i, (String)paramSparseArray.get(i - 1));
          i -= 1;
        }
      }
      j = k - 1;
      while (i < j)
      {
        paramSparseArray.put(i, (String)paramSparseArray.get(i + 1));
        i += 1;
      }
      for (i = j;; i = k)
      {
        paramSparseArray.put(i, str);
        break;
      }
    }
  }
  
  private CharSequence a(com.tencent.mm.storage.bb parambb, int paramInt, boolean paramBoolean, gnx paramgnx)
  {
    AppMethodBeat.i(257193);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (parambb.field_remitMarkRed == 1)
    {
      paramgnx.aciP = 101;
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.gSR));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject1);
      Log.i("MicroMsg.ConversationWithCacheAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { parambb.field_username, Integer.valueOf(parambb.field_attrflag) });
    }
    while (((!Util.isNullOrNil(parambb.field_editingMsg)) || (parambb.field_editingQuoteMsgId != 0L)) && ((parambb.field_atCount <= 0) || ((parambb.field_unReadCount <= 0) && (parambb.field_unReadMuteCount <= 0))) && (parambb.field_hasSpecialFollow == 0))
    {
      paramgnx.aciP = 101;
      paramgnx = new SpannableStringBuilder(this.context.getString(R.l.gNc));
      paramgnx.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, paramgnx.length(), 33);
      if (!Util.isNullOrNil(parambb.field_editingMsg)) {
        paramgnx.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.d(this.context, parambb.field_editingMsg, paramInt));
      }
      parambb = localSpannableStringBuilder.append(paramgnx);
      AppMethodBeat.o(257193);
      return parambb;
      if (parambb.field_hbMarkRed == 1)
      {
        paramgnx.aciP = 101;
        localObject1 = new SpannableStringBuilder(this.context.getString(R.l.grU));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        localSpannableStringBuilder.append((CharSequence)localObject1);
        Log.i("MicroMsg.ConversationWithCacheAdapter", "mark hb flag conversation: %s", new Object[] { parambb.field_username });
      }
    }
    if ((aip(parambb.field_msgType) == 10000) && (!ab.c(parambb)) && (parambb.field_hasTodo != 1) && (parambb.field_hasSpecialFollow == 0))
    {
      if (parambb.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
      {
        Log.i("MicroMsg.ConversationWithCacheAdapter", "is transfer remind msg ");
        parambb = localSpannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.h(this.context, parambb.field_content, paramInt));
        AppMethodBeat.o(257193);
        return parambb;
      }
      if (parambb.field_hbMarkRed == 1)
      {
        parambb = localSpannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.h(this.context, parambb.field_content, paramInt));
        AppMethodBeat.o(257193);
        return parambb;
      }
      if (parambb.field_remitMarkRed == 1)
      {
        parambb = localSpannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.span.p.h(this.context, parambb.field_content, paramInt));
        AppMethodBeat.o(257193);
        return parambb;
      }
      parambb = new SpannableString(com.tencent.mm.pluginsdk.ui.span.p.h(this.context, parambb.field_content, paramInt));
      AppMethodBeat.o(257193);
      return parambb;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    Object localObject5;
    if (aip(parambb.field_msgType) == 49)
    {
      localObject4 = aa.getDisplayName(parambb.field_digestUser);
      localObject5 = com.tencent.mm.message.k.b.Hf(parambb.field_content);
      localObject1 = localObject2;
      if (localObject5 == null) {}
    }
    switch (((com.tencent.mm.message.k.b)localObject5).type)
    {
    default: 
      localObject1 = localObject2;
      localObject2 = parambb.field_digest;
      if ((localObject2 == null) || (!((String)localObject2).startsWith("<img src=\"original_label.png\"/>  "))) {
        break;
      }
    }
    label753:
    label1535:
    Object localObject3;
    label822:
    label961:
    label993:
    label1003:
    String str;
    for (localObject2 = new SpannableString(com.tencent.mm.pluginsdk.ui.span.p.e(this.context, (CharSequence)localObject2, paramInt));; localObject3 = str)
    {
      localObject5 = parambb.field_username;
      localObject1 = localObject2;
      int i;
      if (((String)localObject5).equals("qqmail"))
      {
        bh.bCz();
        if (Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(17, null)) != 1) {
          break label1535;
        }
        i = 1;
        localObject1 = localObject2;
        if (i == 0) {
          localObject1 = this.context.getString(R.l.settings_plugins_disable);
        }
      }
      localObject4 = localObject1;
      if (((String)localObject5).equals("tmessage"))
      {
        bh.bCz();
        localObject2 = com.tencent.mm.model.c.bzJ().aMh("@t.qq.com");
        if ((localObject2 == null) || (!((cm)localObject2).isEnable())) {
          break label1541;
        }
        i = 1;
        localObject4 = localObject1;
        if (i == 0) {
          localObject4 = this.context.getString(R.l.settings_plugins_disable);
        }
      }
      localObject2 = localObject4;
      if (parambb.field_msgType != null)
      {
        localObject2 = localObject4;
        if (parambb.field_msgType.equals("64")) {
          localObject2 = parambb.field_content;
        }
      }
      if ((parambb.field_msgType != null) && ((parambb.field_msgType.equals("47")) || (parambb.field_msgType.equals("1048625"))))
      {
        localObject1 = bAr(parambb.field_digest);
        localObject5 = "";
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject1 = "[" + (String)localObject1 + "]";
          localObject4 = localObject5;
          localObject2 = localObject1;
          if (Util.isNullOrNil((CharSequence)localObject1))
          {
            localObject2 = this.context.getString(R.l.app_emoji);
            if (!Util.isNullOrNil((String)localObject4)) {
              break label1753;
            }
            parambb.BF((String)localObject2);
            localObject2 = localObject1;
          }
          localObject1 = localObject2;
          if (Util.isNullOrNil((CharSequence)localObject2))
          {
            if (Util.isNullOrNil(parambb.field_digest)) {
              break label1810;
            }
            if (Util.isNullOrNil(parambb.field_digestUser)) {
              break label1799;
            }
            localObject1 = r(parambb);
          }
        }
      }
      for (;;)
      {
        label1541:
        label1753:
        try
        {
          localObject1 = String.format(parambb.field_digest, new Object[] { localObject1 });
          localObject1 = ((CharSequence)localObject1).toString().replace('\n', ' ');
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject1, paramInt);
          if ((!parambb.rx(33554432)) || ((parambb.field_unReadCount <= 0) && (parambb.field_unReadMuteCount <= 0))) {
            break label1841;
          }
          paramgnx.aciP = 101;
          parambb = new SpannableStringBuilder(this.context.getString(R.l.gWA));
          parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
          parambb.append(" ").append((CharSequence)localObject1);
          parambb = localSpannableStringBuilder.append(parambb);
          AppMethodBeat.o(257193);
          return parambb;
        }
        catch (Exception localException1) {}
        localObject5 = com.tencent.mm.message.t.Hk(parambb.field_content);
        localObject1 = localObject2;
        if (localObject5 == null) {
          break;
        }
        localObject1 = localObject2;
        if (((com.tencent.mm.message.t)localObject5).nUJ != 19) {
          break;
        }
        if (Util.isNullOrNil((String)localObject4))
        {
          localObject1 = this.context.getString(R.l.app_record);
          parambb.BF((String)localObject1);
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject1, paramInt);
          break;
        }
        localObject1 = (String)localObject4 + ": " + this.context.getString(R.l.app_record);
        continue;
        localObject1 = null;
        try
        {
          localObject2 = String.format(parambb.field_digest, new Object[] { r(parambb) });
          localObject1 = localObject2;
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", localException2, "", new Object[0]);
          continue;
          i = R.l.app_url;
          continue;
        }
        localObject2 = this.context;
        if (((com.tencent.mm.message.k.b)localObject5).type == 4)
        {
          i = R.l.app_video;
          localObject4 = ((Context)localObject2).getString(i);
          localObject6 = new StringBuilder();
          localObject2 = localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            localObject2 = localObject4;
          }
          localObject1 = (String)localObject2 + " " + ((com.tencent.mm.message.k.b)localObject5).title;
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.h(this.context, (CharSequence)localObject1, paramInt);
          break;
        }
        if (Util.isNullOrNil((String)localObject4))
        {
          localObject1 = this.context.getString(R.l.app_record);
          parambb.BF((String)localObject1);
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject1, paramInt);
          break;
        }
        localObject1 = (String)localObject4 + ": " + this.context.getString(R.l.app_record);
        continue;
        i = 0;
        break label753;
        i = 0;
        break label822;
        localObject4 = localObject5;
        localObject1 = localException2;
        if (parambb.field_digest == null) {
          break label961;
        }
        localObject4 = localObject5;
        localObject1 = localException2;
        if (!parambb.field_digest.contains(":")) {
          break label961;
        }
        localObject5 = parambb.field_digest.substring(0, parambb.field_digest.indexOf(":"));
        Object localObject6 = bAr(parambb.field_digest.substring(parambb.field_digest.indexOf(":") + 1).replace(" ", ""));
        localObject4 = localObject5;
        localObject1 = localException2;
        if (Util.isNullOrNil((String)localObject6)) {
          break label961;
        }
        localObject3 = "[" + (String)localObject6 + "]";
        if (Util.isNullOrNil((String)localObject5))
        {
          localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject5, paramInt);
          localObject4 = localObject5;
          break label961;
        }
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject5, paramInt));
        ((SpannableStringBuilder)localObject1).append(": ");
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
        localObject4 = localObject5;
        break label961;
        localObject3 = (String)localObject4 + ": " + (String)localObject3;
        break label993;
        localObject3 = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, (CharSequence)localObject3, paramInt);
        break label1003;
        label1799:
        localObject1 = parambb.field_digest;
        continue;
        label1810:
        str = com.tencent.mm.booter.notification.a.h.a(parambb.field_isSend, parambb.field_username, parambb.field_content, aip(parambb.field_msgType), this.context);
      }
      label1841:
      if (parambb.field_UnReadInvite > 0)
      {
        paramgnx.aciP = 101;
        if (parambb.field_UnReadInvite < 4096) {}
        for (parambb = this.context.getString(R.l.gMZ, new Object[] { Integer.valueOf(parambb.field_UnReadInvite) });; parambb = this.context.getString(R.l.gMW))
        {
          parambb = new SpannableStringBuilder(parambb);
          parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
          parambb.append(" ").append(str);
          AppMethodBeat.o(257193);
          return parambb;
        }
      }
      if ((parambb.field_atCount > 0) && ((parambb.field_unReadCount > 0) || (parambb.field_unReadMuteCount > 0)))
      {
        paramgnx.aciP = 101;
        paramgnx = this.context;
        if (parambb.field_atCount < 4096) {
          paramInt = R.l.gMY;
        }
        for (;;)
        {
          parambb = new SpannableStringBuilder(paramgnx.getString(paramInt));
          parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
          parambb.append(" ").append(str);
          AppMethodBeat.o(257193);
          return parambb;
          if (com.tencent.mm.an.g.Dn(parambb.field_username)) {
            paramInt = R.l.gMX;
          } else {
            paramInt = R.l.gNa;
          }
        }
      }
      if ((parambb.field_hasSpecialFollow > 0) && ((parambb.field_unReadCount > 0) || (parambb.field_unReadMuteCount > 0)))
      {
        paramgnx.aciP = 1;
        parambb = new SpannableStringBuilder(this.context.getString(R.l.gWu));
        parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
        parambb.append(" ").append(str);
        AppMethodBeat.o(257193);
        return parambb;
      }
      if (parambb.field_hasTodo == 1)
      {
        paramgnx.aciP = 101;
        parambb = new SpannableStringBuilder(this.context.getString(R.l.gXq));
        parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
        parambb.append(" ").append(str);
        AppMethodBeat.o(257193);
        return parambb;
      }
      if ((parambb.rx(16777216)) && ((parambb.field_unReadCount > 0) || (parambb.field_unReadMuteCount > 0)))
      {
        paramgnx.aciP = 101;
        parambb = this.context.getString(R.l.gpu);
        paramgnx = str.toString().replace(parambb, "");
        parambb = new SpannableStringBuilder(parambb);
        parambb.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, parambb.length(), 33);
        parambb.append(com.tencent.mm.pluginsdk.ui.span.p.d(this.context, paramgnx, paramInt));
        parambb = localSpannableStringBuilder.append(parambb);
        AppMethodBeat.o(257193);
        return parambb;
      }
      if (parambb.field_remitMarkRed == 1)
      {
        parambb = this.context.getString(R.l.gSR);
        localSpannableStringBuilder.append(str.toString().replace(parambb, ""));
        AppMethodBeat.o(257193);
        return localSpannableStringBuilder;
      }
      if (parambb.field_hbMarkRed == 1)
      {
        paramgnx = str;
        if (aip(parambb.field_msgType) == 436207665)
        {
          parambb = com.tencent.mm.message.k.b.Hf(parambb.field_content);
          paramgnx = str;
          if (parambb != null)
          {
            parambb = str.toString().replace("[" + parambb.nSI + "]", "");
            paramgnx = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, parambb, paramInt);
          }
        }
      }
      label2961:
      do
      {
        do
        {
          do
          {
            parambb = localSpannableStringBuilder.append(paramgnx);
            AppMethodBeat.o(257193);
            return parambb;
            if ((paramBoolean) && ((parambb.field_unReadCount > 1) || (parambb.field_unReadMuteCount > 0)))
            {
              localSpannableStringBuilder.append(this.context.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), "" }));
              localSpannableStringBuilder.append(str);
              AppMethodBeat.o(257193);
              return localSpannableStringBuilder;
            }
            if (!au.bwp(parambb.field_username)) {
              break label2961;
            }
            paramgnx = com.tencent.mm.plugin.biz.b.a.vtj;
            paramgnx = com.tencent.mm.plugin.biz.b.a.a(paramInt, this.context, parambb);
            if ((paramgnx != null) && (paramgnx.length() > 0))
            {
              AppMethodBeat.o(257193);
              return paramgnx;
            }
            paramBoolean = parambb.rx(16);
            if ((parambb.field_unReadCount <= 1) && ((paramBoolean) || (parambb.field_unReadCount <= 0))) {
              break;
            }
            if (paramBoolean)
            {
              if (parambb.rx(32))
              {
                parambb = this.context.getString(R.l.main_conversation_biz_time_line_unread_count, new Object[] { Integer.valueOf(parambb.field_unReadCount) });
                paramgnx = com.tencent.mm.plugin.biz.b.a.vtj;
                parambb = TextUtils.concat(new CharSequence[] { parambb, " ", com.tencent.mm.plugin.biz.b.a.e(paramInt, this.context), str });
                AppMethodBeat.o(257193);
                return parambb;
              }
              localSpannableStringBuilder.append(this.context.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), "" }));
              localSpannableStringBuilder.append(str);
              AppMethodBeat.o(257193);
              return localSpannableStringBuilder;
            }
            paramgnx = str;
          } while (!ai.iZf());
          localSpannableStringBuilder.append(this.context.getString(R.l.gMV, new Object[] { Integer.valueOf(parambb.field_unReadCount), "" }));
          localSpannableStringBuilder.append(str);
          AppMethodBeat.o(257193);
          return localSpannableStringBuilder;
          paramgnx = str;
        } while (!parambb.rx(32));
        parambb = com.tencent.mm.plugin.biz.b.a.vtj;
        parambb = TextUtils.concat(new CharSequence[] { com.tencent.mm.plugin.biz.b.a.e(paramInt, this.context), str });
        AppMethodBeat.o(257193);
        return parambb;
        if ((au.bwA(parambb.field_username)) && ((parambb.field_unReadCount > 1) || (parambb.field_unReadMuteCount > 0)))
        {
          localSpannableStringBuilder.append(this.context.getString(R.l.gNb, new Object[] { Integer.valueOf(parambb.field_unReadCount), "" }));
          localSpannableStringBuilder.append(str);
          AppMethodBeat.o(257193);
          return localSpannableStringBuilder;
        }
        if (aip(parambb.field_msgType) == 889192497) {
          break;
        }
        paramgnx = str;
      } while (aip(parambb.field_msgType) != 922746929);
      parambb = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).b(this.context, aip(parambb.field_msgType), parambb.field_content, parambb.field_username, paramInt);
      AppMethodBeat.o(257193);
      return parambb;
    }
  }
  
  private void a(d paramd, au paramau)
  {
    AppMethodBeat.i(38505);
    if ((paramd.Aeu) && (Util.isNullOrNil(paramd.displayName)))
    {
      paramd.nickName = this.context.getString(R.l.gzv);
      AppMethodBeat.o(38505);
      return;
    }
    if (paramd.displayName.equalsIgnoreCase("conversationboxservice"))
    {
      paramd.nickName = this.context.getString(R.l.hardcode_plugin_conv_box_message_nick);
      AppMethodBeat.o(38505);
      return;
    }
    if (au.bwO(paramau.field_username))
    {
      paramd.nickName = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).e(MMApplicationContext.getContext(), paramd.displayName, com.tencent.mm.cd.a.br(this.context, R.f.NormalTextSize));
      AppMethodBeat.o(38505);
      return;
    }
    paramd.nickName = com.tencent.mm.pluginsdk.ui.span.p.d(this.context, paramd.displayName, com.tencent.mm.cd.a.br(this.context, R.f.NormalTextSize));
    AppMethodBeat.o(38505);
  }
  
  private static void a(f paramf)
  {
    AppMethodBeat.i(257119);
    if (paramf != null)
    {
      if (paramf.vzm != null) {
        paramf.vzm.setVisibility(4);
      }
      if (paramf.aebo != null) {
        paramf.aebo.setVisibility(4);
      }
    }
    AppMethodBeat.o(257119);
  }
  
  private void a(String paramString, f paramf)
  {
    AppMethodBeat.i(257127);
    LinkedList localLinkedList = ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Gv(paramString);
    int i = 0;
    if (paramf != null)
    {
      if (au.bwE(paramString))
      {
        com.tencent.mm.ui.t localt = com.tencent.mm.ui.t.adCS;
        if (com.tencent.mm.ui.t.jjA())
        {
          if ((localLinkedList == null) || (localLinkedList.isEmpty())) {
            break label140;
          }
          this.afof.put(paramString, Integer.valueOf(2));
        }
      }
      if (paramf.afoK.getVisibility() != 0) {
        break label156;
      }
    }
    label140:
    label156:
    for (i = 1;; i = 2)
    {
      if ((paramf != null) && (paramf.afoM.getVisibility() == 0)) {
        paramf.afoM.setIconColor(com.tencent.mm.cd.a.w(paramf.afoM.getContext(), R.e.UN_BW_0_Alpha_0_3));
      }
      paramf = com.tencent.mm.ui.report.d.afBU;
      com.tencent.mm.ui.report.d.g(paramString, localLinkedList, i);
      AppMethodBeat.o(257127);
      return;
      this.afof.put(paramString, Integer.valueOf(1));
      break;
    }
  }
  
  protected static int aip(String paramString)
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
  
  private static String bAr(String paramString)
  {
    AppMethodBeat.i(38511);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramString);
      AppMethodBeat.o(38511);
      return paramString;
    }
    AppMethodBeat.o(38511);
    return null;
  }
  
  private void fHY()
  {
    AppMethodBeat.i(38498);
    if (this.aebd == null)
    {
      AppMethodBeat.o(38498);
      return;
    }
    Iterator localIterator = this.aebd.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).afna = null;
    }
    AppMethodBeat.o(38498);
  }
  
  private com.tencent.mm.storage.bb g(String paramString, HashMap<String, com.tencent.mm.storage.bb> paramHashMap)
  {
    AppMethodBeat.i(38515);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (com.tencent.mm.storage.bb)paramHashMap.get(paramString);
      AppMethodBeat.o(38515);
      return paramString;
    }
    paramString = (com.tencent.mm.storage.bb)gG(paramString);
    AppMethodBeat.o(38515);
    return paramString;
  }
  
  private boolean i(LinkedList<com.tencent.mm.live.model.c.b> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(257138);
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.afoe.get(paramString);
    if (this.afof.containsKey(paramString)) {}
    for (int j = ((Integer)this.afof.get(paramString)).intValue();; j = 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      if (paramLinkedList.hasNext())
      {
        com.tencent.mm.live.model.c.b localb = (com.tencent.mm.live.model.c.b)paramLinkedList.next();
        localArrayList.add(Long.valueOf(localb.field_liveId));
        if ((localList == null) || (localList.contains(Long.valueOf(localb.field_liveId)))) {
          break label180;
        }
        i = 1;
      }
      label180:
      for (;;)
      {
        break;
        this.afoe.put(paramString, localArrayList);
        if ((i != 0) && (j == 2))
        {
          AppMethodBeat.o(257138);
          return false;
        }
        if ((i != 0) || (j == 0))
        {
          AppMethodBeat.o(257138);
          return true;
        }
        AppMethodBeat.o(257138);
        return false;
      }
    }
  }
  
  private boolean jAh()
  {
    return this.afon != null;
  }
  
  private void jAj()
  {
    AppMethodBeat.i(38518);
    if ((this.aebd == null) || (this.afoa == null) || (this.afoa.isEmpty()))
    {
      AppMethodBeat.o(38518);
      return;
    }
    Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.afoa.size()) });
    Iterator localIterator = this.afoa.iterator();
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
        if (!this.aebd.containsKey(str1)) {
          break label360;
        }
        d locald = (d)this.aebd.get(str1);
        j = i;
        if (locald == null) {
          break label360;
        }
        this.afoq.BS(str1);
        bool1 = au.bwE(str1);
        au localau = this.afoq.jzV();
        if (localau != null)
        {
          String str2 = aa.a(localau, str1, bool1);
          Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.displayName });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.displayName))
            {
              locald.displayName = str2;
              a(locald, localau);
              j = 1;
            }
          }
          boolean bool2 = localau.aGe();
          if (localau.kaf == 0)
          {
            bool1 = true;
            label269:
            if ((locald.afng == bool2) && (bool1 == locald.afnk)) {
              break label360;
            }
            locald.afng = bool2;
            locald.afnk = bool1;
            locald.afnl = localau.aMW();
            Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[] { str1 });
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
      this.afoa.clear();
      AppMethodBeat.o(38518);
      return;
    }
  }
  
  private static boolean jAk()
  {
    AppMethodBeat.i(257242);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTV, false);
    Log.i("MicroMsg.ConversationWithCacheAdapter", "isShowAppBrandNotifyMsgEntry: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(257242);
    return bool;
  }
  
  private CharSequence q(com.tencent.mm.storage.bb parambb)
  {
    AppMethodBeat.i(38495);
    if (parambb.field_status == 1)
    {
      parambb = this.context.getString(R.l.gNp);
      AppMethodBeat.o(38495);
      return parambb;
    }
    if (parambb.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38495);
      return "";
    }
    parambb = com.tencent.mm.pluginsdk.platformtools.f.d(this.context, parambb.field_conversationTime, true);
    AppMethodBeat.o(38495);
    return parambb;
  }
  
  private static String r(com.tencent.mm.storage.bb parambb)
  {
    AppMethodBeat.i(38510);
    if ((parambb.field_isSend == 0) && (au.bwE(parambb.field_username)))
    {
      parambb = aa.aV(parambb.field_digestUser, parambb.field_username);
      AppMethodBeat.o(38510);
      return parambb;
    }
    parambb = aa.getDisplayName(parambb.field_digestUser);
    AppMethodBeat.o(38510);
    return parambb;
  }
  
  static int s(com.tencent.mm.storage.bb parambb)
  {
    AppMethodBeat.i(257115);
    if ((parambb != null) && (parambb.rx(128)))
    {
      if (parambb.rx(256))
      {
        AppMethodBeat.o(257115);
        return 1;
      }
      AppMethodBeat.o(257115);
      return 0;
    }
    if ((parambb == null) || (parambb.field_unReadCount <= 0))
    {
      if ((parambb != null) && ((parambb.rx(8388608)) || (parambb.rx(2097152))) && (parambb.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(257115);
        return 1;
      }
      if ((parambb != null) && (au.bwD(parambb.field_username)) && (parambb.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(257115);
        return 1;
      }
      AppMethodBeat.o(257115);
      return 0;
    }
    if (au.bwz(parambb.field_username))
    {
      AppMethodBeat.o(257115);
      return 1;
    }
    if (au.bwp(parambb.field_username))
    {
      if ((!parambb.rx(16)) && (!parambb.rx(64)))
      {
        AppMethodBeat.o(257115);
        return 0;
      }
      AppMethodBeat.o(257115);
      return 1;
    }
    if (au.bwu(parambb.field_username))
    {
      bh.bCz();
      if (!com.tencent.mm.model.c.ban().getBoolean(at.a.acOa, true))
      {
        AppMethodBeat.o(257115);
        return 1;
      }
    }
    if (au.bwy(parambb.field_username))
    {
      bh.bCz();
      if (!com.tencent.mm.model.c.ban().getBoolean(at.a.acOb, true))
      {
        AppMethodBeat.o(257115);
        return 1;
      }
    }
    bh.bCz();
    au localau = com.tencent.mm.model.c.bzA().JE(parambb.field_username);
    if ((localau != null) && ((int)localau.maN != 0))
    {
      if ((localau.aGe()) && (localau.aMW()))
      {
        AppMethodBeat.o(257115);
        return 1;
      }
      if ((au.bwE(parambb.field_username)) && (localau.kaf == 0))
      {
        AppMethodBeat.o(257115);
        return 1;
      }
    }
    if (au.bwA(parambb.field_username))
    {
      AppMethodBeat.o(257115);
      return 1;
    }
    if (au.bwB(parambb.field_username))
    {
      AppMethodBeat.o(257115);
      return 0;
    }
    AppMethodBeat.o(257115);
    return 2;
  }
  
  public final void a(View paramView, int paramInt, String paramString)
  {
    AppMethodBeat.i(38500);
    if (paramView == null)
    {
      AppMethodBeat.o(38500);
      return;
    }
    if ((this.afon != null) && (!aw.jkS()))
    {
      Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(38500);
      return;
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (au.bwB(paramString))
    {
      this.afnw.jAu();
      AppMethodBeat.o(38500);
      return;
    }
    this.afon = paramString;
    f localf = (f)paramView.getTag();
    int j = paramView.getContext().getResources().getColor(R.e.FG_3);
    Object localObject = paramView.getContext().getResources();
    if ((localf != null) && (localf.aebg))
    {
      i = R.e.BG_0;
      i = ((Resources)localObject).getColor(i);
      if (aw.jkS())
      {
        localObject = paramView.getContext().getResources();
        if ((localf == null) || (!localf.aebg)) {
          break label396;
        }
      }
    }
    label396:
    for (int i = R.e.click_top_item;; i = R.e.fkl)
    {
      i = ((Resources)localObject).getColor(i);
      this.afoo = new ColorDrawable(com.tencent.mm.ui.bb.av(j, i));
      paramView.setBackground(this.afoo);
      if (aw.jkS()) {
        notifyDataSetChanged();
      }
      if (au.bwA(paramString))
      {
        paramView = (com.tencent.mm.storage.bb)azn(paramInt);
        localObject = (com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.h.class);
        com.tencent.mm.kernel.h.baC();
        ((com.tencent.mm.plugin.appbrand.service.h)localObject).UQ(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.b.getUin())));
        ((com.tencent.mm.plugin.appbrand.service.h)localObject).a(new h.a(paramView.field_unReadCount, paramInt + 1));
      }
      bh.bCz();
      if (com.tencent.mm.model.c.bzG().bxW(paramString)) {
        m.u((com.tencent.mm.storage.bb)azn(paramInt));
      }
      paramView = com.tencent.mm.ui.conversation.fold.b.a.afuo;
      com.tencent.mm.ui.conversation.fold.b.a.a(paramString, this.afnw.jAx(), this.afnw.afpC, paramInt, this.mListView);
      a(paramString, localf);
      a(localf);
      AppMethodBeat.o(38500);
      return;
      i = R.e.BG_2;
      break;
    }
  }
  
  public final SparseArray<String>[] a(HashSet<g.b<String, com.tencent.mm.storage.bb>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(38514);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.h.baz()))
    {
      if (paramArrayOfSparseArray == null) {}
      for (paramHashSet = "null";; paramHashSet = Integer.valueOf(paramArrayOfSparseArray.length))
      {
        Log.i("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion oldPosistion:%s, accHasReady:%s", new Object[] { paramHashSet, Boolean.valueOf(com.tencent.mm.kernel.h.baz()) });
        AppMethodBeat.o(38514);
        return paramArrayOfSparseArray;
      }
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[] { Integer.valueOf(paramHashSet.size()), Integer.valueOf(paramArrayOfSparseArray[0].size()) });
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (g.b)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((g.b)localObject3).adxx != 5) && (!((ArrayList)localObject1).contains(((g.b)localObject3).object)))
      {
        Log.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((g.b)localObject3).object);
        ((ArrayList)localObject1).add((String)((g.b)localObject3).object);
      }
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "refreshChangedConversation searchArray:%s, %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()), ((ArrayList)localObject1).toString() });
    localObject2 = new HashMap();
    bh.bCz();
    Object localObject3 = com.tencent.mm.model.c.bzG().b((ArrayList)localObject1, this.lMF, com.tencent.mm.l.a.maX);
    Object localObject4;
    Object localObject5;
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = new com.tencent.mm.storage.bb();
      ((com.tencent.mm.storage.bb)localObject4).convertFrom((Cursor)localObject3);
      ((HashMap)localObject2).put(((com.tencent.mm.autogen.b.bd)localObject4).field_username, localObject4);
      localObject5 = this.afnw.bCf(((com.tencent.mm.autogen.b.bd)localObject4).field_username);
      if (localObject5 != null) {
        ((com.tencent.mm.storage.bb)localObject4).adis = ((com.tencent.mm.storage.bb)localObject5).adis;
      }
    }
    ((Cursor)localObject3).close();
    localObject3 = paramHashSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (g.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((g.b)localObject4).adxx != 5)
        {
          localObject5 = new StringBuilder("evnet name,").append((String)((g.b)localObject4).object).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((g.b)localObject4).object) == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((g.b)localObject4).adxy = ((HashMap)localObject2).get(((g.b)localObject4).object);
            break;
          }
        }
        ((g.b)localObject4).adxy = null;
      }
    }
    ((ArrayList)localObject1).clear();
    ((HashMap)localObject2).clear();
    localObject1 = new HashMap();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      localObject2 = (g.b)paramHashSet.next();
      if (localObject2 != null)
      {
        a((g.b)localObject2, paramArrayOfSparseArray[0], (HashMap)localObject1);
        if (((g.b)localObject2).adxx != 5) {
          ((HashMap)localObject1).put((String)((g.b)localObject2).object, (com.tencent.mm.storage.bb)((g.b)localObject2).adxy);
        }
      }
    }
    AppMethodBeat.o(38514);
    return paramArrayOfSparseArray;
  }
  
  public final void aDC(int paramInt)
  {
    AppMethodBeat.i(38501);
    if (!jAh())
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
      AppMethodBeat.o(38501);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38485);
        k.e(k.this);
        AppMethodBeat.o(38485);
      }
    }, paramInt);
    AppMethodBeat.o(38501);
  }
  
  public final void aDD(int paramInt)
  {
    AppMethodBeat.i(38521);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(38521);
      return;
    }
    try
    {
      com.tencent.mm.storage.bb localbb = (com.tencent.mm.storage.bb)azn(paramInt);
      if (localbb == null)
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
        Log.w("MicroMsg.ConversationWithCacheAdapter", "preLoad position:%s is null!", new Object[] { Integer.valueOf(paramInt) });
        localObject = null;
      }
      com.tencent.mm.pluginsdk.ui.a.b.iKa().loadBitmap(localObject.field_username);
      AppMethodBeat.o(38521);
    }
  }
  
  public final com.tencent.mm.ui.g<String, com.tencent.mm.storage.bb>.c b(com.tencent.mm.storagebase.a.d paramd)
  {
    AppMethodBeat.i(257297);
    paramd = new g.c(this, paramd, (byte)0);
    AppMethodBeat.o(257297);
    return paramd;
  }
  
  public final ArrayList<com.tencent.mm.storage.bb> ce(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(38513);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    bh.bCz();
    paramArrayList = com.tencent.mm.model.c.bzG().b(paramArrayList, this.lMF, com.tencent.mm.l.a.maX);
    while (paramArrayList.moveToNext())
    {
      com.tencent.mm.storage.bb localbb = new com.tencent.mm.storage.bb();
      localbb.convertFrom(paramArrayList);
      localArrayList.add(localbb);
    }
    paramArrayList.close();
    AppMethodBeat.o(38513);
    return localArrayList;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(38508);
    if (this.aebd != null)
    {
      this.aebd.clear();
      this.afoi = true;
    }
    AppMethodBeat.o(38508);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38503);
    this.afou = new a((byte)0);
    com.tencent.mm.storage.bb localbb = (com.tencent.mm.storage.bb)azn(paramInt);
    String str = localbb.field_username;
    this.afoq.BS(str);
    Object localObject3;
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject4;
    label487:
    Object localObject5;
    label512:
    label535:
    label588:
    au localau;
    label1158:
    label1228:
    boolean bool1;
    if (afoc.containsKey(str))
    {
      if (paramInt != ((Integer)afoc.get(str)).intValue())
      {
        localObject3 = jhS();
        localObject1 = jhT();
        localObject2 = new StringBuffer();
        int k = localObject3.length;
        i = 0;
        while (i < k)
        {
          localObject4 = localObject3[i];
          int j = 0;
          while ((j < ((SparseArray)localObject4).size()) && (j < 50))
          {
            ((StringBuffer)localObject2).append("[");
            ((StringBuffer)localObject2).append(j);
            ((StringBuffer)localObject2).append(",");
            ((StringBuffer)localObject2).append(((SparseArray)localObject4).keyAt(j));
            ((StringBuffer)localObject2).append(",");
            ((StringBuffer)localObject2).append((String)((SparseArray)localObject4).valueAt(j));
            ((StringBuffer)localObject2).append("]");
            j += 1;
          }
          i += 1;
        }
        ((StringBuffer)localObject2).append("\n");
        if (localObject1 != null)
        {
          localObject3 = ((HashMap)localObject1).entrySet().iterator();
          i = 0;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            if (i >= 50) {
              break;
            }
            i += 1;
            ((StringBuffer)localObject2).append("[");
            ((StringBuffer)localObject2).append(((Map.Entry)localObject4).getKey());
            ((StringBuffer)localObject2).append(",");
            if (((Map.Entry)localObject4).getValue() != null) {
              ((StringBuffer)localObject2).append(((com.tencent.mm.storage.bb)((Map.Entry)localObject4).getValue()).field_username);
            }
            ((StringBuffer)localObject2).append("]");
          }
          ((StringBuffer)localObject2).append("\n");
        }
        localObject2 = ((StringBuffer)localObject2).toString();
        localObject3 = afoc.toString();
        if (localObject1 == null) {
          break label3551;
        }
        i = ((HashMap)localObject1).size();
        Log.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject2, str, Integer.valueOf(paramInt), localObject3, Integer.valueOf(i) });
        if (!this.afob)
        {
          com.tencent.mm.plugin.fts.a.e.Wf(20);
          this.afob = true;
        }
        if (System.currentTimeMillis() - this.afov > 3600000L)
        {
          super.v(null, 1);
          this.afov = System.currentTimeMillis();
        }
      }
      localObject1 = this.afnw;
      if ((localbb == null) || (localbb.adis != 132)) {
        break label3573;
      }
      i = 1;
      if (i == 0)
      {
        if ((localbb == null) || (localbb.adis != 66)) {
          break label3579;
        }
        i = 1;
        if (i == 0) {
          m.a((m)localObject1, localbb);
        }
      }
      if (paramView != null) {
        break label3618;
      }
      localObject2 = new f();
      if (!com.tencent.mm.cd.a.mr(this.context)) {
        break label3585;
      }
      com.tencent.mm.kiss.layout.b.bbG();
      paramView = com.tencent.mm.kiss.layout.b.d((Activity)this.context, R.i.giH);
      paramView.setTag(R.h.touch_loc, new int[2]);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38489);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if ((k.g(k.this) == null) || (k.g(k.this).getOnItemClickListener() == null))
          {
            Log.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          if (paramAnonymousView.getTag() == null)
          {
            Log.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          if ((!k.this.aepk) && (!aw.jkS()))
          {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          localObject = (k.f)paramAnonymousView.getTag();
          int i = ((k.f)localObject).position;
          int j = k.g(k.this).getHeaderViewsCount();
          k.g(k.this).getOnItemClickListener().onItemClick(k.g(k.this), paramAnonymousView, i + j, k.this.getItemId(((k.f)localObject).position));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if ((k.g(k.this) == null) || (k.g(k.this).getOnItemLongClickListener() == null))
          {
            Log.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          if (paramAnonymousView.getTag() == null)
          {
            Log.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          if (!k.this.aepk)
          {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          localObject = (k.f)paramAnonymousView.getTag();
          int i = ((k.f)localObject).position;
          int j = k.g(k.this).getHeaderViewsCount();
          boolean bool = k.g(k.this).getOnItemLongClickListener().onItemLongClick(k.g(k.this), paramAnonymousView, i + j, k.this.getItemId(((k.f)localObject).position));
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38490);
          return bool;
        }
      });
      ((f)localObject2).lBC = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      com.tencent.mm.pluginsdk.ui.a.b.g(((f)localObject2).lBC, str);
      localObject1 = (com.tencent.mm.pluginsdk.ui.a)((f)localObject2).lBC.getDrawable();
      if (this.afmK != null) {
        this.afmK.a((e.a)localObject1);
      }
      ((f)localObject2).lBC.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(38491);
          this.afoB.lBC.getViewTreeObserver().removeOnPreDrawListener(this);
          int i = this.afoB.lBC.getWidth();
          int j = com.tencent.mm.ui.bd.bs(k.h(k.this), R.f.NormalAvatarSize);
          if (i != j)
          {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.afoB.lBC.getLayoutParams();
            localLayoutParams.width = j;
            localLayoutParams.height = j;
            this.afoB.lBC.setLayoutParams(localLayoutParams);
            Log.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", new Object[] { Integer.valueOf(this.afoB.lBC.getWidth()) });
            if (!k.i(k.this))
            {
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1055L, 4L, 1L, false);
              Log.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
              k.j(k.this);
            }
          }
          AppMethodBeat.o(38491);
          return true;
        }
      });
      ((f)localObject2).afoQ = paramView.findViewById(R.h.fDD);
      ((f)localObject2).contentView = paramView.findViewById(R.h.fDC);
      ((f)localObject2).aebj = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
      ((f)localObject2).aebj.setLayoutCallback(this.afaM);
      ((f)localObject2).aebk = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
      ((f)localObject2).afoJ = ((ImageView)paramView.findViewById(R.h.fMq));
      ((f)localObject2).aebl = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
      ((f)localObject2).vzm = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
      ((f)localObject2).afoK = ((WeImageView)paramView.findViewById(R.h.fKm));
      ((f)localObject2).aebo = paramView.findViewById(R.h.fsw);
      ((f)localObject2).afnp = ((ImageView)paramView.findViewById(R.h.fNi));
      ((f)localObject2).afoL = ((ImageView)paramView.findViewById(R.h.fOQ));
      ((f)localObject2).afoM = ((WeImageView)paramView.findViewById(R.h.fVd));
      ((f)localObject2).afoR = ((ImageView)paramView.findViewById(R.h.fVJ));
      ((f)localObject2).afoS = ((TextView)paramView.findViewById(R.h.fIM));
      ((f)localObject2).vzm.setBackgroundResource(com.tencent.mm.ui.tools.v.nH(this.context));
      ((f)localObject2).vzm.setTextSize(0, com.tencent.mm.cd.a.bs(this.context, R.f.unReadCountTextSize) * com.tencent.mm.cd.a.jO(this.context));
      ((f)localObject2).afoN = new c();
      paramView.setTag(localObject2);
      ((f)localObject2).aebl.setTextSize(0, com.tencent.mm.cd.a.br(this.context, R.f.SmallerTextSize));
      ((f)localObject2).aebk.setTextSize(0, com.tencent.mm.cd.a.br(this.context, R.f.SmallestTextSize));
      ((f)localObject2).aebj.setTextSize(0, com.tencent.mm.cd.a.br(this.context, R.f.NormalTextSize));
      this.afor = ((f)localObject2).aebj.getTextSize();
      ((f)localObject2).aebl.setTextColor(this.aebb[0]);
      ((f)localObject2).aebk.setTextColor(this.aebb[4]);
      ((f)localObject2).aebj.setTextColor(this.aebb[3]);
      ((f)localObject2).aebl.setShouldEllipsize(true);
      ((f)localObject2).aebk.setShouldEllipsize(false);
      ((f)localObject2).aebj.setShouldEllipsize(true);
      if (((f)localObject2).aebj.getPaint() != null) {
        aw.a(((f)localObject2).aebj.getPaint(), 0.1F);
      }
      if (!au.bwB(localbb.field_username)) {
        break label3606;
      }
      ((f)localObject2).afoO = this.afot;
      ((f)localObject2).afoP = this.afnw.afpM;
      ((f)localObject2).aebk.setGravity(5);
      Log.i("MicroMsg.ConversationWithCacheAdapter", "[getNewView] position=%s, username=%s, parentRef=%s, foldFlag=%d", new Object[] { Integer.valueOf(paramInt), localbb.field_username, localbb.field_parentRef, Integer.valueOf(localbb.adis) });
      localObject1 = paramView;
      localObject5 = localbb.field_username;
      if (this.aebd != null)
      {
        localObject3 = (d)this.aebd.get(localObject5);
        if (localObject3 != null) {
          break label5140;
        }
      }
      localObject4 = new d((byte)0);
      this.afoq.BS((String)localObject5);
      localau = this.afoq.jzV();
      if (localau == null) {
        break label3633;
      }
      ((d)localObject4).afne = localau.hyY;
      ((d)localObject4).afnd = ((int)localau.maN);
      label1316:
      if (localau == null) {
        break label3648;
      }
      bool1 = true;
      label1324:
      ((d)localObject4).afnj = bool1;
      if ((localau == null) || (!localau.aMW())) {
        break label3654;
      }
      bool1 = true;
      label1347:
      ((d)localObject4).afnl = bool1;
      if ((localau == null) || (localau.kaf != 0)) {
        break label3660;
      }
      bool1 = true;
      label1370:
      ((d)localObject4).afnk = bool1;
      ((d)localObject4).Aeu = au.bwE((String)localObject5);
      if ((!((d)localObject4).Aeu) || (!((d)localObject4).afnk) || (localbb.field_unReadCount <= 0)) {
        break label3666;
      }
      bool1 = true;
      label1414:
      ((d)localObject4).afni = bool1;
      ((d)localObject4).viewType = 0;
      if ((aip(localbb.field_msgType) == 34) && (localbb.field_isSend == 0) && (!Util.isNullOrNil(localbb.field_content)))
      {
        localObject3 = localbb.field_content;
        if ((!localbb.field_username.equals("officialaccounts")) && (!localbb.rx(2097152)))
        {
          paramView = (View)localObject3;
          if (!localbb.rx(8388608)) {}
        }
        else
        {
          String[] arrayOfString = ((String)localObject3).split(":");
          paramView = (View)localObject3;
          if (arrayOfString != null)
          {
            paramView = (View)localObject3;
            if (arrayOfString.length > 3) {
              paramView = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
            }
          }
        }
        if (!new com.tencent.mm.modelvoice.p(paramView).paW) {
          ((d)localObject4).viewType = 1;
        }
      }
      ((d)localObject4).displayName = aa.a(localau, (String)localObject5, ((d)localObject4).Aeu);
      a((d)localObject4, localau);
      ((d)localObject4).afna = q(localbb);
      switch (localbb.field_status)
      {
      case 3: 
      case 4: 
      case 6: 
      case 7: 
      default: 
        i = -1;
        label1691:
        ((d)localObject4).afnc = i;
        ((d)localObject4).afnf = ab.a(localbb);
        bh.bCz();
        ((d)localObject4).aebg = com.tencent.mm.model.c.bzG().k(localbb);
        if ((localau != null) && (localau.aGe()))
        {
          bool1 = true;
          label1743:
          ((d)localObject4).afng = bool1;
          ((d)localObject4).adis = localbb.adis;
          localObject3 = localObject4;
          if (this.aebd != null)
          {
            this.aebd.put(localObject5, localObject4);
            localObject3 = localObject4;
          }
        }
        break;
      }
    }
    label1823:
    label2087:
    label2348:
    label3633:
    label3900:
    label4414:
    for (;;)
    {
      ((f)localObject2).position = paramInt;
      ((f)localObject2).username = str;
      if ((((d)localObject3).aebg) && (localbb.field_conversationTime != -1L))
      {
        bool1 = true;
        ((f)localObject2).aebg = bool1;
        ((f)localObject2).adis = localbb.adis;
        localObject5 = new gnx();
        ((gnx)localObject5).aciP = 0;
        if (((d)localObject3).viewType == 1) {
          ((gnx)localObject5).aciP = 101;
        }
        if (((d)localObject3).afnb == null) {
          ((d)localObject3).afnb = a(localbb, (int)((f)localObject2).aebl.getTextSize(), ((d)localObject3).afni, (gnx)localObject5);
        }
        if ((au.bwp(localbb.field_username)) && (((d)localObject3).afnb != null))
        {
          paramView = com.tencent.mm.storage.v.acEJ;
          com.tencent.mm.storage.v.bvx(((d)localObject3).afnb.toString());
          paramView = e.afmD;
          if (e.jzS())
          {
            paramView = e.afmD;
            e.a(this.mListView, this);
            paramView = com.tencent.mm.plugin.brandservice.model.d.vBI;
            com.tencent.mm.plugin.brandservice.model.d.w(1, "", "");
          }
        }
        if (((d)localObject3).afna == null) {
          ((d)localObject3).afna = q(localbb);
        }
        if (!((d)localObject3).afni) {
          break label3712;
        }
        ((f)localObject2).aebl.setTextColor(this.aebb[0]);
        com.tencent.mm.booter.notification.a.h.qr(((f)localObject2).aebl.getWidth());
        com.tencent.mm.booter.notification.a.h.qs((int)((f)localObject2).aebl.getTextSize());
        com.tencent.mm.booter.notification.a.h.c(((f)localObject2).aebl.getPaint());
        if ((!au.bwF(str)) && (!ab.II(str))) {
          break label3857;
        }
        ((f)localObject2).aebj.setCompoundRightDrawablesWithIntrinsicBounds(R.k.open_im_main_logo);
        ((f)localObject2).aebj.setDrawRightDrawable(true);
        i = ((d)localObject3).afnc;
        if (i == -1) {
          break label3880;
        }
        ((f)localObject2).aebl.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        ((f)localObject2).aebl.setDrawLeftDrawable(true);
        Log.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((d)localObject3).afnc) });
        label2147:
        if (!au.bwO(localbb.field_username)) {
          break label3914;
        }
        this.afoq.BS(localbb.field_username);
        localau = this.afoq.jzV();
        paramView = "";
        if (localau != null) {
          paramView = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cc(localau.field_openImAppid, localau.field_descWordingId);
        }
        if (Util.isNullOrNil(paramView)) {
          break label3900;
        }
        localObject4 = paramView;
        if ("3552365301".equals(localau.field_openImAppid)) {
          localObject4 = "@".concat(String.valueOf(paramView));
        }
        ((f)localObject2).aebj.bc((String)localObject4, R.e.fkJ, 14);
        label2263:
        ((f)localObject2).aebj.setText(((d)localObject3).nickName);
        paramView = ((f)localObject2).aebk.getLayoutParams();
        if (((d)localObject3).afna.length() < 9) {
          break label3937;
        }
        if (paramView.width != this.afmT)
        {
          paramView.width = this.afmT;
          ((f)localObject2).aebk.setLayoutParams(paramView);
        }
        if (!au.bwz(localbb.field_username)) {
          break label3968;
        }
        ((f)localObject2).aebk.setVisibility(4);
        ((f)localObject2).aebl.setText(((d)localObject3).afnb);
        ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).updateOnlyMemory(13, "report_".concat(String.valueOf(str)), (com.tencent.mm.bx.a)localObject5);
        if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, 7, 0L) <= 0L) {
          break label3993;
        }
        bool1 = true;
        label2406:
        localObject4 = localbb.field_username;
        long l1 = localbb.field_conversationTime;
        localObject5 = ((d)localObject3).afna;
        boolean bool2 = ((f)localObject2).aebg;
        long l2 = localbb.field_flag;
        long l3 = localbb.field_flag;
        if ((((d)localObject3).nickName != null) && (((d)localObject3).nickName.length() > 0)) {
          break label3999;
        }
        paramView = "?";
        Log.i("MicroMsg.ConversationWithCacheAdapter", "[getView] position=%s username=%s conversationTime=%s updateTime=%s isPlacedTop=%s isTalkRoomTopPlace=%s flag=%s flagTime=%s nickname=%s unread=%s, hbMarkRed=%s, parentRef=%s, foldFlag=%d", new Object[] { Integer.valueOf(paramInt), localObject4, Long.valueOf(l1), localObject5, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3 & 0xFFFFFFFF), paramView, Integer.valueOf(localbb.field_unReadCount), Integer.valueOf(localbb.field_hbMarkRed), localbb.field_parentRef, Integer.valueOf(localbb.adis) });
        if ((bool1) && (0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, 7, 0L)))
        {
          localbb.gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localbb, 6, localbb.field_conversationTime));
          bh.bCz();
          com.tencent.mm.model.c.bzG().c(localbb, localbb.field_username);
        }
        ((f)localObject2).afoJ.setVisibility(8);
        ((f)localObject2).afoK.setVisibility(8);
        ((f)localObject2).afoK.setImageDrawable(com.tencent.mm.ui.bb.m(this.context, R.k.icons_outlined_bellring_off, this.context.getResources().getColor(R.e.arrow_color)));
        if (!((d)localObject3).Aeu) {
          break label4017;
        }
        if (((d)localObject3).afnk) {
          ((f)localObject2).afoK.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.g(((f)localObject2).lBC, str);
        if (this.afmI)
        {
          Log.i("MicroMsg.ConversationWithCacheAdapter", "handleShowTipCnt.");
          if ((localbb != null) && (localObject2 != null) && (localObject3 != null)) {
            break label4037;
          }
          Log.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        label2778:
        if ((!((d)localObject3).afnf) && (((d)localObject3).aebg) && (bh.baz()))
        {
          bh.bCz();
          com.tencent.mm.model.c.bzG().j(localbb);
        }
        if ((this.afon == null) || (!this.afon.equals(str))) {
          break label4360;
        }
        Log.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", new Object[] { Integer.valueOf(localObject1.hashCode()), this.afon });
        ((View)localObject1).findViewById(R.h.fDD).setBackground(this.afoo);
        label2879:
        if (Build.VERSION.SDK_INT >= 21) {
          ((View)localObject1).findViewById(R.h.fDD).setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(38483);
              paramAnonymousView.findViewById(R.h.fDD).getBackground().setHotspot(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
              AppMethodBeat.o(38483);
              return false;
            }
          });
        }
        if ((com.tencent.mm.bd.d.oXN == null) || (!com.tencent.mm.bd.d.oXN.Py(localbb.field_username))) {
          break label4414;
        }
        ((f)localObject2).afnp.setVisibility(0);
        label2937:
        if ((!au.bwE(localbb.field_username)) || (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class) == null) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMQ(localbb.field_username))) {
          break label4461;
        }
        if ((!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).geW()) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).kl(localbb.field_username, z.bAM()))) {
          break label4427;
        }
        ((f)localObject2).afoL.setImageResource(R.k.chatlist_multitalk_highlight_icon);
        label3032:
        ((f)localObject2).afoL.setVisibility(0);
        label3041:
        ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).setTextWithStatus(((f)localObject2).aebj, str, com.tencent.mm.plugin.textstatus.a.a.b.ThD);
        if ((!au.bwE(localbb.field_username)) || (com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class) == null) || (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Gv(localbb.field_username).size() <= 0)) {
          break label4553;
        }
        paramView = com.tencent.mm.ui.t.adCS;
        if (!com.tencent.mm.ui.t.jjA()) {
          break label4553;
        }
        ((f)localObject2).afoM.setVisibility(0);
        if (!i(((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Gv(localbb.field_username), localbb.field_username)) {
          break label4474;
        }
        this.afof.remove(localbb.field_username);
        ((f)localObject2).afoM.setIconColor(com.tencent.mm.cd.a.w(((f)localObject2).afoM.getContext(), R.e.room_live_logo_color));
        this.afou.content = String.valueOf(((d)localObject3).afnb);
        this.afou.nickName = ((d)localObject3).displayName;
        this.afou.time = String.valueOf(((d)localObject3).afna);
        ((View)localObject1).setTag(R.h.fDy, Boolean.valueOf(((d)localObject3).aebg));
        ((View)localObject1).setAlpha(1.0F);
        ((View)localObject1).setTag(R.h.fDz, Integer.valueOf(paramInt));
        ((View)localObject1).setTag(R.h.fDx, localbb);
        paramView = f.afmG;
        s.u(str, "talker");
        s.u(localObject1, "itemView");
        paramView = (e.b)f.afmH.get(str);
        if (paramView != null) {
          break label4592;
        }
        paramView = null;
        label3325:
        if (paramView == null) {
          com.tencent.mm.view.f.a((View)localObject1, null);
        }
        localObject3 = this.afnw;
        s.u(localObject2, "viewHolder");
        s.u(localbb, "conv");
        s.u(localObject1, "convertView");
        s.u(paramViewGroup, "parent");
        ((View)localObject1).findViewById(R.h.fDB).setVisibility(8);
        ((View)localObject1).findViewById(R.h.fDC).setVisibility(0);
        if (!au.bwB(localbb.field_username)) {
          break label4610;
        }
        ((View)localObject1).findViewById(R.h.fDC).setVisibility(8);
        ((View)localObject1).findViewById(R.h.fDB).setVisibility(0);
        ((View)localObject1).findViewById(R.h.fDD).setVisibility(0);
        ((m)localObject3).a(localbb.adis, (View)((f)localObject2).afoR, ((f)localObject2).afoS, ((m)localObject3).afpC);
        paramView = ((f)localObject2).afoQ.getLayoutParams();
        if (!(paramView instanceof AbsListView.LayoutParams)) {
          break label4605;
        }
      }
      label3551:
      label3573:
      label3579:
      label4605:
      for (paramView = (AbsListView.LayoutParams)paramView;; paramView = null)
      {
        for (;;)
        {
          if ((paramView != null) && (((f)localObject2).afoO != ((m)localObject3).afot))
          {
            paramView.height = ((m)localObject3).afot;
            ((f)localObject2).afoO = ((m)localObject3).afot;
            ((f)localObject2).afoQ.setLayoutParams((ViewGroup.LayoutParams)paramView);
          }
          AppMethodBeat.o(38503);
          return localObject1;
          i = 0;
          break;
          afoc.put(str, Integer.valueOf(paramInt));
          break label487;
          i = 0;
          break label512;
          i = 0;
          break label535;
          com.tencent.mm.kiss.layout.b.bbG();
          paramView = com.tencent.mm.kiss.layout.b.d((Activity)this.context, R.i.giG);
          break label588;
          ((f)localObject2).afoO = this.afos;
          break label1158;
          localObject2 = (f)paramView.getTag();
          localObject1 = paramView;
          break label1228;
          ((d)localObject4).afne = -1;
          ((d)localObject4).afnd = -1;
          break label1316;
          bool1 = false;
          break label1324;
          bool1 = false;
          break label1347;
          bool1 = false;
          break label1370;
          bool1 = false;
          break label1414;
          i = -1;
          break label1691;
          i = R.k.msg_state_sending;
          break label1691;
          i = -1;
          break label1691;
          i = R.k.msg_state_failed;
          break label1691;
          bool1 = false;
          break label1743;
          bool1 = false;
          break label1823;
          if ((((d)localObject3).viewType == 1) && (localbb.field_isSend == 0))
          {
            paramView = this.context.getString(R.l.app_voice);
            i = ((d)localObject3).afnb.toString().lastIndexOf(paramView);
            if (i < 0) {}
          }
          try
          {
            ((gnx)localObject5).aciP = 101;
            localObject4 = new SpannableStringBuilder(((d)localObject3).afnb);
            ((SpannableStringBuilder)localObject4).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), i, paramView.length() + i, 33);
            ((d)localObject3).afnb = ((CharSequence)localObject4);
            ((f)localObject2).aebl.setTextColor(this.aebb[0]);
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramView, null, new Object[0]);
            }
          }
        }
        if (!((f)localObject2).aebj.adWm) {
          break label2087;
        }
        ((f)localObject2).aebj.setDrawRightDrawable(false);
        break label2087;
        ((f)localObject2).aebl.setDrawLeftDrawable(false);
        ((f)localObject2).aebl.invalidate();
        break label2147;
        ((f)localObject2).aebj.bc(null, 0, 0);
        break label2263;
        au.bwF(localbb.field_username);
        ((f)localObject2).aebj.bc(null, 0, 0);
        break label2263;
        if (paramView.width == this.afmS) {
          break label2328;
        }
        paramView.width = this.afmS;
        ((f)localObject2).aebk.setLayoutParams(paramView);
        break label2328;
        ((f)localObject2).aebk.setVisibility(0);
        ((f)localObject2).aebk.setText(((d)localObject3).afna);
        break label2348;
        bool1 = false;
        break label2406;
        paramView = Character.valueOf(((d)localObject3).nickName.charAt(0));
        break label2473;
        if (!((d)localObject3).afng) {
          break label2730;
        }
        ((f)localObject2).afoK.setVisibility(0);
        break label2730;
        ((f)localObject2).vzm.setVisibility(4);
        ((f)localObject2).aebo.setVisibility(4);
        if ((!au.bxe(localbb.field_username)) && (((d)localObject3).afnj) && ((((d)localObject3).afne == 1) || (((d)localObject3).afne == 2) || (((d)localObject3).afne == 3)))
        {
          paramView = this.aebb[2];
          ((f)localObject2).aebj.setTextColor(paramView);
          if ((!((d)localObject3).afnj) || (((d)localObject3).afnd == 0)) {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
          }
          i = s(localbb);
          if (i != 1) {
            break label4207;
          }
          ((f)localObject2).aebo.setVisibility(0);
          paramView = com.tencent.mm.ui.report.d.afBU;
          if (((f)localObject2).afoK.getVisibility() != 0) {
            break label4201;
          }
        }
        for (i = 1;; i = 2)
        {
          com.tencent.mm.ui.report.d.b(localbb, i);
          break;
          paramView = this.aebb[3];
          break label4108;
        }
        if (i != 2) {
          break label2778;
        }
        i = localbb.field_unReadCount;
        if (i > 99)
        {
          ((f)localObject2).vzm.setText("");
          ((f)localObject2).vzm.setBackgroundResource(R.k.badge_count_more);
          ((f)localObject2).vzm.setVisibility(0);
          this.afou.afmZ = i;
          paramView = com.tencent.mm.ui.report.d.afBU;
          if (((f)localObject2).afoK.getVisibility() != 0) {
            break label4354;
          }
        }
        for (i = 1;; i = 2)
        {
          com.tencent.mm.ui.report.d.b(localbb, i);
          break;
          if (i <= 0) {
            break label4257;
          }
          ((f)localObject2).vzm.setText(localbb.field_unReadCount);
          ((f)localObject2).vzm.setVisibility(0);
          ((f)localObject2).vzm.setBackgroundResource(com.tencent.mm.ui.tools.v.bC(this.context, i));
          break label4257;
        }
        if ((((d)localObject3).aebg) && (localbb.field_conversationTime != -1L))
        {
          ((View)localObject1).findViewById(R.h.fDD).setBackgroundResource(R.g.list_item_top_selector);
          break label2879;
        }
        ((View)localObject1).findViewById(R.h.fDD).setBackgroundResource(R.g.fnA);
        break label2879;
        ((f)localObject2).afnp.setVisibility(8);
        break label2937;
        ((f)localObject2).afoL.setImageDrawable(com.tencent.mm.ui.bb.m(this.context, R.k.icons_filled_groupcall, this.context.getResources().getColor(R.e.arrow_color)));
        break label3032;
        ((f)localObject2).afoL.setVisibility(8);
        break label3041;
        ((f)localObject2).afoM.setIconColor(com.tencent.mm.cd.a.w(((f)localObject2).afoM.getContext(), R.e.UN_BW_0_Alpha_0_3));
        if ((!this.afof.containsKey(localbb.field_username)) || (((Integer)this.afof.get(localbb.field_username)).intValue() != 2)) {
          break label3201;
        }
        this.afof.put(localbb.field_username, Integer.valueOf(1));
        break label3201;
        this.afoe.remove(localbb.field_username);
        this.afof.remove(localbb.field_username);
        ((f)localObject2).afoM.setVisibility(8);
        break label3201;
        com.tencent.mm.view.f.a((View)localObject1, paramView);
        paramView = ah.aiuX;
        break label3325;
      }
      label3648:
      label3654:
      label3660:
      label3666:
      label3937:
      label4201:
      label4207:
      label4474:
      if ((localbb.adis & 0x4) == 0) {
        ((View)localObject1).findViewById(R.h.fDD).setVisibility(0);
      }
      label3914:
      label4427:
      label4461:
      label4592:
      if (((localbb.adis <= 2) || (localbb.adis == 10)) && (((f)localObject2).afoQ.getMeasuredHeight() != ((m)localObject3).afos))
      {
        ((f)localObject2).afoO = ((m)localObject3).afos;
        paramView = ((f)localObject2).afoQ.getLayoutParams();
        if ((paramView instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)paramView;
          if ((paramView != null) && (paramView.height != ((m)localObject3).afos))
          {
            paramView.height = ((m)localObject3).afos;
            ((f)localObject2).afoQ.setLayoutParams((ViewGroup.LayoutParams)paramView);
          }
          label4735:
          if ((localbb.adis <= 2) || (localbb.adis == 10))
          {
            if (((f)localObject2).contentView.getAlpha() != 1.0F) {
              break label5122;
            }
            i = 1;
            if (i == 0) {
              ((f)localObject2).contentView.setAlpha(1.0F);
            }
          }
          if ((localbb.adis == 2) && (((m)localObject3).afpB))
          {
            paramView = ((m)localObject3).afpH;
            if (paramView != null)
            {
              paramViewGroup = ((f)localObject2).afoQ;
              if (paramViewGroup != null)
              {
                i = paramViewGroup.hashCode();
                paramViewGroup = (Animator)paramView.afug.get(i);
                if (paramViewGroup != null)
                {
                  paramViewGroup.end();
                  paramView.afug.remove(i);
                }
              }
            }
            paramView = m.a(((m)localObject3).a((f)localObject2, localbb));
            paramViewGroup = ((m)localObject3).afpH;
            if ((paramViewGroup != null) && (paramView.length != 0) && (paramViewGroup.afun) && (paramInt > paramViewGroup.afum))
            {
              if (paramViewGroup.aful == -1) {
                paramViewGroup.aful = paramInt;
              }
              if (paramViewGroup.afuk == -1L) {
                paramViewGroup.afuk = SystemClock.uptimeMillis();
              }
              localObject2 = new AnimatorSet();
              ((AnimatorSet)localObject2).playTogether(paramView);
              ((AnimatorSet)localObject2).setStartDelay(0L);
              ((AnimatorSet)localObject2).setDuration(paramViewGroup.afuj);
              ((AnimatorSet)localObject2).start();
              paramViewGroup.afug.put(localObject1.hashCode(), localObject2);
              paramViewGroup.afum = paramInt;
            }
          }
          paramView = ((m)localObject3).afpq;
          if ((paramView == null) || (paramView.getVisibility() != 0)) {
            break label5128;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label5131;
          }
          paramView = com.tencent.mm.storage.b.a.admS;
          if (!com.tencent.mm.storage.b.a.jdN()) {
            break label5133;
          }
        }
      }
      label4037:
      label4553:
      label4698:
      for (paramInt = 131072;; paramInt = 262144)
      {
        ((m)localObject3).a(paramInt, ((m)localObject3).afpr, ((m)localObject3).afoS, ((m)localObject3).afpC);
        break;
        paramView = null;
        break label4698;
        if (localbb.adis != 4) {
          break label4735;
        }
        paramView = (CharSequence)localbb.field_parentRef;
        if ((paramView == null) || (paramView.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (((f)localObject2).afoQ.getMeasuredHeight() == ((m)localObject3).afpM)) {
            break label5120;
          }
          m.u(localbb);
          break;
        }
        break label4735;
        i = 0;
        break label4770;
        paramInt = 0;
        break label5006;
        break;
      }
    }
  }
  
  public final void jAi()
  {
    AppMethodBeat.i(38502);
    super.v(null, 1);
    AppMethodBeat.o(38502);
  }
  
  public final boolean jdV()
  {
    AppMethodBeat.i(38519);
    boolean bool = super.jdV();
    AppMethodBeat.o(38519);
    return bool;
  }
  
  public final com.tencent.mm.storagebase.a.d jhR()
  {
    AppMethodBeat.i(38512);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    bh.bCz();
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)com.tencent.mm.model.c.bzG().I(this.lMF, com.tencent.mm.l.a.maX);
    AppMethodBeat.o(38512);
    return locald;
  }
  
  public final void jxZ()
  {
    boolean bool1 = true;
    AppMethodBeat.i(38496);
    if (this.lMF == null) {
      this.lMF = new ArrayList();
    }
    this.lMF.clear();
    int i;
    if ((z.bAQ() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = z.bBo();
      if ((i == 0) || (!bool2)) {
        break label198;
      }
      label59:
      if (bool1 != this.afoj)
      {
        if (!bool1) {
          break label203;
        }
        bh.bCz();
        onNotifyChange(5, (MStorageEx)com.tencent.mm.model.c.bzG(), "floatbottle");
        label89:
        this.afoj = bool1;
      }
      if (this.afoj) {
        this.lMF.add("floatbottle");
      }
      this.lMF.add("qmessage");
      bool1 = jAk();
      if (bool1 != this.afok)
      {
        if (!bool1) {
          break label224;
        }
        bh.bCz();
        onNotifyChange(2, (MStorageEx)com.tencent.mm.model.c.bzG(), "appbrand_notify_message");
      }
    }
    for (;;)
    {
      this.afok = bool1;
      if (!this.afok) {
        this.lMF.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38496);
      return;
      i = 0;
      break;
      label198:
      bool1 = false;
      break label59;
      label203:
      bh.bCz();
      onNotifyChange(2, (MStorageEx)com.tencent.mm.model.c.bzG(), "floatbottle");
      break label89;
      label224:
      bh.bCz();
      onNotifyChange(5, (MStorageEx)com.tencent.mm.model.c.bzG(), "appbrand_notify_message");
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(38522);
    if (!this.afox)
    {
      super.notifyDataSetChanged();
      afoc.clear();
      if ((this.afnw != null) && (this.afnw.afpF)) {
        this.afnw.jAt();
      }
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap %s", new Object[] { Boolean.valueOf(this.afox) });
    AppMethodBeat.o(38522);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(38517);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(38517);
      return;
    }
    String str = (String)paramObject;
    if ((paramMStorageEx instanceof by))
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
      if ((!str.contains("@")) || (str.endsWith("@chatroom")) || (str.endsWith("@im.chatroom")) || (str.endsWith("@micromsg.qq.com")) || (au.bwO(str))) {}
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.aebd != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.afoi = true;
            super.v(null, 1);
            AppMethodBeat.o(38517);
          }
        }
        else {
          this.afoh.add(str);
        }
      }
      if (paramInt != 8) {}
      for (boolean bool = true;; bool = false)
      {
        if (paramInt != 3)
        {
          i = paramInt;
          if (paramInt != 8) {}
        }
        else
        {
          i = 2;
        }
        super.d(str, i, bool);
        AppMethodBeat.o(38517);
        return;
      }
    }
    if ((paramMStorageEx instanceof bx))
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", new Object[] { Integer.valueOf(paramInt), paramObject, Boolean.valueOf(this.Kgb) });
      if (this.Kgb)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (!Util.isNullOrNil(str))
      {
        paramMStorageEx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
        if ((paramMStorageEx != null) && ((int)paramMStorageEx.maN > 0)) {
          Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(paramMStorageEx.aGe()), Integer.valueOf(paramMStorageEx.kaf) });
        }
      }
      this.afog = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if ((this.aebd == null) || (!this.aebd.containsKey(str)))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.afoa != null) {
        this.afoa.add(str);
      }
    }
    AppMethodBeat.o(38517);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38497);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.aepk);
    if (!this.aepk)
    {
      AppMethodBeat.o(38497);
      return;
    }
    this.aepk = false;
    super.pause();
    if (this.vzi != null) {
      this.vzi.fSm();
    }
    AppMethodBeat.o(38497);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(38499);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.aepk);
    if (this.aepk)
    {
      AppMethodBeat.o(38499);
      return;
    }
    this.aepk = true;
    jxZ();
    jAj();
    super.jhY();
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.platformtools.e.a("MM/dd", (Time)localObject).toString();
    String str = LocaleUtil.getApplicationLanguage();
    if ((!this.afmQ.equals(localObject)) || (!this.afol.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.afmQ = ((String)localObject);
      this.afol = str;
      if (i != 0) {
        fHY();
      }
      if ((this.afmL) && (this.afnZ != null))
      {
        this.afnZ.jAl();
        this.afmL = false;
        super.v(null, 1);
      }
      AppMethodBeat.o(38499);
      return;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  final class a
  {
    public int afmZ;
    public String content;
    public String nickName;
    public String time;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void jAl();
  }
  
  final class c
  {
    boolean FpN = false;
    public View adSL = null;
    boolean afoC = false;
    boolean afoD = false;
    boolean afoE = false;
    boolean afoF = false;
    public ImageView afoG = null;
    public TextView afoH = null;
    public View afoI = null;
    String username = "";
    public View vzn = null;
    public TextView vzo = null;
    
    c() {}
  }
  
  final class d
  {
    public boolean Aeu;
    public int adis;
    public boolean aebg;
    public CharSequence afna;
    public CharSequence afnb;
    public int afnc;
    public int afnd;
    public int afne;
    public boolean afnf;
    public boolean afng;
    public boolean afni;
    public boolean afnj;
    public boolean afnk;
    public boolean afnl;
    public String displayName;
    public CharSequence nickName;
    public int viewType;
    
    private d() {}
  }
  
  final class e
  {
    private Integer afnn = null;
    private au contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final void BS(String paramString)
    {
      AppMethodBeat.i(38492);
      this.talker = paramString;
      this.contact = null;
      this.afnn = null;
      this.initialized = false;
      if (!Util.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(38492);
    }
    
    public final au jzV()
    {
      AppMethodBeat.i(38493);
      if ((this.initialized) && (this.contact == null) && (bh.baz()))
      {
        bh.bCz();
        this.contact = com.tencent.mm.model.c.bzA().JE(this.talker);
      }
      au localau = this.contact;
      AppMethodBeat.o(38493);
      return localau;
    }
  }
  
  public static final class f
  {
    public int adis;
    public boolean aebg;
    public NoMeasuredTextView aebj;
    public NoMeasuredTextView aebk;
    public NoMeasuredTextView aebl;
    public View aebo;
    public ImageView afnp;
    public ImageView afoJ;
    public WeImageView afoK;
    public ImageView afoL;
    public WeImageView afoM;
    public k.c afoN;
    public int afoO;
    public int afoP;
    public View afoQ;
    public ImageView afoR;
    public TextView afoS;
    public View contentView;
    public ImageView lBC;
    public int position;
    public String username;
    public TextView vzm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */