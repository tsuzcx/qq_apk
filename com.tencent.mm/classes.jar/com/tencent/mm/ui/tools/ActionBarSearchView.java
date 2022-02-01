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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements d
{
  private TextWatcher DxY;
  private boolean Hga;
  private View IMe;
  protected ActionBarEditText IMf;
  private ImageButton IMg;
  private c IMh;
  private boolean IMi;
  private w IMj;
  private b IMk;
  private a IMl;
  private View.OnFocusChangeListener IMm;
  private View.OnFocusChangeListener IMn;
  private View.OnClickListener IMo;
  private View.OnClickListener IMp;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143001);
    this.IMh = c.IMs;
    this.IMi = false;
    this.Hga = false;
    this.DxY = new TextWatcher()
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
        if (localw.IUO)
        {
          localEditText = (EditText)localw.IUM.get();
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
          ((ActionBarSearchView.b)localObject).aGX(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localw.mText == null) || (localw.mText.length() == 0) || ((localw.mText != null) && (paramAnonymousCharSequence != null) && (localw.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            ac.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localw.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localw.mText = ((String)localObject);
            localw.IUL = w.l(localw.mText, localw.IUN);
            if (!w.a(localEditText, localw.IUN)) {
              break;
            }
            ac.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.IMm = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        ac.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.IMo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        if (ActionBarSearchView.c.IMs == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ac.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.xM(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
          {
            ActionBarSearchView.c(ActionBarSearchView.this).aPc();
            AppMethodBeat.o(142988);
          }
        }
        else
        {
          ac.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).ftv();
          }
        }
        AppMethodBeat.o(142988);
      }
    };
    this.IMp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).ftt();
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
    this.IMh = c.IMs;
    this.IMi = false;
    this.Hga = false;
    this.DxY = new TextWatcher()
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
        if (localw.IUO)
        {
          localEditText = (EditText)localw.IUM.get();
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
          ((ActionBarSearchView.b)localObject).aGX(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localw.mText == null) || (localw.mText.length() == 0) || ((localw.mText != null) && (paramAnonymousCharSequence != null) && (localw.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            ac.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localw.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localw.mText = ((String)localObject);
            localw.IUL = w.l(localw.mText, localw.IUN);
            if (!w.a(localEditText, localw.IUN)) {
              break;
            }
            ac.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.IMm = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        ac.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.IMo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        if (ActionBarSearchView.c.IMs == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ac.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.xM(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
          {
            ActionBarSearchView.c(ActionBarSearchView.this).aPc();
            AppMethodBeat.o(142988);
          }
        }
        else
        {
          ac.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).ftv();
          }
        }
        AppMethodBeat.o(142988);
      }
    };
    this.IMp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).ftt();
        }
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143000);
  }
  
  private void ftp()
  {
    AppMethodBeat.i(143010);
    if ((this.IMf.getEditableText() != null) && (!bs.isNullOrNil(this.IMf.getEditableText().toString())))
    {
      jL(2131233918, getResources().getDimensionPixelSize(2131165514));
      this.IMh = c.IMs;
      AppMethodBeat.o(143010);
      return;
    }
    if (this.IMi)
    {
      jL(2131234523, getResources().getDimensionPixelSize(2131165514));
      this.IMh = c.IMt;
      AppMethodBeat.o(143010);
      return;
    }
    jL(0, 0);
    this.IMh = c.IMs;
    AppMethodBeat.o(143010);
  }
  
  private void init()
  {
    AppMethodBeat.i(143002);
    this.Hga = aj.DT();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
    this.IMe = findViewById(2131297690);
    this.IMe.setOnClickListener(this.IMp);
    this.IMf = ((ActionBarEditText)findViewById(2131299306));
    this.IMj = new w(this.IMf);
    this.IMf.setSearchView(this);
    this.IMf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142990);
        ActionBarSearchView.this.IMf.setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).ftu();
        }
        AppMethodBeat.o(142990);
      }
    });
    this.IMg = ((ImageButton)findViewById(2131305196));
    this.IMf.addTextChangedListener(this.DxY);
    this.IMf.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142991);
        if (paramAnonymousInt == 67)
        {
          ac.d("MicroMsg.ActionBarSearchView", "on back key click.");
          Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          if (((w)localObject).IUO)
          {
            paramAnonymousView = (EditText)((w)localObject).IUM.get();
            if ((paramAnonymousView != null) && (((w)localObject).IUL != null)) {}
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
            localObject = ((w)localObject).acu(paramAnonymousInt);
            if ((localObject != null) && (((w.b)localObject).IUR))
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
    this.IMf.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(142992);
        ac.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((w)localObject).IUO)
        {
          localEditText = (EditText)((w)localObject).IUM.get();
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
          localObject = ((w)localObject).acu(paramAnonymousInt2);
          if ((localObject != null) && (((w.b)localObject).IUR))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((w.b)localObject).start;
            localEditText.setSelection(((w.b)localObject).length + paramAnonymousInt1);
          }
          AppMethodBeat.o(142992);
          return;
        }
        w.b localb = ((w)localObject).acu(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.IUR) {
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
        localObject = ((w)localObject).acu(i);
        if ((localObject != null) && (((w.b)localObject).IUR))
        {
          paramAnonymousInt2 = ((w.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(142992);
      }
    });
    this.IMf.setOnFocusChangeListener(this.IMm);
    c.d(this.IMf).acw(100).a(null);
    this.IMg.setOnClickListener(this.IMo);
    if (this.IMg.getDrawable() != null) {
      this.IMg.getDrawable().setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(143002);
  }
  
  private void jL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143009);
    this.IMg.setImageResource(paramInt1);
    this.IMg.setBackgroundResource(0);
    if (paramInt1 == 2131234523) {
      this.IMg.setContentDescription(getContext().getString(2131764714));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.IMg.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.IMg.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(143009);
      return;
      this.IMg.setContentDescription(getContext().getString(2131757419));
    }
  }
  
  public final void ftq()
  {
    AppMethodBeat.i(143013);
    this.IMf.clearFocus();
    AppMethodBeat.o(143013);
  }
  
  public final boolean ftr()
  {
    AppMethodBeat.i(143014);
    if (this.IMf != null)
    {
      boolean bool = this.IMf.hasFocus();
      AppMethodBeat.o(143014);
      return bool;
    }
    AppMethodBeat.o(143014);
    return false;
  }
  
  public final boolean fts()
  {
    AppMethodBeat.i(143015);
    if (this.IMf != null)
    {
      boolean bool = this.IMf.requestFocus();
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
    if (this.IMf.getEditableText() != null)
    {
      String str = this.IMf.getEditableText().toString();
      AppMethodBeat.o(143003);
      return str;
    }
    AppMethodBeat.o(143003);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(143021);
    if (this.IMf != null)
    {
      int i = this.IMf.getSelectionEnd();
      AppMethodBeat.o(143021);
      return i;
    }
    AppMethodBeat.o(143021);
    return -1;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(143020);
    if (this.IMf != null)
    {
      int i = this.IMf.getSelectionStart();
      AppMethodBeat.o(143020);
      return i;
    }
    AppMethodBeat.o(143020);
    return -1;
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.IMj != null) {
      this.IMj.IUO = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.IMl = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.IMk = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(143016);
    if (this.IMf != null)
    {
      this.IMf.setFocusable(false);
      this.IMf.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(143016);
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143007);
    this.IMf.setEnabled(paramBoolean);
    AppMethodBeat.o(143007);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.IMn = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143005);
    this.IMf.setHint(paramCharSequence);
    AppMethodBeat.o(143005);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143017);
    if (this.IMj != null)
    {
      w localw = this.IMj;
      localw.IUN = paramArrayList;
      if (localw.IUO)
      {
        paramArrayList = (EditText)localw.IUM.get();
        if (paramArrayList != null) {
          w.a(paramArrayList, localw.IUN);
        }
      }
    }
    AppMethodBeat.o(143017);
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(143011);
    this.IMf.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(143011);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143004);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.IMf.setText(str);
    this.IMf.setSelection(str.length());
    AppMethodBeat.o(143004);
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    AppMethodBeat.i(143018);
    if (this.IMf != null) {
      this.IMf.setCompoundDrawables(ai.getResources().getDrawable(paramInt), null, null, null);
    }
    AppMethodBeat.o(143018);
  }
  
  public void setSelectedTag(String paramString)
  {
    AppMethodBeat.i(143019);
    if (this.IMf != null)
    {
      this.IMf.setCompoundDrawables(new d(this.IMf, paramString), null, null, null);
      this.IMf.setHint("");
    }
    AppMethodBeat.o(143019);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143008);
    this.IMg.setEnabled(paramBoolean);
    AppMethodBeat.o(143008);
  }
  
  public final void xL(boolean paramBoolean)
  {
    AppMethodBeat.i(143006);
    this.IMi = paramBoolean;
    ftp();
    AppMethodBeat.o(143006);
  }
  
  public final void xM(boolean paramBoolean)
  {
    AppMethodBeat.i(143012);
    if (!paramBoolean)
    {
      this.IMf.removeTextChangedListener(this.DxY);
      this.IMf.setText("");
      this.IMf.addTextChangedListener(this.DxY);
      AppMethodBeat.o(143012);
      return;
    }
    this.IMf.setText("");
    AppMethodBeat.o(143012);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView IMr;
    
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
      ac.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          ac.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          AppMethodBeat.o(142993);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          ac.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            ac.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
            this.IMr.clearFocus();
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
      this.IMr = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ftt();
  }
  
  public static abstract interface b
  {
    public abstract void aGX(String paramString);
    
    public abstract void aPc();
    
    public abstract void ftu();
    
    public abstract void ftv();
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(142996);
      IMs = new c("CLEAR", 0);
      IMt = new c("VOICE_SEARCH", 1);
      IMu = new c[] { IMs, IMt };
      AppMethodBeat.o(142996);
    }
    
    private c() {}
  }
  
  final class d
    extends Drawable
  {
    private RectF CBO;
    private int IMv;
    private float IMw;
    private float IMx;
    private String mText;
    private Paint urN;
    
    d(EditText paramEditText, String paramString)
    {
      AppMethodBeat.i(142997);
      this.IMv = BackwardSupportUtil.b.g(ai.getContext(), 2.0F);
      this.urN = new Paint(paramEditText.getPaint());
      this.mText = paramString;
      this.urN.setColor(ai.getResources().getColor(2131100035));
      this.IMw = this.urN.measureText(this.mText);
      this$1 = this.urN.getFontMetrics();
      this.IMx = ((float)Math.ceil(ActionBarSearchView.this.bottom - ActionBarSearchView.this.top));
      float f = this.IMx;
      setBounds(0, 0, (int)(this.IMw + this.IMv * 2 + this.IMv * 2 + 2.0F), (int)f);
      AppMethodBeat.o(142997);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(142998);
      Paint.FontMetricsInt localFontMetricsInt = this.urN.getFontMetricsInt();
      Rect localRect = getBounds();
      int i = localRect.right;
      i = localRect.left;
      float f = this.CBO.right;
      f = this.CBO.left;
      i = localRect.top;
      int j = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int k = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, localRect.left + 2, i + j - k, this.urN);
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
      Paint.FontMetrics localFontMetrics = this.urN.getFontMetrics();
      float f1 = this.IMv + paramInt1;
      float f2 = paramInt2;
      this.CBO = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.IMv, paramInt4);
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