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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.cd.a;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView
  extends FrameLayout
{
  private boolean IPg = true;
  private ProgressBar PvQ;
  private TextView UtY;
  private int YlB;
  private int YlC;
  private int YlD;
  private int YlE;
  private int YlF;
  public ChattingEmojiView YlG;
  private int mStatus = -1;
  private EmojiInfo xRp;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void awQ(int paramInt)
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
      this.PvQ.setVisibility(0);
      this.UtY.setVisibility(4);
      this.YlG.setVisibility(4);
      setBackgroundResource(a.f.transparent_background);
      AppMethodBeat.o(104732);
      return;
      this.PvQ.setVisibility(0);
      this.UtY.setVisibility(4);
      this.YlG.setVisibility(4);
      setBackgroundResource(a.f.chatting_item_emoji_bg);
      AppMethodBeat.o(104732);
      return;
      Drawable localDrawable = getResources().getDrawable(a.f.emoji_download_icon_samll);
      localDrawable.setBounds(0, 0, this.YlD, this.YlD);
      Log.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.YlD), Integer.valueOf(hashCode()) });
      this.UtY.setCompoundDrawables(null, localDrawable, null, null);
      this.UtY.setText(a.j.emoji_retry_download);
      this.UtY.setVisibility(0);
      this.PvQ.setVisibility(4);
      this.YlG.setVisibility(4);
      setBackgroundResource(a.f.chatting_item_emoji_bg);
      AppMethodBeat.o(104732);
      return;
      this.YlG.setVisibility(0);
      this.PvQ.setVisibility(4);
      this.UtY.setVisibility(4);
      setBackgroundResource(a.f.transparent_background);
    }
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104728);
    a(paramEmojiInfo, paramLong, new bg(""));
    AppMethodBeat.o(104728);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong, bg parambg)
  {
    boolean bool2 = false;
    AppMethodBeat.i(104729);
    Log.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(paramLong) });
    this.xRp = paramEmojiInfo;
    if (this.xRp.aqJ())
    {
      this.YlG.setStatus(1);
      awQ(2);
      Object localObject = ((n)h.ax(n.class)).gaZ().sl(paramLong);
      if ((((fi)localObject).field_status == 2) || (((fi)localObject).field_status == 3) || (((fi)localObject).field_status == 5)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = this.YlG;
        if (!parambg.paW) {
          bool2 = true;
        }
        ((ChattingEmojiView)localObject).a(bool2, bool1, ((PluginEmoji)h.az(PluginEmoji.class)).getEmojiMgr().q(paramEmojiInfo), ((PluginEmoji)h.az(PluginEmoji.class)).getEmojiMgr().r(paramEmojiInfo), paramEmojiInfo.getName(), String.valueOf(paramLong + paramEmojiInfo.getName()));
        AppMethodBeat.o(104729);
        return;
      }
    }
    this.IPg = true;
    this.YlG.setStatusListener(new EmojiStatusView.b()
    {
      public final void rJ(int paramAnonymousInt)
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
    this.YlG.a(this.xRp, paramLong);
    AppMethodBeat.o(104729);
  }
  
  public final void iNs()
  {
    AppMethodBeat.i(104726);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    addView(this.YlG, localLayoutParams);
    AppMethodBeat.o(104726);
  }
  
  public final void iNt()
  {
    AppMethodBeat.i(104727);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 5;
    addView(this.YlG, localLayoutParams);
    AppMethodBeat.o(104727);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104725);
    this.YlB = getContext().getResources().getDimensionPixelSize(a.e.emoji_view_image_size);
    this.YlC = getContext().getResources().getDimensionPixelSize(a.e.emoji_view_chatting_min_size);
    this.YlE = getContext().getResources().getDimensionPixelSize(a.e.emoji_view_refresh_size);
    this.YlF = getContext().getResources().getDimensionPixelSize(a.e.emoji_view_refresh_min_size);
    this.YlG = new ChattingEmojiView(getContext());
    this.PvQ = new ProgressBar(getContext());
    this.PvQ.setIndeterminateDrawable(getResources().getDrawable(a.f.progress_small_holo));
    this.UtY = new TextView(getContext());
    this.UtY.setText(a.j.emoji_retry_download);
    this.UtY.setTextColor(getResources().getColor(a.d.emoji_load_text_color));
    int i = a.fromDPToPix(getContext(), 32);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    addView(this.PvQ, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(this.UtY, localLayoutParams);
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
      if ((this.xRp == null) || (this.xRp.field_height == 0)) {
        break label155;
      }
    }
    label155:
    for (int i = Math.max((int)(this.xRp.field_height * this.YlG.getEmojiDensityScale()), this.YlC);; i = this.YlB)
    {
      int j = i;
      if (i > this.YlB) {
        j = this.YlB;
      }
      this.YlD = this.YlE;
      if ((j >= this.YlC) && (j < this.YlC + (this.YlE - this.YlF)))
      {
        i = this.YlF;
        this.YlD = (j - this.YlC + i);
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
      this.IPg = false;
      this.YlG.reload();
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
    awQ(2);
    if ((this.YlG != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.YlG.getEmojiDensity());
      this.YlG.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */