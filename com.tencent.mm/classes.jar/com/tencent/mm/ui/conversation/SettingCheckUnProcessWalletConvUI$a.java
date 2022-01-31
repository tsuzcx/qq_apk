package com.tencent.mm.ui.conversation;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.q;
import java.util.HashMap;
import java.util.List;

final class SettingCheckUnProcessWalletConvUI$a
  extends BaseAdapter
{
  private final int vQb;
  private final int vQc;
  private float veB = -1.0F;
  protected float veC = -1.0F;
  private float veD = -1.0F;
  private ColorStateList[] veE = new ColorStateList[5];
  private HashMap<String, SettingCheckUnProcessWalletConvUI.a.a> veF;
  
  public SettingCheckUnProcessWalletConvUI$a(SettingCheckUnProcessWalletConvUI paramSettingCheckUnProcessWalletConvUI)
  {
    this.veE[0] = a.h(paramSettingCheckUnProcessWalletConvUI, R.e.hint_text_color);
    this.veE[1] = a.h(paramSettingCheckUnProcessWalletConvUI, R.e.mm_list_textcolor_unread);
    this.veE[3] = a.h(paramSettingCheckUnProcessWalletConvUI, R.e.normal_text_color);
    this.veE[2] = a.h(paramSettingCheckUnProcessWalletConvUI, R.e.mm_list_textcolor_three);
    this.veE[2] = a.h(paramSettingCheckUnProcessWalletConvUI, R.e.mm_list_textcolor_three);
    this.veE[4] = a.h(paramSettingCheckUnProcessWalletConvUI, R.e.light_text_color);
    if (a.fh(paramSettingCheckUnProcessWalletConvUI)) {
      this.vQc = paramSettingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
    }
    for (this.vQb = paramSettingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);; this.vQb = paramSettingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth))
    {
      this.veB = a.aa(paramSettingCheckUnProcessWalletConvUI, R.f.NormalTextSize);
      this.veC = a.aa(paramSettingCheckUnProcessWalletConvUI, R.f.HintTextSize);
      this.veD = a.aa(paramSettingCheckUnProcessWalletConvUI, R.f.SmallestTextSize);
      this.veF = new HashMap();
      return;
      this.vQc = paramSettingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
    }
  }
  
  private static String adj(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 32)) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(paramString);
    }
    return null;
  }
  
  private CharSequence c(ak paramak, int paramInt, boolean paramBoolean)
  {
    if ((!ah.bl(paramak.field_editingMsg)) && ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.vUd.getString(R.l.main_conversation_last_editing_msg_prefix));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.vUd, paramak.field_editingMsg, paramInt));
      return localObject1;
    }
    Object localObject1 = paramak.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  "))) {
      return new SpannableString(com.tencent.mm.pluginsdk.ui.d.j.c(this.vUd, (CharSequence)localObject1, paramInt));
    }
    localObject1 = paramak.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      au.Hx();
      if (ah.g((Integer)c.Dz().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0) {
        return this.vUd.getString(R.l.settings_plugins_disable);
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      au.Hx();
      localObject1 = c.FE().Ic("@t.qq.com");
      if ((localObject1 != null) && (((bq)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0) {
        return this.vUd.getString(R.l.settings_plugins_disable);
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
      str1 = this.vUd.getString(R.l.app_emoji);
      if (ah.bl((String)localObject1))
      {
        localObject1 = str1;
        paramak.dQ((String)localObject1);
      }
    }
    else
    {
      if (ah.bl(paramak.field_digest)) {
        break label724;
      }
      if (ah.bl(paramak.field_digestUser)) {
        break label713;
      }
      if ((paramak.field_isSend != 0) || (!s.fn(paramak.field_username))) {
        break label701;
      }
      localObject1 = r.getDisplayName(paramak.field_digestUser, paramak.field_username);
    }
    label701:
    label713:
    label724:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramak.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)) {
          break label755;
        }
        paramak = new SpannableStringBuilder(this.vUd.getString(R.l.main_conversation_chatroom_at_hint));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.b(this.vUd, str1, paramInt));
        return paramak;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = r.gV(paramak.field_digestUser);
      continue;
      localObject1 = paramak.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramak.field_isSend, paramak.field_username, paramak.field_content, xP(paramak.field_msgType), this.vUd);
    }
    label755:
    if ((paramBoolean) && (paramak.field_unReadCount > 1)) {
      localObject2 = this.vUd.getString(R.l.main_conversation_chatroom_unread_digest, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
    }
    for (;;)
    {
      return com.tencent.mm.pluginsdk.ui.d.j.b(this.vUd, (CharSequence)localObject2, paramInt);
      localObject2 = str1;
      if (paramak.field_unReadCount > 1)
      {
        localObject2 = str1;
        if (s.hK(paramak.field_parentRef)) {
          localObject2 = this.vUd.getString(R.l.main_conversation_chatroom_unread_digest, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
        }
      }
    }
  }
  
  private CharSequence h(ak paramak)
  {
    if (paramak.field_status == 1) {
      return this.vUd.getString(R.l.main_sending);
    }
    if (paramak.field_conversationTime == 9223372036854775807L) {
      return "";
    }
    return com.tencent.mm.pluginsdk.f.h.c(this.vUd, paramak.field_conversationTime, true);
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
  
  public final ak HS(int paramInt)
  {
    String str = (String)SettingCheckUnProcessWalletConvUI.d(this.vUd).get(paramInt);
    au.Hx();
    return c.FB().abv(str);
  }
  
  public final int getCount()
  {
    return SettingCheckUnProcessWalletConvUI.d(this.vUd).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new SettingCheckUnProcessWalletConvUI.a.b(this, (byte)0);
      if (a.fh(this.vUd))
      {
        paramView = View.inflate(this.vUd, R.i.conversation_item_large, null);
        paramViewGroup.doU = ((ImageView)paramView.findViewById(R.h.avatar_iv));
        paramViewGroup.veJ = ((NoMeasuredTextView)paramView.findViewById(R.h.nickname_tv));
        paramViewGroup.vQy = ((NoMeasuredTextView)paramView.findViewById(R.h.source_tv));
        paramViewGroup.veK = ((NoMeasuredTextView)paramView.findViewById(R.h.update_time_tv));
        paramViewGroup.veL = ((NoMeasuredTextView)paramView.findViewById(R.h.last_msg_tv));
        paramViewGroup.hZk = ((TextView)paramView.findViewById(R.h.tipcnt_tv));
        paramViewGroup.hZk.setBackgroundResource(q.hh(this.vUd));
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
      }
    }
    ak localak;
    for (;;)
    {
      localak = HS(paramInt);
      if (localak != null) {
        break label372;
      }
      return paramView;
      paramView = View.inflate(this.vUd, R.i.conversation_item, null);
      break;
      paramViewGroup = (SettingCheckUnProcessWalletConvUI.a.b)paramView.getTag();
    }
    label372:
    a.b.a(paramViewGroup.doU, localak.field_username);
    paramViewGroup.doU.getDrawable();
    String str2 = localak.field_username;
    Object localObject2 = (SettingCheckUnProcessWalletConvUI.a.a)this.veF.get(str2);
    Object localObject1 = localObject2;
    boolean bool;
    if (localObject2 == null)
    {
      localObject2 = new SettingCheckUnProcessWalletConvUI.a.a(this, (byte)0);
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQo = -1;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQn = -1;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQt = false;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQv = false;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQu = false;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).kay = s.fn(localak.field_username);
      if ((((SettingCheckUnProcessWalletConvUI.a.a)localObject2).kay) && (((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQu) && (localak.field_unReadCount > 0))
      {
        bool = true;
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQs = bool;
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).ivk = 0;
        if ((xP(localak.field_msgType) == 34) && (localak.field_isSend == 0) && (!ah.bl(localak.field_content)))
        {
          String str1 = localak.field_content;
          if (!str2.equals("qmessage"))
          {
            localObject1 = str1;
            if (!str2.equals("floatbottle")) {}
          }
          else
          {
            String[] arrayOfString = str1.split(":");
            localObject1 = str1;
            if (arrayOfString != null)
            {
              localObject1 = str1;
              if (arrayOfString.length > 3) {
                localObject1 = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
              }
            }
          }
          if (!new n((String)localObject1).eHB) {
            ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).ivk = 1;
          }
        }
        localObject1 = r.gV(str2);
        if ((!((SettingCheckUnProcessWalletConvUI.a.a)localObject2).kay) || (localObject1 != null)) {
          break label1220;
        }
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).nickName = this.vUd.getString(R.l.chatting_roominfo_noname);
        label712:
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQk = h(localak);
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQl = c(localak, (int)paramViewGroup.veL.getTextSize(), ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQs);
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQw = localak.field_attrflag;
      }
    }
    else
    {
      switch (localak.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        label802:
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQm = paramInt;
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQp = s.a(localak);
        au.Hx();
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).veG = c.FB().g(localak);
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQq = false;
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).vQr = x.cqF();
        this.veF.put(str2, localObject2);
        localObject1 = localObject2;
        if (((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQk == null) {
          ((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQk = h(localak);
        }
        if ((((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQs) || (s.hK(localak.field_parentRef)))
        {
          paramViewGroup.veL.setTextColor(this.veE[0]);
          label918:
          if (!str2.toLowerCase().endsWith("@t.qq.com")) {
            break label1291;
          }
          paramViewGroup.veJ.setCompoundRightDrawablesWithIntrinsicBounds(R.g.icon_tencent_weibo);
          paramViewGroup.veJ.setDrawRightDrawable(true);
          label950:
          paramInt = ((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQm;
          if (paramInt == -1) {
            break label1302;
          }
          paramViewGroup.veL.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
          paramViewGroup.veL.setDrawLeftDrawable(true);
          label977:
          paramViewGroup.veJ.setText(((SettingCheckUnProcessWalletConvUI.a.a)localObject1).nickName);
          paramViewGroup.vQy.setVisibility(8);
          localObject2 = paramViewGroup.veK.getLayoutParams();
          if (((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQk.length() <= 9) {
            break label1313;
          }
          if (((ViewGroup.LayoutParams)localObject2).width != this.vQc)
          {
            ((ViewGroup.LayoutParams)localObject2).width = this.vQc;
            paramViewGroup.veK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          label1052:
          y.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
          paramViewGroup.veK.setText(((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQk);
          paramViewGroup.veL.setText(((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQl);
          if ((!((SettingCheckUnProcessWalletConvUI.a.a)localObject1).kay) || (!((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQu)) {
            break label1346;
          }
          paramViewGroup.veM.setVisibility(0);
          label1124:
          a.b.a(paramViewGroup.doU, str2);
          if ((!((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQp) && (((SettingCheckUnProcessWalletConvUI.a.a)localObject1).veG) && (au.DK()))
          {
            au.Hx();
            c.FB().f(localak);
          }
          if ((!((SettingCheckUnProcessWalletConvUI.a.a)localObject1).veG) || (localak.field_conversationTime == -1L)) {
            break label1377;
          }
          paramView.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.veN.setVisibility(8);
      return paramView;
      bool = false;
      break;
      label1220:
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.d.j.a(this.vUd, r.gV(str2), paramViewGroup.veJ.getTextSize());
      break label712;
      paramInt = -1;
      break label802;
      paramInt = R.k.msg_state_sending;
      break label802;
      paramInt = -1;
      break label802;
      paramInt = R.k.msg_state_failed;
      break label802;
      paramViewGroup.veL.setTextColor(this.veE[localObject1.ivk]);
      break label918;
      label1291:
      paramViewGroup.veJ.setDrawRightDrawable(false);
      break label950;
      label1302:
      paramViewGroup.veL.setDrawLeftDrawable(false);
      break label977;
      label1313:
      if (((ViewGroup.LayoutParams)localObject2).width == this.vQb) {
        break label1052;
      }
      ((ViewGroup.LayoutParams)localObject2).width = this.vQb;
      paramViewGroup.veK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label1052;
      label1346:
      if (((SettingCheckUnProcessWalletConvUI.a.a)localObject1).vQq)
      {
        paramViewGroup.veM.setVisibility(0);
        break label1124;
      }
      paramViewGroup.veM.setVisibility(8);
      break label1124;
      label1377:
      paramView.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.a
 * JD-Core Version:    0.7.0.1
 */