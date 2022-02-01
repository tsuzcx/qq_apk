package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView
  extends MMAnimateView
{
  protected int DzP;
  protected int DzQ;
  private boolean DzR;
  private boolean DzS;
  private boolean DzT;
  private int mScreenWidth;
  protected EmojiInfo peL;
  
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
    this.DzR = false;
    this.DzS = false;
    this.DzT = false;
    init(paramContext);
    AppMethodBeat.o(104710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(104711);
    this.DzP = paramContext.getResources().getDimensionPixelSize(2131166264);
    this.DzQ = paramContext.getResources().getDimensionPixelSize(2131166262);
    this.mScreenWidth = a.ig(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.DzP);
    setMaxHeight(this.DzP);
    setMinimumWidth(this.DzQ);
    setMinimumHeight(this.DzQ);
    AppMethodBeat.o(104711);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(104712);
    this.peL = paramEmojiInfo;
    Object localObject = paramEmojiInfo.ghd();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm)
    {
      if (c.cRR().ahW(paramString) != null)
      {
        setImageDrawable(c.cRR().ahW(paramString));
        AppMethodBeat.o(104712);
        return;
      }
      paramEmojiInfo = this.peL;
      localObject = ((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().a(this.peL);
      this.peL = paramEmojiInfo;
      for (;;)
      {
        try
        {
          if (bs.cv((byte[])localObject)) {
            continue;
          }
          if (!bs.isNullOrNil(paramString))
          {
            setCacheKey(paramString);
            paramString = c.cRR().r(getCacheKey(), (byte[])localObject);
            setImageDrawable(paramString);
            AppMethodBeat.o(104712);
            return;
          }
          if ((!s.co((byte[])localObject)) || (!((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().cbX())) {
            continue;
          }
          paramEmojiInfo = new h((byte[])localObject);
          this.DzS = true;
        }
        catch (MMGIFException paramEmojiInfo)
        {
          a(paramEmojiInfo);
          if (paramEmojiInfo.getErrorCode() != 103) {
            continue;
          }
          ac.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
          paramEmojiInfo = f.ck((byte[])localObject);
          if (paramEmojiInfo == null) {
            continue;
          }
          paramEmojiInfo.setDensity(getEmojiDensity());
          setImageBitmap(paramEmojiInfo);
          AppMethodBeat.o(104712);
          return;
          ac.v("MicroMsg.emoji.MMEmojiView", "set with gif");
          paramEmojiInfo = new com.tencent.mm.plugin.gif.d((byte[])localObject);
          continue;
        }
        catch (IOException paramEmojiInfo)
        {
          ac.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.peL == null) {
            continue;
          }
          this.peL.fdq();
          ac.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          ac.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { localObject.toString() });
          if (this.peL == null) {
            continue;
          }
          this.peL.fdq();
          ac.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          ac.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.peL == null) {
            continue;
          }
          this.peL.fdq();
          ac.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          continue;
        }
        catch (NullPointerException paramEmojiInfo)
        {
          ac.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
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
    gU((String)localObject, paramString);
    AppMethodBeat.o(104712);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104713);
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.peL != null))
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
        if ((this.DzT) && ((this.peL.field_width == 0) || (this.peL.field_height == 0)))
        {
          this.peL.field_width = ((int)f2);
          this.peL.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.peL);
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
    this.DzR = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.DzP);
      setMaxHeight(this.DzP);
      AppMethodBeat.o(104714);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
    AppMethodBeat.o(104714);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.DzP = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.DzT = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */