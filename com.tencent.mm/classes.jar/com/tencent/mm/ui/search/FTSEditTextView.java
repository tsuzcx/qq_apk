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
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSEditTextView
  extends LinearLayout
{
  private TextView NbB;
  private TextView NbC;
  private TextView NcJ;
  private boolean XLP;
  private View.OnClickListener XLQ;
  private b XLR;
  private final ArrayList<a> XLS;
  private FTSEditTextView.c XLT;
  public EditText bGw;
  private String hint;
  private WeImageView jQn;
  private ImageButton jQo;
  private View jQp;
  private String jQq;
  protected View.OnFocusChangeListener jQt;
  private List<a.c> unc;
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164183);
    this.XLP = true;
    this.jQq = "";
    this.XLQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164178);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = -1;
        if (paramAnonymousView.getId() == a.g.tag_1) {
          i = 0;
        }
        for (;;)
        {
          if ((FTSEditTextView.h(FTSEditTextView.this) != null) && (i >= 0))
          {
            paramAnonymousView = FTSEditTextView.h(FTSEditTextView.this);
            FTSEditTextView.b(FTSEditTextView.this).get(i);
            paramAnonymousView.dvg();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164178);
          return;
          if (paramAnonymousView.getId() == a.g.tag_2) {
            i = 1;
          } else if (paramAnonymousView.getId() == a.g.tag_3) {
            i = 2;
          }
        }
      }
    };
    this.XLS = new ArrayList();
    this.XLT = FTSEditTextView.c.XLV;
    this.jQt = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).eF(paramAnonymousBoolean);
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
    this.XLP = true;
    this.jQq = "";
    this.XLQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164178);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        int i = -1;
        if (paramAnonymousView.getId() == a.g.tag_1) {
          i = 0;
        }
        for (;;)
        {
          if ((FTSEditTextView.h(FTSEditTextView.this) != null) && (i >= 0))
          {
            paramAnonymousView = FTSEditTextView.h(FTSEditTextView.this);
            FTSEditTextView.b(FTSEditTextView.this).get(i);
            paramAnonymousView.dvg();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164178);
          return;
          if (paramAnonymousView.getId() == a.g.tag_2) {
            i = 1;
          } else if (paramAnonymousView.getId() == a.g.tag_3) {
            i = 2;
          }
        }
      }
    };
    this.XLS = new ArrayList();
    this.XLT = FTSEditTextView.c.XLV;
    this.jQt = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).eF(paramAnonymousBoolean);
        }
        AppMethodBeat.o(164179);
      }
    };
    init();
    AppMethodBeat.o(164184);
  }
  
  private void a(String paramString, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(164191);
    String str = Util.nullAs(paramString, "").trim();
    paramString = str;
    if (str.length() > getLimitInputLength()) {
      paramString = str.substring(0, getLimitInputLength()).replace("\n", " ");
    }
    this.unc.clear();
    if (paramList != null) {
      this.unc.addAll(paramList);
    }
    Log.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[] { paramString, Integer.valueOf(this.unc.size()) });
    this.XLT = FTSEditTextView.c.XLX;
    this.bGw.setText(paramString);
    Selection.setSelection(this.bGw.getText(), this.bGw.getText().length());
    hXO();
    this.XLT = paramc;
    AppMethodBeat.o(164191);
  }
  
  private void hXO()
  {
    AppMethodBeat.i(164195);
    Log.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[] { Integer.valueOf(this.unc.size()) });
    float f = com.tencent.mm.ci.a.aY(getContext(), a.e.NormalTextSize);
    if (this.unc.size() > 0)
    {
      this.NbB.setVisibility(0);
      this.NbB.setText(com.tencent.mm.ui.h.c.b.c(getContext(), ((a.c)this.unc.get(0)).getTagName(), f));
      if (this.unc.size() < 2) {
        break label222;
      }
      this.NbC.setVisibility(0);
      this.NbC.setText(com.tencent.mm.ui.h.c.b.c(getContext(), ((a.c)this.unc.get(1)).getTagName(), f));
    }
    for (;;)
    {
      if (this.unc.size() < 3) {
        break label234;
      }
      this.NcJ.setVisibility(0);
      this.NcJ.setText(com.tencent.mm.ui.h.c.b.c(getContext(), ((a.c)this.unc.get(2)).getTagName(), f));
      AppMethodBeat.o(164195);
      return;
      this.NbB.setVisibility(8);
      break;
      label222:
      this.NbC.setVisibility(8);
    }
    label234:
    this.NcJ.setVisibility(8);
    AppMethodBeat.o(164195);
  }
  
  public final void O(String paramString, List<a.c> paramList)
  {
    AppMethodBeat.i(164190);
    a(paramString, paramList, FTSEditTextView.c.XLV);
    AppMethodBeat.o(164190);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(223281);
    if (!this.XLS.contains(parama)) {
      this.XLS.add(parama);
    }
    AppMethodBeat.o(223281);
  }
  
  public final void aDT()
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
  
  public final void aDU()
  {
    AppMethodBeat.i(164192);
    this.bGw.requestFocus();
    AppMethodBeat.o(164192);
  }
  
  public ImageButton getClearBtn()
  {
    return this.jQo;
  }
  
  public EditText getEditText()
  {
    return this.bGw;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(164189);
    int i = this.bGw.getHighlightColor();
    AppMethodBeat.o(164189);
    return i;
  }
  
  public WeImageView getIconView()
  {
    return this.jQn;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(164196);
    String str = this.bGw.getText().toString().trim();
    AppMethodBeat.o(164196);
    return str;
  }
  
  protected int getLayoutById()
  {
    return a.h.fts_edittext_view;
  }
  
  protected int getLimitInputLength()
  {
    return 100;
  }
  
  public List<a.c> getTagList()
  {
    return this.unc;
  }
  
  public View getTagPanel()
  {
    return this.jQp;
  }
  
  public FTSEditTextView.c getTextChangeStatus()
  {
    return this.XLT;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(164197);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.unc.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((a.c)localIterator.next()).getTagName());
      ((StringBuffer)localObject).append(" ");
    }
    ((StringBuffer)localObject).append(this.bGw.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(164197);
    return localObject;
  }
  
  public final void hUu()
  {
    AppMethodBeat.i(293221);
    this.bGw.clearFocus();
    AppMethodBeat.o(293221);
  }
  
  public final void hXB()
  {
    AppMethodBeat.i(164198);
    this.jQn.setVisibility(8);
    AppMethodBeat.o(164198);
  }
  
  protected boolean hXM()
  {
    return false;
  }
  
  public final void hXN()
  {
    AppMethodBeat.i(223271);
    this.bGw.setTextSize(1, 17.0F);
    AppMethodBeat.o(223271);
  }
  
  public final void hXP()
  {
    AppMethodBeat.i(164199);
    this.jQn.setVisibility(0);
    AppMethodBeat.o(164199);
  }
  
  public final void hXQ()
  {
    AppMethodBeat.i(164200);
    this.jQo.setVisibility(8);
    AppMethodBeat.o(164200);
  }
  
  public final void hXR()
  {
    AppMethodBeat.i(164201);
    this.jQo.setVisibility(0);
    AppMethodBeat.o(164201);
  }
  
  public final void hcg()
  {
    AppMethodBeat.i(164186);
    this.XLT = FTSEditTextView.c.XLW;
    if (this.XLP) {
      this.unc.clear();
    }
    this.bGw.setText("");
    this.bGw.setHint(this.hint);
    this.jQo.setVisibility(8);
    hXO();
    this.XLT = FTSEditTextView.c.XLV;
    AppMethodBeat.o(164186);
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(223256);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.bGw.getWindowToken(), 0);
    AppMethodBeat.o(223256);
  }
  
  protected void init()
  {
    AppMethodBeat.i(164185);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    this.jQp = findViewById(a.g.tag_panel);
    this.jQn = ((WeImageView)findViewById(a.g.icon));
    this.bGw = ((EditText)findViewById(a.g.edittext));
    this.jQo = ((ImageButton)findViewById(a.g.clear_btn));
    this.NbB = ((TextView)findViewById(a.g.tag_1));
    this.NbC = ((TextView)findViewById(a.g.tag_2));
    this.NcJ = ((TextView)findViewById(a.g.tag_3));
    this.unc = new ArrayList();
    this.bGw.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164173);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.bn(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
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
    this.bGw.addTextChangedListener(new TextWatcher()
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
    this.bGw.setOnFocusChangeListener(this.jQt);
    this.bGw.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164175);
        if ((3 == paramAnonymousInt) && (FTSEditTextView.h(FTSEditTextView.this) != null))
        {
          boolean bool = FTSEditTextView.h(FTSEditTextView.this).aDV();
          AppMethodBeat.o(164175);
          return bool;
        }
        AppMethodBeat.o(164175);
        return false;
      }
    });
    this.NbB.setOnClickListener(this.XLQ);
    this.NbC.setOnClickListener(this.XLQ);
    this.NcJ.setOnClickListener(this.XLQ);
    this.jQo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164176);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FTSEditTextView.this.hcg();
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).onClickClearTextBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164176);
      }
    });
    c.i(this.bGw).axx(getLimitInputLength()).b(g.a.XSt).a(null);
    if ((ar.isDarkMode()) || (hXM())) {
      this.jQo.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(164185);
  }
  
  public void setCanDeleteTag(boolean paramBoolean)
  {
    this.XLP = paramBoolean;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(164187);
    if (paramInt == -1)
    {
      this.bGw.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(164187);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 15), com.tencent.mm.ci.a.fromDPToPix(getContext(), 15));
    this.bGw.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(164187);
  }
  
  public void setFtsEditTextListener(b paramb)
  {
    this.XLR = paramb;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(164194);
    this.bGw.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(164194);
  }
  
  public void setHintColor(int paramInt)
  {
    AppMethodBeat.i(223266);
    this.bGw.setHintTextColor(paramInt);
    AppMethodBeat.o(223266);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(223267);
    this.bGw.setTextColor(paramInt);
    AppMethodBeat.o(223267);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(223253);
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.bGw, 0);
    AppMethodBeat.o(223253);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc);
  }
  
  public static abstract interface b
    extends FTSEditTextView.a
  {
    public abstract boolean aDV();
    
    public abstract void dvg();
    
    public abstract void eF(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.search.FTSEditTextView
 * JD-Core Version:    0.7.0.1
 */