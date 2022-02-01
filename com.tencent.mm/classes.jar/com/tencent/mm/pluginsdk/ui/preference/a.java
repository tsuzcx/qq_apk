package com.tencent.mm.pluginsdk.ui.preference;

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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bk.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class a
  extends LinearLayout
  implements com.tencent.mm.al.f
{
  private static a FfF;
  private Button FfG;
  private Context context;
  private TextView hca;
  private p tipDialog;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(31814);
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131494158, this);
    this.hca = ((TextView)paramContext.findViewById(2131300168));
    this.FfG = ((Button)paramContext.findViewById(2131300169));
    this.FfG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31812);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/FMessageItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = View.inflate(a.a(a.this), 2131495371, null);
        ((TextView)paramAnonymousView.findViewById(2131304591)).setVisibility(8);
        localObject = (TextView)paramAnonymousView.findViewById(2131307005);
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText("50");
        final EditText localEditText = (EditText)paramAnonymousView.findViewById(2131304590);
        localEditText.setSingleLine(false);
        com.tencent.mm.ui.tools.b.c.d(localEditText).aeU(100).a(null);
        localEditText.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymous2Editable)
          {
            AppMethodBeat.i(31809);
            int i = com.tencent.mm.ui.tools.f.cU(100, paramAnonymous2Editable.toString());
            if (this.FfI != null) {
              this.FfI.setText(String.valueOf(i));
            }
            AppMethodBeat.o(31809);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
          
          public final void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
        });
        h.a(a.a(a.this), a.a(a.this).getString(2131755875), paramAnonymousView, new DialogInterface.OnClickListener()
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
                ad.printErrStackTrace("MicroMsg.FMessageItemView", paramAnonymous2DialogInterface, "", new Object[0]);
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
  
  private static int aNc(String paramString)
  {
    AppMethodBeat.i(31816);
    if (paramString == null)
    {
      ad.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
      AppMethodBeat.o(31816);
      return 6;
    }
    switch (bu.d.aUe(paramString).dsi)
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
    FfF = parama;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31815);
    ba.aiU().b(30, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(31815);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(31819);
    if (paramn.getType() != 30)
    {
      AppMethodBeat.o(31819);
      return;
    }
    ad.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = ((o)paramn).dsi;
      paramString = ((o)paramn).ELV;
      ad.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + paramInt1 + ", verifyContent = " + paramString);
      ad.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + FfF.type);
      switch (FfF.type)
      {
      default: 
        paramn = new bh();
        paramn.field_createTime = com.tencent.mm.bk.c.B(FfF.talker, 0L);
        paramn.field_isSend = 1;
        paramn.field_msgContent = paramString;
        paramn.field_talker = FfF.talker;
        if (paramInt1 != 5) {
          break;
        }
      }
      for (paramInt1 = 2;; paramInt1 = 3)
      {
        paramn.field_type = paramInt1;
        ad.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = ".concat(String.valueOf(d.aMn().b(paramn))));
        for (;;)
        {
          ba.aiU().b(30, this);
          AppMethodBeat.o(31819);
          return;
          paramn = new br();
          paramn.field_createtime = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlH().apR(FfF.talker);
          paramn.field_isSend = 1;
          paramn.field_content = paramString;
          paramn.field_talker = "fmessage";
          paramn.field_sayhiuser = FfF.talker;
          paramn.field_svrid = System.currentTimeMillis();
          paramn.field_status = 4;
          d.aMp().a(paramn);
          continue;
          paramn = new cd();
          paramn.field_createtime = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlG().apR(FfF.talker);
          paramn.field_isSend = 1;
          paramn.field_content = paramString;
          paramn.field_talker = "fmessage";
          paramn.field_sayhiuser = FfF.talker;
          paramn.field_svrid = System.currentTimeMillis();
          paramn.field_status = 4;
          ad.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(d.aMq().a(paramn))));
        }
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -34)) {
      paramn = this.context.getString(2131759479);
    }
    for (;;)
    {
      Toast.makeText(this.context, paramn, 1).show();
      break;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramn = this.context.getString(2131759482);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramn = paramString;
        if (!bt.isNullOrNil(paramString)) {}
      }
      else
      {
        paramn = this.context.getString(2131763075);
      }
    }
  }
  
  public final void setBtnVisibility(int paramInt)
  {
    AppMethodBeat.i(31818);
    if (this.FfG != null) {
      this.FfG.setVisibility(paramInt);
    }
    AppMethodBeat.o(31818);
  }
  
  public final void setContentText(String paramString)
  {
    AppMethodBeat.i(31817);
    if (bt.isNullOrNil(paramString))
    {
      this.hca.setVisibility(8);
      AppMethodBeat.o(31817);
      return;
    }
    this.hca.setVisibility(0);
    this.hca.setText(k.b(this.context, bt.nullAsNil(paramString), this.hca.getTextSize()));
    AppMethodBeat.o(31817);
  }
  
  public static final class a
  {
    public String FfL;
    public int scene;
    public String talker;
    public String txJ;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a
 * JD-Core Version:    0.7.0.1
 */