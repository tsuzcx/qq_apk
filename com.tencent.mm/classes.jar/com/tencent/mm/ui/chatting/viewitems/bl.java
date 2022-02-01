package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.fcu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.ax;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

public final class bl
  extends c
{
  private ProgressDialog JfW;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private com.tencent.mm.an.i onSceneEndCallback;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37500);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.eeu);
      ((View)localObject).setTag(new br().it((View)localObject));
    }
    AppMethodBeat.o(37500);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
  {
    AppMethodBeat.i(37501);
    paramString = (br)parama;
    this.WBq = parama1;
    parama = ao.hhH().NR(paramca.field_msgId);
    parama1 = paramca.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = k.b.OQ(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = e.bdO(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.MdU == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.pluginsdk.j.f.aR(this.WBq.WQv.getContext(), parama1.MdU);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.mrM.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.Xmr.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.Xms.setText(localObject1[1]);
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          long l;
          Object localObject3;
          Log.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", localException, "", new Object[0]);
          continue;
          paramString.Xmv.setVisibility(8);
          paramString.mrM.setTextColor(this.WBq.WQv.getMMResources().getColor(R.e.dkP));
          paramString.Xms.setTextColor(this.WBq.WQv.getMMResources().getColor(R.e.dkP));
          paramString.Xmr.setTextColor(this.WBq.WQv.getMMResources().getColor(R.e.dkP));
          continue;
          int i = 0;
          continue;
          paramString.Xmt.setBackgroundResource(R.g.dpv);
          continue;
        }
        bool1 = ae.xX(parama1.MdU);
        if (!bool1) {
          continue;
        }
        paramString.Xmv.setVisibility(0);
        paramString.mrM.setTextColor(this.WBq.WQv.getMMResources().getColor(R.e.dkQ));
        paramString.Xms.setTextColor(this.WBq.WQv.getMMResources().getColor(R.e.dkQ));
        paramString.Xmr.setTextColor(this.WBq.WQv.getMMResources().getColor(R.e.dkQ));
        paramString.Xmt.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37493);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (ae.isNullOrNil(paramca.field_imgPath))
            {
              Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37493);
              return;
            }
            ((ax)bl.a(bl.this).bC(ax.class)).hQU().b(paramInt, paramca);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37493);
          }
        });
        l = paramca.field_msgId;
        localObject1 = ((ax)this.WBq.bC(ax.class)).hQU();
        if ((localObject1 == null) || (!((d)localObject1).isPlaying()) || (((d)localObject1).WxA != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.Xmt.setBackgroundResource(R.g.dpu);
        if ((parama1 != null) && (!ae.isNullOrNil(parama1.MdW)) && (parama1.MdX > 0) && (ae.isNullOrNil(paramca.field_reserved)) && (parama != null))
        {
          localObject1 = k.XS(z.bcZ());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.cN((String)localObject1, false);
          paramca.Jo((String)localObject1);
          bh.beI();
          com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
          localObject1 = m.a((String)localObject2, paramca.field_msgId, parama.sdkVer, parama.appId, parama1.MdW, parama1.MdX, parama.type, parama.lmb);
          if (localObject1 != null)
          {
            localObject2 = bh.aGY();
            localObject3 = new com.tencent.mm.an.i()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
              {
                AppMethodBeat.i(37494);
                Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousq.getType());
                boolean bool = false;
                if (az.a.ltu != null) {
                  bool = az.a.ltu.Gj(paramca.field_msgId);
                }
                if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.f)paramAnonymousq).getMediaId().equals(this.acq)))
                {
                  paramAnonymousString = ca.bs(paramca);
                  paramAnonymousString.Jn(paramca.field_reserved);
                  paramAnonymousString.setMsgId(-1L);
                  ((ax)bl.a(bl.this).bC(ax.class)).hQU().b(paramInt, paramAnonymousString);
                }
                bh.aGY().b(221, bl.b(bl.this));
                bl.a(bl.this, null);
                AppMethodBeat.o(37494);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.an.i)localObject3);
            ((t)localObject2).a(221, (com.tencent.mm.an.i)localObject3);
            localObject1 = new com.tencent.mm.plugin.record.b.f((String)localObject1);
            ((com.tencent.mm.plugin.record.b.f)localObject1).fur();
            bh.aGY().a((q)localObject1, 0);
          }
        }
        if ((ae.isNullOrNil(paramca.field_imgPath)) && (parama1.Mea > 0))
        {
          bh.beI();
          localObject1 = com.tencent.mm.model.c.bbO().aL(paramca.field_talker, parama1.Mea);
          if (!ae.isNullOrNil(((et)localObject1).field_imgPath))
          {
            localObject2 = k.XS(z.bcZ());
            localObject3 = com.tencent.mm.plugin.subapp.d.h.cN((String)localObject2, false);
            if (u.on(com.tencent.mm.plugin.subapp.d.h.cN(((et)localObject1).field_imgPath, false), (String)localObject3) >= 0L)
            {
              paramca.Jn((String)localObject2);
              bh.beI();
              com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
            }
          }
        }
        if ((ae.isNullOrNil(paramca.field_imgPath)) && (parama1 != null) && (!ae.isNullOrNil(parama1.fvr)) && (parama1.llX > 0) && (this.onSceneEndCallback == null))
        {
          localObject1 = k.XS(z.bcZ());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.cN((String)localObject1, false);
          paramca.Jn((String)localObject1);
          bh.beI();
          com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
          parama = m.a((String)localObject2, paramca.field_msgId, parama.sdkVer, parama.appId, parama.fvr, parama.llX);
          Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = bh.aGY();
            localObject2 = new com.tencent.mm.an.i()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
              {
                AppMethodBeat.i(37495);
                Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousq.getType());
                if (((com.tencent.mm.plugin.record.b.f)paramAnonymousq).getMediaId().equals(parama.field_mediaSvrId))
                {
                  bh.aGY().b(221, bl.b(bl.this));
                  bl.a(bl.this, null);
                }
                AppMethodBeat.o(37495);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.an.i)localObject2);
            ((t)localObject1).a(221, (com.tencent.mm.an.i)localObject2);
            parama = new com.tencent.mm.plugin.record.b.f(parama);
            bh.aGY().a(parama, 0);
          }
        }
        paramString.Xmu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37499);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            com.tencent.mm.ui.base.h.a(bl.a(bl.this).WQv.getContext(), R.l.eVl, R.l.eVn, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(37498);
                bh.aGY().a(331, bl.a(bl.this, new com.tencent.mm.an.i()
                {
                  public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, q paramAnonymous3q)
                  {
                    AppMethodBeat.i(37496);
                    Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymous3Int1 + " errCode " + paramAnonymous3Int2 + "  scene " + paramAnonymous3q.getType());
                    if ((paramAnonymous3Int1 == 0) && (paramAnonymous3Int2 == 0))
                    {
                      paramAnonymous3String = bl.4.this.XlZ.field_content;
                      if (paramAnonymous3String == null) {
                        break label242;
                      }
                    }
                    label242:
                    for (paramAnonymous3String = k.b.OQ(paramAnonymous3String);; paramAnonymous3String = null)
                    {
                      if (paramAnonymous3String != null) {
                        m.TS(bl.4.this.XlZ.field_msgId);
                      }
                      bq.Gk(bl.4.this.XlZ.field_msgId);
                      Toast.makeText(bl.a(bl.this).WQv.getContext(), bl.a(bl.this).WQv.getMMResources().getString(R.l.evD), 0).show();
                      bh.aGY().b(331, bl.b(bl.this));
                      bl.a(bl.this, null);
                      if (bl.c(bl.this) != null) {
                        bl.c(bl.this).dismiss();
                      }
                      AppMethodBeat.o(37496);
                      return;
                    }
                  }
                }));
                paramAnonymous2DialogInterface = new LinkedList();
                Object localObject = new fcu();
                ((fcu)localObject).RJS = bl.4.this.Xmd.MdV;
                paramAnonymous2DialogInterface.add(localObject);
                paramAnonymous2DialogInterface = new com.tencent.mm.plugin.subapp.d.a(paramAnonymous2DialogInterface, paramAnonymous2DialogInterface.size());
                bh.aGY().a(paramAnonymous2DialogInterface, 0);
                localObject = bl.this;
                Activity localActivity = bl.a(bl.this).WQv.getContext();
                bl.a(bl.this).WQv.getMMResources().getString(R.l.app_tip);
                bl.a((bl)localObject, com.tencent.mm.ui.base.h.a(localActivity, bl.a(bl.this).WQv.getMMResources().getString(R.l.evE), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(37497);
                    bh.aGY().a(paramAnonymous2DialogInterface);
                    bh.aGY().b(331, bl.b(bl.this));
                    bl.a(bl.this, null);
                    if (bl.c(bl.this) != null) {
                      bl.c(bl.this).dismiss();
                    }
                    AppMethodBeat.o(37497);
                  }
                }));
                AppMethodBeat.o(37498);
              }
            }, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37499);
          }
        });
        paramString.clickArea.setTag(new by(paramca, this.WBq.hRi(), paramInt, null, '\000'));
        bh.beI();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.clickArea.setOnLongClickListener(c(this.WBq));
        }
        AppMethodBeat.o(37501);
        return;
        paramString.mrM.setText("");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37503);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37503);
      return false;
    }
    paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37503);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(246489);
    int i = ((by)paramView.getTag()).position;
    int j = m.bqe(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    paramView = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    if ((paramView.llX <= 0) || ((paramView.llX > 0) && (j >= 100))) {
      paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (!this.WBq.hRj()) {
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(246489);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048189;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return true;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bl
 * JD-Core Version:    0.7.0.1
 */