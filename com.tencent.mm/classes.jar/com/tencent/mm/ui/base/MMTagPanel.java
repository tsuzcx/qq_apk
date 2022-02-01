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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int JnA;
  private int JnB;
  private int JnC;
  private int JnD;
  private d JnE;
  private LinkedList<d> JnF;
  private a JnG;
  private int JnH;
  private View JnI;
  MMEditText JnJ;
  private boolean JnK;
  private View.OnClickListener JnL;
  public boolean Jnv;
  private boolean Jnw;
  public boolean Jnx;
  public boolean Jny;
  public boolean Jnz;
  public boolean mClickable;
  private boolean ryh;
  private int rzF;
  private int rzG;
  private LinkedList<d> tSj;
  private int uRS;
  private int uRT;
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142188);
    this.ryh = false;
    this.Jnv = true;
    this.Jnw = false;
    this.Jnx = true;
    this.Jny = false;
    this.Jnz = false;
    this.JnA = 2131234288;
    this.JnB = 0;
    this.rzG = 2131234298;
    this.rzF = 2131100711;
    this.uRS = 2131234292;
    this.uRT = 2131101171;
    this.JnC = 2131234295;
    this.JnD = 2131101182;
    this.JnE = null;
    this.tSj = new LinkedList();
    this.JnF = new LinkedList();
    this.JnK = false;
    this.JnL = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.e(MMTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.e(MMTagPanel.this).acd(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142176);
              }
            });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142179);
          return;
          if ((!MMTagPanel.f(MMTagPanel.this)) || (MMTagPanel.c(MMTagPanel.this)))
          {
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142177);
                  MMTagPanel.e(MMTagPanel.this).acc(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142177);
                }
              });
            }
          }
          else if (MMTagPanel.d(MMTagPanel.this) == null)
          {
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).JnX, false, true);
            }
          }
          else if (MMTagPanel.d(MMTagPanel.this).JnX == paramAnonymousView)
          {
            MMTagPanel.a(MMTagPanel.this, null);
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142178);
                  MMTagPanel.e(MMTagPanel.this).acc(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142178);
                }
              });
            }
          }
          else
          {
            MMTagPanel.this.fzd();
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).JnX, false, true);
            }
          }
        }
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
    this.ryh = false;
    this.Jnv = true;
    this.Jnw = false;
    this.Jnx = true;
    this.Jny = false;
    this.Jnz = false;
    this.JnA = 2131234288;
    this.JnB = 0;
    this.rzG = 2131234298;
    this.rzF = 2131100711;
    this.uRS = 2131234292;
    this.uRT = 2131101171;
    this.JnC = 2131234295;
    this.JnD = 2131101182;
    this.JnE = null;
    this.tSj = new LinkedList();
    this.JnF = new LinkedList();
    this.JnK = false;
    this.JnL = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.e(MMTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.e(MMTagPanel.this).acd(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142176);
              }
            });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142179);
          return;
          if ((!MMTagPanel.f(MMTagPanel.this)) || (MMTagPanel.c(MMTagPanel.this)))
          {
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142177);
                  MMTagPanel.e(MMTagPanel.this).acc(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142177);
                }
              });
            }
          }
          else if (MMTagPanel.d(MMTagPanel.this) == null)
          {
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).JnX, false, true);
            }
          }
          else if (MMTagPanel.d(MMTagPanel.this).JnX == paramAnonymousView)
          {
            MMTagPanel.a(MMTagPanel.this, null);
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142178);
                  MMTagPanel.e(MMTagPanel.this).acc(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142178);
                }
              });
            }
          }
          else
          {
            MMTagPanel.this.fzd();
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).JnX, false, true);
            }
          }
        }
      }
    };
    this.mClickable = true;
    init();
    AppMethodBeat.o(142187);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(142204);
    paramd.JnX.setOnClickListener(null);
    if (this.JnF.size() >= 16)
    {
      AppMethodBeat.o(142204);
      return;
    }
    this.JnF.add(paramd);
    AppMethodBeat.o(142204);
  }
  
  private void init()
  {
    AppMethodBeat.i(142189);
    this.JnH = getContext().getResources().getDimensionPixelSize(2131165466);
    this.JnI = LayoutInflater.from(getContext()).inflate(2131494907, null);
    this.JnJ = ((MMEditText)this.JnI.findViewById(2131299306));
    this.JnJ.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142169);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (67 == paramAnonymousInt))
        {
          ad.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", new Object[] { Integer.valueOf(MMTagPanel.a(MMTagPanel.this).getSelectionStart()), Integer.valueOf(MMTagPanel.a(MMTagPanel.this).getSelectionEnd()) });
          if ((MMTagPanel.a(MMTagPanel.this).getSelectionStart() == 0) && (MMTagPanel.a(MMTagPanel.this).getSelectionStart() == MMTagPanel.a(MMTagPanel.this).getSelectionEnd())) {}
          for (paramAnonymousInt = 1; paramAnonymousInt == 0; paramAnonymousInt = 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(142169);
            return false;
          }
          MMTagPanel.this.cxp();
          if ((MMTagPanel.b(MMTagPanel.this) == null) || (MMTagPanel.b(MMTagPanel.this).isEmpty()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(142169);
            return false;
          }
          if ((MMTagPanel.c(MMTagPanel.this)) || (MMTagPanel.d(MMTagPanel.this) != null)) {
            break label313;
          }
          MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast());
          MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).JnX, false, true);
          MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(142169);
          return false;
          label313:
          if ((MMTagPanel.d(MMTagPanel.this) != null) && (MMTagPanel.b(MMTagPanel.this) != null) && (MMTagPanel.b(MMTagPanel.this).getLast() != null) && (!bt.isNullOrNil(MMTagPanel.d(MMTagPanel.this).JnW)) && (!bt.isNullOrNil(((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).JnW)) && (!MMTagPanel.d(MMTagPanel.this).JnW.equals(((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).JnW)))
          {
            ad.i("MicroMsg.MMTagPanel", "change hight");
            MMTagPanel.this.fzd();
            MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast());
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).JnX, false, true);
            MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
          }
          else
          {
            paramAnonymousView = ((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).JnW;
            MMTagPanel.this.removeTag(paramAnonymousView);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              MMTagPanel.e(MMTagPanel.this).ace(paramAnonymousView);
            }
            MMTagPanel.this.fzd();
          }
        }
      }
    });
    this.JnJ.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(142170);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.e(MMTagPanel.this).acf(paramAnonymousEditable);
        }
        if (paramAnonymousEditable.length() > 0) {
          MMTagPanel.this.fzd();
        }
        AppMethodBeat.o(142170);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.JnJ.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142171);
        ad.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousBoolean) && (MMTagPanel.e(MMTagPanel.this) != null)) {
          MMTagPanel.e(MMTagPanel.this).ciS();
        }
        AppMethodBeat.o(142171);
      }
    });
    this.JnJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142172);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.MMTagPanel", "on edittext click");
        MMTagPanel.this.fzd();
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.e(MMTagPanel.this).ciS();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142172);
      }
    });
    this.JnJ.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142173);
        ad.d("MicroMsg.MMTagPanel", "on action %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        AppMethodBeat.o(142173);
        return false;
      }
    });
    final c localc = new c();
    b localb = new b();
    this.JnJ.setFilters(new InputFilter[] { localc, localb });
    fzb();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142174);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[] { Boolean.valueOf(MMTagPanel.f(MMTagPanel.this)) });
        if (MMTagPanel.f(MMTagPanel.this))
        {
          MMTagPanel.this.fzd();
          MMTagPanel.a(MMTagPanel.this).requestFocus();
          MMTagPanel.a(MMTagPanel.this).setSelection(MMTagPanel.a(MMTagPanel.this).getText().length());
          ((InputMethodManager)MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(MMTagPanel.this), 0);
          ad.d("MicroMsg.MMTagPanel", "on content click");
          if (MMTagPanel.e(MMTagPanel.this) != null) {
            MMTagPanel.e(MMTagPanel.this).ciS();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142174);
      }
    });
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142175);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (MMTagPanel.g(MMTagPanel.this))
        {
          paramAnonymousMotionEvent = MMTagPanel.this.getEditText();
          if (!bt.isNullOrNil(paramAnonymousMotionEvent))
          {
            paramAnonymousView = paramAnonymousMotionEvent;
            if (localc != null)
            {
              paramAnonymousView = paramAnonymousMotionEvent;
              if (f.aXj(paramAnonymousMotionEvent) > localc.JnS)
              {
                int i = localc.JnS - f.aXl(paramAnonymousMotionEvent);
                paramAnonymousView = paramAnonymousMotionEvent;
                if (i < paramAnonymousMotionEvent.length()) {
                  paramAnonymousView = paramAnonymousMotionEvent.substring(0, i);
                }
              }
            }
            MMTagPanel.this.cN(paramAnonymousView, true);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              MMTagPanel.e(MMTagPanel.this).acg(paramAnonymousView);
            }
            MMTagPanel.this.fyZ();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142175);
        return false;
      }
    });
    AppMethodBeat.o(142189);
  }
  
  public final void a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(142207);
    paramTextView.setTextSize(0, getContext().getResources().getDimension(2131165466) * com.tencent.mm.cc.a.eb(getContext()));
    if (paramBoolean2)
    {
      paramTextView.setBackgroundResource(this.JnC);
      paramTextView.setTextColor(getResources().getColor(this.JnD));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.JnA, 0);
      AppMethodBeat.o(142207);
      return;
    }
    if (paramBoolean1)
    {
      paramTextView.setTag(Integer.valueOf(1));
      paramTextView.setBackgroundResource(this.uRS);
      paramTextView.setTextColor(getResources().getColor(this.uRT));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      AppMethodBeat.o(142207);
      return;
    }
    paramTextView.setTag(Integer.valueOf(0));
    paramTextView.setBackgroundResource(this.rzG);
    paramTextView.setTextColor(getResources().getColor(this.rzF));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(142207);
  }
  
  protected final void a(d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142205);
    paramd.JnW = paramString;
    paramd.JnX.setText(com.tencent.mm.ui.f.c.b.h(getContext(), paramString, this.JnH));
    TextView localTextView = paramd.JnX;
    if (this.Jnv) {}
    for (paramString = this.JnL;; paramString = null)
    {
      localTextView.setOnClickListener(paramString);
      a(paramd.JnX, paramBoolean, false);
      AppMethodBeat.o(142205);
      return;
    }
  }
  
  public final void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(142202);
    fyS();
    if (this.Jnw) {
      addView(this.JnI);
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
        cN(str, bool);
        break;
      }
    }
    AppMethodBeat.o(142202);
  }
  
  public final void cN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142208);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
      AppMethodBeat.o(142208);
      return;
    }
    paramString = paramString.trim();
    ad.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", new Object[] { paramString });
    removeTag(paramString);
    Object localObject = this.tSj.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((d)((Iterator)localObject).next()).JnW))
      {
        ad.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(142208);
        return;
      }
    }
    localObject = fzc();
    a((d)localObject, paramString, paramBoolean);
    this.tSj.add(localObject);
    if (this.Jnw) {
      addView(((d)localObject).JnX, getChildCount() - 1);
    }
    for (;;)
    {
      fzd();
      AppMethodBeat.o(142208);
      return;
      addView(((d)localObject).JnX);
    }
  }
  
  public final void cO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142211);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
      AppMethodBeat.o(142211);
      return;
    }
    Iterator localIterator = this.tSj.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.JnW))
      {
        a(locald, paramString, paramBoolean);
        fzd();
        AppMethodBeat.o(142211);
        return;
      }
    }
    ad.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142211);
  }
  
  protected void cxp() {}
  
  public void fyS()
  {
    AppMethodBeat.i(142201);
    this.tSj.clear();
    removeAllViews();
    Iterator localIterator = this.tSj.iterator();
    while (localIterator.hasNext()) {
      a((d)localIterator.next());
    }
    AppMethodBeat.o(142201);
  }
  
  public final void fyZ()
  {
    AppMethodBeat.i(142194);
    if (this.JnJ != null) {
      this.JnJ.setText("");
    }
    AppMethodBeat.o(142194);
  }
  
  public final void fza()
  {
    AppMethodBeat.i(142195);
    if ((this.JnJ == null) || (this.JnJ.isFocused()))
    {
      AppMethodBeat.o(142195);
      return;
    }
    this.JnJ.requestFocus();
    AppMethodBeat.o(142195);
  }
  
  public final void fzb()
  {
    AppMethodBeat.i(142196);
    if ((this.JnJ != null) && (this.JnJ.isFocused()))
    {
      ad.d("MicroMsg.MMTagPanel", "do clear edit focus");
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      IBinder localIBinder = this.JnJ.getWindowToken();
      if (localIBinder == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
      this.JnJ.clearFocus();
    }
    AppMethodBeat.o(142196);
  }
  
  protected final d fzc()
  {
    AppMethodBeat.i(142203);
    if (!this.JnF.isEmpty())
    {
      localObject = (d)this.JnF.removeFirst();
      AppMethodBeat.o(142203);
      return localObject;
    }
    d locald = new d();
    TextView localTextView = new TextView(getContext());
    localTextView.setBackgroundResource(this.rzG);
    localTextView.setTextColor(getResources().getColor(this.rzF));
    localTextView.setTag(Integer.valueOf(0));
    localTextView.setGravity(17);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.JnA, 0);
    if (this.Jnv) {}
    for (Object localObject = this.JnL;; localObject = null)
    {
      localTextView.setOnClickListener((View.OnClickListener)localObject);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine();
      locald.JnX = localTextView;
      AppMethodBeat.o(142203);
      return locald;
    }
  }
  
  protected final void fzd()
  {
    AppMethodBeat.i(142206);
    if (this.JnJ != null)
    {
      ad.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[] { Boolean.valueOf(this.JnJ.isFocused()) });
      this.JnJ.setCursorVisible(true);
    }
    if (this.JnE == null)
    {
      AppMethodBeat.o(142206);
      return;
    }
    TextView localTextView = this.JnE.JnX;
    if (((Integer)this.JnE.JnX.getTag()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      this.JnE = null;
      AppMethodBeat.o(142206);
      return;
    }
  }
  
  public final void fze()
  {
    AppMethodBeat.i(142210);
    Iterator localIterator = this.tSj.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      removeView(locald.JnX);
      a(locald);
    }
    this.tSj.clear();
    fzd();
    AppMethodBeat.o(142210);
  }
  
  public String getEditText()
  {
    AppMethodBeat.i(142193);
    if (this.JnJ != null)
    {
      String str = this.JnJ.getText().toString();
      AppMethodBeat.o(142193);
      return str;
    }
    AppMethodBeat.o(142193);
    return "";
  }
  
  public int getTagCount()
  {
    AppMethodBeat.i(142200);
    int i = this.tSj.size();
    AppMethodBeat.o(142200);
    return i;
  }
  
  public ArrayList<String> getTagList()
  {
    AppMethodBeat.i(142199);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tSj.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!bt.isNullOrNil(locald.JnW)) {
        localArrayList.add(locald.JnW);
      }
    }
    AppMethodBeat.o(142199);
    return localArrayList;
  }
  
  public Set<String> getTagSet()
  {
    AppMethodBeat.i(142198);
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.tSj.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!bt.isNullOrNil(locald.JnW)) {
        localTreeSet.add(locald.JnW);
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
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
      AppMethodBeat.o(142209);
      return;
    }
    Iterator localIterator = this.tSj.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.JnW))
      {
        this.tSj.remove(locald);
        removeView(locald.JnX);
        a(locald);
        fzd();
        AppMethodBeat.o(142209);
        return;
      }
    }
    ad.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142209);
  }
  
  public void setCallBack(a parama)
  {
    this.JnG = parama;
  }
  
  public void setEditHint(String paramString)
  {
    AppMethodBeat.i(142192);
    if (this.JnJ != null) {
      this.JnJ.setHint(paramString);
    }
    AppMethodBeat.o(142192);
  }
  
  public void setEditTextColor(int paramInt)
  {
    AppMethodBeat.i(142191);
    if (this.JnJ != null) {
      this.JnJ.setTextColor(paramInt);
    }
    AppMethodBeat.o(142191);
  }
  
  public void setEditTextHit(boolean paramBoolean)
  {
    AppMethodBeat.i(142213);
    if (this.JnJ != null)
    {
      if (paramBoolean)
      {
        this.JnJ.setHint(2131755158);
        AppMethodBeat.o(142213);
        return;
      }
      this.JnJ.setHint("");
    }
    AppMethodBeat.o(142213);
  }
  
  public void setIsAllowEnterCharacter(boolean paramBoolean)
  {
    this.JnK = paramBoolean;
  }
  
  public void setPanelClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public void setTagEditTextBG(int paramInt)
  {
    AppMethodBeat.i(142190);
    this.JnB = paramInt;
    if (this.JnJ != null)
    {
      com.tencent.mm.cc.a.fromDPToPix(getContext(), 6);
      getResources().getDimensionPixelSize(2131165516);
      this.JnJ.setBackgroundResource(this.JnB);
    }
    AppMethodBeat.o(142190);
  }
  
  public void setTagHighlineBG(int paramInt)
  {
    this.JnC = paramInt;
  }
  
  public void setTagNormalBG(int paramInt)
  {
    this.rzG = paramInt;
  }
  
  public void setTagNormalTextColorRes(int paramInt)
  {
    this.rzF = paramInt;
  }
  
  public void setTagSelectedBG(int paramInt)
  {
    this.uRS = paramInt;
  }
  
  public void setTagSelectedTextColorRes(int paramInt)
  {
    this.uRT = paramInt;
  }
  
  public void setTagTipsDrawable(int paramInt)
  {
    this.JnA = paramInt;
  }
  
  public void setTaghighlineTextColorRes(int paramInt)
  {
    this.JnD = paramInt;
  }
  
  public final void xC(boolean paramBoolean)
  {
    AppMethodBeat.i(142197);
    if (paramBoolean == this.Jnw)
    {
      AppMethodBeat.o(142197);
      return;
    }
    this.Jnw = paramBoolean;
    removeView(this.JnI);
    if (this.Jnw)
    {
      addView(this.JnI);
      fzb();
    }
    AppMethodBeat.o(142197);
  }
  
  public static abstract interface a
  {
    public abstract void C(boolean paramBoolean, int paramInt);
    
    public abstract void acc(String paramString);
    
    public abstract void acd(String paramString);
    
    public abstract void ace(String paramString);
    
    public abstract void acf(String paramString);
    
    public abstract void acg(String paramString);
    
    public abstract void ciS();
  }
  
  public final class b
    implements InputFilter
  {
    List<String> JnP;
    int mark;
    
    public b()
    {
      AppMethodBeat.i(142183);
      this.JnP = new LinkedList();
      AppMethodBeat.o(142183);
    }
    
    public final CharSequence filter(final CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142184);
      ad.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(MMTagPanel.i(MMTagPanel.this)) });
      this.mark = -1;
      this.JnP.clear();
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
              MMTagPanel.e(MMTagPanel.this).acg(paramCharSequence.toString());
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
          this.JnP.add((paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, i)).trim());
        }
        for (;;)
        {
          this.mark = (i + 1);
          i += 1;
          break;
          label385:
          this.JnP.add(paramCharSequence.subSequence(this.mark, i).toString().trim());
        }
      }
      if (MMTagPanel.h(MMTagPanel.this))
      {
        paramInt1 = f.aXj(paramSpanned.toString());
        if ((MMTagPanel.i(MMTagPanel.this)) && (paramCharSequence.equals("\n")) && (36 < paramInt1)) {
          this.JnP.clear();
        }
      }
      if (this.JnP.isEmpty())
      {
        AppMethodBeat.o(142184);
        return null;
      }
      if (MMTagPanel.e(MMTagPanel.this) != null)
      {
        localObject = this.JnP.iterator();
        while (((Iterator)localObject).hasNext())
        {
          final String str = (String)((Iterator)localObject).next();
          if (str.length() > 0) {
            MMTagPanel.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142181);
                MMTagPanel.e(MMTagPanel.this).acg(str.trim());
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
    int JnS = 36;
    private int JnT = 256;
    private int JnU;
    
    public c() {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142186);
      paramInt1 = f.aXj(paramSpanned.toString()) + f.aXj(paramCharSequence.toString());
      if (paramInt4 > paramInt3) {
        if (paramInt1 - (paramInt4 - paramInt3) > this.JnS)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.JnU = (paramInt1 - (paramInt4 - paramInt3) - this.JnS);
        }
      }
      for (;;)
      {
        if ((MMTagPanel.h(MMTagPanel.this)) && (1 == this.JnU) && (paramCharSequence.equals("\n"))) {
          this.JnU = 0;
        }
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142185);
              MMTagPanel.e(MMTagPanel.this).C(MMTagPanel.i(MMTagPanel.this), f.cU(MMTagPanel.c.a(MMTagPanel.c.this), ""));
              AppMethodBeat.o(142185);
            }
          });
        }
        if (paramInt1 <= this.JnT) {
          break;
        }
        AppMethodBeat.o(142186);
        return "";
        MMTagPanel.a(MMTagPanel.this, false);
        continue;
        if (paramInt1 > this.JnS)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.JnU = (paramInt1 - this.JnS);
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
    public String JnW;
    public TextView JnX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel
 * JD-Core Version:    0.7.0.1
 */