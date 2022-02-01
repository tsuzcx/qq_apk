package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rs;
import com.tencent.mm.plugin.remittance.model.af;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.c;

public final class d
{
  private abe Okb;
  public a Ols;
  public Context mContext;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(final af paramaf, final abe paramabe, final a parama)
  {
    AppMethodBeat.i(67940);
    this.Ols = parama;
    this.Okb = paramabe;
    Object localObject = View.inflate(this.mContext, a.g.real_name_check_dialog, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(a.f.last_name);
    parama = (EditText)((View)localObject).findViewById(a.f.first_name);
    ((MMNeat7extView)((View)localObject).findViewById(a.f.content)).aZ(this.Okb.wording);
    localTextView.setText(paramabe.MEz);
    paramabe = new com.tencent.mm.ui.widget.a.g.a(this.mContext);
    paramabe.bf(this.Okb.title).mg((View)localObject);
    paramabe.bDI(this.mContext.getResources().getString(a.i.app_sure));
    c.i(parama).b(com.tencent.mm.ui.tools.g.a.afIH).oF(1, 1).Nc(false).a(null);
    parama.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(289166);
        if (paramabe.pRv != null)
        {
          if (parama.length() > 0)
          {
            paramabe.pRv.ayi(d.this.mContext.getResources().getColor(a.c.Link_100));
            paramabe.pRv.aEJ(-1).setEnabled(true);
            AppMethodBeat.o(289166);
            return;
          }
          paramabe.pRv.ayi(-2141754475);
          paramabe.pRv.aEJ(-1).setEnabled(false);
        }
        AppMethodBeat.o(289166);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289170);
        parama.requestFocus();
        ((InputMethodManager)d.this.mContext.getSystemService("input_method")).showSoftInput(parama, 0);
        AppMethodBeat.o(289170);
      }
    }, 200L);
    localObject = new rs();
    ((rs)localObject).jwc = paramaf.amount;
    localObject = ((rs)localObject).yr(paramaf.username);
    ((rs)localObject).jvV = 1L;
    ((rs)localObject).bMH();
    paramabe.c(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(289177);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new rs();
          paramAnonymousString.jwc = paramaf.amount;
          paramAnonymousString = paramAnonymousString.yr(paramaf.username);
          paramAnonymousString.jvV = 3L;
          paramAnonymousString.bMH();
          d.this.Ols.aTT(parama.getText().toString());
          AppMethodBeat.o(289177);
          return;
        }
        paramAnonymousString = new rs();
        paramAnonymousString.jwc = paramaf.amount;
        paramAnonymousString = paramAnonymousString.yr(paramaf.username);
        paramAnonymousString.jvV = 2L;
        paramAnonymousString.bMH();
        d.this.Ols.onCancel();
        AppMethodBeat.o(289177);
      }
    }).show();
    if ((paramabe.pRv != null) && (Util.isNullOrNil(parama.getText())))
    {
      paramabe.pRv.aEJ(-1).setEnabled(false);
      paramabe.pRv.ayi(-2141754475);
    }
    AppMethodBeat.o(67940);
  }
  
  public static abstract interface a
  {
    public abstract void aTT(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.d
 * JD-Core Version:    0.7.0.1
 */