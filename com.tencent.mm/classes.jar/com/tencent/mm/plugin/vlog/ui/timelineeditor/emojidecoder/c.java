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
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/WechatEmojiDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "value", "", "(Ljava/lang/String;)V", "emojiDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "destroy", "", "duration", "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements IStickerDecoder
{
  public static final a UqK;
  private com.tencent.mm.emoji.decode.d UqL;
  private EmojiInfo mgK;
  
  static
  {
    AppMethodBeat.i(282140);
    UqK = new a((byte)0);
    AppMethodBeat.o(282140);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(282133);
    this.mgK = new EmojiInfo();
    this.UqL = ((com.tencent.mm.emoji.decode.d)new b());
    try
    {
      paramString = new JSONObject(paramString).optString("emoji_md5");
      paramString = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramString);
      s.s(paramString, "plugin<IPluginEmoji>(IPl….getEmojiInfoFromMD5(md5)");
      this.mgK = paramString;
      this.UqL = MMGIFJNIFactory.Companion.getDecoder(this.mgK);
      AppMethodBeat.o(282133);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(282133);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(282145);
    this.UqL.destroy();
    AppMethodBeat.o(282145);
  }
  
  public final long duration()
  {
    return 1073741824L;
  }
  
  public final Bitmap getFrame()
  {
    AppMethodBeat.i(282160);
    this.UqL.aUe();
    Bitmap localBitmap = this.UqL.getFrame();
    AppMethodBeat.o(282160);
    return localBitmap;
  }
  
  public final void seekTo(long paramLong) {}
  
  public final Size size()
  {
    AppMethodBeat.i(282173);
    Size localSize = new Size(this.UqL.aUh(), this.UqL.aUi());
    AppMethodBeat.o(282173);
    return localSize;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/WechatEmojiDecoder$Companion;", "", "()V", "EMOJI_MD5", "", "EMOJI_SCHEME", "getEmojiValue", "md5", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String bfx(String paramString)
    {
      AppMethodBeat.i(282143);
      s.u(paramString, "md5");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("scheme", "emoji");
        localJSONObject.put("emoji_md5", paramString);
        label36:
        paramString = localJSONObject.toString();
        s.s(paramString, "value.toString()");
        AppMethodBeat.o(282143);
        return paramString;
      }
      catch (Exception paramString)
      {
        break label36;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.c
 * JD-Core Version:    0.7.0.1
 */