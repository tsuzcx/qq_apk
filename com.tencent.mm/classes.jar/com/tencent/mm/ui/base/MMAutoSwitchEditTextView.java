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
import com.tencent.mm.af.a.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView
  extends LinearLayout
{
  private a FWA;
  private b FWB;
  private int FWw;
  private String FWx;
  private ArrayList<MMAutoSwitchEditText> FWy;
  private c FWz;
  private int lWf;
  private Context mContext;
  private int mScreenWidth;
  private int sNG;
  private int vwA;
  
  public MMAutoSwitchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141870);
    this.FWy = new ArrayList();
    this.FWz = new c((byte)0);
    this.lWf = 100;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.AutoSwitchLayout);
    this.FWw = paramAttributeSet.getInteger(0, 3);
    this.sNG = paramAttributeSet.getInteger(3, 4);
    this.vwA = paramAttributeSet.getInteger(2, 2);
    int i = paramAttributeSet.getResourceId(1, 0);
    if (i != 0) {
      this.FWx = paramContext.getString(i);
    }
    paramAttributeSet.recycle();
    if ((paramContext instanceof Activity))
    {
      this.mScreenWidth = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      this.lWf = ((this.mScreenWidth - 80 - (this.FWw - 1) * 20) / this.FWw);
    }
    setPadding(a.fromDPToPix(paramContext, 20), 0, a.fromDPToPix(paramContext, 20), 0);
    eSE();
    AppMethodBeat.o(141870);
  }
  
  private void eSE()
  {
    AppMethodBeat.i(141871);
    int i = 0;
    if (i < this.FWw)
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)View.inflate(this.mContext, 2131493124, null);
      localMMAutoSwitchEditText.setInputType(this.vwA);
      if ((this.FWx != null) && (this.FWx.length() > 0)) {
        localMMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.FWx));
      }
      localMMAutoSwitchEditText.FWr.mIndex = i;
      int j = this.sNG;
      localMMAutoSwitchEditText.FWr.FWv = j;
      Object localObject = this.FWz;
      localMMAutoSwitchEditText.FWr.FWs = ((MMAutoSwitchEditText.c)localObject);
      localObject = this.FWz;
      localMMAutoSwitchEditText.FWr.FWt = ((MMAutoSwitchEditText.b)localObject);
      localObject = this.FWz;
      localMMAutoSwitchEditText.FWr.FWu = ((MMAutoSwitchEditText.d)localObject);
      localObject = new LinearLayout.LayoutParams(this.lWf, -2);
      if (i > 0) {}
      for (((LinearLayout.LayoutParams)localObject).leftMargin = 20;; ((LinearLayout.LayoutParams)localObject).leftMargin = 0)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        localMMAutoSwitchEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.FWy.add(localMMAutoSwitchEditText);
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
    Iterator localIterator = this.FWy.iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bt.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
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
    this.FWA = parama;
  }
  
  public void setOnTextChanged(b paramb)
  {
    this.FWB = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void CB(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void aJH();
  }
  
  final class c
    implements MMAutoSwitchEditText.b, MMAutoSwitchEditText.c, MMAutoSwitchEditText.d
  {
    private c() {}
    
    public final void XJ(int paramInt)
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
    
    public final void XK(int paramInt)
    {
      AppMethodBeat.i(141866);
      Object localObject = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (bt.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label226;
        }
        localObject = (String)localObject + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label226:
      for (;;)
      {
        break;
        if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).length() == MMAutoSwitchEditTextView.b(MMAutoSwitchEditTextView.this) * MMAutoSwitchEditTextView.c(MMAutoSwitchEditTextView.this)))
        {
          if (MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this) != null) {
            MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this).CB((String)localObject);
          }
          AppMethodBeat.o(141866);
          return;
        }
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).aJH();
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
    
    public final void bRW()
    {
      AppMethodBeat.i(141868);
      String str = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (bt.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label113;
        }
        str = str + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label113:
      for (;;)
      {
        break;
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).aJH();
        }
        AppMethodBeat.o(141868);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditTextView
 * JD-Core Version:    0.7.0.1
 */