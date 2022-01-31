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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.a;
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
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends com.tencent.mm.ui.r<ak>
  implements m.b
{
  private static long vQe = 2000L;
  protected List<String> dru = null;
  private String feq;
  private boolean fiq = false;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.f hZf;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  boolean oPd = false;
  private boolean vPP = true;
  private e.f vPQ;
  private com.tencent.mm.pluginsdk.ui.d vPR;
  private boolean vPS = false;
  private boolean vPT = false;
  private boolean vPU = false;
  private boolean vPV = false;
  private c vPW;
  private com.tencent.mm.sdk.b.c vPX = null;
  private e.b vPY = null;
  public String vPZ = "";
  final e vQa = new e();
  private final int vQb;
  private final int vQc;
  private e.a vQd;
  private boolean vQf = false;
  private am vQg = new am(au.DS().mnU.getLooper(), new e.1(this), false);
  private float veB = -1.0F;
  protected float veC = -1.0F;
  private float veD = -1.0F;
  private ColorStateList[] veE = new ColorStateList[5];
  HashMap<String, d> veF;
  
  public e(Context paramContext, r.a parama)
  {
    super(paramContext, new ak());
    this.uMi = parama;
    this.veE[0] = com.tencent.mm.cb.a.h(paramContext, R.e.hint_text_color);
    this.veE[1] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_unread);
    this.veE[3] = com.tencent.mm.cb.a.h(paramContext, R.e.normal_text_color);
    this.veE[2] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_three);
    this.veE[2] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_three);
    this.veE[4] = com.tencent.mm.cb.a.h(paramContext, R.e.light_text_color);
    this.veF = new HashMap();
    if (com.tencent.mm.cb.a.fh(paramContext)) {
      this.vQc = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
    }
    for (this.vQb = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);; this.vQb = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth))
    {
      this.veB = com.tencent.mm.cb.a.aa(paramContext, R.f.NormalTextSize);
      this.veC = com.tencent.mm.cb.a.aa(paramContext, R.f.HintTextSize);
      this.veD = com.tencent.mm.cb.a.aa(paramContext, R.f.SmallestTextSize);
      return;
      this.vQc = paramContext.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
    }
  }
  
  private CharSequence a(ak paramak, int paramInt, boolean paramBoolean)
  {
    if ((!ah.bl(paramak.field_editingMsg)) && ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_last_editing_msg_prefix));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, paramak.field_editingMsg, paramInt));
      return localObject1;
    }
    Object localObject1 = paramak.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
      return new SpannableString(com.tencent.mm.pluginsdk.ui.d.j.c(this.context, (CharSequence)localObject1, paramInt));
    }
    localObject1 = paramak.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      au.Hx();
      if (ah.g((Integer)com.tencent.mm.model.c.Dz().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0) {
        return this.context.getString(R.l.settings_plugins_disable);
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      au.Hx();
      localObject1 = com.tencent.mm.model.c.FE().Ic("@t.qq.com");
      if ((localObject1 != null) && (((bq)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0) {
        return this.context.getString(R.l.settings_plugins_disable);
      }
    }
    String str1;
    if ((paramak.field_msgType != null) && ((paramak.field_msgType.equals("47")) || (paramak.field_msgType.equals("1048625"))))
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
        break label730;
      }
      if (ah.bl(paramak.field_digestUser)) {
        break label719;
      }
      if ((paramak.field_isSend != 0) || (!s.fn(paramak.field_username))) {
        break label707;
      }
      localObject1 = com.tencent.mm.model.r.getDisplayName(paramak.field_digestUser, paramak.field_username);
    }
    label707:
    label719:
    label730:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramak.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)) {
          break label761;
        }
        paramak = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_chatroom_at_hint));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, str1, paramInt));
        return paramak;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = com.tencent.mm.model.r.gV(paramak.field_digestUser);
      continue;
      localObject1 = paramak.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramak.field_isSend, paramak.field_username, paramak.field_content, xP(paramak.field_msgType), this.context);
    }
    label761:
    if ((paramBoolean) && (paramak.field_unReadCount > 1)) {
      localObject2 = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
    }
    for (;;)
    {
      return com.tencent.mm.pluginsdk.ui.d.j.b(this.context, (CharSequence)localObject2, paramInt);
      localObject2 = str1;
      if (paramak.field_unReadCount > 0)
      {
        localObject2 = str1;
        if (s.hK(paramak.field_parentRef))
        {
          localObject2 = str1;
          if (!(this.context instanceof NewBizConversationUI)) {
            localObject2 = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
          }
        }
      }
    }
  }
  
  private static String adj(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 32)) {
      return ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(paramString);
    }
    return null;
  }
  
  private void cHW()
  {
    if (this.veF == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.veF.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((d)((Map.Entry)localIterator.next()).getValue()).vQk = null;
      }
    }
  }
  
  private void cHX()
  {
    ai.d(new e.2(this));
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
  
  private static int xP(String paramString)
  {
    int j = 1;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 1;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      y.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  protected void a(ak paramak, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.hZf = paramf;
  }
  
  public final void a(String paramString, l paraml)
  {
    y.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.vPS), Boolean.valueOf(this.vPT), paramString });
    if ((!ah.bl(paramString)) && (this.veF != null)) {
      this.veF.remove(paramString);
    }
    if (this.vPS)
    {
      y.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.vQf), Boolean.valueOf(this.vQg.crl()) });
      this.vQf = true;
      if (this.vQg.crl()) {
        cHX();
      }
      return;
    }
    this.vPT = true;
  }
  
  protected void a(String paramString, e.g paramg) {}
  
  public void detach() {}
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ak localak = (ak)getItem(paramInt);
    String str = localak.field_username;
    paramViewGroup = this.vQa;
    paramViewGroup.talker = str;
    paramViewGroup.dnp = null;
    paramViewGroup.vQx = null;
    paramViewGroup.initialized = false;
    if (!ah.bl(str)) {
      paramViewGroup.initialized = true;
    }
    this.vQd = new e.a(this, (byte)0);
    Object localObject1;
    label436:
    Object localObject2;
    ad localad;
    label543:
    boolean bool;
    label551:
    label574:
    label597:
    Object localObject3;
    label641:
    label857:
    int i;
    if (paramView == null)
    {
      paramViewGroup = new e.g();
      if (com.tencent.mm.cb.a.fh(this.context))
      {
        paramView = View.inflate(this.context, R.i.conversation_item_large, null);
        paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
        a.b.a(paramViewGroup.doU, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.doU.getDrawable();
        if (this.vPR != null) {
          this.vPR.a((d.a)localObject1);
        }
        paramViewGroup.veJ = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
        paramViewGroup.vQy = ((NoMeasuredTextView)paramView.findViewById(R.h.source_tv));
        paramViewGroup.veK = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
        paramViewGroup.veL = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
        paramViewGroup.hZk = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
        paramViewGroup.hZk.setBackgroundResource(q.hh(this.context));
        paramViewGroup.veM = ((ImageView)paramView.findViewById(R.h.image_mute));
        paramViewGroup.veO = paramView.findViewById(R.h.avatar_prospect_iv);
        paramViewGroup.veN = ((ImageView)paramView.findViewById(R.h.talkroom_iv));
        paramViewGroup.vQz = ((ImageView)paramView.findViewById(R.h.location_share_iv));
        paramView.setTag(paramViewGroup);
        paramViewGroup.veL.setTextSize(0, this.veC);
        paramViewGroup.veK.setTextSize(0, this.veD);
        paramViewGroup.veJ.setTextSize(0, this.veB);
        paramViewGroup.vQy.setTextSize(0, this.veC);
        paramViewGroup.veL.setTextColor(this.veE[0]);
        paramViewGroup.veK.setTextColor(this.veE[4]);
        paramViewGroup.veJ.setTextColor(this.veE[3]);
        paramViewGroup.vQy.setTextColor(this.veE[0]);
        paramViewGroup.veL.setShouldEllipsize(true);
        paramViewGroup.veK.setShouldEllipsize(false);
        paramViewGroup.veJ.setShouldEllipsize(true);
        paramViewGroup.vQy.setShouldEllipsize(true);
        paramViewGroup.veK.setGravity(5);
        localObject1 = (d)this.veF.get(str);
        if (localObject1 != null) {
          break label2531;
        }
        localObject2 = new d((byte)0);
        localObject1 = this.vQa;
        if ((((e)localObject1).initialized) && (((e)localObject1).dnp == null))
        {
          au.Hx();
          ((e)localObject1).dnp = com.tencent.mm.model.c.Fw().abl(((e)localObject1).talker);
        }
        localad = ((e)localObject1).dnp;
        if (localad == null) {
          break label1818;
        }
        ((d)localObject2).vQo = localad.cCI;
        ((d)localObject2).vQn = ((int)localad.dBe);
        if (localad == null) {
          break label1833;
        }
        bool = true;
        ((d)localObject2).vQt = bool;
        if ((localad == null) || (!localad.xG())) {
          break label1839;
        }
        bool = true;
        ((d)localObject2).vQv = bool;
        if ((localad == null) || (localad.cCy != 0)) {
          break label1845;
        }
        bool = true;
        ((d)localObject2).vQu = bool;
        ((d)localObject2).kay = s.fn(str);
        if ((!((d)localObject2).kay) || (!((d)localObject2).vQu) || (localak.field_unReadCount <= 0)) {
          break label1851;
        }
        bool = true;
        ((d)localObject2).vQs = bool;
        ((d)localObject2).ivk = 0;
        if ((xP(localak.field_msgType) == 34) && (localak.field_isSend == 0) && (!ah.bl(localak.field_content)))
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
          if (!new n((String)localObject1).eHB) {
            ((d)localObject2).ivk = 1;
          }
        }
        localObject1 = com.tencent.mm.model.r.a(localad, str, ((d)localObject2).kay);
        if ((!((d)localObject2).kay) || (localObject1 != null)) {
          break label1857;
        }
        ((d)localObject2).nickName = this.context.getString(R.l.chatting_roominfo_noname);
        ((d)localObject2).vQk = h(localak);
        ((d)localObject2).vQl = a(localak, (int)paramViewGroup.veL.getTextSize(), ((d)localObject2).vQs);
        ((d)localObject2).vQw = localak.field_attrflag;
        switch (localak.field_status)
        {
        case 3: 
        case 4: 
        default: 
          i = -1;
          label947:
          ((d)localObject2).vQm = i;
          ((d)localObject2).vQp = s.a(localak);
          au.Hx();
          ((d)localObject2).veG = com.tencent.mm.model.c.FB().g(localak);
          if ((localad != null) && (localad.Bj()))
          {
            bool = true;
            label999:
            ((d)localObject2).vQq = bool;
            ((d)localObject2).vQr = x.cqF();
            this.veF.put(str, localObject2);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    label1081:
    label1237:
    label2519:
    label2531:
    for (;;)
    {
      if (((d)localObject1).vQk == null) {
        ((d)localObject1).vQk = h(localak);
      }
      if ((((d)localObject1).vQs) || (s.hK(localak.field_parentRef)))
      {
        paramViewGroup.veL.setTextColor(this.veE[0]);
        com.tencent.mm.booter.notification.a.h.gc(paramViewGroup.veL.getWidth());
        com.tencent.mm.booter.notification.a.h.gd((int)paramViewGroup.veL.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(paramViewGroup.veL.getPaint());
        if (!str.toLowerCase().endsWith("@t.qq.com")) {
          break label1945;
        }
        paramViewGroup.veJ.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
        paramViewGroup.veJ.setDrawRightDrawable(true);
        label1144:
        i = ((d)localObject1).vQm;
        if (i == -1) {
          break label1956;
        }
        paramViewGroup.veL.setCompoundLeftDrawablesWithIntrinsicBounds(i);
        paramViewGroup.veL.setDrawLeftDrawable(true);
        paramViewGroup.vQy.setVisibility(8);
        localObject2 = paramViewGroup.veK.getLayoutParams();
        if (((d)localObject1).vQk.length() <= 9) {
          break label1967;
        }
        if (((ViewGroup.LayoutParams)localObject2).width != this.vQc)
        {
          ((ViewGroup.LayoutParams)localObject2).width = this.vQc;
          paramViewGroup.veK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        y.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
        paramViewGroup.veK.setText(((d)localObject1).vQk);
        paramViewGroup.veL.setText(((d)localObject1).vQl);
        if ((!((d)localObject1).kay) || (!((d)localObject1).vQu)) {
          break label2000;
        }
        paramViewGroup.veM.setVisibility(0);
        a.b.a(paramViewGroup.doU, str);
        if (this.vPP)
        {
          if ((localak != null) && (paramViewGroup != null) && (localObject1 != null)) {
            break label2031;
          }
          y.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
        }
        if ((!((d)localObject1).vQp) && (((d)localObject1).veG) && (au.DK()))
        {
          au.Hx();
          com.tencent.mm.model.c.FB().f(localak);
        }
        if ((!(this.context instanceof NewBizConversationUI)) || (!((d)localObject1).veG) || (localak.field_conversationTime == -1L)) {
          break label2418;
        }
        localObject2 = this.context.getResources().getDrawable(R.g.biz_timeline_star_icon);
        i = (int)paramViewGroup.veJ.getTextSize();
        ((Drawable)localObject2).setBounds(0, 0, i, i);
        localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
        localObject3 = new SpannableString("@");
        ((SpannableString)localObject3).setSpan(localObject2, 0, 1, 33);
        paramViewGroup.veJ.setText(TextUtils.concat(new CharSequence[] { ((d)localObject1).nickName, " ", localObject3 }));
        label1518:
        paramView.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
        label1531:
        com.tencent.mm.br.d.coz();
        localObject2 = new ru();
        ((ru)localObject2).cbq.cbs = true;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 7, 0L)) && (!localak.field_username.equals(((ru)localObject2).cbr.cbu)))
        {
          localak.bb(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 6, localak.field_conversationTime));
          au.Hx();
          com.tencent.mm.model.c.FB().a(localak, localak.field_username);
        }
        if ((com.tencent.mm.bf.g.eEV != null) && (com.tencent.mm.bf.g.eEV.nx(localak.field_username))) {
          break label2466;
        }
        paramViewGroup.veN.setVisibility(8);
        label1662:
        if ((com.tencent.mm.bg.d.eEX == null) || (!com.tencent.mm.bg.d.eEX.nA(localak.field_username))) {
          break label2519;
        }
        paramViewGroup.vQz.setVisibility(0);
      }
      for (;;)
      {
        this.vQd.content = String.valueOf(((d)localObject1).vQl);
        this.vQd.aVr = String.valueOf(((d)localObject1).nickName);
        this.vQd.vQj = String.valueOf(((d)localObject1).vQk);
        localObject2 = this.vQd;
        a.a.cAj().a(paramView, ((e.a)localObject2).aVr, ((e.a)localObject2).vQi, ((e.a)localObject2).vQj, ((e.a)localObject2).content);
        a(str, paramViewGroup);
        a(localak, ((d)localObject1).veG, paramInt, false);
        return paramView;
        paramView = View.inflate(this.context, R.i.conversation_item, null);
        break;
        paramViewGroup = (e.g)paramView.getTag();
        break label436;
        ((d)localObject2).vQo = -1;
        ((d)localObject2).vQn = -1;
        break label543;
        bool = false;
        break label551;
        bool = false;
        break label574;
        bool = false;
        break label597;
        bool = false;
        break label641;
        ((d)localObject2).nickName = com.tencent.mm.pluginsdk.ui.d.j.a(this.context, com.tencent.mm.model.r.a(localad, str, ((d)localObject2).kay), paramViewGroup.veJ.getTextSize());
        break label857;
        i = -1;
        break label947;
        i = R.k.msg_state_sending;
        break label947;
        i = -1;
        break label947;
        i = R.k.msg_state_failed;
        break label947;
        bool = false;
        break label999;
        paramViewGroup.veL.setTextColor(this.veE[localObject1.ivk]);
        break label1081;
        paramViewGroup.veJ.setDrawRightDrawable(false);
        break label1144;
        paramViewGroup.veL.setDrawLeftDrawable(false);
        break label1174;
        if (((ViewGroup.LayoutParams)localObject2).width == this.vQb) {
          break label1237;
        }
        ((ViewGroup.LayoutParams)localObject2).width = this.vQb;
        paramViewGroup.veK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break label1237;
        if (((d)localObject1).vQq)
        {
          paramViewGroup.veM.setVisibility(0);
          break label1309;
        }
        paramViewGroup.veM.setVisibility(8);
        break label1309;
        label2031:
        paramViewGroup.hZk.setVisibility(4);
        paramViewGroup.veO.setVisibility(4);
        if (s.hK(localak.field_username))
        {
          localObject2 = paramViewGroup.veO;
          if (localak.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            paramViewGroup.veJ.setTextColor(this.veE[3]);
            break;
          }
        }
        localObject3 = paramViewGroup.veJ;
        if ((((d)localObject1).vQt) && (((d)localObject1).vQo == 1)) {}
        for (localObject2 = this.veE[2];; localObject2 = this.veE[3])
        {
          ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
          if ((((d)localObject1).vQt) && (((d)localObject1).vQn != 0)) {
            break label2181;
          }
          y.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
          break;
        }
        if (s.hK(localak.field_parentRef))
        {
          if ((this.context instanceof NewBizConversationUI)) {
            break label1348;
          }
          localObject2 = paramViewGroup.veO;
          if (localak.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).vQq) && (((d)localObject1).vQv))
        {
          localObject2 = paramViewGroup.veO;
          if (localak.field_unReadCount > 0) {}
          for (i = 0;; i = 4)
          {
            ((View)localObject2).setVisibility(i);
            break;
          }
        }
        if ((((d)localObject1).kay) && (((d)localObject1).vQu))
        {
          localObject2 = paramViewGroup.veO;
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
          paramViewGroup.hZk.setText(R.l.unread_count_overt_100);
          paramViewGroup.hZk.setVisibility(0);
        }
        for (;;)
        {
          this.vQd.vQi = i;
          break;
          if (i > 0)
          {
            paramViewGroup.hZk.setText(localak.field_unReadCount);
            paramViewGroup.hZk.setVisibility(0);
          }
        }
        label2418:
        paramViewGroup.veJ.setText(((d)localObject1).nickName);
        if ((!((d)localObject1).veG) || (localak.field_conversationTime == -1L)) {
          break label1518;
        }
        paramView.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
        break label1531;
        paramViewGroup.veN.setVisibility(0);
        if (localak.field_username.equals(((ru)localObject2).cbr.cbu))
        {
          paramViewGroup.veN.setImageResource(R.k.talk_room_mic_speaking);
          break label1662;
        }
        paramViewGroup.veN.setImageResource(R.k.talk_room_mic_idle);
        break label1662;
        paramViewGroup.vQz.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    this.vQg.stopTimer();
    this.vPY = null;
    this.vPW = null;
    if (this.veF != null)
    {
      this.veF.clear();
      this.veF = null;
    }
    bcS();
    this.uMi = null;
    detach();
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
    y.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.vPS), Boolean.valueOf(this.vPU), Boolean.valueOf(this.vPT), Boolean.valueOf(this.vPV) });
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
      if ((this.vPU) && (this.vPY != null)) {
        this.vPU = false;
      }
      if ((this.vPT) || (this.vPV))
      {
        super.a(null, null);
        this.vPT = false;
        this.vPV = false;
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
  
  public void yc()
  {
    y.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.fiq) });
    if (this.fiq)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = au.Hx().dUh.b(s.dUT, this.dru, this.feq);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.dru != null) && (this.dru.size() > 0)) {
        localArrayList1.addAll(this.dru);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!s.fn(str)) {
            localArrayList2.add(str);
          }
          y.d("MicroMsg.ConversationAdapter", "block user " + str);
        }
        if (this.vPQ == null) {}
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = au.Hx().dUi.b(this.feq, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.feq != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      return;
      au.Hx();
      setCursor(com.tencent.mm.model.c.FB().a(s.dUT, this.dru, com.tencent.mm.o.a.dBg, false));
    }
  }
  
  protected final void yd()
  {
    yc();
  }
  
  private final class c
    implements m.b
  {
    public final void a(int paramInt, m paramm, Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof String))) {
        y.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      }
      do
      {
        return;
        paramm = (String)paramObject;
      } while ((e.a(this.vQh)) || (paramm == null) || (paramm.equals("")) || (e.b(this.vQh) == null) || (!e.b(this.vQh).containsKey(Integer.valueOf(paramInt))));
      e.b(this.vQh).remove(Integer.valueOf(paramInt));
      e.c(this.vQh);
    }
  }
  
  private final class d
  {
    public int ivk;
    public boolean kay;
    public CharSequence nickName;
    public CharSequence vQk;
    public CharSequence vQl;
    public int vQm;
    public int vQn;
    public int vQo;
    public boolean vQp;
    public boolean vQq;
    public boolean vQr;
    public boolean vQs;
    public boolean vQt;
    public boolean vQu;
    public boolean vQv;
    public int vQw;
    public boolean veG;
    
    private d() {}
  }
  
  private final class e
  {
    ad dnp = null;
    boolean initialized = false;
    String talker = null;
    Integer vQx = null;
    
    public e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */