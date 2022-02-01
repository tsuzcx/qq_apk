package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cedit.edit.CustomEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PasterEditTextCompact
  extends CustomEditText
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
  
  public PasterEditTextCompact(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(252231);
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
    AppMethodBeat.o(252231);
  }
  
  public PasterEditTextCompact(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(252240);
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
    AppMethodBeat.o(252240);
  }
  
  private void init()
  {
    AppMethodBeat.i(252249);
    super.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(252239);
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
        if ((!PasterEditTextCompact.h(PasterEditTextCompact.this)) && (PasterEditTextCompact.d(PasterEditTextCompact.this) >= 7)) {
          PasterEditTextCompact.i(PasterEditTextCompact.this);
        }
        if (PasterEditTextCompact.d(PasterEditTextCompact.this) >= 7) {
          PasterEditTextCompact.j(PasterEditTextCompact.this).add(Integer.valueOf(PasterEditTextCompact.d(PasterEditTextCompact.this)));
        }
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).afterTextChanged(paramAnonymousEditable);
        }
        AppMethodBeat.o(252239);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(252225);
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).beforeTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(252225);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(252229);
        PasterEditTextCompact.a(PasterEditTextCompact.this, paramAnonymousInt1);
        PasterEditTextCompact.b(PasterEditTextCompact.this, paramAnonymousInt3);
        PasterEditTextCompact.a(PasterEditTextCompact.this, paramAnonymousCharSequence.subSequence(paramAnonymousInt1, paramAnonymousInt1 + paramAnonymousInt3));
        Iterator localIterator = PasterEditTextCompact.a(PasterEditTextCompact.this).iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(252229);
      }
    });
    AppMethodBeat.o(252249);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(252339);
    this.afWV.add(paramTextWatcher);
    AppMethodBeat.o(252339);
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
    AppMethodBeat.i(252357);
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
    AppMethodBeat.o(252357);
    return localObject;
  }
  
  public final void jFl()
  {
    AppMethodBeat.i(252366);
    this.afWT = false;
    this.afWU.clear();
    AppMethodBeat.o(252366);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252382);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyDown keyCode:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(252382);
    return bool;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252401);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyMultiple keyCode:%s repeatCount:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    AppMethodBeat.o(252401);
    return bool;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252408);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyMultiple keyCode:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(252408);
    return bool;
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252392);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyShortcut keyCode:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyShortcut(paramInt, paramKeyEvent);
    AppMethodBeat.o(252392);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252414);
    Log.i("MicroMsg.PasterEditTextCompact", "onKeyUp keyCode:%s eventAction:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramKeyEvent.getAction()) });
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(252414);
    return bool;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(252376);
    if (paramInt == 16908322) {
      this.afWO = true;
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(252376);
    return bool;
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(252348);
    this.afWV.remove(paramTextWatcher);
    AppMethodBeat.o(252348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.PasterEditTextCompact
 * JD-Core Version:    0.7.0.1
 */