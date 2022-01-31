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
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView
  extends LinearLayout
{
  private int hrq = 100;
  private int lCv;
  private Context mContext;
  private int mScreenWidth;
  private int nxc;
  private int uUr;
  private String uUs;
  private ArrayList<MMAutoSwitchEditText> uUt = new ArrayList();
  private MMAutoSwitchEditTextView.c uUu = new MMAutoSwitchEditTextView.c(this, (byte)0);
  private MMAutoSwitchEditTextView.a uUv;
  private MMAutoSwitchEditTextView.b uUw;
  
  public MMAutoSwitchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.AutoSwitchLayout);
    this.uUr = paramAttributeSet.getInteger(a.m.AutoSwitchLayout_edit_text_count, 3);
    this.lCv = paramAttributeSet.getInteger(a.m.AutoSwitchLayout_max_input_count, 4);
    this.nxc = paramAttributeSet.getInteger(a.m.AutoSwitchLayout_edit_text_inputType, 2);
    int i = paramAttributeSet.getResourceId(a.m.AutoSwitchLayout_edit_text_digits, 0);
    if (i != 0) {
      this.uUs = paramContext.getString(i);
    }
    paramAttributeSet.recycle();
    if ((paramContext instanceof Activity))
    {
      this.mScreenWidth = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      this.hrq = ((this.mScreenWidth - 80 - (this.uUr - 1) * 20) / this.uUr);
    }
    setPadding(a.fromDPToPix(paramContext, 20), 0, a.fromDPToPix(paramContext, 20), 0);
    cAD();
  }
  
  private void cAD()
  {
    int i = 0;
    if (i < this.uUr)
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)View.inflate(this.mContext, a.h.auto_switch_edittext, null);
      localMMAutoSwitchEditText.setInputType(this.nxc);
      if ((this.uUs != null) && (this.uUs.length() > 0)) {
        localMMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.uUs));
      }
      localMMAutoSwitchEditText.uUm.mIndex = i;
      int j = this.lCv;
      localMMAutoSwitchEditText.uUm.uUq = j;
      Object localObject = this.uUu;
      localMMAutoSwitchEditText.uUm.uUn = ((MMAutoSwitchEditText.c)localObject);
      localObject = this.uUu;
      localMMAutoSwitchEditText.uUm.uUo = ((MMAutoSwitchEditText.b)localObject);
      localObject = this.uUu;
      localMMAutoSwitchEditText.uUm.uUp = ((MMAutoSwitchEditText.d)localObject);
      localObject = new LinearLayout.LayoutParams(this.hrq, -2);
      if (i > 0) {}
      for (((LinearLayout.LayoutParams)localObject).leftMargin = 20;; ((LinearLayout.LayoutParams)localObject).leftMargin = 0)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        localMMAutoSwitchEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.uUt.add(localMMAutoSwitchEditText);
        addView(localMMAutoSwitchEditText);
        i += 1;
        break;
      }
    }
  }
  
  public String getText()
  {
    String str = "";
    Iterator localIterator = this.uUt.iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bk.bl(localMMAutoSwitchEditText.getText().toString().trim())) {
        break label79;
      }
      str = str + localMMAutoSwitchEditText.getText().toString().trim();
    }
    label79:
    for (;;)
    {
      break;
      return str;
    }
  }
  
  public void setOnInputFinished(MMAutoSwitchEditTextView.a parama)
  {
    this.uUv = parama;
  }
  
  public void setOnTextChanged(MMAutoSwitchEditTextView.b paramb)
  {
    this.uUw = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditTextView
 * JD-Core Version:    0.7.0.1
 */