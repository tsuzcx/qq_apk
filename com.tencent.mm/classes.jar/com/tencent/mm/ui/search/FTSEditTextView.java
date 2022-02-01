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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.f.c.b;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FTSEditTextView
  extends LinearLayout
{
  private TextView AeY;
  private TextView AeZ;
  private TextView Agg;
  private String HTu;
  private View ILp;
  private boolean ILq;
  private View.OnClickListener ILr;
  private a ILs;
  private FTSEditTextView.b ILt;
  private String hint;
  protected View.OnFocusChangeListener lMo;
  private ImageView lzC;
  private List<a.c> oMl;
  private ImageButton qUx;
  public EditText ty;
  
  public FTSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164183);
    this.ILq = true;
    this.HTu = "";
    this.ILr = new View.OnClickListener()
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
            paramAnonymousView.cxG();
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
    this.ILt = FTSEditTextView.b.ILv;
    this.lMo = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).lF(paramAnonymousBoolean);
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
    this.ILq = true;
    this.HTu = "";
    this.ILr = new View.OnClickListener()
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
            paramAnonymousView.cxG();
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
    this.ILt = FTSEditTextView.b.ILv;
    this.lMo = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164179);
        if (FTSEditTextView.h(FTSEditTextView.this) != null) {
          FTSEditTextView.h(FTSEditTextView.this).lF(paramAnonymousBoolean);
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
    this.oMl.clear();
    if (paramList != null) {
      this.oMl.addAll(paramList);
    }
    ac.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[] { paramString, Integer.valueOf(this.oMl.size()) });
    this.ILt = FTSEditTextView.b.ILx;
    this.ty.setText(paramString);
    Selection.setSelection(this.ty.getText(), this.ty.getText().length());
    ftf();
    this.ILt = paramb;
    AppMethodBeat.o(164191);
  }
  
  private void ftf()
  {
    AppMethodBeat.i(164195);
    ac.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[] { Integer.valueOf(this.oMl.size()) });
    float f = a.au(getContext(), 2131165517);
    if (this.oMl.size() > 0)
    {
      this.AeY.setVisibility(0);
      this.AeY.setText(b.c(getContext(), ((a.c)this.oMl.get(0)).getTagName(), f));
      if (this.oMl.size() < 2) {
        break label221;
      }
      this.AeZ.setVisibility(0);
      this.AeZ.setText(b.c(getContext(), ((a.c)this.oMl.get(1)).getTagName(), f));
    }
    for (;;)
    {
      if (this.oMl.size() < 3) {
        break label233;
      }
      this.Agg.setVisibility(0);
      this.Agg.setText(b.c(getContext(), ((a.c)this.oMl.get(2)).getTagName(), f));
      AppMethodBeat.o(164195);
      return;
      this.AeY.setVisibility(8);
      break;
      label221:
      this.AeZ.setVisibility(8);
    }
    label233:
    this.Agg.setVisibility(8);
    AppMethodBeat.o(164195);
  }
  
  public final void F(String paramString, List<a.c> paramList)
  {
    AppMethodBeat.i(164190);
    a(paramString, paramList, FTSEditTextView.b.ILv);
    AppMethodBeat.o(164190);
  }
  
  public final void clearText()
  {
    AppMethodBeat.i(164186);
    this.ILt = FTSEditTextView.b.ILw;
    if (this.ILq) {
      this.oMl.clear();
    }
    this.ty.setText("");
    this.ty.setHint(this.hint);
    this.qUx.setVisibility(8);
    ftf();
    this.ILt = FTSEditTextView.b.ILv;
    AppMethodBeat.o(164186);
  }
  
  public final void frb()
  {
    AppMethodBeat.i(210327);
    this.ty.clearFocus();
    AppMethodBeat.o(210327);
  }
  
  public final void ftb()
  {
    AppMethodBeat.i(164198);
    this.lzC.setVisibility(8);
    AppMethodBeat.o(164198);
  }
  
  public final void ftd()
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
  
  public final void fte()
  {
    AppMethodBeat.i(164192);
    this.ty.requestFocus();
    AppMethodBeat.o(164192);
  }
  
  public final void ftg()
  {
    AppMethodBeat.i(164199);
    this.lzC.setVisibility(0);
    AppMethodBeat.o(164199);
  }
  
  public final void fth()
  {
    AppMethodBeat.i(164200);
    this.qUx.setVisibility(8);
    AppMethodBeat.o(164200);
  }
  
  public final void fti()
  {
    AppMethodBeat.i(164201);
    this.qUx.setVisibility(0);
    AppMethodBeat.o(164201);
  }
  
  public ImageButton getClearBtn()
  {
    return this.qUx;
  }
  
  public EditText getEditText()
  {
    return this.ty;
  }
  
  public int getHighlightColor()
  {
    AppMethodBeat.i(164189);
    int i = this.ty.getHighlightColor();
    AppMethodBeat.o(164189);
    return i;
  }
  
  public ImageView getIconView()
  {
    return this.lzC;
  }
  
  public String getInEditTextQuery()
  {
    AppMethodBeat.i(164196);
    String str = this.ty.getText().toString().trim();
    AppMethodBeat.o(164196);
    return str;
  }
  
  protected int getLayoutById()
  {
    return 2131494198;
  }
  
  public List<a.c> getTagList()
  {
    return this.oMl;
  }
  
  public View getTagPanel()
  {
    return this.ILp;
  }
  
  public FTSEditTextView.b getTextChangeStatus()
  {
    return this.ILt;
  }
  
  public String getTotalQuery()
  {
    AppMethodBeat.i(164197);
    Object localObject = new StringBuffer();
    Iterator localIterator = this.oMl.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuffer)localObject).append(((a.c)localIterator.next()).getTagName());
      ((StringBuffer)localObject).append(" ");
    }
    ((StringBuffer)localObject).append(this.ty.getText().toString());
    localObject = ((StringBuffer)localObject).toString().trim();
    AppMethodBeat.o(164197);
    return localObject;
  }
  
  protected void init()
  {
    AppMethodBeat.i(164185);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutById(), this, true);
    this.ILp = findViewById(2131305631);
    this.lzC = ((ImageView)findViewById(2131300874));
    this.ty = ((EditText)findViewById(2131299306));
    this.qUx = ((ImageButton)findViewById(2131298348));
    this.AeY = ((TextView)findViewById(2131305610));
    this.AeZ = ((TextView)findViewById(2131305614));
    this.Agg = ((TextView)findViewById(2131305618));
    this.oMl = new ArrayList();
    this.ty.setOnKeyListener(new View.OnKeyListener()
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
    this.ty.addTextChangedListener(new TextWatcher()
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
    this.ty.setOnFocusChangeListener(this.lMo);
    this.ty.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(164175);
        if ((3 == paramAnonymousInt) && (FTSEditTextView.h(FTSEditTextView.this) != null))
        {
          boolean bool = FTSEditTextView.h(FTSEditTextView.this).bvs();
          AppMethodBeat.o(164175);
          return bool;
        }
        AppMethodBeat.o(164175);
        return false;
      }
    });
    this.AeY.setOnClickListener(this.ILr);
    this.AeZ.setOnClickListener(this.ILr);
    this.Agg.setOnClickListener(this.ILr);
    this.qUx.setOnClickListener(new View.OnClickListener()
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
    c.d(this.ty).acw(100).a(null);
    if (aj.DT()) {
      this.qUx.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(164185);
  }
  
  public void setCanDeleteTag(boolean paramBoolean)
  {
    this.ILq = paramBoolean;
  }
  
  public void setEditTextDrawableLeft(int paramInt)
  {
    AppMethodBeat.i(164187);
    if (paramInt == -1)
    {
      this.ty.setCompoundDrawablesRelative(null, null, null, null);
      AppMethodBeat.o(164187);
      return;
    }
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, a.fromDPToPix(getContext(), 15), a.fromDPToPix(getContext(), 15));
    this.ty.setCompoundDrawablesRelative(localDrawable, null, null, null);
    AppMethodBeat.o(164187);
  }
  
  public void setFtsEditTextListener(a parama)
  {
    this.ILs = parama;
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(164194);
    this.ty.setHint(paramString);
    this.hint = paramString;
    AppMethodBeat.o(164194);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb);
    
    public abstract boolean bvs();
    
    public abstract void cxG();
    
    public abstract void lF(boolean paramBoolean);
    
    public abstract void onClickClearTextBtn(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.search.FTSEditTextView
 * JD-Core Version:    0.7.0.1
 */