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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.b;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a.b;
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
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.tools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends s<az>
  implements MStorageEx.IOnStorageChange
{
  private static long QbY = 2000L;
  boolean EqF;
  private float Paq;
  protected float Pat;
  private float Pau;
  private ColorStateList[] Pav;
  HashMap<String, d> Pax;
  private boolean Pay;
  private boolean Paz;
  private boolean QbL;
  private f QbM;
  private com.tencent.mm.pluginsdk.ui.e QbN;
  private boolean QbO;
  private boolean QbP;
  private c QbQ;
  private IListener QbR;
  private b QbS;
  public String QbT;
  final e QbU;
  private final int QbV;
  private final int QbW;
  private a QbX;
  private boolean QbZ;
  private MTimerHandler Qca;
  protected List<String> gzY;
  private String kdi;
  private boolean khr;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.f pla;
  protected MMSlideDelView.d plb;
  
  public e(Context paramContext, s.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(38304);
    this.gzY = null;
    this.Pav = new ColorStateList[5];
    this.QbL = true;
    this.khr = false;
    this.plb = MMSlideDelView.getItemStatusCallBack();
    this.Paq = -1.0F;
    this.Pat = -1.0F;
    this.Pau = -1.0F;
    this.Pay = false;
    this.Paz = false;
    this.QbO = false;
    this.QbP = false;
    this.QbR = null;
    this.QbS = null;
    this.QbT = "";
    this.QbU = new e();
    this.EqF = false;
    this.QbZ = false;
    this.Qca = new MTimerHandler(bg.aAk().getLooper(), new MTimerHandler.CallBack()
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
    this.Pav[0] = com.tencent.mm.cb.a.m(paramContext, 2131100594);
    this.Pav[1] = com.tencent.mm.cb.a.m(paramContext, 2131100813);
    this.Pav[3] = com.tencent.mm.cb.a.m(paramContext, 2131100904);
    this.Pav[2] = com.tencent.mm.cb.a.m(paramContext, 2131100810);
    this.Pav[2] = com.tencent.mm.cb.a.m(paramContext, 2131100810);
    this.Pav[4] = com.tencent.mm.cb.a.m(paramContext, 2131100681);
    this.Pax = new HashMap();
    if (com.tencent.mm.cb.a.jl(paramContext))
    {
      this.QbW = paramContext.getResources().getDimensionPixelSize(2131165250);
      this.QbV = paramContext.getResources().getDimensionPixelSize(2131165251);
    }
    for (;;)
    {
      this.Paq = com.tencent.mm.cb.a.aG(paramContext, 2131165535);
      this.Pat = com.tencent.mm.cb.a.aG(paramContext, 2131165482);
      this.Pau = com.tencent.mm.cb.a.aG(paramContext, 2131165594);
      AppMethodBeat.o(38304);
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
  
  private CharSequence a(az paramaz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38315);
    if ((!Util.isNullOrNil(paramaz.field_editingMsg)) && ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131762834));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, paramaz.field_editingMsg, paramInt));
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
      bg.aVF();
      if (Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramaz = this.context.getString(2131765538);
        AppMethodBeat.o(38315);
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
        AppMethodBeat.o(38315);
        return paramaz;
      }
    }
    String str1;
    if ((paramaz.field_msgType != null) && ((paramaz.field_msgType.equals("47")) || (paramaz.field_msgType.equals("1048625"))))
    {
      localObject1 = bmp(paramaz.field_digest);
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
          String str2 = bmp(paramaz.field_digest.substring(paramaz.field_digest.indexOf(":") + 1).replace(" ", ""));
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
      str1 = this.context.getString(2131755793);
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramaz.Cm((String)localObject1);
      }
    }
    else
    {
      if (Util.isNullOrNil(paramaz.field_digest)) {
        break label785;
      }
      if (Util.isNullOrNil(paramaz.field_digestUser)) {
        break label774;
      }
      if ((paramaz.field_isSend != 0) || (!ab.Eq(paramaz.field_username))) {
        break label762;
      }
      localObject1 = aa.getDisplayName(paramaz.field_digestUser, paramaz.field_username);
    }
    label762:
    Object localObject2;
    for (;;)
    {
      label774:
      try
      {
        localObject1 = String.format(paramaz.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)) {
          break label816;
        }
        paramaz = new SpannableStringBuilder(this.context.getString(2131762825));
        paramaz.setSpan(new ForegroundColorSpan(-5569532), 0, paramaz.length(), 33);
        paramaz.append(" ").append(com.tencent.mm.pluginsdk.ui.span.l.e(this.context, str1, paramInt));
        AppMethodBeat.o(38315);
        return paramaz;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = aa.getDisplayName(paramaz.field_digestUser);
      continue;
      localObject1 = paramaz.field_digest;
      continue;
      label785:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramaz.field_isSend, paramaz.field_username, paramaz.field_content, ahn(paramaz.field_msgType), this.context);
    }
    label816:
    if ((paramBoolean) && (paramaz.field_unReadCount > 1)) {
      localObject2 = this.context.getString(2131762828, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramaz = com.tencent.mm.pluginsdk.ui.span.l.e(this.context, (CharSequence)localObject2, paramInt);
      AppMethodBeat.o(38315);
      return paramaz;
      localObject2 = str1;
      if (paramaz.field_unReadCount > 0)
      {
        localObject2 = str1;
        if (ab.Js(paramaz.field_parentRef))
        {
          localObject2 = str1;
          if (!(this.context instanceof NewBizConversationUI)) {
            localObject2 = this.context.getString(2131762828, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
          }
        }
      }
    }
  }
  
  private static int ahn(String paramString)
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
  
  private static String bmp(String paramString)
  {
    AppMethodBeat.i(38316);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(paramString);
      AppMethodBeat.o(38316);
      return paramString;
    }
    AppMethodBeat.o(38316);
    return null;
  }
  
  private void gVp()
  {
    AppMethodBeat.i(38308);
    if (this.Pax == null)
    {
      AppMethodBeat.o(38308);
      return;
    }
    Iterator localIterator = this.Pax.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).Qcd = null;
    }
    AppMethodBeat.o(38308);
  }
  
  private void gVq()
  {
    AppMethodBeat.i(38320);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38301);
        if (!bg.aAc())
        {
          e.f(e.this).stopTimer();
          Log.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38301);
          return;
        }
        long l = Util.nowMilliSecond();
        e.g(e.this);
        l = Util.milliSecondsToNow(l) * 3L;
        Log.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(e.cWB()), Boolean.valueOf(e.d(e.this)) });
        e.NU((l + e.cWB()) / 2L);
        e.h(e.this);
        e.f(e.this).startTimer(e.cWB());
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
      paramaz = this.context.getString(2131762861);
      AppMethodBeat.o(38305);
      return paramaz;
    }
    if (paramaz.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38305);
      return "";
    }
    paramaz = f.c(this.context, paramaz.field_conversationTime, true);
    AppMethodBeat.o(38305);
    return paramaz;
  }
  
  public az a(az paramaz, Cursor paramCursor)
  {
    AppMethodBeat.i(234115);
    if (this.khr)
    {
      if ((paramCursor.getString(0) != null) && (paramCursor.getString(0).equals("1")))
      {
        localObject = paramaz;
        if (paramaz == null) {
          localObject = new az();
        }
        ((az)localObject).Cm("");
        ((az)localObject).Cn("");
        ((az)localObject).convertFrom(paramCursor);
        AppMethodBeat.o(234115);
        return localObject;
      }
      if (paramCursor.getString(0).equals("2"))
      {
        bg.aVF();
        as localas = com.tencent.mm.model.c.aSN().bjF(as.p(paramCursor));
        localObject = localas;
        if (localas == null)
        {
          localObject = new as();
          ((as)localObject).convertFrom(paramCursor);
          bg.aVF();
          com.tencent.mm.model.c.aSN().am((as)localObject);
        }
        paramCursor = paramaz;
        if (paramaz == null) {
          paramCursor = new az();
        }
        paramCursor.setStatus(2);
        paramCursor.yA(-1L);
        paramCursor.nv(1);
        paramCursor.setContent(this.context.getString(2131760990));
        paramCursor.setUsername(((ax)localObject).field_username);
        paramCursor.nt(0);
        paramCursor.Cl(Integer.toString(1));
        paramCursor.Cm("");
        paramCursor.Cn("");
        AppMethodBeat.o(234115);
        return paramCursor;
      }
    }
    Object localObject = paramaz;
    if (paramaz == null) {
      localObject = new az();
    }
    ((az)localObject).Cm("");
    ((az)localObject).Cn("");
    ((az)localObject).convertFrom(paramCursor);
    AppMethodBeat.o(234115);
    return localObject;
  }
  
  protected void a(az paramaz, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.pla = paramf;
  }
  
  protected void a(String paramString, g paramg) {}
  
  public void anp()
  {
    AppMethodBeat.i(38311);
    Log.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.khr) });
    if (this.khr)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = bg.aVF().iBo.a(ab.iCF, this.gzY, this.kdi);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.gzY != null) && (this.gzY.size() > 0)) {
        localArrayList1.addAll(this.gzY);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!ab.Eq(str)) {
            localArrayList2.add(str);
          }
          Log.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(str)));
        }
        if (this.QbM == null) {}
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = bg.aVF().iBp.b(this.kdi, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.kdi != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38311);
      return;
      bg.aVF();
      setCursor(com.tencent.mm.model.c.aST().a(ab.iCF, this.gzY, com.tencent.mm.o.a.gNj, false));
    }
  }
  
  public final void anq()
  {
    AppMethodBeat.i(38306);
    anp();
    AppMethodBeat.o(38306);
  }
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38312);
    az localaz = (az)getItem(paramInt);
    String str = localaz.field_username;
    paramViewGroup = this.QbU;
    paramViewGroup.talker = str;
    paramViewGroup.contact = null;
    paramViewGroup.Qcq = null;
    paramViewGroup.initialized = false;
    if (!Util.isNullOrNil(str)) {
      paramViewGroup.initialized = true;
    }
    this.QbX = new a((byte)0);
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
      if (com.tencent.mm.cb.a.jk(this.context))
      {
        paramView = View.inflate(this.context, 2131493793, null);
        paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131297134));
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI)) && (!(this.context instanceof ServiceNotifyConversationUI))) {
          break label1927;
        }
        a.b.d(paramViewGroup.gvv, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.gvv.getDrawable();
        if (this.QbN != null) {
          this.QbN.a((com.tencent.mm.pluginsdk.ui.e.a)localObject1);
        }
        paramViewGroup.PaE = ((NoMeasuredTextView)paramView.findViewById(2131305440));
        paramViewGroup.Qcr = ((NoMeasuredTextView)paramView.findViewById(2131308313));
        paramViewGroup.PaF = ((NoMeasuredTextView)paramView.findViewById(2131309606));
        paramViewGroup.PaG = ((NoMeasuredTextView)paramView.findViewById(2131303011));
        paramViewGroup.plf = ((TextView)paramView.findViewById(2131309165));
        paramViewGroup.plf.setBackgroundResource(v.kH(this.context));
        paramViewGroup.PaH = ((ImageView)paramView.findViewById(2131302590));
        paramViewGroup.PaJ = paramView.findViewById(2131297142);
        paramViewGroup.PaI = ((ImageView)paramView.findViewById(2131308917));
        paramViewGroup.Qcs = ((ImageView)paramView.findViewById(2131303751));
        paramView.setTag(paramViewGroup);
        paramViewGroup.PaG.setTextSize(0, this.Pat);
        paramViewGroup.PaF.setTextSize(0, this.Pau);
        paramViewGroup.PaE.setTextSize(0, this.Paq);
        paramViewGroup.Qcr.setTextSize(0, this.Pat);
        paramViewGroup.PaG.setTextColor(this.Pav[0]);
        paramViewGroup.PaF.setTextColor(this.Pav[4]);
        paramViewGroup.PaE.setTextColor(this.Pav[3]);
        paramViewGroup.Qcr.setTextColor(this.Pav[0]);
        paramViewGroup.PaG.setShouldEllipsize(true);
        paramViewGroup.PaF.setShouldEllipsize(false);
        paramViewGroup.PaE.setShouldEllipsize(true);
        paramViewGroup.Qcr.setShouldEllipsize(true);
        paramViewGroup.PaF.setGravity(5);
        localObject1 = (d)this.Pax.get(str);
        if (localObject1 != null) {
          break label2710;
        }
        localObject2 = new d((byte)0);
        localObject1 = this.QbU;
        if ((((e)localObject1).initialized) && (((e)localObject1).contact == null))
        {
          bg.aVF();
          ((e)localObject1).contact = com.tencent.mm.model.c.aSN().Kn(((e)localObject1).talker);
        }
        localas = ((e)localObject1).contact;
        if (localas == null) {
          break label1950;
        }
        ((d)localObject2).Qch = localas.fuQ;
        ((d)localObject2).Qcg = ((int)localas.gMZ);
        if (localas == null) {
          break label1965;
        }
        bool = true;
        ((d)localObject2).Qcm = bool;
        if ((localas == null) || (!localas.amU())) {
          break label1971;
        }
        bool = true;
        ((d)localObject2).Qco = bool;
        if ((localas == null) || (localas.fuH != 0)) {
          break label1977;
        }
        bool = true;
        ((d)localObject2).Qcn = bool;
        ((d)localObject2).tcb = ab.Eq(str);
        if ((!((d)localObject2).tcb) || (!((d)localObject2).Qcn) || (localaz.field_unReadCount <= 0)) {
          break label1983;
        }
        bool = true;
        ((d)localObject2).Qcl = bool;
        ((d)localObject2).qcr = 0;
        i = ahn(localaz.field_msgType);
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
          if (!new p((String)localObject1).jsi) {
            ((d)localObject2).qcr = 1;
          }
        }
        if (i == 285212721)
        {
          localObject1 = localaz.field_content;
          long l = localaz.field_lastSeq;
          com.tencent.f.h.RTc.b(new e.3(this, (String)localObject1), "tmplPreload");
        }
        localObject1 = aa.a(localas, str, ((d)localObject2).tcb);
        if ((!((d)localObject2).tcb) || (localObject1 != null)) {
          break label1989;
        }
        ((d)localObject2).nickName = this.context.getString(2131757507);
        label941:
        ((d)localObject2).Qcd = i(localaz);
        ((d)localObject2).Qce = a(localaz, (int)paramViewGroup.PaG.getTextSize(), ((d)localObject2).Qcl);
        ((d)localObject2).Qcp = localaz.field_attrflag;
        switch (localaz.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label1031:
          ((d)localObject2).Qcf = i;
          ((d)localObject2).Qci = ab.a(localaz);
          bg.aVF();
          ((d)localObject2).PaB = com.tencent.mm.model.c.aST().h(localaz);
          if ((localas != null) && (localas.Zx()))
          {
            bool = true;
            label1083:
            ((d)localObject2).Qcj = bool;
            ((d)localObject2).Qck = LocaleUtil.isChineseAppLang();
            this.Pax.put(str, localObject2);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    label1165:
    label2325:
    label2710:
    for (;;)
    {
      if (((d)localObject1).Qcd == null) {
        ((d)localObject1).Qcd = i(localaz);
      }
      if ((((d)localObject1).Qcl) || (ab.Js(localaz.field_parentRef)))
      {
        paramViewGroup.PaG.setTextColor(this.Pav[0]);
        com.tencent.mm.booter.notification.a.h.oc(paramViewGroup.PaG.getWidth());
        com.tencent.mm.booter.notification.a.h.od((int)paramViewGroup.PaG.getTextSize());
        com.tencent.mm.booter.notification.a.h.b(paramViewGroup.PaG.getPaint());
        if (!str.toLowerCase().endsWith("@t.qq.com")) {
          break label2077;
        }
        paramViewGroup.PaE.setCompoundRightDrawablesWithIntrinsicBounds(2131233117);
        paramViewGroup.PaE.setDrawRightDrawable(true);
        label1228:
        i = ((d)localObject1).Qcf;
        if (i == -1) {
          break label2088;
        }
        paramViewGroup.PaG.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        paramViewGroup.PaG.setDrawLeftDrawable(true);
        label1258:
        paramViewGroup.Qcr.setVisibility(8);
        localObject2 = paramViewGroup.PaF.getLayoutParams();
        if (((d)localObject1).Qcd.length() < 9) {
          break label2099;
        }
        if (((ViewGroup.LayoutParams)localObject2).width != this.QbW)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.QbW;
          paramViewGroup.PaF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        label1321:
        Log.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
        paramViewGroup.PaF.setText(((d)localObject1).Qcd);
        paramViewGroup.PaG.setText(((d)localObject1).Qce);
        if ((!((d)localObject1).tcb) || (!((d)localObject1).Qcn)) {
          break label2132;
        }
        paramViewGroup.PaH.setVisibility(0);
        label1393:
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI)) && (!(this.context instanceof ServiceNotifyConversationUI))) {
          break label2163;
        }
        a.b.d(paramViewGroup.gvv, str);
        label1432:
        if (this.QbL)
        {
          if ((localaz != null) && (paramViewGroup != null) && (localObject1 != null)) {
            break label2175;
          }
          Log.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        label1462:
        if ((!((d)localObject1).Qci) && (((d)localObject1).PaB) && (bg.aAc()))
        {
          bg.aVF();
          com.tencent.mm.model.c.aST().g(localaz);
        }
        if ((!(this.context instanceof NewBizConversationUI)) || (!((d)localObject1).PaB) || (localaz.field_conversationTime == -1L)) {
          break label2597;
        }
        localObject2 = this.context.getResources().getDrawable(2131231352);
        i = (int)paramViewGroup.PaE.getTextSize();
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
        localObject3 = new SpannableString("@");
        ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
        paramViewGroup.PaE.setText(TextUtils.concat(new CharSequence[] { ((d)localObject1).nickName, " ", localObject3 }));
        label1632:
        paramView.findViewById(2131299246).setBackgroundResource(2131231898);
        label1645:
        com.tencent.mm.br.c.gsX();
        localObject2 = new xq();
        ((xq)localObject2).edR.edT = true;
        EventCenter.instance.publish((IEvent)localObject2);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 7, 0L)) && (!localaz.field_username.equals(((xq)localObject2).edS.edV)))
        {
          localaz.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localaz, 6, localaz.field_conversationTime));
          bg.aVF();
          com.tencent.mm.model.c.aST().a(localaz, localaz.field_username);
        }
        if ((com.tencent.mm.bh.g.jpy != null) && (com.tencent.mm.bh.g.jpy.PW(localaz.field_username))) {
          break label2645;
        }
        paramViewGroup.PaI.setVisibility(8);
        label1776:
        if ((com.tencent.mm.bi.d.jpA == null) || (!com.tencent.mm.bi.d.jpA.PZ(localaz.field_username))) {
          break label2698;
        }
        paramViewGroup.Qcs.setVisibility(0);
      }
      for (;;)
      {
        this.QbX.content = String.valueOf(((d)localObject1).Qce);
        this.QbX.nickName = String.valueOf(((d)localObject1).nickName);
        this.QbX.time = String.valueOf(((d)localObject1).Qcd);
        localObject2 = this.QbX;
        a.a.gKe().a(paramView, ((a)localObject2).nickName, ((a)localObject2).Qcc, ((a)localObject2).time, ((a)localObject2).content);
        a(str, paramViewGroup);
        a(localaz, ((d)localObject1).PaB, paramInt, false);
        AppMethodBeat.o(38312);
        return paramView;
        paramView = View.inflate(this.context, 2131493792, null);
        break;
        a.b.c(paramViewGroup.gvv, str);
        break label162;
        paramViewGroup = (g)paramView.getTag();
        break label472;
        label1950:
        ((d)localObject2).Qch = -1;
        ((d)localObject2).Qcg = -1;
        break label579;
        label1965:
        bool = false;
        break label587;
        label1971:
        bool = false;
        break label610;
        label1977:
        bool = false;
        break label633;
        label1983:
        bool = false;
        break label677;
        label1989:
        ((d)localObject2).nickName = com.tencent.mm.pluginsdk.ui.span.l.b(this.context, aa.a(localas, str, ((d)localObject2).tcb), paramViewGroup.PaE.getTextSize());
        break label941;
        i = -1;
        break label1031;
        i = 2131691165;
        break label1031;
        i = -1;
        break label1031;
        i = 2131691164;
        break label1031;
        bool = false;
        break label1083;
        paramViewGroup.PaG.setTextColor(this.Pav[localObject1.qcr]);
        break label1165;
        label2077:
        paramViewGroup.PaE.setDrawRightDrawable(false);
        break label1228;
        label2088:
        paramViewGroup.PaG.setDrawLeftDrawable(false);
        break label1258;
        label2099:
        if (((ViewGroup.LayoutParams)localObject2).width == this.QbV) {
          break label1321;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.QbV;
        paramViewGroup.PaF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1321;
        label2132:
        if (((d)localObject1).Qcj)
        {
          paramViewGroup.PaH.setVisibility(0);
          break label1393;
        }
        paramViewGroup.PaH.setVisibility(8);
        break label1393;
        label2163:
        a.b.c(paramViewGroup.gvv, str);
        break label1432;
        label2175:
        paramViewGroup.plf.setVisibility(4);
        paramViewGroup.PaJ.setVisibility(4);
        if (ab.Js(localaz.field_username))
        {
          localObject2 = paramViewGroup.PaJ;
          if (localaz.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            paramViewGroup.PaE.setTextColor(this.Pav[3]);
            break;
          }
        }
        localObject3 = paramViewGroup.PaE;
        if ((((d)localObject1).Qcm) && (((d)localObject1).Qch == 1)) {}
        for (localObject2 = this.Pav[2];; localObject2 = this.Pav[3])
        {
          ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
          if ((((d)localObject1).Qcm) && (((d)localObject1).Qcg != 0)) {
            break label2325;
          }
          Log.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (ab.Js(localaz.field_parentRef))
        {
          if (((this.context instanceof NewBizConversationUI)) || ((this.context instanceof ServiceNotifyConversationUI))) {
            break label1462;
          }
          localObject2 = paramViewGroup.PaJ;
          if (localaz.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).Qcj) && (((d)localObject1).Qco))
        {
          localObject2 = paramViewGroup.PaJ;
          if (localaz.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).tcb) && (((d)localObject1).Qcn))
        {
          localObject2 = paramViewGroup.PaJ;
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
          paramViewGroup.plf.setText("");
          paramViewGroup.plf.setBackgroundResource(2131689753);
          paramViewGroup.plf.setVisibility(0);
        }
        for (;;)
        {
          this.QbX.Qcc = i;
          break;
          if (i > 0)
          {
            paramViewGroup.plf.setText(localaz.field_unReadCount);
            paramViewGroup.plf.setBackgroundResource(v.aQ(this.context, i));
            paramViewGroup.plf.setVisibility(0);
          }
        }
        label2597:
        paramViewGroup.PaE.setText(((d)localObject1).nickName);
        if ((!((d)localObject1).PaB) || (localaz.field_conversationTime == -1L)) {
          break label1632;
        }
        paramView.findViewById(2131299246).setBackgroundResource(2131231897);
        break label1645;
        label2645:
        paramViewGroup.PaI.setVisibility(0);
        if (localaz.field_username.equals(((xq)localObject2).edS.edV))
        {
          paramViewGroup.PaI.setImageResource(2131691604);
          break label1776;
        }
        paramViewGroup.PaI.setImageResource(2131691603);
        break label1776;
        paramViewGroup.Qcs.setVisibility(8);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38314);
    this.Qca.stopTimer();
    this.QbS = null;
    this.QbQ = null;
    if (this.Pax != null)
    {
      this.Pax.clear();
      this.Pax = null;
    }
    ebf();
    gGV();
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
    Log.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.Pay), Boolean.valueOf(this.Paz), paramString });
    if ((!Util.isNullOrNil(paramString)) && (this.Pax != null)) {
      this.Pax.remove(paramString);
    }
    if (this.Pay)
    {
      Log.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.QbZ), Boolean.valueOf(this.Qca.stopped()) });
      this.QbZ = true;
      if (this.Qca.stopped()) {
        gVq();
      }
      AppMethodBeat.o(38318);
      return;
    }
    this.Paz = true;
    AppMethodBeat.o(38318);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38307);
    if (this.plb != null) {
      this.plb.ebo();
    }
    this.Pay = false;
    AppMethodBeat.o(38307);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38309);
    Log.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.Pay), Boolean.valueOf(this.QbO), Boolean.valueOf(this.Paz), Boolean.valueOf(this.QbP) });
    this.Pay = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.i.e.a("MM/dd", (Time)localObject).toString();
    if (!this.QbT.equals(localObject)) {}
    for (;;)
    {
      this.QbT = ((String)localObject);
      if (i != 0) {
        gVp();
      }
      if ((this.QbO) && (this.QbS != null)) {
        this.QbO = false;
      }
      if ((this.Paz) || (this.QbP))
      {
        super.onNotifyChange(null, null);
        this.Paz = false;
        this.QbP = false;
      }
      AppMethodBeat.o(38309);
      return;
      i = 0;
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
  
  public static abstract interface b {}
  
  final class c
    implements MStorageEx.IOnStorageChange
  {
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      AppMethodBeat.i(38303);
      if ((paramObject == null) || (!(paramObject instanceof String)))
      {
        Log.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
        AppMethodBeat.o(38303);
        return;
      }
      paramMStorageEx = (String)paramObject;
      if (e.a(this.Qcb))
      {
        AppMethodBeat.o(38303);
        return;
      }
      if ((paramMStorageEx != null) && (!paramMStorageEx.equals("")) && (e.b(this.Qcb) != null) && (e.b(this.Qcb).containsKey(Integer.valueOf(paramInt))))
      {
        e.b(this.Qcb).remove(Integer.valueOf(paramInt));
        e.c(this.Qcb);
      }
      AppMethodBeat.o(38303);
    }
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
    public boolean Qck;
    public boolean Qcl;
    public boolean Qcm;
    public boolean Qcn;
    public boolean Qco;
    public int Qcp;
    public CharSequence nickName;
    public int qcr;
    public boolean tcb;
    
    private d() {}
  }
  
  final class e
  {
    Integer Qcq = null;
    as contact = null;
    boolean initialized = false;
    String talker = null;
    
    public e() {}
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public NoMeasuredTextView PaE;
    public NoMeasuredTextView PaF;
    public NoMeasuredTextView PaG;
    public ImageView PaH;
    public ImageView PaI;
    public View PaJ;
    public NoMeasuredTextView Qcr;
    public ImageView Qcs;
    public ImageView gvv;
    public TextView plf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */