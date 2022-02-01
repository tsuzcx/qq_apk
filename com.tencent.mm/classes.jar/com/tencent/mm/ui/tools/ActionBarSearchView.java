package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarSearchView
  extends LinearLayout
  implements e
{
  private TextWatcher JiE;
  private boolean VQV;
  private View XMT;
  protected ActionBarEditText XMU;
  private ImageButton XMV;
  private ActionBarSearchView.c XMW;
  private boolean XMX;
  private z XMY;
  private b XMZ;
  private a XNa;
  private View.OnFocusChangeListener XNb;
  private View.OnFocusChangeListener XNc;
  private View.OnClickListener XNd;
  private View.OnClickListener XNe;
  
  public ActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143001);
    this.XMW = ActionBarSearchView.c.XNh;
    this.XMX = false;
    this.VQV = false;
    this.JiE = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142986);
        ActionBarSearchView.a(ActionBarSearchView.this);
        z localz = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localz.XVv)
        {
          localEditText = (EditText)localz.XVt.get();
          if (localEditText != null) {}
        }
        else if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
        {
          localObject = ActionBarSearchView.c(ActionBarSearchView.this);
          if (paramAnonymousCharSequence != null) {
            break label253;
          }
        }
        label253:
        for (paramAnonymousCharSequence = "";; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
        {
          ((ActionBarSearchView.b)localObject).bqU(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localz.mText == null) || (localz.mText.length() == 0) || ((localz.mText != null) && (paramAnonymousCharSequence != null) && (localz.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            Log.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localz.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localz.mText = ((String)localObject);
            localz.XVs = z.q(localz.mText, localz.XVu);
            if (!z.a(localEditText, localz.XVu)) {
              break;
            }
            Log.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.XNb = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        Log.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.XNd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ActionBarSearchView.c.XNh == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.Hb(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).bxJ();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).hYf();
          }
        }
      }
    };
    this.XNe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).hYd();
        }
        a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143001);
  }
  
  public ActionBarSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143000);
    this.XMW = ActionBarSearchView.c.XNh;
    this.XMX = false;
    this.VQV = false;
    this.JiE = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(142986);
        ActionBarSearchView.a(ActionBarSearchView.this);
        z localz = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        Object localObject;
        if (localz.XVv)
        {
          localEditText = (EditText)localz.XVt.get();
          if (localEditText != null) {}
        }
        else if (ActionBarSearchView.c(ActionBarSearchView.this) != null)
        {
          localObject = ActionBarSearchView.c(ActionBarSearchView.this);
          if (paramAnonymousCharSequence != null) {
            break label253;
          }
        }
        label253:
        for (paramAnonymousCharSequence = "";; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
        {
          ((ActionBarSearchView.b)localObject).bqU(paramAnonymousCharSequence);
          AppMethodBeat.o(142986);
          return;
          if (((paramAnonymousCharSequence != null) && (paramAnonymousCharSequence.toString() != null) && (paramAnonymousCharSequence.toString().length() != 0)) || ((localz.mText == null) || (localz.mText.length() == 0) || ((localz.mText != null) && (paramAnonymousCharSequence != null) && (localz.mText.equals(paramAnonymousCharSequence.toString())))))
          {
            Log.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", new Object[] { paramAnonymousCharSequence, localz.mText });
            break;
          }
          if (paramAnonymousCharSequence != null) {}
          for (localObject = paramAnonymousCharSequence.toString();; localObject = "")
          {
            localz.mText = ((String)localObject);
            localz.XVs = z.q(localz.mText, localz.XVu);
            if (!z.a(localEditText, localz.XVu)) {
              break;
            }
            Log.d("MicroMsg.WordsChecker", "decorate text succ.");
            break;
          }
        }
      }
    };
    this.XNb = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(142987);
        Log.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ActionBarSearchView.d(ActionBarSearchView.this) != null) {
          ActionBarSearchView.d(ActionBarSearchView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        AppMethodBeat.o(142987);
      }
    };
    this.XNd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142988);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ActionBarSearchView.c.XNh == ActionBarSearchView.e(ActionBarSearchView.this))
        {
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
          ActionBarSearchView.this.Hb(true);
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).bxJ();
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142988);
          return;
          Log.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
          if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
            ActionBarSearchView.c(ActionBarSearchView.this).hYf();
          }
        }
      }
    };
    this.XNe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142989);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (ActionBarSearchView.f(ActionBarSearchView.this) != null) {
          ActionBarSearchView.f(ActionBarSearchView.this).hYd();
        }
        a.a(this, "com/tencent/mm/ui/tools/ActionBarSearchView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142989);
      }
    };
    init();
    AppMethodBeat.o(143000);
  }
  
  private void hXZ()
  {
    AppMethodBeat.i(143010);
    if ((this.XMU.getEditableText() != null) && (!Util.isNullOrNil(this.XMU.getEditableText().toString())))
    {
      mH(a.f.search_clear, getResources().getDimensionPixelSize(a.e.NormalIconSize));
      this.XMW = ActionBarSearchView.c.XNh;
      AppMethodBeat.o(143010);
      return;
    }
    if (this.XMX)
    {
      mH(a.f.voicesearch_enter_btn, getResources().getDimensionPixelSize(a.e.NormalIconSize));
      this.XMW = ActionBarSearchView.c.XNi;
      AppMethodBeat.o(143010);
      return;
    }
    mH(0, 0);
    this.XMW = ActionBarSearchView.c.XNh;
    AppMethodBeat.o(143010);
  }
  
  private void init()
  {
    AppMethodBeat.i(143002);
    this.VQV = ar.isDarkMode();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
    this.XMT = findViewById(a.g.cancel_btn);
    this.XMT.setOnClickListener(this.XNe);
    this.XMU = ((ActionBarEditText)findViewById(a.g.edittext));
    this.XMY = new z(this.XMU);
    this.XMU.setSearchView(this);
    this.XMU.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142990);
        ActionBarSearchView.this.XMU.setText("");
        if (ActionBarSearchView.c(ActionBarSearchView.this) != null) {
          ActionBarSearchView.c(ActionBarSearchView.this).hYe();
        }
        AppMethodBeat.o(142990);
      }
    });
    this.XMV = ((ImageButton)findViewById(a.g.status_btn));
    this.XMU.addTextChangedListener(this.JiE);
    this.XMU.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(142991);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        ((b)localObject).sg(paramAnonymousInt);
        ((b)localObject).bn(paramAnonymousKeyEvent);
        a.c("com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((b)localObject).aFi());
        if (paramAnonymousInt == 67)
        {
          Log.d("MicroMsg.ActionBarSearchView", "on back key click.");
          localObject = ActionBarSearchView.b(ActionBarSearchView.this);
          boolean bool;
          if (((z)localObject).XVv)
          {
            paramAnonymousView = (EditText)((z)localObject).XVt.get();
            if ((paramAnonymousView != null) && (((z)localObject).XVs != null)) {}
          }
          else
          {
            bool = false;
          }
          for (;;)
          {
            a.a(bool, this, "com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(142991);
            return bool;
            paramAnonymousKeyEvent = paramAnonymousView.getText();
            paramAnonymousInt = paramAnonymousView.getSelectionStart();
            if (paramAnonymousInt == paramAnonymousView.getSelectionEnd())
            {
              localObject = ((z)localObject).axv(paramAnonymousInt);
              if ((localObject != null) && (((z.b)localObject).XVy))
              {
                paramAnonymousKeyEvent.delete(((z.b)localObject).start, ((z.b)localObject).start + ((z.b)localObject).length);
                paramAnonymousView.setTextKeepState(paramAnonymousKeyEvent);
                paramAnonymousView.setSelection(((z.b)localObject).start);
                bool = true;
                continue;
              }
            }
            bool = false;
          }
        }
        a.a(false, this, "com/tencent/mm/ui/tools/ActionBarSearchView$6", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(142991);
        return false;
      }
    });
    this.XMU.setOnSelectionChangeListener(new AutoMatchKeywordEditText.a()
    {
      public final void b(EditText paramAnonymousEditText, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(142992);
        Log.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject = ActionBarSearchView.b(ActionBarSearchView.this);
        EditText localEditText;
        if (((z)localObject).XVv)
        {
          localEditText = (EditText)((z)localObject).XVt.get();
          if ((localEditText != null) && (paramAnonymousEditText == localEditText)) {}
        }
        else
        {
          AppMethodBeat.o(142992);
          return;
        }
        paramAnonymousEditText = localEditText.getText();
        paramAnonymousInt2 = localEditText.getSelectionStart();
        int i = localEditText.getSelectionEnd();
        if ((paramAnonymousInt2 < 0) || (i < paramAnonymousInt2))
        {
          AppMethodBeat.o(142992);
          return;
        }
        if (paramAnonymousInt2 == i)
        {
          localObject = ((z)localObject).axv(paramAnonymousInt2);
          if ((localObject != null) && (((z.b)localObject).XVy))
          {
            localEditText.setTextKeepState(paramAnonymousEditText);
            paramAnonymousInt1 = ((z.b)localObject).start;
            localEditText.setSelection(((z.b)localObject).length + paramAnonymousInt1);
          }
          AppMethodBeat.o(142992);
          return;
        }
        z.b localb = ((z)localObject).axv(paramAnonymousInt2);
        paramAnonymousInt1 = paramAnonymousInt2;
        if (localb != null)
        {
          paramAnonymousInt1 = paramAnonymousInt2;
          if (localb.XVy) {
            paramAnonymousInt1 = localb.start + localb.length;
          }
        }
        if (paramAnonymousInt1 >= i)
        {
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1);
          AppMethodBeat.o(142992);
          return;
        }
        localObject = ((z)localObject).axv(i);
        if ((localObject != null) && (((z.b)localObject).XVy))
        {
          paramAnonymousInt2 = ((z.b)localObject).start;
          localEditText.setTextKeepState(paramAnonymousEditText);
          localEditText.setSelection(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(142992);
      }
    });
    this.XMU.setOnFocusChangeListener(this.XNb);
    c.i(this.XMU).axx(100).a(null);
    this.XMV.setOnClickListener(this.XNd);
    if (this.XMV.getDrawable() != null) {
      this.XMV.getDrawable().setColorFilter(getResources().getColor(a.d.FG_0), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(143002);
  }
  
  private void mH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143009);
    this.XMV.setImageResource(paramInt1);
    this.XMV.setBackgroundResource(0);
    if (paramInt1 == a.f.voicesearch_enter_btn) {
      this.XMV.setContentDescription(getContext().getString(a.k.voice_Input));
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = this.XMV.getLayoutParams();
      localLayoutParams.width = paramInt2;
      this.XMV.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(143009);
      return;
      this.XMV.setContentDescription(getContext().getString(a.k.clear_btn));
    }
  }
  
  public final void Ha(boolean paramBoolean)
  {
    AppMethodBeat.i(143006);
    this.XMX = paramBoolean;
    hXZ();
    AppMethodBeat.o(143006);
  }
  
  public final void Hb(boolean paramBoolean)
  {
    AppMethodBeat.i(143012);
    if (!paramBoolean)
    {
      this.XMU.removeTextChangedListener(this.JiE);
      this.XMU.setText("");
      this.XMU.addTextChangedListener(this.JiE);
      AppMethodBeat.o(143012);
      return;
    }
    this.XMU.setText("");
    AppMethodBeat.o(143012);
  }
  
  protected int getLayoutId()
  {
    return a.h.actionbar_searchview;
  }
  
  public String getSearchContent()
  {
    AppMethodBeat.i(143003);
    if (this.XMU.getEditableText() != null)
    {
      String str = this.XMU.getEditableText().toString();
      AppMethodBeat.o(143003);
      return str;
    }
    AppMethodBeat.o(143003);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(143021);
    if (this.XMU != null)
    {
      int i = this.XMU.getSelectionEnd();
      AppMethodBeat.o(143021);
      return i;
    }
    AppMethodBeat.o(143021);
    return -1;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(143020);
    if (this.XMU != null)
    {
      int i = this.XMU.getSelectionStart();
      AppMethodBeat.o(143020);
      return i;
    }
    AppMethodBeat.o(143020);
    return -1;
  }
  
  public final void hYa()
  {
    AppMethodBeat.i(143013);
    this.XMU.clearFocus();
    AppMethodBeat.o(143013);
  }
  
  public final boolean hYb()
  {
    AppMethodBeat.i(143014);
    if (this.XMU != null)
    {
      boolean bool = this.XMU.hasFocus();
      AppMethodBeat.o(143014);
      return bool;
    }
    AppMethodBeat.o(143014);
    return false;
  }
  
  public final boolean hYc()
  {
    AppMethodBeat.i(143015);
    if (this.XMU != null)
    {
      boolean bool = this.XMU.requestFocus();
      AppMethodBeat.o(143015);
      return bool;
    }
    AppMethodBeat.o(143015);
    return false;
  }
  
  public final void hjE()
  {
    AppMethodBeat.i(193505);
    findViewById(a.g.actionbar_searchview_parent).setBackgroundColor(getResources().getColor(a.d.Dark_0));
    findViewById(a.g.search_ll).setBackgroundResource(a.f.black_bg);
    ((TextView)this.XMT).setTextColor(Color.parseColor("#7D90A9"));
    ((WeImageView)findViewById(a.g.search_icon)).setIconColor(Color.parseColor("#6B6B6B"));
    this.XMU.setTextColor(Color.parseColor("#CCFFFFFF"));
    this.XMU.setHintTextColor(Color.parseColor("#4DFFFFFF"));
    AppMethodBeat.o(193505);
  }
  
  public void setAutoMatchKeywords(boolean paramBoolean)
  {
    if (this.XMY != null) {
      this.XMY.XVv = paramBoolean;
    }
  }
  
  public void setBackClickCallback(a parama)
  {
    this.XNa = parama;
  }
  
  public void setCallBack(b paramb)
  {
    this.XMZ = paramb;
  }
  
  public void setEditTextClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(143016);
    if (this.XMU != null)
    {
      this.XMU.setFocusable(false);
      this.XMU.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(143016);
  }
  
  public void setEditTextEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143007);
    this.XMU.setEnabled(paramBoolean);
    AppMethodBeat.o(143007);
  }
  
  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.XNc = paramOnFocusChangeListener;
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143005);
    this.XMU.setHint(paramCharSequence);
    AppMethodBeat.o(143005);
  }
  
  public void setImeScene(int paramInt)
  {
    AppMethodBeat.i(193526);
    if (this.XMU != null) {
      this.XMU.getInputExtras(true).putInt("wechat_scene", paramInt);
    }
    AppMethodBeat.o(193526);
  }
  
  public void setKeywords(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143017);
    if (this.XMY != null)
    {
      z localz = this.XMY;
      localz.XVu = paramArrayList;
      if (localz.XVv)
      {
        paramArrayList = (EditText)localz.XVt.get();
        if (paramArrayList != null) {
          z.a(paramArrayList, localz.XVu);
        }
      }
    }
    AppMethodBeat.o(143017);
  }
  
  public void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama) {}
  
  public void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    AppMethodBeat.i(143011);
    this.XMU.setOnEditorActionListener(paramOnEditorActionListener);
    AppMethodBeat.o(143011);
  }
  
  public void setSearchContent(String paramString)
  {
    AppMethodBeat.i(143004);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.XMU.setText(str);
    this.XMU.setSelection(str.length());
    AppMethodBeat.o(143004);
  }
  
  public void setSearchTipIcon(int paramInt)
  {
    AppMethodBeat.i(143018);
    if (this.XMU != null) {
      this.XMU.setCompoundDrawables(MMApplicationContext.getResources().getDrawable(paramInt), null, null, null);
    }
    AppMethodBeat.o(143018);
  }
  
  public void setSelectedTag(String paramString)
  {
    AppMethodBeat.i(143019);
    if (this.XMU != null)
    {
      this.XMU.setCompoundDrawables(new ActionBarSearchView.d(this, this.XMU, paramString), null, null, null);
      this.XMU.setHint("");
    }
    AppMethodBeat.o(143019);
  }
  
  public void setStatusBtnEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(143008);
    this.XMV.setEnabled(paramBoolean);
    AppMethodBeat.o(143008);
  }
  
  public static class ActionBarEditText
    extends AutoMatchKeywordEditText
  {
    private ActionBarSearchView XNg;
    
    public ActionBarEditText(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public ActionBarEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(142993);
      Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          AppMethodBeat.o(142993);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            Log.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
            this.XNg.clearFocus();
            paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
            if (paramKeyEvent != null) {
              paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            AppMethodBeat.o(142993);
            return true;
          }
        }
      }
      boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
      AppMethodBeat.o(142993);
      return bool;
    }
    
    public void setSearchView(ActionBarSearchView paramActionBarSearchView)
    {
      this.XNg = paramActionBarSearchView;
    }
  }
  
  public static abstract interface a
  {
    public abstract void hYd();
  }
  
  public static abstract interface b
  {
    public abstract void bqU(String paramString);
    
    public abstract void bxJ();
    
    public abstract void hYe();
    
    public abstract void hYf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ActionBarSearchView
 * JD-Core Version:    0.7.0.1
 */