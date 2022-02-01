package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.aq;

public class MMPhoneNumberEditText
  extends EditText
{
  public boolean Flu;
  public Drawable Flv;
  private a Flw;
  public boolean Flx;
  private boolean Fly;
  public String nod;
  int pCk;
  private View.OnFocusChangeListener xFB;
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31197);
    this.nod = "";
    this.Flu = false;
    this.Fly = false;
    this.pCk = 0;
    this.xFB = null;
    init();
    AppMethodBeat.o(31197);
  }
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31198);
    this.nod = "";
    this.Flu = false;
    this.Fly = false;
    this.pCk = 0;
    this.xFB = null;
    init();
    AppMethodBeat.o(31198);
  }
  
  private void aNS(String paramString)
  {
    AppMethodBeat.i(31202);
    int i = getSelectionStart();
    g localg = g.fqZ();
    getContext();
    setText(localg.b(paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(31202);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(31202);
  }
  
  private void ffC()
  {
    AppMethodBeat.i(31203);
    if (getText().toString().equals(""))
    {
      ffE();
      AppMethodBeat.o(31203);
      return;
    }
    ffD();
    AppMethodBeat.o(31203);
  }
  
  private void ffD()
  {
    AppMethodBeat.i(31204);
    setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], this.Flv, getCompoundDrawables()[3]);
    AppMethodBeat.o(31204);
  }
  
  private void ffE()
  {
    AppMethodBeat.i(31205);
    setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(31205);
  }
  
  private void init()
  {
    AppMethodBeat.i(31200);
    this.Flv = aq.aM(getContext(), 2130968981);
    this.Flv.setBounds(0, 0, this.Flv.getIntrinsicWidth(), this.Flv.getIntrinsicHeight());
    ae.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.Flv.getIntrinsicWidth()), Integer.valueOf(this.Flv.getIntrinsicHeight()) });
    ffC();
    setHeight(this.Flv.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
    clearFocus();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31193);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/MMPhoneNumberEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        paramAnonymousView = MMPhoneNumberEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/MMPhoneNumberEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31193);
          return false;
        }
        if ((paramAnonymousMotionEvent.getAction() == 1) && (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMPhoneNumberEditText.this.Flv.getIntrinsicWidth()))
        {
          if (!paramAnonymousView.isFocused()) {
            break label150;
          }
          paramAnonymousView.setText("");
          MMPhoneNumberEditText.a(paramAnonymousView);
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/MMPhoneNumberEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31193);
          return false;
          label150:
          if (MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).f(paramAnonymousView);
          }
        }
      }
    });
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31195);
        if (bu.isNullOrNil(paramAnonymousCharSequence.toString()))
        {
          MMPhoneNumberEditText.a(MMPhoneNumberEditText.this, true);
          AppMethodBeat.o(31195);
          return;
        }
        MMPhoneNumberEditText.a(MMPhoneNumberEditText.this, false);
        AppMethodBeat.o(31195);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31194);
        MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
        if ((paramAnonymousCharSequence.toString().equals("")) && (!MMPhoneNumberEditText.d(MMPhoneNumberEditText.this)))
        {
          if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused()))
          {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).g(MMPhoneNumberEditText.this);
            AppMethodBeat.o(31194);
          }
        }
        else if ((!paramAnonymousCharSequence.toString().equals("")) && (MMPhoneNumberEditText.d(MMPhoneNumberEditText.this)))
        {
          if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused()))
          {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).ffF();
            AppMethodBeat.o(31194);
          }
        }
        else if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused())) {
          MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).ffG();
        }
        AppMethodBeat.o(31194);
      }
    });
    super.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31196);
        if (MMPhoneNumberEditText.e(MMPhoneNumberEditText.this) != null) {
          MMPhoneNumberEditText.e(MMPhoneNumberEditText.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
        AppMethodBeat.o(31196);
      }
    });
    AppMethodBeat.o(31200);
  }
  
  public final void ffB()
  {
    AppMethodBeat.i(31199);
    this.Flx = true;
    this.Flv = getResources().getDrawable(2131690693);
    this.Flv.setBounds(0, 0, this.Flv.getIntrinsicWidth(), this.Flv.getIntrinsicHeight());
    setFocusable(false);
    ffD();
    AppMethodBeat.o(31199);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(31206);
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(31206);
      return;
    }
    if (!this.Flu) {
      paramParcelable = View.BaseSavedState.EMPTY_STATE;
    }
    super.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(31206);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(31201);
    boolean bool = super.onTextContextMenuItem(paramInt);
    String str;
    if (paramInt == 16908322)
    {
      this.pCk = 0;
      str = getText().toString();
    }
    try
    {
      aNS(str);
      AppMethodBeat.o(31201);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        ae.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.pCk) });
        if (this.pCk < 3)
        {
          this.pCk += 1;
          aNS(" ".concat(String.valueOf(str)));
        }
        else
        {
          ae.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
        }
      }
    }
  }
  
  public void setCallback(a parama)
  {
    this.Flw = parama;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.xFB = paramOnFocusChangeListener;
  }
  
  public static abstract interface a
  {
    public abstract void f(MMPhoneNumberEditText paramMMPhoneNumberEditText);
    
    public abstract void ffF();
    
    public abstract void ffG();
    
    public abstract void g(MMPhoneNumberEditText paramMMPhoneNumberEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText
 * JD-Core Version:    0.7.0.1
 */