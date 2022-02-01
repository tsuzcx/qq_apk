package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fbn;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "()Landroid/graphics/Matrix;", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class e
  extends a
{
  public static final a Icq;
  Matrix Icp;
  public EmojiInfo jHh;
  
  static
  {
    AppMethodBeat.i(224879);
    Icq = new a((byte)0);
    AppMethodBeat.o(224879);
  }
  
  public e(jc paramjc)
  {
    super(d.IbH);
    AppMethodBeat.i(224877);
    this.Icp = new Matrix();
    try
    {
      Object localObject = (com.tencent.mm.cd.a)new ajj();
      paramjc = paramjc.ROY;
      p.j(paramjc, "proto.itemData");
      paramjc = paramjc.Tkb;
      p.j(paramjc, "proto.itemData.buffer");
      paramjc = paramjc.UH;
      try
      {
        ((com.tencent.mm.cd.a)localObject).parseFrom(paramjc);
        paramjc = (jc)localObject;
      }
      catch (Exception paramjc)
      {
        for (;;)
        {
          fbn localfbn;
          Log.printDebugStack("safeParser", "", new Object[] { paramjc });
          paramjc = null;
        }
        AppMethodBeat.o(224877);
        return;
      }
      paramjc = (ajj)paramjc;
      if (paramjc != null)
      {
        localObject = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        this.jHh = ((com.tencent.mm.plugin.emoji.b.d)localObject).getProvider().aue(paramjc.md5);
        localObject = this.Icp;
        localfbn = paramjc.StP;
        p.j(localfbn, "it.showMatrix");
        ((Matrix)localObject).setValues(a(localfbn));
        localObject = this.aHZ;
        localfbn = paramjc.StO;
        p.j(localfbn, "it.editorMatrix");
        ((Matrix)localObject).setValues(a(localfbn));
        a(paramjc.IcZ);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.EmojiItem", toString());
        AppMethodBeat.o(224877);
        return;
      }
      return;
    }
    catch (IOException paramjc)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.EmojiItem", (Throwable)paramjc, "EmojiItem parse error", new Object[0]);
      AppMethodBeat.o(224877);
    }
  }
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    super(d.IbH);
    AppMethodBeat.i(224864);
    this.Icp = new Matrix();
    this.jHh = paramEmojiInfo;
    this.Icp.set(paramMatrix1);
    this.aHZ.set(paramMatrix2);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.EmojiItem", toString());
    AppMethodBeat.o(224864);
  }
  
  public final com.tencent.mm.cd.a fyG()
  {
    AppMethodBeat.i(224859);
    ajj localajj = new ajj();
    Object localObject = this.jHh;
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
    localajj.md5 = ((String)localObject);
    localObject = this.jHh;
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
    localajj.name = ((String)localObject);
    localajj.StO = f(this.aHZ);
    localajj.StP = f(this.Icp);
    localajj.IcZ = fyE();
    localObject = (com.tencent.mm.cd.a)localajj;
    AppMethodBeat.o(224859);
    return localObject;
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    AppMethodBeat.i(224860);
    StringBuilder localStringBuilder = new StringBuilder("[").append(hashCode()).append("]md5:");
    Object localObject1 = this.jHh;
    if (localObject1 != null) {}
    for (localObject1 = ((EmojiInfo)localObject1).getMd5();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" name:");
      EmojiInfo localEmojiInfo = this.jHh;
      localObject1 = localObject2;
      if (localEmojiInfo != null) {
        localObject1 = localEmojiInfo.getName();
      }
      localObject1 = (String)localObject1;
      AppMethodBeat.o(224860);
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.e
 * JD-Core Version:    0.7.0.1
 */