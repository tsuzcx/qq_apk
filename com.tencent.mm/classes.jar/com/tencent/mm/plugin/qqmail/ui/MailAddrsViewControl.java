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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
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
  private static final Pattern HqB;
  private GestureDetector HpL;
  private a HqA;
  private GestureDetector.SimpleOnGestureListener HqC;
  private LinkedList<l> Hqv;
  AutoCompleteTextView Hqw;
  private b Hqx;
  private c Hqy;
  private View Hqz;
  private MMHandler handler;
  private boolean nlF;
  
  static
  {
    AppMethodBeat.i(123102);
    HqB = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    AppMethodBeat.o(123102);
  }
  
  public MailAddrsViewControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123085);
    this.nlF = false;
    this.Hqv = new LinkedList();
    this.handler = new MMHandler();
    this.HqA = null;
    this.HqC = new GestureDetector.SimpleOnGestureListener()
    {
      private void ftc()
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
        ((Intent)localObject1).putExtra("addr", ((l)localObject2).Ejj);
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("can_compose", bool);
          localObject2 = MailAddrsViewControl.this.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(123071);
          return;
        }
      }
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250496);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(250496);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123074);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        ftc();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123074);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123073);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
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
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {
          ftc();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123072);
        return true;
      }
    };
    this.HpL = new GestureDetector(paramContext, this.HqC);
    AppMethodBeat.o(123085);
  }
  
  private static boolean aVl(String paramString)
  {
    AppMethodBeat.i(123097);
    boolean bool = HqB.matcher(paramString).matches();
    AppMethodBeat.o(123097);
    return bool;
  }
  
  private void cg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123100);
    paramString = paramString.trim();
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(123100);
      return;
    }
    Object localObject = ((k)h.ag(k.class)).getNormalMailAppService().Hmn.aVe(paramString);
    if (((List)localObject).size() > 0)
    {
      b((l)((List)localObject).get(0));
      this.Hqw.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (aVl(paramString))
    {
      localObject = new l();
      ((l)localObject).name = paramString;
      ((l)localObject).Ejj = paramString;
      ((l)localObject).HlR = 0;
      b((l)localObject);
      this.Hqw.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (paramBoolean)
    {
      if (this.HqA != null) {
        this.HqA.fsK();
      }
      for (;;)
      {
        this.Hqw.setText(paramString);
        this.Hqw.setSelection(paramString.length());
        AppMethodBeat.o(123100);
        return;
        Toast.makeText(getContext(), e.i.plugin_qqmail_mail_addr_format_invalid, 2000).show();
      }
    }
    if (this.HqA != null) {
      this.HqA.b(this);
    }
    AppMethodBeat.o(123100);
  }
  
  private void fsZ()
  {
    AppMethodBeat.i(177331);
    removeAllViews();
    this.Hqv.clear();
    ftb();
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
    Object localObject1 = this.Hqv.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((l)((Iterator)localObject1).next()).Ejj.equalsIgnoreCase(paraml.Ejj));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = (ViewGroup)View.inflate(getContext(), e.f.qqmail_comm_widget, null);
        localObject1 = (Button)((ViewGroup)localObject2).findViewById(e.e.qqmail_single_addr_btn);
        ((ViewGroup)localObject2).removeView((View)((Button)localObject1).getParent());
        ((Button)localObject1).setText(paraml.name);
        if (this.nlF) {
          ((Button)localObject1).setCompoundDrawables(null, null, null, null);
        }
        ((Button)localObject1).setTag(this.Hqv.size());
        localObject2 = (View)((Button)localObject1).getParent();
        ((Button)localObject1).setTag(paraml);
        ((View)localObject2).setVisibility(4);
        ((View)localObject2).setTag(paraml);
        addView((View)localObject2, this.Hqv.size());
        this.Hqv.add(paraml);
        this.handler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123065);
            this.HqE.invalidate();
            this.HqE.setOnTouchListener(new View.OnTouchListener()
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
                if ((MailAddrsViewControl.this.Hqw != null) && (paramAnonymous2MotionEvent.getAction() == 0))
                {
                  paramAnonymous2View = MailAddrsViewControl.2.this.HqE;
                  if (MailAddrsViewControl.2.this.HqE.isSelected()) {
                    break label264;
                  }
                }
                label264:
                for (boolean bool = true;; bool = false)
                {
                  paramAnonymous2View.setSelected(bool);
                  MailAddrsViewControl.this.Hqw.setVisibility(0);
                  MailAddrsViewControl.this.Hqw.requestFocus();
                  ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                  paramAnonymous2View = MailAddrsViewControl.d(MailAddrsViewControl.this);
                  paramAnonymous2MotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymous2MotionEvent);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymous2View, paramAnonymous2MotionEvent.aFh(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymous2View, paramAnonymous2View.onTouchEvent((MotionEvent)paramAnonymous2MotionEvent.sf(0)), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                  AppMethodBeat.o(123064);
                  return bool;
                }
              }
            });
            MailAddrsViewControl.this.ftb();
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
    while (i < this.Hqv.size())
    {
      l locall = (l)this.Hqv.get(i);
      if (paraml.Ejj.equalsIgnoreCase(locall.Ejj))
      {
        removeViewAt(i);
        this.Hqv.remove(i);
        ftb();
        invalidate();
        AppMethodBeat.o(123096);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(123096);
  }
  
  public final boolean fsX()
  {
    AppMethodBeat.i(123084);
    Editable localEditable = this.Hqw.getText();
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
  
  public final boolean fsY()
  {
    AppMethodBeat.i(123089);
    String str = this.Hqw.getEditableText().toString().trim();
    if ((!Util.isNullOrNil(str)) && (aVl(str)))
    {
      AppMethodBeat.o(123089);
      return true;
    }
    AppMethodBeat.o(123089);
    return false;
  }
  
  public final boolean fta()
  {
    AppMethodBeat.i(123098);
    Iterator localIterator = this.Hqv.iterator();
    while (localIterator.hasNext()) {
      if (!aVl(((l)localIterator.next()).Ejj))
      {
        AppMethodBeat.o(123098);
        return false;
      }
    }
    AppMethodBeat.o(123098);
    return true;
  }
  
  final void ftb()
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
        if ((this.Hqw == null) || (m != i2 - 1) || (this.Hqw.isFocused())) {
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
    if (fsY()) {
      cg(this.Hqw.getEditableText().toString(), false);
    }
    String str1 = "";
    int i = 0;
    while (i < this.Hqv.size())
    {
      l locall = (l)this.Hqv.get(i);
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + ",";
      }
      str1 = str2 + locall.Ejj;
      i += 1;
    }
    AppMethodBeat.o(123090);
    return str1;
  }
  
  public String[] getMailAddrStringArray()
  {
    AppMethodBeat.i(250357);
    String[] arrayOfString = new String[this.Hqv.size()];
    int i = 0;
    while (i < this.Hqv.size())
    {
      l locall = (l)this.Hqv.get(i);
      arrayOfString[i] = (locall.name + " " + locall.Ejj);
      i += 1;
    }
    AppMethodBeat.o(250357);
    return arrayOfString;
  }
  
  public LinkedList<l> getMailAddrs()
  {
    return this.Hqv;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(123091);
    int i = this.Hqv.size();
    AppMethodBeat.o(123091);
    return i;
  }
  
  public final void k(List<l> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(250365);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(250365);
      return;
    }
    if (paramBoolean) {
      fsZ();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((l)paramList.next());
    }
    AppMethodBeat.o(250365);
  }
  
  public void setAddrsAdapter(b paramb)
  {
    AppMethodBeat.i(123087);
    if ((this.Hqw != null) && (paramb != null))
    {
      this.Hqx = paramb;
      this.Hqw.setAdapter(paramb);
    }
    AppMethodBeat.o(123087);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    AppMethodBeat.i(123086);
    this.nlF = paramBoolean;
    if ((paramBoolean) && (this.Hqw == null))
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
          this.Hqw = ((AutoCompleteTextView)localObject);
        }
        label167:
        do
        {
          if (this.Hqw == null) {
            break;
          }
          this.Hqw.setDropDownBackgroundResource(e.d.qqmail_dropdown_thumb);
          setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(123063);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              MailAddrsViewControl.this.Hqw.requestFocus();
              ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(123063);
            }
          });
          this.Hqw.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(123066);
              b localb = new b();
              localb.bn(paramAnonymousAdapterView);
              localb.bn(paramAnonymousView);
              localb.sg(paramAnonymousInt);
              localb.Fs(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
              paramAnonymousAdapterView = MailAddrsViewControl.e(MailAddrsViewControl.this).abQ(paramAnonymousInt);
              MailAddrsViewControl.this.b(paramAnonymousAdapterView);
              MailAddrsViewControl.this.Hqw.setText("");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(123066);
            }
          });
          this.Hqw.setOnEditorActionListener(new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123067);
              if (paramAnonymousInt == 5)
              {
                paramAnonymousTextView = MailAddrsViewControl.this.Hqw.getEditableText().toString();
                if ((paramAnonymousTextView != null) && (paramAnonymousTextView.length() > 0))
                {
                  MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousTextView, false);
                  MailAddrsViewControl.this.ftb();
                }
              }
              AppMethodBeat.o(123067);
              return true;
            }
          });
          this.Hqw.setOnKeyListener(new View.OnKeyListener()
          {
            public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123068);
              b localb = new b();
              localb.bn(paramAnonymousView);
              localb.sg(paramAnonymousInt);
              localb.bn(paramAnonymousKeyEvent);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
              if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0))
              {
                paramAnonymousView = MailAddrsViewControl.this.Hqw.getEditableText().toString();
                if ((paramAnonymousView.length() == 0) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.this.c((l)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag());
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                  MailAddrsViewControl.this.ftb();
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
                    MailAddrsViewControl.this.ftb();
                    continue;
                    if ((paramAnonymousInt == 66) && (paramAnonymousKeyEvent.getAction() == 0))
                    {
                      paramAnonymousView = MailAddrsViewControl.this.Hqw.getEditableText().toString();
                      if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                      {
                        MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, true);
                        MailAddrsViewControl.this.ftb();
                      }
                    }
                  }
                }
              }
            }
          });
          this.Hqw.addTextChangedListener(new TextWatcher()
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
              MailAddrsViewControl.this.ftb();
              AppMethodBeat.o(123069);
            }
          });
          this.Hqw.setOnFocusChangeListener(new View.OnFocusChangeListener()
          {
            public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(123070);
              if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null) {
                MailAddrsViewControl.g(MailAddrsViewControl.this).wm(paramAnonymousBoolean);
              }
              paramAnonymousView = MailAddrsViewControl.this.Hqw.getEditableText().toString();
              if ((!paramAnonymousBoolean) && (paramAnonymousView.trim().length() > 0)) {
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, false);
              }
              if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
              {
                MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(paramAnonymousBoolean);
                MailAddrsViewControl.a(MailAddrsViewControl.this, null);
              }
              MailAddrsViewControl.this.ftb();
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
                this.Hqw = ((AutoCompleteTextView)localView);
              }
              j += 1;
            }
          }
        } while (this.Hqw != null);
        i += 1;
      }
    }
    if ((!paramBoolean) && (this.Hqw != null)) {
      this.Hqw.setVisibility(8);
    }
    AppMethodBeat.o(123086);
  }
  
  public void setInvalidMailAddrListener(a parama)
  {
    this.HqA = parama;
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
    while (i < this.Hqv.size())
    {
      locall1 = (l)this.Hqv.get(i);
      j = 0;
      while (j < paramList.size())
      {
        locall2 = (l)paramList.get(j);
        if (locall1.Ejj.equalsIgnoreCase(locall2.Ejj)) {
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
      while (j < this.Hqv.size())
      {
        locall2 = (l)this.Hqv.get(j);
        if (locall1.Ejj.equalsIgnoreCase(locall2.Ejj)) {
          break;
        }
        j += 1;
      }
      if (j == this.Hqv.size()) {
        b(locall1);
      }
      i += 1;
    }
    AppMethodBeat.o(123095);
  }
  
  public void setOnActionListener(c paramc)
  {
    this.Hqy = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void b(MailAddrsViewControl paramMailAddrsViewControl);
    
    public abstract void fsK();
  }
  
  public static class b
    extends BaseAdapter
    implements Filterable
  {
    private boolean HqG;
    private a HqH;
    private Context mContext;
    private final Object mLock;
    private List<l> nbO;
    private ArrayList<l> nbP;
    
    public b(Context paramContext, List<l> paramList)
    {
      AppMethodBeat.i(123077);
      this.mLock = new Object();
      this.HqG = true;
      this.mContext = paramContext;
      this.nbO = paramList;
      AppMethodBeat.o(123077);
    }
    
    public final l abQ(int paramInt)
    {
      AppMethodBeat.i(123080);
      l locall = (l)this.nbO.get(paramInt);
      AppMethodBeat.o(123080);
      return locall;
    }
    
    public int getCount()
    {
      AppMethodBeat.i(123079);
      int i = this.nbO.size();
      AppMethodBeat.o(123079);
      return i;
    }
    
    public Filter getFilter()
    {
      AppMethodBeat.i(123082);
      if (this.HqH == null) {
        this.HqH = new a((byte)0);
      }
      a locala = this.HqH;
      AppMethodBeat.o(123082);
      return locala;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(123081);
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, e.f.qqmail_dropdown_addrlist_item, null);
        paramViewGroup = new b((byte)0);
        paramViewGroup.mYd = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_name_tv));
        paramViewGroup.Hqr = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_addr_iv));
        paramViewGroup.HqJ = ((CheckBox)paramView.findViewById(e.e.qqmail_addrlist_item_select_cb));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup = abQ(paramInt);
        b localb = (b)paramView.getTag();
        localb.mYd.setText(paramViewGroup.name);
        localb.Hqr.setText(paramViewGroup.Ejj);
        localb.HqJ.setVisibility(8);
        paramView.setBackgroundColor(this.mContext.getResources().getColor(e.c.white));
        AppMethodBeat.o(123081);
        return paramView;
        paramView = (ViewGroup)paramView;
      }
    }
    
    public void notifyDataSetChanged()
    {
      AppMethodBeat.i(123078);
      super.notifyDataSetChanged();
      this.HqG = true;
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
            if ((locall.name.toLowerCase().contains(???)) || (locall.Ejj.toLowerCase().contains(???))) {
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
      CheckBox HqJ;
      TextView Hqr;
      TextView mYd;
      
      private b() {}
    }
  }
  
  public static abstract class c
  {
    public void wm(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl
 * JD-Core Version:    0.7.0.1
 */