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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.t;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
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
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cj;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import com.tencent.mm.ui.g.b;
import com.tencent.mm.ui.g.c;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  extends com.tencent.mm.ui.g<String, az>
  implements MStorageEx.IOnStorageChange
{
  boolean Ent;
  boolean KDX;
  public boolean WHe;
  MStorage.IOnStorageChange Wez;
  private float WtD;
  private float WtG;
  private float WtH;
  private ColorStateList[] WtI;
  HashMap<String, d> WtK;
  private boolean XAa;
  com.tencent.mm.pluginsdk.ui.e XAc;
  private boolean XAd;
  IListener XAg;
  public String XAi;
  private final int XAk;
  private final int XAl;
  private ColorDrawable XBA;
  ValueAnimator XBB;
  final e XBC;
  private float XBD;
  private a XBE;
  private long XBF;
  private boolean XBG;
  boolean XBH;
  private boolean XBl;
  private yx XBm;
  b XBn;
  private HashSet<String> XBo;
  private boolean XBp;
  HashMap<String, Integer> XBq;
  private HashMap<String, Integer> XBr;
  private boolean XBs;
  HashSet<String> XBt;
  boolean XBu;
  private boolean XBv;
  private boolean XBw;
  public String XBx;
  boolean XBy;
  private String XBz;
  private NoMeasuredTextView.c Xpk;
  protected List<String> jkb;
  private ListView mListView;
  private boolean mYQ;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.d snk;
  
  public j(Context paramContext, ListView paramListView, com.tencent.mm.ui.g.a parama)
  {
    super(paramContext, (short)0);
    AppMethodBeat.i(38494);
    this.jkb = null;
    this.WtI = new ColorStateList[5];
    this.XAa = true;
    this.XBl = false;
    this.snk = MMSlideDelView.getItemStatusCallBack();
    this.XBm = null;
    this.mYQ = false;
    this.WtD = -1.0F;
    this.WtG = -1.0F;
    this.WtH = -1.0F;
    this.XAd = false;
    this.XAg = null;
    this.XBn = null;
    this.WHe = false;
    this.XBp = false;
    this.XBq = new HashMap();
    this.XBr = new HashMap();
    this.XBs = false;
    this.XBu = false;
    this.XBv = false;
    this.XBw = false;
    this.Xpk = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38482);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.ci.a.fromDPToPix(j.a(j.this), paramAnonymousInt2);
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
          paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.span.l.c(j.b(j.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.ci.a.l(j.c(j.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(38482);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.XAi = "";
    this.XBx = "";
    this.XBy = true;
    this.Wez = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(38488);
        j.this.notifyDataSetChanged();
        AppMethodBeat.o(38488);
      }
    };
    this.XBC = new e();
    this.KDX = false;
    this.XBD = -1.0F;
    this.XBF = 0L;
    this.XBG = false;
    this.Ent = false;
    this.XBH = false;
    this.mListView = paramListView;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.WtI[0] = com.tencent.mm.ci.a.l(paramContext, R.e.hint_text_color);
    this.WtI[1] = com.tencent.mm.ci.a.l(paramContext, R.e.red_text_color);
    this.WtI[3] = com.tencent.mm.ci.a.l(paramContext, R.e.normal_text_color);
    this.WtI[2] = com.tencent.mm.ci.a.l(paramContext, R.e.Link);
    this.WtI[2] = com.tencent.mm.ci.a.l(paramContext, R.e.Link);
    this.WtI[4] = com.tencent.mm.ci.a.l(paramContext, R.e.hint_text_color);
    if (com.tencent.mm.ci.a.kp(paramContext))
    {
      this.XAl = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeLargerWidth);
      this.XAk = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
    }
    for (;;)
    {
      this.WtK = new HashMap();
      this.XBo = new HashSet();
      this.XBt = new HashSet();
      this.WtD = paramContext.getResources().getDimension(R.f.NormalTextSize);
      this.WtG = paramContext.getResources().getDimension(R.f.HintTextSize);
      this.WtH = paramContext.getResources().getDimension(R.f.SmallestTextSize);
      this.jkb = new ArrayList();
      this.jkb.add("qmessage");
      this.XBw = hWm();
      if (!this.XBw) {
        this.jkb.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38494);
      return;
      if (com.tencent.mm.ci.a.ko(paramContext))
      {
        this.XAl = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
        this.XAk = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
      }
      else
      {
        this.XAl = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
        this.XAk = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth);
      }
    }
  }
  
  private SparseArray<String> a(g.b<String, az> paramb, SparseArray<String> paramSparseArray, HashMap<String, az> paramHashMap)
  {
    AppMethodBeat.i(38516);
    String str = (String)paramb.object;
    int k = paramSparseArray.size();
    az localaz = (az)paramb.VTp;
    int j = paramSparseArray.size();
    int i = 0;
    label39:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d, changeType:%s", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramb.VTo) });
      switch (paramb.VTo)
      {
      case 3: 
      case 4: 
      default: 
        if (i >= 0) {
          break label427;
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
      while ((i < k) && (g((String)paramSparseArray.get(i), paramHashMap).field_flag > localaz.field_flag)) {
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
    label427:
    paramb = g(str, paramHashMap);
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
      label554:
      k = j;
      label558:
      if (k > n) {
        break label781;
      }
      if (g((String)paramSparseArray.get(k), paramHashMap).field_flag > localaz.field_flag) {
        break label682;
      }
    }
    label781:
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
        break label554;
        label682:
        k += 1;
        break label558;
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
    if ((paramd.wIg) && (paramd.jmB == null))
    {
      paramd.nickName = this.context.getString(R.l.ewS);
      AppMethodBeat.o(38505);
      return;
    }
    if (as.bvK(paramas.field_username))
    {
      paramd.nickName = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), paramd.jmB, com.tencent.mm.ci.a.aY(this.context, R.f.NormalTextSize));
      AppMethodBeat.o(38505);
      return;
    }
    paramd.nickName = com.tencent.mm.pluginsdk.ui.span.l.d(this.context, paramd.jmB, com.tencent.mm.ci.a.aY(this.context, R.f.NormalTextSize));
    AppMethodBeat.o(38505);
  }
  
  private static int aoT(String paramString)
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
  
  private CharSequence b(az paramaz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38509);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramaz.field_remitMarkRed == 1)
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.eQm));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject1);
      Log.i("MicroMsg.ConversationWithCacheAdapter", "mark remittance flag conversation: %s, flag: %s", new Object[] { paramaz.field_username, Integer.valueOf(paramaz.field_attrflag) });
    }
    while (((!Util.isNullOrNil(paramaz.field_editingMsg)) || (paramaz.field_editingQuoteMsgId != 0L)) && ((paramaz.field_atCount <= 0) || ((paramaz.field_unReadCount <= 0) && (paramaz.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.eLh));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      if (!Util.isNullOrNil(paramaz.field_editingMsg)) {
        ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, paramaz.field_editingMsg, paramInt));
      }
      paramaz = localSpannableStringBuilder.append((CharSequence)localObject1);
      AppMethodBeat.o(38509);
      return paramaz;
      if (paramaz.field_hbMarkRed == 1)
      {
        localObject1 = new SpannableStringBuilder(this.context.getString(R.l.eoT));
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        localSpannableStringBuilder.append((CharSequence)localObject1);
        Log.i("MicroMsg.ConversationWithCacheAdapter", "mark hb flag conversation: %s", new Object[] { paramaz.field_username });
      }
    }
    if (aoT(paramaz.field_msgType) == 10000)
    {
      boolean bool2 = ab.QL(paramaz.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramaz.rp(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramaz.rp(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramaz.rp(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = ab.QU(paramaz.field_username);
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
    if (aoT(paramaz.field_msgType) == 49)
    {
      localObject1 = aa.PJ(paramaz.field_digestUser);
      localObject3 = k.b.OQ(paramaz.field_content);
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
      } while (t.OV(paramaz.field_content).lpH != 19);
      if (Util.isNullOrNil((String)localObject1)) {}
      for (localObject1 = this.context.getString(R.l.app_record);; localObject1 = (String)localObject1 + ": " + this.context.getString(R.l.app_record))
      {
        paramaz.Ja((String)localObject1);
        paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject1, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
      }
    case 5: 
      localObject1 = null;
      try
      {
        paramaz = String.format(paramaz.field_digest, new Object[] { k(paramaz) });
        localObject4 = new StringBuilder();
        localObject1 = paramaz;
        if (Util.isNullOrNil(paramaz)) {
          localObject1 = this.context.getString(R.l.app_url);
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
    for (Object localObject1 = this.context.getString(R.l.app_record);; localObject1 = (String)localObject1 + ": " + this.context.getString(R.l.app_record))
    {
      paramaz.Ja((String)localObject1);
      paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38509);
      return paramaz;
    }
    localObject1 = paramaz.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      bh.beI();
      if (Util.nullAsNil((Integer)com.tencent.mm.model.c.aHp().b(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramaz = this.context.getString(R.l.settings_plugins_disable);
        AppMethodBeat.o(38509);
        return paramaz;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbU().aPi("@t.qq.com");
      if ((localObject1 != null) && (((cj)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramaz = this.context.getString(R.l.settings_plugins_disable);
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
      localObject1 = byO(paramaz.field_digest);
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
          localObject4 = byO(paramaz.field_digest.substring(paramaz.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject3;
          if (!Util.isNullOrNil((String)localObject4))
          {
            paramaz = "[" + (String)localObject4 + "]";
            if (Util.isNullOrNil((String)localObject3))
            {
              paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject3, paramInt));
              AppMethodBeat.o(38509);
              return paramaz;
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject3, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramaz);
            paramaz = localSpannableStringBuilder.append((CharSequence)localObject1);
            AppMethodBeat.o(38509);
            return paramaz;
          }
        }
      }
      localObject3 = this.context.getString(R.l.app_emoji);
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = localObject3;
        paramaz.Ja((String)localObject1);
      }
    }
    else
    {
      if (Util.isNullOrNil(paramaz.field_digest)) {
        break label1724;
      }
      if (Util.isNullOrNil(paramaz.field_digestUser)) {
        break label1713;
      }
      localObject1 = k(paramaz);
    }
    label1713:
    label1724:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramaz.field_digest, new Object[] { localObject1 });
        localObject3 = ((String)localObject1).replace('\n', ' ');
        if ((!paramaz.rp(33554432)) || ((paramaz.field_unReadCount <= 0) && (paramaz.field_unReadMuteCount <= 0))) {
          break label1755;
        }
        paramaz = new SpannableStringBuilder(this.context.getString(R.l.eTI));
        paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, paramaz.length(), 33);
        paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject3, paramInt));
        paramaz = localSpannableStringBuilder.append(paramaz);
        AppMethodBeat.o(38509);
        return paramaz;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject3;
      break;
      localObject1 = paramaz.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramaz.field_isSend, paramaz.field_username, paramaz.field_content, aoT(paramaz.field_msgType), this.context);
    }
    label1755:
    if (paramaz.field_UnReadInvite > 0)
    {
      if (paramaz.field_UnReadInvite < 4096) {}
      for (paramaz = this.context.getString(R.l.eLe, new Object[] { Integer.valueOf(paramaz.field_UnReadInvite) });; paramaz = this.context.getString(R.l.eLb))
      {
        paramaz = new SpannableStringBuilder(paramaz);
        paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, paramaz.length(), 33);
        paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject3, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
      }
    }
    if ((paramaz.field_atCount > 0) && ((paramaz.field_unReadCount > 0) || (paramaz.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramaz.field_atCount < 4096) {
        i = R.l.eLd;
      }
      for (;;)
      {
        paramaz = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, paramaz.length(), 33);
        paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject3, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
        if (com.tencent.mm.ao.g.KI(paramaz.field_username)) {
          i = R.l.eLc;
        } else {
          i = R.l.eLf;
        }
      }
    }
    if (paramaz.field_hasTodo == 1)
    {
      paramaz = new SpannableStringBuilder(this.context.getString(R.l.eUr));
      paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, paramaz.length(), 33);
      paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject3, paramInt));
      AppMethodBeat.o(38509);
      return paramaz;
    }
    if ((paramaz.rp(16777216)) && ((paramaz.field_unReadCount > 0) || (paramaz.field_unReadMuteCount > 0)))
    {
      paramaz = this.context.getString(R.l.emr);
      localObject2 = ((String)localObject3).replace(paramaz, "");
      paramaz = new SpannableStringBuilder(paramaz);
      paramaz.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), 0, paramaz.length(), 33);
      paramaz.append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject2, paramInt));
      paramaz = localSpannableStringBuilder.append(paramaz);
      AppMethodBeat.o(38509);
      return paramaz;
    }
    if (paramaz.field_remitMarkRed == 1)
    {
      localSpannableStringBuilder.append(((String)localObject3).replace(this.context.getString(R.l.eQm), ""));
      AppMethodBeat.o(38509);
      return localSpannableStringBuilder;
    }
    if (paramaz.field_hbMarkRed == 1)
    {
      localObject2 = localObject3;
      if (aoT(paramaz.field_msgType) == 436207665)
      {
        paramaz = k.b.OQ(paramaz.field_content);
        if (paramaz == null) {
          break label2942;
        }
      }
    }
    label2761:
    label2942:
    for (paramaz = ((String)localObject3).replace("[" + paramaz.lnE + "]", "");; paramaz = (az)localObject3)
    {
      localObject2 = paramaz;
      for (;;)
      {
        paramaz = localSpannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject2, paramInt));
        AppMethodBeat.o(38509);
        return paramaz;
        if ((paramBoolean) && ((paramaz.field_unReadCount > 1) || (paramaz.field_unReadMuteCount > 0)))
        {
          localObject2 = this.context.getString(R.l.eLg, new Object[] { Integer.valueOf(paramaz.field_unReadCount), localObject3 });
        }
        else
        {
          if (!ab.QL(paramaz.field_username)) {
            break label2818;
          }
          localObject2 = com.tencent.mm.plugin.biz.b.a.shp;
          localObject2 = com.tencent.mm.plugin.biz.b.a.a(paramInt, this.context, paramaz);
          if ((localObject2 != null) && (((CharSequence)localObject2).length() > 0))
          {
            AppMethodBeat.o(38509);
            return localObject2;
          }
          paramBoolean = paramaz.rp(16);
          if ((paramaz.field_unReadCount <= 1) && ((paramBoolean) || (paramaz.field_unReadCount <= 0))) {
            break label2761;
          }
          if (!paramBoolean) {
            break;
          }
          if (paramaz.rp(32))
          {
            paramaz = this.context.getString(R.l.main_conversation_biz_time_line_unread_count, new Object[] { Integer.valueOf(paramaz.field_unReadCount) });
            localObject2 = com.tencent.mm.plugin.biz.b.a.shp;
            paramaz = TextUtils.concat(new CharSequence[] { paramaz, " ", com.tencent.mm.plugin.biz.b.a.c(paramInt, this.context), com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject3, paramInt) });
            AppMethodBeat.o(38509);
            return paramaz;
          }
          localObject2 = this.context.getString(R.l.eLg, new Object[] { Integer.valueOf(paramaz.field_unReadCount), localObject3 });
        }
      }
      long l = MultiProcessMMKV.getSingleMMKV("brandService").decodeLong("BizLastMsgId");
      if (l < 0L)
      {
        localObject2 = com.tencent.mm.ao.af.bjD().ad(l, "msgId");
        if ((localObject2 != null) && (((com.tencent.mm.storage.z)localObject2).hwE()))
        {
          localObject2 = ag.Q((com.tencent.mm.storage.z)localObject2);
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
        localObject2 = this.context.getString(R.l.eLa, new Object[] { Integer.valueOf(paramaz.field_unReadCount), localObject3 });
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
          if (!paramaz.rp(32)) {
            break;
          }
          paramaz = com.tencent.mm.plugin.biz.b.a.shp;
          paramaz = TextUtils.concat(new CharSequence[] { com.tencent.mm.plugin.biz.b.a.c(paramInt, this.context), com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject3, paramInt) });
          AppMethodBeat.o(38509);
          return paramaz;
          if ((ab.QV(paramaz.field_username)) && ((paramaz.field_unReadCount > 1) || (paramaz.field_unReadMuteCount > 0)))
          {
            localObject2 = this.context.getString(R.l.eLg, new Object[] { Integer.valueOf(paramaz.field_unReadCount), localObject3 });
            break;
          }
          if (aoT(paramaz.field_msgType) != 889192497)
          {
            localObject2 = localObject3;
            if (aoT(paramaz.field_msgType) != 922746929) {
              break;
            }
          }
          paramaz = j(aoT(paramaz.field_msgType), paramaz.field_content, paramaz.field_username, paramInt);
          AppMethodBeat.o(38509);
          return paramaz;
        }
        i = 1;
      }
    }
  }
  
  private static String byO(String paramString)
  {
    AppMethodBeat.i(38511);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(paramString);
      AppMethodBeat.o(38511);
      return paramString;
    }
    AppMethodBeat.o(38511);
    return null;
  }
  
  private void ezX()
  {
    AppMethodBeat.i(38498);
    if (this.WtK == null)
    {
      AppMethodBeat.o(38498);
      return;
    }
    Iterator localIterator = this.WtK.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).XAs = null;
    }
    AppMethodBeat.o(38498);
  }
  
  private az g(String paramString, HashMap<String, az> paramHashMap)
  {
    AppMethodBeat.i(38515);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (az)paramHashMap.get(paramString);
      AppMethodBeat.o(38515);
      return paramString;
    }
    paramString = (az)ei(paramString);
    AppMethodBeat.o(38515);
    return paramString;
  }
  
  private boolean hWj()
  {
    return this.XBz != null;
  }
  
  private void hWl()
  {
    AppMethodBeat.i(38518);
    if ((this.WtK == null) || (this.XBo == null) || (this.XBo.isEmpty()))
    {
      AppMethodBeat.o(38518);
      return;
    }
    Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.XBo.size()) });
    Iterator localIterator = this.XBo.iterator();
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
        if (!this.WtK.containsKey(str1)) {
          break label360;
        }
        d locald = (d)this.WtK.get(str1);
        j = i;
        if (locald == null) {
          break label360;
        }
        this.XBC.Jm(str1);
        bool1 = ab.Lj(str1);
        as localas = this.XBC.fqR();
        if (localas != null)
        {
          String str2 = aa.a(localas, str1, bool1);
          Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.jmB });
          j = i;
          if (str2 != null)
          {
            j = i;
            if (!str2.equals(locald.jmB))
            {
              locald.jmB = str2;
              a(locald, localas);
              j = 1;
            }
          }
          boolean bool2 = localas.aeg();
          if (localas.hDj == 0)
          {
            bool1 = true;
            label269:
            if ((locald.XAy == bool2) && (bool1 == locald.XAC)) {
              break label360;
            }
            locald.XAy = bool2;
            locald.XAC = bool1;
            locald.XAD = localas.asV();
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
      this.XBo.clear();
      AppMethodBeat.o(38518);
      return;
    }
  }
  
  private static boolean hWm()
  {
    AppMethodBeat.i(290549);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEF, false);
    Log.i("MicroMsg.ConversationWithCacheAdapter", "isShowAppBrandNotifyMsgEntry: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(290549);
    return bool;
  }
  
  private CharSequence i(az paramaz)
  {
    AppMethodBeat.i(38495);
    if (paramaz.field_status == 1)
    {
      paramaz = this.context.getString(R.l.eLv);
      AppMethodBeat.o(38495);
      return paramaz;
    }
    if (paramaz.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38495);
      return "";
    }
    paramaz = com.tencent.mm.pluginsdk.j.f.d(this.context, paramaz.field_conversationTime, true);
    AppMethodBeat.o(38495);
    return paramaz;
  }
  
  static int j(az paramaz)
  {
    AppMethodBeat.i(290543);
    if ((paramaz != null) && (paramaz.rp(128)))
    {
      if (paramaz.rp(256))
      {
        AppMethodBeat.o(290543);
        return 1;
      }
      AppMethodBeat.o(290543);
      return 0;
    }
    if ((paramaz == null) || (paramaz.field_unReadCount <= 0))
    {
      if (((paramaz.rp(8388608)) || (paramaz.rp(2097152))) && (paramaz.field_unReadMuteCount > 0))
      {
        AppMethodBeat.o(290543);
        return 1;
      }
      AppMethodBeat.o(290543);
      return 0;
    }
    if (ab.QL(paramaz.field_username))
    {
      if ((!paramaz.rp(16)) && (!paramaz.rp(64)))
      {
        AppMethodBeat.o(290543);
        return 0;
      }
      AppMethodBeat.o(290543);
      return 1;
    }
    if (ab.QQ(paramaz.field_username))
    {
      bh.beI();
      if (!com.tencent.mm.model.c.aHp().getBoolean(ar.a.VmF, true))
      {
        AppMethodBeat.o(290543);
        return 1;
      }
    }
    if (ab.QU(paramaz.field_username))
    {
      bh.beI();
      if (!com.tencent.mm.model.c.aHp().getBoolean(ar.a.VmG, true))
      {
        AppMethodBeat.o(290543);
        return 1;
      }
    }
    bh.beI();
    as localas = com.tencent.mm.model.c.bbL().RG(paramaz.field_username);
    if ((localas != null) && ((int)localas.jxt != 0))
    {
      if ((localas.aeg()) && (localas.asV()))
      {
        AppMethodBeat.o(290543);
        return 1;
      }
      if ((ab.Lj(paramaz.field_username)) && (localas.hDj == 0))
      {
        AppMethodBeat.o(290543);
        return 1;
      }
    }
    if (ab.QV(paramaz.field_username))
    {
      AppMethodBeat.o(290543);
      return 1;
    }
    AppMethodBeat.o(290543);
    return 2;
  }
  
  private CharSequence j(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(290545);
    Object localObject2 = new dit();
    Object localObject1;
    if (paramInt1 == 889192497) {
      localObject1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).aUf(paramString1);
    }
    for (;;)
    {
      try
      {
        if (((dit)localObject1).Ezu.size() <= 0) {
          continue;
        }
        localObject1 = (diu)((dit)localObject1).Ezu.getLast();
        paramString1 = ((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).parseDisplayTemplate(((diu)localObject1).lqH, paramString2);
        paramString2 = new SpannableString(paramString1.result);
        localObject2 = com.tencent.mm.model.z.bcZ();
        if ((!((diu)localObject1).fLi.equals(localObject2)) && (((diu)localObject1).TQk.equals(localObject2)) && (((diu)localObject1).TQl == 0) && (!paramString1.GKx.isEmpty()))
        {
          localObject1 = new BoldForegroundColorSpan(this.context.getResources().getColor(R.e.FG_0));
          localObject2 = this.context.getString(R.l.pat_action_string);
          int j = paramString1.result.indexOf((String)localObject2, ((Integer)((Pair)paramString1.GKx.get(0)).second).intValue());
          int i = ((String)localObject2).length() + j;
          paramInt1 = i;
          if (i > paramString2.length()) {
            paramInt1 = paramString2.length();
          }
          paramString2.setSpan(localObject1, j, paramInt1, 17);
        }
        paramString1 = com.tencent.mm.pluginsdk.ui.span.l.d(this.context, paramString2, paramInt2);
        AppMethodBeat.o(290545);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramString1, "", new Object[0]);
        AppMethodBeat.o(290545);
      }
      localObject1 = localObject2;
      if (paramInt1 == 922746929)
      {
        paramString1 = k.b.OQ(paramString1);
        localObject1 = localObject2;
        if (paramString1 != null) {
          localObject1 = ((com.tencent.mm.plugin.patmsg.a.a)paramString1.ar(com.tencent.mm.plugin.patmsg.a.a.class)).GKw;
        }
      }
    }
    return "";
  }
  
  private static String k(az paramaz)
  {
    AppMethodBeat.i(38510);
    if ((paramaz.field_isSend == 0) && (ab.Lj(paramaz.field_username)))
    {
      paramaz = aa.aL(paramaz.field_digestUser, paramaz.field_username);
      AppMethodBeat.o(38510);
      return paramaz;
    }
    paramaz = aa.PJ(paramaz.field_digestUser);
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
    if ((this.XBz != null) && (!ar.hIH()))
    {
      Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      AppMethodBeat.o(38500);
      return;
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.XBz = paramString;
    Object localObject = (f)paramView.getTag();
    int j = paramView.getContext().getResources().getColor(R.e.FG_3);
    Resources localResources = paramView.getContext().getResources();
    int i;
    if ((localObject != null) && (((f)localObject).WtO))
    {
      i = R.e.BG_3;
      i = localResources.getColor(i);
      if (!ar.hIH()) {
        break label343;
      }
      localResources = paramView.getContext().getResources();
      if ((localObject == null) || (!((f)localObject).WtO)) {
        break label335;
      }
      i = R.e.click_top_item;
      label181:
      i = localResources.getColor(i);
    }
    label335:
    label343:
    for (;;)
    {
      this.XBA = new ColorDrawable(au.A(j, i));
      paramView.setBackground(this.XBA);
      if (ar.hIH()) {
        notifyDataSetChanged();
      }
      if (ab.QV(paramString))
      {
        paramView = (az)asW(paramInt);
        localObject = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.g.class);
        com.tencent.mm.kernel.h.aHE();
        ((com.tencent.mm.plugin.appbrand.service.g)localObject).acp(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.b.getUin())));
        ((com.tencent.mm.plugin.appbrand.service.g)localObject).a(new com.tencent.mm.plugin.appbrand.service.g.a(paramView.field_unReadCount, paramInt + 1));
      }
      paramView = com.tencent.mm.ui.report.b.XLO;
      com.tencent.mm.ui.report.b.N(paramString, ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Oi(paramString));
      AppMethodBeat.o(38500);
      return;
      i = R.e.BG_2;
      break;
      i = R.e.dkj;
      break label181;
    }
  }
  
  public final SparseArray<String>[] a(HashSet<g.b<String, az>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(38514);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0) || (!com.tencent.mm.kernel.h.aHB()))
    {
      if (paramArrayOfSparseArray == null) {}
      for (paramHashSet = "null";; paramHashSet = Integer.valueOf(paramArrayOfSparseArray.length))
      {
        Log.i("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion oldPosistion:%s, accHasReady:%s", new Object[] { paramHashSet, Boolean.valueOf(com.tencent.mm.kernel.h.aHB()) });
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
      if ((localObject3 != null) && (((g.b)localObject3).VTo != 5) && (!((ArrayList)localObject1).contains(((g.b)localObject3).object)))
      {
        Log.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((g.b)localObject3).object);
        ((ArrayList)localObject1).add(((g.b)localObject3).object);
      }
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "refreshChangedConversation searchArray:%s, %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()), ((ArrayList)localObject1).toString() });
    localObject2 = new HashMap();
    bh.beI();
    Object localObject3 = com.tencent.mm.model.c.bbR().b((ArrayList)localObject1, this.jkb, com.tencent.mm.o.a.jxD);
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
      localObject4 = (g.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((g.b)localObject4).VTo != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((g.b)localObject4).object).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((g.b)localObject4).object) == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((g.b)localObject4).VTp = ((HashMap)localObject2).get(((g.b)localObject4).object);
            break;
          }
        }
        ((g.b)localObject4).VTp = null;
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
        if (((g.b)localObject2).VTo != 5) {
          ((HashMap)localObject1).put(((g.b)localObject2).object, ((g.b)localObject2).VTp);
        }
      }
    }
    AppMethodBeat.o(38514);
    return paramArrayOfSparseArray;
  }
  
  public final void awV(int paramInt)
  {
    AppMethodBeat.i(38501);
    if (!hWj())
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
        j.e(j.this);
        AppMethodBeat.o(38485);
      }
    }, paramInt);
    AppMethodBeat.o(38501);
  }
  
  public final void awW(int paramInt)
  {
    AppMethodBeat.i(38521);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(38521);
      return;
    }
    try
    {
      az localaz = (az)asW(paramInt);
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
      com.tencent.mm.pluginsdk.ui.a.b.hjf().gJ(localObject.field_username);
      AppMethodBeat.o(38521);
    }
  }
  
  public final com.tencent.mm.ui.g<String, az>.c b(com.tencent.mm.storagebase.a.d paramd)
  {
    AppMethodBeat.i(290546);
    paramd = new g.c(this, paramd, (byte)0);
    AppMethodBeat.o(290546);
    return paramd;
  }
  
  public final ArrayList<az> bD(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(38513);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    bh.beI();
    paramArrayList = com.tencent.mm.model.c.bbR().b(paramArrayList, this.jkb, com.tencent.mm.o.a.jxD);
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
    if (this.WtK != null)
    {
      this.WtK.clear();
      this.XBu = true;
    }
    AppMethodBeat.o(38508);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38503);
    this.XBE = new a((byte)0);
    az localaz = (az)asW(paramInt);
    String str = localaz.field_username;
    this.XBC.Jm(str);
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    label485:
    Object localObject4;
    label526:
    label1119:
    boolean bool1;
    if (this.XBq.containsKey(str))
    {
      if (paramInt != ((Integer)this.XBq.get(str)).intValue())
      {
        localObject2 = hFG();
        paramViewGroup = hFH();
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
              ((StringBuffer)localObject1).append(((az)((Map.Entry)localObject3).getValue()).field_username);
            }
            ((StringBuffer)localObject1).append("]");
          }
          ((StringBuffer)localObject1).append("\n");
        }
        localObject1 = ((StringBuffer)localObject1).toString();
        localObject2 = this.XBq.toString();
        if (paramViewGroup == null) {
          break label2982;
        }
        i = paramViewGroup.size();
        Log.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject1, str, Integer.valueOf(paramInt), localObject2, Integer.valueOf(i) });
        if (!this.XBp)
        {
          com.tencent.mm.plugin.fts.a.e.Sy(20);
          this.XBp = true;
        }
        if (System.currentTimeMillis() - this.XBF > 3600000L)
        {
          super.u(null, 1);
          this.XBF = System.currentTimeMillis();
        }
      }
      if (paramView != null) {
        break label3026;
      }
      localObject1 = new f();
      if (!com.tencent.mm.ci.a.kq(this.context)) {
        break label3005;
      }
      com.tencent.mm.kiss.a.b.aIK();
      paramView = com.tencent.mm.kiss.a.b.d((Activity)this.context, R.i.efI);
      paramView.setTag(R.h.touch_loc, new int[2]);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38489);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if ((j.g(j.this) == null) || (j.g(j.this).getOnItemClickListener() == null))
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
          if ((!j.this.WHe) && (!ar.hIH()))
          {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38489);
            return;
          }
          localObject = (j.f)paramAnonymousView.getTag();
          int i = ((j.f)localObject).position;
          int j = j.g(j.this).getHeaderViewsCount();
          j.g(j.this).getOnItemClickListener().onItemClick(j.g(j.this), paramAnonymousView, i + j, j.this.getItemId(((j.f)localObject).position));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if ((j.g(j.this) == null) || (j.g(j.this).getOnItemLongClickListener() == null))
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
          if (!j.this.WHe)
          {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(38490);
            return false;
          }
          localObject = (j.f)paramAnonymousView.getTag();
          int i = ((j.f)localObject).position;
          int j = j.g(j.this).getHeaderViewsCount();
          boolean bool = j.g(j.this).getOnItemLongClickListener().onItemLongClick(j.g(j.this), paramAnonymousView, i + j, j.this.getItemId(((j.f)localObject).position));
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38490);
          return bool;
        }
      });
      ((f)localObject1).iZG = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      com.tencent.mm.pluginsdk.ui.a.b.c(((f)localObject1).iZG, str);
      paramViewGroup = (com.tencent.mm.pluginsdk.ui.a)((f)localObject1).iZG.getDrawable();
      if (this.XAc != null) {
        this.XAc.a(paramViewGroup);
      }
      ((f)localObject1).iZG.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(38491);
          this.XBL.iZG.getViewTreeObserver().removeOnPreDrawListener(this);
          int i = this.XBL.iZG.getWidth();
          int j = aw.aZ(j.h(j.this), R.f.NormalAvatarSize);
          if (i != j)
          {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.XBL.iZG.getLayoutParams();
            localLayoutParams.width = j;
            localLayoutParams.height = j;
            this.XBL.iZG.setLayoutParams(localLayoutParams);
            Log.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", new Object[] { Integer.valueOf(this.XBL.iZG.getWidth()) });
            if (!j.i(j.this))
            {
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1055L, 4L, 1L, false);
              Log.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
              j.j(j.this);
            }
          }
          AppMethodBeat.o(38491);
          return true;
        }
      });
      ((f)localObject1).WtR = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
      ((f)localObject1).WtR.setLayoutCallback(this.Xpk);
      ((f)localObject1).WtS = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
      ((f)localObject1).XBU = ((ImageView)paramView.findViewById(R.h.dKP));
      ((f)localObject1).WtT = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
      ((f)localObject1).sno = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
      ((f)localObject1).XBV = ((WeImageView)paramView.findViewById(R.h.dIR));
      ((f)localObject1).WtW = paramView.findViewById(R.h.dse);
      ((f)localObject1).XAH = ((ImageView)paramView.findViewById(R.h.dLB));
      ((f)localObject1).XBW = ((ImageView)paramView.findViewById(R.h.dMZ));
      ((f)localObject1).XBX = ((ImageView)paramView.findViewById(R.h.dSX));
      ((f)localObject1).sno.setBackgroundResource(w.lE(this.context));
      ((f)localObject1).sno.setTextSize(0, com.tencent.mm.ci.a.aZ(this.context, R.f.unReadCountTextSize) * com.tencent.mm.ci.a.km(this.context));
      ((f)localObject1).XBY = new c();
      paramView.setTag(localObject1);
      ((f)localObject1).WtT.setTextSize(0, com.tencent.mm.ci.a.aY(this.context, R.f.SmallerTextSize));
      ((f)localObject1).WtS.setTextSize(0, com.tencent.mm.ci.a.aY(this.context, R.f.SmallestTextSize));
      ((f)localObject1).WtR.setTextSize(0, com.tencent.mm.ci.a.aY(this.context, R.f.NormalTextSize));
      this.XBD = ((f)localObject1).WtR.getTextSize();
      ((f)localObject1).WtT.setTextColor(this.WtI[0]);
      ((f)localObject1).WtS.setTextColor(this.WtI[4]);
      ((f)localObject1).WtR.setTextColor(this.WtI[3]);
      ((f)localObject1).WtT.setShouldEllipsize(true);
      ((f)localObject1).WtS.setShouldEllipsize(false);
      ((f)localObject1).WtR.setShouldEllipsize(true);
      if (((f)localObject1).WtR.getPaint() != null) {
        ar.a(((f)localObject1).WtR.getPaint(), 0.1F);
      }
      ((f)localObject1).WtS.setGravity(5);
      paramViewGroup = paramView;
      label1031:
      localObject4 = localaz.field_username;
      if (this.WtK != null)
      {
        localObject2 = (d)this.WtK.get(localObject4);
        if (localObject2 != null) {
          break label3824;
        }
      }
      localObject3 = new d((byte)0);
      this.XBC.Jm((String)localObject4);
      as localas = this.XBC.fqR();
      if (localas == null) {
        break label3040;
      }
      ((d)localObject3).XAw = localas.hDp;
      ((d)localObject3).XAv = ((int)localas.jxt);
      if (localas == null) {
        break label3055;
      }
      bool1 = true;
      label1127:
      ((d)localObject3).XAB = bool1;
      if ((localas == null) || (!localas.asV())) {
        break label3061;
      }
      bool1 = true;
      label1150:
      ((d)localObject3).XAD = bool1;
      if ((localas == null) || (localas.hDj != 0)) {
        break label3067;
      }
      bool1 = true;
      label1173:
      ((d)localObject3).XAC = bool1;
      ((d)localObject3).wIg = ab.PO((String)localObject4);
      if ((!((d)localObject3).wIg) || (!((d)localObject3).XAC) || (localaz.field_unReadCount <= 0)) {
        break label3073;
      }
      bool1 = true;
      label1217:
      ((d)localObject3).XAA = bool1;
      ((d)localObject3).viewType = 0;
      if ((aoT(localaz.field_msgType) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)))
      {
        localObject2 = localaz.field_content;
        if ((!localaz.field_username.equals("officialaccounts")) && (!localaz.rp(2097152)))
        {
          paramView = (View)localObject2;
          if (!localaz.rp(8388608)) {}
        }
        else
        {
          String[] arrayOfString = ((String)localObject2).split(":");
          paramView = (View)localObject2;
          if (arrayOfString != null)
          {
            paramView = (View)localObject2;
            if (arrayOfString.length > 3) {
              paramView = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
            }
          }
        }
        if (!new com.tencent.mm.modelvoice.p(paramView).mhL) {
          ((d)localObject3).viewType = 1;
        }
      }
      ((d)localObject3).jmB = aa.a(localas, (String)localObject4, ((d)localObject3).wIg);
      a((d)localObject3, localas);
      ((d)localObject3).XAs = i(localaz);
      switch (localaz.field_status)
      {
      case 3: 
      case 4: 
      case 6: 
      case 7: 
      default: 
        i = -1;
        label1495:
        ((d)localObject3).XAu = i;
        ((d)localObject3).XAx = ab.a(localaz);
        bh.beI();
        ((d)localObject3).WtO = com.tencent.mm.model.c.bbR().h(localaz);
        if ((localas != null) && (localas.aeg()))
        {
          bool1 = true;
          label1547:
          ((d)localObject3).XAy = bool1;
          localObject2 = localObject3;
          if (this.WtK != null)
          {
            this.WtK.put(localObject4, localObject3);
            localObject2 = localObject3;
          }
        }
        break;
      }
    }
    label1617:
    label1883:
    label3040:
    label3055:
    label3824:
    for (;;)
    {
      ((f)localObject1).position = paramInt;
      ((f)localObject1).username = str;
      if ((((d)localObject2).WtO) && (localaz.field_conversationTime != -1L))
      {
        bool1 = true;
        ((f)localObject1).WtO = bool1;
        if (((d)localObject2).XAt == null) {
          ((d)localObject2).XAt = b(localaz, (int)((f)localObject1).WtT.getTextSize(), ((d)localObject2).XAA);
        }
        if ((ab.QL(localaz.field_username)) && (((d)localObject2).XAt != null))
        {
          paramView = d.XzX;
          if (d.hVV())
          {
            paramView = d.XzX;
            d.a(this.mListView, this, true, false);
            paramView = com.tencent.mm.plugin.brandservice.b.d.swc;
            com.tencent.mm.plugin.brandservice.b.d.t(1, "", "");
          }
        }
        if (((d)localObject2).XAs == null) {
          ((d)localObject2).XAs = i(localaz);
        }
        if (!((d)localObject2).XAA) {
          break label3119;
        }
        ((f)localObject1).WtT.setTextColor(this.WtI[0]);
        com.tencent.mm.booter.notification.a.h.qr(((f)localObject1).WtT.getWidth());
        com.tencent.mm.booter.notification.a.h.qs((int)((f)localObject1).WtT.getTextSize());
        com.tencent.mm.booter.notification.a.h.b(((f)localObject1).WtT.getPaint());
        if ((!ab.PQ(str)) && (!ab.PT(str))) {
          break label3257;
        }
        ((f)localObject1).WtR.setCompoundRightDrawablesWithIntrinsicBounds(R.k.open_im_main_logo);
        ((f)localObject1).WtR.setDrawRightDrawable(true);
        i = ((d)localObject2).XAu;
        if (i == -1) {
          break label3280;
        }
        ((f)localObject1).WtT.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        ((f)localObject1).WtT.setDrawLeftDrawable(true);
        Log.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { str, Integer.valueOf(((d)localObject2).XAu) });
        if (!as.bvK(localaz.field_username)) {
          break label3314;
        }
        this.XBC.Jm(localaz.field_username);
        localObject4 = this.XBC.fqR();
        paramView = "";
        if (localObject4 != null) {
          paramView = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bR(((ax)localObject4).field_openImAppid, ((ax)localObject4).field_descWordingId);
        }
        if (Util.isNullOrNil(paramView)) {
          break label3300;
        }
        localObject3 = paramView;
        if ("3552365301".equals(((ax)localObject4).field_openImAppid)) {
          localObject3 = "@".concat(String.valueOf(paramView));
        }
        ((f)localObject1).WtR.aT((String)localObject3, R.e.dkA, 14);
        ((f)localObject1).WtR.setText(((d)localObject2).nickName);
        paramView = ((f)localObject1).WtS.getLayoutParams();
        if (((d)localObject2).XAs.length() < 9) {
          break label3337;
        }
        if (paramView.width != this.XAl)
        {
          paramView.width = this.XAl;
          ((f)localObject1).WtS.setLayoutParams(paramView);
        }
        ((f)localObject1).WtS.setText(((d)localObject2).XAs);
        ((f)localObject1).WtT.setText(((d)localObject2).XAt);
        if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 7, 0L) <= 0L) {
          break label3368;
        }
        bool1 = true;
        localObject3 = localaz.field_username;
        long l1 = localaz.field_conversationTime;
        localObject4 = ((d)localObject2).XAs;
        boolean bool2 = ((f)localObject1).WtO;
        long l2 = localaz.field_flag;
        long l3 = localaz.field_flag;
        if ((((d)localObject2).nickName != null) && (((d)localObject2).nickName.length() > 0)) {
          break label3374;
        }
        paramView = "?";
        label2173:
        Log.i("MicroMsg.ConversationWithCacheAdapter", "[getView] position=%s username=%s conversationTime=%s updateTime=%s isPlacedTop=%s isTalkRoomTopPlace=%s flag=%s flagTime=%s nickname=%s unread=%s, hbMarkRed=%s, parentRef=%s", new Object[] { Integer.valueOf(paramInt), localObject3, Long.valueOf(l1), localObject4, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3 & 0xFFFFFFFF), paramView, Integer.valueOf(localaz.field_unReadCount), Integer.valueOf(localaz.field_hbMarkRed), localaz.field_parentRef });
        if ((bool1) && (0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 7, 0L)))
        {
          localaz.EC(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 6, localaz.field_conversationTime));
          bh.beI();
          com.tencent.mm.model.c.bbR().a(localaz, localaz.field_username);
        }
        ((f)localObject1).XBU.setVisibility(8);
        ((f)localObject1).XBV.setVisibility(8);
        ((f)localObject1).XBV.setImageDrawable(au.o(this.context, R.k.icons_outlined_bellring_off, this.context.getResources().getColor(R.e.arrow_color)));
        if (!((d)localObject2).wIg) {
          break label3392;
        }
        if (((d)localObject2).XAC) {
          ((f)localObject1).XBV.setVisibility(0);
        }
        label2418:
        com.tencent.mm.pluginsdk.ui.a.b.c(((f)localObject1).iZG, str);
        if (this.XAa)
        {
          Log.i("MicroMsg.ConversationWithCacheAdapter", "handleShowTipCnt.");
          if ((localaz != null) && (localObject1 != null) && (localObject2 != null)) {
            break label3412;
          }
          Log.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        if ((!((d)localObject2).XAx) && (((d)localObject2).WtO) && (bh.aHB()))
        {
          bh.beI();
          com.tencent.mm.model.c.bbR().g(localaz);
        }
        if ((this.XBz == null) || (!this.XBz.equals(str))) {
          break label3691;
        }
        Log.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), this.XBz });
        paramViewGroup.findViewById(R.h.dCL).setBackground(this.XBA);
        if (Build.VERSION.SDK_INT >= 21) {
          paramViewGroup.findViewById(R.h.dCL).setOnTouchListener(new View.OnTouchListener()
          {
            @TargetApi(21)
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(38483);
              paramAnonymousView.findViewById(R.h.dCL).getBackground().setHotspot(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
              AppMethodBeat.o(38483);
              return false;
            }
          });
        }
        if ((com.tencent.mm.bk.d.meV == null) || (!com.tencent.mm.bk.d.meV.Xw(localaz.field_username))) {
          break label3743;
        }
        ((f)localObject1).XAH.setVisibility(0);
        if ((!ab.Lj(localaz.field_username)) || (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class) == null) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPV(localaz.field_username))) {
          break label3790;
        }
        if ((!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).eWf()) || (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).iW(localaz.field_username, com.tencent.mm.model.z.bcZ()))) {
          break label3756;
        }
        ((f)localObject1).XBW.setImageResource(R.k.chatlist_multitalk_highlight_icon);
        ((f)localObject1).XBW.setVisibility(0);
        ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).setTextWithStatus(((f)localObject1).WtR, str, com.tencent.mm.plugin.textstatus.a.a.b.Mzz);
        if ((!ab.Lj(localaz.field_username)) || (com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class) == null) || (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Oi(localaz.field_username).size() <= 0)) {
          break label3803;
        }
        paramView = r.VYx;
        if (!r.hHp()) {
          break label3803;
        }
        ((f)localObject1).XBX.setVisibility(0);
        ((f)localObject1).XBX.setImageResource(R.k.icons_filled_room_live);
        ((f)localObject1).XBX.setAlpha(0.3F);
        this.XBE.content = String.valueOf(((d)localObject2).XAt);
        this.XBE.nickName = ((d)localObject2).jmB;
        this.XBE.time = String.valueOf(((d)localObject2).XAs);
        paramView = this.XBE;
        a.a.hJg().a(paramViewGroup, paramView.nickName, paramView.XAr, paramView.time, paramView.content);
        paramViewGroup.setAlpha(1.0F);
        paramViewGroup.setTag(R.h.dCJ, Integer.valueOf(paramInt));
        paramViewGroup.setTag(R.h.dCI, localaz);
        paramView = e.XzZ;
        kotlin.g.b.p.k(str, "talker");
        kotlin.g.b.p.k(paramViewGroup, "itemView");
        paramView = (e.b)e.XzY.get(str);
        if (paramView == null) {
          break label3816;
        }
        com.tencent.mm.view.f.a(paramViewGroup, paramView);
      }
      for (;;)
      {
        for (;;)
        {
          AppMethodBeat.o(38503);
          return paramViewGroup;
          i = 0;
          break;
          this.XBq.put(str, Integer.valueOf(paramInt));
          break label485;
          com.tencent.mm.kiss.a.b.aIK();
          paramView = com.tencent.mm.kiss.a.b.d((Activity)this.context, R.i.efH);
          break label526;
          localObject1 = (f)paramView.getTag();
          paramViewGroup = paramView;
          break label1031;
          ((d)localObject3).XAw = -1;
          ((d)localObject3).XAv = -1;
          break label1119;
          bool1 = false;
          break label1127;
          label3061:
          bool1 = false;
          break label1150;
          label3067:
          bool1 = false;
          break label1173;
          bool1 = false;
          break label1217;
          i = -1;
          break label1495;
          i = R.k.msg_state_sending;
          break label1495;
          i = -1;
          break label1495;
          i = R.k.msg_state_failed;
          break label1495;
          bool1 = false;
          break label1547;
          bool1 = false;
          break label1617;
          if ((((d)localObject2).viewType == 1) && (localaz.field_isSend == 0))
          {
            paramView = this.context.getString(R.l.app_voice);
            i = ((d)localObject2).XAt.toString().lastIndexOf(paramView);
            if (i < 0) {}
          }
          try
          {
            localObject3 = new SpannableStringBuilder(((d)localObject2).XAt);
            ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.red_text_color)), i, paramView.length() + i, 33);
            ((d)localObject2).XAt = ((CharSequence)localObject3);
            ((f)localObject1).WtT.setTextColor(this.WtI[0]);
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", paramView, null, new Object[0]);
            }
          }
        }
        if (!((f)localObject1).WtR.WoY) {
          break label1823;
        }
        ((f)localObject1).WtR.setDrawRightDrawable(false);
        break label1823;
        ((f)localObject1).WtT.setDrawLeftDrawable(false);
        ((f)localObject1).WtT.invalidate();
        break label1883;
        ((f)localObject1).WtR.aT(null, 0, 0);
        break label1999;
        label3314:
        ab.PQ(localaz.field_username);
        ((f)localObject1).WtR.aT(null, 0, 0);
        break label1999;
        if (paramView.width == this.XAk) {
          break label2064;
        }
        paramView.width = this.XAk;
        ((f)localObject1).WtS.setLayoutParams(paramView);
        break label2064;
        bool1 = false;
        break label2106;
        paramView = Character.valueOf(((d)localObject2).nickName.charAt(0));
        break label2173;
        if (!((d)localObject2).XAy) {
          break label2418;
        }
        ((f)localObject1).XBV.setVisibility(0);
        break label2418;
        ((f)localObject1).sno.setVisibility(4);
        ((f)localObject1).WtW.setVisibility(4);
        if ((!ab.Qb(localaz.field_username)) && (((d)localObject2).XAB) && ((((d)localObject2).XAw == 1) || (((d)localObject2).XAw == 2) || (((d)localObject2).XAw == 3))) {}
        for (paramView = this.WtI[2];; paramView = this.WtI[3])
        {
          ((f)localObject1).WtR.setTextColor(paramView);
          if ((!((d)localObject2).XAB) || (((d)localObject2).XAv == 0)) {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
          }
          i = j(localaz);
          if (i != 1) {
            break label3560;
          }
          ((f)localObject1).WtW.setVisibility(0);
          paramView = com.tencent.mm.ui.report.b.XLO;
          com.tencent.mm.ui.report.b.n(localaz);
          break;
        }
        if (i != 2) {
          break label2466;
        }
        i = localaz.field_unReadCount;
        if (i > 99)
        {
          ((f)localObject1).sno.setText("");
          ((f)localObject1).sno.setBackgroundResource(R.k.badge_count_more);
          ((f)localObject1).sno.setVisibility(0);
        }
        for (;;)
        {
          this.XBE.XAr = i;
          paramView = com.tencent.mm.ui.report.b.XLO;
          com.tencent.mm.ui.report.b.n(localaz);
          break;
          if (i > 0)
          {
            ((f)localObject1).sno.setText(localaz.field_unReadCount);
            ((f)localObject1).sno.setVisibility(0);
            ((f)localObject1).sno.setBackgroundResource(w.bj(this.context, i));
          }
        }
        if ((((d)localObject2).WtO) && (localaz.field_conversationTime != -1L))
        {
          paramViewGroup.findViewById(R.h.dCL).setBackgroundResource(R.g.list_item_top_selector);
          break label2565;
        }
        paramViewGroup.findViewById(R.h.dCL).setBackgroundResource(R.g.dno);
        break label2565;
        ((f)localObject1).XAH.setVisibility(8);
        break label2622;
        ((f)localObject1).XBW.setImageDrawable(au.o(this.context, R.k.icons_filled_groupcall, this.context.getResources().getColor(R.e.arrow_color)));
        break label2717;
        ((f)localObject1).XBW.setVisibility(8);
        break label2726;
        ((f)localObject1).XBX.setVisibility(8);
        break label2839;
        com.tencent.mm.view.f.a(paramViewGroup, null);
      }
    }
  }
  
  public final boolean hBP()
  {
    AppMethodBeat.i(38519);
    boolean bool = super.hBP();
    AppMethodBeat.o(38519);
    return bool;
  }
  
  public final com.tencent.mm.storagebase.a.d hFF()
  {
    AppMethodBeat.i(38512);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    bh.beI();
    com.tencent.mm.storagebase.a.d locald = (com.tencent.mm.storagebase.a.d)com.tencent.mm.model.c.bbR().d(this.jkb, com.tencent.mm.o.a.jxD, true);
    AppMethodBeat.o(38512);
    return locald;
  }
  
  public final void hUj()
  {
    boolean bool1 = true;
    AppMethodBeat.i(38496);
    if (this.jkb == null) {
      this.jkb = new ArrayList();
    }
    this.jkb.clear();
    int i;
    if ((com.tencent.mm.model.z.bdd() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = com.tencent.mm.model.z.bdw();
      if ((i == 0) || (!bool2)) {
        break label198;
      }
      label59:
      if (bool1 != this.XBv)
      {
        if (!bool1) {
          break label203;
        }
        bh.beI();
        onNotifyChange(5, (MStorageEx)com.tencent.mm.model.c.bbR(), "floatbottle");
        label89:
        this.XBv = bool1;
      }
      if (this.XBv) {
        this.jkb.add("floatbottle");
      }
      this.jkb.add("qmessage");
      bool1 = hWm();
      if (bool1 != this.XBw)
      {
        if (!bool1) {
          break label224;
        }
        bh.beI();
        onNotifyChange(2, (MStorageEx)com.tencent.mm.model.c.bbR(), "appbrand_notify_message");
      }
    }
    for (;;)
    {
      this.XBw = bool1;
      if (!this.XBw) {
        this.jkb.add("appbrand_notify_message");
      }
      AppMethodBeat.o(38496);
      return;
      i = 0;
      break;
      label198:
      bool1 = false;
      break label59;
      label203:
      bh.beI();
      onNotifyChange(2, (MStorageEx)com.tencent.mm.model.c.bbR(), "floatbottle");
      break label89;
      label224:
      bh.beI();
      onNotifyChange(5, (MStorageEx)com.tencent.mm.model.c.bbR(), "appbrand_notify_message");
    }
  }
  
  public final void hWk()
  {
    AppMethodBeat.i(38502);
    super.u(null, 1);
    AppMethodBeat.o(38502);
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(38522);
    if (!this.XBH)
    {
      super.notifyDataSetChanged();
      this.XBq.clear();
    }
    Log.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap %s", new Object[] { Boolean.valueOf(this.XBH) });
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
      if ((!str.contains("@")) || (str.endsWith("@chatroom")) || (str.endsWith("@im.chatroom")) || (str.endsWith("@micromsg.qq.com")) || (as.bvK(str))) {}
      for (int i = 0; i != 0; i = 1)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.WtK != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.XBu = true;
            super.u(null, 1);
            AppMethodBeat.o(38517);
          }
        }
        else {
          this.XBt.add(str);
        }
      }
      i = paramInt;
      if (paramInt == 3) {
        i = 2;
      }
      super.u(str, i);
      AppMethodBeat.o(38517);
      return;
    }
    if ((paramMStorageEx instanceof bv))
    {
      Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", new Object[] { Integer.valueOf(paramInt), paramObject, Boolean.valueOf(this.Ent) });
      if (this.Ent)
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (!Util.isNullOrNil(str))
      {
        paramMStorageEx = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str);
        if ((paramMStorageEx != null) && ((int)paramMStorageEx.jxt > 0)) {
          Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", new Object[] { Boolean.valueOf(paramMStorageEx.aeg()), Integer.valueOf(paramMStorageEx.hDj) });
        }
      }
      this.XBs = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if ((this.WtK == null) || (!this.WtK.containsKey(str)))
      {
        AppMethodBeat.o(38517);
        return;
      }
      if (this.XBo != null) {
        this.XBo.add(str);
      }
    }
    AppMethodBeat.o(38517);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38497);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.WHe);
    if (!this.WHe)
    {
      AppMethodBeat.o(38497);
      return;
    }
    this.WHe = false;
    super.pause();
    if (this.snk != null) {
      this.snk.eKm();
    }
    AppMethodBeat.o(38497);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(38499);
    Log.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.WHe);
    if (this.WHe)
    {
      AppMethodBeat.o(38499);
      return;
    }
    this.WHe = true;
    hUj();
    hWl();
    super.hFM();
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.j.e.a("MM/dd", (Time)localObject).toString();
    String str = LocaleUtil.getApplicationLanguage();
    if ((!this.XAi.equals(localObject)) || (!this.XBx.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.XAi = ((String)localObject);
      this.XBx = str;
      if (i != 0) {
        ezX();
      }
      if ((this.XAd) && (this.XBn != null))
      {
        this.XBn.hWn();
        this.XAd = false;
        super.u(null, 1);
      }
      AppMethodBeat.o(38499);
      return;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.sni = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.snh = paramg;
  }
  
  final class a
  {
    public int XAr;
    public String content;
    public String nickName;
    public String time;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void hWn();
  }
  
  final class c
  {
    public View Wlv = null;
    boolean XBM = false;
    boolean XBN = false;
    boolean XBO = false;
    boolean XBP = false;
    boolean XBQ = false;
    public ImageView XBR = null;
    public TextView XBS = null;
    public View XBT = null;
    public View snp = null;
    public TextView snq = null;
    String username = "";
    
    c() {}
  }
  
  final class d
  {
    public boolean WtO;
    public boolean XAA;
    public boolean XAB;
    public boolean XAC;
    public boolean XAD;
    public CharSequence XAs;
    public CharSequence XAt;
    public int XAu;
    public int XAv;
    public int XAw;
    public boolean XAx;
    public boolean XAy;
    public String jmB;
    public CharSequence nickName;
    public int viewType;
    public boolean wIg;
    
    private d() {}
  }
  
  final class e
  {
    private Integer XAF = null;
    private as contact = null;
    private boolean initialized = false;
    private String talker = null;
    
    public e() {}
    
    public final void Jm(String paramString)
    {
      AppMethodBeat.i(38492);
      this.talker = paramString;
      this.contact = null;
      this.XAF = null;
      this.initialized = false;
      if (!Util.isNullOrNil(paramString)) {
        this.initialized = true;
      }
      AppMethodBeat.o(38492);
    }
    
    public final as fqR()
    {
      AppMethodBeat.i(38493);
      if ((this.initialized) && (this.contact == null) && (bh.aHB()))
      {
        bh.beI();
        this.contact = com.tencent.mm.model.c.bbL().RG(this.talker);
      }
      as localas = this.contact;
      AppMethodBeat.o(38493);
      return localas;
    }
  }
  
  public static final class f
  {
    public boolean WtO;
    public NoMeasuredTextView WtR;
    public NoMeasuredTextView WtS;
    public NoMeasuredTextView WtT;
    public View WtW;
    public ImageView XAH;
    public ImageView XBU;
    public WeImageView XBV;
    public ImageView XBW;
    public ImageView XBX;
    public j.c XBY;
    public ImageView iZG;
    public int position;
    public TextView sno;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */