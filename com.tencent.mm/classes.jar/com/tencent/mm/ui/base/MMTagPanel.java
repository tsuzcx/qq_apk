package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.tools.f;
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
  public boolean kQa = true;
  private boolean kdw = false;
  private int keS = a.d.normal_text_color;
  private int keT = a.f.tag_white_tab_selector;
  private int lwo = a.f.tag_green_tab_selector;
  private int lwp = a.d.wechat_green;
  public LinkedList<d> sXo = new LinkedList();
  public boolean uXW = true;
  private boolean uXX = false;
  public boolean uXY = true;
  public boolean uXZ = false;
  public boolean uYa = false;
  private int uYb = a.f.tag_deletetab;
  private int uYc = 0;
  private int uYd = a.f.tag_highlight_tab_selector;
  private int uYe = a.d.white;
  private d uYf = null;
  private LinkedList<d> uYg = new LinkedList();
  private a uYh;
  private int uYi;
  private View uYj;
  MMEditText uYk;
  private boolean uYl = false;
  private View.OnClickListener uYm = new View.OnClickListener()
  {
    public final void onClick(final View paramAnonymousView)
    {
      if (((Integer)paramAnonymousView.getTag()).intValue() == 0)
      {
        MMTagPanel.this.a((TextView)paramAnonymousView, true, false);
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              MMTagPanel.e(MMTagPanel.this).Bd(((TextView)paramAnonymousView).getText().toString());
            }
          });
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            if ((MMTagPanel.f(MMTagPanel.this)) && (!MMTagPanel.c(MMTagPanel.this))) {
              break;
            }
            MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
          } while (MMTagPanel.e(MMTagPanel.this) == null);
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              MMTagPanel.e(MMTagPanel.this).Bc(((TextView)paramAnonymousView).getText().toString());
            }
          });
          return;
          if (MMTagPanel.d(MMTagPanel.this) != null) {
            break;
          }
          MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
        } while (MMTagPanel.d(MMTagPanel.this) == null);
        MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).uYz, false, true);
        return;
        if (MMTagPanel.d(MMTagPanel.this).uYz != paramAnonymousView) {
          break;
        }
        MMTagPanel.a(MMTagPanel.this, null);
        MMTagPanel.this.a((TextView)paramAnonymousView, false, false);
      } while (MMTagPanel.e(MMTagPanel.this) == null);
      paramAnonymousView.post(new MMTagPanel.8.3(this, paramAnonymousView));
      return;
      MMTagPanel.this.cBd();
      MMTagPanel.a(MMTagPanel.this, MMTagPanel.a(MMTagPanel.this, ((TextView)paramAnonymousView).getText().toString()));
      MMTagPanel.this.a(MMTagPanel.d(MMTagPanel.this).uYz, false, true);
    }
  };
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.uYi = getContext().getResources().getDimensionPixelSize(a.e.HintTextSize);
    this.uYj = LayoutInflater.from(getContext()).inflate(a.h.mm_tag_panel_edittext, null);
    this.uYk = ((MMEditText)this.uYj.findViewById(a.g.edittext));
    this.uYk.setOnKeyListener(new MMTagPanel.1(this));
    this.uYk.addTextChangedListener(new MMTagPanel.2(this));
    this.uYk.setOnFocusChangeListener(new MMTagPanel.3(this));
    this.uYk.setOnClickListener(new MMTagPanel.4(this));
    this.uYk.setOnEditorActionListener(new MMTagPanel.5(this));
    c localc = new c();
    b localb = new b();
    this.uYk.setFilters(new InputFilter[] { localc, localb });
    cBb();
    setOnClickListener(new MMTagPanel.6(this));
    setOnTouchListener(new MMTagPanel.7(this, localc));
  }
  
  public final void a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramTextView.setTextSize(0, getContext().getResources().getDimension(a.e.HintTextSize) * a.cJ(getContext()));
    if (paramBoolean2)
    {
      paramTextView.setBackgroundResource(this.uYd);
      paramTextView.setTextColor(getResources().getColor(this.uYe));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.uYb, 0);
      return;
    }
    if (paramBoolean1)
    {
      paramTextView.setTag(Integer.valueOf(1));
      paramTextView.setBackgroundResource(this.lwo);
      paramTextView.setTextColor(getResources().getColor(this.lwp));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    paramTextView.setTag(Integer.valueOf(0));
    paramTextView.setBackgroundResource(this.keT);
    paramTextView.setTextColor(getResources().getColor(this.keS));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public final void a(d paramd)
  {
    paramd.uYz.setOnClickListener(null);
    if (this.uYg.size() >= 16) {
      return;
    }
    this.uYg.add(paramd);
  }
  
  public final void a(d paramd, String paramString, boolean paramBoolean)
  {
    paramd.uYy = paramString;
    TextView localTextView = paramd.uYz;
    getContext();
    localTextView.setText(b.c(paramString, this.uYi));
    localTextView = paramd.uYz;
    if (this.uXW) {}
    for (paramString = this.uYm;; paramString = null)
    {
      localTextView.setOnClickListener(paramString);
      a(paramd.uYz, paramBoolean, false);
      return;
    }
  }
  
  public final void a(Collection<String> paramCollection, List<String> paramList)
  {
    cAU();
    if (this.uXX) {
      addView(this.uYj);
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    label40:
    String str;
    if (paramList.hasNext())
    {
      str = (String)paramList.next();
      if (paramCollection != null) {
        break label76;
      }
    }
    label76:
    for (boolean bool = false;; bool = paramCollection.contains(str))
    {
      bH(str, bool);
      break label40;
      break;
    }
  }
  
  public void aSc() {}
  
  public final void bH(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
      return;
    }
    paramString = paramString.trim();
    y.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", new Object[] { paramString });
    removeTag(paramString);
    Object localObject = this.sXo.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((d)((Iterator)localObject).next()).uYy))
      {
        y.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[] { paramString });
        return;
      }
    }
    localObject = cBc();
    a((d)localObject, paramString, paramBoolean);
    this.sXo.add(localObject);
    if (this.uXX) {
      addView(((d)localObject).uYz, getChildCount() - 1);
    }
    for (;;)
    {
      cBd();
      return;
      addView(((d)localObject).uYz);
    }
  }
  
  public final void bI(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
      return;
    }
    Iterator localIterator = this.sXo.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.uYy))
      {
        a(locald, paramString, paramBoolean);
        cBd();
        return;
      }
    }
    y.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[] { paramString });
  }
  
  public void cAU()
  {
    this.sXo.clear();
    removeAllViews();
    Iterator localIterator = this.sXo.iterator();
    while (localIterator.hasNext()) {
      a((d)localIterator.next());
    }
  }
  
  public final void cAZ()
  {
    if (this.uYk != null) {
      this.uYk.setText("");
    }
  }
  
  public final void cBa()
  {
    if ((this.uYk == null) || (this.uYk.isFocused())) {
      return;
    }
    this.uYk.requestFocus();
  }
  
  public final void cBb()
  {
    InputMethodManager localInputMethodManager;
    if ((this.uYk != null) && (this.uYk.isFocused()))
    {
      y.d("MicroMsg.MMTagPanel", "do clear edit focus");
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        break label44;
      }
    }
    label44:
    IBinder localIBinder;
    do
    {
      return;
      localIBinder = this.uYk.getWindowToken();
    } while (localIBinder == null);
    localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
    this.uYk.clearFocus();
  }
  
  public final d cBc()
  {
    if (!this.uYg.isEmpty()) {
      return (d)this.uYg.removeFirst();
    }
    d locald = new d();
    TextView localTextView = new TextView(getContext());
    localTextView.setBackgroundResource(this.keT);
    localTextView.setTextColor(getResources().getColor(this.keS));
    localTextView.setTag(Integer.valueOf(0));
    localTextView.setGravity(17);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.uYb, 0);
    if (this.uXW) {}
    for (View.OnClickListener localOnClickListener = this.uYm;; localOnClickListener = null)
    {
      localTextView.setOnClickListener(localOnClickListener);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine();
      locald.uYz = localTextView;
      return locald;
    }
  }
  
  public final void cBd()
  {
    if (this.uYk != null)
    {
      y.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[] { Boolean.valueOf(this.uYk.isFocused()) });
      this.uYk.setCursorVisible(true);
    }
    if (this.uYf == null) {
      return;
    }
    TextView localTextView = this.uYf.uYz;
    if (((Integer)this.uYf.uYz.getTag()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      this.uYf = null;
      return;
    }
  }
  
  public String getEditText()
  {
    if (this.uYk != null) {
      return this.uYk.getText().toString();
    }
    return "";
  }
  
  public int getTagCount()
  {
    return this.sXo.size();
  }
  
  public ArrayList<String> getTagList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.sXo.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!bk.bl(locald.uYy)) {
        localArrayList.add(locald.uYy);
      }
    }
    return localArrayList;
  }
  
  public Set<String> getTagSet()
  {
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.sXo.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (!bk.bl(locald.uYy)) {
        localTreeSet.add(locald.uYy);
      }
    }
    return localTreeSet;
  }
  
  public final void nc(boolean paramBoolean)
  {
    if (paramBoolean == this.uXX) {}
    do
    {
      return;
      this.uXX = paramBoolean;
      removeView(this.uYj);
    } while (!this.uXX);
    addView(this.uYj);
    cBb();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.kQa) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public final void removeTag(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
      return;
    }
    Iterator localIterator = this.sXo.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (paramString.equals(locald.uYy))
      {
        this.sXo.remove(locald);
        removeView(locald.uYz);
        a(locald);
        cBd();
        return;
      }
    }
    y.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[] { paramString });
  }
  
  public void setCallBack(a parama)
  {
    this.uYh = parama;
  }
  
  public void setEditHint(String paramString)
  {
    if (this.uYk != null) {
      this.uYk.setHint(paramString);
    }
  }
  
  public void setEditTextColor(int paramInt)
  {
    if (this.uYk != null) {
      this.uYk.setTextColor(paramInt);
    }
  }
  
  public void setEditTextHit(boolean paramBoolean)
  {
    if (this.uYk != null)
    {
      if (paramBoolean) {
        this.uYk.setHint(a.k.add_tag_tips);
      }
    }
    else {
      return;
    }
    this.uYk.setHint("");
  }
  
  public void setIsAllowEnterCharacter(boolean paramBoolean)
  {
    this.uYl = paramBoolean;
  }
  
  public void setPanelClickable(boolean paramBoolean)
  {
    this.kQa = paramBoolean;
  }
  
  public void setTagEditTextBG(int paramInt)
  {
    this.uYc = paramInt;
    if (this.uYk != null)
    {
      a.fromDPToPix(getContext(), 6);
      getResources().getDimensionPixelSize(a.e.NormalPadding);
      this.uYk.setBackgroundResource(this.uYc);
    }
  }
  
  public void setTagHighlineBG(int paramInt)
  {
    this.uYd = paramInt;
  }
  
  public void setTagNormalBG(int paramInt)
  {
    this.keT = paramInt;
  }
  
  public void setTagNormalTextColorRes(int paramInt)
  {
    this.keS = paramInt;
  }
  
  public void setTagSelectedBG(int paramInt)
  {
    this.lwo = paramInt;
  }
  
  public void setTagSelectedTextColorRes(int paramInt)
  {
    this.lwp = paramInt;
  }
  
  public void setTagTipsDrawable(int paramInt)
  {
    this.uYb = paramInt;
  }
  
  public void setTaghighlineTextColorRes(int paramInt)
  {
    this.uYe = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void Bc(String paramString);
    
    public abstract void Bd(String paramString);
    
    public abstract void Be(String paramString);
    
    public abstract void Bf(String paramString);
    
    public abstract void Bg(String paramString);
    
    public abstract void aJI();
    
    public abstract void i(boolean paramBoolean, int paramInt);
  }
  
  public final class b
    implements InputFilter
  {
    int mark;
    List<String> uYq = new LinkedList();
    
    public b() {}
    
    public final CharSequence filter(final CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      y.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(MMTagPanel.i(MMTagPanel.this)) });
      this.mark = -1;
      this.uYq.clear();
      Object localObject = new char[paramInt2 - paramInt1];
      TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, (char[])localObject, 0);
      if (!MMTagPanel.j(MMTagPanel.this))
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
              MMTagPanel.e(MMTagPanel.this).Bg(paramCharSequence.toString());
            }
          });
          return localObject;
        }
        return null;
      }
      int i = paramInt1;
      if (i < paramInt2)
      {
        if ((localObject[i] == '\n') || (localObject[i] == ',') || (localObject[i] == ';') || (localObject[i] == '、') || (localObject[i] == 65292) || (localObject[i] == 65307))
        {
          if (-1 != this.mark) {
            break label370;
          }
          this.uYq.add((paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, i)).trim());
        }
        for (;;)
        {
          this.mark = (i + 1);
          i += 1;
          break;
          label370:
          this.uYq.add(paramCharSequence.subSequence(this.mark, i).toString().trim());
        }
      }
      if (MMTagPanel.h(MMTagPanel.this))
      {
        paramInt1 = f.aek(paramSpanned.toString());
        if ((MMTagPanel.i(MMTagPanel.this)) && (paramCharSequence.equals("\n")) && (36 < paramInt1)) {
          this.uYq.clear();
        }
      }
      if (this.uYq.isEmpty()) {
        return null;
      }
      if (MMTagPanel.e(MMTagPanel.this) != null)
      {
        localObject = this.uYq.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (str.length() > 0) {
            MMTagPanel.this.post(new MMTagPanel.b.2(this, str));
          }
        }
      }
      if (this.mark >= paramInt2) {
        paramSpanned.length();
      }
      for (paramCharSequence = paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();; paramCharSequence = paramCharSequence.subSequence(this.mark, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()))
      {
        MMTagPanel.this.post(new MMTagPanel.b.3(this, paramCharSequence));
        return "";
      }
    }
  }
  
  public final class c
    implements InputFilter
  {
    int uYu = 36;
    private int uYv = 256;
    private int uYw;
    
    public c() {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      paramInt1 = f.aek(paramSpanned.toString()) + f.aek(paramCharSequence.toString());
      if (paramInt4 > paramInt3) {
        if (paramInt1 - (paramInt4 - paramInt3) > this.uYu)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.uYw = (paramInt1 - (paramInt4 - paramInt3) - this.uYu);
        }
      }
      for (;;)
      {
        if ((MMTagPanel.h(MMTagPanel.this)) && (1 == this.uYw) && (paramCharSequence.equals("\n"))) {
          this.uYw = 0;
        }
        if (MMTagPanel.e(MMTagPanel.this) != null) {
          MMTagPanel.this.post(new MMTagPanel.c.1(this));
        }
        if (paramInt1 > this.uYv) {
          paramCharSequence = "";
        }
        return paramCharSequence;
        MMTagPanel.a(MMTagPanel.this, false);
        continue;
        if (paramInt1 > this.uYu)
        {
          MMTagPanel.a(MMTagPanel.this, true);
          this.uYw = (paramInt1 - this.uYu);
        }
        else
        {
          MMTagPanel.a(MMTagPanel.this, false);
        }
      }
    }
  }
  
  public static final class d
  {
    public String uYy;
    public TextView uYz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel
 * JD-Core Version:    0.7.0.1
 */