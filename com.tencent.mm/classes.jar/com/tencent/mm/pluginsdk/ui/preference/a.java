package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.c;
import com.tencent.mm.bi.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;

public final class a
  extends LinearLayout
  implements com.tencent.mm.ai.f
{
  private static a.a waB;
  private Context context;
  private TextView gMp;
  private com.tencent.mm.ui.base.p tipDialog;
  private Button waC;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(28030);
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2130969617, this);
    this.gMp = ((TextView)paramContext.findViewById(2131824228));
    this.waC = ((Button)paramContext.findViewById(2131824229));
    this.waC.setOnClickListener(new a.1(this));
    AppMethodBeat.o(28030);
  }
  
  private static int amu(String paramString)
  {
    AppMethodBeat.i(28032);
    if (paramString == null)
    {
      ab.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
      AppMethodBeat.o(28032);
      return 6;
    }
    switch (bi.d.asm(paramString).cut)
    {
    case 3: 
    case 4: 
    default: 
      AppMethodBeat.o(28032);
      return 6;
    case 2: 
    case 5: 
      AppMethodBeat.o(28032);
      return 6;
    }
    AppMethodBeat.o(28032);
    return 5;
  }
  
  public static void setFMessageArgs(a.a parama)
  {
    waB = parama;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(28031);
    aw.Rc().b(30, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(28031);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(28035);
    if (paramm.getType() != 30)
    {
      AppMethodBeat.o(28035);
      return;
    }
    ab.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).cut;
      paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).vKt;
      ab.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + paramInt1 + ", verifyContent = " + paramString);
      ab.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + waB.type);
      switch (waB.type)
      {
      default: 
        paramm = new ax();
        paramm.field_createTime = c.x(waB.talker, 0L);
        paramm.field_isSend = 1;
        paramm.field_msgContent = paramString;
        paramm.field_talker = waB.talker;
        if (paramInt1 != 5) {
          break;
        }
      }
      for (paramInt1 = 2;; paramInt1 = 3)
      {
        paramm.field_type = paramInt1;
        ab.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = ".concat(String.valueOf(d.alh().b(paramm))));
        for (;;)
        {
          aw.Rc().b(30, this);
          AppMethodBeat.o(28035);
          return;
          paramm = new bf();
          paramm.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPN().Tg(waB.talker);
          paramm.field_isSend = 1;
          paramm.field_content = paramString;
          paramm.field_talker = "fmessage";
          paramm.field_sayhiuser = waB.talker;
          paramm.field_svrid = System.currentTimeMillis();
          paramm.field_status = 4;
          d.alj().a(paramm);
          continue;
          paramm = new bt();
          paramm.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPM().Tg(waB.talker);
          paramm.field_isSend = 1;
          paramm.field_content = paramString;
          paramm.field_talker = "fmessage";
          paramm.field_sayhiuser = waB.talker;
          paramm.field_svrid = System.currentTimeMillis();
          paramm.field_status = 4;
          ab.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(d.alk().a(paramm))));
        }
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -34)) {
      paramm = this.context.getString(2131300013);
    }
    for (;;)
    {
      Toast.makeText(this.context, paramm, 1).show();
      break;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramm = this.context.getString(2131300016);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramm = paramString;
        if (!bo.isNullOrNil(paramString)) {}
      }
      else
      {
        paramm = this.context.getString(2131303126);
      }
    }
  }
  
  public final void setBtnVisibility(int paramInt)
  {
    AppMethodBeat.i(28034);
    if (this.waC != null) {
      this.waC.setVisibility(paramInt);
    }
    AppMethodBeat.o(28034);
  }
  
  public final void setContentText(String paramString)
  {
    AppMethodBeat.i(28033);
    if (bo.isNullOrNil(paramString))
    {
      this.gMp.setVisibility(8);
      AppMethodBeat.o(28033);
      return;
    }
    this.gMp.setVisibility(0);
    this.gMp.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, bo.nullAsNil(paramString), this.gMp.getTextSize()));
    AppMethodBeat.o(28033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a
 * JD-Core Version:    0.7.0.1
 */