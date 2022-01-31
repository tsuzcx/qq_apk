package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView
  extends FrameLayout
{
  private EmojiInfo lkU;
  private int mStatus = -1;
  private boolean nxs = true;
  private TextView tsa;
  private int waf;
  private int wag;
  private int wah;
  private int wai;
  private int waj;
  public ChattingEmojiView wak;
  private ProgressBar wal;
  private FrameLayout.LayoutParams wam;
  private FrameLayout.LayoutParams wan;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Mr(int paramInt)
  {
    AppMethodBeat.i(62497);
    this.mStatus = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62497);
      return;
      this.wal.setVisibility(0);
      this.tsa.setVisibility(4);
      this.wak.setVisibility(4);
      setBackgroundResource(2130840999);
      AppMethodBeat.o(62497);
      return;
      this.wal.setVisibility(0);
      this.tsa.setVisibility(4);
      this.wak.setVisibility(4);
      setBackgroundResource(2130838323);
      AppMethodBeat.o(62497);
      return;
      Drawable localDrawable = getResources().getDrawable(2130838615);
      localDrawable.setBounds(0, 0, this.wah, this.wah);
      ab.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.wah), Integer.valueOf(hashCode()) });
      this.tsa.setCompoundDrawables(null, localDrawable, null, null);
      this.tsa.setText(2131299168);
      this.tsa.setVisibility(0);
      this.wal.setVisibility(4);
      this.wak.setVisibility(4);
      setBackgroundResource(2130838323);
      AppMethodBeat.o(62497);
      return;
      this.wak.setVisibility(0);
      this.wal.setVisibility(4);
      this.tsa.setVisibility(4);
      setBackgroundResource(2130840999);
    }
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(62493);
    a(paramEmojiInfo, paramLong, new ap(""));
    AppMethodBeat.o(62493);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong, ap paramap)
  {
    boolean bool2 = false;
    AppMethodBeat.i(62494);
    ab.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(paramLong) });
    this.lkU = paramEmojiInfo;
    if (this.lkU.vY())
    {
      this.wak.setStatus(1);
      Mr(2);
      Object localObject = ((j)g.E(j.class)).bPQ().kB(paramLong);
      if ((((dd)localObject).field_status == 2) || (((dd)localObject).field_status == 3) || (((dd)localObject).field_status == 5)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = this.wak;
        if (!paramap.fXr) {
          bool2 = true;
        }
        ((ChattingEmojiView)localObject).a(bool2, bool1, ((PluginEmoji)g.G(PluginEmoji.class)).getEmojiMgr().o(paramEmojiInfo), ((PluginEmoji)g.G(PluginEmoji.class)).getEmojiMgr().p(paramEmojiInfo), paramEmojiInfo.getName(), String.valueOf(paramLong + paramEmojiInfo.getName()));
        AppMethodBeat.o(62494);
        return;
      }
    }
    this.nxs = true;
    this.wak.setStatusListener(new RTChattingEmojiView.1(this));
    this.wak.a(this.lkU, paramLong);
    AppMethodBeat.o(62494);
  }
  
  public final void dpa()
  {
    AppMethodBeat.i(62491);
    this.wan.gravity = 3;
    addView(this.wak, this.wan);
    AppMethodBeat.o(62491);
  }
  
  public final void dpb()
  {
    AppMethodBeat.i(62492);
    this.wan.gravity = 5;
    addView(this.wak, this.wan);
    AppMethodBeat.o(62492);
  }
  
  public void initView()
  {
    AppMethodBeat.i(62490);
    this.waf = getContext().getResources().getDimensionPixelSize(2131428398);
    this.wag = getContext().getResources().getDimensionPixelSize(2131428395);
    this.wai = getContext().getResources().getDimensionPixelSize(2131428401);
    this.waj = getContext().getResources().getDimensionPixelSize(2131428400);
    this.wak = new ChattingEmojiView(getContext());
    this.wal = new ProgressBar(getContext());
    this.wal.setIndeterminateDrawable(getResources().getDrawable(2130840009));
    this.tsa = new TextView(getContext());
    this.tsa.setText(2131299168);
    this.tsa.setTextColor(getResources().getColor(2131689981));
    this.wam = new FrameLayout.LayoutParams(-2, -2);
    this.wan = new FrameLayout.LayoutParams(-2, -2);
    this.wam.gravity = 17;
    addView(this.wal, this.wam);
    addView(this.tsa, this.wam);
    AppMethodBeat.o(62490);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(62499);
    super.onAttachedToWindow();
    AppMethodBeat.o(62499);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(62500);
    super.onDetachedFromWindow();
    AppMethodBeat.o(62500);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62498);
    if ((this.mStatus == 0) || (this.mStatus == 1) || (this.mStatus == 3))
    {
      if ((this.lkU != null) && (this.lkU.field_height != 0))
      {
        paramInt1 = (int)(this.lkU.field_height * this.wak.getEmojiDensityScale());
        if (paramInt1 < this.wag) {}
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 > this.waf) {
          paramInt2 = this.waf;
        }
        this.wah = this.wai;
        if ((paramInt2 >= this.wag) && (paramInt2 < this.wag + (this.wai - this.waj))) {
          this.wah = (this.waj + (paramInt2 - this.wag));
        }
        paramInt1 = this.waf;
        setMeasuredDimension(paramInt1, paramInt2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        Mr(this.mStatus);
        AppMethodBeat.o(62498);
        return;
        paramInt1 = this.wag;
        continue;
        paramInt1 = this.waf;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(62498);
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(62496);
    ab.i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 3)
    {
      this.nxs = false;
      this.wak.reload();
      AppMethodBeat.o(62496);
      return true;
    }
    if (this.mStatus == 2)
    {
      boolean bool = super.performClick();
      AppMethodBeat.o(62496);
      return bool;
    }
    ab.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
    AppMethodBeat.o(62496);
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(62495);
    Mr(2);
    if ((this.wak != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.wak.getEmojiDensity());
      this.wak.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(62495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */