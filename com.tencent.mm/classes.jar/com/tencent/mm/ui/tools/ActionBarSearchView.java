package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements d
{
  private View ApR;
  protected ActionBarEditText ApS;
  private ImageButton ApT;
  private c ApU;
  private boolean ApV;
  private u ApW;
  private b ApX;
  private a ApY;
  private View.OnFocusChangeListener ApZ;
  private View.OnFocusChangeListener Aqa;
  private View.OnClickListener Aqb;
  private View.OnClickListener Aqc;
  private boolean qGO;
  private TextWatcher vYh;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107564);
    this.ApU = c.Aqf;
    this.ApV = false;
    this.qGO = false;
    this.vYh = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107549);
        ActionBarSearchView.a(ActionBarSearchView.this);
        u localu = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localu.Ayk)
        {
          localEditText = (EditText)localu.Ayi.get();
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
          ((ActionBarSearchView.b)localObject).Sk(paramAnonymousCharSequence);
          AppMethodBeat.o(107549);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localu.mText == null) || (localu.mText.length() == 0) || ((localu.mText != null) && (paramAnonymousCharSequence != null) && (localu.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            ab.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localu.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localu.mText = ((String)localObject);
            localu.Ayh = u.m(localu.mText, localu.Ayj);
            if (!u.a(localEditText, localu.Ayj)) {
              break;
            }
            ab.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.ApZ = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(107550);
        ab.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(107550);
      }
    };
    this.Aqb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107551);
        if (ActionBarSearchView.c.Aqf == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ab.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.rs(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
          {
            ActionBarSearchView.c(ActionBarSearchView.this).apP();
            AppMethodBeat.o(107551);
          }
        }
        else
        {
          ab.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).bMm();
          }
        }
        AppMethodBeat.o(107551);
      }
    };
    this.Aqc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107552);
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).bMn();
        }
        AppMethodBeat.o(107552);
      }
    };
    init();
    AppMethodBeat.o(107564);
  }
  
  public ActionBarSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107563);
    this.ApU = c.Aqf;
    this.ApV = false;
    this.qGO = false;
    this.vYh = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(107549);
        ActionBarSearchView.a(ActionBarSearchView.this);
        u localu = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localu.Ayk)
        {
          localEditText = (EditText)localu.Ayi.get();
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
          ((ActionBarSearchView.b)localObject).Sk(paramAnonymousCharSequence);
          AppMethodBeat.o(107549);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localu.mText == null) || (localu.mText.length() == 0) || ((localu.mText != null) && (paramAnonymousCharSequence != null) && (localu.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            ab.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localu.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localu.mText = ((String)localObject);
            localu.Ayh = u.m(localu.mText, localu.Ayj);
            if (!u.a(localEditText, localu.Ayj)) {
              break;
            }
            ab.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.ApZ = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(107550);
        ab.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(107550);
      }
    };
    this.Aqb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107551);
        if (ActionBarSearchView.c.Aqf == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ab.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.rs(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
          {
            ActionBarSearchView.c(ActionBarSearchView.this).apP();
            AppMethodBeat.o(107551);
          }
        }
        else
        {
          ab.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).bMm();
          }
        }
        AppMethodBeat.o(107551);
      }
    };
    this.Aqc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107552);
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).bMn();
        }
        AppMethodBeat.o(107552);
      }
    };
    init();
    AppMethodBeat.o(107563);
  }
  
  private void dNw()
  {
    AppMethodBeat.i(107573);
    if ((this.ApS.getEditableText() != null) && (!bo.isNullOrNil(this.ApS.getEditableText().toString())))
    {
      hM(2130840216, getResources().getDimensionPixelSize(2131427806));
      this.ApU = c.Aqf;
      AppMethodBeat.o(107573);
      return;
    }
    if (this.ApV)
    {
      hM(2130840709, getResources().getDimensionPixelSize(2131427806));
      this.ApU = c.Aqg;
      AppMethodBeat.o(107573);
      return;
    }
    hM(0, 0);
    this.ApU = c.Aqf;
    AppMethodBeat.o(107573);
  }
  
  private void hM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107572);
    this.ApT.setImageResource(paramInt1);
    this.ApT.setBackgroundResource(0);
    if (paramInt1 == 2130840709) {
      this.ApT.setContentDescription(getContext().getString(2131304544));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.ApT.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.ApT.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(107572);
      return;
      this.ApT.setContentDescription(getContext().getString(2131298408));
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(107565);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
    this.ApR = findViewById(2131820992);
    this.ApR.setOnClickListener(this.Aqc);
    this.ApS = ((ActionBarEditText)findViewById(2131820995));
    this.ApW = new u(this.ApS);
    this.ApS.setSearchView(this);
    this.ApS.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107553);
        ActionBarSearchView.this.ApS.setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).bMl();
        }
        AppMethodBeat.o(107553);
      }
    });
    this.ApT = ((ImageButton)findViewById(2131820996));
    this.ApS.addTextChangedListener(this.vYh);
    this.ApS.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(107554);
        if (paramAnonymousInt == 67)
        {
          ab.d("MicroMsg.ActionBarSearchView", "on back key click.");
          Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          if (((u)localObject).Ayk)
          {
            paramAnonymousView = (EditText)((u)localObject).Ayi.get();
            if ((paramAnonymousView != null) && (((u)localObject).Ayh != null)) {}
          }
          else
          {
            AppMethodBeat.o(107554);
            return false;
          }
          paramAnonymousKeyEvent = paramAnonymousView.getText();
          paramAnonymousInt = paramAnonymousView.getSelectionStart();
          if (paramAnonymousInt == paramAnonymousView.getSelectionEnd())
          {
            localObject = ((u)localObject).QQ(paramAnonymousInt);
            if ((localObject != null) && (((u.b)localObject).Ayn))
            {
              paramAnonymousKeyEvent.delete(((u.b)localObject).start, ((u.b)localObject).start + ((u.b)localObject).length);
              paramAnonymousView.setTextKeepState(paramAnonymousKeyEvent);
              paramAnonymousView.setSelection(((u.b)localObject).start);
              AppMethodBeat.o(107554);
              return true;
            }
          }
          AppMethodBeat.o(107554);
          return false;
        }
        AppMethodBeat.o(107554);
        return false;
      }
    });
    this.ApS.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107555);
        ab.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((u)localObject).Ayk)
        {
          localEditText = (EditText)((u)localObject).Ayi.get();
          if ((localEditText != null) && (paramAnonymousEditText == localEditText)) {}
        }
        else
        {
          AppMethodBeat.o(107555);
          return;
        }
        paramAnonymousEditText = localEditText.getText();
        paramAnonymousInt2 = localEditText.getSelectionStart();
        int i = localEditText.getSelectionEnd();
        if ((paramAnonymousInt2 < 0) || (i < paramAnonymousInt2))
        {
          AppMethodBeat.o(107555);
          return;
        }
        if (paramAnonymousInt2 == i)
        {
          localObject = ((u)localObject).QQ(paramAnonymousInt2);
          if ((localObject != null) && (((u.b)localObject).Ayn))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((u.b)localObject).start;
            localEditText.setSelection(((u.b)localObject).length + paramAnonymousInt1);
          }
          AppMethodBeat.o(107555);
          return;
        }
        u.b localb = ((u)localObject).QQ(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.Ayn) {
            paramAnonymousInt1 = localb.start + localb.length;
          }
        }
        if (paramAnonymousInt1 >= i)
        {
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1);
          AppMethodBeat.o(107555);
          return;
        }
        localObject = ((u)localObject).QQ(i);
        if ((localObject != null) && (((u.b)localObject).Ayn))
        {
          paramAnonymousInt2 = ((u.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(107555);
      }
    });
    this.ApS.setOnFocusChangeListener(this.ApZ);
    c.d(this.ApS).QS(100).a(null);
    this.ApT.setOnClickListener(this.Aqb);
    AppMethodBeat.o(107565);
  }
  
  public final void dNx()
  {
    AppMethodBeat.i(107576);
    this.ApS.clearFocus();
    AppMethodBeat.o(107576);
  }
  
  public final boolean dNy()
  {
    AppMethodBeat.i(107577);
    if (this.ApS != null)
    {
      boolean bool = this.ApS.hasFocus();
      AppMethodBeat.o(107577);
      return bool;
    }
    AppMethodBeat.o(107577);
    return false;
  }
  
  public final boolean dNz()
  {
    AppMethodBeat.i(107578);
    if (this.ApS != null)
    {
      boolean bool = this.ApS.requestFocus();
      AppMethodBeat.o(107578);
      return bool;
    }
    AppMethodBeat.o(107578);
    return false;
  }
  
  protected int getLayoutId()
  {
    return 2130968616;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(107566);
    if (this.ApS.getEditableText() != null)
    {
      String str = this.ApS.getEditableText().toString();
      AppMethodBeat.o(107566);
      return str;
    }
    AppMethodBeat.o(107566);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(107584);
    if (this.ApS != null)
    {
      int i = this.ApS.getSelectionEnd();
      AppMethodBeat.o(107584);
      return i;
    }
    AppMethodBeat.o(107584);
    return -1;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(107583);
    if (this.ApS != null)
    {
      int i = this.ApS.getSelectionStart();
      AppMethodBeat.o(107583);
      return i;
    }
    AppMethodBeat.o(107583);
    return -1;
  }
  
  public final void rr(boolean paramBoolean)
  {
    AppMethodBeat.i(107569);
    this.ApV = paramBoolean;
    dNw();
    AppMethodBeat.o(107569);
  }
  
  public final void rs(boolean paramBoolean)
  {
    AppMethodBeat.i(107575);
    if (!paramBoolean)
    {
      this.ApS.removeTextChangedListener(this.vYh);
      this.ApS.setText("");
      this.ApS.addTextChangedListener(this.vYh);
      AppMethodBeat.o(107575);
      return;
    }
    this.ApS.setText("");
    AppMethodBeat.o(107575);
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.ApW != null) {
      this.ApW.Ayk = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.ApY = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.ApX = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(107579);
    if (this.ApS != null)
    {
      this.ApS.setFocusable(false);
      this.ApS.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(107579);
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(107570);
    this.ApS.setEnabled(paramBoolean);
    AppMethodBeat.o(107570);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.Aqa = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107568);
    this.ApS.setHint(paramCharSequence);
    AppMethodBeat.o(107568);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(107580);
    if (this.ApW != null)
    {
      u localu = this.ApW;
      localu.Ayj = paramArrayList;
      if (localu.Ayk)
      {
        paramArrayList = (EditText)localu.Ayi.get();
        if (paramArrayList != null) {
          u.a(paramArrayList, localu.Ayj);
        }
      }
    }
    AppMethodBeat.o(107580);
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(107574);
    this.ApS.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(107574);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(107567);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.ApS.setText(str);
    this.ApS.setSelection(str.length());
    AppMethodBeat.o(107567);
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    AppMethodBeat.i(107581);
    if (this.ApS != null) {
      this.ApS.setCompoundDrawables(ah.getResources().getDrawable(paramInt), null, null, null);
    }
    AppMethodBeat.o(107581);
  }
  
  public void setSelectedTag(String paramString)
  {
    AppMethodBeat.i(107582);
    if (this.ApS != null)
    {
      this.ApS.setCompoundDrawables(new d(this.ApS, paramString), null, null, null);
      this.ApS.setHint("");
    }
    AppMethodBeat.o(107582);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(107571);
    this.ApT.setEnabled(paramBoolean);
    AppMethodBeat.o(107571);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView Aqe;
    
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
      AppMethodBeat.i(107556);
      ab.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          ab.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          AppMethodBeat.o(107556);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          ab.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            ab.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
            this.Aqe.clearFocus();
            paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
            if (paramKeyEvent != null) {
              paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            AppMethodBeat.o(107556);
            return true;
          }
        }
      }
      boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
      AppMethodBeat.o(107556);
      return bool;
    }
    
    public void setSearchView(ActionBarSearchView paramActionBarSearchView)
    {
      this.Aqe = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bMn();
  }
  
  public static abstract interface b
  {
    public abstract void Sk(String paramString);
    
    public abstract void apP();
    
    public abstract void bMl();
    
    public abstract void bMm();
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(107559);
      Aqf = new c("CLEAR", 0);
      Aqg = new c("VOICE_SEARCH", 1);
      Aqh = new c[] { Aqf, Aqg };
      AppMethodBeat.o(107559);
    }
    
    private c() {}
  }
  
  final class d
    extends Drawable
  {
    private int Aqi;
    private float Aqj;
    private float Aqk;
    private RectF gM;
    private String mText;
    private Paint oqV;
    
    d(EditText paramEditText, String paramString)
    {
      AppMethodBeat.i(107560);
      this.Aqi = BackwardSupportUtil.b.b(ah.getContext(), 2.0F);
      this.oqV = new Paint(paramEditText.getPaint());
      this.mText = paramString;
      this.oqV.setColor(ah.getResources().getColor(2131689778));
      this.Aqj = this.oqV.measureText(this.mText);
      this$1 = this.oqV.getFontMetrics();
      this.Aqk = ((float)Math.ceil(ActionBarSearchView.this.bottom - ActionBarSearchView.this.top));
      float f = this.Aqk;
      setBounds(0, 0, (int)(this.Aqj + this.Aqi * 2 + this.Aqi * 2 + 2.0F), (int)f);
      AppMethodBeat.o(107560);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(107561);
      Paint.FontMetricsInt localFontMetricsInt = this.oqV.getFontMetricsInt();
      Rect localRect = getBounds();
      int i = localRect.right;
      i = localRect.left;
      float f = this.gM.right;
      f = this.gM.left;
      i = localRect.top;
      int j = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int k = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, localRect.left + 2, i + j - k, this.oqV);
      AppMethodBeat.o(107561);
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(107562);
      super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      Paint.FontMetrics localFontMetrics = this.oqV.getFontMetrics();
      float f1 = this.Aqi + paramInt1;
      float f2 = paramInt2;
      this.gM = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.Aqi, paramInt4);
      invalidateSelf();
      AppMethodBeat.o(107562);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ActionBarSearchView
 * JD-Core Version:    0.7.0.1
 */