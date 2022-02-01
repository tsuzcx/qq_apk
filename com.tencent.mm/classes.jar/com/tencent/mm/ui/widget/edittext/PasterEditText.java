package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PasterEditText
  extends EditText
{
  private int JYv;
  private boolean afWO;
  private int afWP;
  private CharSequence afWQ;
  private CharSequence afWR;
  private int afWS;
  private boolean afWT;
  private List afWU;
  private LinkedList<TextWatcher> afWV;
  private LinkedList<Object> afWW;
  private Context context;
  
  public PasterEditText(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168813);
    this.afWO = false;
    this.afWP = 0;
    this.JYv = 0;
    this.afWQ = "";
    this.afWR = "";
    this.afWS = 0;
    this.afWT = false;
    this.afWU = new ArrayList();
    this.afWV = new LinkedList();
    this.afWW = new LinkedList();
    this.context = paramContext;
    init();
    AppMethodBeat.o(168813);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159400);
    this.afWO = false;
    this.afWP = 0;
    this.JYv = 0;
    this.afWQ = "";
    this.afWR = "";
    this.afWS = 0;
    this.afWT = false;
    this.afWU = new ArrayList();
    this.afWV = new LinkedList();
    this.afWW = new LinkedList();
    this.context = paramContext;
    init();
    AppMethodBeat.o(159400);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159401);
    this.afWO = false;
    this.afWP = 0;
    this.JYv = 0;
    this.afWQ = "";
    this.afWR = "";
    this.afWS = 0;
    this.afWT = false;
    this.afWU = new ArrayList();
    this.afWV = new LinkedList();
    this.afWW = new LinkedList();
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
        AppMethodBeat.i(252024);
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
        if ((!PasterEditText.h(PasterEditText.this)) && (PasterEditText.d(PasterEditText.this) >= 7)) {
          PasterEditText.i(PasterEditText.this);
        }
        if (PasterEditText.d(PasterEditText.this) >= 7) {
          PasterEditText.j(PasterEditText.this).add(Integer.valueOf(PasterEditText.d(PasterEditText.this)));
        }
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).afterTextChanged(paramAnonymousEditable);
        }
        AppMethodBeat.o(252024);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(252016);
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).beforeTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(252016);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(252019);
        PasterEditText.a(PasterEditText.this, paramAnonymousInt1);
        PasterEditText.b(PasterEditText.this, paramAnonymousInt3);
        PasterEditText.a(PasterEditText.this, paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3));
        Iterator localIterator = PasterEditText.a(PasterEditText.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(252019);
      }
    });
    AppMethodBeat.o(159402);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(252145);
    this.afWV.add(paramTextWatcher);
    AppMethodBeat.o(252145);
  }
  
  public CharSequence getPasterContent()
  {
    return this.afWR;
  }
  
  public int getPasterLen()
  {
    return this.afWS;
  }
  
  public boolean getSimilarPasteChange()
  {
    return this.afWT;
  }
  
  public String getSimilarPasteSeqStr()
  {
    AppMethodBeat.i(252186);
    Object localObject = new StringBuilder();
    int i = 0;
    while ((i < 3) && (i < this.afWU.size()))
    {
      if (i != 0) {
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append(this.afWU.get(i));
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(252186);
    return localObject;
  }
  
  public final void jFl()
  {
    AppMethodBeat.i(252194);
    this.afWT = false;
    this.afWU.clear();
    AppMethodBeat.o(252194);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(159403);
    if (paramInt == 16908322) {
      this.afWO = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(159403);
    return bool;
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(252154);
    this.afWV.remove(paramTextWatcher);
    AppMethodBeat.o(252154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.PasterEditText
 * JD-Core Version:    0.7.0.1
 */