package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bf.g;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends com.tencent.mm.ui.r<ak>
{
  protected List<String> dru = null;
  private String feq;
  private com.tencent.mm.ui.applet.b ffG = new com.tencent.mm.ui.applet.b(new a.1(this));
  private b.b ffH = null;
  private boolean vPP = true;
  private ColorStateList[] veE = new ColorStateList[2];
  private HashMap<String, a.a> veF;
  private a.b wiE;
  
  public a(Context paramContext, r.a parama)
  {
    super(paramContext, new ak());
    this.uMi = parama;
    this.veE[0] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_two);
    this.veE[1] = com.tencent.mm.cb.a.h(paramContext, R.e.mm_list_textcolor_unread);
    this.veF = new HashMap();
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
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString != null) && (!paramString.equals("")) && (this.veF != null)) {
      this.veF.remove(paramString);
    }
    for (;;)
    {
      super.a(paramString, paraml);
      return;
      if (this.veF != null) {
        this.veF.clear();
      }
    }
  }
  
  public final void ej(List<String> paramList)
  {
    this.dru = paramList;
    a(null, null);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.ffH == null) {
      this.ffH = new b.b()
      {
        public final int WL()
        {
          return a.this.getCount();
        }
        
        public final String jX(int paramAnonymousInt)
        {
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            y.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            return null;
          }
          ak localak = (ak)a.this.getItem(paramAnonymousInt);
          if (localak == null) {
            return null;
          }
          return localak.field_username;
        }
      };
    }
    if (this.ffG != null) {
      this.ffG.a(paramInt, this.ffH);
    }
    ak localak = (ak)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((xP(localak.field_msgType) == 34) && (localak.field_isSend == 0) && (!ah.bl(localak.field_content)))
    {
      localObject1 = localak.field_content;
      if (!localak.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localak.field_username.equals("floatbottle")) {}
      }
      else
      {
        localObject2 = ((String)localObject1).split(":");
        paramViewGroup = (ViewGroup)localObject1;
        if (localObject2 != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          if (localObject2.length > 3) {
            paramViewGroup = localObject2[1] + ":" + localObject2[2] + ":" + localObject2[3];
          }
        }
      }
      if (new n(paramViewGroup).eHB) {}
    }
    for (int i = 1;; i = 0)
    {
      label460:
      int j;
      int k;
      if (paramView == null)
      {
        paramViewGroup = new a.c();
        localObject1 = View.inflate(this.context, R.i.search_conversation, null);
        paramViewGroup.doU = ((ImageView)((View)localObject1).findViewById(R.h.avatar_iv));
        paramViewGroup.doV = ((TextView)((View)localObject1).findViewById(R.h.nickname_tv));
        paramViewGroup.hZi = ((TextView)((View)localObject1).findViewById(R.h.update_time_tv));
        paramViewGroup.hZj = ((TextView)((View)localObject1).findViewById(R.h.last_msg_tv));
        paramViewGroup.hZk = ((TextView)((View)localObject1).findViewById(R.h.tipcnt_tv));
        paramViewGroup.hZk.setBackgroundResource(com.tencent.mm.ui.tools.q.hh(this.context));
        paramViewGroup.veM = ((ImageView)((View)localObject1).findViewById(R.h.image_mute));
        paramViewGroup.veN = ((ImageView)((View)localObject1).findViewById(R.h.talkroom_iv));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a.a)this.veF.get(localak.field_username + localak.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a.a(this, (byte)0);
          ((a.a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.d.j.a(this.context, com.tencent.mm.model.r.gV(localak.field_username), paramViewGroup.doV.getTextSize());
          if (localak.field_status != 1) {
            break label1077;
          }
          paramView = this.context.getString(R.l.main_sending);
          ((a.a)localObject2).vQk = paramView;
          j = (int)paramViewGroup.hZj.getTextSize();
          k = com.tencent.mm.model.q.Gn();
          paramView = localak.field_username;
          au.Hx();
          if (ah.g((Integer)c.Dz().get(17, null)) != 1) {
            break label1112;
          }
          paramInt = 1;
          label512:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1117;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          label537:
          ((a.a)localObject2).vQl = paramView;
          if ((s.fn(localak.field_username)) && (m.gM(localak.field_username) == 0)) {
            ((a.a)localObject2).nickName = this.context.getString(R.l.chatting_roominfo_noname);
          }
        }
        switch (localak.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label626:
          ((a.a)localObject2).vQm = paramInt;
          this.veF.put(localak.field_username + localak.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.hZj.setTextColor(this.veE[i]);
          paramViewGroup.doV.setText(paramView.nickName);
          paramViewGroup.hZi.setText(paramView.vQk);
          paramViewGroup.hZj.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, paramView.vQl.toString(), paramViewGroup.hZj.getTextSize()));
          if (localak.field_conversationTime == 0L)
          {
            paramViewGroup.hZi.setVisibility(8);
            label756:
            paramViewGroup.veM.setVisibility(8);
            if (s.fn(localak.field_username))
            {
              au.Hx();
              paramView = c.Fw().abl(localak.field_username);
              if ((paramView != null) && (paramView.cCy == 0)) {
                paramViewGroup.veM.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(paramViewGroup.doU, localak.field_username);
            if (this.vPP)
            {
              if (localak.field_unReadCount <= 100) {
                break label1302;
              }
              paramViewGroup.hZk.setText("...");
              paramViewGroup.hZk.setVisibility(0);
            }
            label860:
            if (au.DK())
            {
              if (!s.a(localak))
              {
                au.Hx();
                if (c.FB().g(localak))
                {
                  au.Hx();
                  c.FB().f(localak);
                }
              }
              au.Hx();
              if (c.FB().g(localak)) {
                break label1357;
              }
              ((View)localObject1).findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
            }
          }
          break;
        }
      }
      for (;;)
      {
        paramView = new ru();
        paramView.cbq.cbs = true;
        com.tencent.mm.sdk.b.a.udP.m(paramView);
        if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 7, 0L)) && (!localak.field_username.equals(paramView.cbr.cbu)))
        {
          localak.bb(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localak, 6, localak.field_conversationTime));
          au.Hx();
          c.FB().a(localak, localak.field_username);
        }
        if ((g.eEV != null) && (g.eEV.nx(localak.field_username))) {
          break label1374;
        }
        paramViewGroup.veN.setVisibility(8);
        return localObject1;
        paramViewGroup = (a.c)paramView.getTag();
        localObject1 = paramView;
        break;
        label1077:
        if (localak.field_conversationTime == 9223372036854775807L)
        {
          paramView = "";
          break label460;
        }
        paramView = com.tencent.mm.pluginsdk.f.h.c(this.context, localak.field_conversationTime, true);
        break label460;
        label1112:
        paramInt = 0;
        break label512;
        label1117:
        au.Hx();
        bq localbq = c.FE().Ic("@t.qq.com");
        if ((localbq != null) && (localbq.isEnable())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("tmessage")) || (paramInt != 0)) {
            break label1182;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          break;
        }
        label1182:
        if ((k & 0x40) != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("qmessage")) || (paramInt != 0)) {
            break label1224;
          }
          paramView = this.context.getString(R.l.settings_plugins_disable);
          break;
        }
        label1224:
        paramView = com.tencent.mm.pluginsdk.ui.d.j.b(this.context, com.tencent.mm.booter.notification.a.h.a(localak.field_isSend, localak.field_username, localak.field_content, xP(localak.field_msgType), this.context), j);
        break label537;
        paramInt = -1;
        break label626;
        paramInt = R.k.msg_state_sending;
        break label626;
        paramInt = -1;
        break label626;
        paramInt = R.k.msg_state_failed;
        break label626;
        paramViewGroup.hZi.setVisibility(0);
        break label756;
        label1302:
        if (localak.field_unReadCount > 0)
        {
          paramViewGroup.hZk.setText(localak.field_unReadCount);
          paramViewGroup.hZk.setVisibility(0);
          break label860;
        }
        paramViewGroup.hZk.setVisibility(4);
        break label860;
        label1357:
        ((View)localObject1).findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
      }
      label1374:
      paramViewGroup.veN.setVisibility(0);
      if (localak.field_username.equals(paramView.cbr.cbu))
      {
        paramViewGroup.veN.setImageResource(R.k.talk_room_mic_speaking);
        return localObject1;
      }
      paramViewGroup.veN.setImageResource(R.k.talk_room_mic_idle);
      return localObject1;
    }
  }
  
  public final void pA(String paramString)
  {
    this.feq = paramString;
    bcS();
    yc();
  }
  
  public final void yc()
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
        y.d("MicroMsg.SearchConversationAdapter", "block user " + str);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = au.Hx().dUi.a(this.feq, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      setCursor(new MergeCursor(arrayOfCursor));
      if ((this.wiE != null) && (this.feq != null)) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
    }
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.a
 * JD-Core Version:    0.7.0.1
 */