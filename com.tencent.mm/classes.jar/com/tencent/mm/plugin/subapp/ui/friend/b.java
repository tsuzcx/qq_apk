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
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public final class b
  extends s<bl>
{
  private View.OnClickListener FKx;
  private View.OnClickListener FKy;
  private Context context;
  
  public b(Context paramContext)
  {
    super(paramContext, new bl());
    AppMethodBeat.i(29030);
    this.FKx = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(29026);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          Log.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
          paramAnonymousView = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (Util.isNullOrNil(paramAnonymousView.username)))
          {
            Log.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29026);
            return;
          }
          localObject = com.tencent.mm.pluginsdk.ui.preference.b.a(d.bgM().bkv(paramAnonymousView.username));
          com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(b.a(b.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(29025);
              if (paramAnonymous2Boolean1)
              {
                if (Util.isNullOrNil(paramAnonymous2String1))
                {
                  Log.w("MicroMsg.FMessageConversationUI", "addContact respUsername is empty");
                  com.tencent.mm.plugin.report.service.h.CyF.dN(931, 21);
                }
                bg.aVF();
                as localas = com.tencent.mm.model.c.aSN().Kn(paramAnonymousView.username);
                paramAnonymous2String2 = localas;
                if ((int)localas.gMZ == 0)
                {
                  localas = this.FKB;
                  if (!Util.isNullOrNil(paramAnonymous2String1)) {
                    localas.setUsername(paramAnonymous2String1);
                  }
                  bg.aVF();
                  paramAnonymous2String2 = localas;
                  if (!com.tencent.mm.model.c.aSN().ap(localas))
                  {
                    Log.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                    AppMethodBeat.o(29025);
                    return;
                  }
                }
                ab.B(paramAnonymous2String2);
                d.bgN().gP(paramAnonymousView.username, 1);
                com.tencent.mm.ui.base.h.cD(b.a(b.this), b.a(b.this).getString(2131755310));
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
                d.bgN().gP(paramAnonymousView.username, 2);
              }
              Log.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + paramAnonymousView.username);
              AppMethodBeat.o(29025);
            }
          });
          Log.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(paramAnonymousView.Dkc));
          locala.beC(((ax)localObject).fuY);
          locala.b(paramAnonymousView.username, localLinkedList, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29026);
      }
    };
    this.FKy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          Log.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
          com.tencent.mm.pluginsdk.ui.preference.b localb = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          localObject = d.bgM().bkv(localb.username);
          if ((localObject == null) || (((bn)localObject).field_msgContent == null))
          {
            Log.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + localb.username);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          paramAnonymousView = ca.d.bkD(((bn)localObject).field_msgContent);
          Log.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + localb.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
          if (paramAnonymousView.Ora == 1)
          {
            com.tencent.mm.ui.base.h.a(b.a(b.this), paramAnonymousView.Orb, null, b.a(b.this).getString(2131760787), b.a(b.this).getString(2131755761), true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29027);
                a.b(b.a(b.this), this.FKD);
                AppMethodBeat.o(29027);
              }
            }, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          bg.aVF();
          localObject = com.tencent.mm.model.c.aSO().aEZ(localb.username);
          Intent localIntent = new Intent();
          localIntent.putExtra("Contact_User", localb.username);
          localIntent.putExtra("Contact_Nick", localb.nickname);
          if (localObject != null) {
            localIntent.putExtra("Contact_RemarkName", ((cn)localObject).field_conRemark);
          }
          if (!Util.isNullOrNil(paramAnonymousView.chatroomName))
          {
            bg.aVF();
            localObject = com.tencent.mm.model.c.aSX().Kd(paramAnonymousView.chatroomName);
            if (localObject != null)
            {
              localIntent.putExtra("Contact_RoomNickname", ((ah)localObject).getDisplayName(paramAnonymousView.dkU));
              localIntent.putExtra("room_name", paramAnonymousView.chatroomName);
            }
          }
          localIntent.putExtra("Contact_Scene", paramAnonymousView.scene);
          localIntent.putExtra("Verify_ticket", paramAnonymousView.wZz);
          localIntent.putExtra("sayhi_with_sns_perm_send_verify", false);
          localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
          localIntent.putExtra("sayhi_with_sns_perm_set_label", true);
          localIntent.putExtra("sayhi_with_jump_to_profile", true);
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 7);
          int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slQ, 2);
          int j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slT, 1000);
          localObject = ".ui.SayHiWithSnsPermissionUI";
          if ((!as.bjp(localb.username)) && (i == 1)) {
            paramAnonymousView = ".ui.SayHiWithSnsPermissionUI2";
          }
          while (((as.bjp(localb.username)) || (as.bjq(localb.username))) && (!WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(b.a(b.this))))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
            paramAnonymousView = (View)localObject;
            if (!as.bjp(localb.username))
            {
              paramAnonymousView = (View)localObject;
              if (i == 2)
              {
                paramAnonymousView = (View)localObject;
                if (ab.aVc() >= j) {
                  paramAnonymousView = ".ui.SayHiWithSnsPermissionUI3";
                }
              }
            }
          }
          com.tencent.mm.br.c.b(b.a(b.this), "profile", paramAnonymousView, localIntent);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29028);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(29030);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(29032);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setCursor(d.bgN().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(29032);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29024);
        b.a(b.this, d.bgN().getAll());
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(29024);
      }
    });
    AppMethodBeat.o(29032);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(29033);
    ebf();
    anp();
    AppMethodBeat.o(29033);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29031);
    if (paramView == null)
    {
      paramView = aa.jQ(this.context).inflate(2131494706, null);
      paramViewGroup = new a();
      paramViewGroup.FKF = ((MaskLayout)paramView.findViewById(2131301602));
      paramViewGroup.kib = ((TextView)paramView.findViewById(2131301608));
      paramViewGroup.FKK = ((TextView)paramView.findViewById(2131301604));
      paramViewGroup.kid = ((Button)paramView.findViewById(2131301599));
      paramViewGroup.kid.setOnClickListener(this.FKx);
      paramViewGroup.FKG = ((Button)paramView.findViewById(2131301612));
      paramViewGroup.FKG.setOnClickListener(this.FKy);
      paramViewGroup.FKH = ((TextView)paramView.findViewById(2131301610));
      paramViewGroup.FKI = ((TextView)paramView.findViewById(2131301601));
      paramViewGroup.jUO = ((TextView)paramView.findViewById(2131301603));
      paramViewGroup.FKJ = ((TextView)paramView.findViewById(2131301605));
      paramView.setTag(paramViewGroup);
    }
    bl localbl;
    for (;;)
    {
      localbl = (bl)getItem(paramInt);
      a.b.c((ImageView)paramViewGroup.FKF.getContentView(), localbl.field_talker);
      paramViewGroup.kib.setText(l.b(this.context, localbl.field_displayName, paramViewGroup.kib.getTextSize()));
      if (localbl.field_fmsgSysRowId > 0L) {
        break label541;
      }
      Log.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = d.bgM().aEm(localbl.field_talker);
      if (localObject1 != null) {
        break;
      }
      Log.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localbl.field_talker);
      paramViewGroup.kid.setVisibility(8);
      paramViewGroup.FKG.setVisibility(8);
      paramViewGroup.FKH.setVisibility(8);
      paramViewGroup.FKI.setVisibility(8);
      paramViewGroup.FKK.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.c(this.context, (bn)localObject1);
    Log.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localbl.field_talker);
    Object localObject2;
    if (localbl.field_state == 1)
    {
      bg.aVF();
      localObject2 = com.tencent.mm.model.c.aSN().Kn(localbl.field_talker);
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).gMZ != 0) && (!com.tencent.mm.contact.c.oR(((ax)localObject2).field_type))) {
        d.bgN().gP(localbl.field_talker, 0);
      }
    }
    label541:
    long l;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localbl.field_talker);
      paramViewGroup.kid.setVisibility(8);
      paramViewGroup.FKG.setVisibility(8);
      paramViewGroup.FKH.setVisibility(8);
      paramViewGroup.FKI.setVisibility(8);
      paramViewGroup.FKK.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      localObject1 = this.context;
      l = localbl.field_fmsgSysRowId;
      if (localbl.field_fmsgIsSend % 2 == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a((Context)localObject1, l, bool, localbl.field_talker, localbl.field_fmsgContent, localbl.field_fmsgType, localbl.field_contentFromUsername, localbl.field_contentNickname, localbl.field_contentPhoneNumMD5, localbl.field_contentFullPhoneNumMD5, localbl.field_contentVerifyContent, localbl.field_addScene);
        Log.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + localbl.field_fmsgSysRowId + ", talker = " + localbl.field_talker);
        break;
      }
    }
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).Dkc = localbl.field_addScene;
    paramViewGroup.FKK.setText(l.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).iAq, paramViewGroup.FKK.getTextSize()));
    int i;
    if ((localbl.field_state == 0) && (cl.aWz() - localbl.field_lastModifiedTime >= 259200000L))
    {
      i = 3;
      localbl.field_state = i;
      switch (localbl.field_state)
      {
      default: 
        paramViewGroup.FKJ.setVisibility(8);
        paramViewGroup.kid.setVisibility(8);
        paramViewGroup.FKG.setVisibility(8);
        paramViewGroup.FKH.setVisibility(8);
        paramViewGroup.FKI.setVisibility(8);
        label821:
        paramView.findViewById(2131301607).setBackgroundResource(2131235784);
        l = cl.aWz();
        if ((paramInt == 0) && (localbl.field_lastModifiedTime + 259200000L >= l))
        {
          paramViewGroup.jUO.setVisibility(0);
          paramViewGroup.jUO.setText(this.context.getString(2131760796));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29031);
      return paramView;
      i = localbl.field_state;
      break;
      if (localbl.field_fmsgSysRowId <= 0L)
      {
        Log.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
        localObject2 = d.bgM().bkv(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if (localObject2 == null)
        {
          i = 0;
          label940:
          if ((i != 0) && (i != 3)) {
            break label1027;
          }
          paramViewGroup.kid.setVisibility(0);
          paramViewGroup.kid.setTag(localObject1);
          paramViewGroup.FKG.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup.FKH.setVisibility(8);
        paramViewGroup.FKI.setVisibility(8);
        paramViewGroup.FKJ.setVisibility(8);
        break;
        i = ((bn)localObject2).field_type;
        break label940;
        i = localbl.field_recvFmsgType;
        break label940;
        label1027:
        paramViewGroup.FKG.setVisibility(0);
        paramViewGroup.FKG.setTag(localObject1);
        paramViewGroup.kid.setVisibility(8);
      }
      paramViewGroup.FKH.setVisibility(0);
      paramViewGroup.kid.setVisibility(8);
      paramViewGroup.FKG.setVisibility(8);
      paramViewGroup.FKI.setVisibility(8);
      paramViewGroup.FKJ.setVisibility(8);
      break label821;
      paramViewGroup.FKI.setVisibility(0);
      paramViewGroup.kid.setVisibility(8);
      paramViewGroup.FKG.setVisibility(8);
      paramViewGroup.FKH.setVisibility(8);
      paramViewGroup.FKJ.setVisibility(8);
      break label821;
      paramViewGroup.FKJ.setVisibility(0);
      paramViewGroup.kid.setVisibility(8);
      paramViewGroup.FKG.setVisibility(8);
      paramViewGroup.FKH.setVisibility(8);
      paramViewGroup.FKI.setVisibility(8);
      break label821;
      if (((paramInt == 0) || (((bl)getItem(paramInt - 1)).field_lastModifiedTime + 259200000L >= l)) && (((bl)getItem(paramInt)).field_lastModifiedTime + 259200000L < l))
      {
        paramViewGroup.jUO.setVisibility(0);
        paramViewGroup.jUO.setText(this.context.getString(2131760795));
      }
      else
      {
        paramViewGroup.jUO.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public MaskLayout FKF;
    public Button FKG;
    public TextView FKH;
    public TextView FKI;
    public TextView FKJ;
    public TextView FKK;
    public TextView jUO;
    public TextView kib;
    public Button kid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */