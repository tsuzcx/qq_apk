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
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class RTChattingEmojiView
  extends FrameLayout
{
  private int ChF;
  private int ChG;
  private int ChH;
  private int ChI;
  private int ChJ;
  public ChattingEmojiView ChK;
  private ProgressBar ChL;
  private FrameLayout.LayoutParams ChM;
  private FrameLayout.LayoutParams ChN;
  private int mStatus = -1;
  private EmojiInfo oBl;
  private boolean sgS = true;
  private TextView zel;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Vl(int paramInt)
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
      this.ChL.setVisibility(0);
      this.zel.setVisibility(4);
      this.ChK.setVisibility(4);
      setBackgroundResource(2131234429);
      AppMethodBeat.o(104732);
      return;
      this.ChL.setVisibility(0);
      this.zel.setVisibility(4);
      this.ChK.setVisibility(4);
      setBackgroundResource(2131231680);
      AppMethodBeat.o(104732);
      return;
      Drawable localDrawable = getResources().getDrawable(2131232026);
      localDrawable.setBounds(0, 0, this.ChH, this.ChH);
      ad.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.ChH), Integer.valueOf(hashCode()) });
      this.zel.setCompoundDrawables(null, localDrawable, null, null);
      this.zel.setText(2131758294);
      this.zel.setVisibility(0);
      this.ChL.setVisibility(4);
      this.ChK.setVisibility(4);
      setBackgroundResource(2131231680);
      AppMethodBeat.o(104732);
      return;
      this.ChK.setVisibility(0);
      this.ChL.setVisibility(4);
      this.zel.setVisibility(4);
      setBackgroundResource(2131234429);
    }
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104728);
    a(paramEmojiInfo, paramLong, new ar(""));
    AppMethodBeat.o(104728);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong, ar paramar)
  {
    boolean bool2 = false;
    AppMethodBeat.i(104729);
    ad.i("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo %s msgId %s", new Object[] { paramEmojiInfo.field_md5, Long.valueOf(paramLong) });
    this.oBl = paramEmojiInfo;
    if (this.oBl.CZ())
    {
      this.ChK.setStatus(1);
      Vl(2);
      Object localObject = ((k)g.ab(k.class)).cOI().rm(paramLong);
      if ((((du)localObject).field_status == 2) || (((du)localObject).field_status == 3) || (((du)localObject).field_status == 5)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = this.ChK;
        if (!paramar.hAc) {
          bool2 = true;
        }
        ((ChattingEmojiView)localObject).a(bool2, bool1, ((PluginEmoji)g.ad(PluginEmoji.class)).getEmojiMgr().q(paramEmojiInfo), ((PluginEmoji)g.ad(PluginEmoji.class)).getEmojiMgr().r(paramEmojiInfo), paramEmojiInfo.getName(), String.valueOf(paramLong + paramEmojiInfo.getName()));
        AppMethodBeat.o(104729);
        return;
      }
    }
    this.sgS = true;
    this.ChK.setStatusListener(new EmojiStatusView.b()
    {
      public final void lG(int paramAnonymousInt)
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
    this.ChK.a(this.oBl, paramLong);
    AppMethodBeat.o(104729);
  }
  
  public final void eAf()
  {
    AppMethodBeat.i(104726);
    this.ChN.gravity = 3;
    addView(this.ChK, this.ChN);
    AppMethodBeat.o(104726);
  }
  
  public final void eAg()
  {
    AppMethodBeat.i(104727);
    this.ChN.gravity = 5;
    addView(this.ChK, this.ChN);
    AppMethodBeat.o(104727);
  }
  
  public void initView()
  {
    AppMethodBeat.i(104725);
    this.ChF = getContext().getResources().getDimensionPixelSize(2131166264);
    this.ChG = getContext().getResources().getDimensionPixelSize(2131166261);
    this.ChI = getContext().getResources().getDimensionPixelSize(2131166267);
    this.ChJ = getContext().getResources().getDimensionPixelSize(2131166266);
    this.ChK = new ChattingEmojiView(getContext());
    this.ChL = new ProgressBar(getContext());
    this.ChL.setIndeterminateDrawable(getResources().getDrawable(2131233684));
    this.zel = new TextView(getContext());
    this.zel.setText(2131758294);
    this.zel.setTextColor(getResources().getColor(2131100275));
    this.ChM = new FrameLayout.LayoutParams(-2, -2);
    this.ChN = new FrameLayout.LayoutParams(-2, -2);
    this.ChM.gravity = 17;
    addView(this.ChL, this.ChM);
    addView(this.zel, this.ChM);
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
    if ((this.mStatus == 0) || (this.mStatus == 1) || (this.mStatus == 3))
    {
      if ((this.oBl != null) && (this.oBl.field_height != 0))
      {
        paramInt1 = (int)(this.oBl.field_height * this.ChK.getEmojiDensityScale());
        if (paramInt1 < this.ChG) {}
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 > this.ChF) {
          paramInt2 = this.ChF;
        }
        this.ChH = this.ChI;
        if ((paramInt2 >= this.ChG) && (paramInt2 < this.ChG + (this.ChI - this.ChJ))) {
          this.ChH = (this.ChJ + (paramInt2 - this.ChG));
        }
        paramInt1 = this.ChF;
        setMeasuredDimension(paramInt1, paramInt2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        Vl(this.mStatus);
        AppMethodBeat.o(104733);
        return;
        paramInt1 = this.ChG;
        continue;
        paramInt1 = this.ChF;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(104733);
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(104731);
    ad.i("MicroMsg.emoji.RTChattingEmojiView", "performClick: %s", new Object[] { Integer.valueOf(this.mStatus) });
    if (this.mStatus == 3)
    {
      this.sgS = false;
      this.ChK.reload();
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
    Vl(2);
    if ((this.ChK != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.ChK.getEmojiDensity());
      this.ChK.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */