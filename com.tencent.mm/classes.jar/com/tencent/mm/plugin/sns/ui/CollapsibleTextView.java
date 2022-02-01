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
import com.tencent.mm.pluginsdk.ui.span.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private int Eoo;
  protected SnsPostDescPreloadTextView Epk;
  protected SnsTextView Epl;
  protected TextView Epm;
  private String Epn;
  private String Epo;
  private HashMap<String, Integer> Epp;
  protected bl Epq;
  private Runnable Epr;
  private Context context;
  private String dJX;
  private String dRS;
  private MMHandler handler;
  private boolean hasCheck;
  private boolean isAd;
  protected a mAdTagClickCallback;
  protected int position;
  private CharSequence text;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97837);
    this.isAd = false;
    this.hasCheck = true;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Eoo = 0;
    this.Epr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97836);
        if ((CollapsibleTextView.this.Epk != null) && ((CollapsibleTextView.this.Epk.getTag() instanceof bg)) && (((bg)CollapsibleTextView.this.Epk.getTag()).dRS.equals(CollapsibleTextView.a(CollapsibleTextView.this))))
        {
          CollapsibleTextView.this.Epk.setMaxLines(6);
          CollapsibleTextView.this.Epm.setVisibility(0);
          CollapsibleTextView.this.Epm.setText(CollapsibleTextView.b(CollapsibleTextView.this));
        }
        AppMethodBeat.o(97836);
      }
    };
    this.context = paramContext;
    this.Epn = this.context.getString(2131766024);
    this.Epo = this.context.getString(2131766023);
    paramContext = aa.jQ(this.context).inflate(2131493661, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.Epk = ((SnsPostDescPreloadTextView)paramContext.findViewById(2131299510));
    this.Epm = ((TextView)paramContext.findViewById(2131299508));
    this.Epl = ((SnsTextView)paramContext.findViewById(2131299511));
    AppMethodBeat.o(97837);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, bk parambk, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97838);
    this.context = parambk.gte;
    this.Epp = paramHashMap;
    this.text = paramCharSequence;
    this.isAd = paramBoolean;
    this.dJX = paramString1;
    this.dRS = paramString2;
    this.Eoo = paramInt;
    this.Epk.setCollapseibleMap(paramHashMap);
    this.Epk.setIsAd(paramBoolean);
    this.Epn = this.context.getString(2131766024);
    this.Epo = this.context.getString(2131766023);
    this.Epl.setOriginText(paramString3);
    paramString2 = new bg(this.dRS, this.dJX, false, false, 1);
    paramString2.userName = this.Epq.mRa;
    if (paramInt == 0)
    {
      this.Epk.setText(paramCharSequence);
      this.Epl.setVisibility(8);
      this.Epm.setVisibility(0);
      this.Epk.setVisibility(0);
      paramCharSequence = new o(this.context);
      paramCharSequence.setAdTagClickCallback(this.mAdTagClickCallback, this.position);
      paramCharSequence.mAdTagClickScene = 30;
      this.Epk.setOnTouchListener(paramCharSequence);
      this.Epk.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.Epm.setVisibility(8);
        this.Epk.setMaxLines(8);
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
        this.Epm.setVisibility(8);
        AppMethodBeat.o(97838);
        return;
        this.Epk.setMaxLines(6);
        this.Epm.setVisibility(0);
        this.Epm.setText(this.Epn);
        AppMethodBeat.o(97838);
        return;
        this.Epk.setMaxLines(2147483647);
        this.Epm.setVisibility(0);
        this.Epm.setText(this.Epo);
      }
    }
    this.Epl.setText(paramCharSequence, paramBufferType);
    this.Epl.setTag(paramString2);
    this.Epl.setVisibility(0);
    this.Epm.setVisibility(8);
    this.Epk.setVisibility(8);
    this.Epl.setOnClickListener(parambk.DQs.FaO);
    AppMethodBeat.o(97838);
  }
  
  public int getSpreadHeight()
  {
    AppMethodBeat.i(97839);
    Log.i("MicroMsg.CollapsibleTextView", "count:" + this.Epk.getLineCount() + "  height:" + this.Epk.getLineHeight());
    int i = this.Epk.getLineCount();
    int j = this.Epk.getLineHeight();
    AppMethodBeat.o(97839);
    return (i - 7) * j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97843);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.Eoo == 0) && (!this.isAd))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(97843);
        return;
      }
      this.hasCheck = true;
      if (this.Epk.getLineCount() <= 7)
      {
        this.Epp.put(this.dJX, Integer.valueOf(0));
        AppMethodBeat.o(97843);
        return;
      }
      this.Epp.put(this.dJX, Integer.valueOf(1));
      this.handler.post(this.Epr);
    }
    AppMethodBeat.o(97843);
  }
  
  public void setAdTagClickCallback(a parama, int paramInt)
  {
    this.mAdTagClickCallback = parama;
    this.position = paramInt;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97842);
    this.Epm.setClickable(paramBoolean);
    this.Epl.setClickable(paramBoolean);
    this.Epk.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
    AppMethodBeat.o(97842);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97841);
    this.Epm.setLongClickable(paramBoolean);
    this.Epl.setLongClickable(paramBoolean);
    this.Epk.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
    AppMethodBeat.o(97841);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(97840);
    if (this.Epm != null) {
      this.Epm.setOnClickListener(paramOnClickListener);
    }
    setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(97840);
  }
  
  public void setShrinkOrSpreadListener(SnsPostDescPreloadTextView.b paramb)
  {
    AppMethodBeat.i(203233);
    if (this.Epk != null) {
      this.Epk.setShrinkOrSpreadListener(paramb);
    }
    AppMethodBeat.o(203233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */