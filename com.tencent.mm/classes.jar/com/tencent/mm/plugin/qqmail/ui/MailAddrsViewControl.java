package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAddrsViewControl
  extends RelativeLayout
{
  private static final Pattern xgn;
  private ap handler;
  private boolean jsK;
  private GestureDetector xfv;
  private LinkedList<l> xgh;
  AutoCompleteTextView xgi;
  private b xgj;
  private c xgk;
  private View xgl;
  private a xgm;
  private GestureDetector.SimpleOnGestureListener xgo;
  
  static
  {
    AppMethodBeat.i(123102);
    xgn = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    AppMethodBeat.o(123102);
  }
  
  public MailAddrsViewControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123085);
    this.jsK = false;
    this.xgh = new LinkedList();
    this.handler = new ap();
    this.xgm = null;
    this.xgo = new GestureDetector.SimpleOnGestureListener()
    {
      private void dCS()
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
        ((Intent)localObject1).putExtra("addr", ((l)localObject2).uZn);
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("can_compose", bool);
          localObject2 = MailAddrsViewControl.this.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(123071);
          return;
        }
      }
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(215313);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(215313);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123074);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        dCS();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123074);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123073);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {
          dCS();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123072);
        return true;
      }
    };
    this.xfv = new GestureDetector(paramContext, this.xgo);
    AppMethodBeat.o(123085);
  }
  
  private static boolean avd(String paramString)
  {
    AppMethodBeat.i(123097);
    boolean bool = xgn.matcher(paramString).matches();
    AppMethodBeat.o(123097);
    return bool;
  }
  
  private void bC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123100);
    paramString = paramString.trim();
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(123100);
      return;
    }
    Object localObject = ((k)g.ad(k.class)).getNormalMailAppService().xbZ.auW(paramString);
    if (((List)localObject).size() > 0)
    {
      b((l)((List)localObject).get(0));
      this.xgi.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (avd(paramString))
    {
      localObject = new l();
      ((l)localObject).name = paramString;
      ((l)localObject).uZn = paramString;
      ((l)localObject).xbF = 0;
      b((l)localObject);
      this.xgi.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (paramBoolean)
    {
      if (this.xgm != null) {
        this.xgm.dCC();
      }
      for (;;)
      {
        this.xgi.setText(paramString);
        this.xgi.setSelection(paramString.length());
        AppMethodBeat.o(123100);
        return;
        Toast.makeText(getContext(), 2131761980, 2000).show();
      }
    }
    if (this.xgm != null) {
      this.xgm.b(this);
    }
    AppMethodBeat.o(123100);
  }
  
  private void dCP()
  {
    AppMethodBeat.i(177331);
    removeAllViews();
    this.xgh.clear();
    dCR();
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
    Object localObject1 = this.xgh.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((l)((Iterator)localObject1).next()).uZn.equalsIgnoreCase(paraml.uZn));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = (ViewGroup)View.inflate(getContext(), 2131495156, null);
        localObject1 = (Button)((ViewGroup)localObject2).findViewById(2131303603);
        ((ViewGroup)localObject2).removeView((View)((Button)localObject1).getParent());
        ((Button)localObject1).setText(paraml.name);
        if (this.jsK) {
          ((Button)localObject1).setCompoundDrawables(null, null, null, null);
        }
        ((Button)localObject1).setTag(this.xgh.size());
        localObject2 = (View)((Button)localObject1).getParent();
        ((Button)localObject1).setTag(paraml);
        ((View)localObject2).setVisibility(4);
        ((View)localObject2).setTag(paraml);
        addView((View)localObject2, this.xgh.size());
        this.xgh.add(paraml);
        this.handler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123065);
            this.xgq.invalidate();
            this.xgq.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
              {
                AppMethodBeat.i(123064);
                b localb = new b();
                localb.bd(paramAnonymous2View);
                localb.bd(paramAnonymous2MotionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
                if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != paramAnonymous2View) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(false);
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                }
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymous2View);
                if ((MailAddrsViewControl.this.xgi != null) && (paramAnonymous2MotionEvent.getAction() == 0))
                {
                  paramAnonymous2View = MailAddrsViewControl.2.this.xgq;
                  if (MailAddrsViewControl.2.this.xgq.isSelected()) {
                    break label315;
                  }
                }
                label315:
                for (boolean bool = true;; bool = false)
                {
                  paramAnonymous2View.setSelected(bool);
                  MailAddrsViewControl.this.xgi.setVisibility(0);
                  MailAddrsViewControl.this.xgi.requestFocus();
                  ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                  paramAnonymous2View = MailAddrsViewControl.d(MailAddrsViewControl.this);
                  paramAnonymous2MotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymous2MotionEvent);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2MotionEvent.ahp(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2View.onTouchEvent((MotionEvent)paramAnonymous2MotionEvent.mq(0)), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                  AppMethodBeat.o(123064);
                  return bool;
                }
              }
            });
            MailAddrsViewControl.this.dCR();
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
    while (i < this.xgh.size())
    {
      l locall = (l)this.xgh.get(i);
      if (paraml.uZn.equalsIgnoreCase(locall.uZn))
      {
        removeViewAt(i);
        this.xgh.remove(i);
        dCR();
        invalidate();
        AppMethodBeat.o(123096);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(123096);
  }
  
  public final boolean dCN()
  {
    AppMethodBeat.i(123084);
    Editable localEditable = this.xgi.getText();
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
  
  public final boolean dCO()
  {
    AppMethodBeat.i(123089);
    String str = this.xgi.getEditableText().toString().trim();
    if ((!bt.isNullOrNil(str)) && (avd(str)))
    {
      AppMethodBeat.o(123089);
      return true;
    }
    AppMethodBeat.o(123089);
    return false;
  }
  
  public final boolean dCQ()
  {
    AppMethodBeat.i(123098);
    Iterator localIterator = this.xgh.iterator();
    while (localIterator.hasNext()) {
      if (!avd(((l)localIterator.next()).uZn))
      {
        AppMethodBeat.o(123098);
        return false;
      }
    }
    AppMethodBeat.o(123098);
    return true;
  }
  
  final void dCR()
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
        if ((this.xgi == null) || (m != i2 - 1) || (this.xgi.isFocused())) {
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
    AppMethodBeat.i(215315);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(215315);
      return;
    }
    if (paramBoolean) {
      dCP();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((l)paramList.next());
    }
    AppMethodBeat.o(215315);
  }
  
  public String getAddrsString()
  {
    AppMethodBeat.i(123090);
    if (dCO()) {
      bC(this.xgi.getEditableText().toString(), false);
    }
    String str1 = "";
    int i = 0;
    while (i < this.xgh.size())
    {
      l locall = (l)this.xgh.get(i);
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + ",";
      }
      str1 = str2 + locall.uZn;
      i += 1;
    }
    AppMethodBeat.o(123090);
    return str1;
  }
  
  public String[] getMailAddrStringArray()
  {
    AppMethodBeat.i(215314);
    String[] arrayOfString = new String[this.xgh.size()];
    int i = 0;
    while (i < this.xgh.size())
    {
      l locall = (l)this.xgh.get(i);
      arrayOfString[i] = (locall.name + " " + locall.uZn);
      i += 1;
    }
    AppMethodBeat.o(215314);
    return arrayOfString;
  }
  
  public LinkedList<l> getMailAddrs()
  {
    return this.xgh;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(123091);
    int i = this.xgh.size();
    AppMethodBeat.o(123091);
    return i;
  }
  
  public void setAddrsAdapter(b paramb)
  {
    AppMethodBeat.i(123087);
    if ((this.xgi != null) && (paramb != null))
    {
      this.xgj = paramb;
      this.xgi.setAdapter(paramb);
    }
    AppMethodBeat.o(123087);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    AppMethodBeat.i(123086);
    this.jsK = paramBoolean;
    if ((paramBoolean) && (this.xgi == null))
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
          this.xgi = ((AutoCompleteTextView)localObject);
        }
        label167:
        do
        {
          if (this.xgi == null) {
            break;
          }
          this.xgi.setDropDownBackgroundResource(2131233704);
          setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(123063);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              MailAddrsViewControl.this.xgi.requestFocus();
              ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(123063);
            }
          });
          this.xgi.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(123066);
              b localb = new b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mr(paramAnonymousInt);
              localb.qY(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
              paramAnonymousAdapterView = MailAddrsViewControl.e(MailAddrsViewControl.this).Nn(paramAnonymousInt);
              MailAddrsViewControl.this.b(paramAnonymousAdapterView);
              MailAddrsViewControl.this.xgi.setText("");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(123066);
            }
          });
          this.xgi.setOnEditorActionListener(new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123067);
              if (paramAnonymousInt == 5)
              {
                paramAnonymousTextView = MailAddrsViewControl.this.xgi.getEditableText().toString();
                if ((paramAnonymousTextView != null) && (paramAnonymousTextView.length() > 0))
                {
                  MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousTextView, false);
                  MailAddrsViewControl.this.dCR();
                }
              }
              AppMethodBeat.o(123067);
              return true;
            }
          });
          this.xgi.setOnKeyListener(new View.OnKeyListener()
          {
            public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123068);
              b localb = new b();
              localb.bd(paramAnonymousView);
              localb.mr(paramAnonymousInt);
              localb.bd(paramAnonymousKeyEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
              if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0))
              {
                paramAnonymousView = MailAddrsViewControl.this.xgi.getEditableText().toString();
                if ((paramAnonymousView.length() == 0) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.this.c((l)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag());
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                  MailAddrsViewControl.this.dCR();
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
                    MailAddrsViewControl.this.dCR();
                    continue;
                    if ((paramAnonymousInt == 66) && (paramAnonymousKeyEvent.getAction() == 0))
                    {
                      paramAnonymousView = MailAddrsViewControl.this.xgi.getEditableText().toString();
                      if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                      {
                        MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, true);
                        MailAddrsViewControl.this.dCR();
                      }
                    }
                  }
                }
              }
            }
          });
          this.xgi.addTextChangedListener(new TextWatcher()
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
              MailAddrsViewControl.this.dCR();
              AppMethodBeat.o(123069);
            }
          });
          this.xgi.setOnFocusChangeListener(new View.OnFocusChangeListener()
          {
            public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(123070);
              if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null) {
                MailAddrsViewControl.g(MailAddrsViewControl.this).pz(paramAnonymousBoolean);
              }
              paramAnonymousView = MailAddrsViewControl.this.xgi.getEditableText().toString();
              if ((!paramAnonymousBoolean) && (paramAnonymousView.trim().length() > 0)) {
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, false);
              }
              if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
              {
                MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(paramAnonymousBoolean);
                MailAddrsViewControl.a(MailAddrsViewControl.this, null);
              }
              MailAddrsViewControl.this.dCR();
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
                this.xgi = ((AutoCompleteTextView)localView);
              }
              j += 1;
            }
          }
        } while (this.xgi != null);
        i += 1;
      }
    }
    if ((!paramBoolean) && (this.xgi != null)) {
      this.xgi.setVisibility(8);
    }
    AppMethodBeat.o(123086);
  }
  
  public void setInvalidMailAddrListener(a parama)
  {
    this.xgm = parama;
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
    while (i < this.xgh.size())
    {
      locall1 = (l)this.xgh.get(i);
      j = 0;
      while (j < paramList.size())
      {
        locall2 = (l)paramList.get(j);
        if (locall1.uZn.equalsIgnoreCase(locall2.uZn)) {
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
      while (j < this.xgh.size())
      {
        locall2 = (l)this.xgh.get(j);
        if (locall1.uZn.equalsIgnoreCase(locall2.uZn)) {
          break;
        }
        j += 1;
      }
      if (j == this.xgh.size()) {
        b(locall1);
      }
      i += 1;
    }
    AppMethodBeat.o(123095);
  }
  
  public void setOnActionListener(c paramc)
  {
    this.xgk = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void b(MailAddrsViewControl paramMailAddrsViewControl);
    
    public abstract void dCC();
  }
  
  public static final class b
    extends BaseAdapter
    implements Filterable
  {
    private List<l> jiW;
    private ArrayList<l> jiX;
    private Context mContext;
    private final Object mLock;
    private boolean xgs;
    private a xgt;
    
    public b(Context paramContext, List<l> paramList)
    {
      AppMethodBeat.i(123077);
      this.mLock = new Object();
      this.xgs = true;
      this.mContext = paramContext;
      this.jiW = paramList;
      AppMethodBeat.o(123077);
    }
    
    public final l Nn(int paramInt)
    {
      AppMethodBeat.i(123080);
      l locall = (l)this.jiW.get(paramInt);
      AppMethodBeat.o(123080);
      return locall;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(123079);
      int i = this.jiW.size();
      AppMethodBeat.o(123079);
      return i;
    }
    
    public final Filter getFilter()
    {
      AppMethodBeat.i(123082);
      if (this.xgt == null) {
        this.xgt = new a((byte)0);
      }
      a locala = this.xgt;
      AppMethodBeat.o(123082);
      return locala;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(123081);
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, 2131495158, null);
        paramViewGroup = new b((byte)0);
        paramViewGroup.jfJ = ((TextView)paramView.findViewById(2131303579));
        paramViewGroup.xgd = ((TextView)paramView.findViewById(2131303576));
        paramViewGroup.xgv = ((CheckBox)paramView.findViewById(2131303580));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup = Nn(paramInt);
        b localb = (b)paramView.getTag();
        localb.jfJ.setText(paramViewGroup.name);
        localb.xgd.setText(paramViewGroup.uZn);
        localb.xgv.setVisibility(8);
        paramView.setBackgroundColor(this.mContext.getResources().getColor(2131101179));
        AppMethodBeat.o(123081);
        return paramView;
        paramView = (ViewGroup)paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(123078);
      super.notifyDataSetChanged();
      this.xgs = true;
      AppMethodBeat.o(123078);
    }
    
    final class a
      extends Filter
    {
      private a() {}
      
      protected final Filter.FilterResults performFiltering(CharSequence arg1)
      {
        AppMethodBeat.i(123075);
        Filter.FilterResults localFilterResults = new Filter.FilterResults();
        if (MailAddrsViewControl.b.a(MailAddrsViewControl.b.this) == null) {}
        synchronized (MailAddrsViewControl.b.b(MailAddrsViewControl.b.this))
        {
          MailAddrsViewControl.b.a(MailAddrsViewControl.b.this, new ArrayList(MailAddrsViewControl.b.c(MailAddrsViewControl.b.this)));
          if (??? != null) {
            if (???.length() != 0) {
              break label150;
            }
          }
        }
        for (;;)
        {
          synchronized (MailAddrsViewControl.b.b(MailAddrsViewControl.b.this))
          {
            ??? = new ArrayList(MailAddrsViewControl.b.a(MailAddrsViewControl.b.this));
            localFilterResults.values = ???;
            localFilterResults.count = ((ArrayList)???).size();
            AppMethodBeat.o(123075);
            return localFilterResults;
            ??? = finally;
            AppMethodBeat.o(123075);
            throw ???;
          }
          label150:
          ??? = ???.toString().toLowerCase();
          ??? = MailAddrsViewControl.b.a(MailAddrsViewControl.b.this);
          int j = ((ArrayList)???).size();
          ArrayList localArrayList = new ArrayList(j);
          int i = 0;
          while (i < j)
          {
            l locall = (l)((ArrayList)???).get(i);
            if ((locall.name.toLowerCase().contains(???)) || (locall.uZn.toLowerCase().contains(???))) {
              localArrayList.add(locall);
            }
            i += 1;
          }
          localObject1.values = localArrayList;
          localObject1.count = localArrayList.size();
        }
      }
      
      protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
      {
        AppMethodBeat.i(123076);
        MailAddrsViewControl.b.a(MailAddrsViewControl.b.this, (List)paramFilterResults.values);
        if (paramFilterResults.count > 0)
        {
          MailAddrsViewControl.b.this.notifyDataSetChanged();
          AppMethodBeat.o(123076);
          return;
        }
        MailAddrsViewControl.b.a(MailAddrsViewControl.b.this, new ArrayList(MailAddrsViewControl.b.a(MailAddrsViewControl.b.this)));
        MailAddrsViewControl.b.this.notifyDataSetInvalidated();
        AppMethodBeat.o(123076);
      }
    }
    
    final class b
    {
      TextView jfJ;
      TextView xgd;
      CheckBox xgv;
      
      private b() {}
    }
  }
  
  public static abstract class c
  {
    public void pz(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl
 * JD-Core Version:    0.7.0.1
 */