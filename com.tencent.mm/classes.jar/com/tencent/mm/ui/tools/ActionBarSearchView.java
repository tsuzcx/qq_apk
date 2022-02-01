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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements d
{
  private TextWatcher Fdh;
  private boolean ITq;
  private View KDl;
  protected ActionBarEditText KDm;
  private ImageButton KDn;
  private c KDo;
  private boolean KDp;
  private w KDq;
  private b KDr;
  private a KDs;
  private View.OnFocusChangeListener KDt;
  private View.OnFocusChangeListener KDu;
  private View.OnClickListener KDv;
  private View.OnClickListener KDw;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143001);
    this.KDo = c.KDz;
    this.KDp = false;
    this.ITq = false;
    this.Fdh = new TextWatcher()
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
        if (localw.KLS)
        {
          localEditText = (EditText)localw.KLQ.get();
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
          ((ActionBarSearchView.b)localObject).aMA(paramAnonymousCharSequence);
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
            localw.KLP = w.l(localw.mText, localw.KLR);
            if (!w.a(localEditText, localw.KLR)) {
              break;
            }
            ad.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.KDt = new View.OnFocusChangeListener()
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
    this.KDv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ActionBarSearchView.c.KDz == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ad.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.yA(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).aSo();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          ad.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).fKj();
          }
        }
      }
    };
    this.KDw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).fKh();
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
    this.KDo = c.KDz;
    this.KDp = false;
    this.ITq = false;
    this.Fdh = new TextWatcher()
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
        if (localw.KLS)
        {
          localEditText = (EditText)localw.KLQ.get();
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
          ((ActionBarSearchView.b)localObject).aMA(paramAnonymousCharSequence);
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
            localw.KLP = w.l(localw.mText, localw.KLR);
            if (!w.a(localEditText, localw.KLR)) {
              break;
            }
            ad.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.KDt = new View.OnFocusChangeListener()
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
    this.KDv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ActionBarSearchView.c.KDz == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ad.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.yA(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).aSo();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          ad.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).fKj();
          }
        }
      }
    };
    this.KDw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).fKh();
        }
        a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143000);
  }
  
  private void fKd()
  {
    AppMethodBeat.i(143010);
    if ((this.KDm.getEditableText() != null) && (!bt.isNullOrNil(this.KDm.getEditableText().toString())))
    {
      jX(2131233918, getResources().getDimensionPixelSize(2131165514));
      this.KDo = c.KDz;
      AppMethodBeat.o(143010);
      return;
    }
    if (this.KDp)
    {
      jX(2131234523, getResources().getDimensionPixelSize(2131165514));
      this.KDo = c.KDA;
      AppMethodBeat.o(143010);
      return;
    }
    jX(0, 0);
    this.KDo = c.KDz;
    AppMethodBeat.o(143010);
  }
  
  private void init()
  {
    AppMethodBeat.i(143002);
    this.ITq = al.isDarkMode();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
    this.KDl = findViewById(2131297690);
    this.KDl.setOnClickListener(this.KDw);
    this.KDm = ((ActionBarEditText)findViewById(2131299306));
    this.KDq = new w(this.KDm);
    this.KDm.setSearchView(this);
    this.KDm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142990);
        ActionBarSearchView.this.KDm.setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).fKi();
        }
        AppMethodBeat.o(142990);
      }
    });
    this.KDn = ((ImageButton)findViewById(2131305196));
    this.KDm.addTextChangedListener(this.Fdh);
    this.KDm.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142991);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mr(paramAnonymousInt);
        ((b)localObject).bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((b)localObject).ahq());
        if (paramAnonymousInt == 67)
        {
          ad.d("MicroMsg.ActionBarSearchView", "on back key click.");
          localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          boolean bool;
          if (((w)localObject).KLS)
          {
            paramAnonymousView = (EditText)((w)localObject).KLQ.get();
            if ((paramAnonymousView != null) && (((w)localObject).KLP != null)) {}
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
              localObject = ((w)localObject).aeS(paramAnonymousInt);
              if ((localObject != null) && (((w.b)localObject).KLV))
              {
                paramAnonymousKeyEvent.delete(((w.b)localObject).start, ((w.b)localObject).start + ((w.b)localObject).length);
                paramAnonymousView.setTextKeepState(paramAnonymousKeyEvent);
                paramAnonymousView.setSelection(((w.b)localObject).start);
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
    this.KDm.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(142992);
        ad.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((w)localObject).KLS)
        {
          localEditText = (EditText)((w)localObject).KLQ.get();
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
          localObject = ((w)localObject).aeS(paramAnonymousInt2);
          if ((localObject != null) && (((w.b)localObject).KLV))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((w.b)localObject).start;
            localEditText.setSelection(((w.b)localObject).length + paramAnonymousInt1);
          }
          AppMethodBeat.o(142992);
          return;
        }
        w.b localb = ((w)localObject).aeS(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.KLV) {
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
        localObject = ((w)localObject).aeS(i);
        if ((localObject != null) && (((w.b)localObject).KLV))
        {
          paramAnonymousInt2 = ((w.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(142992);
      }
    });
    this.KDm.setOnFocusChangeListener(this.KDt);
    c.d(this.KDm).aeU(100).a(null);
    this.KDn.setOnClickListener(this.KDv);
    if (this.KDn.getDrawable() != null) {
      this.KDn.getDrawable().setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(143002);
  }
  
  private void jX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143009);
    this.KDn.setImageResource(paramInt1);
    this.KDn.setBackgroundResource(0);
    if (paramInt1 == 2131234523) {
      this.KDn.setContentDescription(getContext().getString(2131764714));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.KDn.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.KDn.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(143009);
      return;
      this.KDn.setContentDescription(getContext().getString(2131757419));
    }
  }
  
  public final void fKe()
  {
    AppMethodBeat.i(143013);
    this.KDm.clearFocus();
    AppMethodBeat.o(143013);
  }
  
  public final boolean fKf()
  {
    AppMethodBeat.i(143014);
    if (this.KDm != null)
    {
      boolean bool = this.KDm.hasFocus();
      AppMethodBeat.o(143014);
      return bool;
    }
    AppMethodBeat.o(143014);
    return false;
  }
  
  public final boolean fKg()
  {
    AppMethodBeat.i(143015);
    if (this.KDm != null)
    {
      boolean bool = this.KDm.requestFocus();
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
    if (this.KDm.getEditableText() != null)
    {
      String str = this.KDm.getEditableText().toString();
      AppMethodBeat.o(143003);
      return str;
    }
    AppMethodBeat.o(143003);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(143021);
    if (this.KDm != null)
    {
      int i = this.KDm.getSelectionEnd();
      AppMethodBeat.o(143021);
      return i;
    }
    AppMethodBeat.o(143021);
    return -1;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(143020);
    if (this.KDm != null)
    {
      int i = this.KDm.getSelectionStart();
      AppMethodBeat.o(143020);
      return i;
    }
    AppMethodBeat.o(143020);
    return -1;
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.KDq != null) {
      this.KDq.KLS = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.KDs = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.KDr = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(143016);
    if (this.KDm != null)
    {
      this.KDm.setFocusable(false);
      this.KDm.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(143016);
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143007);
    this.KDm.setEnabled(paramBoolean);
    AppMethodBeat.o(143007);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.KDu = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143005);
    this.KDm.setHint(paramCharSequence);
    AppMethodBeat.o(143005);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143017);
    if (this.KDq != null)
    {
      w localw = this.KDq;
      localw.KLR = paramArrayList;
      if (localw.KLS)
      {
        paramArrayList = (EditText)localw.KLQ.get();
        if (paramArrayList != null) {
          w.a(paramArrayList, localw.KLR);
        }
      }
    }
    AppMethodBeat.o(143017);
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(143011);
    this.KDm.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(143011);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143004);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.KDm.setText(str);
    this.KDm.setSelection(str.length());
    AppMethodBeat.o(143004);
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    AppMethodBeat.i(143018);
    if (this.KDm != null) {
      this.KDm.setCompoundDrawables(aj.getResources().getDrawable(paramInt), null, null, null);
    }
    AppMethodBeat.o(143018);
  }
  
  public void setSelectedTag(String paramString)
  {
    AppMethodBeat.i(143019);
    if (this.KDm != null)
    {
      this.KDm.setCompoundDrawables(new d(this.KDm, paramString), null, null, null);
      this.KDm.setHint("");
    }
    AppMethodBeat.o(143019);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143008);
    this.KDn.setEnabled(paramBoolean);
    AppMethodBeat.o(143008);
  }
  
  public final void yA(boolean paramBoolean)
  {
    AppMethodBeat.i(143012);
    if (!paramBoolean)
    {
      this.KDm.removeTextChangedListener(this.Fdh);
      this.KDm.setText("");
      this.KDm.addTextChangedListener(this.Fdh);
      AppMethodBeat.o(143012);
      return;
    }
    this.KDm.setText("");
    AppMethodBeat.o(143012);
  }
  
  public final void yz(boolean paramBoolean)
  {
    AppMethodBeat.i(143006);
    this.KDp = paramBoolean;
    fKd();
    AppMethodBeat.o(143006);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView KDy;
    
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
            this.KDy.clearFocus();
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
      this.KDy = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void fKh();
  }
  
  public static abstract interface b
  {
    public abstract void aMA(String paramString);
    
    public abstract void aSo();
    
    public abstract void fKi();
    
    public abstract void fKj();
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(142996);
      KDz = new c("CLEAR", 0);
      KDA = new c("VOICE_SEARCH", 1);
      KDB = new c[] { KDz, KDA };
      AppMethodBeat.o(142996);
    }
    
    private c() {}
  }
  
  final class d
    extends Drawable
  {
    private RectF Efw;
    private int KDC;
    private float KDD;
    private float KDE;
    private String mText;
    private Paint vuq;
    
    d(EditText paramEditText, String paramString)
    {
      AppMethodBeat.i(142997);
      this.KDC = BackwardSupportUtil.b.g(aj.getContext(), 2.0F);
      this.vuq = new Paint(paramEditText.getPaint());
      this.mText = paramString;
      this.vuq.setColor(aj.getResources().getColor(2131100035));
      this.KDD = this.vuq.measureText(this.mText);
      this$1 = this.vuq.getFontMetrics();
      this.KDE = ((float)Math.ceil(ActionBarSearchView.this.bottom - ActionBarSearchView.this.top));
      float f = this.KDE;
      setBounds(0, 0, (int)(this.KDD + this.KDC * 2 + this.KDC * 2 + 2.0F), (int)f);
      AppMethodBeat.o(142997);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(142998);
      Paint.FontMetricsInt localFontMetricsInt = this.vuq.getFontMetricsInt();
      Rect localRect = getBounds();
      int i = localRect.right;
      i = localRect.left;
      float f = this.Efw.right;
      f = this.Efw.left;
      i = localRect.top;
      int j = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int k = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, localRect.left + 2, i + j - k, this.vuq);
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
      Paint.FontMetrics localFontMetrics = this.vuq.getFontMetrics();
      float f1 = this.KDC + paramInt1;
      float f2 = paramInt2;
      this.Efw = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.KDC, paramInt4);
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