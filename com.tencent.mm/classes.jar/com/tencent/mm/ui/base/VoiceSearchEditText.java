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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class VoiceSearchEditText
  extends EditText
{
  final Drawable OWR;
  final Drawable OWS;
  final Drawable OWT;
  private a OWU;
  private boolean OWV;
  private boolean OWW;
  private boolean OWX;
  private Context context;
  public String oxJ;
  private View.OnClickListener zHh;
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142460);
    this.oxJ = "";
    this.OWR = getResources().getDrawable(2131235485);
    this.OWS = null;
    this.OWT = getResources().getDrawable(2131234750);
    this.OWV = true;
    this.OWW = false;
    this.OWX = false;
    init(paramContext);
    AppMethodBeat.o(142460);
  }
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142461);
    this.oxJ = "";
    this.OWR = getResources().getDrawable(2131235485);
    this.OWS = null;
    this.OWT = getResources().getDrawable(2131234750);
    this.OWV = true;
    this.OWW = false;
    this.OWX = false;
    init(paramContext);
    AppMethodBeat.o(142461);
  }
  
  private void gLx()
  {
    AppMethodBeat.i(142464);
    this.OWV = true;
    if (this.OWW)
    {
      setCompoundDrawables(this.OWS, getCompoundDrawables()[1], this.OWR, getCompoundDrawables()[3]);
      AppMethodBeat.o(142464);
      return;
    }
    if (getText().toString().length() > 0)
    {
      setCompoundDrawables(this.OWS, getCompoundDrawables()[1], this.OWT, getCompoundDrawables()[3]);
      AppMethodBeat.o(142464);
      return;
    }
    setCompoundDrawables(this.OWS, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(142464);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(142463);
    this.context = paramContext;
    this.OWW = false;
    this.OWR.setBounds(0, 0, this.OWR.getIntrinsicWidth(), this.OWR.getIntrinsicHeight());
    this.OWT.setBounds(0, 0, this.OWT.getIntrinsicWidth(), this.OWT.getIntrinsicHeight());
    gLx();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142457);
        paramAnonymousView = VoiceSearchEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          AppMethodBeat.o(142457);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          AppMethodBeat.o(142457);
          return true;
        }
        VoiceSearchEditText.a(VoiceSearchEditText.this, true);
        if ((VoiceSearchEditText.a(VoiceSearchEditText.this)) && (VoiceSearchEditText.b(VoiceSearchEditText.this)) && (paramAnonymousView.getText().toString().equals(""))) {
          if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - VoiceSearchEditText.this.OWR.getIntrinsicWidth() - a.fromDPToPix(VoiceSearchEditText.c(paramAnonymousView), 25))
          {
            if (VoiceSearchEditText.d(VoiceSearchEditText.this) != null)
            {
              Log.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
              if ((VoiceSearchEditText.this.getContext() instanceof MMActivity)) {
                ((MMActivity)VoiceSearchEditText.this.getContext()).hideVKB(paramAnonymousView);
              }
              VoiceSearchEditText.d(VoiceSearchEditText.this).onClick(VoiceSearchEditText.this);
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
          AppMethodBeat.o(142457);
          return false;
          if (paramAnonymousView.getText().toString().length() > 0)
          {
            if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - VoiceSearchEditText.this.OWT.getIntrinsicWidth() - a.fromDPToPix(VoiceSearchEditText.c(paramAnonymousView), 25))
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
        Log.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(VoiceSearchEditText.g(VoiceSearchEditText.this)) });
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
    for (this.OWX = true;; this.OWX = false)
    {
      requestFocus();
      AppMethodBeat.o(142463);
      return;
    }
  }
  
  public void setNeedIcon(boolean paramBoolean) {}
  
  public void setOnContentClearListener(a parama)
  {
    this.OWU = parama;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(142462);
    this.zHh = paramOnClickListener;
    this.OWW = true;
    gLx();
    AppMethodBeat.o(142462);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText
 * JD-Core Version:    0.7.0.1
 */