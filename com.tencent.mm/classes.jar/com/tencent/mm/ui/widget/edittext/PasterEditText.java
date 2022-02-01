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
  private boolean YeO;
  private int YeP;
  private int YeQ;
  private CharSequence YeR;
  private CharSequence YeS;
  private int YeT;
  private boolean YeU;
  private LinkedList<TextWatcher> YeV;
  private LinkedList<Object> YeW;
  private Context context;
  
  public PasterEditText(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168813);
    this.YeO = false;
    this.YeP = 0;
    this.YeQ = 0;
    this.YeR = "";
    this.YeS = "";
    this.YeT = 0;
    this.YeU = false;
    this.YeV = new LinkedList();
    this.YeW = new LinkedList();
    this.context = paramContext;
    init();
    AppMethodBeat.o(168813);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159400);
    this.YeO = false;
    this.YeP = 0;
    this.YeQ = 0;
    this.YeR = "";
    this.YeS = "";
    this.YeT = 0;
    this.YeU = false;
    this.YeV = new LinkedList();
    this.YeW = new LinkedList();
    this.context = paramContext;
    init();
    AppMethodBeat.o(159400);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159401);
    this.YeO = false;
    this.YeP = 0;
    this.YeQ = 0;
    this.YeR = "";
    this.YeS = "";
    this.YeT = 0;
    this.YeU = false;
    this.YeV = new LinkedList();
    this.YeW = new LinkedList();
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
        AppMethodBeat.i(250595);
        if (PasterEditText.b(PasterEditText.this))
        {
          PasterEditText.c(PasterEditText.this);
          PasterEditText.c(PasterEditText.this, PasterEditText.d(PasterEditText.this));
          PasterEditText.b(PasterEditText.this, PasterEditText.e(PasterEditText.this));
          localIterator = PasterEditText.f(PasterEditText.this).iterator();
          while (localIterator.hasNext())
          {
            localIterator.next();
            PasterEditText.e(PasterEditText.this);
            PasterEditText.g(PasterEditText.this);
            PasterEditText.d(PasterEditText.this);
          }
        }
        if ((!PasterEditText.h(PasterEditText.this)) && (PasterEditText.d(PasterEditText.this) > 10)) {
          PasterEditText.i(PasterEditText.this);
        }
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).afterTextChanged(paramAnonymousEditable);
        }
        AppMethodBeat.o(250595);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(250590);
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).beforeTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(250590);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(250592);
        PasterEditText.a(PasterEditText.this, paramAnonymousInt1);
        PasterEditText.b(PasterEditText.this, paramAnonymousInt3);
        PasterEditText.a(PasterEditText.this, paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3));
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(250592);
      }
    });
    AppMethodBeat.o(159402);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(249817);
    this.YeV.add(paramTextWatcher);
    AppMethodBeat.o(249817);
  }
  
  public CharSequence getPasterContent()
  {
    return this.YeS;
  }
  
  public int getPasterLen()
  {
    return this.YeT;
  }
  
  public boolean getSimilarPasteChange()
  {
    return this.YeU;
  }
  
  public void hZA()
  {
    this.YeU = false;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(159403);
    if (paramInt == 16908322) {
      this.YeO = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(159403);
    return bool;
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(249818);
    this.YeV.remove(paramTextWatcher);
    AppMethodBeat.o(249818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.PasterEditText
 * JD-Core Version:    0.7.0.1
 */