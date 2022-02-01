package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView
  extends MMAnimateView
{
  private boolean ChA;
  private boolean ChB;
  private boolean ChC;
  protected int Chy;
  protected int Chz;
  private int mScreenWidth;
  protected EmojiInfo oBl;
  
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
    this.ChA = false;
    this.ChB = false;
    this.ChC = false;
    init(paramContext);
    AppMethodBeat.o(104710);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(104711);
    this.Chy = paramContext.getResources().getDimensionPixelSize(2131166264);
    this.Chz = paramContext.getResources().getDimensionPixelSize(2131166262);
    this.mScreenWidth = a.hV(paramContext);
    setAdjustViewBounds(true);
    setMaxWidth(this.Chy);
    setMaxHeight(this.Chy);
    setMinimumWidth(this.Chz);
    setMinimumHeight(this.Chz);
    AppMethodBeat.o(104711);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(104712);
    this.oBl = paramEmojiInfo;
    Object localObject = paramEmojiInfo.gaa();
    if ((paramEmojiInfo.field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl)
    {
      if (c.cEH().ade(paramString) != null)
      {
        setImageDrawable(c.cEH().ade(paramString));
        AppMethodBeat.o(104712);
        return;
      }
      paramEmojiInfo = this.oBl;
      localObject = ((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().a(this.oBl);
      this.oBl = paramEmojiInfo;
      for (;;)
      {
        try
        {
          if (bt.cw((byte[])localObject)) {
            continue;
          }
          if (!bt.isNullOrNil(paramString))
          {
            setCacheKey(paramString);
            paramString = c.cEH().r(getCacheKey(), (byte[])localObject);
            setImageDrawable(paramString);
            AppMethodBeat.o(104712);
            return;
          }
          if ((!t.cp((byte[])localObject)) || (!((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().bUK())) {
            continue;
          }
          paramEmojiInfo = new h((byte[])localObject);
          this.ChB = true;
        }
        catch (MMGIFException paramEmojiInfo)
        {
          a(paramEmojiInfo);
          if (paramEmojiInfo.getErrorCode() != 103) {
            continue;
          }
          ad.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
          paramEmojiInfo = f.cl((byte[])localObject);
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
          if (this.oBl == null) {
            continue;
          }
          this.oBl.fZN();
          ad.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          ad.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { localObject.toString() });
          if (this.oBl == null) {
            continue;
          }
          this.oBl.fZN();
          ad.i("MicroMsg.emoji.MMEmojiView", "delete file.");
          init();
          AppMethodBeat.o(104712);
          return;
          ad.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", new Object[] { paramEmojiInfo.toString() });
          if (this.oBl == null) {
            continue;
          }
          this.oBl.fZN();
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
    gD((String)localObject, paramString);
    AppMethodBeat.o(104712);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104713);
    super.setImageDrawable(paramDrawable);
    float f1;
    if ((paramDrawable != null) && (this.oBl != null))
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
        if ((this.ChC) && ((this.oBl.field_width == 0) || (this.oBl.field_height == 0)))
        {
          this.oBl.field_width = ((int)f2);
          this.oBl.field_height = ((int)f1);
          ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.oBl);
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
    this.ChA = paramBoolean;
    if (paramBoolean)
    {
      setAdjustViewBounds(true);
      setMaxWidth(this.Chy);
      setMaxHeight(this.Chy);
      AppMethodBeat.o(104714);
      return;
    }
    setMaxHeight(2147483647);
    setMaxHeight(2147483647);
    AppMethodBeat.o(104714);
  }
  
  public void setMaxSize(int paramInt)
  {
    this.Chy = paramInt;
  }
  
  public void setUpdateEmojiSize(boolean paramBoolean)
  {
    this.ChC = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView
 * JD-Core Version:    0.7.0.1
 */