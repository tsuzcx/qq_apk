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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public boolean FZQ;
  private boolean FZR;
  public boolean FZS;
  public boolean FZT;
  public boolean FZU;
  private int FZV;
  private int FZW;
  private int FZX;
  private int FZY;
  private d FZZ;
  private LinkedList<d> Gaa;
  private a Gab;
  private int Gac;
  private View Gad;
  MMEditText Gae;
  private boolean Gaf;
  private View.OnClickListener Gag;
  public boolean mClickable;
  private boolean qfG;
  private int qhe;
  private int qhf;
  private LinkedList<d> rNO;
  private int sHy;
  private int sHz;
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142188);
    this.qfG = false;
    this.FZQ = true;
    this.FZR = false;
    this.FZS = true;
    this.FZT = false;
    this.FZU = false;
    this.FZV = 2131234288;
    this.FZW = 0;
    this.qhf = 2131234298;
    this.qhe = 2131100711;
    this.sHy = 2131234292;
    this.sHz = 2131101171;
    this.FZX = 2131234295;
    this.FZY = 2131101182;
    this.FZZ = null;
    this.rNO = new LinkedList();
    this.Gaa = new LinkedList();
    this.Gaf = false;
    this.Gag = new View.OnClickListener()
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
                MMTagPanel.e(MMTagPanel.this).Ul(((TextView)paramAnonymousView).getText().toString());
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
                MMTagPanel.e(MMTagPanel.this).Uk(((TextView)paramAnonymousView).getText().toString());
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
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).Gas, false, true);
            AppMethodBeat.o(142179);
          }
        }
        else if (MMTagPanel.d(MMTagPanel.this).Gas == paramAnonymousView)
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
                MMTagPanel.e(MMTagPanel.this).Uk(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142178);
              }
            });
            AppMethodBeat.o(142179);
          }
        }
        else
        {
          MMTagPanel.this.eTe();
          MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).Gas, false, true);
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
    this.qfG = false;
    this.FZQ = true;
    this.FZR = false;
    this.FZS = true;
    this.FZT = false;
    this.FZU = false;
    this.FZV = 2131234288;
    this.FZW = 0;
    this.qhf = 2131234298;
    this.qhe = 2131100711;
    this.sHy = 2131234292;
    this.sHz = 2131101171;
    this.FZX = 2131234295;
    this.FZY = 2131101182;
    this.FZZ = null;
    this.rNO = new LinkedList();
    this.Gaa = new LinkedList();
    this.Gaf = false;
    this.Gag = new View.OnClickListener()
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
                MMTagPanel.e(MMTagPanel.this).Ul(((TextView)paramAnonymousView).getText().toString());
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
                MMTagPanel.e(MMTagPanel.this).Uk(((TextView)paramAnonymousView).getText().toString());
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
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).Gas, false, true);
            AppMethodBeat.o(142179);
          }
        }
        else if (MMTagPanel.d(MMTagPanel.this).Gas == paramAnonymousView)
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
                MMTagPanel.e(MMTagPanel.this).Uk(((TextView)paramAnonymousView).getText().toString());
                AppMethodBeat.o(142178);
              }
            });
            AppMethodBeat.o(142179);
          }
        }
        else
        {
          MMTagPanel.this.eTe();
          MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).Gas, false, true);
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
    paramd.Gas.setOnClickListener(null);
    if (this.Gaa.size() >= 16)
    {
      AppMethodBeat.o(142204);
      return;
    }
    this.Gaa.add(paramd);
    AppMethodBeat.o(142204);
  }
  
  private void init()
  {
    AppMethodBeat.i(142189);
    this.Gac = getContext().getResources().getDimensionPixelSize(2131165466);
    this.Gad = LayoutInflater.from(getContext()).inflate(2131494907, null);
    this.Gae = ((MMEditText)this.Gad.findViewById(2131299306));
    this.Gae.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142169);
        if ((paramAnonymousKeyEvent.getAction() == 0) && (67 == paramAnonymousInt))
        {
          ad.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", new Object[] { Integer.valueOf(MMTagPanel.a(MMTagPanel.this).getSelectionStart()), Integer.valueOf(MMTagPanel.a(MMTagPanel.this).getSelectionEnd()) });
          if ((MMTagPanel.a(MMTagPanel.this).getSelectionStart() == 0) && (MMTagPanel.a(MMTagPanel.this).getSelectionStart() == MMTagPanel.a(MMTagPanel.this).getSelectionEnd())) {}
          for (paramAnonymousInt = 1; paramAnonymousInt == 0; paramAnonymousInt = 0)
          {
            AppMethodBeat.o(142169);
            return false;
          }
          MMTagPanel.this.cjW();
          if ((MMTagPanel.b(MMTagPanel.this) == null) || (MMTagPanel.b(MMTagPanel.this).isEmpty()))
          {
            AppMethodBeat.o(142169);
            return false;
          }
          if ((MMTagPanel.c(MMTagPanel.this)) || (MMTagPanel.d(MMTagPanel.this) != null)) {
            break label230;
          }
          MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast());
          MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).Gas, false, true);
          MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
        }
        for (;;)
        {
          AppMethodBeat.o(142169);
          return false;
          label230:
          if ((MMTagPanel.d(MMTagPanel.this) != null) && (MMTagPanel.b(MMTagPanel.this) != null) && (MMTagPanel.b(MMTagPanel.this).getLast() != null) && (!bt.isNullOrNil(MMTagPanel.d(MMTagPanel.this).Gar)) && (!bt.isNullOrNil(((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).Gar)) && (!MMTagPanel.d(MMTagPanel.this).Gar.equals(((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).Gar)))
          {
            ad.i("MicroMsg.MMTagPanel", "change hight");
            MMTagPanel.this.eTe();
            MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast());
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).Gas, false, true);
            MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
          }
          else
          {
            paramAnonymousView = ((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).Gar;
            MMTagPanel.this.removeTag(paramAnonymousView);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              MMTagPanel.e(MMTagPanel.this).Um(paramAnonymousView);
            }
            MMTagPanel.this.eTe();
          }
        }
      }
    });
    this.Gae.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(142170);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.e(MMTagPanel.this).Un(paramAnonymousEditable);
        }
        if (paramAnonymousEditable.length() > 0) {
          MMTagPanel.this.eTe();
        }
        AppMethodBeat.o(142170);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Gae.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142171);
        ad.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousBoolean) && (MMTagPanel.e(MMTagPanel.this) != null)) {
          MMTagPanel.e(MMTagPanel.this).bXc();
        }
        AppMethodBeat.o(142171);
      }
    });
    this.Gae.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142172);
        ad.d("MicroMsg.MMTagPanel", "on edittext click");
        MMTagPanel.this.eTe();
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.e(MMTagPanel.this).bXc();
        }
        AppMethodBeat.o(142172);
      }
    });
    this.Gae.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.Gae.setFilters(new InputFilter[] { localc, localb });
    eTc();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142174);
        ad.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[] { Boolean.valueOf(MMTagPanel.f(MMTagPanel.this)) });
        if (MMTagPanel.f(MMTagPanel.this))
        {
          MMTagPanel.this.eTe();
          MMTagPanel.a(MMTagPanel.this).requestFocus();
          MMTagPanel.a(MMTagPanel.this).setSelection(MMTagPanel.a(MMTagPanel.this).getText().length());
          ((InputMethodManager)MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(MMTagPanel.this), 0);
          ad.d("MicroMsg.MMTagPanel", "on content click");
          if (MMTagPanel.e(MMTagPanel.this) != null) {
            MMTagPanel.e(MMTagPanel.this).bXc();
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
          if (!bt.isNullOrNil(paramAnonymousMotionEvent))
          {
            paramAnonymousView = paramAnonymousMotionEvent;
            if (localc != null)
            {
              paramAnonymousView = paramAnonymousMotionEvent;
              if (f.aLJ(paramAnonymousMotionEvent) > localc.Gan)
              {
                int i = localc.Gan - f.aLL(paramAnonymousMotionEvent);
                paramAnonymousView = paramAnonymousMotionEvent;
                if (i < paramAnonymousMotionEvent.length()) {
                  paramAnonymousView = paramAnonymousMotionEvent.substring(0, i);
                }
              }
            }
            MMTagPanel.this.cC(paramAnonymousView, true);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              MMTagPanel.e(MMTagPanel.this).Uo(paramAnonymousView);
            }
            MMTagPanel.this.eTa();
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
    paramTextView.setTextSize(0, getContext().getResources().getDimension(2131165466) * a.dT(getContext()));
    if (paramBoolean2)
    {
      paramTextView.setBackgroundResource(this.FZX);
      paramTextView.setTextColor(getResources().getColor(this.FZY));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.FZV, 0);
      AppMethodBeat.o(142207);
      return;
    }
    if (paramBoolean1)
    {
      paramTextView.setTag(Integer.valueOf(1));
      paramTextView.setBackgroundResource(this.sHy);
      paramTextView.setTextColor(getResources().getColor(this.sHz));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      AppMethodBeat.o(142207);
      return;
    }
    paramTextView.setTag(Integer.valueOf(0));
    paramTextView.setBackgroundResource(this.qhf);
    paramTextView.setTextColor(getResources().getColor(this.qhe));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(142207);
  }
  
  protected final void a(d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142205);
    paramd.Gar = paramString;
    paramd.Gas.setText(b.g(getContext(), paramString, this.Gac));
    TextView localTextView = paramd.Gas;
    if (this.FZQ) {}
    for (paramString = this.Gag;; paramString = null)
    {
      localTextView.setOnClickListener(paramString);
      a(paramd.Gas, paramBoolean, false);
      AppMethodBeat.o(142205);
      return;
    }
  }
  
  public final void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(142202);
    eST();
    if (this.FZR) {
      addView(this.Gad);
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
        cC(str, bool);
        break;
      }
    }
    AppMethodBeat.o(142202);
  }
  
  public final void cC(String paramString, boolean paramBoolean)
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
    Object localObject = this.rNO.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((d)((Iterator)localObject).next()).Gar))
      {
        ad.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(142208);
        return;
      }
    }
    localObject = eTd();
    a((d)localObject, paramString, paramBoolean);
    this.rNO.add(localObject);
    if (this.FZR) {
      addView(((d)localObject).Gas, getChildCount() - 1);
    }
    for (;;)
    {
      eTe();
      AppMethodBeat.o(142208);
      return;
      addView(((d)localObject).Gas);
    }
  }
  
  public final void cD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142211);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
      AppMethodBeat.o(142211);
      return;
    }
    Iterator localIterator = this.rNO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.Gar))
      {
        a(locald, paramString, paramBoolean);
        eTe();
        AppMethodBeat.o(142211);
        return;
      }
    }
    ad.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142211);
  }
  
  protected void cjW() {}
  
  public void eST()
  {
    AppMethodBeat.i(142201);
    this.rNO.clear();
    removeAllViews();
    Iterator localIterator = this.rNO.iterator();
    while (localIterator.hasNext()) {
      a((d)localIterator.next());
    }
    AppMethodBeat.o(142201);
  }
  
  public final void eTa()
  {
    AppMethodBeat.i(142194);
    if (this.Gae != null) {
      this.Gae.setText("");
    }
    AppMethodBeat.o(142194);
  }
  
  public final void eTb()
  {
    AppMethodBeat.i(142195);
    if ((this.Gae == null) || (this.Gae.isFocused()))
    {
      AppMethodBeat.o(142195);
      return;
    }
    this.Gae.requestFocus();
    AppMethodBeat.o(142195);
  }
  
  public final void eTc()
  {
    AppMethodBeat.i(142196);
    if ((this.Gae != null) && (this.Gae.isFocused()))
    {
      ad.d("MicroMsg.MMTagPanel", "do clear edit focus");
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      IBinder localIBinder = this.Gae.getWindowToken();
      if (localIBinder == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
      this.Gae.clearFocus();
    }
    AppMethodBeat.o(142196);
  }
  
  protected final d eTd()
  {
    AppMethodBeat.i(142203);
    if (!this.Gaa.isEmpty())
    {
      localObject = (d)this.Gaa.removeFirst();
      AppMethodBeat.o(142203);
      return localObject;
    }
    d locald = new d();
    TextView localTextView = new TextView(getContext());
    localTextView.setBackgroundResource(this.qhf);
    localTextView.setTextColor(getResources().getColor(this.qhe));
    localTextView.setTag(Integer.valueOf(0));
    localTextView.setGravity(17);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.FZV, 0);
    if (this.FZQ) {}
    for (Object localObject = this.Gag;; localObject = null)
    {
      localTextView.setOnClickListener((View.OnClickListener)localObject);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine();
      locald.Gas = localTextView;
      AppMethodBeat.o(142203);
      return locald;
    }
  }
  
  protected final void eTe()
  {
    AppMethodBeat.i(142206);
    if (this.Gae != null)
    {
      ad.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[] { Boolean.valueOf(this.Gae.isFocused()) });
      this.Gae.setCursorVisible(true);
    }
    if (this.FZZ == null)
    {
      AppMethodBeat.o(142206);
      return;
    }
    TextView localTextView = this.FZZ.Gas;
    if (((Integer)this.FZZ.Gas.getTag()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      this.FZZ = null;
      AppMethodBeat.o(142206);
      return;
    }
  }
  
  public final void eTf()
  {
    AppMethodBeat.i(142210);
    Iterator localIterator = this.rNO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      removeView(locald.Gas);
      a(locald);
    }
    this.rNO.clear();
    eTe();
    AppMethodBeat.o(142210);
  }
  
  public String getEditText()
  {
    AppMethodBeat.i(142193);
    if (this.Gae != null)
    {
      String str = this.Gae.getText().toString();
      AppMethodBeat.o(142193);
      return str;
    }
    AppMethodBeat.o(142193);
    return "";
  }
  
  public int getTagCount()
  {
    AppMethodBeat.i(142200);
    int i = this.rNO.size();
    AppMethodBeat.o(142200);
    return i;
  }
  
  public ArrayList<String> getTagList()
  {
    AppMethodBeat.i(142199);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.rNO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!bt.isNullOrNil(locald.Gar)) {
        localArrayList.add(locald.Gar);
      }
    }
    AppMethodBeat.o(142199);
    return localArrayList;
  }
  
  public Set<String> getTagSet()
  {
    AppMethodBeat.i(142198);
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.rNO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!bt.isNullOrNil(locald.Gar)) {
        localTreeSet.add(locald.Gar);
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
    Iterator localIterator = this.rNO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.Gar))
      {
        this.rNO.remove(locald);
        removeView(locald.Gas);
        a(locald);
        eTe();
        AppMethodBeat.o(142209);
        return;
      }
    }
    ad.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142209);
  }
  
  public void setCallBack(a parama)
  {
    this.Gab = parama;
  }
  
  public void setEditHint(String paramString)
  {
    AppMethodBeat.i(142192);
    if (this.Gae != null) {
      this.Gae.setHint(paramString);
    }
    AppMethodBeat.o(142192);
  }
  
  public void setEditTextColor(int paramInt)
  {
    AppMethodBeat.i(142191);
    if (this.Gae != null) {
      this.Gae.setTextColor(paramInt);
    }
    AppMethodBeat.o(142191);
  }
  
  public void setEditTextHit(boolean paramBoolean)
  {
    AppMethodBeat.i(142213);
    if (this.Gae != null)
    {
      if (paramBoolean)
      {
        this.Gae.setHint(2131755158);
        AppMethodBeat.o(142213);
        return;
      }
      this.Gae.setHint("");
    }
    AppMethodBeat.o(142213);
  }
  
  public void setIsAllowEnterCharacter(boolean paramBoolean)
  {
    this.Gaf = paramBoolean;
  }
  
  public void setPanelClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public void setTagEditTextBG(int paramInt)
  {
    AppMethodBeat.i(142190);
    this.FZW = paramInt;
    if (this.Gae != null)
    {
      a.fromDPToPix(getContext(), 6);
      getResources().getDimensionPixelSize(2131165516);
      this.Gae.setBackgroundResource(this.FZW);
    }
    AppMethodBeat.o(142190);
  }
  
  public void setTagHighlineBG(int paramInt)
  {
    this.FZX = paramInt;
  }
  
  public void setTagNormalBG(int paramInt)
  {
    this.qhf = paramInt;
  }
  
  public void setTagNormalTextColorRes(int paramInt)
  {
    this.qhe = paramInt;
  }
  
  public void setTagSelectedBG(int paramInt)
  {
    this.sHy = paramInt;
  }
  
  public void setTagSelectedTextColorRes(int paramInt)
  {
    this.sHz = paramInt;
  }
  
  public void setTagTipsDrawable(int paramInt)
  {
    this.FZV = paramInt;
  }
  
  public void setTaghighlineTextColorRes(int paramInt)
  {
    this.FZY = paramInt;
  }
  
  public final void vN(boolean paramBoolean)
  {
    AppMethodBeat.i(142197);
    if (paramBoolean == this.FZR)
    {
      AppMethodBeat.o(142197);
      return;
    }
    this.FZR = paramBoolean;
    removeView(this.Gad);
    if (this.FZR)
    {
      addView(this.Gad);
      eTc();
    }
    AppMethodBeat.o(142197);
  }
  
  public static abstract interface a
  {
    public abstract void B(boolean paramBoolean, int paramInt);
    
    public abstract void Uk(String paramString);
    
    public abstract void Ul(String paramString);
    
    public abstract void Um(String paramString);
    
    public abstract void Un(String paramString);
    
    public abstract void Uo(String paramString);
    
    public abstract void bXc();
  }
  
  public final class b
    implements InputFilter
  {
    List<String> Gak;
    int mark;
    
    public b()
    {
      AppMethodBeat.i(142183);
      this.Gak = new LinkedList();
      AppMethodBeat.o(142183);
    }
    
    public final CharSequence filter(final CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142184);
      ad.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(MMTagPanel.i(MMTagPanel.this)) });
      this.mark = -1;
      this.Gak.clear();
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
              MMTagPanel.e(MMTagPanel.this).Uo(paramCharSequence.toString());
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
          this.Gak.add((paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, i)).trim());
        }
        for (;;)
        {
          this.mark = (i + 1);
          i += 1;
          break;
          label385:
          this.Gak.add(paramCharSequence.subSequence(this.mark, i).toString().trim());
        }
      }
      if (MMTagPanel.h(MMTagPanel.this))
      {
        paramInt1 = f.aLJ(paramSpanned.toString());
        if ((MMTagPanel.i(MMTagPanel.this)) && (paramCharSequence.equals("\n")) && (36 < paramInt1)) {
          this.Gak.clear();
        }
      }
      if (this.Gak.isEmpty())
      {
        AppMethodBeat.o(142184);
        return null;
      }
      if (MMTagPanel.e(MMTagPanel.this) != null)
      {
        localObject = this.Gak.iterator();
        while (((Iterator)localObject).hasNext())
        {
          final String str = (String)((Iterator)localObject).next();
          if (str.length() > 0) {
            MMTagPanel.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142181);
                MMTagPanel.e(MMTagPanel.this).Uo(str.trim());
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
    int Gan = 36;
    private int Gao = 256;
    private int Gap;
    
    public c() {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142186);
      paramInt1 = f.aLJ(paramSpanned.toString()) + f.aLJ(paramCharSequence.toString());
      if (paramInt4 > paramInt3) {
        if (paramInt1 - (paramInt4 - paramInt3) > this.Gan)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.Gap = (paramInt1 - (paramInt4 - paramInt3) - this.Gan);
        }
      }
      for (;;)
      {
        if ((MMTagPanel.h(MMTagPanel.this)) && (1 == this.Gap) && (paramCharSequence.equals("\n"))) {
          this.Gap = 0;
        }
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142185);
              MMTagPanel.e(MMTagPanel.this).B(MMTagPanel.i(MMTagPanel.this), f.cJ(MMTagPanel.c.a(MMTagPanel.c.this), ""));
              AppMethodBeat.o(142185);
            }
          });
        }
        if (paramInt1 <= this.Gao) {
          break;
        }
        AppMethodBeat.o(142186);
        return "";
        MMTagPanel.a(MMTagPanel.this, false);
        continue;
        if (paramInt1 > this.Gan)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.Gap = (paramInt1 - this.Gan);
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
    public String Gar;
    public TextView Gas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel
 * JD-Core Version:    0.7.0.1
 */