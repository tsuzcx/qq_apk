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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView
  extends MMAnimateView
{
  protected EmojiInfo lkU;
  private int mScreenWidth;
  protected int vZY;
  protected int vZZ;
  private boolean waa;
  private boolean wab;
  private boolean wac;
  
  public MMEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(62475);
    init(paramContext);
    AppMethodBeat.o(62475);
  }
  
  public MMEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62476);
    this.waa = false;
    this.wab = false;
    this.wac = false;
    init(paramContext);
    AppMethodBeat.o(62476);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(62477);
    this.vZY = paramContext.getResources().getDimensionPixelSize(2131428398);
    this.vZZ = paramContext.getResources().getDimensionPixelSize(2131428396);
    this.mScreenWidth = a.gw(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.vZY);
    setMaxHeight(this.vZY);
    setMinimumWidth(this.vZZ);
    setMinimumHeight(this.vZZ);
    AppMethodBeat.o(62477);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(62478);
    this.lkU = paramEmojiInfo;
    Object localObject = paramEmojiInfo.dQB();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx)
    {
      if (c.bHK().QG(paramString) != null)
      {
        setImageDrawable(c.bHK().QG(paramString));
        AppMethodBeat.o(62478);
        return;
      }
      paramEmojiInfo = this.lkU;
      localObject = ((PluginEmoji)g.G(PluginEmoji.class)).getProvider().l(this.lkU);
      this.lkU = paramEmojiInfo;
      for (;;)
      {
        try
        {
          if (bo.ce((byte[])localObject)) {
            continue;
          }
          if (!bo.isNullOrNil(paramString))
          {
            setCacheKey(paramString);
            paramString = c.bHK().x(getCacheKey(), (byte[])localObject);
            setImageDrawable(paramString);
            AppMethodBeat.o(62478);
            return;
          }
          if ((!r.bX((byte[])localObject)) || (!((PluginEmoji)g.G(PluginEmoji.class)).getProvider().ble())) {
            continue;
          }
          paramEmojiInfo = new h((byte[])localObject);
          this.wab = true;
        }
        catch (MMGIFException paramEmojiInfo)
        {
          a(paramEmojiInfo);
          if (paramEmojiInfo.getErrorCode() != 103) {
            continue;
          }
          ab.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
          paramEmojiInfo = com.tencent.mm.sdk.platformtools.d.bT((byte[])localObject);
          if (paramEmojiInfo == null) {
            continue;
          }
          paramEmojiInfo.setDensity(getEmojiDensity());
          setImageBitmap(paramEmojiInfo);
          AppMethodBeat.o(62478);
          return;
          ab.v("MicroMsg.emoji.MMEmojiView", "set with gif");
          paramEmojiInfo = new com.tencent.mm.plugin.gif.d((byte[])localObject);
          continue;
        }
        catch (IOException paramEmojiInfo)
        {
          ab.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.lkU == null) {
            continue;
          }
          this.lkU.dzo();
          ab.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(62478);
          return;
          ab.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { localObject.toString() });
          if (this.lkU == null) {
            continue;
          }
          this.lkU.dzo();
          ab.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(62478);
          return;
          ab.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.lkU == null) {
            continue;
          }
          this.lkU.dzo();
          ab.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          continue;
        }
        catch (NullPointerException paramEmojiInfo)
        {
          ab.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
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
    eL((String)localObject, paramString);
    AppMethodBeat.o(62478);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(62479);
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.lkU != null))
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
        if ((this.wac) && ((this.lkU.field_width == 0) || (this.lkU.field_height == 0)))
        {
          this.lkU.field_width = ((int)f2);
          this.lkU.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.lkU);
        }
        AppMethodBeat.o(62479);
        return;
        if (!(paramDrawable instanceof h)) {
          break;
        }
        f1 = ((h)paramDrawable).getEmojiDensityScale();
      }
    } while ((paramDrawable instanceof BitmapDrawable));
    AppMethodBeat.o(62479);
  }
  
  public void setIsMaxSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(62480);
    this.waa = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.vZY);
      setMaxHeight(this.vZY);
      AppMethodBeat.o(62480);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
    AppMethodBeat.o(62480);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.vZY = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.wac = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */