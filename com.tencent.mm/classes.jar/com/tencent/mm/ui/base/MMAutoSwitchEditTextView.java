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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView
  extends LinearLayout
{
  private int JEO;
  private String JEP;
  private ArrayList<MMAutoSwitchEditText> JEQ;
  private c JER;
  private a JES;
  private b JET;
  private Context mContext;
  private int mScreenWidth;
  private int ndW;
  private int vjB;
  private int ykf;
  
  public MMAutoSwitchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141870);
    this.JEQ = new ArrayList();
    this.JER = new c((byte)0);
    this.ndW = 100;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.AutoSwitchLayout);
    this.JEO = paramAttributeSet.getInteger(0, 3);
    this.vjB = paramAttributeSet.getInteger(3, 4);
    this.ykf = paramAttributeSet.getInteger(2, 2);
    int i = paramAttributeSet.getResourceId(1, 0);
    if (i != 0) {
      this.JEP = paramContext.getString(i);
    }
    paramAttributeSet.recycle();
    if ((paramContext instanceof Activity))
    {
      this.mScreenWidth = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      this.ndW = ((this.mScreenWidth - 80 - (this.JEO - 1) * 20) / this.JEO);
    }
    setPadding(a.fromDPToPix(paramContext, 20), 0, a.fromDPToPix(paramContext, 20), 0);
    fCF();
    AppMethodBeat.o(141870);
  }
  
  private void fCF()
  {
    AppMethodBeat.i(141871);
    int i = 0;
    if (i < this.JEO)
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)View.inflate(this.mContext, 2131493124, null);
      localMMAutoSwitchEditText.setInputType(this.ykf);
      if ((this.JEP != null) && (this.JEP.length() > 0)) {
        localMMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.JEP));
      }
      localMMAutoSwitchEditText.JEJ.mIndex = i;
      int j = this.vjB;
      localMMAutoSwitchEditText.JEJ.JEN = j;
      Object localObject = this.JER;
      localMMAutoSwitchEditText.JEJ.JEK = ((MMAutoSwitchEditText.c)localObject);
      localObject = this.JER;
      localMMAutoSwitchEditText.JEJ.JEL = ((MMAutoSwitchEditText.b)localObject);
      localObject = this.JER;
      localMMAutoSwitchEditText.JEJ.JEM = ((MMAutoSwitchEditText.d)localObject);
      localObject = new LinearLayout.LayoutParams(this.ndW, -2);
      if (i > 0) {}
      for (((LinearLayout.LayoutParams)localObject).leftMargin = 20;; ((LinearLayout.LayoutParams)localObject).leftMargin = 0)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        localMMAutoSwitchEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.JEQ.add(localMMAutoSwitchEditText);
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
    Iterator localIterator = this.JEQ.iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bu.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
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
    this.JES = parama;
  }
  
  public void setOnTextChanged(b paramb)
  {
    this.JET = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void Ks(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void aUj();
  }
  
  final class c
    implements MMAutoSwitchEditText.b, MMAutoSwitchEditText.c, MMAutoSwitchEditText.d
  {
    private c() {}
    
    public final void acL(int paramInt)
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
    
    public final void acM(int paramInt)
    {
      AppMethodBeat.i(141866);
      Object localObject = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (bu.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label226;
        }
        localObject = (String)localObject + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label226:
      for (;;)
      {
        break;
        if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).length() == MMAutoSwitchEditTextView.b(MMAutoSwitchEditTextView.this) * MMAutoSwitchEditTextView.c(MMAutoSwitchEditTextView.this)))
        {
          if (MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this) != null) {
            MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this).Ks((String)localObject);
          }
          AppMethodBeat.o(141866);
          return;
        }
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).aUj();
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
    
    public final void cfe()
    {
      AppMethodBeat.i(141868);
      String str = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (bu.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label113;
        }
        str = str + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label113:
      for (;;)
      {
        break;
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).aUj();
        }
        AppMethodBeat.o(141868);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditTextView
 * JD-Core Version:    0.7.0.1
 */