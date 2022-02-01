package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView
  extends MMAnimateView
{
  protected int Rpd;
  protected int Rpe;
  private boolean Rpf;
  private boolean Rpg;
  private boolean Rph;
  private int mScreenWidth;
  protected EmojiInfo uIz;
  
  public MMEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(104709);
    init(paramContext);
    AppMethodBeat.o(104709);
  }
  
  public MMEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104710);
    this.Rpf = false;
    this.Rpg = false;
    this.Rph = false;
    init(paramContext);
    AppMethodBeat.o(104710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(104711);
    this.Rpd = paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_size);
    this.Rpe = paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_min_size);
    this.mScreenWidth = a.kr(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.Rpd);
    setMaxHeight(this.Rpd);
    setMinimumWidth(this.Rpe);
    setMinimumHeight(this.Rpe);
    AppMethodBeat.o(104711);
  }
  
  public final void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(104712);
    this.uIz = paramEmojiInfo;
    Object localObject = paramEmojiInfo.ifh();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM)
    {
      if (c.eAV().aKR(paramString) != null)
      {
        setImageDrawable(c.eAV().aKR(paramString));
        AppMethodBeat.o(104712);
        return;
      }
      paramEmojiInfo = this.uIz;
      localObject = ((PluginEmoji)com.tencent.mm.kernel.h.ag(PluginEmoji.class)).getProvider().a(this.uIz);
      this.uIz = paramEmojiInfo;
      for (;;)
      {
        try
        {
          if (Util.isNullOrNil((byte[])localObject)) {
            continue;
          }
          if (!Util.isNullOrNil(paramString))
          {
            setCacheKey(paramString);
            paramString = c.eAV().v(getCacheKey(), (byte[])localObject);
            setImageDrawable(paramString);
            AppMethodBeat.o(104712);
            return;
          }
          if ((!ImgUtil.isWXGF((byte[])localObject)) || (!((PluginEmoji)com.tencent.mm.kernel.h.ag(PluginEmoji.class)).getProvider().cUw())) {
            continue;
          }
          paramEmojiInfo = new com.tencent.mm.plugin.gif.h((byte[])localObject);
          this.Rpg = true;
        }
        catch (MMGIFException paramEmojiInfo)
        {
          a(paramEmojiInfo);
          if (paramEmojiInfo.getErrorCode() != 103) {
            continue;
          }
          Log.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
          paramEmojiInfo = BitmapUtil.decodeByteArray((byte[])localObject);
          if (paramEmojiInfo == null) {
            continue;
          }
          paramEmojiInfo.setDensity(getEmojiDensity());
          setImageBitmap(paramEmojiInfo);
          AppMethodBeat.o(104712);
          return;
          Log.v("MicroMsg.emoji.MMEmojiView", "set with gif");
          paramEmojiInfo = new com.tencent.mm.plugin.gif.d((byte[])localObject);
          continue;
        }
        catch (IOException paramEmojiInfo)
        {
          Log.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.uIz == null) {
            continue;
          }
          this.uIz.hBq();
          Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          Log.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { localObject.toString() });
          if (this.uIz == null) {
            continue;
          }
          this.uIz.hBq();
          Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          Log.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.uIz == null) {
            continue;
          }
          this.uIz.hBq();
          Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          continue;
        }
        catch (NullPointerException paramEmojiInfo)
        {
          Log.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
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
    id((String)localObject, paramString);
    AppMethodBeat.o(104712);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104713);
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.uIz != null))
    {
      f1 = 1.0F;
      if (!(paramDrawable instanceof com.tencent.mm.plugin.gif.d)) {
        break label130;
      }
      f1 = ((com.tencent.mm.plugin.gif.d)paramDrawable).getEmojiDensityScale();
    }
    label130:
    do
    {
      for (;;)
      {
        float f2 = paramDrawable.getIntrinsicWidth() / f1;
        f1 = paramDrawable.getIntrinsicHeight() / f1;
        if ((this.Rph) && ((this.uIz.field_width == 0) || (this.uIz.field_height == 0)))
        {
          this.uIz.field_width = ((int)f2);
          this.uIz.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.uIz);
        }
        AppMethodBeat.o(104713);
        return;
        if (!(paramDrawable instanceof com.tencent.mm.plugin.gif.h)) {
          break;
        }
        f1 = ((com.tencent.mm.plugin.gif.h)paramDrawable).getEmojiDensityScale();
      }
    } while ((paramDrawable instanceof BitmapDrawable));
    AppMethodBeat.o(104713);
  }
  
  public void setIsMaxSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(104714);
    this.Rpf = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.Rpd);
      setMaxHeight(this.Rpd);
      AppMethodBeat.o(104714);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
    AppMethodBeat.o(104714);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.Rpd = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.Rph = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */