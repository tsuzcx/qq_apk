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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.q;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAddrsViewControl
  extends RelativeLayout
{
  private static final Pattern vYE;
  private ao handler;
  private boolean iZB;
  private GestureDetector vXH;
  private MailAddrsViewControl.b vYA;
  private c vYB;
  private View vYC;
  private a vYD;
  private GestureDetector.SimpleOnGestureListener vYF;
  private LinkedList<p> vYy;
  AutoCompleteTextView vYz;
  
  static
  {
    AppMethodBeat.i(123102);
    vYE = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    AppMethodBeat.o(123102);
  }
  
  public MailAddrsViewControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123085);
    this.iZB = false;
    this.vYy = new LinkedList();
    this.handler = new ao();
    this.vYD = null;
    this.vYF = new GestureDetector.SimpleOnGestureListener()
    {
      private void dst()
      {
        AppMethodBeat.i(123071);
        Object localObject2 = (p)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag();
        if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null)
        {
          MailAddrsViewControl.g(MailAddrsViewControl.this);
          MailAddrsViewControl.c(MailAddrsViewControl.this);
        }
        Object localObject1 = new Intent(MailAddrsViewControl.this.getContext(), MailAddrProfileUI.class);
        ((Intent)localObject1).putExtra("name", ((p)localObject2).name);
        ((Intent)localObject1).putExtra("addr", ((p)localObject2).tWE);
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("can_compose", bool);
          localObject2 = MailAddrsViewControl.this.getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/qqmail/ui/MailAddrsViewControl$8", "startActivity", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(123071);
          return;
        }
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123074);
        dst();
        AppMethodBeat.o(123074);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123073);
        if ((MailAddrsViewControl.g(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != null))
        {
          MailAddrsViewControl.g(MailAddrsViewControl.this);
          MailAddrsViewControl.c(MailAddrsViewControl.this);
          MailAddrsViewControl.c(MailAddrsViewControl.this).getTag();
        }
        AppMethodBeat.o(123073);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123072);
        if (!MailAddrsViewControl.h(MailAddrsViewControl.this)) {
          dst();
        }
        AppMethodBeat.o(123072);
        return true;
      }
    };
    this.vXH = new GestureDetector(paramContext, this.vYF);
    AppMethodBeat.o(123085);
  }
  
  private static boolean aqe(String paramString)
  {
    AppMethodBeat.i(123097);
    boolean bool = vYE.matcher(paramString).matches();
    AppMethodBeat.o(123097);
    return bool;
  }
  
  private void bv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123100);
    paramString = paramString.trim();
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(123100);
      return;
    }
    Object localObject = ((o)g.ad(o.class)).getNormalMailAppService().vUL.apU(paramString);
    if (((List)localObject).size() > 0)
    {
      e((p)((List)localObject).get(0));
      this.vYz.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (aqe(paramString))
    {
      localObject = new p();
      ((p)localObject).name = paramString;
      ((p)localObject).tWE = paramString;
      ((p)localObject).vUp = 0;
      e((p)localObject);
      this.vYz.setText("");
      AppMethodBeat.o(123100);
      return;
    }
    if (paramBoolean)
    {
      if (this.vYD != null) {
        this.vYD.dse();
      }
      for (;;)
      {
        this.vYz.setText(paramString);
        this.vYz.setSelection(paramString.length());
        AppMethodBeat.o(123100);
        return;
        Toast.makeText(getContext(), 2131761980, 2000).show();
      }
    }
    if (this.vYD != null) {
      this.vYD.b(this);
    }
    AppMethodBeat.o(123100);
  }
  
  private void dsq()
  {
    AppMethodBeat.i(177331);
    removeAllViews();
    this.vYy.clear();
    dss();
    invalidate();
    AppMethodBeat.o(177331);
  }
  
  public final String[] a(boolean paramBoolean, d paramd)
  {
    int i = 0;
    AppMethodBeat.i(123088);
    if ((paramd != null) && (paramd.isConnected())) {}
    String[] arrayOfString;
    for (;;)
    {
      try
      {
        paramd = (String)new ReadMailProxy(paramd, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
        arrayOfString = new String[this.vYy.size()];
        if (i >= this.vYy.size()) {
          break;
        }
        p localp = (p)this.vYy.get(i);
        if ((paramBoolean) && (localp.tWE.equalsIgnoreCase(paramd))) {
          break label173;
        }
        arrayOfString[i] = (localp.name + " " + localp.tWE);
        i += 1;
        continue;
        paramd = u.getUserBindEmail();
      }
      catch (Exception paramd)
      {
        ac.e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", new Object[] { paramd.getMessage() });
        AppMethodBeat.o(123088);
        return null;
      }
      continue;
      label173:
      arrayOfString[i] = "";
    }
    AppMethodBeat.o(123088);
    return arrayOfString;
  }
  
  public final void c(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(123093);
    if (paramBoolean) {
      dsq();
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(123093);
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      p localp = q.apV(paramArrayOfString[i]);
      if (localp != null) {
        e(localp);
      }
      i += 1;
    }
    AppMethodBeat.o(123093);
  }
  
  public final boolean dso()
  {
    AppMethodBeat.i(123084);
    Editable localEditable = this.vYz.getText();
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
  
  public final boolean dsp()
  {
    AppMethodBeat.i(123089);
    String str = this.vYz.getEditableText().toString().trim();
    if ((!bs.isNullOrNil(str)) && (aqe(str)))
    {
      AppMethodBeat.o(123089);
      return true;
    }
    AppMethodBeat.o(123089);
    return false;
  }
  
  public final boolean dsr()
  {
    AppMethodBeat.i(123098);
    Iterator localIterator = this.vYy.iterator();
    while (localIterator.hasNext()) {
      if (!aqe(((p)localIterator.next()).tWE))
      {
        AppMethodBeat.o(123098);
        return false;
      }
    }
    AppMethodBeat.o(123098);
    return true;
  }
  
  final void dss()
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
        if ((this.vYz == null) || (m != i2 - 1) || (this.vYz.isFocused())) {
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
  
  public final void e(p paramp)
  {
    AppMethodBeat.i(123092);
    if (paramp == null)
    {
      AppMethodBeat.o(123092);
      return;
    }
    Object localObject1 = this.vYy.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((p)((Iterator)localObject1).next()).tWE.equalsIgnoreCase(paramp.tWE));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = (ViewGroup)View.inflate(getContext(), 2131495156, null);
        localObject1 = (Button)((ViewGroup)localObject2).findViewById(2131303603);
        ((ViewGroup)localObject2).removeView((View)((Button)localObject1).getParent());
        ((Button)localObject1).setText(paramp.name);
        if (this.iZB) {
          ((Button)localObject1).setCompoundDrawables(null, null, null, null);
        }
        ((Button)localObject1).setTag(this.vYy.size());
        localObject2 = (View)((Button)localObject1).getParent();
        ((Button)localObject1).setTag(paramp);
        ((View)localObject2).setVisibility(4);
        ((View)localObject2).setTag(paramp);
        addView((View)localObject2, this.vYy.size());
        this.vYy.add(paramp);
        this.handler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123065);
            this.vYH.invalidate();
            this.vYH.setOnTouchListener(new View.OnTouchListener()
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
                if ((MailAddrsViewControl.this.vYz != null) && (paramAnonymous2MotionEvent.getAction() == 0))
                {
                  paramAnonymous2View = MailAddrsViewControl.2.this.vYH;
                  if (MailAddrsViewControl.2.this.vYH.isSelected()) {
                    break label207;
                  }
                }
                label207:
                for (boolean bool = true;; bool = false)
                {
                  paramAnonymous2View.setSelected(bool);
                  MailAddrsViewControl.this.vYz.setVisibility(0);
                  MailAddrsViewControl.this.vYz.requestFocus();
                  ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                  bool = MailAddrsViewControl.d(MailAddrsViewControl.this).onTouchEvent(paramAnonymous2MotionEvent);
                  AppMethodBeat.o(123064);
                  return bool;
                }
              }
            });
            MailAddrsViewControl.this.dss();
            MailAddrsViewControl.this.invalidate();
            AppMethodBeat.o(123065);
          }
        }, 100L);
      }
      AppMethodBeat.o(123092);
      return;
    }
  }
  
  public final void eF(List<p> paramList)
  {
    AppMethodBeat.i(123094);
    if (paramList == null)
    {
      AppMethodBeat.o(123094);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      e((p)paramList.next());
    }
    AppMethodBeat.o(123094);
  }
  
  public final void f(p paramp)
  {
    AppMethodBeat.i(123096);
    int i = 0;
    while (i < this.vYy.size())
    {
      p localp = (p)this.vYy.get(i);
      if (paramp.tWE.equalsIgnoreCase(localp.tWE))
      {
        removeViewAt(i);
        this.vYy.remove(i);
        dss();
        invalidate();
        AppMethodBeat.o(123096);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(123096);
  }
  
  public String getAddrsString()
  {
    AppMethodBeat.i(123090);
    if (dsp()) {
      bv(this.vYz.getEditableText().toString(), false);
    }
    String str1 = "";
    int i = 0;
    while (i < this.vYy.size())
    {
      p localp = (p)this.vYy.get(i);
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + ",";
      }
      str1 = str2 + localp.tWE;
      i += 1;
    }
    AppMethodBeat.o(123090);
    return str1;
  }
  
  public LinkedList<p> getMailAddrs()
  {
    return this.vYy;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(123091);
    int i = this.vYy.size();
    AppMethodBeat.o(123091);
    return i;
  }
  
  public void setAddrsAdapter(MailAddrsViewControl.b paramb)
  {
    AppMethodBeat.i(123087);
    if ((this.vYz != null) && (paramb != null))
    {
      this.vYA = paramb;
      this.vYz.setAdapter(paramb);
    }
    AppMethodBeat.o(123087);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    AppMethodBeat.i(123086);
    this.iZB = paramBoolean;
    if ((paramBoolean) && (this.vYz == null))
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
          this.vYz = ((AutoCompleteTextView)localObject);
        }
        label167:
        do
        {
          if (this.vYz == null) {
            break;
          }
          this.vYz.setDropDownBackgroundResource(2131233704);
          setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(123063);
              MailAddrsViewControl.this.vYz.requestFocus();
              ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
              AppMethodBeat.o(123063);
            }
          });
          this.vYz.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(123066);
              paramAnonymousAdapterView = MailAddrsViewControl.e(MailAddrsViewControl.this).LO(paramAnonymousInt);
              MailAddrsViewControl.this.e(paramAnonymousAdapterView);
              MailAddrsViewControl.this.vYz.setText("");
              AppMethodBeat.o(123066);
            }
          });
          this.vYz.setOnEditorActionListener(new TextView.OnEditorActionListener()
          {
            public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123067);
              if (paramAnonymousInt == 5)
              {
                paramAnonymousTextView = MailAddrsViewControl.this.vYz.getEditableText().toString();
                if ((paramAnonymousTextView != null) && (paramAnonymousTextView.length() > 0))
                {
                  MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousTextView, false);
                  MailAddrsViewControl.this.dss();
                }
              }
              AppMethodBeat.o(123067);
              return true;
            }
          });
          this.vYz.setOnKeyListener(new View.OnKeyListener()
          {
            public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(123068);
              if ((paramAnonymousInt == 67) && (paramAnonymousKeyEvent.getAction() == 0))
              {
                paramAnonymousView = MailAddrsViewControl.this.vYz.getEditableText().toString();
                if ((paramAnonymousView.length() == 0) && (MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
                {
                  MailAddrsViewControl.this.f((p)MailAddrsViewControl.c(MailAddrsViewControl.this).getTag());
                  MailAddrsViewControl.a(MailAddrsViewControl.this, null);
                  MailAddrsViewControl.this.dss();
                }
              }
              for (;;)
              {
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
                    MailAddrsViewControl.this.f((p)MailAddrsViewControl.f(MailAddrsViewControl.this).get(paramAnonymousInt));
                    MailAddrsViewControl.this.dss();
                    continue;
                    if ((paramAnonymousInt == 66) && (paramAnonymousKeyEvent.getAction() == 0))
                    {
                      paramAnonymousView = MailAddrsViewControl.this.vYz.getEditableText().toString();
                      if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
                      {
                        MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, true);
                        MailAddrsViewControl.this.dss();
                      }
                    }
                  }
                }
              }
            }
          });
          this.vYz.addTextChangedListener(new TextWatcher()
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
              MailAddrsViewControl.this.dss();
              AppMethodBeat.o(123069);
            }
          });
          this.vYz.setOnFocusChangeListener(new View.OnFocusChangeListener()
          {
            public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(123070);
              if (MailAddrsViewControl.g(MailAddrsViewControl.this) != null) {
                MailAddrsViewControl.g(MailAddrsViewControl.this).pa(paramAnonymousBoolean);
              }
              paramAnonymousView = MailAddrsViewControl.this.vYz.getEditableText().toString();
              if ((!paramAnonymousBoolean) && (paramAnonymousView.trim().length() > 0)) {
                MailAddrsViewControl.a(MailAddrsViewControl.this, paramAnonymousView, false);
              }
              if ((MailAddrsViewControl.c(MailAddrsViewControl.this) != null) && (MailAddrsViewControl.c(MailAddrsViewControl.this).isSelected()))
              {
                MailAddrsViewControl.c(MailAddrsViewControl.this).setSelected(paramAnonymousBoolean);
                MailAddrsViewControl.a(MailAddrsViewControl.this, null);
              }
              MailAddrsViewControl.this.dss();
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
                this.vYz = ((AutoCompleteTextView)localView);
              }
              j += 1;
            }
          }
        } while (this.vYz != null);
        i += 1;
      }
    }
    if ((!paramBoolean) && (this.vYz != null)) {
      this.vYz.setVisibility(8);
    }
    AppMethodBeat.o(123086);
  }
  
  public void setInvalidMailAddrListener(a parama)
  {
    this.vYD = parama;
  }
  
  public void setMailAdds(List<p> paramList)
  {
    AppMethodBeat.i(123095);
    if (paramList == null)
    {
      AppMethodBeat.o(123095);
      return;
    }
    int i = 0;
    p localp1;
    int j;
    p localp2;
    while (i < this.vYy.size())
    {
      localp1 = (p)this.vYy.get(i);
      j = 0;
      while (j < paramList.size())
      {
        localp2 = (p)paramList.get(j);
        if (localp1.tWE.equalsIgnoreCase(localp2.tWE)) {
          break;
        }
        j += 1;
      }
      if (j == paramList.size()) {
        f(localp1);
      }
      i += 1;
    }
    i = 0;
    while (i < paramList.size())
    {
      localp1 = (p)paramList.get(i);
      j = 0;
      while (j < this.vYy.size())
      {
        localp2 = (p)this.vYy.get(j);
        if (localp1.tWE.equalsIgnoreCase(localp2.tWE)) {
          break;
        }
        j += 1;
      }
      if (j == this.vYy.size()) {
        e(localp1);
      }
      i += 1;
    }
    AppMethodBeat.o(123095);
  }
  
  public void setOnActionListener(c paramc)
  {
    this.vYB = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void b(MailAddrsViewControl paramMailAddrsViewControl);
    
    public abstract void dse();
  }
  
  public static abstract class c
  {
    public void pa(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl
 * JD-Core Version:    0.7.0.1
 */