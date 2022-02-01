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
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView
  extends LinearLayout
{
  private int JWX;
  private int OeF;
  private int adPO;
  private String adPP;
  private ArrayList<MMAutoSwitchEditText> adPQ;
  private c adPR;
  private a adPS;
  private b adPT;
  private Context mContext;
  private int mScreenWidth;
  private int xGX;
  
  public MMAutoSwitchEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141870);
    this.adPQ = new ArrayList();
    this.adPR = new c((byte)0);
    this.xGX = 100;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.AutoSwitchLayout);
    this.adPO = paramAttributeSet.getInteger(a.m.AutoSwitchLayout_edit_text_count, 3);
    this.JWX = paramAttributeSet.getInteger(a.m.AutoSwitchLayout_max_input_count, 4);
    this.OeF = paramAttributeSet.getInteger(a.m.AutoSwitchLayout_edit_text_inputType, 2);
    int i = paramAttributeSet.getResourceId(a.m.AutoSwitchLayout_edit_text_digits, 0);
    if (i != 0) {
      this.adPP = paramContext.getString(i);
    }
    paramAttributeSet.recycle();
    if ((paramContext instanceof Activity))
    {
      this.mScreenWidth = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getWidth();
      this.xGX = ((this.mScreenWidth - 80 - (this.adPO - 1) * 20) / this.adPO);
    }
    setPadding(a.fromDPToPix(paramContext, 20), 0, a.fromDPToPix(paramContext, 20), 0);
    grz();
    AppMethodBeat.o(141870);
  }
  
  private void grz()
  {
    AppMethodBeat.i(141871);
    int i = 0;
    if (i < this.adPO)
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)View.inflate(this.mContext, a.h.auto_switch_edittext, null);
      localMMAutoSwitchEditText.setInputType(this.OeF);
      if ((this.adPP != null) && (this.adPP.length() > 0)) {
        localMMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.adPP));
      }
      localMMAutoSwitchEditText.adPJ.mIndex = i;
      int j = this.JWX;
      localMMAutoSwitchEditText.adPJ.adPN = j;
      Object localObject = this.adPR;
      localMMAutoSwitchEditText.adPJ.adPK = ((MMAutoSwitchEditText.c)localObject);
      localObject = this.adPR;
      localMMAutoSwitchEditText.adPJ.adPL = ((MMAutoSwitchEditText.b)localObject);
      localObject = this.adPR;
      localMMAutoSwitchEditText.adPJ.adPM = ((MMAutoSwitchEditText.d)localObject);
      localObject = new LinearLayout.LayoutParams(this.xGX, -2);
      if (i > 0) {}
      for (((LinearLayout.LayoutParams)localObject).leftMargin = 20;; ((LinearLayout.LayoutParams)localObject).leftMargin = 0)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        localMMAutoSwitchEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.adPQ.add(localMMAutoSwitchEditText);
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
    Iterator localIterator = this.adPQ.iterator();
    if (localIterator.hasNext())
    {
      MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
      if (Util.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
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
    this.adPS = parama;
  }
  
  public void setOnTextChanged(b paramb)
  {
    this.adPT = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void Ts(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void bXZ();
  }
  
  final class c
    implements MMAutoSwitchEditText.b, MMAutoSwitchEditText.c, MMAutoSwitchEditText.d
  {
    private c() {}
    
    public final void aAP(int paramInt)
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
    
    public final void aAQ(int paramInt)
    {
      AppMethodBeat.i(141866);
      Object localObject = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (Util.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label226;
        }
        localObject = (String)localObject + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label226:
      for (;;)
      {
        break;
        if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).length() == MMAutoSwitchEditTextView.b(MMAutoSwitchEditTextView.this) * MMAutoSwitchEditTextView.c(MMAutoSwitchEditTextView.this)))
        {
          if (MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this) != null) {
            MMAutoSwitchEditTextView.d(MMAutoSwitchEditTextView.this).Ts((String)localObject);
          }
          AppMethodBeat.o(141866);
          return;
        }
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).bXZ();
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
    
    public final void dvS()
    {
      AppMethodBeat.i(141868);
      String str = "";
      Iterator localIterator = MMAutoSwitchEditTextView.a(MMAutoSwitchEditTextView.this).iterator();
      if (localIterator.hasNext())
      {
        MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)localIterator.next();
        if (Util.isNullOrNil(localMMAutoSwitchEditText.getText().toString().trim())) {
          break label113;
        }
        str = str + localMMAutoSwitchEditText.getText().toString().trim();
      }
      label113:
      for (;;)
      {
        break;
        if (MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this) != null) {
          MMAutoSwitchEditTextView.e(MMAutoSwitchEditTextView.this).bXZ();
        }
        AppMethodBeat.o(141868);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditTextView
 * JD-Core Version:    0.7.0.1
 */