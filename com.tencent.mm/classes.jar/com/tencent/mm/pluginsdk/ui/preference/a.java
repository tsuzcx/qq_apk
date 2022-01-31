package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bh.c;
import com.tencent.mm.bh.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;

public final class a
  extends LinearLayout
  implements com.tencent.mm.ah.f
{
  private static a.a sib;
  private Context context;
  private TextView fuN;
  private Button sic;
  com.tencent.mm.ui.base.p tipDialog;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    paramContext = View.inflate(this.context, R.i.fmessage_item_view, this);
    this.fuN = ((TextView)paramContext.findViewById(R.h.fmessage_item_view_content_tv));
    this.sic = ((Button)paramContext.findViewById(R.h.fmessage_item_view_reply_btn));
    this.sic.setOnClickListener(new a.1(this));
  }
  
  private static int WO(String paramString)
  {
    if (paramString == null)
    {
      y.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
      return 6;
    }
    switch (bi.d.acc(paramString).bNb)
    {
    case 2: 
    case 5: 
    case 3: 
    case 4: 
    default: 
      return 6;
    }
    return 5;
  }
  
  public static void setFMessageArgs(a.a parama)
  {
    sib = parama;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (paramm.getType() != 30) {
      return;
    }
    y.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).bNb;
      paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).rTw;
      y.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + paramInt1 + ", verifyContent = " + paramString);
      y.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + sib.type);
      switch (sib.type)
      {
      default: 
        paramm = new ax();
        paramm.field_createTime = c.o(sib.talker, 0L);
        paramm.field_isSend = 1;
        paramm.field_msgContent = paramString;
        paramm.field_talker = sib.talker;
        if (paramInt1 != 5) {
          break;
        }
      }
      for (paramInt1 = 2;; paramInt1 = 3)
      {
        paramm.field_type = paramInt1;
        boolean bool = d.RX().b(paramm);
        y.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = " + bool);
        for (;;)
        {
          au.Dk().b(30, this);
          return;
          paramm = new bf();
          paramm.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhL().Hu(sib.talker);
          paramm.field_isSend = 1;
          paramm.field_content = paramString;
          paramm.field_talker = "fmessage";
          paramm.field_sayhiuser = sib.talker;
          paramm.field_svrid = System.currentTimeMillis();
          paramm.field_status = 4;
          d.RZ().a(paramm);
          continue;
          paramm = new bt();
          paramm.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhK().Hu(sib.talker);
          paramm.field_isSend = 1;
          paramm.field_content = paramString;
          paramm.field_talker = "fmessage";
          paramm.field_sayhiuser = sib.talker;
          paramm.field_svrid = System.currentTimeMillis();
          paramm.field_status = 4;
          bool = d.Sa().a(paramm);
          y.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = " + bool);
        }
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -34)) {
      paramm = this.context.getString(R.l.fmessage_request_too_offen);
    }
    for (;;)
    {
      Toast.makeText(this.context, paramm, 1).show();
      break;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramm = this.context.getString(R.l.fmessage_user_not_support);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramm = paramString;
        if (!bk.bl(paramString)) {}
      }
      else
      {
        paramm = this.context.getString(R.l.sendrequest_send_fail);
      }
    }
  }
  
  public final void setBtnVisibility(int paramInt)
  {
    if (this.sic != null) {
      this.sic.setVisibility(paramInt);
    }
  }
  
  public final void setContentText(String paramString)
  {
    this.fuN.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, bk.pm(paramString), this.fuN.getTextSize()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a
 * JD-Core Version:    0.7.0.1
 */