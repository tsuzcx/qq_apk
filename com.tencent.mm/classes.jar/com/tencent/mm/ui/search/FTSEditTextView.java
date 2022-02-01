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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSEditTextView
  extends LinearLayout
{
  private TextView BwK;
  private TextView BwL;
  private TextView BxS;
  private String JHR;
  private b KCA;
  private View KCw;
  private boolean KCx;
  private View.OnClickListener KCy;
  private a KCz;
  private String hint;
  protected View.OnFocusChangeListener mmc;
  private WeImageView nZY;
  private List<a.c> ppT;
  private ImageButton rEL;
  public EditText vr;
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164183);
    this.KCx = true;
    this.JHR = "";
    this.KCy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164178);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        int i = -1;
        if (paramAnonymousView.getId() == 2131305610) {
          i = 0;
        }
        for (;;)
        {
          if ((FTSEditTextView.h(FTSEditTextView.this) != null) && (i >= 0))
          {
            paramAnonymousView = FTSEditTextView.h(FTSEditTextView.this);
            FTSEditTextView.b(FTSEditTextView.this).get(i);
            paramAnonymousView.cED();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164178);
          return;
          if (paramAnonymousView.getId() == 2131305614) {
            i = 1;
          } else if (paramAnonymousView.getId() == 2131305618) {
            i = 2;
          }
        }
      }
    };
    this.KCA = b.KCC;
    this.mmc = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).ma(paramAnonymousBoolean);
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
    this.KCx = true;
    this.JHR = "";
    this.KCy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164178);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        int i = -1;
        if (paramAnonymousView.getId() == 2131305610) {
          i = 0;
        }
        for (;;)
        {
          if ((FTSEditTextView.h(FTSEditTextView.this) != null) && (i >= 0))
          {
            paramAnonymousView = FTSEditTextView.h(FTSEditTextView.this);
            FTSEditTextView.b(FTSEditTextView.this).get(i);
            paramAnonymousView.cED();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(164178);
          return;
          if (paramAnonymousView.getId() == 2131305614) {
            i = 1;
          } else if (paramAnonymousView.getId() == 2131305618) {
            i = 2;
          }
        }
      }
    };
    this.KCA = b.KCC;
    this.mmc = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).ma(paramAnonymousBoolean);
        }
        AppMethodBeat.o(164179);
      }
    };
    init();
    AppMethodBeat.o(164184);
  }
  
  private void a(String paramString, List<a.c> paramList, b paramb)
  {
    AppMethodBeat.i(164191);
    this.ppT.clear();
    if (paramList != null) {
      this.ppT.addAll(paramList);
    }
    ad.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[] { paramString, Integer.valueOf(this.ppT.size()) });
    this.KCA = b.KCE;
    this.vr.setText(paramString);
    Selection.setSelection(this.vr.getText(), this.vr.getText().length());
    fJT();
    this.KCA = paramb;
    AppMethodBeat.o(164191);
  }
  
  private void fJT()
  {
    AppMethodBeat.i(164195);
    ad.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[] { Integer.valueOf(this.ppT.size()) });
    float f = com.tencent.mm.cc.a.ax(getContext(), 2131165517);
    if (this.ppT.size() > 0)
    {
      this.BwK.setVisibility(0);
      this.BwK.setText(com.tencent.mm.ui.f.c.b.c(getContext(), ((a.c)this.ppT.get(0)).getTagName(), f));
      if (this.ppT.size() < 2) {
        break label221;
      }
      this.BwL.setVisibility(0);
      this.BwL.setText(com.tencent.mm.ui.f.c.b.c(getContext(), ((a.c)this.ppT.get(1)).getTagName(), f));
    }
    for (;;)
    {
      if (this.ppT.size() < 3) {
        break label233;
      }
      this.BxS.setVisibility(0);
      this.BxS.setText(com.tencent.mm.ui.f.c.b.c(getContext(), ((a.c)this.ppT.get(2)).getTagName(), f));
      AppMethodBeat.o(164195);
      return;
      this.BwK.setVisibility(8);
      break;
      label221:
      this.BwL.setVisibility(8);
    }
    label233:
    this.BxS.setVisibility(8);
    AppMethodBeat.o(164195);
  }
  
  public final void H(String paramString, List<a.c> paramList)
  {
    AppMethodBeat.i(164190);
    a(paramString, paramList, b.KCC);
    AppMethodBeat.o(164190);
  }
  
  public final void clearText()
  {
    AppMethodBeat.i(164186);
    this.KCA = b.KCD;
    if (this.KCx) {
      this.ppT.clear();
    }
    this.vr.setText("");
    this.vr.setHint(this.hint);
    this.rEL.setVisibility(8);
    fJT();
    this.KCA = b.KCC;
    AppMethodBeat.o(164186);
  }
  
  public final void fHO()
  {
    AppMethodBeat.i(221158);
    this.vr.clearFocus();
    AppMethodBeat.o(221158);
  }
  
  public final void fJP()
  {
    AppMethodBeat.i(164198);
    this.nZY.setVisibility(8);
    AppMethodBeat.o(164198);
  }
  
  public final void fJR()
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
  
  public final void fJS()
  {
    AppMethodBeat.i(164192);
    this.vr.requestFocus();
    AppMethodBeat.o(164192);
  }
  
  public final void fJU()
  {
    AppMethodBeat.i(164199);
    this.nZY.setVisibility(0);
    AppMethodBeat.o(164199);
  }
  
  public final void fJV()
  {
    AppMethodBeat.i(164200);
    this.rEL.setVisibility(8);
    AppMethodBeat.o(164200);
  }
  
  public final void fJW()
  {
    AppMethodBeat.i(164201);
    this.rEL.setVisibility(0);
    AppMethodBeat.o(164201);
  }
  
  public ImageButton getClearBtn()
  {
    return this.rEL;
  }
  
  public EditText getEditText()
  {
    return this.vr;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(164189);
    int i = this.vr.getHighlightColor();
    AppMethodBeat.o(164189);
    return i;
  }
  
  public WeImageView getIconView()
  {
    return this.nZY;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(164196);
    String str = this.vr.getText().toString().trim();
    AppMethodBeat.o(164196);
    return str;
  }
  
  protected int getLayoutById()
  {
    return 2131494198;
  }
  
  public List<a.c> getTagList()
  {
    return this.ppT;
  }
  
  public View getTagPanel()
  {
    return this.KCw;
  }
  
  public b getTextChangeStatus()
  {
    return this.KCA;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(164197);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.ppT.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((a.c)localIterator.next()).getTagName());
      ((StringBuffer)localObject).append(" ");
    }
    ((StringBuffer)localObject).append(this.vr.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(164197);
    return localObject;
  }
  
  protected void init()
  {
    AppMethodBeat.i(164185);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    this.KCw = findViewById(2131305631);
    this.nZY = ((WeImageView)findViewById(2131300874));
    this.vr = ((EditText)findViewById(2131299306));
    this.rEL = ((ImageButton)findViewById(2131298348));
    this.BwK = ((TextView)findViewById(2131305610));
    this.BwL = ((TextView)findViewById(2131305614));
    this.BxS = ((TextView)findViewById(2131305618));
    this.ppT = new ArrayList();
    this.vr.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164173);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
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
    this.vr.addTextChangedListener(new TextWatcher()
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
    this.vr.setOnFocusChangeListener(this.mmc);
    this.vr.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164175);
        if ((3 == paramAnonymousInt) && (FTSEditTextView.h(FTSEditTextView.this) != null))
        {
          boolean bool = FTSEditTextView.h(FTSEditTextView.this).bzz();
          AppMethodBeat.o(164175);
          return bool;
        }
        AppMethodBeat.o(164175);
        return false;
      }
    });
    this.BwK.setOnClickListener(this.KCy);
    this.BwL.setOnClickListener(this.KCy);
    this.BxS.setOnClickListener(this.KCy);
    this.rEL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164176);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FTSEditTextView.this.clearText();
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).onClickClearTextBtn(paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/search/FTSEditTextView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(164176);
      }
    });
    c.d(this.vr).aeU(100).a(null);
    if (al.isDarkMode()) {
      this.rEL.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(164185);
  }
  
  public void setCanDeleteTag(boolean paramBoolean)
  {
    this.KCx = paramBoolean;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(164187);
    if (paramInt == -1)
    {
      this.vr.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(164187);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 15), com.tencent.mm.cc.a.fromDPToPix(getContext(), 15));
    this.vr.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(164187);
  }
  
  public void setFtsEditTextListener(a parama)
  {
    this.KCz = parama;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(164194);
    this.vr.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(164194);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb);
    
    public abstract boolean bzz();
    
    public abstract void cED();
    
    public abstract void ma(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(164182);
      KCC = new b("UserInput", 0);
      KCD = new b("ClearText", 1);
      KCE = new b("SetText", 2);
      KCF = new b[] { KCC, KCD, KCE };
      AppMethodBeat.o(164182);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.search.FTSEditTextView
 * JD-Core Version:    0.7.0.1
 */