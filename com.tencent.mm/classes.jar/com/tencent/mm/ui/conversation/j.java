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
import com.tencent.mm.al.ag;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.i.e;
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
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  extends s<az>
  implements MStorageEx.IOnStorageChange
{
  private static long QbY = 2000L;
  private float Paq;
  private float Pat;
  private float Pau;
  HashMap<String, a> Pax;
  private boolean Pay;
  private boolean Paz;
  public String QbT;
  private final int QbV;
  private final int QbW;
  private boolean QbZ;
  MTimerHandler Qca;
  private String QeU;
  private ColorStateList[] QeV;
  private String dVu;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.f pla;
  protected MMSlideDelView.d plb;
  
  public j(Context paramContext, String paramString, s.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(38528);
    this.QeV = new ColorStateList[5];
    this.plb = MMSlideDelView.getItemStatusCallBack();
    this.Paq = -1.0F;
    this.Pat = -1.0F;
    this.Pau = -1.0F;
    this.Pay = false;
    this.Paz = false;
    this.QbT = "";
    this.QbZ = false;
    this.Qca = new MTimerHandler(bg.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(38526);
        if (j.a(j.this)) {
          j.b(j.this);
        }
        AppMethodBeat.o(38526);
        return false;
      }
    }, false);
    super.a(parama);
    this.dVu = paramString;
    try
    {
      ag.bah();
      this.QeU = com.tencent.mm.al.f.MX(paramString);
      label119:
      this.Pax = new HashMap();
      this.QeV[0] = com.tencent.mm.cb.a.m(paramContext, 2131100594);
      this.QeV[1] = com.tencent.mm.cb.a.m(paramContext, 2131100813);
      this.QeV[3] = com.tencent.mm.cb.a.m(paramContext, 2131100904);
      this.QeV[2] = com.tencent.mm.cb.a.m(paramContext, 2131100810);
      this.QeV[2] = com.tencent.mm.cb.a.m(paramContext, 2131100810);
      this.QeV[4] = com.tencent.mm.cb.a.m(paramContext, 2131100681);
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
        bg.aVF();
        com.tencent.mm.model.c.aST().add(this);
        AppMethodBeat.o(38528);
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
    catch (Throwable paramString)
    {
      break label119;
    }
  }
  
  public static az a(az paramaz, Cursor paramCursor)
  {
    AppMethodBeat.i(234157);
    az localaz = paramaz;
    if (paramaz == null) {
      localaz = new az();
    }
    localaz.Cm("");
    localaz.Cn("");
    localaz.convertFrom(paramCursor);
    AppMethodBeat.o(234157);
    return localaz;
  }
  
  private static String bmp(String paramString)
  {
    AppMethodBeat.i(38536);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(paramString);
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
      localObject1 = new SpannableStringBuilder(this.context.getString(2131762834));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(l.e(this.context, paramaz.field_editingMsg, paramInt));
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
    if ((m(paramaz) == 47) || (m(paramaz) == 1048625))
    {
      localObject1 = bmp(paramaz.field_digest);
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
          String str2 = bmp(paramaz.field_digest.substring(paramaz.field_digest.indexOf(":") + 1).replace(" ", ""));
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
        break label633;
      }
      if (Util.isNullOrNil(paramaz.field_digestUser)) {
        break label622;
      }
      if ((paramaz.field_isSend != 0) || (!ab.Eq(paramaz.field_username))) {
        break label610;
      }
      localObject1 = aa.getDisplayName(paramaz.field_digestUser, paramaz.field_username);
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
        paramaz = new SpannableStringBuilder(this.context.getString(2131762825));
        paramaz.setSpan(new ForegroundColorSpan(-5569532), 0, paramaz.length(), 33);
        paramaz.append(" ").append(l.e(this.context, str1, paramInt));
        AppMethodBeat.o(38535);
        return paramaz;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = aa.getDisplayName(paramaz.field_digestUser);
      continue;
      localObject1 = paramaz.field_digest;
      continue;
      label633:
      localObject2 = h.a(paramaz.field_isSend, paramaz.field_username, paramaz.field_content, m(paramaz), this.context);
    }
    label661:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramaz.field_unReadCount > 1) {
        localObject2 = this.context.getString(2131762828, new Object[] { Integer.valueOf(paramaz.field_unReadCount), str1 });
      }
    }
    paramaz = l.e(this.context, (CharSequence)localObject2, paramInt);
    AppMethodBeat.o(38535);
    return paramaz;
  }
  
  private void gVp()
  {
    AppMethodBeat.i(38538);
    if (this.Pax == null)
    {
      AppMethodBeat.o(38538);
      return;
    }
    Iterator localIterator = this.Pax.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).Qcd = null;
    }
    AppMethodBeat.o(38538);
  }
  
  private void gVq()
  {
    AppMethodBeat.i(38542);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38527);
        if (!bg.aAc())
        {
          j.c(j.this).stopTimer();
          Log.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
          AppMethodBeat.o(38527);
          return;
        }
        long l = Util.nowMilliSecond();
        j.d(j.this);
        l = Util.milliSecondsToNow(l) * 3L;
        Log.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(j.QbY), Boolean.valueOf(j.a(j.this)) });
        j.NV((l + j.QbY) / 2L);
        j.e(j.this);
        j.c(j.this).startTimer(j.QbY);
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
      paramaz = this.context.getString(2131762861);
      AppMethodBeat.o(38537);
      return paramaz;
    }
    if (paramaz.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(38537);
      return "";
    }
    paramaz = com.tencent.mm.pluginsdk.i.f.c(this.context, paramaz.field_conversationTime, true);
    AppMethodBeat.o(38537);
    return paramaz;
  }
  
  private static int m(az paramaz)
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
    this.pla = paramf;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(38532);
    ebf();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      localLinkedList.addAll(com.tencent.mm.al.g.Nl(this.dVu));
      label30:
      if (Util.isNullOrNil(this.QeU))
      {
        bg.aVF();
        setCursor(com.tencent.mm.model.c.aST().c(ab.iCF, localLinkedList, this.dVu));
      }
      for (;;)
      {
        if (this.OFI != null) {
          this.OFI.bnE();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38532);
        return;
        localLinkedList.add(this.QeU);
        bg.aVF();
        setCursor(com.tencent.mm.model.c.aST().c(ab.iCF, localLinkedList, this.dVu));
      }
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }
  
  public final void anq()
  {
    AppMethodBeat.i(38531);
    anp();
    AppMethodBeat.o(38531);
  }
  
  public final Cursor getCursor()
  {
    AppMethodBeat.i(234156);
    Cursor localCursor = super.getCursor();
    AppMethodBeat.o(234156);
    return localCursor;
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
      if (com.tencent.mm.cb.a.jk(this.context))
      {
        paramView = View.inflate(this.context, 2131493793, null);
        paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131297134));
        paramViewGroup.QeX = ((NoMeasuredTextView)paramView.findViewById(2131305440));
        paramViewGroup.QeX.setTextSize(0, this.Paq);
        paramViewGroup.QeX.setTextColor(this.QeV[3]);
        paramViewGroup.QeX.setShouldEllipsize(true);
        paramViewGroup.QeY = ((NoMeasuredTextView)paramView.findViewById(2131309606));
        paramViewGroup.QeY.setTextSize(0, this.Pau);
        paramViewGroup.QeY.setTextColor(this.QeV[4]);
        paramViewGroup.QeY.setShouldEllipsize(false);
        paramViewGroup.QeY.setGravity(5);
        paramViewGroup.QeZ = ((NoMeasuredTextView)paramView.findViewById(2131303011));
        paramViewGroup.QeZ.setTextSize(0, this.Pat);
        paramViewGroup.QeZ.setTextColor(this.QeV[0]);
        paramViewGroup.QeZ.setShouldEllipsize(true);
        paramViewGroup.Qfa = ((TextView)paramView.findViewById(2131309165));
        paramViewGroup.Qfa.setBackgroundResource(v.kH(this.context));
        paramViewGroup.PaH = ((ImageView)paramView.findViewById(2131302590));
        paramViewGroup.PaJ = paramView.findViewById(2131297142);
        paramView.findViewById(2131308917).setVisibility(8);
        paramView.findViewById(2131303751).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a locala = (a)this.Pax.get(str);
      bg.aVF();
      Object localObject = com.tencent.mm.model.c.aSN().Kn(str);
      label382:
      boolean bool;
      if (locala == null)
      {
        locala = new a((byte)0);
        if (localObject != null)
        {
          locala.Qcg = ((int)((com.tencent.mm.contact.c)localObject).gMZ);
          if (localObject == null) {
            break label1093;
          }
          bool = true;
          label390:
          locala.Qcm = bool;
          if ((localObject == null) || (!((as)localObject).amU())) {
            break label1099;
          }
          bool = true;
          label413:
          locala.Qco = bool;
          if ((localObject == null) || (!((as)localObject).Zx())) {
            break label1105;
          }
          bool = true;
          label436:
          locala.Qcj = bool;
          if (localaz.field_unReadCount <= 0) {
            break label1111;
          }
          bool = true;
          label454:
          locala.FpT = bool;
          locala.qcr = 0;
          if ((m(localaz) == 34) && (localaz.field_isSend == 0) && (!Util.isNullOrNil(localaz.field_content)) && (!new p(localaz.field_content).jsi)) {
            locala.qcr = 1;
          }
          locala.nickName = l.b(this.context, aa.a((as)localObject, str, false), paramViewGroup.QeX.getTextSize());
          locala.Qcd = i(localaz);
          paramInt = (int)paramViewGroup.QeZ.getTextSize();
          if ((!locala.Qcj) || (!locala.FpT)) {
            break label1117;
          }
          bool = true;
          label586:
          locala.Qce = c(localaz, paramInt, bool);
          locala.Qcp = localaz.field_attrflag;
          switch (localaz.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label654:
            locala.Qcf = paramInt;
            bg.aVF();
            locala.PaB = com.tencent.mm.model.c.aST().h(localaz);
            locala.Qck = LocaleUtil.isChineseAppLang();
            this.Pax.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.Qcd == null) {
          locala.Qcd = i(localaz);
        }
        if ((locala.Qcj) && (locala.FpT))
        {
          paramViewGroup.QeZ.setTextColor(this.QeV[0]);
          label747:
          h.oc(paramViewGroup.QeZ.getWidth());
          h.od((int)paramViewGroup.QeZ.getTextSize());
          h.b(paramViewGroup.QeZ.getPaint());
          if (locala.Qcf == -1) {
            break label1167;
          }
          paramViewGroup.QeZ.setCompoundLeftDrawablesWithIntrinsicBounds(locala.Qcf);
          paramViewGroup.QeZ.setDrawLeftDrawable(true);
          label807:
          paramViewGroup.QeZ.setText(locala.Qce);
          paramViewGroup.QeX.setDrawRightDrawable(false);
          paramViewGroup.QeX.setText(locala.nickName);
          localObject = paramViewGroup.QeY.getLayoutParams();
          if (locala.Qcd.length() < 9) {
            break label1178;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.QbW)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.QbW;
            paramViewGroup.QeY.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label893:
          paramViewGroup.QeY.setText(locala.Qcd);
          if (!locala.Qcj) {
            break label1211;
          }
          paramViewGroup.PaH.setVisibility(0);
          label921:
          a.b.c(paramViewGroup.gvv, str);
          paramViewGroup.Qfa.setVisibility(4);
          paramViewGroup.PaJ.setVisibility(4);
          if ((locala.Qcm) && (locala.Qcg != 0))
          {
            paramInt = localaz.field_unReadCount;
            if (!locala.Qcj) {
              break label1228;
            }
            paramViewGroup = paramViewGroup.PaJ;
            if (paramInt <= 0) {
              break label1223;
            }
            paramInt = 0;
            label987:
            paramViewGroup.setVisibility(paramInt);
          }
          label992:
          if ((!locala.PaB) || (localaz.field_conversationTime == -1L)) {
            break label1305;
          }
          paramView.findViewById(2131299246).setBackgroundResource(2131231897);
        }
        for (;;)
        {
          a.a.gKe().a(paramView, String.valueOf(locala.nickName), localaz.field_unReadCount, String.valueOf(locala.Qcd), String.valueOf(locala.Qce));
          AppMethodBeat.o(38533);
          return paramView;
          paramView = View.inflate(this.context, 2131493792, null);
          break;
          locala.Qcg = -1;
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
          paramInt = 2131691165;
          break label654;
          paramInt = -1;
          break label654;
          paramInt = 2131691164;
          break label654;
          paramViewGroup.QeZ.setTextColor(this.QeV[locala.qcr]);
          break label747;
          label1167:
          paramViewGroup.QeZ.setDrawLeftDrawable(false);
          break label807;
          label1178:
          if (((ViewGroup.LayoutParams)localObject).width == this.QbV) {
            break label893;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.QbV;
          paramViewGroup.QeY.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label893;
          label1211:
          paramViewGroup.PaH.setVisibility(8);
          break label921;
          label1223:
          paramInt = 4;
          break label987;
          label1228:
          if (paramInt > 99)
          {
            paramViewGroup.Qfa.setText("");
            paramViewGroup.Qfa.setBackgroundResource(2131689753);
            paramViewGroup.Qfa.setVisibility(0);
            break label992;
          }
          if (paramInt <= 0) {
            break label992;
          }
          paramViewGroup.Qfa.setText(String.valueOf(paramInt));
          paramViewGroup.Qfa.setBackgroundResource(v.aQ(this.context, paramInt));
          paramViewGroup.Qfa.setVisibility(0);
          break label992;
          label1305:
          paramView.findViewById(2131299246).setBackgroundResource(2131231898);
        }
      }
    }
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
    Log.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.Pay), Boolean.valueOf(this.Paz), paramString });
    if ((!Util.isNullOrNil(paramString)) && (this.Pax != null)) {
      this.Pax.remove(paramString);
    }
    if (this.Pay)
    {
      Log.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.QbZ), Boolean.valueOf(this.Qca.stopped()) });
      this.QbZ = true;
      if (this.Qca.stopped()) {
        gVq();
      }
      AppMethodBeat.o(38540);
      return;
    }
    this.Paz = true;
    AppMethodBeat.o(38540);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(38529);
    if (this.plb != null) {
      this.plb.ebo();
    }
    this.Pay = false;
    AppMethodBeat.o(38529);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(38530);
    this.Pay = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = e.a("MM/dd", (Time)localObject).toString();
    if (!this.QbT.equals(localObject)) {}
    for (;;)
    {
      this.QbT = ((String)localObject);
      if (i != 0) {
        gVp();
      }
      if (this.Paz)
      {
        super.onNotifyChange(null, null);
        this.Paz = false;
      }
      AppMethodBeat.o(38530);
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
    public boolean FpT;
    public boolean PaB;
    public CharSequence Qcd;
    public CharSequence Qce;
    public int Qcf;
    public int Qcg;
    public boolean Qcj;
    public boolean Qck;
    public boolean Qcm;
    public boolean Qco;
    public int Qcp;
    public CharSequence nickName;
    public int qcr;
    
    private a() {}
  }
  
  public static final class b
  {
    public ImageView PaH;
    public View PaJ;
    public NoMeasuredTextView QeX;
    public NoMeasuredTextView QeY;
    public NoMeasuredTextView QeZ;
    public TextView Qfa;
    public ImageView gvv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j
 * JD-Core Version:    0.7.0.1
 */