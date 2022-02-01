package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cedit.api.MMCustomEditText;

public class SnsCustomEditText
  extends MMCustomEditText
{
  private boolean Kcv;
  private boolean RqX;
  private int RqY;
  private int RqZ;
  private int Rra;
  private Context context;
  private int ucb;
  
  public SnsCustomEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(308884);
    this.ucb = 0;
    this.RqX = false;
    this.RqY = 0;
    this.RqZ = 0;
    this.Kcv = false;
    this.Rra = 10;
    this.context = paramContext;
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(308312);
        if (paramAnonymousCharSequence != null) {
          SnsCustomEditText.b(SnsCustomEditText.this, paramAnonymousCharSequence.length());
        }
        AppMethodBeat.o(308312);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(308311);
        try
        {
          if (SnsCustomEditText.a(SnsCustomEditText.this))
          {
            if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < a.Qkq))
            {
              SnsCustomEditText.a(SnsCustomEditText.this, 0);
              AppMethodBeat.o(308311);
              return;
            }
            if (paramAnonymousCharSequence.length() - SnsCustomEditText.b(SnsCustomEditText.this) > a.Qkq) {
              SnsCustomEditText.a(SnsCustomEditText.this, paramAnonymousCharSequence.length() - SnsCustomEditText.b(SnsCustomEditText.this));
            }
          }
          AppMethodBeat.o(308311);
          return;
        }
        catch (Exception paramAnonymousCharSequence)
        {
          Log.printErrStackTrace("MicroMsg.SnsEditText", paramAnonymousCharSequence, "", new Object[0]);
          AppMethodBeat.o(308311);
        }
      }
    });
    AppMethodBeat.o(308884);
  }
  
  public int getPasterLen()
  {
    return this.ucb;
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(308901);
    if (paramInt == 16908322) {
      this.RqX = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(308901);
    return bool;
  }
  
  public void setPasterLen(int paramInt)
  {
    this.ucb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCustomEditText
 * JD-Core Version:    0.7.0.1
 */