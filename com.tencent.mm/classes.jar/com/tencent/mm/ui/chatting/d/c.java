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
import com.tencent.mm.al.n;
import com.tencent.mm.am.a.d.a;
import com.tencent.mm.am.a.d.a.a;
import com.tencent.mm.am.a.d.a.b;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.f.a.a;
import com.tencent.mm.am.f.a.b;
import com.tencent.mm.am.i.a;
import com.tencent.mm.am.p;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.msgsubscription.storage.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.b;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.viewitems.bk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.d.class)
public class c
  extends a
  implements p, com.tencent.mm.ui.chatting.d.b.d
{
  private long JGA;
  private RelativeLayout JGB;
  private TextView JGC;
  private int JGD;
  private boolean JGE;
  private boolean JGF;
  private f.a JGG;
  private boolean JGH;
  private com.tencent.mm.app.plugin.a.a JGw;
  private long JGx;
  private bu JGy;
  public boolean JGz;
  private d.a JuW;
  public com.tencent.mm.am.a.c Jul;
  protected final ChatFooter.g JxW;
  protected final a JyU;
  private dbo hQt;
  private com.tencent.mm.sdk.b.c obT;
  public boolean ruj;
  private com.tencent.mm.api.c wPN;
  private com.tencent.mm.ui.widget.a.d wRA;
  public com.tencent.mm.am.a.k wRr;
  
  public c()
  {
    AppMethodBeat.i(35100);
    this.JGx = 0L;
    this.ruj = false;
    this.JGz = false;
    this.JGA = -1L;
    this.wRA = null;
    this.hQt = null;
    this.JyU = new a()
    {
      public final boolean fCX()
      {
        AppMethodBeat.i(35086);
        if (c.a(c.this) == null)
        {
          l.a(c.this.cWM.JOR, 2131306438);
          c.a(c.this, (RelativeLayout)c.this.cWM.findViewById(2131297418));
          c.a(c.this, (TextView)c.this.cWM.findViewById(2131297419));
          c.b(c.this).setText(2131757080);
        }
        c.a(c.this).setVisibility(0);
        com.tencent.mm.ui.chatting.e.a.fFx().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35085);
            if ((c.a(c.this) != null) && (c.a(c.this).getVisibility() != 8)) {
              c.a(c.this).setVisibility(8);
            }
            if (c.this.cWM == null)
            {
              ad.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
              AppMethodBeat.o(35085);
              return;
            }
            ((com.tencent.mm.ui.chatting.d.b.y)c.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fDo();
            c.this.cWM.bOo();
            AppMethodBeat.o(35085);
          }
        }, 5000L);
        AppMethodBeat.o(35086);
        return true;
      }
    };
    this.JxW = new ChatFooter.g()
    {
      public final boolean wg(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(35091);
        if (c.c(c.this) == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        Object localObject = c.c(c.this).bX(false);
        if (localObject == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = ((c.b)localObject).KM();
        if ((localObject == null) || (((c.b.c)localObject).cRg == null) || (((c.b.c)localObject).cRg.isEmpty()))
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = (com.tencent.mm.am.k)((c.b.c)localObject).cRg.get(0);
        try
        {
          localObject = new JSONObject(((com.tencent.mm.am.k)localObject).value);
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1083;
          localAppBrandStatObject.dkh = c.c(c.this).field_username;
          ((o)com.tencent.mm.kernel.g.ab(o.class)).a(aj.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, c.c(c.this).field_appId);
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
    this.JuW = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35092);
        if ((c.this.ruj) && (paramAnonymousb != null) && (paramAnonymousb.hRz == c.this.fCU()))
        {
          if (!c.this.cWM.cBJ)
          {
            ad.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
            AppMethodBeat.o(35092);
            return;
          }
          if (paramAnonymousb.hRJ != d.a.a.hRG)
          {
            ad.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
            paramAnonymousb = ag.aGb().bd(c.this.fCU());
            c.this.Jul = paramAnonymousb;
            if (!c.this.JGz)
            {
              paramAnonymousb = ag.aGd().eK(c.this.Jul.field_bizChatServId);
              if (paramAnonymousb != null) {
                c.this.wRr = paramAnonymousb;
              }
            }
            for (;;)
            {
              ((com.tencent.mm.ui.chatting.d.b.y)c.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fDo();
              AppMethodBeat.o(35092);
              return;
              c.a(c.this, com.tencent.mm.am.a.e.c(c.this.Jul));
              ((com.tencent.mm.ui.chatting.d.b.y)c.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fEc();
            }
          }
          if (c.this.JGz)
          {
            Toast.makeText(aj.getContext(), c.this.cWM.JOR.getMMResources().getString(2131762612), 1).show();
            c.this.cWM.JOR.fAX();
          }
        }
        AppMethodBeat.o(35092);
      }
    };
    this.JGE = false;
    this.JGF = false;
    this.JGG = new f.a()
    {
      public final void a(final f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35094);
        if ((paramAnonymousb != null) && (paramAnonymousb.hQa == f.a.a.hPY) && (paramAnonymousb.hPO != null) && (paramAnonymousb.hPO.equals(c.this.cWM.getTalkerUserName())))
        {
          com.tencent.mm.model.ba.aBQ();
          final am localam = com.tencent.mm.model.c.azp().Bf(paramAnonymousb.hPO);
          if ((localam == null) || ((int)localam.gfj == 0))
          {
            ad.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramAnonymousb.hPO });
            AppMethodBeat.o(35094);
            return;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35093);
              if ((c.d(c.this)) && (paramAnonymousb.hPO.equals(c.this.cWM.getTalkerUserName())))
              {
                ad.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                c.a(c.this, com.tencent.mm.am.g.eS(paramAnonymousb.hPO));
                if ((c.this.cWM != null) && (c.e(c.this))) {
                  ((s)c.this.cWM.bh(s.class)).al(localam);
                }
              }
              AppMethodBeat.o(35093);
            }
          });
        }
        AppMethodBeat.o(35094);
      }
    };
    this.obT = new com.tencent.mm.sdk.b.c() {};
    this.JGH = false;
    AppMethodBeat.o(35100);
  }
  
  private String bq(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35115);
    if (paramLinkedList.size() <= 0)
    {
      AppMethodBeat.o(35115);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.Jul.zf((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.cWM.JOR.getContext().getString(2131757106)).append(this.Jul.zf((String)paramLinkedList.get(i)));
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(35115);
    return paramLinkedList;
  }
  
  public static boolean br(Intent paramIntent)
  {
    AppMethodBeat.i(35101);
    String str = paramIntent.getStringExtra("Chat_User");
    boolean bool = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if ((!bool) && (str == null))
    {
      ad.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
      AppMethodBeat.o(35101);
      return true;
    }
    if ((bool) && (paramIntent.getLongExtra("key_biz_chat_id", -1L) == -1L))
    {
      ad.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
      AppMethodBeat.o(35101);
      return true;
    }
    AppMethodBeat.o(35101);
    return false;
  }
  
  private void fCW()
  {
    AppMethodBeat.i(35116);
    if (!this.ruj)
    {
      AppMethodBeat.o(35116);
      return;
    }
    ag.aGh();
    com.tencent.mm.am.a.h.l(this.cWM.getTalkerUserName(), this.Jul.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(35116);
  }
  
  private void fch()
  {
    AppMethodBeat.i(35105);
    bl.H("bizflag", false);
    this.obT.dead();
    Object localObject;
    if (this.ruj)
    {
      fCW();
      ag.aGm();
      localObject = this.Jul;
      if (com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx))
      {
        String str = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.am.a.c)localObject).field_brandUserName, ((com.tencent.mm.am.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        aa.b(((com.tencent.mm.am.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str);
        ad.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str });
      }
    }
    if (this.JGx != 0L) {}
    for (int i = (int)(System.currentTimeMillis() - this.JGx) / 1000;; i = 0)
    {
      if (com.tencent.mm.model.ba.ajx())
      {
        if (this.ruj) {
          ag.aGb().a(this.JuW);
        }
        if ((this.cWM.BYG != null) && (this.cWM.BYG.fqg())) {
          ag.aFZ().a(this.JGG);
        }
        if ((com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) && (this.cWM.BYG.fqg()) && (!com.tencent.mm.am.g.vd(this.cWM.getTalkerUserName())))
        {
          if ((this.wPN != null) && (this.wPN.Kk()))
          {
            if (this.hQt == null) {
              this.hQt = new dbo();
            }
            this.hQt.Hrn = i;
            this.hQt.Hrr = this.cWM.JOR.getIntExtra("Main_IndexInSessionList", 0);
            this.hQt.Hrp = this.cWM.JOR.getIntExtra("Main_UnreadCount", 0);
            if (this.JGy != null)
            {
              this.hQt.Hrq = this.JGy.getType();
              if (this.hQt.Hrp > 0) {
                this.hQt.Hro = ((int)(this.JGx - this.JGy.field_createTime) / 1000);
              }
            }
          }
          ag.aGk().a(this.cWM.getTalkerUserName(), this.hQt);
        }
      }
      if ((com.tencent.mm.app.plugin.a.a.c(this.wPN)) && (this.JGw != null))
      {
        ad.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { fCR() });
        this.JGw.a(2, this.wPN);
        this.cWM.JOR.setMMSubTitle(null);
      }
      if ((com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) && (this.cWM.BYG.fqg()) && (i != 0))
      {
        int j = this.cWM.JOR.getIntExtra("specific_chat_from_scene", 0);
        int k = com.tencent.mm.storage.y.getSessionId();
        com.tencent.mm.plugin.report.service.g.yhR.f(10638, new Object[] { this.cWM.getTalkerUserName(), Integer.valueOf(i), Integer.valueOf(this.cWM.JOR.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.cWM.JOR.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(j), Integer.valueOf(k) });
      }
      if (this.JGw != null)
      {
        localObject = this.JGw;
        ad.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
        if (((com.tencent.mm.app.plugin.a.a)localObject).cWN != null)
        {
          com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.app.plugin.a.a)localObject).cWN);
          ((com.tencent.mm.app.plugin.a.a)localObject).cWN = null;
          if (((com.tencent.mm.app.plugin.a.a)localObject).cWQ != null) {
            ((com.tencent.mm.app.plugin.a.a)localObject).cWQ.clear();
          }
        }
        ((com.tencent.mm.app.plugin.a.a)localObject).cWR = false;
        if (((com.tencent.mm.app.plugin.a.a)localObject).cWO != null)
        {
          com.tencent.mm.sdk.b.a.IbL.d(((com.tencent.mm.app.plugin.a.a)localObject).cWO);
          ((com.tencent.mm.app.plugin.a.a)localObject).cWO = null;
        }
        this.JGw = null;
      }
      com.tencent.mm.storage.y.aSF(null);
      this.JGx = 0L;
      AppMethodBeat.o(35105);
      return;
    }
  }
  
  private boolean h(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35108);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.wPN == null) || (this.wPN.bX(false) == null) || (this.wPN.bX(false).KM() == null) || (this.wPN.bX(false).KM().cRg == null) || (this.wPN.bX(false).KM().cRg.isEmpty()))) {
      ((s)this.cWM.bh(s.class)).fDC().fW(null);
    }
    AppMethodBeat.o(35108);
    return false;
  }
  
  public final String Es(String paramString)
  {
    AppMethodBeat.i(35103);
    paramString = this.Jul.Em(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(35103);
      return paramString;
    }
    AppMethodBeat.o(35103);
    return null;
  }
  
  public final long TD()
  {
    return this.JGx;
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(35111);
    if (paramn.getType() == 1357)
    {
      this.cWM.dismissDialog();
      if (paramInt != 0) {
        Toast.makeText(aj.getContext(), this.cWM.JOR.getMMResources().getString(2131762584), 0).show();
      }
    }
    AppMethodBeat.o(35111);
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.e.a parama, bk parambk)
  {
    AppMethodBeat.i(193929);
    String str2 = com.tencent.mm.model.u.aAm();
    String str3 = parambk.userName;
    String str1;
    Object localObject;
    int j;
    if (bt.isNullOrNil(parambk.Khx))
    {
      str1 = "";
      i = parambk.hGR;
      if (com.tencent.mm.am.g.DL(str3))
      {
        ad.d("MicroMsg.ChattingUI.BizComponent", "alvinluo reportBizAvatarClick brand: %s, username: %s, kfWorker: %s, kfType: %d", new Object[] { str3, str2, str1, Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.g.yhR.f(20008, new Object[] { Long.valueOf(this.JGx), str3, Integer.valueOf(1), str1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((bt.isNullOrNil(parambk.Khx)) || (bt.isNullOrNil(parambk.userName)) || (ag.aGa() == null) || (!ag.aGa().oY(parambk.hGR))) {
        break label495;
      }
      localObject = ag.aGa();
      str1 = parambk.userName;
      str3 = parambk.Khx;
      j = parambk.hGR;
      ad.i("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle username: %s, brandUsername: %s, kfOpenId: %s, kfType: %d", new Object[] { str2, str1, str3, Integer.valueOf(j) });
      if (((com.tencent.mm.am.i)localObject).oY(j))
      {
        parambk = ((com.tencent.mm.am.i)localObject).hQc;
        if ((bt.isNullOrNil(parambk.appId)) || (parambk.path == null)) {
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
      parambk = null;
      if ((parambk == null) || (parama.JOR.getContext() == null)) {
        break label495;
      }
      ((o)com.tencent.mm.kernel.g.ab(o.class)).a(parama.JOR.getContext(), parambk);
      AppMethodBeat.o(193929);
      return true;
      str1 = parambk.Khx;
      break;
    }
    label333:
    parambk = new com.tencent.mm.plugin.appbrand.api.f();
    parambk.appId = ((com.tencent.mm.am.i)localObject).hQc.appId;
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG)) {}
    for (i = ((com.tencent.mm.am.i)localObject).hQc.hQh;; i = 0)
    {
      parambk.hQh = i;
      parambk.scene = 1166;
      parambk.dkh = str1;
      localObject = Uri.parse(((com.tencent.mm.am.i)localObject).hQc.path).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("username", str2);
      ((Uri.Builder)localObject).appendQueryParameter("brandUsername", str1);
      ((Uri.Builder)localObject).appendQueryParameter("kfOpenId", str3);
      ((Uri.Builder)localObject).appendQueryParameter("kfType", String.valueOf(j));
      parambk.jCN = ((Uri.Builder)localObject).build().toString();
      ad.v("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle enterPath: %s", new Object[] { parambk.jCN });
      break;
    }
    label495:
    AppMethodBeat.o(193929);
    return false;
  }
  
  public final String aVZ(String paramString)
  {
    AppMethodBeat.i(35113);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://weixin.qq.com/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) && (this.cWM.BYG.fqg()) && (this.wPN != null))
      {
        c.b localb = this.wPN.bX(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.KL())) && (paramString.contains(localb.KL())))
        {
          AppMethodBeat.o(35113);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(35113);
    return null;
  }
  
  public final void bp(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35114);
    ag.aGb().bd(fCU());
    LinkedList localLinkedList = new LinkedList();
    List localList = this.Jul.aGo();
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
        com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131762605), null, this.cWM.JOR.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35114);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131762600), null, this.cWM.JOR.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35114);
      return;
    }
    paramLinkedList = this.cWM.JOR.getMMResources().getString(2131762599, new Object[] { bq(localLinkedList) });
    com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), paramLinkedList, null, this.cWM.JOR.getMMResources().getString(2131762607), this.cWM.JOR.getMMResources().getString(2131755691), true, new c.5(this, localLinkedList), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(35114);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35125);
    super.fCC();
    fch();
    AppMethodBeat.o(35125);
  }
  
  public final com.tencent.mm.api.c fCE()
  {
    return this.wPN;
  }
  
  public final com.tencent.mm.am.a.c fCF()
  {
    return this.Jul;
  }
  
  public final com.tencent.mm.am.a.k fCG()
  {
    return this.wRr;
  }
  
  public final boolean fCH()
  {
    return this.ruj;
  }
  
  public final boolean fCI()
  {
    return this.JGz;
  }
  
  public final boolean fCJ()
  {
    AppMethodBeat.i(35102);
    if (this.ruj)
    {
      int i;
      if (this.JGz)
      {
        i = com.tencent.mm.am.a.e.rY(fCU());
        if (bt.isNullOrNil(this.Jul.field_chatName)) {
          if (i == 0) {
            this.cWM.JOR.setMMTitle(this.cWM.JOR.getMMResources().getString(2131757293));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35102);
        return true;
        this.cWM.JOR.setMMTitle(this.cWM.JOR.getMMResources().getString(2131759496, new Object[] { this.cWM.JOR.getMMResources().getString(2131757293), Integer.valueOf(i) }));
        continue;
        ((com.tencent.mm.ui.chatting.d.b.y)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class)).setMMTitle(this.cWM.JOR.getMMResources().getString(2131759496, new Object[] { this.Jul.field_chatName, Integer.valueOf(i) }));
        continue;
        this.cWM.JOR.setMMTitle(this.wRr.field_userName);
      }
    }
    AppMethodBeat.o(35102);
    return false;
  }
  
  public final a fCK()
  {
    return this.JyU;
  }
  
  public final ChatFooter.g fCL()
  {
    return this.JxW;
  }
  
  public final List<bu> fCM()
  {
    int i = 100;
    AppMethodBeat.i(35104);
    Object localObject = ag.aGc().rS(fCU());
    if (((com.tencent.mm.am.a.a)localObject).field_unReadCount > 100) {}
    for (;;)
    {
      com.tencent.mm.model.ba.aBQ();
      localObject = com.tencent.mm.model.c.azt().q(this.cWM.BYG.field_username, fCU(), i);
      AppMethodBeat.o(35104);
      return localObject;
      i = ((com.tencent.mm.am.a.a)localObject).field_unReadCount;
    }
  }
  
  public final boolean fCN()
  {
    return this.JGH;
  }
  
  public final void fCO()
  {
    AppMethodBeat.i(35106);
    if (this.wPN == null)
    {
      AppMethodBeat.o(35106);
      return;
    }
    final boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.d.aHR()) && (!com.tencent.mm.modelgeo.d.aHS()))
    {
      bool = true;
      if ((this.wPN.field_hadAlert != 0) || (!bool)) {
        break label144;
      }
      str = this.cWM.JOR.getMMResources().getString(2131757140, new Object[] { this.cWM.BYG.adv() });
    }
    for (;;)
    {
      this.wRA = com.tencent.mm.ui.base.h.a(this.cWM.JOR.getContext(), str, this.cWM.JOR.getMMResources().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35098);
          c.c(c.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = c.c(c.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag |= 0x4;
            com.tencent.mm.am.g.i(paramAnonymousDialogInterface);
          }
          if (bool)
          {
            Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            paramAnonymousDialogInterface = c.this.cWM.JOR;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35098);
            return;
          }
          ag.aGk().Ec(c.this.cWM.getTalkerUserName());
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
            com.tencent.mm.am.g.i(paramAnonymousDialogInterface);
          }
          ag.aGk().Ec(c.this.cWM.getTalkerUserName());
          AppMethodBeat.o(35099);
        }
      });
      AppMethodBeat.o(35106);
      return;
      bool = false;
      break;
      label144:
      if (bool) {
        str = this.cWM.JOR.getMMResources().getString(2131757141);
      } else {
        str = this.cWM.JOR.getMMResources().getString(2131757139, new Object[] { this.cWM.BYG.adv() });
      }
    }
  }
  
  public final void fCP()
  {
    AppMethodBeat.i(35107);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.cWM.getTalkerUserName());
    localIntent.putExtra("key_start_biz_profile_setting_from_scene", 1);
    com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "profile", ".ui.newbizinfo.NewBizInfoSettingUI", localIntent);
    AppMethodBeat.o(35107);
  }
  
  public final int fCQ()
  {
    return this.JGD;
  }
  
  public final String fCR()
  {
    if (this.ruj) {
      if (this.JGz) {
        if (this.Jul != null) {}
      }
    }
    while (this.cWM.BYG == null)
    {
      do
      {
        return null;
        return this.Jul.field_chatName;
      } while (this.wRr == null);
      return this.wRr.field_userName;
    }
    return this.cWM.BYG.field_nickname;
  }
  
  public final boolean fCS()
  {
    AppMethodBeat.i(35109);
    Object localObject1 = new Intent(this.cWM.JOR.getContext(), ChatroomInfoUI.class);
    if ((this.cWM.fFu()) || (this.JGz)) {}
    Object localObject2;
    for (int i = 1; (i != 0) && (!this.ruj); i = 0)
    {
      ((Intent)localObject1).putExtra("Chat_User", this.cWM.BYG.field_username);
      ((Intent)localObject1).putExtra("RoomInfo_Id", this.cWM.getTalkerUserName());
      ((Intent)localObject1).putExtra("Is_Chatroom", this.cWM.fFu());
      ((Intent)localObject1).putExtra("fromChatting", true);
      localObject2 = this.cWM;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35109);
      return true;
    }
    if (this.ruj)
    {
      ((Intent)localObject1).setClass(this.cWM.JOR.getContext(), BizChatroomInfoUI.class);
      ((Intent)localObject1).putExtra("Chat_User", this.cWM.BYG.field_username);
      ((Intent)localObject1).putExtra("key_biz_chat_id", fCU());
      if ((this.cWM.JOR.thisActivity() instanceof ChattingUI)) {
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        localObject2 = this.cWM.JOR;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((w.Ak(this.cWM.getTalkerUserName())) || (am.aSN(this.cWM.getTalkerUserName())) || (am.aSP(this.cWM.getTalkerUserName())) || (w.Ag(this.cWM.getTalkerUserName())) || (am.zs(this.cWM.getTalkerUserName())) || (this.cWM.BYG.fqg()))
    {
      localObject1 = new Intent();
      com.tencent.mm.ui.contact.e.u((Intent)localObject1, this.cWM.getTalkerUserName());
      if (this.cWM.JOR.getIntExtra("chat_from_scene", 0) == 2)
      {
        ((Intent)localObject1).putExtra("Kdel_from", 2);
        ((Intent)localObject1).putExtra("chat_from_scene", this.cWM.JOR.getIntExtra("chat_from_scene", 0));
        ((Intent)localObject1).putExtra("preUsername", this.cWM.getTalkerUserName());
        ((Intent)localObject1).putExtra("preChatName", this.cWM.getTalkerUserName());
        if ((this.wPN == null) || (!this.wPN.Kk())) {
          break label833;
        }
        i = 6;
        label588:
        ((Intent)localObject1).putExtra("preChatTYPE", this.cWM.JOR.getIntExtra("preChatTYPE", i));
        localObject2 = this.cWM.JOR.getContext().getIntent();
        i = ((Intent)localObject2).getIntExtra("key_temp_session_scene", 5);
        if ((i != 16) && (i != 17) && (!((Intent)localObject2).getBooleanExtra("key_biz_profile_stay_after_follow_op", false))) {
          break label898;
        }
        ((Intent)localObject1).putExtra("Kdel_from", 1);
      }
    }
    label898:
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject1).putExtra("key_biz_profile_stay_after_follow_op", bool);
      if ((((ac)this.cWM.bh(ac.class)).fEy()) && (l.aWd(this.cWM.getTalkerUserName())))
      {
        if (i != 16) {
          break label839;
        }
        ((Intent)localObject1).putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.cWM.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.a.c.ma(2);
          com.tencent.mm.plugin.newtips.a.duq();
          if (com.tencent.mm.plugin.newtips.a.e.LM(com.tencent.mm.plugin.newtips.a.d.wsk))
          {
            com.tencent.mm.plugin.newtips.a.dun();
            com.tencent.mm.plugin.newtips.a.i.LO(com.tencent.mm.plugin.newtips.a.d.wsk);
            ((Intent)localObject1).putExtra("key_from_wesport_right_newtips", true);
          }
        }
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1, 213);
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("Kdel_from", 0);
        break;
        label833:
        i = 7;
        break label588;
        label839:
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
  
  public final boolean fCT()
  {
    AppMethodBeat.i(35110);
    if (this.cWM == null)
    {
      ad.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
      AppMethodBeat.o(35110);
      return false;
    }
    Object localObject1;
    if ((this.cWM.BYG.fqg()) && (this.wPN != null))
    {
      if (this.ruj)
      {
        bool = ag.aGc().rU(fCU());
        AppMethodBeat.o(35110);
        return bool;
      }
      if (!this.wPN.Ko()) {
        break label238;
      }
      if ((this.wPN.bX(false) != null) && (this.wPN.bX(false).KP() != null) && (!bt.isNullOrNil(this.wPN.Kv())))
      {
        com.tencent.mm.model.ba.aBQ();
        localObject1 = com.tencent.mm.model.c.azv().aTN(this.wPN.Kv());
        if ((localObject1 != null) && (((com.tencent.mm.g.c.ba)localObject1).field_username.equals(this.cWM.getTalkerUserName())) && (((com.tencent.mm.g.c.ba)localObject1).field_unReadCount > 0))
        {
          if (this.cWM.JOR.getIntExtra("chat_from_scene", 0) == 2)
          {
            AppMethodBeat.o(35110);
            return false;
          }
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().aTB(this.wPN.Kv());
        }
      }
    }
    while (w.Ad(this.cWM.getTalkerUserName()))
    {
      AppMethodBeat.o(35110);
      return true;
      label238:
      if ((!this.wPN.Kk()) && (!this.wPN.Km())) {
        if (!com.tencent.mm.storage.y.bNf())
        {
          com.tencent.mm.model.ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azv().fqU();
          if ((localObject1 != null) && (((com.tencent.mm.g.c.ba)localObject1).field_username.equals(this.cWM.getTalkerUserName())) && (((com.tencent.mm.g.c.ba)localObject1).field_unReadCount > 0))
          {
            com.tencent.mm.model.ba.aBQ();
            com.tencent.mm.model.c.azv().aTB("officialaccounts");
          }
        }
        else if (ag.aGf().fps() > 0)
        {
          localObject1 = ag.aGf();
          Object localObject2 = this.cWM.getTalkerUserName();
          localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + (String)localObject2 + "' ";
          ((x)localObject1).hHS.execSQL("BizTimeLineInfo", (String)localObject2);
          localObject2 = new x.a();
          ((x.a)localObject2).IoG = x.b.IoK;
          ((x)localObject1).a((x.a)localObject2);
        }
      }
    }
    com.tencent.mm.model.ba.aBQ();
    boolean bool = com.tencent.mm.model.c.azv().aTB(this.cWM.getTalkerUserName());
    AppMethodBeat.o(35110);
    return bool;
  }
  
  public final long fCU()
  {
    if (this.Jul == null) {
      return -1L;
    }
    return this.Jul.field_bizChatLocalId;
  }
  
  public final void fCV()
  {
    AppMethodBeat.i(35112);
    com.tencent.mm.model.ba.ajF().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35087);
        if (c.this.cWM == null)
        {
          AppMethodBeat.o(35087);
          return;
        }
        boolean bool = ((com.tencent.mm.ui.chatting.d.b.k)c.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode();
        if ((c.this.ruj) && (!bool)) {
          com.tencent.mm.am.a.e.d(c.this.Jul);
        }
        AppMethodBeat.o(35087);
      }
    }, 500L);
    AppMethodBeat.o(35112);
  }
  
  public final void fws()
  {
    boolean bool2 = false;
    AppMethodBeat.i(35119);
    this.JGA = this.cWM.JOR.getLongExtra("key_biz_chat_id", -1L);
    this.ruj = this.cWM.JOR.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    if (this.ruj)
    {
      this.Jul = ag.aGb().bd(this.JGA);
      this.Jul = com.tencent.mm.am.a.e.a(this.Jul, this.JGA);
      this.JGD = ag.aGc().rS(fCU()).field_unReadCount;
    }
    boolean bool1 = bool2;
    if (this.ruj)
    {
      bool1 = bool2;
      if (com.tencent.mm.am.a.e.Eq(this.Jul.field_bizChatServId)) {
        bool1 = true;
      }
    }
    this.JGz = bool1;
    if ((this.ruj) && (!this.JGz))
    {
      this.wRr = ag.aGd().eK(this.Jul.field_bizChatServId);
      this.wRr = com.tencent.mm.am.a.e.a(this.wRr, this.Jul.field_bizChatServId);
    }
    if (this.JGz) {
      this.JGH = com.tencent.mm.am.a.e.c(this.Jul);
    }
    this.wPN = com.tencent.mm.am.g.eS(this.cWM.getTalkerUserName());
    this.JGE = true;
    AppMethodBeat.o(35119);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35120);
    this.JGx = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    if (((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() > 0) {}
    for (localObject = ((com.tencent.mm.ui.chatting.d.b.k)localObject).ada(((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() - 1);; localObject = null)
    {
      this.JGy = ((bu)localObject);
      com.tencent.mm.storage.y.aSF(this.cWM.getTalkerUserName());
      this.cWM.JOR.getLongExtra("key_biz_chat_id", -1L);
      if (this.ruj)
      {
        ad.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
        com.tencent.mm.model.ba.ajF().n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35090);
            long l = System.currentTimeMillis();
            if ((c.this.ruj) && (c.this.Jul != null) && (c.this.cWM.BYG != null))
            {
              c.f(c.this);
              ag.aGm();
              com.tencent.mm.am.a.c localc = c.this.Jul;
              if (com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx))
              {
                String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
                aa.b(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
                ad.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
              }
              if (c.this.JGz)
              {
                if (c.this.Jul.aGp())
                {
                  ag.aGh();
                  com.tencent.mm.am.a.h.bj(c.this.Jul.field_bizChatServId, c.this.cWM.BYG.field_username);
                }
              }
              else {
                c.g(c.this);
              }
            }
            for (;;)
            {
              ad.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              AppMethodBeat.o(35090);
              return;
              com.tencent.mm.am.a.e.f(c.this.Jul);
              break;
              ad.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { c.this.Jul, c.this.cWM.BYG });
            }
          }
        }, 500L);
      }
      if ((this.cWM.BYG != null) && (this.cWM.BYG.fqg())) {
        ag.aGl().Dx(this.cWM.BYG.field_username);
      }
      this.obT.alive();
      this.JGA = this.cWM.JOR.getLongExtra("key_biz_chat_id", -1L);
      if ((com.tencent.mm.app.plugin.a.a.c(this.wPN)) && (this.JGw == null))
      {
        ad.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { fCR() });
        this.JGw = new com.tencent.mm.app.plugin.a.a(this.cWM);
      }
      if (this.cWM.BYG.fqg()) {
        com.tencent.mm.bh.d.chatType = 2;
      }
      if (this.ruj) {
        ag.aGb().a(this.JuW, Looper.getMainLooper());
      }
      if ((this.cWM.BYG != null) && (this.cWM.BYG.fqg())) {
        ag.aFZ().a(this.JGG, Looper.getMainLooper());
      }
      AppMethodBeat.o(35120);
      return;
    }
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35121);
    if ((com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) && (this.cWM.BYG.fqg()) && (com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) && (this.cWM.BYG.fqg()) && (!com.tencent.mm.am.g.vd(this.cWM.getTalkerUserName())))
    {
      int i = this.cWM.JOR.getIntExtra("specific_chat_from_scene", 0);
      if (this.hQt == null) {
        this.hQt = new dbo();
      }
      this.hQt.Hrr = this.cWM.JOR.getIntExtra("Main_IndexInSessionList", 0);
      this.hQt.Hrp = this.cWM.JOR.getIntExtra("Main_UnreadCount", 0);
      if (this.JGy != null)
      {
        this.hQt.Hrq = this.JGy.getType();
        if (this.hQt.Hrp > 0) {
          this.hQt.Hro = ((int)(this.JGx - this.JGy.field_createTime) / 1000);
        }
      }
      ag.aGk().a(this.cWM.getTalkerUserName(), this.JGy, i, this.hQt);
    }
    if (w.Ai(this.cWM.getTalkerUserName())) {
      com.tencent.e.h.LTJ.h(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193928);
          c.h(c.this);
          AppMethodBeat.o(193928);
        }
      }, "ReportEnterNotifyMessage");
    }
    AppMethodBeat.o(35121);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35122);
    this.JGF = true;
    bl.H("bizflag", ((ac)this.cWM.bh(ac.class)).fEy());
    if ((this.wPN == null) || (com.tencent.mm.app.plugin.a.a.c(this.wPN)))
    {
      ad.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { fCR() });
      if (this.JGw != null) {
        this.JGw.a(1, this.wPN);
      }
    }
    Object localObject1 = this.wPN;
    int i;
    if ((localObject1 != null) && (localObject1 != null))
    {
      localObject1 = ((com.tencent.mm.api.c)localObject1).bX(false);
      if ((localObject1 != null) && (((c.b)localObject1).Kx()))
      {
        i = 1;
        if (i != 0) {
          com.tencent.mm.model.ba.ajF().ay(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35096);
              sg localsg = new sg();
              if (c.c(c.this) != null)
              {
                localsg.dGL.userName = c.c(c.this).field_username;
                com.tencent.mm.sdk.b.a.IbL.l(localsg);
              }
              AppMethodBeat.o(35096);
            }
          });
        }
        if ((!com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) || (!this.cWM.BYG.fqg()) || (this.wPN == null)) {
          break label565;
        }
        localObject1 = this.wPN.bX(false);
        if ((localObject1 != null) && (((c.b)localObject1).Kj()))
        {
          if (this.wPN.field_hadAlert != 0) {
            break label549;
          }
          Object localObject2 = this.cWM.JOR.getContext().getResources().getString(2131757142, new Object[] { this.cWM.BYG.adv() });
          String str = this.cWM.JOR.getContext().getResources().getString(2131757143);
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
          localObject2 = new bu();
          ((bu)localObject2).tN(this.cWM.getTalkerUserName());
          ((bu)localObject2).kr(2);
          ((bu)localObject2).setType(10002);
          ((bu)localObject2).qA(bj.aCb());
          ((bu)localObject2).setContent(((StringBuffer)localObject1).toString());
          bj.v((bu)localObject2);
          this.wPN.field_hadAlert = 1;
          ag.aFZ().update(this.wPN, new String[0]);
        }
        label440:
        if ((this.wPN.Kh()) && ((!this.cWM.BYG.fqg()) || (!com.tencent.mm.am.a.aFr())))
        {
          as.a.hFO.aI(this.cWM.BYG.field_username, "");
          com.tencent.mm.ak.c.CT(this.cWM.BYG.field_username);
        }
        if (this.wPN.field_status == 1)
        {
          this.wPN.field_status = 0;
          ag.aFZ().g(this.wPN);
        }
      }
    }
    for (;;)
    {
      fCV();
      AppMethodBeat.o(35122);
      return;
      i = 0;
      break;
      label549:
      ag.aGk().Ec(this.cWM.getTalkerUserName());
      break label440;
      label565:
      if ((!this.cWM.JOR.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) && (this.cWM.BYG.fqg())) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35097);
            if ((!com.tencent.mm.o.b.lM(c.this.cWM.BYG.field_type)) && (c.this.cWM.BYG.fqg())) {
              c.this.cWM.JOR.setMMSubTitle(2131757138);
            }
            AppMethodBeat.o(35097);
          }
        });
      }
    }
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35123);
    this.JGF = false;
    if ((com.tencent.mm.o.b.lM(this.cWM.BYG.field_type)) && (this.cWM.BYG.fqg()) && (this.wPN != null))
    {
      ag.aGk().aFM();
      if (this.wRA != null) {
        this.wRA.dismiss();
      }
    }
    a.a locala = com.tencent.mm.msgsubscription.storage.a.iBk;
    ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clearNotifyCallback");
    com.tencent.mm.msgsubscription.storage.a.aOq().clear();
    AppMethodBeat.o(35123);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35124);
    this.JGE = false;
    fch();
    AppMethodBeat.o(35124);
  }
  
  public final void gy(String paramString, int paramInt)
  {
    AppMethodBeat.i(193930);
    Object localObject;
    int i;
    if ((!bt.isNullOrNil(paramString)) && (com.tencent.mm.am.g.DL(paramString)))
    {
      localObject = (com.tencent.mm.ui.chatting.d.b.k)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      if (((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() <= 0) {
        break label186;
      }
      localObject = ((com.tencent.mm.ui.chatting.d.b.k)localObject).ada(((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() - 1);
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
      ad.d("MicroMsg.ChattingUI.BizComponent", "alvinluo onFooterSwitchInput talker: %s, switchType: %d, lastMsgType: %d, sender: %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i), localObject });
      com.tencent.mm.plugin.report.service.g.yhR.f(20018, new Object[] { Long.valueOf(this.JGx), paramString, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), localObject, Integer.valueOf(1) });
      AppMethodBeat.o(193930);
      return;
      label186:
      localObject = null;
      break;
      label192:
      if (((bu)localObject).getType() == 285212721)
      {
        i = 2;
        break label70;
      }
      if (((bu)localObject).getType() == 318767153)
      {
        i = 5;
        break label70;
      }
      if (!bt.isNullOrNil(((ei)localObject).fky))
      {
        if (((ei)localObject).fkE == 1)
        {
          i = 3;
          break label70;
        }
        if (((ei)localObject).fkE == 2)
        {
          i = 4;
          break label70;
        }
      }
      i = 0;
      break label70;
      label268:
      if (!bt.isNullOrNil(((ei)localObject).fky)) {
        localObject = ((ei)localObject).fky;
      } else if (((ei)localObject).field_isSend == 0) {
        localObject = ((ei)localObject).field_talker;
      } else {
        localObject = com.tencent.mm.model.u.aAm();
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
      if (this.JGw != null)
      {
        paramIntent = this.JGw;
        if (paramIntent.cWM == null)
        {
          ad.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == -1)
        {
          Toast.makeText(paramIntent.cWM.JOR.getContext(), 2131758561, 0).show();
          eo localeo = new eo();
          localeo.dpI.op = 0;
          localeo.dpI.userName = paramIntent.cWM.getTalkerUserName();
          localeo.dpI.context = paramIntent.cWM.JOR.getContext();
          com.tencent.mm.sdk.b.a.IbL.l(localeo);
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == 0) {
          Toast.makeText(paramIntent.cWM.JOR.getContext(), 2131758560, 0).show();
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
    public abstract boolean fCX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c
 * JD-Core Version:    0.7.0.1
 */