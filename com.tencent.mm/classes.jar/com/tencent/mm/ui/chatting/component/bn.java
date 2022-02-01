package com.tencent.mm.ui.chatting.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.multitalk.model.d.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.LiveTalkRoomTipsBar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.a;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ae;
import com.tencent.mm.ui.chatting.component.api.ap;
import com.tencent.mm.ui.chatting.component.api.ba;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.u.a;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ba.class)
public class bn
  extends a
  implements com.tencent.mm.bc.a, com.tencent.mm.bd.c, d.a, ba, u.a
{
  public LiveTalkRoomTipsBar adDg;
  private final MStorage.IOnStorageChange aepz;
  public MultiTalkRoomPopupNav aexA;
  private View aexB;
  private TalkRoomPopupNav.a aexC;
  public TalkRoomPopupNav aexz;
  private IListener xeK;
  
  public bn()
  {
    AppMethodBeat.i(35663);
    this.aepz = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35650);
        Log.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify ".concat(String.valueOf(paramAnonymousString)));
        if (!Util.isNullOrNil(paramAnonymousString)) {
          bn.a(bn.this);
        }
        AppMethodBeat.o(35650);
      }
    };
    this.xeK = new TrackRoomComponent.2(this, com.tencent.mm.app.f.hfK);
    this.aexC = new TalkRoomPopupNav.a()
    {
      public final void aBb(String paramAnonymousString)
      {
        AppMethodBeat.i(256417);
        if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
        {
          if ((com.tencent.mm.pluginsdk.permission.b.s(bn.this.hlc.aezO.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.s(bn.this.hlc.aezO.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label258;
            }
            if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue()) {
              break;
            }
            com.tencent.mm.plugin.account.sdk.c.a.b(bn.this.hlc.aezO.getContext(), bn.this.hlc.aezO.getMMResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30762, true);
            AppMethodBeat.o(256417);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.a(bn.this.hlc.aezO.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68);
          AppMethodBeat.o(256417);
          return;
        }
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(bn.this.hlc.aezO.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68, null);
        Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(256417);
          return;
        }
        label258:
        bn.this.bAT(paramAnonymousString);
        AppMethodBeat.o(256417);
      }
      
      public final void jnc()
      {
        AppMethodBeat.i(35657);
        if ((com.tencent.mm.n.a.dm(bn.this.hlc.aezO.getContext())) || (com.tencent.mm.n.a.dl(bn.this.hlc.aezO.getContext())) || (com.tencent.mm.n.a.dp(bn.this.hlc.aezO.getContext())))
        {
          Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
          AppMethodBeat.o(35657);
          return;
        }
        Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[] { Integer.valueOf(com.tencent.mm.bd.d.oXN.Px(bn.this.hlc.Uxa.field_username).size()) });
        if (com.tencent.mm.bd.d.oXN.Py(bn.this.hlc.Uxa.field_username))
        {
          bn.b(bn.this);
          AppMethodBeat.o(35657);
          return;
        }
        bn.this.Mc(true);
        AppMethodBeat.o(35657);
      }
    };
    AppMethodBeat.o(35663);
  }
  
  private void Mb(boolean paramBoolean)
  {
    AppMethodBeat.i(35673);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[tomys] FOR_DEBUG checkTalkroomBanner, isResume: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.hlc == null)
    {
      Log.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(35673);
      return;
    }
    if ((((com.tencent.mm.ui.chatting.component.api.g)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.g.class)).jrq()) || (((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jrc())) {}
    for (boolean bool = true; (au.bwE(this.hlc.getTalkerUserName())) && (!bool); bool = false)
    {
      if (this.aexz != null)
      {
        this.aexz.setVisibility(8);
        this.aexz.jnb();
        ((ae)this.hlc.cm(ae.class)).aCf(-1);
      }
      if (this.aexA != null)
      {
        this.aexA.setInChatRoom(false);
        this.aexA.setVisibility(8);
      }
      if (this.adDg != null)
      {
        this.adDg.setInChatRoom(false);
        this.adDg.setVisibility(8);
        if (this.aexB != null) {
          this.aexB.setVisibility(8);
        }
        this.hlc.aezO.getController().showActionbarLine();
        ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().Gx(this.hlc.getTalkerUserName());
        ((ae)this.hlc.cm(ae.class)).aCf(-1);
      }
      AppMethodBeat.o(35673);
      return;
    }
    jtN();
    if (((ap)this.hlc.cm(ap.class)).jtm())
    {
      Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "isRecordSelect");
      AppMethodBeat.o(35673);
      return;
    }
    jtO();
    LinkedList localLinkedList;
    Object localObject;
    if ((com.tencent.mm.bd.d.oXN != null) && (com.tencent.mm.bd.d.oXN.Py(this.hlc.Uxa.field_username)))
    {
      a(this.aexC);
      if (this.aexz == null)
      {
        AppMethodBeat.o(35673);
        return;
      }
      localLinkedList = com.tencent.mm.bd.d.oXN.Px(this.hlc.Uxa.field_username);
      localObject = "";
      if ((localLinkedList != null) && (localLinkedList.contains(this.hlc.getSelfUserName())))
      {
        this.aexz.setBgViewResource(R.g.tipsbar_small_white_bg);
        localObject = this.hlc.aezO.getMMResources().getString(R.l.gXs);
        this.aexz.updateView();
        this.aexz.nj(localLinkedList);
        this.aexz.setVisibility(0);
        this.aexz.setNavContent((String)localObject);
        ((ae)this.hlc.cm(ae.class)).aCf(1);
        AppMethodBeat.o(35673);
        return;
      }
      this.aexz.jna();
      this.aexz.stop();
      this.aexz.setBgViewResource(R.g.tipsbar_small_white_bg);
      if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
        localObject = this.hlc.aezO.getMMResources().getString(R.l.gXr, new Object[] { aa.getDisplayName((String)localLinkedList.get(0)) });
      }
      for (;;)
      {
        this.aexz.om(R.k.icons_filled_location, this.hlc.aezO.getMMResources().getColor(R.e.Brand));
        break;
        if (localLinkedList != null) {
          localObject = this.hlc.aezO.getMMResources().getString(R.l.gXt, new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
      }
    }
    if ((com.tencent.mm.bc.g.oXL == null) || (!com.tencent.mm.bc.g.oXL.Pv(this.hlc.getTalkerUserName())))
    {
      if (au.bwE(this.hlc.getTalkerUserName()))
      {
        localObject = ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMP(this.hlc.getTalkerUserName());
        if ((localObject != null) && (((com.tencent.mm.bc.f)localObject).field_wxGroupId != null) && (((com.tencent.mm.bc.f)localObject).field_wxGroupId.equals(this.hlc.getTalkerUserName())))
        {
          jtL();
          if (this.aexA != null)
          {
            Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
            this.aexA.setGroupUserName(this.hlc.getTalkerUserName());
            this.aexA.setCurrentSenderUserName(this.hlc.getSelfUserName());
            this.aexA.setInChatRoom(bool);
            this.aexA.Lp(paramBoolean);
            this.aexA.setMultiTalkInfo((com.tencent.mm.bc.f)localObject);
            ((ae)this.hlc.cm(ae.class)).aCf(1);
            AppMethodBeat.o(35673);
          }
        }
        else
        {
          localObject = this.hlc.getTalkerUserName();
          localLinkedList = u.bzK((String)localObject);
          jtM();
          if ((localLinkedList != null) && (localLinkedList.size() > 0) && (this.adDg != null))
          {
            Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "show liveTalkRoomTipsBar, hostRoomId:%s, size:%d", new Object[] { localObject, Integer.valueOf(localLinkedList.size()) });
            this.hlc.aezO.getController().hideActionbarLine();
            this.adDg.setInChatRoom(bool);
            this.adDg.setChattingContext(this.hlc);
            this.adDg.jjC();
            this.adDg.jjE();
            ((ae)this.hlc.cm(ae.class)).aCf(1);
          }
        }
        AppMethodBeat.o(35673);
        return;
      }
      jtN();
    }
    AppMethodBeat.o(35673);
  }
  
  private void a(TalkRoomPopupNav.a parama)
  {
    AppMethodBeat.i(35671);
    if (this.aexz == null)
    {
      n.c(this.hlc.aezO, R.h.gcm);
      this.aexz = ((TalkRoomPopupNav)this.hlc.findViewById(R.h.fYM));
      this.aexB = this.hlc.findViewById(R.h.gab);
      this.aexz.setRootTipsBarBackground(this.aexB);
      this.aexz.setChattingContext(this.hlc);
      if (this.aexz == null)
      {
        AppMethodBeat.o(35671);
        return;
      }
    }
    if (this.aexz != null) {
      this.aexz.setOnClickListener(parama);
    }
    AppMethodBeat.o(35671);
  }
  
  private void bAU(String paramString)
  {
    AppMethodBeat.i(35679);
    Intent localIntent = new Intent();
    localIntent.putExtra("enter_room_username", paramString);
    localIntent.setFlags(268435456);
    com.tencent.mm.br.c.b(this.hlc.aezO.getContext(), "talkroom", ".ui.TalkRoomUI", localIntent);
    AppMethodBeat.o(35679);
  }
  
  private void jtL()
  {
    AppMethodBeat.i(35672);
    if (this.aexA == null)
    {
      this.aexB = this.hlc.findViewById(R.h.gab);
      n.c(this.hlc.aezO, R.h.gck);
      this.aexA = ((MultiTalkRoomPopupNav)this.hlc.findViewById(R.h.fOR));
      this.aexA.setRootTipsBarBackground(this.aexB);
      this.aexA.setChattingContext(this.hlc);
    }
    AppMethodBeat.o(35672);
  }
  
  private void jtM()
  {
    AppMethodBeat.i(256409);
    if (this.adDg == null)
    {
      this.aexB = this.hlc.findViewById(R.h.gab);
      n.c(this.hlc.aezO, R.h.gcj);
      this.adDg = ((LiveTalkRoomTipsBar)this.hlc.findViewById(R.h.fMY));
      LiveTalkRoomTipsBar localLiveTalkRoomTipsBar = this.adDg;
      if (localLiveTalkRoomTipsBar.adCT == null) {
        localLiveTalkRoomTipsBar.adCT = new u(localLiveTalkRoomTipsBar);
      }
      localLiveTalkRoomTipsBar.jjB();
      if (localLiveTalkRoomTipsBar.adCZ != null) {
        localLiveTalkRoomTipsBar.adCZ.setAdapter(localLiveTalkRoomTipsBar.adCT.adDi);
      }
      this.adDg.setRootTipsBarBackground(this.aexB);
      this.adDg.setChattingUserName(this.hlc.getTalkerUserName());
      AppMethodBeat.o(256409);
      return;
    }
    this.adDg.jjB();
    AppMethodBeat.o(256409);
  }
  
  private void jtN()
  {
    AppMethodBeat.i(35674);
    if (this.aexz != null)
    {
      this.aexz.setVisibility(8);
      this.aexz.jnb();
      this.aexz.jna();
      this.aexz.stop();
      ((ae)this.hlc.cm(ae.class)).aCf(-1);
    }
    if (this.aexA != null)
    {
      if (!((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMO(this.hlc.getTalkerUserName())) {
        this.aexA.jkA();
      }
      this.aexA.setVisibility(8);
      ((ae)this.hlc.cm(ae.class)).aCf(-1);
    }
    if (this.adDg != null)
    {
      this.adDg.setVisibility(8);
      this.adDg.jjF();
      if (this.aexB != null) {
        this.aexB.setVisibility(8);
      }
      this.hlc.aezO.getController().showActionbarLine();
      if ((this.aexz == null) && (this.aexA == null)) {
        ((ae)this.hlc.cm(ae.class)).aCf(-1);
      }
    }
    AppMethodBeat.o(35674);
  }
  
  private void jtO()
  {
    AppMethodBeat.i(256419);
    if (this.adDg != null) {
      this.adDg.setChattingUserName(this.hlc.getTalkerUserName());
    }
    AppMethodBeat.o(256419);
  }
  
  private void jtP()
  {
    AppMethodBeat.i(35676);
    el("fromBanner", false);
    AppMethodBeat.o(35676);
  }
  
  public final void Mc(final boolean paramBoolean)
  {
    AppMethodBeat.i(35675);
    if ((((com.tencent.mm.ui.chatting.component.api.g)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.g.class)).jrq()) || (((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jrc())) {}
    for (int i = 1; (au.bwE(this.hlc.getTalkerUserName())) && (i == 0); i = 0)
    {
      k.c(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gWP), null, true);
      AppMethodBeat.o(35675);
      return;
    }
    Object localObject = new aaq();
    ((aaq)localObject).ieg.iei = true;
    ((aaq)localObject).publish();
    if (!paramBoolean)
    {
      if ((com.tencent.mm.bd.d.oXN != null) && (com.tencent.mm.bd.d.oXN.Py(this.hlc.Uxa.field_username)))
      {
        localObject = com.tencent.mm.bd.d.oXN.Px(this.hlc.Uxa.field_username);
        if ((localObject != null) && (((List)localObject).contains(this.hlc.getSelfUserName()))) {
          localObject = this.hlc.aezO.getMMResources().getString(R.l.gWK);
        }
        for (i = R.l.gFp;; i = R.l.gMa)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          e.a locala = new e.a(this.hlc.aezO.getContext());
          locala.bDw((String)localObject);
          locala.aER(R.l.app_cancel).c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35659);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(35659);
            }
          });
          locala.aES(i).d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35660);
              bn localbn = bn.this;
              if (paramBoolean) {}
              for (paramAnonymousDialogInterface = "fromBanner";; paramAnonymousDialogInterface = "fromPluginTalk")
              {
                localbn.bAT(paramAnonymousDialogInterface);
                AppMethodBeat.o(35660);
                return;
              }
            }
          });
          locala.jHH().show();
          AppMethodBeat.o(35675);
          return;
          localObject = this.hlc.aezO.getMMResources().getString(R.l.gWL);
        }
      }
      if ((!Util.isNullOrNil(((aaq)localObject).ieh.iek)) && (!this.hlc.getTalkerUserName().equals(((aaq)localObject).ieh.iek)))
      {
        k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gWG), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35661);
            paramAnonymousDialogInterface = new aaq();
            paramAnonymousDialogInterface.ieg.iej = true;
            paramAnonymousDialogInterface.publish();
            bn.a(bn.this, bn.this.hlc.getTalkerUserName());
            AppMethodBeat.o(35661);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35662);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(35662);
          }
        });
        AppMethodBeat.o(35675);
        return;
      }
      bAU(this.hlc.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((Util.isNullOrNil(((aaq)localObject).ieh.iek)) || (this.hlc.getTalkerUserName().equals(((aaq)localObject).ieh.iek)))
    {
      bAU(this.hlc.getTalkerUserName());
      AppMethodBeat.o(35675);
      return;
    }
    if ((this.aexz == null) || (this.aexz.getVisibility() != 0)) {
      k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gWG), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35651);
          paramAnonymousDialogInterface = new aaq();
          paramAnonymousDialogInterface.ieg.iej = true;
          paramAnonymousDialogInterface.publish();
          bn.a(bn.this, bn.this.hlc.getTalkerUserName());
          AppMethodBeat.o(35651);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35652);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(35652);
        }
      });
    }
    AppMethodBeat.o(35675);
  }
  
  public final void Pz(String paramString)
  {
    AppMethodBeat.i(35669);
    if ((this.hlc != null) && (paramString.equals(this.hlc.getTalkerUserName()))) {
      Mb(false);
    }
    AppMethodBeat.o(35669);
  }
  
  public final void aMY(String paramString)
  {
    AppMethodBeat.i(35670);
    if ((this.hlc != null) && (paramString.equals(this.hlc.getTalkerUserName()))) {
      Mb(false);
    }
    AppMethodBeat.o(35670);
  }
  
  public final void bAT(String paramString)
  {
    AppMethodBeat.i(35678);
    Intent localIntent = new Intent();
    localIntent.putExtra("map_view_type", 6);
    localIntent.putExtra("map_sender_name", this.hlc.getSelfUserName());
    localIntent.putExtra("map_talker_name", this.hlc.getTalkerUserName());
    localIntent.putExtra("fromWhereShare", paramString);
    com.tencent.mm.br.c.b(this.hlc.aezO.getContext(), "location", ".ui.RedirectUI", localIntent);
    AppMethodBeat.o(35678);
  }
  
  public final void ba(final Runnable paramRunnable)
  {
    AppMethodBeat.i(35667);
    if ((com.tencent.mm.bd.d.oXN != null) && (com.tencent.mm.bd.d.oXN.bQ(this.hlc.Uxa.field_username, this.hlc.getSelfUserName())))
    {
      k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.track_leave_chattingui), this.hlc.aezO.getMMResources().getString(R.l.app_tip), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35656);
          paramRunnable.run();
          paramAnonymousDialogInterface = new gg();
          paramAnonymousDialogInterface.hGt.username = bn.this.hlc.getTalkerUserName();
          paramAnonymousDialogInterface.publish();
          AppMethodBeat.o(35656);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(35667);
      return;
    }
    Object localObject;
    if (this.aexz != null)
    {
      localObject = this.aexz;
      if (((TalkRoomPopupNav)localObject).adWW.getVisibility() == 0)
      {
        ((TalkRoomPopupNav)localObject).Lo(false);
        ((TalkRoomPopupNav)localObject).adWW.setVisibility(8);
      }
    }
    if (this.aexA != null)
    {
      localObject = this.aexA;
      if ((((MultiTalkRoomPopupNav)localObject).adIn != null) && (((MultiTalkRoomPopupNav)localObject).adIn.adIw != null) && (((MultiTalkRoomPopupNav)localObject).adIn.adIw.getVisibility() == 0))
      {
        ((MultiTalkRoomPopupNav)localObject).adIn.close();
        ((MultiTalkRoomPopupNav)localObject).adIn.adIw.setVisibility(8);
      }
    }
    if (this.adDg != null)
    {
      localObject = this.adDg;
      if (((LiveTalkRoomTipsBar)localObject).adCU.getVisibility() == 0)
      {
        ((LiveTalkRoomTipsBar)localObject).bK(true, false);
        ((LiveTalkRoomTipsBar)localObject).adCU.setVisibility(8);
      }
    }
    paramRunnable.run();
    AppMethodBeat.o(35667);
  }
  
  public final void bzL(String paramString)
  {
    AppMethodBeat.i(256470);
    if ((this.hlc != null) && (paramString.equals(this.hlc.getTalkerUserName()))) {
      Mb(false);
    }
    AppMethodBeat.o(256470);
  }
  
  public final void el(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(35677);
    if ((com.tencent.mm.n.a.dm(this.hlc.aezO.getContext())) || (com.tencent.mm.n.a.dl(this.hlc.aezO.getContext())) || (com.tencent.mm.n.a.dp(this.hlc.aezO.getContext())))
    {
      Log.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
      AppMethodBeat.o(35677);
      return;
    }
    if (((com.tencent.mm.bd.d.oXN != null) && (com.tencent.mm.bd.d.oXN.Py(this.hlc.Uxa.field_username))) || (paramBoolean))
    {
      LinkedList localLinkedList = com.tencent.mm.bd.d.oXN.Px(this.hlc.Uxa.field_username);
      if ((localLinkedList == null) || (!localLinkedList.contains(this.hlc.getSelfUserName())))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        if (this.aexz == null)
        {
          Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "talkRoomPopupNav = null.");
          AppMethodBeat.o(35677);
          return;
        }
        this.aexz.setDialogContent(this.hlc.aezO.getMMResources().getString(R.l.gFq));
        this.aexz.U(paramString, localLinkedList);
        AppMethodBeat.o(35677);
        return;
      }
    }
    bAT(paramString);
    AppMethodBeat.o(35677);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35681);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
    if (com.tencent.mm.bc.g.oXL != null) {
      com.tencent.mm.bc.g.oXL.a(this);
    }
    if (com.tencent.mm.bd.d.oXN != null) {
      com.tencent.mm.bd.d.oXN.a(this);
    }
    if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class) != null) {
      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).a(this);
    }
    u.a(this);
    this.xeK.alive();
    Mb(true);
    AppMethodBeat.o(35681);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35682);
    Log.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
    if (com.tencent.mm.bc.g.oXL != null) {
      com.tencent.mm.bc.g.oXL.b(this);
    }
    if (com.tencent.mm.bd.d.oXN != null) {
      com.tencent.mm.bd.d.oXN.b(this);
    }
    u.b(this);
    this.xeK.dead();
    ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).b(this);
    AppMethodBeat.o(35682);
  }
  
  public final void jjk() {}
  
  public final void jjl()
  {
    AppMethodBeat.i(256502);
    if (this.adDg != null)
    {
      this.adDg.bK(true, false);
      if (this.adDg.adCT != null) {
        u.jjG();
      }
    }
    jtN();
    AppMethodBeat.o(256502);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35680);
    super.jqF();
    if (this.aexz != null) {
      this.aexz.stop();
    }
    AppMethodBeat.o(35680);
  }
  
  public final boolean jtH()
  {
    AppMethodBeat.i(35664);
    if (this.aexz == null)
    {
      AppMethodBeat.o(35664);
      return false;
    }
    if (this.aexz.getVisibility() == 0)
    {
      AppMethodBeat.o(35664);
      return true;
    }
    AppMethodBeat.o(35664);
    return false;
  }
  
  public final boolean jtI()
  {
    AppMethodBeat.i(35665);
    if (this.aexA == null)
    {
      AppMethodBeat.o(35665);
      return false;
    }
    if (this.aexA.getVisibility() == 0)
    {
      AppMethodBeat.o(35665);
      return true;
    }
    AppMethodBeat.o(35665);
    return false;
  }
  
  public final boolean jtJ()
  {
    AppMethodBeat.i(256438);
    if (this.adDg == null)
    {
      AppMethodBeat.o(256438);
      return false;
    }
    if (this.adDg.getVisibility() == 0)
    {
      AppMethodBeat.o(256438);
      return true;
    }
    AppMethodBeat.o(256438);
    return false;
  }
  
  public final int jtK()
  {
    AppMethodBeat.i(35666);
    if (this.aexz == null)
    {
      AppMethodBeat.o(35666);
      return 0;
    }
    int i = this.aexz.getHeight();
    AppMethodBeat.o(35666);
    return i;
  }
  
  public final void m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(35668);
    if ((this.hlc != null) && (paramString1.equals(this.hlc.getTalkerUserName()))) {
      Mb(false);
    }
    AppMethodBeat.o(35668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bn
 * JD-Core Version:    0.7.0.1
 */