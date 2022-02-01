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
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.api.r;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.mmdata.rpt.an;
import com.tencent.mm.autogen.mmdata.rpt.lf;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class h
  implements AdapterView.OnItemClickListener
{
  private Activity activity;
  private ListView aflX;
  private k afnq;
  
  public h(k paramk, ListView paramListView, Activity paramActivity)
  {
    this.afnq = paramk;
    this.aflX = paramListView;
    this.activity = paramActivity;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38324);
    if (paramInt < this.aflX.getHeaderViewsCount())
    {
      AppMethodBeat.o(38324);
      return;
    }
    int i = paramInt - this.aflX.getHeaderViewsCount();
    bb localbb;
    try
    {
      localbb = (bb)this.afnq.azn(i);
      if (localbb == null)
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
        localbb = null;
      }
      if ((paramView.getTag() instanceof k.f))
      {
        paramAdapterView = (k.f)paramView.getTag();
        Log.i("MicroMsg.ConversationClickListener", "[onItemClick] position:%s [%s,%s]", new Object[] { Integer.valueOf(i), localbb.field_username, paramAdapterView.username });
      }
      if (localbb.rx(16777216))
      {
        localbb.rw(16777216);
        bh.bCz();
        com.tencent.mm.model.c.bzG().c(localbb, localbb.field_username);
      }
      if (localbb.rx(33554432))
      {
        localbb.rw(33554432);
        bh.bCz();
        com.tencent.mm.model.c.bzG().c(localbb, localbb.field_username);
      }
      if (localbb.rx(134217728))
      {
        localbb.rw(134217728);
        bh.bCz();
        com.tencent.mm.model.c.bzG().c(localbb, localbb.field_username);
      }
      if (localbb.field_hasSpecialFollow > 0)
      {
        localbb.pS(0);
        bh.bCz();
        com.tencent.mm.model.c.bzG().c(localbb, localbb.field_username);
      }
      if (!au.bvV(localbb.field_username)) {
        break label410;
      }
    }
    if (z.bBp())
    {
      com.tencent.mm.br.c.ai(this.activity, "tmessage", ".ui.TConversationUI");
      this.afnq.a(paramView, i, localbb.field_username);
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        if (((au.bwO(localbb.field_username)) || (au.bwF(localbb.field_username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
        {
          AppMethodBeat.o(38324);
          return;
          com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localbb.field_username));
          break;
          label410:
          if (au.bwB(localbb.field_username))
          {
            this.afnq.a(paramView, i, localbb.field_username);
            paramInt = 0;
            continue;
          }
          if (au.bvW(localbb.field_username))
          {
            if (z.bBo()) {
              com.tencent.mm.br.c.ai(this.activity, "bottle", ".ui.BottleConversationUI");
            }
            for (;;)
            {
              this.afnq.a(paramView, i, localbb.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localbb.field_username));
            }
          }
          if (au.bwb(localbb.field_username))
          {
            MMAppMgr.iH(localbb.field_username);
            com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localbb.field_username));
            this.afnq.a(paramView, i, localbb.field_username);
            paramInt = 0;
            continue;
          }
          if (au.bvS(localbb.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            if (z.bBA())
            {
              paramInt = 1;
              continue;
            }
            com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localbb.field_username));
            this.afnq.a(paramView, i, localbb.field_username);
            paramInt = 0;
            continue;
          }
          if (au.bwh(localbb.field_username)) {
            break label2941;
          }
          if (au.bwg(localbb.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomePluginQQMail.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            if (z.bBu())
            {
              paramAdapterView = new Intent();
              paramAdapterView.addFlags(67108864);
              paramAdapterView.putExtra("type", 20);
              com.tencent.mm.br.c.b(this.activity, "readerapp", ".ui.ReaderAppUI", paramAdapterView);
            }
            for (;;)
            {
              this.afnq.a(paramView, i, localbb.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localbb.field_username));
            }
          }
          if (au.bwo(localbb.field_username))
          {
            if (z.bBv())
            {
              paramAdapterView = new Intent();
              paramAdapterView.addFlags(67108864);
              paramAdapterView.putExtra("type", 11);
              com.tencent.mm.br.c.b(this.activity, "readerapp", ".ui.ReaderAppUI", paramAdapterView);
            }
            for (;;)
            {
              this.afnq.a(paramView, i, localbb.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localbb.field_username));
            }
          }
          if (au.bvY(localbb.field_username))
          {
            com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localbb.field_username));
            this.afnq.a(paramView, i, localbb.field_username);
            paramInt = 0;
            continue;
          }
          if (au.bvZ(localbb.field_username))
          {
            if (z.bBx())
            {
              paramAdapterView = new Intent().addFlags(67108864);
              com.tencent.mm.br.c.b(this.activity, "masssend", ".ui.MassSendHistoryUI", paramAdapterView);
            }
            for (;;)
            {
              this.afnq.a(paramView, i, localbb.field_username);
              paramInt = 0;
              break;
              com.tencent.mm.br.c.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", localbb.field_username));
            }
          }
          if (au.bwn(localbb.field_username))
          {
            if (az.a.okS != null) {
              az.a.okS.JC(localbb.field_username);
            }
            paramInt = 1;
            continue;
          }
          label1283:
          Object localObject;
          if (au.bwp(localbb.field_username))
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
              if (!((r)com.tencent.mm.kernel.h.ax(r.class)).aBw()) {
                break label1283;
              }
              ((d)com.tencent.mm.kernel.h.ax(d.class)).kg(this.activity);
              ((r)com.tencent.mm.kernel.h.ax(r.class)).p(9, localbb.field_username);
              paramInt = 0;
              break;
            }
            ad.KC(true);
            paramAdapterView = new Intent(this.activity, BizTimeLineUI.class);
            paramAdapterView.putExtra("KOpenArticleSceneFromScene", 93);
            paramAdapterView.putExtra("Main_IndexInSessionList", i);
            paramAdapterView.putExtra("Main_UnreadCount", localbb.field_unReadCount);
            if (localbb.rx(128))
            {
              localObject = com.tencent.mm.pluginsdk.model.c.XPt;
              com.tencent.mm.pluginsdk.model.c.iHm();
              if (localbb.rx(256))
              {
                paramAdapterView.putExtra("Main_BizFinderLiveRedDotType", 1);
                label1374:
                paramAdapterView.putExtra("Main_BizExposeMsgType", 7);
                paramAdapterView.putExtra("Main_FromUserName", localbb.field_digestUser);
                label1397:
                localObject = this.activity;
                paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAdapterView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAdapterView.aYi(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject).startActivity((Intent)paramAdapterView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ad.iYK();
                paramAdapterView = com.tencent.mm.pluginsdk.c.XNm;
                com.tencent.mm.pluginsdk.c.iGB();
                paramAdapterView = com.tencent.mm.plugin.biz.b.a.vtj;
                paramLong = com.tencent.mm.plugin.biz.b.a.atj().decodeLong("BizLastMsgId");
                long l = com.tencent.mm.plugin.biz.b.a.atj().decodeLong("BizLastMsgTime");
                localObject = (MMKVSlotManager)com.tencent.mm.an.c.ovO;
                paramAdapterView = com.tencent.mm.plugin.biz.b.a.aig(paramLong + '-' + l);
                localObject = (MultiProcessMMKV)((MMKVSlotManager)localObject).findSlot(paramAdapterView);
                if (localObject != null) {
                  break label1643;
                }
              }
            }
            label1670:
            label1712:
            label1735:
            for (paramAdapterView = null;; paramAdapterView = null)
            {
              com.tencent.mm.plugin.biz.b.a.vtl = (akj)paramAdapterView;
              this.afnq.a(paramView, i, localbb.field_username);
              paramInt = 0;
              break;
              paramAdapterView.putExtra("Main_BizFinderLiveRedDotType", 2);
              break label1374;
              localObject = v.acEJ;
              paramAdapterView.putExtra("Main_BizExposeMsgType", v.iXN());
              localObject = v.acEJ;
              paramAdapterView.putExtra("Main_FromUserName", v.iXO());
              break label1397;
              label1643:
              if (((MultiProcessMMKV)localObject).containsKey(paramAdapterView))
              {
                paramAdapterView = ((MultiProcessMMKV)localObject).decodeBytes(paramAdapterView);
                if (paramAdapterView != null)
                {
                  if (paramAdapterView.length == 0)
                  {
                    paramInt = 1;
                    if (paramInt != 0) {
                      break label1712;
                    }
                  }
                  for (paramInt = 1;; paramInt = 0)
                  {
                    for (;;)
                    {
                      if (paramInt == 0) {
                        break label1735;
                      }
                      try
                      {
                        localObject = akj.class.newInstance();
                        ((com.tencent.mm.bx.a)localObject).parseFrom(paramAdapterView);
                        paramAdapterView = (com.tencent.mm.bx.a)localObject;
                      }
                      catch (Exception paramAdapterView)
                      {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramAdapterView, "decode ProtoBuffer", new Object[0]);
                      }
                    }
                    paramInt = 0;
                    break label1670;
                  }
                }
              }
            }
          }
          if ((ab.IS(localbb.field_username)) && (com.tencent.mm.an.g.MB(localbb.field_username)))
          {
            if (!ab.IR(localbb.field_username))
            {
              com.tencent.mm.ui.base.k.cZ(this.activity, this.activity.getString(R.l.enterprise_not_contact));
              AppMethodBeat.o(38324);
              return;
            }
            localObject = new Intent(this.activity, EnterpriseConversationUI.class);
            ((Intent)localObject).putExtra("enterprise_biz_name", localbb.field_username);
            ((Intent)localObject).putExtra("enterprise_biz_display_name", aa.getDisplayName(localbb.field_username));
            ((Intent)localObject).putExtra("enterprise_from_scene", 1);
            paramAdapterView = this.activity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.afnq.a(paramView, i, localbb.field_username);
            paramInt = 0;
            continue;
          }
          if ((ab.IS(localbb.field_username)) && (com.tencent.mm.an.g.Dn(localbb.field_username)))
          {
            if (!ab.IR(localbb.field_username))
            {
              com.tencent.mm.ui.base.k.cZ(this.activity, this.activity.getString(R.l.enterprise_not_contact));
              AppMethodBeat.o(38324);
              return;
            }
            localObject = new Intent(this.activity, BizChatConversationUI.class);
            ((Intent)localObject).putExtra("Contact_User", localbb.field_username);
            ((Intent)localObject).putExtra("biz_chat_from_scene", 1);
            ((Intent)localObject).addFlags(67108864);
            paramAdapterView = this.activity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.afnq.a(paramView, i, localbb.field_username);
            paramInt = 0;
            continue;
          }
          if (au.bwy(localbb.field_username))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
            ((Intent)localObject).putExtra("Contact_User", localbb.field_username);
            ((Intent)localObject).putExtra("app_brand_conversation_from_scene", 1);
            ((Intent)localObject).addFlags(67108864);
            paramAdapterView = this.activity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.afnq.a(paramView, i, localbb.field_username);
            paramInt = 0;
            continue;
          }
          if (au.bwz(localbb.field_username))
          {
            paramAdapterView = new an();
            paramAdapterView.ila = 1L;
            if (localbb.field_unReadCount > 0) {}
            for (paramLong = 1L;; paramLong = 0L)
            {
              paramAdapterView.ioU = paramLong;
              paramAdapterView.bMH();
              localObject = new Intent();
              ((Intent)localObject).setClassName(this.activity, "com.tencent.mm.ui.conversation.ConvBoxServiceConversationUI");
              ((Intent)localObject).putExtra("Contact_User", localbb.field_username);
              paramAdapterView = this.activity;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              this.afnq.a(paramView, i, localbb.field_username);
              paramInt = 0;
              break;
            }
          }
          if (au.bwD(localbb.field_username))
          {
            localObject = new Intent();
            ((Intent)localObject).setClassName(this.activity, "com.tencent.mm.ui.conversation.OpenImKefuServiceConversationUI");
            ((Intent)localObject).putExtra("Contact_User", localbb.field_username);
            ((Intent)localObject).putExtra("open_im_kefu_conversation_list_ui_from_scene", 1);
            ((Intent)localObject).addFlags(67108864);
            paramAdapterView = this.activity;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAdapterView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/ui/conversation/ConversationClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.afnq.a(paramView, i, localbb.field_username);
            paramInt = 0;
            continue;
          }
          if (au.bwu(localbb.field_username))
          {
            if (!WeChatBrands.Business.Entries.HomeNotifyMessage.checkAvailable(paramView.getContext()))
            {
              AppMethodBeat.o(38324);
              return;
            }
            com.tencent.threadpool.h.ahAA.bo(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(256526);
                Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG("notifymessage");
                bb localbb = (bb)paramView.getTag(R.h.fDx);
                int j = ((Integer)paramView.getTag(R.h.fDz)).intValue();
                int k = (int)(((cc)localObject).getCreateTime() / 1000L);
                localObject = localbb.field_digest;
                if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acOa, true)) {}
                for (int i = 0;; i = 1)
                {
                  com.tencent.mm.plugin.report.service.h.OAn.b(22611, new Object[] { Integer.valueOf(2), Integer.valueOf(k), localObject, Integer.valueOf(i), Integer.valueOf(j) });
                  AppMethodBeat.o(256526);
                  return;
                }
              }
            });
          }
          paramInt = 1;
          continue;
        }
        if ((au.bxe(localbb.field_username)) && (!WeChatBrands.Business.Entries.HomePluginSports.checkAvailable(paramView.getContext())))
        {
          AppMethodBeat.o(38324);
          return;
        }
        this.afnq.a(paramView, i, localbb.field_username);
        com.tencent.mm.plugin.report.service.g.ahw(9);
        ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).clearTemplate();
        paramAdapterView = (LauncherUI)this.activity;
        if (paramAdapterView == null) {
          break label2935;
        }
      }
      label2935:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("Launcher should not be empty.", bool);
        paramView = new Bundle();
        paramView.putInt("specific_chat_from_scene", 7);
        paramView.putInt("KOpenArticleSceneFromScene", 93);
        paramView.putInt("chat_from_scene_for_group_chats", 3);
        paramView.putInt("Main_IndexInSessionList", i);
        paramView.putInt("Main_UnreadCount", localbb.field_unReadCount);
        paramView.putInt("chat_from_scene", 0);
        paramAdapterView.startChatting(localbb.field_username, paramView, true);
        if (au.bwF(localbb.field_username))
        {
          paramAdapterView = new lf();
          paramAdapterView.uc(localbb.field_username);
          paramAdapterView.iuA = 1L;
          paramAdapterView.bMH();
        }
        AppMethodBeat.o(38324);
        return;
      }
      label2941:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h
 * JD-Core Version:    0.7.0.1
 */