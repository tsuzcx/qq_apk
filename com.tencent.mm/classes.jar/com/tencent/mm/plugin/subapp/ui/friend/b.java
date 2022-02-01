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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.y;
import java.util.LinkedList;

public final class b
  extends q<ay>
{
  private Context context;
  private View.OnClickListener yDy;
  private View.OnClickListener yDz;
  
  public b(Context paramContext)
  {
    super(paramContext, new ay());
    AppMethodBeat.i(29030);
    this.yDy = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(29026);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          ad.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
          paramAnonymousView = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (bt.isNullOrNil(paramAnonymousView.username)))
          {
            ad.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
            AppMethodBeat.o(29026);
            return;
          }
          final af localaf = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.bk.d.aCn().aIJ(paramAnonymousView.username));
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
                  com.tencent.mm.plugin.report.service.h.vKh.dB(931, 21);
                }
                com.tencent.mm.model.az.arV();
                af localaf = c.apM().aHY(paramAnonymousView.username);
                paramAnonymous2String2 = localaf;
                if ((int)localaf.fId == 0)
                {
                  localaf = localaf;
                  if (!bt.isNullOrNil(paramAnonymous2String1)) {
                    localaf.setUsername(paramAnonymous2String1);
                  }
                  com.tencent.mm.model.az.arV();
                  paramAnonymous2String2 = localaf;
                  if (!c.apM().af(localaf))
                  {
                    ad.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                    AppMethodBeat.o(29025);
                    return;
                  }
                }
                com.tencent.mm.model.w.u(paramAnonymous2String2);
                com.tencent.mm.bk.d.aCo().fM(paramAnonymousView.username, 1);
                com.tencent.mm.ui.base.h.cf(b.a(b.this), b.a(b.this).getString(2131755275));
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
                com.tencent.mm.bk.d.aCo().fM(paramAnonymousView.username, 2);
              }
              ad.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + paramAnonymousView.username);
              AppMethodBeat.o(29025);
            }
          });
          ad.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(paramAnonymousView.woZ));
          locala.aBJ(localaf.evP);
          locala.b(paramAnonymousView.username, localLinkedList, true);
        }
        AppMethodBeat.o(29026);
      }
    };
    this.yDz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29028);
        Object localObject1;
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          ad.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
          Object localObject2 = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          localObject1 = com.tencent.mm.bk.d.aCn().aIJ(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
          if ((localObject1 == null) || (((ba)localObject1).field_msgContent == null))
          {
            ad.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
            AppMethodBeat.o(29028);
            return;
          }
          paramAnonymousView = bl.d.aIR(((ba)localObject1).field_msgContent);
          ad.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username + ", opcode = MM_VERIFYUSER_VERIFYOK");
          if (paramAnonymousView.FAl == 1)
          {
            com.tencent.mm.ui.base.h.a(b.a(b.this), paramAnonymousView.FAm, null, b.a(b.this).getString(2131759472), b.a(b.this).getString(2131755691), true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29027);
                a.b(b.a(b.this), this.yDE);
                AppMethodBeat.o(29027);
              }
            }, null);
            AppMethodBeat.o(29028);
            return;
          }
          com.tencent.mm.model.az.arV();
          bw localbw = c.apN().agQ(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
          ((Intent)localObject1).putExtra("Contact_Nick", ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).nickname);
          if (localbw != null) {
            ((Intent)localObject1).putExtra("Contact_RemarkName", localbw.field_conRemark);
          }
          if (!bt.isNullOrNil(paramAnonymousView.chatroomName))
          {
            com.tencent.mm.model.az.arV();
            localObject2 = c.apV().tH(paramAnonymousView.chatroomName);
            if (localObject2 != null)
            {
              ((Intent)localObject1).putExtra("Contact_RoomNickname", ((com.tencent.mm.storage.w)localObject2).sh(paramAnonymousView.yGA));
              ((Intent)localObject1).putExtra("room_name", paramAnonymousView.chatroomName);
            }
          }
          ((Intent)localObject1).putExtra("Contact_Scene", paramAnonymousView.scene);
          ((Intent)localObject1).putExtra("Verify_ticket", paramAnonymousView.rso);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_send_verify", false);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_add_remark", true);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_set_label", true);
          ((Intent)localObject1).putExtra("sayhi_with_jump_to_profile", true);
          ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", 7);
          i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pxj, 0);
          paramAnonymousView = ".ui.SayHiWithSnsPermissionUI";
          if (i != 1) {
            break label432;
          }
          paramAnonymousView = ".ui.SayHiWithSnsPermissionUI2";
        }
        for (;;)
        {
          com.tencent.mm.bs.d.b(b.a(b.this), "profile", paramAnonymousView, (Intent)localObject1);
          AppMethodBeat.o(29028);
          return;
          label432:
          if (i == 2) {
            paramAnonymousView = ".ui.SayHiWithSnsPermissionUI3";
          }
        }
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(29030);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(29032);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setCursor(com.tencent.mm.bk.d.aCo().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(29032);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29024);
        b.a(b.this, com.tencent.mm.bk.d.aCo().getAll());
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(29024);
      }
    });
    AppMethodBeat.o(29032);
  }
  
  public final void We()
  {
    AppMethodBeat.i(29033);
    cHX();
    Wd();
    AppMethodBeat.o(29033);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29031);
    if (paramView == null)
    {
      paramView = y.js(this.context).inflate(2131494151, null);
      paramViewGroup = new a();
      paramViewGroup.yDG = ((MaskLayout)paramView.findViewById(2131300151));
      paramViewGroup.inR = ((TextView)paramView.findViewById(2131300157));
      paramViewGroup.yDL = ((TextView)paramView.findViewById(2131300153));
      paramViewGroup.inT = ((Button)paramView.findViewById(2131300148));
      paramViewGroup.inT.setOnClickListener(this.yDy);
      paramViewGroup.yDH = ((Button)paramView.findViewById(2131300161));
      paramViewGroup.yDH.setOnClickListener(this.yDz);
      paramViewGroup.yDI = ((TextView)paramView.findViewById(2131300159));
      paramViewGroup.yDJ = ((TextView)paramView.findViewById(2131300150));
      paramViewGroup.ibF = ((TextView)paramView.findViewById(2131300152));
      paramViewGroup.yDK = ((TextView)paramView.findViewById(2131300154));
      paramView.setTag(paramViewGroup);
    }
    ay localay;
    for (;;)
    {
      localay = (ay)getItem(paramInt);
      a.b.c((ImageView)paramViewGroup.yDG.getContentView(), localay.field_talker);
      paramViewGroup.inR.setText(k.b(this.context, localay.field_displayName, paramViewGroup.inR.getTextSize()));
      if (localay.field_fmsgSysRowId > 0L) {
        break label541;
      }
      ad.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = com.tencent.mm.bk.d.aCn().agg(localay.field_talker);
      if (localObject1 != null) {
        break;
      }
      ad.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localay.field_talker);
      paramViewGroup.inT.setVisibility(8);
      paramViewGroup.yDH.setVisibility(8);
      paramViewGroup.yDI.setVisibility(8);
      paramViewGroup.yDJ.setVisibility(8);
      paramViewGroup.yDL.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.c(this.context, (ba)localObject1);
    ad.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localay.field_talker);
    Object localObject2;
    if (localay.field_state == 1)
    {
      com.tencent.mm.model.az.arV();
      localObject2 = c.apM().aHY(localay.field_talker);
      if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fId != 0) && (!com.tencent.mm.n.b.ls(((au)localObject2).field_type))) {
        com.tencent.mm.bk.d.aCo().fM(localay.field_talker, 0);
      }
    }
    label541:
    long l;
    if (localObject1 == null)
    {
      ad.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localay.field_talker);
      paramViewGroup.inT.setVisibility(8);
      paramViewGroup.yDH.setVisibility(8);
      paramViewGroup.yDI.setVisibility(8);
      paramViewGroup.yDJ.setVisibility(8);
      paramViewGroup.yDL.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      localObject1 = this.context;
      l = localay.field_fmsgSysRowId;
      if (localay.field_fmsgIsSend % 2 == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a((Context)localObject1, l, bool, localay.field_talker, localay.field_fmsgContent, localay.field_fmsgType, localay.field_contentFromUsername, localay.field_contentNickname, localay.field_contentPhoneNumMD5, localay.field_contentFullPhoneNumMD5, localay.field_contentVerifyContent, localay.field_addScene);
        ad.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + localay.field_fmsgSysRowId + ", talker = " + localay.field_talker);
        break;
      }
    }
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).woZ = localay.field_addScene;
    paramViewGroup.yDL.setText(k.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).gKF, paramViewGroup.yDL.getTextSize()));
    int i;
    if ((localay.field_state == 0) && (ce.asR() - localay.field_lastModifiedTime >= 259200000L))
    {
      i = 3;
      localay.field_state = i;
      switch (localay.field_state)
      {
      default: 
        paramViewGroup.yDK.setVisibility(8);
        paramViewGroup.inT.setVisibility(8);
        paramViewGroup.yDH.setVisibility(8);
        paramViewGroup.yDI.setVisibility(8);
        paramViewGroup.yDJ.setVisibility(8);
        label821:
        paramView.findViewById(2131300156).setBackgroundResource(2131234801);
        l = ce.asR();
        if ((paramInt == 0) && (localay.field_lastModifiedTime + 259200000L >= l))
        {
          paramViewGroup.ibF.setVisibility(0);
          paramViewGroup.ibF.setText(this.context.getString(2131759481));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29031);
      return paramView;
      i = localay.field_state;
      break;
      if (localay.field_fmsgSysRowId <= 0L)
      {
        ad.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
        localObject2 = com.tencent.mm.bk.d.aCn().aIJ(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if (localObject2 == null)
        {
          i = 0;
          label940:
          if ((i != 0) && (i != 3)) {
            break label1027;
          }
          paramViewGroup.inT.setVisibility(0);
          paramViewGroup.inT.setTag(localObject1);
          paramViewGroup.yDH.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup.yDI.setVisibility(8);
        paramViewGroup.yDJ.setVisibility(8);
        paramViewGroup.yDK.setVisibility(8);
        break;
        i = ((ba)localObject2).field_type;
        break label940;
        i = localay.field_recvFmsgType;
        break label940;
        label1027:
        paramViewGroup.yDH.setVisibility(0);
        paramViewGroup.yDH.setTag(localObject1);
        paramViewGroup.inT.setVisibility(8);
      }
      paramViewGroup.yDI.setVisibility(0);
      paramViewGroup.inT.setVisibility(8);
      paramViewGroup.yDH.setVisibility(8);
      paramViewGroup.yDJ.setVisibility(8);
      paramViewGroup.yDK.setVisibility(8);
      break label821;
      paramViewGroup.yDJ.setVisibility(0);
      paramViewGroup.inT.setVisibility(8);
      paramViewGroup.yDH.setVisibility(8);
      paramViewGroup.yDI.setVisibility(8);
      paramViewGroup.yDK.setVisibility(8);
      break label821;
      paramViewGroup.yDK.setVisibility(0);
      paramViewGroup.inT.setVisibility(8);
      paramViewGroup.yDH.setVisibility(8);
      paramViewGroup.yDI.setVisibility(8);
      paramViewGroup.yDJ.setVisibility(8);
      break label821;
      if (((paramInt == 0) || (((ay)getItem(paramInt - 1)).field_lastModifiedTime + 259200000L >= l)) && (((ay)getItem(paramInt)).field_lastModifiedTime + 259200000L < l))
      {
        paramViewGroup.ibF.setVisibility(0);
        paramViewGroup.ibF.setText(this.context.getString(2131759480));
      }
      else
      {
        paramViewGroup.ibF.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public TextView ibF;
    public TextView inR;
    public Button inT;
    public MaskLayout yDG;
    public Button yDH;
    public TextView yDI;
    public TextView yDJ;
    public TextView yDK;
    public TextView yDL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */