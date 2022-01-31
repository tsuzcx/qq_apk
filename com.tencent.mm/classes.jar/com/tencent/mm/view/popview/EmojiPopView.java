package com.tencent.mm.view.popview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class EmojiPopView
  extends AbstractPopView
{
  private MMEmojiView jbW;
  private ProgressBar mZJ;
  private int offsetY;
  private WindowManager.LayoutParams wzh;
  private String wzi;
  
  public EmojiPopView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmojiPopView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiPopView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, a.f.emoji_pop_emoji_view, this);
    this.jbW = ((MMEmojiView)findViewById(a.e.image));
    this.mZJ = ((ProgressBar)findViewById(a.e.progress));
    setBackgroundResource(a.d.emo_relatedword_bg);
    this.jbW.setMaxSize(paramContext.getResources().getDimensionPixelSize(a.c.emoji_pop_emoji_size));
    this.jbW.setIsMaxSizeLimit(true);
    this.wzh = new WindowManager.LayoutParams(2, 264, 1);
    paramInt = paramContext.getResources().getDimensionPixelSize(a.c.emoji_pop_frame_size_emoji);
    this.wzh.width = paramInt;
    this.wzh.height = paramInt;
    this.wzh.gravity = 8388659;
    this.offsetY = paramContext.getResources().getDimensionPixelSize(a.c.emoji_pop_emoji_offset_y);
  }
  
  public final void ep(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    this.wzh.x = (arrayOfInt[0] - (this.wzh.width - paramView.getMeasuredWidth()) / 2);
    this.wzh.y = (arrayOfInt[1] - this.wzh.height + this.offsetY);
  }
  
  public WindowManager.LayoutParams getWindowLayoutParams()
  {
    return this.wzh;
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo == null)
    {
      this.jbW.setVisibility(4);
      this.mZJ.setVisibility(0);
      y.i("MicroMsg.EmojiPopView", "emoji is null. set null");
    }
    while (paramEmojiInfo.Wv().equals(this.wzi)) {
      return;
    }
    this.jbW.setVisibility(0);
    this.mZJ.setVisibility(4);
    this.wzi = paramEmojiInfo.Wv();
    if ((paramEmojiInfo.field_catalog == EmojiGroupInfo.uCR) && ((paramEmojiInfo.field_content.equals(String.valueOf(EmojiInfo.uCY))) || (paramEmojiInfo.field_content.equals(String.valueOf(EmojiInfo.uCX))))) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramEmojiInfo = paramEmojiInfo.getName().split("\\.")[0];
      y.d("MicroMsg.EmojiPopView", "emoji drawable name is %s", new Object[] { paramEmojiInfo });
      i = getResources().getIdentifier(paramEmojiInfo, "drawable", ae.getPackageName());
      this.jbW.setImageResource(i);
      return;
    }
    if (paramEmojiInfo.cwC()) {
      this.jbW.b(EmojiInfo.bv(ae.getContext(), paramEmojiInfo.getName()), paramEmojiInfo.getName());
    }
    for (;;)
    {
      this.jbW.resume();
      return;
      this.jbW.a(paramEmojiInfo, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.popview.EmojiPopView
 * JD-Core Version:    0.7.0.1
 */