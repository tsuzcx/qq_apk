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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.f;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class f
  implements AdapterView.OnItemClickListener
{
  private ListView KrJ;
  private i KsY;
  private Activity activity;
  
  public f(i parami, ListView paramListView, Activity paramActivity)
  {
    this.KsY = parami;
    this.KrJ = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38324);
    if (paramInt < this.KrJ.getHeaderViewsCount())
    {
      AppMethodBeat.o(38324);
      return;
    }
    int i = paramInt - this.KrJ.getHeaderViewsCount();
    Object localObject1;
    try
    {
      paramAdapterView = (at)this.KsY.abj(i);
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
      if (paramAdapterView.lQ(16777216))
      {
        paramAdapterView.lP(16777216);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.lQ(33554432))
      {
        paramAdapterView.lP(33554432);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.lQ(134217728))
      {
        paramAdapterView.lP(134217728);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (!w.zJ(paramAdapterView.field_username)) {
        break label468;
      }
    }
    if (u.aAI())
    {
      d.Q(this.activity, "tmessage", ".ui.TConversationUI");
      this.KsY.a(paramView, i, paramAdapterView.field_username);
      paramInt = 0;
    }
    for (;;)
    {
      label284:
      if (paramInt != 0)
      {
        this.KsY.a(paramView, i, paramAdapterView.field_username);
        com.tencent.mm.plugin.report.service.f.Oj(9);
        paramView = (LauncherUI)this.activity;
        if (paramView == null) {
          break label2057;
        }
      }
      label2052:
      label2057:
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
        if (w.zl(paramAdapterView.field_username))
        {
          paramView = new dm();
          paramView.mS(paramAdapterView.field_username);
          paramView.dUW = 1L;
          paramView.aLk();
        }
        AppMethodBeat.o(38324);
        return;
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        break;
        label468:
        if (w.zK(paramAdapterView.field_username))
        {
          if (u.aAH()) {
            d.Q(this.activity, "bottle", ".ui.BottleConversationUI");
          }
          for (;;)
          {
            this.KsY.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.zP(paramAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAdapterView.field_username);
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.KsY.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.zH(paramAdapterView.field_username))
        {
          if (u.aAT()) {
            break label2052;
          }
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.KsY.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.zV(paramAdapterView.field_username)) {
          break label2063;
        }
        if (w.zU(paramAdapterView.field_username))
        {
          if (u.aAN())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("type", 20);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.KsY.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.Ac(paramAdapterView.field_username))
        {
          if (u.aAO())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("type", 11);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.KsY.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.zM(paramAdapterView.field_username))
        {
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.KsY.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.zN(paramAdapterView.field_username))
        {
          if (u.aAQ())
          {
            localObject1 = new Intent().addFlags(67108864);
            d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.KsY.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (w.Ab(paramAdapterView.field_username))
        {
          if (as.a.hFR != null) {
            as.a.hFR.Bd(paramAdapterView.field_username);
          }
          paramInt = 1;
          break label284;
        }
        label1121:
        Object localObject2;
        if (w.Ad(paramAdapterView.field_username))
        {
          bool = WXHardCoderJNI.hcBizEnable;
          int j = WXHardCoderJNI.hcBizDelay;
          int k = WXHardCoderJNI.hcBizCPU;
          int m = WXHardCoderJNI.hcBizIO;
          if (WXHardCoderJNI.hcBizThr)
          {
            paramInt = Process.myTid();
            ad.i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(901), Integer.valueOf(WXHardCoderJNI.startPerformance(bool, j, k, m, paramInt, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener")) });
            if (!y.bNf()) {
              break label1363;
            }
            y.wN(true);
            localObject2 = new Intent(this.activity, BizTimeLineUI.class);
            ((Intent)localObject2).putExtra("KOpenArticleSceneFromScene", 93);
            ((Intent)localObject2).putExtra("Main_IndexInSessionList", i);
            ((Intent)localObject2).putExtra("Main_UnreadCount", paramAdapterView.field_unReadCount);
            localObject1 = this.activity;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            y.fpA();
            localObject1 = com.tencent.mm.pluginsdk.c.EIZ;
            com.tencent.mm.pluginsdk.c.eYP();
            ((b)com.tencent.mm.kernel.g.ab(b.class)).bNm();
          }
          for (;;)
          {
            this.KsY.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            paramInt = 0;
            break label1121;
            label1363:
            localObject1 = this.activity;
            localObject2 = new Intent(this.activity, BizConversationUI.class);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        if ((w.zE(paramAdapterView.field_username)) && (com.tencent.mm.am.g.DQ(paramAdapterView.field_username)))
        {
          if (!w.zD(paramAdapterView.field_username))
          {
            h.cl(this.activity, this.activity.getString(2131758445));
            AppMethodBeat.o(38324);
            return;
          }
          localObject2 = new Intent(this.activity, EnterpriseConversationUI.class);
          ((Intent)localObject2).putExtra("enterprise_biz_name", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("enterprise_biz_display_name", v.zf(paramAdapterView.field_username));
          ((Intent)localObject2).putExtra("enterprise_from_scene", 1);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.KsY.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if ((w.zE(paramAdapterView.field_username)) && (com.tencent.mm.am.g.vd(paramAdapterView.field_username)))
        {
          if (!w.zD(paramAdapterView.field_username))
          {
            h.cl(this.activity, this.activity.getString(2131758445));
            AppMethodBeat.o(38324);
            return;
          }
          localObject2 = new Intent(this.activity, BizChatConversationUI.class);
          ((Intent)localObject2).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("biz_chat_from_scene", 1);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.KsY.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (w.Am(paramAdapterView.field_username))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
          ((Intent)localObject2).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("app_brand_conversation_from_scene", 1);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.KsY.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        paramInt = 1;
        break label284;
      }
      label2063:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */