package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import java.io.IOException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "()Landroid/graphics/Matrix;", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class e
  extends a
{
  public static final e.a xOz;
  public EmojiInfo gjb;
  Matrix xOy;
  
  static
  {
    AppMethodBeat.i(200666);
    xOz = new e.a((byte)0);
    AppMethodBeat.o(200666);
  }
  
  public e(ja paramja)
  {
    super(d.xNQ);
    AppMethodBeat.i(200665);
    this.xOy = new Matrix();
    try
    {
      Object localObject = (com.tencent.mm.bx.a)new agc();
      paramja = paramja.FCa;
      p.g(paramja, "proto.itemData");
      paramja = paramja.getBuffer();
      p.g(paramja, "proto.itemData.buffer");
      paramja = paramja.getBytes();
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramja);
        paramja = (ja)localObject;
      }
      catch (Exception paramja)
      {
        for (;;)
        {
          dwb localdwb;
          ad.l("safeParser", "", new Object[] { paramja });
          paramja = null;
        }
        AppMethodBeat.o(200665);
        return;
      }
      paramja = (agc)paramja;
      if (paramja != null)
      {
        localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        this.gjb = ((com.tencent.mm.plugin.emoji.b.d)localObject).getProvider().abs(paramja.md5);
        localObject = this.xOy;
        localdwb = paramja.Ged;
        p.g(localdwb, "it.showMatrix");
        ((Matrix)localObject).setValues(a(localdwb));
        localObject = this.gR;
        localdwb = paramja.Gec;
        p.g(localdwb, "it.editorMatrix");
        ((Matrix)localObject).setValues(a(localdwb));
        a(paramja.xPq);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.EmojiItem", toString());
        AppMethodBeat.o(200665);
        return;
      }
      return;
    }
    catch (IOException paramja)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.EmojiItem", (Throwable)paramja, "EmojiItem parse error", new Object[0]);
      AppMethodBeat.o(200665);
    }
  }
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    super(d.xNQ);
    AppMethodBeat.i(200663);
    this.xOy = new Matrix();
    this.gjb = paramEmojiInfo;
    this.xOy.set(paramMatrix1);
    this.gR.set(paramMatrix2);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.EmojiItem", toString());
    AppMethodBeat.o(200663);
  }
  
  public final com.tencent.mm.bx.a dHT()
  {
    AppMethodBeat.i(200661);
    agc localagc = new agc();
    Object localObject = this.gjb;
    String str;
    if (localObject != null)
    {
      str = ((EmojiInfo)localObject).Lb();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    localagc.md5 = ((String)localObject);
    localObject = this.gjb;
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
    localagc.name = ((String)localObject);
    localagc.Gec = f(this.gR);
    localagc.Ged = f(this.xOy);
    localagc.xPq = dHR();
    localObject = (com.tencent.mm.bx.a)localagc;
    AppMethodBeat.o(200661);
    return localObject;
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    AppMethodBeat.i(200662);
    StringBuilder localStringBuilder = new StringBuilder("[").append(hashCode()).append("]md5:");
    Object localObject1 = this.gjb;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).Lb();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" name:");
      EmojiInfo localEmojiInfo = this.gjb;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.getName();
      }
      localObject1 = (String)localObject1;
      AppMethodBeat.o(200662);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.e
 * JD-Core Version:    0.7.0.1
 */