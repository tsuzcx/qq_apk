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
import com.tencent.mm.ad.a.a;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView
  extends LinearLayout
{
  private int jfZ;
  private Context mContext;
  private int mScreenWidth;
  private int nZH;
  private int qid;
  private int ziS;
  private String ziT;
  private ArrayList<MMAutoSwitchEditText> ziU;
  private MMAutoSwitchEditTextView.c ziV;
  private MMAutoSwitchEditTextView.a ziW;
  private MMAutoSwitchEditTextView.b ziX;
  
  public MMAutoSwitchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106502);
    this.ziU = new ArrayList();
    this.ziV = new MMAutoSwitchEditTextView.c(this, (byte)0);
    this.jfZ = 100;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.AutoSwitchLayout);
    this.ziS = paramAttributeSet.getInteger(0, 3);
    this.nZH = paramAttributeSet.getInteger(1, 4);
    this.qid = paramAttributeSet.getInteger(2, 2);
    int i = paramAttributeSet.getResourceId(3, 0);
    if (i != 0) {
      this.ziT = paramContext.getString(i);
    }
    paramAttributeSet.recycle();
    if ((paramContext instanceof Activity))
    {
      this.mScreenWidth = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      this.jfZ = ((this.mScreenWidth - 80 - (this.ziS - 1) * 20) / this.ziS);
    }
    setPadding(a.fromDPToPix(paramContext, 20), 0, a.fromDPToPix(paramContext, 20), 0);
    dDO();
    AppMethodBeat.o(106502);
  }
  
  private void dDO()
  {
    AppMethodBeat.i(106503);
    int i = 0;
    if (i < this.ziS)
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)View.inflate(this.mContext, 2130968795, null);
      localMMAutoSwitchEditText.setInputType(this.qid);
      if ((this.ziT != null) && (this.ziT.length() > 0)) {
        localMMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.ziT));
      }
      localMMAutoSwitchEditText.ziN.mIndex = i;
      int j = this.nZH;
      localMMAutoSwitchEditText.ziN.ziR = j;
      Object localObject = this.ziV;
      localMMAutoSwitchEditText.ziN.ziO = ((MMAutoSwitchEditText.c)localObject);
      localObject = this.ziV;
      localMMAutoSwitchEditText.ziN.ziP = ((MMAutoSwitchEditText.b)localObject);
      localObject = this.ziV;
      localMMAutoSwitchEditText.ziN.ziQ = ((MMAutoSwitchEditText.d)localObject);
      localObject = new LinearLayout.LayoutParams(this.jfZ, -2);
      if (i > 0) {}
      for (((LinearLayout.LayoutParams)localObject).leftMargin = 20;; ((LinearLayout.LayoutParams)localObject).leftMargin = 0)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        localMMAutoSwitchEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.ziU.add(localMMAutoSwitchEditText);
        addView(localMMAutoSwitchEditText);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(106503);
  }
  
  public String getText()
  {
    AppMethodBeat.i(106501);
    String str = "";
    Iterator localIterator = this.ziU.iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (bo.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
        break label89;
      }
      str = str + localMMAutoSwitchEditText.getText().toString().trim();
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(106501);
      return str;
    }
  }
  
  public void setOnInputFinished(MMAutoSwitchEditTextView.a parama)
  {
    this.ziW = parama;
  }
  
  public void setOnTextChanged(MMAutoSwitchEditTextView.b paramb)
  {
    this.ziX = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditTextView
 * JD-Core Version:    0.7.0.1
 */