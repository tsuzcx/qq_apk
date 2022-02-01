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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
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
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.v;
import java.util.LinkedList;

public final class b
  extends v<bl>
{
  private View.OnClickListener Meu;
  private View.OnClickListener Mev;
  private Context context;
  
  public b(Context paramContext)
  {
    super(paramContext, new bl());
    AppMethodBeat.i(29030);
    this.Meu = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(29026);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
          localObject = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.bl.d.bqb().bwU(paramAnonymousView.username));
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
                  com.tencent.mm.plugin.report.service.h.IzE.el(931, 21);
                }
                bh.beI();
                as localas = com.tencent.mm.model.c.bbL().RG(paramAnonymousView.username);
                paramAnonymous2String2 = localas;
                if ((int)localas.jxt == 0)
                {
                  localas = this.Mey;
                  if (!Util.isNullOrNil(paramAnonymous2String1)) {
                    localas.setUsername(paramAnonymous2String1);
                  }
                  bh.beI();
                  paramAnonymous2String2 = localas;
                  if (!com.tencent.mm.model.c.bbL().av(localas))
                  {
                    Log.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                    AppMethodBeat.o(29025);
                    return;
                  }
                }
                ab.H(paramAnonymous2String2);
                com.tencent.mm.bl.d.bqc().hx(paramAnonymousView.username, 1);
                com.tencent.mm.ui.base.h.cO(b.a(b.this), b.a(b.this).getString(R.l.app_added));
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
                com.tencent.mm.bl.d.bqc().hx(paramAnonymousView.username, 2);
              }
              Log.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + paramAnonymousView.username);
              AppMethodBeat.o(29025);
            }
          });
          Log.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(paramAnonymousView.JpE));
          locala.bqY(((ax)localObject).hDx);
          locala.b(paramAnonymousView.username, localLinkedList, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29026);
      }
    };
    this.Mev = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          Log.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
          com.tencent.mm.pluginsdk.ui.preference.b localb = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          localObject = com.tencent.mm.bl.d.bqb().bwU(localb.username);
          if ((localObject == null) || (((bn)localObject).field_msgContent == null))
          {
            Log.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + localb.username);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          paramAnonymousView = ca.d.bxc(((bn)localObject).field_msgContent);
          Log.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + localb.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
          if (paramAnonymousView.VGW == 1)
          {
            com.tencent.mm.ui.base.h.a(b.a(b.this), paramAnonymousView.VGX, null, b.a(b.this).getString(R.l.eFm), b.a(b.this).getString(R.l.app_cancel), true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29027);
                a.b(b.a(b.this), this.MeA);
                AppMethodBeat.o(29027);
              }
            }, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          bh.beI();
          localObject = com.tencent.mm.model.c.bbM().aPj(localb.username);
          Intent localIntent = new Intent();
          localIntent.putExtra("Contact_User", localb.username);
          localIntent.putExtra("Contact_Nick", localb.nickname);
          if (localObject != null) {
            localIntent.putExtra("Contact_RemarkName", ((co)localObject).field_conRemark);
          }
          if (!Util.isNullOrNil(paramAnonymousView.chatroomName))
          {
            bh.beI();
            localObject = com.tencent.mm.model.c.bbV().Rw(paramAnonymousView.chatroomName);
            if (localObject != null)
            {
              localIntent.putExtra("Contact_RoomNickname", ((ah)localObject).PJ(paramAnonymousView.fcC));
              localIntent.putExtra("room_name", paramAnonymousView.chatroomName);
            }
          }
          localIntent.putExtra("Contact_Scene", paramAnonymousView.scene);
          localIntent.putExtra("Verify_ticket", paramAnonymousView.BLy);
          localIntent.putExtra("sayhi_with_sns_perm_send_verify", false);
          localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
          localIntent.putExtra("sayhi_with_sns_perm_set_label", true);
          localIntent.putExtra("sayhi_with_jump_to_profile", true);
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 7);
          int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWD, 2);
          int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWG, 5000);
          localObject = ".ui.SayHiWithSnsPermissionUI";
          if ((!as.bvK(localb.username)) && (i == 1)) {
            paramAnonymousView = ".ui.SayHiWithSnsPermissionUI2";
          }
          while (((as.bvK(localb.username)) || (as.bvL(localb.username))) && (!WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(b.a(b.this))))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
            paramAnonymousView = (View)localObject;
            if (!as.bvK(localb.username))
            {
              paramAnonymousView = (View)localObject;
              if (i == 2)
              {
                paramAnonymousView = (View)localObject;
                if (ab.bef() >= j) {
                  paramAnonymousView = ".ui.SayHiWithSnsPermissionUI3";
                }
              }
            }
          }
          com.tencent.mm.by.c.b(b.a(b.this), "profile", paramAnonymousView, localIntent);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29028);
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(29030);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(29032);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      v(com.tencent.mm.bl.d.bqc().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(29032);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29024);
        b.a(b.this, com.tencent.mm.bl.d.bqc().getAll());
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(29024);
      }
    });
    AppMethodBeat.o(29032);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(29033);
    eKd();
    atr();
    AppMethodBeat.o(29033);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29031);
    if (paramView == null)
    {
      paramView = ad.kS(this.context).inflate(R.i.ehm, null);
      paramViewGroup = new a();
      paramViewGroup.MeC = ((MaskLayout)paramView.findViewById(R.h.dHn));
      paramViewGroup.mZA = ((TextView)paramView.findViewById(R.h.dHs));
      paramViewGroup.MeH = ((TextView)paramView.findViewById(R.h.dHp));
      paramViewGroup.mZC = ((Button)paramView.findViewById(R.h.dHk));
      paramViewGroup.mZC.setOnClickListener(this.Meu);
      paramViewGroup.MeD = ((Button)paramView.findViewById(R.h.dHv));
      paramViewGroup.MeD.setOnClickListener(this.Mev);
      paramViewGroup.MeE = ((TextView)paramView.findViewById(R.h.dHt));
      paramViewGroup.MeF = ((TextView)paramView.findViewById(R.h.dHm));
      paramViewGroup.mMb = ((TextView)paramView.findViewById(R.h.dHo));
      paramViewGroup.MeG = ((TextView)paramView.findViewById(R.h.dHq));
      paramView.setTag(paramViewGroup);
    }
    bl localbl;
    for (;;)
    {
      localbl = (bl)getItem(paramInt);
      a.b.c((ImageView)paramViewGroup.MeC.getContentView(), localbl.field_talker);
      paramViewGroup.mZA.setText(l.b(this.context, localbl.field_displayName, paramViewGroup.mZA.getTextSize()));
      if (localbl.field_fmsgSysRowId > 0L) {
        break label557;
      }
      Log.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = com.tencent.mm.bl.d.bqb().aOw(localbl.field_talker);
      if (localObject1 != null) {
        break;
      }
      Log.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localbl.field_talker);
      paramViewGroup.mZC.setVisibility(8);
      paramViewGroup.MeD.setVisibility(8);
      paramViewGroup.MeE.setVisibility(8);
      paramViewGroup.MeF.setVisibility(8);
      paramViewGroup.MeH.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.c(this.context, (bn)localObject1);
    Log.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localbl.field_talker);
    Object localObject2;
    if (localbl.field_state == 1)
    {
      bh.beI();
      localObject2 = com.tencent.mm.model.c.bbL().RG(localbl.field_talker);
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.d)localObject2).jxt != 0) && (!com.tencent.mm.contact.d.rk(((ax)localObject2).field_type))) {
        com.tencent.mm.bl.d.bqc().hx(localbl.field_talker, 0);
      }
    }
    label557:
    long l;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localbl.field_talker);
      paramViewGroup.mZC.setVisibility(8);
      paramViewGroup.MeD.setVisibility(8);
      paramViewGroup.MeE.setVisibility(8);
      paramViewGroup.MeF.setVisibility(8);
      paramViewGroup.MeH.setVisibility(8);
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
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).JpE = localbl.field_addScene;
    paramViewGroup.MeH.setText(l.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).lpM, paramViewGroup.MeH.getTextSize()));
    int i;
    if ((localbl.field_state == 0) && (cm.bfD() - localbl.field_lastModifiedTime >= 259200000L))
    {
      i = 3;
      localbl.field_state = i;
      switch (localbl.field_state)
      {
      default: 
        paramViewGroup.MeG.setVisibility(8);
        paramViewGroup.mZC.setVisibility(8);
        paramViewGroup.MeD.setVisibility(8);
        paramViewGroup.MeE.setVisibility(8);
        paramViewGroup.MeF.setVisibility(8);
        label841:
        paramView.findViewById(R.h.dHr).setBackgroundResource(R.g.white_list_item_selector);
        l = cm.bfD();
        if ((paramInt == 0) && (localbl.field_lastModifiedTime + 259200000L >= l))
        {
          paramViewGroup.mMb.setVisibility(0);
          paramViewGroup.mMb.setText(this.context.getString(R.l.eFq));
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
        localObject2 = com.tencent.mm.bl.d.bqb().bwU(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if (localObject2 == null)
        {
          i = 0;
          label961:
          if ((i != 0) && (i != 3)) {
            break label1048;
          }
          paramViewGroup.mZC.setVisibility(0);
          paramViewGroup.mZC.setTag(localObject1);
          paramViewGroup.MeD.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup.MeE.setVisibility(8);
        paramViewGroup.MeF.setVisibility(8);
        paramViewGroup.MeG.setVisibility(8);
        break;
        i = ((bn)localObject2).field_type;
        break label961;
        i = localbl.field_recvFmsgType;
        break label961;
        label1048:
        paramViewGroup.MeD.setVisibility(0);
        paramViewGroup.MeD.setTag(localObject1);
        paramViewGroup.mZC.setVisibility(8);
      }
      paramViewGroup.MeE.setVisibility(0);
      paramViewGroup.mZC.setVisibility(8);
      paramViewGroup.MeD.setVisibility(8);
      paramViewGroup.MeF.setVisibility(8);
      paramViewGroup.MeG.setVisibility(8);
      break label841;
      paramViewGroup.MeF.setVisibility(0);
      paramViewGroup.mZC.setVisibility(8);
      paramViewGroup.MeD.setVisibility(8);
      paramViewGroup.MeE.setVisibility(8);
      paramViewGroup.MeG.setVisibility(8);
      break label841;
      paramViewGroup.MeG.setVisibility(0);
      paramViewGroup.mZC.setVisibility(8);
      paramViewGroup.MeD.setVisibility(8);
      paramViewGroup.MeE.setVisibility(8);
      paramViewGroup.MeF.setVisibility(8);
      break label841;
      if (((paramInt == 0) || (((bl)getItem(paramInt - 1)).field_lastModifiedTime + 259200000L >= l)) && (((bl)getItem(paramInt)).field_lastModifiedTime + 259200000L < l))
      {
        paramViewGroup.mMb.setVisibility(0);
        paramViewGroup.mMb.setText(this.context.getString(R.l.eFp));
      }
      else
      {
        paramViewGroup.mMb.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public MaskLayout MeC;
    public Button MeD;
    public TextView MeE;
    public TextView MeF;
    public TextView MeG;
    public TextView MeH;
    public TextView mMb;
    public TextView mZA;
    public Button mZC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */