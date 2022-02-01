package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
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
import com.tencent.mm.an.q;
import com.tencent.mm.ao.a.d.a;
import com.tencent.mm.ao.a.d.a.a;
import com.tencent.mm.ao.a.d.a.b;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.f.a;
import com.tencent.mm.ao.f.a.a;
import com.tencent.mm.ao.f.a.b;
import com.tencent.mm.ao.i.a;
import com.tencent.mm.ao.p;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.f.a.ez;
import com.tencent.mm.f.a.uf;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.msgsubscription.b.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.pluginsdk.model.b.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.aa.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.LiveBizSessionTipsBar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.by;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.d.class)
public class c
  extends a
  implements p, com.tencent.mm.ui.chatting.d.b.d
{
  private boolean DAn;
  private com.tencent.mm.api.c GXj;
  public com.tencent.mm.ao.a.k GYT;
  private com.tencent.mm.ui.widget.a.d GZc;
  private com.tencent.mm.plugin.brandservice.a.a Hgq;
  private IListener Hgr;
  private com.tencent.mm.app.plugin.a.a WGV;
  private LiveBizSessionTipsBar WGW;
  private long WGX;
  private ca WGY;
  public boolean WGZ;
  private long WHa;
  private RelativeLayout WHb;
  private TextView WHc;
  private int WHd;
  private boolean WHe;
  private f.a WHf;
  private boolean WHg;
  public com.tencent.mm.ao.a.c Wtt;
  private d.a Wud;
  protected final ChatFooter.g Wxl;
  protected final b Wyh;
  private efo lEQ;
  private IListener sCy;
  public boolean wIf;
  
  public c()
  {
    AppMethodBeat.i(35100);
    this.WGW = null;
    this.Hgq = null;
    this.Hgr = null;
    this.WGX = 0L;
    this.wIf = false;
    this.WGZ = false;
    this.WHa = -1L;
    this.GZc = null;
    this.lEQ = null;
    this.Wyh = new b()
    {
      public final boolean hOv()
      {
        AppMethodBeat.i(35086);
        if (c.a(c.this) == null)
        {
          m.a(c.this.fgR.WQv, R.h.dZi);
          c.a(c.this, (RelativeLayout)c.this.fgR.findViewById(R.h.duv));
          c.a(c.this, (TextView)c.this.fgR.findViewById(R.h.duw));
          c.b(c.this).setText(R.l.chatfooter_getting);
        }
        c.a(c.this).setVisibility(0);
        com.tencent.mm.ui.chatting.e.a.hRl().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35085);
            if ((c.a(c.this) != null) && (c.a(c.this).getVisibility() != 8)) {
              c.a(c.this).setVisibility(8);
            }
            if (c.this.fgR == null)
            {
              Log.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
              AppMethodBeat.o(35085);
              return;
            }
            ((com.tencent.mm.ui.chatting.d.b.aa)c.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).hOL();
            c.this.fgR.cAe();
            AppMethodBeat.o(35085);
          }
        }, 5000L);
        AppMethodBeat.o(35086);
        return true;
      }
    };
    this.Wxl = new ChatFooter.g()
    {
      public final boolean Et(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(35091);
        if (c.c(c.this) == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        Object localObject = c.c(c.this).dc(false);
        if (localObject == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = ((com.tencent.mm.api.c.b)localObject).Zw();
        if ((localObject == null) || (((c.b.c)localObject).eZQ == null) || (((c.b.c)localObject).eZQ.isEmpty()))
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = (com.tencent.mm.ao.k)((c.b.c)localObject).eZQ.get(0);
        try
        {
          localObject = new JSONObject(((com.tencent.mm.ao.k)localObject).value);
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1083;
          localAppBrandStatObject.fvd = c.c(c.this).field_username;
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(MMApplicationContext.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, c.c(c.this).field_appId);
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
    this.Wud = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35092);
        if ((c.this.wIf) && (paramAnonymousb != null) && (paramAnonymousb.lFU == c.this.hOs()))
        {
          if (!c.this.fgR.dgo)
          {
            Log.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
            AppMethodBeat.o(35092);
            return;
          }
          if (paramAnonymousb.lGe != d.a.a.lGb)
          {
            Log.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
            paramAnonymousb = af.bjx().bF(c.this.hOs());
            c.this.Wtt = paramAnonymousb;
            if (!c.this.WGZ)
            {
              paramAnonymousb = af.bjz().gm(c.this.Wtt.field_bizChatServId);
              if (paramAnonymousb != null) {
                c.this.GYT = paramAnonymousb;
              }
            }
            for (;;)
            {
              ((com.tencent.mm.ui.chatting.d.b.aa)c.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).hOL();
              AppMethodBeat.o(35092);
              return;
              c.a(c.this, com.tencent.mm.ao.a.e.c(c.this.Wtt));
              ((com.tencent.mm.ui.chatting.d.b.aa)c.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).hPL();
            }
          }
          if (c.this.WGZ)
          {
            Toast.makeText(MMApplicationContext.getContext(), c.this.fgR.WQv.getMMResources().getString(R.l.eRe), 1).show();
            c.this.fgR.WQv.hMr();
          }
        }
        AppMethodBeat.o(35092);
      }
    };
    this.DAn = false;
    this.WHe = false;
    this.WHf = new f.a()
    {
      public final void a(final f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35094);
        if ((paramAnonymousb != null) && (paramAnonymousb.lEy == f.a.a.lEw) && (paramAnonymousb.lEm != null) && (paramAnonymousb.lEm.equals(c.this.fgR.getTalkerUserName())))
        {
          bh.beI();
          final as localas = com.tencent.mm.model.c.bbL().RG(paramAnonymousb.lEm);
          if ((localas == null) || ((int)localas.jxt == 0))
          {
            Log.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramAnonymousb.lEm });
            AppMethodBeat.o(35094);
            return;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35093);
              if ((c.d(c.this)) && (paramAnonymousb.lEm.equals(c.this.fgR.getTalkerUserName())))
              {
                Log.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                c.a(c.this, com.tencent.mm.ao.g.gu(paramAnonymousb.lEm));
                if ((c.this.fgR != null) && (c.e(c.this))) {
                  ((u)c.this.fgR.bC(u.class)).aA(localas);
                }
              }
              AppMethodBeat.o(35093);
            }
          });
        }
        AppMethodBeat.o(35094);
      }
    };
    this.sCy = new c.13(this);
    this.WHg = false;
    AppMethodBeat.o(35100);
  }
  
  public static boolean bD(Intent paramIntent)
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
  
  private String cl(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35115);
    if (paramLinkedList.size() <= 0)
    {
      AppMethodBeat.o(35115);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.Wtt.PJ((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.fgR.WQv.getContext().getString(R.l.chatroom_sys_msg_invite_split)).append(this.Wtt.PJ((String)paramLinkedList.get(i)));
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(35115);
    return paramLinkedList;
  }
  
  private void hOl()
  {
    AppMethodBeat.i(273177);
    if (this.WGW != null)
    {
      this.WGW.setVisibility(8);
      this.fgR.WQv.getController().showActionbarLine();
    }
    AppMethodBeat.o(273177);
  }
  
  private void hOu()
  {
    AppMethodBeat.i(35116);
    if (!this.wIf)
    {
      AppMethodBeat.o(35116);
      return;
    }
    af.bjE();
    com.tencent.mm.ao.a.h.l(this.fgR.getTalkerUserName(), this.Wtt.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(35116);
  }
  
  private void hjX()
  {
    AppMethodBeat.i(35105);
    bs.K("bizflag", false);
    this.sCy.dead();
    Object localObject;
    if (this.wIf)
    {
      hOu();
      af.bjJ();
      localObject = this.Wtt;
      if (com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.h.aHE().kbN))
      {
        String str = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.ao.a.c)localObject).field_brandUserName, ((com.tencent.mm.ao.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.modelsimple.ab.b(((com.tencent.mm.ao.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str);
        Log.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str });
      }
    }
    if (this.WGX != 0L) {}
    for (int i = (int)(System.currentTimeMillis() - this.WGX) / 1000;; i = 0)
    {
      if (bh.aHB())
      {
        if (this.wIf) {
          af.bjx().a(this.Wud);
        }
        if ((this.fgR.NKq != null) && (this.fgR.NKq.hxX())) {
          af.bjv().a(this.WHf);
        }
        if ((com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) && (this.fgR.NKq.hxX()) && (!com.tencent.mm.ao.g.KI(this.fgR.getTalkerUserName())))
        {
          if ((this.GXj != null) && (this.GXj.YU()))
          {
            if (this.lEQ == null) {
              this.lEQ = new efo();
            }
            this.lEQ.UiT = i;
            this.lEQ.UiX = this.fgR.WQv.getIntExtra("Main_IndexInSessionList", 0);
            this.lEQ.UiV = this.fgR.WQv.getIntExtra("Main_UnreadCount", 0);
            if (this.WGY != null)
            {
              this.lEQ.UiW = this.WGY.getType();
              if (this.lEQ.UiV > 0) {
                this.lEQ.UiU = ((int)(this.WGX - this.WGY.field_createTime) / 1000);
              }
            }
          }
          af.bjH().a(this.fgR.getTalkerUserName(), this.lEQ);
        }
      }
      if ((com.tencent.mm.app.plugin.a.a.d(this.GXj)) && (this.WGV != null))
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { hOp() });
        this.WGV.a(2, this.GXj);
        this.fgR.WQv.setMMSubTitle(null);
      }
      if ((com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) && (this.fgR.NKq.hxX()) && (i != 0))
      {
        int j = this.fgR.WQv.getIntExtra("specific_chat_from_scene", 0);
        int k = com.tencent.mm.storage.ab.getSessionId();
        com.tencent.mm.plugin.report.service.h.IzE.a(10638, new Object[] { this.fgR.getTalkerUserName(), Integer.valueOf(i), Integer.valueOf(this.fgR.WQv.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.fgR.WQv.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(j), Integer.valueOf(k) });
      }
      if (this.WGV != null)
      {
        localObject = this.WGV;
        Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
        if (((com.tencent.mm.app.plugin.a.a)localObject).fgS != null)
        {
          EventCenter.instance.removeListener(((com.tencent.mm.app.plugin.a.a)localObject).fgS);
          ((com.tencent.mm.app.plugin.a.a)localObject).fgS = null;
          if (((com.tencent.mm.app.plugin.a.a)localObject).fgV != null) {
            ((com.tencent.mm.app.plugin.a.a)localObject).fgV.clear();
          }
        }
        ((com.tencent.mm.app.plugin.a.a)localObject).fgW = false;
        if (((com.tencent.mm.app.plugin.a.a)localObject).fgT != null)
        {
          EventCenter.instance.removeListener(((com.tencent.mm.app.plugin.a.a)localObject).fgT);
          ((com.tencent.mm.app.plugin.a.a)localObject).fgT = null;
        }
        this.WGV = null;
      }
      com.tencent.mm.storage.ab.bvv(null);
      this.WGX = 0L;
      AppMethodBeat.o(35105);
      return;
    }
  }
  
  private boolean i(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35108);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.GXj == null) || (this.GXj.dc(false) == null) || (this.GXj.dc(false).Zw() == null) || (this.GXj.dc(false).Zw().eZQ == null) || (this.GXj.dc(false).Zw().eZQ.isEmpty()))) {
      ((u)this.fgR.bC(u.class)).hPj().hy(null);
    }
    AppMethodBeat.o(35108);
    return false;
  }
  
  public final String Ve(String paramString)
  {
    AppMethodBeat.i(35103);
    paramString = this.Wtt.UY(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(35103);
      return paramString;
    }
    AppMethodBeat.o(35103);
    return null;
  }
  
  public final void a(int paramInt, q paramq)
  {
    AppMethodBeat.i(35111);
    if (paramq.getType() == 1357)
    {
      this.fgR.dismissDialog();
      if (paramInt != 0) {
        Toast.makeText(MMApplicationContext.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eQK), 0).show();
      }
    }
    AppMethodBeat.o(35111);
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.e.a parama, by paramby)
  {
    AppMethodBeat.i(273194);
    String str2 = z.bcZ();
    String str3 = paramby.userName;
    String str1;
    Object localObject;
    int j;
    if (Util.isNullOrNil(paramby.XmL))
    {
      str1 = "";
      i = paramby.luu;
      if (com.tencent.mm.ao.g.Ux(str3))
      {
        Log.d("MicroMsg.ChattingUI.BizComponent", "alvinluo reportBizAvatarClick brand: %s, username: %s, kfWorker: %s, kfType: %d", new Object[] { str3, str2, str1, Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.IzE.a(20008, new Object[] { Long.valueOf(this.WGX), str3, Integer.valueOf(1), str1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((Util.isNullOrNil(paramby.XmL)) || (Util.isNullOrNil(paramby.userName)) || (af.bjw() == null) || (!af.bjw().vM(paramby.luu))) {
        break label495;
      }
      localObject = af.bjw();
      str1 = paramby.userName;
      str3 = paramby.XmL;
      j = paramby.luu;
      Log.i("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle username: %s, brandUsername: %s, kfOpenId: %s, kfType: %d", new Object[] { str2, str1, str3, Integer.valueOf(j) });
      if (((com.tencent.mm.ao.i)localObject).vM(j))
      {
        paramby = ((com.tencent.mm.ao.i)localObject).lEA;
        if ((Util.isNullOrNil(paramby.appId)) || (paramby.path == null)) {
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
      paramby = null;
      if ((paramby == null) || (parama.WQv.getContext() == null)) {
        break label495;
      }
      ((r)com.tencent.mm.kernel.h.ae(r.class)).a(parama.WQv.getContext(), paramby);
      AppMethodBeat.o(273194);
      return true;
      str1 = paramby.XmL;
      break;
    }
    label333:
    paramby = new com.tencent.mm.plugin.appbrand.api.g();
    paramby.appId = ((com.tencent.mm.ao.i)localObject).lEA.appId;
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (i = ((com.tencent.mm.ao.i)localObject).lEA.cBU;; i = 0)
    {
      paramby.cBU = i;
      paramby.scene = 1166;
      paramby.fvd = str1;
      localObject = Uri.parse(((com.tencent.mm.ao.i)localObject).lEA.path).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("username", str2);
      ((Uri.Builder)localObject).appendQueryParameter("brandUsername", str1);
      ((Uri.Builder)localObject).appendQueryParameter("kfOpenId", str3);
      ((Uri.Builder)localObject).appendQueryParameter("kfType", String.valueOf(j));
      paramby.nBq = ((Uri.Builder)localObject).build().toString();
      Log.v("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle enterPath: %s", new Object[] { paramby.nBq });
      break;
    }
    label495:
    AppMethodBeat.o(273194);
    return false;
  }
  
  public final long amU()
  {
    return this.WGX;
  }
  
  public final String bzf(String paramString)
  {
    AppMethodBeat.i(35113);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://" + WeChatHosts.domainString(R.l.host_weixin_qq_com) + "/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) && (this.fgR.NKq.hxX()) && (this.GXj != null))
      {
        com.tencent.mm.api.c.b localb = this.GXj.dc(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.Zv())) && (paramString.contains(localb.Zv())))
        {
          AppMethodBeat.o(35113);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(35113);
    return null;
  }
  
  public final void ck(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35114);
    af.bjx().bF(hOs());
    LinkedList localLinkedList = new LinkedList();
    List localList = this.Wtt.bjL();
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
        com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eQX), null, this.fgR.WQv.getMMResources().getString(R.l.eQY), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35114);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eQT), null, this.fgR.WQv.getMMResources().getString(R.l.eQY), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35114);
      return;
    }
    paramLinkedList = this.fgR.WQv.getMMResources().getString(R.l.eQR, new Object[] { cl(localLinkedList) });
    com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), paramLinkedList, null, this.fgR.WQv.getMMResources().getString(R.l.eQZ), this.fgR.WQv.getMMResources().getString(R.l.app_cancel), true, new c.5(this, localLinkedList), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(35114);
  }
  
  public final void dB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(273176);
    if (!Util.isEqual(paramString, this.fgR.getTalkerUserName()))
    {
      hOl();
      Log.i("MicroMsg.ChattingUI.BizComponent", "hideLiveBizSessionTipsBar not current user %s, %s", new Object[] { paramString, this.fgR.getTalkerUserName() });
      AppMethodBeat.o(273176);
      return;
    }
    if (!paramBoolean)
    {
      hOl();
      Log.i("MicroMsg.ChattingUI.BizComponent", "hideLiveBizSessionTipsBar not live now");
      AppMethodBeat.o(273176);
      return;
    }
    if (this.WGW == null)
    {
      m.a(this.fgR.WQv, R.h.dZo);
      this.WGW = ((LiveBizSessionTipsBar)this.fgR.findViewById(R.h.live_biz_session_tipsbar));
      if (this.WGW == null)
      {
        Log.w("MicroMsg.ChattingUI.BizComponent", "liveBizSessionTipsBar is null");
        AppMethodBeat.o(273176);
        return;
      }
      this.WGW.setChattingContext(this.fgR);
    }
    this.WGW.setVisibility(0);
    this.fgR.WQv.getController().hideActionbarLine();
    AppMethodBeat.o(273176);
  }
  
  public final void hGU()
  {
    boolean bool2 = false;
    AppMethodBeat.i(35119);
    this.WHa = this.fgR.WQv.getLongExtra("key_biz_chat_id", -1L);
    this.wIf = this.fgR.WQv.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    Log.i("MicroMsg.ChattingUI.BizComponent", "rawBizUserid %s %s", new Object[] { Long.valueOf(this.WHa), Boolean.valueOf(this.wIf) });
    if (this.wIf)
    {
      this.Wtt = af.bjx().bF(this.WHa);
      this.Wtt = com.tencent.mm.ao.a.e.a(this.Wtt, this.WHa);
      this.WHd = af.bjy().Gt(hOs()).field_unReadCount;
    }
    boolean bool1 = bool2;
    if (this.wIf)
    {
      bool1 = bool2;
      if (com.tencent.mm.ao.a.e.Vc(this.Wtt.field_bizChatServId)) {
        bool1 = true;
      }
    }
    this.WGZ = bool1;
    if ((this.wIf) && (!this.WGZ))
    {
      this.GYT = af.bjz().gm(this.Wtt.field_bizChatServId);
      this.GYT = com.tencent.mm.ao.a.e.a(this.GYT, this.Wtt.field_bizChatServId);
    }
    if (this.WGZ) {
      this.WHg = com.tencent.mm.ao.a.e.c(this.Wtt);
    }
    this.GXj = com.tencent.mm.ao.g.gu(this.fgR.getTalkerUserName());
    this.DAn = true;
    if (this.fgR.NKq.hxX())
    {
      localObject = com.tencent.mm.pluginsdk.model.b.QTJ;
      if (com.tencent.mm.pluginsdk.model.b.hgf()) {}
    }
    else
    {
      Log.d("MicroMsg.ChattingUI.BizComponent", "initLiveTipsBar return");
      AppMethodBeat.o(35119);
      return;
    }
    Object localObject = this.fgR.getTalkerUserName();
    com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
    dB((String)localObject, com.tencent.mm.pluginsdk.model.b.bmt((String)localObject));
    if (this.Hgr == null)
    {
      this.Hgr = new c.a(this);
      this.Hgr.alive();
    }
    AppMethodBeat.o(35119);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35120);
    this.WGX = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
    if (((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() > 0) {}
    for (localObject = ((com.tencent.mm.ui.chatting.d.b.k)localObject).avt(((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() - 1);; localObject = null)
    {
      this.WGY = ((ca)localObject);
      com.tencent.mm.storage.ab.bvv(this.fgR.getTalkerUserName());
      if (this.wIf)
      {
        Log.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
        bh.aHJ().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35090);
            long l = System.currentTimeMillis();
            if ((c.this.wIf) && (c.this.Wtt != null) && (c.this.fgR.NKq != null))
            {
              c.f(c.this);
              af.bjJ();
              com.tencent.mm.ao.a.c localc = c.this.Wtt;
              if (com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.h.aHE().kbN))
              {
                String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
                com.tencent.mm.modelsimple.ab.b(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
                Log.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
              }
              if (c.this.WGZ)
              {
                if (c.this.Wtt.bjN())
                {
                  af.bjE();
                  com.tencent.mm.ao.a.h.br(c.this.Wtt.field_bizChatServId, c.this.fgR.NKq.field_username);
                }
              }
              else {
                c.g(c.this);
              }
            }
            for (;;)
            {
              Log.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              AppMethodBeat.o(35090);
              return;
              com.tencent.mm.ao.a.e.f(c.this.Wtt);
              break;
              Log.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { c.this.Wtt, c.this.fgR.NKq });
            }
          }
        }, 500L);
      }
      if ((this.fgR.NKq != null) && (this.fgR.NKq.hxX())) {
        af.bjI().Ui(this.fgR.NKq.field_username);
      }
      this.sCy.alive();
      this.WHa = this.fgR.WQv.getLongExtra("key_biz_chat_id", -1L);
      if ((com.tencent.mm.app.plugin.a.a.d(this.GXj)) && (this.WGV == null))
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { hOp() });
        this.WGV = new com.tencent.mm.app.plugin.a.a(this.fgR);
      }
      if (this.fgR.NKq.hxX()) {
        com.tencent.mm.bi.d.chatType = 2;
      }
      if (this.wIf) {
        af.bjx().a(this.Wud, Looper.getMainLooper());
      }
      if ((this.fgR.NKq != null) && (this.fgR.NKq.hxX())) {
        af.bjv().a(this.WHf, Looper.getMainLooper());
      }
      AppMethodBeat.o(35120);
      return;
    }
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35121);
    if ((com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) && (this.fgR.NKq.hxX()) && (com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) && (this.fgR.NKq.hxX()) && (!com.tencent.mm.ao.g.KI(this.fgR.getTalkerUserName())))
    {
      int i = this.fgR.WQv.getIntExtra("specific_chat_from_scene", 0);
      if (this.lEQ == null) {
        this.lEQ = new efo();
      }
      this.lEQ.UiX = this.fgR.WQv.getIntExtra("Main_IndexInSessionList", 0);
      this.lEQ.UiV = this.fgR.WQv.getIntExtra("Main_UnreadCount", 0);
      if (this.WGY != null)
      {
        this.lEQ.UiW = this.WGY.getType();
        if (this.lEQ.UiV > 0) {
          this.lEQ.UiU = ((int)(this.WGX - this.WGY.field_createTime) / 1000);
        }
      }
      af.bjH().a(this.fgR.getTalkerUserName(), this.WGY, i, this.lEQ);
    }
    if (com.tencent.mm.model.ab.QQ(this.fgR.getTalkerUserName())) {
      com.tencent.e.h.ZvG.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221084);
          c.h(c.this);
          AppMethodBeat.o(221084);
        }
      }, "ReportEnterNotifyMessage");
    }
    AppMethodBeat.o(35121);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35122);
    this.WHe = true;
    bs.K("bizflag", ((ae)this.fgR.bC(ae.class)).hQj());
    Object localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
    int i;
    label179:
    Object localObject2;
    Object localObject3;
    if (com.tencent.mm.pluginsdk.model.b.hgf())
    {
      if ((this.WGW != null) && (this.WGW.getVisibility() == 0))
      {
        localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
        com.tencent.mm.pluginsdk.model.b.onResume();
      }
      localObject1 = this.fgR.getTalkerUserName();
      if (Util.isNullOrNil((String)localObject1)) {
        Log.i("MicroMsg.ChattingUI.BizComponent", "startCheck fail bizUserName is null");
      }
    }
    else
    {
      if ((this.GXj == null) || (com.tencent.mm.app.plugin.a.a.d(this.GXj)))
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { hOp() });
        if (this.WGV != null) {
          this.WGV.a(1, this.GXj);
        }
      }
      localObject1 = this.GXj;
      if ((localObject1 == null) || (localObject1 == null)) {
        break label662;
      }
      localObject1 = ((com.tencent.mm.api.c)localObject1).dc(false);
      if ((localObject1 == null) || (!((com.tencent.mm.api.c.b)localObject1).Zh())) {
        break label662;
      }
      i = 1;
      if (i != 0) {
        bh.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35096);
            uf localuf = new uf();
            if (c.c(c.this) != null)
            {
              localuf.fTx.userName = c.c(c.this).field_username;
              EventCenter.instance.publish(localuf);
            }
            AppMethodBeat.o(35096);
          }
        });
      }
      if ((!com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) || (!this.fgR.NKq.hxX()) || (this.GXj == null)) {
        break label683;
      }
      localObject1 = this.GXj.dc(false);
      if ((localObject1 != null) && (((com.tencent.mm.api.c.b)localObject1).YT()))
      {
        if (this.GXj.field_hadAlert != 0) {
          break label667;
        }
        localObject2 = this.fgR.WQv.getContext().getResources().getString(R.l.euB, new Object[] { this.fgR.NKq.ays() });
        localObject3 = this.fgR.WQv.getContext().getResources().getString(R.l.euC);
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("<sysmsg type=\"reportbizlocation\">");
        ((StringBuffer)localObject1).append("<reportbizlocation>");
        ((StringBuffer)localObject1).append("<text><![CDATA[").append((String)localObject2).append("]]></text>");
        ((StringBuffer)localObject1).append("<link>");
        ((StringBuffer)localObject1).append("<scene>reportbizlocation</scene>");
        ((StringBuffer)localObject1).append("<text><![CDATA[").append((String)localObject3).append("]]></text>");
        ((StringBuffer)localObject1).append("</link>");
        ((StringBuffer)localObject1).append("</reportbizlocation>");
        ((StringBuffer)localObject1).append("</sysmsg>");
        localObject2 = new ca();
        ((ca)localObject2).Jm(this.fgR.getTalkerUserName());
        ((ca)localObject2).pJ(2);
        ((ca)localObject2).setType(10002);
        ((ca)localObject2).setCreateTime(bq.beS());
        ((ca)localObject2).setContent(((StringBuffer)localObject1).toString());
        bq.z((ca)localObject2);
        this.GXj.field_hadAlert = 1;
        af.bjv().update(this.GXj, new String[0]);
      }
      label497:
      if ((this.GXj.YR()) && ((!this.fgR.NKq.hxX()) || (!com.tencent.mm.ao.a.biP())))
      {
        az.a.ltq.aP(this.fgR.NKq.field_username, "");
        com.tencent.mm.am.d.TA(this.fgR.NKq.field_username);
      }
      if (this.GXj.field_status == 1)
      {
        this.GXj.field_status = 0;
        af.bjv().h(this.GXj);
      }
    }
    for (;;)
    {
      hOt();
      AppMethodBeat.o(35122);
      return;
      if (!this.fgR.NKq.hxX()) {
        break;
      }
      if (this.Hgq == null)
      {
        localObject2 = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
        localObject3 = b.b.QUa;
        this.Hgq = ((com.tencent.mm.plugin.brandservice.a.c)localObject2).Gy(b.b.hgC());
      }
      this.Hgq.apt((String)localObject1);
      break;
      label662:
      i = 0;
      break label179;
      label667:
      af.bjH().UO(this.fgR.getTalkerUserName());
      break label497;
      label683:
      if ((!this.fgR.WQv.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) && (this.fgR.NKq.hxX())) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35097);
            if ((!com.tencent.mm.contact.d.rk(c.this.fgR.NKq.field_type)) && (c.this.fgR.NKq.hxX())) {
              c.this.fgR.WQv.setMMSubTitle(R.l.eux);
            }
            AppMethodBeat.o(35097);
          }
        });
      }
    }
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35123);
    this.WHe = false;
    if ((com.tencent.mm.contact.d.rk(this.fgR.NKq.field_type)) && (this.fgR.NKq.hxX()) && (this.GXj != null))
    {
      af.bjH().bjk();
      if (this.GZc != null) {
        this.GZc.dismiss();
      }
    }
    a.a locala = com.tencent.mm.msgsubscription.b.a.mpf;
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clearNotifyCallback");
    com.tencent.mm.msgsubscription.b.a.bss().clear();
    if (this.Hgq != null) {
      this.Hgq.stopCheck();
    }
    AppMethodBeat.o(35123);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35124);
    this.DAn = false;
    hjX();
    AppMethodBeat.o(35124);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(273192);
    super.hHa();
    hOl();
    if (this.Hgr != null)
    {
      this.Hgr.dead();
      this.Hgr = null;
    }
    AppMethodBeat.o(273192);
  }
  
  public final void hJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(273195);
    Object localObject;
    int i;
    if ((!Util.isNullOrNil(paramString)) && (com.tencent.mm.ao.g.Ux(paramString)))
    {
      localObject = (com.tencent.mm.ui.chatting.d.b.k)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class);
      if (((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() <= 0) {
        break label186;
      }
      localObject = ((com.tencent.mm.ui.chatting.d.b.k)localObject).avt(((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() - 1);
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
      com.tencent.mm.plugin.report.service.h.IzE.a(20018, new Object[] { Long.valueOf(this.WGX), paramString, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), localObject, Integer.valueOf(1) });
      AppMethodBeat.o(273195);
      return;
      label186:
      localObject = null;
      break;
      label192:
      if (((ca)localObject).getType() == 285212721)
      {
        i = 2;
        break label70;
      }
      if (((ca)localObject).getType() == 318767153)
      {
        i = 5;
        break label70;
      }
      if (!Util.isNullOrNil(((et)localObject).ilp))
      {
        if (((et)localObject).ilv == 1)
        {
          i = 3;
          break label70;
        }
        if (((et)localObject).ilv == 2)
        {
          i = 4;
          break label70;
        }
      }
      i = 0;
      break label70;
      label268:
      if (!Util.isNullOrNil(((et)localObject).ilp)) {
        localObject = ((et)localObject).ilp;
      } else if (((et)localObject).field_isSend == 0) {
        localObject = ((et)localObject).field_talker;
      } else {
        localObject = z.bcZ();
      }
    }
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35125);
    super.hNZ();
    hjX();
    AppMethodBeat.o(35125);
  }
  
  public final com.tencent.mm.api.c hOb()
  {
    return this.GXj;
  }
  
  public final com.tencent.mm.ao.a.c hOc()
  {
    return this.Wtt;
  }
  
  public final com.tencent.mm.ao.a.k hOd()
  {
    return this.GYT;
  }
  
  public final boolean hOe()
  {
    return this.wIf;
  }
  
  public final boolean hOf()
  {
    return this.WGZ;
  }
  
  public final boolean hOg()
  {
    AppMethodBeat.i(35102);
    if (this.wIf)
    {
      int i;
      if (this.WGZ)
      {
        i = com.tencent.mm.ao.a.e.Gz(hOs());
        if (Util.isNullOrNil(this.Wtt.field_chatName)) {
          if (i == 0) {
            this.fgR.WQv.setMMTitle(this.fgR.WQv.getMMResources().getString(R.l.ewS));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35102);
        return true;
        this.fgR.WQv.setMMTitle(this.fgR.WQv.getMMResources().getString(R.l.eFv, new Object[] { this.fgR.WQv.getMMResources().getString(R.l.ewS), Integer.valueOf(i) }));
        continue;
        ((com.tencent.mm.ui.chatting.d.b.aa)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.aa.class)).setMMTitle(this.fgR.WQv.getMMResources().getString(R.l.eFv, new Object[] { this.Wtt.field_chatName, Integer.valueOf(i) }));
        continue;
        this.fgR.WQv.setMMTitle(this.GYT.field_userName);
      }
    }
    AppMethodBeat.o(35102);
    return false;
  }
  
  public final b hOh()
  {
    return this.Wyh;
  }
  
  public final ChatFooter.g hOi()
  {
    return this.Wxl;
  }
  
  public final List<ca> hOj()
  {
    int i = 100;
    AppMethodBeat.i(35104);
    Object localObject = af.bjy().Gt(hOs());
    if (((com.tencent.mm.ao.a.a)localObject).field_unReadCount > 100) {}
    for (;;)
    {
      bh.beI();
      localObject = com.tencent.mm.model.c.bbP().t(this.fgR.NKq.field_username, hOs(), i);
      AppMethodBeat.o(35104);
      return localObject;
      i = ((com.tencent.mm.ao.a.a)localObject).field_unReadCount;
    }
  }
  
  public final boolean hOk()
  {
    return this.WHg;
  }
  
  public final void hOm()
  {
    AppMethodBeat.i(35106);
    if (this.GXj == null)
    {
      AppMethodBeat.o(35106);
      return;
    }
    final boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.d.blr()) && (!com.tencent.mm.modelgeo.d.bls()))
    {
      bool = true;
      if ((this.GXj.field_hadAlert != 0) || (!bool)) {
        break label145;
      }
      str = this.fgR.WQv.getMMResources().getString(R.l.euz, new Object[] { this.fgR.NKq.ays() });
    }
    for (;;)
    {
      this.GZc = com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), str, this.fgR.WQv.getMMResources().getString(R.l.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35098);
          c.c(c.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = c.c(c.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag |= 0x4;
            com.tencent.mm.ao.g.j(paramAnonymousDialogInterface);
          }
          if (bool)
          {
            Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            paramAnonymousDialogInterface = c.this.fgR.WQv;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35098);
            return;
          }
          af.bjH().UO(c.this.fgR.getTalkerUserName());
          AppMethodBeat.o(35098);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35099);
          c.c(c.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = c.c(c.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag &= 0xFFFFFFFB;
            com.tencent.mm.ao.g.j(paramAnonymousDialogInterface);
          }
          af.bjH().UO(c.this.fgR.getTalkerUserName());
          AppMethodBeat.o(35099);
        }
      });
      AppMethodBeat.o(35106);
      return;
      bool = false;
      break;
      label145:
      if (bool) {
        str = this.fgR.WQv.getMMResources().getString(R.l.euA);
      } else {
        str = this.fgR.WQv.getMMResources().getString(R.l.euy, new Object[] { this.fgR.NKq.ays() });
      }
    }
  }
  
  public final void hOn()
  {
    AppMethodBeat.i(35107);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.fgR.getTalkerUserName());
    localIntent.putExtra("key_start_biz_profile_setting_from_scene", 1);
    com.tencent.mm.by.c.b(this.fgR.WQv.getContext(), "profile", ".ui.newbizinfo.NewBizInfoSettingUI", localIntent);
    AppMethodBeat.o(35107);
  }
  
  public final int hOo()
  {
    return this.WHd;
  }
  
  public final String hOp()
  {
    if (this.wIf) {
      if (this.WGZ) {
        if (this.Wtt != null) {}
      }
    }
    while (this.fgR.NKq == null)
    {
      do
      {
        return null;
        return this.Wtt.field_chatName;
      } while (this.GYT == null);
      return this.GYT.field_userName;
    }
    return this.fgR.NKq.field_nickname;
  }
  
  public final boolean hOq()
  {
    AppMethodBeat.i(35109);
    Object localObject1 = new Intent(this.fgR.WQv.getContext(), ChatroomInfoUI.class);
    if ((this.fgR.hRh()) || (this.WGZ)) {}
    Object localObject2;
    for (int i = 1; (i != 0) && (!this.wIf); i = 0)
    {
      ((Intent)localObject1).putExtra("Chat_User", this.fgR.NKq.field_username);
      ((Intent)localObject1).putExtra("RoomInfo_Id", this.fgR.getTalkerUserName());
      ((Intent)localObject1).putExtra("Is_Chatroom", this.fgR.hRh());
      ((Intent)localObject1).putExtra("fromChatting", true);
      localObject2 = this.fgR;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35109);
      return true;
    }
    if (this.wIf)
    {
      ((Intent)localObject1).setClass(this.fgR.WQv.getContext(), BizChatroomInfoUI.class);
      ((Intent)localObject1).putExtra("Chat_User", this.fgR.NKq.field_username);
      ((Intent)localObject1).putExtra("key_biz_chat_id", hOs());
      if ((this.fgR.WQv.thisActivity() instanceof ChattingUI)) {
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        localObject2 = this.fgR.WQv;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((com.tencent.mm.model.ab.QS(this.fgR.getTalkerUserName())) || (as.bvH(this.fgR.getTalkerUserName())) || (as.bvJ(this.fgR.getTalkerUserName())) || (com.tencent.mm.model.ab.QO(this.fgR.getTalkerUserName())) || (as.PY(this.fgR.getTalkerUserName())) || (this.fgR.NKq.hxX()))
    {
      localObject1 = new Intent();
      com.tencent.mm.ui.contact.e.r((Intent)localObject1, this.fgR.getTalkerUserName());
      if (this.fgR.WQv.getIntExtra("chat_from_scene", 0) == 2)
      {
        ((Intent)localObject1).putExtra("Kdel_from", 2);
        ((Intent)localObject1).putExtra("chat_from_scene", this.fgR.WQv.getIntExtra("chat_from_scene", 0));
        ((Intent)localObject1).putExtra("preUsername", this.fgR.getTalkerUserName());
        ((Intent)localObject1).putExtra("preChatName", this.fgR.getTalkerUserName());
        if ((this.GXj == null) || (!this.GXj.YU())) {
          break label831;
        }
        i = 6;
        label586:
        ((Intent)localObject1).putExtra("preChatTYPE", this.fgR.WQv.getIntExtra("preChatTYPE", i));
        localObject2 = this.fgR.WQv.getContext().getIntent();
        i = ((Intent)localObject2).getIntExtra("key_temp_session_scene", 5);
        if ((i != 16) && (i != 17) && (!((Intent)localObject2).getBooleanExtra("key_biz_profile_stay_after_follow_op", false))) {
          break label896;
        }
        ((Intent)localObject1).putExtra("Kdel_from", 1);
      }
    }
    label896:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject1).putExtra("key_biz_profile_stay_after_follow_op", bool);
      if ((((ae)this.fgR.bC(ae.class)).hQj()) && (m.bvT(this.fgR.getTalkerUserName())))
      {
        if (i != 16) {
          break label837;
        }
        ((Intent)localObject1).putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.fgR.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.a.d.rE(2);
          com.tencent.mm.plugin.newtips.a.fiR();
          if (com.tencent.mm.plugin.newtips.a.e.aal(com.tencent.mm.plugin.newtips.a.d.Gwh))
          {
            com.tencent.mm.plugin.newtips.a.fiO();
            com.tencent.mm.plugin.newtips.a.i.aan(com.tencent.mm.plugin.newtips.a.d.Gwh);
            ((Intent)localObject1).putExtra("key_from_wesport_right_newtips", true);
          }
        }
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.by.c.b(this.fgR.WQv.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1, 213);
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("Kdel_from", 0);
        break;
        label831:
        i = 7;
        break label586;
        label837:
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
  
  public final boolean hOr()
  {
    AppMethodBeat.i(35110);
    if (this.fgR == null)
    {
      Log.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
      AppMethodBeat.o(35110);
      return false;
    }
    Object localObject1;
    if ((this.fgR.NKq.hxX()) && (this.GXj != null))
    {
      if (this.wIf)
      {
        bool = af.bjy().Gv(hOs());
        AppMethodBeat.o(35110);
        return bool;
      }
      if (!this.GXj.YY()) {
        break label238;
      }
      if ((this.GXj.dc(false) != null) && (this.GXj.dc(false).Zz() != null) && (!Util.isNullOrNil(this.GXj.Zf())))
      {
        bh.beI();
        localObject1 = com.tencent.mm.model.c.bbR().bwL(this.GXj.Zf());
        if ((localObject1 != null) && (((bb)localObject1).field_username.equals(this.fgR.getTalkerUserName())) && (((bb)localObject1).field_unReadCount > 0))
        {
          if (this.fgR.WQv.getIntExtra("chat_from_scene", 0) == 2)
          {
            AppMethodBeat.o(35110);
            return false;
          }
          bh.beI();
          com.tencent.mm.model.c.bbR().bwz(this.GXj.Zf());
        }
      }
    }
    while (com.tencent.mm.model.ab.QL(this.fgR.getTalkerUserName()))
    {
      AppMethodBeat.o(35110);
      return true;
      label238:
      if ((!this.GXj.YU()) && (!this.GXj.YW()) && (af.bjB().hwZ() > 0))
      {
        localObject1 = af.bjB();
        Object localObject2 = this.fgR.getTalkerUserName();
        localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + (String)localObject2 + "' ";
        ((com.tencent.mm.storage.aa)localObject1).lvy.execSQL("BizTimeLineInfo", (String)localObject2);
        localObject2 = new aa.a();
        ((aa.a)localObject2).VeB = aa.b.VeF;
        ((com.tencent.mm.storage.aa)localObject1).a((aa.a)localObject2);
      }
    }
    bh.beI();
    boolean bool = com.tencent.mm.model.c.bbR().bwz(this.fgR.getTalkerUserName());
    AppMethodBeat.o(35110);
    return bool;
  }
  
  public final long hOs()
  {
    if (this.Wtt == null) {
      return -1L;
    }
    return this.Wtt.field_bizChatLocalId;
  }
  
  public final void hOt()
  {
    AppMethodBeat.i(35112);
    bh.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35087);
        if (c.this.fgR == null)
        {
          AppMethodBeat.o(35087);
          return;
        }
        boolean bool = ((com.tencent.mm.ui.chatting.d.b.k)c.this.fgR.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNH();
        if ((c.this.wIf) && (!bool)) {
          com.tencent.mm.ao.a.e.d(c.this.Wtt);
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
      if (this.WGV != null)
      {
        paramIntent = this.WGV;
        if (paramIntent.fgR == null)
        {
          Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == -1)
        {
          Toast.makeText(paramIntent.fgR.WQv.getContext(), R.l.eDH, 0).show();
          ez localez = new ez();
          localez.fAR.op = 0;
          localez.fAR.userName = paramIntent.fgR.getTalkerUserName();
          localez.fAR.context = paramIntent.fgR.WQv.getContext();
          EventCenter.instance.publish(localez);
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == 0) {
          Toast.makeText(paramIntent.fgR.WQv.getContext(), R.l.eDG, 0).show();
        }
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35117);
    boolean bool = i(paramKeyEvent);
    AppMethodBeat.o(35117);
    return bool;
  }
  
  public static abstract interface b
  {
    public abstract boolean hOv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c
 * JD-Core Version:    0.7.0.1
 */