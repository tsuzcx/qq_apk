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
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView
  extends FrameLayout
{
  private TextView AwR;
  private int DAa;
  public ChattingEmojiView DAb;
  private ProgressBar DAc;
  private FrameLayout.LayoutParams DAd;
  private FrameLayout.LayoutParams DAe;
  private int DzW;
  private int DzX;
  private int DzY;
  private int DzZ;
  private int mStatus = -1;
  private EmojiInfo peL;
  private boolean toM = true;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Xu(int paramInt)
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
      this.DAc.setVisibility(0);
      this.AwR.setVisibility(4);
      this.DAb.setVisibility(4);
      setBackgroundResource(2131234429);
      AppMethodBeat.o(104732);
      return;
      this.DAc.setVisibility(0);
      this.AwR.setVisibility(4);
      this.DAb.setVisibility(4);
      setBackgroundResource(2131231680);
      AppMethodBeat.o(104732);
      return;
      Drawable localDrawable = getResources().getDrawable(2131232026);
      localDrawable.setBounds(0, 0, this.DzY, this.DzY);
      ac.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.DzY), Integer.valueOf(hashCode()) });
      this.AwR.setCompoundDrawables(null, localDrawable, null, null);
      this.AwR.setText(2131758294);
      this.AwR.setVisibility(0);
      this.DAc.setVisibility(4);
      this.DAb.setVisibility(4);
      setBackgroundResource(2131231680);
      AppMethodBeat.o(104732);
      return;
      this.DAb.setVisibility(0);
      this.DAc.setVisibility(4);
      this.AwR.setVisibility(4);
      setBackgroundResource(2131234429);
    }
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104728);
    a(paramEmojiInfo, paramLong, new au(""));
    AppMethodBeat.o(104728);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong, au paramau)
  {
    boolean bool2 = false;
    AppMethodBeat.i(104729);
    ac.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(paramLong) });
    this.peL = paramEmojiInfo;
    if (this.peL.CC())
    {
      this.DAb.setStatus(1);
      Xu(2);
      Object localObject = ((k)g.ab(k.class)).dcr().vP(paramLong);
      if ((((dy)localObject).field_status == 2) || (((dy)localObject).field_status == 3) || (((dy)localObject).field_status == 5)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = this.DAb;
        if (!paramau.iaD) {
          bool2 = true;
        }
        ((ChattingEmojiView)localObject).a(bool2, bool1, ((PluginEmoji)g.ad(PluginEmoji.class)).getEmojiMgr().q(paramEmojiInfo), ((PluginEmoji)g.ad(PluginEmoji.class)).getEmojiMgr().r(paramEmojiInfo), paramEmojiInfo.getName(), String.valueOf(paramLong + paramEmojiInfo.getName()));
        AppMethodBeat.o(104729);
        return;
      }
    }
    this.toM = true;
    this.DAb.setStatusListener(new EmojiStatusView.b()
    {
      public final void lD(int paramAnonymousInt)
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
    this.DAb.a(this.peL, paramLong);
    AppMethodBeat.o(104729);
  }
  
  public final void ePA()
  {
    AppMethodBeat.i(104727);
    this.DAe.gravity = 5;
    addView(this.DAb, this.DAe);
    AppMethodBeat.o(104727);
  }
  
  public final void ePz()
  {
    AppMethodBeat.i(104726);
    this.DAe.gravity = 3;
    addView(this.DAb, this.DAe);
    AppMethodBeat.o(104726);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104725);
    this.DzW = getContext().getResources().getDimensionPixelSize(2131166264);
    this.DzX = getContext().getResources().getDimensionPixelSize(2131166261);
    this.DzZ = getContext().getResources().getDimensionPixelSize(2131166267);
    this.DAa = getContext().getResources().getDimensionPixelSize(2131166266);
    this.DAb = new ChattingEmojiView(getContext());
    this.DAc = new ProgressBar(getContext());
    this.DAc.setIndeterminateDrawable(getResources().getDrawable(2131233684));
    this.AwR = new TextView(getContext());
    this.AwR.setText(2131758294);
    this.AwR.setTextColor(getResources().getColor(2131100275));
    this.DAd = new FrameLayout.LayoutParams(-2, -2);
    this.DAe = new FrameLayout.LayoutParams(-2, -2);
    this.DAd.gravity = 17;
    addView(this.DAc, this.DAd);
    addView(this.AwR, this.DAd);
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
    int i;
    if ((this.mStatus == 0) || (this.mStatus == 1) || (this.mStatus == 3))
    {
      if ((this.peL == null) || (this.peL.field_height == 0)) {
        break label164;
      }
      i = (int)(this.peL.field_height * this.DAb.getEmojiDensityScale());
      if (i < this.DzX) {
        break label156;
      }
    }
    for (;;)
    {
      int j = i;
      if (i > this.DzW) {
        j = this.DzW;
      }
      this.DzY = this.DzZ;
      if ((j >= this.DzX) && (j < this.DzX + (this.DzZ - this.DAa)))
      {
        i = this.DAa;
        this.DzY = (j - this.DzX + i);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(104733);
      return;
      label156:
      i = this.DzX;
      continue;
      label164:
      i = this.DzW;
    }
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(104731);
    ac.i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 3)
    {
      this.toM = false;
      this.DAb.reload();
      AppMethodBeat.o(104731);
      return true;
    }
    if (this.mStatus == 2)
    {
      boolean bool = super.performClick();
      AppMethodBeat.o(104731);
      return bool;
    }
    ac.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
    AppMethodBeat.o(104731);
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104730);
    Xu(2);
    if ((this.DAb != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.DAb.getEmojiDensity());
      this.DAb.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */