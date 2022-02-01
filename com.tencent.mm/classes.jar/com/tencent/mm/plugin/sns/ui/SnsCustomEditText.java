package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cedit.api.MMCustomEditText;

public class SnsCustomEditText
  extends MMCustomEditText
{
  private boolean EjM;
  private boolean KRe;
  private int KRf;
  private int KRg;
  private int KRh;
  private Context context;
  private int qWs;
  
  public SnsCustomEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(201796);
    this.qWs = 0;
    this.KRe = false;
    this.KRf = 0;
    this.KRg = 0;
    this.EjM = false;
    this.KRh = 10;
    this.context = paramContext;
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(269932);
        if (paramAnonymousCharSequence != null) {
          SnsCustomEditText.b(SnsCustomEditText.this, paramAnonymousCharSequence.length());
        }
        AppMethodBeat.o(269932);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(269931);
        try
        {
          if (SnsCustomEditText.a(SnsCustomEditText.this))
          {
            if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.JPj))
            {
              SnsCustomEditText.a(SnsCustomEditText.this, 0);
              AppMethodBeat.o(269931);
              return;
            }
            if (paramAnonymousCharSequence.length() - SnsCustomEditText.b(SnsCustomEditText.this) > a.JPj) {
              SnsCustomEditText.a(SnsCustomEditText.this, paramAnonymousCharSequence.length() - SnsCustomEditText.b(SnsCustomEditText.this));
            }
          }
          AppMethodBeat.o(269931);
          return;
        }
        catch (Exception paramAnonymousCharSequence)
        {
          Log.printErrStackTrace("MicroMsg.SnsEditText", paramAnonymousCharSequence, "", new Object[0]);
          AppMethodBeat.o(269931);
        }
      }
    });
    AppMethodBeat.o(201796);
  }
  
  public int getPasterLen()
  {
    return this.qWs;
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(201802);
    if (paramInt == 16908322) {
      this.KRe = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(201802);
    return bool;
  }
  
  public void setPasterLen(int paramInt)
  {
    this.qWs = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCustomEditText
 * JD-Core Version:    0.7.0.1
 */