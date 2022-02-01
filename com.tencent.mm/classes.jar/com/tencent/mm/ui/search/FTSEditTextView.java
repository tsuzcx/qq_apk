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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.f.c.b;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSEditTextView
  extends LinearLayout
{
  private String GtB;
  private View HkW;
  private boolean HkX;
  private View.OnClickListener HkY;
  private a HkZ;
  private FTSEditTextView.b Hla;
  private String hint;
  private ImageView kXS;
  protected View.OnFocusChangeListener lmy;
  private List<a.c> oiL;
  private ImageButton qlV;
  public EditText sz;
  private TextView yRj;
  private TextView yRk;
  private TextView ySr;
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164183);
    this.HkX = true;
    this.GtB = "";
    this.HkY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164178);
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
            paramAnonymousView.cok();
          }
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
    this.Hla = FTSEditTextView.b.Hlc;
    this.lmy = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).lb(paramAnonymousBoolean);
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
    this.HkX = true;
    this.GtB = "";
    this.HkY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164178);
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
            paramAnonymousView.cok();
          }
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
    this.Hla = FTSEditTextView.b.Hlc;
    this.lmy = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).lb(paramAnonymousBoolean);
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
    this.oiL.clear();
    if (paramList != null) {
      this.oiL.addAll(paramList);
    }
    ad.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[] { paramString, Integer.valueOf(this.oiL.size()) });
    this.Hla = FTSEditTextView.b.Hle;
    this.sz.setText(paramString);
    Selection.setSelection(this.sz.getText(), this.sz.getText().length());
    fdk();
    this.Hla = paramb;
    AppMethodBeat.o(164191);
  }
  
  private void fdk()
  {
    AppMethodBeat.i(164195);
    ad.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[] { Integer.valueOf(this.oiL.size()) });
    float f = a.ao(getContext(), 2131165517);
    if (this.oiL.size() > 0)
    {
      this.yRj.setVisibility(0);
      this.yRj.setText(b.c(getContext(), ((a.c)this.oiL.get(0)).getTagName(), f));
      if (this.oiL.size() < 2) {
        break label221;
      }
      this.yRk.setVisibility(0);
      this.yRk.setText(b.c(getContext(), ((a.c)this.oiL.get(1)).getTagName(), f));
    }
    for (;;)
    {
      if (this.oiL.size() < 3) {
        break label233;
      }
      this.ySr.setVisibility(0);
      this.ySr.setText(b.c(getContext(), ((a.c)this.oiL.get(2)).getTagName(), f));
      AppMethodBeat.o(164195);
      return;
      this.yRj.setVisibility(8);
      break;
      label221:
      this.yRk.setVisibility(8);
    }
    label233:
    this.ySr.setVisibility(8);
    AppMethodBeat.o(164195);
  }
  
  public final void J(String paramString, List<a.c> paramList)
  {
    AppMethodBeat.i(164190);
    a(paramString, paramList, FTSEditTextView.b.Hlc);
    AppMethodBeat.o(164190);
  }
  
  public final void clearText()
  {
    AppMethodBeat.i(164186);
    this.Hla = FTSEditTextView.b.Hld;
    if (this.HkX) {
      this.oiL.clear();
    }
    this.sz.setText("");
    this.sz.setHint(this.hint);
    this.qlV.setVisibility(8);
    fdk();
    this.Hla = FTSEditTextView.b.Hlc;
    AppMethodBeat.o(164186);
  }
  
  public final void fbk()
  {
    AppMethodBeat.i(204020);
    this.sz.clearFocus();
    AppMethodBeat.o(204020);
  }
  
  public final void fdg()
  {
    AppMethodBeat.i(164198);
    this.kXS.setVisibility(8);
    AppMethodBeat.o(164198);
  }
  
  public final void fdi()
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
  
  public final void fdj()
  {
    AppMethodBeat.i(164192);
    this.sz.requestFocus();
    AppMethodBeat.o(164192);
  }
  
  public final void fdl()
  {
    AppMethodBeat.i(164199);
    this.kXS.setVisibility(0);
    AppMethodBeat.o(164199);
  }
  
  public final void fdm()
  {
    AppMethodBeat.i(164200);
    this.qlV.setVisibility(8);
    AppMethodBeat.o(164200);
  }
  
  public final void fdn()
  {
    AppMethodBeat.i(164201);
    this.qlV.setVisibility(0);
    AppMethodBeat.o(164201);
  }
  
  public ImageButton getClearBtn()
  {
    return this.qlV;
  }
  
  public EditText getEditText()
  {
    return this.sz;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(164189);
    int i = this.sz.getHighlightColor();
    AppMethodBeat.o(164189);
    return i;
  }
  
  public ImageView getIconView()
  {
    return this.kXS;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(164196);
    String str = this.sz.getText().toString().trim();
    AppMethodBeat.o(164196);
    return str;
  }
  
  protected int getLayoutById()
  {
    return 2131494198;
  }
  
  public List<a.c> getTagList()
  {
    return this.oiL;
  }
  
  public View getTagPanel()
  {
    return this.HkW;
  }
  
  public FTSEditTextView.b getTextChangeStatus()
  {
    return this.Hla;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(164197);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.oiL.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((a.c)localIterator.next()).getTagName());
      ((StringBuffer)localObject).append(" ");
    }
    ((StringBuffer)localObject).append(this.sz.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(164197);
    return localObject;
  }
  
  protected void init()
  {
    AppMethodBeat.i(164185);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    this.HkW = findViewById(2131305631);
    this.kXS = ((ImageView)findViewById(2131300874));
    this.sz = ((EditText)findViewById(2131299306));
    this.qlV = ((ImageButton)findViewById(2131298348));
    this.yRj = ((TextView)findViewById(2131305610));
    this.yRk = ((TextView)findViewById(2131305614));
    this.ySr = ((TextView)findViewById(2131305618));
    this.oiL = new ArrayList();
    this.sz.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164173);
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
        AppMethodBeat.o(164173);
        return false;
      }
    });
    this.sz.addTextChangedListener(new TextWatcher()
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
    this.sz.setOnFocusChangeListener(this.lmy);
    this.sz.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164175);
        if ((3 == paramAnonymousInt) && (FTSEditTextView.h(FTSEditTextView.this) != null))
        {
          boolean bool = FTSEditTextView.h(FTSEditTextView.this).bow();
          AppMethodBeat.o(164175);
          return bool;
        }
        AppMethodBeat.o(164175);
        return false;
      }
    });
    this.yRj.setOnClickListener(this.HkY);
    this.yRk.setOnClickListener(this.HkY);
    this.ySr.setOnClickListener(this.HkY);
    this.qlV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(164176);
        FTSEditTextView.this.clearText();
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).onClickClearTextBtn(paramAnonymousView);
        }
        AppMethodBeat.o(164176);
      }
    });
    c.d(this.sz).aaj(100).a(null);
    if (ai.Eq()) {
      this.qlV.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(164185);
  }
  
  public void setCanDeleteTag(boolean paramBoolean)
  {
    this.HkX = paramBoolean;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(164187);
    if (paramInt == -1)
    {
      this.sz.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(164187);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, a.fromDPToPix(getContext(), 15), a.fromDPToPix(getContext(), 15));
    this.sz.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(164187);
  }
  
  public void setFtsEditTextListener(a parama)
  {
    this.HkZ = parama;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(164194);
    this.sz.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(164194);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb);
    
    public abstract boolean bow();
    
    public abstract void cok();
    
    public abstract void lb(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.search.FTSEditTextView
 * JD-Core Version:    0.7.0.1
 */