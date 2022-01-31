package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.br;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.a;
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
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.p.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends com.tencent.mm.ui.p<ak>
  implements n.b
{
  private static long AhO = 2000L;
  private boolean AhA;
  private e.f AhB;
  private com.tencent.mm.pluginsdk.ui.d AhC;
  private boolean AhD;
  private boolean AhE;
  private boolean AhF;
  private e.c AhG;
  private com.tencent.mm.sdk.b.c AhH;
  private e.b AhI;
  public String AhJ;
  final e.e AhK;
  private final int AhL;
  private final int AhM;
  private e.a AhN;
  private boolean AhP;
  private ap AhQ;
  protected List<String> ejc;
  private String gvZ;
  private boolean gzX;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.f jSd;
  protected MMSlideDelView.d jSe;
  private boolean ltg;
  boolean rGP;
  private float zta;
  protected float ztb;
  private float ztc;
  private ColorStateList[] ztd;
  HashMap<String, e.d> zte;
  
  public e(Context paramContext, p.a parama)
  {
    super(paramContext, new ak());
    AppMethodBeat.i(34189);
    this.ejc = null;
    this.ztd = new ColorStateList[5];
    this.AhA = true;
    this.gzX = false;
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.zta = -1.0F;
    this.ztb = -1.0F;
    this.ztc = -1.0F;
    this.ltg = false;
    this.AhD = false;
    this.AhE = false;
    this.AhF = false;
    this.AhH = null;
    this.AhI = null;
    this.AhJ = "";
    this.AhK = new e.e(this);
    this.rGP = false;
    this.AhP = false;
    this.AhQ = new ap(aw.RO().oNc.getLooper(), new e.1(this), false);
    super.a(parama);
    this.ztd[0] = com.tencent.mm.cb.a.l(paramContext, 2131690168);
    this.ztd[1] = com.tencent.mm.cb.a.l(paramContext, 2131690773);
    this.ztd[3] = com.tencent.mm.cb.a.l(paramContext, 2131690322);
    this.ztd[2] = com.tencent.mm.cb.a.l(paramContext, 2131690770);
    this.ztd[2] = com.tencent.mm.cb.a.l(paramContext, 2131690770);
    this.ztd[4] = com.tencent.mm.cb.a.l(paramContext, 2131690210);
    this.zte = new HashMap();
    if (com.tencent.mm.cb.a.gt(paramContext)) {
      this.AhM = paramContext.getResources().getDimensionPixelSize(2131427552);
    }
    for (this.AhL = paramContext.getResources().getDimensionPixelSize(2131427554);; this.AhL = paramContext.getResources().getDimensionPixelSize(2131427555))
    {
      this.zta = com.tencent.mm.cb.a.ao(paramContext, 2131427809);
      this.ztb = com.tencent.mm.cb.a.ao(paramContext, 2131427758);
      this.ztc = com.tencent.mm.cb.a.ao(paramContext, 2131427862);
      AppMethodBeat.o(34189);
      return;
      this.AhM = paramContext.getResources().getDimensionPixelSize(2131427551);
    }
  }
  
  private static int GH(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(34198);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(34198);
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
  
  private CharSequence a(ak paramak, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34200);
    if ((!ah.isNullOrNil(paramak.field_editingMsg)) && ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(2131301401));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(j.b(this.context, paramak.field_editingMsg, paramInt));
      AppMethodBeat.o(34200);
      return localObject1;
    }
    Object localObject1 = paramak.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramak = new SpannableString(j.e(this.context, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(34200);
      return paramak;
    }
    localObject1 = paramak.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      aw.aaz();
      if (ah.g((Integer)com.tencent.mm.model.c.Ru().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramak = this.context.getString(2131303374);
        AppMethodBeat.o(34200);
        return paramak;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      aw.aaz();
      localObject1 = com.tencent.mm.model.c.YI().TL("@t.qq.com");
      if ((localObject1 != null) && (((com.tencent.mm.storage.bq)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramak = this.context.getString(2131303374);
        AppMethodBeat.o(34200);
        return paramak;
      }
    }
    String str1;
    if ((paramak.field_msgType != null) && ((paramak.field_msgType.equals("47")) || (paramak.field_msgType.equals("1048625"))))
    {
      localObject1 = atE(paramak.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramak = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(34200);
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
              AppMethodBeat.o(34200);
              return paramak;
            }
            paramak = str1 + ": " + paramak;
            AppMethodBeat.o(34200);
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
        break label785;
      }
      if (ah.isNullOrNil(paramak.field_digestUser)) {
        break label774;
      }
      if ((paramak.field_isSend != 0) || (!com.tencent.mm.model.t.lA(paramak.field_username))) {
        break label762;
      }
      localObject1 = s.getDisplayName(paramak.field_digestUser, paramak.field_username);
    }
    label762:
    Object localObject2;
    for (;;)
    {
      label774:
      try
      {
        localObject1 = String.format(paramak.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)) {
          break label816;
        }
        paramak = new SpannableStringBuilder(this.context.getString(2131301397));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(j.b(this.context, str1, paramInt));
        AppMethodBeat.o(34200);
        return paramak;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = s.nE(paramak.field_digestUser);
      continue;
      localObject1 = paramak.field_digest;
      continue;
      label785:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramak.field_isSend, paramak.field_username, paramak.field_content, GH(paramak.field_msgType), this.context);
    }
    label816:
    if ((paramBoolean) && (paramak.field_unReadCount > 1)) {
      localObject2 = this.context.getString(2131301400, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramak = j.b(this.context, (CharSequence)localObject2, paramInt);
      AppMethodBeat.o(34200);
      return paramak;
      localObject2 = str1;
      if (paramak.field_unReadCount > 0)
      {
        localObject2 = str1;
        if (com.tencent.mm.model.t.ot(paramak.field_parentRef))
        {
          localObject2 = str1;
          if (!(this.context instanceof NewBizConversationUI)) {
            localObject2 = this.context.getString(2131301400, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
          }
        }
      }
    }
  }
  
  private static String atE(String paramString)
  {
    AppMethodBeat.i(34201);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(paramString);
      AppMethodBeat.o(34201);
      return paramString;
    }
    AppMethodBeat.o(34201);
    return null;
  }
  
  private void ayq()
  {
    AppMethodBeat.i(34199);
    if (this.zte != null)
    {
      this.zte.clear();
      this.zte = null;
    }
    AppMethodBeat.o(34199);
  }
  
  private void dMq()
  {
    AppMethodBeat.i(34193);
    if (this.zte == null)
    {
      AppMethodBeat.o(34193);
      return;
    }
    Iterator localIterator = this.zte.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((e.d)((Map.Entry)localIterator.next()).getValue()).AhU = null;
    }
    AppMethodBeat.o(34193);
  }
  
  private void dMr()
  {
    AppMethodBeat.i(34204);
    ab.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.AhP), Boolean.valueOf(this.AhQ.dtj()) });
    this.AhP = true;
    if (this.AhQ.dtj()) {
      dMs();
    }
    AppMethodBeat.o(34204);
  }
  
  private void dMs()
  {
    AppMethodBeat.i(34205);
    al.d(new e.2(this));
    AppMethodBeat.o(34205);
  }
  
  private CharSequence h(ak paramak)
  {
    AppMethodBeat.i(34190);
    if (paramak.field_status == 1)
    {
      paramak = this.context.getString(2131301428);
      AppMethodBeat.o(34190);
      return paramak;
    }
    if (paramak.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34190);
      return "";
    }
    paramak = com.tencent.mm.pluginsdk.f.h.c(this.context, paramak.field_conversationTime, true);
    AppMethodBeat.o(34190);
    return paramak;
  }
  
  public void Ku()
  {
    AppMethodBeat.i(34196);
    ab.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.gzX) });
    if (this.gzX)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = aw.aaz().fkq.b(com.tencent.mm.model.t.flc, this.ejc, this.gvZ);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.ejc != null) && (this.ejc.size() > 0)) {
        localArrayList1.addAll(this.ejc);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!com.tencent.mm.model.t.lA(str)) {
            localArrayList2.add(str);
          }
          ab.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(str)));
        }
        if (this.AhB == null) {}
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = aw.aaz().fkr.b(this.gvZ, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.gvZ != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(34196);
      return;
      aw.aaz();
      setCursor(com.tencent.mm.model.c.YF().a(com.tencent.mm.model.t.flc, this.ejc, com.tencent.mm.o.a.euH, false));
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(34191);
    Ku();
    AppMethodBeat.o(34191);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(34202);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(34202);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(34202);
  }
  
  protected void a(ak paramak, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.jSd = paramf;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(34203);
    ab.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.ltg), Boolean.valueOf(this.AhD), paramString });
    if ((!ah.isNullOrNil(paramString)) && (this.zte != null)) {
      this.zte.remove(paramString);
    }
    if (this.ltg)
    {
      dMr();
      AppMethodBeat.o(34203);
      return;
    }
    this.AhD = true;
    AppMethodBeat.o(34203);
  }
  
  protected void a(String paramString, e.g paramg) {}
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34197);
    ak localak = (ak)getItem(paramInt);
    String str = localak.field_username;
    paramViewGroup = this.AhK;
    paramViewGroup.talker = str;
    paramViewGroup.contact = null;
    paramViewGroup.Aih = null;
    paramViewGroup.initialized = false;
    if (!ah.isNullOrNil(str)) {
      paramViewGroup.initialized = true;
    }
    this.AhN = new e.a(this, (byte)0);
    label152:
    Object localObject1;
    label462:
    Object localObject2;
    ad localad;
    label569:
    boolean bool;
    label577:
    label600:
    label623:
    int i;
    label667:
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new e.g();
      if (com.tencent.mm.cb.a.gt(this.context))
      {
        paramView = View.inflate(this.context, 2130969275, null);
        paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label1909;
        }
        a.b.s(paramViewGroup.egq, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.egq.getDrawable();
        if (this.AhC != null) {
          this.AhC.a((d.a)localObject1);
        }
        paramViewGroup.zti = ((NoMeasuredTextView)paramView.findViewById(2131823254));
        paramViewGroup.Aii = ((NoMeasuredTextView)paramView.findViewById(2131821550));
        paramViewGroup.ztj = ((NoMeasuredTextView)paramView.findViewById(2131823255));
        paramViewGroup.ztk = ((NoMeasuredTextView)paramView.findViewById(2131823256));
        paramViewGroup.jSi = ((TextView)paramView.findViewById(2131821087));
        paramViewGroup.jSi.setBackgroundResource(com.tencent.mm.ui.tools.t.iF(this.context));
        paramViewGroup.ztl = ((ImageView)paramView.findViewById(2131823258));
        paramViewGroup.ztn = paramView.findViewById(2131823253);
        paramViewGroup.ztm = ((ImageView)paramView.findViewById(2131823259));
        paramViewGroup.Aij = ((ImageView)paramView.findViewById(2131823260));
        paramView.setTag(paramViewGroup);
        paramViewGroup.ztk.setTextSize(0, this.ztb);
        paramViewGroup.ztj.setTextSize(0, this.ztc);
        paramViewGroup.zti.setTextSize(0, this.zta);
        paramViewGroup.Aii.setTextSize(0, this.ztb);
        paramViewGroup.ztk.setTextColor(this.ztd[0]);
        paramViewGroup.ztj.setTextColor(this.ztd[4]);
        paramViewGroup.zti.setTextColor(this.ztd[3]);
        paramViewGroup.Aii.setTextColor(this.ztd[0]);
        paramViewGroup.ztk.setShouldEllipsize(true);
        paramViewGroup.ztj.setShouldEllipsize(false);
        paramViewGroup.zti.setShouldEllipsize(true);
        paramViewGroup.Aii.setShouldEllipsize(true);
        paramViewGroup.ztj.setGravity(5);
        localObject1 = (e.d)this.zte.get(str);
        if (localObject1 != null) {
          break label2680;
        }
        localObject2 = new e.d(this, (byte)0);
        localObject1 = this.AhK;
        if ((((e.e)localObject1).initialized) && (((e.e)localObject1).contact == null))
        {
          aw.aaz();
          ((e.e)localObject1).contact = com.tencent.mm.model.c.YA().arw(((e.e)localObject1).talker);
        }
        localad = ((e.e)localObject1).contact;
        if (localad == null) {
          break label1932;
        }
        ((e.d)localObject2).AhY = localad.dqS;
        ((e.d)localObject2).AhX = ((int)localad.euF);
        if (localad == null) {
          break label1947;
        }
        bool = true;
        ((e.d)localObject2).Aid = bool;
        if ((localad == null) || (!localad.JY())) {
          break label1953;
        }
        bool = true;
        ((e.d)localObject2).Aif = bool;
        if ((localad == null) || (localad.dqK != 0)) {
          break label1959;
        }
        bool = true;
        ((e.d)localObject2).Aie = bool;
        ((e.d)localObject2).muU = com.tencent.mm.model.t.lA(str);
        if ((!((e.d)localObject2).muU) || (!((e.d)localObject2).Aie) || (localak.field_unReadCount <= 0)) {
          break label1965;
        }
        bool = true;
        ((e.d)localObject2).Aic = bool;
        ((e.d)localObject2).kwo = 0;
        i = GH(localak.field_msgType);
        if ((i == 34) && (localak.field_isSend == 0) && (!ah.isNullOrNil(localak.field_content)))
        {
          localObject3 = localak.field_content;
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
          if (!new com.tencent.mm.modelvoice.p((String)localObject1).fXr) {
            ((e.d)localObject2).kwo = 1;
          }
        }
        if (i == 285212721)
        {
          localObject1 = localak.field_content;
          long l = localak.field_lastSeq;
          com.tencent.mm.sdk.g.d.ysm.b(new e.3(this, (String)localObject1), "tmplPreload");
        }
        localObject1 = s.a(localad, str, ((e.d)localObject2).muU);
        if ((!((e.d)localObject2).muU) || (localObject1 != null)) {
          break label1971;
        }
        ((e.d)localObject2).nickName = this.context.getString(2131298302);
        label930:
        ((e.d)localObject2).AhU = h(localak);
        ((e.d)localObject2).AhV = a(localak, (int)paramViewGroup.ztk.getTextSize(), ((e.d)localObject2).Aic);
        ((e.d)localObject2).Aig = localak.field_attrflag;
        switch (localak.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label1023:
          ((e.d)localObject2).AhW = i;
          ((e.d)localObject2).AhZ = com.tencent.mm.model.t.a(localak);
          aw.aaz();
          ((e.d)localObject2).ztf = com.tencent.mm.model.c.YF().g(localak);
          if ((localad != null) && (localad.DP()))
          {
            bool = true;
            label1075:
            ((e.d)localObject2).Aia = bool;
            ((e.d)localObject2).Aib = aa.dsC();
            this.zte.put(str, localObject2);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    label1157:
    label1220:
    label1250:
    label1385:
    label1909:
    label2680:
    for (;;)
    {
      if (((e.d)localObject1).AhU == null) {
        ((e.d)localObject1).AhU = h(localak);
      }
      if ((((e.d)localObject1).Aic) || (com.tencent.mm.model.t.ot(localak.field_parentRef)))
      {
        paramViewGroup.ztk.setTextColor(this.ztd[0]);
        com.tencent.mm.booter.notification.a.h.is(paramViewGroup.ztk.getWidth());
        com.tencent.mm.booter.notification.a.h.it((int)paramViewGroup.ztk.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(paramViewGroup.ztk.getPaint());
        if (!str.toLowerCase().endsWith("@t.qq.com")) {
          break label2059;
        }
        paramViewGroup.zti.setCompoundRightDrawablesWithIntrinsicBounds(2130839141);
        paramViewGroup.zti.setDrawRightDrawable(true);
        i = ((e.d)localObject1).AhW;
        if (i == -1) {
          break label2070;
        }
        paramViewGroup.ztk.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        paramViewGroup.ztk.setDrawLeftDrawable(true);
        paramViewGroup.Aii.setVisibility(8);
        localObject2 = paramViewGroup.ztj.getLayoutParams();
        if (((e.d)localObject1).AhU.length() <= 9) {
          break label2081;
        }
        if (((ViewGroup.LayoutParams)localObject2).width != this.AhM)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.AhM;
          paramViewGroup.ztj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        ab.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
        paramViewGroup.ztj.setText(((e.d)localObject1).AhU);
        paramViewGroup.ztk.setText(((e.d)localObject1).AhV);
        if ((!((e.d)localObject1).muU) || (!((e.d)localObject1).Aie)) {
          break label2114;
        }
        paramViewGroup.ztl.setVisibility(0);
        if ((!(this.context instanceof BizConversationUI)) && (!(this.context instanceof NewBizConversationUI))) {
          break label2145;
        }
        a.b.s(paramViewGroup.egq, str);
        if (this.AhA)
        {
          if ((localak != null) && (paramViewGroup != null) && (localObject1 != null)) {
            break label2157;
          }
          ab.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        if ((!((e.d)localObject1).AhZ) && (((e.d)localObject1).ztf) && (aw.RG()))
        {
          aw.aaz();
          com.tencent.mm.model.c.YF().f(localak);
        }
        if ((!(this.context instanceof NewBizConversationUI)) || (!((e.d)localObject1).ztf) || (localak.field_conversationTime == -1L)) {
          break label2567;
        }
        localObject2 = this.context.getResources().getDrawable(2130837986);
        i = (int)paramViewGroup.zti.getTextSize();
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
        localObject3 = new SpannableString("@");
        ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
        paramViewGroup.zti.setText(TextUtils.concat(new CharSequence[] { ((e.d)localObject1).nickName, " ", localObject3 }));
        paramView.findViewById(2131823252).setBackgroundResource(2130838445);
        com.tencent.mm.bq.d.dpU();
        localObject2 = new tl();
        ((tl)localObject2).cJT.cJV = true;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 7, 0L)) && (!localak.field_username.equals(((tl)localObject2).cJU.cJX)))
        {
          localak.fL(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 6, localak.field_conversationTime));
          aw.aaz();
          com.tencent.mm.model.c.YF().a(localak, localak.field_username);
        }
        if ((com.tencent.mm.bg.g.fUM != null) && (com.tencent.mm.bg.g.fUM.uL(localak.field_username))) {
          break label2615;
        }
        paramViewGroup.ztm.setVisibility(8);
        if ((com.tencent.mm.bh.d.fUO == null) || (!com.tencent.mm.bh.d.fUO.uO(localak.field_username))) {
          break label2668;
        }
        paramViewGroup.Aij.setVisibility(0);
      }
      for (;;)
      {
        this.AhN.content = String.valueOf(((e.d)localObject1).AhV);
        this.AhN.blZ = String.valueOf(((e.d)localObject1).nickName);
        this.AhN.AhT = String.valueOf(((e.d)localObject1).AhU);
        localObject2 = this.AhN;
        a.a.dDt().a(paramView, ((e.a)localObject2).blZ, ((e.a)localObject2).AhS, ((e.a)localObject2).AhT, ((e.a)localObject2).content);
        a(str, paramViewGroup);
        a(localak, ((e.d)localObject1).ztf, paramInt, false);
        AppMethodBeat.o(34197);
        return paramView;
        paramView = View.inflate(this.context, 2130969274, null);
        break;
        a.b.c(paramViewGroup.egq, str);
        break label152;
        paramViewGroup = (e.g)paramView.getTag();
        break label462;
        ((e.d)localObject2).AhY = -1;
        ((e.d)localObject2).AhX = -1;
        break label569;
        bool = false;
        break label577;
        bool = false;
        break label600;
        bool = false;
        break label623;
        bool = false;
        break label667;
        ((e.d)localObject2).nickName = j.b(this.context, s.a(localad, str, ((e.d)localObject2).muU), paramViewGroup.zti.getTextSize());
        break label930;
        i = -1;
        break label1023;
        i = 2131231716;
        break label1023;
        i = -1;
        break label1023;
        i = 2131231715;
        break label1023;
        bool = false;
        break label1075;
        paramViewGroup.ztk.setTextColor(this.ztd[localObject1.kwo]);
        break label1157;
        paramViewGroup.zti.setDrawRightDrawable(false);
        break label1220;
        paramViewGroup.ztk.setDrawLeftDrawable(false);
        break label1250;
        if (((ViewGroup.LayoutParams)localObject2).width == this.AhL) {
          break label1313;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.AhL;
        paramViewGroup.ztj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1313;
        if (((e.d)localObject1).Aia)
        {
          paramViewGroup.ztl.setVisibility(0);
          break label1385;
        }
        paramViewGroup.ztl.setVisibility(8);
        break label1385;
        a.b.c(paramViewGroup.egq, str);
        break label1414;
        paramViewGroup.jSi.setVisibility(4);
        paramViewGroup.ztn.setVisibility(4);
        if (com.tencent.mm.model.t.ot(localak.field_username))
        {
          localObject2 = paramViewGroup.ztn;
          if (localak.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            paramViewGroup.zti.setTextColor(this.ztd[3]);
            break;
          }
        }
        localObject3 = paramViewGroup.zti;
        if ((((e.d)localObject1).Aid) && (((e.d)localObject1).AhY == 1)) {}
        for (localObject2 = this.ztd[2];; localObject2 = this.ztd[3])
        {
          ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
          if ((((e.d)localObject1).Aid) && (((e.d)localObject1).AhX != 0)) {
            break label2307;
          }
          ab.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (com.tencent.mm.model.t.ot(localak.field_parentRef))
        {
          if ((this.context instanceof NewBizConversationUI)) {
            break label1444;
          }
          localObject2 = paramViewGroup.ztn;
          if (localak.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((e.d)localObject1).Aia) && (((e.d)localObject1).Aif))
        {
          localObject2 = paramViewGroup.ztn;
          if (localak.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((e.d)localObject1).muU) && (((e.d)localObject1).Aie))
        {
          localObject2 = paramViewGroup.ztn;
          if (localak.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        i = localak.field_unReadCount;
        if (i > 99)
        {
          paramViewGroup.jSi.setText("");
          paramViewGroup.jSi.setBackgroundResource(2131230963);
          paramViewGroup.jSi.setVisibility(0);
        }
        for (;;)
        {
          this.AhN.AhS = i;
          break;
          if (i > 0)
          {
            paramViewGroup.jSi.setText(localak.field_unReadCount);
            paramViewGroup.jSi.setBackgroundResource(com.tencent.mm.ui.tools.t.iF(this.context));
            paramViewGroup.jSi.setVisibility(0);
          }
        }
        paramViewGroup.zti.setText(((e.d)localObject1).nickName);
        if ((!((e.d)localObject1).ztf) || (localak.field_conversationTime == -1L)) {
          break label1614;
        }
        paramView.findViewById(2131823252).setBackgroundResource(2130838444);
        break label1627;
        paramViewGroup.ztm.setVisibility(0);
        if (localak.field_username.equals(((tl)localObject2).cJU.cJX))
        {
          paramViewGroup.ztm.setImageResource(2131232073);
          break label1758;
        }
        paramViewGroup.ztm.setImageResource(2131232072);
        break label1758;
        paramViewGroup.Aij.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(34195);
    this.AhQ.stopTimer();
    this.AhI = null;
    this.AhG = null;
    ayq();
    bKb();
    dAW();
    detach();
    AppMethodBeat.o(34195);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(34192);
    if (this.jSe != null) {
      this.jSe.bKk();
    }
    this.ltg = false;
    AppMethodBeat.o(34192);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(34194);
    ab.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.ltg), Boolean.valueOf(this.AhE), Boolean.valueOf(this.AhD), Boolean.valueOf(this.AhF) });
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
      if ((this.AhE) && (this.AhI != null)) {
        this.AhE = false;
      }
      if ((this.AhD) || (this.AhF))
      {
        super.a(null, null);
        this.AhD = false;
        this.AhF = false;
      }
      AppMethodBeat.o(34194);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */