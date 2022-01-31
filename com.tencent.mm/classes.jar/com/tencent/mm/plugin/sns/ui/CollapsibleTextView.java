package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.w;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private Context context;
  private String ctV;
  private String czw;
  private ak handler;
  private boolean hasCheck;
  private int rEV;
  protected SnsPostDescPreloadTextView rFO;
  protected SnsTextView rFP;
  protected TextView rFQ;
  private String rFR;
  private String rFS;
  private HashMap<String, Integer> rFT;
  protected aw rFU;
  private Runnable rFV;
  private boolean raZ;
  private CharSequence text;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38200);
    this.raZ = false;
    this.hasCheck = true;
    this.handler = new ak(Looper.getMainLooper());
    this.rEV = 0;
    this.rFV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38199);
        if ((CollapsibleTextView.this.rFO != null) && ((CollapsibleTextView.this.rFO.getTag() instanceof as)) && (((as)CollapsibleTextView.this.rFO.getTag()).czw.equals(CollapsibleTextView.a(CollapsibleTextView.this))))
        {
          CollapsibleTextView.this.rFO.setMaxLines(6);
          CollapsibleTextView.this.rFQ.setVisibility(0);
          CollapsibleTextView.this.rFQ.setText(CollapsibleTextView.b(CollapsibleTextView.this));
        }
        AppMethodBeat.o(38199);
      }
    };
    this.context = paramContext;
    this.rFR = this.context.getString(2131303797);
    this.rFS = this.context.getString(2131303796);
    paramContext = w.hM(this.context).inflate(2130969167, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.rFO = ((SnsPostDescPreloadTextView)paramContext.findViewById(2131821007));
    this.rFQ = ((TextView)paramContext.findViewById(2131822881));
    this.rFP = ((SnsTextView)paramContext.findViewById(2131822880));
    AppMethodBeat.o(38200);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, av paramav, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(38201);
    this.context = paramav.cmc;
    this.rFT = paramHashMap;
    this.text = paramCharSequence;
    this.raZ = paramBoolean;
    this.ctV = paramString1;
    this.czw = paramString2;
    this.rEV = paramInt;
    this.rFR = this.context.getString(2131303797);
    this.rFS = this.context.getString(2131303796);
    this.rFP.setOriginText(paramString3);
    paramString2 = new as(this.czw, this.ctV, false, false, 1);
    paramString2.userName = this.rFU.ikj;
    if (paramInt == 0)
    {
      this.rFO.setText(paramString3);
      this.rFP.setVisibility(8);
      this.rFQ.setVisibility(0);
      this.rFO.setVisibility(0);
      paramCharSequence = new m(this.context);
      this.rFO.setOnTouchListener(paramCharSequence);
      this.rFO.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.rFQ.setVisibility(8);
        this.rFO.setMaxLines(8);
        AppMethodBeat.o(38201);
        return;
      }
      this.hasCheck = true;
      switch (((Integer)paramHashMap.get(paramString1)).intValue())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(38201);
        return;
        this.rFQ.setVisibility(8);
        AppMethodBeat.o(38201);
        return;
        this.rFO.setMaxLines(6);
        this.rFQ.setVisibility(0);
        this.rFQ.setText(this.rFR);
        AppMethodBeat.o(38201);
        return;
        this.rFO.setMaxLines(2147483647);
        this.rFQ.setVisibility(0);
        this.rFQ.setText(this.rFS);
      }
    }
    this.rFP.setText(paramCharSequence, paramBufferType);
    this.rFP.setTag(paramString2);
    this.rFP.setVisibility(0);
    this.rFQ.setVisibility(8);
    this.rFO.setVisibility(8);
    this.rFP.setOnClickListener(paramav.rks.sjM);
    AppMethodBeat.o(38201);
  }
  
  public int getSpreadHeight()
  {
    AppMethodBeat.i(38202);
    ab.i("MicroMsg.CollapsibleTextView", "count:" + this.rFO.getLineCount() + "  height:" + this.rFO.getLineHeight());
    int i = this.rFO.getLineCount();
    int j = this.rFO.getLineHeight();
    AppMethodBeat.o(38202);
    return (i - 7) * j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38206);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.rEV == 0) && (!this.raZ))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(38206);
        return;
      }
      this.hasCheck = true;
      if (this.rFO.getLineCount() <= 7)
      {
        this.rFT.put(this.ctV, Integer.valueOf(0));
        AppMethodBeat.o(38206);
        return;
      }
      this.rFT.put(this.ctV, Integer.valueOf(1));
      this.handler.post(this.rFV);
    }
    AppMethodBeat.o(38206);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(38205);
    this.rFQ.setClickable(paramBoolean);
    this.rFP.setClickable(paramBoolean);
    this.rFO.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
    AppMethodBeat.o(38205);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(38204);
    this.rFQ.setLongClickable(paramBoolean);
    this.rFP.setLongClickable(paramBoolean);
    this.rFO.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
    AppMethodBeat.o(38204);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(38203);
    if (this.rFQ != null) {
      this.rFQ.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(38203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */