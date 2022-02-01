package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomEditText;
import java.util.Iterator;
import java.util.LinkedList;

public class PasterEditTextCompact
  extends CustomEditText
{
  private boolean QFZ;
  private int QGa;
  private int QGb;
  private CharSequence QGc;
  private CharSequence QGd;
  private int QGe;
  private LinkedList<TextWatcher> QGf;
  private LinkedList<Object> QGg;
  private Context context;
  
  public PasterEditTextCompact(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205540);
    this.QFZ = false;
    this.QGa = 0;
    this.QGb = 0;
    this.QGc = "";
    this.QGd = "";
    this.QGe = 0;
    this.QGf = new LinkedList();
    this.QGg = new LinkedList();
    this.context = paramContext;
    init();
    AppMethodBeat.o(205540);
  }
  
  public PasterEditTextCompact(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205541);
    this.QFZ = false;
    this.QGa = 0;
    this.QGb = 0;
    this.QGc = "";
    this.QGd = "";
    this.QGe = 0;
    this.QGf = new LinkedList();
    this.QGg = new LinkedList();
    init();
    AppMethodBeat.o(205541);
  }
  
  private void init()
  {
    AppMethodBeat.i(205542);
    super.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(205539);
        if ((PasterEditTextCompact.b(PasterEditTextCompact.this)) || (PasterEditTextCompact.c(PasterEditTextCompact.this) > 20))
        {
          PasterEditTextCompact.d(PasterEditTextCompact.this);
          PasterEditTextCompact.c(PasterEditTextCompact.this, PasterEditTextCompact.e(PasterEditTextCompact.this));
          PasterEditTextCompact.b(PasterEditTextCompact.this, PasterEditTextCompact.f(PasterEditTextCompact.this));
          localIterator = PasterEditTextCompact.g(PasterEditTextCompact.this).iterator();
          while (localIterator.hasNext())
          {
            localIterator.next();
            PasterEditTextCompact.f(PasterEditTextCompact.this);
            PasterEditTextCompact.h(PasterEditTextCompact.this);
            PasterEditTextCompact.e(PasterEditTextCompact.this);
          }
        }
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).afterTextChanged(paramAnonymousEditable);
        }
        AppMethodBeat.o(205539);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205537);
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).beforeTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(205537);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205538);
        PasterEditTextCompact.a(PasterEditTextCompact.this, paramAnonymousInt1);
        PasterEditTextCompact.b(PasterEditTextCompact.this, paramAnonymousInt3);
        PasterEditTextCompact.a(PasterEditTextCompact.this, paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3));
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(205538);
      }
    });
    AppMethodBeat.o(205542);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(205543);
    this.QGf.add(paramTextWatcher);
    AppMethodBeat.o(205543);
  }
  
  public CharSequence getPasterContent()
  {
    return this.QGd;
  }
  
  public int getPasterLen()
  {
    return this.QGe;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(205545);
    if (paramInt == 16908322) {
      this.QFZ = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(205545);
    return bool;
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(205544);
    this.QGf.remove(paramTextWatcher);
    AppMethodBeat.o(205544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.PasterEditTextCompact
 * JD-Core Version:    0.7.0.1
 */