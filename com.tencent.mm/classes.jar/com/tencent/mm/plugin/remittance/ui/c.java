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
import com.tencent.mm.g.b.a.le;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.c;

public final class c
{
  private zd Cpw;
  public a CqB;
  public Context mContext;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(final w paramw, final zd paramzd, final a parama)
  {
    AppMethodBeat.i(67940);
    this.CqB = parama;
    this.Cpw = paramzd;
    Object localObject = View.inflate(this.mContext, 2131496041, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131303013);
    parama = (EditText)((View)localObject).findViewById(2131301551);
    ((MMNeat7extView)((View)localObject).findViewById(2131299180)).aw(this.Cpw.dQx);
    localTextView.setText(paramzd.AOv);
    paramzd = new com.tencent.mm.ui.widget.a.f.a(this.mContext);
    paramzd.aC(this.Cpw.title).hu((View)localObject);
    paramzd.boA(this.mContext.getResources().getString(2131755995));
    com.tencent.mm.ui.tools.b.c.f(parama).a(com.tencent.mm.ui.tools.f.a.Quh).lv(1, 1).CN(false).a(null);
    parama.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(213751);
        if (paramzd.kdo != null)
        {
          if (parama.length() > 0)
          {
            paramzd.kdo.ajL(c.this.mContext.getResources().getColor(2131099784));
            paramzd.kdo.getButton(-1).setEnabled(true);
            AppMethodBeat.o(213751);
            return;
          }
          paramzd.kdo.ajL(-2141754475);
          paramzd.kdo.getButton(-1).setEnabled(false);
        }
        AppMethodBeat.o(213751);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213754);
        parama.requestFocus();
        ((InputMethodManager)c.this.mContext.getSystemService("input_method")).showSoftInput(parama, 0);
        AppMethodBeat.o(213754);
      }
    }, 200L);
    localObject = new le();
    ((le)localObject).eXN = paramw.yRL;
    localObject = ((le)localObject).yr(paramw.username);
    ((le)localObject).eXG = 1L;
    ((le)localObject).bfK();
    paramzd.c(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(213755);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new le();
          paramAnonymousString.eXN = paramw.yRL;
          paramAnonymousString = paramAnonymousString.yr(paramw.username);
          paramAnonymousString.eXG = 3L;
          paramAnonymousString.bfK();
          c.this.CqB.aMb(parama.getText().toString());
          AppMethodBeat.o(213755);
          return;
        }
        paramAnonymousString = new le();
        paramAnonymousString.eXN = paramw.yRL;
        paramAnonymousString = paramAnonymousString.yr(paramw.username);
        paramAnonymousString.eXG = 2L;
        paramAnonymousString.bfK();
        c.this.CqB.onCancel();
        AppMethodBeat.o(213755);
      }
    }).show();
    if ((paramzd.kdo != null) && (Util.isNullOrNil(parama.getText())))
    {
      paramzd.kdo.getButton(-1).setEnabled(false);
      paramzd.kdo.ajL(-2141754475);
    }
    AppMethodBeat.o(67940);
  }
  
  public static abstract interface a
  {
    public abstract void aMb(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */