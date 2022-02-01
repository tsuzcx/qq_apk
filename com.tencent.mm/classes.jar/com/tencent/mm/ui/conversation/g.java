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
import com.tencent.mm.am.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.bg;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class g
  implements AdapterView.OnItemClickListener
{
  private i HaU;
  private ListView Hal;
  private Activity activity;
  
  public g(i parami, ListView paramListView, Activity paramActivity)
  {
    this.HaU = parami;
    this.Hal = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38324);
    if (paramInt < this.Hal.getHeaderViewsCount())
    {
      AppMethodBeat.o(38324);
      return;
    }
    int i = paramInt - this.Hal.getHeaderViewsCount();
    Object localObject1;
    try
    {
      paramAdapterView = (am)this.HaU.WQ(i);
      if (paramAdapterView == null)
      {
        ad.e("MicroMsg.ConversationClickListener", "null user at position = ".concat(String.valueOf(i)));
        AppMethodBeat.o(38324);
        return;
      }
    }
    catch (IllegalStateException paramAdapterView)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ConversationClickListener", paramAdapterView, "", new Object[0]);
        paramAdapterView = null;
      }
      if ((paramView.getTag() instanceof i.f))
      {
        localObject1 = (i.f)paramView.getTag();
        ad.i("MicroMsg.ConversationClickListener", "[onItemClick] position:%s [%s,%s]", new Object[] { Integer.valueOf(i), paramAdapterView.field_username, ((i.f)localObject1).username });
      }
      if (paramAdapterView.lw(16777216))
      {
        paramAdapterView.lv(16777216);
        az.arV();
        c.apR().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.lw(33554432))
      {
        paramAdapterView.lv(33554432);
        az.arV();
        c.apR().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.lw(134217728))
      {
        paramAdapterView.lv(134217728);
        az.arV();
        c.apR().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (!w.sJ(paramAdapterView.field_username)) {
        break label468;
      }
    }
    if (com.tencent.mm.model.u.ara())
    {
      d.O(this.activity, "tmessage", ".ui.TConversationUI");
      this.HaU.a(paramView, i, paramAdapterView.field_username);
      paramInt = 0;
    }
    for (;;)
    {
      label284:
      if (paramInt != 0)
      {
        this.HaU.a(paramView, i, paramAdapterView.field_username);
        com.tencent.mm.plugin.report.service.g.KI(9);
        paramView = (LauncherUI)this.activity;
        if (paramView == null) {
          break label2074;
        }
      }
      label1152:
      label2069:
      label2074:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("Launcher should not be empty.", bool);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("specific_chat_from_scene", 7);
        ((Bundle)localObject1).putInt("KOpenArticleSceneFromScene", 93);
        ((Bundle)localObject1).putInt("Main_IndexInSessionList", i);
        ((Bundle)localObject1).putInt("Main_UnreadCount", paramAdapterView.field_unReadCount);
        ((Bundle)localObject1).putInt("chat_from_scene", 0);
        paramView.startChatting(paramAdapterView.field_username, (Bundle)localObject1, true);
        if (w.sn(paramAdapterView.field_username))
        {
          paramView = new bg();
          paramView.hZ(paramAdapterView.field_username);
          paramView.dKc = 1L;
          paramView.aBj();
        }
        AppMethodBeat.o(38324);
        return;
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        break;
        label468:
        if (w.sK(paramAdapterView.field_username))
        {
          if (com.tencent.mm.model.u.aqZ()) {
            d.O(this.activity, "bottle", ".ui.BottleConversationUI");
          }
          for (;;)
          {
            this.HaU.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.sP(paramAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAdapterView.field_username);
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.HaU.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.sH(paramAdapterView.field_username))
        {
          com.tencent.mm.kernel.g.afC();
          if (bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(17, null)) == 1) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label2069;
            }
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            this.HaU.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
          }
        }
        if (w.sV(paramAdapterView.field_username)) {
          break label2080;
        }
        if (w.sU(paramAdapterView.field_username))
        {
          if (com.tencent.mm.model.u.are())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("type", 20);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.HaU.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.tc(paramAdapterView.field_username))
        {
          if (com.tencent.mm.model.u.arf())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("type", 11);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.HaU.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.sM(paramAdapterView.field_username))
        {
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.HaU.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.sN(paramAdapterView.field_username))
        {
          if (com.tencent.mm.model.u.arh())
          {
            localObject1 = new Intent().addFlags(67108864);
            d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.HaU.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.tb(paramAdapterView.field_username))
        {
          if (ar.a.gMZ != null) {
            ar.a.gMZ.tZ(paramAdapterView.field_username);
          }
          paramInt = 1;
          break label284;
        }
        Object localObject2;
        if (w.td(paramAdapterView.field_username))
        {
          bool = WXHardCoderJNI.hcBizEnable;
          int j = WXHardCoderJNI.hcBizDelay;
          int k = WXHardCoderJNI.hcBizCPU;
          int m = WXHardCoderJNI.hcBizIO;
          if (WXHardCoderJNI.hcBizThr)
          {
            paramInt = Process.myTid();
            ad.i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(901), Integer.valueOf(WXHardCoderJNI.startPerformance(bool, j, k, m, paramInt, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener")) });
            if (!com.tencent.mm.storage.u.bBQ()) {
              break label1380;
            }
            com.tencent.mm.storage.u.uZ(true);
            localObject2 = new Intent(this.activity, BizTimeLineUI.class);
            ((Intent)localObject2).putExtra("KOpenArticleSceneFromScene", 93);
            ((Intent)localObject2).putExtra("Main_IndexInSessionList", i);
            ((Intent)localObject2).putExtra("Main_UnreadCount", paramAdapterView.field_unReadCount);
            localObject1 = this.activity;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.storage.u.eKe();
            localObject1 = b.BMT;
            b.euI();
          }
          for (;;)
          {
            this.HaU.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            paramInt = 0;
            break label1152;
            label1380:
            localObject1 = this.activity;
            localObject2 = new Intent(this.activity, BizConversationUI.class);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        if ((w.sE(paramAdapterView.field_username)) && (f.wL(paramAdapterView.field_username)))
        {
          if (!w.sD(paramAdapterView.field_username))
          {
            h.cf(this.activity, this.activity.getString(2131758445));
            AppMethodBeat.o(38324);
            return;
          }
          localObject2 = new Intent(this.activity, EnterpriseConversationUI.class);
          ((Intent)localObject2).putExtra("enterprise_biz_name", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("enterprise_biz_display_name", v.sh(paramAdapterView.field_username));
          ((Intent)localObject2).putExtra("enterprise_from_scene", 1);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.HaU.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if ((w.sE(paramAdapterView.field_username)) && (f.pc(paramAdapterView.field_username)))
        {
          if (!w.sD(paramAdapterView.field_username))
          {
            h.cf(this.activity, this.activity.getString(2131758445));
            AppMethodBeat.o(38324);
            return;
          }
          localObject2 = new Intent(this.activity, BizChatConversationUI.class);
          ((Intent)localObject2).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("biz_chat_from_scene", 1);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.HaU.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.tm(paramAdapterView.field_username))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
          ((Intent)localObject2).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("app_brand_conversation_from_scene", 1);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.HaU.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        paramInt = 1;
        break label284;
      }
      label2080:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */