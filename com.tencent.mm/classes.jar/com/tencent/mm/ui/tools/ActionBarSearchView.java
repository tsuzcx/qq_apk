package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements d
{
  private TextWatcher CfH;
  private boolean FGS;
  private View HlJ;
  protected ActionBarEditText HlK;
  private ImageButton HlL;
  private c HlM;
  private boolean HlN;
  private w HlO;
  private b HlP;
  private a HlQ;
  private View.OnFocusChangeListener HlR;
  private View.OnFocusChangeListener HlS;
  private View.OnClickListener HlT;
  private View.OnClickListener HlU;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143001);
    this.HlM = c.HlX;
    this.HlN = false;
    this.FGS = false;
    this.CfH = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142986);
        ActionBarSearchView.a(ActionBarSearchView.this);
        w localw = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localw.Hur)
        {
          localEditText = (EditText)localw.Hup.get();
          if (localEditText != null) {}
        }
        else if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
        {
          localObject = ActionBarSearchView.c(ActionBarSearchView.this);
          if (paramAnonymousCharSequence != null) {
            break label253;
          }
        }
        label253:
        for (paramAnonymousCharSequence = "";; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
        {
          ((ActionBarSearchView.b)localObject).aBF(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localw.mText == null) || (localw.mText.length() == 0) || ((localw.mText != null) && (paramAnonymousCharSequence != null) && (localw.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            ad.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localw.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localw.mText = ((String)localObject);
            localw.Huo = w.l(localw.mText, localw.Huq);
            if (!w.a(localEditText, localw.Huq)) {
              break;
            }
            ad.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.HlR = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        ad.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.HlT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        if (ActionBarSearchView.c.HlX == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ad.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.wF(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
          {
            ActionBarSearchView.c(ActionBarSearchView.this).aIl();
            AppMethodBeat.o(142988);
          }
        }
        else
        {
          ad.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).fdA();
          }
        }
        AppMethodBeat.o(142988);
      }
    };
    this.HlU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).fdy();
        }
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143001);
  }
  
  public ActionBarSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143000);
    this.HlM = c.HlX;
    this.HlN = false;
    this.FGS = false;
    this.CfH = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142986);
        ActionBarSearchView.a(ActionBarSearchView.this);
        w localw = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localw.Hur)
        {
          localEditText = (EditText)localw.Hup.get();
          if (localEditText != null) {}
        }
        else if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
        {
          localObject = ActionBarSearchView.c(ActionBarSearchView.this);
          if (paramAnonymousCharSequence != null) {
            break label253;
          }
        }
        label253:
        for (paramAnonymousCharSequence = "";; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
        {
          ((ActionBarSearchView.b)localObject).aBF(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localw.mText == null) || (localw.mText.length() == 0) || ((localw.mText != null) && (paramAnonymousCharSequence != null) && (localw.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            ad.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localw.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localw.mText = ((String)localObject);
            localw.Huo = w.l(localw.mText, localw.Huq);
            if (!w.a(localEditText, localw.Huq)) {
              break;
            }
            ad.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.HlR = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        ad.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.HlT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        if (ActionBarSearchView.c.HlX == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ad.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.wF(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
          {
            ActionBarSearchView.c(ActionBarSearchView.this).aIl();
            AppMethodBeat.o(142988);
          }
        }
        else
        {
          ad.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).fdA();
          }
        }
        AppMethodBeat.o(142988);
      }
    };
    this.HlU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).fdy();
        }
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143000);
  }
  
  private void fdu()
  {
    AppMethodBeat.i(143010);
    if ((this.HlK.getEditableText() != null) && (!bt.isNullOrNil(this.HlK.getEditableText().toString())))
    {
      jz(2131233918, getResources().getDimensionPixelSize(2131165514));
      this.HlM = c.HlX;
      AppMethodBeat.o(143010);
      return;
    }
    if (this.HlN)
    {
      jz(2131234523, getResources().getDimensionPixelSize(2131165514));
      this.HlM = c.HlY;
      AppMethodBeat.o(143010);
      return;
    }
    jz(0, 0);
    this.HlM = c.HlX;
    AppMethodBeat.o(143010);
  }
  
  private void init()
  {
    AppMethodBeat.i(143002);
    this.FGS = ai.Eq();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
    this.HlJ = findViewById(2131297690);
    this.HlJ.setOnClickListener(this.HlU);
    this.HlK = ((ActionBarEditText)findViewById(2131299306));
    this.HlO = new w(this.HlK);
    this.HlK.setSearchView(this);
    this.HlK.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142990);
        ActionBarSearchView.this.HlK.setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).fdz();
        }
        AppMethodBeat.o(142990);
      }
    });
    this.HlL = ((ImageButton)findViewById(2131305196));
    this.HlK.addTextChangedListener(this.CfH);
    this.HlK.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142991);
        if (paramAnonymousInt == 67)
        {
          ad.d("MicroMsg.ActionBarSearchView", "on back key click.");
          Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          if (((w)localObject).Hur)
          {
            paramAnonymousView = (EditText)((w)localObject).Hup.get();
            if ((paramAnonymousView != null) && (((w)localObject).Huo != null)) {}
          }
          else
          {
            AppMethodBeat.o(142991);
            return false;
          }
          paramAnonymousKeyEvent = paramAnonymousView.getText();
          paramAnonymousInt = paramAnonymousView.getSelectionStart();
          if (paramAnonymousInt == paramAnonymousView.getSelectionEnd())
          {
            localObject = ((w)localObject).aah(paramAnonymousInt);
            if ((localObject != null) && (((w.b)localObject).Huu))
            {
              paramAnonymousKeyEvent.delete(((w.b)localObject).start, ((w.b)localObject).start + ((w.b)localObject).length);
              paramAnonymousView.setTextKeepState(paramAnonymousKeyEvent);
              paramAnonymousView.setSelection(((w.b)localObject).start);
              AppMethodBeat.o(142991);
              return true;
            }
          }
          AppMethodBeat.o(142991);
          return false;
        }
        AppMethodBeat.o(142991);
        return false;
      }
    });
    this.HlK.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(142992);
        ad.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((w)localObject).Hur)
        {
          localEditText = (EditText)((w)localObject).Hup.get();
          if ((localEditText != null) && (paramAnonymousEditText == localEditText)) {}
        }
        else
        {
          AppMethodBeat.o(142992);
          return;
        }
        paramAnonymousEditText = localEditText.getText();
        paramAnonymousInt2 = localEditText.getSelectionStart();
        int i = localEditText.getSelectionEnd();
        if ((paramAnonymousInt2 < 0) || (i < paramAnonymousInt2))
        {
          AppMethodBeat.o(142992);
          return;
        }
        if (paramAnonymousInt2 == i)
        {
          localObject = ((w)localObject).aah(paramAnonymousInt2);
          if ((localObject != null) && (((w.b)localObject).Huu))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((w.b)localObject).start;
            localEditText.setSelection(((w.b)localObject).length + paramAnonymousInt1);
          }
          AppMethodBeat.o(142992);
          return;
        }
        w.b localb = ((w)localObject).aah(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.Huu) {
            paramAnonymousInt1 = localb.start + localb.length;
          }
        }
        if (paramAnonymousInt1 >= i)
        {
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1);
          AppMethodBeat.o(142992);
          return;
        }
        localObject = ((w)localObject).aah(i);
        if ((localObject != null) && (((w.b)localObject).Huu))
        {
          paramAnonymousInt2 = ((w.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(142992);
      }
    });
    this.HlK.setOnFocusChangeListener(this.HlR);
    c.d(this.HlK).aaj(100).a(null);
    this.HlL.setOnClickListener(this.HlT);
    if (this.HlL.getDrawable() != null) {
      this.HlL.getDrawable().setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(143002);
  }
  
  private void jz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143009);
    this.HlL.setImageResource(paramInt1);
    this.HlL.setBackgroundResource(0);
    if (paramInt1 == 2131234523) {
      this.HlL.setContentDescription(getContext().getString(2131764714));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.HlL.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.HlL.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(143009);
      return;
      this.HlL.setContentDescription(getContext().getString(2131757419));
    }
  }
  
  public final void fdv()
  {
    AppMethodBeat.i(143013);
    this.HlK.clearFocus();
    AppMethodBeat.o(143013);
  }
  
  public final boolean fdw()
  {
    AppMethodBeat.i(143014);
    if (this.HlK != null)
    {
      boolean bool = this.HlK.hasFocus();
      AppMethodBeat.o(143014);
      return bool;
    }
    AppMethodBeat.o(143014);
    return false;
  }
  
  public final boolean fdx()
  {
    AppMethodBeat.i(143015);
    if (this.HlK != null)
    {
      boolean bool = this.HlK.requestFocus();
      AppMethodBeat.o(143015);
      return bool;
    }
    AppMethodBeat.o(143015);
    return false;
  }
  
  protected int getLayoutId()
  {
    return 2131492924;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(143003);
    if (this.HlK.getEditableText() != null)
    {
      String str = this.HlK.getEditableText().toString();
      AppMethodBeat.o(143003);
      return str;
    }
    AppMethodBeat.o(143003);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(143021);
    if (this.HlK != null)
    {
      int i = this.HlK.getSelectionEnd();
      AppMethodBeat.o(143021);
      return i;
    }
    AppMethodBeat.o(143021);
    return -1;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(143020);
    if (this.HlK != null)
    {
      int i = this.HlK.getSelectionStart();
      AppMethodBeat.o(143020);
      return i;
    }
    AppMethodBeat.o(143020);
    return -1;
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.HlO != null) {
      this.HlO.Hur = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.HlQ = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.HlP = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(143016);
    if (this.HlK != null)
    {
      this.HlK.setFocusable(false);
      this.HlK.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(143016);
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143007);
    this.HlK.setEnabled(paramBoolean);
    AppMethodBeat.o(143007);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.HlS = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143005);
    this.HlK.setHint(paramCharSequence);
    AppMethodBeat.o(143005);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143017);
    if (this.HlO != null)
    {
      w localw = this.HlO;
      localw.Huq = paramArrayList;
      if (localw.Hur)
      {
        paramArrayList = (EditText)localw.Hup.get();
        if (paramArrayList != null) {
          w.a(paramArrayList, localw.Huq);
        }
      }
    }
    AppMethodBeat.o(143017);
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(143011);
    this.HlK.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(143011);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143004);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.HlK.setText(str);
    this.HlK.setSelection(str.length());
    AppMethodBeat.o(143004);
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    AppMethodBeat.i(143018);
    if (this.HlK != null) {
      this.HlK.setCompoundDrawables(aj.getResources().getDrawable(paramInt), null, null, null);
    }
    AppMethodBeat.o(143018);
  }
  
  public void setSelectedTag(String paramString)
  {
    AppMethodBeat.i(143019);
    if (this.HlK != null)
    {
      this.HlK.setCompoundDrawables(new d(this.HlK, paramString), null, null, null);
      this.HlK.setHint("");
    }
    AppMethodBeat.o(143019);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143008);
    this.HlL.setEnabled(paramBoolean);
    AppMethodBeat.o(143008);
  }
  
  public final void wE(boolean paramBoolean)
  {
    AppMethodBeat.i(143006);
    this.HlN = paramBoolean;
    fdu();
    AppMethodBeat.o(143006);
  }
  
  public final void wF(boolean paramBoolean)
  {
    AppMethodBeat.i(143012);
    if (!paramBoolean)
    {
      this.HlK.removeTextChangedListener(this.CfH);
      this.HlK.setText("");
      this.HlK.addTextChangedListener(this.CfH);
      AppMethodBeat.o(143012);
      return;
    }
    this.HlK.setText("");
    AppMethodBeat.o(143012);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView HlW;
    
    public ActionBarEditText(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public ActionBarEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(142993);
      ad.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          ad.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          AppMethodBeat.o(142993);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          ad.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            ad.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
            this.HlW.clearFocus();
            paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
            if (paramKeyEvent != null) {
              paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            AppMethodBeat.o(142993);
            return true;
          }
        }
      }
      boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
      AppMethodBeat.o(142993);
      return bool;
    }
    
    public void setSearchView(ActionBarSearchView paramActionBarSearchView)
    {
      this.HlW = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void fdy();
  }
  
  public static abstract interface b
  {
    public abstract void aBF(String paramString);
    
    public abstract void aIl();
    
    public abstract void fdA();
    
    public abstract void fdz();
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(142996);
      HlX = new c("CLEAR", 0);
      HlY = new c("VOICE_SEARCH", 1);
      HlZ = new c[] { HlX, HlY };
      AppMethodBeat.o(142996);
    }
    
    private c() {}
  }
  
  final class d
    extends Drawable
  {
    private RectF BjB;
    private int Hma;
    private float Hmb;
    private float Hmc;
    private String mText;
    private Paint tju;
    
    d(EditText paramEditText, String paramString)
    {
      AppMethodBeat.i(142997);
      this.Hma = BackwardSupportUtil.b.g(aj.getContext(), 2.0F);
      this.tju = new Paint(paramEditText.getPaint());
      this.mText = paramString;
      this.tju.setColor(aj.getResources().getColor(2131100035));
      this.Hmb = this.tju.measureText(this.mText);
      this$1 = this.tju.getFontMetrics();
      this.Hmc = ((float)Math.ceil(ActionBarSearchView.this.bottom - ActionBarSearchView.this.top));
      float f = this.Hmc;
      setBounds(0, 0, (int)(this.Hmb + this.Hma * 2 + this.Hma * 2 + 2.0F), (int)f);
      AppMethodBeat.o(142997);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(142998);
      Paint.FontMetricsInt localFontMetricsInt = this.tju.getFontMetricsInt();
      Rect localRect = getBounds();
      int i = localRect.right;
      i = localRect.left;
      float f = this.BjB.right;
      f = this.BjB.left;
      i = localRect.top;
      int j = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int k = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, localRect.left + 2, i + j - k, this.tju);
      AppMethodBeat.o(142998);
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142999);
      super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      Paint.FontMetrics localFontMetrics = this.tju.getFontMetrics();
      float f1 = this.Hma + paramInt1;
      float f2 = paramInt2;
      this.BjB = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.Hma, paramInt4);
      invalidateSelf();
      AppMethodBeat.o(142999);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ActionBarSearchView
 * JD-Core Version:    0.7.0.1
 */