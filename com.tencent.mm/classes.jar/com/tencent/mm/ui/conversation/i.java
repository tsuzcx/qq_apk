package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.HandlerThread;
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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.p.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class i
  extends com.tencent.mm.ui.p<ak>
  implements n.b
{
  private static long AhO = 2000L;
  private boolean AhD;
  public String AhJ;
  private final int AhL;
  private final int AhM;
  private boolean AhP;
  ap AhQ;
  private ColorStateList[] AkB;
  private String cCC;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.f jSd;
  protected MMSlideDelView.d jSe;
  private boolean ltg;
  private float zta;
  private float ztb;
  private float ztc;
  HashMap<String, i.a> zte;
  
  public i(Context paramContext, String paramString, p.a parama)
  {
    super(paramContext, new ak());
    AppMethodBeat.i(34399);
    this.AkB = new ColorStateList[5];
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.zta = -1.0F;
    this.ztb = -1.0F;
    this.ztc = -1.0F;
    this.ltg = false;
    this.AhD = false;
    this.AhJ = "";
    this.AhP = false;
    this.AhQ = new ap(aw.RO().oNc.getLooper(), new i.1(this), false);
    super.a(parama);
    this.cCC = paramString;
    this.zte = new HashMap();
    this.AkB[0] = com.tencent.mm.cb.a.l(paramContext, 2131690168);
    this.AkB[1] = com.tencent.mm.cb.a.l(paramContext, 2131690773);
    this.AkB[3] = com.tencent.mm.cb.a.l(paramContext, 2131690322);
    this.AkB[2] = com.tencent.mm.cb.a.l(paramContext, 2131690770);
    this.AkB[2] = com.tencent.mm.cb.a.l(paramContext, 2131690770);
    this.AkB[4] = com.tencent.mm.cb.a.l(paramContext, 2131690210);
    if (com.tencent.mm.cb.a.gt(paramContext)) {
      this.AhM = paramContext.getResources().getDimensionPixelSize(2131427552);
    }
    for (this.AhL = paramContext.getResources().getDimensionPixelSize(2131427554);; this.AhL = paramContext.getResources().getDimensionPixelSize(2131427555))
    {
      this.zta = com.tencent.mm.cb.a.ao(paramContext, 2131427809);
      this.ztb = com.tencent.mm.cb.a.ao(paramContext, 2131427758);
      this.ztc = com.tencent.mm.cb.a.ao(paramContext, 2131427862);
      aw.aaz();
      c.YF().a(this);
      AppMethodBeat.o(34399);
      return;
      this.AhM = paramContext.getResources().getDimensionPixelSize(2131427551);
    }
  }
  
  private static String atE(String paramString)
  {
    AppMethodBeat.i(34407);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(paramString);
      AppMethodBeat.o(34407);
      return paramString;
    }
    AppMethodBeat.o(34407);
    return null;
  }
  
  private CharSequence c(ak paramak, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34406);
    if ((!ah.isNullOrNil(paramak.field_editingMsg)) && ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131301401));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(j.b(this.context, paramak.field_editingMsg, paramInt));
      AppMethodBeat.o(34406);
      return localObject1;
    }
    Object localObject1 = paramak.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramak = new SpannableString(j.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(34406);
      return paramak;
    }
    String str1;
    if ((k(paramak) == 47) || (k(paramak) == 1048625))
    {
      localObject1 = atE(paramak.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramak = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(34406);
        return paramak;
      }
      localObject1 = str1;
      if (paramak.field_digest != null)
      {
        localObject1 = str1;
        if (paramak.field_digest.contains(":"))
        {
          str1 = paramak.field_digest.substring(0, paramak.field_digest.indexOf(":"));
          String str2 = atE(paramak.field_digest.substring(paramak.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramak = "[" + str2 + "]";
            if (ah.isNullOrNil(str1))
            {
              AppMethodBeat.o(34406);
              return paramak;
            }
            paramak = str1 + ": " + paramak;
            AppMethodBeat.o(34406);
            return paramak;
          }
        }
      }
      str1 = this.context.getString(2131296915);
      if (ah.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramak.jW((String)localObject1);
      }
    }
    else
    {
      if (ah.isNullOrNil(paramak.field_digest)) {
        break label626;
      }
      if (ah.isNullOrNil(paramak.field_digestUser)) {
        break label615;
      }
      if ((paramak.field_isSend != 0) || (!com.tencent.mm.model.t.lA(paramak.field_username))) {
        break label603;
      }
      localObject1 = s.getDisplayName(paramak.field_digestUser, paramak.field_username);
    }
    for (;;)
    {
      label603:
      label615:
      try
      {
        localObject1 = String.format(paramak.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)) {
          break label654;
        }
        paramak = new SpannableStringBuilder(this.context.getString(2131301397));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(j.b(this.context, str1, paramInt));
        AppMethodBeat.o(34406);
        return paramak;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = s.nE(paramak.field_digestUser);
      continue;
      localObject1 = paramak.field_digest;
      continue;
      label626:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramak.field_isSend, paramak.field_username, paramak.field_content, k(paramak), this.context);
    }
    label654:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramak.field_unReadCount > 1) {
        localObject2 = this.context.getString(2131301400, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
      }
    }
    paramak = j.b(this.context, (CharSequence)localObject2, paramInt);
    AppMethodBeat.o(34406);
    return paramak;
  }
  
  private void dMq()
  {
    AppMethodBeat.i(34409);
    if (this.zte == null)
    {
      AppMethodBeat.o(34409);
      return;
    }
    Iterator localIterator = this.zte.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((i.a)((Map.Entry)localIterator.next()).getValue()).AhU = null;
    }
    AppMethodBeat.o(34409);
  }
  
  private void dMr()
  {
    AppMethodBeat.i(34412);
    ab.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.AhP), Boolean.valueOf(this.AhQ.dtj()) });
    this.AhP = true;
    if (this.AhQ.dtj()) {
      dMs();
    }
    AppMethodBeat.o(34412);
  }
  
  private void dMs()
  {
    AppMethodBeat.i(34413);
    al.d(new i.2(this));
    AppMethodBeat.o(34413);
  }
  
  private CharSequence h(ak paramak)
  {
    AppMethodBeat.i(34408);
    if (paramak.field_status == 1)
    {
      paramak = this.context.getString(2131301428);
      AppMethodBeat.o(34408);
      return paramak;
    }
    if (paramak.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34408);
      return "";
    }
    paramak = com.tencent.mm.pluginsdk.f.h.c(this.context, paramak.field_conversationTime, true);
    AppMethodBeat.o(34408);
    return paramak;
  }
  
  private static int k(ak paramak)
  {
    int j = 1;
    AppMethodBeat.i(34405);
    paramak = paramak.field_msgType;
    int i = j;
    if (paramak != null)
    {
      i = j;
      if (paramak.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramak).intValue();
      AppMethodBeat.o(34405);
      return i;
    }
    catch (NumberFormatException paramak)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(34403);
    bKb();
    aw.aaz();
    setCursor(c.YF().c(com.tencent.mm.model.t.flc, null, this.cCC));
    if (this.zaq != null) {
      this.zaq.apT();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34403);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(34402);
    Ku();
    AppMethodBeat.o(34402);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(34410);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(34410);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(34410);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.jSd = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(34411);
    ab.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.ltg), Boolean.valueOf(this.AhD), paramString });
    if ((!ah.isNullOrNil(paramString)) && (this.zte != null)) {
      this.zte.remove(paramString);
    }
    if (this.ltg)
    {
      dMr();
      AppMethodBeat.o(34411);
      return;
    }
    this.AhD = true;
    AppMethodBeat.o(34411);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34404);
    ak localak = (ak)getItem(paramInt);
    String str = localak.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.cb.a.gt(this.context))
      {
        paramView = View.inflate(this.context, 2130969275, null);
        paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
        paramViewGroup.AkD = ((NoMeasuredTextView)paramView.findViewById(2131823254));
        paramViewGroup.AkD.setTextSize(0, this.zta);
        paramViewGroup.AkD.setTextColor(this.AkB[3]);
        paramViewGroup.AkD.setShouldEllipsize(true);
        paramViewGroup.AkE = ((NoMeasuredTextView)paramView.findViewById(2131823255));
        paramViewGroup.AkE.setTextSize(0, this.ztc);
        paramViewGroup.AkE.setTextColor(this.AkB[4]);
        paramViewGroup.AkE.setShouldEllipsize(false);
        paramViewGroup.AkE.setGravity(5);
        paramViewGroup.AkF = ((NoMeasuredTextView)paramView.findViewById(2131823256));
        paramViewGroup.AkF.setTextSize(0, this.ztb);
        paramViewGroup.AkF.setTextColor(this.AkB[0]);
        paramViewGroup.AkF.setShouldEllipsize(true);
        paramViewGroup.AkG = ((TextView)paramView.findViewById(2131821087));
        paramViewGroup.AkG.setBackgroundResource(com.tencent.mm.ui.tools.t.iF(this.context));
        paramViewGroup.ztl = ((ImageView)paramView.findViewById(2131823258));
        paramViewGroup.ztn = paramView.findViewById(2131823253);
        paramView.findViewById(2131823259).setVisibility(8);
        paramView.findViewById(2131823260).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      i.a locala = (i.a)this.zte.get(str);
      aw.aaz();
      Object localObject = c.YA().arw(str);
      label382:
      boolean bool;
      if (locala == null)
      {
        locala = new i.a(this, (byte)0);
        if (localObject != null)
        {
          locala.AhX = ((int)((com.tencent.mm.n.a)localObject).euF);
          if (localObject == null) {
            break label1093;
          }
          bool = true;
          label390:
          locala.Aid = bool;
          if ((localObject == null) || (!((ad)localObject).JY())) {
            break label1099;
          }
          bool = true;
          label413:
          locala.Aif = bool;
          if ((localObject == null) || (!((ad)localObject).DP())) {
            break label1105;
          }
          bool = true;
          label436:
          locala.Aia = bool;
          if (localak.field_unReadCount <= 0) {
            break label1111;
          }
          bool = true;
          label454:
          locala.szu = bool;
          locala.kwo = 0;
          if ((k(localak) == 34) && (localak.field_isSend == 0) && (!ah.isNullOrNil(localak.field_content)) && (!new com.tencent.mm.modelvoice.p(localak.field_content).fXr)) {
            locala.kwo = 1;
          }
          locala.nickName = j.b(this.context, s.a((ad)localObject, str, false), paramViewGroup.AkD.getTextSize());
          locala.AhU = h(localak);
          paramInt = (int)paramViewGroup.AkF.getTextSize();
          if ((!locala.Aia) || (!locala.szu)) {
            break label1117;
          }
          bool = true;
          label586:
          locala.AhV = c(localak, paramInt, bool);
          locala.Aig = localak.field_attrflag;
          switch (localak.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label654:
            locala.AhW = paramInt;
            aw.aaz();
            locala.ztf = c.YF().g(localak);
            locala.Aib = aa.dsC();
            this.zte.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.AhU == null) {
          locala.AhU = h(localak);
        }
        if ((locala.Aia) && (locala.szu))
        {
          paramViewGroup.AkF.setTextColor(this.AkB[0]);
          label747:
          com.tencent.mm.booter.notification.a.h.is(paramViewGroup.AkF.getWidth());
          com.tencent.mm.booter.notification.a.h.it((int)paramViewGroup.AkF.getTextSize());
          com.tencent.mm.booter.notification.a.h.a(paramViewGroup.AkF.getPaint());
          if (locala.AhW == -1) {
            break label1167;
          }
          paramViewGroup.AkF.setCompoundLeftDrawablesWithIntrinsicBounds(locala.AhW);
          paramViewGroup.AkF.setDrawLeftDrawable(true);
          label807:
          paramViewGroup.AkF.setText(locala.AhV);
          paramViewGroup.AkD.setDrawRightDrawable(false);
          paramViewGroup.AkD.setText(locala.nickName);
          localObject = paramViewGroup.AkE.getLayoutParams();
          if (locala.AhU.length() <= 9) {
            break label1178;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.AhM)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.AhM;
            paramViewGroup.AkE.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label893:
          paramViewGroup.AkE.setText(locala.AhU);
          if (!locala.Aia) {
            break label1211;
          }
          paramViewGroup.ztl.setVisibility(0);
          label921:
          a.b.c(paramViewGroup.egq, str);
          paramViewGroup.AkG.setVisibility(4);
          paramViewGroup.ztn.setVisibility(4);
          if ((locala.Aid) && (locala.AhX != 0))
          {
            paramInt = localak.field_unReadCount;
            if (!locala.Aia) {
              break label1228;
            }
            paramViewGroup = paramViewGroup.ztn;
            if (paramInt <= 0) {
              break label1223;
            }
            paramInt = 0;
            label987:
            paramViewGroup.setVisibility(paramInt);
          }
          label992:
          if ((!locala.ztf) || (localak.field_conversationTime == -1L)) {
            break label1304;
          }
          paramView.findViewById(2131823252).setBackgroundResource(2130838444);
        }
        for (;;)
        {
          a.a.dDt().a(paramView, String.valueOf(locala.nickName), localak.field_unReadCount, String.valueOf(locala.AhU), String.valueOf(locala.AhV));
          AppMethodBeat.o(34404);
          return paramView;
          paramView = View.inflate(this.context, 2130969274, null);
          break;
          locala.AhX = -1;
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
          paramInt = 2131231716;
          break label654;
          paramInt = -1;
          break label654;
          paramInt = 2131231715;
          break label654;
          paramViewGroup.AkF.setTextColor(this.AkB[locala.kwo]);
          break label747;
          label1167:
          paramViewGroup.AkF.setDrawLeftDrawable(false);
          break label807;
          label1178:
          if (((ViewGroup.LayoutParams)localObject).width == this.AhL) {
            break label893;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.AhL;
          paramViewGroup.AkE.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label893;
          label1211:
          paramViewGroup.ztl.setVisibility(8);
          break label921;
          label1223:
          paramInt = 4;
          break label987;
          label1228:
          if (paramInt > 99)
          {
            paramViewGroup.AkG.setText("");
            paramViewGroup.AkG.setBackgroundResource(2131230963);
            paramViewGroup.AkG.setVisibility(0);
            break label992;
          }
          if (paramInt <= 0) {
            break label992;
          }
          paramViewGroup.AkG.setText(String.valueOf(paramInt));
          paramViewGroup.AkG.setBackgroundResource(com.tencent.mm.ui.tools.t.iF(this.context));
          paramViewGroup.AkG.setVisibility(0);
          break label992;
          label1304:
          paramView.findViewById(2131823252).setBackgroundResource(2130838445);
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(34400);
    if (this.jSe != null) {
      this.jSe.bKk();
    }
    this.ltg = false;
    AppMethodBeat.o(34400);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(34401);
    this.ltg = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.f.g.a("MM/dd", (Time)localObject).toString();
    if (!this.AhJ.equals(localObject)) {}
    for (;;)
    {
      this.AhJ = ((String)localObject);
      if (i != 0) {
        dMq();
      }
      if (this.AhD)
      {
        super.a(null, null);
        this.AhD = false;
      }
      AppMethodBeat.o(34401);
      return;
      i = 0;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
  
  public static final class b
  {
    public NoMeasuredTextView AkD;
    public NoMeasuredTextView AkE;
    public NoMeasuredTextView AkF;
    public TextView AkG;
    public ImageView egq;
    public ImageView ztl;
    public View ztn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */