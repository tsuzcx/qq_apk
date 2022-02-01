package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.a.y;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.a.a;
import com.tencent.mm.al.e.a.b;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.o;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.bi;
import com.tencent.mm.msgsubscription.storage.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.u.a;
import com.tencent.mm.storage.u.b;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.d.class)
public class c
  extends a
  implements o, com.tencent.mm.ui.chatting.c.b.d
{
  public com.tencent.mm.al.a.c HGu;
  private d.a HHf;
  protected final ChatFooter.g HKf;
  protected final a HLd;
  private com.tencent.mm.app.plugin.a.a HSn;
  private long HSo;
  private bo HSp;
  public boolean HSq;
  private long HSr;
  private RelativeLayout HSs;
  private TextView HSt;
  private int HSu;
  private boolean HSv;
  private boolean HSw;
  private e.a HSx;
  private boolean HSy;
  private cwb hxY;
  private com.tencent.mm.sdk.b.c nAK;
  public boolean qKh;
  private com.tencent.mm.api.c vIG;
  public com.tencent.mm.al.a.k vKi;
  private com.tencent.mm.ui.widget.a.d vKr;
  
  public c()
  {
    AppMethodBeat.i(35100);
    this.HSo = 0L;
    this.qKh = false;
    this.HSq = false;
    this.HSr = -1L;
    this.vKr = null;
    this.hxY = null;
    this.HLd = new a()
    {
      public final boolean fmE()
      {
        AppMethodBeat.i(35086);
        if (c.a(c.this) == null)
        {
          j.a(c.this.cLy.HZF, 2131306438);
          c.a(c.this, (RelativeLayout)c.this.cLy.findViewById(2131297418));
          c.a(c.this, (TextView)c.this.cLy.findViewById(2131297419));
          c.b(c.this).setText(2131757080);
        }
        c.a(c.this).setVisibility(0);
        com.tencent.mm.ui.chatting.d.a.foS().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35085);
            if ((c.a(c.this) != null) && (c.a(c.this).getVisibility() != 8)) {
              c.a(c.this).setVisibility(8);
            }
            if (c.this.cLy == null)
            {
              ac.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
              AppMethodBeat.o(35085);
              return;
            }
            ((com.tencent.mm.ui.chatting.c.b.w)c.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnC();
            c.this.cLy.bJU();
            AppMethodBeat.o(35085);
          }
        }, 5000L);
        AppMethodBeat.o(35086);
        return true;
      }
    };
    this.HKf = new ChatFooter.g()
    {
      public final boolean vu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(35091);
        if (c.c(c.this) == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        Object localObject = c.c(c.this).bV(false);
        if (localObject == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = ((c.b)localObject).Jn();
        if ((localObject == null) || (((c.b.c)localObject).cGb == null) || (((c.b.c)localObject).cGb.isEmpty()))
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = (com.tencent.mm.al.j)((c.b.c)localObject).cGb.get(0);
        try
        {
          localObject = new JSONObject(((com.tencent.mm.al.j)localObject).value);
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1083;
          localAppBrandStatObject.cYP = c.c(c.this).field_username;
          ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(com.tencent.mm.sdk.platformtools.ai.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, c.c(c.this).field_appId);
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
    this.HHf = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35092);
        if ((c.this.qKh) && (paramAnonymousb != null) && (paramAnonymousb.hze == c.this.fmB()))
        {
          if (!c.this.cLy.cqM)
          {
            ac.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
            AppMethodBeat.o(35092);
            return;
          }
          if (paramAnonymousb.hzo != d.a.a.hzl)
          {
            ac.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
            paramAnonymousb = af.aCY().bd(c.this.fmB());
            c.this.HGu = paramAnonymousb;
            if (!c.this.HSq)
            {
              paramAnonymousb = af.aDa().dP(c.this.HGu.field_bizChatServId);
              if (paramAnonymousb != null) {
                c.this.vKi = paramAnonymousb;
              }
            }
            for (;;)
            {
              ((com.tencent.mm.ui.chatting.c.b.w)c.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnC();
              AppMethodBeat.o(35092);
              return;
              c.a(c.this, com.tencent.mm.al.a.e.c(c.this.HGu));
              ((com.tencent.mm.ui.chatting.c.b.w)c.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnF();
            }
          }
          if (c.this.HSq)
          {
            Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), c.this.cLy.HZF.getMMResources().getString(2131762612), 1).show();
            c.this.cLy.HZF.fkI();
          }
        }
        AppMethodBeat.o(35092);
      }
    };
    this.HSv = false;
    this.HSw = false;
    this.HSx = new e.a()
    {
      public final void a(final e.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35094);
        if ((paramAnonymousb != null) && (paramAnonymousb.hxF == e.a.a.hxD) && (paramAnonymousb.hxt != null) && (paramAnonymousb.hxt.equals(c.this.cLy.getTalkerUserName())))
        {
          com.tencent.mm.model.az.ayM();
          final com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(paramAnonymousb.hxt);
          if ((localai == null) || ((int)localai.fLJ == 0))
          {
            ac.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramAnonymousb.hxt });
            AppMethodBeat.o(35094);
            return;
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35093);
              if ((c.d(c.this)) && (paramAnonymousb.hxt.equals(c.this.cLy.getTalkerUserName())))
              {
                ac.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                c.a(c.this, com.tencent.mm.al.f.dX(paramAnonymousb.hxt));
                if ((c.this.cLy != null) && (c.e(c.this))) {
                  ((com.tencent.mm.ui.chatting.c.b.q)c.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).al(localai);
                }
              }
              AppMethodBeat.o(35093);
            }
          });
        }
        AppMethodBeat.o(35094);
      }
    };
    this.nAK = new com.tencent.mm.sdk.b.c() {};
    this.HSy = false;
    AppMethodBeat.o(35100);
  }
  
  public static boolean bm(Intent paramIntent)
  {
    AppMethodBeat.i(35101);
    String str = paramIntent.getStringExtra("Chat_User");
    boolean bool = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if ((!bool) && (str == null))
    {
      ac.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
      AppMethodBeat.o(35101);
      return true;
    }
    if ((bool) && (paramIntent.getLongExtra("key_biz_chat_id", -1L) == -1L))
    {
      ac.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
      AppMethodBeat.o(35101);
      return true;
    }
    AppMethodBeat.o(35101);
    return false;
  }
  
  private String bp(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35115);
    if (paramLinkedList.size() <= 0)
    {
      AppMethodBeat.o(35115);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.HGu.wk((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.cLy.HZF.getContext().getString(2131757106)).append(this.HGu.wk((String)paramLinkedList.get(i)));
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(35115);
    return paramLinkedList;
  }
  
  private void eNi()
  {
    AppMethodBeat.i(35105);
    com.tencent.mm.model.bk.H("bizflag", false);
    this.nAK.dead();
    Object localObject;
    if (this.qKh)
    {
      fmD();
      af.aDj();
      localObject = this.HGu;
      if (com.tencent.mm.kernel.a.mo(g.agP().ggN))
      {
        String str = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.al.a.c)localObject).field_brandUserName, ((com.tencent.mm.al.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.modelsimple.aa.b(((com.tencent.mm.al.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str);
        ac.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str });
      }
    }
    if (this.HSo != 0L) {}
    for (int i = (int)(System.currentTimeMillis() - this.HSo) / 1000;; i = 0)
    {
      if (com.tencent.mm.model.az.agM())
      {
        if (this.qKh) {
          af.aCY().a(this.HHf);
        }
        if ((this.cLy.AzG != null) && (this.cLy.AzG.fad())) {
          af.aCW().a(this.HSx);
        }
        if ((com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) && (this.cLy.AzG.fad()) && (!com.tencent.mm.al.f.so(this.cLy.getTalkerUserName())))
        {
          if ((this.vIG != null) && (this.vIG.IK()))
          {
            if (this.hxY == null) {
              this.hxY = new cwb();
            }
            this.hxY.FGE = i;
            this.hxY.FGI = this.cLy.HZF.getIntExtra("Main_IndexInSessionList", 0);
            this.hxY.FGG = this.cLy.HZF.getIntExtra("Main_UnreadCount", 0);
            if (this.HSp != null)
            {
              this.hxY.FGH = this.HSp.getType();
              if (this.hxY.FGG > 0) {
                this.hxY.FGF = ((int)(this.HSo - this.HSp.field_createTime) / 1000);
              }
            }
          }
          af.aDh().a(this.cLy.getTalkerUserName(), this.hxY);
        }
      }
      if ((com.tencent.mm.app.plugin.a.a.c(this.vIG)) && (this.HSn != null))
      {
        ac.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { fmy() });
        this.HSn.a(2, this.vIG);
        this.cLy.HZF.setMMSubTitle(null);
      }
      if ((com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) && (this.cLy.AzG.fad()) && (i != 0))
      {
        int j = this.cLy.HZF.getIntExtra("specific_chat_from_scene", 0);
        int k = v.getSessionId();
        com.tencent.mm.plugin.report.service.h.wUl.f(10638, new Object[] { this.cLy.getTalkerUserName(), Integer.valueOf(i), Integer.valueOf(this.cLy.HZF.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.cLy.HZF.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(j), Integer.valueOf(k) });
      }
      if (this.HSn != null)
      {
        localObject = this.HSn;
        ac.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
        if (((com.tencent.mm.app.plugin.a.a)localObject).cLz != null)
        {
          com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.app.plugin.a.a)localObject).cLz);
          ((com.tencent.mm.app.plugin.a.a)localObject).cLz = null;
          if (((com.tencent.mm.app.plugin.a.a)localObject).cLC != null) {
            ((com.tencent.mm.app.plugin.a.a)localObject).cLC.clear();
          }
        }
        ((com.tencent.mm.app.plugin.a.a)localObject).cLD = false;
        if (((com.tencent.mm.app.plugin.a.a)localObject).cLA != null)
        {
          com.tencent.mm.sdk.b.a.GpY.d(((com.tencent.mm.app.plugin.a.a)localObject).cLA);
          ((com.tencent.mm.app.plugin.a.a)localObject).cLA = null;
        }
        this.HSn = null;
      }
      v.aMS(null);
      this.HSo = 0L;
      AppMethodBeat.o(35105);
      return;
    }
  }
  
  private void fmD()
  {
    AppMethodBeat.i(35116);
    if (!this.qKh)
    {
      AppMethodBeat.o(35116);
      return;
    }
    af.aDe();
    com.tencent.mm.al.a.h.m(this.cLy.getTalkerUserName(), this.HGu.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(35116);
  }
  
  private boolean h(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35108);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.vIG == null) || (this.vIG.bV(false) == null) || (this.vIG.bV(false).Jn() == null) || (this.vIG.bV(false).Jn().cGb == null) || (this.vIG.bV(false).Jn().cGb.isEmpty()))) {
      ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).fne().fH(null);
    }
    AppMethodBeat.o(35108);
    return false;
  }
  
  public final String Bt(String paramString)
  {
    AppMethodBeat.i(35103);
    paramString = this.HGu.Bn(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(35103);
      return paramString;
    }
    AppMethodBeat.o(35103);
    return null;
  }
  
  public final long Rw()
  {
    return this.HSo;
  }
  
  public final void a(int paramInt, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(35111);
    if (paramn.getType() == 1357)
    {
      this.cLy.dismissDialog();
      if (paramInt != 0) {
        Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), this.cLy.HZF.getMMResources().getString(2131762584), 0).show();
      }
    }
    AppMethodBeat.o(35111);
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.viewitems.bj parambj)
  {
    AppMethodBeat.i(196440);
    String str2 = com.tencent.mm.model.u.axw();
    String str3 = parambj.userName;
    String str1;
    Object localObject;
    int j;
    if (bs.isNullOrNil(parambj.IqU))
    {
      str1 = "";
      i = parambj.hoz;
      if (com.tencent.mm.al.f.AM(str3))
      {
        ac.d("MicroMsg.ChattingUI.BizComponent", "alvinluo reportBizAvatarClick brand: %s, username: %s, kfWorker: %s, kfType: %d", new Object[] { str3, str2, str1, Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.wUl.f(20008, new Object[] { Long.valueOf(this.HSo), str3, Integer.valueOf(1), str1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((bs.isNullOrNil(parambj.IqU)) || (bs.isNullOrNil(parambj.userName)) || (af.aCX() == null) || (!af.aCX().ox(parambj.hoz))) {
        break label495;
      }
      localObject = af.aCX();
      str1 = parambj.userName;
      str3 = parambj.IqU;
      j = parambj.hoz;
      ac.i("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle username: %s, brandUsername: %s, kfOpenId: %s, kfType: %d", new Object[] { str2, str1, str3, Integer.valueOf(j) });
      if (((com.tencent.mm.al.h)localObject).ox(j))
      {
        parambj = ((com.tencent.mm.al.h)localObject).hxH;
        if ((bs.isNullOrNil(parambj.appId)) || (parambj.path == null)) {
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
      parambj = null;
      if ((parambj == null) || (parama.HZF.getContext() == null)) {
        break label495;
      }
      ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(parama.HZF.getContext(), parambj);
      AppMethodBeat.o(196440);
      return true;
      str1 = parambj.IqU;
      break;
    }
    label333:
    parambj = new com.tencent.mm.plugin.appbrand.a.f();
    parambj.appId = ((com.tencent.mm.al.h)localObject).hxH.appId;
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) {}
    for (i = ((com.tencent.mm.al.h)localObject).hxH.hxM;; i = 0)
    {
      parambj.hxM = i;
      parambj.scene = 1166;
      parambj.cYP = str1;
      localObject = Uri.parse(((com.tencent.mm.al.h)localObject).hxH.path).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("username", str2);
      ((Uri.Builder)localObject).appendQueryParameter("brandUsername", str1);
      ((Uri.Builder)localObject).appendQueryParameter("kfOpenId", str3);
      ((Uri.Builder)localObject).appendQueryParameter("kfType", String.valueOf(j));
      parambj.jjf = ((Uri.Builder)localObject).build().toString();
      ac.v("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle enterPath: %s", new Object[] { parambj.jjf });
      break;
    }
    label495:
    AppMethodBeat.o(196440);
    return false;
  }
  
  public final String aQi(String paramString)
  {
    AppMethodBeat.i(35113);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://weixin.qq.com/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) && (this.cLy.AzG.fad()) && (this.vIG != null))
      {
        c.b localb = this.vIG.bV(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.Jm())) && (paramString.contains(localb.Jm())))
        {
          AppMethodBeat.o(35113);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(35113);
    return null;
  }
  
  public final void bo(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35114);
    af.aCY().bd(fmB());
    final LinkedList localLinkedList = new LinkedList();
    List localList = this.HGu.aDl();
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
        com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131762605), null, this.cLy.HZF.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35114);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131762600), null, this.cLy.HZF.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35114);
      return;
    }
    paramLinkedList = this.cLy.HZF.getMMResources().getString(2131762599, new Object[] { bp(localLinkedList) });
    com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), paramLinkedList, null, this.cLy.HZF.getMMResources().getString(2131762607), this.cLy.HZF.getMMResources().getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(35088);
        paramAnonymousDialogInterface = new mn();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < localLinkedList.size())
        {
          mm localmm = new mm();
          localmm.Ebt = ((String)localLinkedList.get(paramAnonymousInt));
          paramAnonymousDialogInterface.Ebu.add(localmm);
          paramAnonymousInt += 1;
        }
        c.a(c.this, paramAnonymousDialogInterface);
        AppMethodBeat.o(35088);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(35114);
  }
  
  public final void fgg()
  {
    boolean bool2 = false;
    AppMethodBeat.i(35119);
    this.HSr = this.cLy.HZF.getLongExtra("key_biz_chat_id", -1L);
    this.qKh = this.cLy.HZF.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    if (this.qKh)
    {
      this.HGu = af.aCY().bd(this.HSr);
      this.HGu = com.tencent.mm.al.a.e.a(this.HGu, this.HSr);
      this.HSu = af.aCZ().pT(fmB()).field_unReadCount;
    }
    boolean bool1 = bool2;
    if (this.qKh)
    {
      bool1 = bool2;
      if (com.tencent.mm.al.a.e.Br(this.HGu.field_bizChatServId)) {
        bool1 = true;
      }
    }
    this.HSq = bool1;
    if ((this.qKh) && (!this.HSq))
    {
      this.vKi = af.aDa().dP(this.HGu.field_bizChatServId);
      this.vKi = com.tencent.mm.al.a.e.a(this.vKi, this.HGu.field_bizChatServId);
    }
    if (this.HSq) {
      this.HSy = com.tencent.mm.al.a.e.c(this.HGu);
    }
    this.vIG = com.tencent.mm.al.f.dX(this.cLy.getTalkerUserName());
    this.HSv = true;
    AppMethodBeat.o(35119);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35120);
    this.HSo = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
    if (((com.tencent.mm.ui.chatting.c.b.i)localObject).getCount() > 0) {}
    for (localObject = ((com.tencent.mm.ui.chatting.c.b.i)localObject).aaP(((com.tencent.mm.ui.chatting.c.b.i)localObject).getCount() - 1);; localObject = null)
    {
      this.HSp = ((bo)localObject);
      v.aMS(this.cLy.getTalkerUserName());
      this.cLy.HZF.getLongExtra("key_biz_chat_id", -1L);
      if (this.qKh)
      {
        ac.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
        com.tencent.mm.model.az.agU().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35090);
            long l = System.currentTimeMillis();
            if ((c.this.qKh) && (c.this.HGu != null) && (c.this.cLy.AzG != null))
            {
              c.f(c.this);
              af.aDj();
              com.tencent.mm.al.a.c localc = c.this.HGu;
              if (com.tencent.mm.kernel.a.mo(g.agP().ggN))
              {
                String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
                com.tencent.mm.modelsimple.aa.b(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
                ac.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
              }
              if (c.this.HSq)
              {
                if (c.this.HGu.aDm())
                {
                  af.aDe();
                  com.tencent.mm.al.a.h.bi(c.this.HGu.field_bizChatServId, c.this.cLy.AzG.field_username);
                }
              }
              else {
                c.g(c.this);
              }
            }
            for (;;)
            {
              ac.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              AppMethodBeat.o(35090);
              return;
              com.tencent.mm.al.a.e.f(c.this.HGu);
              break;
              ac.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { c.this.HGu, c.this.cLy.AzG });
            }
          }
        }, 500L);
      }
      if ((this.cLy.AzG != null) && (this.cLy.AzG.fad())) {
        af.aDi().Ay(this.cLy.AzG.field_username);
      }
      this.nAK.alive();
      this.HSr = this.cLy.HZF.getLongExtra("key_biz_chat_id", -1L);
      if ((com.tencent.mm.app.plugin.a.a.c(this.vIG)) && (this.HSn == null))
      {
        ac.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { fmy() });
        this.HSn = new com.tencent.mm.app.plugin.a.a(this.cLy);
      }
      if (this.cLy.AzG.fad()) {
        com.tencent.mm.bg.d.chatType = 2;
      }
      if (this.qKh) {
        af.aCY().a(this.HHf, Looper.getMainLooper());
      }
      if ((this.cLy.AzG != null) && (this.cLy.AzG.fad())) {
        af.aCW().a(this.HSx, Looper.getMainLooper());
      }
      AppMethodBeat.o(35120);
      return;
    }
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35121);
    if ((com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) && (this.cLy.AzG.fad()) && (com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) && (this.cLy.AzG.fad()) && (!com.tencent.mm.al.f.so(this.cLy.getTalkerUserName())))
    {
      int i = this.cLy.HZF.getIntExtra("specific_chat_from_scene", 0);
      if (this.hxY == null) {
        this.hxY = new cwb();
      }
      this.hxY.FGI = this.cLy.HZF.getIntExtra("Main_IndexInSessionList", 0);
      this.hxY.FGG = this.cLy.HZF.getIntExtra("Main_UnreadCount", 0);
      if (this.HSp != null)
      {
        this.hxY.FGH = this.HSp.getType();
        if (this.hxY.FGG > 0) {
          this.hxY.FGF = ((int)(this.HSo - this.HSp.field_createTime) / 1000);
        }
      }
      af.aDh().a(this.cLy.getTalkerUserName(), this.HSp, i, this.hxY);
    }
    AppMethodBeat.o(35121);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35122);
    this.HSw = true;
    com.tencent.mm.model.bk.H("bizflag", ((com.tencent.mm.ui.chatting.c.b.aa)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.aa.class)).fob());
    if ((this.vIG == null) || (com.tencent.mm.app.plugin.a.a.c(this.vIG)))
    {
      ac.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { fmy() });
      if (this.HSn != null) {
        this.HSn.a(1, this.vIG);
      }
    }
    Object localObject1 = this.vIG;
    int i;
    if ((localObject1 != null) && (localObject1 != null))
    {
      localObject1 = ((com.tencent.mm.api.c)localObject1).bV(false);
      if ((localObject1 != null) && (((c.b)localObject1).IX()))
      {
        i = 1;
        if (i != 0) {
          com.tencent.mm.model.az.agU().az(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35096);
              ru localru = new ru();
              if (c.c(c.this) != null)
              {
                localru.duK.userName = c.c(c.this).field_username;
                com.tencent.mm.sdk.b.a.GpY.l(localru);
              }
              AppMethodBeat.o(35096);
            }
          });
        }
        if ((!com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) || (!this.cLy.AzG.fad()) || (this.vIG == null)) {
          break label565;
        }
        localObject1 = this.vIG.bV(false);
        if ((localObject1 != null) && (((c.b)localObject1).IJ()))
        {
          if (this.vIG.field_hadAlert != 0) {
            break label549;
          }
          Object localObject2 = this.cLy.HZF.getContext().getResources().getString(2131757142, new Object[] { this.cLy.AzG.aaS() });
          String str = this.cLy.HZF.getContext().getResources().getString(2131757143);
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
          localObject2 = new bo();
          ((bo)localObject2).re(this.cLy.getTalkerUserName());
          ((bo)localObject2).jT(2);
          ((bo)localObject2).setType(10002);
          ((bo)localObject2).oA(bi.ayX());
          ((bo)localObject2).setContent(((StringBuffer)localObject1).toString());
          bi.u((bo)localObject2);
          this.vIG.field_hadAlert = 1;
          af.aCW().update(this.vIG, new String[0]);
        }
        label440:
        if ((this.vIG.IH()) && ((!this.cLy.AzG.fad()) || (!com.tencent.mm.al.a.aCo())))
        {
          ar.a.hnw.aJ(this.cLy.AzG.field_username, "");
          com.tencent.mm.aj.c.zU(this.cLy.AzG.field_username);
        }
        if (this.vIG.field_status == 1)
        {
          this.vIG.field_status = 0;
          af.aCW().g(this.vIG);
        }
      }
    }
    for (;;)
    {
      fmC();
      AppMethodBeat.o(35122);
      return;
      i = 0;
      break;
      label549:
      af.aDh().Bd(this.cLy.getTalkerUserName());
      break label440;
      label565:
      if ((!this.cLy.HZF.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) && (this.cLy.AzG.fad())) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35097);
            if ((!com.tencent.mm.n.b.ln(c.this.cLy.AzG.field_type)) && (c.this.cLy.AzG.fad())) {
              c.this.cLy.HZF.setMMSubTitle(2131757138);
            }
            AppMethodBeat.o(35097);
          }
        });
      }
    }
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35123);
    this.HSw = false;
    if ((com.tencent.mm.n.b.ln(this.cLy.AzG.field_type)) && (this.cLy.AzG.fad()) && (this.vIG != null))
    {
      af.aDh().aCJ();
      if (this.vKr != null) {
        this.vKr.dismiss();
      }
    }
    a.a locala = com.tencent.mm.msgsubscription.storage.a.ihQ;
    ac.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clearNotifyCallback");
    com.tencent.mm.msgsubscription.storage.a.aLg().clear();
    AppMethodBeat.o(35123);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35124);
    this.HSv = false;
    eNi();
    AppMethodBeat.o(35124);
  }
  
  public final boolean fmA()
  {
    AppMethodBeat.i(35110);
    if (this.cLy == null)
    {
      ac.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
      AppMethodBeat.o(35110);
      return false;
    }
    Object localObject1;
    if ((this.cLy.AzG.fad()) && (this.vIG != null))
    {
      if (this.qKh)
      {
        bool = af.aCZ().pV(fmB());
        AppMethodBeat.o(35110);
        return bool;
      }
      if (!this.vIG.IO()) {
        break label238;
      }
      if ((this.vIG.bV(false) != null) && (this.vIG.bV(false).Jq() != null) && (!bs.isNullOrNil(this.vIG.IV())))
      {
        com.tencent.mm.model.az.ayM();
        localObject1 = com.tencent.mm.model.c.awG().aNW(this.vIG.IV());
        if ((localObject1 != null) && (((com.tencent.mm.g.c.az)localObject1).field_username.equals(this.cLy.getTalkerUserName())) && (((com.tencent.mm.g.c.az)localObject1).field_unReadCount > 0))
        {
          if (this.cLy.HZF.getIntExtra("chat_from_scene", 0) == 2)
          {
            AppMethodBeat.o(35110);
            return false;
          }
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().aNK(this.vIG.IV());
        }
      }
    }
    while (com.tencent.mm.model.w.xg(this.cLy.getTalkerUserName()))
    {
      AppMethodBeat.o(35110);
      return true;
      label238:
      if ((!this.vIG.IK()) && (!this.vIG.IM())) {
        if (!v.bIO())
        {
          com.tencent.mm.model.az.ayM();
          localObject1 = com.tencent.mm.model.c.awG().faR();
          if ((localObject1 != null) && (((com.tencent.mm.g.c.az)localObject1).field_username.equals(this.cLy.getTalkerUserName())) && (((com.tencent.mm.g.c.az)localObject1).field_unReadCount > 0))
          {
            com.tencent.mm.model.az.ayM();
            com.tencent.mm.model.c.awG().aNK("officialaccounts");
          }
        }
        else if (af.aDc().eZt() > 0)
        {
          localObject1 = af.aDc();
          Object localObject2 = this.cLy.getTalkerUserName();
          localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + (String)localObject2 + "' ";
          ((com.tencent.mm.storage.u)localObject1).hpA.execSQL("BizTimeLineInfo", (String)localObject2);
          localObject2 = new u.a();
          ((u.a)localObject2).GCq = u.b.GCu;
          ((com.tencent.mm.storage.u)localObject1).a((u.a)localObject2);
        }
      }
    }
    com.tencent.mm.model.az.ayM();
    boolean bool = com.tencent.mm.model.c.awG().aNK(this.cLy.getTalkerUserName());
    AppMethodBeat.o(35110);
    return bool;
  }
  
  public final long fmB()
  {
    if (this.HGu == null) {
      return -1L;
    }
    return this.HGu.field_bizChatLocalId;
  }
  
  public final void fmC()
  {
    AppMethodBeat.i(35112);
    com.tencent.mm.model.az.agU().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35087);
        if (c.this.cLy == null)
        {
          AppMethodBeat.o(35087);
          return;
        }
        boolean bool = ((com.tencent.mm.ui.chatting.c.b.i)c.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).isInEditMode();
        if ((c.this.qKh) && (!bool)) {
          com.tencent.mm.al.a.e.d(c.this.HGu);
        }
        AppMethodBeat.o(35087);
      }
    }, 500L);
    AppMethodBeat.o(35112);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35125);
    super.fmj();
    eNi();
    AppMethodBeat.o(35125);
  }
  
  public final com.tencent.mm.api.c fml()
  {
    return this.vIG;
  }
  
  public final com.tencent.mm.al.a.c fmm()
  {
    return this.HGu;
  }
  
  public final com.tencent.mm.al.a.k fmn()
  {
    return this.vKi;
  }
  
  public final boolean fmo()
  {
    return this.qKh;
  }
  
  public final boolean fmp()
  {
    return this.HSq;
  }
  
  public final boolean fmq()
  {
    AppMethodBeat.i(35102);
    if (this.qKh)
    {
      int i;
      if (this.HSq)
      {
        i = com.tencent.mm.al.a.e.pZ(fmB());
        if (bs.isNullOrNil(this.HGu.field_chatName)) {
          if (i == 0) {
            this.cLy.HZF.setMMTitle(this.cLy.HZF.getMMResources().getString(2131757293));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35102);
        return true;
        this.cLy.HZF.setMMTitle(this.cLy.HZF.getMMResources().getString(2131759496, new Object[] { this.cLy.HZF.getMMResources().getString(2131757293), Integer.valueOf(i) }));
        continue;
        ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).setMMTitle(this.cLy.HZF.getMMResources().getString(2131759496, new Object[] { this.HGu.field_chatName, Integer.valueOf(i) }));
        continue;
        this.cLy.HZF.setMMTitle(this.vKi.field_userName);
      }
    }
    AppMethodBeat.o(35102);
    return false;
  }
  
  public final a fmr()
  {
    return this.HLd;
  }
  
  public final ChatFooter.g fms()
  {
    return this.HKf;
  }
  
  public final List<bo> fmt()
  {
    int i = 100;
    AppMethodBeat.i(35104);
    Object localObject = af.aCZ().pT(fmB());
    if (((com.tencent.mm.al.a.a)localObject).field_unReadCount > 100) {}
    for (;;)
    {
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awE().o(this.cLy.AzG.field_username, fmB(), i);
      AppMethodBeat.o(35104);
      return localObject;
      i = ((com.tencent.mm.al.a.a)localObject).field_unReadCount;
    }
  }
  
  public final boolean fmu()
  {
    return this.HSy;
  }
  
  public final void fmv()
  {
    AppMethodBeat.i(35106);
    if (this.vIG == null)
    {
      AppMethodBeat.o(35106);
      return;
    }
    final boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.d.aEM()) && (!com.tencent.mm.modelgeo.d.aEN()))
    {
      bool = true;
      if ((this.vIG.field_hadAlert != 0) || (!bool)) {
        break label144;
      }
      str = this.cLy.HZF.getMMResources().getString(2131757140, new Object[] { this.cLy.AzG.aaS() });
    }
    for (;;)
    {
      this.vKr = com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), str, this.cLy.HZF.getMMResources().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35098);
          c.c(c.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = c.c(c.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag |= 0x4;
            com.tencent.mm.al.f.i(paramAnonymousDialogInterface);
          }
          if (bool)
          {
            Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            paramAnonymousDialogInterface = c.this.cLy.HZF;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35098);
            return;
          }
          af.aDh().Bd(c.this.cLy.getTalkerUserName());
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
            com.tencent.mm.al.f.i(paramAnonymousDialogInterface);
          }
          af.aDh().Bd(c.this.cLy.getTalkerUserName());
          AppMethodBeat.o(35099);
        }
      });
      AppMethodBeat.o(35106);
      return;
      bool = false;
      break;
      label144:
      if (bool) {
        str = this.cLy.HZF.getMMResources().getString(2131757141);
      } else {
        str = this.cLy.HZF.getMMResources().getString(2131757139, new Object[] { this.cLy.AzG.aaS() });
      }
    }
  }
  
  public final void fmw()
  {
    AppMethodBeat.i(35107);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.cLy.getTalkerUserName());
    localIntent.putExtra("key_start_biz_profile_setting_from_scene", 1);
    com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "profile", ".ui.newbizinfo.NewBizInfoSettingUI", localIntent);
    AppMethodBeat.o(35107);
  }
  
  public final int fmx()
  {
    return this.HSu;
  }
  
  public final String fmy()
  {
    if (this.qKh) {
      if (this.HSq) {
        if (this.HGu != null) {}
      }
    }
    while (this.cLy.AzG == null)
    {
      do
      {
        return null;
        return this.HGu.field_chatName;
      } while (this.vKi == null);
      return this.vKi.field_userName;
    }
    return this.cLy.AzG.field_nickname;
  }
  
  public final boolean fmz()
  {
    AppMethodBeat.i(35109);
    Object localObject1 = new Intent(this.cLy.HZF.getContext(), ChatroomInfoUI.class);
    if ((this.cLy.foP()) || (this.HSq)) {}
    Object localObject2;
    for (int i = 1; (i != 0) && (!this.qKh); i = 0)
    {
      ((Intent)localObject1).putExtra("Chat_User", this.cLy.AzG.field_username);
      ((Intent)localObject1).putExtra("RoomInfo_Id", this.cLy.getTalkerUserName());
      ((Intent)localObject1).putExtra("Is_Chatroom", this.cLy.foP());
      ((Intent)localObject1).putExtra("fromChatting", true);
      localObject2 = this.cLy;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35109);
      return true;
    }
    if (this.qKh)
    {
      ((Intent)localObject1).setClass(this.cLy.HZF.getContext(), BizChatroomInfoUI.class);
      ((Intent)localObject1).putExtra("Chat_User", this.cLy.AzG.field_username);
      ((Intent)localObject1).putExtra("key_biz_chat_id", fmB());
      if ((this.cLy.HZF.thisActivity() instanceof ChattingUI)) {
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        localObject2 = this.cLy.HZF;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((com.tencent.mm.model.w.xn(this.cLy.getTalkerUserName())) || (com.tencent.mm.storage.ai.aMZ(this.cLy.getTalkerUserName())) || (com.tencent.mm.storage.ai.aNb(this.cLy.getTalkerUserName())) || (com.tencent.mm.model.w.xj(this.cLy.getTalkerUserName())) || (com.tencent.mm.storage.ai.ww(this.cLy.getTalkerUserName())) || (this.cLy.AzG.fad()))
    {
      localObject1 = new Intent();
      com.tencent.mm.ui.contact.e.u((Intent)localObject1, this.cLy.getTalkerUserName());
      if (this.cLy.HZF.getIntExtra("chat_from_scene", 0) == 2)
      {
        ((Intent)localObject1).putExtra("Kdel_from", 2);
        ((Intent)localObject1).putExtra("chat_from_scene", this.cLy.HZF.getIntExtra("chat_from_scene", 0));
        ((Intent)localObject1).putExtra("preUsername", this.cLy.getTalkerUserName());
        ((Intent)localObject1).putExtra("preChatName", this.cLy.getTalkerUserName());
        if ((this.vIG == null) || (!this.vIG.IK())) {
          break label830;
        }
        i = 6;
        label585:
        ((Intent)localObject1).putExtra("preChatTYPE", this.cLy.HZF.getIntExtra("preChatTYPE", i));
        localObject2 = this.cLy.HZF.getContext().getIntent();
        i = ((Intent)localObject2).getIntExtra("key_temp_session_scene", 5);
        if ((i != 16) && (i != 17) && (!((Intent)localObject2).getBooleanExtra("key_biz_profile_stay_after_follow_op", false))) {
          break label895;
        }
        ((Intent)localObject1).putExtra("Kdel_from", 1);
      }
    }
    label830:
    label836:
    label895:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject1).putExtra("key_biz_profile_stay_after_follow_op", bool);
      if ((((com.tencent.mm.ui.chatting.c.b.aa)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.aa.class)).fob()) && (j.aQk(this.cLy.getTalkerUserName())))
      {
        if (i != 16) {
          break label836;
        }
        ((Intent)localObject1).putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.cLy.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.a.c.lA(2);
          com.tencent.mm.plugin.newtips.a.dke();
          if (com.tencent.mm.plugin.newtips.a.e.Kk(com.tencent.mm.plugin.newtips.a.d.vmS))
          {
            com.tencent.mm.plugin.newtips.a.dkb();
            com.tencent.mm.plugin.newtips.a.i.Km(com.tencent.mm.plugin.newtips.a.d.vmS);
            ((Intent)localObject1).putExtra("key_from_wesport_right_newtips", true);
          }
        }
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1, 213);
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("Kdel_from", 0);
        break;
        i = 7;
        break label585;
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
  
  public final void gb(String paramString, int paramInt)
  {
    AppMethodBeat.i(196441);
    Object localObject;
    int i;
    if ((!bs.isNullOrNil(paramString)) && (com.tencent.mm.al.f.AM(paramString)))
    {
      localObject = (com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
      if (((com.tencent.mm.ui.chatting.c.b.i)localObject).getCount() <= 0) {
        break label186;
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.i)localObject).aaP(((com.tencent.mm.ui.chatting.c.b.i)localObject).getCount() - 1);
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
      ac.d("MicroMsg.ChattingUI.BizComponent", "alvinluo onFooterSwitchInput talker: %s, switchType: %d, lastMsgType: %d, sender: %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i), localObject });
      com.tencent.mm.plugin.report.service.h.wUl.f(20018, new Object[] { Long.valueOf(this.HSo), paramString, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), localObject, Integer.valueOf(1) });
      AppMethodBeat.o(196441);
      return;
      label186:
      localObject = null;
      break;
      label192:
      if (((bo)localObject).getType() == 285212721)
      {
        i = 2;
        break label70;
      }
      if (((bo)localObject).getType() == 318767153)
      {
        i = 5;
        break label70;
      }
      if (!bs.isNullOrNil(((dy)localObject).eSj))
      {
        if (((dy)localObject).eSp == 1)
        {
          i = 3;
          break label70;
        }
        if (((dy)localObject).eSp == 2)
        {
          i = 4;
          break label70;
        }
      }
      i = 0;
      break label70;
      label268:
      if (!bs.isNullOrNil(((dy)localObject).eSj)) {
        localObject = ((dy)localObject).eSj;
      } else if (((dy)localObject).field_isSend == 0) {
        localObject = ((dy)localObject).field_talker;
      } else {
        localObject = com.tencent.mm.model.u.axw();
      }
    }
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
      if (this.HSn != null)
      {
        paramIntent = this.HSn;
        if (paramIntent.cLy == null)
        {
          ac.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == -1)
        {
          Toast.makeText(paramIntent.cLy.HZF.getContext(), 2131758561, 0).show();
          el localel = new el();
          localel.dem.op = 0;
          localel.dem.userName = paramIntent.cLy.getTalkerUserName();
          localel.dem.context = paramIntent.cLy.HZF.getContext();
          com.tencent.mm.sdk.b.a.GpY.l(localel);
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == 0) {
          Toast.makeText(paramIntent.cLy.HZF.getContext(), 2131758560, 0).show();
        }
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35117);
    boolean bool = h(paramKeyEvent);
    AppMethodBeat.o(35117);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean fmE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c
 * JD-Core Version:    0.7.0.1
 */