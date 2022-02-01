package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "()Landroid/graphics/Matrix;", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class e
  extends a
{
  public static final e.a Cfu;
  Matrix Cft;
  public EmojiInfo gWm;
  
  static
  {
    AppMethodBeat.i(237765);
    Cfu = new e.a((byte)0);
    AppMethodBeat.o(237765);
  }
  
  public e(jn paramjn)
  {
    super(d.CeL);
    AppMethodBeat.i(237764);
    this.Cft = new Matrix();
    try
    {
      Object localObject = (com.tencent.mm.bw.a)new aiu();
      paramjn = paramjn.KOd;
      p.g(paramjn, "proto.itemData");
      paramjn = paramjn.getBuffer();
      p.g(paramjn, "proto.itemData.buffer");
      paramjn = paramjn.zy;
      try
      {
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramjn);
        paramjn = (jn)localObject;
      }
      catch (Exception paramjn)
      {
        for (;;)
        {
          erc localerc;
          Log.printDebugStack("safeParser", "", new Object[] { paramjn });
          paramjn = null;
        }
        AppMethodBeat.o(237764);
        return;
      }
      paramjn = (aiu)paramjn;
      if (paramjn != null)
      {
        localObject = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        this.gWm = ((com.tencent.mm.plugin.emoji.b.d)localObject).getProvider().amm(paramjn.md5);
        localObject = this.Cft;
        localerc = paramjn.Lsq;
        p.g(localerc, "it.showMatrix");
        ((Matrix)localObject).setValues(a(localerc));
        localObject = this.gT;
        localerc = paramjn.Lsp;
        p.g(localerc, "it.editorMatrix");
        ((Matrix)localObject).setValues(a(localerc));
        a(paramjn.Cgj);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.EmojiItem", toString());
        AppMethodBeat.o(237764);
        return;
      }
      return;
    }
    catch (IOException paramjn)
    {
      com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.EmojiItem", (Throwable)paramjn, "EmojiItem parse error", new Object[0]);
      AppMethodBeat.o(237764);
    }
  }
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    super(d.CeL);
    AppMethodBeat.i(237762);
    this.Cft = new Matrix();
    this.gWm = paramEmojiInfo;
    this.Cft.set(paramMatrix1);
    this.gT.set(paramMatrix2);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.EmojiItem", toString());
    AppMethodBeat.o(237762);
  }
  
  public final com.tencent.mm.bw.a eMk()
  {
    AppMethodBeat.i(237760);
    aiu localaiu = new aiu();
    Object localObject = this.gWm;
    String str;
    if (localObject != null)
    {
      str = ((EmojiInfo)localObject).getMd5();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localaiu.md5 = ((String)localObject);
    localObject = this.gWm;
    if (localObject != null)
    {
      str = ((EmojiInfo)localObject).getName();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localaiu.name = ((String)localObject);
    localaiu.Lsp = f(this.gT);
    localaiu.Lsq = f(this.Cft);
    localaiu.Cgj = eMi();
    localObject = (com.tencent.mm.bw.a)localaiu;
    AppMethodBeat.o(237760);
    return localObject;
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    AppMethodBeat.i(237761);
    StringBuilder localStringBuilder = new StringBuilder("[").append(hashCode()).append("]md5:");
    Object localObject1 = this.gWm;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).getMd5();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" name:");
      EmojiInfo localEmojiInfo = this.gWm;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.getName();
      }
      localObject1 = (String)localObject1;
      AppMethodBeat.o(237761);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.e
 * JD-Core Version:    0.7.0.1
 */