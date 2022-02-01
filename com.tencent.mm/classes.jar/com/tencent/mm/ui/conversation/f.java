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
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class f
  implements AdapterView.OnItemClickListener
{
  private ListView IAD;
  private i IBS;
  private Activity activity;
  
  public f(i parami, ListView paramListView, Activity paramActivity)
  {
    this.IBS = parami;
    this.IAD = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38324);
    if (paramInt < this.IAD.getHeaderViewsCount())
    {
      AppMethodBeat.o(38324);
      return;
    }
    int i = paramInt - this.IAD.getHeaderViewsCount();
    Object localObject1;
    try
    {
      paramAdapterView = (ap)this.IBS.Za(i);
      if (paramAdapterView == null)
      {
        ac.e("MicroMsg.ConversationClickListener", "null user at position = ".concat(String.valueOf(i)));
        AppMethodBeat.o(38324);
        return;
      }
    }
    catch (IllegalStateException paramAdapterView)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ConversationClickListener", paramAdapterView, "", new Object[0]);
        paramAdapterView = null;
      }
      if ((paramView.getTag() instanceof i.f))
      {
        localObject1 = (i.f)paramView.getTag();
        ac.i("MicroMsg.ConversationClickListener", "[onItemClick] position:%s [%s,%s]", new Object[] { Integer.valueOf(i), paramAdapterView.field_username, ((i.f)localObject1).username });
      }
      if (paramAdapterView.lr(16777216))
      {
        paramAdapterView.lq(16777216);
        com.tencent.mm.model.az.ayM();
        c.awG().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.lr(33554432))
      {
        paramAdapterView.lq(33554432);
        com.tencent.mm.model.az.ayM();
        c.awG().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.lr(134217728))
      {
        paramAdapterView.lq(134217728);
        com.tencent.mm.model.az.ayM();
        c.awG().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (!w.wM(paramAdapterView.field_username)) {
        break label468;
      }
    }
    if (u.axQ())
    {
      d.N(this.activity, "tmessage", ".ui.TConversationUI");
      this.IBS.a(paramView, i, paramAdapterView.field_username);
      paramInt = 0;
    }
    for (;;)
    {
      label284:
      if (paramInt != 0)
      {
        this.IBS.a(paramView, i, paramAdapterView.field_username);
        com.tencent.mm.plugin.report.service.g.MH(9);
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
        if (w.wq(paramAdapterView.field_username))
        {
          paramView = new ct();
          paramView.kP(paramAdapterView.field_username);
          paramView.dHR = 1L;
          paramView.aHZ();
        }
        AppMethodBeat.o(38324);
        return;
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        break;
        label468:
        if (w.wN(paramAdapterView.field_username))
        {
          if (u.axP()) {
            d.N(this.activity, "bottle", ".ui.BottleConversationUI");
          }
          for (;;)
          {
            this.IBS.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.wS(paramAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAdapterView.field_username);
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.IBS.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.wK(paramAdapterView.field_username))
        {
          com.tencent.mm.kernel.g.agS();
          if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(17, null)) == 1) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label2069;
            }
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            this.IBS.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
          }
        }
        if (w.wY(paramAdapterView.field_username)) {
          break label2080;
        }
        if (w.wX(paramAdapterView.field_username))
        {
          if (u.axU())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("type", 20);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.IBS.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.xf(paramAdapterView.field_username))
        {
          if (u.axV())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("type", 11);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.IBS.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.wP(paramAdapterView.field_username))
        {
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.IBS.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.wQ(paramAdapterView.field_username))
        {
          if (u.axX())
          {
            localObject1 = new Intent().addFlags(67108864);
            d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.IBS.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.xe(paramAdapterView.field_username))
        {
          if (ar.a.hnz != null) {
            ar.a.hnz.yf(paramAdapterView.field_username);
          }
          paramInt = 1;
          break label284;
        }
        Object localObject2;
        if (w.xg(paramAdapterView.field_username))
        {
          bool = WXHardCoderJNI.hcBizEnable;
          int j = WXHardCoderJNI.hcBizDelay;
          int k = WXHardCoderJNI.hcBizCPU;
          int m = WXHardCoderJNI.hcBizIO;
          if (WXHardCoderJNI.hcBizThr)
          {
            paramInt = Process.myTid();
            ac.i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(901), Integer.valueOf(WXHardCoderJNI.startPerformance(bool, j, k, m, paramInt, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener")) });
            if (!com.tencent.mm.storage.v.bIO()) {
              break label1380;
            }
            com.tencent.mm.storage.v.wb(true);
            localObject2 = new Intent(this.activity, BizTimeLineUI.class);
            ((Intent)localObject2).putExtra("KOpenArticleSceneFromScene", 93);
            ((Intent)localObject2).putExtra("Main_IndexInSessionList", i);
            ((Intent)localObject2).putExtra("Main_UnreadCount", paramAdapterView.field_unReadCount);
            localObject1 = this.activity;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.storage.v.eZB();
            localObject1 = b.Dfd;
            b.eKb();
          }
          for (;;)
          {
            this.IBS.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            paramInt = 0;
            break label1152;
            label1380:
            localObject1 = this.activity;
            localObject2 = new Intent(this.activity, BizConversationUI.class);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        if ((w.wH(paramAdapterView.field_username)) && (com.tencent.mm.al.f.AR(paramAdapterView.field_username)))
        {
          if (!w.wG(paramAdapterView.field_username))
          {
            h.cg(this.activity, this.activity.getString(2131758445));
            AppMethodBeat.o(38324);
            return;
          }
          localObject2 = new Intent(this.activity, EnterpriseConversationUI.class);
          ((Intent)localObject2).putExtra("enterprise_biz_name", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("enterprise_biz_display_name", com.tencent.mm.model.v.wk(paramAdapterView.field_username));
          ((Intent)localObject2).putExtra("enterprise_from_scene", 1);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.IBS.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if ((w.wH(paramAdapterView.field_username)) && (com.tencent.mm.al.f.so(paramAdapterView.field_username)))
        {
          if (!w.wG(paramAdapterView.field_username))
          {
            h.cg(this.activity, this.activity.getString(2131758445));
            AppMethodBeat.o(38324);
            return;
          }
          localObject2 = new Intent(this.activity, BizChatConversationUI.class);
          ((Intent)localObject2).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("biz_chat_from_scene", 1);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.IBS.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.xp(paramAdapterView.field_username))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
          ((Intent)localObject2).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("app_brand_conversation_from_scene", 1);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.IBS.a(paramView, i, paramAdapterView.field_username);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */