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
import com.tencent.mm.ci.a;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.f.c.et;
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
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView
  extends FrameLayout
{
  private boolean CUO = true;
  private TextView NHX;
  private int Rpk;
  private int Rpl;
  private int Rpm;
  private int Rpn;
  private int Rpo;
  public ChattingEmojiView Rpp;
  private ProgressBar Rpq;
  private int mStatus = -1;
  private EmojiInfo uIz;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aqK(int paramInt)
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
      this.Rpq.setVisibility(0);
      this.NHX.setVisibility(4);
      this.Rpp.setVisibility(4);
      setBackgroundResource(a.f.transparent_background);
      AppMethodBeat.o(104732);
      return;
      this.Rpq.setVisibility(0);
      this.NHX.setVisibility(4);
      this.Rpp.setVisibility(4);
      setBackgroundResource(a.f.chatting_item_emoji_bg);
      AppMethodBeat.o(104732);
      return;
      Drawable localDrawable = getResources().getDrawable(a.f.emoji_download_icon_samll);
      localDrawable.setBounds(0, 0, this.Rpm, this.Rpm);
      Log.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.Rpm), Integer.valueOf(hashCode()) });
      this.NHX.setCompoundDrawables(null, localDrawable, null, null);
      this.NHX.setText(a.j.emoji_retry_download);
      this.NHX.setVisibility(0);
      this.Rpq.setVisibility(4);
      this.Rpp.setVisibility(4);
      setBackgroundResource(a.f.chatting_item_emoji_bg);
      AppMethodBeat.o(104732);
      return;
      this.Rpp.setVisibility(0);
      this.Rpq.setVisibility(4);
      this.NHX.setVisibility(4);
      setBackgroundResource(a.f.transparent_background);
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
    this.uIz = paramEmojiInfo;
    if (this.uIz.Qv())
    {
      this.Rpp.setStatus(1);
      aqK(2);
      Object localObject = ((n)h.ae(n.class)).eSe().Oq(paramLong);
      if ((((et)localObject).field_status == 2) || (((et)localObject).field_status == 3) || (((et)localObject).field_status == 5)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = this.Rpp;
        if (!parambe.mhL) {
          bool2 = true;
        }
        ((ChattingEmojiView)localObject).a(bool2, bool1, ((PluginEmoji)h.ag(PluginEmoji.class)).getEmojiMgr().q(paramEmojiInfo), ((PluginEmoji)h.ag(PluginEmoji.class)).getEmojiMgr().r(paramEmojiInfo), paramEmojiInfo.getName(), String.valueOf(paramLong + paramEmojiInfo.getName()));
        AppMethodBeat.o(104729);
        return;
      }
    }
    this.CUO = true;
    this.Rpp.setStatusListener(new EmojiStatusView.b()
    {
      public final void rH(int paramAnonymousInt)
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
    this.Rpp.a(this.uIz, paramLong);
    AppMethodBeat.o(104729);
  }
  
  public final void hmC()
  {
    AppMethodBeat.i(104726);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    addView(this.Rpp, localLayoutParams);
    AppMethodBeat.o(104726);
  }
  
  public final void hmD()
  {
    AppMethodBeat.i(104727);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 5;
    addView(this.Rpp, localLayoutParams);
    AppMethodBeat.o(104727);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104725);
    this.Rpk = getContext().getResources().getDimensionPixelSize(a.e.emoji_view_image_size);
    this.Rpl = getContext().getResources().getDimensionPixelSize(a.e.emoji_view_chatting_min_size);
    this.Rpn = getContext().getResources().getDimensionPixelSize(a.e.emoji_view_refresh_size);
    this.Rpo = getContext().getResources().getDimensionPixelSize(a.e.emoji_view_refresh_min_size);
    this.Rpp = new ChattingEmojiView(getContext());
    this.Rpq = new ProgressBar(getContext());
    this.Rpq.setIndeterminateDrawable(getResources().getDrawable(a.f.progress_small_holo));
    this.NHX = new TextView(getContext());
    this.NHX.setText(a.j.emoji_retry_download);
    this.NHX.setTextColor(getResources().getColor(a.d.emoji_load_text_color));
    int i = a.fromDPToPix(getContext(), 32);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    addView(this.Rpq, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(this.NHX, localLayoutParams);
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
      if ((this.uIz == null) || (this.uIz.field_height == 0)) {
        break label155;
      }
    }
    label155:
    for (int i = Math.max((int)(this.uIz.field_height * this.Rpp.getEmojiDensityScale()), this.Rpl);; i = this.Rpk)
    {
      int j = i;
      if (i > this.Rpk) {
        j = this.Rpk;
      }
      this.Rpm = this.Rpn;
      if ((j >= this.Rpl) && (j < this.Rpl + (this.Rpn - this.Rpo)))
      {
        i = this.Rpo;
        this.Rpm = (j - this.Rpl + i);
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
      this.CUO = false;
      this.Rpp.reload();
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
    aqK(2);
    if ((this.Rpp != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.Rpp.getEmojiDensity());
      this.Rpp.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */