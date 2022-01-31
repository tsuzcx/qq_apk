package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.g.c.au;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private ListView AgN;
  private h Ahr;
  private Activity activity;
  
  public f(h paramh, ListView paramListView, Activity paramActivity)
  {
    this.Ahr = paramh;
    this.AgN = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34209);
    if (paramInt < this.AgN.getHeaderViewsCount())
    {
      AppMethodBeat.o(34209);
      return;
    }
    int i = paramInt - this.AgN.getHeaderViewsCount();
    paramAdapterView = (ak)this.Ahr.NM(i);
    Object localObject;
    if ((paramView.getTag() instanceof h.f))
    {
      localObject = (h.f)paramView.getTag();
      ab.i("MicroMsg.ConversationClickListener", "[onItemClick] position:%s [%s,%s]", new Object[] { Integer.valueOf(i), paramAdapterView.field_username, ((h.f)localObject).username });
    }
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.ConversationClickListener", "null user at position = ".concat(String.valueOf(i)));
      AppMethodBeat.o(34209);
      return;
    }
    if (paramAdapterView.ji(16777216))
    {
      paramAdapterView.jh(16777216);
      aw.aaz();
      c.YF().a(paramAdapterView, paramAdapterView.field_username);
    }
    if (paramAdapterView.ji(33554432))
    {
      paramAdapterView.jh(33554432);
      aw.aaz();
      c.YF().a(paramAdapterView, paramAdapterView.field_username);
    }
    if (t.nZ(paramAdapterView.field_username)) {
      if (r.ZG())
      {
        d.H(this.activity, "tmessage", ".ui.TConversationUI");
        this.Ahr.a(paramView, i, paramAdapterView.field_username);
        paramInt = 0;
      }
    }
    for (;;)
    {
      label233:
      if (paramInt != 0)
      {
        this.Ahr.a(paramView, i, paramAdapterView.field_username);
        com.tencent.mm.plugin.report.service.g.Cx(9);
        paramView = (LauncherUI)this.activity;
        if (paramView == null) {
          break label1616;
        }
      }
      label1093:
      label1230:
      label1616:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("Launcher should not be empty.", bool);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("specific_chat_from_scene", 7);
        ((Bundle)localObject).putInt("KOpenArticleSceneFromScene", 93);
        ((Bundle)localObject).putInt("Main_IndexInSessionList", i);
        ((Bundle)localObject).putInt("Main_UnreadCount", paramAdapterView.field_unReadCount);
        paramView.startChatting(paramAdapterView.field_username, (Bundle)localObject, true);
        if (t.nK(paramAdapterView.field_username))
        {
          paramView = new v();
          paramView.fq(paramAdapterView.field_username);
          paramView.cTE = 1L;
          paramView.ake();
        }
        AppMethodBeat.o(34209);
        return;
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        break;
        if (t.oa(paramAdapterView.field_username))
        {
          if (r.ZF()) {
            d.H(this.activity, "bottle", ".ui.BottleConversationUI");
          }
          for (;;)
          {
            this.Ahr.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (t.of(paramAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAdapterView.field_username);
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.Ahr.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label233;
        }
        if (t.nX(paramAdapterView.field_username))
        {
          com.tencent.mm.kernel.g.RM();
          if (bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(17, null)) == 1) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label1611;
            }
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            this.Ahr.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
          }
        }
        if (t.ol(paramAdapterView.field_username)) {
          break label1622;
        }
        if (t.ok(paramAdapterView.field_username))
        {
          if (r.ZK())
          {
            localObject = new Intent();
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("type", 20);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject);
          }
          for (;;)
          {
            this.Ahr.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (t.os(paramAdapterView.field_username))
        {
          if (r.ZL())
          {
            localObject = new Intent();
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("type", 11);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject);
          }
          for (;;)
          {
            this.Ahr.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (t.oc(paramAdapterView.field_username))
        {
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.Ahr.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label233;
        }
        if (t.od(paramAdapterView.field_username))
        {
          if (r.ZN())
          {
            localObject = new Intent().addFlags(67108864);
            d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", (Intent)localObject);
          }
          for (;;)
          {
            this.Ahr.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (t.or(paramAdapterView.field_username))
        {
          if (ao.a.flL != null) {
            ao.a.flL.pn(paramAdapterView.field_username);
          }
          paramInt = 1;
          break label233;
        }
        if (t.ot(paramAdapterView.field_username))
        {
          bool = WXHardCoderJNI.hcBizEnable;
          int j = WXHardCoderJNI.hcBizDelay;
          int k = WXHardCoderJNI.hcBizCPU;
          int m = WXHardCoderJNI.hcBizIO;
          if (WXHardCoderJNI.hcBizThr)
          {
            paramInt = Process.myTid();
            ab.i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(901), Integer.valueOf(WXHardCoderJNI.startPerformance(bool, j, k, m, paramInt, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener")) });
            if (!com.tencent.mm.storage.s.aWl()) {
              break label1230;
            }
            localObject = new Intent(this.activity, BizTimeLineUI.class);
            ((Intent)localObject).putExtra("KOpenArticleSceneFromScene", 93);
            ((Intent)localObject).putExtra("Main_IndexInSessionList", i);
            ((Intent)localObject).putExtra("Main_UnreadCount", paramAdapterView.field_unReadCount);
            this.activity.startActivity((Intent)localObject);
          }
          for (;;)
          {
            this.Ahr.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            paramInt = 0;
            break label1093;
            this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
          }
        }
        if ((t.nU(paramAdapterView.field_username)) && (com.tencent.mm.aj.f.rX(paramAdapterView.field_username)))
        {
          if (!t.nT(paramAdapterView.field_username))
          {
            com.tencent.mm.ui.base.h.bO(this.activity, this.activity.getString(2131299318));
            AppMethodBeat.o(34209);
            return;
          }
          localObject = new Intent(this.activity, EnterpriseConversationUI.class);
          ((Intent)localObject).putExtra("enterprise_biz_name", paramAdapterView.field_username);
          ((Intent)localObject).putExtra("enterprise_biz_display_name", com.tencent.mm.model.s.nE(paramAdapterView.field_username));
          ((Intent)localObject).putExtra("enterprise_from_scene", 1);
          this.activity.startActivity((Intent)localObject);
          this.Ahr.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label233;
        }
        if ((t.nU(paramAdapterView.field_username)) && (com.tencent.mm.aj.f.lg(paramAdapterView.field_username)))
        {
          if (!t.nT(paramAdapterView.field_username))
          {
            com.tencent.mm.ui.base.h.bO(this.activity, this.activity.getString(2131299318));
            AppMethodBeat.o(34209);
            return;
          }
          localObject = new Intent(this.activity, BizChatConversationUI.class);
          ((Intent)localObject).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject).putExtra("biz_chat_from_scene", 1);
          ((Intent)localObject).addFlags(67108864);
          this.activity.startActivity((Intent)localObject);
          this.Ahr.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label233;
        }
        if (t.oC(paramAdapterView.field_username))
        {
          localObject = new Intent();
          ((Intent)localObject).setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
          ((Intent)localObject).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject).putExtra("app_brand_conversation_from_scene", 1);
          ((Intent)localObject).addFlags(67108864);
          this.activity.startActivity((Intent)localObject);
          this.Ahr.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label233;
        }
        paramInt = 1;
        break label233;
      }
      label1611:
      label1622:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */