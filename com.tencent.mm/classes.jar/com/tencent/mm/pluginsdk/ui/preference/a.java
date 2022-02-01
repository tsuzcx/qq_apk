package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.bj.c;
import com.tencent.mm.bj.d;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;

public final class a
  extends LinearLayout
  implements i
{
  private static a KoZ;
  private Button Kpa;
  private Context context;
  private TextView hXC;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(31814);
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131494713, this);
    this.hXC = ((TextView)paramContext.findViewById(2131301619));
    this.Kpa = ((Button)paramContext.findViewById(2131301620));
    this.Kpa.setOnClickListener(new a.1(this));
    AppMethodBeat.o(31814);
  }
  
  private static int bfb(String paramString)
  {
    AppMethodBeat.i(31816);
    if (paramString == null)
    {
      Log.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
      AppMethodBeat.o(31816);
      return 6;
    }
    switch (ca.d.bkD(paramString).dKy)
    {
    case 3: 
    case 4: 
    default: 
      AppMethodBeat.o(31816);
      return 6;
    case 2: 
    case 5: 
      AppMethodBeat.o(31816);
      return 6;
    }
    AppMethodBeat.o(31816);
    return 5;
  }
  
  public static void setFMessageArgs(a parama)
  {
    KoZ = parama;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31815);
    bg.azz().b(30, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(31815);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(31819);
    if (paramq.getType() != 30)
    {
      AppMethodBeat.o(31819);
      return;
    }
    Log.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = ((p)paramq).dKy;
      paramString = ((p)paramq).JVk;
      Log.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + paramInt1 + ", verifyContent = " + paramString);
      Log.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + KoZ.type);
      switch (KoZ.type)
      {
      default: 
        paramq = new bn();
        paramq.field_createTime = c.C(KoZ.talker, 0L);
        paramq.field_isSend = 1;
        paramq.field_msgContent = paramString;
        paramq.field_talker = KoZ.talker;
        if (paramInt1 != 5) {
          break;
        }
      }
      for (paramInt1 = 2;; paramInt1 = 3)
      {
        paramq.field_type = paramInt1;
        Log.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = ".concat(String.valueOf(d.bgM().b(paramq))));
        for (;;)
        {
          bg.azz().b(30, this);
          AppMethodBeat.o(31819);
          return;
          paramq = new bx();
          paramq.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().aEr(KoZ.talker);
          paramq.field_isSend = 1;
          paramq.field_content = paramString;
          paramq.field_talker = "fmessage";
          paramq.field_sayhiuser = KoZ.talker;
          paramq.field_svrid = System.currentTimeMillis();
          paramq.field_status = 4;
          d.bgO().a(paramq);
          continue;
          paramq = new cl();
          paramq.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiu().aEr(KoZ.talker);
          paramq.field_isSend = 1;
          paramq.field_content = paramString;
          paramq.field_talker = "fmessage";
          paramq.field_sayhiuser = KoZ.talker;
          paramq.field_svrid = System.currentTimeMillis();
          paramq.field_status = 4;
          Log.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(d.bgP().a(paramq))));
        }
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -34)) {
      paramq = this.context.getString(2131760794);
    }
    for (;;)
    {
      Toast.makeText(this.context, paramq, 1).show();
      break;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramq = this.context.getString(2131760797);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramq = paramString;
        if (!Util.isNullOrNil(paramString)) {}
      }
      else
      {
        paramq = this.context.getString(2131765235);
      }
    }
  }
  
  public final void setBtnVisibility(int paramInt)
  {
    AppMethodBeat.i(31818);
    if (this.Kpa != null) {
      this.Kpa.setVisibility(paramInt);
    }
    AppMethodBeat.o(31818);
  }
  
  public final void setContentText(String paramString)
  {
    AppMethodBeat.i(31817);
    if (Util.isNullOrNil(paramString))
    {
      this.hXC.setVisibility(8);
      AppMethodBeat.o(31817);
      return;
    }
    this.hXC.setVisibility(0);
    this.hXC.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Util.nullAsNil(paramString), this.hXC.getTextSize()));
    AppMethodBeat.o(31817);
  }
  
  public static final class a
  {
    public String Kpf;
    public int scene;
    public String talker;
    public int type;
    public String wZz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a
 * JD-Core Version:    0.7.0.1
 */