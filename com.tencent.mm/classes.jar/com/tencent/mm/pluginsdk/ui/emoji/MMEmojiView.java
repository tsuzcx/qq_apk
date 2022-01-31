package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView
  extends MMAnimateView
{
  private EmojiInfo jck;
  private int mScreenWidth;
  private int shG;
  private int shH;
  private boolean shI = false;
  public boolean shJ = false;
  private boolean shK = false;
  
  public MMEmojiView(Context paramContext)
  {
    this(paramContext, null);
    init(paramContext);
  }
  
  public MMEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
    init(paramContext);
  }
  
  public MMEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.shG = paramContext.getResources().getDimensionPixelSize(a.c.emoji_view_image_size);
    this.shH = paramContext.getResources().getDimensionPixelSize(a.c.emoji_view_image_min_size);
    this.mScreenWidth = a.fj(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.shG);
    setMaxHeight(this.shG);
    setMinimumWidth(this.shH);
    setMinimumHeight(this.shH);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, String paramString)
  {
    this.jck = paramEmojiInfo;
    String str = paramEmojiInfo.cwL();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo)
    {
      if (com.tencent.mm.plugin.gif.c.baM().Fi(paramString) != null)
      {
        setImageDrawable(com.tencent.mm.plugin.gif.c.baM().Fi(paramString));
        return;
      }
      a(this.jck, ((PluginEmoji)g.t(PluginEmoji.class)).getProvider().a(this.jck), paramString);
      return;
    }
    du(str, paramString);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte, String paramString)
  {
    this.jck = paramEmojiInfo;
    for (;;)
    {
      try
      {
        if (bk.bE(paramArrayOfByte)) {
          continue;
        }
        if (!bk.bl(paramString))
        {
          setCacheKey(paramString);
          paramString = com.tencent.mm.plugin.gif.c.baM().p(getCacheKey(), paramArrayOfByte);
          setImageDrawable(paramString);
          return;
        }
        if ((!o.bz(paramArrayOfByte)) || (!((PluginEmoji)g.t(PluginEmoji.class)).getProvider().aHs())) {
          continue;
        }
        paramEmojiInfo = new h(paramArrayOfByte);
        this.shJ = true;
      }
      catch (MMGIFException paramEmojiInfo)
      {
        a(paramEmojiInfo);
        if (paramEmojiInfo.getErrorCode() != 103) {
          continue;
        }
        y.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
        paramEmojiInfo = com.tencent.mm.sdk.platformtools.c.bu(paramArrayOfByte);
        if (paramEmojiInfo == null) {
          continue;
        }
        paramEmojiInfo.setDensity(getEmojiDensity());
        setImageBitmap(paramEmojiInfo);
        return;
        y.v("MicroMsg.emoji.MMEmojiView", "set with gif");
        paramEmojiInfo = new com.tencent.mm.plugin.gif.d(paramArrayOfByte);
        continue;
      }
      catch (IOException paramEmojiInfo)
      {
        y.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
        if (this.jck == null) {
          continue;
        }
        this.jck.cwA();
        y.i("MicroMsg.emoji.MMEmojiView", "delete file.");
        init();
        return;
        y.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { paramArrayOfByte.toString() });
        if (this.jck == null) {
          continue;
        }
        this.jck.cwA();
        y.i("MicroMsg.emoji.MMEmojiView", "delete file.");
        init();
        return;
        y.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
        if (this.jck == null) {
          continue;
        }
        this.jck.cwA();
        y.i("MicroMsg.emoji.MMEmojiView", "delete file.");
        continue;
      }
      catch (NullPointerException paramEmojiInfo)
      {
        y.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
        continue;
      }
      paramString = paramEmojiInfo;
      if (!paramEmojiInfo.isRunning())
      {
        paramEmojiInfo.reset();
        paramString = paramEmojiInfo;
      }
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.jck != null))
    {
      f1 = 1.0F;
      if (!(paramDrawable instanceof com.tencent.mm.plugin.gif.d)) {
        break label118;
      }
      f1 = ((com.tencent.mm.plugin.gif.d)paramDrawable).getEmojiDensityScale();
    }
    label118:
    do
    {
      for (;;)
      {
        float f2 = paramDrawable.getIntrinsicWidth() / f1;
        f1 = paramDrawable.getIntrinsicHeight() / f1;
        if ((this.shK) && ((this.jck.field_width == 0) || (this.jck.field_height == 0)))
        {
          this.jck.field_width = ((int)f2);
          this.jck.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(this.jck);
        }
        return;
        if (!(paramDrawable instanceof h)) {
          break;
        }
        f1 = ((h)paramDrawable).getEmojiDensityScale();
      }
    } while ((paramDrawable instanceof BitmapDrawable));
  }
  
  public void setIsMaxSizeLimit(boolean paramBoolean)
  {
    this.shI = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.shG);
      setMaxHeight(this.shG);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.shG = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.shK = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */