package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.model.j;
import com.tencent.mm.plugin.qqmail.model.k;
import com.tencent.mm.plugin.qqmail.model.l;
import com.tencent.mm.plugin.qqmail.model.u;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAddrsViewControl
  extends RelativeLayout
{
  private static final Pattern Nop;
  private GestureDetector Nnz;
  private LinkedList<k> Noj;
  AutoCompleteTextView Nok;
  private MailAddrsViewControl.b Nol;
  private c Nom;
  private View Non;
  private a Noo;
  private GestureDetector.SimpleOnGestureListener Noq;
  private MMHandler handler;
  private boolean qiO;
  
  static
  {
    AppMethodBeat.i(123102);
    Nop = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    AppMethodBeat.o(123102);
  }
  
  public MailAddrsViewControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123085);
    this.qiO = false;
    this.Noj = new LinkedList();
    this.handler = new MMHandler();
    this.Noo = null;
    this.Noq = new GestureDetector.SimpleOnGestureListener()
    {
      private void gEL()
      {
        AppMethodBeat.i(123071);
        Object localObject2 = (k)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag();
        if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null)
        {
          MailAddrsViewControl.g(MailAddrsViewControl.this);
          MailAddrsViewControl.c(MailAddrsViewControl.this);
        }
        Object localObject1 = new Intent(MailAddrsViewControl.this.getContext(), MailAddrProfileUI.class);
        ((Intent)localObject1).putExtra("name", ((k)localObject2).name);
        ((Intent)localObject1).putExtra("addr", ((k)localObject2).KbS);
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("can_compose", bool);
          localObject2 = MailAddrsViewControl.this.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(123071);
          return;
        }
      }
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(266997);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(266997);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123074);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        gEL();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123074);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123073);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        if ((MailAddrsViewControl.g(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != null))
        {
          MailAddrsViewControl.g(MailAddrsViewControl.this);
          MailAddrsViewControl.c(MailAddrsViewControl.this);
          MailAddrsViewControl.c(MailAddrsViewControl.this).getTag();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(123073);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123072);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {
          gEL();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123072);
        return true;
      }
    };
    this.Nnz = new GestureDetector(paramContext, this.Noq);
    AppMethodBeat.o(123085);
  }
  
  private static boolean aSt(String paramString)
  {
    AppMethodBeat.i(123097);
    boolean bool = Nop.matcher(paramString).matches();
    AppMethodBeat.o(123097);
    return bool;
  }
  
  private void cF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123100);
    paramString = paramString.trim();
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(123100);
      return;
    }
    Object localObject = ((j)h.az(j.class)).getNormalMailAppService().Nkb.aSm(paramString);
    if (((List)localObject).size() > 0)
    {
      b((k)((List)localObject).get(0));
      this.Nok.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (aSt(paramString))
    {
      localObject = new k();
      ((k)localObject).name = paramString;
      ((k)localObject).KbS = paramString;
      ((k)localObject).NjF = 0;
      b((k)localObject);
      this.Nok.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (paramBoolean)
    {
      if (this.Noo != null) {
        this.Noo.gEt();
      }
      for (;;)
      {
        this.Nok.setText(paramString);
        this.Nok.setSelection(paramString.length());
        AppMethodBeat.o(123100);
        return;
        Toast.makeText(getContext(), e.i.plugin_qqmail_mail_addr_format_invalid, 2000).show();
      }
    }
    if (this.Noo != null) {
      this.Noo.b(this);
    }
    AppMethodBeat.o(123100);
  }
  
  private void gEI()
  {
    AppMethodBeat.i(177331);
    removeAllViews();
    this.Noj.clear();
    gEK();
    invalidate();
    AppMethodBeat.o(177331);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(123092);
    if (paramk == null)
    {
      AppMethodBeat.o(123092);
      return;
    }
    Object localObject1 = this.Noj.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((k)((Iterator)localObject1).next()).KbS.equalsIgnoreCase(paramk.KbS));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = (ViewGroup)View.inflate(getContext(), e.f.qqmail_comm_widget, null);
        localObject1 = (Button)((ViewGroup)localObject2).findViewById(e.e.qqmail_single_addr_btn);
        ((ViewGroup)localObject2).removeView((View)((Button)localObject1).getParent());
        ((Button)localObject1).setText(paramk.name);
        if (this.qiO) {
          ((Button)localObject1).setCompoundDrawables(null, null, null, null);
        }
        ((Button)localObject1).setTag(this.Noj.size());
        localObject2 = (View)((Button)localObject1).getParent();
        ((Button)localObject1).setTag(paramk);
        ((View)localObject2).setVisibility(4);
        ((View)localObject2).setTag(paramk);
        addView((View)localObject2, this.Noj.size());
        this.Noj.add(paramk);
        this.handler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123065);
            this.Nos.invalidate();
            this.Nos.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
              {
                AppMethodBeat.i(123064);
                if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != paramAnonymous2View) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(false);
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                }
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymous2View);
                if ((MailAddrsViewControl.this.Nok != null) && (paramAnonymous2MotionEvent.getAction() == 0))
                {
                  paramAnonymous2View = MailAddrsViewControl.2.this.Nos;
                  if (MailAddrsViewControl.2.this.Nos.isSelected()) {
                    break label264;
                  }
                }
                label264:
                for (boolean bool = true;; bool = false)
                {
                  paramAnonymous2View.setSelected(bool);
                  MailAddrsViewControl.this.Nok.setVisibility(0);
                  MailAddrsViewControl.this.Nok.requestFocus();
                  ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                  paramAnonymous2View = MailAddrsViewControl.d(MailAddrsViewControl.this);
                  paramAnonymous2MotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymous2MotionEvent);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2View, paramAnonymous2MotionEvent.aYi(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2View.onTouchEvent((MotionEvent)paramAnonymous2MotionEvent.sb(0)), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  AppMethodBeat.o(123064);
                  return bool;
                }
              }
            });
            MailAddrsViewControl.this.gEK();
            MailAddrsViewControl.this.invalidate();
            AppMethodBeat.o(123065);
          }
        }, 100L);
      }
      AppMethodBeat.o(123092);
      return;
    }
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(123096);
    int i = 0;
    while (i < this.Noj.size())
    {
      k localk = (k)this.Noj.get(i);
      if (paramk.KbS.equalsIgnoreCase(localk.KbS))
      {
        removeViewAt(i);
        this.Noj.remove(i);
        gEK();
        invalidate();
        AppMethodBeat.o(123096);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(123096);
  }
  
  public final boolean gEG()
  {
    AppMethodBeat.i(123084);
    Editable localEditable = this.Nok.getText();
    if (localEditable != null)
    {
      if (localEditable.toString().length() <= 0)
      {
        AppMethodBeat.o(123084);
        return true;
      }
      AppMethodBeat.o(123084);
      return false;
    }
    AppMethodBeat.o(123084);
    return true;
  }
  
  public final boolean gEH()
  {
    AppMethodBeat.i(123089);
    String str = this.Nok.getEditableText().toString().trim();
    if ((!Util.isNullOrNil(str)) && (aSt(str)))
    {
      AppMethodBeat.o(123089);
      return true;
    }
    AppMethodBeat.o(123089);
    return false;
  }
  
  public final boolean gEJ()
  {
    AppMethodBeat.i(123098);
    Iterator localIterator = this.Noj.iterator();
    while (localIterator.hasNext()) {
      if (!aSt(((k)localIterator.next()).KbS))
      {
        AppMethodBeat.o(123098);
        return false;
      }
    }
    AppMethodBeat.o(123098);
    return true;
  }
  
  final void gEK()
  {
    AppMethodBeat.i(123099);
    int i2 = getChildCount();
    int i3 = getMeasuredWidth();
    int m = 0;
    int j = 0;
    int i = 0;
    View localView;
    int k;
    int i4;
    if (m < i2)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8)
      {
        k = j;
        n = i;
        if (!(localView instanceof AutoCompleteTextView)) {}
      }
      else
      {
        n = localView.getWidth();
        i4 = localView.getHeight();
        k = n;
        if (n == 0)
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
          k = localView.getMeasuredWidth();
        }
        if ((this.Nok == null) || (m != i2 - 1) || (this.Nok.isFocused())) {
          break label236;
        }
      }
    }
    label236:
    for (int n = 0;; n = k)
    {
      k = j;
      int i1 = i;
      if (i + n > i3)
      {
        k = j + i4;
        i1 = 0;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(i1, k, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      localView.setLayoutParams(localLayoutParams);
      n = i1 + n;
      localView.setVisibility(0);
      m += 1;
      j = k;
      i = n;
      break;
      AppMethodBeat.o(123099);
      return;
    }
  }
  
  public String getAddrsString()
  {
    AppMethodBeat.i(123090);
    if (gEH()) {
      cF(this.Nok.getEditableText().toString(), false);
    }
    String str1 = "";
    int i = 0;
    while (i < this.Noj.size())
    {
      k localk = (k)this.Noj.get(i);
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + ",";
      }
      str1 = str2 + localk.KbS;
      i += 1;
    }
    AppMethodBeat.o(123090);
    return str1;
  }
  
  public String[] getMailAddrStringArray()
  {
    AppMethodBeat.i(266986);
    String[] arrayOfString = new String[this.Noj.size()];
    int i = 0;
    while (i < this.Noj.size())
    {
      k localk = (k)this.Noj.get(i);
      arrayOfString[i] = (localk.name + " " + localk.KbS);
      i += 1;
    }
    AppMethodBeat.o(266986);
    return arrayOfString;
  }
  
  public LinkedList<k> getMailAddrs()
  {
    return this.Noj;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(123091);
    int i = this.Noj.size();
    AppMethodBeat.o(123091);
    return i;
  }
  
  public void setAddrsAdapter(MailAddrsViewControl.b paramb)
  {
    AppMethodBeat.i(123087);
    if ((this.Nok != null) && (paramb != null))
    {
      this.Nol = paramb;
      this.Nok.setAdapter(paramb);
    }
    AppMethodBeat.o(123087);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    AppMethodBeat.i(123086);
    this.qiO = paramBoolean;
    if ((paramBoolean) && (this.Nok == null))
    {
      int i = 0;
      for (;;)
      {
        Object localObject;
        if (i < getChildCount())
        {
          localObject = getChildAt(i);
          if (!(localObject instanceof AutoCompleteTextView)) {
            break label167;
          }
          this.Nok = ((AutoCompleteTextView)localObject);
        }
        label167:
        do
        {
          if (this.Nok == null) {
            break;
          }
          this.Nok.setDropDownBackgroundResource(e.d.qqmail_dropdown_thumb);
          setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(123063);
              b localb = new b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              MailAddrsViewControl.this.Nok.requestFocus();
              ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(123063);
            }
          });
          this.Nok.setOnItemClickListener(new MailAddrsViewControl.3(this));
          this.Nok.setOnEditorActionListener(new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123067);
              if (paramAnonymousInt == 5)
              {
                paramAnonymousTextView = MailAddrsViewControl.this.Nok.getEditableText().toString();
                if ((paramAnonymousTextView != null) && (paramAnonymousTextView.length() > 0))
                {
                  MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousTextView, false);
                  MailAddrsViewControl.this.gEK();
                }
              }
              AppMethodBeat.o(123067);
              return true;
            }
          });
          this.Nok.setOnKeyListener(new View.OnKeyListener()
          {
            public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123068);
              b localb = new b();
              localb.cH(paramAnonymousView);
              localb.sc(paramAnonymousInt);
              localb.cH(paramAnonymousKeyEvent);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
              if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0))
              {
                paramAnonymousView = MailAddrsViewControl.this.Nok.getEditableText().toString();
                if ((paramAnonymousView.length() == 0) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.this.c((k)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag());
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                  MailAddrsViewControl.this.gEK();
                }
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(123068);
                return false;
                if ((paramAnonymousView.length() == 0) && (MailAddrsViewControl.f(MailAddrsViewControl.this).size() > 0))
                {
                  paramAnonymousInt = MailAddrsViewControl.f(MailAddrsViewControl.this).size() - 1;
                  paramAnonymousView = MailAddrsViewControl.this.getChildAt(paramAnonymousInt);
                  if (!paramAnonymousView.isSelected())
                  {
                    paramAnonymousView.setSelected(true);
                  }
                  else
                  {
                    MailAddrsViewControl.this.c((k)MailAddrsViewControl.f(MailAddrsViewControl.this).get(paramAnonymousInt));
                    MailAddrsViewControl.this.gEK();
                    continue;
                    if ((paramAnonymousInt == 66) && (paramAnonymousKeyEvent.getAction() == 0))
                    {
                      paramAnonymousView = MailAddrsViewControl.this.Nok.getEditableText().toString();
                      if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                      {
                        MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, true);
                        MailAddrsViewControl.this.gEK();
                      }
                    }
                  }
                }
              }
            }
          });
          this.Nok.addTextChangedListener(new TextWatcher()
          {
            public final void afterTextChanged(Editable paramAnonymousEditable) {}
            
            public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(123069);
              paramAnonymousCharSequence = paramAnonymousCharSequence.toString();
              if ((paramAnonymousCharSequence.endsWith("\n")) || (paramAnonymousCharSequence.endsWith(" "))) {
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousCharSequence, true);
              }
              MailAddrsViewControl.this.gEK();
              AppMethodBeat.o(123069);
            }
          });
          this.Nok.setOnFocusChangeListener(new View.OnFocusChangeListener()
          {
            public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(123070);
              if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null) {
                MailAddrsViewControl.g(MailAddrsViewControl.this).AM(paramAnonymousBoolean);
              }
              paramAnonymousView = MailAddrsViewControl.this.Nok.getEditableText().toString();
              if ((!paramAnonymousBoolean) && (paramAnonymousView.trim().length() > 0)) {
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, false);
              }
              if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
              {
                MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(paramAnonymousBoolean);
                MailAddrsViewControl.a(MailAddrsViewControl.this, null);
              }
              MailAddrsViewControl.this.gEK();
              AppMethodBeat.o(123070);
            }
          });
          AppMethodBeat.o(123086);
          return;
          if ((localObject instanceof ViewGroup))
          {
            localObject = (ViewGroup)localObject;
            int j = 0;
            while (j < ((ViewGroup)localObject).getChildCount())
            {
              View localView = ((ViewGroup)localObject).getChildAt(j);
              if ((localView instanceof AutoCompleteTextView)) {
                this.Nok = ((AutoCompleteTextView)localView);
              }
              j += 1;
            }
          }
        } while (this.Nok != null);
        i += 1;
      }
    }
    if ((!paramBoolean) && (this.Nok != null)) {
      this.Nok.setVisibility(8);
    }
    AppMethodBeat.o(123086);
  }
  
  public void setInvalidMailAddrListener(a parama)
  {
    this.Noo = parama;
  }
  
  public void setMailAdds(List<k> paramList)
  {
    AppMethodBeat.i(123095);
    if (paramList == null)
    {
      AppMethodBeat.o(123095);
      return;
    }
    int i = 0;
    k localk1;
    int j;
    k localk2;
    while (i < this.Noj.size())
    {
      localk1 = (k)this.Noj.get(i);
      j = 0;
      while (j < paramList.size())
      {
        localk2 = (k)paramList.get(j);
        if (localk1.KbS.equalsIgnoreCase(localk2.KbS)) {
          break;
        }
        j += 1;
      }
      if (j == paramList.size()) {
        c(localk1);
      }
      i += 1;
    }
    i = 0;
    while (i < paramList.size())
    {
      localk1 = (k)paramList.get(i);
      j = 0;
      while (j < this.Noj.size())
      {
        localk2 = (k)this.Noj.get(j);
        if (localk1.KbS.equalsIgnoreCase(localk2.KbS)) {
          break;
        }
        j += 1;
      }
      if (j == this.Noj.size()) {
        b(localk1);
      }
      i += 1;
    }
    AppMethodBeat.o(123095);
  }
  
  public void setOnActionListener(c paramc)
  {
    this.Nom = paramc;
  }
  
  public final void y(List<k> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(266995);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(266995);
      return;
    }
    if (paramBoolean) {
      gEI();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((k)paramList.next());
    }
    AppMethodBeat.o(266995);
  }
  
  public static abstract interface a
  {
    public abstract void b(MailAddrsViewControl paramMailAddrsViewControl);
    
    public abstract void gEt();
  }
  
  public static abstract class c
  {
    public void AM(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl
 * JD-Core Version:    0.7.0.1
 */