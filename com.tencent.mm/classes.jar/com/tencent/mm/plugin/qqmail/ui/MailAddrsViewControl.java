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
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAddrsViewControl
  extends RelativeLayout
{
  private static final Pattern Bwg;
  private GestureDetector Bvq;
  private LinkedList<l> Bwa;
  AutoCompleteTextView Bwb;
  private b Bwc;
  private c Bwd;
  private View Bwe;
  private a Bwf;
  private GestureDetector.SimpleOnGestureListener Bwh;
  private MMHandler handler;
  private boolean ktR;
  
  static
  {
    AppMethodBeat.i(123102);
    Bwg = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    AppMethodBeat.o(123102);
  }
  
  public MailAddrsViewControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123085);
    this.ktR = false;
    this.Bwa = new LinkedList();
    this.handler = new MMHandler();
    this.Bwf = null;
    this.Bwh = new GestureDetector.SimpleOnGestureListener()
    {
      private void eGX()
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
        ((Intent)localObject1).putExtra("addr", ((l)localObject2).yFq);
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("can_compose", bool);
          localObject2 = MailAddrsViewControl.this.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(123071);
          return;
        }
      }
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198716);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198716);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123074);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        eGX();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123074);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123073);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {
          eGX();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123072);
        return true;
      }
    };
    this.Bvq = new GestureDetector(paramContext, this.Bwh);
    AppMethodBeat.o(123085);
  }
  
  private static boolean aKK(String paramString)
  {
    AppMethodBeat.i(123097);
    boolean bool = Bwg.matcher(paramString).matches();
    AppMethodBeat.o(123097);
    return bool;
  }
  
  private void bW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123100);
    paramString = paramString.trim();
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(123100);
      return;
    }
    Object localObject = ((k)g.ah(k.class)).getNormalMailAppService().BrU.aKD(paramString);
    if (((List)localObject).size() > 0)
    {
      b((l)((List)localObject).get(0));
      this.Bwb.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (aKK(paramString))
    {
      localObject = new l();
      ((l)localObject).name = paramString;
      ((l)localObject).yFq = paramString;
      ((l)localObject).Bry = 0;
      b((l)localObject);
      this.Bwb.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (paramBoolean)
    {
      if (this.Bwf != null) {
        this.Bwf.eGH();
      }
      for (;;)
      {
        this.Bwb.setText(paramString);
        this.Bwb.setSelection(paramString.length());
        AppMethodBeat.o(123100);
        return;
        Toast.makeText(getContext(), 2131763986, 2000).show();
      }
    }
    if (this.Bwf != null) {
      this.Bwf.b(this);
    }
    AppMethodBeat.o(123100);
  }
  
  private void eGU()
  {
    AppMethodBeat.i(177331);
    removeAllViews();
    this.Bwa.clear();
    eGW();
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
    Object localObject1 = this.Bwa.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((l)((Iterator)localObject1).next()).yFq.equalsIgnoreCase(paraml.yFq));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = (ViewGroup)View.inflate(getContext(), 2131495999, null);
        localObject1 = (Button)((ViewGroup)localObject2).findViewById(2131306380);
        ((ViewGroup)localObject2).removeView((View)((Button)localObject1).getParent());
        ((Button)localObject1).setText(paraml.name);
        if (this.ktR) {
          ((Button)localObject1).setCompoundDrawables(null, null, null, null);
        }
        ((Button)localObject1).setTag(this.Bwa.size());
        localObject2 = (View)((Button)localObject1).getParent();
        ((Button)localObject1).setTag(paraml);
        ((View)localObject2).setVisibility(4);
        ((View)localObject2).setTag(paraml);
        addView((View)localObject2, this.Bwa.size());
        this.Bwa.add(paraml);
        this.handler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123065);
            this.Bwj.invalidate();
            this.Bwj.setOnTouchListener(new View.OnTouchListener()
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
                if ((MailAddrsViewControl.this.Bwb != null) && (paramAnonymous2MotionEvent.getAction() == 0))
                {
                  paramAnonymous2View = MailAddrsViewControl.2.this.Bwj;
                  if (MailAddrsViewControl.2.this.Bwj.isSelected()) {
                    break label264;
                  }
                }
                label264:
                for (boolean bool = true;; bool = false)
                {
                  paramAnonymous2View.setSelected(bool);
                  MailAddrsViewControl.this.Bwb.setVisibility(0);
                  MailAddrsViewControl.this.Bwb.requestFocus();
                  ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                  paramAnonymous2View = MailAddrsViewControl.d(MailAddrsViewControl.this);
                  paramAnonymous2MotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymous2MotionEvent);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2MotionEvent.axQ(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2View.onTouchEvent((MotionEvent)paramAnonymous2MotionEvent.pG(0)), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  AppMethodBeat.o(123064);
                  return bool;
                }
              }
            });
            MailAddrsViewControl.this.eGW();
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
    while (i < this.Bwa.size())
    {
      l locall = (l)this.Bwa.get(i);
      if (paraml.yFq.equalsIgnoreCase(locall.yFq))
      {
        removeViewAt(i);
        this.Bwa.remove(i);
        eGW();
        invalidate();
        AppMethodBeat.o(123096);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(123096);
  }
  
  public final boolean eGS()
  {
    AppMethodBeat.i(123084);
    Editable localEditable = this.Bwb.getText();
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
  
  public final boolean eGT()
  {
    AppMethodBeat.i(123089);
    String str = this.Bwb.getEditableText().toString().trim();
    if ((!Util.isNullOrNil(str)) && (aKK(str)))
    {
      AppMethodBeat.o(123089);
      return true;
    }
    AppMethodBeat.o(123089);
    return false;
  }
  
  public final boolean eGV()
  {
    AppMethodBeat.i(123098);
    Iterator localIterator = this.Bwa.iterator();
    while (localIterator.hasNext()) {
      if (!aKK(((l)localIterator.next()).yFq))
      {
        AppMethodBeat.o(123098);
        return false;
      }
    }
    AppMethodBeat.o(123098);
    return true;
  }
  
  final void eGW()
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
        if ((this.Bwb == null) || (m != i2 - 1) || (this.Bwb.isFocused())) {
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
    if (eGT()) {
      bW(this.Bwb.getEditableText().toString(), false);
    }
    String str1 = "";
    int i = 0;
    while (i < this.Bwa.size())
    {
      l locall = (l)this.Bwa.get(i);
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + ",";
      }
      str1 = str2 + locall.yFq;
      i += 1;
    }
    AppMethodBeat.o(123090);
    return str1;
  }
  
  public String[] getMailAddrStringArray()
  {
    AppMethodBeat.i(198717);
    String[] arrayOfString = new String[this.Bwa.size()];
    int i = 0;
    while (i < this.Bwa.size())
    {
      l locall = (l)this.Bwa.get(i);
      arrayOfString[i] = (locall.name + " " + locall.yFq);
      i += 1;
    }
    AppMethodBeat.o(198717);
    return arrayOfString;
  }
  
  public LinkedList<l> getMailAddrs()
  {
    return this.Bwa;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(123091);
    int i = this.Bwa.size();
    AppMethodBeat.o(123091);
    return i;
  }
  
  public final void j(List<l> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(198718);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(198718);
      return;
    }
    if (paramBoolean) {
      eGU();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((l)paramList.next());
    }
    AppMethodBeat.o(198718);
  }
  
  public void setAddrsAdapter(b paramb)
  {
    AppMethodBeat.i(123087);
    if ((this.Bwb != null) && (paramb != null))
    {
      this.Bwc = paramb;
      this.Bwb.setAdapter(paramb);
    }
    AppMethodBeat.o(123087);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    AppMethodBeat.i(123086);
    this.ktR = paramBoolean;
    if ((paramBoolean) && (this.Bwb == null))
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
          this.Bwb = ((AutoCompleteTextView)localObject);
        }
        label167:
        do
        {
          if (this.Bwb == null) {
            break;
          }
          this.Bwb.setDropDownBackgroundResource(2131234520);
          setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(123063);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              MailAddrsViewControl.this.Bwb.requestFocus();
              ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(123063);
            }
          });
          this.Bwb.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(123066);
              b localb = new b();
              localb.bm(paramAnonymousAdapterView);
              localb.bm(paramAnonymousView);
              localb.pH(paramAnonymousInt);
              localb.zo(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
              paramAnonymousAdapterView = MailAddrsViewControl.e(MailAddrsViewControl.this).Vi(paramAnonymousInt);
              MailAddrsViewControl.this.b(paramAnonymousAdapterView);
              MailAddrsViewControl.this.Bwb.setText("");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(123066);
            }
          });
          this.Bwb.setOnEditorActionListener(new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123067);
              if (paramAnonymousInt == 5)
              {
                paramAnonymousTextView = MailAddrsViewControl.this.Bwb.getEditableText().toString();
                if ((paramAnonymousTextView != null) && (paramAnonymousTextView.length() > 0))
                {
                  MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousTextView, false);
                  MailAddrsViewControl.this.eGW();
                }
              }
              AppMethodBeat.o(123067);
              return true;
            }
          });
          this.Bwb.setOnKeyListener(new View.OnKeyListener()
          {
            public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123068);
              b localb = new b();
              localb.bm(paramAnonymousView);
              localb.pH(paramAnonymousInt);
              localb.bm(paramAnonymousKeyEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
              if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0))
              {
                paramAnonymousView = MailAddrsViewControl.this.Bwb.getEditableText().toString();
                if ((paramAnonymousView.length() == 0) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.this.c((l)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag());
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                  MailAddrsViewControl.this.eGW();
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
                    MailAddrsViewControl.this.eGW();
                    continue;
                    if ((paramAnonymousInt == 66) && (paramAnonymousKeyEvent.getAction() == 0))
                    {
                      paramAnonymousView = MailAddrsViewControl.this.Bwb.getEditableText().toString();
                      if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                      {
                        MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, true);
                        MailAddrsViewControl.this.eGW();
                      }
                    }
                  }
                }
              }
            }
          });
          this.Bwb.addTextChangedListener(new TextWatcher()
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
              MailAddrsViewControl.this.eGW();
              AppMethodBeat.o(123069);
            }
          });
          this.Bwb.setOnFocusChangeListener(new View.OnFocusChangeListener()
          {
            public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(123070);
              if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null) {
                MailAddrsViewControl.g(MailAddrsViewControl.this).sS(paramAnonymousBoolean);
              }
              paramAnonymousView = MailAddrsViewControl.this.Bwb.getEditableText().toString();
              if ((!paramAnonymousBoolean) && (paramAnonymousView.trim().length() > 0)) {
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, false);
              }
              if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
              {
                MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(paramAnonymousBoolean);
                MailAddrsViewControl.a(MailAddrsViewControl.this, null);
              }
              MailAddrsViewControl.this.eGW();
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
                this.Bwb = ((AutoCompleteTextView)localView);
              }
              j += 1;
            }
          }
        } while (this.Bwb != null);
        i += 1;
      }
    }
    if ((!paramBoolean) && (this.Bwb != null)) {
      this.Bwb.setVisibility(8);
    }
    AppMethodBeat.o(123086);
  }
  
  public void setInvalidMailAddrListener(a parama)
  {
    this.Bwf = parama;
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
    while (i < this.Bwa.size())
    {
      locall1 = (l)this.Bwa.get(i);
      j = 0;
      while (j < paramList.size())
      {
        locall2 = (l)paramList.get(j);
        if (locall1.yFq.equalsIgnoreCase(locall2.yFq)) {
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
      while (j < this.Bwa.size())
      {
        locall2 = (l)this.Bwa.get(j);
        if (locall1.yFq.equalsIgnoreCase(locall2.yFq)) {
          break;
        }
        j += 1;
      }
      if (j == this.Bwa.size()) {
        b(locall1);
      }
      i += 1;
    }
    AppMethodBeat.o(123095);
  }
  
  public void setOnActionListener(c paramc)
  {
    this.Bwd = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void b(MailAddrsViewControl paramMailAddrsViewControl);
    
    public abstract void eGH();
  }
  
  public static final class b
    extends BaseAdapter
    implements Filterable
  {
    private boolean Bwl;
    private a Bwm;
    private List<l> kjY;
    private ArrayList<l> kjZ;
    private Context mContext;
    private final Object mLock;
    
    public b(Context paramContext, List<l> paramList)
    {
      AppMethodBeat.i(123077);
      this.mLock = new Object();
      this.Bwl = true;
      this.mContext = paramContext;
      this.kjY = paramList;
      AppMethodBeat.o(123077);
    }
    
    public final l Vi(int paramInt)
    {
      AppMethodBeat.i(123080);
      l locall = (l)this.kjY.get(paramInt);
      AppMethodBeat.o(123080);
      return locall;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(123079);
      int i = this.kjY.size();
      AppMethodBeat.o(123079);
      return i;
    }
    
    public final Filter getFilter()
    {
      AppMethodBeat.i(123082);
      if (this.Bwm == null) {
        this.Bwm = new a((byte)0);
      }
      a locala = this.Bwm;
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
        paramView = View.inflate(this.mContext, 2131496001, null);
        paramViewGroup = new b((byte)0);
        paramViewGroup.kgE = ((TextView)paramView.findViewById(2131306356));
        paramViewGroup.BvW = ((TextView)paramView.findViewById(2131306353));
        paramViewGroup.Bwo = ((CheckBox)paramView.findViewById(2131306357));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup = Vi(paramInt);
        b localb = (b)paramView.getTag();
        localb.kgE.setText(paramViewGroup.name);
        localb.BvW.setText(paramViewGroup.yFq);
        localb.Bwo.setVisibility(8);
        paramView.setBackgroundColor(this.mContext.getResources().getColor(2131101424));
        AppMethodBeat.o(123081);
        return paramView;
        paramView = (ViewGroup)paramView;
      }
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(123078);
      super.notifyDataSetChanged();
      this.Bwl = true;
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
            if ((locall.name.toLowerCase().contains(???)) || (locall.yFq.toLowerCase().contains(???))) {
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
      TextView BvW;
      CheckBox Bwo;
      TextView kgE;
      
      private b() {}
    }
  }
  
  public static abstract class c
  {
    public void sS(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl
 * JD-Core Version:    0.7.0.1
 */