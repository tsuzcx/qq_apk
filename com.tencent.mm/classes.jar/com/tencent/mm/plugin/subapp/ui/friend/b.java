package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public final class b
  extends r<bg>
{
  private View.OnClickListener BzM;
  private View.OnClickListener BzN;
  private Context context;
  
  public b(Context paramContext)
  {
    super(paramContext, new bg());
    AppMethodBeat.i(29030);
    this.BzM = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(29026);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          ae.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
          paramAnonymousView = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (bu.isNullOrNil(paramAnonymousView.username)))
          {
            ae.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29026);
            return;
          }
          localObject = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.bj.d.aML().aVx(paramAnonymousView.username));
          com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(b.a(b.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(29025);
              if (paramAnonymous2Boolean1)
              {
                if (bu.isNullOrNil(paramAnonymous2String1))
                {
                  ae.w("MicroMsg.FMessageConversationUI", "addContact respUsername is empty");
                  com.tencent.mm.plugin.report.service.g.yxI.dD(931, 21);
                }
                bc.aCg();
                an localan = com.tencent.mm.model.c.azF().BH(paramAnonymousView.username);
                paramAnonymous2String2 = localan;
                if ((int)localan.ght == 0)
                {
                  localan = this.BzQ;
                  if (!bu.isNullOrNil(paramAnonymous2String1)) {
                    localan.setUsername(paramAnonymous2String1);
                  }
                  bc.aCg();
                  paramAnonymous2String2 = localan;
                  if (!com.tencent.mm.model.c.azF().an(localan))
                  {
                    ae.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                    AppMethodBeat.o(29025);
                    return;
                  }
                }
                x.B(paramAnonymous2String2);
                com.tencent.mm.bj.d.aMM().gw(paramAnonymousView.username, 1);
                h.cm(b.a(b.this), b.a(b.this).getString(2131755275));
                b.a(b.this, paramAnonymousView.username);
              }
              for (;;)
              {
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(29025);
                return;
                if (!paramAnonymous2Boolean2) {
                  break;
                }
                com.tencent.mm.bj.d.aMM().gw(paramAnonymousView.username, 2);
              }
              ae.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + paramAnonymousView.username);
              AppMethodBeat.o(29025);
            }
          });
          ae.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(paramAnonymousView.zfk));
          locala.aOa(((aw)localObject).eRv);
          locala.b(paramAnonymousView.username, localLinkedList, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29026);
      }
    };
    this.BzN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29028);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          ae.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
          paramAnonymousView = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          localObject1 = com.tencent.mm.bj.d.aML().aVx(paramAnonymousView.username);
          if ((localObject1 == null) || (((bi)localObject1).field_msgContent == null))
          {
            ae.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + paramAnonymousView.username);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          bv.d locald = bv.d.aVF(((bi)localObject1).field_msgContent);
          ae.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
          if (locald.Jhj == 1)
          {
            h.a(b.a(b.this), locald.Jhk, null, b.a(b.this).getString(2131759472), b.a(b.this).getString(2131755691), true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29027);
                a.b(b.a(b.this), this.BzS);
                AppMethodBeat.o(29027);
              }
            }, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          bc.aCg();
          Object localObject2 = com.tencent.mm.model.c.azG().arE(paramAnonymousView.username);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", paramAnonymousView.username);
          ((Intent)localObject1).putExtra("Contact_Nick", paramAnonymousView.nickname);
          if (localObject2 != null) {
            ((Intent)localObject1).putExtra("Contact_RemarkName", ((cg)localObject2).field_conRemark);
          }
          if (!bu.isNullOrNil(locald.chatroomName))
          {
            bc.aCg();
            localObject2 = com.tencent.mm.model.c.azP().Bx(locald.chatroomName);
            if (localObject2 != null)
            {
              ((Intent)localObject1).putExtra("Contact_RoomNickname", ((ac)localObject2).zP(locald.cUA));
              ((Intent)localObject1).putExtra("room_name", locald.chatroomName);
            }
          }
          ((Intent)localObject1).putExtra("Contact_Scene", locald.scene);
          ((Intent)localObject1).putExtra("Verify_ticket", locald.tIA);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_send_verify", false);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_add_remark", true);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_set_label", true);
          ((Intent)localObject1).putExtra("sayhi_with_jump_to_profile", true);
          ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", 7);
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOK, 0);
          if ((an.aUq(paramAnonymousView.username)) || (i != 1)) {
            break label508;
          }
          paramAnonymousView = ".ui.SayHiWithSnsPermissionUI2";
        }
        for (;;)
        {
          com.tencent.mm.br.d.b(b.a(b.this), "profile", paramAnonymousView, (Intent)localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29028);
          return;
          label508:
          if ((!an.aUq(paramAnonymousView.username)) && (i == 2)) {
            paramAnonymousView = ".ui.SayHiWithSnsPermissionUI3";
          } else {
            paramAnonymousView = ".ui.SayHiWithSnsPermissionUI";
          }
        }
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(29030);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(29032);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setCursor(com.tencent.mm.bj.d.aMM().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(29032);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29024);
        b.a(b.this, com.tencent.mm.bj.d.aMM().getAll());
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(29024);
      }
    });
    AppMethodBeat.o(29032);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(29033);
    dhl();
    ZD();
    AppMethodBeat.o(29033);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29031);
    if (paramView == null)
    {
      paramView = z.jV(this.context).inflate(2131494151, null);
      paramViewGroup = new a();
      paramViewGroup.BzU = ((MaskLayout)paramView.findViewById(2131300151));
      paramViewGroup.jjZ = ((TextView)paramView.findViewById(2131300157));
      paramViewGroup.BzZ = ((TextView)paramView.findViewById(2131300153));
      paramViewGroup.jkb = ((Button)paramView.findViewById(2131300148));
      paramViewGroup.jkb.setOnClickListener(this.BzM);
      paramViewGroup.BzV = ((Button)paramView.findViewById(2131300161));
      paramViewGroup.BzV.setOnClickListener(this.BzN);
      paramViewGroup.BzW = ((TextView)paramView.findViewById(2131300159));
      paramViewGroup.BzX = ((TextView)paramView.findViewById(2131300150));
      paramViewGroup.iXP = ((TextView)paramView.findViewById(2131300152));
      paramViewGroup.BzY = ((TextView)paramView.findViewById(2131300154));
      paramView.setTag(paramViewGroup);
    }
    bg localbg;
    for (;;)
    {
      localbg = (bg)getItem(paramInt);
      a.b.c((ImageView)paramViewGroup.BzU.getContentView(), localbg.field_talker);
      paramViewGroup.jjZ.setText(k.b(this.context, localbg.field_displayName, paramViewGroup.jjZ.getTextSize()));
      if (localbg.field_fmsgSysRowId > 0L) {
        break label541;
      }
      ae.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = com.tencent.mm.bj.d.aML().aqR(localbg.field_talker);
      if (localObject1 != null) {
        break;
      }
      ae.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localbg.field_talker);
      paramViewGroup.jkb.setVisibility(8);
      paramViewGroup.BzV.setVisibility(8);
      paramViewGroup.BzW.setVisibility(8);
      paramViewGroup.BzX.setVisibility(8);
      paramViewGroup.BzZ.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.c(this.context, (bi)localObject1);
    ae.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localbg.field_talker);
    Object localObject2;
    if (localbg.field_state == 1)
    {
      bc.aCg();
      localObject2 = com.tencent.mm.model.c.azF().BH(localbg.field_talker);
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).ght != 0) && (!com.tencent.mm.contact.c.lO(((aw)localObject2).field_type))) {
        com.tencent.mm.bj.d.aMM().gw(localbg.field_talker, 0);
      }
    }
    label541:
    long l;
    if (localObject1 == null)
    {
      ae.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localbg.field_talker);
      paramViewGroup.jkb.setVisibility(8);
      paramViewGroup.BzV.setVisibility(8);
      paramViewGroup.BzW.setVisibility(8);
      paramViewGroup.BzX.setVisibility(8);
      paramViewGroup.BzZ.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      localObject1 = this.context;
      l = localbg.field_fmsgSysRowId;
      if (localbg.field_fmsgIsSend % 2 == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a((Context)localObject1, l, bool, localbg.field_talker, localbg.field_fmsgContent, localbg.field_fmsgType, localbg.field_contentFromUsername, localbg.field_contentNickname, localbg.field_contentPhoneNumMD5, localbg.field_contentFullPhoneNumMD5, localbg.field_contentVerifyContent, localbg.field_addScene);
        ae.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + localbg.field_fmsgSysRowId + ", talker = " + localbg.field_talker);
        break;
      }
    }
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).zfk = localbg.field_addScene;
    paramViewGroup.BzZ.setText(k.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).hGg, paramViewGroup.BzZ.getTextSize()));
    int i;
    if ((localbg.field_state == 0) && (ch.aDb() - localbg.field_lastModifiedTime >= 259200000L))
    {
      i = 3;
      localbg.field_state = i;
      switch (localbg.field_state)
      {
      default: 
        paramViewGroup.BzY.setVisibility(8);
        paramViewGroup.jkb.setVisibility(8);
        paramViewGroup.BzV.setVisibility(8);
        paramViewGroup.BzW.setVisibility(8);
        paramViewGroup.BzX.setVisibility(8);
        label821:
        paramView.findViewById(2131300156).setBackgroundResource(2131234801);
        l = ch.aDb();
        if ((paramInt == 0) && (localbg.field_lastModifiedTime + 259200000L >= l))
        {
          paramViewGroup.iXP.setVisibility(0);
          paramViewGroup.iXP.setText(this.context.getString(2131759481));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29031);
      return paramView;
      i = localbg.field_state;
      break;
      if (localbg.field_fmsgSysRowId <= 0L)
      {
        ae.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
        localObject2 = com.tencent.mm.bj.d.aML().aVx(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if (localObject2 == null)
        {
          i = 0;
          label940:
          if ((i != 0) && (i != 3)) {
            break label1027;
          }
          paramViewGroup.jkb.setVisibility(0);
          paramViewGroup.jkb.setTag(localObject1);
          paramViewGroup.BzV.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup.BzW.setVisibility(8);
        paramViewGroup.BzX.setVisibility(8);
        paramViewGroup.BzY.setVisibility(8);
        break;
        i = ((bi)localObject2).field_type;
        break label940;
        i = localbg.field_recvFmsgType;
        break label940;
        label1027:
        paramViewGroup.BzV.setVisibility(0);
        paramViewGroup.BzV.setTag(localObject1);
        paramViewGroup.jkb.setVisibility(8);
      }
      paramViewGroup.BzW.setVisibility(0);
      paramViewGroup.jkb.setVisibility(8);
      paramViewGroup.BzV.setVisibility(8);
      paramViewGroup.BzX.setVisibility(8);
      paramViewGroup.BzY.setVisibility(8);
      break label821;
      paramViewGroup.BzX.setVisibility(0);
      paramViewGroup.jkb.setVisibility(8);
      paramViewGroup.BzV.setVisibility(8);
      paramViewGroup.BzW.setVisibility(8);
      paramViewGroup.BzY.setVisibility(8);
      break label821;
      paramViewGroup.BzY.setVisibility(0);
      paramViewGroup.jkb.setVisibility(8);
      paramViewGroup.BzV.setVisibility(8);
      paramViewGroup.BzW.setVisibility(8);
      paramViewGroup.BzX.setVisibility(8);
      break label821;
      if (((paramInt == 0) || (((bg)getItem(paramInt - 1)).field_lastModifiedTime + 259200000L >= l)) && (((bg)getItem(paramInt)).field_lastModifiedTime + 259200000L < l))
      {
        paramViewGroup.iXP.setVisibility(0);
        paramViewGroup.iXP.setText(this.context.getString(2131759480));
      }
      else
      {
        paramViewGroup.iXP.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public MaskLayout BzU;
    public Button BzV;
    public TextView BzW;
    public TextView BzX;
    public TextView BzY;
    public TextView BzZ;
    public TextView iXP;
    public TextView jjZ;
    public Button jkb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */