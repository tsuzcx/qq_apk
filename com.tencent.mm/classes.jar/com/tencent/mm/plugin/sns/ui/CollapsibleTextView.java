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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView.b;
import com.tencent.mm.pluginsdk.ui.span.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ad;
import java.util.HashMap;

public class CollapsibleTextView
  extends LinearLayout
{
  private int KBx;
  private Runnable KCA;
  protected SnsPostDescPreloadTextView KCt;
  protected SnsTextView KCu;
  protected TextView KCv;
  private String KCw;
  private String KCx;
  private HashMap<String, Integer> KCy;
  protected bn KCz;
  private CharSequence LV;
  private Context context;
  private String fCM;
  private String fLp;
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
    this.KBx = 0;
    this.KCA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97836);
        if ((CollapsibleTextView.this.KCt != null) && ((CollapsibleTextView.this.KCt.getTag() instanceof bi)) && (((bi)CollapsibleTextView.this.KCt.getTag()).fLp.equals(CollapsibleTextView.a(CollapsibleTextView.this))))
        {
          CollapsibleTextView.this.KCt.setMaxLines(6);
          CollapsibleTextView.this.KCv.setVisibility(0);
          CollapsibleTextView.this.KCv.setText(CollapsibleTextView.b(CollapsibleTextView.this));
        }
        AppMethodBeat.o(97836);
      }
    };
    this.context = paramContext;
    this.KCw = this.context.getString(i.j.sns_desc_spread);
    this.KCx = this.context.getString(i.j.sns_desc_shrinkup);
    paramContext = ad.kS(this.context).inflate(i.g.collapsible_textview, this);
    paramContext.setPadding(0, -3, 0, 0);
    this.KCt = ((SnsPostDescPreloadTextView)paramContext.findViewById(i.f.desc_tv));
    this.KCv = ((TextView)paramContext.findViewById(i.f.desc_op_tv));
    this.KCu = ((SnsTextView)paramContext.findViewById(i.f.desc_tv_single));
    AppMethodBeat.o(97837);
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, TextView.BufferType paramBufferType, HashMap<String, Integer> paramHashMap, String paramString1, String paramString2, bm parambm, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97838);
    this.context = parambm.iXq;
    this.KCy = paramHashMap;
    this.LV = paramCharSequence;
    this.isAd = paramBoolean;
    this.fCM = paramString1;
    this.fLp = paramString2;
    this.KBx = paramInt;
    this.KCt.setCollapseibleMap(paramHashMap);
    this.KCt.setIsAd(paramBoolean);
    this.KCw = this.context.getString(i.j.sns_desc_spread);
    this.KCx = this.context.getString(i.j.sns_desc_shrinkup);
    this.KCu.setOriginText(paramString3);
    paramString2 = new bi(this.fLp, this.fCM, false, false, 1);
    paramString2.userName = this.KCz.pRV;
    if (paramInt == 0)
    {
      this.KCt.setText(paramCharSequence);
      this.KCu.setVisibility(8);
      this.KCv.setVisibility(0);
      this.KCt.setVisibility(0);
      paramCharSequence = new o(this.context);
      paramCharSequence.setAdTagClickCallback(this.mAdTagClickCallback, this.position);
      paramCharSequence.mAdTagClickScene = 30;
      this.KCt.setOnTouchListener(paramCharSequence);
      this.KCt.setTag(paramString2);
      if (paramHashMap.get(paramString1) == null)
      {
        this.hasCheck = false;
        this.KCv.setVisibility(8);
        this.KCt.setMaxLines(8);
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
        this.KCv.setVisibility(8);
        AppMethodBeat.o(97838);
        return;
        this.KCt.setMaxLines(6);
        this.KCv.setVisibility(0);
        this.KCv.setText(this.KCw);
        AppMethodBeat.o(97838);
        return;
        this.KCt.setMaxLines(2147483647);
        this.KCv.setVisibility(0);
        this.KCv.setText(this.KCx);
      }
    }
    this.KCu.setText(paramCharSequence, paramBufferType);
    this.KCu.setTag(paramString2);
    this.KCu.setVisibility(0);
    this.KCv.setVisibility(8);
    this.KCt.setVisibility(8);
    this.KCu.setOnClickListener(parambm.Kdz.Lpm);
    AppMethodBeat.o(97838);
  }
  
  public int getSpreadHeight()
  {
    AppMethodBeat.i(97839);
    Log.i("MicroMsg.CollapsibleTextView", "count:" + this.KCt.getLineCount() + "  height:" + this.KCt.getLineHeight());
    int i = this.KCt.getLineCount();
    int j = this.KCt.getLineHeight();
    AppMethodBeat.o(97839);
    return (i - 7) * j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97843);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.KBx == 0) && (!this.isAd))
    {
      if (this.hasCheck)
      {
        AppMethodBeat.o(97843);
        return;
      }
      this.hasCheck = true;
      if (this.KCt.getLineCount() <= 7)
      {
        this.KCy.put(this.fCM, Integer.valueOf(0));
        AppMethodBeat.o(97843);
        return;
      }
      this.KCy.put(this.fCM, Integer.valueOf(1));
      this.handler.post(this.KCA);
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
    this.KCv.setClickable(paramBoolean);
    this.KCu.setClickable(paramBoolean);
    this.KCt.setClickable(paramBoolean);
    super.setClickable(paramBoolean);
    AppMethodBeat.o(97842);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(97841);
    this.KCv.setLongClickable(paramBoolean);
    this.KCu.setLongClickable(paramBoolean);
    this.KCt.setLongClickable(paramBoolean);
    super.setLongClickable(paramBoolean);
    AppMethodBeat.o(97841);
  }
  
  public void setOpClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(97840);
    if (this.KCv != null) {
      this.KCv.setOnClickListener(paramOnClickListener);
    }
    setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(97840);
  }
  
  public void setShrinkOrSpreadListener(SnsPostDescPreloadTextView.b paramb)
  {
    AppMethodBeat.i(235185);
    if (this.KCt != null) {
      this.KCt.setShrinkOrSpreadListener(paramb);
    }
    AppMethodBeat.o(235185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.CollapsibleTextView
 * JD-Core Version:    0.7.0.1
 */