package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class PasterEditText
  extends EditText
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
  
  public PasterEditText(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168813);
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
    AppMethodBeat.o(168813);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159400);
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
    AppMethodBeat.o(159400);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159401);
    this.QFZ = false;
    this.QGa = 0;
    this.QGb = 0;
    this.QGc = "";
    this.QGd = "";
    this.QGe = 0;
    this.QGf = new LinkedList();
    this.QGg = new LinkedList();
    init();
    AppMethodBeat.o(159401);
  }
  
  private void init()
  {
    AppMethodBeat.i(159402);
    super.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(198297);
        if ((PasterEditText.b(PasterEditText.this)) || (PasterEditText.c(PasterEditText.this) > 20))
        {
          PasterEditText.d(PasterEditText.this);
          PasterEditText.c(PasterEditText.this, PasterEditText.e(PasterEditText.this));
          PasterEditText.b(PasterEditText.this, PasterEditText.f(PasterEditText.this));
          localIterator = PasterEditText.g(PasterEditText.this).iterator();
          while (localIterator.hasNext())
          {
            localIterator.next();
            PasterEditText.f(PasterEditText.this);
            PasterEditText.h(PasterEditText.this);
            PasterEditText.e(PasterEditText.this);
          }
        }
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).afterTextChanged(paramAnonymousEditable);
        }
        AppMethodBeat.o(198297);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(198295);
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).beforeTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(198295);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(198296);
        PasterEditText.a(PasterEditText.this, paramAnonymousInt1);
        PasterEditText.b(PasterEditText.this, paramAnonymousInt3);
        PasterEditText.a(PasterEditText.this, paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3));
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(198296);
      }
    });
    AppMethodBeat.o(159402);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(198298);
    this.QGf.add(paramTextWatcher);
    AppMethodBeat.o(198298);
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
    AppMethodBeat.i(159403);
    if (paramInt == 16908322) {
      this.QFZ = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(159403);
    return bool;
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(198299);
    this.QGf.remove(paramTextWatcher);
    AppMethodBeat.o(198299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.PasterEditText
 * JD-Core Version:    0.7.0.1
 */