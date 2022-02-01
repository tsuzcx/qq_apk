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
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView
  extends MMAnimateView
{
  private boolean FxA;
  protected int Fxw;
  protected int Fxx;
  private boolean Fxy;
  private boolean Fxz;
  private int mScreenWidth;
  protected EmojiInfo pOS;
  
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
    this.Fxy = false;
    this.Fxz = false;
    this.FxA = false;
    init(paramContext);
    AppMethodBeat.o(104710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(104711);
    this.Fxw = paramContext.getResources().getDimensionPixelSize(2131166264);
    this.Fxx = paramContext.getResources().getDimensionPixelSize(2131166262);
    this.mScreenWidth = a.iu(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.Fxw);
    setMaxHeight(this.Fxw);
    setMinimumWidth(this.Fxx);
    setMinimumHeight(this.Fxx);
    AppMethodBeat.o(104711);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(104712);
    this.pOS = paramEmojiInfo;
    Object localObject = paramEmojiInfo.fSQ();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.OAp) == EmojiInfo.OAp)
    {
      if (c.ddO().anK(paramString) != null)
      {
        setImageDrawable(c.ddO().anK(paramString));
        AppMethodBeat.o(104712);
        return;
      }
      paramEmojiInfo = this.pOS;
      localObject = ((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().a(this.pOS);
      this.pOS = paramEmojiInfo;
      for (;;)
      {
        try
        {
          if (bu.cF((byte[])localObject)) {
            continue;
          }
          if (!bu.isNullOrNil(paramString))
          {
            setCacheKey(paramString);
            paramString = c.ddO().s(getCacheKey(), (byte[])localObject);
            setImageDrawable(paramString);
            AppMethodBeat.o(104712);
            return;
          }
          if ((!u.cy((byte[])localObject)) || (!((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().chR())) {
            continue;
          }
          paramEmojiInfo = new com.tencent.mm.plugin.gif.h((byte[])localObject);
          this.Fxz = true;
        }
        catch (MMGIFException paramEmojiInfo)
        {
          a(paramEmojiInfo);
          if (paramEmojiInfo.getErrorCode() != 103) {
            continue;
          }
          ae.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
          paramEmojiInfo = com.tencent.mm.sdk.platformtools.h.cu((byte[])localObject);
          if (paramEmojiInfo == null) {
            continue;
          }
          paramEmojiInfo.setDensity(getEmojiDensity());
          setImageBitmap(paramEmojiInfo);
          AppMethodBeat.o(104712);
          return;
          ae.v("MicroMsg.emoji.MMEmojiView", "set with gif");
          paramEmojiInfo = new com.tencent.mm.plugin.gif.d((byte[])localObject);
          continue;
        }
        catch (IOException paramEmojiInfo)
        {
          ae.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.pOS == null) {
            continue;
          }
          this.pOS.fxo();
          ae.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          ae.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { localObject.toString() });
          if (this.pOS == null) {
            continue;
          }
          this.pOS.fxo();
          ae.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          ae.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.pOS == null) {
            continue;
          }
          this.pOS.fxo();
          ae.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          continue;
        }
        catch (NullPointerException paramEmojiInfo)
        {
          ae.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
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
    hn((String)localObject, paramString);
    AppMethodBeat.o(104712);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104713);
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.pOS != null))
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
        if ((this.FxA) && ((this.pOS.field_width == 0) || (this.pOS.field_height == 0)))
        {
          this.pOS.field_width = ((int)f2);
          this.pOS.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.pOS);
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
    this.Fxy = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.Fxw);
      setMaxHeight(this.Fxw);
      AppMethodBeat.o(104714);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
    AppMethodBeat.o(104714);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.Fxw = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.FxA = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */