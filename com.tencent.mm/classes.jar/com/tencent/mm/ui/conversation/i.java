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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.t;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
  extends com.tencent.mm.ui.f<String, az>
  implements MStorageEx.IOnStorageChange
{
  boolean EqF;
  MStorage.IOnStorageChange OLa;
  private NoMeasuredTextView.c PSx;
  private float Paq;
  private float Pat;
  private float Pau;
  private ColorStateList[] Pav;
  HashMap<String, d> Pax;
  public boolean PmS;
  private boolean QbL;
  com.tencent.mm.pluginsdk.ui.e QbN;
  private boolean QbO;
  IListener QbR;
  public String QbT;
  private final int QbV;
  private final int QbW;
  private a QeA;
  private long QeB;
  private boolean QeC;
  boolean QeD;
  private boolean Qeh;
  private xq Qei;
  b Qej;
  private HashSet<String> Qek;
  private boolean Qel;
  HashMap<String, Integer> Qem;
  private HashMap<String, Integer> Qen;
  private boolean Qeo;
  HashSet<String> Qep;
  boolean Qeq;
  private boolean Qer;
  private boolean Qes;
  public String Qet;
  boolean Qeu;
  private String Qev;
  private ColorDrawable Qew;
  ValueAnimator Qex;
  final e Qey;
  private float Qez;
  protected List<String> gzY;
  private boolean khr;
  private ListView mListView;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.d plb;
  boolean yJA;
  
  public i(Context paramContext, ListView paramListView, f.a parama)
  {
    super(paramContext, (short)0);
    AppMethodBeat.i(38494);
    this.gzY = null;
    this.Pav = new ColorStateList[5];
    this.QbL = true;
    this.Qeh = false;
    this.plb = MMSlideDelView.getItemStatusCallBack();
    this.Qei = null;
    this.khr = false;
    this.Paq = -1.0F;
    this.Pat = -1.0F;
    this.Pau = -1.0F;
    this.QbO = false;
    this.QbR = null;
    this.Qej = null;
    this.PmS = false;
    this.Qel = false;
    this.Qem = new HashMap();
    this.Qen = new HashMap();
    this.Qeo = false;
    this.Qeq = false;
    this.Qer = false;
    this.Qes = false;
    this.PSx = new NoMeasuredTextView.c()
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
          paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.span.l.c(i.b(i.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.cb.a.m(i.c(i.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(38482);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.QbT = "";
    this.Qet = "";
    this.Qeu = true;
    this.OLa = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(38488);
        i.this.notifyDataSetChanged();
        AppMethodBeat.o(38488);
      }
    };
    this.Qey = new e();
    this.EqF = false;
    this.Qez = -1.0F;
    this.QeB = 0L;
    this.QeC = false;
    this.yJA = false;
    this.QeD = false;
    this.mListView = paramListView;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.Pav[0] = com.tencent.mm.cb.a.m(paramContext, 2131100594);
    this.Pav[1] = com.tencent.mm.cb.a.m(paramContext, 2131100813);
    this.Pav[3] = com.tencent.mm.cb.a.m(paramContext, 2131100904);
    this.Pav[2] = com.tencent.mm.cb.a.m(paramContext, 2131099783);
    this.Pav[2] = com.tencent.mm.cb.a.m(paramContext, 2131099783);
    this.Pav[4] = com.tencent.mm.cb.a.m(paramContext, 2131100594);
    if (com.tencent.mm.cb.a.jl(paramContext))
    {
      this.QbW = paramContext.getResources().getDimensionPixelSize(2131165250);
      this.QbV = paramContext.getResources().getDimensionPixelSize(2131165251);
    }
    for (;;)
    {
      this.Pax = new HashMap();
      this.Qek = new HashSet();
      this.Qep = new HashSet();
      this.Paq = paramContext.getResources().getDimension(2131165535);
      this.Pat = paramContext.getResources().getDimension(2131165482);
      this.Pau = paramContext.getResources().getDimension(2131165594);
      this.gzY = new ArrayList();
      this.gzY.add("qmessage");
      this.Qes = gVO();
      if (!this.Qes) {
        this.gzY.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38494);
      return;
      if (com.tencent.mm.cb.a.jk(paramContext))
      {
        this.QbW = paramContext.getResources().getDimensionPixelSize(2131165249);
        this.QbV = paramContext.getResources().getDimensionPixelSize(2131165251);
      }
      else
      {
        this.QbW = paramContext.getResources().getDimensionPixelSize(2131165248);
        this.QbV = paramContext.getResources().getDimensionPixelSize(2131165252);
      }
    }
  }
  
  private SparseArray<String> a(f.b<String, az> paramb, SparseArray<String> paramSparseArray, HashMap<String, az> paramHashMap)
  {
    AppMethodBeat.i(38516);
    String str = (String)paramb.object;
    int k = paramSparseArray.size();
    az localaz = (az)paramb.OAb;
    int j = paramSparseArray.size();
    int i = 0;
    label39:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      Log.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i) });
      switch (paramb.OAa)
      {
      case 3: 
      case 4: 
      default: 
        if (i >= 0) {
          break label411;
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
      if (localaz == null)
      {
        Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
        if (i >= 0)
        {
          Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[] { str });
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
      while ((i < k) && (f((String)paramSparseArray.get(i), paramHashMap).field_flag > localaz.field_flag)) {
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
    if (localaz == null)
    {
      Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[] { str });
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
    long l2 = localaz.field_flag;
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
      if (f((String)paramSparseArray.get(k), paramHashMap).field_flag > localaz.field_flag) {
        break label666;
      }
    }
    label666:
    label765:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(-1), Boolean.valueOf(bool), Integer.valueOf(i), str });
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
  
  private void a(d paramd, as paramas)
  {
    AppMethodBeat.i(38505);
    if ((paramd.tcb) && (paramd.gCv == null))
    {
      paramd.nickName = this.context.getString(2131757507);
      AppMethodBeat.o(38505);
      return;
    }
    if (as.bjp(paramas.field_username))
    {
      paramd.nickName = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), paramd.gCv, com.tencent.mm.cb.a.aG(this.context, 2131165535));
      AppMethodBeat.o(38505);
      return;
    }
    paramd.nickName = com.tencent.mm.pluginsdk.ui.span.l.e(this.context, paramd.gCv, com.tencent.mm.cb.a.aG(this.context, 2131165535));
    AppMethodBeat.o(38505);
  }
  
  private static int ahn(String paramString)
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
  
  private static int anD(int paramInt)
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
      return 2131691165;
    }
    return 2131691164;
  }
  
  private CharSequence b(az paramaz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38509);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramaz.oV(268435456)) && (!com.tencent.mm.model.ab.Eq(paramaz.field_username)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131764297));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100996)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject1);
      Log.i("MicroMsg.ConversationWithCacheAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { paramaz.field_username, Integer.valueOf(paramaz.field_attrflag) });
    }
    while (((!Util.isNullOrNil(paramaz.field_editingMsg)) || (paramaz.field_editingQuoteMsgId != 0L)) && ((paramaz.field_atCount <= 0) || ((paramaz.field_unReadCount <= 0) && (paramaz.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131762834));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100996)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      if (!Util.isNullOrNil(paramaz.field_editingMsg)) {
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, paramaz.field_editingMsg, paramInt));
      }
      paramaz = localSpannableStringBuilder.append((CharSequence)localObject1);
      AppMethodBeat.o(38509);
      return paramaz;
      if ((paramaz.oV(268435456)) && (com.tencent.mm.model.ab.Eq(paramaz.field_username)))
      {
        Log.w("MicroMsg.ConversationWithCacheAdapter", "wrong flag");
        com.tencent.mm.plugin.report.service.h.CyF.a(20435, new Object[] { Integer.valueOf(1) });
        Log.i("MicroMsg.ConversationWithCacheAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { paramaz.field_username, Integer.valueOf(paramaz.field_attrflag) });
      }
      else if (paramaz.field_hbMarkRed == 1)
      {
        localObject1 = new SpannableStringBuilder(this.context.getString(2131756190));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100996)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        localSpannableStringBuilder.append((CharSequence)localObject1);
        Log.i("MicroMsg.ConversationWithCacheAdapter", "mark hb flag conversation: %s", new Object[] { paramaz.field_username });
      }
    }
    if (ahn(paramaz.field_msgType) == 10000)
    {
      boolean bool2 = com.tencent.mm.model.ab.Js(paramaz.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramaz.oV(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramaz.oV(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramaz.oV(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = com.tencent.mm.model.ab.JB(paramaz.field_username);
      }
      if ((!bool2) && (paramaz.field_hasTodo != 1))
      {
        if (paramaz.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
        {
          Log.i("MicroMsg.ConversationWithCacheAdapter", "is transfer remind msg ");
          paramaz = localSpannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.i(this.context, paramaz.field_content, paramInt));
          AppMethodBeat.o(38509);
          return paramaz;
        }
        if (paramaz.field_hbMarkRed == 1)
        {
          paramaz = localSpannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.i(this.context, paramaz.field_content, paramInt));
          AppMethodBeat.o(38509);
          return paramaz;
        }
        paramaz = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.i(this.context, paramaz.field_content, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
      }
    }
    Object localObject3;
    if (ahn(paramaz.field_msgType) == 49)
    {
      localObject1 = aa.getDisplayName(paramaz.field_digestUser);
      localObject3 = k.b.HD(paramaz.field_content);
      if (localObject3 == null) {}
    }
    Object localObject4;
    switch (((k.b)localObject3).type)
    {
    default: 
    case 40: 
      do
      {
        localObject1 = paramaz.field_digest;
        if ((localObject1 == null) || (!((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
          break;
        }
        paramaz = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
      } while (t.HI(paramaz.field_content).iAl != 19);
      if (Util.isNullOrNil((String)localObject1)) {}
      for (localObject1 = this.context.getString(2131755961);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755961))
      {
        paramaz.Cm((String)localObject1);
        paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
      }
    case 5: 
      localObject1 = null;
      try
      {
        paramaz = String.format(paramaz.field_digest, new Object[] { l(paramaz) });
        localObject4 = new StringBuilder();
        localObject1 = paramaz;
        if (Util.isNullOrNil(paramaz)) {
          localObject1 = this.context.getString(2131756012);
        }
        paramaz = (String)localObject1 + " " + ((k.b)localObject3).title;
        paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.i(this.context, paramaz, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
      }
      catch (Exception paramaz)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramaz, "", new Object[0]);
          paramaz = (az)localObject1;
        }
      }
    }
    if (Util.isNullOrNil((String)localObject1)) {}
    for (Object localObject1 = this.context.getString(2131755961);; localObject1 = (String)localObject1 + ": " + this.context.getString(2131755961))
    {
      paramaz.Cm((String)localObject1);
      paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38509);
      return paramaz;
    }
    localObject1 = paramaz.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      bg.aVF();
      if (Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramaz = this.context.getString(2131765538);
        AppMethodBeat.o(38509);
        return paramaz;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSW().aEY("@t.qq.com");
      if ((localObject1 != null) && (((ci)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramaz = this.context.getString(2131765538);
        AppMethodBeat.o(38509);
        return paramaz;
      }
    }
    if ((paramaz.field_msgType != null) && (paramaz.field_msgType.equals("64")))
    {
      paramaz = paramaz.field_content;
      AppMethodBeat.o(38509);
      return paramaz;
    }
    if ((paramaz.field_msgType != null) && ((paramaz.field_msgType.equals("47")) || (paramaz.field_msgType.equals("1048625"))))
    {
      localObject1 = bmp(paramaz.field_digest);
      localObject3 = "";
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramaz = localSpannableStringBuilder.append("[" + (String)localObject1 + "]");
        AppMethodBeat.o(38509);
        return paramaz;
      }
      localObject1 = localObject3;
      if (paramaz.field_digest != null)
      {
        localObject1 = localObject3;
        if (paramaz.field_digest.contains(":"))
        {
          localObject3 = paramaz.field_digest.substring(0, paramaz.field_digest.indexOf(":"));
          localObject4 = bmp(paramaz.field_digest.substring(paramaz.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject3;
          if (!Util.isNullOrNil((String)localObject4))
          {
            paramaz = "[" + (String)localObject4 + "]";
            if (Util.isNullOrNil((String)localObject3))
            {
              paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject3, paramInt));
              AppMethodBeat.o(38509);
              return paramaz;
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject3, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramaz);
            paramaz = localSpannableStringBuilder.append((CharSequence)localObject1);
            AppMethodBeat.o(38509);
            return paramaz;
          }
        }
      }
      localObject3 = this.context.getString(2131755793);
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = localObject3;
        paramaz.Cm((String)localObject1);
      }
    }
    else
    {
      if (Util.isNullOrNil(paramaz.field_digest)) {
        break label1816;
      }
      if (Util.isNullOrNil(paramaz.field_digestUser)) {
        break label1805;
      }
      localObject1 = l(paramaz);
    }
    label1805:
    label1816:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramaz.field_digest, new Object[] { localObject1 });
        localObject3 = ((String)localObject1).replace('\n', ' ');
        if ((!paramaz.oV(33554432)) || ((paramaz.field_unReadCount <= 0) && (paramaz.field_unReadMuteCount <= 0))) {
          break label1847;
        }
        paramaz = new SpannableStringBuilder(this.context.getString(2131766579));
        paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100996)), 0, paramaz.length(), 33);
        paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject3, paramInt));
        paramaz = localSpannableStringBuilder.append(paramaz);
        AppMethodBeat.o(38509);
        return paramaz;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject3;
      break;
      localObject1 = paramaz.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramaz.field_isSend, paramaz.field_username, paramaz.field_content, ahn(paramaz.field_msgType), this.context);
    }
    label1847:
    if (paramaz.field_UnReadInvite > 0)
    {
      if (paramaz.field_UnReadInvite < 4096) {}
      for (paramaz = this.context.getString(2131762826, new Object[] { Integer.valueOf(paramaz.field_UnReadInvite) });; paramaz = this.context.getString(2131762823))
      {
        paramaz = new SpannableStringBuilder(paramaz);
        paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100996)), 0, paramaz.length(), 33);
        paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject3, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
      }
    }
    if ((paramaz.field_atCount > 0) && ((paramaz.field_unReadCount > 0) || (paramaz.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramaz.field_atCount < 4096) {
        i = 2131762825;
      }
      for (;;)
      {
        paramaz = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100996)), 0, paramaz.length(), 33);
        paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject3, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
        if (com.tencent.mm.al.g.DQ(paramaz.field_username)) {
          i = 2131762824;
        } else {
          i = 2131762827;
        }
      }
    }
    if (paramaz.field_hasTodo == 1)
    {
      paramaz = new SpannableStringBuilder(this.context.getString(2131766793));
      paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100996)), 0, paramaz.length(), 33);
      paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject3, paramInt));
      AppMethodBeat.o(38509);
      return paramaz;
    }
    if ((paramaz.oV(16777216)) && ((paramaz.field_unReadCount > 0) || (paramaz.field_unReadMuteCount > 0)))
    {
      paramaz = this.context.getString(2131755037);
      localObject2 = ((String)localObject3).replace(paramaz, "");
      paramaz = new SpannableStringBuilder(paramaz);
      paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(2131100996)), 0, paramaz.length(), 33);
      paramaz.append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject2, paramInt));
      paramaz = localSpannableStringBuilder.append(paramaz);
      AppMethodBeat.o(38509);
      return paramaz;
    }
    if ((paramaz.oV(268435456)) && (!com.tencent.mm.model.ab.Eq(paramaz.field_username)))
    {
      localSpannableStringBuilder.append(((String)localObject3).replace(this.context.getString(2131764297), ""));
      AppMethodBeat.o(38509);
      return localSpannableStringBuilder;
    }
    if (paramaz.field_hbMarkRed == 1)
    {
      localObject2 = localObject3;
      if (ahn(paramaz.field_msgType) == 436207665)
      {
        paramaz = k.b.HD(paramaz.field_content);
        if (paramaz == null) {
          break label3052;
        }
      }
    }
    label2871:
    label3052:
    for (paramaz = ((String)localObject3).replace("[" + paramaz.iyo + "]", "");; paramaz = (az)localObject3)
    {
      localObject2 = paramaz;
      for (;;)
      {
        paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject2, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
        if ((paramBoolean) && ((paramaz.field_unReadCount > 1) || (paramaz.field_unReadMuteCount > 0)))
        {
          localObject2 = this.context.getString(2131762828, new Object[] { Integer.valueOf(paramaz.field_unReadCount), localObject3 });
        }
        else
        {
          if ((!com.tencent.mm.storage.ab.clc()) || (!com.tencent.mm.model.ab.Js(paramaz.field_username))) {
            break label2928;
          }
          localObject2 = com.tencent.mm.plugin.biz.b.a.pfl;
          localObject2 = com.tencent.mm.plugin.biz.b.a.a(paramInt, this.context, paramaz);
          if ((localObject2 != null) && (((CharSequence)localObject2).length() > 0))
          {
            AppMethodBeat.o(38509);
            return localObject2;
          }
          paramBoolean = paramaz.oV(16);
          if ((paramaz.field_unReadCount <= 1) && ((paramBoolean) || (paramaz.field_unReadCount <= 0))) {
            break label2871;
          }
          if (!paramBoolean) {
            break;
          }
          if (paramaz.oV(32))
          {
            paramaz = this.context.getString(2131762820, new Object[] { Integer.valueOf(paramaz.field_unReadCount) });
            localObject2 = com.tencent.mm.plugin.biz.b.a.pfl;
            paramaz = TextUtils.concat(new CharSequence[] { paramaz, " ", com.tencent.mm.plugin.biz.b.a.c(paramInt, this.context), com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject3, paramInt) });
            AppMethodBeat.o(38509);
            return paramaz;
          }
          localObject2 = this.context.getString(2131762828, new Object[] { Integer.valueOf(paramaz.field_unReadCount), localObject3 });
        }
      }
      long l = MultiProcessMMKV.getSingleMMKV("brandService").decodeLong("BizLastMsgId");
      if (l < 0L)
      {
        localObject2 = com.tencent.mm.al.ag.bap().R(l, "msgId");
        if ((localObject2 != null) && (((com.tencent.mm.storage.z)localObject2).gAx()))
        {
          localObject2 = com.tencent.mm.storage.ag.K((com.tencent.mm.storage.z)localObject2);
          if (localObject2 == null) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject3;
        if (i == 0) {
          break;
        }
        localObject2 = this.context.getString(2131762821, new Object[] { Integer.valueOf(paramaz.field_unReadCount), localObject3 });
        break;
        if (localObject2 != null)
        {
          if (Util.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.notify_msg.is_show_msg_count"), 1) == 1)
          {
            i = 1;
            continue;
          }
          i = 0;
          continue;
          localObject2 = localObject3;
          if (!paramaz.oV(32)) {
            break;
          }
          paramaz = com.tencent.mm.plugin.biz.b.a.pfl;
          paramaz = TextUtils.concat(new CharSequence[] { com.tencent.mm.plugin.biz.b.a.c(paramInt, this.context), com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject3, paramInt) });
          AppMethodBeat.o(38509);
          return paramaz;
          label2928:
          if ((com.tencent.mm.model.ab.JC(paramaz.field_username)) && ((paramaz.field_unReadCount > 1) || (paramaz.field_unReadMuteCount > 0)))
          {
            localObject2 = this.context.getString(2131762828, new Object[] { Integer.valueOf(paramaz.field_unReadCount), localObject3 });
            break;
          }
          if (ahn(paramaz.field_msgType) != 889192497)
          {
            localObject2 = localObject3;
            if (ahn(paramaz.field_msgType) != 922746929) {
              break;
            }
          }
          paramaz = j(ahn(paramaz.field_msgType), paramaz.field_content, paramaz.field_username, paramInt);
          AppMethodBeat.o(38509);
          return paramaz;
        }
        i = 1;
      }
    }
  }
  
  private static String bmp(String paramString)
  {
    AppMethodBeat.i(38511);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(paramString);
      AppMethodBeat.o(38511);
      return paramString;
    }
    AppMethodBeat.o(38511);
    return null;
  }
  
  private az f(String paramString, HashMap<String, az> paramHashMap)
  {
    AppMethodBeat.i(38515);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (az)paramHashMap.get(paramString);
      AppMethodBeat.o(38515);
      return paramString;
    }
    if (this.OzM == null) {}
    for (paramString = null;; paramString = this.OzM.Ouf.ee(paramString))
    {
      paramString = (az)paramString;
      AppMethodBeat.o(38515);
      return paramString;
    }
  }
  
  private boolean gVL()
  {
    return this.Qev != null;
  }
  
  private void gVN()
  {
    AppMethodBeat.i(38518);
    if ((this.Pax == null) || (this.Qek == null) || (this.Qek.isEmpty()))
    {
      AppMethodBeat.o(38518);
      return;
    }
    Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.Qek.size()) });
    Iterator localIterator = this.Qek.iterator();
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
        if (!this.Pax.containsKey(str1)) {
          break label360;
        }
        d locald = (d)this.Pax.get(str1);
        j = i;
        if (locald == null) {
          break label360;
        }
        this.Qey.Cy(str1);
        bool1 = com.tencent.mm.model.ab.Eq(str1);
        as localas = this.Qey.eFa();
        if (localas != null)
        {
          String str2 = aa.a(localas, str1, bool1);
          Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.gCv });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.gCv))
            {
              locald.gCv = str2;
              a(locald, localas);
              j = 1;
            }
          }
          boolean bool2 = localas.Zx();
          if (localas.fuH == 0)
          {
            bool1 = true;
            label269:
            if ((locald.Qcj == bool2) && (bool1 == locald.Qcn)) {
              break label360;
            }
            locald.Qcj = bool2;
            locald.Qcn = bool1;
            locald.Qco = localas.amU();
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
      this.Qek.clear();
      AppMethodBeat.o(38518);
      return;
    }
  }
  
  private static boolean gVO()
  {
    AppMethodBeat.i(234154);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXN, false);
    Log.i("MicroMsg.ConversationWithCacheAdapter", "isShowAppBrandNotifyMsgEntry: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(234154);
    return bool;
  }
  
  private void gVp()
  {
    AppMethodBeat.i(38498);
    if (this.Pax == null)
    {
      AppMethodBeat.o(38498);
      return;
    }
    Iterator localIterator = this.Pax.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).Qcd = null;
    }
    AppMethodBeat.o(38498);
  }
  
  private CharSequence i(az paramaz)
  {
    AppMethodBeat.i(38495);
    if (paramaz.field_status == 1)
    {
      paramaz = this.context.getString(2131762861);
      AppMethodBeat.o(38495);
      return paramaz;
    }
    if (paramaz.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38495);
      return "";
    }
    paramaz = com.tencent.mm.pluginsdk.i.f.c(this.context, paramaz.field_conversationTime, true);
    AppMethodBeat.o(38495);
    return paramaz;
  }
  
  private CharSequence j(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(234152);
    Object localObject2 = new czg();
    Object localObject1;
    if (paramInt1 == 889192497) {
      localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.patmsg.a.b.class)).aJJ(paramString1);
    }
    for (;;)
    {
      try
      {
        if (((czg)localObject1).yVw.size() <= 0) {
          continue;
        }
        localObject1 = (czh)((czg)localObject1).yVw.getLast();
        paramString1 = ((PluginPatMsg)com.tencent.mm.kernel.g.ah(PluginPatMsg.class)).parseDisplayTemplate(((czh)localObject1).iBd, paramString2);
        paramString2 = new SpannableString(paramString1.result);
        localObject2 = com.tencent.mm.model.z.aTY();
        if ((!((czh)localObject1).dRL.equals(localObject2)) && (((czh)localObject1).MEA.equals(localObject2)) && (((czh)localObject1).MEB == 0) && (!paramString1.ARm.isEmpty()))
        {
          localObject1 = new BoldForegroundColorSpan(this.context.getResources().getColor(2131099746));
          localObject2 = this.context.getString(2131763811);
          int j = paramString1.result.indexOf((String)localObject2, ((Integer)((Pair)paramString1.ARm.get(0)).second).intValue());
          int i = ((String)localObject2).length() + j;
          paramInt1 = i;
          if (i > paramString2.length()) {
            paramInt1 = paramString2.length();
          }
          paramString2.setSpan(localObject1, j, paramInt1, 17);
        }
        paramString1 = com.tencent.mm.pluginsdk.ui.span.l.d(this.context, paramString2, paramInt2);
        AppMethodBeat.o(234152);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramString1, "", new Object[0]);
        AppMethodBeat.o(234152);
      }
      localObject1 = localObject2;
      if (paramInt1 == 922746929)
      {
        paramString1 = k.b.HD(paramString1);
        localObject1 = localObject2;
        if (paramString1 != null) {
          localObject1 = ((com.tencent.mm.plugin.patmsg.a.a)paramString1.as(com.tencent.mm.plugin.patmsg.a.a.class)).ARl;
        }
      }
    }
    return "";
  }
  
  static int k(az paramaz)
  {
    AppMethodBeat.i(234151);
    if ((paramaz == null) || (paramaz.field_unReadCount <= 0))
    {
      if (((paramaz.oV(8388608)) || (paramaz.oV(2097152))) && (paramaz.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(234151);
        return 1;
      }
      AppMethodBeat.o(234151);
      return 0;
    }
    if (com.tencent.mm.model.ab.Js(paramaz.field_username))
    {
      if ((com.tencent.mm.storage.ab.clc()) && (!paramaz.oV(16)) && (!paramaz.oV(64)))
      {
        AppMethodBeat.o(234151);
        return 0;
      }
      AppMethodBeat.o(234151);
      return 1;
    }
    if (com.tencent.mm.model.ab.Jx(paramaz.field_username))
    {
      bg.aVF();
      if (!com.tencent.mm.model.c.azQ().getBoolean(ar.a.NYF, true))
      {
        AppMethodBeat.o(234151);
        return 1;
      }
    }
    if (com.tencent.mm.model.ab.JB(paramaz.field_username))
    {
      bg.aVF();
      if (!com.tencent.mm.model.c.azQ().getBoolean(ar.a.NYG, true))
      {
        AppMethodBeat.o(234151);
        return 1;
      }
    }
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(paramaz.field_username);
    if ((localas != null) && ((int)localas.gMZ != 0))
    {
      if ((localas.Zx()) && (localas.amU()))
      {
        AppMethodBeat.o(234151);
        return 1;
      }
      if ((com.tencent.mm.model.ab.Eq(paramaz.field_username)) && (localas.fuH == 0))
      {
        AppMethodBeat.o(234151);
        return 1;
      }
    }
    if (com.tencent.mm.model.ab.JC(paramaz.field_username))
    {
      AppMethodBeat.o(234151);
      return 1;
    }
    AppMethodBeat.o(234151);
    return 2;
  }
  
  private static String l(az paramaz)
  {
    AppMethodBeat.i(38510);
    if ((paramaz.field_isSend == 0) && (com.tencent.mm.model.ab.Eq(paramaz.field_username)))
    {
      paramaz = aa.getDisplayName(paramaz.field_digestUser, paramaz.field_username);
      AppMethodBeat.o(38510);
      return paramaz;
    }
    paramaz = aa.getDisplayName(paramaz.field_digestUser);
    AppMethodBeat.o(38510);
    return paramaz;
  }
  
  public final void a(View paramView, int paramInt, String paramString)
  {
    AppMethodBeat.i(38500);
    if (paramView == null)
    {
      AppMethodBeat.o(38500);
      return;
    }
    if ((this.Qev != null) && (!com.tencent.mm.ui.ao.gJK()))
    {
      Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(38500);
      return;
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.Qev = paramString;
    f localf = (f)paramView.getTag();
    int j = paramView.getContext().getResources().getColor(2131099750);
    Resources localResources = paramView.getContext().getResources();
    int i;
    if ((localf != null) && (localf.PaB))
    {
      i = 2131099651;
      i = localResources.getColor(i);
      if (!com.tencent.mm.ui.ao.gJK()) {
        break label314;
      }
      localResources = paramView.getContext().getResources();
      if ((localf == null) || (!localf.PaB)) {
        break label306;
      }
      i = 2131100190;
      label181:
      i = localResources.getColor(i);
    }
    label306:
    label314:
    for (;;)
    {
      this.Qew = new ColorDrawable(ar.v(j, i));
      paramView.setBackground(this.Qew);
      if (com.tencent.mm.ui.ao.gJK()) {
        notifyDataSetChanged();
      }
      if (com.tencent.mm.model.ab.JC(paramString))
      {
        paramView = (az)akz(paramInt);
        paramString = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class);
        com.tencent.mm.kernel.g.aAf();
        paramString.UF(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
        paramString.a(new g.a(paramView.field_unReadCount, paramInt + 1));
      }
      AppMethodBeat.o(38500);
      return;
      i = 2131099650;
      break;
      i = 2131100227;
      break label181;
    }
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, az>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(38514);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.g.aAc()))
    {
      AppMethodBeat.o(38514);
      return paramArrayOfSparseArray;
    }
    Log.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[] { Integer.valueOf(paramHashSet.size()), Integer.valueOf(paramArrayOfSparseArray[0].size()) });
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (f.b)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((f.b)localObject3).OAa != 5) && (!((ArrayList)localObject1).contains(((f.b)localObject3).object)))
      {
        Log.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((f.b)localObject3).object);
        ((ArrayList)localObject1).add(((f.b)localObject3).object);
      }
    }
    localObject2 = new HashMap();
    bg.aVF();
    Object localObject3 = com.tencent.mm.model.c.aST().a((ArrayList)localObject1, com.tencent.mm.model.ab.iCF, this.gzY, com.tencent.mm.o.a.gNj);
    Object localObject4;
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = new az();
      ((az)localObject4).convertFrom((Cursor)localObject3);
      ((HashMap)localObject2).put(((bb)localObject4).field_username, localObject4);
    }
    ((Cursor)localObject3).close();
    localObject3 = paramHashSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (f.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((f.b)localObject4).OAa != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((f.b)localObject4).object).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((f.b)localObject4).object) == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((f.b)localObject4).OAb = ((HashMap)localObject2).get(((f.b)localObject4).object);
            break;
          }
        }
        ((f.b)localObject4).OAb = null;
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
        if (((f.b)localObject2).OAa != 5) {
          ((HashMap)localObject1).put(((f.b)localObject2).object, ((f.b)localObject2).OAb);
        }
      }
    }
    AppMethodBeat.o(38514);
    return paramArrayOfSparseArray;
  }
  
  public final void anQ(int paramInt)
  {
    AppMethodBeat.i(38501);
    if (!gVL())
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
        i.e(i.this);
        AppMethodBeat.o(38485);
      }
    }, paramInt);
    AppMethodBeat.o(38501);
  }
  
  public final void anR(int paramInt)
  {
    AppMethodBeat.i(38521);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(38521);
      return;
    }
    try
    {
      az localaz = (az)akz(paramInt);
      if (localaz == null)
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
      com.tencent.mm.pluginsdk.ui.a.b.gov().fZ(localObject.field_username);
      AppMethodBeat.o(38521);
    }
  }
  
  public final com.tencent.mm.ui.f<String, az>.c b(com.tencent.mm.storagebase.a.d paramd)
  {
    AppMethodBeat.i(234153);
    paramd = new f.c(this, paramd, (byte)0);
    AppMethodBeat.o(234153);
    return paramd;
  }
  
  public final ArrayList<az> bo(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(38513);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    bg.aVF();
    paramArrayList = com.tencent.mm.model.c.aST().a(paramArrayList, com.tencent.mm.model.ab.iCF, this.gzY, com.tencent.mm.o.a.gNj);
    while (paramArrayList.moveToNext())
    {
      az localaz = new az();
      localaz.convertFrom(paramArrayList);
      localArrayList.add(localaz);
    }
    paramArrayList.close();
    AppMethodBeat.o(38513);
    return localArrayList;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(38508);
    if (this.Pax != null)
    {
      this.Pax.clear();
      this.Qeq = true;
    }
    AppMethodBeat.o(38508);
  }
  
  public final boolean gFx()
  {
    AppMethodBeat.i(38519);
    boolean bool = super.gFx();
    AppMethodBeat.o(38519);
    return bool;
  }
  
  public final com.tencent.mm.storagebase.a.d gGY()
  {
    AppMethodBeat.i(38512);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    bg.aVF();
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)com.tencent.mm.model.c.aST().a(com.tencent.mm.model.ab.iCF, this.gzY, com.tencent.mm.o.a.gNj, true);
    AppMethodBeat.o(38512);
    return locald;
  }
  
  public final void gUq()
  {
    boolean bool1 = true;
    AppMethodBeat.i(38496);
    if (this.gzY == null) {
      this.gzY = new ArrayList();
    }
    this.gzY.clear();
    int i;
    if ((com.tencent.mm.model.z.aUc() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = com.tencent.mm.model.z.aUu();
      if ((i == 0) || (!bool2)) {
        break label198;
      }
      label59:
      if (bool1 != this.Qer)
      {
        if (!bool1) {
          break label203;
        }
        bg.aVF();
        onNotifyChange(5, (MStorageEx)com.tencent.mm.model.c.aST(), "floatbottle");
        label89:
        this.Qer = bool1;
      }
      if (this.Qer) {
        this.gzY.add("floatbottle");
      }
      this.gzY.add("qmessage");
      bool1 = gVO();
      if (bool1 != this.Qes)
      {
        if (!bool1) {
          break label224;
        }
        bg.aVF();
        onNotifyChange(2, (MStorageEx)com.tencent.mm.model.c.aST(), "appbrand_notify_message");
      }
    }
    for (;;)
    {
      this.Qes = bool1;
      if (!this.Qes) {
        this.gzY.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38496);
      return;
      i = 0;
      break;
      label198:
      bool1 = false;
      break label59;
      label203:
      bg.aVF();
      onNotifyChange(2, (MStorageEx)com.tencent.mm.model.c.aST(), "floatbottle");
      break label89;
      label224:
      bg.aVF();
      onNotifyChange(5, (MStorageEx)com.tencent.mm.model.c.aST(), "appbrand_notify_message");
    }
  }
  
  public final void gVM()
  {
    AppMethodBeat.i(38502);
    super.o(null, 1);
    AppMethodBeat.o(38502);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38503);
    this.QeA = new a((byte)0);
    az localaz = (az)akz(paramInt);
    String str = localaz.field_username;
    this.Qey.Cy(str);
    Object localObject1;
    int i;
    Object localObject3;
    label249:
    label505:
    boolean bool1;
    if (this.Qem.containsKey(str))
    {
      if (paramInt != ((Integer)this.Qem.get(str)).intValue())
      {
        localObject1 = gGZ();
        int k;
        if (this.OzM == null)
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
              paramViewGroup = this.OzM.Ouf.gFw();
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
              ((StringBuffer)localObject2).append(((az)((Map.Entry)localObject3).getValue()).field_username);
            }
            ((StringBuffer)localObject2).append("]");
          }
          ((StringBuffer)localObject2).append("\n");
        }
        localObject1 = ((StringBuffer)localObject2).toString();
        localObject2 = this.Qem.toString();
        if (paramViewGroup == null) {
          break label2299;
        }
        i = paramViewGroup.size();
        Log.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject1, str, Integer.valueOf(paramInt), localObject2, Integer.valueOf(i) });
        if (!this.Qel)
        {
          com.tencent.mm.plugin.fts.a.e.Nk(20);
          this.Qel = true;
        }
        if (System.currentTimeMillis() - this.QeB > 3600000L)
        {
          super.o(null, 1);
          this.QeB = System.currentTimeMillis();
        }
      }
      if (paramView != null) {
        break label2343;
      }
      localObject1 = new f();
      if (!com.tencent.mm.cb.a.jm(this.context)) {
        break label2322;
      }
      com.tencent.mm.kiss.a.b.aBh();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493796);
      label546:
      paramView.setTag(2131309367, new int[2]);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38489);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if ((i.g(i.this) == null) || (i.g(i.this).getOnItemClickListener() == null))
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
          if ((!i.this.PmS) && (!com.tencent.mm.ui.ao.gJK()))
          {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if ((i.g(i.this) == null) || (i.g(i.this).getOnItemLongClickListener() == null))
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
          if (!i.this.PmS)
          {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
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
      ((f)localObject1).gvv = ((ImageView)paramView.findViewById(2131297134));
      com.tencent.mm.pluginsdk.ui.a.b.c(((f)localObject1).gvv, str);
      paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)((f)localObject1).gvv.getDrawable();
      if (this.QbN != null) {
        this.QbN.a(paramViewGroup);
      }
      ((f)localObject1).gvv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(38491);
          this.QeH.gvv.getViewTreeObserver().removeOnPreDrawListener(this);
          int i = this.QeH.gvv.getWidth();
          int j = at.aH(i.h(i.this), 2131165526);
          if (i != j)
          {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.QeH.gvv.getLayoutParams();
            localLayoutParams.width = j;
            localLayoutParams.height = j;
            this.QeH.gvv.setLayoutParams(localLayoutParams);
            Log.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", new Object[] { Integer.valueOf(this.QeH.gvv.getWidth()) });
            if (!i.i(i.this))
            {
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1055L, 4L, 1L, false);
              Log.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
              i.j(i.this);
            }
          }
          AppMethodBeat.o(38491);
          return true;
        }
      });
      ((f)localObject1).PaE = ((NoMeasuredTextView)paramView.findViewById(2131305440));
      ((f)localObject1).PaE.setLayoutCallback(this.PSx);
      ((f)localObject1).PaF = ((NoMeasuredTextView)paramView.findViewById(2131309606));
      ((f)localObject1).QeQ = ((ImageView)paramView.findViewById(2131303012));
      ((f)localObject1).PaG = ((NoMeasuredTextView)paramView.findViewById(2131303011));
      ((f)localObject1).plf = ((TextView)paramView.findViewById(2131309165));
      ((f)localObject1).QeR = ((WeImageView)paramView.findViewById(2131302590));
      ((f)localObject1).PaJ = paramView.findViewById(2131297142);
      ((f)localObject1).Qcs = ((ImageView)paramView.findViewById(2131303751));
      ((f)localObject1).QeS = ((ImageView)paramView.findViewById(2131305037));
      ((f)localObject1).plf.setBackgroundResource(com.tencent.mm.ui.tools.v.kH(this.context));
      ((f)localObject1).plf.setTextSize(0, com.tencent.mm.cb.a.aH(this.context, 2131167084) * com.tencent.mm.cb.a.ji(this.context));
      ((f)localObject1).QeT = new c();
      paramView.setTag(localObject1);
      ((f)localObject1).PaG.setTextSize(0, com.tencent.mm.cb.a.aG(this.context, 2131165592));
      ((f)localObject1).PaF.setTextSize(0, com.tencent.mm.cb.a.aG(this.context, 2131165594));
      ((f)localObject1).PaE.setTextSize(0, com.tencent.mm.cb.a.aG(this.context, 2131165535));
      this.Qez = ((f)localObject1).PaE.getTextSize();
      ((f)localObject1).PaG.setTextColor(this.Pav[0]);
      ((f)localObject1).PaF.setTextColor(this.Pav[4]);
      ((f)localObject1).PaE.setTextColor(this.Pav[3]);
      ((f)localObject1).PaG.setShouldEllipsize(true);
      ((f)localObject1).PaF.setShouldEllipsize(false);
      ((f)localObject1).PaE.setShouldEllipsize(true);
      if (((f)localObject1).PaE.getPaint() != null) {
        com.tencent.mm.ui.ao.a(((f)localObject1).PaE.getPaint(), 0.1F);
      }
      ((f)localObject1).PaF.setGravity(5);
      paramViewGroup = paramView;
      label1036:
      localObject3 = j(localaz);
      ((f)localObject1).position = paramInt;
      ((f)localObject1).username = str;
      if ((!((d)localObject3).PaB) || (localaz.field_conversationTime == -1L)) {
        break label2357;
      }
      bool1 = true;
      label1080:
      ((f)localObject1).PaB = bool1;
      if (((d)localObject3).Qce == null) {
        ((d)localObject3).Qce = b(localaz, (int)((f)localObject1).PaG.getTextSize(), ((d)localObject3).Qcl);
      }
      if ((com.tencent.mm.model.ab.Js(localaz.field_username)) && (((d)localObject3).Qce != null))
      {
        paramView = d.QbK;
        if (d.gVo())
        {
          paramView = com.tencent.mm.storage.v.NPH;
          com.tencent.mm.storage.v.aO(((d)localObject3).Qce.toString(), paramInt, localaz.field_unReadCount);
          paramView = com.tencent.mm.plugin.brandservice.b.c.pne;
          com.tencent.mm.plugin.brandservice.b.c.t(1, "", "");
        }
      }
      if (((d)localObject3).Qcd == null) {
        ((d)localObject3).Qcd = i(localaz);
      }
      if (!((d)localObject3).Qcl) {
        break label2363;
      }
      ((f)localObject1).PaG.setTextColor(this.Pav[0]);
      label1225:
      com.tencent.mm.booter.notification.a.h.oc(((f)localObject1).PaG.getWidth());
      com.tencent.mm.booter.notification.a.h.od((int)((f)localObject1).PaG.getTextSize());
      com.tencent.mm.booter.notification.a.h.b(((f)localObject1).PaG.getPaint());
      if ((!com.tencent.mm.model.ab.Iy(str)) && (!com.tencent.mm.model.ab.IB(str))) {
        break label2384;
      }
      ((f)localObject1).PaE.setCompoundRightDrawablesWithIntrinsicBounds(2131691298);
      ((f)localObject1).PaE.setDrawRightDrawable(true);
      label1295:
      i = ((d)localObject3).Qcf;
      if (i == -1) {
        break label2407;
      }
      ((f)localObject1).PaG.setCompoundLeftDrawablesWithIntrinsicBounds(i);
      ((f)localObject1).PaG.setDrawLeftDrawable(true);
      Log.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((d)localObject3).Qcf) });
      label1355:
      if (!as.bjp(localaz.field_username)) {
        break label2441;
      }
      this.Qey.Cy(localaz.field_username);
      Object localObject4 = this.Qey.eFa();
      paramView = "";
      if (localObject4 != null) {
        paramView = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bN(((ax)localObject4).field_openImAppid, ((ax)localObject4).field_descWordingId);
      }
      if (Util.isNullOrNil(paramView)) {
        break label2427;
      }
      Object localObject2 = paramView;
      if ("3552365301".equals(((ax)localObject4).field_openImAppid)) {
        localObject2 = "@".concat(String.valueOf(paramView));
      }
      ((f)localObject1).PaE.aR((String)localObject2, 2131100666, 14);
      label1471:
      ((f)localObject1).PaE.setText(((d)localObject3).nickName);
      paramView = ((f)localObject1).PaF.getLayoutParams();
      if (((d)localObject3).Qcd.length() < 9) {
        break label2464;
      }
      if (paramView.width != this.QbW)
      {
        paramView.width = this.QbW;
        ((f)localObject1).PaF.setLayoutParams(paramView);
      }
      label1536:
      ((f)localObject1).PaF.setText(((d)localObject3).Qcd);
      ((f)localObject1).PaG.setText(((d)localObject3).Qce);
      if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 7, 0L) <= 0L) {
        break label2495;
      }
      bool1 = true;
      label1578:
      localObject2 = localaz.field_username;
      long l1 = localaz.field_conversationTime;
      localObject4 = ((d)localObject3).Qcd;
      boolean bool2 = ((f)localObject1).PaB;
      long l2 = localaz.field_flag;
      long l3 = localaz.field_flag;
      if ((((d)localObject3).nickName != null) && (((d)localObject3).nickName.length() > 0)) {
        break label2501;
      }
      paramView = "?";
      label1645:
      Log.i("MicroMsg.ConversationWithCacheAdapter", "[getView] position=%s username=%s conversationTime=%s updateTime=%s isPlacedTop=%s isTalkRoomTopPlace=%s flag=%s flagTime=%s nickname=%s unread=%s, hbMarkRed=%s", new Object[] { Integer.valueOf(paramInt), localObject2, Long.valueOf(l1), localObject4, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3 & 0xFFFFFFFF), paramView, Integer.valueOf(localaz.field_unReadCount), Integer.valueOf(localaz.field_hbMarkRed) });
      if ((bool1) && (0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 7, 0L)))
      {
        localaz.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 6, localaz.field_conversationTime));
        bg.aVF();
        com.tencent.mm.model.c.aST().a(localaz, localaz.field_username);
      }
      ((f)localObject1).QeQ.setVisibility(8);
      ((f)localObject1).QeR.setVisibility(8);
      if (!((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.forcenotify.a.b.class)).axC(str)) {
        break label2519;
      }
      ((f)localObject1).QeR.setVisibility(0);
      ((f)localObject1).QeR.setImageDrawable(ar.m(this.context, 2131690756, this.context.getResources().getColor(2131100006)));
      label1884:
      com.tencent.mm.pluginsdk.ui.a.b.c(((f)localObject1).gvv, str);
      if (this.QbL)
      {
        Log.i("MicroMsg.ConversationWithCacheAdapter", "handleShowTipCnt.");
        if ((localaz != null) && (localObject1 != null) && (localObject3 != null)) {
          break label2598;
        }
        Log.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
      }
      label1932:
      if ((!((d)localObject3).Qci) && (((d)localObject3).PaB) && (bg.aAc()))
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().g(localaz);
      }
      if ((this.Qev == null) || (!this.Qev.equals(str))) {
        break label2851;
      }
      Log.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), this.Qev });
      paramViewGroup.findViewById(2131299246).setBackground(this.Qew);
      label2031:
      if (Build.VERSION.SDK_INT >= 21) {
        paramViewGroup.findViewById(2131299246).setOnTouchListener(new View.OnTouchListener()
        {
          @TargetApi(21)
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(38483);
            paramAnonymousView.findViewById(2131299246).getBackground().setHotspot(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
            AppMethodBeat.o(38483);
            return false;
          }
        });
      }
      if ((com.tencent.mm.bi.d.jpA == null) || (!com.tencent.mm.bi.d.jpA.PZ(localaz.field_username))) {
        break label2903;
      }
      ((f)localObject1).Qcs.setVisibility(0);
      label2088:
      if ((!com.tencent.mm.model.ab.Eq(localaz.field_username)) || (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class) == null) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFJ(localaz.field_username))) {
        break label2950;
      }
      if ((!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emr()) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).iL(localaz.field_username, com.tencent.mm.model.z.aTY()))) {
        break label2916;
      }
      ((f)localObject1).QeS.setImageResource(2131689910);
      label2183:
      ((f)localObject1).QeS.setVisibility(0);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).setTextWithStatus(((f)localObject1).PaE, str, com.tencent.mm.plugin.textstatus.a.a.b.FXg);
      this.QeA.content = String.valueOf(((d)localObject3).Qce);
      this.QeA.nickName = ((d)localObject3).gCv;
      this.QeA.time = String.valueOf(((d)localObject3).Qcd);
      paramView = this.QeA;
      a.a.gKe().a(paramViewGroup, paramView.nickName, paramView.Qcc, paramView.time, paramView.content);
      paramViewGroup.setAlpha(1.0F);
      AppMethodBeat.o(38503);
      return paramViewGroup;
      label2299:
      i = 0;
      break;
      this.Qem.put(str, Integer.valueOf(paramInt));
      break label505;
      label2322:
      com.tencent.mm.kiss.a.b.aBh();
      paramView = com.tencent.mm.kiss.a.b.c((Activity)this.context, 2131493794);
      break label546;
      label2343:
      localObject1 = (f)paramView.getTag();
      paramViewGroup = paramView;
      break label1036;
      label2357:
      bool1 = false;
      break label1080;
      label2363:
      ((f)localObject1).PaG.setTextColor(this.Pav[localObject3.qcr]);
      break label1225;
      label2384:
      if (!((f)localObject1).PaE.OVM) {
        break label1295;
      }
      ((f)localObject1).PaE.setDrawRightDrawable(false);
      break label1295;
      label2407:
      ((f)localObject1).PaG.setDrawLeftDrawable(false);
      ((f)localObject1).PaG.invalidate();
      break label1355;
      label2427:
      ((f)localObject1).PaE.aR(null, 0, 0);
      break label1471;
      label2441:
      com.tencent.mm.model.ab.Iy(localaz.field_username);
      ((f)localObject1).PaE.aR(null, 0, 0);
      break label1471;
      label2464:
      if (paramView.width == this.QbV) {
        break label1536;
      }
      paramView.width = this.QbV;
      ((f)localObject1).PaF.setLayoutParams(paramView);
      break label1536;
      label2495:
      bool1 = false;
      break label1578;
      label2501:
      paramView = Character.valueOf(((d)localObject3).nickName.charAt(0));
      break label1645;
      label2519:
      ((f)localObject1).QeR.setImageDrawable(ar.m(this.context, 2131690747, this.context.getResources().getColor(2131100006)));
      if (((d)localObject3).tcb)
      {
        if (!((d)localObject3).Qcn) {
          break label1884;
        }
        ((f)localObject1).QeR.setVisibility(0);
        break label1884;
      }
      if (!((d)localObject3).Qcj) {
        break label1884;
      }
      ((f)localObject1).QeR.setVisibility(0);
      break label1884;
      label2598:
      ((f)localObject1).plf.setVisibility(4);
      ((f)localObject1).PaJ.setVisibility(4);
      if ((!com.tencent.mm.model.ab.IJ(localaz.field_username)) && (((d)localObject3).Qcm) && ((((d)localObject3).Qch == 1) || (((d)localObject3).Qch == 2) || (((d)localObject3).Qch == 3))) {}
      for (paramView = this.Pav[2];; paramView = this.Pav[3])
      {
        ((f)localObject1).PaE.setTextColor(paramView);
        if ((!((d)localObject3).Qcm) || (((d)localObject3).Qcg == 0)) {
          Log.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
        }
        paramInt = k(localaz);
        if (paramInt != 1) {
          break label2735;
        }
        ((f)localObject1).PaJ.setVisibility(0);
        break;
      }
      label2735:
      if (paramInt != 2) {
        break label1932;
      }
      paramInt = localaz.field_unReadCount;
      if (paramInt > 99)
      {
        ((f)localObject1).plf.setText("");
        ((f)localObject1).plf.setBackgroundResource(2131689753);
        ((f)localObject1).plf.setVisibility(0);
      }
      for (;;)
      {
        this.QeA.Qcc = paramInt;
        break;
        if (paramInt > 0)
        {
          ((f)localObject1).plf.setText(localaz.field_unReadCount);
          ((f)localObject1).plf.setVisibility(0);
          ((f)localObject1).plf.setBackgroundResource(com.tencent.mm.ui.tools.v.aQ(this.context, paramInt));
        }
      }
      label2851:
      if ((((d)localObject3).PaB) && (localaz.field_conversationTime != -1L))
      {
        paramViewGroup.findViewById(2131299246).setBackgroundResource(2131233332);
        break label2031;
      }
      paramViewGroup.findViewById(2131299246).setBackgroundResource(2131231935);
      break label2031;
      label2903:
      ((f)localObject1).Qcs.setVisibility(8);
      break label2088;
      label2916:
      ((f)localObject1).QeS.setImageDrawable(ar.m(this.context, 2131690566, this.context.getResources().getColor(2131100006)));
      break label2183;
      label2950:
      ((f)localObject1).QeS.setVisibility(8);
    }
  }
  
  final d j(az paramaz)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38504);
    String str2 = paramaz.field_username;
    Object localObject;
    if (this.Pax != null)
    {
      localObject = (d)this.Pax.get(str2);
      if (localObject != null)
      {
        AppMethodBeat.o(38504);
        return localObject;
      }
    }
    d locald = new d((byte)0);
    this.Qey.Cy(str2);
    as localas = this.Qey.eFa();
    if (localas != null)
    {
      locald.Qch = localas.fuQ;
      locald.Qcg = ((int)localas.gMZ);
      if (localas == null) {
        break label532;
      }
      bool1 = true;
      label111:
      locald.Qcm = bool1;
      if ((localas == null) || (!localas.amU())) {
        break label537;
      }
      bool1 = true;
      label132:
      locald.Qco = bool1;
      if ((localas == null) || (localas.fuH != 0)) {
        break label542;
      }
      bool1 = true;
      label153:
      locald.Qcn = bool1;
      locald.tcb = com.tencent.mm.model.ab.Iw(str2);
      if ((!locald.tcb) || (!locald.Qcn) || (paramaz.field_unReadCount <= 0)) {
        break label547;
      }
      bool1 = true;
      label194:
      locald.Qcl = bool1;
      locald.qcr = 0;
      if ((ahn(paramaz.field_msgType) == 34) && (paramaz.field_isSend == 0) && (!Util.isNullOrNil(paramaz.field_content)))
      {
        String str1 = paramaz.field_content;
        if ((!str2.equals("qmessage")) && (!str2.equals("floatbottle")) && (!str2.equals("officialaccounts")) && (!paramaz.oV(2097152)))
        {
          localObject = str1;
          if (!paramaz.oV(8388608)) {}
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
        if (!new p((String)localObject).jsi) {
          locald.qcr = 1;
        }
      }
      locald.gCv = aa.a(localas, str2, locald.tcb);
      a(locald, localas);
      locald.Qcd = i(paramaz);
      locald.Qcf = anD(paramaz.field_status);
      locald.Qci = com.tencent.mm.model.ab.a(paramaz);
      bg.aVF();
      locald.PaB = com.tencent.mm.model.c.aST().h(paramaz);
      if ((localas == null) || (!localas.Zx())) {
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
      locald.Qcj = bool1;
      if (this.Pax != null) {
        this.Pax.put(str2, locald);
      }
      AppMethodBeat.o(38504);
      return locald;
      locald.Qch = -1;
      locald.Qcg = -1;
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
    if (!this.QeD)
    {
      super.notifyDataSetChanged();
      this.Qem.clear();
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
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
    if ((paramMStorageEx instanceof bw))
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
      if ((!str.contains("@")) || (str.endsWith("@chatroom")) || (str.endsWith("@im.chatroom")) || (str.endsWith("@micromsg.qq.com")) || (as.bjp(str))) {}
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.Pax != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.Qeq = true;
            super.o(null, 1);
            AppMethodBeat.o(38517);
          }
        }
        else {
          this.Qep.add(str);
        }
      }
      i = paramInt;
      if (paramInt == 3) {
        i = 2;
      }
      super.o(str, i);
      AppMethodBeat.o(38517);
      return;
    }
    if ((paramMStorageEx instanceof bv))
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (!Util.isNullOrNil(str))
      {
        paramMStorageEx = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
        if ((paramMStorageEx != null) && ((int)paramMStorageEx.gMZ > 0)) {
          Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(paramMStorageEx.Zx()), Integer.valueOf(paramMStorageEx.fuH) });
        }
      }
      if (this.yJA)
      {
        AppMethodBeat.o(38517);
        return;
      }
      this.Qeo = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if ((this.Pax == null) || (!this.Pax.containsKey(str)))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.Qek != null) {
        this.Qek.add(str);
      }
    }
    AppMethodBeat.o(38517);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38497);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.PmS);
    if (!this.PmS)
    {
      AppMethodBeat.o(38497);
      return;
    }
    this.PmS = false;
    super.pause();
    if (this.plb != null) {
      this.plb.ebo();
    }
    AppMethodBeat.o(38497);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(38499);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.PmS);
    if (this.PmS)
    {
      AppMethodBeat.o(38499);
      return;
    }
    this.PmS = true;
    gUq();
    gVN();
    Log.i(this.TAG, "newcursor resume syncNow ");
    this.OzL = true;
    mY(true);
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.i.e.a("MM/dd", (Time)localObject).toString();
    String str = LocaleUtil.getApplicationLanguage();
    if ((!this.QbT.equals(localObject)) || (!this.Qet.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.QbT = ((String)localObject);
      this.Qet = str;
      if (i != 0) {
        gVp();
      }
      if ((this.QbO) && (this.Qej != null))
      {
        this.Qej.gVP();
        this.QbO = false;
        super.o(null, 1);
      }
      AppMethodBeat.o(38499);
      return;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  final class a
  {
    public int Qcc;
    public String content;
    public String nickName;
    public String time;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void gVP();
  }
  
  final class c
  {
    public View OSi = null;
    boolean QeI = false;
    boolean QeJ = false;
    boolean QeK = false;
    boolean QeL = false;
    boolean QeM = false;
    public ImageView QeN = null;
    public TextView QeO = null;
    public View QeP = null;
    public View plg = null;
    public TextView plh = null;
    String username = "";
    
    c() {}
  }
  
  final class d
  {
    public boolean PaB;
    public CharSequence Qcd;
    public CharSequence Qce;
    public int Qcf;
    public int Qcg;
    public int Qch;
    public boolean Qci;
    public boolean Qcj;
    public boolean Qcl;
    public boolean Qcm;
    public boolean Qcn;
    public boolean Qco;
    public String gCv;
    public CharSequence nickName;
    public int qcr;
    public boolean tcb;
    
    private d() {}
  }
  
  final class e
  {
    private Integer Qcq = null;
    private as contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final void Cy(String paramString)
    {
      AppMethodBeat.i(38492);
      this.talker = paramString;
      this.contact = null;
      this.Qcq = null;
      this.initialized = false;
      if (!Util.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(38492);
    }
    
    public final as eFa()
    {
      AppMethodBeat.i(38493);
      if ((this.initialized) && (this.contact == null) && (bg.aAc()))
      {
        bg.aVF();
        this.contact = com.tencent.mm.model.c.aSN().Kn(this.talker);
      }
      as localas = this.contact;
      AppMethodBeat.o(38493);
      return localas;
    }
  }
  
  public static final class f
  {
    public boolean PaB;
    public NoMeasuredTextView PaE;
    public NoMeasuredTextView PaF;
    public NoMeasuredTextView PaG;
    public View PaJ;
    public ImageView Qcs;
    public ImageView QeQ;
    public WeImageView QeR;
    public ImageView QeS;
    public i.c QeT;
    public ImageView gvv;
    public TextView plf;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */