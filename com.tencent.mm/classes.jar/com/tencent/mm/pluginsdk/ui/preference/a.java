package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class a
  extends LinearLayout
  implements com.tencent.mm.am.h
{
  private static a Ymg;
  private b MYn;
  private Button Ymh;
  private Context context;
  private TextView noc;
  private w tipDialog;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(31814);
    this.context = paramContext;
    paramContext = View.inflate(this.context, R.i.gkl, this);
    this.noc = ((TextView)paramContext.findViewById(R.h.fIJ));
    this.Ymh = ((Button)paramContext.findViewById(R.h.fIK));
    this.Ymh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31812);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/FMessageItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = View.inflate(a.a(a.this), R.i.sendrequest_dialog, null);
        ((TextView)paramAnonymousView.findViewById(R.h.sendrequest_tip)).setVisibility(8);
        localObject = (TextView)paramAnonymousView.findViewById(R.h.wordcount);
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText("50");
        final EditText localEditText = (EditText)paramAnonymousView.findViewById(R.h.sendrequest_content);
        localEditText.setSingleLine(false);
        com.tencent.mm.ui.tools.b.c.i(localEditText).aEg(100).a(null);
        localEditText.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymous2Editable)
          {
            AppMethodBeat.i(31809);
            int i = com.tencent.mm.ui.tools.g.ej(100, paramAnonymous2Editable.toString());
            if (this.Ymj != null) {
              this.Ymj.setText(String.valueOf(i));
            }
            AppMethodBeat.o(31809);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
          
          public final void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
        });
        if ((a.a(a.this) instanceof Activity)) {
          com.tencent.mm.plugin.profile.d.b(((Activity)a.a(a.this)).getIntent(), 28, 1, a.iNy().talker);
        }
        k.a(a.a(a.this), a.a(a.this).getString(R.l.app_reply), paramAnonymousView, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(31810);
            paramAnonymous2DialogInterface = localEditText.getText().toString().trim();
            if ((paramAnonymous2DialogInterface != null) && (paramAnonymous2DialogInterface.length() > 0)) {
              try
              {
                a.a(a.this, paramAnonymous2DialogInterface);
                if ((a.a(a.this) instanceof Activity))
                {
                  com.tencent.mm.plugin.profile.d.b(((Activity)a.a(a.this)).getIntent(), 29, 1, a.iNy().talker);
                  if (a.b(a.this) != null) {
                    a.b(a.this).gAQ();
                  }
                }
                AppMethodBeat.o(31810);
                return;
              }
              catch (ArrayIndexOutOfBoundsException paramAnonymous2DialogInterface)
              {
                Log.printErrStackTrace("MicroMsg.FMessageItemView", paramAnonymous2DialogInterface, "", new Object[0]);
                if ((a.c(a.this) != null) && (a.c(a.this).isShowing())) {
                  a.c(a.this).dismiss();
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
  
  private static int brl(String paramString)
  {
    AppMethodBeat.i(31816);
    if (paramString == null)
    {
      Log.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
      AppMethodBeat.o(31816);
      return 6;
    }
    paramString = cc.f.byv(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, verify is null");
      AppMethodBeat.o(31816);
      return 6;
    }
    switch (paramString.hId)
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
    Ymg = parama;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31815);
    bh.aZW().b(30, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(31815);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(31819);
    if (paramp.getType() != 30)
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
      paramInt2 = ((v)paramp).hId;
      paramString = ((v)paramp).XRs;
      Log.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + paramInt2 + ", verifyContent = " + paramString);
      Log.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + Ymg.type);
      switch (Ymg.type)
      {
      default: 
        paramp = Ymg.talker;
        if (paramInt2 != 5) {
          break;
        }
      }
      for (paramInt1 = 2;; paramInt1 = 3)
      {
        com.tencent.mm.plugin.profile.c.p(paramp, paramString, paramInt1, Ymg.scene);
        Log.d("MicroMsg.FMessageItemView", "FMessageConversationStorage onSceneEnd, insert fmsg , opcode = ".concat(String.valueOf(paramInt2)));
        for (;;)
        {
          bh.aZW().b(30, this);
          AppMethodBeat.o(31819);
          return;
          paramp = new bz();
          paramp.field_createtime = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaW().aLA(Ymg.talker);
          paramp.field_isSend = 1;
          paramp.field_content = paramString;
          paramp.field_talker = "fmessage";
          paramp.field_sayhiuser = Ymg.talker;
          paramp.field_svrid = System.currentTimeMillis();
          paramp.field_status = 4;
          com.tencent.mm.modelverify.d.bNJ().a(paramp);
          continue;
          paramp = new cp();
          paramp.field_createtime = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaV().aLA(Ymg.talker);
          paramp.field_isSend = 1;
          paramp.field_content = paramString;
          paramp.field_talker = "fmessage";
          paramp.field_sayhiuser = Ymg.talker;
          paramp.field_svrid = System.currentTimeMillis();
          paramp.field_status = 4;
          Log.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(com.tencent.mm.modelverify.d.bNK().a(paramp))));
        }
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -302)) {
      if (paramp.getType() != 30) {
        break label675;
      }
    }
    label675:
    for (paramInt1 = ((v)paramp).hId;; paramInt1 = 0)
    {
      Log.w("MicroMsg.FMessageItemView", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 != 6) && (paramInt1 != 5)) {
        break;
      }
      k.b(this.context, this.context.getString(R.l.contact_info_verify_outofdate_msg), this.context.getString(R.l.app_tip), this.context.getString(R.l.app_add), this.context.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(245113);
          if (a.b(a.this) != null) {
            a.b(a.this).gAP();
          }
          AppMethodBeat.o(245113);
        }
      }, null);
      break;
      if ((paramInt1 == 4) && (paramInt2 == -34)) {
        paramp = this.context.getString(R.l.fmessage_request_too_offen);
      }
      for (;;)
      {
        Toast.makeText(this.context, paramp, 1).show();
        break;
        if ((paramInt1 == 4) && (paramInt2 == -94))
        {
          paramp = this.context.getString(R.l.fmessage_user_not_support);
        }
        else if ((paramInt1 == 4) && (paramInt2 == -24))
        {
          paramp = paramString;
          if (!Util.isNullOrNil(paramString)) {}
        }
        else
        {
          paramp = this.context.getString(R.l.sendrequest_send_fail);
        }
      }
    }
  }
  
  public final void setBtnVisibility(int paramInt)
  {
    AppMethodBeat.i(31818);
    if (this.Ymh != null) {
      this.Ymh.setVisibility(paramInt);
    }
    AppMethodBeat.o(31818);
  }
  
  public final void setContentText(String paramString)
  {
    AppMethodBeat.i(31817);
    if (Util.isNullOrNil(paramString))
    {
      this.noc.setVisibility(8);
      AppMethodBeat.o(31817);
      return;
    }
    this.noc.setVisibility(0);
    this.noc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, Util.nullAsNil(paramString), this.noc.getTextSize()));
    AppMethodBeat.o(31817);
  }
  
  public final void setGotoSayHiCallBack(b paramb)
  {
    this.MYn = paramb;
  }
  
  public static class a
  {
    public String Ymm;
    public String pPi;
    public int scene;
    public String talker;
    public int type;
  }
  
  public static abstract interface b
  {
    public abstract void gAP();
    
    public abstract void gAQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a
 * JD-Core Version:    0.7.0.1
 */