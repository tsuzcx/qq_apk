package com.tencent.mm.ui.chatting.d;

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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.a.a;
import com.tencent.mm.al.f.a.b;
import com.tencent.mm.al.i.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.msgsubscription.storage.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.r;
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

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.d.class)
public class c
  extends a
  implements com.tencent.mm.al.p, com.tencent.mm.ui.chatting.d.b.d
{
  private d.a JPM;
  public com.tencent.mm.al.a.c JPa;
  protected final ChatFooter.g JSM;
  protected final a JTK;
  private com.tencent.mm.app.plugin.a.a Kbn;
  private long Kbo;
  private bv Kbp;
  public boolean Kbq;
  private long Kbr;
  private RelativeLayout Kbs;
  private TextView Kbt;
  private int Kbu;
  private boolean Kbv;
  private boolean Kbw;
  private f.a Kbx;
  private boolean Kby;
  private dci hTl;
  private com.tencent.mm.sdk.b.c ohH;
  public boolean rCv;
  private com.tencent.mm.api.c xfE;
  public com.tencent.mm.al.a.k xhi;
  private com.tencent.mm.ui.widget.a.d xhr;
  
  public c()
  {
    AppMethodBeat.i(35100);
    this.Kbo = 0L;
    this.rCv = false;
    this.Kbq = false;
    this.Kbr = -1L;
    this.xhr = null;
    this.hTl = null;
    this.JTK = new a()
    {
      public final boolean fGZ()
      {
        AppMethodBeat.i(35086);
        if (c.a(c.this) == null)
        {
          l.a(c.this.cXJ.Kkd, 2131306438);
          c.a(c.this, (RelativeLayout)c.this.cXJ.findViewById(2131297418));
          c.a(c.this, (TextView)c.this.cXJ.findViewById(2131297419));
          c.b(c.this).setText(2131757080);
        }
        c.a(c.this).setVisibility(0);
        com.tencent.mm.ui.chatting.e.a.fJE().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35085);
            if ((c.a(c.this) != null) && (c.a(c.this).getVisibility() != 8)) {
              c.a(c.this).setVisibility(8);
            }
            if (c.this.cXJ == null)
            {
              ae.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
              AppMethodBeat.o(35085);
              return;
            }
            ((com.tencent.mm.ui.chatting.d.b.y)c.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fHr();
            c.this.cXJ.bPl();
            AppMethodBeat.o(35085);
          }
        }, 5000L);
        AppMethodBeat.o(35086);
        return true;
      }
    };
    this.JSM = new ChatFooter.g()
    {
      public final boolean wo(boolean paramAnonymousBoolean)
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
        localObject = ((c.b)localObject).KU();
        if ((localObject == null) || (((c.b.c)localObject).cRQ == null) || (((c.b.c)localObject).cRQ.isEmpty()))
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = (com.tencent.mm.al.k)((c.b.c)localObject).cRQ.get(0);
        try
        {
          localObject = new JSONObject(((com.tencent.mm.al.k)localObject).value);
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1083;
          localAppBrandStatObject.dlj = c.c(c.this).field_username;
          ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(ak.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, c.c(c.this).field_appId);
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
    this.JPM = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35092);
        if ((c.this.rCv) && (paramAnonymousb != null) && (paramAnonymousb.hUr == c.this.fGW()))
        {
          if (!c.this.cXJ.cCq)
          {
            ae.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
            AppMethodBeat.o(35092);
            return;
          }
          if (paramAnonymousb.hUB != d.a.a.hUy)
          {
            ae.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
            paramAnonymousb = ag.aGr().bd(c.this.fGW());
            c.this.JPa = paramAnonymousb;
            if (!c.this.Kbq)
            {
              paramAnonymousb = ag.aGt().eP(c.this.JPa.field_bizChatServId);
              if (paramAnonymousb != null) {
                c.this.xhi = paramAnonymousb;
              }
            }
            for (;;)
            {
              ((com.tencent.mm.ui.chatting.d.b.y)c.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fHr();
              AppMethodBeat.o(35092);
              return;
              c.a(c.this, com.tencent.mm.al.a.e.c(c.this.JPa));
              ((com.tencent.mm.ui.chatting.d.b.y)c.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fIf();
            }
          }
          if (c.this.Kbq)
          {
            Toast.makeText(ak.getContext(), c.this.cXJ.Kkd.getMMResources().getString(2131762612), 1).show();
            c.this.cXJ.Kkd.fEZ();
          }
        }
        AppMethodBeat.o(35092);
      }
    };
    this.Kbv = false;
    this.Kbw = false;
    this.Kbx = new f.a()
    {
      public final void a(final f.a.b paramAnonymousb)
      {
        AppMethodBeat.i(35094);
        if ((paramAnonymousb != null) && (paramAnonymousb.hSS == f.a.a.hSQ) && (paramAnonymousb.hSG != null) && (paramAnonymousb.hSG.equals(c.this.cXJ.getTalkerUserName())))
        {
          bc.aCg();
          final an localan = com.tencent.mm.model.c.azF().BH(paramAnonymousb.hSG);
          if ((localan == null) || ((int)localan.ght == 0))
          {
            ae.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramAnonymousb.hSG });
            AppMethodBeat.o(35094);
            return;
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35093);
              if ((c.d(c.this)) && (paramAnonymousb.hSG.equals(c.this.cXJ.getTalkerUserName())))
              {
                ae.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
                c.a(c.this, com.tencent.mm.al.g.eX(paramAnonymousb.hSG));
                if ((c.this.cXJ != null) && (c.e(c.this))) {
                  ((s)c.this.cXJ.bh(s.class)).as(localan);
                }
              }
              AppMethodBeat.o(35093);
            }
          });
        }
        AppMethodBeat.o(35094);
      }
    };
    this.ohH = new com.tencent.mm.sdk.b.c() {};
    this.Kby = false;
    AppMethodBeat.o(35100);
  }
  
  private String br(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35115);
    if (paramLinkedList.size() <= 0)
    {
      AppMethodBeat.o(35115);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.JPa.zP((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.cXJ.Kkd.getContext().getString(2131757106)).append(this.JPa.zP((String)paramLinkedList.get(i)));
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(35115);
    return paramLinkedList;
  }
  
  public static boolean bs(Intent paramIntent)
  {
    AppMethodBeat.i(35101);
    String str = paramIntent.getStringExtra("Chat_User");
    boolean bool = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if ((!bool) && (str == null))
    {
      ae.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
      AppMethodBeat.o(35101);
      return true;
    }
    if ((bool) && (paramIntent.getLongExtra("key_biz_chat_id", -1L) == -1L))
    {
      ae.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
      AppMethodBeat.o(35101);
      return true;
    }
    AppMethodBeat.o(35101);
    return false;
  }
  
  private void fGY()
  {
    AppMethodBeat.i(35116);
    if (!this.rCv)
    {
      AppMethodBeat.o(35116);
      return;
    }
    ag.aGx();
    com.tencent.mm.al.a.h.l(this.cXJ.getTalkerUserName(), this.JPa.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(35116);
  }
  
  private void ffV()
  {
    AppMethodBeat.i(35105);
    bn.H("bizflag", false);
    this.ohH.dead();
    Object localObject;
    if (this.rCv)
    {
      fGY();
      ag.aGC();
      localObject = this.JPa;
      if (com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe))
      {
        String str = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.al.a.c)localObject).field_brandUserName, ((com.tencent.mm.al.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        ab.b(((com.tencent.mm.al.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str);
        ae.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str });
      }
    }
    if (this.Kbo != 0L) {}
    for (int i = (int)(System.currentTimeMillis() - this.Kbo) / 1000;; i = 0)
    {
      if (bc.ajM())
      {
        if (this.rCv) {
          ag.aGr().a(this.JPM);
        }
        if ((this.cXJ.Cqh != null) && (this.cXJ.Cqh.fug())) {
          ag.aGp().a(this.Kbx);
        }
        if ((com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) && (this.cXJ.Cqh.fug()) && (!com.tencent.mm.al.g.vz(this.cXJ.getTalkerUserName())))
        {
          if ((this.xfE != null) && (this.xfE.Ks()))
          {
            if (this.hTl == null) {
              this.hTl = new dci();
            }
            this.hTl.HKP = i;
            this.hTl.HKT = this.cXJ.Kkd.getIntExtra("Main_IndexInSessionList", 0);
            this.hTl.HKR = this.cXJ.Kkd.getIntExtra("Main_UnreadCount", 0);
            if (this.Kbp != null)
            {
              this.hTl.HKS = this.Kbp.getType();
              if (this.hTl.HKR > 0) {
                this.hTl.HKQ = ((int)(this.Kbo - this.Kbp.field_createTime) / 1000);
              }
            }
          }
          ag.aGA().a(this.cXJ.getTalkerUserName(), this.hTl);
        }
      }
      if ((com.tencent.mm.app.plugin.a.a.c(this.xfE)) && (this.Kbn != null))
      {
        ae.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { fGT() });
        this.Kbn.a(2, this.xfE);
        this.cXJ.Kkd.setMMSubTitle(null);
      }
      if ((com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) && (this.cXJ.Cqh.fug()) && (i != 0))
      {
        int j = this.cXJ.Kkd.getIntExtra("specific_chat_from_scene", 0);
        int k = com.tencent.mm.storage.y.getSessionId();
        com.tencent.mm.plugin.report.service.g.yxI.f(10638, new Object[] { this.cXJ.getTalkerUserName(), Integer.valueOf(i), Integer.valueOf(this.cXJ.Kkd.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.cXJ.Kkd.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(j), Integer.valueOf(k) });
      }
      if (this.Kbn != null)
      {
        localObject = this.Kbn;
        ae.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
        if (((com.tencent.mm.app.plugin.a.a)localObject).cXK != null)
        {
          com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.app.plugin.a.a)localObject).cXK);
          ((com.tencent.mm.app.plugin.a.a)localObject).cXK = null;
          if (((com.tencent.mm.app.plugin.a.a)localObject).cXN != null) {
            ((com.tencent.mm.app.plugin.a.a)localObject).cXN.clear();
          }
        }
        ((com.tencent.mm.app.plugin.a.a)localObject).cXO = false;
        if (((com.tencent.mm.app.plugin.a.a)localObject).cXL != null)
        {
          com.tencent.mm.sdk.b.a.IvT.d(((com.tencent.mm.app.plugin.a.a)localObject).cXL);
          ((com.tencent.mm.app.plugin.a.a)localObject).cXL = null;
        }
        this.Kbn = null;
      }
      com.tencent.mm.storage.y.aUd(null);
      this.Kbo = 0L;
      AppMethodBeat.o(35105);
      return;
    }
  }
  
  private boolean h(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35108);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.xfE == null) || (this.xfE.bX(false) == null) || (this.xfE.bX(false).KU() == null) || (this.xfE.bX(false).KU().cRQ == null) || (this.xfE.bX(false).KU().cRQ.isEmpty()))) {
      ((s)this.cXJ.bh(s.class)).fHF().fV(null);
    }
    AppMethodBeat.o(35108);
    return false;
  }
  
  public final String EU(String paramString)
  {
    AppMethodBeat.i(35103);
    paramString = this.JPa.EO(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(35103);
      return paramString;
    }
    AppMethodBeat.o(35103);
    return null;
  }
  
  public final long TJ()
  {
    return this.Kbo;
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(35111);
    if (paramn.getType() == 1357)
    {
      this.cXJ.dismissDialog();
      if (paramInt != 0) {
        Toast.makeText(ak.getContext(), this.cXJ.Kkd.getMMResources().getString(2131762584), 0).show();
      }
    }
    AppMethodBeat.o(35111);
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.e.a parama, bk parambk)
  {
    AppMethodBeat.i(187236);
    String str2 = v.aAC();
    String str3 = parambk.userName;
    String str1;
    Object localObject;
    int j;
    if (bu.isNullOrNil(parambk.KDS))
    {
      str1 = "";
      i = parambk.hJJ;
      if (com.tencent.mm.al.g.En(str3))
      {
        ae.d("MicroMsg.ChattingUI.BizComponent", "alvinluo reportBizAvatarClick brand: %s, username: %s, kfWorker: %s, kfType: %d", new Object[] { str3, str2, str1, Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.g.yxI.f(20008, new Object[] { Long.valueOf(this.Kbo), str3, Integer.valueOf(1), str1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((bu.isNullOrNil(parambk.KDS)) || (bu.isNullOrNil(parambk.userName)) || (ag.aGq() == null) || (!ag.aGq().pb(parambk.hJJ))) {
        break label495;
      }
      localObject = ag.aGq();
      str1 = parambk.userName;
      str3 = parambk.KDS;
      j = parambk.hJJ;
      ae.i("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle username: %s, brandUsername: %s, kfOpenId: %s, kfType: %d", new Object[] { str2, str1, str3, Integer.valueOf(j) });
      if (((com.tencent.mm.al.i)localObject).pb(j))
      {
        parambk = ((com.tencent.mm.al.i)localObject).hSU;
        if ((bu.isNullOrNil(parambk.appId)) || (parambk.path == null)) {
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
      if ((parambk == null) || (parama.Kkd.getContext() == null)) {
        break label495;
      }
      ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(parama.Kkd.getContext(), parambk);
      AppMethodBeat.o(187236);
      return true;
      str1 = parambk.KDS;
      break;
    }
    label333:
    parambk = new com.tencent.mm.plugin.appbrand.api.f();
    parambk.appId = ((com.tencent.mm.al.i)localObject).hSU.appId;
    if ((j.IS_FLAVOR_RED) || (j.DEBUG)) {}
    for (i = ((com.tencent.mm.al.i)localObject).hSU.hSZ;; i = 0)
    {
      parambk.hSZ = i;
      parambk.scene = 1166;
      parambk.dlj = str1;
      localObject = Uri.parse(((com.tencent.mm.al.i)localObject).hSU.path).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("username", str2);
      ((Uri.Builder)localObject).appendQueryParameter("brandUsername", str1);
      ((Uri.Builder)localObject).appendQueryParameter("kfOpenId", str3);
      ((Uri.Builder)localObject).appendQueryParameter("kfType", String.valueOf(j));
      parambk.jFL = ((Uri.Builder)localObject).build().toString();
      ae.v("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle enterPath: %s", new Object[] { parambk.jFL });
      break;
    }
    label495:
    AppMethodBeat.o(187236);
    return false;
  }
  
  public final String aXA(String paramString)
  {
    AppMethodBeat.i(35113);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://weixin.qq.com/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) && (this.cXJ.Cqh.fug()) && (this.xfE != null))
      {
        c.b localb = this.xfE.bX(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.KT())) && (paramString.contains(localb.KT())))
        {
          AppMethodBeat.o(35113);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(35113);
    return null;
  }
  
  public final void bq(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35114);
    ag.aGr().bd(fGW());
    final LinkedList localLinkedList = new LinkedList();
    List localList = this.JPa.aGE();
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
        com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131762605), null, this.cXJ.Kkd.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35114);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131762600), null, this.cXJ.Kkd.getMMResources().getString(2131762606), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35114);
      return;
    }
    paramLinkedList = this.cXJ.Kkd.getMMResources().getString(2131762599, new Object[] { br(localLinkedList) });
    com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), paramLinkedList, null, this.cXJ.Kkd.getMMResources().getString(2131762607), this.cXJ.Kkd.getMMResources().getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(35088);
        paramAnonymousDialogInterface = new ne();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < localLinkedList.size())
        {
          nd localnd = new nd();
          localnd.FZy = ((String)localLinkedList.get(paramAnonymousInt));
          paramAnonymousDialogInterface.FZz.add(localnd);
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
  
  public final void fAs()
  {
    boolean bool2 = false;
    AppMethodBeat.i(35119);
    this.Kbr = this.cXJ.Kkd.getLongExtra("key_biz_chat_id", -1L);
    this.rCv = this.cXJ.Kkd.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    if (this.rCv)
    {
      this.JPa = ag.aGr().bd(this.Kbr);
      this.JPa = com.tencent.mm.al.a.e.a(this.JPa, this.Kbr);
      this.Kbu = ag.aGs().sf(fGW()).field_unReadCount;
    }
    boolean bool1 = bool2;
    if (this.rCv)
    {
      bool1 = bool2;
      if (com.tencent.mm.al.a.e.ES(this.JPa.field_bizChatServId)) {
        bool1 = true;
      }
    }
    this.Kbq = bool1;
    if ((this.rCv) && (!this.Kbq))
    {
      this.xhi = ag.aGt().eP(this.JPa.field_bizChatServId);
      this.xhi = com.tencent.mm.al.a.e.a(this.xhi, this.JPa.field_bizChatServId);
    }
    if (this.Kbq) {
      this.Kby = com.tencent.mm.al.a.e.c(this.JPa);
    }
    this.xfE = com.tencent.mm.al.g.eX(this.cXJ.getTalkerUserName());
    this.Kbv = true;
    AppMethodBeat.o(35119);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35120);
    this.Kbo = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    if (((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() > 0) {}
    for (localObject = ((com.tencent.mm.ui.chatting.d.b.k)localObject).adI(((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() - 1);; localObject = null)
    {
      this.Kbp = ((bv)localObject);
      com.tencent.mm.storage.y.aUd(this.cXJ.getTalkerUserName());
      this.cXJ.Kkd.getLongExtra("key_biz_chat_id", -1L);
      if (this.rCv)
      {
        ae.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
        bc.ajU().n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35090);
            long l = System.currentTimeMillis();
            if ((c.this.rCv) && (c.this.JPa != null) && (c.this.cXJ.Cqh != null))
            {
              c.f(c.this);
              ag.aGC();
              com.tencent.mm.al.a.c localc = c.this.JPa;
              if (com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe))
              {
                String str = String.format("%s;%s;%d", new Object[] { localc.field_brandUserName, localc.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
                ab.b(localc.field_brandUserName, 7, "EnterpriseChatStatus", str);
                ae.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[] { str });
              }
              if (c.this.Kbq)
              {
                if (c.this.JPa.aGF())
                {
                  ag.aGx();
                  com.tencent.mm.al.a.h.bj(c.this.JPa.field_bizChatServId, c.this.cXJ.Cqh.field_username);
                }
              }
              else {
                c.g(c.this);
              }
            }
            for (;;)
            {
              ae.d("MicroMsg.ChattingUI.BizComponent", "willen test  updateBizChatInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              AppMethodBeat.o(35090);
              return;
              com.tencent.mm.al.a.e.f(c.this.JPa);
              break;
              ae.i("MicroMsg.ChattingUI.BizComponent", "bizChatInfo:%s  talker:%s", new Object[] { c.this.JPa, c.this.cXJ.Cqh });
            }
          }
        }, 500L);
      }
      if ((this.cXJ.Cqh != null) && (this.cXJ.Cqh.fug())) {
        ag.aGB().DZ(this.cXJ.Cqh.field_username);
      }
      this.ohH.alive();
      this.Kbr = this.cXJ.Kkd.getLongExtra("key_biz_chat_id", -1L);
      if ((com.tencent.mm.app.plugin.a.a.c(this.xfE)) && (this.Kbn == null))
      {
        ae.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { fGT() });
        this.Kbn = new com.tencent.mm.app.plugin.a.a(this.cXJ);
      }
      if (this.cXJ.Cqh.fug()) {
        com.tencent.mm.bg.d.chatType = 2;
      }
      if (this.rCv) {
        ag.aGr().a(this.JPM, Looper.getMainLooper());
      }
      if ((this.cXJ.Cqh != null) && (this.cXJ.Cqh.fug())) {
        ag.aGp().a(this.Kbx, Looper.getMainLooper());
      }
      AppMethodBeat.o(35120);
      return;
    }
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35121);
    if ((com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) && (this.cXJ.Cqh.fug()) && (com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) && (this.cXJ.Cqh.fug()) && (!com.tencent.mm.al.g.vz(this.cXJ.getTalkerUserName())))
    {
      int i = this.cXJ.Kkd.getIntExtra("specific_chat_from_scene", 0);
      if (this.hTl == null) {
        this.hTl = new dci();
      }
      this.hTl.HKT = this.cXJ.Kkd.getIntExtra("Main_IndexInSessionList", 0);
      this.hTl.HKR = this.cXJ.Kkd.getIntExtra("Main_UnreadCount", 0);
      if (this.Kbp != null)
      {
        this.hTl.HKS = this.Kbp.getType();
        if (this.hTl.HKR > 0) {
          this.hTl.HKQ = ((int)(this.Kbo - this.Kbp.field_createTime) / 1000);
        }
      }
      ag.aGA().a(this.cXJ.getTalkerUserName(), this.Kbp, i, this.hTl);
    }
    if (com.tencent.mm.model.x.AS(this.cXJ.getTalkerUserName())) {
      com.tencent.e.h.MqF.i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187235);
          c.h(c.this);
          AppMethodBeat.o(187235);
        }
      }, "ReportEnterNotifyMessage");
    }
    AppMethodBeat.o(35121);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35122);
    this.Kbw = true;
    bn.H("bizflag", ((ac)this.cXJ.bh(ac.class)).fIC());
    if ((this.xfE == null) || (com.tencent.mm.app.plugin.a.a.c(this.xfE)))
    {
      ae.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { fGT() });
      if (this.Kbn != null) {
        this.Kbn.a(1, this.xfE);
      }
    }
    Object localObject1 = this.xfE;
    int i;
    if ((localObject1 != null) && (localObject1 != null))
    {
      localObject1 = ((com.tencent.mm.api.c)localObject1).bX(false);
      if ((localObject1 != null) && (((c.b)localObject1).KF()))
      {
        i = 1;
        if (i != 0) {
          bc.ajU().aw(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35096);
              sh localsh = new sh();
              if (c.c(c.this) != null)
              {
                localsh.dHR.userName = c.c(c.this).field_username;
                com.tencent.mm.sdk.b.a.IvT.l(localsh);
              }
              AppMethodBeat.o(35096);
            }
          });
        }
        if ((!com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) || (!this.cXJ.Cqh.fug()) || (this.xfE == null)) {
          break label565;
        }
        localObject1 = this.xfE.bX(false);
        if ((localObject1 != null) && (((c.b)localObject1).Kr()))
        {
          if (this.xfE.field_hadAlert != 0) {
            break label549;
          }
          Object localObject2 = this.cXJ.Kkd.getContext().getResources().getString(2131757142, new Object[] { this.cXJ.Cqh.adG() });
          String str = this.cXJ.Kkd.getContext().getResources().getString(2131757143);
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
          localObject2 = new bv();
          ((bv)localObject2).ui(this.cXJ.getTalkerUserName());
          ((bv)localObject2).kt(2);
          ((bv)localObject2).setType(10002);
          ((bv)localObject2).qN(bl.aCr());
          ((bv)localObject2).setContent(((StringBuffer)localObject1).toString());
          bl.v((bv)localObject2);
          this.xfE.field_hadAlert = 1;
          ag.aGp().update(this.xfE, new String[0]);
        }
        label440:
        if ((this.xfE.Kp()) && ((!this.cXJ.Cqh.fug()) || (!com.tencent.mm.al.a.aFH())))
        {
          au.a.hIG.aJ(this.cXJ.Cqh.field_username, "");
          com.tencent.mm.aj.c.Dv(this.cXJ.Cqh.field_username);
        }
        if (this.xfE.field_status == 1)
        {
          this.xfE.field_status = 0;
          ag.aGp().g(this.xfE);
        }
      }
    }
    for (;;)
    {
      fGX();
      AppMethodBeat.o(35122);
      return;
      i = 0;
      break;
      label549:
      ag.aGA().EE(this.cXJ.getTalkerUserName());
      break label440;
      label565:
      if ((!this.cXJ.Kkd.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) && (this.cXJ.Cqh.fug())) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35097);
            if ((!com.tencent.mm.contact.c.lO(c.this.cXJ.Cqh.field_type)) && (c.this.cXJ.Cqh.fug())) {
              c.this.cXJ.Kkd.setMMSubTitle(2131757138);
            }
            AppMethodBeat.o(35097);
          }
        });
      }
    }
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35123);
    this.Kbw = false;
    if ((com.tencent.mm.contact.c.lO(this.cXJ.Cqh.field_type)) && (this.cXJ.Cqh.fug()) && (this.xfE != null))
    {
      ag.aGA().aGc();
      if (this.xhr != null) {
        this.xhr.dismiss();
      }
    }
    a.a locala = com.tencent.mm.msgsubscription.storage.a.iEd;
    ae.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clearNotifyCallback");
    com.tencent.mm.msgsubscription.storage.a.aON().clear();
    AppMethodBeat.o(35123);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35124);
    this.Kbv = false;
    ffV();
    AppMethodBeat.o(35124);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35125);
    super.fGE();
    ffV();
    AppMethodBeat.o(35125);
  }
  
  public final com.tencent.mm.api.c fGG()
  {
    return this.xfE;
  }
  
  public final com.tencent.mm.al.a.c fGH()
  {
    return this.JPa;
  }
  
  public final com.tencent.mm.al.a.k fGI()
  {
    return this.xhi;
  }
  
  public final boolean fGJ()
  {
    return this.rCv;
  }
  
  public final boolean fGK()
  {
    return this.Kbq;
  }
  
  public final boolean fGL()
  {
    AppMethodBeat.i(35102);
    if (this.rCv)
    {
      int i;
      if (this.Kbq)
      {
        i = com.tencent.mm.al.a.e.sl(fGW());
        if (bu.isNullOrNil(this.JPa.field_chatName)) {
          if (i == 0) {
            this.cXJ.Kkd.setMMTitle(this.cXJ.Kkd.getMMResources().getString(2131757293));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35102);
        return true;
        this.cXJ.Kkd.setMMTitle(this.cXJ.Kkd.getMMResources().getString(2131759496, new Object[] { this.cXJ.Kkd.getMMResources().getString(2131757293), Integer.valueOf(i) }));
        continue;
        ((com.tencent.mm.ui.chatting.d.b.y)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class)).setMMTitle(this.cXJ.Kkd.getMMResources().getString(2131759496, new Object[] { this.JPa.field_chatName, Integer.valueOf(i) }));
        continue;
        this.cXJ.Kkd.setMMTitle(this.xhi.field_userName);
      }
    }
    AppMethodBeat.o(35102);
    return false;
  }
  
  public final a fGM()
  {
    return this.JTK;
  }
  
  public final ChatFooter.g fGN()
  {
    return this.JSM;
  }
  
  public final List<bv> fGO()
  {
    int i = 100;
    AppMethodBeat.i(35104);
    Object localObject = ag.aGs().sf(fGW());
    if (((com.tencent.mm.al.a.a)localObject).field_unReadCount > 100) {}
    for (;;)
    {
      bc.aCg();
      localObject = com.tencent.mm.model.c.azJ().q(this.cXJ.Cqh.field_username, fGW(), i);
      AppMethodBeat.o(35104);
      return localObject;
      i = ((com.tencent.mm.al.a.a)localObject).field_unReadCount;
    }
  }
  
  public final boolean fGP()
  {
    return this.Kby;
  }
  
  public final void fGQ()
  {
    AppMethodBeat.i(35106);
    if (this.xfE == null)
    {
      AppMethodBeat.o(35106);
      return;
    }
    final boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.d.aIi()) && (!com.tencent.mm.modelgeo.d.aIj()))
    {
      bool = true;
      if ((this.xfE.field_hadAlert != 0) || (!bool)) {
        break label144;
      }
      str = this.cXJ.Kkd.getMMResources().getString(2131757140, new Object[] { this.cXJ.Cqh.adG() });
    }
    for (;;)
    {
      this.xhr = com.tencent.mm.ui.base.h.a(this.cXJ.Kkd.getContext(), str, this.cXJ.Kkd.getMMResources().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35098);
          c.c(c.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = c.c(c.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag |= 0x4;
            com.tencent.mm.al.g.i(paramAnonymousDialogInterface);
          }
          if (bool)
          {
            Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            paramAnonymousDialogInterface = c.this.cXJ.Kkd;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35098);
            return;
          }
          ag.aGA().EE(c.this.cXJ.getTalkerUserName());
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
            com.tencent.mm.al.g.i(paramAnonymousDialogInterface);
          }
          ag.aGA().EE(c.this.cXJ.getTalkerUserName());
          AppMethodBeat.o(35099);
        }
      });
      AppMethodBeat.o(35106);
      return;
      bool = false;
      break;
      label144:
      if (bool) {
        str = this.cXJ.Kkd.getMMResources().getString(2131757141);
      } else {
        str = this.cXJ.Kkd.getMMResources().getString(2131757139, new Object[] { this.cXJ.Cqh.adG() });
      }
    }
  }
  
  public final void fGR()
  {
    AppMethodBeat.i(35107);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.cXJ.getTalkerUserName());
    localIntent.putExtra("key_start_biz_profile_setting_from_scene", 1);
    com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "profile", ".ui.newbizinfo.NewBizInfoSettingUI", localIntent);
    AppMethodBeat.o(35107);
  }
  
  public final int fGS()
  {
    return this.Kbu;
  }
  
  public final String fGT()
  {
    if (this.rCv) {
      if (this.Kbq) {
        if (this.JPa != null) {}
      }
    }
    while (this.cXJ.Cqh == null)
    {
      do
      {
        return null;
        return this.JPa.field_chatName;
      } while (this.xhi == null);
      return this.xhi.field_userName;
    }
    return this.cXJ.Cqh.field_nickname;
  }
  
  public final boolean fGU()
  {
    AppMethodBeat.i(35109);
    Object localObject1 = new Intent(this.cXJ.Kkd.getContext(), ChatroomInfoUI.class);
    if ((this.cXJ.fJB()) || (this.Kbq)) {}
    Object localObject2;
    for (int i = 1; (i != 0) && (!this.rCv); i = 0)
    {
      ((Intent)localObject1).putExtra("Chat_User", this.cXJ.Cqh.field_username);
      ((Intent)localObject1).putExtra("RoomInfo_Id", this.cXJ.getTalkerUserName());
      ((Intent)localObject1).putExtra("Is_Chatroom", this.cXJ.fJB());
      ((Intent)localObject1).putExtra("fromChatting", true);
      localObject2 = this.cXJ;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35109);
      return true;
    }
    if (this.rCv)
    {
      ((Intent)localObject1).setClass(this.cXJ.Kkd.getContext(), BizChatroomInfoUI.class);
      ((Intent)localObject1).putExtra("Chat_User", this.cXJ.Cqh.field_username);
      ((Intent)localObject1).putExtra("key_biz_chat_id", fGW());
      if ((this.cXJ.Kkd.thisActivity() instanceof ChattingUI)) {
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        localObject2 = this.cXJ.Kkd;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((com.tencent.mm.model.x.AU(this.cXJ.getTalkerUserName())) || (an.aUn(this.cXJ.getTalkerUserName())) || (an.aUp(this.cXJ.getTalkerUserName())) || (com.tencent.mm.model.x.AQ(this.cXJ.getTalkerUserName())) || (an.Ac(this.cXJ.getTalkerUserName())) || (this.cXJ.Cqh.fug()))
    {
      localObject1 = new Intent();
      com.tencent.mm.ui.contact.e.u((Intent)localObject1, this.cXJ.getTalkerUserName());
      if (this.cXJ.Kkd.getIntExtra("chat_from_scene", 0) == 2)
      {
        ((Intent)localObject1).putExtra("Kdel_from", 2);
        ((Intent)localObject1).putExtra("chat_from_scene", this.cXJ.Kkd.getIntExtra("chat_from_scene", 0));
        ((Intent)localObject1).putExtra("preUsername", this.cXJ.getTalkerUserName());
        ((Intent)localObject1).putExtra("preChatName", this.cXJ.getTalkerUserName());
        if ((this.xfE == null) || (!this.xfE.Ks())) {
          break label833;
        }
        i = 6;
        label588:
        ((Intent)localObject1).putExtra("preChatTYPE", this.cXJ.Kkd.getIntExtra("preChatTYPE", i));
        localObject2 = this.cXJ.Kkd.getContext().getIntent();
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
      if ((((ac)this.cXJ.bh(ac.class)).fIC()) && (l.aXE(this.cXJ.getTalkerUserName())))
      {
        if (i != 16) {
          break label839;
        }
        ((Intent)localObject1).putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.cXJ.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.a.c.md(2);
          com.tencent.mm.plugin.newtips.a.dxG();
          if (com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHT))
          {
            com.tencent.mm.plugin.newtips.a.dxD();
            com.tencent.mm.plugin.newtips.a.i.Mt(com.tencent.mm.plugin.newtips.a.d.wHT);
            ((Intent)localObject1).putExtra("key_from_wesport_right_newtips", true);
          }
        }
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1, 213);
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
  
  public final boolean fGV()
  {
    AppMethodBeat.i(35110);
    if (this.cXJ == null)
    {
      ae.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
      AppMethodBeat.o(35110);
      return false;
    }
    Object localObject1;
    if ((this.cXJ.Cqh.fug()) && (this.xfE != null))
    {
      if (this.rCv)
      {
        bool = ag.aGs().sh(fGW());
        AppMethodBeat.o(35110);
        return bool;
      }
      if (!this.xfE.Kw()) {
        break label238;
      }
      if ((this.xfE.bX(false) != null) && (this.xfE.bX(false).KX() != null) && (!bu.isNullOrNil(this.xfE.KD())))
      {
        bc.aCg();
        localObject1 = com.tencent.mm.model.c.azL().aVo(this.xfE.KD());
        if ((localObject1 != null) && (((ba)localObject1).field_username.equals(this.cXJ.getTalkerUserName())) && (((ba)localObject1).field_unReadCount > 0))
        {
          if (this.cXJ.Kkd.getIntExtra("chat_from_scene", 0) == 2)
          {
            AppMethodBeat.o(35110);
            return false;
          }
          bc.aCg();
          com.tencent.mm.model.c.azL().aVc(this.xfE.KD());
        }
      }
    }
    while (com.tencent.mm.model.x.AN(this.cXJ.getTalkerUserName()))
    {
      AppMethodBeat.o(35110);
      return true;
      label238:
      if ((!this.xfE.Ks()) && (!this.xfE.Ku())) {
        if (!com.tencent.mm.storage.y.bOd())
        {
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azL().fuU();
          if ((localObject1 != null) && (((ba)localObject1).field_username.equals(this.cXJ.getTalkerUserName())) && (((ba)localObject1).field_unReadCount > 0))
          {
            bc.aCg();
            com.tencent.mm.model.c.azL().aVc("officialaccounts");
          }
        }
        else if (ag.aGv().ftr() > 0)
        {
          localObject1 = ag.aGv();
          Object localObject2 = this.cXJ.getTalkerUserName();
          localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + (String)localObject2 + "' ";
          ((com.tencent.mm.storage.x)localObject1).hKK.execSQL("BizTimeLineInfo", (String)localObject2);
          localObject2 = new x.a();
          ((x.a)localObject2).IIW = x.b.IJa;
          ((com.tencent.mm.storage.x)localObject1).a((x.a)localObject2);
        }
      }
    }
    bc.aCg();
    boolean bool = com.tencent.mm.model.c.azL().aVc(this.cXJ.getTalkerUserName());
    AppMethodBeat.o(35110);
    return bool;
  }
  
  public final long fGW()
  {
    if (this.JPa == null) {
      return -1L;
    }
    return this.JPa.field_bizChatLocalId;
  }
  
  public final void fGX()
  {
    AppMethodBeat.i(35112);
    bc.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35087);
        if (c.this.cXJ == null)
        {
          AppMethodBeat.o(35087);
          return;
        }
        boolean bool = ((com.tencent.mm.ui.chatting.d.b.k)c.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode();
        if ((c.this.rCv) && (!bool)) {
          com.tencent.mm.al.a.e.d(c.this.JPa);
        }
        AppMethodBeat.o(35087);
      }
    }, 500L);
    AppMethodBeat.o(35112);
  }
  
  public final void gH(String paramString, int paramInt)
  {
    AppMethodBeat.i(187237);
    Object localObject;
    int i;
    if ((!bu.isNullOrNil(paramString)) && (com.tencent.mm.al.g.En(paramString)))
    {
      localObject = (com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      if (((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() <= 0) {
        break label186;
      }
      localObject = ((com.tencent.mm.ui.chatting.d.b.k)localObject).adI(((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() - 1);
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
      ae.d("MicroMsg.ChattingUI.BizComponent", "alvinluo onFooterSwitchInput talker: %s, switchType: %d, lastMsgType: %d, sender: %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i), localObject });
      com.tencent.mm.plugin.report.service.g.yxI.f(20018, new Object[] { Long.valueOf(this.Kbo), paramString, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), localObject, Integer.valueOf(1) });
      AppMethodBeat.o(187237);
      return;
      label186:
      localObject = null;
      break;
      label192:
      if (((bv)localObject).getType() == 285212721)
      {
        i = 2;
        break label70;
      }
      if (((bv)localObject).getType() == 318767153)
      {
        i = 5;
        break label70;
      }
      if (!bu.isNullOrNil(((ei)localObject).fmv))
      {
        if (((ei)localObject).fmB == 1)
        {
          i = 3;
          break label70;
        }
        if (((ei)localObject).fmB == 2)
        {
          i = 4;
          break label70;
        }
      }
      i = 0;
      break label70;
      label268:
      if (!bu.isNullOrNil(((ei)localObject).fmv)) {
        localObject = ((ei)localObject).fmv;
      } else if (((ei)localObject).field_isSend == 0) {
        localObject = ((ei)localObject).field_talker;
      } else {
        localObject = v.aAC();
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
      if (this.Kbn != null)
      {
        paramIntent = this.Kbn;
        if (paramIntent.cXJ == null)
        {
          ae.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == -1)
        {
          Toast.makeText(paramIntent.cXJ.Kkd.getContext(), 2131758561, 0).show();
          ep localep = new ep();
          localep.dqN.op = 0;
          localep.dqN.userName = paramIntent.cXJ.getTalkerUserName();
          localep.dqN.context = paramIntent.cXJ.Kkd.getContext();
          com.tencent.mm.sdk.b.a.IvT.l(localep);
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == 0) {
          Toast.makeText(paramIntent.cXJ.Kkd.getContext(), 2131758560, 0).show();
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
    public abstract boolean fGZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c
 * JD-Core Version:    0.7.0.1
 */