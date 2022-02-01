package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.x;
import java.util.HashMap;
import java.util.LinkedList;

public final class b
  extends x<bn>
{
  private HashMap<String, Boolean> SFK;
  private HashMap<String, bp> SFL;
  private View.OnClickListener SFM;
  private View.OnClickListener SFN;
  private Context context;
  
  public b(Context paramContext)
  {
    super(paramContext, new bn());
    AppMethodBeat.i(29030);
    this.SFK = new HashMap();
    this.SFL = new HashMap();
    this.SFM = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(29026);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
          localObject = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.modelverify.d.bNH().byn(paramAnonymousView.username));
          com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(b.a(b.this), new a.a()
          {
            public final void canAddContact(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(29025);
              if (paramAnonymous2Boolean1)
              {
                if (Util.isNullOrNil(paramAnonymous2String1))
                {
                  Log.w("MicroMsg.FMessageConversationUI", "addContact respUsername is empty");
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(931, 21);
                }
                bh.bCz();
                au localau = com.tencent.mm.model.c.bzA().JE(paramAnonymousView.username);
                paramAnonymous2String2 = localau;
                if ((int)localau.maN == 0)
                {
                  localau = this.SFQ;
                  if (!Util.isNullOrNil(paramAnonymous2String1)) {
                    localau.setUsername(paramAnonymous2String1);
                  }
                  bh.bCz();
                  paramAnonymous2String2 = localau;
                  if (!com.tencent.mm.model.c.bzA().aB(localau))
                  {
                    Log.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                    AppMethodBeat.o(29025);
                    return;
                  }
                }
                ab.I(paramAnonymous2String2);
                com.tencent.mm.modelverify.d.bNI().fP(paramAnonymousView.username, 1);
                k.cZ(b.a(b.this), b.a(b.this).getString(R.l.app_added));
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
                com.tencent.mm.modelverify.d.bNI().fP(paramAnonymousView.username, 2);
              }
              Log.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + paramAnonymousView.username);
              AppMethodBeat.o(29025);
            }
          });
          Log.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(paramAnonymousView.PCB));
          locala.bqM(((az)localObject).kas);
          locala.b(paramAnonymousView.username, localLinkedList, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29026);
      }
    };
    this.SFN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29028);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          Log.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
          com.tencent.mm.pluginsdk.ui.preference.b localb = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          localObject = com.tencent.mm.modelverify.d.bNH().byn(localb.username);
          if ((localObject == null) || (((bp)localObject).field_msgContent == null))
          {
            Log.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + localb.username);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          paramAnonymousView = cc.f.byv(((bp)localObject).field_msgContent);
          if (paramAnonymousView == null)
          {
            Log.e("MicroMsg.FMessageConversationUI", "verify is null, verify fail, talker = " + localb.username);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          Log.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + localb.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
          if (paramAnonymousView.adkR == 1)
          {
            k.a(b.a(b.this), paramAnonymousView.adkS, null, b.a(b.this).getString(R.l.gIg), b.a(b.this).getString(R.l.app_cancel), true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29027);
                a.b(b.a(b.this), this.SFS);
                AppMethodBeat.o(29027);
              }
            }, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
          }
          bh.bCz();
          localObject = com.tencent.mm.model.c.bzB().aMi(localb.username);
          Intent localIntent = new Intent();
          localIntent.putExtra("Contact_User", localb.username);
          localIntent.putExtra("Contact_Nick", localb.nickname);
          if (localObject != null) {
            localIntent.putExtra("Contact_RemarkName", ((cr)localObject).field_conRemark);
          }
          if (!Util.isNullOrNil(paramAnonymousView.chatroomName))
          {
            bh.bCz();
            localObject = com.tencent.mm.model.c.bzK().Ju(paramAnonymousView.chatroomName);
            if (localObject != null)
            {
              localIntent.putExtra("Contact_RoomNickname", ((aj)localObject).getDisplayName(paramAnonymousView.hgk));
              localIntent.putExtra("room_name", paramAnonymousView.chatroomName);
            }
          }
          localIntent.putExtra("Contact_Scene", paramAnonymousView.scene);
          localIntent.putExtra("Verify_ticket", paramAnonymousView.pPi);
          localIntent.putExtra("sayhi_with_sns_perm_send_verify", false);
          localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
          localIntent.putExtra("sayhi_with_sns_perm_set_label", true);
          localIntent.putExtra("sayhi_with_jump_to_profile", true);
          localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 7);
          int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 2);
          int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpl, 5000);
          localObject = ".ui.SayHiWithSnsPermissionUI";
          if ((!au.bwO(localb.username)) && (i == 1)) {
            paramAnonymousView = ".ui.SayHiWithSnsPermissionUI2";
          }
          while (((au.bwO(localb.username)) || (au.bwP(localb.username))) && (!WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(b.a(b.this))))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29028);
            return;
            paramAnonymousView = (View)localObject;
            if (!au.bwO(localb.username))
            {
              paramAnonymousView = (View)localObject;
              if (i == 2)
              {
                paramAnonymousView = (View)localObject;
                if (ab.bBW() >= j) {
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
  
  public final void aNy()
  {
    AppMethodBeat.i(29032);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      w(com.tencent.mm.modelverify.d.bNI().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(29032);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29024);
        b.a(b.this, com.tencent.mm.modelverify.d.bNI().getAll());
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(29024);
      }
    });
    AppMethodBeat.o(29032);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(29033);
    fSd();
    aNy();
    AppMethodBeat.o(29033);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29031);
    if (paramView == null)
    {
      paramView = af.mU(this.context).inflate(R.i.gkh, null);
      paramViewGroup = new a();
      paramViewGroup.SFU = ((MaskLayout)paramView.findViewById(R.h.fIw));
      paramViewGroup.pWj = ((TextView)paramView.findViewById(R.h.fIB));
      paramViewGroup.SFZ = ((TextView)paramView.findViewById(R.h.fIy));
      paramViewGroup.pWl = ((Button)paramView.findViewById(R.h.fIt));
      paramViewGroup.pWl.setOnClickListener(this.SFM);
      paramViewGroup.SFV = ((Button)paramView.findViewById(R.h.fIE));
      paramViewGroup.SFV.setOnClickListener(this.SFN);
      paramViewGroup.SFW = ((TextView)paramView.findViewById(R.h.fIC));
      paramViewGroup.SFX = ((TextView)paramView.findViewById(R.h.fIv));
      paramViewGroup.pIJ = ((TextView)paramView.findViewById(R.h.fIx));
      paramViewGroup.SFY = ((TextView)paramView.findViewById(R.h.fIz));
      paramViewGroup.SGa = ((ImageView)paramView.findViewById(R.h.fLA));
      paramViewGroup.SGa.setImageDrawable(bb.m(this.context, R.k.icons_outlined_sendinvitation, this.context.getResources().getColor(R.e.BW_0_Alpha_0_5)));
      paramView.setTag(paramViewGroup);
    }
    bn localbn;
    for (;;)
    {
      localbn = (bn)getItem(paramInt);
      a.b.g((ImageView)paramViewGroup.SFU.getContentView(), localbn.field_talker);
      paramViewGroup.pWj.setText(p.b(this.context, localbn.field_displayName, paramViewGroup.pWj.getTextSize()));
      if (localbn.field_fmsgSysRowId > 0L) {
        break label601;
      }
      Log.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = com.tencent.mm.modelverify.d.bNH().aLv(localbn.field_talker);
      if (localObject1 != null) {
        break;
      }
      Log.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localbn.field_talker);
      paramViewGroup.pWl.setVisibility(8);
      paramViewGroup.SFV.setVisibility(8);
      paramViewGroup.SFW.setVisibility(8);
      paramViewGroup.SFX.setVisibility(8);
      paramViewGroup.SFZ.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.c(this.context, (bp)localObject1);
    Log.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localbn.field_talker);
    Object localObject2;
    if (localbn.field_state == 1)
    {
      bh.bCz();
      localObject2 = com.tencent.mm.model.c.bzA().JE(localbn.field_talker);
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.d)localObject2).maN != 0) && (!com.tencent.mm.contact.d.rs(((az)localObject2).field_type))) {
        com.tencent.mm.modelverify.d.bNI().fP(localbn.field_talker, 0);
      }
    }
    label601:
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localbn.field_talker);
      paramViewGroup.pWl.setVisibility(8);
      paramViewGroup.SFV.setVisibility(8);
      paramViewGroup.SFW.setVisibility(8);
      paramViewGroup.SFX.setVisibility(8);
      paramViewGroup.SFZ.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      localObject1 = this.context;
      l = localbn.field_fmsgSysRowId;
      if (localbn.field_fmsgIsSend % 2 == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a((Context)localObject1, l, bool1, localbn.field_talker, localbn.field_fmsgContent, localbn.field_fmsgType, localbn.field_contentFromUsername, localbn.field_contentNickname, localbn.field_contentPhoneNumMD5, localbn.field_contentFullPhoneNumMD5, localbn.field_contentVerifyContent, localbn.field_addScene);
        Log.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + localbn.field_fmsgSysRowId + ", talker = " + localbn.field_talker);
        break;
      }
    }
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).PCB = localbn.field_addScene;
    int i;
    label989:
    boolean bool2;
    if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).ihD)
    {
      paramViewGroup.SFZ.setText(this.context.getString(R.l.gIi, new Object[] { p.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).nUO, paramViewGroup.SFZ.getTextSize()) }));
      if ((localbn.field_state == 2) && (!this.SFK.containsKey(localbn.field_talker)))
      {
        bh.bCz();
        localObject2 = com.tencent.mm.model.c.bzA().JE(localbn.field_talker);
        this.SFK.put(((az)localObject2).field_username, Boolean.valueOf(com.tencent.mm.contact.d.rs(((az)localObject2).field_type)));
        if (com.tencent.mm.contact.d.rs(((az)localObject2).field_type))
        {
          localbn.field_state = 1;
          com.tencent.mm.plugin.profile.c.lb(((az)localObject2).field_username, ((az)localObject2).field_encryptUsername);
          Log.i("MicroMsg.FMessageConversationUI", "error status update username = " + ((az)localObject2).field_username);
        }
      }
      l = i.aRC().getInt("VerifyUserTicketTimeExceed", 259200) * 1000L;
      Log.i("MicroMsg.FMessageConversationUI", "expired time , defaultExpireTime = ".concat(String.valueOf(l)));
      if (((localbn.field_state != 0) && (localbn.field_state != 2)) || (cn.bDv() - localbn.field_lastModifiedTime < l)) {
        break label1444;
      }
      i = 1;
      bool2 = false;
      bool1 = bool2;
      if (localbn.field_state == 2)
      {
        bool1 = bool2;
        if (i != 0)
        {
          bool1 = true;
          Log.i("MicroMsg.FMessageConversationUI", "isStateVerifyingButExpiretime");
        }
      }
      if (i == 0) {
        break label1450;
      }
      i = 3;
      label1034:
      localbn.field_state = i;
      switch (localbn.field_state)
      {
      default: 
        paramViewGroup.SFY.setVisibility(8);
        paramViewGroup.pWl.setVisibility(8);
        paramViewGroup.SFV.setVisibility(8);
        paramViewGroup.SFW.setVisibility(8);
        paramViewGroup.SFX.setVisibility(8);
        label1121:
        paramView.findViewById(R.h.fIA).setBackgroundResource(R.g.white_list_item_selector);
        l = cn.bDv();
        if ((paramInt == 0) && (localbn.field_lastModifiedTime + 259200000L >= l))
        {
          paramViewGroup.pIJ.setVisibility(0);
          paramViewGroup.pIJ.setText(this.context.getString(R.l.gIk));
          label1183:
          if (paramViewGroup.SFW.getVisibility() != 0) {
            break label1882;
          }
          bool2 = true;
          label1196:
          if (1 != localbn.field_state) {
            break label1924;
          }
          if (this.SFL.get(localbn.field_talker) != null) {
            break label1888;
          }
          localObject1 = com.tencent.mm.modelverify.d.bNH().aLv(localbn.field_talker);
          this.SFL.put(localbn.field_talker, localObject1);
          Log.i("MicroMsg.FMessageConversationUI", "put item.field_talker = %s ", new Object[] { localbn.field_talker });
          label1269:
          localObject1 = (bp)this.SFL.get(localbn.field_talker);
          if ((localObject1 == null) || (((((bp)localObject1).field_isSend != 1) || (((bp)localObject1).field_type != 1)) && ((!((bp)localObject1).jbg()) || (((bp)localObject1).field_type != 3)) && ((((bp)localObject1).field_isSend != 1) || (((bp)localObject1).field_type != 2)))) {
            break label1924;
          }
        }
        break;
      }
    }
    label1924:
    for (boolean bool3 = true;; bool3 = false)
    {
      Log.i("MicroMsg.FMessageConversationUI", "isShowVerifyingButtton = %s. isStateVerifyingButExpiretime =  %s, isAddedButonIsend =  %s, ", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((bool2) || (bool1) || (bool3)) {
        paramViewGroup.SGa.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(29031);
        return paramView;
        paramViewGroup.SFZ.setText(p.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).nUO, paramViewGroup.SFZ.getTextSize()));
        break;
        label1444:
        i = 0;
        break label989;
        label1450:
        i = localbn.field_state;
        break label1034;
        if (localbn.field_fmsgSysRowId <= 0L)
        {
          Log.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
          localObject2 = com.tencent.mm.modelverify.d.bNH().byn(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
          if (localObject2 == null)
          {
            i = 0;
            label1500:
            if (i != 0) {
              break label1581;
            }
            paramViewGroup.pWl.setVisibility(0);
            paramViewGroup.pWl.setTag(localObject1);
            paramViewGroup.SFV.setVisibility(8);
          }
        }
        for (;;)
        {
          paramViewGroup.SFW.setVisibility(8);
          paramViewGroup.SFX.setVisibility(8);
          paramViewGroup.SFY.setVisibility(8);
          break;
          i = ((bp)localObject2).field_type;
          break label1500;
          i = localbn.field_recvFmsgType;
          break label1500;
          label1581:
          if ((i == 3) && (!((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).ihD))
          {
            paramViewGroup.pWl.setVisibility(0);
            paramViewGroup.pWl.setTag(localObject1);
            paramViewGroup.SFV.setVisibility(8);
          }
          else
          {
            paramViewGroup.SFV.setVisibility(0);
            paramViewGroup.SFV.setTag(localObject1);
            paramViewGroup.pWl.setVisibility(8);
          }
        }
        paramViewGroup.SFW.setVisibility(0);
        paramViewGroup.pWl.setVisibility(8);
        paramViewGroup.SFV.setVisibility(8);
        paramViewGroup.SFX.setVisibility(8);
        paramViewGroup.SFY.setVisibility(8);
        break label1121;
        paramViewGroup.SFX.setVisibility(0);
        paramViewGroup.pWl.setVisibility(8);
        paramViewGroup.SFV.setVisibility(8);
        paramViewGroup.SFW.setVisibility(8);
        paramViewGroup.SFY.setVisibility(8);
        break label1121;
        paramViewGroup.SFY.setVisibility(0);
        paramViewGroup.pWl.setVisibility(8);
        paramViewGroup.SFV.setVisibility(8);
        paramViewGroup.SFW.setVisibility(8);
        paramViewGroup.SFX.setVisibility(8);
        break label1121;
        if (((paramInt == 0) || (((bn)getItem(paramInt - 1)).field_lastModifiedTime + 259200000L >= l)) && (((bn)getItem(paramInt)).field_lastModifiedTime + 259200000L < l))
        {
          paramViewGroup.pIJ.setVisibility(0);
          paramViewGroup.pIJ.setText(this.context.getString(R.l.gIj));
          break label1183;
        }
        paramViewGroup.pIJ.setVisibility(8);
        break label1183;
        label1882:
        bool2 = false;
        break label1196;
        label1888:
        Log.i("MicroMsg.FMessageConversationUI", "get item.field_talker = %s,", new Object[] { localbn.field_talker });
        break label1269;
        paramViewGroup.SGa.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public MaskLayout SFU;
    public Button SFV;
    public TextView SFW;
    public TextView SFX;
    public TextView SFY;
    public TextView SFZ;
    public ImageView SGa;
    public TextView pIJ;
    public TextView pWj;
    public Button pWl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */