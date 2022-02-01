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
  private boolean EDp;
  private int EDq;
  private int EDr;
  private int EDs;
  private Context context;
  private int nUS;
  private boolean yFT;
  
  public SnsCustomEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203569);
    this.nUS = 0;
    this.EDp = false;
    this.EDq = 0;
    this.EDr = 0;
    this.yFT = false;
    this.EDs = 10;
    this.context = paramContext;
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(203568);
        if (paramAnonymousCharSequence != null) {
          SnsCustomEditText.b(SnsCustomEditText.this, paramAnonymousCharSequence.length());
        }
        AppMethodBeat.o(203568);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(203567);
        try
        {
          if (SnsCustomEditText.a(SnsCustomEditText.this))
          {
            if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.DCT))
            {
              SnsCustomEditText.a(SnsCustomEditText.this, 0);
              AppMethodBeat.o(203567);
              return;
            }
            if (paramAnonymousCharSequence.length() - SnsCustomEditText.b(SnsCustomEditText.this) > a.DCT) {
              SnsCustomEditText.a(SnsCustomEditText.this, paramAnonymousCharSequence.length() - SnsCustomEditText.b(SnsCustomEditText.this));
            }
          }
          AppMethodBeat.o(203567);
          return;
        }
        catch (Exception paramAnonymousCharSequence)
        {
          Log.printErrStackTrace("MicroMsg.SnsEditText", paramAnonymousCharSequence, "", new Object[0]);
          AppMethodBeat.o(203567);
        }
      }
    });
    AppMethodBeat.o(203569);
  }
  
  public int getPasterLen()
  {
    return this.nUS;
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(203570);
    if (paramInt == 16908322) {
      this.EDp = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(203570);
    return bool;
  }
  
  public void setPasterLen(int paramInt)
  {
    this.nUS = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCustomEditText
 * JD-Core Version:    0.7.0.1
 */