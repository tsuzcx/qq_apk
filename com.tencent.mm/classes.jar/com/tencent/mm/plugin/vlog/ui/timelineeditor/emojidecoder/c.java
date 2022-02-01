package com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder;

import android.graphics.Bitmap;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/WechatEmojiDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "value", "", "(Ljava/lang/String;)V", "emojiDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "destroy", "", "duration", "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "Companion", "plugin-vlog_release"})
public final class c
  implements IStickerDecoder
{
  public static final a NEA;
  private com.tencent.mm.emoji.decode.d NEz;
  private EmojiInfo jHh;
  
  static
  {
    AppMethodBeat.i(244179);
    NEA = new a((byte)0);
    AppMethodBeat.o(244179);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(244178);
    this.jHh = new EmojiInfo();
    this.NEz = ((com.tencent.mm.emoji.decode.d)new b());
    try
    {
      paramString = new JSONObject(paramString).optString("emoji_md5");
      paramString = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramString);
      p.j(paramString, "MMKernel.plugin<IPluginE….getEmojiInfoFromMD5(md5)");
      this.jHh = paramString;
      this.NEz = MMGIFJNIFactory.Companion.getDecoder(this.jHh);
      AppMethodBeat.o(244178);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(244178);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(244173);
    this.NEz.destroy();
    AppMethodBeat.o(244173);
  }
  
  public final long duration()
  {
    return 1073741824L;
  }
  
  public final Bitmap getFrame()
  {
    AppMethodBeat.i(244174);
    this.NEz.aBh();
    Bitmap localBitmap = this.NEz.getFrame();
    AppMethodBeat.o(244174);
    return localBitmap;
  }
  
  public final void seekTo(long paramLong) {}
  
  public final Size size()
  {
    AppMethodBeat.i(244176);
    Size localSize = new Size(this.NEz.aBk(), this.NEz.aBl());
    AppMethodBeat.o(244176);
    return localSize;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/WechatEmojiDecoder$Companion;", "", "()V", "EMOJI_MD5", "", "EMOJI_SCHEME", "getEmojiValue", "md5", "plugin-vlog_release"})
  public static final class a
  {
    public static String bfR(String paramString)
    {
      AppMethodBeat.i(232266);
      p.k(paramString, "md5");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("scheme", "emoji");
        localJSONObject.put("emoji_md5", paramString);
        label36:
        paramString = localJSONObject.toString();
        p.j(paramString, "value.toString()");
        AppMethodBeat.o(232266);
        return paramString;
      }
      catch (Exception paramString)
      {
        break label36;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.c
 * JD-Core Version:    0.7.0.1
 */