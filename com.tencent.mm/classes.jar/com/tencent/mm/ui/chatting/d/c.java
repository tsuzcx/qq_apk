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
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.y;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.i.a;
import com.tencent.mm.al.p;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.c;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.te;
import com.tencent.mm.g.a.w;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.msgsubscription.b.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
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
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.bq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.d.class)
public class c
  extends a
  implements p, com.tencent.mm.ui.chatting.d.b.d
{
  private com.tencent.mm.api.c Bdk;
  public com.tencent.mm.al.a.k BeV;
  private com.tencent.mm.ui.widget.a.d Bfe;
  private d.a PaQ;
  public com.tencent.mm.al.a.c Pag;
  protected final ChatFooter.g PdR;
  protected final a PeP;
  private com.tencent.mm.app.plugin.a.a PmJ;
  private long PmK;
  private ca PmL;
  public boolean PmM;
  private long PmN;
  private RelativeLayout PmO;
  private TextView PmP;
  private int PmQ;
  private boolean PmR;
  private boolean PmS;
  private f.a PmT;
  private boolean PmU;
  private dvm iOA;
  private IListener pti;
  public boolean tca;
  
  public c()
  {
    AppMethodBeat.i(35100);
    this.PmK = 0L;
    this.tca = false;
    this.PmM = false;
    this.PmN = -1L;
    this.Bfe = null;
    this.iOA = null;
    this.PeP = new a()
    {
      public final boolean gPf()
      {
        AppMethodBeat.i(35086);
        if (c.a(c.this) == null)
        {
          l.a(c.this.dom.Pwc, 2131309871);
          c.a(c.this, (RelativeLayout)c.this.dom.findViewById(2131297636));
          c.a(c.this, (TextView)c.this.dom.findViewById(2131297637));
          c.b(c.this).setText(2131757281);
        }
        c.a(c.this).setVisibility(0);
        com.tencent.mm.ui.chatting.e.a.gRP().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35085);
            if ((c.a(c.this) != null) && (c.a(c.this).getVisibility() != 8)) {
              c.a(c.this).setVisibility(8);
            }
            if (c.this.dom == null)
            {
              Log.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
              AppMethodBeat.o(35085);
              return;
            }
            ((com.tencent.mm.ui.chatting.d.b.aa)c.this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).gPx();
            c.this.dom.cmy();
            AppMethodBeat.o(35085);
          }
        }, 5000L);
        AppMethodBeat.o(35086);
        return true;
      }
    };
    this.PdR = new ChatFooter.g()
    {
      public final boolean An(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(35091);
        if (c.c(c.this) == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        Object localObject = c.c(c.this).cG(false);
        if (localObject == null)
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = ((c.b)localObject).Ve();
        if ((localObject == null) || (((c.b.c)localObject).dij == null) || (((c.b.c)localObject).dij.isEmpty()))
        {
          AppMethodBeat.o(35091);
          return false;
        }
        localObject = (com.tencent.mm.al.k)((c.b.c)localObject).dij.get(0);
        try
        {
          localObject = new JSONObject(((com.tencent.mm.al.k)localObject).value);
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1083;
          localAppBrandStatObject.dCw = c.c(c.this).field_username;
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), ((JSONObject)localObject).optString("userName"), null, 0, 0, ((JSONObject)localObject).optString("pagePath"), localAppBrandStatObject, c.c(c.this).field_appId);
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
    this.PaQ = new c.11(this);
    this.PmR = false;
    this.PmS = false;
    this.PmT = new c.12(this);
    this.pti = new IListener() {};
    this.PmU = false;
    AppMethodBeat.o(35100);
  }
  
  public static boolean bC(Intent paramIntent)
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
  
  private String bM(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35115);
    if (paramLinkedList.size() <= 0)
    {
      AppMethodBeat.o(35115);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.Pag.getDisplayName((String)paramLinkedList.get(0)));
    int i = 1;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append(this.dom.Pwc.getContext().getString(2131757307)).append(this.Pag.getDisplayName((String)paramLinkedList.get(i)));
      i += 1;
    }
    paramLinkedList = localStringBuilder.toString();
    AppMethodBeat.o(35115);
    return paramLinkedList;
  }
  
  private void gPe()
  {
    AppMethodBeat.i(35116);
    if (!this.tca)
    {
      AppMethodBeat.o(35116);
      return;
    }
    ag.baq();
    com.tencent.mm.al.a.h.k(this.dom.getTalkerUserName(), this.Pag.field_bizChatServId, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(35116);
  }
  
  private void gpe()
  {
    AppMethodBeat.i(35105);
    br.I("bizflag", false);
    this.pti.dead();
    Object localObject;
    if (this.tca)
    {
      gPe();
      ag.bav();
      localObject = this.Pag;
      if (com.tencent.mm.kernel.a.qd(com.tencent.mm.kernel.g.aAf().hpS))
      {
        String str = String.format("%s;%s;%d", new Object[] { ((com.tencent.mm.al.a.c)localObject).field_brandUserName, ((com.tencent.mm.al.a.c)localObject).field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.modelsimple.ab.b(((com.tencent.mm.al.a.c)localObject).field_brandUserName, 8, "EnterpriseChatStatus", str);
        Log.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[] { str });
      }
    }
    if (this.PmK != 0L) {}
    for (int i = (int)(System.currentTimeMillis() - this.PmK) / 1000;; i = 0)
    {
      if (bg.aAc())
      {
        if (this.tca) {
          ag.baj().a(this.PaQ);
        }
        if ((this.dom.GUe != null) && (this.dom.GUe.gBM())) {
          ag.bah().a(this.PmT);
        }
        if ((com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) && (this.dom.GUe.gBM()) && (!com.tencent.mm.al.g.DQ(this.dom.getTalkerUserName())))
        {
          if ((this.Bdk != null) && (this.Bdk.UC()))
          {
            if (this.iOA == null) {
              this.iOA = new dvm();
            }
            this.iOA.MWy = i;
            this.iOA.MWC = this.dom.Pwc.getIntExtra("Main_IndexInSessionList", 0);
            this.iOA.MWA = this.dom.Pwc.getIntExtra("Main_UnreadCount", 0);
            if (this.PmL != null)
            {
              this.iOA.MWB = this.PmL.getType();
              if (this.iOA.MWA > 0) {
                this.iOA.MWz = ((int)(this.PmK - this.PmL.field_createTime) / 1000);
              }
            }
          }
          ag.bat().a(this.dom.getTalkerUserName(), this.iOA);
        }
      }
      if ((com.tencent.mm.app.plugin.a.a.d(this.Bdk)) && (this.PmJ != null))
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[] { gOZ() });
        this.PmJ.a(2, this.Bdk);
        this.dom.Pwc.setMMSubTitle(null);
      }
      if ((com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) && (this.dom.GUe.gBM()) && (i != 0))
      {
        int j = this.dom.Pwc.getIntExtra("specific_chat_from_scene", 0);
        int k = com.tencent.mm.storage.ab.getSessionId();
        com.tencent.mm.plugin.report.service.h.CyF.a(10638, new Object[] { this.dom.getTalkerUserName(), Integer.valueOf(i), Integer.valueOf(this.dom.Pwc.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.dom.Pwc.getIntExtra("biz_click_item_position", 0)), Integer.valueOf(j), Integer.valueOf(k) });
      }
      if (this.PmJ != null)
      {
        localObject = this.PmJ;
        Log.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
        if (((com.tencent.mm.app.plugin.a.a)localObject).don != null)
        {
          EventCenter.instance.removeListener(((com.tencent.mm.app.plugin.a.a)localObject).don);
          ((com.tencent.mm.app.plugin.a.a)localObject).don = null;
          if (((com.tencent.mm.app.plugin.a.a)localObject).doq != null) {
            ((com.tencent.mm.app.plugin.a.a)localObject).doq.clear();
          }
        }
        ((com.tencent.mm.app.plugin.a.a)localObject).dor = false;
        if (((com.tencent.mm.app.plugin.a.a)localObject).doo != null)
        {
          EventCenter.instance.removeListener(((com.tencent.mm.app.plugin.a.a)localObject).doo);
          ((com.tencent.mm.app.plugin.a.a)localObject).doo = null;
        }
        this.PmJ = null;
      }
      com.tencent.mm.storage.ab.bja(null);
      this.PmK = 0L;
      AppMethodBeat.o(35105);
      return;
    }
  }
  
  private boolean i(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35108);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1) && ((this.Bdk == null) || (this.Bdk.cG(false) == null) || (this.Bdk.cG(false).Ve() == null) || (this.Bdk.cG(false).Ve().dij == null) || (this.Bdk.cG(false).Ve().dij.isEmpty()))) {
      ((u)this.dom.bh(u.class)).gPO().go(null);
    }
    AppMethodBeat.o(35108);
    return false;
  }
  
  public final String NI(String paramString)
  {
    AppMethodBeat.i(35103);
    paramString = this.Pag.NC(paramString);
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
      this.dom.dismissDialog();
      if (paramInt != 0) {
        Toast.makeText(MMApplicationContext.getContext(), this.dom.Pwc.getMMResources().getString(2131764662), 0).show();
      }
    }
    AppMethodBeat.o(35111);
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.e.a parama, bq parambq)
  {
    AppMethodBeat.i(232995);
    String str2 = z.aTY();
    String str3 = parambq.userName;
    String str1;
    Object localObject;
    int j;
    if (Util.isNullOrNil(parambq.PQF))
    {
      str1 = "";
      i = parambq.iEt;
      if (com.tencent.mm.al.g.Nb(str3))
      {
        Log.d("MicroMsg.ChattingUI.BizComponent", "alvinluo reportBizAvatarClick brand: %s, username: %s, kfWorker: %s, kfType: %d", new Object[] { str3, str2, str1, Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.CyF.a(20008, new Object[] { Long.valueOf(this.PmK), str3, Integer.valueOf(1), str1, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((Util.isNullOrNil(parambq.PQF)) || (Util.isNullOrNil(parambq.userName)) || (ag.bai() == null) || (!ag.bai().sP(parambq.iEt))) {
        break label495;
      }
      localObject = ag.bai();
      str1 = parambq.userName;
      str3 = parambq.PQF;
      j = parambq.iEt;
      Log.i("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle username: %s, brandUsername: %s, kfOpenId: %s, kfType: %d", new Object[] { str2, str1, str3, Integer.valueOf(j) });
      if (((com.tencent.mm.al.i)localObject).sP(j))
      {
        parambq = ((com.tencent.mm.al.i)localObject).iOj;
        if ((Util.isNullOrNil(parambq.appId)) || (parambq.path == null)) {
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
      parambq = null;
      if ((parambq == null) || (parama.Pwc.getContext() == null)) {
        break label495;
      }
      ((r)com.tencent.mm.kernel.g.af(r.class)).a(parama.Pwc.getContext(), parambq);
      AppMethodBeat.o(232995);
      return true;
      str1 = parambq.PQF;
      break;
    }
    label333:
    parambq = new com.tencent.mm.plugin.appbrand.api.g();
    parambq.appId = ((com.tencent.mm.al.i)localObject).iOj.appId;
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (i = ((com.tencent.mm.al.i)localObject).iOj.iOo;; i = 0)
    {
      parambq.iOo = i;
      parambq.scene = 1166;
      parambq.dCw = str1;
      localObject = Uri.parse(((com.tencent.mm.al.i)localObject).iOj.path).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("username", str2);
      ((Uri.Builder)localObject).appendQueryParameter("brandUsername", str1);
      ((Uri.Builder)localObject).appendQueryParameter("kfOpenId", str3);
      ((Uri.Builder)localObject).appendQueryParameter("kfType", String.valueOf(j));
      parambq.kHw = ((Uri.Builder)localObject).build().toString();
      Log.v("MicroMsg.BizKFService", "alvinluo getKFGuideAppBrandOpenBundle enterPath: %s", new Object[] { parambq.kHw });
      break;
    }
    label495:
    AppMethodBeat.o(232995);
    return false;
  }
  
  public final long ahy()
  {
    return this.PmK;
  }
  
  public final void bL(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35114);
    ag.baj().bs(gPc());
    final LinkedList localLinkedList = new LinkedList();
    List localList = this.Pag.bax();
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
        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131764686), null, this.dom.Pwc.getMMResources().getString(2131764687), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35114);
        return;
      }
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131764681), null, this.dom.Pwc.getMMResources().getString(2131764687), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35114);
      return;
    }
    paramLinkedList = this.dom.Pwc.getMMResources().getString(2131764679, new Object[] { bM(localLinkedList) });
    com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), paramLinkedList, null, this.dom.Pwc.getMMResources().getString(2131764688), this.dom.Pwc.getMMResources().getString(2131755761), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(35088);
        paramAnonymousDialogInterface = new nw();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < localLinkedList.size())
        {
          nv localnv = new nv();
          localnv.KTu = ((String)localLinkedList.get(paramAnonymousInt));
          paramAnonymousDialogInterface.KTv.add(localnv);
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
  
  public final String bmE(String paramString)
  {
    AppMethodBeat.i(35113);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("http://" + WeChatHosts.domainString(2131761749) + "/emoticonstore/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
      if ((com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) && (this.dom.GUe.gBM()) && (this.Bdk != null))
      {
        c.b localb = this.Bdk.cG(false);
        if ((localb != null) && (!TextUtils.isEmpty(localb.Vd())) && (paramString.contains(localb.Vd())))
        {
          AppMethodBeat.o(35113);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(35113);
    return null;
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35122);
    this.PmS = true;
    br.I("bizflag", ((ae)this.dom.bh(ae.class)).gQM());
    if ((this.Bdk == null) || (com.tencent.mm.app.plugin.a.a.d(this.Bdk)))
    {
      Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[] { gOZ() });
      if (this.PmJ != null) {
        this.PmJ.a(1, this.Bdk);
      }
    }
    Object localObject1 = this.Bdk;
    int i;
    if ((localObject1 != null) && (localObject1 != null))
    {
      localObject1 = ((com.tencent.mm.api.c)localObject1).cG(false);
      if ((localObject1 != null) && (((c.b)localObject1).UP()))
      {
        i = 1;
        if (i != 0) {
          bg.aAk().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35096);
              te localte = new te();
              if (c.c(c.this) != null)
              {
                localte.dZD.userName = c.c(c.this).field_username;
                EventCenter.instance.publish(localte);
              }
              AppMethodBeat.o(35096);
            }
          });
        }
        if ((!com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) || (!this.dom.GUe.gBM()) || (this.Bdk == null)) {
          break label565;
        }
        localObject1 = this.Bdk.cG(false);
        if ((localObject1 != null) && (((c.b)localObject1).UB()))
        {
          if (this.Bdk.field_hadAlert != 0) {
            break label549;
          }
          Object localObject2 = this.dom.Pwc.getContext().getResources().getString(2131757346, new Object[] { this.dom.GUe.arJ() });
          String str = this.dom.Pwc.getContext().getResources().getString(2131757347);
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
          localObject2 = new ca();
          ((ca)localObject2).Cy(this.dom.getTalkerUserName());
          ((ca)localObject2).nv(2);
          ((ca)localObject2).setType(10002);
          ((ca)localObject2).setCreateTime(bp.aVP());
          ((ca)localObject2).setContent(((StringBuffer)localObject1).toString());
          bp.x((ca)localObject2);
          this.Bdk.field_hadAlert = 1;
          ag.bah().update(this.Bdk, new String[0]);
        }
        label440:
        if ((this.Bdk.Uz()) && ((!this.dom.GUe.gBM()) || (!com.tencent.mm.al.a.aZz())))
        {
          ay.a.iDq.aL(this.dom.GUe.field_username, "");
          com.tencent.mm.aj.c.Mf(this.dom.GUe.field_username);
        }
        if (this.Bdk.field_status == 1)
        {
          this.Bdk.field_status = 0;
          ag.bah().h(this.Bdk);
        }
      }
    }
    for (;;)
    {
      gPd();
      AppMethodBeat.o(35122);
      return;
      i = 0;
      break;
      label549:
      ag.bat().Ns(this.dom.getTalkerUserName());
      break label440;
      label565:
      if ((!this.dom.Pwc.getBooleanExtra("key_has_add_contact", false).booleanValue()) && (!com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) && (this.dom.GUe.gBM())) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(35097);
            if ((!com.tencent.mm.contact.c.oR(c.this.dom.GUe.field_type)) && (c.this.dom.GUe.gBM())) {
              c.this.dom.Pwc.setMMSubTitle(2131757342);
            }
            AppMethodBeat.o(35097);
          }
        });
      }
    }
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35123);
    this.PmS = false;
    if ((com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) && (this.dom.GUe.gBM()) && (this.Bdk != null))
    {
      ag.bat().aZU();
      if (this.Bfe != null) {
        this.Bfe.dismiss();
      }
    }
    a.a locala = com.tencent.mm.msgsubscription.b.a.jzz;
    Log.i("MicroMsg.BaseSubscribeMsgService", "alvinluo clearNotifyCallback");
    com.tencent.mm.msgsubscription.b.a.biU().clear();
    AppMethodBeat.o(35123);
  }
  
  public final void gIk()
  {
    boolean bool2 = false;
    AppMethodBeat.i(35119);
    this.PmN = this.dom.Pwc.getLongExtra("key_biz_chat_id", -1L);
    this.tca = this.dom.Pwc.getBooleanExtra("key_is_biz_chat", false).booleanValue();
    Log.i("MicroMsg.ChattingUI.BizComponent", "rawBizUserid %s %s", new Object[] { Long.valueOf(this.PmN), Boolean.valueOf(this.tca) });
    if (this.tca)
    {
      this.Pag = ag.baj().bs(this.PmN);
      this.Pag = com.tencent.mm.al.a.e.a(this.Pag, this.PmN);
      this.PmQ = ag.bak().Al(gPc()).field_unReadCount;
    }
    boolean bool1 = bool2;
    if (this.tca)
    {
      bool1 = bool2;
      if (com.tencent.mm.al.a.e.NG(this.Pag.field_bizChatServId)) {
        bool1 = true;
      }
    }
    this.PmM = bool1;
    if ((this.tca) && (!this.PmM))
    {
      this.BeV = ag.bal().fB(this.Pag.field_bizChatServId);
      this.BeV = com.tencent.mm.al.a.e.a(this.BeV, this.Pag.field_bizChatServId);
    }
    if (this.PmM) {
      this.PmU = com.tencent.mm.al.a.e.c(this.Pag);
    }
    this.Bdk = com.tencent.mm.al.g.fJ(this.dom.getTalkerUserName());
    this.PmR = true;
    AppMethodBeat.o(35119);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35120);
    this.PmK = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    if (((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() > 0) {}
    for (localObject = ((com.tencent.mm.ui.chatting.d.b.k)localObject).amt(((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() - 1);; localObject = null)
    {
      this.PmL = ((ca)localObject);
      com.tencent.mm.storage.ab.bja(this.dom.getTalkerUserName());
      this.dom.Pwc.getLongExtra("key_biz_chat_id", -1L);
      if (this.tca)
      {
        Log.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
        bg.aAk().postToWorkerDelayed(new c.8(this), 500L);
      }
      if ((this.dom.GUe != null) && (this.dom.GUe.gBM())) {
        ag.bau().MN(this.dom.GUe.field_username);
      }
      this.pti.alive();
      this.PmN = this.dom.Pwc.getLongExtra("key_biz_chat_id", -1L);
      if ((com.tencent.mm.app.plugin.a.a.d(this.Bdk)) && (this.PmJ == null))
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[] { gOZ() });
        this.PmJ = new com.tencent.mm.app.plugin.a.a(this.dom);
      }
      if (this.dom.GUe.gBM()) {
        com.tencent.mm.bg.d.chatType = 2;
      }
      if (this.tca) {
        ag.baj().a(this.PaQ, Looper.getMainLooper());
      }
      if ((this.dom.GUe != null) && (this.dom.GUe.gBM())) {
        ag.bah().a(this.PmT, Looper.getMainLooper());
      }
      AppMethodBeat.o(35120);
      return;
    }
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35121);
    if ((com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) && (this.dom.GUe.gBM()) && (com.tencent.mm.contact.c.oR(this.dom.GUe.field_type)) && (this.dom.GUe.gBM()) && (!com.tencent.mm.al.g.DQ(this.dom.getTalkerUserName())))
    {
      int i = this.dom.Pwc.getIntExtra("specific_chat_from_scene", 0);
      if (this.iOA == null) {
        this.iOA = new dvm();
      }
      this.iOA.MWC = this.dom.Pwc.getIntExtra("Main_IndexInSessionList", 0);
      this.iOA.MWA = this.dom.Pwc.getIntExtra("Main_UnreadCount", 0);
      if (this.PmL != null)
      {
        this.iOA.MWB = this.PmL.getType();
        if (this.iOA.MWA > 0) {
          this.iOA.MWz = ((int)(this.PmK - this.PmL.field_createTime) / 1000);
        }
      }
      ag.bat().a(this.dom.getTalkerUserName(), this.PmL, i, this.iOA);
    }
    if (com.tencent.mm.model.ab.Jx(this.dom.getTalkerUserName())) {
      com.tencent.f.h.RTc.e(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232994);
          c.h(c.this);
          AppMethodBeat.o(232994);
        }
      }, "ReportEnterNotifyMessage");
    }
    AppMethodBeat.o(35121);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35124);
    this.PmR = false;
    gpe();
    AppMethodBeat.o(35124);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35125);
    super.gOK();
    gpe();
    AppMethodBeat.o(35125);
  }
  
  public final com.tencent.mm.api.c gOM()
  {
    return this.Bdk;
  }
  
  public final com.tencent.mm.al.a.c gON()
  {
    return this.Pag;
  }
  
  public final com.tencent.mm.al.a.k gOO()
  {
    return this.BeV;
  }
  
  public final boolean gOP()
  {
    return this.tca;
  }
  
  public final boolean gOQ()
  {
    return this.PmM;
  }
  
  public final boolean gOR()
  {
    AppMethodBeat.i(35102);
    if (this.tca)
    {
      int i;
      if (this.PmM)
      {
        i = com.tencent.mm.al.a.e.Ar(gPc());
        if (Util.isNullOrNil(this.Pag.field_chatName)) {
          if (i == 0) {
            this.dom.Pwc.setMMTitle(this.dom.Pwc.getMMResources().getString(2131757507));
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35102);
        return true;
        this.dom.Pwc.setMMTitle(this.dom.Pwc.getMMResources().getString(2131760811, new Object[] { this.dom.Pwc.getMMResources().getString(2131757507), Integer.valueOf(i) }));
        continue;
        ((com.tencent.mm.ui.chatting.d.b.aa)this.dom.bh(com.tencent.mm.ui.chatting.d.b.aa.class)).setMMTitle(this.dom.Pwc.getMMResources().getString(2131760811, new Object[] { this.Pag.field_chatName, Integer.valueOf(i) }));
        continue;
        this.dom.Pwc.setMMTitle(this.BeV.field_userName);
      }
    }
    AppMethodBeat.o(35102);
    return false;
  }
  
  public final a gOS()
  {
    return this.PeP;
  }
  
  public final ChatFooter.g gOT()
  {
    return this.PdR;
  }
  
  public final List<ca> gOU()
  {
    int i = 100;
    AppMethodBeat.i(35104);
    Object localObject = ag.bak().Al(gPc());
    if (((com.tencent.mm.al.a.a)localObject).field_unReadCount > 100) {}
    for (;;)
    {
      bg.aVF();
      localObject = com.tencent.mm.model.c.aSR().s(this.dom.GUe.field_username, gPc(), i);
      AppMethodBeat.o(35104);
      return localObject;
      i = ((com.tencent.mm.al.a.a)localObject).field_unReadCount;
    }
  }
  
  public final boolean gOV()
  {
    return this.PmU;
  }
  
  public final void gOW()
  {
    AppMethodBeat.i(35106);
    if (this.Bdk == null)
    {
      AppMethodBeat.o(35106);
      return;
    }
    final boolean bool;
    String str;
    if ((!com.tencent.mm.modelgeo.d.bcc()) && (!com.tencent.mm.modelgeo.d.bcd()))
    {
      bool = true;
      if ((this.Bdk.field_hadAlert != 0) || (!bool)) {
        break label144;
      }
      str = this.dom.Pwc.getMMResources().getString(2131757344, new Object[] { this.dom.GUe.arJ() });
    }
    for (;;)
    {
      this.Bfe = com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), str, this.dom.Pwc.getMMResources().getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35098);
          c.c(c.this).field_hadAlert = 1;
          paramAnonymousDialogInterface = c.c(c.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.field_brandFlag |= 0x4;
            com.tencent.mm.al.g.j(paramAnonymousDialogInterface);
          }
          if (bool)
          {
            Object localObject = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            paramAnonymousDialogInterface = c.this.dom.Pwc;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/component/BizComponent$8", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35098);
            return;
          }
          ag.bat().Ns(c.this.dom.getTalkerUserName());
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
            com.tencent.mm.al.g.j(paramAnonymousDialogInterface);
          }
          ag.bat().Ns(c.this.dom.getTalkerUserName());
          AppMethodBeat.o(35099);
        }
      });
      AppMethodBeat.o(35106);
      return;
      bool = false;
      break;
      label144:
      if (bool) {
        str = this.dom.Pwc.getMMResources().getString(2131757345);
      } else {
        str = this.dom.Pwc.getMMResources().getString(2131757343, new Object[] { this.dom.GUe.arJ() });
      }
    }
  }
  
  public final void gOX()
  {
    AppMethodBeat.i(35107);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.dom.getTalkerUserName());
    localIntent.putExtra("key_start_biz_profile_setting_from_scene", 1);
    com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "profile", ".ui.newbizinfo.NewBizInfoSettingUI", localIntent);
    AppMethodBeat.o(35107);
  }
  
  public final int gOY()
  {
    return this.PmQ;
  }
  
  public final String gOZ()
  {
    if (this.tca) {
      if (this.PmM) {
        if (this.Pag != null) {}
      }
    }
    while (this.dom.GUe == null)
    {
      do
      {
        return null;
        return this.Pag.field_chatName;
      } while (this.BeV == null);
      return this.BeV.field_userName;
    }
    return this.dom.GUe.field_nickname;
  }
  
  public final boolean gPa()
  {
    AppMethodBeat.i(35109);
    Object localObject1 = new Intent(this.dom.Pwc.getContext(), ChatroomInfoUI.class);
    if ((this.dom.gRL()) || (this.PmM)) {}
    Object localObject2;
    for (int i = 1; (i != 0) && (!this.tca); i = 0)
    {
      ((Intent)localObject1).putExtra("Chat_User", this.dom.GUe.field_username);
      ((Intent)localObject1).putExtra("RoomInfo_Id", this.dom.getTalkerUserName());
      ((Intent)localObject1).putExtra("Is_Chatroom", this.dom.gRL());
      ((Intent)localObject1).putExtra("fromChatting", true);
      localObject2 = this.dom;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((com.tencent.mm.ui.chatting.e.a)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35109);
      return true;
    }
    if (this.tca)
    {
      ((Intent)localObject1).setClass(this.dom.Pwc.getContext(), BizChatroomInfoUI.class);
      ((Intent)localObject1).putExtra("Chat_User", this.dom.GUe.field_username);
      ((Intent)localObject1).putExtra("key_biz_chat_id", gPc());
      if ((this.dom.Pwc.thisActivity() instanceof ChattingUI)) {
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 1);
      }
      for (;;)
      {
        localObject2 = this.dom.Pwc;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/component/BizComponent", "doRightBtnClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35109);
        return true;
        ((Intent)localObject1).putExtra("key_biz_chat_info_from_scene", 2);
      }
    }
    if ((com.tencent.mm.model.ab.Jz(this.dom.getTalkerUserName())) || (as.bjm(this.dom.getTalkerUserName())) || (as.bjo(this.dom.getTalkerUserName())) || (com.tencent.mm.model.ab.Jv(this.dom.getTalkerUserName())) || (as.IG(this.dom.getTalkerUserName())) || (this.dom.GUe.gBM()))
    {
      localObject1 = new Intent();
      com.tencent.mm.ui.contact.e.s((Intent)localObject1, this.dom.getTalkerUserName());
      if (this.dom.Pwc.getIntExtra("chat_from_scene", 0) == 2)
      {
        ((Intent)localObject1).putExtra("Kdel_from", 2);
        ((Intent)localObject1).putExtra("chat_from_scene", this.dom.Pwc.getIntExtra("chat_from_scene", 0));
        ((Intent)localObject1).putExtra("preUsername", this.dom.getTalkerUserName());
        ((Intent)localObject1).putExtra("preChatName", this.dom.getTalkerUserName());
        if ((this.Bdk == null) || (!this.Bdk.UC())) {
          break label830;
        }
        i = 6;
        label585:
        ((Intent)localObject1).putExtra("preChatTYPE", this.dom.Pwc.getIntExtra("preChatTYPE", i));
        localObject2 = this.dom.Pwc.getContext().getIntent();
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
      if ((((ae)this.dom.bh(ae.class)).gQM()) && (l.bmI(this.dom.getTalkerUserName())))
      {
        if (i != 16) {
          break label836;
        }
        ((Intent)localObject1).putExtra("Contact_Scene", 92);
      }
      for (;;)
      {
        if (this.dom.getTalkerUserName().equals("gh_43f2581f6fd6"))
        {
          com.tencent.mm.plugin.sport.a.c.pl(2);
          com.tencent.mm.plugin.newtips.a.exo();
          if (com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADd))
          {
            com.tencent.mm.plugin.newtips.a.exl();
            com.tencent.mm.plugin.newtips.a.i.TA(com.tencent.mm.plugin.newtips.a.d.ADd);
            ((Intent)localObject1).putExtra("key_from_wesport_right_newtips", true);
          }
        }
        ((Intent)localObject1).putExtra("KOpenArticleSceneFromScene", 0);
        com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject1, 213);
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
  
  public final boolean gPb()
  {
    AppMethodBeat.i(35110);
    if (this.dom == null)
    {
      Log.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
      AppMethodBeat.o(35110);
      return false;
    }
    Object localObject1;
    if ((this.dom.GUe.gBM()) && (this.Bdk != null))
    {
      if (this.tca)
      {
        bool = ag.bak().An(gPc());
        AppMethodBeat.o(35110);
        return bool;
      }
      if (!this.Bdk.UG()) {
        break label238;
      }
      if ((this.Bdk.cG(false) != null) && (this.Bdk.cG(false).Vh() != null) && (!Util.isNullOrNil(this.Bdk.UN())))
      {
        bg.aVF();
        localObject1 = com.tencent.mm.model.c.aST().bkm(this.Bdk.UN());
        if ((localObject1 != null) && (((bb)localObject1).field_username.equals(this.dom.getTalkerUserName())) && (((bb)localObject1).field_unReadCount > 0))
        {
          if (this.dom.Pwc.getIntExtra("chat_from_scene", 0) == 2)
          {
            AppMethodBeat.o(35110);
            return false;
          }
          bg.aVF();
          com.tencent.mm.model.c.aST().bka(this.Bdk.UN());
        }
      }
    }
    while (com.tencent.mm.model.ab.Js(this.dom.getTalkerUserName()))
    {
      AppMethodBeat.o(35110);
      return true;
      label238:
      if ((!this.Bdk.UC()) && (!this.Bdk.UE())) {
        if (!com.tencent.mm.storage.ab.clc())
        {
          bg.aVF();
          localObject1 = com.tencent.mm.model.c.aST().gCB();
          if ((localObject1 != null) && (((bb)localObject1).field_username.equals(this.dom.getTalkerUserName())) && (((bb)localObject1).field_unReadCount > 0))
          {
            bg.aVF();
            com.tencent.mm.model.c.aST().bka("officialaccounts");
          }
        }
        else if (ag.ban().gAR() > 0)
        {
          localObject1 = ag.ban();
          Object localObject2 = this.dom.getTalkerUserName();
          localObject2 = "update BizTimeLineInfo set hasShow = 1 where hasShow < 1  and talker = '" + (String)localObject2 + "' ";
          ((com.tencent.mm.storage.aa)localObject1).iFy.execSQL("BizTimeLineInfo", (String)localObject2);
          localObject2 = new aa.a();
          ((aa.a)localObject2).NQE = aa.b.NQI;
          ((com.tencent.mm.storage.aa)localObject1).a((aa.a)localObject2);
        }
      }
    }
    bg.aVF();
    boolean bool = com.tencent.mm.model.c.aST().bka(this.dom.getTalkerUserName());
    AppMethodBeat.o(35110);
    return bool;
  }
  
  public final long gPc()
  {
    if (this.Pag == null) {
      return -1L;
    }
    return this.Pag.field_bizChatLocalId;
  }
  
  public final void gPd()
  {
    AppMethodBeat.i(35112);
    bg.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35087);
        if (c.this.dom == null)
        {
          AppMethodBeat.o(35087);
          return;
        }
        boolean bool = ((com.tencent.mm.ui.chatting.d.b.k)c.this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode();
        if ((c.this.tca) && (!bool)) {
          com.tencent.mm.al.a.e.d(c.this.Pag);
        }
        AppMethodBeat.o(35087);
      }
    }, 500L);
    AppMethodBeat.o(35112);
  }
  
  public final void ha(String paramString, int paramInt)
  {
    AppMethodBeat.i(232996);
    Object localObject;
    int i;
    if ((!Util.isNullOrNil(paramString)) && (com.tencent.mm.al.g.Nb(paramString)))
    {
      localObject = (com.tencent.mm.ui.chatting.d.b.k)this.dom.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      if (((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() <= 0) {
        break label186;
      }
      localObject = ((com.tencent.mm.ui.chatting.d.b.k)localObject).amt(((com.tencent.mm.ui.chatting.d.b.k)localObject).getCount() - 1);
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
      com.tencent.mm.plugin.report.service.h.CyF.a(20018, new Object[] { Long.valueOf(this.PmK), paramString, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), localObject, Integer.valueOf(1) });
      AppMethodBeat.o(232996);
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
      if (!Util.isNullOrNil(((eo)localObject).fQZ))
      {
        if (((eo)localObject).fRf == 1)
        {
          i = 3;
          break label70;
        }
        if (((eo)localObject).fRf == 2)
        {
          i = 4;
          break label70;
        }
      }
      i = 0;
      break label70;
      label268:
      if (!Util.isNullOrNil(((eo)localObject).fQZ)) {
        localObject = ((eo)localObject).fQZ;
      } else if (((eo)localObject).field_isSend == 0) {
        localObject = ((eo)localObject).field_talker;
      } else {
        localObject = z.aTY();
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
      if (this.PmJ != null)
      {
        paramIntent = this.PmJ;
        if (paramIntent.dom == null)
        {
          Log.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == -1)
        {
          Toast.makeText(paramIntent.dom.Pwc.getContext(), 2131758862, 0).show();
          es locales = new es();
          locales.dIa.op = 0;
          locales.dIa.userName = paramIntent.dom.getTalkerUserName();
          locales.dIa.context = paramIntent.dom.Pwc.getContext();
          EventCenter.instance.publish(locales);
          AppMethodBeat.o(35118);
          return;
        }
        if (paramInt2 == 0) {
          Toast.makeText(paramIntent.dom.Pwc.getContext(), 2131758861, 0).show();
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
  
  public static abstract interface a
  {
    public abstract boolean gPf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c
 * JD-Core Version:    0.7.0.1
 */