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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAddrsViewControl
  extends RelativeLayout
{
  private static final Pattern xwf;
  private aq handler;
  private boolean jvD;
  private LinkedList<l> xvZ;
  private GestureDetector xvn;
  AutoCompleteTextView xwa;
  private MailAddrsViewControl.b xwb;
  private c xwc;
  private View xwd;
  private a xwe;
  private GestureDetector.SimpleOnGestureListener xwg;
  
  static
  {
    AppMethodBeat.i(123102);
    xwf = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    AppMethodBeat.o(123102);
  }
  
  public MailAddrsViewControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123085);
    this.jvD = false;
    this.xvZ = new LinkedList();
    this.handler = new aq();
    this.xwe = null;
    this.xwg = new GestureDetector.SimpleOnGestureListener()
    {
      private void dGj()
      {
        AppMethodBeat.i(123071);
        Object localObject2 = (l)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag();
        if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null)
        {
          MailAddrsViewControl.g(MailAddrsViewControl.this);
          MailAddrsViewControl.c(MailAddrsViewControl.this);
        }
        Object localObject1 = new Intent(MailAddrsViewControl.this.getContext(), MailAddrProfileUI.class);
        ((Intent)localObject1).putExtra("name", ((l)localObject2).name);
        ((Intent)localObject1).putExtra("addr", ((l)localObject2).vly);
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("can_compose", bool);
          localObject2 = MailAddrsViewControl.this.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(123071);
          return;
        }
      }
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(218060);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(218060);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123074);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        dGj();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123074);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123073);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
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
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {
          dGj();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123072);
        return true;
      }
    };
    this.xvn = new GestureDetector(paramContext, this.xwg);
    AppMethodBeat.o(123085);
  }
  
  private static boolean aws(String paramString)
  {
    AppMethodBeat.i(123097);
    boolean bool = xwf.matcher(paramString).matches();
    AppMethodBeat.o(123097);
    return bool;
  }
  
  private void bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123100);
    paramString = paramString.trim();
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(123100);
      return;
    }
    Object localObject = ((k)g.ad(k.class)).getNormalMailAppService().xrQ.awl(paramString);
    if (((List)localObject).size() > 0)
    {
      b((l)((List)localObject).get(0));
      this.xwa.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (aws(paramString))
    {
      localObject = new l();
      ((l)localObject).name = paramString;
      ((l)localObject).vly = paramString;
      ((l)localObject).xrw = 0;
      b((l)localObject);
      this.xwa.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (paramBoolean)
    {
      if (this.xwe != null) {
        this.xwe.dFT();
      }
      for (;;)
      {
        this.xwa.setText(paramString);
        this.xwa.setSelection(paramString.length());
        AppMethodBeat.o(123100);
        return;
        Toast.makeText(getContext(), 2131761980, 2000).show();
      }
    }
    if (this.xwe != null) {
      this.xwe.b(this);
    }
    AppMethodBeat.o(123100);
  }
  
  private void dGg()
  {
    AppMethodBeat.i(177331);
    removeAllViews();
    this.xvZ.clear();
    dGi();
    invalidate();
    AppMethodBeat.o(177331);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(123092);
    if (paraml == null)
    {
      AppMethodBeat.o(123092);
      return;
    }
    Object localObject1 = this.xvZ.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((l)((Iterator)localObject1).next()).vly.equalsIgnoreCase(paraml.vly));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = (ViewGroup)View.inflate(getContext(), 2131495156, null);
        localObject1 = (Button)((ViewGroup)localObject2).findViewById(2131303603);
        ((ViewGroup)localObject2).removeView((View)((Button)localObject1).getParent());
        ((Button)localObject1).setText(paraml.name);
        if (this.jvD) {
          ((Button)localObject1).setCompoundDrawables(null, null, null, null);
        }
        ((Button)localObject1).setTag(this.xvZ.size());
        localObject2 = (View)((Button)localObject1).getParent();
        ((Button)localObject1).setTag(paraml);
        ((View)localObject2).setVisibility(4);
        ((View)localObject2).setTag(paraml);
        addView((View)localObject2, this.xvZ.size());
        this.xvZ.add(paraml);
        this.handler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123065);
            this.xwi.invalidate();
            this.xwi.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
              {
                AppMethodBeat.i(123064);
                b localb = new b();
                localb.bd(paramAnonymous2View);
                localb.bd(paramAnonymous2MotionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
                if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != paramAnonymous2View) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(false);
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                }
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymous2View);
                if ((MailAddrsViewControl.this.xwa != null) && (paramAnonymous2MotionEvent.getAction() == 0))
                {
                  paramAnonymous2View = MailAddrsViewControl.2.this.xwi;
                  if (MailAddrsViewControl.2.this.xwi.isSelected()) {
                    break label315;
                  }
                }
                label315:
                for (boolean bool = true;; bool = false)
                {
                  paramAnonymous2View.setSelected(bool);
                  MailAddrsViewControl.this.xwa.setVisibility(0);
                  MailAddrsViewControl.this.xwa.requestFocus();
                  ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                  paramAnonymous2View = MailAddrsViewControl.d(MailAddrsViewControl.this);
                  paramAnonymous2MotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2MotionEvent);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2MotionEvent.ahE(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2View.onTouchEvent((MotionEvent)paramAnonymous2MotionEvent.mt(0)), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                  AppMethodBeat.o(123064);
                  return bool;
                }
              }
            });
            MailAddrsViewControl.this.dGi();
            MailAddrsViewControl.this.invalidate();
            AppMethodBeat.o(123065);
          }
        }, 100L);
      }
      AppMethodBeat.o(123092);
      return;
    }
  }
  
  public final void c(l paraml)
  {
    AppMethodBeat.i(123096);
    int i = 0;
    while (i < this.xvZ.size())
    {
      l locall = (l)this.xvZ.get(i);
      if (paraml.vly.equalsIgnoreCase(locall.vly))
      {
        removeViewAt(i);
        this.xvZ.remove(i);
        dGi();
        invalidate();
        AppMethodBeat.o(123096);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(123096);
  }
  
  public final boolean dGe()
  {
    AppMethodBeat.i(123084);
    Editable localEditable = this.xwa.getText();
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
  
  public final boolean dGf()
  {
    AppMethodBeat.i(123089);
    String str = this.xwa.getEditableText().toString().trim();
    if ((!bu.isNullOrNil(str)) && (aws(str)))
    {
      AppMethodBeat.o(123089);
      return true;
    }
    AppMethodBeat.o(123089);
    return false;
  }
  
  public final boolean dGh()
  {
    AppMethodBeat.i(123098);
    Iterator localIterator = this.xvZ.iterator();
    while (localIterator.hasNext()) {
      if (!aws(((l)localIterator.next()).vly))
      {
        AppMethodBeat.o(123098);
        return false;
      }
    }
    AppMethodBeat.o(123098);
    return true;
  }
  
  final void dGi()
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
        if ((this.xwa == null) || (m != i2 - 1) || (this.xwa.isFocused())) {
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
  
  public final void f(List<l> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(218062);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(218062);
      return;
    }
    if (paramBoolean) {
      dGg();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((l)paramList.next());
    }
    AppMethodBeat.o(218062);
  }
  
  public String getAddrsString()
  {
    AppMethodBeat.i(123090);
    if (dGf()) {
      bG(this.xwa.getEditableText().toString(), false);
    }
    String str1 = "";
    int i = 0;
    while (i < this.xvZ.size())
    {
      l locall = (l)this.xvZ.get(i);
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + ",";
      }
      str1 = str2 + locall.vly;
      i += 1;
    }
    AppMethodBeat.o(123090);
    return str1;
  }
  
  public String[] getMailAddrStringArray()
  {
    AppMethodBeat.i(218061);
    String[] arrayOfString = new String[this.xvZ.size()];
    int i = 0;
    while (i < this.xvZ.size())
    {
      l locall = (l)this.xvZ.get(i);
      arrayOfString[i] = (locall.name + " " + locall.vly);
      i += 1;
    }
    AppMethodBeat.o(218061);
    return arrayOfString;
  }
  
  public LinkedList<l> getMailAddrs()
  {
    return this.xvZ;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(123091);
    int i = this.xvZ.size();
    AppMethodBeat.o(123091);
    return i;
  }
  
  public void setAddrsAdapter(MailAddrsViewControl.b paramb)
  {
    AppMethodBeat.i(123087);
    if ((this.xwa != null) && (paramb != null))
    {
      this.xwb = paramb;
      this.xwa.setAdapter(paramb);
    }
    AppMethodBeat.o(123087);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    AppMethodBeat.i(123086);
    this.jvD = paramBoolean;
    if ((paramBoolean) && (this.xwa == null))
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
          this.xwa = ((AutoCompleteTextView)localObject);
        }
        label167:
        do
        {
          if (this.xwa == null) {
            break;
          }
          this.xwa.setDropDownBackgroundResource(2131233704);
          setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(123063);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              MailAddrsViewControl.this.xwa.requestFocus();
              ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(123063);
            }
          });
          this.xwa.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(123066);
              b localb = new b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mu(paramAnonymousInt);
              localb.rl(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
              paramAnonymousAdapterView = MailAddrsViewControl.e(MailAddrsViewControl.this).NT(paramAnonymousInt);
              MailAddrsViewControl.this.b(paramAnonymousAdapterView);
              MailAddrsViewControl.this.xwa.setText("");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(123066);
            }
          });
          this.xwa.setOnEditorActionListener(new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123067);
              if (paramAnonymousInt == 5)
              {
                paramAnonymousTextView = MailAddrsViewControl.this.xwa.getEditableText().toString();
                if ((paramAnonymousTextView != null) && (paramAnonymousTextView.length() > 0))
                {
                  MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousTextView, false);
                  MailAddrsViewControl.this.dGi();
                }
              }
              AppMethodBeat.o(123067);
              return true;
            }
          });
          this.xwa.setOnKeyListener(new View.OnKeyListener()
          {
            public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123068);
              b localb = new b();
              localb.bd(paramAnonymousView);
              localb.mu(paramAnonymousInt);
              localb.bd(paramAnonymousKeyEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
              if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0))
              {
                paramAnonymousView = MailAddrsViewControl.this.xwa.getEditableText().toString();
                if ((paramAnonymousView.length() == 0) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.this.c((l)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag());
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                  MailAddrsViewControl.this.dGi();
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
                    MailAddrsViewControl.this.c((l)MailAddrsViewControl.f(MailAddrsViewControl.this).get(paramAnonymousInt));
                    MailAddrsViewControl.this.dGi();
                    continue;
                    if ((paramAnonymousInt == 66) && (paramAnonymousKeyEvent.getAction() == 0))
                    {
                      paramAnonymousView = MailAddrsViewControl.this.xwa.getEditableText().toString();
                      if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                      {
                        MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, true);
                        MailAddrsViewControl.this.dGi();
                      }
                    }
                  }
                }
              }
            }
          });
          this.xwa.addTextChangedListener(new TextWatcher()
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
              MailAddrsViewControl.this.dGi();
              AppMethodBeat.o(123069);
            }
          });
          this.xwa.setOnFocusChangeListener(new View.OnFocusChangeListener()
          {
            public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(123070);
              if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null) {
                MailAddrsViewControl.g(MailAddrsViewControl.this).pH(paramAnonymousBoolean);
              }
              paramAnonymousView = MailAddrsViewControl.this.xwa.getEditableText().toString();
              if ((!paramAnonymousBoolean) && (paramAnonymousView.trim().length() > 0)) {
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, false);
              }
              if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
              {
                MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(paramAnonymousBoolean);
                MailAddrsViewControl.a(MailAddrsViewControl.this, null);
              }
              MailAddrsViewControl.this.dGi();
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
                this.xwa = ((AutoCompleteTextView)localView);
              }
              j += 1;
            }
          }
        } while (this.xwa != null);
        i += 1;
      }
    }
    if ((!paramBoolean) && (this.xwa != null)) {
      this.xwa.setVisibility(8);
    }
    AppMethodBeat.o(123086);
  }
  
  public void setInvalidMailAddrListener(a parama)
  {
    this.xwe = parama;
  }
  
  public void setMailAdds(List<l> paramList)
  {
    AppMethodBeat.i(123095);
    if (paramList == null)
    {
      AppMethodBeat.o(123095);
      return;
    }
    int i = 0;
    l locall1;
    int j;
    l locall2;
    while (i < this.xvZ.size())
    {
      locall1 = (l)this.xvZ.get(i);
      j = 0;
      while (j < paramList.size())
      {
        locall2 = (l)paramList.get(j);
        if (locall1.vly.equalsIgnoreCase(locall2.vly)) {
          break;
        }
        j += 1;
      }
      if (j == paramList.size()) {
        c(locall1);
      }
      i += 1;
    }
    i = 0;
    while (i < paramList.size())
    {
      locall1 = (l)paramList.get(i);
      j = 0;
      while (j < this.xvZ.size())
      {
        locall2 = (l)this.xvZ.get(j);
        if (locall1.vly.equalsIgnoreCase(locall2.vly)) {
          break;
        }
        j += 1;
      }
      if (j == this.xvZ.size()) {
        b(locall1);
      }
      i += 1;
    }
    AppMethodBeat.o(123095);
  }
  
  public void setOnActionListener(c paramc)
  {
    this.xwc = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void b(MailAddrsViewControl paramMailAddrsViewControl);
    
    public abstract void dFT();
  }
  
  public static abstract class c
  {
    public void pH(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl
 * JD-Core Version:    0.7.0.1
 */