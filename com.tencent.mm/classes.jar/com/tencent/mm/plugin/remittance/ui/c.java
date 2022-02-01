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
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.c;

public final class c
{
  public Context mContext;
  private xr yoG;
  public a ypK;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(final w paramw, final xr paramxr, final a parama)
  {
    AppMethodBeat.i(67940);
    this.ypK = parama;
    this.yoG = paramxr;
    Object localObject = View.inflate(this.mContext, 2131495198, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131301313);
    parama = (EditText)((View)localObject).findViewById(2131300111);
    ((MMNeat7extView)((View)localObject).findViewById(2131298739)).aq(this.yoG.dyI);
    localTextView.setText(paramxr.wSB);
    paramxr = new com.tencent.mm.ui.widget.a.f.a(this.mContext);
    paramxr.au(this.yoG.title).hg((View)localObject);
    paramxr.aZu(this.mContext.getResources().getString(2131755903));
    localObject = com.tencent.mm.ui.tools.b.c.d(parama);
    ((com.tencent.mm.ui.tools.b.c)localObject).njK = com.tencent.mm.ui.tools.f.a.Lfg;
    localObject = ((com.tencent.mm.ui.tools.b.c)localObject).kj(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject).LiL = false;
    ((com.tencent.mm.ui.tools.b.c)localObject).a(null);
    parama.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(190004);
        if (paramxr.jfl != null)
        {
          if (parama.length() > 0)
          {
            paramxr.jfl.aaW(c.this.mContext.getResources().getColor(2131099770));
            paramxr.jfl.getButton(-1).setEnabled(true);
            AppMethodBeat.o(190004);
            return;
          }
          paramxr.jfl.aaW(-2141754475);
          paramxr.jfl.getButton(-1).setEnabled(false);
        }
        AppMethodBeat.o(190004);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190007);
        parama.requestFocus();
        ((InputMethodManager)c.this.mContext.getSystemService("input_method")).showSoftInput(parama, 0);
        AppMethodBeat.o(190007);
      }
    }, 200L);
    localObject = new hn();
    ((hn)localObject).etH = paramw.vxx;
    localObject = ((hn)localObject).qx(paramw.username);
    ((hn)localObject).etA = 1L;
    ((hn)localObject).aLH();
    paramxr.c(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(190008);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new hn();
          paramAnonymousString.etH = paramw.vxx;
          paramAnonymousString = paramAnonymousString.qx(paramw.username);
          paramAnonymousString.etA = 3L;
          paramAnonymousString.aLH();
          c.this.ypK.axB(parama.getText().toString());
          AppMethodBeat.o(190008);
          return;
        }
        paramAnonymousString = new hn();
        paramAnonymousString.etH = paramw.vxx;
        paramAnonymousString = paramAnonymousString.qx(paramw.username);
        paramAnonymousString.etA = 2L;
        paramAnonymousString.aLH();
        c.this.ypK.onCancel();
        AppMethodBeat.o(190008);
      }
    }).show();
    if ((paramxr.jfl != null) && (bu.ah(parama.getText())))
    {
      paramxr.jfl.getButton(-1).setEnabled(false);
      paramxr.jfl.aaW(-2141754475);
    }
    AppMethodBeat.o(67940);
  }
  
  public static abstract interface a
  {
    public abstract void axB(String paramString);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */