package com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import com.tencent.mm.xeffect.effect.IStickerDecoderFactory;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/WechatEmojiDecoderFactory;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements IStickerDecoderFactory
{
  public static final a UqM;
  private Context context;
  
  static
  {
    AppMethodBeat.i(282127);
    UqM = new a((byte)0);
    AppMethodBeat.o(282127);
  }
  
  public d()
  {
    AppMethodBeat.i(282120);
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    this.context = localContext;
    AppMethodBeat.o(282120);
  }
  
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(282149);
    s.u(paramString, "path");
    try
    {
      String str = new JSONObject(paramString).optString("scheme");
      if (s.p(str, "text"))
      {
        paramString = (IStickerDecoder)new b(this.context, paramString);
        AppMethodBeat.o(282149);
        return paramString;
      }
      if (s.p(str, "emoji"))
      {
        paramString = (IStickerDecoder)new c(paramString);
        AppMethodBeat.o(282149);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString = (IStickerDecoder)new a();
      AppMethodBeat.o(282149);
    }
    return paramString;
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(282139);
    s.u(paramArrayOfByte, "bytes");
    paramArrayOfByte = (IStickerDecoder)new c("test");
    AppMethodBeat.o(282139);
    return paramArrayOfByte;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/WechatEmojiDecoderFactory$Companion;", "", "()V", "TIMELINE_EDIT_SCHEME", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.d
 * JD-Core Version:    0.7.0.1
 */