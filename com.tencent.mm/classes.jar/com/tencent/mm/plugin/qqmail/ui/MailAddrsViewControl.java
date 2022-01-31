package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAddrsViewControl
  extends RelativeLayout
{
  private static final Pattern pNC;
  private boolean gLP;
  private ak handler;
  private GestureDetector pMF;
  private View pNA;
  private MailAddrsViewControl.a pNB;
  private GestureDetector.SimpleOnGestureListener pND;
  private LinkedList<o> pNw;
  AutoCompleteTextView pNx;
  private MailAddrsViewControl.b pNy;
  private MailAddrsViewControl.c pNz;
  
  static
  {
    AppMethodBeat.i(68376);
    pNC = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    AppMethodBeat.o(68376);
  }
  
  public MailAddrsViewControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68359);
    this.gLP = false;
    this.pNw = new LinkedList();
    this.handler = new ak();
    this.pNB = null;
    this.pND = new MailAddrsViewControl.8(this);
    this.pMF = new GestureDetector(paramContext, this.pND);
    AppMethodBeat.o(68359);
  }
  
  private static boolean XC(String paramString)
  {
    AppMethodBeat.i(68371);
    boolean bool = pNC.matcher(paramString).matches();
    AppMethodBeat.o(68371);
    return bool;
  }
  
  private void bg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68374);
    paramString = paramString.trim();
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(68374);
      return;
    }
    Object localObject = ac.cdQ().pJC.Xs(paramString);
    if (((List)localObject).size() > 0)
    {
      e((o)((List)localObject).get(0));
      this.pNx.setText("");
      AppMethodBeat.o(68374);
      return;
    }
    if (XC(paramString))
    {
      localObject = new o();
      ((o)localObject).name = paramString;
      ((o)localObject).nZR = paramString;
      ((o)localObject).pJf = 0;
      e((o)localObject);
      this.pNx.setText("");
      AppMethodBeat.o(68374);
      return;
    }
    if (paramBoolean)
    {
      if (this.pNB != null) {
        this.pNB.cei();
      }
      for (;;)
      {
        this.pNx.setText(paramString);
        this.pNx.setSelection(paramString.length());
        AppMethodBeat.o(68374);
        return;
        Toast.makeText(getContext(), 2131302141, 2000).show();
      }
    }
    if (this.pNB != null) {
      this.pNB.b(this);
    }
    AppMethodBeat.o(68374);
  }
  
  public final String[] a(boolean paramBoolean, d paramd)
  {
    int i = 0;
    AppMethodBeat.i(68362);
    if ((paramd != null) && (paramd.isConnected())) {}
    String[] arrayOfString;
    for (;;)
    {
      try
      {
        paramd = (String)new ReadMailProxy(paramd, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
        arrayOfString = new String[this.pNw.size()];
        if (i >= this.pNw.size()) {
          break;
        }
        o localo = (o)this.pNw.get(i);
        if ((paramBoolean) && (localo.nZR.equalsIgnoreCase(paramd))) {
          break label169;
        }
        arrayOfString[i] = (localo.name + " " + localo.nZR);
        i += 1;
        continue;
        paramd = r.getUserBindEmail();
      }
      catch (Exception paramd)
      {
        ab.e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", new Object[] { paramd.getMessage() });
        AppMethodBeat.o(68362);
        return null;
      }
      continue;
      label169:
      arrayOfString[i] = "";
    }
    AppMethodBeat.o(68362);
    return arrayOfString;
  }
  
  public final void b(String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(68367);
    if (paramBoolean)
    {
      removeAllViews();
      this.pNw.clear();
      cew();
      invalidate();
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(68367);
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      o localo = p.Xt(paramArrayOfString[i]);
      if (localo != null) {
        e(localo);
      }
      i += 1;
    }
    AppMethodBeat.o(68367);
  }
  
  public final void cF(List<o> paramList)
  {
    AppMethodBeat.i(68368);
    if (paramList == null)
    {
      AppMethodBeat.o(68368);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      e((o)paramList.next());
    }
    AppMethodBeat.o(68368);
  }
  
  public final boolean cet()
  {
    AppMethodBeat.i(68358);
    Editable localEditable = this.pNx.getText();
    if (localEditable != null)
    {
      if (localEditable.toString().length() <= 0)
      {
        AppMethodBeat.o(68358);
        return true;
      }
      AppMethodBeat.o(68358);
      return false;
    }
    AppMethodBeat.o(68358);
    return true;
  }
  
  public final boolean ceu()
  {
    AppMethodBeat.i(68363);
    String str = this.pNx.getEditableText().toString().trim();
    if ((!bo.isNullOrNil(str)) && (XC(str)))
    {
      AppMethodBeat.o(68363);
      return true;
    }
    AppMethodBeat.o(68363);
    return false;
  }
  
  public final boolean cev()
  {
    AppMethodBeat.i(68372);
    Iterator localIterator = this.pNw.iterator();
    while (localIterator.hasNext()) {
      if (!XC(((o)localIterator.next()).nZR))
      {
        AppMethodBeat.o(68372);
        return false;
      }
    }
    AppMethodBeat.o(68372);
    return true;
  }
  
  final void cew()
  {
    AppMethodBeat.i(68373);
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
        if ((this.pNx == null) || (m != i2 - 1) || (this.pNx.isFocused())) {
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
      AppMethodBeat.o(68373);
      return;
    }
  }
  
  public final void e(o paramo)
  {
    AppMethodBeat.i(68366);
    if (paramo == null)
    {
      AppMethodBeat.o(68366);
      return;
    }
    Object localObject1 = this.pNw.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((o)((Iterator)localObject1).next()).nZR.equalsIgnoreCase(paramo.nZR));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = (ViewGroup)View.inflate(getContext(), 2130970483, null);
        localObject1 = (Button)((ViewGroup)localObject2).findViewById(2131826888);
        ((ViewGroup)localObject2).removeView((View)((Button)localObject1).getParent());
        ((Button)localObject1).setText(paramo.name);
        if (this.gLP) {
          ((Button)localObject1).setCompoundDrawables(null, null, null, null);
        }
        ((Button)localObject1).setTag(this.pNw.size());
        localObject2 = (View)((Button)localObject1).getParent();
        ((Button)localObject1).setTag(paramo);
        ((View)localObject2).setVisibility(4);
        ((View)localObject2).setTag(paramo);
        addView((View)localObject2, this.pNw.size());
        this.pNw.add(paramo);
        this.handler.postDelayed(new MailAddrsViewControl.2(this, (Button)localObject1), 100L);
      }
      AppMethodBeat.o(68366);
      return;
    }
  }
  
  public final void f(o paramo)
  {
    AppMethodBeat.i(68370);
    int i = 0;
    while (i < this.pNw.size())
    {
      o localo = (o)this.pNw.get(i);
      if (paramo.nZR.equalsIgnoreCase(localo.nZR))
      {
        removeViewAt(i);
        this.pNw.remove(i);
        cew();
        invalidate();
        AppMethodBeat.o(68370);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(68370);
  }
  
  public String getAddrsString()
  {
    AppMethodBeat.i(68364);
    if (ceu()) {
      bg(this.pNx.getEditableText().toString(), false);
    }
    String str1 = "";
    int i = 0;
    while (i < this.pNw.size())
    {
      o localo = (o)this.pNw.get(i);
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + ",";
      }
      str1 = str2 + localo.nZR;
      i += 1;
    }
    AppMethodBeat.o(68364);
    return str1;
  }
  
  public LinkedList<o> getMailAddrs()
  {
    return this.pNw;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(68365);
    int i = this.pNw.size();
    AppMethodBeat.o(68365);
    return i;
  }
  
  public void setAddrsAdapter(MailAddrsViewControl.b paramb)
  {
    AppMethodBeat.i(68361);
    if ((this.pNx != null) && (paramb != null))
    {
      this.pNy = paramb;
      this.pNx.setAdapter(paramb);
    }
    AppMethodBeat.o(68361);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    AppMethodBeat.i(68360);
    this.gLP = paramBoolean;
    if ((paramBoolean) && (this.pNx == null))
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
          this.pNx = ((AutoCompleteTextView)localObject);
        }
        label167:
        do
        {
          if (this.pNx == null) {
            break;
          }
          this.pNx.setDropDownBackgroundResource(2130840028);
          setOnClickListener(new MailAddrsViewControl.1(this));
          this.pNx.setOnItemClickListener(new MailAddrsViewControl.3(this));
          this.pNx.setOnEditorActionListener(new MailAddrsViewControl.4(this));
          this.pNx.setOnKeyListener(new MailAddrsViewControl.5(this));
          this.pNx.addTextChangedListener(new MailAddrsViewControl.6(this));
          this.pNx.setOnFocusChangeListener(new MailAddrsViewControl.7(this));
          AppMethodBeat.o(68360);
          return;
          if ((localObject instanceof ViewGroup))
          {
            localObject = (ViewGroup)localObject;
            int j = 0;
            while (j < ((ViewGroup)localObject).getChildCount())
            {
              View localView = ((ViewGroup)localObject).getChildAt(j);
              if ((localView instanceof AutoCompleteTextView)) {
                this.pNx = ((AutoCompleteTextView)localView);
              }
              j += 1;
            }
          }
        } while (this.pNx != null);
        i += 1;
      }
    }
    if ((!paramBoolean) && (this.pNx != null)) {
      this.pNx.setVisibility(8);
    }
    AppMethodBeat.o(68360);
  }
  
  public void setInvalidMailAddrListener(MailAddrsViewControl.a parama)
  {
    this.pNB = parama;
  }
  
  public void setMailAdds(List<o> paramList)
  {
    AppMethodBeat.i(68369);
    if (paramList == null)
    {
      AppMethodBeat.o(68369);
      return;
    }
    int i = 0;
    o localo1;
    int j;
    o localo2;
    while (i < this.pNw.size())
    {
      localo1 = (o)this.pNw.get(i);
      j = 0;
      while (j < paramList.size())
      {
        localo2 = (o)paramList.get(j);
        if (localo1.nZR.equalsIgnoreCase(localo2.nZR)) {
          break;
        }
        j += 1;
      }
      if (j == paramList.size()) {
        f(localo1);
      }
      i += 1;
    }
    i = 0;
    while (i < paramList.size())
    {
      localo1 = (o)paramList.get(i);
      j = 0;
      while (j < this.pNw.size())
      {
        localo2 = (o)this.pNw.get(j);
        if (localo1.nZR.equalsIgnoreCase(localo2.nZR)) {
          break;
        }
        j += 1;
      }
      if (j == this.pNw.size()) {
        e(localo1);
      }
      i += 1;
    }
    AppMethodBeat.o(68369);
  }
  
  public void setOnActionListener(MailAddrsViewControl.c paramc)
  {
    this.pNz = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl
 * JD-Core Version:    0.7.0.1
 */