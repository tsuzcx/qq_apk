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
import com.tencent.mm.cc.a;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView
  extends FrameLayout
{
  private TextView BWm;
  private int Fff;
  private int Ffg;
  private int Ffh;
  private int Ffi;
  private int Ffj;
  public ChattingEmojiView Ffk;
  private ProgressBar Ffl;
  private int mStatus = -1;
  private EmojiInfo pIn;
  private boolean unj = true;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Zq(int paramInt)
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
      this.Ffl.setVisibility(0);
      this.BWm.setVisibility(4);
      this.Ffk.setVisibility(4);
      setBackgroundResource(2131234429);
      AppMethodBeat.o(104732);
      return;
      this.Ffl.setVisibility(0);
      this.BWm.setVisibility(4);
      this.Ffk.setVisibility(4);
      setBackgroundResource(2131231680);
      AppMethodBeat.o(104732);
      return;
      Drawable localDrawable = getResources().getDrawable(2131232026);
      localDrawable.setBounds(0, 0, this.Ffh, this.Ffh);
      ad.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.Ffh), Integer.valueOf(hashCode()) });
      this.BWm.setCompoundDrawables(null, localDrawable, null, null);
      this.BWm.setText(2131758294);
      this.BWm.setVisibility(0);
      this.Ffl.setVisibility(4);
      this.Ffk.setVisibility(4);
      setBackgroundResource(2131231680);
      AppMethodBeat.o(104732);
      return;
      this.Ffk.setVisibility(0);
      this.Ffl.setVisibility(4);
      this.BWm.setVisibility(4);
      setBackgroundResource(2131234429);
    }
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104728);
    a(paramEmojiInfo, paramLong, new ay(""));
    AppMethodBeat.o(104728);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong, ay paramay)
  {
    boolean bool2 = false;
    AppMethodBeat.i(104729);
    ad.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(paramLong) });
    this.pIn = paramEmojiInfo;
    if (this.pIn.Eb())
    {
      this.Ffk.setStatus(1);
      Zq(2);
      Object localObject = ((l)g.ab(l.class)).dlK().xY(paramLong);
      if ((((ei)localObject).field_status == 2) || (((ei)localObject).field_status == 3) || (((ei)localObject).field_status == 5)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = this.Ffk;
        if (!paramay.itZ) {
          bool2 = true;
        }
        ((ChattingEmojiView)localObject).a(bool2, bool1, ((PluginEmoji)g.ad(PluginEmoji.class)).getEmojiMgr().q(paramEmojiInfo), ((PluginEmoji)g.ad(PluginEmoji.class)).getEmojiMgr().r(paramEmojiInfo), paramEmojiInfo.getName(), String.valueOf(paramLong + paramEmojiInfo.getName()));
        AppMethodBeat.o(104729);
        return;
      }
    }
    this.unj = true;
    this.Ffk.setStatusListener(new EmojiStatusView.b()
    {
      public final void md(int paramAnonymousInt)
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
    this.Ffk.a(this.pIn, paramLong);
    AppMethodBeat.o(104729);
  }
  
  public final void feB()
  {
    AppMethodBeat.i(104726);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    addView(this.Ffk, localLayoutParams);
    AppMethodBeat.o(104726);
  }
  
  public final void feC()
  {
    AppMethodBeat.i(104727);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 5;
    addView(this.Ffk, localLayoutParams);
    AppMethodBeat.o(104727);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104725);
    this.Fff = getContext().getResources().getDimensionPixelSize(2131166264);
    this.Ffg = getContext().getResources().getDimensionPixelSize(2131166261);
    this.Ffi = getContext().getResources().getDimensionPixelSize(2131166267);
    this.Ffj = getContext().getResources().getDimensionPixelSize(2131166266);
    this.Ffk = new ChattingEmojiView(getContext());
    this.Ffl = new ProgressBar(getContext());
    this.Ffl.setIndeterminateDrawable(getResources().getDrawable(2131233684));
    this.BWm = new TextView(getContext());
    this.BWm.setText(2131758294);
    this.BWm.setTextColor(getResources().getColor(2131100275));
    int i = a.fromDPToPix(getContext(), 32);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
    localLayoutParams.gravity = 17;
    addView(this.Ffl, localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(this.BWm, localLayoutParams);
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
      if ((this.pIn == null) || (this.pIn.field_height == 0)) {
        break label155;
      }
    }
    label155:
    for (int i = Math.max((int)(this.pIn.field_height * this.Ffk.getEmojiDensityScale()), this.Ffg);; i = this.Fff)
    {
      int j = i;
      if (i > this.Fff) {
        j = this.Fff;
      }
      this.Ffh = this.Ffi;
      if ((j >= this.Ffg) && (j < this.Ffg + (this.Ffi - this.Ffj)))
      {
        i = this.Ffj;
        this.Ffh = (j - this.Ffg + i);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(104733);
      return;
    }
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(104731);
    ad.i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 3)
    {
      this.unj = false;
      this.Ffk.reload();
      AppMethodBeat.o(104731);
      return true;
    }
    if (this.mStatus == 2)
    {
      boolean bool = super.performClick();
      AppMethodBeat.o(104731);
      return bool;
    }
    ad.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
    AppMethodBeat.o(104731);
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104730);
    Zq(2);
    if ((this.Ffk != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.Ffk.getEmojiDensity());
      this.Ffk.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */