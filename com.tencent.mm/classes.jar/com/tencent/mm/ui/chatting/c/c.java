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
import com.tencent.mm.am.a.d.a;
import com.tencent.mm.am.a.d.a.a;
import com.tencent.mm.am.a.d.a.b;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.a.y;
import com.tencent.mm.am.e.a;
import com.tencent.mm.am.e.a.a;
import com.tencent.mm.am.e.a.b;
import com.tencent.mm.am.h.a;
import com.tencent.mm.am.o;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.msgsubscription.storage.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.storage.t.b;
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

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.d.class)
public class c
  extends a
  implements o, com.tencent.mm.ui.chatting.c.b.d
{
  public com.tencent.mm.am.a.c GgE;
  private d.a Ghq;
  protected final ChatFooter.g Gkq;
  protected final a Glo;
  private RelativeLayout GsA;
  private TextView GsB;
  private int GsC;
  private boolean GsD;
  private boolean GsE;
  private e.a GsF;
  private boolean GsG;
  private com.tencent.mm.app.plugin.a.a Gsv;
  private long Gsw;
  private bl Gsx;
  public boolean Gsy;
  private long Gsz;
  private cqu gXz;
  private com.tencent.mm.sdk.b.c mYl;
  public boolean qbB;
  public com.tencent.mm.am.a.k uBp;
  private com.tencent.mm.ui.widget.a.d uBy;
  private com.tencent.mm.api.c uzN;
  
  public c()
  {
    AppMethodBeat.i(35100);
    this.Gsw = 0L;
    this.qbB = false;
    this.Gsy = false;
    this.Gsz = -1L;
    this.uBy = null;
    this.gXz = null;
    this.Glo = new a()
    {
      public final boolean eWS()
      {
        AppMethodBeat.i(35086);
        if (c.a(c.this) == null)
        {
          j.a(c.this.cOd.GzJ, 2131306438);
          c.a(c.this, (RelativeLayout)c.this.cOd.findViewById(2131297418));
          c.a(c.this, (TextView)c.this.cOd.findViewById(2131297419));
          c.b(c.this).setText(2131757080);
        }
        c.a(c.this).setVisibility(0);
        com.tencent.mm.ui.chatting.d.a.eZd().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35085);
            if ((c.a(c.this) != null) && (c.a(c.this).getVisibility() != 8)) {
              c.a(c.this).setVisibility(8);
            }
            if (c.this.cOd == null)
            {
              ad.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
              AppMethodBeat.o(35085);
              return;
            }
            ((com.tencent.mm.ui.chatting.c.b.w)c.this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXQ();
            c.this.cOd.bCM();
            AppMethodBeat.o(35085);
          }
        }, 5000L);
        AppMethodBeat.o(35086);
        return true;
      }
    };
    this.Gkq = new ChatFooter.g()
    {
      public final boolean us(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(35091);
        if (c.c(c.this) == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        Object localObject = c.c(c.this).bU(false);
        if (localObject == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = ((c.b)localObject).JE();
        if ((localObject == null) || (((c.b.c)localObject).cIU == null) || (((c.b.c)localObject).cIU.isEmpty()))
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = (com.tencent.mm.am.j)((c.b.c)localObject).cIU.get(0);
        try
        {
          localObject = new JSONObject(((com.tencent.mm.am.j)localObject).value);
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1083;
          localAppBrandStatObject.dbt = c.c(c.this).field_username;
          ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(aj.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, c.c(c.this).field_appId);
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
    this.Ghq = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35092);
        if ((c.this.qbB) && (paramAnonymousb != null) && (paramAnonymousb.gYF == c.this.eWP()))
        {
          if (!c.this.cOd.ctF)
          {
            ad.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
            AppMethodBeat.o(35092);
            return;
          }
          if (paramAnonymousb.gYP != d.a.a.gYM)
          {
            ad.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
            paramAnonymousb = com.tencent.mm.am.af.awg().bg(c.this.eWP());
            c.this.GgE = paramAnonymousb;
            if (!c.this.Gsy)
            {
              paramAnonymousb = com.tencent.mm.am.af.awi().ea(c.this.GgE.field_bizChatServId);
              if (paramAnonymousb != null) {
                c.this.uBp = paramAnonymousb;
              }
            }
            for (;;)
            {
              ((com.tencent.mm.ui.chatting.c.b.w)c.this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXQ();
              AppMethodBeat.o(35092);
              return;
              c.a(c.this, com.tencent.mm.am.a.e.c(c.this.GgE));
              ((com.tencent.mm.ui.chatting.c.b.w)c.this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXT();
            }
          }
          if (c.this.Gsy)
          {
            Toast.makeText(aj.getContext(), c.this.cOd.GzJ.getMMResources().getString(2131762612), 1).show();
            c.this.cOd.GzJ.eUW();
          }
        }
        AppMethodBeat.o(35092);
      }
    };
    this.GsD = false;
    this.GsE = false;
    this.GsF = new e.a()
    {
      public final void a(final e.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35094);
        if ((paramAnonymousb != null) && (paramAnonymousb.gXg == e.a.a.gXe) && (paramAnonymousb.gWU != null) && (paramAnonymousb.gWU.equals(c.this.cOd.getTalkerUserName())))
        {
          az.arV();
          final com.tencent.mm.storage.af localaf = com.tencent.mm.model.c.apM().aHY(paramAnonymousb.gWU);
          if ((localaf == null) || ((int)localaf.fId == 0))
          {
            ad.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramAnonymousb.gWU });
            AppMethodBeat.o(35094);
            return;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35093);
              if ((c.d(c.this)) && (paramAnonymousb.gWU.equals(c.this.cOd.getTalkerUserName())))
              {
                ad.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                c.a(c.this, com.tencent.mm.am.f.ei(paramAnonymousb.gWU));
                if ((c.this.cOd != null) && (c.e(c.this))) {
                  ((com.tencent.mm.ui.chatting.c.b.q)c.this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).ak(localaf);
                }
              }
              AppMethodBeat.o(35093);
            }
          });
        }
        AppMethodBeat.o(35094);
      }
    };
    this.mYl = new com.tencent.mm.sdk.b.c() {};
    this.GsG = false;
    AppMethodBeat.o(35100);
  }
  
  private String bi(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35115);
    if (paramLinkedList.size() <= 0)
    {
      AppMethodBeat.o(35115);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.GgE.sh((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.cOd.GzJ.getContext().getString(2131757106)).append(this.GgE.sh((String)paramLinkedList.get(i)));
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(35115);
    return paramLinkedList;
  }
  
  public static boolean bl(Intent paramIntent)
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
  
  private void eWR()
  {
    AppMethodBeat.i(35116);
    if (!this.qbB)
    {
      AppMethodBeat.o(35116);
      return;
    }
    com.tencent.mm.am.af.awm();
    com.tencent.mm.am.a.h.l(this.cOd.getTalkerUserName(), this.GgE.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(35116);
  }
  
  private void exO()
  {
    AppMethodBeat.i(35105);
    bk.G("bizflag", false);
    this.mYl.dead();
    Object localObject;
    if (this.qbB)
    {
      eWR();
      com.tencent.mm.am.af.awr();
      localObject = this.GgE;
      if (com.tencent.mm.kernel.a.mp(g.afz().gch))
      {
        String str = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.am.a.c)localObject).field_brandUserName, ((com.tencent.mm.am.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.modelsimple.aa.b(((com.tencent.mm.am.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str);
        ad.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str });
      }
    }
    if (this.Gsw != 0L) {}
    for (int i = (int)(System.currentTimeMillis() - this.Gsw) / 1000;; i = 0)
    {
      if (az.afw())
      {
        if (this.qbB) {
          com.tencent.mm.am.af.awg().a(this.Ghq);
        }
        if ((this.cOd.zgX != null) && (this.cOd.zgX.eKB())) {
          com.tencent.mm.am.af.awe().a(this.GsF);
        }
        if ((com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) && (this.cOd.zgX.eKB()) && (!com.tencent.mm.am.f.pc(this.cOd.getTalkerUserName())))
        {
          if ((this.uzN != null) && (this.uzN.Jb()))
          {
            if (this.gXz == null) {
              this.gXz = new cqu();
            }
            this.gXz.EjG = i;
            this.gXz.EjK = this.cOd.GzJ.getIntExtra("Main_IndexInSessionList", 0);
            this.gXz.EjI = this.cOd.GzJ.getIntExtra("Main_UnreadCount", 0);
            if (this.Gsx != null)
            {
              this.gXz.EjJ = this.Gsx.getType();
              if (this.gXz.EjI > 0) {
                this.gXz.EjH = ((int)(this.Gsw - this.Gsx.field_createTime) / 1000);
              }
            }
          }
          com.tencent.mm.am.af.awp().a(this.cOd.getTalkerUserName(), this.gXz);
        }
      }
      if ((com.tencent.mm.app.plugin.a.a.c(this.uzN)) && (this.Gsv != null))
      {
        ad.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { eWM() });
        this.Gsv.a(2, this.uzN);
        this.cOd.GzJ.setMMSubTitle(null);
      }
      if ((com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) && (this.cOd.zgX.eKB()) && (i != 0))
      {
        int j = this.cOd.GzJ.getIntExtra("specific_chat_from_scene", 0);
        int k = com.tencent.mm.storage.u.getSessionId();
        com.tencent.mm.plugin.report.service.h.vKh.f(10638, new Object[] { this.cOd.getTalkerUserName(), Integer.valueOf(i), Integer.valueOf(this.cOd.GzJ.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.cOd.GzJ.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(j), Integer.valueOf(k) });
      }
      if (this.Gsv != null)
      {
        localObject = this.Gsv;
        ad.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
        if (((com.tencent.mm.app.plugin.a.a)localObject).cOe != null)
        {
          com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.app.plugin.a.a)localObject).cOe);
          ((com.tencent.mm.app.plugin.a.a)localObject).cOe = null;
          if (((com.tencent.mm.app.plugin.a.a)localObject).cOh != null) {
            ((com.tencent.mm.app.plugin.a.a)localObject).cOh.clear();
          }
        }
        ((com.tencent.mm.app.plugin.a.a)localObject).cOi = false;
        if (((com.tencent.mm.app.plugin.a.a)localObject).cOf != null)
        {
          com.tencent.mm.sdk.b.a.ESL.d(((com.tencent.mm.app.plugin.a.a)localObject).cOf);
          ((com.tencent.mm.app.plugin.a.a)localObject).cOf = null;
        }
        this.Gsv = null;
      }
      com.tencent.mm.storage.u.aHx(null);
      this.Gsw = 0L;
      AppMethodBeat.o(35105);
      return;
    }
  }
  
  private boolean h(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35108);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.uzN == null) || (this.uzN.bU(false) == null) || (this.uzN.bU(false).JE() == null) || (this.uzN.bU(false).JE().cIU == null) || (this.uzN.bU(false).JE().cIU.isEmpty()))) {
      ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).eXs().fu(null);
    }
    AppMethodBeat.o(35108);
    return false;
  }
  
  public final long QU()
  {
    return this.Gsw;
  }
  
  public final void a(int paramInt, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(35111);
    if (paramn.getType() == 1357)
    {
      this.cOd.dismissDialog();
      if (paramInt != 0) {
        Toast.makeText(aj.getContext(), this.cOd.GzJ.getMMResources().getString(2131762584), 0).show();
      }
    }
    AppMethodBeat.o(35111);
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.ui.chatting.viewitems.bi parambi)
  {
    AppMethodBeat.i(191488);
    String str2 = com.tencent.mm.model.u.aqG();
    String str3 = parambi.userName;
    String str1;
    Object localObject;
    int j;
    if (bt.isNullOrNil(parambi.GQT))
    {
      str1 = "";
      i = parambi.gNZ;
      if (com.tencent.mm.am.f.wG(str3))
      {
        ad.d("MicroMsg.ChattingUI.BizComponent", "alvinluo reportBizAvatarClick brand: %s, username: %s, kfWorker: %s, kfType: %d", new Object[] { str3, str2, str1, Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.vKh.f(20008, new Object[] { Long.valueOf(this.Gsw), str3, Integer.valueOf(1), str1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((bt.isNullOrNil(parambi.GQT)) || (bt.isNullOrNil(parambi.userName)) || (com.tencent.mm.am.af.awf() == null) || (!com.tencent.mm.am.af.awf().nJ(parambi.gNZ))) {
        break label495;
      }
      localObject = com.tencent.mm.am.af.awf();
      str1 = parambi.userName;
      str3 = parambi.GQT;
      j = parambi.gNZ;
      ad.i("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle username: %s, brandUsername: %s, kfOpenId: %s, kfType: %d", new Object[] { str2, str1, str3, Integer.valueOf(j) });
      if (((com.tencent.mm.am.h)localObject).nJ(j))
      {
        parambi = ((com.tencent.mm.am.h)localObject).gXi;
        if ((bt.isNullOrNil(parambi.appId)) || (parambi.path == null)) {
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
      parambi = null;
      if ((parambi == null) || (parama.GzJ.getContext() == null)) {
        break label495;
      }
      ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(parama.GzJ.getContext(), parambi);
      AppMethodBeat.o(191488);
      return true;
      str1 = parambi.GQT;
      break;
    }
    label333:
    parambi = new com.tencent.mm.plugin.appbrand.a.f();
    parambi.appId = ((com.tencent.mm.am.h)localObject).gXi.appId;
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) {}
    for (i = ((com.tencent.mm.am.h)localObject).gXi.gXn;; i = 0)
    {
      parambi.gXn = i;
      parambi.scene = 1166;
      parambi.dbt = str1;
      localObject = Uri.parse(((com.tencent.mm.am.h)localObject).gXi.path).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("username", str2);
      ((Uri.Builder)localObject).appendQueryParameter("brandUsername", str1);
      ((Uri.Builder)localObject).appendQueryParameter("kfOpenId", str3);
      ((Uri.Builder)localObject).appendQueryParameter("kfType", String.valueOf(j));
      parambi.iJb = ((Uri.Builder)localObject).build().toString();
      ad.v("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle enterPath: %s", new Object[] { parambi.iJb });
      break;
    }
    label495:
    AppMethodBeat.o(191488);
    return false;
  }
  
  public final String aKF(String paramString)
  {
    AppMethodBeat.i(35113);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://weixin.qq.com/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) && (this.cOd.zgX.eKB()) && (this.uzN != null))
      {
        c.b localb = this.uzN.bU(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.JD())) && (paramString.contains(localb.JD())))
        {
          AppMethodBeat.o(35113);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(35113);
    return null;
  }
  
  public final void bh(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35114);
    com.tencent.mm.am.af.awg().bg(eWP());
    final LinkedList localLinkedList = new LinkedList();
    List localList = this.GgE.awt();
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
        com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131762605), null, this.cOd.GzJ.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35114);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131762600), null, this.cOd.GzJ.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35114);
      return;
    }
    paramLinkedList = this.cOd.GzJ.getMMResources().getString(2131762599, new Object[] { bi(localLinkedList) });
    com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), paramLinkedList, null, this.cOd.GzJ.getMMResources().getString(2131762607), this.cOd.GzJ.getMMResources().getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(35088);
        paramAnonymousDialogInterface = new mg();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < localLinkedList.size())
        {
          mf localmf = new mf();
          localmf.CIR = ((String)localLinkedList.get(paramAnonymousInt));
          paramAnonymousDialogInterface.CIS.add(localmf);
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
  
  public final void eQA()
  {
    boolean bool2 = false;
    AppMethodBeat.i(35119);
    this.Gsz = this.cOd.GzJ.getLongExtra("key_biz_chat_id", -1L);
    this.qbB = this.cOd.GzJ.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    if (this.qbB)
    {
      this.GgE = com.tencent.mm.am.af.awg().bg(this.Gsz);
      this.GgE = com.tencent.mm.am.a.e.a(this.GgE, this.Gsz);
      this.GsC = com.tencent.mm.am.af.awh().mf(eWP()).field_unReadCount;
    }
    boolean bool1 = bool2;
    if (this.qbB)
    {
      bool1 = bool2;
      if (com.tencent.mm.am.a.e.xl(this.GgE.field_bizChatServId)) {
        bool1 = true;
      }
    }
    this.Gsy = bool1;
    if ((this.qbB) && (!this.Gsy))
    {
      this.uBp = com.tencent.mm.am.af.awi().ea(this.GgE.field_bizChatServId);
      this.uBp = com.tencent.mm.am.a.e.a(this.uBp, this.GgE.field_bizChatServId);
    }
    if (this.Gsy) {
      this.GsG = com.tencent.mm.am.a.e.c(this.GgE);
    }
    this.uzN = com.tencent.mm.am.f.ei(this.cOd.getTalkerUserName());
    this.GsD = true;
    AppMethodBeat.o(35119);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35120);
    this.Gsw = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
    if (((com.tencent.mm.ui.chatting.c.b.i)localObject).getCount() > 0) {}
    for (localObject = ((com.tencent.mm.ui.chatting.c.b.i)localObject).YE(((com.tencent.mm.ui.chatting.c.b.i)localObject).getCount() - 1);; localObject = null)
    {
      this.Gsx = ((bl)localObject);
      com.tencent.mm.storage.u.aHx(this.cOd.getTalkerUserName());
      this.cOd.GzJ.getLongExtra("key_biz_chat_id", -1L);
      if (this.qbB)
      {
        ad.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
        az.afE().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35090);
            long l = System.currentTimeMillis();
            if ((c.this.qbB) && (c.this.GgE != null) && (c.this.cOd.zgX != null))
            {
              c.f(c.this);
              com.tencent.mm.am.af.awr();
              com.tencent.mm.am.a.c localc = c.this.GgE;
              if (com.tencent.mm.kernel.a.mp(g.afz().gch))
              {
                String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
                com.tencent.mm.modelsimple.aa.b(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
                ad.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
              }
              if (c.this.Gsy)
              {
                if (c.this.GgE.awu())
                {
                  com.tencent.mm.am.af.awm();
                  com.tencent.mm.am.a.h.ba(c.this.GgE.field_bizChatServId, c.this.cOd.zgX.field_username);
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
              com.tencent.mm.am.a.e.f(c.this.GgE);
              break;
              ad.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { c.this.GgE, c.this.cOd.zgX });
            }
          }
        }, 500L);
      }
      if ((this.cOd.zgX != null) && (this.cOd.zgX.eKB())) {
        com.tencent.mm.am.af.awq().ws(this.cOd.zgX.field_username);
      }
      this.mYl.alive();
      this.Gsz = this.cOd.GzJ.getLongExtra("key_biz_chat_id", -1L);
      if ((com.tencent.mm.app.plugin.a.a.c(this.uzN)) && (this.Gsv == null))
      {
        ad.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { eWM() });
        this.Gsv = new com.tencent.mm.app.plugin.a.a(this.cOd);
      }
      if (this.cOd.zgX.eKB()) {
        com.tencent.mm.bh.d.chatType = 2;
      }
      if (this.qbB) {
        com.tencent.mm.am.af.awg().a(this.Ghq, Looper.getMainLooper());
      }
      if ((this.cOd.zgX != null) && (this.cOd.zgX.eKB())) {
        com.tencent.mm.am.af.awe().a(this.GsF, Looper.getMainLooper());
      }
      AppMethodBeat.o(35120);
      return;
    }
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35121);
    if ((com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) && (this.cOd.zgX.eKB()) && (com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) && (this.cOd.zgX.eKB()) && (!com.tencent.mm.am.f.pc(this.cOd.getTalkerUserName())))
    {
      int i = this.cOd.GzJ.getIntExtra("specific_chat_from_scene", 0);
      if (this.gXz == null) {
        this.gXz = new cqu();
      }
      this.gXz.EjK = this.cOd.GzJ.getIntExtra("Main_IndexInSessionList", 0);
      this.gXz.EjI = this.cOd.GzJ.getIntExtra("Main_UnreadCount", 0);
      if (this.Gsx != null)
      {
        this.gXz.EjJ = this.Gsx.getType();
        if (this.gXz.EjI > 0) {
          this.gXz.EjH = ((int)(this.Gsw - this.Gsx.field_createTime) / 1000);
        }
      }
      com.tencent.mm.am.af.awp().a(this.cOd.getTalkerUserName(), this.Gsx, i, this.gXz);
    }
    AppMethodBeat.o(35121);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35122);
    this.GsE = true;
    bk.G("bizflag", ((com.tencent.mm.ui.chatting.c.b.aa)this.cOd.be(com.tencent.mm.ui.chatting.c.b.aa.class)).eYp());
    if ((this.uzN == null) || (com.tencent.mm.app.plugin.a.a.c(this.uzN)))
    {
      ad.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { eWM() });
      if (this.Gsv != null) {
        this.Gsv.a(1, this.uzN);
      }
    }
    Object localObject1 = this.uzN;
    int i;
    if ((localObject1 != null) && (localObject1 != null))
    {
      localObject1 = ((com.tencent.mm.api.c)localObject1).bU(false);
      if ((localObject1 != null) && (((c.b)localObject1).Jo()))
      {
        i = 1;
        if (i != 0) {
          az.afE().ax(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35096);
              rl localrl = new rl();
              if (c.c(c.this) != null)
              {
                localrl.dwX.userName = c.c(c.this).field_username;
                com.tencent.mm.sdk.b.a.ESL.l(localrl);
              }
              AppMethodBeat.o(35096);
            }
          });
        }
        if ((!com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) || (!this.cOd.zgX.eKB()) || (this.uzN == null)) {
          break label565;
        }
        localObject1 = this.uzN.bU(false);
        if ((localObject1 != null) && (((c.b)localObject1).Ja()))
        {
          if (this.uzN.field_hadAlert != 0) {
            break label549;
          }
          Object localObject2 = this.cOd.GzJ.getContext().getResources().getString(2131757142, new Object[] { this.cOd.zgX.ZX() });
          String str = this.cOd.GzJ.getContext().getResources().getString(2131757143);
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
          localObject2 = new bl();
          ((bl)localObject2).nY(this.cOd.getTalkerUserName());
          ((bl)localObject2).jV(2);
          ((bl)localObject2).setType(10002);
          ((bl)localObject2).kY(com.tencent.mm.model.bi.asg());
          ((bl)localObject2).setContent(((StringBuffer)localObject1).toString());
          com.tencent.mm.model.bi.u((bl)localObject2);
          this.uzN.field_hadAlert = 1;
          com.tencent.mm.am.af.awe().update(this.uzN, new String[0]);
        }
        label440:
        if ((this.uzN.IY()) && ((!this.cOd.zgX.eKB()) || (!com.tencent.mm.am.a.avv())))
        {
          ar.a.gMW.aB(this.cOd.zgX.field_username, "");
          com.tencent.mm.ak.c.vO(this.cOd.zgX.field_username);
        }
        if (this.uzN.field_status == 1)
        {
          this.uzN.field_status = 0;
          com.tencent.mm.am.af.awe().g(this.uzN);
        }
      }
    }
    for (;;)
    {
      eWQ();
      AppMethodBeat.o(35122);
      return;
      i = 0;
      break;
      label549:
      com.tencent.mm.am.af.awp().wX(this.cOd.getTalkerUserName());
      break label440;
      label565:
      if ((!this.cOd.GzJ.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) && (this.cOd.zgX.eKB())) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35097);
            if ((!com.tencent.mm.n.b.ls(c.this.cOd.zgX.field_type)) && (c.this.cOd.zgX.eKB())) {
              c.this.cOd.GzJ.setMMSubTitle(2131757138);
            }
            AppMethodBeat.o(35097);
          }
        });
      }
    }
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35123);
    this.GsE = false;
    if ((com.tencent.mm.n.b.ls(this.cOd.zgX.field_type)) && (this.cOd.zgX.eKB()) && (this.uzN != null))
    {
      com.tencent.mm.am.af.awp().avR();
      if (this.uBy != null) {
        this.uBy.dismiss();
      }
    }
    a.a locala = com.tencent.mm.msgsubscription.storage.a.hHo;
    ad.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clearNotifyCallback");
    com.tencent.mm.msgsubscription.storage.a.aEp().clear();
    AppMethodBeat.o(35123);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35124);
    this.GsD = false;
    exO();
    AppMethodBeat.o(35124);
  }
  
  public final com.tencent.mm.am.a.c eWA()
  {
    return this.GgE;
  }
  
  public final com.tencent.mm.am.a.k eWB()
  {
    return this.uBp;
  }
  
  public final boolean eWC()
  {
    return this.qbB;
  }
  
  public final boolean eWD()
  {
    return this.Gsy;
  }
  
  public final boolean eWE()
  {
    AppMethodBeat.i(35102);
    if (this.qbB)
    {
      int i;
      if (this.Gsy)
      {
        i = com.tencent.mm.am.a.e.ml(eWP());
        if (bt.isNullOrNil(this.GgE.field_chatName)) {
          if (i == 0) {
            this.cOd.GzJ.setMMTitle(this.cOd.GzJ.getMMResources().getString(2131757293));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35102);
        return true;
        this.cOd.GzJ.setMMTitle(this.cOd.GzJ.getMMResources().getString(2131759496, new Object[] { this.cOd.GzJ.getMMResources().getString(2131757293), Integer.valueOf(i) }));
        continue;
        ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).setMMTitle(this.cOd.GzJ.getMMResources().getString(2131759496, new Object[] { this.GgE.field_chatName, Integer.valueOf(i) }));
        continue;
        this.cOd.GzJ.setMMTitle(this.uBp.field_userName);
      }
    }
    AppMethodBeat.o(35102);
    return false;
  }
  
  public final a eWF()
  {
    return this.Glo;
  }
  
  public final ChatFooter.g eWG()
  {
    return this.Gkq;
  }
  
  public final List<bl> eWH()
  {
    int i = 100;
    AppMethodBeat.i(35104);
    Object localObject = com.tencent.mm.am.af.awh().mf(eWP());
    if (((com.tencent.mm.am.a.a)localObject).field_unReadCount > 100) {}
    for (;;)
    {
      az.arV();
      localObject = com.tencent.mm.model.c.apP().o(this.cOd.zgX.field_username, eWP(), i);
      AppMethodBeat.o(35104);
      return localObject;
      i = ((com.tencent.mm.am.a.a)localObject).field_unReadCount;
    }
  }
  
  public final boolean eWI()
  {
    return this.GsG;
  }
  
  public final void eWJ()
  {
    AppMethodBeat.i(35106);
    if (this.uzN == null)
    {
      AppMethodBeat.o(35106);
      return;
    }
    final boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.d.axU()) && (!com.tencent.mm.modelgeo.d.axV()))
    {
      bool = true;
      if ((this.uzN.field_hadAlert != 0) || (!bool)) {
        break label144;
      }
      str = this.cOd.GzJ.getMMResources().getString(2131757140, new Object[] { this.cOd.zgX.ZX() });
    }
    for (;;)
    {
      this.uBy = com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), str, this.cOd.GzJ.getMMResources().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35098);
          c.c(c.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = c.c(c.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag |= 0x4;
            com.tencent.mm.am.f.i(paramAnonymousDialogInterface);
          }
          if (bool)
          {
            Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            paramAnonymousDialogInterface = c.this.cOd.GzJ;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35098);
            return;
          }
          com.tencent.mm.am.af.awp().wX(c.this.cOd.getTalkerUserName());
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
            com.tencent.mm.am.f.i(paramAnonymousDialogInterface);
          }
          com.tencent.mm.am.af.awp().wX(c.this.cOd.getTalkerUserName());
          AppMethodBeat.o(35099);
        }
      });
      AppMethodBeat.o(35106);
      return;
      bool = false;
      break;
      label144:
      if (bool) {
        str = this.cOd.GzJ.getMMResources().getString(2131757141);
      } else {
        str = this.cOd.GzJ.getMMResources().getString(2131757139, new Object[] { this.cOd.zgX.ZX() });
      }
    }
  }
  
  public final void eWK()
  {
    AppMethodBeat.i(35107);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.cOd.getTalkerUserName());
    localIntent.putExtra("key_start_biz_profile_setting_from_scene", 1);
    com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "profile", ".ui.newbizinfo.NewBizInfoSettingUI", localIntent);
    AppMethodBeat.o(35107);
  }
  
  public final int eWL()
  {
    return this.GsC;
  }
  
  public final String eWM()
  {
    if (this.qbB) {
      if (this.Gsy) {
        if (this.GgE != null) {}
      }
    }
    while (this.cOd.zgX == null)
    {
      do
      {
        return null;
        return this.GgE.field_chatName;
      } while (this.uBp == null);
      return this.uBp.field_userName;
    }
    return this.cOd.zgX.field_nickname;
  }
  
  public final boolean eWN()
  {
    AppMethodBeat.i(35109);
    Object localObject1 = new Intent(this.cOd.GzJ.getContext(), ChatroomInfoUI.class);
    if ((this.cOd.eZa()) || (this.Gsy)) {}
    Object localObject2;
    for (int i = 1; (i != 0) && (!this.qbB); i = 0)
    {
      ((Intent)localObject1).putExtra("Chat_User", this.cOd.zgX.field_username);
      ((Intent)localObject1).putExtra("RoomInfo_Id", this.cOd.getTalkerUserName());
      ((Intent)localObject1).putExtra("Is_Chatroom", this.cOd.eZa());
      ((Intent)localObject1).putExtra("fromChatting", true);
      localObject2 = this.cOd;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.ui.chatting.d.a)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35109);
      return true;
    }
    if (this.qbB)
    {
      ((Intent)localObject1).setClass(this.cOd.GzJ.getContext(), BizChatroomInfoUI.class);
      ((Intent)localObject1).putExtra("Chat_User", this.cOd.zgX.field_username);
      ((Intent)localObject1).putExtra("key_biz_chat_id", eWP());
      if ((this.cOd.GzJ.thisActivity() instanceof ChattingUI)) {
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        localObject2 = this.cOd.GzJ;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((com.tencent.mm.model.w.tk(this.cOd.getTalkerUserName())) || (com.tencent.mm.storage.af.aHE(this.cOd.getTalkerUserName())) || (com.tencent.mm.storage.af.aHG(this.cOd.getTalkerUserName())) || (com.tencent.mm.model.w.tg(this.cOd.getTalkerUserName())) || (com.tencent.mm.storage.af.st(this.cOd.getTalkerUserName())) || (this.cOd.zgX.eKB()))
    {
      localObject1 = new Intent();
      com.tencent.mm.ui.contact.e.u((Intent)localObject1, this.cOd.getTalkerUserName());
      if (this.cOd.GzJ.getIntExtra("chat_from_scene", 0) == 2)
      {
        ((Intent)localObject1).putExtra("Kdel_from", 2);
        ((Intent)localObject1).putExtra("chat_from_scene", this.cOd.GzJ.getIntExtra("chat_from_scene", 0));
        ((Intent)localObject1).putExtra("preUsername", this.cOd.getTalkerUserName());
        ((Intent)localObject1).putExtra("preChatName", this.cOd.getTalkerUserName());
        if ((this.uzN == null) || (!this.uzN.Jb())) {
          break label833;
        }
        i = 6;
        label588:
        ((Intent)localObject1).putExtra("preChatTYPE", this.cOd.GzJ.getIntExtra("preChatTYPE", i));
        localObject2 = this.cOd.GzJ.getContext().getIntent();
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
      if ((((com.tencent.mm.ui.chatting.c.b.aa)this.cOd.be(com.tencent.mm.ui.chatting.c.b.aa.class)).eYp()) && (j.aKH(this.cOd.getTalkerUserName())))
      {
        if (i != 16) {
          break label839;
        }
        ((Intent)localObject1).putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.cOd.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.a.c.lI(2);
          com.tencent.mm.plugin.newtips.a.cWv();
          if (com.tencent.mm.plugin.newtips.a.e.Il(com.tencent.mm.plugin.newtips.a.d.udT))
          {
            com.tencent.mm.plugin.newtips.a.cWs();
            com.tencent.mm.plugin.newtips.a.i.In(com.tencent.mm.plugin.newtips.a.d.udT);
            ((Intent)localObject1).putExtra("key_from_wesport_right_newtips", true);
          }
        }
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1, 213);
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
  
  public final boolean eWO()
  {
    AppMethodBeat.i(35110);
    if (this.cOd == null)
    {
      ad.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
      AppMethodBeat.o(35110);
      return false;
    }
    Object localObject1;
    if ((this.cOd.zgX.eKB()) && (this.uzN != null))
    {
      if (this.qbB)
      {
        bool = com.tencent.mm.am.af.awh().mh(eWP());
        AppMethodBeat.o(35110);
        return bool;
      }
      if (!this.uzN.Jf()) {
        break label238;
      }
      if ((this.uzN.bU(false) != null) && (this.uzN.bU(false).JH() != null) && (!bt.isNullOrNil(this.uzN.Jm())))
      {
        az.arV();
        localObject1 = com.tencent.mm.model.c.apR().aIA(this.uzN.Jm());
        if ((localObject1 != null) && (((ay)localObject1).field_username.equals(this.cOd.getTalkerUserName())) && (((ay)localObject1).field_unReadCount > 0))
        {
          if (this.cOd.GzJ.getIntExtra("chat_from_scene", 0) == 2)
          {
            AppMethodBeat.o(35110);
            return false;
          }
          az.arV();
          com.tencent.mm.model.c.apR().aIp(this.uzN.Jm());
        }
      }
    }
    while (com.tencent.mm.model.w.td(this.cOd.getTalkerUserName()))
    {
      AppMethodBeat.o(35110);
      return true;
      label238:
      if ((!this.uzN.Jb()) && (!this.uzN.Jd())) {
        if (!com.tencent.mm.storage.u.bBQ())
        {
          az.arV();
          localObject1 = com.tencent.mm.model.c.apR().eLp();
          if ((localObject1 != null) && (((ay)localObject1).field_username.equals(this.cOd.getTalkerUserName())) && (((ay)localObject1).field_unReadCount > 0))
          {
            az.arV();
            com.tencent.mm.model.c.apR().aIp("officialaccounts");
          }
        }
        else if (com.tencent.mm.am.af.awk().eJW() > 0)
        {
          localObject1 = com.tencent.mm.am.af.awk();
          Object localObject2 = this.cOd.getTalkerUserName();
          localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + (String)localObject2 + "' ";
          ((com.tencent.mm.storage.t)localObject1).gPa.execSQL("BizTimeLineInfo", (String)localObject2);
          localObject2 = new t.a();
          ((t.a)localObject2).FeG = t.b.FeK;
          ((com.tencent.mm.storage.t)localObject1).a((t.a)localObject2);
        }
      }
    }
    az.arV();
    boolean bool = com.tencent.mm.model.c.apR().aIp(this.cOd.getTalkerUserName());
    AppMethodBeat.o(35110);
    return bool;
  }
  
  public final long eWP()
  {
    if (this.GgE == null) {
      return -1L;
    }
    return this.GgE.field_bizChatLocalId;
  }
  
  public final void eWQ()
  {
    AppMethodBeat.i(35112);
    az.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35087);
        if (c.this.cOd == null)
        {
          AppMethodBeat.o(35087);
          return;
        }
        boolean bool = ((com.tencent.mm.ui.chatting.c.b.i)c.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).isInEditMode();
        if ((c.this.qbB) && (!bool)) {
          com.tencent.mm.am.a.e.d(c.this.GgE);
        }
        AppMethodBeat.o(35087);
      }
    }, 500L);
    AppMethodBeat.o(35112);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35125);
    super.eWx();
    exO();
    AppMethodBeat.o(35125);
  }
  
  public final com.tencent.mm.api.c eWz()
  {
    return this.uzN;
  }
  
  public final void fX(String paramString, int paramInt)
  {
    AppMethodBeat.i(191489);
    Object localObject;
    int i;
    if ((!bt.isNullOrNil(paramString)) && (com.tencent.mm.am.f.wG(paramString)))
    {
      localObject = (com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
      if (((com.tencent.mm.ui.chatting.c.b.i)localObject).getCount() <= 0) {
        break label186;
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.i)localObject).YE(((com.tencent.mm.ui.chatting.c.b.i)localObject).getCount() - 1);
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
      com.tencent.mm.plugin.report.service.h.vKh.f(20018, new Object[] { Long.valueOf(this.Gsw), paramString, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), localObject, Integer.valueOf(1) });
      AppMethodBeat.o(191489);
      return;
      label186:
      localObject = null;
      break;
      label192:
      if (((bl)localObject).getType() == 285212721)
      {
        i = 2;
        break label70;
      }
      if (((bl)localObject).getType() == 318767153)
      {
        i = 5;
        break label70;
      }
      if (!bt.isNullOrNil(((du)localObject).ePb))
      {
        if (((du)localObject).ePh == 1)
        {
          i = 3;
          break label70;
        }
        if (((du)localObject).ePh == 2)
        {
          i = 4;
          break label70;
        }
      }
      i = 0;
      break label70;
      label268:
      if (!bt.isNullOrNil(((du)localObject).ePb)) {
        localObject = ((du)localObject).ePb;
      } else if (((du)localObject).field_isSend == 0) {
        localObject = ((du)localObject).field_talker;
      } else {
        localObject = com.tencent.mm.model.u.aqG();
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
      if (this.Gsv != null)
      {
        paramIntent = this.Gsv;
        if (paramIntent.cOd == null)
        {
          ad.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == -1)
        {
          Toast.makeText(paramIntent.cOd.GzJ.getContext(), 2131758561, 0).show();
          ek localek = new ek();
          localek.dgR.op = 0;
          localek.dgR.userName = paramIntent.cOd.getTalkerUserName();
          localek.dgR.context = paramIntent.cOd.GzJ.getContext();
          com.tencent.mm.sdk.b.a.ESL.l(localek);
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == 0) {
          Toast.makeText(paramIntent.cOd.GzJ.getContext(), 2131758560, 0).show();
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
  
  public final String xn(String paramString)
  {
    AppMethodBeat.i(35103);
    paramString = this.GgE.xh(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(35103);
      return paramString;
    }
    AppMethodBeat.o(35103);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract boolean eWS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c
 * JD-Core Version:    0.7.0.1
 */