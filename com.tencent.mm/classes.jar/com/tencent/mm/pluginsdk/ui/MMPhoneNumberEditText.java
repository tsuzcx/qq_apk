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
import com.tencent.mm.cf.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.aq;

public class MMPhoneNumberEditText
  extends EditText
{
  public boolean ESZ;
  public Drawable ETa;
  private a ETb;
  public boolean ETc;
  private boolean ETd;
  public String niV;
  int pvG;
  private View.OnFocusChangeListener xpE;
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31197);
    this.niV = "";
    this.ESZ = false;
    this.ETd = false;
    this.pvG = 0;
    this.xpE = null;
    init();
    AppMethodBeat.o(31197);
  }
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31198);
    this.niV = "";
    this.ESZ = false;
    this.ETd = false;
    this.pvG = 0;
    this.xpE = null;
    init();
    AppMethodBeat.o(31198);
  }
  
  private void aMw(String paramString)
  {
    AppMethodBeat.i(31202);
    int i = getSelectionStart();
    g localg = g.fng();
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
  
  private void fbO()
  {
    AppMethodBeat.i(31203);
    if (getText().toString().equals(""))
    {
      fbQ();
      AppMethodBeat.o(31203);
      return;
    }
    fbP();
    AppMethodBeat.o(31203);
  }
  
  private void fbP()
  {
    AppMethodBeat.i(31204);
    setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], this.ETa, getCompoundDrawables()[3]);
    AppMethodBeat.o(31204);
  }
  
  private void fbQ()
  {
    AppMethodBeat.i(31205);
    setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(31205);
  }
  
  private void init()
  {
    AppMethodBeat.i(31200);
    this.ETa = aq.aM(getContext(), 2130968981);
    this.ETa.setBounds(0, 0, this.ETa.getIntrinsicWidth(), this.ETa.getIntrinsicHeight());
    ad.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.ETa.getIntrinsicWidth()), Integer.valueOf(this.ETa.getIntrinsicHeight()) });
    fbO();
    setHeight(this.ETa.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
    clearFocus();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31193);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/pluginsdk/ui/MMPhoneNumberEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        paramAnonymousView = MMPhoneNumberEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          a.a(false, this, "com/tencent/mm/pluginsdk/ui/MMPhoneNumberEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(31193);
          return false;
        }
        if ((paramAnonymousMotionEvent.getAction() == 1) && (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMPhoneNumberEditText.this.ETa.getIntrinsicWidth()))
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
        if (bt.isNullOrNil(paramAnonymousCharSequence.toString()))
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
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).fbR();
            AppMethodBeat.o(31194);
          }
        }
        else if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused())) {
          MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).fbS();
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
  
  public final void fbN()
  {
    AppMethodBeat.i(31199);
    this.ETc = true;
    this.ETa = getResources().getDrawable(2131690693);
    this.ETa.setBounds(0, 0, this.ETa.getIntrinsicWidth(), this.ETa.getIntrinsicHeight());
    setFocusable(false);
    fbP();
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
    if (!this.ESZ) {
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
      this.pvG = 0;
      str = getText().toString();
    }
    try
    {
      aMw(str);
      AppMethodBeat.o(31201);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        ad.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.pvG) });
        if (this.pvG < 3)
        {
          this.pvG += 1;
          aMw(" ".concat(String.valueOf(str)));
        }
        else
        {
          ad.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
        }
      }
    }
  }
  
  public void setCallback(a parama)
  {
    this.ETb = parama;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.xpE = paramOnFocusChangeListener;
  }
  
  public static abstract interface a
  {
    public abstract void f(MMPhoneNumberEditText paramMMPhoneNumberEditText);
    
    public abstract void fbR();
    
    public abstract void fbS();
    
    public abstract void g(MMPhoneNumberEditText paramMMPhoneNumberEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText
 * JD-Core Version:    0.7.0.1
 */