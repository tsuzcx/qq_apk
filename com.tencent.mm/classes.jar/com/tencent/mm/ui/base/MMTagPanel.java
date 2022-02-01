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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public boolean OTd;
  private boolean OTe;
  public boolean OTf;
  public boolean OTg;
  public boolean OTh;
  private int OTi;
  private int OTj;
  private int OTk;
  private int OTl;
  private d OTm;
  private LinkedList<d> OTn;
  private a OTo;
  private int OTp;
  private View OTq;
  MMEditText OTr;
  private boolean OTs;
  private View.OnClickListener OTt;
  public boolean mClickable;
  private boolean tfY;
  private int thx;
  private int thy;
  private LinkedList<d> xuO;
  private int ywe;
  private int ywf;
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142188);
    this.tfY = false;
    this.OTd = true;
    this.OTe = false;
    this.OTf = true;
    this.OTg = false;
    this.OTh = false;
    this.OTi = 2131235167;
    this.OTj = 0;
    this.thy = 2131235181;
    this.thx = 2131100904;
    this.ywe = 2131235171;
    this.ywf = 2131101414;
    this.OTk = 2131235174;
    this.OTl = 2131101427;
    this.OTm = null;
    this.xuO = new LinkedList();
    this.OTn = new LinkedList();
    this.OTs = false;
    this.OTt = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.e(MMTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.e(MMTagPanel.this).anc(((TextView)paramAnonymousView).getText().toString());
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
                  MMTagPanel.e(MMTagPanel.this).anb(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142177);
                }
              });
            }
          }
          else if (MMTagPanel.d(MMTagPanel.this) == null)
          {
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).OTG, false, true);
            }
          }
          else if (MMTagPanel.d(MMTagPanel.this).OTG == paramAnonymousView)
          {
            MMTagPanel.a(MMTagPanel.this, null);
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142178);
                  MMTagPanel.e(MMTagPanel.this).anb(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142178);
                }
              });
            }
          }
          else
          {
            MMTagPanel.this.gLg();
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).OTG, false, true);
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
    this.tfY = false;
    this.OTd = true;
    this.OTe = false;
    this.OTf = true;
    this.OTg = false;
    this.OTh = false;
    this.OTi = 2131235167;
    this.OTj = 0;
    this.thy = 2131235181;
    this.thx = 2131100904;
    this.ywe = 2131235171;
    this.ywf = 2131101414;
    this.OTk = 2131235174;
    this.OTl = 2131101427;
    this.OTm = null;
    this.xuO = new LinkedList();
    this.OTn = new LinkedList();
    this.OTs = false;
    this.OTt = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.e(MMTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.e(MMTagPanel.this).anc(((TextView)paramAnonymousView).getText().toString());
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
                  MMTagPanel.e(MMTagPanel.this).anb(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142177);
                }
              });
            }
          }
          else if (MMTagPanel.d(MMTagPanel.this) == null)
          {
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).OTG, false, true);
            }
          }
          else if (MMTagPanel.d(MMTagPanel.this).OTG == paramAnonymousView)
          {
            MMTagPanel.a(MMTagPanel.this, null);
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142178);
                  MMTagPanel.e(MMTagPanel.this).anb(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142178);
                }
              });
            }
          }
          else
          {
            MMTagPanel.this.gLg();
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).OTG, false, true);
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
    paramd.OTG.setOnClickListener(null);
    if (this.OTn.size() >= 16)
    {
      AppMethodBeat.o(142204);
      return;
    }
    this.OTn.add(paramd);
    AppMethodBeat.o(142204);
  }
  
  private void init()
  {
    AppMethodBeat.i(142189);
    this.OTp = getContext().getResources().getDimensionPixelSize(2131165482);
    this.OTq = LayoutInflater.from(getContext()).inflate(2131495646, null);
    this.OTr = ((MMEditText)this.OTq.findViewById(2131299910));
    this.OTr.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142169);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (67 == paramAnonymousInt))
        {
          Log.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", new Object[] { Integer.valueOf(MMTagPanel.a(MMTagPanel.this).getSelectionStart()), Integer.valueOf(MMTagPanel.a(MMTagPanel.this).getSelectionEnd()) });
          if ((MMTagPanel.a(MMTagPanel.this).getSelectionStart() == 0) && (MMTagPanel.a(MMTagPanel.this).getSelectionStart() == MMTagPanel.a(MMTagPanel.this).getSelectionEnd())) {}
          for (paramAnonymousInt = 1; paramAnonymousInt == 0; paramAnonymousInt = 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(142169);
            return false;
          }
          MMTagPanel.this.cWT();
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
          MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).OTG, false, true);
          MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(142169);
          return false;
          label313:
          if ((MMTagPanel.d(MMTagPanel.this) != null) && (MMTagPanel.b(MMTagPanel.this) != null) && (MMTagPanel.b(MMTagPanel.this).getLast() != null) && (!Util.isNullOrNil(MMTagPanel.d(MMTagPanel.this).OTF)) && (!Util.isNullOrNil(((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).OTF)) && (!MMTagPanel.d(MMTagPanel.this).OTF.equals(((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).OTF)))
          {
            Log.i("MicroMsg.MMTagPanel", "change hight");
            MMTagPanel.this.gLg();
            MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast());
            MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).OTG, false, true);
            MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
          }
          else
          {
            paramAnonymousView = ((MMTagPanel.d)MMTagPanel.b(MMTagPanel.this).getLast()).OTF;
            MMTagPanel.this.removeTag(paramAnonymousView);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              MMTagPanel.e(MMTagPanel.this).and(paramAnonymousView);
            }
            MMTagPanel.this.gLg();
          }
        }
      }
    });
    this.OTr.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(142170);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.e(MMTagPanel.this).ane(paramAnonymousEditable);
        }
        if (paramAnonymousEditable.length() > 0) {
          MMTagPanel.this.gLg();
        }
        AppMethodBeat.o(142170);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.OTr.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142171);
        Log.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousBoolean) && (MMTagPanel.e(MMTagPanel.this) != null)) {
          MMTagPanel.e(MMTagPanel.this).cIk();
        }
        AppMethodBeat.o(142171);
      }
    });
    this.OTr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142172);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d("MicroMsg.MMTagPanel", "on edittext click");
        MMTagPanel.this.gLg();
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.e(MMTagPanel.this).cIk();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142172);
      }
    });
    this.OTr.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142173);
        Log.d("MicroMsg.MMTagPanel", "on action %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousKeyEvent });
        AppMethodBeat.o(142173);
        return false;
      }
    });
    final c localc = new c();
    b localb = new b();
    this.OTr.setFilters(new InputFilter[] { localc, localb });
    gLe();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142174);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMTagPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[] { Boolean.valueOf(MMTagPanel.f(MMTagPanel.this)) });
        if (MMTagPanel.f(MMTagPanel.this))
        {
          MMTagPanel.this.gLg();
          MMTagPanel.a(MMTagPanel.this).requestFocus();
          MMTagPanel.a(MMTagPanel.this).setSelection(MMTagPanel.a(MMTagPanel.this).getText().length());
          ((InputMethodManager)MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(MMTagPanel.this), 0);
          Log.d("MicroMsg.MMTagPanel", "on content click");
          if (MMTagPanel.e(MMTagPanel.this) != null) {
            MMTagPanel.e(MMTagPanel.this).cIk();
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
        if (MMTagPanel.g(MMTagPanel.this))
        {
          paramAnonymousMotionEvent = MMTagPanel.this.getEditText();
          if (!Util.isNullOrNil(paramAnonymousMotionEvent))
          {
            paramAnonymousView = paramAnonymousMotionEvent;
            if (localc != null)
            {
              paramAnonymousView = paramAnonymousMotionEvent;
              if (f.bnP(paramAnonymousMotionEvent) > localc.OTB)
              {
                int i = localc.OTB - f.bnR(paramAnonymousMotionEvent);
                paramAnonymousView = paramAnonymousMotionEvent;
                if (i < paramAnonymousMotionEvent.length()) {
                  paramAnonymousView = paramAnonymousMotionEvent.substring(0, i);
                }
              }
            }
            MMTagPanel.this.dm(paramAnonymousView, true);
            if (MMTagPanel.e(MMTagPanel.this) != null) {
              MMTagPanel.e(MMTagPanel.this).anf(paramAnonymousView);
            }
            MMTagPanel.this.gLc();
          }
        }
        AppMethodBeat.o(142175);
        return false;
      }
    });
    AppMethodBeat.o(142189);
  }
  
  public final void Bz(boolean paramBoolean)
  {
    AppMethodBeat.i(142197);
    if (paramBoolean == this.OTe)
    {
      AppMethodBeat.o(142197);
      return;
    }
    this.OTe = paramBoolean;
    removeView(this.OTq);
    if (this.OTe)
    {
      addView(this.OTq);
      gLe();
    }
    AppMethodBeat.o(142197);
  }
  
  public final void a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(142207);
    paramTextView.setTextSize(0, getContext().getResources().getDimension(2131165482) * com.tencent.mm.cb.a.ez(getContext()));
    if (paramBoolean2)
    {
      paramTextView.setBackgroundResource(this.OTk);
      paramTextView.setTextColor(getResources().getColor(this.OTl));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.OTi, 0);
      AppMethodBeat.o(142207);
      return;
    }
    if (paramBoolean1)
    {
      paramTextView.setTag(Integer.valueOf(1));
      paramTextView.setBackgroundResource(this.ywe);
      paramTextView.setTextColor(getResources().getColor(this.ywf));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      AppMethodBeat.o(142207);
      return;
    }
    paramTextView.setTag(Integer.valueOf(0));
    paramTextView.setBackgroundResource(this.thy);
    paramTextView.setTextColor(getResources().getColor(this.thx));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(142207);
  }
  
  protected final void a(d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142205);
    paramd.OTF = paramString;
    paramd.OTG.setText(com.tencent.mm.ui.g.c.b.a(getContext(), paramString, this.OTp));
    TextView localTextView = paramd.OTG;
    if (this.OTd) {}
    for (paramString = this.OTt;; paramString = null)
    {
      localTextView.setOnClickListener(paramString);
      a(paramd.OTG, paramBoolean, false);
      AppMethodBeat.o(142205);
      return;
    }
  }
  
  public final void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(142202);
    gKV();
    if (this.OTe) {
      addView(this.OTq);
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
        dm(str, bool);
        break;
      }
    }
    AppMethodBeat.o(142202);
  }
  
  protected void cWT() {}
  
  public final void dm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142208);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
      AppMethodBeat.o(142208);
      return;
    }
    paramString = paramString.trim();
    Log.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", new Object[] { paramString });
    removeTag(paramString);
    Object localObject = this.xuO.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((d)((Iterator)localObject).next()).OTF))
      {
        Log.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(142208);
        return;
      }
    }
    localObject = gLf();
    a((d)localObject, paramString, paramBoolean);
    this.xuO.add(localObject);
    if (this.OTe) {
      addView(((d)localObject).OTG, getChildCount() - 1);
    }
    for (;;)
    {
      gLg();
      AppMethodBeat.o(142208);
      return;
      addView(((d)localObject).OTG);
    }
  }
  
  public final void dn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142211);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
      AppMethodBeat.o(142211);
      return;
    }
    Iterator localIterator = this.xuO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.OTF))
      {
        a(locald, paramString, paramBoolean);
        gLg();
        AppMethodBeat.o(142211);
        return;
      }
    }
    Log.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142211);
  }
  
  public void gKV()
  {
    AppMethodBeat.i(142201);
    this.xuO.clear();
    removeAllViews();
    Iterator localIterator = this.xuO.iterator();
    while (localIterator.hasNext()) {
      a((d)localIterator.next());
    }
    AppMethodBeat.o(142201);
  }
  
  public final void gLc()
  {
    AppMethodBeat.i(142194);
    if (this.OTr != null) {
      this.OTr.setText("");
    }
    AppMethodBeat.o(142194);
  }
  
  public final void gLd()
  {
    AppMethodBeat.i(142195);
    if ((this.OTr == null) || (this.OTr.isFocused()))
    {
      AppMethodBeat.o(142195);
      return;
    }
    this.OTr.requestFocus();
    AppMethodBeat.o(142195);
  }
  
  public final void gLe()
  {
    AppMethodBeat.i(142196);
    if ((this.OTr != null) && (this.OTr.isFocused()))
    {
      Log.d("MicroMsg.MMTagPanel", "do clear edit focus");
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      IBinder localIBinder = this.OTr.getWindowToken();
      if (localIBinder == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
      this.OTr.clearFocus();
    }
    AppMethodBeat.o(142196);
  }
  
  protected final d gLf()
  {
    AppMethodBeat.i(142203);
    if (!this.OTn.isEmpty())
    {
      localObject = (d)this.OTn.removeFirst();
      AppMethodBeat.o(142203);
      return localObject;
    }
    d locald = new d();
    TextView localTextView = new TextView(getContext());
    localTextView.setBackgroundResource(this.thy);
    localTextView.setTextColor(getResources().getColor(this.thx));
    localTextView.setTag(Integer.valueOf(0));
    localTextView.setGravity(17);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.OTi, 0);
    if (this.OTd) {}
    for (Object localObject = this.OTt;; localObject = null)
    {
      localTextView.setOnClickListener((View.OnClickListener)localObject);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine();
      locald.OTG = localTextView;
      AppMethodBeat.o(142203);
      return locald;
    }
  }
  
  protected final void gLg()
  {
    AppMethodBeat.i(142206);
    if (this.OTr != null)
    {
      Log.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[] { Boolean.valueOf(this.OTr.isFocused()) });
      this.OTr.setCursorVisible(true);
    }
    if (this.OTm == null)
    {
      AppMethodBeat.o(142206);
      return;
    }
    TextView localTextView = this.OTm.OTG;
    if (((Integer)this.OTm.OTG.getTag()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      this.OTm = null;
      AppMethodBeat.o(142206);
      return;
    }
  }
  
  public final void gLh()
  {
    AppMethodBeat.i(142210);
    Iterator localIterator = this.xuO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      removeView(locald.OTG);
      a(locald);
    }
    this.xuO.clear();
    gLg();
    AppMethodBeat.o(142210);
  }
  
  public String getEditText()
  {
    AppMethodBeat.i(142193);
    if (this.OTr != null)
    {
      String str = this.OTr.getText().toString();
      AppMethodBeat.o(142193);
      return str;
    }
    AppMethodBeat.o(142193);
    return "";
  }
  
  public int getTagCount()
  {
    AppMethodBeat.i(142200);
    int i = this.xuO.size();
    AppMethodBeat.o(142200);
    return i;
  }
  
  public ArrayList<String> getTagList()
  {
    AppMethodBeat.i(142199);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.xuO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!Util.isNullOrNil(locald.OTF)) {
        localArrayList.add(locald.OTF);
      }
    }
    AppMethodBeat.o(142199);
    return localArrayList;
  }
  
  public Set<String> getTagSet()
  {
    AppMethodBeat.i(142198);
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.xuO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!Util.isNullOrNil(locald.OTF)) {
        localTreeSet.add(locald.OTF);
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
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
      AppMethodBeat.o(142209);
      return;
    }
    Iterator localIterator = this.xuO.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.OTF))
      {
        this.xuO.remove(locald);
        removeView(locald.OTG);
        a(locald);
        gLg();
        AppMethodBeat.o(142209);
        return;
      }
    }
    Log.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142209);
  }
  
  public void setCallBack(a parama)
  {
    this.OTo = parama;
  }
  
  public void setEditHint(String paramString)
  {
    AppMethodBeat.i(142192);
    if (this.OTr != null) {
      this.OTr.setHint(paramString);
    }
    AppMethodBeat.o(142192);
  }
  
  public void setEditTextColor(int paramInt)
  {
    AppMethodBeat.i(142191);
    if (this.OTr != null) {
      this.OTr.setTextColor(paramInt);
    }
    AppMethodBeat.o(142191);
  }
  
  public void setEditTextHit(boolean paramBoolean)
  {
    AppMethodBeat.i(142213);
    if (this.OTr != null)
    {
      if (paramBoolean)
      {
        this.OTr.setHint(2131755176);
        AppMethodBeat.o(142213);
        return;
      }
      this.OTr.setHint("");
    }
    AppMethodBeat.o(142213);
  }
  
  public void setIsAllowEnterCharacter(boolean paramBoolean)
  {
    this.OTs = paramBoolean;
  }
  
  public void setPanelClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public void setTagEditTextBG(int paramInt)
  {
    AppMethodBeat.i(142190);
    this.OTj = paramInt;
    if (this.OTr != null)
    {
      com.tencent.mm.cb.a.fromDPToPix(getContext(), 6);
      getResources().getDimensionPixelSize(2131165534);
      this.OTr.setBackgroundResource(this.OTj);
    }
    AppMethodBeat.o(142190);
  }
  
  public void setTagHighlineBG(int paramInt)
  {
    this.OTk = paramInt;
  }
  
  public void setTagNormalBG(int paramInt)
  {
    this.thy = paramInt;
  }
  
  public void setTagNormalTextColorRes(int paramInt)
  {
    this.thx = paramInt;
  }
  
  public void setTagSelectedBG(int paramInt)
  {
    this.ywe = paramInt;
  }
  
  public void setTagSelectedTextColorRes(int paramInt)
  {
    this.ywf = paramInt;
  }
  
  public void setTagTipsDrawable(int paramInt)
  {
    this.OTi = paramInt;
  }
  
  public void setTaghighlineTextColorRes(int paramInt)
  {
    this.OTl = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void E(boolean paramBoolean, int paramInt);
    
    public abstract void anb(String paramString);
    
    public abstract void anc(String paramString);
    
    public abstract void and(String paramString);
    
    public abstract void ane(String paramString);
    
    public abstract void anf(String paramString);
    
    public abstract void cIk();
  }
  
  public final class b
    implements InputFilter
  {
    List<String> OTx;
    int mark;
    
    public b()
    {
      AppMethodBeat.i(142183);
      this.OTx = new LinkedList();
      AppMethodBeat.o(142183);
    }
    
    public final CharSequence filter(final CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142184);
      Log.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(MMTagPanel.i(MMTagPanel.this)) });
      this.mark = -1;
      this.OTx.clear();
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
              MMTagPanel.e(MMTagPanel.this).anf(paramCharSequence.toString());
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
          this.OTx.add((paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, i)).trim());
        }
        for (;;)
        {
          this.mark = (i + 1);
          i += 1;
          break;
          label385:
          this.OTx.add(paramCharSequence.subSequence(this.mark, i).toString().trim());
        }
      }
      if (MMTagPanel.h(MMTagPanel.this))
      {
        paramInt1 = f.bnP(paramSpanned.toString());
        if ((MMTagPanel.i(MMTagPanel.this)) && (paramCharSequence.equals("\n")) && (36 < paramInt1)) {
          this.OTx.clear();
        }
      }
      if (this.OTx.isEmpty())
      {
        AppMethodBeat.o(142184);
        return null;
      }
      if (MMTagPanel.e(MMTagPanel.this) != null)
      {
        localObject = this.OTx.iterator();
        while (((Iterator)localObject).hasNext())
        {
          final String str = (String)((Iterator)localObject).next();
          if (str.length() > 0) {
            MMTagPanel.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142181);
                MMTagPanel.e(MMTagPanel.this).anf(str.trim());
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
    int OTB = 36;
    private int OTC = 256;
    private int OTD;
    
    public c() {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142186);
      paramInt1 = f.bnP(paramSpanned.toString()) + f.bnP(paramCharSequence.toString());
      if (paramInt4 > paramInt3) {
        if (paramInt1 - (paramInt4 - paramInt3) > this.OTB)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.OTD = (paramInt1 - (paramInt4 - paramInt3) - this.OTB);
        }
      }
      for (;;)
      {
        if ((MMTagPanel.h(MMTagPanel.this)) && (1 == this.OTD) && (paramCharSequence.equals("\n"))) {
          this.OTD = 0;
        }
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142185);
              MMTagPanel.e(MMTagPanel.this).E(MMTagPanel.i(MMTagPanel.this), f.dp(MMTagPanel.c.a(MMTagPanel.c.this), ""));
              AppMethodBeat.o(142185);
            }
          });
        }
        if (paramInt1 <= this.OTC) {
          break;
        }
        AppMethodBeat.o(142186);
        return "";
        MMTagPanel.a(MMTagPanel.this, false);
        continue;
        if (paramInt1 > this.OTB)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.OTD = (paramInt1 - this.OTB);
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
    public String OTF;
    public TextView OTG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel
 * JD-Core Version:    0.7.0.1
 */