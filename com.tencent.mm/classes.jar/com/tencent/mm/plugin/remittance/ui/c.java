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
import com.tencent.mm.f.b.a.oa;
import com.tencent.mm.plugin.remittance.model.ae;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class c
{
  private zh ImL;
  public a Ioa;
  public Context mContext;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(final ae paramae, final zh paramzh, final a parama)
  {
    AppMethodBeat.i(67940);
    this.Ioa = parama;
    this.ImL = paramzh;
    Object localObject = View.inflate(this.mContext, a.g.real_name_check_dialog, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(a.f.last_name);
    parama = (EditText)((View)localObject).findViewById(a.f.first_name);
    ((MMNeat7extView)((View)localObject).findViewById(a.f.content)).aL(this.ImL.wording);
    localTextView.setText(paramzh.GHJ);
    paramzh = new f.a(this.mContext);
    paramzh.aR(this.ImL.title).iK((View)localObject);
    paramzh.bBp(this.mContext.getResources().getString(a.i.app_sure));
    com.tencent.mm.ui.tools.b.c.i(parama).b(g.a.XSt).mM(1, 1).Hh(false).a(null);
    parama.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(186871);
        if (paramzh.mUO != null)
        {
          if (parama.length() > 0)
          {
            paramzh.mUO.asd(c.this.mContext.getResources().getColor(a.c.Link_100));
            paramzh.mUO.ayb(-1).setEnabled(true);
            AppMethodBeat.o(186871);
            return;
          }
          paramzh.mUO.asd(-2141754475);
          paramzh.mUO.ayb(-1).setEnabled(false);
        }
        AppMethodBeat.o(186871);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211052);
        parama.requestFocus();
        ((InputMethodManager)c.this.mContext.getSystemService("input_method")).showSoftInput(parama, 0);
        AppMethodBeat.o(211052);
      }
    }, 200L);
    localObject = new oa();
    ((oa)localObject).has = paramae.amount;
    localObject = ((oa)localObject).EJ(paramae.username);
    ((oa)localObject).hal = 1L;
    ((oa)localObject).bpa();
    paramzh.c(new f.c()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(270905);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new oa();
          paramAnonymousString.has = paramae.amount;
          paramAnonymousString = paramAnonymousString.EJ(paramae.username);
          paramAnonymousString.hal = 3L;
          paramAnonymousString.bpa();
          c.this.Ioa.aWF(parama.getText().toString());
          AppMethodBeat.o(270905);
          return;
        }
        paramAnonymousString = new oa();
        paramAnonymousString.has = paramae.amount;
        paramAnonymousString = paramAnonymousString.EJ(paramae.username);
        paramAnonymousString.hal = 2L;
        paramAnonymousString.bpa();
        c.this.Ioa.onCancel();
        AppMethodBeat.o(270905);
      }
    }).show();
    if ((paramzh.mUO != null) && (Util.isNullOrNil(parama.getText())))
    {
      paramzh.mUO.ayb(-1).setEnabled(false);
      paramzh.mUO.asd(-2141754475);
    }
    AppMethodBeat.o(67940);
  }
  
  public static abstract interface a
  {
    public abstract void aWF(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */