package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.bl.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

public final class a
  extends LinearLayout
  implements i
{
  private static a RpQ;
  private Button RpR;
  private Context context;
  private TextView kMh;
  private s tipDialog;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(31814);
    this.context = paramContext;
    paramContext = View.inflate(this.context, R.i.ehq, this);
    this.kMh = ((TextView)paramContext.findViewById(R.h.dHA));
    this.RpR = ((Button)paramContext.findViewById(R.h.dHB));
    this.RpR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31812);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/FMessageItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = View.inflate(a.a(a.this), R.i.sendrequest_dialog, null);
        ((TextView)paramAnonymousView.findViewById(R.h.sendrequest_tip)).setVisibility(8);
        localObject = (TextView)paramAnonymousView.findViewById(R.h.wordcount);
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText("50");
        final EditText localEditText = (EditText)paramAnonymousView.findViewById(R.h.sendrequest_content);
        localEditText.setSingleLine(false);
        com.tencent.mm.ui.tools.b.c.i(localEditText).axx(100).a(null);
        localEditText.addTextChangedListener(new a.1.1(this, (TextView)localObject));
        com.tencent.mm.ui.base.h.a(a.a(a.this), a.a(a.this).getString(R.l.app_reply), paramAnonymousView, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(31810);
            paramAnonymous2DialogInterface = localEditText.getText().toString().trim();
            if ((paramAnonymous2DialogInterface != null) && (paramAnonymous2DialogInterface.length() > 0)) {
              try
              {
                a.a(a.this, paramAnonymous2DialogInterface);
                AppMethodBeat.o(31810);
                return;
              }
              catch (ArrayIndexOutOfBoundsException paramAnonymous2DialogInterface)
              {
                Log.printErrStackTrace("MicroMsg.FMessageItemView", paramAnonymous2DialogInterface, "", new Object[0]);
                if ((a.b(a.this) != null) && (a.b(a.this).isShowing())) {
                  a.b(a.this).dismiss();
                }
              }
            }
            AppMethodBeat.o(31810);
          }
        }, null);
        localEditText.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(31811);
            if ((a.a(a.this) instanceof MMActivity)) {
              ((MMActivity)a.a(a.this)).showVKB();
            }
            AppMethodBeat.o(31811);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/FMessageItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(31812);
      }
    });
    AppMethodBeat.o(31814);
  }
  
  private static int brx(String paramString)
  {
    AppMethodBeat.i(31816);
    if (paramString == null)
    {
      Log.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
      AppMethodBeat.o(31816);
      return 6;
    }
    switch (ca.d.bxc(paramString).fDn)
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
    RpQ = parama;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31815);
    bh.aGY().b(30, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(31815);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
      paramInt1 = ((com.tencent.mm.pluginsdk.model.t)paramq).fDn;
      paramString = ((com.tencent.mm.pluginsdk.model.t)paramq).QVv;
      Log.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + paramInt1 + ", verifyContent = " + paramString);
      Log.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + RpQ.type);
      switch (RpQ.type)
      {
      default: 
        paramq = new bn();
        paramq.field_createTime = com.tencent.mm.bl.c.z(RpQ.talker, 0L);
        paramq.field_isSend = 1;
        paramq.field_msgContent = paramString;
        paramq.field_talker = RpQ.talker;
        if (paramInt1 != 5) {
          break;
        }
      }
      for (paramInt1 = 2;; paramInt1 = 3)
      {
        paramq.field_type = paramInt1;
        Log.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = ".concat(String.valueOf(d.bqb().b(paramq))));
        for (;;)
        {
          bh.aGY().b(30, this);
          AppMethodBeat.o(31819);
          return;
          paramq = new bx();
          paramq.field_createtime = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSb().aOB(RpQ.talker);
          paramq.field_isSend = 1;
          paramq.field_content = paramString;
          paramq.field_talker = "fmessage";
          paramq.field_sayhiuser = RpQ.talker;
          paramq.field_svrid = System.currentTimeMillis();
          paramq.field_status = 4;
          d.bqd().a(paramq);
          continue;
          paramq = new cm();
          paramq.field_createtime = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSa().aOB(RpQ.talker);
          paramq.field_isSend = 1;
          paramq.field_content = paramString;
          paramq.field_talker = "fmessage";
          paramq.field_sayhiuser = RpQ.talker;
          paramq.field_svrid = System.currentTimeMillis();
          paramq.field_status = 4;
          Log.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(d.bqe().a(paramq))));
        }
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -34)) {
      paramq = this.context.getString(R.l.fmessage_request_too_offen);
    }
    for (;;)
    {
      Toast.makeText(this.context, paramq, 1).show();
      break;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramq = this.context.getString(R.l.fmessage_user_not_support);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramq = paramString;
        if (!Util.isNullOrNil(paramString)) {}
      }
      else
      {
        paramq = this.context.getString(R.l.sendrequest_send_fail);
      }
    }
  }
  
  public final void setBtnVisibility(int paramInt)
  {
    AppMethodBeat.i(31818);
    if (this.RpR != null) {
      this.RpR.setVisibility(paramInt);
    }
    AppMethodBeat.o(31818);
  }
  
  public final void setContentText(String paramString)
  {
    AppMethodBeat.i(31817);
    if (Util.isNullOrNil(paramString))
    {
      this.kMh.setVisibility(8);
      AppMethodBeat.o(31817);
      return;
    }
    this.kMh.setVisibility(0);
    this.kMh.setText(l.b(this.context, Util.nullAsNil(paramString), this.kMh.getTextSize()));
    AppMethodBeat.o(31817);
  }
  
  public static class a
  {
    public String BLy;
    public String RpW;
    public int scene;
    public String talker;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a
 * JD-Core Version:    0.7.0.1
 */