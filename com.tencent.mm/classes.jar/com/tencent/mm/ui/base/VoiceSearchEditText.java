package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public class VoiceSearchEditText
  extends EditText
{
  final Drawable JLV;
  final Drawable JLW;
  final Drawable JLX;
  private a JLY;
  private boolean JLZ;
  private boolean JMa;
  private boolean JMb;
  private Context context;
  public String nod;
  private View.OnClickListener wme;
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142460);
    this.nod = "";
    this.JLV = getResources().getDrawable(2131234523);
    this.JLW = null;
    this.JLX = getResources().getDrawable(2131233918);
    this.JLZ = true;
    this.JMa = false;
    this.JMb = false;
    init(paramContext);
    AppMethodBeat.o(142460);
  }
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142461);
    this.nod = "";
    this.JLV = getResources().getDrawable(2131234523);
    this.JLW = null;
    this.JLX = getResources().getDrawable(2131233918);
    this.JLZ = true;
    this.JMa = false;
    this.JMb = false;
    init(paramContext);
    AppMethodBeat.o(142461);
  }
  
  private void fDy()
  {
    AppMethodBeat.i(142464);
    this.JLZ = true;
    if (this.JMa)
    {
      setCompoundDrawables(this.JLW, getCompoundDrawables()[1], this.JLV, getCompoundDrawables()[3]);
      AppMethodBeat.o(142464);
      return;
    }
    if (getText().toString().length() > 0)
    {
      setCompoundDrawables(this.JLW, getCompoundDrawables()[1], this.JLX, getCompoundDrawables()[3]);
      AppMethodBeat.o(142464);
      return;
    }
    setCompoundDrawables(this.JLW, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(142464);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(142463);
    this.context = paramContext;
    this.JMa = false;
    this.JLV.setBounds(0, 0, this.JLV.getIntrinsicWidth(), this.JLV.getIntrinsicHeight());
    this.JLX.setBounds(0, 0, this.JLX.getIntrinsicWidth(), this.JLX.getIntrinsicHeight());
    fDy();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142457);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/VoiceSearchEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        paramAnonymousView = VoiceSearchEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/VoiceSearchEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(142457);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/VoiceSearchEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(142457);
          return true;
        }
        VoiceSearchEditText.a(VoiceSearchEditText.this, true);
        if ((VoiceSearchEditText.a(VoiceSearchEditText.this)) && (VoiceSearchEditText.b(VoiceSearchEditText.this)) && (paramAnonymousView.getText().toString().equals(""))) {
          if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - VoiceSearchEditText.this.JLV.getIntrinsicWidth() - com.tencent.mm.cb.a.fromDPToPix(VoiceSearchEditText.c(paramAnonymousView), 25))
          {
            if (VoiceSearchEditText.d(VoiceSearchEditText.this) != null)
            {
              ae.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
              if ((VoiceSearchEditText.this.getContext() instanceof MMActivity)) {
                ((MMActivity)VoiceSearchEditText.this.getContext()).hideVKB(paramAnonymousView);
              }
              VoiceSearchEditText.d(VoiceSearchEditText.this).onClick(VoiceSearchEditText.this);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/VoiceSearchEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(142457);
              return true;
            }
          }
          else
          {
            paramAnonymousView.requestFocus();
            if ((VoiceSearchEditText.this.getContext() instanceof Activity)) {
              MMActivity.showVKB((Activity)VoiceSearchEditText.this.getContext());
            }
            if (VoiceSearchEditText.d(VoiceSearchEditText.this) != null) {
              VoiceSearchEditText.d(VoiceSearchEditText.this).onClick(null);
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/VoiceSearchEditText$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(142457);
          return false;
          if (paramAnonymousView.getText().toString().length() > 0)
          {
            if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - VoiceSearchEditText.this.JLX.getIntrinsicWidth() - com.tencent.mm.cb.a.fromDPToPix(VoiceSearchEditText.c(paramAnonymousView), 25))
            {
              paramAnonymousView.setText("");
              if (VoiceSearchEditText.e(VoiceSearchEditText.this) != null) {
                VoiceSearchEditText.e(VoiceSearchEditText.this);
              }
              VoiceSearchEditText.f(VoiceSearchEditText.this);
            }
            else if (!paramAnonymousView.isFocused())
            {
              paramAnonymousView.requestFocus();
              if ((VoiceSearchEditText.this.getContext() instanceof Activity)) {
                MMActivity.showVKB((Activity)VoiceSearchEditText.this.getContext());
              }
            }
          }
          else if (VoiceSearchEditText.d(VoiceSearchEditText.this) != null) {
            VoiceSearchEditText.d(VoiceSearchEditText.this).onClick(null);
          }
        }
      }
    });
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142458);
        VoiceSearchEditText.a(VoiceSearchEditText.this, true);
        VoiceSearchEditText.f(VoiceSearchEditText.this);
        AppMethodBeat.o(142458);
      }
    });
    setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142459);
        ae.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(VoiceSearchEditText.g(VoiceSearchEditText.this)) });
        if ((!paramAnonymousBoolean) && (VoiceSearchEditText.g(VoiceSearchEditText.this)))
        {
          VoiceSearchEditText.f(VoiceSearchEditText.this);
          VoiceSearchEditText.a(VoiceSearchEditText.this, false);
        }
        AppMethodBeat.o(142459);
      }
    });
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getCurrentFocus();
      if ((paramContext == null) || (paramContext != this)) {
        break label141;
      }
    }
    label141:
    for (this.JMb = true;; this.JMb = false)
    {
      requestFocus();
      AppMethodBeat.o(142463);
      return;
    }
  }
  
  public void setNeedIcon(boolean paramBoolean) {}
  
  public void setOnContentClearListener(a parama)
  {
    this.JLY = parama;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(142462);
    this.wme = paramOnClickListener;
    this.JMa = true;
    fDy();
    AppMethodBeat.o(142462);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText
 * JD-Core Version:    0.7.0.1
 */