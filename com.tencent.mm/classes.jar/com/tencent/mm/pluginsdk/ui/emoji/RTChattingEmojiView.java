package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.f;
import com.tencent.mm.h.a.cr;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.l.a.b;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

public class RTChattingEmojiView
  extends FrameLayout
{
  private EmojiInfo jck;
  private int mStatus = -1;
  private TextView pMe;
  private int shN;
  private int shO;
  private int shP;
  private int shQ;
  private int shR;
  public ChattingEmojiView shS;
  private ProgressBar shT;
  private FrameLayout.LayoutParams shU;
  FrameLayout.LayoutParams shV;
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RTChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Et(int paramInt)
  {
    this.mStatus = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.shT.setVisibility(0);
      this.pMe.setVisibility(4);
      this.shS.setVisibility(4);
      setBackgroundResource(a.d.transparent_background);
      return;
    case 1: 
      this.shT.setVisibility(0);
      this.pMe.setVisibility(4);
      this.shS.setVisibility(4);
      setBackgroundResource(a.d.chatting_item_emoji_bg);
      return;
    case 3: 
      Drawable localDrawable = getResources().getDrawable(a.d.emoji_download_icon_samll);
      localDrawable.setBounds(0, 0, this.shP, this.shP);
      y.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", new Object[] { Integer.valueOf(this.shP), Integer.valueOf(hashCode()) });
      this.pMe.setCompoundDrawables(null, localDrawable, null, null);
      this.pMe.setText(a.h.emoji_retry_download);
      this.pMe.setVisibility(0);
      this.shT.setVisibility(4);
      this.shS.setVisibility(4);
      setBackgroundResource(a.d.chatting_item_emoji_bg);
      return;
    }
    this.shS.setVisibility(0);
    this.shT.setVisibility(4);
    this.pMe.setVisibility(4);
    setBackgroundResource(a.d.transparent_background);
  }
  
  private void cnT()
  {
    cr localcr = new cr();
    localcr.bIQ.bIR = this.jck;
    localcr.bIQ.scene = 0;
    a.udP.m(localcr);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    a(paramEmojiInfo, paramLong, new ap(""));
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong, ap paramap)
  {
    y.d("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo");
    this.jck = paramEmojiInfo;
    Object localObject;
    boolean bool1;
    boolean bool2;
    int i;
    int[] arrayOfInt;
    String str1;
    String str2;
    c localc;
    Context localContext;
    if (this.jck.ZH())
    {
      Et(2);
      localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramLong);
      if ((((cs)localObject).field_status == 2) || (((cs)localObject).field_status == 3) || (((cs)localObject).field_status == 5))
      {
        bool1 = true;
        localObject = this.shS;
        if (paramap.eHB) {
          break label238;
        }
      }
      label225:
      label238:
      for (bool2 = true;; bool2 = false)
      {
        i = ((PluginEmoji)com.tencent.mm.kernel.g.t(PluginEmoji.class)).getEmojiMgr().e(paramEmojiInfo);
        arrayOfInt = ((PluginEmoji)com.tencent.mm.kernel.g.t(PluginEmoji.class)).getEmojiMgr().f(paramEmojiInfo);
        str1 = paramEmojiInfo.getName();
        str2 = String.valueOf(paramLong + paramEmojiInfo.getName());
        if (bk.bl(str2)) {
          break label379;
        }
        ((MMAnimateView)localObject).setCacheKey(str2);
        localc = c.baM();
        localContext = ((MMAnimateView)localObject).getContext();
        if (!TextUtils.isEmpty(str1)) {
          break label244;
        }
        paramEmojiInfo = null;
        if (paramEmojiInfo == null) {
          break label369;
        }
        paramEmojiInfo.lis = bool1;
        if (bool2 != paramEmojiInfo.mIsPlaying) {
          break label347;
        }
        paramEmojiInfo.start();
        ((MMAnimateView)localObject).setImageDrawable(paramEmojiInfo);
        return;
        bool1 = false;
        break;
      }
      label244:
      if ((localc.lhC.get(str2) == null) || (((WeakReference)localc.lhC.get(str2)).get() == null)) {
        break label620;
      }
    }
    label347:
    label620:
    for (paramap = (com.tencent.mm.plugin.gif.e)((WeakReference)localc.lhC.get(str2)).get();; paramap = null)
    {
      paramEmojiInfo = paramap;
      if (paramap != null) {
        break;
      }
      paramEmojiInfo = new com.tencent.mm.plugin.gif.e(localContext, bool2, bool1, i, arrayOfInt, str1);
      localc.lhC.put(str2, new WeakReference(paramEmojiInfo));
      break;
      paramEmojiInfo.jiU = 0;
      paramEmojiInfo.liu = 0;
      paramEmojiInfo.mIsPlaying = true;
      paramEmojiInfo.start();
      break label225;
      label369:
      y.e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
      return;
      label379:
      paramEmojiInfo = new com.tencent.mm.plugin.gif.e(((MMAnimateView)localObject).getContext(), bool2, bool1, i, arrayOfInt, str1);
      paramEmojiInfo.start();
      ((MMAnimateView)localObject).setImageDrawable(paramEmojiInfo);
      return;
      if (this.jck.cwC())
      {
        Et(2);
        this.shS.b(EmojiInfo.bv(getContext(), paramEmojiInfo.getName()), String.valueOf(paramLong));
        return;
      }
      paramap = this.jck.cwL();
      if (com.tencent.mm.vfs.e.aeQ(paramap) > 0L)
      {
        Et(2);
        paramEmojiInfo = com.tencent.mm.vfs.e.c(paramap, 0, 10);
        if ((paramEmojiInfo != null) && (!o.by(paramEmojiInfo)))
        {
          this.shS.a(this.jck, ((PluginEmoji)com.tencent.mm.kernel.g.t(PluginEmoji.class)).getEmojiMgr().a(this.jck), String.valueOf(paramLong));
          return;
        }
        this.shS.du(paramap, String.valueOf(paramLong));
        return;
      }
      y.i("MicroMsg.emoji.RTChattingEmojiView", "try download emoji %s, state %d", new Object[] { paramEmojiInfo.Wv(), Integer.valueOf(paramEmojiInfo.field_state) });
      if ((paramEmojiInfo.field_state == EmojiInfo.uDj) || (paramEmojiInfo.field_state == EmojiInfo.uDf))
      {
        Et(0);
        cnT();
      }
      for (;;)
      {
        this.shS.setImageBitmap(null);
        return;
        Et(3);
      }
    }
  }
  
  public void initView()
  {
    this.shN = getContext().getResources().getDimensionPixelSize(a.c.emoji_view_image_size);
    this.shO = getContext().getResources().getDimensionPixelSize(a.c.emoji_view_chatting_min_size);
    this.shQ = getContext().getResources().getDimensionPixelSize(a.c.emoji_view_refresh_size);
    this.shR = getContext().getResources().getDimensionPixelSize(a.c.emoji_view_refresh_min_size);
    this.shS = new ChattingEmojiView(getContext());
    this.shS.setUpdateEmojiSize(true);
    this.shT = new ProgressBar(getContext());
    this.shT.setIndeterminateDrawable(getResources().getDrawable(a.d.progress_small_holo));
    this.pMe = new TextView(getContext());
    this.pMe.setText(a.h.emoji_retry_download);
    this.pMe.setTextColor(getResources().getColor(a.b.emoji_load_text_color));
    this.shU = new FrameLayout.LayoutParams(-2, -2);
    this.shV = new FrameLayout.LayoutParams(-2, -2);
    this.shU.gravity = 17;
    addView(this.shT, this.shU);
    addView(this.pMe, this.shU);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mStatus == 0) || (this.mStatus == 1) || (this.mStatus == 3))
    {
      if ((this.jck != null) && (this.jck.field_height != 0))
      {
        paramInt1 = (int)(this.jck.field_height * this.shS.getEmojiDensityScale());
        if (paramInt1 < this.shO) {}
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 > this.shN) {
          paramInt2 = this.shN;
        }
        this.shP = this.shQ;
        if ((paramInt2 >= this.shO) && (paramInt2 < this.shO + (this.shQ - this.shR))) {
          this.shP = (this.shR + (paramInt2 - this.shO));
        }
        paramInt1 = this.shN;
        setMeasuredDimension(paramInt1, paramInt2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        Et(this.mStatus);
        return;
        paramInt1 = this.shO;
        continue;
        paramInt1 = this.shO;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean performClick()
  {
    if (this.mStatus == 3)
    {
      Et(1);
      cnT();
      return true;
    }
    if (this.mStatus == 2) {
      return super.performClick();
    }
    y.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    Et(2);
    if ((this.shS != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.shS.getEmojiDensity());
      this.shS.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */