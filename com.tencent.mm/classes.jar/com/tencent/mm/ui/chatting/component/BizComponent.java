package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.an.a.d.a;
import com.tencent.mm.an.a.d.a.a;
import com.tencent.mm.an.a.d.a.b;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f.a;
import com.tencent.mm.an.f.a.a;
import com.tencent.mm.an.f.a.b;
import com.tencent.mm.an.i.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.app.plugin.exdevice.ChattingUIExDeviceLogic;
import com.tencent.mm.app.plugin.exdevice.ChattingUIExDeviceLogic.ExDeviceChattingUIStateEventListener;
import com.tencent.mm.app.plugin.exdevice.ChattingUIExDeviceLogic.OpFromExDeviceEventListener;
import com.tencent.mm.autogen.a.fk;
import com.tencent.mm.autogen.a.vv;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.msgsubscription.b.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ac.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.LiveBizSessionTipsBar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.component.api.ah;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.viewitems.bz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.e.class)
public class BizComponent
  extends a
  implements com.tencent.mm.an.p, MStorageEx.IOnStorageChange, com.tencent.mm.ui.chatting.component.api.e
{
  public boolean Aet;
  private IListener Ixi;
  private com.tencent.mm.plugin.brandservice.api.a Ixk;
  private boolean Jtp;
  private com.tencent.mm.api.c MVg;
  public com.tencent.mm.an.a.k MWW;
  private com.tencent.mm.ui.widget.a.e MXf;
  public com.tencent.mm.an.a.c aeaM;
  private d.a aebv;
  protected final ChatFooter.g aeeD;
  protected final a aefE;
  private ChattingUIExDeviceLogic aepa;
  private LiveBizSessionTipsBar aepb;
  private long aepc;
  private cc aepd;
  public boolean aepe;
  private long aepf;
  private RelativeLayout aepg;
  private TextView aeph;
  private int aepi;
  private boolean aepj;
  private boolean aepk;
  private f.a aepl;
  private boolean aepm;
  private ezh oww;
  private IListener vIq;
  
  public BizComponent()
  {
    AppMethodBeat.i(35100);
    this.aepb = null;
    this.Ixk = null;
    this.Ixi = null;
    this.aepc = 0L;
    this.Aet = false;
    this.aepe = false;
    this.aepf = -1L;
    this.MXf = null;
    this.oww = null;
    this.aefE = new a()
    {
      public final boolean jrn()
      {
        AppMethodBeat.i(35086);
        if (BizComponent.a(BizComponent.this) == null)
        {
          n.c(BizComponent.this.hlc.aezO, R.h.gcc);
          BizComponent.a(BizComponent.this, (RelativeLayout)BizComponent.this.hlc.findViewById(R.h.fuL));
          BizComponent.a(BizComponent.this, (TextView)BizComponent.this.hlc.findViewById(R.h.fuM));
          BizComponent.b(BizComponent.this).setText(R.l.chatfooter_getting);
        }
        BizComponent.a(BizComponent.this).setVisibility(0);
        com.tencent.mm.ui.chatting.d.a.juI().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35085);
            if ((BizComponent.a(BizComponent.this) != null) && (BizComponent.a(BizComponent.this).getVisibility() != 8)) {
              BizComponent.a(BizComponent.this).setVisibility(8);
            }
            if (BizComponent.this.hlc == null)
            {
              Log.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
              AppMethodBeat.o(35085);
              return;
            }
            ((com.tencent.mm.ui.chatting.component.api.ad)BizComponent.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).jrB();
            BizComponent.this.hlc.dcZ();
            AppMethodBeat.o(35085);
          }
        }, 5000L);
        AppMethodBeat.o(35086);
        return true;
      }
    };
    this.aeeD = new ChatFooter.g()
    {
      public final boolean Ke(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(35091);
        if (BizComponent.c(BizComponent.this) == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        Object localObject = BizComponent.c(BizComponent.this).dO(false);
        if (localObject == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = ((c.b)localObject).aBo();
        if ((localObject == null) || (((c.b.c)localObject).hdq == null) || (((c.b.c)localObject).hdq.isEmpty()))
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = (com.tencent.mm.an.k)((c.b.c)localObject).hdq.get(0);
        try
        {
          localObject = new JSONObject(((com.tencent.mm.an.k)localObject).value);
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1083;
          localAppBrandStatObject.hzx = BizComponent.c(BizComponent.this).field_username;
          ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(MMApplicationContext.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, BizComponent.c(BizComponent.this).field_appId);
          AppMethodBeat.o(35091);
          return true;
        }
        catch (JSONException localJSONException)
        {
          AppMethodBeat.o(35091);
        }
        return false;
      }
    };
    this.aepj = false;
    this.aebv = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35092);
        if ((BizComponent.this.Aet) && (paramAnonymousb != null) && (paramAnonymousb.oxB == BizComponent.this.jrk()))
        {
          if (!BizComponent.this.hlc.ffv)
          {
            Log.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
            AppMethodBeat.o(35092);
            return;
          }
          if (paramAnonymousb.oxL != d.a.a.oxI)
          {
            Log.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
            paramAnonymousb = af.bHh().dW(BizComponent.this.jrk());
            if (paramAnonymousb != null)
            {
              BizComponent.this.aeaM = paramAnonymousb;
              if (BizComponent.this.aepe) {
                break label168;
              }
              paramAnonymousb = af.bHj().hM(BizComponent.this.aeaM.field_bizChatServId);
              if (paramAnonymousb != null) {
                BizComponent.this.MWW = paramAnonymousb;
              }
            }
            for (;;)
            {
              ((com.tencent.mm.ui.chatting.component.api.ad)BizComponent.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).jrB();
              AppMethodBeat.o(35092);
              return;
              label168:
              BizComponent.a(BizComponent.this, com.tencent.mm.an.a.e.c(BizComponent.this.aeaM));
              ((com.tencent.mm.ui.chatting.component.api.ad)BizComponent.this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).jsI();
            }
          }
          if (BizComponent.this.aepe)
          {
            Toast.makeText(MMApplicationContext.getContext(), BizComponent.this.hlc.aezO.getMMResources().getString(R.l.gTK), 1).show();
            BizComponent.this.hlc.aezO.joU();
          }
        }
        AppMethodBeat.o(35092);
      }
    };
    this.Jtp = false;
    this.aepk = false;
    this.aepl = new f.a()
    {
      public final void a(final f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35094);
        if ((paramAnonymousb != null) && (paramAnonymousb.owf == f.a.a.owd) && (paramAnonymousb.ovT != null) && (paramAnonymousb.ovT.equals(BizComponent.this.hlc.getTalkerUserName())))
        {
          bh.bCz();
          final au localau = com.tencent.mm.model.c.bzA().JE(paramAnonymousb.ovT);
          if ((localau == null) || ((int)localau.maN == 0))
          {
            Log.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramAnonymousb.ovT });
            AppMethodBeat.o(35094);
            return;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35093);
              if ((BizComponent.d(BizComponent.this)) && (paramAnonymousb.ovT.equals(BizComponent.this.hlc.getTalkerUserName())))
              {
                Log.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                BizComponent.a(BizComponent.this, com.tencent.mm.an.g.hU(paramAnonymousb.ovT));
                if ((BizComponent.this.hlc != null) && (BizComponent.e(BizComponent.this))) {
                  ((x)BizComponent.this.hlc.cm(x.class)).aG(localau);
                }
              }
              AppMethodBeat.o(35093);
            }
          });
        }
        AppMethodBeat.o(35094);
      }
    };
    this.vIq = new BizComponent.5(this, com.tencent.mm.app.f.hfK);
    this.aepm = false;
    AppMethodBeat.o(35100);
  }
  
  public static boolean cg(Intent paramIntent)
  {
    AppMethodBeat.i(35101);
    String str = paramIntent.getStringExtra("Chat_User");
    boolean bool = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if ((!bool) && (str == null))
    {
      Log.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
      AppMethodBeat.o(35101);
      return true;
    }
    if ((bool) && (paramIntent.getLongExtra("key_biz_chat_id", -1L) == -1L))
    {
      Log.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
      AppMethodBeat.o(35101);
      return true;
    }
    AppMethodBeat.o(35101);
    return false;
  }
  
  private String cz(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35115);
    if (paramLinkedList.size() <= 0)
    {
      AppMethodBeat.o(35115);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.aeaM.getDisplayName((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.hlc.aezO.getContext().getString(R.l.chatroom_sys_msg_invite_split)).append(this.aeaM.getDisplayName((String)paramLinkedList.get(i)));
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(35115);
    return paramLinkedList;
  }
  
  private void iKP()
  {
    AppMethodBeat.i(35105);
    bt.O("bizflag", false);
    this.vIq.dead();
    Object localObject;
    String str1;
    if (this.Aet)
    {
      jrm();
      af.bHu();
      localObject = this.aeaM;
      str1 = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.an.a.c)localObject).field_brandUserName, ((com.tencent.mm.an.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
      com.tencent.mm.modelsimple.ac.a(((com.tencent.mm.an.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str1);
      Log.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str1 });
    }
    com.tencent.mm.kernel.h.baF();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this);
    int i = 0;
    if (this.aepc != 0L) {
      i = (int)(System.currentTimeMillis() - this.aepc) / 1000;
    }
    if (bh.baz())
    {
      if (this.Aet) {
        af.bHh().a(this.aebv);
      }
      if ((this.hlc.Uxa != null) && (this.hlc.Uxa.iZC())) {
        af.bHf().a(this.aepl);
      }
      if ((com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) && (this.hlc.Uxa.iZC()) && (!com.tencent.mm.an.g.Dn(this.hlc.getTalkerUserName())))
      {
        if ((this.MVg != null) && (this.MVg.aAM()))
        {
          if (this.oww == null) {
            this.oww = new ezh();
          }
          this.oww.abAs = i;
          this.oww.abAw = this.hlc.aezO.getIntExtra("Main_IndexInSessionList", 0);
          this.oww.abAu = this.hlc.aezO.getIntExtra("Main_UnreadCount", 0);
          if (this.aepd != null)
          {
            this.oww.abAv = this.aepd.getType();
            if (this.oww.abAu > 0) {
              this.oww.abAt = ((int)(this.aepc - this.aepd.getCreateTime()) / 1000);
            }
          }
        }
        af.bHs().a(this.hlc.getTalkerUserName(), this.oww);
      }
    }
    if ((ChattingUIExDeviceLogic.d(this.MVg)) && (this.aepa != null))
    {
      Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { jrh() });
      this.aepa.a(2, this.MVg);
      this.hlc.aezO.setMMSubTitle(null);
    }
    if ((com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) && (this.hlc.Uxa.iZC()) && (i != 0))
    {
      Intent localIntent = this.hlc.aezO.getContext().getIntent();
      String str2 = "";
      str1 = "";
      localObject = "";
      if (localIntent != null)
      {
        str2 = localIntent.getStringExtra("uinserve_search_id");
        str1 = localIntent.getStringExtra("uinserve_search_session_id");
        localObject = localIntent.getStringExtra("uinserve_search_time_token");
      }
      long l = System.currentTimeMillis();
      int j = this.hlc.aezO.getIntExtra("specific_chat_from_scene", 0);
      int k = com.tencent.mm.storage.ad.getSessionId();
      com.tencent.mm.plugin.report.service.h.OAn.b(10638, new Object[] { this.hlc.getTalkerUserName(), Integer.valueOf(i), Integer.valueOf(this.hlc.aezO.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.hlc.aezO.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l), str1 + ":" + str2 + ":" + (String)localObject });
    }
    if (this.aepa != null)
    {
      localObject = this.aepa;
      Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
      if (((ChattingUIExDeviceLogic)localObject).hld != null)
      {
        ((ChattingUIExDeviceLogic)localObject).hld.dead();
        ((ChattingUIExDeviceLogic)localObject).hld = null;
        if (((ChattingUIExDeviceLogic)localObject).hlg != null) {
          ((ChattingUIExDeviceLogic)localObject).hlg.clear();
        }
      }
      ((ChattingUIExDeviceLogic)localObject).hlh = false;
      if (((ChattingUIExDeviceLogic)localObject).hle != null)
      {
        ((ChattingUIExDeviceLogic)localObject).hle.dead();
        ((ChattingUIExDeviceLogic)localObject).hle = null;
      }
      this.aepa = null;
    }
    com.tencent.mm.storage.ad.bvE(null);
    this.aepc = 0L;
    jrd();
    if (this.Ixi != null)
    {
      this.Ixi.dead();
      this.Ixi = null;
    }
    Log.i("MicroMsg.ChattingUI.BizComponent", "doDestroy %s", new Object[] { this.hlc.getTalkerUserName() });
    AppMethodBeat.o(35105);
  }
  
  private void jra()
  {
    AppMethodBeat.i(256028);
    this.aepj = false;
    if ((this.hlc.Uxa != null) && (this.hlc.Uxa.iZC()))
    {
      this.aepj = true;
      af.bHt().Mh(this.hlc.Uxa.field_username);
    }
    AppMethodBeat.o(256028);
  }
  
  private void jrd()
  {
    AppMethodBeat.i(256031);
    if ((this.aepb != null) && (this.aepb.getVisibility() == 0))
    {
      Log.i("MicroMsg.ChattingUI.BizComponent", "hideLiveBizSessionTipsBar");
      this.aepb.setVisibility(8);
      this.hlc.aezO.getController().showActionbarLine();
    }
    AppMethodBeat.o(256031);
  }
  
  private void jrm()
  {
    AppMethodBeat.i(35116);
    if (!this.Aet)
    {
      AppMethodBeat.o(35116);
      return;
    }
    af.bHp();
    com.tencent.mm.an.a.h.o(this.hlc.getTalkerUserName(), this.aeaM.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(35116);
  }
  
  private boolean q(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35108);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.MVg == null) || (this.MVg.dO(false) == null) || (this.MVg.dO(false).aBo() == null) || (this.MVg.dO(false).aBo().hdq == null) || (this.MVg.dO(false).aBo().hdq.isEmpty()))) {
      ((x)this.hlc.cm(x.class)).jsd().kO(null);
    }
    AppMethodBeat.o(35108);
    return false;
  }
  
  public final String Nd(String paramString)
  {
    AppMethodBeat.i(35103);
    paramString = this.aeaM.MX(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(35103);
      return paramString;
    }
    AppMethodBeat.o(35103);
    return null;
  }
  
  public final void a(int paramInt, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(35111);
    if (paramp.getType() == 1357)
    {
      this.hlc.aDM();
      if (paramInt != 0) {
        Toast.makeText(MMApplicationContext.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gTq), 0).show();
      }
    }
    AppMethodBeat.o(35111);
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.d.a parama, bz parambz)
  {
    AppMethodBeat.i(256290);
    String str2 = z.bAM();
    String str3 = parambz.userName;
    String str1;
    Object localObject;
    int j;
    if (Util.isNullOrNil(parambz.aeXQ))
    {
      str1 = "";
      i = parambz.olT;
      if (com.tencent.mm.an.g.Mw(str3))
      {
        Log.d("MicroMsg.ChattingUI.BizComponent", "alvinluo reportBizAvatarClick brand: %s, username: %s, kfWorker: %s, kfType: %d", new Object[] { str3, str2, str1, Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.OAn.b(20008, new Object[] { Long.valueOf(this.aepc), str3, Integer.valueOf(1), str1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((Util.isNullOrNil(parambz.aeXQ)) || (Util.isNullOrNil(parambz.userName)) || (af.bHg() == null) || (!af.bHg().vR(parambz.olT))) {
        break label495;
      }
      localObject = af.bHg();
      str1 = parambz.userName;
      str3 = parambz.aeXQ;
      j = parambz.olT;
      Log.i("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle username: %s, brandUsername: %s, kfOpenId: %s, kfType: %d", new Object[] { str2, str1, str3, Integer.valueOf(j) });
      if (((com.tencent.mm.an.i)localObject).vR(j))
      {
        parambz = ((com.tencent.mm.an.i)localObject).owh;
        if ((Util.isNullOrNil(parambz.appId)) || (parambz.path == null)) {
          break label328;
        }
      }
    }
    label328:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label333;
      }
      parambz = null;
      if ((parambz == null) || (parama.aezO.getContext() == null)) {
        break label495;
      }
      ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(parama.aezO.getContext(), parambz);
      AppMethodBeat.o(256290);
      return true;
      str1 = parambz.aeXQ;
      break;
    }
    label333:
    parambz = new com.tencent.mm.plugin.appbrand.api.g();
    parambz.appId = ((com.tencent.mm.an.i)localObject).owh.appId;
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (i = ((com.tencent.mm.an.i)localObject).owh.euz;; i = 0)
    {
      parambz.euz = i;
      parambz.scene = 1166;
      parambz.hzx = str1;
      localObject = Uri.parse(((com.tencent.mm.an.i)localObject).owh.path).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("username", str2);
      ((Uri.Builder)localObject).appendQueryParameter("brandUsername", str1);
      ((Uri.Builder)localObject).appendQueryParameter("kfOpenId", str3);
      ((Uri.Builder)localObject).appendQueryParameter("kfType", String.valueOf(j));
      parambz.qAF = ((Uri.Builder)localObject).build().toString();
      Log.v("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle enterPath: %s", new Object[] { parambz.qAF });
      break;
    }
    label495:
    AppMethodBeat.o(256290);
    return false;
  }
  
  public final String bAJ(String paramString)
  {
    AppMethodBeat.i(35113);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://" + WeChatHosts.domainString(R.l.host_weixin_qq_com) + "/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) && (this.hlc.Uxa.iZC()) && (this.MVg != null))
      {
        c.b localb = this.MVg.dO(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.aBn())) && (paramString.contains(localb.aBn())))
        {
          AppMethodBeat.o(35113);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(35113);
    return null;
  }
  
  public final void cy(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35114);
    if (af.bHh().dW(jrk()) == null)
    {
      com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gTJ), null, this.hlc.aezO.getMMResources().getString(R.l.gTE), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35114);
      return;
    }
    final LinkedList localLinkedList = new LinkedList();
    List localList = this.aeaM.bHw();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((localList != null) && (localList.contains(str))) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() == 0)
    {
      if (paramLinkedList.size() == 1)
      {
        com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gTD), null, this.hlc.aezO.getMMResources().getString(R.l.gTE), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35114);
        return;
      }
      com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gTz), null, this.hlc.aezO.getMMResources().getString(R.l.gTE), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35114);
      return;
    }
    paramLinkedList = this.hlc.aezO.getMMResources().getString(R.l.gTx, new Object[] { cz(localLinkedList) });
    com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), paramLinkedList, null, this.hlc.aezO.getMMResources().getString(R.l.gTF), this.hlc.aezO.getMMResources().getString(R.l.app_cancel), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(35088);
        paramAnonymousDialogInterface = new os();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < localLinkedList.size())
        {
          or localor = new or();
          localor.YRR = ((String)localLinkedList.get(paramAnonymousInt));
          paramAnonymousDialogInterface.YRS.add(localor);
          paramAnonymousInt += 1;
        }
        BizComponent.a(BizComponent.this, paramAnonymousDialogInterface);
        AppMethodBeat.o(35088);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(35114);
  }
  
  public final void ej(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(256154);
    if (!Util.isEqual(paramString, this.hlc.getTalkerUserName()))
    {
      jrd();
      Log.i("MicroMsg.ChattingUI.BizComponent", "hideLiveBizSessionTipsBar not current user %s, %s", new Object[] { paramString, this.hlc.getTalkerUserName() });
      AppMethodBeat.o(256154);
      return;
    }
    if (!paramBoolean)
    {
      jrd();
      Log.i("MicroMsg.ChattingUI.BizComponent", "hideLiveBizSessionTipsBar not live now");
      AppMethodBeat.o(256154);
      return;
    }
    if (this.aepb == null)
    {
      n.c(this.hlc.aezO, R.h.gci);
      this.aepb = ((LiveBizSessionTipsBar)this.hlc.findViewById(R.h.live_biz_session_tipsbar));
      if (this.aepb == null)
      {
        Log.w("MicroMsg.ChattingUI.BizComponent", "liveBizSessionTipsBar is null");
        AppMethodBeat.o(256154);
        return;
      }
    }
    this.aepb.setChattingContext(this.hlc);
    this.aepb.setVisibility(0);
    this.hlc.aezO.getController().hideActionbarLine();
    AppMethodBeat.o(256154);
  }
  
  public final long etq()
  {
    return this.aepc;
  }
  
  public final void iQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(256294);
    Object localObject;
    int i;
    if ((!Util.isNullOrNil(paramString)) && (com.tencent.mm.an.g.Mw(paramString)))
    {
      localObject = (m)this.hlc.cm(m.class);
      if (((m)localObject).getCount() <= 0) {
        break label186;
      }
      localObject = ((m)localObject).aBV(((m)localObject).getCount() - 1);
      if (localObject != null) {
        break label192;
      }
      i = 1;
      label70:
      if (localObject != null) {
        break label268;
      }
      localObject = "";
    }
    for (;;)
    {
      Log.d("MicroMsg.ChattingUI.BizComponent", "alvinluo onFooterSwitchInput talker: %s, switchType: %d, lastMsgType: %d, sender: %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i), localObject });
      com.tencent.mm.plugin.report.service.h.OAn.b(20018, new Object[] { Long.valueOf(this.aepc), paramString, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), localObject, Integer.valueOf(1) });
      AppMethodBeat.o(256294);
      return;
      label186:
      localObject = null;
      break;
      label192:
      if (((cc)localObject).getType() == 285212721)
      {
        i = 2;
        break label70;
      }
      if (((cc)localObject).getType() == 318767153)
      {
        i = 5;
        break label70;
      }
      if (!Util.isNullOrNil(((fi)localObject).kLo))
      {
        if (((fi)localObject).kLu == 1)
        {
          i = 3;
          break label70;
        }
        if (((fi)localObject).kLu == 2)
        {
          i = 4;
          break label70;
        }
      }
      i = 0;
      break label70;
      label268:
      if (!Util.isNullOrNil(((fi)localObject).kLo)) {
        localObject = ((fi)localObject).kLo;
      } else if (((fi)localObject).field_isSend == 0) {
        localObject = ((fi)localObject).field_talker;
      } else {
        localObject = z.bAM();
      }
    }
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35119);
    this.aepf = this.hlc.aezO.getLongExtra("key_biz_chat_id", -1L);
    this.Aet = this.hlc.aezO.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    Log.i("MicroMsg.ChattingUI.BizComponent", "rawBizUserid %s %s", new Object[] { Long.valueOf(this.aepf), Boolean.valueOf(this.Aet) });
    if (this.Aet)
    {
      this.aeaM = af.bHh().dW(this.aepf);
      this.aeaM = com.tencent.mm.an.a.e.a(this.aeaM, this.aepf);
      localObject = af.bHi().iD(jrk());
      if (localObject != null) {
        this.aepi = ((com.tencent.mm.an.a.a)localObject).field_unReadCount;
      }
    }
    if ((this.Aet) && (com.tencent.mm.an.a.e.Nb(this.aeaM.field_bizChatServId))) {}
    for (boolean bool = true;; bool = false)
    {
      this.aepe = bool;
      if ((this.Aet) && (!this.aepe))
      {
        this.MWW = af.bHj().hM(this.aeaM.field_bizChatServId);
        this.MWW = com.tencent.mm.an.a.e.a(this.MWW, this.aeaM.field_bizChatServId);
      }
      if (this.aepe) {
        this.aepm = com.tencent.mm.an.a.e.c(this.aeaM);
      }
      this.MVg = com.tencent.mm.an.g.hU(this.hlc.getTalkerUserName());
      this.Jtp = true;
      if (this.hlc.Uxa.iZC())
      {
        localObject = com.tencent.mm.pluginsdk.model.c.XPt;
        if (com.tencent.mm.pluginsdk.model.c.iGZ()) {
          break;
        }
      }
      Log.i("MicroMsg.ChattingUI.BizComponent", "initLiveTipsBar return %d", new Object[] { Integer.valueOf(hashCode()) });
      jrd();
      AppMethodBeat.o(35119);
      return;
    }
    Object localObject = this.hlc.getTalkerUserName();
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    bool = com.tencent.mm.pluginsdk.model.c.bpf((String)localObject);
    Log.i("MicroMsg.ChattingUI.BizComponent", "initLiveTipsBar isLiveNow=%b, %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
    ej((String)localObject, bool);
    if (this.Ixi == null)
    {
      this.Ixi = new BizComponent.BizFinderLineStatusChangedEventListenerImpl(this);
      this.Ixi.alive();
    }
    AppMethodBeat.o(35119);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35120);
    this.aepc = System.currentTimeMillis();
    Object localObject = (m)this.hlc.cm(m.class);
    if (((m)localObject).getCount() > 0) {}
    for (localObject = ((m)localObject).aBV(((m)localObject).getCount() - 1);; localObject = null)
    {
      this.aepd = ((cc)localObject);
      com.tencent.mm.storage.ad.bvE(this.hlc.getTalkerUserName());
      if (this.Aet)
      {
        Log.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
        bh.baH().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35090);
            long l = System.currentTimeMillis();
            if ((BizComponent.this.Aet) && (BizComponent.this.aeaM != null) && (BizComponent.this.hlc.Uxa != null))
            {
              BizComponent.f(BizComponent.this);
              af.bHu();
              com.tencent.mm.an.a.c localc = BizComponent.this.aeaM;
              String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
              com.tencent.mm.modelsimple.ac.a(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
              Log.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
              if (BizComponent.this.aepe)
              {
                if (BizComponent.this.aeaM.bHy())
                {
                  af.bHp();
                  com.tencent.mm.an.a.h.bC(BizComponent.this.aeaM.field_bizChatServId, BizComponent.this.hlc.Uxa.field_username);
                }
              }
              else {
                BizComponent.g(BizComponent.this);
              }
            }
            for (;;)
            {
              Log.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              AppMethodBeat.o(35090);
              return;
              com.tencent.mm.an.a.e.f(BizComponent.this.aeaM);
              break;
              Log.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { BizComponent.this.aeaM, BizComponent.this.hlc.Uxa });
            }
          }
        }, 500L);
      }
      com.tencent.mm.kernel.h.baF();
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add(this);
      jra();
      this.vIq.alive();
      this.aepf = this.hlc.aezO.getLongExtra("key_biz_chat_id", -1L);
      if ((ChattingUIExDeviceLogic.d(this.MVg)) && (this.aepa == null))
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { jrh() });
        this.aepa = new ChattingUIExDeviceLogic(this.hlc);
      }
      if (this.hlc.Uxa.iZC()) {
        com.tencent.mm.bb.d.chatType = 2;
      }
      if (this.Aet) {
        af.bHh().a(this.aebv, Looper.getMainLooper());
      }
      if ((this.hlc.Uxa != null) && (this.hlc.Uxa.iZC())) {
        af.bHf().a(this.aepl, Looper.getMainLooper());
      }
      AppMethodBeat.o(35120);
      return;
    }
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35121);
    if ((com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) && (this.hlc.Uxa.iZC()) && (com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) && (this.hlc.Uxa.iZC()) && (!com.tencent.mm.an.g.Dn(this.hlc.getTalkerUserName())))
    {
      int i = this.hlc.aezO.getIntExtra("specific_chat_from_scene", 0);
      if (this.oww == null) {
        this.oww = new ezh();
      }
      this.oww.abAw = this.hlc.aezO.getIntExtra("Main_IndexInSessionList", 0);
      this.oww.abAu = this.hlc.aezO.getIntExtra("Main_UnreadCount", 0);
      if (this.aepd != null)
      {
        this.oww.abAv = this.aepd.getType();
        if (this.oww.abAu > 0) {
          this.oww.abAt = ((int)(this.aepc - this.aepd.getCreateTime()) / 1000);
        }
      }
      af.bHs().a(this.hlc.getTalkerUserName(), this.aepd, i, this.oww);
    }
    if (au.bwu(this.hlc.getTalkerUserName())) {
      com.tencent.threadpool.h.ahAA.j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(255834);
          BizComponent.h(BizComponent.this);
          AppMethodBeat.o(255834);
        }
      }, "ReportEnterNotifyMessage");
    }
    AppMethodBeat.o(35121);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35122);
    this.aepk = true;
    bt.O("bizflag", ((ah)this.hlc.cm(ah.class)).jti());
    Object localObject1 = com.tencent.mm.pluginsdk.model.c.XPt;
    int i;
    if (com.tencent.mm.pluginsdk.model.c.iGZ())
    {
      if ((this.aepb != null) && (this.aepb.getVisibility() == 0))
      {
        localObject1 = com.tencent.mm.pluginsdk.model.c.XPt;
        com.tencent.mm.pluginsdk.model.c.onResume();
      }
      localObject1 = this.hlc.getTalkerUserName();
      if (Util.isNullOrNil((String)localObject1)) {
        Log.i("MicroMsg.ChattingUI.BizComponent", "startCheck fail bizUserName is null");
      }
    }
    else
    {
      if ((this.MVg == null) || (ChattingUIExDeviceLogic.d(this.MVg)))
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { jrh() });
        if (this.aepa != null) {
          this.aepa.a(1, this.MVg);
        }
      }
      localObject1 = this.MVg;
      if ((localObject1 == null) || (localObject1 == null)) {
        break label653;
      }
      localObject1 = ((com.tencent.mm.api.c)localObject1).dO(false);
      if ((localObject1 == null) || (!((c.b)localObject1).aAZ())) {
        break label653;
      }
      i = 1;
      label179:
      if (i != 0) {
        bh.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35096);
            vv localvv = new vv();
            if (BizComponent.c(BizComponent.this) != null)
            {
              localvv.hZv.userName = BizComponent.c(BizComponent.this).field_username;
              localvv.publish();
            }
            AppMethodBeat.o(35096);
          }
        });
      }
      if ((!com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) || (!this.hlc.Uxa.iZC()) || (this.MVg == null)) {
        break label674;
      }
      localObject1 = this.MVg.dO(false);
      if ((localObject1 != null) && (((c.b)localObject1).aAL()))
      {
        if (this.MVg.field_hadAlert != 0) {
          break label658;
        }
        Object localObject2 = this.hlc.aezO.getContext().getResources().getString(R.l.gxa, new Object[] { this.hlc.Uxa.aSV() });
        String str = this.hlc.aezO.getContext().getResources().getString(R.l.gxb);
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("<sysmsg type=\"reportbizlocation\">");
        ((StringBuffer)localObject1).append("<reportbizlocation>");
        ((StringBuffer)localObject1).append("<text><![CDATA[").append((String)localObject2).append("]]></text>");
        ((StringBuffer)localObject1).append("<link>");
        ((StringBuffer)localObject1).append("<scene>reportbizlocation</scene>");
        ((StringBuffer)localObject1).append("<text><![CDATA[").append(str).append("]]></text>");
        ((StringBuffer)localObject1).append("</link>");
        ((StringBuffer)localObject1).append("</reportbizlocation>");
        ((StringBuffer)localObject1).append("</sysmsg>");
        localObject2 = new cc();
        ((cc)localObject2).BS(this.hlc.getTalkerUserName());
        ((cc)localObject2).pI(2);
        ((cc)localObject2).setType(10002);
        ((cc)localObject2).setCreateTime(br.bCJ());
        ((cc)localObject2).setContent(((StringBuffer)localObject1).toString());
        br.B((cc)localObject2);
        this.MVg.field_hadAlert = 1;
        af.bHf().update(this.MVg, new String[0]);
      }
      label497:
      if ((this.MVg.aAJ()) && ((!this.hlc.Uxa.iZC()) || (!com.tencent.mm.an.a.bGz())))
      {
        az.a.okP.aZ(this.hlc.Uxa.field_username, "");
        com.tencent.mm.modelavatar.d.LA(this.hlc.Uxa.field_username);
      }
      if (this.MVg.field_status == 1)
      {
        this.MVg.field_status = 0;
        af.bHf().h(this.MVg);
      }
    }
    for (;;)
    {
      jrl();
      AppMethodBeat.o(35122);
      return;
      if (!this.hlc.Uxa.iZC()) {
        break;
      }
      if (this.Ixk == null) {
        this.Ixk = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GX(4);
      }
      this.Ixk.aiO((String)localObject1);
      break;
      label653:
      i = 0;
      break label179;
      label658:
      af.bHs().MN(this.hlc.getTalkerUserName());
      break label497;
      label674:
      if ((!this.hlc.aezO.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) && (this.hlc.Uxa.iZC())) {
        MMHandlerThread.postToMainThread(new BizComponent.16(this));
      }
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35123);
    this.aepk = false;
    if ((com.tencent.mm.contact.d.rs(this.hlc.Uxa.field_type)) && (this.hlc.Uxa.iZC()) && (this.MVg != null))
    {
      af.bHs().bGU();
      if (this.MXf != null) {
        this.MXf.dismiss();
      }
    }
    a.a locala = com.tencent.mm.msgsubscription.b.a.piP;
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clearNotifyCallback");
    com.tencent.mm.msgsubscription.b.a.bPY().clear();
    if (this.Ixk != null) {
      this.Ixk.stopCheck();
    }
    AppMethodBeat.o(35123);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35124);
    this.Jtp = false;
    iKP();
    AppMethodBeat.o(35124);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256279);
    super.jjl();
    AppMethodBeat.o(256279);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35125);
    super.jqF();
    iKP();
    AppMethodBeat.o(35125);
  }
  
  public final com.tencent.mm.api.c jqS()
  {
    return this.MVg;
  }
  
  public final com.tencent.mm.an.a.c jqT()
  {
    return this.aeaM;
  }
  
  public final com.tencent.mm.an.a.k jqU()
  {
    return this.MWW;
  }
  
  public final boolean jqV()
  {
    return this.Aet;
  }
  
  public final boolean jqW()
  {
    return this.aepe;
  }
  
  public final boolean jqX()
  {
    AppMethodBeat.i(35102);
    if (this.Aet)
    {
      int i;
      if (this.aepe)
      {
        i = com.tencent.mm.an.a.e.iK(jrk());
        if (Util.isNullOrNil(this.aeaM.field_chatName)) {
          if (i == 0) {
            this.hlc.aezO.setMMTitle(this.hlc.aezO.getMMResources().getString(R.l.gzv));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35102);
        return true;
        this.hlc.aezO.setMMTitle(this.hlc.aezO.getMMResources().getString(R.l.gIp, new Object[] { this.hlc.aezO.getMMResources().getString(R.l.gzv), Integer.valueOf(i) }));
        continue;
        ((com.tencent.mm.ui.chatting.component.api.ad)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.ad.class)).setMMTitle(this.hlc.aezO.getMMResources().getString(R.l.gIp, new Object[] { this.aeaM.field_chatName, Integer.valueOf(i) }));
        continue;
        this.hlc.aezO.setMMTitle(this.MWW.field_userName);
      }
    }
    AppMethodBeat.o(35102);
    return false;
  }
  
  public final a jqY()
  {
    return this.aefE;
  }
  
  public final ChatFooter.g jqZ()
  {
    return this.aeeD;
  }
  
  public final List<cc> jrb()
  {
    int i = 100;
    AppMethodBeat.i(35104);
    Object localObject = af.bHi().iD(jrk());
    if (localObject != null) {
      if (((com.tencent.mm.an.a.a)localObject).field_unReadCount > 100) {
        bh.bCz();
      }
    }
    for (localObject = com.tencent.mm.model.c.bzE().y(this.hlc.Uxa.field_username, jrk(), i);; localObject = null)
    {
      AppMethodBeat.o(35104);
      return localObject;
      i = ((com.tencent.mm.an.a.a)localObject).field_unReadCount;
      break;
    }
  }
  
  public final boolean jrc()
  {
    return this.aepm;
  }
  
  public final void jre()
  {
    AppMethodBeat.i(35106);
    if (this.MVg == null)
    {
      AppMethodBeat.o(35106);
      return;
    }
    final boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.d.bJm()) && (!com.tencent.mm.modelgeo.d.bJn()))
    {
      bool = true;
      if ((this.MVg.field_hadAlert != 0) || (!bool)) {
        break label145;
      }
      str = this.hlc.aezO.getMMResources().getString(R.l.gwY, new Object[] { this.hlc.Uxa.aSV() });
    }
    for (;;)
    {
      this.MXf = com.tencent.mm.ui.base.k.a(this.hlc.aezO.getContext(), str, this.hlc.aezO.getMMResources().getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35098);
          BizComponent.c(BizComponent.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = BizComponent.c(BizComponent.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag |= 0x4;
            com.tencent.mm.an.g.j(paramAnonymousDialogInterface);
          }
          if (bool)
          {
            Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            paramAnonymousDialogInterface = BizComponent.this.hlc.aezO;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35098);
            return;
          }
          af.bHs().MN(BizComponent.this.hlc.getTalkerUserName());
          AppMethodBeat.o(35098);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35099);
          BizComponent.c(BizComponent.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = BizComponent.c(BizComponent.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag &= 0xFFFFFFFB;
            com.tencent.mm.an.g.j(paramAnonymousDialogInterface);
          }
          af.bHs().MN(BizComponent.this.hlc.getTalkerUserName());
          AppMethodBeat.o(35099);
        }
      });
      AppMethodBeat.o(35106);
      return;
      bool = false;
      break;
      label145:
      if (bool) {
        str = this.hlc.aezO.getMMResources().getString(R.l.gwZ);
      } else {
        str = this.hlc.aezO.getMMResources().getString(R.l.gwX, new Object[] { this.hlc.Uxa.aSV() });
      }
    }
  }
  
  public final void jrf()
  {
    AppMethodBeat.i(35107);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.hlc.getTalkerUserName());
    localIntent.putExtra("key_start_biz_profile_setting_from_scene", 1);
    com.tencent.mm.br.c.b(this.hlc.aezO.getContext(), "profile", ".ui.newbizinfo.NewBizInfoSettingUI", localIntent);
    AppMethodBeat.o(35107);
  }
  
  public final int jrg()
  {
    return this.aepi;
  }
  
  public final String jrh()
  {
    if (this.Aet) {
      if (this.aepe) {
        if (this.aeaM != null) {}
      }
    }
    while (this.hlc.Uxa == null)
    {
      do
      {
        return null;
        return this.aeaM.field_chatName;
      } while (this.MWW == null);
      return this.MWW.field_userName;
    }
    return this.hlc.Uxa.field_nickname;
  }
  
  public final boolean jri()
  {
    AppMethodBeat.i(35109);
    Object localObject1 = new Intent(this.hlc.aezO.getContext(), ChatroomInfoUI.class);
    int i;
    if ((this.hlc.juF()) || (this.aepe))
    {
      i = 1;
      if ((!au.bwE(this.hlc.getTalkerUserName())) || (!((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ(this.hlc.getTalkerUserName()))) {
        break label324;
      }
      bool1 = true;
      label86:
      if ((!au.bwE(this.hlc.getTalkerUserName())) || (v.If(this.hlc.getTalkerUserName()))) {
        break label329;
      }
    }
    Object localObject2;
    label324:
    label329:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.ChattingUI.BizComponent", "isChatroomDismiss = " + bool1 + ", inChatRoom = " + bool2);
      if (((i == 0) || (this.Aet)) && (!bool1) && (!bool2)) {
        break label334;
      }
      ((Intent)localObject1).putExtra("Chat_User", this.hlc.Uxa.field_username);
      ((Intent)localObject1).putExtra("RoomInfo_Id", this.hlc.getTalkerUserName());
      ((Intent)localObject1).putExtra("Is_Chatroom", this.hlc.juF());
      ((Intent)localObject1).putExtra("fromChatting", true);
      localObject2 = this.hlc;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35109);
      return true;
      i = 0;
      break;
      bool1 = false;
      break label86;
    }
    label334:
    if (this.Aet)
    {
      ((Intent)localObject1).setClass(this.hlc.aezO.getContext(), BizChatroomInfoUI.class);
      ((Intent)localObject1).putExtra("Chat_User", this.hlc.Uxa.field_username);
      ((Intent)localObject1).putExtra("key_biz_chat_id", jrk());
      if ((this.hlc.aezO.thisActivity() instanceof ChattingUI)) {
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        localObject2 = this.hlc.aezO;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((au.bww(this.hlc.getTalkerUserName())) || (au.bwL(this.hlc.getTalkerUserName())) || (au.bwN(this.hlc.getTalkerUserName())) || (au.bws(this.hlc.getTalkerUserName())) || (au.bwS(this.hlc.getTalkerUserName())) || (this.hlc.Uxa.iZC()))
    {
      localObject1 = new Intent();
      com.tencent.mm.ui.contact.e.t((Intent)localObject1, this.hlc.getTalkerUserName());
      if (this.hlc.aezO.getIntExtra("chat_from_scene", 0) == 2)
      {
        ((Intent)localObject1).putExtra("Kdel_from", 2);
        ((Intent)localObject1).putExtra("chat_from_scene", this.hlc.aezO.getIntExtra("chat_from_scene", 0));
        ((Intent)localObject1).putExtra("preUsername", this.hlc.getTalkerUserName());
        ((Intent)localObject1).putExtra("preChatName", this.hlc.getTalkerUserName());
        if ((this.MVg == null) || (!this.MVg.aAM())) {
          break label982;
        }
        i = 6;
        label729:
        ((Intent)localObject1).putExtra("preChatTYPE", this.hlc.aezO.getIntExtra("preChatTYPE", i));
        localObject2 = this.hlc.aezO.getContext().getIntent();
        i = ((Intent)localObject2).getIntExtra("key_temp_session_scene", 5);
        if ((i != 16) && (i != 17) && (!((Intent)localObject2).getBooleanExtra("key_biz_profile_stay_after_follow_op", false))) {
          break label1050;
        }
        ((Intent)localObject1).putExtra("Kdel_from", 1);
      }
    }
    label1050:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((Intent)localObject1).putExtra("key_biz_profile_stay_after_follow_op", bool1);
      if ((((ah)this.hlc.cm(ah.class)).jti()) && (n.bxa(this.hlc.getTalkerUserName())))
      {
        if (i != 16) {
          break label988;
        }
        ((Intent)localObject1).putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.hlc.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.a.d.rG(2);
          com.tencent.mm.plugin.newtips.a.gti();
          if (com.tencent.mm.plugin.newtips.a.e.aeE(com.tencent.mm.plugin.newtips.a.d.Msg))
          {
            com.tencent.mm.plugin.newtips.a.gtf();
            com.tencent.mm.plugin.newtips.a.i.aeG(com.tencent.mm.plugin.newtips.a.d.Msg);
            ((Intent)localObject1).putExtra("key_from_wesport_right_newtips", true);
          }
        }
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.br.c.b(this.hlc.aezO.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1, 213);
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("Kdel_from", 0);
        break;
        label982:
        i = 7;
        break label729;
        label988:
        if (i == 17) {
          ((Intent)localObject1).putExtra("Contact_Scene", 93);
        } else if (i == 18) {
          ((Intent)localObject1).putExtra("Contact_Scene", 94);
        } else {
          ((Intent)localObject1).putExtra("Contact_Scene", 81);
        }
      }
      AppMethodBeat.o(35109);
      return false;
    }
  }
  
  public final boolean jrj()
  {
    AppMethodBeat.i(35110);
    if (this.hlc == null)
    {
      Log.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
      AppMethodBeat.o(35110);
      return false;
    }
    Object localObject1;
    if ((this.hlc.Uxa.iZC()) && (this.MVg != null))
    {
      if (this.Aet)
      {
        bool = af.bHi().iF(jrk());
        AppMethodBeat.o(35110);
        return bool;
      }
      if (!this.MVg.aAQ()) {
        break label238;
      }
      if ((this.MVg.dO(false) != null) && (this.MVg.dO(false).aBr() != null) && (!Util.isNullOrNil(this.MVg.aAX())))
      {
        bh.bCz();
        localObject1 = com.tencent.mm.model.c.bzG().bye(this.MVg.aAX());
        if ((localObject1 != null) && (((bd)localObject1).field_username.equals(this.hlc.getTalkerUserName())) && (((bd)localObject1).field_unReadCount > 0))
        {
          if (this.hlc.aezO.getIntExtra("chat_from_scene", 0) == 2)
          {
            AppMethodBeat.o(35110);
            return false;
          }
          bh.bCz();
          com.tencent.mm.model.c.bzG().bxO(this.MVg.aAX());
        }
      }
    }
    while (au.bwp(this.hlc.getTalkerUserName()))
    {
      AppMethodBeat.o(35110);
      return true;
      label238:
      if ((!this.MVg.aAM()) && (!this.MVg.aAO()) && (af.bHl().iYB() > 0))
      {
        localObject1 = af.bHl();
        Object localObject2 = this.hlc.getTalkerUserName();
        localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + (String)localObject2 + "' ";
        ((com.tencent.mm.storage.ac)localObject1).omV.execSQL("BizTimeLineInfo", (String)localObject2);
        localObject2 = new ac.a();
        ((ac.a)localObject2).acFX = ac.b.acGb;
        ((com.tencent.mm.storage.ac)localObject1).a((ac.a)localObject2);
      }
    }
    bh.bCz();
    boolean bool = com.tencent.mm.model.c.bzG().bxO(this.hlc.getTalkerUserName());
    AppMethodBeat.o(35110);
    return bool;
  }
  
  public final long jrk()
  {
    if (this.aeaM == null) {
      return -1L;
    }
    return this.aeaM.field_bizChatLocalId;
  }
  
  public final void jrl()
  {
    AppMethodBeat.i(35112);
    bh.baH().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35087);
        if (BizComponent.this.hlc == null)
        {
          AppMethodBeat.o(35087);
          return;
        }
        boolean bool = ((m)BizComponent.this.hlc.cm(m.class)).jqo();
        if ((BizComponent.this.Aet) && (!bool)) {
          com.tencent.mm.an.a.e.d(BizComponent.this.aeaM);
        }
        AppMethodBeat.o(35087);
      }
    }, 500L);
    AppMethodBeat.o(35112);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35118);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35118);
      return;
      if (this.aepa != null)
      {
        paramIntent = this.aepa;
        if (paramIntent.hlc == null)
        {
          Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == -1)
        {
          Toast.makeText(paramIntent.hlc.aezO.getContext(), R.l.gGv, 0).show();
          fk localfk = new fk();
          localfk.hFE.op = 0;
          localfk.hFE.userName = paramIntent.hlc.getTalkerUserName();
          localfk.hFE.context = paramIntent.hlc.aezO.getContext();
          localfk.publish();
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == 0) {
          Toast.makeText(paramIntent.hlc.aezO.getContext(), R.l.gGu, 0).show();
        }
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35117);
    boolean bool = q(paramKeyEvent);
    AppMethodBeat.o(35117);
    return bool;
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(256129);
    Log.d("MicroMsg.ChattingUI.BizComponent", "onNotifyChange obj %s talker %s hasDoUpdateBizAttrs %b", new Object[] { paramObject, this.hlc.getTalkerUserName(), Boolean.valueOf(this.aepj) });
    if ((!this.aepj) && (Util.isEqual(paramObject, this.hlc.getTalkerUserName())))
    {
      if ((this.hlc.Uxa != null) && (this.hlc.Uxa.iZC())) {
        af.bHf().a(this.aepl, Looper.getMainLooper());
      }
      jra();
    }
    AppMethodBeat.o(256129);
  }
  
  public static abstract interface a
  {
    public abstract boolean jrn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.BizComponent
 * JD-Core Version:    0.7.0.1
 */