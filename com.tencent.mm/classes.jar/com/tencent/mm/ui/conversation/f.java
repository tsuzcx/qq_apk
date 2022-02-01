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
import com.tencent.mm.api.q;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class f
  implements AdapterView.OnItemClickListener
{
  private ListView Qbd;
  private i Qct;
  private Activity activity;
  
  public f(i parami, ListView paramListView, Activity paramActivity)
  {
    this.Qct = parami;
    this.Qbd = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38324);
    if (paramInt < this.Qbd.getHeaderViewsCount())
    {
      AppMethodBeat.o(38324);
      return;
    }
    int i = paramInt - this.Qbd.getHeaderViewsCount();
    Object localObject1;
    try
    {
      paramAdapterView = (az)this.Qct.akz(i);
      if (paramAdapterView == null)
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
        paramAdapterView = null;
      }
      if ((paramView.getTag() instanceof i.f))
      {
        localObject1 = (i.f)paramView.getTag();
        Log.i("MicroMsg.ConversationClickListener", "[onItemClick] position:%s [%s,%s]", new Object[] { Integer.valueOf(i), paramAdapterView.field_username, ((i.f)localObject1).username });
      }
      if (paramAdapterView.oV(16777216))
      {
        paramAdapterView.oU(16777216);
        bg.aVF();
        com.tencent.mm.model.c.aST().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.oV(33554432))
      {
        paramAdapterView.oU(33554432);
        bg.aVF();
        com.tencent.mm.model.c.aST().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (paramAdapterView.oV(134217728))
      {
        paramAdapterView.oU(134217728);
        bg.aVF();
        com.tencent.mm.model.c.aST().a(paramAdapterView, paramAdapterView.field_username);
      }
      if (!com.tencent.mm.model.ab.IY(paramAdapterView.field_username)) {
        break label357;
      }
    }
    if (z.aUv())
    {
      com.tencent.mm.br.c.V(this.activity, "tmessage", ".ui.TConversationUI");
      this.Qct.a(paramView, i, paramAdapterView.field_username);
      paramInt = 0;
    }
    for (;;)
    {
      label357:
      label1528:
      Object localObject2;
      if (paramInt != 0)
      {
        if (((as.bjp(paramAdapterView.field_username)) || (com.tencent.mm.model.ab.Iy(paramAdapterView.field_username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
        {
          AppMethodBeat.o(38324);
          return;
          com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          break;
          if (com.tencent.mm.model.ab.IZ(paramAdapterView.field_username))
          {
            if (z.aUu()) {
              com.tencent.mm.br.c.V(this.activity, "bottle", ".ui.BottleConversationUI");
            }
            for (;;)
            {
              this.Qct.a(paramView, i, paramAdapterView.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            }
          }
          if (com.tencent.mm.model.ab.Je(paramAdapterView.field_username))
          {
            MMAppMgr.cancelNotification(paramAdapterView.field_username);
            com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            this.Qct.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.IW(paramAdapterView.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            if (z.aUG())
            {
              paramInt = 1;
              continue;
            }
            com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            this.Qct.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.Jk(paramAdapterView.field_username)) {
            break label2471;
          }
          if (com.tencent.mm.model.ab.Jj(paramAdapterView.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            if (z.aUA())
            {
              localObject1 = new Intent();
              ((Intent)localObject1).addFlags(67108864);
              ((Intent)localObject1).putExtra("type", 20);
              com.tencent.mm.br.c.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
            }
            for (;;)
            {
              this.Qct.a(paramView, i, paramAdapterView.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            }
          }
          if (com.tencent.mm.model.ab.Jr(paramAdapterView.field_username))
          {
            if (z.aUB())
            {
              localObject1 = new Intent();
              ((Intent)localObject1).addFlags(67108864);
              ((Intent)localObject1).putExtra("type", 11);
              com.tencent.mm.br.c.b(this.activity, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
            }
            for (;;)
            {
              this.Qct.a(paramView, i, paramAdapterView.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            }
          }
          if (com.tencent.mm.model.ab.Jb(paramAdapterView.field_username))
          {
            com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            this.Qct.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.Jc(paramAdapterView.field_username))
          {
            if (z.aUD())
            {
              localObject1 = new Intent().addFlags(67108864);
              com.tencent.mm.br.c.b(this.activity, "masssend", ".ui.MassSendHistoryUI", (Intent)localObject1);
            }
            for (;;)
            {
              this.Qct.a(paramView, i, paramAdapterView.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
            }
          }
          if (com.tencent.mm.model.ab.Jq(paramAdapterView.field_username))
          {
            if (ay.a.iDt != null) {
              ay.a.iDt.Kl(paramAdapterView.field_username);
            }
            paramInt = 1;
            continue;
          }
          label1184:
          Object localObject3;
          if (com.tencent.mm.model.ab.Js(paramAdapterView.field_username))
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
              if (!com.tencent.mm.storage.ab.clc()) {
                break label1534;
              }
              if (!((q)com.tencent.mm.kernel.g.af(q.class)).Vv()) {
                break label1184;
              }
              ((b)com.tencent.mm.kernel.g.af(b.class)).hr(this.activity);
              ((q)com.tencent.mm.kernel.g.af(q.class)).o(9, paramAdapterView.field_username);
              paramInt = 0;
              break;
            }
            com.tencent.mm.storage.ab.AK(true);
            localObject3 = new Intent(this.activity, BizTimeLineUI.class);
            ((Intent)localObject3).putExtra("KOpenArticleSceneFromScene", 93);
            ((Intent)localObject3).putExtra("Main_IndexInSessionList", i);
            ((Intent)localObject3).putExtra("Main_UnreadCount", paramAdapterView.field_unReadCount);
            localObject1 = this.activity;
            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.storage.ab.gAX();
            localObject1 = com.tencent.mm.pluginsdk.c.JSr;
            com.tencent.mm.pluginsdk.c.glP();
            localObject1 = com.tencent.mm.plugin.biz.b.a.pfl;
            paramLong = com.tencent.mm.plugin.biz.b.a.aTI().decodeLong("BizLastMsgId");
            long l = com.tencent.mm.plugin.biz.b.a.aTI().decodeLong("BizLastMsgTime");
            localObject1 = (MultiProcessMMKV)com.tencent.mm.al.c.iNQ.getSlot();
            localObject3 = com.tencent.mm.plugin.biz.b.a.ahe(paramLong + '-' + l);
            if (((MultiProcessMMKV)localObject1).containsKey((String)localObject3))
            {
              localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes((String)localObject3);
              if (localObject1 != null) {
                if (localObject1.length == 0)
                {
                  paramInt = 1;
                  label1435:
                  if (paramInt != 0) {
                    break label1503;
                  }
                  paramInt = 1;
                  label1441:
                  if (paramInt == 0) {
                    break label1528;
                  }
                }
              }
            }
            for (;;)
            {
              try
              {
                localObject3 = ahh.class.newInstance();
                ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
                localObject1 = (com.tencent.mm.bw.a)localObject3;
                com.tencent.mm.plugin.biz.b.a.pfj = (ahh)localObject1;
                this.Qct.a(paramView, i, paramAdapterView.field_username);
                paramInt = 0;
              }
              catch (Exception localException)
              {
                label1503:
                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
              }
              paramInt = 0;
              break label1435;
              paramInt = 0;
              break label1441;
              localObject2 = null;
            }
            label1534:
            localObject2 = this.activity;
            localObject3 = new Intent(this.activity, BizConversationUI.class);
            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.Qct.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            continue;
          }
          if ((com.tencent.mm.model.ab.IT(paramAdapterView.field_username)) && (com.tencent.mm.al.g.Ng(paramAdapterView.field_username)))
          {
            if (!com.tencent.mm.model.ab.IS(paramAdapterView.field_username))
            {
              h.cD(this.activity, this.activity.getString(2131758743));
              AppMethodBeat.o(38324);
              return;
            }
            localObject3 = new Intent(this.activity, EnterpriseConversationUI.class);
            ((Intent)localObject3).putExtra("enterprise_biz_name", paramAdapterView.field_username);
            ((Intent)localObject3).putExtra("enterprise_biz_display_name", aa.getDisplayName(paramAdapterView.field_username));
            ((Intent)localObject3).putExtra("enterprise_from_scene", 1);
            localObject2 = this.activity;
            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.Qct.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            continue;
          }
          if ((com.tencent.mm.model.ab.IT(paramAdapterView.field_username)) && (com.tencent.mm.al.g.DQ(paramAdapterView.field_username)))
          {
            if (!com.tencent.mm.model.ab.IS(paramAdapterView.field_username))
            {
              h.cD(this.activity, this.activity.getString(2131758743));
              AppMethodBeat.o(38324);
              return;
            }
            localObject3 = new Intent(this.activity, BizChatConversationUI.class);
            ((Intent)localObject3).putExtra("Contact_User", paramAdapterView.field_username);
            ((Intent)localObject3).putExtra("biz_chat_from_scene", 1);
            ((Intent)localObject3).addFlags(67108864);
            localObject2 = this.activity;
            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.Qct.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            continue;
          }
          if (com.tencent.mm.model.ab.JB(paramAdapterView.field_username))
          {
            localObject3 = new Intent();
            ((Intent)localObject3).setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
            ((Intent)localObject3).putExtra("Contact_User", paramAdapterView.field_username);
            ((Intent)localObject3).putExtra("app_brand_conversation_from_scene", 1);
            ((Intent)localObject3).addFlags(67108864);
            localObject2 = this.activity;
            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.Qct.a(paramView, i, paramAdapterView.field_username);
            paramInt = 0;
            continue;
          }
          if ((com.tencent.mm.model.ab.Jx(paramAdapterView.field_username)) && (!WeChatBrands.Business.Entries.HomeNotifyMessage.checkAvailable(paramView.getContext())))
          {
            AppMethodBeat.o(38324);
            return;
          }
          paramInt = 1;
          continue;
        }
        if ((com.tencent.mm.model.ab.IJ(paramAdapterView.field_username)) && (!WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(paramView.getContext())))
        {
          AppMethodBeat.o(38324);
          return;
        }
        this.Qct.a(paramView, i, paramAdapterView.field_username);
        com.tencent.mm.plugin.report.service.g.Wl(9);
        paramView = (LauncherUI)this.activity;
        if (paramView == null) {
          break label2465;
        }
      }
      label2465:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("Launcher should not be empty.", bool);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("specific_chat_from_scene", 7);
        ((Bundle)localObject2).putInt("KOpenArticleSceneFromScene", 93);
        ((Bundle)localObject2).putInt("chat_from_scene_for_group_chats", 3);
        ((Bundle)localObject2).putInt("Main_IndexInSessionList", i);
        ((Bundle)localObject2).putInt("Main_UnreadCount", paramAdapterView.field_unReadCount);
        ((Bundle)localObject2).putInt("chat_from_scene", 0);
        paramView.startChatting(paramAdapterView.field_username, (Bundle)localObject2, true);
        if (com.tencent.mm.model.ab.Iy(paramAdapterView.field_username))
        {
          paramView = new gq();
          paramView.us(paramAdapterView.field_username);
          paramView.erw = 1L;
          paramView.bfK();
        }
        AppMethodBeat.o(38324);
        return;
      }
      label2471:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f
 * JD-Core Version:    0.7.0.1
 */