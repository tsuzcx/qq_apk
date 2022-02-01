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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public final class b
  extends r<bb>
{
  private Context context;
  private View.OnClickListener zQM;
  private View.OnClickListener zQN;
  
  public b(Context paramContext)
  {
    super(paramContext, new bb());
    AppMethodBeat.i(29030);
    this.zQM = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(29026);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          ac.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
          paramAnonymousView = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          if ((paramAnonymousView == null) || (bs.isNullOrNil(paramAnonymousView.username)))
          {
            ac.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
            AppMethodBeat.o(29026);
            return;
          }
          final ai localai = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.bj.d.aJd().aOf(paramAnonymousView.username));
          com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(b.a(b.this), new a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              AppMethodBeat.i(29025);
              if (paramAnonymous2Boolean1)
              {
                if (bs.isNullOrNil(paramAnonymous2String1))
                {
                  ac.w("MicroMsg.FMessageConversationUI", "addContact respUsername is empty");
                  com.tencent.mm.plugin.report.service.h.wUl.dB(931, 21);
                }
                az.ayM();
                ai localai = c.awB().aNt(paramAnonymousView.username);
                paramAnonymous2String2 = localai;
                if ((int)localai.fLJ == 0)
                {
                  localai = localai;
                  if (!bs.isNullOrNil(paramAnonymous2String1)) {
                    localai.setUsername(paramAnonymous2String1);
                  }
                  az.ayM();
                  paramAnonymous2String2 = localai;
                  if (!c.awB().ag(localai))
                  {
                    ac.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                    AppMethodBeat.o(29025);
                    return;
                  }
                }
                w.u(paramAnonymous2String2);
                com.tencent.mm.bj.d.aJe().fQ(paramAnonymousView.username, 1);
                com.tencent.mm.ui.base.h.cg(b.a(b.this), b.a(b.this).getString(2131755275));
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
                com.tencent.mm.bj.d.aJe().fQ(paramAnonymousView.username, 2);
              }
              ac.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + paramAnonymousView.username);
              AppMethodBeat.o(29025);
            }
          });
          ac.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + paramAnonymousView.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(paramAnonymousView.xAq));
          locala.aHb(localai.eym);
          locala.b(paramAnonymousView.username, localLinkedList, true);
        }
        AppMethodBeat.o(29026);
      }
    };
    this.zQN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29028);
        Object localObject1;
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
        {
          ac.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
          Object localObject2 = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
          localObject1 = com.tencent.mm.bj.d.aJd().aOf(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
          if ((localObject1 == null) || (((bd)localObject1).field_msgContent == null))
          {
            ac.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
            AppMethodBeat.o(29028);
            return;
          }
          paramAnonymousView = bo.d.aOn(((bd)localObject1).field_msgContent);
          ac.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username + ", opcode = MM_VERIFYUSER_VERIFYOK");
          if (paramAnonymousView.GZn == 1)
          {
            com.tencent.mm.ui.base.h.a(b.a(b.this), paramAnonymousView.GZo, null, b.a(b.this).getString(2131759472), b.a(b.this).getString(2131755691), true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(29027);
                a.b(b.a(b.this), this.zQS);
                AppMethodBeat.o(29027);
              }
            }, null);
            AppMethodBeat.o(29028);
            return;
          }
          az.ayM();
          bz localbz = c.awC().alK(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Contact_User", ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).username);
          ((Intent)localObject1).putExtra("Contact_Nick", ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).nickname);
          if (localbz != null) {
            ((Intent)localObject1).putExtra("Contact_RemarkName", localbz.field_conRemark);
          }
          if (!bs.isNullOrNil(paramAnonymousView.chatroomName))
          {
            az.ayM();
            localObject2 = c.awK().xN(paramAnonymousView.chatroomName);
            if (localObject2 != null)
            {
              ((Intent)localObject1).putExtra("Contact_RoomNickname", ((x)localObject2).wk(paramAnonymousView.zTO));
              ((Intent)localObject1).putExtra("room_name", paramAnonymousView.chatroomName);
            }
          }
          ((Intent)localObject1).putExtra("Contact_Scene", paramAnonymousView.scene);
          ((Intent)localObject1).putExtra("Verify_ticket", paramAnonymousView.sBi);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_send_verify", false);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_add_remark", true);
          ((Intent)localObject1).putExtra("sayhi_with_sns_perm_set_label", true);
          ((Intent)localObject1).putExtra("sayhi_with_jump_to_profile", true);
          ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", 7);
          i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbC, 0);
          paramAnonymousView = ".ui.SayHiWithSnsPermissionUI";
          if (i != 1) {
            break label432;
          }
          paramAnonymousView = ".ui.SayHiWithSnsPermissionUI2";
        }
        for (;;)
        {
          com.tencent.mm.br.d.b(b.a(b.this), "profile", paramAnonymousView, (Intent)localObject1);
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
  
  public final void Xb()
  {
    AppMethodBeat.i(29032);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setCursor(com.tencent.mm.bj.d.aJe().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(29032);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29024);
        b.a(b.this, com.tencent.mm.bj.d.aJe().getAll());
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(29024);
      }
    });
    AppMethodBeat.o(29032);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(29033);
    cVi();
    Xb();
    AppMethodBeat.o(29033);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29031);
    if (paramView == null)
    {
      paramView = z.jD(this.context).inflate(2131494151, null);
      paramViewGroup = new a();
      paramViewGroup.zQU = ((MaskLayout)paramView.findViewById(2131300151));
      paramViewGroup.iNX = ((TextView)paramView.findViewById(2131300157));
      paramViewGroup.zQZ = ((TextView)paramView.findViewById(2131300153));
      paramViewGroup.iNZ = ((Button)paramView.findViewById(2131300148));
      paramViewGroup.iNZ.setOnClickListener(this.zQM);
      paramViewGroup.zQV = ((Button)paramView.findViewById(2131300161));
      paramViewGroup.zQV.setOnClickListener(this.zQN);
      paramViewGroup.zQW = ((TextView)paramView.findViewById(2131300159));
      paramViewGroup.zQX = ((TextView)paramView.findViewById(2131300150));
      paramViewGroup.iBM = ((TextView)paramView.findViewById(2131300152));
      paramViewGroup.zQY = ((TextView)paramView.findViewById(2131300154));
      paramView.setTag(paramViewGroup);
    }
    bb localbb;
    for (;;)
    {
      localbb = (bb)getItem(paramInt);
      a.b.c((ImageView)paramViewGroup.zQU.getContentView(), localbb.field_talker);
      paramViewGroup.iNX.setText(k.b(this.context, localbb.field_displayName, paramViewGroup.iNX.getTextSize()));
      if (localbb.field_fmsgSysRowId > 0L) {
        break label541;
      }
      ac.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = com.tencent.mm.bj.d.aJd().ala(localbb.field_talker);
      if (localObject1 != null) {
        break;
      }
      ac.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localbb.field_talker);
      paramViewGroup.iNZ.setVisibility(8);
      paramViewGroup.zQV.setVisibility(8);
      paramViewGroup.zQW.setVisibility(8);
      paramViewGroup.zQX.setVisibility(8);
      paramViewGroup.zQZ.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.c(this.context, (bd)localObject1);
    ac.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localbb.field_talker);
    Object localObject2;
    if (localbb.field_state == 1)
    {
      az.ayM();
      localObject2 = c.awB().aNt(localbb.field_talker);
      if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fLJ != 0) && (!com.tencent.mm.n.b.ln(((av)localObject2).field_type))) {
        com.tencent.mm.bj.d.aJe().fQ(localbb.field_talker, 0);
      }
    }
    label541:
    long l;
    if (localObject1 == null)
    {
      ac.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localbb.field_talker);
      paramViewGroup.iNZ.setVisibility(8);
      paramViewGroup.zQV.setVisibility(8);
      paramViewGroup.zQW.setVisibility(8);
      paramViewGroup.zQX.setVisibility(8);
      paramViewGroup.zQZ.setVisibility(8);
      AppMethodBeat.o(29031);
      return paramView;
      localObject1 = this.context;
      l = localbb.field_fmsgSysRowId;
      if (localbb.field_fmsgIsSend % 2 == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a((Context)localObject1, l, bool, localbb.field_talker, localbb.field_fmsgContent, localbb.field_fmsgType, localbb.field_contentFromUsername, localbb.field_contentNickname, localbb.field_contentPhoneNumMD5, localbb.field_contentFullPhoneNumMD5, localbb.field_contentVerifyContent, localbb.field_addScene);
        ac.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + localbb.field_fmsgSysRowId + ", talker = " + localbb.field_talker);
        break;
      }
    }
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).xAq = localbb.field_addScene;
    paramViewGroup.zQZ.setText(k.b(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).hlf, paramViewGroup.zQZ.getTextSize()));
    int i;
    if ((localbb.field_state == 0) && (ce.azI() - localbb.field_lastModifiedTime >= 259200000L))
    {
      i = 3;
      localbb.field_state = i;
      switch (localbb.field_state)
      {
      default: 
        paramViewGroup.zQY.setVisibility(8);
        paramViewGroup.iNZ.setVisibility(8);
        paramViewGroup.zQV.setVisibility(8);
        paramViewGroup.zQW.setVisibility(8);
        paramViewGroup.zQX.setVisibility(8);
        label821:
        paramView.findViewById(2131300156).setBackgroundResource(2131234801);
        l = ce.azI();
        if ((paramInt == 0) && (localbb.field_lastModifiedTime + 259200000L >= l))
        {
          paramViewGroup.iBM.setVisibility(0);
          paramViewGroup.iBM.setText(this.context.getString(2131759481));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29031);
      return paramView;
      i = localbb.field_state;
      break;
      if (localbb.field_fmsgSysRowId <= 0L)
      {
        ac.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
        localObject2 = com.tencent.mm.bj.d.aJd().aOf(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if (localObject2 == null)
        {
          i = 0;
          label940:
          if ((i != 0) && (i != 3)) {
            break label1027;
          }
          paramViewGroup.iNZ.setVisibility(0);
          paramViewGroup.iNZ.setTag(localObject1);
          paramViewGroup.zQV.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup.zQW.setVisibility(8);
        paramViewGroup.zQX.setVisibility(8);
        paramViewGroup.zQY.setVisibility(8);
        break;
        i = ((bd)localObject2).field_type;
        break label940;
        i = localbb.field_recvFmsgType;
        break label940;
        label1027:
        paramViewGroup.zQV.setVisibility(0);
        paramViewGroup.zQV.setTag(localObject1);
        paramViewGroup.iNZ.setVisibility(8);
      }
      paramViewGroup.zQW.setVisibility(0);
      paramViewGroup.iNZ.setVisibility(8);
      paramViewGroup.zQV.setVisibility(8);
      paramViewGroup.zQX.setVisibility(8);
      paramViewGroup.zQY.setVisibility(8);
      break label821;
      paramViewGroup.zQX.setVisibility(0);
      paramViewGroup.iNZ.setVisibility(8);
      paramViewGroup.zQV.setVisibility(8);
      paramViewGroup.zQW.setVisibility(8);
      paramViewGroup.zQY.setVisibility(8);
      break label821;
      paramViewGroup.zQY.setVisibility(0);
      paramViewGroup.iNZ.setVisibility(8);
      paramViewGroup.zQV.setVisibility(8);
      paramViewGroup.zQW.setVisibility(8);
      paramViewGroup.zQX.setVisibility(8);
      break label821;
      if (((paramInt == 0) || (((bb)getItem(paramInt - 1)).field_lastModifiedTime + 259200000L >= l)) && (((bb)getItem(paramInt)).field_lastModifiedTime + 259200000L < l))
      {
        paramViewGroup.iBM.setVisibility(0);
        paramViewGroup.iBM.setText(this.context.getString(2131759480));
      }
      else
      {
        paramViewGroup.iBM.setVisibility(8);
      }
    }
  }
  
  static final class a
  {
    public TextView iBM;
    public TextView iNX;
    public Button iNZ;
    public MaskLayout zQU;
    public Button zQV;
    public TextView zQW;
    public TextView zQX;
    public TextView zQY;
    public TextView zQZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */