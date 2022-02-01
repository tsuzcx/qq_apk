package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView
  extends MMAnimateView
{
  protected int Kor;
  protected int Kos;
  private boolean Kot;
  private boolean Kou;
  private boolean Kov;
  private int mScreenWidth;
  protected EmojiInfo rfq;
  
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
    this.Kot = false;
    this.Kou = false;
    this.Kov = false;
    init(paramContext);
    AppMethodBeat.o(104710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(104711);
    this.Kor = paramContext.getResources().getDimensionPixelSize(2131166307);
    this.Kos = paramContext.getResources().getDimensionPixelSize(2131166305);
    this.mScreenWidth = a.jn(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.Kor);
    setMaxHeight(this.Kor);
    setMinimumWidth(this.Kos);
    setMinimumHeight(this.Kos);
    AppMethodBeat.o(104711);
  }
  
  public final void b(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(104712);
    this.rfq = paramEmojiInfo;
    Object localObject = paramEmojiInfo.hRM();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.UuK) == EmojiInfo.UuK)
    {
      if (c.dXx().aBd(paramString) != null)
      {
        setImageDrawable(c.dXx().aBd(paramString));
        AppMethodBeat.o(104712);
        return;
      }
      paramEmojiInfo = this.rfq;
      localObject = ((PluginEmoji)g.ah(PluginEmoji.class)).getProvider().a(this.rfq);
      this.rfq = paramEmojiInfo;
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
            paramString = c.dXx().s(getCacheKey(), (byte[])localObject);
            setImageDrawable(paramString);
            AppMethodBeat.o(104712);
            return;
          }
          if ((!ImgUtil.isWXGF((byte[])localObject)) || (!((PluginEmoji)g.ah(PluginEmoji.class)).getProvider().cFP())) {
            continue;
          }
          paramEmojiInfo = new h((byte[])localObject);
          this.Kou = true;
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
          if (this.rfq == null) {
            continue;
          }
          this.rfq.hRy();
          Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          Log.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { localObject.toString() });
          if (this.rfq == null) {
            continue;
          }
          this.rfq.hRy();
          Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          Log.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.rfq == null) {
            continue;
          }
          this.rfq.hRy();
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
    hU((String)localObject, paramString);
    AppMethodBeat.o(104712);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104713);
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.rfq != null))
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
        if ((this.Kov) && ((this.rfq.field_width == 0) || (this.rfq.field_height == 0)))
        {
          this.rfq.field_width = ((int)f2);
          this.rfq.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.rfq);
        }
        AppMethodBeat.o(104713);
        return;
        if (!(paramDrawable instanceof h)) {
          break;
        }
        f1 = ((h)paramDrawable).getEmojiDensityScale();
      }
    } while ((paramDrawable instanceof BitmapDrawable));
    AppMethodBeat.o(104713);
  }
  
  public void setIsMaxSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(104714);
    this.Kot = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.Kor);
      setMaxHeight(this.Kor);
      AppMethodBeat.o(104714);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
    AppMethodBeat.o(104714);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.Kor = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.Kov = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */