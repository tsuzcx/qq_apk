package com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import com.tencent.mm.xeffect.effect.IStickerDecoderFactory;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/WechatEmojiDecoderFactory;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "Companion", "plugin-vlog_release"})
public final class d
  implements IStickerDecoderFactory
{
  public static final a NEB;
  private Context context;
  
  static
  {
    AppMethodBeat.i(226297);
    NEB = new a((byte)0);
    AppMethodBeat.o(226297);
  }
  
  public d()
  {
    AppMethodBeat.i(226296);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    this.context = localContext;
    AppMethodBeat.o(226296);
  }
  
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(226295);
    p.k(paramString, "path");
    for (;;)
    {
      try
      {
        str = new JSONObject(paramString).optString("scheme");
        if (str != null) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        String str;
        continue;
      }
      paramString = (IStickerDecoder)new a();
      AppMethodBeat.o(226295);
      return paramString;
      switch (str.hashCode())
      {
      case 3556653: 
        if (str.equals("text"))
        {
          paramString = (IStickerDecoder)new b(this.context, paramString);
          AppMethodBeat.o(226295);
          return paramString;
        }
        break;
      case 96632902: 
        if (str.equals("emoji"))
        {
          paramString = (IStickerDecoder)new c(paramString);
          AppMethodBeat.o(226295);
          return paramString;
        }
        break;
      }
    }
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226292);
    p.k(paramArrayOfByte, "bytes");
    paramArrayOfByte = (IStickerDecoder)new c("test");
    AppMethodBeat.o(226292);
    return paramArrayOfByte;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/WechatEmojiDecoderFactory$Companion;", "", "()V", "TIMELINE_EDIT_SCHEME", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.d
 * JD-Core Version:    0.7.0.1
 */