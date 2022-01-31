package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAddrsViewControl
  extends RelativeLayout
{
  private static final Pattern nip = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
  private boolean fun = false;
  private ah handler = new ah();
  private GestureDetector nhs = new GestureDetector(paramContext, this.niq);
  private LinkedList<o> nij = new LinkedList();
  AutoCompleteTextView nik;
  private MailAddrsViewControl.b nil;
  private MailAddrsViewControl.c nim;
  private View nin;
  private MailAddrsViewControl.a nio = null;
  private GestureDetector.SimpleOnGestureListener niq = new MailAddrsViewControl.8(this);
  
  public MailAddrsViewControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static boolean Ls(String paramString)
  {
    return nip.matcher(paramString).matches();
  }
  
  private void aR(String paramString, boolean paramBoolean)
  {
    paramString = paramString.trim();
    if (paramString.length() == 0) {}
    do
    {
      return;
      Object localObject = ac.btF().nem.Li(paramString);
      if (((List)localObject).size() > 0)
      {
        e((o)((List)localObject).get(0));
        this.nik.setText("");
        return;
      }
      if (Ls(paramString))
      {
        localObject = new o();
        ((o)localObject).name = paramString;
        ((o)localObject).lCF = paramString;
        ((o)localObject).ndP = 0;
        e((o)localObject);
        this.nik.setText("");
        return;
      }
      if (paramBoolean)
      {
        if (this.nio != null) {
          this.nio.btW();
        }
        for (;;)
        {
          this.nik.setText(paramString);
          this.nik.setSelection(paramString.length());
          return;
          Toast.makeText(getContext(), b.j.plugin_qqmail_mail_addr_format_invalid, 2000).show();
        }
      }
    } while (this.nio == null);
    this.nio.b(this);
  }
  
  public final void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      removeAllViews();
      this.nij.clear();
      buk();
      invalidate();
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        o localo = p.Lj(paramArrayOfString[i]);
        if (localo != null) {
          e(localo);
        }
        i += 1;
      }
    }
  }
  
  public final String[] a(boolean paramBoolean, d paramd)
  {
    int i = 0;
    if ((paramd != null) && (paramd.isConnected())) {}
    String[] arrayOfString;
    for (;;)
    {
      try
      {
        paramd = (String)new ReadMailProxy(paramd, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
        arrayOfString = new String[this.nij.size()];
        if (i >= this.nij.size()) {
          break;
        }
        o localo = (o)this.nij.get(i);
        if ((paramBoolean) && (localo.lCF.equalsIgnoreCase(paramd))) {
          break label160;
        }
        arrayOfString[i] = (localo.name + " " + localo.lCF);
        i += 1;
        continue;
        paramd = q.getUserBindEmail();
      }
      catch (Exception paramd)
      {
        y.e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", new Object[] { paramd.getMessage() });
        return null;
      }
      continue;
      label160:
      arrayOfString[i] = "";
    }
    return arrayOfString;
  }
  
  public final boolean buh()
  {
    Editable localEditable = this.nik.getText();
    return (localEditable == null) || (localEditable.toString().length() <= 0);
  }
  
  public final boolean bui()
  {
    String str = this.nik.getEditableText().toString().trim();
    return (!bk.bl(str)) && (Ls(str));
  }
  
  public final boolean buj()
  {
    Iterator localIterator = this.nij.iterator();
    while (localIterator.hasNext()) {
      if (!Ls(((o)localIterator.next()).lCF)) {
        return false;
      }
    }
    return true;
  }
  
  final void buk()
  {
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
        if ((this.nik == null) || (m != i2 - 1) || (this.nik.isFocused())) {
          break label224;
        }
      }
    }
    label224:
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
      return;
    }
  }
  
  public final void cd(List<o> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        e((o)paramList.next());
      }
    }
  }
  
  public final void e(o paramo)
  {
    if (paramo == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.nij.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((o)((Iterator)localObject1).next()).lCF.equalsIgnoreCase(paramo.lCF));
      for (int i = 1; i == 0; i = 0)
      {
        Object localObject2 = (ViewGroup)View.inflate(getContext(), b.g.qqmail_comm_widget, null);
        localObject1 = (Button)((ViewGroup)localObject2).findViewById(b.f.qqmail_single_addr_btn);
        ((ViewGroup)localObject2).removeView((View)((Button)localObject1).getParent());
        ((Button)localObject1).setText(paramo.name);
        if (this.fun) {
          ((Button)localObject1).setCompoundDrawables(null, null, null, null);
        }
        ((Button)localObject1).setTag(this.nij.size());
        localObject2 = (View)((Button)localObject1).getParent();
        ((Button)localObject1).setTag(paramo);
        ((View)localObject2).setVisibility(4);
        ((View)localObject2).setTag(paramo);
        addView((View)localObject2, this.nij.size());
        this.nij.add(paramo);
        this.handler.postDelayed(new MailAddrsViewControl.2(this, (Button)localObject1), 100L);
        return;
      }
    }
  }
  
  public final void f(o paramo)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.nij.size())
      {
        o localo = (o)this.nij.get(i);
        if (paramo.lCF.equalsIgnoreCase(localo.lCF))
        {
          removeViewAt(i);
          this.nij.remove(i);
          buk();
          invalidate();
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public String getAddrsString()
  {
    if (bui()) {
      aR(this.nik.getEditableText().toString(), false);
    }
    String str1 = "";
    int i = 0;
    while (i < this.nij.size())
    {
      o localo = (o)this.nij.get(i);
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + ",";
      }
      str1 = str2 + localo.lCF;
      i += 1;
    }
    return str1;
  }
  
  public LinkedList<o> getMailAddrs()
  {
    return this.nij;
  }
  
  public int getSize()
  {
    return this.nij.size();
  }
  
  public void setAddrsAdapter(MailAddrsViewControl.b paramb)
  {
    if ((this.nik != null) && (paramb != null))
    {
      this.nil = paramb;
      this.nik.setAdapter(paramb);
    }
  }
  
  public void setEditable(boolean paramBoolean)
  {
    this.fun = paramBoolean;
    if ((paramBoolean) && (this.nik == null))
    {
      i = 0;
      if (i < getChildCount())
      {
        localObject = getChildAt(i);
        if ((localObject instanceof AutoCompleteTextView)) {
          this.nik = ((AutoCompleteTextView)localObject);
        }
      }
      else if (this.nik != null)
      {
        this.nik.setDropDownBackgroundResource(b.e.qqmail_dropdown_thumb);
        setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            MailAddrsViewControl.this.nik.requestFocus();
            ((InputMethodManager)MailAddrsViewControl.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
          }
        });
        this.nik.setOnItemClickListener(new MailAddrsViewControl.3(this));
        this.nik.setOnEditorActionListener(new MailAddrsViewControl.4(this));
        this.nik.setOnKeyListener(new MailAddrsViewControl.5(this));
        this.nik.addTextChangedListener(new MailAddrsViewControl.6(this));
        this.nik.setOnFocusChangeListener(new MailAddrsViewControl.7(this));
      }
    }
    while ((paramBoolean) || (this.nik == null)) {
      for (;;)
      {
        int i;
        Object localObject;
        return;
        if ((localObject instanceof ViewGroup))
        {
          localObject = (ViewGroup)localObject;
          int j = 0;
          while (j < ((ViewGroup)localObject).getChildCount())
          {
            View localView = ((ViewGroup)localObject).getChildAt(j);
            if ((localView instanceof AutoCompleteTextView)) {
              this.nik = ((AutoCompleteTextView)localView);
            }
            j += 1;
          }
        }
        if (this.nik == null) {
          i += 1;
        }
      }
    }
    this.nik.setVisibility(8);
  }
  
  public void setInvalidMailAddrListener(MailAddrsViewControl.a parama)
  {
    this.nio = parama;
  }
  
  public void setMailAdds(List<o> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      o localo1;
      int j;
      o localo2;
      while (i < this.nij.size())
      {
        localo1 = (o)this.nij.get(i);
        j = 0;
        while (j < paramList.size())
        {
          localo2 = (o)paramList.get(j);
          if (localo1.lCF.equalsIgnoreCase(localo2.lCF)) {
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
        while (j < this.nij.size())
        {
          localo2 = (o)this.nij.get(j);
          if (localo1.lCF.equalsIgnoreCase(localo2.lCF)) {
            break;
          }
          j += 1;
        }
        if (j == this.nij.size()) {
          e(localo1);
        }
        i += 1;
      }
    }
  }
  
  public void setOnActionListener(MailAddrsViewControl.c paramc)
  {
    this.nim = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl
 * JD-Core Version:    0.7.0.1
 */