package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.f.c.b;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MMTagPanel
  extends FlowLayout
{
  public boolean HzE;
  private boolean HzF;
  public boolean HzG;
  public boolean HzH;
  public boolean HzI;
  private int HzJ;
  private int HzK;
  private int HzL;
  private int HzM;
  private d HzN;
  private LinkedList<d> HzO;
  private a HzP;
  private int HzQ;
  private View HzR;
  MMEditText HzS;
  private boolean HzT;
  private View.OnClickListener HzU;
  public boolean mClickable;
  private boolean qOi;
  private int qPG;
  private int qPH;
  private LinkedList<d> sVE;
  private int tPf;
  private int tPg;
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142188);
    this.qOi = false;
    this.HzE = true;
    this.HzF = false;
    this.HzG = true;
    this.HzH = false;
    this.HzI = false;
    this.HzJ = 2131234288;
    this.HzK = 0;
    this.qPH = 2131234298;
    this.qPG = 2131100711;
    this.tPf = 2131234292;
    this.tPg = 2131101171;
    this.HzL = 2131234295;
    this.HzM = 2131101182;
    this.HzN = null;
    this.sVE = new LinkedList();
    this.HzO = new LinkedList();
    this.HzT = false;
    this.HzU = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.e(MMTagPanel.this) != null)
          {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.e(MMTagPanel.this).Yx(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142176);
              }
            });
            AppMethodBeat.o(142179);
          }
        }
        else if ((!MMTagPanel.f(MMTagPanel.this)) || (MMTagPanel.c(MMTagPanel.this)))
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
          if (MMTagPanel.e(MMTagPanel.this) != null)
          {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142177);
                MMTagPanel.e(MMTagPanel.this).Yw(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142177);
              }
            });
            AppMethodBeat.o(142179);
          }
        }
        else if (MMTagPanel.d(MMTagPanel.this) == null)
        {
          MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
          if (MMTagPanel.d(MMTagPanel.this) != null)
          {
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).HAg, false, true);
            AppMethodBeat.o(142179);
          }
        }
        else if (MMTagPanel.d(MMTagPanel.this).HAg == paramAnonymousView)
        {
          MMTagPanel.a(MMTagPanel.this, null);
          MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
          if (MMTagPanel.e(MMTagPanel.this) != null)
          {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142178);
                MMTagPanel.e(MMTagPanel.this).Yw(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142178);
              }
            });
            AppMethodBeat.o(142179);
          }
        }
        else
        {
          MMTagPanel.this.fiO();
          MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).HAg, false, true);
          }
        }
        AppMethodBeat.o(142179);
      }
    };
    this.mClickable = true;
    init();
    AppMethodBeat.o(142188);
  }
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142187);
    this.qOi = false;
    this.HzE = true;
    this.HzF = false;
    this.HzG = true;
    this.HzH = false;
    this.HzI = false;
    this.HzJ = 2131234288;
    this.HzK = 0;
    this.qPH = 2131234298;
    this.qPG = 2131100711;
    this.tPf = 2131234292;
    this.tPg = 2131101171;
    this.HzL = 2131234295;
    this.HzM = 2131101182;
    this.HzN = null;
    this.sVE = new LinkedList();
    this.HzO = new LinkedList();
    this.HzT = false;
    this.HzU = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.e(MMTagPanel.this) != null)
          {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.e(MMTagPanel.this).Yx(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142176);
              }
            });
            AppMethodBeat.o(142179);
          }
        }
        else if ((!MMTagPanel.f(MMTagPanel.this)) || (MMTagPanel.c(MMTagPanel.this)))
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
          if (MMTagPanel.e(MMTagPanel.this) != null)
          {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142177);
                MMTagPanel.e(MMTagPanel.this).Yw(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142177);
              }
            });
            AppMethodBeat.o(142179);
          }
        }
        else if (MMTagPanel.d(MMTagPanel.this) == null)
        {
          MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
          if (MMTagPanel.d(MMTagPanel.this) != null)
          {
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).HAg, false, true);
            AppMethodBeat.o(142179);
          }
        }
        else if (MMTagPanel.d(MMTagPanel.this).HAg == paramAnonymousView)
        {
          MMTagPanel.a(MMTagPanel.this, null);
          MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
          if (MMTagPanel.e(MMTagPanel.this) != null)
          {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142178);
                MMTagPanel.e(MMTagPanel.this).Yw(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142178);
              }
            });
            AppMethodBeat.o(142179);
          }
        }
        else
        {
          MMTagPanel.this.fiO();
          MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).HAg, false, true);
          }
        }
        AppMethodBeat.o(142179);
      }
    };
    this.mClickable = true;
    init();
    AppMethodBeat.o(142187);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(142204);
    paramd.HAg.setOnClickListener(null);
    if (this.HzO.size() >= 16)
    {
      AppMethodBeat.o(142204);
      return;
    }
    this.HzO.add(paramd);
    AppMethodBeat.o(142204);
  }
  
  private void init()
  {
    AppMethodBeat.i(142189);
    this.HzQ = getContext().getResources().getDimensionPixelSize(2131165466);
    this.HzR = LayoutInflater.from(getContext()).inflate(2131494907, null);
    this.HzS = ((MMEditText)this.HzR.findViewById(2131299306));
    this.HzS.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142169);
        if ((paramAnonymousKeyEvent.getAction() == 0) && (67 == paramAnonymousInt))
        {
          ac.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", new Object[] { Integer.valueOf(MMTagPanel.a(MMTagPanel.this).getSelectionStart()), Integer.valueOf(MMTagPanel.a(MMTagPanel.this).getSelectionEnd()) });
          if ((MMTagPanel.a(MMTagPanel.this).getSelectionStart() == 0) && (MMTagPanel.a(MMTagPanel.this).getSelectionStart() == MMTagPanel.a(MMTagPanel.this).getSelectionEnd())) {}
          for (paramAnonymousInt = 1; paramAnonymousInt == 0; paramAnonymousInt = 0)
          {
            AppMethodBeat.o(142169);
            return false;
          }
          MMTagPanel.this.crD();
          if ((MMTagPanel.b(MMTagPanel.this) == null) || (MMTagPanel.b(MMTagPanel.this).isEmpty()))
          {
            AppMethodBeat.o(142169);
            return false;
          }
          if ((MMTagPanel.c(MMTagPanel.this)) || (MMTagPanel.d(MMTagPanel.this) != null)) {
            break label230;
          }
          MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast());
          MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).HAg, false, true);
          MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
        }
        for (;;)
        {
          AppMethodBeat.o(142169);
          return false;
          label230:
          if ((MMTagPanel.d(MMTagPanel.this) != null) && (MMTagPanel.b(MMTagPanel.this) != null) && (MMTagPanel.b(MMTagPanel.this).getLast() != null) && (!bs.isNullOrNil(MMTagPanel.d(MMTagPanel.this).HAf)) && (!bs.isNullOrNil(((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).HAf)) && (!MMTagPanel.d(MMTagPanel.this).HAf.equals(((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).HAf)))
          {
            ac.i("MicroMsg.MMTagPanel", "change hight");
            MMTagPanel.this.fiO();
            MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast());
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).HAg, false, true);
            MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
          }
          else
          {
            paramAnonymousView = ((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).HAf;
            MMTagPanel.this.removeTag(paramAnonymousView);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              MMTagPanel.e(MMTagPanel.this).Yy(paramAnonymousView);
            }
            MMTagPanel.this.fiO();
          }
        }
      }
    });
    this.HzS.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(142170);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.e(MMTagPanel.this).Yz(paramAnonymousEditable);
        }
        if (paramAnonymousEditable.length() > 0) {
          MMTagPanel.this.fiO();
        }
        AppMethodBeat.o(142170);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.HzS.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142171);
        ac.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousBoolean) && (MMTagPanel.e(MMTagPanel.this) != null)) {
          MMTagPanel.e(MMTagPanel.this).cep();
        }
        AppMethodBeat.o(142171);
      }
    });
    this.HzS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142172);
        ac.d("MicroMsg.MMTagPanel", "on edittext click");
        MMTagPanel.this.fiO();
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.e(MMTagPanel.this).cep();
        }
        AppMethodBeat.o(142172);
      }
    });
    this.HzS.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142173);
        ac.d("MicroMsg.MMTagPanel", "on action %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        AppMethodBeat.o(142173);
        return false;
      }
    });
    final c localc = new c();
    b localb = new b();
    this.HzS.setFilters(new InputFilter[] { localc, localb });
    fiM();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142174);
        ac.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[] { Boolean.valueOf(MMTagPanel.f(MMTagPanel.this)) });
        if (MMTagPanel.f(MMTagPanel.this))
        {
          MMTagPanel.this.fiO();
          MMTagPanel.a(MMTagPanel.this).requestFocus();
          MMTagPanel.a(MMTagPanel.this).setSelection(MMTagPanel.a(MMTagPanel.this).getText().length());
          ((InputMethodManager)MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(MMTagPanel.this), 0);
          ac.d("MicroMsg.MMTagPanel", "on content click");
          if (MMTagPanel.e(MMTagPanel.this) != null) {
            MMTagPanel.e(MMTagPanel.this).cep();
          }
        }
        AppMethodBeat.o(142174);
      }
    });
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142175);
        if (MMTagPanel.g(MMTagPanel.this))
        {
          paramAnonymousMotionEvent = MMTagPanel.this.getEditText();
          if (!bs.isNullOrNil(paramAnonymousMotionEvent))
          {
            paramAnonymousView = paramAnonymousMotionEvent;
            if (localc != null)
            {
              paramAnonymousView = paramAnonymousMotionEvent;
              if (f.aRl(paramAnonymousMotionEvent) > localc.HAb)
              {
                int i = localc.HAb - f.aRn(paramAnonymousMotionEvent);
                paramAnonymousView = paramAnonymousMotionEvent;
                if (i < paramAnonymousMotionEvent.length()) {
                  paramAnonymousView = paramAnonymousMotionEvent.substring(0, i);
                }
              }
            }
            MMTagPanel.this.cI(paramAnonymousView, true);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              MMTagPanel.e(MMTagPanel.this).YA(paramAnonymousView);
            }
            MMTagPanel.this.fiK();
          }
        }
        AppMethodBeat.o(142175);
        return false;
      }
    });
    AppMethodBeat.o(142189);
  }
  
  public final void a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(142207);
    paramTextView.setTextSize(0, getContext().getResources().getDimension(2131165466) * a.eb(getContext()));
    if (paramBoolean2)
    {
      paramTextView.setBackgroundResource(this.HzL);
      paramTextView.setTextColor(getResources().getColor(this.HzM));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.HzJ, 0);
      AppMethodBeat.o(142207);
      return;
    }
    if (paramBoolean1)
    {
      paramTextView.setTag(Integer.valueOf(1));
      paramTextView.setBackgroundResource(this.tPf);
      paramTextView.setTextColor(getResources().getColor(this.tPg));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      AppMethodBeat.o(142207);
      return;
    }
    paramTextView.setTag(Integer.valueOf(0));
    paramTextView.setBackgroundResource(this.qPH);
    paramTextView.setTextColor(getResources().getColor(this.qPG));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(142207);
  }
  
  protected final void a(d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142205);
    paramd.HAf = paramString;
    paramd.HAg.setText(b.h(getContext(), paramString, this.HzQ));
    TextView localTextView = paramd.HAg;
    if (this.HzE) {}
    for (paramString = this.HzU;; paramString = null)
    {
      localTextView.setOnClickListener(paramString);
      a(paramd.HAg, paramBoolean, false);
      AppMethodBeat.o(142205);
      return;
    }
  }
  
  public final void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(142202);
    fiD();
    if (this.HzF) {
      addView(this.HzR);
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(142202);
      return;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramCollection == null) {}
      for (boolean bool = false;; bool = paramCollection.contains(str))
      {
        cI(str, bool);
        break;
      }
    }
    AppMethodBeat.o(142202);
  }
  
  public final void cI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142208);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
      AppMethodBeat.o(142208);
      return;
    }
    paramString = paramString.trim();
    ac.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", new Object[] { paramString });
    removeTag(paramString);
    Object localObject = this.sVE.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((d)((Iterator)localObject).next()).HAf))
      {
        ac.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(142208);
        return;
      }
    }
    localObject = fiN();
    a((d)localObject, paramString, paramBoolean);
    this.sVE.add(localObject);
    if (this.HzF) {
      addView(((d)localObject).HAg, getChildCount() - 1);
    }
    for (;;)
    {
      fiO();
      AppMethodBeat.o(142208);
      return;
      addView(((d)localObject).HAg);
    }
  }
  
  public final void cJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142211);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
      AppMethodBeat.o(142211);
      return;
    }
    Iterator localIterator = this.sVE.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.HAf))
      {
        a(locald, paramString, paramBoolean);
        fiO();
        AppMethodBeat.o(142211);
        return;
      }
    }
    ac.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142211);
  }
  
  protected void crD() {}
  
  public void fiD()
  {
    AppMethodBeat.i(142201);
    this.sVE.clear();
    removeAllViews();
    Iterator localIterator = this.sVE.iterator();
    while (localIterator.hasNext()) {
      a((d)localIterator.next());
    }
    AppMethodBeat.o(142201);
  }
  
  public final void fiK()
  {
    AppMethodBeat.i(142194);
    if (this.HzS != null) {
      this.HzS.setText("");
    }
    AppMethodBeat.o(142194);
  }
  
  public final void fiL()
  {
    AppMethodBeat.i(142195);
    if ((this.HzS == null) || (this.HzS.isFocused()))
    {
      AppMethodBeat.o(142195);
      return;
    }
    this.HzS.requestFocus();
    AppMethodBeat.o(142195);
  }
  
  public final void fiM()
  {
    AppMethodBeat.i(142196);
    if ((this.HzS != null) && (this.HzS.isFocused()))
    {
      ac.d("MicroMsg.MMTagPanel", "do clear edit focus");
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      IBinder localIBinder = this.HzS.getWindowToken();
      if (localIBinder == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
      this.HzS.clearFocus();
    }
    AppMethodBeat.o(142196);
  }
  
  protected final d fiN()
  {
    AppMethodBeat.i(142203);
    if (!this.HzO.isEmpty())
    {
      localObject = (d)this.HzO.removeFirst();
      AppMethodBeat.o(142203);
      return localObject;
    }
    d locald = new d();
    TextView localTextView = new TextView(getContext());
    localTextView.setBackgroundResource(this.qPH);
    localTextView.setTextColor(getResources().getColor(this.qPG));
    localTextView.setTag(Integer.valueOf(0));
    localTextView.setGravity(17);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.HzJ, 0);
    if (this.HzE) {}
    for (Object localObject = this.HzU;; localObject = null)
    {
      localTextView.setOnClickListener((View.OnClickListener)localObject);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine();
      locald.HAg = localTextView;
      AppMethodBeat.o(142203);
      return locald;
    }
  }
  
  protected final void fiO()
  {
    AppMethodBeat.i(142206);
    if (this.HzS != null)
    {
      ac.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[] { Boolean.valueOf(this.HzS.isFocused()) });
      this.HzS.setCursorVisible(true);
    }
    if (this.HzN == null)
    {
      AppMethodBeat.o(142206);
      return;
    }
    TextView localTextView = this.HzN.HAg;
    if (((Integer)this.HzN.HAg.getTag()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      this.HzN = null;
      AppMethodBeat.o(142206);
      return;
    }
  }
  
  public final void fiP()
  {
    AppMethodBeat.i(142210);
    Iterator localIterator = this.sVE.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      removeView(locald.HAg);
      a(locald);
    }
    this.sVE.clear();
    fiO();
    AppMethodBeat.o(142210);
  }
  
  public String getEditText()
  {
    AppMethodBeat.i(142193);
    if (this.HzS != null)
    {
      String str = this.HzS.getText().toString();
      AppMethodBeat.o(142193);
      return str;
    }
    AppMethodBeat.o(142193);
    return "";
  }
  
  public int getTagCount()
  {
    AppMethodBeat.i(142200);
    int i = this.sVE.size();
    AppMethodBeat.o(142200);
    return i;
  }
  
  public ArrayList<String> getTagList()
  {
    AppMethodBeat.i(142199);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.sVE.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!bs.isNullOrNil(locald.HAf)) {
        localArrayList.add(locald.HAf);
      }
    }
    AppMethodBeat.o(142199);
    return localArrayList;
  }
  
  public Set<String> getTagSet()
  {
    AppMethodBeat.i(142198);
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.sVE.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!bs.isNullOrNil(locald.HAf)) {
        localTreeSet.add(locald.HAf);
      }
    }
    AppMethodBeat.o(142198);
    return localTreeSet;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142212);
    if (this.mClickable)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142212);
      return bool;
    }
    AppMethodBeat.o(142212);
    return true;
  }
  
  public final void removeTag(String paramString)
  {
    AppMethodBeat.i(142209);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
      AppMethodBeat.o(142209);
      return;
    }
    Iterator localIterator = this.sVE.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.HAf))
      {
        this.sVE.remove(locald);
        removeView(locald.HAg);
        a(locald);
        fiO();
        AppMethodBeat.o(142209);
        return;
      }
    }
    ac.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142209);
  }
  
  public void setCallBack(a parama)
  {
    this.HzP = parama;
  }
  
  public void setEditHint(String paramString)
  {
    AppMethodBeat.i(142192);
    if (this.HzS != null) {
      this.HzS.setHint(paramString);
    }
    AppMethodBeat.o(142192);
  }
  
  public void setEditTextColor(int paramInt)
  {
    AppMethodBeat.i(142191);
    if (this.HzS != null) {
      this.HzS.setTextColor(paramInt);
    }
    AppMethodBeat.o(142191);
  }
  
  public void setEditTextHit(boolean paramBoolean)
  {
    AppMethodBeat.i(142213);
    if (this.HzS != null)
    {
      if (paramBoolean)
      {
        this.HzS.setHint(2131755158);
        AppMethodBeat.o(142213);
        return;
      }
      this.HzS.setHint("");
    }
    AppMethodBeat.o(142213);
  }
  
  public void setIsAllowEnterCharacter(boolean paramBoolean)
  {
    this.HzT = paramBoolean;
  }
  
  public void setPanelClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public void setTagEditTextBG(int paramInt)
  {
    AppMethodBeat.i(142190);
    this.HzK = paramInt;
    if (this.HzS != null)
    {
      a.fromDPToPix(getContext(), 6);
      getResources().getDimensionPixelSize(2131165516);
      this.HzS.setBackgroundResource(this.HzK);
    }
    AppMethodBeat.o(142190);
  }
  
  public void setTagHighlineBG(int paramInt)
  {
    this.HzL = paramInt;
  }
  
  public void setTagNormalBG(int paramInt)
  {
    this.qPH = paramInt;
  }
  
  public void setTagNormalTextColorRes(int paramInt)
  {
    this.qPG = paramInt;
  }
  
  public void setTagSelectedBG(int paramInt)
  {
    this.tPf = paramInt;
  }
  
  public void setTagSelectedTextColorRes(int paramInt)
  {
    this.tPg = paramInt;
  }
  
  public void setTagTipsDrawable(int paramInt)
  {
    this.HzJ = paramInt;
  }
  
  public void setTaghighlineTextColorRes(int paramInt)
  {
    this.HzM = paramInt;
  }
  
  public final void wR(boolean paramBoolean)
  {
    AppMethodBeat.i(142197);
    if (paramBoolean == this.HzF)
    {
      AppMethodBeat.o(142197);
      return;
    }
    this.HzF = paramBoolean;
    removeView(this.HzR);
    if (this.HzF)
    {
      addView(this.HzR);
      fiM();
    }
    AppMethodBeat.o(142197);
  }
  
  public static abstract interface a
  {
    public abstract void C(boolean paramBoolean, int paramInt);
    
    public abstract void YA(String paramString);
    
    public abstract void Yw(String paramString);
    
    public abstract void Yx(String paramString);
    
    public abstract void Yy(String paramString);
    
    public abstract void Yz(String paramString);
    
    public abstract void cep();
  }
  
  public final class b
    implements InputFilter
  {
    List<String> HzY;
    int mark;
    
    public b()
    {
      AppMethodBeat.i(142183);
      this.HzY = new LinkedList();
      AppMethodBeat.o(142183);
    }
    
    public final CharSequence filter(final CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142184);
      ac.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(MMTagPanel.i(MMTagPanel.this)) });
      this.mark = -1;
      this.HzY.clear();
      Object localObject = new char[paramInt2 - paramInt1];
      TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, (char[])localObject, 0);
      if (!MMTagPanel.j(MMTagPanel.this))
      {
        i = 0;
        paramCharSequence = new StringBuilder();
        if (paramInt1 < paramInt2)
        {
          if (localObject[paramInt1] == '\n') {
            i = 1;
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            paramCharSequence.append(localObject[paramInt1]);
          }
        }
        if (i != 0)
        {
          localObject = paramCharSequence.toString();
          paramCharSequence.insert(0, paramSpanned.subSequence(0, paramInt3));
          paramCharSequence.append(paramSpanned.subSequence(paramInt4, paramSpanned.length()));
          MMTagPanel.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142180);
              MMTagPanel.e(MMTagPanel.this).YA(paramCharSequence.toString());
              AppMethodBeat.o(142180);
            }
          });
          AppMethodBeat.o(142184);
          return localObject;
        }
        AppMethodBeat.o(142184);
        return null;
      }
      int i = paramInt1;
      if (i < paramInt2)
      {
        if ((localObject[i] == '\n') || (localObject[i] == ',') || (localObject[i] == ';') || (localObject[i] == '、') || (localObject[i] == 65292) || (localObject[i] == 65307))
        {
          if (-1 != this.mark) {
            break label385;
          }
          this.HzY.add((paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, i)).trim());
        }
        for (;;)
        {
          this.mark = (i + 1);
          i += 1;
          break;
          label385:
          this.HzY.add(paramCharSequence.subSequence(this.mark, i).toString().trim());
        }
      }
      if (MMTagPanel.h(MMTagPanel.this))
      {
        paramInt1 = f.aRl(paramSpanned.toString());
        if ((MMTagPanel.i(MMTagPanel.this)) && (paramCharSequence.equals("\n")) && (36 < paramInt1)) {
          this.HzY.clear();
        }
      }
      if (this.HzY.isEmpty())
      {
        AppMethodBeat.o(142184);
        return null;
      }
      if (MMTagPanel.e(MMTagPanel.this) != null)
      {
        localObject = this.HzY.iterator();
        while (((Iterator)localObject).hasNext())
        {
          final String str = (String)((Iterator)localObject).next();
          if (str.length() > 0) {
            MMTagPanel.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142181);
                MMTagPanel.e(MMTagPanel.this).YA(str.trim());
                AppMethodBeat.o(142181);
              }
            });
          }
        }
      }
      if (this.mark >= paramInt2) {
        paramSpanned.length();
      }
      for (paramCharSequence = paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();; paramCharSequence = paramCharSequence.subSequence(this.mark, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()))
      {
        MMTagPanel.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(142182);
            MMTagPanel.a(MMTagPanel.this).setText("");
            MMTagPanel.a(MMTagPanel.this).append(paramCharSequence);
            AppMethodBeat.o(142182);
          }
        });
        AppMethodBeat.o(142184);
        return "";
      }
    }
  }
  
  public final class c
    implements InputFilter
  {
    int HAb = 36;
    private int HAc = 256;
    private int HAd;
    
    public c() {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142186);
      paramInt1 = f.aRl(paramSpanned.toString()) + f.aRl(paramCharSequence.toString());
      if (paramInt4 > paramInt3) {
        if (paramInt1 - (paramInt4 - paramInt3) > this.HAb)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.HAd = (paramInt1 - (paramInt4 - paramInt3) - this.HAb);
        }
      }
      for (;;)
      {
        if ((MMTagPanel.h(MMTagPanel.this)) && (1 == this.HAd) && (paramCharSequence.equals("\n"))) {
          this.HAd = 0;
        }
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142185);
              MMTagPanel.e(MMTagPanel.this).C(MMTagPanel.i(MMTagPanel.this), f.cM(MMTagPanel.c.a(MMTagPanel.c.this), ""));
              AppMethodBeat.o(142185);
            }
          });
        }
        if (paramInt1 <= this.HAc) {
          break;
        }
        AppMethodBeat.o(142186);
        return "";
        MMTagPanel.a(MMTagPanel.this, false);
        continue;
        if (paramInt1 > this.HAb)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.HAd = (paramInt1 - this.HAb);
        }
        else
        {
          MMTagPanel.a(MMTagPanel.this, false);
        }
      }
      AppMethodBeat.o(142186);
      return paramCharSequence;
    }
  }
  
  public static final class d
  {
    public String HAf;
    public TextView HAg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel
 * JD-Core Version:    0.7.0.1
 */