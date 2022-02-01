package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView
  extends LinearLayout
{
  private int Hwk;
  private String Hwl;
  private ArrayList<MMAutoSwitchEditText> Hwm;
  private c Hwn;
  private a Hwo;
  private b Hwp;
  private Context mContext;
  private int mScreenWidth;
  private int myh;
  private int tVl;
  private int wGF;
  
  public MMAutoSwitchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141870);
    this.Hwm = new ArrayList();
    this.Hwn = new c((byte)0);
    this.myh = 100;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.AutoSwitchLayout);
    this.Hwk = paramAttributeSet.getInteger(0, 3);
    this.tVl = paramAttributeSet.getInteger(3, 4);
    this.wGF = paramAttributeSet.getInteger(2, 2);
    int i = paramAttributeSet.getResourceId(1, 0);
    if (i != 0) {
      this.Hwl = paramContext.getString(i);
    }
    paramAttributeSet.recycle();
    if ((paramContext instanceof Activity))
    {
      this.mScreenWidth = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      this.myh = ((this.mScreenWidth - 80 - (this.Hwk - 1) * 20) / this.Hwk);
    }
    setPadding(a.fromDPToPix(paramContext, 20), 0, a.fromDPToPix(paramContext, 20), 0);
    fio();
    AppMethodBeat.o(141870);
  }
  
  private void fio()
  {
    AppMethodBeat.i(141871);
    int i = 0;
    if (i < this.Hwk)
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)View.inflate(this.mContext, 2131493124, null);
      localMMAutoSwitchEditText.setInputType(this.wGF);
      if ((this.Hwl != null) && (this.Hwl.length() > 0)) {
        localMMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.Hwl));
      }
      localMMAutoSwitchEditText.Hwf.mIndex = i;
      int j = this.tVl;
      localMMAutoSwitchEditText.Hwf.Hwj = j;
      Object localObject = this.Hwn;
      localMMAutoSwitchEditText.Hwf.Hwg = ((MMAutoSwitchEditText.c)localObject);
      localObject = this.Hwn;
      localMMAutoSwitchEditText.Hwf.Hwh = ((MMAutoSwitchEditText.b)localObject);
      localObject = this.Hwn;
      localMMAutoSwitchEditText.Hwf.Hwi = ((MMAutoSwitchEditText.d)localObject);
      localObject = new LinearLayout.LayoutParams(this.myh, -2);
      if (i > 0) {}
      for (((LinearLayout.LayoutParams)localObject).leftMargin = 20;; ((LinearLayout.LayoutParams)localObject).leftMargin = 0)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        localMMAutoSwitchEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.Hwm.add(localMMAutoSwitchEditText);
        addView(localMMAutoSwitchEditText);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(141871);
  }
  
  public String getText()
  {
    AppMethodBeat.i(141869);
    String str = "";
    Iterator localIterator = this.Hwm.iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bs.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
        break label89;
      }
      str = str + localMMAutoSwitchEditText.getText().toString().trim();
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(141869);
      return str;
    }
  }
  
  public void setOnInputFinished(a parama)
  {
    this.Hwo = parama;
  }
  
  public void setOnTextChanged(b paramb)
  {
    this.Hwp = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void GE(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void aQy();
  }
  
  final class c
    implements MMAutoSwitchEditText.b, MMAutoSwitchEditText.c, MMAutoSwitchEditText.d
  {
    private c() {}
    
    public final void ZU(int paramInt)
    {
      AppMethodBeat.i(141867);
      if ((MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this) != null) && (paramInt < MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).size()))
      {
        if (paramInt == 0)
        {
          AppMethodBeat.o(141867);
          return;
        }
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).get(paramInt - 1);
        if (localMMAutoSwitchEditText != null) {
          localMMAutoSwitchEditText.requestFocus();
        }
      }
      AppMethodBeat.o(141867);
    }
    
    public final void ZV(int paramInt)
    {
      AppMethodBeat.i(141866);
      Object localObject = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (bs.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label226;
        }
        localObject = (String)localObject + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label226:
      for (;;)
      {
        break;
        if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).length() == MMAutoSwitchEditTextView.b(MMAutoSwitchEditTextView.this) * MMAutoSwitchEditTextView.c(MMAutoSwitchEditTextView.this)))
        {
          if (MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this) != null) {
            MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this).GE((String)localObject);
          }
          AppMethodBeat.o(141866);
          return;
        }
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).aQy();
        }
        if ((MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this) != null) && (paramInt < MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).size() - 1))
        {
          localObject = (MMAutoSwitchEditText)MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).get(paramInt + 1);
          if (localObject != null) {
            ((MMAutoSwitchEditText)localObject).requestFocus();
          }
        }
        AppMethodBeat.o(141866);
        return;
      }
    }
    
    public final void bZl()
    {
      AppMethodBeat.i(141868);
      String str = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (bs.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label113;
        }
        str = str + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label113:
      for (;;)
      {
        break;
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).aQy();
        }
        AppMethodBeat.o(141868);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditTextView
 * JD-Core Version:    0.7.0.1
 */