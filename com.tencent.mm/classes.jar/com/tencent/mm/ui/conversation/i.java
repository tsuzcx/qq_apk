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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
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
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class i
  extends com.tencent.mm.ui.r<ak>
  implements m.b
{
  private static long vQe = 2000L;
  private String bUU;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.f hZf;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  private boolean vPS = false;
  private boolean vPT = false;
  public String vPZ = "";
  private final int vQb;
  private final int vQc;
  private boolean vQf = false;
  am vQg = new am(au.DS().mnU.getLooper(), new i.1(this), false);
  private ColorStateList[] vSI = new ColorStateList[5];
  private float veB = -1.0F;
  private float veC = -1.0F;
  private float veD = -1.0F;
  HashMap<String, i.a> veF;
  
  public i(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, new ak());
    this.uMi = parama;
    this.bUU = paramString;
    this.veF = new HashMap();
    this.vSI[0] = com.tencent.mm.cb.a.h(paramContext, R.e.hint_text_color);
    this.vSI[1] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_unread);
    this.vSI[3] = com.tencent.mm.cb.a.h(paramContext, R.e.normal_text_color);
    this.vSI[2] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_three);
    this.vSI[2] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_three);
    this.vSI[4] = com.tencent.mm.cb.a.h(paramContext, R.e.light_text_color);
    if (com.tencent.mm.cb.a.fh(paramContext)) {
      this.vQc = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
    }
    for (this.vQb = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);; this.vQb = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth))
    {
      this.veB = com.tencent.mm.cb.a.aa(paramContext, R.f.NormalTextSize);
      this.veC = com.tencent.mm.cb.a.aa(paramContext, R.f.HintTextSize);
      this.veD = com.tencent.mm.cb.a.aa(paramContext, R.f.SmallestTextSize);
      au.Hx();
      c.FB().a(this);
      return;
      this.vQc = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
    }
  }
  
  private static String adj(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 32)) {
      return ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(paramString);
    }
    return null;
  }
  
  private CharSequence c(ak paramak, int paramInt, boolean paramBoolean)
  {
    if ((!ah.bl(paramak.field_editingMsg)) && ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_last_editing_msg_prefix));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(j.b(this.context, paramak.field_editingMsg, paramInt));
      return localObject1;
    }
    Object localObject1 = paramak.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
      return new SpannableString(j.c(this.context, (CharSequence)localObject1, paramInt));
    }
    String str1;
    if ((j(paramak) == 47) || (j(paramak) == 1048625))
    {
      localObject1 = adj(paramak.field_digest);
      str1 = "";
      if (localObject1 != null) {
        return "[" + (String)localObject1 + "]";
      }
      localObject1 = str1;
      if (paramak.field_digest != null)
      {
        localObject1 = str1;
        if (paramak.field_digest.contains(":"))
        {
          str1 = paramak.field_digest.substring(0, paramak.field_digest.indexOf(":"));
          String str2 = adj(paramak.field_digest.substring(paramak.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramak = "[" + str2 + "]";
            if (ah.bl(str1)) {
              return paramak;
            }
            return str1 + ": " + paramak;
          }
        }
      }
      str1 = this.context.getString(R.l.app_emoji);
      if (ah.bl((String)localObject1))
      {
        localObject1 = str1;
        paramak.dQ((String)localObject1);
      }
    }
    else
    {
      if (ah.bl(paramak.field_digest)) {
        break label585;
      }
      if (ah.bl(paramak.field_digestUser)) {
        break label574;
      }
      if ((paramak.field_isSend != 0) || (!s.fn(paramak.field_username))) {
        break label562;
      }
      localObject1 = com.tencent.mm.model.r.getDisplayName(paramak.field_digestUser, paramak.field_username);
    }
    for (;;)
    {
      label562:
      label574:
      try
      {
        localObject1 = String.format(paramak.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)) {
          break label613;
        }
        paramak = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_chatroom_at_hint));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(j.b(this.context, str1, paramInt));
        return paramak;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = com.tencent.mm.model.r.gV(paramak.field_digestUser);
      continue;
      localObject1 = paramak.field_digest;
      continue;
      label585:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramak.field_isSend, paramak.field_username, paramak.field_content, j(paramak), this.context);
    }
    label613:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramak.field_unReadCount > 1) {
        localObject2 = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
      }
    }
    return j.b(this.context, (CharSequence)localObject2, paramInt);
  }
  
  private void cHW()
  {
    if (this.veF == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.veF.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((i.a)((Map.Entry)localIterator.next()).getValue()).vQk = null;
      }
    }
  }
  
  private void cHX()
  {
    ai.d(new i.2(this));
  }
  
  private CharSequence h(ak paramak)
  {
    if (paramak.field_status == 1) {
      return this.context.getString(R.l.main_sending);
    }
    if (paramak.field_conversationTime == 9223372036854775807L) {
      return "";
    }
    return com.tencent.mm.pluginsdk.f.h.c(this.context, paramak.field_conversationTime, true);
  }
  
  private static int j(ak paramak)
  {
    int j = 1;
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
      return i;
    }
    catch (NumberFormatException paramak) {}
    return 1;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      y.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.hZf = paramf;
  }
  
  public final void a(String paramString, l paraml)
  {
    y.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.vPS), Boolean.valueOf(this.vPT), paramString });
    if ((!ah.bl(paramString)) && (this.veF != null)) {
      this.veF.remove(paramString);
    }
    if (this.vPS)
    {
      y.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.vQf), Boolean.valueOf(this.vQg.crl()) });
      this.vQf = true;
      if (this.vQg.crl()) {
        cHX();
      }
      return;
    }
    this.vPT = true;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ak localak = (ak)getItem(paramInt);
    String str = localak.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.cb.a.fh(this.context))
      {
        paramView = View.inflate(this.context, R.i.conversation_item_large, null);
        paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
        paramViewGroup.vSL = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
        paramViewGroup.vSL.setTextSize(0, this.veB);
        paramViewGroup.vSL.setTextColor(this.vSI[3]);
        paramViewGroup.vSL.setShouldEllipsize(true);
        paramViewGroup.vSM = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
        paramViewGroup.vSM.setTextSize(0, this.veD);
        paramViewGroup.vSM.setTextColor(this.vSI[4]);
        paramViewGroup.vSM.setShouldEllipsize(false);
        paramViewGroup.vSM.setGravity(5);
        paramViewGroup.vSN = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
        paramViewGroup.vSN.setTextSize(0, this.veC);
        paramViewGroup.vSN.setTextColor(this.vSI[0]);
        paramViewGroup.vSN.setShouldEllipsize(true);
        paramViewGroup.vSO = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
        paramViewGroup.vSO.setBackgroundResource(q.hh(this.context));
        paramViewGroup.veM = ((ImageView)paramView.findViewById(R.h.image_mute));
        paramViewGroup.veO = paramView.findViewById(R.h.avatar_prospect_iv);
        paramView.findViewById(R.h.talkroom_iv).setVisibility(8);
        paramView.findViewById(R.h.location_share_iv).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      i.a locala = (i.a)this.veF.get(str);
      au.Hx();
      Object localObject = c.Fw().abl(str);
      label376:
      boolean bool;
      if (locala == null)
      {
        locala = new i.a(this, (byte)0);
        if (localObject != null)
        {
          locala.vQn = ((int)((com.tencent.mm.n.a)localObject).dBe);
          if (localObject == null) {
            break label1083;
          }
          bool = true;
          label384:
          locala.vQt = bool;
          if ((localObject == null) || (!((ad)localObject).xG())) {
            break label1089;
          }
          bool = true;
          label407:
          locala.vQv = bool;
          if ((localObject == null) || (!((ad)localObject).Bj())) {
            break label1095;
          }
          bool = true;
          label430:
          locala.vQq = bool;
          if (localak.field_unReadCount <= 0) {
            break label1101;
          }
          bool = true;
          label448:
          locala.vSK = bool;
          locala.ivk = 0;
          if ((j(localak) == 34) && (localak.field_isSend == 0) && (!ah.bl(localak.field_content)) && (!new n(localak.field_content).eHB)) {
            locala.ivk = 1;
          }
          locala.nickName = j.a(this.context, com.tencent.mm.model.r.a((ad)localObject, str, false), paramViewGroup.vSL.getTextSize());
          locala.vQk = h(localak);
          paramInt = (int)paramViewGroup.vSN.getTextSize();
          if ((!locala.vQq) || (!locala.vSK)) {
            break label1107;
          }
          bool = true;
          label580:
          locala.vQl = c(localak, paramInt, bool);
          locala.vQw = localak.field_attrflag;
          switch (localak.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label650:
            locala.vQm = paramInt;
            au.Hx();
            locala.veG = c.FB().g(localak);
            locala.vQr = x.cqF();
            this.veF.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.vQk == null) {
          locala.vQk = h(localak);
        }
        if ((locala.vQq) && (locala.vSK))
        {
          paramViewGroup.vSN.setTextColor(this.vSI[0]);
          label743:
          com.tencent.mm.booter.notification.a.h.gc(paramViewGroup.vSN.getWidth());
          com.tencent.mm.booter.notification.a.h.gd((int)paramViewGroup.vSN.getTextSize());
          com.tencent.mm.booter.notification.a.h.a(paramViewGroup.vSN.getPaint());
          if (locala.vQm == -1) {
            break label1157;
          }
          paramViewGroup.vSN.setCompoundLeftDrawablesWithIntrinsicBounds(locala.vQm);
          paramViewGroup.vSN.setDrawLeftDrawable(true);
          label803:
          paramViewGroup.vSN.setText(locala.vQl);
          paramViewGroup.vSL.setDrawRightDrawable(false);
          paramViewGroup.vSL.setText(locala.nickName);
          localObject = paramViewGroup.vSM.getLayoutParams();
          if (locala.vQk.length() <= 9) {
            break label1168;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.vQc)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.vQc;
            paramViewGroup.vSM.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label889:
          paramViewGroup.vSM.setText(locala.vQk);
          if (!locala.vQq) {
            break label1201;
          }
          paramViewGroup.veM.setVisibility(0);
          label917:
          a.b.a(paramViewGroup.doU, str);
          paramViewGroup.vSO.setVisibility(4);
          paramViewGroup.veO.setVisibility(4);
          if ((locala.vQt) && (locala.vQn != 0))
          {
            paramInt = localak.field_unReadCount;
            if (!locala.vQq) {
              break label1218;
            }
            paramViewGroup = paramViewGroup.veO;
            if (paramInt <= 0) {
              break label1213;
            }
            paramInt = 0;
            label983:
            paramViewGroup.setVisibility(paramInt);
          }
          label988:
          if ((!locala.veG) || (localak.field_conversationTime == -1L)) {
            break label1271;
          }
          paramView.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
        }
        for (;;)
        {
          a.a.cAj().a(paramView, String.valueOf(locala.nickName), localak.field_unReadCount, String.valueOf(locala.vQk), String.valueOf(locala.vQl));
          return paramView;
          paramView = View.inflate(this.context, R.i.conversation_item, null);
          break;
          locala.vQn = -1;
          break label376;
          label1083:
          bool = false;
          break label384;
          label1089:
          bool = false;
          break label407;
          label1095:
          bool = false;
          break label430;
          label1101:
          bool = false;
          break label448;
          label1107:
          bool = false;
          break label580;
          paramInt = -1;
          break label650;
          paramInt = R.k.msg_state_sending;
          break label650;
          paramInt = -1;
          break label650;
          paramInt = R.k.msg_state_failed;
          break label650;
          paramViewGroup.vSN.setTextColor(this.vSI[locala.ivk]);
          break label743;
          label1157:
          paramViewGroup.vSN.setDrawLeftDrawable(false);
          break label803;
          label1168:
          if (((ViewGroup.LayoutParams)localObject).width == this.vQb) {
            break label889;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.vQb;
          paramViewGroup.vSM.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label889;
          label1201:
          paramViewGroup.veM.setVisibility(8);
          break label917;
          label1213:
          paramInt = 4;
          break label983;
          label1218:
          if (paramInt > 99)
          {
            paramViewGroup.vSO.setText(R.l.unread_count_overt_100);
            paramViewGroup.vSO.setVisibility(0);
            break label988;
          }
          if (paramInt <= 0) {
            break label988;
          }
          paramViewGroup.vSO.setText(String.valueOf(paramInt));
          paramViewGroup.vSO.setVisibility(0);
          break label988;
          label1271:
          paramView.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
        }
      }
    }
  }
  
  public final void onPause()
  {
    if (this.hZg != null) {
      this.hZg.bdb();
    }
    this.vPS = false;
  }
  
  public final void onResume()
  {
    int i = 1;
    this.vPS = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.f.g.a("MM/dd", (Time)localObject).toString();
    if (!this.vPZ.equals(localObject)) {}
    for (;;)
    {
      this.vPZ = ((String)localObject);
      if (i != 0) {
        cHW();
      }
      if (this.vPT)
      {
        super.a(null, null);
        this.vPT = false;
      }
      return;
      i = 0;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public final void yc()
  {
    bcS();
    au.Hx();
    setCursor(c.FB().c(s.dUT, null, this.bUU));
    if (this.uMi != null) {
      this.uMi.Wp();
    }
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
  
  public static final class b
  {
    public ImageView doU;
    public NoMeasuredTextView vSL;
    public NoMeasuredTextView vSM;
    public NoMeasuredTextView vSN;
    public TextView vSO;
    public ImageView veM;
    public View veO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.i
 * JD-Core Version:    0.7.0.1
 */