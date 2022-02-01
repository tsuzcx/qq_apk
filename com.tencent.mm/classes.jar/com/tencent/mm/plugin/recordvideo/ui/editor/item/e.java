package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agl;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import java.io.IOException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "()Landroid/graphics/Matrix;", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class e
  extends a
{
  public static final e.a yes;
  public EmojiInfo glt;
  Matrix yer;
  
  static
  {
    AppMethodBeat.i(206924);
    yes = new e.a((byte)0);
    AppMethodBeat.o(206924);
  }
  
  public e(ja paramja)
  {
    super(d.ydJ);
    AppMethodBeat.i(206923);
    this.yer = new Matrix();
    try
    {
      Object localObject = (com.tencent.mm.bw.a)new agl();
      paramja = paramja.FUv;
      p.g(paramja, "proto.itemData");
      paramja = paramja.getBuffer();
      p.g(paramja, "proto.itemData.buffer");
      paramja = paramja.getBytes();
      try
      {
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramja);
        paramja = (ja)localObject;
      }
      catch (Exception paramja)
      {
        for (;;)
        {
          dww localdww;
          ae.l("safeParser", "", new Object[] { paramja });
          paramja = null;
        }
        AppMethodBeat.o(206923);
        return;
      }
      paramja = (agl)paramja;
      if (paramja != null)
      {
        localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        this.glt = ((com.tencent.mm.plugin.emoji.b.d)localObject).getProvider().acj(paramja.md5);
        localObject = this.yer;
        localdww = paramja.GwK;
        p.g(localdww, "it.showMatrix");
        ((Matrix)localObject).setValues(a(localdww));
        localObject = this.gR;
        localdww = paramja.GwJ;
        p.g(localdww, "it.editorMatrix");
        ((Matrix)localObject).setValues(a(localdww));
        a(paramja.yfj);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.EmojiItem", toString());
        AppMethodBeat.o(206923);
        return;
      }
      return;
    }
    catch (IOException paramja)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.EmojiItem", (Throwable)paramja, "EmojiItem parse error", new Object[0]);
      AppMethodBeat.o(206923);
    }
  }
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    super(d.ydJ);
    AppMethodBeat.i(206921);
    this.yer = new Matrix();
    this.glt = paramEmojiInfo;
    this.yer.set(paramMatrix1);
    this.gR.set(paramMatrix2);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.EmojiItem", toString());
    AppMethodBeat.o(206921);
  }
  
  public final com.tencent.mm.bw.a dLk()
  {
    AppMethodBeat.i(206919);
    agl localagl = new agl();
    Object localObject = this.glt;
    String str;
    if (localObject != null)
    {
      str = ((EmojiInfo)localObject).Lj();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localagl.md5 = ((String)localObject);
    localObject = this.glt;
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
    localagl.name = ((String)localObject);
    localagl.GwJ = f(this.gR);
    localagl.GwK = f(this.yer);
    localagl.yfj = dLi();
    localObject = (com.tencent.mm.bw.a)localagl;
    AppMethodBeat.o(206919);
    return localObject;
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    AppMethodBeat.i(206920);
    StringBuilder localStringBuilder = new StringBuilder("[").append(hashCode()).append("]md5:");
    Object localObject1 = this.glt;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).Lj();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" name:");
      EmojiInfo localEmojiInfo = this.glt;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.getName();
      }
      localObject1 = (String)localObject1;
      AppMethodBeat.o(206920);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.e
 * JD-Core Version:    0.7.0.1
 */