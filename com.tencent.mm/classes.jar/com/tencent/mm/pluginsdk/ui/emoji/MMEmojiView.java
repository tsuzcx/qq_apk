package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView
  extends MMAnimateView
{
  protected int FeY;
  protected int FeZ;
  private boolean Ffa;
  private boolean Ffb;
  private boolean Ffc;
  private int mScreenWidth;
  protected EmojiInfo pIn;
  
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
    this.Ffa = false;
    this.Ffb = false;
    this.Ffc = false;
    init(paramContext);
    AppMethodBeat.o(104710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(104711);
    this.FeY = paramContext.getResources().getDimensionPixelSize(2131166264);
    this.FeZ = paramContext.getResources().getDimensionPixelSize(2131166262);
    this.mScreenWidth = a.ip(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.FeY);
    setMaxHeight(this.FeY);
    setMinimumWidth(this.FeZ);
    setMinimumHeight(this.FeZ);
    AppMethodBeat.o(104711);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(104712);
    this.pIn = paramEmojiInfo;
    Object localObject = paramEmojiInfo.gzQ();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.Ofi) == EmojiInfo.Ofi)
    {
      if (c.daX().amJ(paramString) != null)
      {
        setImageDrawable(c.daX().amJ(paramString));
        AppMethodBeat.o(104712);
        return;
      }
      paramEmojiInfo = this.pIn;
      localObject = ((PluginEmoji)com.tencent.mm.kernel.g.ad(PluginEmoji.class)).getProvider().a(this.pIn);
      this.pIn = paramEmojiInfo;
      for (;;)
      {
        try
        {
          if (bt.cC((byte[])localObject)) {
            continue;
          }
          if (!bt.isNullOrNil(paramString))
          {
            setCacheKey(paramString);
            paramString = c.daX().s(getCacheKey(), (byte[])localObject);
            setImageDrawable(paramString);
            AppMethodBeat.o(104712);
            return;
          }
          if ((!t.cv((byte[])localObject)) || (!((PluginEmoji)com.tencent.mm.kernel.g.ad(PluginEmoji.class)).getProvider().cgB())) {
            continue;
          }
          paramEmojiInfo = new h((byte[])localObject);
          this.Ffb = true;
        }
        catch (MMGIFException paramEmojiInfo)
        {
          a(paramEmojiInfo);
          if (paramEmojiInfo.getErrorCode() != 103) {
            continue;
          }
          ad.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
          paramEmojiInfo = com.tencent.mm.sdk.platformtools.g.cr((byte[])localObject);
          if (paramEmojiInfo == null) {
            continue;
          }
          paramEmojiInfo.setDensity(getEmojiDensity());
          setImageBitmap(paramEmojiInfo);
          AppMethodBeat.o(104712);
          return;
          ad.v("MicroMsg.emoji.MMEmojiView", "set with gif");
          paramEmojiInfo = new com.tencent.mm.plugin.gif.d((byte[])localObject);
          continue;
        }
        catch (IOException paramEmojiInfo)
        {
          ad.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.pIn == null) {
            continue;
          }
          this.pIn.fOv();
          ad.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          ad.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { localObject.toString() });
          if (this.pIn == null) {
            continue;
          }
          this.pIn.fOv();
          ad.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          ad.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.pIn == null) {
            continue;
          }
          this.pIn.fOv();
          ad.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          continue;
        }
        catch (NullPointerException paramEmojiInfo)
        {
          ad.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
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
    hg((String)localObject, paramString);
    AppMethodBeat.o(104712);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104713);
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.pIn != null))
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
        if ((this.Ffc) && ((this.pIn.field_width == 0) || (this.pIn.field_height == 0)))
        {
          this.pIn.field_width = ((int)f2);
          this.pIn.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.pIn);
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
    this.Ffa = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.FeY);
      setMaxHeight(this.FeY);
      AppMethodBeat.o(104714);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
    AppMethodBeat.o(104714);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.FeY = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.Ffc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */