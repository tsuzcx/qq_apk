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
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class VoiceSearchEditText
  extends EditText
{
  private View.OnClickListener Fms;
  final Drawable Wqc;
  final Drawable Wqd;
  final Drawable Wqe;
  private a Wqf;
  private boolean Wqg;
  private boolean Wqh;
  private boolean Wqi;
  private Context context;
  public String rAi;
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142460);
    this.rAi = "";
    this.Wqc = getResources().getDrawable(a.f.voicesearch_enter_btn);
    this.Wqd = null;
    this.Wqe = getResources().getDrawable(a.f.search_clear);
    this.Wqg = true;
    this.Wqh = false;
    this.Wqi = false;
    init(paramContext);
    AppMethodBeat.o(142460);
  }
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142461);
    this.rAi = "";
    this.Wqc = getResources().getDrawable(a.f.voicesearch_enter_btn);
    this.Wqd = null;
    this.Wqe = getResources().getDrawable(a.f.search_clear);
    this.Wqg = true;
    this.Wqh = false;
    this.Wqi = false;
    init(paramContext);
    AppMethodBeat.o(142461);
  }
  
  private void hKz()
  {
    AppMethodBeat.i(142464);
    this.Wqg = true;
    if (this.Wqh)
    {
      setCompoundDrawables(this.Wqd, getCompoundDrawables()[1], this.Wqc, getCompoundDrawables()[3]);
      AppMethodBeat.o(142464);
      return;
    }
    if (getText().toString().length() > 0)
    {
      setCompoundDrawables(this.Wqd, getCompoundDrawables()[1], this.Wqe, getCompoundDrawables()[3]);
      AppMethodBeat.o(142464);
      return;
    }
    setCompoundDrawables(this.Wqd, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(142464);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(142463);
    this.context = paramContext;
    this.Wqh = false;
    this.Wqc.setBounds(0, 0, this.Wqc.getIntrinsicWidth(), this.Wqc.getIntrinsicHeight());
    this.Wqe.setBounds(0, 0, this.Wqe.getIntrinsicWidth(), this.Wqe.getIntrinsicHeight());
    hKz();
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
          if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - VoiceSearchEditText.this.Wqc.getIntrinsicWidth() - a.fromDPToPix(VoiceSearchEditText.c(paramAnonymousView), 25))
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
            if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - VoiceSearchEditText.this.Wqe.getIntrinsicWidth() - a.fromDPToPix(VoiceSearchEditText.c(paramAnonymousView), 25))
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
    for (this.Wqi = true;; this.Wqi = false)
    {
      requestFocus();
      AppMethodBeat.o(142463);
      return;
    }
  }
  
  public void setNeedIcon(boolean paramBoolean) {}
  
  public void setOnContentClearListener(a parama)
  {
    this.Wqf = parama;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(142462);
    this.Fms = paramOnClickListener;
    this.Wqh = true;
    hKz();
    AppMethodBeat.o(142462);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText
 * JD-Core Version:    0.7.0.1
 */