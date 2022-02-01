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
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.c;

public final class c
{
  public Context mContext;
  private xo xYO;
  public a xZS;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(final w paramw, final xo paramxo, final a parama)
  {
    AppMethodBeat.i(67940);
    this.xZS = parama;
    this.xYO = paramxo;
    Object localObject = View.inflate(this.mContext, 2131495198, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131301313);
    parama = (EditText)((View)localObject).findViewById(2131300111);
    ((MMNeat7extView)((View)localObject).findViewById(2131298739)).ar(this.xYO.dxD);
    localTextView.setText(paramxo.wCQ);
    paramxo = new com.tencent.mm.ui.widget.a.f.a(this.mContext);
    paramxo.av(this.xYO.title).hb((View)localObject);
    paramxo.aXS(this.mContext.getResources().getString(2131755903));
    localObject = com.tencent.mm.ui.tools.b.c.d(parama);
    ((com.tencent.mm.ui.tools.b.c)localObject).neC = com.tencent.mm.ui.tools.f.a.KIM;
    localObject = ((com.tencent.mm.ui.tools.b.c)localObject).kc(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject).KMn = false;
    ((com.tencent.mm.ui.tools.b.c)localObject).a(null);
    parama.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(199147);
        if (paramxo.jcs != null)
        {
          if (parama.length() > 0)
          {
            paramxo.jcs.aaq(c.this.mContext.getResources().getColor(2131099770));
            paramxo.jcs.getButton(-1).setEnabled(true);
            AppMethodBeat.o(199147);
            return;
          }
          paramxo.jcs.aaq(-2141754475);
          paramxo.jcs.getButton(-1).setEnabled(false);
        }
        AppMethodBeat.o(199147);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199150);
        parama.requestFocus();
        ((InputMethodManager)c.this.mContext.getSystemService("input_method")).showSoftInput(parama, 0);
        AppMethodBeat.o(199150);
      }
    }, 200L);
    localObject = new hl();
    ((hl)localObject).esa = paramw.vls;
    localObject = ((hl)localObject).qc(paramw.username);
    ((hl)localObject).erT = 1L;
    ((hl)localObject).aLk();
    paramxo.c(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(199151);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new hl();
          paramAnonymousString.esa = paramw.vls;
          paramAnonymousString = paramAnonymousString.qc(paramw.username);
          paramAnonymousString.erT = 3L;
          paramAnonymousString.aLk();
          c.this.xZS.awm(parama.getText().toString());
          AppMethodBeat.o(199151);
          return;
        }
        paramAnonymousString = new hl();
        paramAnonymousString.esa = paramw.vls;
        paramAnonymousString = paramAnonymousString.qc(paramw.username);
        paramAnonymousString.erT = 2L;
        paramAnonymousString.aLk();
        c.this.xZS.onCancel();
        AppMethodBeat.o(199151);
      }
    }).show();
    if ((paramxo.jcs != null) && (bt.ai(parama.getText())))
    {
      paramxo.jcs.getButton(-1).setEnabled(false);
      paramxo.jcs.aaq(-2141754475);
    }
    AppMethodBeat.o(67940);
  }
  
  public static abstract interface a
  {
    public abstract void awm(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */