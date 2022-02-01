package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cedit.edit.CustomEditText;
import java.util.Iterator;
import java.util.LinkedList;

public class PasterEditTextCompact
  extends CustomEditText
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
  
  public PasterEditTextCompact(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193995);
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
    AppMethodBeat.o(193995);
  }
  
  public PasterEditTextCompact(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193996);
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
    AppMethodBeat.o(193996);
  }
  
  private void init()
  {
    AppMethodBeat.i(193997);
    super.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(222453);
        if (PasterEditTextCompact.b(PasterEditTextCompact.this))
        {
          PasterEditTextCompact.c(PasterEditTextCompact.this);
          PasterEditTextCompact.c(PasterEditTextCompact.this, PasterEditTextCompact.d(PasterEditTextCompact.this));
          PasterEditTextCompact.b(PasterEditTextCompact.this, PasterEditTextCompact.e(PasterEditTextCompact.this));
          localIterator = PasterEditTextCompact.f(PasterEditTextCompact.this).iterator();
          while (localIterator.hasNext())
          {
            localIterator.next();
            PasterEditTextCompact.e(PasterEditTextCompact.this);
            PasterEditTextCompact.g(PasterEditTextCompact.this);
            PasterEditTextCompact.d(PasterEditTextCompact.this);
          }
        }
        if ((!PasterEditTextCompact.h(PasterEditTextCompact.this)) && (PasterEditTextCompact.d(PasterEditTextCompact.this) > 10)) {
          PasterEditTextCompact.i(PasterEditTextCompact.this);
        }
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).afterTextChanged(paramAnonymousEditable);
        }
        AppMethodBeat.o(222453);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(222441);
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).beforeTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(222441);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(222447);
        PasterEditTextCompact.a(PasterEditTextCompact.this, paramAnonymousInt1);
        PasterEditTextCompact.b(PasterEditTextCompact.this, paramAnonymousInt3);
        PasterEditTextCompact.a(PasterEditTextCompact.this, paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3));
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(222447);
      }
    });
    AppMethodBeat.o(193997);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(193998);
    this.YeV.add(paramTextWatcher);
    AppMethodBeat.o(193998);
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
  
  public final void hZA()
  {
    this.YeU = false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(194006);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyDown keyCode:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(194006);
    return bool;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(194009);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyMultiple keyCode:%s repeatCount:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    AppMethodBeat.o(194009);
    return bool;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(194011);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyMultiple keyCode:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(194011);
    return bool;
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(194008);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyShortcut keyCode:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyShortcut(paramInt, paramKeyEvent);
    AppMethodBeat.o(194008);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(194014);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyUp keyCode:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(194014);
    return bool;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(194003);
    if (paramInt == 16908322) {
      this.YeO = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(194003);
    return bool;
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(194000);
    this.YeV.remove(paramTextWatcher);
    AppMethodBeat.o(194000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.PasterEditTextCompact
 * JD-Core Version:    0.7.0.1
 */