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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.g;
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
  private boolean AiK;
  private int Akr;
  private int Aks;
  protected LinkedList<MMTagPanel.d> Idn;
  private int JNr;
  private int JNs;
  protected boolean adTD;
  protected boolean adTE;
  public boolean adTF;
  public boolean adTG;
  public boolean adTH;
  private int adTI;
  private int adTJ;
  private int adTK;
  private int adTL;
  private MMTagPanel.d adTM;
  private LinkedList<MMTagPanel.d> adTN;
  private a adTO;
  private int adTP;
  protected View adTQ;
  public MMEditText adTR;
  public int adTS;
  private boolean adTT;
  protected View.OnClickListener adTU;
  public boolean mClickable;
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142188);
    this.AiK = false;
    this.adTD = true;
    this.adTE = false;
    this.adTF = true;
    this.adTG = false;
    this.adTH = false;
    this.adTI = a.f.tag_deletetab;
    this.adTJ = 0;
    this.Aks = a.f.tag_white_tab_selector;
    this.Akr = a.d.normal_text_color;
    this.JNr = a.f.tag_green_tab_selector;
    this.JNs = a.d.wechat_green;
    this.adTK = a.f.tag_highlight_tab_selector;
    this.adTL = a.d.white_text_color;
    this.adTM = null;
    this.Idn = new LinkedList();
    this.adTN = new LinkedList();
    this.adTT = false;
    this.adTU = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.d(MMTagPanel.this).aoU(((TextView)paramAnonymousView).getText().toString());
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
          if ((!MMTagPanel.this.adTE) || (MMTagPanel.b(MMTagPanel.this)))
          {
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142177);
                  MMTagPanel.d(MMTagPanel.this).aoT(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142177);
                }
              });
            }
          }
          else if (MMTagPanel.c(MMTagPanel.this) == null)
          {
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.c(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).adUg, false, true);
            }
          }
          else if (MMTagPanel.c(MMTagPanel.this).adUg == paramAnonymousView)
          {
            MMTagPanel.a(MMTagPanel.this, null);
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142178);
                  MMTagPanel.d(MMTagPanel.this).aoT(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142178);
                }
              });
            }
          }
          else
          {
            MMTagPanel.this.jmK();
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.c(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).adUg, false, true);
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
    this.AiK = false;
    this.adTD = true;
    this.adTE = false;
    this.adTF = true;
    this.adTG = false;
    this.adTH = false;
    this.adTI = a.f.tag_deletetab;
    this.adTJ = 0;
    this.Aks = a.f.tag_white_tab_selector;
    this.Akr = a.d.normal_text_color;
    this.JNr = a.f.tag_green_tab_selector;
    this.JNs = a.d.wechat_green;
    this.adTK = a.f.tag_highlight_tab_selector;
    this.adTL = a.d.white_text_color;
    this.adTM = null;
    this.Idn = new LinkedList();
    this.adTN = new LinkedList();
    this.adTT = false;
    this.adTU = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.d(MMTagPanel.this).aoU(((TextView)paramAnonymousView).getText().toString());
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
          if ((!MMTagPanel.this.adTE) || (MMTagPanel.b(MMTagPanel.this)))
          {
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142177);
                  MMTagPanel.d(MMTagPanel.this).aoT(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142177);
                }
              });
            }
          }
          else if (MMTagPanel.c(MMTagPanel.this) == null)
          {
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.c(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).adUg, false, true);
            }
          }
          else if (MMTagPanel.c(MMTagPanel.this).adUg == paramAnonymousView)
          {
            MMTagPanel.a(MMTagPanel.this, null);
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142178);
                  MMTagPanel.d(MMTagPanel.this).aoT(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142178);
                }
              });
            }
          }
          else
          {
            MMTagPanel.this.jmK();
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.c(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).adUg, false, true);
            }
          }
        }
      }
    };
    this.mClickable = true;
    init();
    AppMethodBeat.o(142187);
  }
  
  private void a(MMTagPanel.d paramd)
  {
    AppMethodBeat.i(142204);
    paramd.adUg.setOnClickListener(null);
    if (this.adTN.size() >= 16)
    {
      AppMethodBeat.o(142204);
      return;
    }
    this.adTN.add(paramd);
    AppMethodBeat.o(142204);
  }
  
  private void init()
  {
    AppMethodBeat.i(142189);
    this.adTP = getContext().getResources().getDimensionPixelSize(a.e.HintTextSize);
    this.adTQ = LayoutInflater.from(getContext()).inflate(getEditViewLayoutId(), null);
    this.adTR = ((MMEditText)this.adTQ.findViewById(a.g.edittext));
    this.adTR.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142169);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.cH(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
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
          MMTagPanel.this.dSS();
          if ((MMTagPanel.this.Idn == null) || (MMTagPanel.this.Idn.isEmpty()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(142169);
            return false;
          }
          if ((MMTagPanel.b(MMTagPanel.this)) || (MMTagPanel.c(MMTagPanel.this) != null)) {
            break label313;
          }
          MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.this.Idn.getLast());
          MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).adUg, false, true);
          MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(142169);
          return false;
          label313:
          if ((MMTagPanel.c(MMTagPanel.this) != null) && (MMTagPanel.this.Idn != null) && (MMTagPanel.this.Idn.getLast() != null) && (!Util.isNullOrNil(MMTagPanel.c(MMTagPanel.this).adUf)) && (!Util.isNullOrNil(((MMTagPanel.d)MMTagPanel.this.Idn.getLast()).adUf)) && (!MMTagPanel.c(MMTagPanel.this).adUf.equals(((MMTagPanel.d)MMTagPanel.this.Idn.getLast()).adUf)))
          {
            Log.i("MicroMsg.MMTagPanel", "change hight");
            MMTagPanel.this.jmK();
            MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.this.Idn.getLast());
            MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).adUg, false, true);
            MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
          }
          else
          {
            paramAnonymousView = ((MMTagPanel.d)MMTagPanel.this.Idn.getLast()).adUf;
            MMTagPanel.this.aue(paramAnonymousView);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.d(MMTagPanel.this).aoV(paramAnonymousView);
            }
            MMTagPanel.this.jmK();
          }
        }
      }
    });
    this.adTR.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(142170);
        String str = paramAnonymousEditable.toString();
        if (MMTagPanel.d(MMTagPanel.this) != null) {
          MMTagPanel.d(MMTagPanel.this).aoW(str);
        }
        if (MMTagPanel.this.a(MMTagPanel.a(MMTagPanel.this), paramAnonymousEditable, str, this).length() > 0)
        {
          MMTagPanel.this.jmK();
          MMTagPanel.a(MMTagPanel.this).setBackground(MMTagPanel.this.getResources().getDrawable(a.f.lebal_edittext_gb));
          AppMethodBeat.o(142170);
          return;
        }
        MMTagPanel.a(MMTagPanel.this).setBackground(null);
        AppMethodBeat.o(142170);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.adTR.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142171);
        Log.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousBoolean) && (MMTagPanel.d(MMTagPanel.this) != null)) {
          MMTagPanel.d(MMTagPanel.this).dCx();
        }
        AppMethodBeat.o(142171);
      }
    });
    this.adTR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142172);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.d("MicroMsg.MMTagPanel", "on edittext click");
        MMTagPanel.this.jmK();
        if (MMTagPanel.d(MMTagPanel.this) != null) {
          MMTagPanel.d(MMTagPanel.this).dCx();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142172);
      }
    });
    this.adTR.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.adTR.setFilters(new InputFilter[] { localc, localb });
    jmH();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142174);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[] { Boolean.valueOf(MMTagPanel.this.adTE) });
        if (MMTagPanel.this.adTE)
        {
          MMTagPanel.this.jmK();
          MMTagPanel.a(MMTagPanel.this).requestFocus();
          MMTagPanel.a(MMTagPanel.this).setSelection(MMTagPanel.a(MMTagPanel.this).getText().length());
          ((InputMethodManager)MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(MMTagPanel.this), 0);
          Log.d("MicroMsg.MMTagPanel", "on content click");
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            MMTagPanel.d(MMTagPanel.this).dCx();
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
        if (MMTagPanel.e(MMTagPanel.this))
        {
          paramAnonymousMotionEvent = MMTagPanel.this.getEditText();
          if (!Util.isNullOrNil(paramAnonymousMotionEvent))
          {
            paramAnonymousView = paramAnonymousMotionEvent;
            if (localc != null)
            {
              paramAnonymousView = paramAnonymousMotionEvent;
              if (g.bCx(paramAnonymousMotionEvent) > localc.adUb)
              {
                int i = localc.adUb - g.bCA(paramAnonymousMotionEvent);
                paramAnonymousView = paramAnonymousMotionEvent;
                if (i < paramAnonymousMotionEvent.length()) {
                  paramAnonymousView = paramAnonymousMotionEvent.substring(0, i);
                }
              }
            }
            MMTagPanel.this.cm(paramAnonymousView, true);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.d(MMTagPanel.this).aoX(paramAnonymousView);
            }
            MMTagPanel.this.jmG();
          }
        }
        AppMethodBeat.o(142175);
        return false;
      }
    });
    AppMethodBeat.o(142189);
  }
  
  public final void LD(boolean paramBoolean)
  {
    AppMethodBeat.i(142197);
    if (paramBoolean == this.adTE)
    {
      AppMethodBeat.o(142197);
      return;
    }
    this.adTE = paramBoolean;
    removeView(this.adTQ);
    if (this.adTE)
    {
      addView(this.adTQ);
      jmH();
    }
    AppMethodBeat.o(142197);
  }
  
  protected String a(EditText paramEditText, Editable paramEditable, String paramString, TextWatcher paramTextWatcher)
  {
    return paramString;
  }
  
  public final void a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(142207);
    paramTextView.setTextSize(0, this.adTP * com.tencent.mm.cd.a.getScaleSize(getContext()));
    if (paramBoolean2)
    {
      paramTextView.setBackgroundResource(this.adTK);
      paramTextView.setTextColor(getResources().getColor(this.adTL));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.adTI, 0);
      AppMethodBeat.o(142207);
      return;
    }
    if (paramBoolean1)
    {
      paramTextView.setTag(Integer.valueOf(1));
      paramTextView.setBackgroundResource(this.JNr);
      paramTextView.setTextColor(getResources().getColor(this.JNs));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      if (dSR())
      {
        paramTextView.setContentDescription(paramTextView.getText() + getContext().getResources().getString(a.k.favorite_label) + getContext().getResources().getString(a.k.add_tag_select));
        AppMethodBeat.o(142207);
      }
    }
    else
    {
      paramTextView.setTag(Integer.valueOf(0));
      paramTextView.setBackgroundResource(this.Aks);
      paramTextView.setTextColor(getResources().getColor(this.Akr));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      if (dSR()) {
        paramTextView.setContentDescription(paramTextView.getText() + getContext().getResources().getString(a.k.favorite_label) + getContext().getResources().getString(a.k.add_tag_unselect));
      }
    }
    AppMethodBeat.o(142207);
  }
  
  protected final void a(MMTagPanel.d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142205);
    paramd.adUf = paramString;
    paramd.adUg.setText(com.tencent.mm.ui.i.c.b.a(getContext(), paramString, this.adTP));
    TextView localTextView = paramd.adUg;
    if (this.adTD) {}
    for (paramString = this.adTU;; paramString = null)
    {
      localTextView.setOnClickListener(paramString);
      a(paramd.adUg, paramBoolean, false);
      AppMethodBeat.o(142205);
      return;
    }
  }
  
  public void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(142202);
    jmz();
    if (this.adTE) {
      addView(this.adTQ);
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
        cm(str, bool);
        break;
      }
    }
    AppMethodBeat.o(142202);
  }
  
  public final void aue(String paramString)
  {
    AppMethodBeat.i(142209);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
      AppMethodBeat.o(142209);
      return;
    }
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (paramString.equals(locald.adUf))
      {
        this.Idn.remove(locald);
        removeView(locald.adUg);
        a(locald);
        jmK();
        AppMethodBeat.o(142209);
        return;
      }
    }
    Log.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142209);
  }
  
  public void cm(String paramString, boolean paramBoolean)
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
    aue(paramString);
    Object localObject = this.Idn.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).adUf))
      {
        Log.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(142208);
        return;
      }
    }
    localObject = jmJ();
    a((MMTagPanel.d)localObject, paramString, paramBoolean);
    this.Idn.add(localObject);
    if (this.adTE) {
      addView(((MMTagPanel.d)localObject).adUg, getChildCount() - 1);
    }
    for (;;)
    {
      jmK();
      AppMethodBeat.o(142208);
      return;
      addView(((MMTagPanel.d)localObject).adUg);
    }
  }
  
  protected boolean dSR()
  {
    return true;
  }
  
  protected void dSS() {}
  
  public final void eg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142211);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
      AppMethodBeat.o(142211);
      return;
    }
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (paramString.equals(locald.adUf))
      {
        a(locald, paramString, paramBoolean);
        jmK();
        AppMethodBeat.o(142211);
        return;
      }
    }
    Log.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142211);
  }
  
  protected TextView fTM()
  {
    AppMethodBeat.i(251483);
    TextView localTextView = new TextView(getContext());
    localTextView.setBackgroundResource(this.Aks);
    localTextView.setTextColor(getResources().getColor(this.Akr));
    localTextView.setTag(Integer.valueOf(0));
    localTextView.setGravity(17);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.adTI, 0);
    if (this.adTD) {}
    for (View.OnClickListener localOnClickListener = this.adTU;; localOnClickListener = null)
    {
      localTextView.setOnClickListener(localOnClickListener);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine();
      AppMethodBeat.o(251483);
      return localTextView;
    }
  }
  
  public String getEditText()
  {
    AppMethodBeat.i(142193);
    if (this.adTR != null)
    {
      String str = this.adTR.getText().toString();
      AppMethodBeat.o(142193);
      return str;
    }
    AppMethodBeat.o(142193);
    return "";
  }
  
  protected int getEditViewLayoutId()
  {
    return a.h.mm_tag_panel_edittext;
  }
  
  public String getEdittextText()
  {
    AppMethodBeat.i(251469);
    if ((this.adTE) && (!Util.isNullOrNil(this.adTR.getText())))
    {
      String str = this.adTR.getText().toString();
      AppMethodBeat.o(251469);
      return str;
    }
    AppMethodBeat.o(251469);
    return "";
  }
  
  public ArrayList<String> getSelectTagList()
  {
    AppMethodBeat.i(251478);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if ((locald != null) && (!Util.isNullOrNil(locald.adUf)) && (locald.adUg != null) && (((Integer)locald.adUg.getTag()).intValue() == 1)) {
        localArrayList.add(locald.adUf);
      }
    }
    AppMethodBeat.o(251478);
    return localArrayList;
  }
  
  public int getTagCount()
  {
    AppMethodBeat.i(142200);
    int i = this.Idn.size();
    AppMethodBeat.o(142200);
    return i;
  }
  
  public ArrayList<String> getTagList()
  {
    AppMethodBeat.i(142199);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (!Util.isNullOrNil(locald.adUf)) {
        localArrayList.add(locald.adUf);
      }
    }
    AppMethodBeat.o(142199);
    return localArrayList;
  }
  
  public Set<String> getTagSet()
  {
    AppMethodBeat.i(142198);
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (!Util.isNullOrNil(locald.adUf)) {
        localTreeSet.add(locald.adUf);
      }
    }
    AppMethodBeat.o(142198);
    return localTreeSet;
  }
  
  public final void iCG()
  {
    AppMethodBeat.i(142195);
    if ((this.adTR == null) || (this.adTR.isFocused()))
    {
      AppMethodBeat.o(142195);
      return;
    }
    this.adTR.requestFocus();
    AppMethodBeat.o(142195);
  }
  
  public final void jmG()
  {
    AppMethodBeat.i(142194);
    if (this.adTR != null) {
      this.adTR.setText("");
    }
    AppMethodBeat.o(142194);
  }
  
  public final void jmH()
  {
    AppMethodBeat.i(142196);
    if ((this.adTR != null) && (this.adTR.isFocused()))
    {
      Log.d("MicroMsg.MMTagPanel", "do clear edit focus");
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      IBinder localIBinder = this.adTR.getWindowToken();
      if (localIBinder == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
      this.adTR.clearFocus();
    }
    AppMethodBeat.o(142196);
  }
  
  public final void jmI()
  {
    this.adTD = false;
  }
  
  protected final MMTagPanel.d jmJ()
  {
    AppMethodBeat.i(142203);
    if (!this.adTN.isEmpty())
    {
      locald = (MMTagPanel.d)this.adTN.removeFirst();
      AppMethodBeat.o(142203);
      return locald;
    }
    MMTagPanel.d locald = new MMTagPanel.d();
    locald.adUg = fTM();
    AppMethodBeat.o(142203);
    return locald;
  }
  
  protected final void jmK()
  {
    AppMethodBeat.i(142206);
    if (this.adTR != null)
    {
      Log.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[] { Boolean.valueOf(this.adTR.isFocused()) });
      this.adTR.setCursorVisible(true);
    }
    if (this.adTM == null)
    {
      AppMethodBeat.o(142206);
      return;
    }
    TextView localTextView = this.adTM.adUg;
    if (((Integer)this.adTM.adUg.getTag()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      this.adTM = null;
      AppMethodBeat.o(142206);
      return;
    }
  }
  
  public final void jmL()
  {
    AppMethodBeat.i(142210);
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      removeView(locald.adUg);
      a(locald);
    }
    this.Idn.clear();
    jmK();
    AppMethodBeat.o(142210);
  }
  
  public void jmz()
  {
    AppMethodBeat.i(142201);
    this.Idn.clear();
    removeAllViews();
    Iterator localIterator = this.Idn.iterator();
    while (localIterator.hasNext()) {
      a((MMTagPanel.d)localIterator.next());
    }
    AppMethodBeat.o(142201);
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
  
  public void setCallBack(a parama)
  {
    this.adTO = parama;
  }
  
  public void setEditHint(String paramString)
  {
    AppMethodBeat.i(142192);
    if (this.adTR != null) {
      this.adTR.setHint(paramString);
    }
    AppMethodBeat.o(142192);
  }
  
  public void setEditTextColor(int paramInt)
  {
    AppMethodBeat.i(142191);
    if (this.adTR != null) {
      this.adTR.setTextColor(paramInt);
    }
    AppMethodBeat.o(142191);
  }
  
  public void setEditTextHit(boolean paramBoolean)
  {
    AppMethodBeat.i(142213);
    if (this.adTR != null)
    {
      if (paramBoolean)
      {
        this.adTR.setHint(a.k.add_tag_tips);
        AppMethodBeat.o(142213);
        return;
      }
      this.adTR.setHint("");
    }
    AppMethodBeat.o(142213);
  }
  
  public void setEdittextMaxSize(int paramInt)
  {
    AppMethodBeat.i(251441);
    this.adTS = paramInt;
    if (this.adTR != null) {
      this.adTR.setMaxEms(paramInt);
    }
    AppMethodBeat.o(251441);
  }
  
  public void setHintTextSize(int paramInt)
  {
    this.adTP = paramInt;
  }
  
  public void setIsAllowEnterCharacter(boolean paramBoolean)
  {
    this.adTT = paramBoolean;
  }
  
  public void setPanelClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public void setTagEditTextBG(int paramInt)
  {
    AppMethodBeat.i(142190);
    this.adTJ = paramInt;
    if (this.adTR != null)
    {
      com.tencent.mm.cd.a.fromDPToPix(getContext(), 6);
      getResources().getDimensionPixelSize(a.e.NormalPadding);
      this.adTR.setBackgroundResource(this.adTJ);
    }
    AppMethodBeat.o(142190);
  }
  
  public void setTagHighlineBG(int paramInt)
  {
    this.adTK = paramInt;
  }
  
  public void setTagNormalBG(int paramInt)
  {
    this.Aks = paramInt;
  }
  
  public void setTagNormalTextColorRes(int paramInt)
  {
    this.Akr = paramInt;
  }
  
  public void setTagSelectedBG(int paramInt)
  {
    this.JNr = paramInt;
  }
  
  public void setTagSelectedTextColorRes(int paramInt)
  {
    this.JNs = paramInt;
  }
  
  public void setTagTipsDrawable(int paramInt)
  {
    this.adTI = paramInt;
  }
  
  public void setTaghighlineTextColorRes(int paramInt)
  {
    this.adTL = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void G(boolean paramBoolean, int paramInt);
    
    public abstract void aoT(String paramString);
    
    public abstract void aoU(String paramString);
    
    public abstract void aoV(String paramString);
    
    public abstract void aoW(String paramString);
    
    public abstract void aoX(String paramString);
    
    public abstract void dCx();
  }
  
  public final class b
    implements InputFilter
  {
    List<String> adTY;
    int dUY;
    
    public b()
    {
      AppMethodBeat.i(142183);
      this.adTY = new LinkedList();
      AppMethodBeat.o(142183);
    }
    
    public final CharSequence filter(final CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142184);
      Log.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(MMTagPanel.g(MMTagPanel.this)) });
      this.dUY = -1;
      this.adTY.clear();
      Object localObject = new char[paramInt2 - paramInt1];
      TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, (char[])localObject, 0);
      if (!MMTagPanel.h(MMTagPanel.this))
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
              MMTagPanel.d(MMTagPanel.this).aoX(paramCharSequence.toString());
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
          if (-1 != this.dUY) {
            break label385;
          }
          this.adTY.add((paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, i)).trim());
        }
        for (;;)
        {
          this.dUY = (i + 1);
          i += 1;
          break;
          label385:
          this.adTY.add(paramCharSequence.subSequence(this.dUY, i).toString().trim());
        }
      }
      if (MMTagPanel.f(MMTagPanel.this))
      {
        paramInt1 = g.bCx(paramSpanned.toString());
        if ((MMTagPanel.g(MMTagPanel.this)) && (paramCharSequence.equals("\n")) && (36 < paramInt1)) {
          this.adTY.clear();
        }
      }
      if (this.adTY.isEmpty())
      {
        AppMethodBeat.o(142184);
        return null;
      }
      if (MMTagPanel.d(MMTagPanel.this) != null)
      {
        localObject = this.adTY.iterator();
        while (((Iterator)localObject).hasNext())
        {
          final String str = (String)((Iterator)localObject).next();
          if (str.length() > 0) {
            MMTagPanel.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142181);
                MMTagPanel.d(MMTagPanel.this).aoX(str.trim());
                AppMethodBeat.o(142181);
              }
            });
          }
        }
      }
      if (this.dUY >= paramInt2) {
        paramSpanned.length();
      }
      for (paramCharSequence = paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();; paramCharSequence = paramCharSequence.subSequence(this.dUY, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()))
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
    int adUb = 36;
    private int adUc = 256;
    private int adUd;
    
    public c() {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142186);
      paramInt1 = g.bCx(paramSpanned.toString()) + g.bCx(paramCharSequence.toString());
      if (paramInt4 > paramInt3) {
        if (paramInt1 - (paramInt4 - paramInt3) > this.adUb)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.adUd = (paramInt1 - (paramInt4 - paramInt3) - this.adUb);
        }
      }
      for (;;)
      {
        if ((MMTagPanel.f(MMTagPanel.this)) && (1 == this.adUd) && (paramCharSequence.equals("\n"))) {
          this.adUd = 0;
        }
        if (MMTagPanel.d(MMTagPanel.this) != null) {
          MMTagPanel.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142185);
              MMTagPanel.d(MMTagPanel.this).G(MMTagPanel.g(MMTagPanel.this), g.ej(MMTagPanel.c.a(MMTagPanel.c.this), ""));
              AppMethodBeat.o(142185);
            }
          });
        }
        if (paramInt1 <= this.adUc) {
          break;
        }
        AppMethodBeat.o(142186);
        return "";
        MMTagPanel.a(MMTagPanel.this, false);
        continue;
        if (paramInt1 > this.adUb)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.adUd = (paramInt1 - this.adUb);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel
 * JD-Core Version:    0.7.0.1
 */