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
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.c;

public final class c
{
  public Context mContext;
  private vf vBc;
  public a vCg;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(final w paramw, final vf paramvf, final a parama)
  {
    AppMethodBeat.i(67940);
    this.vCg = parama;
    this.vBc = paramvf;
    Object localObject = View.inflate(this.mContext, 2131495198, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131301313);
    parama = (EditText)((View)localObject).findViewById(2131300111);
    ((MMNeat7extView)((View)localObject).findViewById(2131298739)).aq(this.vBc.doh);
    localTextView.setText(paramvf.uoA);
    paramvf = new com.tencent.mm.ui.widget.a.f.a(this.mContext);
    paramvf.au(this.vBc.title).gu((View)localObject);
    paramvf.aMs(this.mContext.getResources().getString(2131755903));
    localObject = com.tencent.mm.ui.tools.b.c.d(parama);
    ((com.tencent.mm.ui.tools.b.c)localObject).mcf = com.tencent.mm.ui.tools.f.a.Hrl;
    localObject = ((com.tencent.mm.ui.tools.b.c)localObject).jE(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject).HuM = false;
    ((com.tencent.mm.ui.tools.b.c)localObject).a(null);
    parama.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(187071);
        if (paramvf.ijc != null)
        {
          if (parama.length() > 0)
          {
            paramvf.ijc.Wc(c.this.mContext.getResources().getColor(2131099770));
            paramvf.ijc.getButton(-1).setEnabled(true);
            AppMethodBeat.o(187071);
            return;
          }
          paramvf.ijc.Wc(-2141754475);
          paramvf.ijc.getButton(-1).setEnabled(false);
        }
        AppMethodBeat.o(187071);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187074);
        parama.requestFocus();
        ((InputMethodManager)c.this.mContext.getSystemService("input_method")).showSoftInput(parama, 0);
        AppMethodBeat.o(187074);
      }
    }, 200L);
    localObject = new es();
    ((es)localObject).dZD = paramw.tav;
    localObject = ((es)localObject).kL(paramw.username);
    ((es)localObject).dZv = 1L;
    ((es)localObject).aBj();
    paramvf.c(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(187075);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new es();
          paramAnonymousString.dZD = paramw.tav;
          paramAnonymousString = paramAnonymousString.kL(paramw.username);
          paramAnonymousString.dZv = 3L;
          paramAnonymousString.aBj();
          c.this.vCg.amf(parama.getText().toString());
          AppMethodBeat.o(187075);
          return;
        }
        paramAnonymousString = new es();
        paramAnonymousString.dZD = paramw.tav;
        paramAnonymousString = paramAnonymousString.kL(paramw.username);
        paramAnonymousString.dZv = 2L;
        paramAnonymousString.aBj();
        c.this.vCg.onCancel();
        AppMethodBeat.o(187075);
      }
    }).show();
    if ((paramvf.ijc != null) && (bt.ai(parama.getText())))
    {
      paramvf.ijc.getButton(-1).setEnabled(false);
      paramvf.ijc.Wc(-2141754475);
    }
    AppMethodBeat.o(67940);
  }
  
  public static abstract interface a
  {
    public abstract void amf(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */