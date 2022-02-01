package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView
  extends FrameLayout
{
  private TextView GRM;
  private int KoA;
  private int KoB;
  private int KoC;
  public ChattingEmojiView KoD;
  private ProgressBar KoE;
  private int Koy;
  private int Koz;
  private int mStatus = -1;
  private EmojiInfo rfq;
  private boolean xQE = true;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aiJ(int paramInt)
  {
    AppMethodBeat.i(104732);
    this.mStatus = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104732);
      return;
      this.KoE.setVisibility(0);
      this.GRM.setVisibility(4);
      this.KoD.setVisibility(4);
      setBackgroundResource(2131235359);
      AppMethodBeat.o(104732);
      return;
      this.KoE.setVisibility(0);
      this.GRM.setVisibility(4);
      this.KoD.setVisibility(4);
      setBackgroundResource(2131231746);
      AppMethodBeat.o(104732);
      return;
      Drawable localDrawable = getResources().getDrawable(2131232117);
      localDrawable.setBounds(0, 0, this.KoA, this.KoA);
      Log.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.KoA), Integer.valueOf(hashCode()) });
      this.GRM.setCompoundDrawables(null, localDrawable, null, null);
      this.GRM.setText(2131758584);
      this.GRM.setVisibility(0);
      this.KoE.setVisibility(4);
      this.KoD.setVisibility(4);
      setBackgroundResource(2131231746);
      AppMethodBeat.o(104732);
      return;
      this.KoD.setVisibility(0);
      this.KoE.setVisibility(4);
      this.GRM.setVisibility(4);
      setBackgroundResource(2131235359);
    }
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104728);
    a(paramEmojiInfo, paramLong, new be(""));
    AppMethodBeat.o(104728);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong, be parambe)
  {
    boolean bool2 = false;
    AppMethodBeat.i(104729);
    Log.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(paramLong) });
    this.rfq = paramEmojiInfo;
    if (this.rfq.NA())
    {
      this.KoD.setStatus(1);
      aiJ(2);
      Object localObject = ((l)g.af(l.class)).eiy().Hb(paramLong);
      if ((((eo)localObject).field_status == 2) || (((eo)localObject).field_status == 3) || (((eo)localObject).field_status == 5)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = this.KoD;
        if (!parambe.jsi) {
          bool2 = true;
        }
        ((ChattingEmojiView)localObject).a(bool2, bool1, ((PluginEmoji)g.ah(PluginEmoji.class)).getEmojiMgr().q(paramEmojiInfo), ((PluginEmoji)g.ah(PluginEmoji.class)).getEmojiMgr().r(paramEmojiInfo), paramEmojiInfo.getName(), String.valueOf(paramLong + paramEmojiInfo.getName()));
        AppMethodBeat.o(104729);
        return;
      }
    }
    this.xQE = true;
    this.KoD.setStatusListener(new EmojiStatusView.b()
    {
      public final void po(int paramAnonymousInt)
      {
        AppMethodBeat.i(104724);
        if (paramAnonymousInt == 0)
        {
          RTChattingEmojiView localRTChattingEmojiView = RTChattingEmojiView.this;
          if (RTChattingEmojiView.a(RTChattingEmojiView.this)) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = 1)
          {
            RTChattingEmojiView.a(localRTChattingEmojiView, paramAnonymousInt);
            AppMethodBeat.o(104724);
            return;
          }
        }
        if (paramAnonymousInt == -1)
        {
          RTChattingEmojiView.a(RTChattingEmojiView.this, 3);
          AppMethodBeat.o(104724);
          return;
        }
        RTChattingEmojiView.a(RTChattingEmojiView.this, 2);
        AppMethodBeat.o(104724);
      }
    });
    this.KoD.a(this.rfq, paramLong);
    AppMethodBeat.o(104729);
  }
  
  public final void grD()
  {
    AppMethodBeat.i(104726);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    addView(this.KoD, localLayoutParams);
    AppMethodBeat.o(104726);
  }
  
  public final void grE()
  {
    AppMethodBeat.i(104727);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 5;
    addView(this.KoD, localLayoutParams);
    AppMethodBeat.o(104727);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104725);
    this.Koy = getContext().getResources().getDimensionPixelSize(2131166307);
    this.Koz = getContext().getResources().getDimensionPixelSize(2131166304);
    this.KoB = getContext().getResources().getDimensionPixelSize(2131166310);
    this.KoC = getContext().getResources().getDimensionPixelSize(2131166309);
    this.KoD = new ChattingEmojiView(getContext());
    this.KoE = new ProgressBar(getContext());
    this.KoE.setIndeterminateDrawable(getResources().getDrawable(2131234498));
    this.GRM = new TextView(getContext());
    this.GRM.setText(2131758584);
    this.GRM.setTextColor(getResources().getColor(2131100309));
    int i = a.fromDPToPix(getContext(), 32);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    addView(this.KoE, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(this.GRM, localLayoutParams);
    AppMethodBeat.o(104725);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(104734);
    super.onAttachedToWindow();
    AppMethodBeat.o(104734);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(104735);
    super.onDetachedFromWindow();
    AppMethodBeat.o(104735);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104733);
    if ((this.mStatus == 0) || (this.mStatus == 1) || (this.mStatus == 3)) {
      if ((this.rfq == null) || (this.rfq.field_height == 0)) {
        break label155;
      }
    }
    label155:
    for (int i = Math.max((int)(this.rfq.field_height * this.KoD.getEmojiDensityScale()), this.Koz);; i = this.Koy)
    {
      int j = i;
      if (i > this.Koy) {
        j = this.Koy;
      }
      this.KoA = this.KoB;
      if ((j >= this.Koz) && (j < this.Koz + (this.KoB - this.KoC)))
      {
        i = this.KoC;
        this.KoA = (j - this.Koz + i);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(104733);
      return;
    }
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(104731);
    Log.i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 3)
    {
      this.xQE = false;
      this.KoD.reload();
      AppMethodBeat.o(104731);
      return true;
    }
    if (this.mStatus == 2)
    {
      boolean bool = super.performClick();
      AppMethodBeat.o(104731);
      return bool;
    }
    Log.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
    AppMethodBeat.o(104731);
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104730);
    aiJ(2);
    if ((this.KoD != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.KoD.getEmojiDensity());
      this.KoD.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */