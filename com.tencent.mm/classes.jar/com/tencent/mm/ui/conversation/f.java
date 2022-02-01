package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.drawable.Drawable;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bj.b;
import com.tencent.mm.bj.g;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.cc;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cj;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.w;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class f
  extends v<az>
  implements MStorageEx.IOnStorageChange
{
  private static long XAn = 2000L;
  boolean KDX;
  private float WtD;
  protected float WtG;
  private float WtH;
  private ColorStateList[] WtI;
  private HashMap<String, d> WtK;
  private boolean WtL;
  private boolean WtM;
  private boolean XAa;
  private f XAb;
  private com.tencent.mm.pluginsdk.ui.e XAc;
  private boolean XAd;
  private boolean XAe;
  private f.c XAf;
  private IListener XAg;
  private b XAh;
  public String XAi;
  final e XAj;
  private final int XAk;
  private final int XAl;
  private a XAm;
  private boolean XAo;
  private MTimerHandler XAp;
  protected List<String> jkb;
  private String mUI;
  private boolean mYQ;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.f snj;
  protected MMSlideDelView.d snk;
  
  public f(Context paramContext, v.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(38304);
    this.jkb = null;
    this.WtI = new ColorStateList[5];
    this.XAa = true;
    this.mYQ = false;
    this.snk = MMSlideDelView.getItemStatusCallBack();
    this.WtD = -1.0F;
    this.WtG = -1.0F;
    this.WtH = -1.0F;
    this.WtL = false;
    this.WtM = false;
    this.XAd = false;
    this.XAe = false;
    this.XAg = null;
    this.XAh = null;
    this.XAi = "";
    this.XAj = new e();
    this.KDX = false;
    this.XAo = false;
    this.XAp = new MTimerHandler(bh.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(38300);
        if (f.a(f.this)) {
          f.b(f.this);
        }
        AppMethodBeat.o(38300);
        return false;
      }
    }, false);
    super.a(parama);
    this.WtI[0] = com.tencent.mm.ci.a.l(paramContext, R.e.hint_text_color);
    this.WtI[1] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_unread);
    this.WtI[3] = com.tencent.mm.ci.a.l(paramContext, R.e.normal_text_color);
    this.WtI[2] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_three);
    this.WtI[2] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_three);
    this.WtI[4] = com.tencent.mm.ci.a.l(paramContext, R.e.light_text_color);
    this.WtK = new HashMap();
    if (com.tencent.mm.ci.a.kp(paramContext))
    {
      this.XAl = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeLargerWidth);
      this.XAk = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
    }
    for (;;)
    {
      this.WtD = com.tencent.mm.ci.a.aY(paramContext, R.f.NormalTextSize);
      this.WtG = com.tencent.mm.ci.a.aY(paramContext, R.f.HintTextSize);
      this.WtH = com.tencent.mm.ci.a.aY(paramContext, R.f.SmallestTextSize);
      AppMethodBeat.o(38304);
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
  
  private CharSequence a(az paramaz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38315);
    if ((!Util.isNullOrNil(paramaz.field_editingMsg)) && ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.eLh));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, paramaz.field_editingMsg, paramInt));
      AppMethodBeat.o(38315);
      return localObject1;
    }
    Object localObject1 = paramaz.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramaz = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38315);
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
        AppMethodBeat.o(38315);
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
        AppMethodBeat.o(38315);
        return paramaz;
      }
    }
    String str1;
    if ((paramaz.field_msgType != null) && ((paramaz.field_msgType.equals("47")) || (paramaz.field_msgType.equals("1048625"))))
    {
      localObject1 = byO(paramaz.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramaz = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38315);
        return paramaz;
      }
      localObject1 = str1;
      if (paramaz.field_digest != null)
      {
        localObject1 = str1;
        if (paramaz.field_digest.contains(":"))
        {
          str1 = paramaz.field_digest.substring(0, paramaz.field_digest.indexOf(":"));
          String str2 = byO(paramaz.field_digest.substring(paramaz.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramaz = "[" + str2 + "]";
            if (Util.isNullOrNil(str1))
            {
              AppMethodBeat.o(38315);
              return paramaz;
            }
            paramaz = str1 + ": " + paramaz;
            AppMethodBeat.o(38315);
            return paramaz;
          }
        }
      }
      str1 = this.context.getString(R.l.app_emoji);
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramaz.Ja((String)localObject1);
      }
    }
    else
    {
      if (Util.isNullOrNil(paramaz.field_digest)) {
        break label794;
      }
      if (Util.isNullOrNil(paramaz.field_digestUser)) {
        break label783;
      }
      if ((paramaz.field_isSend != 0) || (!ab.Lj(paramaz.field_username))) {
        break label771;
      }
      localObject1 = aa.aL(paramaz.field_digestUser, paramaz.field_username);
    }
    label771:
    label783:
    label794:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramaz.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)) {
          break label825;
        }
        paramaz = new SpannableStringBuilder(this.context.getString(R.l.eLd));
        paramaz.setSpan(new ForegroundColorSpan(-5569532), 0, paramaz.length(), 33);
        paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.d(this.context, str1, paramInt));
        AppMethodBeat.o(38315);
        return paramaz;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = aa.PJ(paramaz.field_digestUser);
      continue;
      localObject1 = paramaz.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramaz.field_isSend, paramaz.field_username, paramaz.field_content, aoT(paramaz.field_msgType), this.context);
    }
    label825:
    if ((paramBoolean) && (paramaz.field_unReadCount > 1)) {
      localObject2 = this.context.getString(R.l.eLg, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramaz = com.tencent.mm.pluginsdk.ui.span.l.d(this.context, (CharSequence)localObject2, paramInt);
      AppMethodBeat.o(38315);
      return paramaz;
      localObject2 = str1;
      if (paramaz.field_unReadCount > 0)
      {
        localObject2 = str1;
        if (ab.QL(paramaz.field_parentRef))
        {
          localObject2 = str1;
          if (!(this.context instanceof NewBizConversationUI)) {
            localObject2 = this.context.getString(R.l.eLg, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
          }
        }
      }
    }
  }
  
  private static int aoT(String paramString)
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
  
  private static String byO(String paramString)
  {
    AppMethodBeat.i(38316);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(paramString);
      AppMethodBeat.o(38316);
      return paramString;
    }
    AppMethodBeat.o(38316);
    return null;
  }
  
  private void ezX()
  {
    AppMethodBeat.i(38308);
    if (this.WtK == null)
    {
      AppMethodBeat.o(38308);
      return;
    }
    Iterator localIterator = this.WtK.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).XAs = null;
    }
    AppMethodBeat.o(38308);
  }
  
  private void hVW()
  {
    AppMethodBeat.i(38320);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38301);
        if (!bh.aHB())
        {
          f.c(f.this).stopTimer();
          Log.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38301);
          return;
        }
        long l = Util.nowMilliSecond();
        f.d(f.this);
        l = Util.milliSecondsToNow(l) * 3L;
        Log.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(f.hVX()), Boolean.valueOf(f.a(f.this)) });
        f.Wh((l + f.hVX()) / 2L);
        f.e(f.this);
        f.c(f.this).startTimer(f.hVX());
        AppMethodBeat.o(38301);
      }
    });
    AppMethodBeat.o(38320);
  }
  
  private CharSequence i(az paramaz)
  {
    AppMethodBeat.i(38305);
    if (paramaz.field_status == 1)
    {
      paramaz = this.context.getString(R.l.eLv);
      AppMethodBeat.o(38305);
      return paramaz;
    }
    if (paramaz.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38305);
      return "";
    }
    paramaz = com.tencent.mm.pluginsdk.j.f.d(this.context, paramaz.field_conversationTime, true);
    AppMethodBeat.o(38305);
    return paramaz;
  }
  
  public az a(az paramaz, Cursor paramCursor)
  {
    AppMethodBeat.i(292357);
    if (this.mYQ)
    {
      if ((paramCursor.getString(0) != null) && (paramCursor.getString(0).equals("1")))
      {
        localObject = paramaz;
        if (paramaz == null) {
          localObject = new az();
        }
        ((az)localObject).Ja("");
        ((az)localObject).Jb("");
        ((az)localObject).convertFrom(paramCursor);
        AppMethodBeat.o(292357);
        return localObject;
      }
      if (paramCursor.getString(0).equals("2"))
      {
        bh.beI();
        as localas = com.tencent.mm.model.c.bbL().bwc(as.s(paramCursor));
        localObject = localas;
        if (localas == null)
        {
          localObject = new as();
          ((as)localObject).convertFrom(paramCursor);
          bh.beI();
          com.tencent.mm.model.c.bbL().as((as)localObject);
        }
        paramCursor = paramaz;
        if (paramaz == null) {
          paramCursor = new az();
        }
        paramCursor.setStatus(2);
        paramCursor.EB(-1L);
        paramCursor.pJ(1);
        paramCursor.setContent(this.context.getString(R.l.eFV));
        paramCursor.setUsername(((ax)localObject).field_username);
        paramCursor.pH(0);
        paramCursor.IZ(Integer.toString(1));
        paramCursor.Ja("");
        paramCursor.Jb("");
        AppMethodBeat.o(292357);
        return paramCursor;
      }
    }
    Object localObject = paramaz;
    if (paramaz == null) {
      localObject = new az();
    }
    ((az)localObject).Ja("");
    ((az)localObject).Jb("");
    ((az)localObject).convertFrom(paramCursor);
    AppMethodBeat.o(292357);
    return localObject;
  }
  
  protected void a(az paramaz, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.snj = paramf;
  }
  
  protected void a(String paramString, g paramg) {}
  
  public void atr()
  {
    AppMethodBeat.i(38311);
    Log.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.mYQ) });
    if (this.mYQ)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = bh.beI().lqS.a(ab.lsA, this.jkb, this.mUI);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.jkb != null) && (this.jkb.size() > 0)) {
        localArrayList1.addAll(this.jkb);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!ab.Lj(str)) {
            localArrayList2.add(str);
          }
          Log.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(str)));
        }
        if (this.XAb == null) {}
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = bh.beI().lqT.b(this.mUI, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        v(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.mUI != null) {
        hK().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38311);
      return;
      bh.beI();
      v(com.tencent.mm.model.c.bbR().d(this.jkb, com.tencent.mm.o.a.jxD, false));
    }
  }
  
  public final void ats()
  {
    AppMethodBeat.i(38306);
    atr();
    AppMethodBeat.o(38306);
  }
  
  protected final String bAm(String paramString)
  {
    AppMethodBeat.i(292356);
    paramString = (d)this.WtK.get(paramString);
    if ((paramString != null) && (paramString.nickName != null))
    {
      paramString = paramString.nickName.toString();
      AppMethodBeat.o(292356);
      return paramString;
    }
    AppMethodBeat.o(292356);
    return "";
  }
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38312);
    az localaz = (az)getItem(paramInt);
    String str = localaz.field_username;
    paramViewGroup = this.XAj;
    paramViewGroup.talker = str;
    paramViewGroup.contact = null;
    paramViewGroup.XAF = null;
    paramViewGroup.initialized = false;
    if (!Util.isNullOrNil(str)) {
      paramViewGroup.initialized = true;
    }
    this.XAm = new a((byte)0);
    label162:
    Object localObject1;
    label472:
    Object localObject2;
    as localas;
    label579:
    boolean bool;
    label587:
    label610:
    label633:
    int i;
    label677:
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new g();
      if (com.tencent.mm.ci.a.ko(this.context))
      {
        paramView = View.inflate(this.context, R.i.efG, null);
        paramViewGroup.iZG = ((ImageView)paramView.findViewById(R.h.avatar_iv));
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI)) && (!(this.context instanceof ServiceNotifyConversationUI))) {
          break label1928;
        }
        a.b.d(paramViewGroup.iZG, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.iZG.getDrawable();
        if (this.XAc != null) {
          this.XAc.a((e.a)localObject1);
        }
        paramViewGroup.WtR = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
        paramViewGroup.XAG = ((NoMeasuredTextView)paramView.findViewById(R.h.source_tv));
        paramViewGroup.WtS = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
        paramViewGroup.WtT = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
        paramViewGroup.sno = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
        paramViewGroup.sno.setBackgroundResource(w.lE(this.context));
        paramViewGroup.WtU = ((ImageView)paramView.findViewById(R.h.dIR));
        paramViewGroup.WtW = paramView.findViewById(R.h.dse);
        paramViewGroup.WtV = ((ImageView)paramView.findViewById(R.h.dWs));
        paramViewGroup.XAH = ((ImageView)paramView.findViewById(R.h.dLB));
        paramView.setTag(paramViewGroup);
        paramViewGroup.WtT.setTextSize(0, this.WtG);
        paramViewGroup.WtS.setTextSize(0, this.WtH);
        paramViewGroup.WtR.setTextSize(0, this.WtD);
        paramViewGroup.XAG.setTextSize(0, this.WtG);
        paramViewGroup.WtT.setTextColor(this.WtI[0]);
        paramViewGroup.WtS.setTextColor(this.WtI[4]);
        paramViewGroup.WtR.setTextColor(this.WtI[3]);
        paramViewGroup.XAG.setTextColor(this.WtI[0]);
        paramViewGroup.WtT.setShouldEllipsize(true);
        paramViewGroup.WtS.setShouldEllipsize(false);
        paramViewGroup.WtR.setShouldEllipsize(true);
        paramViewGroup.XAG.setShouldEllipsize(true);
        paramViewGroup.WtS.setGravity(5);
        localObject1 = (d)this.WtK.get(str);
        if (localObject1 != null) {
          break label2711;
        }
        localObject2 = new d((byte)0);
        localObject1 = this.XAj;
        if ((((e)localObject1).initialized) && (((e)localObject1).contact == null))
        {
          bh.beI();
          ((e)localObject1).contact = com.tencent.mm.model.c.bbL().RG(((e)localObject1).talker);
        }
        localas = ((e)localObject1).contact;
        if (localas == null) {
          break label1951;
        }
        ((d)localObject2).XAw = localas.hDp;
        ((d)localObject2).XAv = ((int)localas.jxt);
        if (localas == null) {
          break label1966;
        }
        bool = true;
        ((d)localObject2).XAB = bool;
        if ((localas == null) || (!localas.asV())) {
          break label1972;
        }
        bool = true;
        ((d)localObject2).XAD = bool;
        if ((localas == null) || (localas.hDj != 0)) {
          break label1978;
        }
        bool = true;
        ((d)localObject2).XAC = bool;
        ((d)localObject2).wIg = ab.Lj(str);
        if ((!((d)localObject2).wIg) || (!((d)localObject2).XAC) || (localaz.field_unReadCount <= 0)) {
          break label1984;
        }
        bool = true;
        ((d)localObject2).XAA = bool;
        ((d)localObject2).viewType = 0;
        i = aoT(localaz.field_msgType);
        if ((i == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)))
        {
          localObject3 = localaz.field_content;
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
          if (!new p((String)localObject1).mhL) {
            ((d)localObject2).viewType = 1;
          }
        }
        if (i == 285212721)
        {
          localObject1 = localaz.field_content;
          long l = localaz.field_lastSeq;
          com.tencent.e.h.ZvG.d(new f.3(this, (String)localObject1), "tmplPreload");
        }
        localObject1 = aa.a(localas, str, ((d)localObject2).wIg);
        if ((!((d)localObject2).wIg) || (localObject1 != null)) {
          break label1990;
        }
        ((d)localObject2).nickName = this.context.getString(R.l.ewS);
        label941:
        ((d)localObject2).XAs = i(localaz);
        ((d)localObject2).XAt = a(localaz, (int)paramViewGroup.WtT.getTextSize(), ((d)localObject2).XAA);
        ((d)localObject2).XAE = localaz.field_attrflag;
        switch (localaz.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label1031:
          ((d)localObject2).XAu = i;
          ((d)localObject2).XAx = ab.a(localaz);
          bh.beI();
          ((d)localObject2).WtO = com.tencent.mm.model.c.bbR().h(localaz);
          if ((localas != null) && (localas.aeg()))
          {
            bool = true;
            label1083:
            ((d)localObject2).XAy = bool;
            ((d)localObject2).XAz = LocaleUtil.isChineseAppLang();
            this.WtK.put(str, localObject2);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    label1165:
    label2326:
    label2711:
    for (;;)
    {
      if (((d)localObject1).XAs == null) {
        ((d)localObject1).XAs = i(localaz);
      }
      if ((((d)localObject1).XAA) || (ab.QL(localaz.field_parentRef)))
      {
        paramViewGroup.WtT.setTextColor(this.WtI[0]);
        com.tencent.mm.booter.notification.a.h.qr(paramViewGroup.WtT.getWidth());
        com.tencent.mm.booter.notification.a.h.qs((int)paramViewGroup.WtT.getTextSize());
        com.tencent.mm.booter.notification.a.h.b(paramViewGroup.WtT.getPaint());
        if (!str.toLowerCase().endsWith("@t.qq.com")) {
          break label2078;
        }
        paramViewGroup.WtR.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
        paramViewGroup.WtR.setDrawRightDrawable(true);
        label1228:
        i = ((d)localObject1).XAu;
        if (i == -1) {
          break label2089;
        }
        paramViewGroup.WtT.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        paramViewGroup.WtT.setDrawLeftDrawable(true);
        label1258:
        paramViewGroup.XAG.setVisibility(8);
        localObject2 = paramViewGroup.WtS.getLayoutParams();
        if (((d)localObject1).XAs.length() < 9) {
          break label2100;
        }
        if (((ViewGroup.LayoutParams)localObject2).width != this.XAl)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.XAl;
          paramViewGroup.WtS.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        label1321:
        Log.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
        paramViewGroup.WtS.setText(((d)localObject1).XAs);
        paramViewGroup.WtT.setText(((d)localObject1).XAt);
        if ((!((d)localObject1).wIg) || (!((d)localObject1).XAC)) {
          break label2133;
        }
        paramViewGroup.WtU.setVisibility(0);
        label1393:
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI)) && (!(this.context instanceof ServiceNotifyConversationUI))) {
          break label2164;
        }
        a.b.d(paramViewGroup.iZG, str);
        label1432:
        if (this.XAa)
        {
          if ((localaz != null) && (paramViewGroup != null) && (localObject1 != null)) {
            break label2176;
          }
          Log.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        label1462:
        if ((!((d)localObject1).XAx) && (((d)localObject1).WtO) && (bh.aHB()))
        {
          bh.beI();
          com.tencent.mm.model.c.bbR().g(localaz);
        }
        if ((!(this.context instanceof NewBizConversationUI)) || (!((d)localObject1).WtO) || (localaz.field_conversationTime == -1L)) {
          break label2598;
        }
        localObject2 = this.context.getResources().getDrawable(R.g.biz_timeline_star_icon);
        i = (int)paramViewGroup.WtR.getTextSize();
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1);
        localObject3 = new SpannableString("@");
        ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
        paramViewGroup.WtR.setText(TextUtils.concat(new CharSequence[] { ((d)localObject1).nickName, " ", localObject3 }));
        label1633:
        paramView.findViewById(R.h.dCL).setBackgroundResource(R.g.comm_list_item_selector);
        label1646:
        com.tencent.mm.by.c.hok();
        localObject2 = new yx();
        ((yx)localObject2).fYg.fYi = true;
        EventCenter.instance.publish((IEvent)localObject2);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 7, 0L)) && (!localaz.field_username.equals(((yx)localObject2).fYh.fYk)))
        {
          localaz.EC(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 6, localaz.field_conversationTime));
          bh.beI();
          com.tencent.mm.model.c.bbR().a(localaz, localaz.field_username);
        }
        if ((g.meT != null) && (g.meT.Xt(localaz.field_username))) {
          break label2646;
        }
        paramViewGroup.WtV.setVisibility(8);
        label1777:
        if ((com.tencent.mm.bk.d.meV == null) || (!com.tencent.mm.bk.d.meV.Xw(localaz.field_username))) {
          break label2699;
        }
        paramViewGroup.XAH.setVisibility(0);
      }
      for (;;)
      {
        this.XAm.content = String.valueOf(((d)localObject1).XAt);
        this.XAm.nickName = String.valueOf(((d)localObject1).nickName);
        this.XAm.time = String.valueOf(((d)localObject1).XAs);
        localObject2 = this.XAm;
        a.a.hJg().a(paramView, ((a)localObject2).nickName, ((a)localObject2).XAr, ((a)localObject2).time, ((a)localObject2).content);
        a(str, paramViewGroup);
        a(localaz, ((d)localObject1).WtO, paramInt, false);
        AppMethodBeat.o(38312);
        return paramView;
        paramView = View.inflate(this.context, R.i.efF, null);
        break;
        a.b.c(paramViewGroup.iZG, str);
        break label162;
        paramViewGroup = (g)paramView.getTag();
        break label472;
        label1951:
        ((d)localObject2).XAw = -1;
        ((d)localObject2).XAv = -1;
        break label579;
        label1966:
        bool = false;
        break label587;
        label1972:
        bool = false;
        break label610;
        label1978:
        bool = false;
        break label633;
        label1984:
        bool = false;
        break label677;
        label1990:
        ((d)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.l.b(this.context, aa.a(localas, str, ((d)localObject2).wIg), paramViewGroup.WtR.getTextSize());
        break label941;
        i = -1;
        break label1031;
        i = R.k.msg_state_sending;
        break label1031;
        i = -1;
        break label1031;
        i = R.k.msg_state_failed;
        break label1031;
        bool = false;
        break label1083;
        paramViewGroup.WtT.setTextColor(this.WtI[localObject1.viewType]);
        break label1165;
        label2078:
        paramViewGroup.WtR.setDrawRightDrawable(false);
        break label1228;
        label2089:
        paramViewGroup.WtT.setDrawLeftDrawable(false);
        break label1258;
        label2100:
        if (((ViewGroup.LayoutParams)localObject2).width == this.XAk) {
          break label1321;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.XAk;
        paramViewGroup.WtS.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1321;
        label2133:
        if (((d)localObject1).XAy)
        {
          paramViewGroup.WtU.setVisibility(0);
          break label1393;
        }
        paramViewGroup.WtU.setVisibility(8);
        break label1393;
        label2164:
        a.b.c(paramViewGroup.iZG, str);
        break label1432;
        paramViewGroup.sno.setVisibility(4);
        paramViewGroup.WtW.setVisibility(4);
        if (ab.QL(localaz.field_username))
        {
          localObject2 = paramViewGroup.WtW;
          if (localaz.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            paramViewGroup.WtR.setTextColor(this.WtI[3]);
            break;
          }
        }
        localObject3 = paramViewGroup.WtR;
        if ((((d)localObject1).XAB) && (((d)localObject1).XAw == 1)) {}
        for (localObject2 = this.WtI[2];; localObject2 = this.WtI[3])
        {
          ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
          if ((((d)localObject1).XAB) && (((d)localObject1).XAv != 0)) {
            break label2326;
          }
          Log.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (ab.QL(localaz.field_parentRef))
        {
          if (((this.context instanceof NewBizConversationUI)) || ((this.context instanceof ServiceNotifyConversationUI))) {
            break label1462;
          }
          localObject2 = paramViewGroup.WtW;
          if (localaz.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).XAy) && (((d)localObject1).XAD))
        {
          localObject2 = paramViewGroup.WtW;
          if (localaz.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).wIg) && (((d)localObject1).XAC))
        {
          localObject2 = paramViewGroup.WtW;
          if (localaz.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        i = localaz.field_unReadCount;
        if (i > 99)
        {
          paramViewGroup.sno.setText("");
          paramViewGroup.sno.setBackgroundResource(R.k.badge_count_more);
          paramViewGroup.sno.setVisibility(0);
        }
        for (;;)
        {
          this.XAm.XAr = i;
          break;
          if (i > 0)
          {
            paramViewGroup.sno.setText(localaz.field_unReadCount);
            paramViewGroup.sno.setBackgroundResource(w.bj(this.context, i));
            paramViewGroup.sno.setVisibility(0);
          }
        }
        label2598:
        paramViewGroup.WtR.setText(((d)localObject1).nickName);
        if ((!((d)localObject1).WtO) || (localaz.field_conversationTime == -1L)) {
          break label1633;
        }
        paramView.findViewById(R.h.dCL).setBackgroundResource(R.g.comm_item_highlight_selector);
        break label1646;
        label2646:
        paramViewGroup.WtV.setVisibility(0);
        if (localaz.field_username.equals(((yx)localObject2).fYh.fYk))
        {
          paramViewGroup.WtV.setImageResource(R.k.talk_room_mic_speaking);
          break label1777;
        }
        paramViewGroup.WtV.setImageResource(R.k.talk_room_mic_idle);
        break label1777;
        paramViewGroup.XAH.setVisibility(8);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38314);
    this.XAp.stopTimer();
    this.XAh = null;
    this.XAf = null;
    if (this.WtK != null)
    {
      this.WtK.clear();
      this.WtK = null;
    }
    eKd();
    hFC();
    detach();
    AppMethodBeat.o(38314);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(38317);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(38317);
      return;
    }
    onNotifyChange((String)paramObject, null);
    AppMethodBeat.o(38317);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(38318);
    Log.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.WtL), Boolean.valueOf(this.WtM), paramString });
    if ((!Util.isNullOrNil(paramString)) && (this.WtK != null)) {
      this.WtK.remove(paramString);
    }
    if (this.WtL)
    {
      Log.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.XAo), Boolean.valueOf(this.XAp.stopped()) });
      this.XAo = true;
      if (this.XAp.stopped()) {
        hVW();
      }
      AppMethodBeat.o(38318);
      return;
    }
    this.WtM = true;
    AppMethodBeat.o(38318);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38307);
    if (this.snk != null) {
      this.snk.eKm();
    }
    this.WtL = false;
    AppMethodBeat.o(38307);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38309);
    Log.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.WtL), Boolean.valueOf(this.XAd), Boolean.valueOf(this.WtM), Boolean.valueOf(this.XAe) });
    this.WtL = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.j.e.a("MM/dd", (Time)localObject).toString();
    if (!this.XAi.equals(localObject)) {}
    for (;;)
    {
      this.XAi = ((String)localObject);
      if (i != 0) {
        ezX();
      }
      if ((this.XAd) && (this.XAh != null)) {
        this.XAd = false;
      }
      if ((this.WtM) || (this.XAe))
      {
        super.onNotifyChange(null, null);
        this.WtM = false;
        this.XAe = false;
      }
      AppMethodBeat.o(38309);
      return;
      i = 0;
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
  
  public static abstract interface b {}
  
  final class d
  {
    public boolean WtO;
    public boolean XAA;
    public boolean XAB;
    public boolean XAC;
    public boolean XAD;
    public int XAE;
    public CharSequence XAs;
    public CharSequence XAt;
    public int XAu;
    public int XAv;
    public int XAw;
    public boolean XAx;
    public boolean XAy;
    public boolean XAz;
    public CharSequence nickName;
    public int viewType;
    public boolean wIg;
    
    private d() {}
  }
  
  final class e
  {
    Integer XAF = null;
    as contact = null;
    boolean initialized = false;
    String talker = null;
    
    public e() {}
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public NoMeasuredTextView WtR;
    public NoMeasuredTextView WtS;
    public NoMeasuredTextView WtT;
    public ImageView WtU;
    public ImageView WtV;
    public View WtW;
    public NoMeasuredTextView XAG;
    public ImageView XAH;
    public ImageView iZG;
    public TextView sno;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */