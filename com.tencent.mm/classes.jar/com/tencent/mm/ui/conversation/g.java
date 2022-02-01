package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.api.q;
import com.tencent.mm.f.b.a.iv;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class g
  implements AdapterView.OnItemClickListener
{
  private j XAI;
  private ListView Xzq;
  private Activity activity;
  
  public g(j paramj, ListView paramListView, Activity paramActivity)
  {
    this.XAI = paramj;
    this.Xzq = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38324);
    if (paramInt < this.Xzq.getHeaderViewsCount())
    {
      AppMethodBeat.o(38324);
      return;
    }
    int i = paramInt - this.Xzq.getHeaderViewsCount();
    az localaz;
    try
    {
      localaz = (az)this.XAI.asW(i);
      if (localaz == null)
      {
        Log.e("MicroMsg.ConversationClickListener", "null user at position = ".concat(String.valueOf(i)));
        AppMethodBeat.o(38324);
        return;
      }
    }
    catch (IllegalStateException paramAdapterView)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ConversationClickListener", paramAdapterView, "", new Object[0]);
        localaz = null;
      }
      if ((paramView.getTag() instanceof j.f))
      {
        paramAdapterView = (j.f)paramView.getTag();
        Log.i("MicroMsg.ConversationClickListener", "[onItemClick] position:%s [%s,%s]", new Object[] { Integer.valueOf(i), localaz.field_username, paramAdapterView.username });
      }
      if (localaz.rp(16777216))
      {
        localaz.ro(16777216);
        bh.beI();
        com.tencent.mm.model.c.bbR().a(localaz, localaz.field_username);
      }
      if (localaz.rp(33554432))
      {
        localaz.ro(33554432);
        bh.beI();
        com.tencent.mm.model.c.bbR().a(localaz, localaz.field_username);
      }
      if (localaz.rp(134217728))
      {
        localaz.ro(134217728);
        bh.beI();
        com.tencent.mm.model.c.bbR().a(localaz, localaz.field_username);
      }
      if (!com.tencent.mm.model.ab.Qr(localaz.field_username)) {
        break label376;
      }
    }
    if (z.bdx())
    {
      com.tencent.mm.by.c.ad(this.activity, "tmessage", ".ui.TConversationUI");
      this.XAI.a(paramView, i, localaz.field_username);
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        if (((as.bvK(localaz.field_username)) || (com.tencent.mm.model.ab.PQ(localaz.field_username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
        {
          AppMethodBeat.o(38324);
          return;
          com.tencent.mm.by.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localaz.field_username));
          break;
          label376:
          if (com.tencent.mm.model.ab.Qs(localaz.field_username))
          {
            if (z.bdw()) {
              com.tencent.mm.by.c.ad(this.activity, "bottle", ".ui.BottleConversationUI");
            }
            for (;;)
            {
              this.XAI.a(paramView, i, localaz.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.by.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localaz.field_username));
            }
          }
          if (com.tencent.mm.model.ab.Qx(localaz.field_username))
          {
            MMAppMgr.hg(localaz.field_username);
            com.tencent.mm.by.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localaz.field_username));
            this.XAI.a(paramView, i, localaz.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.Qp(localaz.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            if (z.bdI())
            {
              paramInt = 1;
              continue;
            }
            com.tencent.mm.by.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localaz.field_username));
            this.XAI.a(paramView, i, localaz.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.QD(localaz.field_username)) {
            break label2417;
          }
          if (com.tencent.mm.model.ab.QC(localaz.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            if (z.bdC())
            {
              paramAdapterView = new Intent();
              paramAdapterView.addFlags(67108864);
              paramAdapterView.putExtra("type", 20);
              com.tencent.mm.by.c.b(this.activity, "readerapp", ".ui.ReaderAppUI", paramAdapterView);
            }
            for (;;)
            {
              this.XAI.a(paramView, i, localaz.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.by.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localaz.field_username));
            }
          }
          if (com.tencent.mm.model.ab.QK(localaz.field_username))
          {
            if (z.bdD())
            {
              paramAdapterView = new Intent();
              paramAdapterView.addFlags(67108864);
              paramAdapterView.putExtra("type", 11);
              com.tencent.mm.by.c.b(this.activity, "readerapp", ".ui.ReaderAppUI", paramAdapterView);
            }
            for (;;)
            {
              this.XAI.a(paramView, i, localaz.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.by.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localaz.field_username));
            }
          }
          if (com.tencent.mm.model.ab.Qu(localaz.field_username))
          {
            com.tencent.mm.by.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localaz.field_username));
            this.XAI.a(paramView, i, localaz.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.Qv(localaz.field_username))
          {
            if (z.bdF())
            {
              paramAdapterView = new Intent().addFlags(67108864);
              com.tencent.mm.by.c.b(this.activity, "masssend", ".ui.MassSendHistoryUI", paramAdapterView);
            }
            for (;;)
            {
              this.XAI.a(paramView, i, localaz.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.by.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localaz.field_username));
            }
          }
          if (com.tencent.mm.model.ab.QJ(localaz.field_username))
          {
            if (az.a.ltu != null) {
              az.a.ltu.RE(localaz.field_username);
            }
            paramInt = 1;
            continue;
          }
          label1214:
          Object localObject;
          if (com.tencent.mm.model.ab.QL(localaz.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomeServiceOa.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            bool = WXHardCoderJNI.hcBizEnable;
            int j = WXHardCoderJNI.hcBizDelay;
            int k = WXHardCoderJNI.hcBizCPU;
            int m = WXHardCoderJNI.hcBizIO;
            if (WXHardCoderJNI.hcBizThr) {}
            for (paramInt = Process.myTid();; paramInt = 0)
            {
              Log.i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", new Object[] { Integer.valueOf(901), Integer.valueOf(WXHardCoderJNI.startPerformance(bool, j, k, m, paramInt, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener")) });
              if (!((q)com.tencent.mm.kernel.h.ae(q.class)).ZO()) {
                break label1214;
              }
              ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(this.activity);
              ((q)com.tencent.mm.kernel.h.ae(q.class)).p(9, localaz.field_username);
              paramInt = 0;
              break;
            }
            com.tencent.mm.storage.ab.ES(true);
            paramAdapterView = new Intent(this.activity, BizTimeLineUI.class);
            paramAdapterView.putExtra("KOpenArticleSceneFromScene", 93);
            paramAdapterView.putExtra("Main_IndexInSessionList", i);
            paramAdapterView.putExtra("Main_UnreadCount", localaz.field_unReadCount);
            if (localaz.rp(128))
            {
              localObject = com.tencent.mm.pluginsdk.model.b.QTJ;
              com.tencent.mm.pluginsdk.model.b.hgk();
            }
            localObject = this.activity;
            paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAdapterView);
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAdapterView.aFh(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject).startActivity((Intent)paramAdapterView.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.storage.ab.hxg();
            paramAdapterView = com.tencent.mm.pluginsdk.c.QRw;
            com.tencent.mm.pluginsdk.c.hfG();
            paramAdapterView = com.tencent.mm.plugin.biz.b.a.shp;
            paramLong = com.tencent.mm.plugin.biz.b.a.bcJ().decodeLong("BizLastMsgId");
            long l = com.tencent.mm.plugin.biz.b.a.bcJ().decodeLong("BizLastMsgTime");
            localObject = (MMKVSlotManager)com.tencent.mm.ao.c.lEh;
            paramAdapterView = com.tencent.mm.plugin.biz.b.a.aoK(paramLong + '-' + l);
            localObject = (MultiProcessMMKV)((MMKVSlotManager)localObject).findSlot(paramAdapterView);
            if (localObject != null) {
              if (((MultiProcessMMKV)localObject).containsKey(paramAdapterView))
              {
                paramAdapterView = ((MultiProcessMMKV)localObject).decodeBytes(paramAdapterView);
                if (paramAdapterView != null) {
                  if (paramAdapterView.length == 0)
                  {
                    paramInt = 1;
                    label1482:
                    if (paramInt != 0) {
                      break label1548;
                    }
                    paramInt = 1;
                    label1488:
                    if (paramInt == 0) {
                      break label1571;
                    }
                  }
                }
              }
            }
            for (;;)
            {
              try
              {
                localObject = ahs.class.newInstance();
                ((com.tencent.mm.cd.a)localObject).parseFrom(paramAdapterView);
                paramAdapterView = (com.tencent.mm.cd.a)localObject;
                com.tencent.mm.plugin.biz.b.a.shn = (ahs)paramAdapterView;
                this.XAI.a(paramView, i, localaz.field_username);
                paramInt = 0;
              }
              catch (Exception paramAdapterView)
              {
                label1548:
                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramAdapterView, "decode ProtoBuffer", new Object[0]);
              }
              paramInt = 0;
              break label1482;
              paramInt = 0;
              break label1488;
              label1571:
              paramAdapterView = null;
              continue;
              paramAdapterView = null;
            }
          }
          if ((com.tencent.mm.model.ab.Qm(localaz.field_username)) && (com.tencent.mm.ao.g.UC(localaz.field_username)))
          {
            if (!com.tencent.mm.model.ab.Ql(localaz.field_username))
            {
              com.tencent.mm.ui.base.h.cO(this.activity, this.activity.getString(R.l.eCw));
              AppMethodBeat.o(38324);
              return;
            }
            localObject = new Intent(this.activity, EnterpriseConversationUI.class);
            ((Intent)localObject).putExtra("enterprise_biz_name", localaz.field_username);
            ((Intent)localObject).putExtra("enterprise_biz_display_name", aa.PJ(localaz.field_username));
            ((Intent)localObject).putExtra("enterprise_from_scene", 1);
            paramAdapterView = this.activity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.XAI.a(paramView, i, localaz.field_username);
            paramInt = 0;
            continue;
          }
          if ((com.tencent.mm.model.ab.Qm(localaz.field_username)) && (com.tencent.mm.ao.g.KI(localaz.field_username)))
          {
            if (!com.tencent.mm.model.ab.Ql(localaz.field_username))
            {
              com.tencent.mm.ui.base.h.cO(this.activity, this.activity.getString(R.l.eCw));
              AppMethodBeat.o(38324);
              return;
            }
            localObject = new Intent(this.activity, BizChatConversationUI.class);
            ((Intent)localObject).putExtra("Contact_User", localaz.field_username);
            ((Intent)localObject).putExtra("biz_chat_from_scene", 1);
            ((Intent)localObject).addFlags(67108864);
            paramAdapterView = this.activity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.XAI.a(paramView, i, localaz.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.QU(localaz.field_username))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
            ((Intent)localObject).putExtra("Contact_User", localaz.field_username);
            ((Intent)localObject).putExtra("app_brand_conversation_from_scene", 1);
            ((Intent)localObject).addFlags(67108864);
            paramAdapterView = this.activity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.XAI.a(paramView, i, localaz.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.QQ(localaz.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomeNotifyMessage.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            com.tencent.e.h.ZvG.bg(new g.1(this, paramView));
          }
          paramInt = 1;
          continue;
        }
        if ((com.tencent.mm.model.ab.Qb(localaz.field_username)) && (!WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(paramView.getContext())))
        {
          AppMethodBeat.o(38324);
          return;
        }
        this.XAI.a(paramView, i, localaz.field_username);
        com.tencent.mm.plugin.report.service.g.ada(9);
        paramAdapterView = (LauncherUI)this.activity;
        if (paramAdapterView == null) {
          break label2411;
        }
      }
      label2411:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("Launcher should not be empty.", bool);
        paramView = new Bundle();
        paramView.putInt("specific_chat_from_scene", 7);
        paramView.putInt("KOpenArticleSceneFromScene", 93);
        paramView.putInt("chat_from_scene_for_group_chats", 3);
        paramView.putInt("Main_IndexInSessionList", i);
        paramView.putInt("Main_UnreadCount", localaz.field_unReadCount);
        paramView.putInt("chat_from_scene", 0);
        paramAdapterView.startChatting(localaz.field_username, paramView, true);
        if (com.tencent.mm.model.ab.PQ(localaz.field_username))
        {
          paramAdapterView = new iv();
          paramAdapterView.zR(localaz.field_username);
          paramAdapterView.gmT = 1L;
          paramAdapterView.bpa();
        }
        AppMethodBeat.o(38324);
        return;
      }
      label2417:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g
 * JD-Core Version:    0.7.0.1
 */