package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements e
{
  private TextWatcher PuL;
  private boolean advd;
  private View afDg;
  protected ActionBarEditText afDh;
  private ImageButton afDi;
  private ActionBarSearchView.c afDj;
  private boolean afDk;
  private y afDl;
  private View afDm;
  private b afDn;
  private a afDo;
  private View.OnFocusChangeListener afDp;
  private View.OnFocusChangeListener afDq;
  private View.OnClickListener afDr;
  private View.OnClickListener afDs;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143001);
    this.afDj = ActionBarSearchView.c.afDv;
    this.afDk = false;
    this.advd = false;
    this.PuL = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142986);
        ActionBarSearchView.a(ActionBarSearchView.this);
        y localy = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localy.afLK)
        {
          localEditText = (EditText)localy.afLI.get();
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
          ((ActionBarSearchView.b)localObject).bqJ(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localy.mText == null) || (localy.mText.length() == 0) || ((localy.mText != null) && (paramAnonymousCharSequence != null) && (localy.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            Log.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localy.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localy.mText = ((String)localObject);
            localy.afLH = y.r(localy.mText, localy.afLJ);
            if (!y.a(localEditText, localy.afLJ)) {
              break;
            }
            Log.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.afDp = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        Log.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.afDr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ActionBarSearchView.c.afDv == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.MW(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).bWy();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).jCP();
          }
        }
      }
    };
    this.afDs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).jCN();
        }
        a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.afDj = ActionBarSearchView.c.afDv;
    this.afDk = false;
    this.advd = false;
    this.PuL = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142986);
        ActionBarSearchView.a(ActionBarSearchView.this);
        y localy = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localy.afLK)
        {
          localEditText = (EditText)localy.afLI.get();
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
          ((ActionBarSearchView.b)localObject).bqJ(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localy.mText == null) || (localy.mText.length() == 0) || ((localy.mText != null) && (paramAnonymousCharSequence != null) && (localy.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            Log.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localy.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localy.mText = ((String)localObject);
            localy.afLH = y.r(localy.mText, localy.afLJ);
            if (!y.a(localEditText, localy.afLJ)) {
              break;
            }
            Log.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.afDp = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        Log.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.afDr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ActionBarSearchView.c.afDv == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.MW(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).bWy();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).jCP();
          }
        }
      }
    };
    this.afDs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).jCN();
        }
        a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143000);
  }
  
  private void init()
  {
    AppMethodBeat.i(143002);
    this.advd = aw.isDarkMode();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
    this.afDg = findViewById(a.g.cancel_btn);
    this.afDg.setOnClickListener(this.afDs);
    this.afDh = ((ActionBarEditText)findViewById(a.g.edittext));
    this.afDl = new y(this.afDh);
    this.afDh.setSearchView(this);
    this.afDm = ((WeImageView)findViewById(a.g.search_icon));
    this.afDh.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142990);
        ActionBarSearchView.this.afDh.setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).jCO();
        }
        AppMethodBeat.o(142990);
      }
    });
    this.afDi = ((ImageButton)findViewById(a.g.status_btn));
    this.afDh.addTextChangedListener(this.PuL);
    this.afDh.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142991);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        ((b)localObject).sc(paramAnonymousInt);
        ((b)localObject).cH(paramAnonymousKeyEvent);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((b)localObject).aYj());
        if (paramAnonymousInt == 67)
        {
          Log.d("MicroMsg.ActionBarSearchView", "on back key click.");
          localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          boolean bool;
          if (((y)localObject).afLK)
          {
            paramAnonymousView = (EditText)((y)localObject).afLI.get();
            if ((paramAnonymousView != null) && (((y)localObject).afLH != null)) {}
          }
          else
          {
            bool = false;
          }
          for (;;)
          {
            a.a(bool, this, "com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(142991);
            return bool;
            paramAnonymousKeyEvent = paramAnonymousView.getText();
            paramAnonymousInt = paramAnonymousView.getSelectionStart();
            if (paramAnonymousInt == paramAnonymousView.getSelectionEnd())
            {
              localObject = ((y)localObject).aEe(paramAnonymousInt);
              if ((localObject != null) && (((y.b)localObject).afLN))
              {
                paramAnonymousKeyEvent.delete(((y.b)localObject).start, ((y.b)localObject).start + ((y.b)localObject).length);
                paramAnonymousView.setTextKeepState(paramAnonymousKeyEvent);
                paramAnonymousView.setSelection(((y.b)localObject).start);
                bool = true;
                continue;
              }
            }
            bool = false;
          }
        }
        a.a(false, this, "com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(142991);
        return false;
      }
    });
    this.afDh.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(142992);
        Log.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((y)localObject).afLK)
        {
          localEditText = (EditText)((y)localObject).afLI.get();
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
          localObject = ((y)localObject).aEe(paramAnonymousInt2);
          if ((localObject != null) && (((y.b)localObject).afLN))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((y.b)localObject).start;
            localEditText.setSelection(((y.b)localObject).length + paramAnonymousInt1);
          }
          AppMethodBeat.o(142992);
          return;
        }
        y.b localb = ((y)localObject).aEe(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.afLN) {
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
        localObject = ((y)localObject).aEe(i);
        if ((localObject != null) && (((y.b)localObject).afLN))
        {
          paramAnonymousInt2 = ((y.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(142992);
      }
    });
    this.afDh.setOnFocusChangeListener(this.afDp);
    c.i(this.afDh).aEg(100).a(null);
    this.afDi.setOnClickListener(this.afDr);
    if (this.afDi.getDrawable() != null) {
      this.afDi.getDrawable().setColorFilter(getResources().getColor(a.d.FG_0), PorterDuff.Mode.SRC_ATOP);
    }
    if (this.afDm != null) {
      this.afDm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(250980);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/tools/ActionBarSearchView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ActionBarSearchView.this.jCM();
          ActionBarSearchView.this.showVKB();
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(250980);
        }
      });
    }
    AppMethodBeat.o(143002);
  }
  
  private void jCJ()
  {
    AppMethodBeat.i(143010);
    if ((this.afDh.getEditableText() != null) && (!Util.isNullOrNil(this.afDh.getEditableText().toString())))
    {
      oA(a.f.search_clear, getResources().getDimensionPixelSize(a.e.NormalIconSize));
      this.afDj = ActionBarSearchView.c.afDv;
      AppMethodBeat.o(143010);
      return;
    }
    if (this.afDk)
    {
      oA(a.f.voicesearch_enter_btn, getResources().getDimensionPixelSize(a.e.NormalIconSize));
      this.afDj = ActionBarSearchView.c.afDw;
      AppMethodBeat.o(143010);
      return;
    }
    oA(0, 0);
    this.afDj = ActionBarSearchView.c.afDv;
    AppMethodBeat.o(143010);
  }
  
  private void oA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143009);
    this.afDi.setImageResource(paramInt1);
    this.afDi.setBackgroundResource(0);
    if (paramInt1 == a.f.voicesearch_enter_btn) {
      this.afDi.setContentDescription(getContext().getString(a.k.voice_Input));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.afDi.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.afDi.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(143009);
      return;
      this.afDi.setContentDescription(getContext().getString(a.k.clear_btn));
    }
  }
  
  public final void MV(boolean paramBoolean)
  {
    AppMethodBeat.i(143006);
    this.afDk = paramBoolean;
    jCJ();
    AppMethodBeat.o(143006);
  }
  
  public final void MW(boolean paramBoolean)
  {
    AppMethodBeat.i(143012);
    if (!paramBoolean)
    {
      this.afDh.removeTextChangedListener(this.PuL);
      this.afDh.setText("");
      this.afDh.addTextChangedListener(this.PuL);
      AppMethodBeat.o(143012);
      return;
    }
    this.afDh.setText("");
    AppMethodBeat.o(143012);
  }
  
  protected int getLayoutId()
  {
    return a.h.actionbar_searchview;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(143003);
    if (this.afDh.getEditableText() != null)
    {
      String str = this.afDh.getEditableText().toString();
      AppMethodBeat.o(143003);
      return str;
    }
    AppMethodBeat.o(143003);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(143021);
    if (this.afDh != null)
    {
      int i = this.afDh.getSelectionEnd();
      AppMethodBeat.o(143021);
      return i;
    }
    AppMethodBeat.o(143021);
    return -1;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(143020);
    if (this.afDh != null)
    {
      int i = this.afDh.getSelectionStart();
      AppMethodBeat.o(143020);
      return i;
    }
    AppMethodBeat.o(143020);
    return -1;
  }
  
  public final void iKw()
  {
    AppMethodBeat.i(251113);
    findViewById(a.g.actionbar_searchview_parent).setBackgroundColor(getResources().getColor(a.d.Dark_0));
    findViewById(a.g.search_ll).setBackgroundResource(a.f.black_bg);
    ((TextView)this.afDg).setTextColor(Color.parseColor("#7D90A9"));
    ((WeImageView)findViewById(a.g.search_icon)).setIconColor(Color.parseColor("#6B6B6B"));
    this.afDh.setTextColor(Color.parseColor("#CCFFFFFF"));
    this.afDh.setHintTextColor(Color.parseColor("#4DFFFFFF"));
    AppMethodBeat.o(251113);
  }
  
  public final void jCK()
  {
    AppMethodBeat.i(143013);
    this.afDh.clearFocus();
    AppMethodBeat.o(143013);
  }
  
  public final boolean jCL()
  {
    AppMethodBeat.i(143014);
    if (this.afDh != null)
    {
      boolean bool = this.afDh.hasFocus();
      AppMethodBeat.o(143014);
      return bool;
    }
    AppMethodBeat.o(143014);
    return false;
  }
  
  public final boolean jCM()
  {
    AppMethodBeat.i(143015);
    if (this.afDh != null)
    {
      boolean bool = this.afDh.requestFocus();
      AppMethodBeat.o(143015);
      return bool;
    }
    AppMethodBeat.o(143015);
    return false;
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.afDl != null) {
      this.afDl.afLK = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.afDo = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.afDn = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(143016);
    if (this.afDh != null)
    {
      this.afDh.setFocusable(false);
      this.afDh.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(143016);
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143007);
    this.afDh.setEnabled(paramBoolean);
    AppMethodBeat.o(143007);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.afDq = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143005);
    this.afDh.setHint(paramCharSequence);
    AppMethodBeat.o(143005);
  }
  
  public void setImeScene(int paramInt)
  {
    AppMethodBeat.i(251141);
    if (this.afDh != null) {
      this.afDh.getInputExtras(true).putInt("wechat_scene", paramInt);
    }
    AppMethodBeat.o(251141);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143017);
    if (this.afDl != null)
    {
      y localy = this.afDl;
      localy.afLJ = paramArrayList;
      if (localy.afLK)
      {
        paramArrayList = (EditText)localy.afLI.get();
        if (paramArrayList != null) {
          y.a(paramArrayList, localy.afLJ);
        }
      }
    }
    AppMethodBeat.o(143017);
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(143011);
    this.afDh.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(143011);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143004);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.afDh.setText(str);
    this.afDh.setSelection(str.length());
    AppMethodBeat.o(143004);
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    AppMethodBeat.i(143018);
    if (this.afDh != null) {
      this.afDh.setCompoundDrawables(MMApplicationContext.getResources().getDrawable(paramInt), null, null, null);
    }
    AppMethodBeat.o(143018);
  }
  
  public void setSelectedTag(String paramString)
  {
    AppMethodBeat.i(143019);
    if (this.afDh != null)
    {
      this.afDh.setCompoundDrawables(new ActionBarSearchView.d(this, this.afDh, paramString), null, null, null);
      this.afDh.setHint("");
    }
    AppMethodBeat.o(143019);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143008);
    this.afDi.setEnabled(paramBoolean);
    AppMethodBeat.o(143008);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(251106);
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.afDh, 0);
    AppMethodBeat.o(251106);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView afDu;
    
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
      Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          AppMethodBeat.o(142993);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
            this.afDu.clearFocus();
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
      this.afDu = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void jCN();
  }
  
  public static abstract interface b
  {
    public abstract void bWy();
    
    public abstract void bqJ(String paramString);
    
    public abstract void jCO();
    
    public abstract void jCP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ActionBarSearchView
 * JD-Core Version:    0.7.0.1
 */