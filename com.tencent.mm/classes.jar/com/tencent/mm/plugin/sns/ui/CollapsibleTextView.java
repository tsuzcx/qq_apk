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
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.y;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private Context context;
  private String diQ;
  private String dpC;
  private ap handler;
  private boolean hasCheck;
  private boolean isAd;
  private CharSequence text;
  private int xkG;
  protected SnsPostDescPreloadTextView xlE;
  protected SnsTextView xlF;
  protected TextView xlG;
  private String xlH;
  private String xlI;
  private HashMap<String, Integer> xlJ;
  protected bf xlK;
  private Runnable xlL;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97837);
    this.isAd = false;
    this.hasCheck = true;
    this.handler = new ap(Looper.getMainLooper());
    this.xkG = 0;
    this.xlL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97836);
        if ((CollapsibleTextView.this.xlE != null) && ((CollapsibleTextView.this.xlE.getTag() instanceof ba)) && (((ba)CollapsibleTextView.this.xlE.getTag()).dpC.equals(CollapsibleTextView.a(CollapsibleTextView.this))))
        {
          CollapsibleTextView.this.xlE.setMaxLines(6);
          CollapsibleTextView.this.xlG.setVisibility(0);
          CollapsibleTextView.this.xlG.setText(CollapsibleTextView.b(CollapsibleTextView.this));
        }
        AppMethodBeat.o(97836);
      }
    };
    this.context = paramContext;
    this.xlH = this.context.getString(2131763800);
    this.xlI = this.context.getString(2131763799);
    paramContext = y.js(this.context).inflate(2131493549, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.xlE = ((SnsPostDescPreloadTextView)paramContext.findViewById(2131299008));
    this.xlG = ((TextView)paramContext.findViewById(2131299006));
    this.xlF = ((SnsTextView)paramContext.findViewById(2131299009));
    AppMethodBeat.o(97837);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, be parambe, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97838);
    this.context = parambe.imP;
    this.xlJ = paramHashMap;
    this.text = paramCharSequence;
    this.isAd = paramBoolean;
    this.diQ = paramString1;
    this.dpC = paramString2;
    this.xkG = paramInt;
    this.xlH = this.context.getString(2131763800);
    this.xlI = this.context.getString(2131763799);
    this.xlF.setOriginText(paramString3);
    paramString2 = new ba(this.dpC, this.diQ, false, false, 1);
    paramString2.userName = this.xlK.kGt;
    if (paramInt == 0)
    {
      this.xlE.setText(paramString3);
      this.xlF.setVisibility(8);
      this.xlG.setVisibility(0);
      this.xlE.setVisibility(0);
      paramCharSequence = new n(this.context);
      this.xlE.setOnTouchListener(paramCharSequence);
      this.xlE.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.xlG.setVisibility(8);
        this.xlE.setMaxLines(8);
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
        this.xlG.setVisibility(8);
        AppMethodBeat.o(97838);
        return;
        this.xlE.setMaxLines(6);
        this.xlG.setVisibility(0);
        this.xlG.setText(this.xlH);
        AppMethodBeat.o(97838);
        return;
        this.xlE.setMaxLines(2147483647);
        this.xlG.setVisibility(0);
        this.xlG.setText(this.xlI);
      }
    }
    this.xlF.setText(paramCharSequence, paramBufferType);
    this.xlF.setTag(paramString2);
    this.xlF.setVisibility(0);
    this.xlG.setVisibility(8);
    this.xlE.setVisibility(8);
    this.xlF.setOnClickListener(parambe.wMy.xTO);
    AppMethodBeat.o(97838);
  }
  
  public int getSpreadHeight()
  {
    AppMethodBeat.i(97839);
    ad.i("MicroMsg.CollapsibleTextView", "count:" + this.xlE.getLineCount() + "  height:" + this.xlE.getLineHeight());
    int i = this.xlE.getLineCount();
    int j = this.xlE.getLineHeight();
    AppMethodBeat.o(97839);
    return (i - 7) * j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97843);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.xkG == 0) && (!this.isAd))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(97843);
        return;
      }
      this.hasCheck = true;
      if (this.xlE.getLineCount() <= 7)
      {
        this.xlJ.put(this.diQ, Integer.valueOf(0));
        AppMethodBeat.o(97843);
        return;
      }
      this.xlJ.put(this.diQ, Integer.valueOf(1));
      this.handler.post(this.xlL);
    }
    AppMethodBeat.o(97843);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97842);
    this.xlG.setClickable(paramBoolean);
    this.xlF.setClickable(paramBoolean);
    this.xlE.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
    AppMethodBeat.o(97842);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97841);
    this.xlG.setLongClickable(paramBoolean);
    this.xlF.setLongClickable(paramBoolean);
    this.xlE.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
    AppMethodBeat.o(97841);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(97840);
    if (this.xlG != null) {
      this.xlG.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(97840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */