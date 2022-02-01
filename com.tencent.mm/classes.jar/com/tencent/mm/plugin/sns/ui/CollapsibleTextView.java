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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView.b;
import com.tencent.mm.pluginsdk.ui.span.a;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.af;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private int Rbe;
  protected SnsPostDescPreloadTextView Rcb;
  protected SnsTextView Rcc;
  protected TextView Rcd;
  private String Rce;
  private String Rcf;
  private HashMap<String, Integer> Rcg;
  protected bo Rch;
  private Runnable Rci;
  private CharSequence bba;
  private Context context;
  private String hHB;
  private String hQX;
  private MMHandler handler;
  private boolean hasCheck;
  private boolean isAd;
  protected a mAdTagClickCallback;
  protected int position;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97837);
    this.isAd = false;
    this.hasCheck = true;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Rbe = 0;
    this.Rci = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97836);
        if ((CollapsibleTextView.this.Rcb != null) && ((CollapsibleTextView.this.Rcb.getTag() instanceof bj)) && (((bj)CollapsibleTextView.this.Rcb.getTag()).hQX.equals(CollapsibleTextView.a(CollapsibleTextView.this))))
        {
          CollapsibleTextView.this.Rcb.setMaxLines(6);
          CollapsibleTextView.this.Rcd.setVisibility(0);
          CollapsibleTextView.this.Rcd.setText(CollapsibleTextView.b(CollapsibleTextView.this));
        }
        AppMethodBeat.o(97836);
      }
    };
    this.context = paramContext;
    this.Rce = this.context.getString(b.j.sns_desc_spread);
    this.Rcf = this.context.getString(b.j.sns_desc_shrinkup);
    paramContext = af.mU(this.context).inflate(b.g.collapsible_textview, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.Rcb = ((SnsPostDescPreloadTextView)paramContext.findViewById(b.f.desc_tv));
    this.Rcd = ((TextView)paramContext.findViewById(b.f.desc_op_tv));
    this.Rcc = ((SnsTextView)paramContext.findViewById(b.f.desc_tv_single));
    AppMethodBeat.o(97837);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, bn parambn, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97838);
    this.context = parambn.lzt;
    this.Rcg = paramHashMap;
    this.bba = paramCharSequence;
    this.isAd = paramBoolean;
    this.hHB = paramString1;
    this.hQX = paramString2;
    this.Rbe = paramInt;
    this.Rcb.setCollapseibleMap(paramHashMap);
    this.Rcb.setIsAd(paramBoolean);
    this.Rce = this.context.getString(b.j.sns_desc_spread);
    this.Rcf = this.context.getString(b.j.sns_desc_shrinkup);
    this.Rcc.setOriginText(paramString3);
    paramString2 = new bj(this.hQX, this.hHB, false, false, 1);
    paramString2.userName = this.Rch.sWX;
    if (paramInt == 0)
    {
      this.Rcb.setText(paramCharSequence);
      this.Rcc.setVisibility(8);
      this.Rcd.setVisibility(0);
      this.Rcb.setVisibility(0);
      paramCharSequence = new s(this.context);
      paramCharSequence.setAdTagClickCallback(this.mAdTagClickCallback, this.position);
      paramCharSequence.mAdTagClickScene = 30;
      this.Rcb.setOnTouchListener(paramCharSequence);
      this.Rcb.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.Rcd.setVisibility(8);
        this.Rcb.setMaxLines(8);
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
        this.Rcd.setVisibility(8);
        AppMethodBeat.o(97838);
        return;
        this.Rcb.setMaxLines(6);
        this.Rcd.setVisibility(0);
        this.Rcd.setText(this.Rce);
        AppMethodBeat.o(97838);
        return;
        this.Rcb.setMaxLines(2147483647);
        this.Rcd.setVisibility(0);
        this.Rcd.setText(this.Rcf);
      }
    }
    this.Rcc.setText(paramCharSequence, paramBufferType);
    this.Rcc.setTag(paramString2);
    this.Rcc.setVisibility(0);
    this.Rcd.setVisibility(8);
    this.Rcb.setVisibility(8);
    this.Rcc.setOnClickListener(parambn.QBf.RQr);
    AppMethodBeat.o(97838);
  }
  
  public int getSpreadHeight()
  {
    AppMethodBeat.i(97839);
    Log.i("MicroMsg.CollapsibleTextView", "count:" + this.Rcb.getLineCount() + "  height:" + this.Rcb.getLineHeight());
    int i = this.Rcb.getLineCount();
    int j = this.Rcb.getLineHeight();
    AppMethodBeat.o(97839);
    return (i - 7) * j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97843);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.Rbe == 0) && (!this.isAd))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(97843);
        return;
      }
      this.hasCheck = true;
      if (this.Rcb.getLineCount() <= 7)
      {
        this.Rcg.put(this.hHB, Integer.valueOf(0));
        AppMethodBeat.o(97843);
        return;
      }
      this.Rcg.put(this.hHB, Integer.valueOf(1));
      this.handler.post(this.Rci);
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
    this.Rcd.setClickable(paramBoolean);
    this.Rcc.setClickable(paramBoolean);
    this.Rcb.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
    AppMethodBeat.o(97842);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97841);
    this.Rcd.setLongClickable(paramBoolean);
    this.Rcc.setLongClickable(paramBoolean);
    this.Rcb.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
    AppMethodBeat.o(97841);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(97840);
    if (this.Rcd != null) {
      this.Rcd.setOnClickListener(paramOnClickListener);
    }
    setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(97840);
  }
  
  public void setShrinkOrSpreadListener(SnsPostDescPreloadTextView.b paramb)
  {
    AppMethodBeat.i(308204);
    if (this.Rcb != null) {
      this.Rcb.setShrinkOrSpreadListener(paramb);
    }
    AppMethodBeat.o(308204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */