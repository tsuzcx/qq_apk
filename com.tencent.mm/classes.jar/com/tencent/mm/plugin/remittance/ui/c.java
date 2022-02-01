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
import com.tencent.mm.g.b.a.gi;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.c;

public final class c
{
  public Context mContext;
  private vp wLh;
  public a wMl;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(final w paramw, final vp paramvp, final a parama)
  {
    AppMethodBeat.i(67940);
    this.wMl = parama;
    this.wLh = paramvp;
    Object localObject = View.inflate(this.mContext, 2131495198, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131301313);
    parama = (EditText)((View)localObject).findViewById(2131300111);
    ((MMNeat7extView)((View)localObject).findViewById(2131298739)).ar(this.wLh.dlQ);
    localTextView.setText(paramvp.vxw);
    paramvp = new com.tencent.mm.ui.widget.a.f.a(this.mContext);
    paramvp.av(this.wLh.title).gK((View)localObject);
    paramvp.aRU(this.mContext.getResources().getString(2131755903));
    localObject = com.tencent.mm.ui.tools.b.c.d(parama);
    ((com.tencent.mm.ui.tools.b.c)localObject).mEd = com.tencent.mm.ui.tools.f.a.IRI;
    localObject = ((com.tencent.mm.ui.tools.b.c)localObject).jQ(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject).IVj = false;
    ((com.tencent.mm.ui.tools.b.c)localObject).a(null);
    parama.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(207152);
        if (paramvp.iJj != null)
        {
          if (parama.length() > 0)
          {
            paramvp.iJj.Yl(c.this.mContext.getResources().getColor(2131099770));
            paramvp.iJj.getButton(-1).setEnabled(true);
            AppMethodBeat.o(207152);
            return;
          }
          paramvp.iJj.Yl(-2141754475);
          paramvp.iJj.getButton(-1).setEnabled(false);
        }
        AppMethodBeat.o(207152);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207155);
        parama.requestFocus();
        ((InputMethodManager)c.this.mContext.getSystemService("input_method")).showSoftInput(parama, 0);
        AppMethodBeat.o(207155);
      }
    }, 200L);
    localObject = new gi();
    ((gi)localObject).ebv = paramw.uiK;
    localObject = ((gi)localObject).nD(paramw.username);
    ((gi)localObject).ebn = 1L;
    ((gi)localObject).aHZ();
    paramvp.c(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(207156);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new gi();
          paramAnonymousString.ebv = paramw.uiK;
          paramAnonymousString = paramAnonymousString.nD(paramw.username);
          paramAnonymousString.ebn = 3L;
          paramAnonymousString.aHZ();
          c.this.wMl.arm(parama.getText().toString());
          AppMethodBeat.o(207156);
          return;
        }
        paramAnonymousString = new gi();
        paramAnonymousString.ebv = paramw.uiK;
        paramAnonymousString = paramAnonymousString.nD(paramw.username);
        paramAnonymousString.ebn = 2L;
        paramAnonymousString.aHZ();
        c.this.wMl.onCancel();
        AppMethodBeat.o(207156);
      }
    }).show();
    if ((paramvp.iJj != null) && (bs.aj(parama.getText())))
    {
      paramvp.iJj.getButton(-1).setEnabled(false);
      paramvp.iJj.Yl(-2141754475);
    }
    AppMethodBeat.o(67940);
  }
  
  public static abstract interface a
  {
    public abstract void arm(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */