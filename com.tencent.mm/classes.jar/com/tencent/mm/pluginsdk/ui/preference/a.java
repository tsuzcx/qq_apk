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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bj.d;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class a
  extends LinearLayout
  implements com.tencent.mm.ak.g
{
  private static a DAy;
  private Button DAz;
  private Context context;
  private TextView gIq;
  private p tipDialog;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(31814);
    this.context = paramContext;
    paramContext = View.inflate(this.context, 2131494158, this);
    this.gIq = ((TextView)paramContext.findViewById(2131300168));
    this.DAz = ((Button)paramContext.findViewById(2131300169));
    this.DAz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(31812);
        paramAnonymousView = View.inflate(a.a(a.this), 2131495371, null);
        ((TextView)paramAnonymousView.findViewById(2131304591)).setVisibility(8);
        final TextView localTextView = (TextView)paramAnonymousView.findViewById(2131307005);
        localTextView.setVisibility(0);
        localTextView.setText("50");
        final EditText localEditText = (EditText)paramAnonymousView.findViewById(2131304590);
        localEditText.setSingleLine(false);
        com.tencent.mm.ui.tools.b.c.d(localEditText).acw(100).a(null);
        localEditText.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymous2Editable)
          {
            AppMethodBeat.i(31809);
            int i = com.tencent.mm.ui.tools.f.cM(100, paramAnonymous2Editable.toString());
            if (localTextView != null) {
              localTextView.setText(String.valueOf(i));
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
                ac.printErrStackTrace("MicroMsg.FMessageItemView", paramAnonymous2DialogInterface, "", new Object[0]);
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
        AppMethodBeat.o(31812);
      }
    });
    AppMethodBeat.o(31814);
  }
  
  private static int aHz(String paramString)
  {
    AppMethodBeat.i(31816);
    if (paramString == null)
    {
      ac.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
      AppMethodBeat.o(31816);
      return 6;
    }
    switch (bo.d.aOn(paramString).dgL)
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
    DAy = parama;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31815);
    az.agi().b(30, this);
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
    ac.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = ((o)paramn).dgL;
      paramString = ((o)paramn).Dhl;
      ac.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + paramInt1 + ", verifyContent = " + paramString);
      ac.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + DAy.type);
      switch (DAy.type)
      {
      default: 
        paramn = new bd();
        paramn.field_createTime = com.tencent.mm.bj.c.z(DAy.talker, 0L);
        paramn.field_isSend = 1;
        paramn.field_msgContent = paramString;
        paramn.field_talker = DAy.talker;
        if (paramInt1 != 5) {
          break;
        }
      }
      for (paramInt1 = 2;; paramInt1 = 3)
      {
        paramn.field_type = paramInt1;
        ac.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = ".concat(String.valueOf(d.aJd().b(paramn))));
        for (;;)
        {
          az.agi().b(30, this);
          AppMethodBeat.o(31819);
          return;
          paramn = new bl();
          paramn.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dco().ale(DAy.talker);
          paramn.field_isSend = 1;
          paramn.field_content = paramString;
          paramn.field_talker = "fmessage";
          paramn.field_sayhiuser = DAy.talker;
          paramn.field_svrid = System.currentTimeMillis();
          paramn.field_status = 4;
          d.aJf().a(paramn);
          continue;
          paramn = new bx();
          paramn.field_createtime = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcn().ale(DAy.talker);
          paramn.field_isSend = 1;
          paramn.field_content = paramString;
          paramn.field_talker = "fmessage";
          paramn.field_sayhiuser = DAy.talker;
          paramn.field_svrid = System.currentTimeMillis();
          paramn.field_status = 4;
          ac.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = ".concat(String.valueOf(d.aJg().a(paramn))));
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
        if (!bs.isNullOrNil(paramString)) {}
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
    if (this.DAz != null) {
      this.DAz.setVisibility(paramInt);
    }
    AppMethodBeat.o(31818);
  }
  
  public final void setContentText(String paramString)
  {
    AppMethodBeat.i(31817);
    if (bs.isNullOrNil(paramString))
    {
      this.gIq.setVisibility(8);
      AppMethodBeat.o(31817);
      return;
    }
    this.gIq.setVisibility(0);
    this.gIq.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, bs.nullAsNil(paramString), this.gIq.getTextSize()));
    AppMethodBeat.o(31817);
  }
  
  public static final class a
  {
    public String DAE;
    public String sBi;
    public int scene;
    public String talker;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a
 * JD-Core Version:    0.7.0.1
 */