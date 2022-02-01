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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.z;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private Context context;
  private String dgl;
  private String dnn;
  private ao handler;
  private boolean hasCheck;
  private boolean isAd;
  private CharSequence text;
  private int yxy;
  private String yyA;
  private HashMap<String, Integer> yyB;
  protected bf yyC;
  private Runnable yyD;
  protected SnsPostDescPreloadTextView yyw;
  protected SnsTextView yyx;
  protected TextView yyy;
  private String yyz;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97837);
    this.isAd = false;
    this.hasCheck = true;
    this.handler = new ao(Looper.getMainLooper());
    this.yxy = 0;
    this.yyD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97836);
        if ((CollapsibleTextView.this.yyw != null) && ((CollapsibleTextView.this.yyw.getTag() instanceof ba)) && (((ba)CollapsibleTextView.this.yyw.getTag()).dnn.equals(CollapsibleTextView.a(CollapsibleTextView.this))))
        {
          CollapsibleTextView.this.yyw.setMaxLines(6);
          CollapsibleTextView.this.yyy.setVisibility(0);
          CollapsibleTextView.this.yyy.setText(CollapsibleTextView.b(CollapsibleTextView.this));
        }
        AppMethodBeat.o(97836);
      }
    };
    this.context = paramContext;
    this.yyz = this.context.getString(2131763800);
    this.yyA = this.context.getString(2131763799);
    paramContext = z.jD(this.context).inflate(2131493549, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.yyw = ((SnsPostDescPreloadTextView)paramContext.findViewById(2131299008));
    this.yyy = ((TextView)paramContext.findViewById(2131299006));
    this.yyx = ((SnsTextView)paramContext.findViewById(2131299009));
    AppMethodBeat.o(97837);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, be parambe, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97838);
    this.context = parambe.iMV;
    this.yyB = paramHashMap;
    this.text = paramCharSequence;
    this.isAd = paramBoolean;
    this.dgl = paramString1;
    this.dnn = paramString2;
    this.yxy = paramInt;
    this.yyz = this.context.getString(2131763800);
    this.yyA = this.context.getString(2131763799);
    this.yyx.setOriginText(paramString3);
    paramString2 = new ba(this.dnn, this.dgl, false, false, 1);
    paramString2.userName = this.yyC.lhM;
    if (paramInt == 0)
    {
      this.yyw.setText(paramCharSequence);
      this.yyx.setVisibility(8);
      this.yyy.setVisibility(0);
      this.yyw.setVisibility(0);
      paramCharSequence = new n(this.context);
      this.yyw.setOnTouchListener(paramCharSequence);
      this.yyw.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.yyy.setVisibility(8);
        this.yyw.setMaxLines(8);
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
        this.yyy.setVisibility(8);
        AppMethodBeat.o(97838);
        return;
        this.yyw.setMaxLines(6);
        this.yyy.setVisibility(0);
        this.yyy.setText(this.yyz);
        AppMethodBeat.o(97838);
        return;
        this.yyw.setMaxLines(2147483647);
        this.yyy.setVisibility(0);
        this.yyy.setText(this.yyA);
      }
    }
    this.yyx.setText(paramCharSequence, paramBufferType);
    this.yyx.setTag(paramString2);
    this.yyx.setVisibility(0);
    this.yyy.setVisibility(8);
    this.yyw.setVisibility(8);
    this.yyx.setOnClickListener(parambe.xZe.zgK);
    AppMethodBeat.o(97838);
  }
  
  public int getSpreadHeight()
  {
    AppMethodBeat.i(97839);
    ac.i("MicroMsg.CollapsibleTextView", "count:" + this.yyw.getLineCount() + "  height:" + this.yyw.getLineHeight());
    int i = this.yyw.getLineCount();
    int j = this.yyw.getLineHeight();
    AppMethodBeat.o(97839);
    return (i - 7) * j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97843);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.yxy == 0) && (!this.isAd))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(97843);
        return;
      }
      this.hasCheck = true;
      if (this.yyw.getLineCount() <= 7)
      {
        this.yyB.put(this.dgl, Integer.valueOf(0));
        AppMethodBeat.o(97843);
        return;
      }
      this.yyB.put(this.dgl, Integer.valueOf(1));
      this.handler.post(this.yyD);
    }
    AppMethodBeat.o(97843);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97842);
    this.yyy.setClickable(paramBoolean);
    this.yyx.setClickable(paramBoolean);
    this.yyw.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
    AppMethodBeat.o(97842);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97841);
    this.yyy.setLongClickable(paramBoolean);
    this.yyx.setLongClickable(paramBoolean);
    this.yyw.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
    AppMethodBeat.o(97841);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(97840);
    if (this.yyy != null) {
      this.yyy.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(97840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */