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
  protected LinkedList<MMTagPanel.d> Crg;
  private int DWi;
  private int DWj;
  private LinkedList<MMTagPanel.d> WmA;
  private a WmB;
  private int WmC;
  protected View WmD;
  public MMEditText WmE;
  public int WmF;
  private boolean WmG;
  protected View.OnClickListener WmH;
  protected boolean Wmq;
  protected boolean Wmr;
  public boolean Wms;
  public boolean Wmt;
  public boolean Wmu;
  private int Wmv;
  private int Wmw;
  private int Wmx;
  private int Wmy;
  private MMTagPanel.d Wmz;
  public boolean mClickable;
  private boolean wMn;
  private int wNO;
  private int wNP;
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142188);
    this.wMn = false;
    this.Wmq = true;
    this.Wmr = false;
    this.Wms = true;
    this.Wmt = false;
    this.Wmu = false;
    this.Wmv = a.f.tag_deletetab;
    this.Wmw = 0;
    this.wNP = a.f.tag_white_tab_selector;
    this.wNO = a.d.normal_text_color;
    this.DWi = a.f.tag_green_tab_selector;
    this.DWj = a.d.wechat_green;
    this.Wmx = a.f.tag_highlight_tab_selector;
    this.Wmy = a.d.white_text_color;
    this.Wmz = null;
    this.Crg = new LinkedList();
    this.WmA = new LinkedList();
    this.WmG = false;
    this.WmH = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.d(MMTagPanel.this).auW(((TextView)paramAnonymousView).getText().toString());
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
          if ((!MMTagPanel.this.Wmr) || (MMTagPanel.b(MMTagPanel.this)))
          {
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142177);
                  MMTagPanel.d(MMTagPanel.this).auV(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142177);
                }
              });
            }
          }
          else if (MMTagPanel.c(MMTagPanel.this) == null)
          {
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.c(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).WmT, false, true);
            }
          }
          else if (MMTagPanel.c(MMTagPanel.this).WmT == paramAnonymousView)
          {
            MMTagPanel.a(MMTagPanel.this, null);
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142178);
                  MMTagPanel.d(MMTagPanel.this).auV(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142178);
                }
              });
            }
          }
          else
          {
            MMTagPanel.this.hKe();
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.c(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).WmT, false, true);
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
    this.wMn = false;
    this.Wmq = true;
    this.Wmr = false;
    this.Wms = true;
    this.Wmt = false;
    this.Wmu = false;
    this.Wmv = a.f.tag_deletetab;
    this.Wmw = 0;
    this.wNP = a.f.tag_white_tab_selector;
    this.wNO = a.d.normal_text_color;
    this.DWi = a.f.tag_green_tab_selector;
    this.DWj = a.d.wechat_green;
    this.Wmx = a.f.tag_highlight_tab_selector;
    this.Wmy = a.d.white_text_color;
    this.Wmz = null;
    this.Crg = new LinkedList();
    this.WmA = new LinkedList();
    this.WmG = false;
    this.WmH = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(142179);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
        {
          MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142176);
                MMTagPanel.d(MMTagPanel.this).auW(((TextView)paramAnonymousView).getText().toString());
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
          if ((!MMTagPanel.this.Wmr) || (MMTagPanel.b(MMTagPanel.this)))
          {
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142177);
                  MMTagPanel.d(MMTagPanel.this).auV(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142177);
                }
              });
            }
          }
          else if (MMTagPanel.c(MMTagPanel.this) == null)
          {
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.c(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).WmT, false, true);
            }
          }
          else if (MMTagPanel.c(MMTagPanel.this).WmT == paramAnonymousView)
          {
            MMTagPanel.a(MMTagPanel.this, null);
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              paramAnonymousView.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(142178);
                  MMTagPanel.d(MMTagPanel.this).auV(((TextView)paramAnonymousView).getText().toString());
                  AppMethodBeat.o(142178);
                }
              });
            }
          }
          else
          {
            MMTagPanel.this.hKe();
            MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
            if (MMTagPanel.c(MMTagPanel.this) != null) {
              MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).WmT, false, true);
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
    paramd.WmT.setOnClickListener(null);
    if (this.WmA.size() >= 16)
    {
      AppMethodBeat.o(142204);
      return;
    }
    this.WmA.add(paramd);
    AppMethodBeat.o(142204);
  }
  
  private void init()
  {
    AppMethodBeat.i(142189);
    this.WmC = getContext().getResources().getDimensionPixelSize(a.e.HintTextSize);
    this.WmD = LayoutInflater.from(getContext()).inflate(getEditViewLayoutId(), null);
    this.WmE = ((MMEditText)this.WmD.findViewById(a.g.edittext));
    this.WmE.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142169);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.bn(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
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
          MMTagPanel.this.dmb();
          if ((MMTagPanel.this.Crg == null) || (MMTagPanel.this.Crg.isEmpty()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(142169);
            return false;
          }
          if ((MMTagPanel.b(MMTagPanel.this)) || (MMTagPanel.c(MMTagPanel.this) != null)) {
            break label313;
          }
          MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.this.Crg.getLast());
          MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).WmT, false, true);
          MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMTagPanel$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(142169);
          return false;
          label313:
          if ((MMTagPanel.c(MMTagPanel.this) != null) && (MMTagPanel.this.Crg != null) && (MMTagPanel.this.Crg.getLast() != null) && (!Util.isNullOrNil(MMTagPanel.c(MMTagPanel.this).WmS)) && (!Util.isNullOrNil(((MMTagPanel.d)MMTagPanel.this.Crg.getLast()).WmS)) && (!MMTagPanel.c(MMTagPanel.this).WmS.equals(((MMTagPanel.d)MMTagPanel.this.Crg.getLast()).WmS)))
          {
            Log.i("MicroMsg.MMTagPanel", "change hight");
            MMTagPanel.this.hKe();
            MMTagPanel.a(MMTagPanel.this, (MMTagPanel.d)MMTagPanel.this.Crg.getLast());
            MMTagPanel.this.a(MMTagPanel.c(MMTagPanel.this).WmT, false, true);
            MMTagPanel.a(MMTagPanel.this).setCursorVisible(false);
          }
          else
          {
            paramAnonymousView = ((MMTagPanel.d)MMTagPanel.this.Crg.getLast()).WmS;
            MMTagPanel.this.removeTag(paramAnonymousView);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.d(MMTagPanel.this).auX(paramAnonymousView);
            }
            MMTagPanel.this.hKe();
          }
        }
      }
    });
    this.WmE.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(142170);
        String str = paramAnonymousEditable.toString();
        if (MMTagPanel.d(MMTagPanel.this) != null) {
          MMTagPanel.d(MMTagPanel.this).auY(str);
        }
        if (MMTagPanel.this.a(MMTagPanel.a(MMTagPanel.this), paramAnonymousEditable, str, this).length() > 0)
        {
          MMTagPanel.this.hKe();
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
    this.WmE.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142171);
        Log.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousBoolean) && (MMTagPanel.d(MMTagPanel.this) != null)) {
          MMTagPanel.d(MMTagPanel.this).cWR();
        }
        AppMethodBeat.o(142171);
      }
    });
    this.WmE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142172);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.MMTagPanel", "on edittext click");
        MMTagPanel.this.hKe();
        if (MMTagPanel.d(MMTagPanel.this) != null) {
          MMTagPanel.d(MMTagPanel.this).cWR();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMTagPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142172);
      }
    });
    this.WmE.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.WmE.setFilters(new InputFilter[] { localc, localb });
    hKb();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142174);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMTagPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[] { Boolean.valueOf(MMTagPanel.this.Wmr) });
        if (MMTagPanel.this.Wmr)
        {
          MMTagPanel.this.hKe();
          MMTagPanel.a(MMTagPanel.this).requestFocus();
          MMTagPanel.a(MMTagPanel.this).setSelection(MMTagPanel.a(MMTagPanel.this).getText().length());
          ((InputMethodManager)MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(MMTagPanel.this), 0);
          Log.d("MicroMsg.MMTagPanel", "on content click");
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            MMTagPanel.d(MMTagPanel.this).cWR();
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
              if (g.bAB(paramAnonymousMotionEvent) > localc.WmO)
              {
                int i = localc.WmO - g.bAE(paramAnonymousMotionEvent);
                paramAnonymousView = paramAnonymousMotionEvent;
                if (i < paramAnonymousMotionEvent.length()) {
                  paramAnonymousView = paramAnonymousMotionEvent.substring(0, i);
                }
              }
            }
            MMTagPanel.this.bR(paramAnonymousView, true);
            if (MMTagPanel.d(MMTagPanel.this) != null) {
              MMTagPanel.d(MMTagPanel.this).auZ(paramAnonymousView);
            }
            MMTagPanel.this.hKa();
          }
        }
        AppMethodBeat.o(142175);
        return false;
      }
    });
    AppMethodBeat.o(142189);
  }
  
  public final void FR(boolean paramBoolean)
  {
    AppMethodBeat.i(142197);
    if (paramBoolean == this.Wmr)
    {
      AppMethodBeat.o(142197);
      return;
    }
    this.Wmr = paramBoolean;
    removeView(this.WmD);
    if (this.Wmr)
    {
      addView(this.WmD);
      hKb();
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
    paramTextView.setTextSize(0, this.WmC);
    if (paramBoolean2)
    {
      paramTextView.setBackgroundResource(this.Wmx);
      paramTextView.setTextColor(getResources().getColor(this.Wmy));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.Wmv, 0);
      AppMethodBeat.o(142207);
      return;
    }
    if (paramBoolean1)
    {
      paramTextView.setTag(Integer.valueOf(1));
      paramTextView.setBackgroundResource(this.DWi);
      paramTextView.setTextColor(getResources().getColor(this.DWj));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      AppMethodBeat.o(142207);
      return;
    }
    paramTextView.setTag(Integer.valueOf(0));
    paramTextView.setBackgroundResource(this.wNP);
    paramTextView.setTextColor(getResources().getColor(this.wNO));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(142207);
  }
  
  protected final void a(MMTagPanel.d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142205);
    paramd.WmS = paramString;
    paramd.WmT.setText(com.tencent.mm.ui.h.c.b.a(getContext(), paramString, this.WmC));
    TextView localTextView = paramd.WmT;
    if (this.Wmq) {}
    for (paramString = this.WmH;; paramString = null)
    {
      localTextView.setOnClickListener(paramString);
      a(paramd.WmT, paramBoolean, false);
      AppMethodBeat.o(142205);
      return;
    }
  }
  
  public void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(142202);
    hJT();
    if (this.Wmr) {
      addView(this.WmD);
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
        bR(str, bool);
        break;
      }
    }
    AppMethodBeat.o(142202);
  }
  
  public void bR(String paramString, boolean paramBoolean)
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
    Object localObject = this.Crg.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).WmS))
      {
        Log.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(142208);
        return;
      }
    }
    localObject = hKd();
    a((MMTagPanel.d)localObject, paramString, paramBoolean);
    this.Crg.add(localObject);
    if (this.Wmr) {
      addView(((MMTagPanel.d)localObject).WmT, getChildCount() - 1);
    }
    for (;;)
    {
      hKe();
      AppMethodBeat.o(142208);
      return;
      addView(((MMTagPanel.d)localObject).WmT);
    }
  }
  
  protected void dmb() {}
  
  public final void dy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142211);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
      AppMethodBeat.o(142211);
      return;
    }
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (paramString.equals(locald.WmS))
      {
        a(locald, paramString, paramBoolean);
        hKe();
        AppMethodBeat.o(142211);
        return;
      }
    }
    Log.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142211);
  }
  
  protected TextView eLu()
  {
    AppMethodBeat.i(190847);
    TextView localTextView = new TextView(getContext());
    localTextView.setBackgroundResource(this.wNP);
    localTextView.setTextColor(getResources().getColor(this.wNO));
    localTextView.setTag(Integer.valueOf(0));
    localTextView.setGravity(17);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.Wmv, 0);
    if (this.Wmq) {}
    for (View.OnClickListener localOnClickListener = this.WmH;; localOnClickListener = null)
    {
      localTextView.setOnClickListener(localOnClickListener);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine();
      AppMethodBeat.o(190847);
      return localTextView;
    }
  }
  
  public String getEditText()
  {
    AppMethodBeat.i(142193);
    if (this.WmE != null)
    {
      String str = this.WmE.getText().toString();
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
    AppMethodBeat.i(190802);
    if ((this.Wmr) && (!Util.isNullOrNil(this.WmE.getText())))
    {
      String str = this.WmE.getText().toString();
      AppMethodBeat.o(190802);
      return str;
    }
    AppMethodBeat.o(190802);
    return "";
  }
  
  public ArrayList<String> getSelectTagList()
  {
    AppMethodBeat.i(190824);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if ((locald != null) && (!Util.isNullOrNil(locald.WmS)) && (locald.WmT != null) && (((Integer)locald.WmT.getTag()).intValue() == 1)) {
        localArrayList.add(locald.WmS);
      }
    }
    AppMethodBeat.o(190824);
    return localArrayList;
  }
  
  public int getTagCount()
  {
    AppMethodBeat.i(142200);
    int i = this.Crg.size();
    AppMethodBeat.o(142200);
    return i;
  }
  
  public ArrayList<String> getTagList()
  {
    AppMethodBeat.i(142199);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (!Util.isNullOrNil(locald.WmS)) {
        localArrayList.add(locald.WmS);
      }
    }
    AppMethodBeat.o(142199);
    return localArrayList;
  }
  
  public Set<String> getTagSet()
  {
    AppMethodBeat.i(142198);
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (!Util.isNullOrNil(locald.WmS)) {
        localTreeSet.add(locald.WmS);
      }
    }
    AppMethodBeat.o(142198);
    return localTreeSet;
  }
  
  public void hJT()
  {
    AppMethodBeat.i(142201);
    this.Crg.clear();
    removeAllViews();
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext()) {
      a((MMTagPanel.d)localIterator.next());
    }
    AppMethodBeat.o(142201);
  }
  
  public final void hKa()
  {
    AppMethodBeat.i(142194);
    if (this.WmE != null) {
      this.WmE.setText("");
    }
    AppMethodBeat.o(142194);
  }
  
  public final void hKb()
  {
    AppMethodBeat.i(142196);
    if ((this.WmE != null) && (this.WmE.isFocused()))
    {
      Log.d("MicroMsg.MMTagPanel", "do clear edit focus");
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      IBinder localIBinder = this.WmE.getWindowToken();
      if (localIBinder == null)
      {
        AppMethodBeat.o(142196);
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
      this.WmE.clearFocus();
    }
    AppMethodBeat.o(142196);
  }
  
  public final void hKc()
  {
    this.Wmq = false;
  }
  
  protected final MMTagPanel.d hKd()
  {
    AppMethodBeat.i(142203);
    if (!this.WmA.isEmpty())
    {
      locald = (MMTagPanel.d)this.WmA.removeFirst();
      AppMethodBeat.o(142203);
      return locald;
    }
    MMTagPanel.d locald = new MMTagPanel.d();
    locald.WmT = eLu();
    AppMethodBeat.o(142203);
    return locald;
  }
  
  protected final void hKe()
  {
    AppMethodBeat.i(142206);
    if (this.WmE != null)
    {
      Log.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[] { Boolean.valueOf(this.WmE.isFocused()) });
      this.WmE.setCursorVisible(true);
    }
    if (this.Wmz == null)
    {
      AppMethodBeat.o(142206);
      return;
    }
    TextView localTextView = this.Wmz.WmT;
    if (((Integer)this.Wmz.WmT.getTag()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      this.Wmz = null;
      AppMethodBeat.o(142206);
      return;
    }
  }
  
  public final void hKf()
  {
    AppMethodBeat.i(142210);
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      removeView(locald.WmT);
      a(locald);
    }
    this.Crg.clear();
    hKe();
    AppMethodBeat.o(142210);
  }
  
  public final void hch()
  {
    AppMethodBeat.i(142195);
    if ((this.WmE == null) || (this.WmE.isFocused()))
    {
      AppMethodBeat.o(142195);
      return;
    }
    this.WmE.requestFocus();
    AppMethodBeat.o(142195);
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
    Iterator localIterator = this.Crg.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (paramString.equals(locald.WmS))
      {
        this.Crg.remove(locald);
        removeView(locald.WmT);
        a(locald);
        hKe();
        AppMethodBeat.o(142209);
        return;
      }
    }
    Log.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(142209);
  }
  
  public void setCallBack(a parama)
  {
    this.WmB = parama;
  }
  
  public void setEditHint(String paramString)
  {
    AppMethodBeat.i(142192);
    if (this.WmE != null) {
      this.WmE.setHint(paramString);
    }
    AppMethodBeat.o(142192);
  }
  
  public void setEditTextColor(int paramInt)
  {
    AppMethodBeat.i(142191);
    if (this.WmE != null) {
      this.WmE.setTextColor(paramInt);
    }
    AppMethodBeat.o(142191);
  }
  
  public void setEditTextHit(boolean paramBoolean)
  {
    AppMethodBeat.i(142213);
    if (this.WmE != null)
    {
      if (paramBoolean)
      {
        this.WmE.setHint(a.k.add_tag_tips);
        AppMethodBeat.o(142213);
        return;
      }
      this.WmE.setHint("");
    }
    AppMethodBeat.o(142213);
  }
  
  public void setEdittextMaxSize(int paramInt)
  {
    AppMethodBeat.i(190761);
    this.WmF = paramInt;
    if (this.WmE != null) {
      this.WmE.setMaxEms(paramInt);
    }
    AppMethodBeat.o(190761);
  }
  
  public void setHintTextSize(int paramInt)
  {
    this.WmC = paramInt;
  }
  
  public void setIsAllowEnterCharacter(boolean paramBoolean)
  {
    this.WmG = paramBoolean;
  }
  
  public void setPanelClickable(boolean paramBoolean)
  {
    this.mClickable = paramBoolean;
  }
  
  public void setTagEditTextBG(int paramInt)
  {
    AppMethodBeat.i(142190);
    this.Wmw = paramInt;
    if (this.WmE != null)
    {
      com.tencent.mm.ci.a.fromDPToPix(getContext(), 6);
      getResources().getDimensionPixelSize(a.e.NormalPadding);
      this.WmE.setBackgroundResource(this.Wmw);
    }
    AppMethodBeat.o(142190);
  }
  
  public void setTagHighlineBG(int paramInt)
  {
    this.Wmx = paramInt;
  }
  
  public void setTagNormalBG(int paramInt)
  {
    this.wNP = paramInt;
  }
  
  public void setTagNormalTextColorRes(int paramInt)
  {
    this.wNO = paramInt;
  }
  
  public void setTagSelectedBG(int paramInt)
  {
    this.DWi = paramInt;
  }
  
  public void setTagSelectedTextColorRes(int paramInt)
  {
    this.DWj = paramInt;
  }
  
  public void setTagTipsDrawable(int paramInt)
  {
    this.Wmv = paramInt;
  }
  
  public void setTaghighlineTextColorRes(int paramInt)
  {
    this.Wmy = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void I(boolean paramBoolean, int paramInt);
    
    public abstract void auV(String paramString);
    
    public abstract void auW(String paramString);
    
    public abstract void auX(String paramString);
    
    public abstract void auY(String paramString);
    
    public abstract void auZ(String paramString);
    
    public abstract void cWR();
  }
  
  public final class b
    implements InputFilter
  {
    List<String> WmL;
    int iSy;
    
    public b()
    {
      AppMethodBeat.i(142183);
      this.WmL = new LinkedList();
      AppMethodBeat.o(142183);
    }
    
    public final CharSequence filter(final CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142184);
      Log.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(MMTagPanel.g(MMTagPanel.this)) });
      this.iSy = -1;
      this.WmL.clear();
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
              MMTagPanel.d(MMTagPanel.this).auZ(paramCharSequence.toString());
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
          if (-1 != this.iSy) {
            break label385;
          }
          this.WmL.add((paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, i)).trim());
        }
        for (;;)
        {
          this.iSy = (i + 1);
          i += 1;
          break;
          label385:
          this.WmL.add(paramCharSequence.subSequence(this.iSy, i).toString().trim());
        }
      }
      if (MMTagPanel.f(MMTagPanel.this))
      {
        paramInt1 = g.bAB(paramSpanned.toString());
        if ((MMTagPanel.g(MMTagPanel.this)) && (paramCharSequence.equals("\n")) && (36 < paramInt1)) {
          this.WmL.clear();
        }
      }
      if (this.WmL.isEmpty())
      {
        AppMethodBeat.o(142184);
        return null;
      }
      if (MMTagPanel.d(MMTagPanel.this) != null)
      {
        localObject = this.WmL.iterator();
        while (((Iterator)localObject).hasNext())
        {
          final String str = (String)((Iterator)localObject).next();
          if (str.length() > 0) {
            MMTagPanel.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(142181);
                MMTagPanel.d(MMTagPanel.this).auZ(str.trim());
                AppMethodBeat.o(142181);
              }
            });
          }
        }
      }
      if (this.iSy >= paramInt2) {
        paramSpanned.length();
      }
      for (paramCharSequence = paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();; paramCharSequence = paramCharSequence.subSequence(this.iSy, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()))
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
    int WmO = 36;
    private int WmP = 256;
    private int WmQ;
    
    public c() {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(142186);
      paramInt1 = g.bAB(paramSpanned.toString()) + g.bAB(paramCharSequence.toString());
      if (paramInt4 > paramInt3) {
        if (paramInt1 - (paramInt4 - paramInt3) > this.WmO)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.WmQ = (paramInt1 - (paramInt4 - paramInt3) - this.WmO);
        }
      }
      for (;;)
      {
        if ((MMTagPanel.f(MMTagPanel.this)) && (1 == this.WmQ) && (paramCharSequence.equals("\n"))) {
          this.WmQ = 0;
        }
        if (MMTagPanel.d(MMTagPanel.this) != null) {
          MMTagPanel.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142185);
              MMTagPanel.d(MMTagPanel.this).I(MMTagPanel.g(MMTagPanel.this), g.dq(MMTagPanel.c.a(MMTagPanel.c.this), ""));
              AppMethodBeat.o(142185);
            }
          });
        }
        if (paramInt1 <= this.WmP) {
          break;
        }
        AppMethodBeat.o(142186);
        return "";
        MMTagPanel.a(MMTagPanel.this, false);
        continue;
        if (paramInt1 > this.WmO)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.WmQ = (paramInt1 - this.WmO);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel
 * JD-Core Version:    0.7.0.1
 */