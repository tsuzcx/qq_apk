package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.InputFilter;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.f.c.b;
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
  private boolean myg;
  private int mzB;
  private int mzC;
  private int nTD;
  private int nTE;
  public boolean nob;
  private LinkedList<MMTagPanel.d> wVo;
  private View zmA;
  MMEditText zmB;
  private boolean zmC;
  private View.OnClickListener zmD;
  public boolean zmn;
  private boolean zmo;
  public boolean zmp;
  public boolean zmq;
  public boolean zmr;
  private int zms;
  private int zmt;
  private int zmu;
  private int zmv;
  private MMTagPanel.d zmw;
  private LinkedList<MMTagPanel.d> zmx;
  private MMTagPanel.a zmy;
  private int zmz;
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106829);
    this.myg = false;
    this.zmn = true;
    this.zmo = false;
    this.zmp = true;
    this.zmq = false;
    this.zmr = false;
    this.zms = 2130840499;
    this.zmt = 0;
    this.mzC = 2130840509;
    this.mzB = 2131690322;
    this.nTD = 2130840503;
    this.nTE = 2131690701;
    this.zmu = 2130840506;
    this.zmv = 2131690709;
    this.zmw = null;
    this.wVo = new LinkedList();
    this.zmx = new LinkedList();
    this.zmC = false;
    this.zmD = new MMTagPanel.8(this);
    this.nob = true;
    init();
    AppMethodBeat.o(106829);
  }
  
  public MMTagPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106828);
    this.myg = false;
    this.zmn = true;
    this.zmo = false;
    this.zmp = true;
    this.zmq = false;
    this.zmr = false;
    this.zms = 2130840499;
    this.zmt = 0;
    this.mzC = 2130840509;
    this.mzB = 2131690322;
    this.nTD = 2130840503;
    this.nTE = 2131690701;
    this.zmu = 2130840506;
    this.zmv = 2131690709;
    this.zmw = null;
    this.wVo = new LinkedList();
    this.zmx = new LinkedList();
    this.zmC = false;
    this.zmD = new MMTagPanel.8(this);
    this.nob = true;
    init();
    AppMethodBeat.o(106828);
  }
  
  private void a(MMTagPanel.d paramd)
  {
    AppMethodBeat.i(106845);
    paramd.zmP.setOnClickListener(null);
    if (this.zmx.size() >= 16)
    {
      AppMethodBeat.o(106845);
      return;
    }
    this.zmx.add(paramd);
    AppMethodBeat.o(106845);
  }
  
  private void init()
  {
    AppMethodBeat.i(106830);
    this.zmz = getContext().getResources().getDimensionPixelSize(2131427758);
    this.zmA = LayoutInflater.from(getContext()).inflate(2130970276, null);
    this.zmB = ((MMEditText)this.zmA.findViewById(2131820995));
    this.zmB.setOnKeyListener(new MMTagPanel.1(this));
    this.zmB.addTextChangedListener(new MMTagPanel.2(this));
    this.zmB.setOnFocusChangeListener(new MMTagPanel.3(this));
    this.zmB.setOnClickListener(new MMTagPanel.4(this));
    this.zmB.setOnEditorActionListener(new MMTagPanel.5(this));
    MMTagPanel.c localc = new MMTagPanel.c(this);
    MMTagPanel.b localb = new MMTagPanel.b(this);
    this.zmB.setFilters(new InputFilter[] { localc, localb });
    dEo();
    setOnClickListener(new MMTagPanel.6(this));
    setOnTouchListener(new MMTagPanel.7(this, localc));
    AppMethodBeat.o(106830);
  }
  
  public final void a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(106848);
    paramTextView.setTextSize(0, getContext().getResources().getDimension(2131427758) * a.dr(getContext()));
    if (paramBoolean2)
    {
      paramTextView.setBackgroundResource(this.zmu);
      paramTextView.setTextColor(getResources().getColor(this.zmv));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.zms, 0);
      AppMethodBeat.o(106848);
      return;
    }
    if (paramBoolean1)
    {
      paramTextView.setTag(Integer.valueOf(1));
      paramTextView.setBackgroundResource(this.nTD);
      paramTextView.setTextColor(getResources().getColor(this.nTE));
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      AppMethodBeat.o(106848);
      return;
    }
    paramTextView.setTag(Integer.valueOf(0));
    paramTextView.setBackgroundResource(this.mzC);
    paramTextView.setTextColor(getResources().getColor(this.mzB));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    AppMethodBeat.o(106848);
  }
  
  protected final void a(MMTagPanel.d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(106846);
    paramd.zmO = paramString;
    paramd.zmP.setText(b.h(getContext(), paramString, this.zmz));
    TextView localTextView = paramd.zmP;
    if (this.zmn) {}
    for (paramString = this.zmD;; paramString = null)
    {
      localTextView.setOnClickListener(paramString);
      a(paramd.zmP, paramBoolean, false);
      AppMethodBeat.o(106846);
      return;
    }
  }
  
  public final void a(Collection<String> paramCollection, List<String> paramList)
  {
    AppMethodBeat.i(106843);
    dEf();
    if (this.zmo) {
      addView(this.zmA);
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(106843);
      return;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (paramCollection == null) {}
      for (boolean bool = false;; bool = paramCollection.contains(str))
      {
        cj(str, bool);
        break;
      }
    }
    AppMethodBeat.o(106843);
  }
  
  protected void byt() {}
  
  public final void cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(106849);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
      AppMethodBeat.o(106849);
      return;
    }
    paramString = paramString.trim();
    ab.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", new Object[] { paramString });
    removeTag(paramString);
    Object localObject = this.wVo.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((MMTagPanel.d)((Iterator)localObject).next()).zmO))
      {
        ab.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[] { paramString });
        AppMethodBeat.o(106849);
        return;
      }
    }
    localObject = dEp();
    a((MMTagPanel.d)localObject, paramString, paramBoolean);
    this.wVo.add(localObject);
    if (this.zmo) {
      addView(((MMTagPanel.d)localObject).zmP, getChildCount() - 1);
    }
    for (;;)
    {
      dEq();
      AppMethodBeat.o(106849);
      return;
      addView(((MMTagPanel.d)localObject).zmP);
    }
  }
  
  public final void ck(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(106852);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
      AppMethodBeat.o(106852);
      return;
    }
    Iterator localIterator = this.wVo.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (paramString.equals(locald.zmO))
      {
        a(locald, paramString, paramBoolean);
        dEq();
        AppMethodBeat.o(106852);
        return;
      }
    }
    ab.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(106852);
  }
  
  public void dEf()
  {
    AppMethodBeat.i(106842);
    this.wVo.clear();
    removeAllViews();
    Iterator localIterator = this.wVo.iterator();
    while (localIterator.hasNext()) {
      a((MMTagPanel.d)localIterator.next());
    }
    AppMethodBeat.o(106842);
  }
  
  public final void dEm()
  {
    AppMethodBeat.i(106835);
    if (this.zmB != null) {
      this.zmB.setText("");
    }
    AppMethodBeat.o(106835);
  }
  
  public final void dEn()
  {
    AppMethodBeat.i(106836);
    if ((this.zmB == null) || (this.zmB.isFocused()))
    {
      AppMethodBeat.o(106836);
      return;
    }
    this.zmB.requestFocus();
    AppMethodBeat.o(106836);
  }
  
  public final void dEo()
  {
    AppMethodBeat.i(106837);
    if ((this.zmB != null) && (this.zmB.isFocused()))
    {
      ab.d("MicroMsg.MMTagPanel", "do clear edit focus");
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager == null)
      {
        AppMethodBeat.o(106837);
        return;
      }
      IBinder localIBinder = this.zmB.getWindowToken();
      if (localIBinder == null)
      {
        AppMethodBeat.o(106837);
        return;
      }
      localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
      this.zmB.clearFocus();
    }
    AppMethodBeat.o(106837);
  }
  
  protected final MMTagPanel.d dEp()
  {
    AppMethodBeat.i(106844);
    if (!this.zmx.isEmpty())
    {
      localObject = (MMTagPanel.d)this.zmx.removeFirst();
      AppMethodBeat.o(106844);
      return localObject;
    }
    MMTagPanel.d locald = new MMTagPanel.d();
    TextView localTextView = new TextView(getContext());
    localTextView.setBackgroundResource(this.mzC);
    localTextView.setTextColor(getResources().getColor(this.mzB));
    localTextView.setTag(Integer.valueOf(0));
    localTextView.setGravity(17);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.zms, 0);
    if (this.zmn) {}
    for (Object localObject = this.zmD;; localObject = null)
    {
      localTextView.setOnClickListener((View.OnClickListener)localObject);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine();
      locald.zmP = localTextView;
      AppMethodBeat.o(106844);
      return locald;
    }
  }
  
  protected final void dEq()
  {
    AppMethodBeat.i(106847);
    if (this.zmB != null)
    {
      ab.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[] { Boolean.valueOf(this.zmB.isFocused()) });
      this.zmB.setCursorVisible(true);
    }
    if (this.zmw == null)
    {
      AppMethodBeat.o(106847);
      return;
    }
    TextView localTextView = this.zmw.zmP;
    if (((Integer)this.zmw.zmP.getTag()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, bool, false);
      this.zmw = null;
      AppMethodBeat.o(106847);
      return;
    }
  }
  
  public final void dEr()
  {
    AppMethodBeat.i(106851);
    Iterator localIterator = this.wVo.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      removeView(locald.zmP);
      a(locald);
    }
    this.wVo.clear();
    dEq();
    AppMethodBeat.o(106851);
  }
  
  public String getEditText()
  {
    AppMethodBeat.i(106834);
    if (this.zmB != null)
    {
      String str = this.zmB.getText().toString();
      AppMethodBeat.o(106834);
      return str;
    }
    AppMethodBeat.o(106834);
    return "";
  }
  
  public int getTagCount()
  {
    AppMethodBeat.i(106841);
    int i = this.wVo.size();
    AppMethodBeat.o(106841);
    return i;
  }
  
  public ArrayList<String> getTagList()
  {
    AppMethodBeat.i(106840);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.wVo.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (!bo.isNullOrNil(locald.zmO)) {
        localArrayList.add(locald.zmO);
      }
    }
    AppMethodBeat.o(106840);
    return localArrayList;
  }
  
  public Set<String> getTagSet()
  {
    AppMethodBeat.i(106839);
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = this.wVo.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (!bo.isNullOrNil(locald.zmO)) {
        localTreeSet.add(locald.zmO);
      }
    }
    AppMethodBeat.o(106839);
    return localTreeSet;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106853);
    if (this.nob)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106853);
      return bool;
    }
    AppMethodBeat.o(106853);
    return true;
  }
  
  public final void qF(boolean paramBoolean)
  {
    AppMethodBeat.i(106838);
    if (paramBoolean == this.zmo)
    {
      AppMethodBeat.o(106838);
      return;
    }
    this.zmo = paramBoolean;
    removeView(this.zmA);
    if (this.zmo)
    {
      addView(this.zmA);
      dEo();
    }
    AppMethodBeat.o(106838);
  }
  
  public final void removeTag(String paramString)
  {
    AppMethodBeat.i(106850);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
      AppMethodBeat.o(106850);
      return;
    }
    Iterator localIterator = this.wVo.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      if (paramString.equals(locald.zmO))
      {
        this.wVo.remove(locald);
        removeView(locald.zmP);
        a(locald);
        dEq();
        AppMethodBeat.o(106850);
        return;
      }
    }
    ab.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[] { paramString });
    AppMethodBeat.o(106850);
  }
  
  public void setCallBack(MMTagPanel.a parama)
  {
    this.zmy = parama;
  }
  
  public void setEditHint(String paramString)
  {
    AppMethodBeat.i(106833);
    if (this.zmB != null) {
      this.zmB.setHint(paramString);
    }
    AppMethodBeat.o(106833);
  }
  
  public void setEditTextColor(int paramInt)
  {
    AppMethodBeat.i(106832);
    if (this.zmB != null) {
      this.zmB.setTextColor(paramInt);
    }
    AppMethodBeat.o(106832);
  }
  
  public void setEditTextHit(boolean paramBoolean)
  {
    AppMethodBeat.i(106854);
    if (this.zmB != null)
    {
      if (paramBoolean)
      {
        this.zmB.setHint(2131296430);
        AppMethodBeat.o(106854);
        return;
      }
      this.zmB.setHint("");
    }
    AppMethodBeat.o(106854);
  }
  
  public void setIsAllowEnterCharacter(boolean paramBoolean)
  {
    this.zmC = paramBoolean;
  }
  
  public void setPanelClickable(boolean paramBoolean)
  {
    this.nob = paramBoolean;
  }
  
  public void setTagEditTextBG(int paramInt)
  {
    AppMethodBeat.i(106831);
    this.zmt = paramInt;
    if (this.zmB != null)
    {
      a.fromDPToPix(getContext(), 6);
      getResources().getDimensionPixelSize(2131427808);
      this.zmB.setBackgroundResource(this.zmt);
    }
    AppMethodBeat.o(106831);
  }
  
  public void setTagHighlineBG(int paramInt)
  {
    this.zmu = paramInt;
  }
  
  public void setTagNormalBG(int paramInt)
  {
    this.mzC = paramInt;
  }
  
  public void setTagNormalTextColorRes(int paramInt)
  {
    this.mzB = paramInt;
  }
  
  public void setTagSelectedBG(int paramInt)
  {
    this.nTD = paramInt;
  }
  
  public void setTagSelectedTextColorRes(int paramInt)
  {
    this.nTE = paramInt;
  }
  
  public void setTagTipsDrawable(int paramInt)
  {
    this.zms = paramInt;
  }
  
  public void setTaghighlineTextColorRes(int paramInt)
  {
    this.zmv = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel
 * JD-Core Version:    0.7.0.1
 */