package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
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
  protected int Ylu;
  protected int Ylv;
  private boolean Ylw;
  private boolean Ylx;
  private boolean Yly;
  private int mScreenWidth;
  protected EmojiInfo xRp;
  
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
    this.Ylw = false;
    this.Ylx = false;
    this.Yly = false;
    init(paramContext);
    AppMethodBeat.o(104710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(104711);
    this.Ylu = paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_size);
    this.Ylv = paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_min_size);
    this.mScreenWidth = a.ms(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.Ylu);
    setMaxHeight(this.Ylu);
    setMinimumWidth(this.Ylv);
    setMinimumHeight(this.Ylv);
    AppMethodBeat.o(104711);
  }
  
  public final void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(104712);
    this.xRp = paramEmojiInfo;
    Object localObject = paramEmojiInfo.kMn();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.akmb) == EmojiInfo.akmb)
    {
      if (c.fJa().aHI(paramString) != null)
      {
        setImageDrawable(c.fJa().aHI(paramString));
        AppMethodBeat.o(104712);
        return;
      }
      paramEmojiInfo = this.xRp;
      localObject = ((PluginEmoji)com.tencent.mm.kernel.h.az(PluginEmoji.class)).getProvider().a(this.xRp);
      this.xRp = paramEmojiInfo;
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
            paramString = c.fJa().z(getCacheKey(), (byte[])localObject);
            setImageDrawable(paramString);
            AppMethodBeat.o(104712);
            return;
          }
          if ((!ImgUtil.isWXGF((byte[])localObject)) || (!((PluginEmoji)com.tencent.mm.kernel.h.az(PluginEmoji.class)).getProvider().dzD())) {
            continue;
          }
          paramEmojiInfo = new com.tencent.mm.plugin.gif.h((byte[])localObject);
          this.Ylx = true;
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
          if (this.xRp == null) {
            continue;
          }
          this.xRp.kMa();
          Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          Log.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { localObject.toString() });
          if (this.xRp == null) {
            continue;
          }
          this.xRp.kMa();
          Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          Log.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.xRp == null) {
            continue;
          }
          this.xRp.kMa();
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
    jk((String)localObject, paramString);
    AppMethodBeat.o(104712);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104713);
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.xRp != null))
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
        if ((this.Yly) && ((this.xRp.field_width == 0) || (this.xRp.field_height == 0)))
        {
          this.xRp.field_width = ((int)f2);
          this.xRp.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(this.xRp);
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
    this.Ylw = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.Ylu);
      setMaxHeight(this.Ylu);
      AppMethodBeat.o(104714);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
    AppMethodBeat.o(104714);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.Ylu = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.Yly = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */