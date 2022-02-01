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
import com.tencent.mm.al.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.f;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class f
  implements AdapterView.OnItemClickListener
{
  private ListView KOd;
  private i KPs;
  private Activity activity;
  
  public f(i parami, ListView paramListView, Activity paramActivity)
  {
    this.KPs = parami;
    this.KOd = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38324);
    if (paramInt < this.KOd.getHeaderViewsCount())
    {
      AppMethodBeat.o(38324);
      return;
    }
    int i = paramInt - this.KOd.getHeaderViewsCount();
    Object localObject1;
    try
    {
      paramAdapterView = (au)this.KPs.abR(i);
      if (paramAdapterView == null)
      {
        ae.e("MicroMsg.ConversationClickListener", "null user at position = ".concat(String.valueOf(i)));
        AppMethodBeat.o(38324);
        return;
      }
    }
    catch (IllegalStateException paramAdapterView)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ConversationClickListener", paramAdapterView, "", new Object[0]);
        paramAdapterView = null;
      }
      if ((paramView.getTag() instanceof i.f))
      {
        localObject1 = (i.f)paramView.getTag();
        ae.i("MicroMsg.ConversationClickListener", "[onItemClick] position:%s [%s,%s]", new Object[] { Integer.valueOf(i), paramAdapterView.field_username, ((i.f)localObject1).username });
      }
      if (paramAdapterView.lS(16777216))
      {
        paramAdapterView.lR(16777216);
        bc.aCg();
        com.tencent.mm.model.c.azL().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.lS(33554432))
      {
        paramAdapterView.lR(33554432);
        bc.aCg();
        com.tencent.mm.model.c.azL().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.lS(134217728))
      {
        paramAdapterView.lR(134217728);
        bc.aCg();
        com.tencent.mm.model.c.azL().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (!x.At(paramAdapterView.field_username)) {
        break label468;
      }
    }
    if (v.aAY())
    {
      d.Q(this.activity, "tmessage", ".ui.TConversationUI");
      this.KPs.a(paramView, i, paramAdapterView.field_username);
      paramInt = 0;
    }
    label2049:
    for (;;)
    {
      label284:
      if (paramInt != 0)
      {
        this.KPs.a(paramView, i, paramAdapterView.field_username);
        com.tencent.mm.plugin.report.service.f.OP(9);
        paramView = (LauncherUI)this.activity;
        if (paramView == null) {
          break label2043;
        }
      }
      label468:
      label1121:
      label2038:
      label2043:
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
        if (x.zV(paramAdapterView.field_username))
        {
          paramView = new do();
          paramView.nl(paramAdapterView.field_username);
          paramView.dWm = 1L;
          paramView.aLH();
        }
        AppMethodBeat.o(38324);
        return;
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        break;
        if (x.Au(paramAdapterView.field_username))
        {
          if (v.aAX()) {
            d.Q(this.activity, "bottle", ".ui.BottleConversationUI");
          }
          for (;;)
          {
            this.KPs.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (x.Az(paramAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAdapterView.field_username);
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.KPs.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (x.Ar(paramAdapterView.field_username))
        {
          if (v.aBj()) {
            break label2038;
          }
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.KPs.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (x.AF(paramAdapterView.field_username)) {
          break label2049;
        }
        if (x.AE(paramAdapterView.field_username))
        {
          if (v.aBd())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("type", 20);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.KPs.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (x.AM(paramAdapterView.field_username))
        {
          if (v.aBe())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("type", 11);
            d.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.KPs.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (x.Aw(paramAdapterView.field_username))
        {
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          this.KPs.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (x.Ax(paramAdapterView.field_username))
        {
          if (v.aBg())
          {
            localObject1 = new Intent().addFlags(67108864);
            d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", (Intent)localObject1);
          }
          for (;;)
          {
            this.KPs.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          }
        }
        if (x.AL(paramAdapterView.field_username))
        {
          if (au.a.hIJ != null) {
            au.a.hIJ.BF(paramAdapterView.field_username);
          }
          paramInt = 1;
          break label284;
        }
        Object localObject2;
        if (x.AN(paramAdapterView.field_username))
        {
          bool = WXHardCoderJNI.hcBizEnable;
          int j = WXHardCoderJNI.hcBizDelay;
          int k = WXHardCoderJNI.hcBizCPU;
          int m = WXHardCoderJNI.hcBizIO;
          if (WXHardCoderJNI.hcBizThr)
          {
            paramInt = Process.myTid();
            ae.i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(901), Integer.valueOf(WXHardCoderJNI.startPerformance(bool, j, k, m, paramInt, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener")) });
            if (!y.bOd()) {
              break label1349;
            }
            y.wW(true);
            localObject2 = new Intent(this.activity, BizTimeLineUI.class);
            ((Intent)localObject2).putExtra("KOpenArticleSceneFromScene", 93);
            ((Intent)localObject2).putExtra("Main_IndexInSessionList", i);
            ((Intent)localObject2).putExtra("Main_UnreadCount", paramAdapterView.field_unReadCount);
            localObject1 = this.activity;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            y.ftz();
            localObject1 = com.tencent.mm.pluginsdk.c.Fbx;
            com.tencent.mm.pluginsdk.c.fcD();
          }
          for (;;)
          {
            this.KPs.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            break;
            paramInt = 0;
            break label1121;
            localObject1 = this.activity;
            localObject2 = new Intent(this.activity, BizConversationUI.class);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        if ((x.Ao(paramAdapterView.field_username)) && (g.Es(paramAdapterView.field_username)))
        {
          if (!x.An(paramAdapterView.field_username))
          {
            h.cm(this.activity, this.activity.getString(2131758445));
            AppMethodBeat.o(38324);
            return;
          }
          localObject2 = new Intent(this.activity, EnterpriseConversationUI.class);
          ((Intent)localObject2).putExtra("enterprise_biz_name", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("enterprise_biz_display_name", w.zP(paramAdapterView.field_username));
          ((Intent)localObject2).putExtra("enterprise_from_scene", 1);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.KPs.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if ((x.Ao(paramAdapterView.field_username)) && (g.vz(paramAdapterView.field_username)))
        {
          if (!x.An(paramAdapterView.field_username))
          {
            h.cm(this.activity, this.activity.getString(2131758445));
            AppMethodBeat.o(38324);
            return;
          }
          localObject2 = new Intent(this.activity, BizChatConversationUI.class);
          ((Intent)localObject2).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("biz_chat_from_scene", 1);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.KPs.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        if (x.AW(paramAdapterView.field_username))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
          ((Intent)localObject2).putExtra("Contact_User", paramAdapterView.field_username);
          ((Intent)localObject2).putExtra("app_brand_conversation_from_scene", 1);
          ((Intent)localObject2).addFlags(67108864);
          localObject1 = this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.KPs.a(paramView, i, paramAdapterView.field_username);
          paramInt = 0;
          break label284;
        }
        paramInt = 1;
        break label284;
      }
      label1349:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */