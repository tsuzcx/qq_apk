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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  private TextWatcher FvF;
  private boolean JnY;
  private View KZF;
  protected ActionBarEditText KZG;
  private ImageButton KZH;
  private c KZI;
  private boolean KZJ;
  private x KZK;
  private b KZL;
  private a KZM;
  private View.OnFocusChangeListener KZN;
  private View.OnFocusChangeListener KZO;
  private View.OnClickListener KZP;
  private View.OnClickListener KZQ;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143001);
    this.KZI = c.KZT;
    this.KZJ = false;
    this.JnY = false;
    this.FvF = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142986);
        ActionBarSearchView.a(ActionBarSearchView.this);
        x localx = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localx.Liq)
        {
          localEditText = (EditText)localx.Lio.get();
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
          ((ActionBarSearchView.b)localObject).aNW(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localx.mText == null) || (localx.mText.length() == 0) || ((localx.mText != null) && (paramAnonymousCharSequence != null) && (localx.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            ae.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localx.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localx.mText = ((String)localObject);
            localx.Lin = x.l(localx.mText, localx.Lip);
            if (!x.a(localEditText, localx.Lip)) {
              break;
            }
            ae.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.KZN = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        ae.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.KZP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ActionBarSearchView.c.KZT == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ae.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.yN(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).aSN();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          ae.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).fOA();
          }
        }
      }
    };
    this.KZQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).fOy();
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
    this.KZI = c.KZT;
    this.KZJ = false;
    this.JnY = false;
    this.FvF = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142986);
        ActionBarSearchView.a(ActionBarSearchView.this);
        x localx = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localx.Liq)
        {
          localEditText = (EditText)localx.Lio.get();
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
          ((ActionBarSearchView.b)localObject).aNW(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localx.mText == null) || (localx.mText.length() == 0) || ((localx.mText != null) && (paramAnonymousCharSequence != null) && (localx.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            ae.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localx.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localx.mText = ((String)localObject);
            localx.Lin = x.l(localx.mText, localx.Lip);
            if (!x.a(localEditText, localx.Lip)) {
              break;
            }
            ae.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.KZN = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        ae.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.KZP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ActionBarSearchView.c.KZT == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          ae.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.yN(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).aSN();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          ae.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).fOA();
          }
        }
      }
    };
    this.KZQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).fOy();
        }
        a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143000);
  }
  
  private void fOu()
  {
    AppMethodBeat.i(143010);
    if ((this.KZG.getEditableText() != null) && (!bu.isNullOrNil(this.KZG.getEditableText().toString())))
    {
      ke(2131233918, getResources().getDimensionPixelSize(2131165514));
      this.KZI = c.KZT;
      AppMethodBeat.o(143010);
      return;
    }
    if (this.KZJ)
    {
      ke(2131234523, getResources().getDimensionPixelSize(2131165514));
      this.KZI = c.KZU;
      AppMethodBeat.o(143010);
      return;
    }
    ke(0, 0);
    this.KZI = c.KZT;
    AppMethodBeat.o(143010);
  }
  
  private void init()
  {
    AppMethodBeat.i(143002);
    this.JnY = al.isDarkMode();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
    this.KZF = findViewById(2131297690);
    this.KZF.setOnClickListener(this.KZQ);
    this.KZG = ((ActionBarEditText)findViewById(2131299306));
    this.KZK = new x(this.KZG);
    this.KZG.setSearchView(this);
    this.KZG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142990);
        ActionBarSearchView.this.KZG.setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).fOz();
        }
        AppMethodBeat.o(142990);
      }
    });
    this.KZH = ((ImageButton)findViewById(2131305196));
    this.KZG.addTextChangedListener(this.FvF);
    this.KZG.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142991);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mu(paramAnonymousInt);
        ((b)localObject).bd(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((b)localObject).ahF());
        if (paramAnonymousInt == 67)
        {
          ae.d("MicroMsg.ActionBarSearchView", "on back key click.");
          localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          boolean bool;
          if (((x)localObject).Liq)
          {
            paramAnonymousView = (EditText)((x)localObject).Lio.get();
            if ((paramAnonymousView != null) && (((x)localObject).Lin != null)) {}
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
              localObject = ((x)localObject).afB(paramAnonymousInt);
              if ((localObject != null) && (((x.b)localObject).Lit))
              {
                paramAnonymousKeyEvent.delete(((x.b)localObject).start, ((x.b)localObject).start + ((x.b)localObject).length);
                paramAnonymousView.setTextKeepState(paramAnonymousKeyEvent);
                paramAnonymousView.setSelection(((x.b)localObject).start);
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
    this.KZG.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(142992);
        ae.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((x)localObject).Liq)
        {
          localEditText = (EditText)((x)localObject).Lio.get();
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
          localObject = ((x)localObject).afB(paramAnonymousInt2);
          if ((localObject != null) && (((x.b)localObject).Lit))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((x.b)localObject).start;
            localEditText.setSelection(((x.b)localObject).length + paramAnonymousInt1);
          }
          AppMethodBeat.o(142992);
          return;
        }
        x.b localb = ((x)localObject).afB(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.Lit) {
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
        localObject = ((x)localObject).afB(i);
        if ((localObject != null) && (((x.b)localObject).Lit))
        {
          paramAnonymousInt2 = ((x.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(142992);
      }
    });
    this.KZG.setOnFocusChangeListener(this.KZN);
    c.d(this.KZG).afD(100).a(null);
    this.KZH.setOnClickListener(this.KZP);
    if (this.KZH.getDrawable() != null) {
      this.KZH.getDrawable().setColorFilter(getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(143002);
  }
  
  private void ke(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143009);
    this.KZH.setImageResource(paramInt1);
    this.KZH.setBackgroundResource(0);
    if (paramInt1 == 2131234523) {
      this.KZH.setContentDescription(getContext().getString(2131764714));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.KZH.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.KZH.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(143009);
      return;
      this.KZH.setContentDescription(getContext().getString(2131757419));
    }
  }
  
  public final void fOv()
  {
    AppMethodBeat.i(143013);
    this.KZG.clearFocus();
    AppMethodBeat.o(143013);
  }
  
  public final boolean fOw()
  {
    AppMethodBeat.i(143014);
    if (this.KZG != null)
    {
      boolean bool = this.KZG.hasFocus();
      AppMethodBeat.o(143014);
      return bool;
    }
    AppMethodBeat.o(143014);
    return false;
  }
  
  public final boolean fOx()
  {
    AppMethodBeat.i(143015);
    if (this.KZG != null)
    {
      boolean bool = this.KZG.requestFocus();
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
    if (this.KZG.getEditableText() != null)
    {
      String str = this.KZG.getEditableText().toString();
      AppMethodBeat.o(143003);
      return str;
    }
    AppMethodBeat.o(143003);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(143021);
    if (this.KZG != null)
    {
      int i = this.KZG.getSelectionEnd();
      AppMethodBeat.o(143021);
      return i;
    }
    AppMethodBeat.o(143021);
    return -1;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(143020);
    if (this.KZG != null)
    {
      int i = this.KZG.getSelectionStart();
      AppMethodBeat.o(143020);
      return i;
    }
    AppMethodBeat.o(143020);
    return -1;
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.KZK != null) {
      this.KZK.Liq = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.KZM = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.KZL = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(143016);
    if (this.KZG != null)
    {
      this.KZG.setFocusable(false);
      this.KZG.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(143016);
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143007);
    this.KZG.setEnabled(paramBoolean);
    AppMethodBeat.o(143007);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.KZO = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143005);
    this.KZG.setHint(paramCharSequence);
    AppMethodBeat.o(143005);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143017);
    if (this.KZK != null)
    {
      x localx = this.KZK;
      localx.Lip = paramArrayList;
      if (localx.Liq)
      {
        paramArrayList = (EditText)localx.Lio.get();
        if (paramArrayList != null) {
          x.a(paramArrayList, localx.Lip);
        }
      }
    }
    AppMethodBeat.o(143017);
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(143011);
    this.KZG.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(143011);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143004);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.KZG.setText(str);
    this.KZG.setSelection(str.length());
    AppMethodBeat.o(143004);
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    AppMethodBeat.i(143018);
    if (this.KZG != null) {
      this.KZG.setCompoundDrawables(ak.getResources().getDrawable(paramInt), null, null, null);
    }
    AppMethodBeat.o(143018);
  }
  
  public void setSelectedTag(String paramString)
  {
    AppMethodBeat.i(143019);
    if (this.KZG != null)
    {
      this.KZG.setCompoundDrawables(new d(this.KZG, paramString), null, null, null);
      this.KZG.setHint("");
    }
    AppMethodBeat.o(143019);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143008);
    this.KZH.setEnabled(paramBoolean);
    AppMethodBeat.o(143008);
  }
  
  public final void yM(boolean paramBoolean)
  {
    AppMethodBeat.i(143006);
    this.KZJ = paramBoolean;
    fOu();
    AppMethodBeat.o(143006);
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(143012);
    if (!paramBoolean)
    {
      this.KZG.removeTextChangedListener(this.FvF);
      this.KZG.setText("");
      this.KZG.addTextChangedListener(this.FvF);
      AppMethodBeat.o(143012);
      return;
    }
    this.KZG.setText("");
    AppMethodBeat.o(143012);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView KZS;
    
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
      ae.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          ae.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          AppMethodBeat.o(142993);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          ae.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            ae.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
            this.KZS.clearFocus();
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
      this.KZS = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void fOy();
  }
  
  public static abstract interface b
  {
    public abstract void aNW(String paramString);
    
    public abstract void aSN();
    
    public abstract void fOA();
    
    public abstract void fOz();
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(142996);
      KZT = new c("CLEAR", 0);
      KZU = new c("VOICE_SEARCH", 1);
      KZV = new c[] { KZT, KZU };
      AppMethodBeat.o(142996);
    }
    
    private c() {}
  }
  
  final class d
    extends Drawable
  {
    private RectF Exz;
    private int KZW;
    private float KZX;
    private float KZY;
    private String mText;
    private Paint vGu;
    
    d(EditText paramEditText, String paramString)
    {
      AppMethodBeat.i(142997);
      this.KZW = BackwardSupportUtil.b.h(ak.getContext(), 2.0F);
      this.vGu = new Paint(paramEditText.getPaint());
      this.mText = paramString;
      this.vGu.setColor(ak.getResources().getColor(2131100035));
      this.KZX = this.vGu.measureText(this.mText);
      this$1 = this.vGu.getFontMetrics();
      this.KZY = ((float)Math.ceil(ActionBarSearchView.this.bottom - ActionBarSearchView.this.top));
      float f = this.KZY;
      setBounds(0, 0, (int)(this.KZX + this.KZW * 2 + this.KZW * 2 + 2.0F), (int)f);
      AppMethodBeat.o(142997);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(142998);
      Paint.FontMetricsInt localFontMetricsInt = this.vGu.getFontMetricsInt();
      Rect localRect = getBounds();
      int i = localRect.right;
      i = localRect.left;
      float f = this.Exz.right;
      f = this.Exz.left;
      i = localRect.top;
      int j = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int k = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, localRect.left + 2, i + j - k, this.vGu);
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
      Paint.FontMetrics localFontMetrics = this.vGu.getFontMetrics();
      float f1 = this.KZW + paramInt1;
      float f2 = paramInt2;
      this.Exz = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.KZW, paramInt4);
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