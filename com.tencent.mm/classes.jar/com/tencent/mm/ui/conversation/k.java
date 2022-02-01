package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.j.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class k
  extends v<az>
  implements MStorageEx.IOnStorageChange
{
  private static long XAn = 2000L;
  private float WtD;
  private float WtG;
  private float WtH;
  HashMap<String, a> WtK;
  private boolean WtL;
  private boolean WtM;
  public String XAi;
  private final int XAk;
  private final int XAl;
  private boolean XAo;
  MTimerHandler XAp;
  private String XBZ;
  private ColorStateList[] XCa;
  private String fOX;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.f snj;
  protected MMSlideDelView.d snk;
  
  public k(Context paramContext, String paramString, v.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(38528);
    this.XCa = new ColorStateList[5];
    this.snk = MMSlideDelView.getItemStatusCallBack();
    this.WtD = -1.0F;
    this.WtG = -1.0F;
    this.WtH = -1.0F;
    this.WtL = false;
    this.WtM = false;
    this.XAi = "";
    this.XAo = false;
    this.XAp = new MTimerHandler(bh.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(38526);
        if (k.a(k.this)) {
          k.b(k.this);
        }
        AppMethodBeat.o(38526);
        return false;
      }
    }, false);
    super.a(parama);
    this.fOX = paramString;
    try
    {
      af.bjv();
      this.XBZ = com.tencent.mm.ao.f.Ut(paramString);
      label119:
      this.WtK = new HashMap();
      this.XCa[0] = com.tencent.mm.ci.a.l(paramContext, R.e.hint_text_color);
      this.XCa[1] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_unread);
      this.XCa[3] = com.tencent.mm.ci.a.l(paramContext, R.e.normal_text_color);
      this.XCa[2] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_three);
      this.XCa[2] = com.tencent.mm.ci.a.l(paramContext, R.e.mm_list_textcolor_three);
      this.XCa[4] = com.tencent.mm.ci.a.l(paramContext, R.e.light_text_color);
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
        bh.beI();
        c.bbR().add(this);
        AppMethodBeat.o(38528);
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
    catch (Throwable paramString)
    {
      break label119;
    }
  }
  
  public static az a(az paramaz, Cursor paramCursor)
  {
    AppMethodBeat.i(281034);
    az localaz = paramaz;
    if (paramaz == null) {
      localaz = new az();
    }
    localaz.Ja("");
    localaz.Jb("");
    localaz.convertFrom(paramCursor);
    AppMethodBeat.o(281034);
    return localaz;
  }
  
  private static String byO(String paramString)
  {
    AppMethodBeat.i(38536);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(paramString);
      AppMethodBeat.o(38536);
      return paramString;
    }
    AppMethodBeat.o(38536);
    return null;
  }
  
  private CharSequence c(az paramaz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38535);
    if ((!Util.isNullOrNil(paramaz.field_editingMsg)) && ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.eLh));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(l.d(this.context, paramaz.field_editingMsg, paramInt));
      AppMethodBeat.o(38535);
      return localObject1;
    }
    Object localObject1 = paramaz.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramaz = new SpannableString(l.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(38535);
      return paramaz;
    }
    String str1;
    if ((l(paramaz) == 47) || (l(paramaz) == 1048625))
    {
      localObject1 = byO(paramaz.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramaz = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(38535);
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
              AppMethodBeat.o(38535);
              return paramaz;
            }
            paramaz = str1 + ": " + paramaz;
            AppMethodBeat.o(38535);
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
        break label633;
      }
      if (Util.isNullOrNil(paramaz.field_digestUser)) {
        break label622;
      }
      if ((paramaz.field_isSend != 0) || (!ab.Lj(paramaz.field_username))) {
        break label610;
      }
      localObject1 = aa.aL(paramaz.field_digestUser, paramaz.field_username);
    }
    for (;;)
    {
      label610:
      label622:
      try
      {
        localObject1 = String.format(paramaz.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramaz.field_atCount <= 0) || (paramaz.field_unReadCount <= 0)) {
          break label661;
        }
        paramaz = new SpannableStringBuilder(this.context.getString(R.l.eLd));
        paramaz.setSpan(new ForegroundColorSpan(-5569532), 0, paramaz.length(), 33);
        paramaz.append(" ").append(l.d(this.context, str1, paramInt));
        AppMethodBeat.o(38535);
        return paramaz;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = aa.PJ(paramaz.field_digestUser);
      continue;
      localObject1 = paramaz.field_digest;
      continue;
      label633:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramaz.field_isSend, paramaz.field_username, paramaz.field_content, l(paramaz), this.context);
    }
    label661:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramaz.field_unReadCount > 1) {
        localObject2 = this.context.getString(R.l.eLg, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
      }
    }
    paramaz = l.d(this.context, (CharSequence)localObject2, paramInt);
    AppMethodBeat.o(38535);
    return paramaz;
  }
  
  private void ezX()
  {
    AppMethodBeat.i(38538);
    if (this.WtK == null)
    {
      AppMethodBeat.o(38538);
      return;
    }
    Iterator localIterator = this.WtK.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).XAs = null;
    }
    AppMethodBeat.o(38538);
  }
  
  private void hVW()
  {
    AppMethodBeat.i(38542);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38527);
        if (!bh.aHB())
        {
          k.c(k.this).stopTimer();
          Log.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38527);
          return;
        }
        long l = Util.nowMilliSecond();
        k.d(k.this);
        l = Util.milliSecondsToNow(l) * 3L;
        Log.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(k.XAn), Boolean.valueOf(k.a(k.this)) });
        k.Wi((l + k.XAn) / 2L);
        k.e(k.this);
        k.c(k.this).startTimer(k.XAn);
        AppMethodBeat.o(38527);
      }
    });
    AppMethodBeat.o(38542);
  }
  
  private CharSequence i(az paramaz)
  {
    AppMethodBeat.i(38537);
    if (paramaz.field_status == 1)
    {
      paramaz = this.context.getString(R.l.eLv);
      AppMethodBeat.o(38537);
      return paramaz;
    }
    if (paramaz.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38537);
      return "";
    }
    paramaz = com.tencent.mm.pluginsdk.j.f.d(this.context, paramaz.field_conversationTime, true);
    AppMethodBeat.o(38537);
    return paramaz;
  }
  
  private static int l(az paramaz)
  {
    int j = 1;
    AppMethodBeat.i(38534);
    paramaz = paramaz.field_msgType;
    int i = j;
    if (paramaz != null)
    {
      i = j;
      if (paramaz.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramaz).intValue();
      AppMethodBeat.o(38534);
      return i;
    }
    catch (NumberFormatException paramaz)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.snj = paramf;
  }
  
  public final void atr()
  {
    AppMethodBeat.i(38532);
    eKd();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      localLinkedList.addAll(g.UH(this.fOX));
      label30:
      if (Util.isNullOrNil(this.XBZ))
      {
        bh.beI();
        v(c.bbR().a(1, localLinkedList, this.fOX));
      }
      for (;;)
      {
        if (this.VZc != null) {
          this.VZc.bxN();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38532);
        return;
        localLinkedList.add(this.XBZ);
        bh.beI();
        v(c.bbR().a(1, localLinkedList, this.fOX));
      }
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }
  
  public final void ats()
  {
    AppMethodBeat.i(38531);
    atr();
    AppMethodBeat.o(38531);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38533);
    az localaz = (az)getItem(paramInt);
    String str = localaz.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.ci.a.ko(this.context))
      {
        paramView = View.inflate(this.context, R.i.efG, null);
        paramViewGroup.iZG = ((ImageView)paramView.findViewById(R.h.avatar_iv));
        paramViewGroup.XCc = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
        paramViewGroup.XCc.setTextSize(0, this.WtD);
        paramViewGroup.XCc.setTextColor(this.XCa[3]);
        paramViewGroup.XCc.setShouldEllipsize(true);
        paramViewGroup.XCd = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
        paramViewGroup.XCd.setTextSize(0, this.WtH);
        paramViewGroup.XCd.setTextColor(this.XCa[4]);
        paramViewGroup.XCd.setShouldEllipsize(false);
        paramViewGroup.XCd.setGravity(5);
        paramViewGroup.XCe = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
        paramViewGroup.XCe.setTextSize(0, this.WtG);
        paramViewGroup.XCe.setTextColor(this.XCa[0]);
        paramViewGroup.XCe.setShouldEllipsize(true);
        paramViewGroup.XCf = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
        paramViewGroup.XCf.setBackgroundResource(w.lE(this.context));
        paramViewGroup.WtU = ((ImageView)paramView.findViewById(R.h.dIR));
        paramViewGroup.WtW = paramView.findViewById(R.h.dse);
        paramView.findViewById(R.h.dWs).setVisibility(8);
        paramView.findViewById(R.h.dLB).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a locala = (a)this.WtK.get(str);
      bh.beI();
      Object localObject = c.bbL().RG(str);
      label382:
      boolean bool;
      if (locala == null)
      {
        locala = new a((byte)0);
        if (localObject != null)
        {
          locala.XAv = ((int)((com.tencent.mm.contact.d)localObject).jxt);
          if (localObject == null) {
            break label1093;
          }
          bool = true;
          label390:
          locala.XAB = bool;
          if ((localObject == null) || (!((as)localObject).asV())) {
            break label1099;
          }
          bool = true;
          label413:
          locala.XAD = bool;
          if ((localObject == null) || (!((as)localObject).aeg())) {
            break label1105;
          }
          bool = true;
          label436:
          locala.XAy = bool;
          if (localaz.field_unReadCount <= 0) {
            break label1111;
          }
          bool = true;
          label454:
          locala.LJW = bool;
          locala.viewType = 0;
          if ((l(localaz) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)) && (!new p(localaz.field_content).mhL)) {
            locala.viewType = 1;
          }
          locala.nickName = l.b(this.context, aa.a((as)localObject, str, false), paramViewGroup.XCc.getTextSize());
          locala.XAs = i(localaz);
          paramInt = (int)paramViewGroup.XCe.getTextSize();
          if ((!locala.XAy) || (!locala.LJW)) {
            break label1117;
          }
          bool = true;
          label586:
          locala.XAt = c(localaz, paramInt, bool);
          locala.XAE = localaz.field_attrflag;
          switch (localaz.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label654:
            locala.XAu = paramInt;
            bh.beI();
            locala.WtO = c.bbR().h(localaz);
            locala.XAz = LocaleUtil.isChineseAppLang();
            this.WtK.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.XAs == null) {
          locala.XAs = i(localaz);
        }
        if ((locala.XAy) && (locala.LJW))
        {
          paramViewGroup.XCe.setTextColor(this.XCa[0]);
          label747:
          com.tencent.mm.booter.notification.a.h.qr(paramViewGroup.XCe.getWidth());
          com.tencent.mm.booter.notification.a.h.qs((int)paramViewGroup.XCe.getTextSize());
          com.tencent.mm.booter.notification.a.h.b(paramViewGroup.XCe.getPaint());
          if (locala.XAu == -1) {
            break label1167;
          }
          paramViewGroup.XCe.setCompoundLeftDrawablesWithIntrinsicBounds(locala.XAu);
          paramViewGroup.XCe.setDrawLeftDrawable(true);
          label807:
          paramViewGroup.XCe.setText(locala.XAt);
          paramViewGroup.XCc.setDrawRightDrawable(false);
          paramViewGroup.XCc.setText(locala.nickName);
          localObject = paramViewGroup.XCd.getLayoutParams();
          if (locala.XAs.length() < 9) {
            break label1178;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.XAl)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.XAl;
            paramViewGroup.XCd.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label893:
          paramViewGroup.XCd.setText(locala.XAs);
          if (!locala.XAy) {
            break label1211;
          }
          paramViewGroup.WtU.setVisibility(0);
          label921:
          a.b.c(paramViewGroup.iZG, str);
          paramViewGroup.XCf.setVisibility(4);
          paramViewGroup.WtW.setVisibility(4);
          if ((locala.XAB) && (locala.XAv != 0))
          {
            paramInt = localaz.field_unReadCount;
            if (!locala.XAy) {
              break label1228;
            }
            paramViewGroup = paramViewGroup.WtW;
            if (paramInt <= 0) {
              break label1223;
            }
            paramInt = 0;
            label987:
            paramViewGroup.setVisibility(paramInt);
          }
          label992:
          if ((!locala.WtO) || (localaz.field_conversationTime == -1L)) {
            break label1305;
          }
          paramView.findViewById(R.h.dCL).setBackgroundResource(R.g.comm_item_highlight_selector);
        }
        for (;;)
        {
          a.a.hJg().a(paramView, String.valueOf(locala.nickName), localaz.field_unReadCount, String.valueOf(locala.XAs), String.valueOf(locala.XAt));
          AppMethodBeat.o(38533);
          return paramView;
          paramView = View.inflate(this.context, R.i.efF, null);
          break;
          locala.XAv = -1;
          break label382;
          label1093:
          bool = false;
          break label390;
          label1099:
          bool = false;
          break label413;
          label1105:
          bool = false;
          break label436;
          label1111:
          bool = false;
          break label454;
          label1117:
          bool = false;
          break label586;
          paramInt = -1;
          break label654;
          paramInt = R.k.msg_state_sending;
          break label654;
          paramInt = -1;
          break label654;
          paramInt = R.k.msg_state_failed;
          break label654;
          paramViewGroup.XCe.setTextColor(this.XCa[locala.viewType]);
          break label747;
          label1167:
          paramViewGroup.XCe.setDrawLeftDrawable(false);
          break label807;
          label1178:
          if (((ViewGroup.LayoutParams)localObject).width == this.XAk) {
            break label893;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.XAk;
          paramViewGroup.XCd.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label893;
          label1211:
          paramViewGroup.WtU.setVisibility(8);
          break label921;
          label1223:
          paramInt = 4;
          break label987;
          label1228:
          if (paramInt > 99)
          {
            paramViewGroup.XCf.setText("");
            paramViewGroup.XCf.setBackgroundResource(R.k.badge_count_more);
            paramViewGroup.XCf.setVisibility(0);
            break label992;
          }
          if (paramInt <= 0) {
            break label992;
          }
          paramViewGroup.XCf.setText(String.valueOf(paramInt));
          paramViewGroup.XCf.setBackgroundResource(w.bj(this.context, paramInt));
          paramViewGroup.XCf.setVisibility(0);
          break label992;
          label1305:
          paramView.findViewById(R.h.dCL).setBackgroundResource(R.g.comm_list_item_selector);
        }
      }
    }
  }
  
  public final Cursor hK()
  {
    AppMethodBeat.i(281033);
    Cursor localCursor = super.hK();
    AppMethodBeat.o(281033);
    return localCursor;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(38539);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(38539);
      return;
    }
    onNotifyChange((String)paramObject, null);
    AppMethodBeat.o(38539);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(38540);
    Log.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.WtL), Boolean.valueOf(this.WtM), paramString });
    if ((!Util.isNullOrNil(paramString)) && (this.WtK != null)) {
      this.WtK.remove(paramString);
    }
    if (this.WtL)
    {
      Log.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.XAo), Boolean.valueOf(this.XAp.stopped()) });
      this.XAo = true;
      if (this.XAp.stopped()) {
        hVW();
      }
      AppMethodBeat.o(38540);
      return;
    }
    this.WtM = true;
    AppMethodBeat.o(38540);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38529);
    if (this.snk != null) {
      this.snk.eKm();
    }
    this.WtL = false;
    AppMethodBeat.o(38529);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38530);
    this.WtL = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = e.a("MM/dd", (Time)localObject).toString();
    if (!this.XAi.equals(localObject)) {}
    for (;;)
    {
      this.XAi = ((String)localObject);
      if (i != 0) {
        ezX();
      }
      if (this.WtM)
      {
        super.onNotifyChange(null, null);
        this.WtM = false;
      }
      AppMethodBeat.o(38530);
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
    public boolean LJW;
    public boolean WtO;
    public boolean XAB;
    public boolean XAD;
    public int XAE;
    public CharSequence XAs;
    public CharSequence XAt;
    public int XAu;
    public int XAv;
    public boolean XAy;
    public boolean XAz;
    public CharSequence nickName;
    public int viewType;
    
    private a() {}
  }
  
  public static final class b
  {
    public ImageView WtU;
    public View WtW;
    public NoMeasuredTextView XCc;
    public NoMeasuredTextView XCd;
    public NoMeasuredTextView XCe;
    public TextView XCf;
    public ImageView iZG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */