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
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public final class b
  extends r<bf>
{
  private View.OnClickListener Bio;
  private View.OnClickListener Bip;
  private Context context;
  
  public b(Context paramContext)
  {
    super(paramContext, new bf());
    AppMethodBeat.i(29030);
    this.Bio = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(29026);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          ad.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
          paramAnonymousView = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (bt.isNullOrNil(paramAnonymousView.username)))
          {
            ad.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29026);
            return;
          }
          localObject = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.bk.d.aMn().aTW(paramAnonymousView.username));
          com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(b.a(b.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(29025);
              if (paramAnonymous2Boolean1)
              {
                if (bt.isNullOrNil(paramAnonymous2String1))
                {
                  ad.w("MicroMsg.FMessageConversationUI", "addContact respUsername is empty");
                  com.tencent.mm.plugin.report.service.g.yhR.dD(931, 21);
                }
                ba.aBQ();
                am localam = c.azp().Bf(paramAnonymousView.username);
                paramAnonymous2String2 = localam;
                if ((int)localam.gfj == 0)
                {
                  localam = this.Bis;
                  if (!bt.isNullOrNil(paramAnonymous2String1)) {
                    localam.setUsername(paramAnonymous2String1);
                  }
                  ba.aBQ();
                  paramAnonymous2String2 = localam;
                  if (!c.azp().ag(localam))
                  {
                    ad.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                    AppMethodBeat.o(29025);
                    return;
                  }
                }
                w.u(paramAnonymous2String2);
                com.tencent.mm.bk.d.aMo().gn(paramAnonymousView.username, 1);
                h.cl(b.a(b.this), b.a(b.this).getString(2131755275));
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
                com.tencent.mm.bk.d.aMo().gn(paramAnonymousView.username, 2);
              }
              ad.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + paramAnonymousView.username);
              AppMethodBeat.o(29025);
            }
          });
          ad.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(paramAnonymousView.yPa));
          locala.aME(((aw)localObject).ePK);
          locala.b(paramAnonymousView.username, localLinkedList, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29026);
      }
    };
    this.Bip = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29028);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          ad.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
          paramAnonymousView = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          localObject1 = com.tencent.mm.bk.d.aMn().aTW(paramAnonymousView.username);
          if ((localObject1 == null) || (((bh)localObject1).field_msgContent == null))
          {
            ad.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + paramAnonymousView.username);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          bu.d locald = bu.d.aUe(((bh)localObject1).field_msgContent);
          ad.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
          if (locald.IMC == 1)
          {
            h.a(b.a(b.this), locald.IMD, null, b.a(b.this).getString(2131759472), b.a(b.this).getString(2131755691), true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29027);
                a.b(b.a(b.this), this.Biu);
                AppMethodBeat.o(29027);
              }
            }, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          ba.aBQ();
          Object localObject2 = c.azq().aqz(paramAnonymousView.username);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", paramAnonymousView.username);
          ((Intent)localObject1).putExtra("Contact_Nick", paramAnonymousView.nickname);
          if (localObject2 != null) {
            ((Intent)localObject1).putExtra("Contact_RemarkName", ((com.tencent.mm.storage.cf)localObject2).field_conRemark);
          }
          if (!bt.isNullOrNil(locald.chatroomName))
          {
            ba.aBQ();
            localObject2 = c.azz().AN(locald.chatroomName);
            if (localObject2 != null)
            {
              ((Intent)localObject1).putExtra("Contact_RoomNickname", ((ab)localObject2).zf(locald.dHm));
              ((Intent)localObject1).putExtra("room_name", locald.chatroomName);
            }
          }
          ((Intent)localObject1).putExtra("Contact_Scene", locald.scene);
          ((Intent)localObject1).putExtra("Verify_ticket", locald.txJ);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_send_verify", false);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_add_remark", true);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_set_label", true);
          ((Intent)localObject1).putExtra("sayhi_with_jump_to_profile", true);
          ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", 7);
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHe, 0);
          if ((am.aSQ(paramAnonymousView.username)) || (i != 1)) {
            break label508;
          }
          paramAnonymousView = ".ui.SayHiWithSnsPermissionUI2";
        }
        for (;;)
        {
          com.tencent.mm.bs.d.b(b.a(b.this), "profile", paramAnonymousView, (Intent)localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29028);
          return;
          label508:
          if ((!am.aSQ(paramAnonymousView.username)) && (i == 2)) {
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
  
  public final void Zu()
  {
    AppMethodBeat.i(29032);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setCursor(com.tencent.mm.bk.d.aMo().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(29032);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29024);
        b.a(b.this, com.tencent.mm.bk.d.aMo().getAll());
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(29024);
      }
    });
    AppMethodBeat.o(29032);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(29033);
    det();
    Zu();
    AppMethodBeat.o(29033);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29031);
    if (paramView == null)
    {
      paramView = z.jO(this.context).inflate(2131494151, null);
      paramViewGroup = new a();
      paramViewGroup.Biw = ((MaskLayout)paramView.findViewById(2131300151));
      paramViewGroup.jhg = ((TextView)paramView.findViewById(2131300157));
      paramViewGroup.BiB = ((TextView)paramView.findViewById(2131300153));
      paramViewGroup.jhi = ((Button)paramView.findViewById(2131300148));
      paramViewGroup.jhi.setOnClickListener(this.Bio);
      paramViewGroup.Bix = ((Button)paramView.findViewById(2131300161));
      paramViewGroup.Bix.setOnClickListener(this.Bip);
      paramViewGroup.Biy = ((TextView)paramView.findViewById(2131300159));
      paramViewGroup.Biz = ((TextView)paramView.findViewById(2131300150));
      paramViewGroup.iUW = ((TextView)paramView.findViewById(2131300152));
      paramViewGroup.BiA = ((TextView)paramView.findViewById(2131300154));
      paramView.setTag(paramViewGroup);
    }
    bf localbf;
    for (;;)
    {
      localbf = (bf)getItem(paramInt);
      a.b.c((ImageView)paramViewGroup.Biw.getContentView(), localbf.field_talker);
      paramViewGroup.jhg.setText(k.b(this.context, localbf.field_displayName, paramViewGroup.jhg.getTextSize()));
      if (localbf.field_fmsgSysRowId > 0L) {
        break label541;
      }
      ad.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = com.tencent.mm.bk.d.aMn().apM(localbf.field_talker);
      if (localObject1 != null) {
        break;
      }
      ad.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localbf.field_talker);
      paramViewGroup.jhi.setVisibility(8);
      paramViewGroup.Bix.setVisibility(8);
      paramViewGroup.Biy.setVisibility(8);
      paramViewGroup.Biz.setVisibility(8);
      paramViewGroup.BiB.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.c(this.context, (bh)localObject1);
    ad.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localbf.field_talker);
    Object localObject2;
    if (localbf.field_state == 1)
    {
      ba.aBQ();
      localObject2 = c.azp().Bf(localbf.field_talker);
      if ((localObject2 != null) && ((int)((com.tencent.mm.o.b)localObject2).gfj != 0) && (!com.tencent.mm.o.b.lM(((aw)localObject2).field_type))) {
        com.tencent.mm.bk.d.aMo().gn(localbf.field_talker, 0);
      }
    }
    label541:
    long l;
    if (localObject1 == null)
    {
      ad.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localbf.field_talker);
      paramViewGroup.jhi.setVisibility(8);
      paramViewGroup.Bix.setVisibility(8);
      paramViewGroup.Biy.setVisibility(8);
      paramViewGroup.Biz.setVisibility(8);
      paramViewGroup.BiB.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      localObject1 = this.context;
      l = localbf.field_fmsgSysRowId;
      if (localbf.field_fmsgIsSend % 2 == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a((Context)localObject1, l, bool, localbf.field_talker, localbf.field_fmsgContent, localbf.field_fmsgType, localbf.field_contentFromUsername, localbf.field_contentNickname, localbf.field_contentPhoneNumMD5, localbf.field_contentFullPhoneNumMD5, localbf.field_contentVerifyContent, localbf.field_addScene);
        ad.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + localbf.field_fmsgSysRowId + ", talker = " + localbf.field_talker);
        break;
      }
    }
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).yPa = localbf.field_addScene;
    paramViewGroup.BiB.setText(k.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).hDo, paramViewGroup.BiB.getTextSize()));
    int i;
    if ((localbf.field_state == 0) && (com.tencent.mm.model.cf.aCL() - localbf.field_lastModifiedTime >= 259200000L))
    {
      i = 3;
      localbf.field_state = i;
      switch (localbf.field_state)
      {
      default: 
        paramViewGroup.BiA.setVisibility(8);
        paramViewGroup.jhi.setVisibility(8);
        paramViewGroup.Bix.setVisibility(8);
        paramViewGroup.Biy.setVisibility(8);
        paramViewGroup.Biz.setVisibility(8);
        label821:
        paramView.findViewById(2131300156).setBackgroundResource(2131234801);
        l = com.tencent.mm.model.cf.aCL();
        if ((paramInt == 0) && (localbf.field_lastModifiedTime + 259200000L >= l))
        {
          paramViewGroup.iUW.setVisibility(0);
          paramViewGroup.iUW.setText(this.context.getString(2131759481));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29031);
      return paramView;
      i = localbf.field_state;
      break;
      if (localbf.field_fmsgSysRowId <= 0L)
      {
        ad.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
        localObject2 = com.tencent.mm.bk.d.aMn().aTW(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if (localObject2 == null)
        {
          i = 0;
          label940:
          if ((i != 0) && (i != 3)) {
            break label1027;
          }
          paramViewGroup.jhi.setVisibility(0);
          paramViewGroup.jhi.setTag(localObject1);
          paramViewGroup.Bix.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup.Biy.setVisibility(8);
        paramViewGroup.Biz.setVisibility(8);
        paramViewGroup.BiA.setVisibility(8);
        break;
        i = ((bh)localObject2).field_type;
        break label940;
        i = localbf.field_recvFmsgType;
        break label940;
        label1027:
        paramViewGroup.Bix.setVisibility(0);
        paramViewGroup.Bix.setTag(localObject1);
        paramViewGroup.jhi.setVisibility(8);
      }
      paramViewGroup.Biy.setVisibility(0);
      paramViewGroup.jhi.setVisibility(8);
      paramViewGroup.Bix.setVisibility(8);
      paramViewGroup.Biz.setVisibility(8);
      paramViewGroup.BiA.setVisibility(8);
      break label821;
      paramViewGroup.Biz.setVisibility(0);
      paramViewGroup.jhi.setVisibility(8);
      paramViewGroup.Bix.setVisibility(8);
      paramViewGroup.Biy.setVisibility(8);
      paramViewGroup.BiA.setVisibility(8);
      break label821;
      paramViewGroup.BiA.setVisibility(0);
      paramViewGroup.jhi.setVisibility(8);
      paramViewGroup.Bix.setVisibility(8);
      paramViewGroup.Biy.setVisibility(8);
      paramViewGroup.Biz.setVisibility(8);
      break label821;
      if (((paramInt == 0) || (((bf)getItem(paramInt - 1)).field_lastModifiedTime + 259200000L >= l)) && (((bf)getItem(paramInt)).field_lastModifiedTime + 259200000L < l))
      {
        paramViewGroup.iUW.setVisibility(0);
        paramViewGroup.iUW.setText(this.context.getString(2131759480));
      }
      else
      {
        paramViewGroup.iUW.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public TextView BiA;
    public TextView BiB;
    public MaskLayout Biw;
    public Button Bix;
    public TextView Biy;
    public TextView Biz;
    public TextView iUW;
    public TextView jhg;
    public Button jhi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */