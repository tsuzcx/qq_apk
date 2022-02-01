package com.tencent.mm.ui.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSEditTextView
  extends LinearLayout
{
  private TextView GoP;
  private TextView GoQ;
  private TextView GpX;
  private boolean QnL;
  private View.OnClickListener QnM;
  private a QnN;
  private FTSEditTextView.b QnO;
  private String heA;
  protected View.OnFocusChangeListener heD;
  private WeImageView hex;
  private ImageButton hey;
  private View hez;
  private String hint;
  private List<a.c> qLQ;
  public EditText vy;
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164183);
    this.QnL = true;
    this.heA = "";
    this.QnM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164178);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = -1;
        if (paramAnonymousView.getId() == 2131308851) {
          i = 0;
        }
        for (;;)
        {
          if ((FTSEditTextView.h(FTSEditTextView.this) != null) && (i >= 0))
          {
            paramAnonymousView = FTSEditTextView.h(FTSEditTextView.this);
            FTSEditTextView.b(FTSEditTextView.this).get(i);
            paramAnonymousView.dpw();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164178);
          return;
          if (paramAnonymousView.getId() == 2131308855) {
            i = 1;
          } else if (paramAnonymousView.getId() == 2131308859) {
            i = 2;
          }
        }
      }
    };
    this.QnO = FTSEditTextView.b.QnQ;
    this.heD = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).eh(paramAnonymousBoolean);
        }
        AppMethodBeat.o(164179);
      }
    };
    init();
    AppMethodBeat.o(164183);
  }
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164184);
    this.QnL = true;
    this.heA = "";
    this.QnM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164178);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = -1;
        if (paramAnonymousView.getId() == 2131308851) {
          i = 0;
        }
        for (;;)
        {
          if ((FTSEditTextView.h(FTSEditTextView.this) != null) && (i >= 0))
          {
            paramAnonymousView = FTSEditTextView.h(FTSEditTextView.this);
            FTSEditTextView.b(FTSEditTextView.this).get(i);
            paramAnonymousView.dpw();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164178);
          return;
          if (paramAnonymousView.getId() == 2131308855) {
            i = 1;
          } else if (paramAnonymousView.getId() == 2131308859) {
            i = 2;
          }
        }
      }
    };
    this.QnO = FTSEditTextView.b.QnQ;
    this.heD = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).eh(paramAnonymousBoolean);
        }
        AppMethodBeat.o(164179);
      }
    };
    init();
    AppMethodBeat.o(164184);
  }
  
  private void a(String paramString, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(164191);
    String str = Util.nullAs(paramString, "").trim();
    paramString = str;
    if (str.length() > getLimitInputLength()) {
      paramString = str.substring(0, getLimitInputLength()).replace("\n", " ");
    }
    this.qLQ.clear();
    if (paramList != null) {
      this.qLQ.addAll(paramList);
    }
    Log.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[] { paramString, Integer.valueOf(this.qLQ.size()) });
    this.QnO = FTSEditTextView.b.QnS;
    this.vy.setText(paramString);
    Selection.setSelection(this.vy.getText(), this.vy.getText().length());
    gXd();
    this.QnO = paramb;
    AppMethodBeat.o(164191);
  }
  
  private void gXd()
  {
    AppMethodBeat.i(164195);
    Log.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[] { Integer.valueOf(this.qLQ.size()) });
    float f = com.tencent.mm.cb.a.aG(getContext(), 2131165535);
    if (this.qLQ.size() > 0)
    {
      this.GoP.setVisibility(0);
      this.GoP.setText(com.tencent.mm.ui.g.c.b.c(getContext(), ((a.c)this.qLQ.get(0)).getTagName(), f));
      if (this.qLQ.size() < 2) {
        break label221;
      }
      this.GoQ.setVisibility(0);
      this.GoQ.setText(com.tencent.mm.ui.g.c.b.c(getContext(), ((a.c)this.qLQ.get(1)).getTagName(), f));
    }
    for (;;)
    {
      if (this.qLQ.size() < 3) {
        break label233;
      }
      this.GpX.setVisibility(0);
      this.GpX.setText(com.tencent.mm.ui.g.c.b.c(getContext(), ((a.c)this.qLQ.get(2)).getTagName(), f));
      AppMethodBeat.o(164195);
      return;
      this.GoP.setVisibility(8);
      break;
      label221:
      this.GoQ.setVisibility(8);
    }
    label233:
    this.GpX.setVisibility(8);
    AppMethodBeat.o(164195);
  }
  
  public final void O(String paramString, List<a.c> paramList)
  {
    AppMethodBeat.i(164190);
    a(paramString, paramList, FTSEditTextView.b.QnQ);
    AppMethodBeat.o(164190);
  }
  
  public final void awC()
  {
    AppMethodBeat.i(164188);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(164177);
        ((InputMethodManager)FTSEditTextView.this.getContext().getSystemService("input_method")).showSoftInput(FTSEditTextView.a(FTSEditTextView.this), 0);
        AppMethodBeat.o(164177);
      }
    }, 128L);
    AppMethodBeat.o(164188);
  }
  
  public final void awD()
  {
    AppMethodBeat.i(164192);
    this.vy.requestFocus();
    AppMethodBeat.o(164192);
  }
  
  public final void clearText()
  {
    AppMethodBeat.i(164186);
    this.QnO = FTSEditTextView.b.QnR;
    if (this.QnL) {
      this.qLQ.clear();
    }
    this.vy.setText("");
    this.vy.setHint(this.hint);
    this.hey.setVisibility(8);
    gXd();
    this.QnO = FTSEditTextView.b.QnQ;
    AppMethodBeat.o(164186);
  }
  
  public final void gUA()
  {
    AppMethodBeat.i(258466);
    this.vy.clearFocus();
    AppMethodBeat.o(258466);
  }
  
  public final void gWY()
  {
    AppMethodBeat.i(164198);
    this.hex.setVisibility(8);
    AppMethodBeat.o(164198);
  }
  
  public final void gXe()
  {
    AppMethodBeat.i(164199);
    this.hex.setVisibility(0);
    AppMethodBeat.o(164199);
  }
  
  public final void gXf()
  {
    AppMethodBeat.i(164200);
    this.hey.setVisibility(8);
    AppMethodBeat.o(164200);
  }
  
  public final void gXg()
  {
    AppMethodBeat.i(164201);
    this.hey.setVisibility(0);
    AppMethodBeat.o(164201);
  }
  
  public ImageButton getClearBtn()
  {
    return this.hey;
  }
  
  public EditText getEditText()
  {
    return this.vy;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(164189);
    int i = this.vy.getHighlightColor();
    AppMethodBeat.o(164189);
    return i;
  }
  
  public WeImageView getIconView()
  {
    return this.hex;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(164196);
    String str = this.vy.getText().toString().trim();
    AppMethodBeat.o(164196);
    return str;
  }
  
  protected int getLayoutById()
  {
    return 2131494751;
  }
  
  protected int getLimitInputLength()
  {
    return 100;
  }
  
  public List<a.c> getTagList()
  {
    return this.qLQ;
  }
  
  public View getTagPanel()
  {
    return this.hez;
  }
  
  public FTSEditTextView.b getTextChangeStatus()
  {
    return this.QnO;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(164197);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.qLQ.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((a.c)localIterator.next()).getTagName());
      ((StringBuffer)localObject).append(" ");
    }
    ((StringBuffer)localObject).append(this.vy.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(164197);
    return localObject;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(205352);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.vy.getWindowToken(), 0);
    AppMethodBeat.o(205352);
  }
  
  protected void init()
  {
    AppMethodBeat.i(164185);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    this.hez = findViewById(2131308873);
    this.hex = ((WeImageView)findViewById(2131302468));
    this.vy = ((EditText)findViewById(2131299910));
    this.hey = ((ImageButton)findViewById(2131298744));
    this.GoP = ((TextView)findViewById(2131308851));
    this.GoQ = ((TextView)findViewById(2131308855));
    this.GpX = ((TextView)findViewById(2131308859));
    this.qLQ = new ArrayList();
    this.vy.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164173);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (67 == paramAnonymousInt))
        {
          paramAnonymousInt = FTSEditTextView.a(FTSEditTextView.this).getSelectionStart();
          int i = FTSEditTextView.a(FTSEditTextView.this).getSelectionEnd();
          if ((paramAnonymousInt == 0) && (i == 0) && (FTSEditTextView.b(FTSEditTextView.this).size() > 0) && (FTSEditTextView.c(FTSEditTextView.this)))
          {
            FTSEditTextView.b(FTSEditTextView.this).remove(FTSEditTextView.b(FTSEditTextView.this).size() - 1);
            FTSEditTextView.d(FTSEditTextView.this);
            FTSEditTextView.e(FTSEditTextView.this);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/search/FTSEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(164173);
        return false;
      }
    });
    this.vy.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(164174);
        paramAnonymousCharSequence = FTSEditTextView.this.getTotalQuery();
        if ((paramAnonymousCharSequence != FTSEditTextView.f(FTSEditTextView.this)) && (!paramAnonymousCharSequence.equals(FTSEditTextView.f(FTSEditTextView.this))))
        {
          FTSEditTextView.a(FTSEditTextView.this, paramAnonymousCharSequence);
          if (paramAnonymousCharSequence.length() <= 0) {
            break label78;
          }
          FTSEditTextView.g(FTSEditTextView.this).setVisibility(0);
        }
        for (;;)
        {
          FTSEditTextView.e(FTSEditTextView.this);
          AppMethodBeat.o(164174);
          return;
          label78:
          FTSEditTextView.g(FTSEditTextView.this).setVisibility(8);
        }
      }
    });
    this.vy.setOnFocusChangeListener(this.heD);
    this.vy.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164175);
        if ((3 == paramAnonymousInt) && (FTSEditTextView.h(FTSEditTextView.this) != null))
        {
          boolean bool = FTSEditTextView.h(FTSEditTextView.this).awE();
          AppMethodBeat.o(164175);
          return bool;
        }
        AppMethodBeat.o(164175);
        return false;
      }
    });
    this.GoP.setOnClickListener(this.QnM);
    this.GoQ.setOnClickListener(this.QnM);
    this.GpX.setOnClickListener(this.QnM);
    this.hey.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164176);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        FTSEditTextView.this.clearText();
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).onClickClearTextBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164176);
      }
    });
    c.f(this.vy).aoq(getLimitInputLength()).a(f.a.Quh).a(null);
    if (ao.isDarkMode()) {
      this.hey.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(164185);
  }
  
  public void setCanDeleteTag(boolean paramBoolean)
  {
    this.QnL = paramBoolean;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(164187);
    if (paramInt == -1)
    {
      this.vy.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(164187);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 15), com.tencent.mm.cb.a.fromDPToPix(getContext(), 15));
    this.vy.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(164187);
  }
  
  public void setFtsEditTextListener(a parama)
  {
    this.QnN = parama;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(164194);
    this.vy.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(164194);
  }
  
  public void setHintColor(int paramInt)
  {
    AppMethodBeat.i(205353);
    this.vy.setHintTextColor(paramInt);
    AppMethodBeat.o(205353);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(205354);
    this.vy.setTextColor(paramInt);
    AppMethodBeat.o(205354);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(205351);
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.vy, 0);
    AppMethodBeat.o(205351);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb);
    
    public abstract boolean awE();
    
    public abstract void dpw();
    
    public abstract void eh(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.search.FTSEditTextView
 * JD-Core Version:    0.7.0.1
 */