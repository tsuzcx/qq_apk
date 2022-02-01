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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.z;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private Context context;
  private String drH;
  private String dzb;
  private ap handler;
  private boolean hasCheck;
  private boolean isAd;
  private CharSequence text;
  private int zOK;
  protected SnsPostDescPreloadTextView zPH;
  protected SnsTextView zPI;
  protected TextView zPJ;
  private String zPK;
  private String zPL;
  private HashMap<String, Integer> zPM;
  protected bi zPN;
  private Runnable zPO;
  
  public CollapsibleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97837);
    this.isAd = false;
    this.hasCheck = true;
    this.handler = new ap(Looper.getMainLooper());
    this.zOK = 0;
    this.zPO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97836);
        if ((CollapsibleTextView.this.zPH != null) && ((CollapsibleTextView.this.zPH.getTag() instanceof bd)) && (((bd)CollapsibleTextView.this.zPH.getTag()).dzb.equals(CollapsibleTextView.a(CollapsibleTextView.this))))
        {
          CollapsibleTextView.this.zPH.setMaxLines(6);
          CollapsibleTextView.this.zPJ.setVisibility(0);
          CollapsibleTextView.this.zPJ.setText(CollapsibleTextView.b(CollapsibleTextView.this));
        }
        AppMethodBeat.o(97836);
      }
    };
    this.context = paramContext;
    this.zPK = this.context.getString(2131763800);
    this.zPL = this.context.getString(2131763799);
    paramContext = z.jO(this.context).inflate(2131493549, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.zPH = ((SnsPostDescPreloadTextView)paramContext.findViewById(2131299008));
    this.zPJ = ((TextView)paramContext.findViewById(2131299006));
    this.zPI = ((SnsTextView)paramContext.findViewById(2131299009));
    AppMethodBeat.o(97837);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, bh parambh, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97838);
    this.context = parambh.fLP;
    this.zPM = paramHashMap;
    this.text = paramCharSequence;
    this.isAd = paramBoolean;
    this.drH = paramString1;
    this.dzb = paramString2;
    this.zOK = paramInt;
    this.zPH.setCollapseibleMap(paramHashMap);
    this.zPH.setIsAd(paramBoolean);
    this.zPK = this.context.getString(2131763800);
    this.zPL = this.context.getString(2131763799);
    this.zPI.setOriginText(paramString3);
    paramString2 = new bd(this.dzb, this.drH, false, false, 1);
    paramString2.userName = this.zPN.lEN;
    if (paramInt == 0)
    {
      this.zPH.setText(paramCharSequence);
      this.zPI.setVisibility(8);
      this.zPJ.setVisibility(0);
      this.zPH.setVisibility(0);
      paramCharSequence = new n(this.context);
      this.zPH.setOnTouchListener(paramCharSequence);
      this.zPH.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.zPJ.setVisibility(8);
        this.zPH.setMaxLines(8);
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
        this.zPJ.setVisibility(8);
        AppMethodBeat.o(97838);
        return;
        this.zPH.setMaxLines(6);
        this.zPJ.setVisibility(0);
        this.zPJ.setText(this.zPK);
        AppMethodBeat.o(97838);
        return;
        this.zPH.setMaxLines(2147483647);
        this.zPJ.setVisibility(0);
        this.zPJ.setText(this.zPL);
      }
    }
    this.zPI.setText(paramCharSequence, paramBufferType);
    this.zPI.setTag(paramString2);
    this.zPI.setVisibility(0);
    this.zPJ.setVisibility(8);
    this.zPH.setVisibility(8);
    this.zPI.setOnClickListener(parambh.zpd.AyN);
    AppMethodBeat.o(97838);
  }
  
  public int getSpreadHeight()
  {
    AppMethodBeat.i(97839);
    ad.i("MicroMsg.CollapsibleTextView", "count:" + this.zPH.getLineCount() + "  height:" + this.zPH.getLineHeight());
    int i = this.zPH.getLineCount();
    int j = this.zPH.getLineHeight();
    AppMethodBeat.o(97839);
    return (i - 7) * j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97843);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.zOK == 0) && (!this.isAd))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(97843);
        return;
      }
      this.hasCheck = true;
      if (this.zPH.getLineCount() <= 7)
      {
        this.zPM.put(this.drH, Integer.valueOf(0));
        AppMethodBeat.o(97843);
        return;
      }
      this.zPM.put(this.drH, Integer.valueOf(1));
      this.handler.post(this.zPO);
    }
    AppMethodBeat.o(97843);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97842);
    this.zPJ.setClickable(paramBoolean);
    this.zPI.setClickable(paramBoolean);
    this.zPH.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
    AppMethodBeat.o(97842);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97841);
    this.zPJ.setLongClickable(paramBoolean);
    this.zPI.setLongClickable(paramBoolean);
    this.zPH.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
    AppMethodBeat.o(97841);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(97840);
    if (this.zPJ != null) {
      this.zPJ.setOnClickListener(paramOnClickListener);
    }
    setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(97840);
  }
  
  public void setShrinkOrSpreadListener(SnsPostDescPreloadTextView.b paramb)
  {
    AppMethodBeat.i(198134);
    if (this.zPH != null) {
      this.zPH.setShrinkOrSpreadListener(paramb);
    }
    AppMethodBeat.o(198134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */