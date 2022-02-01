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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView
  extends FrameLayout
{
  private TextView CnN;
  private int FxD;
  private int FxE;
  private int FxF;
  private int FxG;
  private int FxH;
  public ChattingEmojiView FxI;
  private ProgressBar FxJ;
  private int mStatus = -1;
  private EmojiInfo pOS;
  private boolean uyF = true;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void ZW(int paramInt)
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
      this.FxJ.setVisibility(0);
      this.CnN.setVisibility(4);
      this.FxI.setVisibility(4);
      setBackgroundResource(2131234429);
      AppMethodBeat.o(104732);
      return;
      this.FxJ.setVisibility(0);
      this.CnN.setVisibility(4);
      this.FxI.setVisibility(4);
      setBackgroundResource(2131231680);
      AppMethodBeat.o(104732);
      return;
      Drawable localDrawable = getResources().getDrawable(2131232026);
      localDrawable.setBounds(0, 0, this.FxF, this.FxF);
      ae.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.FxF), Integer.valueOf(hashCode()) });
      this.CnN.setCompoundDrawables(null, localDrawable, null, null);
      this.CnN.setText(2131758294);
      this.CnN.setVisibility(0);
      this.FxJ.setVisibility(4);
      this.FxI.setVisibility(4);
      setBackgroundResource(2131231680);
      AppMethodBeat.o(104732);
      return;
      this.FxI.setVisibility(0);
      this.FxJ.setVisibility(4);
      this.CnN.setVisibility(4);
      setBackgroundResource(2131234429);
    }
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104728);
    a(paramEmojiInfo, paramLong, new az(""));
    AppMethodBeat.o(104728);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong, az paramaz)
  {
    boolean bool2 = false;
    AppMethodBeat.i(104729);
    ae.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(paramLong) });
    this.pOS = paramEmojiInfo;
    if (this.pOS.Ee())
    {
      this.FxI.setStatus(1);
      ZW(2);
      Object localObject = ((l)g.ab(l.class)).doJ().ys(paramLong);
      if ((((ei)localObject).field_status == 2) || (((ei)localObject).field_status == 3) || (((ei)localObject).field_status == 5)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = this.FxI;
        if (!paramaz.iwT) {
          bool2 = true;
        }
        ((ChattingEmojiView)localObject).a(bool2, bool1, ((PluginEmoji)g.ad(PluginEmoji.class)).getEmojiMgr().q(paramEmojiInfo), ((PluginEmoji)g.ad(PluginEmoji.class)).getEmojiMgr().r(paramEmojiInfo), paramEmojiInfo.getName(), String.valueOf(paramLong + paramEmojiInfo.getName()));
        AppMethodBeat.o(104729);
        return;
      }
    }
    this.uyF = true;
    this.FxI.setStatusListener(new EmojiStatusView.b()
    {
      public final void mg(int paramAnonymousInt)
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
    this.FxI.a(this.pOS, paramLong);
    AppMethodBeat.o(104729);
  }
  
  public final void fir()
  {
    AppMethodBeat.i(104726);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    addView(this.FxI, localLayoutParams);
    AppMethodBeat.o(104726);
  }
  
  public final void fis()
  {
    AppMethodBeat.i(104727);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 5;
    addView(this.FxI, localLayoutParams);
    AppMethodBeat.o(104727);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104725);
    this.FxD = getContext().getResources().getDimensionPixelSize(2131166264);
    this.FxE = getContext().getResources().getDimensionPixelSize(2131166261);
    this.FxG = getContext().getResources().getDimensionPixelSize(2131166267);
    this.FxH = getContext().getResources().getDimensionPixelSize(2131166266);
    this.FxI = new ChattingEmojiView(getContext());
    this.FxJ = new ProgressBar(getContext());
    this.FxJ.setIndeterminateDrawable(getResources().getDrawable(2131233684));
    this.CnN = new TextView(getContext());
    this.CnN.setText(2131758294);
    this.CnN.setTextColor(getResources().getColor(2131100275));
    int i = a.fromDPToPix(getContext(), 32);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    addView(this.FxJ, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(this.CnN, localLayoutParams);
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
      if ((this.pOS == null) || (this.pOS.field_height == 0)) {
        break label155;
      }
    }
    label155:
    for (int i = Math.max((int)(this.pOS.field_height * this.FxI.getEmojiDensityScale()), this.FxE);; i = this.FxD)
    {
      int j = i;
      if (i > this.FxD) {
        j = this.FxD;
      }
      this.FxF = this.FxG;
      if ((j >= this.FxE) && (j < this.FxE + (this.FxG - this.FxH)))
      {
        i = this.FxH;
        this.FxF = (j - this.FxE + i);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(104733);
      return;
    }
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(104731);
    ae.i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 3)
    {
      this.uyF = false;
      this.FxI.reload();
      AppMethodBeat.o(104731);
      return true;
    }
    if (this.mStatus == 2)
    {
      boolean bool = super.performClick();
      AppMethodBeat.o(104731);
      return bool;
    }
    ae.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
    AppMethodBeat.o(104731);
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104730);
    ZW(2);
    if ((this.FxI != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.FxI.getEmojiDensity());
      this.FxI.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */