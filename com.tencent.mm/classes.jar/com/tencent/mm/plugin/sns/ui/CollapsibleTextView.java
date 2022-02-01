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
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView.b;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.z;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private int AfR;
  protected SnsPostDescPreloadTextView AgO;
  protected SnsTextView AgP;
  protected TextView AgQ;
  private String AgR;
  private String AgS;
  private HashMap<String, Integer> AgT;
  protected bi AgU;
  private Runnable AgV;
  private Context context;
  private String dAg;
  private String dsN;
  private aq handler;
  private boolean hasCheck;
  private boolean isAd;
  private CharSequence text;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97837);
    this.isAd = false;
    this.hasCheck = true;
    this.handler = new aq(Looper.getMainLooper());
    this.AfR = 0;
    this.AgV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97836);
        if ((CollapsibleTextView.this.AgO != null) && ((CollapsibleTextView.this.AgO.getTag() instanceof bd)) && (((bd)CollapsibleTextView.this.AgO.getTag()).dAg.equals(CollapsibleTextView.a(CollapsibleTextView.this))))
        {
          CollapsibleTextView.this.AgO.setMaxLines(6);
          CollapsibleTextView.this.AgQ.setVisibility(0);
          CollapsibleTextView.this.AgQ.setText(CollapsibleTextView.b(CollapsibleTextView.this));
        }
        AppMethodBeat.o(97836);
      }
    };
    this.context = paramContext;
    this.AgR = this.context.getString(2131763800);
    this.AgS = this.context.getString(2131763799);
    paramContext = z.jV(this.context).inflate(2131493549, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.AgO = ((SnsPostDescPreloadTextView)paramContext.findViewById(2131299008));
    this.AgQ = ((TextView)paramContext.findViewById(2131299006));
    this.AgP = ((SnsTextView)paramContext.findViewById(2131299009));
    AppMethodBeat.o(97837);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, bh parambh, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97838);
    this.context = parambh.fNT;
    this.AgT = paramHashMap;
    this.text = paramCharSequence;
    this.isAd = paramBoolean;
    this.dsN = paramString1;
    this.dAg = paramString2;
    this.AfR = paramInt;
    this.AgO.setCollapseibleMap(paramHashMap);
    this.AgO.setIsAd(paramBoolean);
    this.AgR = this.context.getString(2131763800);
    this.AgS = this.context.getString(2131763799);
    this.AgP.setOriginText(paramString3);
    paramString2 = new bd(this.dAg, this.dsN, false, false, 1);
    paramString2.userName = this.AgU.lJm;
    if (paramInt == 0)
    {
      this.AgO.setText(paramCharSequence);
      this.AgP.setVisibility(8);
      this.AgQ.setVisibility(0);
      this.AgO.setVisibility(0);
      paramCharSequence = new n(this.context);
      this.AgO.setOnTouchListener(paramCharSequence);
      this.AgO.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.AgQ.setVisibility(8);
        this.AgO.setMaxLines(8);
        AppMethodBeat.o(97838);
        return;
      }
      this.hasCheck = true;
      switch (((Integer)paramHashMap.get(paramString1)).intValue())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(97838);
        return;
        this.AgQ.setVisibility(8);
        AppMethodBeat.o(97838);
        return;
        this.AgO.setMaxLines(6);
        this.AgQ.setVisibility(0);
        this.AgQ.setText(this.AgR);
        AppMethodBeat.o(97838);
        return;
        this.AgO.setMaxLines(2147483647);
        this.AgQ.setVisibility(0);
        this.AgQ.setText(this.AgS);
      }
    }
    this.AgP.setText(paramCharSequence, paramBufferType);
    this.AgP.setTag(paramString2);
    this.AgP.setVisibility(0);
    this.AgQ.setVisibility(8);
    this.AgO.setVisibility(8);
    this.AgP.setOnClickListener(parambh.zGs.AQj);
    AppMethodBeat.o(97838);
  }
  
  public int getSpreadHeight()
  {
    AppMethodBeat.i(97839);
    ae.i("MicroMsg.CollapsibleTextView", "count:" + this.AgO.getLineCount() + "  height:" + this.AgO.getLineHeight());
    int i = this.AgO.getLineCount();
    int j = this.AgO.getLineHeight();
    AppMethodBeat.o(97839);
    return (i - 7) * j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97843);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.AfR == 0) && (!this.isAd))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(97843);
        return;
      }
      this.hasCheck = true;
      if (this.AgO.getLineCount() <= 7)
      {
        this.AgT.put(this.dsN, Integer.valueOf(0));
        AppMethodBeat.o(97843);
        return;
      }
      this.AgT.put(this.dsN, Integer.valueOf(1));
      this.handler.post(this.AgV);
    }
    AppMethodBeat.o(97843);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97842);
    this.AgQ.setClickable(paramBoolean);
    this.AgP.setClickable(paramBoolean);
    this.AgO.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
    AppMethodBeat.o(97842);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97841);
    this.AgQ.setLongClickable(paramBoolean);
    this.AgP.setLongClickable(paramBoolean);
    this.AgO.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
    AppMethodBeat.o(97841);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(97840);
    if (this.AgQ != null) {
      this.AgQ.setOnClickListener(paramOnClickListener);
    }
    setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(97840);
  }
  
  public void setShrinkOrSpreadListener(SnsPostDescPreloadTextView.b paramb)
  {
    AppMethodBeat.i(219651);
    if (this.AgO != null) {
      this.AgO.setShrinkOrSpreadListener(paramb);
    }
    AppMethodBeat.o(219651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */