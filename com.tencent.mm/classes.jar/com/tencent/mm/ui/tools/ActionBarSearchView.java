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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements d
{
  private TextWatcher KmA;
  private boolean OxS;
  private View QoG;
  protected ActionBarEditText QoH;
  private ImageButton QoI;
  private c QoJ;
  private boolean QoK;
  private y QoL;
  private b QoM;
  private a QoN;
  private View.OnFocusChangeListener QoO;
  private View.OnFocusChangeListener QoP;
  private View.OnClickListener QoQ;
  private View.OnClickListener QoR;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143001);
    this.QoJ = c.QoU;
    this.QoK = false;
    this.OxS = false;
    this.KmA = new TextWatcher()
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
        if (localy.Qxp)
        {
          localEditText = (EditText)localy.Qxn.get();
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
          ((ActionBarSearchView.b)localObject).bey(paramAnonymousCharSequence);
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
            localy.Qxm = y.o(localy.mText, localy.Qxo);
            if (!y.a(localEditText, localy.Qxo)) {
              break;
            }
            Log.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.QoO = new View.OnFocusChangeListener()
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
    this.QoQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ActionBarSearchView.c.QoU == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.CH(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).bnA();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).gXt();
          }
        }
      }
    };
    this.QoR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).gXr();
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
    this.QoJ = c.QoU;
    this.QoK = false;
    this.OxS = false;
    this.KmA = new TextWatcher()
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
        if (localy.Qxp)
        {
          localEditText = (EditText)localy.Qxn.get();
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
          ((ActionBarSearchView.b)localObject).bey(paramAnonymousCharSequence);
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
            localy.Qxm = y.o(localy.mText, localy.Qxo);
            if (!y.a(localEditText, localy.Qxo)) {
              break;
            }
            Log.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.QoO = new View.OnFocusChangeListener()
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
    this.QoQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ActionBarSearchView.c.QoU == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.CH(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).bnA();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).gXt();
          }
        }
      }
    };
    this.QoR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).gXr();
        }
        a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143000);
  }
  
  private void gXn()
  {
    AppMethodBeat.i(143010);
    if ((this.QoH.getEditableText() != null) && (!Util.isNullOrNil(this.QoH.getEditableText().toString())))
    {
      lq(2131234750, getResources().getDimensionPixelSize(2131165532));
      this.QoJ = c.QoU;
      AppMethodBeat.o(143010);
      return;
    }
    if (this.QoK)
    {
      lq(2131235485, getResources().getDimensionPixelSize(2131165532));
      this.QoJ = c.QoV;
      AppMethodBeat.o(143010);
      return;
    }
    lq(0, 0);
    this.QoJ = c.QoU;
    AppMethodBeat.o(143010);
  }
  
  private void init()
  {
    AppMethodBeat.i(143002);
    this.OxS = ao.isDarkMode();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
    this.QoG = findViewById(2131297963);
    this.QoG.setOnClickListener(this.QoR);
    this.QoH = ((ActionBarEditText)findViewById(2131299910));
    this.QoL = new y(this.QoH);
    this.QoH.setSearchView(this);
    this.QoH.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142990);
        ActionBarSearchView.this.QoH.setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).gXs();
        }
        AppMethodBeat.o(142990);
      }
    });
    this.QoI = ((ImageButton)findViewById(2131308392));
    this.QoH.addTextChangedListener(this.KmA);
    this.QoH.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142991);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        ((b)localObject).pH(paramAnonymousInt);
        ((b)localObject).bm(paramAnonymousKeyEvent);
        a.b("com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((b)localObject).axR());
        if (paramAnonymousInt == 67)
        {
          Log.d("MicroMsg.ActionBarSearchView", "on back key click.");
          localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          boolean bool;
          if (((y)localObject).Qxp)
          {
            paramAnonymousView = (EditText)((y)localObject).Qxn.get();
            if ((paramAnonymousView != null) && (((y)localObject).Qxm != null)) {}
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
              localObject = ((y)localObject).aoo(paramAnonymousInt);
              if ((localObject != null) && (((y.b)localObject).Qxs))
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
    this.QoH.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(142992);
        Log.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((y)localObject).Qxp)
        {
          localEditText = (EditText)((y)localObject).Qxn.get();
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
          localObject = ((y)localObject).aoo(paramAnonymousInt2);
          if ((localObject != null) && (((y.b)localObject).Qxs))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((y.b)localObject).start;
            localEditText.setSelection(((y.b)localObject).length + paramAnonymousInt1);
          }
          AppMethodBeat.o(142992);
          return;
        }
        y.b localb = ((y)localObject).aoo(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.Qxs) {
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
        localObject = ((y)localObject).aoo(i);
        if ((localObject != null) && (((y.b)localObject).Qxs))
        {
          paramAnonymousInt2 = ((y.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(142992);
      }
    });
    this.QoH.setOnFocusChangeListener(this.QoO);
    c.f(this.QoH).aoq(100).a(null);
    this.QoI.setOnClickListener(this.QoQ);
    if (this.QoI.getDrawable() != null) {
      this.QoI.getDrawable().setColorFilter(getResources().getColor(2131099746), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(143002);
  }
  
  private void lq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143009);
    this.QoI.setImageResource(paramInt1);
    this.QoI.setBackgroundResource(0);
    if (paramInt1 == 2131235485) {
      this.QoI.setContentDescription(getContext().getString(2131767151));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.QoI.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.QoI.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(143009);
      return;
      this.QoI.setContentDescription(getContext().getString(2131757636));
    }
  }
  
  public final void CG(boolean paramBoolean)
  {
    AppMethodBeat.i(143006);
    this.QoK = paramBoolean;
    gXn();
    AppMethodBeat.o(143006);
  }
  
  public final void CH(boolean paramBoolean)
  {
    AppMethodBeat.i(143012);
    if (!paramBoolean)
    {
      this.QoH.removeTextChangedListener(this.KmA);
      this.QoH.setText("");
      this.QoH.addTextChangedListener(this.KmA);
      AppMethodBeat.o(143012);
      return;
    }
    this.QoH.setText("");
    AppMethodBeat.o(143012);
  }
  
  public final void gXo()
  {
    AppMethodBeat.i(143013);
    this.QoH.clearFocus();
    AppMethodBeat.o(143013);
  }
  
  public final boolean gXp()
  {
    AppMethodBeat.i(143014);
    if (this.QoH != null)
    {
      boolean bool = this.QoH.hasFocus();
      AppMethodBeat.o(143014);
      return bool;
    }
    AppMethodBeat.o(143014);
    return false;
  }
  
  public final boolean gXq()
  {
    AppMethodBeat.i(143015);
    if (this.QoH != null)
    {
      boolean bool = this.QoH.requestFocus();
      AppMethodBeat.o(143015);
      return bool;
    }
    AppMethodBeat.o(143015);
    return false;
  }
  
  protected int getLayoutId()
  {
    return 2131492943;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(143003);
    if (this.QoH.getEditableText() != null)
    {
      String str = this.QoH.getEditableText().toString();
      AppMethodBeat.o(143003);
      return str;
    }
    AppMethodBeat.o(143003);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(143021);
    if (this.QoH != null)
    {
      int i = this.QoH.getSelectionEnd();
      AppMethodBeat.o(143021);
      return i;
    }
    AppMethodBeat.o(143021);
    return -1;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(143020);
    if (this.QoH != null)
    {
      int i = this.QoH.getSelectionStart();
      AppMethodBeat.o(143020);
      return i;
    }
    AppMethodBeat.o(143020);
    return -1;
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.QoL != null) {
      this.QoL.Qxp = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.QoN = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.QoM = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(143016);
    if (this.QoH != null)
    {
      this.QoH.setFocusable(false);
      this.QoH.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(143016);
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143007);
    this.QoH.setEnabled(paramBoolean);
    AppMethodBeat.o(143007);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.QoP = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143005);
    this.QoH.setHint(paramCharSequence);
    AppMethodBeat.o(143005);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143017);
    if (this.QoL != null)
    {
      y localy = this.QoL;
      localy.Qxo = paramArrayList;
      if (localy.Qxp)
      {
        paramArrayList = (EditText)localy.Qxn.get();
        if (paramArrayList != null) {
          y.a(paramArrayList, localy.Qxo);
        }
      }
    }
    AppMethodBeat.o(143017);
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(143011);
    this.QoH.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(143011);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143004);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.QoH.setText(str);
    this.QoH.setSelection(str.length());
    AppMethodBeat.o(143004);
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    AppMethodBeat.i(143018);
    if (this.QoH != null) {
      this.QoH.setCompoundDrawables(MMApplicationContext.getResources().getDrawable(paramInt), null, null, null);
    }
    AppMethodBeat.o(143018);
  }
  
  public void setSelectedTag(String paramString)
  {
    AppMethodBeat.i(143019);
    if (this.QoH != null)
    {
      this.QoH.setCompoundDrawables(new d(this.QoH, paramString), null, null, null);
      this.QoH.setHint("");
    }
    AppMethodBeat.o(143019);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143008);
    this.QoI.setEnabled(paramBoolean);
    AppMethodBeat.o(143008);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView QoT;
    
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
            this.QoT.clearFocus();
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
      this.QoT = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void gXr();
  }
  
  public static abstract interface b
  {
    public abstract void bey(String paramString);
    
    public abstract void bnA();
    
    public abstract void gXs();
    
    public abstract void gXt();
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(142996);
      QoU = new c("CLEAR", 0);
      QoV = new c("VOICE_SEARCH", 1);
      QoW = new c[] { QoU, QoV };
      AppMethodBeat.o(142996);
    }
    
    private c() {}
  }
  
  final class d
    extends Drawable
  {
    private RectF JkS;
    private int QoX;
    private float QoY;
    private float QoZ;
    private String mText;
    private Paint zbt;
    
    d(EditText paramEditText, String paramString)
    {
      AppMethodBeat.i(142997);
      this.QoX = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 2.0F);
      this.zbt = new Paint(paramEditText.getPaint());
      this.mText = paramString;
      this.zbt.setColor(MMApplicationContext.getResources().getColor(2131100063));
      this.QoY = this.zbt.measureText(this.mText);
      this$1 = this.zbt.getFontMetrics();
      this.QoZ = ((float)Math.ceil(ActionBarSearchView.this.bottom - ActionBarSearchView.this.top));
      float f = this.QoZ;
      setBounds(0, 0, (int)(this.QoY + this.QoX * 2 + this.QoX * 2 + 2.0F), (int)f);
      AppMethodBeat.o(142997);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(142998);
      Paint.FontMetricsInt localFontMetricsInt = this.zbt.getFontMetricsInt();
      Rect localRect = getBounds();
      int i = localRect.right;
      i = localRect.left;
      float f = this.JkS.right;
      f = this.JkS.left;
      i = localRect.top;
      int j = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int k = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, localRect.left + 2, i + j - k, this.zbt);
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
      Paint.FontMetrics localFontMetrics = this.zbt.getFontMetrics();
      float f1 = this.QoX + paramInt1;
      float f2 = paramInt2;
      this.JkS = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.QoX, paramInt4);
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