package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.b.a.m;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class f
  implements AdapterView.OnItemClickListener
{
  private Activity activity;
  private h vPG;
  private ListView vPc;
  
  public f(h paramh, ListView paramListView, Activity paramActivity)
  {
    this.vPG = paramh;
    this.vPc = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = false;
    if (paramInt < this.vPc.getHeaderViewsCount()) {}
    label1177:
    label1185:
    for (;;)
    {
      return;
      paramInt -= this.vPc.getHeaderViewsCount();
      paramAdapterView = (ak)this.vPG.FC(paramInt);
      if (paramAdapterView == null)
      {
        y.e("MicroMsg.ConversationClickListener", "null user at position = " + paramInt);
        return;
      }
      if (paramAdapterView.gV(16777216))
      {
        paramAdapterView.gU(16777216);
        au.Hx();
        c.FB().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.gV(33554432))
      {
        paramAdapterView.gU(33554432);
        au.Hx();
        c.FB().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (com.tencent.mm.model.s.hq(paramAdapterView.field_username)) {
        if (q.GB())
        {
          d.x(this.activity, "tmessage", ".ui.TConversationUI");
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label1185;
        }
        com.tencent.mm.plugin.report.service.g.wI(9);
        paramView = (LauncherUI)this.activity;
        if (paramView != null) {
          bool = true;
        }
        Assert.assertTrue("Launcher should not be empty.", bool);
        Bundle localBundle = new Bundle();
        localBundle.putInt("specific_chat_from_scene", 7);
        paramView.startChatting(paramAdapterView.field_username, localBundle, true);
        if (!com.tencent.mm.model.s.hb(paramAdapterView.field_username)) {
          break;
        }
        paramView = new m();
        paramView.ciU = paramAdapterView.field_username;
        paramView.ciV = 1L;
        paramView.QX();
        return;
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        paramInt = 0;
        continue;
        if (com.tencent.mm.model.s.hr(paramAdapterView.field_username))
        {
          if (q.GA())
          {
            d.x(this.activity, "bottle", ".ui.BottleConversationUI");
            paramInt = 0;
          }
          else
          {
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            paramInt = 0;
          }
        }
        else if (com.tencent.mm.model.s.hw(paramAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAdapterView.field_username);
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          paramInt = 0;
        }
        else
        {
          if (com.tencent.mm.model.s.ho(paramAdapterView.field_username))
          {
            com.tencent.mm.kernel.g.DQ();
            if (bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(17, null)) == 1) {}
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt != 0) {
                break label1177;
              }
              d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
              paramInt = 0;
              break;
            }
          }
          if (!com.tencent.mm.model.s.hC(paramAdapterView.field_username))
          {
            if (com.tencent.mm.model.s.hB(paramAdapterView.field_username))
            {
              if (q.GG())
              {
                paramView = new Intent();
                paramView.addFlags(67108864);
                paramView.putExtra("type", 20);
                d.b(this.activity, "readerapp", ".ui.ReaderAppUI", paramView);
                paramInt = 0;
              }
              else
              {
                d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
                paramInt = 0;
              }
            }
            else if (com.tencent.mm.model.s.hJ(paramAdapterView.field_username))
            {
              if (q.GH())
              {
                paramView = new Intent();
                paramView.addFlags(67108864);
                paramView.putExtra("type", 11);
                d.b(this.activity, "readerapp", ".ui.ReaderAppUI", paramView);
                paramInt = 0;
              }
              else
              {
                d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
                paramInt = 0;
              }
            }
            else if (com.tencent.mm.model.s.ht(paramAdapterView.field_username))
            {
              d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
              paramInt = 0;
            }
            else if (com.tencent.mm.model.s.hu(paramAdapterView.field_username))
            {
              if (q.GJ())
              {
                paramView = new Intent().addFlags(67108864);
                d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", paramView);
                paramInt = 0;
              }
              else
              {
                d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
                paramInt = 0;
              }
            }
            else if (com.tencent.mm.model.s.hI(paramAdapterView.field_username))
            {
              if (am.a.dVB != null) {
                am.a.dVB.iE(paramAdapterView.field_username);
              }
              paramInt = 1;
            }
            else if (com.tencent.mm.model.s.hK(paramAdapterView.field_username))
            {
              if (com.tencent.mm.storage.s.ctL())
              {
                this.activity.startActivity(new Intent(this.activity, BizTimeLineUI.class));
                paramInt = 0;
              }
              else
              {
                this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
                paramInt = 0;
              }
            }
            else if ((com.tencent.mm.model.s.hl(paramAdapterView.field_username)) && (com.tencent.mm.ai.f.lc(paramAdapterView.field_username)))
            {
              if (!com.tencent.mm.model.s.hk(paramAdapterView.field_username))
              {
                com.tencent.mm.ui.base.h.bC(this.activity, this.activity.getString(R.l.enterprise_not_contact));
                return;
              }
              paramView = new Intent(this.activity, EnterpriseConversationUI.class);
              paramView.putExtra("enterprise_biz_name", paramAdapterView.field_username);
              paramView.putExtra("enterprise_biz_display_name", r.gV(paramAdapterView.field_username));
              paramView.putExtra("enterprise_from_scene", 1);
              this.activity.startActivity(paramView);
              paramInt = 0;
            }
            else if ((com.tencent.mm.model.s.hl(paramAdapterView.field_username)) && (com.tencent.mm.ai.f.eW(paramAdapterView.field_username)))
            {
              if (!com.tencent.mm.model.s.hk(paramAdapterView.field_username))
              {
                com.tencent.mm.ui.base.h.bC(this.activity, this.activity.getString(R.l.enterprise_not_contact));
                return;
              }
              paramView = new Intent(this.activity, BizChatConversationUI.class);
              paramView.putExtra("Contact_User", paramAdapterView.field_username);
              paramView.putExtra("biz_chat_from_scene", 1);
              paramView.addFlags(67108864);
              this.activity.startActivity(paramView);
              paramInt = 0;
            }
            else if (com.tencent.mm.model.s.hT(paramAdapterView.field_username))
            {
              paramView = new Intent();
              paramView.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
              paramView.putExtra("Contact_User", paramAdapterView.field_username);
              paramView.putExtra("app_brand_conversation_from_scene", 1);
              paramView.addFlags(67108864);
              this.activity.startActivity(paramView);
              paramInt = 0;
            }
            else
            {
              paramInt = 1;
            }
          }
          else {
            paramInt = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */